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
public class EuclideanIntegerPoint implements Serializable , Clusterable<EuclideanIntegerPoint> {
    private static final long serialVersionUID = 3946024775784901369L;

    private final int[] point;

    public EuclideanIntegerPoint(final int[] point) {
        ConstructorContext _bcornu_methode_context306 = new ConstructorContext(EuclideanIntegerPoint.class, 47, 1530, 1815);
        try {
            this.point = point;
            CallChecker.varAssign(this.point, "this.point", 48, 1791, 1809);
        } finally {
            _bcornu_methode_context306.methodEnd();
        }
    }

    public int[] getPoint() {
        MethodContext _bcornu_methode_context1372 = new MethodContext(int[].class, 55, 1822, 2005);
        try {
            CallChecker.varInit(this, "this", 55, 1822, 2005);
            CallChecker.varInit(this.point, "point", 55, 1822, 2005);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanIntegerPoint.serialVersionUID", 55, 1822, 2005);
            return point;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1372.methodEnd();
        }
    }

    public double distanceFrom(final EuclideanIntegerPoint p) {
        MethodContext _bcornu_methode_context1373 = new MethodContext(double.class, 60, 2012, 2158);
        try {
            CallChecker.varInit(this, "this", 60, 2012, 2158);
            CallChecker.varInit(p, "p", 60, 2012, 2158);
            CallChecker.varInit(this.point, "point", 60, 2012, 2158);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanIntegerPoint.serialVersionUID", 60, 2012, 2158);
            if (CallChecker.beforeDeref(p, EuclideanIntegerPoint.class, 61, 2139, 2139)) {
                return MathArrays.distance(point, CallChecker.isCalled(p, EuclideanIntegerPoint.class, 61, 2139, 2139).getPoint());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1373.methodEnd();
        }
    }

    public EuclideanIntegerPoint centroidOf(final Collection<EuclideanIntegerPoint> points) {
        MethodContext _bcornu_methode_context1374 = new MethodContext(EuclideanIntegerPoint.class, 65, 2165, 2670);
        try {
            CallChecker.varInit(this, "this", 65, 2165, 2670);
            CallChecker.varInit(points, "points", 65, 2165, 2670);
            CallChecker.varInit(this.point, "point", 65, 2165, 2670);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanIntegerPoint.serialVersionUID", 65, 2165, 2670);
            final int[] npe_invocation_var132 = getPoint();
            int[] centroid = CallChecker.init(int[].class);
            if (CallChecker.beforeDeref(npe_invocation_var132, int[].class, 66, 2313, 2322)) {
                centroid = new int[CallChecker.isCalled(npe_invocation_var132, int[].class, 66, 2313, 2322).length];
                CallChecker.varAssign(centroid, "centroid", 66, 2313, 2322);
            }
            if (CallChecker.beforeDeref(points, EuclideanIntegerPoint.class, 67, 2372, 2377)) {
                for (EuclideanIntegerPoint p : points) {
                    centroid = CallChecker.beforeCalled(centroid, int[].class, 68, 2414, 2421);
                    for (int i = 0; i < (CallChecker.isCalled(centroid, int[].class, 68, 2414, 2421).length); i++) {
                        if (CallChecker.beforeDeref(centroid, int[].class, 69, 2454, 2461)) {
                            if (CallChecker.beforeDeref(p, EuclideanIntegerPoint.class, 69, 2469, 2469)) {
                                final int[] npe_invocation_var133 = CallChecker.isCalled(p, EuclideanIntegerPoint.class, 69, 2469, 2469).getPoint();
                                if (CallChecker.beforeDeref(npe_invocation_var133, int[].class, 69, 2469, 2480)) {
                                    centroid = CallChecker.beforeCalled(centroid, int[].class, 69, 2454, 2461);
                                    CallChecker.isCalled(centroid, int[].class, 69, 2454, 2461)[i] += CallChecker.isCalled(npe_invocation_var133, int[].class, 69, 2469, 2480)[i];
                                    CallChecker.varAssign(CallChecker.isCalled(centroid, int[].class, 69, 2454, 2461)[i], "CallChecker.isCalled(centroid, int[].class, 69, 2454, 2461)[i]", 69, 2454, 2484);
                                }
                            }
                        }
                    }
                }
            }
            centroid = CallChecker.beforeCalled(centroid, int[].class, 72, 2538, 2545);
            for (int i = 0; i < (CallChecker.isCalled(centroid, int[].class, 72, 2538, 2545).length); i++) {
                if (CallChecker.beforeDeref(centroid, int[].class, 73, 2574, 2581)) {
                    if (CallChecker.beforeDeref(points, Collection.class, 73, 2589, 2594)) {
                        centroid = CallChecker.beforeCalled(centroid, int[].class, 73, 2574, 2581);
                        CallChecker.isCalled(centroid, int[].class, 73, 2574, 2581)[i] /= CallChecker.isCalled(points, Collection.class, 73, 2589, 2594).size();
                        CallChecker.varAssign(CallChecker.isCalled(centroid, int[].class, 73, 2574, 2581)[i], "CallChecker.isCalled(centroid, int[].class, 73, 2574, 2581)[i]", 73, 2574, 2602);
                    }
                }
            }
            return new EuclideanIntegerPoint(centroid);
        } catch (ForceReturn _bcornu_return_t) {
            return ((EuclideanIntegerPoint) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1374.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object other) {
        MethodContext _bcornu_methode_context1375 = new MethodContext(boolean.class, 80, 2677, 2933);
        try {
            CallChecker.varInit(this, "this", 80, 2677, 2933);
            CallChecker.varInit(other, "other", 80, 2677, 2933);
            CallChecker.varInit(this.point, "point", 80, 2677, 2933);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanIntegerPoint.serialVersionUID", 80, 2677, 2933);
            if (!(other instanceof EuclideanIntegerPoint)) {
                return false;
            }
            if (CallChecker.beforeDeref(other, Object.class, 84, 2914, 2918)) {
                return Arrays.equals(point, CallChecker.isCalled(((EuclideanIntegerPoint) (other)), EuclideanIntegerPoint.class, 84, 2914, 2918).point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1375.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1376 = new MethodContext(int.class, 89, 2940, 3046);
        try {
            CallChecker.varInit(this, "this", 89, 2940, 3046);
            CallChecker.varInit(this.point, "point", 89, 2940, 3046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanIntegerPoint.serialVersionUID", 89, 2940, 3046);
            return Arrays.hashCode(point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1376.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1377 = new MethodContext(String.class, 98, 3053, 3192);
        try {
            CallChecker.varInit(this, "this", 98, 3053, 3192);
            CallChecker.varInit(this.point, "point", 98, 3053, 3192);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.EuclideanIntegerPoint.serialVersionUID", 98, 3053, 3192);
            return Arrays.toString(point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1377.methodEnd();
        }
    }
}

