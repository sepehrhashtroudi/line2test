public BaseClass(String a, String b) { [EOL]     this.a = a; [EOL]     this.b = b; [EOL] } <line_num>: 24,27
public SubClass(String a, String b) { [EOL]     super(a, b); [EOL] } <line_num>: 33,35
public void testFieldMixInsTopLevel() throws IOException { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     Map<String, Object> result; [EOL]     BaseClass bean = new BaseClass("1", "2"); [EOL]     result = writeAndMap(mapper, bean); [EOL]     assertEquals(1, result.size()); [EOL]     assertEquals("1", result.get("a")); [EOL]     mapper = new ObjectMapper(); [EOL]     mapper.addMixInAnnotations(BaseClass.class, MixIn.class); [EOL]     result = writeAndMap(mapper, bean); [EOL]     assertEquals(2, result.size()); [EOL]     assertEquals("1", result.get("a")); [EOL]     assertEquals("2", result.get("banana")); [EOL] } <line_num>: 59,77
public void testMultipleFieldMixIns() throws IOException { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     HashMap<Class<?>, Class<?>> mixins = new HashMap<Class<?>, Class<?>>(); [EOL]     mixins.put(SubClass.class, MixIn.class); [EOL]     mixins.put(BaseClass.class, MixIn2.class); [EOL]     mapper.setMixInAnnotations(mixins); [EOL]     Map<String, Object> result; [EOL]     result = writeAndMap(mapper, new SubClass("1", "2")); [EOL]     assertEquals(1, result.size()); [EOL]     assertEquals("2", result.get("banana")); [EOL] } <line_num>: 79,93
