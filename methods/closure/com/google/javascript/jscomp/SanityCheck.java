SanityCheck(AbstractCompiler compiler) { [EOL]     this.compiler = compiler; [EOL] } <line_num>: 45,47
@Override [EOL] public void process(Node externs, Node root) { [EOL]     sanityCheckAst(externs, root); [EOL]     sanityCheckNormalization(externs, root); [EOL]     sanityCheckCodeGeneration(root); [EOL]     sanityCheckVars(externs, root); [EOL] } <line_num>: 49,55
private void sanityCheckAst(Node externs, Node root) { [EOL]     astValidator.validateCodeRoot(externs); [EOL]     astValidator.validateCodeRoot(root); [EOL] } <line_num>: 60,63
private void sanityCheckVars(Node externs, Node root) { [EOL]     if (compiler.getLifeCycleStage().isNormalized()) { [EOL]         (new VarCheck(compiler, true)).process(externs, root); [EOL]     } [EOL] } <line_num>: 65,69
private Node sanityCheckCodeGeneration(Node root) { [EOL]     if (compiler.hasHaltingErrors()) { [EOL]         return null; [EOL]     } [EOL]     String source = compiler.toSource(root); [EOL]     Node root2 = compiler.parseSyntheticCode(source); [EOL]     if (compiler.hasHaltingErrors()) { [EOL]         compiler.report(JSError.make(CANNOT_PARSE_GENERATED_CODE, Strings.truncateAtMaxLength(source, 100, true))); [EOL]         throw new IllegalStateException("Sanity Check failed"); [EOL]     } [EOL]     String source2 = compiler.toSource(root2); [EOL]     if (!source.equals(source2)) { [EOL]         compiler.report(JSError.make(GENERATED_BAD_CODE, source, source2)); [EOL]         throw new IllegalStateException("Sanity Check failed"); [EOL]     } [EOL]     return root2; [EOL] } <line_num>: 78,106
private void sanityCheckNormalization(Node externs, Node root) { [EOL]     CodeChangeHandler handler = new CodeChangeHandler.ForbiddenChange(); [EOL]     compiler.addChangeHandler(handler); [EOL]     new PrepareAst(compiler, true).process(null, root); [EOL]     if (compiler.getLifeCycleStage().isNormalized()) { [EOL]         (new Normalize(compiler, true)).process(externs, root); [EOL]         if (compiler.getLifeCycleStage().isNormalizedUnobfuscated()) { [EOL]             boolean checkUserDeclarations = true; [EOL]             CompilerPass pass = new Normalize.VerifyConstants(compiler, checkUserDeclarations); [EOL]             pass.process(externs, root); [EOL]         } [EOL]     } [EOL]     compiler.removeChangeHandler(handler); [EOL] } <line_num>: 112,134
