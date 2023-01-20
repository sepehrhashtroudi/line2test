public ArrayBuilders() { [EOL] } <line_num>: 27,27
public BooleanBuilder() { [EOL] } <line_num>: 90,90
public ByteBuilder() { [EOL] } <line_num>: 98,98
public ShortBuilder() { [EOL] } <line_num>: 105,105
public IntBuilder() { [EOL] } <line_num>: 112,112
public LongBuilder() { [EOL] } <line_num>: 119,119
public FloatBuilder() { [EOL] } <line_num>: 127,127
public DoubleBuilder() { [EOL] } <line_num>: 134,134
public ArrayIterator(T[] array) { [EOL]     _array = array; [EOL]     _index = 0; [EOL] } <line_num>: 329,332
public BooleanBuilder getBooleanBuilder() { [EOL]     if (_booleanBuilder == null) { [EOL]         _booleanBuilder = new BooleanBuilder(); [EOL]     } [EOL]     return _booleanBuilder; [EOL] } <line_num>: 29,35
public ByteBuilder getByteBuilder() { [EOL]     if (_byteBuilder == null) { [EOL]         _byteBuilder = new ByteBuilder(); [EOL]     } [EOL]     return _byteBuilder; [EOL] } <line_num>: 37,43
public ShortBuilder getShortBuilder() { [EOL]     if (_shortBuilder == null) { [EOL]         _shortBuilder = new ShortBuilder(); [EOL]     } [EOL]     return _shortBuilder; [EOL] } <line_num>: 44,50
public IntBuilder getIntBuilder() { [EOL]     if (_intBuilder == null) { [EOL]         _intBuilder = new IntBuilder(); [EOL]     } [EOL]     return _intBuilder; [EOL] } <line_num>: 51,57
public LongBuilder getLongBuilder() { [EOL]     if (_longBuilder == null) { [EOL]         _longBuilder = new LongBuilder(); [EOL]     } [EOL]     return _longBuilder; [EOL] } <line_num>: 58,64
public FloatBuilder getFloatBuilder() { [EOL]     if (_floatBuilder == null) { [EOL]         _floatBuilder = new FloatBuilder(); [EOL]     } [EOL]     return _floatBuilder; [EOL] } <line_num>: 66,72
public DoubleBuilder getDoubleBuilder() { [EOL]     if (_doubleBuilder == null) { [EOL]         _doubleBuilder = new DoubleBuilder(); [EOL]     } [EOL]     return _doubleBuilder; [EOL] } <line_num>: 73,79
@Override [EOL] public final boolean[] _constructArray(int len) { [EOL]     return new boolean[len]; [EOL] } <line_num>: 91,92
@Override [EOL] public final byte[] _constructArray(int len) { [EOL]     return new byte[len]; [EOL] } <line_num>: 99,100
@Override [EOL] public final short[] _constructArray(int len) { [EOL]     return new short[len]; [EOL] } <line_num>: 106,107
@Override [EOL] public final int[] _constructArray(int len) { [EOL]     return new int[len]; [EOL] } <line_num>: 113,114
@Override [EOL] public final long[] _constructArray(int len) { [EOL]     return new long[len]; [EOL] } <line_num>: 120,121
@Override [EOL] public final float[] _constructArray(int len) { [EOL]     return new float[len]; [EOL] } <line_num>: 128,129
@Override [EOL] public final double[] _constructArray(int len) { [EOL]     return new double[len]; [EOL] } <line_num>: 135,136
@Override [EOL] public boolean equals(Object other) { [EOL]     if (other == this) [EOL]         return true; [EOL]     if (other == null || other.getClass() != defaultValueType) { [EOL]         return false; [EOL]     } [EOL]     if (Array.getLength(other) != length) [EOL]         return false; [EOL]     for (int i = 0; i < length; ++i) { [EOL]         Object value1 = Array.get(defaultValue, i); [EOL]         Object value2 = Array.get(other, i); [EOL]         if (value1 == value2) [EOL]             continue; [EOL]         if (value1 != null) { [EOL]             if (!value1.equals(value2)) { [EOL]                 return false; [EOL]             } [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 160,179
public static Object getArrayComparator(final Object defaultValue) { [EOL]     final int length = Array.getLength(defaultValue); [EOL]     final Class<?> defaultValueType = defaultValue.getClass(); [EOL]     return new Object() { [EOL]  [EOL]         @Override [EOL]         public boolean equals(Object other) { [EOL]             if (other == this) [EOL]                 return true; [EOL]             if (other == null || other.getClass() != defaultValueType) { [EOL]                 return false; [EOL]             } [EOL]             if (Array.getLength(other) != length) [EOL]                 return false; [EOL]             for (int i = 0; i < length; ++i) { [EOL]                 Object value1 = Array.get(defaultValue, i); [EOL]                 Object value2 = Array.get(other, i); [EOL]                 if (value1 == value2) [EOL]                     continue; [EOL]                 if (value1 != null) { [EOL]                     if (!value1.equals(value2)) { [EOL]                         return false; [EOL]                     } [EOL]                 } [EOL]             } [EOL]             return true; [EOL]         } [EOL]     }; [EOL] } <line_num>: 155,181
public static <T> HashSet<T> arrayToSet(T[] elements) { [EOL]     HashSet<T> result = new HashSet<T>(); [EOL]     if (elements != null) { [EOL]         for (T elem : elements) { [EOL]             result.add(elem); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 183,192
public static <T> ArrayList<T> arrayToList(T[] elements) { [EOL]     ArrayList<T> result = new ArrayList<T>(); [EOL]     if (elements != null) { [EOL]         for (T elem : elements) { [EOL]             result.add(elem); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 194,203
public static <T> HashSet<T> setAndArray(Set<T> set, T[] elements) { [EOL]     HashSet<T> result = new HashSet<T>(); [EOL]     if (set != null) { [EOL]         result.addAll(set); [EOL]     } [EOL]     if (elements != null) { [EOL]         for (T value : elements) { [EOL]             result.add(value); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 205,217
public static <T> List<T> addToList(List<T> list, T element) { [EOL]     if (list == null) { [EOL]         list = new ArrayList<T>(); [EOL]     } [EOL]     list.add(element); [EOL]     return list; [EOL] } <line_num>: 231,238
public static <T> T[] insertInList(T[] array, T element) { [EOL]     int len = array.length; [EOL]     @SuppressWarnings("unchecked") [EOL]     T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), len + 1); [EOL]     if (len > 0) { [EOL]         System.arraycopy(array, 0, result, 1, len); [EOL]     } [EOL]     result[0] = element; [EOL]     return result; [EOL] } <line_num>: 245,255
@SuppressWarnings("unchecked") [EOL] public static <T> T[] insertInListNoDup(T[] array, T element) { [EOL]     final int len = array.length; [EOL]     for (int ix = 0; ix < len; ++ix) { [EOL]         if (array[ix] == element) { [EOL]             if (ix == 0) { [EOL]                 return array; [EOL]             } [EOL]             T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), len); [EOL]             System.arraycopy(array, 0, result, 1, ix); [EOL]             result[0] = element; [EOL]             ++ix; [EOL]             int left = len - ix; [EOL]             if (left > 0) { [EOL]                 System.arraycopy(array, ix, result, ix, left); [EOL]             } [EOL]             return result; [EOL]         } [EOL]     } [EOL]     T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), len + 1); [EOL]     if (len > 0) { [EOL]         System.arraycopy(array, 0, result, 1, len); [EOL]     } [EOL]     result[0] = element; [EOL]     return result; [EOL] } <line_num>: 265,297
public static <T> Iterator<T> arrayAsIterator(T[] array) { [EOL]     return new ArrayIterator<T>(array); [EOL] } <line_num>: 302,305
public static <T> Iterable<T> arrayAsIterable(T[] array) { [EOL]     return new ArrayIterator<T>(array); [EOL] } <line_num>: 307,310
@Override [EOL] public boolean hasNext() { [EOL]     return _index < _array.length; [EOL] } <line_num>: 334,337
@Override [EOL] public T next() { [EOL]     if (_index >= _array.length) { [EOL]         throw new NoSuchElementException(); [EOL]     } [EOL]     return _array[_index++]; [EOL] } <line_num>: 339,346
@Override [EOL] public void remove() { [EOL]     throw new UnsupportedOperationException(); [EOL] } <line_num>: 348,351
@Override [EOL] public Iterator<T> iterator() { [EOL]     return this; [EOL] } <line_num>: 353,356
