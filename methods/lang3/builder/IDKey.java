@Override [EOL] public int hashCode() { [EOL]     return id; [EOL] } <line_num>: 53
@Override [EOL] public boolean equals(final Object other) { [EOL]     if (!(other instanceof IDKey)) { [EOL]         return false; [EOL]     } [EOL]     final IDKey idKey = (IDKey) other; [EOL]     if (id != idKey.id) { [EOL]         return false; [EOL]     } [EOL]     return value == idKey.value; [EOL] } <line_num>: 63