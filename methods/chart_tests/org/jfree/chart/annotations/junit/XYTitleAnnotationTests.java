public XYTitleAnnotationTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 83,85
public static Test suite() { [EOL]     return new TestSuite(XYTitleAnnotationTests.class); [EOL] } <line_num>: 74,76
public void testEquals() { [EOL]     TextTitle t = new TextTitle("Title"); [EOL]     XYTitleAnnotation a1 = new XYTitleAnnotation(1.0, 2.0, t); [EOL]     XYTitleAnnotation a2 = new XYTitleAnnotation(1.0, 2.0, t); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYTitleAnnotation(1.1, 2.0, t); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYTitleAnnotation(1.1, 2.0, t); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYTitleAnnotation(1.1, 2.2, t); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYTitleAnnotation(1.1, 2.2, t); [EOL]     assertTrue(a1.equals(a2)); [EOL]     TextTitle t2 = new TextTitle("Title 2"); [EOL]     a1 = new XYTitleAnnotation(1.1, 2.2, t2); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYTitleAnnotation(1.1, 2.2, t2); [EOL]     assertTrue(a1.equals(a2)); [EOL] } <line_num>: 90,111
public void testHashCode() { [EOL]     TextTitle t = new TextTitle("Title"); [EOL]     XYTitleAnnotation a1 = new XYTitleAnnotation(1.0, 2.0, t); [EOL]     XYTitleAnnotation a2 = new XYTitleAnnotation(1.0, 2.0, t); [EOL]     assertTrue(a1.equals(a2)); [EOL]     int h1 = a1.hashCode(); [EOL]     int h2 = a2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 116,124
public void testCloning() { [EOL]     TextTitle t = new TextTitle("Title"); [EOL]     XYTitleAnnotation a1 = new XYTitleAnnotation(1.0, 2.0, t); [EOL]     XYTitleAnnotation a2 = null; [EOL]     try { [EOL]         a2 = (XYTitleAnnotation) a1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(a1 != a2); [EOL]     assertTrue(a1.getClass() == a2.getClass()); [EOL]     assertTrue(a1.equals(a2)); [EOL] } <line_num>: 129,142
public void testSerialization() { [EOL]     TextTitle t = new TextTitle("Title"); [EOL]     XYTitleAnnotation a1 = new XYTitleAnnotation(1.0, 2.0, t); [EOL]     XYTitleAnnotation a2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(a1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         a2 = (XYTitleAnnotation) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(a1, a2); [EOL] } <line_num>: 147,166
public void testDrawWithNullInfo() { [EOL]     boolean success = false; [EOL]     try { [EOL]         DefaultTableXYDataset dataset = new DefaultTableXYDataset(); [EOL]         XYSeries s1 = new XYSeries("Series 1", true, false); [EOL]         s1.add(5.0, 5.0); [EOL]         s1.add(10.0, 15.5); [EOL]         s1.add(15.0, 9.5); [EOL]         s1.add(20.0, 7.5); [EOL]         dataset.addSeries(s1); [EOL]         XYSeries s2 = new XYSeries("Series 2", true, false); [EOL]         s2.add(5.0, 5.0); [EOL]         s2.add(10.0, 15.5); [EOL]         s2.add(15.0, 9.5); [EOL]         s2.add(20.0, 3.5); [EOL]         dataset.addSeries(s2); [EOL]         XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), new XYLineAndShapeRenderer()); [EOL]         plot.addAnnotation(new XYTitleAnnotation(5.0, 6.0, new TextTitle("Hello World!"))); [EOL]         JFreeChart chart = new JFreeChart(plot); [EOL]         chart.createBufferedImage(300, 200, null); [EOL]         success = true; [EOL]     } catch (NullPointerException e) { [EOL]         e.printStackTrace(); [EOL]         success = false; [EOL]     } [EOL]     assertTrue(success); [EOL] } <line_num>: 172,205