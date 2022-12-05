public void testFunction() { [EOL]     String g = "function g(){}"; [EOL]     String fAndG = "function f(){" + g + "}"; [EOL]     String js = "var h=" + fAndG + ";h()"; [EOL]     FunctionInformationMap.Builder expected = FunctionInformationMap.newBuilder(); [EOL]     expected.addEntry(FunctionInformationMap.Entry.newBuilder().setId(0).setSourceName("testcode").setLineNumber(1).setModuleName("").setSize(g.length()).setName("f::g").setCompiledSource(g).build()); [EOL]     expected.addEntry(FunctionInformationMap.Entry.newBuilder().setId(1).setSourceName("testcode").setLineNumber(1).setModuleName("").setSize(fAndG.length()).setName("f").setCompiledSource(fAndG).build()); [EOL]     expected.addModule(FunctionInformationMap.Module.newBuilder().setName("").setCompiledSource(js + ";").build()); [EOL]     test(js, expected.build()); [EOL] } <line_num>: 31,62
public void testModule() { [EOL]     String g = "function g(){}"; [EOL]     String fAndG = "function f(){" + g + "}"; [EOL]     String m0_js = "var h=" + fAndG + ";h()"; [EOL]     String sum = "function(a,b){return a+b}"; [EOL]     String m1_js = "var x=" + sum + "(1,2)"; [EOL]     FunctionInformationMap.Builder expected = FunctionInformationMap.newBuilder(); [EOL]     expected.addEntry(FunctionInformationMap.Entry.newBuilder().setId(0).setSourceName("i0").setLineNumber(1).setModuleName("m0").setSize(g.length()).setName("f::g").setCompiledSource(g).build()); [EOL]     expected.addEntry(FunctionInformationMap.Entry.newBuilder().setId(1).setSourceName("i0").setLineNumber(1).setModuleName("m0").setSize(fAndG.length()).setName("f").setCompiledSource(fAndG).build()); [EOL]     expected.addEntry(FunctionInformationMap.Entry.newBuilder().setId(2).setSourceName("i1").setLineNumber(1).setModuleName("m1").setSize(sum.length()).setName("<anonymous>").setCompiledSource(sum).build()); [EOL]     expected.addModule(FunctionInformationMap.Module.newBuilder().setName("m0").setCompiledSource(m0_js + ";").build()); [EOL]     expected.addModule(FunctionInformationMap.Module.newBuilder().setName("m1").setCompiledSource(m1_js + ";").build()); [EOL]     test(CompilerTestCase.createModules(m0_js, m1_js), expected.build()); [EOL] } <line_num>: 64,110
public void testMotionPreservesOriginalSourceName() { [EOL]     String f = "function f(){}"; [EOL]     String g = "function g(){}"; [EOL]     String m0_before = f + g; [EOL]     String m1_before = ""; [EOL]     JSModule[] modules = CompilerTestCase.createModules(m0_before, m1_before); [EOL]     Compiler compiler = compilerFor(modules); [EOL]     Node root = root(compiler); [EOL]     Node externsRoot = externs(root); [EOL]     Node mainRoot = main(root); [EOL]     String m0_after = f; [EOL]     String m1_after = g; [EOL]     Node nodeG = mainRoot.getFirstChild().getLastChild(); [EOL]     mainRoot.getFirstChild().removeChild(nodeG); [EOL]     mainRoot.getLastChild().addChildrenToBack(nodeG.cloneTree()); [EOL]     FunctionInformationMap.Builder expected = FunctionInformationMap.newBuilder(); [EOL]     expected.addEntry(FunctionInformationMap.Entry.newBuilder().setId(0).setSourceName("i0").setLineNumber(1).setModuleName("m0").setSize(g.length()).setName("f").setCompiledSource(f).build()); [EOL]     expected.addEntry(FunctionInformationMap.Entry.newBuilder().setId(1).setSourceName("i0").setLineNumber(1).setModuleName("m1").setSize(g.length()).setName("g").setCompiledSource(g).build()); [EOL]     expected.addModule(FunctionInformationMap.Module.newBuilder().setName("m0").setCompiledSource(m0_after + ";").build()); [EOL]     expected.addModule(FunctionInformationMap.Module.newBuilder().setName("m1").setCompiledSource(m1_after + ";").build()); [EOL]     test(compiler, externsRoot, mainRoot, expected.build()); [EOL] } <line_num>: 112,161
private void test(String js, FunctionInformationMap expected) { [EOL]     Compiler compiler = new Compiler(); [EOL]     compiler.init(ImmutableList.of(SourceFile.fromCode("externs", "")), ImmutableList.of(SourceFile.fromCode("testcode", js)), new CompilerOptions()); [EOL]     test(compiler, expected); [EOL] } <line_num>: 164,170
private void test(JSModule[] modules, FunctionInformationMap expected) { [EOL]     test(compilerFor(modules), expected); [EOL] } <line_num>: 172,174
private void test(Compiler compiler, FunctionInformationMap expected) { [EOL]     Node root = root(compiler); [EOL]     test(compiler, externs(root), main(root), expected); [EOL] } <line_num>: 176,179
private void test(Compiler compiler, Node externsRoot, Node mainRoot, FunctionInformationMap expected) { [EOL]     FunctionNames functionNames = new FunctionNames(compiler); [EOL]     functionNames.process(externsRoot, mainRoot); [EOL]     RecordFunctionInformation processor = new RecordFunctionInformation(compiler, functionNames); [EOL]     processor.process(externsRoot, mainRoot); [EOL]     FunctionInformationMap result = processor.getMap(); [EOL]     assertEquals(expected, result); [EOL] } <line_num>: 181,191
private Compiler compilerFor(JSModule[] modules) { [EOL]     Compiler compiler = new Compiler(); [EOL]     compiler.initModules(ImmutableList.of(SourceFile.fromCode("externs", "")), Lists.newArrayList(modules), new CompilerOptions()); [EOL]     return compiler; [EOL] } <line_num>: 193,200
private Node root(Compiler compiler) { [EOL]     return compiler.parseInputs(); [EOL] } <line_num>: 202,204
private Node externs(Node root) { [EOL]     return root.getFirstChild(); [EOL] } <line_num>: 206,208
private Node main(Node root) { [EOL]     return root.getFirstChild().getNext(); [EOL] } <line_num>: 210,212
