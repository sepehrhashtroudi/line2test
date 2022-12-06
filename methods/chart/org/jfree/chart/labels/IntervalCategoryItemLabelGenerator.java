public IntervalCategoryItemLabelGenerator() { [EOL]     super(DEFAULT_LABEL_FORMAT_STRING, NumberFormat.getInstance()); [EOL] } <line_num>: 71,73
public IntervalCategoryItemLabelGenerator(String labelFormat, NumberFormat formatter) { [EOL]     super(labelFormat, formatter); [EOL] } <line_num>: 82,85
public IntervalCategoryItemLabelGenerator(String labelFormat, DateFormat formatter) { [EOL]     super(labelFormat, formatter); [EOL] } <line_num>: 94,97
protected Object[] createItemArray(CategoryDataset dataset, int row, int column) { [EOL]     Object[] result = new Object[5]; [EOL]     result[0] = dataset.getRowKey(row).toString(); [EOL]     result[1] = dataset.getColumnKey(column).toString(); [EOL]     Number value = dataset.getValue(row, column); [EOL]     if (getNumberFormat() != null) { [EOL]         result[2] = getNumberFormat().format(value); [EOL]     } else if (getDateFormat() != null) { [EOL]         result[2] = getDateFormat().format(value); [EOL]     } [EOL]     if (dataset instanceof IntervalCategoryDataset) { [EOL]         IntervalCategoryDataset icd = (IntervalCategoryDataset) dataset; [EOL]         Number start = icd.getStartValue(row, column); [EOL]         Number end = icd.getEndValue(row, column); [EOL]         if (getNumberFormat() != null) { [EOL]             result[3] = getNumberFormat().format(start); [EOL]             result[4] = getNumberFormat().format(end); [EOL]         } else if (getDateFormat() != null) { [EOL]             result[3] = getDateFormat().format(start); [EOL]             result[4] = getDateFormat().format(end); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 109,136