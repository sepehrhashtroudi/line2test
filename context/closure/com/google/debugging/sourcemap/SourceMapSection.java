public SourceMapSection(String sectionUrl, int line, int column)
private SourceMapSection(SectionType type, String value, int line, int column)
public static SourceMapSection forMap(String value, int line, int column)
public static SourceMapSection forURL(String value, int line, int column)
public SectionType getSectionType()
public String getSectionUrl()
public String getSectionValue()
public int getLine()
public int getColumn()
String value
int line
int column
SectionType type