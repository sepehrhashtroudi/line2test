public GrayPaintScale() { [EOL]     this(0.0, 1.0); [EOL] } <line_num>: 78,80
public GrayPaintScale(double lowerBound, double upperBound) { [EOL]     this(lowerBound, upperBound, 255); [EOL] } <line_num>: 91,93
public GrayPaintScale(double lowerBound, double upperBound, int alpha) { [EOL]     if (lowerBound >= upperBound) { [EOL]         throw new IllegalArgumentException("Requires lowerBound < upperBound."); [EOL]     } [EOL]     if (alpha < 0 || alpha > 255) { [EOL]         throw new IllegalArgumentException("Requires alpha in the range 0 to 255."); [EOL]     } [EOL]     this.lowerBound = lowerBound; [EOL]     this.upperBound = upperBound; [EOL]     this.alpha = alpha; [EOL] } <line_num>: 108,121
public double getLowerBound() { [EOL]     return this.lowerBound; [EOL] } <line_num>: 130,132
public double getUpperBound() { [EOL]     return this.upperBound; [EOL] } <line_num>: 141,143
public int getAlpha() { [EOL]     return this.alpha; [EOL] } <line_num>: 152,154
public Paint getPaint(double value) { [EOL]     double v = Math.max(value, this.lowerBound); [EOL]     v = Math.min(v, this.upperBound); [EOL]     int g = (int) ((v - this.lowerBound) / (this.upperBound - this.lowerBound) * 255.0); [EOL]     return new Color(g, g, g, this.alpha); [EOL] } <line_num>: 164,170
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof GrayPaintScale)) { [EOL]         return false; [EOL]     } [EOL]     GrayPaintScale that = (GrayPaintScale) obj; [EOL]     if (this.lowerBound != that.lowerBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.upperBound != that.upperBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.alpha != that.alpha) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 185,203
public int hashCode() { [EOL]     int hash = 7; [EOL]     hash = HashUtilities.hashCode(hash, this.lowerBound); [EOL]     hash = HashUtilities.hashCode(hash, this.upperBound); [EOL]     hash = 43 * hash + this.alpha; [EOL]     return hash; [EOL] } <line_num>: 210,216
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 226,228