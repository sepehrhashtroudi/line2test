@Test [EOL] public void testConstructors() throws DimensionMismatchException { [EOL]     double cosAlpha = 1 / 2.0; [EOL]     double sinAlpha = FastMath.sqrt(3) / 2.0; [EOL]     double cosDelta = FastMath.sqrt(2) / 2.0; [EOL]     double sinDelta = -FastMath.sqrt(2) / 2.0; [EOL]     FieldVector3D<DerivativeStructure> u = new FieldVector3D<DerivativeStructure>(2, new FieldVector3D<DerivativeStructure>(new DerivativeStructure(2, 1, 0, FastMath.PI / 3), new DerivativeStructure(2, 1, 1, -FastMath.PI / 4))); [EOL]     checkVector(u, 2 * cosAlpha * cosDelta, 2 * sinAlpha * cosDelta, 2 * sinDelta); [EOL]     Assert.assertEquals(-2 * sinAlpha * cosDelta, u.getX().getPartialDerivative(1, 0), 1.0e-12); [EOL]     Assert.assertEquals(+2 * cosAlpha * cosDelta, u.getY().getPartialDerivative(1, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, u.getZ().getPartialDerivative(1, 0), 1.0e-12); [EOL]     Assert.assertEquals(-2 * cosAlpha * sinDelta, u.getX().getPartialDerivative(0, 1), 1.0e-12); [EOL]     Assert.assertEquals(-2 * sinAlpha * sinDelta, u.getY().getPartialDerivative(0, 1), 1.0e-12); [EOL]     Assert.assertEquals(2 * cosDelta, u.getZ().getPartialDerivative(0, 1), 1.0e-12); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(2, createVector(1, 0, 0, 3)), 2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), createVector(1, 0, 0, 4)), 2, 0, 0, 2, 0, 0, 1, 0, 2, 0, 0, 0, 0, 2, 0); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), new Vector3D(1, 0, 0)), 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(2, createVector(1, 0, 0, 3), -3, createVector(0, 0, -1, 3)), 2, 0, 3, -1, 0, 0, 0, -1, 0, 0, 0, -1); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), createVector(1, 0, 0, 4), new DerivativeStructure(4, 1, 3, -3.0), createVector(0, 0, -1, 4)), 2, 0, 3, -1, 0, 0, 1, 0, -1, 0, 0, 0, 0, -1, -1); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), new Vector3D(1, 0, 0), new DerivativeStructure(4, 1, 3, -3.0), new Vector3D(0, 0, -1)), 2, 0, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -1); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(2, createVector(1, 0, 0, 3), 5, createVector(0, 1, 0, 3), -3, createVector(0, 0, -1, 3)), 2, 5, 3, 4, 0, 0, 0, 4, 0, 0, 0, 4); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), createVector(1, 0, 0, 4), new DerivativeStructure(4, 1, 3, 5.0), createVector(0, 1, 0, 4), new DerivativeStructure(4, 1, 3, -3.0), createVector(0, 0, -1, 4)), 2, 5, 3, 4, 0, 0, 1, 0, 4, 0, 1, 0, 0, 4, -1); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), new Vector3D(1, 0, 0), new DerivativeStructure(4, 1, 3, 5.0), new Vector3D(0, 1, 0), new DerivativeStructure(4, 1, 3, -3.0), new Vector3D(0, 0, -1)), 2, 5, 3, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, -1); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(2, createVector(1, 0, 0, 3), 5, createVector(0, 1, 0, 3), 5, createVector(0, -1, 0, 3), -3, createVector(0, 0, -1, 3)), 2, 0, 3, 9, 0, 0, 0, 9, 0, 0, 0, 9); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), createVector(1, 0, 0, 4), new DerivativeStructure(4, 1, 3, 5.0), createVector(0, 1, 0, 4), new DerivativeStructure(4, 1, 3, 5.0), createVector(0, -1, 0, 4), new DerivativeStructure(4, 1, 3, -3.0), createVector(0, 0, -1, 4)), 2, 0, 3, 9, 0, 0, 1, 0, 9, 0, 0, 0, 0, 9, -1); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(4, 1, 3, 2.0), new Vector3D(1, 0, 0), new DerivativeStructure(4, 1, 3, 5.0), new Vector3D(0, 1, 0), new DerivativeStructure(4, 1, 3, 5.0), new Vector3D(0, -1, 0), new DerivativeStructure(4, 1, 3, -3.0), new Vector3D(0, 0, -1)), 2, 0, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -1); [EOL]     checkVector(new FieldVector3D<DerivativeStructure>(new DerivativeStructure[] { new DerivativeStructure(3, 1, 2, 2), new DerivativeStructure(3, 1, 1, 5), new DerivativeStructure(3, 1, 0, -3) }), 2, 5, -3, 0, 0, 1, 0, 1, 0, 1, 0, 0); [EOL] } <line_num>: 36,126
@Test [EOL] public void testEquals() { [EOL]     FieldVector3D<DerivativeStructure> u1 = createVector(1, 2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v = createVector(1, 2, 3 + 10 * Precision.EPSILON, 3); [EOL]     Assert.assertTrue(u1.equals(u1)); [EOL]     Assert.assertTrue(u1.equals(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(3, 1, 0, 1.0), new DerivativeStructure(3, 1, 1, 2.0), new DerivativeStructure(3, 1, 2, 3.0)))); [EOL]     Assert.assertFalse(u1.equals(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(3, 1, 1.0), new DerivativeStructure(3, 1, 1, 2.0), new DerivativeStructure(3, 1, 2, 3.0)))); [EOL]     Assert.assertFalse(u1.equals(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(3, 1, 0, 1.0), new DerivativeStructure(3, 1, 2.0), new DerivativeStructure(3, 1, 2, 3.0)))); [EOL]     Assert.assertFalse(u1.equals(new FieldVector3D<DerivativeStructure>(new DerivativeStructure(3, 1, 0, 1.0), new DerivativeStructure(3, 1, 1, 2.0), new DerivativeStructure(3, 1, 3.0)))); [EOL]     Assert.assertFalse(u1.equals(v)); [EOL]     Assert.assertFalse(u1.equals(u1.toVector3D())); [EOL]     Assert.assertTrue(createVector(0, Double.NaN, 0, 3).equals(createVector(0, 0, Double.NaN, 3))); [EOL] } <line_num>: 128,148
@Test [EOL] public void testHash() { [EOL]     Assert.assertEquals(createVector(0, Double.NaN, 0, 3).hashCode(), createVector(0, 0, Double.NaN, 3).hashCode()); [EOL]     FieldVector3D<DerivativeStructure> u = createVector(1, 2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v = createVector(1, 2, 3 + 10 * Precision.EPSILON, 3); [EOL]     Assert.assertTrue(u.hashCode() != v.hashCode()); [EOL] } <line_num>: 150,156
@Test [EOL] public void testInfinite() { [EOL]     Assert.assertTrue(createVector(1, 1, Double.NEGATIVE_INFINITY, 3).isInfinite()); [EOL]     Assert.assertTrue(createVector(1, Double.NEGATIVE_INFINITY, 1, 3).isInfinite()); [EOL]     Assert.assertTrue(createVector(Double.NEGATIVE_INFINITY, 1, 1, 3).isInfinite()); [EOL]     Assert.assertFalse(createVector(1, 1, 2, 3).isInfinite()); [EOL]     Assert.assertFalse(createVector(1, Double.NaN, Double.NEGATIVE_INFINITY, 3).isInfinite()); [EOL] } <line_num>: 158,165
@Test [EOL] public void testNaN() { [EOL]     Assert.assertTrue(createVector(1, 1, Double.NaN, 3).isNaN()); [EOL]     Assert.assertTrue(createVector(1, Double.NaN, 1, 3).isNaN()); [EOL]     Assert.assertTrue(createVector(Double.NaN, 1, 1, 3).isNaN()); [EOL]     Assert.assertFalse(createVector(1, 1, 2, 3).isNaN()); [EOL]     Assert.assertFalse(createVector(1, 1, Double.NEGATIVE_INFINITY, 3).isNaN()); [EOL] } <line_num>: 167,174
@Test [EOL] public void testToString() { [EOL]     Assert.assertEquals("{3; 2; 1}", createVector(3, 2, 1, 3).toString()); [EOL]     NumberFormat format = new DecimalFormat("0.000", new DecimalFormatSymbols(Locale.US)); [EOL]     Assert.assertEquals("{3.000; 2.000; 1.000}", createVector(3, 2, 1, 3).toString(format)); [EOL] } <line_num>: 176,181
@Test(expected = DimensionMismatchException.class) [EOL] public void testWrongDimension() throws DimensionMismatchException { [EOL]     new FieldVector3D<DerivativeStructure>(new DerivativeStructure[] { new DerivativeStructure(3, 1, 0, 2), new DerivativeStructure(3, 1, 0, 5) }); [EOL] } <line_num>: 183,189
@Test [EOL] public void testCoordinates() { [EOL]     FieldVector3D<DerivativeStructure> v = createVector(1, 2, 3, 3); [EOL]     Assert.assertTrue(FastMath.abs(v.getX().getReal() - 1) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(v.getY().getReal() - 2) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(v.getZ().getReal() - 3) < 1.0e-12); [EOL]     DerivativeStructure[] coordinates = v.toArray(); [EOL]     Assert.assertTrue(FastMath.abs(coordinates[0].getReal() - 1) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(coordinates[1].getReal() - 2) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(coordinates[2].getReal() - 3) < 1.0e-12); [EOL] } <line_num>: 191,201
@Test [EOL] public void testNorm1() { [EOL]     Assert.assertEquals(0.0, createVector(0, 0, 0, 3).getNorm1().getReal(), 0); [EOL]     Assert.assertEquals(6.0, createVector(1, -2, 3, 3).getNorm1().getReal(), 0); [EOL]     Assert.assertEquals(1.0, createVector(1, -2, 3, 3).getNorm1().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(-1.0, createVector(1, -2, 3, 3).getNorm1().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(1.0, createVector(1, -2, 3, 3).getNorm1().getPartialDerivative(0, 0, 1), 0); [EOL] } <line_num>: 203,210
@Test [EOL] public void testNorm() { [EOL]     double r = FastMath.sqrt(14); [EOL]     Assert.assertEquals(0.0, createVector(0, 0, 0, 3).getNorm().getReal(), 0); [EOL]     Assert.assertEquals(r, createVector(1, 2, 3, 3).getNorm().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(1.0 / r, createVector(1, 2, 3, 3).getNorm().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(2.0 / r, createVector(1, 2, 3, 3).getNorm().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(3.0 / r, createVector(1, 2, 3, 3).getNorm().getPartialDerivative(0, 0, 1), 0); [EOL] } <line_num>: 212,220
@Test [EOL] public void testNormSq() { [EOL]     Assert.assertEquals(0.0, createVector(0, 0, 0, 3).getNormSq().getReal(), 0); [EOL]     Assert.assertEquals(14, createVector(1, 2, 3, 3).getNormSq().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(2, createVector(1, 2, 3, 3).getNormSq().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(4, createVector(1, 2, 3, 3).getNormSq().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(6, createVector(1, 2, 3, 3).getNormSq().getPartialDerivative(0, 0, 1), 0); [EOL] } <line_num>: 222,229
@Test [EOL] public void testNormInf() { [EOL]     Assert.assertEquals(0.0, createVector(0, 0, 0, 3).getNormInf().getReal(), 0); [EOL]     Assert.assertEquals(3.0, createVector(1, -2, 3, 3).getNormInf().getReal(), 0); [EOL]     Assert.assertEquals(0.0, createVector(1, -2, 3, 3).getNormInf().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(1, -2, 3, 3).getNormInf().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(1.0, createVector(1, -2, 3, 3).getNormInf().getPartialDerivative(0, 0, 1), 0); [EOL]     Assert.assertEquals(3.0, createVector(2, -1, 3, 3).getNormInf().getReal(), 0); [EOL]     Assert.assertEquals(0.0, createVector(2, -1, 3, 3).getNormInf().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(2, -1, 3, 3).getNormInf().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(1.0, createVector(2, -1, 3, 3).getNormInf().getPartialDerivative(0, 0, 1), 0); [EOL]     Assert.assertEquals(3.0, createVector(1, -3, 2, 3).getNormInf().getReal(), 0); [EOL]     Assert.assertEquals(0.0, createVector(1, -3, 2, 3).getNormInf().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(-1.0, createVector(1, -3, 2, 3).getNormInf().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(1, -3, 2, 3).getNormInf().getPartialDerivative(0, 0, 1), 0); [EOL]     Assert.assertEquals(3.0, createVector(2, -3, 1, 3).getNormInf().getReal(), 0); [EOL]     Assert.assertEquals(0.0, createVector(2, -3, 1, 3).getNormInf().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(-1.0, createVector(2, -3, 1, 3).getNormInf().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(2, -3, 1, 3).getNormInf().getPartialDerivative(0, 0, 1), 0); [EOL]     Assert.assertEquals(3.0, createVector(3, -1, 2, 3).getNormInf().getReal(), 0); [EOL]     Assert.assertEquals(1.0, createVector(3, -1, 2, 3).getNormInf().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(3, -1, 2, 3).getNormInf().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(3, -1, 2, 3).getNormInf().getPartialDerivative(0, 0, 1), 0); [EOL]     Assert.assertEquals(3.0, createVector(3, -2, 1, 3).getNormInf().getReal(), 0); [EOL]     Assert.assertEquals(1.0, createVector(3, -2, 1, 3).getNormInf().getPartialDerivative(1, 0, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(3, -2, 1, 3).getNormInf().getPartialDerivative(0, 1, 0), 0); [EOL]     Assert.assertEquals(0.0, createVector(3, -2, 1, 3).getNormInf().getPartialDerivative(0, 0, 1), 0); [EOL] } <line_num>: 231,258
@Test [EOL] public void testDistance1() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(1, -2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(-4, 2, 0, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.distance1(createVector(-1, 0, 0, 3), createVector(-1, 0, 0, 3)).getReal(), 0); [EOL]     DerivativeStructure distance = FieldVector3D.distance1(v1, v2); [EOL]     Assert.assertEquals(12.0, distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distance = FieldVector3D.distance1(v1, new Vector3D(-4, 2, 0)); [EOL]     Assert.assertEquals(12.0, distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(1, distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(-1, distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(1, distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distance = FieldVector3D.distance1(new Vector3D(-4, 2, 0), v1); [EOL]     Assert.assertEquals(12.0, distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(1, distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(-1, distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(1, distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL] } <line_num>: 260,280
@Test [EOL] public void testDistance() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(1, -2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(-4, 2, 0, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.distance(createVector(-1, 0, 0, 3), createVector(-1, 0, 0, 3)).getReal(), 0); [EOL]     DerivativeStructure distance = FieldVector3D.distance(v1, v2); [EOL]     Assert.assertEquals(FastMath.sqrt(50), distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distance = FieldVector3D.distance(v1, new Vector3D(-4, 2, 0)); [EOL]     Assert.assertEquals(FastMath.sqrt(50), distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5 / FastMath.sqrt(50), distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(-4 / FastMath.sqrt(50), distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(3 / FastMath.sqrt(50), distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distance = FieldVector3D.distance(new Vector3D(-4, 2, 0), v1); [EOL]     Assert.assertEquals(FastMath.sqrt(50), distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5 / FastMath.sqrt(50), distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(-4 / FastMath.sqrt(50), distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(3 / FastMath.sqrt(50), distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL] } <line_num>: 282,302
@Test [EOL] public void testDistanceSq() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(1, -2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(-4, 2, 0, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.distanceSq(createVector(-1, 0, 0, 3), createVector(-1, 0, 0, 3)).getReal(), 0); [EOL]     DerivativeStructure distanceSq = FieldVector3D.distanceSq(v1, v2); [EOL]     Assert.assertEquals(50.0, distanceSq.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(0, distanceSq.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distanceSq.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distanceSq.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distanceSq = FieldVector3D.distanceSq(v1, new Vector3D(-4, 2, 0)); [EOL]     Assert.assertEquals(50.0, distanceSq.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(10, distanceSq.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(-8, distanceSq.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(6, distanceSq.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distanceSq = FieldVector3D.distanceSq(new Vector3D(-4, 2, 0), v1); [EOL]     Assert.assertEquals(50.0, distanceSq.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(10, distanceSq.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(-8, distanceSq.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(6, distanceSq.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL] } <line_num>: 304,324
@Test [EOL] public void testDistanceInf() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(1, -2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(-4, 2, 0, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.distanceInf(createVector(-1, 0, 0, 3), createVector(-1, 0, 0, 3)).getReal(), 0); [EOL]     DerivativeStructure distance = FieldVector3D.distanceInf(v1, v2); [EOL]     Assert.assertEquals(5.0, distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distance = FieldVector3D.distanceInf(v1, new Vector3D(-4, 2, 0)); [EOL]     Assert.assertEquals(5.0, distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(1, distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     distance = FieldVector3D.distanceInf(new Vector3D(-4, 2, 0), v1); [EOL]     Assert.assertEquals(5.0, distance.getReal(), 1.0e-12); [EOL]     Assert.assertEquals(1, distance.getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(0, distance.getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     Assert.assertEquals(v1.subtract(v2).getNormInf().getReal(), FieldVector3D.distanceInf(v1, v2).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(1, -2, 3, 3), createVector(-4, 2, 0, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(1, 3, -2, 3), createVector(-4, 0, 2, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(-2, 1, 3, 3), createVector(2, -4, 0, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(-2, 3, 1, 3), createVector(2, 0, -4, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(3, -2, 1, 3), createVector(0, 2, -4, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(3, 1, -2, 3), createVector(0, -4, 2, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(1, -2, 3, 3), new Vector3D(-4, 2, 0)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(1, 3, -2, 3), new Vector3D(-4, 0, 2)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(-2, 1, 3, 3), new Vector3D(2, -4, 0)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(-2, 3, 1, 3), new Vector3D(2, 0, -4)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(3, -2, 1, 3), new Vector3D(0, 2, -4)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(5.0, FieldVector3D.distanceInf(createVector(3, 1, -2, 3), new Vector3D(0, -4, 2)).getReal(), 1.0e-12); [EOL] } <line_num>: 326,386
@Test [EOL] public void testSubtract() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(1, 2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(-3, -2, -1, 3); [EOL]     v1 = v1.subtract(v2); [EOL]     checkVector(v1, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0); [EOL]     checkVector(v2.subtract(v1), -7, -6, -5, 1, 0, 0, 0, 1, 0, 0, 0, 1); [EOL]     checkVector(v2.subtract(new Vector3D(4, 4, 4)), -7, -6, -5, 1, 0, 0, 0, 1, 0, 0, 0, 1); [EOL]     checkVector(v2.subtract(3, v1), -15, -14, -13, 1, 0, 0, 0, 1, 0, 0, 0, 1); [EOL]     checkVector(v2.subtract(3, new Vector3D(4, 4, 4)), -15, -14, -13, 1, 0, 0, 0, 1, 0, 0, 0, 1); [EOL]     checkVector(v2.subtract(new DerivativeStructure(3, 1, 2, 3), new Vector3D(4, 4, 4)), -15, -14, -13, 1, 0, -4, 0, 1, -4, 0, 0, -3); [EOL]     checkVector(createVector(1, 2, 3, 4).subtract(new DerivativeStructure(4, 1, 3, 5.0), createVector(3, -2, 1, 4)), -14, 12, -2, -4, 0, 0, -3, 0, -4, 0, 2, 0, 0, -4, -1); [EOL] } <line_num>: 388,409
@Test [EOL] public void testAdd() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(1, 2, 3, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(-3, -2, -1, 3); [EOL]     v1 = v1.add(v2); [EOL]     checkVector(v1, -2, 0, 2, 2, 0, 0, 0, 2, 0, 0, 0, 2); [EOL]     checkVector(v2.add(v1), -5, -2, 1, 3, 0, 0, 0, 3, 0, 0, 0, 3); [EOL]     checkVector(v2.add(new Vector3D(-2, 0, 2)), -5, -2, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1); [EOL]     checkVector(v2.add(3, v1), -9, -2, 5, 7, 0, 0, 0, 7, 0, 0, 0, 7); [EOL]     checkVector(v2.add(3, new Vector3D(-2, 0, 2)), -9, -2, 5, 1, 0, 0, 0, 1, 0, 0, 0, 1); [EOL]     checkVector(v2.add(new DerivativeStructure(3, 1, 2, 3), new Vector3D(-2, 0, 2)), -9, -2, 5, 1, 0, -2, 0, 1, 0, 0, 0, 3); [EOL]     checkVector(createVector(1, 2, 3, 4).add(new DerivativeStructure(4, 1, 3, 5.0), createVector(3, -2, 1, 4)), 16, -8, 8, 6, 0, 0, 3, 0, 6, 0, -2, 0, 0, 6, 1); [EOL] } <line_num>: 411,432
@Test [EOL] public void testScalarProduct() { [EOL]     FieldVector3D<DerivativeStructure> v = createVector(1, 2, 3, 3); [EOL]     v = v.scalarMultiply(3); [EOL]     checkVector(v, 3, 6, 9); [EOL]     checkVector(v.scalarMultiply(0.5), 1.5, 3, 4.5); [EOL] } <line_num>: 434,441
@Test [EOL] public void testVectorialProducts() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(2, 1, -4, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(3, 1, -1, 3); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v1, v2).getReal() - 11) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v1, v2.toVector3D()).getReal() - 11) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v1.toVector3D(), v2).getReal() - 11) < 1.0e-12); [EOL]     FieldVector3D<DerivativeStructure> v3 = FieldVector3D.crossProduct(v1, v2); [EOL]     checkVector(v3, 3, -10, -1); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v1, v3).getReal()) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v2, v3).getReal()) < 1.0e-12); [EOL]     v3 = FieldVector3D.crossProduct(v1, v2.toVector3D()); [EOL]     checkVector(v3, 3, -10, -1); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v1, v3).getReal()) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v2, v3).getReal()) < 1.0e-12); [EOL]     v3 = FieldVector3D.crossProduct(v1.toVector3D(), v2); [EOL]     checkVector(v3, 3, -10, -1); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v1, v3).getReal()) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.dotProduct(v2, v3).getReal()) < 1.0e-12); [EOL] } <line_num>: 443,467
@Test [EOL] public void testCrossProductCancellation() { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(9070467121.0, 4535233560.0, 1, 3); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(9070467123.0, 4535233561.0, 1, 3); [EOL]     checkVector(FieldVector3D.crossProduct(v1, v2), -1, 2, 1); [EOL]     double scale = FastMath.scalb(1.0, 100); [EOL]     FieldVector3D<DerivativeStructure> big1 = new FieldVector3D<DerivativeStructure>(scale, v1); [EOL]     FieldVector3D<DerivativeStructure> small2 = new FieldVector3D<DerivativeStructure>(1 / scale, v2); [EOL]     checkVector(FieldVector3D.crossProduct(big1, small2), -1, 2, 1); [EOL] } <line_num>: 469,480
@Test [EOL] public void testAngular() { [EOL]     Assert.assertEquals(0, createVector(1, 0, 0, 3).getAlpha().getReal(), 1.0e-10); [EOL]     Assert.assertEquals(0, createVector(1, 0, 0, 3).getDelta().getReal(), 1.0e-10); [EOL]     Assert.assertEquals(FastMath.PI / 2, createVector(0, 1, 0, 3).getAlpha().getReal(), 1.0e-10); [EOL]     Assert.assertEquals(0, createVector(0, 1, 0, 3).getDelta().getReal(), 1.0e-10); [EOL]     Assert.assertEquals(FastMath.PI / 2, createVector(0, 0, 1, 3).getDelta().getReal(), 1.0e-10); [EOL]     FieldVector3D<DerivativeStructure> u = createVector(-1, 1, -1, 3); [EOL]     Assert.assertEquals(3 * FastMath.PI / 4, u.getAlpha().getReal(), 1.0e-10); [EOL]     Assert.assertEquals(-1.0 / FastMath.sqrt(3), u.getDelta().sin().getReal(), 1.0e-10); [EOL] } <line_num>: 482,493
@Test [EOL] public void testAngularSeparation() throws MathArithmeticException { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(2, -1, 4, 3); [EOL]     FieldVector3D<DerivativeStructure> k = v1.normalize(); [EOL]     FieldVector3D<DerivativeStructure> i = k.orthogonal(); [EOL]     FieldVector3D<DerivativeStructure> v2 = k.scalarMultiply(FastMath.cos(1.2)).add(i.scalarMultiply(FastMath.sin(1.2))); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.angle(v1, v2).getReal() - 1.2) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.angle(v1, v2.toVector3D()).getReal() - 1.2) < 1.0e-12); [EOL]     Assert.assertTrue(FastMath.abs(FieldVector3D.angle(v1.toVector3D(), v2).getReal() - 1.2) < 1.0e-12); [EOL]     try { [EOL]         FieldVector3D.angle(v1, Vector3D.ZERO); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (MathArithmeticException mae) { [EOL]     } [EOL]     Assert.assertEquals(0.0, FieldVector3D.angle(v1, v1.toVector3D()).getReal(), 1.0e-15); [EOL]     Assert.assertEquals(FastMath.PI, FieldVector3D.angle(v1, v1.negate().toVector3D()).getReal(), 1.0e-15); [EOL] } <line_num>: 495,516
@Test [EOL] public void testNormalize() throws MathArithmeticException { [EOL]     Assert.assertEquals(1.0, createVector(5, -4, 2, 3).normalize().getNorm().getReal(), 1.0e-12); [EOL]     try { [EOL]         createVector(0, 0, 0, 3).normalize(); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (MathArithmeticException ae) { [EOL]     } [EOL] } <line_num>: 518,527
@Test [EOL] public void testNegate() { [EOL]     checkVector(createVector(0.1, 2.5, 1.3, 3).negate(), -0.1, -2.5, -1.3, -1, 0, 0, 0, -1, 0, 0, 0, -1); [EOL] } <line_num>: 529,533
@Test [EOL] public void testOrthogonal() throws MathArithmeticException { [EOL]     FieldVector3D<DerivativeStructure> v1 = createVector(0.1, 2.5, 1.3, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.dotProduct(v1, v1.orthogonal()).getReal(), 1.0e-12); [EOL]     FieldVector3D<DerivativeStructure> v2 = createVector(2.3, -0.003, 7.6, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.dotProduct(v2, v2.orthogonal()).getReal(), 1.0e-12); [EOL]     FieldVector3D<DerivativeStructure> v3 = createVector(-1.7, 1.4, 0.2, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.dotProduct(v3, v3.orthogonal()).getReal(), 1.0e-12); [EOL]     FieldVector3D<DerivativeStructure> v4 = createVector(4.2, 0.1, -1.8, 3); [EOL]     Assert.assertEquals(0.0, FieldVector3D.dotProduct(v4, v4.orthogonal()).getReal(), 1.0e-12); [EOL]     try { [EOL]         createVector(0, 0, 0, 3).orthogonal(); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (MathArithmeticException ae) { [EOL]     } [EOL] } <line_num>: 535,551
@Test [EOL] public void testAngle() throws MathArithmeticException { [EOL]     Assert.assertEquals(0.22572612855273393616, FieldVector3D.angle(createVector(1, 2, 3, 3), createVector(4, 5, 6, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(7.98595620686106654517199e-8, FieldVector3D.angle(createVector(1, 2, 3, 3), createVector(2, 4, 6.000001, 3)).getReal(), 1.0e-12); [EOL]     Assert.assertEquals(3.14159257373023116985197793156, FieldVector3D.angle(createVector(1, 2, 3, 3), createVector(-2, -4, -6.000001, 3)).getReal(), 1.0e-12); [EOL]     try { [EOL]         FieldVector3D.angle(createVector(0, 0, 0, 3), createVector(1, 0, 0, 3)); [EOL]         Assert.fail("an exception should have been thrown"); [EOL]     } catch (MathArithmeticException ae) { [EOL]     } [EOL] } <line_num>: 553,570
@Test [EOL] public void testAccurateDotProduct() { [EOL]     FieldVector3D<DerivativeStructure> u1 = createVector(-1321008684645961.0 / 268435456.0, -5774608829631843.0 / 268435456.0, -7645843051051357.0 / 8589934592.0, 3); [EOL]     FieldVector3D<DerivativeStructure> u2 = createVector(-5712344449280879.0 / 2097152.0, -4550117129121957.0 / 2097152.0, 8846951984510141.0 / 131072.0, 3); [EOL]     DerivativeStructure sNaive = u1.getX().multiply(u2.getX()).add(u1.getY().multiply(u2.getY())).add(u1.getZ().multiply(u2.getZ())); [EOL]     DerivativeStructure sAccurate = FieldVector3D.dotProduct(u1, u2); [EOL]     Assert.assertEquals(0.0, sNaive.getReal(), 1.0e-30); [EOL]     Assert.assertEquals(-2088690039198397.0 / 1125899906842624.0, sAccurate.getReal(), 1.0e-16); [EOL] } <line_num>: 572,587
@Test [EOL] public void testDotProduct() { [EOL]     Well1024a random = new Well1024a(553267312521321234l); [EOL]     for (int i = 0; i < 10000; ++i) { [EOL]         double ux = 10000 * random.nextDouble(); [EOL]         double uy = 10000 * random.nextDouble(); [EOL]         double uz = 10000 * random.nextDouble(); [EOL]         double vx = 10000 * random.nextDouble(); [EOL]         double vy = 10000 * random.nextDouble(); [EOL]         double vz = 10000 * random.nextDouble(); [EOL]         double sNaive = ux * vx + uy * vy + uz * vz; [EOL]         FieldVector3D<DerivativeStructure> uds = createVector(ux, uy, uz, 3); [EOL]         FieldVector3D<DerivativeStructure> vds = createVector(vx, vy, vz, 3); [EOL]         Vector3D v = new Vector3D(vx, vy, vz); [EOL]         DerivativeStructure sAccurate = FieldVector3D.dotProduct(uds, vds); [EOL]         Assert.assertEquals(sNaive, sAccurate.getReal(), 2.5e-16 * sNaive); [EOL]         Assert.assertEquals(ux + vx, sAccurate.getPartialDerivative(1, 0, 0), 2.5e-16 * sNaive); [EOL]         Assert.assertEquals(uy + vy, sAccurate.getPartialDerivative(0, 1, 0), 2.5e-16 * sNaive); [EOL]         Assert.assertEquals(uz + vz, sAccurate.getPartialDerivative(0, 0, 1), 2.5e-16 * sNaive); [EOL]         sAccurate = FieldVector3D.dotProduct(uds, v); [EOL]         Assert.assertEquals(sNaive, sAccurate.getReal(), 2.5e-16 * sNaive); [EOL]         Assert.assertEquals(vx, sAccurate.getPartialDerivative(1, 0, 0), 2.5e-16 * sNaive); [EOL]         Assert.assertEquals(vy, sAccurate.getPartialDerivative(0, 1, 0), 2.5e-16 * sNaive); [EOL]         Assert.assertEquals(vz, sAccurate.getPartialDerivative(0, 0, 1), 2.5e-16 * sNaive); [EOL]     } [EOL] } <line_num>: 589,620
@Test [EOL] public void testAccurateCrossProduct() { [EOL]     final FieldVector3D<DerivativeStructure> u1 = createVector(-1321008684645961.0 / 268435456.0, -5774608829631843.0 / 268435456.0, -7645843051051357.0 / 8589934592.0, 3); [EOL]     final FieldVector3D<DerivativeStructure> u2 = createVector(1796571811118507.0 / 2147483648.0, 7853468008299307.0 / 2147483648.0, 2599586637357461.0 / 17179869184.0, 3); [EOL]     final FieldVector3D<DerivativeStructure> u3 = createVector(12753243807587107.0 / 18446744073709551616.0, -2313766922703915.0 / 18446744073709551616.0, -227970081415313.0 / 288230376151711744.0, 3); [EOL]     FieldVector3D<DerivativeStructure> cNaive = new FieldVector3D<DerivativeStructure>(u1.getY().multiply(u2.getZ()).subtract(u1.getZ().multiply(u2.getY())), u1.getZ().multiply(u2.getX()).subtract(u1.getX().multiply(u2.getZ())), u1.getX().multiply(u2.getY()).subtract(u1.getY().multiply(u2.getX()))); [EOL]     FieldVector3D<DerivativeStructure> cAccurate = FieldVector3D.crossProduct(u1, u2); [EOL]     Assert.assertTrue(FieldVector3D.distance(u3, cNaive).getReal() > 2.9 * u3.getNorm().getReal()); [EOL]     Assert.assertEquals(0.0, FieldVector3D.distance(u3, cAccurate).getReal(), 1.0e-30 * cAccurate.getNorm().getReal()); [EOL] } <line_num>: 622,644
@Test [EOL] public void testCrossProduct() { [EOL]     Well1024a random = new Well1024a(885362227452043214l); [EOL]     for (int i = 0; i < 10000; ++i) { [EOL]         double ux = random.nextDouble(); [EOL]         double uy = random.nextDouble(); [EOL]         double uz = random.nextDouble(); [EOL]         double vx = random.nextDouble(); [EOL]         double vy = random.nextDouble(); [EOL]         double vz = random.nextDouble(); [EOL]         Vector3D cNaive = new Vector3D(uy * vz - uz * vy, uz * vx - ux * vz, ux * vy - uy * vx); [EOL]         FieldVector3D<DerivativeStructure> uds = createVector(ux, uy, uz, 3); [EOL]         FieldVector3D<DerivativeStructure> vds = createVector(vx, vy, vz, 3); [EOL]         Vector3D v = new Vector3D(vx, vy, vz); [EOL]         checkVector(FieldVector3D.crossProduct(uds, vds), cNaive.getX(), cNaive.getY(), cNaive.getZ(), 0, vz - uz, uy - vy, uz - vz, 0, vx - ux, vy - uy, ux - vx, 0); [EOL]         checkVector(FieldVector3D.crossProduct(uds, v), cNaive.getX(), cNaive.getY(), cNaive.getZ(), 0, vz, -vy, -vz, 0, vx, vy, -vx, 0); [EOL]     } [EOL] } <line_num>: 646,677
private FieldVector3D<DerivativeStructure> createVector(double x, double y, double z, int params) { [EOL]     return new FieldVector3D<DerivativeStructure>(new DerivativeStructure(params, 1, 0, x), new DerivativeStructure(params, 1, 1, y), new DerivativeStructure(params, 1, 2, z)); [EOL] } <line_num>: 679,683
private void checkVector(FieldVector3D<DerivativeStructure> v, double x, double y, double z) { [EOL]     Assert.assertEquals(x, v.getX().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(y, v.getY().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(z, v.getZ().getReal(), 1.0e-12); [EOL] } <line_num>: 685,689
private void checkVector(FieldVector3D<DerivativeStructure> v, double x, double y, double z, double dxdx, double dxdy, double dxdz, double dydx, double dydy, double dydz, double dzdx, double dzdy, double dzdz) { [EOL]     Assert.assertEquals(x, v.getX().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(y, v.getY().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(z, v.getZ().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(dxdx, v.getX().getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dxdy, v.getX().getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(dxdz, v.getX().getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     Assert.assertEquals(dydx, v.getY().getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dydy, v.getY().getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(dydz, v.getY().getPartialDerivative(0, 0, 1), 1.0e-12); [EOL]     Assert.assertEquals(dzdx, v.getZ().getPartialDerivative(1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dzdy, v.getZ().getPartialDerivative(0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(dzdz, v.getZ().getPartialDerivative(0, 0, 1), 1.0e-12); [EOL] } <line_num>: 691,707
private void checkVector(FieldVector3D<DerivativeStructure> v, double x, double y, double z, double dxdx, double dxdy, double dxdz, double dxdt, double dydx, double dydy, double dydz, double dydt, double dzdx, double dzdy, double dzdz, double dzdt) { [EOL]     Assert.assertEquals(x, v.getX().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(y, v.getY().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(z, v.getZ().getReal(), 1.0e-12); [EOL]     Assert.assertEquals(dxdx, v.getX().getPartialDerivative(1, 0, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dxdy, v.getX().getPartialDerivative(0, 1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dxdz, v.getX().getPartialDerivative(0, 0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(dxdt, v.getX().getPartialDerivative(0, 0, 0, 1), 1.0e-12); [EOL]     Assert.assertEquals(dydx, v.getY().getPartialDerivative(1, 0, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dydy, v.getY().getPartialDerivative(0, 1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dydz, v.getY().getPartialDerivative(0, 0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(dydt, v.getY().getPartialDerivative(0, 0, 0, 1), 1.0e-12); [EOL]     Assert.assertEquals(dzdx, v.getZ().getPartialDerivative(1, 0, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dzdy, v.getZ().getPartialDerivative(0, 1, 0, 0), 1.0e-12); [EOL]     Assert.assertEquals(dzdz, v.getZ().getPartialDerivative(0, 0, 1, 0), 1.0e-12); [EOL]     Assert.assertEquals(dzdt, v.getZ().getPartialDerivative(0, 0, 0, 1), 1.0e-12); [EOL] } <line_num>: 709,728
