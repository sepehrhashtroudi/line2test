public final T getObject() { [EOL]     return object; [EOL] } <line_num>: 68
@Override [EOL] public T get() throws ConcurrentException { [EOL]     return getObject(); [EOL] } <line_num>: 80
@Override [EOL] public int hashCode() { [EOL]     return getObject() != null ? getObject().hashCode() : 0; [EOL] } <line_num>: 91
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof ConstantInitializer<?>)) { [EOL]         return false; [EOL]     } [EOL]     final ConstantInitializer<?> c = (ConstantInitializer<?>) obj; [EOL]     return ObjectUtils.equals(getObject(), c.getObject()); [EOL] } <line_num>: 105
@Override [EOL] public String toString() { [EOL]     return String.format(FMT_TO_STRING, Integer.valueOf(System.identityHashCode(this)), String.valueOf(getObject())); [EOL] } <line_num>: 125
