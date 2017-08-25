package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;

public class SimpleBounds implements OptimizationData {
    private final double[] lower;

    private final double[] upper;

    public SimpleBounds(double[] lB, double[] uB) {
        ConstructorContext _bcornu_methode_context288 = new ConstructorContext(SimpleBounds.class, 41, 1285, 1495);
        try {
            lB = CallChecker.beforeCalled(lB, double[].class, 43, 1451, 1452);
            lower = CallChecker.isCalled(lB, double[].class, 43, 1451, 1452).clone();
            CallChecker.varAssign(this.lower, "this.lower", 43, 1443, 1461);
            uB = CallChecker.beforeCalled(uB, double[].class, 44, 1479, 1480);
            upper = CallChecker.isCalled(uB, double[].class, 44, 1479, 1480).clone();
            CallChecker.varAssign(this.upper, "this.upper", 44, 1471, 1489);
        } finally {
            _bcornu_methode_context288.methodEnd();
        }
    }

    public double[] getLower() {
        MethodContext _bcornu_methode_context1310 = new MethodContext(double[].class, 52, 1502, 1651);
        try {
            CallChecker.varInit(this, "this", 52, 1502, 1651);
            CallChecker.varInit(this.upper, "upper", 52, 1502, 1651);
            CallChecker.varInit(this.lower, "lower", 52, 1502, 1651);
            if (CallChecker.beforeDeref(lower, double[].class, 53, 1632, 1636)) {
                return CallChecker.isCalled(lower, double[].class, 53, 1632, 1636).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1310.methodEnd();
        }
    }

    public double[] getUpper() {
        MethodContext _bcornu_methode_context1311 = new MethodContext(double[].class, 60, 1657, 1806);
        try {
            CallChecker.varInit(this, "this", 60, 1657, 1806);
            CallChecker.varInit(this.upper, "upper", 60, 1657, 1806);
            CallChecker.varInit(this.lower, "lower", 60, 1657, 1806);
            if (CallChecker.beforeDeref(upper, double[].class, 61, 1787, 1791)) {
                return CallChecker.isCalled(upper, double[].class, 61, 1787, 1791).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1311.methodEnd();
        }
    }

    public static SimpleBounds unbounded(int dim) {
        MethodContext _bcornu_methode_context1312 = new MethodContext(SimpleBounds.class, 72, 1813, 2371);
        try {
            CallChecker.varInit(dim, "dim", 72, 1813, 2371);
            final double[] lB = CallChecker.varInit(new double[dim], "lB", 73, 2141, 2176);
            Arrays.fill(lB, Double.NEGATIVE_INFINITY);
            final double[] uB = CallChecker.varInit(new double[dim], "uB", 75, 2237, 2272);
            Arrays.fill(uB, Double.POSITIVE_INFINITY);
            return new SimpleBounds(lB, uB);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SimpleBounds) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1312.methodEnd();
        }
    }
}

