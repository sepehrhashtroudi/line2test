public static StrMatcher commaMatcher() { [EOL]     return COMMA_MATCHER; [EOL] } <line_num>: 80
public static StrMatcher tabMatcher() { [EOL]     return TAB_MATCHER; [EOL] } <line_num>: 89
public static StrMatcher spaceMatcher() { [EOL]     return SPACE_MATCHER; [EOL] } <line_num>: 98
public static StrMatcher splitMatcher() { [EOL]     return SPLIT_MATCHER; [EOL] } <line_num>: 108
public static StrMatcher trimMatcher() { [EOL]     return TRIM_MATCHER; [EOL] } <line_num>: 117
public static StrMatcher singleQuoteMatcher() { [EOL]     return SINGLE_QUOTE_MATCHER; [EOL] } <line_num>: 126
public static StrMatcher doubleQuoteMatcher() { [EOL]     return DOUBLE_QUOTE_MATCHER; [EOL] } <line_num>: 135
public static StrMatcher quoteMatcher() { [EOL]     return QUOTE_MATCHER; [EOL] } <line_num>: 144
public static StrMatcher noneMatcher() { [EOL]     return NONE_MATCHER; [EOL] } <line_num>: 153
public static StrMatcher charMatcher(final char ch) { [EOL]     return new CharMatcher(ch); [EOL] } <line_num>: 163
public static StrMatcher charSetMatcher(final char... chars) { [EOL]     if (chars == null || chars.length == 0) { [EOL]         return NONE_MATCHER; [EOL]     } [EOL]     if (chars.length == 1) { [EOL]         return new CharMatcher(chars[0]); [EOL]     } [EOL]     return new CharSetMatcher(chars); [EOL] } <line_num>: 173
public static StrMatcher charSetMatcher(final String chars) { [EOL]     if (StringUtils.isEmpty(chars)) { [EOL]         return NONE_MATCHER; [EOL]     } [EOL]     if (chars.length() == 1) { [EOL]         return new CharMatcher(chars.charAt(0)); [EOL]     } [EOL]     return new CharSetMatcher(chars.toCharArray()); [EOL] } <line_num>: 189
public static StrMatcher stringMatcher(final String str) { [EOL]     if (StringUtils.isEmpty(str)) { [EOL]         return NONE_MATCHER; [EOL]     } [EOL]     return new StringMatcher(str); [EOL] } <line_num>: 205
public abstract int isMatch(char[] buffer, int pos, int bufferStart, int bufferEnd); <line_num>: 245
public int isMatch(final char[] buffer, final int pos) { [EOL]     return isMatch(buffer, pos, 0, buffer.length); [EOL] } <line_num>: 267
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return Arrays.binarySearch(chars, buffer[pos]) >= 0 ? 1 : 0; [EOL] } <line_num>: 300
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return ch == buffer[pos] ? 1 : 0; [EOL] } <line_num>: 333
@Override [EOL] public int isMatch(final char[] buffer, int pos, final int bufferStart, final int bufferEnd) { [EOL]     final int len = chars.length; [EOL]     if (pos + len > bufferEnd) { [EOL]         return 0; [EOL]     } [EOL]     for (int i = 0; i < chars.length; i++, pos++) { [EOL]         if (chars[i] != buffer[pos]) { [EOL]             return 0; [EOL]         } [EOL]     } [EOL]     return len; [EOL] } <line_num>: 366
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return 0; [EOL] } <line_num>: 403
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return buffer[pos] <= 32 ? 1 : 0; [EOL] } <line_num>: 431
