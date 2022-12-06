public CloseIntegerPoint(EuclideanIntegerPoint point) { [EOL]     euclideanPoint = point; [EOL] } <line_num>: 175,177
@Test [EOL] public void dimension2() { [EOL]     KMeansPlusPlusClusterer<EuclideanIntegerPoint> transformer = new KMeansPlusPlusClusterer<EuclideanIntegerPoint>(new Random(1746432956321l)); [EOL]     EuclideanIntegerPoint[] points = new EuclideanIntegerPoint[] { new EuclideanIntegerPoint(new int[] { -15, 3 }), new EuclideanIntegerPoint(new int[] { -15, 4 }), new EuclideanIntegerPoint(new int[] { -15, 5 }), new EuclideanIntegerPoint(new int[] { -14, 3 }), new EuclideanIntegerPoint(new int[] { -14, 5 }), new EuclideanIntegerPoint(new int[] { -13, 3 }), new EuclideanIntegerPoint(new int[] { -13, 4 }), new EuclideanIntegerPoint(new int[] { -13, 5 }), new EuclideanIntegerPoint(new int[] { -1, 0 }), new EuclideanIntegerPoint(new int[] { -1, -1 }), new EuclideanIntegerPoint(new int[] { 0, -1 }), new EuclideanIntegerPoint(new int[] { 1, -1 }), new EuclideanIntegerPoint(new int[] { 1, -2 }), new EuclideanIntegerPoint(new int[] { 13, 3 }), new EuclideanIntegerPoint(new int[] { 13, 4 }), new EuclideanIntegerPoint(new int[] { 14, 4 }), new EuclideanIntegerPoint(new int[] { 14, 7 }), new EuclideanIntegerPoint(new int[] { 16, 5 }), new EuclideanIntegerPoint(new int[] { 16, 6 }), new EuclideanIntegerPoint(new int[] { 17, 4 }), new EuclideanIntegerPoint(new int[] { 17, 7 }) }; [EOL]     List<Cluster<EuclideanIntegerPoint>> clusters = transformer.cluster(Arrays.asList(points), 3, 5, 10); [EOL]     Assert.assertEquals(3, clusters.size()); [EOL]     boolean cluster1Found = false; [EOL]     boolean cluster2Found = false; [EOL]     boolean cluster3Found = false; [EOL]     for (Cluster<EuclideanIntegerPoint> cluster : clusters) { [EOL]         int[] center = cluster.getCenter().getPoint(); [EOL]         if (center[0] < 0) { [EOL]             cluster1Found = true; [EOL]             Assert.assertEquals(8, cluster.getPoints().size()); [EOL]             Assert.assertEquals(-14, center[0]); [EOL]             Assert.assertEquals(4, center[1]); [EOL]         } else if (center[1] < 0) { [EOL]             cluster2Found = true; [EOL]             Assert.assertEquals(5, cluster.getPoints().size()); [EOL]             Assert.assertEquals(0, center[0]); [EOL]             Assert.assertEquals(-1, center[1]); [EOL]         } else { [EOL]             cluster3Found = true; [EOL]             Assert.assertEquals(8, cluster.getPoints().size()); [EOL]             Assert.assertEquals(15, center[0]); [EOL]             Assert.assertEquals(5, center[1]); [EOL]         } [EOL]     } [EOL]     Assert.assertTrue(cluster1Found); [EOL]     Assert.assertTrue(cluster2Found); [EOL]     Assert.assertTrue(cluster3Found); [EOL] } <line_num>: 33,97
@Test [EOL] public void testPerformClusterAnalysisDegenerate() { [EOL]     KMeansPlusPlusClusterer<EuclideanIntegerPoint> transformer = new KMeansPlusPlusClusterer<EuclideanIntegerPoint>(new Random(1746432956321l)); [EOL]     EuclideanIntegerPoint[] points = new EuclideanIntegerPoint[] { new EuclideanIntegerPoint(new int[] { 1959, 325100 }), new EuclideanIntegerPoint(new int[] { 1960, 373200 }) }; [EOL]     List<Cluster<EuclideanIntegerPoint>> clusters = transformer.cluster(Arrays.asList(points), 1, 1); [EOL]     Assert.assertEquals(1, clusters.size()); [EOL]     Assert.assertEquals(2, (clusters.get(0).getPoints().size())); [EOL]     EuclideanIntegerPoint pt1 = new EuclideanIntegerPoint(new int[] { 1959, 325100 }); [EOL]     EuclideanIntegerPoint pt2 = new EuclideanIntegerPoint(new int[] { 1960, 373200 }); [EOL]     Assert.assertTrue(clusters.get(0).getPoints().contains(pt1)); [EOL]     Assert.assertTrue(clusters.get(0).getPoints().contains(pt2)); [EOL] } <line_num>: 104,119
@Test [EOL] public void testCertainSpace() { [EOL]     KMeansPlusPlusClusterer.EmptyClusterStrategy[] strategies = { KMeansPlusPlusClusterer.EmptyClusterStrategy.LARGEST_VARIANCE, KMeansPlusPlusClusterer.EmptyClusterStrategy.LARGEST_POINTS_NUMBER, KMeansPlusPlusClusterer.EmptyClusterStrategy.FARTHEST_POINT }; [EOL]     for (KMeansPlusPlusClusterer.EmptyClusterStrategy strategy : strategies) { [EOL]         KMeansPlusPlusClusterer<EuclideanIntegerPoint> transformer = new KMeansPlusPlusClusterer<EuclideanIntegerPoint>(new Random(1746432956321l), strategy); [EOL]         int numberOfVariables = 27; [EOL]         int position1 = 1; [EOL]         int position2 = position1 + numberOfVariables; [EOL]         int position3 = position2 + numberOfVariables; [EOL]         int position4 = position3 + numberOfVariables; [EOL]         int multiplier = 1000000; [EOL]         EuclideanIntegerPoint[] breakingPoints = new EuclideanIntegerPoint[numberOfVariables]; [EOL]         for (int i = 0; i < numberOfVariables; i++) { [EOL]             int[] points = { position1, position2, position3, position4 }; [EOL]             for (int j = 0; j < points.length; j++) { [EOL]                 points[j] = points[j] * multiplier; [EOL]             } [EOL]             EuclideanIntegerPoint euclideanIntegerPoint = new EuclideanIntegerPoint(points); [EOL]             breakingPoints[i] = euclideanIntegerPoint; [EOL]             position1 = position1 + numberOfVariables; [EOL]             position2 = position2 + numberOfVariables; [EOL]             position3 = position3 + numberOfVariables; [EOL]             position4 = position4 + numberOfVariables; [EOL]         } [EOL]         for (int n = 2; n < 27; ++n) { [EOL]             List<Cluster<EuclideanIntegerPoint>> clusters = transformer.cluster(Arrays.asList(breakingPoints), n, 100); [EOL]             Assert.assertEquals(n, clusters.size()); [EOL]             int sum = 0; [EOL]             for (Cluster<EuclideanIntegerPoint> cluster : clusters) { [EOL]                 sum += cluster.getPoints().size(); [EOL]             } [EOL]             Assert.assertEquals(numberOfVariables, sum); [EOL]         } [EOL]     } [EOL] } <line_num>: 121,168
public double distanceFrom(CloseIntegerPoint p) { [EOL]     return euclideanPoint.distanceFrom(p.euclideanPoint) * 0.001; [EOL] } <line_num>: 179,181
public CloseIntegerPoint centroidOf(Collection<CloseIntegerPoint> p) { [EOL]     Collection<EuclideanIntegerPoint> euclideanPoints = new ArrayList<EuclideanIntegerPoint>(); [EOL]     for (CloseIntegerPoint point : p) { [EOL]         euclideanPoints.add(point.euclideanPoint); [EOL]     } [EOL]     return new CloseIntegerPoint(euclideanPoint.centroidOf(euclideanPoints)); [EOL] } <line_num>: 183,190
@Override [EOL] public boolean equals(Object o) { [EOL]     if (!(o instanceof CloseIntegerPoint)) { [EOL]         return false; [EOL]     } [EOL]     CloseIntegerPoint p = (CloseIntegerPoint) o; [EOL]     return euclideanPoint.equals(p.euclideanPoint); [EOL] } <line_num>: 192,200
@Override [EOL] public int hashCode() { [EOL]     return euclideanPoint.hashCode(); [EOL] } <line_num>: 202,205
@Test [EOL] public void testSmallDistances() { [EOL]     int[] repeatedArray = { 0 }; [EOL]     int[] uniqueArray = { 1 }; [EOL]     CloseIntegerPoint repeatedPoint = new CloseIntegerPoint(new EuclideanIntegerPoint(repeatedArray)); [EOL]     CloseIntegerPoint uniquePoint = new CloseIntegerPoint(new EuclideanIntegerPoint(uniqueArray)); [EOL]     Collection<CloseIntegerPoint> points = new ArrayList<CloseIntegerPoint>(); [EOL]     final int NUM_REPEATED_POINTS = 10 * 1000; [EOL]     for (int i = 0; i < NUM_REPEATED_POINTS; ++i) { [EOL]         points.add(repeatedPoint); [EOL]     } [EOL]     points.add(uniquePoint); [EOL]     final long RANDOM_SEED = 0; [EOL]     final int NUM_CLUSTERS = 2; [EOL]     final int NUM_ITERATIONS = 0; [EOL]     KMeansPlusPlusClusterer<CloseIntegerPoint> clusterer = new KMeansPlusPlusClusterer<CloseIntegerPoint>(new Random(RANDOM_SEED)); [EOL]     List<Cluster<CloseIntegerPoint>> clusters = clusterer.cluster(points, NUM_CLUSTERS, NUM_ITERATIONS); [EOL]     boolean uniquePointIsCenter = false; [EOL]     for (Cluster<CloseIntegerPoint> cluster : clusters) { [EOL]         if (cluster.getCenter().equals(uniquePoint)) { [EOL]             uniquePointIsCenter = true; [EOL]         } [EOL]     } [EOL]     Assert.assertTrue(uniquePointIsCenter); [EOL] } <line_num>: 213,249
@Test(expected = NumberIsTooSmallException.class) [EOL] public void testPerformClusterAnalysisToManyClusters() { [EOL]     KMeansPlusPlusClusterer<EuclideanIntegerPoint> transformer = new KMeansPlusPlusClusterer<EuclideanIntegerPoint>(new Random(1746432956321l)); [EOL]     EuclideanIntegerPoint[] points = new EuclideanIntegerPoint[] { new EuclideanIntegerPoint(new int[] { 1959, 325100 }), new EuclideanIntegerPoint(new int[] { 1960, 373200 }) }; [EOL]     transformer.cluster(Arrays.asList(points), 3, 1); [EOL] } <line_num>: 254,270