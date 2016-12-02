package ufscar.compiladores2.t1;

import java.io.FileInputStream;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

public class GeradorDeCodigoC extends LABaseVisitor<String> {
    // Variável que armazenará o código C gerado
    private String codigo_c;

    // Constantes para deixar o código mais legível (a análise semântica retorna números que identificam os comandos)
    private final int LEIA = 1, ESCREVA = 2, SE = 3, CASO = 4, PARA = 5, ENQUANTO = 6, FACA = 7, PONTEIRO = 8,
            CHAMADA = 9, ATRIBUICAO = 10, RETORNE = 11, VARIAVEL = 1, CONSTANTE = 2, TIPO = 3, PARCELA_UNARIO = 1;
    private final String LITERAL = "literal", REAL = "real", INTEIRO = "inteiro", LOGICO = "logico";

    // O construtor desta classe inicializa a string que armazenará em memória o código C gerado ao processar a
    // árvore gerada pelo parser
    public GeradorDeCodigoC() {
        this.codigo_c = "";
    }

    public static void testaGeradorDeCodigoC() throws Exception {
        String entrada = "/Users/marcelodeoliveiradasilva/Desktop/LACompiler/casosDeTeste/entrada/13.txt";
//        String entrada = "/Users/ViniciusBarbosa/Downloads/T2/T2/T2/src/trabalho2/casosDeTeste/entrada/casoDeTeste01.txt";
        //String entrada = "/Users/gustavoB/vai/casosDeTesteT1/entrada/casoDeTeste01.txt";
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(entrada));
        LALexer lexer = new LALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LAParser parser = new LAParser(tokens);
        LAParser.ProgramaContext tree = parser.programa();

        GeradorDeCodigoC codigo_c = new GeradorDeCodigoC();

        codigo_c.visitPrograma(tree);

