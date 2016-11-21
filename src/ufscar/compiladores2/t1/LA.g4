grammar LA;

@members {
    static String grupo = "<488950, 489085, 489093, 489182>";
    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    Tipos tipos = new Tipos();
    Funcoes funcoes = new Funcoes();

    private void stop(String msg) {
        throw new ParseCancellationException(msg);
    }
}

programa : {pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));}
           declaracoes 'algoritmo' corpo 'fim_algoritmo'
           {pilhaDeTabelas.desempilhar();};


declaracoes : (decl_local_global)*;

//"decl_local_global" retornar para "declaracoes" um inteiro dizendo se a declaracao
//feita é local ou global para possibilitar percorrer a arvore durante a geracao
//de código c

decl_local_global returns [int dec]: declaracao_local {$dec = 1;}| declaracao_global {$dec = 2;};

//"Na declaracao_local" a nova variável, constante ou novo tipo é criado e adionado
//no topo da pilha atual. Além disso é retornado valores para "decl_local_global"
//e para "declaracoes_locais".

declaracao_local returns [int tipoDec, String name, String tipoVar]
    : 'declare' variavel {$name = $variavel.name; $tipoVar = $variavel.tipoVar; $tipoDec = 1;}
    | 'constante' IDENT ':' tipo_basico '=' valor_constante
      {pilhaDeTabelas.topo().adicionarSimbolo($IDENT.text, $tipo_basico.tipodado, "constante");
       $tipoDec = 2;}
    | 'tipo' IDENT ':' tipo
      {tipos.addTipo($IDENT.text, $tipo.atributos);
       pilhaDeTabelas.topo().adicionarSimbolo($IDENT.text, "indefinido", "tipo");
       $tipoDec = 3;};

//uma variável é do tipo "nome[expressão]" ou "nome" seguido de dois pontos e o tipo,
//ou seja a variavel pode ser um vetor. Além disso é possível fazer a declaração de
//N variaveis no mesmo comando. Antes da inserção da variavel na pilha é
//verificado se esta já existe no escopo em que está sendo declarada. Caso
//esteja, é gerada uma msg de erro, senao a váriavel é adicionada

variavel returns [String name, String tipoVar]
    : IDENT dimensao mais_var ':' tipo
         {  List<Pair> nomes = new ArrayList<Pair>();
            nomes = $mais_var.nomes;
            Pair pair = new Pair($IDENT.text, $IDENT.line);
            nomes.add(0, pair);
            for (Pair var : nomes) {
                if(!pilhaDeTabelas.existeSimbolo(var.a.toString()))
                    pilhaDeTabelas.topo().adicionarSimbolo(var.a.toString(), $tipo.tipodado, "variavel");
                else
                    Mensagens.erroVariavelJaExiste(var.a.toString(), Integer.parseInt(var.b.toString()));

            }

            $name = $IDENT.text;
            $tipoVar = $tipo.tipodado;
         };


//Permite que seja declarada mais de uma variável do mesmo tipo. Retorna para
//"variavel" uma lista contendo em cada posicao o nome da variavel e a linha que
//ela está, para que o semantico utilize essa informação quando houver um erro.

mais_var returns [List<Pair> nomes]
@init { $nomes = new ArrayList<Pair>(); }
    : (',' IDENT dimensao {Pair pair = new Pair($IDENT.text, $IDENT.line); $nomes.add(pair);})*;

//Identificador pode iniciar com 0 ou mais ^ seguido de um identificador,
//Podendo ou não ter uma dimensão e podendo ou não ser composto de outros identificadores
//Além disso verifica-se se o identificador criado já existe na tabela de simbolos
//do escopo corrente.

identificador returns [String nameVar]
    : ponteiros_opcionais IDENT dimensao outros_ident {$nameVar = $IDENT.text;}
                {if(!pilhaDeTabelas.existeSimbolo($IDENT.text))
                     Mensagens.erroVariavelNaoExiste($IDENT.text, $IDENT.line);
                     else if (!$outros_ident.id.equals("")) {
                        String var = $IDENT.text + $outros_ident.id;
                        String tipo = pilhaDeTabelas.getVarTipo($IDENT.text);
                        String atr = $outros_ident.id.substring(1);
                        if(!tipos.existeAtributo(tipo, atr))
                            Mensagens.erroVariavelNaoExiste(var, $IDENT.line);
                    }
                    };

