public HypergeometricDistribution(int populationSize, int numberOfSuccesses, int sampleSize) throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException
public HypergeometricDistribution(RandomGenerator rng, int populationSize, int numberOfSuccesses, int sampleSize) throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException
public double cumulativeProbability(int x)
private int[] getDomain(int n, int m, int k)
private int getLowerDomain(int n, int m, int k)
public int getNumberOfSuccesses()
public int getPopulationSize()
public int getSampleSize()
private int getUpperDomain(int m, int k)
public double probability(int x)
public double upperCumulativeProbability(int x)
private double innerCumulativeProbability(int x0, int x1, int dx)
public double getNumericalMean()
public double getNumericalVariance()
protected double calculateNumericalVariance()
public int getSupportLowerBound()
public int getSupportUpperBound()
public boolean isSupportConnected()
long serialVersionUID=Optional[-436928820673516179L]
int numberOfSuccesses
int populationSize
int sampleSize
double numericalVariance=Optional[Double.NaN]
boolean numericalVarianceIsCalculated=Optional[false]
