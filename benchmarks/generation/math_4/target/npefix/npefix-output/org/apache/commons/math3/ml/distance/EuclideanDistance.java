package org.apache.commons.math3.ml.distance;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.MathArrays;

public class EuclideanDistance implements DistanceMeasure {
    private static final long serialVersionUID = 1717556319784040040L;

    public double compute(double[] a, double[] b) {
        MethodContext _bcornu_methode_context3562 = new MethodContext(double.class, 33, 1197, 1316);
        try {
            CallChecker.varInit(this, "this", 33, 1197, 1316);
            CallChecker.varInit(b, "b", 33, 1197, 1316);
            CallChecker.varInit(a, "a", 33, 1197, 1316);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.distance.EuclideanDistance.serialVersionUID", 33, 1197, 1316);
            return MathArrays.distance(a, b);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3562.methodEnd();
        }
    }
}

