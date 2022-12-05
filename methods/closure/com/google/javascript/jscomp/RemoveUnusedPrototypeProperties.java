RemoveUnusedPrototypeProperties(AbstractCompiler compiler, boolean canModifyExterns, boolean anchorUnusedVars) { [EOL]     this.compiler = compiler; [EOL]     this.canModifyExterns = canModifyExterns; [EOL]     this.anchorUnusedVars = anchorUnusedVars; [EOL] } <line_num>: 55,61
@Override [EOL] public void enableSpecialization(SpecializeModule.SpecializationState state) { [EOL]     this.specializationState = state; [EOL] } <line_num>: 63,66
@Override [EOL] public void process(Node externRoot, Node root) { [EOL]     AnalyzePrototypeProperties analyzer = new AnalyzePrototypeProperties(compiler, null, canModifyExterns, anchorUnusedVars); [EOL]     analyzer.process(externRoot, root); [EOL]     removeUnusedSymbols(analyzer.getAllNameInfo()); [EOL] } <line_num>: 68,75
private void removeUnusedSymbols(Collection<NameInfo> allNameInfo) { [EOL]     boolean changed = false; [EOL]     for (NameInfo nameInfo : allNameInfo) { [EOL]         if (!nameInfo.isReferenced()) { [EOL]             for (Symbol declaration : nameInfo.getDeclarations()) { [EOL]                 boolean canRemove = false; [EOL]                 if (specializationState == null) { [EOL]                     canRemove = true; [EOL]                 } else { [EOL]                     Node specializableFunction = getSpecializableFunctionFromSymbol(declaration); [EOL]                     if (specializableFunction != null) { [EOL]                         specializationState.reportRemovedFunction(specializableFunction, null); [EOL]                         canRemove = true; [EOL]                     } [EOL]                 } [EOL]                 if (canRemove) { [EOL]                     declaration.remove(); [EOL]                     changed = true; [EOL]                 } [EOL]             } [EOL]             logger.fine("Removed unused prototype property: " + nameInfo.name); [EOL]         } [EOL]     } [EOL]     if (changed) { [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL] } <line_num>: 81,114
private Node getSpecializableFunctionFromSymbol(Symbol symbol) { [EOL]     Preconditions.checkNotNull(specializationState); [EOL]     Node specializableFunction = null; [EOL]     if (symbol instanceof GlobalFunction) { [EOL]         specializableFunction = ((GlobalFunction) symbol).getFunctionNode(); [EOL]     } else if (symbol instanceof AssignmentProperty) { [EOL]         Node propertyValue = ((AssignmentProperty) symbol).getValue(); [EOL]         if (propertyValue.isFunction()) { [EOL]             specializableFunction = propertyValue; [EOL]         } [EOL]     } else if (symbol instanceof LiteralProperty) { [EOL]         return null; [EOL]     } else { [EOL]         Preconditions.checkState(false, "Should be unreachable."); [EOL]     } [EOL]     if (specializableFunction != null && specializationState.canFixupFunction(specializableFunction)) { [EOL]         return specializableFunction; [EOL]     } else { [EOL]         return null; [EOL]     } [EOL] } <line_num>: 119,147
