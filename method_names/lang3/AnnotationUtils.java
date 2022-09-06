public AnnotationUtils()
protected String getShortClassName(final java.lang.Class<?> cls)
protected void appendDetail(final StringBuffer buffer, final String fieldName, Object value)
public static boolean equals(final Annotation a1, final Annotation a2)
public static int hashCode(final Annotation a)
public static String toString(final Annotation a)
public static boolean isValidAnnotationMemberType(Class<?> type)
private static int hashMember(final String name, final Object value)
private static boolean memberEquals(final Class<?> type, final Object o1, final Object o2)
private static boolean arrayMemberEquals(final Class<?> componentType, final Object o1, final Object o2)
private static boolean annotationArrayMemberEquals(final Annotation[] a1, final Annotation[] a2)
private static int arrayMemberHash(final Class<?> componentType, final Object o)
