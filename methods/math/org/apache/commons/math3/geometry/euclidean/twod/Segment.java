public Segment(final Vector2D start, final Vector2D end, final Line line) { [EOL]     this.start = start; [EOL]     this.end = end; [EOL]     this.line = line; [EOL] } <line_num>: 41,45
public Vector2D getStart() { [EOL]     return start; [EOL] } <line_num>: 50,52
public Vector2D getEnd() { [EOL]     return end; [EOL] } <line_num>: 57,59
public Line getLine() { [EOL]     return line; [EOL] } <line_num>: 64,66
public double distance(final Vector2D p) { [EOL]     final double deltaX = end.getX() - start.getX(); [EOL]     final double deltaY = end.getY() - start.getY(); [EOL]     final double r = ((p.getX() - start.getX()) * deltaX + (p.getY() - start.getY()) * deltaY) / (deltaX * deltaX + deltaY * deltaY); [EOL]     if (r < 0 || r > 1) { [EOL]         final double dist1 = getStart().distance(p); [EOL]         final double dist2 = getEnd().distance(p); [EOL]         return FastMath.min(dist1, dist2); [EOL]     } else { [EOL]         final double px = start.getX() + r * deltaX; [EOL]         final double py = start.getY() + r * deltaY; [EOL]         final Vector2D interPt = new Vector2D(px, py); [EOL]         return interPt.distance(p); [EOL]     } [EOL] } <line_num>: 83,111
