@Test [EOL] public void testAccessors() { [EOL]     final NumberIsTooSmallException e = new NumberIsTooSmallException(0, 0, false); [EOL]     Assert.assertEquals(0, e.getArgument()); [EOL]     Assert.assertEquals(0, e.getMin()); [EOL]     Assert.assertFalse(e.getBoundIsAllowed()); [EOL] } <line_num>: 28,34