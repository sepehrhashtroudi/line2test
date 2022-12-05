public ChiSquareTest() { [EOL]     super(); [EOL] } <line_num>: 47,49
public double chiSquare(final double[] expected, final long[] observed) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException { [EOL]     if (expected.length < 2) { [EOL]         throw new DimensionMismatchException(expected.length, 2); [EOL]     } [EOL]     if (expected.length != observed.length) { [EOL]         throw new DimensionMismatchException(expected.length, observed.length); [EOL]     } [EOL]     MathArrays.checkPositive(expected); [EOL]     MathArrays.checkNonNegative(observed); [EOL]     double sumExpected = 0d; [EOL]     double sumObserved = 0d; [EOL]     for (int i = 0; i < observed.length; i++) { [EOL]         sumExpected += expected[i]; [EOL]         sumObserved += observed[i]; [EOL]     } [EOL]     double ratio = 1.0d; [EOL]     boolean rescale = false; [EOL]     if (FastMath.abs(sumExpected - sumObserved) > 10E-6) { [EOL]         ratio = sumObserved / sumExpected; [EOL]         rescale = true; [EOL]     } [EOL]     double sumSq = 0.0d; [EOL]     for (int i = 0; i < observed.length; i++) { [EOL]         if (rescale) { [EOL]             final double dev = observed[i] - ratio * expected[i]; [EOL]             sumSq += dev * dev / (ratio * expected[i]); [EOL]         } else { [EOL]             final double dev = observed[i] - expected[i]; [EOL]             sumSq += dev * dev / expected[i]; [EOL]         } [EOL]     } [EOL]     return sumSq; [EOL] } <line_num>: 81,118
public double chiSquareTest(final double[] expected, final long[] observed) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, MaxCountExceededException { [EOL]     ChiSquaredDistribution distribution = new ChiSquaredDistribution(expected.length - 1.0); [EOL]     return 1.0 - distribution.cumulativeProbability(chiSquare(expected, observed)); [EOL] } <line_num>: 155,162
public boolean chiSquareTest(final double[] expected, final long[] observed, final double alpha) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, OutOfRangeException, MaxCountExceededException { [EOL]     if ((alpha <= 0) || (alpha > 0.5)) { [EOL]         throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, alpha, 0, 0.5); [EOL]     } [EOL]     return chiSquareTest(expected, observed) < alpha; [EOL] } <line_num>: 203,214
public double chiSquare(final long[][] counts) throws NullArgumentException, NotPositiveException, DimensionMismatchException { [EOL]     checkArray(counts); [EOL]     int nRows = counts.length; [EOL]     int nCols = counts[0].length; [EOL]     double[] rowSum = new double[nRows]; [EOL]     double[] colSum = new double[nCols]; [EOL]     double total = 0.0d; [EOL]     for (int row = 0; row < nRows; row++) { [EOL]         for (int col = 0; col < nCols; col++) { [EOL]             rowSum[row] += counts[row][col]; [EOL]             colSum[col] += counts[row][col]; [EOL]             total += counts[row][col]; [EOL]         } [EOL]     } [EOL]     double sumSq = 0.0d; [EOL]     double expected = 0.0d; [EOL]     for (int row = 0; row < nRows; row++) { [EOL]         for (int col = 0; col < nCols; col++) { [EOL]             expected = (rowSum[row] * colSum[col]) / total; [EOL]             sumSq += ((counts[row][col] - expected) * (counts[row][col] - expected)) / expected; [EOL]         } [EOL]     } [EOL]     return sumSq; [EOL] } <line_num>: 244,276
public double chiSquareTest(final long[][] counts) throws NullArgumentException, DimensionMismatchException, NotPositiveException, MaxCountExceededException { [EOL]     checkArray(counts); [EOL]     double df = ((double) counts.length - 1) * ((double) counts[0].length - 1); [EOL]     ChiSquaredDistribution distribution; [EOL]     distribution = new ChiSquaredDistribution(df); [EOL]     return 1 - distribution.cumulativeProbability(chiSquare(counts)); [EOL] } <line_num>: 309,319
public boolean chiSquareTest(final long[][] counts, final double alpha) throws NullArgumentException, DimensionMismatchException, NotPositiveException, OutOfRangeException, MaxCountExceededException { [EOL]     if ((alpha <= 0) || (alpha > 0.5)) { [EOL]         throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, alpha, 0, 0.5); [EOL]     } [EOL]     return chiSquareTest(counts) < alpha; [EOL] } <line_num>: 359,369
public double chiSquareDataSetsComparison(long[] observed1, long[] observed2) throws DimensionMismatchException, NotPositiveException, ZeroException { [EOL]     if (observed1.length < 2) { [EOL]         throw new DimensionMismatchException(observed1.length, 2); [EOL]     } [EOL]     if (observed1.length != observed2.length) { [EOL]         throw new DimensionMismatchException(observed1.length, observed2.length); [EOL]     } [EOL]     MathArrays.checkNonNegative(observed1); [EOL]     MathArrays.checkNonNegative(observed2); [EOL]     long countSum1 = 0; [EOL]     long countSum2 = 0; [EOL]     boolean unequalCounts = false; [EOL]     double weight = 0.0; [EOL]     for (int i = 0; i < observed1.length; i++) { [EOL]         countSum1 += observed1[i]; [EOL]         countSum2 += observed2[i]; [EOL]     } [EOL]     if (countSum1 == 0 || countSum2 == 0) { [EOL]         throw new ZeroException(); [EOL]     } [EOL]     unequalCounts = countSum1 != countSum2; [EOL]     if (unequalCounts) { [EOL]         weight = FastMath.sqrt((double) countSum1 / (double) countSum2); [EOL]     } [EOL]     double sumSq = 0.0d; [EOL]     double dev = 0.0d; [EOL]     double obs1 = 0.0d; [EOL]     double obs2 = 0.0d; [EOL]     for (int i = 0; i < observed1.length; i++) { [EOL]         if (observed1[i] == 0 && observed2[i] == 0) { [EOL]             throw new ZeroException(LocalizedFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, i); [EOL]         } else { [EOL]             obs1 = observed1[i]; [EOL]             obs2 = observed2[i]; [EOL]             if (unequalCounts) { [EOL]                 dev = obs1 / weight - obs2 * weight; [EOL]             } else { [EOL]                 dev = obs1 - obs2; [EOL]             } [EOL]             sumSq += (dev * dev) / (obs1 + obs2); [EOL]         } [EOL]     } [EOL]     return sumSq; [EOL] } <line_num>: 410,463
public double chiSquareTestDataSetsComparison(long[] observed1, long[] observed2) throws DimensionMismatchException, NotPositiveException, ZeroException, MaxCountExceededException { [EOL]     ChiSquaredDistribution distribution; [EOL]     distribution = new ChiSquaredDistribution((double) observed1.length - 1); [EOL]     return 1 - distribution.cumulativeProbability(chiSquareDataSetsComparison(observed1, observed2)); [EOL] } <line_num>: 507,516
public boolean chiSquareTestDataSetsComparison(final long[] observed1, final long[] observed2, final double alpha) throws DimensionMismatchException, NotPositiveException, ZeroException, OutOfRangeException, MaxCountExceededException { [EOL]     if (alpha <= 0 || alpha > 0.5) { [EOL]         throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, alpha, 0, 0.5); [EOL]     } [EOL]     return chiSquareTestDataSetsComparison(observed1, observed2) < alpha; [EOL] } <line_num>: 560,573
private void checkArray(final long[][] in) throws NullArgumentException, DimensionMismatchException, NotPositiveException { [EOL]     if (in.length < 2) { [EOL]         throw new DimensionMismatchException(in.length, 2); [EOL]     } [EOL]     if (in[0].length < 2) { [EOL]         throw new DimensionMismatchException(in[0].length, 2); [EOL]     } [EOL]     MathArrays.checkRectangular(in); [EOL]     MathArrays.checkNonNegative(in); [EOL] } <line_num>: 584,599
