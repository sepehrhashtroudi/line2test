DatePrinter getInstance(final String format) { [EOL]     return getInstance(format, TimeZone.getDefault(), Locale.getDefault()); [EOL] } <line_num>: 46,48
private DatePrinter getDateInstance(final int dateStyle, final Locale locale) { [EOL]     return getInstance(FormatCache.getPatternForStyle(Integer.valueOf(dateStyle), null, locale), TimeZone.getDefault(), Locale.getDefault()); [EOL] } <line_num>: 50,52
private DatePrinter getInstance(final String format, final Locale locale) { [EOL]     return getInstance(format, TimeZone.getDefault(), locale); [EOL] } <line_num>: 54,56
private DatePrinter getInstance(final String format, final TimeZone timeZone) { [EOL]     return getInstance(format, timeZone, Locale.getDefault()); [EOL] } <line_num>: 58,60
protected DatePrinter getInstance(final String format, final TimeZone timeZone, final Locale locale) { [EOL]     return new FastDatePrinter(format, timeZone, locale); [EOL] } <line_num>: 69,71
@Test [EOL] public void testFormat() { [EOL]     final Locale realDefaultLocale = Locale.getDefault(); [EOL]     final TimeZone realDefaultZone = TimeZone.getDefault(); [EOL]     try { [EOL]         Locale.setDefault(Locale.US); [EOL]         TimeZone.setDefault(NEW_YORK); [EOL]         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); [EOL]         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); [EOL]         final Date date1 = cal1.getTime(); [EOL]         final Date date2 = cal2.getTime(); [EOL]         final long millis1 = date1.getTime(); [EOL]         final long millis2 = date2.getTime(); [EOL]         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); [EOL]         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); [EOL]         assertEquals(sdf.format(date1), fdf.format(date1)); [EOL]         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); [EOL]         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); [EOL]         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); [EOL]         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); [EOL]         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); [EOL]         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); [EOL]         fdf = getInstance("Z"); [EOL]         assertEquals("-0500", fdf.format(date1)); [EOL]         assertEquals("-0500", fdf.format(cal1)); [EOL]         assertEquals("-0500", fdf.format(millis1)); [EOL]         assertEquals("-0400", fdf.format(date2)); [EOL]         assertEquals("-0400", fdf.format(cal2)); [EOL]         assertEquals("-0400", fdf.format(millis2)); [EOL]         fdf = getInstance("ZZ"); [EOL]         assertEquals("-05:00", fdf.format(date1)); [EOL]         assertEquals("-05:00", fdf.format(cal1)); [EOL]         assertEquals("-05:00", fdf.format(millis1)); [EOL]         assertEquals("-04:00", fdf.format(date2)); [EOL]         assertEquals("-04:00", fdf.format(cal2)); [EOL]         assertEquals("-04:00", fdf.format(millis2)); [EOL]         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; [EOL]         fdf = getInstance(pattern); [EOL]         sdf = new SimpleDateFormat(pattern); [EOL]         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); [EOL]         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); [EOL]     } finally { [EOL]         Locale.setDefault(realDefaultLocale); [EOL]         TimeZone.setDefault(realDefaultZone); [EOL]     } [EOL] } <line_num>: 73,127
@Test [EOL] public void testShortDateStyleWithLocales() { [EOL]     final Locale usLocale = Locale.US; [EOL]     final Locale swedishLocale = new Locale("sv", "SE"); [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     cal.set(2004, 1, 3); [EOL]     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); [EOL]     assertEquals("2/3/04", fdf.format(cal)); [EOL]     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); [EOL]     assertEquals("2004-02-03", fdf.format(cal)); [EOL] } <line_num>: 132,144
@Test [EOL] public void testLowYearPadding() { [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     final DatePrinter format = getInstance(YYYY_MM_DD); [EOL]     cal.set(1, 0, 1); [EOL]     assertEquals("0001/01/01", format.format(cal)); [EOL]     cal.set(10, 0, 1); [EOL]     assertEquals("0010/01/01", format.format(cal)); [EOL]     cal.set(100, 0, 1); [EOL]     assertEquals("0100/01/01", format.format(cal)); [EOL]     cal.set(999, 0, 1); [EOL]     assertEquals("0999/01/01", format.format(cal)); [EOL] } <line_num>: 149,162
@Test [EOL] public void testMilleniumBug() { [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     final DatePrinter format = getInstance("dd.MM.yyyy"); [EOL]     cal.set(1000, 0, 1); [EOL]     assertEquals("01.01.1000", format.format(cal)); [EOL] } <line_num>: 166,173
@Test [EOL] public void testSimpleDate() { [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     final DatePrinter format = getInstance(YYYY_MM_DD); [EOL]     cal.set(2004, 11, 31); [EOL]     assertEquals("2004/12/31", format.format(cal)); [EOL]     cal.set(999, 11, 31); [EOL]     assertEquals("0999/12/31", format.format(cal)); [EOL]     cal.set(1, 2, 2); [EOL]     assertEquals("0001/03/02", format.format(cal)); [EOL] } <line_num>: 179,190
@Test [EOL] public void testLang303() { [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     cal.set(2004, 11, 31); [EOL]     DatePrinter format = getInstance(YYYY_MM_DD); [EOL]     final String output = format.format(cal); [EOL]     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); [EOL]     assertEquals(output, format.format(cal)); [EOL] } <line_num>: 192,202
@Test [EOL] public void testLang538() { [EOL]     final GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT-8")); [EOL]     cal.clear(); [EOL]     cal.set(2009, 9, 16, 8, 42, 16); [EOL]     final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("GMT")); [EOL]     assertEquals("dateTime", "2009-10-16T16:42:16.000Z", format.format(cal.getTime())); [EOL]     assertEquals("dateTime", "2009-10-16T08:42:16.000Z", format.format(cal)); [EOL] } <line_num>: 204,215
@Test [EOL] public void testLang645() { [EOL]     final Locale locale = new Locale("sv", "SE"); [EOL]     final Calendar cal = Calendar.getInstance(); [EOL]     cal.set(2010, 0, 1, 12, 0, 0); [EOL]     final Date d = cal.getTime(); [EOL]     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); [EOL]     assertEquals("fredag, week 53", fdf.format(d)); [EOL] } <line_num>: 217,228
@Test [EOL] public void testEquals() { [EOL]     final DatePrinter printer1 = getInstance(YYYY_MM_DD); [EOL]     final DatePrinter printer2 = getInstance(YYYY_MM_DD); [EOL]     assertEquals(printer1, printer2); [EOL]     assertEquals(printer1.hashCode(), printer2.hashCode()); [EOL]     assertFalse(printer1.equals(new Object())); [EOL] } <line_num>: 230,239
@Test [EOL] public void testToStringContainsName() { [EOL]     final DatePrinter printer = getInstance(YYYY_MM_DD); [EOL]     assertTrue(printer.toString().startsWith("FastDate")); [EOL] } <line_num>: 241,245
@Test [EOL] public void testPatternMatches() { [EOL]     final DatePrinter printer = getInstance(YYYY_MM_DD); [EOL]     assertEquals(YYYY_MM_DD, printer.getPattern()); [EOL] } <line_num>: 247,251
@Test [EOL] public void testLocaleMatches() { [EOL]     final DatePrinter printer = getInstance(YYYY_MM_DD, SWEDEN); [EOL]     assertEquals(SWEDEN, printer.getLocale()); [EOL] } <line_num>: 253,257
@Test [EOL] public void testTimeZoneMatches() { [EOL]     final DatePrinter printer = getInstance(YYYY_MM_DD, NEW_YORK); [EOL]     assertEquals(NEW_YORK, printer.getTimeZone()); [EOL] } <line_num>: 259,263
@Test [EOL] public void testCalendarTimezoneRespected() { [EOL] } <line_num>: 265,266