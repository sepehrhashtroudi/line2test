int getB(); <line_num>: 29,29
@Override [EOL] public int getB() { [EOL]     return 3; [EOL] } <line_num>: 37,38
public boolean getB2() { [EOL]     return true; [EOL] } <line_num>: 44,44
@SuppressWarnings("unchecked") [EOL] public void testSuperClass() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     SubType bean = new SubType(); [EOL]     Map<String, Object> result = writeAndMap(mapper, bean); [EOL]     assertEquals(4, result.size()); [EOL]     assertEquals("a", result.get("a")); [EOL]     assertEquals(Integer.valueOf(3), result.get("b")); [EOL]     assertEquals("x", result.get("a2")); [EOL]     assertEquals(Boolean.TRUE, result.get("b2")); [EOL]     ObjectWriter w = mapper.writerWithType(BaseType.class); [EOL]     String json = w.writeValueAsString(bean); [EOL]     result = (Map<String, Object>) mapper.readValue(json, Map.class); [EOL]     assertEquals(2, result.size()); [EOL]     assertEquals("a", result.get("a")); [EOL]     assertEquals(Integer.valueOf(3), result.get("b")); [EOL] } <line_num>: 65,86
public void testSuperInterface() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     SubType bean = new SubType(); [EOL]     ObjectWriter w = mapper.writerWithType(BaseInterface.class); [EOL]     String json = w.writeValueAsString(bean); [EOL]     @SuppressWarnings("unchecked") [EOL]     Map<String, Object> result = mapper.readValue(json, Map.class); [EOL]     assertEquals(1, result.size()); [EOL]     assertEquals(Integer.valueOf(3), result.get("b")); [EOL] } <line_num>: 88,100
public void testInArray() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.configure(MapperFeature.USE_STATIC_TYPING, true); [EOL]     SubType[] ob = new SubType[] { new SubType() }; [EOL]     String json = mapper.writerWithType(BaseInterface[].class).writeValueAsString(ob); [EOL]     assertEquals("[{\"b\":3}]", json); [EOL] } <line_num>: 102,111
public void testIncompatibleRootType() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     SubType bean = new SubType(); [EOL]     ObjectWriter w = mapper.writerWithType(HashMap.class); [EOL]     try { [EOL]         w.writeValueAsString(bean); [EOL]         fail("Should have failed due to incompatible type"); [EOL]     } catch (JsonProcessingException e) { [EOL]         verifyException(e, "Incompatible types"); [EOL]     } [EOL] } <line_num>: 117,130
public void testJackson398() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     JavaType collectionType = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, BaseClass398.class); [EOL]     List<TestClass398> typedList = new ArrayList<TestClass398>(); [EOL]     typedList.add(new TestClass398()); [EOL]     final String EXP = "[{\"beanClass\":\"TestRootType$TestClass398\",\"property\":\"aa\"}]"; [EOL]     String json = mapper.writerWithType(collectionType).writeValueAsString(typedList); [EOL]     assertEquals(EXP, json); [EOL]     StringWriter out = new StringWriter(); [EOL]     JsonFactory f = new JsonFactory(); [EOL]     mapper.writerWithType(collectionType).writeValue(f.createGenerator(out), typedList); [EOL]     assertEquals(EXP, out.toString()); [EOL] } <line_num>: 135,153
public void testRootWrapping() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true); [EOL]     String json = mapper.writeValueAsString(new StringWrapper("abc")); [EOL]     assertEquals("{\"StringWrapper\":{\"str\":\"abc\"}}", json); [EOL] } <line_num>: 156,162
public void testIssue456WrapperPart() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     assertEquals("123", mapper.writerWithType(Integer.TYPE).writeValueAsString(Integer.valueOf(123))); [EOL]     assertEquals("456", mapper.writerWithType(Long.TYPE).writeValueAsString(Long.valueOf(456L))); [EOL] } <line_num>: 170,175
public void testRootNameAnnotation() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true); [EOL]     String json = mapper.writeValueAsString(new WithRootName()); [EOL]     assertEquals("{\"root\":{\"a\":3}}", json); [EOL] } <line_num>: 178,184
