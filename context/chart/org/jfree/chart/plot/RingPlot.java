public RingPlot()
public RingPlot(PieDataset dataset)
public boolean getSeparatorsVisible()
public void setSeparatorsVisible(boolean visible)
public Stroke getSeparatorStroke()
public void setSeparatorStroke(Stroke stroke)
public Paint getSeparatorPaint()
public void setSeparatorPaint(Paint paint)
public double getInnerSeparatorExtension()
public void setInnerSeparatorExtension(double percent)
public double getOuterSeparatorExtension()
public void setOuterSeparatorExtension(double percent)
public double getSectionDepth()
public void setSectionDepth(double sectionDepth)
public PiePlotState initialise(Graphics2D g2, Rectangle2D plotArea, PiePlot plot, Integer index, PlotRenderingInfo info)
protected void drawItem(Graphics2D g2, int section, Rectangle2D dataArea, PiePlotState state, int currentPass)
protected double getLabelLinkDepth()
public boolean equals(Object obj)
private Line2D extendLine(Line2D line, double startPercent, double endPercent)
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
long serialVersionUID=Optional[1556064784129676620L]
boolean separatorsVisible
Stroke separatorStroke
Paint separatorPaint
double innerSeparatorExtension
double outerSeparatorExtension
double sectionDepth
