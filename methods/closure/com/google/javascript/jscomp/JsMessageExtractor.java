public JsMessageExtractor(JsMessage.IdGenerator idGenerator, JsMessage.Style style) { [EOL]     this(idGenerator, style, new CompilerOptions()); [EOL] } <line_num>: 55,59
public JsMessageExtractor(JsMessage.IdGenerator idGenerator, JsMessage.Style style, CompilerOptions options) { [EOL]     this.idGenerator = idGenerator; [EOL]     this.style = style; [EOL]     this.options = options; [EOL] } <line_num>: 61,68
private ExtractMessagesVisitor(AbstractCompiler compiler) { [EOL]     super(compiler, true, style, idGenerator); [EOL] } <line_num>: 81,83
@Override [EOL] void processJsMessage(JsMessage message, JsMessageDefinition definition) { [EOL]     if (!message.isExternal()) { [EOL]         messages.add(message); [EOL]     } [EOL] } <line_num>: 85,91
public Collection<JsMessage> getMessages() { [EOL]     return messages; [EOL] } <line_num>: 98,100
public Collection<JsMessage> extractMessages(SourceFile... inputs) throws IOException { [EOL]     return extractMessages(ImmutableList.copyOf(inputs)); [EOL] } <line_num>: 106,109
public <T extends SourceFile> Collection<JsMessage> extractMessages(Iterable<T> inputs) throws IOException { [EOL]     Compiler compiler = new Compiler(); [EOL]     compiler.init(ImmutableList.<SourceFile>of(), Lists.newArrayList(inputs), options); [EOL]     compiler.parseInputs(); [EOL]     ExtractMessagesVisitor extractCompilerPass = new ExtractMessagesVisitor(compiler); [EOL]     if (compiler.getErrors().length == 0) { [EOL]         extractCompilerPass.process(null, compiler.getRoot()); [EOL]     } [EOL]     JSError[] errors = compiler.getErrors(); [EOL]     if (errors.length > 0) { [EOL]         StringBuilder msg = new StringBuilder("JSCompiler errors\n"); [EOL]         MessageFormatter formatter = new LightweightMessageFormatter(compiler); [EOL]         for (JSError e : errors) { [EOL]             msg.append(formatter.formatError(e)); [EOL]         } [EOL]         throw new RuntimeException(msg.toString()); [EOL]     } [EOL]     return extractCompilerPass.getMessages(); [EOL] } <line_num>: 121,149