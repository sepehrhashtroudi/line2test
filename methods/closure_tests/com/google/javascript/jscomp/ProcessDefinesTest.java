public ProcessDefinesTest() { [EOL]     super("var externMethod;"); [EOL]     allowSourcelessWarnings(); [EOL] } <line_num>: 33,39
public ProcessDefinesWithInjectedNamespace(Compiler compiler) { [EOL]     this.compiler = compiler; [EOL] } <line_num>: 329,331
@Override [EOL] public void setUp() throws Exception { [EOL]     super.setUp(); [EOL]     overrides.clear(); [EOL] } <line_num>: 44,48
@Override [EOL] protected CompilerPass getProcessor(Compiler compiler) { [EOL]     return new ProcessDefinesWithInjectedNamespace(compiler); [EOL] } <line_num>: 50,53
@Override [EOL] protected int getNumRepetitions() { [EOL]     return 1; [EOL] } <line_num>: 55,60
private void testWithPrefix(String definitions, String js, String expected) { [EOL]     test(definitions + js, definitions + expected); [EOL] } <line_num>: 66,68
public void testBasicDefine1() { [EOL]     test("/** @define {boolean} */ var DEF = true", "var DEF=true"); [EOL] } <line_num>: 70,72
public void testBasicDefine2() { [EOL]     test("/** @define {string} */ var DEF = 'a'", "var DEF=\"a\""); [EOL] } <line_num>: 74,76
public void testBasicDefine3() { [EOL]     test("/** @define {number} */ var DEF = 0", "var DEF=0"); [EOL] } <line_num>: 78,80
public void testDefineBadType() { [EOL]     test("/** @define {Object} */ var DEF = {}", null, ProcessDefines.INVALID_DEFINE_TYPE_ERROR); [EOL] } <line_num>: 82,85
public void testDefineWithBadValue1() { [EOL]     test("/** @define {boolean} */ var DEF = new Boolean(true);", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); [EOL] } <line_num>: 87,90
public void testDefineWithBadValue2() { [EOL]     test("/** @define {string} */ var DEF = 'x' + y;", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); [EOL] } <line_num>: 92,95
public void testDefineWithDependentValue() { [EOL]     test("/** @define {boolean} */ var BASE = false;\n" + "/** @define {boolean} */ var DEF = !BASE;", "var BASE=false;var DEF=!BASE"); [EOL]     test("var a = {};\n" + "/** @define {boolean} */ a.BASE = false;\n" + "/** @define {boolean} */ a.DEF = !a.BASE;", "var a={};a.BASE=false;a.DEF=!a.BASE"); [EOL] } <line_num>: 97,105
public void testDefineWithInvalidDependentValue() { [EOL]     test("var BASE = false;\n" + "/** @define {boolean} */ var DEF = !BASE;", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); [EOL] } <line_num>: 108,113
public void testOverriding1() { [EOL]     overrides.put("DEF_OVERRIDE_TO_TRUE", new Node(Token.TRUE)); [EOL]     overrides.put("DEF_OVERRIDE_TO_FALSE", new Node(Token.FALSE)); [EOL]     test("/** @define {boolean} */ var DEF_OVERRIDE_TO_TRUE = false;" + "/** @define {boolean} */ var DEF_OVERRIDE_TO_FALSE = true", "var DEF_OVERRIDE_TO_TRUE=true;var DEF_OVERRIDE_TO_FALSE=false"); [EOL] } <line_num>: 115,122
public void testOverriding2() { [EOL]     overrides.put("DEF_OVERRIDE_TO_TRUE", new Node(Token.TRUE)); [EOL]     String normalConst = "var DEF_OVERRIDE_TO_FALSE=true;"; [EOL]     testWithPrefix(normalConst, "/** @define {boolean} */ var DEF_OVERRIDE_TO_TRUE = false", "var DEF_OVERRIDE_TO_TRUE=true"); [EOL] } <line_num>: 124,131
public void testOverriding3() { [EOL]     overrides.put("DEF_OVERRIDE_TO_TRUE", new Node(Token.TRUE)); [EOL]     test("/** @define {boolean} */ var DEF_OVERRIDE_TO_TRUE = true;", "var DEF_OVERRIDE_TO_TRUE=true"); [EOL] } <line_num>: 133,138
public void testOverridingString0() { [EOL]     test("/** @define {string} */ var DEF_OVERRIDE_STRING = 'x';", "var DEF_OVERRIDE_STRING=\"x\""); [EOL] } <line_num>: 140,144
public void testOverridingString1() { [EOL]     test("/** @define {string} */ var DEF_OVERRIDE_STRING = 'x' + 'y';", "var DEF_OVERRIDE_STRING=\"x\" + \"y\""); [EOL] } <line_num>: 146,150
public void testOverridingString2() { [EOL]     overrides.put("DEF_OVERRIDE_STRING", Node.newString("foo")); [EOL]     test("/** @define {string} */ var DEF_OVERRIDE_STRING = 'x';", "var DEF_OVERRIDE_STRING=\"foo\""); [EOL] } <line_num>: 152,157
public void testOverridingString3() { [EOL]     overrides.put("DEF_OVERRIDE_STRING", Node.newString("foo")); [EOL]     test("/** @define {string} */ var DEF_OVERRIDE_STRING = 'x' + 'y';", "var DEF_OVERRIDE_STRING=\"foo\""); [EOL] } <line_num>: 159,164
public void testMisspelledOverride() { [EOL]     overrides.put("DEF_BAD_OVERIDE", new Node(Token.TRUE)); [EOL]     test("/** @define {boolean} */ var DEF_BAD_OVERRIDE = true", "var DEF_BAD_OVERRIDE=true", null, ProcessDefines.UNKNOWN_DEFINE_WARNING); [EOL] } <line_num>: 166,171
public void testCompiledIsKnownDefine() { [EOL]     overrides.put("COMPILED", new Node(Token.TRUE)); [EOL]     testSame(""); [EOL] } <line_num>: 173,176
public void testSimpleReassign1() { [EOL]     test("/** @define {boolean} */ var DEF = false; DEF = true;", "var DEF=true;true"); [EOL] } <line_num>: 178,181
public void testSimpleReassign2() { [EOL]     test("/** @define {number|boolean} */ var DEF=false;DEF=true;DEF=3", "var DEF=3;true;3"); [EOL]     Name def = namespace.getNameIndex().get("DEF"); [EOL]     assertEquals(1, def.getRefs().size()); [EOL]     assertEquals(1, def.globalSets); [EOL]     assertNotNull(def.getDeclaration()); [EOL] } <line_num>: 183,191
public void testSimpleReassign3() { [EOL]     test("/** @define {boolean} */ var DEF = false;var x;x = DEF = true;", "var DEF=true;var x;x=true"); [EOL] } <line_num>: 193,196
public void testDuplicateVar() { [EOL]     test("/** @define {boolean} */ var DEF = false; var DEF = true;", null, VAR_MULTIPLY_DECLARED_ERROR); [EOL] } <line_num>: 198,201
public void testAssignBeforeDeclaration1() { [EOL]     test("DEF=false;var b=false,/** @define {boolean} */DEF=true,c=false", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); [EOL] } <line_num>: 203,206
public void testAssignBeforeDeclaration2() { [EOL]     overrides.put("DEF_OVERRIDE_TO_TRUE", new Node(Token.TRUE)); [EOL]     test("DEF_OVERRIDE_TO_TRUE = 3;" + "/** @define {boolean|number} */ var DEF_OVERRIDE_TO_TRUE = false;", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); [EOL] } <line_num>: 208,214
public void testEmptyDeclaration() { [EOL]     test("/** @define {boolean} */ var DEF;", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); [EOL] } <line_num>: 216,219
public void testReassignAfterCall() { [EOL]     test("/** @define {boolean} */var DEF=true;externMethod();DEF=false", null, ProcessDefines.DEFINE_NOT_ASSIGNABLE_ERROR); [EOL] } <line_num>: 221,224
public void testReassignAfterRef() { [EOL]     test("/** @define {boolean} */var DEF=true;var x = DEF;DEF=false", null, ProcessDefines.DEFINE_NOT_ASSIGNABLE_ERROR); [EOL] } <line_num>: 226,229
public void testReassignWithExpr() { [EOL]     test("/** @define {boolean} */var DEF=true;var x;DEF=x=false", null, ProcessDefines.INVALID_DEFINE_INIT_ERROR); [EOL] } <line_num>: 231,234
public void testReassignAfterNonGlobalRef() { [EOL]     test("/** @define {boolean} */var DEF=true;" + "var x=function(){var y=DEF}; DEF=false", "var DEF=false;var x=function(){var y=DEF};false"); [EOL]     Name def = namespace.getNameIndex().get("DEF"); [EOL]     assertEquals(2, def.getRefs().size()); [EOL]     assertEquals(1, def.globalSets); [EOL]     assertNotNull(def.getDeclaration()); [EOL] } <line_num>: 236,246
public void testReassignAfterRefInConditional() { [EOL]     test("/** @define {boolean} */var DEF=true;" + "if (false) {var x=DEF} DEF=false;", null, ProcessDefines.DEFINE_NOT_ASSIGNABLE_ERROR); [EOL] } <line_num>: 248,253
public void testAssignInNonGlobalScope() { [EOL]     test("/** @define {boolean} */var DEF=true;function foo() {DEF=false};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); [EOL] } <line_num>: 255,258
public void testDeclareInNonGlobalScope() { [EOL]     test("function foo() {/** @define {boolean} */var DEF=true;};", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); [EOL] } <line_num>: 260,263
public void testDefineAssignmentInLoop() { [EOL]     test("/** @define {boolean} */var DEF=true;var x=0;while (x) {DEF=false;}", null, ProcessDefines.NON_GLOBAL_DEFINE_INIT_ERROR); [EOL] } <line_num>: 265,268
public void testWithNoDefines() { [EOL]     testSame("var DEF=true;var x={};x.foo={}"); [EOL] } <line_num>: 270,272
public void testNamespacedDefine1() { [EOL]     test("var a = {}; /** @define {boolean} */ a.B = false; a.B = true;", "var a = {}; a.B = true; true;"); [EOL]     Name aDotB = namespace.getNameIndex().get("a.B"); [EOL]     assertEquals(1, aDotB.getRefs().size()); [EOL]     assertEquals(1, aDotB.globalSets); [EOL]     assertNotNull(aDotB.getDeclaration()); [EOL] } <line_num>: 274,282
public void testNamespacedDefine2a() { [EOL]     overrides.put("a.B", new Node(Token.TRUE)); [EOL]     test("var a = {}; /** @define {boolean} */ a.B = false;", "var a = {}; a.B = true;"); [EOL] } <line_num>: 284,288
public void testNamespacedDefine2b() { [EOL]     overrides.put("a.B", new Node(Token.TRUE)); [EOL]     test("var a = { /** @define {boolean} */ B : false };", "var a = {B : false};", null, ProcessDefines.UNKNOWN_DEFINE_WARNING); [EOL] } <line_num>: 290,297
public void testNamespacedDefine2c() { [EOL]     overrides.put("a.B", new Node(Token.TRUE)); [EOL]     test("var a = { /** @define {boolean} */ get B() { return false } };", "var a = {get B() { return false } };", null, ProcessDefines.UNKNOWN_DEFINE_WARNING); [EOL] } <line_num>: 299,306
public void testNamespacedDefine3() { [EOL]     overrides.put("a.B", new Node(Token.TRUE)); [EOL]     test("var a = {};", "var a = {};", null, ProcessDefines.UNKNOWN_DEFINE_WARNING); [EOL] } <line_num>: 308,312
public void testNamespacedDefine4() { [EOL]     overrides.put("a.B", new Node(Token.TRUE)); [EOL]     test("var a = {}; /** @define {boolean} */ a.B = false;", "var a = {}; a.B = true;"); [EOL] } <line_num>: 314,318
public void testOverrideAfterAlias() { [EOL]     test("var x; /** @define {boolean} */var DEF=true; x=DEF; DEF=false;", null, ProcessDefines.DEFINE_NOT_ASSIGNABLE_ERROR); [EOL] } <line_num>: 321,324
@Override [EOL] public void process(Node externs, Node js) { [EOL]     namespace = new GlobalNamespace(compiler, js); [EOL]     new ProcessDefines(compiler, overrides).injectNamespace(namespace).process(externs, js); [EOL] } <line_num>: 333,339