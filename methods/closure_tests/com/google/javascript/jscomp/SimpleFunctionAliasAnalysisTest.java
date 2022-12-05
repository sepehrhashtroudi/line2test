FunctionFinder(String target) { [EOL]     this.target = target; [EOL] } <line_num>: 211,213
@Override [EOL] public void process(Node externs, Node root) { [EOL]     SimpleDefinitionFinder finder = new SimpleDefinitionFinder(compiler); [EOL]     finder.process(externs, root); [EOL]     analysis = new SimpleFunctionAliasAnalysis(); [EOL]     analysis.analyze(finder); [EOL]     lastCompiler = compiler; [EOL] } <line_num>: 36,46
@Override [EOL] protected CompilerPass getProcessor(final Compiler compiler) { [EOL]     return new CompilerPass() { [EOL]  [EOL]         @Override [EOL]         public void process(Node externs, Node root) { [EOL]             SimpleDefinitionFinder finder = new SimpleDefinitionFinder(compiler); [EOL]             finder.process(externs, root); [EOL]             analysis = new SimpleFunctionAliasAnalysis(); [EOL]             analysis.analyze(finder); [EOL]             lastCompiler = compiler; [EOL]         } [EOL]     }; [EOL] } <line_num>: 32,48
public void testFunctionGetIsAliased() { [EOL]     String source = "function A(){};\n" + "var ns = {};\n" + "ns.B = function() {};\n" + "var C = function() {}\n" + "var D = function() {}\n" + "var aliasA = A;\n" + "var aliasB = ns.B;\n" + "var aliasC = C;\n" + "D();"; [EOL]     compileAndRun(source); [EOL]     assertFunctionAliased(true, "A"); [EOL]     assertFunctionAliased(true, "ns.B"); [EOL]     assertFunctionAliased(true, "C"); [EOL]     assertFunctionAliased(false, "D"); [EOL]     source = "function A(){};\n" + "var ns = {};\n" + "ns.B = function() {};\n" + "var C = function() {}\n" + "ns.D = function() {}\n" + "var aliasA;\n" + "aliasA = A;\n" + "var aliasB = {};\n" + "aliasB.foo = ns.B;\n" + "var aliasC;\n" + "aliasC = C;\n" + "ns.D();"; [EOL]     compileAndRun(source); [EOL]     assertFunctionAliased(true, "A"); [EOL]     assertFunctionAliased(true, "ns.B"); [EOL]     assertFunctionAliased(true, "C"); [EOL]     assertFunctionAliased(false, "ns.D"); [EOL]     source = "function A(){};\n" + "var ns = {};\n" + "ns.B = function() {};\n" + "var C = function() {}\n" + "function D() {}\n" + "var foo = function(a) {}\n" + "foo(A);\n" + "foo(ns.B)\n" + "foo(C);\n" + "D();"; [EOL]     compileAndRun(source); [EOL]     assertFunctionAliased(true, "A"); [EOL]     assertFunctionAliased(true, "ns.B"); [EOL]     assertFunctionAliased(true, "C"); [EOL]     assertFunctionAliased(false, "D"); [EOL]     source = "function A(){};\n" + "var ns = {};\n" + "ns.B = function() {};\n" + "var C = function() {}\n" + "A();\n" + "ns.B();\n" + "C();\n"; [EOL]     compileAndRun(source); [EOL]     assertFunctionAliased(false, "A"); [EOL]     assertFunctionAliased(false, "ns.B"); [EOL]     assertFunctionAliased(false, "C"); [EOL]     source = "function A(){};\n" + "var ns = {};\n" + "ns.B = function() {};\n" + "var C = function() {}\n" + "A.foo;\n" + "ns.B.prototype;\n" + "C[0];\n"; [EOL]     compileAndRun(source); [EOL]     assertFunctionAliased(false, "A"); [EOL]     assertFunctionAliased(false, "ns.B"); [EOL]     assertFunctionAliased(false, "C"); [EOL] } <line_num>: 50,143
public void testFunctionGetIsExposedToCallOrApply() { [EOL]     String source = "function A(){};\n" + "function B(){};\n" + "function C(){};\n" + "var x;\n" + "A.call(x);\n" + "B.apply(x);\n" + "C();\n"; [EOL]     compileAndRun(source); [EOL]     assertFunctionExposedToCallOrApply(true, "A"); [EOL]     assertFunctionExposedToCallOrApply(true, "B"); [EOL]     assertFunctionExposedToCallOrApply(false, "C"); [EOL]     source = "var ns = {};" + "ns.A = function(){};\n" + "ns.B = function(){};\n" + "ns.C = function(){};\n" + "var x;\n" + "ns.A.call(x);\n" + "ns.B.apply(x);\n" + "ns.C();\n"; [EOL]     compileAndRun(source); [EOL]     assertFunctionExposedToCallOrApply(true, "ns.A"); [EOL]     assertFunctionExposedToCallOrApply(true, "ns.B"); [EOL]     assertFunctionExposedToCallOrApply(false, "ns.C"); [EOL] } <line_num>: 145,177
private void assertFunctionAliased(boolean aliasStatus, String functionName) { [EOL]     Node function = findFunction(functionName); [EOL]     assertEquals(aliasStatus, analysis.isAliased(function)); [EOL] } <line_num>: 179,184
private void assertFunctionExposedToCallOrApply(boolean exposure, String functionName) { [EOL]     Node function = findFunction(functionName); [EOL]     assertEquals(exposure, analysis.isExposedToCallOrApply(function)); [EOL] } <line_num>: 186,191
private void compileAndRun(String source) { [EOL]     testSame(source, source, null); [EOL] } <line_num>: 193,195
private Node findFunction(String name) { [EOL]     FunctionFinder f = new FunctionFinder(name); [EOL]     new NodeTraversal(lastCompiler, f).traverse(lastCompiler.jsRoot); [EOL]     assertNotNull("Couldn't find " + name, f.found); [EOL]     return f.found; [EOL] } <line_num>: 197,202
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (n.isFunction() && target.equals(NodeUtil.getFunctionName(n))) { [EOL]         found = n; [EOL]     } [EOL] } <line_num>: 215,221
