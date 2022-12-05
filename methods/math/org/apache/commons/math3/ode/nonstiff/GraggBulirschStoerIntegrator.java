public GraggBulirschStoerIntegrator(final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) { [EOL]     super(METHOD_NAME, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance); [EOL]     setStabilityCheck(true, -1, -1, -1); [EOL]     setControlFactors(-1, -1, -1, -1); [EOL]     setOrderControl(-1, -1, -1); [EOL]     setInterpolationControl(true, -1); [EOL] } <line_num>: 169,178
public GraggBulirschStoerIntegrator(final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) { [EOL]     super(METHOD_NAME, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance); [EOL]     setStabilityCheck(true, -1, -1, -1); [EOL]     setControlFactors(-1, -1, -1, -1); [EOL]     setOrderControl(-1, -1, -1); [EOL]     setInterpolationControl(true, -1); [EOL] } <line_num>: 191,200
public void setStabilityCheck(final boolean performStabilityCheck, final int maxNumIter, final int maxNumChecks, final double stepsizeReductionFactor) { [EOL]     this.performTest = performStabilityCheck; [EOL]     this.maxIter = (maxNumIter <= 0) ? 2 : maxNumIter; [EOL]     this.maxChecks = (maxNumChecks <= 0) ? 1 : maxNumChecks; [EOL]     if ((stepsizeReductionFactor < 0.0001) || (stepsizeReductionFactor > 0.9999)) { [EOL]         this.stabilityReduction = 0.5; [EOL]     } else { [EOL]         this.stabilityReduction = stepsizeReductionFactor; [EOL]     } [EOL] } <line_num>: 220,234
public void setControlFactors(final double control1, final double control2, final double control3, final double control4) { [EOL]     if ((control1 < 0.0001) || (control1 > 0.9999)) { [EOL]         this.stepControl1 = 0.65; [EOL]     } else { [EOL]         this.stepControl1 = control1; [EOL]     } [EOL]     if ((control2 < 0.0001) || (control2 > 0.9999)) { [EOL]         this.stepControl2 = 0.94; [EOL]     } else { [EOL]         this.stepControl2 = control2; [EOL]     } [EOL]     if ((control3 < 0.0001) || (control3 > 0.9999)) { [EOL]         this.stepControl3 = 0.02; [EOL]     } else { [EOL]         this.stepControl3 = control3; [EOL]     } [EOL]     if ((control4 < 1.0001) || (control4 > 999.9)) { [EOL]         this.stepControl4 = 4.0; [EOL]     } else { [EOL]         this.stepControl4 = control4; [EOL]     } [EOL] } <line_num>: 260,287
public void setOrderControl(final int maximalOrder, final double control1, final double control2) { [EOL]     if ((maximalOrder <= 6) || (maximalOrder % 2 != 0)) { [EOL]         this.maxOrder = 18; [EOL]     } [EOL]     if ((control1 < 0.0001) || (control1 > 0.9999)) { [EOL]         this.orderControl1 = 0.8; [EOL]     } else { [EOL]         this.orderControl1 = control1; [EOL]     } [EOL]     if ((control2 < 0.0001) || (control2 > 0.9999)) { [EOL]         this.orderControl2 = 0.9; [EOL]     } else { [EOL]         this.orderControl2 = control2; [EOL]     } [EOL]     initializeArrays(); [EOL] } <line_num>: 312,334
@Override [EOL] public void addStepHandler(final StepHandler handler) { [EOL]     super.addStepHandler(handler); [EOL]     initializeArrays(); [EOL] } <line_num>: 337,345
@Override [EOL] public void addEventHandler(final EventHandler function, final double maxCheckInterval, final double convergence, final int maxIterationCount, final UnivariateSolver solver) { [EOL]     super.addEventHandler(function, maxCheckInterval, convergence, maxIterationCount, solver); [EOL]     initializeArrays(); [EOL] } <line_num>: 348,360
private void initializeArrays() { [EOL]     final int size = maxOrder / 2; [EOL]     if ((sequence == null) || (sequence.length != size)) { [EOL]         sequence = new int[size]; [EOL]         costPerStep = new int[size]; [EOL]         coeff = new double[size][]; [EOL]         costPerTimeUnit = new double[size]; [EOL]         optimalStep = new double[size]; [EOL]     } [EOL]     for (int k = 0; k < size; ++k) { [EOL]         sequence[k] = 4 * k + 2; [EOL]     } [EOL]     costPerStep[0] = sequence[0] + 1; [EOL]     for (int k = 1; k < size; ++k) { [EOL]         costPerStep[k] = costPerStep[k - 1] + sequence[k]; [EOL]     } [EOL]     for (int k = 0; k < size; ++k) { [EOL]         coeff[k] = (k > 0) ? new double[k] : null; [EOL]         for (int l = 0; l < k; ++l) { [EOL]             final double ratio = ((double) sequence[k]) / sequence[k - l - 1]; [EOL]             coeff[k][l] = 1.0 / (ratio * ratio - 1.0); [EOL]         } [EOL]     } [EOL] } <line_num>: 363,397
public void setInterpolationControl(final boolean useInterpolationErrorForControl, final int mudifControlParameter) { [EOL]     this.useInterpolationError = useInterpolationErrorForControl; [EOL]     if ((mudifControlParameter <= 0) || (mudifControlParameter >= 7)) { [EOL]         this.mudif = 4; [EOL]     } else { [EOL]         this.mudif = mudifControlParameter; [EOL]     } [EOL] } <line_num>: 409,420
private void rescale(final double[] y1, final double[] y2, final double[] scale) { [EOL]     if (vecAbsoluteTolerance == null) { [EOL]         for (int i = 0; i < scale.length; ++i) { [EOL]             final double yi = FastMath.max(FastMath.abs(y1[i]), FastMath.abs(y2[i])); [EOL]             scale[i] = scalAbsoluteTolerance + scalRelativeTolerance * yi; [EOL]         } [EOL]     } else { [EOL]         for (int i = 0; i < scale.length; ++i) { [EOL]             final double yi = FastMath.max(FastMath.abs(y1[i]), FastMath.abs(y2[i])); [EOL]             scale[i] = vecAbsoluteTolerance[i] + vecRelativeTolerance[i] * yi; [EOL]         } [EOL]     } [EOL] } <line_num>: 427,439
private boolean tryStep(final double t0, final double[] y0, final double step, final int k, final double[] scale, final double[][] f, final double[] yMiddle, final double[] yEnd, final double[] yTmp) throws MaxCountExceededException, DimensionMismatchException { [EOL]     final int n = sequence[k]; [EOL]     final double subStep = step / n; [EOL]     final double subStep2 = 2 * subStep; [EOL]     double t = t0 + subStep; [EOL]     for (int i = 0; i < y0.length; ++i) { [EOL]         yTmp[i] = y0[i]; [EOL]         yEnd[i] = y0[i] + subStep * f[0][i]; [EOL]     } [EOL]     computeDerivatives(t, yEnd, f[1]); [EOL]     for (int j = 1; j < n; ++j) { [EOL]         if (2 * j == n) { [EOL]             System.arraycopy(yEnd, 0, yMiddle, 0, y0.length); [EOL]         } [EOL]         t += subStep; [EOL]         for (int i = 0; i < y0.length; ++i) { [EOL]             final double middle = yEnd[i]; [EOL]             yEnd[i] = yTmp[i] + subStep2 * f[j][i]; [EOL]             yTmp[i] = middle; [EOL]         } [EOL]         computeDerivatives(t, yEnd, f[j + 1]); [EOL]         if (performTest && (j <= maxChecks) && (k < maxIter)) { [EOL]             double initialNorm = 0.0; [EOL]             for (int l = 0; l < scale.length; ++l) { [EOL]                 final double ratio = f[0][l] / scale[l]; [EOL]                 initialNorm += ratio * ratio; [EOL]             } [EOL]             double deltaNorm = 0.0; [EOL]             for (int l = 0; l < scale.length; ++l) { [EOL]                 final double ratio = (f[j + 1][l] - f[0][l]) / scale[l]; [EOL]                 deltaNorm += ratio * ratio; [EOL]             } [EOL]             if (deltaNorm > 4 * FastMath.max(1.0e-15, initialNorm)) { [EOL]                 return false; [EOL]             } [EOL]         } [EOL]     } [EOL]     for (int i = 0; i < y0.length; ++i) { [EOL]         yEnd[i] = 0.5 * (yTmp[i] + yEnd[i] + subStep * f[n][i]); [EOL]     } [EOL]     return true; [EOL] } <line_num>: 458,519
private void extrapolate(final int offset, final int k, final double[][] diag, final double[] last) { [EOL]     for (int j = 1; j < k; ++j) { [EOL]         for (int i = 0; i < last.length; ++i) { [EOL]             diag[k - j - 1][i] = diag[k - j][i] + coeff[k + offset][j - 1] * (diag[k - j][i] - diag[k - j - 1][i]); [EOL]         } [EOL]     } [EOL]     for (int i = 0; i < last.length; ++i) { [EOL]         last[i] = diag[0][i] + coeff[k + offset][k - 1] * (diag[0][i] - last[i]); [EOL]     } [EOL] } <line_num>: 528,545
@Override [EOL] public void integrate(final ExpandableStatefulODE equations, final double t) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException { [EOL]     sanityChecks(equations, t); [EOL]     setEquations(equations); [EOL]     final boolean forward = t > equations.getTime(); [EOL]     final double[] y0 = equations.getCompleteState(); [EOL]     final double[] y = y0.clone(); [EOL]     final double[] yDot0 = new double[y.length]; [EOL]     final double[] y1 = new double[y.length]; [EOL]     final double[] yTmp = new double[y.length]; [EOL]     final double[] yTmpDot = new double[y.length]; [EOL]     final double[][] diagonal = new double[sequence.length - 1][]; [EOL]     final double[][] y1Diag = new double[sequence.length - 1][]; [EOL]     for (int k = 0; k < sequence.length - 1; ++k) { [EOL]         diagonal[k] = new double[y.length]; [EOL]         y1Diag[k] = new double[y.length]; [EOL]     } [EOL]     final double[][][] fk = new double[sequence.length][][]; [EOL]     for (int k = 0; k < sequence.length; ++k) { [EOL]         fk[k] = new double[sequence[k] + 1][]; [EOL]         fk[k][0] = yDot0; [EOL]         for (int l = 0; l < sequence[k]; ++l) { [EOL]             fk[k][l + 1] = new double[y0.length]; [EOL]         } [EOL]     } [EOL]     if (y != y0) { [EOL]         System.arraycopy(y0, 0, y, 0, y0.length); [EOL]     } [EOL]     final double[] yDot1 = new double[y0.length]; [EOL]     final double[][] yMidDots = new double[1 + 2 * sequence.length][y0.length]; [EOL]     final double[] scale = new double[mainSetDimension]; [EOL]     rescale(y, y, scale); [EOL]     final double tol = (vecRelativeTolerance == null) ? scalRelativeTolerance : vecRelativeTolerance[0]; [EOL]     final double log10R = FastMath.log10(FastMath.max(1.0e-10, tol)); [EOL]     int targetIter = FastMath.max(1, FastMath.min(sequence.length - 2, (int) FastMath.floor(0.5 - 0.6 * log10R))); [EOL]     final AbstractStepInterpolator interpolator = new GraggBulirschStoerStepInterpolator(y, yDot0, y1, yDot1, yMidDots, forward, equations.getPrimaryMapper(), equations.getSecondaryMappers()); [EOL]     interpolator.storeTime(equations.getTime()); [EOL]     stepStart = equations.getTime(); [EOL]     double hNew = 0; [EOL]     double maxError = Double.MAX_VALUE; [EOL]     boolean previousRejected = false; [EOL]     boolean firstTime = true; [EOL]     boolean newStep = true; [EOL]     boolean firstStepAlreadyComputed = false; [EOL]     initIntegration(equations.getTime(), y0, t); [EOL]     costPerTimeUnit[0] = 0; [EOL]     isLastStep = false; [EOL]     do { [EOL]         double error; [EOL]         boolean reject = false; [EOL]         if (newStep) { [EOL]             interpolator.shift(); [EOL]             if (!firstStepAlreadyComputed) { [EOL]                 computeDerivatives(stepStart, y, yDot0); [EOL]             } [EOL]             if (firstTime) { [EOL]                 hNew = initializeStep(forward, 2 * targetIter + 1, scale, stepStart, y, yDot0, yTmp, yTmpDot); [EOL]             } [EOL]             newStep = false; [EOL]         } [EOL]         stepSize = hNew; [EOL]         if ((forward && (stepStart + stepSize > t)) || ((!forward) && (stepStart + stepSize < t))) { [EOL]             stepSize = t - stepStart; [EOL]         } [EOL]         final double nextT = stepStart + stepSize; [EOL]         isLastStep = forward ? (nextT >= t) : (nextT <= t); [EOL]         int k = -1; [EOL]         for (boolean loop = true; loop; ) { [EOL]             ++k; [EOL]             if (!tryStep(stepStart, y, stepSize, k, scale, fk[k], (k == 0) ? yMidDots[0] : diagonal[k - 1], (k == 0) ? y1 : y1Diag[k - 1], yTmp)) { [EOL]                 hNew = FastMath.abs(filterStep(stepSize * stabilityReduction, forward, false)); [EOL]                 reject = true; [EOL]                 loop = false; [EOL]             } else { [EOL]                 if (k > 0) { [EOL]                     extrapolate(0, k, y1Diag, y1); [EOL]                     rescale(y, y1, scale); [EOL]                     error = 0; [EOL]                     for (int j = 0; j < mainSetDimension; ++j) { [EOL]                         final double e = FastMath.abs(y1[j] - y1Diag[0][j]) / scale[j]; [EOL]                         error += e * e; [EOL]                     } [EOL]                     error = FastMath.sqrt(error / mainSetDimension); [EOL]                     if ((error > 1.0e15) || ((k > 1) && (error > maxError))) { [EOL]                         hNew = FastMath.abs(filterStep(stepSize * stabilityReduction, forward, false)); [EOL]                         reject = true; [EOL]                         loop = false; [EOL]                     } else { [EOL]                         maxError = FastMath.max(4 * error, 1.0); [EOL]                         final double exp = 1.0 / (2 * k + 1); [EOL]                         double fac = stepControl2 / FastMath.pow(error / stepControl1, exp); [EOL]                         final double pow = FastMath.pow(stepControl3, exp); [EOL]                         fac = FastMath.max(pow / stepControl4, FastMath.min(1 / pow, fac)); [EOL]                         optimalStep[k] = FastMath.abs(filterStep(stepSize * fac, forward, true)); [EOL]                         costPerTimeUnit[k] = costPerStep[k] / optimalStep[k]; [EOL]                         switch(k - targetIter) { [EOL]                             case -1: [EOL]                                 if ((targetIter > 1) && !previousRejected) { [EOL]                                     if (error <= 1.0) { [EOL]                                         loop = false; [EOL]                                     } else { [EOL]                                         final double ratio = ((double) sequence[targetIter] * sequence[targetIter + 1]) / (sequence[0] * sequence[0]); [EOL]                                         if (error > ratio * ratio) { [EOL]                                             reject = true; [EOL]                                             loop = false; [EOL]                                             targetIter = k; [EOL]                                             if ((targetIter > 1) && (costPerTimeUnit[targetIter - 1] < orderControl1 * costPerTimeUnit[targetIter])) { [EOL]                                                 --targetIter; [EOL]                                             } [EOL]                                             hNew = optimalStep[targetIter]; [EOL]                                         } [EOL]                                     } [EOL]                                 } [EOL]                                 break; [EOL]                             case 0: [EOL]                                 if (error <= 1.0) { [EOL]                                     loop = false; [EOL]                                 } else { [EOL]                                     final double ratio = ((double) sequence[k + 1]) / sequence[0]; [EOL]                                     if (error > ratio * ratio) { [EOL]                                         reject = true; [EOL]                                         loop = false; [EOL]                                         if ((targetIter > 1) && (costPerTimeUnit[targetIter - 1] < orderControl1 * costPerTimeUnit[targetIter])) { [EOL]                                             --targetIter; [EOL]                                         } [EOL]                                         hNew = optimalStep[targetIter]; [EOL]                                     } [EOL]                                 } [EOL]                                 break; [EOL]                             case 1: [EOL]                                 if (error > 1.0) { [EOL]                                     reject = true; [EOL]                                     if ((targetIter > 1) && (costPerTimeUnit[targetIter - 1] < orderControl1 * costPerTimeUnit[targetIter])) { [EOL]                                         --targetIter; [EOL]                                     } [EOL]                                     hNew = optimalStep[targetIter]; [EOL]                                 } [EOL]                                 loop = false; [EOL]                                 break; [EOL]                             default: [EOL]                                 if ((firstTime || isLastStep) && (error <= 1.0)) { [EOL]                                     loop = false; [EOL]                                 } [EOL]                                 break; [EOL]                         } [EOL]                     } [EOL]                 } [EOL]             } [EOL]         } [EOL]         if (!reject) { [EOL]             computeDerivatives(stepStart + stepSize, y1, yDot1); [EOL]         } [EOL]         double hInt = getMaxStep(); [EOL]         if (!reject) { [EOL]             for (int j = 1; j <= k; ++j) { [EOL]                 extrapolate(0, j, diagonal, yMidDots[0]); [EOL]             } [EOL]             final int mu = 2 * k - mudif + 3; [EOL]             for (int l = 0; l < mu; ++l) { [EOL]                 final int l2 = l / 2; [EOL]                 double factor = FastMath.pow(0.5 * sequence[l2], l); [EOL]                 int middleIndex = fk[l2].length / 2; [EOL]                 for (int i = 0; i < y0.length; ++i) { [EOL]                     yMidDots[l + 1][i] = factor * fk[l2][middleIndex + l][i]; [EOL]                 } [EOL]                 for (int j = 1; j <= k - l2; ++j) { [EOL]                     factor = FastMath.pow(0.5 * sequence[j + l2], l); [EOL]                     middleIndex = fk[l2 + j].length / 2; [EOL]                     for (int i = 0; i < y0.length; ++i) { [EOL]                         diagonal[j - 1][i] = factor * fk[l2 + j][middleIndex + l][i]; [EOL]                     } [EOL]                     extrapolate(l2, j, diagonal, yMidDots[l + 1]); [EOL]                 } [EOL]                 for (int i = 0; i < y0.length; ++i) { [EOL]                     yMidDots[l + 1][i] *= stepSize; [EOL]                 } [EOL]                 for (int j = (l + 1) / 2; j <= k; ++j) { [EOL]                     for (int m = fk[j].length - 1; m >= 2 * (l + 1); --m) { [EOL]                         for (int i = 0; i < y0.length; ++i) { [EOL]                             fk[j][m][i] -= fk[j][m - 2][i]; [EOL]                         } [EOL]                     } [EOL]                 } [EOL]             } [EOL]             if (mu >= 0) { [EOL]                 final GraggBulirschStoerStepInterpolator gbsInterpolator = (GraggBulirschStoerStepInterpolator) interpolator; [EOL]                 gbsInterpolator.computeCoefficients(mu, stepSize); [EOL]                 if (useInterpolationError) { [EOL]                     final double interpError = gbsInterpolator.estimateError(scale); [EOL]                     hInt = FastMath.abs(stepSize / FastMath.max(FastMath.pow(interpError, 1.0 / (mu + 4)), 0.01)); [EOL]                     if (interpError > 10.0) { [EOL]                         hNew = hInt; [EOL]                         reject = true; [EOL]                     } [EOL]                 } [EOL]             } [EOL]         } [EOL]         if (!reject) { [EOL]             interpolator.storeTime(stepStart + stepSize); [EOL]             stepStart = acceptStep(interpolator, y1, yDot1, t); [EOL]             interpolator.storeTime(stepStart); [EOL]             System.arraycopy(y1, 0, y, 0, y0.length); [EOL]             System.arraycopy(yDot1, 0, yDot0, 0, y0.length); [EOL]             firstStepAlreadyComputed = true; [EOL]             int optimalIter; [EOL]             if (k == 1) { [EOL]                 optimalIter = 2; [EOL]                 if (previousRejected) { [EOL]                     optimalIter = 1; [EOL]                 } [EOL]             } else if (k <= targetIter) { [EOL]                 optimalIter = k; [EOL]                 if (costPerTimeUnit[k - 1] < orderControl1 * costPerTimeUnit[k]) { [EOL]                     optimalIter = k - 1; [EOL]                 } else if (costPerTimeUnit[k] < orderControl2 * costPerTimeUnit[k - 1]) { [EOL]                     optimalIter = FastMath.min(k + 1, sequence.length - 2); [EOL]                 } [EOL]             } else { [EOL]                 optimalIter = k - 1; [EOL]                 if ((k > 2) && (costPerTimeUnit[k - 2] < orderControl1 * costPerTimeUnit[k - 1])) { [EOL]                     optimalIter = k - 2; [EOL]                 } [EOL]                 if (costPerTimeUnit[k] < orderControl2 * costPerTimeUnit[optimalIter]) { [EOL]                     optimalIter = FastMath.min(k, sequence.length - 2); [EOL]                 } [EOL]             } [EOL]             if (previousRejected) { [EOL]                 targetIter = FastMath.min(optimalIter, k); [EOL]                 hNew = FastMath.min(FastMath.abs(stepSize), optimalStep[targetIter]); [EOL]             } else { [EOL]                 if (optimalIter <= k) { [EOL]                     hNew = optimalStep[optimalIter]; [EOL]                 } else { [EOL]                     if ((k < targetIter) && (costPerTimeUnit[k] < orderControl2 * costPerTimeUnit[k - 1])) { [EOL]                         hNew = filterStep(optimalStep[k] * costPerStep[optimalIter + 1] / costPerStep[k], forward, false); [EOL]                     } else { [EOL]                         hNew = filterStep(optimalStep[k] * costPerStep[optimalIter] / costPerStep[k], forward, false); [EOL]                     } [EOL]                 } [EOL]                 targetIter = optimalIter; [EOL]             } [EOL]             newStep = true; [EOL]         } [EOL]         hNew = FastMath.min(hNew, hInt); [EOL]         if (!forward) { [EOL]             hNew = -hNew; [EOL]         } [EOL]         firstTime = false; [EOL]         if (reject) { [EOL]             isLastStep = false; [EOL]             previousRejected = true; [EOL]         } else { [EOL]             previousRejected = false; [EOL]         } [EOL]     } while (!isLastStep); [EOL]     equations.setTime(stepStart); [EOL]     equations.setCompleteState(y); [EOL]     resetInternalState(); [EOL] } <line_num>: 548,948
