ProcessDefines(AbstractCompiler compiler, Map<String, Node> replacements) { [EOL]     this.compiler = compiler; [EOL]     dominantReplacements = replacements; [EOL] } <line_num>: 100,103
CollectDefines(AbstractCompiler compiler, List<Name> listOfDefines) { [EOL]     this.compiler = compiler; [EOL]     this.allDefines = Maps.newHashMap(); [EOL]     assignableDefines = Maps.newHashMap(); [EOL]     assignAllowed = new ArrayDeque<Integer>(); [EOL]     assignAllowed.push(1); [EOL]     allRefInfo = Maps.newHashMap(); [EOL]     for (Name name : listOfDefines) { [EOL]         Ref decl = name.getDeclaration(); [EOL]         if (decl != null) { [EOL]             allRefInfo.put(decl.node, new RefInfo(decl, name)); [EOL]         } [EOL]         for (Ref ref : name.getRefs()) { [EOL]             if (ref == decl) { [EOL]                 continue; [EOL]             } [EOL]             if (ref.getTwin() == null || !ref.getTwin().isSet()) { [EOL]                 allRefInfo.put(ref.node, new RefInfo(ref, name)); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 237,265
RefInfo(Ref ref, Name name) { [EOL]     this.ref = ref; [EOL]     this.name = name; [EOL] } <line_num>: 480,483
public DefineInfo(Node initialValue, Node initialValueParent) { [EOL]     this.initialValueParent = initialValueParent; [EOL]     this.initialValue = initialValue; [EOL]     lastValue = initialValue; [EOL]     isAssignable = true; [EOL] } <line_num>: 502,507
ProcessDefines injectNamespace(GlobalNamespace namespace) { [EOL]     this.namespace = namespace; [EOL]     return this; [EOL] } <line_num>: 110,113
@Override [EOL] public void process(Node externs, Node root) { [EOL]     if (namespace == null) { [EOL]         namespace = new GlobalNamespace(compiler, root); [EOL]     } [EOL]     overrideDefines(collectDefines(root, namespace)); [EOL] } <line_num>: 115,121
private void overrideDefines(Map<String, DefineInfo> allDefines) { [EOL]     boolean changed = false; [EOL]     for (Map.Entry<String, DefineInfo> def : allDefines.entrySet()) { [EOL]         String defineName = def.getKey(); [EOL]         DefineInfo info = def.getValue(); [EOL]         Node inputValue = dominantReplacements.get(defineName); [EOL]         Node finalValue = inputValue != null ? inputValue : info.getLastValue(); [EOL]         if (finalValue != info.initialValue) { [EOL]             info.initialValueParent.replaceChild(info.initialValue, finalValue.cloneTree()); [EOL]             compiler.addToDebugLog("Overriding @define variable " + defineName); [EOL]             changed = changed || finalValue.getType() != info.initialValue.getType() || !finalValue.isEquivalentTo(info.initialValue); [EOL]         } [EOL]     } [EOL]     if (changed) { [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL]     Set<String> unusedReplacements = dominantReplacements.keySet(); [EOL]     unusedReplacements.removeAll(allDefines.keySet()); [EOL]     unusedReplacements.removeAll(KNOWN_DEFINES); [EOL]     for (String unknownDefine : unusedReplacements) { [EOL]         compiler.report(JSError.make(UNKNOWN_DEFINE_WARNING, unknownDefine)); [EOL]     } [EOL] } <line_num>: 123,151
private static String format(MessageFormat format, Object... params) { [EOL]     return format.format(params); [EOL] } <line_num>: 153,155
private boolean isValidDefineType(JSTypeExpression expression) { [EOL]     JSType type = expression.evaluate(null, compiler.getTypeRegistry()); [EOL]     return !type.isUnknownType() && type.isSubtype(compiler.getTypeRegistry().getNativeType(JSTypeNative.NUMBER_STRING_BOOLEAN)); [EOL] } <line_num>: 160,165
private Map<String, DefineInfo> collectDefines(Node root, GlobalNamespace namespace) { [EOL]     List<Name> allDefines = Lists.newArrayList(); [EOL]     for (Name name : namespace.getNameIndex().values()) { [EOL]         Ref decl = name.getDeclaration(); [EOL]         if (name.docInfo != null && name.docInfo.isDefine()) { [EOL]             if (isValidDefineType(name.docInfo.getType())) { [EOL]                 allDefines.add(name); [EOL]             } else { [EOL]                 JSError error = JSError.make(decl.getSourceName(), decl.node, INVALID_DEFINE_TYPE_ERROR); [EOL]                 compiler.report(error); [EOL]             } [EOL]         } else { [EOL]             for (Ref ref : name.getRefs()) { [EOL]                 if (ref == decl) { [EOL]                     continue; [EOL]                 } [EOL]                 Node n = ref.node; [EOL]                 Node parent = ref.node.getParent(); [EOL]                 JSDocInfo info = n.getJSDocInfo(); [EOL]                 if (info == null && parent.isVar() && parent.hasOneChild()) { [EOL]                     info = parent.getJSDocInfo(); [EOL]                 } [EOL]                 if (info != null && info.isDefine()) { [EOL]                     allDefines.add(name); [EOL]                     break; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     CollectDefines pass = new CollectDefines(compiler, allDefines); [EOL]     NodeTraversal.traverse(compiler, root, pass); [EOL]     return pass.getAllDefines(); [EOL] } <line_num>: 172,215
Map<String, DefineInfo> getAllDefines() { [EOL]     return allDefines; [EOL] } <line_num>: 271,273
@Override [EOL] public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent) { [EOL]     updateAssignAllowedStack(n, true); [EOL]     return true; [EOL] } <line_num>: 279,284
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     RefInfo refInfo = allRefInfo.get(n); [EOL]     if (refInfo != null) { [EOL]         Ref ref = refInfo.ref; [EOL]         Name name = refInfo.name; [EOL]         String fullName = name.getFullName(); [EOL]         switch(ref.type) { [EOL]             case SET_FROM_GLOBAL: [EOL]             case SET_FROM_LOCAL: [EOL]                 Node valParent = getValueParent(ref); [EOL]                 Node val = valParent.getLastChild(); [EOL]                 if (valParent.isAssign() && name.isSimpleName() && name.getDeclaration() == ref) { [EOL]                     compiler.report(t.makeError(val, INVALID_DEFINE_INIT_ERROR, fullName)); [EOL]                 } else if (processDefineAssignment(t, fullName, val, valParent)) { [EOL]                     refInfo.name.removeRef(ref); [EOL]                     lvalueToRemoveLater = valParent; [EOL]                 } [EOL]                 break; [EOL]             default: [EOL]                 if (t.inGlobalScope()) { [EOL]                     DefineInfo info = assignableDefines.get(fullName); [EOL]                     if (info != null) { [EOL]                         setDefineInfoNotAssignable(info, t); [EOL]                         assignableDefines.remove(fullName); [EOL]                     } [EOL]                 } [EOL]                 break; [EOL]         } [EOL]     } [EOL]     if (!t.inGlobalScope() && n.getJSDocInfo() != null && n.getJSDocInfo().isDefine()) { [EOL]         compiler.report(t.makeError(n, NON_GLOBAL_DEFINE_INIT_ERROR, "")); [EOL]     } [EOL]     if (lvalueToRemoveLater == n) { [EOL]         lvalueToRemoveLater = null; [EOL]         if (n.isAssign()) { [EOL]             Node last = n.getLastChild(); [EOL]             n.removeChild(last); [EOL]             parent.replaceChild(n, last); [EOL]         } else { [EOL]             Preconditions.checkState(n.isName()); [EOL]             n.removeChild(n.getFirstChild()); [EOL]         } [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL]     if (n.isCall()) { [EOL]         if (t.inGlobalScope()) { [EOL]             for (DefineInfo info : assignableDefines.values()) { [EOL]                 setDefineInfoNotAssignable(info, t); [EOL]             } [EOL]             assignableDefines.clear(); [EOL]         } [EOL]     } [EOL]     updateAssignAllowedStack(n, false); [EOL] } <line_num>: 286,371
private void updateAssignAllowedStack(Node n, boolean entering) { [EOL]     switch(n.getType()) { [EOL]         case Token.CASE: [EOL]         case Token.FOR: [EOL]         case Token.FUNCTION: [EOL]         case Token.HOOK: [EOL]         case Token.IF: [EOL]         case Token.SWITCH: [EOL]         case Token.WHILE: [EOL]             if (entering) { [EOL]                 assignAllowed.push(0); [EOL]             } else { [EOL]                 assignAllowed.remove(); [EOL]             } [EOL]             break; [EOL]     } [EOL] } <line_num>: 380,396
private boolean isAssignAllowed() { [EOL]     return assignAllowed.element() == 1; [EOL] } <line_num>: 402,404
private boolean processDefineAssignment(NodeTraversal t, String name, Node value, Node valueParent) { [EOL]     if (value == null || !NodeUtil.isValidDefineValue(value, allDefines.keySet())) { [EOL]         compiler.report(t.makeError(value, INVALID_DEFINE_INIT_ERROR, name)); [EOL]     } else if (!isAssignAllowed()) { [EOL]         compiler.report(t.makeError(valueParent, NON_GLOBAL_DEFINE_INIT_ERROR, name)); [EOL]     } else { [EOL]         DefineInfo info = allDefines.get(name); [EOL]         if (info == null) { [EOL]             info = new DefineInfo(value, valueParent); [EOL]             allDefines.put(name, info); [EOL]             assignableDefines.put(name, info); [EOL]         } else if (info.recordAssignment(value)) { [EOL]             return true; [EOL]         } else { [EOL]             compiler.report(t.makeError(valueParent, DEFINE_NOT_ASSIGNABLE_ERROR, name, info.getReasonWhyNotAssignable())); [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 415,445
private static Node getValueParent(Ref ref) { [EOL]     return ref.node.getParent() != null && ref.node.getParent().isVar() ? ref.node : ref.node.getParent(); [EOL] } <line_num>: 453,458
private void setDefineInfoNotAssignable(DefineInfo info, NodeTraversal t) { [EOL]     info.setNotAssignable(format(REASON_DEFINE_NOT_ASSIGNABLE, t.getLineNumber(), t.getSourceName())); [EOL] } <line_num>: 467,470
public void setNotAssignable(String reason) { [EOL]     isAssignable = false; [EOL]     reasonNotAssignable = reason; [EOL] } <line_num>: 514,517
public String getReasonWhyNotAssignable() { [EOL]     return reasonNotAssignable; [EOL] } <line_num>: 522,524
public boolean recordAssignment(Node value) { [EOL]     lastValue = value; [EOL]     return isAssignable; [EOL] } <line_num>: 531,534
public Node getLastValue() { [EOL]     return lastValue; [EOL] } <line_num>: 539,541
