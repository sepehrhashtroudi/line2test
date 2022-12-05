@Test [EOL] public void testAggregation() { [EOL]     AggregateSummaryStatistics aggregate = new AggregateSummaryStatistics(); [EOL]     SummaryStatistics setOneStats = aggregate.createContributingStatistics(); [EOL]     SummaryStatistics setTwoStats = aggregate.createContributingStatistics(); [EOL]     Assert.assertNotNull("The set one contributing stats are null", setOneStats); [EOL]     Assert.assertNotNull("The set two contributing stats are null", setTwoStats); [EOL]     Assert.assertNotSame("Contributing stats objects are the same", setOneStats, setTwoStats); [EOL]     setOneStats.addValue(2); [EOL]     setOneStats.addValue(3); [EOL]     setOneStats.addValue(5); [EOL]     setOneStats.addValue(7); [EOL]     setOneStats.addValue(11); [EOL]     Assert.assertEquals("Wrong number of set one values", 5, setOneStats.getN()); [EOL]     Assert.assertTrue("Wrong sum of set one values", Precision.equals(28.0, setOneStats.getSum(), 1)); [EOL]     setTwoStats.addValue(2); [EOL]     setTwoStats.addValue(4); [EOL]     setTwoStats.addValue(8); [EOL]     Assert.assertEquals("Wrong number of set two values", 3, setTwoStats.getN()); [EOL]     Assert.assertTrue("Wrong sum of set two values", Precision.equals(14.0, setTwoStats.getSum(), 1)); [EOL]     Assert.assertEquals("Wrong number of aggregate values", 8, aggregate.getN()); [EOL]     Assert.assertTrue("Wrong aggregate sum", Precision.equals(42.0, aggregate.getSum(), 1)); [EOL] } <line_num>: 43,69
@Test [EOL] public void testAggregationConsistency() { [EOL]     double[] totalSample = generateSample(); [EOL]     double[][] subSamples = generatePartition(totalSample); [EOL]     int nSamples = subSamples.length; [EOL]     AggregateSummaryStatistics aggregate = new AggregateSummaryStatistics(); [EOL]     SummaryStatistics totalStats = new SummaryStatistics(); [EOL]     SummaryStatistics[] componentStats = new SummaryStatistics[nSamples]; [EOL]     for (int i = 0; i < nSamples; i++) { [EOL]         componentStats[i] = aggregate.createContributingStatistics(); [EOL]         for (int j = 0; j < subSamples[i].length; j++) { [EOL]             componentStats[i].addValue(subSamples[i][j]); [EOL]         } [EOL]     } [EOL]     for (int i = 0; i < totalSample.length; i++) { [EOL]         totalStats.addValue(totalSample[i]); [EOL]     } [EOL]     Assert.assertEquals(totalStats.getSummary(), aggregate.getSummary()); [EOL] } <line_num>: 84,124
@Test [EOL] public void testAggregate() { [EOL]     double[] totalSample = generateSample(); [EOL]     double[][] subSamples = generatePartition(totalSample); [EOL]     int nSamples = subSamples.length; [EOL]     SummaryStatistics totalStats = new SummaryStatistics(); [EOL]     for (int i = 0; i < totalSample.length; i++) { [EOL]         totalStats.addValue(totalSample[i]); [EOL]     } [EOL]     SummaryStatistics[] subSampleStats = new SummaryStatistics[nSamples]; [EOL]     for (int i = 0; i < nSamples; i++) { [EOL]         subSampleStats[i] = new SummaryStatistics(); [EOL]     } [EOL]     Collection<SummaryStatistics> aggregate = new ArrayList<SummaryStatistics>(); [EOL]     for (int i = 0; i < nSamples; i++) { [EOL]         for (int j = 0; j < subSamples[i].length; j++) { [EOL]             subSampleStats[i].addValue(subSamples[i][j]); [EOL]         } [EOL]         aggregate.add(subSampleStats[i]); [EOL]     } [EOL]     StatisticalSummary aggregatedStats = AggregateSummaryStatistics.aggregate(aggregate); [EOL]     assertEquals(totalStats.getSummary(), aggregatedStats, 10E-12); [EOL] } <line_num>: 134,164
@Test [EOL] public void testAggregateDegenerate() { [EOL]     double[] totalSample = { 1, 2, 3, 4, 5 }; [EOL]     double[][] subSamples = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } }; [EOL]     SummaryStatistics totalStats = new SummaryStatistics(); [EOL]     for (int i = 0; i < totalSample.length; i++) { [EOL]         totalStats.addValue(totalSample[i]); [EOL]     } [EOL]     SummaryStatistics[] subSampleStats = new SummaryStatistics[5]; [EOL]     for (int i = 0; i < 5; i++) { [EOL]         subSampleStats[i] = new SummaryStatistics(); [EOL]     } [EOL]     Collection<SummaryStatistics> aggregate = new ArrayList<SummaryStatistics>(); [EOL]     for (int i = 0; i < 5; i++) { [EOL]         for (int j = 0; j < subSamples[i].length; j++) { [EOL]             subSampleStats[i].addValue(subSamples[i][j]); [EOL]         } [EOL]         aggregate.add(subSampleStats[i]); [EOL]     } [EOL]     StatisticalSummaryValues aggregatedStats = AggregateSummaryStatistics.aggregate(aggregate); [EOL]     assertEquals(totalStats.getSummary(), aggregatedStats, 10E-12); [EOL] } <line_num>: 167,194
@Test [EOL] public void testAggregateSpecialValues() { [EOL]     double[] totalSample = { Double.POSITIVE_INFINITY, 2, 3, Double.NaN, 5 }; [EOL]     double[][] subSamples = { { Double.POSITIVE_INFINITY, 2 }, { 3 }, { Double.NaN }, { 5 } }; [EOL]     SummaryStatistics totalStats = new SummaryStatistics(); [EOL]     for (int i = 0; i < totalSample.length; i++) { [EOL]         totalStats.addValue(totalSample[i]); [EOL]     } [EOL]     SummaryStatistics[] subSampleStats = new SummaryStatistics[5]; [EOL]     for (int i = 0; i < 4; i++) { [EOL]         subSampleStats[i] = new SummaryStatistics(); [EOL]     } [EOL]     Collection<SummaryStatistics> aggregate = new ArrayList<SummaryStatistics>(); [EOL]     for (int i = 0; i < 4; i++) { [EOL]         for (int j = 0; j < subSamples[i].length; j++) { [EOL]             subSampleStats[i].addValue(subSamples[i][j]); [EOL]         } [EOL]         aggregate.add(subSampleStats[i]); [EOL]     } [EOL]     StatisticalSummaryValues aggregatedStats = AggregateSummaryStatistics.aggregate(aggregate); [EOL]     assertEquals(totalStats.getSummary(), aggregatedStats, 10E-12); [EOL] } <line_num>: 196,224
protected static void assertEquals(StatisticalSummary expected, StatisticalSummary observed, double delta) { [EOL]     TestUtils.assertEquals(expected.getMax(), observed.getMax(), 0); [EOL]     TestUtils.assertEquals(expected.getMin(), observed.getMin(), 0); [EOL]     Assert.assertEquals(expected.getN(), observed.getN()); [EOL]     TestUtils.assertEquals(expected.getSum(), observed.getSum(), delta); [EOL]     TestUtils.assertEquals(expected.getMean(), observed.getMean(), delta); [EOL]     TestUtils.assertEquals(expected.getStandardDeviation(), observed.getStandardDeviation(), delta); [EOL]     TestUtils.assertEquals(expected.getVariance(), observed.getVariance(), delta); [EOL] } <line_num>: 231,239
private double[] generateSample() { [EOL]     final IntegerDistribution size = new UniformIntegerDistribution(10, 100); [EOL]     final RealDistribution randomData = new UniformRealDistribution(-100, 100); [EOL]     final int sampleSize = size.sample(); [EOL]     final double[] out = randomData.sample(sampleSize); [EOL]     return out; [EOL] } <line_num>: 249,255
private double[][] generatePartition(double[] sample) { [EOL]     final int length = sample.length; [EOL]     final double[][] out = new double[5][]; [EOL]     int cur = 0; [EOL]     int offset = 0; [EOL]     int sampleCount = 0; [EOL]     for (int i = 0; i < 5; i++) { [EOL]         if (cur == length || offset == length) { [EOL]             break; [EOL]         } [EOL]         final int next; [EOL]         if (i == 4 || cur == length - 1) { [EOL]             next = length - 1; [EOL]         } else { [EOL]             next = (new UniformIntegerDistribution(cur, length - 1)).sample(); [EOL]         } [EOL]         final int subLength = next - cur + 1; [EOL]         out[i] = new double[subLength]; [EOL]         System.arraycopy(sample, offset, out[i], 0, subLength); [EOL]         cur = next + 1; [EOL]         sampleCount++; [EOL]         offset += subLength; [EOL]     } [EOL]     if (sampleCount < 5) { [EOL]         double[][] out2 = new double[sampleCount][]; [EOL]         for (int j = 0; j < sampleCount; j++) { [EOL]             final int curSize = out[j].length; [EOL]             out2[j] = new double[curSize]; [EOL]             System.arraycopy(out[j], 0, out2[j], 0, curSize); [EOL]         } [EOL]         return out2; [EOL]     } else { [EOL]         return out; [EOL]     } [EOL] } <line_num>: 264,298
