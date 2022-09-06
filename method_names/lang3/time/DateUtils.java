public DateUtils()
 DateIterator(final Calendar startFinal, final Calendar endFinal)
public static boolean isSameDay(final Date date1, final Date date2)
public static boolean isSameDay(final Calendar cal1, final Calendar cal2)
public static boolean isSameInstant(final Date date1, final Date date2)
public static boolean isSameInstant(final Calendar cal1, final Calendar cal2)
public static boolean isSameLocalTime(final Calendar cal1, final Calendar cal2)
public static Date parseDate(final String str, final String... parsePatterns) throws ParseException
public static Date parseDate(final String str, final Locale locale, final String... parsePatterns) throws ParseException
public static Date parseDateStrictly(final String str, final String... parsePatterns) throws ParseException
public static Date parseDateStrictly(final String str, final Locale locale, final String... parsePatterns) throws ParseException
private static Date parseDateWithLeniency(final String str, final Locale locale, final String[] parsePatterns, final boolean lenient) throws ParseException
public static Date addYears(final Date date, final int amount)
public static Date addMonths(final Date date, final int amount)
public static Date addWeeks(final Date date, final int amount)
public static Date addDays(final Date date, final int amount)
public static Date addHours(final Date date, final int amount)
public static Date addMinutes(final Date date, final int amount)
public static Date addSeconds(final Date date, final int amount)
public static Date addMilliseconds(final Date date, final int amount)
private static Date add(final Date date, final int calendarField, final int amount)
public static Date setYears(final Date date, final int amount)
public static Date setMonths(final Date date, final int amount)
public static Date setDays(final Date date, final int amount)
public static Date setHours(final Date date, final int amount)
public static Date setMinutes(final Date date, final int amount)
public static Date setSeconds(final Date date, final int amount)
public static Date setMilliseconds(final Date date, final int amount)
private static Date set(final Date date, final int calendarField, final int amount)
public static Calendar toCalendar(final Date date)
public static Date round(final Date date, final int field)
public static Calendar round(final Calendar date, final int field)
public static Date round(final Object date, final int field)
public static Date truncate(final Date date, final int field)
public static Calendar truncate(final Calendar date, final int field)
public static Date truncate(final Object date, final int field)
public static Date ceiling(final Date date, final int field)
public static Calendar ceiling(final Calendar date, final int field)
public static Date ceiling(final Object date, final int field)
private static void modify(final Calendar val, final int field, final int modType)
public static Iterator<Calendar> iterator(final Date focus, final int rangeStyle)
public static Iterator<Calendar> iterator(final Calendar focus, final int rangeStyle)
public static Iterator<?> iterator(final Object focus, final int rangeStyle)
public static long getFragmentInMilliseconds(final Date date, final int fragment)
public static long getFragmentInSeconds(final Date date, final int fragment)
public static long getFragmentInMinutes(final Date date, final int fragment)
public static long getFragmentInHours(final Date date, final int fragment)
public static long getFragmentInDays(final Date date, final int fragment)
public static long getFragmentInMilliseconds(final Calendar calendar, final int fragment)
public static long getFragmentInSeconds(final Calendar calendar, final int fragment)
public static long getFragmentInMinutes(final Calendar calendar, final int fragment)
public static long getFragmentInHours(final Calendar calendar, final int fragment)
public static long getFragmentInDays(final Calendar calendar, final int fragment)
private static long getFragment(final Date date, final int fragment, final int unit)
private static long getFragment(final Calendar calendar, final int fragment, final int unit)
public static boolean truncatedEquals(final Calendar cal1, final Calendar cal2, final int field)
public static boolean truncatedEquals(final Date date1, final Date date2, final int field)
public static int truncatedCompareTo(final Calendar cal1, final Calendar cal2, final int field)
public static int truncatedCompareTo(final Date date1, final Date date2, final int field)
private static long getMillisPerUnit(final int unit)
public boolean hasNext()
public Calendar next()
public void remove()
