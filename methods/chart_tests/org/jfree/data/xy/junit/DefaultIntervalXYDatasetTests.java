public DefaultIntervalXYDatasetTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 78,80
public static Test suite() { [EOL]     return new TestSuite(DefaultIntervalXYDatasetTests.class); [EOL] } <line_num>: 69,71
public void testGetSeriesCount() { [EOL]     DefaultIntervalXYDataset d = new DefaultIntervalXYDataset(); [EOL]     assertEquals(0, d.getSeriesCount()); [EOL]     d = createSampleDataset1(); [EOL]     assertEquals(2, d.getSeriesCount()); [EOL] } <line_num>: 85,90
public void testGetSeriesKey() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals("S1", d.getSeriesKey(0)); [EOL]     assertEquals("S2", d.getSeriesKey(1)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d.getSeriesKey(-1); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL]     pass = false; [EOL]     try { [EOL]         d.getSeriesKey(2); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 95,118
public void testGetItemCount() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(3, d.getItemCount(0)); [EOL]     assertEquals(3, d.getItemCount(1)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d.getItemCount(2); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 123,137
public void testGetXValue() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(1.0, d.getXValue(0, 0), EPSILON); [EOL]     assertEquals(2.0, d.getXValue(0, 1), EPSILON); [EOL]     assertEquals(3.0, d.getXValue(0, 2), EPSILON); [EOL]     assertEquals(11.0, d.getXValue(1, 0), EPSILON); [EOL]     assertEquals(12.0, d.getXValue(1, 1), EPSILON); [EOL]     assertEquals(13.0, d.getXValue(1, 2), EPSILON); [EOL] } <line_num>: 144,152
public void testGetYValue() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(4.0, d.getYValue(0, 0), EPSILON); [EOL]     assertEquals(5.0, d.getYValue(0, 1), EPSILON); [EOL]     assertEquals(6.0, d.getYValue(0, 2), EPSILON); [EOL]     assertEquals(14.0, d.getYValue(1, 0), EPSILON); [EOL]     assertEquals(15.0, d.getYValue(1, 1), EPSILON); [EOL]     assertEquals(16.0, d.getYValue(1, 2), EPSILON); [EOL] } <line_num>: 157,165
public void testGetStartXValue() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(0.9, d.getStartXValue(0, 0), EPSILON); [EOL]     assertEquals(1.9, d.getStartXValue(0, 1), EPSILON); [EOL]     assertEquals(2.9, d.getStartXValue(0, 2), EPSILON); [EOL]     assertEquals(10.9, d.getStartXValue(1, 0), EPSILON); [EOL]     assertEquals(11.9, d.getStartXValue(1, 1), EPSILON); [EOL]     assertEquals(12.9, d.getStartXValue(1, 2), EPSILON); [EOL] } <line_num>: 170,178
public void testGetEndXValue() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(1.1, d.getEndXValue(0, 0), EPSILON); [EOL]     assertEquals(2.1, d.getEndXValue(0, 1), EPSILON); [EOL]     assertEquals(3.1, d.getEndXValue(0, 2), EPSILON); [EOL]     assertEquals(11.1, d.getEndXValue(1, 0), EPSILON); [EOL]     assertEquals(12.1, d.getEndXValue(1, 1), EPSILON); [EOL]     assertEquals(13.1, d.getEndXValue(1, 2), EPSILON); [EOL] } <line_num>: 183,191
public void testGetStartYValue() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(1.09, d.getStartYValue(0, 0), EPSILON); [EOL]     assertEquals(2.09, d.getStartYValue(0, 1), EPSILON); [EOL]     assertEquals(3.09, d.getStartYValue(0, 2), EPSILON); [EOL]     assertEquals(11.09, d.getStartYValue(1, 0), EPSILON); [EOL]     assertEquals(12.09, d.getStartYValue(1, 1), EPSILON); [EOL]     assertEquals(13.09, d.getStartYValue(1, 2), EPSILON); [EOL] } <line_num>: 196,204
public void testGetEndYValue() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(1.11, d.getEndYValue(0, 0), EPSILON); [EOL]     assertEquals(2.11, d.getEndYValue(0, 1), EPSILON); [EOL]     assertEquals(3.11, d.getEndYValue(0, 2), EPSILON); [EOL]     assertEquals(11.11, d.getEndYValue(1, 0), EPSILON); [EOL]     assertEquals(12.11, d.getEndYValue(1, 1), EPSILON); [EOL]     assertEquals(13.11, d.getEndYValue(1, 2), EPSILON); [EOL] } <line_num>: 209,217
public void testEquals() { [EOL]     DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset(); [EOL]     DefaultIntervalXYDataset d2 = new DefaultIntervalXYDataset(); [EOL]     assertTrue(d1.equals(d2)); [EOL]     assertTrue(d2.equals(d1)); [EOL]     d1 = createSampleDataset1(); [EOL]     assertFalse(d1.equals(d2)); [EOL]     d2 = createSampleDataset1(); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 222,232
public void testCloning() { [EOL]     DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset(); [EOL]     DefaultIntervalXYDataset d2 = null; [EOL]     try { [EOL]         d2 = (DefaultIntervalXYDataset) d1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(d1 != d2); [EOL]     assertTrue(d1.getClass() == d2.getClass()); [EOL]     assertTrue(d1.equals(d2)); [EOL]     d1 = createSampleDataset1(); [EOL]     try { [EOL]         d2 = (DefaultIntervalXYDataset) d1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(d1 != d2); [EOL]     assertTrue(d1.getClass() == d2.getClass()); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 237,261
public void testCloning2() { [EOL]     DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset(); [EOL]     double[] x1 = new double[] { 1.0, 2.0, 3.0 }; [EOL]     double[] x1Start = new double[] { 0.9, 1.9, 2.9 }; [EOL]     double[] x1End = new double[] { 1.1, 2.1, 3.1 }; [EOL]     double[] y1 = new double[] { 4.0, 5.0, 6.0 }; [EOL]     double[] y1Start = new double[] { 1.09, 2.09, 3.09 }; [EOL]     double[] y1End = new double[] { 1.11, 2.11, 3.11 }; [EOL]     double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End }; [EOL]     d1.addSeries("S1", data1); [EOL]     DefaultIntervalXYDataset d2 = null; [EOL]     try { [EOL]         d2 = (DefaultIntervalXYDataset) d1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(d1 != d2); [EOL]     assertTrue(d1.getClass() == d2.getClass()); [EOL]     assertTrue(d1.equals(d2)); [EOL]     x1[0] = 111.1; [EOL]     assertFalse(d1.equals(d2)); [EOL] } <line_num>: 266,291
public void testPublicCloneable() { [EOL]     DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset(); [EOL]     assertTrue(d1 instanceof PublicCloneable); [EOL] } <line_num>: 296,299
public void testSerialization() { [EOL]     DefaultIntervalXYDataset d1 = new DefaultIntervalXYDataset(); [EOL]     DefaultIntervalXYDataset d2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(d1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         d2 = (DefaultIntervalXYDataset) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(d1, d2); [EOL]     d1 = createSampleDataset1(); [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(d1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         d2 = (DefaultIntervalXYDataset) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(d1, d2); [EOL] } <line_num>: 304,343
public void testIndexOf() { [EOL]     DefaultIntervalXYDataset d = createSampleDataset1(); [EOL]     assertEquals(0, d.indexOf("S1")); [EOL]     assertEquals(1, d.indexOf("S2")); [EOL]     assertEquals(-1, d.indexOf("Green Eggs and Ham")); [EOL]     assertEquals(-1, d.indexOf(null)); [EOL] } <line_num>: 348,354
public void testAddSeries() { [EOL]     DefaultIntervalXYDataset d = new DefaultIntervalXYDataset(); [EOL]     d.addSeries("S1", new double[][] { { 1.0 }, { 0.5 }, { 1.5 }, { 2.0 }, { 2.5 }, { 1.5 } }); [EOL]     assertEquals(1, d.getSeriesCount()); [EOL]     assertEquals("S1", d.getSeriesKey(0)); [EOL]     d.addSeries("S1", new double[][] { { 1.1 }, { 0.6 }, { 1.6 }, { 2.1 }, { 2.6 }, { 1.6 } }); [EOL]     assertEquals(1, d.getSeriesCount()); [EOL]     assertEquals(2.1, d.getYValue(0, 0), EPSILON); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d.addSeries(null, new double[][] { { 1.1 }, { 0.6 }, { 1.6 }, { 2.1 }, { 2.6 }, { 1.6 } }); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 359,384
public DefaultIntervalXYDataset createSampleDataset1() { [EOL]     DefaultIntervalXYDataset d = new DefaultIntervalXYDataset(); [EOL]     double[] x1 = new double[] { 1.0, 2.0, 3.0 }; [EOL]     double[] x1Start = new double[] { 0.9, 1.9, 2.9 }; [EOL]     double[] x1End = new double[] { 1.1, 2.1, 3.1 }; [EOL]     double[] y1 = new double[] { 4.0, 5.0, 6.0 }; [EOL]     double[] y1Start = new double[] { 1.09, 2.09, 3.09 }; [EOL]     double[] y1End = new double[] { 1.11, 2.11, 3.11 }; [EOL]     double[][] data1 = new double[][] { x1, x1Start, x1End, y1, y1Start, y1End }; [EOL]     d.addSeries("S1", data1); [EOL]     double[] x2 = new double[] { 11.0, 12.0, 13.0 }; [EOL]     double[] x2Start = new double[] { 10.9, 11.9, 12.9 }; [EOL]     double[] x2End = new double[] { 11.1, 12.1, 13.1 }; [EOL]     double[] y2 = new double[] { 14.0, 15.0, 16.0 }; [EOL]     double[] y2Start = new double[] { 11.09, 12.09, 13.09 }; [EOL]     double[] y2End = new double[] { 11.11, 12.11, 13.11 }; [EOL]     double[][] data2 = new double[][] { x2, x2Start, x2End, y2, y2Start, y2End }; [EOL]     d.addSeries("S2", data2); [EOL]     return d; [EOL] } <line_num>: 391,413
