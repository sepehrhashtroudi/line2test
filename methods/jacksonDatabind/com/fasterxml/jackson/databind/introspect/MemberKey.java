public MemberKey(Method m) { [EOL]     this(m.getName(), m.getParameterTypes()); [EOL] } <line_num>: 18,21
public MemberKey(Constructor<?> ctor) { [EOL]     this("", ctor.getParameterTypes()); [EOL] } <line_num>: 23,26
public MemberKey(String name, Class<?>[] argTypes) { [EOL]     _name = name; [EOL]     _argTypes = (argTypes == null) ? NO_CLASSES : argTypes; [EOL] } <line_num>: 28,32
@Override [EOL] public String toString() { [EOL]     return _name + "(" + _argTypes.length + "-args)"; [EOL] } <line_num>: 34,37
@Override [EOL] public int hashCode() { [EOL]     return _name.hashCode() + _argTypes.length; [EOL] } <line_num>: 39,43
@Override [EOL] public boolean equals(Object o) { [EOL]     if (o == this) [EOL]         return true; [EOL]     if (o == null) [EOL]         return false; [EOL]     if (o.getClass() != getClass()) { [EOL]         return false; [EOL]     } [EOL]     MemberKey other = (MemberKey) o; [EOL]     if (!_name.equals(other._name)) { [EOL]         return false; [EOL]     } [EOL]     Class<?>[] otherArgs = other._argTypes; [EOL]     int len = _argTypes.length; [EOL]     if (otherArgs.length != len) { [EOL]         return false; [EOL]     } [EOL]     for (int i = 0; i < len; ++i) { [EOL]         Class<?> type1 = otherArgs[i]; [EOL]         Class<?> type2 = _argTypes[i]; [EOL]         if (type1 == type2) { [EOL]             continue; [EOL]         } [EOL]         if (type1.isAssignableFrom(type2) || type2.isAssignableFrom(type1)) { [EOL]             continue; [EOL]         } [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 45,82