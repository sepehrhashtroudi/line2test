public XYTaskDatasetTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 79,81
public static Test suite() { [EOL]     return new TestSuite(XYTaskDatasetTests.class); [EOL] } <line_num>: 70,72
public void testEquals() { [EOL]     TaskSeries s1 = new TaskSeries("Series"); [EOL]     s1.add(new Task("Task 1", new Date(0L), new Date(1L))); [EOL]     s1.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     s1.add(new Task("Task 3", new Date(20L), new Date(21L))); [EOL]     TaskSeriesCollection u1 = new TaskSeriesCollection(); [EOL]     u1.add(s1); [EOL]     XYTaskDataset d1 = new XYTaskDataset(u1); [EOL]     TaskSeries s2 = new TaskSeries("Series"); [EOL]     s2.add(new Task("Task 1", new Date(0L), new Date(1L))); [EOL]     s2.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     s2.add(new Task("Task 3", new Date(20L), new Date(21L))); [EOL]     TaskSeriesCollection u2 = new TaskSeriesCollection(); [EOL]     u2.add(s2); [EOL]     XYTaskDataset d2 = new XYTaskDataset(u2); [EOL]     assertTrue(d1.equals(d2)); [EOL]     d1.setSeriesWidth(0.123); [EOL]     assertFalse(d1.equals(d2)); [EOL]     d2.setSeriesWidth(0.123); [EOL]     assertTrue(d1.equals(d2)); [EOL]     d1.setTransposed(true); [EOL]     assertFalse(d1.equals(d2)); [EOL]     d2.setTransposed(true); [EOL]     assertTrue(d1.equals(d2)); [EOL]     s1.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     assertFalse(d1.equals(d2)); [EOL]     s2.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 86,117
public void testCloning() { [EOL]     TaskSeries s1 = new TaskSeries("Series"); [EOL]     s1.add(new Task("Task 1", new Date(0L), new Date(1L))); [EOL]     TaskSeriesCollection u1 = new TaskSeriesCollection(); [EOL]     u1.add(s1); [EOL]     XYTaskDataset d1 = new XYTaskDataset(u1); [EOL]     XYTaskDataset d2 = null; [EOL]     try { [EOL]         d2 = (XYTaskDataset) d1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(d1 != d2); [EOL]     assertTrue(d1.getClass() == d2.getClass()); [EOL]     assertTrue(d1.equals(d2)); [EOL]     s1.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     assertFalse(d1.equals(d2)); [EOL]     TaskSeriesCollection u2 = d2.getTasks(); [EOL]     TaskSeries s2 = u2.getSeries("Series"); [EOL]     s2.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 122,146
public void testSerialization() { [EOL]     TaskSeries s1 = new TaskSeries("Series"); [EOL]     s1.add(new Task("Task 1", new Date(0L), new Date(1L))); [EOL]     TaskSeriesCollection u1 = new TaskSeriesCollection(); [EOL]     u1.add(s1); [EOL]     XYTaskDataset d1 = new XYTaskDataset(u1); [EOL]     XYTaskDataset d2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(d1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         d2 = (XYTaskDataset) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(d1, d2); [EOL]     s1.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     assertFalse(d1.equals(d2)); [EOL]     TaskSeriesCollection u2 = d2.getTasks(); [EOL]     TaskSeries s2 = u2.getSeries("Series"); [EOL]     s2.add(new Task("Task 2", new Date(10L), new Date(11L))); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 151,181
