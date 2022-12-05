 TypeInferencePass(AbstractCompiler compiler, ReverseAbstractInterpreter reverseInterpreter, Scope topScope, MemoizedScopeCreator scopeCreator)
public void process(Node externsRoot, Node jsRoot)
 void inferAllScopes(Node node)
 void inferScope(Node n, Scope scope)
public void enterScope(NodeTraversal t)
public void visit(NodeTraversal t, Node n, Node parent)
public void enterScope(NodeTraversal t)
public void visit(NodeTraversal t, Node n, Node parent)
private ControlFlowGraph<Node> computeCfg(Node n)
DiagnosticType DATAFLOW_ERROR=Optional[DiagnosticType.warning("JSC_INTERNAL_ERROR_DATAFLOW", "non-monotonic data-flow analysis")]
AbstractCompiler compiler
ReverseAbstractInterpreter reverseInterpreter
Scope topScope
MemoizedScopeCreator scopeCreator
Map<String, AssertionFunctionSpec> assertionFunctionsMap
