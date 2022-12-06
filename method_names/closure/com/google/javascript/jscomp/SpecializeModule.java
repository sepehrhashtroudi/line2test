public SpecializeModule(AbstractCompiler compiler, PassFactory... specializationPassFactories)
public OriginalFunctionInformation(Node originalFunction)
public SpecializationState(SimpleFunctionAliasAnalysis initialModuleAliasAnalysis)
public void process(Node externs, Node root)
private Collection<SpecializationAwareCompilerPass> createSpecializingPasses()
private Node copyModuleInputs(JSModule module)
public void reportMatch(Node original, Node specialized)
public boolean shouldTraverse(Node n1, Node n2)
private void matchTopLevelFunctions(Node original, Node toBeSpecialized)
private void replaceOriginalModuleInputsWithSpecialized()
private void addDummyVarDeclarationsToInitialModule(JSModule module)
private void addOriginalFunctionVersionsToDependentModules(JSModule module)
public Collection<JSModule> getDirectDependents(JSModule module)
public void match(Node ast1, Node ast2)
public abstract void reportMatch(Node n1, Node n2)
public boolean shouldTraverse(Node node1, Node n2)
private Node copiedOriginalFunction()
private boolean originalWasDeclaration()
private Node generateFixupDefinition()
private Node generateDummyDeclaration()
private boolean hasChanged()
private void resetHasChanged()
public Set<Node> getSpecializedFunctions()
public void reportSpecializedFunction(Node functionNode)
public void reportSpecializedFunctionContainingNode(Node node)
public Set<Node> getRemovedFunctions()
public void reportRemovedFunction(Node functionNode, Node declaringBlock)
public boolean canFixupFunction(Node functionNode)
public boolean canFixupSpecializedFunctionContainingNode(Node n)
private boolean nodeIsInGlobalScope(Node node)
private Node containingFunction(Node node)