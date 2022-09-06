public HashCodeBuilder()
public HashCodeBuilder(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber)
 static Set<IDKey> getRegistry()
 static boolean isRegistered(final Object value)
private static void reflectionAppend(final Object object, final Class<?> clazz, final HashCodeBuilder builder, final boolean useTransients, final String[] excludeFields)
public static int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final Object object)
public static int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final Object object, final boolean testTransients)
public static int reflectionHashCode(final int initialNonZeroOddNumber, final int multiplierNonZeroOddNumber, final T object, final boolean testTransients, final Class<? super T> reflectUpToClass, final String... excludeFields)
public static int reflectionHashCode(final Object object, final boolean testTransients)
public static int reflectionHashCode(final Object object, final Collection<String> excludeFields)
public static int reflectionHashCode(final Object object, final String... excludeFields)
 static void register(final Object value)
 static void unregister(final Object value)
public HashCodeBuilder append(final boolean value)
public HashCodeBuilder append(final boolean[] array)
public HashCodeBuilder append(final byte value)
public HashCodeBuilder append(final byte[] array)
public HashCodeBuilder append(final char value)
public HashCodeBuilder append(final char[] array)
public HashCodeBuilder append(final double value)
public HashCodeBuilder append(final double[] array)
public HashCodeBuilder append(final float value)
public HashCodeBuilder append(final float[] array)
public HashCodeBuilder append(final int value)
public HashCodeBuilder append(final int[] array)
public HashCodeBuilder append(final long value)
public HashCodeBuilder append(final long[] array)
public HashCodeBuilder append(final Object object)
public HashCodeBuilder append(final Object[] array)
public HashCodeBuilder append(final short value)
public HashCodeBuilder append(final short[] array)
public HashCodeBuilder appendSuper(final int superHashCode)
public int toHashCode()
public Integer build()
public int hashCode()
