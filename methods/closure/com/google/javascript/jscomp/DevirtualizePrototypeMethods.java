DevirtualizePrototypeMethods(AbstractCompiler compiler) { [EOL]     this.compiler = compiler; [EOL] } <line_num>: 72,74
@Override [EOL] public void enableSpecialization(SpecializeModule.SpecializationState state) { [EOL]     this.specializationState = state; [EOL] } <line_num>: 76,79
@Override [EOL] public void process(Node externs, Node root) { [EOL]     SimpleDefinitionFinder defFinder = new SimpleDefinitionFinder(compiler); [EOL]     defFinder.process(externs, root); [EOL]     process(externs, root, defFinder); [EOL] } <line_num>: 81,86
@Override [EOL] public void process(Node externs, Node root, SimpleDefinitionFinder definitions) { [EOL]     for (DefinitionSite defSite : definitions.getDefinitionSites()) { [EOL]         rewriteDefinitionIfEligible(defSite, definitions); [EOL]     } [EOL] } <line_num>: 88,94
private static boolean isCall(UseSite site) { [EOL]     Node node = site.node; [EOL]     Node parent = node.getParent(); [EOL]     return (parent.getFirstChild() == node) && parent.isCall(); [EOL] } <line_num>: 99,103
private static boolean isPrototypeMethodDefinition(Node node) { [EOL]     Node parent = node.getParent(); [EOL]     if (parent == null) { [EOL]         return false; [EOL]     } [EOL]     Node gramp = parent.getParent(); [EOL]     if (gramp == null) { [EOL]         return false; [EOL]     } [EOL]     if (node.isGetProp()) { [EOL]         if (parent.getFirstChild() != node) { [EOL]             return false; [EOL]         } [EOL]         if (!NodeUtil.isExprAssign(gramp)) { [EOL]             return false; [EOL]         } [EOL]         Node functionNode = parent.getLastChild(); [EOL]         if ((functionNode == null) || !functionNode.isFunction()) { [EOL]             return false; [EOL]         } [EOL]         Node nameNode = node.getFirstChild(); [EOL]         return nameNode.isGetProp() && nameNode.getLastChild().getString().equals("prototype"); [EOL]     } else if (node.isStringKey()) { [EOL]         Preconditions.checkState(parent.isObjectLit()); [EOL]         if (!gramp.isAssign()) { [EOL]             return false; [EOL]         } [EOL]         if (gramp.getLastChild() != parent) { [EOL]             return false; [EOL]         } [EOL]         Node greatGramp = gramp.getParent(); [EOL]         if (greatGramp == null || !greatGramp.isExprResult()) { [EOL]             return false; [EOL]         } [EOL]         Node functionNode = node.getFirstChild(); [EOL]         if ((functionNode == null) || !functionNode.isFunction()) { [EOL]             return false; [EOL]         } [EOL]         Node target = gramp.getFirstChild(); [EOL]         return target.isGetProp() && target.getLastChild().getString().equals("prototype"); [EOL]     } else { [EOL]         return false; [EOL]     } [EOL] } <line_num>: 108,162
private String getMethodName(Node node) { [EOL]     if (node.isGetProp()) { [EOL]         return node.getLastChild().getString(); [EOL]     } else if (node.isStringKey()) { [EOL]         return node.getString(); [EOL]     } else { [EOL]         throw new IllegalStateException("unexpected"); [EOL]     } [EOL] } <line_num>: 164,172
private String getRewrittenMethodName(String originalMethodName) { [EOL]     return "JSCompiler_StaticMethods_" + originalMethodName; [EOL] } <line_num>: 177,179
private void rewriteDefinitionIfEligible(DefinitionSite defSite, SimpleDefinitionFinder defFinder) { [EOL]     if (defSite.inExterns || !defSite.inGlobalScope || !isEligibleDefinition(defFinder, defSite)) { [EOL]         return; [EOL]     } [EOL]     Node node = defSite.node; [EOL]     if (!isPrototypeMethodDefinition(node)) { [EOL]         return; [EOL]     } [EOL]     for (Node ancestor = node.getParent(); ancestor != null; ancestor = ancestor.getParent()) { [EOL]         if (NodeUtil.isControlStructure(ancestor)) { [EOL]             return; [EOL]         } [EOL]     } [EOL]     String newMethodName = getRewrittenMethodName(getMethodName(node)); [EOL]     rewriteDefinition(node, newMethodName); [EOL]     rewriteCallSites(defFinder, defSite.definition, newMethodName); [EOL] } <line_num>: 192,224
private boolean isEligibleDefinition(SimpleDefinitionFinder defFinder, DefinitionSite definitionSite) { [EOL]     Definition definition = definitionSite.definition; [EOL]     JSModule definitionModule = definitionSite.module; [EOL]     Node rValue = definition.getRValue(); [EOL]     if (rValue == null || !rValue.isFunction() || NodeUtil.isVarArgsFunction(rValue)) { [EOL]         return false; [EOL]     } [EOL]     Node lValue = definition.getLValue(); [EOL]     if ((lValue == null) || !lValue.isGetProp()) { [EOL]         return false; [EOL]     } [EOL]     CodingConvention codingConvention = compiler.getCodingConvention(); [EOL]     if (codingConvention.isExported(lValue.getLastChild().getString())) { [EOL]         return false; [EOL]     } [EOL]     Collection<UseSite> useSites = defFinder.getUseSites(definition); [EOL]     if (useSites.isEmpty()) { [EOL]         return false; [EOL]     } [EOL]     JSModuleGraph moduleGraph = compiler.getModuleGraph(); [EOL]     for (UseSite site : useSites) { [EOL]         if (!isCall(site)) { [EOL]             return false; [EOL]         } [EOL]         Node nameNode = site.node; [EOL]         if (specializationState != null && !specializationState.canFixupSpecializedFunctionContainingNode(nameNode)) { [EOL]             return false; [EOL]         } [EOL]         Collection<Definition> singleSiteDefinitions = defFinder.getDefinitionsReferencedAt(nameNode); [EOL]         if (singleSiteDefinitions.size() > 1) { [EOL]             return false; [EOL]         } [EOL]         Preconditions.checkState(!singleSiteDefinitions.isEmpty()); [EOL]         Preconditions.checkState(singleSiteDefinitions.contains(definition)); [EOL]         JSModule callModule = site.module; [EOL]         if ((definitionModule != callModule) && ((callModule == null) || !moduleGraph.dependsOn(callModule, definitionModule))) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 239,312
private void rewriteCallSites(SimpleDefinitionFinder defFinder, Definition definition, String newMethodName) { [EOL]     Collection<UseSite> useSites = defFinder.getUseSites(definition); [EOL]     for (UseSite site : useSites) { [EOL]         Node node = site.node; [EOL]         Node parent = node.getParent(); [EOL]         Node objectNode = node.getFirstChild(); [EOL]         node.removeChild(objectNode); [EOL]         parent.replaceChild(node, objectNode); [EOL]         parent.addChildToFront(IR.name(newMethodName).srcref(node)); [EOL]         Preconditions.checkState(parent.isCall()); [EOL]         parent.putBooleanProp(Node.FREE_CALL, true); [EOL]         compiler.reportCodeChange(); [EOL]         if (specializationState != null) { [EOL]             specializationState.reportSpecializedFunctionContainingNode(parent); [EOL]         } [EOL]     } [EOL] } <line_num>: 324,344
private void rewriteDefinition(Node node, String newMethodName) { [EOL]     boolean isObjLitDefKey = node.isStringKey(); [EOL]     Node parent = node.getParent(); [EOL]     Node refNode = isObjLitDefKey ? node : parent.getFirstChild(); [EOL]     Node newNameNode = IR.name(newMethodName).copyInformationFrom(refNode); [EOL]     Node newVarNode = IR.var(newNameNode).copyInformationFrom(refNode); [EOL]     Node functionNode; [EOL]     if (!isObjLitDefKey) { [EOL]         Preconditions.checkState(parent.isAssign()); [EOL]         functionNode = parent.getLastChild(); [EOL]         Node expr = parent.getParent(); [EOL]         Node block = expr.getParent(); [EOL]         parent.removeChild(functionNode); [EOL]         newNameNode.addChildToFront(functionNode); [EOL]         block.replaceChild(expr, newVarNode); [EOL]         if (specializationState != null) { [EOL]             specializationState.reportRemovedFunction(functionNode, block); [EOL]         } [EOL]     } else { [EOL]         Preconditions.checkState(parent.isObjectLit()); [EOL]         functionNode = node.getFirstChild(); [EOL]         Node assign = parent.getParent(); [EOL]         Node expr = assign.getParent(); [EOL]         Node block = expr.getParent(); [EOL]         node.removeChild(functionNode); [EOL]         parent.removeChild(node); [EOL]         newNameNode.addChildToFront(functionNode); [EOL]         block.addChildAfter(newVarNode, expr); [EOL]         if (specializationState != null) { [EOL]             specializationState.reportRemovedFunction(functionNode, block); [EOL]         } [EOL]     } [EOL]     String self = newMethodName + "$self"; [EOL]     Node argList = functionNode.getFirstChild().getNext(); [EOL]     argList.addChildToFront(IR.name(self).copyInformationFrom(functionNode)); [EOL]     Node body = functionNode.getLastChild(); [EOL]     replaceReferencesToThis(body, self); [EOL]     fixFunctionType(functionNode); [EOL]     compiler.reportCodeChange(); [EOL] } <line_num>: 356,409
private void fixFunctionType(Node functionNode) { [EOL]     FunctionType type = JSType.toMaybeFunctionType(functionNode.getJSType()); [EOL]     if (type != null) { [EOL]         JSTypeRegistry typeRegistry = compiler.getTypeRegistry(); [EOL]         List<JSType> parameterTypes = Lists.newArrayList(); [EOL]         parameterTypes.add(type.getTypeOfThis()); [EOL]         for (Node param : type.getParameters()) { [EOL]             parameterTypes.add(param.getJSType()); [EOL]         } [EOL]         ObjectType thisType = typeRegistry.getNativeObjectType(JSTypeNative.UNKNOWN_TYPE); [EOL]         JSType returnType = type.getReturnType(); [EOL]         JSType newType = typeRegistry.createFunctionType(thisType, returnType, parameterTypes); [EOL]         functionNode.setJSType(newType); [EOL]     } [EOL] } <line_num>: 417,437
private void replaceReferencesToThis(Node node, String name) { [EOL]     if (node.isFunction()) { [EOL]         return; [EOL]     } [EOL]     for (Node child : node.children()) { [EOL]         if (child.isThis()) { [EOL]             Node newName = IR.name(name); [EOL]             newName.setJSType(child.getJSType()); [EOL]             node.replaceChild(child, newName); [EOL]         } else { [EOL]             replaceReferencesToThis(child, name); [EOL]         } [EOL]     } [EOL] } <line_num>: 443,457
