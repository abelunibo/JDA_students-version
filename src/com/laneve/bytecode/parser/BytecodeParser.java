// Generated from Bytecode.g4 by ANTLR 4.4
package com.laneve.bytecode.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BytecodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__114=1, T__113=2, T__112=3, T__111=4, T__110=5, T__109=6, T__108=7, 
		T__107=8, T__106=9, T__105=10, T__104=11, T__103=12, T__102=13, T__101=14, 
		T__100=15, T__99=16, T__98=17, T__97=18, T__96=19, T__95=20, T__94=21, 
		T__93=22, T__92=23, T__91=24, T__90=25, T__89=26, T__88=27, T__87=28, 
		T__86=29, T__85=30, T__84=31, T__83=32, T__82=33, T__81=34, T__80=35, 
		T__79=36, T__78=37, T__77=38, T__76=39, T__75=40, T__74=41, T__73=42, 
		T__72=43, T__71=44, T__70=45, T__69=46, T__68=47, T__67=48, T__66=49, 
		T__65=50, T__64=51, T__63=52, T__62=53, T__61=54, T__60=55, T__59=56, 
		T__58=57, T__57=58, T__56=59, T__55=60, T__54=61, T__53=62, T__52=63, 
		T__51=64, T__50=65, T__49=66, T__48=67, T__47=68, T__46=69, T__45=70, 
		T__44=71, T__43=72, T__42=73, T__41=74, T__40=75, T__39=76, T__38=77, 
		T__37=78, T__36=79, T__35=80, T__34=81, T__33=82, T__32=83, T__31=84, 
		T__30=85, T__29=86, T__28=87, T__27=88, T__26=89, T__25=90, T__24=91, 
		T__23=92, T__22=93, T__21=94, T__20=95, T__19=96, T__18=97, T__17=98, 
		T__16=99, T__15=100, T__14=101, T__13=102, T__12=103, T__11=104, T__10=105, 
		T__9=106, T__8=107, T__7=108, T__6=109, T__5=110, T__4=111, T__3=112, 
		T__2=113, T__1=114, T__0=115, CLASS=116, ENUM=117, INDEX=118, ALOAD=119, 
		ILOAD=120, ISTORE=121, ASTORE=122, REFNUM=123, NAT=124, INT=125, DEC=126, 
		THIS=127, STRING=128, Identifier=129, CLASSFILE=130, LAST=131, MD5=132, 
		COMPILED=133, ENCLOSINGMETHOD=134, SOURCE=135, MINOR=136, MAJOR=137, FLAGS=138, 
		CONSTANTVALUE=139, DESCRIPTOR=140, EXCEPTIONTABLE=141, FROMTO=142, FROMTONUMBERS=143, 
		LINENUMBERTABLE=144, LINENUMBERTABLECONTENT=145, LOCALVARIABLETABLE=146, 
		LOCALVARIABLECONTENT=147, LOCALVARIABLELINE=148, STACKMAPTABLE=149, FRAMETYPE=150, 
		OFFSETDELTA=151, LOCALS=152, STACK=153, STACKLOCALARGSSIZE=154, EXCEPTION=155, 
		THROWS=156, WS=157, COMMENT=158, LINE_COMMENT=159;
	public static final String[] tokenNames = {
		"<INVALID>", "'Float'", "'iconst_1'", "'dup'", "'char'", "'if_acmpeq'", 
		"'athrow'", "'^'", "'if_icmple'", "'int'", "','", "'throws'", "'if_icmplt'", 
		"'iconst_2'", "'abstract'", "'boolean'", "'monitorexit'", "'long'", "'ireturn'", 
		"'<'", "']'", "'protected'", "'ifne'", "'pop'", "'putstatic'", "'ldc2_w'", 
		"'if_icmpeq'", "'strictfp'", "'native'", "'iconst_3'", "'of'", "'Long'", 
		"';'", "'Integer'", "'}'", "'iinc'", "'if_icmpge'", "'''", "'monitorenter'", 
		"'areturn'", "'invokespecial'", "'l'", "'bipush'", "'if_icmpgt'", "'ifnonnull'", 
		"'Utf8'", "'Fieldref'", "'getstatic'", "'aconst_null'", "'aload'", "'istore'", 
		"'iconst_4'", "'putfield'", "':'", "'['", "'NameAndType'", "'public'", 
		"'!'", "')'", "'isub'", "'imul'", "'ifge'", "'private'", "'iload'", "'iconst_5'", 
		"'new'", "'float'", "'ifnull'", "'ifeq'", "'void'", "'{'", "'byte'", "'= '", 
		"'{}'", "'irem'", "'('", "'if_icmpne'", "'aastore'", "'astore'", "'idiv'", 
		"'implements'", "'Code:'", "'ifgt'", "'iconst_m1'", "'ifle'", "'static'", 
		"'iadd'", "'ldc_w'", "'anewarray'", "'final'", "'Methodref'", "'invokestatic'", 
		"'/'", "'return'", "'\\'", "'goto'", "'Double'", "'Class'", "'extends'", 
		"'?'", "'short'", "'double'", "'synchronized'", "'InterfaceMethodref'", 
		"'.'", "'iflt'", "'iconst_0'", "'ldc'", "'if_acmpne'", "'getfield'", "'Constant pool:'", 
		"'invokevirtual'", "'>'", "'%'", "'InnerClasses:'", "'-'", "'class'", 
		"'enum'", "INDEX", "ALOAD", "ILOAD", "ISTORE", "ASTORE", "REFNUM", "NAT", 
		"INT", "DEC", "'this'", "'String'", "Identifier", "CLASSFILE", "LAST", 
		"MD5", "COMPILED", "ENCLOSINGMETHOD", "SOURCE", "MINOR", "MAJOR", "FLAGS", 
		"CONSTANTVALUE", "DESCRIPTOR", "EXCEPTIONTABLE", "FROMTO", "FROMTONUMBERS", 
		"LINENUMBERTABLE", "LINENUMBERTABLECONTENT", "LOCALVARIABLETABLE", "LOCALVARIABLECONTENT", 
		"LOCALVARIABLELINE", "STACKMAPTABLE", "FRAMETYPE", "OFFSETDELTA", "LOCALS", 
		"STACK", "STACKLOCALARGSSIZE", "EXCEPTION", "THROWS", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final int
		RULE_classfile = 0, RULE_classDec = 1, RULE_classModifier = 2, RULE_innerClass = 3, 
		RULE_fields = 4, RULE_fieldModifier = 5, RULE_fieldName = 6, RULE_constantPool = 7, 
		RULE_tableEntries = 8, RULE_tableEntry = 9, RULE_constantAndInfo = 10, 
		RULE_methodDeclaration = 11, RULE_methodModifier = 12, RULE_methodHeader = 13, 
		RULE_result = 14, RULE_type = 15, RULE_primitiveType = 16, RULE_numericType = 17, 
		RULE_integralType = 18, RULE_floatingPointType = 19, RULE_referenceType = 20, 
		RULE_packageAndClassName = 21, RULE_methodDeclarator = 22, RULE_methodName = 23, 
		RULE_formalParameters = 24, RULE_formalParameter = 25, RULE_throws_ = 26, 
		RULE_exceptionTypeList = 27, RULE_exceptionType = 28, RULE_methodBody = 29, 
		RULE_instructionLine = 30, RULE_instruction = 31, RULE_ref = 32, RULE_num = 33, 
		RULE_identifierExtended = 34;
	public static final String[] ruleNames = {
		"classfile", "classDec", "classModifier", "innerClass", "fields", "fieldModifier", 
		"fieldName", "constantPool", "tableEntries", "tableEntry", "constantAndInfo", 
		"methodDeclaration", "methodModifier", "methodHeader", "result", "type", 
		"primitiveType", "numericType", "integralType", "floatingPointType", "referenceType", 
		"packageAndClassName", "methodDeclarator", "methodName", "formalParameters", 
		"formalParameter", "throws_", "exceptionTypeList", "exceptionType", "methodBody", 
		"instructionLine", "instruction", "ref", "num", "identifierExtended"
	};

	@Override
	public String getGrammarFileName() { return "Bytecode.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BytecodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ClassfileContext extends ParserRuleContext {
		public InnerClassContext innerClass(int i) {
			return getRuleContext(InnerClassContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public TerminalNode EOF() { return getToken(BytecodeParser.EOF, 0); }
		public ConstantPoolContext constantPool() {
			return getRuleContext(ConstantPoolContext.class,0);
		}
		public List<FieldsContext> fields() {
			return getRuleContexts(FieldsContext.class);
		}
		public List<InnerClassContext> innerClass() {
			return getRuleContexts(InnerClassContext.class);
		}
		public ClassDecContext classDec() {
			return getRuleContext(ClassDecContext.class,0);
		}
		public FieldsContext fields(int i) {
			return getRuleContext(FieldsContext.class,i);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassfileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classfile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitClassfile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassfileContext classfile() throws RecognitionException {
		ClassfileContext _localctx = new ClassfileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_classfile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(70); classDec();
			setState(72);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(71); innerClass();
				}
			}

			setState(74); constantPool();
			setState(75); match(T__45);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76); fields();
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(83); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(82); methodDeclaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(85); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(87); match(T__81);
			setState(89);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(88); innerClass();
				}
			}

			}
			setState(91); match(EOF);
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

	public static class ClassDecContext extends ParserRuleContext {
		public PackageAndClassNameContext ilmio;
		public ClassModifierContext classModifier() {
			return getRuleContext(ClassModifierContext.class,0);
		}
		public TerminalNode ENUM() { return getToken(BytecodeParser.ENUM, 0); }
		public PackageAndClassNameContext packageAndClassName(int i) {
			return getRuleContext(PackageAndClassNameContext.class,i);
		}
		public TerminalNode CLASS() { return getToken(BytecodeParser.CLASS, 0); }
		public List<PackageAndClassNameContext> packageAndClassName() {
			return getRuleContexts(PackageAndClassNameContext.class);
		}
		public ClassDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitClassDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDecContext classDec() throws RecognitionException {
		ClassDecContext _localctx = new ClassDecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if (_la==T__101 || _la==T__59 || _la==T__30 || _la==T__26) {
				{
				setState(93); classModifier();
				}
			}

			setState(96);
			_la = _input.LA(1);
			if ( !(_la==CLASS || _la==ENUM) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(97); ((ClassDecContext)_localctx).ilmio = packageAndClassName(0);
			setState(100);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(98); match(T__17);
				setState(99); packageAndClassName(0);
				}
			}

			setState(112);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				{
				setState(102); match(T__35);
				setState(103); packageAndClassName(0);
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__105) {
					{
					{
					setState(105); match(T__105);
					setState(106); packageAndClassName(0);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ClassModifierContext extends ParserRuleContext {
		public ClassModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitClassModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassModifierContext classModifier() throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if ( !(_la==T__101 || _la==T__59 || _la==T__30 || _la==T__26) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class InnerClassContext extends ParserRuleContext {
		public List<RefContext> ref() {
			return getRuleContexts(RefContext.class);
		}
		public RefContext ref(int i) {
			return getRuleContext(RefContext.class,i);
		}
		public InnerClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitInnerClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerClassContext innerClass() throws RecognitionException {
		InnerClassContext _localctx = new InnerClassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_innerClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(T__1);
			setState(129); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				switch (_input.LA(1)) {
				case T__59:
				case T__30:
					{
					setState(117);
					_la = _input.LA(1);
					if ( !(_la==T__59 || _la==T__30) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(121);
						switch (_input.LA(1)) {
						case T__43:
							{
							setState(118); match(T__43);
							}
							break;
						case REFNUM:
							{
							setState(119); ref();
							}
							break;
						case T__85:
							{
							setState(120); match(T__85);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(123); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__85 || _la==T__43 || _la==REFNUM );
					}
					break;
				case REFNUM:
					{
					setState(125); ref();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(128); match(T__83);
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__59 || _la==T__30 || _la==REFNUM );
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

	public static class FieldsContext extends ParserRuleContext {
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__101) | (1L << T__94) | (1L << T__59) | (1L << T__53))) != 0) || _la==T__30 || _la==T__26) {
				{
				{
				setState(133); fieldModifier();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139); type();
			setState(140); fieldName();
			setState(141); match(T__83);
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

	public static class FieldModifierContext extends ParserRuleContext {
		public ClassModifierContext classModifier() {
			return getRuleContext(ClassModifierContext.class,0);
		}
		public FieldModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitFieldModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldModifierContext fieldModifier() throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldModifier);
		try {
			setState(146);
			switch (_input.LA(1)) {
			case T__101:
			case T__59:
			case T__30:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(143); classModifier();
				}
				break;
			case T__94:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); match(T__94);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 3);
				{
				setState(145); match(T__53);
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

	public static class FieldNameContext extends ParserRuleContext {
		public PackageAndClassNameContext packageAndClassName() {
			return getRuleContext(PackageAndClassNameContext.class,0);
		}
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); packageAndClassName(0);
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

	public static class ConstantPoolContext extends ParserRuleContext {
		public TableEntriesContext tableEntries() {
			return getRuleContext(TableEntriesContext.class,0);
		}
		public ConstantPoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantPool; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitConstantPool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantPoolContext constantPool() throws RecognitionException {
		ConstantPoolContext _localctx = new ConstantPoolContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constantPool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(T__5);
			setState(151); tableEntries();
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

	public static class TableEntriesContext extends ParserRuleContext {
		public List<TableEntryContext> tableEntry() {
			return getRuleContexts(TableEntryContext.class);
		}
		public TableEntryContext tableEntry(int i) {
			return getRuleContext(TableEntryContext.class,i);
		}
		public TableEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableEntries; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitTableEntries(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableEntriesContext tableEntries() throws RecognitionException {
		TableEntriesContext _localctx = new TableEntriesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153); tableEntry();
				}
				}
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==REFNUM );
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

	public static class TableEntryContext extends ParserRuleContext {
		public RefContext ref() {
			return getRuleContext(RefContext.class,0);
		}
		public ConstantAndInfoContext constantAndInfo() {
			return getRuleContext(ConstantAndInfoContext.class,0);
		}
		public TableEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableEntry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitTableEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableEntryContext tableEntry() throws RecognitionException {
		TableEntryContext _localctx = new TableEntryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tableEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); ref();
			setState(159); match(T__43);
			setState(160); constantAndInfo();
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

	public static class ConstantAndInfoContext extends ParserRuleContext {
		public TerminalNode DEC() { return getToken(BytecodeParser.DEC, 0); }
		public List<TerminalNode> Identifier() { return getTokens(BytecodeParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(BytecodeParser.Identifier, i);
		}
		public List<IdentifierExtendedContext> identifierExtended() {
			return getRuleContexts(IdentifierExtendedContext.class);
		}
		public List<RefContext> ref() {
			return getRuleContexts(RefContext.class);
		}
		public RefContext ref(int i) {
			return getRuleContext(RefContext.class,i);
		}
		public TerminalNode STRING() { return getToken(BytecodeParser.STRING, 0); }
		public TerminalNode NAT(int i) {
			return getToken(BytecodeParser.NAT, i);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public List<TerminalNode> NAT() { return getTokens(BytecodeParser.NAT); }
		public IdentifierExtendedContext identifierExtended(int i) {
			return getRuleContext(IdentifierExtendedContext.class,i);
		}
		public ConstantAndInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantAndInfo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitConstantAndInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantAndInfoContext constantAndInfo() throws RecognitionException {
		ConstantAndInfoContext _localctx = new ConstantAndInfoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constantAndInfo);
		int _la;
		try {
			setState(226);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); match(T__18);
				setState(163); ref();
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 2);
				{
				setState(164); match(T__69);
				setState(165); ref();
				setState(166); match(T__11);
				setState(167); ref();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(169); match(T__25);
				setState(170); ref();
				setState(171); match(T__11);
				setState(172); ref();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(174); match(T__12);
				setState(175); ref();
				setState(176); match(T__11);
				setState(177); ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(179); match(STRING);
				setState(180); ref();
				}
				break;
			case T__82:
				enterOuterAlt(_localctx, 6);
				{
				setState(181); match(T__82);
				setState(182); num();
				}
				break;
			case T__114:
				enterOuterAlt(_localctx, 7);
				{
				setState(183); match(T__114);
				setState(184); match(DEC);
				}
				break;
			case T__84:
				enterOuterAlt(_localctx, 8);
				{
				setState(185); match(T__84);
				setState(186); num();
				setState(187); match(T__74);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 9);
				{
				setState(189); match(T__19);
				setState(190); match(DEC);
				}
				break;
			case T__60:
				enterOuterAlt(_localctx, 10);
				{
				setState(191); match(T__60);
				setState(192); ref();
				setState(193); match(T__62);
				setState(194); ref();
				}
				break;
			case T__70:
				enterOuterAlt(_localctx, 11);
				{
				setState(196); match(T__70);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__108) | (1L << T__105) | (1L << T__96) | (1L << T__95) | (1L << T__83) | (1L << T__78) | (1L << T__62) | (1L << T__61) | (1L << T__58) | (1L << T__57))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__40 - 75)) | (1L << (T__23 - 75)) | (1L << (T__21 - 75)) | (1L << (T__16 - 75)) | (1L << (T__11 - 75)) | (1L << (T__3 - 75)) | (1L << (T__2 - 75)) | (1L << (T__0 - 75)) | (1L << (NAT - 75)) | (1L << (THIS - 75)) | (1L << (STRING - 75)) | (1L << (Identifier - 75)))) != 0)) {
					{
					setState(221);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(199);
						switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
						case 1:
							{
							setState(197); match(Identifier);
							}
							break;
						case 2:
							{
							setState(198); identifierExtended();
							}
							break;
						}
						}
						break;
					case 2:
						{
						setState(201); match(NAT);
						}
						break;
					case 3:
						{
						setState(202); match(T__2);
						}
						break;
					case 4:
						{
						setState(203); match(T__83);
						}
						break;
					case 5:
						{
						setState(204); match(T__40);
						}
						break;
					case 6:
						{
						setState(205); match(T__57);
						}
						break;
					case 7:
						{
						setState(206); match(T__23);
						}
						break;
					case 8:
						{
						setState(207); match(T__0);
						}
						break;
					case 9:
						{
						setState(208); match(T__96);
						}
						break;
					case 10:
						{
						setState(209); match(T__3);
						}
						break;
					case 11:
						{
						setState(210); match(T__83);
						}
						break;
					case 12:
						{
						setState(211); match(T__61);
						}
						break;
					case 13:
						{
						setState(212); match(T__95);
						}
						break;
					case 14:
						{
						setState(213); match(T__11);
						}
						break;
					case 15:
						{
						setState(214); match(T__62);
						}
						break;
					case 16:
						{
						setState(215); match(T__78);
						}
						break;
					case 17:
						{
						setState(216); match(T__58);
						}
						break;
					case 18:
						{
						setState(217); match(T__16);
						}
						break;
					case 19:
						{
						setState(218); match(T__108);
						}
						break;
					case 20:
						{
						setState(219); match(T__21);
						}
						break;
					case 21:
						{
						setState(220); match(T__105);
						}
						break;
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public List<MethodModifierContext> methodModifier() {
			return getRuleContexts(MethodModifierContext.class);
		}
		public MethodModifierContext methodModifier(int i) {
			return getRuleContext(MethodModifierContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(228); methodModifier();
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(236);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(234); methodHeader();
				}
				break;
			case 2:
				{
				setState(235); match(T__42);
				}
				break;
			}
			setState(238); match(T__83);
			setState(239); methodBody();
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

	public static class MethodModifierContext extends ParserRuleContext {
		public FieldModifierContext fieldModifier() {
			return getRuleContext(FieldModifierContext.class,0);
		}
		public MethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMethodModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodModifierContext methodModifier() throws RecognitionException {
		MethodModifierContext _localctx = new MethodModifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_methodModifier);
		try {
			setState(246);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241); fieldModifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242); match(T__101);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(243); match(T__13);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(244); match(T__87);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(245); match(T__88);
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

	public static class MethodHeaderContext extends ParserRuleContext {
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public MethodDeclaratorContext methodDeclarator() {
			return getRuleContext(MethodDeclaratorContext.class,0);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMethodHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(248); result();
				}
				break;
			}
			setState(251); methodDeclarator();
			setState(253);
			_la = _input.LA(1);
			if (_la==T__104) {
				{
				setState(252); throws_();
				}
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

	public static class ResultContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_result);
		try {
			setState(258);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				if (!( ! _input.LT(1).getText().substring(_input.LT(1).getText().length() - 1).equals("("))) throw new FailedPredicateException(this, " ! _input.LT(1).getText().substring(_input.LT(1).getText().length() - 1).equals(\"(\")");
				setState(256); type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257); match(T__46);
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

	public static class TypeContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		try {
			setState(262);
			switch (_input.LA(1)) {
			case T__111:
			case T__106:
			case T__100:
			case T__98:
			case T__49:
			case T__44:
			case T__15:
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(260); primitiveType();
				}
				break;
			case THIS:
			case STRING:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(261); referenceType();
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primitiveType);
		try {
			setState(266);
			switch (_input.LA(1)) {
			case T__111:
			case T__106:
			case T__98:
			case T__49:
			case T__44:
			case T__15:
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(264); numericType();
				}
				break;
			case T__100:
				enterOuterAlt(_localctx, 2);
				{
				setState(265); match(T__100);
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

	public static class NumericTypeContext extends ParserRuleContext {
		public IntegralTypeContext integralType() {
			return getRuleContext(IntegralTypeContext.class,0);
		}
		public FloatingPointTypeContext floatingPointType() {
			return getRuleContext(FloatingPointTypeContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitNumericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_numericType);
		try {
			setState(270);
			switch (_input.LA(1)) {
			case T__111:
			case T__106:
			case T__98:
			case T__44:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(268); integralType();
				}
				break;
			case T__49:
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(269); floatingPointType();
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

	public static class IntegralTypeContext extends ParserRuleContext {
		public IntegralTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integralType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitIntegralType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegralTypeContext integralType() throws RecognitionException {
		IntegralTypeContext _localctx = new IntegralTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_integralType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__111) | (1L << T__106) | (1L << T__98))) != 0) || _la==T__44 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class FloatingPointTypeContext extends ParserRuleContext {
		public FloatingPointTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPointType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitFloatingPointType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingPointTypeContext floatingPointType() throws RecognitionException {
		FloatingPointTypeContext _localctx = new FloatingPointTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_floatingPointType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !(_la==T__49 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ReferenceTypeContext extends ParserRuleContext {
		public PackageAndClassNameContext packageAndClassName() {
			return getRuleContext(PackageAndClassNameContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitReferenceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_referenceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); packageAndClassName(0);
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

	public static class PackageAndClassNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BytecodeParser.Identifier, 0); }
		public IdentifierExtendedContext identifierExtended() {
			return getRuleContext(IdentifierExtendedContext.class,0);
		}
		public PackageAndClassNameContext packageAndClassName() {
			return getRuleContext(PackageAndClassNameContext.class,0);
		}
		public PackageAndClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageAndClassName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitPackageAndClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageAndClassNameContext packageAndClassName() throws RecognitionException {
		return packageAndClassName(0);
	}

	private PackageAndClassNameContext packageAndClassName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PackageAndClassNameContext _localctx = new PackageAndClassNameContext(_ctx, _parentState);
		PackageAndClassNameContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_packageAndClassName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(281);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(279); match(Identifier);
				}
				break;
			case 2:
				{
				setState(280); identifierExtended();
				}
				break;
			}
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(283); match(T__61);
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(289); match(T__95);
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PackageAndClassNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_packageAndClassName);
					setState(295);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(296); match(T__11);
					{
					setState(299);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(297); match(Identifier);
						}
						break;
					case 2:
						{
						setState(298); identifierExtended();
						}
						break;
					}
					setState(304);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(301); match(T__61);
							}
							} 
						}
						setState(306);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					}
					setState(310);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(307); match(T__95);
							}
							} 
						}
						setState(312);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					}
					}
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MethodDeclaratorContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMethodDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
		MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_methodDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); methodName();
			setState(319); match(T__40);
			setState(321);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__111) | (1L << T__106) | (1L << T__100) | (1L << T__98))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (T__49 - 66)) | (1L << (T__44 - 66)) | (1L << (T__26 - 66)) | (1L << (T__15 - 66)) | (1L << (T__14 - 66)) | (1L << (THIS - 66)) | (1L << (STRING - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				setState(320); formalParameters();
				}
			}

			setState(323); match(T__57);
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

	public static class MethodNameContext extends ParserRuleContext {
		public PackageAndClassNameContext packageAndClassName() {
			return getRuleContext(PackageAndClassNameContext.class,0);
		}
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325); packageAndClassName(0);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327); formalParameter();
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__105) {
				{
				{
				setState(328); match(T__105);
				setState(329); formalParameter();
				}
				}
				setState(334);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode THIS() { return getToken(BytecodeParser.THIS, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(335); match(T__26);
				}
			}

			setState(340);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(338); type();
				}
				break;
			case 2:
				{
				setState(339); match(THIS);
				}
				break;
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

	public static class Throws_Context extends ParserRuleContext {
		public ExceptionTypeListContext exceptionTypeList() {
			return getRuleContext(ExceptionTypeListContext.class,0);
		}
		public Throws_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throws_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitThrows_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Throws_Context throws_() throws RecognitionException {
		Throws_Context _localctx = new Throws_Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_throws_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342); match(T__104);
			setState(343); exceptionTypeList();
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

	public static class ExceptionTypeListContext extends ParserRuleContext {
		public List<ExceptionTypeContext> exceptionType() {
			return getRuleContexts(ExceptionTypeContext.class);
		}
		public ExceptionTypeContext exceptionType(int i) {
			return getRuleContext(ExceptionTypeContext.class,i);
		}
		public ExceptionTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionTypeList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitExceptionTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionTypeListContext exceptionTypeList() throws RecognitionException {
		ExceptionTypeListContext _localctx = new ExceptionTypeListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exceptionTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); exceptionType();
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__105) {
				{
				{
				setState(346); match(T__105);
				setState(347); exceptionType();
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

	public static class ExceptionTypeContext extends ParserRuleContext {
		public PackageAndClassNameContext packageAndClassName() {
			return getRuleContext(PackageAndClassNameContext.class,0);
		}
		public ExceptionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitExceptionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionTypeContext exceptionType() throws RecognitionException {
		ExceptionTypeContext _localctx = new ExceptionTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_exceptionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353); packageAndClassName(0);
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

	public static class MethodBodyContext extends ParserRuleContext {
		public List<InstructionLineContext> instructionLine() {
			return getRuleContexts(InstructionLineContext.class);
		}
		public InstructionLineContext instructionLine(int i) {
			return getRuleContext(InstructionLineContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_methodBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(355); match(T__34);
			setState(357); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(356); instructionLine();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(359); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class InstructionLineContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(BytecodeParser.INDEX, 0); }
		public RefContext ref() {
			return getRuleContext(RefContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public TerminalNode NAT() { return getToken(BytecodeParser.NAT, 0); }
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public InstructionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionLine; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitInstructionLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionLineContext instructionLine() throws RecognitionException {
		InstructionLineContext _localctx = new InstructionLineContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_instructionLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361); match(INDEX);
			setState(362); instruction();
			setState(370);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				{
				setState(364);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(363); match(NAT);
					}
					break;
				}
				setState(367);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(366); num();
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				setState(369); ref();
				}
				break;
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

	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MonitorenterContext extends InstructionContext {
		public MonitorenterContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMonitorenter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewContext extends InstructionContext {
		public NewContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadContext extends InstructionContext {
		public TerminalNode ALOAD() { return getToken(BytecodeParser.ALOAD, 0); }
		public TerminalNode ILOAD() { return getToken(BytecodeParser.ILOAD, 0); }
		public LoadContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GotoContext extends InstructionContext {
		public GotoContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitGoto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends InstructionContext {
		public ReturnContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstContext extends InstructionContext {
		public ConstContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitConst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StoreContext extends InstructionContext {
		public TerminalNode ASTORE() { return getToken(BytecodeParser.ASTORE, 0); }
		public TerminalNode ISTORE() { return getToken(BytecodeParser.ISTORE, 0); }
		public StoreContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitStore(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotImplementedContext extends InstructionContext {
		public NotImplementedContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitNotImplemented(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OperationContext extends InstructionContext {
		public OperationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PutContext extends InstructionContext {
		public PutContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitPut(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvokeContext extends InstructionContext {
		public InvokeContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitInvoke(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MonitorexitContext extends InstructionContext {
		public MonitorexitContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitMonitorexit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PopContext extends InstructionContext {
		public PopContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitPop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetContext extends InstructionContext {
		public GetContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitGet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IincContext extends InstructionContext {
		public IincContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitIinc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AthrowContext extends InstructionContext {
		public AthrowContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitAthrow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends InstructionContext {
		public IfContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DupContext extends InstructionContext {
		public DupContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitDup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_instruction);
		try {
			setState(433);
			switch (_input.LA(1)) {
			case T__67:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(372); match(T__67);
				}
				break;
			case T__66:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(373); match(T__66);
				}
				break;
			case ALOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(374); match(ALOAD);
				}
				break;
			case T__76:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(375); match(T__76);
				}
				break;
			case T__37:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(376); match(T__37);
				}
				break;
			case ASTORE:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(377); match(ASTORE);
				}
				break;
			case T__109:
				_localctx = new AthrowContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(378); match(T__109);
				}
				break;
			case T__112:
				_localctx = new DupContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(379); match(T__112);
				}
				break;
			case T__6:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(380); match(T__6);
				}
				break;
			case T__68:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(381); match(T__68);
				}
				break;
			case T__20:
				_localctx = new GotoContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(382); match(T__20);
				}
				break;
			case T__29:
				_localctx = new OperationContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(383); match(T__29);
				}
				break;
			case T__32:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(384); match(T__32);
				}
				break;
			case T__9:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(385); match(T__9);
				}
				break;
			case T__113:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(386); match(T__113);
				}
				break;
			case T__102:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(387); match(T__102);
				}
				break;
			case T__86:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(388); match(T__86);
				}
				break;
			case T__64:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(389); match(T__64);
				}
				break;
			case T__51:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(390); match(T__51);
				}
				break;
			case T__73:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(391); match(T__73);
				}
				break;
			case T__36:
				_localctx = new OperationContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(392); match(T__36);
				}
				break;
			case T__110:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(393); match(T__110);
				}
				break;
			case T__7:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(394); match(T__7);
				}
				break;
			case T__89:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(395); match(T__89);
				}
				break;
			case T__39:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(396); match(T__39);
				}
				break;
			case T__103:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(397); match(T__103);
				}
				break;
			case T__79:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(398); match(T__79);
				}
				break;
			case T__72:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(399); match(T__72);
				}
				break;
			case T__107:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(400); match(T__107);
				}
				break;
			case T__47:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(401); match(T__47);
				}
				break;
			case T__93:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(402); match(T__93);
				}
				break;
			case T__10:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(403); match(T__10);
				}
				break;
			case T__31:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(404); match(T__31);
				}
				break;
			case T__33:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(405); match(T__33);
				}
				break;
			case T__54:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(406); match(T__54);
				}
				break;
			case T__71:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 36);
				{
				setState(407); match(T__71);
				}
				break;
			case T__48:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 37);
				{
				setState(408); match(T__48);
				}
				break;
			case T__80:
				_localctx = new IincContext(_localctx);
				enterOuterAlt(_localctx, 38);
				{
				setState(409); match(T__80);
				}
				break;
			case T__52:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 39);
				{
				setState(410); match(T__52);
				}
				break;
			case ILOAD:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 40);
				{
				setState(411); match(ILOAD);
				}
				break;
			case T__55:
				_localctx = new OperationContext(_localctx);
				enterOuterAlt(_localctx, 41);
				{
				setState(412); match(T__55);
				}
				break;
			case T__75:
				_localctx = new InvokeContext(_localctx);
				enterOuterAlt(_localctx, 42);
				{
				setState(413); match(T__75);
				}
				break;
			case T__24:
				_localctx = new InvokeContext(_localctx);
				enterOuterAlt(_localctx, 43);
				{
				setState(414); match(T__24);
				}
				break;
			case T__4:
				_localctx = new InvokeContext(_localctx);
				enterOuterAlt(_localctx, 44);
				{
				setState(415); match(T__4);
				}
				break;
			case T__41:
				_localctx = new OperationContext(_localctx);
				enterOuterAlt(_localctx, 45);
				{
				setState(416); match(T__41);
				}
				break;
			case T__97:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 46);
				{
				setState(417); match(T__97);
				}
				break;
			case T__65:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 47);
				{
				setState(418); match(T__65);
				}
				break;
			case ISTORE:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 48);
				{
				setState(419); match(ISTORE);
				}
				break;
			case T__56:
				_localctx = new OperationContext(_localctx);
				enterOuterAlt(_localctx, 49);
				{
				setState(420); match(T__56);
				}
				break;
			case T__8:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 50);
				{
				setState(421); match(T__8);
				}
				break;
			case T__28:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 51);
				{
				setState(422); match(T__28);
				}
				break;
			case T__90:
				_localctx = new NotImplementedContext(_localctx);
				enterOuterAlt(_localctx, 52);
				{
				setState(423); match(T__90);
				}
				break;
			case T__77:
				_localctx = new MonitorenterContext(_localctx);
				enterOuterAlt(_localctx, 53);
				{
				setState(424); match(T__77);
				}
				break;
			case T__99:
				_localctx = new MonitorexitContext(_localctx);
				enterOuterAlt(_localctx, 54);
				{
				setState(425); match(T__99);
				}
				break;
			case T__50:
				_localctx = new NewContext(_localctx);
				enterOuterAlt(_localctx, 55);
				{
				setState(426); match(T__50);
				}
				break;
			case T__92:
				_localctx = new PopContext(_localctx);
				enterOuterAlt(_localctx, 56);
				{
				setState(427); match(T__92);
				}
				break;
			case T__63:
				_localctx = new PutContext(_localctx);
				enterOuterAlt(_localctx, 57);
				{
				setState(428); match(T__63);
				}
				break;
			case T__91:
				_localctx = new PutContext(_localctx);
				enterOuterAlt(_localctx, 58);
				{
				setState(429); match(T__91);
				}
				break;
			case T__27:
				_localctx = new NotImplementedContext(_localctx);
				enterOuterAlt(_localctx, 59);
				{
				setState(430); match(T__27);
				}
				break;
			case T__38:
				_localctx = new NotImplementedContext(_localctx);
				enterOuterAlt(_localctx, 60);
				{
				setState(431); match(T__38);
				}
				break;
			case T__22:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 61);
				{
				setState(432); match(T__22);
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

	public static class RefContext extends ParserRuleContext {
		public TerminalNode REFNUM() { return getToken(BytecodeParser.REFNUM, 0); }
		public RefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefContext ref() throws RecognitionException {
		RefContext _localctx = new RefContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435); match(REFNUM);
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

	public static class NumContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BytecodeParser.INT, 0); }
		public TerminalNode NAT() { return getToken(BytecodeParser.NAT, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			_la = _input.LA(1);
			if ( !(_la==NAT || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class IdentifierExtendedContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BytecodeParser.Identifier, 0); }
		public TerminalNode STRING() { return getToken(BytecodeParser.STRING, 0); }
		public TerminalNode THIS() { return getToken(BytecodeParser.THIS, 0); }
		public IdentifierExtendedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierExtended; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BytecodeVisitor ) return ((BytecodeVisitor<? extends T>)visitor).visitIdentifierExtended(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierExtendedContext identifierExtended() throws RecognitionException {
		IdentifierExtendedContext _localctx = new IdentifierExtendedContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_identifierExtended);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_la = _input.LA(1);
			if ( !(((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (THIS - 127)) | (1L << (STRING - 127)) | (1L << (Identifier - 127)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14: return result_sempred((ResultContext)_localctx, predIndex);
		case 21: return packageAndClassName_sempred((PackageAndClassNameContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean result_sempred(ResultContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return  ! _input.LT(1).getText().substring(_input.LT(1).getText().length() - 1).equals("(");
		}
		return true;
	}
	private boolean packageAndClassName_sempred(PackageAndClassNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00a1\u01bc\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\5\2K\n\2\3\2\3\2\3\2\7\2P\n\2\f\2\16\2"+
		"S\13\2\3\2\6\2V\n\2\r\2\16\2W\3\2\3\2\5\2\\\n\2\3\2\3\2\3\3\5\3a\n\3\3"+
		"\3\3\3\3\3\3\3\5\3g\n\3\3\3\3\3\3\3\3\3\3\3\7\3n\n\3\f\3\16\3q\13\3\5"+
		"\3s\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\6\5|\n\5\r\5\16\5}\3\5\5\5\u0081\n"+
		"\5\3\5\6\5\u0084\n\5\r\5\16\5\u0085\3\6\7\6\u0089\n\6\f\6\16\6\u008c\13"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7\u0095\n\7\3\b\3\b\3\t\3\t\3\t\3\n\6"+
		"\n\u009d\n\n\r\n\16\n\u009e\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ca\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\7\f\u00e0\n\f\f\f\16\f\u00e3\13\f\5\f\u00e5\n\f\3\r\7\r\u00e8"+
		"\n\r\f\r\16\r\u00eb\13\r\3\r\3\r\5\r\u00ef\n\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00f9\n\16\3\17\5\17\u00fc\n\17\3\17\3\17\5\17\u0100"+
		"\n\17\3\20\3\20\3\20\5\20\u0105\n\20\3\21\3\21\5\21\u0109\n\21\3\22\3"+
		"\22\5\22\u010d\n\22\3\23\3\23\5\23\u0111\n\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\5\27\u011c\n\27\3\27\7\27\u011f\n\27\f\27\16\27\u0122"+
		"\13\27\3\27\7\27\u0125\n\27\f\27\16\27\u0128\13\27\3\27\3\27\3\27\3\27"+
		"\5\27\u012e\n\27\3\27\7\27\u0131\n\27\f\27\16\27\u0134\13\27\3\27\7\27"+
		"\u0137\n\27\f\27\16\27\u013a\13\27\7\27\u013c\n\27\f\27\16\27\u013f\13"+
		"\27\3\30\3\30\3\30\5\30\u0144\n\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32"+
		"\7\32\u014d\n\32\f\32\16\32\u0150\13\32\3\33\5\33\u0153\n\33\3\33\3\33"+
		"\5\33\u0157\n\33\3\34\3\34\3\34\3\35\3\35\3\35\7\35\u015f\n\35\f\35\16"+
		"\35\u0162\13\35\3\36\3\36\3\37\3\37\6\37\u0168\n\37\r\37\16\37\u0169\3"+
		" \3 \3 \5 \u016f\n \3 \5 \u0172\n \3 \5 \u0175\n \3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01b4\n!\3\"\3\"\3#\3#\3$\3$\3$\2\3,%\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\t\3"+
		"\2vw\6\2\20\20::WW[[\4\2::WW\7\2\6\6\13\13\23\23IIff\4\2DDgg\3\2~\177"+
		"\3\2\u0081\u0083\u0221\2H\3\2\2\2\4`\3\2\2\2\6t\3\2\2\2\bv\3\2\2\2\n\u008a"+
		"\3\2\2\2\f\u0094\3\2\2\2\16\u0096\3\2\2\2\20\u0098\3\2\2\2\22\u009c\3"+
		"\2\2\2\24\u00a0\3\2\2\2\26\u00e4\3\2\2\2\30\u00e9\3\2\2\2\32\u00f8\3\2"+
		"\2\2\34\u00fb\3\2\2\2\36\u0104\3\2\2\2 \u0108\3\2\2\2\"\u010c\3\2\2\2"+
		"$\u0110\3\2\2\2&\u0112\3\2\2\2(\u0114\3\2\2\2*\u0116\3\2\2\2,\u0118\3"+
		"\2\2\2.\u0140\3\2\2\2\60\u0147\3\2\2\2\62\u0149\3\2\2\2\64\u0152\3\2\2"+
		"\2\66\u0158\3\2\2\28\u015b\3\2\2\2:\u0163\3\2\2\2<\u0165\3\2\2\2>\u016b"+
		"\3\2\2\2@\u01b3\3\2\2\2B\u01b5\3\2\2\2D\u01b7\3\2\2\2F\u01b9\3\2\2\2H"+
		"J\5\4\3\2IK\5\b\5\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\5\20\t\2MQ\7H\2\2"+
		"NP\5\n\6\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2"+
		"TV\5\30\r\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y[\7$\2\2"+
		"Z\\\5\b\5\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\2\2\3^\3\3\2\2\2_a\5\6"+
		"\4\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\t\2\2\2cf\5,\27\2de\7d\2\2eg\5,\27"+
		"\2fd\3\2\2\2fg\3\2\2\2gr\3\2\2\2hi\7R\2\2ij\5,\27\2jo\3\2\2\2kl\7\f\2"+
		"\2ln\5,\27\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2"+
		"\2rh\3\2\2\2rs\3\2\2\2s\5\3\2\2\2tu\t\3\2\2u\7\3\2\2\2v\u0083\7t\2\2w"+
		"{\t\4\2\2x|\7J\2\2y|\5B\"\2z|\7 \2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|}\3"+
		"\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177\u0081\5B\"\2\u0080w\3\2"+
		"\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\7\"\2\2\u0083\u0080"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\t\3\2\2\2\u0087\u0089\5\f\7\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2"+
		"\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008d\u008e\5 \21\2\u008e\u008f\5\16\b\2\u008f\u0090\7\"\2\2"+
		"\u0090\13\3\2\2\2\u0091\u0095\5\6\4\2\u0092\u0095\7\27\2\2\u0093\u0095"+
		"\7@\2\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\r\3\2\2\2\u0096\u0097\5,\27\2\u0097\17\3\2\2\2\u0098\u0099\7p\2\2\u0099"+
		"\u009a\5\22\n\2\u009a\21\3\2\2\2\u009b\u009d\5\24\13\2\u009c\u009b\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\23\3\2\2\2\u00a0\u00a1\5B\"\2\u00a1\u00a2\7J\2\2\u00a2\u00a3\5\26\f\2"+
		"\u00a3\25\3\2\2\2\u00a4\u00a5\7c\2\2\u00a5\u00e5\5B\"\2\u00a6\u00a7\7"+
		"\60\2\2\u00a7\u00a8\5B\"\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\5B\"\2\u00aa"+
		"\u00e5\3\2\2\2\u00ab\u00ac\7\\\2\2\u00ac\u00ad\5B\"\2\u00ad\u00ae\7j\2"+
		"\2\u00ae\u00af\5B\"\2\u00af\u00e5\3\2\2\2\u00b0\u00b1\7i\2\2\u00b1\u00b2"+
		"\5B\"\2\u00b2\u00b3\7j\2\2\u00b3\u00b4\5B\"\2\u00b4\u00e5\3\2\2\2\u00b5"+
		"\u00b6\7\u0082\2\2\u00b6\u00e5\5B\"\2\u00b7\u00b8\7#\2\2\u00b8\u00e5\5"+
		"D#\2\u00b9\u00ba\7\3\2\2\u00ba\u00e5\7\u0080\2\2\u00bb\u00bc\7!\2\2\u00bc"+
		"\u00bd\5D#\2\u00bd\u00be\7+\2\2\u00be\u00e5\3\2\2\2\u00bf\u00c0\7b\2\2"+
		"\u00c0\u00e5\7\u0080\2\2\u00c1\u00c2\79\2\2\u00c2\u00c3\5B\"\2\u00c3\u00c4"+
		"\7\67\2\2\u00c4\u00c5\5B\"\2\u00c5\u00e5\3\2\2\2\u00c6\u00e1\7/\2\2\u00c7"+
		"\u00ca\7\u0083\2\2\u00c8\u00ca\5F$\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3"+
		"\2\2\2\u00ca\u00e0\3\2\2\2\u00cb\u00e0\7~\2\2\u00cc\u00e0\7s\2\2\u00cd"+
		"\u00e0\7\"\2\2\u00ce\u00e0\7M\2\2\u00cf\u00e0\7<\2\2\u00d0\u00e0\7^\2"+
		"\2\u00d1\u00e0\7u\2\2\u00d2\u00e0\7\25\2\2\u00d3\u00e0\7r\2\2\u00d4\u00e0"+
		"\7\"\2\2\u00d5\u00e0\78\2\2\u00d6\u00e0\7\26\2\2\u00d7\u00e0\7j\2\2\u00d8"+
		"\u00e0\7\67\2\2\u00d9\u00e0\7\'\2\2\u00da\u00e0\7;\2\2\u00db\u00e0\7e"+
		"\2\2\u00dc\u00e0\7\t\2\2\u00dd\u00e0\7`\2\2\u00de\u00e0\7\f\2\2\u00df"+
		"\u00c9\3\2\2\2\u00df\u00cb\3\2\2\2\u00df\u00cc\3\2\2\2\u00df\u00cd\3\2"+
		"\2\2\u00df\u00ce\3\2\2\2\u00df\u00cf\3\2\2\2\u00df\u00d0\3\2\2\2\u00df"+
		"\u00d1\3\2\2\2\u00df\u00d2\3\2\2\2\u00df\u00d3\3\2\2\2\u00df\u00d4\3\2"+
		"\2\2\u00df\u00d5\3\2\2\2\u00df\u00d6\3\2\2\2\u00df\u00d7\3\2\2\2\u00df"+
		"\u00d8\3\2\2\2\u00df\u00d9\3\2\2\2\u00df\u00da\3\2\2\2\u00df\u00db\3\2"+
		"\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00a4\3\2\2\2\u00e4\u00a6\3\2\2\2\u00e4"+
		"\u00ab\3\2\2\2\u00e4\u00b0\3\2\2\2\u00e4\u00b5\3\2\2\2\u00e4\u00b7\3\2"+
		"\2\2\u00e4\u00b9\3\2\2\2\u00e4\u00bb\3\2\2\2\u00e4\u00bf\3\2\2\2\u00e4"+
		"\u00c1\3\2\2\2\u00e4\u00c6\3\2\2\2\u00e5\27\3\2\2\2\u00e6\u00e8\5\32\16"+
		"\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\5\34\17\2"+
		"\u00ed\u00ef\7K\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f1\7\"\2\2\u00f1\u00f2\5<\37\2\u00f2\31\3\2\2\2\u00f3"+
		"\u00f9\5\f\7\2\u00f4\u00f9\7\20\2\2\u00f5\u00f9\7h\2\2\u00f6\u00f9\7\36"+
		"\2\2\u00f7\u00f9\7\35\2\2\u00f8\u00f3\3\2\2\2\u00f8\u00f4\3\2\2\2\u00f8"+
		"\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\33\3\2\2"+
		"\2\u00fa\u00fc\5\36\20\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00ff\5.\30\2\u00fe\u0100\5\66\34\2\u00ff\u00fe\3"+
		"\2\2\2\u00ff\u0100\3\2\2\2\u0100\35\3\2\2\2\u0101\u0102\6\20\2\2\u0102"+
		"\u0105\5 \21\2\u0103\u0105\7G\2\2\u0104\u0101\3\2\2\2\u0104\u0103\3\2"+
		"\2\2\u0105\37\3\2\2\2\u0106\u0109\5\"\22\2\u0107\u0109\5*\26\2\u0108\u0106"+
		"\3\2\2\2\u0108\u0107\3\2\2\2\u0109!\3\2\2\2\u010a\u010d\5$\23\2\u010b"+
		"\u010d\7\21\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d#\3\2\2\2"+
		"\u010e\u0111\5&\24\2\u010f\u0111\5(\25\2\u0110\u010e\3\2\2\2\u0110\u010f"+
		"\3\2\2\2\u0111%\3\2\2\2\u0112\u0113\t\5\2\2\u0113\'\3\2\2\2\u0114\u0115"+
		"\t\6\2\2\u0115)\3\2\2\2\u0116\u0117\5,\27\2\u0117+\3\2\2\2\u0118\u011b"+
		"\b\27\1\2\u0119\u011c\7\u0083\2\2\u011a\u011c\5F$\2\u011b\u0119\3\2\2"+
		"\2\u011b\u011a\3\2\2\2\u011c\u0120\3\2\2\2\u011d\u011f\78\2\2\u011e\u011d"+
		"\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0126\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0125\7\26\2\2\u0124\u0123\3"+
		"\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u013d\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012a\f\3\2\2\u012a\u012d\7j"+
		"\2\2\u012b\u012e\7\u0083\2\2\u012c\u012e\5F$\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012c\3\2\2\2\u012e\u0132\3\2\2\2\u012f\u0131\78\2\2\u0130\u012f\3\2"+
		"\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0138\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0137\7\26\2\2\u0136\u0135\3"+
		"\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0129\3\2\2\2\u013c\u013f\3\2"+
		"\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e-\3\2\2\2\u013f\u013d"+
		"\3\2\2\2\u0140\u0141\5\60\31\2\u0141\u0143\7M\2\2\u0142\u0144\5\62\32"+
		"\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146"+
		"\7<\2\2\u0146/\3\2\2\2\u0147\u0148\5,\27\2\u0148\61\3\2\2\2\u0149\u014e"+
		"\5\64\33\2\u014a\u014b\7\f\2\2\u014b\u014d\5\64\33\2\u014c\u014a\3\2\2"+
		"\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\63"+
		"\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0153\7[\2\2\u0152\u0151\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0157\5 \21\2\u0155\u0157\7\u0081"+
		"\2\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\65\3\2\2\2\u0158\u0159"+
		"\7\r\2\2\u0159\u015a\58\35\2\u015a\67\3\2\2\2\u015b\u0160\5:\36\2\u015c"+
		"\u015d\7\f\2\2\u015d\u015f\5:\36\2\u015e\u015c\3\2\2\2\u015f\u0162\3\2"+
		"\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u01619\3\2\2\2\u0162\u0160"+
		"\3\2\2\2\u0163\u0164\5,\27\2\u0164;\3\2\2\2\u0165\u0167\7S\2\2\u0166\u0168"+
		"\5> \2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169"+
		"\u016a\3\2\2\2\u016a=\3\2\2\2\u016b\u016c\7x\2\2\u016c\u0174\5@!\2\u016d"+
		"\u016f\7~\2\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2"+
		"\2\2\u0170\u0172\5D#\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0175"+
		"\3\2\2\2\u0173\u0175\5B\"\2\u0174\u016e\3\2\2\2\u0174\u0173\3\2\2\2\u0175"+
		"?\3\2\2\2\u0176\u01b4\7\62\2\2\u0177\u01b4\7\63\2\2\u0178\u01b4\7y\2\2"+
		"\u0179\u01b4\7)\2\2\u017a\u01b4\7P\2\2\u017b\u01b4\7|\2\2\u017c\u01b4"+
		"\7\b\2\2\u017d\u01b4\7\5\2\2\u017e\u01b4\7o\2\2\u017f\u01b4\7\61\2\2\u0180"+
		"\u01b4\7a\2\2\u0181\u01b4\7X\2\2\u0182\u01b4\7U\2\2\u0183\u01b4\7l\2\2"+
		"\u0184\u01b4\7\4\2\2\u0185\u01b4\7\17\2\2\u0186\u01b4\7\37\2\2\u0187\u01b4"+
		"\7\65\2\2\u0188\u01b4\7B\2\2\u0189\u01b4\7,\2\2\u018a\u01b4\7Q\2\2\u018b"+
		"\u01b4\7\7\2\2\u018c\u01b4\7n\2\2\u018d\u01b4\7\34\2\2\u018e\u01b4\7N"+
		"\2\2\u018f\u01b4\7\16\2\2\u0190\u01b4\7&\2\2\u0191\u01b4\7-\2\2\u0192"+
		"\u01b4\7\n\2\2\u0193\u01b4\7F\2\2\u0194\u01b4\7\30\2\2\u0195\u01b4\7k"+
		"\2\2\u0196\u01b4\7V\2\2\u0197\u01b4\7T\2\2\u0198\u01b4\7?\2\2\u0199\u01b4"+
		"\7.\2\2\u019a\u01b4\7E\2\2\u019b\u01b4\7%\2\2\u019c\u01b4\7A\2\2\u019d"+
		"\u01b4\7z\2\2\u019e\u01b4\7>\2\2\u019f\u01b4\7*\2\2\u01a0\u01b4\7]\2\2"+
		"\u01a1\u01b4\7q\2\2\u01a2\u01b4\7L\2\2\u01a3\u01b4\7\24\2\2\u01a4\u01b4"+
		"\7\64\2\2\u01a5\u01b4\7{\2\2\u01a6\u01b4\7=\2\2\u01a7\u01b4\7m\2\2\u01a8"+
		"\u01b4\7Y\2\2\u01a9\u01b4\7\33\2\2\u01aa\u01b4\7(\2\2\u01ab\u01b4\7\22"+
		"\2\2\u01ac\u01b4\7C\2\2\u01ad\u01b4\7\31\2\2\u01ae\u01b4\7\66\2\2\u01af"+
		"\u01b4\7\32\2\2\u01b0\u01b4\7Z\2\2\u01b1\u01b4\7O\2\2\u01b2\u01b4\7_\2"+
		"\2\u01b3\u0176\3\2\2\2\u01b3\u0177\3\2\2\2\u01b3\u0178\3\2\2\2\u01b3\u0179"+
		"\3\2\2\2\u01b3\u017a\3\2\2\2\u01b3\u017b\3\2\2\2\u01b3\u017c\3\2\2\2\u01b3"+
		"\u017d\3\2\2\2\u01b3\u017e\3\2\2\2\u01b3\u017f\3\2\2\2\u01b3\u0180\3\2"+
		"\2\2\u01b3\u0181\3\2\2\2\u01b3\u0182\3\2\2\2\u01b3\u0183\3\2\2\2\u01b3"+
		"\u0184\3\2\2\2\u01b3\u0185\3\2\2\2\u01b3\u0186\3\2\2\2\u01b3\u0187\3\2"+
		"\2\2\u01b3\u0188\3\2\2\2\u01b3\u0189\3\2\2\2\u01b3\u018a\3\2\2\2\u01b3"+
		"\u018b\3\2\2\2\u01b3\u018c\3\2\2\2\u01b3\u018d\3\2\2\2\u01b3\u018e\3\2"+
		"\2\2\u01b3\u018f\3\2\2\2\u01b3\u0190\3\2\2\2\u01b3\u0191\3\2\2\2\u01b3"+
		"\u0192\3\2\2\2\u01b3\u0193\3\2\2\2\u01b3\u0194\3\2\2\2\u01b3\u0195\3\2"+
		"\2\2\u01b3\u0196\3\2\2\2\u01b3\u0197\3\2\2\2\u01b3\u0198\3\2\2\2\u01b3"+
		"\u0199\3\2\2\2\u01b3\u019a\3\2\2\2\u01b3\u019b\3\2\2\2\u01b3\u019c\3\2"+
		"\2\2\u01b3\u019d\3\2\2\2\u01b3\u019e\3\2\2\2\u01b3\u019f\3\2\2\2\u01b3"+
		"\u01a0\3\2\2\2\u01b3\u01a1\3\2\2\2\u01b3\u01a2\3\2\2\2\u01b3\u01a3\3\2"+
		"\2\2\u01b3\u01a4\3\2\2\2\u01b3\u01a5\3\2\2\2\u01b3\u01a6\3\2\2\2\u01b3"+
		"\u01a7\3\2\2\2\u01b3\u01a8\3\2\2\2\u01b3\u01a9\3\2\2\2\u01b3\u01aa\3\2"+
		"\2\2\u01b3\u01ab\3\2\2\2\u01b3\u01ac\3\2\2\2\u01b3\u01ad\3\2\2\2\u01b3"+
		"\u01ae\3\2\2\2\u01b3\u01af\3\2\2\2\u01b3\u01b0\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b3\u01b2\3\2\2\2\u01b4A\3\2\2\2\u01b5\u01b6\7}\2\2\u01b6C\3\2"+
		"\2\2\u01b7\u01b8\t\7\2\2\u01b8E\3\2\2\2\u01b9\u01ba\t\b\2\2\u01baG\3\2"+
		"\2\2/JQW[`for{}\u0080\u0085\u008a\u0094\u009e\u00c9\u00df\u00e1\u00e4"+
		"\u00e9\u00ee\u00f8\u00fb\u00ff\u0104\u0108\u010c\u0110\u011b\u0120\u0126"+
		"\u012d\u0132\u0138\u013d\u0143\u014e\u0152\u0156\u0160\u0169\u016e\u0171"+
		"\u0174\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}