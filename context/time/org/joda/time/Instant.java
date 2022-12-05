public Instant()
public Instant(long instant)
public Instant(Object instant)
public static Instant now()
public static Instant parse(String str)
public static Instant parse(String str, DateTimeFormatter formatter)
public Instant toInstant()
public Instant withMillis(long newMillis)
public Instant withDurationAdded(long durationToAdd, int scalar)
public Instant withDurationAdded(ReadableDuration durationToAdd, int scalar)
public Instant plus(long duration)
public Instant plus(ReadableDuration duration)
public Instant minus(long duration)
public Instant minus(ReadableDuration duration)
public long getMillis()
public Chronology getChronology()
public DateTime toDateTime()
public DateTime toDateTimeISO()
public MutableDateTime toMutableDateTime()
public MutableDateTime toMutableDateTimeISO()
long serialVersionUID=Optional[3299096530934209741L]
long iMillis
