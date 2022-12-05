private FieldUtils() { [EOL]     super(); [EOL] } <line_num>: 35,37
public static int safeNegate(int value) { [EOL]     if (value == Integer.MIN_VALUE) { [EOL]         throw new ArithmeticException("Integer.MIN_VALUE cannot be negated"); [EOL]     } [EOL]     return -value; [EOL] } <line_num>: 48,53
public static int safeAdd(int val1, int val2) { [EOL]     int sum = val1 + val2; [EOL]     if ((val1 ^ sum) < 0 && (val1 ^ val2) >= 0) { [EOL]         throw new ArithmeticException("The calculation caused an overflow: " + val1 + " + " + val2); [EOL]     } [EOL]     return sum; [EOL] } <line_num>: 63,71
public static long safeAdd(long val1, long val2) { [EOL]     long sum = val1 + val2; [EOL]     if ((val1 ^ sum) < 0 && (val1 ^ val2) >= 0) { [EOL]         throw new ArithmeticException("The calculation caused an overflow: " + val1 + " + " + val2); [EOL]     } [EOL]     return sum; [EOL] } <line_num>: 81,89
public static long safeSubtract(long val1, long val2) { [EOL]     long diff = val1 - val2; [EOL]     if ((val1 ^ diff) < 0 && (val1 ^ val2) < 0) { [EOL]         throw new ArithmeticException("The calculation caused an overflow: " + val1 + " - " + val2); [EOL]     } [EOL]     return diff; [EOL] } <line_num>: 99,107
public static int safeMultiply(int val1, int val2) { [EOL]     long total = (long) val1 * (long) val2; [EOL]     if (total < Integer.MIN_VALUE || total > Integer.MAX_VALUE) { [EOL]         throw new ArithmeticException("Multiplication overflows an int: " + val1 + " * " + val2); [EOL]     } [EOL]     return (int) total; [EOL] } <line_num>: 118,124
public static long safeMultiply(long val1, int val2) { [EOL]     switch(val2) { [EOL]         case -1: [EOL]             if (val1 == Long.MIN_VALUE) { [EOL]                 throw new ArithmeticException("Multiplication overflows a long: " + val1 + " * " + val2); [EOL]             } [EOL]             return -val1; [EOL]         case 0: [EOL]             return 0L; [EOL]         case 1: [EOL]             return val1; [EOL]     } [EOL]     long total = val1 * val2; [EOL]     if (total / val2 != val1) { [EOL]         throw new ArithmeticException("Multiplication overflows a long: " + val1 + " * " + val2); [EOL]     } [EOL]     return total; [EOL] } <line_num>: 135,152
public static long safeMultiply(long val1, long val2) { [EOL]     if (val2 == 1) { [EOL]         return val1; [EOL]     } [EOL]     if (val1 == 1) { [EOL]         return val2; [EOL]     } [EOL]     if (val1 == 0 || val2 == 0) { [EOL]         return 0; [EOL]     } [EOL]     long total = val1 * val2; [EOL]     if (total / val2 != val1 || val1 == Long.MIN_VALUE && val2 == -1 || val2 == Long.MIN_VALUE && val1 == -1) { [EOL]         throw new ArithmeticException("Multiplication overflows a long: " + val1 + " * " + val2); [EOL]     } [EOL]     return total; [EOL] } <line_num>: 162,177
public static long safeDivide(long dividend, long divisor) { [EOL]     if (dividend == Long.MIN_VALUE && divisor == -1L) { [EOL]         throw new ArithmeticException("Multiplication overflows a long: " + dividend + " / " + divisor); [EOL]     } [EOL]     return dividend / divisor; [EOL] } <line_num>: 188,193
public static int safeToInt(long value) { [EOL]     if (Integer.MIN_VALUE <= value && value <= Integer.MAX_VALUE) { [EOL]         return (int) value; [EOL]     } [EOL]     throw new ArithmeticException("Value cannot fit in an int: " + value); [EOL] } <line_num>: 202,207
public static int safeMultiplyToInt(long val1, long val2) { [EOL]     long val = FieldUtils.safeMultiply(val1, val2); [EOL]     return FieldUtils.safeToInt(val); [EOL] } <line_num>: 217,220
public static void verifyValueBounds(DateTimeField field, int value, int lowerBound, int upperBound) { [EOL]     if ((value < lowerBound) || (value > upperBound)) { [EOL]         throw new IllegalFieldValueException(field.getType(), Integer.valueOf(value), Integer.valueOf(lowerBound), Integer.valueOf(upperBound)); [EOL]     } [EOL] } <line_num>: 231,238
public static void verifyValueBounds(DateTimeFieldType fieldType, int value, int lowerBound, int upperBound) { [EOL]     if ((value < lowerBound) || (value > upperBound)) { [EOL]         throw new IllegalFieldValueException(fieldType, Integer.valueOf(value), Integer.valueOf(lowerBound), Integer.valueOf(upperBound)); [EOL]     } [EOL] } <line_num>: 249,256
public static void verifyValueBounds(String fieldName, int value, int lowerBound, int upperBound) { [EOL]     if ((value < lowerBound) || (value > upperBound)) { [EOL]         throw new IllegalFieldValueException(fieldName, Integer.valueOf(value), Integer.valueOf(lowerBound), Integer.valueOf(upperBound)); [EOL]     } [EOL] } <line_num>: 266,273
public static int getWrappedValue(int currentValue, int wrapValue, int minValue, int maxValue) { [EOL]     return getWrappedValue(currentValue + wrapValue, minValue, maxValue); [EOL] } <line_num>: 290,293
public static int getWrappedValue(int value, int minValue, int maxValue) { [EOL]     if (minValue >= maxValue) { [EOL]         throw new IllegalArgumentException("MIN > MAX"); [EOL]     } [EOL]     int wrapRange = maxValue - minValue + 1; [EOL]     value -= minValue; [EOL]     if (value >= 0) { [EOL]         return (value % wrapRange) + minValue; [EOL]     } [EOL]     int remByRange = (-value) % wrapRange; [EOL]     if (remByRange == 0) { [EOL]         return 0 + minValue; [EOL]     } [EOL]     return (wrapRange - remByRange) + minValue; [EOL] } <line_num>: 307,325
public static boolean equals(Object object1, Object object2) { [EOL]     if (object1 == object2) { [EOL]         return true; [EOL]     } [EOL]     if (object1 == null || object2 == null) { [EOL]         return false; [EOL]     } [EOL]     return object1.equals(object2); [EOL] } <line_num>: 336,344
