public static JavaUnicodeEscaper above(final int codepoint) { [EOL]     return outsideOf(0, codepoint); [EOL] } <line_num>: 36
public static JavaUnicodeEscaper below(final int codepoint) { [EOL]     return outsideOf(codepoint, Integer.MAX_VALUE); [EOL] } <line_num>: 49
public static JavaUnicodeEscaper between(final int codepointLow, final int codepointHigh) { [EOL]     return new JavaUnicodeEscaper(codepointLow, codepointHigh, true); [EOL] } <line_num>: 64
public static JavaUnicodeEscaper outsideOf(final int codepointLow, final int codepointHigh) { [EOL]     return new JavaUnicodeEscaper(codepointLow, codepointHigh, false); [EOL] } <line_num>: 79
@Override [EOL] protected String toUtf16Escape(final int codepoint) { [EOL]     final char[] surrogatePair = Character.toChars(codepoint); [EOL]     return "\\u" + hex(surrogatePair[0]) + "\\u" + hex(surrogatePair[1]); [EOL] } <line_num>: 109
