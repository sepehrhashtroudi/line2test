public static <L, R> MutablePair<L, R> of(final L left, final R right) { [EOL]     return new MutablePair<L, R>(left, right); [EOL] } <line_num>: 52
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] } <line_num>: 80
public void setLeft(final L left) { [EOL]     this.left = left; [EOL] } <line_num>: 89
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] } <line_num>: 97
public void setRight(final R right) { [EOL]     this.right = right; [EOL] } <line_num>: 106
@Override [EOL] public R setValue(final R value) { [EOL]     final R result = getRight(); [EOL]     setRight(value); [EOL]     return result; [EOL] } <line_num>: 118
