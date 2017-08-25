package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

class GillStepInterpolator extends RungeKuttaStepInterpolator {
    private static final double ONE_MINUS_INV_SQRT_2 = 1 - (FastMath.sqrt(0.5));

    private static final double ONE_PLUS_INV_SQRT_2 = 1 + (FastMath.sqrt(0.5));

    private static final long serialVersionUID = 20111120L;

    public GillStepInterpolator() {
        ConstructorContext _bcornu_methode_context155 = new ConstructorContext(GillStepInterpolator.class, 79, 2897, 3507);
        try {
        } finally {
            _bcornu_methode_context155.methodEnd();
        }
    }

    public GillStepInterpolator(final GillStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context156 = new ConstructorContext(GillStepInterpolator.class, 87, 3512, 3793);
        try {
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context570 = new MethodContext(StepInterpolator.class, 93, 3798, 3916);
        try {
            CallChecker.varInit(this, "this", 93, 3798, 3916);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 93, 3798, 3916);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 93, 3798, 3916);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 93, 3798, 3916);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 93, 3798, 3916);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 93, 3798, 3916);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 93, 3798, 3916);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 93, 3798, 3916);
            CallChecker.varInit(this.currentState, "currentState", 93, 3798, 3916);
            CallChecker.varInit(this.h, "h", 93, 3798, 3916);
            CallChecker.varInit(this.integrator, "integrator", 93, 3798, 3916);
            CallChecker.varInit(this.yDotK, "yDotK", 93, 3798, 3916);
            CallChecker.varInit(this.previousState, "previousState", 93, 3798, 3916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GillStepInterpolator.serialVersionUID", 93, 3798, 3916);
            CallChecker.varInit(ONE_PLUS_INV_SQRT_2, "org.apache.commons.math3.ode.nonstiff.GillStepInterpolator.ONE_PLUS_INV_SQRT_2", 93, 3798, 3916);
            CallChecker.varInit(ONE_MINUS_INV_SQRT_2, "org.apache.commons.math3.ode.nonstiff.GillStepInterpolator.ONE_MINUS_INV_SQRT_2", 93, 3798, 3916);
            return new GillStepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context570.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context571 = new MethodContext(void.class, 100, 3922, 6356);
        try {
            CallChecker.varInit(this, "this", 100, 3922, 6356);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 100, 3922, 6356);
            CallChecker.varInit(theta, "theta", 100, 3922, 6356);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 100, 3922, 6356);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 100, 3922, 6356);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 100, 3922, 6356);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 100, 3922, 6356);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 100, 3922, 6356);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 100, 3922, 6356);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 100, 3922, 6356);
            CallChecker.varInit(this.currentState, "currentState", 100, 3922, 6356);
            CallChecker.varInit(this.h, "h", 100, 3922, 6356);
            CallChecker.varInit(this.integrator, "integrator", 100, 3922, 6356);
            CallChecker.varInit(this.yDotK, "yDotK", 100, 3922, 6356);
            CallChecker.varInit(this.previousState, "previousState", 100, 3922, 6356);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GillStepInterpolator.serialVersionUID", 100, 3922, 6356);
            CallChecker.varInit(ONE_PLUS_INV_SQRT_2, "org.apache.commons.math3.ode.nonstiff.GillStepInterpolator.ONE_PLUS_INV_SQRT_2", 100, 3922, 6356);
            CallChecker.varInit(ONE_MINUS_INV_SQRT_2, "org.apache.commons.math3.ode.nonstiff.GillStepInterpolator.ONE_MINUS_INV_SQRT_2", 100, 3922, 6356);
            final double twoTheta = CallChecker.varInit(((double) (2 * theta)), "twoTheta", 103, 4109, 4144);
            final double fourTheta2 = CallChecker.varInit(((double) (twoTheta * twoTheta)), "fourTheta2", 104, 4150, 4195);
            final double coeffDot1 = CallChecker.varInit(((double) ((theta * (twoTheta - 3)) + 1)), "coeffDot1", 105, 4201, 4253);
            final double cDot23 = CallChecker.varInit(((double) (twoTheta * (1 - theta))), "cDot23", 106, 4259, 4307);
            final double coeffDot2 = CallChecker.varInit(((double) (cDot23 * (GillStepInterpolator.ONE_MINUS_INV_SQRT_2))), "coeffDot2", 107, 4313, 4369);
            final double coeffDot3 = CallChecker.varInit(((double) (cDot23 * (GillStepInterpolator.ONE_PLUS_INV_SQRT_2))), "coeffDot3", 108, 4375, 4430);
            final double coeffDot4 = CallChecker.varInit(((double) (theta * (twoTheta - 1))), "coeffDot4", 109, 4436, 4484);
            if (((previousState) != null) && (theta <= 0.5)) {
                final double s = CallChecker.varInit(((double) ((theta * (this.h)) / 6.0)), "s", 112, 4548, 4588);
                final double c23 = CallChecker.varInit(((double) (s * ((6 * theta) - fourTheta2))), "c23", 113, 4598, 4651);
                final double coeff1 = CallChecker.varInit(((double) (s * ((6 - (9 * theta)) + fourTheta2))), "coeff1", 114, 4661, 4718);
                final double coeff2 = CallChecker.varInit(((double) (c23 * (GillStepInterpolator.ONE_MINUS_INV_SQRT_2))), "coeff2", 115, 4728, 4780);
                final double coeff3 = CallChecker.varInit(((double) (c23 * (GillStepInterpolator.ONE_PLUS_INV_SQRT_2))), "coeff3", 116, 4790, 4841);
                final double coeff4 = CallChecker.varInit(((double) (s * (((-3) * theta) + fourTheta2))), "coeff4", 117, 4851, 4905);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 118, 4935, 4951);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 118, 4935, 4951).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 119, 5001, 5005);
                    CallChecker.isCalled(yDotK, double[][].class, 119, 5001, 5005)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 119, 5001, 5005)[0], double[].class, 119, 5001, 5008);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 119, 5001, 5005)[0], double[].class, 119, 5001, 5008)[i])), "yDot1", 119, 4980, 5012);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 120, 5047, 5051);
                    CallChecker.isCalled(yDotK, double[][].class, 120, 5047, 5051)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 120, 5047, 5051)[1], double[].class, 120, 5047, 5054);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 120, 5047, 5051)[1], double[].class, 120, 5047, 5054)[i])), "yDot2", 120, 5026, 5058);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 121, 5093, 5097);
                    CallChecker.isCalled(yDotK, double[][].class, 121, 5093, 5097)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 121, 5093, 5097)[2], double[].class, 121, 5093, 5100);
                    final double yDot3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 121, 5093, 5097)[2], double[].class, 121, 5093, 5100)[i])), "yDot3", 121, 5072, 5104);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 122, 5139, 5143);
                    CallChecker.isCalled(yDotK, double[][].class, 122, 5139, 5143)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 122, 5139, 5143)[3], double[].class, 122, 5139, 5146);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 122, 5139, 5143)[3], double[].class, 122, 5139, 5146)[i])), "yDot4", 122, 5118, 5150);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 123, 5164, 5180)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 123, 5164, 5180);
                        CallChecker.isCalled(interpolatedState, double[].class, 123, 5164, 5180)[i] = ((((previousState[i]) + (coeff1 * yDot1)) + (coeff2 * yDot2)) + (coeff3 * yDot3)) + (coeff4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 123, 5164, 5180)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 123, 5164, 5180)[i]", 123, 5164, 5291);
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 125, 5305, 5327)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 125, 5305, 5327);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 125, 5305, 5327)[i] = (((coeffDot1 * yDot1) + (coeffDot2 * yDot2)) + (coeffDot3 * yDot3)) + (coeffDot4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 125, 5305, 5327)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 125, 5305, 5327)[i]", 125, 5305, 5431);
                    }
                }
            }else {
                final double s = CallChecker.varInit(((double) (oneMinusThetaH / 6.0)), "s", 129, 5464, 5506);
                final double c23 = CallChecker.varInit(((double) (s * ((2 + twoTheta) - fourTheta2))), "c23", 130, 5516, 5569);
                final double coeff1 = CallChecker.varInit(((double) (s * ((1 - (5 * theta)) + fourTheta2))), "coeff1", 131, 5579, 5633);
                final double coeff2 = CallChecker.varInit(((double) (c23 * (GillStepInterpolator.ONE_MINUS_INV_SQRT_2))), "coeff2", 132, 5643, 5692);
                final double coeff3 = CallChecker.varInit(((double) (c23 * (GillStepInterpolator.ONE_PLUS_INV_SQRT_2))), "coeff3", 133, 5702, 5750);
                final double coeff4 = CallChecker.varInit(((double) (s * ((1 + theta) + fourTheta2))), "coeff4", 134, 5760, 5810);
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 135, 5840, 5856);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 135, 5840, 5856).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 136, 5906, 5910);
                    CallChecker.isCalled(yDotK, double[][].class, 136, 5906, 5910)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 136, 5906, 5910)[0], double[].class, 136, 5906, 5913);
                    final double yDot1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 136, 5906, 5910)[0], double[].class, 136, 5906, 5913)[i])), "yDot1", 136, 5885, 5917);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 137, 5952, 5956);
                    CallChecker.isCalled(yDotK, double[][].class, 137, 5952, 5956)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 137, 5952, 5956)[1], double[].class, 137, 5952, 5959);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 137, 5952, 5956)[1], double[].class, 137, 5952, 5959)[i])), "yDot2", 137, 5931, 5963);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 138, 5998, 6002);
                    CallChecker.isCalled(yDotK, double[][].class, 138, 5998, 6002)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 138, 5998, 6002)[2], double[].class, 138, 5998, 6005);
                    final double yDot3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 138, 5998, 6002)[2], double[].class, 138, 5998, 6005)[i])), "yDot3", 138, 5977, 6009);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 139, 6044, 6048);
                    CallChecker.isCalled(yDotK, double[][].class, 139, 6044, 6048)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 139, 6044, 6048)[3], double[].class, 139, 6044, 6051);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 139, 6044, 6048)[3], double[].class, 139, 6044, 6051)[i])), "yDot4", 139, 6023, 6055);
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 140, 6069, 6085)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 141, 6112, 6123)) {
                            interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 140, 6069, 6085);
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 141, 6112, 6123);
                            CallChecker.isCalled(interpolatedState, double[].class, 140, 6069, 6085)[i] = ((((CallChecker.isCalled(currentState, double[].class, 141, 6112, 6123)[i]) - (coeff1 * yDot1)) - (coeff2 * yDot2)) - (coeff3 * yDot3)) - (coeff4 * yDot4);
                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 140, 6069, 6085)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 140, 6069, 6085)[i]", 140, 6069, 6195);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 142, 6209, 6231)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 142, 6209, 6231);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 142, 6209, 6231)[i] = (((coeffDot1 * yDot1) + (coeffDot2 * yDot2)) + (coeffDot3 * yDot3)) + (coeffDot4 * yDot4);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 142, 6209, 6231)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 142, 6209, 6231)[i]", 142, 6209, 6335);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context571.methodEnd();
        }
    }
}

