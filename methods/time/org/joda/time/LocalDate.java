public LocalDate() { [EOL]     this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance()); [EOL] } <line_num>: 266,268
public LocalDate(DateTimeZone zone) { [EOL]     this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance(zone)); [EOL] } <line_num>: 280,282
public LocalDate(Chronology chronology) { [EOL]     this(DateTimeUtils.currentTimeMillis(), chronology); [EOL] } <line_num>: 294,296
public LocalDate(long instant) { [EOL]     this(instant, ISOChronology.getInstance()); [EOL] } <line_num>: 307,309
public LocalDate(long instant, DateTimeZone zone) { [EOL]     this(instant, ISOChronology.getInstance(zone)); [EOL] } <line_num>: 321,323
public LocalDate(long instant, Chronology chronology) { [EOL]     chronology = DateTimeUtils.getChronology(chronology); [EOL]     long localMillis = chronology.getZone().getMillisKeepLocal(DateTimeZone.UTC, instant); [EOL]     chronology = chronology.withUTC(); [EOL]     iLocalMillis = chronology.dayOfMonth().roundFloor(localMillis); [EOL]     iChronology = chronology; [EOL] } <line_num>: 335,342
public LocalDate(Object instant) { [EOL]     this(instant, (Chronology) null); [EOL] } <line_num>: 362,364
public LocalDate(Object instant, DateTimeZone zone) { [EOL]     PartialConverter converter = ConverterManager.getInstance().getPartialConverter(instant); [EOL]     Chronology chronology = converter.getChronology(instant, zone); [EOL]     chronology = DateTimeUtils.getChronology(chronology); [EOL]     iChronology = chronology.withUTC(); [EOL]     int[] values = converter.getPartialValues(this, instant, chronology, ISODateTimeFormat.localDateParser()); [EOL]     iLocalMillis = iChronology.getDateTimeMillis(values[0], values[1], values[2], 0); [EOL] } <line_num>: 384,391
public LocalDate(Object instant, Chronology chronology) { [EOL]     PartialConverter converter = ConverterManager.getInstance().getPartialConverter(instant); [EOL]     chronology = converter.getChronology(instant, chronology); [EOL]     chronology = DateTimeUtils.getChronology(chronology); [EOL]     iChronology = chronology.withUTC(); [EOL]     int[] values = converter.getPartialValues(this, instant, chronology, ISODateTimeFormat.localDateParser()); [EOL]     iLocalMillis = iChronology.getDateTimeMillis(values[0], values[1], values[2], 0); [EOL] } <line_num>: 414,421
public LocalDate(int year, int monthOfYear, int dayOfMonth) { [EOL]     this(year, monthOfYear, dayOfMonth, ISOChronology.getInstanceUTC()); [EOL] } <line_num>: 432,437
public LocalDate(int year, int monthOfYear, int dayOfMonth, Chronology chronology) { [EOL]     super(); [EOL]     chronology = DateTimeUtils.getChronology(chronology).withUTC(); [EOL]     long instant = chronology.getDateTimeMillis(year, monthOfYear, dayOfMonth, 0); [EOL]     iChronology = chronology; [EOL]     iLocalMillis = instant; [EOL] } <line_num>: 450,460
Property(LocalDate instant, DateTimeField field) { [EOL]     super(); [EOL]     iInstant = instant; [EOL]     iField = field; [EOL] } <line_num>: 1893,1897
public static LocalDate now() { [EOL]     return new LocalDate(); [EOL] } <line_num>: 123,125
public static LocalDate now(DateTimeZone zone) { [EOL]     if (zone == null) { [EOL]         throw new NullPointerException("Zone must not be null"); [EOL]     } [EOL]     return new LocalDate(zone); [EOL] } <line_num>: 135,140
public static LocalDate now(Chronology chronology) { [EOL]     if (chronology == null) { [EOL]         throw new NullPointerException("Chronology must not be null"); [EOL]     } [EOL]     return new LocalDate(chronology); [EOL] } <line_num>: 150,155
@FromString [EOL] public static LocalDate parse(String str) { [EOL]     return parse(str, ISODateTimeFormat.localDateParser()); [EOL] } <line_num>: 166,169
public static LocalDate parse(String str, DateTimeFormatter formatter) { [EOL]     return formatter.parseLocalDate(str); [EOL] } <line_num>: 178,180
public static LocalDate fromCalendarFields(Calendar calendar) { [EOL]     if (calendar == null) { [EOL]         throw new IllegalArgumentException("The calendar must not be null"); [EOL]     } [EOL]     int era = calendar.get(Calendar.ERA); [EOL]     int yearOfEra = calendar.get(Calendar.YEAR); [EOL]     return new LocalDate((era == GregorianCalendar.AD ? yearOfEra : 1 - yearOfEra), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)); [EOL] } <line_num>: 206,217
@SuppressWarnings("deprecation") [EOL] public static LocalDate fromDateFields(Date date) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     if (date.getTime() < 0) { [EOL]         GregorianCalendar cal = new GregorianCalendar(); [EOL]         cal.setTime(date); [EOL]         return fromCalendarFields(cal); [EOL]     } [EOL]     return new LocalDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate()); [EOL] } <line_num>: 239,255
private Object readResolve() { [EOL]     if (iChronology == null) { [EOL]         return new LocalDate(iLocalMillis, ISOChronology.getInstanceUTC()); [EOL]     } [EOL]     if (DateTimeZone.UTC.equals(iChronology.getZone()) == false) { [EOL]         return new LocalDate(iLocalMillis, iChronology.withUTC()); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 466,474
public int size() { [EOL]     return 3; [EOL] } <line_num>: 485,487
protected DateTimeField getField(int index, Chronology chrono) { [EOL]     switch(index) { [EOL]         case YEAR: [EOL]             return chrono.year(); [EOL]         case MONTH_OF_YEAR: [EOL]             return chrono.monthOfYear(); [EOL]         case DAY_OF_MONTH: [EOL]             return chrono.dayOfMonth(); [EOL]         default: [EOL]             throw new IndexOutOfBoundsException("Invalid index: " + index); [EOL]     } [EOL] } <line_num>: 498,509
public int getValue(int index) { [EOL]     switch(index) { [EOL]         case YEAR: [EOL]             return getChronology().year().get(getLocalMillis()); [EOL]         case MONTH_OF_YEAR: [EOL]             return getChronology().monthOfYear().get(getLocalMillis()); [EOL]         case DAY_OF_MONTH: [EOL]             return getChronology().dayOfMonth().get(getLocalMillis()); [EOL]         default: [EOL]             throw new IndexOutOfBoundsException("Invalid index: " + index); [EOL]     } [EOL] } <line_num>: 523,534
public int get(DateTimeFieldType fieldType) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("The DateTimeFieldType must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     return fieldType.getField(getChronology()).get(getLocalMillis()); [EOL] } <line_num>: 551,559
public boolean isSupported(DateTimeFieldType type) { [EOL]     if (type == null) { [EOL]         return false; [EOL]     } [EOL]     DurationFieldType durType = type.getDurationType(); [EOL]     if (DATE_DURATION_TYPES.contains(durType) || durType.getField(getChronology()).getUnitMillis() >= getChronology().days().getUnitMillis()) { [EOL]         return type.getField(getChronology()).isSupported(); [EOL]     } [EOL]     return false; [EOL] } <line_num>: 569,580
public boolean isSupported(DurationFieldType type) { [EOL]     if (type == null) { [EOL]         return false; [EOL]     } [EOL]     DurationField field = type.getField(getChronology()); [EOL]     if (DATE_DURATION_TYPES.contains(type) || field.getUnitMillis() >= getChronology().days().getUnitMillis()) { [EOL]         return field.isSupported(); [EOL]     } [EOL]     return false; [EOL] } <line_num>: 589,599
protected long getLocalMillis() { [EOL]     return iLocalMillis; [EOL] } <line_num>: 609,611
public Chronology getChronology() { [EOL]     return iChronology; [EOL] } <line_num>: 618,620
public boolean equals(Object partial) { [EOL]     if (this == partial) { [EOL]         return true; [EOL]     } [EOL]     if (partial instanceof LocalDate) { [EOL]         LocalDate other = (LocalDate) partial; [EOL]         if (iChronology.equals(other.iChronology)) { [EOL]             return iLocalMillis == other.iLocalMillis; [EOL]         } [EOL]     } [EOL]     return super.equals(partial); [EOL] } <line_num>: 630,642
public int hashCode() { [EOL]     int hash = iHash; [EOL]     if (hash == 0) { [EOL]         hash = iHash = super.hashCode(); [EOL]     } [EOL]     return hash; [EOL] } <line_num>: 649,656
public int compareTo(ReadablePartial partial) { [EOL]     if (this == partial) { [EOL]         return 0; [EOL]     } [EOL]     if (partial instanceof LocalDate) { [EOL]         LocalDate other = (LocalDate) partial; [EOL]         if (iChronology.equals(other.iChronology)) { [EOL]             return (iLocalMillis < other.iLocalMillis ? -1 : (iLocalMillis == other.iLocalMillis ? 0 : 1)); [EOL]         } [EOL]     } [EOL]     return super.compareTo(partial); [EOL] } <line_num>: 674,688
public DateTime toDateTimeAtStartOfDay() { [EOL]     return toDateTimeAtStartOfDay(null); [EOL] } <line_num>: 705,707
public DateTime toDateTimeAtStartOfDay(DateTimeZone zone) { [EOL]     zone = DateTimeUtils.getZone(zone); [EOL]     Chronology chrono = getChronology().withZone(zone); [EOL]     long localMillis = getLocalMillis() + 6L * DateTimeConstants.MILLIS_PER_HOUR; [EOL]     long instant = zone.convertLocalToUTC(localMillis, false); [EOL]     instant = chrono.dayOfMonth().roundFloor(instant); [EOL]     return new DateTime(instant, chrono); [EOL] } <line_num>: 727,734
@Deprecated [EOL] public DateTime toDateTimeAtMidnight() { [EOL]     return toDateTimeAtMidnight(null); [EOL] } <line_num>: 751,754
@Deprecated [EOL] public DateTime toDateTimeAtMidnight(DateTimeZone zone) { [EOL]     zone = DateTimeUtils.getZone(zone); [EOL]     Chronology chrono = getChronology().withZone(zone); [EOL]     return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, chrono); [EOL] } <line_num>: 774,779
public DateTime toDateTimeAtCurrentTime() { [EOL]     return toDateTimeAtCurrentTime(null); [EOL] } <line_num>: 794,796
public DateTime toDateTimeAtCurrentTime(DateTimeZone zone) { [EOL]     zone = DateTimeUtils.getZone(zone); [EOL]     Chronology chrono = getChronology().withZone(zone); [EOL]     long instantMillis = DateTimeUtils.currentTimeMillis(); [EOL]     long resolved = chrono.set(this, instantMillis); [EOL]     return new DateTime(resolved, chrono); [EOL] } <line_num>: 814,820
@Deprecated [EOL] public DateMidnight toDateMidnight() { [EOL]     return toDateMidnight(null); [EOL] } <line_num>: 840,843
@Deprecated [EOL] public DateMidnight toDateMidnight(DateTimeZone zone) { [EOL]     zone = DateTimeUtils.getZone(zone); [EOL]     Chronology chrono = getChronology().withZone(zone); [EOL]     return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), chrono); [EOL] } <line_num>: 863,868
public LocalDateTime toLocalDateTime(LocalTime time) { [EOL]     if (time == null) { [EOL]         throw new IllegalArgumentException("The time must not be null"); [EOL]     } [EOL]     if (getChronology() != time.getChronology()) { [EOL]         throw new IllegalArgumentException("The chronology of the time does not match"); [EOL]     } [EOL]     long localMillis = getLocalMillis() + time.getLocalMillis(); [EOL]     return new LocalDateTime(localMillis, getChronology()); [EOL] } <line_num>: 887,896
public DateTime toDateTime(LocalTime time) { [EOL]     return toDateTime(time, null); [EOL] } <line_num>: 916,918
public DateTime toDateTime(LocalTime time, DateTimeZone zone) { [EOL]     if (time != null && getChronology() != time.getChronology()) { [EOL]         throw new IllegalArgumentException("The chronology of the time does not match"); [EOL]     } [EOL]     Chronology chrono = getChronology().withZone(zone); [EOL]     long instant = DateTimeUtils.currentTimeMillis(); [EOL]     instant = chrono.set(this, instant); [EOL]     if (time != null) { [EOL]         instant = chrono.set(time, instant); [EOL]     } [EOL]     return new DateTime(instant, chrono); [EOL] } <line_num>: 938,949
public Interval toInterval() { [EOL]     return toInterval(null); [EOL] } <line_num>: 963,965
public Interval toInterval(DateTimeZone zone) { [EOL]     zone = DateTimeUtils.getZone(zone); [EOL]     DateTime start = toDateTimeAtStartOfDay(zone); [EOL]     DateTime end = plusDays(1).toDateTimeAtStartOfDay(zone); [EOL]     return new Interval(start, end); [EOL] } <line_num>: 978,983
@SuppressWarnings("deprecation") [EOL] public Date toDate() { [EOL]     int dom = getDayOfMonth(); [EOL]     Date date = new Date(getYear() - 1900, getMonthOfYear() - 1, dom); [EOL]     LocalDate check = LocalDate.fromDateFields(date); [EOL]     if (check.isBefore(this)) { [EOL]         while (check.equals(this) == false) { [EOL]             date.setTime(date.getTime() + 3600000); [EOL]             check = LocalDate.fromDateFields(date); [EOL]         } [EOL]         while (date.getDate() == dom) { [EOL]             date.setTime(date.getTime() - 1000); [EOL]         } [EOL]         date.setTime(date.getTime() + 1000); [EOL]     } else if (check.equals(this)) { [EOL]         Date earlier = new Date(date.getTime() - TimeZone.getDefault().getDSTSavings()); [EOL]         if (earlier.getDate() == dom) { [EOL]             date = earlier; [EOL]         } [EOL]     } [EOL]     return date; [EOL] } <line_num>: 1001,1027
LocalDate withLocalMillis(long newMillis) { [EOL]     newMillis = iChronology.dayOfMonth().roundFloor(newMillis); [EOL]     return (newMillis == getLocalMillis() ? this : new LocalDate(newMillis, getChronology())); [EOL] } <line_num>: 1040,1043
public LocalDate withFields(ReadablePartial partial) { [EOL]     if (partial == null) { [EOL]         return this; [EOL]     } [EOL]     return withLocalMillis(getChronology().set(partial, getLocalMillis())); [EOL] } <line_num>: 1059,1064
public LocalDate withField(DateTimeFieldType fieldType, int value) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("Field must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     long instant = fieldType.getField(getChronology()).set(getLocalMillis(), value); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1084,1093
public LocalDate withFieldAdded(DurationFieldType fieldType, int amount) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("Field must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     if (amount == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = fieldType.getField(getChronology()).add(getLocalMillis(), amount); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1113,1125
public LocalDate withPeriodAdded(ReadablePeriod period, int scalar) { [EOL]     if (period == null || scalar == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getLocalMillis(); [EOL]     Chronology chrono = getChronology(); [EOL]     for (int i = 0; i < period.size(); i++) { [EOL]         long value = FieldUtils.safeMultiply(period.getValue(i), scalar); [EOL]         DurationFieldType type = period.getFieldType(i); [EOL]         if (isSupported(type)) { [EOL]             instant = type.getField(chrono).add(instant, value); [EOL]         } [EOL]     } [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1146,1160
public LocalDate plus(ReadablePeriod period) { [EOL]     return withPeriodAdded(period, 1); [EOL] } <line_num>: 1179,1181
public LocalDate plusYears(int years) { [EOL]     if (years == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().years().add(getLocalMillis(), years); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1201,1207
public LocalDate plusMonths(int months) { [EOL]     if (months == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().months().add(getLocalMillis(), months); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1227,1233
public LocalDate plusWeeks(int weeks) { [EOL]     if (weeks == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().weeks().add(getLocalMillis(), weeks); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1250,1256
public LocalDate plusDays(int days) { [EOL]     if (days == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().days().add(getLocalMillis(), days); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1273,1279
public LocalDate minus(ReadablePeriod period) { [EOL]     return withPeriodAdded(period, -1); [EOL] } <line_num>: 1298,1300
public LocalDate minusYears(int years) { [EOL]     if (years == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().years().subtract(getLocalMillis(), years); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1320,1326
public LocalDate minusMonths(int months) { [EOL]     if (months == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().months().subtract(getLocalMillis(), months); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1346,1352
public LocalDate minusWeeks(int weeks) { [EOL]     if (weeks == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().weeks().subtract(getLocalMillis(), weeks); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1369,1375
public LocalDate minusDays(int days) { [EOL]     if (days == 0) { [EOL]         return this; [EOL]     } [EOL]     long instant = getChronology().days().subtract(getLocalMillis(), days); [EOL]     return withLocalMillis(instant); [EOL] } <line_num>: 1392,1398
public Property property(DateTimeFieldType fieldType) { [EOL]     if (fieldType == null) { [EOL]         throw new IllegalArgumentException("The DateTimeFieldType must not be null"); [EOL]     } [EOL]     if (isSupported(fieldType) == false) { [EOL]         throw new IllegalArgumentException("Field '" + fieldType + "' is not supported"); [EOL]     } [EOL]     return new Property(this, fieldType.getField(getChronology())); [EOL] } <line_num>: 1409,1417
public int getEra() { [EOL]     return getChronology().era().get(getLocalMillis()); [EOL] } <line_num>: 1425,1427
public int getCenturyOfEra() { [EOL]     return getChronology().centuryOfEra().get(getLocalMillis()); [EOL] } <line_num>: 1434,1436
public int getYearOfEra() { [EOL]     return getChronology().yearOfEra().get(getLocalMillis()); [EOL] } <line_num>: 1443,1445
public int getYearOfCentury() { [EOL]     return getChronology().yearOfCentury().get(getLocalMillis()); [EOL] } <line_num>: 1452,1454
public int getYear() { [EOL]     return getChronology().year().get(getLocalMillis()); [EOL] } <line_num>: 1461,1463
public int getWeekyear() { [EOL]     return getChronology().weekyear().get(getLocalMillis()); [EOL] } <line_num>: 1476,1478
public int getMonthOfYear() { [EOL]     return getChronology().monthOfYear().get(getLocalMillis()); [EOL] } <line_num>: 1485,1487
public int getWeekOfWeekyear() { [EOL]     return getChronology().weekOfWeekyear().get(getLocalMillis()); [EOL] } <line_num>: 1499,1501
public int getDayOfYear() { [EOL]     return getChronology().dayOfYear().get(getLocalMillis()); [EOL] } <line_num>: 1508,1510
public int getDayOfMonth() { [EOL]     return getChronology().dayOfMonth().get(getLocalMillis()); [EOL] } <line_num>: 1519,1521
public int getDayOfWeek() { [EOL]     return getChronology().dayOfWeek().get(getLocalMillis()); [EOL] } <line_num>: 1530,1532
public LocalDate withEra(int era) { [EOL]     return withLocalMillis(getChronology().era().set(getLocalMillis(), era)); [EOL] } <line_num>: 1546,1548
public LocalDate withCenturyOfEra(int centuryOfEra) { [EOL]     return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), centuryOfEra)); [EOL] } <line_num>: 1561,1563
public LocalDate withYearOfEra(int yearOfEra) { [EOL]     return withLocalMillis(getChronology().yearOfEra().set(getLocalMillis(), yearOfEra)); [EOL] } <line_num>: 1576,1578
public LocalDate withYearOfCentury(int yearOfCentury) { [EOL]     return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), yearOfCentury)); [EOL] } <line_num>: 1591,1593
public LocalDate withYear(int year) { [EOL]     return withLocalMillis(getChronology().year().set(getLocalMillis(), year)); [EOL] } <line_num>: 1606,1608
public LocalDate withWeekyear(int weekyear) { [EOL]     return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), weekyear)); [EOL] } <line_num>: 1627,1629
public LocalDate withMonthOfYear(int monthOfYear) { [EOL]     return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), monthOfYear)); [EOL] } <line_num>: 1642,1644
public LocalDate withWeekOfWeekyear(int weekOfWeekyear) { [EOL]     return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), weekOfWeekyear)); [EOL] } <line_num>: 1662,1664
public LocalDate withDayOfYear(int dayOfYear) { [EOL]     return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), dayOfYear)); [EOL] } <line_num>: 1677,1679
public LocalDate withDayOfMonth(int dayOfMonth) { [EOL]     return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), dayOfMonth)); [EOL] } <line_num>: 1692,1694
public LocalDate withDayOfWeek(int dayOfWeek) { [EOL]     return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), dayOfWeek)); [EOL] } <line_num>: 1707,1709
public Property era() { [EOL]     return new Property(this, getChronology().era()); [EOL] } <line_num>: 1717,1719
public Property centuryOfEra() { [EOL]     return new Property(this, getChronology().centuryOfEra()); [EOL] } <line_num>: 1726,1728
public Property yearOfCentury() { [EOL]     return new Property(this, getChronology().yearOfCentury()); [EOL] } <line_num>: 1735,1737
public Property yearOfEra() { [EOL]     return new Property(this, getChronology().yearOfEra()); [EOL] } <line_num>: 1744,1746
public Property year() { [EOL]     return new Property(this, getChronology().year()); [EOL] } <line_num>: 1753,1755
public Property weekyear() { [EOL]     return new Property(this, getChronology().weekyear()); [EOL] } <line_num>: 1762,1764
public Property monthOfYear() { [EOL]     return new Property(this, getChronology().monthOfYear()); [EOL] } <line_num>: 1771,1773
public Property weekOfWeekyear() { [EOL]     return new Property(this, getChronology().weekOfWeekyear()); [EOL] } <line_num>: 1780,1782
public Property dayOfYear() { [EOL]     return new Property(this, getChronology().dayOfYear()); [EOL] } <line_num>: 1789,1791
public Property dayOfMonth() { [EOL]     return new Property(this, getChronology().dayOfMonth()); [EOL] } <line_num>: 1798,1800
public Property dayOfWeek() { [EOL]     return new Property(this, getChronology().dayOfWeek()); [EOL] } <line_num>: 1807,1809
@ToString [EOL] public String toString() { [EOL]     return ISODateTimeFormat.date().print(this); [EOL] } <line_num>: 1817,1820
public String toString(String pattern) { [EOL]     if (pattern == null) { [EOL]         return toString(); [EOL]     } [EOL]     return DateTimeFormat.forPattern(pattern).print(this); [EOL] } <line_num>: 1828,1833
public String toString(String pattern, Locale locale) throws IllegalArgumentException { [EOL]     if (pattern == null) { [EOL]         return toString(); [EOL]     } [EOL]     return DateTimeFormat.forPattern(pattern).withLocale(locale).print(this); [EOL] } <line_num>: 1842,1847
private void writeObject(ObjectOutputStream oos) throws IOException { [EOL]     oos.writeObject(iInstant); [EOL]     oos.writeObject(iField.getType()); [EOL] } <line_num>: 1902,1905
private void readObject(ObjectInputStream oos) throws IOException, ClassNotFoundException { [EOL]     iInstant = (LocalDate) oos.readObject(); [EOL]     DateTimeFieldType type = (DateTimeFieldType) oos.readObject(); [EOL]     iField = type.getField(iInstant.getChronology()); [EOL] } <line_num>: 1910,1914
public DateTimeField getField() { [EOL]     return iField; [EOL] } <line_num>: 1922,1924
protected long getMillis() { [EOL]     return iInstant.getLocalMillis(); [EOL] } <line_num>: 1931,1933
protected Chronology getChronology() { [EOL]     return iInstant.getChronology(); [EOL] } <line_num>: 1941,1943
public LocalDate getLocalDate() { [EOL]     return iInstant; [EOL] } <line_num>: 1950,1952
public LocalDate addToCopy(int value) { [EOL]     return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), value)); [EOL] } <line_num>: 1964,1966
public LocalDate addWrapFieldToCopy(int value) { [EOL]     return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), value)); [EOL] } <line_num>: 1979,1981
public LocalDate setCopy(int value) { [EOL]     return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), value)); [EOL] } <line_num>: 1993,1995
public LocalDate setCopy(String text, Locale locale) { [EOL]     return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), text, locale)); [EOL] } <line_num>: 2007,2009
public LocalDate setCopy(String text) { [EOL]     return setCopy(text, null); [EOL] } <line_num>: 2020,2022
public LocalDate withMaximumValue() { [EOL]     return setCopy(getMaximumValue()); [EOL] } <line_num>: 2039,2041
public LocalDate withMinimumValue() { [EOL]     return setCopy(getMinimumValue()); [EOL] } <line_num>: 2051,2053
public LocalDate roundFloorCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis())); [EOL] } <line_num>: 2066,2068
public LocalDate roundCeilingCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis())); [EOL] } <line_num>: 2080,2082
public LocalDate roundHalfFloorCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis())); [EOL] } <line_num>: 2090,2092
public LocalDate roundHalfCeilingCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis())); [EOL] } <line_num>: 2100,2102
public LocalDate roundHalfEvenCopy() { [EOL]     return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis())); [EOL] } <line_num>: 2111,2113