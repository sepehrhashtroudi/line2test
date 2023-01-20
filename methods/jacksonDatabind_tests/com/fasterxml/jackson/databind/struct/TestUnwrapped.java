public Unwrapping() { [EOL] } <line_num>: 17,17
public Unwrapping(String str, int x, int y) { [EOL]     name = str; [EOL]     location = new Location(x, y); [EOL] } <line_num>: 18,21
public DeepUnwrapping() { [EOL] } <line_num>: 29,29
public DeepUnwrapping(String str, int x, int y) { [EOL]     unwrapped = new Unwrapping(str, x, y); [EOL] } <line_num>: 30,32
@JsonCreator [EOL] public UnwrappingWithCreator(@JsonProperty("name") String n) { [EOL]     name = n; [EOL] } <line_num>: 41,44
public Location() { [EOL] } <line_num>: 51,51
public Location(int x, int y) { [EOL]     this.x = x; [EOL]     this.y = y; [EOL] } <line_num>: 52,55
public TwoUnwrappedProperties() { [EOL] } <line_num>: 65,65
public void testSimpleUnwrappingSerialize() throws Exception { [EOL]     assertEquals("{\"name\":\"Tatu\",\"x\":1,\"y\":2}", mapper.writeValueAsString(new Unwrapping("Tatu", 1, 2))); [EOL] } <line_num>: 80,84
public void testDeepUnwrappingSerialize() throws Exception { [EOL]     assertEquals("{\"name\":\"Tatu\",\"x\":1,\"y\":2}", mapper.writeValueAsString(new DeepUnwrapping("Tatu", 1, 2))); [EOL] } <line_num>: 85,89
public void testSimpleUnwrappedDeserialize() throws Exception { [EOL]     Unwrapping bean = mapper.readValue("{\"name\":\"Tatu\",\"y\":7,\"x\":-13}", Unwrapping.class); [EOL]     assertEquals("Tatu", bean.name); [EOL]     Location loc = bean.location; [EOL]     assertNotNull(loc); [EOL]     assertEquals(-13, loc.x); [EOL]     assertEquals(7, loc.y); [EOL] } <line_num>: 97,106
public void testDoubleUnwrapping() throws Exception { [EOL]     TwoUnwrappedProperties bean = mapper.readValue("{\"first\":\"Joe\",\"y\":7,\"last\":\"Smith\",\"x\":-13}", TwoUnwrappedProperties.class); [EOL]     Location loc = bean.location; [EOL]     assertNotNull(loc); [EOL]     assertEquals(-13, loc.x); [EOL]     assertEquals(7, loc.y); [EOL]     Name name = bean.name; [EOL]     assertNotNull(name); [EOL]     assertEquals("Joe", name.first); [EOL]     assertEquals("Smith", name.last); [EOL] } <line_num>: 108,120
public void testDeepUnwrapping() throws Exception { [EOL]     DeepUnwrapping bean = mapper.readValue("{\"x\":3,\"name\":\"Bob\",\"y\":27}", DeepUnwrapping.class); [EOL]     Unwrapping uw = bean.unwrapped; [EOL]     assertNotNull(uw); [EOL]     assertEquals("Bob", uw.name); [EOL]     Location loc = uw.location; [EOL]     assertNotNull(loc); [EOL]     assertEquals(3, loc.x); [EOL]     assertEquals(27, loc.y); [EOL] } <line_num>: 122,133
public void testUnwrappedDeserializeWithCreator() throws Exception { [EOL]     UnwrappingWithCreator bean = mapper.readValue("{\"x\":1,\"y\":2,\"name\":\"Tatu\"}", UnwrappingWithCreator.class); [EOL]     assertEquals("Tatu", bean.name); [EOL]     Location loc = bean.location; [EOL]     assertNotNull(loc); [EOL]     assertEquals(1, loc.x); [EOL]     assertEquals(2, loc.y); [EOL] } <line_num>: 135,144