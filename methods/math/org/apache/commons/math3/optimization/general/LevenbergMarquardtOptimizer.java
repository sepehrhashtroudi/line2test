public LevenbergMarquardtOptimizer() { [EOL]     this(100, 1e-10, 1e-10, 1e-10, Precision.SAFE_MIN); [EOL] } <line_num>: 157,159
public LevenbergMarquardtOptimizer(ConvergenceChecker<PointVectorValuePair> checker) { [EOL]     this(100, checker, 1e-10, 1e-10, 1e-10, Precision.SAFE_MIN); [EOL] } <line_num>: 176,178
public LevenbergMarquardtOptimizer(double initialStepBoundFactor, ConvergenceChecker<PointVectorValuePair> checker, double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance, double threshold) { [EOL]     super(checker); [EOL]     this.initialStepBoundFactor = initialStepBoundFactor; [EOL]     this.costRelativeTolerance = costRelativeTolerance; [EOL]     this.parRelativeTolerance = parRelativeTolerance; [EOL]     this.orthoTolerance = orthoTolerance; [EOL]     this.qrRankingThreshold = threshold; [EOL] } <line_num>: 202,214
public LevenbergMarquardtOptimizer(double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance) { [EOL]     this(100, costRelativeTolerance, parRelativeTolerance, orthoTolerance, Precision.SAFE_MIN); [EOL] } <line_num>: 234,240
public LevenbergMarquardtOptimizer(double initialStepBoundFactor, double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance, double threshold) { [EOL]     super(null); [EOL]     this.initialStepBoundFactor = initialStepBoundFactor; [EOL]     this.costRelativeTolerance = costRelativeTolerance; [EOL]     this.parRelativeTolerance = parRelativeTolerance; [EOL]     this.orthoTolerance = orthoTolerance; [EOL]     this.qrRankingThreshold = threshold; [EOL] } <line_num>: 265,276
@Override [EOL] protected PointVectorValuePair doOptimize() { [EOL]     final int nR = getTarget().length; [EOL]     final double[] currentPoint = getStartPoint(); [EOL]     final int nC = currentPoint.length; [EOL]     solvedCols = FastMath.min(nR, nC); [EOL]     diagR = new double[nC]; [EOL]     jacNorm = new double[nC]; [EOL]     beta = new double[nC]; [EOL]     permutation = new int[nC]; [EOL]     lmDir = new double[nC]; [EOL]     double delta = 0; [EOL]     double xNorm = 0; [EOL]     double[] diag = new double[nC]; [EOL]     double[] oldX = new double[nC]; [EOL]     double[] oldRes = new double[nR]; [EOL]     double[] oldObj = new double[nR]; [EOL]     double[] qtf = new double[nR]; [EOL]     double[] work1 = new double[nC]; [EOL]     double[] work2 = new double[nC]; [EOL]     double[] work3 = new double[nC]; [EOL]     final RealMatrix weightMatrixSqrt = getWeightSquareRoot(); [EOL]     double[] currentObjective = computeObjectiveValue(currentPoint); [EOL]     double[] currentResiduals = computeResiduals(currentObjective); [EOL]     PointVectorValuePair current = new PointVectorValuePair(currentPoint, currentObjective); [EOL]     double currentCost = computeCost(currentResiduals); [EOL]     lmPar = 0; [EOL]     boolean firstIteration = true; [EOL]     int iter = 0; [EOL]     final ConvergenceChecker<PointVectorValuePair> checker = getConvergenceChecker(); [EOL]     while (true) { [EOL]         ++iter; [EOL]         final PointVectorValuePair previous = current; [EOL]         qrDecomposition(computeWeightedJacobian(currentPoint)); [EOL]         weightedResidual = weightMatrixSqrt.operate(currentResiduals); [EOL]         for (int i = 0; i < nR; i++) { [EOL]             qtf[i] = weightedResidual[i]; [EOL]         } [EOL]         qTy(qtf); [EOL]         for (int k = 0; k < solvedCols; ++k) { [EOL]             int pk = permutation[k]; [EOL]             weightedJacobian[k][pk] = diagR[pk]; [EOL]         } [EOL]         if (firstIteration) { [EOL]             xNorm = 0; [EOL]             for (int k = 0; k < nC; ++k) { [EOL]                 double dk = jacNorm[k]; [EOL]                 if (dk == 0) { [EOL]                     dk = 1.0; [EOL]                 } [EOL]                 double xk = dk * currentPoint[k]; [EOL]                 xNorm += xk * xk; [EOL]                 diag[k] = dk; [EOL]             } [EOL]             xNorm = FastMath.sqrt(xNorm); [EOL]             delta = (xNorm == 0) ? initialStepBoundFactor : (initialStepBoundFactor * xNorm); [EOL]         } [EOL]         double maxCosine = 0; [EOL]         if (currentCost != 0) { [EOL]             for (int j = 0; j < solvedCols; ++j) { [EOL]                 int pj = permutation[j]; [EOL]                 double s = jacNorm[pj]; [EOL]                 if (s != 0) { [EOL]                     double sum = 0; [EOL]                     for (int i = 0; i <= j; ++i) { [EOL]                         sum += weightedJacobian[i][pj] * qtf[i]; [EOL]                     } [EOL]                     maxCosine = FastMath.max(maxCosine, FastMath.abs(sum) / (s * currentCost)); [EOL]                 } [EOL]             } [EOL]         } [EOL]         if (maxCosine <= orthoTolerance) { [EOL]             setCost(currentCost); [EOL]             point = current.getPoint(); [EOL]             return current; [EOL]         } [EOL]         for (int j = 0; j < nC; ++j) { [EOL]             diag[j] = FastMath.max(diag[j], jacNorm[j]); [EOL]         } [EOL]         for (double ratio = 0; ratio < 1.0e-4; ) { [EOL]             for (int j = 0; j < solvedCols; ++j) { [EOL]                 int pj = permutation[j]; [EOL]                 oldX[pj] = currentPoint[pj]; [EOL]             } [EOL]             final double previousCost = currentCost; [EOL]             double[] tmpVec = weightedResidual; [EOL]             weightedResidual = oldRes; [EOL]             oldRes = tmpVec; [EOL]             tmpVec = currentObjective; [EOL]             currentObjective = oldObj; [EOL]             oldObj = tmpVec; [EOL]             determineLMParameter(qtf, delta, diag, work1, work2, work3); [EOL]             double lmNorm = 0; [EOL]             for (int j = 0; j < solvedCols; ++j) { [EOL]                 int pj = permutation[j]; [EOL]                 lmDir[pj] = -lmDir[pj]; [EOL]                 currentPoint[pj] = oldX[pj] + lmDir[pj]; [EOL]                 double s = diag[pj] * lmDir[pj]; [EOL]                 lmNorm += s * s; [EOL]             } [EOL]             lmNorm = FastMath.sqrt(lmNorm); [EOL]             if (firstIteration) { [EOL]                 delta = FastMath.min(delta, lmNorm); [EOL]             } [EOL]             currentObjective = computeObjectiveValue(currentPoint); [EOL]             currentResiduals = computeResiduals(currentObjective); [EOL]             current = new PointVectorValuePair(currentPoint, currentObjective); [EOL]             currentCost = computeCost(currentResiduals); [EOL]             double actRed = -1.0; [EOL]             if (0.1 * currentCost < previousCost) { [EOL]                 double r = currentCost / previousCost; [EOL]                 actRed = 1.0 - r * r; [EOL]             } [EOL]             for (int j = 0; j < solvedCols; ++j) { [EOL]                 int pj = permutation[j]; [EOL]                 double dirJ = lmDir[pj]; [EOL]                 work1[j] = 0; [EOL]                 for (int i = 0; i <= j; ++i) { [EOL]                     work1[i] += weightedJacobian[i][pj] * dirJ; [EOL]                 } [EOL]             } [EOL]             double coeff1 = 0; [EOL]             for (int j = 0; j < solvedCols; ++j) { [EOL]                 coeff1 += work1[j] * work1[j]; [EOL]             } [EOL]             double pc2 = previousCost * previousCost; [EOL]             coeff1 = coeff1 / pc2; [EOL]             double coeff2 = lmPar * lmNorm * lmNorm / pc2; [EOL]             double preRed = coeff1 + 2 * coeff2; [EOL]             double dirDer = -(coeff1 + coeff2); [EOL]             ratio = (preRed == 0) ? 0 : (actRed / preRed); [EOL]             if (ratio <= 0.25) { [EOL]                 double tmp = (actRed < 0) ? (0.5 * dirDer / (dirDer + 0.5 * actRed)) : 0.5; [EOL]                 if ((0.1 * currentCost >= previousCost) || (tmp < 0.1)) { [EOL]                     tmp = 0.1; [EOL]                 } [EOL]                 delta = tmp * FastMath.min(delta, 10.0 * lmNorm); [EOL]                 lmPar /= tmp; [EOL]             } else if ((lmPar == 0) || (ratio >= 0.75)) { [EOL]                 delta = 2 * lmNorm; [EOL]                 lmPar *= 0.5; [EOL]             } [EOL]             if (ratio >= 1.0e-4) { [EOL]                 firstIteration = false; [EOL]                 xNorm = 0; [EOL]                 for (int k = 0; k < nC; ++k) { [EOL]                     double xK = diag[k] * currentPoint[k]; [EOL]                     xNorm += xK * xK; [EOL]                 } [EOL]                 xNorm = FastMath.sqrt(xNorm); [EOL]                 if (checker != null && checker.converged(iter, previous, current)) { [EOL]                     setCost(currentCost); [EOL]                     point = current.getPoint(); [EOL]                     return current; [EOL]                 } [EOL]             } else { [EOL]                 currentCost = previousCost; [EOL]                 for (int j = 0; j < solvedCols; ++j) { [EOL]                     int pj = permutation[j]; [EOL]                     currentPoint[pj] = oldX[pj]; [EOL]                 } [EOL]                 tmpVec = weightedResidual; [EOL]                 weightedResidual = oldRes; [EOL]                 oldRes = tmpVec; [EOL]                 tmpVec = currentObjective; [EOL]                 currentObjective = oldObj; [EOL]                 oldObj = tmpVec; [EOL]                 current = new PointVectorValuePair(currentPoint, currentObjective); [EOL]             } [EOL]             if ((FastMath.abs(actRed) <= costRelativeTolerance && preRed <= costRelativeTolerance && ratio <= 2.0) || delta <= parRelativeTolerance * xNorm) { [EOL]                 setCost(currentCost); [EOL]                 point = current.getPoint(); [EOL]                 return current; [EOL]             } [EOL]             if ((FastMath.abs(actRed) <= 2.2204e-16) && (preRed <= 2.2204e-16) && (ratio <= 2.0)) { [EOL]                 throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, costRelativeTolerance); [EOL]             } else if (delta <= 2.2204e-16 * xNorm) { [EOL]                 throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, parRelativeTolerance); [EOL]             } else if (maxCosine <= 2.2204e-16) { [EOL]                 throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, orthoTolerance); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 279,531
private void determineLMParameter(double[] qy, double delta, double[] diag, double[] work1, double[] work2, double[] work3) { [EOL]     final int nC = weightedJacobian[0].length; [EOL]     for (int j = 0; j < rank; ++j) { [EOL]         lmDir[permutation[j]] = qy[j]; [EOL]     } [EOL]     for (int j = rank; j < nC; ++j) { [EOL]         lmDir[permutation[j]] = 0; [EOL]     } [EOL]     for (int k = rank - 1; k >= 0; --k) { [EOL]         int pk = permutation[k]; [EOL]         double ypk = lmDir[pk] / diagR[pk]; [EOL]         for (int i = 0; i < k; ++i) { [EOL]             lmDir[permutation[i]] -= ypk * weightedJacobian[i][pk]; [EOL]         } [EOL]         lmDir[pk] = ypk; [EOL]     } [EOL]     double dxNorm = 0; [EOL]     for (int j = 0; j < solvedCols; ++j) { [EOL]         int pj = permutation[j]; [EOL]         double s = diag[pj] * lmDir[pj]; [EOL]         work1[pj] = s; [EOL]         dxNorm += s * s; [EOL]     } [EOL]     dxNorm = FastMath.sqrt(dxNorm); [EOL]     double fp = dxNorm - delta; [EOL]     if (fp <= 0.1 * delta) { [EOL]         lmPar = 0; [EOL]         return; [EOL]     } [EOL]     double sum2; [EOL]     double parl = 0; [EOL]     if (rank == solvedCols) { [EOL]         for (int j = 0; j < solvedCols; ++j) { [EOL]             int pj = permutation[j]; [EOL]             work1[pj] *= diag[pj] / dxNorm; [EOL]         } [EOL]         sum2 = 0; [EOL]         for (int j = 0; j < solvedCols; ++j) { [EOL]             int pj = permutation[j]; [EOL]             double sum = 0; [EOL]             for (int i = 0; i < j; ++i) { [EOL]                 sum += weightedJacobian[i][pj] * work1[permutation[i]]; [EOL]             } [EOL]             double s = (work1[pj] - sum) / diagR[pj]; [EOL]             work1[pj] = s; [EOL]             sum2 += s * s; [EOL]         } [EOL]         parl = fp / (delta * sum2); [EOL]     } [EOL]     sum2 = 0; [EOL]     for (int j = 0; j < solvedCols; ++j) { [EOL]         int pj = permutation[j]; [EOL]         double sum = 0; [EOL]         for (int i = 0; i <= j; ++i) { [EOL]             sum += weightedJacobian[i][pj] * qy[i]; [EOL]         } [EOL]         sum /= diag[pj]; [EOL]         sum2 += sum * sum; [EOL]     } [EOL]     double gNorm = FastMath.sqrt(sum2); [EOL]     double paru = gNorm / delta; [EOL]     if (paru == 0) { [EOL]         paru = 2.2251e-308 / FastMath.min(delta, 0.1); [EOL]     } [EOL]     lmPar = FastMath.min(paru, FastMath.max(lmPar, parl)); [EOL]     if (lmPar == 0) { [EOL]         lmPar = gNorm / dxNorm; [EOL]     } [EOL]     for (int countdown = 10; countdown >= 0; --countdown) { [EOL]         if (lmPar == 0) { [EOL]             lmPar = FastMath.max(2.2251e-308, 0.001 * paru); [EOL]         } [EOL]         double sPar = FastMath.sqrt(lmPar); [EOL]         for (int j = 0; j < solvedCols; ++j) { [EOL]             int pj = permutation[j]; [EOL]             work1[pj] = sPar * diag[pj]; [EOL]         } [EOL]         determineLMDirection(qy, work1, work2, work3); [EOL]         dxNorm = 0; [EOL]         for (int j = 0; j < solvedCols; ++j) { [EOL]             int pj = permutation[j]; [EOL]             double s = diag[pj] * lmDir[pj]; [EOL]             work3[pj] = s; [EOL]             dxNorm += s * s; [EOL]         } [EOL]         dxNorm = FastMath.sqrt(dxNorm); [EOL]         double previousFP = fp; [EOL]         fp = dxNorm - delta; [EOL]         if ((FastMath.abs(fp) <= 0.1 * delta) || ((parl == 0) && (fp <= previousFP) && (previousFP < 0))) { [EOL]             return; [EOL]         } [EOL]         for (int j = 0; j < solvedCols; ++j) { [EOL]             int pj = permutation[j]; [EOL]             work1[pj] = work3[pj] * diag[pj] / dxNorm; [EOL]         } [EOL]         for (int j = 0; j < solvedCols; ++j) { [EOL]             int pj = permutation[j]; [EOL]             work1[pj] /= work2[j]; [EOL]             double tmp = work1[pj]; [EOL]             for (int i = j + 1; i < solvedCols; ++i) { [EOL]                 work1[permutation[i]] -= weightedJacobian[i][pj] * tmp; [EOL]             } [EOL]         } [EOL]         sum2 = 0; [EOL]         for (int j = 0; j < solvedCols; ++j) { [EOL]             double s = work1[permutation[j]]; [EOL]             sum2 += s * s; [EOL]         } [EOL]         double correction = fp / (delta * sum2); [EOL]         if (fp > 0) { [EOL]             parl = FastMath.max(parl, lmPar); [EOL]         } else if (fp < 0) { [EOL]             paru = FastMath.min(paru, lmPar); [EOL]         } [EOL]         lmPar = FastMath.max(parl, lmPar + correction); [EOL]     } [EOL] } <line_num>: 555,703
private void determineLMDirection(double[] qy, double[] diag, double[] lmDiag, double[] work) { [EOL]     for (int j = 0; j < solvedCols; ++j) { [EOL]         int pj = permutation[j]; [EOL]         for (int i = j + 1; i < solvedCols; ++i) { [EOL]             weightedJacobian[i][pj] = weightedJacobian[j][permutation[i]]; [EOL]         } [EOL]         lmDir[j] = diagR[pj]; [EOL]         work[j] = qy[j]; [EOL]     } [EOL]     for (int j = 0; j < solvedCols; ++j) { [EOL]         int pj = permutation[j]; [EOL]         double dpj = diag[pj]; [EOL]         if (dpj != 0) { [EOL]             Arrays.fill(lmDiag, j + 1, lmDiag.length, 0); [EOL]         } [EOL]         lmDiag[j] = dpj; [EOL]         double qtbpj = 0; [EOL]         for (int k = j; k < solvedCols; ++k) { [EOL]             int pk = permutation[k]; [EOL]             if (lmDiag[k] != 0) { [EOL]                 final double sin; [EOL]                 final double cos; [EOL]                 double rkk = weightedJacobian[k][pk]; [EOL]                 if (FastMath.abs(rkk) < FastMath.abs(lmDiag[k])) { [EOL]                     final double cotan = rkk / lmDiag[k]; [EOL]                     sin = 1.0 / FastMath.sqrt(1.0 + cotan * cotan); [EOL]                     cos = sin * cotan; [EOL]                 } else { [EOL]                     final double tan = lmDiag[k] / rkk; [EOL]                     cos = 1.0 / FastMath.sqrt(1.0 + tan * tan); [EOL]                     sin = cos * tan; [EOL]                 } [EOL]                 weightedJacobian[k][pk] = cos * rkk + sin * lmDiag[k]; [EOL]                 final double temp = cos * work[k] + sin * qtbpj; [EOL]                 qtbpj = -sin * work[k] + cos * qtbpj; [EOL]                 work[k] = temp; [EOL]                 for (int i = k + 1; i < solvedCols; ++i) { [EOL]                     double rik = weightedJacobian[i][pk]; [EOL]                     final double temp2 = cos * rik + sin * lmDiag[i]; [EOL]                     lmDiag[i] = -sin * rik + cos * lmDiag[i]; [EOL]                     weightedJacobian[i][pk] = temp2; [EOL]                 } [EOL]             } [EOL]         } [EOL]         lmDiag[j] = weightedJacobian[j][permutation[j]]; [EOL]         weightedJacobian[j][permutation[j]] = lmDir[j]; [EOL]     } [EOL]     int nSing = solvedCols; [EOL]     for (int j = 0; j < solvedCols; ++j) { [EOL]         if ((lmDiag[j] == 0) && (nSing == solvedCols)) { [EOL]             nSing = j; [EOL]         } [EOL]         if (nSing < solvedCols) { [EOL]             work[j] = 0; [EOL]         } [EOL]     } [EOL]     if (nSing > 0) { [EOL]         for (int j = nSing - 1; j >= 0; --j) { [EOL]             int pj = permutation[j]; [EOL]             double sum = 0; [EOL]             for (int i = j + 1; i < nSing; ++i) { [EOL]                 sum += weightedJacobian[i][pj] * work[i]; [EOL]             } [EOL]             work[j] = (work[j] - sum) / lmDiag[j]; [EOL]         } [EOL]     } [EOL]     for (int j = 0; j < lmDir.length; ++j) { [EOL]         lmDir[permutation[j]] = work[j]; [EOL]     } [EOL] } <line_num>: 725,824
private void qrDecomposition(RealMatrix jacobian) throws ConvergenceException { [EOL]     weightedJacobian = jacobian.scalarMultiply(-1).getData(); [EOL]     final int nR = weightedJacobian.length; [EOL]     final int nC = weightedJacobian[0].length; [EOL]     for (int k = 0; k < nC; ++k) { [EOL]         permutation[k] = k; [EOL]         double norm2 = 0; [EOL]         for (int i = 0; i < nR; ++i) { [EOL]             double akk = weightedJacobian[i][k]; [EOL]             norm2 += akk * akk; [EOL]         } [EOL]         jacNorm[k] = FastMath.sqrt(norm2); [EOL]     } [EOL]     for (int k = 0; k < nC; ++k) { [EOL]         int nextColumn = -1; [EOL]         double ak2 = Double.NEGATIVE_INFINITY; [EOL]         for (int i = k; i < nC; ++i) { [EOL]             double norm2 = 0; [EOL]             for (int j = k; j < nR; ++j) { [EOL]                 double aki = weightedJacobian[j][permutation[i]]; [EOL]                 norm2 += aki * aki; [EOL]             } [EOL]             if (Double.isInfinite(norm2) || Double.isNaN(norm2)) { [EOL]                 throw new ConvergenceException(LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, nR, nC); [EOL]             } [EOL]             if (norm2 > ak2) { [EOL]                 nextColumn = i; [EOL]                 ak2 = norm2; [EOL]             } [EOL]         } [EOL]         if (ak2 <= qrRankingThreshold) { [EOL]             rank = k; [EOL]             return; [EOL]         } [EOL]         int pk = permutation[nextColumn]; [EOL]         permutation[nextColumn] = permutation[k]; [EOL]         permutation[k] = pk; [EOL]         double akk = weightedJacobian[k][pk]; [EOL]         double alpha = (akk > 0) ? -FastMath.sqrt(ak2) : FastMath.sqrt(ak2); [EOL]         double betak = 1.0 / (ak2 - akk * alpha); [EOL]         beta[pk] = betak; [EOL]         diagR[pk] = alpha; [EOL]         weightedJacobian[k][pk] -= alpha; [EOL]         for (int dk = nC - 1 - k; dk > 0; --dk) { [EOL]             double gamma = 0; [EOL]             for (int j = k; j < nR; ++j) { [EOL]                 gamma += weightedJacobian[j][pk] * weightedJacobian[j][permutation[k + dk]]; [EOL]             } [EOL]             gamma *= betak; [EOL]             for (int j = k; j < nR; ++j) { [EOL]                 weightedJacobian[j][permutation[k + dk]] -= gamma * weightedJacobian[j][pk]; [EOL]             } [EOL]         } [EOL]     } [EOL]     rank = solvedCols; [EOL] } <line_num>: 850,921
private void qTy(double[] y) { [EOL]     final int nR = weightedJacobian.length; [EOL]     final int nC = weightedJacobian[0].length; [EOL]     for (int k = 0; k < nC; ++k) { [EOL]         int pk = permutation[k]; [EOL]         double gamma = 0; [EOL]         for (int i = k; i < nR; ++i) { [EOL]             gamma += weightedJacobian[i][pk] * y[i]; [EOL]         } [EOL]         gamma *= beta[pk]; [EOL]         for (int i = k; i < nR; ++i) { [EOL]             y[i] -= gamma * weightedJacobian[i][pk]; [EOL]         } [EOL]     } [EOL] } <line_num>: 928,943
