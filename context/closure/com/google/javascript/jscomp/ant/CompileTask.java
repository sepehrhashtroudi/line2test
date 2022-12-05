public CompileTask()
public void setLanguageIn(String value)
public void setWarning(String value)
public void setDebug(boolean value)
public void setCompilationLevel(String value)
public void setManageDependencies(boolean value)
public void setCustomExternsOnly(boolean value)
public void setOutput(File value)
public void setReplacePropertiesPrefix(String value)
public void setReplaceProperties(boolean value)
public void setEncoding(String encoding)
public void setOutputEncoding(String outputEncoding)
public void setPrettyPrint(boolean pretty)
public void setPrintInputDelimiter(boolean print)
public void setForceRecompile(boolean forceRecompile)
public void setGenerateExports(boolean generateExports)
public void addExterns(FileList list)
public void addWarning(Warning warning)
public void addSources(FileList list)
public void addPath(Path list)
public void execute()
private CompilerOptions createCompilerOptions()
public Parameter createDefine()
private void convertDefineParameters(CompilerOptions options)
private void convertPropertiesMap(CompilerOptions options)
private boolean setDefine(CompilerOptions options, String key, Object value)
private Compiler createCompiler(CompilerOptions options)
private List<SourceFile> findExternFiles()
private List<SourceFile> findSourceFiles()
private List<SourceFile> findJavaScriptFiles(FileList fileList)
private List<SourceFile> findJavaScriptFiles(Path path)
private List<SourceFile> getDefaultExterns()
private void writeResult(String source)
private boolean isStale()
private long getLastModifiedTime(List<?> fileLists)
private long getLastModifiedTime(File file)
CompilerOptions.LanguageMode languageIn
WarningLevel warningLevel
boolean debugOptions
String encoding=Optional["UTF-8"]
String outputEncoding=Optional["UTF-8"]
CompilationLevel compilationLevel
boolean customExternsOnly
boolean manageDependencies
boolean prettyPrint
boolean printInputDelimiter
boolean generateExports
boolean replaceProperties
boolean forceRecompile
String replacePropertiesPrefix
File outputFile
List<Parameter> defineParams
List<FileList> externFileLists
List<FileList> sourceFileLists
List<Path> sourcePaths
List<Warning> warnings
