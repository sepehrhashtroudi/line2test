protected AssembledChronology(Chronology base, Object param)
 Fields()
public DateTimeZone getZone()
public long getDateTimeMillis(int year, int monthOfYear, int dayOfMonth, int millisOfDay) throws IllegalArgumentException
public long getDateTimeMillis(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute, int millisOfSecond) throws IllegalArgumentException
public long getDateTimeMillis(long instant, int hourOfDay, int minuteOfHour, int secondOfMinute, int millisOfSecond) throws IllegalArgumentException
public final DurationField millis()
public final DateTimeField millisOfSecond()
public final DateTimeField millisOfDay()
public final DurationField seconds()
public final DateTimeField secondOfMinute()
public final DateTimeField secondOfDay()
public final DurationField minutes()
public final DateTimeField minuteOfHour()
public final DateTimeField minuteOfDay()
public final DurationField hours()
public final DateTimeField hourOfDay()
public final DateTimeField clockhourOfDay()
public final DurationField halfdays()
public final DateTimeField hourOfHalfday()
public final DateTimeField clockhourOfHalfday()
public final DateTimeField halfdayOfDay()
public final DurationField days()
public final DateTimeField dayOfWeek()
public final DateTimeField dayOfMonth()
public final DateTimeField dayOfYear()
public final DurationField weeks()
public final DateTimeField weekOfWeekyear()
public final DurationField weekyears()
public final DateTimeField weekyear()
public final DateTimeField weekyearOfCentury()
public final DurationField months()
public final DateTimeField monthOfYear()
public final DurationField years()
public final DateTimeField year()
public final DateTimeField yearOfEra()
public final DateTimeField yearOfCentury()
public final DurationField centuries()
public final DateTimeField centuryOfEra()
public final DurationField eras()
public final DateTimeField era()
protected abstract void assemble(Fields fields)
protected final Chronology getBase()
protected final Object getParam()
private void setFields()
private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
public void copyFieldsFrom(Chronology chrono)
private static boolean isSupported(DurationField field)
private static boolean isSupported(DateTimeField field)
long serialVersionUID=Optional[-6728465968995518215L]
Chronology iBase
Object iParam
DurationField iMillis
DurationField iSeconds
DurationField iMinutes
DurationField iHours
DurationField iHalfdays
DurationField iDays
DurationField iWeeks
DurationField iWeekyears
DurationField iMonths
DurationField iYears
DurationField iCenturies
DurationField iEras
DateTimeField iMillisOfSecond
DateTimeField iMillisOfDay
DateTimeField iSecondOfMinute
DateTimeField iSecondOfDay
DateTimeField iMinuteOfHour
DateTimeField iMinuteOfDay
DateTimeField iHourOfDay
DateTimeField iClockhourOfDay
DateTimeField iHourOfHalfday
DateTimeField iClockhourOfHalfday
DateTimeField iHalfdayOfDay
DateTimeField iDayOfWeek
DateTimeField iDayOfMonth
DateTimeField iDayOfYear
DateTimeField iWeekOfWeekyear
DateTimeField iWeekyear
DateTimeField iWeekyearOfCentury
DateTimeField iMonthOfYear
DateTimeField iYear
DateTimeField iYearOfEra
DateTimeField iYearOfCentury
DateTimeField iCenturyOfEra
DateTimeField iEra
int iBaseFlags