        System.out.println(codigo_c);
    }

    // Este método adiciona texto à variável que guarda o código C que é gerado durante a avaliação da AST
    public void println(String texto) {
        this.codigo_c += (texto + "\n");
    }

    // Esta função faz o mesmo que a anterior, mas sem colocar quebrar a linha após a inserção de novo texto
    public void print(String texto) {
        this.codigo_c += texto;
    }

    // Esta função realiza a conversão dos tipos da linguagem LA para tipos equivalentes em linguagem C
    public String getTipoDeDadoEmC(String tipo_em_LA) {
        return tipo_em_LA.replace(INTEIRO, "int").replace(REAL, "float").replace(LOGICO, "bool").
                replace(LITERAL, "char").replace("^", "*");
    }

    // Início da geração de código começa neste método, sendo inclusa a estrutura básica do programa C, e então,
    // chama-se o método que percorrerá as declarações globais do programa e em seguida o corpo do programa
    @Override
    public String visitPrograma(LAParser.ProgramaContext ctx) {
        this.println("/* Código gerado automaticamente pelo compilador da linguagem LA */\n");
        this.println("#include <stdio.h>\n#include <stdlib.h>\n");

        this.visitDeclaracoes(ctx.declaracoes());

        this.println("int main() {");

        this.visitCorpo(ctx.corpo());

        this.print("\n\treturn 0;\n}");

        return "";
    }

    // Método que visita as declarações do programa, se existirem
    @Override
    public String visitDeclaracoes(LAParser.DeclaracoesContext ctx) {
        if (ctx != null) {
            for (LAParser.Decl_local_globalContext declaracao : ctx.decl_local_global()) {
                this.visitDecl_local_global(declaracao);
            }
        }
        return "";
    }

    // Método que visita as declarações locais ou globais, se existirem
    @Override
    public String visitDecl_local_global(LAParser.Decl_local_globalContext ctx) {
        if (ctx != null) {
            if (ctx.declaracao_local() != null) {
                this.visitDeclaracao_local(ctx.declaracao_local());
            } else if (ctx.declaracao_global() != null) {
                this.visitDeclaracao_global(ctx.declaracao_global());
            }
        }
        return "";
    }

    // Método que visita declarações globais, que, no caso da linguagem LA, inclue funções e procedimentos
    @Override
    public String visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        this.print((ctx.tipo_estendido() == null ? "void ": "") + ctx.IDENT().getText() + "(");
        this.visitParametros_opcional(ctx.parametros_opcional());
        this.println(") {");
        this.visitComandos(ctx.comandos());
        this.println("}\n");
        return "";
    }

    // Método que visita declarações locais, que podem ser variáveis, constantes ou tipos
    // Para o caso de tipos, é necessário visitar cada variável que compõe o tipo
    // Observação a respeito do tipo literal: em C, foi considerado um literal como um vetor de char de tamanho 100
    @Override
    public String visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        if (ctx.tipo_declaracao == VARIAVEL) {
            if (ctx.tipo_variavel.compareTo("registro") == 0) {
                this.println("\tstruct {");
                this.visitRegistro(ctx.variavel().tipo().registro());
                this.println("\t} " + ctx.variavel().IDENT().getText() + ";");
            } else {
                this.visitVariavel(ctx.variavel);
            }
        } else if (ctx.tipo_declaracao == CONSTANTE) {
            this.println("#define " + ctx.IDENT.getText() + " " + visitValor_constante(ctx.valor_constante()));
        } else if (ctx.tipo_declaracao == TIPO) {
            if (ctx.tipo().registro() != null) {
                this.println("typedef struct " + ctx.IDENT.getText() + " {");

                for (LAParser.Variavel_registroContext variavel : ctx.tipo().registro().variavel_registro()) {
                    String tipo = this.getTipoDeDadoEmC(variavel.tipo().tipodado);

                    this.println("\t" + tipo + " " + variavel.IDENT() +
                            (variavel.tipo().tipodado.compareTo(LITERAL) == 0 ? "[100]" : "") + ";");

                    // Quando várias variáveis são declaradas na mesma linha no programa em linguagem LA,
                    // as mesmas são definidas em linhas separadas em C
                    if (variavel.mais_var_registro() != null) {
                        for (String _variavel : variavel.mais_var_registro().atributos) {
                            this.println("\t" + tipo + " " + _variavel +
                                    ((variavel.tipo().tipodado.compareTo(LITERAL) == 0) ? "[100]" : "") + ";");
                        }
                    }
                }
                this.println("} " + ctx.IDENT.getText() + ";\n");
            }
        }
        return "";
    }

    // Método que visita as declarações locais do programa
    @Override
    public String visitDeclaracoes_locais(LAParser.Declaracoes_locaisContext ctx) {
        for (LAParser.Declaracao_localContext declaracao : ctx.declaracao_local()) {
            this.visitDeclaracao_local(declaracao);
        }
        return "";
    }

    // Método que visita as variáveis declaradas, incluindo suas dimensões, se houverem (para suportar vetores)
    @Override
    public String visitVariavel(LAParser.VariavelContext ctx) {
        String tipo = getTipoDeDadoEmC(ctx.tipo_variavel);
        String dimensao = (ctx.tipo_variavel.compareTo(LITERAL) == 0) ? "[100]" : this.visitDimensao(ctx.dimensao());

        this.println("\t" + tipo + " " + ctx.IDENT().getText() + dimensao + ';');
        this.visitMais_var_aux(ctx.mais_var(), tipo);
        return "";
    }

    // Método que visita eventuais mais variáveis que possam ter sido declaradas numa mesma linha na linguagem LA
    // Neste método, ao invés de fazer override do método da classe LABaseVisitor, optamos por receber um parâmetro
    // adicional: o tipo. Desta forma, em C fazemos a declaração de variáveis uma por linha
    public String visitMais_var_aux(LAParser.Mais_varContext ctx, String tipo_variavel) {
        for (TerminalNode v : ctx.IDENT()) {
            this.println("\t" + tipo_variavel + " " + v.getText() + ";");
        }
        return "";
    }

    // Método que visita o corpo do programa, sendo primeiro as declarações locais e posteriormente os comandos
    @Override
    public String visitCorpo(LAParser.CorpoContext ctx) {
        if (ctx != null) {
            this.visitDeclaracoes_locais(ctx.declaracoes_locais());
            this.visitComandos(ctx.comandos());
        }
        return "";
    }

    // Método que visita comandos individuais, dada uma lista de comandos
    @Override
    public String visitComandos(LAParser.ComandosContext ctx) {
        if (ctx != null) {
            for (LAParser.CmdContext comando : ctx.cmd()) {
                this.visitCmd(comando);
            }
        }
        return "";
    }

    // Método que visita comandos individuais, de acordo com seu tipo
    @Override
    public String visitCmd(LAParser.CmdContext ctx) {
        if (ctx != null) {
            switch (ctx.tipoCmd) {
                case LEIA:
                    if (ctx.tipo_variavel.compareTo(LITERAL) == 0) { // trata o caso de literais
                        this.println("\tgets(" + ctx.nome_variavel + ");");
                    } else { // trata o caso de demais variáveis de outros tipos
                        this.print("\tscanf(\"");
                        this.print((ctx.tipo_variavel.compareTo(INTEIRO) == 0) ? "%d" : "%f");
                        this.println("\", &" + ctx.nome_variavel + ");");

                        if (ctx.mais_ident() != null) {
                            for (LAParser.IdentificadorContext identificador : ctx.mais_ident().identificador()) {
                                this.print(", &" + identificador.nome_variavel);
                            }
                        }
                    }
                    break;
                case ESCREVA:
                    this.print("\tprintf(\"" + ((ctx.tipo_variavel.compareTo(LITERAL) == 0) ?
                            "%s" : (ctx.tipo_variavel.compareTo(INTEIRO) == 0) ? "%d" :
                            (ctx.tipo_variavel.compareTo(REAL) == 0) ? "%f" : "%s"));
                    this.println("\", " + this.visitExpressao(ctx.expressao()) + ");");

                    String[] mais_expressoes = this.visitMais_expressao_aux(ctx.mais_expressao());

                    for (int i = 0; i < mais_expressoes.length; i++) {
                        String tipo = ctx.mais_expressao().tipos.get(i);

                        this.print("\tprintf(\"" +
                                ((tipo.compareTo(LITERAL) == 0) ? "%s" :
                                        (tipo.compareTo(REAL) == 0) ? "%f" : "%d") + "\", " + mais_expressoes[i] + ");\n");
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
                    this.println("\tswitch (" + this.visitExp_aritmetica(ctx.exp_aritmetica(0)) + ") {");
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
                    this.println("\tfor (" + ctx.nome_variavel + " = " + this.visitExp_aritmetica(ctx.exp_aritmetica(0)) +
                            "; " + ctx.nome_variavel + " <= " + this.visitExp_aritmetica(ctx.exp_aritmetica(1)) + "; " +
                            ctx.nome_variavel + "++) {");
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
                case PONTEIRO:
                    this.println("*" + ctx.IDENT().getText() + this.visitOutros_ident(ctx.outros_ident()) +
                            this.visitDimensao(ctx.dimensao()) + " = " + this.visitExpressao(ctx.expressao()) + ";");
                    break;
                case CHAMADA: // chamada de função ou procedimento
                    this.print(ctx.IDENT().getText());
                    this.visitChamada(ctx.chamada());
                    this.println(";");
                    break;
                case ATRIBUICAO: // atribuição de variável
                    if (ctx.atribuicao().type.compareTo(LITERAL) != 0) { // Variável não é do tipo literal
                        this.print("\t" + ctx.IDENT().getText());
                        this.visitAtribuicao(ctx.atribuicao());
                        this.println(";");
                    } else { // Variável é literal, atribuição deve ser com strcpy
                        this.println("\tstrcpy(" + ctx.IDENT().getText() + this.visitOutros_ident(ctx.atribuicao().outros_ident()) +
                                this.visitDimensao(ctx.dimensao()) + ", " +
                                this.visitExpressao(ctx.atribuicao().expressao()) + ");");
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

    // Método que adiciona os asteriscos que indicam que uma variável é um ponteiro
    @Override
    public String visitPonteiros_opcionais(LAParser.Ponteiros_opcionaisContext ctx) {
        this.print(ctx.ponteiros + " ");
        return "";
    }

    // Método que verifica se uma variável possui outros identificadores (caso dos registros)
    @Override
    public String visitOutros_ident(LAParser.Outros_identContext ctx) {
        String outros_identificadores = "";
        if (ctx != null) {
            List<TerminalNode> identificadores = ctx.IDENT();
            List<LAParser.DimensaoContext> dimensao = ctx.dimensao();

            for (int i = 0; i < identificadores.size(); i++) {
                outros_identificadores += "." + identificadores.get(i).getText() + this.visitDimensao(dimensao.get(i));
            }
        }
        return outros_identificadores;
    }

    // Método que verifica a dimensão de uma variável (no caso, vetores)
    @Override
    public String visitDimensao(LAParser.DimensaoContext ctx) {
        String dimensao = "";
        if (ctx != null) {
            for (LAParser.Exp_aritmeticaContext exp : ctx.exp_aritmetica()) {
                dimensao += "[" + this.visitExp_aritmetica(exp) + "]";
            }
        }
        return dimensao;
    }

    // Método que visita tipos customizados
    @Override
    public String visitTipo(LAParser.TipoContext ctx) {
        return this.visitRegistro(ctx.registro());
    }

    // Método que verifica o tipo de uma variável, quando esta é de um tipo básico (literal, real, inteiro)
    @Override
    public String visitTipo_basico(LAParser.Tipo_basicoContext ctx) {
        this.print((ctx.tipodado.compareTo(LITERAL) == 0) ? "char*" : this.getTipoDeDadoEmC(ctx.tipodado));
        return "";
    }

    // Método que visita os identificadores de forma a obter seus tipos
    @Override
    public String visitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx) {
        return this.visitTipo_basico(ctx.tipo_basico());
    }

    // Método que visita os identificadores e verifica se os mesmos são ponteiros
    @Override
    public String visitTipo_estendido(LAParser.Tipo_estendidoContext ctx) {
        this.visitTipo_basico_ident(ctx.tipo_basico_ident());
        this.visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        return "";
    }

    // Método que obtém o valor de uma constante
    @Override
    public String visitValor_constante(LAParser.Valor_constanteContext ctx) {
        return ctx.getText();
    }

    // Método que visita cada uma das variáveis de um registro
    @Override
    public String visitRegistro(LAParser.RegistroContext ctx) {
        for (LAParser.Variavel_registroContext variavel : ctx.variavel_registro()) {
            this.visitVariavel_registro(variavel);
        }
        return "";
    }

    // Método que converte para C cada uma variável de registro
    @Override
    public String visitVariavel_registro(LAParser.Variavel_registroContext ctx) {
        this.println("\t\t" + this.getTipoDeDadoEmC(ctx.tipo.tipodado) + " " + ctx.IDENT().getText() +
                ((ctx.tipo.tipodado.compareTo(LITERAL) == 0) ? "[100]" : "") + ";");
        return "";
    }

    // Método que verifica se uma função ou procedimento possui parâmetros. Se possuir, visita-os
    @Override
    public String visitParametros_opcional(LAParser.Parametros_opcionalContext ctx) {
        return (ctx.parametro() != null) ? this.visitParametro(ctx.parametro()) : "";
    }

    // Método que visita os parâmetros de uma função ou procedimento
    @Override
    public String visitParametro(LAParser.ParametroContext ctx) {
        this.visitTipo_estendido(ctx.tipo_estendido());
        this.visitIdent_param(ctx.ident_param());
        return "";
    }

    // Método que visita os identificadores de um parâmetro e se eles são ponteiros
    @Override
    public String visitIdent_param(LAParser.Ident_paramContext ctx) {
        this.visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        this.print(ctx.IDENT().getText() + this.visitDimensao(ctx.dimensao()) + this.visitOutros_ident(ctx.outros_ident()));
        return "";
    }

    // NÃO REMOVER
    // Este método, embora apenas retorne uma string vazia, é MUITO IMPORTANTE!
    // Ele evita que os argumentos de uma chamada de função ou procedimento não terminem com o texto "null"
    @Override
    public String visitMais_expressao(LAParser.Mais_expressaoContext ctx) {
        return "";
    }

    // Este método é uma pequena modificação do visitMais_expressao. 
    // Para facilitar a geração de código, um vetor de strings é retornado com código C para cada uma das possíveis 
    // mais expressões encontradas
    public String[] visitMais_expressao_aux(LAParser.Mais_expressaoContext ctx) {
        String[] mais_expressoes = new String[ctx.expressao().size()];
        int i = 0;

        for (LAParser.ExpressaoContext expressao : ctx.expressao()) {
            mais_expressoes[i++] = this.visitExpressao(expressao);
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
        return (ctx.selecao() != null) ? this.visitSelecao(ctx.selecao()) : "";
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

        for (LAParser.Op_adicaoContext operador : ctx.op_adicao()) {
            outros_termos += " " + this.visitOp_adicao(operador) + " " + this.visitTermo(ctx.termo().get(i++));
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

        for (LAParser.Op_multiplicacaoContext operador : ctx.op_multiplicacao()) {
            outros_fatores += this.visitOp_multiplicacao(operador) + this.visitFator(ctx.fator().get(i++));
        }
        return outros_fatores;
    }

    @Override
    public String visitParcela(LAParser.ParcelaContext ctx) {
        return (ctx.tipo_parcela == PARCELA_UNARIO) ? this.visitOp_unario(ctx.op_unario()) + this.visitParcela_unario(ctx.parcela_unario()) :
                this.visitParcela_nao_unario(ctx.parcela_nao_unario());
    }

    @Override
    public String visitParcela_unario(LAParser.Parcela_unarioContext ctx) {
        if (ctx.tipo_parcela_unario.compareTo("PONTEIRO") == 0) {
            return "* " + ctx.IDENT().getText() + this.visitOutros_ident(ctx.outros_ident()) + this.visitDimensao(ctx.dimensao());
        } else if (ctx.tipo_parcela_unario.compareTo("CHAMADA") == 0) {
            return ctx.IDENT().getText() +
                    ((ctx.chamada_partes().tipoChamada == 1) ?
                            "(" + this.visitExpressao(ctx.chamada_partes().expressao()) +
                            this.visitMais_expressao(ctx.chamada_partes().mais_expressao()) + ")" :
                            ((ctx.chamada_partes().tipoChamada == 2)
                                    ? this.visitOutros_ident(ctx.chamada_partes().outros_ident()) +
                                    this.visitDimensao(ctx.chamada_partes().dimensao()) : ""));
        } else if (ctx.tipo_parcela_unario.compareTo("INTEIRO") == 0) {
            return ctx.NUM_INT.getText();
        } else if (ctx.tipo_parcela_unario.compareTo("REAL") == 0) {
            return ctx.NUM_REAL.getText();
        } else if (ctx.tipo_parcela_unario.compareTo("EXPRESSAO") == 0) {
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

        for (LAParser.ParcelaContext parcela : ctx.parcela()) {
            outras_parcelas += "% " + this.visitParcela(parcela);
        }
        return outras_parcelas;
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
        return (ctx != null) ? this.visitTermo_logico(ctx.termo_logico()) +
                this.visitOutros_termos_logicos(ctx.outros_termos_logicos()) : "";
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
        return (ctx.tipo_parcela_logica.compareTo("verdadeiro") == 0) ?
                "true" : ((ctx.tipo_parcela_logica.compareTo("falso") == 0) ?
                "false" : this.visitExp_relacional(ctx.exp_relacional()));
    }

    @Override
    public String toString() {
        return this.codigo_c;
    }
}