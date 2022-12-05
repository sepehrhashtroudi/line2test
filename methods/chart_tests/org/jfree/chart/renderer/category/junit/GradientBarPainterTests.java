public GradientBarPainterTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 76,78
public static Test suite() { [EOL]     return new TestSuite(GradientBarPainterTests.class); [EOL] } <line_num>: 67,69
public void testEquals() { [EOL]     GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3); [EOL]     GradientBarPainter p2 = new GradientBarPainter(0.1, 0.2, 0.3); [EOL]     assertEquals(p1, p2); [EOL]     p1 = new GradientBarPainter(0.11, 0.2, 0.3); [EOL]     assertFalse(p1.equals(p2)); [EOL]     p2 = new GradientBarPainter(0.11, 0.2, 0.3); [EOL]     assertTrue(p1.equals(p2)); [EOL]     p1 = new GradientBarPainter(0.11, 0.22, 0.3); [EOL]     assertFalse(p1.equals(p2)); [EOL]     p2 = new GradientBarPainter(0.11, 0.22, 0.3); [EOL]     assertTrue(p1.equals(p2)); [EOL]     p1 = new GradientBarPainter(0.11, 0.22, 0.33); [EOL]     assertFalse(p1.equals(p2)); [EOL]     p2 = new GradientBarPainter(0.11, 0.22, 0.33); [EOL]     assertTrue(p1.equals(p2)); [EOL] } <line_num>: 83,102
public void testHashcode() { [EOL]     GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3); [EOL]     GradientBarPainter p2 = new GradientBarPainter(0.1, 0.2, 0.3); [EOL]     assertTrue(p1.equals(p2)); [EOL]     int h1 = p1.hashCode(); [EOL]     int h2 = p2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 107,114
public void testCloning() { [EOL]     GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3); [EOL]     assertFalse(p1 instanceof Cloneable); [EOL]     assertFalse(p1 instanceof PublicCloneable); [EOL] } <line_num>: 120,124
public void testSerialization() { [EOL]     GradientBarPainter p1 = new GradientBarPainter(0.1, 0.2, 0.3); [EOL]     GradientBarPainter p2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(p1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         p2 = (GradientBarPainter) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(p1, p2); [EOL] } <line_num>: 129,146
