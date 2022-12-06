public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException { [EOL]     final double h = 0.001 * (interpolator.getCurrentTime() - interpolator.getPreviousTime()); [EOL]     final double t = interpolator.getCurrentTime() - 300 * h; [EOL]     if (FastMath.abs(h) < 10 * FastMath.ulp(t)) { [EOL]         return; [EOL]     } [EOL]     interpolator.setInterpolatedTime(t - 4 * h); [EOL]     final double[] yM4h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t - 3 * h); [EOL]     final double[] yM3h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t - 2 * h); [EOL]     final double[] yM2h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t - h); [EOL]     final double[] yM1h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t + h); [EOL]     final double[] yP1h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t + 2 * h); [EOL]     final double[] yP2h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t + 3 * h); [EOL]     final double[] yP3h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t + 4 * h); [EOL]     final double[] yP4h = interpolator.getInterpolatedState().clone(); [EOL]     interpolator.setInterpolatedTime(t); [EOL]     final double[] yDot = interpolator.getInterpolatedDerivatives(); [EOL]     for (int i = 0; i < yDot.length; ++i) { [EOL]         final double approYDot = (-3 * (yP4h[i] - yM4h[i]) + 32 * (yP3h[i] - yM3h[i]) + -168 * (yP2h[i] - yM2h[i]) + 672 * (yP1h[i] - yM1h[i])) / (840 * h); [EOL]         Assert.assertEquals(approYDot, yDot[i], threshold); [EOL]     } [EOL] } <line_num>: 38,76
public void init(double t0, double[] y0, double t) { [EOL] } <line_num>: 78,79
public static void checkDerivativesConsistency(final FirstOrderIntegrator integrator, final TestProblemAbstract problem, final double threshold) throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException { [EOL]     integrator.addStepHandler(new StepHandler() { [EOL]  [EOL]         public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException { [EOL]             final double h = 0.001 * (interpolator.getCurrentTime() - interpolator.getPreviousTime()); [EOL]             final double t = interpolator.getCurrentTime() - 300 * h; [EOL]             if (FastMath.abs(h) < 10 * FastMath.ulp(t)) { [EOL]                 return; [EOL]             } [EOL]             interpolator.setInterpolatedTime(t - 4 * h); [EOL]             final double[] yM4h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t - 3 * h); [EOL]             final double[] yM3h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t - 2 * h); [EOL]             final double[] yM2h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t - h); [EOL]             final double[] yM1h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t + h); [EOL]             final double[] yP1h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t + 2 * h); [EOL]             final double[] yP2h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t + 3 * h); [EOL]             final double[] yP3h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t + 4 * h); [EOL]             final double[] yP4h = interpolator.getInterpolatedState().clone(); [EOL]             interpolator.setInterpolatedTime(t); [EOL]             final double[] yDot = interpolator.getInterpolatedDerivatives(); [EOL]             for (int i = 0; i < yDot.length; ++i) { [EOL]                 final double approYDot = (-3 * (yP4h[i] - yM4h[i]) + 32 * (yP3h[i] - yM3h[i]) + -168 * (yP2h[i] - yM2h[i]) + 672 * (yP1h[i] - yM1h[i])) / (840 * h); [EOL]                 Assert.assertEquals(approYDot, yDot[i], threshold); [EOL]             } [EOL]         } [EOL]  [EOL]         public void init(double t0, double[] y0, double t) { [EOL]         } [EOL]     }); [EOL]     integrator.integrate(problem, problem.getInitialTime(), problem.getInitialState(), problem.getFinalTime(), new double[problem.getDimension()]); [EOL] } <line_num>: 31,87