static Set<IDKey> getRegistry() { [EOL]     return REGISTRY.get(); [EOL] } <line_num>: 135
static boolean isRegistered(final Object value) { [EOL]     final Set<IDKey> registry = getRegistry(); [EOL]     return registry != null && registry.contains(new IDKey(value)); [EOL] } <line_num>: 150
private static void reflectionAppend(final Object object, final Class<?> clazz, final HashCodeBuilder builder, final boolean useTransients, final String[] excludeFields) { [EOL]     if (isRegistered(object)) { [EOL]         return; [EOL]     } [EOL]     try { [EOL]         register(object); [EOL]         final Field[] fields = clazz.getDeclaredFields(); [EOL]         AccessibleObject.setAccessible(fields, true); [EOL]         for (final Field field : fields) { [EOL]             if (!ArrayUtils.contains(excludeFields, field.getName()) && (field.getName().indexOf('$') == -1) && (useTransients || !Modifier.isTransient(field.getModifiers())) && (!Modifier.isStatic(field.getModifiers()))) { [EOL]                 try { [EOL]                     final Object fieldValue = field.get(object); [EOL]                     builder.append(fieldValue); [EOL]                 } catch (final IllegalAccessException e) { [EOL]                     throw new InternalError("Unexpected IllegalAccessException"); [EOL]                 } [EOL]             } [EOL]         } [EOL]     } finally { [EOL]         unregister(object); [EOL]     } [EOL] } <line_num>: 171
public static int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final Object object) { [EOL]     return reflectionHashCode(initialNonZeroOddNumber, multiplierNonZeroOddNumber, object, false, null); [EOL] } <line_num>: 237
public static int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final Object object, final boolean testTransients) { [EOL]     return reflectionHashCode(initialNonZeroOddNumber, multiplierNonZeroOddNumber, object, testTransients, null); [EOL] } <line_num>: 280
public static <T> int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final T object, final boolean testTransients, final Class<? super T> reflectUpToClass, final String... excludeFields) { [EOL]     if (object == null) { [EOL]         throw new IllegalArgumentException("The object to build a hash code for must not be null"); [EOL]     } [EOL]     final HashCodeBuilder builder = new HashCodeBuilder(initialNonZeroOddNumber, multiplierNonZeroOddNumber); [EOL]     Class<?> clazz = object.getClass(); [EOL]     reflectionAppend(object, clazz, builder, testTransients, excludeFields); [EOL]     while (clazz.getSuperclass() != null && clazz != reflectUpToClass) { [EOL]         clazz = clazz.getSuperclass(); [EOL]         reflectionAppend(object, clazz, builder, testTransients, excludeFields); [EOL]     } [EOL]     return builder.toHashCode(); [EOL] } <line_num>: 332
public static int reflectionHashCode(final Object object, final boolean testTransients) { [EOL]     return reflectionHashCode(17, 37, object, testTransients, null); [EOL] } <line_num>: 380
public static int reflectionHashCode(final Object object, final Collection<String> excludeFields) { [EOL]     return reflectionHashCode(object, ReflectionToStringBuilder.toNoNullStringArray(excludeFields)); [EOL] } <line_num>: 416
public static int reflectionHashCode(final Object object, final String... excludeFields) { [EOL]     return reflectionHashCode(17, 37, object, false, null, excludeFields); [EOL] } <line_num>: 454
static void register(final Object value) { [EOL]     synchronized (HashCodeBuilder.class) { [EOL]         if (getRegistry() == null) { [EOL]             REGISTRY.set(new HashSet<IDKey>()); [EOL]         } [EOL]     } [EOL]     getRegistry().add(new IDKey(value)); [EOL] } <line_num>: 466
static void unregister(final Object value) { [EOL]     Set<IDKey> registry = getRegistry(); [EOL]     if (registry != null) { [EOL]         registry.remove(new IDKey(value)); [EOL]         synchronized (HashCodeBuilder.class) { [EOL]             registry = getRegistry(); [EOL]             if (registry != null && registry.isEmpty()) { [EOL]                 REGISTRY.remove(); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 487
public HashCodeBuilder append(final boolean value) { [EOL]     iTotal = iTotal * iConstant + (value ? 0 : 1); [EOL]     return this; [EOL] } <line_num>: 576
public HashCodeBuilder append(final boolean[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final boolean element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 590
public HashCodeBuilder append(final byte value) { [EOL]     iTotal = iTotal * iConstant + value; [EOL]     return this; [EOL] } <line_num>: 612
public HashCodeBuilder append(final byte[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final byte element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 628
public HashCodeBuilder append(final char value) { [EOL]     iTotal = iTotal * iConstant + value; [EOL]     return this; [EOL] } <line_num>: 648
public HashCodeBuilder append(final char[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final char element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 662
public HashCodeBuilder append(final double value) { [EOL]     return append(Double.doubleToLongBits(value)); [EOL] } <line_num>: 682
public HashCodeBuilder append(final double[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final double element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 695
public HashCodeBuilder append(final float value) { [EOL]     iTotal = iTotal * iConstant + Float.floatToIntBits(value); [EOL]     return this; [EOL] } <line_num>: 715
public HashCodeBuilder append(final float[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final float element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 729
public HashCodeBuilder append(final int value) { [EOL]     iTotal = iTotal * iConstant + value; [EOL]     return this; [EOL] } <line_num>: 749
public HashCodeBuilder append(final int[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final int element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 763
public HashCodeBuilder append(final long value) { [EOL]     iTotal = iTotal * iConstant + ((int) (value ^ (value >> 32))); [EOL]     return this; [EOL] } <line_num>: 787
public HashCodeBuilder append(final long[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final long element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 801
public HashCodeBuilder append(final Object object) { [EOL]     if (object == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         if (object.getClass().isArray()) { [EOL]             if (object instanceof long[]) { [EOL]                 append((long[]) object); [EOL]             } else if (object instanceof int[]) { [EOL]                 append((int[]) object); [EOL]             } else if (object instanceof short[]) { [EOL]                 append((short[]) object); [EOL]             } else if (object instanceof char[]) { [EOL]                 append((char[]) object); [EOL]             } else if (object instanceof byte[]) { [EOL]                 append((byte[]) object); [EOL]             } else if (object instanceof double[]) { [EOL]                 append((double[]) object); [EOL]             } else if (object instanceof float[]) { [EOL]                 append((float[]) object); [EOL]             } else if (object instanceof boolean[]) { [EOL]                 append((boolean[]) object); [EOL]             } else { [EOL]                 append((Object[]) object); [EOL]             } [EOL]         } else { [EOL]             iTotal = iTotal * iConstant + object.hashCode(); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 821
public HashCodeBuilder append(final Object[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final Object element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 865
public HashCodeBuilder append(final short value) { [EOL]     iTotal = iTotal * iConstant + value; [EOL]     return this; [EOL] } <line_num>: 885
public HashCodeBuilder append(final short[] array) { [EOL]     if (array == null) { [EOL]         iTotal = iTotal * iConstant; [EOL]     } else { [EOL]         for (final short element : array) { [EOL]             append(element); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 899
public HashCodeBuilder appendSuper(final int superHashCode) { [EOL]     iTotal = iTotal * iConstant + superHashCode; [EOL]     return this; [EOL] } <line_num>: 920
public int toHashCode() { [EOL]     return iTotal; [EOL] } <line_num>: 932
@Override [EOL] public Integer build() { [EOL]     return Integer.valueOf(toHashCode()); [EOL] } <line_num>: 944
@Override [EOL] public int hashCode() { [EOL]     return toHashCode(); [EOL] } <line_num>: 958