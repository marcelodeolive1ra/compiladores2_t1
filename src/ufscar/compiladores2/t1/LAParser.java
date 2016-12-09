// Generated from /Users/marcelodeoliveiradasilva/Desktop/T1_CC2_IntelliJ/src/ufscar/compiladores2/t1/LA.g4 by ANTLR 4.5.3
package ufscar.compiladores2.t1;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LAParser extends Parser {
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
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_decl_local_global = 2, RULE_declaracao_local = 3, 
		RULE_variavel = 4, RULE_mais_var = 5, RULE_identificador = 6, RULE_ponteiros_opcionais = 7, 
		RULE_outros_ident = 8, RULE_dimensao = 9, RULE_tipo = 10, RULE_mais_ident = 11, 
		RULE_tipo_basico = 12, RULE_tipo_basico_ident = 13, RULE_tipo_estendido = 14, 
		RULE_valor_constante = 15, RULE_registro = 16, RULE_variavel_registro = 17, 
		RULE_mais_var_registro = 18, RULE_declaracao_global = 19, RULE_parametros_opcional = 20, 
		RULE_parametro = 21, RULE_ident_param = 22, RULE_mais_id_param = 23, RULE_var_opcional = 24, 
		RULE_mais_parametros = 25, RULE_declaracoes_locais = 26, RULE_corpo = 27, 
		RULE_comandos = 28, RULE_cmd = 29, RULE_mais_expressao = 30, RULE_senao_opcional = 31, 
		RULE_chamada = 32, RULE_atribuicao = 33, RULE_argumentos_opcional = 34, 
		RULE_selecao = 35, RULE_mais_selecao = 36, RULE_constantes = 37, RULE_mais_constantes = 38, 
		RULE_numero_intervalo = 39, RULE_intervalo_opcional = 40, RULE_op_unario = 41, 
		RULE_exp_aritmetica = 42, RULE_op_multiplicacao = 43, RULE_op_adicao = 44, 
		RULE_termo = 45, RULE_outros_termos = 46, RULE_fator = 47, RULE_outros_fatores = 48, 
		RULE_parcela = 49, RULE_parcela_unario = 50, RULE_parcela_nao_unario = 51, 
		RULE_outras_parcelas = 52, RULE_chamada_partes = 53, RULE_exp_relacional = 54, 
		RULE_op_opcional = 55, RULE_op_relacional = 56, RULE_expressao = 57, RULE_op_nao = 58, 
		RULE_termo_logico = 59, RULE_outros_termos_logicos = 60, RULE_outros_fatores_logicos = 61, 
		RULE_fator_logico = 62, RULE_parcela_logica = 63;
	public static final String[] ruleNames = {
		"programa", "declaracoes", "decl_local_global", "declaracao_local", "variavel", 
		"mais_var", "identificador", "ponteiros_opcionais", "outros_ident", "dimensao", 
		"tipo", "mais_ident", "tipo_basico", "tipo_basico_ident", "tipo_estendido", 
		"valor_constante", "registro", "variavel_registro", "mais_var_registro", 
		"declaracao_global", "parametros_opcional", "parametro", "ident_param", 
		"mais_id_param", "var_opcional", "mais_parametros", "declaracoes_locais", 
		"corpo", "comandos", "cmd", "mais_expressao", "senao_opcional", "chamada", 
		"atribuicao", "argumentos_opcional", "selecao", "mais_selecao", "constantes", 
		"mais_constantes", "numero_intervalo", "intervalo_opcional", "op_unario", 
		"exp_aritmetica", "op_multiplicacao", "op_adicao", "termo", "outros_termos", 
		"fator", "outros_fatores", "parcela", "parcela_unario", "parcela_nao_unario", 
		"outras_parcelas", "chamada_partes", "exp_relacional", "op_opcional", 
		"op_relacional", "expressao", "op_nao", "termo_logico", "outros_termos_logicos", 
		"outros_fatores_logicos", "fator_logico", "parcela_logica"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'constante'", "':'", 
		"'='", "'tipo'", "','", "'^'", "'.'", "'['", "']'", "'inteiro'", "'real'", 
		"'literal'", "'logico'", "'verdadeiro'", "'falso'", "'registro'", "'fim_registro'", 
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

	@Override
	public String getGrammarFileName() { return "LA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
	    private final int CHAMADA_EXPRESSAO = 1, CHAMADA_IDENTIFICADOR = 2, CHAMADA_VAZIA = 3;

	    private void stop(String msg) {
	        throw new ParseCancellationException(msg);
	    }

	public LAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LAParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 pilhaDeTabelas.empilhar(new TabelaDeSimbolos(GLOBAL)); 
			setState(129);
			declaracoes();
			setState(130);
			match(T__0);
			setState(131);
			corpo();
			setState(132);
			match(T__1);
			setState(133);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesContext extends ParserRuleContext {
		public List<Decl_local_globalContext> decl_local_global() {
			return getRuleContexts(Decl_local_globalContext.class);
		}
		public Decl_local_globalContext decl_local_global(int i) {
			return getRuleContext(Decl_local_globalContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__6) | (1L << T__20) | (1L << T__24))) != 0)) {
				{
				{
				setState(135);
				decl_local_global();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_local_globalContext extends ParserRuleContext {
		public Declaracao_localContext declaracao_local() {
			return getRuleContext(Declaracao_localContext.class,0);
		}
		public Declaracao_globalContext declaracao_global() {
			return getRuleContext(Declaracao_globalContext.class,0);
		}
		public Decl_local_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_local_global; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDecl_local_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_local_globalContext decl_local_global() throws RecognitionException {
		Decl_local_globalContext _localctx = new Decl_local_globalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_local_global);
		try {
			setState(143);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				declaracao_local();
				}
				break;
			case T__20:
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				declaracao_global();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracao_localContext extends ParserRuleContext {
		public int tipo_declaracao;
		public String nome;
		public String tipo_variavel;
		public VariavelContext variavel;
		public Token IDENT;
		public Tipo_basicoContext tipo_basico;
		public TipoContext tipo;
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public Valor_constanteContext valor_constante() {
			return getRuleContext(Valor_constanteContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Declaracao_localContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_local; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_local(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_localContext declaracao_local() throws RecognitionException {
		Declaracao_localContext _localctx = new Declaracao_localContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao_local);
		try {
			setState(163);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(T__2);
				setState(146);
				((Declaracao_localContext)_localctx).variavel = variavel();

				        ((Declaracao_localContext)_localctx).tipo_declaracao =  VARIAVEL;
				        ((Declaracao_localContext)_localctx).nome =  ((Declaracao_localContext)_localctx).variavel.nome;
				        ((Declaracao_localContext)_localctx).tipo_variavel =  ((Declaracao_localContext)_localctx).variavel.tipo_variavel;
				    
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(T__3);
				setState(150);
				((Declaracao_localContext)_localctx).IDENT = match(IDENT);
				setState(151);
				match(T__4);
				setState(152);
				((Declaracao_localContext)_localctx).tipo_basico = tipo_basico();
				setState(153);
				match(T__5);
				setState(154);
				valor_constante();

				        ((Declaracao_localContext)_localctx).tipo_declaracao =  CONSTANTE;
				        pilhaDeTabelas.topo().adicionarSimbolo((((Declaracao_localContext)_localctx).IDENT!=null?((Declaracao_localContext)_localctx).IDENT.getText():null), ((Declaracao_localContext)_localctx).tipo_basico.tipodado, "constante");
				    
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(T__6);
				setState(158);
				((Declaracao_localContext)_localctx).IDENT = match(IDENT);
				setState(159);
				match(T__4);
				setState(160);
				((Declaracao_localContext)_localctx).tipo = tipo();

				        ((Declaracao_localContext)_localctx).tipo_declaracao =  TIPO;
				        pilhaDeTabelas.adicionarTipo((((Declaracao_localContext)_localctx).IDENT!=null?((Declaracao_localContext)_localctx).IDENT.getText():null), ((Declaracao_localContext)_localctx).tipo.atributos);
				        pilhaDeTabelas.topo().adicionarSimbolo((((Declaracao_localContext)_localctx).IDENT!=null?((Declaracao_localContext)_localctx).IDENT.getText():null), "novotipo", "tipo");
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariavelContext extends ParserRuleContext {
		public String nome;
		public String tipo_variavel;
		public Token IDENT;
		public Mais_varContext mais_var;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Mais_varContext mais_var() {
			return getRuleContext(Mais_varContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public VariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariavelContext variavel() throws RecognitionException {
		VariavelContext _localctx = new VariavelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variavel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			((VariavelContext)_localctx).IDENT = match(IDENT);
			setState(166);
			dimensao();
			setState(167);
			((VariavelContext)_localctx).mais_var = mais_var();
			setState(168);
			match(T__4);
			setState(169);
			((VariavelContext)_localctx).tipo = tipo();

			        ((VariavelContext)_localctx).nome =  (((VariavelContext)_localctx).IDENT!=null?((VariavelContext)_localctx).IDENT.getText():null);
			        ((VariavelContext)_localctx).tipo_variavel =  ((VariavelContext)_localctx).tipo.tipodado;
			        pilhaDeTabelas.verificaVariavelExistente(new Pair((((VariavelContext)_localctx).IDENT!=null?((VariavelContext)_localctx).IDENT.getText():null), (((VariavelContext)_localctx).IDENT!=null?((VariavelContext)_localctx).IDENT.getLine():0)), ((VariavelContext)_localctx).mais_var.nomes, _localctx.tipo_variavel);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_varContext extends ParserRuleContext {
		public List<Pair> nomes;
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(LAParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LAParser.IDENT, i);
		}
		public List<DimensaoContext> dimensao() {
			return getRuleContexts(DimensaoContext.class);
		}
		public DimensaoContext dimensao(int i) {
			return getRuleContext(DimensaoContext.class,i);
		}
		public Mais_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_varContext mais_var() throws RecognitionException {
		Mais_varContext _localctx = new Mais_varContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mais_var);

		        ((Mais_varContext)_localctx).nomes =  new ArrayList<Pair>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(172);
				match(T__7);
				setState(173);
				((Mais_varContext)_localctx).IDENT = match(IDENT);
				setState(174);
				dimensao();

				            Pair variavel = new Pair((((Mais_varContext)_localctx).IDENT!=null?((Mais_varContext)_localctx).IDENT.getText():null), (((Mais_varContext)_localctx).IDENT!=null?((Mais_varContext)_localctx).IDENT.getLine():0));
				            _localctx.nomes.add(variavel);
				        
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentificadorContext extends ParserRuleContext {
		public String nome_variavel;
		public Token IDENT;
		public Outros_identContext outros_ident;
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_identificador);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			ponteiros_opcionais();
			setState(183);
			((IdentificadorContext)_localctx).IDENT = match(IDENT);
			setState(184);
			dimensao();
			setState(185);
			((IdentificadorContext)_localctx).outros_ident = outros_ident();

			        ((IdentificadorContext)_localctx).nome_variavel =  (((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getText():null);
			        pilhaDeTabelas.verificaVariavelInexistente((((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getText():null), ((IdentificadorContext)_localctx).outros_ident.nome_atributo, ((IdentificadorContext)_localctx).outros_ident.id, (((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getLine():0));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ponteiros_opcionaisContext extends ParserRuleContext {
		public String ponteiros;
		public int linha;
		public Ponteiros_opcionaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ponteiros_opcionais; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitPonteiros_opcionais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ponteiros_opcionaisContext ponteiros_opcionais() throws RecognitionException {
		Ponteiros_opcionaisContext _localctx = new Ponteiros_opcionaisContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ponteiros_opcionais);

		        ((Ponteiros_opcionaisContext)_localctx).ponteiros =  "";
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(188);
				match(T__8);
				 _localctx.ponteiros += "^"; 
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_identContext extends ParserRuleContext {
		public String id;
		public String nome_atributo;
		public boolean atributo;
		public Token IDENT;
		public List<Ponteiros_opcionaisContext> ponteiros_opcionais() {
			return getRuleContexts(Ponteiros_opcionaisContext.class);
		}
		public Ponteiros_opcionaisContext ponteiros_opcionais(int i) {
			return getRuleContext(Ponteiros_opcionaisContext.class,i);
		}
		public List<TerminalNode> IDENT() { return getTokens(LAParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LAParser.IDENT, i);
		}
		public List<DimensaoContext> dimensao() {
			return getRuleContexts(DimensaoContext.class);
		}
		public DimensaoContext dimensao(int i) {
			return getRuleContext(DimensaoContext.class,i);
		}
		public Outros_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_identContext outros_ident() throws RecognitionException {
		Outros_identContext _localctx = new Outros_identContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_outros_ident);

		        ((Outros_identContext)_localctx).id =  "";
		        ((Outros_identContext)_localctx).nome_atributo =  "";
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(195);
				match(T__9);
				setState(196);
				ponteiros_opcionais();
				setState(197);
				((Outros_identContext)_localctx).IDENT = match(IDENT);
				setState(198);
				dimensao();

				            _localctx.id += "." + (((Outros_identContext)_localctx).IDENT!=null?((Outros_identContext)_localctx).IDENT.getText():null);
				            ((Outros_identContext)_localctx).nome_atributo =  (((Outros_identContext)_localctx).IDENT!=null?((Outros_identContext)_localctx).IDENT.getText():null);
				            ((Outros_identContext)_localctx).atributo =  true;
				        
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimensaoContext extends ParserRuleContext {
		public int indice;
		public Exp_aritmeticaContext exp_aritmetica;
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public DimensaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDimensao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensaoContext dimensao() throws RecognitionException {
		DimensaoContext _localctx = new DimensaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dimensao);

		        ((DimensaoContext)_localctx).indice =  -1;
		    
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					match(T__10);
					setState(207);
					((DimensaoContext)_localctx).exp_aritmetica = exp_aritmetica();
					 ((DimensaoContext)_localctx).indice =  ((DimensaoContext)_localctx).exp_aritmetica.indice; 
					setState(209);
					match(T__11);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public String tipodado;
		public List<Pair> atributos;
		public RegistroContext registro;
		public Tipo_estendidoContext tipo_estendido;
		public RegistroContext registro() {
			return getRuleContext(RegistroContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(222);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				((TipoContext)_localctx).registro = registro();

				        ((TipoContext)_localctx).tipodado =  "registro";
				        ((TipoContext)_localctx).atributos =  ((TipoContext)_localctx).registro.atributos;
				        pilhaDeTabelas.adicionarTipo("registro", _localctx.atributos);
				    
				}
				break;
			case T__8:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				((TipoContext)_localctx).tipo_estendido = tipo_estendido();

				        ((TipoContext)_localctx).tipodado =  ((TipoContext)_localctx).tipo_estendido.tipodado;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_identContext extends ParserRuleContext {
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public Mais_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_identContext mais_ident() throws RecognitionException {
		Mais_identContext _localctx = new Mais_identContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mais_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(224);
				match(T__7);
				setState(225);
				identificador();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_basicoContext extends ParserRuleContext {
		public String tipodado;
		public Tipo_basicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_basico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basicoContext tipo_basico() throws RecognitionException {
		Tipo_basicoContext _localctx = new Tipo_basicoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tipo_basico);
		try {
			setState(239);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				match(T__12);

				        ((Tipo_basicoContext)_localctx).tipodado =  "inteiro";
				    
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(T__13);

				        ((Tipo_basicoContext)_localctx).tipodado =  "real";
				    
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(T__14);

				        ((Tipo_basicoContext)_localctx).tipodado =  "literal";
				    
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				match(T__15);

				        ((Tipo_basicoContext)_localctx).tipodado =  "logico";
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_basico_identContext extends ParserRuleContext {
		public String tipodado;
		public Tipo_basicoContext tipo_basico;
		public Token IDENT;
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Tipo_basico_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_basico_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basico_identContext tipo_basico_ident() throws RecognitionException {
		Tipo_basico_identContext _localctx = new Tipo_basico_identContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipo_basico_ident);
		try {
			setState(246);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				((Tipo_basico_identContext)_localctx).tipo_basico = tipo_basico();

				        ((Tipo_basico_identContext)_localctx).tipodado =  ((Tipo_basico_identContext)_localctx).tipo_basico.tipodado;
				    
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				((Tipo_basico_identContext)_localctx).IDENT = match(IDENT);

				        ((Tipo_basico_identContext)_localctx).tipodado =  (((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getText():null);
				        if (!pilhaDeTabelas.existeTipo((((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getText():null))) {
				            ErrosSemanticos.tipoInexistente((((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getText():null), (((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getLine():0));
				        }
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_estendidoContext extends ParserRuleContext {
		public String tipodado;
		public Ponteiros_opcionaisContext ponteiros_opcionais;
		public Tipo_basico_identContext tipo_basico_ident;
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public Tipo_basico_identContext tipo_basico_ident() {
			return getRuleContext(Tipo_basico_identContext.class,0);
		}
		public Tipo_estendidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_estendido; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_estendido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_estendidoContext tipo_estendido() throws RecognitionException {
		Tipo_estendidoContext _localctx = new Tipo_estendidoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo_estendido);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			((Tipo_estendidoContext)_localctx).ponteiros_opcionais = ponteiros_opcionais();
			setState(249);
			((Tipo_estendidoContext)_localctx).tipo_basico_ident = tipo_basico_ident();

			        ((Tipo_estendidoContext)_localctx).tipodado =  ((Tipo_estendidoContext)_localctx).tipo_basico_ident.tipodado + ((Tipo_estendidoContext)_localctx).ponteiros_opcionais.ponteiros;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Valor_constanteContext extends ParserRuleContext {
		public TerminalNode CADEIA() { return getToken(LAParser.CADEIA, 0); }
		public TerminalNode NUM_INT() { return getToken(LAParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(LAParser.NUM_REAL, 0); }
		public Valor_constanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_constante; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitValor_constante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_constanteContext valor_constante() throws RecognitionException {
		Valor_constanteContext _localctx = new Valor_constanteContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_valor_constante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << NUM_INT) | (1L << NUM_REAL) | (1L << CADEIA))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegistroContext extends ParserRuleContext {
		public List<Pair> atributos;
		public Variavel_registroContext variavel_registro;
		public List<Variavel_registroContext> variavel_registro() {
			return getRuleContexts(Variavel_registroContext.class);
		}
		public Variavel_registroContext variavel_registro(int i) {
			return getRuleContext(Variavel_registroContext.class,i);
		}
		public RegistroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_registro);

		        ((RegistroContext)_localctx).atributos =  new ArrayList<Pair>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__18);
			setState(258); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(255);
				((RegistroContext)_localctx).variavel_registro = variavel_registro();

				            for (Pair atributo: ((RegistroContext)_localctx).variavel_registro.atributos) {
				                _localctx.atributos.add(atributo);
				            }
				        
				}
				}
				setState(260); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(262);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variavel_registroContext extends ParserRuleContext {
		public List<Pair> atributos;
		public Token IDENT;
		public Mais_var_registroContext mais_var_registro;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Mais_var_registroContext mais_var_registro() {
			return getRuleContext(Mais_var_registroContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Variavel_registroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel_registro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitVariavel_registro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variavel_registroContext variavel_registro() throws RecognitionException {
		Variavel_registroContext _localctx = new Variavel_registroContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variavel_registro);

		        ((Variavel_registroContext)_localctx).atributos =  new ArrayList<Pair>();
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			((Variavel_registroContext)_localctx).IDENT = match(IDENT);
			setState(265);
			dimensao();
			setState(266);
			((Variavel_registroContext)_localctx).mais_var_registro = mais_var_registro();
			setState(267);
			match(T__4);
			setState(268);
			((Variavel_registroContext)_localctx).tipo = tipo();

			        _localctx.atributos.add(new Pair((((Variavel_registroContext)_localctx).IDENT!=null?((Variavel_registroContext)_localctx).IDENT.getText():null), ((Variavel_registroContext)_localctx).tipo.tipodado));
			        for (String atributo : ((Variavel_registroContext)_localctx).mais_var_registro.atributos) {
			            _localctx.atributos.add(new Pair(atributo, ((Variavel_registroContext)_localctx).tipo.tipodado));
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_var_registroContext extends ParserRuleContext {
		public List<String> atributos;
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(LAParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LAParser.IDENT, i);
		}
		public List<DimensaoContext> dimensao() {
			return getRuleContexts(DimensaoContext.class);
		}
		public DimensaoContext dimensao(int i) {
			return getRuleContext(DimensaoContext.class,i);
		}
		public Mais_var_registroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_var_registro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_var_registro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_var_registroContext mais_var_registro() throws RecognitionException {
		Mais_var_registroContext _localctx = new Mais_var_registroContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mais_var_registro);

		        ((Mais_var_registroContext)_localctx).atributos =  new ArrayList<String>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(271);
				match(T__7);
				setState(272);
				((Mais_var_registroContext)_localctx).IDENT = match(IDENT);
				setState(273);
				dimensao();

				            _localctx.atributos.add((((Mais_var_registroContext)_localctx).IDENT!=null?((Mais_var_registroContext)_localctx).IDENT.getText():null));
				        
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracao_globalContext extends ParserRuleContext {
		public Token IDENT;
		public Tipo_estendidoContext tipo_estendido;
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Parametros_opcionalContext parametros_opcional() {
			return getRuleContext(Parametros_opcionalContext.class,0);
		}
		public Declaracoes_locaisContext declaracoes_locais() {
			return getRuleContext(Declaracoes_locaisContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public Declaracao_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_global; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_globalContext declaracao_global() throws RecognitionException {
		Declaracao_globalContext _localctx = new Declaracao_globalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_declaracao_global);
		try {
			setState(306);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(T__20);
				setState(282);
				((Declaracao_globalContext)_localctx).IDENT = match(IDENT);

				        pilhaDeTabelas.topo().adicionarSimbolo((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null), "void", "procedimento");
				        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento_" + (((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null)));
				        pilhaDeTabelas.adicionarFuncaoOuProcedimento((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null));
				    
				setState(284);
				match(T__21);
				setState(285);
				parametros_opcional();
				setState(286);
				match(T__22);
				setState(287);
				declaracoes_locais();
				setState(288);
				comandos();
				setState(289);
				match(T__23);

				        pilhaDeTabelas.desempilhar();
				    
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(T__24);
				setState(293);
				((Declaracao_globalContext)_localctx).IDENT = match(IDENT);

				        pilhaDeTabelas.adicionarFuncaoOuProcedimento((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null));
				        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao_" + (((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null)));
				    
				setState(295);
				match(T__21);
				setState(296);
				parametros_opcional();
				setState(297);
				match(T__22);
				setState(298);
				match(T__4);
				setState(299);
				((Declaracao_globalContext)_localctx).tipo_estendido = tipo_estendido();

				        pilhaDeTabelas.tabelaGlobal().adicionarSimbolo((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null), ((Declaracao_globalContext)_localctx).tipo_estendido.tipodado, "funcao");
				    
				setState(301);
				declaracoes_locais();
				setState(302);
				comandos();
				setState(303);
				match(T__25);

				        pilhaDeTabelas.desempilhar();
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parametros_opcionalContext extends ParserRuleContext {
		public ParametroContext parametro() {
			return getRuleContext(ParametroContext.class,0);
		}
		public Parametros_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros_opcional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParametros_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametros_opcionalContext parametros_opcional() throws RecognitionException {
		Parametros_opcionalContext _localctx = new Parametros_opcionalContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parametros_opcional);
		try {
			setState(310);
			switch (_input.LA(1)) {
			case T__8:
			case T__26:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				parametro();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public Ident_paramContext ident_param;
		public Tipo_estendidoContext tipo_estendido;
		public Var_opcionalContext var_opcional() {
			return getRuleContext(Var_opcionalContext.class,0);
		}
		public Ident_paramContext ident_param() {
			return getRuleContext(Ident_paramContext.class,0);
		}
		public Mais_id_paramContext mais_id_param() {
			return getRuleContext(Mais_id_paramContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public Mais_parametrosContext mais_parametros() {
			return getRuleContext(Mais_parametrosContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			var_opcional();
			setState(313);
			((ParametroContext)_localctx).ident_param = ident_param();
			setState(314);
			mais_id_param();
			setState(315);
			match(T__4);
			setState(316);
			((ParametroContext)_localctx).tipo_estendido = tipo_estendido();

			        pilhaDeTabelas.topo().adicionarSimbolo(((ParametroContext)_localctx).ident_param.nome_parametro, ((ParametroContext)_localctx).tipo_estendido.tipodado, "parametro");
			        pilhaDeTabelas.topo_funcoes().add(((ParametroContext)_localctx).tipo_estendido.tipodado);
			    
			setState(318);
			mais_parametros();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ident_paramContext extends ParserRuleContext {
		public String nome_parametro;
		public Token IDENT;
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public Ident_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitIdent_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ident_paramContext ident_param() throws RecognitionException {
		Ident_paramContext _localctx = new Ident_paramContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ident_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			ponteiros_opcionais();
			setState(321);
			((Ident_paramContext)_localctx).IDENT = match(IDENT);

			        ((Ident_paramContext)_localctx).nome_parametro =  (((Ident_paramContext)_localctx).IDENT!=null?((Ident_paramContext)_localctx).IDENT.getText():null);
			    
			setState(323);
			dimensao();
			setState(324);
			outros_ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_id_paramContext extends ParserRuleContext {
		public List<Ident_paramContext> ident_param() {
			return getRuleContexts(Ident_paramContext.class);
		}
		public Ident_paramContext ident_param(int i) {
			return getRuleContext(Ident_paramContext.class,i);
		}
		public Mais_id_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_id_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_id_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_id_paramContext mais_id_param() throws RecognitionException {
		Mais_id_paramContext _localctx = new Mais_id_paramContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mais_id_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(326);
				match(T__7);
				setState(327);
				ident_param();
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_opcionalContext extends ParserRuleContext {
		public Var_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_opcional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitVar_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_opcionalContext var_opcional() throws RecognitionException {
		Var_opcionalContext _localctx = new Var_opcionalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_var_opcional);
		try {
			setState(335);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				match(T__26);
				}
				break;
			case T__8:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_parametrosContext extends ParserRuleContext {
		public ParametroContext parametro() {
			return getRuleContext(ParametroContext.class,0);
		}
		public Mais_parametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_parametros; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_parametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_parametrosContext mais_parametros() throws RecognitionException {
		Mais_parametrosContext _localctx = new Mais_parametrosContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mais_parametros);
		try {
			setState(340);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				match(T__7);
				setState(338);
				parametro();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracoes_locaisContext extends ParserRuleContext {
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public Declaracoes_locaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes_locais; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracoes_locais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracoes_locaisContext declaracoes_locais() throws RecognitionException {
		Declaracoes_locaisContext _localctx = new Declaracoes_locaisContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_declaracoes_locais);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__6))) != 0)) {
				{
				{
				setState(342);
				declaracao_local();
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorpoContext extends ParserRuleContext {
		public Declaracoes_locaisContext declaracoes_locais() {
			return getRuleContext(Declaracoes_locaisContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_corpo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			declaracoes_locais();
			setState(349);
			comandos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_comandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__32) | (1L << T__35) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << IDENT))) != 0)) {
				{
				{
				setState(351);
				cmd();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public int tipo_comando;
		public String nome_variavel;
		public String tipo_variavel;
		public IdentificadorContext identificador;
		public ExpressaoContext expressao;
		public Token IDENT;
		public AtribuicaoContext atribuicao;
		public Token retorne;
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Mais_identContext mais_ident() {
			return getRuleContext(Mais_identContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Senao_opcionalContext senao_opcional() {
			return getRuleContext(Senao_opcionalContext.class,0);
		}
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public ChamadaContext chamada() {
			return getRuleContext(ChamadaContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_cmd);
		try {
			setState(431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				match(T__27);
				setState(358);
				match(T__21);
				setState(359);
				((CmdContext)_localctx).identificador = identificador();
				setState(360);
				mais_ident();
				setState(361);
				match(T__22);

				        ((CmdContext)_localctx).tipo_comando =  LEIA;
				        ((CmdContext)_localctx).nome_variavel =  ((CmdContext)_localctx).identificador.nome_variavel;
				        ((CmdContext)_localctx).tipo_variavel =  pilhaDeTabelas.getTipoDoSimbolo(((CmdContext)_localctx).identificador.nome_variavel);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(T__28);
				setState(365);
				match(T__21);
				setState(366);
				((CmdContext)_localctx).expressao = expressao();
				setState(367);
				mais_expressao();
				setState(368);
				match(T__22);

				        ((CmdContext)_localctx).tipo_comando =  ESCREVA;
				        ((CmdContext)_localctx).nome_variavel =  ((CmdContext)_localctx).expressao.nome;
				        ((CmdContext)_localctx).tipo_variavel =  ((CmdContext)_localctx).expressao.type;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(371);
				match(T__29);
				setState(372);
				expressao();
				setState(373);
				match(T__30);
				setState(374);
				comandos();
				setState(375);
				senao_opcional();
				setState(376);
				match(T__31);

				        ((CmdContext)_localctx).tipo_comando =  SE;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
				match(T__32);
				setState(380);
				exp_aritmetica();
				setState(381);
				match(T__33);
				setState(382);
				selecao();
				setState(383);
				senao_opcional();
				setState(384);
				match(T__34);

				        ((CmdContext)_localctx).tipo_comando =  CASO;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(387);
				match(T__35);
				setState(388);
				((CmdContext)_localctx).IDENT = match(IDENT);
				setState(389);
				match(T__36);
				setState(390);
				exp_aritmetica();
				setState(391);
				match(T__37);
				setState(392);
				exp_aritmetica();
				setState(393);
				match(T__38);
				setState(394);
				comandos();
				setState(395);
				match(T__39);

				        ((CmdContext)_localctx).tipo_comando =  PARA;
				        ((CmdContext)_localctx).nome_variavel =  (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null);
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(398);
				match(T__40);
				setState(399);
				expressao();
				setState(400);
				match(T__38);
				setState(401);
				comandos();
				setState(402);
				match(T__41);

				        ((CmdContext)_localctx).tipo_comando =  ENQUANTO;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(405);
				match(T__38);
				setState(406);
				comandos();
				setState(407);
				match(T__37);
				setState(408);
				expressao();

				        ((CmdContext)_localctx).tipo_comando =  FACA;
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(411);
				match(T__8);
				setState(412);
				((CmdContext)_localctx).IDENT = match(IDENT);
				setState(413);
				dimensao();
				setState(414);
				outros_ident();
				setState(415);
				match(T__36);
				setState(416);
				((CmdContext)_localctx).expressao = expressao();

				        ((CmdContext)_localctx).tipo_comando =  PONTEIRO;
				        pilhaDeTabelas.verificaAtribuicaoDePonteiro((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null), (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getLine():0), ((CmdContext)_localctx).expressao.type);
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(419);
				match(IDENT);
				setState(420);
				chamada();

				        ((CmdContext)_localctx).tipo_comando =  CHAMADA;
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(423);
				((CmdContext)_localctx).IDENT = match(IDENT);
				setState(424);
				((CmdContext)_localctx).atribuicao = atribuicao();

				        ((CmdContext)_localctx).tipo_comando =  ATRIBUICAO;
				        pilhaDeTabelas.verificaCompatibilidadeDeAtribuicao(((CmdContext)_localctx).atribuicao.compativel, ((CmdContext)_localctx).atribuicao.type, (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null),
				            ((CmdContext)_localctx).atribuicao.nome, ((CmdContext)_localctx).atribuicao.indice, (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getLine():0));
				    
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(427);
				((CmdContext)_localctx).retorne = match(T__42);
				setState(428);
				expressao();

				        ((CmdContext)_localctx).tipo_comando =  RETORNE;
				        if (!pilhaDeTabelas.topo().getType().equals("funcao")) {
				            ErrosSemanticos.escopoInvalido((((CmdContext)_localctx).retorne!=null?((CmdContext)_localctx).retorne.getLine():0));
				        }
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_expressaoContext extends ParserRuleContext {
		public List<String> tipos;
		public ExpressaoContext expressao;
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public Mais_expressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_expressao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_expressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_expressaoContext mais_expressao() throws RecognitionException {
		Mais_expressaoContext _localctx = new Mais_expressaoContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_mais_expressao);

		        ((Mais_expressaoContext)_localctx).tipos =  new ArrayList<String>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(433);
				match(T__7);
				setState(434);
				((Mais_expressaoContext)_localctx).expressao = expressao();

				            _localctx.tipos.add(((Mais_expressaoContext)_localctx).expressao.type);
				        
				}
				}
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Senao_opcionalContext extends ParserRuleContext {
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Senao_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senao_opcional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitSenao_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Senao_opcionalContext senao_opcional() throws RecognitionException {
		Senao_opcionalContext _localctx = new Senao_opcionalContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_senao_opcional);
		try {
			setState(445);
			switch (_input.LA(1)) {
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				match(T__43);
				setState(443);
				comandos();
				}
				break;
			case T__31:
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChamadaContext extends ParserRuleContext {
		public Argumentos_opcionalContext argumentos_opcional() {
			return getRuleContext(Argumentos_opcionalContext.class,0);
		}
		public ChamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitChamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChamadaContext chamada() throws RecognitionException {
		ChamadaContext _localctx = new ChamadaContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_chamada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(T__21);
			setState(448);
			argumentos_opcional();
			setState(449);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoContext extends ParserRuleContext {
		public boolean compativel;
		public String type;
		public int indice;
		public String nome;
		public Outros_identContext outros_ident;
		public DimensaoContext dimensao;
		public ExpressaoContext expressao;
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_atribuicao);

		        ((AtribuicaoContext)_localctx).type =  "";
		        ((AtribuicaoContext)_localctx).nome =  "";
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			((AtribuicaoContext)_localctx).outros_ident = outros_ident();
			setState(452);
			((AtribuicaoContext)_localctx).dimensao = dimensao();
			setState(453);
			match(T__36);
			setState(454);
			((AtribuicaoContext)_localctx).expressao = expressao();

			        ((AtribuicaoContext)_localctx).type =  ((AtribuicaoContext)_localctx).expressao.type;
			        ((AtribuicaoContext)_localctx).indice =  ((AtribuicaoContext)_localctx).dimensao.indice;

			        if (((AtribuicaoContext)_localctx).outros_ident.nome_atributo.compareTo("") == 0) {
			            ((AtribuicaoContext)_localctx).nome =  (((AtribuicaoContext)_localctx).expressao.atributo && ((AtribuicaoContext)_localctx).expressao.nome.compareTo("") != 0) ? ((AtribuicaoContext)_localctx).expressao.nome : _localctx.nome;
			            ((AtribuicaoContext)_localctx).compativel =  (((AtribuicaoContext)_localctx).expressao.nome.compareTo("") == 0) ? ((AtribuicaoContext)_localctx).expressao.compativel : false;
			            ((AtribuicaoContext)_localctx).type =  (((AtribuicaoContext)_localctx).expressao.nome.compareTo("") == 0) ? ((AtribuicaoContext)_localctx).expressao.type : _localctx.type;
			        } else {
			            ((AtribuicaoContext)_localctx).nome =  ((AtribuicaoContext)_localctx).outros_ident.nome_atributo;
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Argumentos_opcionalContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public Argumentos_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos_opcional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitArgumentos_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argumentos_opcionalContext argumentos_opcional() throws RecognitionException {
		Argumentos_opcionalContext _localctx = new Argumentos_opcionalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_argumentos_opcional);
		try {
			setState(461);
			switch (_input.LA(1)) {
			case T__8:
			case T__16:
			case T__17:
			case T__21:
			case T__45:
			case T__49:
			case T__56:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
			case CADEIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				expressao();
				setState(458);
				mais_expressao();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelecaoContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Mais_selecaoContext mais_selecao() {
			return getRuleContext(Mais_selecaoContext.class,0);
		}
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitSelecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_selecao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			constantes();
			setState(464);
			match(T__4);
			setState(465);
			comandos();
			setState(466);
			mais_selecao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_selecaoContext extends ParserRuleContext {
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public Mais_selecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_selecao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_selecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_selecaoContext mais_selecao() throws RecognitionException {
		Mais_selecaoContext _localctx = new Mais_selecaoContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_mais_selecao);
		try {
			setState(470);
			switch (_input.LA(1)) {
			case T__45:
			case NUM_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				selecao();
				}
				break;
			case T__34:
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantesContext extends ParserRuleContext {
		public Numero_intervaloContext numero_intervalo() {
			return getRuleContext(Numero_intervaloContext.class,0);
		}
		public Mais_constantesContext mais_constantes() {
			return getRuleContext(Mais_constantesContext.class,0);
		}
		public ConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitConstantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantesContext constantes() throws RecognitionException {
		ConstantesContext _localctx = new ConstantesContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_constantes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			numero_intervalo();
			setState(473);
			mais_constantes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_constantesContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public Mais_constantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_constantes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitMais_constantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_constantesContext mais_constantes() throws RecognitionException {
		Mais_constantesContext _localctx = new Mais_constantesContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_mais_constantes);
		try {
			setState(478);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				match(T__7);
				setState(476);
				constantes();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numero_intervaloContext extends ParserRuleContext {
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public TerminalNode NUM_INT() { return getToken(LAParser.NUM_INT, 0); }
		public Intervalo_opcionalContext intervalo_opcional() {
			return getRuleContext(Intervalo_opcionalContext.class,0);
		}
		public Numero_intervaloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero_intervalo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitNumero_intervalo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numero_intervaloContext numero_intervalo() throws RecognitionException {
		Numero_intervaloContext _localctx = new Numero_intervaloContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_numero_intervalo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			op_unario();
			setState(481);
			match(NUM_INT);
			setState(482);
			intervalo_opcional();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Intervalo_opcionalContext extends ParserRuleContext {
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public TerminalNode NUM_INT() { return getToken(LAParser.NUM_INT, 0); }
		public Intervalo_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalo_opcional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitIntervalo_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Intervalo_opcionalContext intervalo_opcional() throws RecognitionException {
		Intervalo_opcionalContext _localctx = new Intervalo_opcionalContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_intervalo_opcional);
		try {
			setState(489);
			switch (_input.LA(1)) {
			case T__44:
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				match(T__44);
				setState(485);
				op_unario();
				setState(486);
				match(NUM_INT);
				}
				break;
			case T__4:
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_unarioContext extends ParserRuleContext {
		public Op_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_unario; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_unarioContext op_unario() throws RecognitionException {
		Op_unarioContext _localctx = new Op_unarioContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_op_unario);
		try {
			setState(493);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				match(T__45);
				}
				break;
			case T__8:
			case T__21:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_aritmeticaContext extends ParserRuleContext {
		public boolean compativel;
		public String type;
		public int indice;
		public String nome;
		public boolean atributo;
		public TermoContext termo;
		public Outros_termosContext outros_termos;
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Outros_termosContext outros_termos() {
			return getRuleContext(Outros_termosContext.class,0);
		}
		public Exp_aritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_aritmetica; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_aritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_aritmeticaContext exp_aritmetica() throws RecognitionException {
		Exp_aritmeticaContext _localctx = new Exp_aritmeticaContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_exp_aritmetica);

		        ((Exp_aritmeticaContext)_localctx).type =  "";
		        ((Exp_aritmeticaContext)_localctx).nome =  "";
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			((Exp_aritmeticaContext)_localctx).termo = termo();
			setState(496);
			((Exp_aritmeticaContext)_localctx).outros_termos = outros_termos();

			        ((Exp_aritmeticaContext)_localctx).nome =  ((Exp_aritmeticaContext)_localctx).termo.nome;
			        ((Exp_aritmeticaContext)_localctx).atributo =  ((Exp_aritmeticaContext)_localctx).termo.atributo;

			        if (!((Exp_aritmeticaContext)_localctx).outros_termos.type.equals("") && !((Exp_aritmeticaContext)_localctx).termo.type.equals(((Exp_aritmeticaContext)_localctx).outros_termos.type)) {
			            ((Exp_aritmeticaContext)_localctx).type =  ((Exp_aritmeticaContext)_localctx).outros_termos.type;
			            ((Exp_aritmeticaContext)_localctx).indice =  ((Exp_aritmeticaContext)_localctx).termo.indice;
			        } else {
			            ((Exp_aritmeticaContext)_localctx).type =  ((Exp_aritmeticaContext)_localctx).termo.type;
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_multiplicacaoContext extends ParserRuleContext {
		public Op_multiplicacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_multiplicacao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_multiplicacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_multiplicacaoContext op_multiplicacao() throws RecognitionException {
		Op_multiplicacaoContext _localctx = new Op_multiplicacaoContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_op_multiplicacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_la = _input.LA(1);
			if ( !(_la==T__46 || _la==T__47) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_adicaoContext extends ParserRuleContext {
		public Op_adicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_adicao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_adicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_adicaoContext op_adicao() throws RecognitionException {
		Op_adicaoContext _localctx = new Op_adicaoContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_op_adicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			_la = _input.LA(1);
			if ( !(_la==T__45 || _la==T__48) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public String type;
		public int indice;
		public String nome;
		public boolean atributo;
		public FatorContext fator;
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public Outros_fatoresContext outros_fatores() {
			return getRuleContext(Outros_fatoresContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_termo);

		        ((TermoContext)_localctx).nome =  "";
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			((TermoContext)_localctx).fator = fator();
			setState(504);
			outros_fatores();

			        ((TermoContext)_localctx).type =  ((TermoContext)_localctx).fator.type;
			        ((TermoContext)_localctx).indice =  ((TermoContext)_localctx).fator.indice;
			        ((TermoContext)_localctx).nome =  ((TermoContext)_localctx).fator.nome;
			        ((TermoContext)_localctx).atributo =  ((TermoContext)_localctx).fator.atributo;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_termosContext extends ParserRuleContext {
		public String type;
		public TermoContext termo;
		public List<Op_adicaoContext> op_adicao() {
			return getRuleContexts(Op_adicaoContext.class);
		}
		public Op_adicaoContext op_adicao(int i) {
			return getRuleContext(Op_adicaoContext.class,i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public Outros_termosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_termos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_termos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_termosContext outros_termos() throws RecognitionException {
		Outros_termosContext _localctx = new Outros_termosContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_outros_termos);

		        ((Outros_termosContext)_localctx).type =  "";
		    
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(507);
					op_adicao();
					setState(508);
					((Outros_termosContext)_localctx).termo = termo();

					            ((Outros_termosContext)_localctx).type =  ((Outros_termosContext)_localctx).termo.type;
					        
					}
					} 
				}
				setState(515);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public String type;
		public int indice;
		public String nome;
		public boolean atributo;
		public ParcelaContext parcela;
		public ParcelaContext parcela() {
			return getRuleContext(ParcelaContext.class,0);
		}
		public Outras_parcelasContext outras_parcelas() {
			return getRuleContext(Outras_parcelasContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_fator);

		        ((FatorContext)_localctx).nome =  "";
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			((FatorContext)_localctx).parcela = parcela();
			setState(517);
			outras_parcelas();

			        ((FatorContext)_localctx).type =  ((FatorContext)_localctx).parcela.type;
			        ((FatorContext)_localctx).indice =  ((FatorContext)_localctx).parcela.indice;
			        ((FatorContext)_localctx).nome =  ((FatorContext)_localctx).parcela.nome;
			        ((FatorContext)_localctx).atributo =  ((FatorContext)_localctx).parcela.atributo;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_fatoresContext extends ParserRuleContext {
		public List<Op_multiplicacaoContext> op_multiplicacao() {
			return getRuleContexts(Op_multiplicacaoContext.class);
		}
		public Op_multiplicacaoContext op_multiplicacao(int i) {
			return getRuleContext(Op_multiplicacaoContext.class,i);
		}
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public Outros_fatoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_fatores; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_fatores(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_fatoresContext outros_fatores() throws RecognitionException {
		Outros_fatoresContext _localctx = new Outros_fatoresContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_outros_fatores);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__46 || _la==T__47) {
				{
				{
				setState(520);
				op_multiplicacao();
				setState(521);
				fator();
				}
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParcelaContext extends ParserRuleContext {
		public String type;
		public int indice;
		public String nome;
		public int tipo_parcela;
		public boolean atributo;
		public Parcela_unarioContext parcela_unario;
		public Parcela_nao_unarioContext parcela_nao_unario;
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public Parcela_unarioContext parcela_unario() {
			return getRuleContext(Parcela_unarioContext.class,0);
		}
		public Parcela_nao_unarioContext parcela_nao_unario() {
			return getRuleContext(Parcela_nao_unarioContext.class,0);
		}
		public ParcelaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParcelaContext parcela() throws RecognitionException {
		ParcelaContext _localctx = new ParcelaContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parcela);

		        ((ParcelaContext)_localctx).nome =  "";
		    
		try {
			setState(535);
			switch (_input.LA(1)) {
			case T__8:
			case T__21:
			case T__45:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				op_unario();
				setState(529);
				((ParcelaContext)_localctx).parcela_unario = parcela_unario();

				        ((ParcelaContext)_localctx).tipo_parcela =  PARCELA_UNARIO;
				        ((ParcelaContext)_localctx).type =  ((ParcelaContext)_localctx).parcela_unario.type;
				        ((ParcelaContext)_localctx).indice =  ((ParcelaContext)_localctx).parcela_unario.indice;
				        ((ParcelaContext)_localctx).nome =  ((ParcelaContext)_localctx).parcela_unario.nome;
				        ((ParcelaContext)_localctx).atributo =  ((ParcelaContext)_localctx).parcela_unario.atributo;
				    
				}
				break;
			case T__49:
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(532);
				((ParcelaContext)_localctx).parcela_nao_unario = parcela_nao_unario();

				        ((ParcelaContext)_localctx).tipo_parcela =  PARCELA_NAO_UNARIO;
				        ((ParcelaContext)_localctx).type =  ((ParcelaContext)_localctx).parcela_nao_unario.type;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parcela_unarioContext extends ParserRuleContext {
		public String type;
		public int indice;
		public String nome;
		public String tipo_parcela_unario;
		public boolean atributo;
		public Token IDENT;
		public Chamada_partesContext chamada_partes;
		public Token NUM_INT;
		public Token NUM_REAL;
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Chamada_partesContext chamada_partes() {
			return getRuleContext(Chamada_partesContext.class,0);
		}
		public TerminalNode NUM_INT() { return getToken(LAParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(LAParser.NUM_REAL, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Parcela_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_unario; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_unarioContext parcela_unario() throws RecognitionException {
		Parcela_unarioContext _localctx = new Parcela_unarioContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_parcela_unario);

		        ((Parcela_unarioContext)_localctx).type =  "";
		        ((Parcela_unarioContext)_localctx).indice =  -1;
		        ((Parcela_unarioContext)_localctx).nome =  "";
		    
		try {
			setState(556);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(537);
				match(T__8);
				setState(538);
				((Parcela_unarioContext)_localctx).IDENT = match(IDENT);
				setState(539);
				outros_ident();
				setState(540);
				dimensao();

				        ((Parcela_unarioContext)_localctx).tipo_parcela_unario =  "PONTEIRO";
				        ((Parcela_unarioContext)_localctx).type =  pilhaDeTabelas.getTipoDoSimbolo((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null));
				    
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
				((Parcela_unarioContext)_localctx).IDENT = match(IDENT);
				setState(544);
				((Parcela_unarioContext)_localctx).chamada_partes = chamada_partes();

				        ((Parcela_unarioContext)_localctx).tipo_parcela_unario =  "CHAMADA";

				        if (!pilhaDeTabelas.existeSimbolo((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null))) {
				            ErrosSemanticos.identificadorInexistente((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null) + ((Parcela_unarioContext)_localctx).chamada_partes.id, (((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getLine():0));
				        }

				        ((Parcela_unarioContext)_localctx).type =  pilhaDeTabelas.getTipoDoSimbolo((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null));
				        pilhaDeTabelas.verificaCompatibilidadeDeParametros(((Parcela_unarioContext)_localctx).chamada_partes.tipos, (((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null), (((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getLine():0));
				        ((Parcela_unarioContext)_localctx).nome =  ((Parcela_unarioContext)_localctx).chamada_partes.nome;;
				        ((Parcela_unarioContext)_localctx).atributo =  ((Parcela_unarioContext)_localctx).chamada_partes.atributo;
				    
				}
				break;
			case NUM_INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(547);
				((Parcela_unarioContext)_localctx).NUM_INT = match(NUM_INT);

				        ((Parcela_unarioContext)_localctx).tipo_parcela_unario =  "INTEIRO";
				        ((Parcela_unarioContext)_localctx).type =  "inteiro";
				        ((Parcela_unarioContext)_localctx).indice =  Integer.parseInt((((Parcela_unarioContext)_localctx).NUM_INT!=null?((Parcela_unarioContext)_localctx).NUM_INT.getText():null));
				        ((Parcela_unarioContext)_localctx).nome =  (((Parcela_unarioContext)_localctx).NUM_INT!=null?((Parcela_unarioContext)_localctx).NUM_INT.getText():null);
				    
				}
				break;
			case NUM_REAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(549);
				((Parcela_unarioContext)_localctx).NUM_REAL = match(NUM_REAL);

				        ((Parcela_unarioContext)_localctx).tipo_parcela_unario =  "REAL";
				        ((Parcela_unarioContext)_localctx).type =  "real";
				        ((Parcela_unarioContext)_localctx).nome =  (((Parcela_unarioContext)_localctx).NUM_REAL!=null?((Parcela_unarioContext)_localctx).NUM_REAL.getText():null);
				    
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 5);
				{
				setState(551);
				match(T__21);
				setState(552);
				expressao();
				setState(553);
				match(T__22);

				        ((Parcela_unarioContext)_localctx).tipo_parcela_unario =  "EXPRESSAO";
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parcela_nao_unarioContext extends ParserRuleContext {
		public String type;
		public String nome;
		public Outros_identContext outros_ident;
		public Token CADEIA;
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(LAParser.CADEIA, 0); }
		public Parcela_nao_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_nao_unario; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_nao_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_nao_unarioContext parcela_nao_unario() throws RecognitionException {
		Parcela_nao_unarioContext _localctx = new Parcela_nao_unarioContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_parcela_nao_unario);

		        ((Parcela_nao_unarioContext)_localctx).nome =  "";
		    
		try {
			setState(566);
			switch (_input.LA(1)) {
			case T__49:
				enterOuterAlt(_localctx, 1);
				{
				setState(558);
				match(T__49);
				setState(559);
				match(IDENT);
				setState(560);
				((Parcela_nao_unarioContext)_localctx).outros_ident = outros_ident();
				setState(561);
				dimensao();

				        ((Parcela_nao_unarioContext)_localctx).type =  "";
				        ((Parcela_nao_unarioContext)_localctx).nome =  ((Parcela_nao_unarioContext)_localctx).outros_ident.nome_atributo;
				    
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(564);
				((Parcela_nao_unarioContext)_localctx).CADEIA = match(CADEIA);

				        ((Parcela_nao_unarioContext)_localctx).type =  "literal";
				        ((Parcela_nao_unarioContext)_localctx).nome =  (((Parcela_nao_unarioContext)_localctx).CADEIA!=null?((Parcela_nao_unarioContext)_localctx).CADEIA.getText():null);
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outras_parcelasContext extends ParserRuleContext {
		public List<ParcelaContext> parcela() {
			return getRuleContexts(ParcelaContext.class);
		}
		public ParcelaContext parcela(int i) {
			return getRuleContext(ParcelaContext.class,i);
		}
		public Outras_parcelasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outras_parcelas; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutras_parcelas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outras_parcelasContext outras_parcelas() throws RecognitionException {
		Outras_parcelasContext _localctx = new Outras_parcelasContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_outras_parcelas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__50) {
				{
				{
				setState(568);
				match(T__50);
				setState(569);
				parcela();
				}
				}
				setState(574);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Chamada_partesContext extends ParserRuleContext {
		public String id;
		public List<String> tipos;
		public String nome;
		public int tipo_chamada;
		public boolean atributo;
		public ExpressaoContext expressao;
		public Mais_expressaoContext mais_expressao;
		public Outros_identContext outros_ident;
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Chamada_partesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada_partes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitChamada_partes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chamada_partesContext chamada_partes() throws RecognitionException {
		Chamada_partesContext _localctx = new Chamada_partesContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_chamada_partes);

		        ((Chamada_partesContext)_localctx).id =  "";
		        ((Chamada_partesContext)_localctx).tipos =  new ArrayList<String>();
		        ((Chamada_partesContext)_localctx).nome =  "";
		    
		try {
			setState(586);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				match(T__21);
				setState(576);
				((Chamada_partesContext)_localctx).expressao = expressao();
				setState(577);
				((Chamada_partesContext)_localctx).mais_expressao = mais_expressao();

				        ((Chamada_partesContext)_localctx).tipos =  ((Chamada_partesContext)_localctx).mais_expressao.tipos;
				        _localctx.tipos.add(((Chamada_partesContext)_localctx).expressao.type);
				        ((Chamada_partesContext)_localctx).tipo_chamada =  CHAMADA_EXPRESSAO;
				    
				setState(579);
				match(T__22);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(581);
				((Chamada_partesContext)_localctx).outros_ident = outros_ident();
				setState(582);
				dimensao();

				        ((Chamada_partesContext)_localctx).id =  ((Chamada_partesContext)_localctx).outros_ident.id;
				        ((Chamada_partesContext)_localctx).nome =  ((Chamada_partesContext)_localctx).outros_ident.nome_atributo;
				        ((Chamada_partesContext)_localctx).atributo =  ((Chamada_partesContext)_localctx).outros_ident.atributo;
				        ((Chamada_partesContext)_localctx).tipo_chamada =  CHAMADA_IDENTIFICADOR;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				 ((Chamada_partesContext)_localctx).tipo_chamada =  CHAMADA_VAZIA; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_relacionalContext extends ParserRuleContext {
		public boolean compativel;
		public String type;
		public String nome;
		public boolean atributo;
		public Exp_aritmeticaContext exp_aritmetica;
		public Op_opcionalContext op_opcional;
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public Op_opcionalContext op_opcional() {
			return getRuleContext(Op_opcionalContext.class,0);
		}
		public Exp_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_relacional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_relacionalContext exp_relacional() throws RecognitionException {
		Exp_relacionalContext _localctx = new Exp_relacionalContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_exp_relacional);

		        ((Exp_relacionalContext)_localctx).nome =  "";
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			((Exp_relacionalContext)_localctx).exp_aritmetica = exp_aritmetica();
			setState(589);
			((Exp_relacionalContext)_localctx).op_opcional = op_opcional();

			        ((Exp_relacionalContext)_localctx).nome =  ((Exp_relacionalContext)_localctx).exp_aritmetica.nome;
			        ((Exp_relacionalContext)_localctx).atributo =  ((Exp_relacionalContext)_localctx).exp_aritmetica.atributo;

			        if (((Exp_relacionalContext)_localctx).op_opcional.type.equals("")) {
			            ((Exp_relacionalContext)_localctx).compativel =  ((Exp_relacionalContext)_localctx).exp_aritmetica.compativel;
			            ((Exp_relacionalContext)_localctx).type =  ((Exp_relacionalContext)_localctx).exp_aritmetica.type;
			        } else {
			            ((Exp_relacionalContext)_localctx).compativel =  true;
			            ((Exp_relacionalContext)_localctx).type =  ((Exp_relacionalContext)_localctx).op_opcional.type;
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_opcionalContext extends ParserRuleContext {
		public String type;
		public boolean compativel;
		public Op_relacionalContext op_relacional() {
			return getRuleContext(Op_relacionalContext.class,0);
		}
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public Op_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_opcional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_opcionalContext op_opcional() throws RecognitionException {
		Op_opcionalContext _localctx = new Op_opcionalContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_op_opcional);

		        ((Op_opcionalContext)_localctx).type =  "";
		        ((Op_opcionalContext)_localctx).compativel =  true;
		    
		try {
			setState(597);
			switch (_input.LA(1)) {
			case T__5:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				op_relacional();
				setState(593);
				exp_aritmetica();

				        ((Op_opcionalContext)_localctx).type =  "logico";
				    
				}
				break;
			case T__1:
			case T__7:
			case T__8:
			case T__22:
			case T__23:
			case T__25:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__34:
			case T__35:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__45:
			case T__57:
			case T__58:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_relacionalContext extends ParserRuleContext {
		public Op_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_relacional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_relacionalContext op_relacional() throws RecognitionException {
		Op_relacionalContext _localctx = new Op_relacionalContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_op_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public boolean compativel;
		public String type;
		public String nome;
		public boolean atributo;
		public Termo_logicoContext termo_logico;
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public Outros_termos_logicosContext outros_termos_logicos() {
			return getRuleContext(Outros_termos_logicosContext.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_expressao);

		        ((ExpressaoContext)_localctx).nome =  "";
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			((ExpressaoContext)_localctx).termo_logico = termo_logico();
			setState(602);
			outros_termos_logicos();

			        ((ExpressaoContext)_localctx).compativel =  ((ExpressaoContext)_localctx).termo_logico.compativel;
			        ((ExpressaoContext)_localctx).type =  ((ExpressaoContext)_localctx).termo_logico.type;
			        ((ExpressaoContext)_localctx).nome =  ((ExpressaoContext)_localctx).termo_logico.nome;
			        ((ExpressaoContext)_localctx).atributo =  ((ExpressaoContext)_localctx).termo_logico.atributo;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_naoContext extends ParserRuleContext {
		public Op_naoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_nao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_nao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_naoContext op_nao() throws RecognitionException {
		Op_naoContext _localctx = new Op_naoContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_op_nao);
		try {
			setState(607);
			switch (_input.LA(1)) {
			case T__56:
				enterOuterAlt(_localctx, 1);
				{
				setState(605);
				match(T__56);
				}
				break;
			case T__8:
			case T__16:
			case T__17:
			case T__21:
			case T__45:
			case T__49:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Termo_logicoContext extends ParserRuleContext {
		public boolean compativel;
		public String type;
		public String nome;
		public boolean atributo;
		public Fator_logicoContext fator_logico;
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public Outros_fatores_logicosContext outros_fatores_logicos() {
			return getRuleContext(Outros_fatores_logicosContext.class,0);
		}
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_termo_logico);

		        ((Termo_logicoContext)_localctx).nome =  "";
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			((Termo_logicoContext)_localctx).fator_logico = fator_logico();
			setState(610);
			outros_fatores_logicos();

			        ((Termo_logicoContext)_localctx).compativel =  ((Termo_logicoContext)_localctx).fator_logico.compativel;
			        ((Termo_logicoContext)_localctx).type =  ((Termo_logicoContext)_localctx).fator_logico.type;
			        ((Termo_logicoContext)_localctx).nome =  ((Termo_logicoContext)_localctx).fator_logico.nome;
			        ((Termo_logicoContext)_localctx).atributo =  ((Termo_logicoContext)_localctx).fator_logico.atributo;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_termos_logicosContext extends ParserRuleContext {
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public Outros_termos_logicosContext outros_termos_logicos() {
			return getRuleContext(Outros_termos_logicosContext.class,0);
		}
		public Outros_termos_logicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_termos_logicos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_termos_logicos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_termos_logicosContext outros_termos_logicos() throws RecognitionException {
		Outros_termos_logicosContext _localctx = new Outros_termos_logicosContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_outros_termos_logicos);
		try {
			setState(618);
			switch (_input.LA(1)) {
			case T__57:
				enterOuterAlt(_localctx, 1);
				{
				setState(613);
				match(T__57);
				setState(614);
				termo_logico();
				setState(615);
				outros_termos_logicos();
				}
				break;
			case T__1:
			case T__7:
			case T__8:
			case T__22:
			case T__23:
			case T__25:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__34:
			case T__35:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__45:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_fatores_logicosContext extends ParserRuleContext {
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public Outros_fatores_logicosContext outros_fatores_logicos() {
			return getRuleContext(Outros_fatores_logicosContext.class,0);
		}
		public Outros_fatores_logicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_fatores_logicos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_fatores_logicos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_fatores_logicosContext outros_fatores_logicos() throws RecognitionException {
		Outros_fatores_logicosContext _localctx = new Outros_fatores_logicosContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_outros_fatores_logicos);
		try {
			setState(625);
			switch (_input.LA(1)) {
			case T__58:
				enterOuterAlt(_localctx, 1);
				{
				setState(620);
				match(T__58);
				setState(621);
				fator_logico();
				setState(622);
				outros_fatores_logicos();
				}
				break;
			case T__1:
			case T__7:
			case T__8:
			case T__22:
			case T__23:
			case T__25:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__34:
			case T__35:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__45:
			case T__57:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fator_logicoContext extends ParserRuleContext {
		public boolean compativel;
		public String type;
		public String nome;
		public boolean atributo;
		public Parcela_logicaContext parcela_logica;
		public Op_naoContext op_nao() {
			return getRuleContext(Op_naoContext.class,0);
		}
		public Parcela_logicaContext parcela_logica() {
			return getRuleContext(Parcela_logicaContext.class,0);
		}
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitFator_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_fator_logico);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			op_nao();
			setState(628);
			((Fator_logicoContext)_localctx).parcela_logica = parcela_logica();

			        ((Fator_logicoContext)_localctx).compativel =  ((Fator_logicoContext)_localctx).parcela_logica.compativel;
			        ((Fator_logicoContext)_localctx).type =  ((Fator_logicoContext)_localctx).parcela_logica.tipo_parcela_logica;
			        ((Fator_logicoContext)_localctx).nome =  ((Fator_logicoContext)_localctx).parcela_logica.nome;
			        ((Fator_logicoContext)_localctx).atributo =  ((Fator_logicoContext)_localctx).parcela_logica.atributo;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parcela_logicaContext extends ParserRuleContext {
		public String tipo_parcela_logica;
		public String nome;
		public boolean compativel;
		public boolean atributo;
		public Exp_relacionalContext exp_relacional;
		public Exp_relacionalContext exp_relacional() {
			return getRuleContext(Exp_relacionalContext.class,0);
		}
		public Parcela_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_logica; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_logicaContext parcela_logica() throws RecognitionException {
		Parcela_logicaContext _localctx = new Parcela_logicaContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_parcela_logica);

		        ((Parcela_logicaContext)_localctx).nome =  "";
		    
		try {
			setState(638);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				match(T__16);

				        ((Parcela_logicaContext)_localctx).tipo_parcela_logica =  "verdadeiro";
				    
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(633);
				match(T__17);

				        ((Parcela_logicaContext)_localctx).tipo_parcela_logica =  "falso";
				    
				}
				break;
			case T__8:
			case T__21:
			case T__45:
			case T__49:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
			case CADEIA:
				enterOuterAlt(_localctx, 3);
				{
				setState(635);
				((Parcela_logicaContext)_localctx).exp_relacional = exp_relacional();

				        ((Parcela_logicaContext)_localctx).tipo_parcela_logica =  ((Parcela_logicaContext)_localctx).exp_relacional.type;
				        ((Parcela_logicaContext)_localctx).compativel =  ((Parcela_logicaContext)_localctx).exp_relacional.compativel;
				        ((Parcela_logicaContext)_localctx).nome =  ((Parcela_logicaContext)_localctx).exp_relacional.nome;
				        ((Parcela_logicaContext)_localctx).atributo =  ((Parcela_logicaContext)_localctx).exp_relacional.atributo;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u0283\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3\u008b\n\3"+
		"\f\3\16\3\u008e\13\3\3\4\3\4\5\4\u0092\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a6\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u00b4\n\7\f\7\16\7\u00b7\13\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\t\u00c1\n\t\f\t\16\t\u00c4\13\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\7\n\u00cc\n\n\f\n\16\n\u00cf\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u00d6\n\13\f\13\16\13\u00d9\13\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u00e1\n\f\3\r\3\r\7\r\u00e5\n\r\f\r\16\r\u00e8\13\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f2\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00f9\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\6\22"+
		"\u0105\n\22\r\22\16\22\u0106\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\7\24\u0117\n\24\f\24\16\24\u011a\13\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0135\n\25"+
		"\3\26\3\26\5\26\u0139\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u014b\n\31\f\31\16\31\u014e\13"+
		"\31\3\32\3\32\5\32\u0152\n\32\3\33\3\33\3\33\5\33\u0157\n\33\3\34\7\34"+
		"\u015a\n\34\f\34\16\34\u015d\13\34\3\35\3\35\3\35\3\36\7\36\u0163\n\36"+
		"\f\36\16\36\u0166\13\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u01b2\n\37\3 \3 \3 \3"+
		" \7 \u01b8\n \f \16 \u01bb\13 \3!\3!\3!\5!\u01c0\n!\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\3#\3#\3$\3$\3$\3$\5$\u01d0\n$\3%\3%\3%\3%\3%\3&\3&\5&\u01d9"+
		"\n&\3\'\3\'\3\'\3(\3(\3(\5(\u01e1\n(\3)\3)\3)\3)\3*\3*\3*\3*\3*\5*\u01ec"+
		"\n*\3+\3+\5+\u01f0\n+\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3\60\3\60\3"+
		"\60\3\60\7\60\u0202\n\60\f\60\16\60\u0205\13\60\3\61\3\61\3\61\3\61\3"+
		"\62\3\62\3\62\7\62\u020e\n\62\f\62\16\62\u0211\13\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\5\63\u021a\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u022f"+
		"\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u0239\n\65\3\66\3\66"+
		"\7\66\u023d\n\66\f\66\16\66\u0240\13\66\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\5\67\u024d\n\67\38\38\38\38\39\39\39\39\39\5"+
		"9\u0258\n9\3:\3:\3;\3;\3;\3;\3<\3<\5<\u0262\n<\3=\3=\3=\3=\3>\3>\3>\3"+
		">\3>\5>\u026d\n>\3?\3?\3?\3?\3?\5?\u0274\n?\3@\3@\3@\3@\3A\3A\3A\3A\3"+
		"A\3A\3A\5A\u0281\nA\3A\2\2B\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\2\6\4\2"+
		"\23\24?A\3\2\61\62\4\2\60\60\63\63\4\2\b\b\66:\u027b\2\u0082\3\2\2\2\4"+
		"\u008c\3\2\2\2\6\u0091\3\2\2\2\b\u00a5\3\2\2\2\n\u00a7\3\2\2\2\f\u00b5"+
		"\3\2\2\2\16\u00b8\3\2\2\2\20\u00c2\3\2\2\2\22\u00cd\3\2\2\2\24\u00d7\3"+
		"\2\2\2\26\u00e0\3\2\2\2\30\u00e6\3\2\2\2\32\u00f1\3\2\2\2\34\u00f8\3\2"+
		"\2\2\36\u00fa\3\2\2\2 \u00fe\3\2\2\2\"\u0100\3\2\2\2$\u010a\3\2\2\2&\u0118"+
		"\3\2\2\2(\u0134\3\2\2\2*\u0138\3\2\2\2,\u013a\3\2\2\2.\u0142\3\2\2\2\60"+
		"\u014c\3\2\2\2\62\u0151\3\2\2\2\64\u0156\3\2\2\2\66\u015b\3\2\2\28\u015e"+
		"\3\2\2\2:\u0164\3\2\2\2<\u01b1\3\2\2\2>\u01b9\3\2\2\2@\u01bf\3\2\2\2B"+
		"\u01c1\3\2\2\2D\u01c5\3\2\2\2F\u01cf\3\2\2\2H\u01d1\3\2\2\2J\u01d8\3\2"+
		"\2\2L\u01da\3\2\2\2N\u01e0\3\2\2\2P\u01e2\3\2\2\2R\u01eb\3\2\2\2T\u01ef"+
		"\3\2\2\2V\u01f1\3\2\2\2X\u01f5\3\2\2\2Z\u01f7\3\2\2\2\\\u01f9\3\2\2\2"+
		"^\u0203\3\2\2\2`\u0206\3\2\2\2b\u020f\3\2\2\2d\u0219\3\2\2\2f\u022e\3"+
		"\2\2\2h\u0238\3\2\2\2j\u023e\3\2\2\2l\u024c\3\2\2\2n\u024e\3\2\2\2p\u0257"+
		"\3\2\2\2r\u0259\3\2\2\2t\u025b\3\2\2\2v\u0261\3\2\2\2x\u0263\3\2\2\2z"+
		"\u026c\3\2\2\2|\u0273\3\2\2\2~\u0275\3\2\2\2\u0080\u0280\3\2\2\2\u0082"+
		"\u0083\b\2\1\2\u0083\u0084\5\4\3\2\u0084\u0085\7\3\2\2\u0085\u0086\58"+
		"\35\2\u0086\u0087\7\4\2\2\u0087\u0088\7\2\2\3\u0088\3\3\2\2\2\u0089\u008b"+
		"\5\6\4\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\5\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0092\5\b\5\2"+
		"\u0090\u0092\5(\25\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\7\3"+
		"\2\2\2\u0093\u0094\7\5\2\2\u0094\u0095\5\n\6\2\u0095\u0096\b\5\1\2\u0096"+
		"\u00a6\3\2\2\2\u0097\u0098\7\6\2\2\u0098\u0099\7>\2\2\u0099\u009a\7\7"+
		"\2\2\u009a\u009b\5\32\16\2\u009b\u009c\7\b\2\2\u009c\u009d\5 \21\2\u009d"+
		"\u009e\b\5\1\2\u009e\u00a6\3\2\2\2\u009f\u00a0\7\t\2\2\u00a0\u00a1\7>"+
		"\2\2\u00a1\u00a2\7\7\2\2\u00a2\u00a3\5\26\f\2\u00a3\u00a4\b\5\1\2\u00a4"+
		"\u00a6\3\2\2\2\u00a5\u0093\3\2\2\2\u00a5\u0097\3\2\2\2\u00a5\u009f\3\2"+
		"\2\2\u00a6\t\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9\5\24\13\2\u00a9\u00aa"+
		"\5\f\7\2\u00aa\u00ab\7\7\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\b\6\1\2"+
		"\u00ad\13\3\2\2\2\u00ae\u00af\7\n\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\5"+
		"\24\13\2\u00b1\u00b2\b\7\1\2\u00b2\u00b4\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\r\3\2\2\2"+
		"\u00b7\u00b5\3\2\2\2\u00b8\u00b9\5\20\t\2\u00b9\u00ba\7>\2\2\u00ba\u00bb"+
		"\5\24\13\2\u00bb\u00bc\5\22\n\2\u00bc\u00bd\b\b\1\2\u00bd\17\3\2\2\2\u00be"+
		"\u00bf\7\13\2\2\u00bf\u00c1\b\t\1\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\21\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c6\7\f\2\2\u00c6\u00c7\5\20\t\2\u00c7\u00c8\7"+
		">\2\2\u00c8\u00c9\5\24\13\2\u00c9\u00ca\b\n\1\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c5\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\23\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7\r\2\2\u00d1\u00d2"+
		"\5V,\2\u00d2\u00d3\b\13\1\2\u00d3\u00d4\7\16\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00d0\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\25\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\5\"\22\2\u00db\u00dc"+
		"\b\f\1\2\u00dc\u00e1\3\2\2\2\u00dd\u00de\5\36\20\2\u00de\u00df\b\f\1\2"+
		"\u00df\u00e1\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00dd\3\2\2\2\u00e1\27"+
		"\3\2\2\2\u00e2\u00e3\7\n\2\2\u00e3\u00e5\5\16\b\2\u00e4\u00e2\3\2\2\2"+
		"\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\31"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7\17\2\2\u00ea\u00f2\b\16\1\2"+
		"\u00eb\u00ec\7\20\2\2\u00ec\u00f2\b\16\1\2\u00ed\u00ee\7\21\2\2\u00ee"+
		"\u00f2\b\16\1\2\u00ef\u00f0\7\22\2\2\u00f0\u00f2\b\16\1\2\u00f1\u00e9"+
		"\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\33\3\2\2\2\u00f3\u00f4\5\32\16\2\u00f4\u00f5\b\17\1\2\u00f5\u00f9\3\2"+
		"\2\2\u00f6\u00f7\7>\2\2\u00f7\u00f9\b\17\1\2\u00f8\u00f3\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\35\3\2\2\2\u00fa\u00fb\5\20\t\2\u00fb\u00fc\5\34"+
		"\17\2\u00fc\u00fd\b\20\1\2\u00fd\37\3\2\2\2\u00fe\u00ff\t\2\2\2\u00ff"+
		"!\3\2\2\2\u0100\u0104\7\25\2\2\u0101\u0102\5$\23\2\u0102\u0103\b\22\1"+
		"\2\u0103\u0105\3\2\2\2\u0104\u0101\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\26\2\2"+
		"\u0109#\3\2\2\2\u010a\u010b\7>\2\2\u010b\u010c\5\24\13\2\u010c\u010d\5"+
		"&\24\2\u010d\u010e\7\7\2\2\u010e\u010f\5\26\f\2\u010f\u0110\b\23\1\2\u0110"+
		"%\3\2\2\2\u0111\u0112\7\n\2\2\u0112\u0113\7>\2\2\u0113\u0114\5\24\13\2"+
		"\u0114\u0115\b\24\1\2\u0115\u0117\3\2\2\2\u0116\u0111\3\2\2\2\u0117\u011a"+
		"\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\'\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011b\u011c\7\27\2\2\u011c\u011d\7>\2\2\u011d\u011e\b\25"+
		"\1\2\u011e\u011f\7\30\2\2\u011f\u0120\5*\26\2\u0120\u0121\7\31\2\2\u0121"+
		"\u0122\5\66\34\2\u0122\u0123\5:\36\2\u0123\u0124\7\32\2\2\u0124\u0125"+
		"\b\25\1\2\u0125\u0135\3\2\2\2\u0126\u0127\7\33\2\2\u0127\u0128\7>\2\2"+
		"\u0128\u0129\b\25\1\2\u0129\u012a\7\30\2\2\u012a\u012b\5*\26\2\u012b\u012c"+
		"\7\31\2\2\u012c\u012d\7\7\2\2\u012d\u012e\5\36\20\2\u012e\u012f\b\25\1"+
		"\2\u012f\u0130\5\66\34\2\u0130\u0131\5:\36\2\u0131\u0132\7\34\2\2\u0132"+
		"\u0133\b\25\1\2\u0133\u0135\3\2\2\2\u0134\u011b\3\2\2\2\u0134\u0126\3"+
		"\2\2\2\u0135)\3\2\2\2\u0136\u0139\5,\27\2\u0137\u0139\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0138\u0137\3\2\2\2\u0139+\3\2\2\2\u013a\u013b\5\62\32\2\u013b"+
		"\u013c\5.\30\2\u013c\u013d\5\60\31\2\u013d\u013e\7\7\2\2\u013e\u013f\5"+
		"\36\20\2\u013f\u0140\b\27\1\2\u0140\u0141\5\64\33\2\u0141-\3\2\2\2\u0142"+
		"\u0143\5\20\t\2\u0143\u0144\7>\2\2\u0144\u0145\b\30\1\2\u0145\u0146\5"+
		"\24\13\2\u0146\u0147\5\22\n\2\u0147/\3\2\2\2\u0148\u0149\7\n\2\2\u0149"+
		"\u014b\5.\30\2\u014a\u0148\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\61\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0152"+
		"\7\35\2\2\u0150\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2"+
		"\u0152\63\3\2\2\2\u0153\u0154\7\n\2\2\u0154\u0157\5,\27\2\u0155\u0157"+
		"\3\2\2\2\u0156\u0153\3\2\2\2\u0156\u0155\3\2\2\2\u0157\65\3\2\2\2\u0158"+
		"\u015a\5\b\5\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\67\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f"+
		"\5\66\34\2\u015f\u0160\5:\36\2\u01609\3\2\2\2\u0161\u0163\5<\37\2\u0162"+
		"\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165;\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7\36\2\2\u0168\u0169"+
		"\7\30\2\2\u0169\u016a\5\16\b\2\u016a\u016b\5\30\r\2\u016b\u016c\7\31\2"+
		"\2\u016c\u016d\b\37\1\2\u016d\u01b2\3\2\2\2\u016e\u016f\7\37\2\2\u016f"+
		"\u0170\7\30\2\2\u0170\u0171\5t;\2\u0171\u0172\5> \2\u0172\u0173\7\31\2"+
		"\2\u0173\u0174\b\37\1\2\u0174\u01b2\3\2\2\2\u0175\u0176\7 \2\2\u0176\u0177"+
		"\5t;\2\u0177\u0178\7!\2\2\u0178\u0179\5:\36\2\u0179\u017a\5@!\2\u017a"+
		"\u017b\7\"\2\2\u017b\u017c\b\37\1\2\u017c\u01b2\3\2\2\2\u017d\u017e\7"+
		"#\2\2\u017e\u017f\5V,\2\u017f\u0180\7$\2\2\u0180\u0181\5H%\2\u0181\u0182"+
		"\5@!\2\u0182\u0183\7%\2\2\u0183\u0184\b\37\1\2\u0184\u01b2\3\2\2\2\u0185"+
		"\u0186\7&\2\2\u0186\u0187\7>\2\2\u0187\u0188\7\'\2\2\u0188\u0189\5V,\2"+
		"\u0189\u018a\7(\2\2\u018a\u018b\5V,\2\u018b\u018c\7)\2\2\u018c\u018d\5"+
		":\36\2\u018d\u018e\7*\2\2\u018e\u018f\b\37\1\2\u018f\u01b2\3\2\2\2\u0190"+
		"\u0191\7+\2\2\u0191\u0192\5t;\2\u0192\u0193\7)\2\2\u0193\u0194\5:\36\2"+
		"\u0194\u0195\7,\2\2\u0195\u0196\b\37\1\2\u0196\u01b2\3\2\2\2\u0197\u0198"+
		"\7)\2\2\u0198\u0199\5:\36\2\u0199\u019a\7(\2\2\u019a\u019b\5t;\2\u019b"+
		"\u019c\b\37\1\2\u019c\u01b2\3\2\2\2\u019d\u019e\7\13\2\2\u019e\u019f\7"+
		">\2\2\u019f\u01a0\5\24\13\2\u01a0\u01a1\5\22\n\2\u01a1\u01a2\7\'\2\2\u01a2"+
		"\u01a3\5t;\2\u01a3\u01a4\b\37\1\2\u01a4\u01b2\3\2\2\2\u01a5\u01a6\7>\2"+
		"\2\u01a6\u01a7\5B\"\2\u01a7\u01a8\b\37\1\2\u01a8\u01b2\3\2\2\2\u01a9\u01aa"+
		"\7>\2\2\u01aa\u01ab\5D#\2\u01ab\u01ac\b\37\1\2\u01ac\u01b2\3\2\2\2\u01ad"+
		"\u01ae\7-\2\2\u01ae\u01af\5t;\2\u01af\u01b0\b\37\1\2\u01b0\u01b2\3\2\2"+
		"\2\u01b1\u0167\3\2\2\2\u01b1\u016e\3\2\2\2\u01b1\u0175\3\2\2\2\u01b1\u017d"+
		"\3\2\2\2\u01b1\u0185\3\2\2\2\u01b1\u0190\3\2\2\2\u01b1\u0197\3\2\2\2\u01b1"+
		"\u019d\3\2\2\2\u01b1\u01a5\3\2\2\2\u01b1\u01a9\3\2\2\2\u01b1\u01ad\3\2"+
		"\2\2\u01b2=\3\2\2\2\u01b3\u01b4\7\n\2\2\u01b4\u01b5\5t;\2\u01b5\u01b6"+
		"\b \1\2\u01b6\u01b8\3\2\2\2\u01b7\u01b3\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9"+
		"\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba?\3\2\2\2\u01bb\u01b9\3\2\2\2"+
		"\u01bc\u01bd\7.\2\2\u01bd\u01c0\5:\36\2\u01be\u01c0\3\2\2\2\u01bf\u01bc"+
		"\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0A\3\2\2\2\u01c1\u01c2\7\30\2\2\u01c2"+
		"\u01c3\5F$\2\u01c3\u01c4\7\31\2\2\u01c4C\3\2\2\2\u01c5\u01c6\5\22\n\2"+
		"\u01c6\u01c7\5\24\13\2\u01c7\u01c8\7\'\2\2\u01c8\u01c9\5t;\2\u01c9\u01ca"+
		"\b#\1\2\u01caE\3\2\2\2\u01cb\u01cc\5t;\2\u01cc\u01cd\5> \2\u01cd\u01d0"+
		"\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01cb\3\2\2\2\u01cf\u01ce\3\2\2\2\u01d0"+
		"G\3\2\2\2\u01d1\u01d2\5L\'\2\u01d2\u01d3\7\7\2\2\u01d3\u01d4\5:\36\2\u01d4"+
		"\u01d5\5J&\2\u01d5I\3\2\2\2\u01d6\u01d9\5H%\2\u01d7\u01d9\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9K\3\2\2\2\u01da\u01db\5P)\2\u01db"+
		"\u01dc\5N(\2\u01dcM\3\2\2\2\u01dd\u01de\7\n\2\2\u01de\u01e1\5L\'\2\u01df"+
		"\u01e1\3\2\2\2\u01e0\u01dd\3\2\2\2\u01e0\u01df\3\2\2\2\u01e1O\3\2\2\2"+
		"\u01e2\u01e3\5T+\2\u01e3\u01e4\7?\2\2\u01e4\u01e5\5R*\2\u01e5Q\3\2\2\2"+
		"\u01e6\u01e7\7/\2\2\u01e7\u01e8\5T+\2\u01e8\u01e9\7?\2\2\u01e9\u01ec\3"+
		"\2\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01e6\3\2\2\2\u01eb\u01ea\3\2\2\2\u01ec"+
		"S\3\2\2\2\u01ed\u01f0\7\60\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01ed\3\2\2\2"+
		"\u01ef\u01ee\3\2\2\2\u01f0U\3\2\2\2\u01f1\u01f2\5\\/\2\u01f2\u01f3\5^"+
		"\60\2\u01f3\u01f4\b,\1\2\u01f4W\3\2\2\2\u01f5\u01f6\t\3\2\2\u01f6Y\3\2"+
		"\2\2\u01f7\u01f8\t\4\2\2\u01f8[\3\2\2\2\u01f9\u01fa\5`\61\2\u01fa\u01fb"+
		"\5b\62\2\u01fb\u01fc\b/\1\2\u01fc]\3\2\2\2\u01fd\u01fe\5Z.\2\u01fe\u01ff"+
		"\5\\/\2\u01ff\u0200\b\60\1\2\u0200\u0202\3\2\2\2\u0201\u01fd\3\2\2\2\u0202"+
		"\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204_\3\2\2\2"+
		"\u0205\u0203\3\2\2\2\u0206\u0207\5d\63\2\u0207\u0208\5j\66\2\u0208\u0209"+
		"\b\61\1\2\u0209a\3\2\2\2\u020a\u020b\5X-\2\u020b\u020c\5`\61\2\u020c\u020e"+
		"\3\2\2\2\u020d\u020a\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f"+
		"\u0210\3\2\2\2\u0210c\3\2\2\2\u0211\u020f\3\2\2\2\u0212\u0213\5T+\2\u0213"+
		"\u0214\5f\64\2\u0214\u0215\b\63\1\2\u0215\u021a\3\2\2\2\u0216\u0217\5"+
		"h\65\2\u0217\u0218\b\63\1\2\u0218\u021a\3\2\2\2\u0219\u0212\3\2\2\2\u0219"+
		"\u0216\3\2\2\2\u021ae\3\2\2\2\u021b\u021c\7\13\2\2\u021c\u021d\7>\2\2"+
		"\u021d\u021e\5\22\n\2\u021e\u021f\5\24\13\2\u021f\u0220\b\64\1\2\u0220"+
		"\u022f\3\2\2\2\u0221\u0222\7>\2\2\u0222\u0223\5l\67\2\u0223\u0224\b\64"+
		"\1\2\u0224\u022f\3\2\2\2\u0225\u0226\7?\2\2\u0226\u022f\b\64\1\2\u0227"+
		"\u0228\7@\2\2\u0228\u022f\b\64\1\2\u0229\u022a\7\30\2\2\u022a\u022b\5"+
		"t;\2\u022b\u022c\7\31\2\2\u022c\u022d\b\64\1\2\u022d\u022f\3\2\2\2\u022e"+
		"\u021b\3\2\2\2\u022e\u0221\3\2\2\2\u022e\u0225\3\2\2\2\u022e\u0227\3\2"+
		"\2\2\u022e\u0229\3\2\2\2\u022fg\3\2\2\2\u0230\u0231\7\64\2\2\u0231\u0232"+
		"\7>\2\2\u0232\u0233\5\22\n\2\u0233\u0234\5\24\13\2\u0234\u0235\b\65\1"+
		"\2\u0235\u0239\3\2\2\2\u0236\u0237\7A\2\2\u0237\u0239\b\65\1\2\u0238\u0230"+
		"\3\2\2\2\u0238\u0236\3\2\2\2\u0239i\3\2\2\2\u023a\u023b\7\65\2\2\u023b"+
		"\u023d\5d\63\2\u023c\u023a\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2"+
		"\2\2\u023e\u023f\3\2\2\2\u023fk\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0242"+
		"\7\30\2\2\u0242\u0243\5t;\2\u0243\u0244\5> \2\u0244\u0245\b\67\1\2\u0245"+
		"\u0246\7\31\2\2\u0246\u024d\3\2\2\2\u0247\u0248\5\22\n\2\u0248\u0249\5"+
		"\24\13\2\u0249\u024a\b\67\1\2\u024a\u024d\3\2\2\2\u024b\u024d\b\67\1\2"+
		"\u024c\u0241\3\2\2\2\u024c\u0247\3\2\2\2\u024c\u024b\3\2\2\2\u024dm\3"+
		"\2\2\2\u024e\u024f\5V,\2\u024f\u0250\5p9\2\u0250\u0251\b8\1\2\u0251o\3"+
		"\2\2\2\u0252\u0253\5r:\2\u0253\u0254\5V,\2\u0254\u0255\b9\1\2\u0255\u0258"+
		"\3\2\2\2\u0256\u0258\3\2\2\2\u0257\u0252\3\2\2\2\u0257\u0256\3\2\2\2\u0258"+
		"q\3\2\2\2\u0259\u025a\t\5\2\2\u025as\3\2\2\2\u025b\u025c\5x=\2\u025c\u025d"+
		"\5z>\2\u025d\u025e\b;\1\2\u025eu\3\2\2\2\u025f\u0262\7;\2\2\u0260\u0262"+
		"\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0260\3\2\2\2\u0262w\3\2\2\2\u0263"+
		"\u0264\5~@\2\u0264\u0265\5|?\2\u0265\u0266\b=\1\2\u0266y\3\2\2\2\u0267"+
		"\u0268\7<\2\2\u0268\u0269\5x=\2\u0269\u026a\5z>\2\u026a\u026d\3\2\2\2"+
		"\u026b\u026d\3\2\2\2\u026c\u0267\3\2\2\2\u026c\u026b\3\2\2\2\u026d{\3"+
		"\2\2\2\u026e\u026f\7=\2\2\u026f\u0270\5~@\2\u0270\u0271\5|?\2\u0271\u0274"+
		"\3\2\2\2\u0272\u0274\3\2\2\2\u0273\u026e\3\2\2\2\u0273\u0272\3\2\2\2\u0274"+
		"}\3\2\2\2\u0275\u0276\5v<\2\u0276\u0277\5\u0080A\2\u0277\u0278\b@\1\2"+
		"\u0278\177\3\2\2\2\u0279\u027a\7\23\2\2\u027a\u0281\bA\1\2\u027b\u027c"+
		"\7\24\2\2\u027c\u0281\bA\1\2\u027d\u027e\5n8\2\u027e\u027f\bA\1\2\u027f"+
		"\u0281\3\2\2\2\u0280\u0279\3\2\2\2\u0280\u027b\3\2\2\2\u0280\u027d\3\2"+
		"\2\2\u0281\u0081\3\2\2\2*\u008c\u0091\u00a5\u00b5\u00c2\u00cd\u00d7\u00e0"+
		"\u00e6\u00f1\u00f8\u0106\u0118\u0134\u0138\u014c\u0151\u0156\u015b\u0164"+
		"\u01b1\u01b9\u01bf\u01cf\u01d8\u01e0\u01eb\u01ef\u0203\u020f\u0219\u022e"+
		"\u0238\u023e\u024c\u0257\u0261\u026c\u0273\u0280";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}