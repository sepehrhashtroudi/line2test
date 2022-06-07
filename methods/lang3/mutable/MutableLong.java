@Override [EOL] public Long getValue() { [EOL]     return Long.valueOf(this.value); [EOL] } <line_num>: 87
public void setValue(final long value) { [EOL]     this.value = value; [EOL] } <line_num>: 96
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.longValue(); [EOL] } <line_num>: 107
public void increment() { [EOL]     value++; [EOL] } <line_num>: 117
public void decrement() { [EOL]     value--; [EOL] } <line_num>: 126
public void add(final long operand) { [EOL]     this.value += operand; [EOL] } <line_num>: 137
public void add(final Number operand) { [EOL]     this.value += operand.longValue(); [EOL] } <line_num>: 148
public void subtract(final long operand) { [EOL]     this.value -= operand; [EOL] } <line_num>: 158
public void subtract(final Number operand) { [EOL]     this.value -= operand.longValue(); [EOL] } <line_num>: 169
@Override [EOL] public int intValue() { [EOL]     return (int) value; [EOL] } <line_num>: 181
@Override [EOL] public long longValue() { [EOL]     return value; [EOL] } <line_num>: 191
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] } <line_num>: 201
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] } <line_num>: 211
public Long toLong() { [EOL]     return Long.valueOf(longValue()); [EOL] } <line_num>: 221
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableLong) { [EOL]         return value == ((MutableLong) obj).longValue(); [EOL]     } [EOL]     return false; [EOL] } <line_num>: 235
@Override [EOL] public int hashCode() { [EOL]     return (int) (value ^ (value >>> 32)); [EOL] } <line_num>: 248
@Override [EOL] public int compareTo(final MutableLong other) { [EOL]     final long anotherVal = other.value; [EOL]     return value < anotherVal ? -1 : (value == anotherVal ? 0 : 1); [EOL] } <line_num>: 260
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] } <line_num>: 272
