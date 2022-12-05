@Override [EOL] public void setUp() { [EOL]     super.setUp(); [EOL]     setTolerance(defaultTolerance); [EOL] } <line_num>: 35,39
@Override [EOL] public CauchyDistribution makeDistribution() { [EOL]     return new CauchyDistribution(1.2, 2.1); [EOL] } <line_num>: 44,47
@Override [EOL] public double[] makeCumulativeTestPoints() { [EOL]     return new double[] { -667.24856187, -65.6230835029, -25.4830299460, -12.0588781808, -5.26313542807, 669.64856187, 68.0230835029, 27.8830299460, 14.4588781808, 7.66313542807 }; [EOL] } <line_num>: 50,55
@Override [EOL] public double[] makeCumulativeTestValues() { [EOL]     return new double[] { 0.001, 0.01, 0.025, 0.05, 0.1, 0.999, 0.990, 0.975, 0.950, 0.900 }; [EOL] } <line_num>: 58,62
@Override [EOL] public double[] makeDensityTestValues() { [EOL]     return new double[] { 1.49599158008e-06, 0.000149550440335, 0.000933076881878, 0.00370933207799, 0.0144742330437, 1.49599158008e-06, 0.000149550440335, 0.000933076881878, 0.00370933207799, 0.0144742330437 }; [EOL] } <line_num>: 65,69
@Test [EOL] public void testInverseCumulativeProbabilityExtremes() { [EOL]     setInverseCumulativeTestPoints(new double[] { 0.0, 1.0 }); [EOL]     setInverseCumulativeTestValues(new double[] { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY }); [EOL]     verifyInverseCumulativeProbabilities(); [EOL] } <line_num>: 73,79
@Test [EOL] public void testMedian() { [EOL]     CauchyDistribution distribution = (CauchyDistribution) getDistribution(); [EOL]     Assert.assertEquals(1.2, distribution.getMedian(), 0.0); [EOL] } <line_num>: 81,85
@Test [EOL] public void testScale() { [EOL]     CauchyDistribution distribution = (CauchyDistribution) getDistribution(); [EOL]     Assert.assertEquals(2.1, distribution.getScale(), 0.0); [EOL] } <line_num>: 87,91
@Test [EOL] public void testPreconditions() { [EOL]     try { [EOL]         new CauchyDistribution(0, 0); [EOL]         Assert.fail("Cannot have zero scale"); [EOL]     } catch (NotStrictlyPositiveException ex) { [EOL]     } [EOL]     try { [EOL]         new CauchyDistribution(0, -1); [EOL]         Assert.fail("Cannot have negative scale"); [EOL]     } catch (NotStrictlyPositiveException ex) { [EOL]     } [EOL] } <line_num>: 93,107
@Test [EOL] public void testMoments() { [EOL]     CauchyDistribution dist; [EOL]     dist = new CauchyDistribution(10.2, 0.15); [EOL]     Assert.assertTrue(Double.isNaN(dist.getNumericalMean())); [EOL]     Assert.assertTrue(Double.isNaN(dist.getNumericalVariance())); [EOL]     dist = new CauchyDistribution(23.12, 2.12); [EOL]     Assert.assertTrue(Double.isNaN(dist.getNumericalMean())); [EOL]     Assert.assertTrue(Double.isNaN(dist.getNumericalVariance())); [EOL] } <line_num>: 109,120
