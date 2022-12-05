public PeriodAxis(String label)
public PeriodAxis(String label, RegularTimePeriod first, RegularTimePeriod last)
public PeriodAxis(String label, RegularTimePeriod first, RegularTimePeriod last, TimeZone timeZone, Locale locale)
public RegularTimePeriod getFirst()
public void setFirst(RegularTimePeriod first)
public RegularTimePeriod getLast()
public void setLast(RegularTimePeriod last)
public TimeZone getTimeZone()
public void setTimeZone(TimeZone zone)
public Locale getLocale()
public Class getAutoRangeTimePeriodClass()
public void setAutoRangeTimePeriodClass(Class c)
public Class getMajorTickTimePeriodClass()
public void setMajorTickTimePeriodClass(Class c)
public boolean isMinorTickMarksVisible()
public void setMinorTickMarksVisible(boolean visible)
public Class getMinorTickTimePeriodClass()
public void setMinorTickTimePeriodClass(Class c)
public Stroke getMinorTickMarkStroke()
public void setMinorTickMarkStroke(Stroke stroke)
public Paint getMinorTickMarkPaint()
public void setMinorTickMarkPaint(Paint paint)
public float getMinorTickMarkInsideLength()
public void setMinorTickMarkInsideLength(float length)
public float getMinorTickMarkOutsideLength()
public void setMinorTickMarkOutsideLength(float length)
public PeriodAxisLabelInfo[] getLabelInfo()
public void setLabelInfo(PeriodAxisLabelInfo[] info)
public Range getRange()
public void setRange(Range range, boolean turnOffAutoRange, boolean notify)
public void configure()
public AxisSpace reserveSpace(Graphics2D g2, Plot plot, Rectangle2D plotArea, RectangleEdge edge, AxisSpace space)
public AxisState draw(Graphics2D g2, double cursor, Rectangle2D plotArea, Rectangle2D dataArea, RectangleEdge edge, PlotRenderingInfo plotState)
protected void drawTickMarks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge)
protected void drawTickMarksHorizontal(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge)
protected void drawTickMarksVertical(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge)
protected AxisState drawTickLabels(int band, Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge)
public List refreshTicks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge)
public double valueToJava2D(double value, Rectangle2D area, RectangleEdge edge)
public double java2DToValue(double java2DValue, Rectangle2D area, RectangleEdge edge)
protected void autoAdjustRange()
public boolean equals(Object obj)
public int hashCode()
public Object clone() throws CloneNotSupportedException
private RegularTimePeriod createInstance(Class periodClass, Date millisecond, TimeZone zone, Locale locale)
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
long serialVersionUID=Optional[8353295532075872069L]
RegularTimePeriod first
RegularTimePeriod last
TimeZone timeZone
Locale locale
Calendar calendar
Class autoRangeTimePeriodClass
Class majorTickTimePeriodClass
boolean minorTickMarksVisible
Class minorTickTimePeriodClass
float minorTickMarkInsideLength=Optional[0.0f]
float minorTickMarkOutsideLength=Optional[2.0f]
Stroke minorTickMarkStroke=Optional[new BasicStroke(0.5f)]
Paint minorTickMarkPaint=Optional[Color.black]
PeriodAxisLabelInfo[] labelInfo