//ponteiros_opcionais são compostos por zero ou mais ^
ponteiros_opcionais returns [String ponteiros]
@init {$ponteiros = "";}
    : ('^'{$ponteiros += "^";})*;

//outros_ident permite a separação dos identificadores por virgula
outros_ident returns [String id, String name, boolean temAtributo]
@init {$id = ""; $name = ""; $temAtributo = false;}
    : ('.' ponteiros_opcionais IDENT dimensao {$id += "." + $IDENT.text;
                                               $name = $IDENT.text;
                                               $temAtributo = true;})*;


//Define a dimensão sendo zero ou mais sequencidas de [expressão]
dimensao returns [int indice]
@init {$indice = -1;}
    : ('[' exp_aritmetica {$indice = $exp_aritmetica.indice;}']')*;

//´Tipo é definido como um registro ("registro" v1, v2 ... "fim registro") ou
// um ponteiro (^) seguido de um tipo básico
tipo returns [String tipodado, List<Pair> atributos]
    : registro {$tipodado = "registro"; $atributos = $registro.atributos;
                tipos.addTipo("registro", $atributos);}| tipo_estendido {$tipodado = $tipo_estendido.tipodado;};

//mais_ident permite criar N "identificador" todos separados por ','
mais_ident : (',' identificador)* ;


//Define as palavres reservadas para um tipo basico
tipo_basico returns [String tipodado]
    : 'literal' {$tipodado = "literal";}| 'inteiro' {$tipodado = "inteiro";}
    | 'real' {$tipodado = "real";}| 'logico' {$tipodado = "logico";};

//Define um tipo basico ou um identificador(verifica a existencia do tipo que está
//sendo definido
tipo_basico_ident returns [String tipodado]
    : tipo_basico {$tipodado = $tipo_basico.tipodado;}
    | IDENT {$tipodado = $IDENT.text;
             if(!tipos.existeTipo($IDENT.text))
                Mensagens.erroTipoNaoExiste($IDENT.text, $IDENT.line);};

//tipo estendido é um ponteiro seguido de um identificador de tipo básico
tipo_estendido returns [String tipodado]
    : ponteiros_opcionais tipo_basico_ident {$tipodado = $tipo_basico_ident.tipodado + $ponteiros_opcionais.ponteiros;};

valor_constante : CADEIA | NUM_INT | NUM_REAL | 'verdadeiro' | 'falso' ;

//define um registro que tem a forma "registro" seguido de uma ou mais variáveis
//"fim_registro"
registro returns [List<Pair> atributos]
@init { $atributos = new ArrayList<Pair>();}
    : 'registro' (variavel_registro {$atributos.addAll($variavel_registro.atributos);})+ 'fim_registro';


variavel_registro returns [List<Pair> atributos]
@init { $atributos = new ArrayList<Pair>();}
    : IDENT dimensao mais_var_registro ':' tipo
      {Pair pair = new Pair($IDENT.text, $tipo.tipodado);
       $atributos.add(pair);
       for (String atr : $mais_var_registro.atributos) {
           Pair npair = new Pair(atr, $tipo.tipodado);
           $atributos.add(npair);
           }};

mais_var_registro returns [List<String> atributos]
@init { $atributos = new ArrayList<String>();}
    : (',' IDENT dimensao {$atributos.add($IDENT.text);})*;


