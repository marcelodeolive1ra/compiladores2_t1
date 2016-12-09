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
    private final int CHAMADA_EXPRESSAO = 1, CHAMADA_IDENTIFICADOR = 2, CHAMADA_VAZIA = 3;

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
    declaracoes 'algoritmo' corpo 'fim_algoritmo' EOF
;


// Regra que define declarações. Declarações são um conjunto de uma ou mais declarações locais ou globais.
declaracoes:
    (decl_local_global)*;


// Regra que permite a "escolha" do tipo de declaração: local ou global
decl_local_global
    :
    declaracao_local  |
    declaracao_global
;


// Regra em que declarações locais acontecem. São possíveis três tipos de declarações locais:
// variáveis, constantes e tipos (definição de tipos, equivalente a typedef struct em C).
// Constantes e tipos são adicionados no topo tabela de símbolos já nesta regra. Variáveis,
// por outro lado, são adicionadas na tabela de símbolos na regra "variavel", pois na linguagem LA
// é possível declarar mais de uma variável do mesmo tipo na mesma "linha de declaração".
declaracao_local returns [int tipo_declaracao, String nome, String tipo_variavel]
    :
    'declare' variavel {
        $tipo_declaracao = VARIAVEL;
        $nome = $variavel.nome;
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
variavel returns [String nome, String tipo_variavel]
    :
    IDENT dimensao mais_var ':' tipo {
        $nome = $IDENT.text;
        $tipo_variavel = $tipo.tipodado;
        pilhaDeTabelas.verificaVariavelExistente(new Pair($IDENT.text, $IDENT.line), $mais_var.nomes, $tipo_variavel);
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
        pilhaDeTabelas.verificaVariavelInexistente($IDENT.text, $outros_ident.nome_atributo, $outros_ident.id, $IDENT.line);
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


// Regra que permite declarar mais de um identificador do mesmo tipo na mesma linha, separados por vírgula
mais_ident:
    (',' identificador)*;


// Regra que define os tipos básicos da linguagem LA
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


// Regra que define o identificador do tipo de dado, verificando se o mesmo existe no escopo apropriado
tipo_basico_ident returns [String tipodado]
    :
    tipo_basico {
        $tipodado = $tipo_basico.tipodado;
    } |
    IDENT {
        $tipodado = $IDENT.text;
        if (!pilhaDeTabelas.existeTipo($IDENT.text)) {
            ErrosSemanticos.tipoInexistente($IDENT.text, $IDENT.line);
        }
    }
;


// Regra que define um tipo estendido, que é um ponteiro seguido de um identificador de tipo básico
tipo_estendido returns [String tipodado]
    :
    ponteiros_opcionais tipo_basico_ident {
        $tipodado = $tipo_basico_ident.tipodado + $ponteiros_opcionais.ponteiros;
    }
;


// Regra que define valores constantes
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
            for (Pair atributo: $variavel_registro.atributos) {
                $atributos.add(atributo);
            }
        }
    )+
    'fim_registro'
;


// Regra que define os atributos de um registro (guarda todas as variáveis definidas dentro do registro)
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


// Regra que permite que sejam adicionados mais atributos a um registro
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


// Regra que define declarações globais, podendo estas serem procedimentos ou funções, ambas permitindo parâmetros
// formais, que terão uma nova tabela de símbolos para cuidar do escopo das variáveis adequadamente.
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


// Esta regra permite a adição opcional de parâmetros formais a funções ou procedimentos
parametros_opcional:
    parametro |
;


// Regra que define a estrutura de funções, com seu tipo de retorno e parâmetros formais
parametro:
    var_opcional ident_param mais_id_param ':' tipo_estendido {
        pilhaDeTabelas.topo().adicionarSimbolo($ident_param.nome_parametro, $tipo_estendido.tipodado, "parametro");
        pilhaDeTabelas.topo_funcoes().add($tipo_estendido.tipodado);
    }
    mais_parametros
;


