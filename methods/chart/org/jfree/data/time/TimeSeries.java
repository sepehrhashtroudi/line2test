public TimeSeries(Comparable name) { [EOL]     this(name, DEFAULT_DOMAIN_DESCRIPTION, DEFAULT_RANGE_DESCRIPTION); [EOL] } <line_num>: 168,170
public TimeSeries(Comparable name, String domain, String range) { [EOL]     super(name); [EOL]     this.domain = domain; [EOL]     this.range = range; [EOL]     this.timePeriodClass = null; [EOL]     this.data = new java.util.ArrayList(); [EOL]     this.maximumItemCount = Integer.MAX_VALUE; [EOL]     this.maximumItemAge = Long.MAX_VALUE; [EOL]     this.minY = Double.NaN; [EOL]     this.maxY = Double.NaN; [EOL] } <line_num>: 185,195
public String getDomainDescription() { [EOL]     return this.domain; [EOL] } <line_num>: 204,206
public void setDomainDescription(String description) { [EOL]     String old = this.domain; [EOL]     this.domain = description; [EOL]     firePropertyChange("Domain", old, description); [EOL] } <line_num>: 217,221
public String getRangeDescription() { [EOL]     return this.range; [EOL] } <line_num>: 230,232
public void setRangeDescription(String description) { [EOL]     String old = this.range; [EOL]     this.range = description; [EOL]     firePropertyChange("Range", old, description); [EOL] } <line_num>: 242,246
public int getItemCount() { [EOL]     return this.data.size(); [EOL] } <line_num>: 253,255
public List getItems() { [EOL]     return Collections.unmodifiableList(this.data); [EOL] } <line_num>: 263,266
public int getMaximumItemCount() { [EOL]     return this.maximumItemCount; [EOL] } <line_num>: 276,278
public void setMaximumItemCount(int maximum) { [EOL]     if (maximum < 0) { [EOL]         throw new IllegalArgumentException("Negative 'maximum' argument."); [EOL]     } [EOL]     this.maximumItemCount = maximum; [EOL]     int count = this.data.size(); [EOL]     if (count > maximum) { [EOL]         delete(0, count - maximum - 1); [EOL]     } [EOL] } <line_num>: 291,300
public long getMaximumItemAge() { [EOL]     return this.maximumItemAge; [EOL] } <line_num>: 309,311
public void setMaximumItemAge(long periods) { [EOL]     if (periods < 0) { [EOL]         throw new IllegalArgumentException("Negative 'periods' argument."); [EOL]     } [EOL]     this.maximumItemAge = periods; [EOL]     removeAgedItems(true); [EOL] } <line_num>: 325,331
public double getMinY() { [EOL]     return this.minY; [EOL] } <line_num>: 344,346
public double getMaxY() { [EOL]     return this.maxY; [EOL] } <line_num>: 359,361
public Class getTimePeriodClass() { [EOL]     return this.timePeriodClass; [EOL] } <line_num>: 373,375
public TimeSeriesDataItem getDataItem(int index) { [EOL]     TimeSeriesDataItem item = (TimeSeriesDataItem) this.data.get(index); [EOL]     return (TimeSeriesDataItem) item.clone(); [EOL] } <line_num>: 388,391
public TimeSeriesDataItem getDataItem(RegularTimePeriod period) { [EOL]     int index = getIndex(period); [EOL]     if (index >= 0) { [EOL]         return getDataItem(index); [EOL]     } else { [EOL]         return null; [EOL]     } [EOL] } <line_num>: 405,413
TimeSeriesDataItem getRawDataItem(int index) { [EOL]     return (TimeSeriesDataItem) this.data.get(index); [EOL] } <line_num>: 428,430
TimeSeriesDataItem getRawDataItem(RegularTimePeriod period) { [EOL]     int index = getIndex(period); [EOL]     if (index >= 0) { [EOL]         return (TimeSeriesDataItem) this.data.get(index); [EOL]     } else { [EOL]         return null; [EOL]     } [EOL] } <line_num>: 445,453
public RegularTimePeriod getTimePeriod(int index) { [EOL]     return getRawDataItem(index).getPeriod(); [EOL] } <line_num>: 462,464
public RegularTimePeriod getNextTimePeriod() { [EOL]     RegularTimePeriod last = getTimePeriod(getItemCount() - 1); [EOL]     return last.next(); [EOL] } <line_num>: 472,475
public Collection getTimePeriods() { [EOL]     Collection result = new java.util.ArrayList(); [EOL]     for (int i = 0; i < getItemCount(); i++) { [EOL]         result.add(getTimePeriod(i)); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 482,488
public Collection getTimePeriodsUniqueToOtherSeries(TimeSeries series) { [EOL]     Collection result = new java.util.ArrayList(); [EOL]     for (int i = 0; i < series.getItemCount(); i++) { [EOL]         RegularTimePeriod period = series.getTimePeriod(i); [EOL]         int index = getIndex(period); [EOL]         if (index < 0) { [EOL]             result.add(period); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 498,508
public int getIndex(RegularTimePeriod period) { [EOL]     if (period == null) { [EOL]         throw new IllegalArgumentException("Null 'period' argument."); [EOL]     } [EOL]     TimeSeriesDataItem dummy = new TimeSeriesDataItem(period, Integer.MIN_VALUE); [EOL]     return Collections.binarySearch(this.data, dummy); [EOL] } <line_num>: 518,525
public Number getValue(int index) { [EOL]     return getRawDataItem(index).getValue(); [EOL] } <line_num>: 534,536
public Number getValue(RegularTimePeriod period) { [EOL]     int index = getIndex(period); [EOL]     if (index >= 0) { [EOL]         return getValue(index); [EOL]     } else { [EOL]         return null; [EOL]     } [EOL] } <line_num>: 546,554
public void add(TimeSeriesDataItem item) { [EOL]     add(item, true); [EOL] } <line_num>: 563,565
public void add(TimeSeriesDataItem item, boolean notify) { [EOL]     if (item == null) { [EOL]         throw new IllegalArgumentException("Null 'item' argument."); [EOL]     } [EOL]     item = (TimeSeriesDataItem) item.clone(); [EOL]     Class c = item.getPeriod().getClass(); [EOL]     if (this.timePeriodClass == null) { [EOL]         this.timePeriodClass = c; [EOL]     } else if (!this.timePeriodClass.equals(c)) { [EOL]         StringBuffer b = new StringBuffer(); [EOL]         b.append("You are trying to add data where the time period class "); [EOL]         b.append("is "); [EOL]         b.append(item.getPeriod().getClass().getName()); [EOL]         b.append(", but the TimeSeries is expecting an instance of "); [EOL]         b.append(this.timePeriodClass.getName()); [EOL]         b.append("."); [EOL]         throw new SeriesException(b.toString()); [EOL]     } [EOL]     boolean added = false; [EOL]     int count = getItemCount(); [EOL]     if (count == 0) { [EOL]         this.data.add(item); [EOL]         added = true; [EOL]     } else { [EOL]         RegularTimePeriod last = getTimePeriod(getItemCount() - 1); [EOL]         if (item.getPeriod().compareTo(last) > 0) { [EOL]             this.data.add(item); [EOL]             added = true; [EOL]         } else { [EOL]             int index = Collections.binarySearch(this.data, item); [EOL]             if (index < 0) { [EOL]                 this.data.add(-index - 1, item); [EOL]                 added = true; [EOL]             } else { [EOL]                 StringBuffer b = new StringBuffer(); [EOL]                 b.append("You are attempting to add an observation for "); [EOL]                 b.append("the time period "); [EOL]                 b.append(item.getPeriod().toString()); [EOL]                 b.append(" but the series already contains an observation"); [EOL]                 b.append(" for that time period. Duplicates are not "); [EOL]                 b.append("permitted.  Try using the addOrUpdate() method."); [EOL]                 throw new SeriesException(b.toString()); [EOL]             } [EOL]         } [EOL]     } [EOL]     if (added) { [EOL]         updateBoundsForAddedItem(item); [EOL]         if (getItemCount() > this.maximumItemCount) { [EOL]             TimeSeriesDataItem d = (TimeSeriesDataItem) this.data.remove(0); [EOL]             updateBoundsForRemovedItem(d); [EOL]         } [EOL]         removeAgedItems(false); [EOL]         if (notify) { [EOL]             fireSeriesChanged(); [EOL]         } [EOL]     } [EOL] } <line_num>: 575,642
public void add(RegularTimePeriod period, double value) { [EOL]     add(period, value, true); [EOL] } <line_num>: 651,654
public void add(RegularTimePeriod period, double value, boolean notify) { [EOL]     TimeSeriesDataItem item = new TimeSeriesDataItem(period, value); [EOL]     add(item, notify); [EOL] } <line_num>: 664,668
public void add(RegularTimePeriod period, Number value) { [EOL]     add(period, value, true); [EOL] } <line_num>: 678,681
public void add(RegularTimePeriod period, Number value, boolean notify) { [EOL]     TimeSeriesDataItem item = new TimeSeriesDataItem(period, value); [EOL]     add(item, notify); [EOL] } <line_num>: 691,695
public void update(RegularTimePeriod period, Number value) { [EOL]     TimeSeriesDataItem temp = new TimeSeriesDataItem(period, value); [EOL]     int index = Collections.binarySearch(this.data, temp); [EOL]     if (index < 0) { [EOL]         throw new SeriesException("There is no existing value for the " + "specified 'period'."); [EOL]     } [EOL]     update(index, value); [EOL] } <line_num>: 704,712
public void update(int index, Number value) { [EOL]     TimeSeriesDataItem item = (TimeSeriesDataItem) this.data.get(index); [EOL]     boolean iterate = false; [EOL]     Number oldYN = item.getValue(); [EOL]     if (oldYN != null) { [EOL]         double oldY = oldYN.doubleValue(); [EOL]         if (!Double.isNaN(oldY)) { [EOL]             iterate = oldY <= this.minY || oldY >= this.maxY; [EOL]         } [EOL]     } [EOL]     item.setValue(value); [EOL]     if (iterate) { [EOL]         findBoundsByIteration(); [EOL]     } else if (value != null) { [EOL]         double yy = value.doubleValue(); [EOL]         this.minY = minIgnoreNaN(this.minY, yy); [EOL]         this.maxY = maxIgnoreNaN(this.maxY, yy); [EOL]     } [EOL]     fireSeriesChanged(); [EOL] } <line_num>: 720,740
public TimeSeries addAndOrUpdate(TimeSeries series) { [EOL]     TimeSeries overwritten = new TimeSeries("Overwritten values from: " + getKey()); [EOL]     for (int i = 0; i < series.getItemCount(); i++) { [EOL]         TimeSeriesDataItem item = series.getRawDataItem(i); [EOL]         TimeSeriesDataItem oldItem = addOrUpdate(item.getPeriod(), item.getValue()); [EOL]         if (oldItem != null) { [EOL]             overwritten.add(oldItem); [EOL]         } [EOL]     } [EOL]     return overwritten; [EOL] } <line_num>: 750,762
public TimeSeriesDataItem addOrUpdate(RegularTimePeriod period, double value) { [EOL]     return addOrUpdate(period, new Double(value)); [EOL] } <line_num>: 775,778
public TimeSeriesDataItem addOrUpdate(RegularTimePeriod period, Number value) { [EOL]     return addOrUpdate(new TimeSeriesDataItem(period, value)); [EOL] } <line_num>: 791,794
public TimeSeriesDataItem addOrUpdate(TimeSeriesDataItem item) { [EOL]     if (item == null) { [EOL]         throw new IllegalArgumentException("Null 'period' argument."); [EOL]     } [EOL]     Class periodClass = item.getPeriod().getClass(); [EOL]     if (this.timePeriodClass == null) { [EOL]         this.timePeriodClass = periodClass; [EOL]     } else if (!this.timePeriodClass.equals(periodClass)) { [EOL]         String msg = "You are trying to add data where the time " + "period class is " + periodClass.getName() + ", but the TimeSeries is expecting an instance of " + this.timePeriodClass.getName() + "."; [EOL]         throw new SeriesException(msg); [EOL]     } [EOL]     TimeSeriesDataItem overwritten = null; [EOL]     int index = Collections.binarySearch(this.data, item); [EOL]     if (index >= 0) { [EOL]         TimeSeriesDataItem existing = (TimeSeriesDataItem) this.data.get(index); [EOL]         overwritten = (TimeSeriesDataItem) existing.clone(); [EOL]         boolean iterate = false; [EOL]         Number oldYN = existing.getValue(); [EOL]         double oldY = oldYN != null ? oldYN.doubleValue() : Double.NaN; [EOL]         if (!Double.isNaN(oldY)) { [EOL]             iterate = oldY <= this.minY || oldY >= this.maxY; [EOL]         } [EOL]         existing.setValue(item.getValue()); [EOL]         if (iterate) { [EOL]             findBoundsByIteration(); [EOL]         } else if (item.getValue() != null) { [EOL]             double yy = item.getValue().doubleValue(); [EOL]             this.minY = minIgnoreNaN(this.minY, yy); [EOL]             this.maxY = minIgnoreNaN(this.maxY, yy); [EOL]         } [EOL]     } else { [EOL]         item = (TimeSeriesDataItem) item.clone(); [EOL]         this.data.add(-index - 1, item); [EOL]         updateBoundsForAddedItem(item); [EOL]         if (getItemCount() > this.maximumItemCount) { [EOL]             TimeSeriesDataItem d = (TimeSeriesDataItem) this.data.remove(0); [EOL]             updateBoundsForRemovedItem(d); [EOL]         } [EOL]     } [EOL]     removeAgedItems(false); [EOL]     fireSeriesChanged(); [EOL]     return overwritten; [EOL] } <line_num>: 807,864
public void removeAgedItems(boolean notify) { [EOL]     if (getItemCount() > 1) { [EOL]         long latest = getTimePeriod(getItemCount() - 1).getSerialIndex(); [EOL]         boolean removed = false; [EOL]         while ((latest - getTimePeriod(0).getSerialIndex()) > this.maximumItemAge) { [EOL]             this.data.remove(0); [EOL]             removed = true; [EOL]         } [EOL]         if (removed) { [EOL]             findBoundsByIteration(); [EOL]             if (notify) { [EOL]                 fireSeriesChanged(); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 874,892
public void removeAgedItems(long latest, boolean notify) { [EOL]     if (this.data.isEmpty()) { [EOL]         return; [EOL]     } [EOL]     long index = Long.MAX_VALUE; [EOL]     try { [EOL]         Method m = RegularTimePeriod.class.getDeclaredMethod("createInstance", new Class[] { Class.class, Date.class, TimeZone.class }); [EOL]         RegularTimePeriod newest = (RegularTimePeriod) m.invoke(this.timePeriodClass, new Object[] { this.timePeriodClass, new Date(latest), TimeZone.getDefault() }); [EOL]         index = newest.getSerialIndex(); [EOL]     } catch (NoSuchMethodException e) { [EOL]         e.printStackTrace(); [EOL]     } catch (IllegalAccessException e) { [EOL]         e.printStackTrace(); [EOL]     } catch (InvocationTargetException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     boolean removed = false; [EOL]     while (getItemCount() > 0 && (index - getTimePeriod(0).getSerialIndex()) > this.maximumItemAge) { [EOL]         this.data.remove(0); [EOL]         removed = true; [EOL]     } [EOL]     if (removed) { [EOL]         findBoundsByIteration(); [EOL]         if (notify) { [EOL]             fireSeriesChanged(); [EOL]         } [EOL]     } [EOL] } <line_num>: 904,943
public void clear() { [EOL]     if (this.data.size() > 0) { [EOL]         this.data.clear(); [EOL]         this.timePeriodClass = null; [EOL]         this.minY = Double.NaN; [EOL]         this.maxY = Double.NaN; [EOL]         fireSeriesChanged(); [EOL]     } [EOL] } <line_num>: 949,957
public void delete(RegularTimePeriod period) { [EOL]     int index = getIndex(period); [EOL]     if (index >= 0) { [EOL]         TimeSeriesDataItem item = (TimeSeriesDataItem) this.data.remove(index); [EOL]         updateBoundsForRemovedItem(item); [EOL]         if (this.data.isEmpty()) { [EOL]             this.timePeriodClass = null; [EOL]         } [EOL]         fireSeriesChanged(); [EOL]     } [EOL] } <line_num>: 967,978
public void delete(int start, int end) { [EOL]     delete(start, end, true); [EOL] } <line_num>: 986,988
public void delete(int start, int end, boolean notify) { [EOL]     if (end < start) { [EOL]         throw new IllegalArgumentException("Requires start <= end."); [EOL]     } [EOL]     for (int i = 0; i <= (end - start); i++) { [EOL]         this.data.remove(start); [EOL]     } [EOL]     findBoundsByIteration(); [EOL]     if (this.data.isEmpty()) { [EOL]         this.timePeriodClass = null; [EOL]     } [EOL]     if (notify) { [EOL]         fireSeriesChanged(); [EOL]     } [EOL] } <line_num>: 999,1013
public Object clone() throws CloneNotSupportedException { [EOL]     TimeSeries clone = (TimeSeries) super.clone(); [EOL]     clone.data = (List) ObjectUtilities.deepClone(this.data); [EOL]     return clone; [EOL] } <line_num>: 1030,1034
public TimeSeries createCopy(int start, int end) throws CloneNotSupportedException { [EOL]     if (start < 0) { [EOL]         throw new IllegalArgumentException("Requires start >= 0."); [EOL]     } [EOL]     if (end < start) { [EOL]         throw new IllegalArgumentException("Requires start <= end."); [EOL]     } [EOL]     TimeSeries copy = (TimeSeries) super.clone(); [EOL]     copy.minY = Double.NaN; [EOL]     copy.maxY = Double.NaN; [EOL]     copy.data = new java.util.ArrayList(); [EOL]     if (this.data.size() > 0) { [EOL]         for (int index = start; index <= end; index++) { [EOL]             TimeSeriesDataItem item = (TimeSeriesDataItem) this.data.get(index); [EOL]             TimeSeriesDataItem clone = (TimeSeriesDataItem) item.clone(); [EOL]             try { [EOL]                 copy.add(clone); [EOL]             } catch (SeriesException e) { [EOL]                 e.printStackTrace(); [EOL]             } [EOL]         } [EOL]     } [EOL]     return copy; [EOL] } <line_num>: 1048,1074
public TimeSeries createCopy(RegularTimePeriod start, RegularTimePeriod end) throws CloneNotSupportedException { [EOL]     if (start == null) { [EOL]         throw new IllegalArgumentException("Null 'start' argument."); [EOL]     } [EOL]     if (end == null) { [EOL]         throw new IllegalArgumentException("Null 'end' argument."); [EOL]     } [EOL]     if (start.compareTo(end) > 0) { [EOL]         throw new IllegalArgumentException("Requires start on or before end."); [EOL]     } [EOL]     boolean emptyRange = false; [EOL]     int startIndex = getIndex(start); [EOL]     if (startIndex < 0) { [EOL]         startIndex = -(startIndex + 1); [EOL]         if (startIndex == this.data.size()) { [EOL]             emptyRange = true; [EOL]         } [EOL]     } [EOL]     int endIndex = getIndex(end); [EOL]     if (endIndex < 0) { [EOL]         endIndex = -(endIndex + 1); [EOL]         endIndex = endIndex - 1; [EOL]     } [EOL]     if ((endIndex < 0) || (endIndex < startIndex)) { [EOL]         emptyRange = true; [EOL]     } [EOL]     if (emptyRange) { [EOL]         TimeSeries copy = (TimeSeries) super.clone(); [EOL]         copy.data = new java.util.ArrayList(); [EOL]         return copy; [EOL]     } else { [EOL]         return createCopy(startIndex, endIndex); [EOL]     } [EOL] } <line_num>: 1090,1128
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof TimeSeries)) { [EOL]         return false; [EOL]     } [EOL]     TimeSeries that = (TimeSeries) obj; [EOL]     if (!ObjectUtilities.equal(getDomainDescription(), that.getDomainDescription())) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(getRangeDescription(), that.getRangeDescription())) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.timePeriodClass, that.timePeriodClass)) { [EOL]         return false; [EOL]     } [EOL]     if (getMaximumItemAge() != that.getMaximumItemAge()) { [EOL]         return false; [EOL]     } [EOL]     if (getMaximumItemCount() != that.getMaximumItemCount()) { [EOL]         return false; [EOL]     } [EOL]     int count = getItemCount(); [EOL]     if (count != that.getItemCount()) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.data, that.data)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 1137,1171
public int hashCode() { [EOL]     int result = super.hashCode(); [EOL]     result = 29 * result + (this.domain != null ? this.domain.hashCode() : 0); [EOL]     result = 29 * result + (this.range != null ? this.range.hashCode() : 0); [EOL]     result = 29 * result + (this.timePeriodClass != null ? this.timePeriodClass.hashCode() : 0); [EOL]     int count = getItemCount(); [EOL]     if (count > 0) { [EOL]         TimeSeriesDataItem item = getRawDataItem(0); [EOL]         result = 29 * result + item.hashCode(); [EOL]     } [EOL]     if (count > 1) { [EOL]         TimeSeriesDataItem item = getRawDataItem(count - 1); [EOL]         result = 29 * result + item.hashCode(); [EOL]     } [EOL]     if (count > 2) { [EOL]         TimeSeriesDataItem item = getRawDataItem(count / 2); [EOL]         result = 29 * result + item.hashCode(); [EOL]     } [EOL]     result = 29 * result + this.maximumItemCount; [EOL]     result = 29 * result + (int) this.maximumItemAge; [EOL]     return result; [EOL] } <line_num>: 1178,1203
private void updateBoundsForAddedItem(TimeSeriesDataItem item) { [EOL]     Number yN = item.getValue(); [EOL]     if (item.getValue() != null) { [EOL]         double y = yN.doubleValue(); [EOL]         this.minY = minIgnoreNaN(this.minY, y); [EOL]         this.maxY = maxIgnoreNaN(this.maxY, y); [EOL]     } [EOL] } <line_num>: 1212,1219
private void updateBoundsForRemovedItem(TimeSeriesDataItem item) { [EOL]     Number yN = item.getValue(); [EOL]     if (yN != null) { [EOL]         double y = yN.doubleValue(); [EOL]         if (!Double.isNaN(y)) { [EOL]             if (y <= this.minY || y >= this.maxY) { [EOL]                 findBoundsByIteration(); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 1229,1239
private void findBoundsByIteration() { [EOL]     this.minY = Double.NaN; [EOL]     this.maxY = Double.NaN; [EOL]     Iterator iterator = this.data.iterator(); [EOL]     while (iterator.hasNext()) { [EOL]         TimeSeriesDataItem item = (TimeSeriesDataItem) iterator.next(); [EOL]         updateBoundsForAddedItem(item); [EOL]     } [EOL] } <line_num>: 1247,1255
private double minIgnoreNaN(double a, double b) { [EOL]     if (Double.isNaN(a)) { [EOL]         return b; [EOL]     } else { [EOL]         if (Double.isNaN(b)) { [EOL]             return a; [EOL]         } else { [EOL]             return Math.min(a, b); [EOL]         } [EOL]     } [EOL] } <line_num>: 1266,1278
private double maxIgnoreNaN(double a, double b) { [EOL]     if (Double.isNaN(a)) { [EOL]         return b; [EOL]     } else { [EOL]         if (Double.isNaN(b)) { [EOL]             return a; [EOL]         } else { [EOL]             return Math.max(a, b); [EOL]         } [EOL]     } [EOL] } <line_num>: 1289,1301