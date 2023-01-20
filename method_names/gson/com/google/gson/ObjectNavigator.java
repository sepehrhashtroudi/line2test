 ObjectNavigator(ObjectTypePair objTypePair, ExclusionStrategy exclusionStrategy)
public void start(ObjectTypePair node)
public void end(ObjectTypePair node)
 void startVisitingObject(Object node)
 void visitArray(Object array, Type componentType)
 void visitObjectField(FieldAttributes f, Type typeOfF, Object obj)
 void visitArrayField(FieldAttributes f, Type typeOfF, Object obj)
public boolean visitUsingCustomHandler(ObjectTypePair objTypePair)
public boolean visitFieldUsingCustomHandler(FieldAttributes f, Type actualTypeOfField, Object parent)
 Object getTarget()
 void visitPrimitive(Object primitive)
public void accept(Visitor visitor)
private boolean isPrimitiveOrString(Object objectToVisit)
private void navigateClassFields(Object obj, Class<?> clazz, Visitor visitor)
