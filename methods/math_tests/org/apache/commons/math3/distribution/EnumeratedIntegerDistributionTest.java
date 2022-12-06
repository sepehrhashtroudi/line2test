public EnumeratedIntegerDistributionTest() { [EOL]     testDistribution = new EnumeratedIntegerDistribution(new int[] { 3, -1, 3, 7, -2, 8 }, new double[] { 0.2, 0.2, 0.3, 0.3, 0.0, 0.0 }); [EOL] } <line_num>: 43,49
@Test [EOL] public void testExceptions() { [EOL]     EnumeratedIntegerDistribution invalid = null; [EOL]     try { [EOL]         new EnumeratedIntegerDistribution(new int[] { 1, 2 }, new double[] { 0.0 }); [EOL]         Assert.fail("Expected DimensionMismatchException"); [EOL]     } catch (DimensionMismatchException e) { [EOL]     } [EOL]     try { [EOL]         new EnumeratedIntegerDistribution(new int[] { 1, 2 }, new double[] { 0.0, -1.0 }); [EOL]         Assert.fail("Expected NotPositiveException"); [EOL]     } catch (NotPositiveException e) { [EOL]     } [EOL]     try { [EOL]         new EnumeratedIntegerDistribution(new int[] { 1, 2 }, new double[] { 0.0, 0.0 }); [EOL]         Assert.fail("Expected MathArithmeticException"); [EOL]     } catch (MathArithmeticException e) { [EOL]     } [EOL]     try { [EOL]         new EnumeratedIntegerDistribution(new int[] { 1, 2 }, new double[] { 0.0, Double.NaN }); [EOL]         Assert.fail("Expected NotANumberException"); [EOL]     } catch (NotANumberException e) { [EOL]     } [EOL]     try { [EOL]         new EnumeratedIntegerDistribution(new int[] { 1, 2 }, new double[] { 0.0, Double.POSITIVE_INFINITY }); [EOL]         Assert.fail("Expected NotFiniteNumberException"); [EOL]     } catch (NotFiniteNumberException e) { [EOL]     } [EOL]     Assert.assertNull("Expected non-initialized DiscreteRealDistribution", invalid); [EOL] } <line_num>: 55,84
@Test [EOL] public void testProbability() { [EOL]     int[] points = new int[] { -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8 }; [EOL]     double[] results = new double[] { 0, 0.2, 0, 0, 0, 0.5, 0, 0, 0, 0.3, 0 }; [EOL]     for (int p = 0; p < points.length; p++) { [EOL]         double probability = testDistribution.probability(points[p]); [EOL]         Assert.assertEquals(results[p], probability, 0.0); [EOL]     } [EOL] } <line_num>: 89,97
@Test [EOL] public void testCumulativeProbability() { [EOL]     int[] points = new int[] { -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8 }; [EOL]     double[] results = new double[] { 0, 0.2, 0.2, 0.2, 0.2, 0.7, 0.7, 0.7, 0.7, 1.0, 1.0 }; [EOL]     for (int p = 0; p < points.length; p++) { [EOL]         double probability = testDistribution.cumulativeProbability(points[p]); [EOL]         Assert.assertEquals(results[p], probability, 1e-10); [EOL]     } [EOL] } <line_num>: 102,110
@Test [EOL] public void testGetNumericalMean() { [EOL]     Assert.assertEquals(3.4, testDistribution.getNumericalMean(), 1e-10); [EOL] } <line_num>: 115,118
@Test [EOL] public void testGetNumericalVariance() { [EOL]     Assert.assertEquals(7.84, testDistribution.getNumericalVariance(), 1e-10); [EOL] } <line_num>: 123,126
@Test [EOL] public void testGetSupportLowerBound() { [EOL]     Assert.assertEquals(-1, testDistribution.getSupportLowerBound()); [EOL] } <line_num>: 131,134
@Test [EOL] public void testGetSupportUpperBound() { [EOL]     Assert.assertEquals(7, testDistribution.getSupportUpperBound()); [EOL] } <line_num>: 139,142
@Test [EOL] public void testIsSupportConnected() { [EOL]     Assert.assertTrue(testDistribution.isSupportConnected()); [EOL] } <line_num>: 147,150
@Test [EOL] public void testSample() { [EOL]     final int n = 1000000; [EOL]     testDistribution.reseedRandomGenerator(-334759360); [EOL]     final int[] samples = testDistribution.sample(n); [EOL]     Assert.assertEquals(n, samples.length); [EOL]     double sum = 0; [EOL]     double sumOfSquares = 0; [EOL]     for (int i = 0; i < samples.length; i++) { [EOL]         sum += samples[i]; [EOL]         sumOfSquares += samples[i] * samples[i]; [EOL]     } [EOL]     Assert.assertEquals(testDistribution.getNumericalMean(), sum / n, 1e-2); [EOL]     Assert.assertEquals(testDistribution.getNumericalVariance(), sumOfSquares / n - FastMath.pow(sum / n, 2), 1e-2); [EOL] } <line_num>: 155,171