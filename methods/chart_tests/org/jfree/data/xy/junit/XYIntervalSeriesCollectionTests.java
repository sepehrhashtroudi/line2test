public XYIntervalSeriesCollectionTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 80,82
public static Test suite() { [EOL]     return new TestSuite(XYIntervalSeriesCollectionTests.class); [EOL] } <line_num>: 71,73
public void testEquals() { [EOL]     XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection(); [EOL]     XYIntervalSeriesCollection c2 = new XYIntervalSeriesCollection(); [EOL]     assertEquals(c1, c2); [EOL]     XYIntervalSeries s1 = new XYIntervalSeries("Series"); [EOL]     s1.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5); [EOL]     c1.addSeries(s1); [EOL]     assertFalse(c1.equals(c2)); [EOL]     XYIntervalSeries s2 = new XYIntervalSeries("Series"); [EOL]     s2.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5); [EOL]     c2.addSeries(s2); [EOL]     assertTrue(c1.equals(c2)); [EOL]     c1.addSeries(new XYIntervalSeries("Empty Series")); [EOL]     assertFalse(c1.equals(c2)); [EOL]     c2.addSeries(new XYIntervalSeries("Empty Series")); [EOL]     assertTrue(c1.equals(c2)); [EOL] } <line_num>: 87,107
public void testCloning() { [EOL]     XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection(); [EOL]     XYIntervalSeries s1 = new XYIntervalSeries("Series"); [EOL]     s1.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5); [EOL]     XYIntervalSeriesCollection c2 = null; [EOL]     try { [EOL]         c2 = (XYIntervalSeriesCollection) c1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(c1 != c2); [EOL]     assertTrue(c1.getClass() == c2.getClass()); [EOL]     assertTrue(c1.equals(c2)); [EOL]     c1.addSeries(new XYIntervalSeries("Empty")); [EOL]     assertFalse(c1.equals(c2)); [EOL]     c2.addSeries(new XYIntervalSeries("Empty")); [EOL]     assertTrue(c1.equals(c2)); [EOL] } <line_num>: 112,132
public void testPublicCloneable() { [EOL]     XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection(); [EOL]     assertTrue(c1 instanceof PublicCloneable); [EOL] } <line_num>: 137,140
public void testSerialization() { [EOL]     XYIntervalSeriesCollection c1 = new XYIntervalSeriesCollection(); [EOL]     XYIntervalSeries s1 = new XYIntervalSeries("Series"); [EOL]     s1.add(1.0, 1.1, 1.2, 1.3, 1.4, 1.5); [EOL]     XYIntervalSeriesCollection c2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(c1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         c2 = (XYIntervalSeriesCollection) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(c1, c2); [EOL]     c1.addSeries(new XYIntervalSeries("Empty")); [EOL]     assertFalse(c1.equals(c2)); [EOL]     c2.addSeries(new XYIntervalSeries("Empty")); [EOL]     assertTrue(c1.equals(c2)); [EOL] } <line_num>: 145,172
public void testRemoveSeries() { [EOL]     XYIntervalSeriesCollection c = new XYIntervalSeriesCollection(); [EOL]     XYIntervalSeries s1 = new XYIntervalSeries("s1"); [EOL]     c.addSeries(s1); [EOL]     c.removeSeries(0); [EOL]     assertEquals(0, c.getSeriesCount()); [EOL]     c.addSeries(s1); [EOL]     boolean pass = false; [EOL]     try { [EOL]         c.removeSeries(-1); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL]     pass = false; [EOL]     try { [EOL]         c.removeSeries(1); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 177,202
public void test1170825() { [EOL]     XYIntervalSeries s1 = new XYIntervalSeries("Series1"); [EOL]     XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection(); [EOL]     dataset.addSeries(s1); [EOL]     try { [EOL]         dataset.getSeries(1); [EOL]     } catch (IllegalArgumentException e) { [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]         assertTrue(false); [EOL]     } [EOL] } <line_num>: 208,221
