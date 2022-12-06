@Test [EOL] public void testGetValue() { [EOL]     assertEquals(bf_multi.getValue(-1), 127); [EOL]     assertEquals(bf_multi.getValue(0), 0); [EOL]     assertEquals(bf_single.getValue(-1), 1); [EOL]     assertEquals(bf_single.getValue(0), 0); [EOL]     assertEquals(bf_zero.getValue(-1), 0); [EOL]     assertEquals(bf_zero.getValue(0), 0); [EOL] } <line_num>: 39,47
@Test [EOL] public void testGetShortValue() { [EOL]     assertEquals(bf_multi.getShortValue((short) -1), (short) 127); [EOL]     assertEquals(bf_multi.getShortValue((short) 0), (short) 0); [EOL]     assertEquals(bf_single.getShortValue((short) -1), (short) 1); [EOL]     assertEquals(bf_single.getShortValue((short) 0), (short) 0); [EOL]     assertEquals(bf_zero.getShortValue((short) -1), (short) 0); [EOL]     assertEquals(bf_zero.getShortValue((short) 0), (short) 0); [EOL] } <line_num>: 52,60
@Test [EOL] public void testGetRawValue() { [EOL]     assertEquals(bf_multi.getRawValue(-1), 0x3F80); [EOL]     assertEquals(bf_multi.getRawValue(0), 0); [EOL]     assertEquals(bf_single.getRawValue(-1), 0x4000); [EOL]     assertEquals(bf_single.getRawValue(0), 0); [EOL]     assertEquals(bf_zero.getRawValue(-1), 0); [EOL]     assertEquals(bf_zero.getRawValue(0), 0); [EOL] } <line_num>: 65,73
@Test [EOL] public void testGetShortRawValue() { [EOL]     assertEquals(bf_multi.getShortRawValue((short) -1), (short) 0x3F80); [EOL]     assertEquals(bf_multi.getShortRawValue((short) 0), (short) 0); [EOL]     assertEquals(bf_single.getShortRawValue((short) -1), (short) 0x4000); [EOL]     assertEquals(bf_single.getShortRawValue((short) 0), (short) 0); [EOL]     assertEquals(bf_zero.getShortRawValue((short) -1), (short) 0); [EOL]     assertEquals(bf_zero.getShortRawValue((short) 0), (short) 0); [EOL] } <line_num>: 78,86
@Test [EOL] public void testIsSet() { [EOL]     assertTrue(!bf_multi.isSet(0)); [EOL]     assertTrue(!bf_zero.isSet(0)); [EOL]     for (int j = 0x80; j <= 0x3F80; j += 0x80) { [EOL]         assertTrue(bf_multi.isSet(j)); [EOL]     } [EOL]     for (int j = 0x80; j <= 0x3F80; j += 0x80) { [EOL]         assertTrue(!bf_zero.isSet(j)); [EOL]     } [EOL]     assertTrue(!bf_single.isSet(0)); [EOL]     assertTrue(bf_single.isSet(0x4000)); [EOL] } <line_num>: 91,103
@Test [EOL] public void testIsAllSet() { [EOL]     for (int j = 0; j < 0x3F80; j += 0x80) { [EOL]         assertTrue(!bf_multi.isAllSet(j)); [EOL]         assertTrue(bf_zero.isAllSet(j)); [EOL]     } [EOL]     assertTrue(bf_multi.isAllSet(0x3F80)); [EOL]     assertTrue(!bf_single.isAllSet(0)); [EOL]     assertTrue(bf_single.isAllSet(0x4000)); [EOL] } <line_num>: 108,117
@Test [EOL] public void testSetValue() { [EOL]     for (int j = 0; j < 128; j++) { [EOL]         assertEquals(bf_multi.getValue(bf_multi.setValue(0, j)), j); [EOL]         assertEquals(bf_multi.setValue(0, j), j << 7); [EOL]     } [EOL]     for (int j = 0; j < 128; j++) { [EOL]         assertEquals(bf_zero.getValue(bf_zero.setValue(0, j)), 0); [EOL]         assertEquals(bf_zero.setValue(0, j), 0); [EOL]     } [EOL]     assertEquals(bf_multi.setValue(0x3f80, 128), 0); [EOL]     for (int j = 0; j < 2; j++) { [EOL]         assertEquals(bf_single.getValue(bf_single.setValue(0, j)), j); [EOL]         assertEquals(bf_single.setValue(0, j), j << 14); [EOL]     } [EOL]     assertEquals(bf_single.setValue(0x4000, 2), 0); [EOL] } <line_num>: 122,142
@Test [EOL] public void testSetShortValue() { [EOL]     for (int j = 0; j < 128; j++) { [EOL]         assertEquals(bf_multi.getShortValue(bf_multi.setShortValue((short) 0, (short) j)), (short) j); [EOL]         assertEquals(bf_multi.setShortValue((short) 0, (short) j), (short) (j << 7)); [EOL]     } [EOL]     for (int j = 0; j < 128; j++) { [EOL]         assertEquals(bf_zero.getShortValue(bf_zero.setShortValue((short) 0, (short) j)), (short) 0); [EOL]         assertEquals(bf_zero.setShortValue((short) 0, (short) j), (short) 0); [EOL]     } [EOL]     assertEquals(bf_multi.setShortValue((short) 0x3f80, (short) 128), (short) 0); [EOL]     for (int j = 0; j < 2; j++) { [EOL]         assertEquals(bf_single.getShortValue(bf_single.setShortValue((short) 0, (short) j)), (short) j); [EOL]         assertEquals(bf_single.setShortValue((short) 0, (short) j), (short) (j << 14)); [EOL]     } [EOL]     assertEquals(bf_single.setShortValue((short) 0x4000, (short) 2), (short) 0); [EOL] } <line_num>: 147,167
@Test [EOL] public void testByte() { [EOL]     assertEquals(0, new BitField(0).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(1, new BitField(1).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(2, new BitField(2).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(4, new BitField(4).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(8, new BitField(8).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(16, new BitField(16).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(32, new BitField(32).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(64, new BitField(64).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(-128, new BitField(128).setByteBoolean((byte) 0, true)); [EOL]     assertEquals(1, new BitField(0).setByteBoolean((byte) 1, false)); [EOL]     assertEquals(0, new BitField(1).setByteBoolean((byte) 1, false)); [EOL]     assertEquals(0, new BitField(2).setByteBoolean((byte) 2, false)); [EOL]     assertEquals(0, new BitField(4).setByteBoolean((byte) 4, false)); [EOL]     assertEquals(0, new BitField(8).setByteBoolean((byte) 8, false)); [EOL]     assertEquals(0, new BitField(16).setByteBoolean((byte) 16, false)); [EOL]     assertEquals(0, new BitField(32).setByteBoolean((byte) 32, false)); [EOL]     assertEquals(0, new BitField(64).setByteBoolean((byte) 64, false)); [EOL]     assertEquals(0, new BitField(128).setByteBoolean((byte) 128, false)); [EOL]     assertEquals(-2, new BitField(1).setByteBoolean((byte) 255, false)); [EOL]     final byte clearedBit = new BitField(0x40).setByteBoolean((byte) -63, false); [EOL]     assertFalse(new BitField(0x40).isSet(clearedBit)); [EOL] } <line_num>: 169,193
@Test [EOL] public void testClear() { [EOL]     assertEquals(bf_multi.clear(-1), 0xFFFFC07F); [EOL]     assertEquals(bf_single.clear(-1), 0xFFFFBFFF); [EOL]     assertEquals(bf_zero.clear(-1), 0xFFFFFFFF); [EOL] } <line_num>: 198,203
@Test [EOL] public void testClearShort() { [EOL]     assertEquals(bf_multi.clearShort((short) -1), (short) 0xC07F); [EOL]     assertEquals(bf_single.clearShort((short) -1), (short) 0xBFFF); [EOL]     assertEquals(bf_zero.clearShort((short) -1), (short) 0xFFFF); [EOL] } <line_num>: 208,213
@Test [EOL] public void testSet() { [EOL]     assertEquals(bf_multi.set(0), 0x3F80); [EOL]     assertEquals(bf_single.set(0), 0x4000); [EOL]     assertEquals(bf_zero.set(0), 0); [EOL] } <line_num>: 218,223
@Test [EOL] public void testSetShort() { [EOL]     assertEquals(bf_multi.setShort((short) 0), (short) 0x3F80); [EOL]     assertEquals(bf_single.setShort((short) 0), (short) 0x4000); [EOL]     assertEquals(bf_zero.setShort((short) 0), (short) 0); [EOL] } <line_num>: 228,233
@Test [EOL] public void testSetBoolean() { [EOL]     assertEquals(bf_multi.set(0), bf_multi.setBoolean(0, true)); [EOL]     assertEquals(bf_single.set(0), bf_single.setBoolean(0, true)); [EOL]     assertEquals(bf_zero.set(0), bf_zero.setBoolean(0, true)); [EOL]     assertEquals(bf_multi.clear(-1), bf_multi.setBoolean(-1, false)); [EOL]     assertEquals(bf_single.clear(-1), bf_single.setBoolean(-1, false)); [EOL]     assertEquals(bf_zero.clear(-1), bf_zero.setBoolean(-1, false)); [EOL] } <line_num>: 238,246
@Test [EOL] public void testSetShortBoolean() { [EOL]     assertEquals(bf_multi.setShort((short) 0), bf_multi.setShortBoolean((short) 0, true)); [EOL]     assertEquals(bf_single.setShort((short) 0), bf_single.setShortBoolean((short) 0, true)); [EOL]     assertEquals(bf_zero.setShort((short) 0), bf_zero.setShortBoolean((short) 0, true)); [EOL]     assertEquals(bf_multi.clearShort((short) -1), bf_multi.setShortBoolean((short) -1, false)); [EOL]     assertEquals(bf_single.clearShort((short) -1), bf_single.setShortBoolean((short) -1, false)); [EOL]     assertEquals(bf_zero.clearShort((short) -1), bf_zero.setShortBoolean((short) -1, false)); [EOL] } <line_num>: 251,259