public FastScatterPlotTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 84,86
public static Test suite() { [EOL]     return new TestSuite(FastScatterPlotTests.class); [EOL] } <line_num>: 75,77
public void testEquals() { [EOL]     FastScatterPlot plot1 = new FastScatterPlot(); [EOL]     FastScatterPlot plot2 = new FastScatterPlot(); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     assertTrue(plot2.equals(plot1)); [EOL]     plot1.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow)); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.yellow)); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setDomainGridlinesVisible(false); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setDomainGridlinesVisible(false); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow)); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setDomainGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.yellow)); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     Stroke s = new BasicStroke(1.5f); [EOL]     plot1.setDomainGridlineStroke(s); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setDomainGridlineStroke(s); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setRangeGridlinesVisible(false); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setRangeGridlinesVisible(false); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow)); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setRangeGridlinePaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.yellow)); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     Stroke s2 = new BasicStroke(1.5f); [EOL]     plot1.setRangeGridlineStroke(s2); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setRangeGridlineStroke(s2); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setDomainPannable(true); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setDomainPannable(true); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setRangePannable(true); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setRangePannable(true); [EOL]     assertTrue(plot1.equals(plot2)); [EOL] } <line_num>: 91,151
public void testEquals2() { [EOL]     FastScatterPlot plot1 = new FastScatterPlot(); [EOL]     FastScatterPlot plot2 = new FastScatterPlot(); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     assertTrue(plot2.equals(plot1)); [EOL]     float[][] a = new float[2][]; [EOL]     float[][] b = new float[2][]; [EOL]     plot1.setData(a); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setData(b); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     a[0] = new float[6]; [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     b[0] = new float[6]; [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     a[0][0] = 1.0f; [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     b[0][0] = 1.0f; [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     a[0][1] = Float.NaN; [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     b[0][1] = Float.NaN; [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     a[0][2] = Float.POSITIVE_INFINITY; [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     b[0][2] = Float.POSITIVE_INFINITY; [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     a[0][3] = Float.NEGATIVE_INFINITY; [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     b[0][3] = Float.NEGATIVE_INFINITY; [EOL]     assertTrue(plot1.equals(plot2)); [EOL] } <line_num>: 156,193
public void testCloning() { [EOL]     FastScatterPlot p1 = new FastScatterPlot(); [EOL]     FastScatterPlot p2 = null; [EOL]     try { [EOL]         p2 = (FastScatterPlot) p1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(p1 != p2); [EOL]     assertTrue(p1.getClass() == p2.getClass()); [EOL]     assertTrue(p1.equals(p2)); [EOL] } <line_num>: 198,210
public void testSerialization() { [EOL]     float[][] data = createData(); [EOL]     ValueAxis domainAxis = new NumberAxis("X"); [EOL]     ValueAxis rangeAxis = new NumberAxis("Y"); [EOL]     FastScatterPlot p1 = new FastScatterPlot(data, domainAxis, rangeAxis); [EOL]     FastScatterPlot p2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(p1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         p2 = (FastScatterPlot) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(p1, p2); [EOL] } <line_num>: 215,237
public void testDrawWithNullInfo() { [EOL]     boolean success = false; [EOL]     try { [EOL]         float[][] data = createData(); [EOL]         ValueAxis domainAxis = new NumberAxis("X"); [EOL]         ValueAxis rangeAxis = new NumberAxis("Y"); [EOL]         FastScatterPlot plot = new FastScatterPlot(data, domainAxis, rangeAxis); [EOL]         JFreeChart chart = new JFreeChart(plot); [EOL]         chart.createBufferedImage(300, 200, null); [EOL]         success = true; [EOL]     } catch (NullPointerException e) { [EOL]         e.printStackTrace(); [EOL]         success = false; [EOL]     } [EOL]     assertTrue(success); [EOL] } <line_num>: 243,262
private float[][] createData() { [EOL]     float[][] result = new float[2][1000]; [EOL]     for (int i = 0; i < result[0].length; i++) { [EOL]         float x = (float) i + 100; [EOL]         result[0][i] = x; [EOL]         result[1][i] = 100 + (float) Math.random() * 1000; [EOL]     } [EOL]     return result; [EOL] } <line_num>: 269,277