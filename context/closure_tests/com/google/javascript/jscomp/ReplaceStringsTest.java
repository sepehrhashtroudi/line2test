public ReplaceStringsTest()
protected CompilerOptions getOptions()
protected void setUp() throws Exception
public void process(Node externs, Node js)
public CompilerPass getProcessor(final Compiler compiler)
public int getNumRepetitions()
public void testStable1()
public void testStable2()
public void testThrowError1()
public void testThrowError2()
public void testThrowError3()
public void testThrowError4()
public void testThrowNonStringError()
public void testThrowConstStringError()
public void testThrowNewError1()
public void testThrowNewError2()
public void testStartTracer1()
public void testStartTracer2()
public void testStartTracer3()
public void testStartTracer4()
public void testLoggerInitialization()
public void testLoggerOnObject1()
public void testLoggerOnObject2()
public void testLoggerOnObject3a()
public void testLoggerOnObject3b()
public void testLoggerOnObject4()
public void testLoggerOnObject5()
public void testLoggerOnVar()
public void testLoggerOnThis()
public void testRepeatedErrorString1()
public void testRepeatedErrorString2()
public void testRepeatedErrorString3()
public void testRepeatedTracerString()
public void testRepeatedLoggerString()
public void testRepeatedStringsWithDifferentMethods()
public void testReserved()
private void testDebugStrings(String js, String expected, String[] substitutedStrings)
ReplaceStrings pass
Set<String> reserved
VariableMap previous
String EXTERNS=Optional["var goog = {};\n" + "goog.debug = {};\n" + "/** @constructor */\n" + "goog.debug.Trace = function() {};\n" + "goog.debug.Trace.startTracer = function (var_args) {};\n" + "/** @constructor */\n" + "goog.debug.Logger = function() {};\n" + "goog.debug.Logger.prototype.info = function(msg, opt_ex) {};\n" + "/**\n" + " * @param {string} name\n" + " * @return {!goog.debug.Logger}\n" + " */\n" + "goog.debug.Logger.getLogger = function(name){};\n"]