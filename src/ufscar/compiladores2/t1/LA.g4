grammar LA;

// Declaração de variáveis que serão utilizadas neste arquivo
@members {
    static String grupo = "<488950, 489085, 489093, 489182>";
    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    private final String GLOBAL = "global";
    private final int VARIAVEL = 1;
    private final int CONSTANTE = 2;
    private final int TIPO = 3;
    private final int PARCELA_UNARIO = 1;
    private final int PARCELA_NAO_UNARIO = 2;
    private final int LEIA = 1, ESCREVA = 2, SE = 3, CASO = 4, PARA = 5, ENQUANTO = 6, FACA = 7, PONTEIRO = 8,
            CHAMADA = 9, ATRIBUICAO = 10, RETORNE = 11;

    private void stop(String msg) {
        throw new ParseCancellationException(msg);
    }
}

/*********************************************************************************************************
 REGRAS SINTÁTICAS
 *********************************************************************************************************/

// Regra para identificadores (números, letras e underscores, não podendo começar com números)
IDENT:
    ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;

// Regra para números inteiros
NUM_INT:
    ('0'..'9')+;

// Regra para números reais, sendo o ponto o caracter de separação decimal
NUM_REAL:
    ('0'..'9')+ '.' ('0'..'9')+;

// Regra para cadeias (strings): qualquer combinação de caracteres, entre aspas, com exceção dos caracteres \n
// (new line) e \r (retorno)
CADEIA:
    '"' ~('\n' | '\r' | '"')* '"';

// Regra para comentários: qualquer combinação de caracteres, entre chaves
COMENTARIO:
    '{' ~('}'|'\n')* '}' {
        skip();
    }
;

// Regra para ignorar espaços, tabulações e quebras de linha
ESPACO:
    (' ' |'\t' | '\r' | '\n') {
        skip();
    }
;


/*********************************************************************************************************
 Regras para detecção de erros sintáticos com identificadores, comentários e de símbolos não identificados
 *********************************************************************************************************/

IDENT_ERRADO:
    '[' IDENT ')' {
        stop("Linha " + getLine() + ": erro sintatico proximo a )");
    }
;

// Regra para reportar erro em variável string ou numérica
NUM_ERRADO:
    ('0'..'9')+ ('a'..'z' | 'A'..'Z' | '_')+ {
        String variavel = getText().replaceAll("[0-9]", "");
        stop("Linha " + getLine() + ": erro sintatico proximo a " + variavel);
    }
;

// Regra oara reportar erro de comentario mal declarado
COMENTARIO_ERRADO:
    '{' ~('\n'|'}')* '\n' {
        stop("Linha " + getLine() + ": comentario nao fechado");
    }
;

// Regra geral para reportar simbolos não identificados no código
ERROR:
    . {
        stop("Linha " + getLine() + ": " + getText() + " - simbolo nao identificado");
    }
;

/*********************************************************************************************************
 REGRAS SEMÂNTICAS
 *********************************************************************************************************/

// Regra que inicia o programa. Note que neste momento, criamos uma tabela de símbolos de escobo global.
programa
    :
    { pilhaDeTabelas.empilhar(new TabelaDeSimbolos(GLOBAL)); }
    declaracoes 'algoritmo' corpo 'fim_algoritmo'
;


// Regra que define declarações. Declarações são um conjunto de uma ou mais declarações locais ou globais.
declaracoes:
    (decl_local_global)*;


// Regra que permite a "escolha" do tipo de declaração: local ou global
decl_local_global
    :
    declaracao_local |
    declaracao_global
;


// Regra em que declarações locais acontecem. São possíveis três tipos de declarações locais:
// variáveis, constantes e tipos (definição de tipos, equivalente a typedef struct em C).
// Constantes e tipos são adicionados no topo tabela de símbolos já nesta regra. Variáveis,
// por outro lado, são adicionadas na tabela de símbolos na regra "variavel", pois na linguagem LA
// é possível declarar mais de uma variável do mesmo tipo na mesma "linha de declaração".
declaracao_local returns [int tipo_declaracao, String name, String tipo_variavel]
    :
    'declare' variavel {
        $tipo_declaracao = VARIAVEL;
        $name = $variavel.name;
        $tipo_variavel = $variavel.tipo_variavel;
    } |
    'constante' IDENT ':' tipo_basico '=' valor_constante {
        $tipo_declaracao = CONSTANTE;
        pilhaDeTabelas.topo().adicionarSimbolo($IDENT.text, $tipo_basico.tipodado, "constante");
    } |
    'tipo' IDENT ':' tipo {
        $tipo_declaracao = TIPO;
        pilhaDeTabelas.adicionarTipo($IDENT.text, $tipo.atributos);
        pilhaDeTabelas.topo().adicionarSimbolo($IDENT.text, "novotipo", "tipo");
    }
