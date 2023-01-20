public void testListWithPolymorphic() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     BeanListWrapper beans = new BeanListWrapper(); [EOL]     assertEquals("{\"beans\":[{\"@type\":\"bean\",\"x\":0}]}", mapper.writeValueAsString(beans)); [EOL]     ObjectWriter w = mapper.writerWithView(Object.class); [EOL]     assertEquals("{\"beans\":[{\"@type\":\"bean\",\"x\":0}]}", w.writeValueAsString(beans)); [EOL] } <line_num>: 73,81
public void testIntList() throws Exception { [EOL]     TypedList<Integer> input = new TypedList<Integer>(); [EOL]     input.add(5); [EOL]     input.add(13); [EOL]     assertEquals("[\"" + TypedList.class.getName() + "\",[5,13]]", serializeAsString(input)); [EOL] } <line_num>: 83,90
public void testStringListAsProp() throws Exception { [EOL]     TypedListAsProp<String> input = new TypedListAsProp<String>(); [EOL]     input.add("a"); [EOL]     input.add("b"); [EOL]     assertEquals("[\"" + TypedListAsProp.class.getName() + "\",[\"a\",\"b\"]]", serializeAsString(input)); [EOL] } <line_num>: 96,103
public void testStringListAsObjectWrapper() throws Exception { [EOL]     TypedListAsWrapper<Boolean> input = new TypedListAsWrapper<Boolean>(); [EOL]     input.add(true); [EOL]     input.add(null); [EOL]     input.add(false); [EOL]     String expName = "TestTypedArraySerialization$TypedListAsWrapper"; [EOL]     assertEquals("{\"" + expName + "\":[true,null,false]}", serializeAsString(input)); [EOL] } <line_num>: 105,117
public void testIntArray() throws Exception { [EOL]     ObjectMapper m = new ObjectMapper(); [EOL]     m.addMixInAnnotations(int[].class, WrapperMixIn.class); [EOL]     int[] input = new int[] { 1, 2, 3 }; [EOL]     String clsName = int[].class.getName(); [EOL]     assertEquals("{\"" + clsName + "\":[1,2,3]}", serializeAsString(m, input)); [EOL] } <line_num>: 125,132
public void testGenericArray() throws Exception { [EOL]     ObjectMapper m; [EOL]     final A[] input = new A[] { new B() }; [EOL]     final String EXP = "[{\"BB\":{\"value\":2}}]"; [EOL]     m = new ObjectMapper(); [EOL]     assertEquals(EXP, m.writeValueAsString(input)); [EOL]     m = new ObjectMapper(); [EOL]     m.configure(MapperFeature.USE_STATIC_TYPING, true); [EOL]     assertEquals(EXP, m.writeValueAsString(input)); [EOL] } <line_num>: 140,154