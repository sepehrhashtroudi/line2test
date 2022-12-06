public StandardXYItemRenderer() { [EOL]     this(LINES, null); [EOL] } <line_num>: 221,223
public StandardXYItemRenderer(int type) { [EOL]     this(type, null); [EOL] } <line_num>: 232,234
public StandardXYItemRenderer(int type, XYToolTipGenerator toolTipGenerator) { [EOL]     this(type, toolTipGenerator, null); [EOL] } <line_num>: 245,248
public StandardXYItemRenderer(int type, XYToolTipGenerator toolTipGenerator, XYURLGenerator urlGenerator) { [EOL]     super(); [EOL]     setBaseToolTipGenerator(toolTipGenerator); [EOL]     setBaseURLGenerator(urlGenerator); [EOL]     if ((type & SHAPES) != 0) { [EOL]         this.baseShapesVisible = true; [EOL]     } [EOL]     if ((type & LINES) != 0) { [EOL]         this.plotLines = true; [EOL]     } [EOL]     if ((type & IMAGES) != 0) { [EOL]         this.plotImages = true; [EOL]     } [EOL]     if ((type & DISCONTINUOUS) != 0) { [EOL]         this.plotDiscontinuous = true; [EOL]     } [EOL]     this.seriesShapesFilled = new BooleanList(); [EOL]     this.baseShapesFilled = true; [EOL]     this.legendLine = new Line2D.Double(-7.0, 0.0, 7.0, 0.0); [EOL]     this.drawSeriesLineAsPath = false; [EOL] } <line_num>: 260,284
public State(PlotRenderingInfo info) { [EOL]     super(info); [EOL] } <line_num>: 648,650
public boolean getBaseShapesVisible() { [EOL]     return this.baseShapesVisible; [EOL] } <line_num>: 293,295
public void setBaseShapesVisible(boolean flag) { [EOL]     if (this.baseShapesVisible != flag) { [EOL]         this.baseShapesVisible = flag; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 305,310
public boolean getItemShapeFilled(int series, int item) { [EOL]     Boolean flag = this.seriesShapesFilled.getBoolean(series); [EOL]     if (flag != null) { [EOL]         return flag.booleanValue(); [EOL]     } else { [EOL]         return this.baseShapesFilled; [EOL]     } [EOL] } <line_num>: 329,337
public Boolean getSeriesShapesFilled(int series) { [EOL]     return this.seriesShapesFilled.getBoolean(series); [EOL] } <line_num>: 347,349
public void setSeriesShapesFilled(int series, Boolean flag) { [EOL]     this.seriesShapesFilled.setBoolean(series, flag); [EOL]     fireChangeEvent(); [EOL] } <line_num>: 360,363
public boolean getBaseShapesFilled() { [EOL]     return this.baseShapesFilled; [EOL] } <line_num>: 372,374
public void setBaseShapesFilled(boolean flag) { [EOL]     this.baseShapesFilled = flag; [EOL] } <line_num>: 384,386
public boolean getPlotLines() { [EOL]     return this.plotLines; [EOL] } <line_num>: 395,397
public void setPlotLines(boolean flag) { [EOL]     if (this.plotLines != flag) { [EOL]         this.plotLines = flag; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 408,413
public UnitType getGapThresholdType() { [EOL]     return this.gapThresholdType; [EOL] } <line_num>: 422,424
public void setGapThresholdType(UnitType thresholdType) { [EOL]     if (thresholdType == null) { [EOL]         throw new IllegalArgumentException("Null 'thresholdType' argument."); [EOL]     } [EOL]     this.gapThresholdType = thresholdType; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 434,441
public double getGapThreshold() { [EOL]     return this.gapThreshold; [EOL] } <line_num>: 450,452
public void setGapThreshold(double t) { [EOL]     this.gapThreshold = t; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 462,465
public boolean getPlotImages() { [EOL]     return this.plotImages; [EOL] } <line_num>: 474,476
public void setPlotImages(boolean flag) { [EOL]     if (this.plotImages != flag) { [EOL]         this.plotImages = flag; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 487,492
public boolean getPlotDiscontinuous() { [EOL]     return this.plotDiscontinuous; [EOL] } <line_num>: 500,502
public void setPlotDiscontinuous(boolean flag) { [EOL]     if (this.plotDiscontinuous != flag) { [EOL]         this.plotDiscontinuous = flag; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 513,518
public boolean getDrawSeriesLineAsPath() { [EOL]     return this.drawSeriesLineAsPath; [EOL] } <line_num>: 528,530
public void setDrawSeriesLineAsPath(boolean flag) { [EOL]     this.drawSeriesLineAsPath = flag; [EOL] } <line_num>: 540,542
public Shape getLegendLine() { [EOL]     return this.legendLine; [EOL] } <line_num>: 551,553
public void setLegendLine(Shape line) { [EOL]     if (line == null) { [EOL]         throw new IllegalArgumentException("Null 'line' argument."); [EOL]     } [EOL]     this.legendLine = line; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 563,569
public LegendItem getLegendItem(int datasetIndex, int series) { [EOL]     XYPlot plot = getPlot(); [EOL]     if (plot == null) { [EOL]         return null; [EOL]     } [EOL]     LegendItem result = null; [EOL]     XYDataset dataset = plot.getDataset(datasetIndex); [EOL]     if (dataset != null) { [EOL]         if (getItemVisible(series, 0)) { [EOL]             String label = getLegendItemLabelGenerator().generateLabel(dataset, series); [EOL]             String description = label; [EOL]             String toolTipText = null; [EOL]             if (getLegendItemToolTipGenerator() != null) { [EOL]                 toolTipText = getLegendItemToolTipGenerator().generateLabel(dataset, series); [EOL]             } [EOL]             String urlText = null; [EOL]             if (getLegendItemURLGenerator() != null) { [EOL]                 urlText = getLegendItemURLGenerator().generateLabel(dataset, series); [EOL]             } [EOL]             Shape shape = lookupLegendShape(series); [EOL]             boolean shapeFilled = getItemShapeFilled(series, 0); [EOL]             Paint paint = lookupSeriesPaint(series); [EOL]             Paint linePaint = paint; [EOL]             Stroke lineStroke = lookupSeriesStroke(series); [EOL]             result = new LegendItem(label, description, toolTipText, urlText, this.baseShapesVisible, shape, shapeFilled, paint, !shapeFilled, paint, lineStroke, this.plotLines, this.legendLine, lineStroke, linePaint); [EOL]             result.setLabelFont(lookupLegendTextFont(series)); [EOL]             Paint labelPaint = lookupLegendTextPaint(series); [EOL]             if (labelPaint != null) { [EOL]                 result.setLabelPaint(labelPaint); [EOL]             } [EOL]             result.setDataset(dataset); [EOL]             result.setDatasetIndex(datasetIndex); [EOL]             result.setSeriesKey(dataset.getSeriesKey(series)); [EOL]             result.setSeriesIndex(series); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 579,622
public boolean isLastPointGood() { [EOL]     return this.lastPointGood; [EOL] } <line_num>: 658,660
public void setLastPointGood(boolean good) { [EOL]     this.lastPointGood = good; [EOL] } <line_num>: 668,670
public int getSeriesIndex() { [EOL]     return this.seriesIndex; [EOL] } <line_num>: 677,679
public void setSeriesIndex(int index) { [EOL]     this.seriesIndex = index; [EOL] } <line_num>: 686,688
public XYItemRendererState initialise(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, XYDataset data, PlotRenderingInfo info) { [EOL]     State state = new State(info); [EOL]     state.seriesPath = new GeneralPath(); [EOL]     state.seriesIndex = -1; [EOL]     return state; [EOL] } <line_num>: 707,718
public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, int pass) { [EOL]     boolean itemVisible = getItemVisible(series, item); [EOL]     Shape entityArea = null; [EOL]     EntityCollection entities = null; [EOL]     if (state.getInfo() != null) { [EOL]         entities = state.getInfo().getOwner().getEntityCollection(); [EOL]     } [EOL]     PlotOrientation orientation = plot.getOrientation(); [EOL]     Paint paint = getItemPaint(series, item, selected); [EOL]     Stroke seriesStroke = getItemStroke(series, item, selected); [EOL]     g2.setPaint(paint); [EOL]     g2.setStroke(seriesStroke); [EOL]     double x1 = dataset.getXValue(series, item); [EOL]     double y1 = dataset.getYValue(series, item); [EOL]     if (Double.isNaN(x1) || Double.isNaN(y1)) { [EOL]         itemVisible = false; [EOL]     } [EOL]     RectangleEdge xAxisLocation = plot.getDomainAxisEdge(); [EOL]     RectangleEdge yAxisLocation = plot.getRangeAxisEdge(); [EOL]     double transX1 = domainAxis.valueToJava2D(x1, dataArea, xAxisLocation); [EOL]     double transY1 = rangeAxis.valueToJava2D(y1, dataArea, yAxisLocation); [EOL]     if (getPlotLines()) { [EOL]         if (this.drawSeriesLineAsPath) { [EOL]             State s = (State) state; [EOL]             if (s.getSeriesIndex() != series) { [EOL]                 s.seriesPath.reset(); [EOL]                 s.lastPointGood = false; [EOL]                 s.setSeriesIndex(series); [EOL]             } [EOL]             if (itemVisible && !Double.isNaN(transX1) && !Double.isNaN(transY1)) { [EOL]                 float x = (float) transX1; [EOL]                 float y = (float) transY1; [EOL]                 if (orientation == PlotOrientation.HORIZONTAL) { [EOL]                     x = (float) transY1; [EOL]                     y = (float) transX1; [EOL]                 } [EOL]                 if (s.isLastPointGood()) { [EOL]                     s.seriesPath.lineTo(x, y); [EOL]                 } else { [EOL]                     s.seriesPath.moveTo(x, y); [EOL]                 } [EOL]                 s.setLastPointGood(true); [EOL]             } else { [EOL]                 s.setLastPointGood(false); [EOL]             } [EOL]             if (item == dataset.getItemCount(series) - 1) { [EOL]                 if (s.seriesIndex == series) { [EOL]                     g2.setStroke(lookupSeriesStroke(series)); [EOL]                     g2.setPaint(lookupSeriesPaint(series)); [EOL]                     g2.draw(s.seriesPath); [EOL]                 } [EOL]             } [EOL]         } else if (item != 0 && itemVisible) { [EOL]             double x0 = dataset.getXValue(series, item - 1); [EOL]             double y0 = dataset.getYValue(series, item - 1); [EOL]             if (!Double.isNaN(x0) && !Double.isNaN(y0)) { [EOL]                 boolean drawLine = true; [EOL]                 if (getPlotDiscontinuous()) { [EOL]                     int numX = dataset.getItemCount(series); [EOL]                     double minX = dataset.getXValue(series, 0); [EOL]                     double maxX = dataset.getXValue(series, numX - 1); [EOL]                     if (this.gapThresholdType == UnitType.ABSOLUTE) { [EOL]                         drawLine = Math.abs(x1 - x0) <= this.gapThreshold; [EOL]                     } else { [EOL]                         drawLine = Math.abs(x1 - x0) <= ((maxX - minX) / numX * getGapThreshold()); [EOL]                     } [EOL]                 } [EOL]                 if (drawLine) { [EOL]                     double transX0 = domainAxis.valueToJava2D(x0, dataArea, xAxisLocation); [EOL]                     double transY0 = rangeAxis.valueToJava2D(y0, dataArea, yAxisLocation); [EOL]                     if (Double.isNaN(transX0) || Double.isNaN(transY0) || Double.isNaN(transX1) || Double.isNaN(transY1)) { [EOL]                         return; [EOL]                     } [EOL]                     if (orientation == PlotOrientation.HORIZONTAL) { [EOL]                         state.workingLine.setLine(transY0, transX0, transY1, transX1); [EOL]                     } else if (orientation == PlotOrientation.VERTICAL) { [EOL]                         state.workingLine.setLine(transX0, transY0, transX1, transY1); [EOL]                     } [EOL]                     if (state.workingLine.intersects(dataArea)) { [EOL]                         g2.draw(state.workingLine); [EOL]                     } [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     if (!itemVisible) { [EOL]         return; [EOL]     } [EOL]     if (getBaseShapesVisible()) { [EOL]         Shape shape = getItemShape(series, item, selected); [EOL]         if (orientation == PlotOrientation.HORIZONTAL) { [EOL]             shape = ShapeUtilities.createTranslatedShape(shape, transY1, transX1); [EOL]         } else if (orientation == PlotOrientation.VERTICAL) { [EOL]             shape = ShapeUtilities.createTranslatedShape(shape, transX1, transY1); [EOL]         } [EOL]         if (shape.intersects(dataArea)) { [EOL]             if (getItemShapeFilled(series, item)) { [EOL]                 g2.fill(shape); [EOL]             } else { [EOL]                 g2.draw(shape); [EOL]             } [EOL]         } [EOL]         entityArea = shape; [EOL]     } [EOL]     if (getPlotImages()) { [EOL]         Image image = getImage(plot, series, item, transX1, transY1); [EOL]         if (image != null) { [EOL]             Point hotspot = getImageHotspot(plot, series, item, transX1, transY1, image); [EOL]             g2.drawImage(image, (int) (transX1 - hotspot.getX()), (int) (transY1 - hotspot.getY()), null); [EOL]             entityArea = new Rectangle2D.Double(transX1 - hotspot.getX(), transY1 - hotspot.getY(), image.getWidth(null), image.getHeight(null)); [EOL]         } [EOL]     } [EOL]     double xx = transX1; [EOL]     double yy = transY1; [EOL]     if (orientation == PlotOrientation.HORIZONTAL) { [EOL]         xx = transY1; [EOL]         yy = transX1; [EOL]     } [EOL]     if (isItemLabelVisible(series, item, selected)) { [EOL]         drawItemLabel(g2, orientation, dataset, series, item, selected, xx, yy, (y1 < 0.0)); [EOL]     } [EOL]     int domainAxisIndex = plot.getDomainAxisIndex(domainAxis); [EOL]     int rangeAxisIndex = plot.getRangeAxisIndex(rangeAxis); [EOL]     XYCrosshairState crosshairState = state.getCrosshairState(); [EOL]     updateCrosshairValues(crosshairState, x1, y1, domainAxisIndex, rangeAxisIndex, transX1, transY1, orientation); [EOL]     if (entities != null && ShapeUtilities.isPointInRect(xx, yy, dataArea)) { [EOL]         addEntity(entities, entityArea, dataset, series, item, selected, xx, yy); [EOL]     } [EOL] } <line_num>: 735,927
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof StandardXYItemRenderer)) { [EOL]         return false; [EOL]     } [EOL]     StandardXYItemRenderer that = (StandardXYItemRenderer) obj; [EOL]     if (this.baseShapesVisible != that.baseShapesVisible) { [EOL]         return false; [EOL]     } [EOL]     if (this.plotLines != that.plotLines) { [EOL]         return false; [EOL]     } [EOL]     if (this.plotImages != that.plotImages) { [EOL]         return false; [EOL]     } [EOL]     if (this.plotDiscontinuous != that.plotDiscontinuous) { [EOL]         return false; [EOL]     } [EOL]     if (this.gapThresholdType != that.gapThresholdType) { [EOL]         return false; [EOL]     } [EOL]     if (this.gapThreshold != that.gapThreshold) { [EOL]         return false; [EOL]     } [EOL]     if (!this.seriesShapesFilled.equals(that.seriesShapesFilled)) { [EOL]         return false; [EOL]     } [EOL]     if (this.baseShapesFilled != that.baseShapesFilled) { [EOL]         return false; [EOL]     } [EOL]     if (this.drawSeriesLineAsPath != that.drawSeriesLineAsPath) { [EOL]         return false; [EOL]     } [EOL]     if (!ShapeUtilities.equal(this.legendLine, that.legendLine)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 936,977
public Object clone() throws CloneNotSupportedException { [EOL]     StandardXYItemRenderer clone = (StandardXYItemRenderer) super.clone(); [EOL]     clone.seriesShapesFilled = (BooleanList) this.seriesShapesFilled.clone(); [EOL]     clone.legendLine = ShapeUtilities.clone(this.legendLine); [EOL]     return clone; [EOL] } <line_num>: 986,992
protected Image getImage(Plot plot, int series, int item, double x, double y) { [EOL]     return null; [EOL] } <line_num>: 1014,1018
protected Point getImageHotspot(Plot plot, int series, int item, double x, double y, Image image) { [EOL]     int height = image.getHeight(null); [EOL]     int width = image.getWidth(null); [EOL]     return new Point(width / 2, height / 2); [EOL] } <line_num>: 1037,1044
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.legendLine = SerialUtilities.readShape(stream); [EOL] } <line_num>: 1054,1058
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writeShape(this.legendLine, stream); [EOL] } <line_num>: 1067,1070