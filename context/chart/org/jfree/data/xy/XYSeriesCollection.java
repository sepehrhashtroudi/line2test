public XYSeriesCollection()
public XYSeriesCollection(XYSeries series)
public DomainOrder getDomainOrder()
public void addSeries(XYSeries series)
public void removeSeries(int series)
public void removeSeries(XYSeries series)
public void removeAllSeries()
public int getSeriesCount()
public List getSeries()
public int indexOf(XYSeries series)
public XYSeries getSeries(int series)
public XYSeries getSeries(Comparable key)
public Comparable getSeriesKey(int series)
public int getItemCount(int series)
public Number getX(int series, int item)
public Number getStartX(int series, int item)
public Number getEndX(int series, int item)
public Number getY(int series, int index)
public Number getStartY(int series, int item)
public Number getEndY(int series, int item)
public boolean isSelected(int series, int item)
public void setSelected(int series, int item, boolean selected)
public void setSelected(int series, int item, boolean selected, boolean notify)
public void clearSelection()
public void fireSelectionEvent()
public boolean equals(Object obj)
public Object clone() throws CloneNotSupportedException
public int hashCode()
public double getDomainLowerBound(boolean includeInterval)
public double getDomainUpperBound(boolean includeInterval)
public Range getDomainBounds(boolean includeInterval)
public double getIntervalWidth()
public void setIntervalWidth(double width)
public double getIntervalPositionFactor()
public void setIntervalPositionFactor(double factor)
public boolean isAutoWidth()
public void setAutoWidth(boolean b)
public Range getRangeBounds(boolean includeInterval)
public double getRangeLowerBound(boolean includeInterval)
public double getRangeUpperBound(boolean includeInterval)
long serialVersionUID=Optional[-7590013825931496766L]
List data
IntervalXYDelegate intervalDelegate