;


// Regra para declaração de variáveis. Como várias variáveis de um mesmo tipo (variáveis que são declaradas na mesma
// linha na linguagem LA, separadas por vírgula) podem existir, fazemos uma lista de pares (com a estrutura Pair do
// ANTLR) para armazenar essas variáveis.
// A estrutura Pair do ANTLR tem dois parâmetros, "a" e "b". Estes serão utilizados para guardar o nome da variável e
// a linha em que a variável é declarada.
// A lista de Pairs receberá o retorno da regra "mais_var", e adicionará cada uma das variáveis da lista na tabela de
// símbolos desde que estas ainda não tenham sido declaradas anteriormente no mesmo escopo. Caso as variáveis já existam
// um erro semântico será registrado através de um atributo estático da classe ErrosSemanticos.
// Mais detalhes sobre a classe Pair em http://www.antlr.org/api/Java/org/antlr/v4/runtime/misc/Pair.html
variavel returns [String name, String tipo_variavel]
    :
    IDENT dimensao mais_var ':' tipo {
        $name = $IDENT.text;
        $tipo_variavel = $tipo.tipodado;
        pilhaDeTabelas.verificaVariavelJaExistente(new Pair($IDENT.text, $IDENT.line), $mais_var.nomes, $tipo_variavel);
    }
;


// Regra que complementa a regra anterior ("variavel"), permitindo que mais variáveis do mesmo tipo sejam declaradas
// em uma única linha na linguagem LA. Cada variável "encontrada" é adicionada a uma lista que será retornada para a
// regra "variavel". A lista guarda informação do nome da variável e da linha em que a mesma é declarada (pois essa
// informação é necessária para reportar erros semânticos.
// Se não houver nenhuma variável adicional, a lista retornada é vazia, permitindo fácil verificação
// na geração de código.
mais_var returns [List<Pair> nomes]
    @init {
        $nomes = new ArrayList<Pair>();
    }
    :
    (
        ',' IDENT dimensao {
            Pair variavel = new Pair($IDENT.text, $IDENT.line);
            $nomes.add(variavel);
        }
    )*
;


// Regra que define identificadores para uso das variáveis declaradas anteriormente. A checagem semântica é realizada
// verificando se o nome do identificador existe na tabela de símbolos. Esta regra permite identificadores serem
// referenciados com ponteiros, com índices (para o caso de vetores) e com mais identificadores (para acesso a atributos
// de registros. Note que para registros, é necessário checar tanto se a variável em si existe, bem como o atributo
// desta variável (formando assim o identificador completo).
identificador returns [String nome_variavel]
    :
    ponteiros_opcionais IDENT dimensao outros_ident {
        $nome_variavel = $IDENT.text;
        pilhaDeTabelas.verificaVariavelNaoExistente($IDENT.text, $outros_ident.nome_atributo, $outros_ident.id, $IDENT.line);
    }
;

// Regra para tratatamento dos ponteiros, que são opcionais para identificadores.
// O único retorno é a quantidade de ponteiros a serem adicionados antes do identificador.
ponteiros_opcionais returns [String ponteiros, int linha]
    @init {
        $ponteiros = "";
    }
    :
    ('^' { $ponteiros += "^"; })*
;

// Regra que permite definir identificadores compostos, com o uso do ponto ".".
outros_ident returns [String id, String nome_atributo, boolean atributo]
    @init {
        $id = "";
        $nome_atributo = "";
    }
    :
    (
        '.' ponteiros_opcionais IDENT dimensao {
            $id += "." + $IDENT.text;
            $nome_atributo = $IDENT.text;
            $atributo = true;
        }
    )*
;


// Regra que "calcula" a dimensão de uma variável, pois esta pode ser uma expressão aritmética. Essa dimensão é
// utilizada como índice para acesso a uma posição específica de um vetor
dimensao returns [int indice]
    @init {
        $indice = -1;
    }
    : ('[' exp_aritmetica { $indice = $exp_aritmetica.indice; }']')*
