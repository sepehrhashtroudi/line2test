@Override [EOL] public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { [EOL]     return formatter.format(obj, toAppendTo, pos); [EOL] } <line_num>: 67
@Override [EOL] public Object parseObject(final String source, final ParsePosition pos) { [EOL]     return parser.parseObject(source, pos); [EOL] } <line_num>: 83
public Format getParser() { [EOL]     return this.parser; [EOL] } <line_num>: 92
public Format getFormatter() { [EOL]     return this.formatter; [EOL] } <line_num>: 101
public String reformat(final String input) throws ParseException { [EOL]     return format(parseObject(input)); [EOL] } <line_num>: 112
