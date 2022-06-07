public static <L, M, R> ImmutableTriple<L, M, R> of(final L left, final M middle, final R right) { [EOL]     return new ImmutableTriple<L, M, R>(left, middle, right); [EOL] } <line_num>: 61
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] } <line_num>: 84
@Override [EOL] public M getMiddle() { [EOL]     return middle; [EOL] } <line_num>: 92
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] } <line_num>: 100
