protected FastDateParser(final String pattern, final TimeZone timeZone, final Locale locale)
 CopyQuotedStrategy(final String formatField)
 TextStrategy(final int field, final Calendar definingCalendar, final Locale locale)
 NumberStrategy(final int field)
 TimeZoneStrategy(final Locale locale)
private void init()
public String getPattern()
public TimeZone getTimeZone()
public Locale getLocale()
 Pattern getParsePattern()
public boolean equals(final Object obj)
public int hashCode()
public String toString()
private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException
public Object parseObject(final String source) throws ParseException
public Date parse(final String source) throws ParseException
public Object parseObject(final String source, final ParsePosition pos)
public Date parse(final String source, final ParsePosition pos)
private static StringBuilder escapeRegex(final StringBuilder regex, final String value, final boolean unquote)
private static Map<String, Integer> getDisplayNames(final int field, final Calendar definingCalendar, final Locale locale)
 int adjustYear(final int twoDigitYear)
 boolean isNextNumber()
 int getFieldWidth()
 boolean isNumber()
 void setCalendar(final FastDateParser parser, final Calendar cal, final String value)
 abstract boolean addRegex(FastDateParser parser, StringBuilder regex)
private Strategy getStrategy(String formatField, final Calendar definingCalendar)
private static ConcurrentMap<Locale, Strategy> getCache(final int field)
private Strategy getLocaleSpecificStrategy(final int field, final Calendar definingCalendar)
 boolean isNumber()
 boolean addRegex(final FastDateParser parser, final StringBuilder regex)
 boolean addRegex(final FastDateParser parser, final StringBuilder regex)
 void setCalendar(final FastDateParser parser, final Calendar cal, final String value)
 boolean isNumber()
 boolean addRegex(final FastDateParser parser, final StringBuilder regex)
 void setCalendar(final FastDateParser parser, final Calendar cal, final String value)
 int modify(final int iValue)
 void setCalendar(final FastDateParser parser, final Calendar cal, final String value)
 boolean addRegex(final FastDateParser parser, final StringBuilder regex)
 void setCalendar(final FastDateParser parser, final Calendar cal, final String value)
 int modify(final int iValue)
 int modify(final int iValue)
 int modify(final int iValue)
