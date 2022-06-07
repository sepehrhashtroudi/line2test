static Map<Object, Object> getRegistry() { [EOL]     return REGISTRY.get(); [EOL] } <line_num>: 156
static boolean isRegistered(final Object value) { [EOL]     final Map<Object, Object> m = getRegistry(); [EOL]     return m != null && m.containsKey(value); [EOL] } <line_num>: 171
static void register(final Object value) { [EOL]     if (value != null) { [EOL]         final Map<Object, Object> m = getRegistry(); [EOL]         if (m == null) { [EOL]             REGISTRY.set(new WeakHashMap<Object, Object>()); [EOL]         } [EOL]         getRegistry().put(value, null); [EOL]     } [EOL] } <line_num>: 185
static void unregister(final Object value) { [EOL]     if (value != null) { [EOL]         final Map<Object, Object> m = getRegistry(); [EOL]         if (m != null) { [EOL]             m.remove(value); [EOL]             if (m.isEmpty()) { [EOL]                 REGISTRY.remove(); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 207
public void appendSuper(final StringBuffer buffer, final String superToString) { [EOL]     appendToString(buffer, superToString); [EOL] } <line_num>: 341
public void appendToString(final StringBuffer buffer, final String toString) { [EOL]     if (toString != null) { [EOL]         final int pos1 = toString.indexOf(contentStart) + contentStart.length(); [EOL]         final int pos2 = toString.lastIndexOf(contentEnd); [EOL]         if (pos1 != pos2 && pos1 >= 0 && pos2 >= 0) { [EOL]             final String data = toString.substring(pos1, pos2); [EOL]             if (fieldSeparatorAtStart) { [EOL]                 removeLastFieldSeparator(buffer); [EOL]             } [EOL]             buffer.append(data); [EOL]             appendFieldSeparator(buffer); [EOL]         } [EOL]     } [EOL] } <line_num>: 355
public void appendStart(final StringBuffer buffer, final Object object) { [EOL]     if (object != null) { [EOL]         appendClassName(buffer, object); [EOL]         appendIdentityHashCode(buffer, object); [EOL]         appendContentStart(buffer); [EOL]         if (fieldSeparatorAtStart) { [EOL]             appendFieldSeparator(buffer); [EOL]         } [EOL]     } [EOL] } <line_num>: 376
public void appendEnd(final StringBuffer buffer, final Object object) { [EOL]     if (this.fieldSeparatorAtEnd == false) { [EOL]         removeLastFieldSeparator(buffer); [EOL]     } [EOL]     appendContentEnd(buffer); [EOL]     unregister(object); [EOL] } <line_num>: 394
protected void removeLastFieldSeparator(final StringBuffer buffer) { [EOL]     final int len = buffer.length(); [EOL]     final int sepLen = fieldSeparator.length(); [EOL]     if (len > 0 && sepLen > 0 && len >= sepLen) { [EOL]         boolean match = true; [EOL]         for (int i = 0; i < sepLen; i++) { [EOL]             if (buffer.charAt(len - 1 - i) != fieldSeparator.charAt(sepLen - 1 - i)) { [EOL]                 match = false; [EOL]                 break; [EOL]             } [EOL]         } [EOL]         if (match) { [EOL]             buffer.setLength(len - sepLen); [EOL]         } [EOL]     } [EOL] } <line_num>: 408
public void append(final StringBuffer buffer, final String fieldName, final Object value, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (value == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else { [EOL]         appendInternal(buffer, fieldName, value, isFullDetail(fullDetail)); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 438
protected void appendInternal(final StringBuffer buffer, final String fieldName, final Object value, final boolean detail) { [EOL]     if (isRegistered(value) && !(value instanceof Number || value instanceof Boolean || value instanceof Character)) { [EOL]         appendCyclicObject(buffer, fieldName, value); [EOL]         return; [EOL]     } [EOL]     register(value); [EOL]     try { [EOL]         if (value instanceof Collection<?>) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (Collection<?>) value); [EOL]             } else { [EOL]                 appendSummarySize(buffer, fieldName, ((Collection<?>) value).size()); [EOL]             } [EOL]         } else if (value instanceof Map<?, ?>) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (Map<?, ?>) value); [EOL]             } else { [EOL]                 appendSummarySize(buffer, fieldName, ((Map<?, ?>) value).size()); [EOL]             } [EOL]         } else if (value instanceof long[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (long[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (long[]) value); [EOL]             } [EOL]         } else if (value instanceof int[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (int[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (int[]) value); [EOL]             } [EOL]         } else if (value instanceof short[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (short[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (short[]) value); [EOL]             } [EOL]         } else if (value instanceof byte[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (byte[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (byte[]) value); [EOL]             } [EOL]         } else if (value instanceof char[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (char[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (char[]) value); [EOL]             } [EOL]         } else if (value instanceof double[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (double[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (double[]) value); [EOL]             } [EOL]         } else if (value instanceof float[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (float[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (float[]) value); [EOL]             } [EOL]         } else if (value instanceof boolean[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (boolean[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (boolean[]) value); [EOL]             } [EOL]         } else if (value.getClass().isArray()) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (Object[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (Object[]) value); [EOL]             } [EOL]         } else { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, value); [EOL]             } [EOL]         } [EOL]     } finally { [EOL]         unregister(value); [EOL]     } [EOL] } <line_num>: 470
protected void appendCyclicObject(final StringBuffer buffer, final String fieldName, final Object value) { [EOL]     ObjectUtils.identityToString(buffer, value); [EOL] } <line_num>: 581
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 594
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Collection<?> coll) { [EOL]     buffer.append(coll); [EOL] } <line_num>: 606
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Map<?, ?> map) { [EOL]     buffer.append(map); [EOL] } <line_num>: 618
protected void appendSummary(final StringBuffer buffer, final String fieldName, final Object value) { [EOL]     buffer.append(summaryObjectStartText); [EOL]     buffer.append(getShortClassName(value.getClass())); [EOL]     buffer.append(summaryObjectEndText); [EOL] } <line_num>: 631
public void append(final StringBuffer buffer, final String fieldName, final long value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 647
protected void appendDetail(final StringBuffer buffer, final String fieldName, final long value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 661
public void append(final StringBuffer buffer, final String fieldName, final int value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 675
protected void appendDetail(final StringBuffer buffer, final String fieldName, final int value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 689
public void append(final StringBuffer buffer, final String fieldName, final short value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 703
protected void appendDetail(final StringBuffer buffer, final String fieldName, final short value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 717
public void append(final StringBuffer buffer, final String fieldName, final byte value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 731
protected void appendDetail(final StringBuffer buffer, final String fieldName, final byte value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 745
public void append(final StringBuffer buffer, final String fieldName, final char value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 759
protected void appendDetail(final StringBuffer buffer, final String fieldName, final char value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 773
public void append(final StringBuffer buffer, final String fieldName, final double value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 787
protected void appendDetail(final StringBuffer buffer, final String fieldName, final double value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 801
public void append(final StringBuffer buffer, final String fieldName, final float value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 815
protected void appendDetail(final StringBuffer buffer, final String fieldName, final float value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 829
public void append(final StringBuffer buffer, final String fieldName, final boolean value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 843
protected void appendDetail(final StringBuffer buffer, final String fieldName, final boolean value) { [EOL]     buffer.append(value); [EOL] } <line_num>: 857
public void append(final StringBuffer buffer, final String fieldName, final Object[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 871
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         final Object item = array[i]; [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         if (item == null) { [EOL]             appendNullText(buffer, fieldName); [EOL]         } else { [EOL]             appendInternal(buffer, fieldName, item, arrayContentDetail); [EOL]         } [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 898
protected void reflectionAppendArrayDetail(final StringBuffer buffer, final String fieldName, final Object array) { [EOL]     buffer.append(arrayStart); [EOL]     final int length = Array.getLength(array); [EOL]     for (int i = 0; i < length; i++) { [EOL]         final Object item = Array.get(array, i); [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         if (item == null) { [EOL]             appendNullText(buffer, fieldName); [EOL]         } else { [EOL]             appendInternal(buffer, fieldName, item, arrayContentDetail); [EOL]         } [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 924
protected void appendSummary(final StringBuffer buffer, final String fieldName, final Object[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 951
public void append(final StringBuffer buffer, final String fieldName, final long[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 967
protected void appendDetail(final StringBuffer buffer, final String fieldName, final long[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 992
protected void appendSummary(final StringBuffer buffer, final String fieldName, final long[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1012
public void append(final StringBuffer buffer, final String fieldName, final int[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 1028
protected void appendDetail(final StringBuffer buffer, final String fieldName, final int[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 1053
protected void appendSummary(final StringBuffer buffer, final String fieldName, final int[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1073
public void append(final StringBuffer buffer, final String fieldName, final short[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 1089
protected void appendDetail(final StringBuffer buffer, final String fieldName, final short[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 1114
protected void appendSummary(final StringBuffer buffer, final String fieldName, final short[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1134
public void append(final StringBuffer buffer, final String fieldName, final byte[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 1150
protected void appendDetail(final StringBuffer buffer, final String fieldName, final byte[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 1175
protected void appendSummary(final StringBuffer buffer, final String fieldName, final byte[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1195
public void append(final StringBuffer buffer, final String fieldName, final char[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 1211
protected void appendDetail(final StringBuffer buffer, final String fieldName, final char[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 1236
protected void appendSummary(final StringBuffer buffer, final String fieldName, final char[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1256
public void append(final StringBuffer buffer, final String fieldName, final double[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 1272
protected void appendDetail(final StringBuffer buffer, final String fieldName, final double[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 1297
protected void appendSummary(final StringBuffer buffer, final String fieldName, final double[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1317
public void append(final StringBuffer buffer, final String fieldName, final float[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 1333
protected void appendDetail(final StringBuffer buffer, final String fieldName, final float[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 1358
protected void appendSummary(final StringBuffer buffer, final String fieldName, final float[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1378
public void append(final StringBuffer buffer, final String fieldName, final boolean[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] } <line_num>: 1394
protected void appendDetail(final StringBuffer buffer, final String fieldName, final boolean[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] } <line_num>: 1419
protected void appendSummary(final StringBuffer buffer, final String fieldName, final boolean[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] } <line_num>: 1439
protected void appendClassName(final StringBuffer buffer, final Object object) { [EOL]     if (useClassName && object != null) { [EOL]         register(object); [EOL]         if (useShortClassName) { [EOL]             buffer.append(getShortClassName(object.getClass())); [EOL]         } else { [EOL]             buffer.append(object.getClass().getName()); [EOL]         } [EOL]     } [EOL] } <line_num>: 1451
protected void appendIdentityHashCode(final StringBuffer buffer, final Object object) { [EOL]     if (this.isUseIdentityHashCode() && object != null) { [EOL]         register(object); [EOL]         buffer.append('@'); [EOL]         buffer.append(Integer.toHexString(System.identityHashCode(object))); [EOL]     } [EOL] } <line_num>: 1468
protected void appendContentStart(final StringBuffer buffer) { [EOL]     buffer.append(contentStart); [EOL] } <line_num>: 1481
protected void appendContentEnd(final StringBuffer buffer) { [EOL]     buffer.append(contentEnd); [EOL] } <line_num>: 1490
protected void appendNullText(final StringBuffer buffer, final String fieldName) { [EOL]     buffer.append(nullText); [EOL] } <line_num>: 1502
protected void appendFieldSeparator(final StringBuffer buffer) { [EOL]     buffer.append(fieldSeparator); [EOL] } <line_num>: 1511
protected void appendFieldStart(final StringBuffer buffer, final String fieldName) { [EOL]     if (useFieldNames && fieldName != null) { [EOL]         buffer.append(fieldName); [EOL]         buffer.append(fieldNameValueSeparator); [EOL]     } [EOL] } <line_num>: 1521
protected void appendFieldEnd(final StringBuffer buffer, final String fieldName) { [EOL]     appendFieldSeparator(buffer); [EOL] } <line_num>: 1534
protected void appendSummarySize(final StringBuffer buffer, final String fieldName, final int size) { [EOL]     buffer.append(sizeStartText); [EOL]     buffer.append(size); [EOL]     buffer.append(sizeEndText); [EOL] } <line_num>: 1553
protected boolean isFullDetail(final Boolean fullDetailRequest) { [EOL]     if (fullDetailRequest == null) { [EOL]         return defaultFullDetail; [EOL]     } [EOL]     return fullDetailRequest.booleanValue(); [EOL] } <line_num>: 1573
protected String getShortClassName(final Class<?> cls) { [EOL]     return ClassUtils.getShortClassName(cls); [EOL] } <line_num>: 1589
protected boolean isUseClassName() { [EOL]     return useClassName; [EOL] } <line_num>: 1603
protected void setUseClassName(final boolean useClassName) { [EOL]     this.useClassName = useClassName; [EOL] } <line_num>: 1612
protected boolean isUseShortClassName() { [EOL]     return useShortClassName; [EOL] } <line_num>: 1624
protected void setUseShortClassName(final boolean useShortClassName) { [EOL]     this.useShortClassName = useShortClassName; [EOL] } <line_num>: 1634
protected boolean isUseIdentityHashCode() { [EOL]     return useIdentityHashCode; [EOL] } <line_num>: 1645
protected void setUseIdentityHashCode(final boolean useIdentityHashCode) { [EOL]     this.useIdentityHashCode = useIdentityHashCode; [EOL] } <line_num>: 1654
protected boolean isUseFieldNames() { [EOL]     return useFieldNames; [EOL] } <line_num>: 1665
protected void setUseFieldNames(final boolean useFieldNames) { [EOL]     this.useFieldNames = useFieldNames; [EOL] } <line_num>: 1674
protected boolean isDefaultFullDetail() { [EOL]     return defaultFullDetail; [EOL] } <line_num>: 1686
protected void setDefaultFullDetail(final boolean defaultFullDetail) { [EOL]     this.defaultFullDetail = defaultFullDetail; [EOL] } <line_num>: 1696
protected boolean isArrayContentDetail() { [EOL]     return arrayContentDetail; [EOL] } <line_num>: 1707
protected void setArrayContentDetail(final boolean arrayContentDetail) { [EOL]     this.arrayContentDetail = arrayContentDetail; [EOL] } <line_num>: 1716
protected String getArrayStart() { [EOL]     return arrayStart; [EOL] } <line_num>: 1727
protected void setArrayStart(String arrayStart) { [EOL]     if (arrayStart == null) { [EOL]         arrayStart = ""; [EOL]     } [EOL]     this.arrayStart = arrayStart; [EOL] } <line_num>: 1739
protected String getArrayEnd() { [EOL]     return arrayEnd; [EOL] } <line_num>: 1753
protected void setArrayEnd(String arrayEnd) { [EOL]     if (arrayEnd == null) { [EOL]         arrayEnd = ""; [EOL]     } [EOL]     this.arrayEnd = arrayEnd; [EOL] } <line_num>: 1765
protected String getArraySeparator() { [EOL]     return arraySeparator; [EOL] } <line_num>: 1779
protected void setArraySeparator(String arraySeparator) { [EOL]     if (arraySeparator == null) { [EOL]         arraySeparator = ""; [EOL]     } [EOL]     this.arraySeparator = arraySeparator; [EOL] } <line_num>: 1791
protected String getContentStart() { [EOL]     return contentStart; [EOL] } <line_num>: 1805
protected void setContentStart(String contentStart) { [EOL]     if (contentStart == null) { [EOL]         contentStart = ""; [EOL]     } [EOL]     this.contentStart = contentStart; [EOL] } <line_num>: 1817
protected String getContentEnd() { [EOL]     return contentEnd; [EOL] } <line_num>: 1831
protected void setContentEnd(String contentEnd) { [EOL]     if (contentEnd == null) { [EOL]         contentEnd = ""; [EOL]     } [EOL]     this.contentEnd = contentEnd; [EOL] } <line_num>: 1843
protected String getFieldNameValueSeparator() { [EOL]     return fieldNameValueSeparator; [EOL] } <line_num>: 1857
protected void setFieldNameValueSeparator(String fieldNameValueSeparator) { [EOL]     if (fieldNameValueSeparator == null) { [EOL]         fieldNameValueSeparator = ""; [EOL]     } [EOL]     this.fieldNameValueSeparator = fieldNameValueSeparator; [EOL] } <line_num>: 1869
protected String getFieldSeparator() { [EOL]     return fieldSeparator; [EOL] } <line_num>: 1883
protected void setFieldSeparator(String fieldSeparator) { [EOL]     if (fieldSeparator == null) { [EOL]         fieldSeparator = ""; [EOL]     } [EOL]     this.fieldSeparator = fieldSeparator; [EOL] } <line_num>: 1895
protected boolean isFieldSeparatorAtStart() { [EOL]     return fieldSeparatorAtStart; [EOL] } <line_num>: 1911
protected void setFieldSeparatorAtStart(final boolean fieldSeparatorAtStart) { [EOL]     this.fieldSeparatorAtStart = fieldSeparatorAtStart; [EOL] } <line_num>: 1922
protected boolean isFieldSeparatorAtEnd() { [EOL]     return fieldSeparatorAtEnd; [EOL] } <line_num>: 1935
protected void setFieldSeparatorAtEnd(final boolean fieldSeparatorAtEnd) { [EOL]     this.fieldSeparatorAtEnd = fieldSeparatorAtEnd; [EOL] } <line_num>: 1946
protected String getNullText() { [EOL]     return nullText; [EOL] } <line_num>: 1957
protected void setNullText(String nullText) { [EOL]     if (nullText == null) { [EOL]         nullText = ""; [EOL]     } [EOL]     this.nullText = nullText; [EOL] } <line_num>: 1969
protected String getSizeStartText() { [EOL]     return sizeStartText; [EOL] } <line_num>: 1986
protected void setSizeStartText(String sizeStartText) { [EOL]     if (sizeStartText == null) { [EOL]         sizeStartText = ""; [EOL]     } [EOL]     this.sizeStartText = sizeStartText; [EOL] } <line_num>: 2001
protected String getSizeEndText() { [EOL]     return sizeEndText; [EOL] } <line_num>: 2018
protected void setSizeEndText(String sizeEndText) { [EOL]     if (sizeEndText == null) { [EOL]         sizeEndText = ""; [EOL]     } [EOL]     this.sizeEndText = sizeEndText; [EOL] } <line_num>: 2033
protected String getSummaryObjectStartText() { [EOL]     return summaryObjectStartText; [EOL] } <line_num>: 2050
protected void setSummaryObjectStartText(String summaryObjectStartText) { [EOL]     if (summaryObjectStartText == null) { [EOL]         summaryObjectStartText = ""; [EOL]     } [EOL]     this.summaryObjectStartText = summaryObjectStartText; [EOL] } <line_num>: 2065
protected String getSummaryObjectEndText() { [EOL]     return summaryObjectEndText; [EOL] } <line_num>: 2082
protected void setSummaryObjectEndText(String summaryObjectEndText) { [EOL]     if (summaryObjectEndText == null) { [EOL]         summaryObjectEndText = ""; [EOL]     } [EOL]     this.summaryObjectEndText = summaryObjectEndText; [EOL] } <line_num>: 2097
private Object readResolve() { [EOL]     return ToStringStyle.DEFAULT_STYLE; [EOL] } <line_num>: 2135
private Object readResolve() { [EOL]     return ToStringStyle.NO_FIELD_NAMES_STYLE; [EOL] } <line_num>: 2169
private Object readResolve() { [EOL]     return ToStringStyle.SHORT_PREFIX_STYLE; [EOL] } <line_num>: 2203
private Object readResolve() { [EOL]     return ToStringStyle.SIMPLE_STYLE; [EOL] } <line_num>: 2238
private Object readResolve() { [EOL]     return ToStringStyle.MULTI_LINE_STYLE; [EOL] } <line_num>: 2274