public TestDrawable() { [EOL] } <line_num>: 74,75
public XYDrawableAnnotationTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 124,126
public void draw(Graphics2D g2, Rectangle2D area) { [EOL] } <line_num>: 81,83
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof TestDrawable)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 89,97
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 105,107
public static Test suite() { [EOL]     return new TestSuite(XYDrawableAnnotationTests.class); [EOL] } <line_num>: 115,117
public void testEquals() { [EOL]     XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     XYDrawableAnnotation a2 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYDrawableAnnotation(11.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYDrawableAnnotation(11.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYDrawableAnnotation(11.0, 22.0, 100.0, 200.0, new TestDrawable()); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYDrawableAnnotation(11.0, 22.0, 100.0, 200.0, new TestDrawable()); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 200.0, new TestDrawable()); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 200.0, new TestDrawable()); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, new TestDrawable()); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, new TestDrawable()); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, 2.0, new TestDrawable()); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYDrawableAnnotation(11.0, 22.0, 101.0, 202.0, 2.0, new TestDrawable()); [EOL]     assertTrue(a1.equals(a2)); [EOL] } <line_num>: 131,172
public void testHashCode() { [EOL]     XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     XYDrawableAnnotation a2 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     assertTrue(a1.equals(a2)); [EOL]     int h1 = a1.hashCode(); [EOL]     int h2 = a2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 177,186
public void testCloning() { [EOL]     XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     XYDrawableAnnotation a2 = null; [EOL]     try { [EOL]         a2 = (XYDrawableAnnotation) a1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         System.err.println("Failed to clone."); [EOL]     } [EOL]     assertTrue(a1 != a2); [EOL]     assertTrue(a1.getClass() == a2.getClass()); [EOL]     assertTrue(a1.equals(a2)); [EOL] } <line_num>: 191,204
public void testPublicCloneable() { [EOL]     XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     assertTrue(a1 instanceof PublicCloneable); [EOL] } <line_num>: 209,213
public void testSerialization() { [EOL]     XYDrawableAnnotation a1 = new XYDrawableAnnotation(10.0, 20.0, 100.0, 200.0, new TestDrawable()); [EOL]     XYDrawableAnnotation a2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(a1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         a2 = (XYDrawableAnnotation) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(a1, a2); [EOL] } <line_num>: 218,240
