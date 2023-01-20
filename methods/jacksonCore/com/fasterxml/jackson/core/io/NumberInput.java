public static int parseInt(char[] digitChars, int offset, int len) { [EOL]     int num = digitChars[offset] - '0'; [EOL]     len += offset; [EOL]     if (++offset < len) { [EOL]         num = (num * 10) + (digitChars[offset] - '0'); [EOL]         if (++offset < len) { [EOL]             num = (num * 10) + (digitChars[offset] - '0'); [EOL]             if (++offset < len) { [EOL]                 num = (num * 10) + (digitChars[offset] - '0'); [EOL]                 if (++offset < len) { [EOL]                     num = (num * 10) + (digitChars[offset] - '0'); [EOL]                     if (++offset < len) { [EOL]                         num = (num * 10) + (digitChars[offset] - '0'); [EOL]                         if (++offset < len) { [EOL]                             num = (num * 10) + (digitChars[offset] - '0'); [EOL]                             if (++offset < len) { [EOL]                                 num = (num * 10) + (digitChars[offset] - '0'); [EOL]                                 if (++offset < len) { [EOL]                                     num = (num * 10) + (digitChars[offset] - '0'); [EOL]                                 } [EOL]                             } [EOL]                         } [EOL]                     } [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     return num; [EOL] } <line_num>: 28,58
public static int parseInt(String str) { [EOL]     char c = str.charAt(0); [EOL]     int length = str.length(); [EOL]     boolean negative = (c == '-'); [EOL]     int offset = 1; [EOL]     if (negative) { [EOL]         if (length == 1 || length > 10) { [EOL]             return Integer.parseInt(str); [EOL]         } [EOL]         c = str.charAt(offset++); [EOL]     } else { [EOL]         if (length > 9) { [EOL]             return Integer.parseInt(str); [EOL]         } [EOL]     } [EOL]     if (c > '9' || c < '0') { [EOL]         return Integer.parseInt(str); [EOL]     } [EOL]     int num = c - '0'; [EOL]     if (offset < length) { [EOL]         c = str.charAt(offset++); [EOL]         if (c > '9' || c < '0') { [EOL]             return Integer.parseInt(str); [EOL]         } [EOL]         num = (num * 10) + (c - '0'); [EOL]         if (offset < length) { [EOL]             c = str.charAt(offset++); [EOL]             if (c > '9' || c < '0') { [EOL]                 return Integer.parseInt(str); [EOL]             } [EOL]             num = (num * 10) + (c - '0'); [EOL]             if (offset < length) { [EOL]                 do { [EOL]                     c = str.charAt(offset++); [EOL]                     if (c > '9' || c < '0') { [EOL]                         return Integer.parseInt(str); [EOL]                     } [EOL]                     num = (num * 10) + (c - '0'); [EOL]                 } while (offset < length); [EOL]             } [EOL]         } [EOL]     } [EOL]     return negative ? -num : num; [EOL] } <line_num>: 64,115
public static long parseLong(char[] digitChars, int offset, int len) { [EOL]     int len1 = len - 9; [EOL]     long val = parseInt(digitChars, offset, len1) * L_BILLION; [EOL]     return val + (long) parseInt(digitChars, offset + len1, 9); [EOL] } <line_num>: 117,123
public static long parseLong(String str) { [EOL]     int length = str.length(); [EOL]     if (length <= 9) { [EOL]         return (long) parseInt(str); [EOL]     } [EOL]     return Long.parseLong(str); [EOL] } <line_num>: 125,136
public static boolean inLongRange(char[] digitChars, int offset, int len, boolean negative) { [EOL]     String cmpStr = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR; [EOL]     int cmpLen = cmpStr.length(); [EOL]     if (len < cmpLen) [EOL]         return true; [EOL]     if (len > cmpLen) [EOL]         return false; [EOL]     for (int i = 0; i < cmpLen; ++i) { [EOL]         int diff = digitChars[offset + i] - cmpStr.charAt(i); [EOL]         if (diff != 0) { [EOL]             return (diff < 0); [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 147,162
public static boolean inLongRange(String numberStr, boolean negative) { [EOL]     String cmpStr = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR; [EOL]     int cmpLen = cmpStr.length(); [EOL]     int actualLen = numberStr.length(); [EOL]     if (actualLen < cmpLen) [EOL]         return true; [EOL]     if (actualLen > cmpLen) [EOL]         return false; [EOL]     for (int i = 0; i < cmpLen; ++i) { [EOL]         int diff = numberStr.charAt(i) - cmpStr.charAt(i); [EOL]         if (diff != 0) { [EOL]             return (diff < 0); [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 171,187
public static int parseAsInt(String input, int defaultValue) { [EOL]     if (input == null) { [EOL]         return defaultValue; [EOL]     } [EOL]     input = input.trim(); [EOL]     int len = input.length(); [EOL]     if (len == 0) { [EOL]         return defaultValue; [EOL]     } [EOL]     int i = 0; [EOL]     if (i < len) { [EOL]         char c = input.charAt(0); [EOL]         if (c == '+') { [EOL]             input = input.substring(1); [EOL]             len = input.length(); [EOL]         } else if (c == '-') { [EOL]             ++i; [EOL]         } [EOL]     } [EOL]     for (; i < len; ++i) { [EOL]         char c = input.charAt(i); [EOL]         if (c > '9' || c < '0') { [EOL]             try { [EOL]                 return (int) parseDouble(input); [EOL]             } catch (NumberFormatException e) { [EOL]                 return defaultValue; [EOL]             } [EOL]         } [EOL]     } [EOL]     try { [EOL]         return Integer.parseInt(input); [EOL]     } catch (NumberFormatException e) { [EOL]     } [EOL]     return defaultValue; [EOL] } <line_num>: 189,225
public static long parseAsLong(String input, long defaultValue) { [EOL]     if (input == null) { [EOL]         return defaultValue; [EOL]     } [EOL]     input = input.trim(); [EOL]     int len = input.length(); [EOL]     if (len == 0) { [EOL]         return defaultValue; [EOL]     } [EOL]     int i = 0; [EOL]     if (i < len) { [EOL]         char c = input.charAt(0); [EOL]         if (c == '+') { [EOL]             input = input.substring(1); [EOL]             len = input.length(); [EOL]         } else if (c == '-') { [EOL]             ++i; [EOL]         } [EOL]     } [EOL]     for (; i < len; ++i) { [EOL]         char c = input.charAt(i); [EOL]         if (c > '9' || c < '0') { [EOL]             try { [EOL]                 return (long) parseDouble(input); [EOL]             } catch (NumberFormatException e) { [EOL]                 return defaultValue; [EOL]             } [EOL]         } [EOL]     } [EOL]     try { [EOL]         return Long.parseLong(input); [EOL]     } catch (NumberFormatException e) { [EOL]     } [EOL]     return defaultValue; [EOL] } <line_num>: 227,263
public static double parseAsDouble(String input, double defaultValue) { [EOL]     if (input == null) { [EOL]         return defaultValue; [EOL]     } [EOL]     input = input.trim(); [EOL]     int len = input.length(); [EOL]     if (len == 0) { [EOL]         return defaultValue; [EOL]     } [EOL]     try { [EOL]         return parseDouble(input); [EOL]     } catch (NumberFormatException e) { [EOL]     } [EOL]     return defaultValue; [EOL] } <line_num>: 265,279
public static double parseDouble(String numStr) throws NumberFormatException { [EOL]     if (NASTY_SMALL_DOUBLE.equals(numStr)) { [EOL]         return Double.MIN_VALUE; [EOL]     } [EOL]     return Double.parseDouble(numStr); [EOL] } <line_num>: 281,291
public static BigDecimal parseBigDecimal(String numStr) throws NumberFormatException { [EOL]     try { [EOL]         return new BigDecimal(numStr); [EOL]     } catch (NumberFormatException e) { [EOL]         throw _badBigDecimal(numStr); [EOL]     } [EOL] } <line_num>: 293,300
public static BigDecimal parseBigDecimal(char[] buffer) throws NumberFormatException { [EOL]     return parseBigDecimal(buffer, 0, buffer.length); [EOL] } <line_num>: 302,304
public static BigDecimal parseBigDecimal(char[] buffer, int offset, int len) throws NumberFormatException { [EOL]     try { [EOL]         return new BigDecimal(buffer, offset, len); [EOL]     } catch (NumberFormatException e) { [EOL]         throw _badBigDecimal(new String(buffer, offset, len)); [EOL]     } [EOL] } <line_num>: 306,314
private static NumberFormatException _badBigDecimal(String str) { [EOL]     return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal"); [EOL] } <line_num>: 316,318
