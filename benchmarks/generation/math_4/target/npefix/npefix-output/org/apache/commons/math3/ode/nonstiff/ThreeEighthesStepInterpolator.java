package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

class ThreeEighthesStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120L;

    public ThreeEighthesStepInterpolator() {
        ConstructorContext _bcornu_methode_context239 = new ConstructorContext(ThreeEighthesStepInterpolator.class, 75, 2753, 3372);
        try {
        } finally {
            _bcornu_methode_context239.methodEnd();
        }
    }

    public ThreeEighthesStepInterpolator(final ThreeEighthesStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context240 = new ConstructorContext(ThreeEighthesStepInterpolator.class, 83, 3377, 3676);
        try {
        } finally {
            _bcornu_methode_context240.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context977 = new MethodContext(StepInterpolator.class, 89, 3681, 3808);
        try {
            CallChecker.varInit(this, "this", 89, 3681, 3808);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 89, 3681, 3808);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 89, 3681, 3808);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 89, 3681, 3808);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 89, 3681, 3808);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 89, 3681, 3808);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 89, 3681, 3808);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 89, 3681, 3808);
            CallChecker.varInit(this.currentState, "currentState", 89, 3681, 3808);
            CallChecker.varInit(this.h, "h", 89, 3681, 3808);
            CallChecker.varInit(this.integrator, "integrator", 89, 3681, 3808);
            CallChecker.varInit(this.yDotK, "yDotK", 89, 3681, 3808);
            CallChecker.varInit(this.previousState, "previousState", 89, 3681, 3808);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.ThreeEighthesStepInterpolator.serialVersionUID", 89, 3681, 3808);
            return new ThreeEighthesStepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context977.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context978 = new MethodContext(void.class, 96, 3814, 6176);
        try {
            CallChecker.varInit(this, "this", 96, 3814, 6176);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 96, 3814, 6176);
            CallChecker.varInit(theta, "theta", 96, 3814, 6176);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 96, 3814, 6176);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 96, 3814, 6176);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 96, 3814, 6176);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 96, 3814, 6176);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 96, 3814, 6176);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 96, 3814, 6176);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 96, 3814, 6176);
            CallChecker.varInit(this.currentState, "currentState", 96, 3814, 6176);
            CallChecker.varInit(this.h, "h", 96, 3814, 6176);
            CallChecker.varInit(this.integrator, "integrator", 96, 3814, 6176);
            CallChecker.varInit(this.yDotK, "yDotK", 96, 3814, 6176);
            CallChecker.varInit(this.previousState, "previousState", 96, 3814, 6176);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.ThreeEighthesStepInterpolator.serialVersionUID", 96, 3814, 6176);
            final double coeffDot3 = CallChecker.varInit(((double) (0.75 * theta)), "coeffDot3", 99, 4003, 4041);
            final double coeffDot1 = CallChecker.varInit(((double) ((coeffDot3 * ((4 * theta) - 5)) + 1)), "coeffDot1", 100, 4049, 4106);
            final double coeffDot2 = CallChecker.varInit(((double) (coeffDot3 * (5 - (6 * theta)))), "coeffDot2", 101, 4114, 4167);
            final double coeffDot4 = CallChecker.varInit(((double) (coeffDot3 * ((2 * theta) - 1))), "coeffDot4", 102, 4175, 4228);
            if (((previousState) != null) && (theta <= 0.5)) {
                final double s = CallChecker.varInit(((double) ((theta * (this.h)) / 8.0)), "s", 105, 4296, 4337);
                final double fourTheta2 = CallChecker.varInit(((double) ((4 * theta) * theta)), "fourTheta2", 106, 4349, 4392);
                final double coeff1 = CallChecker.varInit(((double) (s * ((8 - (15 * theta)) + (2 * fourTheta2)))), "coeff1", 107, 4404, 4467);
                final double coeff2 = CallChecker.varInit(((double) ((3 * s) * ((5 * theta) - fourTheta2))), "coeff2", 108, 4479, 4537);
                final double coeff3 = CallChecker.varInit(((double) ((3 * s) * theta)), "coeff3", 109, 4549, 4588);
                final double coeff4 = CallChecker.varInit(((double) (s * (((-3) * theta) + fourTheta2))), "coeff4", 110, 4600, 4655);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 111, 4687, 4703);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 111, 4687, 4703).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 112, 4755, 4759);
                    CallChecker.isCalled(yDotK, double[][].class, 112, 4755, 4759)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 112, 4755, 4759)[0], double[].class, 112, 4755, 4762);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 112, 4755, 4759)[0], double[].class, 112, 4755, 4762)[i])), "yDot1", 112, 4734, 4766);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 113, 4803, 4807);
                    CallChecker.isCalled(yDotK, double[][].class, 113, 4803, 4807)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 113, 4803, 4807)[1], double[].class, 113, 4803, 4810);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 113, 4803, 4807)[1], double[].class, 113, 4803, 4810)[i])), "yDot2", 113, 4782, 4814);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 114, 4851, 4855);
                    CallChecker.isCalled(yDotK, double[][].class, 114, 4851, 4855)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 114, 4851, 4855)[2], double[].class, 114, 4851, 4858);
                    final double yDot3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 114, 4851, 4855)[2], double[].class, 114, 4851, 4858)[i])), "yDot3", 114, 4830, 4862);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 115, 4899, 4903);
                    CallChecker.isCalled(yDotK, double[][].class, 115, 4899, 4903)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 115, 4899, 4903)[3], double[].class, 115, 4899, 4906);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 115, 4899, 4903)[3], double[].class, 115, 4899, 4906)[i])), "yDot4", 115, 4878, 4910);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 116, 4926, 4942)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 116, 4926, 4942);
                        CallChecker.isCalled(interpolatedState, double[].class, 116, 4926, 4942)[i] = ((((previousState[i]) + (coeff1 * yDot1)) + (coeff2 * yDot2)) + (coeff3 * yDot3)) + (coeff4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 116, 4926, 4942)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 116, 4926, 4942)[i]", 116, 4926, 5055);
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 118, 5071, 5093)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 118, 5071, 5093);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 118, 5071, 5093)[i] = (((coeffDot1 * yDot1) + (coeffDot2 * yDot2)) + (coeffDot3 * yDot3)) + (coeffDot4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 118, 5071, 5093)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 118, 5071, 5093)[i]", 118, 5071, 5199);
                    }
                }
            }else {
                final double s = CallChecker.varInit(((double) (oneMinusThetaH / 8.0)), "s", 123, 5239, 5285);
                final double fourTheta2 = CallChecker.varInit(((double) ((4 * theta) * theta)), "fourTheta2", 124, 5297, 5340);
                final double coeff1 = CallChecker.varInit(((double) (s * ((1 - (7 * theta)) + (2 * fourTheta2)))), "coeff1", 125, 5352, 5414);
                final double coeff2 = CallChecker.varInit(((double) ((3 * s) * ((1 + theta) - fourTheta2))), "coeff2", 126, 5426, 5484);
                final double coeff3 = CallChecker.varInit(((double) ((3 * s) * (1 + theta))), "coeff3", 127, 5496, 5541);
                final double coeff4 = CallChecker.varInit(((double) (s * ((1 + theta) + fourTheta2))), "coeff4", 128, 5553, 5607);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 129, 5639, 5655);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 129, 5639, 5655).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 130, 5707, 5711);
                    CallChecker.isCalled(yDotK, double[][].class, 130, 5707, 5711)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 130, 5707, 5711)[0], double[].class, 130, 5707, 5714);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 130, 5707, 5711)[0], double[].class, 130, 5707, 5714)[i])), "yDot1", 130, 5686, 5718);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 131, 5755, 5759);
                    CallChecker.isCalled(yDotK, double[][].class, 131, 5755, 5759)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 131, 5755, 5759)[1], double[].class, 131, 5755, 5762);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 131, 5755, 5759)[1], double[].class, 131, 5755, 5762)[i])), "yDot2", 131, 5734, 5766);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 132, 5803, 5807);
                    CallChecker.isCalled(yDotK, double[][].class, 132, 5803, 5807)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 132, 5803, 5807)[2], double[].class, 132, 5803, 5810);
                    final double yDot3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 132, 5803, 5807)[2], double[].class, 132, 5803, 5810)[i])), "yDot3", 132, 5782, 5814);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 133, 5851, 5855);
                    CallChecker.isCalled(yDotK, double[][].class, 133, 5851, 5855)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 133, 5851, 5855)[3], double[].class, 133, 5851, 5858);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 133, 5851, 5855)[3], double[].class, 133, 5851, 5858)[i])), "yDot4", 133, 5830, 5862);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 134, 5878, 5894)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 135, 5923, 5934)) {
                            interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 134, 5878, 5894);
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 135, 5923, 5934);
                            CallChecker.isCalled(interpolatedState, double[].class, 134, 5878, 5894)[i] = ((((CallChecker.isCalled(currentState, double[].class, 135, 5923, 5934)[i]) - (coeff1 * yDot1)) - (coeff2 * yDot2)) - (coeff3 * yDot3)) - (coeff4 * yDot4);
                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 134, 5878, 5894)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 134, 5878, 5894)[i]", 134, 5878, 6006);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 136, 6022, 6044)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 136, 6022, 6044);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 136, 6022, 6044)[i] = (((coeffDot1 * yDot1) + (coeffDot2 * yDot2)) + (coeffDot3 * yDot3)) + (coeffDot4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 136, 6022, 6044)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 136, 6022, 6044)[i]", 136, 6022, 6150);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context978.methodEnd();
        }
    }
}

