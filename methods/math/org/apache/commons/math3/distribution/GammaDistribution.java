public GammaDistribution(double shape, double scale) throws NotStrictlyPositiveException { [EOL]     this(shape, scale, DEFAULT_INVERSE_ABSOLUTE_ACCURACY); [EOL] } <line_num>: 92,94
public GammaDistribution(double shape, double scale, double inverseCumAccuracy) throws NotStrictlyPositiveException { [EOL]     this(new Well19937c(), shape, scale, inverseCumAccuracy); [EOL] } <line_num>: 109,112
public GammaDistribution(RandomGenerator rng, double shape, double scale, double inverseCumAccuracy) throws NotStrictlyPositiveException { [EOL]     super(rng); [EOL]     if (shape <= 0) { [EOL]         throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, shape); [EOL]     } [EOL]     if (scale <= 0) { [EOL]         throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, scale); [EOL]     } [EOL]     this.shape = shape; [EOL]     this.scale = scale; [EOL]     this.solverAbsoluteAccuracy = inverseCumAccuracy; [EOL]     this.shiftedShape = shape + Gamma.LANCZOS_G + 0.5; [EOL]     final double aux = FastMath.E / (2.0 * FastMath.PI * shiftedShape); [EOL]     this.densityPrefactor2 = shape * FastMath.sqrt(aux) / Gamma.lanczos(shape); [EOL]     this.densityPrefactor1 = this.densityPrefactor2 / scale * FastMath.pow(shiftedShape, -shape) * FastMath.exp(shape + Gamma.LANCZOS_G); [EOL]     this.minY = shape + Gamma.LANCZOS_G - FastMath.log(Double.MAX_VALUE); [EOL]     this.maxLogY = FastMath.log(Double.MAX_VALUE) / (shape - 1.0); [EOL] } <line_num>: 127,152
@Deprecated [EOL] public double getAlpha() { [EOL]     return shape; [EOL] } <line_num>: 161,164
public double getShape() { [EOL]     return shape; [EOL] } <line_num>: 172,174
@Deprecated [EOL] public double getBeta() { [EOL]     return scale; [EOL] } <line_num>: 183,186
public double getScale() { [EOL]     return scale; [EOL] } <line_num>: 194,196
public double density(double x) { [EOL]     if (x < 0) { [EOL]         return 0; [EOL]     } [EOL]     final double y = x / scale; [EOL]     if ((y <= minY) || (FastMath.log(y) >= maxLogY)) { [EOL]         final double aux1 = (y - shiftedShape) / shiftedShape; [EOL]         final double aux2 = shape * (FastMath.log1p(aux1) - aux1); [EOL]         final double aux3 = -y * (Gamma.LANCZOS_G + 0.5) / shiftedShape + Gamma.LANCZOS_G + aux2; [EOL]         return densityPrefactor2 / x * FastMath.exp(aux3); [EOL]     } [EOL]     return densityPrefactor1 * FastMath.exp(-y) * FastMath.pow(y, shape - 1); [EOL] } <line_num>: 199,257
public double cumulativeProbability(double x) { [EOL]     double ret; [EOL]     if (x <= 0) { [EOL]         ret = 0; [EOL]     } else { [EOL]         ret = Gamma.regularizedGammaP(shape, x / scale); [EOL]     } [EOL]     return ret; [EOL] } <line_num>: 273,283
@Override [EOL] protected double getSolverAbsoluteAccuracy() { [EOL]     return solverAbsoluteAccuracy; [EOL] } <line_num>: 286,289
public double getNumericalMean() { [EOL]     return shape * scale; [EOL] } <line_num>: 297,299
public double getNumericalVariance() { [EOL]     return shape * scale * scale; [EOL] } <line_num>: 309,311
public double getSupportLowerBound() { [EOL]     return 0; [EOL] } <line_num>: 320,322
public double getSupportUpperBound() { [EOL]     return Double.POSITIVE_INFINITY; [EOL] } <line_num>: 332,334
public boolean isSupportLowerBoundInclusive() { [EOL]     return true; [EOL] } <line_num>: 337,339
public boolean isSupportUpperBoundInclusive() { [EOL]     return false; [EOL] } <line_num>: 342,344
public boolean isSupportConnected() { [EOL]     return true; [EOL] } <line_num>: 353,355
@Override [EOL] public double sample() { [EOL]     if (shape < 1) { [EOL]         while (true) { [EOL]             final double u = random.nextDouble(); [EOL]             final double bGS = 1 + shape / FastMath.E; [EOL]             final double p = bGS * u; [EOL]             if (p <= 1) { [EOL]                 final double x = FastMath.pow(p, 1 / shape); [EOL]                 final double u2 = random.nextDouble(); [EOL]                 if (u2 > FastMath.exp(-x)) { [EOL]                     continue; [EOL]                 } else { [EOL]                     return scale * x; [EOL]                 } [EOL]             } else { [EOL]                 final double x = -1 * FastMath.log((bGS - p) / shape); [EOL]                 final double u2 = random.nextDouble(); [EOL]                 if (u2 > FastMath.pow(x, shape - 1)) { [EOL]                     continue; [EOL]                 } else { [EOL]                     return scale * x; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     final double d = shape - 0.333333333333333333; [EOL]     final double c = 1 / (3 * FastMath.sqrt(d)); [EOL]     while (true) { [EOL]         final double x = random.nextGaussian(); [EOL]         final double v = (1 + c * x) * (1 + c * x) * (1 + c * x); [EOL]         if (v <= 0) { [EOL]             continue; [EOL]         } [EOL]         final double x2 = x * x; [EOL]         final double u = random.nextDouble(); [EOL]         if (u < 1 - 0.0331 * x2 * x2) { [EOL]             return scale * d * v; [EOL]         } [EOL]         if (FastMath.log(u) < 0.5 * x2 + d * (1 - v + FastMath.log(v))) { [EOL]             return scale * d * v; [EOL]         } [EOL]     } [EOL] } <line_num>: 372,436