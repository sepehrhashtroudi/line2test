public BracketingNthOrderBrentSolver() { [EOL]     this(DEFAULT_ABSOLUTE_ACCURACY, DEFAULT_MAXIMAL_ORDER); [EOL] } <line_num>: 70,72
public BracketingNthOrderBrentSolver(final double absoluteAccuracy, final int maximalOrder) throws NumberIsTooSmallException { [EOL]     super(absoluteAccuracy); [EOL]     if (maximalOrder < 2) { [EOL]         throw new NumberIsTooSmallException(maximalOrder, 2, true); [EOL]     } [EOL]     this.maximalOrder = maximalOrder; [EOL]     this.allowed = AllowedSolution.ANY_SIDE; [EOL] } <line_num>: 81,90
public BracketingNthOrderBrentSolver(final double relativeAccuracy, final double absoluteAccuracy, final int maximalOrder) throws NumberIsTooSmallException { [EOL]     super(relativeAccuracy, absoluteAccuracy); [EOL]     if (maximalOrder < 2) { [EOL]         throw new NumberIsTooSmallException(maximalOrder, 2, true); [EOL]     } [EOL]     this.maximalOrder = maximalOrder; [EOL]     this.allowed = AllowedSolution.ANY_SIDE; [EOL] } <line_num>: 100,110
public BracketingNthOrderBrentSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy, final int maximalOrder) throws NumberIsTooSmallException { [EOL]     super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy); [EOL]     if (maximalOrder < 2) { [EOL]         throw new NumberIsTooSmallException(maximalOrder, 2, true); [EOL]     } [EOL]     this.maximalOrder = maximalOrder; [EOL]     this.allowed = AllowedSolution.ANY_SIDE; [EOL] } <line_num>: 121,132
public int getMaximalOrder() { [EOL]     return maximalOrder; [EOL] } <line_num>: 137,139
@Override [EOL] protected double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException { [EOL]     final double[] x = new double[maximalOrder + 1]; [EOL]     final double[] y = new double[maximalOrder + 1]; [EOL]     x[0] = getMin(); [EOL]     x[1] = getStartValue(); [EOL]     x[2] = getMax(); [EOL]     verifySequence(x[0], x[1], x[2]); [EOL]     y[1] = computeObjectiveValue(x[1]); [EOL]     if (Precision.equals(y[1], 0.0, 1)) { [EOL]         return x[1]; [EOL]     } [EOL]     y[0] = computeObjectiveValue(x[0]); [EOL]     if (Precision.equals(y[0], 0.0, 1)) { [EOL]         return x[0]; [EOL]     } [EOL]     int nbPoints; [EOL]     int signChangeIndex; [EOL]     if (y[0] * y[1] < 0) { [EOL]         nbPoints = 2; [EOL]         signChangeIndex = 1; [EOL]     } else { [EOL]         y[2] = computeObjectiveValue(x[2]); [EOL]         if (Precision.equals(y[2], 0.0, 1)) { [EOL]             return x[2]; [EOL]         } [EOL]         if (y[1] * y[2] < 0) { [EOL]             nbPoints = 3; [EOL]             signChangeIndex = 2; [EOL]         } else { [EOL]             throw new NoBracketingException(x[0], x[2], y[0], y[2]); [EOL]         } [EOL]     } [EOL]     final double[] tmpX = new double[x.length]; [EOL]     double xA = x[signChangeIndex - 1]; [EOL]     double yA = y[signChangeIndex - 1]; [EOL]     double absYA = FastMath.abs(yA); [EOL]     int agingA = 0; [EOL]     double xB = x[signChangeIndex]; [EOL]     double yB = y[signChangeIndex]; [EOL]     double absYB = FastMath.abs(yB); [EOL]     int agingB = 0; [EOL]     while (true) { [EOL]         final double xTol = getAbsoluteAccuracy() + getRelativeAccuracy() * FastMath.max(FastMath.abs(xA), FastMath.abs(xB)); [EOL]         if (((xB - xA) <= xTol) || (FastMath.max(absYA, absYB) < getFunctionValueAccuracy())) { [EOL]             switch(allowed) { [EOL]                 case ANY_SIDE: [EOL]                     return absYA < absYB ? xA : xB; [EOL]                 case LEFT_SIDE: [EOL]                     return xA; [EOL]                 case RIGHT_SIDE: [EOL]                     return xB; [EOL]                 case BELOW_SIDE: [EOL]                     return (yA <= 0) ? xA : xB; [EOL]                 case ABOVE_SIDE: [EOL]                     return (yA < 0) ? xB : xA; [EOL]                 default: [EOL]                     throw new MathInternalError(); [EOL]             } [EOL]         } [EOL]         double targetY; [EOL]         if (agingA >= MAXIMAL_AGING) { [EOL]             final int p = agingA - MAXIMAL_AGING; [EOL]             final double weightA = (1 << p) - 1; [EOL]             final double weightB = p + 1; [EOL]             targetY = (weightA * yA - weightB * REDUCTION_FACTOR * yB) / (weightA + weightB); [EOL]         } else if (agingB >= MAXIMAL_AGING) { [EOL]             final int p = agingB - MAXIMAL_AGING; [EOL]             final double weightA = p + 1; [EOL]             final double weightB = (1 << p) - 1; [EOL]             targetY = (weightB * yB - weightA * REDUCTION_FACTOR * yA) / (weightA + weightB); [EOL]         } else { [EOL]             targetY = 0; [EOL]         } [EOL]         double nextX; [EOL]         int start = 0; [EOL]         int end = nbPoints; [EOL]         do { [EOL]             System.arraycopy(x, start, tmpX, start, end - start); [EOL]             nextX = guessX(targetY, tmpX, y, start, end); [EOL]             if (!((nextX > xA) && (nextX < xB))) { [EOL]                 if (signChangeIndex - start >= end - signChangeIndex) { [EOL]                     ++start; [EOL]                 } else { [EOL]                     --end; [EOL]                 } [EOL]                 nextX = Double.NaN; [EOL]             } [EOL]         } while (Double.isNaN(nextX) && (end - start > 1)); [EOL]         if (Double.isNaN(nextX)) { [EOL]             nextX = xA + 0.5 * (xB - xA); [EOL]             start = signChangeIndex - 1; [EOL]             end = signChangeIndex; [EOL]         } [EOL]         final double nextY = computeObjectiveValue(nextX); [EOL]         if (Precision.equals(nextY, 0.0, 1)) { [EOL]             return nextX; [EOL]         } [EOL]         if ((nbPoints > 2) && (end - start != nbPoints)) { [EOL]             nbPoints = end - start; [EOL]             System.arraycopy(x, start, x, 0, nbPoints); [EOL]             System.arraycopy(y, start, y, 0, nbPoints); [EOL]             signChangeIndex -= start; [EOL]         } else if (nbPoints == x.length) { [EOL]             nbPoints--; [EOL]             if (signChangeIndex >= (x.length + 1) / 2) { [EOL]                 System.arraycopy(x, 1, x, 0, nbPoints); [EOL]                 System.arraycopy(y, 1, y, 0, nbPoints); [EOL]                 --signChangeIndex; [EOL]             } [EOL]         } [EOL]         System.arraycopy(x, signChangeIndex, x, signChangeIndex + 1, nbPoints - signChangeIndex); [EOL]         x[signChangeIndex] = nextX; [EOL]         System.arraycopy(y, signChangeIndex, y, signChangeIndex + 1, nbPoints - signChangeIndex); [EOL]         y[signChangeIndex] = nextY; [EOL]         ++nbPoints; [EOL]         if (nextY * yA <= 0) { [EOL]             xB = nextX; [EOL]             yB = nextY; [EOL]             absYB = FastMath.abs(yB); [EOL]             ++agingA; [EOL]             agingB = 0; [EOL]         } else { [EOL]             xA = nextX; [EOL]             yA = nextY; [EOL]             absYA = FastMath.abs(yA); [EOL]             agingA = 0; [EOL]             ++agingB; [EOL]             signChangeIndex++; [EOL]         } [EOL]     } [EOL] } <line_num>: 144,355
private double guessX(final double targetY, final double[] x, final double[] y, final int start, final int end) { [EOL]     for (int i = start; i < end - 1; ++i) { [EOL]         final int delta = i + 1 - start; [EOL]         for (int j = end - 1; j > i; --j) { [EOL]             x[j] = (x[j] - x[j - 1]) / (y[j] - y[j - delta]); [EOL]         } [EOL]     } [EOL]     double x0 = 0; [EOL]     for (int j = end - 1; j >= start; --j) { [EOL]         x0 = x[j] + x0 * (targetY - y[j]); [EOL]     } [EOL]     return x0; [EOL] } <line_num>: 371,390
public double solve(int maxEval, UnivariateFunction f, double min, double max, AllowedSolution allowedSolution) throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException { [EOL]     this.allowed = allowedSolution; [EOL]     return super.solve(maxEval, f, min, max); [EOL] } <line_num>: 393,400
public double solve(int maxEval, UnivariateFunction f, double min, double max, double startValue, AllowedSolution allowedSolution) throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException { [EOL]     this.allowed = allowedSolution; [EOL]     return super.solve(maxEval, f, min, max, startValue); [EOL] } <line_num>: 403,411