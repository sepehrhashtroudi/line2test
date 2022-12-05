ReferenceCollectingCallback(AbstractCompiler compiler, Behavior behavior) { [EOL]     this(compiler, behavior, Predicates.<Var>alwaysTrue()); [EOL] } <line_num>: 87,89
ReferenceCollectingCallback(AbstractCompiler compiler, Behavior behavior, Predicate<Var> varFilter) { [EOL]     this.compiler = compiler; [EOL]     this.behavior = behavior; [EOL]     this.varFilter = varFilter; [EOL] } <line_num>: 97,102
public ReferenceMapWrapper(Map<Var, ReferenceCollection> referenceMap) { [EOL]     this.referenceMap = referenceMap; [EOL] } <line_num>: 258,260
Reference(Node nameNode, NodeTraversal t, BasicBlock basicBlock) { [EOL]     this(nameNode, basicBlock, t.getScope(), t.getInput().getInputId()); [EOL] } <line_num>: 497,500
private Reference(Node nameNode, BasicBlock basicBlock, Scope scope, InputId inputId) { [EOL]     this.nameNode = nameNode; [EOL]     this.basicBlock = basicBlock; [EOL]     this.scope = scope; [EOL]     this.inputId = inputId; [EOL]     this.sourceFile = nameNode.getStaticSourceFile(); [EOL] } <line_num>: 521,528
BasicBlock(BasicBlock parent, Node root) { [EOL]     this.parent = parent; [EOL]     this.isHoisted = NodeUtil.isHoistedFunctionDeclaration(root); [EOL]     this.isFunction = root.isFunction(); [EOL]     if (root.getParent() != null) { [EOL]         int pType = root.getParent().getType(); [EOL]         this.isLoop = pType == Token.DO || pType == Token.WHILE || pType == Token.FOR; [EOL]     } else { [EOL]         this.isLoop = false; [EOL]     } [EOL] } <line_num>: 665,681
@Override [EOL] public void process(Node externs, Node root) { [EOL]     NodeTraversal.traverseRoots(compiler, Lists.newArrayList(externs, root), this); [EOL] } <line_num>: 108,112
@Override [EOL] public void hotSwapScript(Node scriptRoot, Node originalRoot) { [EOL]     NodeTraversal.traverse(compiler, scriptRoot, this); [EOL] } <line_num>: 117,120
@Override [EOL] public Iterable<Var> getAllSymbols() { [EOL]     return referenceMap.keySet(); [EOL] } <line_num>: 125,128
@Override [EOL] public Scope getScope(Var var) { [EOL]     return var.scope; [EOL] } <line_num>: 130,133
@Override [EOL] public ReferenceCollection getReferences(Var v) { [EOL]     return referenceMap.get(v); [EOL] } <line_num>: 138,141
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (n.isName()) { [EOL]         Var v; [EOL]         if (n.getString().equals("arguments")) { [EOL]             v = t.getScope().getArgumentsVar(); [EOL]         } else { [EOL]             v = t.getScope().getVar(n.getString()); [EOL]         } [EOL]         if (v != null && varFilter.apply(v)) { [EOL]             addReference(t, v, new Reference(n, t, blockStack.peek())); [EOL]         } [EOL]     } [EOL]     if (isBlockBoundary(n, parent)) { [EOL]         blockStack.pop(); [EOL]     } [EOL] } <line_num>: 147,164
@Override [EOL] public void enterScope(NodeTraversal t) { [EOL]     Node n = t.getScope().getRootNode(); [EOL]     BasicBlock parent = blockStack.isEmpty() ? null : blockStack.peek(); [EOL]     blockStack.push(new BasicBlock(parent, n)); [EOL] } <line_num>: 169,174
@Override [EOL] public void exitScope(NodeTraversal t) { [EOL]     blockStack.pop(); [EOL]     if (t.getScope().isGlobal()) { [EOL]         compiler.updateGlobalVarReferences(referenceMap, t.getScopeRoot()); [EOL]         behavior.afterExitScope(t, compiler.getGlobalVarReferences()); [EOL]     } else { [EOL]         behavior.afterExitScope(t, new ReferenceMapWrapper(referenceMap)); [EOL]     } [EOL] } <line_num>: 179,189
@Override [EOL] public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent) { [EOL]     if (isBlockBoundary(n, parent)) { [EOL]         blockStack.push(new BasicBlock(blockStack.peek(), n)); [EOL]     } [EOL]     return true; [EOL] } <line_num>: 194,202
private static boolean isBlockBoundary(Node n, Node parent) { [EOL]     if (parent != null) { [EOL]         switch(parent.getType()) { [EOL]             case Token.DO: [EOL]             case Token.FOR: [EOL]             case Token.TRY: [EOL]             case Token.WHILE: [EOL]             case Token.WITH: [EOL]                 return true; [EOL]             case Token.AND: [EOL]             case Token.HOOK: [EOL]             case Token.IF: [EOL]             case Token.OR: [EOL]                 return n != parent.getFirstChild(); [EOL]         } [EOL]     } [EOL]     return n.isCase(); [EOL] } <line_num>: 207,237
private void addReference(NodeTraversal t, Var v, Reference reference) { [EOL]     ReferenceCollection referenceInfo = referenceMap.get(v); [EOL]     if (referenceInfo == null) { [EOL]         referenceInfo = new ReferenceCollection(); [EOL]         referenceMap.put(v, referenceInfo); [EOL]     } [EOL]     referenceInfo.add(reference, t, v); [EOL] } <line_num>: 239,249
ReferenceCollection getReferences(Var var); <line_num>: 252,252
@Override [EOL] public ReferenceCollection getReferences(Var var) { [EOL]     return referenceMap.get(var); [EOL] } <line_num>: 262,265
void afterExitScope(NodeTraversal t, ReferenceMap referenceMap); <line_num>: 276,276
@Override [EOL] public void afterExitScope(NodeTraversal t, ReferenceMap referenceMap) { [EOL] } <line_num>: 280,281
@Override [EOL] public Iterator<Reference> iterator() { [EOL]     return references.iterator(); [EOL] } <line_num>: 292,295
void add(Reference reference, NodeTraversal t, Var v) { [EOL]     references.add(reference); [EOL] } <line_num>: 297,299
protected boolean isWellDefined() { [EOL]     int size = references.size(); [EOL]     if (size == 0) { [EOL]         return false; [EOL]     } [EOL]     Reference init = getInitializingReference(); [EOL]     if (init == null) { [EOL]         return false; [EOL]     } [EOL]     Preconditions.checkState(references.get(0).isDeclaration()); [EOL]     BasicBlock initBlock = init.getBasicBlock(); [EOL]     for (int i = 1; i < size; i++) { [EOL]         if (!initBlock.provablyExecutesBefore(references.get(i).getBasicBlock())) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 310,333
boolean isEscaped() { [EOL]     Scope scope = null; [EOL]     for (Reference ref : references) { [EOL]         if (scope == null) { [EOL]             scope = ref.scope; [EOL]         } else if (scope != ref.scope) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 338,348
private boolean isInitializingDeclarationAt(int index) { [EOL]     Reference maybeInit = references.get(index); [EOL]     if (maybeInit.isInitializingDeclaration()) { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 357,366
private boolean isInitializingAssignmentAt(int index) { [EOL]     if (index < references.size() && index > 0) { [EOL]         Reference maybeDecl = references.get(index - 1); [EOL]         if (maybeDecl.isVarDeclaration()) { [EOL]             Preconditions.checkState(!maybeDecl.isInitializingDeclaration()); [EOL]             Reference maybeInit = references.get(index); [EOL]             if (maybeInit.isSimpleAssignmentToName()) { [EOL]                 return true; [EOL]             } [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 374,386
Reference getInitializingReference() { [EOL]     if (isInitializingDeclarationAt(0)) { [EOL]         return references.get(0); [EOL]     } else if (isInitializingAssignmentAt(1)) { [EOL]         return references.get(1); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 395,402
Reference getInitializingReferenceForConstants() { [EOL]     int size = references.size(); [EOL]     for (int i = 0; i < size; i++) { [EOL]         if (isInitializingDeclarationAt(i) || isInitializingAssignmentAt(i)) { [EOL]             return references.get(i); [EOL]         } [EOL]     } [EOL]     return null; [EOL] } <line_num>: 407,415
boolean isAssignedOnceInLifetime() { [EOL]     Reference ref = getOneAndOnlyAssignment(); [EOL]     if (ref == null) { [EOL]         return false; [EOL]     } [EOL]     for (BasicBlock block = ref.getBasicBlock(); block != null; block = block.getParent()) { [EOL]         if (block.isFunction) { [EOL]             break; [EOL]         } else if (block.isLoop) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 421,438
private Reference getOneAndOnlyAssignment() { [EOL]     Reference assignment = null; [EOL]     int size = references.size(); [EOL]     for (int i = 0; i < size; i++) { [EOL]         Reference ref = references.get(i); [EOL]         if (ref.isLvalue() || ref.isInitializingDeclaration()) { [EOL]             if (assignment == null) { [EOL]                 assignment = ref; [EOL]             } else { [EOL]                 return null; [EOL]             } [EOL]         } [EOL]     } [EOL]     return assignment; [EOL] } <line_num>: 444,458
boolean isNeverAssigned() { [EOL]     int size = references.size(); [EOL]     for (int i = 0; i < size; i++) { [EOL]         Reference ref = references.get(i); [EOL]         if (ref.isLvalue() || ref.isInitializingDeclaration()) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 463,472
boolean firstReferenceIsAssigningDeclaration() { [EOL]     int size = references.size(); [EOL]     if (size > 0 && references.get(0).isInitializingDeclaration()) { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 474,480
static Reference newBleedingFunction(NodeTraversal t, BasicBlock basicBlock, Node func) { [EOL]     return new Reference(func.getFirstChild(), basicBlock, t.getScope(), t.getInput().getInputId()); [EOL] } <line_num>: 504,508
@VisibleForTesting [EOL] static Reference createRefForTest(CompilerInput input) { [EOL]     return new Reference(new Node(Token.NAME), null, null, input.getInputId()); [EOL] } <line_num>: 515,519
Reference cloneWithNewScope(Scope newScope) { [EOL]     return new Reference(nameNode, basicBlock, newScope, inputId); [EOL] } <line_num>: 533,535
@Override [EOL] public Var getSymbol() { [EOL]     return scope.getVar(nameNode.getString()); [EOL] } <line_num>: 537,540
@Override [EOL] public Node getNode() { [EOL]     return nameNode; [EOL] } <line_num>: 542,545
public InputId getInputId() { [EOL]     return inputId; [EOL] } <line_num>: 547,549
@Override [EOL] public StaticSourceFile getSourceFile() { [EOL]     return sourceFile; [EOL] } <line_num>: 551,554
boolean isDeclaration() { [EOL]     Node parent = getParent(); [EOL]     Node grandparent = parent.getParent(); [EOL]     return DECLARATION_PARENTS.contains(parent.getType()) || parent.isParamList() && grandparent.isFunction(); [EOL] } <line_num>: 556,562
boolean isVarDeclaration() { [EOL]     return getParent().isVar(); [EOL] } <line_num>: 564,566
boolean isHoistedFunction() { [EOL]     return NodeUtil.isHoistedFunctionDeclaration(getParent()); [EOL] } <line_num>: 568,570
boolean isInitializingDeclaration() { [EOL]     return isDeclaration() && !getParent().isVar() || nameNode.getFirstChild() != null; [EOL] } <line_num>: 575,581
Node getAssignedValue() { [EOL]     Node parent = getParent(); [EOL]     return (parent.isFunction()) ? parent : NodeUtil.getAssignedValue(nameNode); [EOL] } <line_num>: 587,591
BasicBlock getBasicBlock() { [EOL]     return basicBlock; [EOL] } <line_num>: 593,595
Node getParent() { [EOL]     return getNode().getParent(); [EOL] } <line_num>: 597,599
Node getGrandparent() { [EOL]     Node parent = getParent(); [EOL]     return parent == null ? null : parent.getParent(); [EOL] } <line_num>: 601,604
private static boolean isLhsOfForInExpression(Node n) { [EOL]     Node parent = n.getParent(); [EOL]     if (parent.isVar()) { [EOL]         return isLhsOfForInExpression(parent); [EOL]     } [EOL]     return NodeUtil.isForIn(parent) && parent.getFirstChild() == n; [EOL] } <line_num>: 606,612
boolean isSimpleAssignmentToName() { [EOL]     Node parent = getParent(); [EOL]     return parent.isAssign() && parent.getFirstChild() == nameNode; [EOL] } <line_num>: 614,618
boolean isLvalue() { [EOL]     Node parent = getParent(); [EOL]     int parentType = parent.getType(); [EOL]     return (parentType == Token.VAR && nameNode.getFirstChild() != null) || parentType == Token.INC || parentType == Token.DEC || (NodeUtil.isAssignmentOp(parent) && parent.getFirstChild() == nameNode) || isLhsOfForInExpression(nameNode); [EOL] } <line_num>: 620,629
Scope getScope() { [EOL]     return scope; [EOL] } <line_num>: 631,633
BasicBlock getParent() { [EOL]     return parent; [EOL] } <line_num>: 683,685
boolean isGlobalScopeBlock() { [EOL]     return getParent() == null; [EOL] } <line_num>: 695,697
boolean provablyExecutesBefore(BasicBlock thatBlock) { [EOL]     BasicBlock currentBlock; [EOL]     for (currentBlock = thatBlock; currentBlock != null && currentBlock != this; currentBlock = currentBlock.getParent()) { [EOL]         if (currentBlock.isHoisted) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     if (currentBlock == this) { [EOL]         return true; [EOL]     } [EOL]     if (isGlobalScopeBlock() && thatBlock.isGlobalScopeBlock()) { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 703,722
