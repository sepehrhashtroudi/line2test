public DeviationRendererTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 77,79
public static Test suite() { [EOL]     return new TestSuite(DeviationRendererTests.class); [EOL] } <line_num>: 68,70
public void testEquals() { [EOL]     DeviationRenderer r1 = new DeviationRenderer(); [EOL]     DeviationRenderer r2 = new DeviationRenderer(); [EOL]     assertTrue(r1.equals(r2)); [EOL]     assertTrue(r2.equals(r1)); [EOL]     r1.setAlpha(0.1f); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setAlpha(0.1f); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 84,97
public void testHashcode() { [EOL]     DeviationRenderer r1 = new DeviationRenderer(); [EOL]     DeviationRenderer r2 = new DeviationRenderer(); [EOL]     assertTrue(r1.equals(r2)); [EOL]     int h1 = r1.hashCode(); [EOL]     int h2 = r2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 102,109
public void testCloning() { [EOL]     DeviationRenderer r1 = new DeviationRenderer(); [EOL]     DeviationRenderer r2 = null; [EOL]     try { [EOL]         r2 = (DeviationRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 114,129
public void testPublicCloneable() { [EOL]     DeviationRenderer r1 = new DeviationRenderer(); [EOL]     assertTrue(r1 instanceof PublicCloneable); [EOL] } <line_num>: 134,137
public void testSerialization() { [EOL]     DeviationRenderer r1 = new DeviationRenderer(); [EOL]     DeviationRenderer r2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(r1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         r2 = (DeviationRenderer) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 142,163
