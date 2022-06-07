public static ToStringStyle getDefaultStyle() { [EOL]     return defaultStyle; [EOL] } <line_num>: 116
public static void setDefaultStyle(final ToStringStyle style) { [EOL]     if (style == null) { [EOL]         throw new IllegalArgumentException("The style must not be null"); [EOL]     } [EOL]     defaultStyle = style; [EOL] } <line_num>: 135
public static String reflectionToString(final Object object) { [EOL]     return ReflectionToStringBuilder.toString(object); [EOL] } <line_num>: 151
public static String reflectionToString(final Object object, final ToStringStyle style) { [EOL]     return ReflectionToStringBuilder.toString(object, style); [EOL] } <line_num>: 164
public static String reflectionToString(final Object object, final ToStringStyle style, final boolean outputTransients) { [EOL]     return ReflectionToStringBuilder.toString(object, style, outputTransients, false, null); [EOL] } <line_num>: 178
public static <T> String reflectionToString(final T object, final ToStringStyle style, final boolean outputTransients, final Class<? super T> reflectUpToClass) { [EOL]     return ReflectionToStringBuilder.toString(object, style, outputTransients, false, reflectUpToClass); [EOL] } <line_num>: 195
public ToStringBuilder append(final boolean value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 275
public ToStringBuilder append(final boolean[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 289
public ToStringBuilder append(final byte value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 303
public ToStringBuilder append(final byte[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 317
public ToStringBuilder append(final char value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 331
public ToStringBuilder append(final char[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 345
public ToStringBuilder append(final double value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 359
public ToStringBuilder append(final double[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 373
public ToStringBuilder append(final float value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 387
public ToStringBuilder append(final float[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 401
public ToStringBuilder append(final int value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 415
public ToStringBuilder append(final int[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 429
public ToStringBuilder append(final long value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 443
public ToStringBuilder append(final long[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 457
public ToStringBuilder append(final Object obj) { [EOL]     style.append(buffer, null, obj, null); [EOL]     return this; [EOL] } <line_num>: 471
public ToStringBuilder append(final Object[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 485
public ToStringBuilder append(final short value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] } <line_num>: 499
public ToStringBuilder append(final short[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] } <line_num>: 513
public ToStringBuilder append(final String fieldName, final boolean value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 526
public ToStringBuilder append(final String fieldName, final boolean[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 539
public ToStringBuilder append(final String fieldName, final boolean[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 559
public ToStringBuilder append(final String fieldName, final byte value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 572
public ToStringBuilder append(final String fieldName, final byte[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 584
public ToStringBuilder append(final String fieldName, final byte[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 604
public ToStringBuilder append(final String fieldName, final char value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 617
public ToStringBuilder append(final String fieldName, final char[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 630
public ToStringBuilder append(final String fieldName, final char[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 650
public ToStringBuilder append(final String fieldName, final double value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 663
public ToStringBuilder append(final String fieldName, final double[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 676
public ToStringBuilder append(final String fieldName, final double[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 696
public ToStringBuilder append(final String fieldName, final float value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 709
public ToStringBuilder append(final String fieldName, final float[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 722
public ToStringBuilder append(final String fieldName, final float[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 742
public ToStringBuilder append(final String fieldName, final int value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 755
public ToStringBuilder append(final String fieldName, final int[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 768
public ToStringBuilder append(final String fieldName, final int[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 788
public ToStringBuilder append(final String fieldName, final long value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 801
public ToStringBuilder append(final String fieldName, final long[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 814
public ToStringBuilder append(final String fieldName, final long[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 834
public ToStringBuilder append(final String fieldName, final Object obj) { [EOL]     style.append(buffer, fieldName, obj, null); [EOL]     return this; [EOL] } <line_num>: 847
public ToStringBuilder append(final String fieldName, final Object obj, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, obj, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 862
public ToStringBuilder append(final String fieldName, final Object[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 875
public ToStringBuilder append(final String fieldName, final Object[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 895
public ToStringBuilder append(final String fieldName, final short value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] } <line_num>: 908
public ToStringBuilder append(final String fieldName, final short[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] } <line_num>: 921
public ToStringBuilder append(final String fieldName, final short[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] } <line_num>: 941
public ToStringBuilder appendAsObjectToString(final Object object) { [EOL]     ObjectUtils.identityToString(this.getStringBuffer(), object); [EOL]     return this; [EOL] } <line_num>: 955
public ToStringBuilder appendSuper(final String superToString) { [EOL]     if (superToString != null) { [EOL]         style.appendSuper(buffer, superToString); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 974
public ToStringBuilder appendToString(final String toString) { [EOL]     if (toString != null) { [EOL]         style.appendToString(buffer, toString); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 1008
public Object getObject() { [EOL]     return object; [EOL] } <line_num>: 1021
public StringBuffer getStringBuffer() { [EOL]     return buffer; [EOL] } <line_num>: 1030
public ToStringStyle getStyle() { [EOL]     return style; [EOL] } <line_num>: 1042
@Override [EOL] public String toString() { [EOL]     if (this.getObject() == null) { [EOL]         this.getStringBuffer().append(this.getStyle().getNullText()); [EOL]     } else { [EOL]         style.appendEnd(this.getStringBuffer(), this.getObject()); [EOL]     } [EOL]     return this.getStringBuffer().toString(); [EOL] } <line_num>: 1057
@Override [EOL] public String build() { [EOL]     return toString(); [EOL] } <line_num>: 1077
