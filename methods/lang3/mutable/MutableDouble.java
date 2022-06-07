@Override [EOL] public Double getValue() { [EOL]     return Double.valueOf(this.value); [EOL] } <line_num>: 87
public void setValue(final double value) { [EOL]     this.value = value; [EOL] } <line_num>: 96
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.doubleValue(); [EOL] } <line_num>: 107
public boolean isNaN() { [EOL]     return Double.isNaN(value); [EOL] } <line_num>: 117
public boolean isInfinite() { [EOL]     return Double.isInfinite(value); [EOL] } <line_num>: 126
public void increment() { [EOL]     value++; [EOL] } <line_num>: 136
public void decrement() { [EOL]     value--; [EOL] } <line_num>: 145
public void add(final double operand) { [EOL]     this.value += operand; [EOL] } <line_num>: 156
public void add(final Number operand) { [EOL]     this.value += operand.doubleValue(); [EOL] } <line_num>: 167
public void subtract(final double operand) { [EOL]     this.value -= operand; [EOL] } <line_num>: 177
public void subtract(final Number operand) { [EOL]     this.value -= operand.doubleValue(); [EOL] } <line_num>: 188
@Override [EOL] public int intValue() { [EOL]     return (int) value; [EOL] } <line_num>: 200
@Override [EOL] public long longValue() { [EOL]     return (long) value; [EOL] } <line_num>: 210
@Override [EOL] public float floatValue() { [EOL]     return (float) value; [EOL] } <line_num>: 220
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] } <line_num>: 230
public Double toDouble() { [EOL]     return Double.valueOf(doubleValue()); [EOL] } <line_num>: 240
@Override [EOL] public boolean equals(final Object obj) { [EOL]     return obj instanceof MutableDouble && Double.doubleToLongBits(((MutableDouble) obj).value) == Double.doubleToLongBits(value); [EOL] } <line_num>: 275
@Override [EOL] public int hashCode() { [EOL]     final long bits = Double.doubleToLongBits(value); [EOL]     return (int) (bits ^ bits >>> 32); [EOL] } <line_num>: 286
@Override [EOL] public int compareTo(final MutableDouble other) { [EOL]     final double anotherVal = other.value; [EOL]     return Double.compare(value, anotherVal); [EOL] } <line_num>: 299
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] } <line_num>: 311
