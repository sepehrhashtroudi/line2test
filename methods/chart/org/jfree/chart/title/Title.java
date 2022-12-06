protected Title() { [EOL]     this(Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING); [EOL] } <line_num>: 138,142
protected Title(RectangleEdge position, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) { [EOL]     this(position, horizontalAlignment, verticalAlignment, Title.DEFAULT_PADDING); [EOL] } <line_num>: 154,161
protected Title(RectangleEdge position, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, RectangleInsets padding) { [EOL]     if (position == null) { [EOL]         throw new IllegalArgumentException("Null 'position' argument."); [EOL]     } [EOL]     if (horizontalAlignment == null) { [EOL]         throw new IllegalArgumentException("Null 'horizontalAlignment' argument."); [EOL]     } [EOL]     if (verticalAlignment == null) { [EOL]         throw new IllegalArgumentException("Null 'verticalAlignment' argument."); [EOL]     } [EOL]     if (padding == null) { [EOL]         throw new IllegalArgumentException("Null 'spacer' argument."); [EOL]     } [EOL]     this.visible = true; [EOL]     this.position = position; [EOL]     this.horizontalAlignment = horizontalAlignment; [EOL]     this.verticalAlignment = verticalAlignment; [EOL]     setPadding(padding); [EOL]     this.listenerList = new EventListenerList(); [EOL]     this.notify = true; [EOL] } <line_num>: 177,207
public boolean isVisible() { [EOL]     return this.visible; [EOL] } <line_num>: 219,221
public void setVisible(boolean visible) { [EOL]     this.visible = visible; [EOL]     notifyListeners(new TitleChangeEvent(this)); [EOL] } <line_num>: 233,236
public RectangleEdge getPosition() { [EOL]     return this.position; [EOL] } <line_num>: 243,245
public void setPosition(RectangleEdge position) { [EOL]     if (position == null) { [EOL]         throw new IllegalArgumentException("Null 'position' argument."); [EOL]     } [EOL]     if (this.position != position) { [EOL]         this.position = position; [EOL]         notifyListeners(new TitleChangeEvent(this)); [EOL]     } [EOL] } <line_num>: 253,261
public HorizontalAlignment getHorizontalAlignment() { [EOL]     return this.horizontalAlignment; [EOL] } <line_num>: 268,270
public void setHorizontalAlignment(HorizontalAlignment alignment) { [EOL]     if (alignment == null) { [EOL]         throw new IllegalArgumentException("Null 'alignment' argument."); [EOL]     } [EOL]     if (this.horizontalAlignment != alignment) { [EOL]         this.horizontalAlignment = alignment; [EOL]         notifyListeners(new TitleChangeEvent(this)); [EOL]     } [EOL] } <line_num>: 279,287
public VerticalAlignment getVerticalAlignment() { [EOL]     return this.verticalAlignment; [EOL] } <line_num>: 294,296
public void setVerticalAlignment(VerticalAlignment alignment) { [EOL]     if (alignment == null) { [EOL]         throw new IllegalArgumentException("Null 'alignment' argument."); [EOL]     } [EOL]     if (this.verticalAlignment != alignment) { [EOL]         this.verticalAlignment = alignment; [EOL]         notifyListeners(new TitleChangeEvent(this)); [EOL]     } [EOL] } <line_num>: 305,313
public boolean getNotify() { [EOL]     return this.notify; [EOL] } <line_num>: 321,323
public void setNotify(boolean flag) { [EOL]     this.notify = flag; [EOL]     if (flag) { [EOL]         notifyListeners(new TitleChangeEvent(this)); [EOL]     } [EOL] } <line_num>: 332,337
public abstract void draw(Graphics2D g2, Rectangle2D area); <line_num>: 347,347
public Object clone() throws CloneNotSupportedException { [EOL]     Title duplicate = (Title) super.clone(); [EOL]     duplicate.listenerList = new EventListenerList(); [EOL]     return duplicate; [EOL] } <line_num>: 361,366
public void addChangeListener(TitleChangeListener listener) { [EOL]     this.listenerList.add(TitleChangeListener.class, listener); [EOL] } <line_num>: 373,375
public void removeChangeListener(TitleChangeListener listener) { [EOL]     this.listenerList.remove(TitleChangeListener.class, listener); [EOL] } <line_num>: 382,384
protected void notifyListeners(TitleChangeEvent event) { [EOL]     if (this.notify) { [EOL]         Object[] listeners = this.listenerList.getListenerList(); [EOL]         for (int i = listeners.length - 2; i >= 0; i -= 2) { [EOL]             if (listeners[i] == TitleChangeListener.class) { [EOL]                 ((TitleChangeListener) listeners[i + 1]).titleChanged(event); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 393,403
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof Title)) { [EOL]         return false; [EOL]     } [EOL]     Title that = (Title) obj; [EOL]     if (this.visible != that.visible) { [EOL]         return false; [EOL]     } [EOL]     if (this.position != that.position) { [EOL]         return false; [EOL]     } [EOL]     if (this.horizontalAlignment != that.horizontalAlignment) { [EOL]         return false; [EOL]     } [EOL]     if (this.verticalAlignment != that.verticalAlignment) { [EOL]         return false; [EOL]     } [EOL]     if (this.notify != that.notify) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 412,436
public int hashCode() { [EOL]     int result = 193; [EOL]     result = 37 * result + ObjectUtilities.hashCode(this.position); [EOL]     result = 37 * result + ObjectUtilities.hashCode(this.horizontalAlignment); [EOL]     result = 37 * result + ObjectUtilities.hashCode(this.verticalAlignment); [EOL]     return result; [EOL] } <line_num>: 443,450
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL] } <line_num>: 459,461
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.listenerList = new EventListenerList(); [EOL] } <line_num>: 471,475