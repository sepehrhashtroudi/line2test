public DateTimeParserBucket(long instantLocal, Chronology chrono, Locale locale)
public DateTimeParserBucket(long instantLocal, Chronology chrono, Locale locale, Integer pivotYear)
public DateTimeParserBucket(long instantLocal, Chronology chrono, Locale locale, Integer pivotYear, int defaultYear)
 SavedState()
 SavedField(DateTimeField field, int value)
 SavedField(DateTimeField field, String text, Locale locale)
public Chronology getChronology()
public Locale getLocale()
public DateTimeZone getZone()
public void setZone(DateTimeZone zone)
public int getOffset()
public Integer getOffsetInteger()
public void setOffset(int offset)
public void setOffset(Integer offset)
public Integer getPivotYear()
public void setPivotYear(Integer pivotYear)
public void saveField(DateTimeField field, int value)
public void saveField(DateTimeFieldType fieldType, int value)
public void saveField(DateTimeFieldType fieldType, String text, Locale locale)
private void saveField(SavedField field)
public Object saveState()
public boolean restoreState(Object savedState)
public long computeMillis()
public long computeMillis(boolean resetFields)
public long computeMillis(boolean resetFields, String text)
private static void sort(SavedField[] array, int high)
 boolean restoreState(DateTimeParserBucket enclosing)
 long set(long millis, boolean reset)
public int compareTo(SavedField obj)
 static int compareReverse(DurationField a, DurationField b)
Chronology iChrono
long iMillis
DateTimeZone iZone
Integer iOffset
Locale iLocale
Integer iPivotYear
int iDefaultYear
SavedField[] iSavedFields=Optional[new SavedField[8]]
int iSavedFieldsCount
boolean iSavedFieldsShared
Object iSavedState
