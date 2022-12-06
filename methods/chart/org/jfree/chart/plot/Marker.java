protected Marker() { [EOL]     this(Color.gray); [EOL] } <line_num>: 143,145
protected Marker(Paint paint) { [EOL]     this(paint, new BasicStroke(0.5f), Color.gray, new BasicStroke(0.5f), 0.80f); [EOL] } <line_num>: 152,155
protected Marker(Paint paint, Stroke stroke, Paint outlinePaint, Stroke outlineStroke, float alpha) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     if (stroke == null) { [EOL]         throw new IllegalArgumentException("Null 'stroke' argument."); [EOL]     } [EOL]     if (alpha < 0.0f || alpha > 1.0f) [EOL]         throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f"); [EOL]     this.paint = paint; [EOL]     this.stroke = stroke; [EOL]     this.outlinePaint = outlinePaint; [EOL]     this.outlineStroke = outlineStroke; [EOL]     this.alpha = alpha; [EOL]     this.labelFont = new Font("Tahoma", Font.PLAIN, 9); [EOL]     this.labelPaint = Color.black; [EOL]     this.labelAnchor = RectangleAnchor.TOP_LEFT; [EOL]     this.labelOffset = new RectangleInsets(3.0, 3.0, 3.0, 3.0); [EOL]     this.labelOffsetType = LengthAdjustmentType.CONTRACT; [EOL]     this.labelTextAnchor = TextAnchor.CENTER; [EOL]     this.listenerList = new EventListenerList(); [EOL] } <line_num>: 171,199
public Paint getPaint() { [EOL]     return this.paint; [EOL] } <line_num>: 208,210
public void setPaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.paint = paint; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 220,226
public Stroke getStroke() { [EOL]     return this.stroke; [EOL] } <line_num>: 235,237
public void setStroke(Stroke stroke) { [EOL]     if (stroke == null) { [EOL]         throw new IllegalArgumentException("Null 'stroke' argument."); [EOL]     } [EOL]     this.stroke = stroke; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 247,253
public Paint getOutlinePaint() { [EOL]     return this.outlinePaint; [EOL] } <line_num>: 262,264
public void setOutlinePaint(Paint paint) { [EOL]     this.outlinePaint = paint; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 274,277
public Stroke getOutlineStroke() { [EOL]     return this.outlineStroke; [EOL] } <line_num>: 286,288
public void setOutlineStroke(Stroke stroke) { [EOL]     this.outlineStroke = stroke; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 298,301
public float getAlpha() { [EOL]     return this.alpha; [EOL] } <line_num>: 310,312
public void setAlpha(float alpha) { [EOL]     if (alpha < 0.0f || alpha > 1.0f) [EOL]         throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f"); [EOL]     this.alpha = alpha; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 328,334
public String getLabel() { [EOL]     return this.label; [EOL] } <line_num>: 343,345
public void setLabel(String label) { [EOL]     this.label = label; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 355,358
public Font getLabelFont() { [EOL]     return this.labelFont; [EOL] } <line_num>: 367,369
public void setLabelFont(Font font) { [EOL]     if (font == null) { [EOL]         throw new IllegalArgumentException("Null 'font' argument."); [EOL]     } [EOL]     this.labelFont = font; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 379,385
public Paint getLabelPaint() { [EOL]     return this.labelPaint; [EOL] } <line_num>: 394,396
public void setLabelPaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.labelPaint = paint; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 406,412
public RectangleAnchor getLabelAnchor() { [EOL]     return this.labelAnchor; [EOL] } <line_num>: 422,424
public void setLabelAnchor(RectangleAnchor anchor) { [EOL]     if (anchor == null) { [EOL]         throw new IllegalArgumentException("Null 'anchor' argument."); [EOL]     } [EOL]     this.labelAnchor = anchor; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 435,441
public RectangleInsets getLabelOffset() { [EOL]     return this.labelOffset; [EOL] } <line_num>: 450,452
public void setLabelOffset(RectangleInsets offset) { [EOL]     if (offset == null) { [EOL]         throw new IllegalArgumentException("Null 'offset' argument."); [EOL]     } [EOL]     this.labelOffset = offset; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 462,468
public LengthAdjustmentType getLabelOffsetType() { [EOL]     return this.labelOffsetType; [EOL] } <line_num>: 477,479
public void setLabelOffsetType(LengthAdjustmentType adj) { [EOL]     if (adj == null) { [EOL]         throw new IllegalArgumentException("Null 'adj' argument."); [EOL]     } [EOL]     this.labelOffsetType = adj; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 489,495
public TextAnchor getLabelTextAnchor() { [EOL]     return this.labelTextAnchor; [EOL] } <line_num>: 504,506
public void setLabelTextAnchor(TextAnchor anchor) { [EOL]     if (anchor == null) { [EOL]         throw new IllegalArgumentException("Null 'anchor' argument."); [EOL]     } [EOL]     this.labelTextAnchor = anchor; [EOL]     notifyListeners(new MarkerChangeEvent(this)); [EOL] } <line_num>: 516,522
public void addChangeListener(MarkerChangeListener listener) { [EOL]     this.listenerList.add(MarkerChangeListener.class, listener); [EOL] } <line_num>: 533,535
public void removeChangeListener(MarkerChangeListener listener) { [EOL]     this.listenerList.remove(MarkerChangeListener.class, listener); [EOL] } <line_num>: 546,548
public void notifyListeners(MarkerChangeEvent event) { [EOL]     Object[] listeners = this.listenerList.getListenerList(); [EOL]     for (int i = listeners.length - 2; i >= 0; i -= 2) { [EOL]         if (listeners[i] == MarkerChangeListener.class) { [EOL]             ((MarkerChangeListener) listeners[i + 1]).markerChanged(event); [EOL]         } [EOL]     } [EOL] } <line_num>: 557,566
public EventListener[] getListeners(Class listenerType) { [EOL]     return this.listenerList.getListeners(listenerType); [EOL] } <line_num>: 577,579
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof Marker)) { [EOL]         return false; [EOL]     } [EOL]     Marker that = (Marker) obj; [EOL]     if (!PaintUtilities.equal(this.paint, that.paint)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.stroke, that.stroke)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.outlinePaint, that.outlinePaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.outlineStroke, that.outlineStroke)) { [EOL]         return false; [EOL]     } [EOL]     if (this.alpha != that.alpha) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.label, that.label)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.labelFont, that.labelFont)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.labelPaint, that.labelPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (this.labelAnchor != that.labelAnchor) { [EOL]         return false; [EOL]     } [EOL]     if (this.labelTextAnchor != that.labelTextAnchor) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.labelOffset, that.labelOffset)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.labelOffsetType.equals(that.labelOffsetType)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 588,633
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 642,644
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writePaint(this.paint, stream); [EOL]     SerialUtilities.writeStroke(this.stroke, stream); [EOL]     SerialUtilities.writePaint(this.outlinePaint, stream); [EOL]     SerialUtilities.writeStroke(this.outlineStroke, stream); [EOL]     SerialUtilities.writePaint(this.labelPaint, stream); [EOL] } <line_num>: 653,660
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.paint = SerialUtilities.readPaint(stream); [EOL]     this.stroke = SerialUtilities.readStroke(stream); [EOL]     this.outlinePaint = SerialUtilities.readPaint(stream); [EOL]     this.outlineStroke = SerialUtilities.readStroke(stream); [EOL]     this.labelPaint = SerialUtilities.readPaint(stream); [EOL]     this.listenerList = new EventListenerList(); [EOL] } <line_num>: 670,679