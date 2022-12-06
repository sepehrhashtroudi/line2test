public MullerSolver2() { [EOL]     this(DEFAULT_ABSOLUTE_ACCURACY); [EOL] } <line_num>: 58,60
public MullerSolver2(double absoluteAccuracy) { [EOL]     super(absoluteAccuracy); [EOL] } <line_num>: 66,68
public MullerSolver2(double relativeAccuracy, double absoluteAccuracy) { [EOL]     super(relativeAccuracy, absoluteAccuracy); [EOL] } <line_num>: 75,78
@Override [EOL] protected double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException { [EOL]     final double min = getMin(); [EOL]     final double max = getMax(); [EOL]     verifyInterval(min, max); [EOL]     final double relativeAccuracy = getRelativeAccuracy(); [EOL]     final double absoluteAccuracy = getAbsoluteAccuracy(); [EOL]     final double functionValueAccuracy = getFunctionValueAccuracy(); [EOL]     double x0 = min; [EOL]     double y0 = computeObjectiveValue(x0); [EOL]     if (FastMath.abs(y0) < functionValueAccuracy) { [EOL]         return x0; [EOL]     } [EOL]     double x1 = max; [EOL]     double y1 = computeObjectiveValue(x1); [EOL]     if (FastMath.abs(y1) < functionValueAccuracy) { [EOL]         return x1; [EOL]     } [EOL]     if (y0 * y1 > 0) { [EOL]         throw new NoBracketingException(x0, x1, y0, y1); [EOL]     } [EOL]     double x2 = 0.5 * (x0 + x1); [EOL]     double y2 = computeObjectiveValue(x2); [EOL]     double oldx = Double.POSITIVE_INFINITY; [EOL]     while (true) { [EOL]         final double q = (x2 - x1) / (x1 - x0); [EOL]         final double a = q * (y2 - (1 + q) * y1 + q * y0); [EOL]         final double b = (2 * q + 1) * y2 - (1 + q) * (1 + q) * y1 + q * q * y0; [EOL]         final double c = (1 + q) * y2; [EOL]         final double delta = b * b - 4 * a * c; [EOL]         double x; [EOL]         final double denominator; [EOL]         if (delta >= 0.0) { [EOL]             double dplus = b + FastMath.sqrt(delta); [EOL]             double dminus = b - FastMath.sqrt(delta); [EOL]             denominator = FastMath.abs(dplus) > FastMath.abs(dminus) ? dplus : dminus; [EOL]         } else { [EOL]             denominator = FastMath.sqrt(b * b - delta); [EOL]         } [EOL]         if (denominator != 0) { [EOL]             x = x2 - 2.0 * c * (x2 - x1) / denominator; [EOL]             while (x == x1 || x == x2) { [EOL]                 x += absoluteAccuracy; [EOL]             } [EOL]         } else { [EOL]             x = min + FastMath.random() * (max - min); [EOL]             oldx = Double.POSITIVE_INFINITY; [EOL]         } [EOL]         final double y = computeObjectiveValue(x); [EOL]         final double tolerance = FastMath.max(relativeAccuracy * FastMath.abs(x), absoluteAccuracy); [EOL]         if (FastMath.abs(x - oldx) <= tolerance || FastMath.abs(y) <= functionValueAccuracy) { [EOL]             return x; [EOL]         } [EOL]         x0 = x1; [EOL]         y0 = y1; [EOL]         x1 = x2; [EOL]         y1 = y2; [EOL]         x2 = x; [EOL]         y2 = y; [EOL]         oldx = x; [EOL]     } [EOL] } <line_num>: 83,168