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

        // Arquivos que serão utilizados pelo corretor automático
//        File entrada = new File(args[0]);
//        File saida = new File(args[1]);
//
//        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(entrada));
//        LALexer lexer = new LALexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        LAParser parser = new LAParser(tokens);
//
//        // Registro do nosso Error Listener para customização das mensagens de erro
//        parser.removeErrorListeners();
//        OutputBuffer sp = new OutputBuffer();
//        MeuErrorListener mel = new MeuErrorListener(sp);
//        parser.addErrorListener(mel);
//        try {
//            parser.programa();
//        } catch(ParseCancellationException pce) {
//            if (pce.getMessage() != null)
//                sp.println(pce.getMessage());
//        }
//        String erros_semanticos = Mensagens.getText();
//        if(!sp.isModificado())
//            sp.print(erros_semanticos);
//        sp.println("Fim da compilacao");
//
//        PrintWriter pw = new PrintWriter(saida);
//        pw.print(sp.toString());
//        pw.flush();
//        pw.close();

        try {
            TestaGeradorDeCodigoC.testaGeradorDeCodigoC();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
