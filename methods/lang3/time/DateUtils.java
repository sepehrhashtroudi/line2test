public static boolean isSameDay(final Date date1, final Date date2) { [EOL]     if (date1 == null || date2 == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar cal1 = Calendar.getInstance(); [EOL]     cal1.setTime(date1); [EOL]     final Calendar cal2 = Calendar.getInstance(); [EOL]     cal2.setTime(date2); [EOL]     return isSameDay(cal1, cal2); [EOL] } <line_num>: 154
public static boolean isSameDay(final Calendar cal1, final Calendar cal2) { [EOL]     if (cal1 == null || cal2 == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)); [EOL] } <line_num>: 178
public static boolean isSameInstant(final Date date1, final Date date2) { [EOL]     if (date1 == null || date2 == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     return date1.getTime() == date2.getTime(); [EOL] } <line_num>: 199
public static boolean isSameInstant(final Calendar cal1, final Calendar cal2) { [EOL]     if (cal1 == null || cal2 == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     return cal1.getTime().getTime() == cal2.getTime().getTime(); [EOL] } <line_num>: 217
public static boolean isSameLocalTime(final Calendar cal1, final Calendar cal2) { [EOL]     if (cal1 == null || cal2 == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     return (cal1.get(Calendar.MILLISECOND) == cal2.get(Calendar.MILLISECOND) && cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND) && cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE) && cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.getClass() == cal2.getClass()); [EOL] } <line_num>: 237
public static Date parseDate(final String str, final String... parsePatterns) throws ParseException { [EOL]     return parseDate(str, null, parsePatterns); [EOL] } <line_num>: 266
public static Date parseDate(final String str, final Locale locale, final String... parsePatterns) throws ParseException { [EOL]     return parseDateWithLeniency(str, locale, parsePatterns, true); [EOL] } <line_num>: 289
public static Date parseDateStrictly(final String str, final String... parsePatterns) throws ParseException { [EOL]     return parseDateStrictly(str, null, parsePatterns); [EOL] } <line_num>: 309
public static Date parseDateStrictly(final String str, final Locale locale, final String... parsePatterns) throws ParseException { [EOL]     return parseDateWithLeniency(str, null, parsePatterns, false); [EOL] } <line_num>: 331
private static Date parseDateWithLeniency(final String str, final Locale locale, final String[] parsePatterns, final boolean lenient) throws ParseException { [EOL]     if (str == null || parsePatterns == null) { [EOL]         throw new IllegalArgumentException("Date and Patterns must not be null"); [EOL]     } [EOL]     SimpleDateFormat parser; [EOL]     if (locale == null) { [EOL]         parser = new SimpleDateFormat(); [EOL]     } else { [EOL]         parser = new SimpleDateFormat("", locale); [EOL]     } [EOL]     parser.setLenient(lenient); [EOL]     final ParsePosition pos = new ParsePosition(0); [EOL]     for (final String parsePattern : parsePatterns) { [EOL]         String pattern = parsePattern; [EOL]         if (parsePattern.endsWith("ZZ")) { [EOL]             pattern = pattern.substring(0, pattern.length() - 1); [EOL]         } [EOL]         parser.applyPattern(pattern); [EOL]         pos.setIndex(0); [EOL]         String str2 = str; [EOL]         if (parsePattern.endsWith("ZZ")) { [EOL]             str2 = str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2"); [EOL]         } [EOL]         final Date date = parser.parse(str2, pos); [EOL]         if (date != null && pos.getIndex() == str2.length()) { [EOL]             return date; [EOL]         } [EOL]     } [EOL]     throw new ParseException("Unable to parse the date: " + str, -1); [EOL] } <line_num>: 352
public static Date addYears(final Date date, final int amount) { [EOL]     return add(date, Calendar.YEAR, amount); [EOL] } <line_num>: 403
public static Date addMonths(final Date date, final int amount) { [EOL]     return add(date, Calendar.MONTH, amount); [EOL] } <line_num>: 417
public static Date addWeeks(final Date date, final int amount) { [EOL]     return add(date, Calendar.WEEK_OF_YEAR, amount); [EOL] } <line_num>: 431
public static Date addDays(final Date date, final int amount) { [EOL]     return add(date, Calendar.DAY_OF_MONTH, amount); [EOL] } <line_num>: 445
public static Date addHours(final Date date, final int amount) { [EOL]     return add(date, Calendar.HOUR_OF_DAY, amount); [EOL] } <line_num>: 459
public static Date addMinutes(final Date date, final int amount) { [EOL]     return add(date, Calendar.MINUTE, amount); [EOL] } <line_num>: 473
public static Date addSeconds(final Date date, final int amount) { [EOL]     return add(date, Calendar.SECOND, amount); [EOL] } <line_num>: 487
public static Date addMilliseconds(final Date date, final int amount) { [EOL]     return add(date, Calendar.MILLISECOND, amount); [EOL] } <line_num>: 501
private static Date add(final Date date, final int calendarField, final int amount) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar c = Calendar.getInstance(); [EOL]     c.setTime(date); [EOL]     c.add(calendarField, amount); [EOL]     return c.getTime(); [EOL] } <line_num>: 516
public static Date setYears(final Date date, final int amount) { [EOL]     return set(date, Calendar.YEAR, amount); [EOL] } <line_num>: 537
public static Date setMonths(final Date date, final int amount) { [EOL]     return set(date, Calendar.MONTH, amount); [EOL] } <line_num>: 552
public static Date setDays(final Date date, final int amount) { [EOL]     return set(date, Calendar.DAY_OF_MONTH, amount); [EOL] } <line_num>: 567
public static Date setHours(final Date date, final int amount) { [EOL]     return set(date, Calendar.HOUR_OF_DAY, amount); [EOL] } <line_num>: 583
public static Date setMinutes(final Date date, final int amount) { [EOL]     return set(date, Calendar.MINUTE, amount); [EOL] } <line_num>: 598
public static Date setSeconds(final Date date, final int amount) { [EOL]     return set(date, Calendar.SECOND, amount); [EOL] } <line_num>: 613
public static Date setMilliseconds(final Date date, final int amount) { [EOL]     return set(date, Calendar.MILLISECOND, amount); [EOL] } <line_num>: 628
private static Date set(final Date date, final int calendarField, final int amount) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar c = Calendar.getInstance(); [EOL]     c.setLenient(false); [EOL]     c.setTime(date); [EOL]     c.set(calendarField, amount); [EOL]     return c.getTime(); [EOL] } <line_num>: 645
public static Calendar toCalendar(final Date date) { [EOL]     final Calendar c = Calendar.getInstance(); [EOL]     c.setTime(date); [EOL]     return c; [EOL] } <line_num>: 666
public static Date round(final Date date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar gval = Calendar.getInstance(); [EOL]     gval.setTime(date); [EOL]     modify(gval, field, MODIFY_ROUND); [EOL]     return gval.getTime(); [EOL] } <line_num>: 699
public static Calendar round(final Calendar date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar rounded = (Calendar) date.clone(); [EOL]     modify(rounded, field, MODIFY_ROUND); [EOL]     return rounded; [EOL] } <line_num>: 736
public static Date round(final Object date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     if (date instanceof Date) { [EOL]         return round((Date) date, field); [EOL]     } else if (date instanceof Calendar) { [EOL]         return round((Calendar) date, field).getTime(); [EOL]     } else { [EOL]         throw new ClassCastException("Could not round " + date); [EOL]     } [EOL] } <line_num>: 773
public static Date truncate(final Date date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar gval = Calendar.getInstance(); [EOL]     gval.setTime(date); [EOL]     modify(gval, field, MODIFY_TRUNCATE); [EOL]     return gval.getTime(); [EOL] } <line_num>: 802
public static Calendar truncate(final Calendar date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar truncated = (Calendar) date.clone(); [EOL]     modify(truncated, field, MODIFY_TRUNCATE); [EOL]     return truncated; [EOL] } <line_num>: 827
public static Date truncate(final Object date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     if (date instanceof Date) { [EOL]         return truncate((Date) date, field); [EOL]     } else if (date instanceof Calendar) { [EOL]         return truncate((Calendar) date, field).getTime(); [EOL]     } else { [EOL]         throw new ClassCastException("Could not truncate " + date); [EOL]     } [EOL] } <line_num>: 852
public static Date ceiling(final Date date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar gval = Calendar.getInstance(); [EOL]     gval.setTime(date); [EOL]     modify(gval, field, MODIFY_CEILING); [EOL]     return gval.getTime(); [EOL] } <line_num>: 882
public static Calendar ceiling(final Calendar date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar ceiled = (Calendar) date.clone(); [EOL]     modify(ceiled, field, MODIFY_CEILING); [EOL]     return ceiled; [EOL] } <line_num>: 908
public static Date ceiling(final Object date, final int field) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     if (date instanceof Date) { [EOL]         return ceiling((Date) date, field); [EOL]     } else if (date instanceof Calendar) { [EOL]         return ceiling((Calendar) date, field).getTime(); [EOL]     } else { [EOL]         throw new ClassCastException("Could not find ceiling of for type: " + date.getClass()); [EOL]     } [EOL] } <line_num>: 934
private static void modify(final Calendar val, final int field, final int modType) { [EOL]     if (val.get(Calendar.YEAR) > 280000000) { [EOL]         throw new ArithmeticException("Calendar value too large for accurate calculations"); [EOL]     } [EOL]     if (field == Calendar.MILLISECOND) { [EOL]         return; [EOL]     } [EOL]     final Date date = val.getTime(); [EOL]     long time = date.getTime(); [EOL]     boolean done = false; [EOL]     final int millisecs = val.get(Calendar.MILLISECOND); [EOL]     if (MODIFY_TRUNCATE == modType || millisecs < 500) { [EOL]         time = time - millisecs; [EOL]     } [EOL]     if (field == Calendar.SECOND) { [EOL]         done = true; [EOL]     } [EOL]     final int seconds = val.get(Calendar.SECOND); [EOL]     if (!done && (MODIFY_TRUNCATE == modType || seconds < 30)) { [EOL]         time = time - (seconds * 1000L); [EOL]     } [EOL]     if (field == Calendar.MINUTE) { [EOL]         done = true; [EOL]     } [EOL]     final int minutes = val.get(Calendar.MINUTE); [EOL]     if (!done && (MODIFY_TRUNCATE == modType || minutes < 30)) { [EOL]         time = time - (minutes * 60000L); [EOL]     } [EOL]     if (date.getTime() != time) { [EOL]         date.setTime(time); [EOL]         val.setTime(date); [EOL]     } [EOL]     boolean roundUp = false; [EOL]     for (final int[] aField : fields) { [EOL]         for (final int element : aField) { [EOL]             if (element == field) { [EOL]                 if (modType == MODIFY_CEILING || (modType == MODIFY_ROUND && roundUp)) { [EOL]                     if (field == DateUtils.SEMI_MONTH) { [EOL]                         if (val.get(Calendar.DATE) == 1) { [EOL]                             val.add(Calendar.DATE, 15); [EOL]                         } else { [EOL]                             val.add(Calendar.DATE, -15); [EOL]                             val.add(Calendar.MONTH, 1); [EOL]                         } [EOL]                     } else if (field == Calendar.AM_PM) { [EOL]                         if (val.get(Calendar.HOUR_OF_DAY) == 0) { [EOL]                             val.add(Calendar.HOUR_OF_DAY, 12); [EOL]                         } else { [EOL]                             val.add(Calendar.HOUR_OF_DAY, -12); [EOL]                             val.add(Calendar.DATE, 1); [EOL]                         } [EOL]                     } else { [EOL]                         val.add(aField[0], 1); [EOL]                     } [EOL]                 } [EOL]                 return; [EOL]             } [EOL]         } [EOL]         int offset = 0; [EOL]         boolean offsetSet = false; [EOL]         switch(field) { [EOL]             case DateUtils.SEMI_MONTH: [EOL]                 if (aField[0] == Calendar.DATE) { [EOL]                     offset = val.get(Calendar.DATE) - 1; [EOL]                     if (offset >= 15) { [EOL]                         offset -= 15; [EOL]                     } [EOL]                     roundUp = offset > 7; [EOL]                     offsetSet = true; [EOL]                 } [EOL]                 break; [EOL]             case Calendar.AM_PM: [EOL]                 if (aField[0] == Calendar.HOUR_OF_DAY) { [EOL]                     offset = val.get(Calendar.HOUR_OF_DAY); [EOL]                     if (offset >= 12) { [EOL]                         offset -= 12; [EOL]                     } [EOL]                     roundUp = offset >= 6; [EOL]                     offsetSet = true; [EOL]                 } [EOL]                 break; [EOL]         } [EOL]         if (!offsetSet) { [EOL]             final int min = val.getActualMinimum(aField[0]); [EOL]             final int max = val.getActualMaximum(aField[0]); [EOL]             offset = val.get(aField[0]) - min; [EOL]             roundUp = offset > ((max - min) / 2); [EOL]         } [EOL]         if (offset != 0) { [EOL]             val.set(aField[0], val.get(aField[0]) - offset); [EOL]         } [EOL]     } [EOL]     throw new IllegalArgumentException("The field " + field + " is not supported"); [EOL] } <line_num>: 956
public static Iterator<Calendar> iterator(final Date focus, final int rangeStyle) { [EOL]     if (focus == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar gval = Calendar.getInstance(); [EOL]     gval.setTime(focus); [EOL]     return iterator(gval, rangeStyle); [EOL] } <line_num>: 1119
public static Iterator<Calendar> iterator(final Calendar focus, final int rangeStyle) { [EOL]     if (focus == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     Calendar start = null; [EOL]     Calendar end = null; [EOL]     int startCutoff = Calendar.SUNDAY; [EOL]     int endCutoff = Calendar.SATURDAY; [EOL]     switch(rangeStyle) { [EOL]         case RANGE_MONTH_SUNDAY: [EOL]         case RANGE_MONTH_MONDAY: [EOL]             start = truncate(focus, Calendar.MONTH); [EOL]             end = (Calendar) start.clone(); [EOL]             end.add(Calendar.MONTH, 1); [EOL]             end.add(Calendar.DATE, -1); [EOL]             if (rangeStyle == RANGE_MONTH_MONDAY) { [EOL]                 startCutoff = Calendar.MONDAY; [EOL]                 endCutoff = Calendar.SUNDAY; [EOL]             } [EOL]             break; [EOL]         case RANGE_WEEK_SUNDAY: [EOL]         case RANGE_WEEK_MONDAY: [EOL]         case RANGE_WEEK_RELATIVE: [EOL]         case RANGE_WEEK_CENTER: [EOL]             start = truncate(focus, Calendar.DATE); [EOL]             end = truncate(focus, Calendar.DATE); [EOL]             switch(rangeStyle) { [EOL]                 case RANGE_WEEK_SUNDAY: [EOL]                     break; [EOL]                 case RANGE_WEEK_MONDAY: [EOL]                     startCutoff = Calendar.MONDAY; [EOL]                     endCutoff = Calendar.SUNDAY; [EOL]                     break; [EOL]                 case RANGE_WEEK_RELATIVE: [EOL]                     startCutoff = focus.get(Calendar.DAY_OF_WEEK); [EOL]                     endCutoff = startCutoff - 1; [EOL]                     break; [EOL]                 case RANGE_WEEK_CENTER: [EOL]                     startCutoff = focus.get(Calendar.DAY_OF_WEEK) - 3; [EOL]                     endCutoff = focus.get(Calendar.DAY_OF_WEEK) + 3; [EOL]                     break; [EOL]             } [EOL]             break; [EOL]         default: [EOL]             throw new IllegalArgumentException("The range style " + rangeStyle + " is not valid."); [EOL]     } [EOL]     if (startCutoff < Calendar.SUNDAY) { [EOL]         startCutoff += 7; [EOL]     } [EOL]     if (startCutoff > Calendar.SATURDAY) { [EOL]         startCutoff -= 7; [EOL]     } [EOL]     if (endCutoff < Calendar.SUNDAY) { [EOL]         endCutoff += 7; [EOL]     } [EOL]     if (endCutoff > Calendar.SATURDAY) { [EOL]         endCutoff -= 7; [EOL]     } [EOL]     while (start.get(Calendar.DAY_OF_WEEK) != startCutoff) { [EOL]         start.add(Calendar.DATE, -1); [EOL]     } [EOL]     while (end.get(Calendar.DAY_OF_WEEK) != endCutoff) { [EOL]         end.add(Calendar.DATE, 1); [EOL]     } [EOL]     return new DateIterator(start, end); [EOL] } <line_num>: 1152
public static Iterator<?> iterator(final Object focus, final int rangeStyle) { [EOL]     if (focus == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     if (focus instanceof Date) { [EOL]         return iterator((Date) focus, rangeStyle); [EOL]     } else if (focus instanceof Calendar) { [EOL]         return iterator((Calendar) focus, rangeStyle); [EOL]     } else { [EOL]         throw new ClassCastException("Could not iterate based on " + focus); [EOL]     } [EOL] } <line_num>: 1240
public static long getFragmentInMilliseconds(final Date date, final int fragment) { [EOL]     return getFragment(date, fragment, Calendar.MILLISECOND); [EOL] } <line_num>: 1286
public static long getFragmentInSeconds(final Date date, final int fragment) { [EOL]     return getFragment(date, fragment, Calendar.SECOND); [EOL] } <line_num>: 1326
public static long getFragmentInMinutes(final Date date, final int fragment) { [EOL]     return getFragment(date, fragment, Calendar.MINUTE); [EOL] } <line_num>: 1366
public static long getFragmentInHours(final Date date, final int fragment) { [EOL]     return getFragment(date, fragment, Calendar.HOUR_OF_DAY); [EOL] } <line_num>: 1406
public static long getFragmentInDays(final Date date, final int fragment) { [EOL]     return getFragment(date, fragment, Calendar.DAY_OF_YEAR); [EOL] } <line_num>: 1446
public static long getFragmentInMilliseconds(final Calendar calendar, final int fragment) { [EOL]     return getFragment(calendar, fragment, Calendar.MILLISECOND); [EOL] } <line_num>: 1486
public static long getFragmentInSeconds(final Calendar calendar, final int fragment) { [EOL]     return getFragment(calendar, fragment, Calendar.SECOND); [EOL] } <line_num>: 1525
public static long getFragmentInMinutes(final Calendar calendar, final int fragment) { [EOL]     return getFragment(calendar, fragment, Calendar.MINUTE); [EOL] } <line_num>: 1565
public static long getFragmentInHours(final Calendar calendar, final int fragment) { [EOL]     return getFragment(calendar, fragment, Calendar.HOUR_OF_DAY); [EOL] } <line_num>: 1605
public static long getFragmentInDays(final Calendar calendar, final int fragment) { [EOL]     return getFragment(calendar, fragment, Calendar.DAY_OF_YEAR); [EOL] } <line_num>: 1647
private static long getFragment(final Date date, final int fragment, final int unit) { [EOL]     if (date == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final Calendar calendar = Calendar.getInstance(); [EOL]     calendar.setTime(date); [EOL]     return getFragment(calendar, fragment, unit); [EOL] } <line_num>: 1662
private static long getFragment(final Calendar calendar, final int fragment, final int unit) { [EOL]     if (calendar == null) { [EOL]         throw new IllegalArgumentException("The date must not be null"); [EOL]     } [EOL]     final long millisPerUnit = getMillisPerUnit(unit); [EOL]     long result = 0; [EOL]     switch(fragment) { [EOL]         case Calendar.YEAR: [EOL]             result += (calendar.get(Calendar.DAY_OF_YEAR) * MILLIS_PER_DAY) / millisPerUnit; [EOL]             break; [EOL]         case Calendar.MONTH: [EOL]             result += (calendar.get(Calendar.DAY_OF_MONTH) * MILLIS_PER_DAY) / millisPerUnit; [EOL]             break; [EOL]     } [EOL]     switch(fragment) { [EOL]         case Calendar.YEAR: [EOL]         case Calendar.MONTH: [EOL]         case Calendar.DAY_OF_YEAR: [EOL]         case Calendar.DATE: [EOL]             result += (calendar.get(Calendar.HOUR_OF_DAY) * MILLIS_PER_HOUR) / millisPerUnit; [EOL]         case Calendar.HOUR_OF_DAY: [EOL]             result += (calendar.get(Calendar.MINUTE) * MILLIS_PER_MINUTE) / millisPerUnit; [EOL]         case Calendar.MINUTE: [EOL]             result += (calendar.get(Calendar.SECOND) * MILLIS_PER_SECOND) / millisPerUnit; [EOL]         case Calendar.SECOND: [EOL]             result += (calendar.get(Calendar.MILLISECOND) * 1) / millisPerUnit; [EOL]             break; [EOL]         case Calendar.MILLISECOND: [EOL]             break; [EOL]         default: [EOL]             throw new IllegalArgumentException("The fragment " + fragment + " is not supported"); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 1682
public static boolean truncatedEquals(final Calendar cal1, final Calendar cal2, final int field) { [EOL]     return truncatedCompareTo(cal1, cal2, field) == 0; [EOL] } <line_num>: 1737
public static boolean truncatedEquals(final Date date1, final Date date2, final int field) { [EOL]     return truncatedCompareTo(date1, date2, field) == 0; [EOL] } <line_num>: 1754
public static int truncatedCompareTo(final Calendar cal1, final Calendar cal2, final int field) { [EOL]     final Calendar truncatedCal1 = truncate(cal1, field); [EOL]     final Calendar truncatedCal2 = truncate(cal2, field); [EOL]     return truncatedCal1.compareTo(truncatedCal2); [EOL] } <line_num>: 1772
public static int truncatedCompareTo(final Date date1, final Date date2, final int field) { [EOL]     final Date truncatedDate1 = truncate(date1, field); [EOL]     final Date truncatedDate2 = truncate(date2, field); [EOL]     return truncatedDate1.compareTo(truncatedDate2); [EOL] } <line_num>: 1792
private static long getMillisPerUnit(final int unit) { [EOL]     long result = Long.MAX_VALUE; [EOL]     switch(unit) { [EOL]         case Calendar.DAY_OF_YEAR: [EOL]         case Calendar.DATE: [EOL]             result = MILLIS_PER_DAY; [EOL]             break; [EOL]         case Calendar.HOUR_OF_DAY: [EOL]             result = MILLIS_PER_HOUR; [EOL]             break; [EOL]         case Calendar.MINUTE: [EOL]             result = MILLIS_PER_MINUTE; [EOL]             break; [EOL]         case Calendar.SECOND: [EOL]             result = MILLIS_PER_SECOND; [EOL]             break; [EOL]         case Calendar.MILLISECOND: [EOL]             result = 1; [EOL]             break; [EOL]         default: [EOL]             throw new IllegalArgumentException("The unit " + unit + " cannot be represented is milleseconds"); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 1807
@Override [EOL] public boolean hasNext() { [EOL]     return spot.before(endFinal); [EOL] } <line_num>: 1858
@Override [EOL] public Calendar next() { [EOL]     if (spot.equals(endFinal)) { [EOL]         throw new NoSuchElementException(); [EOL]     } [EOL]     spot.add(Calendar.DATE, 1); [EOL]     return (Calendar) spot.clone(); [EOL] } <line_num>: 1868
@Override [EOL] public void remove() { [EOL]     throw new UnsupportedOperationException(); [EOL] } <line_num>: 1883
