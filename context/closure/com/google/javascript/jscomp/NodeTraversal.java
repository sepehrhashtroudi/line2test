public AbstractNodeTypePruningCallback(Set<Integer> nodeTypes)
public AbstractNodeTypePruningCallback(Set<Integer> nodeTypes, boolean include)
public NodeTraversal(AbstractCompiler compiler, Callback cb)
public NodeTraversal(AbstractCompiler compiler, Callback cb, ScopeCreator scopeCreator)
 boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
 void visit(NodeTraversal t, Node n, Node parent)
 void enterScope(NodeTraversal t)
 void exitScope(NodeTraversal t)
public final boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
public final boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
public void enterScope(NodeTraversal t)
public void exitScope(NodeTraversal t)
public final boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
public final boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
private void throwUnexpectedException(Exception unexpectedException)
private String formatNodeContext(String label, Node n)
public void traverse(Node root)
public void traverseRoots(Node... roots)
public void traverseRoots(List<Node> roots)
private String formatNodePosition(Node n)
 void traverseWithScope(Node root, Scope s)
 void traverseAtScope(Scope s)
protected void traverseInnerNode(Node node, Node parent, Scope refinedScope)
public Compiler getCompiler()
public int getLineNumber()
public String getSourceName()
public CompilerInput getInput()
public JSModule getModule()
public Node getCurrentNode()
public static void traverse(AbstractCompiler compiler, Node root, Callback cb)
public static void traverseRoots(AbstractCompiler compiler, List<Node> roots, Callback cb)
public static void traverseRoots(AbstractCompiler compiler, Callback cb, Node... roots)
private void traverseBranch(Node n, Node parent)
private void traverseFunction(Node n, Node parent)
public Node getEnclosingFunction()
private void pushScope(Node node)
private void pushScope(Scope s)
private void popScope()
public Scope getScope()
public ControlFlowGraph<Node> getControlFlowGraph()
public Node getScopeRoot()
 boolean inGlobalScope()
 int getScopeDepth()
public boolean hasScope()
public void report(Node n, DiagnosticType diagnosticType, String... arguments)
private static String getSourceName(Node n)
 InputId getInputId()
public JSError makeError(Node n, CheckLevel level, DiagnosticType type, String... arguments)
public JSError makeError(Node n, DiagnosticType type, String... arguments)
private String getBestSourceFileName(Node n)
AbstractCompiler compiler
Callback callback
Node curNode
DiagnosticType NODE_TRAVERSAL_ERROR=Optional[DiagnosticType.error("JSC_NODE_TRAVERSAL_ERROR", "{0}")]
Deque<Scope> scopes=Optional[new ArrayDeque<Scope>()]
Deque<Node> scopeRoots=Optional[new ArrayDeque<Node>()]
Deque<ControlFlowGraph<Node>> cfgs=Optional[new LinkedList<ControlFlowGraph<Node>>()]
String sourceName
InputId inputId
ScopeCreator scopeCreator
ScopedCallback scopeCallback
String MISSING_SOURCE=Optional["[source unknown]"]
