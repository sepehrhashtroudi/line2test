public ModuloAxis(String label, Range fixedRange) { [EOL]     super(label); [EOL]     this.fixedRange = fixedRange; [EOL]     this.displayStart = 270.0; [EOL]     this.displayEnd = 90.0; [EOL] } <line_num>: 80,85
public double getDisplayStart() { [EOL]     return this.displayStart; [EOL] } <line_num>: 92,94
public double getDisplayEnd() { [EOL]     return this.displayEnd; [EOL] } <line_num>: 101,103
public void setDisplayRange(double start, double end) { [EOL]     this.displayStart = mapValueToFixedRange(start); [EOL]     this.displayEnd = mapValueToFixedRange(end); [EOL]     if (this.displayStart < this.displayEnd) { [EOL]         setRange(this.displayStart, this.displayEnd); [EOL]     } else { [EOL]         setRange(this.displayStart, this.fixedRange.getUpperBound() + (this.displayEnd - this.fixedRange.getLowerBound())); [EOL]     } [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 112,123
protected void autoAdjustRange() { [EOL]     setRange(this.fixedRange, false, false); [EOL] } <line_num>: 129,131
public double valueToJava2D(double value, Rectangle2D area, RectangleEdge edge) { [EOL]     double result = 0.0; [EOL]     double v = mapValueToFixedRange(value); [EOL]     if (this.displayStart < this.displayEnd) { [EOL]         result = trans(v, area, edge); [EOL]     } else { [EOL]         double cutoff = (this.displayStart + this.displayEnd) / 2.0; [EOL]         double length1 = this.fixedRange.getUpperBound() - this.displayStart; [EOL]         double length2 = this.displayEnd - this.fixedRange.getLowerBound(); [EOL]         if (v > cutoff) { [EOL]             result = transStart(v, area, edge, length1, length2); [EOL]         } else { [EOL]             result = transEnd(v, area, edge, length1, length2); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 142,162
private double trans(double value, Rectangle2D area, RectangleEdge edge) { [EOL]     double min = 0.0; [EOL]     double max = 0.0; [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         min = area.getX(); [EOL]         max = area.getX() + area.getWidth(); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         min = area.getMaxY(); [EOL]         max = area.getMaxY() - area.getHeight(); [EOL]     } [EOL]     if (isInverted()) { [EOL]         return max - ((value - this.displayStart) / (this.displayEnd - this.displayStart)) * (max - min); [EOL]     } else { [EOL]         return min + ((value - this.displayStart) / (this.displayEnd - this.displayStart)) * (max - min); [EOL]     } [EOL] } <line_num>: 173,193
private double transStart(double value, Rectangle2D area, RectangleEdge edge, double length1, double length2) { [EOL]     double min = 0.0; [EOL]     double max = 0.0; [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         min = area.getX(); [EOL]         max = area.getX() + area.getWidth() * length1 / (length1 + length2); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         min = area.getMaxY(); [EOL]         max = area.getMaxY() - area.getHeight() * length1 / (length1 + length2); [EOL]     } [EOL]     if (isInverted()) { [EOL]         return max - ((value - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart)) * (max - min); [EOL]     } else { [EOL]         return min + ((value - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart)) * (max - min); [EOL]     } [EOL] } <line_num>: 207,232
private double transEnd(double value, Rectangle2D area, RectangleEdge edge, double length1, double length2) { [EOL]     double min = 0.0; [EOL]     double max = 0.0; [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         max = area.getMaxX(); [EOL]         min = area.getMaxX() - area.getWidth() * length2 / (length1 + length2); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         max = area.getMinY(); [EOL]         min = area.getMinY() + area.getHeight() * length2 / (length1 + length2); [EOL]     } [EOL]     if (isInverted()) { [EOL]         return max - ((value - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound())) * (max - min); [EOL]     } else { [EOL]         return min + ((value - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound())) * (max - min); [EOL]     } [EOL] } <line_num>: 246,271
private double mapValueToFixedRange(double value) { [EOL]     double lower = this.fixedRange.getLowerBound(); [EOL]     double length = this.fixedRange.getLength(); [EOL]     if (value < lower) { [EOL]         return lower + length + ((value - lower) % length); [EOL]     } else { [EOL]         return lower + ((value - lower) % length); [EOL]     } [EOL] } <line_num>: 280,289
public double java2DToValue(double java2DValue, Rectangle2D area, RectangleEdge edge) { [EOL]     double result = 0.0; [EOL]     if (this.displayStart < this.displayEnd) { [EOL]         result = super.java2DToValue(java2DValue, area, edge); [EOL]     } else { [EOL]     } [EOL]     return result; [EOL] } <line_num>: 300,310
private double getDisplayLength() { [EOL]     if (this.displayStart < this.displayEnd) { [EOL]         return (this.displayEnd - this.displayStart); [EOL]     } else { [EOL]         return (this.fixedRange.getUpperBound() - this.displayStart) + (this.displayEnd - this.fixedRange.getLowerBound()); [EOL]     } [EOL] } <line_num>: 317,325
private double getDisplayCentralValue() { [EOL]     return mapValueToFixedRange(this.displayStart + (getDisplayLength() / 2)); [EOL] } <line_num>: 332,336
public void resizeRange(double percent) { [EOL]     resizeRange(percent, getDisplayCentralValue()); [EOL] } <line_num>: 348,350
public void resizeRange(double percent, double anchorValue) { [EOL]     if (percent > 0.0) { [EOL]         double halfLength = getDisplayLength() * percent / 2; [EOL]         setDisplayRange(anchorValue - halfLength, anchorValue + halfLength); [EOL]     } else { [EOL]         setAutoRange(true); [EOL]     } [EOL] } <line_num>: 363,373
public double lengthToJava2D(double length, Rectangle2D area, RectangleEdge edge) { [EOL]     double axisLength = 0.0; [EOL]     if (this.displayEnd > this.displayStart) { [EOL]         axisLength = this.displayEnd - this.displayStart; [EOL]     } else { [EOL]         axisLength = (this.fixedRange.getUpperBound() - this.displayStart) + (this.displayEnd - this.fixedRange.getLowerBound()); [EOL]     } [EOL]     double areaLength = 0.0; [EOL]     if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         areaLength = area.getHeight(); [EOL]     } else { [EOL]         areaLength = area.getWidth(); [EOL]     } [EOL]     return (length / axisLength) * areaLength; [EOL] } <line_num>: 385,403
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof ModuloAxis)) { [EOL]         return false; [EOL]     } [EOL]     ModuloAxis that = (ModuloAxis) obj; [EOL]     if (this.displayStart != that.displayStart) { [EOL]         return false; [EOL]     } [EOL]     if (this.displayEnd != that.displayEnd) { [EOL]         return false; [EOL]     } [EOL]     if (!this.fixedRange.equals(that.fixedRange)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 412,430