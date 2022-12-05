private DSCompiler(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler) throws NumberIsTooLargeException { [EOL]     this.parameters = parameters; [EOL]     this.order = order; [EOL]     this.sizes = compileSizes(parameters, order, valueCompiler); [EOL]     this.derivativesIndirection = compileDerivativesIndirection(parameters, order, valueCompiler, derivativeCompiler); [EOL]     this.lowerIndirection = compileLowerIndirection(parameters, order, valueCompiler, derivativeCompiler); [EOL]     this.multIndirection = compileMultiplicationIndirection(parameters, order, valueCompiler, derivativeCompiler, lowerIndirection); [EOL]     this.compIndirection = compileCompositionIndirection(parameters, order, valueCompiler, derivativeCompiler, sizes, derivativesIndirection); [EOL] } <line_num>: 162,183
public static DSCompiler getCompiler(int parameters, int order) throws NumberIsTooLargeException { [EOL]     final DSCompiler[][] cache = compilers.get(); [EOL]     if (cache != null && cache.length > parameters && cache[parameters].length > order && cache[parameters][order] != null) { [EOL]         return cache[parameters][order]; [EOL]     } [EOL]     final int maxParameters = FastMath.max(parameters, cache == null ? 0 : cache.length); [EOL]     final int maxOrder = FastMath.max(order, cache == null ? 0 : cache[0].length); [EOL]     final DSCompiler[][] newCache = new DSCompiler[maxParameters + 1][maxOrder + 1]; [EOL]     if (cache != null) { [EOL]         for (int i = 0; i < cache.length; ++i) { [EOL]             System.arraycopy(cache[i], 0, newCache[i], 0, cache[i].length); [EOL]         } [EOL]     } [EOL]     for (int diag = 0; diag <= parameters + order; ++diag) { [EOL]         for (int o = FastMath.max(0, diag - parameters); o <= FastMath.min(order, diag); ++o) { [EOL]             final int p = diag - o; [EOL]             if (newCache[p][o] == null) { [EOL]                 final DSCompiler valueCompiler = (p == 0) ? null : newCache[p - 1][o]; [EOL]                 final DSCompiler derivativeCompiler = (o == 0) ? null : newCache[p][o - 1]; [EOL]                 newCache[p][o] = new DSCompiler(p, o, valueCompiler, derivativeCompiler); [EOL]             } [EOL]         } [EOL]     } [EOL]     compilers.compareAndSet(cache, newCache); [EOL]     return newCache[parameters][order]; [EOL] } <line_num>: 191,231
private static int[][] compileSizes(final int parameters, final int order, final DSCompiler valueCompiler) { [EOL]     final int[][] sizes = new int[parameters + 1][order + 1]; [EOL]     if (parameters == 0) { [EOL]         Arrays.fill(sizes[0], 1); [EOL]     } else { [EOL]         System.arraycopy(valueCompiler.sizes, 0, sizes, 0, parameters); [EOL]         sizes[parameters][0] = 1; [EOL]         for (int i = 0; i < order; ++i) { [EOL]             sizes[parameters][i + 1] = sizes[parameters][i] + sizes[parameters - 1][i + 1]; [EOL]         } [EOL]     } [EOL]     return sizes; [EOL] } <line_num>: 239,255
private static int[][] compileDerivativesIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler) { [EOL]     if (parameters == 0 || order == 0) { [EOL]         return new int[1][parameters]; [EOL]     } [EOL]     final int vSize = valueCompiler.derivativesIndirection.length; [EOL]     final int dSize = derivativeCompiler.derivativesIndirection.length; [EOL]     final int[][] derivativesIndirection = new int[vSize + dSize][parameters]; [EOL]     for (int i = 0; i < vSize; ++i) { [EOL]         System.arraycopy(valueCompiler.derivativesIndirection[i], 0, derivativesIndirection[i], 0, parameters - 1); [EOL]     } [EOL]     for (int i = 0; i < dSize; ++i) { [EOL]         System.arraycopy(derivativeCompiler.derivativesIndirection[i], 0, derivativesIndirection[vSize + i], 0, parameters); [EOL]         derivativesIndirection[vSize + i][parameters - 1]++; [EOL]     } [EOL]     return derivativesIndirection; [EOL] } <line_num>: 264,299
private static int[] compileLowerIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler) { [EOL]     if (parameters == 0 || order <= 1) { [EOL]         return new int[] { 0 }; [EOL]     } [EOL]     final int vSize = valueCompiler.lowerIndirection.length; [EOL]     final int dSize = derivativeCompiler.lowerIndirection.length; [EOL]     final int[] lowerIndirection = new int[vSize + dSize]; [EOL]     System.arraycopy(valueCompiler.lowerIndirection, 0, lowerIndirection, 0, vSize); [EOL]     for (int i = 0; i < dSize; ++i) { [EOL]         lowerIndirection[vSize + i] = valueCompiler.getSize() + derivativeCompiler.lowerIndirection[i]; [EOL]     } [EOL]     return lowerIndirection; [EOL] } <line_num>: 312,331
private static int[][][] compileMultiplicationIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler, final int[] lowerIndirection) { [EOL]     if ((parameters == 0) || (order == 0)) { [EOL]         return new int[][][] { { { 1, 0, 0 } } }; [EOL]     } [EOL]     final int vSize = valueCompiler.multIndirection.length; [EOL]     final int dSize = derivativeCompiler.multIndirection.length; [EOL]     final int[][][] multIndirection = new int[vSize + dSize][][]; [EOL]     System.arraycopy(valueCompiler.multIndirection, 0, multIndirection, 0, vSize); [EOL]     for (int i = 0; i < dSize; ++i) { [EOL]         final int[][] dRow = derivativeCompiler.multIndirection[i]; [EOL]         List<int[]> row = new ArrayList<int[]>(dRow.length * 2); [EOL]         for (int j = 0; j < dRow.length; ++j) { [EOL]             row.add(new int[] { dRow[j][0], lowerIndirection[dRow[j][1]], vSize + dRow[j][2] }); [EOL]             row.add(new int[] { dRow[j][0], vSize + dRow[j][1], lowerIndirection[dRow[j][2]] }); [EOL]         } [EOL]         final List<int[]> combined = new ArrayList<int[]>(row.size()); [EOL]         for (int j = 0; j < row.size(); ++j) { [EOL]             final int[] termJ = row.get(j); [EOL]             if (termJ[0] > 0) { [EOL]                 for (int k = j + 1; k < row.size(); ++k) { [EOL]                     final int[] termK = row.get(k); [EOL]                     if (termJ[1] == termK[1] && termJ[2] == termK[2]) { [EOL]                         termJ[0] += termK[0]; [EOL]                         termK[0] = 0; [EOL]                     } [EOL]                 } [EOL]                 combined.add(termJ); [EOL]             } [EOL]         } [EOL]         multIndirection[vSize + i] = combined.toArray(new int[combined.size()][]); [EOL]     } [EOL]     return multIndirection; [EOL] } <line_num>: 346,394
private static int[][][] compileCompositionIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler, final int[][] sizes, final int[][] derivativesIndirection) throws NumberIsTooLargeException { [EOL]     if ((parameters == 0) || (order == 0)) { [EOL]         return new int[][][] { { { 1, 0 } } }; [EOL]     } [EOL]     final int vSize = valueCompiler.compIndirection.length; [EOL]     final int dSize = derivativeCompiler.compIndirection.length; [EOL]     final int[][][] compIndirection = new int[vSize + dSize][][]; [EOL]     System.arraycopy(valueCompiler.compIndirection, 0, compIndirection, 0, vSize); [EOL]     for (int i = 0; i < dSize; ++i) { [EOL]         List<int[]> row = new ArrayList<int[]>(); [EOL]         for (int[] term : derivativeCompiler.compIndirection[i]) { [EOL]             int[] derivedTermF = new int[term.length + 1]; [EOL]             derivedTermF[0] = term[0]; [EOL]             derivedTermF[1] = term[1] + 1; [EOL]             int[] orders = new int[parameters]; [EOL]             orders[parameters - 1] = 1; [EOL]             derivedTermF[term.length] = getPartialDerivativeIndex(parameters, order, sizes, orders); [EOL]             for (int j = 2; j < term.length; ++j) { [EOL]                 derivedTermF[j] = convertIndex(term[j], parameters, derivativeCompiler.derivativesIndirection, parameters, order, sizes); [EOL]             } [EOL]             Arrays.sort(derivedTermF, 2, derivedTermF.length); [EOL]             row.add(derivedTermF); [EOL]             for (int l = 2; l < term.length; ++l) { [EOL]                 int[] derivedTermG = new int[term.length]; [EOL]                 derivedTermG[0] = term[0]; [EOL]                 derivedTermG[1] = term[1]; [EOL]                 for (int j = 2; j < term.length; ++j) { [EOL]                     derivedTermG[j] = convertIndex(term[j], parameters, derivativeCompiler.derivativesIndirection, parameters, order, sizes); [EOL]                     if (j == l) { [EOL]                         System.arraycopy(derivativesIndirection[derivedTermG[j]], 0, orders, 0, parameters); [EOL]                         orders[parameters - 1]++; [EOL]                         derivedTermG[j] = getPartialDerivativeIndex(parameters, order, sizes, orders); [EOL]                     } [EOL]                 } [EOL]                 Arrays.sort(derivedTermG, 2, derivedTermG.length); [EOL]                 row.add(derivedTermG); [EOL]             } [EOL]         } [EOL]         final List<int[]> combined = new ArrayList<int[]>(row.size()); [EOL]         for (int j = 0; j < row.size(); ++j) { [EOL]             final int[] termJ = row.get(j); [EOL]             if (termJ[0] > 0) { [EOL]                 for (int k = j + 1; k < row.size(); ++k) { [EOL]                     final int[] termK = row.get(k); [EOL]                     boolean equals = termJ.length == termK.length; [EOL]                     for (int l = 1; equals && l < termJ.length; ++l) { [EOL]                         equals &= termJ[l] == termK[l]; [EOL]                     } [EOL]                     if (equals) { [EOL]                         termJ[0] += termK[0]; [EOL]                         termK[0] = 0; [EOL]                     } [EOL]                 } [EOL]                 combined.add(termJ); [EOL]             } [EOL]         } [EOL]         compIndirection[vSize + i] = combined.toArray(new int[combined.size()][]); [EOL]     } [EOL]     return compIndirection; [EOL] } <line_num>: 411,508
public int getPartialDerivativeIndex(final int... orders) throws DimensionMismatchException, NumberIsTooLargeException { [EOL]     if (orders.length != getFreeParameters()) { [EOL]         throw new DimensionMismatchException(orders.length, getFreeParameters()); [EOL]     } [EOL]     return getPartialDerivativeIndex(parameters, order, sizes, orders); [EOL] } <line_num>: 542,552
private static int getPartialDerivativeIndex(final int parameters, final int order, final int[][] sizes, final int... orders) throws NumberIsTooLargeException { [EOL]     int index = 0; [EOL]     int m = order; [EOL]     int ordersSum = 0; [EOL]     for (int i = parameters - 1; i >= 0; --i) { [EOL]         int derivativeOrder = orders[i]; [EOL]         ordersSum += derivativeOrder; [EOL]         if (ordersSum > order) { [EOL]             throw new NumberIsTooLargeException(ordersSum, order, true); [EOL]         } [EOL]         while (derivativeOrder-- > 0) { [EOL]             index += sizes[i][m--]; [EOL]         } [EOL]     } [EOL]     return index; [EOL] } <line_num>: 564,595
private static int convertIndex(final int index, final int srcP, final int[][] srcDerivativesIndirection, final int destP, final int destO, final int[][] destSizes) throws NumberIsTooLargeException { [EOL]     int[] orders = new int[destP]; [EOL]     System.arraycopy(srcDerivativesIndirection[index], 0, orders, 0, FastMath.min(srcP, destP)); [EOL]     return getPartialDerivativeIndex(destP, destO, destSizes, orders); [EOL] } <line_num>: 609,616
public int[] getPartialDerivativeOrders(final int index) { [EOL]     return derivativesIndirection[index]; [EOL] } <line_num>: 626,628
public int getFreeParameters() { [EOL]     return parameters; [EOL] } <line_num>: 633,635
public int getOrder() { [EOL]     return order; [EOL] } <line_num>: 640,642
public int getSize() { [EOL]     return sizes[parameters][order]; [EOL] } <line_num>: 651,653
public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double[] result, final int resultOffset) { [EOL]     for (int i = 0; i < getSize(); ++i) { [EOL]         result[resultOffset + i] = MathArrays.linearCombination(a1, c1[offset1 + i], a2, c2[offset2 + i]); [EOL]     } [EOL] } <line_num>: 667,674
public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double a3, final double[] c3, final int offset3, final double[] result, final int resultOffset) { [EOL]     for (int i = 0; i < getSize(); ++i) { [EOL]         result[resultOffset + i] = MathArrays.linearCombination(a1, c1[offset1 + i], a2, c2[offset2 + i], a3, c3[offset3 + i]); [EOL]     } [EOL] } <line_num>: 691,701
public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double a3, final double[] c3, final int offset3, final double a4, final double[] c4, final int offset4, final double[] result, final int resultOffset) { [EOL]     for (int i = 0; i < getSize(); ++i) { [EOL]         result[resultOffset + i] = MathArrays.linearCombination(a1, c1[offset1 + i], a2, c2[offset2 + i], a3, c3[offset3 + i], a4, c4[offset4 + i]); [EOL]     } [EOL] } <line_num>: 721,733
public void add(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) { [EOL]     for (int i = 0; i < getSize(); ++i) { [EOL]         result[resultOffset + i] = lhs[lhsOffset + i] + rhs[rhsOffset + i]; [EOL]     } [EOL] } <line_num>: 744,750
public void subtract(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) { [EOL]     for (int i = 0; i < getSize(); ++i) { [EOL]         result[resultOffset + i] = lhs[lhsOffset + i] - rhs[rhsOffset + i]; [EOL]     } [EOL] } <line_num>: 760,766
public void multiply(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) { [EOL]     for (int i = 0; i < multIndirection.length; ++i) { [EOL]         final int[][] mappingI = multIndirection[i]; [EOL]         double r = 0; [EOL]         for (int j = 0; j < mappingI.length; ++j) { [EOL]             r += mappingI[j][0] * lhs[lhsOffset + mappingI[j][1]] * rhs[rhsOffset + mappingI[j][2]]; [EOL]         } [EOL]         result[resultOffset + i] = r; [EOL]     } [EOL] } <line_num>: 778,791
public void divide(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) { [EOL]     final double[] reciprocal = new double[getSize()]; [EOL]     pow(rhs, lhsOffset, -1, reciprocal, 0); [EOL]     multiply(lhs, lhsOffset, reciprocal, 0, result, resultOffset); [EOL] } <line_num>: 803,809
public void remainder(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) { [EOL]     final double rem = FastMath.IEEEremainder(lhs[lhsOffset], rhs[rhsOffset]); [EOL]     final double k = FastMath.rint((lhs[lhsOffset] - rem) / rhs[rhsOffset]); [EOL]     result[resultOffset] = rem; [EOL]     for (int i = 1; i < getSize(); ++i) { [EOL]         result[resultOffset + i] = lhs[lhsOffset + i] - k * rhs[rhsOffset + i]; [EOL]     } [EOL] } <line_num>: 820,836
public void pow(final double a, final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     final double[] function = new double[1 + order]; [EOL]     if (a == 0) { [EOL]         if (operand[operandOffset] == 0) { [EOL]             function[0] = 1; [EOL]             double infinity = Double.POSITIVE_INFINITY; [EOL]             for (int i = 1; i < function.length; ++i) { [EOL]                 infinity = -infinity; [EOL]                 function[i] = infinity; [EOL]             } [EOL]         } else if (operand[operandOffset] < 0) { [EOL]             Arrays.fill(function, Double.NaN); [EOL]         } [EOL]     } else { [EOL]         function[0] = FastMath.pow(a, operand[operandOffset]); [EOL]         final double lnA = FastMath.log(a); [EOL]         for (int i = 1; i < function.length; ++i) { [EOL]             function[i] = lnA * function[i - 1]; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 848,878
public void pow(final double[] operand, final int operandOffset, final double p, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     double xk = FastMath.pow(operand[operandOffset], p - order); [EOL]     for (int i = order; i > 0; --i) { [EOL]         function[i] = xk; [EOL]         xk *= operand[operandOffset]; [EOL]     } [EOL]     function[0] = xk; [EOL]     double coefficient = p; [EOL]     for (int i = 1; i <= order; ++i) { [EOL]         function[i] *= coefficient; [EOL]         coefficient *= p - i; [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 889,910
public void pow(final double[] operand, final int operandOffset, final int n, final double[] result, final int resultOffset) { [EOL]     if (n == 0) { [EOL]         result[resultOffset] = 1.0; [EOL]         Arrays.fill(result, resultOffset + 1, resultOffset + getSize(), 0); [EOL]         return; [EOL]     } [EOL]     double[] function = new double[1 + order]; [EOL]     if (n > 0) { [EOL]         final int maxOrder = FastMath.min(order, n); [EOL]         double xk = FastMath.pow(operand[operandOffset], n - maxOrder); [EOL]         for (int i = maxOrder; i > 0; --i) { [EOL]             function[i] = xk; [EOL]             xk *= operand[operandOffset]; [EOL]         } [EOL]         function[0] = xk; [EOL]     } else { [EOL]         final double inv = 1.0 / operand[operandOffset]; [EOL]         double xk = FastMath.pow(inv, -n); [EOL]         for (int i = 0; i <= order; ++i) { [EOL]             function[i] = xk; [EOL]             xk *= inv; [EOL]         } [EOL]     } [EOL]     double coefficient = n; [EOL]     for (int i = 1; i <= order; ++i) { [EOL]         function[i] *= coefficient; [EOL]         coefficient *= n - i; [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 921,963
public void pow(final double[] x, final int xOffset, final double[] y, final int yOffset, final double[] result, final int resultOffset) { [EOL]     final double[] logX = new double[getSize()]; [EOL]     log(x, xOffset, logX, 0); [EOL]     final double[] yLogX = new double[getSize()]; [EOL]     multiply(logX, 0, y, yOffset, yLogX, 0); [EOL]     exp(yLogX, 0, result, resultOffset); [EOL] } <line_num>: 975,983
public void rootN(final double[] operand, final int operandOffset, final int n, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     double xk; [EOL]     if (n == 2) { [EOL]         function[0] = FastMath.sqrt(operand[operandOffset]); [EOL]         xk = 0.5 / function[0]; [EOL]     } else if (n == 3) { [EOL]         function[0] = FastMath.cbrt(operand[operandOffset]); [EOL]         xk = 1.0 / (3.0 * function[0] * function[0]); [EOL]     } else { [EOL]         function[0] = FastMath.pow(operand[operandOffset], 1.0 / n); [EOL]         xk = 1.0 / (n * FastMath.pow(function[0], n - 1)); [EOL]     } [EOL]     final double nReciprocal = 1.0 / n; [EOL]     final double xReciprocal = 1.0 / operand[operandOffset]; [EOL]     for (int i = 1; i <= order; ++i) { [EOL]         function[i] = xk; [EOL]         xk *= xReciprocal * (nReciprocal - i); [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 994,1021
public void exp(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     Arrays.fill(function, FastMath.exp(operand[operandOffset])); [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1031,1041
public void expm1(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.expm1(operand[operandOffset]); [EOL]     Arrays.fill(function, 1, 1 + order, FastMath.exp(operand[operandOffset])); [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1051,1062
public void log(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.log(operand[operandOffset]); [EOL]     if (order > 0) { [EOL]         double inv = 1.0 / operand[operandOffset]; [EOL]         double xk = inv; [EOL]         for (int i = 1; i <= order; ++i) { [EOL]             function[i] = xk; [EOL]             xk *= -i * inv; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1072,1090
public void log1p(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.log1p(operand[operandOffset]); [EOL]     if (order > 0) { [EOL]         double inv = 1.0 / (1.0 + operand[operandOffset]); [EOL]         double xk = inv; [EOL]         for (int i = 1; i <= order; ++i) { [EOL]             function[i] = xk; [EOL]             xk *= -i * inv; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1099,1117
public void log10(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.log10(operand[operandOffset]); [EOL]     if (order > 0) { [EOL]         double inv = 1.0 / operand[operandOffset]; [EOL]         double xk = inv / FastMath.log(10.0); [EOL]         for (int i = 1; i <= order; ++i) { [EOL]             function[i] = xk; [EOL]             xk *= -i * inv; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1126,1144
public void cos(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.cos(operand[operandOffset]); [EOL]     if (order > 0) { [EOL]         function[1] = -FastMath.sin(operand[operandOffset]); [EOL]         for (int i = 2; i <= order; ++i) { [EOL]             function[i] = -function[i - 2]; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1154,1170
public void sin(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.sin(operand[operandOffset]); [EOL]     if (order > 0) { [EOL]         function[1] = FastMath.cos(operand[operandOffset]); [EOL]         for (int i = 2; i <= order; ++i) { [EOL]             function[i] = -function[i - 2]; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1180,1196
public void tan(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     final double[] function = new double[1 + order]; [EOL]     final double t = FastMath.tan(operand[operandOffset]); [EOL]     function[0] = t; [EOL]     if (order > 0) { [EOL]         final double[] p = new double[order + 2]; [EOL]         p[1] = 1; [EOL]         final double t2 = t * t; [EOL]         for (int n = 1; n <= order; ++n) { [EOL]             double v = 0; [EOL]             p[n + 1] = n * p[n]; [EOL]             for (int k = n + 1; k >= 0; k -= 2) { [EOL]                 v = v * t2 + p[k]; [EOL]                 if (k > 2) { [EOL]                     p[k - 2] = (k - 1) * p[k - 1] + (k - 3) * p[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     p[0] = p[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= t; [EOL]             } [EOL]             function[n] = v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1206,1251
public void acos(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     final double x = operand[operandOffset]; [EOL]     function[0] = FastMath.acos(x); [EOL]     if (order > 0) { [EOL]         final double[] p = new double[order]; [EOL]         p[0] = -1; [EOL]         final double x2 = x * x; [EOL]         final double f = 1.0 / (1 - x2); [EOL]         double coeff = FastMath.sqrt(f); [EOL]         function[1] = coeff * p[0]; [EOL]         for (int n = 2; n <= order; ++n) { [EOL]             double v = 0; [EOL]             p[n - 1] = (n - 1) * p[n - 2]; [EOL]             for (int k = n - 1; k >= 0; k -= 2) { [EOL]                 v = v * x2 + p[k]; [EOL]                 if (k > 2) { [EOL]                     p[k - 2] = (k - 1) * p[k - 1] + (2 * n - k) * p[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     p[0] = p[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= x; [EOL]             } [EOL]             coeff *= f; [EOL]             function[n] = coeff * v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1261,1308
public void asin(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     final double x = operand[operandOffset]; [EOL]     function[0] = FastMath.asin(x); [EOL]     if (order > 0) { [EOL]         final double[] p = new double[order]; [EOL]         p[0] = 1; [EOL]         final double x2 = x * x; [EOL]         final double f = 1.0 / (1 - x2); [EOL]         double coeff = FastMath.sqrt(f); [EOL]         function[1] = coeff * p[0]; [EOL]         for (int n = 2; n <= order; ++n) { [EOL]             double v = 0; [EOL]             p[n - 1] = (n - 1) * p[n - 2]; [EOL]             for (int k = n - 1; k >= 0; k -= 2) { [EOL]                 v = v * x2 + p[k]; [EOL]                 if (k > 2) { [EOL]                     p[k - 2] = (k - 1) * p[k - 1] + (2 * n - k) * p[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     p[0] = p[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= x; [EOL]             } [EOL]             coeff *= f; [EOL]             function[n] = coeff * v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1318,1365
public void atan(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     final double x = operand[operandOffset]; [EOL]     function[0] = FastMath.atan(x); [EOL]     if (order > 0) { [EOL]         final double[] q = new double[order]; [EOL]         q[0] = 1; [EOL]         final double x2 = x * x; [EOL]         final double f = 1.0 / (1 + x2); [EOL]         double coeff = f; [EOL]         function[1] = coeff * q[0]; [EOL]         for (int n = 2; n <= order; ++n) { [EOL]             double v = 0; [EOL]             q[n - 1] = -n * q[n - 2]; [EOL]             for (int k = n - 1; k >= 0; k -= 2) { [EOL]                 v = v * x2 + q[k]; [EOL]                 if (k > 2) { [EOL]                     q[k - 2] = (k - 1) * q[k - 1] + (k - 1 - 2 * n) * q[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     q[0] = q[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= x; [EOL]             } [EOL]             coeff *= f; [EOL]             function[n] = coeff * v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1375,1422
public void atan2(final double[] y, final int yOffset, final double[] x, final int xOffset, final double[] result, final int resultOffset) { [EOL]     double[] tmp1 = new double[getSize()]; [EOL]     multiply(x, xOffset, x, xOffset, tmp1, 0); [EOL]     double[] tmp2 = new double[getSize()]; [EOL]     multiply(y, yOffset, y, yOffset, tmp2, 0); [EOL]     add(tmp1, 0, tmp2, 0, tmp2, 0); [EOL]     rootN(tmp2, 0, 2, tmp1, 0); [EOL]     if (x[xOffset] >= 0) { [EOL]         add(tmp1, 0, x, xOffset, tmp2, 0); [EOL]         divide(y, yOffset, tmp2, 0, tmp1, 0); [EOL]         atan(tmp1, 0, tmp2, 0); [EOL]         for (int i = 0; i < tmp2.length; ++i) { [EOL]             result[resultOffset + i] = 2 * tmp2[i]; [EOL]         } [EOL]     } else { [EOL]         subtract(tmp1, 0, x, xOffset, tmp2, 0); [EOL]         divide(y, yOffset, tmp2, 0, tmp1, 0); [EOL]         atan(tmp1, 0, tmp2, 0); [EOL]         result[resultOffset] = ((tmp2[0] <= 0) ? -FastMath.PI : FastMath.PI) - 2 * tmp2[0]; [EOL]         for (int i = 1; i < tmp2.length; ++i) { [EOL]             result[resultOffset + i] = -2 * tmp2[i]; [EOL]         } [EOL]     } [EOL]     result[resultOffset] = FastMath.atan2(y[yOffset], x[xOffset]); [EOL] } <line_num>: 1434,1473
public void cosh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.cosh(operand[operandOffset]); [EOL]     if (order > 0) { [EOL]         function[1] = FastMath.sinh(operand[operandOffset]); [EOL]         for (int i = 2; i <= order; ++i) { [EOL]             function[i] = function[i - 2]; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1483,1499
public void sinh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     function[0] = FastMath.sinh(operand[operandOffset]); [EOL]     if (order > 0) { [EOL]         function[1] = FastMath.cosh(operand[operandOffset]); [EOL]         for (int i = 2; i <= order; ++i) { [EOL]             function[i] = function[i - 2]; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1509,1525
public void tanh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     final double[] function = new double[1 + order]; [EOL]     final double t = FastMath.tanh(operand[operandOffset]); [EOL]     function[0] = t; [EOL]     if (order > 0) { [EOL]         final double[] p = new double[order + 2]; [EOL]         p[1] = 1; [EOL]         final double t2 = t * t; [EOL]         for (int n = 1; n <= order; ++n) { [EOL]             double v = 0; [EOL]             p[n + 1] = -n * p[n]; [EOL]             for (int k = n + 1; k >= 0; k -= 2) { [EOL]                 v = v * t2 + p[k]; [EOL]                 if (k > 2) { [EOL]                     p[k - 2] = (k - 1) * p[k - 1] - (k - 3) * p[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     p[0] = p[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= t; [EOL]             } [EOL]             function[n] = v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1535,1580
public void acosh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     final double x = operand[operandOffset]; [EOL]     function[0] = FastMath.acosh(x); [EOL]     if (order > 0) { [EOL]         final double[] p = new double[order]; [EOL]         p[0] = 1; [EOL]         final double x2 = x * x; [EOL]         final double f = 1.0 / (x2 - 1); [EOL]         double coeff = FastMath.sqrt(f); [EOL]         function[1] = coeff * p[0]; [EOL]         for (int n = 2; n <= order; ++n) { [EOL]             double v = 0; [EOL]             p[n - 1] = (1 - n) * p[n - 2]; [EOL]             for (int k = n - 1; k >= 0; k -= 2) { [EOL]                 v = v * x2 + p[k]; [EOL]                 if (k > 2) { [EOL]                     p[k - 2] = (1 - k) * p[k - 1] + (k - 2 * n) * p[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     p[0] = -p[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= x; [EOL]             } [EOL]             coeff *= f; [EOL]             function[n] = coeff * v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1590,1637
public void asinh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     final double x = operand[operandOffset]; [EOL]     function[0] = FastMath.asinh(x); [EOL]     if (order > 0) { [EOL]         final double[] p = new double[order]; [EOL]         p[0] = 1; [EOL]         final double x2 = x * x; [EOL]         final double f = 1.0 / (1 + x2); [EOL]         double coeff = FastMath.sqrt(f); [EOL]         function[1] = coeff * p[0]; [EOL]         for (int n = 2; n <= order; ++n) { [EOL]             double v = 0; [EOL]             p[n - 1] = (1 - n) * p[n - 2]; [EOL]             for (int k = n - 1; k >= 0; k -= 2) { [EOL]                 v = v * x2 + p[k]; [EOL]                 if (k > 2) { [EOL]                     p[k - 2] = (k - 1) * p[k - 1] + (k - 2 * n) * p[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     p[0] = p[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= x; [EOL]             } [EOL]             coeff *= f; [EOL]             function[n] = coeff * v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1647,1694
public void atanh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) { [EOL]     double[] function = new double[1 + order]; [EOL]     final double x = operand[operandOffset]; [EOL]     function[0] = FastMath.atanh(x); [EOL]     if (order > 0) { [EOL]         final double[] q = new double[order]; [EOL]         q[0] = 1; [EOL]         final double x2 = x * x; [EOL]         final double f = 1.0 / (1 - x2); [EOL]         double coeff = f; [EOL]         function[1] = coeff * q[0]; [EOL]         for (int n = 2; n <= order; ++n) { [EOL]             double v = 0; [EOL]             q[n - 1] = n * q[n - 2]; [EOL]             for (int k = n - 1; k >= 0; k -= 2) { [EOL]                 v = v * x2 + q[k]; [EOL]                 if (k > 2) { [EOL]                     q[k - 2] = (k - 1) * q[k - 1] + (2 * n - k + 1) * q[k - 3]; [EOL]                 } else if (k == 2) { [EOL]                     q[0] = q[1]; [EOL]                 } [EOL]             } [EOL]             if ((n & 0x1) == 0) { [EOL]                 v *= x; [EOL]             } [EOL]             coeff *= f; [EOL]             function[n] = coeff * v; [EOL]         } [EOL]     } [EOL]     compose(operand, operandOffset, function, result, resultOffset); [EOL] } <line_num>: 1704,1751
public void compose(final double[] operand, final int operandOffset, final double[] f, final double[] result, final int resultOffset) { [EOL]     for (int i = 0; i < compIndirection.length; ++i) { [EOL]         final int[][] mappingI = compIndirection[i]; [EOL]         double r = 0; [EOL]         for (int j = 0; j < mappingI.length; ++j) { [EOL]             final int[] mappingIJ = mappingI[j]; [EOL]             double product = mappingIJ[0] * f[mappingIJ[1]]; [EOL]             for (int k = 2; k < mappingIJ.length; ++k) { [EOL]                 product *= operand[operandOffset + mappingIJ[k]]; [EOL]             } [EOL]             r += product; [EOL]         } [EOL]         result[resultOffset + i] = r; [EOL]     } [EOL] } <line_num>: 1763,1778
public double taylor(final double[] ds, final int dsOffset, final double... delta) throws MathArithmeticException { [EOL]     double value = 0; [EOL]     for (int i = getSize() - 1; i >= 0; --i) { [EOL]         final int[] orders = getPartialDerivativeOrders(i); [EOL]         double term = ds[dsOffset + i]; [EOL]         for (int k = 0; k < orders.length; ++k) { [EOL]             if (orders[k] > 0) { [EOL]                 try { [EOL]                     term *= FastMath.pow(delta[k], orders[k]) / CombinatoricsUtils.factorial(orders[k]); [EOL]                 } catch (NotPositiveException e) { [EOL]                     throw new MathInternalError(e); [EOL]                 } [EOL]             } [EOL]         } [EOL]         value += term; [EOL]     } [EOL]     return value; [EOL] } <line_num>: 1787,1807
public void checkCompatibility(final DSCompiler compiler) throws DimensionMismatchException { [EOL]     if (parameters != compiler.parameters) { [EOL]         throw new DimensionMismatchException(parameters, compiler.parameters); [EOL]     } [EOL]     if (order != compiler.order) { [EOL]         throw new DimensionMismatchException(order, compiler.order); [EOL]     } [EOL] } <line_num>: 1813,1821
