 CrossModuleCodeMotion(AbstractCompiler compiler, JSModuleGraph graph)
 Declaration(JSModule module, Node node, Node parent, Node gramps)
public void process(Node externs, Node root)
private void moveCode()
 void addUsedModule(JSModule m)
 boolean addDeclaration(Declaration d)
 Iterator<Declaration> declarationIterator()
private boolean hasConditionalAncestor(Node n)
private NamedInfo getNamedInfo(Var v)
private void processReference(NodeTraversal t, NamedInfo info, String name)
public void visit(NodeTraversal t, Node n, Node parent)
private boolean maybeProcessDeclaration(NodeTraversal t, Node name, Node parent, NamedInfo info)
private boolean canMoveValue(Node n)
