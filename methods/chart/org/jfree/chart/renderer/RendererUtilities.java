public static int findLiveItemsLowerBound(XYDataset dataset, int series, double xLow, double xHigh) { [EOL]     if (dataset == null) { [EOL]         throw new IllegalArgumentException("Null 'dataset' argument."); [EOL]     } [EOL]     if (xLow >= xHigh) { [EOL]         throw new IllegalArgumentException("Requires xLow < xHigh."); [EOL]     } [EOL]     int itemCount = dataset.getItemCount(series); [EOL]     if (itemCount <= 1) { [EOL]         return 0; [EOL]     } [EOL]     if (dataset.getDomainOrder() == DomainOrder.ASCENDING) { [EOL]         int low = 0; [EOL]         int high = itemCount - 1; [EOL]         double lowValue = dataset.getXValue(series, low); [EOL]         if (lowValue >= xLow) { [EOL]             return low; [EOL]         } [EOL]         double highValue = dataset.getXValue(series, high); [EOL]         if (highValue < xLow) { [EOL]             return high; [EOL]         } [EOL]         while (high - low > 1) { [EOL]             int mid = (low + high) / 2; [EOL]             double midV = dataset.getXValue(series, mid); [EOL]             if (midV >= xLow) { [EOL]                 high = mid; [EOL]             } else { [EOL]                 low = mid; [EOL]             } [EOL]         } [EOL]         return high; [EOL]     } else if (dataset.getDomainOrder() == DomainOrder.DESCENDING) { [EOL]         int low = 0; [EOL]         int high = itemCount - 1; [EOL]         double lowValue = dataset.getXValue(series, low); [EOL]         if (lowValue <= xHigh) { [EOL]             return low; [EOL]         } [EOL]         double highValue = dataset.getXValue(series, high); [EOL]         if (highValue > xHigh) { [EOL]             return high; [EOL]         } [EOL]         while (high - low > 1) { [EOL]             int mid = (low + high) / 2; [EOL]             double midV = dataset.getXValue(series, mid); [EOL]             if (midV > xHigh) { [EOL]                 low = mid; [EOL]             } else { [EOL]                 high = mid; [EOL]             } [EOL]             mid = (low + high) / 2; [EOL]         } [EOL]         return high; [EOL]     } else { [EOL]         int index = 0; [EOL]         double x = dataset.getXValue(series, index); [EOL]         while (index < itemCount && (x < xLow || x > xHigh)) { [EOL]             index++; [EOL]             if (index < itemCount) { [EOL]                 x = dataset.getXValue(series, index); [EOL]             } [EOL]         } [EOL]         return Math.min(Math.max(0, index), itemCount - 1); [EOL]     } [EOL] } <line_num>: 69,149
public static int findLiveItemsUpperBound(XYDataset dataset, int series, double xLow, double xHigh) { [EOL]     if (dataset == null) { [EOL]         throw new IllegalArgumentException("Null 'dataset' argument."); [EOL]     } [EOL]     if (xLow >= xHigh) { [EOL]         throw new IllegalArgumentException("Requires xLow < xHigh."); [EOL]     } [EOL]     int itemCount = dataset.getItemCount(series); [EOL]     if (itemCount <= 1) { [EOL]         return 0; [EOL]     } [EOL]     if (dataset.getDomainOrder() == DomainOrder.ASCENDING) { [EOL]         int low = 0; [EOL]         int high = itemCount - 1; [EOL]         double lowValue = dataset.getXValue(series, low); [EOL]         if (lowValue > xHigh) { [EOL]             return low; [EOL]         } [EOL]         double highValue = dataset.getXValue(series, high); [EOL]         if (highValue <= xHigh) { [EOL]             return high; [EOL]         } [EOL]         int mid = (low + high) / 2; [EOL]         while (high - low > 1) { [EOL]             double midV = dataset.getXValue(series, mid); [EOL]             if (midV <= xHigh) { [EOL]                 low = mid; [EOL]             } else { [EOL]                 high = mid; [EOL]             } [EOL]             mid = (low + high) / 2; [EOL]         } [EOL]         return mid; [EOL]     } else if (dataset.getDomainOrder() == DomainOrder.DESCENDING) { [EOL]         int low = 0; [EOL]         int high = itemCount - 1; [EOL]         int mid = (low + high) / 2; [EOL]         double lowValue = dataset.getXValue(series, low); [EOL]         if (lowValue < xLow) { [EOL]             return low; [EOL]         } [EOL]         double highValue = dataset.getXValue(series, high); [EOL]         if (highValue >= xLow) { [EOL]             return high; [EOL]         } [EOL]         while (high - low > 1) { [EOL]             double midV = dataset.getXValue(series, mid); [EOL]             if (midV >= xLow) { [EOL]                 low = mid; [EOL]             } else { [EOL]                 high = mid; [EOL]             } [EOL]             mid = (low + high) / 2; [EOL]         } [EOL]         return mid; [EOL]     } else { [EOL]         int index = itemCount - 1; [EOL]         double x = dataset.getXValue(series, index); [EOL]         while (index >= 0 && (x < xLow || x > xHigh)) { [EOL]             index--; [EOL]             if (index >= 0) { [EOL]                 x = dataset.getXValue(series, index); [EOL]             } [EOL]         } [EOL]         return Math.max(index, 0); [EOL]     } [EOL] } <line_num>: 166,243
public static int[] findLiveItems(XYDataset dataset, int series, double xLow, double xHigh) { [EOL]     int i0 = findLiveItemsLowerBound(dataset, series, xLow, xHigh); [EOL]     int i1 = findLiveItemsUpperBound(dataset, series, xLow, xHigh); [EOL]     if (i0 > i1) { [EOL]         i0 = i1; [EOL]     } [EOL]     return new int[] { i0, i1 }; [EOL] } <line_num>: 256,267
