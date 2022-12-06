@Before [EOL] public void setUp() { [EOL]     vs.setMode(ValueServer.DIGEST_MODE); [EOL]     URL url = getClass().getResource("testData.txt"); [EOL]     vs.setValuesFileURL(url); [EOL] } <line_num>: 42,47
@Test [EOL] public void testNextDigest() throws Exception { [EOL]     double next = 0.0; [EOL]     double tolerance = 0.1; [EOL]     vs.computeDistribution(); [EOL]     Assert.assertTrue("empirical distribution property", vs.getEmpiricalDistribution() != null); [EOL]     SummaryStatistics stats = new SummaryStatistics(); [EOL]     for (int i = 1; i < 1000; i++) { [EOL]         next = vs.getNext(); [EOL]         stats.addValue(next); [EOL]     } [EOL]     Assert.assertEquals("mean", 5.069831575018909, stats.getMean(), tolerance); [EOL]     Assert.assertEquals("std dev", 1.0173699343977738, stats.getStandardDeviation(), tolerance); [EOL]     vs.computeDistribution(500); [EOL]     stats = new SummaryStatistics(); [EOL]     for (int i = 1; i < 1000; i++) { [EOL]         next = vs.getNext(); [EOL]         stats.addValue(next); [EOL]     } [EOL]     Assert.assertEquals("mean", 5.069831575018909, stats.getMean(), tolerance); [EOL]     Assert.assertEquals("std dev", 1.0173699343977738, stats.getStandardDeviation(), tolerance); [EOL] } <line_num>: 54,79
@Test [EOL] public void testFixedSeed() throws Exception { [EOL]     ValueServer valueServer = new ValueServer(); [EOL]     URL url = getClass().getResource("testData.txt"); [EOL]     valueServer.setValuesFileURL(url); [EOL]     valueServer.computeDistribution(); [EOL]     checkFixedSeed(valueServer, ValueServer.DIGEST_MODE); [EOL]     checkFixedSeed(valueServer, ValueServer.EXPONENTIAL_MODE); [EOL]     checkFixedSeed(valueServer, ValueServer.GAUSSIAN_MODE); [EOL]     checkFixedSeed(valueServer, ValueServer.UNIFORM_MODE); [EOL] } <line_num>: 85,95
private void checkFixedSeed(ValueServer valueServer, int mode) throws Exception { [EOL]     valueServer.reSeed(1000); [EOL]     valueServer.setMode(mode); [EOL]     double[][] values = new double[2][100]; [EOL]     for (int i = 0; i < 100; i++) { [EOL]         values[0][i] = valueServer.getNext(); [EOL]     } [EOL]     valueServer.reSeed(1000); [EOL]     for (int i = 0; i < 100; i++) { [EOL]         values[1][i] = valueServer.getNext(); [EOL]     } [EOL]     Assert.assertTrue(Arrays.equals(values[0], values[1])); [EOL] } <line_num>: 101,113
@Test [EOL] public void testNextDigestFail() throws Exception { [EOL]     try { [EOL]         vs.getNext(); [EOL]         Assert.fail("Expecting IllegalStateException"); [EOL]     } catch (IllegalStateException ex) { [EOL]     } [EOL] } <line_num>: 119,125
@Test [EOL] public void testEmptyReplayFile() throws Exception { [EOL]     try { [EOL]         URL url = getClass().getResource("emptyFile.txt"); [EOL]         vs.setMode(ValueServer.REPLAY_MODE); [EOL]         vs.setValuesFileURL(url); [EOL]         vs.getNext(); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (MathIllegalStateException mise) { [EOL]     } [EOL] } <line_num>: 127,138
@Test [EOL] public void testEmptyDigestFile() throws Exception { [EOL]     try { [EOL]         URL url = getClass().getResource("emptyFile.txt"); [EOL]         vs.setMode(ValueServer.DIGEST_MODE); [EOL]         vs.setValuesFileURL(url); [EOL]         vs.computeDistribution(); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (ZeroException ze) { [EOL]     } [EOL] } <line_num>: 140,151
@Test [EOL] public void testReplay() throws Exception { [EOL]     double firstDataValue = 4.038625496201205; [EOL]     double secondDataValue = 3.6485326248346936; [EOL]     double tolerance = 10E-15; [EOL]     double compareValue = 0.0d; [EOL]     vs.setMode(ValueServer.REPLAY_MODE); [EOL]     vs.resetReplayFile(); [EOL]     compareValue = vs.getNext(); [EOL]     Assert.assertEquals(compareValue, firstDataValue, tolerance); [EOL]     compareValue = vs.getNext(); [EOL]     Assert.assertEquals(compareValue, secondDataValue, tolerance); [EOL]     for (int i = 3; i < 1001; i++) { [EOL]         compareValue = vs.getNext(); [EOL]     } [EOL]     compareValue = vs.getNext(); [EOL]     Assert.assertEquals(compareValue, firstDataValue, tolerance); [EOL]     compareValue = vs.getNext(); [EOL]     Assert.assertEquals(compareValue, secondDataValue, tolerance); [EOL]     vs.closeReplayFile(); [EOL]     vs.closeReplayFile(); [EOL] } <line_num>: 158,180
@Test [EOL] public void testModes() throws Exception { [EOL]     vs.setMode(ValueServer.CONSTANT_MODE); [EOL]     vs.setMu(0); [EOL]     Assert.assertEquals("constant mode test", vs.getMu(), vs.getNext(), Double.MIN_VALUE); [EOL]     vs.setMode(ValueServer.UNIFORM_MODE); [EOL]     vs.setMu(2); [EOL]     double val = vs.getNext(); [EOL]     Assert.assertTrue(val > 0 && val < 4); [EOL]     vs.setSigma(1); [EOL]     vs.setMode(ValueServer.GAUSSIAN_MODE); [EOL]     val = vs.getNext(); [EOL]     Assert.assertTrue("gaussian value close enough to mean", val < vs.getMu() + 100 * vs.getSigma()); [EOL]     vs.setMode(ValueServer.EXPONENTIAL_MODE); [EOL]     val = vs.getNext(); [EOL]     Assert.assertTrue(val > 0); [EOL]     try { [EOL]         vs.setMode(1000); [EOL]         vs.getNext(); [EOL]         Assert.fail("bad mode, expecting IllegalStateException"); [EOL]     } catch (IllegalStateException ex) { [EOL]     } [EOL] } <line_num>: 185,209
@Test [EOL] public void testFill() throws Exception { [EOL]     vs.setMode(ValueServer.CONSTANT_MODE); [EOL]     vs.setMu(2); [EOL]     double[] val = new double[5]; [EOL]     vs.fill(val); [EOL]     for (int i = 0; i < 5; i++) { [EOL]         Assert.assertEquals("fill test in place", 2, val[i], Double.MIN_VALUE); [EOL]     } [EOL]     double[] v2 = vs.fill(3); [EOL]     for (int i = 0; i < 3; i++) { [EOL]         Assert.assertEquals("fill test in place", 2, v2[i], Double.MIN_VALUE); [EOL]     } [EOL] } <line_num>: 214,227
@Test [EOL] public void testProperties() throws Exception { [EOL]     vs.setMode(ValueServer.CONSTANT_MODE); [EOL]     Assert.assertEquals("mode test", ValueServer.CONSTANT_MODE, vs.getMode()); [EOL]     vs.setValuesFileURL("http://www.apache.org"); [EOL]     URL url = vs.getValuesFileURL(); [EOL]     Assert.assertEquals("valuesFileURL test", "http://www.apache.org", url.toString()); [EOL] } <line_num>: 232,239