;


// Regra que trata registros e ponteiros (tipo_estendido)
tipo returns [String tipodado, List<Pair> atributos]
    :
    registro {
        $tipodado = "registro";
        $atributos = $registro.atributos;
        pilhaDeTabelas.adicionarTipo("registro", $atributos);
    } |
    tipo_estendido {
        $tipodado = $tipo_estendido.tipodado;
    }
;

//mais_ident permite criar um ou mais "identificador" separados por ','
mais_ident:
    (',' identificador)*;


//Define as palavres reservadas para um tipo basico
tipo_basico returns [String tipodado]
    :
    'inteiro' {
        $tipodado = "inteiro";
    } |
    'real' {
        $tipodado = "real";
    } |
    'literal' {
        $tipodado = "literal";
    } |
    'logico' {
        $tipodado = "logico";
    }
;

//Define um tipo basico ou um identificador e verifica a existencia do tipo que está sendo definido
tipo_basico_ident returns [String tipodado]
    :
    tipo_basico {
        $tipodado = $tipo_basico.tipodado;
    } |
    IDENT {
        $tipodado = $IDENT.text;
        if (!pilhaDeTabelas.existeTipo($IDENT.text)) {
            ErrosSemanticos.erroTipoNaoExiste($IDENT.text, $IDENT.line);
        }
    }
;

//tipo estendido é um ponteiro seguido de um identificador de tipo básico
tipo_estendido returns [String tipodado]
    :
    ponteiros_opcionais tipo_basico_ident {
        $tipodado = $tipo_basico_ident.tipodado + $ponteiros_opcionais.ponteiros;
    }
;

valor_constante
    :
    CADEIA |
    NUM_INT |
    NUM_REAL |
    'verdadeiro' |
    'falso'
    ;

//Regra que define o formato de um registro, tendo a forma "registro" seguido de uma ou mais variáveis
registro returns [List<Pair> atributos]
    @init {
        $atributos = new ArrayList<Pair>();
    }
    :
    'registro'
    (
        variavel_registro {
            $atributos.addAll($variavel_registro.atributos);
        }
    )+
    'fim_registro'
;


variavel_registro returns [List<Pair> atributos]
    @init {
        $atributos = new ArrayList<Pair>();
    }
    :
    IDENT dimensao mais_var_registro ':' tipo {
        $atributos.add(new Pair($IDENT.text, $tipo.tipodado));
        for (String atributo : $mais_var_registro.atributos) {
            $atributos.add(new Pair(atributo, $tipo.tipodado));
        }
    }
;

mais_var_registro returns [List<String> atributos]
    @init {
        $atributos = new ArrayList<String>();
    }
    :
    (
        ',' IDENT dimensao {
            $atributos.add($IDENT.text);
        }
    )*
;


//Regra que define declaração_global sendo composta por "procedimento nome_procedimento (parametros)" seguido de
//declarações e comandos terminados pela palavra reservada "fim_procedimento" ou
//composta por "funcao nome_funcao (parametros) :" seguido de um tipo estendido,
//declarações e comandos sendo terminados por "fim_funcao"
declaracao_global
    :
    'procedimento' IDENT {
        pilhaDeTabelas.topo().adicionarSimbolo($IDENT.text, "void", "procedimento");
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento_" + $IDENT.text));
        pilhaDeTabelas.adicionarFuncaoOuProcedimento($IDENT.text);
    } '(' parametros_opcional ')' declaracoes_locais comandos 'fim_procedimento' {
        pilhaDeTabelas.desempilhar();
    } |
    'funcao' IDENT {
        pilhaDeTabelas.adicionarFuncaoOuProcedimento($IDENT.text);
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao_" + $IDENT.text));
    } '(' parametros_opcional ')' ':' tipo_estendido {
        pilhaDeTabelas.tabelaGlobal().adicionarSimbolo($IDENT.text, $tipo_estendido.tipodado, "funcao");
    } declaracoes_locais comandos 'fim_funcao' {
        pilhaDeTabelas.desempilhar();
    }
;


parametros_opcional:
    parametro |
;

//Regra que define que parametro deve possuir uma variavel, um ou mais indentificadores
//e um tipo_estendido seguido dos parametros. Chama a classe funcoes para adicionar um tipodado na tabela de símbolos.
parametro:
    var_opcional ident_param mais_id_param ':' tipo_estendido {
        pilhaDeTabelas.topo().adicionarSimbolo($ident_param.param, $tipo_estendido.tipodado, "parametro");
        pilhaDeTabelas.topo_funcoes().add($tipo_estendido.tipodado);
    }
    mais_parametros
