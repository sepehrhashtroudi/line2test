public JFreeChart(Plot plot) { [EOL]     this(null, null, plot, true); [EOL] } <line_num>: 339,341
public JFreeChart(String title, Plot plot) { [EOL]     this(title, JFreeChart.DEFAULT_TITLE_FONT, plot, true); [EOL] } <line_num>: 355,357
public JFreeChart(String title, Font titleFont, Plot plot, boolean createLegend) { [EOL]     if (plot == null) { [EOL]         throw new NullPointerException("Null 'plot' argument."); [EOL]     } [EOL]     this.progressListeners = new EventListenerList(); [EOL]     this.changeListeners = new EventListenerList(); [EOL]     this.notify = true; [EOL]     this.renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); [EOL]     this.borderVisible = false; [EOL]     this.borderStroke = new BasicStroke(1.0f); [EOL]     this.borderPaint = Color.black; [EOL]     this.padding = RectangleInsets.ZERO_INSETS; [EOL]     this.plot = plot; [EOL]     plot.addChangeListener(this); [EOL]     this.subtitles = new ArrayList(); [EOL]     if (createLegend) { [EOL]         LegendTitle legend = new LegendTitle(this.plot); [EOL]         legend.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0)); [EOL]         legend.setFrame(new LineBorder()); [EOL]         legend.setBackgroundPaint(Color.white); [EOL]         legend.setPosition(RectangleEdge.BOTTOM); [EOL]         this.subtitles.add(legend); [EOL]         legend.addChangeListener(this); [EOL]     } [EOL]     if (title != null) { [EOL]         if (titleFont == null) { [EOL]             titleFont = DEFAULT_TITLE_FONT; [EOL]         } [EOL]         this.title = new TextTitle(title, titleFont); [EOL]         this.title.addChangeListener(this); [EOL]     } [EOL]     this.backgroundPaint = DEFAULT_BACKGROUND_PAINT; [EOL]     this.backgroundImage = DEFAULT_BACKGROUND_IMAGE; [EOL]     this.backgroundImageAlignment = DEFAULT_BACKGROUND_IMAGE_ALIGNMENT; [EOL]     this.backgroundImageAlpha = DEFAULT_BACKGROUND_IMAGE_ALPHA; [EOL] } <line_num>: 376,430
public JFreeChartInfo() { [EOL]     String baseResourceClass = "org.jfree.chart.resources.JFreeChartResources"; [EOL]     ResourceBundle resources = ResourceBundleWrapper.getBundle(baseResourceClass); [EOL]     setName(resources.getString("project.name")); [EOL]     setVersion(resources.getString("project.version")); [EOL]     setInfo(resources.getString("project.info")); [EOL]     setCopyright(resources.getString("project.copyright")); [EOL]     setLogo(null); [EOL]     setLicenceName("LGPL"); [EOL]     setLicenceText(Licences.getInstance().getLGPL()); [EOL]     setContributors(Arrays.asList(new Contributor[] { new Contributor("Eric Alexander", "-"), new Contributor("Richard Atkinson", "richard_c_atkinson@ntlworld.com"), new Contributor("David Basten", "-"), new Contributor("David Berry", "-"), new Contributor("Chris Boek", "-"), new Contributor("Zoheb Borbora", "-"), new Contributor("Anthony Boulestreau", "-"), new Contributor("Jeremy Bowman", "-"), new Contributor("Nicolas Brodu", "-"), new Contributor("Jody Brownell", "-"), new Contributor("David Browning", "-"), new Contributor("Soren Caspersen", "-"), new Contributor("Chuanhao Chiu", "-"), new Contributor("Brian Cole", "-"), new Contributor("Pascal Collet", "-"), new Contributor("Martin Cordova", "-"), new Contributor("Paolo Cova", "-"), new Contributor("Greg Darke", "-"), new Contributor("Mike Duffy", "-"), new Contributor("Don Elliott", "-"), new Contributor("David Forslund", "-"), new Contributor("Jonathan Gabbai", "-"), new Contributor("David Gilbert", "david.gilbert@object-refinery.com"), new Contributor("Serge V. Grachov", "-"), new Contributor("Daniel Gredler", "-"), new Contributor("Hans-Jurgen Greiner", "-"), new Contributor("Joao Guilherme Del Valle", "-"), new Contributor("Aiman Han", "-"), new Contributor("Cameron Hayne", "-"), new Contributor("Martin Hoeller", "-"), new Contributor("Jon Iles", "-"), new Contributor("Wolfgang Irler", "-"), new Contributor("Sergei Ivanov", "-"), new Contributor("Adriaan Joubert", "-"), new Contributor("Darren Jung", "-"), new Contributor("Xun Kang", "-"), new Contributor("Bill Kelemen", "-"), new Contributor("Norbert Kiesel", "-"), new Contributor("Peter Kolb", "-"), new Contributor("Gideon Krause", "-"), new Contributor("Pierre-Marie Le Biot", "-"), new Contributor("Arnaud Lelievre", "-"), new Contributor("Wolfgang Lenhard", "-"), new Contributor("David Li", "-"), new Contributor("Yan Liu", "-"), new Contributor("Tin Luu", "-"), new Contributor("Craig MacFarlane", "-"), new Contributor("Achilleus Mantzios", "-"), new Contributor("Thomas Meier", "-"), new Contributor("Jim Moore", "-"), new Contributor("Jonathan Nash", "-"), new Contributor("Barak Naveh", "-"), new Contributor("David M. O'Donnell", "-"), new Contributor("Krzysztof Paz", "-"), new Contributor("Eric Penfold", "-"), new Contributor("Tomer Peretz", "-"), new Contributor("Diego Pierangeli", "-"), new Contributor("Xavier Poinsard", "-"), new Contributor("Andrzej Porebski", "-"), new Contributor("Viktor Rajewski", "-"), new Contributor("Eduardo Ramalho", "-"), new Contributor("Michael Rauch", "-"), new Contributor("Cameron Riley", "-"), new Contributor("Klaus Rheinwald", "-"), new Contributor("Dan Rivett", "d.rivett@ukonline.co.uk"), new Contributor("Scott Sams", "-"), new Contributor("Michel Santos", "-"), new Contributor("Thierry Saura", "-"), new Contributor("Andreas Schneider", "-"), new Contributor("Jean-Luc SCHWAB", "-"), new Contributor("Bryan Scott", "-"), new Contributor("Tobias Selb", "-"), new Contributor("Darshan Shah", "-"), new Contributor("Mofeed Shahin", "-"), new Contributor("Michael Siemer", "-"), new Contributor("Pady Srinivasan", "-"), new Contributor("Greg Steckman", "-"), new Contributor("Gerald Struck", "-"), new Contributor("Roger Studner", "-"), new Contributor("Irv Thomae", "-"), new Contributor("Eric Thomas", "-"), new Contributor("Jess Thrysoee", "-"), new Contributor("Rich Unger", "-"), new Contributor("Daniel van Enckevort", "-"), new Contributor("Laurence Vanhelsuwe", "-"), new Contributor("Sylvain Vieujot", "-"), new Contributor("Ulrich Voigt", "-"), new Contributor("Jelai Wang", "-"), new Contributor("Mark Watson", "www.markwatson.com"), new Contributor("Alex Weber", "-"), new Contributor("Matthew Wright", "-"), new Contributor("Benoit Xhenseval", "-"), new Contributor("Christian W. Zuckschwerdt", "Christian.Zuckschwerdt@Informatik.Uni-Oldenburg.de"), new Contributor("Hari", "-"), new Contributor("Sam (oldman)", "-") })); [EOL] } <line_num>: 1753,1872
public RenderingHints getRenderingHints() { [EOL]     return this.renderingHints; [EOL] } <line_num>: 439,441
public void setRenderingHints(RenderingHints renderingHints) { [EOL]     if (renderingHints == null) { [EOL]         throw new NullPointerException("RenderingHints given are null"); [EOL]     } [EOL]     this.renderingHints = renderingHints; [EOL]     fireChartChanged(); [EOL] } <line_num>: 453,459
public boolean isBorderVisible() { [EOL]     return this.borderVisible; [EOL] } <line_num>: 469,471
public void setBorderVisible(boolean visible) { [EOL]     this.borderVisible = visible; [EOL]     fireChartChanged(); [EOL] } <line_num>: 481,484
public Stroke getBorderStroke() { [EOL]     return this.borderStroke; [EOL] } <line_num>: 493,495
public void setBorderStroke(Stroke stroke) { [EOL]     this.borderStroke = stroke; [EOL]     fireChartChanged(); [EOL] } <line_num>: 504,507
public Paint getBorderPaint() { [EOL]     return this.borderPaint; [EOL] } <line_num>: 516,518
public void setBorderPaint(Paint paint) { [EOL]     this.borderPaint = paint; [EOL]     fireChartChanged(); [EOL] } <line_num>: 527,530
public RectangleInsets getPadding() { [EOL]     return this.padding; [EOL] } <line_num>: 539,541
public void setPadding(RectangleInsets padding) { [EOL]     if (padding == null) { [EOL]         throw new IllegalArgumentException("Null 'padding' argument."); [EOL]     } [EOL]     this.padding = padding; [EOL]     notifyListeners(new ChartChangeEvent(this)); [EOL] } <line_num>: 551,557
public TextTitle getTitle() { [EOL]     return this.title; [EOL] } <line_num>: 569,571
public void setTitle(TextTitle title) { [EOL]     if (this.title != null) { [EOL]         this.title.removeChangeListener(this); [EOL]     } [EOL]     this.title = title; [EOL]     if (title != null) { [EOL]         title.addChangeListener(this); [EOL]     } [EOL]     fireChartChanged(); [EOL] } <line_num>: 583,592
public void setTitle(String text) { [EOL]     if (text != null) { [EOL]         if (this.title == null) { [EOL]             setTitle(new TextTitle(text, JFreeChart.DEFAULT_TITLE_FONT)); [EOL]         } else { [EOL]             this.title.setText(text); [EOL]         } [EOL]     } else { [EOL]         setTitle((TextTitle) null); [EOL]     } [EOL] } <line_num>: 606,618
public void addLegend(LegendTitle legend) { [EOL]     addSubtitle(legend); [EOL] } <line_num>: 628,630
public LegendTitle getLegend() { [EOL]     return getLegend(0); [EOL] } <line_num>: 640,642
public LegendTitle getLegend(int index) { [EOL]     int seen = 0; [EOL]     Iterator iterator = this.subtitles.iterator(); [EOL]     while (iterator.hasNext()) { [EOL]         Title subtitle = (Title) iterator.next(); [EOL]         if (subtitle instanceof LegendTitle) { [EOL]             if (seen == index) { [EOL]                 return (LegendTitle) subtitle; [EOL]             } else { [EOL]                 seen++; [EOL]             } [EOL]         } [EOL]     } [EOL]     return null; [EOL] } <line_num>: 653,668
public void removeLegend() { [EOL]     removeSubtitle(getLegend()); [EOL] } <line_num>: 676,678
public List getSubtitles() { [EOL]     return new ArrayList(this.subtitles); [EOL] } <line_num>: 687,689
public void setSubtitles(List subtitles) { [EOL]     if (subtitles == null) { [EOL]         throw new NullPointerException("Null 'subtitles' argument."); [EOL]     } [EOL]     setNotify(false); [EOL]     clearSubtitles(); [EOL]     Iterator iterator = subtitles.iterator(); [EOL]     while (iterator.hasNext()) { [EOL]         Title t = (Title) iterator.next(); [EOL]         if (t != null) { [EOL]             addSubtitle(t); [EOL]         } [EOL]     } [EOL]     setNotify(true); [EOL] } <line_num>: 701,715
public int getSubtitleCount() { [EOL]     return this.subtitles.size(); [EOL] } <line_num>: 724,726
public Title getSubtitle(int index) { [EOL]     if ((index < 0) || (index >= getSubtitleCount())) { [EOL]         throw new IllegalArgumentException("Index out of range."); [EOL]     } [EOL]     return (Title) this.subtitles.get(index); [EOL] } <line_num>: 737,742
public void addSubtitle(Title subtitle) { [EOL]     if (subtitle == null) { [EOL]         throw new IllegalArgumentException("Null 'subtitle' argument."); [EOL]     } [EOL]     this.subtitles.add(subtitle); [EOL]     subtitle.addChangeListener(this); [EOL]     fireChartChanged(); [EOL] } <line_num>: 752,759
public void addSubtitle(int index, Title subtitle) { [EOL]     if (index < 0 || index > getSubtitleCount()) { [EOL]         throw new IllegalArgumentException("The 'index' argument is out of range."); [EOL]     } [EOL]     if (subtitle == null) { [EOL]         throw new IllegalArgumentException("Null 'subtitle' argument."); [EOL]     } [EOL]     this.subtitles.add(index, subtitle); [EOL]     subtitle.addChangeListener(this); [EOL]     fireChartChanged(); [EOL] } <line_num>: 770,781
public void clearSubtitles() { [EOL]     Iterator iterator = this.subtitles.iterator(); [EOL]     while (iterator.hasNext()) { [EOL]         Title t = (Title) iterator.next(); [EOL]         t.removeChangeListener(this); [EOL]     } [EOL]     this.subtitles.clear(); [EOL]     fireChartChanged(); [EOL] } <line_num>: 789,797
public void removeSubtitle(Title title) { [EOL]     this.subtitles.remove(title); [EOL]     fireChartChanged(); [EOL] } <line_num>: 807,810
public Plot getPlot() { [EOL]     return this.plot; [EOL] } <line_num>: 819,821
public CategoryPlot getCategoryPlot() { [EOL]     return (CategoryPlot) this.plot; [EOL] } <line_num>: 833,835
public XYPlot getXYPlot() { [EOL]     return (XYPlot) this.plot; [EOL] } <line_num>: 847,849
public boolean getAntiAlias() { [EOL]     Object val = this.renderingHints.get(RenderingHints.KEY_ANTIALIASING); [EOL]     return RenderingHints.VALUE_ANTIALIAS_ON.equals(val); [EOL] } <line_num>: 859,862
public void setAntiAlias(boolean flag) { [EOL]     Object val = this.renderingHints.get(RenderingHints.KEY_ANTIALIASING); [EOL]     if (val == null) { [EOL]         val = RenderingHints.VALUE_ANTIALIAS_DEFAULT; [EOL]     } [EOL]     if (!flag && RenderingHints.VALUE_ANTIALIAS_OFF.equals(val) || flag && RenderingHints.VALUE_ANTIALIAS_ON.equals(val)) { [EOL]         return; [EOL]     } [EOL]     if (flag) { [EOL]         this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); [EOL]     } else { [EOL]         this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); [EOL]     } [EOL]     fireChartChanged(); [EOL] } <line_num>: 874,895
public Object getTextAntiAlias() { [EOL]     return this.renderingHints.get(RenderingHints.KEY_TEXT_ANTIALIASING); [EOL] } <line_num>: 907,909
public void setTextAntiAlias(boolean flag) { [EOL]     if (flag) { [EOL]         setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_ON); [EOL]     } else { [EOL]         setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF); [EOL]     } [EOL] } <line_num>: 925,932
public void setTextAntiAlias(Object val) { [EOL]     this.renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, val); [EOL]     notifyListeners(new ChartChangeEvent(this)); [EOL] } <line_num>: 946,949
public Paint getBackgroundPaint() { [EOL]     return this.backgroundPaint; [EOL] } <line_num>: 958,960
public void setBackgroundPaint(Paint paint) { [EOL]     if (this.backgroundPaint != null) { [EOL]         if (!this.backgroundPaint.equals(paint)) { [EOL]             this.backgroundPaint = paint; [EOL]             fireChartChanged(); [EOL]         } [EOL]     } else { [EOL]         if (paint != null) { [EOL]             this.backgroundPaint = paint; [EOL]             fireChartChanged(); [EOL]         } [EOL]     } [EOL] } <line_num>: 970,985
public Image getBackgroundImage() { [EOL]     return this.backgroundImage; [EOL] } <line_num>: 995,997
public void setBackgroundImage(Image image) { [EOL]     if (this.backgroundImage != null) { [EOL]         if (!this.backgroundImage.equals(image)) { [EOL]             this.backgroundImage = image; [EOL]             fireChartChanged(); [EOL]         } [EOL]     } else { [EOL]         if (image != null) { [EOL]             this.backgroundImage = image; [EOL]             fireChartChanged(); [EOL]         } [EOL]     } [EOL] } <line_num>: 1007,1022
public int getBackgroundImageAlignment() { [EOL]     return this.backgroundImageAlignment; [EOL] } <line_num>: 1033,1035
public void setBackgroundImageAlignment(int alignment) { [EOL]     if (this.backgroundImageAlignment != alignment) { [EOL]         this.backgroundImageAlignment = alignment; [EOL]         fireChartChanged(); [EOL]     } [EOL] } <line_num>: 1045,1050
public float getBackgroundImageAlpha() { [EOL]     return this.backgroundImageAlpha; [EOL] } <line_num>: 1059,1061
public void setBackgroundImageAlpha(float alpha) { [EOL]     if (this.backgroundImageAlpha != alpha) { [EOL]         this.backgroundImageAlpha = alpha; [EOL]         fireChartChanged(); [EOL]     } [EOL] } <line_num>: 1071,1078
public boolean isNotify() { [EOL]     return this.notify; [EOL] } <line_num>: 1088,1090
public void setNotify(boolean notify) { [EOL]     this.notify = notify; [EOL]     if (notify) { [EOL]         notifyListeners(new ChartChangeEvent(this)); [EOL]     } [EOL] } <line_num>: 1100,1106
public void draw(Graphics2D g2, Rectangle2D area) { [EOL]     draw(g2, area, null, null); [EOL] } <line_num>: 1117,1119
public void draw(Graphics2D g2, Rectangle2D area, ChartRenderingInfo info) { [EOL]     draw(g2, area, null, info); [EOL] } <line_num>: 1129,1131
public void draw(Graphics2D g2, Rectangle2D chartArea, Point2D anchor, ChartRenderingInfo info) { [EOL]     notifyListeners(new ChartProgressEvent(this, this, ChartProgressEvent.DRAWING_STARTED, 0)); [EOL]     EntityCollection entities = null; [EOL]     if (info != null) { [EOL]         info.clear(); [EOL]         info.setChartArea(chartArea); [EOL]         entities = info.getEntityCollection(); [EOL]     } [EOL]     if (entities != null) { [EOL]         entities.add(new JFreeChartEntity((Rectangle2D) chartArea.clone(), this)); [EOL]     } [EOL]     Shape savedClip = g2.getClip(); [EOL]     g2.clip(chartArea); [EOL]     g2.addRenderingHints(this.renderingHints); [EOL]     if (this.backgroundPaint != null) { [EOL]         g2.setPaint(this.backgroundPaint); [EOL]         g2.fill(chartArea); [EOL]     } [EOL]     if (this.backgroundImage != null) { [EOL]         Composite originalComposite = g2.getComposite(); [EOL]         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.backgroundImageAlpha)); [EOL]         Rectangle2D dest = new Rectangle2D.Double(0.0, 0.0, this.backgroundImage.getWidth(null), this.backgroundImage.getHeight(null)); [EOL]         Align.align(dest, chartArea, this.backgroundImageAlignment); [EOL]         g2.drawImage(this.backgroundImage, (int) dest.getX(), (int) dest.getY(), (int) dest.getWidth(), (int) dest.getHeight(), null); [EOL]         g2.setComposite(originalComposite); [EOL]     } [EOL]     if (isBorderVisible()) { [EOL]         Paint paint = getBorderPaint(); [EOL]         Stroke stroke = getBorderStroke(); [EOL]         if (paint != null && stroke != null) { [EOL]             Rectangle2D borderArea = new Rectangle2D.Double(chartArea.getX(), chartArea.getY(), chartArea.getWidth() - 1.0, chartArea.getHeight() - 1.0); [EOL]             g2.setPaint(paint); [EOL]             g2.setStroke(stroke); [EOL]             g2.draw(borderArea); [EOL]         } [EOL]     } [EOL]     Rectangle2D nonTitleArea = new Rectangle2D.Double(); [EOL]     nonTitleArea.setRect(chartArea); [EOL]     this.padding.trim(nonTitleArea); [EOL]     if (this.title != null && this.title.isVisible()) { [EOL]         EntityCollection e = drawTitle(this.title, g2, nonTitleArea, (entities != null)); [EOL]         if (e != null) { [EOL]             entities.addAll(e); [EOL]         } [EOL]     } [EOL]     Iterator iterator = this.subtitles.iterator(); [EOL]     while (iterator.hasNext()) { [EOL]         Title currentTitle = (Title) iterator.next(); [EOL]         if (currentTitle.isVisible()) { [EOL]             EntityCollection e = drawTitle(currentTitle, g2, nonTitleArea, (entities != null)); [EOL]             if (e != null) { [EOL]                 entities.addAll(e); [EOL]             } [EOL]         } [EOL]     } [EOL]     Rectangle2D plotArea = nonTitleArea; [EOL]     PlotRenderingInfo plotInfo = null; [EOL]     if (info != null) { [EOL]         plotInfo = info.getPlotInfo(); [EOL]     } [EOL]     this.plot.draw(g2, plotArea, anchor, null, plotInfo); [EOL]     g2.setClip(savedClip); [EOL]     notifyListeners(new ChartProgressEvent(this, this, ChartProgressEvent.DRAWING_FINISHED, 100)); [EOL] } <line_num>: 1145,1242
private Rectangle2D createAlignedRectangle2D(Size2D dimensions, Rectangle2D frame, HorizontalAlignment hAlign, VerticalAlignment vAlign) { [EOL]     double x = Double.NaN; [EOL]     double y = Double.NaN; [EOL]     if (hAlign == HorizontalAlignment.LEFT) { [EOL]         x = frame.getX(); [EOL]     } else if (hAlign == HorizontalAlignment.CENTER) { [EOL]         x = frame.getCenterX() - (dimensions.width / 2.0); [EOL]     } else if (hAlign == HorizontalAlignment.RIGHT) { [EOL]         x = frame.getMaxX() - dimensions.width; [EOL]     } [EOL]     if (vAlign == VerticalAlignment.TOP) { [EOL]         y = frame.getY(); [EOL]     } else if (vAlign == VerticalAlignment.CENTER) { [EOL]         y = frame.getCenterY() - (dimensions.height / 2.0); [EOL]     } else if (vAlign == VerticalAlignment.BOTTOM) { [EOL]         y = frame.getMaxY() - dimensions.height; [EOL]     } [EOL]     return new Rectangle2D.Double(x, y, dimensions.width, dimensions.height); [EOL] } <line_num>: 1254,1280
protected EntityCollection drawTitle(Title t, Graphics2D g2, Rectangle2D area, boolean entities) { [EOL]     if (t == null) { [EOL]         throw new IllegalArgumentException("Null 't' argument."); [EOL]     } [EOL]     if (area == null) { [EOL]         throw new IllegalArgumentException("Null 'area' argument."); [EOL]     } [EOL]     Rectangle2D titleArea; [EOL]     RectangleEdge position = t.getPosition(); [EOL]     double ww = area.getWidth(); [EOL]     if (ww <= 0.0) { [EOL]         return null; [EOL]     } [EOL]     double hh = area.getHeight(); [EOL]     if (hh <= 0.0) { [EOL]         return null; [EOL]     } [EOL]     RectangleConstraint constraint = new RectangleConstraint(ww, new Range(0.0, ww), LengthConstraintType.RANGE, hh, new Range(0.0, hh), LengthConstraintType.RANGE); [EOL]     Object retValue = null; [EOL]     BlockParams p = new BlockParams(); [EOL]     p.setGenerateEntities(entities); [EOL]     if (position == RectangleEdge.TOP) { [EOL]         Size2D size = t.arrange(g2, constraint); [EOL]         titleArea = createAlignedRectangle2D(size, area, t.getHorizontalAlignment(), VerticalAlignment.TOP); [EOL]         retValue = t.draw(g2, titleArea, p); [EOL]         area.setRect(area.getX(), Math.min(area.getY() + size.height, area.getMaxY()), area.getWidth(), Math.max(area.getHeight() - size.height, 0)); [EOL]     } else if (position == RectangleEdge.BOTTOM) { [EOL]         Size2D size = t.arrange(g2, constraint); [EOL]         titleArea = createAlignedRectangle2D(size, area, t.getHorizontalAlignment(), VerticalAlignment.BOTTOM); [EOL]         retValue = t.draw(g2, titleArea, p); [EOL]         area.setRect(area.getX(), area.getY(), area.getWidth(), area.getHeight() - size.height); [EOL]     } else if (position == RectangleEdge.RIGHT) { [EOL]         Size2D size = t.arrange(g2, constraint); [EOL]         titleArea = createAlignedRectangle2D(size, area, HorizontalAlignment.RIGHT, t.getVerticalAlignment()); [EOL]         retValue = t.draw(g2, titleArea, p); [EOL]         area.setRect(area.getX(), area.getY(), area.getWidth() - size.width, area.getHeight()); [EOL]     } else if (position == RectangleEdge.LEFT) { [EOL]         Size2D size = t.arrange(g2, constraint); [EOL]         titleArea = createAlignedRectangle2D(size, area, HorizontalAlignment.LEFT, t.getVerticalAlignment()); [EOL]         retValue = t.draw(g2, titleArea, p); [EOL]         area.setRect(area.getX() + size.width, area.getY(), area.getWidth() - size.width, area.getHeight()); [EOL]     } else { [EOL]         throw new RuntimeException("Unrecognised title position."); [EOL]     } [EOL]     EntityCollection result = null; [EOL]     if (retValue instanceof EntityBlockResult) { [EOL]         EntityBlockResult ebr = (EntityBlockResult) retValue; [EOL]         result = ebr.getEntityCollection(); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 1296,1364
public BufferedImage createBufferedImage(int width, int height) { [EOL]     return createBufferedImage(width, height, null); [EOL] } <line_num>: 1374,1376
public BufferedImage createBufferedImage(int width, int height, ChartRenderingInfo info) { [EOL]     return createBufferedImage(width, height, BufferedImage.TYPE_INT_ARGB, info); [EOL] } <line_num>: 1388,1392
public BufferedImage createBufferedImage(int width, int height, int imageType, ChartRenderingInfo info) { [EOL]     BufferedImage image = new BufferedImage(width, height, imageType); [EOL]     if (info != null) { [EOL]         info.setRenderingSource(new BufferedImageRenderingSource(image)); [EOL]     } [EOL]     Graphics2D g2 = image.createGraphics(); [EOL]     draw(g2, new Rectangle2D.Double(0, 0, width, height), null, info); [EOL]     g2.dispose(); [EOL]     return image; [EOL] } <line_num>: 1405,1416
public BufferedImage createBufferedImage(int imageWidth, int imageHeight, double drawWidth, double drawHeight, ChartRenderingInfo info) { [EOL]     BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB); [EOL]     Graphics2D g2 = image.createGraphics(); [EOL]     double scaleX = imageWidth / drawWidth; [EOL]     double scaleY = imageHeight / drawHeight; [EOL]     AffineTransform st = AffineTransform.getScaleInstance(scaleX, scaleY); [EOL]     g2.transform(st); [EOL]     draw(g2, new Rectangle2D.Double(0, 0, drawWidth, drawHeight), null, info); [EOL]     g2.dispose(); [EOL]     return image; [EOL] } <line_num>: 1432,1450
public void handleClick(int x, int y, ChartRenderingInfo info) { [EOL]     this.plot.handleClick(x, y, info.getPlotInfo()); [EOL] } <line_num>: 1464,1470
public void addChangeListener(ChartChangeListener listener) { [EOL]     if (listener == null) { [EOL]         throw new IllegalArgumentException("Null 'listener' argument."); [EOL]     } [EOL]     this.changeListeners.add(ChartChangeListener.class, listener); [EOL] } <line_num>: 1479,1484
public void removeChangeListener(ChartChangeListener listener) { [EOL]     if (listener == null) { [EOL]         throw new IllegalArgumentException("Null 'listener' argument."); [EOL]     } [EOL]     this.changeListeners.remove(ChartChangeListener.class, listener); [EOL] } <line_num>: 1493,1498
public void fireChartChanged() { [EOL]     ChartChangeEvent event = new ChartChangeEvent(this); [EOL]     notifyListeners(event); [EOL] } <line_num>: 1505,1508
protected void notifyListeners(ChartChangeEvent event) { [EOL]     if (this.notify) { [EOL]         Object[] listeners = this.changeListeners.getListenerList(); [EOL]         for (int i = listeners.length - 2; i >= 0; i -= 2) { [EOL]             if (listeners[i] == ChartChangeListener.class) { [EOL]                 ((ChartChangeListener) listeners[i + 1]).chartChanged(event); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 1516,1526
public void addProgressListener(ChartProgressListener listener) { [EOL]     this.progressListeners.add(ChartProgressListener.class, listener); [EOL] } <line_num>: 1536,1538
public void removeProgressListener(ChartProgressListener listener) { [EOL]     this.progressListeners.remove(ChartProgressListener.class, listener); [EOL] } <line_num>: 1547,1549
protected void notifyListeners(ChartProgressEvent event) { [EOL]     Object[] listeners = this.progressListeners.getListenerList(); [EOL]     for (int i = listeners.length - 2; i >= 0; i -= 2) { [EOL]         if (listeners[i] == ChartProgressListener.class) { [EOL]             ((ChartProgressListener) listeners[i + 1]).chartProgress(event); [EOL]         } [EOL]     } [EOL] } <line_num>: 1557,1566
public void titleChanged(TitleChangeEvent event) { [EOL]     event.setChart(this); [EOL]     notifyListeners(event); [EOL] } <line_num>: 1574,1577
public void plotChanged(PlotChangeEvent event) { [EOL]     event.setChart(this); [EOL]     notifyListeners(event); [EOL] } <line_num>: 1585,1588
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof JFreeChart)) { [EOL]         return false; [EOL]     } [EOL]     JFreeChart that = (JFreeChart) obj; [EOL]     if (!this.renderingHints.equals(that.renderingHints)) { [EOL]         return false; [EOL]     } [EOL]     if (this.borderVisible != that.borderVisible) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.borderStroke, that.borderStroke)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.borderPaint, that.borderPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.padding.equals(that.padding)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.title, that.title)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.subtitles, that.subtitles)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.plot, that.plot)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.backgroundPaint, that.backgroundPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.backgroundImage, that.backgroundImage)) { [EOL]         return false; [EOL]     } [EOL]     if (this.backgroundImageAlignment != that.backgroundImageAlignment) { [EOL]         return false; [EOL]     } [EOL]     if (this.backgroundImageAlpha != that.backgroundImageAlpha) { [EOL]         return false; [EOL]     } [EOL]     if (this.notify != that.notify) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 1597,1648
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writeStroke(this.borderStroke, stream); [EOL]     SerialUtilities.writePaint(this.borderPaint, stream); [EOL]     SerialUtilities.writePaint(this.backgroundPaint, stream); [EOL] } <line_num>: 1657,1662
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.borderStroke = SerialUtilities.readStroke(stream); [EOL]     this.borderPaint = SerialUtilities.readPaint(stream); [EOL]     this.backgroundPaint = SerialUtilities.readPaint(stream); [EOL]     this.progressListeners = new EventListenerList(); [EOL]     this.changeListeners = new EventListenerList(); [EOL]     this.renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); [EOL]     if (this.title != null) { [EOL]         this.title.addChangeListener(this); [EOL]     } [EOL]     for (int i = 0; i < getSubtitleCount(); i++) { [EOL]         getSubtitle(i).addChangeListener(this); [EOL]     } [EOL]     this.plot.addChangeListener(this); [EOL] } <line_num>: 1672,1693
public static void main(String[] args) { [EOL]     System.out.println(JFreeChart.INFO.toString()); [EOL] } <line_num>: 1700,1702
public Object clone() throws CloneNotSupportedException { [EOL]     JFreeChart chart = (JFreeChart) super.clone(); [EOL]     chart.renderingHints = (RenderingHints) this.renderingHints.clone(); [EOL]     if (this.title != null) { [EOL]         chart.title = (TextTitle) this.title.clone(); [EOL]         chart.title.addChangeListener(chart); [EOL]     } [EOL]     chart.subtitles = new ArrayList(); [EOL]     for (int i = 0; i < getSubtitleCount(); i++) { [EOL]         Title subtitle = (Title) getSubtitle(i).clone(); [EOL]         chart.subtitles.add(subtitle); [EOL]         subtitle.addChangeListener(chart); [EOL]     } [EOL]     if (this.plot != null) { [EOL]         chart.plot = (Plot) this.plot.clone(); [EOL]         chart.plot.addChangeListener(chart); [EOL]     } [EOL]     chart.progressListeners = new EventListenerList(); [EOL]     chart.changeListeners = new EventListenerList(); [EOL]     return chart; [EOL] } <line_num>: 1712,1740
public Image getLogo() { [EOL]     Image logo = super.getLogo(); [EOL]     if (logo == null) { [EOL]         URL imageURL = this.getClass().getClassLoader().getResource("org/jfree/chart/gorilla.jpg"); [EOL]         if (imageURL != null) { [EOL]             ImageIcon temp = new ImageIcon(imageURL); [EOL]             logo = temp.getImage(); [EOL]             setLogo(logo); [EOL]         } [EOL]     } [EOL]     return logo; [EOL] } <line_num>: 1879,1894