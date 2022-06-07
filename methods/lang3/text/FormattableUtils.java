public static String toString(final Formattable formattable) { [EOL]     return String.format(SIMPLEST_FORMAT, formattable); [EOL] } <line_num>: 65
public static Formatter append(final CharSequence seq, final Formatter formatter, final int flags, final int width, final int precision) { [EOL]     return append(seq, formatter, flags, width, precision, ' ', null); [EOL] } <line_num>: 81
public static Formatter append(final CharSequence seq, final Formatter formatter, final int flags, final int width, final int precision, final char padChar) { [EOL]     return append(seq, formatter, flags, width, precision, padChar, null); [EOL] } <line_num>: 98
public static Formatter append(final CharSequence seq, final Formatter formatter, final int flags, final int width, final int precision, final CharSequence ellipsis) { [EOL]     return append(seq, formatter, flags, width, precision, ' ', ellipsis); [EOL] } <line_num>: 116
public static Formatter append(final CharSequence seq, final Formatter formatter, final int flags, final int width, final int precision, final char padChar, final CharSequence ellipsis) { [EOL]     Validate.isTrue(ellipsis == null || precision < 0 || ellipsis.length() <= precision, "Specified ellipsis '%1$s' exceeds precision of %2$s", ellipsis, Integer.valueOf(precision)); [EOL]     final StringBuilder buf = new StringBuilder(seq); [EOL]     if (precision >= 0 && precision < seq.length()) { [EOL]         final CharSequence _ellipsis = ObjectUtils.defaultIfNull(ellipsis, StringUtils.EMPTY); [EOL]         buf.replace(precision - _ellipsis.length(), seq.length(), _ellipsis.toString()); [EOL]     } [EOL]     final boolean leftJustify = (flags & LEFT_JUSTIFY) == LEFT_JUSTIFY; [EOL]     for (int i = buf.length(); i < width; i++) { [EOL]         buf.insert(leftJustify ? i : 0, padChar); [EOL]     } [EOL]     formatter.format(buf.toString()); [EOL]     return formatter; [EOL] } <line_num>: 134
