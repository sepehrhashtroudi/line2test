public XYBoxAndWhiskerRendererTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 81,83
public static Test suite() { [EOL]     return new TestSuite(XYBoxAndWhiskerRendererTests.class); [EOL] } <line_num>: 72,74
public void testEquals() { [EOL]     XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer(); [EOL]     XYBoxAndWhiskerRenderer r2 = new XYBoxAndWhiskerRenderer(); [EOL]     assertEquals(r1, r2); [EOL]     r1.setArtifactPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red)); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setArtifactPaint(new GradientPaint(1.0f, 2.0f, Color.green, 3.0f, 4.0f, Color.red)); [EOL]     assertEquals(r1, r2); [EOL]     r1.setBoxWidth(0.55); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setBoxWidth(0.55); [EOL]     assertEquals(r1, r2); [EOL]     r1.setFillBox(!r1.getFillBox()); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setFillBox(!r2.getFillBox()); [EOL]     assertEquals(r1, r2); [EOL]     r1.setBoxPaint(Color.yellow); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setBoxPaint(Color.yellow); [EOL]     assertEquals(r1, r2); [EOL]     r1.setBoxPaint(null); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setBoxPaint(null); [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 88,122
public void testHashcode() { [EOL]     XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer(); [EOL]     XYBoxAndWhiskerRenderer r2 = new XYBoxAndWhiskerRenderer(); [EOL]     assertTrue(r1.equals(r2)); [EOL]     int h1 = r1.hashCode(); [EOL]     int h2 = r2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 127,134
public void testCloning() { [EOL]     XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer(); [EOL]     XYBoxAndWhiskerRenderer r2 = null; [EOL]     try { [EOL]         r2 = (XYBoxAndWhiskerRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         System.err.println("Failed to clone."); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 139,151
public void testPublicCloneable() { [EOL]     XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer(); [EOL]     assertTrue(r1 instanceof PublicCloneable); [EOL] } <line_num>: 156,159
public void testSerialization() { [EOL]     XYBoxAndWhiskerRenderer r1 = new XYBoxAndWhiskerRenderer(); [EOL]     XYBoxAndWhiskerRenderer r2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(r1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         r2 = (XYBoxAndWhiskerRenderer) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         System.out.println(e.toString()); [EOL]     } [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 164,186