private BooleanLiteralSet fromOrdinal(int ordinal) { [EOL]     switch(ordinal) { [EOL]         case 0: [EOL]             return EMPTY; [EOL]         case 1: [EOL]             return TRUE; [EOL]         case 2: [EOL]             return FALSE; [EOL]         case 3: [EOL]             return BOTH; [EOL]         default: [EOL]             throw new IllegalArgumentException("Ordinal: " + ordinal); [EOL]     } [EOL] } <line_num>: 53,61
public BooleanLiteralSet intersection(BooleanLiteralSet that) { [EOL]     return fromOrdinal(this.ordinal() & that.ordinal()); [EOL] } <line_num>: 66,68
public BooleanLiteralSet union(BooleanLiteralSet that) { [EOL]     return fromOrdinal(this.ordinal() | that.ordinal()); [EOL] } <line_num>: 73,75
public boolean contains(boolean literalValue) { [EOL]     switch(this.ordinal()) { [EOL]         case 0: [EOL]             return false; [EOL]         case 1: [EOL]             return literalValue; [EOL]         case 2: [EOL]             return !literalValue; [EOL]         case 3: [EOL]             return true; [EOL]         default: [EOL]             throw new IndexOutOfBoundsException("Ordinal: " + this.ordinal()); [EOL]     } [EOL] } <line_num>: 80,89
public static BooleanLiteralSet get(boolean literalValue) { [EOL]     return literalValue ? TRUE : FALSE; [EOL] } <line_num>: 94,96
