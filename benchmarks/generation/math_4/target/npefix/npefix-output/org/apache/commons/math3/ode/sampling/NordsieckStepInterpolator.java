package org.apache.commons.math3.ode.sampling;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.util.FastMath;

public class NordsieckStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = -7179861704951334960L;

    protected double[] stateVariation;

    private double scalingH;

    private double referenceTime;

    private double[] scaled;

    private Array2DRowRealMatrix nordsieck;

    public NordsieckStepInterpolator() {
        ConstructorContext _bcornu_methode_context285 = new ConstructorContext(NordsieckStepInterpolator.class, 74, 2388, 2786);
        try {
        } finally {
            _bcornu_methode_context285.methodEnd();
        }
    }

    public NordsieckStepInterpolator(final NordsieckStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context286 = new ConstructorContext(NordsieckStepInterpolator.class, 82, 2793, 3578);
        try {
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 84, 3120, 3131)) {
                scalingH = CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 84, 3120, 3131).scalingH;
                CallChecker.varAssign(this.scalingH, "this.scalingH", 84, 3104, 3141);
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 85, 3167, 3178)) {
                referenceTime = CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 85, 3167, 3178).referenceTime;
                CallChecker.varAssign(this.referenceTime, "this.referenceTime", 85, 3151, 3193);
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 86, 3207, 3218)) {
                if ((CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 86, 3207, 3218).scaled) != null) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 87, 3259, 3270)) {
                        scaled = CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 87, 3259, 3270).scaled.clone();
                        CallChecker.varAssign(this.scaled, "this.scaled", 87, 3250, 3286);
                    }
                }
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 89, 3310, 3321)) {
                if ((CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 89, 3310, 3321).nordsieck) != null) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 90, 3393, 3404)) {
                        nordsieck = new Array2DRowRealMatrix(CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 90, 3393, 3404).nordsieck.getDataRef(), true);
                        CallChecker.varAssign(this.nordsieck, "this.nordsieck", 90, 3356, 3435);
                    }
                }
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 92, 3459, 3470)) {
                if ((CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 92, 3459, 3470).stateVariation) != null) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 93, 3527, 3538)) {
                        stateVariation = CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 93, 3527, 3538).stateVariation.clone();
                        CallChecker.varAssign(this.stateVariation, "this.stateVariation", 93, 3510, 3562);
                    }
                }
            }
        } finally {
            _bcornu_methode_context286.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context1300 = new MethodContext(StepInterpolator.class, 99, 3585, 3718);
        try {
            CallChecker.varInit(this, "this", 99, 3585, 3718);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 99, 3585, 3718);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 99, 3585, 3718);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 99, 3585, 3718);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 99, 3585, 3718);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 99, 3585, 3718);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 99, 3585, 3718);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 99, 3585, 3718);
            CallChecker.varInit(this.currentState, "currentState", 99, 3585, 3718);
            CallChecker.varInit(this.h, "h", 99, 3585, 3718);
            CallChecker.varInit(this.nordsieck, "nordsieck", 99, 3585, 3718);
            CallChecker.varInit(this.scaled, "scaled", 99, 3585, 3718);
            CallChecker.varInit(this.referenceTime, "referenceTime", 99, 3585, 3718);
            CallChecker.varInit(this.scalingH, "scalingH", 99, 3585, 3718);
            CallChecker.varInit(this.stateVariation, "stateVariation", 99, 3585, 3718);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 99, 3585, 3718);
            return new NordsieckStepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1300.methodEnd();
        }
    }

    @Override
    public void reinitialize(final double[] y, final boolean forward, final EquationsMapper primaryMapper, final EquationsMapper[] secondaryMappers) {
        MethodContext _bcornu_methode_context1301 = new MethodContext(void.class, 113, 3725, 4561);
        try {
            CallChecker.varInit(this, "this", 113, 3725, 4561);
            CallChecker.varInit(secondaryMappers, "secondaryMappers", 113, 3725, 4561);
            CallChecker.varInit(primaryMapper, "primaryMapper", 113, 3725, 4561);
            CallChecker.varInit(forward, "forward", 113, 3725, 4561);
            CallChecker.varInit(y, "y", 113, 3725, 4561);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 113, 3725, 4561);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 113, 3725, 4561);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 113, 3725, 4561);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 113, 3725, 4561);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 113, 3725, 4561);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 113, 3725, 4561);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 113, 3725, 4561);
            CallChecker.varInit(this.currentState, "currentState", 113, 3725, 4561);
            CallChecker.varInit(this.h, "h", 113, 3725, 4561);
            CallChecker.varInit(this.nordsieck, "nordsieck", 113, 3725, 4561);
            CallChecker.varInit(this.scaled, "scaled", 113, 3725, 4561);
            CallChecker.varInit(this.referenceTime, "referenceTime", 113, 3725, 4561);
            CallChecker.varInit(this.scalingH, "scalingH", 113, 3725, 4561);
            CallChecker.varInit(this.stateVariation, "stateVariation", 113, 3725, 4561);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 113, 3725, 4561);
            super.reinitialize(y, forward, primaryMapper, secondaryMappers);
            if (CallChecker.beforeDeref(y, double[].class, 117, 4546, 4546)) {
                stateVariation = new double[CallChecker.isCalled(y, double[].class, 117, 4546, 4546).length];
                CallChecker.varAssign(this.stateVariation, "this.stateVariation", 117, 4518, 4555);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1301.methodEnd();
        }
    }

    public void reinitialize(final double time, final double stepSize, final double[] scaledDerivative, final Array2DRowRealMatrix nordsieckVector) {
        MethodContext _bcornu_methode_context1302 = new MethodContext(void.class, 130, 4568, 5596);
        try {
            CallChecker.varInit(this, "this", 130, 4568, 5596);
            CallChecker.varInit(nordsieckVector, "nordsieckVector", 130, 4568, 5596);
            CallChecker.varInit(scaledDerivative, "scaledDerivative", 130, 4568, 5596);
            CallChecker.varInit(stepSize, "stepSize", 130, 4568, 5596);
            CallChecker.varInit(time, "time", 130, 4568, 5596);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 130, 4568, 5596);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 130, 4568, 5596);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 130, 4568, 5596);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 130, 4568, 5596);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 130, 4568, 5596);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 130, 4568, 5596);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 130, 4568, 5596);
            CallChecker.varInit(this.currentState, "currentState", 130, 4568, 5596);
            CallChecker.varInit(this.h, "h", 130, 4568, 5596);
            CallChecker.varInit(this.nordsieck, "nordsieck", 130, 4568, 5596);
            CallChecker.varInit(this.scaled, "scaled", 130, 4568, 5596);
            CallChecker.varInit(this.referenceTime, "referenceTime", 130, 4568, 5596);
            CallChecker.varInit(this.scalingH, "scalingH", 130, 4568, 5596);
            CallChecker.varInit(this.stateVariation, "stateVariation", 130, 4568, 5596);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 130, 4568, 5596);
            this.referenceTime = time;
            CallChecker.varAssign(this.referenceTime, "this.referenceTime", 133, 5302, 5327);
            this.scalingH = stepSize;
            CallChecker.varAssign(this.scalingH, "this.scalingH", 134, 5337, 5366);
            this.scaled = scaledDerivative;
            CallChecker.varAssign(this.scaled, "this.scaled", 135, 5376, 5413);
            this.nordsieck = nordsieckVector;
            CallChecker.varAssign(this.nordsieck, "this.nordsieck", 136, 5423, 5459);
            setInterpolatedTime(getInterpolatedTime());
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1302.methodEnd();
        }
    }

    public void rescale(final double stepSize) {
        MethodContext _bcornu_methode_context1303 = new MethodContext(void.class, 148, 5603, 6431);
        try {
            CallChecker.varInit(this, "this", 148, 5603, 6431);
            CallChecker.varInit(stepSize, "stepSize", 148, 5603, 6431);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 148, 5603, 6431);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 148, 5603, 6431);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 148, 5603, 6431);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 148, 5603, 6431);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 148, 5603, 6431);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 148, 5603, 6431);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 148, 5603, 6431);
            CallChecker.varInit(this.currentState, "currentState", 148, 5603, 6431);
            CallChecker.varInit(this.h, "h", 148, 5603, 6431);
            CallChecker.varInit(this.nordsieck, "nordsieck", 148, 5603, 6431);
            CallChecker.varInit(this.scaled, "scaled", 148, 5603, 6431);
            CallChecker.varInit(this.referenceTime, "referenceTime", 148, 5603, 6431);
            CallChecker.varInit(this.scalingH, "scalingH", 148, 5603, 6431);
            CallChecker.varInit(this.stateVariation, "stateVariation", 148, 5603, 6431);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 148, 5603, 6431);
            final double ratio = CallChecker.varInit(((double) (stepSize / (this.scalingH))), "ratio", 150, 5937, 5977);
            scaled = CallChecker.beforeCalled(scaled, double[].class, 151, 6007, 6012);
            for (int i = 0; i < (CallChecker.isCalled(scaled, double[].class, 151, 6007, 6012).length); ++i) {
                if (CallChecker.beforeDeref(scaled, double[].class, 152, 6041, 6046)) {
                    scaled = CallChecker.beforeCalled(scaled, double[].class, 152, 6041, 6046);
                    CallChecker.isCalled(scaled, double[].class, 152, 6041, 6046)[i] *= ratio;
                    CallChecker.varAssign(CallChecker.isCalled(this.scaled, double[].class, 152, 6041, 6046)[i], "CallChecker.isCalled(this.scaled, double[].class, 152, 6041, 6046)[i]", 152, 6041, 6059);
                }
            }
            nordsieck = CallChecker.beforeCalled(nordsieck, Array2DRowRealMatrix.class, 155, 6105, 6113);
            final double[][] nData = CallChecker.varInit(CallChecker.isCalled(nordsieck, Array2DRowRealMatrix.class, 155, 6105, 6113).getDataRef(), "nData", 155, 6080, 6127);
            double power = CallChecker.varInit(((double) (ratio)), "power", 156, 6137, 6157);
            for (int i = 0; i < (CallChecker.isCalled(nData, double[][].class, 157, 6187, 6191).length); ++i) {
                power *= ratio;
                CallChecker.varAssign(power, "power", 158, 6220, 6234);
                final double[] nDataI = CallChecker.varInit(CallChecker.isCalled(nData, double[][].class, 159, 6272, 6276)[i], "nDataI", 159, 6248, 6280);
                for (int j = 0; j < (CallChecker.isCalled(nDataI, double[].class, 160, 6314, 6319).length); ++j) {
                    if (CallChecker.beforeDeref(nDataI, double[].class, 161, 6352, 6357)) {
                        CallChecker.isCalled(nDataI, double[].class, 161, 6352, 6357)[j] *= power;
                        CallChecker.varAssign(CallChecker.isCalled(nDataI, double[].class, 161, 6352, 6357)[j], "CallChecker.isCalled(nDataI, double[].class, 161, 6352, 6357)[j]", 161, 6352, 6370);
                    }
                }
            }
            scalingH = stepSize;
            CallChecker.varAssign(this.scalingH, "this.scalingH", 165, 6405, 6424);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1303.methodEnd();
        }
    }

    public double[] getInterpolatedStateVariation() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context1304 = new MethodContext(double[].class, 181, 6438, 7408);
        try {
            CallChecker.varInit(this, "this", 181, 6438, 7408);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 181, 6438, 7408);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 181, 6438, 7408);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 181, 6438, 7408);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 181, 6438, 7408);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 181, 6438, 7408);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 181, 6438, 7408);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 181, 6438, 7408);
            CallChecker.varInit(this.currentState, "currentState", 181, 6438, 7408);
            CallChecker.varInit(this.h, "h", 181, 6438, 7408);
            CallChecker.varInit(this.nordsieck, "nordsieck", 181, 6438, 7408);
            CallChecker.varInit(this.scaled, "scaled", 181, 6438, 7408);
            CallChecker.varInit(this.referenceTime, "referenceTime", 181, 6438, 7408);
            CallChecker.varInit(this.scalingH, "scalingH", 181, 6438, 7408);
            CallChecker.varInit(this.stateVariation, "stateVariation", 181, 6438, 7408);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 181, 6438, 7408);
            getInterpolatedState();
            return stateVariation;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1304.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context1305 = new MethodContext(void.class, 190, 7415, 8715);
        try {
            CallChecker.varInit(this, "this", 190, 7415, 8715);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 190, 7415, 8715);
            CallChecker.varInit(theta, "theta", 190, 7415, 8715);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 190, 7415, 8715);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 190, 7415, 8715);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 190, 7415, 8715);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 190, 7415, 8715);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 190, 7415, 8715);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 190, 7415, 8715);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 190, 7415, 8715);
            CallChecker.varInit(this.currentState, "currentState", 190, 7415, 8715);
            CallChecker.varInit(this.h, "h", 190, 7415, 8715);
            CallChecker.varInit(this.nordsieck, "nordsieck", 190, 7415, 8715);
            CallChecker.varInit(this.scaled, "scaled", 190, 7415, 8715);
            CallChecker.varInit(this.referenceTime, "referenceTime", 190, 7415, 8715);
            CallChecker.varInit(this.scalingH, "scalingH", 190, 7415, 8715);
            CallChecker.varInit(this.stateVariation, "stateVariation", 190, 7415, 8715);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 190, 7415, 8715);
            final double x = CallChecker.varInit(((double) ((this.interpolatedTime) - (this.referenceTime))), "x", 192, 7568, 7617);
            final double normalizedAbscissa = CallChecker.varInit(((double) (x / (this.scalingH))), "normalizedAbscissa", 193, 7627, 7673);
            Arrays.fill(stateVariation, 0.0);
            Arrays.fill(interpolatedDerivatives, 0.0);
            nordsieck = CallChecker.beforeCalled(nordsieck, Array2DRowRealMatrix.class, 200, 7911, 7919);
            final double[][] nData = CallChecker.varInit(CallChecker.isCalled(nordsieck, Array2DRowRealMatrix.class, 200, 7911, 7919).getDataRef(), "nData", 200, 7886, 7933);
            for (int i = (CallChecker.isCalled(nData, double[][].class, 201, 7956, 7960).length) - 1; i >= 0; --i) {
                final int order = CallChecker.varInit(((int) (i + 2)), "order", 202, 8001, 8024);
                final double[] nDataI = CallChecker.varInit(CallChecker.isCalled(nData, double[][].class, 203, 8062, 8066)[i], "nDataI", 203, 8038, 8070);
                final double power = CallChecker.varInit(((double) (FastMath.pow(normalizedAbscissa, order))), "power", 204, 8084, 8144);
                for (int j = 0; j < (CallChecker.isCalled(nDataI, double[].class, 205, 8178, 8183).length); ++j) {
                    final double d = CallChecker.varInit(((double) ((CallChecker.isCalled(nDataI, double[].class, 206, 8233, 8238)[j]) * power)), "d", 206, 8216, 8250);
                    if (CallChecker.beforeDeref(stateVariation, double[].class, 207, 8268, 8281)) {
                        stateVariation = CallChecker.beforeCalled(stateVariation, double[].class, 207, 8268, 8281);
                        CallChecker.isCalled(stateVariation, double[].class, 207, 8268, 8281)[j] += d;
                        CallChecker.varAssign(CallChecker.isCalled(this.stateVariation, double[].class, 207, 8268, 8281)[j], "CallChecker.isCalled(this.stateVariation, double[].class, 207, 8268, 8281)[j]", 207, 8268, 8299);
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 208, 8317, 8339)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 208, 8317, 8339);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 208, 8317, 8339)[j] += order * d;
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 208, 8317, 8339)[j], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 208, 8317, 8339)[j]", 208, 8317, 8356);
                    }
                }
            }
            currentState = CallChecker.beforeCalled(currentState, double[].class, 212, 8411, 8422);
            for (int j = 0; j < (CallChecker.isCalled(currentState, double[].class, 212, 8411, 8422).length); ++j) {
                if (CallChecker.beforeDeref(stateVariation, double[].class, 213, 8451, 8464)) {
                    if (CallChecker.beforeDeref(scaled, double[].class, 213, 8472, 8477)) {
                        stateVariation = CallChecker.beforeCalled(stateVariation, double[].class, 213, 8451, 8464);
                        scaled = CallChecker.beforeCalled(scaled, double[].class, 213, 8472, 8477);
                        CallChecker.isCalled(stateVariation, double[].class, 213, 8451, 8464)[j] += (CallChecker.isCalled(scaled, double[].class, 213, 8472, 8477)[j]) * normalizedAbscissa;
                        CallChecker.varAssign(CallChecker.isCalled(this.stateVariation, double[].class, 213, 8451, 8464)[j], "CallChecker.isCalled(this.stateVariation, double[].class, 213, 8451, 8464)[j]", 213, 8451, 8502);
                    }
                }
                if (CallChecker.beforeDeref(interpolatedState, double[].class, 214, 8516, 8532)) {
                    if (CallChecker.beforeDeref(currentState, double[].class, 214, 8539, 8550)) {
                        if (CallChecker.beforeDeref(stateVariation, double[].class, 214, 8557, 8570)) {
                            interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 214, 8516, 8532);
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 214, 8539, 8550);
                            stateVariation = CallChecker.beforeCalled(stateVariation, double[].class, 214, 8557, 8570);
                            CallChecker.isCalled(interpolatedState, double[].class, 214, 8516, 8532)[j] = (CallChecker.isCalled(currentState, double[].class, 214, 8539, 8550)[j]) + (CallChecker.isCalled(stateVariation, double[].class, 214, 8557, 8570)[j]);
                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 214, 8516, 8532)[j], "CallChecker.isCalled(this.interpolatedState, double[].class, 214, 8516, 8532)[j]", 214, 8516, 8574);
                        }
                    }
                }
                if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 215, 8588, 8610)) {
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 216, 8634, 8656)) {
                        if (CallChecker.beforeDeref(scaled, double[].class, 216, 8663, 8668)) {
                            interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 215, 8588, 8610);
                            interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 216, 8634, 8656);
                            scaled = CallChecker.beforeCalled(scaled, double[].class, 216, 8663, 8668);
                            CallChecker.isCalled(interpolatedDerivatives, double[].class, 215, 8588, 8610)[j] = ((CallChecker.isCalled(interpolatedDerivatives, double[].class, 216, 8634, 8656)[j]) + ((CallChecker.isCalled(scaled, double[].class, 216, 8663, 8668)[j]) * normalizedAbscissa)) / x;
                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 215, 8588, 8610)[j], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 215, 8588, 8610)[j]", 215, 8588, 8698);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1305.methodEnd();
        }
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        MethodContext _bcornu_methode_context1306 = new MethodContext(void.class, 223, 8722, 9578);
        try {
            CallChecker.varInit(this, "this", 223, 8722, 9578);
            CallChecker.varInit(out, "out", 223, 8722, 9578);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 223, 8722, 9578);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 223, 8722, 9578);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 223, 8722, 9578);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 223, 8722, 9578);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 223, 8722, 9578);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 223, 8722, 9578);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 223, 8722, 9578);
            CallChecker.varInit(this.currentState, "currentState", 223, 8722, 9578);
            CallChecker.varInit(this.h, "h", 223, 8722, 9578);
            CallChecker.varInit(this.nordsieck, "nordsieck", 223, 8722, 9578);
            CallChecker.varInit(this.scaled, "scaled", 223, 8722, 9578);
            CallChecker.varInit(this.referenceTime, "referenceTime", 223, 8722, 9578);
            CallChecker.varInit(this.scalingH, "scalingH", 223, 8722, 9578);
            CallChecker.varInit(this.stateVariation, "stateVariation", 223, 8722, 9578);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 223, 8722, 9578);
            writeBaseExternal(out);
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 230, 8963, 8965)) {
                CallChecker.isCalled(out, ObjectOutput.class, 230, 8963, 8965).writeDouble(scalingH);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 231, 8998, 9000)) {
                CallChecker.isCalled(out, ObjectOutput.class, 231, 8998, 9000).writeDouble(referenceTime);
            }
            int n = CallChecker.init(int.class);
            if ((currentState) == null) {
                n = -1;
                CallChecker.varAssign(n, "n", 233, 9053, 9101);
            }else {
                n = currentState.length;
                CallChecker.varAssign(n, "n", 233, 9053, 9101);
            }
            if ((scaled) == null) {
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 235, 9146, 9148)) {
                    CallChecker.isCalled(out, ObjectOutput.class, 235, 9146, 9148).writeBoolean(false);
                }
            }else {
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 237, 9200, 9202)) {
                    CallChecker.isCalled(out, ObjectOutput.class, 237, 9200, 9202).writeBoolean(true);
                }
                for (int j = 0; j < n; ++j) {
                    if (CallChecker.beforeDeref(out, ObjectOutput.class, 239, 9282, 9284)) {
                        CallChecker.isCalled(out, ObjectOutput.class, 239, 9282, 9284).writeDouble(scaled[j]);
                    }
                }
            }
            if ((nordsieck) == null) {
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 244, 9380, 9382)) {
                    CallChecker.isCalled(out, ObjectOutput.class, 244, 9380, 9382).writeBoolean(false);
                }
            }else {
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 246, 9434, 9436)) {
                    CallChecker.isCalled(out, ObjectOutput.class, 246, 9434, 9436).writeBoolean(true);
                }
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 247, 9470, 9472)) {
                    CallChecker.isCalled(out, ObjectOutput.class, 247, 9470, 9472).writeObject(nordsieck);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1306.methodEnd();
        }
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1307 = new MethodContext(void.class, 256, 9585, 10721);
        try {
            CallChecker.varInit(this, "this", 256, 9585, 10721);
            CallChecker.varInit(in, "in", 256, 9585, 10721);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 256, 9585, 10721);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 256, 9585, 10721);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 256, 9585, 10721);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 256, 9585, 10721);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 256, 9585, 10721);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 256, 9585, 10721);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 256, 9585, 10721);
            CallChecker.varInit(this.currentState, "currentState", 256, 9585, 10721);
            CallChecker.varInit(this.h, "h", 256, 9585, 10721);
            CallChecker.varInit(this.nordsieck, "nordsieck", 256, 9585, 10721);
            CallChecker.varInit(this.scaled, "scaled", 256, 9585, 10721);
            CallChecker.varInit(this.referenceTime, "referenceTime", 256, 9585, 10721);
            CallChecker.varInit(this.scalingH, "scalingH", 256, 9585, 10721);
            CallChecker.varInit(this.stateVariation, "stateVariation", 256, 9585, 10721);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator.serialVersionUID", 256, 9585, 10721);
            final double t = CallChecker.varInit(((double) (readBaseExternal(in))), "t", 260, 9733, 9801);
            if (CallChecker.beforeDeref(in, ObjectInput.class, 263, 9865, 9866)) {
                scalingH = CallChecker.isCalled(in, ObjectInput.class, 263, 9865, 9866).readDouble();
                CallChecker.varAssign(this.scalingH, "this.scalingH", 263, 9849, 9880);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 264, 9906, 9907)) {
                referenceTime = CallChecker.isCalled(in, ObjectInput.class, 264, 9906, 9907).readDouble();
                CallChecker.varAssign(this.referenceTime, "this.referenceTime", 264, 9890, 9921);
            }
            int n = CallChecker.init(int.class);
            if ((currentState) == null) {
                n = -1;
                CallChecker.varAssign(n, "n", 266, 9946, 9994);
            }else {
                n = currentState.length;
                CallChecker.varAssign(n, "n", 266, 9946, 9994);
            }
            final boolean hasScaled = CallChecker.varInit(((boolean) (CallChecker.isCalled(in, ObjectInput.class, 267, 10031, 10032).readBoolean())), "hasScaled", 267, 10005, 10047);
            if (hasScaled) {
                scaled = new double[n];
                CallChecker.varAssign(this.scaled, "this.scaled", 269, 10086, 10108);
                for (int j = 0; j < n; ++j) {
                    if (CallChecker.beforeDeref(scaled, double[].class, 271, 10168, 10173)) {
                        if (CallChecker.beforeDeref(in, ObjectInput.class, 271, 10180, 10181)) {
                            scaled = CallChecker.beforeCalled(scaled, double[].class, 271, 10168, 10173);
                            CallChecker.isCalled(scaled, double[].class, 271, 10168, 10173)[j] = CallChecker.isCalled(in, ObjectInput.class, 271, 10180, 10181).readDouble();
                            CallChecker.varAssign(CallChecker.isCalled(this.scaled, double[].class, 271, 10168, 10173)[j], "CallChecker.isCalled(this.scaled, double[].class, 271, 10168, 10173)[j]", 271, 10168, 10195);
                        }
                    }
                }
            }else {
                scaled = null;
                CallChecker.varAssign(this.scaled, "this.scaled", 274, 10240, 10253);
            }
            final boolean hasNordsieck = CallChecker.varInit(((boolean) (CallChecker.isCalled(in, ObjectInput.class, 277, 10303, 10304).readBoolean())), "hasNordsieck", 277, 10274, 10319);
            if (hasNordsieck) {
                if (CallChecker.beforeDeref(in, ObjectInput.class, 279, 10396, 10397)) {
                    nordsieck = ((Array2DRowRealMatrix) (CallChecker.isCalled(in, ObjectInput.class, 279, 10396, 10397).readObject()));
                    CallChecker.varAssign(this.nordsieck, "this.nordsieck", 279, 10361, 10411);
                }
            }else {
                nordsieck = null;
                CallChecker.varAssign(this.nordsieck, "this.nordsieck", 281, 10442, 10458);
            }
            if (hasScaled && hasNordsieck) {
                stateVariation = new double[n];
                CallChecker.varAssign(this.stateVariation, "this.stateVariation", 286, 10586, 10616);
                setInterpolatedTime(t);
            }else {
                stateVariation = null;
                CallChecker.varAssign(this.stateVariation, "this.stateVariation", 289, 10683, 10704);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1307.methodEnd();
        }
    }
}

