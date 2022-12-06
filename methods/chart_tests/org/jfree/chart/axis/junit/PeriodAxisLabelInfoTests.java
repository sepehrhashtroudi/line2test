public PeriodAxisLabelInfoTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 87,89
public static Test suite() { [EOL]     return new TestSuite(PeriodAxisLabelInfoTests.class); [EOL] } <line_num>: 78,80
public void testEquals() { [EOL]     PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")); [EOL]     PeriodAxisLabelInfo info2 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")); [EOL]     assertTrue(info1.equals(info2)); [EOL]     assertTrue(info2.equals(info1)); [EOL]     Class c1 = Day.class; [EOL]     Class c2 = Month.class; [EOL]     DateFormat df1 = new SimpleDateFormat("d"); [EOL]     DateFormat df2 = new SimpleDateFormat("MMM"); [EOL]     RectangleInsets sp1 = new RectangleInsets(1, 1, 1, 1); [EOL]     RectangleInsets sp2 = new RectangleInsets(2, 2, 2, 2); [EOL]     Font lf1 = new Font("SansSerif", Font.PLAIN, 10); [EOL]     Font lf2 = new Font("SansSerif", Font.BOLD, 9); [EOL]     Paint lp1 = Color.black; [EOL]     Paint lp2 = Color.blue; [EOL]     boolean b1 = true; [EOL]     boolean b2 = false; [EOL]     Stroke s1 = new BasicStroke(0.5f); [EOL]     Stroke s2 = new BasicStroke(0.25f); [EOL]     Paint dp1 = Color.red; [EOL]     Paint dp2 = Color.green; [EOL]     info1 = new PeriodAxisLabelInfo(c2, df1, sp1, lf1, lp1, b1, s1, dp1); [EOL]     info2 = new PeriodAxisLabelInfo(c1, df1, sp1, lf1, lp1, b1, s1, dp1); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df1, sp1, lf1, lp1, b1, s1, dp1); [EOL]     assertTrue(info1.equals(info2)); [EOL]     info1 = new PeriodAxisLabelInfo(c2, df2, sp1, lf1, lp1, b1, s1, dp1); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df2, sp1, lf1, lp1, b1, s1, dp1); [EOL]     assertTrue(info1.equals(info2)); [EOL]     info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf1, lp1, b1, s1, dp1); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf1, lp1, b1, s1, dp1); [EOL]     assertTrue(info1.equals(info2)); [EOL]     info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp1, b1, s1, dp1); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp1, b1, s1, dp1); [EOL]     assertTrue(info1.equals(info2)); [EOL]     info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b1, s1, dp1); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b1, s1, dp1); [EOL]     assertTrue(info1.equals(info2)); [EOL]     info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s1, dp1); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s1, dp1); [EOL]     assertTrue(info1.equals(info2)); [EOL]     info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp1); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp1); [EOL]     assertTrue(info1.equals(info2)); [EOL]     info1 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp2); [EOL]     assertFalse(info1.equals(info2)); [EOL]     info2 = new PeriodAxisLabelInfo(c2, df2, sp2, lf2, lp2, b2, s2, dp2); [EOL]     assertTrue(info1.equals(info2)); [EOL] } <line_num>: 94,160
public void testHashCode() { [EOL]     PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")); [EOL]     PeriodAxisLabelInfo info2 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")); [EOL]     assertTrue(info1.equals(info2)); [EOL]     int h1 = info1.hashCode(); [EOL]     int h2 = info2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 165,174
public void testCloning() { [EOL]     PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")); [EOL]     PeriodAxisLabelInfo info2 = null; [EOL]     try { [EOL]         info2 = (PeriodAxisLabelInfo) info1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(info1 != info2); [EOL]     assertTrue(info1.getClass() == info2.getClass()); [EOL]     assertTrue(info1.equals(info2)); [EOL] } <line_num>: 179,192
public void testSerialization() { [EOL]     PeriodAxisLabelInfo info1 = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")); [EOL]     PeriodAxisLabelInfo info2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(info1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         info2 = (PeriodAxisLabelInfo) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     boolean b = info1.equals(info2); [EOL]     assertTrue(b); [EOL] } <line_num>: 197,217