@Override [EOL] protected FastDateFormat createInstance(final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     return new FastDateFormat(pattern, timeZone, locale); [EOL] } <line_num>: 90
public static FastDateFormat getInstance() { [EOL]     return cache.getInstance(); [EOL] } <line_num>: 105
public static FastDateFormat getInstance(final String pattern) { [EOL]     return cache.getInstance(pattern, null, null); [EOL] } <line_num>: 118
public static FastDateFormat getInstance(final String pattern, final TimeZone timeZone) { [EOL]     return cache.getInstance(pattern, timeZone, null); [EOL] } <line_num>: 133
public static FastDateFormat getInstance(final String pattern, final Locale locale) { [EOL]     return cache.getInstance(pattern, null, locale); [EOL] } <line_num>: 147
public static FastDateFormat getInstance(final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getInstance(pattern, timeZone, locale); [EOL] } <line_num>: 164
public static FastDateFormat getDateInstance(final int style) { [EOL]     return cache.getDateInstance(style, null, null); [EOL] } <line_num>: 179
public static FastDateFormat getDateInstance(final int style, final Locale locale) { [EOL]     return cache.getDateInstance(style, null, locale); [EOL] } <line_num>: 194
public static FastDateFormat getDateInstance(final int style, final TimeZone timeZone) { [EOL]     return cache.getDateInstance(style, timeZone, null); [EOL] } <line_num>: 210
public static FastDateFormat getDateInstance(final int style, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getDateInstance(style, timeZone, locale); [EOL] } <line_num>: 226
public static FastDateFormat getTimeInstance(final int style) { [EOL]     return cache.getTimeInstance(style, null, null); [EOL] } <line_num>: 241
public static FastDateFormat getTimeInstance(final int style, final Locale locale) { [EOL]     return cache.getTimeInstance(style, null, locale); [EOL] } <line_num>: 256
public static FastDateFormat getTimeInstance(final int style, final TimeZone timeZone) { [EOL]     return cache.getTimeInstance(style, timeZone, null); [EOL] } <line_num>: 272
public static FastDateFormat getTimeInstance(final int style, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getTimeInstance(style, timeZone, locale); [EOL] } <line_num>: 288
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle) { [EOL]     return cache.getDateTimeInstance(dateStyle, timeStyle, null, null); [EOL] } <line_num>: 304
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final Locale locale) { [EOL]     return cache.getDateTimeInstance(dateStyle, timeStyle, null, locale); [EOL] } <line_num>: 320
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final TimeZone timeZone) { [EOL]     return getDateTimeInstance(dateStyle, timeStyle, timeZone, null); [EOL] } <line_num>: 337
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getDateTimeInstance(dateStyle, timeStyle, timeZone, locale); [EOL] } <line_num>: 353
@Override [EOL] public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { [EOL]     return printer.format(obj, toAppendTo, pos); [EOL] } <line_num>: 385
@Override [EOL] public String format(final long millis) { [EOL]     return printer.format(millis); [EOL] } <line_num>: 397
@Override [EOL] public String format(final Date date) { [EOL]     return printer.format(date); [EOL] } <line_num>: 408
@Override [EOL] public String format(final Calendar calendar) { [EOL]     return printer.format(calendar); [EOL] } <line_num>: 419
@Override [EOL] public StringBuffer format(final long millis, final StringBuffer buf) { [EOL]     return printer.format(millis, buf); [EOL] } <line_num>: 433
@Override [EOL] public StringBuffer format(final Date date, final StringBuffer buf) { [EOL]     return printer.format(date, buf); [EOL] } <line_num>: 446
@Override [EOL] public StringBuffer format(final Calendar calendar, final StringBuffer buf) { [EOL]     return printer.format(calendar, buf); [EOL] } <line_num>: 459
@Override [EOL] public Date parse(final String source) throws ParseException { [EOL]     return parser.parse(source); [EOL] } <line_num>: 471
@Override [EOL] public Date parse(final String source, final ParsePosition pos) { [EOL]     return parser.parse(source, pos); [EOL] } <line_num>: 479
@Override [EOL] public Object parseObject(final String source, final ParsePosition pos) { [EOL]     return parser.parseObject(source, pos); [EOL] } <line_num>: 487
@Override [EOL] public String getPattern() { [EOL]     return printer.getPattern(); [EOL] } <line_num>: 499
@Override [EOL] public TimeZone getTimeZone() { [EOL]     return printer.getTimeZone(); [EOL] } <line_num>: 511
@Override [EOL] public Locale getLocale() { [EOL]     return printer.getLocale(); [EOL] } <line_num>: 521
public int getMaxLengthEstimate() { [EOL]     return printer.getMaxLengthEstimate(); [EOL] } <line_num>: 534
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof FastDateFormat == false) { [EOL]         return false; [EOL]     } [EOL]     final FastDateFormat other = (FastDateFormat) obj; [EOL]     return printer.equals(other.printer); [EOL] } <line_num>: 547
@Override [EOL] public int hashCode() { [EOL]     return printer.hashCode(); [EOL] } <line_num>: 562
@Override [EOL] public String toString() { [EOL]     return "FastDateFormat[" + printer.getPattern() + "," + printer.getLocale() + "," + printer.getTimeZone().getID() + "]"; [EOL] } <line_num>: 572
protected StringBuffer applyRules(final Calendar calendar, final StringBuffer buf) { [EOL]     return printer.applyRules(calendar, buf); [EOL] } <line_num>: 585
