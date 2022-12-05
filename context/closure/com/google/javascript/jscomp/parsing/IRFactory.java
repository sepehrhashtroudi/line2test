private IRFactory(String sourceString, StaticSourceFile sourceFile, Config config, ErrorReporter errorReporter)
private Node createTemplateNode()
public static Node transformTree(AstRoot node, StaticSourceFile sourceFile, String sourceString, Config config, ErrorReporter errorReporter)
private void setFileOverviewJsDoc(Node irNode)
private Node transformBlock(AstNode node)
private void handleBlockComment(Comment comment)
private boolean handlePossibleFileOverviewJsDoc(JsDocInfoParser jsDocParser)
private void handlePossibleFileOverviewJsDoc(Comment comment, Node irNode)
private JSDocInfo handleJsDoc(AstNode node, Node irNode)
private void validateTypeAnnotations(JSDocInfo info, AstNode node, Node irNode)
private boolean isPropAccess(AstNode node)
private boolean isExprStmt(AstNode node)
private Node transform(AstNode node)
private Node maybeInjectCastNode(AstNode node, JSDocInfo info, Node irNode)
private Node transformNameAsString(Name node)
private Node transformNumberAsString(NumberLiteral literalNode)
private static String getStringValue(double value)
private void setSourceInfo(Node irNode, AstNode node)
private JsDocInfoParser createJsDocInfoParser(Comment node, Node irNode)
private void maybeSetLengthFrom(Node node, AstNode source)
private int position2charno(int position)
private Node justTransform(AstNode node)
private Node processGeneric(com.google.javascript.rhino.head.Node n)
private Node transformAsString(AstNode n)
 Node processArrayLiteral(ArrayLiteral literalNode)
 Node processAssignment(Assignment assignmentNode)
 Node processAstRoot(AstRoot rootNode)
private void parseDirectives(Node node)
private boolean isDirective(Node n)
 Node processBlock(Block blockNode)
 Node processBreakStatement(BreakStatement statementNode)
 Node processCatchClause(CatchClause clauseNode)
 Node processConditionalExpression(ConditionalExpression exprNode)
 Node processContinueStatement(ContinueStatement statementNode)
 Node processDoLoop(DoLoop loopNode)
 Node processElementGet(ElementGet getNode)
 Node processEmptyExpression(EmptyExpression exprNode)
 Node processEmptyStatement(EmptyStatement exprNode)
 Node processExpressionStatement(ExpressionStatement statementNode)
 Node processForInLoop(ForInLoop loopNode)
 Node processForLoop(ForLoop loopNode)
 Node processFunctionCall(FunctionCall callNode)
 Node processFunctionNode(FunctionNode functionNode)
 Node processIfStatement(IfStatement statementNode)
 Node processInfixExpression(InfixExpression exprNode)
 Node processKeywordLiteral(KeywordLiteral literalNode)
 Node processLabel(Label labelNode)
 Node processLabeledStatement(LabeledStatement statementNode)
 Node processName(Name nameNode)
 Node processName(Name nameNode, boolean asString)
private boolean isReservedKeyword(String identifier)
 Node processNewExpression(NewExpression exprNode)
 Node processNumberLiteral(NumberLiteral literalNode)
 Node processObjectLiteral(ObjectLiteral literalNode)
 Node getFnParamNode(Node fnNode)
 Node processObjectProperty(ObjectProperty propertyNode)
 Node processParenthesizedExpression(ParenthesizedExpression exprNode)
 Node processPropertyGet(PropertyGet getNode)
 Node processRegExpLiteral(RegExpLiteral literalNode)
 Node processReturnStatement(ReturnStatement statementNode)
 Node processScope(Scope scopeNode)
 Node processStringLiteral(StringLiteral literalNode)
 Node processSwitchCase(SwitchCase caseNode)
 Node processSwitchStatement(SwitchStatement statementNode)
 Node processThrowStatement(ThrowStatement statementNode)
 Node processTryStatement(TryStatement statementNode)
 Node processUnaryExpression(UnaryExpression exprNode)
private boolean validAssignmentTarget(Node target)
 Node processVariableDeclaration(VariableDeclaration declarationNode)
 Node processVariableInitializer(VariableInitializer initializerNode)
 Node processWhileLoop(WhileLoop loopNode)
 Node processWithStatement(WithStatement statementNode)
 Node processIllegalToken(AstNode node)
 void reportDestructuringAssign(AstNode node)
 void reportGetter(AstNode node)
 void reportSetter(AstNode node)
 void reportGetterParam(AstNode node)
 void reportSetterParam(AstNode node)
private static int transformTokenType(int token)
private Node newNode(int type)
private Node newNode(int type, Node child1)
private Node newNode(int type, Node child1, Node child2)
private Node newNode(int type, Node child1, Node child2, Node child3)
private Node newStringNode(String value)
private Node newStringNode(int type, String value)
private Node newNumberNode(Double value)
String GETTER_ERROR_MESSAGE=Optional["getters are not supported in older versions of JS. " + "If you are targeting newer versions of JS, " + "set the appropriate language_in option."]
String SETTER_ERROR_MESSAGE=Optional["setters are not supported in older versions of JS. " + "If you are targeting newer versions of JS, " + "set the appropriate language_in option."]
String SUSPICIOUS_COMMENT_WARNING=Optional["Non-JSDoc comment has annotations. " + "Did you mean to start it with '/**'?"]
String MISPLACED_TYPE_ANNOTATION=Optional["Type annotations are not allowed here. Are you missing parentheses?"]
String sourceString
StaticSourceFile sourceFile
String sourceName
Config config
ErrorReporter errorReporter
TransformDispatcher transformDispatcher
ImmutableSet<String> ALLOWED_DIRECTIVES=Optional[ImmutableSet.of("use strict")]
ImmutableSet<String> ES5_RESERVED_KEYWORDS=Optional[ImmutableSet.of(// From Section 7.6.1.2
"class", "const", "enum", "export", "extends", "import", "super")]
ImmutableSet<String> ES5_STRICT_RESERVED_KEYWORDS=Optional[ImmutableSet.of(// From Section 7.6.1.2
"class", "const", "enum", "export", "extends", "import", "super", "implements", "interface", "let", "package", "private", "protected", "public", "static", "yield")]
Set<String> reservedKeywords
Set<Comment> parsedComments=Optional[Sets.newHashSet()]
Node rootNodeJsDocHolder=Optional[new Node(Token.SCRIPT)]
Node.FileLevelJsDocBuilder fileLevelJsDocBuilder=Optional[rootNodeJsDocHolder.getJsDocBuilderForNode()]
JSDocInfo fileOverviewInfo=Optional[null]
Node templateNode
