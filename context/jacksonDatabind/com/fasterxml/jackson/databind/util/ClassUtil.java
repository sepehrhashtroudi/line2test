private EnumTypeLocator()
public static List<Class<?>> findSuperTypes(Class<?> cls, Class<?> endBefore)
public static List<Class<?>> findSuperTypes(Class<?> cls, Class<?> endBefore, List<Class<?>> result)
private static void _addSuperTypes(Class<?> cls, Class<?> endBefore, Collection<Class<?>> result, boolean addClassItself)
public static String canBeABeanType(Class<?> type)
public static String isLocalType(Class<?> type, boolean allowNonStatic)
public static Class<?> getOuterClass(Class<?> type)
public static boolean isProxyType(Class<?> type)
public static boolean isConcrete(Class<?> type)
public static boolean isConcrete(Member member)
public static boolean isCollectionMapOrArray(Class<?> type)
public static String getClassDescription(Object classOrInstance)
public static Class<?> findClass(String className) throws ClassNotFoundException
public static boolean hasGetterSignature(Method m)
public static Throwable getRootCause(Throwable t)
public static void throwRootCause(Throwable t) throws Exception
public static void throwAsIAE(Throwable t)
public static void throwAsIAE(Throwable t, String msg)
public static void unwrapAndThrowAsIAE(Throwable t)
public static void unwrapAndThrowAsIAE(Throwable t, String msg)
public static T createInstance(Class<T> cls, boolean canFixAccess) throws IllegalArgumentException
public static Constructor<T> findConstructor(Class<T> cls, boolean canFixAccess) throws IllegalArgumentException
public static Object defaultValue(Class<?> cls)
public static Class<?> wrapperType(Class<?> primitiveType)
public static void checkAndFixAccess(Member member)
public static Class<? extends Enum<?>> findEnumType(EnumSet<?> s)
public static Class<? extends Enum<?>> findEnumType(EnumMap<?, ?> m)
public static Class<? extends Enum<?>> findEnumType(Enum<?> en)
public static Class<? extends Enum<?>> findEnumType(Class<?> cls)
public static boolean isJacksonStdImpl(Object impl)
public static boolean isJacksonStdImpl(Class<?> implClass)
public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> set)
public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> set)
private Object get(Object bean, Field field)
private static Field locateField(Class<?> fromClass, String expectedName, Class<?> type)