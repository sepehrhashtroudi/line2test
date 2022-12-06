public DateTimeFormatter(DateTimePrinter printer, DateTimeParser parser) { [EOL]     super(); [EOL]     iPrinter = printer; [EOL]     iParser = parser; [EOL]     iLocale = null; [EOL]     iOffsetParsed = false; [EOL]     iChrono = null; [EOL]     iZone = null; [EOL]     iPivotYear = null; [EOL]     iDefaultYear = 2000; [EOL] } <line_num>: 116,127
private DateTimeFormatter(DateTimePrinter printer, DateTimeParser parser, Locale locale, boolean offsetParsed, Chronology chrono, DateTimeZone zone, Integer pivotYear, int defaultYear) { [EOL]     super(); [EOL]     iPrinter = printer; [EOL]     iParser = parser; [EOL]     iLocale = locale; [EOL]     iOffsetParsed = offsetParsed; [EOL]     iChrono = chrono; [EOL]     iZone = zone; [EOL]     iPivotYear = pivotYear; [EOL]     iDefaultYear = defaultYear; [EOL] } <line_num>: 132,146
public boolean isPrinter() { [EOL]     return (iPrinter != null); [EOL] } <line_num>: 154,156
public DateTimePrinter getPrinter() { [EOL]     return iPrinter; [EOL] } <line_num>: 163,165
public boolean isParser() { [EOL]     return (iParser != null); [EOL] } <line_num>: 172,174
public DateTimeParser getParser() { [EOL]     return iParser; [EOL] } <line_num>: 181,183
public DateTimeFormatter withLocale(Locale locale) { [EOL]     if (locale == getLocale() || (locale != null && locale.equals(getLocale()))) { [EOL]         return this; [EOL]     } [EOL]     return new DateTimeFormatter(iPrinter, iParser, locale, iOffsetParsed, iChrono, iZone, iPivotYear, iDefaultYear); [EOL] } <line_num>: 197,203
public Locale getLocale() { [EOL]     return iLocale; [EOL] } <line_num>: 211,213
public DateTimeFormatter withOffsetParsed() { [EOL]     if (iOffsetParsed == true) { [EOL]         return this; [EOL]     } [EOL]     return new DateTimeFormatter(iPrinter, iParser, iLocale, true, iChrono, null, iPivotYear, iDefaultYear); [EOL] } <line_num>: 230,236
public boolean isOffsetParsed() { [EOL]     return iOffsetParsed; [EOL] } <line_num>: 244,246
public DateTimeFormatter withChronology(Chronology chrono) { [EOL]     if (iChrono == chrono) { [EOL]         return this; [EOL]     } [EOL]     return new DateTimeFormatter(iPrinter, iParser, iLocale, iOffsetParsed, chrono, iZone, iPivotYear, iDefaultYear); [EOL] } <line_num>: 265,271
public Chronology getChronology() { [EOL]     return iChrono; [EOL] } <line_num>: 278,280
@Deprecated [EOL] public Chronology getChronolgy() { [EOL]     return iChrono; [EOL] } <line_num>: 288,291
public DateTimeFormatter withZoneUTC() { [EOL]     return withZone(DateTimeZone.UTC); [EOL] } <line_num>: 309,311
public DateTimeFormatter withZone(DateTimeZone zone) { [EOL]     if (iZone == zone) { [EOL]         return this; [EOL]     } [EOL]     return new DateTimeFormatter(iPrinter, iParser, iLocale, false, iChrono, zone, iPivotYear, iDefaultYear); [EOL] } <line_num>: 329,335
public DateTimeZone getZone() { [EOL]     return iZone; [EOL] } <line_num>: 342,344
public DateTimeFormatter withPivotYear(Integer pivotYear) { [EOL]     if (iPivotYear == pivotYear || (iPivotYear != null && iPivotYear.equals(pivotYear))) { [EOL]         return this; [EOL]     } [EOL]     return new DateTimeFormatter(iPrinter, iParser, iLocale, iOffsetParsed, iChrono, iZone, pivotYear, iDefaultYear); [EOL] } <line_num>: 376,382
public DateTimeFormatter withPivotYear(int pivotYear) { [EOL]     return withPivotYear(Integer.valueOf(pivotYear)); [EOL] } <line_num>: 413,415
public Integer getPivotYear() { [EOL]     return iPivotYear; [EOL] } <line_num>: 423,425
public DateTimeFormatter withDefaultYear(int defaultYear) { [EOL]     return new DateTimeFormatter(iPrinter, iParser, iLocale, iOffsetParsed, iChrono, iZone, iPivotYear, defaultYear); [EOL] } <line_num>: 446,449
public int getDefaultYear() { [EOL]     return iDefaultYear; [EOL] } <line_num>: 457,459
public void printTo(StringBuffer buf, ReadableInstant instant) { [EOL]     long millis = DateTimeUtils.getInstantMillis(instant); [EOL]     Chronology chrono = DateTimeUtils.getInstantChronology(instant); [EOL]     printTo(buf, millis, chrono); [EOL] } <line_num>: 468,472
public void printTo(Writer out, ReadableInstant instant) throws IOException { [EOL]     long millis = DateTimeUtils.getInstantMillis(instant); [EOL]     Chronology chrono = DateTimeUtils.getInstantChronology(instant); [EOL]     printTo(out, millis, chrono); [EOL] } <line_num>: 480,484
public void printTo(Appendable appendable, ReadableInstant instant) throws IOException { [EOL]     appendable.append(print(instant)); [EOL] } <line_num>: 493,495
public void printTo(StringBuffer buf, long instant) { [EOL]     printTo(buf, instant, null); [EOL] } <line_num>: 505,507
public void printTo(Writer out, long instant) throws IOException { [EOL]     printTo(out, instant, null); [EOL] } <line_num>: 516,518
public void printTo(Appendable appendable, long instant) throws IOException { [EOL]     appendable.append(print(instant)); [EOL] } <line_num>: 528,530
public void printTo(StringBuffer buf, ReadablePartial partial) { [EOL]     DateTimePrinter printer = requirePrinter(); [EOL]     if (partial == null) { [EOL]         throw new IllegalArgumentException("The partial must not be null"); [EOL]     } [EOL]     printer.printTo(buf, partial, iLocale); [EOL] } <line_num>: 542,548
public void printTo(Writer out, ReadablePartial partial) throws IOException { [EOL]     DateTimePrinter printer = requirePrinter(); [EOL]     if (partial == null) { [EOL]         throw new IllegalArgumentException("The partial must not be null"); [EOL]     } [EOL]     printer.printTo(out, partial, iLocale); [EOL] } <line_num>: 559,565
public void printTo(Appendable appendable, ReadablePartial partial) throws IOException { [EOL]     appendable.append(print(partial)); [EOL] } <line_num>: 577,579
public String print(ReadableInstant instant) { [EOL]     StringBuffer buf = new StringBuffer(requirePrinter().estimatePrintedLength()); [EOL]     printTo(buf, instant); [EOL]     return buf.toString(); [EOL] } <line_num>: 591,595
public String print(long instant) { [EOL]     StringBuffer buf = new StringBuffer(requirePrinter().estimatePrintedLength()); [EOL]     printTo(buf, instant); [EOL]     return buf.toString(); [EOL] } <line_num>: 606,610
public String print(ReadablePartial partial) { [EOL]     StringBuffer buf = new StringBuffer(requirePrinter().estimatePrintedLength()); [EOL]     printTo(buf, partial); [EOL]     return buf.toString(); [EOL] } <line_num>: 621,625
private void printTo(StringBuffer buf, long instant, Chronology chrono) { [EOL]     DateTimePrinter printer = requirePrinter(); [EOL]     chrono = selectChronology(chrono); [EOL]     DateTimeZone zone = chrono.getZone(); [EOL]     int offset = zone.getOffset(instant); [EOL]     long adjustedInstant = instant + offset; [EOL]     if ((instant ^ adjustedInstant) < 0 && (instant ^ offset) >= 0) { [EOL]         zone = DateTimeZone.UTC; [EOL]         offset = 0; [EOL]         adjustedInstant = instant; [EOL]     } [EOL]     printer.printTo(buf, adjustedInstant, chrono.withUTC(), offset, zone, iLocale); [EOL] } <line_num>: 627,642
private void printTo(Writer buf, long instant, Chronology chrono) throws IOException { [EOL]     DateTimePrinter printer = requirePrinter(); [EOL]     chrono = selectChronology(chrono); [EOL]     DateTimeZone zone = chrono.getZone(); [EOL]     int offset = zone.getOffset(instant); [EOL]     long adjustedInstant = instant + offset; [EOL]     if ((instant ^ adjustedInstant) < 0 && (instant ^ offset) >= 0) { [EOL]         zone = DateTimeZone.UTC; [EOL]         offset = 0; [EOL]         adjustedInstant = instant; [EOL]     } [EOL]     printer.printTo(buf, adjustedInstant, chrono.withUTC(), offset, zone, iLocale); [EOL] } <line_num>: 644,659
private DateTimePrinter requirePrinter() { [EOL]     DateTimePrinter printer = iPrinter; [EOL]     if (printer == null) { [EOL]         throw new UnsupportedOperationException("Printing not supported"); [EOL]     } [EOL]     return printer; [EOL] } <line_num>: 666,672
public int parseInto(ReadWritableInstant instant, String text, int position) { [EOL]     DateTimeParser parser = requireParser(); [EOL]     if (instant == null) { [EOL]         throw new IllegalArgumentException("Instant must not be null"); [EOL]     } [EOL]     long instantMillis = instant.getMillis(); [EOL]     Chronology chrono = instant.getChronology(); [EOL]     int defaultYear = DateTimeUtils.getChronology(chrono).year().get(instantMillis); [EOL]     long instantLocal = instantMillis + chrono.getZone().getOffset(instantMillis); [EOL]     chrono = selectChronology(chrono); [EOL]     DateTimeParserBucket bucket = new DateTimeParserBucket(instantLocal, chrono, iLocale, iPivotYear, defaultYear); [EOL]     int newPos = parser.parseInto(bucket, text, position); [EOL]     instant.setMillis(bucket.computeMillis(false, text)); [EOL]     if (iOffsetParsed && bucket.getOffsetInteger() != null) { [EOL]         int parsedOffset = bucket.getOffsetInteger(); [EOL]         DateTimeZone parsedZone = DateTimeZone.forOffsetMillis(parsedOffset); [EOL]         chrono = chrono.withZone(parsedZone); [EOL]     } else if (bucket.getZone() != null) { [EOL]         chrono = chrono.withZone(bucket.getZone()); [EOL]     } [EOL]     instant.setChronology(chrono); [EOL]     if (iZone != null) { [EOL]         instant.setZone(iZone); [EOL]     } [EOL]     return newPos; [EOL] } <line_num>: 708,736
public long parseMillis(String text) { [EOL]     DateTimeParser parser = requireParser(); [EOL]     Chronology chrono = selectChronology(iChrono); [EOL]     DateTimeParserBucket bucket = new DateTimeParserBucket(0, chrono, iLocale, iPivotYear, iDefaultYear); [EOL]     int newPos = parser.parseInto(bucket, text, 0); [EOL]     if (newPos >= 0) { [EOL]         if (newPos >= text.length()) { [EOL]             return bucket.computeMillis(true, text); [EOL]         } [EOL]     } else { [EOL]         newPos = ~newPos; [EOL]     } [EOL]     throw new IllegalArgumentException(FormatUtils.createErrorMessage(text, newPos)); [EOL] } <line_num>: 750,764
public LocalDate parseLocalDate(String text) { [EOL]     return parseLocalDateTime(text).toLocalDate(); [EOL] } <line_num>: 780,782
public LocalTime parseLocalTime(String text) { [EOL]     return parseLocalDateTime(text).toLocalTime(); [EOL] } <line_num>: 798,800
public LocalDateTime parseLocalDateTime(String text) { [EOL]     DateTimeParser parser = requireParser(); [EOL]     Chronology chrono = selectChronology(null).withUTC(); [EOL]     DateTimeParserBucket bucket = new DateTimeParserBucket(0, chrono, iLocale, iPivotYear, iDefaultYear); [EOL]     int newPos = parser.parseInto(bucket, text, 0); [EOL]     if (newPos >= 0) { [EOL]         if (newPos >= text.length()) { [EOL]             long millis = bucket.computeMillis(true, text); [EOL]             if (bucket.getOffsetInteger() != null) { [EOL]                 int parsedOffset = bucket.getOffsetInteger(); [EOL]                 DateTimeZone parsedZone = DateTimeZone.forOffsetMillis(parsedOffset); [EOL]                 chrono = chrono.withZone(parsedZone); [EOL]             } else if (bucket.getZone() != null) { [EOL]                 chrono = chrono.withZone(bucket.getZone()); [EOL]             } [EOL]             return new LocalDateTime(millis, chrono); [EOL]         } [EOL]     } else { [EOL]         newPos = ~newPos; [EOL]     } [EOL]     throw new IllegalArgumentException(FormatUtils.createErrorMessage(text, newPos)); [EOL] } <line_num>: 816,838
public DateTime parseDateTime(String text) { [EOL]     DateTimeParser parser = requireParser(); [EOL]     Chronology chrono = selectChronology(null); [EOL]     DateTimeParserBucket bucket = new DateTimeParserBucket(0, chrono, iLocale, iPivotYear, iDefaultYear); [EOL]     int newPos = parser.parseInto(bucket, text, 0); [EOL]     if (newPos >= 0) { [EOL]         if (newPos >= text.length()) { [EOL]             long millis = bucket.computeMillis(true, text); [EOL]             if (iOffsetParsed && bucket.getOffsetInteger() != null) { [EOL]                 int parsedOffset = bucket.getOffsetInteger(); [EOL]                 DateTimeZone parsedZone = DateTimeZone.forOffsetMillis(parsedOffset); [EOL]                 chrono = chrono.withZone(parsedZone); [EOL]             } else if (bucket.getZone() != null) { [EOL]                 chrono = chrono.withZone(bucket.getZone()); [EOL]             } [EOL]             DateTime dt = new DateTime(millis, chrono); [EOL]             if (iZone != null) { [EOL]                 dt = dt.withZone(iZone); [EOL]             } [EOL]             return dt; [EOL]         } [EOL]     } else { [EOL]         newPos = ~newPos; [EOL]     } [EOL]     throw new IllegalArgumentException(FormatUtils.createErrorMessage(text, newPos)); [EOL] } <line_num>: 857,883
public MutableDateTime parseMutableDateTime(String text) { [EOL]     DateTimeParser parser = requireParser(); [EOL]     Chronology chrono = selectChronology(null); [EOL]     DateTimeParserBucket bucket = new DateTimeParserBucket(0, chrono, iLocale, iPivotYear, iDefaultYear); [EOL]     int newPos = parser.parseInto(bucket, text, 0); [EOL]     if (newPos >= 0) { [EOL]         if (newPos >= text.length()) { [EOL]             long millis = bucket.computeMillis(true, text); [EOL]             if (iOffsetParsed && bucket.getOffsetInteger() != null) { [EOL]                 int parsedOffset = bucket.getOffsetInteger(); [EOL]                 DateTimeZone parsedZone = DateTimeZone.forOffsetMillis(parsedOffset); [EOL]                 chrono = chrono.withZone(parsedZone); [EOL]             } else if (bucket.getZone() != null) { [EOL]                 chrono = chrono.withZone(bucket.getZone()); [EOL]             } [EOL]             MutableDateTime dt = new MutableDateTime(millis, chrono); [EOL]             if (iZone != null) { [EOL]                 dt.setZone(iZone); [EOL]             } [EOL]             return dt; [EOL]         } [EOL]     } else { [EOL]         newPos = ~newPos; [EOL]     } [EOL]     throw new IllegalArgumentException(FormatUtils.createErrorMessage(text, newPos)); [EOL] } <line_num>: 902,928
private DateTimeParser requireParser() { [EOL]     DateTimeParser parser = iParser; [EOL]     if (parser == null) { [EOL]         throw new UnsupportedOperationException("Parsing not supported"); [EOL]     } [EOL]     return parser; [EOL] } <line_num>: 935,941
private Chronology selectChronology(Chronology chrono) { [EOL]     chrono = DateTimeUtils.getChronology(chrono); [EOL]     if (iChrono != null) { [EOL]         chrono = iChrono; [EOL]     } [EOL]     if (iZone != null) { [EOL]         chrono = chrono.withZone(iZone); [EOL]     } [EOL]     return chrono; [EOL] } <line_num>: 950,959