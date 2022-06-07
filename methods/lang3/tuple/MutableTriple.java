public static <L, M, R> MutableTriple<L, M, R> of(final L left, final M middle, final R right) { [EOL]     return new MutableTriple<L, M, R>(left, middle, right); [EOL] } <line_num>: 56
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] } <line_num>: 86
public void setLeft(final L left) { [EOL]     this.left = left; [EOL] } <line_num>: 95
@Override [EOL] public M getMiddle() { [EOL]     return middle; [EOL] } <line_num>: 103
public void setMiddle(final M middle) { [EOL]     this.middle = middle; [EOL] } <line_num>: 112
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] } <line_num>: 120
public void setRight(final R right) { [EOL]     this.right = right; [EOL] } <line_num>: 129