// Regra que define um parâmetro em específico, considerando a possibilidade do mesmo ter ponteiros, dimensão e até
// mesmo identificadores adicionais (formando assim um identificador composto)
ident_param returns [String nome_parametro]:
    ponteiros_opcionais
    IDENT {
        $nome_parametro = $IDENT.text;
    }
    dimensao
    outros_ident
;


// Regra que permite a adição de mais parâmetros a uma função ou procedimento, sendo os parâmetros separados por vírgula
mais_id_param:
    (',' ident_param)*
;


// Regra que permite a passagem de parâmetros por referência
var_opcional:
    'var' |
;


// Regra auxiliar para adição de mais parâmetros em um procedimento ou função
mais_parametros:
    ',' parametro |
;


// Regra para definição de declarações locais (variáveis)
declaracoes_locais:
    declaracao_local*;


// Regra que define o corpo do programa, sendo este composto por uma série de declarações locais seguidas de comandos
corpo:
    declaracoes_locais comandos;


// Regra que define comandos individuais do corpo do programa
comandos:
    cmd*;


// Regra que define os comandos, fazendo as devidas verificações semânticas, quando necessário
cmd returns [int tipo_comando, String nome_variavel,  String tipo_variavel]
    @id {
        $nome_variavel = "";
        $tipo_variavel = "";
    }
    :
    'leia' '(' identificador mais_ident ')' {
        $tipo_comando = LEIA;
        $nome_variavel = $identificador.nome_variavel;
        $tipo_variavel = pilhaDeTabelas.getTipoDoSimbolo($identificador.nome_variavel);
    } |
    'escreva' '(' expressao mais_expressao ')' {
        $tipo_comando = ESCREVA;
        $nome_variavel = $expressao.nome;
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
            $atribuicao.nome, $atribuicao.indice, $IDENT.line);
    } |
    retorne = 'retorne' expressao {
        $tipo_comando = RETORNE;
        if (!pilhaDeTabelas.topo().getType().equals("funcao")) {
            ErrosSemanticos.escopoInvalido($retorne.line);
        }
    }
;

// Regra que permite a adição de mais expressões a uma expressão
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


// Regra que define o caso SENAO do comando SE
senao_opcional:
    'senao' comandos |
;


// Regra que define chamadas de funções ou procedimentos, incluindo os argumentos para os parâmetros formais,
// quando existerem
chamada:
    '(' argumentos_opcional ')'
;


// Regra que permite a atribuição de variáveis, fazendo as devidas checagens de compatibilidade de tipo, quando
// necessário
atribuicao returns [boolean compativel, String type, int indice, String nome]
    @init {
        $type = "";
        $nome = "";
    }
    :
    outros_ident dimensao '<-' expressao {
        $type = $expressao.type;
        $indice = $dimensao.indice;

        if ($outros_ident.nome_atributo.compareTo("") == 0) {
            $nome = ($expressao.atributo && $expressao.nome.compareTo("") != 0) ? $expressao.nome : $nome;
            $compativel = ($expressao.nome.compareTo("") == 0) ? $expressao.compativel : false;
            $type = ($expressao.nome.compareTo("") == 0) ? $expressao.type : $type;
        } else {
            $nome = $outros_ident.nome_atributo;
        }
    }
;


// Regra que define argumentos opcionais como sendo uma ou mais expressões
argumentos_opcional:
    expressao mais_expressao |
;


// Regra que define um CASO do comando ESCOLHA
selecao:
    constantes ':' comandos mais_selecao;


// Regra que permite a adição de mais CASOS ao comando ESCOLHA
mais_selecao:
    selecao |
;


// Regra que define constantes
constantes:
    numero_intervalo mais_constantes;


// Regra que permite mais constantes em uma mesma linha, separadas por vírgula
mais_constantes:
    ',' constantes |
;

// Regra que define intervalos, para a estrutura CASO do comando ESCOLHA
numero_intervalo:
    op_unario NUM_INT intervalo_opcional;


// Regra que define um intervalo opcional para a estrutura CASO
intervalo_opcional:
    '..' op_unario NUM_INT |
