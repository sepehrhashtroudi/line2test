public HaltonSequenceGenerator(final int dimension) throws OutOfRangeException { [EOL]     this(dimension, PRIMES, WEIGHTS); [EOL] } <line_num>: 89,91
public HaltonSequenceGenerator(final int dimension, final int[] bases, final int[] weights) throws NullArgumentException, OutOfRangeException, DimensionMismatchException { [EOL]     MathUtils.checkNotNull(bases); [EOL]     if (dimension < 1 || dimension > bases.length) { [EOL]         throw new OutOfRangeException(dimension, 1, PRIMES.length); [EOL]     } [EOL]     if (weights != null && weights.length != bases.length) { [EOL]         throw new DimensionMismatchException(weights.length, bases.length); [EOL]     } [EOL]     this.dimension = dimension; [EOL]     this.base = bases.clone(); [EOL]     this.weight = weights == null ? null : weights.clone(); [EOL]     count = 0; [EOL] } <line_num>: 105,122
public double[] nextVector() { [EOL]     final double[] v = new double[dimension]; [EOL]     for (int i = 0; i < dimension; i++) { [EOL]         int index = count; [EOL]         double f = 1.0 / base[i]; [EOL]         int j = 0; [EOL]         while (index > 0) { [EOL]             final int digit = scramble(i, j, base[i], index % base[i]); [EOL]             v[i] += f * digit; [EOL]             index /= base[i]; [EOL]             f /= base[i]; [EOL]         } [EOL]     } [EOL]     count++; [EOL]     return v; [EOL] } <line_num>: 125,141
protected int scramble(final int i, final int j, final int b, final int digit) { [EOL]     return weight != null ? (weight[i] * digit) % b : digit; [EOL] } <line_num>: 156,158
public double[] skipTo(final int index) throws NotPositiveException { [EOL]     count = index; [EOL]     return nextVector(); [EOL] } <line_num>: 169,172
public int getNextIndex() { [EOL]     return count; [EOL] } <line_num>: 180,182
