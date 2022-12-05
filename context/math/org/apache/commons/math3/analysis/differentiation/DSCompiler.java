private DSCompiler(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler) throws NumberIsTooLargeException
public static DSCompiler getCompiler(int parameters, int order) throws NumberIsTooLargeException
private static int[][] compileSizes(final int parameters, final int order, final DSCompiler valueCompiler)
private static int[][] compileDerivativesIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler)
private static int[] compileLowerIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler)
private static int[][][] compileMultiplicationIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler, final int[] lowerIndirection)
private static int[][][] compileCompositionIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler, final int[][] sizes, final int[][] derivativesIndirection) throws NumberIsTooLargeException
public int getPartialDerivativeIndex(final int... orders) throws DimensionMismatchException, NumberIsTooLargeException
private static int getPartialDerivativeIndex(final int parameters, final int order, final int[][] sizes, final int... orders) throws NumberIsTooLargeException
private static int convertIndex(final int index, final int srcP, final int[][] srcDerivativesIndirection, final int destP, final int destO, final int[][] destSizes) throws NumberIsTooLargeException
public int[] getPartialDerivativeOrders(final int index)
public int getFreeParameters()
public int getOrder()
public int getSize()
public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double[] result, final int resultOffset)
public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double a3, final double[] c3, final int offset3, final double[] result, final int resultOffset)
public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double a3, final double[] c3, final int offset3, final double a4, final double[] c4, final int offset4, final double[] result, final int resultOffset)
public void add(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset)
public void subtract(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset)
public void multiply(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset)
public void divide(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset)
public void remainder(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset)
public void pow(final double a, final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void pow(final double[] operand, final int operandOffset, final double p, final double[] result, final int resultOffset)
public void pow(final double[] operand, final int operandOffset, final int n, final double[] result, final int resultOffset)
public void pow(final double[] x, final int xOffset, final double[] y, final int yOffset, final double[] result, final int resultOffset)
public void rootN(final double[] operand, final int operandOffset, final int n, final double[] result, final int resultOffset)
public void exp(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void expm1(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void log(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void log1p(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void log10(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void cos(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void sin(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void tan(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void acos(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void asin(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void atan(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void atan2(final double[] y, final int yOffset, final double[] x, final int xOffset, final double[] result, final int resultOffset)
public void cosh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void sinh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void tanh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void acosh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void asinh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void atanh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset)
public void compose(final double[] operand, final int operandOffset, final double[] f, final double[] result, final int resultOffset)
public double taylor(final double[] ds, final int dsOffset, final double... delta) throws MathArithmeticException
public void checkCompatibility(final DSCompiler compiler) throws DimensionMismatchException
AtomicReference<DSCompiler[][]> compilers=Optional[new AtomicReference<DSCompiler[][]>(null)]
int parameters
int order
int[][] sizes
int[][] derivativesIndirection
int[] lowerIndirection
int[][][] multIndirection
int[][][] compIndirection
