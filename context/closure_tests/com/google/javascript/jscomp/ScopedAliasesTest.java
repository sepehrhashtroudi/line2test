public ScopedAliasesTest()
public TypeVerifyingPass(Compiler compiler)
private void testScoped(String code, String expected)
private void testScopedNoChanges(String aliases, String code)
public void testOneLevel()
public void testTwoLevel()
public void testTransitive()
public void testTransitiveInSameVar()
public void testMultipleTransitive()
public void testFourLevel()
public void testWorksInClosures()
public void testOverridden()
public void testTwoScopes()
public void testTwoSymbolsInTwoScopes()
public void testAliasOfSymbolInGoogScope()
public void testScopedFunctionReturnThis()
public void testScopedFunctionAssignsToVar()
public void testScopedFunctionThrows()
public void testPropertiesNotChanged()
public void testShadowedVar()
public void testShadowedScopedVar()
public void testShadowedScopedVarTwoScopes()
public void testUsingObjectLiteralToEscapeScoping()
private void testTypes(String aliases, String code)
private void verifyTypes()
public void testJsDocType()
public void testJsDocParameter()
public void testJsDocExtends()
public void testJsDocImplements()
public void testJsDocEnum()
public void testJsDocReturn()
public void testJsDocThis()
public void testJsDocThrows()
public void testJsDocSubType()
public void testJsDocTypedef()
public void testArrayJsDoc()
public void testObjectJsDoc()
public void testUnionJsDoc()
public void testFunctionJsDoc()
public void testForwardJsDoc()
public void testTestTypes()
public void testNullType()
public void testIssue772()
private void testFailure(String code, DiagnosticType expectedError)
private void testScopedFailure(String code, DiagnosticType expectedError)
public void testScopedThis()
public void testAliasRedefinition()
public void testAliasNonRedefinition()
public void testScopedReturn()
public void testScopedThrow()
public void testUsedImproperly()
public void testBadParameters()
public void testNonAliasLocal()
public void testNoGoogScope()
public void testRecordOneAlias()
public void testRecordMultipleAliases()
public void testRecordAliasFromMultipleGoogScope()
private void verifyAliasTransformationPosition(int startLine, int startChar, int endLine, int endChar, SourcePosition<AliasTransformation> pos)
protected ScopedAliases getProcessor(Compiler compiler)
public AliasTransformation logAliasTransformation(String sourceFile, SourcePosition<AliasTransformation> position)
public void addAlias(String alias, String definition)
public void process(Node externs, Node root)
public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
public void visit(NodeTraversal t, Node n, Node parent)
String GOOG_SCOPE_START_BLOCK=Optional["goog.scope(function() {"]
String GOOG_SCOPE_END_BLOCK=Optional["});"]
String EXTERNS=Optional["var window;"]
AliasTransformationHandler transformationHandler=Optional[CompilerOptions.NULL_ALIAS_TRANSFORMATION_HANDLER]