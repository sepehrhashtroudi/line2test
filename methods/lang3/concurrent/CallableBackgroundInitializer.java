@Override [EOL] protected T initialize() throws Exception { [EOL]     return callable.call(); [EOL] } <line_num>: 110
private void checkCallable(final Callable<T> call) { [EOL]     if (call == null) { [EOL]         throw new IllegalArgumentException("Callable must not be null!"); [EOL]     } [EOL] } <line_num>: 121
