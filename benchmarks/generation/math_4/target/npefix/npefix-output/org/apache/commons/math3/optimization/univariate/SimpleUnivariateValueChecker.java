package org.apache.commons.math3.optimization.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.optimization.AbstractConvergenceChecker;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public class SimpleUnivariateValueChecker extends AbstractConvergenceChecker<UnivariatePointValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    @Deprecated
    public SimpleUnivariateValueChecker() {
        ConstructorContext _bcornu_methode_context1031 = new ConstructorContext(SimpleUnivariateValueChecker.class, 65, 2509, 2776);
        try {
            maxIterationCount = SimpleUnivariateValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 66, 2726, 2770);
        } finally {
            _bcornu_methode_context1031.methodEnd();
        }
    }

    public SimpleUnivariateValueChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1032 = new ConstructorContext(SimpleUnivariateValueChecker.class, 78, 2783, 3450);
        try {
            maxIterationCount = SimpleUnivariateValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 81, 3400, 3444);
        } finally {
            _bcornu_methode_context1032.methodEnd();
        }
    }

    public SimpleUnivariateValueChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1033 = new ConstructorContext(SimpleUnivariateValueChecker.class, 98, 3457, 4415);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 106, 4382, 4409);
        } finally {
            _bcornu_methode_context1033.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final UnivariatePointValuePair previous, final UnivariatePointValuePair current) {
        MethodContext _bcornu_methode_context4584 = new MethodContext(boolean.class, 126, 4422, 5939);
        try {
            CallChecker.varInit(this, "this", 126, 4422, 5939);
            CallChecker.varInit(current, "current", 126, 4422, 5939);
            CallChecker.varInit(previous, "previous", 126, 4422, 5939);
            CallChecker.varInit(iteration, "iteration", 126, 4422, 5939);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 126, 4422, 5939);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optimization.univariate.SimpleUnivariateValueChecker.ITERATION_CHECK_DISABLED", 126, 4422, 5939);
            if (((maxIterationCount) != (SimpleUnivariateValueChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            final double p = CallChecker.varInit(((double) (CallChecker.isCalled(previous, UnivariatePointValuePair.class, 133, 5626, 5633).getValue())), "p", 133, 5609, 5645);
            final double c = CallChecker.varInit(((double) (CallChecker.isCalled(current, UnivariatePointValuePair.class, 134, 5672, 5678).getValue())), "c", 134, 5655, 5690);
            final double difference = CallChecker.varInit(((double) (FastMath.abs((p - c)))), "difference", 135, 5700, 5745);
            final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(p), FastMath.abs(c)))), "size", 136, 5755, 5821);
            return (difference <= (size * (getRelativeThreshold()))) || (difference <= (getAbsoluteThreshold()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4584.methodEnd();
        }
    }
}

