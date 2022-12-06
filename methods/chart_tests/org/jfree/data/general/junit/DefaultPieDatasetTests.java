public DefaultPieDatasetTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 91,93
public void datasetChanged(DatasetChangeEvent event) { [EOL]     this.lastEvent = event; [EOL] } <line_num>: 73,75
public static Test suite() { [EOL]     return new TestSuite(DefaultPieDatasetTests.class); [EOL] } <line_num>: 82,84
public void testClear() { [EOL]     DefaultPieDataset d = new DefaultPieDataset(); [EOL]     d.addChangeListener(this); [EOL]     d.clear(); [EOL]     assertNull(this.lastEvent); [EOL]     d.setValue("A", 1.0); [EOL]     assertEquals(1, d.getItemCount()); [EOL]     this.lastEvent = null; [EOL]     d.clear(); [EOL]     assertNotNull(this.lastEvent); [EOL]     assertEquals(0, d.getItemCount()); [EOL] } <line_num>: 98,110
public void testGetKey() { [EOL]     DefaultPieDataset d = new DefaultPieDataset(); [EOL]     d.setValue("A", 1.0); [EOL]     d.setValue("B", 2.0); [EOL]     assertEquals("A", d.getKey(0)); [EOL]     assertEquals("B", d.getKey(1)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d.getKey(-1); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL]     pass = false; [EOL]     try { [EOL]         d.getKey(2); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 115,139
public void testGetIndex() { [EOL]     DefaultPieDataset d = new DefaultPieDataset(); [EOL]     d.setValue("A", 1.0); [EOL]     d.setValue("B", 2.0); [EOL]     assertEquals(0, d.getIndex("A")); [EOL]     assertEquals(1, d.getIndex("B")); [EOL]     assertEquals(-1, d.getIndex("XX")); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d.getIndex(null); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 144,160
public void testCloning() { [EOL]     DefaultPieDataset d1 = new DefaultPieDataset(); [EOL]     d1.setValue("V1", new Integer(1)); [EOL]     d1.setValue("V2", null); [EOL]     d1.setValue("V3", new Integer(3)); [EOL]     DefaultPieDataset d2 = null; [EOL]     try { [EOL]         d2 = (DefaultPieDataset) d1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         System.err.println("Failed to clone."); [EOL]     } [EOL]     assertTrue(d1 != d2); [EOL]     assertTrue(d1.getClass() == d2.getClass()); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 165,180
public void testSerialization() { [EOL]     DefaultPieDataset d1 = new DefaultPieDataset(); [EOL]     d1.setValue("C1", new Double(234.2)); [EOL]     d1.setValue("C2", null); [EOL]     d1.setValue("C3", new Double(345.9)); [EOL]     d1.setValue("C4", new Double(452.7)); [EOL]     DefaultPieDataset d2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(d1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         d2 = (DefaultPieDataset) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         System.out.println(e.toString()); [EOL]     } [EOL]     assertEquals(d1, d2); [EOL] } <line_num>: 185,212