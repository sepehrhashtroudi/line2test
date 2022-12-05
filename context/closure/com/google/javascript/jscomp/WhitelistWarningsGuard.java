public WhitelistWarningsGuard(Set<String> whitelist)
private static Set<String> normalizeWhitelist(Set<String> whitelist)
public CheckLevel level(JSError error)
protected boolean containWarning(String formattedWarning)
public int getPriority()
public static WhitelistWarningsGuard fromFile(File file)
public static Set<String> loadWhitelistedJsWarnings(File file)
protected static Set<String> loadWhitelistedJsWarnings(InputSupplier<? extends Reader> supplier)
 static Set<String> loadWhitelistedJsWarnings(Reader reader) throws IOException
public static String formatWarning(JSError error)
public static String formatWarning(JSError error, boolean withMetaData)
public static String getFirstLine(String warning)
public WhitelistBuilder setProductName(String name)
public WhitelistBuilder setGeneratorTarget(String name)
public WhitelistBuilder setNote(String note)
public WhitelistBuilder setWithLineNumber(boolean line)
public void report(CheckLevel level, JSError error)
public void writeWhitelist(File out) throws IOException
public void appendWhitelist(PrintStream out)
Splitter LINE_SPLITTER=Optional[Splitter.on("\n")]
Set<String> whitelist
Pattern LINE_NUMBER=Optional[Pattern.compile(":-?\\d+")]
