public final ThreadFactory getWrappedFactory() { [EOL]     return wrappedFactory; [EOL] } <line_num>: 138
public final String getNamingPattern() { [EOL]     return namingPattern; [EOL] } <line_num>: 148
public final Boolean getDaemonFlag() { [EOL]     return daemonFlag; [EOL] } <line_num>: 160
public final Integer getPriority() { [EOL]     return priority; [EOL] } <line_num>: 170
public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() { [EOL]     return uncaughtExceptionHandler; [EOL] } <line_num>: 180
public long getThreadCount() { [EOL]     return threadCounter.get(); [EOL] } <line_num>: 191
@Override [EOL] public Thread newThread(final Runnable r) { [EOL]     final Thread t = getWrappedFactory().newThread(r); [EOL]     initializeThread(t); [EOL]     return t; [EOL] } <line_num>: 204
private void initializeThread(final Thread t) { [EOL]     if (getNamingPattern() != null) { [EOL]         final Long count = Long.valueOf(threadCounter.incrementAndGet()); [EOL]         t.setName(String.format(getNamingPattern(), count)); [EOL]     } [EOL]     if (getUncaughtExceptionHandler() != null) { [EOL]         t.setUncaughtExceptionHandler(getUncaughtExceptionHandler()); [EOL]     } [EOL]     if (getPriority() != null) { [EOL]         t.setPriority(getPriority().intValue()); [EOL]     } [EOL]     if (getDaemonFlag() != null) { [EOL]         t.setDaemon(getDaemonFlag().booleanValue()); [EOL]     } [EOL] } <line_num>: 219
public Builder wrappedFactory(final ThreadFactory factory) { [EOL]     if (factory == null) { [EOL]         throw new NullPointerException("Wrapped ThreadFactory must not be null!"); [EOL]     } [EOL]     wrappedFactory = factory; [EOL]     return this; [EOL] } <line_num>: 282
public Builder namingPattern(final String pattern) { [EOL]     if (pattern == null) { [EOL]         throw new NullPointerException("Naming pattern must not be null!"); [EOL]     } [EOL]     namingPattern = pattern; [EOL]     return this; [EOL] } <line_num>: 300
public Builder daemon(final boolean f) { [EOL]     daemonFlag = Boolean.valueOf(f); [EOL]     return this; [EOL] } <line_num>: 318
public Builder priority(final int prio) { [EOL]     priority = Integer.valueOf(prio); [EOL]     return this; [EOL] } <line_num>: 330
public Builder uncaughtExceptionHandler(final Thread.UncaughtExceptionHandler handler) { [EOL]     if (handler == null) { [EOL]         throw new NullPointerException("Uncaught exception handler must not be null!"); [EOL]     } [EOL]     exceptionHandler = handler; [EOL]     return this; [EOL] } <line_num>: 344
public void reset() { [EOL]     wrappedFactory = null; [EOL]     exceptionHandler = null; [EOL]     namingPattern = null; [EOL]     priority = null; [EOL]     daemonFlag = null; [EOL] } <line_num>: 361
@Override [EOL] public BasicThreadFactory build() { [EOL]     final BasicThreadFactory factory = new BasicThreadFactory(this); [EOL]     reset(); [EOL]     return factory; [EOL] } <line_num>: 377
