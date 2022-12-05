public ComparableObjectItemTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 75,77
public static Test suite() { [EOL]     return new TestSuite(ComparableObjectItemTests.class); [EOL] } <line_num>: 66,68
public void testConstructor() { [EOL]     boolean pass = false; [EOL]     try { [EOL]         new ComparableObjectItem(null, "XYZ"); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 82,93
public void testEquals() { [EOL]     ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ"); [EOL]     ComparableObjectItem item2 = new ComparableObjectItem(new Integer(1), "XYZ"); [EOL]     assertTrue(item1.equals(item2)); [EOL]     assertTrue(item2.equals(item1)); [EOL]     item1 = new ComparableObjectItem(new Integer(2), "XYZ"); [EOL]     assertFalse(item1.equals(item2)); [EOL]     item2 = new ComparableObjectItem(new Integer(2), "XYZ"); [EOL]     assertTrue(item1.equals(item2)); [EOL]     item1 = new ComparableObjectItem(new Integer(2), null); [EOL]     assertFalse(item1.equals(item2)); [EOL]     item2 = new ComparableObjectItem(new Integer(2), null); [EOL]     assertTrue(item1.equals(item2)); [EOL] } <line_num>: 98,115
public void testCloning() { [EOL]     ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ"); [EOL]     ComparableObjectItem item2 = null; [EOL]     try { [EOL]         item2 = (ComparableObjectItem) item1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(item1 != item2); [EOL]     assertTrue(item1.getClass() == item2.getClass()); [EOL]     assertTrue(item1.equals(item2)); [EOL] } <line_num>: 120,133
public void testSerialization() { [EOL]     ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ"); [EOL]     ComparableObjectItem item2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(item1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         item2 = (ComparableObjectItem) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(item1, item2); [EOL] } <line_num>: 138,157
public void testCompareTo() { [EOL]     ComparableObjectItem item1 = new ComparableObjectItem(new Integer(1), "XYZ"); [EOL]     ComparableObjectItem item2 = new ComparableObjectItem(new Integer(2), "XYZ"); [EOL]     ComparableObjectItem item3 = new ComparableObjectItem(new Integer(3), "XYZ"); [EOL]     ComparableObjectItem item4 = new ComparableObjectItem(new Integer(1), "XYZ"); [EOL]     assertTrue(item2.compareTo(item1) > 0); [EOL]     assertTrue(item3.compareTo(item1) > 0); [EOL]     assertTrue(item4.compareTo(item1) == 0); [EOL]     assertTrue(item1.compareTo(item2) < 0); [EOL] } <line_num>: 162,175
