package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Pair;

public class SimplePointChecker<PAIR extends Pair<double[], ? extends Object>> extends AbstractConvergenceChecker<PAIR> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    public SimplePointChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context936 = new ConstructorContext(SimplePointChecker.class, 66, 2336, 2983);
        try {
            maxIterationCount = SimplePointChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 69, 2933, 2977);
        } finally {
            _bcornu_methode_context936.methodEnd();
        }
    }

    public SimplePointChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context937 = new ConstructorContext(SimplePointChecker.class, 85, 2990, 3913);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 93, 3880, 3907);
        } finally {
            _bcornu_methode_context937.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final PAIR previous, final PAIR current) {
        MethodContext _bcornu_methode_context4238 = new MethodContext(boolean.class, 113, 3920, 5626);
        try {
            CallChecker.varInit(this, "this", 113, 3920, 5626);
            CallChecker.varInit(current, "current", 113, 3920, 5626);
            CallChecker.varInit(previous, "previous", 113, 3920, 5626);
            CallChecker.varInit(iteration, "iteration", 113, 3920, 5626);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 113, 3920, 5626);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optim.SimplePointChecker.ITERATION_CHECK_DISABLED", 113, 3920, 5626);
            if (((maxIterationCount) != (SimplePointChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            final double[] p = CallChecker.varInit(previous.getKey(), "p", 120, 5087, 5123);
            final double[] c = CallChecker.varInit(current.getKey(), "c", 121, 5133, 5168);
            for (int i = 0; i < (CallChecker.isCalled(p, double[].class, 122, 5198, 5198).length); ++i) {
                final double pi = CallChecker.varInit(((double) (CallChecker.isCalled(p, double[].class, 123, 5245, 5245)[i])), "pi", 123, 5227, 5249);
                final double ci = CallChecker.varInit(((double) (CallChecker.isCalled(c, double[].class, 124, 5281, 5281)[i])), "ci", 124, 5263, 5285);
                final double difference = CallChecker.varInit(((double) (FastMath.abs((pi - ci)))), "difference", 125, 5299, 5346);
                final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(pi), FastMath.abs(ci)))), "size", 126, 5360, 5428);
                if ((difference > (size * (getRelativeThreshold()))) && (difference > (getAbsoluteThreshold()))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4238.methodEnd();
        }
    }
}

