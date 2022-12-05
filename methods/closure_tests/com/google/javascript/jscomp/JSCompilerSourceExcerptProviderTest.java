@Override [EOL] protected void setUp() throws Exception { [EOL]     SourceFile foo = SourceFile.fromCode("foo", "foo:first line\nfoo:second line\nfoo:third line\n"); [EOL]     SourceFile bar = SourceFile.fromCode("bar", "bar:first line\nbar:second line\nbar:third line\nbar:fourth line\n"); [EOL]     SourceFile foo2 = SourceFile.fromCode("foo2", "foo2:first line\nfoo2:second line\nfoo2:third line"); [EOL]     Compiler compiler = new Compiler(); [EOL]     CompilerOptions options = new CompilerOptions(); [EOL]     compiler.init(ImmutableList.<SourceFile>of(), ImmutableList.of(foo, bar, foo2), options); [EOL]     this.provider = compiler; [EOL] } <line_num>: 28,43
public void testExcerptOneLine() throws Exception { [EOL]     assertEquals("foo:first line", provider.getSourceLine("foo", 1)); [EOL]     assertEquals("foo:second line", provider.getSourceLine("foo", 2)); [EOL]     assertEquals("foo:third line", provider.getSourceLine("foo", 3)); [EOL]     assertEquals("bar:first line", provider.getSourceLine("bar", 1)); [EOL]     assertEquals("bar:second line", provider.getSourceLine("bar", 2)); [EOL]     assertEquals("bar:third line", provider.getSourceLine("bar", 3)); [EOL]     assertEquals("bar:fourth line", provider.getSourceLine("bar", 4)); [EOL] } <line_num>: 45,53
public void testExcerptLineFromInexistantSource() throws Exception { [EOL]     assertEquals(null, provider.getSourceLine("inexistant", 1)); [EOL]     assertEquals(null, provider.getSourceLine("inexistant", 7)); [EOL]     assertEquals(null, provider.getSourceLine("inexistant", 90)); [EOL] } <line_num>: 55,59
public void testExcerptInexistantLine() throws Exception { [EOL]     assertEquals(null, provider.getSourceLine("foo", 0)); [EOL]     assertEquals(null, provider.getSourceLine("foo", 4)); [EOL]     assertEquals(null, provider.getSourceLine("bar", 0)); [EOL]     assertEquals(null, provider.getSourceLine("bar", 5)); [EOL] } <line_num>: 61,66
public void testExceptNoNewLine() throws Exception { [EOL]     assertEquals("foo2:first line", provider.getSourceLine("foo2", 1)); [EOL]     assertEquals("foo2:second line", provider.getSourceLine("foo2", 2)); [EOL]     assertEquals("foo2:third line", provider.getSourceLine("foo2", 3)); [EOL]     assertEquals(null, provider.getSourceLine("foo2", 4)); [EOL] } <line_num>: 68,73
public void testExcerptRegion() throws Exception { [EOL]     assertRegionWellFormed("foo", 1); [EOL]     assertRegionWellFormed("foo", 2); [EOL]     assertRegionWellFormed("foo", 3); [EOL]     assertRegionWellFormed("bar", 1); [EOL]     assertRegionWellFormed("bar", 2); [EOL]     assertRegionWellFormed("bar", 3); [EOL]     assertRegionWellFormed("bar", 4); [EOL] } <line_num>: 75,83
public void testExcerptRegionFromInexistantSource() throws Exception { [EOL]     assertEquals(null, provider.getSourceRegion("inexistant", 0)); [EOL]     assertEquals(null, provider.getSourceRegion("inexistant", 6)); [EOL]     assertEquals(null, provider.getSourceRegion("inexistant", 90)); [EOL] } <line_num>: 85,89
public void testExcerptInexistantRegion() throws Exception { [EOL]     assertEquals(null, provider.getSourceRegion("foo", 0)); [EOL]     assertEquals(null, provider.getSourceRegion("foo", 4)); [EOL]     assertEquals(null, provider.getSourceRegion("bar", 0)); [EOL]     assertEquals(null, provider.getSourceRegion("bar", 5)); [EOL] } <line_num>: 91,96
private void assertRegionWellFormed(String sourceName, int lineNumber) { [EOL]     Region region = provider.getSourceRegion(sourceName, lineNumber); [EOL]     assertNotNull(region); [EOL]     String sourceRegion = region.getSourceExcerpt(); [EOL]     assertNotNull(sourceRegion); [EOL]     if (lineNumber == 1) { [EOL]         assertEquals(1, region.getBeginningLineNumber()); [EOL]     } else { [EOL]         assertTrue(region.getBeginningLineNumber() <= lineNumber); [EOL]     } [EOL]     assertTrue(lineNumber <= region.getEndingLineNumber()); [EOL]     assertNotSame(sourceRegion, 0, sourceRegion.length()); [EOL]     assertNotSame(sourceRegion, '\n', sourceRegion.charAt(0)); [EOL]     assertNotSame(sourceRegion, '\n', sourceRegion.charAt(sourceRegion.length() - 1)); [EOL]     String line = provider.getSourceLine(sourceName, lineNumber); [EOL]     assertTrue(sourceRegion, sourceRegion.contains(line)); [EOL] } <line_num>: 103,120
