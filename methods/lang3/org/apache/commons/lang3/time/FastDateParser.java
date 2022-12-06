protected FastDateParser(final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     this.pattern = pattern; [EOL]     this.timeZone = timeZone; [EOL]     this.locale = locale; [EOL]     init(); [EOL] } <line_num>: 97,102
CopyQuotedStrategy(final String formatField) { [EOL]     this.formatField = formatField; [EOL] } <line_num>: 523,525
TextStrategy(final int field, final Calendar definingCalendar, final Locale locale) { [EOL]     this.field = field; [EOL]     this.keyValues = getDisplayNames(field, definingCalendar, locale); [EOL] } <line_num>: 562,565
NumberStrategy(final int field) { [EOL]     this.field = field; [EOL] } <line_num>: 610,612
TimeZoneStrategy(final Locale locale) { [EOL]     for (final String id : TimeZone.getAvailableIDs()) { [EOL]         if (id.startsWith("GMT")) { [EOL]             continue; [EOL]         } [EOL]         final TimeZone tz = TimeZone.getTimeZone(id); [EOL]         tzNames.put(tz.getDisplayName(false, TimeZone.SHORT, locale), tz); [EOL]         tzNames.put(tz.getDisplayName(false, TimeZone.LONG, locale), tz); [EOL]         if (tz.useDaylightTime()) { [EOL]             tzNames.put(tz.getDisplayName(true, TimeZone.SHORT, locale), tz); [EOL]             tzNames.put(tz.getDisplayName(true, TimeZone.LONG, locale), tz); [EOL]         } [EOL]     } [EOL]     final StringBuilder sb = new StringBuilder(); [EOL]     sb.append("(GMT[+\\-]\\d{0,1}\\d{2}|[+\\-]\\d{2}:?\\d{2}|"); [EOL]     for (final String id : tzNames.keySet()) { [EOL]         escapeRegex(sb, id, false).append('|'); [EOL]     } [EOL]     sb.setCharAt(sb.length() - 1, ')'); [EOL]     validTimeZoneChars = sb.toString(); [EOL] } <line_num>: 680,700
private void init() { [EOL]     final Calendar definingCalendar = Calendar.getInstance(timeZone, locale); [EOL]     thisYear = definingCalendar.get(Calendar.YEAR); [EOL]     final StringBuilder regex = new StringBuilder(); [EOL]     final List<Strategy> collector = new ArrayList<Strategy>(); [EOL]     final Matcher patternMatcher = formatPattern.matcher(pattern); [EOL]     if (!patternMatcher.lookingAt()) { [EOL]         throw new IllegalArgumentException("Illegal pattern character '" + pattern.charAt(patternMatcher.regionStart()) + "'"); [EOL]     } [EOL]     currentFormatField = patternMatcher.group(); [EOL]     Strategy currentStrategy = getStrategy(currentFormatField, definingCalendar); [EOL]     for (; ; ) { [EOL]         patternMatcher.region(patternMatcher.end(), patternMatcher.regionEnd()); [EOL]         if (!patternMatcher.lookingAt()) { [EOL]             nextStrategy = null; [EOL]             break; [EOL]         } [EOL]         final String nextFormatField = patternMatcher.group(); [EOL]         nextStrategy = getStrategy(nextFormatField, definingCalendar); [EOL]         if (currentStrategy.addRegex(this, regex)) { [EOL]             collector.add(currentStrategy); [EOL]         } [EOL]         currentFormatField = nextFormatField; [EOL]         currentStrategy = nextStrategy; [EOL]     } [EOL]     if (patternMatcher.regionStart() != patternMatcher.regionEnd()) { [EOL]         throw new IllegalArgumentException("Failed to parse \"" + pattern + "\" ; gave up at index " + patternMatcher.regionStart()); [EOL]     } [EOL]     if (currentStrategy.addRegex(this, regex)) { [EOL]         collector.add(currentStrategy); [EOL]     } [EOL]     currentFormatField = null; [EOL]     strategies = collector.toArray(new Strategy[collector.size()]); [EOL]     parsePattern = Pattern.compile(regex.toString()); [EOL] } <line_num>: 108,146
@Override [EOL] public String getPattern() { [EOL]     return pattern; [EOL] } <line_num>: 153,156
@Override [EOL] public TimeZone getTimeZone() { [EOL]     return timeZone; [EOL] } <line_num>: 161,164
@Override [EOL] public Locale getLocale() { [EOL]     return locale; [EOL] } <line_num>: 169,172
Pattern getParsePattern() { [EOL]     return parsePattern; [EOL] } <line_num>: 175,177
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (!(obj instanceof FastDateParser)) { [EOL]         return false; [EOL]     } [EOL]     final FastDateParser other = (FastDateParser) obj; [EOL]     return pattern.equals(other.pattern) && timeZone.equals(other.timeZone) && locale.equals(other.locale); [EOL] } <line_num>: 187,196
@Override [EOL] public int hashCode() { [EOL]     return pattern.hashCode() + 13 * (timeZone.hashCode() + 13 * locale.hashCode()); [EOL] } <line_num>: 203,206
@Override [EOL] public String toString() { [EOL]     return "FastDateParser[" + pattern + "," + locale + "," + timeZone.getID() + "]"; [EOL] } <line_num>: 213,216
private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException { [EOL]     in.defaultReadObject(); [EOL]     init(); [EOL] } <line_num>: 228,231
@Override [EOL] public Object parseObject(final String source) throws ParseException { [EOL]     return parse(source); [EOL] } <line_num>: 236,239
@Override [EOL] public Date parse(final String source) throws ParseException { [EOL]     final Date date = parse(source, new ParsePosition(0)); [EOL]     if (date == null) { [EOL]         if (locale.equals(JAPANESE_IMPERIAL)) { [EOL]             throw new ParseException("(The " + locale + " locale does not support dates before 1868 AD)\n" + "Unparseable date: \"" + source + "\" does not match " + parsePattern.pattern(), 0); [EOL]         } [EOL]         throw new ParseException("Unparseable date: \"" + source + "\" does not match " + parsePattern.pattern(), 0); [EOL]     } [EOL]     return date; [EOL] } <line_num>: 244,257
@Override [EOL] public Object parseObject(final String source, final ParsePosition pos) { [EOL]     return parse(source, pos); [EOL] } <line_num>: 262,265
@Override [EOL] public Date parse(final String source, final ParsePosition pos) { [EOL]     final int offset = pos.getIndex(); [EOL]     final Matcher matcher = parsePattern.matcher(source.substring(offset)); [EOL]     if (!matcher.lookingAt()) { [EOL]         return null; [EOL]     } [EOL]     final Calendar cal = Calendar.getInstance(timeZone, locale); [EOL]     cal.clear(); [EOL]     for (int i = 0; i < strategies.length; ) { [EOL]         final Strategy strategy = strategies[i++]; [EOL]         strategy.setCalendar(this, cal, matcher.group(i)); [EOL]     } [EOL]     pos.setIndex(offset + matcher.end()); [EOL]     return cal.getTime(); [EOL] } <line_num>: 270,287
private static StringBuilder escapeRegex(final StringBuilder regex, final String value, final boolean unquote) { [EOL]     regex.append("\\Q"); [EOL]     for (int i = 0; i < value.length(); ++i) { [EOL]         char c = value.charAt(i); [EOL]         switch(c) { [EOL]             case '\'': [EOL]                 if (unquote) { [EOL]                     if (++i == value.length()) { [EOL]                         return regex; [EOL]                     } [EOL]                     c = value.charAt(i); [EOL]                 } [EOL]                 break; [EOL]             case '\\': [EOL]                 if (++i == value.length()) { [EOL]                     break; [EOL]                 } [EOL]                 regex.append(c); [EOL]                 c = value.charAt(i); [EOL]                 if (c == 'E') { [EOL]                     regex.append("E\\\\E\\"); [EOL]                     c = 'Q'; [EOL]                 } [EOL]                 break; [EOL]         } [EOL]         regex.append(c); [EOL]     } [EOL]     regex.append("\\E"); [EOL]     return regex; [EOL] } <line_num>: 299,335
private static Map<String, Integer> getDisplayNames(final int field, final Calendar definingCalendar, final Locale locale) { [EOL]     return definingCalendar.getDisplayNames(field, Calendar.ALL_STYLES, locale); [EOL] } <line_num>: 345,347
int adjustYear(final int twoDigitYear) { [EOL]     final int trial = twoDigitYear + thisYear - thisYear % 100; [EOL]     if (trial < thisYear + 20) { [EOL]         return trial; [EOL]     } [EOL]     return trial - 100; [EOL] } <line_num>: 354,360
boolean isNextNumber() { [EOL]     return nextStrategy != null && nextStrategy.isNumber(); [EOL] } <line_num>: 366,368
int getFieldWidth() { [EOL]     return currentFormatField.length(); [EOL] } <line_num>: 374,376
boolean isNumber() { [EOL]     return false; [EOL] } <line_num>: 388,390
void setCalendar(final FastDateParser parser, final Calendar cal, final String value) { [EOL] } <line_num>: 400,402
abstract boolean addRegex(FastDateParser parser, StringBuilder regex); <line_num>: 411,411
private Strategy getStrategy(String formatField, final Calendar definingCalendar) { [EOL]     switch(formatField.charAt(0)) { [EOL]         case '\'': [EOL]             if (formatField.length() > 2) { [EOL]                 formatField = formatField.substring(1, formatField.length() - 1); [EOL]             } [EOL]         default: [EOL]             return new CopyQuotedStrategy(formatField); [EOL]         case 'D': [EOL]             return DAY_OF_YEAR_STRATEGY; [EOL]         case 'E': [EOL]             return getLocaleSpecificStrategy(Calendar.DAY_OF_WEEK, definingCalendar); [EOL]         case 'F': [EOL]             return DAY_OF_WEEK_IN_MONTH_STRATEGY; [EOL]         case 'G': [EOL]             return getLocaleSpecificStrategy(Calendar.ERA, definingCalendar); [EOL]         case 'H': [EOL]             return MODULO_HOUR_OF_DAY_STRATEGY; [EOL]         case 'K': [EOL]             return HOUR_STRATEGY; [EOL]         case 'M': [EOL]             return formatField.length() >= 3 ? getLocaleSpecificStrategy(Calendar.MONTH, definingCalendar) : NUMBER_MONTH_STRATEGY; [EOL]         case 'S': [EOL]             return MILLISECOND_STRATEGY; [EOL]         case 'W': [EOL]             return WEEK_OF_MONTH_STRATEGY; [EOL]         case 'a': [EOL]             return getLocaleSpecificStrategy(Calendar.AM_PM, definingCalendar); [EOL]         case 'd': [EOL]             return DAY_OF_MONTH_STRATEGY; [EOL]         case 'h': [EOL]             return MODULO_HOUR_STRATEGY; [EOL]         case 'k': [EOL]             return HOUR_OF_DAY_STRATEGY; [EOL]         case 'm': [EOL]             return MINUTE_STRATEGY; [EOL]         case 's': [EOL]             return SECOND_STRATEGY; [EOL]         case 'w': [EOL]             return WEEK_OF_YEAR_STRATEGY; [EOL]         case 'y': [EOL]             return formatField.length() > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY; [EOL]         case 'Z': [EOL]         case 'z': [EOL]             return getLocaleSpecificStrategy(Calendar.ZONE_OFFSET, definingCalendar); [EOL]     } [EOL] } <line_num>: 426,473
private static ConcurrentMap<Locale, Strategy> getCache(final int field) { [EOL]     synchronized (caches) { [EOL]         if (caches[field] == null) { [EOL]             caches[field] = new ConcurrentHashMap<Locale, Strategy>(3); [EOL]         } [EOL]         return caches[field]; [EOL]     } [EOL] } <line_num>: 483,490
private Strategy getLocaleSpecificStrategy(final int field, final Calendar definingCalendar) { [EOL]     final ConcurrentMap<Locale, Strategy> cache = getCache(field); [EOL]     Strategy strategy = cache.get(locale); [EOL]     if (strategy == null) { [EOL]         strategy = field == Calendar.ZONE_OFFSET ? new TimeZoneStrategy(locale) : new TextStrategy(field, definingCalendar, locale); [EOL]         final Strategy inCache = cache.putIfAbsent(locale, strategy); [EOL]         if (inCache != null) { [EOL]             return inCache; [EOL]         } [EOL]     } [EOL]     return strategy; [EOL] } <line_num>: 498,511
@Override [EOL] boolean isNumber() { [EOL]     char c = formatField.charAt(0); [EOL]     if (c == '\'') { [EOL]         c = formatField.charAt(1); [EOL]     } [EOL]     return Character.isDigit(c); [EOL] } <line_num>: 530,537
@Override [EOL] boolean addRegex(final FastDateParser parser, final StringBuilder regex) { [EOL]     escapeRegex(regex, formatField, true); [EOL]     return false; [EOL] } <line_num>: 542,546
@Override [EOL] boolean addRegex(final FastDateParser parser, final StringBuilder regex) { [EOL]     regex.append('('); [EOL]     for (final String textKeyValue : keyValues.keySet()) { [EOL]         escapeRegex(regex, textKeyValue, false).append('|'); [EOL]     } [EOL]     regex.setCharAt(regex.length() - 1, ')'); [EOL]     return true; [EOL] } <line_num>: 570,578
@Override [EOL] void setCalendar(final FastDateParser parser, final Calendar cal, final String value) { [EOL]     final Integer iVal = keyValues.get(value); [EOL]     if (iVal == null) { [EOL]         final StringBuilder sb = new StringBuilder(value); [EOL]         sb.append(" not in ("); [EOL]         for (final String textKeyValue : keyValues.keySet()) { [EOL]             sb.append(textKeyValue).append(' '); [EOL]         } [EOL]         sb.setCharAt(sb.length() - 1, ')'); [EOL]         throw new IllegalArgumentException(sb.toString()); [EOL]     } [EOL]     cal.set(field, iVal.intValue()); [EOL] } <line_num>: 583,596
@Override [EOL] boolean isNumber() { [EOL]     return true; [EOL] } <line_num>: 617,620
@Override [EOL] boolean addRegex(final FastDateParser parser, final StringBuilder regex) { [EOL]     if (parser.isNextNumber()) { [EOL]         regex.append("(\\p{IsNd}{").append(parser.getFieldWidth()).append("}+)"); [EOL]     } else { [EOL]         regex.append("(\\p{IsNd}++)"); [EOL]     } [EOL]     return true; [EOL] } <line_num>: 625,634
@Override [EOL] void setCalendar(final FastDateParser parser, final Calendar cal, final String value) { [EOL]     cal.set(field, modify(Integer.parseInt(value))); [EOL] } <line_num>: 639,642
int modify(final int iValue) { [EOL]     return iValue; [EOL] } <line_num>: 649,651
@Override [EOL] void setCalendar(final FastDateParser parser, final Calendar cal, final String value) { [EOL]     int iValue = Integer.parseInt(value); [EOL]     if (iValue < 100) { [EOL]         iValue = parser.adjustYear(iValue); [EOL]     } [EOL]     cal.set(Calendar.YEAR, iValue); [EOL] } <line_num>: 658,665
@Override [EOL] boolean addRegex(final FastDateParser parser, final StringBuilder regex) { [EOL]     regex.append(validTimeZoneChars); [EOL]     return true; [EOL] } <line_num>: 705,709
@Override [EOL] void setCalendar(final FastDateParser parser, final Calendar cal, final String value) { [EOL]     TimeZone tz; [EOL]     if (value.charAt(0) == '+' || value.charAt(0) == '-') { [EOL]         tz = TimeZone.getTimeZone("GMT" + value); [EOL]     } else if (value.startsWith("GMT")) { [EOL]         tz = TimeZone.getTimeZone(value); [EOL]     } else { [EOL]         tz = tzNames.get(value); [EOL]         if (tz == null) { [EOL]             throw new IllegalArgumentException(value + " is not a supported timezone name"); [EOL]         } [EOL]     } [EOL]     cal.setTimeZone(tz); [EOL] } <line_num>: 714,730
@Override [EOL] int modify(final int iValue) { [EOL]     return iValue - 1; [EOL] } <line_num>: 734,737
@Override [EOL] int modify(final int iValue) { [EOL]     return iValue % 24; [EOL] } <line_num>: 747,750
@Override [EOL] int modify(final int iValue) { [EOL]     return iValue % 12; [EOL] } <line_num>: 753,756