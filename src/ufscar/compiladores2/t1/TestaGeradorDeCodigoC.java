package ufscar.compiladores2.t1;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by marcelodeoliveiradasilva on 19/11/16.
 */
public class TestaGeradorDeCodigoC {

    public static void testaGeradorDeCodigoC() throws Exception {
        //String entrada = "/Users/marcelodeoliveiradasilva/Desktop/LACompiler/casosDeTeste/entrada/casoDeTeste01.txt";
        //String entrada = "/Users/ViniciusBarbosa/Downloads/T2/T2/T2/src/trabalho2/casosDeTeste/entrada/casoDeTeste01.txt";
        String entrada = "/Users/gustavoB/vai/casosDeTesteT1/entrada/casoDeTeste01.txt";
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(entrada));
        LALexer lexer = new LALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LAParser parser = new LAParser(tokens);
        ParseTree tree = parser.programa();

        GeradorDeCodigoC codigo_c = new GeradorDeCodigoC();

        codigo_c.visit(tree);

        System.out.println(codigo_c);
    }
}
