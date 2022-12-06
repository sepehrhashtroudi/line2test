public WindItemRenderer() { [EOL]     super(); [EOL] } <line_num>: 96,98
public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D plotArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, int pass) { [EOL]     WindDataset windData = (WindDataset) dataset; [EOL]     Paint seriesPaint = getItemPaint(series, item, selected); [EOL]     Stroke seriesStroke = getItemStroke(series, item, selected); [EOL]     g2.setPaint(seriesPaint); [EOL]     g2.setStroke(seriesStroke); [EOL]     Number x = windData.getX(series, item); [EOL]     Number windDir = windData.getWindDirection(series, item); [EOL]     Number wforce = windData.getWindForce(series, item); [EOL]     double windForce = wforce.doubleValue(); [EOL]     double wdirt = Math.toRadians(windDir.doubleValue() * (-30.0) - 90.0); [EOL]     double ax1, ax2, ay1, ay2, rax2, ray2; [EOL]     RectangleEdge domainAxisLocation = plot.getDomainAxisEdge(); [EOL]     RectangleEdge rangeAxisLocation = plot.getRangeAxisEdge(); [EOL]     ax1 = domainAxis.valueToJava2D(x.doubleValue(), plotArea, domainAxisLocation); [EOL]     ay1 = rangeAxis.valueToJava2D(0.0, plotArea, rangeAxisLocation); [EOL]     rax2 = x.doubleValue() + (windForce * Math.cos(wdirt) * 8000000.0); [EOL]     ray2 = windForce * Math.sin(wdirt); [EOL]     ax2 = domainAxis.valueToJava2D(rax2, plotArea, domainAxisLocation); [EOL]     ay2 = rangeAxis.valueToJava2D(ray2, plotArea, rangeAxisLocation); [EOL]     int diri = windDir.intValue(); [EOL]     int forcei = wforce.intValue(); [EOL]     String dirforce = diri + "-" + forcei; [EOL]     Line2D line = new Line2D.Double(ax1, ay1, ax2, ay2); [EOL]     g2.draw(line); [EOL]     g2.setPaint(Color.blue); [EOL]     g2.setFont(new Font("Tahoma", 1, 9)); [EOL]     g2.drawString(dirforce, (float) ax1, (float) ay1); [EOL]     g2.setPaint(seriesPaint); [EOL]     g2.setStroke(seriesStroke); [EOL]     double alx2, aly2, arx2, ary2; [EOL]     double ralx2, raly2, rarx2, rary2; [EOL]     double aldir = Math.toRadians(windDir.doubleValue() * (-30.0) - 90.0 - 5.0); [EOL]     ralx2 = wforce.doubleValue() * Math.cos(aldir) * 8000000 * 0.8 + x.doubleValue(); [EOL]     raly2 = wforce.doubleValue() * Math.sin(aldir) * 0.8; [EOL]     alx2 = domainAxis.valueToJava2D(ralx2, plotArea, domainAxisLocation); [EOL]     aly2 = rangeAxis.valueToJava2D(raly2, plotArea, rangeAxisLocation); [EOL]     line = new Line2D.Double(alx2, aly2, ax2, ay2); [EOL]     g2.draw(line); [EOL]     double ardir = Math.toRadians(windDir.doubleValue() * (-30.0) - 90.0 + 5.0); [EOL]     rarx2 = wforce.doubleValue() * Math.cos(ardir) * 8000000 * 0.8 + x.doubleValue(); [EOL]     rary2 = wforce.doubleValue() * Math.sin(ardir) * 0.8; [EOL]     arx2 = domainAxis.valueToJava2D(rarx2, plotArea, domainAxisLocation); [EOL]     ary2 = rangeAxis.valueToJava2D(rary2, plotArea, rangeAxisLocation); [EOL]     line = new Line2D.Double(arx2, ary2, ax2, ay2); [EOL]     g2.draw(line); [EOL] } <line_num>: 115,191
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 200,202