private static void reset() { [EOL]     description = null; [EOL]     argName = "arg"; [EOL]     longopt = null; [EOL]     type = null; [EOL]     required = false; [EOL]     numberOfArgs = Option.UNINITIALIZED; [EOL]     optionalArg = false; [EOL]     valuesep = (char) 0; [EOL] } <line_num>: 68
public static OptionBuilder withLongOpt(String newLongopt) { [EOL]     OptionBuilder.longopt = newLongopt; [EOL]     return instance; [EOL] } <line_num>: 89
public static OptionBuilder hasArg() { [EOL]     OptionBuilder.numberOfArgs = 1; [EOL]     return instance; [EOL] } <line_num>: 101
public static OptionBuilder hasArg(boolean hasArg) { [EOL]     OptionBuilder.numberOfArgs = (hasArg == true) ? 1 : Option.UNINITIALIZED; [EOL]     return instance; [EOL] } <line_num>: 115
public static OptionBuilder withArgName(String name) { [EOL]     OptionBuilder.argName = name; [EOL]     return instance; [EOL] } <line_num>: 129
public static OptionBuilder isRequired() { [EOL]     OptionBuilder.required = true; [EOL]     return instance; [EOL] } <line_num>: 141
public static OptionBuilder withValueSeparator(char sep) { [EOL]     OptionBuilder.valuesep = sep; [EOL]     return instance; [EOL] } <line_num>: 166
public static OptionBuilder withValueSeparator() { [EOL]     OptionBuilder.valuesep = '='; [EOL]     return instance; [EOL] } <line_num>: 189
public static OptionBuilder isRequired(boolean newRequired) { [EOL]     OptionBuilder.required = newRequired; [EOL]     return instance; [EOL] } <line_num>: 203
public static OptionBuilder hasArgs() { [EOL]     OptionBuilder.numberOfArgs = Option.UNLIMITED_VALUES; [EOL]     return instance; [EOL] } <line_num>: 215
public static OptionBuilder hasArgs(int num) { [EOL]     OptionBuilder.numberOfArgs = num; [EOL]     return instance; [EOL] } <line_num>: 229
public static OptionBuilder hasOptionalArg() { [EOL]     OptionBuilder.numberOfArgs = 1; [EOL]     OptionBuilder.optionalArg = true; [EOL]     return instance; [EOL] } <line_num>: 241
public static OptionBuilder hasOptionalArgs() { [EOL]     OptionBuilder.numberOfArgs = Option.UNLIMITED_VALUES; [EOL]     OptionBuilder.optionalArg = true; [EOL]     return instance; [EOL] } <line_num>: 255
public static OptionBuilder hasOptionalArgs(int numArgs) { [EOL]     OptionBuilder.numberOfArgs = numArgs; [EOL]     OptionBuilder.optionalArg = true; [EOL]     return instance; [EOL] } <line_num>: 271
public static OptionBuilder withType(Object newType) { [EOL]     OptionBuilder.type = newType; [EOL]     return instance; [EOL] } <line_num>: 286
public static OptionBuilder withDescription(String newDescription) { [EOL]     OptionBuilder.description = newDescription; [EOL]     return instance; [EOL] } <line_num>: 299
public static Option create(char opt) throws IllegalArgumentException { [EOL]     return create(String.valueOf(opt)); [EOL] } <line_num>: 315
public static Option create() throws IllegalArgumentException { [EOL]     if (longopt == null) { [EOL]         throw new IllegalArgumentException("must specify longopt"); [EOL]     } [EOL]     return create(null); [EOL] } <line_num>: 328
public static Option create(String opt) throws IllegalArgumentException { [EOL]     Option option = new Option(opt, description); [EOL]     option.setLongOpt(longopt); [EOL]     option.setRequired(required); [EOL]     option.setOptionalArg(optionalArg); [EOL]     option.setArgs(numberOfArgs); [EOL]     option.setType(type); [EOL]     option.setValueSeparator(valuesep); [EOL]     option.setArgName(argName); [EOL]     OptionBuilder.reset(); [EOL]     return option; [EOL] } <line_num>: 349
private OptionBuilder() { [EOL] } <line_num>: 60
