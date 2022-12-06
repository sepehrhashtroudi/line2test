public CompilerPass getProcessor(Compiler compiler)
public void testWhile()
public void testNextedWhile()
public void testBreak()
public void testContinue()
public void testBreakCrossFunction()
public void testBreakCrossFunctionInFor()
public void testContinueToSwitch()
public void testContinueToSwitchWithNoCases()
public void testContinueToSwitchWithTwoCases()
public void testContinueToSwitchWithDefault()
public void testContinueToLabelSwitch()
public void testContinueOutsideSwitch()
public void testContinueNotCrossFunction1()
public void testContinueNotCrossFunction2()
public void testUseOfWith1()
public void testUseOfWith2()
public void testUseOfWith3()
private void assertNoError(String js)
private void assertInvalidBreak(String js)
private void assertInvalidContinue(String js)
private void assertInvalidLabeledContinue(String js)
private void assertUndefinedLabel(String js)
private void testParseError(String js, String errorText)