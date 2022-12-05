public double transform(Object o) throws NullArgumentException, MathIllegalArgumentException { [EOL]     if (o == null) { [EOL]         throw new NullArgumentException(LocalizedFormats.OBJECT_TRANSFORMATION); [EOL]     } [EOL]     if (o instanceof Number) { [EOL]         return ((Number) o).doubleValue(); [EOL]     } [EOL]     try { [EOL]         return Double.parseDouble(o.toString()); [EOL]     } catch (NumberFormatException e) { [EOL]         throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_TRANSFORM_TO_DOUBLE, o.toString()); [EOL]     } [EOL] } <line_num>: 47,64
@Override [EOL] public boolean equals(Object other) { [EOL]     if (this == other) { [EOL]         return true; [EOL]     } [EOL]     return other instanceof DefaultTransformer; [EOL] } <line_num>: 67,73
@Override [EOL] public int hashCode() { [EOL]     return 401993047; [EOL] } <line_num>: 76,80
