public Dual() { [EOL] } <line_num>: 43,43
public List<String> getValues() { [EOL]     return _values; [EOL] } <line_num>: 28,28
public Map<String, Integer> getValues() { [EOL]     return _values; [EOL] } <line_num>: 35,35
public List<Integer> getList() { [EOL]     throw new IllegalStateException("Should not get called"); [EOL] } <line_num>: 45,47
public void testSimpleSetterlessCollectionOk() throws Exception { [EOL]     CollectionBean result = new ObjectMapper().readValue("{\"values\":[ \"abc\", \"def\" ]}", CollectionBean.class); [EOL]     List<String> l = result._values; [EOL]     assertEquals(2, l.size()); [EOL]     assertEquals("abc", l.get(0)); [EOL]     assertEquals("def", l.get(1)); [EOL] } <line_num>: 56,65
public void testSimpleSetterlessCollectionFailure() throws Exception { [EOL]     ObjectMapper m = new ObjectMapper(); [EOL]     assertTrue(m.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS)); [EOL]     m.configure(MapperFeature.USE_GETTERS_AS_SETTERS, false); [EOL]     assertFalse(m.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS)); [EOL]     try { [EOL]         m.readValue("{\"values\":[ \"abc\", \"def\" ]}", CollectionBean.class); [EOL]         fail("Expected an exception"); [EOL]     } catch (JsonMappingException e) { [EOL]         verifyException(e, "Unrecognized field"); [EOL]     } [EOL] } <line_num>: 71,91
public void testSimpleSetterlessMapOk() throws Exception { [EOL]     MapBean result = new ObjectMapper().readValue("{\"values\":{ \"a\": 15, \"b\" : -3 }}", MapBean.class); [EOL]     Map<String, Integer> m = result._values; [EOL]     assertEquals(2, m.size()); [EOL]     assertEquals(Integer.valueOf(15), m.get("a")); [EOL]     assertEquals(Integer.valueOf(-3), m.get("b")); [EOL] } <line_num>: 93,102
public void testSimpleSetterlessMapFailure() throws Exception { [EOL]     ObjectMapper m = new ObjectMapper(); [EOL]     m.configure(MapperFeature.USE_GETTERS_AS_SETTERS, false); [EOL]     try { [EOL]         m.readValue("{\"values\":{ \"a\":3 }}", MapBean.class); [EOL]         fail("Expected an exception"); [EOL]     } catch (JsonMappingException e) { [EOL]         verifyException(e, "Unrecognized field"); [EOL]     } [EOL] } <line_num>: 104,117
public void testSetterlessPrecedence() throws Exception { [EOL]     ObjectMapper m = new ObjectMapper(); [EOL]     m.configure(MapperFeature.USE_GETTERS_AS_SETTERS, true); [EOL]     Dual value = m.readValue("{\"list\":[1,2,3]}, valueType)", Dual.class); [EOL]     assertNotNull(value); [EOL]     assertEquals(3, value.values.size()); [EOL] } <line_num>: 122,129