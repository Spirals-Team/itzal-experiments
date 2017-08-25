package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Pair;

@Deprecated
public class SimplePointChecker<PAIR extends Pair<double[], ? extends Object>> extends AbstractConvergenceChecker<PAIR> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    @Deprecated
    public SimplePointChecker() {
        ConstructorContext _bcornu_methode_context933 = new ConstructorContext(SimplePointChecker.class, 65, 2405, 2661);
        try {
            maxIterationCount = SimplePointChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 66, 2611, 2655);
        } finally {
            _bcornu_methode_context933.methodEnd();
        }
    }

    public SimplePointChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context934 = new ConstructorContext(SimplePointChecker.class, 78, 2668, 3315);
        try {
            maxIterationCount = SimplePointChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 81, 3265, 3309);
        } finally {
            _bcornu_methode_context934.methodEnd();
        }
    }

    public SimplePointChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context935 = new ConstructorContext(SimplePointChecker.class, 97, 3322, 4245);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 105, 4212, 4239);
        } finally {
            _bcornu_methode_context935.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final PAIR previous, final PAIR current) {
        MethodContext _bcornu_methode_context4237 = new MethodContext(boolean.class, 125, 4252, 5958);
        try {
            CallChecker.varInit(this, "this", 125, 4252, 5958);
            CallChecker.varInit(current, "current", 125, 4252, 5958);
            CallChecker.varInit(previous, "previous", 125, 4252, 5958);
            CallChecker.varInit(iteration, "iteration", 125, 4252, 5958);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 125, 4252, 5958);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optimization.SimplePointChecker.ITERATION_CHECK_DISABLED", 125, 4252, 5958);
            if (((maxIterationCount) != (SimplePointChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            final double[] p = CallChecker.varInit(previous.getKey(), "p", 132, 5419, 5455);
            final double[] c = CallChecker.varInit(current.getKey(), "c", 133, 5465, 5500);
            for (int i = 0; i < (CallChecker.isCalled(p, double[].class, 134, 5530, 5530).length); ++i) {
                final double pi = CallChecker.varInit(((double) (CallChecker.isCalled(p, double[].class, 135, 5577, 5577)[i])), "pi", 135, 5559, 5581);
                final double ci = CallChecker.varInit(((double) (CallChecker.isCalled(c, double[].class, 136, 5613, 5613)[i])), "ci", 136, 5595, 5617);
                final double difference = CallChecker.varInit(((double) (FastMath.abs((pi - ci)))), "difference", 137, 5631, 5678);
                final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(pi), FastMath.abs(ci)))), "size", 138, 5692, 5760);
                if ((difference > (size * (getRelativeThreshold()))) && (difference > (getAbsoluteThreshold()))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4237.methodEnd();
        }
    }
}

