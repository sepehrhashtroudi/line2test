public GenericArrayTypeImpl(Type genericComponentType) { [EOL]     this.genericComponentType = genericComponentType; [EOL] } <line_num>: 47,49
public Type getGenericComponentType() { [EOL]     return genericComponentType; [EOL] } <line_num>: 51,53
@Override [EOL] public boolean equals(Object o) { [EOL]     if (!(o instanceof GenericArrayType)) { [EOL]         return false; [EOL]     } [EOL]     GenericArrayType that = (GenericArrayType) o; [EOL]     Type thatComponentType = that.getGenericComponentType(); [EOL]     return genericComponentType == null ? thatComponentType == null : genericComponentType.equals(thatComponentType); [EOL] } <line_num>: 55,64
@Override [EOL] public int hashCode() { [EOL]     return (genericComponentType == null) ? 0 : genericComponentType.hashCode(); [EOL] } <line_num>: 66,69
