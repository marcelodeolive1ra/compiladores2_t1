package ufscar.compiladores2.t1;

import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by marcelodeoliveiradasilva on 19/11/16.
 */

public class GeradorDeCodigoC extends LABaseVisitor<String> {

    private PilhaDeTabelas pilha_de_tabelas;

    // Variável que armazenará o código C gerado
    private String codigo_c;

    // Constantes para deixar o código mais legível (a análise semântica retorna números que identificam os comandos)
    private final String GLOBAL = "global";
    private final String LOCAL = "local";
    private final int LEIA = 1, ESCREVA = 2, SE = 3, CASO = 4, PARA = 5, ENQUANTO = 6, FACA = 7, PONTEIRO = 8,
        CHAMADA = 9, ATRIBUICAO = 10, RETORNE = 11, VARIAVEL = 1, CONSTANTE = 2, REGISTRO = 3;
    private final String LITERAL = "literal", REAL = "real", INTEIRO = "inteiro", LOGICO = "logico";

    // O construtor desta classe inicializa a string que armazenará em memória o código C gerado ao processar a
    // árvore gerada pelo parser
    public GeradorDeCodigoC() {
        this.codigo_c = "";
    }

    // Esta função é adiciona texto à variável que guarda o código C que é gerado durante a avaliação da árvore
    // gerada pelo parser
    public void println(String texto) {
        this.codigo_c += (texto + "\n");
    }

    // Esta função faz o mesmo que a anterior, mas sem colocar quebrar a linha após a inserção de novo texto
    public void print(String texto) {
        this.codigo_c += texto;
    }

    // Esta função realiza a conversão dos tipos da linguagem LA para tipos equivalentes em linguagem C
    public String getTipoDeDadoEmC(String tipo_em_LA) {
        String tipo_em_c = "";

        switch (tipo_em_LA) {
            case LITERAL:
                tipo_em_c = "char";
                break;
            case REAL:
                tipo_em_c = "float";
                break;
            case INTEIRO:
                tipo_em_c = "int";
                break;
            case LOGICO:
                tipo_em_c = "bool";
                break;
            case INTEIRO + "^":
                tipo_em_c = "int*";
                break;
            case REAL + "^":
                tipo_em_c = "float*";
                break;
            case LITERAL + "^":
                tipo_em_c = "char*";
                break;
            default:
                break;
        }

        return tipo_em_c;
    }

    // Início da geração de código começa neste método
    @Override
    public String visitPrograma(LAParser.ProgramaContext ctx) {
        this.println("/* Código gerado automaticamente pelo compilador da linguagem LA */");
        this.println("");
        this.println("#include <stdio.h>");
        this.println("#include <stdlib.h>");
        this.println("");

        // Declarações globais do programa
        this.visitDeclaracoes(ctx.declaracoes());

        this.println("int main() {");

        // Visitando o corpo do programa
        this.visitCorpo(ctx.corpo());

        this.println("\n\treturn 0;");
        this.print("}");

        return "";
    }

    // Declarações globais do programa
    @Override
    public String visitDeclaracoes(LAParser.DeclaracoesContext ctx) {
        if (ctx != null) {
            for (LAParser.Decl_local_globalContext declaracao: ctx.decl_local_global()) {
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
                this.visitDeclaracao_local(ctx.declaracao_local());
            } else if (ctx.declaracao_global() != null) {
                this.visitDeclaracao_global(ctx.declaracao_global());
            }
        }
        return "";
    }

