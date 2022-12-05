@Override [EOL] public GaussNewtonOptimizer createOptimizer() { [EOL]     return GaussNewtonOptimizer.create().withConvergenceChecker(new SimpleVectorValueChecker(1e-6, 1e-6)); [EOL] } <line_num>: 40,44
@Override [EOL] public int getMaxIterations() { [EOL]     return 1000; [EOL] } <line_num>: 46,49
@Override [EOL] @Test [EOL] public void testShallowCopy() { [EOL]     super.testShallowCopy(); [EOL]     final boolean useLU1 = false; [EOL]     final GaussNewtonOptimizer optim1 = createOptimizer().withLU(useLU1); [EOL]     final GaussNewtonOptimizer optim2 = optim1.shallowCopy(); [EOL]     Assert.assertTrue(optim1.getLU() == optim2.getLU()); [EOL]     final boolean useLU2 = true; [EOL]     optim2.withLU(useLU2); [EOL]     Assert.assertFalse(optim1.getLU() == optim2.getLU()); [EOL] } <line_num>: 51,71
@Override [EOL] @Test(expected = ConvergenceException.class) [EOL] public void testMoreEstimatedParametersSimple() { [EOL]     super.testMoreEstimatedParametersSimple(); [EOL] } <line_num>: 73,80
@Override [EOL] @Test(expected = ConvergenceException.class) [EOL] public void testMoreEstimatedParametersUnsorted() { [EOL]     super.testMoreEstimatedParametersUnsorted(); [EOL] } <line_num>: 82,89
@Test(expected = TooManyEvaluationsException.class) [EOL] public void testMaxEvaluations() throws Exception { [EOL]     CircleVectorial circle = new CircleVectorial(); [EOL]     circle.addPoint(30.0, 68.0); [EOL]     circle.addPoint(50.0, -6.0); [EOL]     circle.addPoint(110.0, -20.0); [EOL]     circle.addPoint(35.0, 15.0); [EOL]     circle.addPoint(45.0, 97.0); [EOL]     GaussNewtonOptimizer optimizer = createOptimizer().withConvergenceChecker(new SimpleVectorValueChecker(1e-30, 1e-30)).withMaxIterations(Integer.MAX_VALUE).withMaxEvaluations(100).withModelAndJacobian(circle.getModelFunction(), circle.getModelFunctionJacobian()).withTarget(new double[] { 0, 0, 0, 0, 0 }).withWeight(new DiagonalMatrix(new double[] { 1, 1, 1, 1, 1 })).withStartPoint(new double[] { 98.680, 47.345 }); [EOL]     optimizer.optimize(); [EOL] } <line_num>: 91,111
@Override [EOL] @Test(expected = ConvergenceException.class) [EOL] public void testCircleFittingBadInit() { [EOL]     super.testCircleFittingBadInit(); [EOL] } <line_num>: 113,120
@Override [EOL] @Test(expected = ConvergenceException.class) [EOL] public void testHahn1() throws IOException { [EOL]     super.testHahn1(); [EOL] } <line_num>: 122,131
