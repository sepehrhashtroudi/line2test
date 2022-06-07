public static Fraction getFraction(int numerator, int denominator) { [EOL]     if (denominator == 0) { [EOL]         throw new ArithmeticException("The denominator must not be zero"); [EOL]     } [EOL]     if (denominator < 0) { [EOL]         if (numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE) { [EOL]             throw new ArithmeticException("overflow: can't negate"); [EOL]         } [EOL]         numerator = -numerator; [EOL]         denominator = -denominator; [EOL]     } [EOL]     return new Fraction(numerator, denominator); [EOL] } <line_num>: 141
public static Fraction getFraction(final int whole, final int numerator, final int denominator) { [EOL]     if (denominator == 0) { [EOL]         throw new ArithmeticException("The denominator must not be zero"); [EOL]     } [EOL]     if (denominator < 0) { [EOL]         throw new ArithmeticException("The denominator must not be negative"); [EOL]     } [EOL]     if (numerator < 0) { [EOL]         throw new ArithmeticException("The numerator must not be negative"); [EOL]     } [EOL]     long numeratorValue; [EOL]     if (whole < 0) { [EOL]         numeratorValue = whole * (long) denominator - numerator; [EOL]     } else { [EOL]         numeratorValue = whole * (long) denominator + numerator; [EOL]     } [EOL]     if (numeratorValue < Integer.MIN_VALUE || numeratorValue > Integer.MAX_VALUE) { [EOL]         throw new ArithmeticException("Numerator too large to represent as an Integer."); [EOL]     } [EOL]     return new Fraction((int) numeratorValue, denominator); [EOL] } <line_num>: 172
public static Fraction getReducedFraction(int numerator, int denominator) { [EOL]     if (denominator == 0) { [EOL]         throw new ArithmeticException("The denominator must not be zero"); [EOL]     } [EOL]     if (numerator == 0) { [EOL]         return ZERO; [EOL]     } [EOL]     if (denominator == Integer.MIN_VALUE && (numerator & 1) == 0) { [EOL]         numerator /= 2; [EOL]         denominator /= 2; [EOL]     } [EOL]     if (denominator < 0) { [EOL]         if (numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE) { [EOL]             throw new ArithmeticException("overflow: can't negate"); [EOL]         } [EOL]         numerator = -numerator; [EOL]         denominator = -denominator; [EOL]     } [EOL]     final int gcd = greatestCommonDivisor(numerator, denominator); [EOL]     numerator /= gcd; [EOL]     denominator /= gcd; [EOL]     return new Fraction(numerator, denominator); [EOL] } <line_num>: 209
public static Fraction getFraction(double value) { [EOL]     final int sign = value < 0 ? -1 : 1; [EOL]     value = Math.abs(value); [EOL]     if (value > Integer.MAX_VALUE || Double.isNaN(value)) { [EOL]         throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN"); [EOL]     } [EOL]     final int wholeNumber = (int) value; [EOL]     value -= wholeNumber; [EOL]     int numer0 = 0; [EOL]     int denom0 = 1; [EOL]     int numer1 = 1; [EOL]     int denom1 = 0; [EOL]     int numer2 = 0; [EOL]     int denom2 = 0; [EOL]     int a1 = (int) value; [EOL]     int a2 = 0; [EOL]     double x1 = 1; [EOL]     double x2 = 0; [EOL]     double y1 = value - a1; [EOL]     double y2 = 0; [EOL]     double delta1, delta2 = Double.MAX_VALUE; [EOL]     double fraction; [EOL]     int i = 1; [EOL]     do { [EOL]         delta1 = delta2; [EOL]         a2 = (int) (x1 / y1); [EOL]         x2 = y1; [EOL]         y2 = x1 - a2 * y1; [EOL]         numer2 = a1 * numer1 + numer0; [EOL]         denom2 = a1 * denom1 + denom0; [EOL]         fraction = (double) numer2 / (double) denom2; [EOL]         delta2 = Math.abs(value - fraction); [EOL]         a1 = a2; [EOL]         x1 = x2; [EOL]         y1 = y2; [EOL]         numer0 = numer1; [EOL]         denom0 = denom1; [EOL]         numer1 = numer2; [EOL]         denom1 = denom2; [EOL]         i++; [EOL]     } while (delta1 > delta2 && denom2 <= 10000 && denom2 > 0 && i < 25); [EOL]     if (i == 25) { [EOL]         throw new ArithmeticException("Unable to convert double to fraction"); [EOL]     } [EOL]     return getReducedFraction((numer0 + wholeNumber * denom0) * sign, denom0); [EOL] } <line_num>: 249
public static Fraction getFraction(String str) { [EOL]     if (str == null) { [EOL]         throw new IllegalArgumentException("The string must not be null"); [EOL]     } [EOL]     int pos = str.indexOf('.'); [EOL]     if (pos >= 0) { [EOL]         return getFraction(Double.parseDouble(str)); [EOL]     } [EOL]     pos = str.indexOf(' '); [EOL]     if (pos > 0) { [EOL]         final int whole = Integer.parseInt(str.substring(0, pos)); [EOL]         str = str.substring(pos + 1); [EOL]         pos = str.indexOf('/'); [EOL]         if (pos < 0) { [EOL]             throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z"); [EOL]         } else { [EOL]             final int numer = Integer.parseInt(str.substring(0, pos)); [EOL]             final int denom = Integer.parseInt(str.substring(pos + 1)); [EOL]             return getFraction(whole, numer, denom); [EOL]         } [EOL]     } [EOL]     pos = str.indexOf('/'); [EOL]     if (pos < 0) { [EOL]         return getFraction(Integer.parseInt(str), 1); [EOL]     } else { [EOL]         final int numer = Integer.parseInt(str.substring(0, pos)); [EOL]         final int denom = Integer.parseInt(str.substring(pos + 1)); [EOL]         return getFraction(numer, denom); [EOL]     } [EOL] } <line_num>: 319
public int getNumerator() { [EOL]     return numerator; [EOL] } <line_num>: 367
public int getDenominator() { [EOL]     return denominator; [EOL] } <line_num>: 376
public int getProperNumerator() { [EOL]     return Math.abs(numerator % denominator); [EOL] } <line_num>: 391
public int getProperWhole() { [EOL]     return numerator / denominator; [EOL] } <line_num>: 406
@Override [EOL] public int intValue() { [EOL]     return numerator / denominator; [EOL] } <line_num>: 420
@Override [EOL] public long longValue() { [EOL]     return (long) numerator / denominator; [EOL] } <line_num>: 431
@Override [EOL] public float floatValue() { [EOL]     return (float) numerator / (float) denominator; [EOL] } <line_num>: 442
@Override [EOL] public double doubleValue() { [EOL]     return (double) numerator / (double) denominator; [EOL] } <line_num>: 453
public Fraction reduce() { [EOL]     if (numerator == 0) { [EOL]         return equals(ZERO) ? this : ZERO; [EOL]     } [EOL]     final int gcd = greatestCommonDivisor(Math.abs(numerator), denominator); [EOL]     if (gcd == 1) { [EOL]         return this; [EOL]     } [EOL]     return Fraction.getFraction(numerator / gcd, denominator / gcd); [EOL] } <line_num>: 469
public Fraction invert() { [EOL]     if (numerator == 0) { [EOL]         throw new ArithmeticException("Unable to invert zero."); [EOL]     } [EOL]     if (numerator == Integer.MIN_VALUE) { [EOL]         throw new ArithmeticException("overflow: can't negate numerator"); [EOL]     } [EOL]     if (numerator < 0) { [EOL]         return new Fraction(-denominator, -numerator); [EOL]     } else { [EOL]         return new Fraction(denominator, numerator); [EOL]     } [EOL] } <line_num>: 489
public Fraction negate() { [EOL]     if (numerator == Integer.MIN_VALUE) { [EOL]         throw new ArithmeticException("overflow: too large to negate"); [EOL]     } [EOL]     return new Fraction(-numerator, denominator); [EOL] } <line_num>: 510
public Fraction abs() { [EOL]     if (numerator >= 0) { [EOL]         return this; [EOL]     } [EOL]     return negate(); [EOL] } <line_num>: 527
public Fraction pow(final int power) { [EOL]     if (power == 1) { [EOL]         return this; [EOL]     } else if (power == 0) { [EOL]         return ONE; [EOL]     } else if (power < 0) { [EOL]         if (power == Integer.MIN_VALUE) { [EOL]             return this.invert().pow(2).pow(-(power / 2)); [EOL]         } [EOL]         return this.invert().pow(-power); [EOL]     } else { [EOL]         final Fraction f = this.multiplyBy(this); [EOL]         if (power % 2 == 0) { [EOL]             return f.pow(power / 2); [EOL]         } else { [EOL]             return f.pow(power / 2).multiplyBy(this); [EOL]         } [EOL]     } [EOL] } <line_num>: 546
private static int greatestCommonDivisor(int u, int v) { [EOL]     if (u == 0 || v == 0) { [EOL]         if (u == Integer.MIN_VALUE || v == Integer.MIN_VALUE) { [EOL]             throw new ArithmeticException("overflow: gcd is 2^31"); [EOL]         } [EOL]         return Math.abs(u) + Math.abs(v); [EOL]     } [EOL]     if (Math.abs(u) == 1 || Math.abs(v) == 1) { [EOL]         return 1; [EOL]     } [EOL]     if (u > 0) { [EOL]         u = -u; [EOL]     } [EOL]     if (v > 0) { [EOL]         v = -v; [EOL]     } [EOL]     int k = 0; [EOL]     while ((u & 1) == 0 && (v & 1) == 0 && k < 31) { [EOL]         u /= 2; [EOL]         v /= 2; [EOL]         k++; [EOL]     } [EOL]     if (k == 31) { [EOL]         throw new ArithmeticException("overflow: gcd is 2^31"); [EOL]     } [EOL]     int t = (u & 1) == 1 ? v : -(u / 2); [EOL]     do { [EOL]         while ((t & 1) == 0) { [EOL]             t /= 2; [EOL]         } [EOL]         if (t > 0) { [EOL]             u = -t; [EOL]         } else { [EOL]             v = t; [EOL]         } [EOL]         t = (v - u) / 2; [EOL]     } while (t != 0); [EOL]     return -u * (1 << k); [EOL] } <line_num>: 576
private static int mulAndCheck(final int x, final int y) { [EOL]     final long m = (long) x * (long) y; [EOL]     if (m < Integer.MIN_VALUE || m > Integer.MAX_VALUE) { [EOL]         throw new ArithmeticException("overflow: mul"); [EOL]     } [EOL]     return (int) m; [EOL] } <line_num>: 639
private static int mulPosAndCheck(final int x, final int y) { [EOL]     final long m = (long) x * (long) y; [EOL]     if (m > Integer.MAX_VALUE) { [EOL]         throw new ArithmeticException("overflow: mulPos"); [EOL]     } [EOL]     return (int) m; [EOL] } <line_num>: 657
private static int addAndCheck(final int x, final int y) { [EOL]     final long s = (long) x + (long) y; [EOL]     if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) { [EOL]         throw new ArithmeticException("overflow: add"); [EOL]     } [EOL]     return (int) s; [EOL] } <line_num>: 675
private static int subAndCheck(final int x, final int y) { [EOL]     final long s = (long) x - (long) y; [EOL]     if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) { [EOL]         throw new ArithmeticException("overflow: add"); [EOL]     } [EOL]     return (int) s; [EOL] } <line_num>: 693
public Fraction add(final Fraction fraction) { [EOL]     return addSub(fraction, true); [EOL] } <line_num>: 712
public Fraction subtract(final Fraction fraction) { [EOL]     return addSub(fraction, false); [EOL] } <line_num>: 726
private Fraction addSub(final Fraction fraction, final boolean isAdd) { [EOL]     if (fraction == null) { [EOL]         throw new IllegalArgumentException("The fraction must not be null"); [EOL]     } [EOL]     if (numerator == 0) { [EOL]         return isAdd ? fraction : fraction.negate(); [EOL]     } [EOL]     if (fraction.numerator == 0) { [EOL]         return this; [EOL]     } [EOL]     final int d1 = greatestCommonDivisor(denominator, fraction.denominator); [EOL]     if (d1 == 1) { [EOL]         final int uvp = mulAndCheck(numerator, fraction.denominator); [EOL]         final int upv = mulAndCheck(fraction.numerator, denominator); [EOL]         return new Fraction(isAdd ? addAndCheck(uvp, upv) : subAndCheck(uvp, upv), mulPosAndCheck(denominator, fraction.denominator)); [EOL]     } [EOL]     final BigInteger uvp = BigInteger.valueOf(numerator).multiply(BigInteger.valueOf(fraction.denominator / d1)); [EOL]     final BigInteger upv = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(denominator / d1)); [EOL]     final BigInteger t = isAdd ? uvp.add(upv) : uvp.subtract(upv); [EOL]     final int tmodd1 = t.mod(BigInteger.valueOf(d1)).intValue(); [EOL]     final int d2 = tmodd1 == 0 ? d1 : greatestCommonDivisor(tmodd1, d1); [EOL]     final BigInteger w = t.divide(BigInteger.valueOf(d2)); [EOL]     if (w.bitLength() > 31) { [EOL]         throw new ArithmeticException("overflow: numerator too large after multiply"); [EOL]     } [EOL]     return new Fraction(w.intValue(), mulPosAndCheck(denominator / d1, fraction.denominator / d2)); [EOL] } <line_num>: 740
public Fraction multiplyBy(final Fraction fraction) { [EOL]     if (fraction == null) { [EOL]         throw new IllegalArgumentException("The fraction must not be null"); [EOL]     } [EOL]     if (numerator == 0 || fraction.numerator == 0) { [EOL]         return ZERO; [EOL]     } [EOL]     final int d1 = greatestCommonDivisor(numerator, fraction.denominator); [EOL]     final int d2 = greatestCommonDivisor(fraction.numerator, denominator); [EOL]     return getReducedFraction(mulAndCheck(numerator / d1, fraction.numerator / d2), mulPosAndCheck(denominator / d2, fraction.denominator / d1)); [EOL] } <line_num>: 796
public Fraction divideBy(final Fraction fraction) { [EOL]     if (fraction == null) { [EOL]         throw new IllegalArgumentException("The fraction must not be null"); [EOL]     } [EOL]     if (fraction.numerator == 0) { [EOL]         throw new ArithmeticException("The fraction to divide by must not be zero"); [EOL]     } [EOL]     return multiplyBy(fraction.invert()); [EOL] } <line_num>: 822
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (obj instanceof Fraction == false) { [EOL]         return false; [EOL]     } [EOL]     final Fraction other = (Fraction) obj; [EOL]     return getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator(); [EOL] } <line_num>: 844
@Override [EOL] public int hashCode() { [EOL]     if (hashCode == 0) { [EOL]         hashCode = 37 * (37 * 17 + getNumerator()) + getDenominator(); [EOL]     } [EOL]     return hashCode; [EOL] } <line_num>: 862
@Override [EOL] public int compareTo(final Fraction other) { [EOL]     if (this == other) { [EOL]         return 0; [EOL]     } [EOL]     if (numerator == other.numerator && denominator == other.denominator) { [EOL]         return 0; [EOL]     } [EOL]     final long first = (long) numerator * (long) other.denominator; [EOL]     final long second = (long) other.numerator * (long) denominator; [EOL]     if (first == second) { [EOL]         return 0; [EOL]     } else if (first < second) { [EOL]         return -1; [EOL]     } else { [EOL]         return 1; [EOL]     } [EOL] } <line_num>: 883
@Override [EOL] public String toString() { [EOL]     if (toString == null) { [EOL]         toString = new StringBuilder(32).append(getNumerator()).append('/').append(getDenominator()).toString(); [EOL]     } [EOL]     return toString; [EOL] } <line_num>: 911
public String toProperString() { [EOL]     if (toProperString == null) { [EOL]         if (numerator == 0) { [EOL]             toProperString = "0"; [EOL]         } else if (numerator == denominator) { [EOL]             toProperString = "1"; [EOL]         } else if (numerator == -1 * denominator) { [EOL]             toProperString = "-1"; [EOL]         } else if ((numerator > 0 ? -numerator : numerator) < -denominator) { [EOL]             final int properNumerator = getProperNumerator(); [EOL]             if (properNumerator == 0) { [EOL]                 toProperString = Integer.toString(getProperWhole()); [EOL]             } else { [EOL]                 toProperString = new StringBuilder(32).append(getProperWhole()).append(' ').append(properNumerator).append('/').append(getDenominator()).toString(); [EOL]             } [EOL]         } else { [EOL]             toProperString = new StringBuilder(32).append(getNumerator()).append('/').append(getDenominator()).toString(); [EOL]         } [EOL]     } [EOL]     return toProperString; [EOL] } <line_num>: 930
