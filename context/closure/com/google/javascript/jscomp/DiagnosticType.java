private DiagnosticType(String key, CheckLevel level, MessageFormat format)
public static DiagnosticType error(String name, String descriptionFormat)
public static DiagnosticType warning(String name, String descriptionFormat)
public static DiagnosticType disabled(String name, String descriptionFormat)
public static DiagnosticType make(String name, CheckLevel level, String descriptionFormat)
 String format(Object... arguments)
public boolean equals(Object type)
public int hashCode()
public int compareTo(DiagnosticType diagnosticType)
public String toString()
long serialVersionUID=Optional[1]
String key
MessageFormat format
CheckLevel defaultLevel
CheckLevel level