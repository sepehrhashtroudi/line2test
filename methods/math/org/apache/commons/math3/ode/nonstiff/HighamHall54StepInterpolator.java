public HighamHall54StepInterpolator() { [EOL]     super(); [EOL] } <line_num>: 49,51
public HighamHall54StepInterpolator(final HighamHall54StepInterpolator interpolator) { [EOL]     super(interpolator); [EOL] } <line_num>: 58,60
@Override [EOL] protected StepInterpolator doCopy() { [EOL]     return new HighamHall54StepInterpolator(this); [EOL] } <line_num>: 63,66
@Override [EOL] protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) { [EOL]     final double bDot0 = 1 + theta * (-15.0 / 2.0 + theta * (16.0 - 10.0 * theta)); [EOL]     final double bDot2 = theta * (459.0 / 16.0 + theta * (-729.0 / 8.0 + 135.0 / 2.0 * theta)); [EOL]     final double bDot3 = theta * (-44.0 + theta * (152.0 - 120.0 * theta)); [EOL]     final double bDot4 = theta * (375.0 / 16.0 + theta * (-625.0 / 8.0 + 125.0 / 2.0 * theta)); [EOL]     final double bDot5 = theta * 5.0 / 8.0 * (2 * theta - 1); [EOL]     if ((previousState != null) && (theta <= 0.5)) { [EOL]         final double hTheta = h * theta; [EOL]         final double b0 = hTheta * (1.0 + theta * (-15.0 / 4.0 + theta * (16.0 / 3.0 - 5.0 / 2.0 * theta))); [EOL]         final double b2 = hTheta * (theta * (459.0 / 32.0 + theta * (-243.0 / 8.0 + theta * 135.0 / 8.0))); [EOL]         final double b3 = hTheta * (theta * (-22.0 + theta * (152.0 / 3.0 + theta * -30.0))); [EOL]         final double b4 = hTheta * (theta * (375.0 / 32.0 + theta * (-625.0 / 24.0 + theta * 125.0 / 8.0))); [EOL]         final double b5 = hTheta * (theta * (-5.0 / 16.0 + theta * 5.0 / 12.0)); [EOL]         for (int i = 0; i < interpolatedState.length; ++i) { [EOL]             final double yDot0 = yDotK[0][i]; [EOL]             final double yDot2 = yDotK[2][i]; [EOL]             final double yDot3 = yDotK[3][i]; [EOL]             final double yDot4 = yDotK[4][i]; [EOL]             final double yDot5 = yDotK[5][i]; [EOL]             interpolatedState[i] = previousState[i] + b0 * yDot0 + b2 * yDot2 + b3 * yDot3 + b4 * yDot4 + b5 * yDot5; [EOL]             interpolatedDerivatives[i] = bDot0 * yDot0 + bDot2 * yDot2 + bDot3 * yDot3 + bDot4 * yDot4 + bDot5 * yDot5; [EOL]         } [EOL]     } else { [EOL]         final double theta2 = theta * theta; [EOL]         final double b0 = h * (-1.0 / 12.0 + theta * (1.0 + theta * (-15.0 / 4.0 + theta * (16.0 / 3.0 + theta * -5.0 / 2.0)))); [EOL]         final double b2 = h * (-27.0 / 32.0 + theta2 * (459.0 / 32.0 + theta * (-243.0 / 8.0 + theta * 135.0 / 8.0))); [EOL]         final double b3 = h * (4.0 / 3.0 + theta2 * (-22.0 + theta * (152.0 / 3.0 + theta * -30.0))); [EOL]         final double b4 = h * (-125.0 / 96.0 + theta2 * (375.0 / 32.0 + theta * (-625.0 / 24.0 + theta * 125.0 / 8.0))); [EOL]         final double b5 = h * (-5.0 / 48.0 + theta2 * (-5.0 / 16.0 + theta * 5.0 / 12.0)); [EOL]         for (int i = 0; i < interpolatedState.length; ++i) { [EOL]             final double yDot0 = yDotK[0][i]; [EOL]             final double yDot2 = yDotK[2][i]; [EOL]             final double yDot3 = yDotK[3][i]; [EOL]             final double yDot4 = yDotK[4][i]; [EOL]             final double yDot5 = yDotK[5][i]; [EOL]             interpolatedState[i] = currentState[i] + b0 * yDot0 + b2 * yDot2 + b3 * yDot3 + b4 * yDot4 + b5 * yDot5; [EOL]             interpolatedDerivatives[i] = bDot0 * yDot0 + bDot2 * yDot2 + bDot3 * yDot3 + bDot4 * yDot4 + bDot5 * yDot5; [EOL]         } [EOL]     } [EOL] } <line_num>: 70,118
