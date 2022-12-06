Pattern(int globalOverHead, int perExtractionOverhead, int perMemberOverhead) { [EOL]     this.globalOverhead = globalOverHead; [EOL]     this.perExtractionOverhead = perExtractionOverhead; [EOL]     this.perMemberOverhead = perMemberOverhead; [EOL] } <line_num>: 124,128
ExtractPrototypeMemberDeclarations(AbstractCompiler compiler, Pattern pattern) { [EOL]     this.compiler = compiler; [EOL]     this.pattern = pattern; [EOL] } <line_num>: 131,134
private ExtractionInstance(PrototypeMemberDeclaration head, Node parent) { [EOL]     this.parent = parent; [EOL]     declarations.add(head); [EOL]     delta = pattern.perExtractionOverhead + pattern.perMemberOverhead; [EOL]     for (Node cur = head.node.getNext(); cur != null; cur = cur.getNext()) { [EOL]         if (cur.isFunction()) { [EOL]             continue; [EOL]         } [EOL]         PrototypeMemberDeclaration prototypeMember = PrototypeMemberDeclaration.extractDeclaration(cur); [EOL]         if (prototypeMember == null || !head.isSameClass(prototypeMember)) { [EOL]             break; [EOL]         } [EOL]         declarations.add(prototypeMember); [EOL]         delta += pattern.perMemberOverhead; [EOL]     } [EOL] } <line_num>: 297,320
private PrototypeMemberDeclaration(Node lhs, Node node) { [EOL]     this.lhs = lhs; [EOL]     this.memberName = NodeUtil.getPrototypePropertyName(lhs); [EOL]     this.node = node; [EOL]     this.qualifiedClassName = NodeUtil.getPrototypeClassName(lhs).getQualifiedName(); [EOL] } <line_num>: 342,348
@Override [EOL] public void process(Node externs, Node root) { [EOL]     GatherExtractionInfo extractionInfo = new GatherExtractionInfo(); [EOL]     NodeTraversal.traverse(compiler, root, extractionInfo); [EOL]     if (extractionInfo.shouldExtract()) { [EOL]         doExtraction(extractionInfo); [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL] } <line_num>: 136,144
private void doExtraction(GatherExtractionInfo info) { [EOL]     if (pattern == Pattern.USE_GLOBAL_TEMP) { [EOL]         Node injectionPoint = compiler.getNodeForCodeInsertion(null); [EOL]         Node var = NodeUtil.newVarNode(prototypeAlias, null).copyInformationFromForTree(injectionPoint); [EOL]         injectionPoint.addChildrenToFront(var); [EOL]     } [EOL]     for (ExtractionInstance instance : info.instances) { [EOL]         extractInstance(instance); [EOL]     } [EOL] } <line_num>: 150,165
private void extractInstance(ExtractionInstance instance) { [EOL]     PrototypeMemberDeclaration first = instance.declarations.getFirst(); [EOL]     String className = first.qualifiedClassName; [EOL]     if (pattern == Pattern.USE_GLOBAL_TEMP) { [EOL]         Node stmt = new Node(first.node.getType(), IR.assign(IR.name(prototypeAlias), NodeUtil.newQualifiedNameNode(compiler.getCodingConvention(), className + ".prototype", instance.parent, className + ".prototype"))).copyInformationFromForTree(first.node); [EOL]         instance.parent.addChildBefore(stmt, first.node); [EOL]     } else if (pattern == Pattern.USE_ANON_FUNCTION) { [EOL]         Node block = IR.block(); [EOL]         Node func = IR.function(IR.name(""), IR.paramList(IR.name(prototypeAlias)), block); [EOL]         Node call = IR.call(func, NodeUtil.newQualifiedNameNode(compiler.getCodingConvention(), className + ".prototype", instance.parent, className + ".prototype")); [EOL]         call.putIntProp(Node.FREE_CALL, 1); [EOL]         Node stmt = new Node(first.node.getType(), call); [EOL]         stmt.copyInformationFromForTree(first.node); [EOL]         instance.parent.addChildBefore(stmt, first.node); [EOL]         for (PrototypeMemberDeclaration declar : instance.declarations) { [EOL]             block.addChildToBack(declar.node.detachFromParent()); [EOL]         } [EOL]     } [EOL]     for (PrototypeMemberDeclaration declar : instance.declarations) { [EOL]         replacePrototypeMemberDeclaration(declar); [EOL]     } [EOL] } <line_num>: 172,211
private void replacePrototypeMemberDeclaration(PrototypeMemberDeclaration declar) { [EOL]     Node assignment = declar.node.getFirstChild(); [EOL]     Node lhs = assignment.getFirstChild(); [EOL]     Node name = NodeUtil.newQualifiedNameNode(compiler.getCodingConvention(), prototypeAlias + "." + declar.memberName, declar.node, declar.memberName); [EOL]     Node accessNode = declar.lhs.getFirstChild().getFirstChild(); [EOL]     Object originalName = accessNode.getProp(Node.ORIGINALNAME_PROP); [EOL]     String className = "?"; [EOL]     if (originalName != null) { [EOL]         className = originalName.toString(); [EOL]     } [EOL]     NodeUtil.setDebugInformation(name.getFirstChild(), lhs, className + ".prototype"); [EOL]     assignment.replaceChild(lhs, name); [EOL] } <line_num>: 217,244
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (!n.isScript() && !n.isBlock()) { [EOL]         return; [EOL]     } [EOL]     for (Node cur = n.getFirstChild(); cur != null; cur = cur.getNext()) { [EOL]         PrototypeMemberDeclaration prototypeMember = PrototypeMemberDeclaration.extractDeclaration(cur); [EOL]         if (prototypeMember == null) { [EOL]             continue; [EOL]         } [EOL]         ExtractionInstance instance = new ExtractionInstance(prototypeMember, n); [EOL]         cur = instance.declarations.getLast().node; [EOL]         if (instance.isFavorable()) { [EOL]             instances.add(instance); [EOL]             totalDelta += instance.delta; [EOL]         } [EOL]     } [EOL] } <line_num>: 254,281
private boolean shouldExtract() { [EOL]     return totalDelta < 0; [EOL] } <line_num>: 287,289
boolean isFavorable() { [EOL]     return delta <= 0; [EOL] } <line_num>: 326,328
private boolean isSameClass(PrototypeMemberDeclaration other) { [EOL]     return qualifiedClassName.equals(other.qualifiedClassName); [EOL] } <line_num>: 350,352
private static PrototypeMemberDeclaration extractDeclaration(Node n) { [EOL]     if (!NodeUtil.isPrototypePropertyDeclaration(n)) { [EOL]         return null; [EOL]     } [EOL]     Node lhs = n.getFirstChild().getFirstChild(); [EOL]     return new PrototypeMemberDeclaration(lhs, n); [EOL] } <line_num>: 358,364