/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufscar.compiladores2.t1;

import java.util.BitSet;
import jdk.nashorn.internal.parser.TokenType;
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
public class MeuErrorListener implements ANTLRErrorListener {

    OutputBuffer sp;

    public MeuErrorListener(OutputBuffer sp) {
        this.sp = sp;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        Token tk = (Token)o;
        String text = tk.getText();
        if (text.contentEquals("<EOF>"))
            text = "EOF";
        sp.println("Linha "+i+": erro sintatico proximo a "+text);
        throw new ParseCancellationException();
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {
        //sp.println("Ambiguidade!");
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {
    }

}
