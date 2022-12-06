 NumberNode(double number)
public NumberNode(double number, int lineno, int charno)
 StringNode(int type, String str)
 StringNode(int type, String str, int lineno, int charno)
 AbstractPropListItem(int propType, PropListItem next)
 ObjectPropListItem(int propType, Object objectValue, PropListItem next)
 IntPropListItem(int propType, int intValue, PropListItem next)
public Node(int nodeType)
public Node(int nodeType, Node child)
public Node(int nodeType, Node left, Node right)
public Node(int nodeType, Node left, Node mid, Node right)
public Node(int nodeType, Node left, Node mid, Node mid2, Node right)
public Node(int nodeType, int lineno, int charno)
public Node(int nodeType, Node child, int lineno, int charno)
public Node(int nodeType, Node left, Node right, int lineno, int charno)
public Node(int nodeType, Node left, Node mid, Node right, int lineno, int charno)
public Node(int nodeType, Node left, Node mid, Node mid2, Node right, int lineno, int charno)
public Node(int nodeType, Node[] children, int lineno, int charno)
public Node(int nodeType, Node[] children)
 SiblingNodeIterable(Node start)
 AncestorIterable(Node cur)
public SideEffectFlags()
public SideEffectFlags(int value)
 NodeMismatch(Node nodeA, Node nodeB)
private static final String propToString(int propType)
public double getDouble()
public void setDouble(double d)
 boolean isEquivalentTo(Node node, boolean compareJsType, boolean recurse)
public String getString()
public void setString(String str)
 boolean isEquivalentTo(Node node, boolean compareJsType, boolean recurse)
public boolean isQuotedString()
public void setQuotedString()
 int getType()
 PropListItem getNext()
 PropListItem chain(PropListItem next)
 Object getObjectValue()
 int getIntValue()
public int getType()
public PropListItem getNext()
public abstract PropListItem chain(PropListItem next)
public int getIntValue()
public Object getObjectValue()
public String toString()
public PropListItem chain(PropListItem next)
public int getIntValue()
public Object getObjectValue()
public String toString()
public PropListItem chain(PropListItem next)
public static Node newNumber(double number)
public static Node newNumber(double number, int lineno, int charno)
public static Node newString(String str)
public static Node newString(int type, String str)
public static Node newString(String str, int lineno, int charno)
public static Node newString(int type, String str, int lineno, int charno)
public int getType()
public void setType(int type)
public boolean hasChildren()
public Node getFirstChild()
public Node getLastChild()
public Node getNext()
public Node getChildBefore(Node child)
public Node getChildAtIndex(int i)
public int getIndexOfChild(Node child)
public Node getLastSibling()
public void addChildToFront(Node child)
public void addChildToBack(Node child)
public void addChildrenToFront(Node children)
public void addChildrenToBack(Node children)
public void addChildBefore(Node newChild, Node node)
public void addChildAfter(Node newChild, Node node)
public void addChildrenAfter(Node children, Node node)
public void removeChild(Node child)
public void replaceChild(Node child, Node newChild)
public void replaceChildAfter(Node prevChild, Node newChild)
 PropListItem lookupProperty(int propType)
public Node clonePropsFrom(Node other)
public void removeProp(int propType)
private PropListItem removeProp(PropListItem item, int propType)
public Object getProp(int propType)
public boolean getBooleanProp(int propType)
public int getIntProp(int propType)
public int getExistingIntProp(int propType)
public void putProp(int propType, Object value)
public void putBooleanProp(int propType, boolean value)
public void putIntProp(int propType, int value)
 PropListItem createProp(int propType, Object value, PropListItem next)
 PropListItem createProp(int propType, int value, PropListItem next)
private int[] getSortedPropTypes()
public double getDouble() throws UnsupportedOperationException
public void setDouble(double s) throws UnsupportedOperationException
public String getString() throws UnsupportedOperationException
public void setString(String s) throws UnsupportedOperationException
public String toString()
public String toString(boolean printSource, boolean printAnnotations, boolean printType)
private void toString(StringBuilder sb, boolean printSource, boolean printAnnotations, boolean printType)
public String toStringTree()
private String toStringTreeImpl()
public void appendStringTree(Appendable appendable) throws IOException
private static void toStringTreeHelper(Node n, int level, Appendable sb) throws IOException
public void setStaticSourceFile(StaticSourceFile file)
public void setSourceFileForTesting(String name)
public String getSourceFileName()
public StaticSourceFile getStaticSourceFile()
public void setInputId(InputId inputId)
public InputId getInputId()
public boolean isFromExterns()
public int getLength()
public void setLength(int length)
public int getLineno()
public int getCharno()
public int getSourceOffset()
public int getSourcePosition()
public void setLineno(int lineno)
public void setCharno(int charno)
public void setSourceEncodedPosition(int sourcePosition)
public void setSourceEncodedPositionForTree(int sourcePosition)
protected static int mergeLineCharNo(int lineno, int charno)
protected static int extractLineno(int lineCharNo)
protected static int extractCharno(int lineCharNo)
public Iterable<Node> children()
public Iterable<Node> siblings()
public Iterator<Node> iterator()
public boolean hasNext()
public Node next()
public void remove()
 PropListItem getPropListHeadForTesting()
