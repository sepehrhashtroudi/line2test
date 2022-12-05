public LegendreHighPrecisionRuleFactory() { [EOL]     this(MathContext.DECIMAL128); [EOL] } <line_num>: 49,51
public LegendreHighPrecisionRuleFactory(MathContext mContext) { [EOL]     this.mContext = mContext; [EOL]     two = new BigDecimal("2", mContext); [EOL]     minusOne = new BigDecimal("-1", mContext); [EOL]     oneHalf = new BigDecimal("0.5", mContext); [EOL] } <line_num>: 56,61
@Override [EOL] protected Pair<BigDecimal[], BigDecimal[]> computeRule(int numberOfPoints) throws DimensionMismatchException { [EOL]     if (numberOfPoints == 1) { [EOL]         return new Pair<BigDecimal[], BigDecimal[]>(new BigDecimal[] { BigDecimal.ZERO }, new BigDecimal[] { two }); [EOL]     } [EOL]     final BigDecimal[] previousPoints = getRuleInternal(numberOfPoints - 1).getFirst(); [EOL]     final BigDecimal[] points = new BigDecimal[numberOfPoints]; [EOL]     final BigDecimal[] weights = new BigDecimal[numberOfPoints]; [EOL]     final int iMax = numberOfPoints / 2; [EOL]     for (int i = 0; i < iMax; i++) { [EOL]         BigDecimal a = (i == 0) ? minusOne : previousPoints[i - 1]; [EOL]         BigDecimal b = (iMax == 1) ? BigDecimal.ONE : previousPoints[i]; [EOL]         BigDecimal pma = BigDecimal.ONE; [EOL]         BigDecimal pa = a; [EOL]         BigDecimal pmb = BigDecimal.ONE; [EOL]         BigDecimal pb = b; [EOL]         for (int j = 1; j < numberOfPoints; j++) { [EOL]             final BigDecimal b_two_j_p_1 = new BigDecimal(2 * j + 1, mContext); [EOL]             final BigDecimal b_j = new BigDecimal(j, mContext); [EOL]             final BigDecimal b_j_p_1 = new BigDecimal(j + 1, mContext); [EOL]             BigDecimal tmp1 = a.multiply(b_two_j_p_1, mContext); [EOL]             tmp1 = pa.multiply(tmp1, mContext); [EOL]             BigDecimal tmp2 = pma.multiply(b_j, mContext); [EOL]             BigDecimal ppa = tmp1.subtract(tmp2, mContext); [EOL]             ppa = ppa.divide(b_j_p_1, mContext); [EOL]             tmp1 = b.multiply(b_two_j_p_1, mContext); [EOL]             tmp1 = pb.multiply(tmp1, mContext); [EOL]             tmp2 = pmb.multiply(b_j, mContext); [EOL]             BigDecimal ppb = tmp1.subtract(tmp2, mContext); [EOL]             ppb = ppb.divide(b_j_p_1, mContext); [EOL]             pma = pa; [EOL]             pa = ppa; [EOL]             pmb = pb; [EOL]             pb = ppb; [EOL]         } [EOL]         BigDecimal c = a.add(b, mContext).multiply(oneHalf, mContext); [EOL]         BigDecimal pmc = BigDecimal.ONE; [EOL]         BigDecimal pc = c; [EOL]         boolean done = false; [EOL]         while (!done) { [EOL]             BigDecimal tmp1 = b.subtract(a, mContext); [EOL]             BigDecimal tmp2 = c.ulp().multiply(BigDecimal.TEN, mContext); [EOL]             done = tmp1.compareTo(tmp2) <= 0; [EOL]             pmc = BigDecimal.ONE; [EOL]             pc = c; [EOL]             for (int j = 1; j < numberOfPoints; j++) { [EOL]                 final BigDecimal b_two_j_p_1 = new BigDecimal(2 * j + 1, mContext); [EOL]                 final BigDecimal b_j = new BigDecimal(j, mContext); [EOL]                 final BigDecimal b_j_p_1 = new BigDecimal(j + 1, mContext); [EOL]                 tmp1 = c.multiply(b_two_j_p_1, mContext); [EOL]                 tmp1 = pc.multiply(tmp1, mContext); [EOL]                 tmp2 = pmc.multiply(b_j, mContext); [EOL]                 BigDecimal ppc = tmp1.subtract(tmp2, mContext); [EOL]                 ppc = ppc.divide(b_j_p_1, mContext); [EOL]                 pmc = pc; [EOL]                 pc = ppc; [EOL]             } [EOL]             if (!done) { [EOL]                 if (pa.signum() * pc.signum() <= 0) { [EOL]                     b = c; [EOL]                     pmb = pmc; [EOL]                     pb = pc; [EOL]                 } else { [EOL]                     a = c; [EOL]                     pma = pmc; [EOL]                     pa = pc; [EOL]                 } [EOL]                 c = a.add(b, mContext).multiply(oneHalf, mContext); [EOL]             } [EOL]         } [EOL]         final BigDecimal nP = new BigDecimal(numberOfPoints, mContext); [EOL]         BigDecimal tmp1 = pmc.subtract(c.multiply(pc, mContext), mContext); [EOL]         tmp1 = tmp1.multiply(nP); [EOL]         tmp1 = tmp1.pow(2, mContext); [EOL]         BigDecimal tmp2 = c.pow(2, mContext); [EOL]         tmp2 = BigDecimal.ONE.subtract(tmp2, mContext); [EOL]         tmp2 = tmp2.multiply(two, mContext); [EOL]         tmp2 = tmp2.divide(tmp1, mContext); [EOL]         points[i] = c; [EOL]         weights[i] = tmp2; [EOL]         final int idx = numberOfPoints - i - 1; [EOL]         points[idx] = c.negate(mContext); [EOL]         weights[idx] = tmp2; [EOL]     } [EOL]     if (numberOfPoints % 2 != 0) { [EOL]         BigDecimal pmc = BigDecimal.ONE; [EOL]         for (int j = 1; j < numberOfPoints; j += 2) { [EOL]             final BigDecimal b_j = new BigDecimal(j, mContext); [EOL]             final BigDecimal b_j_p_1 = new BigDecimal(j + 1, mContext); [EOL]             pmc = pmc.multiply(b_j, mContext); [EOL]             pmc = pmc.divide(b_j_p_1, mContext); [EOL]             pmc = pmc.negate(mContext); [EOL]         } [EOL]         final BigDecimal nP = new BigDecimal(numberOfPoints, mContext); [EOL]         BigDecimal tmp1 = pmc.multiply(nP, mContext); [EOL]         tmp1 = tmp1.pow(2, mContext); [EOL]         BigDecimal tmp2 = two.divide(tmp1, mContext); [EOL]         points[iMax] = BigDecimal.ZERO; [EOL]         weights[iMax] = tmp2; [EOL]     } [EOL]     return new Pair<BigDecimal[], BigDecimal[]>(points, weights); [EOL] } <line_num>: 64,215