    // Procedimentos ou funções
    @Override
    public String visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        if (ctx.comandos() != null) {
            // Declaração de procedimento
            if (ctx.tipo_estendido() == null) {
                this.print("void " + ctx.IDENT().getText() + "(");
                this.visitParametros_opcional(ctx.parametros_opcional());
                this.println(") {");
                this.visitComandos(ctx.comandos());
                this.println("}\n");
            } else {
                // Declaração de função, logo é necessário verificar o tipo de retorno
                this.visitTipo_estendido(ctx.tipo_estendido());
                this.print(ctx.IDENT().getText() + "(");
                this.visitParametros_opcional(ctx.parametros_opcional());
                this.println(") {");
                this.visitComandos(ctx.comandos());
                this.println("}\n");
            }
        }
        return "";
    }

    @Override
    public String visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        if (ctx.tipoDec == VARIAVEL) {
            this.visitVariavel(ctx.variavel);
        } else if (ctx.tipoDec == CONSTANTE) {
            this.println("#define " + ctx.IDENT.getText() + " " + visitValor_constante(ctx.valor_constante()));
        } else {
            if (ctx.tipoDec == REGISTRO) {
                if (ctx.tipo().registro() != null) {
                    this.println("typedef struct " + ctx.IDENT.getText() + " {");

                    int i = 0;
                    for (LAParser.Variavel_registroContext v : ctx.tipo().registro().variavel_registro()) {
                        String tipo = this.getTipoDeDadoEmC(v.tipo().tipodado);

                        String variavel_em_c = "\t" + tipo + " " + v.IDENT() + ';';

                        // Tratamento do caso de strings em C, que são tratadas como vetores de char
                        if (v.tipo().tipodado.compareTo(LITERAL) == 0) {
                            variavel_em_c = variavel_em_c.replace(";", "[100];");
                        }

                        this.println(variavel_em_c);

                        // Mais variáveis declaradas na mesma linha
                        if (v.mais_var_registro() != null) {
                            for (String v1: v.mais_var_registro().atributos) {
                                String variavel_em_c2 = "\t" + tipo + " " + v1 + ';';

                                // Tratamento do caso de strings em C, que são tratadas como vetores de char
                                if (v.tipo().tipodado.compareTo(LITERAL) == 0) {
                                    variavel_em_c2 = variavel_em_c.replace(";", "[100];");
                                }

                                //tratar dimensão (para o caso de vetores)

                                this.println(variavel_em_c2);
                            }
                        }
                    }
                    //visitMais_var(ctx.tipo().registro());

                    this.println("} " + ctx.IDENT.getText() + ";\n");
                }
            }
        }
        return "";
    }

    @Override
    public String visitDeclaracoes_locais(LAParser.Declaracoes_locaisContext ctx) {
        for (LAParser.Declaracao_localContext declaracao: ctx.declaracao_local()) {
            this.visitDeclaracao_local(declaracao);
        }
        return "";
    }

    public String visitVariavel(LAParser.VariavelContext ctx) {
        String tipo = getTipoDeDadoEmC(ctx.tipoVar);

        String variavel_em_c = "\t" + tipo + " " + ctx.IDENT().getText() + ';';

        // Tratamento do caso de strings em C, que são tratadas como vetores de char
        if (ctx.tipoVar.compareTo(LITERAL) == 0) {
            variavel_em_c = variavel_em_c.replace(";", "[100];");
        }

        String dimensao = this.visitDimensao(ctx.dimensao());
        if (dimensao.compareTo("") != 0) {
            variavel_em_c = variavel_em_c.replace(";", dimensao + ";");
        }

        this.println(variavel_em_c);

        this.visitMais_var_aux(ctx.mais_var(), tipo);

        //tratar caso de registros

        return "";
    }

    public String visitMais_var(LAParser.Mais_varContext ctx) {
        for (TerminalNode v : ctx.IDENT()) {
            this.print(", " + v.getText() + ";");
        }
        return "";
    }

    public String visitMais_var_aux(LAParser.Mais_varContext ctx, String tipo_variavel) {
        for (TerminalNode v: ctx.IDENT()) {
            this.println("\t" + tipo_variavel + " " + v.getText() + ";");
        }
        return "";
    }


    @Override
    public String visitCorpo(LAParser.CorpoContext ctx) {
        if (ctx != null) {
            // Visita primeiro as declarações locais
            this.visitDeclaracoes_locais(ctx.declaracoes_locais());
            // E depois a lista de comandos do programa
            this.visitComandos(ctx.comandos());
        }
        return "";
    }

    @Override
    public String visitComandos(LAParser.ComandosContext ctx) {
        if (ctx != null) {
            // Dados os vários comandos, visitar cada um deles
            for (LAParser.CmdContext comando: ctx.cmd()) {
                this.visitCmd(comando);
            }
        }
        return "";
    }

    @Override
    public String visitCmd(LAParser.CmdContext ctx) {
        if (ctx != null) {
            switch(ctx.tipoCmd) {
                case LEIA:
                    if(ctx.tipoVar.compareTo(LITERAL) == 0) {
                        this.println("\tgets(" + ctx.nameVar + ");");
                    } else {
                        this.print("\tscanf(\"");
                        this.print((ctx.tipoVar.compareTo(INTEIRO) == 0) ? "%d": "%f");
                        this.println("\", &" + ctx.nameVar + ");");

                        if (ctx.mais_ident() != null) {
                            for (LAParser.IdentificadorContext i : ctx.mais_ident().identificador()) {
                                this.print(", &" + i.nameVar);
                            }
                        }
                    }
                    break;
                case ESCREVA:
                    this.print("\tprintf(\"");
                    this.print((ctx.tipoVar.compareTo(LITERAL) == 0) ? "%s" : (ctx.tipoVar.compareTo(INTEIRO) == 0) ? "%d": "%f");
                    this.println("\", " + this.visitExpressao(ctx.expressao()) + ");");

                    String[] mais_expressoes = this.visitMais_expressao_aux(ctx.mais_expressao());

                    for (int i = 0; i < mais_expressoes.length; i++) {
                        String tipo = ctx.mais_expressao().tipos.get(i);
                        if (tipo.compareTo(LITERAL) == 0) {
                            this.print("\tprintf(\"%s\", ");
                        } else if (tipo.compareTo(REAL) == 0) {
                            this.print("\tprintf(\"%f\", ");
                        } else if (tipo.compareTo(INTEIRO) == 0) {
                            this.print("\tprintf(\"%d\", ");
                        }
                        this.println(mais_expressoes[i] + ");");
                    }
                    break;
                case SE:
                    this.println("\tif (" + this.visitExpressao(ctx.expressao()) + ") {");
                    this.print("\t");
                    this.visitComandos(ctx.comandos());
                    this.print("\t}");
                    this.visitSenao_opcional(ctx.senao_opcional());
                    break;
                case CASO:
                    this.println("\tswitch (" + this.visitExp_aritmetica(ctx.exp_aritmetica(0)) +  ") {");
                    this.visitSelecao(ctx.selecao());
                    this.println("\tdefault:");
                    if (ctx.senao_opcional().comandos() != null) {
                        this.print("\t");
                        this.visitComandos(ctx.senao_opcional().comandos());
                    }
                    this.println("\t\tbreak;");
                    this.println("\t}");
                    break;
                case PARA:
                    // Podemos usar sempre "<=" pela sintaxe da linguagem LA, em que o comando "para" inclui o último
                    // número
                    this.println("\tfor (" + ctx.nameVar + " = " + this.visitExp_aritmetica(ctx.exp_aritmetica(0)) +
                            "; " + ctx.nameVar + " <= " + this.visitExp_aritmetica(ctx.exp_aritmetica(1)) + "; " +
                            ctx.nameVar + "++) {");
                    this.print("\t");
                    this.visitComandos(ctx.comandos());
                    this.println("\t}");
                    break;
                case ENQUANTO:
                    this.println("\twhile (" + this.visitExpressao(ctx.expressao()) + ") {");
                    this.print("\t");
                    this.visitComandos(ctx.comandos());
                    this.println("\t}");
                    break;
                case FACA:
                    this.println("\tdo {");
                    this.print("\t");
                    this.visitComandos(ctx.comandos());
                    this.println("\t} while (" + this.visitExpressao(ctx.expressao()) + ");");
                    break;
                case PONTEIRO: // ^ (acho que é ponteiro, precisa verificar melhor na gramática)
                    this.println("*" + ctx.IDENT().getText() + this.visitOutros_ident(ctx.outros_ident()) +
                            this.visitDimensao(ctx.dimensao()) + " = " + this.visitExpressao(ctx.expressao()) + ";");
                    break;
                case CHAMADA: // chamada [de função ou procedimento]
                    this.print(ctx.IDENT().getText());
                    this.visitChamada(ctx.chamada());
                    this.println(";");
                    break;
                case ATRIBUICAO: // atribuição de variável
                    if (ctx.atribuicao().type.compareTo(LITERAL) != 0) {
                        // Variável não é do tipo literal
                        this.print("\t" + ctx.IDENT().getText());
                        this.visitAtribuicao(ctx.atribuicao());
                        this.println(";");
                    } else {
                        // Variável é literal
                        this.println("\tstrcpy(" + ctx.IDENT().getText() + visitOutros_ident(ctx.outros_ident()) +
                                visitDimensao(ctx.dimensao()) + ", " + visitExpressao(ctx.expressao()) + ";");
                    }
                    break;
                case RETORNE: // retorno de função
                    this.println("\treturn " + this.visitExpressao(ctx.expressao()) + ";");
                    break;
                default:
                    break;
            }
        }
        return "";
    }

    @Override
    public String visitPonteiros_opcionais(LAParser.Ponteiros_opcionaisContext ctx) {
        this.print(ctx.ponteiros + " ");
        return "";
    }

    @Override
    public String visitOutros_ident(LAParser.Outros_identContext ctx) {
        List<TerminalNode> idents = ctx.IDENT();
        List<LAParser.DimensaoContext> dims = ctx.dimensao();
        String o_idents = "";
        for (int i = 0; i < idents.size(); i++) {
            o_idents += "." + idents.get(i).getText() + this.visitDimensao(dims.get(i));
        }
        return o_idents;
    }

    @Override
    public String visitDimensao(LAParser.DimensaoContext ctx) {
        String dim = "";
        for(LAParser.Exp_aritmeticaContext exp : ctx.exp_aritmetica()) {
            dim += "[" + this.visitExp_aritmetica(exp) + "]";
        }
        return dim;
    }

    @Override
    public String visitTipo(LAParser.TipoContext ctx) {
        this.visitRegistro(ctx.registro());
        return "";
    }

    @Override
    public String visitMais_ident(LAParser.Mais_identContext ctx) { return ""; }

    @Override
    public String visitTipo_basico(LAParser.Tipo_basicoContext ctx) {
        if(ctx.tipodado.equals(LITERAL))
            this.print("char*");
        else
            this.print(getTipoDeDadoEmC(ctx.tipodado));
        return "";
    }

    @Override
    public String visitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx) {
        this.visitTipo_basico(ctx.tipo_basico());
        return "";
    }

    @Override
    public String visitTipo_estendido(LAParser.Tipo_estendidoContext ctx) {
        this.visitTipo_basico_ident(ctx.tipo_basico_ident());
        this.visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        return "";
    }

    @Override
    public String visitValor_constante(LAParser.Valor_constanteContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitRegistro(LAParser.RegistroContext ctx) {
        for (LAParser.Variavel_registroContext variavel: ctx.variavel_registro()) {
            this.visitVariavel_registro(variavel);
        }
        return "";
    }

    @Override
    public String visitVariavel_registro(LAParser.Variavel_registroContext ctx) {
        if (ctx.tipo.tipodado.compareTo(LITERAL) == 0) {
            println(this.getTipoDeDadoEmC(ctx.tipo.tipodado) + " " + ctx.IDENT().getText() + "[100]" + ";");
        } else {
            println(this.getTipoDeDadoEmC(ctx.tipo.tipodado) + " " + ctx.IDENT().getText() + ";");
        }
        return "";
    }

    @Override
    public String visitMais_var_registro(LAParser.Mais_var_registroContext ctx) {
        return "";
    }

    @Override
    public String visitParametros_opcional(LAParser.Parametros_opcionalContext ctx) {
        if(ctx.parametro() != null) {
            this.visitParametro(ctx.parametro());
        }
        return "";
    }

    @Override
    public String visitParametro(LAParser.ParametroContext ctx) {
        this.visitTipo_estendido(ctx.tipo_estendido());
        this.visitIdent_param(ctx.ident_param());
        return "";
    }

    @Override
    public String visitIdent_param(LAParser.Ident_paramContext ctx) {
        this.visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        this.print(ctx.IDENT().getText() + visitDimensao(ctx.dimensao()) + visitOutros_ident(ctx.outros_ident()));
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

    public String[] visitMais_expressao_aux(LAParser.Mais_expressaoContext ctx) {
        String[] mais_expressoes = new String[ctx.expressao().size()];
        int i = 0;

        for (LAParser.ExpressaoContext expressao : ctx.expressao()) {
            mais_expressoes[i] = this.visitExpressao(expressao);
            i++;
        }
        return mais_expressoes;
    }

    @Override
    public String visitSenao_opcional(LAParser.Senao_opcionalContext ctx) {
        if (ctx.comandos() != null) {
            this.println(" else {");
            this.print("\t");
            this.visitComandos(ctx.comandos());
            this.println("\t}");
        }
        return "";
    }

    @Override
    public String visitChamada(LAParser.ChamadaContext ctx) {
        this.print("(");
        this.visitArgumentos_opcional(ctx.argumentos_opcional());
        this.print(")");
        return "";
    }

    @Override
    public String visitAtribuicao(LAParser.AtribuicaoContext ctx) {
        this.print(this.visitOutros_ident(ctx.outros_ident()) + this.visitDimensao(ctx.dimensao()) + " = " +
                this.visitExpressao(ctx.expressao()));
        return "";
    }

    @Override
    public String visitArgumentos_opcional(LAParser.Argumentos_opcionalContext ctx) {
        this.print(this.visitExpressao(ctx.expressao()) + this.visitMais_expressao(ctx.mais_expressao()));
        return "";
    }

    @Override
    public String visitSelecao(LAParser.SelecaoContext ctx) {
        this.println("\tcase " + ctx.constantes().numero_intervalo().NUM_INT().getText() + ":");
        this.print("\t");
        this.visitComandos(ctx.comandos());
        this.println("\tbreak;");
        this.visitMais_selecao(ctx.mais_selecao());
        return "";
    }

    @Override
    public String visitMais_selecao(LAParser.Mais_selecaoContext ctx) {
        if(ctx.selecao() != null) {
            this.visitSelecao(ctx.selecao());
        }
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
        return ctx.getText();
    }

    @Override
    public String visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx) {
        return (ctx != null) ? this.visitTermo(ctx.termo()) + this.visitOutros_termos(ctx.outros_termos()) : "";
    }

    @Override
    public String visitOp_multiplicacao(LAParser.Op_multiplicacaoContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitOp_adicao(LAParser.Op_adicaoContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitTermo(LAParser.TermoContext ctx) {
        return this.visitFator(ctx.fator()) + this.visitOutros_fatores(ctx.outros_fatores());
    }

    @Override
    public String visitOutros_termos(LAParser.Outros_termosContext ctx) {
        int i = 0;
        String outros_termos = "";

        for (LAParser.Op_adicaoContext operador: ctx.op_adicao()) {
            outros_termos += " " + this.visitOp_adicao(operador) + " " + this.visitTermo(ctx.termo().get(i));
            i++;
        }
        return outros_termos;
    }

    @Override
    public String visitFator(LAParser.FatorContext ctx) {
        return this.visitParcela(ctx.parcela()) + this.visitOutras_parcelas(ctx.outras_parcelas());
    }

    @Override
    public String visitOutros_fatores(LAParser.Outros_fatoresContext ctx) {
        int i = 0;
        String outros_fatores = "";

        for (LAParser.Op_multiplicacaoContext operador: ctx.op_multiplicacao()) {
            outros_fatores += this.visitOp_multiplicacao(operador) + this.visitFator(ctx.fator().get(i));
            i++;
        }
        return outros_fatores;
    }

    @Override
    public String visitParcela(LAParser.ParcelaContext ctx) {
        return (ctx.parcelaTipo == 1) ? this.visitOp_unario(ctx.op_unario()) + this.visitParcela_unario(ctx.parcela_unario()):
                this.visitParcela_nao_unario(ctx.parcela_nao_unario());
    }

    @Override
    public String visitParcela_unario(LAParser.Parcela_unarioContext ctx) {
        if (ctx.tipoParc == 1) {
            return "* " + ctx.IDENT().getText() + this.visitOutros_ident(ctx.outros_ident()) + this.visitDimensao(ctx.dimensao());
        } else if (ctx.tipoParc == 2) {
            return ctx.IDENT().getText() +
                    ((ctx.chamada_partes().tipoChamada == 1) ? "(" + this.visitExpressao(ctx.chamada_partes().expressao()) +
                            this.visitMais_expressao(ctx.chamada_partes().mais_expressao()) + ")" :
                            ((ctx.chamada_partes().tipoChamada == 2) ? this.visitOutros_ident(ctx.chamada_partes().outros_ident()) +
                                    this.visitDimensao(ctx.chamada_partes().dimensao()) : ""));
        } else if (ctx.tipoParc == 3) {
            return ctx.NUM_INT.getText();
        } else if (ctx.tipoParc == 4) {
            return ctx.NUM_REAL.getText();
        } else if (ctx.tipoParc == 5) {
            return "(" + this.visitExpressao(ctx.expressao()) + ")";
        }
        return "";
    }

    @Override
    public String visitParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx) {
        return (ctx.type.compareTo(LITERAL) == 0) ? ctx.CADEIA.getText() : "&" + ctx.IDENT().getText() +
                this.visitOutros_ident(ctx.outros_ident()) + this.visitDimensao(ctx.dimensao());
    }

    @Override
    public String visitOutras_parcelas(LAParser.Outras_parcelasContext ctx) {
        String outras_parcelas = "";

        for (LAParser.ParcelaContext parcela: ctx.parcela()) {
            outras_parcelas += "% " + this.visitParcela(parcela);
        }
        return outras_parcelas;
    }

    @Override
    public String visitChamada_partes(LAParser.Chamada_partesContext ctx) {
        return "";
    }

    @Override
    public String visitExp_relacional(LAParser.Exp_relacionalContext ctx) {
        return this.visitExp_aritmetica(ctx.exp_aritmetica()) + this.visitOp_opcional(ctx.op_opcional());
    }

    @Override
    public String visitOp_opcional(LAParser.Op_opcionalContext ctx) {
        return this.visitOp_relacional(ctx.op_relacional()) + this.visitExp_aritmetica(ctx.exp_aritmetica());
    }

    @Override
    public String visitOp_relacional(LAParser.Op_relacionalContext ctx) {
        return (ctx != null) ? (ctx.getText().compareTo("=") == 0 ? " ==" :
                (ctx.getText().compareTo("<>") == 0) ? " != " : " " + ctx.getText()) + " " : "";
    }

    @Override
    public String visitExpressao(LAParser.ExpressaoContext ctx) {
        return this.visitTermo_logico(ctx.termo_logico()) + this.visitOutros_termos_logicos(ctx.outros_termos_logicos());
    }

    @Override
    public String visitOp_nao(LAParser.Op_naoContext ctx) {
        return (ctx.getText().compareTo("nao") == 0) ? "!" : "";
    }

    @Override
    public String visitTermo_logico(LAParser.Termo_logicoContext ctx) {
        return (ctx != null) ? this.visitFator_logico(ctx.fator_logico()) +
                this.visitOutros_fatores_logicos(ctx.outros_fatores_logicos()) : "";
    }

    @Override
    public String visitOutros_termos_logicos(LAParser.Outros_termos_logicosContext ctx) {
        return (ctx.termo_logico() != null) ? " || " + this.visitTermo_logico(ctx.termo_logico()) +
                this.visitOutros_termos_logicos(ctx.outros_termos_logicos()) : "";
    }

    @Override
    public String visitFator_logico(LAParser.Fator_logicoContext ctx) {
        return (ctx != null) ? this.visitOp_nao(ctx.op_nao()) + this.visitParcela_logica(ctx.parcela_logica()) : "";
    }

    @Override
    public String visitOutros_fatores_logicos(LAParser.Outros_fatores_logicosContext ctx) {
        return (ctx.fator_logico() != null) ? " && " + this.visitFator_logico(ctx.fator_logico()) +
                this.visitOutros_fatores_logicos(ctx.outros_fatores_logicos()) : "";
    }

    @Override
    public String visitParcela_logica(LAParser.Parcela_logicaContext ctx) {
        return (ctx.tipoParc == 1) ? ("true") : ((ctx.tipoParc == 2) ? ("false") :
                this.visitExp_relacional(ctx.exp_relacional()));
    }

    @Override
    public String toString() {
        return this.codigo_c;
    }
}