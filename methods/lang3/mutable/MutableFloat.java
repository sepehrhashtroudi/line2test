@Override [EOL] public Float getValue() { [EOL]     return Float.valueOf(this.value); [EOL] } <line_num>: 87
public void setValue(final float value) { [EOL]     this.value = value; [EOL] } <line_num>: 96
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.floatValue(); [EOL] } <line_num>: 107
public boolean isNaN() { [EOL]     return Float.isNaN(value); [EOL] } <line_num>: 117
public boolean isInfinite() { [EOL]     return Float.isInfinite(value); [EOL] } <line_num>: 126
public void increment() { [EOL]     value++; [EOL] } <line_num>: 136
public void decrement() { [EOL]     value--; [EOL] } <line_num>: 145
public void add(final float operand) { [EOL]     this.value += operand; [EOL] } <line_num>: 156
public void add(final Number operand) { [EOL]     this.value += operand.floatValue(); [EOL] } <line_num>: 167
public void subtract(final float operand) { [EOL]     this.value -= operand; [EOL] } <line_num>: 177
public void subtract(final Number operand) { [EOL]     this.value -= operand.floatValue(); [EOL] } <line_num>: 188
@Override [EOL] public int intValue() { [EOL]     return (int) value; [EOL] } <line_num>: 200
@Override [EOL] public long longValue() { [EOL]     return (long) value; [EOL] } <line_num>: 210
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] } <line_num>: 220
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] } <line_num>: 230
public Float toFloat() { [EOL]     return Float.valueOf(floatValue()); [EOL] } <line_num>: 240
@Override [EOL] public boolean equals(final Object obj) { [EOL]     return obj instanceof MutableFloat && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(value); [EOL] } <line_num>: 277
@Override [EOL] public int hashCode() { [EOL]     return Float.floatToIntBits(value); [EOL] } <line_num>: 288
@Override [EOL] public int compareTo(final MutableFloat other) { [EOL]     final float anotherVal = other.value; [EOL]     return Float.compare(value, anotherVal); [EOL] } <line_num>: 300
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] } <line_num>: 312
