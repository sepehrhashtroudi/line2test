@Override [EOL] public int translate(final CharSequence input, final int index, final Writer out) throws IOException { [EOL]     int max = longest; [EOL]     if (index + longest > input.length()) { [EOL]         max = input.length() - index; [EOL]     } [EOL]     for (int i = max; i >= shortest; i--) { [EOL]         final CharSequence subSeq = input.subSequence(index, index + i); [EOL]         final CharSequence result = lookupMap.get(subSeq.toString()); [EOL]         if (result != null) { [EOL]             out.write(result.toString()); [EOL]             return i; [EOL]         } [EOL]     } [EOL]     return 0; [EOL] } <line_num>: 69
