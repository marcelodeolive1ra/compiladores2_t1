// Generated from /Users/marcelodeoliveiradasilva/Desktop/T1_CC2_IntelliJ/src/ufscar/compiladores2/t1/LA.g4 by ANTLR 4.5.3
package ufscar.compiladores2.t1;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		IDENT=60, NUM_INT=61, NUM_REAL=62, CADEIA=63, COMENTARIO=64, ESPACO=65, 
		IDENT_ERRADO=66, NUM_ERRADO=67, COMENTARIO_ERRADO=68, ERROR=69;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
		"T__57", "T__58", "IDENT", "NUM_INT", "NUM_REAL", "CADEIA", "COMENTARIO", 
		"ESPACO", "IDENT_ERRADO", "NUM_ERRADO", "COMENTARIO_ERRADO", "ERROR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'constante'", "':'", 
		"'='", "'tipo'", "','", "'^'", "'.'", "'['", "']'", "'literal'", "'inteiro'", 
		"'real'", "'logico'", "'verdadeiro'", "'falso'", "'registro'", "'fim_registro'", 
		"'procedimento'", "'('", "')'", "'fim_procedimento'", "'funcao'", "'fim_funcao'", 
		"'var'", "'leia'", "'escreva'", "'se'", "'entao'", "'fim_se'", "'caso'", 
		"'seja'", "'fim_caso'", "'para'", "'<-'", "'ate'", "'faca'", "'fim_para'", 
		"'enquanto'", "'fim_enquanto'", "'retorne'", "'senao'", "'..'", "'-'", 
		"'*'", "'/'", "'+'", "'&'", "'%'", "'<>'", "'>='", "'<='", "'>'", "'<'", 
		"'nao'", "'ou'", "'e'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"IDENT", "NUM_INT", "NUM_REAL", "CADEIA", "COMENTARIO", "ESPACO", "IDENT_ERRADO", 
		"NUM_ERRADO", "COMENTARIO_ERRADO", "ERROR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	    static String grupo = "<488950, 489085, 489093, 489182>";
	    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
	    private final String GLOBAL = "global";
	    private final int VARIAVEL = 1;
	    private final int CONSTANTE = 2;
	    private final int TIPO = 3;
	    private final int PARCELA_UNARIO = 1;
	    private final int PARCELA_NAO_UNARIO = 2;
	    private final int LEIA = 1, ESCREVA = 2, SE = 3, CASO = 4, PARA = 5, ENQUANTO = 6, FACA = 7, PONTEIRO = 8,
	            CHAMADA = 9, ATRIBUICAO = 10, RETORNE = 11;

	    private void stop(String msg) {
	        throw new ParseCancellationException(msg);
	    }


	public LALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 63:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 64:
			ESPACO_action((RuleContext)_localctx, actionIndex);
			break;
		case 65:
			IDENT_ERRADO_action((RuleContext)_localctx, actionIndex);
			break;
		case 66:
			NUM_ERRADO_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			COMENTARIO_ERRADO_action((RuleContext)_localctx, actionIndex);
			break;
		case 68:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			        skip();
			    
			break;
		}
	}
	private void ESPACO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			        skip();
			    
			break;
		}
	}
	private void IDENT_ERRADO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

			        stop("Linha " + getLine() + ": erro sintatico proximo a )");
			    
			break;
		}
	}
	private void NUM_ERRADO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:

			        String variavel = getText().replaceAll("[0-9]","");
			        stop("Linha " + getLine() + ": erro sintatico proximo a " + variavel);
			    
			break;
		}
	}
	private void COMENTARIO_ERRADO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:

			        stop("Linha " + getLine() + ": comentario nao fechado");
			    
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:

			        stop("Linha " + getLine() + ": " + getText() + " - simbolo nao identificado");
			    
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2G\u0223\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3"+
		"8\38\39\39\3:\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\7=\u01db\n=\f=\16=\u01de\13"+
		"=\3>\6>\u01e1\n>\r>\16>\u01e2\3?\6?\u01e6\n?\r?\16?\u01e7\3?\3?\6?\u01ec"+
		"\n?\r?\16?\u01ed\3@\3@\7@\u01f2\n@\f@\16@\u01f5\13@\3@\3@\3A\3A\7A\u01fb"+
		"\nA\fA\16A\u01fe\13A\3A\3A\3A\3B\3B\3B\3C\3C\3C\3C\3C\3D\6D\u020c\nD\r"+
		"D\16D\u020d\3D\6D\u0211\nD\rD\16D\u0212\3D\3D\3E\3E\7E\u0219\nE\fE\16"+
		"E\u021c\13E\3E\3E\3E\3F\3F\3F\2\2G\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008bG\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\5\2\f\f"+
		"\17\17$$\4\2\f\f\177\177\5\2\13\f\17\17\"\"\u022b\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3"+
		"\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u0097\3\2\2\2"+
		"\7\u00a5\3\2\2\2\t\u00ad\3\2\2\2\13\u00b7\3\2\2\2\r\u00b9\3\2\2\2\17\u00bb"+
		"\3\2\2\2\21\u00c0\3\2\2\2\23\u00c2\3\2\2\2\25\u00c4\3\2\2\2\27\u00c6\3"+
		"\2\2\2\31\u00c8\3\2\2\2\33\u00ca\3\2\2\2\35\u00d2\3\2\2\2\37\u00da\3\2"+
		"\2\2!\u00df\3\2\2\2#\u00e6\3\2\2\2%\u00f1\3\2\2\2\'\u00f7\3\2\2\2)\u0100"+
		"\3\2\2\2+\u010d\3\2\2\2-\u011a\3\2\2\2/\u011c\3\2\2\2\61\u011e\3\2\2\2"+
		"\63\u012f\3\2\2\2\65\u0136\3\2\2\2\67\u0141\3\2\2\29\u0145\3\2\2\2;\u014a"+
		"\3\2\2\2=\u0152\3\2\2\2?\u0155\3\2\2\2A\u015b\3\2\2\2C\u0162\3\2\2\2E"+
		"\u0167\3\2\2\2G\u016c\3\2\2\2I\u0175\3\2\2\2K\u017a\3\2\2\2M\u017d\3\2"+
		"\2\2O\u0181\3\2\2\2Q\u0186\3\2\2\2S\u018f\3\2\2\2U\u0198\3\2\2\2W\u01a5"+
		"\3\2\2\2Y\u01ad\3\2\2\2[\u01b3\3\2\2\2]\u01b6\3\2\2\2_\u01b8\3\2\2\2a"+
		"\u01ba\3\2\2\2c\u01bc\3\2\2\2e\u01be\3\2\2\2g\u01c0\3\2\2\2i\u01c2\3\2"+
		"\2\2k\u01c5\3\2\2\2m\u01c8\3\2\2\2o\u01cb\3\2\2\2q\u01cd\3\2\2\2s\u01cf"+
		"\3\2\2\2u\u01d3\3\2\2\2w\u01d6\3\2\2\2y\u01d8\3\2\2\2{\u01e0\3\2\2\2}"+
		"\u01e5\3\2\2\2\177\u01ef\3\2\2\2\u0081\u01f8\3\2\2\2\u0083\u0202\3\2\2"+
		"\2\u0085\u0205\3\2\2\2\u0087\u020b\3\2\2\2\u0089\u0216\3\2\2\2\u008b\u0220"+
		"\3\2\2\2\u008d\u008e\7c\2\2\u008e\u008f\7n\2\2\u008f\u0090\7i\2\2\u0090"+
		"\u0091\7q\2\2\u0091\u0092\7t\2\2\u0092\u0093\7k\2\2\u0093\u0094\7v\2\2"+
		"\u0094\u0095\7o\2\2\u0095\u0096\7q\2\2\u0096\4\3\2\2\2\u0097\u0098\7h"+
		"\2\2\u0098\u0099\7k\2\2\u0099\u009a\7o\2\2\u009a\u009b\7a\2\2\u009b\u009c"+
		"\7c\2\2\u009c\u009d\7n\2\2\u009d\u009e\7i\2\2\u009e\u009f\7q\2\2\u009f"+
		"\u00a0\7t\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7o\2\2"+
		"\u00a3\u00a4\7q\2\2\u00a4\6\3\2\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7\7g"+
		"\2\2\u00a7\u00a8\7e\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab"+
		"\7t\2\2\u00ab\u00ac\7g\2\2\u00ac\b\3\2\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af"+
		"\7q\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7v\2\2\u00b2"+
		"\u00b3\7c\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\n\3\2\2\2\u00b7\u00b8\7<\2\2\u00b8\f\3\2\2\2\u00b9\u00ba\7?\2\2"+
		"\u00ba\16\3\2\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7"+
		"r\2\2\u00be\u00bf\7q\2\2\u00bf\20\3\2\2\2\u00c0\u00c1\7.\2\2\u00c1\22"+
		"\3\2\2\2\u00c2\u00c3\7`\2\2\u00c3\24\3\2\2\2\u00c4\u00c5\7\60\2\2\u00c5"+
		"\26\3\2\2\2\u00c6\u00c7\7]\2\2\u00c7\30\3\2\2\2\u00c8\u00c9\7_\2\2\u00c9"+
		"\32\3\2\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7v\2\2\u00cd"+
		"\u00ce\7g\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7n\2\2"+
		"\u00d1\34\3\2\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7"+
		"v\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9"+
		"\7q\2\2\u00d9\36\3\2\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd"+
		"\7c\2\2\u00dd\u00de\7n\2\2\u00de \3\2\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1"+
		"\7q\2\2\u00e1\u00e2\7i\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7e\2\2\u00e4"+
		"\u00e5\7q\2\2\u00e5\"\3\2\2\2\u00e6\u00e7\7x\2\2\u00e7\u00e8\7g\2\2\u00e8"+
		"\u00e9\7t\2\2\u00e9\u00ea\7f\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7f\2\2"+
		"\u00ec\u00ed\7g\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0"+
		"\7q\2\2\u00f0$\3\2\2\2\u00f1\u00f2\7h\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4"+
		"\7n\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7q\2\2\u00f6&\3\2\2\2\u00f7\u00f8"+
		"\7t\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7i\2\2\u00fa\u00fb\7k\2\2\u00fb"+
		"\u00fc\7u\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7q\2\2"+
		"\u00ff(\3\2\2\2\u0100\u0101\7h\2\2\u0101\u0102\7k\2\2\u0102\u0103\7o\2"+
		"\2\u0103\u0104\7a\2\2\u0104\u0105\7t\2\2\u0105\u0106\7g\2\2\u0106\u0107"+
		"\7i\2\2\u0107\u0108\7k\2\2\u0108\u0109\7u\2\2\u0109\u010a\7v\2\2\u010a"+
		"\u010b\7t\2\2\u010b\u010c\7q\2\2\u010c*\3\2\2\2\u010d\u010e\7r\2\2\u010e"+
		"\u010f\7t\2\2\u010f\u0110\7q\2\2\u0110\u0111\7e\2\2\u0111\u0112\7g\2\2"+
		"\u0112\u0113\7f\2\2\u0113\u0114\7k\2\2\u0114\u0115\7o\2\2\u0115\u0116"+
		"\7g\2\2\u0116\u0117\7p\2\2\u0117\u0118\7v\2\2\u0118\u0119\7q\2\2\u0119"+
		",\3\2\2\2\u011a\u011b\7*\2\2\u011b.\3\2\2\2\u011c\u011d\7+\2\2\u011d\60"+
		"\3\2\2\2\u011e\u011f\7h\2\2\u011f\u0120\7k\2\2\u0120\u0121\7o\2\2\u0121"+
		"\u0122\7a\2\2\u0122\u0123\7r\2\2\u0123\u0124\7t\2\2\u0124\u0125\7q\2\2"+
		"\u0125\u0126\7e\2\2\u0126\u0127\7g\2\2\u0127\u0128\7f\2\2\u0128\u0129"+
		"\7k\2\2\u0129\u012a\7o\2\2\u012a\u012b\7g\2\2\u012b\u012c\7p\2\2\u012c"+
		"\u012d\7v\2\2\u012d\u012e\7q\2\2\u012e\62\3\2\2\2\u012f\u0130\7h\2\2\u0130"+
		"\u0131\7w\2\2\u0131\u0132\7p\2\2\u0132\u0133\7e\2\2\u0133\u0134\7c\2\2"+
		"\u0134\u0135\7q\2\2\u0135\64\3\2\2\2\u0136\u0137\7h\2\2\u0137\u0138\7"+
		"k\2\2\u0138\u0139\7o\2\2\u0139\u013a\7a\2\2\u013a\u013b\7h\2\2\u013b\u013c"+
		"\7w\2\2\u013c\u013d\7p\2\2\u013d\u013e\7e\2\2\u013e\u013f\7c\2\2\u013f"+
		"\u0140\7q\2\2\u0140\66\3\2\2\2\u0141\u0142\7x\2\2\u0142\u0143\7c\2\2\u0143"+
		"\u0144\7t\2\2\u01448\3\2\2\2\u0145\u0146\7n\2\2\u0146\u0147\7g\2\2\u0147"+
		"\u0148\7k\2\2\u0148\u0149\7c\2\2\u0149:\3\2\2\2\u014a\u014b\7g\2\2\u014b"+
		"\u014c\7u\2\2\u014c\u014d\7e\2\2\u014d\u014e\7t\2\2\u014e\u014f\7g\2\2"+
		"\u014f\u0150\7x\2\2\u0150\u0151\7c\2\2\u0151<\3\2\2\2\u0152\u0153\7u\2"+
		"\2\u0153\u0154\7g\2\2\u0154>\3\2\2\2\u0155\u0156\7g\2\2\u0156\u0157\7"+
		"p\2\2\u0157\u0158\7v\2\2\u0158\u0159\7c\2\2\u0159\u015a\7q\2\2\u015a@"+
		"\3\2\2\2\u015b\u015c\7h\2\2\u015c\u015d\7k\2\2\u015d\u015e\7o\2\2\u015e"+
		"\u015f\7a\2\2\u015f\u0160\7u\2\2\u0160\u0161\7g\2\2\u0161B\3\2\2\2\u0162"+
		"\u0163\7e\2\2\u0163\u0164\7c\2\2\u0164\u0165\7u\2\2\u0165\u0166\7q\2\2"+
		"\u0166D\3\2\2\2\u0167\u0168\7u\2\2\u0168\u0169\7g\2\2\u0169\u016a\7l\2"+
		"\2\u016a\u016b\7c\2\2\u016bF\3\2\2\2\u016c\u016d\7h\2\2\u016d\u016e\7"+
		"k\2\2\u016e\u016f\7o\2\2\u016f\u0170\7a\2\2\u0170\u0171\7e\2\2\u0171\u0172"+
		"\7c\2\2\u0172\u0173\7u\2\2\u0173\u0174\7q\2\2\u0174H\3\2\2\2\u0175\u0176"+
		"\7r\2\2\u0176\u0177\7c\2\2\u0177\u0178\7t\2\2\u0178\u0179\7c\2\2\u0179"+
		"J\3\2\2\2\u017a\u017b\7>\2\2\u017b\u017c\7/\2\2\u017cL\3\2\2\2\u017d\u017e"+
		"\7c\2\2\u017e\u017f\7v\2\2\u017f\u0180\7g\2\2\u0180N\3\2\2\2\u0181\u0182"+
		"\7h\2\2\u0182\u0183\7c\2\2\u0183\u0184\7e\2\2\u0184\u0185\7c\2\2\u0185"+
		"P\3\2\2\2\u0186\u0187\7h\2\2\u0187\u0188\7k\2\2\u0188\u0189\7o\2\2\u0189"+
		"\u018a\7a\2\2\u018a\u018b\7r\2\2\u018b\u018c\7c\2\2\u018c\u018d\7t\2\2"+
		"\u018d\u018e\7c\2\2\u018eR\3\2\2\2\u018f\u0190\7g\2\2\u0190\u0191\7p\2"+
		"\2\u0191\u0192\7s\2\2\u0192\u0193\7w\2\2\u0193\u0194\7c\2\2\u0194\u0195"+
		"\7p\2\2\u0195\u0196\7v\2\2\u0196\u0197\7q\2\2\u0197T\3\2\2\2\u0198\u0199"+
		"\7h\2\2\u0199\u019a\7k\2\2\u019a\u019b\7o\2\2\u019b\u019c\7a\2\2\u019c"+
		"\u019d\7g\2\2\u019d\u019e\7p\2\2\u019e\u019f\7s\2\2\u019f\u01a0\7w\2\2"+
		"\u01a0\u01a1\7c\2\2\u01a1\u01a2\7p\2\2\u01a2\u01a3\7v\2\2\u01a3\u01a4"+
		"\7q\2\2\u01a4V\3\2\2\2\u01a5\u01a6\7t\2\2\u01a6\u01a7\7g\2\2\u01a7\u01a8"+
		"\7v\2\2\u01a8\u01a9\7q\2\2\u01a9\u01aa\7t\2\2\u01aa\u01ab\7p\2\2\u01ab"+
		"\u01ac\7g\2\2\u01acX\3\2\2\2\u01ad\u01ae\7u\2\2\u01ae\u01af\7g\2\2\u01af"+
		"\u01b0\7p\2\2\u01b0\u01b1\7c\2\2\u01b1\u01b2\7q\2\2\u01b2Z\3\2\2\2\u01b3"+
		"\u01b4\7\60\2\2\u01b4\u01b5\7\60\2\2\u01b5\\\3\2\2\2\u01b6\u01b7\7/\2"+
		"\2\u01b7^\3\2\2\2\u01b8\u01b9\7,\2\2\u01b9`\3\2\2\2\u01ba\u01bb\7\61\2"+
		"\2\u01bbb\3\2\2\2\u01bc\u01bd\7-\2\2\u01bdd\3\2\2\2\u01be\u01bf\7(\2\2"+
		"\u01bff\3\2\2\2\u01c0\u01c1\7\'\2\2\u01c1h\3\2\2\2\u01c2\u01c3\7>\2\2"+
		"\u01c3\u01c4\7@\2\2\u01c4j\3\2\2\2\u01c5\u01c6\7@\2\2\u01c6\u01c7\7?\2"+
		"\2\u01c7l\3\2\2\2\u01c8\u01c9\7>\2\2\u01c9\u01ca\7?\2\2\u01can\3\2\2\2"+
		"\u01cb\u01cc\7@\2\2\u01ccp\3\2\2\2\u01cd\u01ce\7>\2\2\u01cer\3\2\2\2\u01cf"+
		"\u01d0\7p\2\2\u01d0\u01d1\7c\2\2\u01d1\u01d2\7q\2\2\u01d2t\3\2\2\2\u01d3"+
		"\u01d4\7q\2\2\u01d4\u01d5\7w\2\2\u01d5v\3\2\2\2\u01d6\u01d7\7g\2\2\u01d7"+
		"x\3\2\2\2\u01d8\u01dc\t\2\2\2\u01d9\u01db\t\3\2\2\u01da\u01d9\3\2\2\2"+
		"\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01ddz\3"+
		"\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e1\4\62;\2\u01e0\u01df\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3|\3\2\2\2"+
		"\u01e4\u01e6\4\62;\2\u01e5\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e5"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\7\60\2\2"+
		"\u01ea\u01ec\4\62;\2\u01eb\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01eb"+
		"\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee~\3\2\2\2\u01ef\u01f3\7$\2\2\u01f0\u01f2"+
		"\n\4\2\2\u01f1\u01f0\3\2\2\2\u01f2\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3"+
		"\u01f4\3\2\2\2\u01f4\u01f6\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f7\7$"+
		"\2\2\u01f7\u0080\3\2\2\2\u01f8\u01fc\7}\2\2\u01f9\u01fb\n\5\2\2\u01fa"+
		"\u01f9\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2"+
		"\2\2\u01fd\u01ff\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u0200\7\177\2\2\u0200"+
		"\u0201\bA\2\2\u0201\u0082\3\2\2\2\u0202\u0203\t\6\2\2\u0203\u0204\bB\3"+
		"\2\u0204\u0084\3\2\2\2\u0205\u0206\7]\2\2\u0206\u0207\5y=\2\u0207\u0208"+
		"\7+\2\2\u0208\u0209\bC\4\2\u0209\u0086\3\2\2\2\u020a\u020c\4\62;\2\u020b"+
		"\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2"+
		"\2\2\u020e\u0210\3\2\2\2\u020f\u0211\t\2\2\2\u0210\u020f\3\2\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\3\2"+
		"\2\2\u0214\u0215\bD\5\2\u0215\u0088\3\2\2\2\u0216\u021a\7}\2\2\u0217\u0219"+
		"\n\5\2\2\u0218\u0217\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u0218\3\2\2\2\u021a"+
		"\u021b\3\2\2\2\u021b\u021d\3\2\2\2\u021c\u021a\3\2\2\2\u021d\u021e\7\f"+
		"\2\2\u021e\u021f\bE\6\2\u021f\u008a\3\2\2\2\u0220\u0221\13\2\2\2\u0221"+
		"\u0222\bF\7\2\u0222\u008c\3\2\2\2\f\2\u01dc\u01e2\u01e7\u01ed\u01f3\u01fc"+
		"\u020d\u0212\u021a\b\3A\2\3B\3\3C\4\3D\5\3E\6\3F\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}