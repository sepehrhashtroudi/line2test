@Override [EOL] public final T get() throws ConcurrentException { [EOL]     T result; [EOL]     while ((result = reference.get()) == null) { [EOL]         if (factory.compareAndSet(null, this)) { [EOL]             reference.set(initialize()); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 73
protected abstract T initialize() throws ConcurrentException; <line_num>: 96
