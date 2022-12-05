UnresolvedTypeExpression(JSTypeRegistry registry, Node typeExpr, String sourceName) { [EOL]     super(registry, false); [EOL]     Preconditions.checkNotNull(typeExpr); [EOL]     this.typeExpr = typeExpr; [EOL]     this.sourceName = sourceName; [EOL] } <line_num>: 67,74
@Override [EOL] JSType resolveInternal(ErrorReporter t, StaticScope<JSType> enclosing) { [EOL]     return registry.createFromTypeNodes(typeExpr, sourceName, enclosing); [EOL] } <line_num>: 79,82
