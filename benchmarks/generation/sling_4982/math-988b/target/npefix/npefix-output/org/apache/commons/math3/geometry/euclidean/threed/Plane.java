package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.util.FastMath;

public class Plane implements Embedding<Euclidean3D, Euclidean2D> , Hyperplane<Euclidean3D> {
    private double originOffset;

    private Vector3D origin;

    private Vector3D u;

    private Vector3D v;

    private Vector3D w;

    public Plane(final Vector3D normal) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context44 = new ConstructorContext(Plane.class, 55, 2139, 2495);
        try {
            setNormal(normal);
            originOffset = 0;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 57, 2453, 2469);
            setFrame();
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public Plane(final Vector3D p, final Vector3D normal) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context45 = new ConstructorContext(Plane.class, 66, 2502, 2908);
        try {
            setNormal(normal);
            originOffset = -(p.dotProduct(w));
            CallChecker.varAssign(this.originOffset, "this.originOffset", 68, 2851, 2882);
            setFrame();
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public Plane(final Vector3D p1, final Vector3D p2, final Vector3D p3) throws MathArithmeticException {
        this(p1, p2.subtract(p1).crossProduct(p3.subtract(p1)));
        ConstructorContext _bcornu_methode_context46 = new ConstructorContext(Plane.class, 80, 2915, 3472);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public Plane(final Plane plane) {
        ConstructorContext _bcornu_methode_context47 = new ConstructorContext(Plane.class, 91, 3479, 3896);
        try {
            originOffset = plane.originOffset;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 92, 3748, 3781);
            origin = plane.origin;
            CallChecker.varAssign(this.origin, "this.origin", 93, 3791, 3812);
            u = plane.u;
            CallChecker.varAssign(this.u, "this.u", 94, 3822, 3838);
            v = plane.v;
            CallChecker.varAssign(this.v, "this.v", 95, 3848, 3864);
            w = plane.w;
            CallChecker.varAssign(this.w, "this.w", 96, 3874, 3890);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public Plane copySelf() {
        MethodContext _bcornu_methode_context173 = new MethodContext(Plane.class, 105, 3903, 4245);
        try {
            CallChecker.varInit(this, "this", 105, 3903, 4245);
            CallChecker.varInit(this.w, "w", 105, 3903, 4245);
            CallChecker.varInit(this.v, "v", 105, 3903, 4245);
            CallChecker.varInit(this.u, "u", 105, 3903, 4245);
            CallChecker.varInit(this.origin, "origin", 105, 3903, 4245);
            CallChecker.varInit(this.originOffset, "originOffset", 105, 3903, 4245);
            return new Plane(this);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Plane) (CallChecker.isToCatch(_bcornu_return_t, Plane.class)));
        } finally {
            _bcornu_methode_context173.methodEnd();
        }
    }

    public void reset(final Vector3D p, final Vector3D normal) throws MathArithmeticException {
        MethodContext _bcornu_methode_context174 = new MethodContext(void.class, 114, 4252, 4680);
        try {
            CallChecker.varInit(this, "this", 114, 4252, 4680);
            CallChecker.varInit(normal, "normal", 114, 4252, 4680);
            CallChecker.varInit(p, "p", 114, 4252, 4680);
            CallChecker.varInit(this.w, "w", 114, 4252, 4680);
            CallChecker.varInit(this.v, "v", 114, 4252, 4680);
            CallChecker.varInit(this.u, "u", 114, 4252, 4680);
            CallChecker.varInit(this.origin, "origin", 114, 4252, 4680);
            CallChecker.varInit(this.originOffset, "originOffset", 114, 4252, 4680);
            setNormal(normal);
            originOffset = -(p.dotProduct(w));
            CallChecker.varAssign(this.originOffset, "this.originOffset", 116, 4623, 4654);
            setFrame();
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    public void reset(final Plane original) {
        MethodContext _bcornu_methode_context175 = new MethodContext(void.class, 126, 4687, 5178);
        try {
            CallChecker.varInit(this, "this", 126, 4687, 5178);
            CallChecker.varInit(original, "original", 126, 4687, 5178);
            CallChecker.varInit(this.w, "w", 126, 4687, 5178);
            CallChecker.varInit(this.v, "v", 126, 4687, 5178);
            CallChecker.varInit(this.u, "u", 126, 4687, 5178);
            CallChecker.varInit(this.origin, "origin", 126, 4687, 5178);
            CallChecker.varInit(this.originOffset, "originOffset", 126, 4687, 5178);
            originOffset = original.originOffset;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 127, 4991, 5027);
            origin = original.origin;
            CallChecker.varAssign(this.origin, "this.origin", 128, 5037, 5067);
            u = original.u;
            CallChecker.varAssign(this.u, "this.u", 129, 5077, 5102);
            v = original.v;
            CallChecker.varAssign(this.v, "this.v", 130, 5112, 5137);
            w = original.w;
            CallChecker.varAssign(this.w, "this.w", 131, 5147, 5172);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context175.methodEnd();
        }
    }

    private void setNormal(final Vector3D normal) throws MathArithmeticException {
        MethodContext _bcornu_methode_context176 = new MethodContext(void.class, 138, 5185, 5656);
        try {
            CallChecker.varInit(this, "this", 138, 5185, 5656);
            CallChecker.varInit(normal, "normal", 138, 5185, 5656);
            CallChecker.varInit(this.w, "w", 138, 5185, 5656);
            CallChecker.varInit(this.v, "v", 138, 5185, 5656);
            CallChecker.varInit(this.u, "u", 138, 5185, 5656);
            CallChecker.varInit(this.origin, "origin", 138, 5185, 5656);
            CallChecker.varInit(this.originOffset, "originOffset", 138, 5185, 5656);
            final double norm = CallChecker.varInit(((double) (normal.getNorm())), "norm", 139, 5453, 5489);
            if (norm < 1.0E-10) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            w = new Vector3D((1.0 / norm), normal);
            CallChecker.varAssign(this.w, "this.w", 143, 5614, 5650);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context176.methodEnd();
        }
    }

    private void setFrame() {
        MethodContext _bcornu_methode_context177 = new MethodContext(void.class, 148, 5663, 5850);
        try {
            CallChecker.varInit(this, "this", 148, 5663, 5850);
            CallChecker.varInit(this.w, "w", 148, 5663, 5850);
            CallChecker.varInit(this.v, "v", 148, 5663, 5850);
            CallChecker.varInit(this.u, "u", 148, 5663, 5850);
            CallChecker.varInit(this.origin, "origin", 148, 5663, 5850);
            CallChecker.varInit(this.originOffset, "originOffset", 148, 5663, 5850);
            origin = new Vector3D((-(originOffset)), w);
            CallChecker.varAssign(this.origin, "this.origin", 149, 5736, 5775);
            u = w.orthogonal();
            CallChecker.varAssign(this.u, "this.u", 150, 5785, 5803);
            v = Vector3D.crossProduct(w, u);
            CallChecker.varAssign(this.v, "this.v", 151, 5813, 5844);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context177.methodEnd();
        }
    }

    public Vector3D getOrigin() {
        MethodContext _bcornu_methode_context178 = new MethodContext(Vector3D.class, 160, 5857, 6174);
        try {
            CallChecker.varInit(this, "this", 160, 5857, 6174);
            CallChecker.varInit(this.w, "w", 160, 5857, 6174);
            CallChecker.varInit(this.v, "v", 160, 5857, 6174);
            CallChecker.varInit(this.u, "u", 160, 5857, 6174);
            CallChecker.varInit(this.origin, "origin", 160, 5857, 6174);
            CallChecker.varInit(this.originOffset, "originOffset", 160, 5857, 6174);
            return origin;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context178.methodEnd();
        }
    }

    public Vector3D getNormal() {
        MethodContext _bcornu_methode_context179 = new MethodContext(Vector3D.class, 172, 6181, 6521);
        try {
            CallChecker.varInit(this, "this", 172, 6181, 6521);
            CallChecker.varInit(this.w, "w", 172, 6181, 6521);
            CallChecker.varInit(this.v, "v", 172, 6181, 6521);
            CallChecker.varInit(this.u, "u", 172, 6181, 6521);
            CallChecker.varInit(this.origin, "origin", 172, 6181, 6521);
            CallChecker.varInit(this.originOffset, "originOffset", 172, 6181, 6521);
            return w;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context179.methodEnd();
        }
    }

    public Vector3D getU() {
        MethodContext _bcornu_methode_context180 = new MethodContext(Vector3D.class, 184, 6528, 6881);
        try {
            CallChecker.varInit(this, "this", 184, 6528, 6881);
            CallChecker.varInit(this.w, "w", 184, 6528, 6881);
            CallChecker.varInit(this.v, "v", 184, 6528, 6881);
            CallChecker.varInit(this.u, "u", 184, 6528, 6881);
            CallChecker.varInit(this.origin, "origin", 184, 6528, 6881);
            CallChecker.varInit(this.originOffset, "originOffset", 184, 6528, 6881);
            return u;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context180.methodEnd();
        }
    }

    public Vector3D getV() {
        MethodContext _bcornu_methode_context181 = new MethodContext(Vector3D.class, 196, 6888, 7243);
        try {
            CallChecker.varInit(this, "this", 196, 6888, 7243);
            CallChecker.varInit(this.w, "w", 196, 6888, 7243);
            CallChecker.varInit(this.v, "v", 196, 6888, 7243);
            CallChecker.varInit(this.u, "u", 196, 6888, 7243);
            CallChecker.varInit(this.origin, "origin", 196, 6888, 7243);
            CallChecker.varInit(this.originOffset, "originOffset", 196, 6888, 7243);
            return v;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context181.methodEnd();
        }
    }

    public void revertSelf() {
        MethodContext _bcornu_methode_context182 = new MethodContext(void.class, 211, 7250, 8071);
        try {
            CallChecker.varInit(this, "this", 211, 7250, 8071);
            CallChecker.varInit(this.w, "w", 211, 7250, 8071);
            CallChecker.varInit(this.v, "v", 211, 7250, 8071);
            CallChecker.varInit(this.u, "u", 211, 7250, 8071);
            CallChecker.varInit(this.origin, "origin", 211, 7250, 8071);
            CallChecker.varInit(this.originOffset, "originOffset", 211, 7250, 8071);
            final Vector3D tmp = CallChecker.varInit(u, "tmp", 212, 7949, 7971);
            u = v;
            CallChecker.varAssign(this.u, "this.u", 213, 7981, 7986);
            v = tmp;
            CallChecker.varAssign(this.v, "this.v", 214, 7996, 8003);
            w = w.negate();
            CallChecker.varAssign(this.w, "this.w", 215, 8013, 8027);
            originOffset = -(originOffset);
            CallChecker.varAssign(this.originOffset, "this.originOffset", 216, 8037, 8065);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context182.methodEnd();
        }
    }

    public Vector2D toSubSpace(final Vector<Euclidean3D> point) {
        MethodContext _bcornu_methode_context183 = new MethodContext(Vector2D.class, 226, 8078, 8528);
        try {
            CallChecker.varInit(this, "this", 226, 8078, 8528);
            CallChecker.varInit(point, "point", 226, 8078, 8528);
            CallChecker.varInit(this.w, "w", 226, 8078, 8528);
            CallChecker.varInit(this.v, "v", 226, 8078, 8528);
            CallChecker.varInit(this.u, "u", 226, 8078, 8528);
            CallChecker.varInit(this.origin, "origin", 226, 8078, 8528);
            CallChecker.varInit(this.originOffset, "originOffset", 226, 8078, 8528);
            return new Vector2D(point.dotProduct(u), point.dotProduct(v));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector2D) (CallChecker.isToCatch(_bcornu_return_t, Vector2D.class)));
        } finally {
            _bcornu_methode_context183.methodEnd();
        }
    }

