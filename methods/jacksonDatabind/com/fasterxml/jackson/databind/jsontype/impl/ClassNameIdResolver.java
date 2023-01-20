public ClassNameIdResolver(JavaType baseType, TypeFactory typeFactory) { [EOL]     super(baseType, typeFactory); [EOL] } <line_num>: 19,21
@Override [EOL] public JsonTypeInfo.Id getMechanism() { [EOL]     return JsonTypeInfo.Id.CLASS; [EOL] } <line_num>: 23,24
public void registerSubtype(Class<?> type, String name) { [EOL] } <line_num>: 26,28
@Override [EOL] public String idFromValue(Object value) { [EOL]     return _idFrom(value, value.getClass()); [EOL] } <line_num>: 30,33
@Override [EOL] public String idFromValueAndType(Object value, Class<?> type) { [EOL]     return _idFrom(value, type); [EOL] } <line_num>: 35,38
@Override [EOL] public JavaType typeFromId(String id) { [EOL]     if (id.indexOf('<') > 0) { [EOL]         JavaType t = _typeFactory.constructFromCanonical(id); [EOL]         return t; [EOL]     } [EOL]     try { [EOL]         Class<?> cls = ClassUtil.findClass(id); [EOL]         return _typeFactory.constructSpecializedType(_baseType, cls); [EOL]     } catch (ClassNotFoundException e) { [EOL]         throw new IllegalArgumentException("Invalid type id '" + id + "' (for id type 'Id.class'): no such class found"); [EOL]     } catch (Exception e) { [EOL]         throw new IllegalArgumentException("Invalid type id '" + id + "' (for id type 'Id.class'): " + e.getMessage(), e); [EOL]     } [EOL] } <line_num>: 40,60
protected final String _idFrom(Object value, Class<?> cls) { [EOL]     if (Enum.class.isAssignableFrom(cls)) { [EOL]         if (!cls.isEnum()) { [EOL]             cls = cls.getSuperclass(); [EOL]         } [EOL]     } [EOL]     String str = cls.getName(); [EOL]     if (str.startsWith("java.util")) { [EOL]         if (value instanceof EnumSet<?>) { [EOL]             Class<?> enumClass = ClassUtil.findEnumType((EnumSet<?>) value); [EOL]             str = TypeFactory.defaultInstance().constructCollectionType(EnumSet.class, enumClass).toCanonical(); [EOL]         } else if (value instanceof EnumMap<?, ?>) { [EOL]             Class<?> enumClass = ClassUtil.findEnumType((EnumMap<?, ?>) value); [EOL]             Class<?> valueClass = Object.class; [EOL]             str = TypeFactory.defaultInstance().constructMapType(EnumMap.class, enumClass, valueClass).toCanonical(); [EOL]         } else { [EOL]             String end = str.substring(9); [EOL]             if ((end.startsWith(".Arrays$") || end.startsWith(".Collections$")) && str.indexOf("List") >= 0) { [EOL]                 str = "java.util.ArrayList"; [EOL]             } [EOL]         } [EOL]     } else if (str.indexOf('$') >= 0) { [EOL]         Class<?> outer = ClassUtil.getOuterClass(cls); [EOL]         if (outer != null) { [EOL]             Class<?> staticType = _baseType.getRawClass(); [EOL]             if (ClassUtil.getOuterClass(staticType) == null) { [EOL]                 cls = _baseType.getRawClass(); [EOL]                 str = cls.getName(); [EOL]             } [EOL]         } [EOL]     } [EOL]     return str; [EOL] } <line_num>: 68,131
