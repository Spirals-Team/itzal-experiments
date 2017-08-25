package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

class ClassicalRungeKuttaStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120L;

    public ClassicalRungeKuttaStepInterpolator() {
        ConstructorContext _bcornu_methode_context737 = new ConstructorContext(ClassicalRungeKuttaStepInterpolator.class, 72, 2568, 3175);
        try {
        } finally {
            _bcornu_methode_context737.methodEnd();
        }
    }

    public ClassicalRungeKuttaStepInterpolator(final ClassicalRungeKuttaStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context738 = new ConstructorContext(ClassicalRungeKuttaStepInterpolator.class, 80, 3182, 3509);
        try {
        } finally {
            _bcornu_methode_context738.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context3316 = new MethodContext(StepInterpolator.class, 86, 3516, 3659);
        try {
            CallChecker.varInit(this, "this", 86, 3516, 3659);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 86, 3516, 3659);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 86, 3516, 3659);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 86, 3516, 3659);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 86, 3516, 3659);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 86, 3516, 3659);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 86, 3516, 3659);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 86, 3516, 3659);
            CallChecker.varInit(this.currentState, "currentState", 86, 3516, 3659);
            CallChecker.varInit(this.h, "h", 86, 3516, 3659);
            CallChecker.varInit(this.integrator, "integrator", 86, 3516, 3659);
            CallChecker.varInit(this.yDotK, "yDotK", 86, 3516, 3659);
            CallChecker.varInit(this.previousState, "previousState", 86, 3516, 3659);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaStepInterpolator.serialVersionUID", 86, 3516, 3659);
            return new ClassicalRungeKuttaStepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3316.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context3317 = new MethodContext(void.class, 92, 3666, 5950);
        try {
            CallChecker.varInit(this, "this", 92, 3666, 5950);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 92, 3666, 5950);
            CallChecker.varInit(theta, "theta", 92, 3666, 5950);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 92, 3666, 5950);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 92, 3666, 5950);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 92, 3666, 5950);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 92, 3666, 5950);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 92, 3666, 5950);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 92, 3666, 5950);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 92, 3666, 5950);
            CallChecker.varInit(this.currentState, "currentState", 92, 3666, 5950);
            CallChecker.varInit(this.h, "h", 92, 3666, 5950);
            CallChecker.varInit(this.integrator, "integrator", 92, 3666, 5950);
            CallChecker.varInit(this.yDotK, "yDotK", 92, 3666, 5950);
            CallChecker.varInit(this.previousState, "previousState", 92, 3666, 5950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaStepInterpolator.serialVersionUID", 92, 3666, 5950);
            final double oneMinusTheta = CallChecker.varInit(((double) (1 - theta)), "oneMinusTheta", 95, 3863, 3902);
            final double oneMinus2Theta = CallChecker.varInit(((double) (1 - (2 * theta))), "oneMinus2Theta", 96, 3912, 3955);
            final double coeffDot1 = CallChecker.varInit(((double) (oneMinusTheta * oneMinus2Theta)), "coeffDot1", 97, 3965, 4024);
            final double coeffDot23 = CallChecker.varInit(((double) ((2 * theta) * oneMinusTheta)), "coeffDot23", 98, 4034, 4088);
            final double coeffDot4 = CallChecker.varInit(((double) ((-theta) * oneMinus2Theta)), "coeffDot4", 99, 4098, 4150);
            if (((previousState) != null) && (theta <= 0.5)) {
                final double fourTheta2 = CallChecker.varInit(((double) ((4 * theta) * theta)), "fourTheta2", 101, 4221, 4268);
                final double s = CallChecker.varInit(((double) ((theta * (this.h)) / 6.0)), "s", 102, 4282, 4326);
                final double coeff1 = CallChecker.varInit(((double) (s * ((6 - (9 * theta)) + fourTheta2))), "coeff1", 103, 4340, 4402);
                final double coeff23 = CallChecker.varInit(((double) (s * ((6 * theta) - fourTheta2))), "coeff23", 104, 4416, 4474);
                final double coeff4 = CallChecker.varInit(((double) (s * (((-3) * theta) + fourTheta2))), "coeff4", 105, 4488, 4546);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 106, 4580, 4596);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 106, 4580, 4596).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 107, 4651, 4655);
                    CallChecker.isCalled(yDotK, double[][].class, 107, 4651, 4655)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 107, 4651, 4655)[0], double[].class, 107, 4651, 4658);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 107, 4651, 4655)[0], double[].class, 107, 4651, 4658)[i])), "yDot1", 107, 4629, 4662);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 108, 4702, 4706);
                    CallChecker.isCalled(yDotK, double[][].class, 108, 4702, 4706)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 108, 4702, 4706)[1], double[].class, 108, 4702, 4709);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 108, 4716, 4720);
                    CallChecker.isCalled(yDotK, double[][].class, 108, 4716, 4720)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 108, 4716, 4720)[2], double[].class, 108, 4716, 4723);
                    final double yDot23 = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 108, 4702, 4706)[1], double[].class, 108, 4702, 4709)[i]) + (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 108, 4716, 4720)[2], double[].class, 108, 4716, 4723)[i]))), "yDot23", 108, 4680, 4727);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 109, 4767, 4771);
                    CallChecker.isCalled(yDotK, double[][].class, 109, 4767, 4771)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 109, 4767, 4771)[3], double[].class, 109, 4767, 4774);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 109, 4767, 4771)[3], double[].class, 109, 4767, 4774)[i])), "yDot4", 109, 4745, 4778);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 110, 4796, 4812)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 110, 4796, 4812);
                        CallChecker.isCalled(interpolatedState, double[].class, 110, 4796, 4812)[i] = (((previousState[i]) + (coeff1 * yDot1)) + (coeff23 * yDot23)) + (coeff4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 110, 4796, 4812)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 110, 4796, 4812)[i]", 110, 4796, 4914);
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 112, 4932, 4954)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 112, 4932, 4954);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 112, 4932, 4954)[i] = ((coeffDot1 * yDot1) + (coeffDot23 * yDot23)) + (coeffDot4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 112, 4932, 4954)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 112, 4932, 4954)[i]", 112, 4932, 5044);
                    }
                }
            }else {
                final double fourTheta = CallChecker.varInit(((double) (4 * theta)), "fourTheta", 116, 5089, 5128);
                final double s = CallChecker.varInit(((double) (oneMinusThetaH / 6.0)), "s", 117, 5142, 5191);
                final double coeff1 = CallChecker.varInit(((double) (s * ((((-fourTheta) + 5) * theta) - 1))), "coeff1", 118, 5205, 5268);
                final double coeff23 = CallChecker.varInit(((double) (s * (((fourTheta - 2) * theta) - 2))), "coeff23", 119, 5282, 5345);
                final double coeff4 = CallChecker.varInit(((double) (s * ((((-fourTheta) - 1) * theta) - 1))), "coeff4", 120, 5359, 5422);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 121, 5456, 5472);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 121, 5456, 5472).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 122, 5527, 5531);
                    CallChecker.isCalled(yDotK, double[][].class, 122, 5527, 5531)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 122, 5527, 5531)[0], double[].class, 122, 5527, 5534);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 122, 5527, 5531)[0], double[].class, 122, 5527, 5534)[i])), "yDot1", 122, 5505, 5538);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 123, 5578, 5582);
                    CallChecker.isCalled(yDotK, double[][].class, 123, 5578, 5582)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 123, 5578, 5582)[1], double[].class, 123, 5578, 5585);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 123, 5592, 5596);
                    CallChecker.isCalled(yDotK, double[][].class, 123, 5592, 5596)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 123, 5592, 5596)[2], double[].class, 123, 5592, 5599);
                    final double yDot23 = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 123, 5578, 5582)[1], double[].class, 123, 5578, 5585)[i]) + (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 123, 5592, 5596)[2], double[].class, 123, 5592, 5599)[i]))), "yDot23", 123, 5556, 5603);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 124, 5643, 5647);
                    CallChecker.isCalled(yDotK, double[][].class, 124, 5643, 5647)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 124, 5643, 5647)[3], double[].class, 124, 5643, 5650);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 124, 5643, 5647)[3], double[].class, 124, 5643, 5650)[i])), "yDot4", 124, 5621, 5654);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 125, 5672, 5688)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 126, 5719, 5730)) {
                            interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 125, 5672, 5688);
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 126, 5719, 5730);
                            CallChecker.isCalled(interpolatedState, double[].class, 125, 5672, 5688)[i] = (((CallChecker.isCalled(currentState, double[].class, 126, 5719, 5730)[i]) + (coeff1 * yDot1)) + (coeff23 * yDot23)) + (coeff4 * yDot4);
                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 125, 5672, 5688)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 125, 5672, 5688)[i]", 125, 5672, 5789);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 127, 5807, 5829)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 127, 5807, 5829);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 127, 5807, 5829)[i] = ((coeffDot1 * yDot1) + (coeffDot23 * yDot23)) + (coeffDot4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 127, 5807, 5829)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 127, 5807, 5829)[i]", 127, 5807, 5919);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3317.methodEnd();
        }
    }
}

