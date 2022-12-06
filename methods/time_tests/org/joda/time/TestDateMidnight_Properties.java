public TestDateMidnight_Properties(String name) { [EOL]     super(name); [EOL] } <line_num>: 80,82
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 72,74
public static TestSuite suite() { [EOL]     return new TestSuite(TestDateMidnight_Properties.class); [EOL] } <line_num>: 76,78
protected void setUp() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]     zone = DateTimeZone.getDefault(); [EOL]     locale = Locale.getDefault(); [EOL]     DateTimeZone.setDefault(LONDON); [EOL]     Locale.setDefault(Locale.UK); [EOL] } <line_num>: 84,90
protected void tearDown() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisSystem(); [EOL]     DateTimeZone.setDefault(zone); [EOL]     Locale.setDefault(locale); [EOL]     zone = null; [EOL] } <line_num>: 92,97
public void testTest() { [EOL]     assertEquals("2002-06-09T00:00:00.000Z", new Instant(TEST_TIME_NOW).toString()); [EOL]     assertEquals("2002-04-05T12:24:00.000Z", new Instant(TEST_TIME1).toString()); [EOL]     assertEquals("2003-05-06T14:28:00.000Z", new Instant(TEST_TIME2).toString()); [EOL] } <line_num>: 100,104
public void testPropertyGetEra() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().era(), test.era().getField()); [EOL]     assertEquals("era", test.era().getName()); [EOL]     assertEquals("Property[era]", test.era().toString()); [EOL]     assertSame(test, test.era().getDateMidnight()); [EOL]     assertEquals(1, test.era().get()); [EOL]     assertEquals("AD", test.era().getAsText()); [EOL]     assertEquals("ap. J.-C.", test.era().getAsText(Locale.FRENCH)); [EOL]     assertEquals("AD", test.era().getAsShortText()); [EOL]     assertEquals("ap. J.-C.", test.era().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().eras(), test.era().getDurationField()); [EOL]     assertEquals(null, test.era().getRangeDurationField()); [EOL]     assertEquals(2, test.era().getMaximumTextLength(null)); [EOL]     assertEquals(9, test.era().getMaximumTextLength(Locale.FRENCH)); [EOL]     assertEquals(2, test.era().getMaximumShortTextLength(null)); [EOL]     assertEquals(9, test.era().getMaximumShortTextLength(Locale.FRENCH)); [EOL] } <line_num>: 107,124
public void testPropertyGetYearOfEra() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().yearOfEra(), test.yearOfEra().getField()); [EOL]     assertEquals("yearOfEra", test.yearOfEra().getName()); [EOL]     assertEquals("Property[yearOfEra]", test.yearOfEra().toString()); [EOL]     assertSame(test, test.yearOfEra().getDateMidnight()); [EOL]     assertEquals(2004, test.yearOfEra().get()); [EOL]     assertEquals("2004", test.yearOfEra().getAsText()); [EOL]     assertEquals("2004", test.yearOfEra().getAsText(Locale.FRENCH)); [EOL]     assertEquals("2004", test.yearOfEra().getAsShortText()); [EOL]     assertEquals("2004", test.yearOfEra().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().years(), test.yearOfEra().getDurationField()); [EOL]     assertEquals(test.getChronology().eras(), test.yearOfEra().getRangeDurationField()); [EOL]     assertEquals(9, test.yearOfEra().getMaximumTextLength(null)); [EOL]     assertEquals(9, test.yearOfEra().getMaximumShortTextLength(null)); [EOL] } <line_num>: 127,142
public void testPropertyGetCenturyOfEra() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().centuryOfEra(), test.centuryOfEra().getField()); [EOL]     assertEquals("centuryOfEra", test.centuryOfEra().getName()); [EOL]     assertEquals("Property[centuryOfEra]", test.centuryOfEra().toString()); [EOL]     assertSame(test, test.centuryOfEra().getDateMidnight()); [EOL]     assertEquals(20, test.centuryOfEra().get()); [EOL]     assertEquals("20", test.centuryOfEra().getAsText()); [EOL]     assertEquals("20", test.centuryOfEra().getAsText(Locale.FRENCH)); [EOL]     assertEquals("20", test.centuryOfEra().getAsShortText()); [EOL]     assertEquals("20", test.centuryOfEra().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().centuries(), test.centuryOfEra().getDurationField()); [EOL]     assertEquals(test.getChronology().eras(), test.centuryOfEra().getRangeDurationField()); [EOL]     assertEquals(7, test.centuryOfEra().getMaximumTextLength(null)); [EOL]     assertEquals(7, test.centuryOfEra().getMaximumShortTextLength(null)); [EOL] } <line_num>: 145,160
public void testPropertyGetYearOfCentury() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().yearOfCentury(), test.yearOfCentury().getField()); [EOL]     assertEquals("yearOfCentury", test.yearOfCentury().getName()); [EOL]     assertEquals("Property[yearOfCentury]", test.yearOfCentury().toString()); [EOL]     assertSame(test, test.yearOfCentury().getDateMidnight()); [EOL]     assertEquals(4, test.yearOfCentury().get()); [EOL]     assertEquals("4", test.yearOfCentury().getAsText()); [EOL]     assertEquals("4", test.yearOfCentury().getAsText(Locale.FRENCH)); [EOL]     assertEquals("4", test.yearOfCentury().getAsShortText()); [EOL]     assertEquals("4", test.yearOfCentury().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().years(), test.yearOfCentury().getDurationField()); [EOL]     assertEquals(test.getChronology().centuries(), test.yearOfCentury().getRangeDurationField()); [EOL]     assertEquals(2, test.yearOfCentury().getMaximumTextLength(null)); [EOL]     assertEquals(2, test.yearOfCentury().getMaximumShortTextLength(null)); [EOL] } <line_num>: 163,178
public void testPropertyGetWeekyear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().weekyear(), test.weekyear().getField()); [EOL]     assertEquals("weekyear", test.weekyear().getName()); [EOL]     assertEquals("Property[weekyear]", test.weekyear().toString()); [EOL]     assertSame(test, test.weekyear().getDateMidnight()); [EOL]     assertEquals(2004, test.weekyear().get()); [EOL]     assertEquals("2004", test.weekyear().getAsText()); [EOL]     assertEquals("2004", test.weekyear().getAsText(Locale.FRENCH)); [EOL]     assertEquals("2004", test.weekyear().getAsShortText()); [EOL]     assertEquals("2004", test.weekyear().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().weekyears(), test.weekyear().getDurationField()); [EOL]     assertEquals(null, test.weekyear().getRangeDurationField()); [EOL]     assertEquals(9, test.weekyear().getMaximumTextLength(null)); [EOL]     assertEquals(9, test.weekyear().getMaximumShortTextLength(null)); [EOL] } <line_num>: 181,196
public void testPropertyGetYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().year(), test.year().getField()); [EOL]     assertEquals("year", test.year().getName()); [EOL]     assertEquals("Property[year]", test.year().toString()); [EOL]     assertSame(test, test.year().getDateMidnight()); [EOL]     assertEquals(2004, test.year().get()); [EOL]     assertEquals("2004", test.year().getAsText()); [EOL]     assertEquals("2004", test.year().getAsText(Locale.FRENCH)); [EOL]     assertEquals("2004", test.year().getAsShortText()); [EOL]     assertEquals("2004", test.year().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().years(), test.year().getDurationField()); [EOL]     assertEquals(null, test.year().getRangeDurationField()); [EOL]     assertEquals(9, test.year().getMaximumTextLength(null)); [EOL]     assertEquals(9, test.year().getMaximumShortTextLength(null)); [EOL]     assertEquals(-292275054, test.year().getMinimumValue()); [EOL]     assertEquals(-292275054, test.year().getMinimumValueOverall()); [EOL]     assertEquals(292278993, test.year().getMaximumValue()); [EOL]     assertEquals(292278993, test.year().getMaximumValueOverall()); [EOL] } <line_num>: 199,218
public void testPropertyGetMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().monthOfYear(), test.monthOfYear().getField()); [EOL]     assertEquals("monthOfYear", test.monthOfYear().getName()); [EOL]     assertEquals("Property[monthOfYear]", test.monthOfYear().toString()); [EOL]     assertSame(test, test.monthOfYear().getDateMidnight()); [EOL]     assertEquals(6, test.monthOfYear().get()); [EOL]     assertEquals("6", test.monthOfYear().getAsString()); [EOL]     assertEquals("June", test.monthOfYear().getAsText()); [EOL]     assertEquals("juin", test.monthOfYear().getAsText(Locale.FRENCH)); [EOL]     assertEquals("Jun", test.monthOfYear().getAsShortText()); [EOL]     assertEquals("juin", test.monthOfYear().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().months(), test.monthOfYear().getDurationField()); [EOL]     assertEquals(test.getChronology().years(), test.monthOfYear().getRangeDurationField()); [EOL]     assertEquals(9, test.monthOfYear().getMaximumTextLength(null)); [EOL]     assertEquals(3, test.monthOfYear().getMaximumShortTextLength(null)); [EOL]     test = new DateMidnight(2004, 7, 9); [EOL]     assertEquals("juillet", test.monthOfYear().getAsText(Locale.FRENCH)); [EOL]     assertEquals("juil.", test.monthOfYear().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(1, test.monthOfYear().getMinimumValue()); [EOL]     assertEquals(1, test.monthOfYear().getMinimumValueOverall()); [EOL]     assertEquals(12, test.monthOfYear().getMaximumValue()); [EOL]     assertEquals(12, test.monthOfYear().getMaximumValueOverall()); [EOL]     assertEquals(1, test.monthOfYear().getMinimumValue()); [EOL]     assertEquals(1, test.monthOfYear().getMinimumValueOverall()); [EOL]     assertEquals(12, test.monthOfYear().getMaximumValue()); [EOL]     assertEquals(12, test.monthOfYear().getMaximumValueOverall()); [EOL] } <line_num>: 221,248
public void testPropertySetMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.monthOfYear().setCopy(8); [EOL]     assertEquals(2004, copy.getYear()); [EOL]     assertEquals(8, copy.getMonthOfYear()); [EOL]     assertEquals(9, copy.getDayOfMonth()); [EOL] } <line_num>: 250,256
public void testPropertySetTextMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.monthOfYear().setCopy("8"); [EOL]     assertEquals(2004, copy.getYear()); [EOL]     assertEquals(8, copy.getMonthOfYear()); [EOL]     assertEquals(9, copy.getDayOfMonth()); [EOL] } <line_num>: 258,264
public void testPropertySetTextLocaleMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.monthOfYear().setCopy("mars", Locale.FRENCH); [EOL]     assertEquals(2004, copy.getYear()); [EOL]     assertEquals(3, copy.getMonthOfYear()); [EOL]     assertEquals(9, copy.getDayOfMonth()); [EOL] } <line_num>: 266,272
public void testPropertyAddMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.monthOfYear().addToCopy(8); [EOL]     assertEquals(2005, copy.getYear()); [EOL]     assertEquals(2, copy.getMonthOfYear()); [EOL]     assertEquals(9, copy.getDayOfMonth()); [EOL] } <line_num>: 274,280
public void testPropertyAddLongMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.monthOfYear().addToCopy(8L); [EOL]     assertEquals(2005, copy.getYear()); [EOL]     assertEquals(2, copy.getMonthOfYear()); [EOL]     assertEquals(9, copy.getDayOfMonth()); [EOL] } <line_num>: 282,288
public void testPropertyAddWrapFieldMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.monthOfYear().addWrapFieldToCopy(8); [EOL]     assertEquals(2004, copy.getYear()); [EOL]     assertEquals(2, copy.getMonthOfYear()); [EOL]     assertEquals(9, copy.getDayOfMonth()); [EOL] } <line_num>: 290,296
public void testPropertyGetDifferenceMonthOfYear() { [EOL]     DateMidnight test1 = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight test2 = new DateMidnight(2004, 8, 9); [EOL]     assertEquals(-2, test1.monthOfYear().getDifference(test2)); [EOL]     assertEquals(2, test2.monthOfYear().getDifference(test1)); [EOL]     assertEquals(-2L, test1.monthOfYear().getDifferenceAsLong(test2)); [EOL]     assertEquals(2L, test2.monthOfYear().getDifferenceAsLong(test1)); [EOL] } <line_num>: 298,305
public void testPropertyRoundFloorMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 16); [EOL]     DateMidnight copy = test.monthOfYear().roundFloorCopy(); [EOL]     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); [EOL] } <line_num>: 307,311
public void testPropertyRoundCeilingMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 16); [EOL]     DateMidnight copy = test.monthOfYear().roundCeilingCopy(); [EOL]     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); [EOL] } <line_num>: 313,317
public void testPropertyRoundHalfFloorMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 16); [EOL]     DateMidnight copy = test.monthOfYear().roundHalfFloorCopy(); [EOL]     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); [EOL]     test = new DateMidnight(2004, 6, 17); [EOL]     copy = test.monthOfYear().roundHalfFloorCopy(); [EOL]     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); [EOL]     test = new DateMidnight(2004, 6, 15); [EOL]     copy = test.monthOfYear().roundHalfFloorCopy(); [EOL]     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); [EOL] } <line_num>: 319,331
public void testPropertyRoundHalfCeilingMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 16); [EOL]     DateMidnight copy = test.monthOfYear().roundHalfCeilingCopy(); [EOL]     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); [EOL]     test = new DateMidnight(2004, 6, 17); [EOL]     copy = test.monthOfYear().roundHalfCeilingCopy(); [EOL]     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); [EOL]     test = new DateMidnight(2004, 6, 15); [EOL]     copy = test.monthOfYear().roundHalfCeilingCopy(); [EOL]     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); [EOL] } <line_num>: 333,345
public void testPropertyRoundHalfEvenMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 16); [EOL]     DateMidnight copy = test.monthOfYear().roundHalfEvenCopy(); [EOL]     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); [EOL]     test = new DateMidnight(2004, 9, 16); [EOL]     copy = test.monthOfYear().roundHalfEvenCopy(); [EOL]     assertEquals("2004-10-01T00:00:00.000+01:00", copy.toString()); [EOL]     test = new DateMidnight(2004, 6, 17); [EOL]     copy = test.monthOfYear().roundHalfEvenCopy(); [EOL]     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); [EOL]     test = new DateMidnight(2004, 6, 15); [EOL]     copy = test.monthOfYear().roundHalfEvenCopy(); [EOL]     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); [EOL] } <line_num>: 347,363
public void testPropertyRemainderMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertEquals((9L - 1L) * DateTimeConstants.MILLIS_PER_DAY, test.monthOfYear().remainder()); [EOL] } <line_num>: 365,368
public void testPropertyGetDayOfMonth() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().dayOfMonth(), test.dayOfMonth().getField()); [EOL]     assertEquals("dayOfMonth", test.dayOfMonth().getName()); [EOL]     assertEquals("Property[dayOfMonth]", test.dayOfMonth().toString()); [EOL]     assertSame(test, test.dayOfMonth().getDateMidnight()); [EOL]     assertEquals(9, test.dayOfMonth().get()); [EOL]     assertEquals("9", test.dayOfMonth().getAsText()); [EOL]     assertEquals("9", test.dayOfMonth().getAsText(Locale.FRENCH)); [EOL]     assertEquals("9", test.dayOfMonth().getAsShortText()); [EOL]     assertEquals("9", test.dayOfMonth().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().days(), test.dayOfMonth().getDurationField()); [EOL]     assertEquals(test.getChronology().months(), test.dayOfMonth().getRangeDurationField()); [EOL]     assertEquals(2, test.dayOfMonth().getMaximumTextLength(null)); [EOL]     assertEquals(2, test.dayOfMonth().getMaximumShortTextLength(null)); [EOL]     assertEquals(1, test.dayOfMonth().getMinimumValue()); [EOL]     assertEquals(1, test.dayOfMonth().getMinimumValueOverall()); [EOL]     assertEquals(30, test.dayOfMonth().getMaximumValue()); [EOL]     assertEquals(31, test.dayOfMonth().getMaximumValueOverall()); [EOL]     assertEquals(false, test.dayOfMonth().isLeap()); [EOL]     assertEquals(0, test.dayOfMonth().getLeapAmount()); [EOL]     assertEquals(null, test.dayOfMonth().getLeapDurationField()); [EOL] } <line_num>: 371,393
public void testPropertyWithMaximumValueDayOfMonth() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.dayOfMonth().withMaximumValue(); [EOL]     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); [EOL]     assertEquals("2004-06-30T00:00:00.000+01:00", copy.toString()); [EOL] } <line_num>: 395,400
public void testPropertyWithMinimumValueDayOfMonth() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     DateMidnight copy = test.dayOfMonth().withMinimumValue(); [EOL]     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); [EOL]     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); [EOL] } <line_num>: 402,407
public void testPropertyGetDayOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().dayOfYear(), test.dayOfYear().getField()); [EOL]     assertEquals("dayOfYear", test.dayOfYear().getName()); [EOL]     assertEquals("Property[dayOfYear]", test.dayOfYear().toString()); [EOL]     assertSame(test, test.dayOfYear().getDateMidnight()); [EOL]     assertEquals(161, test.dayOfYear().get()); [EOL]     assertEquals("161", test.dayOfYear().getAsText()); [EOL]     assertEquals("161", test.dayOfYear().getAsText(Locale.FRENCH)); [EOL]     assertEquals("161", test.dayOfYear().getAsShortText()); [EOL]     assertEquals("161", test.dayOfYear().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().days(), test.dayOfYear().getDurationField()); [EOL]     assertEquals(test.getChronology().years(), test.dayOfYear().getRangeDurationField()); [EOL]     assertEquals(3, test.dayOfYear().getMaximumTextLength(null)); [EOL]     assertEquals(3, test.dayOfYear().getMaximumShortTextLength(null)); [EOL]     assertEquals(false, test.dayOfYear().isLeap()); [EOL]     assertEquals(0, test.dayOfYear().getLeapAmount()); [EOL]     assertEquals(null, test.dayOfYear().getLeapDurationField()); [EOL] } <line_num>: 410,429
public void testPropertyGetWeekOfWeekyear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().weekOfWeekyear(), test.weekOfWeekyear().getField()); [EOL]     assertEquals("weekOfWeekyear", test.weekOfWeekyear().getName()); [EOL]     assertEquals("Property[weekOfWeekyear]", test.weekOfWeekyear().toString()); [EOL]     assertSame(test, test.weekOfWeekyear().getDateMidnight()); [EOL]     assertEquals(24, test.weekOfWeekyear().get()); [EOL]     assertEquals("24", test.weekOfWeekyear().getAsText()); [EOL]     assertEquals("24", test.weekOfWeekyear().getAsText(Locale.FRENCH)); [EOL]     assertEquals("24", test.weekOfWeekyear().getAsShortText()); [EOL]     assertEquals("24", test.weekOfWeekyear().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().weeks(), test.weekOfWeekyear().getDurationField()); [EOL]     assertEquals(test.getChronology().weekyears(), test.weekOfWeekyear().getRangeDurationField()); [EOL]     assertEquals(2, test.weekOfWeekyear().getMaximumTextLength(null)); [EOL]     assertEquals(2, test.weekOfWeekyear().getMaximumShortTextLength(null)); [EOL]     assertEquals(false, test.weekOfWeekyear().isLeap()); [EOL]     assertEquals(0, test.weekOfWeekyear().getLeapAmount()); [EOL]     assertEquals(null, test.weekOfWeekyear().getLeapDurationField()); [EOL] } <line_num>: 432,450
public void testPropertyGetDayOfWeek() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     assertSame(test.getChronology().dayOfWeek(), test.dayOfWeek().getField()); [EOL]     assertEquals("dayOfWeek", test.dayOfWeek().getName()); [EOL]     assertEquals("Property[dayOfWeek]", test.dayOfWeek().toString()); [EOL]     assertSame(test, test.dayOfWeek().getDateMidnight()); [EOL]     assertEquals(3, test.dayOfWeek().get()); [EOL]     assertEquals("3", test.dayOfWeek().getAsString()); [EOL]     assertEquals("Wednesday", test.dayOfWeek().getAsText()); [EOL]     assertEquals("mercredi", test.dayOfWeek().getAsText(Locale.FRENCH)); [EOL]     assertEquals("Wed", test.dayOfWeek().getAsShortText()); [EOL]     assertEquals("mer.", test.dayOfWeek().getAsShortText(Locale.FRENCH)); [EOL]     assertEquals(test.getChronology().days(), test.dayOfWeek().getDurationField()); [EOL]     assertEquals(test.getChronology().weeks(), test.dayOfWeek().getRangeDurationField()); [EOL]     assertEquals(9, test.dayOfWeek().getMaximumTextLength(null)); [EOL]     assertEquals(8, test.dayOfWeek().getMaximumTextLength(Locale.FRENCH)); [EOL]     assertEquals(3, test.dayOfWeek().getMaximumShortTextLength(null)); [EOL]     assertEquals(4, test.dayOfWeek().getMaximumShortTextLength(Locale.FRENCH)); [EOL]     assertEquals(1, test.dayOfWeek().getMinimumValue()); [EOL]     assertEquals(1, test.dayOfWeek().getMinimumValueOverall()); [EOL]     assertEquals(7, test.dayOfWeek().getMaximumValue()); [EOL]     assertEquals(7, test.dayOfWeek().getMaximumValueOverall()); [EOL]     assertEquals(false, test.dayOfWeek().isLeap()); [EOL]     assertEquals(0, test.dayOfWeek().getLeapAmount()); [EOL]     assertEquals(null, test.dayOfWeek().getLeapDurationField()); [EOL] } <line_num>: 453,478
public void testPropertyToIntervalYearOfEra() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     Interval testInterval = test.yearOfEra().toInterval(); [EOL]     assertEquals(new DateMidnight(2004, 1, 1), testInterval.getStart()); [EOL]     assertEquals(new DateMidnight(2005, 1, 1), testInterval.getEnd()); [EOL] } <line_num>: 481,486
public void testPropertyToIntervalYearOfCentury() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     Interval testInterval = test.yearOfCentury().toInterval(); [EOL]     assertEquals(new DateMidnight(2004, 1, 1), testInterval.getStart()); [EOL]     assertEquals(new DateMidnight(2005, 1, 1), testInterval.getEnd()); [EOL] } <line_num>: 488,493
public void testPropertyToIntervalYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     Interval testInterval = test.year().toInterval(); [EOL]     assertEquals(new DateMidnight(2004, 1, 1), testInterval.getStart()); [EOL]     assertEquals(new DateMidnight(2005, 1, 1), testInterval.getEnd()); [EOL] } <line_num>: 495,500
public void testPropertyToIntervalMonthOfYear() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     Interval testInterval = test.monthOfYear().toInterval(); [EOL]     assertEquals(new DateMidnight(2004, 6, 1), testInterval.getStart()); [EOL]     assertEquals(new DateMidnight(2004, 7, 1), testInterval.getEnd()); [EOL] } <line_num>: 502,507
public void testPropertyToIntervalDayOfMonth() { [EOL]     DateMidnight test = new DateMidnight(2004, 6, 9); [EOL]     Interval testInterval = test.dayOfMonth().toInterval(); [EOL]     assertEquals(new DateMidnight(2004, 6, 9), testInterval.getStart()); [EOL]     assertEquals(new DateMidnight(2004, 6, 10), testInterval.getEnd()); [EOL]     DateMidnight febTest = new DateMidnight(2004, 2, 29); [EOL]     Interval febTestInterval = febTest.dayOfMonth().toInterval(); [EOL]     assertEquals(new DateMidnight(2004, 2, 29), febTestInterval.getStart()); [EOL]     assertEquals(new DateMidnight(2004, 3, 1), febTestInterval.getEnd()); [EOL] } <line_num>: 509,519
public void testPropertyEqualsHashCodeLenient() { [EOL]     DateMidnight test1 = new DateMidnight(1970, 6, 9, LenientChronology.getInstance(COPTIC_PARIS)); [EOL]     DateMidnight test2 = new DateMidnight(1970, 6, 9, LenientChronology.getInstance(COPTIC_PARIS)); [EOL]     assertEquals(true, test1.dayOfMonth().equals(test2.dayOfMonth())); [EOL]     assertEquals(true, test2.dayOfMonth().equals(test1.dayOfMonth())); [EOL]     assertEquals(true, test1.dayOfMonth().equals(test1.dayOfMonth())); [EOL]     assertEquals(true, test2.dayOfMonth().equals(test2.dayOfMonth())); [EOL]     assertEquals(true, test1.dayOfMonth().hashCode() == test2.dayOfMonth().hashCode()); [EOL]     assertEquals(true, test1.dayOfMonth().hashCode() == test1.dayOfMonth().hashCode()); [EOL]     assertEquals(true, test2.dayOfMonth().hashCode() == test2.dayOfMonth().hashCode()); [EOL] } <line_num>: 521,531
public void testPropertyEqualsHashCodeStrict() { [EOL]     DateMidnight test1 = new DateMidnight(1970, 6, 9, StrictChronology.getInstance(COPTIC_PARIS)); [EOL]     DateMidnight test2 = new DateMidnight(1970, 6, 9, StrictChronology.getInstance(COPTIC_PARIS)); [EOL]     assertEquals(true, test1.dayOfMonth().equals(test2.dayOfMonth())); [EOL]     assertEquals(true, test2.dayOfMonth().equals(test1.dayOfMonth())); [EOL]     assertEquals(true, test1.dayOfMonth().equals(test1.dayOfMonth())); [EOL]     assertEquals(true, test2.dayOfMonth().equals(test2.dayOfMonth())); [EOL]     assertEquals(true, test1.dayOfMonth().hashCode() == test2.dayOfMonth().hashCode()); [EOL]     assertEquals(true, test1.dayOfMonth().hashCode() == test1.dayOfMonth().hashCode()); [EOL]     assertEquals(true, test2.dayOfMonth().hashCode() == test2.dayOfMonth().hashCode()); [EOL] } <line_num>: 533,543