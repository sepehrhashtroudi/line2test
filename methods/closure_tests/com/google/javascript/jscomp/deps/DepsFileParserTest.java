@Override [EOL] public void setUp() { [EOL]     errorManager = new PrintStreamErrorManager(System.err); [EOL]     parser = new DepsFileParser(errorManager); [EOL]     parser.setShortcutMode(true); [EOL] } <line_num>: 42,47
public void testGoodParse() { [EOL]     final String CONTENTS = "/*" + "goog.addDependency('no1', [], []);*//*\n" + "goog.addDependency('no2', [ ], [ ]);\n" + "*/goog.addDependency('yes1', [], []);\n" + "/* blah */goog.addDependency(\"yes2\", [], [])/* blah*/\n" + "goog.addDependency('yes3', ['a','b'], ['c']); // goog.addDependency('no3', [], []);\n" + "// goog.addDependency('no4', [], []);\n" + "goog.addDependency(\"yes4\", [], [ \"a\",'b' , 'c' ]); //no new line at EOF"; [EOL]     List<DependencyInfo> result = parser.parseFile(SRC_PATH, CONTENTS); [EOL]     ImmutableList<DependencyInfo> EXPECTED = ImmutableList.<DependencyInfo>of(new SimpleDependencyInfo("yes1", SRC_PATH, EMPTY, EMPTY), new SimpleDependencyInfo("yes2", SRC_PATH, EMPTY, EMPTY), new SimpleDependencyInfo("yes3", SRC_PATH, ImmutableList.of("a", "b"), ImmutableList.of("c")), new SimpleDependencyInfo("yes4", SRC_PATH, EMPTY, ImmutableList.of("a", "b", "c"))); [EOL]     assertEquals(EXPECTED, result); [EOL]     assertEquals(0, errorManager.getErrorCount()); [EOL]     assertEquals(0, errorManager.getWarningCount()); [EOL] } <line_num>: 57,80
public void testTooFewArgs() { [EOL]     parser.parseFile(SRC_PATH, "goog.addDependency('a', []);"); [EOL]     assertEquals(1, errorManager.getErrorCount()); [EOL]     assertEquals(0, errorManager.getWarningCount()); [EOL] } <line_num>: 82,86
public void testTooManyArgs() { [EOL]     parser.parseFile(SRC_PATH, "goog.addDependency('a', [], [], []);"); [EOL]     assertEquals(1, errorManager.getErrorCount()); [EOL]     assertEquals(0, errorManager.getWarningCount()); [EOL] } <line_num>: 88,92
public void testShortcutMode() { [EOL]     List<DependencyInfo> result = parser.parseFile(SRC_PATH, "goog.addDependency('yes1', [], []); \n" + "foo();\n" + "goog.addDependency('no1', [], []);"); [EOL]     ImmutableList<DependencyInfo> EXPECTED = ImmutableList.<DependencyInfo>of(new SimpleDependencyInfo("yes1", SRC_PATH, EMPTY, EMPTY)); [EOL]     assertEquals(EXPECTED, result); [EOL] } <line_num>: 94,102
public void testNoShortcutMode() { [EOL]     parser.setShortcutMode(false); [EOL]     List<DependencyInfo> result = parser.parseFile(SRC_PATH, "goog.addDependency('yes1', [], []); \n" + "foo();\n" + "goog.addDependency('yes2', [], []);"); [EOL]     ImmutableList<DependencyInfo> EXPECTED = ImmutableList.<DependencyInfo>of(new SimpleDependencyInfo("yes1", SRC_PATH, EMPTY, EMPTY), new SimpleDependencyInfo("yes2", SRC_PATH, EMPTY, EMPTY)); [EOL]     assertEquals(EXPECTED, result); [EOL] } <line_num>: 104,114