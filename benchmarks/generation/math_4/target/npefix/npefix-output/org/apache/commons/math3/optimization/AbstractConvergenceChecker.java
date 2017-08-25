package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.Precision;

@Deprecated
public abstract class AbstractConvergenceChecker<PAIR> implements ConvergenceChecker<PAIR> {
    @Deprecated
    private static final double DEFAULT_RELATIVE_THRESHOLD = 100 * (Precision.EPSILON);

    @Deprecated
    private static final double DEFAULT_ABSOLUTE_THRESHOLD = 100 * (Precision.SAFE_MIN);

    private final double relativeThreshold;

    private final double absoluteThreshold;

    @Deprecated
    public AbstractConvergenceChecker() {
        ConstructorContext _bcornu_methode_context921 = new ConstructorContext(AbstractConvergenceChecker.class, 66, 1975, 2551);
        try {
            this.relativeThreshold = AbstractConvergenceChecker.DEFAULT_RELATIVE_THRESHOLD;
            CallChecker.varAssign(this.relativeThreshold, "this.relativeThreshold", 67, 2433, 2484);
            this.absoluteThreshold = AbstractConvergenceChecker.DEFAULT_ABSOLUTE_THRESHOLD;
            CallChecker.varAssign(this.absoluteThreshold, "this.absoluteThreshold", 68, 2494, 2545);
        } finally {
            _bcornu_methode_context921.methodEnd();
        }
    }

    public AbstractConvergenceChecker(final double relativeThreshold, final double absoluteThreshold) {
        ConstructorContext _bcornu_methode_context922 = new ConstructorContext(AbstractConvergenceChecker.class, 77, 2558, 3003);
        try {
            this.relativeThreshold = relativeThreshold;
            CallChecker.varAssign(this.relativeThreshold, "this.relativeThreshold", 79, 2903, 2945);
            this.absoluteThreshold = absoluteThreshold;
            CallChecker.varAssign(this.absoluteThreshold, "this.absoluteThreshold", 80, 2955, 2997);
        } finally {
            _bcornu_methode_context922.methodEnd();
        }
    }

    public double getRelativeThreshold() {
        MethodContext _bcornu_methode_context4208 = new MethodContext(double.class, 86, 3010, 3142);
        try {
            CallChecker.varInit(this, "this", 86, 3010, 3142);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 86, 3010, 3142);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 86, 3010, 3142);
            CallChecker.varInit(DEFAULT_ABSOLUTE_THRESHOLD, "org.apache.commons.math3.optimization.AbstractConvergenceChecker.DEFAULT_ABSOLUTE_THRESHOLD", 86, 3010, 3142);
            CallChecker.varInit(DEFAULT_RELATIVE_THRESHOLD, "org.apache.commons.math3.optimization.AbstractConvergenceChecker.DEFAULT_RELATIVE_THRESHOLD", 86, 3010, 3142);
            return relativeThreshold;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4208.methodEnd();
        }
    }

    public double getAbsoluteThreshold() {
        MethodContext _bcornu_methode_context4209 = new MethodContext(double.class, 93, 3149, 3281);
        try {
            CallChecker.varInit(this, "this", 93, 3149, 3281);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 93, 3149, 3281);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 93, 3149, 3281);
            CallChecker.varInit(DEFAULT_ABSOLUTE_THRESHOLD, "org.apache.commons.math3.optimization.AbstractConvergenceChecker.DEFAULT_ABSOLUTE_THRESHOLD", 93, 3149, 3281);
            CallChecker.varInit(DEFAULT_RELATIVE_THRESHOLD, "org.apache.commons.math3.optimization.AbstractConvergenceChecker.DEFAULT_RELATIVE_THRESHOLD", 93, 3149, 3281);
            return absoluteThreshold;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4209.methodEnd();
        }
    }

    public abstract boolean converged(int iteration, PAIR previous, PAIR current);
}