;

// Regra que define o operador unário de negativo
op_unario:
    '-' |
;


// Regra que define expressões aritméticas
exp_aritmetica returns [boolean compativel, String type, int indice, String nome, boolean atributo]
    @init {
        $type = "";
        $nome = "";
    }
    :
    termo outros_termos {
        $nome = $termo.nome;
        $atributo = $termo.atributo;

        if (!$outros_termos.type.equals("") && !$termo.type.equals($outros_termos.type)) {
            $type = $outros_termos.type;
            $indice = $termo.indice;
        } else {
            $type = $termo.type;
        }
    }
;


// Regra que define operadores aritméticos com a mesma ordem de precedência da multiplicação
op_multiplicacao:
    '*' |
    '/'
;


// Regra que define operadores aritméticos com a mesma ordem de precedência da adição
op_adicao:
    '+' |
    '-'
;


// Regra que define termos, que são parte de expressões aritméticas
termo returns [String type, int indice, String nome, boolean atributo]
    @init {
        $nome = "";
    }
    :
    fator outros_fatores {
        $type = $fator.type;
        $indice = $fator.indice;
        $nome = $fator.nome;
        $atributo = $fator.atributo;
    }
;


// Regra que permite eventuais mais termos em uma expressão aritmética
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


// Regra que define fatores, que são parte de termos, que por sua vez, compõem uma expressão aritmética
fator returns [String type, int indice, String nome, boolean atributo]
    @init {
        $nome = "";
    }
    :
    parcela outras_parcelas {
        $type = $parcela.type;
        $indice = $parcela.indice;
        $nome = $parcela.nome;
        $atributo = $parcela.atributo;
    }
;


// Regra que permite o agrupamento de mais fatores com um operador aritmético de mesma ordem de precedência
outros_fatores:
    (op_multiplicacao fator)*;


// Regra que define parcelas (unárias ou não) de expressões aritméticas
parcela returns [String type, int indice, String nome, int tipo_parcela, boolean atributo]
    @init {
        $nome = "";
    }
    :
    op_unario parcela_unario {
        $tipo_parcela = PARCELA_UNARIO;
        $type = $parcela_unario.type;
        $indice = $parcela_unario.indice;
        $nome = $parcela_unario.nome;
        $atributo = $parcela_unario.atributo;
    } |
    parcela_nao_unario {
        $tipo_parcela = PARCELA_NAO_UNARIO;
        $type = $parcela_nao_unario.type;
    }
;


// Regra que define parcelas unárias, fazendo as devidas checagens semânticas quando apropriado
parcela_unario returns [String type, int indice, String nome, String tipo_parcela_unario, boolean atributo]
    @init {
        $type = "";
        $indice = -1;
        $nome = "";
    }
    :
    '^' IDENT outros_ident dimensao {
        $tipo_parcela_unario = "PONTEIRO";
        $type = pilhaDeTabelas.getTipoDoSimbolo($IDENT.text);
    } |
    IDENT chamada_partes {
        $tipo_parcela_unario = "CHAMADA";

        if (!pilhaDeTabelas.existeSimbolo($IDENT.text)) {
            ErrosSemanticos.identificadorInexistente($IDENT.text + $chamada_partes.id, $IDENT.line);
        }

        $type = pilhaDeTabelas.getTipoDoSimbolo($IDENT.text);
        pilhaDeTabelas.verificaCompatibilidadeDeParametros($chamada_partes.tipos, $IDENT.text, $IDENT.line);
        $nome = $chamada_partes.nome;;
        $atributo = $chamada_partes.atributo;
    } |
    NUM_INT {
        $tipo_parcela_unario = "INTEIRO";
        $type = "inteiro";
        $indice = Integer.parseInt($NUM_INT.text);
        $nome = $NUM_INT.text;
    } |
    NUM_REAL {
        $tipo_parcela_unario = "REAL";
        $type = "real";
        $nome = $NUM_REAL.text;
    } |
    '(' expressao ')' {
        $tipo_parcela_unario = "EXPRESSAO";
    }
