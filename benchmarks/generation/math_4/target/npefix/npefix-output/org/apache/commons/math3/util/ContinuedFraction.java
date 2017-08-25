package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public abstract class ContinuedFraction {
    private static final double DEFAULT_EPSILON = 1.0E-8;

    protected ContinuedFraction() {
        super();
        ConstructorContext _bcornu_methode_context91 = new ConstructorContext(ContinuedFraction.class, 44, 1522, 1619);
        try {
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    protected abstract double getA(int n, double x);

    protected abstract double getB(int n, double x);

    public double evaluate(double x) throws ConvergenceException {
        MethodContext _bcornu_methode_context349 = new MethodContext(double.class, 72, 2328, 2708);
        try {
            CallChecker.varInit(this, "this", 72, 2328, 2708);
            CallChecker.varInit(x, "x", 72, 2328, 2708);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.util.ContinuedFraction.DEFAULT_EPSILON", 72, 2328, 2708);
            return evaluate(x, ContinuedFraction.DEFAULT_EPSILON, Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context349.methodEnd();
        }
    }

    public double evaluate(double x, double epsilon) throws ConvergenceException {
        MethodContext _bcornu_methode_context350 = new MethodContext(double.class, 83, 2715, 3148);
        try {
            CallChecker.varInit(this, "this", 83, 2715, 3148);
            CallChecker.varInit(epsilon, "epsilon", 83, 2715, 3148);
            CallChecker.varInit(x, "x", 83, 2715, 3148);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.util.ContinuedFraction.DEFAULT_EPSILON", 83, 2715, 3148);
            return evaluate(x, epsilon, Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context350.methodEnd();
        }
    }

    public double evaluate(double x, int maxIterations) throws ConvergenceException, MaxCountExceededException {
        MethodContext _bcornu_methode_context351 = new MethodContext(double.class, 95, 3155, 3727);
        try {
            CallChecker.varInit(this, "this", 95, 3155, 3727);
            CallChecker.varInit(maxIterations, "maxIterations", 95, 3155, 3727);
            CallChecker.varInit(x, "x", 95, 3155, 3727);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.util.ContinuedFraction.DEFAULT_EPSILON", 95, 3155, 3727);
            return evaluate(x, ContinuedFraction.DEFAULT_EPSILON, maxIterations);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context351.methodEnd();
        }
    }

    public double evaluate(double x, double epsilon, int maxIterations) throws ConvergenceException, MaxCountExceededException {
        MethodContext _bcornu_methode_context352 = new MethodContext(double.class, 123, 3734, 6640);
        try {
            CallChecker.varInit(this, "this", 123, 3734, 6640);
            CallChecker.varInit(maxIterations, "maxIterations", 123, 3734, 6640);
            CallChecker.varInit(epsilon, "epsilon", 123, 3734, 6640);
            CallChecker.varInit(x, "x", 123, 3734, 6640);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.util.ContinuedFraction.DEFAULT_EPSILON", 123, 3734, 6640);
            final double small = CallChecker.varInit(((double) (1.0E-50)), "small", 125, 4984, 5010);
            double hPrev = CallChecker.varInit(((double) (getA(0, x))), "hPrev", 126, 5020, 5045);
            if (Precision.equals(hPrev, 0.0, small)) {
                hPrev = small;
                CallChecker.varAssign(hPrev, "hPrev", 130, 5181, 5194);
            }
            int n = CallChecker.varInit(((int) (1)), "n", 133, 5215, 5224);
            double dPrev = CallChecker.varInit(((double) (0.0)), "dPrev", 134, 5234, 5252);
            double cPrev = CallChecker.varInit(((double) (hPrev)), "cPrev", 135, 5262, 5282);
            double hN = CallChecker.varInit(((double) (hPrev)), "hN", 136, 5292, 5309);
            while (n < maxIterations) {
                final double a = CallChecker.varInit(((double) (getA(n, x))), "a", 139, 5360, 5387);
                final double b = CallChecker.varInit(((double) (getB(n, x))), "b", 140, 5401, 5428);
                double dN = CallChecker.varInit(((double) (a + (b * dPrev))), "dN", 142, 5443, 5468);
                if (Precision.equals(dN, 0.0, small)) {
                    dN = small;
                    CallChecker.varAssign(dN, "dN", 144, 5538, 5548);
                }
                double cN = CallChecker.varInit(((double) (a + (b / cPrev))), "cN", 146, 5576, 5601);
                if (Precision.equals(cN, 0.0, small)) {
                    cN = small;
                    CallChecker.varAssign(cN, "cN", 148, 5671, 5681);
                }
                dN = 1 / dN;
                CallChecker.varAssign(dN, "dN", 151, 5710, 5721);
                final double deltaN = CallChecker.varInit(((double) (cN * dN)), "deltaN", 152, 5735, 5764);
                hN = hPrev * deltaN;
                CallChecker.varAssign(hN, "hN", 153, 5778, 5797);
                if (Double.isInfinite(hN)) {
                    throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_INFINITY_DIVERGENCE, x);
                }
                if (Double.isNaN(hN)) {
                    throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_NAN_DIVERGENCE, x);
                }
                if ((FastMath.abs((deltaN - 1.0))) < epsilon) {
                    break;
                }
                dPrev = dN;
                CallChecker.varAssign(dPrev, "dPrev", 168, 6317, 6327);
                cPrev = cN;
                CallChecker.varAssign(cPrev, "cPrev", 169, 6341, 6351);
                hPrev = hN;
                CallChecker.varAssign(hPrev, "hPrev", 170, 6365, 6375);
                n++;
            } 
            if (n >= maxIterations) {
                throw new MaxCountExceededException(LocalizedFormats.NON_CONVERGENT_CONTINUED_FRACTION, maxIterations, x);
            }
            return hN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context352.methodEnd();
        }
    }
}

