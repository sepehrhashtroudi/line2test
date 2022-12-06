public ArcDialFrame() { [EOL]     this(0, 180); [EOL] } <line_num>: 117,119
public ArcDialFrame(double startAngle, double extent) { [EOL]     this.backgroundPaint = Color.gray; [EOL]     this.foregroundPaint = new Color(100, 100, 150); [EOL]     this.stroke = new BasicStroke(2.0f); [EOL]     this.innerRadius = 0.25; [EOL]     this.outerRadius = 0.75; [EOL]     this.startAngle = startAngle; [EOL]     this.extent = extent; [EOL] } <line_num>: 128,136
public Paint getBackgroundPaint() { [EOL]     return this.backgroundPaint; [EOL] } <line_num>: 145,147
public void setBackgroundPaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.backgroundPaint = paint; [EOL]     notifyListeners(new DialLayerChangeEvent(this)); [EOL] } <line_num>: 157,163
public Paint getForegroundPaint() { [EOL]     return this.foregroundPaint; [EOL] } <line_num>: 172,174
public void setForegroundPaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.foregroundPaint = paint; [EOL]     notifyListeners(new DialLayerChangeEvent(this)); [EOL] } <line_num>: 184,190
public Stroke getStroke() { [EOL]     return this.stroke; [EOL] } <line_num>: 199,201
public void setStroke(Stroke stroke) { [EOL]     if (stroke == null) { [EOL]         throw new IllegalArgumentException("Null 'stroke' argument."); [EOL]     } [EOL]     this.stroke = stroke; [EOL]     notifyListeners(new DialLayerChangeEvent(this)); [EOL] } <line_num>: 211,217
public double getInnerRadius() { [EOL]     return this.innerRadius; [EOL] } <line_num>: 226,228
public void setInnerRadius(double radius) { [EOL]     if (radius < 0.0) { [EOL]         throw new IllegalArgumentException("Negative 'radius' argument."); [EOL]     } [EOL]     this.innerRadius = radius; [EOL]     notifyListeners(new DialLayerChangeEvent(this)); [EOL] } <line_num>: 238,244
public double getOuterRadius() { [EOL]     return this.outerRadius; [EOL] } <line_num>: 253,255
public void setOuterRadius(double radius) { [EOL]     if (radius < 0.0) { [EOL]         throw new IllegalArgumentException("Negative 'radius' argument."); [EOL]     } [EOL]     this.outerRadius = radius; [EOL]     notifyListeners(new DialLayerChangeEvent(this)); [EOL] } <line_num>: 265,271
public double getStartAngle() { [EOL]     return this.startAngle; [EOL] } <line_num>: 280,282
public void setStartAngle(double angle) { [EOL]     this.startAngle = angle; [EOL]     notifyListeners(new DialLayerChangeEvent(this)); [EOL] } <line_num>: 292,295
public double getExtent() { [EOL]     return this.extent; [EOL] } <line_num>: 304,306
public void setExtent(double extent) { [EOL]     this.extent = extent; [EOL]     notifyListeners(new DialLayerChangeEvent(this)); [EOL] } <line_num>: 316,319
public Shape getWindow(Rectangle2D frame) { [EOL]     Rectangle2D innerFrame = DialPlot.rectangleByRadius(frame, this.innerRadius, this.innerRadius); [EOL]     Rectangle2D outerFrame = DialPlot.rectangleByRadius(frame, this.outerRadius, this.outerRadius); [EOL]     Arc2D inner = new Arc2D.Double(innerFrame, this.startAngle, this.extent, Arc2D.OPEN); [EOL]     Arc2D outer = new Arc2D.Double(outerFrame, this.startAngle + this.extent, -this.extent, Arc2D.OPEN); [EOL]     GeneralPath p = new GeneralPath(); [EOL]     Point2D point1 = inner.getStartPoint(); [EOL]     p.moveTo((float) point1.getX(), (float) point1.getY()); [EOL]     p.append(inner, true); [EOL]     p.append(outer, true); [EOL]     p.closePath(); [EOL]     return p; [EOL] } <line_num>: 329,347
protected Shape getOuterWindow(Rectangle2D frame) { [EOL]     double radiusMargin = 0.02; [EOL]     double angleMargin = 1.5; [EOL]     Rectangle2D innerFrame = DialPlot.rectangleByRadius(frame, this.innerRadius - radiusMargin, this.innerRadius - radiusMargin); [EOL]     Rectangle2D outerFrame = DialPlot.rectangleByRadius(frame, this.outerRadius + radiusMargin, this.outerRadius + radiusMargin); [EOL]     Arc2D inner = new Arc2D.Double(innerFrame, this.startAngle - angleMargin, this.extent + 2 * angleMargin, Arc2D.OPEN); [EOL]     Arc2D outer = new Arc2D.Double(outerFrame, this.startAngle + angleMargin + this.extent, -this.extent - 2 * angleMargin, Arc2D.OPEN); [EOL]     GeneralPath p = new GeneralPath(); [EOL]     Point2D point1 = inner.getStartPoint(); [EOL]     p.moveTo((float) point1.getX(), (float) point1.getY()); [EOL]     p.append(inner, true); [EOL]     p.append(outer, true); [EOL]     p.closePath(); [EOL]     return p; [EOL] } <line_num>: 356,377
public void draw(Graphics2D g2, DialPlot plot, Rectangle2D frame, Rectangle2D view) { [EOL]     Shape window = getWindow(frame); [EOL]     Shape outerWindow = getOuterWindow(frame); [EOL]     Area area1 = new Area(outerWindow); [EOL]     Area area2 = new Area(window); [EOL]     area1.subtract(area2); [EOL]     g2.setPaint(Color.lightGray); [EOL]     g2.fill(area1); [EOL]     g2.setStroke(this.stroke); [EOL]     g2.setPaint(this.foregroundPaint); [EOL]     g2.draw(window); [EOL]     g2.draw(outerWindow); [EOL] } <line_num>: 387,404
public boolean isClippedToWindow() { [EOL]     return false; [EOL] } <line_num>: 412,414
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof ArcDialFrame)) { [EOL]         return false; [EOL]     } [EOL]     ArcDialFrame that = (ArcDialFrame) obj; [EOL]     if (!PaintUtilities.equal(this.backgroundPaint, that.backgroundPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.foregroundPaint, that.foregroundPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (this.startAngle != that.startAngle) { [EOL]         return false; [EOL]     } [EOL]     if (this.extent != that.extent) { [EOL]         return false; [EOL]     } [EOL]     if (this.innerRadius != that.innerRadius) { [EOL]         return false; [EOL]     } [EOL]     if (this.outerRadius != that.outerRadius) { [EOL]         return false; [EOL]     } [EOL]     if (!this.stroke.equals(that.stroke)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 423,453
public int hashCode() { [EOL]     int result = 193; [EOL]     long temp = Double.doubleToLongBits(this.startAngle); [EOL]     result = 37 * result + (int) (temp ^ (temp >>> 32)); [EOL]     temp = Double.doubleToLongBits(this.extent); [EOL]     result = 37 * result + (int) (temp ^ (temp >>> 32)); [EOL]     temp = Double.doubleToLongBits(this.innerRadius); [EOL]     result = 37 * result + (int) (temp ^ (temp >>> 32)); [EOL]     temp = Double.doubleToLongBits(this.outerRadius); [EOL]     result = 37 * result + (int) (temp ^ (temp >>> 32)); [EOL]     result = 37 * result + HashUtilities.hashCodeForPaint(this.backgroundPaint); [EOL]     result = 37 * result + HashUtilities.hashCodeForPaint(this.foregroundPaint); [EOL]     result = 37 * result + this.stroke.hashCode(); [EOL]     return result; [EOL] } <line_num>: 460,476
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 486,488
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writePaint(this.backgroundPaint, stream); [EOL]     SerialUtilities.writePaint(this.foregroundPaint, stream); [EOL]     SerialUtilities.writeStroke(this.stroke, stream); [EOL] } <line_num>: 497,502
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.backgroundPaint = SerialUtilities.readPaint(stream); [EOL]     this.foregroundPaint = SerialUtilities.readPaint(stream); [EOL]     this.stroke = SerialUtilities.readStroke(stream); [EOL] } <line_num>: 512,518