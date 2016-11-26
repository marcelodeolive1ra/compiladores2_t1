/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author marcelodeoliveiradasilva
 */
public class LACustomErrorListener implements ANTLRErrorListener {

    OutputBuffer erros_sintaticos;

    public LACustomErrorListener(OutputBuffer erros_sintaticos) {
        this.erros_sintaticos = erros_sintaticos;
    }

    @Override
    public String toString() {
        return this.erros_sintaticos.toString();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        Token tk = (Token)o;
        String text = tk.getText();
        if (text.contentEquals("<EOF>")) {
            text = "EOF";
        }
        this.erros_sintaticos.println("Linha "+i+": erro sintatico proximo a "+text);

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
