public TextAnnotationTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 76,78
public static Test suite() { [EOL]     return new TestSuite(TextAnnotationTests.class); [EOL] } <line_num>: 67,69
public void testEquals() { [EOL]     TextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0); [EOL]     TextAnnotation a2 = new CategoryTextAnnotation("Test", "Category", 1.0); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1.setText("Text"); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2.setText("Text"); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1.setFont(new Font("Serif", Font.BOLD, 18)); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2.setFont(new Font("Serif", Font.BOLD, 18)); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.pink)); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2.setPaint(new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.pink)); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1.setTextAnchor(TextAnchor.BOTTOM_LEFT); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2.setTextAnchor(TextAnchor.BOTTOM_LEFT); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1.setRotationAnchor(TextAnchor.BOTTOM_LEFT); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2.setRotationAnchor(TextAnchor.BOTTOM_LEFT); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1.setRotationAngle(Math.PI); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2.setRotationAngle(Math.PI); [EOL]     assertTrue(a1.equals(a2)); [EOL] } <line_num>: 83,127
public void testHashCode() { [EOL]     TextAnnotation a1 = new CategoryTextAnnotation("Test", "Category", 1.0); [EOL]     TextAnnotation a2 = new CategoryTextAnnotation("Test", "Category", 1.0); [EOL]     assertTrue(a1.equals(a2)); [EOL]     int h1 = a1.hashCode(); [EOL]     int h2 = a2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 132,139
