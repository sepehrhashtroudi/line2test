public ClosureCodingConvention()
public ClosureCodingConvention(CodingConvention wrapped)
public AssertInstanceofSpec(String functionName)
public void applySubclassRelationship(FunctionType parentCtor, FunctionType childCtor, SubclassType type)
public SubclassRelationship getClassesDefinedByCall(Node callNode)
private SubclassType typeofClassDefiningName(Node callName)
public boolean isSuperClassReference(String propertyName)
private boolean endsWithPrototype(Node qualifiedName)
public String extractClassNameIfProvide(Node node, Node parent)
public String extractClassNameIfRequire(Node node, Node parent)
private static String extractClassNameIfGoog(Node node, Node parent, String functionName)
public String getExportPropertyFunction()
public String getExportSymbolFunction()
public List<String> identifyTypeDeclarationCall(Node n)
public String getAbstractMethodName()
public String getSingletonGetterClassName(Node callNode)
public void applySingletonGetter(FunctionType functionType, FunctionType getterType, ObjectType objectType)
public String getGlobalObject()
public boolean isPropertyTestFunction(Node call)
public ObjectLiteralCast getObjectLiteralCast(Node callNode)
public boolean isOptionalParameter(Node parameter)
public boolean isVarArgsParameter(Node parameter)
public boolean isPrivate(String name)
public Collection<AssertionFunctionSpec> getAssertionFunctions()
public Bind describeFunctionBind(Node n, boolean useTypeInfo)
public Collection<String> getIndirectlyDeclaredProperties()
private Node safeNext(Node n)
public JSType getAssertedType(Node call, JSTypeRegistry registry)
long serialVersionUID=Optional[1L]
DiagnosticType OBJECTLIT_EXPECTED=Optional[DiagnosticType.warning("JSC_REFLECT_OBJECTLIT_EXPECTED", "Object literal expected as second argument")]
Set<String> indirectlyDeclaredProperties
Set<String> propertyTestFunctions=Optional[ImmutableSet.of("goog.isDef", "goog.isNull", "goog.isDefAndNotNull", "goog.isString", "goog.isNumber", "goog.isBoolean", "goog.isFunction", "goog.isArray", "goog.isObject")]