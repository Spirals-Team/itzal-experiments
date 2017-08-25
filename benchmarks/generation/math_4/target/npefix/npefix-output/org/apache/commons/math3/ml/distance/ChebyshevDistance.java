package org.apache.commons.math3.ml.distance;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.MathArrays;

public class ChebyshevDistance implements DistanceMeasure {
    private static final long serialVersionUID = -4694868171115238296L;

    public double compute(double[] a, double[] b) {
        MethodContext _bcornu_methode_context4768 = new MethodContext(double.class, 33, 1205, 1327);
        try {
            CallChecker.varInit(this, "this", 33, 1205, 1327);
            CallChecker.varInit(b, "b", 33, 1205, 1327);
            CallChecker.varInit(a, "a", 33, 1205, 1327);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.distance.ChebyshevDistance.serialVersionUID", 33, 1205, 1327);
            return MathArrays.distanceInf(a, b);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4768.methodEnd();
        }
    }
}

