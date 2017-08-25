package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public class SimpleValueChecker extends AbstractConvergenceChecker<PointValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;

    private final int maxIterationCount;

    @Deprecated
    public SimpleValueChecker() {
        ConstructorContext _bcornu_methode_context1223 = new ConstructorContext(SimpleValueChecker.class, 62, 2287, 2544);
        try {
            maxIterationCount = SimpleValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 63, 2494, 2538);
        } finally {
            _bcornu_methode_context1223.methodEnd();
        }
    }

    public SimpleValueChecker(final double relativeThreshold, final double absoluteThreshold) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1224 = new ConstructorContext(SimpleValueChecker.class, 75, 2551, 3198);
        try {
            maxIterationCount = SimpleValueChecker.ITERATION_CHECK_DISABLED;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 78, 3148, 3192);
        } finally {
            _bcornu_methode_context1224.methodEnd();
        }
    }

    public SimpleValueChecker(final double relativeThreshold, final double absoluteThreshold, final int maxIter) {
        super(relativeThreshold, absoluteThreshold);
        ConstructorContext _bcornu_methode_context1225 = new ConstructorContext(SimpleValueChecker.class, 95, 3205, 4133);
        try {
            if (maxIter <= 0) {
                throw new NotStrictlyPositiveException(maxIter);
            }
            maxIterationCount = maxIter;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 103, 4100, 4127);
        } finally {
            _bcornu_methode_context1225.methodEnd();
        }
    }

    @Override
    public boolean converged(final int iteration, final PointValuePair previous, final PointValuePair current) {
        MethodContext _bcornu_methode_context5534 = new MethodContext(boolean.class, 123, 4140, 5637);
        try {
            CallChecker.varInit(this, "this", 123, 4140, 5637);
            CallChecker.varInit(current, "current", 123, 4140, 5637);
            CallChecker.varInit(previous, "previous", 123, 4140, 5637);
            CallChecker.varInit(iteration, "iteration", 123, 4140, 5637);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 123, 4140, 5637);
            CallChecker.varInit(ITERATION_CHECK_DISABLED, "org.apache.commons.math3.optimization.SimpleValueChecker.ITERATION_CHECK_DISABLED", 123, 4140, 5637);
            if (((maxIterationCount) != (SimpleValueChecker.ITERATION_CHECK_DISABLED)) && (iteration >= (maxIterationCount))) {
                return true;
            }
            double p = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(previous, PointValuePair.class, 130, 5324, 5331)) {
                if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(previous, PointValuePair.class, 130, 5324, 5331).getValue())), double.class, 130, 5324, 5342)) {
                    if (CallChecker.beforeDeref(previous, PointValuePair.class, 130, 5324, 5331)) {
                        p = CallChecker.isCalled(((Double) (CallChecker.isCalled(previous, PointValuePair.class, 130, 5324, 5331).getValue())), double.class, 130, 5324, 5342);
                        CallChecker.varAssign(p, "p", 130, 5324, 5342);
                    }
                }
            }
            double c = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(current, PointValuePair.class, 131, 5370, 5376)) {
                if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(current, PointValuePair.class, 131, 5370, 5376).getValue())), double.class, 131, 5370, 5387)) {
                    if (CallChecker.beforeDeref(current, PointValuePair.class, 131, 5370, 5376)) {
                        c = CallChecker.isCalled(((Double) (CallChecker.isCalled(current, PointValuePair.class, 131, 5370, 5376).getValue())), double.class, 131, 5370, 5387);
                        CallChecker.varAssign(c, "c", 131, 5370, 5387);
                    }
                }
            }
            final double difference = CallChecker.varInit(((double) (FastMath.abs((p - c)))), "difference", 132, 5398, 5443);
            final double size = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(p), FastMath.abs(c)))), "size", 133, 5453, 5519);
            return (difference <= (size * (getRelativeThreshold()))) || (difference <= (getAbsoluteThreshold()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5534.methodEnd();
        }
    }
}

