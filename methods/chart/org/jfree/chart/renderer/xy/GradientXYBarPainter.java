public GradientXYBarPainter() { [EOL]     this(0.10, 0.20, 0.80); [EOL] } <line_num>: 76,78
public GradientXYBarPainter(double g1, double g2, double g3) { [EOL]     this.g1 = g1; [EOL]     this.g2 = g2; [EOL]     this.g3 = g3; [EOL] } <line_num>: 87,91
public void paintBar(Graphics2D g2, XYBarRenderer renderer, int row, int column, boolean selected, RectangularShape bar, RectangleEdge base) { [EOL]     Paint itemPaint = renderer.getItemPaint(row, column, selected); [EOL]     Color c0, c1; [EOL]     if (itemPaint instanceof Color) { [EOL]         c0 = (Color) itemPaint; [EOL]         c1 = c0.brighter(); [EOL]     } else if (itemPaint instanceof GradientPaint) { [EOL]         GradientPaint gp = (GradientPaint) itemPaint; [EOL]         c0 = gp.getColor1(); [EOL]         c1 = gp.getColor2(); [EOL]     } else { [EOL]         c0 = Color.blue; [EOL]         c1 = Color.blue.brighter(); [EOL]     } [EOL]     if (c0.getAlpha() == 0) { [EOL]         return; [EOL]     } [EOL]     if (base == RectangleEdge.TOP || base == RectangleEdge.BOTTOM) { [EOL]         Rectangle2D[] regions = splitVerticalBar(bar, this.g1, this.g2, this.g3); [EOL]         GradientPaint gp = new GradientPaint((float) regions[0].getMinX(), 0.0f, c0, (float) regions[0].getMaxX(), 0.0f, Color.white); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[0]); [EOL]         gp = new GradientPaint((float) regions[1].getMinX(), 0.0f, Color.white, (float) regions[1].getMaxX(), 0.0f, c0); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[1]); [EOL]         gp = new GradientPaint((float) regions[2].getMinX(), 0.0f, c0, (float) regions[2].getMaxX(), 0.0f, c1); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[2]); [EOL]         gp = new GradientPaint((float) regions[3].getMinX(), 0.0f, c1, (float) regions[3].getMaxX(), 0.0f, c0); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[3]); [EOL]     } else if (base == RectangleEdge.LEFT || base == RectangleEdge.RIGHT) { [EOL]         Rectangle2D[] regions = splitHorizontalBar(bar, this.g1, this.g2, this.g3); [EOL]         GradientPaint gp = new GradientPaint(0.0f, (float) regions[0].getMinY(), c0, 0.0f, (float) regions[0].getMaxX(), Color.white); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[0]); [EOL]         gp = new GradientPaint(0.0f, (float) regions[1].getMinY(), Color.white, 0.0f, (float) regions[1].getMaxY(), c0); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[1]); [EOL]         gp = new GradientPaint(0.0f, (float) regions[2].getMinY(), c0, 0.0f, (float) regions[2].getMaxY(), c1); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[2]); [EOL]         gp = new GradientPaint(0.0f, (float) regions[3].getMinY(), c1, 0.0f, (float) regions[3].getMaxY(), c0); [EOL]         g2.setPaint(gp); [EOL]         g2.fill(regions[3]); [EOL]     } [EOL]     if (renderer.isDrawBarOutline()) { [EOL]         Stroke stroke = renderer.getItemOutlineStroke(row, column, selected); [EOL]         Paint paint = renderer.getItemOutlinePaint(row, column, selected); [EOL]         if (stroke != null && paint != null) { [EOL]             g2.setStroke(stroke); [EOL]             g2.setPaint(paint); [EOL]             g2.draw(bar); [EOL]         } [EOL]     } [EOL] } <line_num>: 107,195
public void paintBarShadow(Graphics2D g2, XYBarRenderer renderer, int row, int column, boolean selected, RectangularShape bar, RectangleEdge base, boolean pegShadow) { [EOL]     Paint itemPaint = renderer.getItemPaint(row, column, selected); [EOL]     if (itemPaint instanceof Color) { [EOL]         Color c = (Color) itemPaint; [EOL]         if (c.getAlpha() == 0) { [EOL]             return; [EOL]         } [EOL]     } [EOL]     RectangularShape shadow = createShadow(bar, renderer.getShadowXOffset(), renderer.getShadowYOffset(), base, pegShadow); [EOL]     g2.setPaint(Color.gray); [EOL]     g2.fill(shadow); [EOL] } <line_num>: 212,231
private Rectangle2D createShadow(RectangularShape bar, double xOffset, double yOffset, RectangleEdge base, boolean pegShadow) { [EOL]     double x0 = bar.getMinX(); [EOL]     double x1 = bar.getMaxX(); [EOL]     double y0 = bar.getMinY(); [EOL]     double y1 = bar.getMaxY(); [EOL]     if (base == RectangleEdge.TOP) { [EOL]         x0 += xOffset; [EOL]         x1 += xOffset; [EOL]         if (!pegShadow) { [EOL]             y0 += yOffset; [EOL]         } [EOL]         y1 += yOffset; [EOL]     } else if (base == RectangleEdge.BOTTOM) { [EOL]         x0 += xOffset; [EOL]         x1 += xOffset; [EOL]         y0 += yOffset; [EOL]         if (!pegShadow) { [EOL]             y1 += yOffset; [EOL]         } [EOL]     } else if (base == RectangleEdge.LEFT) { [EOL]         if (!pegShadow) { [EOL]             x0 += xOffset; [EOL]         } [EOL]         x1 += xOffset; [EOL]         y0 += yOffset; [EOL]         y1 += yOffset; [EOL]     } else if (base == RectangleEdge.RIGHT) { [EOL]         x0 += xOffset; [EOL]         if (!pegShadow) { [EOL]             x1 += xOffset; [EOL]         } [EOL]         y0 += yOffset; [EOL]         y1 += yOffset; [EOL]     } [EOL]     return new Rectangle2D.Double(x0, y0, (x1 - x0), (y1 - y0)); [EOL] } <line_num>: 244,283
private Rectangle2D[] splitVerticalBar(RectangularShape bar, double a, double b, double c) { [EOL]     Rectangle2D[] result = new Rectangle2D[4]; [EOL]     double x0 = bar.getMinX(); [EOL]     double x1 = Math.rint(x0 + (bar.getWidth() * a)); [EOL]     double x2 = Math.rint(x0 + (bar.getWidth() * b)); [EOL]     double x3 = Math.rint(x0 + (bar.getWidth() * c)); [EOL]     result[0] = new Rectangle2D.Double(bar.getMinX(), bar.getMinY(), x1 - x0, bar.getHeight()); [EOL]     result[1] = new Rectangle2D.Double(x1, bar.getMinY(), x2 - x1, bar.getHeight()); [EOL]     result[2] = new Rectangle2D.Double(x2, bar.getMinY(), x3 - x2, bar.getHeight()); [EOL]     result[3] = new Rectangle2D.Double(x3, bar.getMinY(), bar.getMaxX() - x3, bar.getHeight()); [EOL]     return result; [EOL] } <line_num>: 296,312
private Rectangle2D[] splitHorizontalBar(RectangularShape bar, double a, double b, double c) { [EOL]     Rectangle2D[] result = new Rectangle2D[4]; [EOL]     double y0 = bar.getMinY(); [EOL]     double y1 = Math.rint(y0 + (bar.getHeight() * a)); [EOL]     double y2 = Math.rint(y0 + (bar.getHeight() * b)); [EOL]     double y3 = Math.rint(y0 + (bar.getHeight() * c)); [EOL]     result[0] = new Rectangle2D.Double(bar.getMinX(), bar.getMinY(), bar.getWidth(), y1 - y0); [EOL]     result[1] = new Rectangle2D.Double(bar.getMinX(), y1, bar.getWidth(), y2 - y1); [EOL]     result[2] = new Rectangle2D.Double(bar.getMinX(), y2, bar.getWidth(), y3 - y2); [EOL]     result[3] = new Rectangle2D.Double(bar.getMinX(), y3, bar.getWidth(), bar.getMaxY() - y3); [EOL]     return result; [EOL] } <line_num>: 325,341
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof GradientXYBarPainter)) { [EOL]         return false; [EOL]     } [EOL]     GradientXYBarPainter that = (GradientXYBarPainter) obj; [EOL]     if (this.g1 != that.g1) { [EOL]         return false; [EOL]     } [EOL]     if (this.g2 != that.g2) { [EOL]         return false; [EOL]     } [EOL]     if (this.g3 != that.g3) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 350,368
public int hashCode() { [EOL]     int hash = 37; [EOL]     hash = HashUtilities.hashCode(hash, this.g1); [EOL]     hash = HashUtilities.hashCode(hash, this.g2); [EOL]     hash = HashUtilities.hashCode(hash, this.g3); [EOL]     return hash; [EOL] } <line_num>: 375,381
