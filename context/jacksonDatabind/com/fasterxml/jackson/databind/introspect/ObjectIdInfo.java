public ObjectIdInfo(String prop, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen)
protected ObjectIdInfo(String prop, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen, boolean alwaysAsId)
public ObjectIdInfo withAlwaysAsId(boolean state)
public String getPropertyName()
public Class<?> getScope()
public Class<? extends ObjectIdGenerator<?>> getGeneratorType()
public boolean getAlwaysAsId()
public String toString()
String _propertyName
Class<? extends ObjectIdGenerator<?>> _generator
Class<?> _scope
boolean _alwaysAsId
