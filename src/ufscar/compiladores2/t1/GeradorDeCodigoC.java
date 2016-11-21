package ufscar.compiladores2.t1;

import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by marcelodeoliveiradasilva on 19/11/16.
 */


public class GeradorDeCodigoC extends LABaseVisitor<String> {

    private PilhaDeTabelas pilha_de_tabelas;
    private OutputBuffer codigo_c;

    private final String GLOBAL = "GLOBAL";
    private final String LOCAL = "LOCAL";

    private final int LEIA = 1;
    private final int ESCREVA = 2;
    private final int SE = 3;
    private final int CASO = 4;
    private final int PARA = 5;
    private final int ENQUANTO = 6;
    private final int FACA = 7;
    private final int PONTEIRO = 8;
    private final int CHAMADA = 9;
    private final int ATRIBUICAO = 10;
    private final int RETORNE = 11;
    private final int VARIAVEL = 1;
    private final int CONSTANTE = 2;
    private final int REGISTRO = 3;

    // O construtor desta classe cria um buffer que armazenará em memória o código C gerado ao processar a
    // árvore gerada pelo analisador semântico
    public GeradorDeCodigoC() {
        this.codigo_c = new OutputBuffer();
    }

    public String getTipoDeDadoEmC(String tipoLA) {
        switch (tipoLA) {
            case "literal":
                tipoLA = "char";
                break;
            case "real":
                tipoLA = "float";
                break;
            case "inteiro":
                tipoLA = "int";
                break;
            case "logico":
                tipoLA = "bool";
                break;
            default:
                break;
        }

        return tipoLA;
    }

    // Início da geração de código começa neste método
    @Override
    public String visitPrograma(LAParser.ProgramaContext ctx) {
        this.codigo_c.println("/* Código gerado automaticamente pelo compilador da linguagem LA */");
        this.codigo_c.println("");
        this.codigo_c.println("#include <stdio.h>");
        this.codigo_c.println("#include <stdlib.h>");
        this.codigo_c.println("");

        // Declarações globais do programa
//        this.pilha_de_tabelas = new PilhaDeTabelas();
//        TabelaDeSimbolos tabela_de_simbolos_global = new TabelaDeSimbolos(GLOBAL);
//        this.pilha_de_tabelas.empilhar(tabela_de_simbolos_global);
        this.visitDeclaracoes(ctx.declaracoes());

        this.codigo_c.println("int main() {");

        // Visitando o corpo do programa
        this.visitCorpo(ctx.corpo());

        this.codigo_c.println("\n\treturn 0;");
        this.codigo_c.println("}");

        return "";
    }

    // Declarações globais do programa
    @Override
    public String visitDeclaracoes(LAParser.DeclaracoesContext ctx) {
        if (ctx != null) {
            for (LAParser.Decl_local_globalContext declaracao : ctx.decl_local_global()) {
                visitDecl_local_global(declaracao);
            }
        }
        return "";
    }

    @Override
    public String visitDecl_local_global(LAParser.Decl_local_globalContext ctx) {
        // Se existirem declarações
        if (ctx != null) {
            if (ctx.declaracao_local() != null) {
                visitDeclaracao_local(ctx.declaracao_local());
            } else if (ctx.declaracao_global() != null ) {
                visitDeclaracao_global(ctx.declaracao_global());
            }
        }
        return "";
    }

