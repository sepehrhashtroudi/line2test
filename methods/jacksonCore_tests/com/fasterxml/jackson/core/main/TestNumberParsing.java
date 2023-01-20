public void testIntParsing() throws Exception { [EOL]     char[] testChars = "123456789".toCharArray(); [EOL]     assertEquals(3, NumberInput.parseInt(testChars, 2, 1)); [EOL]     assertEquals(123, NumberInput.parseInt(testChars, 0, 3)); [EOL]     assertEquals(2345, NumberInput.parseInt(testChars, 1, 4)); [EOL]     assertEquals(9, NumberInput.parseInt(testChars, 8, 1)); [EOL]     assertEquals(456789, NumberInput.parseInt(testChars, 3, 6)); [EOL]     assertEquals(23456, NumberInput.parseInt(testChars, 1, 5)); [EOL]     assertEquals(123456789, NumberInput.parseInt(testChars, 0, 9)); [EOL]     testChars = "32".toCharArray(); [EOL]     assertEquals(32, NumberInput.parseInt(testChars, 0, 2)); [EOL]     testChars = "189".toCharArray(); [EOL]     assertEquals(189, NumberInput.parseInt(testChars, 0, 3)); [EOL]     testChars = "10".toCharArray(); [EOL]     assertEquals(10, NumberInput.parseInt(testChars, 0, 2)); [EOL]     assertEquals(0, NumberInput.parseInt(testChars, 1, 1)); [EOL] } <line_num>: 12,32
public void testIntParsingWithStrings() throws Exception { [EOL]     assertEquals(3, NumberInput.parseInt("3")); [EOL]     assertEquals(0, NumberInput.parseInt("0")); [EOL]     assertEquals(-3, NumberInput.parseInt("-3")); [EOL]     assertEquals(27, NumberInput.parseInt("27")); [EOL]     assertEquals(-31, NumberInput.parseInt("-31")); [EOL]     assertEquals(271, NumberInput.parseInt("271")); [EOL]     assertEquals(-131, NumberInput.parseInt("-131")); [EOL]     assertEquals(2709, NumberInput.parseInt("2709")); [EOL]     assertEquals(-9999, NumberInput.parseInt("-9999")); [EOL]     assertEquals(Integer.MIN_VALUE, NumberInput.parseInt("" + Integer.MIN_VALUE)); [EOL]     assertEquals(Integer.MAX_VALUE, NumberInput.parseInt("" + Integer.MAX_VALUE)); [EOL] } <line_num>: 34,47
public void testLongParsing() throws Exception { [EOL]     char[] testChars = "123456789012345678".toCharArray(); [EOL]     assertEquals(123456789012345678L, NumberInput.parseLong(testChars, 0, testChars.length)); [EOL] } <line_num>: 49,54
public void testLongBoundsChecks() throws Exception { [EOL]     String minLong = String.valueOf(Long.MIN_VALUE).substring(1); [EOL]     String maxLong = String.valueOf(Long.MAX_VALUE); [EOL]     final String VALUE_491 = "1323372036854775807"; [EOL]     final String OVERFLOW = "9999999999999999999"; [EOL]     assertTrue(NumberInput.inLongRange(minLong, true)); [EOL]     assertTrue(NumberInput.inLongRange(maxLong, false)); [EOL]     assertTrue(NumberInput.inLongRange(VALUE_491, true)); [EOL]     assertTrue(NumberInput.inLongRange(VALUE_491, false)); [EOL]     assertFalse(NumberInput.inLongRange(OVERFLOW, false)); [EOL]     assertFalse(NumberInput.inLongRange(OVERFLOW, true)); [EOL]     char[] cbuf = minLong.toCharArray(); [EOL]     assertTrue(NumberInput.inLongRange(cbuf, 0, cbuf.length, true)); [EOL]     cbuf = maxLong.toCharArray(); [EOL]     assertTrue(NumberInput.inLongRange(cbuf, 0, cbuf.length, false)); [EOL]     cbuf = VALUE_491.toCharArray(); [EOL]     assertTrue(NumberInput.inLongRange(cbuf, 0, cbuf.length, true)); [EOL]     assertTrue(NumberInput.inLongRange(cbuf, 0, cbuf.length, false)); [EOL]     cbuf = OVERFLOW.toCharArray(); [EOL]     assertFalse(NumberInput.inLongRange(cbuf, 0, cbuf.length, true)); [EOL]     assertFalse(NumberInput.inLongRange(cbuf, 0, cbuf.length, false)); [EOL] } <line_num>: 57,81