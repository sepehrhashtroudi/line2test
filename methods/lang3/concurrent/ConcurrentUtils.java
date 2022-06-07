public static ConcurrentException extractCause(final ExecutionException ex) { [EOL]     if (ex == null || ex.getCause() == null) { [EOL]         return null; [EOL]     } [EOL]     throwCause(ex); [EOL]     return new ConcurrentException(ex.getMessage(), ex.getCause()); [EOL] } <line_num>: 60
public static ConcurrentRuntimeException extractCauseUnchecked(final ExecutionException ex) { [EOL]     if (ex == null || ex.getCause() == null) { [EOL]         return null; [EOL]     } [EOL]     throwCause(ex); [EOL]     return new ConcurrentRuntimeException(ex.getMessage(), ex.getCause()); [EOL] } <line_num>: 81
public static void handleCause(final ExecutionException ex) throws ConcurrentException { [EOL]     final ConcurrentException cex = extractCause(ex); [EOL]     if (cex != null) { [EOL]         throw cex; [EOL]     } [EOL] } <line_num>: 104
public static void handleCauseUnchecked(final ExecutionException ex) { [EOL]     final ConcurrentRuntimeException crex = extractCauseUnchecked(ex); [EOL]     if (crex != null) { [EOL]         throw crex; [EOL]     } [EOL] } <line_num>: 126
static Throwable checkedException(final Throwable ex) { [EOL]     if (ex != null && !(ex instanceof RuntimeException) && !(ex instanceof Error)) { [EOL]         return ex; [EOL]     } else { [EOL]         throw new IllegalArgumentException("Not a checked exception: " + ex); [EOL]     } [EOL] } <line_num>: 143
private static void throwCause(final ExecutionException ex) { [EOL]     if (ex.getCause() instanceof RuntimeException) { [EOL]         throw (RuntimeException) ex.getCause(); [EOL]     } [EOL]     if (ex.getCause() instanceof Error) { [EOL]         throw (Error) ex.getCause(); [EOL]     } [EOL] } <line_num>: 158
public static <T> T initialize(final ConcurrentInitializer<T> initializer) throws ConcurrentException { [EOL]     return initializer != null ? initializer.get() : null; [EOL] } <line_num>: 182
public static <T> T initializeUnchecked(final ConcurrentInitializer<T> initializer) { [EOL]     try { [EOL]         return initialize(initializer); [EOL]     } catch (final ConcurrentException cex) { [EOL]         throw new ConcurrentRuntimeException(cex.getCause()); [EOL]     } [EOL] } <line_num>: 200
public static <K, V> V putIfAbsent(final ConcurrentMap<K, V> map, final K key, final V value) { [EOL]     if (map == null) { [EOL]         return null; [EOL]     } [EOL]     final V result = map.putIfAbsent(key, value); [EOL]     return result != null ? result : value; [EOL] } <line_num>: 241
public static <K, V> V createIfAbsent(final ConcurrentMap<K, V> map, final K key, final ConcurrentInitializer<V> init) throws ConcurrentException { [EOL]     if (map == null || init == null) { [EOL]         return null; [EOL]     } [EOL]     final V value = map.get(key); [EOL]     if (value == null) { [EOL]         return putIfAbsent(map, key, init.get()); [EOL]     } [EOL]     return value; [EOL] } <line_num>: 270
public static <K, V> V createIfAbsentUnchecked(final ConcurrentMap<K, V> map, final K key, final ConcurrentInitializer<V> init) { [EOL]     try { [EOL]         return createIfAbsent(map, key, init); [EOL]     } catch (final ConcurrentException cex) { [EOL]         throw new ConcurrentRuntimeException(cex.getCause()); [EOL]     } [EOL] } <line_num>: 298
public static <T> Future<T> constantFuture(final T value) { [EOL]     return new ConstantFuture<T>(value); [EOL] } <line_num>: 323
@Override [EOL] public boolean isDone() { [EOL]     return true; [EOL] } <line_num>: 351
@Override [EOL] public T get() { [EOL]     return value; [EOL] } <line_num>: 359
@Override [EOL] public T get(final long timeout, final TimeUnit unit) { [EOL]     return value; [EOL] } <line_num>: 368
@Override [EOL] public boolean isCancelled() { [EOL]     return false; [EOL] } <line_num>: 377
@Override [EOL] public boolean cancel(final boolean mayInterruptIfRunning) { [EOL]     return false; [EOL] } <line_num>: 386
