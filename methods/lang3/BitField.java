public int getValue(final int holder) { [EOL]     return getRawValue(holder) >> _shift_count; [EOL] } <line_num>: 65
public short getShortValue(final short holder) { [EOL]     return (short) getValue(holder); [EOL] } <line_num>: 83
public int getRawValue(final int holder) { [EOL]     return holder & _mask; [EOL] } <line_num>: 94
public short getShortRawValue(final short holder) { [EOL]     return (short) getRawValue(holder); [EOL] } <line_num>: 105
public boolean isSet(final int holder) { [EOL]     return (holder & _mask) != 0; [EOL] } <line_num>: 122
public boolean isAllSet(final int holder) { [EOL]     return (holder & _mask) == _mask; [EOL] } <line_num>: 138
public int setValue(final int holder, final int value) { [EOL]     return (holder & ~_mask) | ((value << _shift_count) & _mask); [EOL] } <line_num>: 152
public short setShortValue(final short holder, final short value) { [EOL]     return (short) setValue(holder, value); [EOL] } <line_num>: 166
public int clear(final int holder) { [EOL]     return holder & ~_mask; [EOL] } <line_num>: 178
public short clearShort(final short holder) { [EOL]     return (short) clear(holder); [EOL] } <line_num>: 190
public byte clearByte(final byte holder) { [EOL]     return (byte) clear(holder); [EOL] } <line_num>: 203
public int set(final int holder) { [EOL]     return holder | _mask; [EOL] } <line_num>: 215
public short setShort(final short holder) { [EOL]     return (short) set(holder); [EOL] } <line_num>: 227
public byte setByte(final byte holder) { [EOL]     return (byte) set(holder); [EOL] } <line_num>: 240
public int setBoolean(final int holder, final boolean flag) { [EOL]     return flag ? set(holder) : clear(holder); [EOL] } <line_num>: 253
public short setShortBoolean(final short holder, final boolean flag) { [EOL]     return flag ? setShort(holder) : clearShort(holder); [EOL] } <line_num>: 266
public byte setByteBoolean(final byte holder, final boolean flag) { [EOL]     return flag ? setByte(holder) : clearByte(holder); [EOL] } <line_num>: 279
