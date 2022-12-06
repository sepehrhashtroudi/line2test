@Test [EOL] public void testGetJavaVersion() { [EOL]     assertEquals("0.9 failed", JAVA_0_9, get("0.9")); [EOL]     assertEquals("1.1 failed", JAVA_1_1, get("1.1")); [EOL]     assertEquals("1.2 failed", JAVA_1_2, get("1.2")); [EOL]     assertEquals("1.3 failed", JAVA_1_3, get("1.3")); [EOL]     assertEquals("1.4 failed", JAVA_1_4, get("1.4")); [EOL]     assertEquals("1.5 failed", JAVA_1_5, get("1.5")); [EOL]     assertEquals("1.6 failed", JAVA_1_6, get("1.6")); [EOL]     assertEquals("1.7 failed", JAVA_1_7, get("1.7")); [EOL]     assertEquals("1.8 failed", JAVA_1_8, get("1.8")); [EOL]     assertNull("1.9 unexpectedly worked", get("1.9")); [EOL]     assertEquals("Wrapper method failed", get("1.5"), getJavaVersion("1.5")); [EOL] } <line_num>: 42,55
@Test [EOL] public void testAtLeast() { [EOL]     assertFalse("1.2 at least 1.5 passed", JAVA_1_2.atLeast(JAVA_1_5)); [EOL]     assertTrue("1.5 at least 1.2 failed", JAVA_1_5.atLeast(JAVA_1_2)); [EOL]     assertFalse("1.6 at least 1.7 passed", JAVA_1_6.atLeast(JAVA_1_7)); [EOL]     assertTrue("0.9 at least 1.5 failed", JAVA_0_9.atLeast(JAVA_1_5)); [EOL]     assertFalse("0.9 at least 1.6 passed", JAVA_0_9.atLeast(JAVA_1_6)); [EOL] } <line_num>: 57,65
@Test [EOL] public void testToString() { [EOL]     assertEquals("1.2", JAVA_1_2.toString()); [EOL] } <line_num>: 67,70