;


ident_param returns [String param]:
    ponteiros_opcionais
    IDENT {
        $param = $IDENT.text;
    }
    dimensao
    outros_ident
;


mais_id_param:
    (',' ident_param)*
;


var_opcional:
    'var' |
;

mais_parametros:
    ',' parametro |
;


declaracoes_locais:
    declaracao_local*;

corpo:
    declaracoes_locais comandos;

//Regra que define que os commandos devem ter ao menos uma instrução
comandos:
    cmd*;


//Regra principal de definição de instruções da linguagem LA
//Realiza verificações de formato e contexto para realizar as atribuições,
// retornando os erros devidos quando existirem falhas
cmd returns [int tipo_comando, String nome_variavel,  String tipo_variavel]
    @id {
        $nome_variavel = "";
        $tipo_variavel = "";
    }
    : 'leia' '(' identificador mais_ident ')' {
        $tipo_comando = LEIA;
        $nome_variavel = $identificador.nome_variavel;
        $tipo_variavel = pilhaDeTabelas.getTipoDoSimbolo($identificador.nome_variavel);
    } |
    'escreva' '(' expressao mais_expressao ')' {
        $tipo_comando = ESCREVA;
        $nome_variavel = $expressao.name;
        $tipo_variavel = $expressao.type;
    } |
    'se' expressao 'entao' comandos senao_opcional 'fim_se' {
        $tipo_comando = SE;
    } |
    'caso' exp_aritmetica 'seja' selecao senao_opcional 'fim_caso' {
        $tipo_comando = CASO;
    } |
    'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' comandos 'fim_para' {
        $tipo_comando = PARA;
        $nome_variavel = $IDENT.text;
    } |
    'enquanto' expressao 'faca' comandos 'fim_enquanto' {
        $tipo_comando = ENQUANTO;
    } |
    'faca' comandos 'ate' expressao {
        $tipo_comando = FACA;
    } |
    '^' IDENT dimensao outros_ident '<-' expressao {
        $tipo_comando = PONTEIRO;
        pilhaDeTabelas.verificaAtribuicaoDePonteiro($IDENT.text, $IDENT.line, $expressao.type);
    } |
    IDENT chamada {
        $tipo_comando = CHAMADA;
    } |
    IDENT atribuicao {
        $tipo_comando = ATRIBUICAO;
        pilhaDeTabelas.verificaCompatibilidadeDeAtribuicao($atribuicao.compativel, $atribuicao.type, $IDENT.text,
            $atribuicao.name, $atribuicao.indice, $IDENT.line);
    } |
    retorne = 'retorne' expressao {
        $tipo_comando = RETORNE;
        if (!pilhaDeTabelas.topo().getType().equals("funcao")) {
            ErrosSemanticos.escopoNaoPermitido($retorne.line);
        }
    }
;

//Permite que exista mais de uma expressão
mais_expressao returns [List<String> tipos]
    @init {
        $tipos = new ArrayList<String>();
    }
    :
    (
        ',' expressao {
            $tipos.add($expressao.type);
        }
    )*
;


senao_opcional:
    'senao' comandos |
;

//chamada de atribuição pode ser composta por argumentos opcionais entre parenteses ou por um ou mais identificadores
// podendo ou não serem mais dimensões seguidos de "<-" expressão
chamada:
    '(' argumentos_opcional ')'
;

//Regra para definir atribuição, setando valores das variaveis compatíveis (String, indice e name) que
// são retornadas para a funcão cmd.
atribuicao returns [boolean compativel, String type, int indice, String name]
    @init {
        $type = "";
        $name = "";
    }
    :
    outros_ident dimensao '<-' expressao {
        $type = $expressao.type;
        $indice = $dimensao.indice;

        if ($outros_ident.nome_atributo.compareTo("") == 0) {
            $name = ($expressao.atributo && $expressao.name.compareTo("") != 0) ? $expressao.name : $name;
            $compativel = ($expressao.name.compareTo("") == 0) ? $expressao.compativel : false;
            $type = ($expressao.name.compareTo("") == 0) ? $expressao.type : $type;
        } else {
            $name = $outros_ident.nome_atributo;
        }
    }
