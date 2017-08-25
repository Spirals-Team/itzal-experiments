package org.apache.commons.math3.optim.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.optim.OptimizationData;

public class SearchInterval implements OptimizationData {
    private final double lower;

    private final double upper;

    private final double start;

    public SearchInterval(double lo, double hi, double init) {
        ConstructorContext _bcornu_methode_context547 = new ConstructorContext(SearchInterval.class, 46, 1393, 2034);
        try {
            if (lo >= hi) {
                throw new NumberIsTooLargeException(lo, hi, false);
            }
            if ((init < lo) || (init > hi)) {
                throw new OutOfRangeException(init, lo, hi);
            }
            lower = lo;
            CallChecker.varAssign(this.lower, "this.lower", 57, 1976, 1986);
            upper = hi;
            CallChecker.varAssign(this.upper, "this.upper", 58, 1996, 2006);
            start = init;
            CallChecker.varAssign(this.start, "this.start", 59, 2016, 2028);
        } finally {
            _bcornu_methode_context547.methodEnd();
        }
    }

    public SearchInterval(double lo, double hi) {
        this(lo, hi, (0.5 * (lo + hi)));
        ConstructorContext _bcornu_methode_context548 = new ConstructorContext(SearchInterval.class, 67, 2041, 2294);
        try {
        } finally {
            _bcornu_methode_context548.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context2573 = new MethodContext(double.class, 77, 2301, 2436);
        try {
            CallChecker.varInit(this, "this", 77, 2301, 2436);
            CallChecker.varInit(this.start, "start", 77, 2301, 2436);
            CallChecker.varInit(this.upper, "upper", 77, 2301, 2436);
            CallChecker.varInit(this.lower, "lower", 77, 2301, 2436);
            return lower;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2573.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context2574 = new MethodContext(double.class, 85, 2442, 2577);
        try {
            CallChecker.varInit(this, "this", 85, 2442, 2577);
            CallChecker.varInit(this.start, "start", 85, 2442, 2577);
            CallChecker.varInit(this.upper, "upper", 85, 2442, 2577);
            CallChecker.varInit(this.lower, "lower", 85, 2442, 2577);
            return upper;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2574.methodEnd();
        }
    }

    public double getStartValue() {
        MethodContext _bcornu_methode_context2575 = new MethodContext(double.class, 93, 2583, 2725);
        try {
            CallChecker.varInit(this, "this", 93, 2583, 2725);
            CallChecker.varInit(this.start, "start", 93, 2583, 2725);
            CallChecker.varInit(this.upper, "upper", 93, 2583, 2725);
            CallChecker.varInit(this.lower, "lower", 93, 2583, 2725);
            return start;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2575.methodEnd();
        }
    }
}

