public ModificationVisitor(JSTypeRegistry registry)
public JSType caseNoType()
public JSType caseEnumElementType(EnumElementType type)
public JSType caseAllType()
public JSType caseBooleanType()
public JSType caseNoObjectType()
public JSType caseFunctionType(FunctionType type)
private JSType coerseToThisType(JSType type)
public JSType caseObjectType(ObjectType objType)
public JSType caseParameterizedType(ParameterizedType type)
public JSType caseUnknownType()
public JSType caseNullType()
public JSType caseNumberType()
public JSType caseStringType()
public JSType caseVoidType()
public JSType caseUnionType(UnionType type)
public JSType caseTemplateType(TemplateType type)
private JSType getNativeType(JSTypeNative nativeType)
private boolean isNativeFunctionType(FunctionType type)
JSTypeRegistry registry
