@Override [EOL] public ContextedRuntimeException addContextValue(final String label, final Object value) { [EOL]     exceptionContext.addContextValue(label, value); [EOL]     return this; [EOL] } <line_num>: 168
@Override [EOL] public ContextedRuntimeException setContextValue(final String label, final Object value) { [EOL]     exceptionContext.setContextValue(label, value); [EOL]     return this; [EOL] } <line_num>: 187
@Override [EOL] public List<Object> getContextValues(final String label) { [EOL]     return this.exceptionContext.getContextValues(label); [EOL] } <line_num>: 196
@Override [EOL] public Object getFirstContextValue(final String label) { [EOL]     return this.exceptionContext.getFirstContextValue(label); [EOL] } <line_num>: 204
@Override [EOL] public List<Pair<String, Object>> getContextEntries() { [EOL]     return this.exceptionContext.getContextEntries(); [EOL] } <line_num>: 212
@Override [EOL] public Set<String> getContextLabels() { [EOL]     return exceptionContext.getContextLabels(); [EOL] } <line_num>: 220
@Override [EOL] public String getMessage() { [EOL]     return getFormattedExceptionMessage(super.getMessage()); [EOL] } <line_num>: 231
public String getRawMessage() { [EOL]     return super.getMessage(); [EOL] } <line_num>: 242
@Override [EOL] public String getFormattedExceptionMessage(final String baseMessage) { [EOL]     return exceptionContext.getFormattedExceptionMessage(baseMessage); [EOL] } <line_num>: 250
