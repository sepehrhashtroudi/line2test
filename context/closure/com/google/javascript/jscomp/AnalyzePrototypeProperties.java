 AnalyzePrototypeProperties(AbstractCompiler compiler, JSModuleGraph moduleGraph, boolean canModifyExterns, boolean anchorUnusedVars)
 GlobalFunction(Node nameNode, Var var, JSModule module)
 AssignmentProperty(Node node, Var rootVar, JSModule module)
 LiteralProperty(Node key, Node value, Node map, Node assign, Var rootVar, JSModule module)
 NameContext(NameInfo name, Scope scope)
 NameInfo(String name)
public void process(Node externRoot, Node root)
public Collection<NameInfo> getAllNameInfo()
private NameInfo getNameInfoForName(String name, SymbolType type)
public void enterScope(NodeTraversal t)
public void exitScope(NodeTraversal t)
public boolean shouldTraverse(NodeTraversal t, Node n, Node parent)
public void visit(NodeTraversal t, Node n, Node parent)
private void addSymbolUse(String name, JSModule module, SymbolType type)
private String processNonFunctionPrototypeAssign(Node n, Node parent)
private boolean isGlobalFunctionDeclaration(NodeTraversal t, Node n)
private boolean isAssignRValue(Node n, Node parent)
private String getPrototypePropertyNameFromRValue(Node rValue)
private boolean processGlobalFunctionDeclaration(NodeTraversal t, Node nameNode, Var v)
private boolean processPrototypeRef(NodeTraversal t, Node ref)
private Var maybeGetVar(NodeTraversal t, Node maybeName)
private void addGlobalUseOfSymbol(String name, JSModule module, SymbolType type)
public void visit(NodeTraversal t, Node n, Node parent)
public boolean traverseEdge(NameInfo start, JSModule edge, NameInfo dest)
 void remove()
 Var getRootVar()
 JSModule getModule()
public Var getRootVar()
public void remove()
public JSModule getModule()
public Node getFunctionNode()
 Node getPrototype()
 Node getValue()
public Var getRootVar()
public void remove()
public Node getPrototype()
public Node getValue()
private Node getAssignNode()
public JSModule getModule()
public Var getRootVar()
public void remove()
public Node getPrototype()
public Node getValue()
public JSModule getModule()
public String toString()
 boolean isReferenced()
 boolean readsClosureVariables()
 boolean markReference(JSModule module)
 JSModule getDeepestCommonModuleRef()
 Deque<Symbol> getDeclarations()
SymbolType PROPERTY=Optional[SymbolType.PROPERTY]
SymbolType VAR=Optional[SymbolType.VAR]
AbstractCompiler compiler
boolean canModifyExterns
boolean anchorUnusedVars
JSModuleGraph moduleGraph
JSModule firstModule
Set<String> IMPLICITLY_USED_PROPERTIES=Optional[ImmutableSet.of("length", "toString", "valueOf")]
LinkedDirectedGraph<NameInfo, JSModule> symbolGraph=Optional[LinkedDirectedGraph.createWithoutAnnotations()]
NameInfo globalNode=Optional[new NameInfo("[global]")]
NameInfo externNode=Optional[new NameInfo("[extern]")]
NameInfo anonymousNode=Optional[new NameInfo("[anonymous]")]
Map<String, NameInfo> propertyNameInfo=Optional[Maps.newHashMap()]
Map<String, NameInfo> varNameInfo=Optional[Maps.newHashMap()]
