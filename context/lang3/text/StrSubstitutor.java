StrSubstitutor
public static String replace(final Object source, final Map<String, V> valueMap)
public static String replace(final Object source, final Map<String, V> valueMap, final String prefix, final String suffix)
public static String replace(final Object source, final Properties valueProperties)
public static String replaceSystemProperties(final Object source)
public String replace(final String source)
public String replace(final String source, final int offset, final int length)
public String replace(final char[] source)
public String replace(final char[] source, final int offset, final int length)
public String replace(final StringBuffer source)
public String replace(final StringBuffer source, final int offset, final int length)
public String replace(final StrBuilder source)
public String replace(final StrBuilder source, final int offset, final int length)
public String replace(final Object source)
public boolean replaceIn(final StringBuffer source)
public boolean replaceIn(final StringBuffer source, final int offset, final int length)
public boolean replaceIn(final StrBuilder source)
public boolean replaceIn(final StrBuilder source, final int offset, final int length)
protected boolean substitute(final StrBuilder buf, final int offset, final int length)
private int substitute(final StrBuilder buf, final int offset, final int length, List<String> priorVariables)
private void checkCyclicSubstitution(final String varName, final List<String> priorVariables)
protected String resolveVariable(final String variableName, final StrBuilder buf, final int startPos, final int endPos)
public char getEscapeChar()
public void setEscapeChar(final char escapeCharacter)
public StrMatcher getVariablePrefixMatcher()
public StrSubstitutor setVariablePrefixMatcher(final StrMatcher prefixMatcher)
public StrSubstitutor setVariablePrefix(final char prefix)
public StrSubstitutor setVariablePrefix(final String prefix)
public StrMatcher getVariableSuffixMatcher()
public StrSubstitutor setVariableSuffixMatcher(final StrMatcher suffixMatcher)
public StrSubstitutor setVariableSuffix(final char suffix)
public StrSubstitutor setVariableSuffix(final String suffix)
public StrLookup<?> getVariableResolver()
public void setVariableResolver(final StrLookup<?> variableResolver)
public boolean isEnableSubstitutionInVariables()
public void setEnableSubstitutionInVariables(final boolean enableSubstitutionInVariables)
char DEFAULT_ESCAPE=Optional['$']
StrMatcher DEFAULT_PREFIX=Optional[StrMatcher.stringMatcher("${")]
StrMatcher DEFAULT_SUFFIX=Optional[StrMatcher.stringMatcher("}")]
char escapeChar
StrMatcher prefixMatcher
StrMatcher suffixMatcher
StrLookup<?> variableResolver
boolean enableSubstitutionInVariables
