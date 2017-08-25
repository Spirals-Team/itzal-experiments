package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
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
        ConstructorContext _bcornu_methode_context850 = new ConstructorContext(Plane.class, 55, 2094, 2450);
        try {
            setNormal(normal);
            originOffset = 0;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 57, 2408, 2424);
            setFrame();
        } finally {
            _bcornu_methode_context850.methodEnd();
        }
    }

    public Plane(final Vector3D p, final Vector3D normal) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context851 = new ConstructorContext(Plane.class, 66, 2457, 2863);
        try {
            setNormal(normal);
            if (CallChecker.beforeDeref(p, Vector3D.class, 68, 2822, 2822)) {
                originOffset = -(CallChecker.isCalled(p, Vector3D.class, 68, 2822, 2822).dotProduct(w));
                CallChecker.varAssign(this.originOffset, "this.originOffset", 68, 2806, 2837);
            }
            setFrame();
        } finally {
            _bcornu_methode_context851.methodEnd();
        }
    }

    public Plane(final Vector3D p1, final Vector3D p2, final Vector3D p3) throws MathArithmeticException {
        this(p1, CallChecker.isCalled(CallChecker.isCalled(p2, Vector3D.class, 82, 3375, 3376).subtract(p1), Vector3D.class, 82, 3375, 3389).crossProduct(CallChecker.isCalled(p3, Vector3D.class, 82, 3404, 3405).subtract(p1)));
        ConstructorContext _bcornu_methode_context852 = new ConstructorContext(Plane.class, 80, 2870, 3427);
        try {
        } finally {
            _bcornu_methode_context852.methodEnd();
        }
    }

    public Plane(final Plane plane) {
        ConstructorContext _bcornu_methode_context853 = new ConstructorContext(Plane.class, 91, 3434, 3851);
        try {
            if (CallChecker.beforeDeref(plane, Plane.class, 92, 3718, 3722)) {
                originOffset = CallChecker.isCalled(plane, Plane.class, 92, 3718, 3722).originOffset;
                CallChecker.varAssign(this.originOffset, "this.originOffset", 92, 3703, 3736);
            }
            if (CallChecker.beforeDeref(plane, Plane.class, 93, 3755, 3759)) {
                origin = CallChecker.isCalled(plane, Plane.class, 93, 3755, 3759).origin;
                CallChecker.varAssign(this.origin, "this.origin", 93, 3746, 3767);
            }
            if (CallChecker.beforeDeref(plane, Plane.class, 94, 3786, 3790)) {
                u = CallChecker.isCalled(plane, Plane.class, 94, 3786, 3790).u;
                CallChecker.varAssign(this.u, "this.u", 94, 3777, 3793);
            }
            if (CallChecker.beforeDeref(plane, Plane.class, 95, 3812, 3816)) {
                v = CallChecker.isCalled(plane, Plane.class, 95, 3812, 3816).v;
                CallChecker.varAssign(this.v, "this.v", 95, 3803, 3819);
            }
            if (CallChecker.beforeDeref(plane, Plane.class, 96, 3838, 3842)) {
                w = CallChecker.isCalled(plane, Plane.class, 96, 3838, 3842).w;
                CallChecker.varAssign(this.w, "this.w", 96, 3829, 3845);
            }
        } finally {
            _bcornu_methode_context853.methodEnd();
        }
    }

    public Plane copySelf() {
        MethodContext _bcornu_methode_context3707 = new MethodContext(Plane.class, 105, 3858, 4200);
        try {
            CallChecker.varInit(this, "this", 105, 3858, 4200);
            CallChecker.varInit(this.w, "w", 105, 3858, 4200);
            CallChecker.varInit(this.v, "v", 105, 3858, 4200);
            CallChecker.varInit(this.u, "u", 105, 3858, 4200);
            CallChecker.varInit(this.origin, "origin", 105, 3858, 4200);
            CallChecker.varInit(this.originOffset, "originOffset", 105, 3858, 4200);
            return new Plane(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Plane) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3707.methodEnd();
        }
    }

    public void reset(final Vector3D p, final Vector3D normal) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3708 = new MethodContext(void.class, 114, 4207, 4635);
        try {
            CallChecker.varInit(this, "this", 114, 4207, 4635);
            CallChecker.varInit(normal, "normal", 114, 4207, 4635);
            CallChecker.varInit(p, "p", 114, 4207, 4635);
            CallChecker.varInit(this.w, "w", 114, 4207, 4635);
            CallChecker.varInit(this.v, "v", 114, 4207, 4635);
            CallChecker.varInit(this.u, "u", 114, 4207, 4635);
            CallChecker.varInit(this.origin, "origin", 114, 4207, 4635);
            CallChecker.varInit(this.originOffset, "originOffset", 114, 4207, 4635);
            setNormal(normal);
            if (CallChecker.beforeDeref(p, Vector3D.class, 116, 4594, 4594)) {
                originOffset = -(CallChecker.isCalled(p, Vector3D.class, 116, 4594, 4594).dotProduct(w));
                CallChecker.varAssign(this.originOffset, "this.originOffset", 116, 4578, 4609);
            }
            setFrame();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3708.methodEnd();
        }
    }

    public void reset(final Plane original) {
        MethodContext _bcornu_methode_context3709 = new MethodContext(void.class, 126, 4642, 5133);
        try {
            CallChecker.varInit(this, "this", 126, 4642, 5133);
            CallChecker.varInit(original, "original", 126, 4642, 5133);
            CallChecker.varInit(this.w, "w", 126, 4642, 5133);
            CallChecker.varInit(this.v, "v", 126, 4642, 5133);
            CallChecker.varInit(this.u, "u", 126, 4642, 5133);
            CallChecker.varInit(this.origin, "origin", 126, 4642, 5133);
            CallChecker.varInit(this.originOffset, "originOffset", 126, 4642, 5133);
            if (CallChecker.beforeDeref(original, Plane.class, 127, 4961, 4968)) {
                originOffset = CallChecker.isCalled(original, Plane.class, 127, 4961, 4968).originOffset;
                CallChecker.varAssign(this.originOffset, "this.originOffset", 127, 4946, 4982);
            }
            if (CallChecker.beforeDeref(original, Plane.class, 128, 5007, 5014)) {
                origin = CallChecker.isCalled(original, Plane.class, 128, 5007, 5014).origin;
                CallChecker.varAssign(this.origin, "this.origin", 128, 4992, 5022);
            }
            if (CallChecker.beforeDeref(original, Plane.class, 129, 5047, 5054)) {
                u = CallChecker.isCalled(original, Plane.class, 129, 5047, 5054).u;
                CallChecker.varAssign(this.u, "this.u", 129, 5032, 5057);
            }
            if (CallChecker.beforeDeref(original, Plane.class, 130, 5082, 5089)) {
                v = CallChecker.isCalled(original, Plane.class, 130, 5082, 5089).v;
                CallChecker.varAssign(this.v, "this.v", 130, 5067, 5092);
            }
            if (CallChecker.beforeDeref(original, Plane.class, 131, 5117, 5124)) {
                w = CallChecker.isCalled(original, Plane.class, 131, 5117, 5124).w;
                CallChecker.varAssign(this.w, "this.w", 131, 5102, 5127);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3709.methodEnd();
        }
    }

    private void setNormal(final Vector3D normal) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3710 = new MethodContext(void.class, 138, 5140, 5611);
        try {
            CallChecker.varInit(this, "this", 138, 5140, 5611);
            CallChecker.varInit(normal, "normal", 138, 5140, 5611);
            CallChecker.varInit(this.w, "w", 138, 5140, 5611);
            CallChecker.varInit(this.v, "v", 138, 5140, 5611);
            CallChecker.varInit(this.u, "u", 138, 5140, 5611);
            CallChecker.varInit(this.origin, "origin", 138, 5140, 5611);
            CallChecker.varInit(this.originOffset, "originOffset", 138, 5140, 5611);
            final double norm = CallChecker.varInit(((double) (CallChecker.isCalled(normal, Vector3D.class, 139, 5428, 5433).getNorm())), "norm", 139, 5408, 5444);
            if (norm < 1.0E-10) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            w = new Vector3D((1.0 / norm), normal);
            CallChecker.varAssign(this.w, "this.w", 143, 5569, 5605);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3710.methodEnd();
        }
    }

    private void setFrame() {
        MethodContext _bcornu_methode_context3711 = new MethodContext(void.class, 148, 5618, 5805);
        try {
            CallChecker.varInit(this, "this", 148, 5618, 5805);
            CallChecker.varInit(this.w, "w", 148, 5618, 5805);
            CallChecker.varInit(this.v, "v", 148, 5618, 5805);
            CallChecker.varInit(this.u, "u", 148, 5618, 5805);
            CallChecker.varInit(this.origin, "origin", 148, 5618, 5805);
            CallChecker.varInit(this.originOffset, "originOffset", 148, 5618, 5805);
            origin = new Vector3D((-(originOffset)), w);
            CallChecker.varAssign(this.origin, "this.origin", 149, 5691, 5730);
            if (CallChecker.beforeDeref(w, Vector3D.class, 150, 5744, 5744)) {
                w = CallChecker.beforeCalled(w, Vector3D.class, 150, 5744, 5744);
                u = CallChecker.isCalled(w, Vector3D.class, 150, 5744, 5744).orthogonal();
                CallChecker.varAssign(this.u, "this.u", 150, 5740, 5758);
            }
            v = Vector3D.crossProduct(w, u);
            CallChecker.varAssign(this.v, "this.v", 151, 5768, 5799);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3711.methodEnd();
        }
    }

    public Vector3D getOrigin() {
        MethodContext _bcornu_methode_context3712 = new MethodContext(Vector3D.class, 160, 5812, 6129);
        try {
            CallChecker.varInit(this, "this", 160, 5812, 6129);
            CallChecker.varInit(this.w, "w", 160, 5812, 6129);
            CallChecker.varInit(this.v, "v", 160, 5812, 6129);
            CallChecker.varInit(this.u, "u", 160, 5812, 6129);
            CallChecker.varInit(this.origin, "origin", 160, 5812, 6129);
            CallChecker.varInit(this.originOffset, "originOffset", 160, 5812, 6129);
            return origin;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3712.methodEnd();
        }
    }

    public Vector3D getNormal() {
        MethodContext _bcornu_methode_context3713 = new MethodContext(Vector3D.class, 172, 6136, 6476);
        try {
            CallChecker.varInit(this, "this", 172, 6136, 6476);
            CallChecker.varInit(this.w, "w", 172, 6136, 6476);
            CallChecker.varInit(this.v, "v", 172, 6136, 6476);
            CallChecker.varInit(this.u, "u", 172, 6136, 6476);
            CallChecker.varInit(this.origin, "origin", 172, 6136, 6476);
            CallChecker.varInit(this.originOffset, "originOffset", 172, 6136, 6476);
            return w;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3713.methodEnd();
        }
    }

    public Vector3D getU() {
        MethodContext _bcornu_methode_context3714 = new MethodContext(Vector3D.class, 184, 6483, 6836);
        try {
            CallChecker.varInit(this, "this", 184, 6483, 6836);
            CallChecker.varInit(this.w, "w", 184, 6483, 6836);
            CallChecker.varInit(this.v, "v", 184, 6483, 6836);
            CallChecker.varInit(this.u, "u", 184, 6483, 6836);
            CallChecker.varInit(this.origin, "origin", 184, 6483, 6836);
            CallChecker.varInit(this.originOffset, "originOffset", 184, 6483, 6836);
            return u;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3714.methodEnd();
        }
    }

    public Vector3D getV() {
        MethodContext _bcornu_methode_context3715 = new MethodContext(Vector3D.class, 196, 6843, 7198);
        try {
            CallChecker.varInit(this, "this", 196, 6843, 7198);
            CallChecker.varInit(this.w, "w", 196, 6843, 7198);
            CallChecker.varInit(this.v, "v", 196, 6843, 7198);
            CallChecker.varInit(this.u, "u", 196, 6843, 7198);
            CallChecker.varInit(this.origin, "origin", 196, 6843, 7198);
            CallChecker.varInit(this.originOffset, "originOffset", 196, 6843, 7198);
            return v;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3715.methodEnd();
        }
    }

    public void revertSelf() {
        MethodContext _bcornu_methode_context3716 = new MethodContext(void.class, 211, 7205, 8026);
        try {
            CallChecker.varInit(this, "this", 211, 7205, 8026);
            CallChecker.varInit(this.w, "w", 211, 7205, 8026);
            CallChecker.varInit(this.v, "v", 211, 7205, 8026);
            CallChecker.varInit(this.u, "u", 211, 7205, 8026);
            CallChecker.varInit(this.origin, "origin", 211, 7205, 8026);
            CallChecker.varInit(this.originOffset, "originOffset", 211, 7205, 8026);
            final Vector3D tmp = CallChecker.varInit(u, "tmp", 212, 7904, 7926);
            u = v;
            CallChecker.varAssign(this.u, "this.u", 213, 7936, 7941);
            v = tmp;
            CallChecker.varAssign(this.v, "this.v", 214, 7951, 7958);
            if (CallChecker.beforeDeref(w, Vector3D.class, 215, 7972, 7972)) {
                w = CallChecker.beforeCalled(w, Vector3D.class, 215, 7972, 7972);
                w = CallChecker.isCalled(w, Vector3D.class, 215, 7972, 7972).negate();
                CallChecker.varAssign(this.w, "this.w", 215, 7968, 7982);
            }
            originOffset = -(originOffset);
            CallChecker.varAssign(this.originOffset, "this.originOffset", 216, 7992, 8020);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3716.methodEnd();
        }
    }

    public Vector2D toSubSpace(final Vector<Euclidean3D> point) {
        MethodContext _bcornu_methode_context3717 = new MethodContext(Vector2D.class, 226, 8033, 8483);
        try {
            CallChecker.varInit(this, "this", 226, 8033, 8483);
            CallChecker.varInit(point, "point", 226, 8033, 8483);
            CallChecker.varInit(this.w, "w", 226, 8033, 8483);
            CallChecker.varInit(this.v, "v", 226, 8033, 8483);
            CallChecker.varInit(this.u, "u", 226, 8033, 8483);
            CallChecker.varInit(this.origin, "origin", 226, 8033, 8483);
            CallChecker.varInit(this.originOffset, "originOffset", 226, 8033, 8483);
            if (CallChecker.beforeDeref(point, Vector.class, 227, 8436, 8440)) {
                if (CallChecker.beforeDeref(point, Vector.class, 227, 8457, 8461)) {
                    return new Vector2D(CallChecker.isCalled(point, Vector.class, 227, 8436, 8440).dotProduct(u), CallChecker.isCalled(point, Vector.class, 227, 8457, 8461).dotProduct(v));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3717.methodEnd();
        }
    }

    public Vector3D toSpace(final Vector<Euclidean2D> point) {
        MethodContext _bcornu_methode_context3718 = new MethodContext(Vector3D.class, 236, 8490, 8982);
        try {
            CallChecker.varInit(this, "this", 236, 8490, 8982);
            CallChecker.varInit(point, "point", 236, 8490, 8982);
            CallChecker.varInit(this.w, "w", 236, 8490, 8982);
            CallChecker.varInit(this.v, "v", 236, 8490, 8982);
            CallChecker.varInit(this.u, "u", 236, 8490, 8982);
            CallChecker.varInit(this.origin, "origin", 236, 8490, 8982);
            CallChecker.varInit(this.originOffset, "originOffset", 236, 8490, 8982);
            final Vector2D p2D = CallChecker.varInit(((Vector2D) (point)), "p2D", 237, 8862, 8899);
            if (CallChecker.beforeDeref(p2D, Vector2D.class, 238, 8929, 8931)) {
                if (CallChecker.beforeDeref(p2D, Vector2D.class, 238, 8944, 8946)) {
                    return new Vector3D(CallChecker.isCalled(p2D, Vector2D.class, 238, 8929, 8931).getX(), u, CallChecker.isCalled(p2D, Vector2D.class, 238, 8944, 8946).getY(), v, (-(originOffset)), w);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3718.methodEnd();
        }
    }

    public Vector3D getPointAt(final Vector2D inPlane, final double offset) {
        MethodContext _bcornu_methode_context3719 = new MethodContext(Vector3D.class, 248, 8989, 9449);
        try {
            CallChecker.varInit(this, "this", 248, 8989, 9449);
            CallChecker.varInit(offset, "offset", 248, 8989, 9449);
            CallChecker.varInit(inPlane, "inPlane", 248, 8989, 9449);
            CallChecker.varInit(this.w, "w", 248, 8989, 9449);
            CallChecker.varInit(this.v, "v", 248, 8989, 9449);
            CallChecker.varInit(this.u, "u", 248, 8989, 9449);
            CallChecker.varInit(this.origin, "origin", 248, 8989, 9449);
            CallChecker.varInit(this.originOffset, "originOffset", 248, 8989, 9449);
            if (CallChecker.beforeDeref(inPlane, Vector2D.class, 249, 9380, 9386)) {
                if (CallChecker.beforeDeref(inPlane, Vector2D.class, 249, 9399, 9405)) {
                    return new Vector3D(CallChecker.isCalled(inPlane, Vector2D.class, 249, 9380, 9386).getX(), u, CallChecker.isCalled(inPlane, Vector2D.class, 249, 9399, 9405).getY(), v, (offset - (originOffset)), w);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3719.methodEnd();
        }
    }

    public boolean isSimilarTo(final Plane plane) {
        MethodContext _bcornu_methode_context3720 = new MethodContext(boolean.class, 259, 9456, 10117);
        try {
            CallChecker.varInit(this, "this", 259, 9456, 10117);
            CallChecker.varInit(plane, "plane", 259, 9456, 10117);
            CallChecker.varInit(this.w, "w", 259, 9456, 10117);
            CallChecker.varInit(this.v, "v", 259, 9456, 10117);
            CallChecker.varInit(this.u, "u", 259, 9456, 10117);
            CallChecker.varInit(this.origin, "origin", 259, 9456, 10117);
            CallChecker.varInit(this.originOffset, "originOffset", 259, 9456, 10117);
            final double angle = CallChecker.varInit(((double) (Vector3D.angle(this.w, CallChecker.isCalled(plane, Plane.class, 260, 9887, 9891).w))), "angle", 260, 9848, 9895);
            return ((angle < 1.0E-10) && ((FastMath.abs(((originOffset) - (CallChecker.isCalled(plane, Plane.class, 261, 9963, 9967).originOffset)))) < 1.0E-10)) || ((angle > ((FastMath.PI) - 1.0E-10)) && ((FastMath.abs(((originOffset) + (CallChecker.isCalled(plane, Plane.class, 262, 10080, 10084).originOffset)))) < 1.0E-10));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3720.methodEnd();
        }
    }

    public Plane rotate(final Vector3D center, final Rotation rotation) {
        MethodContext _bcornu_methode_context3721 = new MethodContext(Plane.class, 271, 10124, 10797);
        try {
            CallChecker.varInit(this, "this", 271, 10124, 10797);
            CallChecker.varInit(rotation, "rotation", 271, 10124, 10797);
            CallChecker.varInit(center, "center", 271, 10124, 10797);
            CallChecker.varInit(this.w, "w", 271, 10124, 10797);
            CallChecker.varInit(this.v, "v", 271, 10124, 10797);
            CallChecker.varInit(this.u, "u", 271, 10124, 10797);
            CallChecker.varInit(this.origin, "origin", 271, 10124, 10797);
            CallChecker.varInit(this.originOffset, "originOffset", 271, 10124, 10797);
            origin = CallChecker.beforeCalled(origin, Vector3D.class, 273, 10473, 10478);
            final Vector3D delta = CallChecker.varInit(CallChecker.isCalled(origin, Vector3D.class, 273, 10473, 10478).subtract(center), "delta", 273, 10450, 10496);
            final Plane plane = CallChecker.varInit(new Plane(CallChecker.isCalled(center, Vector3D.class, 274, 10536, 10541).add(CallChecker.isCalled(rotation, Rotation.class, 274, 10547, 10554).applyTo(delta)), CallChecker.isCalled(rotation, Rotation.class, 275, 10611, 10618).applyTo(w)), "plane", 274, 10506, 10631);
            if (CallChecker.beforeDeref(plane, Plane.class, 278, 10699, 10703)) {
                if (CallChecker.beforeDeref(rotation, Rotation.class, 278, 10709, 10716)) {
                    CallChecker.isCalled(plane, Plane.class, 278, 10699, 10703).u = CallChecker.isCalled(rotation, Rotation.class, 278, 10709, 10716).applyTo(u);
                    CallChecker.varAssign(CallChecker.isCalled(plane, Plane.class, 278, 10699, 10703).u, "CallChecker.isCalled(plane, Plane.class, 278, 10699, 10703).u", 278, 10699, 10728);
                }
            }
            if (CallChecker.beforeDeref(plane, Plane.class, 279, 10738, 10742)) {
                if (CallChecker.beforeDeref(rotation, Rotation.class, 279, 10748, 10755)) {
                    CallChecker.isCalled(plane, Plane.class, 279, 10738, 10742).v = CallChecker.isCalled(rotation, Rotation.class, 279, 10748, 10755).applyTo(v);
                    CallChecker.varAssign(CallChecker.isCalled(plane, Plane.class, 279, 10738, 10742).v, "CallChecker.isCalled(plane, Plane.class, 279, 10738, 10742).v", 279, 10738, 10767);
                }
            }
            return plane;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Plane) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3721.methodEnd();
        }
    }

    public Plane translate(final Vector3D translation) {
        MethodContext _bcornu_methode_context3722 = new MethodContext(Plane.class, 290, 10804, 11259);
        try {
            CallChecker.varInit(this, "this", 290, 10804, 11259);
            CallChecker.varInit(translation, "translation", 290, 10804, 11259);
            CallChecker.varInit(this.w, "w", 290, 10804, 11259);
            CallChecker.varInit(this.v, "v", 290, 10804, 11259);
            CallChecker.varInit(this.u, "u", 290, 10804, 11259);
            CallChecker.varInit(this.origin, "origin", 290, 10804, 11259);
            CallChecker.varInit(this.originOffset, "originOffset", 290, 10804, 11259);
            origin = CallChecker.beforeCalled(origin, Vector3D.class, 292, 11102, 11107);
            final Plane plane = CallChecker.varInit(new Plane(CallChecker.isCalled(origin, Vector3D.class, 292, 11102, 11107).add(translation), w), "plane", 292, 11072, 11129);
            if (CallChecker.beforeDeref(plane, Plane.class, 295, 11197, 11201)) {
                CallChecker.isCalled(plane, Plane.class, 295, 11197, 11201).u = u;
                CallChecker.varAssign(CallChecker.isCalled(plane, Plane.class, 295, 11197, 11201).u, "CallChecker.isCalled(plane, Plane.class, 295, 11197, 11201).u", 295, 11197, 11208);
            }
            if (CallChecker.beforeDeref(plane, Plane.class, 296, 11218, 11222)) {
                CallChecker.isCalled(plane, Plane.class, 296, 11218, 11222).v = v;
                CallChecker.varAssign(CallChecker.isCalled(plane, Plane.class, 296, 11218, 11222).v, "CallChecker.isCalled(plane, Plane.class, 296, 11218, 11222).v", 296, 11218, 11229);
            }
            return plane;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Plane) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3722.methodEnd();
        }
    }

    public Vector3D intersection(final Line line) {
        MethodContext _bcornu_methode_context3723 = new MethodContext(Vector3D.class, 307, 11266, 11949);
        try {
            CallChecker.varInit(this, "this", 307, 11266, 11949);
            CallChecker.varInit(line, "line", 307, 11266, 11949);
            CallChecker.varInit(this.w, "w", 307, 11266, 11949);
            CallChecker.varInit(this.v, "v", 307, 11266, 11949);
            CallChecker.varInit(this.u, "u", 307, 11266, 11949);
            CallChecker.varInit(this.origin, "origin", 307, 11266, 11949);
            CallChecker.varInit(this.originOffset, "originOffset", 307, 11266, 11949);
            final Vector3D direction = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 308, 11595, 11598).getDirection(), "direction", 308, 11568, 11614);
            w = CallChecker.beforeCalled(w, Vector3D.class, 309, 11651, 11651);
            final double dot = CallChecker.varInit(((double) (CallChecker.isCalled(this.w, Vector3D.class, 309, 11651, 11651).dotProduct(direction))), "dot", 309, 11624, 11674);
            if ((FastMath.abs(dot)) < 1.0E-10) {
                return null;
            }
            final Vector3D point = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 313, 11785, 11788).toSpace(Vector1D.ZERO), "point", 313, 11762, 11812);
            w = CallChecker.beforeCalled(w, Vector3D.class, 314, 11862, 11862);
            final double k = CallChecker.varInit(((double) ((-((this.originOffset) + (CallChecker.isCalled(this.w, Vector3D.class, 314, 11862, 11862).dotProduct(point)))) / dot)), "k", 314, 11822, 11888);
            return new Vector3D(1.0, point, k, direction);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3723.methodEnd();
        }
    }

    public Line intersection(final Plane other) {
        MethodContext _bcornu_methode_context3724 = new MethodContext(Line.class, 323, 11956, 12516);
        try {
            CallChecker.varInit(this, "this", 323, 11956, 12516);
            CallChecker.varInit(other, "other", 323, 11956, 12516);
            CallChecker.varInit(this.w, "w", 323, 11956, 12516);
            CallChecker.varInit(this.v, "v", 323, 11956, 12516);
            CallChecker.varInit(this.u, "u", 323, 11956, 12516);
            CallChecker.varInit(this.origin, "origin", 323, 11956, 12516);
            CallChecker.varInit(this.originOffset, "originOffset", 323, 11956, 12516);
            final Vector3D direction = CallChecker.varInit(Vector3D.crossProduct(w, CallChecker.isCalled(other, Plane.class, 324, 12288, 12292).w), "direction", 324, 12236, 12296);
            if (CallChecker.beforeDeref(direction, Vector3D.class, 325, 12310, 12318)) {
                if ((CallChecker.isCalled(direction, Vector3D.class, 325, 12310, 12318).getNorm()) < 1.0E-10) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            final Vector3D point = CallChecker.varInit(Plane.intersection(this, other, new Plane(direction)), "point", 328, 12386, 12456);
            if (CallChecker.beforeDeref(point, Vector3D.class, 329, 12489, 12493)) {
                return new Line(point, CallChecker.isCalled(point, Vector3D.class, 329, 12489, 12493).add(direction));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3724.methodEnd();
        }
    }

    public static Vector3D intersection(final Plane plane1, final Plane plane2, final Plane plane3) {
        MethodContext _bcornu_methode_context3725 = new MethodContext(Vector3D.class, 338, 12523, 14263);
        try {
            CallChecker.varInit(plane3, "plane3", 338, 12523, 14263);
            CallChecker.varInit(plane2, "plane2", 338, 12523, 14263);
            CallChecker.varInit(plane1, "plane1", 338, 12523, 14263);
            CallChecker.isCalled(plane1, Plane.class, 341, 12956, 12961).w = CallChecker.beforeCalled(CallChecker.isCalled(plane1, Plane.class, 341, 12956, 12961).w, Vector3D.class, 341, 12956, 12963);
            final double a1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane1, Plane.class, 341, 12956, 12961).w, Vector3D.class, 341, 12956, 12963).getX())), "a1", 341, 12877, 12971);
            CallChecker.isCalled(plane1, Plane.class, 342, 12999, 13004).w = CallChecker.beforeCalled(CallChecker.isCalled(plane1, Plane.class, 342, 12999, 13004).w, Vector3D.class, 342, 12999, 13006);
            final double b1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane1, Plane.class, 342, 12999, 13004).w, Vector3D.class, 342, 12999, 13006).getY())), "b1", 342, 12981, 13014);
            CallChecker.isCalled(plane1, Plane.class, 343, 13042, 13047).w = CallChecker.beforeCalled(CallChecker.isCalled(plane1, Plane.class, 343, 13042, 13047).w, Vector3D.class, 343, 13042, 13049);
            final double c1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane1, Plane.class, 343, 13042, 13047).w, Vector3D.class, 343, 13042, 13049).getZ())), "c1", 343, 13024, 13057);
            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(plane1, Plane.class, 344, 13085, 13090).originOffset)), "d1", 344, 13067, 13104);
            CallChecker.isCalled(plane2, Plane.class, 346, 13133, 13138).w = CallChecker.beforeCalled(CallChecker.isCalled(plane2, Plane.class, 346, 13133, 13138).w, Vector3D.class, 346, 13133, 13140);
            final double a2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane2, Plane.class, 346, 13133, 13138).w, Vector3D.class, 346, 13133, 13140).getX())), "a2", 346, 13115, 13148);
            CallChecker.isCalled(plane2, Plane.class, 347, 13176, 13181).w = CallChecker.beforeCalled(CallChecker.isCalled(plane2, Plane.class, 347, 13176, 13181).w, Vector3D.class, 347, 13176, 13183);
            final double b2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane2, Plane.class, 347, 13176, 13181).w, Vector3D.class, 347, 13176, 13183).getY())), "b2", 347, 13158, 13191);
            CallChecker.isCalled(plane2, Plane.class, 348, 13219, 13224).w = CallChecker.beforeCalled(CallChecker.isCalled(plane2, Plane.class, 348, 13219, 13224).w, Vector3D.class, 348, 13219, 13226);
            final double c2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane2, Plane.class, 348, 13219, 13224).w, Vector3D.class, 348, 13219, 13226).getZ())), "c2", 348, 13201, 13234);
            final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(plane2, Plane.class, 349, 13262, 13267).originOffset)), "d2", 349, 13244, 13281);
            CallChecker.isCalled(plane3, Plane.class, 351, 13310, 13315).w = CallChecker.beforeCalled(CallChecker.isCalled(plane3, Plane.class, 351, 13310, 13315).w, Vector3D.class, 351, 13310, 13317);
            final double a3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane3, Plane.class, 351, 13310, 13315).w, Vector3D.class, 351, 13310, 13317).getX())), "a3", 351, 13292, 13325);
            CallChecker.isCalled(plane3, Plane.class, 352, 13353, 13358).w = CallChecker.beforeCalled(CallChecker.isCalled(plane3, Plane.class, 352, 13353, 13358).w, Vector3D.class, 352, 13353, 13360);
            final double b3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane3, Plane.class, 352, 13353, 13358).w, Vector3D.class, 352, 13353, 13360).getY())), "b3", 352, 13335, 13368);
            CallChecker.isCalled(plane3, Plane.class, 353, 13396, 13401).w = CallChecker.beforeCalled(CallChecker.isCalled(plane3, Plane.class, 353, 13396, 13401).w, Vector3D.class, 353, 13396, 13403);
            final double c3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane3, Plane.class, 353, 13396, 13401).w, Vector3D.class, 353, 13396, 13403).getZ())), "c3", 353, 13378, 13411);
            final double d3 = CallChecker.varInit(((double) (CallChecker.isCalled(plane3, Plane.class, 354, 13439, 13444).originOffset)), "d3", 354, 13421, 13458);
            final double a23 = CallChecker.varInit(((double) ((b2 * c3) - (b3 * c2))), "a23", 358, 13469, 13623);
            final double b23 = CallChecker.varInit(((double) ((c2 * a3) - (c3 * a2))), "b23", 359, 13633, 13677);
            final double c23 = CallChecker.varInit(((double) ((a2 * b3) - (a3 * b2))), "c23", 360, 13687, 13731);
            final double determinant = CallChecker.varInit(((double) (((a1 * a23) + (b1 * b23)) + (c1 * c23))), "determinant", 361, 13741, 13798);
            if ((FastMath.abs(determinant)) < 1.0E-10) {
                return null;
            }
            final double r = CallChecker.varInit(((double) (1.0 / determinant)), "r", 366, 13895, 13929);
            return new Vector3D((((((-a23) * d1) - (((c1 * b3) - (c3 * b1)) * d2)) - (((c2 * b1) - (c1 * b2)) * d3)) * r), (((((-b23) * d1) - (((c3 * a1) - (c1 * a3)) * d2)) - (((c1 * a2) - (c2 * a1)) * d3)) * r), (((((-c23) * d1) - (((b1 * a3) - (b3 * a1)) * d2)) - (((b2 * a1) - (b1 * a2)) * d3)) * r));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3725.methodEnd();
        }
    }

    public SubPlane wholeHyperplane() {
        MethodContext _bcornu_methode_context3726 = new MethodContext(SubPlane.class, 377, 14270, 14480);
        try {
            CallChecker.varInit(this, "this", 377, 14270, 14480);
            CallChecker.varInit(this.w, "w", 377, 14270, 14480);
            CallChecker.varInit(this.v, "v", 377, 14270, 14480);
            CallChecker.varInit(this.u, "u", 377, 14270, 14480);
            CallChecker.varInit(this.origin, "origin", 377, 14270, 14480);
            CallChecker.varInit(this.originOffset, "originOffset", 377, 14270, 14480);
            return new SubPlane(this, new PolygonsSet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubPlane) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3726.methodEnd();
        }
    }

    public PolyhedronsSet wholeSpace() {
        MethodContext _bcornu_methode_context3727 = new MethodContext(PolyhedronsSet.class, 385, 14487, 14735);
        try {
            CallChecker.varInit(this, "this", 385, 14487, 14735);
            CallChecker.varInit(this.w, "w", 385, 14487, 14735);
            CallChecker.varInit(this.v, "v", 385, 14487, 14735);
            CallChecker.varInit(this.u, "u", 385, 14487, 14735);
            CallChecker.varInit(this.origin, "origin", 385, 14487, 14735);
            CallChecker.varInit(this.originOffset, "originOffset", 385, 14487, 14735);
            return new PolyhedronsSet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolyhedronsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3727.methodEnd();
        }
    }

    public boolean contains(final Vector3D p) {
        MethodContext _bcornu_methode_context3728 = new MethodContext(boolean.class, 393, 14742, 14976);
        try {
            CallChecker.varInit(this, "this", 393, 14742, 14976);
            CallChecker.varInit(p, "p", 393, 14742, 14976);
            CallChecker.varInit(this.w, "w", 393, 14742, 14976);
            CallChecker.varInit(this.v, "v", 393, 14742, 14976);
            CallChecker.varInit(this.u, "u", 393, 14742, 14976);
            CallChecker.varInit(this.origin, "origin", 393, 14742, 14976);
            CallChecker.varInit(this.originOffset, "originOffset", 393, 14742, 14976);
            return (FastMath.abs(getOffset(p))) < 1.0E-10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3728.methodEnd();
        }
    }

    public double getOffset(final Plane plane) {
        MethodContext _bcornu_methode_context3729 = new MethodContext(double.class, 407, 14983, 15613);
        try {
            CallChecker.varInit(this, "this", 407, 14983, 15613);
            CallChecker.varInit(plane, "plane", 407, 14983, 15613);
            CallChecker.varInit(this.w, "w", 407, 14983, 15613);
            CallChecker.varInit(this.v, "v", 407, 14983, 15613);
            CallChecker.varInit(this.u, "u", 407, 14983, 15613);
            CallChecker.varInit(this.origin, "origin", 407, 14983, 15613);
            CallChecker.varInit(this.originOffset, "originOffset", 407, 14983, 15613);
            if (CallChecker.beforeDeref(plane, Plane.class, 408, 15567, 15571)) {
                if ((sameOrientationAs(plane)) || (CallChecker.beforeDeref(plane, Plane.class, 408, 15588, 15592))) {
                    return (originOffset) + ((sameOrientationAs(plane)) ? -(CallChecker.isCalled(plane, Plane.class, 408, 15567, 15571).originOffset) : CallChecker.isCalled(plane, Plane.class, 408, 15588, 15592).originOffset);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3729.methodEnd();
        }
    }

    public double getOffset(final Vector<Euclidean3D> point) {
        MethodContext _bcornu_methode_context3730 = new MethodContext(double.class, 419, 15620, 16140);
        try {
            CallChecker.varInit(this, "this", 419, 15620, 16140);
            CallChecker.varInit(point, "point", 419, 15620, 16140);
            CallChecker.varInit(this.w, "w", 419, 15620, 16140);
            CallChecker.varInit(this.v, "v", 419, 15620, 16140);
            CallChecker.varInit(this.u, "u", 419, 15620, 16140);
            CallChecker.varInit(this.origin, "origin", 419, 15620, 16140);
            CallChecker.varInit(this.originOffset, "originOffset", 419, 15620, 16140);
            return (CallChecker.isCalled(point, Vector.class, 420, 16100, 16104).dotProduct(w)) + (originOffset);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3730.methodEnd();
        }
    }

    public boolean sameOrientationAs(final Hyperplane<Euclidean3D> other) {
        MethodContext _bcornu_methode_context3731 = new MethodContext(boolean.class, 428, 16147, 16526);
        try {
            CallChecker.varInit(this, "this", 428, 16147, 16526);
            CallChecker.varInit(other, "other", 428, 16147, 16526);
            CallChecker.varInit(this.w, "w", 428, 16147, 16526);
            CallChecker.varInit(this.v, "v", 428, 16147, 16526);
            CallChecker.varInit(this.u, "u", 428, 16147, 16526);
            CallChecker.varInit(this.origin, "origin", 428, 16147, 16526);
            CallChecker.varInit(this.originOffset, "originOffset", 428, 16147, 16526);
            if (CallChecker.beforeDeref(other, Hyperplane.class, 429, 16491, 16495)) {
                CallChecker.isCalled(((Plane) (other)), Plane.class, 429, 16491, 16495).w = CallChecker.beforeCalled(CallChecker.isCalled(((Plane) (other)), Plane.class, 429, 16491, 16495).w, Vector3D.class, 429, 16481, 16499);
                return (CallChecker.isCalled(CallChecker.isCalled(((Plane) (other)), Plane.class, 429, 16491, 16495).w, Vector3D.class, 429, 16481, 16499).dotProduct(w)) > 0.0;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3731.methodEnd();
        }
    }
}

