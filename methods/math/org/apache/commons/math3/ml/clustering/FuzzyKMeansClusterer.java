public FuzzyKMeansClusterer(final int k, final double fuzziness) throws NumberIsTooSmallException { [EOL]     this(k, fuzziness, -1, new EuclideanDistance()); [EOL] } <line_num>: 107,109
public FuzzyKMeansClusterer(final int k, final double fuzziness, final int maxIterations, final DistanceMeasure measure) throws NumberIsTooSmallException { [EOL]     this(k, fuzziness, maxIterations, measure, DEFAULT_EPSILON, new JDKRandomGenerator()); [EOL] } <line_num>: 121,125
public FuzzyKMeansClusterer(final int k, final double fuzziness, final int maxIterations, final DistanceMeasure measure, final double epsilon, final RandomGenerator random) throws NumberIsTooSmallException { [EOL]     super(measure); [EOL]     if (fuzziness <= 1.0d) { [EOL]         throw new NumberIsTooSmallException(fuzziness, 1.0, false); [EOL]     } [EOL]     this.k = k; [EOL]     this.fuzziness = fuzziness; [EOL]     this.maxIterations = maxIterations; [EOL]     this.epsilon = epsilon; [EOL]     this.random = random; [EOL]     this.membershipMatrix = null; [EOL]     this.points = null; [EOL]     this.clusters = null; [EOL] } <line_num>: 139,158
public int getK() { [EOL]     return k; [EOL] } <line_num>: 164,166
public double getFuzziness() { [EOL]     return fuzziness; [EOL] } <line_num>: 172,174
public int getMaxIterations() { [EOL]     return maxIterations; [EOL] } <line_num>: 180,182
public double getEpsilon() { [EOL]     return epsilon; [EOL] } <line_num>: 188,190
public RandomGenerator getRandomGenerator() { [EOL]     return random; [EOL] } <line_num>: 196,198
public RealMatrix getMembershipMatrix() { [EOL]     if (membershipMatrix == null) { [EOL]         throw new MathIllegalStateException(); [EOL]     } [EOL]     return MatrixUtils.createRealMatrix(membershipMatrix); [EOL] } <line_num>: 210,215
public List<T> getDataPoints() { [EOL]     return points; [EOL] } <line_num>: 223,225
public List<CentroidCluster<T>> getClusters() { [EOL]     return clusters; [EOL] } <line_num>: 232,234
public double getObjectiveFunctionValue() { [EOL]     if (points == null || clusters == null) { [EOL]         throw new MathIllegalStateException(); [EOL]     } [EOL]     int i = 0; [EOL]     double objFunction = 0.0; [EOL]     for (final T point : points) { [EOL]         int j = 0; [EOL]         for (final CentroidCluster<T> cluster : clusters) { [EOL]             final double dist = distance(point, cluster.getCenter()); [EOL]             objFunction += (dist * dist) * FastMath.pow(membershipMatrix[i][j], fuzziness); [EOL]             j++; [EOL]         } [EOL]         i++; [EOL]     } [EOL]     return objFunction; [EOL] } <line_num>: 241,258
@Override [EOL] public List<CentroidCluster<T>> cluster(final Collection<T> dataPoints) throws MathIllegalArgumentException { [EOL]     MathUtils.checkNotNull(dataPoints); [EOL]     final int size = dataPoints.size(); [EOL]     if (size < k) { [EOL]         throw new NumberIsTooSmallException(size, k, false); [EOL]     } [EOL]     points = Collections.unmodifiableList(new ArrayList<T>(dataPoints)); [EOL]     clusters = new ArrayList<CentroidCluster<T>>(); [EOL]     membershipMatrix = new double[size][k]; [EOL]     final double[][] oldMatrix = new double[size][k]; [EOL]     if (size == 0) { [EOL]         return clusters; [EOL]     } [EOL]     initializeMembershipMatrix(); [EOL]     final int pointDimension = points.get(0).getPoint().length; [EOL]     for (int i = 0; i < k; i++) { [EOL]         clusters.add(new CentroidCluster<T>(new DoublePoint(new double[pointDimension]))); [EOL]     } [EOL]     int iteration = 0; [EOL]     final int max = (maxIterations < 0) ? Integer.MAX_VALUE : maxIterations; [EOL]     double difference = 0.0; [EOL]     do { [EOL]         saveMembershipMatrix(oldMatrix); [EOL]         updateClusterCenters(); [EOL]         updateMembershipMatrix(); [EOL]         difference = calculateMaxMembershipChange(oldMatrix); [EOL]     } while (difference > epsilon && ++iteration < max); [EOL]     return clusters; [EOL] } <line_num>: 268,313
private void updateClusterCenters() { [EOL]     int j = 0; [EOL]     final List<CentroidCluster<T>> newClusters = new ArrayList<CentroidCluster<T>>(k); [EOL]     for (final CentroidCluster<T> cluster : clusters) { [EOL]         final Clusterable center = cluster.getCenter(); [EOL]         int i = 0; [EOL]         double[] arr = new double[center.getPoint().length]; [EOL]         double sum = 0.0; [EOL]         for (final T point : points) { [EOL]             final double u = FastMath.pow(membershipMatrix[i][j], fuzziness); [EOL]             final double[] pointArr = point.getPoint(); [EOL]             for (int idx = 0; idx < arr.length; idx++) { [EOL]                 arr[idx] += u * pointArr[idx]; [EOL]             } [EOL]             sum += u; [EOL]             i++; [EOL]         } [EOL]         MathArrays.scaleInPlace(1.0 / sum, arr); [EOL]         newClusters.add(new CentroidCluster<T>(new DoublePoint(arr))); [EOL]         j++; [EOL]     } [EOL]     clusters.clear(); [EOL]     clusters = newClusters; [EOL] } <line_num>: 318,341
private void updateMembershipMatrix() { [EOL]     for (int i = 0; i < points.size(); i++) { [EOL]         final T point = points.get(i); [EOL]         double maxMembership = 0.0; [EOL]         int newCluster = -1; [EOL]         for (int j = 0; j < clusters.size(); j++) { [EOL]             double sum = 0.0; [EOL]             final double distA = FastMath.abs(distance(point, clusters.get(j).getCenter())); [EOL]             for (final CentroidCluster<T> c : clusters) { [EOL]                 final double distB = FastMath.abs(distance(point, c.getCenter())); [EOL]                 sum += FastMath.pow(distA / distB, 2.0 / (fuzziness - 1.0)); [EOL]             } [EOL]             membershipMatrix[i][j] = 1.0 / sum; [EOL]             if (membershipMatrix[i][j] > maxMembership) { [EOL]                 maxMembership = membershipMatrix[i][j]; [EOL]                 newCluster = j; [EOL]             } [EOL]         } [EOL]         clusters.get(newCluster).addPoint(point); [EOL]     } [EOL] } <line_num>: 347,370
private void initializeMembershipMatrix() { [EOL]     for (int i = 0; i < points.size(); i++) { [EOL]         for (int j = 0; j < k; j++) { [EOL]             membershipMatrix[i][j] = random.nextDouble(); [EOL]         } [EOL]         membershipMatrix[i] = MathArrays.normalizeArray(membershipMatrix[i], 1.0); [EOL]     } [EOL] } <line_num>: 375,382
private double calculateMaxMembershipChange(final double[][] matrix) { [EOL]     double maxMembership = 0.0; [EOL]     for (int i = 0; i < points.size(); i++) { [EOL]         for (int j = 0; j < clusters.size(); j++) { [EOL]             double v = FastMath.abs(membershipMatrix[i][j] - matrix[i][j]); [EOL]             maxMembership = FastMath.max(v, maxMembership); [EOL]         } [EOL]     } [EOL]     return maxMembership; [EOL] } <line_num>: 391,400
private void saveMembershipMatrix(final double[][] matrix) { [EOL]     for (int i = 0; i < points.size(); i++) { [EOL]         System.arraycopy(membershipMatrix[i], 0, matrix[i], 0, clusters.size()); [EOL]     } [EOL] } <line_num>: 407,411
