public InlineVariablesTest()
public void setUp()
protected CompilerPass getProcessor(final Compiler compiler)
public void tearDown()
public void testInlineGlobal()
public void testNoInlineExportedName()
public void testNoInlineExportedName2()
public void testDoNotInlineIncrement()
public void testDoNotInlineDecrement()
public void testDoNotInlineIntoLhsOfAssign()
public void testInlineIntoRhsOfAssign()
public void testInlineInFunction()
public void testInlineInFunction2()
public void testInlineInFunction3()
public void testInlineInFunction4()
public void testInlineInFunction5()
public void testInlineAcrossModules()
public void testDoNotExitConditional1()
public void testDoNotExitConditional2()
public void testDoNotExitConditional3()
public void testDoNotExitLoop()
public void testDoNotExitForLoop()
public void testDoNotEnterSubscope()
public void testDoNotExitTry()
public void testDoNotEnterCatch()
public void testDoNotEnterFinally()
public void testInsideIfConditional()
public void testOnlyReadAtInitialization()
public void testImmutableWithSingleReferenceAfterInitialzation()
public void testSingleReferenceAfterInitialzation()
public void testInsideIfBranch()
public void testInsideAndConditional()
public void testInsideAndBranch()
public void testInsideOrBranch()
public void testInsideHookBranch()
public void testInsideHookConditional()
public void testInsideOrBranchInsideIfConditional()
public void testInsideOrBranchInsideIfConditionalWithConstant()
public void testCrossFunctionsAsLeftLeaves()
public void testDoCrossFunction()
public void testDoNotCrossReferencingFunction()
public void testChainedAssignment()
public void testForIn()
public void testDoCrossNewVariables()
public void testDoNotCrossFunctionCalls()
public void testDoNotCrossAssignment()
public void testDoNotCrossDelete()
public void testDoNotCrossAssignmentPlus()
public void testDoNotCrossIncrement()
public void testDoNotCrossConstructor()
public void testDoCrossVar()
public void testOverlappingInlines()
public void testOverlappingInlineFunctions()
public void testInlineIntoLoops()
public void testInlineIntoFunction()
public void testNoInlineIntoNamedFunction()
public void testInlineIntoNestedNonHoistedNamedFunctions()
public void testNoInlineIntoNestedNamedFunctions()
public void testNoInlineMutatedVariable()
public void testInlineImmutableMultipleTimes()
public void testNoInlineStringMultipleTimesIfNotWorthwhile()
public void testInlineStringMultipleTimesWhenAliasingAllStrings()
public void testNoInlineBackwards()
public void testNoInlineOutOfBranch()
public void testInterferingInlines()
public void testInlineIntoTryCatch()
public void testInlineConstants()
public void testInlineStringWhenWorthwhile()
public void testInlineConstantAlias()
public void testInlineConstantAliasWithAnnotation()
public void testInlineConstantAliasWithNonConstant()
public void testCascadingInlines()
public void testNoInlineGetpropIntoCall()
public void testInlineFunctionDeclaration()
public void test2388531()
public void testRecursiveFunction1()
public void testRecursiveFunction2()
public void testUnreferencedBleedingFunction()
public void testReferencedBleedingFunction()
public void testInlineAliases1()
public void testInlineAliases1b()
public void testInlineAliases1c()
public void testInlineAliases1d()
public void testInlineAliases2()
public void testInlineAliases2b()
public void testInlineAliases2c()
public void testInlineAliases2d()
public void testInlineAliasesInLoop()
public void testNoInlineAliasesInLoop()
public void testNoInlineAliases1()
public void testNoInlineAliases1b()
public void testNoInlineAliases2()
public void testNoInlineAliases2b()
public void testNoInlineAliases3()
public void testNoInlineAliases3b()
public void testNoInlineAliases4()
public void testNoInlineAliases4b()
public void testNoInlineAliases5()
public void testNoInlineAliases5b()
public void testNoInlineAliases6()
public void testNoInlineAliases6b()
public void testNoInlineAliases7()
public void testNoInlineAliases7b()
public void testNoInlineAliases8()
public void testNoInlineAliases8b()
public void testSideEffectOrder()
public void testInlineParameterAlias1()
public void testInlineParameterAlias2()
public void testInlineFunctionAlias1a()
public void testInlineFunctionAlias1b()
public void testInlineFunctionAlias2a()
public void testInlineFunctionAlias2b()
public void testInlineCatchAlias1()
public void testInlineCatchAlias2()
public void testLocalsOnly1()
public void testLocalsOnly2()
public void testInlineUndefined1()
public void testInlineUndefined2()
public void testInlineUndefined3()
public void testInlineUndefined4()
public void testInlineUndefined5()
public void testIssue90()
public void testRenamePropertyFunction()
public void testThisAlias()
public void testThisEscapedAlias()
public void testInlineNamedFunction()
public void testIssue378ModifiedArguments1()
public void testIssue378ModifiedArguments2()
public void testIssue378EscapedArguments1()
public void testIssue378EscapedArguments2()
public void testIssue378EscapedArguments3()
public void testIssue378EscapedArguments4()
public void testIssue378ArgumentsRead1()
public void testIssue378ArgumentsRead2()
public void testArgumentsModifiedInOuterFunction()
public void testArgumentsModifiedInInnerFunction()
public void testNoInlineRedeclaredExterns()
public void testBug6598844()
