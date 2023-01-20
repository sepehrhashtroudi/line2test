CircularReferenceException(Object offendingNode) { [EOL]     super("circular reference error"); [EOL]     this.offendingNode = offendingNode; [EOL] } <line_num>: 30,33
public IllegalStateException createDetailedException(FieldAttributes offendingField) { [EOL]     StringBuilder msg = new StringBuilder(getMessage()); [EOL]     if (offendingField != null) { [EOL]         msg.append("\n  ").append("Offending field: ").append(offendingField.getName() + "\n"); [EOL]     } [EOL]     if (offendingNode != null) { [EOL]         msg.append("\n  ").append("Offending object: ").append(offendingNode); [EOL]     } [EOL]     return new IllegalStateException(msg.toString(), this); [EOL] } <line_num>: 35,44
