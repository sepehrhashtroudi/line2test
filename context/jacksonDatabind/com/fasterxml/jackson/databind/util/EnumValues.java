private EnumValues(Class<Enum<?>> enumClass, Map<Enum<?>, SerializedString> v)
public static EnumValues construct(Class<Enum<?>> enumClass, AnnotationIntrospector intr)
public static EnumValues constructFromName(Class<Enum<?>> enumClass, AnnotationIntrospector intr)
public static EnumValues constructFromToString(Class<Enum<?>> enumClass, AnnotationIntrospector intr)
public SerializedString serializedValueFor(Enum<?> key)
public Collection<SerializedString> values()
public EnumMap<?, SerializedString> internalMap()
public Class<Enum<?>> getEnumClass()
Class<Enum<?>> _enumClass
EnumMap<?, SerializedString> _values
