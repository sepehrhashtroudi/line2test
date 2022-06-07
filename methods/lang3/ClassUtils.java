private static void addAbbreviation(final String primitive, final String abbreviation) { [EOL]     abbreviationMap.put(primitive, abbreviation); [EOL]     reverseAbbreviationMap.put(abbreviation, primitive); [EOL] } <line_num>: 110
public static String getShortClassName(final Object object, final String valueIfNull) { [EOL]     if (object == null) { [EOL]         return valueIfNull; [EOL]     } [EOL]     return getShortClassName(object.getClass()); [EOL] } <line_num>: 150
public static String getShortClassName(final Class<?> cls) { [EOL]     if (cls == null) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     return getShortClassName(cls.getName()); [EOL] } <line_num>: 167
public static String getShortClassName(String className) { [EOL]     if (StringUtils.isEmpty(className)) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     final StringBuilder arrayPrefix = new StringBuilder(); [EOL]     if (className.startsWith("[")) { [EOL]         while (className.charAt(0) == '[') { [EOL]             className = className.substring(1); [EOL]             arrayPrefix.append("[]"); [EOL]         } [EOL]         if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') { [EOL]             className = className.substring(1, className.length() - 1); [EOL]         } [EOL]         if (reverseAbbreviationMap.containsKey(className)) { [EOL]             className = reverseAbbreviationMap.get(className); [EOL]         } [EOL]     } [EOL]     final int lastDotIdx = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR); [EOL]     final int innerIdx = className.indexOf(INNER_CLASS_SEPARATOR_CHAR, lastDotIdx == -1 ? 0 : lastDotIdx + 1); [EOL]     String out = className.substring(lastDotIdx + 1); [EOL]     if (innerIdx != -1) { [EOL]         out = out.replace(INNER_CLASS_SEPARATOR_CHAR, PACKAGE_SEPARATOR_CHAR); [EOL]     } [EOL]     return out + arrayPrefix; [EOL] } <line_num>: 186
public static String getSimpleName(final Class<?> cls) { [EOL]     if (cls == null) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     return cls.getSimpleName(); [EOL] } <line_num>: 227
public static String getSimpleName(final Object object, final String valueIfNull) { [EOL]     if (object == null) { [EOL]         return valueIfNull; [EOL]     } [EOL]     return getSimpleName(object.getClass()); [EOL] } <line_num>: 243
public static String getPackageName(final Object object, final String valueIfNull) { [EOL]     if (object == null) { [EOL]         return valueIfNull; [EOL]     } [EOL]     return getPackageName(object.getClass()); [EOL] } <line_num>: 259
public static String getPackageName(final Class<?> cls) { [EOL]     if (cls == null) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     return getPackageName(cls.getName()); [EOL] } <line_num>: 272
public static String getPackageName(String className) { [EOL]     if (StringUtils.isEmpty(className)) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     while (className.charAt(0) == '[') { [EOL]         className = className.substring(1); [EOL]     } [EOL]     if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') { [EOL]         className = className.substring(1); [EOL]     } [EOL]     final int i = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR); [EOL]     if (i == -1) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     return className.substring(0, i); [EOL] } <line_num>: 288
public static List<Class<?>> getAllSuperclasses(final Class<?> cls) { [EOL]     if (cls == null) { [EOL]         return null; [EOL]     } [EOL]     final List<Class<?>> classes = new ArrayList<Class<?>>(); [EOL]     Class<?> superclass = cls.getSuperclass(); [EOL]     while (superclass != null) { [EOL]         classes.add(superclass); [EOL]         superclass = superclass.getSuperclass(); [EOL]     } [EOL]     return classes; [EOL] } <line_num>: 318
public static List<Class<?>> getAllInterfaces(final Class<?> cls) { [EOL]     if (cls == null) { [EOL]         return null; [EOL]     } [EOL]     final LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<Class<?>>(); [EOL]     getAllInterfaces(cls, interfacesFound); [EOL]     return new ArrayList<Class<?>>(interfacesFound); [EOL] } <line_num>: 344
private static void getAllInterfaces(Class<?> cls, final HashSet<Class<?>> interfacesFound) { [EOL]     while (cls != null) { [EOL]         final Class<?>[] interfaces = cls.getInterfaces(); [EOL]         for (final Class<?> i : interfaces) { [EOL]             if (interfacesFound.add(i)) { [EOL]                 getAllInterfaces(i, interfacesFound); [EOL]             } [EOL]         } [EOL]         cls = cls.getSuperclass(); [EOL]     } [EOL] } <line_num>: 361
public static List<Class<?>> convertClassNamesToClasses(final List<String> classNames) { [EOL]     if (classNames == null) { [EOL]         return null; [EOL]     } [EOL]     final List<Class<?>> classes = new ArrayList<Class<?>>(classNames.size()); [EOL]     for (final String className : classNames) { [EOL]         try { [EOL]             classes.add(Class.forName(className)); [EOL]         } catch (final Exception ex) { [EOL]             classes.add(null); [EOL]         } [EOL]     } [EOL]     return classes; [EOL] } <line_num>: 389
public static List<String> convertClassesToClassNames(final List<Class<?>> classes) { [EOL]     if (classes == null) { [EOL]         return null; [EOL]     } [EOL]     final List<String> classNames = new ArrayList<String>(classes.size()); [EOL]     for (final Class<?> cls : classes) { [EOL]         if (cls == null) { [EOL]             classNames.add(null); [EOL]         } else { [EOL]             classNames.add(cls.getName()); [EOL]         } [EOL]     } [EOL]     return classNames; [EOL] } <line_num>: 416
public static boolean isAssignable(final Class<?>[] classArray, final Class<?>... toClassArray) { [EOL]     return isAssignable(classArray, toClassArray, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5)); [EOL] } <line_num>: 469
public static boolean isAssignable(Class<?>[] classArray, Class<?>[] toClassArray, final boolean autoboxing) { [EOL]     if (ArrayUtils.isSameLength(classArray, toClassArray) == false) { [EOL]         return false; [EOL]     } [EOL]     if (classArray == null) { [EOL]         classArray = ArrayUtils.EMPTY_CLASS_ARRAY; [EOL]     } [EOL]     if (toClassArray == null) { [EOL]         toClassArray = ArrayUtils.EMPTY_CLASS_ARRAY; [EOL]     } [EOL]     for (int i = 0; i < classArray.length; i++) { [EOL]         if (isAssignable(classArray[i], toClassArray[i], autoboxing) == false) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 505
public static boolean isPrimitiveOrWrapper(final Class<?> type) { [EOL]     if (type == null) { [EOL]         return false; [EOL]     } [EOL]     return type.isPrimitive() || isPrimitiveWrapper(type); [EOL] } <line_num>: 533
public static boolean isPrimitiveWrapper(final Class<?> type) { [EOL]     return wrapperPrimitiveMap.containsKey(type); [EOL] } <line_num>: 550
public static boolean isAssignable(final Class<?> cls, final Class<?> toClass) { [EOL]     return isAssignable(cls, toClass, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5)); [EOL] } <line_num>: 585
public static boolean isAssignable(Class<?> cls, final Class<?> toClass, final boolean autoboxing) { [EOL]     if (toClass == null) { [EOL]         return false; [EOL]     } [EOL]     if (cls == null) { [EOL]         return !toClass.isPrimitive(); [EOL]     } [EOL]     if (autoboxing) { [EOL]         if (cls.isPrimitive() && !toClass.isPrimitive()) { [EOL]             cls = primitiveToWrapper(cls); [EOL]             if (cls == null) { [EOL]                 return false; [EOL]             } [EOL]         } [EOL]         if (toClass.isPrimitive() && !cls.isPrimitive()) { [EOL]             cls = wrapperToPrimitive(cls); [EOL]             if (cls == null) { [EOL]                 return false; [EOL]             } [EOL]         } [EOL]     } [EOL]     if (cls.equals(toClass)) { [EOL]         return true; [EOL]     } [EOL]     if (cls.isPrimitive()) { [EOL]         if (toClass.isPrimitive() == false) { [EOL]             return false; [EOL]         } [EOL]         if (Integer.TYPE.equals(cls)) { [EOL]             return Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass); [EOL]         } [EOL]         if (Long.TYPE.equals(cls)) { [EOL]             return Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass); [EOL]         } [EOL]         if (Boolean.TYPE.equals(cls)) { [EOL]             return false; [EOL]         } [EOL]         if (Double.TYPE.equals(cls)) { [EOL]             return false; [EOL]         } [EOL]         if (Float.TYPE.equals(cls)) { [EOL]             return Double.TYPE.equals(toClass); [EOL]         } [EOL]         if (Character.TYPE.equals(cls)) { [EOL]             return Integer.TYPE.equals(toClass) || Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass); [EOL]         } [EOL]         if (Short.TYPE.equals(cls)) { [EOL]             return Integer.TYPE.equals(toClass) || Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass); [EOL]         } [EOL]         if (Byte.TYPE.equals(cls)) { [EOL]             return Short.TYPE.equals(toClass) || Integer.TYPE.equals(toClass) || Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass); [EOL]         } [EOL]         return false; [EOL]     } [EOL]     return toClass.isAssignableFrom(cls); [EOL] } <line_num>: 616
public static Class<?> primitiveToWrapper(final Class<?> cls) { [EOL]     Class<?> convertedClass = cls; [EOL]     if (cls != null && cls.isPrimitive()) { [EOL]         convertedClass = primitiveWrapperMap.get(cls); [EOL]     } [EOL]     return convertedClass; [EOL] } <line_num>: 701
public static Class<?>[] primitivesToWrappers(final Class<?>... classes) { [EOL]     if (classes == null) { [EOL]         return null; [EOL]     } [EOL]     if (classes.length == 0) { [EOL]         return classes; [EOL]     } [EOL]     final Class<?>[] convertedClasses = new Class[classes.length]; [EOL]     for (int i = 0; i < classes.length; i++) { [EOL]         convertedClasses[i] = primitiveToWrapper(classes[i]); [EOL]     } [EOL]     return convertedClasses; [EOL] } <line_num>: 719
public static Class<?> wrapperToPrimitive(final Class<?> cls) { [EOL]     return wrapperPrimitiveMap.get(cls); [EOL] } <line_num>: 751
public static Class<?>[] wrappersToPrimitives(final Class<?>... classes) { [EOL]     if (classes == null) { [EOL]         return null; [EOL]     } [EOL]     if (classes.length == 0) { [EOL]         return classes; [EOL]     } [EOL]     final Class<?>[] convertedClasses = new Class[classes.length]; [EOL]     for (int i = 0; i < classes.length; i++) { [EOL]         convertedClasses[i] = wrapperToPrimitive(classes[i]); [EOL]     } [EOL]     return convertedClasses; [EOL] } <line_num>: 769
public static boolean isInnerClass(final Class<?> cls) { [EOL]     return cls != null && cls.getEnclosingClass() != null; [EOL] } <line_num>: 794
public static Class<?> getClass(final ClassLoader classLoader, final String className, final boolean initialize) throws ClassNotFoundException { [EOL]     try { [EOL]         Class<?> clazz; [EOL]         if (abbreviationMap.containsKey(className)) { [EOL]             final String clsName = "[" + abbreviationMap.get(className); [EOL]             clazz = Class.forName(clsName, initialize, classLoader).getComponentType(); [EOL]         } else { [EOL]             clazz = Class.forName(toCanonicalName(className), initialize, classLoader); [EOL]         } [EOL]         return clazz; [EOL]     } catch (final ClassNotFoundException ex) { [EOL]         final int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR); [EOL]         if (lastDotIndex != -1) { [EOL]             try { [EOL]                 return getClass(classLoader, className.substring(0, lastDotIndex) + INNER_CLASS_SEPARATOR_CHAR + className.substring(lastDotIndex + 1), initialize); [EOL]             } catch (final ClassNotFoundException ex2) { [EOL]             } [EOL]         } [EOL]         throw ex; [EOL]     } [EOL] } <line_num>: 812
public static Class<?> getClass(final ClassLoader classLoader, final String className) throws ClassNotFoundException { [EOL]     return getClass(classLoader, className, true); [EOL] } <line_num>: 853
public static Class<?> getClass(final String className) throws ClassNotFoundException { [EOL]     return getClass(className, true); [EOL] } <line_num>: 868
public static Class<?> getClass(final String className, final boolean initialize) throws ClassNotFoundException { [EOL]     final ClassLoader contextCL = Thread.currentThread().getContextClassLoader(); [EOL]     final ClassLoader loader = contextCL == null ? ClassUtils.class.getClassLoader() : contextCL; [EOL]     return getClass(loader, className, initialize); [EOL] } <line_num>: 883
public static Method getPublicMethod(final Class<?> cls, final String methodName, final Class<?>... parameterTypes) throws SecurityException, NoSuchMethodException { [EOL]     final Method declaredMethod = cls.getMethod(methodName, parameterTypes); [EOL]     if (Modifier.isPublic(declaredMethod.getDeclaringClass().getModifiers())) { [EOL]         return declaredMethod; [EOL]     } [EOL]     final List<Class<?>> candidateClasses = new ArrayList<Class<?>>(); [EOL]     candidateClasses.addAll(getAllInterfaces(cls)); [EOL]     candidateClasses.addAll(getAllSuperclasses(cls)); [EOL]     for (final Class<?> candidateClass : candidateClasses) { [EOL]         if (!Modifier.isPublic(candidateClass.getModifiers())) { [EOL]             continue; [EOL]         } [EOL]         Method candidateMethod; [EOL]         try { [EOL]             candidateMethod = candidateClass.getMethod(methodName, parameterTypes); [EOL]         } catch (final NoSuchMethodException ex) { [EOL]             continue; [EOL]         } [EOL]         if (Modifier.isPublic(candidateMethod.getDeclaringClass().getModifiers())) { [EOL]             return candidateMethod; [EOL]         } [EOL]     } [EOL]     throw new NoSuchMethodException("Can't find a public method for " + methodName + " " + ArrayUtils.toString(parameterTypes)); [EOL] } <line_num>: 912
private static String toCanonicalName(String className) { [EOL]     className = StringUtils.deleteWhitespace(className); [EOL]     if (className == null) { [EOL]         throw new NullPointerException("className must not be null."); [EOL]     } else if (className.endsWith("[]")) { [EOL]         final StringBuilder classNameBuffer = new StringBuilder(); [EOL]         while (className.endsWith("[]")) { [EOL]             className = className.substring(0, className.length() - 2); [EOL]             classNameBuffer.append("["); [EOL]         } [EOL]         final String abbreviation = abbreviationMap.get(className); [EOL]         if (abbreviation != null) { [EOL]             classNameBuffer.append(abbreviation); [EOL]         } else { [EOL]             classNameBuffer.append("L").append(className).append(";"); [EOL]         } [EOL]         className = classNameBuffer.toString(); [EOL]     } [EOL]     return className; [EOL] } <line_num>: 950
public static Class<?>[] toClass(final Object... array) { [EOL]     if (array == null) { [EOL]         return null; [EOL]     } else if (array.length == 0) { [EOL]         return ArrayUtils.EMPTY_CLASS_ARRAY; [EOL]     } [EOL]     final Class<?>[] classes = new Class[array.length]; [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         classes[i] = array[i] == null ? null : array[i].getClass(); [EOL]     } [EOL]     return classes; [EOL] } <line_num>: 981
public static String getShortCanonicalName(final Object object, final String valueIfNull) { [EOL]     if (object == null) { [EOL]         return valueIfNull; [EOL]     } [EOL]     return getShortCanonicalName(object.getClass().getName()); [EOL] } <line_num>: 1004
public static String getShortCanonicalName(final Class<?> cls) { [EOL]     if (cls == null) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     return getShortCanonicalName(cls.getName()); [EOL] } <line_num>: 1018
public static String getShortCanonicalName(final String canonicalName) { [EOL]     return ClassUtils.getShortClassName(getCanonicalName(canonicalName)); [EOL] } <line_num>: 1034
public static String getPackageCanonicalName(final Object object, final String valueIfNull) { [EOL]     if (object == null) { [EOL]         return valueIfNull; [EOL]     } [EOL]     return getPackageCanonicalName(object.getClass().getName()); [EOL] } <line_num>: 1048
public static String getPackageCanonicalName(final Class<?> cls) { [EOL]     if (cls == null) { [EOL]         return StringUtils.EMPTY; [EOL]     } [EOL]     return getPackageCanonicalName(cls.getName()); [EOL] } <line_num>: 1062
public static String getPackageCanonicalName(final String canonicalName) { [EOL]     return ClassUtils.getPackageName(getCanonicalName(canonicalName)); [EOL] } <line_num>: 1079
private static String getCanonicalName(String className) { [EOL]     className = StringUtils.deleteWhitespace(className); [EOL]     if (className == null) { [EOL]         return null; [EOL]     } else { [EOL]         int dim = 0; [EOL]         while (className.startsWith("[")) { [EOL]             dim++; [EOL]             className = className.substring(1); [EOL]         } [EOL]         if (dim < 1) { [EOL]             return className; [EOL]         } else { [EOL]             if (className.startsWith("L")) { [EOL]                 className = className.substring(1, className.endsWith(";") ? className.length() - 1 : className.length()); [EOL]             } else { [EOL]                 if (className.length() > 0) { [EOL]                     className = reverseAbbreviationMap.get(className.substring(0, 1)); [EOL]                 } [EOL]             } [EOL]             final StringBuilder canonicalClassNameBuffer = new StringBuilder(className); [EOL]             for (int i = 0; i < dim; i++) { [EOL]                 canonicalClassNameBuffer.append("[]"); [EOL]             } [EOL]             return canonicalClassNameBuffer.toString(); [EOL]         } [EOL]     } [EOL] } <line_num>: 1099
