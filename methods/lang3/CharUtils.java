@Deprecated [EOL] public static Character toCharacterObject(final char ch) { [EOL]     return Character.valueOf(ch); [EOL] } <line_num>: 87
public static Character toCharacterObject(final String str) { [EOL]     if (StringUtils.isEmpty(str)) { [EOL]         return null; [EOL]     } [EOL]     return Character.valueOf(str.charAt(0)); [EOL] } <line_num>: 108
public static char toChar(final Character ch) { [EOL]     if (ch == null) { [EOL]         throw new IllegalArgumentException("The Character must not be null"); [EOL]     } [EOL]     return ch.charValue(); [EOL] } <line_num>: 129
public static char toChar(final Character ch, final char defaultValue) { [EOL]     if (ch == null) { [EOL]         return defaultValue; [EOL]     } [EOL]     return ch.charValue(); [EOL] } <line_num>: 149
public static char toChar(final String str) { [EOL]     if (StringUtils.isEmpty(str)) { [EOL]         throw new IllegalArgumentException("The String must not be empty"); [EOL]     } [EOL]     return str.charAt(0); [EOL] } <line_num>: 172
public static char toChar(final String str, final char defaultValue) { [EOL]     if (StringUtils.isEmpty(str)) { [EOL]         return defaultValue; [EOL]     } [EOL]     return str.charAt(0); [EOL] } <line_num>: 194
public static int toIntValue(final char ch) { [EOL]     if (isAsciiNumeric(ch) == false) { [EOL]         throw new IllegalArgumentException("The character " + ch + " is not in the range '0' - '9'"); [EOL]     } [EOL]     return ch - 48; [EOL] } <line_num>: 217
public static int toIntValue(final char ch, final int defaultValue) { [EOL]     if (isAsciiNumeric(ch) == false) { [EOL]         return defaultValue; [EOL]     } [EOL]     return ch - 48; [EOL] } <line_num>: 239
public static int toIntValue(final Character ch) { [EOL]     if (ch == null) { [EOL]         throw new IllegalArgumentException("The character must not be null"); [EOL]     } [EOL]     return toIntValue(ch.charValue()); [EOL] } <line_num>: 262
public static int toIntValue(final Character ch, final int defaultValue) { [EOL]     if (ch == null) { [EOL]         return defaultValue; [EOL]     } [EOL]     return toIntValue(ch.charValue(), defaultValue); [EOL] } <line_num>: 285
public static String toString(final char ch) { [EOL]     if (ch < 128) { [EOL]         return CHAR_STRING_ARRAY[ch]; [EOL]     } [EOL]     return new String(new char[] { ch }); [EOL] } <line_num>: 307
public static String toString(final Character ch) { [EOL]     if (ch == null) { [EOL]         return null; [EOL]     } [EOL]     return toString(ch.charValue()); [EOL] } <line_num>: 331
public static String unicodeEscaped(final char ch) { [EOL]     if (ch < 0x10) { [EOL]         return "\\u000" + Integer.toHexString(ch); [EOL]     } else if (ch < 0x100) { [EOL]         return "\\u00" + Integer.toHexString(ch); [EOL]     } else if (ch < 0x1000) { [EOL]         return "\\u0" + Integer.toHexString(ch); [EOL]     } [EOL]     return "\\u" + Integer.toHexString(ch); [EOL] } <line_num>: 352
public static String unicodeEscaped(final Character ch) { [EOL]     if (ch == null) { [EOL]         return null; [EOL]     } [EOL]     return unicodeEscaped(ch.charValue()); [EOL] } <line_num>: 379
public static boolean isAscii(final char ch) { [EOL]     return ch < 128; [EOL] } <line_num>: 402
public static boolean isAsciiPrintable(final char ch) { [EOL]     return ch >= 32 && ch < 127; [EOL] } <line_num>: 421
public static boolean isAsciiControl(final char ch) { [EOL]     return ch < 32 || ch == 127; [EOL] } <line_num>: 440
public static boolean isAsciiAlpha(final char ch) { [EOL]     return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'); [EOL] } <line_num>: 459
public static boolean isAsciiAlphaUpper(final char ch) { [EOL]     return ch >= 'A' && ch <= 'Z'; [EOL] } <line_num>: 478
public static boolean isAsciiAlphaLower(final char ch) { [EOL]     return ch >= 'a' && ch <= 'z'; [EOL] } <line_num>: 497
public static boolean isAsciiNumeric(final char ch) { [EOL]     return ch >= '0' && ch <= '9'; [EOL] } <line_num>: 516
public static boolean isAsciiAlphanumeric(final char ch) { [EOL]     return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'); [EOL] } <line_num>: 535
