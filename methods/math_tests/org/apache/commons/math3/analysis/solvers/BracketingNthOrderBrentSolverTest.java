protected TestFunction(final double root, final double min, final double max) { [EOL]     this.root = root; [EOL]     this.min = min; [EOL]     this.max = max; [EOL] } <line_num>: 186,190
@Override [EOL] protected UnivariateSolver getSolver() { [EOL]     return new BracketingNthOrderBrentSolver(); [EOL] } <line_num>: 36,39
@Override [EOL] protected int[] getQuinticEvalCounts() { [EOL]     return new int[] { 1, 3, 8, 1, 9, 4, 8, 1, 12, 1, 16 }; [EOL] } <line_num>: 42,45
@Test(expected = NumberIsTooSmallException.class) [EOL] public void testInsufficientOrder1() { [EOL]     new BracketingNthOrderBrentSolver(1.0e-10, 1); [EOL] } <line_num>: 47,50
@Test(expected = NumberIsTooSmallException.class) [EOL] public void testInsufficientOrder2() { [EOL]     new BracketingNthOrderBrentSolver(1.0e-10, 1.0e-10, 1); [EOL] } <line_num>: 52,55
@Test(expected = NumberIsTooSmallException.class) [EOL] public void testInsufficientOrder3() { [EOL]     new BracketingNthOrderBrentSolver(1.0e-10, 1.0e-10, 1.0e-10, 1); [EOL] } <line_num>: 57,60
@Test [EOL] public void testConstructorsOK() { [EOL]     Assert.assertEquals(2, new BracketingNthOrderBrentSolver(1.0e-10, 2).getMaximalOrder()); [EOL]     Assert.assertEquals(2, new BracketingNthOrderBrentSolver(1.0e-10, 1.0e-10, 2).getMaximalOrder()); [EOL]     Assert.assertEquals(2, new BracketingNthOrderBrentSolver(1.0e-10, 1.0e-10, 1.0e-10, 2).getMaximalOrder()); [EOL] } <line_num>: 62,67
@Test [EOL] public void testConvergenceOnFunctionAccuracy() { [EOL]     BracketingNthOrderBrentSolver solver = new BracketingNthOrderBrentSolver(1.0e-12, 1.0e-10, 0.001, 3); [EOL]     QuinticFunction f = new QuinticFunction(); [EOL]     double result = solver.solve(20, f, 0.2, 0.9, 0.4, AllowedSolution.BELOW_SIDE); [EOL]     Assert.assertEquals(0, f.value(result), solver.getFunctionValueAccuracy()); [EOL]     Assert.assertTrue(f.value(result) <= 0); [EOL]     Assert.assertTrue(result - 0.5 > solver.getAbsoluteAccuracy()); [EOL]     result = solver.solve(20, f, -0.9, -0.2, -0.4, AllowedSolution.ABOVE_SIDE); [EOL]     Assert.assertEquals(0, f.value(result), solver.getFunctionValueAccuracy()); [EOL]     Assert.assertTrue(f.value(result) >= 0); [EOL]     Assert.assertTrue(result + 0.5 < -solver.getAbsoluteAccuracy()); [EOL] } <line_num>: 69,82
public double value(double x) { [EOL]     return (2 * x + 1) / (1.0e9 * (x + 1)); [EOL] } <line_num>: 89,91
@Test [EOL] public void testIssue716() { [EOL]     BracketingNthOrderBrentSolver solver = new BracketingNthOrderBrentSolver(1.0e-12, 1.0e-10, 1.0e-22, 5); [EOL]     UnivariateFunction sharpTurn = new UnivariateFunction() { [EOL]  [EOL]         public double value(double x) { [EOL]             return (2 * x + 1) / (1.0e9 * (x + 1)); [EOL]         } [EOL]     }; [EOL]     double result = solver.solve(100, sharpTurn, -0.9999999, 30, 15, AllowedSolution.RIGHT_SIDE); [EOL]     Assert.assertEquals(0, sharpTurn.value(result), solver.getFunctionValueAccuracy()); [EOL]     Assert.assertTrue(sharpTurn.value(result) >= 0); [EOL]     Assert.assertEquals(-0.5, result, 1.0e-10); [EOL] } <line_num>: 84,97
@Override [EOL] public DerivativeStructure value(DerivativeStructure x) { [EOL]     return x.sin().subtract(x.multiply(0.5)); [EOL] } <line_num>: 108,111
@Override [EOL] public DerivativeStructure value(DerivativeStructure x) { [EOL]     return x.pow(5).add(x).subtract(10000); [EOL] } <line_num>: 114,117
@Override [EOL] public DerivativeStructure value(DerivativeStructure x) { [EOL]     return x.sqrt().subtract(x.reciprocal()).subtract(3); [EOL] } <line_num>: 120,123
@Override [EOL] public DerivativeStructure value(DerivativeStructure x) { [EOL]     return x.exp().add(x).subtract(20); [EOL] } <line_num>: 126,129
@Override [EOL] public DerivativeStructure value(DerivativeStructure x) { [EOL]     return x.log().add(x.sqrt()).subtract(5); [EOL] } <line_num>: 132,135
@Override [EOL] public DerivativeStructure value(DerivativeStructure x) { [EOL]     return x.subtract(1).multiply(x).multiply(x).subtract(1); [EOL] } <line_num>: 138,141
@Test [EOL] public void testFasterThanNewton() { [EOL]     compare(new TestFunction(0.0, -2, 2) { [EOL]  [EOL]         @Override [EOL]         public DerivativeStructure value(DerivativeStructure x) { [EOL]             return x.sin().subtract(x.multiply(0.5)); [EOL]         } [EOL]     }); [EOL]     compare(new TestFunction(6.3087771299726890947, -5, 10) { [EOL]  [EOL]         @Override [EOL]         public DerivativeStructure value(DerivativeStructure x) { [EOL]             return x.pow(5).add(x).subtract(10000); [EOL]         } [EOL]     }); [EOL]     compare(new TestFunction(9.6335955628326951924, 0.001, 10) { [EOL]  [EOL]         @Override [EOL]         public DerivativeStructure value(DerivativeStructure x) { [EOL]             return x.sqrt().subtract(x.reciprocal()).subtract(3); [EOL]         } [EOL]     }); [EOL]     compare(new TestFunction(2.8424389537844470678, -5, 5) { [EOL]  [EOL]         @Override [EOL]         public DerivativeStructure value(DerivativeStructure x) { [EOL]             return x.exp().add(x).subtract(20); [EOL]         } [EOL]     }); [EOL]     compare(new TestFunction(8.3094326942315717953, 0.001, 10) { [EOL]  [EOL]         @Override [EOL]         public DerivativeStructure value(DerivativeStructure x) { [EOL]             return x.log().add(x.sqrt()).subtract(5); [EOL]         } [EOL]     }); [EOL]     compare(new TestFunction(1.4655712318767680266, -0.5, 1.5) { [EOL]  [EOL]         @Override [EOL]         public DerivativeStructure value(DerivativeStructure x) { [EOL]             return x.subtract(1).multiply(x).multiply(x).subtract(1); [EOL]         } [EOL]     }); [EOL] } <line_num>: 99,144
private void compare(TestFunction f) { [EOL]     compare(f, f.getRoot(), f.getMin(), f.getMax()); [EOL] } <line_num>: 146,148
private void compare(final UnivariateDifferentiableFunction f, double root, double min, double max) { [EOL]     NewtonRaphsonSolver newton = new NewtonRaphsonSolver(1.0e-12); [EOL]     BracketingNthOrderBrentSolver bracketing = new BracketingNthOrderBrentSolver(1.0e-12, 1.0e-12, 1.0e-18, 5); [EOL]     double resultN; [EOL]     try { [EOL]         resultN = newton.solve(100, f, min, max); [EOL]     } catch (TooManyEvaluationsException tmee) { [EOL]         resultN = Double.NaN; [EOL]     } [EOL]     double resultB; [EOL]     try { [EOL]         resultB = bracketing.solve(100, f, min, max); [EOL]     } catch (TooManyEvaluationsException tmee) { [EOL]         resultB = Double.NaN; [EOL]     } [EOL]     Assert.assertEquals(root, resultN, newton.getAbsoluteAccuracy()); [EOL]     Assert.assertEquals(root, resultB, bracketing.getAbsoluteAccuracy()); [EOL]     final int weightedBracketingEvaluations = bracketing.getEvaluations(); [EOL]     final int weightedNewtonEvaluations = 2 * newton.getEvaluations(); [EOL]     Assert.assertTrue(weightedBracketingEvaluations < weightedNewtonEvaluations); [EOL] } <line_num>: 150,178
public double getRoot() { [EOL]     return root; [EOL] } <line_num>: 192,194
public double getMin() { [EOL]     return min; [EOL] } <line_num>: 196,198
public double getMax() { [EOL]     return max; [EOL] } <line_num>: 200,202
public double value(final double x) { [EOL]     return value(new DerivativeStructure(0, 0, x)).getValue(); [EOL] } <line_num>: 204,206
public abstract DerivativeStructure value(final DerivativeStructure t); <line_num>: 208,208