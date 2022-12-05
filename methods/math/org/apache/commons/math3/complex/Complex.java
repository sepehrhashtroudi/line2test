public Complex(double real) { [EOL]     this(real, 0.0); [EOL] } <line_num>: 88,90
public Complex(double real, double imaginary) { [EOL]     this.real = real; [EOL]     this.imaginary = imaginary; [EOL]     isNaN = Double.isNaN(real) || Double.isNaN(imaginary); [EOL]     isInfinite = !isNaN && (Double.isInfinite(real) || Double.isInfinite(imaginary)); [EOL] } <line_num>: 98,105
public double abs() { [EOL]     if (isNaN) { [EOL]         return Double.NaN; [EOL]     } [EOL]     if (isInfinite()) { [EOL]         return Double.POSITIVE_INFINITY; [EOL]     } [EOL]     if (FastMath.abs(real) < FastMath.abs(imaginary)) { [EOL]         if (imaginary == 0.0) { [EOL]             return FastMath.abs(real); [EOL]         } [EOL]         double q = real / imaginary; [EOL]         return FastMath.abs(imaginary) * FastMath.sqrt(1 + q * q); [EOL]     } else { [EOL]         if (real == 0.0) { [EOL]             return FastMath.abs(imaginary); [EOL]         } [EOL]         double q = imaginary / real; [EOL]         return FastMath.abs(real) * FastMath.sqrt(1 + q * q); [EOL]     } [EOL] } <line_num>: 115,135
public Complex add(Complex addend) throws NullArgumentException { [EOL]     MathUtils.checkNotNull(addend); [EOL]     if (isNaN || addend.isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(real + addend.getReal(), imaginary + addend.getImaginary()); [EOL] } <line_num>: 156,164
public Complex add(double addend) { [EOL]     if (isNaN || Double.isNaN(addend)) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(real + addend, imaginary); [EOL] } <line_num>: 174,180
public Complex conjugate() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(real, -imaginary); [EOL] } <line_num>: 196,202
public Complex divide(Complex divisor) throws NullArgumentException { [EOL]     MathUtils.checkNotNull(divisor); [EOL]     if (isNaN || divisor.isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     final double c = divisor.getReal(); [EOL]     final double d = divisor.getImaginary(); [EOL]     if (c == 0.0 && d == 0.0) { [EOL]         return NaN; [EOL]     } [EOL]     if (divisor.isInfinite() && !isInfinite()) { [EOL]         return ZERO; [EOL]     } [EOL]     if (FastMath.abs(c) < FastMath.abs(d)) { [EOL]         double q = c / d; [EOL]         double denominator = c * q + d; [EOL]         return createComplex((real * q + imaginary) / denominator, (imaginary * q - real) / denominator); [EOL]     } else { [EOL]         double q = d / c; [EOL]         double denominator = d * q + c; [EOL]         return createComplex((imaginary * q + real) / denominator, (imaginary - real * q) / denominator); [EOL]     } [EOL] } <line_num>: 246,274
public Complex divide(double divisor) { [EOL]     if (isNaN || Double.isNaN(divisor)) { [EOL]         return NaN; [EOL]     } [EOL]     if (divisor == 0d) { [EOL]         return NaN; [EOL]     } [EOL]     if (Double.isInfinite(divisor)) { [EOL]         return !isInfinite() ? ZERO : NaN; [EOL]     } [EOL]     return createComplex(real / divisor, imaginary / divisor); [EOL] } <line_num>: 284,296
public Complex reciprocal() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     if (real == 0.0 && imaginary == 0.0) { [EOL]         return INF; [EOL]     } [EOL]     if (isInfinite) { [EOL]         return ZERO; [EOL]     } [EOL]     if (FastMath.abs(real) < FastMath.abs(imaginary)) { [EOL]         double q = real / imaginary; [EOL]         double scale = 1. / (real * q + imaginary); [EOL]         return createComplex(scale * q, -scale); [EOL]     } else { [EOL]         double q = imaginary / real; [EOL]         double scale = 1. / (imaginary * q + real); [EOL]         return createComplex(scale, -scale * q); [EOL]     } [EOL] } <line_num>: 299,321
@Override [EOL] public boolean equals(Object other) { [EOL]     if (this == other) { [EOL]         return true; [EOL]     } [EOL]     if (other instanceof Complex) { [EOL]         Complex c = (Complex) other; [EOL]         if (c.isNaN) { [EOL]             return isNaN; [EOL]         } else { [EOL]             return (real == c.real) && (imaginary == c.imaginary); [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 338,352
@Override [EOL] public int hashCode() { [EOL]     if (isNaN) { [EOL]         return 7; [EOL]     } [EOL]     return 37 * (17 * MathUtils.hash(imaginary) + MathUtils.hash(real)); [EOL] } <line_num>: 361,368
public double getImaginary() { [EOL]     return imaginary; [EOL] } <line_num>: 375,377
public double getReal() { [EOL]     return real; [EOL] } <line_num>: 384,386
public boolean isNaN() { [EOL]     return isNaN; [EOL] } <line_num>: 395,397
public boolean isInfinite() { [EOL]     return isInfinite; [EOL] } <line_num>: 408,410
public Complex multiply(Complex factor) throws NullArgumentException { [EOL]     MathUtils.checkNotNull(factor); [EOL]     if (isNaN || factor.isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     if (Double.isInfinite(real) || Double.isInfinite(imaginary) || Double.isInfinite(factor.real) || Double.isInfinite(factor.imaginary)) { [EOL]         return INF; [EOL]     } [EOL]     return createComplex(real * factor.real - imaginary * factor.imaginary, real * factor.imaginary + imaginary * factor.real); [EOL] } <line_num>: 436,451
public Complex multiply(final int factor) { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     if (Double.isInfinite(real) || Double.isInfinite(imaginary)) { [EOL]         return INF; [EOL]     } [EOL]     return createComplex(real * factor, imaginary * factor); [EOL] } <line_num>: 461,470
public Complex multiply(double factor) { [EOL]     if (isNaN || Double.isNaN(factor)) { [EOL]         return NaN; [EOL]     } [EOL]     if (Double.isInfinite(real) || Double.isInfinite(imaginary) || Double.isInfinite(factor)) { [EOL]         return INF; [EOL]     } [EOL]     return createComplex(real * factor, imaginary * factor); [EOL] } <line_num>: 480,491
public Complex negate() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(-real, -imaginary); [EOL] } <line_num>: 500,506
public Complex subtract(Complex subtrahend) throws NullArgumentException { [EOL]     MathUtils.checkNotNull(subtrahend); [EOL]     if (isNaN || subtrahend.isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(real - subtrahend.getReal(), imaginary - subtrahend.getImaginary()); [EOL] } <line_num>: 526,535
public Complex subtract(double subtrahend) { [EOL]     if (isNaN || Double.isNaN(subtrahend)) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(real - subtrahend, imaginary); [EOL] } <line_num>: 545,550
public Complex acos() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return this.add(this.sqrt1z().multiply(I)).log().multiply(I.negate()); [EOL] } <line_num>: 568,574
public Complex asin() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return sqrt1z().add(this.multiply(I)).log().multiply(I.negate()); [EOL] } <line_num>: 592,598
public Complex atan() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return this.add(I).divide(I.subtract(this)).log().multiply(I.divide(createComplex(2.0, 0.0))); [EOL] } <line_num>: 616,623
public Complex cos() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(FastMath.cos(real) * FastMath.cosh(imaginary), -FastMath.sin(real) * FastMath.sinh(imaginary)); [EOL] } <line_num>: 657,664
public Complex cosh() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(FastMath.cosh(real) * FastMath.cos(imaginary), FastMath.sinh(real) * FastMath.sin(imaginary)); [EOL] } <line_num>: 697,704
public Complex exp() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     double expReal = FastMath.exp(real); [EOL]     return createComplex(expReal * FastMath.cos(imaginary), expReal * FastMath.sin(imaginary)); [EOL] } <line_num>: 738,746
public Complex log() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(FastMath.log(abs()), FastMath.atan2(imaginary, real)); [EOL] } <line_num>: 783,790
public Complex pow(Complex x) throws NullArgumentException { [EOL]     MathUtils.checkNotNull(x); [EOL]     return this.log().multiply(x).exp(); [EOL] } <line_num>: 812,816
public Complex pow(double x) { [EOL]     return this.log().multiply(x).exp(); [EOL] } <line_num>: 825,827
public Complex sin() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(FastMath.sin(real) * FastMath.cosh(imaginary), FastMath.cos(real) * FastMath.sinh(imaginary)); [EOL] } <line_num>: 861,868
public Complex sinh() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     return createComplex(FastMath.sinh(real) * FastMath.cos(imaginary), FastMath.cosh(real) * FastMath.sin(imaginary)); [EOL] } <line_num>: 901,908
public Complex sqrt() { [EOL]     if (isNaN) { [EOL]         return NaN; [EOL]     } [EOL]     if (real == 0.0 && imaginary == 0.0) { [EOL]         return createComplex(0.0, 0.0); [EOL]     } [EOL]     double t = FastMath.sqrt((FastMath.abs(real) + abs()) / 2.0); [EOL]     if (real >= 0.0) { [EOL]         return createComplex(t, imaginary / (2.0 * t)); [EOL]     } else { [EOL]         return createComplex(FastMath.abs(imaginary) / (2.0 * t), FastMath.copySign(1d, imaginary) * t); [EOL]     } [EOL] } <line_num>: 944,960
public Complex sqrt1z() { [EOL]     return createComplex(1.0, 0.0).subtract(this.multiply(this)).sqrt(); [EOL] } <line_num>: 979,981
public Complex tan() { [EOL]     if (isNaN || Double.isInfinite(real)) { [EOL]         return NaN; [EOL]     } [EOL]     if (imaginary > 20.0) { [EOL]         return createComplex(0.0, 1.0); [EOL]     } [EOL]     if (imaginary < -20.0) { [EOL]         return createComplex(0.0, -1.0); [EOL]     } [EOL]     double real2 = 2.0 * real; [EOL]     double imaginary2 = 2.0 * imaginary; [EOL]     double d = FastMath.cos(real2) + FastMath.cosh(imaginary2); [EOL]     return createComplex(FastMath.sin(real2) / d, FastMath.sinh(imaginary2) / d); [EOL] } <line_num>: 1015,1032
public Complex tanh() { [EOL]     if (isNaN || Double.isInfinite(imaginary)) { [EOL]         return NaN; [EOL]     } [EOL]     if (real > 20.0) { [EOL]         return createComplex(1.0, 0.0); [EOL]     } [EOL]     if (real < -20.0) { [EOL]         return createComplex(-1.0, 0.0); [EOL]     } [EOL]     double real2 = 2.0 * real; [EOL]     double imaginary2 = 2.0 * imaginary; [EOL]     double d = FastMath.cosh(real2) + FastMath.cos(imaginary2); [EOL]     return createComplex(FastMath.sinh(real2) / d, FastMath.sin(imaginary2) / d); [EOL] } <line_num>: 1066,1082
public double getArgument() { [EOL]     return FastMath.atan2(getImaginary(), getReal()); [EOL] } <line_num>: 1103,1105
public List<Complex> nthRoot(int n) throws NotPositiveException { [EOL]     if (n <= 0) { [EOL]         throw new NotPositiveException(LocalizedFormats.CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N, n); [EOL]     } [EOL]     final List<Complex> result = new ArrayList<Complex>(); [EOL]     if (isNaN) { [EOL]         result.add(NaN); [EOL]         return result; [EOL]     } [EOL]     if (isInfinite()) { [EOL]         result.add(INF); [EOL]         return result; [EOL]     } [EOL]     final double nthRootOfAbs = FastMath.pow(abs(), 1.0 / n); [EOL]     final double nthPhi = getArgument() / n; [EOL]     final double slice = 2 * FastMath.PI / n; [EOL]     double innerPart = nthPhi; [EOL]     for (int k = 0; k < n; k++) { [EOL]         final double realPart = nthRootOfAbs * FastMath.cos(innerPart); [EOL]         final double imaginaryPart = nthRootOfAbs * FastMath.sin(innerPart); [EOL]         result.add(createComplex(realPart, imaginaryPart)); [EOL]         innerPart += slice; [EOL]     } [EOL]     return result; [EOL] } <line_num>: 1129,1163
protected Complex createComplex(double realPart, double imaginaryPart) { [EOL]     return new Complex(realPart, imaginaryPart); [EOL] } <line_num>: 1174,1177
public static Complex valueOf(double realPart, double imaginaryPart) { [EOL]     if (Double.isNaN(realPart) || Double.isNaN(imaginaryPart)) { [EOL]         return NaN; [EOL]     } [EOL]     return new Complex(realPart, imaginaryPart); [EOL] } <line_num>: 1186,1193
public static Complex valueOf(double realPart) { [EOL]     if (Double.isNaN(realPart)) { [EOL]         return NaN; [EOL]     } [EOL]     return new Complex(realPart); [EOL] } <line_num>: 1201,1206
protected final Object readResolve() { [EOL]     return createComplex(real, imaginary); [EOL] } <line_num>: 1216,1218
public ComplexField getField() { [EOL]     return ComplexField.getInstance(); [EOL] } <line_num>: 1221,1223
@Override [EOL] public String toString() { [EOL]     return "(" + real + ", " + imaginary + ")"; [EOL] } <line_num>: 1226,1229
