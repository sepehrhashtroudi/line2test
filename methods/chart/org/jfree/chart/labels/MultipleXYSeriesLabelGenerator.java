public MultipleXYSeriesLabelGenerator() { [EOL]     this(DEFAULT_LABEL_FORMAT); [EOL] } <line_num>: 84,86
public MultipleXYSeriesLabelGenerator(String format) { [EOL]     if (format == null) { [EOL]         throw new IllegalArgumentException("Null 'format' argument."); [EOL]     } [EOL]     this.formatPattern = format; [EOL]     this.additionalFormatPattern = "\n{0}"; [EOL]     this.seriesLabelLists = new HashMap(); [EOL] } <line_num>: 93,100
public void addSeriesLabel(int series, String label) { [EOL]     Integer key = new Integer(series); [EOL]     List labelList = (List) this.seriesLabelLists.get(key); [EOL]     if (labelList == null) { [EOL]         labelList = new java.util.ArrayList(); [EOL]         this.seriesLabelLists.put(key, labelList); [EOL]     } [EOL]     labelList.add(label); [EOL] } <line_num>: 108,116
public void clearSeriesLabels(int series) { [EOL]     Integer key = new Integer(series); [EOL]     this.seriesLabelLists.put(key, null); [EOL] } <line_num>: 123,126
public String generateLabel(XYDataset dataset, int series) { [EOL]     if (dataset == null) { [EOL]         throw new IllegalArgumentException("Null 'dataset' argument."); [EOL]     } [EOL]     StringBuffer label = new StringBuffer(); [EOL]     label.append(MessageFormat.format(this.formatPattern, createItemArray(dataset, series))); [EOL]     Integer key = new Integer(series); [EOL]     List extraLabels = (List) this.seriesLabelLists.get(key); [EOL]     if (extraLabels != null) { [EOL]         Object[] temp = new Object[1]; [EOL]         for (int i = 0; i < extraLabels.size(); i++) { [EOL]             temp[0] = extraLabels.get(i); [EOL]             String labelAddition = MessageFormat.format(this.additionalFormatPattern, temp); [EOL]             label.append(labelAddition); [EOL]         } [EOL]     } [EOL]     return label.toString(); [EOL] } <line_num>: 137,156
protected Object[] createItemArray(XYDataset dataset, int series) { [EOL]     Object[] result = new Object[1]; [EOL]     result[0] = dataset.getSeriesKey(series).toString(); [EOL]     return result; [EOL] } <line_num>: 167,171
public Object clone() throws CloneNotSupportedException { [EOL]     MultipleXYSeriesLabelGenerator clone = (MultipleXYSeriesLabelGenerator) super.clone(); [EOL]     clone.seriesLabelLists = new HashMap(); [EOL]     Set keys = this.seriesLabelLists.keySet(); [EOL]     Iterator iterator = keys.iterator(); [EOL]     while (iterator.hasNext()) { [EOL]         Object key = iterator.next(); [EOL]         Object entry = this.seriesLabelLists.get(key); [EOL]         Object toAdd = entry; [EOL]         if (entry instanceof PublicCloneable) { [EOL]             PublicCloneable pc = (PublicCloneable) entry; [EOL]             toAdd = pc.clone(); [EOL]         } [EOL]         clone.seriesLabelLists.put(key, toAdd); [EOL]     } [EOL]     return clone; [EOL] } <line_num>: 180,197
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof MultipleXYSeriesLabelGenerator)) { [EOL]         return false; [EOL]     } [EOL]     MultipleXYSeriesLabelGenerator that = (MultipleXYSeriesLabelGenerator) obj; [EOL]     if (!this.formatPattern.equals(that.formatPattern)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.additionalFormatPattern.equals(that.additionalFormatPattern)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.seriesLabelLists.equals(that.seriesLabelLists)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 206,226
public int hashCode() { [EOL]     int result = 127; [EOL]     result = HashUtilities.hashCode(result, this.formatPattern); [EOL]     result = HashUtilities.hashCode(result, this.additionalFormatPattern); [EOL]     result = HashUtilities.hashCode(result, this.seriesLabelLists); [EOL]     return result; [EOL] } <line_num>: 233,239
