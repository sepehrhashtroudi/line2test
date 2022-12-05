protected TextAnnotation(String text) { [EOL]     super(); [EOL]     if (text == null) { [EOL]         throw new IllegalArgumentException("Null 'text' argument."); [EOL]     } [EOL]     this.text = text; [EOL]     this.font = DEFAULT_FONT; [EOL]     this.paint = DEFAULT_PAINT; [EOL]     this.textAnchor = DEFAULT_TEXT_ANCHOR; [EOL]     this.rotationAnchor = DEFAULT_ROTATION_ANCHOR; [EOL]     this.rotationAngle = DEFAULT_ROTATION_ANGLE; [EOL] } <line_num>: 117,128
public String getText() { [EOL]     return this.text; [EOL] } <line_num>: 137,139
public void setText(String text) { [EOL]     if (text == null) { [EOL]         throw new IllegalArgumentException("Null 'text' argument."); [EOL]     } [EOL]     this.text = text; [EOL] } <line_num>: 148,153
public Font getFont() { [EOL]     return this.font; [EOL] } <line_num>: 162,164
public void setFont(Font font) { [EOL]     if (font == null) { [EOL]         throw new IllegalArgumentException("Null 'font' argument."); [EOL]     } [EOL]     this.font = font; [EOL]     fireAnnotationChanged(); [EOL] } <line_num>: 174,180
public Paint getPaint() { [EOL]     return this.paint; [EOL] } <line_num>: 189,191
public void setPaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.paint = paint; [EOL]     fireAnnotationChanged(); [EOL] } <line_num>: 201,207
public TextAnchor getTextAnchor() { [EOL]     return this.textAnchor; [EOL] } <line_num>: 216,218
public void setTextAnchor(TextAnchor anchor) { [EOL]     if (anchor == null) { [EOL]         throw new IllegalArgumentException("Null 'anchor' argument."); [EOL]     } [EOL]     this.textAnchor = anchor; [EOL]     fireAnnotationChanged(); [EOL] } <line_num>: 229,235
public TextAnchor getRotationAnchor() { [EOL]     return this.rotationAnchor; [EOL] } <line_num>: 244,246
public void setRotationAnchor(TextAnchor anchor) { [EOL]     this.rotationAnchor = anchor; [EOL]     fireAnnotationChanged(); [EOL] } <line_num>: 256,259
public double getRotationAngle() { [EOL]     return this.rotationAngle; [EOL] } <line_num>: 268,270
public void setRotationAngle(double angle) { [EOL]     this.rotationAngle = angle; [EOL]     fireAnnotationChanged(); [EOL] } <line_num>: 280,283
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof TextAnnotation)) { [EOL]         return false; [EOL]     } [EOL]     TextAnnotation that = (TextAnnotation) obj; [EOL]     if (!ObjectUtilities.equal(this.text, that.getText())) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.font, that.getFont())) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.paint, that.getPaint())) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.textAnchor, that.getTextAnchor())) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.rotationAnchor, that.getRotationAnchor())) { [EOL]         return false; [EOL]     } [EOL]     if (this.rotationAngle != that.getRotationAngle()) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 292,324
public int hashCode() { [EOL]     int result = 193; [EOL]     result = 37 * result + this.font.hashCode(); [EOL]     result = 37 * result + HashUtilities.hashCodeForPaint(this.paint); [EOL]     result = 37 * result + this.rotationAnchor.hashCode(); [EOL]     long temp = Double.doubleToLongBits(this.rotationAngle); [EOL]     result = 37 * result + (int) (temp ^ (temp >>> 32)); [EOL]     result = 37 * result + this.text.hashCode(); [EOL]     result = 37 * result + this.textAnchor.hashCode(); [EOL]     return result; [EOL] } <line_num>: 331,341
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writePaint(this.paint, stream); [EOL] } <line_num>: 350,353
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.paint = SerialUtilities.readPaint(stream); [EOL] } <line_num>: 363,367
