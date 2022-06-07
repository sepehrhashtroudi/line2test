public static <L, R> ImmutablePair<L, R> of(final L left, final R right) { [EOL]     return new ImmutablePair<L, R>(left, right); [EOL] } <line_num>: 57
@Override [EOL] public L getLeft() { [EOL]     return left; [EOL] } <line_num>: 78
@Override [EOL] public R getRight() { [EOL]     return right; [EOL] } <line_num>: 86
@Override [EOL] public R setValue(final R value) { [EOL]     throw new UnsupportedOperationException(); [EOL] } <line_num>: 100
