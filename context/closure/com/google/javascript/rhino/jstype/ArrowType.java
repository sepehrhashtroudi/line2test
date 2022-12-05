 ArrowType(JSTypeRegistry registry, Node parameters, JSType returnType)
 ArrowType(JSTypeRegistry registry, Node parameters, JSType returnType, boolean returnTypeInferred)
public boolean isSubtype(JSType other)
 boolean hasEqualParameters(ArrowType that, EquivalenceMethod eqMethod)
 boolean checkArrowEquivalenceHelper(ArrowType that, EquivalenceMethod eqMethod)
public int hashCode()
public JSType getLeastSupertype(JSType that)
public JSType getGreatestSubtype(JSType that)
public TernaryValue testForEquality(JSType that)
public T visit(Visitor<T> visitor)
 T visit(RelationshipVisitor<T> visitor, JSType that)
public BooleanLiteralSet getPossibleToBooleanOutcomes()
 JSType resolveInternal(ErrorReporter t, StaticScope<JSType> scope)
 boolean hasUnknownParamsOrReturn()
 String toStringHelper(boolean forAnnotations)
public boolean hasAnyTemplateTypesInternal()
private boolean hasTemplatedParameterType()
long serialVersionUID=Optional[1L]
Node parameters
JSType returnType
boolean returnTypeInferred