    public Vector3D toSpace(final Vector<Euclidean2D> point) {
        MethodContext _bcornu_methode_context184 = new MethodContext(Vector3D.class, 236, 8535, 9027);
        try {
            CallChecker.varInit(this, "this", 236, 8535, 9027);
            CallChecker.varInit(point, "point", 236, 8535, 9027);
            CallChecker.varInit(this.w, "w", 236, 8535, 9027);
            CallChecker.varInit(this.v, "v", 236, 8535, 9027);
            CallChecker.varInit(this.u, "u", 236, 8535, 9027);
            CallChecker.varInit(this.origin, "origin", 236, 8535, 9027);
            CallChecker.varInit(this.originOffset, "originOffset", 236, 8535, 9027);
            final Vector2D p2D = CallChecker.varInit(((Vector2D) (point)), "p2D", 237, 8907, 8944);
            return new Vector3D(p2D.getX(), u, p2D.getY(), v, (-(originOffset)), w);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context184.methodEnd();
        }
    }

    public Vector3D getPointAt(final Vector2D inPlane, final double offset) {
        MethodContext _bcornu_methode_context185 = new MethodContext(Vector3D.class, 248, 9034, 9494);
        try {
            CallChecker.varInit(this, "this", 248, 9034, 9494);
            CallChecker.varInit(offset, "offset", 248, 9034, 9494);
            CallChecker.varInit(inPlane, "inPlane", 248, 9034, 9494);
            CallChecker.varInit(this.w, "w", 248, 9034, 9494);
            CallChecker.varInit(this.v, "v", 248, 9034, 9494);
            CallChecker.varInit(this.u, "u", 248, 9034, 9494);
            CallChecker.varInit(this.origin, "origin", 248, 9034, 9494);
            CallChecker.varInit(this.originOffset, "originOffset", 248, 9034, 9494);
            return new Vector3D(inPlane.getX(), u, inPlane.getY(), v, (offset - (originOffset)), w);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context185.methodEnd();
        }
    }

