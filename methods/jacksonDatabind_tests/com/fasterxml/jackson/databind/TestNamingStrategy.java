public FieldBean() { [EOL]     this(0); [EOL] } <line_num>: 103,103
public FieldBean(int v) { [EOL]     key = v; [EOL] } <line_num>: 104,104
public PersonBean() { [EOL]     this(null, null, 0); [EOL] } <line_num>: 113,113
public PersonBean(String f, String l, int a) { [EOL]     firstName = f; [EOL]     lastName = l; [EOL]     age = a; [EOL] } <line_num>: 114,119
public Value() { [EOL]     this(0); [EOL] } <line_num>: 125,125
public Value(int v) { [EOL]     intValue = v; [EOL] } <line_num>: 126,126
@Override [EOL] public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) { [EOL]     return "Field-" + defaultName; [EOL] } <line_num>: 30,35
@Override [EOL] public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) { [EOL]     return "Get-" + defaultName; [EOL] } <line_num>: 37,42
@Override [EOL] public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) { [EOL]     return "Set-" + defaultName; [EOL] } <line_num>: 44,49
@Override [EOL] public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) { [EOL]     return convert(defaultName); [EOL] } <line_num>: 54,58
@Override [EOL] public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) { [EOL]     return convert(defaultName); [EOL] } <line_num>: 60,64
@Override [EOL] public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) { [EOL]     return convert(defaultName); [EOL] } <line_num>: 66,70
private String convert(String input) { [EOL]     StringBuilder result = new StringBuilder(); [EOL]     for (int i = 0, len = input.length(); i < len; ++i) { [EOL]         char c = input.charAt(i); [EOL]         if (Character.isUpperCase(c)) { [EOL]             result.append('_'); [EOL]             c = Character.toLowerCase(c); [EOL]         } [EOL]         result.append(c); [EOL]     } [EOL]     return result.toString(); [EOL] } <line_num>: 72,85
public int getKey() { [EOL]     return 123; [EOL] } <line_num>: 89,89
public void setKey(int v) { [EOL]     value = v; [EOL] } <line_num>: 95,97
public List<Value> getValueList() { [EOL]     return values; [EOL] } <line_num>: 133,133
public SetterlessWithValue add(int v) { [EOL]     values.add(new Value(v)); [EOL]     return this; [EOL] } <line_num>: 135,138
@Override [EOL] public String translate(String propertyName) { [EOL]     return propertyName.toLowerCase(); [EOL] } <line_num>: 144,147
public List<String> getTheVALUEs() { [EOL]     return THEvalues; [EOL] } <line_num>: 156,156
public int getA() { [EOL]     return a; [EOL] } <line_num>: 165,165
public void setA(int value) { [EOL]     a = value; [EOL] } <line_num>: 166,166
public void testSimpleGetters() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setPropertyNamingStrategy(new PrefixStrategy()); [EOL]     assertEquals("{\"Get-key\":123}", mapper.writeValueAsString(new GetterBean())); [EOL] } <line_num>: 175,180
public void testSimpleSetters() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setPropertyNamingStrategy(new PrefixStrategy()); [EOL]     SetterBean bean = mapper.readValue("{\"Set-key\":13}", SetterBean.class); [EOL]     assertEquals(13, bean.value); [EOL] } <line_num>: 182,188
public void testSimpleFields() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setPropertyNamingStrategy(new PrefixStrategy()); [EOL]     String json = mapper.writeValueAsString(new FieldBean(999)); [EOL]     assertEquals("{\"Field-key\":999}", json); [EOL]     FieldBean result = mapper.readValue(json, FieldBean.class); [EOL]     assertEquals(999, result.key); [EOL] } <line_num>: 190,201
public void testCStyleNaming() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setPropertyNamingStrategy(new CStyleStrategy()); [EOL]     String json = mapper.writeValueAsString(new PersonBean("Joe", "Sixpack", 42)); [EOL]     assertEquals("{\"first_name\":\"Joe\",\"last_name\":\"Sixpack\",\"age\":42}", json); [EOL]     PersonBean result = mapper.readValue(json, PersonBean.class); [EOL]     assertEquals("Joe", result.firstName); [EOL]     assertEquals("Sixpack", result.lastName); [EOL]     assertEquals(42, result.age); [EOL] } <line_num>: 203,216
public void testWithGetterAsSetter() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setPropertyNamingStrategy(new CStyleStrategy()); [EOL]     SetterlessWithValue input = new SetterlessWithValue().add(3); [EOL]     String json = mapper.writeValueAsString(input); [EOL]     assertEquals("{\"value_list\":[{\"int_value\":3}]}", json); [EOL]     SetterlessWithValue result = mapper.readValue(json, SetterlessWithValue.class); [EOL]     assertNotNull(result.values); [EOL]     assertEquals(1, result.values.size()); [EOL]     assertEquals(3, result.values.get(0).intValue); [EOL] } <line_num>: 218,230
public void testJson() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setPropertyNamingStrategy(new LcStrategy()); [EOL]     RenamedCollectionBean foo = mapper.readValue("{\"thevalues\":[\"a\"]}", RenamedCollectionBean.class); [EOL]     assertNotNull(foo.getTheVALUEs()); [EOL]     assertEquals(1, foo.getTheVALUEs().size()); [EOL]     assertEquals("a", foo.getTheVALUEs().get(0)); [EOL] } <line_num>: 233,242
public void testPerClassAnnotation() throws Exception { [EOL]     final ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.setPropertyNamingStrategy(new LcStrategy()); [EOL]     BeanWithPrefixNames input = new BeanWithPrefixNames(); [EOL]     String json = mapper.writeValueAsString(input); [EOL]     assertEquals("{\"Get-a\":3}", json); [EOL]     BeanWithPrefixNames output = mapper.readValue("{\"Set-a\":7}", BeanWithPrefixNames.class); [EOL]     assertEquals(7, output.a); [EOL] } <line_num>: 245,256