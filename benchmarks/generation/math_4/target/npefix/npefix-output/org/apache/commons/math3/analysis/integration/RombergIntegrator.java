package org.apache.commons.math3.analysis.integration;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

public class RombergIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int ROMBERG_MAX_ITERATIONS_COUNT = 32;

    public RombergIntegrator(final double relativeAccuracy, final double absoluteAccuracy, final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooLargeException, NumberIsTooSmallException {
        super(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(RombergIntegrator.class, 58, 1932, 3427);
        try {
            if (maximalIterationCount > (RombergIntegrator.ROMBERG_MAX_ITERATIONS_COUNT)) {
                throw new NumberIsTooLargeException(maximalIterationCount, RombergIntegrator.ROMBERG_MAX_ITERATIONS_COUNT, false);
            }
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public RombergIntegrator(final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooLargeException, NumberIsTooSmallException {
        super(minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(RombergIntegrator.class, 82, 3434, 4631);
        try {
            if (maximalIterationCount > (RombergIntegrator.ROMBERG_MAX_ITERATIONS_COUNT)) {
                throw new NumberIsTooLargeException(maximalIterationCount, RombergIntegrator.ROMBERG_MAX_ITERATIONS_COUNT, false);
            }
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public RombergIntegrator() {
        super(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, RombergIntegrator.ROMBERG_MAX_ITERATIONS_COUNT);
        ConstructorContext _bcornu_methode_context4 = new ConstructorContext(RombergIntegrator.class, 96, 4638, 4896);
        try {
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    @Override
    protected double doIntegrate() throws MaxCountExceededException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context8 = new MethodContext(double.class, 102, 4903, 6429);
        try {
            CallChecker.varInit(this, "this", 102, 4903, 6429);
            CallChecker.varInit(this.iterations, "iterations", 102, 4903, 6429);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 102, 4903, 6429);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 102, 4903, 6429);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 102, 4903, 6429);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 102, 4903, 6429);
            CallChecker.varInit(ROMBERG_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.RombergIntegrator.ROMBERG_MAX_ITERATIONS_COUNT", 102, 4903, 6429);
            final int m = CallChecker.varInit(((int) ((CallChecker.isCalled(this.iterations, Incrementor.class, 105, 5068, 5077).getMaximalCount()) + 1)), "m", 105, 5054, 5100);
            double[] previousRow = CallChecker.varInit(new double[m], "previousRow", 106, 5110, 5146);
            double[] currentRow = CallChecker.varInit(new double[m], "currentRow", 107, 5156, 5192);
            TrapezoidIntegrator qtrap = CallChecker.varInit(new TrapezoidIntegrator(), "qtrap", 109, 5203, 5256);
            if (CallChecker.beforeDeref(currentRow, double[].class, 110, 5266, 5275)) {
                if (CallChecker.beforeDeref(qtrap, TrapezoidIntegrator.class, 110, 5282, 5286)) {
                    currentRow = CallChecker.beforeCalled(currentRow, double[].class, 110, 5266, 5275);
                    qtrap = CallChecker.beforeCalled(qtrap, TrapezoidIntegrator.class, 110, 5282, 5286);
                    CallChecker.isCalled(currentRow, double[].class, 110, 5266, 5275)[0] = CallChecker.isCalled(qtrap, TrapezoidIntegrator.class, 110, 5282, 5286).stage(this, 0);
                    CallChecker.varAssign(CallChecker.isCalled(currentRow, double[].class, 110, 5266, 5275)[0], "CallChecker.isCalled(currentRow, double[].class, 110, 5266, 5275)[0]", 110, 5266, 5302);
                }
            }
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 111, 5312, 5321)) {
                CallChecker.isCalled(iterations, Incrementor.class, 111, 5312, 5321).incrementCount();
            }
            double olds = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(currentRow, double[].class, 112, 5363, 5372)) {
                currentRow = CallChecker.beforeCalled(currentRow, double[].class, 112, 5363, 5372);
                olds = CallChecker.isCalled(currentRow, double[].class, 112, 5363, 5372)[0];
                CallChecker.varAssign(olds, "olds", 112, 5363, 5372);
            }
            while (true) {
                final int i = CallChecker.varInit(((int) (CallChecker.isCalled(this.iterations, Incrementor.class, 115, 5428, 5437).getCount())), "i", 115, 5414, 5449);
                final double[] tmpRow = CallChecker.varInit(previousRow, "tmpRow", 118, 5491, 5526);
                previousRow = currentRow;
                CallChecker.varAssign(previousRow, "previousRow", 119, 5540, 5564);
                currentRow = tmpRow;
                CallChecker.varAssign(currentRow, "currentRow", 120, 5578, 5597);
                if (CallChecker.beforeDeref(currentRow, double[].class, 122, 5612, 5621)) {
                    if (CallChecker.beforeDeref(qtrap, TrapezoidIntegrator.class, 122, 5628, 5632)) {
                        currentRow = CallChecker.beforeCalled(currentRow, double[].class, 122, 5612, 5621);
                        qtrap = CallChecker.beforeCalled(qtrap, TrapezoidIntegrator.class, 122, 5628, 5632);
                        CallChecker.isCalled(currentRow, double[].class, 122, 5612, 5621)[0] = CallChecker.isCalled(qtrap, TrapezoidIntegrator.class, 122, 5628, 5632).stage(this, i);
                        CallChecker.varAssign(CallChecker.isCalled(currentRow, double[].class, 122, 5612, 5621)[0], "CallChecker.isCalled(currentRow, double[].class, 122, 5612, 5621)[0]", 122, 5612, 5648);
                    }
                }
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 123, 5662, 5671)) {
                    CallChecker.isCalled(iterations, Incrementor.class, 123, 5662, 5671).incrementCount();
                }
                for (int j = 1; j <= i; j++) {
                    final double r = CallChecker.varInit(((double) ((1L << (2 * j)) - 1)), "r", 126, 5750, 5842);
                    currentRow = CallChecker.beforeCalled(currentRow, double[].class, 127, 5881, 5890);
                    final double tIJm1 = CallChecker.varInit(((double) (CallChecker.isCalled(currentRow, double[].class, 127, 5881, 5890)[(j - 1)])), "tIJm1", 127, 5860, 5898);
                    if (CallChecker.beforeDeref(currentRow, double[].class, 128, 5916, 5925)) {
                        if (CallChecker.beforeDeref(previousRow, double[].class, 128, 5949, 5959)) {
                            currentRow = CallChecker.beforeCalled(currentRow, double[].class, 128, 5916, 5925);
                            previousRow = CallChecker.beforeCalled(previousRow, double[].class, 128, 5949, 5959);
                            CallChecker.isCalled(currentRow, double[].class, 128, 5916, 5925)[j] = tIJm1 + ((tIJm1 - (CallChecker.isCalled(previousRow, double[].class, 128, 5949, 5959)[(j - 1)])) / r);
                            CallChecker.varAssign(CallChecker.isCalled(currentRow, double[].class, 128, 5916, 5925)[j], "CallChecker.isCalled(currentRow, double[].class, 128, 5916, 5925)[j]", 128, 5916, 5972);
                        }
                    }
                }
                currentRow = CallChecker.beforeCalled(currentRow, double[].class, 130, 6017, 6026);
                final double s = CallChecker.varInit(((double) (CallChecker.isCalled(currentRow, double[].class, 130, 6017, 6026)[i])), "s", 130, 6000, 6030);
                if (i >= (getMinimalIterationCount())) {
                    final double delta = CallChecker.varInit(((double) (FastMath.abs((s - olds)))), "delta", 132, 6099, 6143);
                    final double rLimit = CallChecker.varInit(((double) (((getRelativeAccuracy()) * ((FastMath.abs(olds)) + (FastMath.abs(s)))) * 0.5)), "rLimit", 133, 6161, 6251);
                    if ((delta <= rLimit) || (delta <= (getAbsoluteAccuracy()))) {
                        return s;
                    }
                }
                olds = s;
                CallChecker.varAssign(olds, "olds", 138, 6404, 6412);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }
}

