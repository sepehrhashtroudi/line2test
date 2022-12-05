@Override [EOL] public void setUp() throws Exception { [EOL]     super.setUp(); [EOL] } <line_num>: 45,48
@Override [EOL] protected ParameterizedType createParameterizedType(ObjectType objectType, JSType parameterType) { [EOL]     return registry.createParameterizedType(objectType, parameterType); [EOL] } <line_num>: 50,54
private void assertTypeCanAssignToItself(JSType type) { [EOL]     assertTrue(type.isSubtype(type)); [EOL] } <line_num>: 59,61
@SuppressWarnings("checked") [EOL] public void testParameterizedType() throws Exception { [EOL]     ParameterizedType arrOfString = createParameterizedType(ARRAY_TYPE, STRING_TYPE); [EOL]     assertTypeCanAssignToItself(arrOfString); [EOL]     assertTrue(arrOfString.isSubtype(ARRAY_TYPE)); [EOL]     assertTrue(ARRAY_TYPE.isSubtype(arrOfString)); [EOL]     ParameterizedType arrOfNumber = createParameterizedType(ARRAY_TYPE, NUMBER_TYPE); [EOL]     assertTypeCanAssignToItself(arrOfNumber); [EOL]     assertTrue(arrOfNumber.isSubtype(ARRAY_TYPE)); [EOL]     assertTrue(ARRAY_TYPE.isSubtype(arrOfNumber)); [EOL]     assertTrue(arrOfString.isEquivalentTo(createParameterizedType(ARRAY_TYPE, STRING_TYPE))); [EOL]     assertFalse(arrOfString.isEquivalentTo(ARRAY_TYPE)); [EOL]     assertFalse(arrOfString.isEquivalentTo(ARRAY_TYPE)); [EOL]     assertFalse(arrOfString.isEquivalentTo(arrOfNumber)); [EOL]     assertFalse(arrOfNumber.isEquivalentTo(arrOfString)); [EOL] } <line_num>: 66,87
public void testPrint1() throws Exception { [EOL]     ParameterizedType arrOfString = createParameterizedType(ARRAY_TYPE, STRING_TYPE); [EOL]     assertEquals("Array.<string>", arrOfString.toString()); [EOL] } <line_num>: 89,93
public void testPrint2() throws Exception { [EOL]     ParameterizedType arrOfTemplateType = createParameterizedType(ARRAY_TYPE, new TemplateType(registry, "T")); [EOL]     assertEquals("Array.<T>", arrOfTemplateType.toString()); [EOL] } <line_num>: 95,99
public void testPrint3() throws Exception { [EOL]     ParameterizedType arrOfUnknown = createParameterizedType(ARRAY_TYPE, UNKNOWN_TYPE); [EOL]     assertEquals("Array.<?>", arrOfUnknown.toString()); [EOL] } <line_num>: 101,105
public void testDifferentRawTypes() throws Exception { [EOL]     ParameterizedType arrOfNumber = createParameterizedType(ARRAY_TYPE, NUMBER_TYPE); [EOL]     ParameterizedType objType = createParameterizedType(OBJECT_TYPE, UNKNOWN_TYPE); [EOL]     assertTrue(arrOfNumber.isSubtype(objType)); [EOL]     assertFalse(objType.isSubtype(arrOfNumber)); [EOL] } <line_num>: 107,114
