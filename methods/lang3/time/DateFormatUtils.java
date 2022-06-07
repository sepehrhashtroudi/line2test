public static String formatUTC(final long millis, final String pattern) { [EOL]     return format(new Date(millis), pattern, UTC_TIME_ZONE, null); [EOL] } <line_num>: 130
public static String formatUTC(final Date date, final String pattern) { [EOL]     return format(date, pattern, UTC_TIME_ZONE, null); [EOL] } <line_num>: 141
public static String formatUTC(final long millis, final String pattern, final Locale locale) { [EOL]     return format(new Date(millis), pattern, UTC_TIME_ZONE, locale); [EOL] } <line_num>: 153
public static String formatUTC(final Date date, final String pattern, final Locale locale) { [EOL]     return format(date, pattern, UTC_TIME_ZONE, locale); [EOL] } <line_num>: 165
public static String format(final long millis, final String pattern) { [EOL]     return format(new Date(millis), pattern, null, null); [EOL] } <line_num>: 176
public static String format(final Date date, final String pattern) { [EOL]     return format(date, pattern, null, null); [EOL] } <line_num>: 187
public static String format(final Calendar calendar, final String pattern) { [EOL]     return format(calendar, pattern, null, null); [EOL] } <line_num>: 200
public static String format(final long millis, final String pattern, final TimeZone timeZone) { [EOL]     return format(new Date(millis), pattern, timeZone, null); [EOL] } <line_num>: 212
public static String format(final Date date, final String pattern, final TimeZone timeZone) { [EOL]     return format(date, pattern, timeZone, null); [EOL] } <line_num>: 224
public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone) { [EOL]     return format(calendar, pattern, timeZone, null); [EOL] } <line_num>: 238
public static String format(final long millis, final String pattern, final Locale locale) { [EOL]     return format(new Date(millis), pattern, null, locale); [EOL] } <line_num>: 250
public static String format(final Date date, final String pattern, final Locale locale) { [EOL]     return format(date, pattern, null, locale); [EOL] } <line_num>: 262
public static String format(final Calendar calendar, final String pattern, final Locale locale) { [EOL]     return format(calendar, pattern, null, locale); [EOL] } <line_num>: 276
public static String format(final long millis, final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     return format(new Date(millis), pattern, timeZone, locale); [EOL] } <line_num>: 289
public static String format(final Date date, final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale); [EOL]     return df.format(date); [EOL] } <line_num>: 302
public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale); [EOL]     return df.format(calendar); [EOL] } <line_num>: 318
