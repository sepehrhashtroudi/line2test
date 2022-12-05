InlineObjectLiterals(AbstractCompiler compiler, Supplier<String> safeNameIdSupplier) { [EOL]     this.compiler = compiler; [EOL]     this.safeNameIdSupplier = safeNameIdSupplier; [EOL] } <line_num>: 56,61
@Override [EOL] public void process(Node externs, Node root) { [EOL]     ReferenceCollectingCallback callback = new ReferenceCollectingCallback(compiler, new InliningBehavior()); [EOL]     callback.process(externs, root); [EOL] } <line_num>: 63,68
@Override [EOL] public void afterExitScope(NodeTraversal t, ReferenceMap referenceMap) { [EOL]     for (Iterator<Var> it = t.getScope().getVars(); it.hasNext(); ) { [EOL]         Var v = it.next(); [EOL]         if (isVarInlineForbidden(v)) { [EOL]             continue; [EOL]         } [EOL]         ReferenceCollection referenceInfo = referenceMap.getReferences(v); [EOL]         if (isInlinableObject(referenceInfo.references)) { [EOL]             staleVars.add(v); [EOL]             Reference declaration = referenceInfo.references.get(0); [EOL]             Reference init = referenceInfo.getInitializingReference(); [EOL]             splitObject(v, declaration, init, referenceInfo); [EOL]         } [EOL]     } [EOL] } <line_num>: 83,107
@Override [EOL] public void visit(Node node) { [EOL]     if (node.isName()) { [EOL]         staleVars.add(scope.getVar(node.getString())); [EOL]     } [EOL] } <line_num>: 117,122
private void blacklistVarReferencesInTree(Node root, final Scope scope) { [EOL]     NodeUtil.visitPreOrder(root, new NodeUtil.Visitor() { [EOL]  [EOL]         @Override [EOL]         public void visit(Node node) { [EOL]             if (node.isName()) { [EOL]                 staleVars.add(scope.getVar(node.getString())); [EOL]             } [EOL]         } [EOL]     }, NodeUtil.MATCH_NOT_FUNCTION); [EOL] } <line_num>: 115,124
private boolean isVarInlineForbidden(Var var) { [EOL]     return var.isGlobal() || var.isExtern() || compiler.getCodingConvention().isExported(var.name) || RenameProperties.RENAME_PROPERTY_FUNCTION_NAME.equals(var.name) || staleVars.contains(var); [EOL] } <line_num>: 129,145
private boolean isInlinableObject(List<Reference> refs) { [EOL]     boolean ret = false; [EOL]     Set<String> validProperties = Sets.newHashSet(); [EOL]     for (Reference ref : refs) { [EOL]         Node name = ref.getNode(); [EOL]         Node parent = ref.getParent(); [EOL]         Node gramps = ref.getGrandparent(); [EOL]         if (parent.isGetProp()) { [EOL]             Preconditions.checkState(parent.getFirstChild() == name); [EOL]             if (gramps.isCall() && gramps.getFirstChild() == parent) { [EOL]                 return false; [EOL]             } [EOL]             if (gramps.isDelProp()) { [EOL]                 return false; [EOL]             } [EOL]             String propName = parent.getLastChild().getString(); [EOL]             if (!validProperties.contains(propName)) { [EOL]                 if (NodeUtil.isVarOrSimpleAssignLhs(parent, gramps)) { [EOL]                     validProperties.add(propName); [EOL]                 } else { [EOL]                     return false; [EOL]                 } [EOL]             } [EOL]             continue; [EOL]         } [EOL]         if (!isVarOrAssignExprLhs(name)) { [EOL]             return false; [EOL]         } [EOL]         Node val = ref.getAssignedValue(); [EOL]         if (val == null) { [EOL]             continue; [EOL]         } [EOL]         if (!val.isObjectLit()) { [EOL]             return false; [EOL]         } [EOL]         for (Node child = val.getFirstChild(); child != null; child = child.getNext()) { [EOL]             if (child.isGetterDef() || child.isSetterDef()) { [EOL]                 return false; [EOL]             } [EOL]             validProperties.add(child.getString()); [EOL]             Node childVal = child.getFirstChild(); [EOL]             for (Reference t : refs) { [EOL]                 Node refNode = t.getParent(); [EOL]                 while (!NodeUtil.isStatementBlock(refNode)) { [EOL]                     if (refNode == childVal) { [EOL]                         return false; [EOL]                     } [EOL]                     refNode = refNode.getParent(); [EOL]                 } [EOL]             } [EOL]         } [EOL]         ret = true; [EOL]     } [EOL]     return ret; [EOL] } <line_num>: 155,256
private boolean isVarOrAssignExprLhs(Node n) { [EOL]     Node parent = n.getParent(); [EOL]     return parent.isVar() || (parent.isAssign() && parent.getFirstChild() == n && parent.getParent().isExprResult()); [EOL] } <line_num>: 258,264
private Map<String, String> computeVarList(Var v, ReferenceCollection referenceInfo) { [EOL]     Map<String, String> varmap = Maps.newLinkedHashMap(); [EOL]     for (Reference ref : referenceInfo.references) { [EOL]         if (ref.isLvalue() || ref.isInitializingDeclaration()) { [EOL]             Node val = ref.getAssignedValue(); [EOL]             if (val != null) { [EOL]                 Preconditions.checkState(val.isObjectLit()); [EOL]                 for (Node child = val.getFirstChild(); child != null; child = child.getNext()) { [EOL]                     String varname = child.getString(); [EOL]                     if (varmap.containsKey(varname)) { [EOL]                         continue; [EOL]                     } [EOL]                     String var = VAR_PREFIX + varname + "_" + safeNameIdSupplier.get(); [EOL]                     varmap.put(varname, var); [EOL]                 } [EOL]             } [EOL]         } else if (ref.getParent().isVar()) { [EOL]         } else { [EOL]             Node getprop = ref.getParent(); [EOL]             Preconditions.checkState(getprop.isGetProp()); [EOL]             String varname = getprop.getLastChild().getString(); [EOL]             if (varmap.containsKey(varname)) { [EOL]                 continue; [EOL]             } [EOL]             String var = VAR_PREFIX + varname + "_" + safeNameIdSupplier.get(); [EOL]             varmap.put(varname, var); [EOL]         } [EOL]     } [EOL]     return varmap; [EOL] } <line_num>: 271,310
private void fillInitialValues(Reference init, Map<String, Node> initvals) { [EOL]     Node object = init.getAssignedValue(); [EOL]     Preconditions.checkState(object.isObjectLit()); [EOL]     for (Node key = object.getFirstChild(); key != null; key = key.getNext()) { [EOL]         initvals.put(key.getString(), key.removeFirstChild()); [EOL]     } [EOL] } <line_num>: 317,324
private void replaceAssignmentExpression(Var v, Reference ref, Map<String, String> varmap) { [EOL]     List<Node> nodes = Lists.newArrayList(); [EOL]     Node val = ref.getAssignedValue(); [EOL]     blacklistVarReferencesInTree(val, v.scope); [EOL]     Preconditions.checkState(val.isObjectLit()); [EOL]     Set<String> all = Sets.newLinkedHashSet(varmap.keySet()); [EOL]     for (Node key = val.getFirstChild(); key != null; key = key.getNext()) { [EOL]         String var = key.getString(); [EOL]         Node value = key.removeFirstChild(); [EOL]         nodes.add(IR.assign(IR.name(varmap.get(var)), value)); [EOL]         all.remove(var); [EOL]     } [EOL]     for (String var : all) { [EOL]         nodes.add(IR.assign(IR.name(varmap.get(var)), NodeUtil.newUndefinedNode(null))); [EOL]     } [EOL]     Node replacement; [EOL]     if (nodes.isEmpty()) { [EOL]         replacement = IR.trueNode(); [EOL]     } else { [EOL]         nodes.add(IR.trueNode()); [EOL]         nodes = Lists.reverse(nodes); [EOL]         replacement = new Node(Token.COMMA); [EOL]         Node cur = replacement; [EOL]         int i; [EOL]         for (i = 0; i < nodes.size() - 2; i++) { [EOL]             cur.addChildToFront(nodes.get(i)); [EOL]             Node t = new Node(Token.COMMA); [EOL]             cur.addChildToFront(t); [EOL]             cur = t; [EOL]         } [EOL]         cur.addChildToFront(nodes.get(i)); [EOL]         cur.addChildToFront(nodes.get(i + 1)); [EOL]     } [EOL]     Node replace = ref.getParent(); [EOL]     replacement.copyInformationFromForTree(replace); [EOL]     if (replace.isVar()) { [EOL]         replace.getParent().replaceChild(replace, NodeUtil.newExpr(replacement)); [EOL]     } else { [EOL]         replace.getParent().replaceChild(replace, replacement); [EOL]     } [EOL] } <line_num>: 331,393
private void splitObject(Var v, Reference declaration, Reference init, ReferenceCollection referenceInfo) { [EOL]     Map<String, String> varmap = computeVarList(v, referenceInfo); [EOL]     Map<String, Node> initvals = Maps.newHashMap(); [EOL]     Node vnode; [EOL]     boolean defined = referenceInfo.isWellDefined() && init.getParent().isVar(); [EOL]     if (defined) { [EOL]         vnode = init.getParent(); [EOL]         fillInitialValues(init, initvals); [EOL]     } else { [EOL]         vnode = v.getScope().getRootNode().getLastChild().getFirstChild(); [EOL]     } [EOL]     for (Map.Entry<String, String> entry : varmap.entrySet()) { [EOL]         Node val = initvals.get(entry.getKey()); [EOL]         Node varnode = NodeUtil.newVarNode(entry.getValue(), val); [EOL]         if (val == null) { [EOL]             varnode.copyInformationFromForTree(vnode); [EOL]         } else { [EOL]             blacklistVarReferencesInTree(val, v.scope); [EOL]         } [EOL]         vnode.getParent().addChildBefore(varnode, vnode); [EOL]     } [EOL]     if (defined) { [EOL]         vnode.getParent().removeChild(vnode); [EOL]     } [EOL]     for (Reference ref : referenceInfo.references) { [EOL]         if (defined && ref == init) [EOL]             continue; [EOL]         if (ref.isLvalue()) { [EOL]             replaceAssignmentExpression(v, ref, varmap); [EOL]         } else if (ref.getParent().isVar()) { [EOL]             ref.getGrandparent().removeChild(ref.getParent()); [EOL]         } else { [EOL]             Node getprop = ref.getParent(); [EOL]             Preconditions.checkState(getprop.isGetProp()); [EOL]             String var = getprop.getChildAtIndex(1).getString(); [EOL]             Preconditions.checkState(varmap.containsKey(var)); [EOL]             Node replacement = IR.name(varmap.get(var)); [EOL]             replacement.copyInformationFrom(getprop); [EOL]             ref.getGrandparent().replaceChild(ref.getParent(), replacement); [EOL]         } [EOL]     } [EOL]     compiler.reportCodeChange(); [EOL] } <line_num>: 399,470
