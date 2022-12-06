public TaskSeriesCollectionTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 81,83
public static Test suite() { [EOL]     return new TestSuite(TaskSeriesCollectionTests.class); [EOL] } <line_num>: 72,74
private TaskSeriesCollection createCollection1() { [EOL]     TaskSeriesCollection result = new TaskSeriesCollection(); [EOL]     TaskSeries s1 = new TaskSeries("S1"); [EOL]     s1.add(new Task("Task 1", new Date(1), new Date(2))); [EOL]     s1.add(new Task("Task 2", new Date(3), new Date(4))); [EOL]     result.add(s1); [EOL]     TaskSeries s2 = new TaskSeries("S2"); [EOL]     s2.add(new Task("Task 3", new Date(5), new Date(6))); [EOL]     result.add(s2); [EOL]     return result; [EOL] } <line_num>: 90,100
private TaskSeriesCollection createCollection2() { [EOL]     TaskSeriesCollection result = new TaskSeriesCollection(); [EOL]     TaskSeries s1 = new TaskSeries("S1"); [EOL]     Task t1 = new Task("Task 1", new Date(10), new Date(20)); [EOL]     t1.addSubtask(new Task("Task 1A", new Date(10), new Date(15))); [EOL]     t1.addSubtask(new Task("Task 1B", new Date(16), new Date(20))); [EOL]     t1.setPercentComplete(0.10); [EOL]     s1.add(t1); [EOL]     Task t2 = new Task("Task 2", new Date(30), new Date(40)); [EOL]     t2.addSubtask(new Task("Task 2A", new Date(30), new Date(35))); [EOL]     t2.addSubtask(new Task("Task 2B", new Date(36), new Date(40))); [EOL]     t2.setPercentComplete(0.20); [EOL]     s1.add(t2); [EOL]     result.add(s1); [EOL]     TaskSeries s2 = new TaskSeries("S2"); [EOL]     Task t3 = new Task("Task 3", new Date(50), new Date(60)); [EOL]     t3.addSubtask(new Task("Task 3A", new Date(50), new Date(55))); [EOL]     t3.addSubtask(new Task("Task 3B", new Date(56), new Date(60))); [EOL]     t3.setPercentComplete(0.30); [EOL]     s2.add(t3); [EOL]     result.add(s2); [EOL]     return result; [EOL] } <line_num>: 107,129
private TaskSeriesCollection createCollection3() { [EOL]     Task sub1 = new Task("Sub1", new Date(11), new Date(111)); [EOL]     Task sub2 = new Task("Sub2", new Date(22), new Date(222)); [EOL]     Task sub3 = new Task("Sub3", new Date(33), new Date(333)); [EOL]     Task sub4 = new Task("Sub4", new Date(44), new Date(444)); [EOL]     Task sub5 = new Task("Sub5", new Date(55), new Date(555)); [EOL]     Task sub6 = new Task("Sub6", new Date(66), new Date(666)); [EOL]     sub1.setPercentComplete(0.111); [EOL]     sub2.setPercentComplete(0.222); [EOL]     sub3.setPercentComplete(0.333); [EOL]     sub4.setPercentComplete(0.444); [EOL]     sub5.setPercentComplete(0.555); [EOL]     sub6.setPercentComplete(0.666); [EOL]     TaskSeries seriesA = new TaskSeries("Series A"); [EOL]     Task taskA1 = new Task("Task 1", new SimpleTimePeriod(new Date(100), new Date(200))); [EOL]     taskA1.setPercentComplete(0.1); [EOL]     taskA1.addSubtask(sub1); [EOL]     Task taskA2 = new Task("Task 2", new SimpleTimePeriod(new Date(220), new Date(350))); [EOL]     taskA2.setPercentComplete(0.2); [EOL]     taskA2.addSubtask(sub2); [EOL]     taskA2.addSubtask(sub3); [EOL]     seriesA.add(taskA1); [EOL]     seriesA.add(taskA2); [EOL]     TaskSeries seriesB = new TaskSeries("Series B"); [EOL]     Task taskB2 = new Task("Task 2", new SimpleTimePeriod(new Date(2220), new Date(3350))); [EOL]     taskB2.setPercentComplete(0.3); [EOL]     taskB2.addSubtask(sub4); [EOL]     taskB2.addSubtask(sub5); [EOL]     taskB2.addSubtask(sub6); [EOL]     seriesB.add(taskB2); [EOL]     TaskSeriesCollection tsc = new TaskSeriesCollection(); [EOL]     tsc.add(seriesA); [EOL]     tsc.add(seriesB); [EOL]     return tsc; [EOL] } <line_num>: 136,180
public void testGetSeriesCount() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(2, c.getSeriesCount()); [EOL] } <line_num>: 185,188
public void testGetSeriesKey() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals("S1", c.getSeriesKey(0)); [EOL]     assertEquals("S2", c.getSeriesKey(1)); [EOL] } <line_num>: 193,197
public void testGetRowCount() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(2, c.getRowCount()); [EOL] } <line_num>: 202,205
public void testGetRowKey() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals("S1", c.getRowKey(0)); [EOL]     assertEquals("S2", c.getRowKey(1)); [EOL] } <line_num>: 210,214
public void testGetRowIndex() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(0, c.getRowIndex("S1")); [EOL]     assertEquals(1, c.getRowIndex("S2")); [EOL] } <line_num>: 219,223
public void testGetValue() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(new Long(1L), c.getValue("S1", "Task 1")); [EOL]     assertEquals(new Long(3L), c.getValue("S1", "Task 2")); [EOL]     assertEquals(new Long(5L), c.getValue("S2", "Task 3")); [EOL]     assertEquals(new Long(1L), c.getValue(0, 0)); [EOL]     assertEquals(new Long(3L), c.getValue(0, 1)); [EOL]     assertEquals(null, c.getValue(0, 2)); [EOL]     assertEquals(null, c.getValue(1, 0)); [EOL]     assertEquals(null, c.getValue(1, 1)); [EOL]     assertEquals(new Long(5L), c.getValue(1, 2)); [EOL] } <line_num>: 228,240
public void testGetStartValue() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(new Long(1L), c.getStartValue("S1", "Task 1")); [EOL]     assertEquals(new Long(3L), c.getStartValue("S1", "Task 2")); [EOL]     assertEquals(new Long(5L), c.getStartValue("S2", "Task 3")); [EOL]     assertEquals(new Long(1L), c.getStartValue(0, 0)); [EOL]     assertEquals(new Long(3L), c.getStartValue(0, 1)); [EOL]     assertEquals(null, c.getStartValue(0, 2)); [EOL]     assertEquals(null, c.getStartValue(1, 0)); [EOL]     assertEquals(null, c.getStartValue(1, 1)); [EOL]     assertEquals(new Long(5L), c.getStartValue(1, 2)); [EOL]     TaskSeriesCollection c3 = createCollection3(); [EOL]     assertEquals(new Long(100), c3.getStartValue(0, 0)); [EOL]     assertEquals(new Long(220), c3.getStartValue(0, 1)); [EOL]     assertTrue(c3.getStartValue(1, 0) == null); [EOL]     assertEquals(new Long(2220), c3.getStartValue(1, 1)); [EOL] } <line_num>: 245,264
public void testGetStartValue2() { [EOL]     TaskSeriesCollection c = createCollection2(); [EOL]     assertEquals(new Long(10L), c.getStartValue("S1", "Task 1", 0)); [EOL]     assertEquals(new Long(16L), c.getStartValue("S1", "Task 1", 1)); [EOL]     assertEquals(new Long(30L), c.getStartValue("S1", "Task 2", 0)); [EOL]     assertEquals(new Long(36L), c.getStartValue("S1", "Task 2", 1)); [EOL]     assertEquals(new Long(50L), c.getStartValue("S2", "Task 3", 0)); [EOL]     assertEquals(new Long(56L), c.getStartValue("S2", "Task 3", 1)); [EOL]     assertEquals(new Long(10L), c.getStartValue(0, 0, 0)); [EOL]     assertEquals(new Long(16L), c.getStartValue(0, 0, 1)); [EOL]     assertEquals(new Long(30L), c.getStartValue(0, 1, 0)); [EOL]     assertEquals(new Long(36L), c.getStartValue(0, 1, 1)); [EOL]     assertEquals(new Long(50L), c.getStartValue(1, 2, 0)); [EOL]     assertEquals(new Long(56L), c.getStartValue(1, 2, 1)); [EOL]     TaskSeriesCollection c3 = createCollection3(); [EOL]     assertEquals(new Long(11), c3.getStartValue(0, 0, 0)); [EOL]     assertEquals(new Long(22), c3.getStartValue(0, 1, 0)); [EOL]     assertEquals(new Long(33), c3.getStartValue(0, 1, 1)); [EOL]     assertTrue(c3.getStartValue(1, 0, 0) == null); [EOL]     assertEquals(new Long(44), c3.getStartValue(1, 1, 0)); [EOL]     assertEquals(new Long(55), c3.getStartValue(1, 1, 1)); [EOL]     assertEquals(new Long(66), c3.getStartValue(1, 1, 2)); [EOL] } <line_num>: 269,293
public void testGetStartValue3() { [EOL]     TaskSeriesCollection c = new TaskSeriesCollection(); [EOL]     TaskSeries s = new TaskSeries("Series 1"); [EOL]     s.add(new Task("Task with null duration", null)); [EOL]     c.add(s); [EOL]     Number millis = c.getStartValue("Series 1", "Task with null duration"); [EOL]     assertTrue(millis == null); [EOL] } <line_num>: 298,305
public void testGetEndValue() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(new Long(2L), c.getEndValue("S1", "Task 1")); [EOL]     assertEquals(new Long(4L), c.getEndValue("S1", "Task 2")); [EOL]     assertEquals(new Long(6L), c.getEndValue("S2", "Task 3")); [EOL]     assertEquals(new Long(2L), c.getEndValue(0, 0)); [EOL]     assertEquals(new Long(4L), c.getEndValue(0, 1)); [EOL]     assertEquals(null, c.getEndValue(0, 2)); [EOL]     assertEquals(null, c.getEndValue(1, 0)); [EOL]     assertEquals(null, c.getEndValue(1, 1)); [EOL]     assertEquals(new Long(6L), c.getEndValue(1, 2)); [EOL]     TaskSeriesCollection c3 = createCollection3(); [EOL]     assertEquals(new Long(200), c3.getEndValue(0, 0)); [EOL]     assertEquals(new Long(350), c3.getEndValue(0, 1)); [EOL]     assertTrue(c3.getEndValue(1, 0) == null); [EOL]     assertEquals(new Long(3350), c3.getEndValue(1, 1)); [EOL] } <line_num>: 310,329
public void testGetEndValue2() { [EOL]     TaskSeriesCollection c = createCollection2(); [EOL]     assertEquals(new Long(15L), c.getEndValue("S1", "Task 1", 0)); [EOL]     assertEquals(new Long(20L), c.getEndValue("S1", "Task 1", 1)); [EOL]     assertEquals(new Long(35L), c.getEndValue("S1", "Task 2", 0)); [EOL]     assertEquals(new Long(40L), c.getEndValue("S1", "Task 2", 1)); [EOL]     assertEquals(new Long(55L), c.getEndValue("S2", "Task 3", 0)); [EOL]     assertEquals(new Long(60L), c.getEndValue("S2", "Task 3", 1)); [EOL]     assertEquals(new Long(15L), c.getEndValue(0, 0, 0)); [EOL]     assertEquals(new Long(20L), c.getEndValue(0, 0, 1)); [EOL]     assertEquals(new Long(35L), c.getEndValue(0, 1, 0)); [EOL]     assertEquals(new Long(40L), c.getEndValue(0, 1, 1)); [EOL]     assertEquals(new Long(55L), c.getEndValue(1, 2, 0)); [EOL]     assertEquals(new Long(60L), c.getEndValue(1, 2, 1)); [EOL]     TaskSeriesCollection c3 = createCollection3(); [EOL]     assertEquals(new Long(111), c3.getEndValue(0, 0, 0)); [EOL]     assertEquals(new Long(222), c3.getEndValue(0, 1, 0)); [EOL]     assertEquals(new Long(333), c3.getEndValue(0, 1, 1)); [EOL]     assertTrue(c3.getEndValue(1, 0, 0) == null); [EOL]     assertEquals(new Long(444), c3.getEndValue(1, 1, 0)); [EOL]     assertEquals(new Long(555), c3.getEndValue(1, 1, 1)); [EOL]     assertEquals(new Long(666), c3.getEndValue(1, 1, 2)); [EOL] } <line_num>: 334,358
public void testGetEndValue3() { [EOL]     TaskSeriesCollection c = new TaskSeriesCollection(); [EOL]     TaskSeries s = new TaskSeries("Series 1"); [EOL]     s.add(new Task("Task with null duration", null)); [EOL]     c.add(s); [EOL]     Number millis = c.getEndValue("Series 1", "Task with null duration"); [EOL]     assertTrue(millis == null); [EOL] } <line_num>: 363,370
public void testGetPercentComplete() { [EOL]     TaskSeriesCollection c = createCollection2(); [EOL]     assertEquals(new Double(0.10), c.getPercentComplete("S1", "Task 1")); [EOL]     assertEquals(new Double(0.20), c.getPercentComplete("S1", "Task 2")); [EOL]     assertEquals(new Double(0.30), c.getPercentComplete("S2", "Task 3")); [EOL]     assertEquals(new Double(0.10), c.getPercentComplete(0, 0)); [EOL]     assertEquals(new Double(0.20), c.getPercentComplete(0, 1)); [EOL]     assertEquals(null, c.getPercentComplete(0, 2)); [EOL]     assertEquals(null, c.getPercentComplete(1, 0)); [EOL]     assertEquals(null, c.getPercentComplete(1, 1)); [EOL]     assertEquals(new Double(0.30), c.getPercentComplete(1, 2)); [EOL]     TaskSeriesCollection c3 = createCollection3(); [EOL]     assertEquals(new Double(0.1), c3.getPercentComplete(0, 0)); [EOL]     assertEquals(new Double(0.2), c3.getPercentComplete(0, 1)); [EOL]     assertTrue(c3.getPercentComplete(1, 0) == null); [EOL]     assertEquals(new Double(0.3), c3.getPercentComplete(1, 1)); [EOL]     assertEquals(new Double(0.111), c3.getPercentComplete(0, 0, 0)); [EOL]     assertEquals(new Double(0.222), c3.getPercentComplete(0, 1, 0)); [EOL]     assertEquals(new Double(0.333), c3.getPercentComplete(0, 1, 1)); [EOL]     assertEquals(new Double(0.444), c3.getPercentComplete(1, 1, 0)); [EOL]     assertEquals(new Double(0.555), c3.getPercentComplete(1, 1, 1)); [EOL]     assertEquals(new Double(0.666), c3.getPercentComplete(1, 1, 2)); [EOL] } <line_num>: 375,403
public void testGetColumnCount() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(3, c.getColumnCount()); [EOL] } <line_num>: 408,411
public void testGetColumnKey() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals("Task 1", c.getColumnKey(0)); [EOL]     assertEquals("Task 2", c.getColumnKey(1)); [EOL]     assertEquals("Task 3", c.getColumnKey(2)); [EOL] } <line_num>: 416,421
public void testGetColumnIndex() { [EOL]     TaskSeriesCollection c = createCollection1(); [EOL]     assertEquals(0, c.getColumnIndex("Task 1")); [EOL]     assertEquals(1, c.getColumnIndex("Task 2")); [EOL]     assertEquals(2, c.getColumnIndex("Task 3")); [EOL] } <line_num>: 426,431
public void testEquals() { [EOL]     TaskSeries s1 = new TaskSeries("S"); [EOL]     s1.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s1.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeries s2 = new TaskSeries("S"); [EOL]     s2.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s2.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeriesCollection c1 = new TaskSeriesCollection(); [EOL]     c1.add(s1); [EOL]     c1.add(s2); [EOL]     TaskSeries s1b = new TaskSeries("S"); [EOL]     s1b.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s1b.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeries s2b = new TaskSeries("S"); [EOL]     s2b.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s2b.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeriesCollection c2 = new TaskSeriesCollection(); [EOL]     c2.add(s1b); [EOL]     c2.add(s2b); [EOL]     assertTrue(c1.equals(c2)); [EOL]     assertTrue(c2.equals(c1)); [EOL] } <line_num>: 436,461
public void testCloning() { [EOL]     TaskSeries s1 = new TaskSeries("S"); [EOL]     s1.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s1.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeries s2 = new TaskSeries("S"); [EOL]     s2.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s2.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeriesCollection c1 = new TaskSeriesCollection(); [EOL]     c1.add(s1); [EOL]     c1.add(s2); [EOL]     TaskSeriesCollection c2 = null; [EOL]     try { [EOL]         c2 = (TaskSeriesCollection) c1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         System.err.println("Failed to clone."); [EOL]     } [EOL]     assertTrue(c1 != c2); [EOL]     assertTrue(c1.getClass() == c2.getClass()); [EOL]     assertTrue(c1.equals(c2)); [EOL] } <line_num>: 466,487
public void testSerialization() { [EOL]     TaskSeries s1 = new TaskSeries("S"); [EOL]     s1.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s1.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeries s2 = new TaskSeries("S"); [EOL]     s2.add(new Task("T1", new Date(1), new Date(2))); [EOL]     s2.add(new Task("T2", new Date(11), new Date(22))); [EOL]     TaskSeriesCollection c1 = new TaskSeriesCollection(); [EOL]     c1.add(s1); [EOL]     c1.add(s2); [EOL]     TaskSeriesCollection c2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(c1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         c2 = (TaskSeriesCollection) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         System.out.println(e.toString()); [EOL]     } [EOL]     assertEquals(c1, c2); [EOL] } <line_num>: 492,521
public void test697153() { [EOL]     TaskSeries s1 = new TaskSeries("S1"); [EOL]     s1.add(new Task("Task 1", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     s1.add(new Task("Task 2", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     s1.add(new Task("Task 3", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     TaskSeries s2 = new TaskSeries("S2"); [EOL]     s2.add(new Task("Task 2", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     s2.add(new Task("Task 3", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     s2.add(new Task("Task 4", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     TaskSeriesCollection tsc = new TaskSeriesCollection(); [EOL]     tsc.add(s1); [EOL]     tsc.add(s2); [EOL]     s1.removeAll(); [EOL]     int taskCount = tsc.getColumnCount(); [EOL]     assertEquals(3, taskCount); [EOL] } <line_num>: 526,554
public void test800324() { [EOL]     TaskSeries s1 = new TaskSeries("S1"); [EOL]     s1.add(new Task("Task 1", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     s1.add(new Task("Task 2", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     s1.add(new Task("Task 3", new SimpleTimePeriod(new Date(), new Date()))); [EOL]     TaskSeriesCollection tsc = new TaskSeriesCollection(); [EOL]     tsc.add(s1); [EOL]     try { [EOL]         tsc.getStartValue(0, 3); [EOL]         assertTrue(false); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]     } [EOL]     try { [EOL]         tsc.getEndValue(0, 3); [EOL]         assertTrue(false); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]     } [EOL]     try { [EOL]         tsc.getSubIntervalCount(0, 3); [EOL]         assertTrue(false); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]     } [EOL] } <line_num>: 559,594
public void testGetSubIntervalCount() { [EOL]     TaskSeriesCollection tsc = createCollection3(); [EOL]     assertEquals(1, tsc.getSubIntervalCount(0, 0)); [EOL]     assertEquals(2, tsc.getSubIntervalCount(0, 1)); [EOL]     assertEquals(0, tsc.getSubIntervalCount(1, 0)); [EOL]     assertEquals(3, tsc.getSubIntervalCount(1, 1)); [EOL] } <line_num>: 603,609
public void testGetSeries() { [EOL]     TaskSeries s1 = new TaskSeries("S1"); [EOL]     TaskSeries s2 = new TaskSeries("S2"); [EOL]     TaskSeriesCollection c = new TaskSeriesCollection(); [EOL]     c.add(s1); [EOL]     assertEquals(c.getSeries(0), s1); [EOL]     assertEquals(c.getSeries("S1"), s1); [EOL]     assertEquals(c.getSeries("XX"), null); [EOL]     c.add(s2); [EOL]     assertEquals(c.getSeries(1), s2); [EOL]     assertEquals(c.getSeries("S2"), s2); [EOL]     boolean pass = false; [EOL]     try { [EOL]         c.getSeries(null); [EOL]     } catch (NullPointerException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 614,636
public void testRemove() { [EOL]     TaskSeriesCollection c = new TaskSeriesCollection(); [EOL]     TaskSeries s1 = new TaskSeries("S1"); [EOL]     c.add(s1); [EOL]     assertEquals("S1", c.getSeries(0).getKey()); [EOL]     c.remove(0); [EOL]     assertEquals(0, c.getSeriesCount()); [EOL]     c.add(s1); [EOL]     boolean pass = false; [EOL]     try { [EOL]         c.remove(-1); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL]     pass = false; [EOL]     try { [EOL]         c.remove(1); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 641,667