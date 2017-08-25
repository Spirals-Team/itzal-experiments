package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public class SimpleVectorValueChecker extends AbstractConvergenceChecker<PointVectorValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    @Deprecated
    public SimpleVectorValueChecker() {
        ConstructorContext _bcornu_methode_context1123 = new ConstructorContext(SimpleVectorValueChecker.class, 62, 2366, 2629);
        try {
            maxIterationCount = SimpleVectorValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 63, 2579, 2623);
        } finally {
            _bcornu_methode_context1123.methodEnd();
        }
    }

    public SimpleVectorValueChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1124 = new ConstructorContext(SimpleVectorValueChecker.class, 76, 2636, 3302);
        try {
            maxIterationCount = SimpleVectorValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 79, 3252, 3296);
        } finally {
            _bcornu_methode_context1124.methodEnd();
        }
    }

    public SimpleVectorValueChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1125 = new ConstructorContext(SimpleVectorValueChecker.class, 97, 3309, 4294);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 105, 4261, 4288);
        } finally {
            _bcornu_methode_context1125.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final PointVectorValuePair previous, final PointVectorValuePair current) {
        MethodContext _bcornu_methode_context5007 = new MethodContext(boolean.class, 125, 4301, 6071);
        try {
            CallChecker.varInit(this, "this", 125, 4301, 6071);
            CallChecker.varInit(current, "current", 125, 4301, 6071);
            CallChecker.varInit(previous, "previous", 125, 4301, 6071);
            CallChecker.varInit(iteration, "iteration", 125, 4301, 6071);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 125, 4301, 6071);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optimization.SimpleVectorValueChecker.ITERATION_CHECK_DISABLED", 125, 4301, 6071);
            if (((maxIterationCount) != (SimpleVectorValueChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            final double[] p = CallChecker.varInit(CallChecker.isCalled(previous, PointVectorValuePair.class, 132, 5519, 5526).getValueRef(), "p", 132, 5500, 5541);
            final double[] c = CallChecker.varInit(CallChecker.isCalled(current, PointVectorValuePair.class, 133, 5570, 5576).getValueRef(), "c", 133, 5551, 5591);
            for (int i = 0; i < (CallChecker.isCalled(p, double[].class, 134, 5621, 5621).length); ++i) {
                final double pi = CallChecker.varInit(((double) (CallChecker.isCalled(p, double[].class, 135, 5676, 5676)[i])), "pi", 135, 5650, 5680);
                final double ci = CallChecker.varInit(((double) (CallChecker.isCalled(c, double[].class, 136, 5720, 5720)[i])), "ci", 136, 5694, 5724);
                final double difference = CallChecker.varInit(((double) (FastMath.abs((pi - ci)))), "difference", 137, 5738, 5785);
                final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(pi), FastMath.abs(ci)))), "size", 138, 5799, 5873);
                if ((difference > (size * (getRelativeThreshold()))) && (difference > (getAbsoluteThreshold()))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5007.methodEnd();
        }
    }
}

