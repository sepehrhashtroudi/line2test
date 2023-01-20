public void testInvalidInstantiation() throws Exception { [EOL]     try { [EOL]         new CamelCaseSeparatorNamingPolicy(null); [EOL]         fail("Null separator string is not supported"); [EOL]     } catch (IllegalArgumentException expected) { [EOL]     } [EOL]     try { [EOL]         new CamelCaseSeparatorNamingPolicy(""); [EOL]         fail("Empty separator string is not supported"); [EOL]     } catch (IllegalArgumentException expected) { [EOL]     } [EOL] } <line_num>: 32,42
public void testUnderscoreSeparator() throws Exception { [EOL]     CamelCaseSeparatorNamingPolicy namingPolicy = new CamelCaseSeparatorNamingPolicy(UNDERSCORE); [EOL]     String translatedName = namingPolicy.translateName("testUnderscoreBetweenWords", CLASS, null); [EOL]     assertEquals("test_Underscore_Between_Words", translatedName); [EOL] } <line_num>: 44,49
public void testMultiCharSeparator() throws Exception { [EOL]     CamelCaseSeparatorNamingPolicy namingPolicy = new CamelCaseSeparatorNamingPolicy(MULTI_CHAR_SEPARATOR); [EOL]     String translatedName = namingPolicy.translateName("testMultCharBetweenWords", CLASS, null); [EOL]     assertEquals("test_$_Mult_$_Char_$_Between_$_Words", translatedName); [EOL] } <line_num>: 51,56
public void testNameBeginsWithCapital() throws Exception { [EOL]     CamelCaseSeparatorNamingPolicy namingPolicy = new CamelCaseSeparatorNamingPolicy(UNDERSCORE); [EOL]     String translatedName = namingPolicy.translateName("TestNameBeginsWithCapital", CLASS, null); [EOL]     assertEquals("Test_Name_Begins_With_Capital", translatedName); [EOL] } <line_num>: 58,62
public void testExceptionPossiblyIncorrectSeparation() throws Exception { [EOL]     CamelCaseSeparatorNamingPolicy namingPolicy = new CamelCaseSeparatorNamingPolicy(UNDERSCORE); [EOL]     String translatedName = namingPolicy.translateName("aURL", CLASS, null); [EOL]     assertEquals("a_U_R_L", translatedName); [EOL] } <line_num>: 64,68