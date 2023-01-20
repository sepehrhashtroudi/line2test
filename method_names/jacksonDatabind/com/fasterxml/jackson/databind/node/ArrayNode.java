public ArrayNode(JsonNodeFactory nc)
public ArrayNode deepCopy()
public JsonNodeType getNodeType()
public JsonToken asToken()
public int size()
public Iterator<JsonNode> elements()
public JsonNode get(int index)
public JsonNode get(String fieldName)
public JsonNode path(String fieldName)
public JsonNode path(int index)
public void serialize(JsonGenerator jg, SerializerProvider provider) throws IOException, JsonProcessingException
public void serializeWithType(JsonGenerator jg, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException
public JsonNode findValue(String fieldName)
public List<JsonNode> findValues(String fieldName, List<JsonNode> foundSoFar)
public List<String> findValuesAsText(String fieldName, List<String> foundSoFar)
public ObjectNode findParent(String fieldName)
public List<JsonNode> findParents(String fieldName, List<JsonNode> foundSoFar)
public JsonNode set(int index, JsonNode value)
public ArrayNode add(JsonNode value)
public ArrayNode addAll(ArrayNode other)
public ArrayNode addAll(Collection<JsonNode> nodes)
public ArrayNode insert(int index, JsonNode value)
public JsonNode remove(int index)
public ArrayNode removeAll()
public ArrayNode addArray()
public ObjectNode addObject()
public ArrayNode addPOJO(Object value)
public ArrayNode addNull()
public ArrayNode add(int v)
public ArrayNode add(Integer value)
public ArrayNode add(long v)
public ArrayNode add(Long value)
public ArrayNode add(float v)
public ArrayNode add(Float value)
public ArrayNode add(double v)
public ArrayNode add(Double value)
public ArrayNode add(BigDecimal v)
public ArrayNode add(String v)
public ArrayNode add(boolean v)
public ArrayNode add(Boolean value)
public ArrayNode add(byte[] v)
public ArrayNode insertArray(int index)
public ObjectNode insertObject(int index)
public ArrayNode insertPOJO(int index, Object value)
public ArrayNode insertNull(int index)
public ArrayNode insert(int index, int v)
public ArrayNode insert(int index, Integer value)
public ArrayNode insert(int index, long v)
public ArrayNode insert(int index, Long value)
public ArrayNode insert(int index, float v)
public ArrayNode insert(int index, Float value)
public ArrayNode insert(int index, double v)
public ArrayNode insert(int index, Double value)
public ArrayNode insert(int index, BigDecimal v)
public ArrayNode insert(int index, String v)
public ArrayNode insert(int index, boolean v)
public ArrayNode insert(int index, Boolean value)
public ArrayNode insert(int index, byte[] v)
public boolean equals(Object o)
public int hashCode()
public String toString()
private ArrayNode _add(JsonNode node)
private ArrayNode _insert(int index, JsonNode node)