;


argumentos_opcional:
    expressao mais_expressao |
;

selecao:
    constantes ':' comandos mais_selecao;

mais_selecao:
    selecao |
;

constantes:
    numero_intervalo mais_constantes;

mais_constantes:
    ',' constantes |
;

numero_intervalo:
    op_unario NUM_INT intervalo_opcional;

intervalo_opcional:
    '..' op_unario NUM_INT |
;

op_unario:
    '-' |
;

//Expressẽos aritiméticas são compostas por um ou mais termos separados por virgulas
exp_aritmetica returns [boolean compativel, String type, int indice, String name, boolean atributo]
    @init {
        $type = "";
        $name = "";
    }
    :
    termo outros_termos {
        $name = $termo.name;
        $atributo = $termo.atributo;

        if (!$outros_termos.type.equals("") && !$termo.type.equals($outros_termos.type)) {
            $type = $outros_termos.type;
            $indice = $termo.indice;
        } else {
            $type = $termo.type;
        }
    }
;


op_multiplicacao:
    '*' |
    '/'
;

op_adicao:
    '+' |
    '-'
;

//Termo é composto por um ou mais fatores separados por virgula
termo returns [String type, int indice, String name, boolean atributo]
    @init {
        $name = "";
    }
    :
    fator outros_fatores {
        $type = $fator.type;
        $indice = $fator.indice;
        $name = $fator.name;
        $atributo = $fator.atributo;
    }
;


//outros termos é composto por uma operação de soma ou subtração seguida de um ou mais termos
outros_termos returns [String type]
    @init {
        $type = "";
    }
    :
    (
        op_adicao termo {
            $type = $termo.type;
        }
    )*
;

//Fator é composto por uma composição de parcelas
fator returns [String type, int indice, String name, boolean atributo]
    @init {
        $name = "";
    }
    :
    parcela outras_parcelas {
        $type = $parcela.type;
        $indice = $parcela.indice;
        $name = $parcela.name;
        $atributo = $parcela.atributo;
    }
;


//outros fatores é composto por operações de multiplicação ou divisão e um ou mais fatores separados
outros_fatores:
    (op_multiplicacao fator)*;

parcela returns [String type, int indice, String name, int tipo_parcela, boolean atributo]
    @init {
        $name = "";
    }
    :
    op_unario parcela_unario {
        $tipo_parcela = PARCELA_UNARIO;
        $type = $parcela_unario.type;
        $indice = $parcela_unario.indice;
        $name = $parcela_unario.name;
        $atributo = $parcela_unario.atributo;
    } |
    parcela_nao_unario {
        $tipo_parcela = PARCELA_NAO_UNARIO;
        $type = $parcela_nao_unario.type;
    }
;


//parcela_unario é composta de um ponteiro seguido de um identificador que pode ou não ter dimensão ou um identificador
//seguido de uma chamada ou uma expressão entre parênteses ou até um número que pode ser inteiro ou real
//o retorno de chamada_partes é usado para as verificações e em caso de algum problema retorna o erro devido.
parcela_unario returns [String type, int indice, String name, String tipo_parcela_unario, boolean atributo]
    @init {
        $type = "";
        $indice = -1;
        $name = "";
    }
    :
    '^' IDENT outros_ident dimensao {
        $tipo_parcela_unario = "PONTEIRO";
        $type = pilhaDeTabelas.getTipoDoSimbolo($IDENT.text);
    } |
    IDENT chamada_partes {
        $tipo_parcela_unario = "CHAMADA";

        if (!pilhaDeTabelas.existeSimbolo($IDENT.text)) {
            ErrosSemanticos.erroVariavelNaoExiste($IDENT.text+$chamada_partes.id, $IDENT.line);
        }

        $type = pilhaDeTabelas.getTipoDoSimbolo($IDENT.text);
        pilhaDeTabelas.verificaCompatibilidadeDeParametros($chamada_partes.tipos, $IDENT.text, $IDENT.line);
        $name = $chamada_partes.name;;
        $atributo = $chamada_partes.atributo;
    } |
    NUM_INT {
        $tipo_parcela_unario = "INTEIRO";
        $type = "inteiro";
        $indice = Integer.parseInt($NUM_INT.text);
        $name = $NUM_INT.text;
    } |
    NUM_REAL {
        $tipo_parcela_unario = "REAL";
        $type = "real";
        $name = $NUM_REAL.text;
    } |
    '(' expressao ')' {
        $tipo_parcela_unario = "EXPRESSAO";
    }
