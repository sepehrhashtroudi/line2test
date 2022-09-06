@Override [EOL] public int translate(final CharSequence input, final int index, final Writer out) throws IOException { [EOL]     if (input.charAt(index) == '\\' && index < (input.length() - 1) && Character.isDigit(input.charAt(index + 1))) { [EOL]         final int start = index + 1; [EOL]         int end = index + 2; [EOL]         while (end < input.length() && Character.isDigit(input.charAt(end))) { [EOL]             end++; [EOL]             if (Integer.parseInt(input.subSequence(start, end).toString(), 10) > OCTAL_MAX) { [EOL]                 end--; [EOL]                 break; [EOL]             } [EOL]         } [EOL]         out.write(Integer.parseInt(input.subSequence(start, end).toString(), 8)); [EOL]         return 1 + end - start; [EOL]     } [EOL]     return 0; [EOL] } <line_num>: 41,59
