private ClassWithBaseField()
public ClassWithBaseField(Base base)
private ClassWithBaseArrayField()
public ClassWithBaseArrayField(Base[] base)
 StringWrapper()
public StringWrapper(String value)
public BagOfPrimitives()
public BagOfPrimitives(long longValue, int intValue, boolean booleanValue, String stringValue)
public BagOfPrimitiveWrappers()
public BagOfPrimitiveWrappers(Long longValue, Integer intValue, Boolean booleanValue)
public PrimitiveArray()
public PrimitiveArray(long[] longArray)
public Nested()
public Nested(BagOfPrimitives primitive1, BagOfPrimitives primitive2)
public ClassWithTransientFields()
public ClassWithTransientFields(long value)
public ClassWithCustomTypeConverter()
public ClassWithCustomTypeConverter(int value)
public ClassWithCustomTypeConverter(BagOfPrimitives bag, int value)
public ArrayOfObjects()
public ClassWithArray()
public ClassWithArray(Object[] array)
public ClassWithObjects()
public ClassWithObjects(BagOfPrimitives bag)
public ClassWithSerializedNameFields()
public ClassWithSerializedNameFields(int f, int g)
public JsonElement serialize(Base src, Type typeOfSrc, JsonSerializationContext context)
public JsonElement serialize(Sub src, Type typeOfSrc, JsonSerializationContext context)
public int getIntValue()
public String getExpectedJson()
public int hashCode()
public boolean equals(Object obj)
public String toString()
public String getExpectedJson()
public String getExpectedJson()
public boolean equals(Object other)
public String getExpectedJson()
public void appendFields(StringBuilder sb)
public String getExpectedJson()
public BagOfPrimitives getBag()
public String getExpectedJson()
public int getValue()
public String getExpectedJson()
public String getExpectedJson()
public boolean equals(Object obj)
public int hashCode()
public String getExpectedJson()
public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context)
public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
