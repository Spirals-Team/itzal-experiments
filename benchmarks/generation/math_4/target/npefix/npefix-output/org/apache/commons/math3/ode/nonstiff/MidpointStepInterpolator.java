package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

class MidpointStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120L;

    public MidpointStepInterpolator() {
        ConstructorContext _bcornu_methode_context1095 = new ConstructorContext(MidpointStepInterpolator.class, 65, 1970, 2584);
        try {
        } finally {
            _bcornu_methode_context1095.methodEnd();
        }
    }

    public MidpointStepInterpolator(final MidpointStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context1096 = new ConstructorContext(MidpointStepInterpolator.class, 73, 2589, 2878);
        try {
        } finally {
            _bcornu_methode_context1096.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context4889 = new MethodContext(StepInterpolator.class, 79, 2883, 3005);
        try {
            CallChecker.varInit(this, "this", 79, 2883, 3005);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 79, 2883, 3005);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 79, 2883, 3005);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 79, 2883, 3005);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 79, 2883, 3005);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 79, 2883, 3005);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 79, 2883, 3005);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 79, 2883, 3005);
            CallChecker.varInit(this.currentState, "currentState", 79, 2883, 3005);
            CallChecker.varInit(this.h, "h", 79, 2883, 3005);
            CallChecker.varInit(this.integrator, "integrator", 79, 2883, 3005);
            CallChecker.varInit(this.yDotK, "yDotK", 79, 2883, 3005);
            CallChecker.varInit(this.previousState, "previousState", 79, 2883, 3005);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.MidpointStepInterpolator.serialVersionUID", 79, 2883, 3005);
            return new MidpointStepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4889.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context4890 = new MethodContext(void.class, 86, 3011, 4244);
        try {
            CallChecker.varInit(this, "this", 86, 3011, 4244);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 86, 3011, 4244);
            CallChecker.varInit(theta, "theta", 86, 3011, 4244);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 86, 3011, 4244);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 86, 3011, 4244);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 86, 3011, 4244);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 86, 3011, 4244);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 86, 3011, 4244);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 86, 3011, 4244);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 86, 3011, 4244);
            CallChecker.varInit(this.currentState, "currentState", 86, 3011, 4244);
            CallChecker.varInit(this.h, "h", 86, 3011, 4244);
            CallChecker.varInit(this.integrator, "integrator", 86, 3011, 4244);
            CallChecker.varInit(this.yDotK, "yDotK", 86, 3011, 4244);
            CallChecker.varInit(this.previousState, "previousState", 86, 3011, 4244);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.MidpointStepInterpolator.serialVersionUID", 86, 3011, 4244);
            final double coeffDot2 = CallChecker.varInit(((double) (2 * theta)), "coeffDot2", 89, 3198, 3232);
            final double coeffDot1 = CallChecker.varInit(((double) (1 - coeffDot2)), "coeffDot1", 90, 3238, 3276);
            if (((previousState) != null) && (theta <= 0.5)) {
                final double coeff1 = CallChecker.varInit(((double) (theta * oneMinusThetaH)), "coeff1", 93, 3340, 3387);
                final double coeff2 = CallChecker.varInit(((double) ((theta * theta) * (this.h))), "coeff2", 94, 3397, 3439);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 95, 3469, 3485);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 95, 3469, 3485).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 96, 3535, 3539);
                    CallChecker.isCalled(yDotK, double[][].class, 96, 3535, 3539)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 96, 3535, 3539)[0], double[].class, 96, 3535, 3542);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 96, 3535, 3539)[0], double[].class, 96, 3535, 3542)[i])), "yDot1", 96, 3514, 3546);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 97, 3581, 3585);
                    CallChecker.isCalled(yDotK, double[][].class, 97, 3581, 3585)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 97, 3581, 3585)[1], double[].class, 97, 3581, 3588);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 97, 3581, 3585)[1], double[].class, 97, 3581, 3588)[i])), "yDot2", 97, 3560, 3592);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 98, 3606, 3622)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 98, 3606, 3622);
                        CallChecker.isCalled(interpolatedState, double[].class, 98, 3606, 3622)[i] = ((previousState[i]) + (coeff1 * yDot1)) + (coeff2 * yDot2);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 98, 3606, 3622)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 98, 3606, 3622)[i]", 98, 3606, 3679);
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 99, 3693, 3715)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 99, 3693, 3715);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 99, 3693, 3715)[i] = (coeffDot1 * yDot1) + (coeffDot2 * yDot2);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 99, 3693, 3715)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 99, 3693, 3715)[i]", 99, 3693, 3759);
                    }
                }
            }else {
                final double coeff1 = CallChecker.varInit(((double) (oneMinusThetaH * theta)), "coeff1", 102, 3792, 3839);
                final double coeff2 = CallChecker.varInit(((double) (oneMinusThetaH * (1.0 + theta))), "coeff2", 103, 3849, 3904);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 104, 3934, 3950);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 104, 3934, 3950).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 105, 4000, 4004);
                    CallChecker.isCalled(yDotK, double[][].class, 105, 4000, 4004)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 105, 4000, 4004)[0], double[].class, 105, 4000, 4007);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 105, 4000, 4004)[0], double[].class, 105, 4000, 4007)[i])), "yDot1", 105, 3979, 4011);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 106, 4046, 4050);
                    CallChecker.isCalled(yDotK, double[][].class, 106, 4046, 4050)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 106, 4046, 4050)[1], double[].class, 106, 4046, 4053);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 106, 4046, 4050)[1], double[].class, 106, 4046, 4053)[i])), "yDot2", 106, 4025, 4057);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 107, 4071, 4087)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 107, 4094, 4105)) {
                            interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 107, 4071, 4087);
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 107, 4094, 4105);
                            CallChecker.isCalled(interpolatedState, double[].class, 107, 4071, 4087)[i] = ((CallChecker.isCalled(currentState, double[].class, 107, 4094, 4105)[i]) + (coeff1 * yDot1)) - (coeff2 * yDot2);
                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 107, 4071, 4087)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 107, 4071, 4087)[i]", 107, 4071, 4143);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 108, 4157, 4179)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 108, 4157, 4179);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 108, 4157, 4179)[i] = (coeffDot1 * yDot1) + (coeffDot2 * yDot2);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 108, 4157, 4179)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 108, 4157, 4179)[i]", 108, 4157, 4223);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4890.methodEnd();
        }
    }
}