public Node getParent()
public Node getAncestor(int level)
public AncestorIterable getAncestors()
public boolean hasNext()
public Node next()
public void remove()
public Iterator<Node> iterator()
public boolean hasOneChild()
public boolean hasMoreThanOneChild()
public int getChildCount()
public boolean hasChild(Node child)
public String checkTreeEquals(Node node2)
 NodeMismatch checkTreeEqualsImpl(Node node2)
 NodeMismatch checkTreeTypeAwareEqualsImpl(Node node2)
public boolean isEquivalentTo(Node node)
public boolean isEquivalentToTyped(Node node)
 boolean isEquivalentTo(Node node, boolean compareJsType, boolean recurse)
public String getQualifiedName()
public boolean isQualifiedName()
public boolean isUnscopedQualifiedName()
public Node detachFromParent()
public Node removeFirstChild()
public Node removeChildren()
public void detachChildren()
public Node removeChildAfter(Node prev)
public Node cloneNode()
public Node cloneTree()
public Node copyInformationFrom(Node other)
public Node copyInformationFromForTree(Node other)
public Node useSourceInfoFrom(Node other)
public Node srcref(Node other)
public Node useSourceInfoFromForTree(Node other)
public Node srcrefTree(Node other)
public Node useSourceInfoIfMissingFrom(Node other)
public Node useSourceInfoIfMissingFromForTree(Node other)
public JSType getJSType()
public void setJSType(JSType jsType)
public FileLevelJsDocBuilder getJsDocBuilderForNode()
public void append(String fileLevelComment)
public JSDocInfo getJSDocInfo()
public Node setJSDocInfo(JSDocInfo info)
public void setVarArgs(boolean varArgs)
public boolean isVarArgs()
public void setOptionalArg(boolean optionalArg)
public boolean isOptionalArg()
public void setIsSyntheticBlock(boolean val)
public boolean isSyntheticBlock()
public void setDirectives(Set<String> val)
public Set<String> getDirectives()
public void addSuppression(String warning)
public void setWasEmptyNode(boolean val)
public boolean wasEmptyNode()
public void setSideEffectFlags(int flags)
public void setSideEffectFlags(SideEffectFlags flags)
public int getSideEffectFlags()
public int valueOf()
public void setAllFlags()
public void clearAllFlags()
public boolean areAllFlagsSet()
public void clearSideEffectFlags()
public void setMutatesGlobalState()
public void setThrows()
public void setMutatesThis()
public void setMutatesArguments()
public void setReturnsTainted()
private void removeFlag(int flag)
public boolean isOnlyModifiesThisCall()
public boolean isNoSideEffectsCall()
public boolean isLocalResultCall()
private boolean areBitFlagsSet(int value, int flags)
public boolean isQuotedString()
public void setQuotedString()
public boolean equals(Object object)
public int hashCode()
public boolean isAdd()
public boolean isAnd()
public boolean isArrayLit()
public boolean isAssign()
public boolean isAssignAdd()
public boolean isBlock()
public boolean isBreak()
public boolean isCall()
public boolean isCase()
public boolean isCast()
public boolean isCatch()
public boolean isComma()
public boolean isContinue()
public boolean isDebugger()
public boolean isDec()
public boolean isDefaultCase()
public boolean isDelProp()
public boolean isDo()
public boolean isEmpty()
public boolean isExprResult()
public boolean isFalse()
public boolean isFor()
public boolean isFunction()
public boolean isGetterDef()
public boolean isGetElem()
public boolean isGetProp()
public boolean isHook()
public boolean isIf()
public boolean isIn()
public boolean isInc()
public boolean isInstanceOf()
public boolean isLabel()
public boolean isLabelName()
public boolean isName()
public boolean isNE()
public boolean isNew()
public boolean isNot()
public boolean isNull()
public boolean isNumber()
public boolean isObjectLit()
public boolean isOr()
public boolean isParamList()
public boolean isRegExp()
public boolean isReturn()
public boolean isScript()
public boolean isSetterDef()
public boolean isString()
public boolean isStringKey()
public boolean isSwitch()
public boolean isThis()
public boolean isThrow()
public boolean isTrue()
public boolean isTry()
public boolean isTypeOf()
public boolean isVar()
public boolean isVoid()
public boolean isWhile()
public boolean isWith()