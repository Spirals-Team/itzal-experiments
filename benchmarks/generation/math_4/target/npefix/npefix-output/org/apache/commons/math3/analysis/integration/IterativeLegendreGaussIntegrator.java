package org.apache.commons.math3.analysis.integration;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.gauss.GaussIntegrator;
import org.apache.commons.math3.analysis.integration.gauss.GaussIntegratorFactory;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

public class IterativeLegendreGaussIntegrator extends BaseAbstractUnivariateIntegrator {
    private static final GaussIntegratorFactory FACTORY = new GaussIntegratorFactory();

    private final int numberOfPoints;

    public IterativeLegendreGaussIntegrator(final int n, final double relativeAccuracy, final double absoluteAccuracy, final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        super(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context1104 = new ConstructorContext(IterativeLegendreGaussIntegrator.class, 61, 2157, 3511);
        try {
            if (n <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_POINTS, n);
            }
            numberOfPoints = n;
            CallChecker.varAssign(this.numberOfPoints, "this.numberOfPoints", 71, 3487, 3505);
        } finally {
            _bcornu_methode_context1104.methodEnd();
        }
    }

    public IterativeLegendreGaussIntegrator(final int n, final double relativeAccuracy, final double absoluteAccuracy) throws NotStrictlyPositiveException {
        this(n, relativeAccuracy, absoluteAccuracy, BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT);
        ConstructorContext _bcornu_methode_context1105 = new ConstructorContext(IterativeLegendreGaussIntegrator.class, 82, 3518, 4207);
        try {
        } finally {
            _bcornu_methode_context1105.methodEnd();
        }
    }

    public IterativeLegendreGaussIntegrator(final int n, final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        this(n, BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context1106 = new ConstructorContext(IterativeLegendreGaussIntegrator.class, 102, 4214, 5199);
        try {
        } finally {
            _bcornu_methode_context1106.methodEnd();
        }
    }

    @Override
    protected double doIntegrate() throws MathIllegalArgumentException, MaxCountExceededException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4919 = new MethodContext(double.class, 112, 5206, 6344);
        try {
            CallChecker.varInit(this, "this", 112, 5206, 6344);
            CallChecker.varInit(this.iterations, "iterations", 112, 5206, 6344);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 112, 5206, 6344);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 112, 5206, 6344);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 112, 5206, 6344);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 112, 5206, 6344);
            CallChecker.varInit(this.numberOfPoints, "numberOfPoints", 112, 5206, 6344);
            CallChecker.varInit(FACTORY, "org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator.FACTORY", 112, 5206, 6344);
            double oldt = CallChecker.varInit(((double) (stage(1))), "oldt", 115, 5440, 5462);
            int n = CallChecker.varInit(((int) (2)), "n", 117, 5473, 5482);
            while (true) {
                final double t = CallChecker.varInit(((double) (stage(n))), "t", 120, 5519, 5607);
                final double delta = CallChecker.varInit(((double) (FastMath.abs((t - oldt)))), "delta", 123, 5622, 5700);
                final double limit = CallChecker.varInit(((double) (FastMath.max(getAbsoluteAccuracy(), (((getRelativeAccuracy()) * ((FastMath.abs(oldt)) + (FastMath.abs(t)))) * 0.5)))), "limit", 124, 5714, 5885);
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 129, 5937, 5946)) {
                    if ((((CallChecker.isCalled(iterations, Incrementor.class, 129, 5937, 5946).getCount()) + 1) >= (getMinimalIterationCount())) && (delta <= limit)) {
                        return t;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final double ratio = CallChecker.varInit(((double) (FastMath.min(4, FastMath.pow((delta / limit), (0.5 / (this.numberOfPoints)))))), "ratio", 135, 6083, 6209);
                n = FastMath.max(((int) (ratio * n)), (n + 1));
                CallChecker.varAssign(n, "n", 136, 6223, 6265);
                oldt = t;
                CallChecker.varAssign(oldt, "oldt", 137, 6279, 6287);
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 138, 6301, 6310)) {
                    CallChecker.isCalled(iterations, Incrementor.class, 138, 6301, 6310).incrementCount();
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4919.methodEnd();
        }
    }

    private double stage(final int n) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4921 = new MethodContext(double.class, 150, 6351, 7508);
        try {
            CallChecker.varInit(this, "this", 150, 6351, 7508);
            CallChecker.varInit(n, "n", 150, 6351, 7508);
            CallChecker.varInit(this.iterations, "iterations", 150, 6351, 7508);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 150, 6351, 7508);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 150, 6351, 7508);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 150, 6351, 7508);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 150, 6351, 7508);
            CallChecker.varInit(this.numberOfPoints, "numberOfPoints", 150, 6351, 7508);
            CallChecker.varInit(FACTORY, "org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator.FACTORY", 150, 6351, 7508);
            final UnivariateFunction f = new UnivariateFunction() {
                public double value(double x) throws MathIllegalArgumentException, TooManyEvaluationsException {
                    MethodContext _bcornu_methode_context4920 = new MethodContext(double.class, 154, 6821, 7007);
                    try {
                        CallChecker.varInit(this, "this", 154, 6821, 7007);
                        CallChecker.varInit(x, "x", 154, 6821, 7007);
                        return computeObjectiveValue(x);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context4920.methodEnd();
                    }
                }
            };
            final double min = CallChecker.varInit(((double) (getMin())), "min", 160, 7033, 7060);
            final double max = CallChecker.varInit(((double) (getMax())), "max", 161, 7070, 7097);
            final double step = CallChecker.varInit(((double) ((max - min) / n)), "step", 162, 7107, 7142);
            double sum = CallChecker.varInit(((double) (0)), "sum", 164, 7153, 7167);
            for (int i = 0; i < n; i++) {
                final double a = CallChecker.varInit(((double) (min + (i * step))), "a", 167, 7219, 7306);
                final double b = CallChecker.varInit(((double) (a + step)), "b", 168, 7320, 7345);
                final GaussIntegrator g = CallChecker.varInit(CallChecker.isCalled(IterativeLegendreGaussIntegrator.FACTORY, GaussIntegratorFactory.class, 169, 7385, 7391).legendreHighPrecision(numberOfPoints, a, b), "g", 169, 7359, 7436);
                if (CallChecker.beforeDeref(g, GaussIntegrator.class, 170, 7457, 7457)) {
                    sum += CallChecker.isCalled(g, GaussIntegrator.class, 170, 7457, 7457).integrate(f);
                    CallChecker.varAssign(sum, "sum", 170, 7450, 7471);
                }
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4921.methodEnd();
        }
    }
}

