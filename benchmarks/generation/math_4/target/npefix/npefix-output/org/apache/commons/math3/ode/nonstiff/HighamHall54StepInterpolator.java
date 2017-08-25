package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

class HighamHall54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120L;

    public HighamHall54StepInterpolator() {
        super();
        ConstructorContext _bcornu_methode_context370 = new ConstructorContext(HighamHall54StepInterpolator.class, 49, 1300, 1933);
        try {
        } finally {
            _bcornu_methode_context370.methodEnd();
        }
    }

    public HighamHall54StepInterpolator(final HighamHall54StepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context371 = new ConstructorContext(HighamHall54StepInterpolator.class, 58, 1938, 2235);
        try {
        } finally {
            _bcornu_methode_context371.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context1625 = new MethodContext(StepInterpolator.class, 64, 2240, 2366);
        try {
            CallChecker.varInit(this, "this", 64, 2240, 2366);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 64, 2240, 2366);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 64, 2240, 2366);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 64, 2240, 2366);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 64, 2240, 2366);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 64, 2240, 2366);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 64, 2240, 2366);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 64, 2240, 2366);
            CallChecker.varInit(this.currentState, "currentState", 64, 2240, 2366);
            CallChecker.varInit(this.h, "h", 64, 2240, 2366);
            CallChecker.varInit(this.integrator, "integrator", 64, 2240, 2366);
            CallChecker.varInit(this.yDotK, "yDotK", 64, 2240, 2366);
            CallChecker.varInit(this.previousState, "previousState", 64, 2240, 2366);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.HighamHall54StepInterpolator.serialVersionUID", 64, 2240, 2366);
            return new HighamHall54StepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1625.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context1626 = new MethodContext(void.class, 71, 2372, 5311);
        try {
            CallChecker.varInit(this, "this", 71, 2372, 5311);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 71, 2372, 5311);
            CallChecker.varInit(theta, "theta", 71, 2372, 5311);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 71, 2372, 5311);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 71, 2372, 5311);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 71, 2372, 5311);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 71, 2372, 5311);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 71, 2372, 5311);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 71, 2372, 5311);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 71, 2372, 5311);
            CallChecker.varInit(this.currentState, "currentState", 71, 2372, 5311);
            CallChecker.varInit(this.h, "h", 71, 2372, 5311);
            CallChecker.varInit(this.integrator, "integrator", 71, 2372, 5311);
            CallChecker.varInit(this.yDotK, "yDotK", 71, 2372, 5311);
            CallChecker.varInit(this.previousState, "previousState", 71, 2372, 5311);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.HighamHall54StepInterpolator.serialVersionUID", 71, 2372, 5311);
            final double bDot0 = CallChecker.varInit(((double) (1 + (theta * (((-15.0) / 2.0) + (theta * (16.0 - (10.0 * theta))))))), "bDot0", 74, 2559, 2635);
            final double bDot2 = CallChecker.varInit(((double) (theta * ((459.0 / 16.0) + (theta * (((-729.0) / 8.0) + ((135.0 / 2.0) * theta)))))), "bDot2", 75, 2641, 2725);
            final double bDot3 = CallChecker.varInit(((double) (theta * ((-44.0) + (theta * (152.0 - (120.0 * theta)))))), "bDot3", 76, 2731, 2801);
            final double bDot4 = CallChecker.varInit(((double) (theta * ((375.0 / 16.0) + (theta * (((-625.0) / 8.0) + ((125.0 / 2.0) * theta)))))), "bDot4", 77, 2807, 2891);
            final double bDot5 = CallChecker.varInit(((double) (((theta * 5.0) / 8.0) * ((2 * theta) - 1))), "bDot5", 78, 2897, 2951);
            if (((previousState) != null) && (theta <= 0.5)) {
                final double hTheta = CallChecker.varInit(((double) ((this.h) * theta)), "hTheta", 81, 3015, 3046);
                final double b0 = CallChecker.varInit(((double) (hTheta * (1.0 + (theta * (((-15.0) / 4.0) + (theta * ((16.0 / 3.0) - ((5.0 / 2.0) * theta)))))))), "b0", 82, 3056, 3150);
                final double b2 = CallChecker.varInit(((double) (hTheta * (theta * ((459.0 / 32.0) + (theta * (((-243.0) / 8.0) + ((theta * 135.0) / 8.0))))))), "b2", 83, 3160, 3258);
                final double b3 = CallChecker.varInit(((double) (hTheta * (theta * ((-22.0) + (theta * ((152.0 / 3.0) + (theta * (-30.0)))))))), "b3", 84, 3268, 3362);
                final double b4 = CallChecker.varInit(((double) (hTheta * (theta * ((375.0 / 32.0) + (theta * (((-625.0) / 24.0) + ((theta * 125.0) / 8.0))))))), "b4", 85, 3372, 3471);
                final double b5 = CallChecker.varInit(((double) (hTheta * (theta * (((-5.0) / 16.0) + ((theta * 5.0) / 12.0))))), "b5", 86, 3481, 3556);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 87, 3586, 3602);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 87, 3586, 3602).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 88, 3652, 3656);
                    CallChecker.isCalled(yDotK, double[][].class, 88, 3652, 3656)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 88, 3652, 3656)[0], double[].class, 88, 3652, 3659);
                    final double yDot0 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 88, 3652, 3656)[0], double[].class, 88, 3652, 3659)[i])), "yDot0", 88, 3631, 3663);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 89, 3698, 3702);
                    CallChecker.isCalled(yDotK, double[][].class, 89, 3698, 3702)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 89, 3698, 3702)[2], double[].class, 89, 3698, 3705);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 89, 3698, 3702)[2], double[].class, 89, 3698, 3705)[i])), "yDot2", 89, 3677, 3709);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 90, 3744, 3748);
                    CallChecker.isCalled(yDotK, double[][].class, 90, 3744, 3748)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 90, 3744, 3748)[3], double[].class, 90, 3744, 3751);
                    final double yDot3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 90, 3744, 3748)[3], double[].class, 90, 3744, 3751)[i])), "yDot3", 90, 3723, 3755);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 91, 3790, 3794);
                    CallChecker.isCalled(yDotK, double[][].class, 91, 3790, 3794)[4] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 91, 3790, 3794)[4], double[].class, 91, 3790, 3797);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 91, 3790, 3794)[4], double[].class, 91, 3790, 3797)[i])), "yDot4", 91, 3769, 3801);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 92, 3836, 3840);
                    CallChecker.isCalled(yDotK, double[][].class, 92, 3836, 3840)[5] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 92, 3836, 3840)[5], double[].class, 92, 3836, 3843);
                    final double yDot5 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 92, 3836, 3840)[5], double[].class, 92, 3836, 3843)[i])), "yDot5", 92, 3815, 3847);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 93, 3861, 3877)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 93, 3861, 3877);
                        CallChecker.isCalled(interpolatedState, double[].class, 93, 3861, 3877)[i] = (((((previousState[i]) + (b0 * yDot0)) + (b2 * yDot2)) + (b3 * yDot3)) + (b4 * yDot4)) + (b5 * yDot5);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 93, 3861, 3877)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 93, 3861, 3877)[i]", 93, 3861, 3985);
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 95, 3999, 4021)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 95, 3999, 4021);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 95, 3999, 4021)[i] = ((((bDot0 * yDot0) + (bDot2 * yDot2)) + (bDot3 * yDot3)) + (bDot4 * yDot4)) + (bDot5 * yDot5);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 95, 3999, 4021)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 95, 3999, 4021)[i]", 95, 3999, 4125);
                    }
                }
            }else {
                final double theta2 = CallChecker.varInit(((double) (theta * theta)), "theta2", 99, 4158, 4193);
                final double b0 = CallChecker.varInit(((double) ((this.h) * (((-1.0) / 12.0) + (theta * (1.0 + (theta * (((-15.0) / 4.0) + (theta * ((16.0 / 3.0) + ((theta * (-5.0)) / 2.0)))))))))), "b0", 100, 4203, 4314);
                final double b2 = CallChecker.varInit(((double) ((this.h) * (((-27.0) / 32.0) + (theta2 * ((459.0 / 32.0) + (theta * (((-243.0) / 8.0) + ((theta * 135.0) / 8.0)))))))), "b2", 101, 4324, 4425);
                final double b3 = CallChecker.varInit(((double) ((this.h) * ((4.0 / 3.0) + (theta2 * ((-22.0) + (theta * ((152.0 / 3.0) + (theta * (-30.0))))))))), "b3", 102, 4435, 4524);
                final double b4 = CallChecker.varInit(((double) ((this.h) * (((-125.0) / 96.0) + (theta2 * ((375.0 / 32.0) + (theta * (((-625.0) / 24.0) + ((theta * 125.0) / 8.0)))))))), "b4", 103, 4534, 4637);
                final double b5 = CallChecker.varInit(((double) ((this.h) * (((-5.0) / 48.0) + (theta2 * (((-5.0) / 16.0) + ((theta * 5.0) / 12.0)))))), "b5", 104, 4647, 4722);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 105, 4752, 4768);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 105, 4752, 4768).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 106, 4818, 4822);
                    CallChecker.isCalled(yDotK, double[][].class, 106, 4818, 4822)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 106, 4818, 4822)[0], double[].class, 106, 4818, 4825);
                    final double yDot0 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 106, 4818, 4822)[0], double[].class, 106, 4818, 4825)[i])), "yDot0", 106, 4797, 4829);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 107, 4864, 4868);
                    CallChecker.isCalled(yDotK, double[][].class, 107, 4864, 4868)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 107, 4864, 4868)[2], double[].class, 107, 4864, 4871);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 107, 4864, 4868)[2], double[].class, 107, 4864, 4871)[i])), "yDot2", 107, 4843, 4875);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 108, 4910, 4914);
                    CallChecker.isCalled(yDotK, double[][].class, 108, 4910, 4914)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 108, 4910, 4914)[3], double[].class, 108, 4910, 4917);
                    final double yDot3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 108, 4910, 4914)[3], double[].class, 108, 4910, 4917)[i])), "yDot3", 108, 4889, 4921);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 109, 4956, 4960);
                    CallChecker.isCalled(yDotK, double[][].class, 109, 4956, 4960)[4] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 109, 4956, 4960)[4], double[].class, 109, 4956, 4963);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 109, 4956, 4960)[4], double[].class, 109, 4956, 4963)[i])), "yDot4", 109, 4935, 4967);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 110, 5002, 5006);
                    CallChecker.isCalled(yDotK, double[][].class, 110, 5002, 5006)[5] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 110, 5002, 5006)[5], double[].class, 110, 5002, 5009);
                    final double yDot5 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 110, 5002, 5006)[5], double[].class, 110, 5002, 5009)[i])), "yDot5", 110, 4981, 5013);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 111, 5027, 5043)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 112, 5070, 5081)) {
                            interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 111, 5027, 5043);
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 112, 5070, 5081);
                            CallChecker.isCalled(interpolatedState, double[].class, 111, 5027, 5043)[i] = (((((CallChecker.isCalled(currentState, double[].class, 112, 5070, 5081)[i]) + (b0 * yDot0)) + (b2 * yDot2)) + (b3 * yDot3)) + (b4 * yDot4)) + (b5 * yDot5);
                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 111, 5027, 5043)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 111, 5027, 5043)[i]", 111, 5027, 5150);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 113, 5164, 5186)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 113, 5164, 5186);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 113, 5164, 5186)[i] = ((((bDot0 * yDot0) + (bDot2 * yDot2)) + (bDot3 * yDot3)) + (bDot4 * yDot4)) + (bDot5 * yDot5);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 113, 5164, 5186)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 113, 5164, 5186)[i]", 113, 5164, 5290);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1626.methodEnd();
        }
    }
}

