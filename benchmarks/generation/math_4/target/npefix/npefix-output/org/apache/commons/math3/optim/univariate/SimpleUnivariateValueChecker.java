package org.apache.commons.math3.optim.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.optim.AbstractConvergenceChecker;
import org.apache.commons.math3.util.FastMath;

public class SimpleUnivariateValueChecker extends AbstractConvergenceChecker<UnivariatePointValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    public SimpleUnivariateValueChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1034 = new ConstructorContext(SimpleUnivariateValueChecker.class, 66, 2433, 3100);
        try {
            maxIterationCount = SimpleUnivariateValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 69, 3050, 3094);
        } finally {
            _bcornu_methode_context1034.methodEnd();
        }
    }

    public SimpleUnivariateValueChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1035 = new ConstructorContext(SimpleUnivariateValueChecker.class, 86, 3107, 4065);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 94, 4032, 4059);
        } finally {
            _bcornu_methode_context1035.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final UnivariatePointValuePair previous, final UnivariatePointValuePair current) {
        MethodContext _bcornu_methode_context4585 = new MethodContext(boolean.class, 114, 4072, 5589);
        try {
            CallChecker.varInit(this, "this", 114, 4072, 5589);
            CallChecker.varInit(current, "current", 114, 4072, 5589);
            CallChecker.varInit(previous, "previous", 114, 4072, 5589);
            CallChecker.varInit(iteration, "iteration", 114, 4072, 5589);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 114, 4072, 5589);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optim.univariate.SimpleUnivariateValueChecker.ITERATION_CHECK_DISABLED", 114, 4072, 5589);
            if (((maxIterationCount) != (SimpleUnivariateValueChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            final double p = CallChecker.varInit(((double) (CallChecker.isCalled(previous, UnivariatePointValuePair.class, 121, 5276, 5283).getValue())), "p", 121, 5259, 5295);
            final double c = CallChecker.varInit(((double) (CallChecker.isCalled(current, UnivariatePointValuePair.class, 122, 5322, 5328).getValue())), "c", 122, 5305, 5340);
            final double difference = CallChecker.varInit(((double) (FastMath.abs((p - c)))), "difference", 123, 5350, 5395);
            final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(p), FastMath.abs(c)))), "size", 124, 5405, 5471);
            return (difference <= (size * (getRelativeThreshold()))) || (difference <= (getAbsoluteThreshold()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4585.methodEnd();
        }
    }
}

