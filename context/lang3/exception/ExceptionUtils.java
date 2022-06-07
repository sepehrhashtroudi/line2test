ExceptionUtils
public static String[] getDefaultCauseMethodNames()
public static Throwable getCause(final Throwable throwable)
public static Throwable getCause(final Throwable throwable, String[] methodNames)
public static Throwable getRootCause(final Throwable throwable)
private static Throwable getCauseUsingMethodName(final Throwable throwable, final String methodName)
public static int getThrowableCount(final Throwable throwable)
public static Throwable[] getThrowables(final Throwable throwable)
public static List<Throwable> getThrowableList(Throwable throwable)
public static int indexOfThrowable(final Throwable throwable, final Class<?> clazz)
public static int indexOfThrowable(final Throwable throwable, final Class<?> clazz, final int fromIndex)
public static int indexOfType(final Throwable throwable, final Class<?> type)
public static int indexOfType(final Throwable throwable, final Class<?> type, final int fromIndex)
private static int indexOf(final Throwable throwable, final Class<?> type, int fromIndex, final boolean subclass)
public static void printRootCauseStackTrace(final Throwable throwable)
public static void printRootCauseStackTrace(final Throwable throwable, final PrintStream stream)
public static void printRootCauseStackTrace(final Throwable throwable, final PrintWriter writer)
public static String[] getRootCauseStackTrace(final Throwable throwable)
public static void removeCommonFrames(final List<String> causeFrames, final List<String> wrapperFrames)
public static String getStackTrace(final Throwable throwable)
public static String[] getStackFrames(final Throwable throwable)
 static String[] getStackFrames(final String stackTrace)
 static List<String> getStackFrameList(final Throwable t)
public static String getMessage(final Throwable th)
public static String getRootCauseMessage(final Throwable th)
String WRAPPED_MARKER=Optional[" [wrapped] "]
String[] CAUSE_METHOD_NAMES=Optional[{ "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" }]