;


// Regra que define parcelas não unárias. O agrupamento de parcelas unárias é feito com o operador lógico E.
parcela_nao_unario returns [String type, String nome]
    @init {
        $nome = "";
    }
    :
    '&' IDENT outros_ident dimensao {
        $type = "";
        $nome = $outros_ident.nome_atributo;
    } |
    CADEIA {
        $type = "literal";
        $nome = $CADEIA.text;
    }
;


// Regra que define outras parcelas da operação de módulo
outras_parcelas:
    ('%' parcela)*;


// Regra que define tipos de chamadas de funções ou procedimentos (com ou sem parâmetros, e caso sejam com parâmetros,
// se os parâmetros são expressões aritméticas ou identificadores)
chamada_partes returns [String id, List<String> tipos, String nome, int tipo_chamada, boolean atributo]
    @init {
        $id = "";
        $tipos = new ArrayList<String>();
        $nome = "";
    }
    :
    '(' expressao mais_expressao {
        $tipos = $mais_expressao.tipos;
        $tipos.add($expressao.type);
        $tipo_chamada = CHAMADA_EXPRESSAO;
    }
    ')' |
    outros_ident dimensao {
        $id = $outros_ident.id;
        $nome = $outros_ident.nome_atributo;
        $atributo = $outros_ident.atributo;
        $tipo_chamada = CHAMADA_IDENTIFICADOR;
    } |
    { $tipo_chamada = CHAMADA_VAZIA; }
;


// Regra que define expressões relacionais (com variáveis que auxiliam a verificação de sua compatibilidade)
exp_relacional returns [boolean compativel, String type, String nome, boolean atributo]
    @init {
        $nome = "";
    }
    :
    exp_aritmetica op_opcional {
        $nome = $exp_aritmetica.nome;
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


// Regra que define operadores opcionais em uma expressão relacional
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


// Regra que define os operadores relacionais aceitos na linguagem
op_relacional:
    '=' |
    '<>' |
    '>=' |
    '<=' |
    '>' |
    '<'
    ;


// Regra que define expressões lógicas (a serem usadas em operações relacionais)
expressao returns [boolean compativel, String type, String nome, boolean atributo]
    @init {
        $nome = "";
    }
    :
    termo_logico outros_termos_logicos {
        $compativel = $termo_logico.compativel;
        $type = $termo_logico.type;
        $nome = $termo_logico.nome;
        $atributo = $termo_logico.atributo;
    }
;


// Regra que define o operador unário de negação
op_nao:
    'nao' |
;


//Regra que define um termo lógico como sendo a composição de fatores lógicos
termo_logico returns [boolean compativel, String type, String nome, boolean atributo]
    @init {
        $nome = "";
    }
    :
    fator_logico outros_fatores_logicos {
        $compativel = $fator_logico.compativel;
        $type = $fator_logico.type;
        $nome = $fator_logico.nome;
        $atributo = $fator_logico.atributo;
    }
;


// Regra que define termos lógicos adicionais, agrupando-os com o operador lógico OU
outros_termos_logicos:
    'ou' termo_logico outros_termos_logicos |
;


// Regra que define fatores lógicos adicionais, agrupando-os com o operador lógico E
outros_fatores_logicos:
    'e' fator_logico outros_fatores_logicos |
;


// Regra que define um fator lógico, que faz parte de um termo lógico
fator_logico returns [boolean compativel, String type, String nome, boolean atributo]
    :
    op_nao parcela_logica {
        $compativel = $parcela_logica.compativel;
        $type = $parcela_logica.tipo_parcela_logica;
        $nome = $parcela_logica.nome;
        $atributo = $parcela_logica.atributo;
    }
;


// Regra que define uma parcela lógica de uma expressão relacional
parcela_logica returns [String tipo_parcela_logica, String nome, boolean compativel, boolean atributo]
    @init {
        $nome = "";
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
        $nome = $exp_relacional.nome;
        $atributo = $exp_relacional.atributo;
    }
;