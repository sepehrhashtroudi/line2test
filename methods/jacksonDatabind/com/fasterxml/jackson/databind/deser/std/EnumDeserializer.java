public EnumDeserializer(EnumResolver<?> res) { [EOL]     super(Enum.class); [EOL]     _resolver = res; [EOL] } <line_num>: 27,31
public FactoryBasedDeserializer(Class<?> cls, AnnotatedMethod f, Class<?> inputType) { [EOL]     super(Enum.class); [EOL]     _enumClass = cls; [EOL]     _factory = f.getAnnotated(); [EOL]     _inputType = inputType; [EOL] } <line_num>: 137,144
public static JsonDeserializer<?> deserializerForCreator(DeserializationConfig config, Class<?> enumClass, AnnotatedMethod factory) { [EOL]     Class<?> paramClass = factory.getRawParameterType(0); [EOL]     if (paramClass == String.class) { [EOL]         paramClass = null; [EOL]     } else if (paramClass == Integer.TYPE || paramClass == Integer.class) { [EOL]         paramClass = Integer.class; [EOL]     } else if (paramClass == Long.TYPE || paramClass == Long.class) { [EOL]         paramClass = Long.class; [EOL]     } else { [EOL]         throw new IllegalArgumentException("Parameter #0 type for factory method (" + factory + ") not suitable, must be java.lang.String or int/Integer/long/Long"); [EOL]     } [EOL]     if (config.canOverrideAccessModifiers()) { [EOL]         ClassUtil.checkAndFixAccess(factory.getMember()); [EOL]     } [EOL]     return new FactoryBasedDeserializer(enumClass, factory, paramClass); [EOL] } <line_num>: 40,59
@Override [EOL] public boolean isCachable() { [EOL]     return true; [EOL] } <line_num>: 71,72
@Override [EOL] public Enum<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     JsonToken curr = jp.getCurrentToken(); [EOL]     if (curr == JsonToken.VALUE_STRING || curr == JsonToken.FIELD_NAME) { [EOL]         String name = jp.getText(); [EOL]         Enum<?> result = _resolver.findEnum(name); [EOL]         if (result == null) { [EOL]             if (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) { [EOL]                 if (name.length() == 0 || name.trim().length() == 0) { [EOL]                     return null; [EOL]                 } [EOL]             } [EOL]             if (!ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) { [EOL]                 throw ctxt.weirdStringException(name, _resolver.getEnumClass(), "value not one of declared Enum instance names"); [EOL]             } [EOL]         } [EOL]         return result; [EOL]     } [EOL]     if (curr == JsonToken.VALUE_NUMBER_INT) { [EOL]         if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) { [EOL]             throw ctxt.mappingException("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)"); [EOL]         } [EOL]         int index = jp.getIntValue(); [EOL]         Enum<?> result = _resolver.getEnum(index); [EOL]         if (result == null && !ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) { [EOL]             throw ctxt.weirdNumberException(Integer.valueOf(index), _resolver.getEnumClass(), "index value outside legal index range [0.." + _resolver.lastValidIndex() + "]"); [EOL]         } [EOL]         return result; [EOL]     } [EOL]     throw ctxt.mappingException(_resolver.getEnumClass()); [EOL] } <line_num>: 74,115
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     Object value; [EOL]     if (_inputType == null) { [EOL]         value = jp.getText(); [EOL]     } else if (_inputType == Integer.class) { [EOL]         value = Integer.valueOf(jp.getValueAsInt()); [EOL]     } else if (_inputType == Long.class) { [EOL]         value = Long.valueOf(jp.getValueAsLong()); [EOL]     } else { [EOL]         throw ctxt.mappingException(_enumClass); [EOL]     } [EOL]     try { [EOL]         return _factory.invoke(_enumClass, value); [EOL]     } catch (Exception e) { [EOL]         ClassUtil.unwrapAndThrowAsIAE(e); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 146,167