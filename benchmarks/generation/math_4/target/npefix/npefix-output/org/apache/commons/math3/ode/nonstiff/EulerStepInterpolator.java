package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

class EulerStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120L;

    public EulerStepInterpolator() {
        ConstructorContext _bcornu_methode_context794 = new ConstructorContext(EulerStepInterpolator.class, 63, 1793, 2404);
        try {
        } finally {
            _bcornu_methode_context794.methodEnd();
        }
    }

    public EulerStepInterpolator(final EulerStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context795 = new ConstructorContext(EulerStepInterpolator.class, 71, 2409, 2692);
        try {
        } finally {
            _bcornu_methode_context795.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context3497 = new MethodContext(StepInterpolator.class, 77, 2697, 2816);
        try {
            CallChecker.varInit(this, "this", 77, 2697, 2816);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 77, 2697, 2816);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 77, 2697, 2816);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 77, 2697, 2816);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 77, 2697, 2816);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 77, 2697, 2816);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 77, 2697, 2816);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 77, 2697, 2816);
            CallChecker.varInit(this.currentState, "currentState", 77, 2697, 2816);
            CallChecker.varInit(this.h, "h", 77, 2697, 2816);
            CallChecker.varInit(this.integrator, "integrator", 77, 2697, 2816);
            CallChecker.varInit(this.yDotK, "yDotK", 77, 2697, 2816);
            CallChecker.varInit(this.previousState, "previousState", 77, 2697, 2816);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.EulerStepInterpolator.serialVersionUID", 77, 2697, 2816);
            return new EulerStepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3497.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context3498 = new MethodContext(void.class, 84, 2822, 3603);
        try {
            CallChecker.varInit(this, "this", 84, 2822, 3603);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 84, 2822, 3603);
            CallChecker.varInit(theta, "theta", 84, 2822, 3603);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 84, 2822, 3603);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 84, 2822, 3603);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 84, 2822, 3603);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 84, 2822, 3603);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 84, 2822, 3603);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 84, 2822, 3603);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 84, 2822, 3603);
            CallChecker.varInit(this.currentState, "currentState", 84, 2822, 3603);
            CallChecker.varInit(this.h, "h", 84, 2822, 3603);
            CallChecker.varInit(this.integrator, "integrator", 84, 2822, 3603);
            CallChecker.varInit(this.yDotK, "yDotK", 84, 2822, 3603);
            CallChecker.varInit(this.previousState, "previousState", 84, 2822, 3603);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.EulerStepInterpolator.serialVersionUID", 84, 2822, 3603);
            if (((previousState) != null) && (theta <= 0.5)) {
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 87, 3089, 3105);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 87, 3089, 3105).length); ++i) {
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 88, 3136, 3152)) {
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 88, 3190, 3194)) {
                            yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 88, 3190, 3194);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 88, 3190, 3194)[0], double[].class, 88, 3190, 3197)) {
                                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 88, 3136, 3152);
                                yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 88, 3190, 3194);
                                CallChecker.isCalled(yDotK, double[][].class, 88, 3190, 3194)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 88, 3190, 3194)[0], double[].class, 88, 3190, 3197);
                                CallChecker.isCalled(interpolatedState, double[].class, 88, 3136, 3152)[i] = (previousState[i]) + ((theta * (h)) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 88, 3190, 3194)[0], double[].class, 88, 3190, 3197)[i]));
                                CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 88, 3136, 3152)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 88, 3136, 3152)[i]", 88, 3136, 3201);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(yDotK, double[][].class, 90, 3242, 3246)) {
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 90, 3283, 3305)) {
                        yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 90, 3242, 3246);
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 90, 3283, 3305);
                        System.arraycopy(CallChecker.isCalled(yDotK, double[][].class, 90, 3242, 3246)[0], 0, interpolatedDerivatives, 0, CallChecker.isCalled(interpolatedDerivatives, double[].class, 90, 3283, 3305).length);
                    }
                }
            }else {
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 92, 3361, 3377);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 92, 3361, 3377).length); ++i) {
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 93, 3408, 3424)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 93, 3431, 3442)) {
                            if (CallChecker.beforeDeref(yDotK, double[][].class, 93, 3466, 3470)) {
                                yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 93, 3466, 3470);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 93, 3466, 3470)[0], double[].class, 93, 3466, 3473)) {
                                    interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 93, 3408, 3424);
                                    currentState = CallChecker.beforeCalled(currentState, double[].class, 93, 3431, 3442);
                                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 93, 3466, 3470);
                                    CallChecker.isCalled(yDotK, double[][].class, 93, 3466, 3470)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 93, 3466, 3470)[0], double[].class, 93, 3466, 3473);
                                    CallChecker.isCalled(interpolatedState, double[].class, 93, 3408, 3424)[i] = (CallChecker.isCalled(currentState, double[].class, 93, 3431, 3442)[i]) - (oneMinusThetaH * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 93, 3466, 3470)[0], double[].class, 93, 3466, 3473)[i]));
                                    CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 93, 3408, 3424)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 93, 3408, 3424)[i]", 93, 3408, 3477);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(yDotK, double[][].class, 95, 3518, 3522)) {
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 95, 3559, 3581)) {
                        yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 95, 3518, 3522);
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 95, 3559, 3581);
                        System.arraycopy(CallChecker.isCalled(yDotK, double[][].class, 95, 3518, 3522)[0], 0, interpolatedDerivatives, 0, CallChecker.isCalled(interpolatedDerivatives, double[].class, 95, 3559, 3581).length);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3498.methodEnd();
        }
    }
}

