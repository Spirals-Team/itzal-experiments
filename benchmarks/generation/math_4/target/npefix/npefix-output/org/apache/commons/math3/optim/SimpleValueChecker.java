package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

public class SimpleValueChecker extends AbstractConvergenceChecker<PointValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    public SimpleValueChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1226 = new ConstructorContext(SimpleValueChecker.class, 64, 2219, 2866);
        try {
            maxIterationCount = SimpleValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 67, 2816, 2860);
        } finally {
            _bcornu_methode_context1226.methodEnd();
        }
    }

    public SimpleValueChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1227 = new ConstructorContext(SimpleValueChecker.class, 84, 2873, 3801);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 92, 3768, 3795);
        } finally {
            _bcornu_methode_context1227.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final PointValuePair previous, final PointValuePair current) {
        MethodContext _bcornu_methode_context5535 = new MethodContext(boolean.class, 112, 3808, 5305);
        try {
            CallChecker.varInit(this, "this", 112, 3808, 5305);
            CallChecker.varInit(current, "current", 112, 3808, 5305);
            CallChecker.varInit(previous, "previous", 112, 3808, 5305);
            CallChecker.varInit(iteration, "iteration", 112, 3808, 5305);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 112, 3808, 5305);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optim.SimpleValueChecker.ITERATION_CHECK_DISABLED", 112, 3808, 5305);
            if (((maxIterationCount) != (SimpleValueChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            double p = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(previous, PointValuePair.class, 119, 4992, 4999)) {
                if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(previous, PointValuePair.class, 119, 4992, 4999).getValue())), double.class, 119, 4992, 5010)) {
                    if (CallChecker.beforeDeref(previous, PointValuePair.class, 119, 4992, 4999)) {
                        p = CallChecker.isCalled(((Double) (CallChecker.isCalled(previous, PointValuePair.class, 119, 4992, 4999).getValue())), double.class, 119, 4992, 5010);
                        CallChecker.varAssign(p, "p", 119, 4992, 5010);
                    }
                }
            }
            double c = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(current, PointValuePair.class, 120, 5038, 5044)) {
                if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(current, PointValuePair.class, 120, 5038, 5044).getValue())), double.class, 120, 5038, 5055)) {
                    if (CallChecker.beforeDeref(current, PointValuePair.class, 120, 5038, 5044)) {
                        c = CallChecker.isCalled(((Double) (CallChecker.isCalled(current, PointValuePair.class, 120, 5038, 5044).getValue())), double.class, 120, 5038, 5055);
                        CallChecker.varAssign(c, "c", 120, 5038, 5055);
                    }
                }
            }
            final double difference = CallChecker.varInit(((double) (FastMath.abs((p - c)))), "difference", 121, 5066, 5111);
            final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(p), FastMath.abs(c)))), "size", 122, 5121, 5187);
            return (difference <= (size * (getRelativeThreshold()))) || (difference <= (getAbsoluteThreshold()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5535.methodEnd();
        }
    }
}

