public CandlestickRenderer() { [EOL]     this(-1.0); [EOL] } <line_num>: 212,214
public CandlestickRenderer(double candleWidth) { [EOL]     this(candleWidth, true, new HighLowItemLabelGenerator()); [EOL] } <line_num>: 224,226
public CandlestickRenderer(double candleWidth, boolean drawVolume, XYToolTipGenerator toolTipGenerator) { [EOL]     super(); [EOL]     setBaseToolTipGenerator(toolTipGenerator); [EOL]     this.candleWidth = candleWidth; [EOL]     this.drawVolume = drawVolume; [EOL]     this.volumePaint = Color.gray; [EOL]     this.upPaint = Color.green; [EOL]     this.downPaint = Color.red; [EOL]     this.useOutlinePaint = false; [EOL] } <line_num>: 240,251
public double getCandleWidth() { [EOL]     return this.candleWidth; [EOL] } <line_num>: 260,262
public void setCandleWidth(double width) { [EOL]     if (width != this.candleWidth) { [EOL]         this.candleWidth = width; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 277,282
public double getMaxCandleWidthInMilliseconds() { [EOL]     return this.maxCandleWidthInMilliseconds; [EOL] } <line_num>: 291,293
public void setMaxCandleWidthInMilliseconds(double millis) { [EOL]     this.maxCandleWidthInMilliseconds = millis; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 307,310
public int getAutoWidthMethod() { [EOL]     return this.autoWidthMethod; [EOL] } <line_num>: 319,321
public void setAutoWidthMethod(int autoWidthMethod) { [EOL]     if (this.autoWidthMethod != autoWidthMethod) { [EOL]         this.autoWidthMethod = autoWidthMethod; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 349,354
public double getAutoWidthFactor() { [EOL]     return this.autoWidthFactor; [EOL] } <line_num>: 365,367
public void setAutoWidthFactor(double autoWidthFactor) { [EOL]     if (this.autoWidthFactor != autoWidthFactor) { [EOL]         this.autoWidthFactor = autoWidthFactor; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 381,386
public double getAutoWidthGap() { [EOL]     return this.autoWidthGap; [EOL] } <line_num>: 396,398
public void setAutoWidthGap(double autoWidthGap) { [EOL]     if (this.autoWidthGap != autoWidthGap) { [EOL]         this.autoWidthGap = autoWidthGap; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 413,418
public Paint getUpPaint() { [EOL]     return this.upPaint; [EOL] } <line_num>: 428,430
public void setUpPaint(Paint paint) { [EOL]     this.upPaint = paint; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 441,444
public Paint getDownPaint() { [EOL]     return this.downPaint; [EOL] } <line_num>: 454,456
public void setDownPaint(Paint paint) { [EOL]     this.downPaint = paint; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 465,468
public boolean getDrawVolume() { [EOL]     return this.drawVolume; [EOL] } <line_num>: 480,482
public void setDrawVolume(boolean flag) { [EOL]     if (this.drawVolume != flag) { [EOL]         this.drawVolume = flag; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 493,498
public Paint getVolumePaint() { [EOL]     return this.volumePaint; [EOL] } <line_num>: 510,512
public void setVolumePaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.volumePaint = paint; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 525,531
public boolean getUseOutlinePaint() { [EOL]     return this.useOutlinePaint; [EOL] } <line_num>: 544,546
public void setUseOutlinePaint(boolean use) { [EOL]     if (this.useOutlinePaint != use) { [EOL]         this.useOutlinePaint = use; [EOL]         fireChangeEvent(); [EOL]     } [EOL] } <line_num>: 559,564
public Range findRangeBounds(XYDataset dataset) { [EOL]     return findRangeBounds(dataset, true); [EOL] } <line_num>: 575,577
public XYItemRendererState initialise(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, XYDataset dataset, PlotRenderingInfo info) { [EOL]     ValueAxis axis = plot.getDomainAxis(); [EOL]     double x1 = axis.getLowerBound(); [EOL]     double x2 = x1 + this.maxCandleWidthInMilliseconds; [EOL]     RectangleEdge edge = plot.getDomainAxisEdge(); [EOL]     double xx1 = axis.valueToJava2D(x1, dataArea, edge); [EOL]     double xx2 = axis.valueToJava2D(x2, dataArea, edge); [EOL]     this.maxCandleWidth = Math.abs(xx2 - xx1); [EOL]     if (this.drawVolume) { [EOL]         OHLCDataset highLowDataset = (OHLCDataset) dataset; [EOL]         this.maxVolume = 0.0; [EOL]         for (int series = 0; series < highLowDataset.getSeriesCount(); series++) { [EOL]             for (int item = 0; item < highLowDataset.getItemCount(series); item++) { [EOL]                 double volume = highLowDataset.getVolumeValue(series, item); [EOL]                 if (volume > this.maxVolume) { [EOL]                     this.maxVolume = volume; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     return new XYItemRendererState(info); [EOL] } <line_num>: 595,630
public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, int pass) { [EOL]     boolean horiz; [EOL]     PlotOrientation orientation = plot.getOrientation(); [EOL]     if (orientation == PlotOrientation.HORIZONTAL) { [EOL]         horiz = true; [EOL]     } else if (orientation == PlotOrientation.VERTICAL) { [EOL]         horiz = false; [EOL]     } else { [EOL]         return; [EOL]     } [EOL]     EntityCollection entities = null; [EOL]     if (state.getInfo() != null) { [EOL]         entities = state.getInfo().getOwner().getEntityCollection(); [EOL]     } [EOL]     OHLCDataset highLowData = (OHLCDataset) dataset; [EOL]     double x = highLowData.getXValue(series, item); [EOL]     double yHigh = highLowData.getHighValue(series, item); [EOL]     double yLow = highLowData.getLowValue(series, item); [EOL]     double yOpen = highLowData.getOpenValue(series, item); [EOL]     double yClose = highLowData.getCloseValue(series, item); [EOL]     RectangleEdge domainEdge = plot.getDomainAxisEdge(); [EOL]     double xx = domainAxis.valueToJava2D(x, dataArea, domainEdge); [EOL]     RectangleEdge edge = plot.getRangeAxisEdge(); [EOL]     double yyHigh = rangeAxis.valueToJava2D(yHigh, dataArea, edge); [EOL]     double yyLow = rangeAxis.valueToJava2D(yLow, dataArea, edge); [EOL]     double yyOpen = rangeAxis.valueToJava2D(yOpen, dataArea, edge); [EOL]     double yyClose = rangeAxis.valueToJava2D(yClose, dataArea, edge); [EOL]     double volumeWidth; [EOL]     double stickWidth; [EOL]     if (this.candleWidth > 0) { [EOL]         volumeWidth = this.candleWidth; [EOL]         stickWidth = this.candleWidth; [EOL]     } else { [EOL]         double xxWidth = 0; [EOL]         int itemCount; [EOL]         switch(this.autoWidthMethod) { [EOL]             case WIDTHMETHOD_AVERAGE: [EOL]                 itemCount = highLowData.getItemCount(series); [EOL]                 if (horiz) { [EOL]                     xxWidth = dataArea.getHeight() / itemCount; [EOL]                 } else { [EOL]                     xxWidth = dataArea.getWidth() / itemCount; [EOL]                 } [EOL]                 break; [EOL]             case WIDTHMETHOD_SMALLEST: [EOL]                 itemCount = highLowData.getItemCount(series); [EOL]                 double lastPos = -1; [EOL]                 xxWidth = dataArea.getWidth(); [EOL]                 for (int i = 0; i < itemCount; i++) { [EOL]                     double pos = domainAxis.valueToJava2D(highLowData.getXValue(series, i), dataArea, domainEdge); [EOL]                     if (lastPos != -1) { [EOL]                         xxWidth = Math.min(xxWidth, Math.abs(pos - lastPos)); [EOL]                     } [EOL]                     lastPos = pos; [EOL]                 } [EOL]                 break; [EOL]             case WIDTHMETHOD_INTERVALDATA: [EOL]                 IntervalXYDataset intervalXYData = (IntervalXYDataset) dataset; [EOL]                 double startPos = domainAxis.valueToJava2D(intervalXYData.getStartXValue(series, item), dataArea, plot.getDomainAxisEdge()); [EOL]                 double endPos = domainAxis.valueToJava2D(intervalXYData.getEndXValue(series, item), dataArea, plot.getDomainAxisEdge()); [EOL]                 xxWidth = Math.abs(endPos - startPos); [EOL]                 break; [EOL]         } [EOL]         xxWidth -= 2 * this.autoWidthGap; [EOL]         xxWidth *= this.autoWidthFactor; [EOL]         xxWidth = Math.min(xxWidth, this.maxCandleWidth); [EOL]         volumeWidth = Math.max(Math.min(1, this.maxCandleWidth), xxWidth); [EOL]         stickWidth = Math.max(Math.min(3, this.maxCandleWidth), xxWidth); [EOL]     } [EOL]     Paint p = getItemPaint(series, item, selected); [EOL]     Paint outlinePaint = null; [EOL]     if (this.useOutlinePaint) { [EOL]         outlinePaint = getItemOutlinePaint(series, item, selected); [EOL]     } [EOL]     Stroke s = getItemStroke(series, item, selected); [EOL]     g2.setStroke(s); [EOL]     if (this.drawVolume) { [EOL]         int volume = (int) highLowData.getVolumeValue(series, item); [EOL]         double volumeHeight = volume / this.maxVolume; [EOL]         double min, max; [EOL]         if (horiz) { [EOL]             min = dataArea.getMinX(); [EOL]             max = dataArea.getMaxX(); [EOL]         } else { [EOL]             min = dataArea.getMinY(); [EOL]             max = dataArea.getMaxY(); [EOL]         } [EOL]         double zzVolume = volumeHeight * (max - min); [EOL]         g2.setPaint(getVolumePaint()); [EOL]         Composite originalComposite = g2.getComposite(); [EOL]         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f)); [EOL]         if (horiz) { [EOL]             g2.fill(new Rectangle2D.Double(min, xx - volumeWidth / 2, zzVolume, volumeWidth)); [EOL]         } else { [EOL]             g2.fill(new Rectangle2D.Double(xx - volumeWidth / 2, max - zzVolume, volumeWidth, zzVolume)); [EOL]         } [EOL]         g2.setComposite(originalComposite); [EOL]     } [EOL]     if (this.useOutlinePaint) { [EOL]         g2.setPaint(outlinePaint); [EOL]     } else { [EOL]         g2.setPaint(p); [EOL]     } [EOL]     double yyMaxOpenClose = Math.max(yyOpen, yyClose); [EOL]     double yyMinOpenClose = Math.min(yyOpen, yyClose); [EOL]     double maxOpenClose = Math.max(yOpen, yClose); [EOL]     double minOpenClose = Math.min(yOpen, yClose); [EOL]     if (yHigh > maxOpenClose) { [EOL]         if (horiz) { [EOL]             g2.draw(new Line2D.Double(yyHigh, xx, yyMaxOpenClose, xx)); [EOL]         } else { [EOL]             g2.draw(new Line2D.Double(xx, yyHigh, xx, yyMaxOpenClose)); [EOL]         } [EOL]     } [EOL]     if (yLow < minOpenClose) { [EOL]         if (horiz) { [EOL]             g2.draw(new Line2D.Double(yyLow, xx, yyMinOpenClose, xx)); [EOL]         } else { [EOL]             g2.draw(new Line2D.Double(xx, yyLow, xx, yyMinOpenClose)); [EOL]         } [EOL]     } [EOL]     Rectangle2D body = null; [EOL]     Rectangle2D hotspot = null; [EOL]     double length = Math.abs(yyHigh - yyLow); [EOL]     double base = Math.min(yyHigh, yyLow); [EOL]     if (horiz) { [EOL]         body = new Rectangle2D.Double(yyMinOpenClose, xx - stickWidth / 2, yyMaxOpenClose - yyMinOpenClose, stickWidth); [EOL]         hotspot = new Rectangle2D.Double(base, xx - stickWidth / 2, length, stickWidth); [EOL]     } else { [EOL]         body = new Rectangle2D.Double(xx - stickWidth / 2, yyMinOpenClose, stickWidth, yyMaxOpenClose - yyMinOpenClose); [EOL]         hotspot = new Rectangle2D.Double(xx - stickWidth / 2, base, stickWidth, length); [EOL]     } [EOL]     if (yClose > yOpen) { [EOL]         if (this.upPaint != null) { [EOL]             g2.setPaint(this.upPaint); [EOL]         } else { [EOL]             g2.setPaint(p); [EOL]         } [EOL]         g2.fill(body); [EOL]     } else { [EOL]         if (this.downPaint != null) { [EOL]             g2.setPaint(this.downPaint); [EOL]         } else { [EOL]             g2.setPaint(p); [EOL]         } [EOL]         g2.fill(body); [EOL]     } [EOL]     if (this.useOutlinePaint) { [EOL]         g2.setPaint(outlinePaint); [EOL]     } else { [EOL]         g2.setPaint(p); [EOL]     } [EOL]     g2.draw(body); [EOL]     if (entities != null) { [EOL]         addEntity(entities, hotspot, dataset, series, item, selected, 0.0, 0.0); [EOL]     } [EOL] } <line_num>: 650,873
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof CandlestickRenderer)) { [EOL]         return false; [EOL]     } [EOL]     CandlestickRenderer that = (CandlestickRenderer) obj; [EOL]     if (this.candleWidth != that.candleWidth) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.upPaint, that.upPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.downPaint, that.downPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (this.drawVolume != that.drawVolume) { [EOL]         return false; [EOL]     } [EOL]     if (this.maxCandleWidthInMilliseconds != that.maxCandleWidthInMilliseconds) { [EOL]         return false; [EOL]     } [EOL]     if (this.autoWidthMethod != that.autoWidthMethod) { [EOL]         return false; [EOL]     } [EOL]     if (this.autoWidthFactor != that.autoWidthFactor) { [EOL]         return false; [EOL]     } [EOL]     if (this.autoWidthGap != that.autoWidthGap) { [EOL]         return false; [EOL]     } [EOL]     if (this.useOutlinePaint != that.useOutlinePaint) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.volumePaint, that.volumePaint)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 882,922
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 931,933
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writePaint(this.upPaint, stream); [EOL]     SerialUtilities.writePaint(this.downPaint, stream); [EOL]     SerialUtilities.writePaint(this.volumePaint, stream); [EOL] } <line_num>: 942,947
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.upPaint = SerialUtilities.readPaint(stream); [EOL]     this.downPaint = SerialUtilities.readPaint(stream); [EOL]     this.volumePaint = SerialUtilities.readPaint(stream); [EOL] } <line_num>: 957,963
public Rectangle2D createHotSpotBounds(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, XYItemRendererState state, Rectangle2D result) { [EOL]     return super.createHotSpotBounds(g2, dataArea, plot, domainAxis, rangeAxis, dataset, series, item, selected, state, result); [EOL] } <line_num>: 965,971
