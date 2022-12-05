@Deprecated [EOL] public CurveFitter(final DifferentiableMultivariateVectorOptimizer optimizer) { [EOL]     this.oldOptimizer = optimizer; [EOL]     this.optimizer = null; [EOL]     observations = new ArrayList<WeightedObservedPoint>(); [EOL] } <line_num>: 69,74
public CurveFitter(final MultivariateDifferentiableVectorOptimizer optimizer) { [EOL]     this.oldOptimizer = null; [EOL]     this.optimizer = optimizer; [EOL]     observations = new ArrayList<WeightedObservedPoint>(); [EOL] } <line_num>: 80,84
public OldTheoreticalValuesFunction(final ParametricUnivariateFunction f) { [EOL]     this.f = f; [EOL] } <line_num>: 211,213
public TheoreticalValuesFunction(final ParametricUnivariateFunction f) { [EOL]     this.f = f; [EOL] } <line_num>: 253,255
public void addObservedPoint(double x, double y) { [EOL]     addObservedPoint(1.0, x, y); [EOL] } <line_num>: 96,98
public void addObservedPoint(double weight, double x, double y) { [EOL]     observations.add(new WeightedObservedPoint(weight, x, y)); [EOL] } <line_num>: 109,111
public void addObservedPoint(WeightedObservedPoint observed) { [EOL]     observations.add(observed); [EOL] } <line_num>: 119,121
public WeightedObservedPoint[] getObservations() { [EOL]     return observations.toArray(new WeightedObservedPoint[observations.size()]); [EOL] } <line_num>: 129,131
public void clearObservations() { [EOL]     observations.clear(); [EOL] } <line_num>: 136,138
public double[] fit(T f, final double[] initialGuess) { [EOL]     return fit(Integer.MAX_VALUE, f, initialGuess); [EOL] } <line_num>: 153,155
public double[] fit(int maxEval, T f, final double[] initialGuess) { [EOL]     double[] target = new double[observations.size()]; [EOL]     double[] weights = new double[observations.size()]; [EOL]     int i = 0; [EOL]     for (WeightedObservedPoint point : observations) { [EOL]         target[i] = point.getY(); [EOL]         weights[i] = point.getWeight(); [EOL]         ++i; [EOL]     } [EOL]     final PointVectorValuePair optimum; [EOL]     if (optimizer == null) { [EOL]         optimum = oldOptimizer.optimize(maxEval, new OldTheoreticalValuesFunction(f), target, weights, initialGuess); [EOL]     } else { [EOL]         optimum = optimizer.optimize(maxEval, new TheoreticalValuesFunction(f), target, weights, initialGuess); [EOL]     } [EOL]     return optimum.getPointRef(); [EOL] } <line_num>: 174,199
public double[][] value(double[] point) { [EOL]     final double[][] jacobian = new double[observations.size()][]; [EOL]     int i = 0; [EOL]     for (WeightedObservedPoint observed : observations) { [EOL]         jacobian[i++] = f.gradient(observed.getX(), point); [EOL]     } [EOL]     return jacobian; [EOL] } <line_num>: 218,227
public MultivariateMatrixFunction jacobian() { [EOL]     return new MultivariateMatrixFunction() { [EOL]  [EOL]         public double[][] value(double[] point) { [EOL]             final double[][] jacobian = new double[observations.size()][]; [EOL]             int i = 0; [EOL]             for (WeightedObservedPoint observed : observations) { [EOL]                 jacobian[i++] = f.gradient(observed.getX(), point); [EOL]             } [EOL]             return jacobian; [EOL]         } [EOL]     }; [EOL] } <line_num>: 216,229
public double[] value(double[] point) { [EOL]     final double[] values = new double[observations.size()]; [EOL]     int i = 0; [EOL]     for (WeightedObservedPoint observed : observations) { [EOL]         values[i++] = f.value(observed.getX(), point); [EOL]     } [EOL]     return values; [EOL] } <line_num>: 232,241
public double[] value(double[] point) { [EOL]     final double[] values = new double[observations.size()]; [EOL]     int i = 0; [EOL]     for (WeightedObservedPoint observed : observations) { [EOL]         values[i++] = f.value(observed.getX(), point); [EOL]     } [EOL]     return values; [EOL] } <line_num>: 258,267
public DerivativeStructure[] value(DerivativeStructure[] point) { [EOL]     final double[] parameters = new double[point.length]; [EOL]     for (int k = 0; k < point.length; ++k) { [EOL]         parameters[k] = point[k].getValue(); [EOL]     } [EOL]     final DerivativeStructure[] values = new DerivativeStructure[observations.size()]; [EOL]     int i = 0; [EOL]     for (WeightedObservedPoint observed : observations) { [EOL]         DerivativeStructure vi = new DerivativeStructure(point.length, 1, f.value(observed.getX(), parameters)); [EOL]         for (int k = 0; k < point.length; ++k) { [EOL]             vi = vi.add(new DerivativeStructure(point.length, 1, k, 0.0)); [EOL]         } [EOL]         values[i++] = vi; [EOL]     } [EOL]     return values; [EOL] } <line_num>: 270,295
