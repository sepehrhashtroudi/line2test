@SuppressWarnings("unused") [EOL] private ObjectWithTypeVariables() { [EOL]     this(null, null, null, null, null, null); [EOL] } <line_num>: 275,278
public ObjectWithTypeVariables(T obj, T[] array, List<T> list, List<T>[] arrayOfList, List<? extends T> wildcardList, List<? extends T>[] arrayOfWildcardList) { [EOL]     this.typeParameterObj = obj; [EOL]     this.typeParameterArray = array; [EOL]     this.listOfTypeParameters = list; [EOL]     this.arrayOfListOfTypeParameters = arrayOfList; [EOL]     this.listOfWildcardTypeParameters = wildcardList; [EOL]     this.arrayOfListOfWildcardTypeParameters = arrayOfWildcardList; [EOL] } <line_num>: 280,288
@SuppressWarnings("unused") [EOL] private MultiParameters() { [EOL] } <line_num>: 392,394
MultiParameters(A a, B b, C c, D d, E e) { [EOL]     super(); [EOL]     this.a = a; [EOL]     this.b = b; [EOL]     this.c = c; [EOL]     this.d = d; [EOL]     this.e = e; [EOL] } <line_num>: 395,402
@Override [EOL] protected void setUp() throws Exception { [EOL]     super.setUp(); [EOL]     gson = new Gson(); [EOL] } <line_num>: 48,52
public void testParameterizedTypesSerialization() throws Exception { [EOL]     MyParameterizedType<Integer> src = new MyParameterizedType<Integer>(10); [EOL]     Type typeOfSrc = new TypeToken<MyParameterizedType<Integer>>() { [EOL]     }.getType(); [EOL]     String json = gson.toJson(src, typeOfSrc); [EOL]     assertEquals(src.getExpectedJson(), json); [EOL] } <line_num>: 54,59
public void testParameterizedTypeDeserialization() throws Exception { [EOL]     BagOfPrimitives bag = new BagOfPrimitives(); [EOL]     MyParameterizedType<BagOfPrimitives> expected = new MyParameterizedType<BagOfPrimitives>(bag); [EOL]     Type expectedType = new TypeToken<MyParameterizedType<BagOfPrimitives>>() { [EOL]     }.getType(); [EOL]     BagOfPrimitives bagDefaultInstance = new BagOfPrimitives(); [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(expectedType, new MyParameterizedTypeInstanceCreator<BagOfPrimitives>(bagDefaultInstance)).create(); [EOL]     String json = expected.getExpectedJson(); [EOL]     MyParameterizedType<BagOfPrimitives> actual = gson.fromJson(json, expectedType); [EOL]     assertEquals(expected, actual); [EOL] } <line_num>: 61,73
public void testTypesWithMultipleParametersSerialization() throws Exception { [EOL]     MultiParameters<Integer, Float, Double, String, BagOfPrimitives> src = new MultiParameters<Integer, Float, Double, String, BagOfPrimitives>(10, 1.0F, 2.1D, "abc", new BagOfPrimitives()); [EOL]     Type typeOfSrc = new TypeToken<MultiParameters<Integer, Float, Double, String, BagOfPrimitives>>() { [EOL]     }.getType(); [EOL]     String json = gson.toJson(src, typeOfSrc); [EOL]     String expected = "{\"a\":10,\"b\":1.0,\"c\":2.1,\"d\":\"abc\"," + "\"e\":{\"longValue\":0,\"intValue\":0,\"booleanValue\":false,\"stringValue\":\"\"}}"; [EOL]     assertEquals(expected, json); [EOL] } <line_num>: 75,85
public void testTypesWithMultipleParametersDeserialization() throws Exception { [EOL]     Type typeOfTarget = new TypeToken<MultiParameters<Integer, Float, Double, String, BagOfPrimitives>>() { [EOL]     }.getType(); [EOL]     String json = "{\"a\":10,\"b\":1.0,\"c\":2.1,\"d\":\"abc\"," + "\"e\":{\"longValue\":0,\"intValue\":0,\"booleanValue\":false,\"stringValue\":\"\"}}"; [EOL]     MultiParameters<Integer, Float, Double, String, BagOfPrimitives> target = gson.fromJson(json, typeOfTarget); [EOL]     MultiParameters<Integer, Float, Double, String, BagOfPrimitives> expected = new MultiParameters<Integer, Float, Double, String, BagOfPrimitives>(10, 1.0F, 2.1D, "abc", new BagOfPrimitives()); [EOL]     assertEquals(expected, target); [EOL] } <line_num>: 87,98
public void testParameterizedTypeWithCustomSerializer() { [EOL]     Type ptIntegerType = new TypeToken<MyParameterizedType<Integer>>() { [EOL]     }.getType(); [EOL]     Type ptStringType = new TypeToken<MyParameterizedType<String>>() { [EOL]     }.getType(); [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(ptIntegerType, new MyParameterizedTypeAdapter<Integer>()).registerTypeAdapter(ptStringType, new MyParameterizedTypeAdapter<String>()).create(); [EOL]     MyParameterizedType<Integer> intTarget = new MyParameterizedType<Integer>(10); [EOL]     String json = gson.toJson(intTarget, ptIntegerType); [EOL]     assertEquals(MyParameterizedTypeAdapter.<Integer>getExpectedJson(intTarget), json); [EOL]     MyParameterizedType<String> stringTarget = new MyParameterizedType<String>("abc"); [EOL]     json = gson.toJson(stringTarget, ptStringType); [EOL]     assertEquals(MyParameterizedTypeAdapter.<String>getExpectedJson(stringTarget), json); [EOL] } <line_num>: 100,114
public void testParameterizedTypesWithCustomDeserializer() { [EOL]     Type ptIntegerType = new TypeToken<MyParameterizedType<Integer>>() { [EOL]     }.getType(); [EOL]     Type ptStringType = new TypeToken<MyParameterizedType<String>>() { [EOL]     }.getType(); [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(ptIntegerType, new MyParameterizedTypeAdapter<Integer>()).registerTypeAdapter(ptStringType, new MyParameterizedTypeAdapter<String>()).registerTypeAdapter(ptStringType, new MyParameterizedTypeInstanceCreator<String>("")).registerTypeAdapter(ptIntegerType, new MyParameterizedTypeInstanceCreator<Integer>(new Integer(0))).create(); [EOL]     MyParameterizedType<Integer> src = new MyParameterizedType<Integer>(10); [EOL]     String json = MyParameterizedTypeAdapter.<Integer>getExpectedJson(src); [EOL]     MyParameterizedType<Integer> intTarget = gson.fromJson(json, ptIntegerType); [EOL]     assertEquals(10, (int) intTarget.value); [EOL]     MyParameterizedType<String> srcStr = new MyParameterizedType<String>("abc"); [EOL]     json = MyParameterizedTypeAdapter.<String>getExpectedJson(srcStr); [EOL]     MyParameterizedType<String> stringTarget = gson.fromJson(json, ptStringType); [EOL]     assertEquals("abc", stringTarget.value); [EOL] } <line_num>: 116,136
public void testParameterizedTypesWithWriterSerialization() throws Exception { [EOL]     Writer writer = new StringWriter(); [EOL]     MyParameterizedType<Integer> src = new MyParameterizedType<Integer>(10); [EOL]     Type typeOfSrc = new TypeToken<MyParameterizedType<Integer>>() { [EOL]     }.getType(); [EOL]     gson.toJson(src, typeOfSrc, writer); [EOL]     assertEquals(src.getExpectedJson(), writer.toString()); [EOL] } <line_num>: 138,144
public void testParameterizedTypeWithReaderDeserialization() throws Exception { [EOL]     BagOfPrimitives bag = new BagOfPrimitives(); [EOL]     MyParameterizedType<BagOfPrimitives> expected = new MyParameterizedType<BagOfPrimitives>(bag); [EOL]     Type expectedType = new TypeToken<MyParameterizedType<BagOfPrimitives>>() { [EOL]     }.getType(); [EOL]     BagOfPrimitives bagDefaultInstance = new BagOfPrimitives(); [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(expectedType, new MyParameterizedTypeInstanceCreator<BagOfPrimitives>(bagDefaultInstance)).create(); [EOL]     Reader json = new StringReader(expected.getExpectedJson()); [EOL]     MyParameterizedType<Integer> actual = gson.fromJson(json, expectedType); [EOL]     assertEquals(expected, actual); [EOL] } <line_num>: 146,158
@SuppressWarnings("unchecked") [EOL] public void testVariableTypeFieldsAndGenericArraysSerialization() throws Exception { [EOL]     Integer obj = 0; [EOL]     Integer[] array = { 1, 2, 3 }; [EOL]     List<Integer> list = new ArrayList<Integer>(); [EOL]     list.add(4); [EOL]     list.add(5); [EOL]     List<Integer>[] arrayOfLists = new List[] { list, list }; [EOL]     Type typeOfSrc = new TypeToken<ObjectWithTypeVariables<Integer>>() { [EOL]     }.getType(); [EOL]     ObjectWithTypeVariables<Integer> objToSerialize = new ObjectWithTypeVariables<Integer>(obj, array, list, arrayOfLists, list, arrayOfLists); [EOL]     String json = gson.toJson(objToSerialize, typeOfSrc); [EOL]     assertEquals(objToSerialize.getExpectedJson(), json); [EOL] } <line_num>: 160,175
@SuppressWarnings("unchecked") [EOL] public void testVariableTypeFieldsAndGenericArraysDeserialization() throws Exception { [EOL]     Integer obj = 0; [EOL]     Integer[] array = { 1, 2, 3 }; [EOL]     List<Integer> list = new ArrayList<Integer>(); [EOL]     list.add(4); [EOL]     list.add(5); [EOL]     List<Integer>[] arrayOfLists = new List[] { list, list }; [EOL]     Type typeOfSrc = new TypeToken<ObjectWithTypeVariables<Integer>>() { [EOL]     }.getType(); [EOL]     ObjectWithTypeVariables<Integer> objToSerialize = new ObjectWithTypeVariables<Integer>(obj, array, list, arrayOfLists, list, arrayOfLists); [EOL]     String json = gson.toJson(objToSerialize, typeOfSrc); [EOL]     ObjectWithTypeVariables<Integer> objAfterDeserialization = gson.fromJson(json, typeOfSrc); [EOL]     assertEquals(objAfterDeserialization.getExpectedJson(), json); [EOL] } <line_num>: 177,193
public void testVariableTypeDeserialization() throws Exception { [EOL]     Type typeOfSrc = new TypeToken<ObjectWithTypeVariables<Integer>>() { [EOL]     }.getType(); [EOL]     ObjectWithTypeVariables<Integer> objToSerialize = new ObjectWithTypeVariables<Integer>(0, null, null, null, null, null); [EOL]     String json = gson.toJson(objToSerialize, typeOfSrc); [EOL]     ObjectWithTypeVariables<Integer> objAfterDeserialization = gson.fromJson(json, typeOfSrc); [EOL]     assertEquals(objAfterDeserialization.getExpectedJson(), json); [EOL] } <line_num>: 195,203
public void testVariableTypeArrayDeserialization() throws Exception { [EOL]     Integer[] array = { 1, 2, 3 }; [EOL]     Type typeOfSrc = new TypeToken<ObjectWithTypeVariables<Integer>>() { [EOL]     }.getType(); [EOL]     ObjectWithTypeVariables<Integer> objToSerialize = new ObjectWithTypeVariables<Integer>(null, array, null, null, null, null); [EOL]     String json = gson.toJson(objToSerialize, typeOfSrc); [EOL]     ObjectWithTypeVariables<Integer> objAfterDeserialization = gson.fromJson(json, typeOfSrc); [EOL]     assertEquals(objAfterDeserialization.getExpectedJson(), json); [EOL] } <line_num>: 205,215
public void testParameterizedTypeWithVariableTypeDeserialization() throws Exception { [EOL]     List<Integer> list = new ArrayList<Integer>(); [EOL]     list.add(4); [EOL]     list.add(5); [EOL]     Type typeOfSrc = new TypeToken<ObjectWithTypeVariables<Integer>>() { [EOL]     }.getType(); [EOL]     ObjectWithTypeVariables<Integer> objToSerialize = new ObjectWithTypeVariables<Integer>(null, null, list, null, null, null); [EOL]     String json = gson.toJson(objToSerialize, typeOfSrc); [EOL]     ObjectWithTypeVariables<Integer> objAfterDeserialization = gson.fromJson(json, typeOfSrc); [EOL]     assertEquals(objAfterDeserialization.getExpectedJson(), json); [EOL] } <line_num>: 217,229
@SuppressWarnings("unchecked") [EOL] public void testParameterizedTypeGenericArraysSerialization() throws Exception { [EOL]     List<Integer> list = new ArrayList<Integer>(); [EOL]     list.add(1); [EOL]     list.add(2); [EOL]     List<Integer>[] arrayOfLists = new List[] { list, list }; [EOL]     Type typeOfSrc = new TypeToken<ObjectWithTypeVariables<Integer>>() { [EOL]     }.getType(); [EOL]     ObjectWithTypeVariables<Integer> objToSerialize = new ObjectWithTypeVariables<Integer>(null, null, null, arrayOfLists, null, null); [EOL]     String json = gson.toJson(objToSerialize, typeOfSrc); [EOL]     assertEquals("{\"arrayOfListOfTypeParameters\":[[1,2],[1,2]]}", json); [EOL] } <line_num>: 231,243
@SuppressWarnings("unchecked") [EOL] public void testParameterizedTypeGenericArraysDeserialization() throws Exception { [EOL]     List<Integer> list = new ArrayList<Integer>(); [EOL]     list.add(1); [EOL]     list.add(2); [EOL]     List<Integer>[] arrayOfLists = new List[] { list, list }; [EOL]     Type typeOfSrc = new TypeToken<ObjectWithTypeVariables<Integer>>() { [EOL]     }.getType(); [EOL]     ObjectWithTypeVariables<Integer> objToSerialize = new ObjectWithTypeVariables<Integer>(null, null, null, arrayOfLists, null, null); [EOL]     String json = gson.toJson(objToSerialize, typeOfSrc); [EOL]     ObjectWithTypeVariables<Integer> objAfterDeserialization = gson.fromJson(json, typeOfSrc); [EOL]     assertEquals(objAfterDeserialization.getExpectedJson(), json); [EOL] } <line_num>: 245,259
public String getExpectedJson() { [EOL]     StringBuilder sb = new StringBuilder().append("{"); [EOL]     boolean needsComma = false; [EOL]     if (typeParameterObj != null) { [EOL]         sb.append("\"typeParameterObj\":").append(toString(typeParameterObj)); [EOL]         needsComma = true; [EOL]     } [EOL]     if (typeParameterArray != null) { [EOL]         if (needsComma) { [EOL]             sb.append(','); [EOL]         } [EOL]         sb.append("\"typeParameterArray\":["); [EOL]         appendObjectsToBuilder(sb, Arrays.asList(typeParameterArray)); [EOL]         sb.append(']'); [EOL]         needsComma = true; [EOL]     } [EOL]     if (listOfTypeParameters != null) { [EOL]         if (needsComma) { [EOL]             sb.append(','); [EOL]         } [EOL]         sb.append("\"listOfTypeParameters\":["); [EOL]         appendObjectsToBuilder(sb, listOfTypeParameters); [EOL]         sb.append(']'); [EOL]         needsComma = true; [EOL]     } [EOL]     if (arrayOfListOfTypeParameters != null) { [EOL]         if (needsComma) { [EOL]             sb.append(','); [EOL]         } [EOL]         sb.append("\"arrayOfListOfTypeParameters\":["); [EOL]         appendObjectsToBuilder(sb, arrayOfListOfTypeParameters); [EOL]         sb.append(']'); [EOL]         needsComma = true; [EOL]     } [EOL]     if (listOfWildcardTypeParameters != null) { [EOL]         if (needsComma) { [EOL]             sb.append(','); [EOL]         } [EOL]         sb.append("\"listOfWildcardTypeParameters\":["); [EOL]         appendObjectsToBuilder(sb, listOfWildcardTypeParameters); [EOL]         sb.append(']'); [EOL]         needsComma = true; [EOL]     } [EOL]     if (arrayOfListOfWildcardTypeParameters != null) { [EOL]         if (needsComma) { [EOL]             sb.append(','); [EOL]         } [EOL]         sb.append("\"arrayOfListOfWildcardTypeParameters\":["); [EOL]         appendObjectsToBuilder(sb, arrayOfListOfWildcardTypeParameters); [EOL]         sb.append(']'); [EOL]         needsComma = true; [EOL]     } [EOL]     sb.append('}'); [EOL]     return sb.toString(); [EOL] } <line_num>: 290,350
private void appendObjectsToBuilder(StringBuilder sb, Iterable<? extends T> iterable) { [EOL]     boolean isFirst = true; [EOL]     for (T obj : iterable) { [EOL]         if (!isFirst) { [EOL]             sb.append(','); [EOL]         } [EOL]         isFirst = false; [EOL]         sb.append(toString(obj)); [EOL]     } [EOL] } <line_num>: 352,361
private void appendObjectsToBuilder(StringBuilder sb, List<? extends T>[] arrayOfList) { [EOL]     boolean isFirst = true; [EOL]     for (List<? extends T> list : arrayOfList) { [EOL]         if (!isFirst) { [EOL]             sb.append(','); [EOL]         } [EOL]         isFirst = false; [EOL]         if (list != null) { [EOL]             sb.append('['); [EOL]             appendObjectsToBuilder(sb, list); [EOL]             sb.append(']'); [EOL]         } else { [EOL]             sb.append("null"); [EOL]         } [EOL]     } [EOL] } <line_num>: 363,378
public String toString(T obj) { [EOL]     return obj.toString(); [EOL] } <line_num>: 380,382
@Override [EOL] public int hashCode() { [EOL]     final int prime = 31; [EOL]     int result = 1; [EOL]     result = prime * result + ((a == null) ? 0 : a.hashCode()); [EOL]     result = prime * result + ((b == null) ? 0 : b.hashCode()); [EOL]     result = prime * result + ((c == null) ? 0 : c.hashCode()); [EOL]     result = prime * result + ((d == null) ? 0 : d.hashCode()); [EOL]     result = prime * result + ((e == null) ? 0 : e.hashCode()); [EOL]     return result; [EOL] } <line_num>: 403,413
@Override [EOL] @SuppressWarnings("unchecked") [EOL] public boolean equals(Object obj) { [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (obj == null) { [EOL]         return false; [EOL]     } [EOL]     if (getClass() != obj.getClass()) { [EOL]         return false; [EOL]     } [EOL]     MultiParameters<A, B, C, D, E> other = (MultiParameters<A, B, C, D, E>) obj; [EOL]     if (a == null) { [EOL]         if (other.a != null) { [EOL]             return false; [EOL]         } [EOL]     } else if (!a.equals(other.a)) { [EOL]         return false; [EOL]     } [EOL]     if (b == null) { [EOL]         if (other.b != null) { [EOL]             return false; [EOL]         } [EOL]     } else if (!b.equals(other.b)) { [EOL]         return false; [EOL]     } [EOL]     if (c == null) { [EOL]         if (other.c != null) { [EOL]             return false; [EOL]         } [EOL]     } else if (!c.equals(other.c)) { [EOL]         return false; [EOL]     } [EOL]     if (d == null) { [EOL]         if (other.d != null) { [EOL]             return false; [EOL]         } [EOL]     } else if (!d.equals(other.d)) { [EOL]         return false; [EOL]     } [EOL]     if (e == null) { [EOL]         if (other.e != null) { [EOL]             return false; [EOL]         } [EOL]     } else if (!e.equals(other.e)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 414,463
public void testDeepParameterizedTypeSerialization() { [EOL]     Amount<MyQuantity> amount = new Amount<MyQuantity>(); [EOL]     String json = gson.toJson(amount); [EOL]     assertTrue(json.contains("value")); [EOL]     assertTrue(json.contains("30")); [EOL] } <line_num>: 489,494
public void testDeepParameterizedTypeDeserialization() { [EOL]     String json = "{value:30}"; [EOL]     Type type = new TypeToken<Amount<MyQuantity>>() { [EOL]     }.getType(); [EOL]     Amount<MyQuantity> amount = gson.fromJson(json, type); [EOL]     assertEquals(30, amount.value); [EOL] } <line_num>: 496,501