public MultiplePiePlot()
public MultiplePiePlot(CategoryDataset dataset)
public CategoryDataset getDataset()
public void setDataset(CategoryDataset dataset)
public JFreeChart getPieChart()
public void setPieChart(JFreeChart pieChart)
public TableOrder getDataExtractOrder()
public void setDataExtractOrder(TableOrder order)
public double getLimit()
public void setLimit(double limit)
public Comparable getAggregatedItemsKey()
public void setAggregatedItemsKey(Comparable key)
public Paint getAggregatedItemsPaint()
public void setAggregatedItemsPaint(Paint paint)
public String getPlotType()
public Shape getLegendItemShape()
public void setLegendItemShape(Shape shape)
public void draw(Graphics2D g2, Rectangle2D area, Point2D anchor, PlotState parentState, PlotRenderingInfo info)
private void prefetchSectionPaints()
public LegendItemCollection getLegendItems()
public boolean equals(Object obj)
public Object clone() throws CloneNotSupportedException
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
long serialVersionUID=Optional[-355377800470807389L]
JFreeChart pieChart
CategoryDataset dataset
TableOrder dataExtractOrder
double limit=Optional[0.0]
Comparable aggregatedItemsKey
Paint aggregatedItemsPaint
Map sectionPaints
Shape legendItemShape
