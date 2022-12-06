public abstract DurationFieldType getType()
public abstract String getName()
public abstract boolean isSupported()
public abstract boolean isPrecise()
public abstract long getUnitMillis()
public abstract int getValue(long duration)
public abstract long getValueAsLong(long duration)
public abstract int getValue(long duration, long instant)
public abstract long getValueAsLong(long duration, long instant)
public abstract long getMillis(int value)
public abstract long getMillis(long value)
public abstract long getMillis(int value, long instant)
public abstract long getMillis(long value, long instant)
public abstract long add(long instant, int value)
public abstract long add(long instant, long value)
public long subtract(long instant, int value)
public long subtract(long instant, long value)
public abstract int getDifference(long minuendInstant, long subtrahendInstant)
public abstract long getDifferenceAsLong(long minuendInstant, long subtrahendInstant)
public abstract String toString()