    // Verificar o que tem que ser feito nessa regra
    @Override
    public String visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        this.codigo_c.println("\t {{ declaracao_global }}");
        return "";
    }

    @Override
    public String visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {

        if (ctx.tipoDec == VARIAVEL) {
            visitVariavel(ctx.variavel);
        } else if (ctx.tipoDec == CONSTANTE) {
            codigo_c.println("#DEFINE " + ctx.IDENT.getText() + " " + visitValor_constante(ctx.valor_constante()));
        } else {
            if (ctx.tipoDec == REGISTRO) {


                if (ctx.tipo().registro() != null) {
                    codigo_c.println("typedef struct " + ctx.IDENT.getText() + " {");

                    int i = 0;
                    for (LAParser.Variavel_registroContext v : ctx.tipo().registro().variavel_registro()) {
                        String tipo = this.getTipoDeDadoEmC(v.tipo().tipodado);

                        String variavel_em_c = "\t" + tipo + " " + v.IDENT() + ';';

                        // Tratamento do caso de strings em C, que são tratadas como vetores de char
                        if (v.tipo().tipodado.compareTo("literal") == 0) {
                            variavel_em_c = variavel_em_c.replace(";", "[100];");
                        }

                        this.codigo_c.println(variavel_em_c);

                        // Mais variáveis declaradas na mesma linha
                        if (v.mais_var_registro() != null) {
                            for (String v1: v.mais_var_registro().atributos) {
                                String variavel_em_c2 = "\t" + tipo + " " + v1 + ';';

                                // Tratamento do caso de strings em C, que são tratadas como vetores de char
                                if (v.tipo().tipodado.compareTo("literal") == 0) {
                                    variavel_em_c2 = variavel_em_c.replace(";", "[100];");
                                }

                                //tratar dimensão (para o caso de vetores)

                                this.codigo_c.println(variavel_em_c2);
                            }
                        }
                    }
                    //visitMais_var(ctx.tipo().registro());

                    codigo_c.println("} " + ctx.IDENT.getText() + ";\n");
                }


//            if(ctx.children != null) {
//                out.println("\tstruct {");
//                visitVariavel(ctx.variavel());
//                visitMais_variaveis(ctx.mais_variaveis());
//
//                out.print("\t}");
//                return "struct ";
//            }
//
//
//            public String visitTipo(GrammarLAParser.TipoContext ctx) {
//                if(ctx.registro() != null){
//                    return visitRegistro(ctx.registro());
//                } else{
//                    return visitTipo_estendido(ctx.tipo_estendido());
//                }
//            }
//            visitTipo(ctx.tipo());

            }
        }
        return "";
    }

    @Override
    public String visitDeclaracoes_locais(LAParser.Declaracoes_locaisContext ctx) {
        for (LAParser.Declaracao_localContext declaracao: ctx.declaracao_local()) {
            visitDeclaracao_local(declaracao);
        }
        return "";
    }


    public String visitVariavel(LAParser.VariavelContext ctx) {
        // tratar o caso de literais que têm que ser convertidos para array de char em C
        String tipo = getTipoDeDadoEmC(ctx.tipoVar);

        String variavel_em_c = "\t" + tipo + " " + ctx.IDENT().getText() + ';';

        // Tratamento do caso de strings em C, que são tratadas como vetores de char
        if (ctx.tipoVar.compareTo("literal") == 0) {
            variavel_em_c = variavel_em_c.replace(";", "[100];");
        }

        this.codigo_c.println(variavel_em_c);

        visitMais_var(ctx.mais_var, tipo);

        //tratar caso de ponteiros e registros

        return "";
    }

    public String visitMais_var(LAParser.Mais_varContext ctx, String tipo_variavel) {
        for (TerminalNode v: ctx.IDENT()) {
            this.codigo_c.println("\t" + tipo_variavel + " " + v.getText() + ";");
        }
        return "";
    }

    public String visitMais_var_aux(LAParser.Mais_varContext ctx, String tipo_variavel) {
        for (TerminalNode v: ctx.IDENT()) {
            this.codigo_c.println("\t" + tipo_variavel + " " + v.getText() + ";");
        }
        return "";
    }


    @Override
    public String visitCorpo(LAParser.CorpoContext ctx) {
        if (ctx != null) {
            // Visita primeiro as declarações locais
            visitDeclaracoes_locais(ctx.declaracoes_locais());
            // E depois a lista de comandos do programa
            visitComandos(ctx.comandos());
        }
        return "";
    }

    @Override
    public String visitComandos(LAParser.ComandosContext ctx) {
        if (ctx != null) {
            // Dados os vários comandos, visitar cada um deles
            for (LAParser.CmdContext comando: ctx.cmd()) {
                visitCmd(comando);
            }
        }
        return "";
    }

    @Override
    public String visitCmd(LAParser.CmdContext ctx) {
        if (ctx != null) {

            // Tratar leia, escreva, se, entao, senao, caso, faca, enquanto

            int quantidade_de_variaveis = 0;

            switch(ctx.tipoCmd) {

                case LEIA: //leia?
                    this.codigo_c.print("\tscanf(\"");

                    if (ctx.mais_ident() != null) {
                        quantidade_de_variaveis = ctx.mais_ident().identificador().size() + 1;
                    }

                    for (int i = 0; i < quantidade_de_variaveis; i++) {
                        this.codigo_c.print("%x");
                    }

                    // Pegar o tipo da variável na tabela de símbolos, e se for literal, não colocar o & (pois vai ser um vetor de char)
                    this.codigo_c.print("\", &");
                    this.codigo_c.print(ctx.identificador().nameVar);

                    String tipo_de_leitura = "";

                    // Precisa pegar o tipo da variável na tabela de símbolos
                    //switch (ctx.identificador.)

                    if (ctx.mais_ident() != null) {
                        for (LAParser.IdentificadorContext i : ctx.mais_ident().identificador()) {
                            this.codigo_c.print(", &" + i.nameVar);
                        }
                    }

                    this.codigo_c.println(");");


                    break;
                case ESCREVA: //escreva?
                    this.codigo_c.print("\tprintf(");

                    // escreva ( expressao mais_expressao )

//                    if (ctx.mais_ident() != null) {
//                        quantidade_de_variaveis = ctx.mais_ident().identificador().size() + 1;
//                    }
//
//                    for (int i = 0; i < quantidade_de_variaveis; i++) {
//                        this.codigo_c.print("\"%x");
//                    }
//
//                    this.codigo_c.print("\", " + ctx.identificador().nameVar);
//
//                    if (ctx.mais_ident() != null) {
//                        for (LAParser.IdentificadorContext i : ctx.mais_ident().identificador()) {
//                            this.codigo_c.print(", " + i.nameVar);
//                        }
//                    }

                    this.codigo_c.println(");");
                    break;
                case SE: //se
                    this.codigo_c.print("\tif (");
                    //visitSelecao();
                    this.codigo_c.print("\t}");
                    break;
                case CASO: //caso
                    break;
                case PARA: // para
                    break;
                case ENQUANTO: // enquanto
                    break;
                case FACA: // faca
                    break;
                case PONTEIRO: // ^ (acho que é ponteiro, precisa verificar melhor na gramática)
                    break;
                case CHAMADA: // chamada [de função ou procedimento]
                    break;
                case ATRIBUICAO: // atribuição de variável
                    break;
                case RETORNE: // retorno de função
                    break;
                default:
                    break;
            }
        }
        return "";
    }

    @Override
    public String visitPonteiros_opcionais(LAParser.Ponteiros_opcionaisContext ctx) {
        this.codigo_c.print(ctx.ponteiros/*.replace("^", "*")*/ + " ");
        return "";
    }

    @Override
    public String visitOutros_ident(LAParser.Outros_identContext ctx) {
        List<TerminalNode> idents = ctx.IDENT();
        List<LAParser.DimensaoContext> dims = ctx.dimensao();
        String o_idents = "";
        for (int i = 0; i < idents.size(); i++) {
            o_idents += "." + idents.get(i).getText() + visitDimensao(dims.get(i));
        }
        return o_idents;
    }

    @Override
    public String visitDimensao(LAParser.DimensaoContext ctx) {
        String dim = "";
//        for(LAParser.Exp_aritmeticaContext exp : ctx.exp_aritmetica()) {
//            dim += "[" + visitExp_aritmetica(exp) + "]";
//        }
        return dim;
    }

    @Override
    public String visitTipo(LAParser.TipoContext ctx) {
        return "";
    }

    @Override
    public String visitMais_ident(LAParser.Mais_identContext ctx) { return ""; }

    @Override
    public String visitTipo_basico(LAParser.Tipo_basicoContext ctx) {
        if(ctx.tipodado.equals("literal"))
            this.codigo_c.print("char*");
        else
            this.codigo_c.print(getTipoDeDadoEmC(ctx.tipodado));
        return "";
    }

    @Override
    public String visitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx) {
        visitTipo_basico(ctx.tipo_basico());
        return "";
    }

    @Override
    public String visitTipo_estendido(LAParser.Tipo_estendidoContext ctx) {
        visitTipo_basico_ident(ctx.tipo_basico_ident());
        visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        return "";
    }

    @Override
    public String visitValor_constante(LAParser.Valor_constanteContext ctx) {
        return "VALORCONSTANTE";
    }

    @Override
    public String visitRegistro(LAParser.RegistroContext ctx) {
        return "";
    }

    @Override
    public String visitVariavel_registro(LAParser.Variavel_registroContext ctx) {
        return "";
    }

    @Override
    public String visitMais_var_registro(LAParser.Mais_var_registroContext ctx) {
        return "";
    }

    @Override
    public String visitParametros_opcional(LAParser.Parametros_opcionalContext ctx) {
        if(ctx.parametro() != null)
            visitParametro(ctx.parametro());
        return "";
    }

    @Override
    public String visitParametro(LAParser.ParametroContext ctx) {
        visitTipo_estendido(ctx.tipo_estendido());
        visitIdent_param(ctx.ident_param());
        return "";
    }

    @Override
    public String visitIdent_param(LAParser.Ident_paramContext ctx) {

//        visitPonteiros_opcionais(ctx.ponteiros_opcionais());
//        this.codigo_c.print(ctx.IDENT().getText() + visitDimensao(ctx.dimensao()) + visitOutros_ident(ctx.outros_ident()));
        return "";
    }

    @Override
    public String visitMais_id_param(LAParser.Mais_id_paramContext ctx) {
        return "";
    }

    @Override
    public String visitVar_opcional(LAParser.Var_opcionalContext ctx) {
        return "";
    }

    @Override
    public String visitMais_parametros(LAParser.Mais_parametrosContext ctx) {
        return "";
    }

    @Override
    public String visitMais_expressao(LAParser.Mais_expressaoContext ctx) {
        return "";
    }

    @Override
    public String visitSenao_opcional(LAParser.Senao_opcionalContext ctx) {
        return "";
    }

    @Override
    public String visitChamada(LAParser.ChamadaContext ctx) {
        this.codigo_c.print("(");
        visitArgumentos_opcional(ctx.argumentos_opcional());
        this.codigo_c.print(")");
        return "";
    }

    @Override
    public String visitAtribuicao(LAParser.AtribuicaoContext ctx) {
        //this.codigo_c.print(visitOutros_ident(ctx.outros_ident()) + visitDimensao(ctx.dimensao()) + " = " + visitExpressao(ctx.expressao()));
        return "";
    }

    @Override
    public String visitArgumentos_opcional(LAParser.Argumentos_opcionalContext ctx) {
        //this.codigo_c.print(visitExpressao(ctx.expressao()) + visitMais_expressao(ctx.mais_expressao()));
        return "";
    }

    @Override
    public String visitSelecao(LAParser.SelecaoContext ctx) {
        this.codigo_c.print("case " + ctx.constantes().numero_intervalo().NUM_INT().getText() + ":");

        List<LAParser.CmdContext> cmds = ctx.comandos().cmd();
        for(LAParser.CmdContext cmd : cmds)
            visitCmd(cmd);
        this.codigo_c.print("break;");
        visitMais_selecao(ctx.mais_selecao());
        return "";
    }

    @Override
    public String visitMais_selecao(LAParser.Mais_selecaoContext ctx) {
        if(ctx.selecao() != null)
            visitSelecao(ctx.selecao());
        return "";
    }

    @Override
    public String visitConstantes(LAParser.ConstantesContext ctx) {
        return "";
    }

    @Override
    public String visitMais_constantes(LAParser.Mais_constantesContext ctx) {
        return "";
    }

    @Override
    public String visitNumero_intervalo(LAParser.Numero_intervaloContext ctx) {
        return "";
    }

    @Override
    public String visitIntervalo_opcional(LAParser.Intervalo_opcionalContext ctx) {
        return "";
    }

    @Override
    public String visitOp_unario(LAParser.Op_unarioContext ctx) {
        return "";
    }

    @Override
    public String visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx) {
        return "";
    }

    @Override
    public String visitOp_multiplicacao(LAParser.Op_multiplicacaoContext ctx) {
        return "";
    }

    @Override
    public String visitOp_adicao(LAParser.Op_adicaoContext ctx) {
        return "";
    }

    @Override
    public String visitTermo(LAParser.TermoContext ctx) {
        return "";
    }

    @Override
    public String visitOutros_termos(LAParser.Outros_termosContext ctx) {
        return "";
    }

    @Override
    public String visitFator(LAParser.FatorContext ctx) {
        return "";
    }

    @Override
    public String visitOutros_fatores(LAParser.Outros_fatoresContext ctx) {
        return "";
    }

    @Override
    public String visitParcela(LAParser.ParcelaContext ctx) {
        return "";
    }

    @Override
    public String visitParcela_unario(LAParser.Parcela_unarioContext ctx) {
        return "";
    }

    @Override
    public String visitParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx) {
        return "";
    }

    @Override
    public String visitOutras_parcelas(LAParser.Outras_parcelasContext ctx) {
        return "";
    }

    @Override
    public String visitChamada_partes(LAParser.Chamada_partesContext ctx) {
        return "";
    }

    @Override
    public String visitExp_relacional(LAParser.Exp_relacionalContext ctx) {
        return "";
    }

    @Override
    public String visitOp_opcional(LAParser.Op_opcionalContext ctx) {
        return "";
    }

    @Override
    public String visitOp_relacional(LAParser.Op_relacionalContext ctx) {
        return "";
    }

    @Override
    public String visitExpressao(LAParser.ExpressaoContext ctx) {
        return "";
    }

    @Override
    public String visitOp_nao(LAParser.Op_naoContext ctx) {
        return "";
    }

    @Override
    public String visitTermo_logico(LAParser.Termo_logicoContext ctx) {
        return "";
    }

    @Override
    public String visitOutros_termos_logicos(LAParser.Outros_termos_logicosContext ctx) {
        return "";
    }

    @Override
    public String visitOutros_fatores_logicos(LAParser.Outros_fatores_logicosContext ctx) {
        return "";
    }

    @Override
    public String visitFator_logico(LAParser.Fator_logicoContext ctx) {
        return "";
    }

    @Override
    public String visitParcela_logica(LAParser.Parcela_logicaContext ctx) {
        return "";
    }

    @Override
    public String toString() {
        return this.codigo_c.toString();
    }
}