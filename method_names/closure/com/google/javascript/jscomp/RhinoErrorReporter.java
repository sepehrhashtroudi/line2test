private RhinoErrorReporter(AbstractCompiler compiler)
private OldRhinoErrorReporter(AbstractCompiler compiler)
private NewRhinoErrorReporter(AbstractCompiler compiler)
private Pattern replacePlaceHolders(String s)
public static com.google.javascript.rhino.head.ErrorReporter forNewRhino(AbstractCompiler compiler)
public static ErrorReporter forOldRhino(AbstractCompiler compiler)
 void warningAtLine(String message, String sourceName, int line, int lineOffset)
 void errorAtLine(String message, String sourceName, int line, int lineOffset)
private JSError makeError(String message, String sourceName, int line, int lineOffset, CheckLevel defaultLevel)
public void error(String message, String sourceName, int line, int lineOffset)
public void warning(String message, String sourceName, int line, int lineOffset)
public com.google.javascript.rhino.head.EvaluatorException runtimeError(String message, String sourceName, int line, String lineSource, int lineOffset)
public void error(String message, String sourceName, int line, String sourceLine, int lineOffset)
public void error(String message, String sourceName, int offset, int length)
public void warning(String message, String sourceName, int line, String sourceLine, int lineOffset)
public void warning(String message, String sourceName, int offset, int length)