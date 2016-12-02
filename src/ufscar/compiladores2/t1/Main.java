package ufscar.compiladores2.t1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            // Arquivos de entrada (programa em linguagem LA) e saída (código C ou relatório de erros)
            File arquivo_entrada = new File(args[0]);
            File arquivo_saida = new File(args[1]);

            ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(arquivo_entrada));

            // Análise Léxica
            LALexer lexer = new LALexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Análise Sintática
            LAParser parser = new LAParser(tokens);

            // Registro do nosso Error Listener para customização das mensagens de erros sintáticos
            parser.removeErrorListeners();

            LACustomErrorListener error_listener = new LACustomErrorListener();

            parser.addErrorListener(error_listener);

            // String que armazenará em memória o conteúdo do arquivo de saída (código C ou listagem de erros)
            String saida_parser = "";

            LAParser.ProgramaContext programa = null;
            try {
                programa = parser.programa();
            } catch (ParseCancellationException e) {
                if (e.getMessage() != null) {
                    saida_parser += e.getMessage() + "\n";
                }
            }

            saida_parser += error_listener.getErrosSintaticos();

            // Se saida_parser é uma string vazia neste momento, significa que não houveram erros sintáticos
            if(saida_parser.compareTo("") == 0) {
                // Com isso, verifica-se agora se existem erros semânticos
                if (Mensagens.getErrosSemanticos().compareTo("") != 0) {
                    // Erros semânticos :-(
                    saida_parser += Mensagens.getErrosSemanticos() + "Fim da compilacao\n";
                } else {
                    // Sem erros semânticos :-)
                    // Geração de código C
                    GeradorDeCodigoC gerador = new GeradorDeCodigoC();
                    gerador.visitPrograma(programa);
                    saida_parser += gerador.toString();
                }
            } else {
                saida_parser += "Fim da compilacao\n"; // Erros sintáticos :-(
            }

            // Escrita do arquivo de saída com listagem de erros ou código C
            PrintWriter pw = new PrintWriter(arquivo_saida);
            pw.print(saida_parser);
            pw.flush();
            pw.close();
        } else {
            // Parte do código utilizada para testes do gerador de código durante o desenvolvimento
            try {
                GeradorDeCodigoC.testaGeradorDeCodigoC();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
