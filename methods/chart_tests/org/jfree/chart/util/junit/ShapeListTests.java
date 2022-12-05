public ShapeListTests(final String name) { [EOL]     super(name); [EOL] } <line_num>: 77,79
public static Test suite() { [EOL]     return new TestSuite(ShapeListTests.class); [EOL] } <line_num>: 68,70
public void testEquals() { [EOL]     ShapeList l1 = new ShapeList(); [EOL]     l1.setShape(0, new Rectangle(1, 2, 3, 4)); [EOL]     l1.setShape(1, new Line2D.Double(1.0, 2.0, 3.0, 4.0)); [EOL]     l1.setShape(2, null); [EOL]     ShapeList l2 = new ShapeList(); [EOL]     l2.setShape(0, new Rectangle(1, 2, 3, 4)); [EOL]     l2.setShape(1, new Line2D.Double(1.0, 2.0, 3.0, 4.0)); [EOL]     l2.setShape(2, null); [EOL]     assertTrue(l1.equals(l2)); [EOL]     assertTrue(l2.equals(l2)); [EOL] } <line_num>: 84,97
public void testCloning() { [EOL]     ShapeList l1 = new ShapeList(); [EOL]     l1.setShape(0, new Rectangle(1, 2, 3, 4)); [EOL]     l1.setShape(1, new Line2D.Double(1.0, 2.0, 3.0, 4.0)); [EOL]     l1.setShape(2, null); [EOL]     ShapeList l2 = null; [EOL]     try { [EOL]         l2 = (ShapeList) l1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(l1 != l2); [EOL]     assertTrue(l1.getClass() == l2.getClass()); [EOL]     assertTrue(l1.equals(l2)); [EOL]     l2.setShape(0, new Rectangle(5, 6, 7, 8)); [EOL]     assertFalse(l1.equals(l2)); [EOL] } <line_num>: 102,123
public void testSerialization() { [EOL]     ShapeList l1 = new ShapeList(); [EOL]     l1.setShape(0, new Rectangle(1, 2, 3, 4)); [EOL]     l1.setShape(1, new Line2D.Double(1.0, 2.0, 3.0, 4.0)); [EOL]     l1.setShape(2, null); [EOL]     ShapeList l2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(l1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         l2 = (ShapeList) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(l1, l2); [EOL] } <line_num>: 128,153
