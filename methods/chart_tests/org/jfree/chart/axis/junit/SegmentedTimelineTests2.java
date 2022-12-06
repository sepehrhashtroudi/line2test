public SegmentedTimelineTests2() { [EOL]     super(); [EOL] } <line_num>: 61,63
public void test1() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Locale savedLocale = Locale.getDefault(); [EOL]     Locale.setDefault(Locale.UK); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 26); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 0); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     assertTrue("test1", value == (900000 * 34) && date.getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL]     Locale.setDefault(savedLocale); [EOL] } <line_num>: 69,94
public void test2() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 26); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 15); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     assertTrue("test2", value == (900000 * 34 + 900000) && date.getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 100,125
public void test3() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 26); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 30); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     assertTrue("test2", value == (900000 * 34 + 900000 * 2) && date.getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 131,156
public void test4() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 26); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 30); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 1); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     assertTrue("test4", value == (900000 * 34 + 900000 * 2 + 1) && date.getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 163,187
public void test5() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 25); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 17); [EOL]     cal.set(Calendar.MINUTE, 30); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     Calendar expectedReverted = Calendar.getInstance(Locale.UK); [EOL]     expectedReverted.set(Calendar.YEAR, 2004); [EOL]     expectedReverted.set(Calendar.MONTH, Calendar.MARCH); [EOL]     expectedReverted.set(Calendar.DAY_OF_MONTH, 26); [EOL]     expectedReverted.set(Calendar.HOUR_OF_DAY, 9); [EOL]     expectedReverted.set(Calendar.MINUTE, 0); [EOL]     expectedReverted.set(Calendar.SECOND, 0); [EOL]     expectedReverted.set(Calendar.MILLISECOND, 0); [EOL]     assertTrue("test5", value == (900000 * 34) && expectedReverted.getTime().getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 195,228
public void test6() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 28); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 0); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     Calendar expectedReverted = Calendar.getInstance(Locale.UK); [EOL]     expectedReverted.set(Calendar.YEAR, 2004); [EOL]     expectedReverted.set(Calendar.MONTH, Calendar.MARCH); [EOL]     expectedReverted.set(Calendar.DAY_OF_MONTH, 29); [EOL]     expectedReverted.set(Calendar.HOUR_OF_DAY, 9); [EOL]     expectedReverted.set(Calendar.MINUTE, 0); [EOL]     expectedReverted.set(Calendar.SECOND, 0); [EOL]     expectedReverted.set(Calendar.MILLISECOND, 0); [EOL]     assertTrue("test6", value == (900000 * 34 * 2) && expectedReverted.getTime().getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 236,270
public void test7() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 29); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 0); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     Calendar expectedReverted = Calendar.getInstance(); [EOL]     expectedReverted.set(Calendar.YEAR, 2004); [EOL]     expectedReverted.set(Calendar.MONTH, Calendar.MARCH); [EOL]     expectedReverted.set(Calendar.DAY_OF_MONTH, 29); [EOL]     expectedReverted.set(Calendar.HOUR_OF_DAY, 9); [EOL]     expectedReverted.set(Calendar.MINUTE, 0); [EOL]     expectedReverted.set(Calendar.SECOND, 0); [EOL]     expectedReverted.set(Calendar.MILLISECOND, 0); [EOL]     assertTrue("test7", value == (900000 * 34 * 2) && expectedReverted.getTime().getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 276,311
public void test8() { [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 29); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 10); [EOL]     cal.set(Calendar.MINUTE, 0); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date date = cal.getTime(); [EOL]     SegmentedTimeline timeline = getTimeline(); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 29); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 15); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     timeline.addException(cal.getTime()); [EOL]     long value = timeline.toTimelineValue(date); [EOL]     long ms = timeline.toMillisecond(value); [EOL]     Calendar cal2 = Calendar.getInstance(Locale.UK); [EOL]     cal2.setTime(new Date(ms)); [EOL]     Date reverted = cal2.getTime(); [EOL]     Calendar expectedReverted = Calendar.getInstance(); [EOL]     expectedReverted.set(Calendar.YEAR, 2004); [EOL]     expectedReverted.set(Calendar.MONTH, Calendar.MARCH); [EOL]     expectedReverted.set(Calendar.DAY_OF_MONTH, 29); [EOL]     expectedReverted.set(Calendar.HOUR_OF_DAY, 10); [EOL]     expectedReverted.set(Calendar.MINUTE, 0); [EOL]     expectedReverted.set(Calendar.SECOND, 0); [EOL]     expectedReverted.set(Calendar.MILLISECOND, 0); [EOL]     assertTrue("test8", value == (900000 * 34 * 2 + 900000 * (4 - 1)) && expectedReverted.getTime().getTime() == reverted.getTime()); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 316,362
private SegmentedTimeline getTimeline() { [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 25); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 0); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date from = cal.getTime(); [EOL]     cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 2004); [EOL]     cal.set(Calendar.MONTH, Calendar.MARCH); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 30); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 17); [EOL]     cal.set(Calendar.MINUTE, 30); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date to = cal.getTime(); [EOL]     return getTimeline(from, to); [EOL] } <line_num>: 370,392
private SegmentedTimeline getTimeline(Date start, Date end) { [EOL]     Calendar cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 1970); [EOL]     cal.set(Calendar.MONTH, Calendar.JANUARY); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 1); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 9); [EOL]     cal.set(Calendar.MINUTE, 0); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date open = cal.getTime(); [EOL]     cal = Calendar.getInstance(Locale.UK); [EOL]     cal.set(Calendar.YEAR, 1970); [EOL]     cal.set(Calendar.MONTH, Calendar.JANUARY); [EOL]     cal.set(Calendar.DAY_OF_MONTH, 1); [EOL]     cal.set(Calendar.HOUR_OF_DAY, 17); [EOL]     cal.set(Calendar.MINUTE, 30); [EOL]     cal.set(Calendar.SECOND, 0); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Date close = cal.getTime(); [EOL]     SegmentedTimeline result = null; [EOL]     long quarterHourCount = (close.getTime() - open.getTime()) / SegmentedTimeline.FIFTEEN_MINUTE_SEGMENT_SIZE; [EOL]     long totalQuarterHourCount = SegmentedTimeline.DAY_SEGMENT_SIZE / SegmentedTimeline.FIFTEEN_MINUTE_SEGMENT_SIZE; [EOL]     result = new SegmentedTimeline(SegmentedTimeline.FIFTEEN_MINUTE_SEGMENT_SIZE, (int) quarterHourCount, (int) (totalQuarterHourCount - quarterHourCount)); [EOL]     result.setAdjustForDaylightSaving(true); [EOL]     result.setStartTime(start.getTime()); [EOL]     result.setBaseTimeline(SegmentedTimeline.newMondayThroughFridayTimeline()); [EOL]     if (start != null && end != null) { [EOL]         result.addBaseTimelineExclusions(start.getTime(), end.getTime()); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 403,449