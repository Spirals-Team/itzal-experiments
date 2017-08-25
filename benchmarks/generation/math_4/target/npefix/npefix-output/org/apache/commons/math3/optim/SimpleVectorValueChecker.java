package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

public class SimpleVectorValueChecker extends AbstractConvergenceChecker<PointVectorValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    public SimpleVectorValueChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1126 = new ConstructorContext(SimpleVectorValueChecker.class, 65, 2298, 2964);
        try {
            maxIterationCount = SimpleVectorValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 68, 2914, 2958);
        } finally {
            _bcornu_methode_context1126.methodEnd();
        }
    }

    public SimpleVectorValueChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1127 = new ConstructorContext(SimpleVectorValueChecker.class, 86, 2971, 3956);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 94, 3923, 3950);
        } finally {
            _bcornu_methode_context1127.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final PointVectorValuePair previous, final PointVectorValuePair current) {
        MethodContext _bcornu_methode_context5008 = new MethodContext(boolean.class, 114, 3963, 5733);
        try {
            CallChecker.varInit(this, "this", 114, 3963, 5733);
            CallChecker.varInit(current, "current", 114, 3963, 5733);
            CallChecker.varInit(previous, "previous", 114, 3963, 5733);
            CallChecker.varInit(iteration, "iteration", 114, 3963, 5733);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 114, 3963, 5733);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optim.SimpleVectorValueChecker.ITERATION_CHECK_DISABLED", 114, 3963, 5733);
            if (((maxIterationCount) != (SimpleVectorValueChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            final double[] p = CallChecker.varInit(CallChecker.isCalled(previous, PointVectorValuePair.class, 121, 5181, 5188).getValueRef(), "p", 121, 5162, 5203);
            final double[] c = CallChecker.varInit(CallChecker.isCalled(current, PointVectorValuePair.class, 122, 5232, 5238).getValueRef(), "c", 122, 5213, 5253);
            for (int i = 0; i < (CallChecker.isCalled(p, double[].class, 123, 5283, 5283).length); ++i) {
                final double pi = CallChecker.varInit(((double) (CallChecker.isCalled(p, double[].class, 124, 5338, 5338)[i])), "pi", 124, 5312, 5342);
                final double ci = CallChecker.varInit(((double) (CallChecker.isCalled(c, double[].class, 125, 5382, 5382)[i])), "ci", 125, 5356, 5386);
                final double difference = CallChecker.varInit(((double) (FastMath.abs((pi - ci)))), "difference", 126, 5400, 5447);
                final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(pi), FastMath.abs(ci)))), "size", 127, 5461, 5535);
                if ((difference > (size * (getRelativeThreshold()))) && (difference > (getAbsoluteThreshold()))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5008.methodEnd();
        }
    }
}

