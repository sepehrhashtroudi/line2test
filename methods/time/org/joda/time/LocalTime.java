public LocalTime() { [EOL]     this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance()); [EOL] } <line_num>: 287,289
public LocalTime(DateTimeZone zone) { [EOL]     this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance(zone)); [EOL] } <line_num>: 301,303
public LocalTime(Chronology chronology) { [EOL]     this(DateTimeUtils.currentTimeMillis(), chronology); [EOL] } <line_num>: 315,317
public LocalTime(long instant) { [EOL]     this(instant, ISOChronology.getInstance()); [EOL] } <line_num>: 328,330
public LocalTime(long instant, DateTimeZone zone) { [EOL]     this(instant, ISOChronology.getInstance(zone)); [EOL] } <line_num>: 342,344
public LocalTime(long instant, Chronology chronology) { [EOL]     chronology = DateTimeUtils.getChronology(chronology); [EOL]     long localMillis = chronology.getZone().getMillisKeepLocal(DateTimeZone.UTC, instant); [EOL]     chronology = chronology.withUTC(); [EOL]     iLocalMillis = chronology.millisOfDay().get(localMillis); [EOL]     iChronology = chronology; [EOL] } <line_num>: 356,363
public LocalTime(Object instant) { [EOL]     this(instant, (Chronology) null); [EOL] } <line_num>: 382,384
public LocalTime(Object instant, DateTimeZone zone) { [EOL]     PartialConverter converter = ConverterManager.getInstance().getPartialConverter(instant); [EOL]     Chronology chronology = converter.getChronology(instant, zone); [EOL]     chronology = DateTimeUtils.getChronology(chronology); [EOL]     iChronology = chronology.withUTC(); [EOL]     int[] values = converter.getPartialValues(this, instant, chronology, ISODateTimeFormat.localTimeParser()); [EOL]     iLocalMillis = iChronology.getDateTimeMillis(0L, values[0], values[1], values[2], values[3]); [EOL] } <line_num>: 404,411
public LocalTime(Object instant, Chronology chronology) { [EOL]     PartialConverter converter = ConverterManager.getInstance().getPartialConverter(instant); [EOL]     chronology = converter.getChronology(instant, chronology); [EOL]     chronology = DateTimeUtils.getChronology(chronology); [EOL]     iChronology = chronology.withUTC(); [EOL]     int[] values = converter.getPartialValues(this, instant, chronology, ISODateTimeFormat.localTimeParser()); [EOL]     iLocalMillis = iChronology.getDateTimeMillis(0L, values[0], values[1], values[2], values[3]); [EOL] } <line_num>: 430,437
public LocalTime(int hourOfDay, int minuteOfHour) { [EOL]     this(hourOfDay, minuteOfHour, 0, 0, ISOChronology.getInstanceUTC()); [EOL] } <line_num>: 447,451
public LocalTime(int hourOfDay, int minuteOfHour, int secondOfMinute) { [EOL]     this(hourOfDay, minuteOfHour, secondOfMinute, 0, ISOChronology.getInstanceUTC()); [EOL] } <line_num>: 461,466
public LocalTime(int hourOfDay, int minuteOfHour, int secondOfMinute, int millisOfSecond) { [EOL]     this(hourOfDay, minuteOfHour, secondOfMinute, millisOfSecond, ISOChronology.getInstanceUTC()); [EOL] } <line_num>: 477,484
public LocalTime(int hourOfDay, int minuteOfHour, int secondOfMinute, int millisOfSecond, Chronology chronology) { [EOL]     super(); [EOL]     chronology = DateTimeUtils.getChronology(chronology).withUTC(); [EOL]     long instant = chronology.getDateTimeMillis(0L, hourOfDay, minuteOfHour, secondOfMinute, millisOfSecond); [EOL]     iChronology = chronology; [EOL]     iLocalMillis = instant; [EOL] } <line_num>: 498,510
Property(LocalTime instant, DateTimeField field) { [EOL]     super(); [EOL]     iInstant = instant; [EOL]     iField = field; [EOL] } <line_num>: 1372,1376
public static LocalTime now() { [EOL]     return new LocalTime(); [EOL] } <line_num>: 117,119
public static LocalTime now(DateTimeZone zone) { [EOL]     if (zone == null) { [EOL]         throw new NullPointerException("Zone must not be null"); [EOL]     } [EOL]     return new LocalTime(zone); [EOL] } <line_num>: 130,135
public static LocalTime now(Chronology chronology) { [EOL]     if (chronology == null) { [EOL]         throw new NullPointerException("Chronology must not be null"); [EOL]     } [EOL]     return new LocalTime(chronology); [EOL] } <line_num>: 146,151
@FromString [EOL] public static LocalTime parse(String str) { [EOL]     return parse(str, ISODateTimeFormat.localTimeParser()); [EOL] } <line_num>: 162,165
public static LocalTime parse(String str, DateTimeFormatter formatter) { [EOL]     return formatter.parseLocalTime(str); [EOL] } <line_num>: 174,176
public static LocalTime fromMillisOfDay(long millisOfDay) { [EOL]     return fromMillisOfDay(millisOfDay, null); [EOL] } <line_num>: 189,191
public static LocalTime fromMillisOfDay(long millisOfDay, Chronology chrono) { [EOL]     chrono = DateTimeUtils.getChronology(chrono).withUTC(); [EOL]     return new LocalTime(millisOfDay, chrono); [EOL] } <line_num>: 204,207
public static LocalTime fromCalendarFields(Calendar calendar) { [EOL]     if (calendar == null) { [EOL]         throw new IllegalArgumentException("The calendar must not be null"); [EOL]     } [EOL]     return new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), calendar.get(Calendar.MILLISECOND)); [EOL] } <line_num>: 233,243
@SuppressWarnings("deprecation") [EOL] public static LocalTime fromDateFields(Date date) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     return new LocalTime(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000); [EOL] } <line_num>: 265,276
private Object readResolve() { [EOL]     if (iChronology == null) { [EOL]         return new LocalTime(iLocalMillis, ISOChronology.getInstanceUTC()); [EOL]     } [EOL]     if (DateTimeZone.UTC.equals(iChronology.getZone()) == false) { [EOL]         return new LocalTime(iLocalMillis, iChronology.withUTC()); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 516,524
public int size() { [EOL]     return 4; [EOL] } <line_num>: 534,536
protected DateTimeField getField(int index, Chronology chrono) { [EOL]     switch(index) { [EOL]         case HOUR_OF_DAY: [EOL]             return chrono.hourOfDay(); [EOL]         case MINUTE_OF_HOUR: [EOL]             return chrono.minuteOfHour(); [EOL]         case SECOND_OF_MINUTE: [EOL]             return chrono.secondOfMinute(); [EOL]         case MILLIS_OF_SECOND: [EOL]             return chrono.millisOfSecond(); [EOL]         default: [EOL]             throw new IndexOutOfBoundsException("Invalid index: " + index); [EOL]     } [EOL] } <line_num>: 547,560
public int getValue(int index) { [EOL]     switch(index) { [EOL]         case HOUR_OF_DAY: [EOL]             return getChronology().hourOfDay().get(getLocalMillis()); [EOL]         case MINUTE_OF_HOUR: [EOL]             return getChronology().minuteOfHour().get(getLocalMillis()); [EOL]         case SECOND_OF_MINUTE: [EOL]             return getChronology().secondOfMinute().get(getLocalMillis()); [EOL]         case MILLIS_OF_SECOND: [EOL]             return getChronology().millisOfSecond().get(getLocalMillis()); [EOL]         default: [EOL]             throw new IndexOutOfBoundsException("Invalid index: " + index); [EOL]     } [EOL] } <line_num>: 573,586
public int get(DateTimeFieldType fieldType) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("The DateTimeFieldType must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     return fieldType.getField(getChronology()).get(getLocalMillis()); [EOL] } <line_num>: 603,611
public boolean isSupported(DateTimeFieldType type) { [EOL]     if (type == null) { [EOL]         return false; [EOL]     } [EOL]     if (isSupported(type.getDurationType()) == false) { [EOL]         return false; [EOL]     } [EOL]     DurationFieldType range = type.getRangeDurationType(); [EOL]     return (isSupported(range) || range == DurationFieldType.days()); [EOL] } <line_num>: 621,630
public boolean isSupported(DurationFieldType type) { [EOL]     if (type == null) { [EOL]         return false; [EOL]     } [EOL]     DurationField field = type.getField(getChronology()); [EOL]     if (TIME_DURATION_TYPES.contains(type) || field.getUnitMillis() < getChronology().days().getUnitMillis()) { [EOL]         return field.isSupported(); [EOL]     } [EOL]     return false; [EOL] } <line_num>: 639,649
protected long getLocalMillis() { [EOL]     return iLocalMillis; [EOL] } <line_num>: 659,661
public Chronology getChronology() { [EOL]     return iChronology; [EOL] } <line_num>: 668,670
public boolean equals(Object partial) { [EOL]     if (this == partial) { [EOL]         return true; [EOL]     } [EOL]     if (partial instanceof LocalTime) { [EOL]         LocalTime other = (LocalTime) partial; [EOL]         if (iChronology.equals(other.iChronology)) { [EOL]             return iLocalMillis == other.iLocalMillis; [EOL]         } [EOL]     } [EOL]     return super.equals(partial); [EOL] } <line_num>: 680,692
public int compareTo(ReadablePartial partial) { [EOL]     if (this == partial) { [EOL]         return 0; [EOL]     } [EOL]     if (partial instanceof LocalTime) { [EOL]         LocalTime other = (LocalTime) partial; [EOL]         if (iChronology.equals(other.iChronology)) { [EOL]             return (iLocalMillis < other.iLocalMillis ? -1 : (iLocalMillis == other.iLocalMillis ? 0 : 1)); [EOL]         } [EOL]     } [EOL]     return super.compareTo(partial); [EOL] } <line_num>: 710,724
LocalTime withLocalMillis(long newMillis) { [EOL]     return (newMillis == getLocalMillis() ? this : new LocalTime(newMillis, getChronology())); [EOL] } <line_num>: 737,739
public LocalTime withFields(ReadablePartial partial) { [EOL]     if (partial == null) { [EOL]         return this; [EOL]     } [EOL]     return withLocalMillis(getChronology().set(partial, getLocalMillis())); [EOL] } <line_num>: 755,760
public LocalTime withField(DateTimeFieldType fieldType, int value) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("Field must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     long instant = fieldType.getField(getChronology()).set(getLocalMillis(), value); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 781,790
public LocalTime withFieldAdded(DurationFieldType fieldType, int amount) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("Field must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     if (amount == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = fieldType.getField(getChronology()).add(getLocalMillis(), amount); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 814,826
public LocalTime withPeriodAdded(ReadablePeriod period, int scalar) { [EOL]     if (period == null || scalar == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().add(period, getLocalMillis(), scalar); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 844,850
public LocalTime plus(ReadablePeriod period) { [EOL]     return withPeriodAdded(period, 1); [EOL] } <line_num>: 866,868
public LocalTime plusHours(int hours) { [EOL]     if (hours == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().hours().add(getLocalMillis(), hours); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 886,892
public LocalTime plusMinutes(int minutes) { [EOL]     if (minutes == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().minutes().add(getLocalMillis(), minutes); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 909,915
public LocalTime plusSeconds(int seconds) { [EOL]     if (seconds == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().seconds().add(getLocalMillis(), seconds); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 932,938
public LocalTime plusMillis(int millis) { [EOL]     if (millis == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().millis().add(getLocalMillis(), millis); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 955,961
public LocalTime minus(ReadablePeriod period) { [EOL]     return withPeriodAdded(period, -1); [EOL] } <line_num>: 977,979
public LocalTime minusHours(int hours) { [EOL]     if (hours == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().hours().subtract(getLocalMillis(), hours); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 997,1003
public LocalTime minusMinutes(int minutes) { [EOL]     if (minutes == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().minutes().subtract(getLocalMillis(), minutes); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1020,1026
public LocalTime minusSeconds(int seconds) { [EOL]     if (seconds == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().seconds().subtract(getLocalMillis(), seconds); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1043,1049
public LocalTime minusMillis(int millis) { [EOL]     if (millis == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().millis().subtract(getLocalMillis(), millis); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1066,1072
public Property property(DateTimeFieldType fieldType) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("The DateTimeFieldType must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     return new Property(this, fieldType.getField(getChronology())); [EOL] } <line_num>: 1083,1091
public int getHourOfDay() { [EOL]     return getChronology().hourOfDay().get(getLocalMillis()); [EOL] } <line_num>: 1099,1101
public int getMinuteOfHour() { [EOL]     return getChronology().minuteOfHour().get(getLocalMillis()); [EOL] } <line_num>: 1108,1110
public int getSecondOfMinute() { [EOL]     return getChronology().secondOfMinute().get(getLocalMillis()); [EOL] } <line_num>: 1117,1119
public int getMillisOfSecond() { [EOL]     return getChronology().millisOfSecond().get(getLocalMillis()); [EOL] } <line_num>: 1126,1128
public int getMillisOfDay() { [EOL]     return getChronology().millisOfDay().get(getLocalMillis()); [EOL] } <line_num>: 1135,1137
public LocalTime withHourOfDay(int hour) { [EOL]     return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), hour)); [EOL] } <line_num>: 1151,1153
public LocalTime withMinuteOfHour(int minute) { [EOL]     return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), minute)); [EOL] } <line_num>: 1166,1168
public LocalTime withSecondOfMinute(int second) { [EOL]     return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), second)); [EOL] } <line_num>: 1181,1183
public LocalTime withMillisOfSecond(int millis) { [EOL]     return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), millis)); [EOL] } <line_num>: 1196,1198
public LocalTime withMillisOfDay(int millis) { [EOL]     return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), millis)); [EOL] } <line_num>: 1211,1213
public Property hourOfDay() { [EOL]     return new Property(this, getChronology().hourOfDay()); [EOL] } <line_num>: 1221,1223
public Property minuteOfHour() { [EOL]     return new Property(this, getChronology().minuteOfHour()); [EOL] } <line_num>: 1230,1232
public Property secondOfMinute() { [EOL]     return new Property(this, getChronology().secondOfMinute()); [EOL] } <line_num>: 1239,1241
public Property millisOfSecond() { [EOL]     return new Property(this, getChronology().millisOfSecond()); [EOL] } <line_num>: 1248,1250
public Property millisOfDay() { [EOL]     return new Property(this, getChronology().millisOfDay()); [EOL] } <line_num>: 1257,1259
public DateTime toDateTimeToday() { [EOL]     return toDateTimeToday(null); [EOL] } <line_num>: 1269,1271
public DateTime toDateTimeToday(DateTimeZone zone) { [EOL]     Chronology chrono = getChronology().withZone(zone); [EOL]     long instantMillis = DateTimeUtils.currentTimeMillis(); [EOL]     long resolved = chrono.set(this, instantMillis); [EOL]     return new DateTime(resolved, chrono); [EOL] } <line_num>: 1284,1289
@ToString [EOL] public String toString() { [EOL]     return ISODateTimeFormat.time().print(this); [EOL] } <line_num>: 1297,1300
public String toString(String pattern) { [EOL]     if (pattern == null) { [EOL]         return toString(); [EOL]     } [EOL]     return DateTimeFormat.forPattern(pattern).print(this); [EOL] } <line_num>: 1308,1313
public String toString(String pattern, Locale locale) throws IllegalArgumentException { [EOL]     if (pattern == null) { [EOL]         return toString(); [EOL]     } [EOL]     return DateTimeFormat.forPattern(pattern).withLocale(locale).print(this); [EOL] } <line_num>: 1322,1327
private void writeObject(ObjectOutputStream oos) throws IOException { [EOL]     oos.writeObject(iInstant); [EOL]     oos.writeObject(iField.getType()); [EOL] } <line_num>: 1381,1384
private void readObject(ObjectInputStream oos) throws IOException, ClassNotFoundException { [EOL]     iInstant = (LocalTime) oos.readObject(); [EOL]     DateTimeFieldType type = (DateTimeFieldType) oos.readObject(); [EOL]     iField = type.getField(iInstant.getChronology()); [EOL] } <line_num>: 1389,1393
public DateTimeField getField() { [EOL]     return iField; [EOL] } <line_num>: 1401,1403
protected long getMillis() { [EOL]     return iInstant.getLocalMillis(); [EOL] } <line_num>: 1410,1412
protected Chronology getChronology() { [EOL]     return iInstant.getChronology(); [EOL] } <line_num>: 1420,1422
public LocalTime getLocalTime() { [EOL]     return iInstant; [EOL] } <line_num>: 1429,1431
public LocalTime addCopy(int value) { [EOL]     return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), value)); [EOL] } <line_num>: 1442,1444
public LocalTime addCopy(long value) { [EOL]     return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), value)); [EOL] } <line_num>: 1456,1458
public LocalTime addNoWrapToCopy(int value) { [EOL]     long millis = iField.add(iInstant.getLocalMillis(), value); [EOL]     long rounded = iInstant.getChronology().millisOfDay().get(millis); [EOL]     if (rounded != millis) { [EOL]         throw new IllegalArgumentException("The addition exceeded the boundaries of LocalTime"); [EOL]     } [EOL]     return iInstant.withLocalMillis(millis); [EOL] } <line_num>: 1472,1479
public LocalTime addWrapFieldToCopy(int value) { [EOL]     return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), value)); [EOL] } <line_num>: 1492,1494
public LocalTime setCopy(int value) { [EOL]     return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), value)); [EOL] } <line_num>: 1506,1508
public LocalTime setCopy(String text, Locale locale) { [EOL]     return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), text, locale)); [EOL] } <line_num>: 1520,1522
public LocalTime setCopy(String text) { [EOL]     return setCopy(text, null); [EOL] } <line_num>: 1533,1535
public LocalTime withMaximumValue() { [EOL]     return setCopy(getMaximumValue()); [EOL] } <line_num>: 1546,1548
public LocalTime withMinimumValue() { [EOL]     return setCopy(getMinimumValue()); [EOL] } <line_num>: 1558,1560
public LocalTime roundFloorCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis())); [EOL] } <line_num>: 1573,1575
public LocalTime roundCeilingCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis())); [EOL] } <line_num>: 1587,1589
public LocalTime roundHalfFloorCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis())); [EOL] } <line_num>: 1597,1599
public LocalTime roundHalfCeilingCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis())); [EOL] } <line_num>: 1607,1609
public LocalTime roundHalfEvenCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis())); [EOL] } <line_num>: 1618,1620
