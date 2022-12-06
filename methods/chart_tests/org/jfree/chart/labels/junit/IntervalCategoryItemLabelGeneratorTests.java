public IntervalCategoryItemLabelGeneratorTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 81,83
public static Test suite() { [EOL]     return new TestSuite(IntervalCategoryItemLabelGeneratorTests.class); [EOL] } <line_num>: 72,74
public void testEquals() { [EOL]     IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator(); [EOL]     IntervalCategoryItemLabelGenerator g2 = new IntervalCategoryItemLabelGenerator(); [EOL]     assertTrue(g1.equals(g2)); [EOL]     assertTrue(g2.equals(g1)); [EOL]     g1 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new DecimalFormat("0.000")); [EOL]     assertFalse(g1.equals(g2)); [EOL]     g2 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new DecimalFormat("0.000")); [EOL]     assertTrue(g1.equals(g2)); [EOL]     g1 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new SimpleDateFormat("d-MMM")); [EOL]     assertFalse(g1.equals(g2)); [EOL]     g2 = new IntervalCategoryItemLabelGenerator("{3} - {4}", new SimpleDateFormat("d-MMM")); [EOL]     assertTrue(g1.equals(g2)); [EOL] } <line_num>: 88,109
public void testHashCode() { [EOL]     IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator(); [EOL]     IntervalCategoryItemLabelGenerator g2 = new IntervalCategoryItemLabelGenerator(); [EOL]     assertTrue(g1.equals(g2)); [EOL]     assertTrue(g1.hashCode() == g2.hashCode()); [EOL] } <line_num>: 114,121
public void testCloning() { [EOL]     IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator(); [EOL]     IntervalCategoryItemLabelGenerator g2 = null; [EOL]     try { [EOL]         g2 = (IntervalCategoryItemLabelGenerator) g1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(g1 != g2); [EOL]     assertTrue(g1.getClass() == g2.getClass()); [EOL]     assertTrue(g1.equals(g2)); [EOL] } <line_num>: 126,139
public void testPublicCloneable() { [EOL]     IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator(); [EOL]     assertTrue(g1 instanceof PublicCloneable); [EOL] } <line_num>: 144,148
public void testSerialization() { [EOL]     IntervalCategoryItemLabelGenerator g1 = new IntervalCategoryItemLabelGenerator("{3} - {4}", DateFormat.getInstance()); [EOL]     IntervalCategoryItemLabelGenerator g2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(g1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         g2 = (IntervalCategoryItemLabelGenerator) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(g1, g2); [EOL] } <line_num>: 153,176