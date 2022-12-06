public CategoryTick(Comparable category, TextBlock label, TextBlockAnchor labelAnchor, TextAnchor rotationAnchor, double angle) { [EOL]     super("", TextAnchor.CENTER, rotationAnchor, angle); [EOL]     this.category = category; [EOL]     this.label = label; [EOL]     this.labelAnchor = labelAnchor; [EOL] } <line_num>: 73,84
public Comparable getCategory() { [EOL]     return this.category; [EOL] } <line_num>: 91,93
public TextBlock getLabel() { [EOL]     return this.label; [EOL] } <line_num>: 100,102
public TextBlockAnchor getLabelAnchor() { [EOL]     return this.labelAnchor; [EOL] } <line_num>: 109,111
public boolean equals(Object obj) { [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (obj instanceof CategoryTick && super.equals(obj)) { [EOL]         CategoryTick that = (CategoryTick) obj; [EOL]         if (!ObjectUtilities.equal(this.category, that.category)) { [EOL]             return false; [EOL]         } [EOL]         if (!ObjectUtilities.equal(this.label, that.label)) { [EOL]             return false; [EOL]         } [EOL]         if (!ObjectUtilities.equal(this.labelAnchor, that.labelAnchor)) { [EOL]             return false; [EOL]         } [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 120,138
public int hashCode() { [EOL]     int result = 41; [EOL]     result = 37 * result + this.category.hashCode(); [EOL]     result = 37 * result + this.label.hashCode(); [EOL]     result = 37 * result + this.labelAnchor.hashCode(); [EOL]     return result; [EOL] } <line_num>: 145,151