private TestUtils() { [EOL]     super(); [EOL] } <line_num>: 46,48
public static void assertEquals(double expected, double actual, double delta) { [EOL]     Assert.assertEquals(null, expected, actual, delta); [EOL] } <line_num>: 54,56
public static void assertEquals(String msg, double expected, double actual, double delta) { [EOL]     if (Double.isNaN(expected)) { [EOL]         Assert.assertTrue("" + actual + " is not NaN.", Double.isNaN(actual)); [EOL]     } else { [EOL]         Assert.assertEquals(msg, expected, actual, delta); [EOL]     } [EOL] } <line_num>: 62,70
public static void assertSame(double expected, double actual) { [EOL]     Assert.assertEquals(expected, actual, 0); [EOL] } <line_num>: 76,78
public static void assertSame(Complex expected, Complex actual) { [EOL]     assertSame(expected.getReal(), actual.getReal()); [EOL]     assertSame(expected.getImaginary(), actual.getImaginary()); [EOL] } <line_num>: 84,87
public static void assertEquals(Complex expected, Complex actual, double delta) { [EOL]     Assert.assertEquals(expected.getReal(), actual.getReal(), delta); [EOL]     Assert.assertEquals(expected.getImaginary(), actual.getImaginary(), delta); [EOL] } <line_num>: 93,96
public static void assertEquals(double[] expected, double[] observed, double tolerance) { [EOL]     assertEquals("Array comparison failure", expected, observed, tolerance); [EOL] } <line_num>: 101,103
public static Object serializeAndRecover(Object o) { [EOL]     try { [EOL]         ByteArrayOutputStream bos = new ByteArrayOutputStream(); [EOL]         ObjectOutputStream so = new ObjectOutputStream(bos); [EOL]         so.writeObject(o); [EOL]         ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray()); [EOL]         ObjectInputStream si = new ObjectInputStream(bis); [EOL]         return si.readObject(); [EOL]     } catch (IOException ioe) { [EOL]         return null; [EOL]     } catch (ClassNotFoundException cnfe) { [EOL]         return null; [EOL]     } [EOL] } <line_num>: 112,128
public static void checkSerializedEquality(Object object) { [EOL]     Object object2 = serializeAndRecover(object); [EOL]     Assert.assertEquals("Equals check", object, object2); [EOL]     Assert.assertEquals("HashCode check", object.hashCode(), object2.hashCode()); [EOL] } <line_num>: 136,140
public static void assertRelativelyEquals(double expected, double actual, double relativeError) { [EOL]     assertRelativelyEquals(null, expected, actual, relativeError); [EOL] } <line_num>: 151,154
public static void assertRelativelyEquals(String msg, double expected, double actual, double relativeError) { [EOL]     if (Double.isNaN(expected)) { [EOL]         Assert.assertTrue(msg, Double.isNaN(actual)); [EOL]     } else if (Double.isNaN(actual)) { [EOL]         Assert.assertTrue(msg, Double.isNaN(expected)); [EOL]     } else if (Double.isInfinite(actual) || Double.isInfinite(expected)) { [EOL]         Assert.assertEquals(expected, actual, relativeError); [EOL]     } else if (expected == 0.0) { [EOL]         Assert.assertEquals(msg, actual, expected, relativeError); [EOL]     } else { [EOL]         double absError = FastMath.abs(expected) * relativeError; [EOL]         Assert.assertEquals(msg, expected, actual, absError); [EOL]     } [EOL] } <line_num>: 166,180
public static void assertContains(String msg, Complex[] values, Complex z, double epsilon) { [EOL]     for (Complex value : values) { [EOL]         if (Precision.equals(value.getReal(), z.getReal(), epsilon) && Precision.equals(value.getImaginary(), z.getImaginary(), epsilon)) { [EOL]             return; [EOL]         } [EOL]     } [EOL]     Assert.fail(msg + " Unable to find " + (new ComplexFormat()).format(z)); [EOL] } <line_num>: 190,199
public static void assertContains(Complex[] values, Complex z, double epsilon) { [EOL]     assertContains(null, values, z, epsilon); [EOL] } <line_num>: 208,211
public static void assertContains(String msg, double[] values, double x, double epsilon) { [EOL]     for (double value : values) { [EOL]         if (Precision.equals(value, x, epsilon)) { [EOL]             return; [EOL]         } [EOL]     } [EOL]     Assert.fail(msg + " Unable to find " + x); [EOL] } <line_num>: 221,229
public static void assertContains(double[] values, double x, double epsilon) { [EOL]     assertContains(null, values, x, epsilon); [EOL] } <line_num>: 238,241
public static void assertEquals(final String message, final double[] expected, final RealVector actual, final double delta) { [EOL]     final String msgAndSep = message.equals("") ? "" : message + ", "; [EOL]     Assert.assertEquals(msgAndSep + "dimension", expected.length, actual.getDimension()); [EOL]     for (int i = 0; i < expected.length; i++) { [EOL]         Assert.assertEquals(msgAndSep + "entry #" + i, expected[i], actual.getEntry(i), delta); [EOL]     } [EOL] } <line_num>: 254,263
public static void assertEquals(final String message, final RealVector expected, final RealVector actual, final double delta) { [EOL]     final String msgAndSep = message.equals("") ? "" : message + ", "; [EOL]     Assert.assertEquals(msgAndSep + "dimension", expected.getDimension(), actual.getDimension()); [EOL]     final int dim = expected.getDimension(); [EOL]     for (int i = 0; i < dim; i++) { [EOL]         Assert.assertEquals(msgAndSep + "entry #" + i, expected.getEntry(i), actual.getEntry(i), delta); [EOL]     } [EOL] } <line_num>: 276,286
public static void assertEquals(String msg, RealMatrix expected, RealMatrix observed, double tolerance) { [EOL]     Assert.assertNotNull(msg + "\nObserved should not be null", observed); [EOL]     if (expected.getColumnDimension() != observed.getColumnDimension() || expected.getRowDimension() != observed.getRowDimension()) { [EOL]         StringBuilder messageBuffer = new StringBuilder(msg); [EOL]         messageBuffer.append("\nObserved has incorrect dimensions."); [EOL]         messageBuffer.append("\nobserved is " + observed.getRowDimension() + " x " + observed.getColumnDimension()); [EOL]         messageBuffer.append("\nexpected " + expected.getRowDimension() + " x " + expected.getColumnDimension()); [EOL]         Assert.fail(messageBuffer.toString()); [EOL]     } [EOL]     RealMatrix delta = expected.subtract(observed); [EOL]     if (delta.getNorm() >= tolerance) { [EOL]         StringBuilder messageBuffer = new StringBuilder(msg); [EOL]         messageBuffer.append("\nExpected: " + expected); [EOL]         messageBuffer.append("\nObserved: " + observed); [EOL]         messageBuffer.append("\nexpected - observed: " + delta); [EOL]         Assert.fail(messageBuffer.toString()); [EOL]     } [EOL] } <line_num>: 289,312
public static void assertEquals(FieldMatrix<? extends FieldElement<?>> expected, FieldMatrix<? extends FieldElement<?>> observed) { [EOL]     Assert.assertNotNull("Observed should not be null", observed); [EOL]     if (expected.getColumnDimension() != observed.getColumnDimension() || expected.getRowDimension() != observed.getRowDimension()) { [EOL]         StringBuilder messageBuffer = new StringBuilder(); [EOL]         messageBuffer.append("Observed has incorrect dimensions."); [EOL]         messageBuffer.append("\nobserved is " + observed.getRowDimension() + " x " + observed.getColumnDimension()); [EOL]         messageBuffer.append("\nexpected " + expected.getRowDimension() + " x " + expected.getColumnDimension()); [EOL]         Assert.fail(messageBuffer.toString()); [EOL]     } [EOL]     for (int i = 0; i < expected.getRowDimension(); ++i) { [EOL]         for (int j = 0; j < expected.getColumnDimension(); ++j) { [EOL]             FieldElement<?> eij = expected.getEntry(i, j); [EOL]             FieldElement<?> oij = observed.getEntry(i, j); [EOL]             Assert.assertEquals(eij, oij); [EOL]         } [EOL]     } [EOL] } <line_num>: 315,338
public static void assertEquals(String msg, double[] expected, double[] observed, double tolerance) { [EOL]     StringBuilder out = new StringBuilder(msg); [EOL]     if (expected.length != observed.length) { [EOL]         out.append("\n Arrays not same length. \n"); [EOL]         out.append("expected has length "); [EOL]         out.append(expected.length); [EOL]         out.append(" observed length = "); [EOL]         out.append(observed.length); [EOL]         Assert.fail(out.toString()); [EOL]     } [EOL]     boolean failure = false; [EOL]     for (int i = 0; i < expected.length; i++) { [EOL]         if (!Precision.equalsIncludingNaN(expected[i], observed[i], tolerance)) { [EOL]             failure = true; [EOL]             out.append("\n Elements at index "); [EOL]             out.append(i); [EOL]             out.append(" differ. "); [EOL]             out.append(" expected = "); [EOL]             out.append(expected[i]); [EOL]             out.append(" observed = "); [EOL]             out.append(observed[i]); [EOL]         } [EOL]     } [EOL]     if (failure) { [EOL]         Assert.fail(out.toString()); [EOL]     } [EOL] } <line_num>: 341,367
public static <T extends FieldElement<T>> void assertEquals(T[] m, T[] n) { [EOL]     if (m.length != n.length) { [EOL]         Assert.fail("vectors not same length"); [EOL]     } [EOL]     for (int i = 0; i < m.length; i++) { [EOL]         Assert.assertEquals(m[i], n[i]); [EOL]     } [EOL] } <line_num>: 370,377
public static double sumSquareDev(double[] values, double target) { [EOL]     double sumsq = 0d; [EOL]     for (int i = 0; i < values.length; i++) { [EOL]         final double dev = values[i] - target; [EOL]         sumsq += (dev * dev); [EOL]     } [EOL]     return sumsq; [EOL] } <line_num>: 386,393
public static void assertChiSquareAccept(String[] valueLabels, double[] expected, long[] observed, double alpha) { [EOL]     ChiSquareTest chiSquareTest = new ChiSquareTest(); [EOL]     if (chiSquareTest.chiSquareTest(expected, observed, alpha)) { [EOL]         StringBuilder msgBuffer = new StringBuilder(); [EOL]         DecimalFormat df = new DecimalFormat("#.##"); [EOL]         msgBuffer.append("Chisquare test failed"); [EOL]         msgBuffer.append(" p-value = "); [EOL]         msgBuffer.append(chiSquareTest.chiSquareTest(expected, observed)); [EOL]         msgBuffer.append(" chisquare statistic = "); [EOL]         msgBuffer.append(chiSquareTest.chiSquare(expected, observed)); [EOL]         msgBuffer.append(". \n"); [EOL]         msgBuffer.append("value\texpected\tobserved\n"); [EOL]         for (int i = 0; i < expected.length; i++) { [EOL]             msgBuffer.append(valueLabels[i]); [EOL]             msgBuffer.append("\t"); [EOL]             msgBuffer.append(df.format(expected[i])); [EOL]             msgBuffer.append("\t\t"); [EOL]             msgBuffer.append(observed[i]); [EOL]             msgBuffer.append("\n"); [EOL]         } [EOL]         msgBuffer.append("This test can fail randomly due to sampling error with probability "); [EOL]         msgBuffer.append(alpha); [EOL]         msgBuffer.append("."); [EOL]         Assert.fail(msgBuffer.toString()); [EOL]     } [EOL] } <line_num>: 404,431
public static void assertChiSquareAccept(int[] values, double[] expected, long[] observed, double alpha) { [EOL]     String[] labels = new String[values.length]; [EOL]     for (int i = 0; i < values.length; i++) { [EOL]         labels[i] = Integer.toString(values[i]); [EOL]     } [EOL]     assertChiSquareAccept(labels, expected, observed, alpha); [EOL] } <line_num>: 442,448
public static void assertChiSquareAccept(double[] expected, long[] observed, double alpha) { [EOL]     String[] labels = new String[expected.length]; [EOL]     for (int i = 0; i < labels.length; i++) { [EOL]         labels[i] = Integer.toString(i + 1); [EOL]     } [EOL]     assertChiSquareAccept(labels, expected, observed, alpha); [EOL] } <line_num>: 458,464
public static double[] getDistributionQuartiles(RealDistribution distribution) { [EOL]     double[] quantiles = new double[3]; [EOL]     quantiles[0] = distribution.inverseCumulativeProbability(0.25d); [EOL]     quantiles[1] = distribution.inverseCumulativeProbability(0.5d); [EOL]     quantiles[2] = distribution.inverseCumulativeProbability(0.75d); [EOL]     return quantiles; [EOL] } <line_num>: 470,476
public static void updateCounts(double value, long[] counts, double[] quartiles) { [EOL]     if (value < quartiles[0]) { [EOL]         counts[0]++; [EOL]     } else if (value > quartiles[2]) { [EOL]         counts[3]++; [EOL]     } else if (value > quartiles[1]) { [EOL]         counts[2]++; [EOL]     } else { [EOL]         counts[1]++; [EOL]     } [EOL] } <line_num>: 482,492
public static int eliminateZeroMassPoints(int[] densityPoints, double[] densityValues) { [EOL]     int positiveMassCount = 0; [EOL]     for (int i = 0; i < densityValues.length; i++) { [EOL]         if (densityValues[i] > 0) { [EOL]             positiveMassCount++; [EOL]         } [EOL]     } [EOL]     if (positiveMassCount < densityValues.length) { [EOL]         int[] newPoints = new int[positiveMassCount]; [EOL]         double[] newValues = new double[positiveMassCount]; [EOL]         int j = 0; [EOL]         for (int i = 0; i < densityValues.length; i++) { [EOL]             if (densityValues[i] > 0) { [EOL]                 newPoints[j] = densityPoints[i]; [EOL]                 newValues[j] = densityValues[i]; [EOL]                 j++; [EOL]             } [EOL]         } [EOL]         System.arraycopy(newPoints, 0, densityPoints, 0, positiveMassCount); [EOL]         System.arraycopy(newValues, 0, densityValues, 0, positiveMassCount); [EOL]     } [EOL]     return positiveMassCount; [EOL] } <line_num>: 500,522
