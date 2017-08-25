package org.apache.commons.math3.analysis.integration;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

public class SimpsonIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int SIMPSON_MAX_ITERATIONS_COUNT = 64;

    public SimpsonIntegrator(final double relativeAccuracy, final double absoluteAccuracy, final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooLargeException, NumberIsTooSmallException {
        super(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context1205 = new ConstructorContext(SimpsonIntegrator.class, 57, 1830, 3325);
        try {
            if (maximalIterationCount > (SimpsonIntegrator.SIMPSON_MAX_ITERATIONS_COUNT)) {
                throw new NumberIsTooLargeException(maximalIterationCount, SimpsonIntegrator.SIMPSON_MAX_ITERATIONS_COUNT, false);
            }
        } finally {
            _bcornu_methode_context1205.methodEnd();
        }
    }

    public SimpsonIntegrator(final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooLargeException, NumberIsTooSmallException {
        super(minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context1206 = new ConstructorContext(SimpsonIntegrator.class, 81, 3332, 4529);
        try {
            if (maximalIterationCount > (SimpsonIntegrator.SIMPSON_MAX_ITERATIONS_COUNT)) {
                throw new NumberIsTooLargeException(maximalIterationCount, SimpsonIntegrator.SIMPSON_MAX_ITERATIONS_COUNT, false);
            }
        } finally {
            _bcornu_methode_context1206.methodEnd();
        }
    }

    public SimpsonIntegrator() {
        super(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, SimpsonIntegrator.SIMPSON_MAX_ITERATIONS_COUNT);
        ConstructorContext _bcornu_methode_context1207 = new ConstructorContext(SimpsonIntegrator.class, 95, 4536, 4788);
        try {
        } finally {
            _bcornu_methode_context1207.methodEnd();
        }
    }

    @Override
    protected double doIntegrate() throws MaxCountExceededException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context5476 = new MethodContext(double.class, 101, 4795, 5914);
        try {
            CallChecker.varInit(this, "this", 101, 4795, 5914);
            CallChecker.varInit(this.iterations, "iterations", 101, 4795, 5914);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 101, 4795, 5914);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 101, 4795, 5914);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 101, 4795, 5914);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 101, 4795, 5914);
            CallChecker.varInit(SIMPSON_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.SimpsonIntegrator.SIMPSON_MAX_ITERATIONS_COUNT", 101, 4795, 5914);
            TrapezoidIntegrator qtrap = CallChecker.varInit(new TrapezoidIntegrator(), "qtrap", 104, 4946, 4999);
            if ((getMinimalIterationCount()) == 1) {
                qtrap = CallChecker.beforeCalled(qtrap, TrapezoidIntegrator.class, 106, 5072, 5076);
                qtrap = CallChecker.beforeCalled(qtrap, TrapezoidIntegrator.class, 106, 5095, 5099);
                return ((4 * (CallChecker.isCalled(qtrap, TrapezoidIntegrator.class, 106, 5072, 5076).stage(this, 1))) - (CallChecker.isCalled(qtrap, TrapezoidIntegrator.class, 106, 5095, 5099).stage(this, 0))) / 3.0;
            }
            double olds = CallChecker.varInit(((double) (0)), "olds", 110, 5209, 5224);
            double oldt = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(qtrap, TrapezoidIntegrator.class, 111, 5248, 5252)) {
                qtrap = CallChecker.beforeCalled(qtrap, TrapezoidIntegrator.class, 111, 5248, 5252);
                oldt = CallChecker.isCalled(qtrap, TrapezoidIntegrator.class, 111, 5248, 5252).stage(this, 0);
                CallChecker.varAssign(oldt, "oldt", 111, 5248, 5252);
            }
            while (true) {
                qtrap = CallChecker.beforeCalled(qtrap, TrapezoidIntegrator.class, 113, 5322, 5326);
                final double t = CallChecker.varInit(((double) (CallChecker.isCalled(qtrap, TrapezoidIntegrator.class, 113, 5322, 5326).stage(this, CallChecker.isCalled(this.iterations, Incrementor.class, 113, 5340, 5349).getCount()))), "t", 113, 5305, 5362);
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 114, 5376, 5385)) {
                    CallChecker.isCalled(iterations, Incrementor.class, 114, 5376, 5385).incrementCount();
                }
                final double s = CallChecker.varInit(((double) (((4 * t) - oldt) / 3.0)), "s", 115, 5417, 5454);
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 116, 5472, 5481)) {
                    if ((CallChecker.isCalled(iterations, Incrementor.class, 116, 5472, 5481).getCount()) >= (getMinimalIterationCount())) {
                        final double delta = CallChecker.varInit(((double) (FastMath.abs((s - olds)))), "delta", 117, 5543, 5586);
                        final double rLimit = CallChecker.varInit(((double) (((getRelativeAccuracy()) * ((FastMath.abs(olds)) + (FastMath.abs(s)))) * 0.5)), "rLimit", 118, 5604, 5714);
                        if ((delta <= rLimit) || (delta <= (getAbsoluteAccuracy()))) {
                            return s;
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                olds = s;
                CallChecker.varAssign(olds, "olds", 124, 5867, 5875);
                oldt = t;
                CallChecker.varAssign(oldt, "oldt", 125, 5889, 5897);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5476.methodEnd();
        }
    }
}

