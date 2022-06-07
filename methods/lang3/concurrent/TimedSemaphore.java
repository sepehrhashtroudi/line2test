public final synchronized int getLimit() { [EOL]     return limit; [EOL] } <line_num>: 231
public final synchronized void setLimit(final int limit) { [EOL]     this.limit = limit; [EOL] } <line_num>: 245
public synchronized void shutdown() { [EOL]     if (!shutdown) { [EOL]         if (ownExecutor) { [EOL]             getExecutorService().shutdownNow(); [EOL]         } [EOL]         if (task != null) { [EOL]             task.cancel(false); [EOL]         } [EOL]         shutdown = true; [EOL]     } [EOL] } <line_num>: 254
public synchronized boolean isShutdown() { [EOL]     return shutdown; [EOL] } <line_num>: 277
public synchronized void acquire() throws InterruptedException { [EOL]     if (isShutdown()) { [EOL]         throw new IllegalStateException("TimedSemaphore is shut down!"); [EOL]     } [EOL]     if (task == null) { [EOL]         task = startTimer(); [EOL]     } [EOL]     boolean canPass = false; [EOL]     do { [EOL]         canPass = getLimit() <= NO_LIMIT || acquireCount < getLimit(); [EOL]         if (!canPass) { [EOL]             wait(); [EOL]         } else { [EOL]             acquireCount++; [EOL]         } [EOL]     } while (!canPass); [EOL] } <line_num>: 292
public synchronized int getLastAcquiresPerPeriod() { [EOL]     return lastCallsPerPeriod; [EOL] } <line_num>: 322
public synchronized int getAcquireCount() { [EOL]     return acquireCount; [EOL] } <line_num>: 332
public synchronized int getAvailablePermits() { [EOL]     return getLimit() - getAcquireCount(); [EOL] } <line_num>: 347
public synchronized double getAverageCallsPerPeriod() { [EOL]     return periodCount == 0 ? 0 : (double) totalAcquireCount / (double) periodCount; [EOL] } <line_num>: 360
public long getPeriod() { [EOL]     return period; [EOL] } <line_num>: 372
public TimeUnit getUnit() { [EOL]     return unit; [EOL] } <line_num>: 381
protected ScheduledExecutorService getExecutorService() { [EOL]     return executorService; [EOL] } <line_num>: 390
@Override [EOL] public void run() { [EOL]     endOfPeriod(); [EOL] } <line_num>: 404
protected ScheduledFuture<?> startTimer() { [EOL]     return getExecutorService().scheduleAtFixedRate(new Runnable() { [EOL]  [EOL]         @Override [EOL]         public void run() { [EOL]             endOfPeriod(); [EOL]         } [EOL]     }, getPeriod(), getPeriod(), getUnit()); [EOL] } <line_num>: 401
synchronized void endOfPeriod() { [EOL]     lastCallsPerPeriod = acquireCount; [EOL]     totalAcquireCount += acquireCount; [EOL]     periodCount++; [EOL]     acquireCount = 0; [EOL]     notifyAll(); [EOL] } <line_num>: 415
