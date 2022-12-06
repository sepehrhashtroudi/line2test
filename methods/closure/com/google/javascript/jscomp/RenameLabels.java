RenameLabels(AbstractCompiler compiler) { [EOL]     this(compiler, new DefaultNameSupplier(), true); [EOL] } <line_num>: 76,78
RenameLabels(AbstractCompiler compiler, Supplier<String> supplier, boolean removeUnused) { [EOL]     this.compiler = compiler; [EOL]     this.nameSupplier = supplier; [EOL]     this.removeUnused = removeUnused; [EOL] } <line_num>: 80,87
ProcessLabels() { [EOL]     namespaceStack.push(new LabelNamespace()); [EOL] } <line_num>: 105,108
LabelInfo(int id) { [EOL]     this.id = id; [EOL] } <line_num>: 268,270
@Override [EOL] public String get() { [EOL]     return nameGenerator.generateNextName(); [EOL] } <line_num>: 94,97
@Override [EOL] public void enterScope(NodeTraversal nodeTraversal) { [EOL]     namespaceStack.push(new LabelNamespace()); [EOL] } <line_num>: 119,123
@Override [EOL] public void exitScope(NodeTraversal nodeTraversal) { [EOL]     namespaceStack.pop(); [EOL] } <line_num>: 125,128
@Override [EOL] public boolean shouldTraverse(NodeTraversal nodeTraversal, Node node, Node parent) { [EOL]     if (node.isLabel()) { [EOL]         LabelNamespace current = namespaceStack.peek(); [EOL]         int currentDepth = current.renameMap.size() + 1; [EOL]         String name = node.getFirstChild().getString(); [EOL]         LabelInfo li = new LabelInfo(currentDepth); [EOL]         Preconditions.checkState(!current.renameMap.containsKey(name)); [EOL]         current.renameMap.put(name, li); [EOL]         if (names.size() < currentDepth) { [EOL]             names.add(nameSupplier.get()); [EOL]         } [EOL]         String newName = getNameForId(currentDepth); [EOL]         compiler.addToDebugLog("label renamed: " + name + " => " + newName); [EOL]     } [EOL]     return true; [EOL] } <line_num>: 136,160
@Override [EOL] public void visit(NodeTraversal nodeTraversal, Node node, Node parent) { [EOL]     switch(node.getType()) { [EOL]         case Token.LABEL: [EOL]             visitLabel(node, parent); [EOL]             break; [EOL]         case Token.BREAK: [EOL]         case Token.CONTINUE: [EOL]             visitBreakOrContinue(node); [EOL]             break; [EOL]     } [EOL] } <line_num>: 168,180
private void visitBreakOrContinue(Node node) { [EOL]     Node nameNode = node.getFirstChild(); [EOL]     if (nameNode != null) { [EOL]         String name = nameNode.getString(); [EOL]         Preconditions.checkState(name.length() != 0); [EOL]         LabelInfo li = getLabelInfo(name); [EOL]         if (li != null) { [EOL]             String newName = getNameForId(li.id); [EOL]             li.referenced = true; [EOL]             if (!name.equals(newName)) { [EOL]                 nameNode.setString(newName); [EOL]                 compiler.reportCodeChange(); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 186,204
private void visitLabel(Node node, Node parent) { [EOL]     Node nameNode = node.getFirstChild(); [EOL]     Preconditions.checkState(nameNode != null); [EOL]     String name = nameNode.getString(); [EOL]     LabelInfo li = getLabelInfo(name); [EOL]     if (li.referenced || !removeUnused) { [EOL]         String newName = getNameForId(li.id); [EOL]         if (!name.equals(newName)) { [EOL]             nameNode.setString(newName); [EOL]             compiler.reportCodeChange(); [EOL]         } [EOL]     } else { [EOL]         Node newChild = node.getLastChild(); [EOL]         node.removeChild(newChild); [EOL]         parent.replaceChild(node, newChild); [EOL]         if (newChild.isBlock()) { [EOL]             NodeUtil.tryMergeBlock(newChild); [EOL]         } [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL]     namespaceStack.peek().renameMap.remove(name); [EOL] } <line_num>: 211,237
String getNameForId(int id) { [EOL]     return names.get(id - 1); [EOL] } <line_num>: 244,246
LabelInfo getLabelInfo(String name) { [EOL]     return namespaceStack.peek().renameMap.get(name); [EOL] } <line_num>: 252,254
@Override [EOL] public void process(Node externs, Node root) { [EOL]     NodeTraversal.traverse(compiler, root, new ProcessLabels()); [EOL] } <line_num>: 257,261