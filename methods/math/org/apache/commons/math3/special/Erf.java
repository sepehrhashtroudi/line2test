private Erf() { [EOL] } <line_num>: 44,44
public static double erf(double x) { [EOL]     if (FastMath.abs(x) > 40) { [EOL]         return x > 0 ? 1 : -1; [EOL]     } [EOL]     final double ret = Gamma.regularizedGammaP(0.5, x * x, 1.0e-15, 10000); [EOL]     return x < 0 ? -ret : ret; [EOL] } <line_num>: 66,72
public static double erfc(double x) { [EOL]     if (FastMath.abs(x) > 40) { [EOL]         return x > 0 ? 0 : 2; [EOL]     } [EOL]     final double ret = Gamma.regularizedGammaQ(0.5, x * x, 1.0e-15, 10000); [EOL]     return x < 0 ? 2 - ret : ret; [EOL] } <line_num>: 97,103
public static double erf(double x1, double x2) { [EOL]     if (x1 > x2) { [EOL]         return -erf(x2, x1); [EOL]     } [EOL]     return x1 < -X_CRIT ? x2 < 0.0 ? erfc(-x2) - erfc(-x1) : erf(x2) - erf(x1) : x2 > X_CRIT && x1 > 0.0 ? erfc(x1) - erfc(x2) : erf(x2) - erf(x1); [EOL] } <line_num>: 115,128
public static double erfInv(final double x) { [EOL]     double w = -FastMath.log((1.0 - x) * (1.0 + x)); [EOL]     double p; [EOL]     if (w < 6.25) { [EOL]         w = w - 3.125; [EOL]         p = -3.6444120640178196996e-21; [EOL]         p = -1.685059138182016589e-19 + p * w; [EOL]         p = 1.2858480715256400167e-18 + p * w; [EOL]         p = 1.115787767802518096e-17 + p * w; [EOL]         p = -1.333171662854620906e-16 + p * w; [EOL]         p = 2.0972767875968561637e-17 + p * w; [EOL]         p = 6.6376381343583238325e-15 + p * w; [EOL]         p = -4.0545662729752068639e-14 + p * w; [EOL]         p = -8.1519341976054721522e-14 + p * w; [EOL]         p = 2.6335093153082322977e-12 + p * w; [EOL]         p = -1.2975133253453532498e-11 + p * w; [EOL]         p = -5.4154120542946279317e-11 + p * w; [EOL]         p = 1.051212273321532285e-09 + p * w; [EOL]         p = -4.1126339803469836976e-09 + p * w; [EOL]         p = -2.9070369957882005086e-08 + p * w; [EOL]         p = 4.2347877827932403518e-07 + p * w; [EOL]         p = -1.3654692000834678645e-06 + p * w; [EOL]         p = -1.3882523362786468719e-05 + p * w; [EOL]         p = 0.0001867342080340571352 + p * w; [EOL]         p = -0.00074070253416626697512 + p * w; [EOL]         p = -0.0060336708714301490533 + p * w; [EOL]         p = 0.24015818242558961693 + p * w; [EOL]         p = 1.6536545626831027356 + p * w; [EOL]     } else if (w < 16.0) { [EOL]         w = FastMath.sqrt(w) - 3.25; [EOL]         p = 2.2137376921775787049e-09; [EOL]         p = 9.0756561938885390979e-08 + p * w; [EOL]         p = -2.7517406297064545428e-07 + p * w; [EOL]         p = 1.8239629214389227755e-08 + p * w; [EOL]         p = 1.5027403968909827627e-06 + p * w; [EOL]         p = -4.013867526981545969e-06 + p * w; [EOL]         p = 2.9234449089955446044e-06 + p * w; [EOL]         p = 1.2475304481671778723e-05 + p * w; [EOL]         p = -4.7318229009055733981e-05 + p * w; [EOL]         p = 6.8284851459573175448e-05 + p * w; [EOL]         p = 2.4031110387097893999e-05 + p * w; [EOL]         p = -0.0003550375203628474796 + p * w; [EOL]         p = 0.00095328937973738049703 + p * w; [EOL]         p = -0.0016882755560235047313 + p * w; [EOL]         p = 0.0024914420961078508066 + p * w; [EOL]         p = -0.0037512085075692412107 + p * w; [EOL]         p = 0.005370914553590063617 + p * w; [EOL]         p = 1.0052589676941592334 + p * w; [EOL]         p = 3.0838856104922207635 + p * w; [EOL]     } else if (!Double.isInfinite(w)) { [EOL]         w = FastMath.sqrt(w) - 5.0; [EOL]         p = -2.7109920616438573243e-11; [EOL]         p = -2.5556418169965252055e-10 + p * w; [EOL]         p = 1.5076572693500548083e-09 + p * w; [EOL]         p = -3.7894654401267369937e-09 + p * w; [EOL]         p = 7.6157012080783393804e-09 + p * w; [EOL]         p = -1.4960026627149240478e-08 + p * w; [EOL]         p = 2.9147953450901080826e-08 + p * w; [EOL]         p = -6.7711997758452339498e-08 + p * w; [EOL]         p = 2.2900482228026654717e-07 + p * w; [EOL]         p = -9.9298272942317002539e-07 + p * w; [EOL]         p = 4.5260625972231537039e-06 + p * w; [EOL]         p = -1.9681778105531670567e-05 + p * w; [EOL]         p = 7.5995277030017761139e-05 + p * w; [EOL]         p = -0.00021503011930044477347 + p * w; [EOL]         p = -0.00013871931833623122026 + p * w; [EOL]         p = 1.0103004648645343977 + p * w; [EOL]         p = 4.8499064014085844221 + p * w; [EOL]     } else { [EOL]         p = Double.POSITIVE_INFINITY; [EOL]     } [EOL]     return p * x; [EOL] } <line_num>: 143,231
public static double erfcInv(final double x) { [EOL]     return erfInv(1 - x); [EOL] } <line_num>: 239,241