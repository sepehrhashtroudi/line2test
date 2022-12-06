public StandardCrosshairLabelGenerator() { [EOL]     this("{0}", NumberFormat.getNumberInstance()); [EOL] } <line_num>: 65,67
public StandardCrosshairLabelGenerator(String labelTemplate, NumberFormat numberFormat) { [EOL]     super(); [EOL]     if (labelTemplate == null) { [EOL]         throw new IllegalArgumentException("Null 'labelTemplate' argument."); [EOL]     } [EOL]     if (numberFormat == null) { [EOL]         throw new IllegalArgumentException("Null 'numberFormat' argument."); [EOL]     } [EOL]     this.labelTemplate = labelTemplate; [EOL]     this.numberFormat = numberFormat; [EOL] } <line_num>: 77,90
public String getLabelTemplate() { [EOL]     return this.labelTemplate; [EOL] } <line_num>: 97,99
public NumberFormat getNumberFormat() { [EOL]     return this.numberFormat; [EOL] } <line_num>: 106,108
public String generateLabel(Crosshair crosshair) { [EOL]     Object[] v = new Object[] { this.numberFormat.format(crosshair.getValue()) }; [EOL]     String result = MessageFormat.format(this.labelTemplate, v); [EOL]     return result; [EOL] } <line_num>: 117,122
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof StandardCrosshairLabelGenerator)) { [EOL]         return false; [EOL]     } [EOL]     StandardCrosshairLabelGenerator that = (StandardCrosshairLabelGenerator) obj; [EOL]     if (!this.labelTemplate.equals(that.labelTemplate)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.numberFormat.equals(that.numberFormat)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 131,147
public int hashCode() { [EOL]     return this.labelTemplate.hashCode(); [EOL] } <line_num>: 154,156