;

// Define a parcela não unaria com a composição usando o operador "E"
parcela_nao_unario returns [String type, String name]
    @init {
        $name = "";
    }
    :
    '&' IDENT outros_ident dimensao {
        $type = "";
        $name = $outros_ident.nome_atributo;
    } |
    CADEIA {
        $type = "literal";
        $name = $CADEIA.text;
    }
;

//Outras parcelas é composto pela operação modulo seguida de uma ou mais parcelas.
outras_parcelas:
    ('%' parcela)*;


chamada_partes returns [String id, List<String> tipos, String name, int tipoChamada, boolean atributo]
    @init {
        $id = "";
        $tipos = new ArrayList<String>();
        $name = "";
    }
    :
    '(' expressao mais_expressao {
        $tipos = $mais_expressao.tipos;
        $tipos.add($expressao.type);
        $tipoChamada = 1;
    }
    ')' |
    outros_ident dimensao {
        $id = $outros_ident.id;
        $name = $outros_ident.nome_atributo;
        $atributo = $outros_ident.atributo;
        $tipoChamada = 2;
    } |
    { $tipoChamada = 3; }
;


//Expressão relacional é composta por uma expressão aritimética seguida de zero ou mais operadores opcionais
exp_relacional returns [boolean compativel, String type, String name, boolean atributo]
    @init {
        $name = "";
    }
    :
    exp_aritmetica op_opcional {
        $name = $exp_aritmetica.name;
        $atributo = $exp_aritmetica.atributo;

        if ($op_opcional.type.equals("")) {
            $compativel = $exp_aritmetica.compativel;
            $type = $exp_aritmetica.type;
        } else {
            $compativel = true;
            $type = $op_opcional.type;
        }
    }
;

// Operador opcional
op_opcional returns [String type, boolean compativel]
    @init {
        $type = "";
        $compativel = true;
    }
    :
    op_relacional exp_aritmetica {
        $type = "logico";
    } |
;

//Expressões relacionais
op_relacional:
    '=' |
    '<>' |
    '>=' |
    '<=' |
    '>' |
    '<'
    ;

//Expressão é composta por um termo lógico seguido por um ou vários termos lógicos
expressao returns [boolean compativel, String type, String name, boolean atributo]
    @init {
        $name = "";
    }
    :
    termo_logico outros_termos_logicos {
        $compativel = $termo_logico.compativel;
        $type = $termo_logico.type;
        $name = $termo_logico.name;
        $atributo = $termo_logico.atributo;
    }
;

op_nao:
    'nao' |
 ;

//Um termo lógico é composto por um ou mais fatores lógicos
termo_logico returns [boolean compativel, String type, String name, boolean atributo]
    @init {
        $name = "";
    }
    :
    fator_logico outros_fatores_logicos {
        $compativel = $fator_logico.compativel;
        $type = $fator_logico.type;
        $name = $fator_logico.name;
        $atributo = $fator_logico.atributo;
    }
;

// Agrupamento de fatores lógicos com "OU"
outros_termos_logicos:
    'ou' termo_logico outros_termos_logicos |
;
// Agrupamento de fatores lógicos com "E"
outros_fatores_logicos:
    'e' fator_logico outros_fatores_logicos |
;

//fator_logico é uma parecela lógica, negada ou não (pos op_nao leva à vazio)
fator_logico returns [boolean compativel, String type, String name, boolean atributo]
    :
    op_nao parcela_logica {
        $compativel = $parcela_logica.compativel;
        $type = $parcela_logica.tipo_parcela_logica;
        $name = $parcela_logica.name;
        $atributo = $parcela_logica.atributo;
    }
;


//Parcela_logica que é verdadeira, falsa ou uma expressão relacional
parcela_logica returns [String tipo_parcela_logica, String name, boolean compativel, boolean atributo]
    @init {
        $name = "";
    }
    :
    'verdadeiro' {
        $tipo_parcela_logica = "verdadeiro";
    } |
    'falso' {
        $tipo_parcela_logica = "falso";
    } |
    exp_relacional {
        $tipo_parcela_logica = $exp_relacional.type;
        $compativel = $exp_relacional.compativel;
        $name = $exp_relacional.name;
        $atributo = $exp_relacional.atributo;
    }
;