//Uma declaração_global é composta por "procedimento nome_procedimento (parametros)" seguido de
//declarações e comandos terminado pela palavra reservada "fim_procedimento" ou
//composta por "funcao nome_funcao (parametros) :" seguido de um tipo estendido,
//declarações e comandos, sendo terminado por "fim_funcao"
declaracao_global : 'procedimento' IDENT
                    {pilhaDeTabelas.topo().adicionarSimbolo($IDENT.text, "void", "procedimento");
                     pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento_"+$IDENT.text));
                     funcoes.addFuncao($IDENT.text);}
                    '(' parametros_opcional ')' declaracoes_locais comandos 'fim_procedimento'
                    {pilhaDeTabelas.desempilhar();}
                  | 'funcao' IDENT {funcoes.addFuncao($IDENT.text);
                                    pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao_"+$IDENT.text));}
                    '(' parametros_opcional ')' ':' tipo_estendido
                    {pilhaDeTabelas.tabelaGlobal().adicionarSimbolo($IDENT.text, $tipo_estendido.tipodado, "funcao");}
                    declaracoes_locais comandos 'fim_funcao'
                    {pilhaDeTabelas.desempilhar();};



parametros_opcional : parametro | ;

//parametro pode possuir uma variavel, possui um ou mais indentificadores
//e um tipo_estendido seguido parametros. Chama a classe funcoes para adicionar
//um tipodado na tabela.
parametro : var_opcional ident_param mais_id_param ':' tipo_estendido
            {pilhaDeTabelas.topo().adicionarSimbolo($ident_param.param, $tipo_estendido.tipodado, "parametro");
             funcoes.topo().add($tipo_estendido.tipodado);}
            mais_parametros;

ident_param returns [String param]
    : ponteiros_opcionais IDENT {$param = $IDENT.text;} dimensao outros_ident;

mais_id_param : (',' ident_param)* ;


var_opcional : 'var' | ;

mais_parametros : ',' parametro | ;


declaracoes_locais : declaracao_local*;

corpo : declaracoes_locais comandos;

//Define que os commandos devem possuir ao menos uma instrução e podem ser seguidos de mais
//instruções
comandos : cmd* ;


//O trecho a seguir define todas as instruções da linguagem e os seus formatos
//além disso faz as devidas verificaçoes para a definir se é possivel
//realizar a atribuição, se nao for retorna o erro adequado
cmd returns [ int tipoCmd, String nameVar,  String tipoVar]
@id {$nameVar = ""; $tipoVar = "";}
    : 'leia' '(' identificador mais_ident ')' { $tipoCmd = 1; $nameVar = $identificador.nameVar; $tipoVar = pilhaDeTabelas.getTypeData($identificador.nameVar);}
    | 'escreva' '(' expressao mais_expressao ')' { $tipoCmd = 2; $nameVar = $expressao.name; $tipoVar = $expressao.type; }
    | 'se' expressao 'entao' comandos senao_opcional 'fim_se' { $tipoCmd = 3; }
    | 'caso' exp_aritmetica 'seja' selecao senao_opcional 'fim_caso' { $tipoCmd = 4; }
    | 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' comandos 'fim_para' { $tipoCmd = 5; $nameVar = $IDENT.text; }
    | 'enquanto' expressao 'faca' comandos 'fim_enquanto' { $tipoCmd = 6; }
    | 'faca' comandos 'ate' expressao { $tipoCmd = 7; }
    | '^' IDENT outros_ident dimensao '<-' expressao { $tipoCmd = 8; }
    | IDENT chamada { $tipoCmd = 9; }
    | IDENT atribuicao {if(!pilhaDeTabelas.existeSimbolo($IDENT.text)){
                            Mensagens.erroVariavelNaoExiste($IDENT.text, $IDENT.line);
                        }else if(!$atribuicao.compativel && !$atribuicao.type.equals("") && !pilhaDeTabelas.getTypeData($IDENT.text).equals($atribuicao.type)){
                            if(!(pilhaDeTabelas.getTypeData($IDENT.text).equals("real") && $atribuicao.type.equals("inteiro"))){
                                if($atribuicao.indice != -1){
                                      Mensagens.erroVariavelNaoCompativel($IDENT.text+"["+$atribuicao.indice+"]", $IDENT.line);
                                }else if(!$atribuicao.name.equals("")){
                                     if(!tipos.getTipoAtr($atribuicao.name).equals($atribuicao.type)) {
                                            if(tipos.getTipoAtr($atribuicao.name).equals("real") && $atribuicao.type.equals("inteiro")){
                                                //pass
                                            }else{
                                                if(!tipos.getTipoAtr($atribuicao.name).equals(pilhaDeTabelas.getTypeData($IDENT.text)))
                                                    Mensagens.erroVariavelNaoCompativel($IDENT.text+"."+$atribuicao.name, $IDENT.line);
                                            }
                                     }else{}
                                }else{
                                      Mensagens.erroVariavelNaoCompativel($IDENT.text, $IDENT.line);
                                }
                            }

                        }if($IDENT.text.equals("ponteiro") && $atribuicao.type.equals("")) {
                             Mensagens.erroVariavelNaoCompativel("^"+$IDENT.text, 14);
                         }
                        }
      { $tipoCmd = 10; }
    | r = 'retorne' expressao { if(!pilhaDeTabelas.topo().getType().equals("funcao"))
                                    Mensagens.escopoNaoPermitido($r.line);}
    { $tipoCmd = 11; }
    ;

//Permite que exista mais de uma expressão
mais_expressao  returns [List<String> tipos]
@init {$tipos = new ArrayList<String>(); }
    : (',' expressao {$tipos.add($expressao.type);})* ;


senao_opcional : 'senao' comandos | ;

//chamada de atribuição é composta por argumentos opcionais entre parenteses ou
//um ou mais identificador podendo ou não ser mais dimensões seguido de "<-" expressão
chamada : '(' argumentos_opcional ')';

//Define o formato de uma atribuição, seta os valores das variaveis "compativel,
//String, indice e name" que sao retornadas para o cmd.
atribuicao returns [boolean compativel, String type, int indice, String name]
@init {$type = ""; $name = "";}
    : outros_ident dimensao '<-' expressao {$type = $expressao.type;
                                            if($outros_ident.name.equals("")){
                                                if(!$expressao.name.equals("")){
                                                     $compativel = false;
                                                     if($expressao.temAtributo)
                                                        $name = $expressao.name;
                                                }else{
                                                      $compativel = $expressao.compativel; $type = $expressao.type;
                                                 }
                                            }else{
                                                $compativel = false; $type = $expressao.type;
                                                $name = $outros_ident.name;
                                             }
                                            $indice = $dimensao.indice;
                                            };


argumentos_opcional : expressao mais_expressao | ;

selecao : constantes ':' comandos mais_selecao;

mais_selecao : selecao | ;

constantes : numero_intervalo mais_constantes;

mais_constantes : ',' constantes | ;

//o operador unário pode ser vazio
numero_intervalo : op_unario NUM_INT intervalo_opcional;

//o operador de unario pode ser vazio
intervalo_opcional : '..' op_unario NUM_INT | ;

op_unario : '-' | ;

//Expressẽos aritiméticas são compostas por um ou mais termos separados por virgulas
exp_aritmetica returns [boolean compativel, String type, int indice, String name, boolean temAtributo]
@init {$compativel = false; $type = ""; $name = ""; $temAtributo=false;}
    : termo outros_termos {$name = $termo.name;
                           $temAtributo = $termo.temAtributo;
                           if(!$outros_termos.type.equals("") && !$termo.type.equals($outros_termos.type)){
                                $compativel = false;
                                $type = $outros_termos.type;
                                $indice = $termo.indice;
                           }else{
                                $compativel = false;
                                $type = $termo.type;};};


op_multiplicacao : '*' | '/';

op_adicao : '+' | '-';

//Termo é composto por um ou mais fatores separados por virgula
termo returns [String type, int indice, String name, boolean temAtributo]
@init {$name = ""; $temAtributo = false;}
    : fator outros_fatores {$type = $fator.type; $indice = $fator.indice; $name = $fator.name; $temAtributo = $fator.temAtributo;};


//outros termos é composto por uma operação de soma ou subtração seguida de um ou mais termos
//separados por virgula
outros_termos returns [String type]
@init {$type = "";}
    : (op_adicao termo {$type = $termo.type;})*;


fator returns [String type, int indice, String name, boolean temAtributo]
@init {$name = ""; $temAtributo =false;}
    : parcela outras_parcelas {$type = $parcela.type; $indice = $parcela.indice; $name = $parcela.name; $temAtributo = $parcela.temAtributo;;};


//outros fatores é composto por operações de multiplicação ou divisão e um ou mais fatores separados
outros_fatores : (op_multiplicacao fator)*;

parcela returns [String type, int indice, String name, int parcelaTipo, boolean temAtributo]
@init {$name = ""; $temAtributo = false;}
    : op_unario parcela_unario {$type = $parcela_unario.type; $indice = $parcela_unario.indice; $name = $parcela_unario.name; $parcelaTipo = 1; $temAtributo = $parcela_unario.temAtributo;}
    | parcela_nao_unario {$type = $parcela_nao_unario.type; $parcelaTipo = 2;};


//parcela_unario é composta de um ponteiro (^) seguido de um identificador podendo ou não ter
//uma dimensão ou
//um identificador seguido de uma chamada *** ou
//um número inteiro ou
//um número real ou
//uma expressão entre parenteses
//com o retorno recebido de chamada_partes faz as devidas verificações e em caso
//de algum problema retorna o erro adequado.
parcela_unario returns [String type, int indice, String name, int tipoParc, boolean temAtributo]
@init {$type = ""; $indice = -1; $name = ""; $temAtributo = false;}
    : '^' IDENT outros_ident dimensao {$type = pilhaDeTabelas.getTypeData($IDENT.text); $tipoParc = 1;}
    | IDENT chamada_partes {if(!pilhaDeTabelas.existeSimbolo($IDENT.text))
                                Mensagens.erroVariavelNaoExiste($IDENT.text+$chamada_partes.id, $IDENT.line);
                            $type = pilhaDeTabelas.getTypeData($IDENT.text);
                            if(!$chamada_partes.tipos.isEmpty()) {
                                List<String> tipos = funcoes.getFuncTipos($IDENT.text);
                                List<String> params = $chamada_partes.tipos;
                                boolean erro = false;
                                if(tipos != null) {
                                    for(int i = 1; i < tipos.size(); i++) {
                                        try {
                                            if(!tipos.get(i).equals(params.get(i)) && !params.get(i).equals("")) {
                                                erro = true;
                                                break;
                                            }
                                        } catch (IndexOutOfBoundsException ioobe) {
                                              erro = true;
                                        }

                                    }
                                }
                                if (erro == true)
                                    Mensagens.erroIncompatibilidadeParametros($IDENT.text, $IDENT.line);
                            }
                            $name = $chamada_partes.name;;
                            $temAtributo = $chamada_partes.temAtributo;
                            $tipoParc = 2;}
    | NUM_INT {$type = "inteiro"; $indice = Integer.parseInt($NUM_INT.text); $name = $NUM_INT.text; $tipoParc = 3;}
    | NUM_REAL {$type = "real"; $name = $NUM_REAL.text; $tipoParc = 4;}
    | '(' expressao ')' {$tipoParc = 5;}; //{$type = $expressao.type;};


parcela_nao_unario returns [String type, String name]
@init {$name="";}
    : '&' IDENT outros_ident dimensao {$type = ""; $name = $outros_ident.name;}
    | CADEIA {$type = "literal"; $name = $CADEIA.text;};

//Composto pela operação modulo seguida de  1+n parcelas.
outras_parcelas : ('%' parcela)*;


chamada_partes returns [String id, List<String> tipos, String name, int tipoChamada, boolean temAtributo]
@init {$id = ""; $tipos = new ArrayList<String>(); $name = ""; $temAtributo = false;}
    : '(' expressao mais_expressao {$tipos = $mais_expressao.tipos; $tipos.add(0, $expressao.type); $tipoChamada = 1;}')'
    | outros_ident dimensao {$id = $outros_ident.id; $name = $outros_ident.name; $temAtributo = $outros_ident.temAtributo; $tipoChamada = 2;}| {$tipoChamada = 3;};


//Define a expressão relacinal como uma expressão aritimética seguida de um operador opcional ou não.
//Verifica a compatibilidade.
exp_relacional returns [boolean compativel, String type, String name, boolean temAtributo]
@init {$name = ""; $temAtributo = false;}
    : exp_aritmetica op_opcional {$name = $exp_aritmetica.name;
                                  $temAtributo = $exp_aritmetica.temAtributo;
                                  if($op_opcional.type.equals("")){
                                        $compativel = $exp_aritmetica.compativel; $type = $exp_aritmetica.type;
                                   }else{
                                        $compativel = true; $type = $op_opcional.type;
                                   }
                                  };

op_opcional returns [String type, boolean compativel]
@init {$type = ""; $compativel = true;}
    : op_relacional exp_aritmetica {$type = "logico";}
    | ;

//Definição das expressões relacionais
op_relacional : '=' | '<>' | '>=' | '<=' | '>' | '<';

//Expressão é composta por um termo lógico seguido por N termos lógicos
expressao returns [boolean compativel, String type, String name, boolean temAtributo]
@init {$name = ""; $temAtributo=false;}
    : termo_logico outros_termos_logicos
      {$compativel = $termo_logico.compativel; $type = $termo_logico.type; $name = $termo_logico.name; $temAtributo = $termo_logico.temAtributo;};

op_nao : 'nao' | ;

//Um termo lógico é composto por um ou mais fatores lógicos
termo_logico returns [boolean compativel, String type, String name, boolean temAtributo]
@init {$name = ""; $temAtributo = false;}
    : fator_logico outros_fatores_logicos {$compativel = $fator_logico.compativel; $type = $fator_logico.type; $name = $fator_logico.name; $temAtributo = $fator_logico.temAtributo;};


outros_termos_logicos : 'ou' termo_logico outros_termos_logicos | ;

outros_fatores_logicos  : 'e' fator_logico outros_fatores_logicos | ;

//fator_logico é uma parecela lógica, negada ou não (pos op_nao leva à vazio)
fator_logico returns [boolean compativel, String type, String name, boolean temAtributo]
    : op_nao parcela_logica {$compativel = $parcela_logica.compativel; $type = $parcela_logica.type; $name = $parcela_logica.name; $temAtributo = $parcela_logica.temAtributo;};


//Parcela_logica que é verdadeira, falsa ou uma expressão relacional
parcela_logica returns [boolean compativel, String type, String name, int tipoParc, boolean temAtributo]
@init {$name = ""; $temAtributo = false;}
    : 'verdadeiro' {$compativel = false; $type = "logico"; $tipoParc = 1;}
    | 'falso' {$compativel = false; $type = "logico"; $tipoParc = 2;}
    | exp_relacional {$compativel = $exp_relacional.compativel; $type = $exp_relacional.type; $name = $exp_relacional.name; $tipoParc = 3; $temAtributo=$exp_relacional.temAtributo;;};



IDENT : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;

IDENT_ERRADO : '[' IDENT ')' {stop("Linha "+getLine()+": erro sintatico proximo a )");};

NUM_INT : ('0'..'9')+;

//Utilizado para identificar casos que geravam erro no sintático
NUM_ERRADO : ('0'..'9')+ ('a'..'z' | 'A'..'Z' | '_')+
             {String variavel = getText().replaceAll("[0-9]","");
              stop("Linha "+getLine()+": erro sintatico proximo a " + variavel);};

NUM_REAL : ('0'..'9')+ '.' ('0'..'9')+;

//Todos os caracteres que não são quebra de linha ou "retorno do cursor"

CADEIA : '"' ~('\n' | '\r' | '"')* '"';

//CADEIA_ERRADA : '"' ~('\n' | '\r' | '"')* '\n'
  //              { stop("Linha "+getLine()+": "+getText()+" - simbolo nao identificado");

//Tudo entre {}

COMENTARIO : '{' ~('}'|'\n')* '}' {skip();};

//COMENTARIO: '{' ~('\n' | '\r' | ' ' | '\t' | '}')* '}' {skip();};

ESPACO : ( ' ' |'\t' | '\r' | '\n') {skip();};

COMENTARIO_ERRADO: '{' ~('\n'|'}')* '\n' { stop("Linha "+getLine()+": comentario nao fechado"); };
ERROR
    : . { stop("Linha "+getLine()+": "+getText()+" - simbolo nao identificado"); }
;