protected AbstractSimplex(int n)
protected AbstractSimplex(int n, double sideLength)
protected AbstractSimplex(final double[] steps)
protected AbstractSimplex(final double[][] referenceSimplex)
public int getDimension()
public int getSize()
public abstract void iterate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator)
public void build(final double[] startPoint)
public void evaluate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator)
protected void replaceWorstPoint(PointValuePair pointValuePair, final Comparator<PointValuePair> comparator)
public PointValuePair[] getPoints()
public PointValuePair getPoint(int index)
protected void setPoint(int index, PointValuePair point)
protected void setPoints(PointValuePair[] points)
private static double[] createHypercubeSteps(int n, double sideLength)
PointValuePair[] simplex
double[][] startConfiguration
int dimension