    public boolean isSimilarTo(final Plane plane) {
        MethodContext _bcornu_methode_context186 = new MethodContext(boolean.class, 259, 9501, 10162);
        try {
            CallChecker.varInit(this, "this", 259, 9501, 10162);
            CallChecker.varInit(plane, "plane", 259, 9501, 10162);
            CallChecker.varInit(this.w, "w", 259, 9501, 10162);
            CallChecker.varInit(this.v, "v", 259, 9501, 10162);
            CallChecker.varInit(this.u, "u", 259, 9501, 10162);
            CallChecker.varInit(this.origin, "origin", 259, 9501, 10162);
            CallChecker.varInit(this.originOffset, "originOffset", 259, 9501, 10162);
            final double angle = CallChecker.varInit(((double) (Vector3D.angle(this.w, plane.w))), "angle", 260, 9893, 9940);
            return ((angle < 1.0E-10) && ((FastMath.abs(((originOffset) - (plane.originOffset)))) < 1.0E-10)) || ((angle > ((FastMath.PI) - 1.0E-10)) && ((FastMath.abs(((originOffset) + (plane.originOffset)))) < 1.0E-10));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context186.methodEnd();
        }
    }

    public Plane rotate(final Vector3D center, final Rotation rotation) {
        MethodContext _bcornu_methode_context187 = new MethodContext(Plane.class, 271, 10169, 10842);
        try {
            CallChecker.varInit(this, "this", 271, 10169, 10842);
            CallChecker.varInit(rotation, "rotation", 271, 10169, 10842);
            CallChecker.varInit(center, "center", 271, 10169, 10842);
            CallChecker.varInit(this.w, "w", 271, 10169, 10842);
            CallChecker.varInit(this.v, "v", 271, 10169, 10842);
            CallChecker.varInit(this.u, "u", 271, 10169, 10842);
            CallChecker.varInit(this.origin, "origin", 271, 10169, 10842);
            CallChecker.varInit(this.originOffset, "originOffset", 271, 10169, 10842);
            final Vector3D delta = CallChecker.varInit(origin.subtract(center), "delta", 273, 10495, 10541);
            final Plane plane = CallChecker.varInit(new Plane(center.add(rotation.applyTo(delta)), rotation.applyTo(w)), "plane", 274, 10551, 10676);
            plane.u = rotation.applyTo(u);
            CallChecker.varAssign(plane.u, "plane.u", 278, 10744, 10773);
            plane.v = rotation.applyTo(v);
            CallChecker.varAssign(plane.v, "plane.v", 279, 10783, 10812);
            return plane;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Plane) (CallChecker.isToCatch(_bcornu_return_t, Plane.class)));
        } finally {
            _bcornu_methode_context187.methodEnd();
        }
    }

    public Plane translate(final Vector3D translation) {
        MethodContext _bcornu_methode_context188 = new MethodContext(Plane.class, 290, 10849, 11304);
        try {
            CallChecker.varInit(this, "this", 290, 10849, 11304);
            CallChecker.varInit(translation, "translation", 290, 10849, 11304);
            CallChecker.varInit(this.w, "w", 290, 10849, 11304);
            CallChecker.varInit(this.v, "v", 290, 10849, 11304);
            CallChecker.varInit(this.u, "u", 290, 10849, 11304);
            CallChecker.varInit(this.origin, "origin", 290, 10849, 11304);
            CallChecker.varInit(this.originOffset, "originOffset", 290, 10849, 11304);
            final Plane plane = CallChecker.varInit(new Plane(origin.add(translation), w), "plane", 292, 11117, 11174);
            plane.u = u;
            CallChecker.varAssign(plane.u, "plane.u", 295, 11242, 11253);
            plane.v = v;
            CallChecker.varAssign(plane.v, "plane.v", 296, 11263, 11274);
            return plane;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Plane) (CallChecker.isToCatch(_bcornu_return_t, Plane.class)));
        } finally {
            _bcornu_methode_context188.methodEnd();
        }
    }

    public Vector3D intersection(final Line line) {
        MethodContext _bcornu_methode_context189 = new MethodContext(Vector3D.class, 307, 11311, 11994);
        try {
            CallChecker.varInit(this, "this", 307, 11311, 11994);
            CallChecker.varInit(line, "line", 307, 11311, 11994);
            CallChecker.varInit(this.w, "w", 307, 11311, 11994);
            CallChecker.varInit(this.v, "v", 307, 11311, 11994);
            CallChecker.varInit(this.u, "u", 307, 11311, 11994);
            CallChecker.varInit(this.origin, "origin", 307, 11311, 11994);
            CallChecker.varInit(this.originOffset, "originOffset", 307, 11311, 11994);
            final Vector3D direction = CallChecker.varInit(line.getDirection(), "direction", 308, 11613, 11659);
            final double dot = CallChecker.varInit(((double) (this.w.dotProduct(direction))), "dot", 309, 11669, 11719);
            if ((FastMath.abs(dot)) < 1.0E-10) {
                return null;
            }
            final Vector3D point = CallChecker.varInit(line.toSpace(Vector1D.ZERO), "point", 313, 11807, 11857);
            final double k = CallChecker.varInit(((double) ((-((this.originOffset) + (this.w.dotProduct(point)))) / dot)), "k", 314, 11867, 11933);
            return new Vector3D(1.0, point, k, direction);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context189.methodEnd();
        }
    }

    public Line intersection(final Plane other) {
        MethodContext _bcornu_methode_context190 = new MethodContext(Line.class, 323, 12001, 12561);
        try {
            CallChecker.varInit(this, "this", 323, 12001, 12561);
            CallChecker.varInit(other, "other", 323, 12001, 12561);
            CallChecker.varInit(this.w, "w", 323, 12001, 12561);
            CallChecker.varInit(this.v, "v", 323, 12001, 12561);
            CallChecker.varInit(this.u, "u", 323, 12001, 12561);
            CallChecker.varInit(this.origin, "origin", 323, 12001, 12561);
            CallChecker.varInit(this.originOffset, "originOffset", 323, 12001, 12561);
            final Vector3D direction = CallChecker.varInit(Vector3D.crossProduct(w, other.w), "direction", 324, 12281, 12341);
            if ((direction.getNorm()) < 1.0E-10) {
                return null;
            }
            final Vector3D point = CallChecker.varInit(Plane.intersection(this, other, new Plane(direction)), "point", 328, 12431, 12501);
            return new Line(point, point.add(direction));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Line) (CallChecker.isToCatch(_bcornu_return_t, Line.class)));
        } finally {
            _bcornu_methode_context190.methodEnd();
        }
    }

    public static Vector3D intersection(final Plane plane1, final Plane plane2, final Plane plane3) {
        MethodContext _bcornu_methode_context191 = new MethodContext(Vector3D.class, 338, 12568, 14308);
        try {
            CallChecker.varInit(plane3, "plane3", 338, 12568, 14308);
            CallChecker.varInit(plane2, "plane2", 338, 12568, 14308);
            CallChecker.varInit(plane1, "plane1", 338, 12568, 14308);
            final double a1 = CallChecker.varInit(((double) (plane1.w.getX())), "a1", 341, 12922, 13016);
            final double b1 = CallChecker.varInit(((double) (plane1.w.getY())), "b1", 342, 13026, 13059);
            final double c1 = CallChecker.varInit(((double) (plane1.w.getZ())), "c1", 343, 13069, 13102);
            final double d1 = CallChecker.varInit(((double) (plane1.originOffset)), "d1", 344, 13112, 13149);
            final double a2 = CallChecker.varInit(((double) (plane2.w.getX())), "a2", 346, 13160, 13193);
            final double b2 = CallChecker.varInit(((double) (plane2.w.getY())), "b2", 347, 13203, 13236);
            final double c2 = CallChecker.varInit(((double) (plane2.w.getZ())), "c2", 348, 13246, 13279);
            final double d2 = CallChecker.varInit(((double) (plane2.originOffset)), "d2", 349, 13289, 13326);
            final double a3 = CallChecker.varInit(((double) (plane3.w.getX())), "a3", 351, 13337, 13370);
            final double b3 = CallChecker.varInit(((double) (plane3.w.getY())), "b3", 352, 13380, 13413);
            final double c3 = CallChecker.varInit(((double) (plane3.w.getZ())), "c3", 353, 13423, 13456);
            final double d3 = CallChecker.varInit(((double) (plane3.originOffset)), "d3", 354, 13466, 13503);
            final double a23 = CallChecker.varInit(((double) ((b2 * c3) - (b3 * c2))), "a23", 358, 13514, 13668);
            final double b23 = CallChecker.varInit(((double) ((c2 * a3) - (c3 * a2))), "b23", 359, 13678, 13722);
            final double c23 = CallChecker.varInit(((double) ((a2 * b3) - (a3 * b2))), "c23", 360, 13732, 13776);
            final double determinant = CallChecker.varInit(((double) (((a1 * a23) + (b1 * b23)) + (c1 * c23))), "determinant", 361, 13786, 13843);
            if ((FastMath.abs(determinant)) < 1.0E-10) {
                return null;
            }
            final double r = CallChecker.varInit(((double) (1.0 / determinant)), "r", 366, 13940, 13974);
            return new Vector3D((((((-a23) * d1) - (((c1 * b3) - (c3 * b1)) * d2)) - (((c2 * b1) - (c1 * b2)) * d3)) * r), (((((-b23) * d1) - (((c3 * a1) - (c1 * a3)) * d2)) - (((c1 * a2) - (c2 * a1)) * d3)) * r), (((((-c23) * d1) - (((b1 * a3) - (b3 * a1)) * d2)) - (((b2 * a1) - (b1 * a2)) * d3)) * r));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context191.methodEnd();
        }
    }

    public SubPlane wholeHyperplane() {
        MethodContext _bcornu_methode_context192 = new MethodContext(SubPlane.class, 377, 14315, 14525);
        try {
            CallChecker.varInit(this, "this", 377, 14315, 14525);
            CallChecker.varInit(this.w, "w", 377, 14315, 14525);
            CallChecker.varInit(this.v, "v", 377, 14315, 14525);
            CallChecker.varInit(this.u, "u", 377, 14315, 14525);
            CallChecker.varInit(this.origin, "origin", 377, 14315, 14525);
            CallChecker.varInit(this.originOffset, "originOffset", 377, 14315, 14525);
            return new SubPlane(this, new PolygonsSet());
        } catch (RuntimeException _bcornu_return_t) {
            return ((SubPlane) (CallChecker.isToCatch(_bcornu_return_t, SubPlane.class)));
        } finally {
            _bcornu_methode_context192.methodEnd();
        }
    }

    public PolyhedronsSet wholeSpace() {
        MethodContext _bcornu_methode_context193 = new MethodContext(PolyhedronsSet.class, 385, 14532, 14780);
        try {
            CallChecker.varInit(this, "this", 385, 14532, 14780);
            CallChecker.varInit(this.w, "w", 385, 14532, 14780);
            CallChecker.varInit(this.v, "v", 385, 14532, 14780);
            CallChecker.varInit(this.u, "u", 385, 14532, 14780);
            CallChecker.varInit(this.origin, "origin", 385, 14532, 14780);
            CallChecker.varInit(this.originOffset, "originOffset", 385, 14532, 14780);
            return new PolyhedronsSet();
        } catch (RuntimeException _bcornu_return_t) {
            return ((PolyhedronsSet) (CallChecker.isToCatch(_bcornu_return_t, PolyhedronsSet.class)));
        } finally {
            _bcornu_methode_context193.methodEnd();
        }
    }

    public boolean contains(final Vector3D p) {
        MethodContext _bcornu_methode_context194 = new MethodContext(boolean.class, 393, 14787, 15021);
        try {
            CallChecker.varInit(this, "this", 393, 14787, 15021);
            CallChecker.varInit(p, "p", 393, 14787, 15021);
            CallChecker.varInit(this.w, "w", 393, 14787, 15021);
            CallChecker.varInit(this.v, "v", 393, 14787, 15021);
            CallChecker.varInit(this.u, "u", 393, 14787, 15021);
            CallChecker.varInit(this.origin, "origin", 393, 14787, 15021);
            CallChecker.varInit(this.originOffset, "originOffset", 393, 14787, 15021);
            return (FastMath.abs(getOffset(p))) < 1.0E-10;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context194.methodEnd();
        }
    }

    public double getOffset(final Plane plane) {
        MethodContext _bcornu_methode_context195 = new MethodContext(double.class, 407, 15028, 15658);
        try {
            CallChecker.varInit(this, "this", 407, 15028, 15658);
            CallChecker.varInit(plane, "plane", 407, 15028, 15658);
            CallChecker.varInit(this.w, "w", 407, 15028, 15658);
            CallChecker.varInit(this.v, "v", 407, 15028, 15658);
            CallChecker.varInit(this.u, "u", 407, 15028, 15658);
            CallChecker.varInit(this.origin, "origin", 407, 15028, 15658);
            CallChecker.varInit(this.originOffset, "originOffset", 407, 15028, 15658);
            return (originOffset) + (sameOrientationAs(plane) ? -(plane.originOffset) : plane.originOffset);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context195.methodEnd();
        }
    }

    public double getOffset(final Vector<Euclidean3D> point) {
        MethodContext _bcornu_methode_context196 = new MethodContext(double.class, 419, 15665, 16185);
        try {
            CallChecker.varInit(this, "this", 419, 15665, 16185);
            CallChecker.varInit(point, "point", 419, 15665, 16185);
            CallChecker.varInit(this.w, "w", 419, 15665, 16185);
            CallChecker.varInit(this.v, "v", 419, 15665, 16185);
            CallChecker.varInit(this.u, "u", 419, 15665, 16185);
            CallChecker.varInit(this.origin, "origin", 419, 15665, 16185);
            CallChecker.varInit(this.originOffset, "originOffset", 419, 15665, 16185);
            return (point.dotProduct(w)) + (originOffset);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context196.methodEnd();
        }
    }

    public boolean sameOrientationAs(final Hyperplane<Euclidean3D> other) {
        MethodContext _bcornu_methode_context197 = new MethodContext(boolean.class, 428, 16192, 16571);
        try {
            CallChecker.varInit(this, "this", 428, 16192, 16571);
            CallChecker.varInit(other, "other", 428, 16192, 16571);
            CallChecker.varInit(this.w, "w", 428, 16192, 16571);
            CallChecker.varInit(this.v, "v", 428, 16192, 16571);
            CallChecker.varInit(this.u, "u", 428, 16192, 16571);
            CallChecker.varInit(this.origin, "origin", 428, 16192, 16571);
            CallChecker.varInit(this.originOffset, "originOffset", 428, 16192, 16571);
            return (((Plane) (other)).w.dotProduct(w)) > 0.0;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context197.methodEnd();
        }
    }
}

