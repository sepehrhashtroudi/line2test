public QuarterDateFormatTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 77,79
public static Test suite() { [EOL]     return new TestSuite(QuarterDateFormatTests.class); [EOL] } <line_num>: 68,70
public void testEquals() { [EOL]     QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" }); [EOL]     QuarterDateFormat qf2 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" }); [EOL]     assertTrue(qf1.equals(qf2)); [EOL]     assertTrue(qf2.equals(qf1)); [EOL]     qf1 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "1", "2", "3", "4" }); [EOL]     assertFalse(qf1.equals(qf2)); [EOL]     qf2 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "1", "2", "3", "4" }); [EOL]     assertTrue(qf1.equals(qf2)); [EOL]     qf1 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" }); [EOL]     assertFalse(qf1.equals(qf2)); [EOL]     qf2 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" }); [EOL]     assertTrue(qf1.equals(qf2)); [EOL]     qf1 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" }, true); [EOL]     assertFalse(qf1.equals(qf2)); [EOL]     qf2 = new QuarterDateFormat(TimeZone.getTimeZone("PST"), new String[] { "A", "2", "3", "4" }, true); [EOL]     assertTrue(qf1.equals(qf2)); [EOL] } <line_num>: 84,112
public void testHashCode() { [EOL]     QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" }); [EOL]     QuarterDateFormat qf2 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" }); [EOL]     assertTrue(qf1.equals(qf2)); [EOL]     int h1 = qf1.hashCode(); [EOL]     int h2 = qf2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 117,126
public void testCloning() { [EOL]     QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" }); [EOL]     QuarterDateFormat qf2 = null; [EOL]     qf2 = (QuarterDateFormat) qf1.clone(); [EOL]     assertTrue(qf1 != qf2); [EOL]     assertTrue(qf1.getClass() == qf2.getClass()); [EOL]     assertTrue(qf1.equals(qf2)); [EOL] } <line_num>: 131,139
public void testSerialization() { [EOL]     QuarterDateFormat qf1 = new QuarterDateFormat(TimeZone.getTimeZone("GMT"), new String[] { "1", "2", "3", "4" }); [EOL]     QuarterDateFormat qf2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(qf1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         qf2 = (QuarterDateFormat) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         fail(e.toString()); [EOL]     } [EOL]     assertTrue(qf1.equals(qf2)); [EOL] } <line_num>: 144,163