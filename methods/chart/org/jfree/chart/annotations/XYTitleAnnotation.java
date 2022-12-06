public XYTitleAnnotation(double x, double y, Title title) { [EOL]     this(x, y, title, RectangleAnchor.CENTER); [EOL] } <line_num>: 115,117
public XYTitleAnnotation(double x, double y, Title title, RectangleAnchor anchor) { [EOL]     super(); [EOL]     if (title == null) { [EOL]         throw new IllegalArgumentException("Null 'title' argument."); [EOL]     } [EOL]     if (anchor == null) { [EOL]         throw new IllegalArgumentException("Null 'anchor' argument."); [EOL]     } [EOL]     this.coordinateType = XYCoordinateType.RELATIVE; [EOL]     this.x = x; [EOL]     this.y = y; [EOL]     this.maxWidth = 0.0; [EOL]     this.maxHeight = 0.0; [EOL]     this.title = title; [EOL]     this.anchor = anchor; [EOL] } <line_num>: 128,144
public XYCoordinateType getCoordinateType() { [EOL]     return this.coordinateType; [EOL] } <line_num>: 151,153
public double getX() { [EOL]     return this.x; [EOL] } <line_num>: 160,162
public double getY() { [EOL]     return this.y; [EOL] } <line_num>: 169,171
public Title getTitle() { [EOL]     return this.title; [EOL] } <line_num>: 178,180
public RectangleAnchor getTitleAnchor() { [EOL]     return this.anchor; [EOL] } <line_num>: 187,189
public double getMaxWidth() { [EOL]     return this.maxWidth; [EOL] } <line_num>: 196,198
public void setMaxWidth(double max) { [EOL]     this.maxWidth = max; [EOL]     fireAnnotationChanged(); [EOL] } <line_num>: 206,209
public double getMaxHeight() { [EOL]     return this.maxHeight; [EOL] } <line_num>: 216,218
public void setMaxHeight(double max) { [EOL]     this.maxHeight = max; [EOL]     fireAnnotationChanged(); [EOL] } <line_num>: 226,229
public void draw(Graphics2D g2, XYPlot plot, Rectangle2D dataArea, ValueAxis domainAxis, ValueAxis rangeAxis, int rendererIndex, PlotRenderingInfo info) { [EOL]     PlotOrientation orientation = plot.getOrientation(); [EOL]     AxisLocation domainAxisLocation = plot.getDomainAxisLocation(); [EOL]     AxisLocation rangeAxisLocation = plot.getRangeAxisLocation(); [EOL]     RectangleEdge domainEdge = Plot.resolveDomainAxisLocation(domainAxisLocation, orientation); [EOL]     RectangleEdge rangeEdge = Plot.resolveRangeAxisLocation(rangeAxisLocation, orientation); [EOL]     Range xRange = domainAxis.getRange(); [EOL]     Range yRange = rangeAxis.getRange(); [EOL]     double anchorX = 0.0; [EOL]     double anchorY = 0.0; [EOL]     if (this.coordinateType == XYCoordinateType.RELATIVE) { [EOL]         anchorX = xRange.getLowerBound() + (this.x * xRange.getLength()); [EOL]         anchorY = yRange.getLowerBound() + (this.y * yRange.getLength()); [EOL]     } else { [EOL]         anchorX = domainAxis.valueToJava2D(this.x, dataArea, domainEdge); [EOL]         anchorY = rangeAxis.valueToJava2D(this.y, dataArea, rangeEdge); [EOL]     } [EOL]     float j2DX = (float) domainAxis.valueToJava2D(anchorX, dataArea, domainEdge); [EOL]     float j2DY = (float) rangeAxis.valueToJava2D(anchorY, dataArea, rangeEdge); [EOL]     float xx = 0.0f; [EOL]     float yy = 0.0f; [EOL]     if (orientation == PlotOrientation.HORIZONTAL) { [EOL]         xx = j2DY; [EOL]         yy = j2DX; [EOL]     } else if (orientation == PlotOrientation.VERTICAL) { [EOL]         xx = j2DX; [EOL]         yy = j2DY; [EOL]     } [EOL]     double maxW = dataArea.getWidth(); [EOL]     double maxH = dataArea.getHeight(); [EOL]     if (this.coordinateType == XYCoordinateType.RELATIVE) { [EOL]         if (this.maxWidth > 0.0) { [EOL]             maxW = maxW * this.maxWidth; [EOL]         } [EOL]         if (this.maxHeight > 0.0) { [EOL]             maxH = maxH * this.maxHeight; [EOL]         } [EOL]     } [EOL]     if (this.coordinateType == XYCoordinateType.DATA) { [EOL]         maxW = this.maxWidth; [EOL]         maxH = this.maxHeight; [EOL]     } [EOL]     RectangleConstraint rc = new RectangleConstraint(new Range(0, maxW), new Range(0, maxH)); [EOL]     Size2D size = this.title.arrange(g2, rc); [EOL]     Rectangle2D titleRect = new Rectangle2D.Double(0, 0, size.width, size.height); [EOL]     Point2D anchorPoint = RectangleAnchor.coordinates(titleRect, this.anchor); [EOL]     xx = xx - (float) anchorPoint.getX(); [EOL]     yy = yy - (float) anchorPoint.getY(); [EOL]     titleRect.setRect(xx, yy, titleRect.getWidth(), titleRect.getHeight()); [EOL]     BlockParams p = new BlockParams(); [EOL]     if (info != null) { [EOL]         if (info.getOwner().getEntityCollection() != null) { [EOL]             p.setGenerateEntities(true); [EOL]         } [EOL]     } [EOL]     Object result = this.title.draw(g2, titleRect, p); [EOL]     if (info != null) { [EOL]         if (result instanceof EntityBlockResult) { [EOL]             EntityBlockResult ebr = (EntityBlockResult) result; [EOL]             info.getOwner().getEntityCollection().addAll(ebr.getEntityCollection()); [EOL]         } [EOL]         String toolTip = getToolTipText(); [EOL]         String url = getURL(); [EOL]         if (toolTip != null || url != null) { [EOL]             addEntity(info, new Rectangle2D.Float(xx, yy, (float) size.width, (float) size.height), rendererIndex, toolTip, url); [EOL]         } [EOL]     } [EOL] } <line_num>: 245,331
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof XYTitleAnnotation)) { [EOL]         return false; [EOL]     } [EOL]     XYTitleAnnotation that = (XYTitleAnnotation) obj; [EOL]     if (this.coordinateType != that.coordinateType) { [EOL]         return false; [EOL]     } [EOL]     if (this.x != that.x) { [EOL]         return false; [EOL]     } [EOL]     if (this.y != that.y) { [EOL]         return false; [EOL]     } [EOL]     if (this.maxWidth != that.maxWidth) { [EOL]         return false; [EOL]     } [EOL]     if (this.maxHeight != that.maxHeight) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.title, that.title)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.anchor.equals(that.anchor)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 340,370
public int hashCode() { [EOL]     int result = 193; [EOL]     result = HashUtilities.hashCode(result, this.anchor); [EOL]     result = HashUtilities.hashCode(result, this.coordinateType); [EOL]     result = HashUtilities.hashCode(result, this.x); [EOL]     result = HashUtilities.hashCode(result, this.y); [EOL]     result = HashUtilities.hashCode(result, this.maxWidth); [EOL]     result = HashUtilities.hashCode(result, this.maxHeight); [EOL]     result = HashUtilities.hashCode(result, this.title); [EOL]     return result; [EOL] } <line_num>: 377,387
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 396,398