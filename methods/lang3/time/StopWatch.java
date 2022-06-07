public void start() { [EOL]     if (this.runningState == STATE_STOPPED) { [EOL]         throw new IllegalStateException("Stopwatch must be reset before being restarted. "); [EOL]     } [EOL]     if (this.runningState != STATE_UNSTARTED) { [EOL]         throw new IllegalStateException("Stopwatch already started. "); [EOL]     } [EOL]     this.startTime = System.nanoTime(); [EOL]     this.startTimeMillis = System.currentTimeMillis(); [EOL]     this.runningState = STATE_RUNNING; [EOL] } <line_num>: 124
public void stop() { [EOL]     if (this.runningState != STATE_RUNNING && this.runningState != STATE_SUSPENDED) { [EOL]         throw new IllegalStateException("Stopwatch is not running. "); [EOL]     } [EOL]     if (this.runningState == STATE_RUNNING) { [EOL]         this.stopTime = System.nanoTime(); [EOL]     } [EOL]     this.runningState = STATE_STOPPED; [EOL] } <line_num>: 148
public void reset() { [EOL]     this.runningState = STATE_UNSTARTED; [EOL]     this.splitState = STATE_UNSPLIT; [EOL] } <line_num>: 167
public void split() { [EOL]     if (this.runningState != STATE_RUNNING) { [EOL]         throw new IllegalStateException("Stopwatch is not running. "); [EOL]     } [EOL]     this.stopTime = System.nanoTime(); [EOL]     this.splitState = STATE_SPLIT; [EOL] } <line_num>: 185
public void unsplit() { [EOL]     if (this.splitState != STATE_SPLIT) { [EOL]         throw new IllegalStateException("Stopwatch has not been split. "); [EOL]     } [EOL]     this.splitState = STATE_UNSPLIT; [EOL] } <line_num>: 206
public void suspend() { [EOL]     if (this.runningState != STATE_RUNNING) { [EOL]         throw new IllegalStateException("Stopwatch must be running to suspend. "); [EOL]     } [EOL]     this.stopTime = System.nanoTime(); [EOL]     this.runningState = STATE_SUSPENDED; [EOL] } <line_num>: 226
public void resume() { [EOL]     if (this.runningState != STATE_SUSPENDED) { [EOL]         throw new IllegalStateException("Stopwatch must be suspended to resume. "); [EOL]     } [EOL]     this.startTime += System.nanoTime() - this.stopTime; [EOL]     this.runningState = STATE_RUNNING; [EOL] } <line_num>: 247
public long getTime() { [EOL]     return getNanoTime() / NANO_2_MILLIS; [EOL] } <line_num>: 267
public long getNanoTime() { [EOL]     if (this.runningState == STATE_STOPPED || this.runningState == STATE_SUSPENDED) { [EOL]         return this.stopTime - this.startTime; [EOL]     } else if (this.runningState == STATE_UNSTARTED) { [EOL]         return 0; [EOL]     } else if (this.runningState == STATE_RUNNING) { [EOL]         return System.nanoTime() - this.startTime; [EOL]     } [EOL]     throw new RuntimeException("Illegal running state has occurred."); [EOL] } <line_num>: 283
public long getSplitTime() { [EOL]     return getSplitNanoTime() / NANO_2_MILLIS; [EOL] } <line_num>: 309
public long getSplitNanoTime() { [EOL]     if (this.splitState != STATE_SPLIT) { [EOL]         throw new IllegalStateException("Stopwatch must be split to get the split time. "); [EOL]     } [EOL]     return this.stopTime - this.startTime; [EOL] } <line_num>: 327
public long getStartTime() { [EOL]     if (this.runningState == STATE_UNSTARTED) { [EOL]         throw new IllegalStateException("Stopwatch has not been started"); [EOL]     } [EOL]     return this.startTimeMillis; [EOL] } <line_num>: 342
@Override [EOL] public String toString() { [EOL]     return DurationFormatUtils.formatDurationHMS(getTime()); [EOL] } <line_num>: 362
public String toSplitString() { [EOL]     return DurationFormatUtils.formatDurationHMS(getSplitTime()); [EOL] } <line_num>: 378
