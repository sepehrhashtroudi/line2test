protected BaseDuration(long duration)
protected BaseDuration(long startInstant, long endInstant)
protected BaseDuration(ReadableInstant start, ReadableInstant end)
protected BaseDuration(Object duration)
public long getMillis()
protected void setMillis(long duration)
public Period toPeriod(PeriodType type)
public Period toPeriod(Chronology chrono)
public Period toPeriod(PeriodType type, Chronology chrono)
public Period toPeriodFrom(ReadableInstant startInstant)
public Period toPeriodFrom(ReadableInstant startInstant, PeriodType type)
public Period toPeriodTo(ReadableInstant endInstant)
public Period toPeriodTo(ReadableInstant endInstant, PeriodType type)
public Interval toIntervalFrom(ReadableInstant startInstant)
public Interval toIntervalTo(ReadableInstant endInstant)