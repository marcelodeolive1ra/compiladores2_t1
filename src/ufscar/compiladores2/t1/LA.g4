grammar LA;

// Declaração de variáveis que serão utilizadas neste arquivo
@members {
    static String grupo = "<488950, 489085, 489093, 489182>";
    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    Tipos tipos = new Tipos();
    Funcoes funcoes = new Funcoes();
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

// Regra para identificadores (números, letras e underscores, não podendo começar com números
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
    ( ' ' |'\t' | '\r' | '\n') {
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

NUM_ERRADO:
    ('0'..'9')+ ('a'..'z' | 'A'..'Z' | '_')+ {
        String variavel = getText().replaceAll("[0-9]","");
        stop("Linha " + getLine() + ": erro sintatico proximo a " + variavel);
    }
;

COMENTARIO_ERRADO:
    '{' ~('\n'|'}')* '\n' {
        stop("Linha " + getLine() + ": comentario nao fechado");
    }
;

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
        tipos.addTipo($IDENT.text, $tipo.atributos);
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
// um erro semântico será registrado através de um atributo estático da classe Mensagens.
// Mais detalhes sobre a classe Pair em http://www.antlr.org/api/Java/org/antlr/v4/runtime/misc/Pair.html
variavel returns [String name, String tipo_variavel]
    :
    IDENT dimensao mais_var ':' tipo {
        List<Pair> mais_variaveis = $mais_var.nomes;
        Pair primeira_variavel = new Pair($IDENT.text, $IDENT.line);

        if (pilhaDeTabelas.existeSimbolo(primeira_variavel.a.toString())) {
            Mensagens.erroVariavelJaExiste(primeira_variavel.a.toString(), Integer.parseInt(primeira_variavel.b.toString()));
        } else {
            pilhaDeTabelas.topo().adicionarSimbolo(primeira_variavel.a.toString(), $tipo.tipodado, "variavel");
        }

        for (Pair variavel: mais_variaveis) {
            if (pilhaDeTabelas.existeSimbolo(variavel.a.toString())) {
                Mensagens.erroVariavelJaExiste(variavel.a.toString(), Integer.parseInt(variavel.b.toString()));
            } else {
                pilhaDeTabelas.topo().adicionarSimbolo(variavel.a.toString(), $tipo.tipodado, "variavel");
            }
        }
        $name = $IDENT.text;
        $tipo_variavel = $tipo.tipodado;
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

        if (!pilhaDeTabelas.existeSimbolo($IDENT.text)) {
            Mensagens.erroVariavelNaoExiste($IDENT.text, $IDENT.line);
        } else if ($outros_ident.id.compareTo("") != 0) {
            if (!tipos.existeAtributo(pilhaDeTabelas.getVarTipo($IDENT.text), $outros_ident.nome_atributo)) {
                Mensagens.erroVariavelNaoExiste($IDENT.text + $outros_ident.id, $IDENT.line);
            }
        }
    }
;

// Regra para tratatamento dos ponteiros, que são opcionais para identificadores.
// O único retorno é a quantidade de ponteiros a serem adicionados antes do identificador.
ponteiros_opcionais returns [String ponteiros]
    @init {
        $ponteiros = "";
    }
    :
    ('^' { $ponteiros += "^"; })*
;

// Regra que permite definir identificadores compostos, com o uso do ponto ".".
outros_ident returns [String id, String nome_atributo, boolean temAtributo]
    @init {
        $id = "";
        $nome_atributo = "";
        $temAtributo = false;
    }
    :
    (
        '.' ponteiros_opcionais IDENT dimensao {
            $id += "." + $IDENT.text;
            $nome_atributo = $IDENT.text;
            $temAtributo = true;
        }
    )*
;


//Define a dimensão sendo zero ou mais sequencidas de [expressão]
dimensao returns [int indice]
    @init {
        $indice = -1;
    }
    : ('[' exp_aritmetica { $indice = $exp_aritmetica.indice; }']')*
;

//´Tipo é definido como um registro ("registro" v1, v2 ... "fim registro") ou
// um ponteiro (^) seguido de um tipo básico
tipo returns [String tipodado, List<Pair> atributos]
    :
    registro {
        $tipodado = "registro";
        $atributos = $registro.atributos;
        tipos.addTipo("registro", $atributos);
    } |
    tipo_estendido {
        $tipodado = $tipo_estendido.tipodado;
    }
;

//mais_ident permite criar N "identificador" todos separados por ','
mais_ident:
    (',' identificador)*;


//Define as palavres reservadas para um tipo basico
tipo_basico returns [String tipodado]
    :
    'literal' {
        $tipodado = "literal";
    } |
    'inteiro' {
        $tipodado = "inteiro";
    } |
    'real' {
        $tipodado = "real";
    } |
    'logico' {
        $tipodado = "logico";
    }
;

//Define um tipo basico ou um identificador(verifica a existencia do tipo que está
//sendo definido
tipo_basico_ident returns [String tipodado]
    :
    tipo_basico {
        $tipodado = $tipo_basico.tipodado;
    } |
    IDENT {
        $tipodado = $IDENT.text;
        if (!tipos.existeTipo($IDENT.text)) {
            Mensagens.erroTipoNaoExiste($IDENT.text, $IDENT.line);
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

//define um registro que tem a forma "registro" seguido de uma ou mais variáveis
//"fim_registro"
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


//Uma declaração_global é composta por "procedimento nome_procedimento (parametros)" seguido de
//declarações e comandos terminado pela palavra reservada "fim_procedimento" ou
//composta por "funcao nome_funcao (parametros) :" seguido de um tipo estendido,
//declarações e comandos, sendo terminado por "fim_funcao"
declaracao_global
    :
    'procedimento' IDENT {
        pilhaDeTabelas.topo().adicionarSimbolo($IDENT.text, "void", "procedimento");
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento_" + $IDENT.text));
        funcoes.addFuncao($IDENT.text);
    } '(' parametros_opcional ')' declaracoes_locais comandos 'fim_procedimento' {
        pilhaDeTabelas.desempilhar();
    } |
    'funcao' IDENT {
        funcoes.addFuncao($IDENT.text);
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

//parametro pode possuir uma variavel, possui um ou mais indentificadores
//e um tipo_estendido seguido parametros. Chama a classe funcoes para adicionar
//um tipodado na tabela.
parametro:
    var_opcional ident_param mais_id_param ':' tipo_estendido {
        pilhaDeTabelas.topo().adicionarSimbolo($ident_param.param, $tipo_estendido.tipodado, "parametro");
        funcoes.topo().add($tipo_estendido.tipodado);
    }
    mais_parametros;


ident_param returns [String param]:
    ponteiros_opcionais
    IDENT {
        $param = $IDENT.text;
    }
    dimensao
    outros_ident;


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

//Define que os commandos devem possuir ao menos uma instrução e podem ser seguidos de mais
//instruções
comandos:
    cmd*;


//O trecho a seguir define todas as instruções da linguagem e os seus formatos
//além disso faz as devidas verificaçoes para a definir se é possivel
//realizar a atribuição, se nao for retorna o erro adequado
cmd returns [ int tipoCmd, String nome_variavel,  String tipo_variavel]
    @id {
        $nome_variavel = "";
        $tipo_variavel = "";
    }
    : 'leia' '(' identificador mais_ident ')' {
        $tipoCmd = LEIA;
        $nome_variavel = $identificador.nome_variavel;
        $tipo_variavel = pilhaDeTabelas.getTypeData($identificador.nome_variavel);
    } |
    'escreva' '(' expressao mais_expressao ')' {
        $tipoCmd = ESCREVA;
        $nome_variavel = $expressao.name;
        $tipo_variavel = $expressao.type;
    } |
    'se' expressao 'entao' comandos senao_opcional 'fim_se' {
        $tipoCmd = SE;
    } |
    'caso' exp_aritmetica 'seja' selecao senao_opcional 'fim_caso' {
        $tipoCmd = CASO;
    } |
    'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' comandos 'fim_para' {
        $tipoCmd = PARA;
        $nome_variavel = $IDENT.text;
    } |
    'enquanto' expressao 'faca' comandos 'fim_enquanto' {
        $tipoCmd = ENQUANTO;
    } |
    'faca' comandos 'ate' expressao {
        $tipoCmd = FACA;
    } |
    '^' IDENT outros_ident dimensao '<-' expressao {
        $tipoCmd = PONTEIRO;
    } |
    IDENT chamada {
        $tipoCmd = CHAMADA;
    } |
    IDENT atribuicao {
        $tipoCmd = ATRIBUICAO;

        if (!pilhaDeTabelas.existeSimbolo($IDENT.text)) {
            Mensagens.erroVariavelNaoExiste($IDENT.text, $IDENT.line);
        } else if (!$atribuicao.compativel && !$atribuicao.type.equals("") && !pilhaDeTabelas.getTypeData($IDENT.text).equals($atribuicao.type)) {
            if (!(pilhaDeTabelas.getTypeData($IDENT.text).equals("real") && $atribuicao.type.equals("inteiro"))) {
                if ($atribuicao.indice != -1) {
                      Mensagens.erroVariavelNaoCompativel($IDENT.text + "[" + $atribuicao.indice + "]", $IDENT.line);
                } else if (!$atribuicao.name.equals("")) {
                     if (!tipos.getTipoAtr($atribuicao.name).equals($atribuicao.type)) {
                        if (!(tipos.getTipoAtr($atribuicao.name).equals("real") && $atribuicao.type.equals("inteiro"))) {
                            if (!tipos.getTipoAtr($atribuicao.name).equals(pilhaDeTabelas.getTypeData($IDENT.text))) {
                                Mensagens.erroVariavelNaoCompativel($IDENT.text + "." + $atribuicao.name, $IDENT.line);
                            }
                        }
                     }
                } else {
                      Mensagens.erroVariavelNaoCompativel($IDENT.text, $IDENT.line);
                }
            }
        }

        if ($IDENT.text.equals("ponteiro") && $atribuicao.type.equals("")) {
             Mensagens.erroVariavelNaoCompativel("^" + $IDENT.text, 14);
        }
    } |
    retorne = 'retorne' expressao {
        $tipoCmd = RETORNE;

        if (!pilhaDeTabelas.topo().getType().equals("funcao")) {
            Mensagens.escopoNaoPermitido($retorne.line);
        }
    }
;

//Permite que exista mais de uma expressão
mais_expressao  returns [List<String> tipos]
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

//chamada de atribuição é composta por argumentos opcionais entre parenteses ou
//um ou mais identificador podendo ou não ser mais dimensões seguido de "<-" expressão
chamada:
    '(' argumentos_opcional ')'
;

//Define o formato de uma atribuição, seta os valores das variaveis "compativel,
//String, indice e name" que sao retornadas para o cmd.
atribuicao returns [boolean compativel, String type, int indice, String name]
    @init {
        $type = "";
        $name = "";
    }
    :
    outros_ident dimensao '<-' expressao {
        $type = $expressao.type;

        if ($outros_ident.nome_atributo.equals("")) {
            if (!$expressao.name.equals("")) {
                 $compativel = false;

                 if($expressao.temAtributo) {
                    $name = $expressao.name;
                 }
            } else {
                $compativel = $expressao.compativel;
                $type = $expressao.type;
            }
        } else {
            $compativel = false;
            $type = $expressao.type;
            $name = $outros_ident.nome_atributo;
        }
        $indice = $dimensao.indice;
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

//o operador unário pode ser vazio
numero_intervalo:
    op_unario NUM_INT intervalo_opcional;

//o operador de unario pode ser vazio
intervalo_opcional:
    '..' op_unario NUM_INT |
;

op_unario:
    '-' |
;

//Expressẽos aritiméticas são compostas por um ou mais termos separados por virgulas
exp_aritmetica returns [boolean compativel, String type, int indice, String name, boolean temAtributo]
    @init {
        $compativel = false;
        $type = "";
        $name = "";
        $temAtributo=false;
    }
    :
    termo outros_termos {
        $name = $termo.name;
        $temAtributo = $termo.temAtributo;

        if (!$outros_termos.type.equals("") && !$termo.type.equals($outros_termos.type)) {
            $compativel = false;
            $type = $outros_termos.type;
            $indice = $termo.indice;
        } else {
            $compativel = false;
            $type = $termo.type;
        };
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
termo returns [String type, int indice, String name, boolean temAtributo]
    @init {
        $name = "";
        $temAtributo = false;
    }
    :
    fator outros_fatores {
        $type = $fator.type;
        $indice = $fator.indice;
        $name = $fator.name;
        $temAtributo = $fator.temAtributo;
    }
;


//outros termos é composto por uma operação de soma ou subtração seguida de um ou mais termos
//separados por virgula
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


fator returns [String type, int indice, String name, boolean temAtributo]
    @init {
        $name = "";
        $temAtributo =false;
    }
    :
    parcela outras_parcelas {
        $type = $parcela.type;
        $indice = $parcela.indice;
        $name = $parcela.name;
        $temAtributo = $parcela.temAtributo;
    }
;


//outros fatores é composto por operações de multiplicação ou divisão e um ou mais fatores separados
outros_fatores:
    (op_multiplicacao fator)*;

parcela returns [String type, int indice, String name, int tipo_parcela, boolean temAtributo]
    @init {
        $name = "";
        $temAtributo = false;
    }
    :
    op_unario parcela_unario {
        $tipo_parcela = PARCELA_UNARIO;
        $type = $parcela_unario.type;
        $indice = $parcela_unario.indice;
        $name = $parcela_unario.name;
        $temAtributo = $parcela_unario.temAtributo;
    } |
    parcela_nao_unario {
        $tipo_parcela = PARCELA_NAO_UNARIO;
        $type = $parcela_nao_unario.type;
    }
;


//parcela_unario é composta de um ponteiro (^) seguido de um identificador podendo ou não ter
//uma dimensão ou
//um identificador seguido de uma chamada *** ou
//um número inteiro ou
//um número real ou
//uma expressão entre parenteses
//com o retorno recebido de chamada_partes faz as devidas verificações e em caso
//de algum problema retorna o erro adequado.
parcela_unario returns [String type, int indice, String name, int tipoParc, boolean temAtributo]
    @init {
        $type = "";
        $indice = -1;
        $name = "";
        $temAtributo = false;
    }
    :
    '^' IDENT outros_ident dimensao {
        $type = pilhaDeTabelas.getTypeData($IDENT.text);
        $tipoParc = 1;
    } |
    IDENT chamada_partes {
        if (!pilhaDeTabelas.existeSimbolo($IDENT.text)) {
            Mensagens.erroVariavelNaoExiste($IDENT.text+$chamada_partes.id, $IDENT.line);
        }

        $type = pilhaDeTabelas.getTypeData($IDENT.text);
        if (!$chamada_partes.tipos.isEmpty()) {
            List<String> tipos = funcoes.getFuncTipos($IDENT.text);
            List<String> params = $chamada_partes.tipos;
            boolean erro = false;

            if (tipos != null) {
                for(int i = 1; i < tipos.size() && !erro; i++) {
                    try {
                        if (!tipos.get(i).equals(params.get(i)) && !params.get(i).equals("")) {
                            erro = true;
                        }
                    } catch (IndexOutOfBoundsException e) {
                          erro = true;
                    }
                }
            }
            if (erro) {
                Mensagens.erroIncompatibilidadeParametros($IDENT.text, $IDENT.line);
            }
        }
        $name = $chamada_partes.name;;
        $temAtributo = $chamada_partes.temAtributo;
        $tipoParc = 2;
    } |
    NUM_INT {
        $type = "inteiro";
        $indice = Integer.parseInt($NUM_INT.text);
        $name = $NUM_INT.text;
        $tipoParc = 3;
    } |
    NUM_REAL {
        $type = "real";
        $name = $NUM_REAL.text;
        $tipoParc = 4;
    } |
    '(' expressao ')' {
        $tipoParc = 5;
    }
;


parcela_nao_unario returns [String type, String name]
    @init {
        $name="";
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

//Composto pela operação modulo seguida de  1+n parcelas.
outras_parcelas:
    ('%' parcela)*;


chamada_partes returns [String id, List<String> tipos, String name, int tipoChamada, boolean temAtributo]
    @init {
        $id = "";
        $tipos = new ArrayList<String>();
        $name = "";
        $temAtributo = false;
    }
    :
    '(' expressao mais_expressao {
        $tipos = $mais_expressao.tipos;
        $tipos.add(0, $expressao.type);
        $tipoChamada = 1;
    }
    ')' |
    outros_ident dimensao {
        $id = $outros_ident.id;
        $name = $outros_ident.nome_atributo;
        $temAtributo = $outros_ident.temAtributo;
        $tipoChamada = 2;
        } |
    { $tipoChamada = 3; }
;


//Define a expressão relacinal como uma expressão aritimética seguida de um operador opcional ou não.
//Verifica a compatibilidade.
exp_relacional returns [boolean compativel, String type, String name, boolean temAtributo]
    @init {
        $name = "";
        $temAtributo = false;
    }
    :
    exp_aritmetica op_opcional {
        $name = $exp_aritmetica.name;
        $temAtributo = $exp_aritmetica.temAtributo;

        if ($op_opcional.type.equals("")) {
            $compativel = $exp_aritmetica.compativel;
            $type = $exp_aritmetica.type;
        } else {
            $compativel = true;
            $type = $op_opcional.type;
        }
    }
;

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

//Definição das expressões relacionais
op_relacional:
    '=' |
    '<>' |
    '>=' |
    '<=' |
    '>' |
    '<'
    ;

//Expressão é composta por um termo lógico seguido por N termos lógicos
expressao returns [boolean compativel, String type, String name, boolean temAtributo]
    @init {
        $name = "";
        $temAtributo = false;
    }
    :
    termo_logico outros_termos_logicos {
        $compativel = $termo_logico.compativel;
        $type = $termo_logico.type;
        $name = $termo_logico.name;
        $temAtributo = $termo_logico.temAtributo;
    }
;

op_nao:
    'nao' |
 ;

//Um termo lógico é composto por um ou mais fatores lógicos
termo_logico returns [boolean compativel, String type, String name, boolean temAtributo]
    @init {
        $name = "";
        $temAtributo = false;
    }
    :
    fator_logico outros_fatores_logicos {
        $compativel = $fator_logico.compativel;
        $type = $fator_logico.type;
        $name = $fator_logico.name;
        $temAtributo = $fator_logico.temAtributo;
    }
;


outros_termos_logicos:
    'ou' termo_logico outros_termos_logicos |
;

outros_fatores_logicos:
    'e' fator_logico outros_fatores_logicos |
;

//fator_logico é uma parecela lógica, negada ou não (pos op_nao leva à vazio)
fator_logico returns [boolean compativel, String type, String name, boolean temAtributo]
    :
    op_nao parcela_logica {
        $compativel = $parcela_logica.compativel;
        $type = $parcela_logica.type;
        $name = $parcela_logica.name;
        $temAtributo = $parcela_logica.temAtributo;
    }
;


//Parcela_logica que é verdadeira, falsa ou uma expressão relacional
parcela_logica returns [boolean compativel, String type, String name, int tipoParc, boolean temAtributo]
    @init {
        $name = "";
        $temAtributo = false;
    }
    :
    'verdadeiro' {
        $compativel = false;
        $type = "logico";
        $tipoParc = 1;
    } |
    'falso' {
        $compativel = false;
        $type = "logico";
        $tipoParc = 2;
    } |
    exp_relacional {
        $compativel = $exp_relacional.compativel;
        $type = $exp_relacional.type;
        $name = $exp_relacional.name;
        $tipoParc = 3;
        $temAtributo=$exp_relacional.temAtributo;
    }
;
