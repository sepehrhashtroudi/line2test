private ParserRunner() { [EOL] } <line_num>: 48,48
public ParseResult(Node ast, AstRoot oldAst) { [EOL]     this.ast = ast; [EOL]     this.oldAst = oldAst; [EOL] } <line_num>: 163,166
@Deprecated [EOL] public static Config createConfig(boolean isIdeMode) { [EOL]     return createConfig(isIdeMode, LanguageMode.ECMASCRIPT3, false); [EOL] } <line_num>: 50,53
public static Config createConfig(boolean isIdeMode, LanguageMode languageMode, boolean acceptConstKeyword) { [EOL]     return createConfig(isIdeMode, languageMode, acceptConstKeyword, null); [EOL] } <line_num>: 55,59
public static Config createConfig(boolean isIdeMode, LanguageMode languageMode, boolean acceptConstKeyword, Set<String> extraAnnotationNames) { [EOL]     initResourceConfig(); [EOL]     Set<String> effectiveAnnotationNames; [EOL]     if (extraAnnotationNames == null) { [EOL]         effectiveAnnotationNames = annotationNames; [EOL]     } else { [EOL]         effectiveAnnotationNames = new HashSet<String>(annotationNames); [EOL]         effectiveAnnotationNames.addAll(extraAnnotationNames); [EOL]     } [EOL]     return new Config(effectiveAnnotationNames, suppressionNames, isIdeMode, languageMode, acceptConstKeyword); [EOL] } <line_num>: 61,75
public static Set<String> getReservedVars() { [EOL]     initResourceConfig(); [EOL]     return reservedVars; [EOL] } <line_num>: 77,80
private static synchronized void initResourceConfig() { [EOL]     if (annotationNames != null) { [EOL]         return; [EOL]     } [EOL]     ResourceBundle config = ResourceBundle.getBundle(configResource); [EOL]     annotationNames = extractList(config.getString("jsdoc.annotations")); [EOL]     suppressionNames = extractList(config.getString("jsdoc.suppressions")); [EOL]     reservedVars = extractList(config.getString("compiler.reserved.vars")); [EOL] } <line_num>: 82,91
private static Set<String> extractList(String configProp) { [EOL]     String[] names = configProp.split(","); [EOL]     Set<String> trimmedNames = Sets.newHashSet(); [EOL]     for (String name : names) { [EOL]         trimmedNames.add(name.trim()); [EOL]     } [EOL]     return ImmutableSet.copyOf(trimmedNames); [EOL] } <line_num>: 93,100
public static ParseResult parse(StaticSourceFile sourceFile, String sourceString, Config config, ErrorReporter errorReporter, Logger logger) throws IOException { [EOL]     Context cx = Context.enter(); [EOL]     cx.setErrorReporter(errorReporter); [EOL]     cx.setLanguageVersion(Context.VERSION_1_5); [EOL]     CompilerEnvirons compilerEnv = new CompilerEnvirons(); [EOL]     compilerEnv.initFromContext(cx); [EOL]     compilerEnv.setRecordingComments(true); [EOL]     compilerEnv.setRecordingLocalJsDocComments(true); [EOL]     compilerEnv.setWarnTrailingComma(config.languageMode == LanguageMode.ECMASCRIPT3); [EOL]     boolean acceptEs5 = config.isIdeMode || config.languageMode != LanguageMode.ECMASCRIPT3; [EOL]     compilerEnv.setReservedKeywordAsIdentifier(acceptEs5); [EOL]     compilerEnv.setAllowMemberExprAsFunctionName(false); [EOL]     compilerEnv.setIdeMode(config.isIdeMode); [EOL]     compilerEnv.setRecoverFromErrors(config.isIdeMode); [EOL]     Parser p = new Parser(compilerEnv, errorReporter); [EOL]     AstRoot astRoot = null; [EOL]     try { [EOL]         astRoot = p.parse(sourceString, sourceFile.getName(), 1); [EOL]     } catch (EvaluatorException e) { [EOL]         logger.info("Error parsing " + sourceFile.getName() + ": " + e.getMessage()); [EOL]     } finally { [EOL]         Context.exit(); [EOL]     } [EOL]     Node root = null; [EOL]     if (astRoot != null) { [EOL]         root = IRFactory.transformTree(astRoot, sourceFile, sourceString, config, errorReporter); [EOL]         root.setIsSyntheticBlock(true); [EOL]     } [EOL]     return new ParseResult(root, astRoot); [EOL] } <line_num>: 111,154