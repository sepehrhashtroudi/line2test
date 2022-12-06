public MultiBackgroundInitializer() { [EOL]     super(); [EOL] } <line_num>: 107,109
public MultiBackgroundInitializer(final ExecutorService exec) { [EOL]     super(exec); [EOL] } <line_num>: 118,120
private MultiBackgroundInitializerResults(final Map<String, BackgroundInitializer<?>> inits, final Map<String, Object> results, final Map<String, ConcurrentException> excepts) { [EOL]     initializers = inits; [EOL]     resultObjects = results; [EOL]     exceptions = excepts; [EOL] } <line_num>: 246,253
public void addInitializer(final String name, final BackgroundInitializer<?> init) { [EOL]     if (name == null) { [EOL]         throw new IllegalArgumentException("Name of child initializer must not be null!"); [EOL]     } [EOL]     if (init == null) { [EOL]         throw new IllegalArgumentException("Child initializer must not be null!"); [EOL]     } [EOL]     synchronized (this) { [EOL]         if (isStarted()) { [EOL]             throw new IllegalStateException("addInitializer() must not be called after start()!"); [EOL]         } [EOL]         childInitializers.put(name, init); [EOL]     } [EOL] } <line_num>: 134,151
@Override [EOL] protected int getTaskCount() { [EOL]     int result = 1; [EOL]     for (final BackgroundInitializer<?> bi : childInitializers.values()) { [EOL]         result += bi.getTaskCount(); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 163,172
@Override [EOL] protected MultiBackgroundInitializerResults initialize() throws Exception { [EOL]     Map<String, BackgroundInitializer<?>> inits; [EOL]     synchronized (this) { [EOL]         inits = new HashMap<String, BackgroundInitializer<?>>(childInitializers); [EOL]     } [EOL]     final ExecutorService exec = getActiveExecutor(); [EOL]     for (final BackgroundInitializer<?> bi : inits.values()) { [EOL]         if (bi.getExternalExecutor() == null) { [EOL]             bi.setExternalExecutor(exec); [EOL]         } [EOL]         bi.start(); [EOL]     } [EOL]     final Map<String, Object> results = new HashMap<String, Object>(); [EOL]     final Map<String, ConcurrentException> excepts = new HashMap<String, ConcurrentException>(); [EOL]     for (final Map.Entry<String, BackgroundInitializer<?>> e : inits.entrySet()) { [EOL]         try { [EOL]             results.put(e.getKey(), e.getValue().get()); [EOL]         } catch (final ConcurrentException cex) { [EOL]             excepts.put(e.getKey(), cex); [EOL]         } [EOL]     } [EOL]     return new MultiBackgroundInitializerResults(inits, results, excepts); [EOL] } <line_num>: 184,215
public BackgroundInitializer<?> getInitializer(final String name) { [EOL]     return checkName(name); [EOL] } <line_num>: 263,265
public Object getResultObject(final String name) { [EOL]     checkName(name); [EOL]     return resultObjects.get(name); [EOL] } <line_num>: 279,282
public boolean isException(final String name) { [EOL]     checkName(name); [EOL]     return exceptions.containsKey(name); [EOL] } <line_num>: 292,295
public ConcurrentException getException(final String name) { [EOL]     checkName(name); [EOL]     return exceptions.get(name); [EOL] } <line_num>: 307,310
public Set<String> initializerNames() { [EOL]     return Collections.unmodifiableSet(initializers.keySet()); [EOL] } <line_num>: 319,321
public boolean isSuccessful() { [EOL]     return exceptions.isEmpty(); [EOL] } <line_num>: 329,331
private BackgroundInitializer<?> checkName(final String name) { [EOL]     final BackgroundInitializer<?> init = initializers.get(name); [EOL]     if (init == null) { [EOL]         throw new NoSuchElementException("No child initializer with name " + name); [EOL]     } [EOL]     return init; [EOL] } <line_num>: 342,350