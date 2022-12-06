static void validateOption(String opt) throws IllegalArgumentException { [EOL]     if (opt == null) { [EOL]         return; [EOL]     } else if (opt.length() == 1) { [EOL]         char ch = opt.charAt(0); [EOL]         if (!isValidOpt(ch)) { [EOL]             throw new IllegalArgumentException("illegal option value '" + ch + "'"); [EOL]         } [EOL]     } else { [EOL]         char[] chars = opt.toCharArray(); [EOL]         for (int i = 0; i < chars.length; i++) { [EOL]             if (!isValidChar(chars[i])) { [EOL]                 throw new IllegalArgumentException("opt contains illegal character value '" + chars[i] + "'"); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 40,76
private static boolean isValidOpt(char c) { [EOL]     return (isValidChar(c) || (c == ' ') || (c == '?') || c == '@'); [EOL] } <line_num>: 85,88
private static boolean isValidChar(char c) { [EOL]     return Character.isJavaIdentifierPart(c); [EOL] } <line_num>: 96,99