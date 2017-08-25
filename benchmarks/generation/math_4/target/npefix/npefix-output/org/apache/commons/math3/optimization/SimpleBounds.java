package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

@Deprecated
public class SimpleBounds implements OptimizationData {
    private final double[] lower;

    private final double[] upper;

    public SimpleBounds(double[] lB, double[] uB) {
        ConstructorContext _bcornu_methode_context287 = new ConstructorContext(SimpleBounds.class, 42, 1328, 1538);
        try {
            lB = CallChecker.beforeCalled(lB, double[].class, 44, 1494, 1495);
            lower = CallChecker.isCalled(lB, double[].class, 44, 1494, 1495).clone();
            CallChecker.varAssign(this.lower, "this.lower", 44, 1486, 1504);
            uB = CallChecker.beforeCalled(uB, double[].class, 45, 1522, 1523);
            upper = CallChecker.isCalled(uB, double[].class, 45, 1522, 1523).clone();
            CallChecker.varAssign(this.upper, "this.upper", 45, 1514, 1532);
        } finally {
            _bcornu_methode_context287.methodEnd();
        }
    }

    public double[] getLower() {
        MethodContext _bcornu_methode_context1308 = new MethodContext(double[].class, 53, 1545, 1695);
        try {
            CallChecker.varInit(this, "this", 53, 1545, 1695);
            CallChecker.varInit(this.upper, "upper", 53, 1545, 1695);
            CallChecker.varInit(this.lower, "lower", 53, 1545, 1695);
            if (CallChecker.beforeDeref(lower, double[].class, 54, 1676, 1680)) {
                return CallChecker.isCalled(lower, double[].class, 54, 1676, 1680).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1308.methodEnd();
        }
    }

    public double[] getUpper() {
        MethodContext _bcornu_methode_context1309 = new MethodContext(double[].class, 61, 1701, 1851);
        try {
            CallChecker.varInit(this, "this", 61, 1701, 1851);
            CallChecker.varInit(this.upper, "upper", 61, 1701, 1851);
            CallChecker.varInit(this.lower, "lower", 61, 1701, 1851);
            if (CallChecker.beforeDeref(upper, double[].class, 62, 1832, 1836)) {
                return CallChecker.isCalled(upper, double[].class, 62, 1832, 1836).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1309.methodEnd();
        }
    }
}

