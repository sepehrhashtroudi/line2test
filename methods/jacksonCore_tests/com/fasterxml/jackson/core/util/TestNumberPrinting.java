public void testIntPrinting() throws Exception { [EOL]     assertIntPrint(0); [EOL]     assertIntPrint(-3); [EOL]     assertIntPrint(1234); [EOL]     assertIntPrint(-1234); [EOL]     assertIntPrint(56789); [EOL]     assertIntPrint(-56789); [EOL]     assertIntPrint(999999); [EOL]     assertIntPrint(-999999); [EOL]     assertIntPrint(1000000); [EOL]     assertIntPrint(-1000000); [EOL]     assertIntPrint(10000001); [EOL]     assertIntPrint(-10000001); [EOL]     assertIntPrint(-100000012); [EOL]     assertIntPrint(100000012); [EOL]     assertIntPrint(1999888777); [EOL]     assertIntPrint(-1999888777); [EOL]     assertIntPrint(Integer.MAX_VALUE); [EOL]     assertIntPrint(Integer.MIN_VALUE); [EOL]     Random rnd = new Random(12345L); [EOL]     for (int i = 0; i < 251000; ++i) { [EOL]         assertIntPrint(rnd.nextInt()); [EOL]     } [EOL] } <line_num>: 14,40
public void testLongPrinting() throws Exception { [EOL]     assertLongPrint(0L, 0); [EOL]     assertLongPrint(1L, 0); [EOL]     assertLongPrint(-1L, 0); [EOL]     assertLongPrint(Long.MAX_VALUE, 0); [EOL]     assertLongPrint(Long.MIN_VALUE, 0); [EOL]     assertLongPrint(Long.MAX_VALUE - 1L, 0); [EOL]     assertLongPrint(Long.MIN_VALUE + 1L, 0); [EOL]     Random rnd = new Random(12345L); [EOL]     for (int i = 0; i < 678000; ++i) { [EOL]         long l = ((long) rnd.nextInt() << 32) | (long) rnd.nextInt(); [EOL]         assertLongPrint(l, i); [EOL]     } [EOL] } <line_num>: 42,60
private void assertIntPrint(int value) { [EOL]     String exp = "" + value; [EOL]     String act = printToString(value); [EOL]     if (!exp.equals(act)) { [EOL]         assertEquals("Expected conversion (exp '" + exp + "', len " + exp.length() + "; act len " + act.length() + ")", exp, act); [EOL]     } [EOL] } <line_num>: 68,76
private void assertLongPrint(long value, int index) { [EOL]     String exp = "" + value; [EOL]     String act = printToString(value); [EOL]     if (!exp.equals(act)) { [EOL]         assertEquals("Expected conversion (exp '" + exp + "', len " + exp.length() + "; act len " + act.length() + "; number index " + index + ")", exp, act); [EOL]     } [EOL] } <line_num>: 78,86
private String printToString(int value) { [EOL]     char[] buffer = new char[12]; [EOL]     int offset = NumberOutput.outputInt(value, buffer, 0); [EOL]     return new String(buffer, 0, offset); [EOL] } <line_num>: 88,93
private String printToString(long value) { [EOL]     char[] buffer = new char[22]; [EOL]     int offset = NumberOutput.outputLong(value, buffer, 0); [EOL]     return new String(buffer, 0, offset); [EOL] } <line_num>: 95,100