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
            // Arquivos que serão utilizados pelo corretor automático
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

            OutputBuffer erros_sintaticos = new OutputBuffer();
            LACustomErrorListener error_listener = new LACustomErrorListener(erros_sintaticos);

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

            saida_parser += erros_sintaticos.toString();

            // Se saida_parser é uma string vazia neste momento, significa que não houveram erros sintáticos
            if(saida_parser.compareTo("") == 0) {
                // Com isso, verifica-se agora se existem erros semânticos
                if (Mensagens.getText().compareTo("") != 0) {
                    // Erros semânticos :-(
                    String erros_semanticos = Mensagens.getText();
                    saida_parser += erros_semanticos;
                    saida_parser += "Fim da compilacao\n";
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
                TestaGeradorDeCodigoC.testaGeradorDeCodigoC();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
