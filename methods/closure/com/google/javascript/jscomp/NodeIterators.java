private NodeIterators() { [EOL] } <line_num>: 38,38
FunctionlessLocalScope(Node... ancestors) { [EOL]     Preconditions.checkArgument(ancestors.length > 0); [EOL]     for (Node n : ancestors) { [EOL]         if (n.isFunction()) { [EOL]             break; [EOL]         } [EOL]         this.ancestors.add(0, n); [EOL]     } [EOL] } <line_num>: 51,61
private LocalVarMotion(Node nameNode, FunctionlessLocalScope iterator) { [EOL]     Preconditions.checkArgument(nameNode.isName()); [EOL]     Node valueNode = NodeUtil.getAssignedValue(nameNode); [EOL]     this.varName = nameNode.getString(); [EOL]     this.valueHasSideEffects = valueNode != null && NodeUtil.mayHaveSideEffects(valueNode); [EOL]     this.iterator = iterator; [EOL]     advanceLookAhead(true); [EOL] } <line_num>: 193,201
@Override [EOL] public boolean hasNext() { [EOL]     return !(ancestors.size() == 1 && ancestors.peek().getNext() == null); [EOL] } <line_num>: 63,67
@Override [EOL] public Node next() { [EOL]     Node current = ancestors.pop(); [EOL]     if (current.getNext() == null) { [EOL]         current = ancestors.peek(); [EOL]         if (current.isFunction()) { [EOL]             return next(); [EOL]         } [EOL]     } else { [EOL]         current = current.getNext(); [EOL]         ancestors.push(current); [EOL]         if (current.isFunction()) { [EOL]             return next(); [EOL]         } [EOL]         while (current.hasChildren()) { [EOL]             current = current.getFirstChild(); [EOL]             ancestors.push(current); [EOL]             if (current.isFunction()) { [EOL]                 return next(); [EOL]             } [EOL]         } [EOL]     } [EOL]     return current; [EOL] } <line_num>: 69,100
@Override [EOL] public void remove() { [EOL]     throw new UnsupportedOperationException("Not implemented"); [EOL] } <line_num>: 102,105
protected Node current() { [EOL]     return ancestors.peek(); [EOL] } <line_num>: 110,112
protected Node currentParent() { [EOL]     return ancestors.size() >= 2 ? ancestors.get(ancestors.size() - 2) : null; [EOL] } <line_num>: 117,120
List<Node> currentAncestors() { [EOL]     List<Node> list = Lists.newArrayList(ancestors); [EOL]     Collections.reverse(list); [EOL]     return list; [EOL] } <line_num>: 126,130
static LocalVarMotion forVar(Node name, Node var, Node block) { [EOL]     Preconditions.checkArgument(var.isVar()); [EOL]     Preconditions.checkArgument(NodeUtil.isStatement(var)); [EOL]     return new LocalVarMotion(name, new FunctionlessLocalScope(name, var, block)); [EOL] } <line_num>: 163,173
static LocalVarMotion forAssign(Node name, Node assign, Node expr, Node block) { [EOL]     Preconditions.checkArgument(assign.isAssign()); [EOL]     Preconditions.checkArgument(expr.isExprResult()); [EOL]     return new LocalVarMotion(name, new FunctionlessLocalScope(assign, expr, block)); [EOL] } <line_num>: 179,187
@Override [EOL] public boolean hasNext() { [EOL]     return lookAhead != null; [EOL] } <line_num>: 203,206
@Override [EOL] public Node next() { [EOL]     Node next = lookAhead; [EOL]     advanceLookAhead(false); [EOL]     return next; [EOL] } <line_num>: 208,213
@Override [EOL] public void remove() { [EOL]     throw new UnsupportedOperationException("Not implemented"); [EOL] } <line_num>: 215,218
private void advanceLookAhead(boolean atStart) { [EOL]     if (!atStart) { [EOL]         if (lookAhead == null) { [EOL]             return; [EOL]         } [EOL]         Node curNode = iterator.current(); [EOL]         if (curNode.isName() && varName.equals(curNode.getString())) { [EOL]             lookAhead = null; [EOL]             return; [EOL]         } [EOL]     } [EOL]     if (!iterator.hasNext()) { [EOL]         lookAhead = null; [EOL]         return; [EOL]     } [EOL]     Node nextNode = iterator.next(); [EOL]     Node nextParent = iterator.currentParent(); [EOL]     int type = nextNode.getType(); [EOL]     if (valueHasSideEffects) { [EOL]         boolean readsState = false; [EOL]         if ((nextNode.isName() && !varName.equals(nextNode.getString())) || (nextNode.isGetProp() || nextNode.isGetElem())) { [EOL]             if (nextParent == null || !NodeUtil.isVarOrSimpleAssignLhs(nextNode, nextParent)) { [EOL]                 readsState = true; [EOL]             } [EOL]         } else if (nextNode.isCall() || nextNode.isNew()) { [EOL]             readsState = true; [EOL]         } [EOL]         if (readsState) { [EOL]             lookAhead = null; [EOL]             return; [EOL]         } [EOL]     } [EOL]     if (NodeUtil.nodeTypeMayHaveSideEffects(nextNode) && type != Token.NAME || type == Token.NAME && nextParent.isCatch()) { [EOL]         lookAhead = null; [EOL]         return; [EOL]     } [EOL]     lookAhead = nextNode; [EOL] } <line_num>: 220,288
