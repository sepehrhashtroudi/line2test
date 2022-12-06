public SingularValueDecomposition(final RealMatrix matrix)
private Solver(final double[] singularValues, final RealMatrix uT, final RealMatrix v, final boolean nonSingular, final double tol)
public RealMatrix getU()
public RealMatrix getUT()
public RealMatrix getS()
public double[] getSingularValues()
public RealMatrix getV()
public RealMatrix getVT()
public void visit(final int row, final int column, final double value)
public RealMatrix getCovariance(final double minSingularValue)
public double getNorm()
public double getConditionNumber()
public double getInverseConditionNumber()
public int getRank()
public DecompositionSolver getSolver()
public RealVector solve(final RealVector b)
public RealMatrix solve(final RealMatrix b)
public boolean isNonSingular()
public RealMatrix getInverse()