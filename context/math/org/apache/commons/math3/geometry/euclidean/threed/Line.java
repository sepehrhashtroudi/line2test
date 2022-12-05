public Line(final Vector3D p1, final Vector3D p2) throws MathIllegalArgumentException
public Line(final Line line)
public void reset(final Vector3D p1, final Vector3D p2) throws MathIllegalArgumentException
public Line revert()
public Vector3D getDirection()
public Vector3D getOrigin()
public double getAbscissa(final Vector3D point)
public Vector3D pointAt(final double abscissa)
public Vector1D toSubSpace(final Vector<Euclidean3D> point)
public Vector3D toSpace(final Vector<Euclidean1D> point)
public boolean isSimilarTo(final Line line)
public boolean contains(final Vector3D p)
public double distance(final Vector3D p)
public double distance(final Line line)
public Vector3D closestPoint(final Line line)
public Vector3D intersection(final Line line)
public SubLine wholeLine()
Vector3D direction
Vector3D zero
