@Override [EOL] public Short getValue() { [EOL]     return Short.valueOf(this.value); [EOL] } <line_num>: 87
public void setValue(final short value) { [EOL]     this.value = value; [EOL] } <line_num>: 96
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.shortValue(); [EOL] } <line_num>: 107
public void increment() { [EOL]     value++; [EOL] } <line_num>: 117
public void decrement() { [EOL]     value--; [EOL] } <line_num>: 126
public void add(final short operand) { [EOL]     this.value += operand; [EOL] } <line_num>: 137
public void add(final Number operand) { [EOL]     this.value += operand.shortValue(); [EOL] } <line_num>: 148
public void subtract(final short operand) { [EOL]     this.value -= operand; [EOL] } <line_num>: 158
public void subtract(final Number operand) { [EOL]     this.value -= operand.shortValue(); [EOL] } <line_num>: 169
@Override [EOL] public short shortValue() { [EOL]     return value; [EOL] } <line_num>: 181
@Override [EOL] public int intValue() { [EOL]     return value; [EOL] } <line_num>: 191
@Override [EOL] public long longValue() { [EOL]     return value; [EOL] } <line_num>: 201
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] } <line_num>: 211
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] } <line_num>: 221
public Short toShort() { [EOL]     return Short.valueOf(shortValue()); [EOL] } <line_num>: 231
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableShort) { [EOL]         return value == ((MutableShort) obj).shortValue(); [EOL]     } [EOL]     return false; [EOL] } <line_num>: 245
@Override [EOL] public int hashCode() { [EOL]     return value; [EOL] } <line_num>: 258
@Override [EOL] public int compareTo(final MutableShort other) { [EOL]     final short anotherVal = other.value; [EOL]     return value < anotherVal ? -1 : (value == anotherVal ? 0 : 1); [EOL] } <line_num>: 270
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] } <line_num>: 282
