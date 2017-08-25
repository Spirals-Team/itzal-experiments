package org.apache.commons.math3.stat.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.math3.util.MathArrays;

@Deprecated
public class EuclideanDoublePoint implements Serializable , Clusterable<EuclideanDoublePoint> {
    private static final long serialVersionUID = 8026472786091227632L;

    private final double[] point;

    public EuclideanDoublePoint(final double[] point) {
        ConstructorContext _bcornu_methode_context1244 = new ConstructorContext(EuclideanDoublePoint.class, 48, 1529, 1827);
        try {
            this.point = point;
            CallChecker.varAssign(this.point, "this.point", 49, 1803, 1821);
        } finally {
            _bcornu_methode_context1244.methodEnd();
        }
    }

    public EuclideanDoublePoint centroidOf(final Collection<EuclideanDoublePoint> points) {
        MethodContext _bcornu_methode_context5588 = new MethodContext(EuclideanDoublePoint.class, 53, 1834, 2353);
        try {
            CallChecker.varInit(this, "this", 53, 1834, 2353);
            CallChecker.varInit(points, "points", 53, 1834, 2353);
            CallChecker.varInit(this.point, "point", 53, 1834, 2353);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanDoublePoint.serialVersionUID", 53, 1834, 2353);
            final double[] centroid = CallChecker.varInit(new double[CallChecker.isCalled(getPoint(), double[].class, 54, 1992, 2001).length], "centroid", 54, 1955, 2010);
            if (CallChecker.beforeDeref(points, EuclideanDoublePoint.class, 55, 2056, 2061)) {
                for (final EuclideanDoublePoint p : points) {
                    for (int i = 0; i < (CallChecker.isCalled(centroid, double[].class, 56, 2098, 2105).length); i++) {
                        if (CallChecker.beforeDeref(centroid, double[].class, 57, 2138, 2145)) {
                            if (CallChecker.beforeDeref(p, EuclideanDoublePoint.class, 57, 2153, 2153)) {
                                final double[] npe_invocation_var1016 = CallChecker.isCalled(p, EuclideanDoublePoint.class, 57, 2153, 2153).getPoint();
                                if (CallChecker.beforeDeref(npe_invocation_var1016, double[].class, 57, 2153, 2164)) {
                                    CallChecker.isCalled(centroid, double[].class, 57, 2138, 2145)[i] += CallChecker.isCalled(npe_invocation_var1016, double[].class, 57, 2153, 2164)[i];
                                    CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 57, 2138, 2145)[i], "CallChecker.isCalled(centroid, double[].class, 57, 2138, 2145)[i]", 57, 2138, 2168);
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(centroid, double[].class, 60, 2222, 2229).length); i++) {
                if (CallChecker.beforeDeref(centroid, double[].class, 61, 2258, 2265)) {
                    if (CallChecker.beforeDeref(points, Collection.class, 61, 2273, 2278)) {
                        CallChecker.isCalled(centroid, double[].class, 61, 2258, 2265)[i] /= CallChecker.isCalled(points, Collection.class, 61, 2273, 2278).size();
                        CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 61, 2258, 2265)[i], "CallChecker.isCalled(centroid, double[].class, 61, 2258, 2265)[i]", 61, 2258, 2286);
                    }
                }
            }
            return new EuclideanDoublePoint(centroid);
        } catch (ForceReturn _bcornu_return_t) {
            return ((EuclideanDoublePoint) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5588.methodEnd();
        }
    }

    public double distanceFrom(final EuclideanDoublePoint p) {
        MethodContext _bcornu_methode_context5589 = new MethodContext(double.class, 67, 2360, 2505);
        try {
            CallChecker.varInit(this, "this", 67, 2360, 2505);
            CallChecker.varInit(p, "p", 67, 2360, 2505);
            CallChecker.varInit(this.point, "point", 67, 2360, 2505);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanDoublePoint.serialVersionUID", 67, 2360, 2505);
            if (CallChecker.beforeDeref(p, EuclideanDoublePoint.class, 68, 2486, 2486)) {
                return MathArrays.distance(point, CallChecker.isCalled(p, EuclideanDoublePoint.class, 68, 2486, 2486).getPoint());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5589.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object other) {
        MethodContext _bcornu_methode_context5590 = new MethodContext(boolean.class, 73, 2512, 2766);
        try {
            CallChecker.varInit(this, "this", 73, 2512, 2766);
            CallChecker.varInit(other, "other", 73, 2512, 2766);
            CallChecker.varInit(this.point, "point", 73, 2512, 2766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanDoublePoint.serialVersionUID", 73, 2512, 2766);
            if (!(other instanceof EuclideanDoublePoint)) {
                return false;
            }
            if (CallChecker.beforeDeref(other, Object.class, 77, 2747, 2751)) {
                return Arrays.equals(point, CallChecker.isCalled(((EuclideanDoublePoint) (other)), EuclideanDoublePoint.class, 77, 2747, 2751).point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5590.methodEnd();
        }
    }

    public double[] getPoint() {
        MethodContext _bcornu_methode_context5591 = new MethodContext(double[].class, 85, 2773, 2966);
        try {
            CallChecker.varInit(this, "this", 85, 2773, 2966);
            CallChecker.varInit(this.point, "point", 85, 2773, 2966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanDoublePoint.serialVersionUID", 85, 2773, 2966);
            return point;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5591.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5592 = new MethodContext(int.class, 91, 2973, 3079);
        try {
            CallChecker.varInit(this, "this", 91, 2973, 3079);
            CallChecker.varInit(this.point, "point", 91, 2973, 3079);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanDoublePoint.serialVersionUID", 91, 2973, 3079);
            return Arrays.hashCode(point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5592.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context5593 = new MethodContext(String.class, 97, 3086, 3195);
        try {
            CallChecker.varInit(this, "this", 97, 3086, 3195);
            CallChecker.varInit(this.point, "point", 97, 3086, 3195);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanDoublePoint.serialVersionUID", 97, 3086, 3195);
            return Arrays.toString(point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5593.methodEnd();
        }
    }
}

