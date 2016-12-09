package ufscar.compiladores2.t1;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.ParseCancellationException;

// Classe que adiciona no arquivo de saída eventuais erros sintáticos do programa

public class ErrosSintaticosErrorListener implements ANTLRErrorListener {

    private String erros_sintaticos;

    public ErrosSintaticosErrorListener() {
        this.erros_sintaticos = "";
    }

    public String getErrosSintaticos() {
        return this.erros_sintaticos;
    }

    //Trata o caso de <EOF> e adiciona uma exceção no programa para parar a execução após a impressão do erro
    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        Token token = (Token)o;
        String texto_do_token = token.getText();
        if (texto_do_token.contentEquals("<EOF>")) {
            texto_do_token = "EOF";
        }
        this.erros_sintaticos += "Linha " + i +": erro sintatico proximo a " + texto_do_token + "\n";

        throw new ParseCancellationException();
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {
    }
}
