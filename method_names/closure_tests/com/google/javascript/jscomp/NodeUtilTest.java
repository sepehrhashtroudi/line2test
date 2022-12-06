private static Node parse(String js)
 static Node getNode(String js)
public void testIsLiteralOrConstValue()
public void assertLiteralAndImmutable(Node n)
public void assertLiteralButNotImmutable(Node n)
public void assertNotLiteral(Node n)
public void testGetBooleanValue()
private void assertPureBooleanTrue(String val)
private void assertPureBooleanFalse(String val)
private void assertPureBooleanUnknown(String val)
public void testGetExpressionBooleanValue()
private void assertImpureBooleanTrue(String val)
private void assertImpureBooleanFalse(String val)
private void assertImpureBooleanUnknown(String val)
public void testGetStringValue()
public void testGetArrayStringValue()
public void testIsObjectLiteralKey1() throws Exception
private Node parseExpr(String js)
private void testIsObjectLiteralKey(Node node, boolean expected)
public void testGetFunctionName1() throws Exception
public void testGetFunctionName2() throws Exception
public void testGetFunctionName3() throws Exception
public void testGetFunctionName4() throws Exception
public void testGetFunctionName5() throws Exception
private void testGetFunctionName(Node function, String name)
public void testContainsFunctionDeclaration()
private void assertSideEffect(boolean se, String js)
private void assertSideEffect(boolean se, String js, boolean globalRegExp)
public void testMayHaveSideEffects()
public void testObjectMethodSideEffects()
public void testRegExpSideEffect()
private void assertMutableState(boolean se, String js)
public void testMayEffectMutableState()
public void testIsFunctionExpression()
private void assertContainsAnonFunc(boolean expected, String js)
private Node findParentOfFuncDescendant(Node n)
private Node getFuncChild(Node n)
public void testContainsType()
public void testReferencesThis()
public void testGetNodeTypeReferenceCount()
public void testIsNameReferenceCount()
public void testGetNameReferenceCount()
public void testGetVarsDeclaredInBranch()
private void assertNodeNames(Set<String> nodeNames, Collection<Node> nodes)
public void testIsControlStructureCodeBlock()
public void testIsFunctionExpression1()
public void testIsFunctionExpression2()
public void testRemoveChildBlock()
public void testRemoveTryChild1()
public void testRemoveTryChild2()
public void testRemoveTryChild3()
public void testRemoveTryChild4()
public void testRemoveTryChild5()
public void testRemoveVarChild()
public void testRemoveLabelChild1()
public void testRemoveLabelChild2()
public void testRemoveForChild()
public void testMergeBlock1()
public void testMergeBlock2()
public void testMergeBlock3()
public void testGetSourceName()
public void testLocalValue1() throws Exception
public void testLocalValue2()
public void testCallSideEffects()
private boolean testLocalValue(String js)
public void testValidDefine()
private boolean testValidDefineValue(String js)
public void testGetNumberValue()
public void testIsNumbericResult()
public void testIsBooleanResult()
public void testMayBeString()
public void testValidNames()
public void testGetNearestFunctionName()
public void testGetBestLValue()
public void testIsNaN()
public void testIsExecutedExactlyOnce()
private boolean executedOnceTestCase(String code)
private String getFunctionLValue(String js)
 static void testFunctionName(String js, String expected)
 static Node getFunctionNode(String js)
 static Node getFunctionNode(Node n)
 static Node getNameNode(Node n, String name)