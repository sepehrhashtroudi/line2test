private Hours(int hours)
public static Hours hours(int hours)
public static Hours hoursBetween(ReadableInstant start, ReadableInstant end)
public static Hours hoursBetween(ReadablePartial start, ReadablePartial end)
public static Hours hoursIn(ReadableInterval interval)
public static Hours standardHoursIn(ReadablePeriod period)
public static Hours parseHours(String periodStr)
private Object readResolve()
public DurationFieldType getFieldType()
public PeriodType getPeriodType()
public Weeks toStandardWeeks()
public Days toStandardDays()
public Minutes toStandardMinutes()
public Seconds toStandardSeconds()
public Duration toStandardDuration()
public int getHours()
public Hours plus(int hours)
public Hours plus(Hours hours)
public Hours minus(int hours)
public Hours minus(Hours hours)
public Hours multipliedBy(int scalar)
public Hours dividedBy(int divisor)
public Hours negated()
public boolean isGreaterThan(Hours other)
public boolean isLessThan(Hours other)
public String toString()