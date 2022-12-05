public TestGJDate(String name) { [EOL]     super(name); [EOL] } <line_num>: 38,40
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 30,32
public static TestSuite suite() { [EOL]     return new TestSuite(TestGJDate.class); [EOL] } <line_num>: 34,36
protected void setUp() throws Exception { [EOL] } <line_num>: 42,43
protected void tearDown() throws Exception { [EOL] } <line_num>: 45,46
public void test_plusYears_positiveToPositive() { [EOL]     LocalDate date = new LocalDate(3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(7, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(4)); [EOL] } <line_num>: 52,56
public void test_plusYears_positiveToZero() { [EOL]     LocalDate date = new LocalDate(3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(-1, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(-3)); [EOL] } <line_num>: 58,62
public void test_plusYears_positiveToNegative() { [EOL]     LocalDate date = new LocalDate(3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(-2, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(-4)); [EOL] } <line_num>: 64,68
public void test_plusYears_negativeToNegative() { [EOL]     LocalDate date = new LocalDate(-3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(-1, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(2)); [EOL] } <line_num>: 71,75
public void test_plusYears_negativeToZero() { [EOL]     LocalDate date = new LocalDate(-3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(1, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(3)); [EOL] } <line_num>: 77,81
public void test_plusYears_negativeToPositive() { [EOL]     LocalDate date = new LocalDate(-3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(2, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(4)); [EOL] } <line_num>: 83,87
public void test_plusYears_positiveToPositive_crossCutover() { [EOL]     LocalDate date = new LocalDate(3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(2007, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(2004)); [EOL] } <line_num>: 90,94
public void test_plusYears_positiveToZero_crossCutover() { [EOL]     LocalDate date = new LocalDate(2003, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(-1, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(-2003)); [EOL] } <line_num>: 96,100
public void test_plusYears_positiveToNegative_crossCutover() { [EOL]     LocalDate date = new LocalDate(2003, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(-2, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(-2004)); [EOL] } <line_num>: 102,106
public void test_plusYears_negativeToPositive_crossCutover() { [EOL]     LocalDate date = new LocalDate(-3, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(2002, 6, 30, GJ_CHRONOLOGY); [EOL]     assertEquals(expected, date.plusYears(2004)); [EOL] } <line_num>: 108,112
public void test_plusWeekyears_positiveToZero_crossCutover() { [EOL]     LocalDate date = new LocalDate(2003, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(-1, 6, 30, GJ_CHRONOLOGY).withWeekOfWeekyear(date.getWeekOfWeekyear()).withDayOfWeek(date.getDayOfWeek()); [EOL]     assertEquals(expected, date.weekyear().addToCopy(-2003)); [EOL] } <line_num>: 115,119
public void test_plusWeekyears_positiveToNegative_crossCutover() { [EOL]     LocalDate date = new LocalDate(2003, 6, 30, GJ_CHRONOLOGY); [EOL]     LocalDate expected = new LocalDate(-2, 6, 30, GJ_CHRONOLOGY).withWeekOfWeekyear(date.getWeekOfWeekyear()).withDayOfWeek(date.getDayOfWeek()); [EOL]     assertEquals(expected, date.weekyear().addToCopy(-2004)); [EOL] } <line_num>: 121,125
public void test_cutoverPreZero() { [EOL]     DateTime cutover = new LocalDate(-2, 6, 30, ISOChronology.getInstanceUTC()).toDateTimeAtStartOfDay(DateTimeZone.UTC); [EOL]     try { [EOL]         GJChronology.getInstance(DateTimeZone.UTC, cutover); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 128,136
