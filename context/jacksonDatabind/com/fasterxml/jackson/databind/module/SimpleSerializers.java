public SimpleSerializers()
public SimpleSerializers(List<JsonSerializer<?>> sers)
public void addSerializer(JsonSerializer<?> ser)
public void addSerializer(Class<? extends T> type, JsonSerializer<T> ser)
public void addSerializers(List<JsonSerializer<?>> sers)
private void _addSerializer(Class<?> cls, JsonSerializer<?> ser)
public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc)
public JsonSerializer<?> findArraySerializer(SerializationConfig config, ArrayType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
public JsonSerializer<?> findCollectionSerializer(SerializationConfig config, CollectionType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig config, CollectionLikeType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
public JsonSerializer<?> findMapSerializer(SerializationConfig config, MapType type, BeanDescription beanDesc, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
public JsonSerializer<?> findMapLikeSerializer(SerializationConfig config, MapLikeType type, BeanDescription beanDesc, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
protected JsonSerializer<?> _findInterfaceMapping(Class<?> cls, ClassKey key)
long serialVersionUID=Optional[8531646511998456779L]
HashMap<ClassKey, JsonSerializer<?>> _classMappings=Optional[null]
HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings=Optional[null]