MultiBackgroundInitializerResults
MultiBackgroundInitializer
public void addInitializer(final String name, final BackgroundInitializer<?> init)
protected int getTaskCount()
protected MultiBackgroundInitializerResults initialize() throws Exception
public BackgroundInitializer<?> getInitializer(final String name)
public Object getResultObject(final String name)
public boolean isException(final String name)
public ConcurrentException getException(final String name)
public Set<String> initializerNames()
public boolean isSuccessful()
private BackgroundInitializer<?> checkName(final String name)
Map<String, BackgroundInitializer<?>> childInitializers=Optional[new HashMap<String, BackgroundInitializer<?>>()]
