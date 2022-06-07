@Override [EOL] public Boolean getValue() { [EOL]     return Boolean.valueOf(this.value); [EOL] } <line_num>: 78
public void setValue(final boolean value) { [EOL]     this.value = value; [EOL] } <line_num>: 87
@Override [EOL] public void setValue(final Boolean value) { [EOL]     this.value = value.booleanValue(); [EOL] } <line_num>: 98
public boolean isTrue() { [EOL]     return value == true; [EOL] } <line_num>: 109
public boolean isFalse() { [EOL]     return value == false; [EOL] } <line_num>: 119
public boolean booleanValue() { [EOL]     return value; [EOL] } <line_num>: 129
public Boolean toBoolean() { [EOL]     return Boolean.valueOf(booleanValue()); [EOL] } <line_num>: 140
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableBoolean) { [EOL]         return value == ((MutableBoolean) obj).booleanValue(); [EOL]     } [EOL]     return false; [EOL] } <line_num>: 154
@Override [EOL] public int hashCode() { [EOL]     return value ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode(); [EOL] } <line_num>: 167
@Override [EOL] public int compareTo(final MutableBoolean other) { [EOL]     final boolean anotherVal = other.value; [EOL]     return value == anotherVal ? 0 : (value ? 1 : -1); [EOL] } <line_num>: 180
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] } <line_num>: 192
