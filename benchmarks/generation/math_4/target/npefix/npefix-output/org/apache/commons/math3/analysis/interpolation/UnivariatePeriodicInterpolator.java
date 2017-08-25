package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class UnivariatePeriodicInterpolator implements UnivariateInterpolator {
    public static final int DEFAULT_EXTEND = 5;

    private final UnivariateInterpolator interpolator;

    private final double period;

    private final int extend;

    public UnivariatePeriodicInterpolator(UnivariateInterpolator interpolator, double period, int extend) {
        ConstructorContext _bcornu_methode_context368 = new ConstructorContext(UnivariatePeriodicInterpolator.class, 58, 2026, 2792);
        try {
            this.interpolator = interpolator;
            CallChecker.varAssign(this.interpolator, "this.interpolator", 61, 2694, 2726);
            this.period = period;
            CallChecker.varAssign(this.period, "this.period", 62, 2736, 2756);
            this.extend = extend;
            CallChecker.varAssign(this.extend, "this.extend", 63, 2766, 2786);
        } finally {
            _bcornu_methode_context368.methodEnd();
        }
    }

    public UnivariatePeriodicInterpolator(UnivariateInterpolator interpolator, double period) {
        this(interpolator, period, UnivariatePeriodicInterpolator.DEFAULT_EXTEND);
        ConstructorContext _bcornu_methode_context369 = new ConstructorContext(UnivariatePeriodicInterpolator.class, 74, 2799, 3236);
        try {
        } finally {
            _bcornu_methode_context369.methodEnd();
        }
    }

    public UnivariateFunction interpolate(double[] xval, double[] yval) throws NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context1624 = new MethodContext(UnivariateFunction.class, 85, 3243, 4881);
        try {
            CallChecker.varInit(this, "this", 85, 3243, 4881);
            CallChecker.varInit(yval, "yval", 85, 3243, 4881);
            CallChecker.varInit(xval, "xval", 85, 3243, 4881);
            CallChecker.varInit(this.extend, "extend", 85, 3243, 4881);
            CallChecker.varInit(this.period, "period", 85, 3243, 4881);
            CallChecker.varInit(this.interpolator, "interpolator", 85, 3243, 4881);
            CallChecker.varInit(DEFAULT_EXTEND, "org.apache.commons.math3.analysis.interpolation.UnivariatePeriodicInterpolator.DEFAULT_EXTEND", 85, 3243, 4881);
            if (CallChecker.beforeDeref(xval, double[].class, 88, 3606, 3609)) {
                xval = CallChecker.beforeCalled(xval, double[].class, 88, 3606, 3609);
                if ((CallChecker.isCalled(xval, double[].class, 88, 3606, 3609).length) < (extend)) {
                    if (CallChecker.beforeDeref(xval, double[].class, 89, 3678, 3681)) {
                        xval = CallChecker.beforeCalled(xval, double[].class, 89, 3678, 3681);
                        throw new NumberIsTooSmallException(CallChecker.isCalled(xval, double[].class, 89, 3678, 3681).length, extend, true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            MathArrays.checkOrder(xval);
            xval = CallChecker.beforeCalled(xval, double[].class, 93, 3784, 3787);
            final double offset = CallChecker.varInit(((double) (CallChecker.isCalled(xval, double[].class, 93, 3784, 3787)[0])), "offset", 93, 3762, 3791);
            xval = CallChecker.beforeCalled(xval, double[].class, 95, 3818, 3821);
            final int len = CallChecker.varInit(((int) ((CallChecker.isCalled(xval, double[].class, 95, 3818, 3821).length) + ((this.extend) * 2))), "len", 95, 3802, 3842);
            final double[] x = CallChecker.varInit(new double[len], "x", 96, 3852, 3886);
            final double[] y = CallChecker.varInit(new double[len], "y", 97, 3896, 3930);
            xval = CallChecker.beforeCalled(xval, double[].class, 98, 3960, 3963);
            for (int i = 0; i < (CallChecker.isCalled(xval, double[].class, 98, 3960, 3963).length); i++) {
                final int index = CallChecker.varInit(((int) (i + (this.extend))), "index", 99, 3992, 4020);
                if (CallChecker.beforeDeref(x, double[].class, 100, 4034, 4034)) {
                    if (CallChecker.beforeDeref(xval, double[].class, 100, 4062, 4065)) {
                        xval = CallChecker.beforeCalled(xval, double[].class, 100, 4062, 4065);
                        CallChecker.isCalled(x, double[].class, 100, 4034, 4034)[index] = MathUtils.reduce(CallChecker.isCalled(xval, double[].class, 100, 4062, 4065)[i], period, offset);
                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 100, 4034, 4034)[index], "CallChecker.isCalled(x, double[].class, 100, 4034, 4034)[index]", 100, 4034, 4086);
                    }
                }
                if (CallChecker.beforeDeref(y, double[].class, 101, 4100, 4100)) {
                    if (CallChecker.beforeDeref(yval, double[].class, 101, 4111, 4114)) {
                        yval = CallChecker.beforeCalled(yval, double[].class, 101, 4111, 4114);
                        CallChecker.isCalled(y, double[].class, 101, 4100, 4100)[index] = CallChecker.isCalled(yval, double[].class, 101, 4111, 4114)[i];
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 101, 4100, 4100)[index], "CallChecker.isCalled(y, double[].class, 101, 4100, 4100)[index]", 101, 4100, 4118);
                    }
                }
            }
            for (int i = 0; i < (extend); i++) {
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(xval, double[].class, 106, 4257, 4260)) {
                    xval = CallChecker.beforeCalled(xval, double[].class, 106, 4257, 4260);
                    index = ((CallChecker.isCalled(xval, double[].class, 106, 4257, 4260).length) - (extend)) + i;
                    CallChecker.varAssign(index, "index", 106, 4257, 4260);
                }
                if (CallChecker.beforeDeref(x, double[].class, 107, 4295, 4295)) {
                    if (CallChecker.beforeDeref(xval, double[].class, 107, 4319, 4322)) {
                        xval = CallChecker.beforeCalled(xval, double[].class, 107, 4319, 4322);
                        CallChecker.isCalled(x, double[].class, 107, 4295, 4295)[i] = (MathUtils.reduce(CallChecker.isCalled(xval, double[].class, 107, 4319, 4322)[index], period, offset)) - (period);
                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 107, 4295, 4295)[i], "CallChecker.isCalled(x, double[].class, 107, 4295, 4295)[i]", 107, 4295, 4356);
                    }
                }
                if (CallChecker.beforeDeref(y, double[].class, 108, 4370, 4370)) {
                    if (CallChecker.beforeDeref(yval, double[].class, 108, 4377, 4380)) {
                        yval = CallChecker.beforeCalled(yval, double[].class, 108, 4377, 4380);
                        CallChecker.isCalled(y, double[].class, 108, 4370, 4370)[i] = CallChecker.isCalled(yval, double[].class, 108, 4377, 4380)[index];
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 108, 4370, 4370)[i], "CallChecker.isCalled(y, double[].class, 108, 4370, 4370)[i]", 108, 4370, 4388);
                    }
                }
                index = (len - (extend)) + i;
                CallChecker.varAssign(index, "index", 110, 4403, 4427);
                if (CallChecker.beforeDeref(x, double[].class, 111, 4441, 4441)) {
                    if (CallChecker.beforeDeref(xval, double[].class, 111, 4469, 4472)) {
                        xval = CallChecker.beforeCalled(xval, double[].class, 111, 4469, 4472);
                        CallChecker.isCalled(x, double[].class, 111, 4441, 4441)[index] = (MathUtils.reduce(CallChecker.isCalled(xval, double[].class, 111, 4469, 4472)[i], period, offset)) + (period);
                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 111, 4441, 4441)[index], "CallChecker.isCalled(x, double[].class, 111, 4441, 4441)[index]", 111, 4441, 4502);
                    }
                }
                if (CallChecker.beforeDeref(y, double[].class, 112, 4516, 4516)) {
                    if (CallChecker.beforeDeref(yval, double[].class, 112, 4527, 4530)) {
                        yval = CallChecker.beforeCalled(yval, double[].class, 112, 4527, 4530);
                        CallChecker.isCalled(y, double[].class, 112, 4516, 4516)[index] = CallChecker.isCalled(yval, double[].class, 112, 4527, 4530)[i];
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 112, 4516, 4516)[index], "CallChecker.isCalled(y, double[].class, 112, 4516, 4516)[index]", 112, 4516, 4534);
                    }
                }
            }
            MathArrays.sortInPlace(x, y);
            final UnivariateFunction f = CallChecker.varInit(CallChecker.isCalled(interpolator, UnivariateInterpolator.class, 117, 4623, 4634).interpolate(x, y), "f", 117, 4594, 4653);
            return new UnivariateFunction() {
                public double value(final double x) throws MathIllegalArgumentException {
                    MethodContext _bcornu_methode_context1623 = new MethodContext(double.class, 119, 4709, 4864);
                    try {
                        CallChecker.varInit(this, "this", 119, 4709, 4864);
                        CallChecker.varInit(x, "x", 119, 4709, 4864);
                        if (CallChecker.beforeDeref(f, UnivariateFunction.class, 120, 4806, 4806)) {
                            return CallChecker.isCalled(f, UnivariateFunction.class, 120, 4806, 4806).value(MathUtils.reduce(x, period, offset));
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1623.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1624.methodEnd();
        }
    }
}

