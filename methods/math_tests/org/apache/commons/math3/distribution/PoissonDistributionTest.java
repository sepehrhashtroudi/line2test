public PoissonDistributionTest() { [EOL]     setTolerance(1e-12); [EOL] } <line_num>: 39,41
@Override [EOL] public IntegerDistribution makeDistribution() { [EOL]     return new PoissonDistribution(DEFAULT_TEST_POISSON_PARAMETER); [EOL] } <line_num>: 46,49
@Override [EOL] public int[] makeDensityTestPoints() { [EOL]     return new int[] { -1, 0, 1, 2, 3, 4, 5, 10, 20 }; [EOL] } <line_num>: 54,57
@Override [EOL] public double[] makeDensityTestValues() { [EOL]     return new double[] { 0d, 0.0183156388887d, 0.073262555555d, 0.14652511111d, 0.195366814813d, 0.195366814813, 0.156293451851d, 0.00529247667642d, 8.27746364655e-09 }; [EOL] } <line_num>: 63,68
@Override [EOL] public int[] makeCumulativeTestPoints() { [EOL]     return new int[] { -1, 0, 1, 2, 3, 4, 5, 10, 20 }; [EOL] } <line_num>: 73,76
@Override [EOL] public double[] makeCumulativeTestValues() { [EOL]     return new double[] { 0d, 0.0183156388887d, 0.0915781944437d, 0.238103305554d, 0.433470120367d, 0.62883693518, 0.78513038703d, 0.99716023388d, 0.999999998077 }; [EOL] } <line_num>: 81,86
@Override [EOL] public double[] makeInverseCumulativeTestPoints() { [EOL]     IntegerDistribution dist = getDistribution(); [EOL]     return new double[] { 0d, 0.018315638886d, 0.018315638890d, 0.091578194441d, 0.091578194445d, 0.238103305552d, 0.238103305556d, dist.cumulativeProbability(3), dist.cumulativeProbability(4), dist.cumulativeProbability(5), dist.cumulativeProbability(10), dist.cumulativeProbability(20) }; [EOL] } <line_num>: 91,99
@Override [EOL] public int[] makeInverseCumulativeTestValues() { [EOL]     return new int[] { 0, 0, 1, 1, 2, 2, 3, 3, 4, 5, 10, 20 }; [EOL] } <line_num>: 104,107
@Test [EOL] public void testNormalApproximateProbability() { [EOL]     PoissonDistribution dist = new PoissonDistribution(100); [EOL]     double result = dist.normalApproximateProbability(110) - dist.normalApproximateProbability(89); [EOL]     Assert.assertEquals(0.706281887248, result, 1E-10); [EOL]     dist = new PoissonDistribution(10000); [EOL]     result = dist.normalApproximateProbability(10200) - dist.normalApproximateProbability(9899); [EOL]     Assert.assertEquals(0.820070051552, result, 1E-10); [EOL] } <line_num>: 114,125
@Test [EOL] public void testDegenerateInverseCumulativeProbability() { [EOL]     PoissonDistribution dist = new PoissonDistribution(DEFAULT_TEST_POISSON_PARAMETER); [EOL]     Assert.assertEquals(Integer.MAX_VALUE, dist.inverseCumulativeProbability(1.0d)); [EOL]     Assert.assertEquals(0, dist.inverseCumulativeProbability(0d)); [EOL] } <line_num>: 130,135
@Test(expected = NotStrictlyPositiveException.class) [EOL] public void testNegativeMean() { [EOL]     new PoissonDistribution(-1); [EOL] } <line_num>: 137,140
@Test [EOL] public void testMean() { [EOL]     PoissonDistribution dist = new PoissonDistribution(10.0); [EOL]     Assert.assertEquals(10.0, dist.getMean(), 0.0); [EOL] } <line_num>: 142,146
@Test [EOL] public void testLargeMeanCumulativeProbability() { [EOL]     double mean = 1.0; [EOL]     while (mean <= 10000000.0) { [EOL]         PoissonDistribution dist = new PoissonDistribution(mean); [EOL]         double x = mean * 2.0; [EOL]         double dx = x / 10.0; [EOL]         double p = Double.NaN; [EOL]         double sigma = FastMath.sqrt(mean); [EOL]         while (x >= 0) { [EOL]             try { [EOL]                 p = dist.cumulativeProbability((int) x); [EOL]                 Assert.assertFalse("NaN cumulative probability returned for mean = " + mean + " x = " + x, Double.isNaN(p)); [EOL]                 if (x > mean - 2 * sigma) { [EOL]                     Assert.assertTrue("Zero cum probaility returned for mean = " + mean + " x = " + x, p > 0); [EOL]                 } [EOL]             } catch (Exception ex) { [EOL]                 Assert.fail("mean of " + mean + " and x of " + x + " caused " + ex.getMessage()); [EOL]             } [EOL]             x -= dx; [EOL]         } [EOL]         mean *= 10.0; [EOL]     } [EOL] } <line_num>: 148,175
@Test [EOL] public void testCumulativeProbabilitySpecial() { [EOL]     PoissonDistribution dist; [EOL]     dist = new PoissonDistribution(9120); [EOL]     checkProbability(dist, 9075); [EOL]     checkProbability(dist, 9102); [EOL]     dist = new PoissonDistribution(5058); [EOL]     checkProbability(dist, 5044); [EOL]     dist = new PoissonDistribution(6986); [EOL]     checkProbability(dist, 6950); [EOL] } <line_num>: 180,190
private void checkProbability(PoissonDistribution dist, int x) { [EOL]     double p = dist.cumulativeProbability(x); [EOL]     Assert.assertFalse("NaN cumulative probability returned for mean = " + dist.getMean() + " x = " + x, Double.isNaN(p)); [EOL]     Assert.assertTrue("Zero cum probability returned for mean = " + dist.getMean() + " x = " + x, p > 0); [EOL] } <line_num>: 192,198
@Test [EOL] public void testLargeMeanInverseCumulativeProbability() { [EOL]     double mean = 1.0; [EOL]     while (mean <= 100000.0) { [EOL]         PoissonDistribution dist = new PoissonDistribution(mean); [EOL]         double p = 0.1; [EOL]         double dp = p; [EOL]         while (p < .99) { [EOL]             try { [EOL]                 int ret = dist.inverseCumulativeProbability(p); [EOL]                 Assert.assertTrue(p <= dist.cumulativeProbability(ret)); [EOL]                 Assert.assertTrue(p > dist.cumulativeProbability(ret - 1)); [EOL]             } catch (Exception ex) { [EOL]                 Assert.fail("mean of " + mean + " and p of " + p + " caused " + ex.getMessage()); [EOL]             } [EOL]             p += dp; [EOL]         } [EOL]         mean *= 10.0; [EOL]     } [EOL] } <line_num>: 200,220
@Test [EOL] public void testMoments() { [EOL]     final double tol = 1e-9; [EOL]     PoissonDistribution dist; [EOL]     dist = new PoissonDistribution(1); [EOL]     Assert.assertEquals(dist.getNumericalMean(), 1, tol); [EOL]     Assert.assertEquals(dist.getNumericalVariance(), 1, tol); [EOL]     dist = new PoissonDistribution(11.23); [EOL]     Assert.assertEquals(dist.getNumericalMean(), 11.23, tol); [EOL]     Assert.assertEquals(dist.getNumericalVariance(), 11.23, tol); [EOL] } <line_num>: 222,234
