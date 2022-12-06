@Test [EOL] public void testLongly() { [EOL]     RealMatrix matrix = createRealMatrix(longleyData, 16, 7); [EOL]     PearsonsCorrelation corrInstance = new PearsonsCorrelation(matrix); [EOL]     RealMatrix correlationMatrix = corrInstance.getCorrelationMatrix(); [EOL]     double[] rData = new double[] { 1.000000000000000, 0.9708985250610560, 0.9835516111796693, 0.5024980838759942, 0.4573073999764817, 0.960390571594376, 0.9713294591921188, 0.970898525061056, 1.0000000000000000, 0.9915891780247822, 0.6206333925590966, 0.4647441876006747, 0.979163432977498, 0.9911491900672053, 0.983551611179669, 0.9915891780247822, 1.0000000000000000, 0.6042609398895580, 0.4464367918926265, 0.991090069458478, 0.9952734837647849, 0.502498083875994, 0.6206333925590966, 0.6042609398895580, 1.0000000000000000, -0.1774206295018783, 0.686551516365312, 0.6682566045621746, 0.457307399976482, 0.4647441876006747, 0.4464367918926265, -0.1774206295018783, 1.0000000000000000, 0.364416267189032, 0.4172451498349454, 0.960390571594376, 0.9791634329774981, 0.9910900694584777, 0.6865515163653120, 0.3644162671890320, 1.000000000000000, 0.9939528462329257, 0.971329459192119, 0.9911491900672053, 0.9952734837647849, 0.6682566045621746, 0.4172451498349454, 0.993952846232926, 1.0000000000000000 }; [EOL]     TestUtils.assertEquals("correlation matrix", createRealMatrix(rData, 7, 7), correlationMatrix, 10E-15); [EOL]     double[] rPvalues = new double[] { 4.38904690369668e-10, 8.36353208910623e-12, 7.8159700933611e-14, 0.0472894097790304, 0.01030636128354301, 0.01316878049026582, 0.0749178049642416, 0.06971758330341182, 0.0830166169296545, 0.510948586323452, 3.693245043123738e-09, 4.327782576751815e-11, 1.167954621905665e-13, 0.00331028281967516, 0.1652293725106684, 3.95834476307755e-10, 1.114663916723657e-13, 1.332267629550188e-15, 0.00466039138541463, 0.1078477071581498, 7.771561172376096e-15 }; [EOL]     RealMatrix rPMatrix = createLowerTriangularRealMatrix(rPvalues, 7); [EOL]     fillUpper(rPMatrix, 0d); [EOL]     TestUtils.assertEquals("correlation p values", rPMatrix, corrInstance.getCorrelationPValues(), 10E-15); [EOL] } <line_num>: 103,137
@Test [EOL] public void testSwissFertility() { [EOL]     RealMatrix matrix = createRealMatrix(swissData, 47, 5); [EOL]     PearsonsCorrelation corrInstance = new PearsonsCorrelation(matrix); [EOL]     RealMatrix correlationMatrix = corrInstance.getCorrelationMatrix(); [EOL]     double[] rData = new double[] { 1.0000000000000000, 0.3530791836199747, -0.6458827064572875, -0.6637888570350691, 0.4636847006517939, 0.3530791836199747, 1.0000000000000000, -0.6865422086171366, -0.6395225189483201, 0.4010950530487398, -0.6458827064572875, -0.6865422086171366, 1.0000000000000000, 0.6984152962884830, -0.5727418060641666, -0.6637888570350691, -0.6395225189483201, 0.6984152962884830, 1.0000000000000000, -0.1538589170909148, 0.4636847006517939, 0.4010950530487398, -0.5727418060641666, -0.1538589170909148, 1.0000000000000000 }; [EOL]     TestUtils.assertEquals("correlation matrix", createRealMatrix(rData, 5, 5), correlationMatrix, 10E-15); [EOL]     double[] rPvalues = new double[] { 0.01491720061472623, 9.45043734069043e-07, 9.95151527133974e-08, 3.658616965962355e-07, 1.304590105694471e-06, 4.811397236181847e-08, 0.001028523190118147, 0.005204433539191644, 2.588307925380906e-05, 0.301807756132683 }; [EOL]     RealMatrix rPMatrix = createLowerTriangularRealMatrix(rPvalues, 5); [EOL]     fillUpper(rPMatrix, 0d); [EOL]     TestUtils.assertEquals("correlation p values", rPMatrix, corrInstance.getCorrelationPValues(), 10E-15); [EOL] } <line_num>: 142,165
@Test [EOL] public void testPValueNearZero() { [EOL]     int dimension = 120; [EOL]     double[][] data = new double[dimension][2]; [EOL]     for (int i = 0; i < dimension; i++) { [EOL]         data[i][0] = i; [EOL]         data[i][1] = i + 1 / ((double) i + 1); [EOL]     } [EOL]     PearsonsCorrelation corrInstance = new PearsonsCorrelation(data); [EOL]     Assert.assertTrue(corrInstance.getCorrelationPValues().getEntry(0, 1) > 0); [EOL] } <line_num>: 170,186
@Test [EOL] public void testConstant() { [EOL]     double[] noVariance = new double[] { 1, 1, 1, 1 }; [EOL]     double[] values = new double[] { 1, 2, 3, 4 }; [EOL]     Assert.assertTrue(Double.isNaN(new PearsonsCorrelation().correlation(noVariance, values))); [EOL] } <line_num>: 192,197
@Test [EOL] public void testInsufficientData() { [EOL]     double[] one = new double[] { 1 }; [EOL]     double[] two = new double[] { 2 }; [EOL]     try { [EOL]         new PearsonsCorrelation().correlation(one, two); [EOL]         Assert.fail("Expecting IllegalArgumentException"); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     RealMatrix matrix = new BlockRealMatrix(new double[][] { { 0 }, { 1 } }); [EOL]     try { [EOL]         new PearsonsCorrelation(matrix); [EOL]         Assert.fail("Expecting IllegalArgumentException"); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 204,221
@Test [EOL] public void testStdErrorConsistency() { [EOL]     TDistribution tDistribution = new TDistribution(45); [EOL]     RealMatrix matrix = createRealMatrix(swissData, 47, 5); [EOL]     PearsonsCorrelation corrInstance = new PearsonsCorrelation(matrix); [EOL]     RealMatrix rValues = corrInstance.getCorrelationMatrix(); [EOL]     RealMatrix pValues = corrInstance.getCorrelationPValues(); [EOL]     RealMatrix stdErrors = corrInstance.getCorrelationStandardErrors(); [EOL]     for (int i = 0; i < 5; i++) { [EOL]         for (int j = 0; j < i; j++) { [EOL]             double t = FastMath.abs(rValues.getEntry(i, j)) / stdErrors.getEntry(i, j); [EOL]             double p = 2 * (1 - tDistribution.cumulativeProbability(t)); [EOL]             Assert.assertEquals(p, pValues.getEntry(i, j), 10E-15); [EOL]         } [EOL]     } [EOL] } <line_num>: 227,242
@Test [EOL] public void testCovarianceConsistency() { [EOL]     RealMatrix matrix = createRealMatrix(longleyData, 16, 7); [EOL]     PearsonsCorrelation corrInstance = new PearsonsCorrelation(matrix); [EOL]     Covariance covInstance = new Covariance(matrix); [EOL]     PearsonsCorrelation corrFromCovInstance = new PearsonsCorrelation(covInstance); [EOL]     TestUtils.assertEquals("correlation values", corrInstance.getCorrelationMatrix(), corrFromCovInstance.getCorrelationMatrix(), 10E-15); [EOL]     TestUtils.assertEquals("p values", corrInstance.getCorrelationPValues(), corrFromCovInstance.getCorrelationPValues(), 10E-15); [EOL]     TestUtils.assertEquals("standard errors", corrInstance.getCorrelationStandardErrors(), corrFromCovInstance.getCorrelationStandardErrors(), 10E-15); [EOL]     PearsonsCorrelation corrFromCovInstance2 = new PearsonsCorrelation(covInstance.getCovarianceMatrix(), 16); [EOL]     TestUtils.assertEquals("correlation values", corrInstance.getCorrelationMatrix(), corrFromCovInstance2.getCorrelationMatrix(), 10E-15); [EOL]     TestUtils.assertEquals("p values", corrInstance.getCorrelationPValues(), corrFromCovInstance2.getCorrelationPValues(), 10E-15); [EOL]     TestUtils.assertEquals("standard errors", corrInstance.getCorrelationStandardErrors(), corrFromCovInstance2.getCorrelationStandardErrors(), 10E-15); [EOL] } <line_num>: 248,269
@Test [EOL] public void testConsistency() { [EOL]     RealMatrix matrix = createRealMatrix(longleyData, 16, 7); [EOL]     PearsonsCorrelation corrInstance = new PearsonsCorrelation(matrix); [EOL]     double[][] data = matrix.getData(); [EOL]     double[] x = matrix.getColumn(0); [EOL]     double[] y = matrix.getColumn(1); [EOL]     Assert.assertEquals(new PearsonsCorrelation().correlation(x, y), corrInstance.getCorrelationMatrix().getEntry(0, 1), Double.MIN_VALUE); [EOL]     TestUtils.assertEquals("Correlation matrix", corrInstance.getCorrelationMatrix(), new PearsonsCorrelation().computeCorrelationMatrix(data), Double.MIN_VALUE); [EOL] } <line_num>: 272,283
protected RealMatrix createRealMatrix(double[] data, int nRows, int nCols) { [EOL]     double[][] matrixData = new double[nRows][nCols]; [EOL]     int ptr = 0; [EOL]     for (int i = 0; i < nRows; i++) { [EOL]         System.arraycopy(data, ptr, matrixData[i], 0, nCols); [EOL]         ptr += nCols; [EOL]     } [EOL]     return new BlockRealMatrix(matrixData); [EOL] } <line_num>: 285,293
protected RealMatrix createLowerTriangularRealMatrix(double[] data, int dimension) { [EOL]     int ptr = 0; [EOL]     RealMatrix result = new BlockRealMatrix(dimension, dimension); [EOL]     for (int i = 1; i < dimension; i++) { [EOL]         for (int j = 0; j < i; j++) { [EOL]             result.setEntry(i, j, data[ptr]); [EOL]             ptr++; [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 295,305
protected void fillUpper(RealMatrix matrix, double diagonalValue) { [EOL]     int dimension = matrix.getColumnDimension(); [EOL]     for (int i = 0; i < dimension; i++) { [EOL]         matrix.setEntry(i, i, diagonalValue); [EOL]         for (int j = i + 1; j < dimension; j++) { [EOL]             matrix.setEntry(i, j, matrix.getEntry(j, i)); [EOL]         } [EOL]     } [EOL] } <line_num>: 307,315