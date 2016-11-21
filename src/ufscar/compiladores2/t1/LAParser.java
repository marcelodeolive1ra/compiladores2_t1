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
		IDENT=60, IDENT_ERRADO=61, NUM_INT=62, NUM_ERRADO=63, NUM_REAL=64, CADEIA=65, 
		COMENTARIO=66, ESPACO=67, COMENTARIO_ERRADO=68, ERROR=69;
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
		"IDENT", "IDENT_ERRADO", "NUM_INT", "NUM_ERRADO", "NUM_REAL", "CADEIA", 
		"COMENTARIO", "ESPACO", "COMENTARIO_ERRADO", "ERROR"
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
	Tipos tipos = new Tipos();
	Funcoes funcoes = new Funcoes();
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
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitPrograma(this);
		}
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
			pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
			setState(129);
			declaracoes();
			setState(130);
			match(T__0);
			setState(131);
			corpo();
			setState(132);
			match(T__1);
			pilhaDeTabelas.desempilhar();
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracoes(this);
		}
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
		public int dec;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDecl_local_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDecl_local_global(this);
		}
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
			setState(147);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				declaracao_local();
				((Decl_local_globalContext)_localctx).dec =  1;
				}
				break;
			case T__20:
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				declaracao_global();
				((Decl_local_globalContext)_localctx).dec =  2;
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
		public int tipoDec;
		public String name;
		public String tipoVar;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_local(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_local(this);
		}
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
			setState(167);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(T__2);
				setState(150);
				((Declaracao_localContext)_localctx).variavel = variavel();
				((Declaracao_localContext)_localctx).name =  ((Declaracao_localContext)_localctx).variavel.name; ((Declaracao_localContext)_localctx).tipoVar =  ((Declaracao_localContext)_localctx).variavel.tipoVar; ((Declaracao_localContext)_localctx).tipoDec =  1;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(T__3);
				setState(154);
				((Declaracao_localContext)_localctx).IDENT = match(IDENT);
				setState(155);
				match(T__4);
				setState(156);
				((Declaracao_localContext)_localctx).tipo_basico = tipo_basico();
				setState(157);
				match(T__5);
				setState(158);
				valor_constante();
				pilhaDeTabelas.topo().adicionarSimbolo((((Declaracao_localContext)_localctx).IDENT!=null?((Declaracao_localContext)_localctx).IDENT.getText():null), ((Declaracao_localContext)_localctx).tipo_basico.tipodado, "constante");
				       ((Declaracao_localContext)_localctx).tipoDec =  2;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				match(T__6);
				setState(162);
				((Declaracao_localContext)_localctx).IDENT = match(IDENT);
				setState(163);
				match(T__4);
				setState(164);
				((Declaracao_localContext)_localctx).tipo = tipo();
				tipos.addTipo((((Declaracao_localContext)_localctx).IDENT!=null?((Declaracao_localContext)_localctx).IDENT.getText():null), ((Declaracao_localContext)_localctx).tipo.atributos);
				       pilhaDeTabelas.topo().adicionarSimbolo((((Declaracao_localContext)_localctx).IDENT!=null?((Declaracao_localContext)_localctx).IDENT.getText():null), "indefinido", "tipo");
				       ((Declaracao_localContext)_localctx).tipoDec =  3;
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
		public String name;
		public String tipoVar;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitVariavel(this);
		}
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
			setState(169);
			((VariavelContext)_localctx).IDENT = match(IDENT);
			setState(170);
			dimensao();
			setState(171);
			((VariavelContext)_localctx).mais_var = mais_var();
			setState(172);
			match(T__4);
			setState(173);
			((VariavelContext)_localctx).tipo = tipo();
			  List<Pair> nomes = new ArrayList<Pair>();
			            nomes = ((VariavelContext)_localctx).mais_var.nomes;
			            Pair pair = new Pair((((VariavelContext)_localctx).IDENT!=null?((VariavelContext)_localctx).IDENT.getText():null), (((VariavelContext)_localctx).IDENT!=null?((VariavelContext)_localctx).IDENT.getLine():0));
			            nomes.add(0, pair);
			            for (Pair var : nomes) {
			                if(!pilhaDeTabelas.existeSimbolo(var.a.toString()))
			                    pilhaDeTabelas.topo().adicionarSimbolo(var.a.toString(), ((VariavelContext)_localctx).tipo.tipodado, "variavel");
			                else
			                    Mensagens.erroVariavelJaExiste(var.a.toString(), Integer.parseInt(var.b.toString()));

			            }

			            ((VariavelContext)_localctx).name =  (((VariavelContext)_localctx).IDENT!=null?((VariavelContext)_localctx).IDENT.getText():null);
			            ((VariavelContext)_localctx).tipoVar =  ((VariavelContext)_localctx).tipo.tipodado;
			         
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_var(this);
		}
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
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(176);
				match(T__7);
				setState(177);
				((Mais_varContext)_localctx).IDENT = match(IDENT);
				setState(178);
				dimensao();
				Pair pair = new Pair((((Mais_varContext)_localctx).IDENT!=null?((Mais_varContext)_localctx).IDENT.getText():null), (((Mais_varContext)_localctx).IDENT!=null?((Mais_varContext)_localctx).IDENT.getLine():0)); _localctx.nomes.add(pair);
				}
				}
				setState(185);
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
		public String nameVar;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitIdentificador(this);
		}
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
			setState(186);
			ponteiros_opcionais();
			setState(187);
			((IdentificadorContext)_localctx).IDENT = match(IDENT);
			setState(188);
			dimensao();
			setState(189);
			((IdentificadorContext)_localctx).outros_ident = outros_ident();
			((IdentificadorContext)_localctx).nameVar =  (((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getText():null);
			if(!pilhaDeTabelas.existeSimbolo((((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getText():null)))
			                     Mensagens.erroVariavelNaoExiste((((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getText():null), (((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getLine():0));
			                     else if (!((IdentificadorContext)_localctx).outros_ident.id.equals("")) {
			                        String var = (((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getText():null) + ((IdentificadorContext)_localctx).outros_ident.id;
			                        String tipo = pilhaDeTabelas.getVarTipo((((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getText():null));
			                        String atr = ((IdentificadorContext)_localctx).outros_ident.id.substring(1);
			                        if(!tipos.existeAtributo(tipo, atr))
			                            Mensagens.erroVariavelNaoExiste(var, (((IdentificadorContext)_localctx).IDENT!=null?((IdentificadorContext)_localctx).IDENT.getLine():0));
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

	public static class Ponteiros_opcionaisContext extends ParserRuleContext {
		public String ponteiros;
		public Ponteiros_opcionaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ponteiros_opcionais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterPonteiros_opcionais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitPonteiros_opcionais(this);
		}
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
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(193);
				match(T__8);
				_localctx.ponteiros += "^";
				}
				}
				setState(199);
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOutros_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_identContext outros_ident() throws RecognitionException {
		Outros_identContext _localctx = new Outros_identContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_outros_ident);
		((Outros_identContext)_localctx).id =  ""; ((Outros_identContext)_localctx).name =  ""; ((Outros_identContext)_localctx).temAtributo =  false;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(200);
				match(T__9);
				setState(201);
				ponteiros_opcionais();
				setState(202);
				((Outros_identContext)_localctx).IDENT = match(IDENT);
				setState(203);
				dimensao();
				_localctx.id += "." + (((Outros_identContext)_localctx).IDENT!=null?((Outros_identContext)_localctx).IDENT.getText():null);
				                                               ((Outros_identContext)_localctx).name =  (((Outros_identContext)_localctx).IDENT!=null?((Outros_identContext)_localctx).IDENT.getText():null);
				                                               ((Outros_identContext)_localctx).temAtributo =  true;
				}
				}
				setState(210);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDimensao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDimensao(this);
		}
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
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(211);
					match(T__10);
					setState(212);
					((DimensaoContext)_localctx).exp_aritmetica = exp_aritmetica();
					((DimensaoContext)_localctx).indice =  ((DimensaoContext)_localctx).exp_aritmetica.indice;
					setState(214);
					match(T__11);
					}
					} 
				}
				setState(220);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo(this);
		}
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
			setState(227);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				((TipoContext)_localctx).registro = registro();
				((TipoContext)_localctx).tipodado =  "registro"; ((TipoContext)_localctx).atributos =  ((TipoContext)_localctx).registro.atributos;
				                tipos.addTipo("registro", _localctx.atributos);
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
				setState(224);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_ident(this);
		}
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
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(229);
				match(T__7);
				setState(230);
				identificador();
				}
				}
				setState(235);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_basico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_basico(this);
		}
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
			setState(244);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(T__12);
				((Tipo_basicoContext)_localctx).tipodado =  "literal";
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(T__13);
				((Tipo_basicoContext)_localctx).tipodado =  "inteiro";
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(T__14);
				((Tipo_basicoContext)_localctx).tipodado =  "real";
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(242);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_basico_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_basico_ident(this);
		}
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
			setState(251);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				((Tipo_basico_identContext)_localctx).tipo_basico = tipo_basico();
				((Tipo_basico_identContext)_localctx).tipodado =  ((Tipo_basico_identContext)_localctx).tipo_basico.tipodado;
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				((Tipo_basico_identContext)_localctx).IDENT = match(IDENT);
				((Tipo_basico_identContext)_localctx).tipodado =  (((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getText():null);
				             if(!tipos.existeTipo((((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getText():null)))
				                Mensagens.erroTipoNaoExiste((((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getText():null), (((Tipo_basico_identContext)_localctx).IDENT!=null?((Tipo_basico_identContext)_localctx).IDENT.getLine():0));
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_estendido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_estendido(this);
		}
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
			setState(253);
			((Tipo_estendidoContext)_localctx).ponteiros_opcionais = ponteiros_opcionais();
			setState(254);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterValor_constante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitValor_constante(this);
		}
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
			setState(257);
			_la = _input.LA(1);
			if ( !(((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (NUM_INT - 17)) | (1L << (NUM_REAL - 17)) | (1L << (CADEIA - 17)))) != 0)) ) {
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitRegistro(this);
		}
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
			setState(259);
			match(T__18);
			setState(263); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(260);
				((RegistroContext)_localctx).variavel_registro = variavel_registro();
				_localctx.atributos.addAll(((RegistroContext)_localctx).variavel_registro.atributos);
				}
				}
				setState(265); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(267);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterVariavel_registro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitVariavel_registro(this);
		}
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
			setState(269);
			((Variavel_registroContext)_localctx).IDENT = match(IDENT);
			setState(270);
			dimensao();
			setState(271);
			((Variavel_registroContext)_localctx).mais_var_registro = mais_var_registro();
			setState(272);
			match(T__4);
			setState(273);
			((Variavel_registroContext)_localctx).tipo = tipo();
			Pair pair = new Pair((((Variavel_registroContext)_localctx).IDENT!=null?((Variavel_registroContext)_localctx).IDENT.getText():null), ((Variavel_registroContext)_localctx).tipo.tipodado);
			       _localctx.atributos.add(pair);
			       for (String atr : ((Variavel_registroContext)_localctx).mais_var_registro.atributos) {
			           Pair npair = new Pair(atr, ((Variavel_registroContext)_localctx).tipo.tipodado);
			           _localctx.atributos.add(npair);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_var_registro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_var_registro(this);
		}
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
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(276);
				match(T__7);
				setState(277);
				((Mais_var_registroContext)_localctx).IDENT = match(IDENT);
				setState(278);
				dimensao();
				_localctx.atributos.add((((Mais_var_registroContext)_localctx).IDENT!=null?((Mais_var_registroContext)_localctx).IDENT.getText():null));
				}
				}
				setState(285);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_global(this);
		}
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
			setState(311);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(T__20);
				setState(287);
				((Declaracao_globalContext)_localctx).IDENT = match(IDENT);
				pilhaDeTabelas.topo().adicionarSimbolo((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null), "void", "procedimento");
				                     pilhaDeTabelas.empilhar(new TabelaDeSimbolos("procedimento_"+(((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null)));
				                     funcoes.addFuncao((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null));
				setState(289);
				match(T__21);
				setState(290);
				parametros_opcional();
				setState(291);
				match(T__22);
				setState(292);
				declaracoes_locais();
				setState(293);
				comandos();
				setState(294);
				match(T__23);
				pilhaDeTabelas.desempilhar();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(T__24);
				setState(298);
				((Declaracao_globalContext)_localctx).IDENT = match(IDENT);
				funcoes.addFuncao((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null));
				                                    pilhaDeTabelas.empilhar(new TabelaDeSimbolos("funcao_"+(((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null)));
				setState(300);
				match(T__21);
				setState(301);
				parametros_opcional();
				setState(302);
				match(T__22);
				setState(303);
				match(T__4);
				setState(304);
				((Declaracao_globalContext)_localctx).tipo_estendido = tipo_estendido();
				pilhaDeTabelas.tabelaGlobal().adicionarSimbolo((((Declaracao_globalContext)_localctx).IDENT!=null?((Declaracao_globalContext)_localctx).IDENT.getText():null), ((Declaracao_globalContext)_localctx).tipo_estendido.tipodado, "funcao");
				setState(306);
				declaracoes_locais();
				setState(307);
				comandos();
				setState(308);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParametros_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParametros_opcional(this);
		}
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
			setState(315);
			switch (_input.LA(1)) {
			case T__8:
			case T__26:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParametro(this);
		}
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
			setState(317);
			var_opcional();
			setState(318);
			((ParametroContext)_localctx).ident_param = ident_param();
			setState(319);
			mais_id_param();
			setState(320);
			match(T__4);
			setState(321);
			((ParametroContext)_localctx).tipo_estendido = tipo_estendido();
			pilhaDeTabelas.topo().adicionarSimbolo(((ParametroContext)_localctx).ident_param.param, ((ParametroContext)_localctx).tipo_estendido.tipodado, "parametro");
			             funcoes.topo().add(((ParametroContext)_localctx).tipo_estendido.tipodado);
			setState(323);
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
		public String param;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterIdent_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitIdent_param(this);
		}
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
			setState(325);
			ponteiros_opcionais();
			setState(326);
			((Ident_paramContext)_localctx).IDENT = match(IDENT);
			((Ident_paramContext)_localctx).param =  (((Ident_paramContext)_localctx).IDENT!=null?((Ident_paramContext)_localctx).IDENT.getText():null);
			setState(328);
			dimensao();
			setState(329);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_id_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_id_param(this);
		}
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
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(331);
				match(T__7);
				setState(332);
				ident_param();
				}
				}
				setState(337);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterVar_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitVar_opcional(this);
		}
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
			setState(340);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_parametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_parametros(this);
		}
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
			setState(345);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(T__7);
				setState(343);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracoes_locais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracoes_locais(this);
		}
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
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__6))) != 0)) {
				{
				{
				setState(347);
				declaracao_local();
				}
				}
				setState(352);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCorpo(this);
		}
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
			setState(353);
			declaracoes_locais();
			setState(354);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitComandos(this);
		}
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
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__32) | (1L << T__35) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << IDENT))) != 0)) {
				{
				{
				setState(356);
				cmd();
				}
				}
				setState(361);
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
		public int tipoCmd;
		public String nameVar;
		public String tipoVar;
		public IdentificadorContext identificador;
		public ExpressaoContext expressao;
		public Token IDENT;
		public AtribuicaoContext atribuicao;
		public Token r;
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
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmd(this);
		}
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
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				match(T__27);
				setState(363);
				match(T__21);
				setState(364);
				((CmdContext)_localctx).identificador = identificador();
				setState(365);
				mais_ident();
				setState(366);
				match(T__22);
				 ((CmdContext)_localctx).tipoCmd =  1; ((CmdContext)_localctx).nameVar =  ((CmdContext)_localctx).identificador.nameVar; ((CmdContext)_localctx).tipoVar =  pilhaDeTabelas.getTypeData(((CmdContext)_localctx).identificador.nameVar);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				match(T__28);
				setState(370);
				match(T__21);
				setState(371);
				((CmdContext)_localctx).expressao = expressao();
				setState(372);
				mais_expressao();
				setState(373);
				match(T__22);
				 ((CmdContext)_localctx).tipoCmd =  2; ((CmdContext)_localctx).nameVar =  ((CmdContext)_localctx).expressao.name; ((CmdContext)_localctx).tipoVar =  ((CmdContext)_localctx).expressao.type; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				match(T__29);
				setState(377);
				expressao();
				setState(378);
				match(T__30);
				setState(379);
				comandos();
				setState(380);
				senao_opcional();
				setState(381);
				match(T__31);
				 ((CmdContext)_localctx).tipoCmd =  3; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(384);
				match(T__32);
				setState(385);
				exp_aritmetica();
				setState(386);
				match(T__33);
				setState(387);
				selecao();
				setState(388);
				senao_opcional();
				setState(389);
				match(T__34);
				 ((CmdContext)_localctx).tipoCmd =  4; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(392);
				match(T__35);
				setState(393);
				((CmdContext)_localctx).IDENT = match(IDENT);
				setState(394);
				match(T__36);
				setState(395);
				exp_aritmetica();
				setState(396);
				match(T__37);
				setState(397);
				exp_aritmetica();
				setState(398);
				match(T__38);
				setState(399);
				comandos();
				setState(400);
				match(T__39);
				 ((CmdContext)_localctx).tipoCmd =  5; ((CmdContext)_localctx).nameVar =  (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(403);
				match(T__40);
				setState(404);
				expressao();
				setState(405);
				match(T__38);
				setState(406);
				comandos();
				setState(407);
				match(T__41);
				 ((CmdContext)_localctx).tipoCmd =  6; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(410);
				match(T__38);
				setState(411);
				comandos();
				setState(412);
				match(T__37);
				setState(413);
				expressao();
				 ((CmdContext)_localctx).tipoCmd =  7; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(416);
				match(T__8);
				setState(417);
				match(IDENT);
				setState(418);
				outros_ident();
				setState(419);
				dimensao();
				setState(420);
				match(T__36);
				setState(421);
				expressao();
				 ((CmdContext)_localctx).tipoCmd =  8; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(424);
				match(IDENT);
				setState(425);
				chamada();
				 ((CmdContext)_localctx).tipoCmd =  9; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(428);
				((CmdContext)_localctx).IDENT = match(IDENT);
				setState(429);
				((CmdContext)_localctx).atribuicao = atribuicao();
				if(!pilhaDeTabelas.existeSimbolo((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null))){
				                            Mensagens.erroVariavelNaoExiste((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null), (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getLine():0));
				                        }else if(!((CmdContext)_localctx).atribuicao.compativel && !((CmdContext)_localctx).atribuicao.type.equals("") && !pilhaDeTabelas.getTypeData((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null)).equals(((CmdContext)_localctx).atribuicao.type)){
				                            if(!(pilhaDeTabelas.getTypeData((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null)).equals("real") && ((CmdContext)_localctx).atribuicao.type.equals("inteiro"))){
				                                if(((CmdContext)_localctx).atribuicao.indice != -1){
				                                      Mensagens.erroVariavelNaoCompativel((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null)+"["+((CmdContext)_localctx).atribuicao.indice+"]", (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getLine():0));
				                                }else if(!((CmdContext)_localctx).atribuicao.name.equals("")){
				                                     if(!tipos.getTipoAtr(((CmdContext)_localctx).atribuicao.name).equals(((CmdContext)_localctx).atribuicao.type)) {
				                                            if(tipos.getTipoAtr(((CmdContext)_localctx).atribuicao.name).equals("real") && ((CmdContext)_localctx).atribuicao.type.equals("inteiro")){
				                                                //pass
				                                            }else{
				                                                if(!tipos.getTipoAtr(((CmdContext)_localctx).atribuicao.name).equals(pilhaDeTabelas.getTypeData((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null))))
				                                                    Mensagens.erroVariavelNaoCompativel((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null)+"."+((CmdContext)_localctx).atribuicao.name, (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getLine():0));
				                                            }
				                                     }else{}
				                                }else{
				                                      Mensagens.erroVariavelNaoCompativel((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null), (((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getLine():0));
				                                }
				                            }

				                        }if((((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null).equals("ponteiro") && ((CmdContext)_localctx).atribuicao.type.equals("")) {
				                             Mensagens.erroVariavelNaoCompativel("^"+(((CmdContext)_localctx).IDENT!=null?((CmdContext)_localctx).IDENT.getText():null), 14);
				                         }
				                        
				 ((CmdContext)_localctx).tipoCmd =  10; 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(433);
				((CmdContext)_localctx).r = match(T__42);
				setState(434);
				expressao();
				 if(!pilhaDeTabelas.topo().getType().equals("funcao"))
				                                    Mensagens.escopoNaoPermitido((((CmdContext)_localctx).r!=null?((CmdContext)_localctx).r.getLine():0));
				 ((CmdContext)_localctx).tipoCmd =  11; 
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_expressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_expressao(this);
		}
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
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(440);
				match(T__7);
				setState(441);
				((Mais_expressaoContext)_localctx).expressao = expressao();
				_localctx.tipos.add(((Mais_expressaoContext)_localctx).expressao.type);
				}
				}
				setState(448);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterSenao_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitSenao_opcional(this);
		}
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
			setState(452);
			switch (_input.LA(1)) {
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				match(T__43);
				setState(450);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterChamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitChamada(this);
		}
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
			setState(454);
			match(T__21);
			setState(455);
			argumentos_opcional();
			setState(456);
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
		public String name;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_atribuicao);
		((AtribuicaoContext)_localctx).type =  ""; ((AtribuicaoContext)_localctx).name =  "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			((AtribuicaoContext)_localctx).outros_ident = outros_ident();
			setState(459);
			((AtribuicaoContext)_localctx).dimensao = dimensao();
			setState(460);
			match(T__36);
			setState(461);
			((AtribuicaoContext)_localctx).expressao = expressao();
			((AtribuicaoContext)_localctx).type =  ((AtribuicaoContext)_localctx).expressao.type;
			                                            if(((AtribuicaoContext)_localctx).outros_ident.name.equals("")){
			                                                if(!((AtribuicaoContext)_localctx).expressao.name.equals("")){
			                                                     ((AtribuicaoContext)_localctx).compativel =  false;
			                                                     if(((AtribuicaoContext)_localctx).expressao.temAtributo)
			                                                        ((AtribuicaoContext)_localctx).name =  ((AtribuicaoContext)_localctx).expressao.name;
			                                                }else{
			                                                      ((AtribuicaoContext)_localctx).compativel =  ((AtribuicaoContext)_localctx).expressao.compativel; ((AtribuicaoContext)_localctx).type =  ((AtribuicaoContext)_localctx).expressao.type;
			                                                 }
			                                            }else{
			                                                ((AtribuicaoContext)_localctx).compativel =  false; ((AtribuicaoContext)_localctx).type =  ((AtribuicaoContext)_localctx).expressao.type;
			                                                ((AtribuicaoContext)_localctx).name =  ((AtribuicaoContext)_localctx).outros_ident.name;
			                                             }
			                                            ((AtribuicaoContext)_localctx).indice =  ((AtribuicaoContext)_localctx).dimensao.indice;
			                                            
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterArgumentos_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitArgumentos_opcional(this);
		}
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
			setState(468);
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
				setState(464);
				expressao();
				setState(465);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitSelecao(this);
		}
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
			setState(470);
			constantes();
			setState(471);
			match(T__4);
			setState(472);
			comandos();
			setState(473);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_selecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_selecao(this);
		}
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
			setState(477);
			switch (_input.LA(1)) {
			case T__45:
			case NUM_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitConstantes(this);
		}
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
			setState(479);
			numero_intervalo();
			setState(480);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterMais_constantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitMais_constantes(this);
		}
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
			setState(485);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				match(T__7);
				setState(483);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterNumero_intervalo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitNumero_intervalo(this);
		}
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
			setState(487);
			op_unario();
			setState(488);
			match(NUM_INT);
			setState(489);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterIntervalo_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitIntervalo_opcional(this);
		}
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
			setState(496);
			switch (_input.LA(1)) {
			case T__44:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				match(T__44);
				setState(492);
				op_unario();
				setState(493);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_unario(this);
		}
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
			setState(500);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExp_aritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExp_aritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_aritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_aritmeticaContext exp_aritmetica() throws RecognitionException {
		Exp_aritmeticaContext _localctx = new Exp_aritmeticaContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_exp_aritmetica);
		((Exp_aritmeticaContext)_localctx).compativel =  false; ((Exp_aritmeticaContext)_localctx).type =  ""; ((Exp_aritmeticaContext)_localctx).name =  ""; ((Exp_aritmeticaContext)_localctx).temAtributo = false;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			((Exp_aritmeticaContext)_localctx).termo = termo();
			setState(503);
			((Exp_aritmeticaContext)_localctx).outros_termos = outros_termos();
			((Exp_aritmeticaContext)_localctx).name =  ((Exp_aritmeticaContext)_localctx).termo.name;
			                           ((Exp_aritmeticaContext)_localctx).temAtributo =  ((Exp_aritmeticaContext)_localctx).termo.temAtributo;
			                           if(!((Exp_aritmeticaContext)_localctx).outros_termos.type.equals("") && !((Exp_aritmeticaContext)_localctx).termo.type.equals(((Exp_aritmeticaContext)_localctx).outros_termos.type)){
			                                ((Exp_aritmeticaContext)_localctx).compativel =  false;
			                                ((Exp_aritmeticaContext)_localctx).type =  ((Exp_aritmeticaContext)_localctx).outros_termos.type;
			                                ((Exp_aritmeticaContext)_localctx).indice =  ((Exp_aritmeticaContext)_localctx).termo.indice;
			                           }else{
			                                ((Exp_aritmeticaContext)_localctx).compativel =  false;
			                                ((Exp_aritmeticaContext)_localctx).type =  ((Exp_aritmeticaContext)_localctx).termo.type;};
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_multiplicacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_multiplicacao(this);
		}
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
			setState(506);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_adicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_adicao(this);
		}
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
			setState(508);
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_termo);
		((TermoContext)_localctx).name =  ""; ((TermoContext)_localctx).temAtributo =  false;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			((TermoContext)_localctx).fator = fator();
			setState(511);
			outros_fatores();
			((TermoContext)_localctx).type =  ((TermoContext)_localctx).fator.type; ((TermoContext)_localctx).indice =  ((TermoContext)_localctx).fator.indice; ((TermoContext)_localctx).name =  ((TermoContext)_localctx).fator.name; ((TermoContext)_localctx).temAtributo =  ((TermoContext)_localctx).fator.temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_termos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_termos(this);
		}
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
			setState(520);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(514);
					op_adicao();
					setState(515);
					((Outros_termosContext)_localctx).termo = termo();
					((Outros_termosContext)_localctx).type =  ((Outros_termosContext)_localctx).termo.type;
					}
					} 
				}
				setState(522);
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitFator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_fator);
		((FatorContext)_localctx).name =  ""; ((FatorContext)_localctx).temAtributo = false;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			((FatorContext)_localctx).parcela = parcela();
			setState(524);
			outras_parcelas();
			((FatorContext)_localctx).type =  ((FatorContext)_localctx).parcela.type; ((FatorContext)_localctx).indice =  ((FatorContext)_localctx).parcela.indice; ((FatorContext)_localctx).name =  ((FatorContext)_localctx).parcela.name; ((FatorContext)_localctx).temAtributo =  ((FatorContext)_localctx).parcela.temAtributo;;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_fatores(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_fatores(this);
		}
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
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__46 || _la==T__47) {
				{
				{
				setState(527);
				op_multiplicacao();
				setState(528);
				fator();
				}
				}
				setState(534);
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
		public String name;
		public int parcelaTipo;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParcelaContext parcela() throws RecognitionException {
		ParcelaContext _localctx = new ParcelaContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parcela);
		((ParcelaContext)_localctx).name =  ""; ((ParcelaContext)_localctx).temAtributo =  false;
		try {
			setState(542);
			switch (_input.LA(1)) {
			case T__8:
			case T__21:
			case T__45:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				op_unario();
				setState(536);
				((ParcelaContext)_localctx).parcela_unario = parcela_unario();
				((ParcelaContext)_localctx).type =  ((ParcelaContext)_localctx).parcela_unario.type; ((ParcelaContext)_localctx).indice =  ((ParcelaContext)_localctx).parcela_unario.indice; ((ParcelaContext)_localctx).name =  ((ParcelaContext)_localctx).parcela_unario.name; ((ParcelaContext)_localctx).parcelaTipo =  1; ((ParcelaContext)_localctx).temAtributo =  ((ParcelaContext)_localctx).parcela_unario.temAtributo;
				}
				break;
			case T__49:
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(539);
				((ParcelaContext)_localctx).parcela_nao_unario = parcela_nao_unario();
				((ParcelaContext)_localctx).type =  ((ParcelaContext)_localctx).parcela_nao_unario.type; ((ParcelaContext)_localctx).parcelaTipo =  2;
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
		public String name;
		public int tipoParc;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_unarioContext parcela_unario() throws RecognitionException {
		Parcela_unarioContext _localctx = new Parcela_unarioContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_parcela_unario);
		((Parcela_unarioContext)_localctx).type =  ""; ((Parcela_unarioContext)_localctx).indice =  -1; ((Parcela_unarioContext)_localctx).name =  ""; ((Parcela_unarioContext)_localctx).temAtributo =  false;
		try {
			setState(563);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				match(T__8);
				setState(545);
				((Parcela_unarioContext)_localctx).IDENT = match(IDENT);
				setState(546);
				outros_ident();
				setState(547);
				dimensao();
				((Parcela_unarioContext)_localctx).type =  pilhaDeTabelas.getTypeData((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null)); ((Parcela_unarioContext)_localctx).tipoParc =  1;
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
				((Parcela_unarioContext)_localctx).IDENT = match(IDENT);
				setState(551);
				((Parcela_unarioContext)_localctx).chamada_partes = chamada_partes();
				if(!pilhaDeTabelas.existeSimbolo((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null)))
				                                Mensagens.erroVariavelNaoExiste((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null)+((Parcela_unarioContext)_localctx).chamada_partes.id, (((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getLine():0));
				                            ((Parcela_unarioContext)_localctx).type =  pilhaDeTabelas.getTypeData((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null));
				                            if(!((Parcela_unarioContext)_localctx).chamada_partes.tipos.isEmpty()) {
				                                List<String> tipos = funcoes.getFuncTipos((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null));
				                                List<String> params = ((Parcela_unarioContext)_localctx).chamada_partes.tipos;
				                                boolean erro = false;
				                                if(tipos != null) {
				                                    for(int i = 1; i < tipos.size(); i++) {
				                                        try {
				                                            if(!tipos.get(i).equals(params.get(i)) && !params.get(i).equals("")) {
				                                                erro = true;
				                                                break;
				                                            }
				                                        } catch (IndexOutOfBoundsException ioobe) {
				                                              erro = true;
				                                        }

				                                    }
				                                }
				                                if (erro == true)
				                                    Mensagens.erroIncompatibilidadeParametros((((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getText():null), (((Parcela_unarioContext)_localctx).IDENT!=null?((Parcela_unarioContext)_localctx).IDENT.getLine():0));
				                            }
				                            ((Parcela_unarioContext)_localctx).name =  ((Parcela_unarioContext)_localctx).chamada_partes.name;;
				                            ((Parcela_unarioContext)_localctx).temAtributo =  ((Parcela_unarioContext)_localctx).chamada_partes.temAtributo;
				                            ((Parcela_unarioContext)_localctx).tipoParc =  2;
				}
				break;
			case NUM_INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(554);
				((Parcela_unarioContext)_localctx).NUM_INT = match(NUM_INT);
				((Parcela_unarioContext)_localctx).type =  "inteiro"; ((Parcela_unarioContext)_localctx).indice =  Integer.parseInt((((Parcela_unarioContext)_localctx).NUM_INT!=null?((Parcela_unarioContext)_localctx).NUM_INT.getText():null)); ((Parcela_unarioContext)_localctx).name =  (((Parcela_unarioContext)_localctx).NUM_INT!=null?((Parcela_unarioContext)_localctx).NUM_INT.getText():null); ((Parcela_unarioContext)_localctx).tipoParc =  3;
				}
				break;
			case NUM_REAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(556);
				((Parcela_unarioContext)_localctx).NUM_REAL = match(NUM_REAL);
				((Parcela_unarioContext)_localctx).type =  "real"; ((Parcela_unarioContext)_localctx).name =  (((Parcela_unarioContext)_localctx).NUM_REAL!=null?((Parcela_unarioContext)_localctx).NUM_REAL.getText():null); ((Parcela_unarioContext)_localctx).tipoParc =  4;
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 5);
				{
				setState(558);
				match(T__21);
				setState(559);
				expressao();
				setState(560);
				match(T__22);
				((Parcela_unarioContext)_localctx).tipoParc =  5;
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
		public String name;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_nao_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_nao_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_nao_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_nao_unarioContext parcela_nao_unario() throws RecognitionException {
		Parcela_nao_unarioContext _localctx = new Parcela_nao_unarioContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_parcela_nao_unario);
		((Parcela_nao_unarioContext)_localctx).name = "";
		try {
			setState(573);
			switch (_input.LA(1)) {
			case T__49:
				enterOuterAlt(_localctx, 1);
				{
				setState(565);
				match(T__49);
				setState(566);
				match(IDENT);
				setState(567);
				((Parcela_nao_unarioContext)_localctx).outros_ident = outros_ident();
				setState(568);
				dimensao();
				((Parcela_nao_unarioContext)_localctx).type =  ""; ((Parcela_nao_unarioContext)_localctx).name =  ((Parcela_nao_unarioContext)_localctx).outros_ident.name;
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(571);
				((Parcela_nao_unarioContext)_localctx).CADEIA = match(CADEIA);
				((Parcela_nao_unarioContext)_localctx).type =  "literal"; ((Parcela_nao_unarioContext)_localctx).name =  (((Parcela_nao_unarioContext)_localctx).CADEIA!=null?((Parcela_nao_unarioContext)_localctx).CADEIA.getText():null);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutras_parcelas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutras_parcelas(this);
		}
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
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__50) {
				{
				{
				setState(575);
				match(T__50);
				setState(576);
				parcela();
				}
				}
				setState(581);
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
		public String name;
		public int tipoChamada;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterChamada_partes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitChamada_partes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitChamada_partes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chamada_partesContext chamada_partes() throws RecognitionException {
		Chamada_partesContext _localctx = new Chamada_partesContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_chamada_partes);
		((Chamada_partesContext)_localctx).id =  ""; ((Chamada_partesContext)_localctx).tipos =  new ArrayList<String>(); ((Chamada_partesContext)_localctx).name =  ""; ((Chamada_partesContext)_localctx).temAtributo =  false;
		try {
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				match(T__21);
				setState(583);
				((Chamada_partesContext)_localctx).expressao = expressao();
				setState(584);
				((Chamada_partesContext)_localctx).mais_expressao = mais_expressao();
				((Chamada_partesContext)_localctx).tipos =  ((Chamada_partesContext)_localctx).mais_expressao.tipos; _localctx.tipos.add(0, ((Chamada_partesContext)_localctx).expressao.type); ((Chamada_partesContext)_localctx).tipoChamada =  1;
				setState(586);
				match(T__22);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(588);
				((Chamada_partesContext)_localctx).outros_ident = outros_ident();
				setState(589);
				dimensao();
				((Chamada_partesContext)_localctx).id =  ((Chamada_partesContext)_localctx).outros_ident.id; ((Chamada_partesContext)_localctx).name =  ((Chamada_partesContext)_localctx).outros_ident.name; ((Chamada_partesContext)_localctx).temAtributo =  ((Chamada_partesContext)_localctx).outros_ident.temAtributo; ((Chamada_partesContext)_localctx).tipoChamada =  2;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				((Chamada_partesContext)_localctx).tipoChamada =  3;
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_relacionalContext exp_relacional() throws RecognitionException {
		Exp_relacionalContext _localctx = new Exp_relacionalContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_exp_relacional);
		((Exp_relacionalContext)_localctx).name =  ""; ((Exp_relacionalContext)_localctx).temAtributo =  false;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			((Exp_relacionalContext)_localctx).exp_aritmetica = exp_aritmetica();
			setState(596);
			((Exp_relacionalContext)_localctx).op_opcional = op_opcional();
			((Exp_relacionalContext)_localctx).name =  ((Exp_relacionalContext)_localctx).exp_aritmetica.name;
			                                  ((Exp_relacionalContext)_localctx).temAtributo =  ((Exp_relacionalContext)_localctx).exp_aritmetica.temAtributo;
			                                  if(((Exp_relacionalContext)_localctx).op_opcional.type.equals("")){
			                                        ((Exp_relacionalContext)_localctx).compativel =  ((Exp_relacionalContext)_localctx).exp_aritmetica.compativel; ((Exp_relacionalContext)_localctx).type =  ((Exp_relacionalContext)_localctx).exp_aritmetica.type;
			                                   }else{
			                                        ((Exp_relacionalContext)_localctx).compativel =  true; ((Exp_relacionalContext)_localctx).type =  ((Exp_relacionalContext)_localctx).op_opcional.type;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_opcionalContext op_opcional() throws RecognitionException {
		Op_opcionalContext _localctx = new Op_opcionalContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_op_opcional);
		((Op_opcionalContext)_localctx).type =  ""; ((Op_opcionalContext)_localctx).compativel =  true;
		try {
			setState(604);
			switch (_input.LA(1)) {
			case T__5:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
				enterOuterAlt(_localctx, 1);
				{
				setState(599);
				op_relacional();
				setState(600);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_relacional(this);
		}
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
			setState(606);
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_expressao);
		((ExpressaoContext)_localctx).name =  ""; ((ExpressaoContext)_localctx).temAtributo = false;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			((ExpressaoContext)_localctx).termo_logico = termo_logico();
			setState(609);
			outros_termos_logicos();
			((ExpressaoContext)_localctx).compativel =  ((ExpressaoContext)_localctx).termo_logico.compativel; ((ExpressaoContext)_localctx).type =  ((ExpressaoContext)_localctx).termo_logico.type; ((ExpressaoContext)_localctx).name =  ((ExpressaoContext)_localctx).termo_logico.name; ((ExpressaoContext)_localctx).temAtributo =  ((ExpressaoContext)_localctx).termo_logico.temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_nao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_nao(this);
		}
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
			setState(614);
			switch (_input.LA(1)) {
			case T__56:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTermo_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_termo_logico);
		((Termo_logicoContext)_localctx).name =  ""; ((Termo_logicoContext)_localctx).temAtributo =  false;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			((Termo_logicoContext)_localctx).fator_logico = fator_logico();
			setState(617);
			outros_fatores_logicos();
			((Termo_logicoContext)_localctx).compativel =  ((Termo_logicoContext)_localctx).fator_logico.compativel; ((Termo_logicoContext)_localctx).type =  ((Termo_logicoContext)_localctx).fator_logico.type; ((Termo_logicoContext)_localctx).name =  ((Termo_logicoContext)_localctx).fator_logico.name; ((Termo_logicoContext)_localctx).temAtributo =  ((Termo_logicoContext)_localctx).fator_logico.temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_termos_logicos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_termos_logicos(this);
		}
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
			setState(625);
			switch (_input.LA(1)) {
			case T__57:
				enterOuterAlt(_localctx, 1);
				{
				setState(620);
				match(T__57);
				setState(621);
				termo_logico();
				setState(622);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOutros_fatores_logicos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOutros_fatores_logicos(this);
		}
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
			setState(632);
			switch (_input.LA(1)) {
			case T__58:
				enterOuterAlt(_localctx, 1);
				{
				setState(627);
				match(T__58);
				setState(628);
				fator_logico();
				setState(629);
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
		public String name;
		public boolean temAtributo;
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitFator_logico(this);
		}
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
			setState(634);
			op_nao();
			setState(635);
			((Fator_logicoContext)_localctx).parcela_logica = parcela_logica();
			((Fator_logicoContext)_localctx).compativel =  ((Fator_logicoContext)_localctx).parcela_logica.compativel; ((Fator_logicoContext)_localctx).type =  ((Fator_logicoContext)_localctx).parcela_logica.type; ((Fator_logicoContext)_localctx).name =  ((Fator_logicoContext)_localctx).parcela_logica.name; ((Fator_logicoContext)_localctx).temAtributo =  ((Fator_logicoContext)_localctx).parcela_logica.temAtributo;
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
		public boolean compativel;
		public String type;
		public String name;
		public int tipoParc;
		public boolean temAtributo;
		public Exp_relacionalContext exp_relacional;
		public Exp_relacionalContext exp_relacional() {
			return getRuleContext(Exp_relacionalContext.class,0);
		}
		public Parcela_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_logica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_logicaContext parcela_logica() throws RecognitionException {
		Parcela_logicaContext _localctx = new Parcela_logicaContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_parcela_logica);
		((Parcela_logicaContext)_localctx).name =  ""; ((Parcela_logicaContext)_localctx).temAtributo =  false;
		try {
			setState(645);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(638);
				match(T__16);
				((Parcela_logicaContext)_localctx).compativel =  false; ((Parcela_logicaContext)_localctx).type =  "logico"; ((Parcela_logicaContext)_localctx).tipoParc =  1;
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(640);
				match(T__17);
				((Parcela_logicaContext)_localctx).compativel =  false; ((Parcela_logicaContext)_localctx).type =  "logico"; ((Parcela_logicaContext)_localctx).tipoParc =  2;
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
				setState(642);
				((Parcela_logicaContext)_localctx).exp_relacional = exp_relacional();
				((Parcela_logicaContext)_localctx).compativel =  ((Parcela_logicaContext)_localctx).exp_relacional.compativel; ((Parcela_logicaContext)_localctx).type =  ((Parcela_logicaContext)_localctx).exp_relacional.type; ((Parcela_logicaContext)_localctx).name =  ((Parcela_logicaContext)_localctx).exp_relacional.name; ((Parcela_logicaContext)_localctx).tipoParc =  3; ((Parcela_logicaContext)_localctx).temAtributo = ((Parcela_logicaContext)_localctx).exp_relacional.temAtributo;;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u028a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3\u008b\n\3"+
		"\f\3\16\3\u008e\13\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0096\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00aa"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u00b8\n\7\f\7"+
		"\16\7\u00bb\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\t\u00c6\n\t\f\t"+
		"\16\t\u00c9\13\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00d1\n\n\f\n\16\n\u00d4"+
		"\13\n\3\13\3\13\3\13\3\13\3\13\7\13\u00db\n\13\f\13\16\13\u00de\13\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e6\n\f\3\r\3\r\7\r\u00ea\n\r\f\r\16\r"+
		"\u00ed\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f7\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u00fe\n\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\6\22\u010a\n\22\r\22\16\22\u010b\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\7\24\u011c\n\24"+
		"\f\24\16\24\u011f\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u013a\n\25\3\26\3\26\5\26\u013e\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u0150"+
		"\n\31\f\31\16\31\u0153\13\31\3\32\3\32\5\32\u0157\n\32\3\33\3\33\3\33"+
		"\5\33\u015c\n\33\3\34\7\34\u015f\n\34\f\34\16\34\u0162\13\34\3\35\3\35"+
		"\3\35\3\36\7\36\u0168\n\36\f\36\16\36\u016b\13\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u01b9\n\37\3 \3 \3 \3 \7 \u01bf\n \f \16 \u01c2\13 \3"+
		"!\3!\3!\5!\u01c7\n!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\5$\u01d7"+
		"\n$\3%\3%\3%\3%\3%\3&\3&\5&\u01e0\n&\3\'\3\'\3\'\3(\3(\3(\5(\u01e8\n("+
		"\3)\3)\3)\3)\3*\3*\3*\3*\3*\5*\u01f3\n*\3+\3+\5+\u01f7\n+\3,\3,\3,\3,"+
		"\3-\3-\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u0209\n\60\f\60\16\60"+
		"\u020c\13\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\7\62\u0215\n\62\f\62\16"+
		"\62\u0218\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u0221\n\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\5\64\u0236\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\5\65\u0240\n\65\3\66\3\66\7\66\u0244\n\66\f\66\16\66\u0247\13\66"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u0254\n\67"+
		"\38\38\38\38\39\39\39\39\39\59\u025f\n9\3:\3:\3;\3;\3;\3;\3<\3<\5<\u0269"+
		"\n<\3=\3=\3=\3=\3>\3>\3>\3>\3>\5>\u0274\n>\3?\3?\3?\3?\3?\5?\u027b\n?"+
		"\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\5A\u0288\nA\3A\2\2B\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhj"+
		"lnprtvxz|~\u0080\2\6\5\2\23\24@@BC\3\2\61\62\4\2\60\60\63\63\4\2\b\b\66"+
		":\u0282\2\u0082\3\2\2\2\4\u008c\3\2\2\2\6\u0095\3\2\2\2\b\u00a9\3\2\2"+
		"\2\n\u00ab\3\2\2\2\f\u00b9\3\2\2\2\16\u00bc\3\2\2\2\20\u00c7\3\2\2\2\22"+
		"\u00d2\3\2\2\2\24\u00dc\3\2\2\2\26\u00e5\3\2\2\2\30\u00eb\3\2\2\2\32\u00f6"+
		"\3\2\2\2\34\u00fd\3\2\2\2\36\u00ff\3\2\2\2 \u0103\3\2\2\2\"\u0105\3\2"+
		"\2\2$\u010f\3\2\2\2&\u011d\3\2\2\2(\u0139\3\2\2\2*\u013d\3\2\2\2,\u013f"+
		"\3\2\2\2.\u0147\3\2\2\2\60\u0151\3\2\2\2\62\u0156\3\2\2\2\64\u015b\3\2"+
		"\2\2\66\u0160\3\2\2\28\u0163\3\2\2\2:\u0169\3\2\2\2<\u01b8\3\2\2\2>\u01c0"+
		"\3\2\2\2@\u01c6\3\2\2\2B\u01c8\3\2\2\2D\u01cc\3\2\2\2F\u01d6\3\2\2\2H"+
		"\u01d8\3\2\2\2J\u01df\3\2\2\2L\u01e1\3\2\2\2N\u01e7\3\2\2\2P\u01e9\3\2"+
		"\2\2R\u01f2\3\2\2\2T\u01f6\3\2\2\2V\u01f8\3\2\2\2X\u01fc\3\2\2\2Z\u01fe"+
		"\3\2\2\2\\\u0200\3\2\2\2^\u020a\3\2\2\2`\u020d\3\2\2\2b\u0216\3\2\2\2"+
		"d\u0220\3\2\2\2f\u0235\3\2\2\2h\u023f\3\2\2\2j\u0245\3\2\2\2l\u0253\3"+
		"\2\2\2n\u0255\3\2\2\2p\u025e\3\2\2\2r\u0260\3\2\2\2t\u0262\3\2\2\2v\u0268"+
		"\3\2\2\2x\u026a\3\2\2\2z\u0273\3\2\2\2|\u027a\3\2\2\2~\u027c\3\2\2\2\u0080"+
		"\u0287\3\2\2\2\u0082\u0083\b\2\1\2\u0083\u0084\5\4\3\2\u0084\u0085\7\3"+
		"\2\2\u0085\u0086\58\35\2\u0086\u0087\7\4\2\2\u0087\u0088\b\2\1\2\u0088"+
		"\3\3\2\2\2\u0089\u008b\5\6\4\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\5\3\2\2\2\u008e\u008c\3"+
		"\2\2\2\u008f\u0090\5\b\5\2\u0090\u0091\b\4\1\2\u0091\u0096\3\2\2\2\u0092"+
		"\u0093\5(\25\2\u0093\u0094\b\4\1\2\u0094\u0096\3\2\2\2\u0095\u008f\3\2"+
		"\2\2\u0095\u0092\3\2\2\2\u0096\7\3\2\2\2\u0097\u0098\7\5\2\2\u0098\u0099"+
		"\5\n\6\2\u0099\u009a\b\5\1\2\u009a\u00aa\3\2\2\2\u009b\u009c\7\6\2\2\u009c"+
		"\u009d\7>\2\2\u009d\u009e\7\7\2\2\u009e\u009f\5\32\16\2\u009f\u00a0\7"+
		"\b\2\2\u00a0\u00a1\5 \21\2\u00a1\u00a2\b\5\1\2\u00a2\u00aa\3\2\2\2\u00a3"+
		"\u00a4\7\t\2\2\u00a4\u00a5\7>\2\2\u00a5\u00a6\7\7\2\2\u00a6\u00a7\5\26"+
		"\f\2\u00a7\u00a8\b\5\1\2\u00a8\u00aa\3\2\2\2\u00a9\u0097\3\2\2\2\u00a9"+
		"\u009b\3\2\2\2\u00a9\u00a3\3\2\2\2\u00aa\t\3\2\2\2\u00ab\u00ac\7>\2\2"+
		"\u00ac\u00ad\5\24\13\2\u00ad\u00ae\5\f\7\2\u00ae\u00af\7\7\2\2\u00af\u00b0"+
		"\5\26\f\2\u00b0\u00b1\b\6\1\2\u00b1\13\3\2\2\2\u00b2\u00b3\7\n\2\2\u00b3"+
		"\u00b4\7>\2\2\u00b4\u00b5\5\24\13\2\u00b5\u00b6\b\7\1\2\u00b6\u00b8\3"+
		"\2\2\2\u00b7\u00b2\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\r\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\5\20\t"+
		"\2\u00bd\u00be\7>\2\2\u00be\u00bf\5\24\13\2\u00bf\u00c0\5\22\n\2\u00c0"+
		"\u00c1\b\b\1\2\u00c1\u00c2\b\b\1\2\u00c2\17\3\2\2\2\u00c3\u00c4\7\13\2"+
		"\2\u00c4\u00c6\b\t\1\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\21\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cb\7\f\2\2\u00cb\u00cc\5\20\t\2\u00cc\u00cd\7>\2\2\u00cd\u00ce\5\24"+
		"\13\2\u00ce\u00cf\b\n\1\2\u00cf\u00d1\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\23\3\2\2"+
		"\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7\r\2\2\u00d6\u00d7\5V,\2\u00d7\u00d8"+
		"\b\13\1\2\u00d8\u00d9\7\16\2\2\u00d9\u00db\3\2\2\2\u00da\u00d5\3\2\2\2"+
		"\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\25"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\5\"\22\2\u00e0\u00e1\b\f\1\2"+
		"\u00e1\u00e6\3\2\2\2\u00e2\u00e3\5\36\20\2\u00e3\u00e4\b\f\1\2\u00e4\u00e6"+
		"\3\2\2\2\u00e5\u00df\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\27\3\2\2\2\u00e7"+
		"\u00e8\7\n\2\2\u00e8\u00ea\5\16\b\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3"+
		"\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\31\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00ef\7\17\2\2\u00ef\u00f7\b\16\1\2\u00f0\u00f1\7"+
		"\20\2\2\u00f1\u00f7\b\16\1\2\u00f2\u00f3\7\21\2\2\u00f3\u00f7\b\16\1\2"+
		"\u00f4\u00f5\7\22\2\2\u00f5\u00f7\b\16\1\2\u00f6\u00ee\3\2\2\2\u00f6\u00f0"+
		"\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\33\3\2\2\2\u00f8"+
		"\u00f9\5\32\16\2\u00f9\u00fa\b\17\1\2\u00fa\u00fe\3\2\2\2\u00fb\u00fc"+
		"\7>\2\2\u00fc\u00fe\b\17\1\2\u00fd\u00f8\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\35\3\2\2\2\u00ff\u0100\5\20\t\2\u0100\u0101\5\34\17\2\u0101\u0102\b\20"+
		"\1\2\u0102\37\3\2\2\2\u0103\u0104\t\2\2\2\u0104!\3\2\2\2\u0105\u0109\7"+
		"\25\2\2\u0106\u0107\5$\23\2\u0107\u0108\b\22\1\2\u0108\u010a\3\2\2\2\u0109"+
		"\u0106\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7\26\2\2\u010e#\3\2\2\2\u010f\u0110"+
		"\7>\2\2\u0110\u0111\5\24\13\2\u0111\u0112\5&\24\2\u0112\u0113\7\7\2\2"+
		"\u0113\u0114\5\26\f\2\u0114\u0115\b\23\1\2\u0115%\3\2\2\2\u0116\u0117"+
		"\7\n\2\2\u0117\u0118\7>\2\2\u0118\u0119\5\24\13\2\u0119\u011a\b\24\1\2"+
		"\u011a\u011c\3\2\2\2\u011b\u0116\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\'\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0121\7\27\2\2\u0121\u0122\7>\2\2\u0122\u0123\b\25\1\2\u0123\u0124\7"+
		"\30\2\2\u0124\u0125\5*\26\2\u0125\u0126\7\31\2\2\u0126\u0127\5\66\34\2"+
		"\u0127\u0128\5:\36\2\u0128\u0129\7\32\2\2\u0129\u012a\b\25\1\2\u012a\u013a"+
		"\3\2\2\2\u012b\u012c\7\33\2\2\u012c\u012d\7>\2\2\u012d\u012e\b\25\1\2"+
		"\u012e\u012f\7\30\2\2\u012f\u0130\5*\26\2\u0130\u0131\7\31\2\2\u0131\u0132"+
		"\7\7\2\2\u0132\u0133\5\36\20\2\u0133\u0134\b\25\1\2\u0134\u0135\5\66\34"+
		"\2\u0135\u0136\5:\36\2\u0136\u0137\7\34\2\2\u0137\u0138\b\25\1\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0120\3\2\2\2\u0139\u012b\3\2\2\2\u013a)\3\2\2\2"+
		"\u013b\u013e\5,\27\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013c"+
		"\3\2\2\2\u013e+\3\2\2\2\u013f\u0140\5\62\32\2\u0140\u0141\5.\30\2\u0141"+
		"\u0142\5\60\31\2\u0142\u0143\7\7\2\2\u0143\u0144\5\36\20\2\u0144\u0145"+
		"\b\27\1\2\u0145\u0146\5\64\33\2\u0146-\3\2\2\2\u0147\u0148\5\20\t\2\u0148"+
		"\u0149\7>\2\2\u0149\u014a\b\30\1\2\u014a\u014b\5\24\13\2\u014b\u014c\5"+
		"\22\n\2\u014c/\3\2\2\2\u014d\u014e\7\n\2\2\u014e\u0150\5.\30\2\u014f\u014d"+
		"\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\61\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0157\7\35\2\2\u0155\u0157\3\2\2"+
		"\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\63\3\2\2\2\u0158\u0159"+
		"\7\n\2\2\u0159\u015c\5,\27\2\u015a\u015c\3\2\2\2\u015b\u0158\3\2\2\2\u015b"+
		"\u015a\3\2\2\2\u015c\65\3\2\2\2\u015d\u015f\5\b\5\2\u015e\u015d\3\2\2"+
		"\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\67"+
		"\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\5\66\34\2\u0164\u0165\5:\36\2"+
		"\u01659\3\2\2\2\u0166\u0168\5<\37\2\u0167\u0166\3\2\2\2\u0168\u016b\3"+
		"\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a;\3\2\2\2\u016b\u0169"+
		"\3\2\2\2\u016c\u016d\7\36\2\2\u016d\u016e\7\30\2\2\u016e\u016f\5\16\b"+
		"\2\u016f\u0170\5\30\r\2\u0170\u0171\7\31\2\2\u0171\u0172\b\37\1\2\u0172"+
		"\u01b9\3\2\2\2\u0173\u0174\7\37\2\2\u0174\u0175\7\30\2\2\u0175\u0176\5"+
		"t;\2\u0176\u0177\5> \2\u0177\u0178\7\31\2\2\u0178\u0179\b\37\1\2\u0179"+
		"\u01b9\3\2\2\2\u017a\u017b\7 \2\2\u017b\u017c\5t;\2\u017c\u017d\7!\2\2"+
		"\u017d\u017e\5:\36\2\u017e\u017f\5@!\2\u017f\u0180\7\"\2\2\u0180\u0181"+
		"\b\37\1\2\u0181\u01b9\3\2\2\2\u0182\u0183\7#\2\2\u0183\u0184\5V,\2\u0184"+
		"\u0185\7$\2\2\u0185\u0186\5H%\2\u0186\u0187\5@!\2\u0187\u0188\7%\2\2\u0188"+
		"\u0189\b\37\1\2\u0189\u01b9\3\2\2\2\u018a\u018b\7&\2\2\u018b\u018c\7>"+
		"\2\2\u018c\u018d\7\'\2\2\u018d\u018e\5V,\2\u018e\u018f\7(\2\2\u018f\u0190"+
		"\5V,\2\u0190\u0191\7)\2\2\u0191\u0192\5:\36\2\u0192\u0193\7*\2\2\u0193"+
		"\u0194\b\37\1\2\u0194\u01b9\3\2\2\2\u0195\u0196\7+\2\2\u0196\u0197\5t"+
		";\2\u0197\u0198\7)\2\2\u0198\u0199\5:\36\2\u0199\u019a\7,\2\2\u019a\u019b"+
		"\b\37\1\2\u019b\u01b9\3\2\2\2\u019c\u019d\7)\2\2\u019d\u019e\5:\36\2\u019e"+
		"\u019f\7(\2\2\u019f\u01a0\5t;\2\u01a0\u01a1\b\37\1\2\u01a1\u01b9\3\2\2"+
		"\2\u01a2\u01a3\7\13\2\2\u01a3\u01a4\7>\2\2\u01a4\u01a5\5\22\n\2\u01a5"+
		"\u01a6\5\24\13\2\u01a6\u01a7\7\'\2\2\u01a7\u01a8\5t;\2\u01a8\u01a9\b\37"+
		"\1\2\u01a9\u01b9\3\2\2\2\u01aa\u01ab\7>\2\2\u01ab\u01ac\5B\"\2\u01ac\u01ad"+
		"\b\37\1\2\u01ad\u01b9\3\2\2\2\u01ae\u01af\7>\2\2\u01af\u01b0\5D#\2\u01b0"+
		"\u01b1\b\37\1\2\u01b1\u01b2\b\37\1\2\u01b2\u01b9\3\2\2\2\u01b3\u01b4\7"+
		"-\2\2\u01b4\u01b5\5t;\2\u01b5\u01b6\b\37\1\2\u01b6\u01b7\b\37\1\2\u01b7"+
		"\u01b9\3\2\2\2\u01b8\u016c\3\2\2\2\u01b8\u0173\3\2\2\2\u01b8\u017a\3\2"+
		"\2\2\u01b8\u0182\3\2\2\2\u01b8\u018a\3\2\2\2\u01b8\u0195\3\2\2\2\u01b8"+
		"\u019c\3\2\2\2\u01b8\u01a2\3\2\2\2\u01b8\u01aa\3\2\2\2\u01b8\u01ae\3\2"+
		"\2\2\u01b8\u01b3\3\2\2\2\u01b9=\3\2\2\2\u01ba\u01bb\7\n\2\2\u01bb\u01bc"+
		"\5t;\2\u01bc\u01bd\b \1\2\u01bd\u01bf\3\2\2\2\u01be\u01ba\3\2\2\2\u01bf"+
		"\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1?\3\2\2\2"+
		"\u01c2\u01c0\3\2\2\2\u01c3\u01c4\7.\2\2\u01c4\u01c7\5:\36\2\u01c5\u01c7"+
		"\3\2\2\2\u01c6\u01c3\3\2\2\2\u01c6\u01c5\3\2\2\2\u01c7A\3\2\2\2\u01c8"+
		"\u01c9\7\30\2\2\u01c9\u01ca\5F$\2\u01ca\u01cb\7\31\2\2\u01cbC\3\2\2\2"+
		"\u01cc\u01cd\5\22\n\2\u01cd\u01ce\5\24\13\2\u01ce\u01cf\7\'\2\2\u01cf"+
		"\u01d0\5t;\2\u01d0\u01d1\b#\1\2\u01d1E\3\2\2\2\u01d2\u01d3\5t;\2\u01d3"+
		"\u01d4\5> \2\u01d4\u01d7\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d2\3\2\2"+
		"\2\u01d6\u01d5\3\2\2\2\u01d7G\3\2\2\2\u01d8\u01d9\5L\'\2\u01d9\u01da\7"+
		"\7\2\2\u01da\u01db\5:\36\2\u01db\u01dc\5J&\2\u01dcI\3\2\2\2\u01dd\u01e0"+
		"\5H%\2\u01de\u01e0\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0"+
		"K\3\2\2\2\u01e1\u01e2\5P)\2\u01e2\u01e3\5N(\2\u01e3M\3\2\2\2\u01e4\u01e5"+
		"\7\n\2\2\u01e5\u01e8\5L\'\2\u01e6\u01e8\3\2\2\2\u01e7\u01e4\3\2\2\2\u01e7"+
		"\u01e6\3\2\2\2\u01e8O\3\2\2\2\u01e9\u01ea\5T+\2\u01ea\u01eb\7@\2\2\u01eb"+
		"\u01ec\5R*\2\u01ecQ\3\2\2\2\u01ed\u01ee\7/\2\2\u01ee\u01ef\5T+\2\u01ef"+
		"\u01f0\7@\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01ed\3\2"+
		"\2\2\u01f2\u01f1\3\2\2\2\u01f3S\3\2\2\2\u01f4\u01f7\7\60\2\2\u01f5\u01f7"+
		"\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f5\3\2\2\2\u01f7U\3\2\2\2\u01f8"+
		"\u01f9\5\\/\2\u01f9\u01fa\5^\60\2\u01fa\u01fb\b,\1\2\u01fbW\3\2\2\2\u01fc"+
		"\u01fd\t\3\2\2\u01fdY\3\2\2\2\u01fe\u01ff\t\4\2\2\u01ff[\3\2\2\2\u0200"+
		"\u0201\5`\61\2\u0201\u0202\5b\62\2\u0202\u0203\b/\1\2\u0203]\3\2\2\2\u0204"+
		"\u0205\5Z.\2\u0205\u0206\5\\/\2\u0206\u0207\b\60\1\2\u0207\u0209\3\2\2"+
		"\2\u0208\u0204\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b"+
		"\3\2\2\2\u020b_\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u020e\5d\63\2\u020e"+
		"\u020f\5j\66\2\u020f\u0210\b\61\1\2\u0210a\3\2\2\2\u0211\u0212\5X-\2\u0212"+
		"\u0213\5`\61\2\u0213\u0215\3\2\2\2\u0214\u0211\3\2\2\2\u0215\u0218\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217c\3\2\2\2\u0218\u0216"+
		"\3\2\2\2\u0219\u021a\5T+\2\u021a\u021b\5f\64\2\u021b\u021c\b\63\1\2\u021c"+
		"\u0221\3\2\2\2\u021d\u021e\5h\65\2\u021e\u021f\b\63\1\2\u021f\u0221\3"+
		"\2\2\2\u0220\u0219\3\2\2\2\u0220\u021d\3\2\2\2\u0221e\3\2\2\2\u0222\u0223"+
		"\7\13\2\2\u0223\u0224\7>\2\2\u0224\u0225\5\22\n\2\u0225\u0226\5\24\13"+
		"\2\u0226\u0227\b\64\1\2\u0227\u0236\3\2\2\2\u0228\u0229\7>\2\2\u0229\u022a"+
		"\5l\67\2\u022a\u022b\b\64\1\2\u022b\u0236\3\2\2\2\u022c\u022d\7@\2\2\u022d"+
		"\u0236\b\64\1\2\u022e\u022f\7B\2\2\u022f\u0236\b\64\1\2\u0230\u0231\7"+
		"\30\2\2\u0231\u0232\5t;\2\u0232\u0233\7\31\2\2\u0233\u0234\b\64\1\2\u0234"+
		"\u0236\3\2\2\2\u0235\u0222\3\2\2\2\u0235\u0228\3\2\2\2\u0235\u022c\3\2"+
		"\2\2\u0235\u022e\3\2\2\2\u0235\u0230\3\2\2\2\u0236g\3\2\2\2\u0237\u0238"+
		"\7\64\2\2\u0238\u0239\7>\2\2\u0239\u023a\5\22\n\2\u023a\u023b\5\24\13"+
		"\2\u023b\u023c\b\65\1\2\u023c\u0240\3\2\2\2\u023d\u023e\7C\2\2\u023e\u0240"+
		"\b\65\1\2\u023f\u0237\3\2\2\2\u023f\u023d\3\2\2\2\u0240i\3\2\2\2\u0241"+
		"\u0242\7\65\2\2\u0242\u0244\5d\63\2\u0243\u0241\3\2\2\2\u0244\u0247\3"+
		"\2\2\2\u0245\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246k\3\2\2\2\u0247\u0245"+
		"\3\2\2\2\u0248\u0249\7\30\2\2\u0249\u024a\5t;\2\u024a\u024b\5> \2\u024b"+
		"\u024c\b\67\1\2\u024c\u024d\7\31\2\2\u024d\u0254\3\2\2\2\u024e\u024f\5"+
		"\22\n\2\u024f\u0250\5\24\13\2\u0250\u0251\b\67\1\2\u0251\u0254\3\2\2\2"+
		"\u0252\u0254\b\67\1\2\u0253\u0248\3\2\2\2\u0253\u024e\3\2\2\2\u0253\u0252"+
		"\3\2\2\2\u0254m\3\2\2\2\u0255\u0256\5V,\2\u0256\u0257\5p9\2\u0257\u0258"+
		"\b8\1\2\u0258o\3\2\2\2\u0259\u025a\5r:\2\u025a\u025b\5V,\2\u025b\u025c"+
		"\b9\1\2\u025c\u025f\3\2\2\2\u025d\u025f\3\2\2\2\u025e\u0259\3\2\2\2\u025e"+
		"\u025d\3\2\2\2\u025fq\3\2\2\2\u0260\u0261\t\5\2\2\u0261s\3\2\2\2\u0262"+
		"\u0263\5x=\2\u0263\u0264\5z>\2\u0264\u0265\b;\1\2\u0265u\3\2\2\2\u0266"+
		"\u0269\7;\2\2\u0267\u0269\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0267\3\2"+
		"\2\2\u0269w\3\2\2\2\u026a\u026b\5~@\2\u026b\u026c\5|?\2\u026c\u026d\b"+
		"=\1\2\u026dy\3\2\2\2\u026e\u026f\7<\2\2\u026f\u0270\5x=\2\u0270\u0271"+
		"\5z>\2\u0271\u0274\3\2\2\2\u0272\u0274\3\2\2\2\u0273\u026e\3\2\2\2\u0273"+
		"\u0272\3\2\2\2\u0274{\3\2\2\2\u0275\u0276\7=\2\2\u0276\u0277\5~@\2\u0277"+
		"\u0278\5|?\2\u0278\u027b\3\2\2\2\u0279\u027b\3\2\2\2\u027a\u0275\3\2\2"+
		"\2\u027a\u0279\3\2\2\2\u027b}\3\2\2\2\u027c\u027d\5v<\2\u027d\u027e\5"+
		"\u0080A\2\u027e\u027f\b@\1\2\u027f\177\3\2\2\2\u0280\u0281\7\23\2\2\u0281"+
		"\u0288\bA\1\2\u0282\u0283\7\24\2\2\u0283\u0288\bA\1\2\u0284\u0285\5n8"+
		"\2\u0285\u0286\bA\1\2\u0286\u0288\3\2\2\2\u0287\u0280\3\2\2\2\u0287\u0282"+
		"\3\2\2\2\u0287\u0284\3\2\2\2\u0288\u0081\3\2\2\2*\u008c\u0095\u00a9\u00b9"+
		"\u00c7\u00d2\u00dc\u00e5\u00eb\u00f6\u00fd\u010b\u011d\u0139\u013d\u0151"+
		"\u0156\u015b\u0160\u0169\u01b8\u01c0\u01c6\u01d6\u01df\u01e7\u01f2\u01f6"+
		"\u020a\u0216\u0220\u0235\u023f\u0245\u0253\u025e\u0268\u0273\u027a\u0287";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}