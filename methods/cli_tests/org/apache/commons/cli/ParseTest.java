public ParseTest(String name) { [EOL]     super(name); [EOL] } <line_num>: 32,35
public static Test suite() { [EOL]     return new TestSuite(ParseTest.class); [EOL] } <line_num>: 28,30
public void setUp() { [EOL]     _options = new Options().addOption("a", "enable-a", false, "turn [a] on or off").addOption("b", "bfile", true, "set the value of [b]").addOption("c", "copt", false, "turn [c] on or off"); [EOL]     _parser = new PosixParser(); [EOL] } <line_num>: 37,54
public void tearDown() { [EOL] } <line_num>: 56,59
public void testSimpleShort() { [EOL]     String[] args = new String[] { "-a", "-b", "toast", "foo", "bar" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args); [EOL]         assertTrue("Confirm -a is set", cl.hasOption("a")); [EOL]         assertTrue("Confirm -b is set", cl.hasOption("b")); [EOL]         assertTrue("Confirm arg of -b", cl.getOptionValue("b").equals("toast")); [EOL]         assertTrue("Confirm size of extra args", cl.getArgList().size() == 2); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 61,80
public void testSimpleLong() { [EOL]     String[] args = new String[] { "--enable-a", "--bfile", "toast", "foo", "bar" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args); [EOL]         assertTrue("Confirm -a is set", cl.hasOption("a")); [EOL]         assertTrue("Confirm -b is set", cl.hasOption("b")); [EOL]         assertTrue("Confirm arg of -b", cl.getOptionValue("b").equals("toast")); [EOL]         assertTrue("Confirm arg of --bfile", cl.getOptionValue("bfile").equals("toast")); [EOL]         assertTrue("Confirm size of extra args", cl.getArgList().size() == 2); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 82,102
public void testComplexShort() { [EOL]     String[] args = new String[] { "-acbtoast", "foo", "bar" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args); [EOL]         assertTrue("Confirm -a is set", cl.hasOption("a")); [EOL]         assertTrue("Confirm -b is set", cl.hasOption("b")); [EOL]         assertTrue("Confirm -c is set", cl.hasOption("c")); [EOL]         assertTrue("Confirm arg of -b", cl.getOptionValue("b").equals("toast")); [EOL]         assertTrue("Confirm size of extra args", cl.getArgList().size() == 2); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 104,123
public void testExtraOption() { [EOL]     String[] args = new String[] { "-adbtoast", "foo", "bar" }; [EOL]     boolean caught = false; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args); [EOL]         assertTrue("Confirm -a is set", cl.hasOption("a")); [EOL]         assertTrue("Confirm -b is set", cl.hasOption("b")); [EOL]         assertTrue("confirm arg of -b", cl.getOptionValue("b").equals("toast")); [EOL]         assertTrue("Confirm size of extra args", cl.getArgList().size() == 3); [EOL]     } catch (UnrecognizedOptionException e) { [EOL]         caught = true; [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL]     assertTrue("Confirm UnrecognizedOptionException caught", caught); [EOL] } <line_num>: 125,150
public void testMissingArg() { [EOL]     String[] args = new String[] { "-acb" }; [EOL]     boolean caught = false; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args); [EOL]     } catch (MissingArgumentException e) { [EOL]         caught = true; [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL]     assertTrue("Confirm MissingArgumentException caught", caught); [EOL] } <line_num>: 152,173
public void testStop() { [EOL]     String[] args = new String[] { "-c", "foober", "-btoast" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args, true); [EOL]         assertTrue("Confirm -c is set", cl.hasOption("c")); [EOL]         assertTrue("Confirm  2 extra args: " + cl.getArgList().size(), cl.getArgList().size() == 2); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 175,191
public void testMultiple() { [EOL]     String[] args = new String[] { "-c", "foobar", "-btoast" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args, true); [EOL]         assertTrue("Confirm -c is set", cl.hasOption("c")); [EOL]         assertTrue("Confirm  2 extra args: " + cl.getArgList().size(), cl.getArgList().size() == 2); [EOL]         cl = _parser.parse(_options, cl.getArgs()); [EOL]         assertTrue("Confirm -c is not set", !cl.hasOption("c")); [EOL]         assertTrue("Confirm -b is set", cl.hasOption("b")); [EOL]         assertTrue("Confirm arg of -b", cl.getOptionValue("b").equals("toast")); [EOL]         assertTrue("Confirm  1 extra arg: " + cl.getArgList().size(), cl.getArgList().size() == 1); [EOL]         assertTrue("Confirm  value of extra arg: " + cl.getArgList().get(0), cl.getArgList().get(0).equals("foobar")); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 193,217
public void testMultipleWithLong() { [EOL]     String[] args = new String[] { "--copt", "foobar", "--bfile", "toast" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args, true); [EOL]         assertTrue("Confirm -c is set", cl.hasOption("c")); [EOL]         assertTrue("Confirm  3 extra args: " + cl.getArgList().size(), cl.getArgList().size() == 3); [EOL]         cl = _parser.parse(_options, cl.getArgs()); [EOL]         assertTrue("Confirm -c is not set", !cl.hasOption("c")); [EOL]         assertTrue("Confirm -b is set", cl.hasOption("b")); [EOL]         assertTrue("Confirm arg of -b", cl.getOptionValue("b").equals("toast")); [EOL]         assertTrue("Confirm  1 extra arg: " + cl.getArgList().size(), cl.getArgList().size() == 1); [EOL]         assertTrue("Confirm  value of extra arg: " + cl.getArgList().get(0), cl.getArgList().get(0).equals("foobar")); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 219,244
public void testDoubleDash() { [EOL]     String[] args = new String[] { "--copt", "--", "-b", "toast" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args); [EOL]         assertTrue("Confirm -c is set", cl.hasOption("c")); [EOL]         assertTrue("Confirm -b is not set", !cl.hasOption("b")); [EOL]         assertTrue("Confirm 2 extra args: " + cl.getArgList().size(), cl.getArgList().size() == 2); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 246,265
public void testSingleDash() { [EOL]     String[] args = new String[] { "--copt", "-b", "-", "-a", "-" }; [EOL]     try { [EOL]         CommandLine cl = _parser.parse(_options, args); [EOL]         assertTrue("Confirm -a is set", cl.hasOption("a")); [EOL]         assertTrue("Confirm -b is set", cl.hasOption("b")); [EOL]         assertTrue("Confirm arg of -b", cl.getOptionValue("b").equals("-")); [EOL]         assertTrue("Confirm 1 extra arg: " + cl.getArgList().size(), cl.getArgList().size() == 1); [EOL]         assertTrue("Confirm value of extra arg: " + cl.getArgList().get(0), cl.getArgList().get(0).equals("-")); [EOL]     } catch (ParseException e) { [EOL]         fail(e.toString()); [EOL]     } [EOL] } <line_num>: 267,289
