public AstParallelizer(Predicate<Node> shouldSplit, Predicate<Node> shouldTraverse, Supplier<Node> placeHolderProvider, Node root, boolean includeRoot)
private DetachPoint(Node placeHolder, Node before, Node original)
public boolean apply(Node input)
public boolean apply(Node ignored)
public Node get()
public static AstParallelizer createNewFunctionLevelAstParallelizer(Node root, boolean globalPass)
public boolean apply(Node input)
public Node get()
public boolean apply(Node n)
public static AstParallelizer createNewFileLevelAstParallelizer(Node root)
private void recordSplitPoint(Node placeHolder, Node before, Node original)
public List<Node> split()
private void split(Node n)
public void join()
public void reattach()
String TEMP_NAME=Optional["JSC_TMP_PLACE_HOLDER"]
Predicate<Node> shouldSplit
Supplier<Node> placeHolderProvider
List<Node> forest
Node root
boolean includeRoot
List<DetachPoint> detachPointList
