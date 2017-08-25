package org.apache.commons.math3.analysis.integration;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

public class TrapezoidIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int TRAPEZOID_MAX_ITERATIONS_COUNT = 64;

    private double s;

    public TrapezoidIntegrator(final double relativeAccuracy, final double absoluteAccuracy, final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooLargeException, NumberIsTooSmallException {
        super(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context380 = new ConstructorContext(TrapezoidIntegrator.class, 60, 1920, 3432);
        try {
            if (maximalIterationCount > (TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT)) {
                throw new NumberIsTooLargeException(maximalIterationCount, TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT, false);
            }
        } finally {
            _bcornu_methode_context380.methodEnd();
        }
    }

    public TrapezoidIntegrator(final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooLargeException, NumberIsTooSmallException {
        super(minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context381 = new ConstructorContext(TrapezoidIntegrator.class, 84, 3439, 4649);
        try {
            if (maximalIterationCount > (TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT)) {
                throw new NumberIsTooLargeException(maximalIterationCount, TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT, false);
            }
        } finally {
            _bcornu_methode_context381.methodEnd();
        }
    }

    public TrapezoidIntegrator() {
        super(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT);
        ConstructorContext _bcornu_methode_context382 = new ConstructorContext(TrapezoidIntegrator.class, 98, 4656, 4923);
        try {
        } finally {
            _bcornu_methode_context382.methodEnd();
        }
    }

    double stage(final BaseAbstractUnivariateIntegrator baseIntegrator, final int n) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context1657 = new MethodContext(double.class, 117, 4930, 6815);
        try {
            CallChecker.varInit(this, "this", 117, 4930, 6815);
            CallChecker.varInit(n, "n", 117, 4930, 6815);
            CallChecker.varInit(baseIntegrator, "baseIntegrator", 117, 4930, 6815);
            CallChecker.varInit(this.iterations, "iterations", 117, 4930, 6815);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 117, 4930, 6815);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 117, 4930, 6815);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 117, 4930, 6815);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 117, 4930, 6815);
            CallChecker.varInit(this.s, "s", 117, 4930, 6815);
            CallChecker.varInit(TRAPEZOID_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT", 117, 4930, 6815);
            if (n == 0) {
                final double max = CallChecker.varInit(((double) (CallChecker.isCalled(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 121, 5828, 5841).getMax())), "max", 121, 5809, 5851);
                final double min = CallChecker.varInit(((double) (CallChecker.isCalled(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 122, 5884, 5897).getMin())), "min", 122, 5865, 5907);
                if (CallChecker.beforeDeref(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 124, 5968, 5981)) {
                    if (CallChecker.beforeDeref(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 125, 6035, 6048)) {
                        s = (0.5 * (max - min)) * ((CallChecker.isCalled(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 124, 5968, 5981).computeObjectiveValue(min)) + (CallChecker.isCalled(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 125, 6035, 6048).computeObjectiveValue(max)));
                        CallChecker.varAssign(this.s, "this.s", 123, 5921, 6077);
                    }
                }
                return s;
            }else {
                final long np = CallChecker.varInit(((long) (1L << (n - 1))), "np", 128, 6130, 6157);
                double sum = CallChecker.varInit(((double) (0)), "sum", 129, 6219, 6233);
                final double max = CallChecker.varInit(((double) (CallChecker.isCalled(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 130, 6266, 6279).getMax())), "max", 130, 6247, 6289);
                final double min = CallChecker.varInit(((double) (CallChecker.isCalled(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 131, 6322, 6335).getMin())), "min", 131, 6303, 6345);
                final double spacing = CallChecker.varInit(((double) ((max - min) / np)), "spacing", 133, 6359, 6449);
                double x = CallChecker.varInit(((double) (min + (0.5 * spacing))), "x", 134, 6463, 6493);
                for (long i = 0; i < np; i++) {
                    if (CallChecker.beforeDeref(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 136, 6588, 6601)) {
                        sum += CallChecker.isCalled(baseIntegrator, BaseAbstractUnivariateIntegrator.class, 136, 6588, 6601).computeObjectiveValue(x);
                        CallChecker.varAssign(sum, "sum", 136, 6581, 6627);
                    }
                    x += spacing;
                    CallChecker.varAssign(x, "x", 137, 6645, 6657);
                }
                s = 0.5 * ((s) + (sum * spacing));
                CallChecker.varAssign(this.s, "this.s", 140, 6748, 6777);
                return s;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1657.methodEnd();
        }
    }

    @Override
    protected double doIntegrate() throws MathIllegalArgumentException, MaxCountExceededException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context1658 = new MethodContext(double.class, 147, 6822, 7644);
        try {
            CallChecker.varInit(this, "this", 147, 6822, 7644);
            CallChecker.varInit(this.iterations, "iterations", 147, 6822, 7644);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 147, 6822, 7644);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 147, 6822, 7644);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 147, 6822, 7644);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 147, 6822, 7644);
            CallChecker.varInit(this.s, "s", 147, 6822, 7644);
            CallChecker.varInit(TRAPEZOID_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT", 147, 6822, 7644);
            double oldt = CallChecker.varInit(((double) (stage(this, 0))), "oldt", 150, 7003, 7031);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 151, 7041, 7050)) {
                CallChecker.isCalled(iterations, Incrementor.class, 151, 7041, 7050).incrementCount();
            }
            while (true) {
                final int i = CallChecker.varInit(((int) (CallChecker.isCalled(this.iterations, Incrementor.class, 153, 7119, 7128).getCount())), "i", 153, 7105, 7140);
                final double t = CallChecker.varInit(((double) (stage(this, i))), "t", 154, 7154, 7185);
                if (i >= (getMinimalIterationCount())) {
                    final double delta = CallChecker.varInit(((double) (FastMath.abs((t - oldt)))), "delta", 156, 7254, 7297);
                    final double rLimit = CallChecker.varInit(((double) (((getRelativeAccuracy()) * ((FastMath.abs(oldt)) + (FastMath.abs(t)))) * 0.5)), "rLimit", 157, 7315, 7425);
                    if ((delta <= rLimit) || (delta <= (getAbsoluteAccuracy()))) {
                        return t;
                    }
                }
                oldt = t;
                CallChecker.varAssign(oldt, "oldt", 163, 7578, 7586);
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 164, 7600, 7609)) {
                    CallChecker.isCalled(iterations, Incrementor.class, 164, 7600, 7609).incrementCount();
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1658.methodEnd();
        }
    }
}

