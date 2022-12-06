public RemoveUnusedPrototypePropertiesTest() { [EOL]     super(EXTERNS); [EOL] } <line_num>: 31,33
@Override [EOL] protected CompilerPass getProcessor(Compiler compiler) { [EOL]     return new RemoveUnusedPrototypeProperties(compiler, canRemoveExterns, anchorUnusedVars); [EOL] } <line_num>: 35,39
@Override [EOL] public void setUp() { [EOL]     anchorUnusedVars = false; [EOL]     canRemoveExterns = false; [EOL] } <line_num>: 41,45
public void testAnalyzePrototypeProperties() { [EOL]     test("function e(){}" + "e.prototype.a = function(){};" + "e.prototype.b = function(){};" + "var x = new e; x.a()", "function e(){}" + "e.prototype.a = function(){};" + "var x = new e; x.a()"); [EOL]     test("function e(){}" + "e.prototype = {a: function(){}, b: function(){}};" + "var x=new e; x.a()", "function e(){}" + "e.prototype = {a: function(){}};" + "var x = new e; x.a()"); [EOL]     test("function e(){}" + "e.prototype.a = function(){};" + "e.prototype.bExtern = function(){};" + "var x = new e;x.a()", "function e(){}" + "e.prototype.a = function(){};" + "e.prototype.bExtern = function(){};" + "var x = new e; x.a()"); [EOL]     test("function e(){}" + "e.prototype = {a: function(){}, bExtern: function(){}};" + "var x = new e; x.a()", "function e(){}" + "e.prototype = {a: function(){}, bExtern: function(){}};" + "var x = new e; x.a()"); [EOL] } <line_num>: 47,81
public void testAliasing1() { [EOL]     test("function e(){}" + "e.prototype.method1 = function(){};" + "e.prototype.method2 = function(){};" + "e.prototype.alias1 = e.prototype.method1;" + "e.prototype.alias2 = e.prototype.method2;" + "var x = new e; x.method1()", "function e(){}" + "e.prototype.method1 = function(){};" + "var x = new e; x.method1()"); [EOL]     test("function e(){}" + "e.prototype.method1 = function(){};" + "e.prototype.method2 = function(){};" + "e.prototype.alias1 = e.prototype.method1;" + "e.prototype.alias2 = e.prototype.method2;" + "var x=new e; x.alias1()", "function e(){}" + "e.prototype.method1 = function(){};" + "e.prototype.alias1 = e.prototype.method1;" + "var x = new e; x.alias1()"); [EOL] } <line_num>: 83,108
public void testAliasing2() { [EOL]     test("function e(){}" + "e.prototype.method1 = function(){};" + "e.prototype.alias1 = e.prototype.method1;" + "(new e).method1()", "function e(){}" + "e.prototype.method1 = function(){};" + "(new e).method1()"); [EOL]     test("function e(){}" + "e.prototype.method1 = function(){};" + "e.prototype.alias1 = e.prototype.method1;" + "(new e).alias1()", "function e(){}" + "e.prototype.method1 = function(){};" + "e.prototype.alias1 = e.prototype.method1;" + "(new e).alias1()"); [EOL] } <line_num>: 110,131
public void testAliasing3() { [EOL]     test("function e(){}" + "e.prototype.method1 = function(){};" + "e.prototype.method2 = function(){};" + "e.prototype['alias1'] = e.prototype.method1;" + "e.prototype['alias2'] = e.prototype.method2;", "function e(){}" + "e.prototype.method1=function(){};" + "e.prototype.method2=function(){};" + "e.prototype[\"alias1\"]=e.prototype.method1;" + "e.prototype[\"alias2\"]=e.prototype.method2;"); [EOL] } <line_num>: 133,146
public void testAliasing4() { [EOL]     test("function e(){}" + "e.prototype['alias1'] = e.prototype.method1 = function(){};" + "e.prototype['alias2'] = e.prototype.method2 = function(){};", "function e(){}" + "e.prototype[\"alias1\"]=e.prototype.method1=function(){};" + "e.prototype[\"alias2\"]=e.prototype.method2=function(){};"); [EOL] } <line_num>: 148,156
public void testAliasing5() { [EOL]     test("function e(){}" + "e.prototype.method1 = function(){this.method2()};" + "e.prototype.method2 = function(){};" + "e.prototype['alias1'] = e.prototype.method1;", "function e(){}" + "e.prototype.method1=function(){this.method2()};" + "e.prototype.method2=function(){};" + "e.prototype[\"alias1\"]=e.prototype.method1;"); [EOL] } <line_num>: 158,170
public void testAliasing6() { [EOL]     test("function e(){}" + "e.prototype.method1 = function(){this.method2()};" + "e.prototype.method2 = function(){};" + "window['alias1'] = e.prototype.method1;", "function e(){}" + "e.prototype.method1=function(){this.method2()};" + "e.prototype.method2=function(){};" + "window['alias1']=e.prototype.method1;"); [EOL] } <line_num>: 172,184
public void testAliasing7() { [EOL]     testSame("function e(){}" + "e.prototype['alias1'] = e.prototype.method1 = " + "function(){this.method2()};" + "e.prototype.method2 = function(){};"); [EOL] } <line_num>: 186,193
public void testStatementRestriction() { [EOL]     test("function e(){}" + "var x = e.prototype.method1 = function(){};" + "var y = new e; x()", "function e(){}" + "var x = e.prototype.method1 = function(){};" + "var y = new e; x()"); [EOL] } <line_num>: 195,202
public void testExportedMethodsByNamingConvention() { [EOL]     String classAndItsMethodAliasedAsExtern = "function Foo() {}" + "Foo.prototype.method = function() {};" + "Foo.prototype.unused = function() {};" + "var _externInstance = new Foo();" + "Foo.prototype._externMethod = Foo.prototype.method"; [EOL]     String compiled = "function Foo(){}" + "Foo.prototype.method = function(){};" + "var _externInstance = new Foo;" + "Foo.prototype._externMethod = Foo.prototype.method"; [EOL]     test(classAndItsMethodAliasedAsExtern, compiled); [EOL] } <line_num>: 204,219
public void testMethodsFromExternsFileNotExported() { [EOL]     canRemoveExterns = true; [EOL]     String classAndItsMethodAliasedAsExtern = "function Foo() {}" + "Foo.prototype.bar_ = function() {};" + "Foo.prototype.unused = function() {};" + "var instance = new Foo;" + "Foo.prototype.bar = Foo.prototype.bar_"; [EOL]     String compiled = "function Foo(){}" + "var instance = new Foo;"; [EOL]     test(classAndItsMethodAliasedAsExtern, compiled); [EOL] } <line_num>: 221,235
public void testExportedMethodsByNamingConventionAlwaysExported() { [EOL]     canRemoveExterns = true; [EOL]     String classAndItsMethodAliasedAsExtern = "function Foo() {}" + "Foo.prototype.method = function() {};" + "Foo.prototype.unused = function() {};" + "var _externInstance = new Foo();" + "Foo.prototype._externMethod = Foo.prototype.method"; [EOL]     String compiled = "function Foo(){}" + "Foo.prototype.method = function(){};" + "var _externInstance = new Foo;" + "Foo.prototype._externMethod = Foo.prototype.method"; [EOL]     test(classAndItsMethodAliasedAsExtern, compiled); [EOL] } <line_num>: 237,253
public void testExternMethodsFromExternsFile() { [EOL]     String classAndItsMethodAliasedAsExtern = "function Foo() {}" + "Foo.prototype.bar_ = function() {};" + "Foo.prototype.unused = function() {};" + "var instance = new Foo;" + "Foo.prototype.bar = Foo.prototype.bar_"; [EOL]     String compiled = "function Foo(){}" + "Foo.prototype.bar_ = function(){};" + "var instance = new Foo;" + "Foo.prototype.bar = Foo.prototype.bar_"; [EOL]     test(classAndItsMethodAliasedAsExtern, compiled); [EOL] } <line_num>: 255,270
public void testPropertyReferenceGraph() { [EOL]     String constructor = "function Foo() {}"; [EOL]     String defA = "Foo.prototype.a = function() { Foo.superClass_.a.call(this); };"; [EOL]     String defB = "Foo.prototype.b = function() { this.a(); };"; [EOL]     String defC = "Foo.prototype.c = function() { " + "Foo.superClass_.c.call(this); this.b(); this.a(); };"; [EOL]     String defD = "Foo.prototype.d = function() { this.c(); };"; [EOL]     String defE = "Foo.prototype.e = function() { this.a(); this.f(); };"; [EOL]     String defF = "Foo.prototype.f = function() { };"; [EOL]     String fullClassDef = constructor + defA + defB + defC + defD + defE + defF; [EOL]     test(fullClassDef, ""); [EOL]     String callA = "(new Foo()).a();"; [EOL]     String callB = "(new Foo()).b();"; [EOL]     String callC = "(new Foo()).c();"; [EOL]     String callD = "(new Foo()).d();"; [EOL]     String callE = "(new Foo()).e();"; [EOL]     String callF = "(new Foo()).f();"; [EOL]     test(fullClassDef + callA, constructor + defA + callA); [EOL]     test(fullClassDef + callB, constructor + defA + defB + callB); [EOL]     test(fullClassDef + callC, constructor + defA + defB + defC + callC); [EOL]     test(fullClassDef + callD, constructor + defA + defB + defC + defD + callD); [EOL]     test(fullClassDef + callE, constructor + defA + defE + defF + callE); [EOL]     test(fullClassDef + callF, constructor + defF + callF); [EOL]     test(fullClassDef + callA + callC, constructor + defA + defB + defC + callA + callC); [EOL]     test(fullClassDef + callB + callC, constructor + defA + defB + defC + callB + callC); [EOL]     test(fullClassDef + callA + callB + callC, constructor + defA + defB + defC + callA + callB + callC); [EOL] } <line_num>: 272,309
public void testPropertiesDefinedWithGetElem() { [EOL]     testSame("function Foo() {} Foo.prototype['elem'] = function() {};"); [EOL]     testSame("function Foo() {} Foo.prototype[1 + 1] = function() {};"); [EOL] } <line_num>: 311,314
public void testNeverRemoveImplicitlyUsedProperties() { [EOL]     testSame("function Foo() {} " + "Foo.prototype.length = 3; " + "Foo.prototype.toString = function() { return 'Foo'; }; " + "Foo.prototype.valueOf = function() { return 'Foo'; }; "); [EOL] } <line_num>: 316,321
public void testPropertyDefinedInBranch() { [EOL]     test("function Foo() {} if (true) Foo.prototype.baz = function() {};", "if (true);"); [EOL]     test("function Foo() {} while (true) Foo.prototype.baz = function() {};", "while (true);"); [EOL]     test("function Foo() {} for (;;) Foo.prototype.baz = function() {};", "for (;;);"); [EOL]     test("function Foo() {} do Foo.prototype.baz = function() {}; while(true);", "do; while(true);"); [EOL] } <line_num>: 323,332
public void testUsingAnonymousObjectsToDefeatRemoval() { [EOL]     String constructor = "function Foo() {}"; [EOL]     String declaration = constructor + "Foo.prototype.baz = 3;"; [EOL]     test(declaration, ""); [EOL]     testSame(declaration + "var x = {}; x.baz = 5;"); [EOL]     testSame(declaration + "var x = {baz: 5};"); [EOL]     test(declaration + "var x = {'baz': 5};", "var x = {'baz': 5};"); [EOL] } <line_num>: 334,342
public void testGlobalFunctionsInGraph() { [EOL]     test("var x = function() { (new Foo).baz(); };" + "var y = function() { x(); };" + "function Foo() {}" + "Foo.prototype.baz = function() { y(); };", ""); [EOL] } <line_num>: 344,351
public void testGlobalFunctionsInGraph2() { [EOL]     testSame("var x = function() { (new Foo).baz(); };" + "var y = function() { x(); };" + "function Foo() { this.baz(); }" + "Foo.prototype.baz = function() { y(); };"); [EOL] } <line_num>: 353,365
public void testGlobalFunctionsInGraph3() { [EOL]     test("var x = function() { (new Foo).baz(); };" + "var y = function() { x(); };" + "function Foo() { this.baz(); }" + "Foo.prototype.baz = function() { x(); };", "var x = function() { (new Foo).baz(); };" + "function Foo() { this.baz(); }" + "Foo.prototype.baz = function() { x(); };"); [EOL] } <line_num>: 367,376
public void testGlobalFunctionsInGraph4() { [EOL]     test("var x = function() { (new Foo).baz(); };" + "var y = function() { x(); };" + "function Foo() { Foo.prototype.baz = function() { y(); }; }", ""); [EOL] } <line_num>: 378,384
public void testGlobalFunctionsInGraph5() { [EOL]     test("function Foo() {}" + "Foo.prototype.methodA = function() {};" + "function x() { (new Foo).methodA(); }" + "Foo.prototype.methodB = function() { x(); };", ""); [EOL]     anchorUnusedVars = true; [EOL]     test("function Foo() {}" + "Foo.prototype.methodA = function() {};" + "function x() { (new Foo).methodA(); }" + "Foo.prototype.methodB = function() { x(); };", "function Foo() {}" + "Foo.prototype.methodA = function() {};" + "function x() { (new Foo).methodA(); }"); [EOL] } <line_num>: 386,404
public void testGlobalFunctionsInGraph6() { [EOL]     testSame("function Foo() {}" + "Foo.prototype.methodA = function() {};" + "function x() { (new Foo).methodA(); }" + "Foo.prototype.methodB = function() { x(); };" + "(new Foo).methodB();"); [EOL] } <line_num>: 406,413
public void testGlobalFunctionsInGraph7() { [EOL]     testSame("function Foo() {}" + "Foo.prototype.methodA = function() {};" + "this.methodA();"); [EOL] } <line_num>: 415,420
public void testGetterBaseline() { [EOL]     anchorUnusedVars = true; [EOL]     test("function Foo() {}" + "Foo.prototype = { " + "  methodA: function() {}," + "  methodB: function() { x(); }" + "};" + "function x() { (new Foo).methodA(); }", "function Foo() {}" + "Foo.prototype = { " + "  methodA: function() {}" + "};" + "function x() { (new Foo).methodA(); }"); [EOL] } <line_num>: 422,437
public void testGetter1() { [EOL]     test("function Foo() {}" + "Foo.prototype = { " + "  get methodA() {}," + "  get methodB() { x(); }" + "};" + "function x() { (new Foo).methodA; }", "function Foo() {}" + "Foo.prototype = {};"); [EOL]     anchorUnusedVars = true; [EOL]     test("function Foo() {}" + "Foo.prototype = { " + "  get methodA() {}," + "  get methodB() { x(); }" + "};" + "function x() { (new Foo).methodA; }", "function Foo() {}" + "Foo.prototype = { " + "  get methodA() {}" + "};" + "function x() { (new Foo).methodA; }"); [EOL] } <line_num>: 439,465
public void testGetter2() { [EOL]     anchorUnusedVars = true; [EOL]     test("function Foo() {}" + "Foo.prototype = { " + "  get methodA() {}," + "  set methodA(a) {}," + "  get methodB() { x(); }," + "  set methodB(a) { x(); }" + "};" + "function x() { (new Foo).methodA; }", "function Foo() {}" + "Foo.prototype = { " + "  get methodA() {}," + "  set methodA(a) {}" + "};" + "function x() { (new Foo).methodA; }"); [EOL] } <line_num>: 467,485
public void testHook1() throws Exception { [EOL]     test("/** @constructor */ function Foo() {}" + "Foo.prototype.method1 = Math.random() ?" + "   function() { this.method2(); } : function() { this.method3(); };" + "Foo.prototype.method2 = function() {};" + "Foo.prototype.method3 = function() {};", ""); [EOL] } <line_num>: 487,495
public void testHook2() throws Exception { [EOL]     testSame("/** @constructor */ function Foo() {}" + "Foo.prototype.method1 = Math.random() ?" + "   function() { this.method2(); } : function() { this.method3(); };" + "Foo.prototype.method2 = function() {};" + "Foo.prototype.method3 = function() {};" + "(new Foo()).method1();"); [EOL] } <line_num>: 497,505