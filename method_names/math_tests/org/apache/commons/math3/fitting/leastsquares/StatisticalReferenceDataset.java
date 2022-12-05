public StatisticalReferenceDataset(final BufferedReader in) throws IOException
public double[] value(final double[] a)
public MultivariateVectorFunction getModelFunction()
public double[][] value(final double[] a) throws IllegalArgumentException
public MultivariateMatrixFunction getModelFunctionJacobian()
public String getName()
public int getNumObservations()
public double[][] getData()
public double getX(final int i)
public double getY(final int i)
public int getNumParameters()
public double[] getParameters()
public double getParameter(final int i)
public double[] getParametersStandardDeviations()
public double getParameterStandardDeviation(final int i)
public double getResidualSumOfSquares()
public int getNumStartingPoints()
public double[] getStartingPoint(final int i)
public LeastSquaresProblem getLeastSquaresProblem()
public abstract double getModelValue(final double x, final double[] a)
public abstract double[] getModelDerivatives(final double x, final double[] a)
private static int[] findLineNumbers(final String key, final Iterable<String> lines)
