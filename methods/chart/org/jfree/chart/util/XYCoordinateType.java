private XYCoordinateType(String name) { [EOL]     this.name = name; [EOL] } <line_num>: 77,79
public String toString() { [EOL]     return this.name; [EOL] } <line_num>: 86,88
public boolean equals(Object obj) { [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof XYCoordinateType)) { [EOL]         return false; [EOL]     } [EOL]     XYCoordinateType order = (XYCoordinateType) obj; [EOL]     if (!this.name.equals(order.toString())) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 98,110
private Object readResolve() throws ObjectStreamException { [EOL]     if (this.equals(XYCoordinateType.DATA)) { [EOL]         return XYCoordinateType.DATA; [EOL]     } else if (this.equals(XYCoordinateType.RELATIVE)) { [EOL]         return XYCoordinateType.RELATIVE; [EOL]     } else if (this.equals(XYCoordinateType.INDEX)) { [EOL]         return XYCoordinateType.INDEX; [EOL]     } [EOL]     return null; [EOL] } <line_num>: 119,130
