public WindItemRendererTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 77,79
public static Test suite() { [EOL]     return new TestSuite(WindItemRendererTests.class); [EOL] } <line_num>: 68,70
public void testEquals() { [EOL]     WindItemRenderer r1 = new WindItemRenderer(); [EOL]     WindItemRenderer r2 = new WindItemRenderer(); [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 84,88
public void testHashcode() { [EOL]     WindItemRenderer r1 = new WindItemRenderer(); [EOL]     WindItemRenderer r2 = new WindItemRenderer(); [EOL]     assertTrue(r1.equals(r2)); [EOL]     int h1 = r1.hashCode(); [EOL]     int h2 = r2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 93,100
public void testCloning() { [EOL]     WindItemRenderer r1 = new WindItemRenderer(); [EOL]     WindItemRenderer r2 = null; [EOL]     try { [EOL]         r2 = (WindItemRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         System.err.println("Failed to clone."); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 105,117
public void testPublicCloneable() { [EOL]     WindItemRenderer r1 = new WindItemRenderer(); [EOL]     assertTrue(r1 instanceof PublicCloneable); [EOL] } <line_num>: 122,125
public void testSerialization() { [EOL]     WindItemRenderer r1 = new WindItemRenderer(); [EOL]     WindItemRenderer r2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(r1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         r2 = (WindItemRenderer) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         System.out.println(e.toString()); [EOL]     } [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 130,151
