public void testVarAndOptionalParams() { [EOL]     Node args = new Node(Token.PARAM_LIST, Node.newString(Token.NAME, "a"), Node.newString(Token.NAME, "b")); [EOL]     Node optArgs = new Node(Token.PARAM_LIST, Node.newString(Token.NAME, "opt_a"), Node.newString(Token.NAME, "opt_b")); [EOL]     assertFalse(conv.isVarArgsParameter(args.getFirstChild())); [EOL]     assertTrue(conv.isVarArgsParameter(args.getLastChild())); [EOL]     assertFalse(conv.isVarArgsParameter(optArgs.getFirstChild())); [EOL]     assertTrue(conv.isVarArgsParameter(optArgs.getLastChild())); [EOL]     assertTrue(conv.isOptionalParameter(args.getFirstChild())); [EOL]     assertFalse(conv.isOptionalParameter(args.getLastChild())); [EOL]     assertTrue(conv.isOptionalParameter(optArgs.getFirstChild())); [EOL]     assertFalse(conv.isOptionalParameter(optArgs.getLastChild())); [EOL] } <line_num>: 30,47
public void testInlineName() { [EOL]     assertFalse(conv.isConstant("a")); [EOL]     assertFalse(conv.isConstant("XYZ123_")); [EOL]     assertFalse(conv.isConstant("ABC")); [EOL]     assertFalse(conv.isConstant("ABCdef")); [EOL]     assertFalse(conv.isConstant("aBC")); [EOL]     assertFalse(conv.isConstant("A")); [EOL]     assertFalse(conv.isConstant("_XYZ123")); [EOL]     assertFalse(conv.isConstant("a$b$XYZ123_")); [EOL]     assertFalse(conv.isConstant("a$b$ABC_DEF")); [EOL]     assertFalse(conv.isConstant("a$b$A")); [EOL]     assertFalse(conv.isConstant("a$b$a")); [EOL]     assertFalse(conv.isConstant("a$b$ABCdef")); [EOL]     assertFalse(conv.isConstant("a$b$aBC")); [EOL]     assertFalse(conv.isConstant("a$b$")); [EOL]     assertFalse(conv.isConstant("$")); [EOL] } <line_num>: 49,65
public void testExportedName() { [EOL]     assertFalse(conv.isExported("_a")); [EOL]     assertFalse(conv.isExported("_a_")); [EOL]     assertFalse(conv.isExported("a")); [EOL]     assertFalse(conv.isExported("$super", false)); [EOL]     assertTrue(conv.isExported("$super", true)); [EOL]     assertTrue(conv.isExported("$super")); [EOL] } <line_num>: 67,75
public void testPrivateName() { [EOL]     assertFalse(conv.isPrivate("a_")); [EOL]     assertFalse(conv.isPrivate("a")); [EOL]     assertFalse(conv.isPrivate("_a_")); [EOL] } <line_num>: 77,81
public void testEnumKey() { [EOL]     assertTrue(conv.isValidEnumKey("A")); [EOL]     assertTrue(conv.isValidEnumKey("123")); [EOL]     assertTrue(conv.isValidEnumKey("FOO_BAR")); [EOL]     assertTrue(conv.isValidEnumKey("a")); [EOL]     assertTrue(conv.isValidEnumKey("someKeyInCamelCase")); [EOL]     assertTrue(conv.isValidEnumKey("_FOO_BAR")); [EOL] } <line_num>: 83,91
public void testInheritanceDetection1() { [EOL]     assertNotClassDefining("goog.foo(A, B);"); [EOL] } <line_num>: 93,95
public void testInheritanceDetection2() { [EOL]     assertNotClassDefining("goog.inherits(A, B);"); [EOL] } <line_num>: 97,99
public void testInheritanceDetection3() { [EOL]     assertNotClassDefining("A.inherits(B);"); [EOL] } <line_num>: 101,103
public void testInheritanceDetection4() { [EOL]     assertNotClassDefining("goog.inherits(goog.A, goog.B);"); [EOL] } <line_num>: 105,107
public void testInheritanceDetection5() { [EOL]     assertNotClassDefining("goog.A.inherits(goog.B);"); [EOL] } <line_num>: 109,111
public void testInheritanceDetection6() { [EOL]     assertNotClassDefining("A.inherits(this.B);"); [EOL] } <line_num>: 113,115
public void testInheritanceDetection7() { [EOL]     assertNotClassDefining("this.A.inherits(B);"); [EOL] } <line_num>: 117,119
public void testInheritanceDetection8() { [EOL]     assertNotClassDefining("goog.inherits(A, B, C);"); [EOL] } <line_num>: 121,123
public void testInheritanceDetection9() { [EOL]     assertNotClassDefining("A.mixin(B.prototype);"); [EOL] } <line_num>: 125,127
public void testInheritanceDetection10() { [EOL]     assertNotClassDefining("goog.mixin(A.prototype, B.prototype);"); [EOL] } <line_num>: 129,131
public void testInheritanceDetectionPostCollapseProperties() { [EOL]     assertNotClassDefining("goog$inherits(A, B);"); [EOL]     assertNotClassDefining("goog$inherits(A);"); [EOL] } <line_num>: 133,136
public void testFunctionBind() { [EOL]     assertNotFunctionBind("goog.bind(f)"); [EOL]     assertNotFunctionBind("goog$bind(f)"); [EOL]     assertNotFunctionBind("goog.partial(f)"); [EOL]     assertNotFunctionBind("goog$partial(f)"); [EOL]     assertFunctionBind("(function(){}).bind()"); [EOL]     assertFunctionBind("(function(){}).bind(obj)"); [EOL]     assertFunctionBind("(function(){}).bind(obj, p1)"); [EOL]     assertNotFunctionBind("Function.prototype.bind.call()"); [EOL]     assertFunctionBind("Function.prototype.bind.call(obj)"); [EOL]     assertFunctionBind("Function.prototype.bind.call(obj, p1)"); [EOL] } <line_num>: 138,151
private void assertFunctionBind(String code) { [EOL]     Node n = parseTestCode(code); [EOL]     assertNotNull(conv.describeFunctionBind(n.getFirstChild())); [EOL] } <line_num>: 153,156
private void assertNotFunctionBind(String code) { [EOL]     Node n = parseTestCode(code); [EOL]     assertNull(conv.describeFunctionBind(n.getFirstChild())); [EOL] } <line_num>: 158,161
private void assertNotClassDefining(String code) { [EOL]     Node n = parseTestCode(code); [EOL]     assertNull(conv.getClassesDefinedByCall(n.getFirstChild())); [EOL] } <line_num>: 163,166
private Node parseTestCode(String code) { [EOL]     Compiler compiler = new Compiler(); [EOL]     return compiler.parseTestCode(code).getFirstChild(); [EOL] } <line_num>: 168,171