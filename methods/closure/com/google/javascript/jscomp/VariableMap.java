VariableMap(Map<String, String> map) { [EOL]     this.map = ImmutableMap.copyOf(map); [EOL] } <line_num>: 44,46
public String lookupNewName(String sourceName) { [EOL]     return map.get(sourceName); [EOL] } <line_num>: 52,54
public String lookupSourceName(String newName) { [EOL]     initReverseMap(); [EOL]     return reverseMap.get(newName); [EOL] } <line_num>: 60,63
private synchronized void initReverseMap() { [EOL]     if (reverseMap == null) { [EOL]         ImmutableMap.Builder<String, String> rm = ImmutableMap.builder(); [EOL]         for (Map.Entry<String, String> entry : map.entrySet()) { [EOL]             rm.put(entry.getValue(), entry.getKey()); [EOL]         } [EOL]         reverseMap = rm.build(); [EOL]     } [EOL] } <line_num>: 68,76
public Map<String, String> getOriginalNameToNewNameMap() { [EOL]     return map; [EOL] } <line_num>: 81,83
public Map<String, String> getNewNameToOriginalNameMap() { [EOL]     initReverseMap(); [EOL]     return reverseMap; [EOL] } <line_num>: 88,91
public void save(String filename) throws IOException { [EOL]     Files.write(toBytes(), new File(filename)); [EOL] } <line_num>: 96,98
public static VariableMap load(String filename) throws IOException { [EOL]     try { [EOL]         return fromBytes(Files.toByteArray(new File(filename))); [EOL]     } catch (ParseException e) { [EOL]         throw new IOException(e); [EOL]     } [EOL] } <line_num>: 103,110
public byte[] toBytes() { [EOL]     ByteArrayOutputStream baos = new ByteArrayOutputStream(); [EOL]     Writer writer = new OutputStreamWriter(baos, Charsets.UTF_8); [EOL]     try { [EOL]         for (Map.Entry<String, String> entry : map.entrySet()) { [EOL]             writer.write(escape(entry.getKey())); [EOL]             writer.write(SEPARATOR); [EOL]             writer.write(escape(entry.getValue())); [EOL]             writer.write('\n'); [EOL]         } [EOL]         writer.close(); [EOL]     } catch (IOException e) { [EOL]         throw new RuntimeException(e); [EOL]     } [EOL]     return baos.toByteArray(); [EOL] } <line_num>: 115,132
public static VariableMap fromBytes(byte[] bytes) throws ParseException { [EOL]     Iterable<String> lines; [EOL]     try { [EOL]         lines = CharStreams.readLines(CharStreams.newReaderSupplier(ByteStreams.newInputStreamSupplier(bytes), Charsets.UTF_8)); [EOL]     } catch (IOException e) { [EOL]         throw new RuntimeException(e); [EOL]     } [EOL]     ImmutableMap.Builder<String, String> map = ImmutableMap.builder(); [EOL]     for (String line : lines) { [EOL]         int pos = findIndexOfChar(line, SEPARATOR); [EOL]         if (pos <= 0 || pos == line.length() - 1) { [EOL]             throw new ParseException("Bad line: " + line, 0); [EOL]         } [EOL]         map.put(unescape(line.substring(0, pos)), unescape(line.substring(pos + 1))); [EOL]     } [EOL]     return new VariableMap(map.build()); [EOL] } <line_num>: 138,161
private static String escape(String value) { [EOL]     return value.replace("\\", "\\\\").replace(":", "\\:").replace("\n", "\\n"); [EOL] } <line_num>: 163,167
private static int findIndexOfChar(String value, char stopChar) { [EOL]     int len = value.length(); [EOL]     for (int i = 0; i < len; i++) { [EOL]         char c = value.charAt(i); [EOL]         if (c == '\\' && ++i < len) { [EOL]             c = value.charAt(i); [EOL]         } else if (c == stopChar) { [EOL]             return i; [EOL]         } [EOL]     } [EOL]     return -1; [EOL] } <line_num>: 169,180
private static String unescape(CharSequence value) { [EOL]     StringBuilder sb = new StringBuilder(); [EOL]     int len = value.length(); [EOL]     for (int i = 0; i < len; i++) { [EOL]         char c = value.charAt(i); [EOL]         if (c == '\\' && ++i < len) { [EOL]             c = value.charAt(i); [EOL]         } [EOL]         sb.append(c); [EOL]     } [EOL]     return sb.toString(); [EOL] } <line_num>: 182,193
public static VariableMap fromMap(Map<String, String> map) { [EOL]     return new VariableMap(map); [EOL] } <line_num>: 201,203
@VisibleForTesting [EOL] Map<String, String> toMap() { [EOL]     return map; [EOL] } <line_num>: 205,208