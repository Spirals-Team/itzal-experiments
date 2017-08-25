package org.apache.commons.math3.ml.distance;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.MathArrays;

public class ManhattanDistance implements DistanceMeasure {
    private static final long serialVersionUID = -9108154600539125566L;

    public double compute(double[] a, double[] b) {
        MethodContext _bcornu_methode_context2072 = new MethodContext(double.class, 33, 1199, 1319);
        try {
            CallChecker.varInit(this, "this", 33, 1199, 1319);
            CallChecker.varInit(b, "b", 33, 1199, 1319);
            CallChecker.varInit(a, "a", 33, 1199, 1319);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.distance.ManhattanDistance.serialVersionUID", 33, 1199, 1319);
            return MathArrays.distance1(a, b);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2072.methodEnd();
        }
    }
}

