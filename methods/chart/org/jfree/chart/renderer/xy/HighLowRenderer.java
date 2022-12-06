public HighLowRenderer() { [EOL]     super(); [EOL]     this.drawOpenTicks = true; [EOL]     this.drawCloseTicks = true; [EOL]     this.tickLength = 2.0; [EOL] } <line_num>: 144,149
public boolean getDrawOpenTicks() { [EOL]     return this.drawOpenTicks; [EOL] } <line_num>: 159,161
public void setDrawOpenTicks(boolean draw) { [EOL]     this.drawOpenTicks = draw; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 171,174
public boolean getDrawCloseTicks() { [EOL]     return this.drawCloseTicks; [EOL] } <line_num>: 184,186
public void setDrawCloseTicks(boolean draw) { [EOL]     this.drawCloseTicks = draw; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 196,199
public Paint getOpenTickPaint() { [EOL]     return this.openTickPaint; [EOL] } <line_num>: 209,211
public void setOpenTickPaint(Paint paint) { [EOL]     this.openTickPaint = paint; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 223,226
public Paint getCloseTickPaint() { [EOL]     return this.closeTickPaint; [EOL] } <line_num>: 236,238
public void setCloseTickPaint(Paint paint) { [EOL]     this.closeTickPaint = paint; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 250,253
public double getTickLength() { [EOL]     return this.tickLength; [EOL] } <line_num>: 264,266
public void setTickLength(double length) { [EOL]     this.tickLength = length; [EOL]     fireChangeEvent(); [EOL] } <line_num>: 278,281
public Range findRangeBounds(XYDataset dataset) { [EOL]     if (dataset != null) { [EOL]         return DatasetUtilities.findRangeBounds(dataset, true); [EOL]     } else { [EOL]         return null; [EOL]     } [EOL] } <line_num>: 292,299
public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, int pass) { [EOL]     double x = dataset.getXValue(series, item); [EOL]     if (!domainAxis.getRange().contains(x)) { [EOL]         return; [EOL]     } [EOL]     double xx = domainAxis.valueToJava2D(x, dataArea, plot.getDomainAxisEdge()); [EOL]     Shape entityArea = null; [EOL]     EntityCollection entities = null; [EOL]     if (state.getInfo() != null) { [EOL]         entities = state.getInfo().getOwner().getEntityCollection(); [EOL]     } [EOL]     PlotOrientation orientation = plot.getOrientation(); [EOL]     RectangleEdge location = plot.getRangeAxisEdge(); [EOL]     Paint itemPaint = getItemPaint(series, item, selected); [EOL]     Stroke itemStroke = getItemStroke(series, item, selected); [EOL]     g2.setPaint(itemPaint); [EOL]     g2.setStroke(itemStroke); [EOL]     if (dataset instanceof OHLCDataset) { [EOL]         OHLCDataset hld = (OHLCDataset) dataset; [EOL]         double yHigh = hld.getHighValue(series, item); [EOL]         double yLow = hld.getLowValue(series, item); [EOL]         if (!Double.isNaN(yHigh) && !Double.isNaN(yLow)) { [EOL]             double yyHigh = rangeAxis.valueToJava2D(yHigh, dataArea, location); [EOL]             double yyLow = rangeAxis.valueToJava2D(yLow, dataArea, location); [EOL]             if (orientation == PlotOrientation.HORIZONTAL) { [EOL]                 g2.draw(new Line2D.Double(yyLow, xx, yyHigh, xx)); [EOL]                 entityArea = new Rectangle2D.Double(Math.min(yyLow, yyHigh), xx - 1.0, Math.abs(yyHigh - yyLow), 2.0); [EOL]             } else if (orientation == PlotOrientation.VERTICAL) { [EOL]                 g2.draw(new Line2D.Double(xx, yyLow, xx, yyHigh)); [EOL]                 entityArea = new Rectangle2D.Double(xx - 1.0, Math.min(yyLow, yyHigh), 2.0, Math.abs(yyHigh - yyLow)); [EOL]             } [EOL]         } [EOL]         double delta = getTickLength(); [EOL]         if (domainAxis.isInverted()) { [EOL]             delta = -delta; [EOL]         } [EOL]         if (getDrawOpenTicks()) { [EOL]             double yOpen = hld.getOpenValue(series, item); [EOL]             if (!Double.isNaN(yOpen)) { [EOL]                 double yyOpen = rangeAxis.valueToJava2D(yOpen, dataArea, location); [EOL]                 if (this.openTickPaint != null) { [EOL]                     g2.setPaint(this.openTickPaint); [EOL]                 } else { [EOL]                     g2.setPaint(itemPaint); [EOL]                 } [EOL]                 if (orientation == PlotOrientation.HORIZONTAL) { [EOL]                     g2.draw(new Line2D.Double(yyOpen, xx + delta, yyOpen, xx)); [EOL]                 } else if (orientation == PlotOrientation.VERTICAL) { [EOL]                     g2.draw(new Line2D.Double(xx - delta, yyOpen, xx, yyOpen)); [EOL]                 } [EOL]             } [EOL]         } [EOL]         if (getDrawCloseTicks()) { [EOL]             double yClose = hld.getCloseValue(series, item); [EOL]             if (!Double.isNaN(yClose)) { [EOL]                 double yyClose = rangeAxis.valueToJava2D(yClose, dataArea, location); [EOL]                 if (this.closeTickPaint != null) { [EOL]                     g2.setPaint(this.closeTickPaint); [EOL]                 } else { [EOL]                     g2.setPaint(itemPaint); [EOL]                 } [EOL]                 if (orientation == PlotOrientation.HORIZONTAL) { [EOL]                     g2.draw(new Line2D.Double(yyClose, xx, yyClose, xx - delta)); [EOL]                 } else if (orientation == PlotOrientation.VERTICAL) { [EOL]                     g2.draw(new Line2D.Double(xx, yyClose, xx + delta, yyClose)); [EOL]                 } [EOL]             } [EOL]         } [EOL]     } else { [EOL]         if (item > 0) { [EOL]             double x0 = dataset.getXValue(series, item - 1); [EOL]             double y0 = dataset.getYValue(series, item - 1); [EOL]             double y = dataset.getYValue(series, item); [EOL]             if (Double.isNaN(x0) || Double.isNaN(y0) || Double.isNaN(y)) { [EOL]                 return; [EOL]             } [EOL]             double xx0 = domainAxis.valueToJava2D(x0, dataArea, plot.getDomainAxisEdge()); [EOL]             double yy0 = rangeAxis.valueToJava2D(y0, dataArea, location); [EOL]             double yy = rangeAxis.valueToJava2D(y, dataArea, location); [EOL]             if (orientation == PlotOrientation.HORIZONTAL) { [EOL]                 g2.draw(new Line2D.Double(yy0, xx0, yy, xx)); [EOL]             } else if (orientation == PlotOrientation.VERTICAL) { [EOL]                 g2.draw(new Line2D.Double(xx0, yy0, xx, yy)); [EOL]             } [EOL]         } [EOL]     } [EOL]     if (entities != null) { [EOL]         addEntity(entities, entityArea, dataset, series, item, selected, 0.0, 0.0); [EOL]     } [EOL] } <line_num>: 316,443
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 452,454
public boolean equals(Object obj) { [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof HighLowRenderer)) { [EOL]         return false; [EOL]     } [EOL]     HighLowRenderer that = (HighLowRenderer) obj; [EOL]     if (this.drawOpenTicks != that.drawOpenTicks) { [EOL]         return false; [EOL]     } [EOL]     if (this.drawCloseTicks != that.drawCloseTicks) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.openTickPaint, that.openTickPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.closeTickPaint, that.closeTickPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (this.tickLength != that.tickLength) { [EOL]         return false; [EOL]     } [EOL]     if (!super.equals(obj)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 463,490
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.openTickPaint = SerialUtilities.readPaint(stream); [EOL]     this.closeTickPaint = SerialUtilities.readPaint(stream); [EOL] } <line_num>: 500,505
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writePaint(this.openTickPaint, stream); [EOL]     SerialUtilities.writePaint(this.closeTickPaint, stream); [EOL] } <line_num>: 514,518