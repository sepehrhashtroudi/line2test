public void testMemoization() throws Exception { [EOL]     Node trueNode = new Node(Token.TRUE); [EOL]     Node falseNode = new Node(Token.FALSE); [EOL]     Compiler compiler = new Compiler(); [EOL]     compiler.initOptions(new CompilerOptions()); [EOL]     ScopeCreator creator = new MemoizedScopeCreator(new SyntacticScopeCreator(compiler)); [EOL]     Scope scopeA = creator.createScope(trueNode, null); [EOL]     assertSame(scopeA, creator.createScope(trueNode, null)); [EOL]     assertNotSame(scopeA, creator.createScope(falseNode, null)); [EOL] } <line_num>: 32,44
public void testPreconditionCheck() throws Exception { [EOL]     Compiler compiler = new Compiler(); [EOL]     compiler.initOptions(new CompilerOptions()); [EOL]     Node trueNode = new Node(Token.TRUE); [EOL]     ScopeCreator creator = new MemoizedScopeCreator(new SyntacticScopeCreator(compiler)); [EOL]     Scope scopeA = creator.createScope(trueNode, null); [EOL]     boolean handled = false; [EOL]     try { [EOL]         creator.createScope(trueNode, scopeA); [EOL]     } catch (IllegalStateException e) { [EOL]         handled = true; [EOL]     } [EOL]     assertTrue(handled); [EOL] } <line_num>: 46,61