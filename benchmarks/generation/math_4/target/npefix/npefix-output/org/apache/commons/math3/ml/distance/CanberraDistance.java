package org.apache.commons.math3.ml.distance;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

public class CanberraDistance implements DistanceMeasure {
    private static final long serialVersionUID = -6972277381587032228L;

    public double compute(double[] a, double[] b) {
        MethodContext _bcornu_methode_context454 = new MethodContext(double.class, 33, 1178, 1553);
        try {
            CallChecker.varInit(this, "this", 33, 1178, 1553);
            CallChecker.varInit(b, "b", 33, 1178, 1553);
            CallChecker.varInit(a, "a", 33, 1178, 1553);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.distance.CanberraDistance.serialVersionUID", 33, 1178, 1553);
            double sum = CallChecker.varInit(((double) (0)), "sum", 34, 1259, 1273);
            a = CallChecker.beforeCalled(a, double[].class, 35, 1303, 1303);
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 35, 1303, 1303).length); i++) {
                a = CallChecker.beforeCalled(a, double[].class, 36, 1364, 1364);
                b = CallChecker.beforeCalled(b, double[].class, 36, 1371, 1371);
                final double num = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(a, double[].class, 36, 1364, 1364)[i]) - (CallChecker.isCalled(b, double[].class, 36, 1371, 1371)[i]))))), "num", 36, 1332, 1376);
                a = CallChecker.beforeCalled(a, double[].class, 37, 1424, 1424);
                b = CallChecker.beforeCalled(b, double[].class, 37, 1445, 1445);
                final double denom = CallChecker.varInit(((double) ((FastMath.abs(CallChecker.isCalled(a, double[].class, 37, 1424, 1424)[i])) + (FastMath.abs(CallChecker.isCalled(b, double[].class, 37, 1445, 1445)[i])))), "denom", 37, 1390, 1450);
                if ((num == 0.0) && (denom == 0.0)) {
                    sum += 0.0;
                    CallChecker.varAssign(sum, "sum", 38, 1464, 1517);
                }else {
                    sum += num / denom;
                    CallChecker.varAssign(sum, "sum", 38, 1464, 1517);
                }
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context454.methodEnd();
        }
    }
}

