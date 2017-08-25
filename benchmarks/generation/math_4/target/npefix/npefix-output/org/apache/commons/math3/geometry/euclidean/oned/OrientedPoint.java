package org.apache.commons.math3.geometry.euclidean.oned;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;

public class OrientedPoint implements Hyperplane<Euclidean1D> {
    private Vector1D location;

    private boolean direct;

    public OrientedPoint(final Vector1D location, final boolean direct) {
        ConstructorContext _bcornu_methode_context314 = new ConstructorContext(OrientedPoint.class, 42, 1398, 1744);
        try {
            this.location = location;
            CallChecker.varAssign(this.location, "this.location", 43, 1682, 1706);
            this.direct = direct;
            CallChecker.varAssign(this.direct, "this.direct", 44, 1716, 1738);
        } finally {
            _bcornu_methode_context314.methodEnd();
        }
    }

    public OrientedPoint copySelf() {
        MethodContext _bcornu_methode_context1456 = new MethodContext(OrientedPoint.class, 52, 1751, 1975);
        try {
            CallChecker.varInit(this, "this", 52, 1751, 1975);
            CallChecker.varInit(this.direct, "direct", 52, 1751, 1975);
            CallChecker.varInit(this.location, "location", 52, 1751, 1975);
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrientedPoint) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1456.methodEnd();
        }
    }

    public double getOffset(final Vector<Euclidean1D> point) {
        MethodContext _bcornu_methode_context1457 = new MethodContext(double.class, 57, 1982, 2184);
        try {
            CallChecker.varInit(this, "this", 57, 1982, 2184);
            CallChecker.varInit(point, "point", 57, 1982, 2184);
            CallChecker.varInit(this.direct, "direct", 57, 1982, 2184);
            CallChecker.varInit(this.location, "location", 57, 1982, 2184);
            location = CallChecker.beforeCalled(location, Vector1D.class, 58, 2123, 2130);
            final double delta = CallChecker.varInit(((double) ((CallChecker.isCalled(((Vector1D) (point)), Vector1D.class, 58, 2107, 2111).getX()) - (CallChecker.isCalled(this.location, Vector1D.class, 58, 2123, 2130).getX()))), "delta", 58, 2074, 2138);
            if (direct) {
                return delta;
            }else {
                return -delta;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1457.methodEnd();
        }
    }

    public SubOrientedPoint wholeHyperplane() {
        MethodContext _bcornu_methode_context1458 = new MethodContext(SubOrientedPoint.class, 73, 2191, 2890);
        try {
            CallChecker.varInit(this, "this", 73, 2191, 2890);
            CallChecker.varInit(this.direct, "direct", 73, 2191, 2890);
            CallChecker.varInit(this.location, "location", 73, 2191, 2890);
            return new SubOrientedPoint(this, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubOrientedPoint) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1458.methodEnd();
        }
    }

    public IntervalsSet wholeSpace() {
        MethodContext _bcornu_methode_context1459 = new MethodContext(IntervalsSet.class, 81, 2897, 3138);
        try {
            CallChecker.varInit(this, "this", 81, 2897, 3138);
            CallChecker.varInit(this.direct, "direct", 81, 2897, 3138);
            CallChecker.varInit(this.location, "location", 81, 2897, 3138);
            return new IntervalsSet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((IntervalsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1459.methodEnd();
        }
    }

    public boolean sameOrientationAs(final Hyperplane<Euclidean1D> other) {
        MethodContext _bcornu_methode_context1460 = new MethodContext(boolean.class, 86, 3145, 3305);
        try {
            CallChecker.varInit(this, "this", 86, 3145, 3305);
            CallChecker.varInit(other, "other", 86, 3145, 3305);
            CallChecker.varInit(this.direct, "direct", 86, 3145, 3305);
            CallChecker.varInit(this.location, "location", 86, 3145, 3305);
            return !((direct) ^ (CallChecker.isCalled(((OrientedPoint) (other)), OrientedPoint.class, 87, 3285, 3289).direct));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1460.methodEnd();
        }
    }

    public Vector1D getLocation() {
        MethodContext _bcornu_methode_context1461 = new MethodContext(Vector1D.class, 93, 3312, 3474);
        try {
            CallChecker.varInit(this, "this", 93, 3312, 3474);
            CallChecker.varInit(this.direct, "direct", 93, 3312, 3474);
            CallChecker.varInit(this.location, "location", 93, 3312, 3474);
            return location;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1461.methodEnd();
        }
    }

    public boolean isDirect() {
        MethodContext _bcornu_methode_context1462 = new MethodContext(boolean.class, 101, 3481, 3715);
        try {
            CallChecker.varInit(this, "this", 101, 3481, 3715);
            CallChecker.varInit(this.direct, "direct", 101, 3481, 3715);
            CallChecker.varInit(this.location, "location", 101, 3481, 3715);
            return direct;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1462.methodEnd();
        }
    }

    public void revertSelf() {
        MethodContext _bcornu_methode_context1463 = new MethodContext(void.class, 107, 3722, 3816);
        try {
            CallChecker.varInit(this, "this", 107, 3722, 3816);
            CallChecker.varInit(this.direct, "direct", 107, 3722, 3816);
            CallChecker.varInit(this.location, "location", 107, 3722, 3816);
            direct = !(direct);
            CallChecker.varAssign(this.direct, "this.direct", 108, 3794, 3810);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1463.methodEnd();
        }
    }
}

