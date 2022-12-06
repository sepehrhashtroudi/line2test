@Test [EOL] public void testSinZero() { [EOL]     UnivariateFunction f = new Sin(); [EOL]     double result; [EOL]     UnivariateSolver solver = new BrentSolver(); [EOL]     result = solver.solve(100, f, 3, 4); [EOL]     Assert.assertEquals(result, FastMath.PI, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 7); [EOL]     result = solver.solve(100, f, 1, 4); [EOL]     Assert.assertEquals(result, FastMath.PI, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 8); [EOL] } <line_num>: 48,68
@Test [EOL] public void testQuinticZero() { [EOL]     UnivariateFunction f = new QuinticFunction(); [EOL]     double result; [EOL]     UnivariateSolver solver = new BrentSolver(); [EOL]     result = solver.solve(100, f, -0.2, 0.2); [EOL]     Assert.assertEquals(result, 0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 3); [EOL]     result = solver.solve(100, f, -0.1, 0.3); [EOL]     Assert.assertEquals(result, 0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 7); [EOL]     result = solver.solve(100, f, -0.3, 0.45); [EOL]     Assert.assertEquals(result, 0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 8); [EOL]     result = solver.solve(100, f, 0.3, 0.7); [EOL]     Assert.assertEquals(result, 0.5, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 9); [EOL]     result = solver.solve(100, f, 0.2, 0.6); [EOL]     Assert.assertEquals(result, 0.5, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 10); [EOL]     result = solver.solve(100, f, 0.05, 0.95); [EOL]     Assert.assertEquals(result, 0.5, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 11); [EOL]     result = solver.solve(100, f, 0.85, 1.25); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 11); [EOL]     result = solver.solve(100, f, 0.8, 1.2); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 11); [EOL]     result = solver.solve(100, f, 0.85, 1.75); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 13); [EOL]     result = solver.solve(100, f, 0.55, 1.45); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 10); [EOL]     result = solver.solve(100, f, 0.85, 5); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(solver.getEvaluations() <= 15); [EOL]     try { [EOL]         result = solver.solve(5, f, 0.85, 5); [EOL]         Assert.fail("Expected TooManyEvaluationsException"); [EOL]     } catch (TooManyEvaluationsException e) { [EOL]     } [EOL] } <line_num>: 70,162
@Test [EOL] public void testRootEndpoints() { [EOL]     UnivariateFunction f = new Sin(); [EOL]     BrentSolver solver = new BrentSolver(); [EOL]     double result = solver.solve(100, f, FastMath.PI, 4); [EOL]     Assert.assertEquals(FastMath.PI, result, solver.getAbsoluteAccuracy()); [EOL]     result = solver.solve(100, f, 3, FastMath.PI); [EOL]     Assert.assertEquals(FastMath.PI, result, solver.getAbsoluteAccuracy()); [EOL]     result = solver.solve(100, f, FastMath.PI, 4, 3.5); [EOL]     Assert.assertEquals(FastMath.PI, result, solver.getAbsoluteAccuracy()); [EOL]     result = solver.solve(100, f, 3, FastMath.PI, 3.07); [EOL]     Assert.assertEquals(FastMath.PI, result, solver.getAbsoluteAccuracy()); [EOL] } <line_num>: 164,181
@Test [EOL] public void testBadEndpoints() { [EOL]     UnivariateFunction f = new Sin(); [EOL]     BrentSolver solver = new BrentSolver(); [EOL]     try { [EOL]         solver.solve(100, f, 1, -1); [EOL]         Assert.fail("Expecting NumberIsTooLargeException - bad interval"); [EOL]     } catch (NumberIsTooLargeException ex) { [EOL]     } [EOL]     try { [EOL]         solver.solve(100, f, 1, 1.5); [EOL]         Assert.fail("Expecting NoBracketingException - non-bracketing"); [EOL]     } catch (NoBracketingException ex) { [EOL]     } [EOL]     try { [EOL]         solver.solve(100, f, 1, 1.5, 1.2); [EOL]         Assert.fail("Expecting NoBracketingException - non-bracketing"); [EOL]     } catch (NoBracketingException ex) { [EOL]     } [EOL] } <line_num>: 183,205
@Test [EOL] public void testInitialGuess() { [EOL]     MonitoredFunction f = new MonitoredFunction(new QuinticFunction()); [EOL]     BrentSolver solver = new BrentSolver(); [EOL]     double result; [EOL]     result = solver.solve(100, f, 0.6, 7.0); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     int referenceCallsCount = f.getCallsCount(); [EOL]     Assert.assertTrue(referenceCallsCount >= 13); [EOL]     try { [EOL]         result = solver.solve(100, f, 0.6, 7.0, 0.0); [EOL]         Assert.fail("a NumberIsTooLargeException was expected"); [EOL]     } catch (NumberIsTooLargeException iae) { [EOL]     } [EOL]     f.setCallsCount(0); [EOL]     result = solver.solve(100, f, 0.6, 7.0, 0.61); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(f.getCallsCount() > referenceCallsCount); [EOL]     f.setCallsCount(0); [EOL]     result = solver.solve(100, f, 0.6, 7.0, 0.999999); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertTrue(f.getCallsCount() < referenceCallsCount); [EOL]     f.setCallsCount(0); [EOL]     result = solver.solve(100, f, 0.6, 7.0, 1.0); [EOL]     Assert.assertEquals(result, 1.0, solver.getAbsoluteAccuracy()); [EOL]     Assert.assertEquals(1, solver.getEvaluations()); [EOL]     Assert.assertEquals(1, f.getCallsCount()); [EOL] } <line_num>: 207,245
public double value(double x) { [EOL]     return func.value(new DerivativeStructure(1, 1, 0, x)).getPartialDerivative(1); [EOL] } <line_num>: 258,260
@Test [EOL] public void testMath832() { [EOL]     final UnivariateFunction f = new UnivariateFunction() { [EOL]  [EOL]         private final UnivariateDifferentiableFunction sqrt = new Sqrt(); [EOL]  [EOL]         private final UnivariateDifferentiableFunction inv = new Inverse(); [EOL]  [EOL]         private final UnivariateDifferentiableFunction func = FunctionUtils.add(FunctionUtils.multiply(new Constant(1e2), sqrt), FunctionUtils.multiply(new Constant(1e6), inv), FunctionUtils.multiply(new Constant(1e4), FunctionUtils.compose(inv, sqrt))); [EOL]  [EOL]         public double value(double x) { [EOL]             return func.value(new DerivativeStructure(1, 1, 0, x)).getPartialDerivative(1); [EOL]         } [EOL]     }; [EOL]     BrentSolver solver = new BrentSolver(); [EOL]     final double result = solver.solve(99, f, 1, 1e30, 1 + 1e-10); [EOL]     Assert.assertEquals(804.93558250, result, 1e-8); [EOL] } <line_num>: 247,267