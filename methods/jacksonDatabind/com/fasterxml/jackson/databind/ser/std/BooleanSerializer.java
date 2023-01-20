public BooleanSerializer(boolean forPrimitive) { [EOL]     super(Boolean.class); [EOL]     _forPrimitive = forPrimitive; [EOL] } <line_num>: 32,36
@Override [EOL] public void serialize(Boolean value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     jgen.writeBoolean(value.booleanValue()); [EOL] } <line_num>: 38,43
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     return createSchemaNode("boolean", !_forPrimitive); [EOL] } <line_num>: 45,49
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         visitor.expectBooleanFormat(typeHint); [EOL]     } [EOL] } <line_num>: 51,58