package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

public abstract class MultistepIntegrator extends AdaptiveStepsizeIntegrator {
    public interface NordsieckTransformer {
        Array2DRowRealMatrix initializeHighOrderDerivatives(final double h, final double[] t, final double[][] y, final double[][] yDot);
    }

    private class NordsieckInitializer implements StepHandler {
        private int count;

        private final double[] t;

        private final double[][] y;

        private final double[][] yDot;

        public NordsieckInitializer(final int nSteps, final int n) {
            ConstructorContext _bcornu_methode_context1217 = new ConstructorContext(MultistepIntegrator.NordsieckInitializer.class, 359, 14904, 15324);
            try {
                this.count = 0;
                CallChecker.varAssign(this.count, "this.count", 360, 15159, 15173);
                this.t = new double[nSteps];
                CallChecker.varAssign(this.t, "this.t", 361, 15187, 15218);
                this.y = new double[nSteps][n];
                CallChecker.varAssign(this.y, "this.y", 362, 15232, 15266);
                this.yDot = new double[nSteps][n];
                CallChecker.varAssign(this.yDot, "this.yDot", 363, 15280, 15314);
            } finally {
                _bcornu_methode_context1217.methodEnd();
            }
        }

        public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
            MethodContext _bcornu_methode_context5519 = new MethodContext(void.class, 367, 15335, 18151);
            try {
                CallChecker.varInit(this, "this", 367, 15335, 18151);
                CallChecker.varInit(isLast, "isLast", 367, 15335, 18151);
                CallChecker.varInit(interpolator, "interpolator", 367, 15335, 18151);
                CallChecker.varInit(this.yDot, "yDot", 367, 15335, 18151);
                CallChecker.varInit(this.y, "y", 367, 15335, 18151);
                CallChecker.varInit(this.t, "t", 367, 15335, 18151);
                CallChecker.varInit(this.count, "count", 367, 15335, 18151);
                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 370, 15514, 15525);
                final double prev = CallChecker.varInit(((double) (CallChecker.isCalled(interpolator, StepInterpolator.class, 370, 15514, 15525).getPreviousTime())), "prev", 370, 15494, 15544);
                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 371, 15578, 15589);
                final double curr = CallChecker.varInit(((double) (CallChecker.isCalled(interpolator, StepInterpolator.class, 371, 15578, 15589).getCurrentTime())), "curr", 371, 15558, 15607);
                if ((count) == 0) {
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 375, 15735, 15746)) {
                        interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 375, 15735, 15746);
                        CallChecker.isCalled(interpolator, StepInterpolator.class, 375, 15735, 15746).setInterpolatedTime(prev);
                    }
                    if (CallChecker.beforeDeref(t, double[].class, 376, 15791, 15791)) {
                        CallChecker.isCalled(t, double[].class, 376, 15791, 15791)[0] = prev;
                        CallChecker.varAssign(CallChecker.isCalled(this.t, double[].class, 376, 15791, 15791)[0], "CallChecker.isCalled(this.t, double[].class, 376, 15791, 15791)[0]", 376, 15791, 15802);
                    }
                    final ExpandableStatefulODE expandable = CallChecker.varInit(getExpandable(), "expandable", 377, 15820, 15876);
                    final EquationsMapper primary = CallChecker.varInit(CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 378, 15926, 15935).getPrimaryMapper(), "primary", 378, 15894, 15955);
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 379, 16000, 16011)) {
                        if (CallChecker.beforeDeref(y, double[][].class, 379, 16037, 16037)) {
                            if (CallChecker.beforeDeref(primary, EquationsMapper.class, 379, 15973, 15979)) {
                                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 379, 16000, 16011);
                                CallChecker.isCalled(primary, EquationsMapper.class, 379, 15973, 15979).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 379, 16000, 16011).getInterpolatedState(), CallChecker.isCalled(y, double[][].class, 379, 16037, 16037)[count]);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 380, 16091, 16102)) {
                        if (CallChecker.beforeDeref(yDot, double[][].class, 380, 16134, 16137)) {
                            if (CallChecker.beforeDeref(primary, EquationsMapper.class, 380, 16064, 16070)) {
                                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 380, 16091, 16102);
                                CallChecker.isCalled(primary, EquationsMapper.class, 380, 16064, 16070).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 380, 16091, 16102).getInterpolatedDerivatives(), CallChecker.isCalled(yDot, double[][].class, 380, 16134, 16137)[count]);
                            }
                        }
                    }
                    int index = CallChecker.varInit(((int) (0)), "index", 381, 16164, 16177);
                    for (final EquationsMapper secondary : CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 382, 16234, 16243).getSecondaryMappers()) {
                        if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 383, 16319, 16330)) {
                            if (CallChecker.beforeDeref(y, double[][].class, 383, 16370, 16370)) {
                                if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 383, 16290, 16298)) {
                                    interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 383, 16319, 16330);
                                    CallChecker.isCalled(secondary, EquationsMapper.class, 383, 16290, 16298).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 383, 16319, 16330).getInterpolatedSecondaryState(index), CallChecker.isCalled(y, double[][].class, 383, 16370, 16370)[count]);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 384, 16430, 16441)) {
                            if (CallChecker.beforeDeref(yDot, double[][].class, 384, 16487, 16490)) {
                                if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 384, 16401, 16409)) {
                                    interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 384, 16430, 16441);
                                    CallChecker.isCalled(secondary, EquationsMapper.class, 384, 16401, 16409).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 384, 16430, 16441).getInterpolatedSecondaryDerivatives(index), CallChecker.isCalled(yDot, double[][].class, 384, 16487, 16490)[count]);
                                }
                            }
                        }
                        ++index;
                    }
                }
                ++(count);
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 391, 16637, 16648)) {
                    interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 391, 16637, 16648);
                    CallChecker.isCalled(interpolator, StepInterpolator.class, 391, 16637, 16648).setInterpolatedTime(curr);
                }
                if (CallChecker.beforeDeref(t, double[].class, 392, 16689, 16689)) {
                    CallChecker.isCalled(t, double[].class, 392, 16689, 16689)[count] = curr;
                    CallChecker.varAssign(CallChecker.isCalled(this.t, double[].class, 392, 16689, 16689)[this.count], "CallChecker.isCalled(this.t, double[].class, 392, 16689, 16689)[this.count]", 392, 16689, 16704);
                }
                final ExpandableStatefulODE expandable = CallChecker.varInit(getExpandable(), "expandable", 394, 16719, 16775);
                final EquationsMapper primary = CallChecker.varInit(CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 395, 16821, 16830).getPrimaryMapper(), "primary", 395, 16789, 16850);
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 396, 16891, 16902)) {
                    if (CallChecker.beforeDeref(y, double[][].class, 396, 16928, 16928)) {
                        if (CallChecker.beforeDeref(primary, EquationsMapper.class, 396, 16864, 16870)) {
                            interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 396, 16891, 16902);
                            CallChecker.isCalled(primary, EquationsMapper.class, 396, 16864, 16870).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 396, 16891, 16902).getInterpolatedState(), CallChecker.isCalled(y, double[][].class, 396, 16928, 16928)[count]);
                        }
                    }
                }
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 397, 16978, 16989)) {
                    if (CallChecker.beforeDeref(yDot, double[][].class, 397, 17021, 17024)) {
                        if (CallChecker.beforeDeref(primary, EquationsMapper.class, 397, 16951, 16957)) {
                            interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 397, 16978, 16989);
                            CallChecker.isCalled(primary, EquationsMapper.class, 397, 16951, 16957).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 397, 16978, 16989).getInterpolatedDerivatives(), CallChecker.isCalled(yDot, double[][].class, 397, 17021, 17024)[count]);
                        }
                    }
                }
                int index = CallChecker.varInit(((int) (0)), "index", 398, 17047, 17060);
                for (final EquationsMapper secondary : CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 399, 17113, 17122).getSecondaryMappers()) {
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 400, 17194, 17205)) {
                        if (CallChecker.beforeDeref(y, double[][].class, 400, 17245, 17245)) {
                            if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 400, 17165, 17173)) {
                                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 400, 17194, 17205);
                                CallChecker.isCalled(secondary, EquationsMapper.class, 400, 17165, 17173).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 400, 17194, 17205).getInterpolatedSecondaryState(index), CallChecker.isCalled(y, double[][].class, 400, 17245, 17245)[count]);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 401, 17301, 17312)) {
                        if (CallChecker.beforeDeref(yDot, double[][].class, 401, 17358, 17361)) {
                            if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 401, 17272, 17280)) {
                                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 401, 17301, 17312);
                                CallChecker.isCalled(secondary, EquationsMapper.class, 401, 17272, 17280).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 401, 17301, 17312).getInterpolatedSecondaryDerivatives(index), CallChecker.isCalled(yDot, double[][].class, 401, 17358, 17361)[count]);
                            }
                        }
                    }
                    ++index;
                }
                if (CallChecker.beforeDeref(t, double[].class, 405, 17437, 17437)) {
                    if ((count) == ((CallChecker.isCalled(t, double[].class, 405, 17437, 17437).length) - 1)) {
                        if (CallChecker.beforeDeref(t, double[].class, 408, 17566, 17566)) {
                            stepStart = CallChecker.isCalled(t, double[].class, 408, 17566, 17566)[0];
                            CallChecker.varAssign(MultistepIntegrator.this.stepStart, "this.stepStart", 408, 17554, 17570);
                        }
                        if (CallChecker.beforeDeref(t, double[].class, 409, 17603, 17603)) {
                            if (CallChecker.beforeDeref(t, double[].class, 409, 17601, 17601)) {
                                if (CallChecker.beforeDeref(t, double[].class, 409, 17619, 17619)) {
                                    if (CallChecker.beforeDeref(t, double[].class, 409, 17628, 17628)) {
                                        stepSize = ((CallChecker.isCalled(t, double[].class, 409, 17601, 17601)[((CallChecker.isCalled(t, double[].class, 409, 17603, 17603).length) - 1)]) - (CallChecker.isCalled(t, double[].class, 409, 17619, 17619)[0])) / ((CallChecker.isCalled(t, double[].class, 409, 17628, 17628).length) - 1);
                                        CallChecker.varAssign(MultistepIntegrator.this.stepSize, "this.stepSize", 409, 17588, 17641);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(yDot, double[][].class, 412, 17712, 17715)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(yDot, double[][].class, 412, 17712, 17715)[0], double[].class, 412, 17712, 17718)) {
                                CallChecker.isCalled(yDot, double[][].class, 412, 17712, 17715)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDot, double[][].class, 412, 17712, 17715)[0], double[].class, 412, 17712, 17718);
                                scaled = CallChecker.isCalled(CallChecker.isCalled(yDot, double[][].class, 412, 17712, 17715)[0], double[].class, 412, 17712, 17718).clone();
                                CallChecker.varAssign(MultistepIntegrator.this.scaled, "this.scaled", 412, 17703, 17727);
                            }
                        }
                        scaled = CallChecker.beforeCalled(scaled, double[].class, 413, 17765, 17770);
                        for (int j = 0; j < (CallChecker.isCalled(scaled, double[].class, 413, 17765, 17770).length); ++j) {
                            if (CallChecker.beforeDeref(scaled, double[].class, 414, 17807, 17812)) {
                                scaled = CallChecker.beforeCalled(scaled, double[].class, 414, 17807, 17812);
                                CallChecker.isCalled(scaled, double[].class, 414, 17807, 17812)[j] *= stepSize;
                                CallChecker.varAssign(CallChecker.isCalled(MultistepIntegrator.this.scaled, double[].class, 414, 17807, 17812)[j], "CallChecker.isCalled(this.scaled, double[].class, 414, 17807, 17812)[j]", 414, 17807, 17828);
                            }
                        }
                        nordsieck = initializeHighOrderDerivatives(stepSize, t, y, yDot);
                        CallChecker.varAssign(MultistepIntegrator.this.nordsieck, "this.nordsieck", 418, 17909, 17973);
                        throw new MultistepIntegrator.InitializationCompletedMarkerException();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5519.methodEnd();
            }
        }

        public void init(double t0, double[] y0, double time) {
            MethodContext _bcornu_methode_context5520 = new MethodContext(void.class, 428, 18162, 18284);
            try {
                CallChecker.varInit(this, "this", 428, 18162, 18284);
                CallChecker.varInit(time, "time", 428, 18162, 18284);
                CallChecker.varInit(y0, "y0", 428, 18162, 18284);
                CallChecker.varInit(t0, "t0", 428, 18162, 18284);
                CallChecker.varInit(this.yDot, "yDot", 428, 18162, 18284);
                CallChecker.varInit(this.y, "y", 428, 18162, 18284);
                CallChecker.varInit(this.t, "t", 428, 18162, 18284);
                CallChecker.varInit(this.count, "count", 428, 18162, 18284);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5520.methodEnd();
            }
        }
    }

    private static class InitializationCompletedMarkerException extends RuntimeException {
        private static final long serialVersionUID = -1914085471038046418L;

        public InitializationCompletedMarkerException() {
            super(((Throwable) (null)));
            ConstructorContext _bcornu_methode_context1218 = new ConstructorContext(MultistepIntegrator.InitializationCompletedMarkerException.class, 442, 18614, 18744);
            try {
            } finally {
                _bcornu_methode_context1218.methodEnd();
            }
        }
    }

    protected double[] scaled;

    protected Array2DRowRealMatrix nordsieck;

    private FirstOrderIntegrator starter;

    private final int nSteps;

    private double exp;

    private double safety;

    private double minReduction;

    private double maxGrowth;

    protected MultistepIntegrator(final String name, final int nSteps, final int order, final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) throws NumberIsTooSmallException {
        super(name, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context1219 = new ConstructorContext(MultistepIntegrator.class, 111, 3953, 6045);
        try {
            if (nSteps < 2) {
                throw new NumberIsTooSmallException(LocalizedFormats.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS, nSteps, 2, true);
            }
            starter = new DormandPrince853Integrator(minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
            CallChecker.varAssign(this.starter, "this.starter", 126, 5605, 5807);
            this.nSteps = nSteps;
            CallChecker.varAssign(this.nSteps, "this.nSteps", 129, 5817, 5837);
            exp = (-1.0) / order;
            CallChecker.varAssign(this.exp, "this.exp", 131, 5848, 5866);
            setSafety(0.9);
            setMinReduction(0.2);
            setMaxGrowth(FastMath.pow(2.0, (-(exp))));
        } finally {
            _bcornu_methode_context1219.methodEnd();
        }
    }

    protected MultistepIntegrator(final String name, final int nSteps, final int order, final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) {
        super(name, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context1220 = new ConstructorContext(MultistepIntegrator.class, 159, 6052, 7804);
        try {
            starter = new DormandPrince853Integrator(minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
            CallChecker.varAssign(this.starter, "this.starter", 165, 7366, 7566);
            this.nSteps = nSteps;
            CallChecker.varAssign(this.nSteps, "this.nSteps", 168, 7576, 7596);
            exp = (-1.0) / order;
            CallChecker.varAssign(this.exp, "this.exp", 170, 7607, 7625);
            setSafety(0.9);
            setMinReduction(0.2);
            setMaxGrowth(FastMath.pow(2.0, (-(exp))));
        } finally {
            _bcornu_methode_context1220.methodEnd();
        }
    }

    public ODEIntegrator getStarterIntegrator() {
        MethodContext _bcornu_methode_context5521 = new MethodContext(ODEIntegrator.class, 183, 7811, 7970);
        try {
            CallChecker.varInit(this, "this", 183, 7811, 7970);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 183, 7811, 7970);
            CallChecker.varInit(this.isLastStep, "isLastStep", 183, 7811, 7970);
            CallChecker.varInit(this.stepSize, "stepSize", 183, 7811, 7970);
            CallChecker.varInit(this.stepStart, "stepStart", 183, 7811, 7970);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 183, 7811, 7970);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 183, 7811, 7970);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 183, 7811, 7970);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 183, 7811, 7970);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 183, 7811, 7970);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 183, 7811, 7970);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 183, 7811, 7970);
            CallChecker.varInit(this.minReduction, "minReduction", 183, 7811, 7970);
            CallChecker.varInit(this.safety, "safety", 183, 7811, 7970);
            CallChecker.varInit(this.exp, "exp", 183, 7811, 7970);
            CallChecker.varInit(this.nSteps, "nSteps", 183, 7811, 7970);
            CallChecker.varInit(this.starter, "starter", 183, 7811, 7970);
            CallChecker.varInit(this.nordsieck, "nordsieck", 183, 7811, 7970);
            CallChecker.varInit(this.scaled, "scaled", 183, 7811, 7970);
            return starter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ODEIntegrator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5521.methodEnd();
        }
    }

    public void setStarterIntegrator(FirstOrderIntegrator starterIntegrator) {
        MethodContext _bcornu_methode_context5522 = new MethodContext(void.class, 194, 7977, 8422);
        try {
            CallChecker.varInit(this, "this", 194, 7977, 8422);
            CallChecker.varInit(starterIntegrator, "starterIntegrator", 194, 7977, 8422);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 194, 7977, 8422);
            CallChecker.varInit(this.isLastStep, "isLastStep", 194, 7977, 8422);
            CallChecker.varInit(this.stepSize, "stepSize", 194, 7977, 8422);
            CallChecker.varInit(this.stepStart, "stepStart", 194, 7977, 8422);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 194, 7977, 8422);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 194, 7977, 8422);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 194, 7977, 8422);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 194, 7977, 8422);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 194, 7977, 8422);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 194, 7977, 8422);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 194, 7977, 8422);
            CallChecker.varInit(this.minReduction, "minReduction", 194, 7977, 8422);
            CallChecker.varInit(this.safety, "safety", 194, 7977, 8422);
            CallChecker.varInit(this.exp, "exp", 194, 7977, 8422);
            CallChecker.varInit(this.nSteps, "nSteps", 194, 7977, 8422);
            CallChecker.varInit(this.starter, "starter", 194, 7977, 8422);
            CallChecker.varInit(this.nordsieck, "nordsieck", 194, 7977, 8422);
            CallChecker.varInit(this.scaled, "scaled", 194, 7977, 8422);
            this.starter = starterIntegrator;
            CallChecker.varAssign(this.starter, "this.starter", 195, 8384, 8416);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5522.methodEnd();
        }
    }

    protected void start(final double t0, final double[] y0, final double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5525 = new MethodContext(void.class, 216, 8429, 11461);
        try {
            CallChecker.varInit(this, "this", 216, 8429, 11461);
            CallChecker.varInit(t, "t", 216, 8429, 11461);
            CallChecker.varInit(y0, "y0", 216, 8429, 11461);
            CallChecker.varInit(t0, "t0", 216, 8429, 11461);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 216, 8429, 11461);
            CallChecker.varInit(this.isLastStep, "isLastStep", 216, 8429, 11461);
            CallChecker.varInit(this.stepSize, "stepSize", 216, 8429, 11461);
            CallChecker.varInit(this.stepStart, "stepStart", 216, 8429, 11461);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 216, 8429, 11461);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 216, 8429, 11461);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 216, 8429, 11461);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 216, 8429, 11461);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 216, 8429, 11461);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 216, 8429, 11461);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 216, 8429, 11461);
            CallChecker.varInit(this.minReduction, "minReduction", 216, 8429, 11461);
            CallChecker.varInit(this.safety, "safety", 216, 8429, 11461);
            CallChecker.varInit(this.exp, "exp", 216, 8429, 11461);
            CallChecker.varInit(this.nSteps, "nSteps", 216, 8429, 11461);
            CallChecker.varInit(this.starter, "starter", 216, 8429, 11461);
            CallChecker.varInit(this.nordsieck, "nordsieck", 216, 8429, 11461);
            CallChecker.varInit(this.scaled, "scaled", 216, 8429, 11461);
            if (CallChecker.beforeDeref(starter, FirstOrderIntegrator.class, 223, 10045, 10051)) {
                starter = CallChecker.beforeCalled(starter, FirstOrderIntegrator.class, 223, 10045, 10051);
                CallChecker.isCalled(starter, FirstOrderIntegrator.class, 223, 10045, 10051).clearEventHandlers();
            }
            if (CallChecker.beforeDeref(starter, FirstOrderIntegrator.class, 224, 10083, 10089)) {
                starter = CallChecker.beforeCalled(starter, FirstOrderIntegrator.class, 224, 10083, 10089);
                CallChecker.isCalled(starter, FirstOrderIntegrator.class, 224, 10083, 10089).clearStepHandlers();
            }
            if (CallChecker.beforeDeref(y0, double[].class, 227, 10257, 10258)) {
                if (CallChecker.beforeDeref(starter, FirstOrderIntegrator.class, 227, 10201, 10207)) {
                    starter = CallChecker.beforeCalled(starter, FirstOrderIntegrator.class, 227, 10201, 10207);
                    CallChecker.isCalled(starter, FirstOrderIntegrator.class, 227, 10201, 10207).addStepHandler(new MultistepIntegrator.NordsieckInitializer(nSteps, CallChecker.isCalled(y0, double[].class, 227, 10257, 10258).length));
                }
            }
            TryContext _bcornu_try_context_106 = new TryContext(106, MultistepIntegrator.class, "org.apache.commons.math3.ode.MultistepIntegrator$InitializationCompletedMarkerException");
            try {
                if ((starter) instanceof AbstractIntegrator) {
                    if (CallChecker.beforeDeref(starter, FirstOrderIntegrator.class, 233, 10462, 10468)) {
                        starter = CallChecker.beforeCalled(starter, AbstractIntegrator.class, 233, 10462, 10468);
                        CallChecker.isCalled(((AbstractIntegrator) (starter)), AbstractIntegrator.class, 233, 10462, 10468).integrate(getExpandable(), t);
                    }
                }else {
                    if (CallChecker.beforeDeref(y0, double[].class, 247, 11045, 11046)) {
                        if (CallChecker.beforeDeref(starter, FirstOrderIntegrator.class, 235, 10539, 10545)) {
                            starter = CallChecker.beforeCalled(starter, FirstOrderIntegrator.class, 235, 10539, 10545);
                            CallChecker.isCalled(starter, FirstOrderIntegrator.class, 235, 10539, 10545).integrate(new FirstOrderDifferentialEquations() {
                                public int getDimension() {
                                    MethodContext _bcornu_methode_context5523 = new MethodContext(int.class, 238, 10618, 10775);
                                    try {
                                        CallChecker.varInit(this, "this", 238, 10618, 10775);
                                        final ExpandableStatefulODE npe_invocation_var1004 = getExpandable();
                                        if (CallChecker.beforeDeref(npe_invocation_var1004, ExpandableStatefulODE.class, 239, 10718, 10732)) {
                                            return CallChecker.isCalled(npe_invocation_var1004, ExpandableStatefulODE.class, 239, 10718, 10732).getTotalDimension();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    } catch (ForceReturn _bcornu_return_t) {
                                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                                    } finally {
                                        _bcornu_methode_context5523.methodEnd();
                                    }
                                }

                                public void computeDerivatives(double t, double[] y, double[] yDot) {
                                    MethodContext _bcornu_methode_context5524 = new MethodContext(void.class, 243, 10798, 11001);
                                    try {
                                        CallChecker.varInit(this, "this", 243, 10798, 11001);
                                        CallChecker.varInit(yDot, "yDot", 243, 10798, 11001);
                                        CallChecker.varInit(y, "y", 243, 10798, 11001);
                                        CallChecker.varInit(t, "t", 243, 10798, 11001);
                                        final ExpandableStatefulODE npe_invocation_var1005 = getExpandable();
                                        if (CallChecker.beforeDeref(npe_invocation_var1005, ExpandableStatefulODE.class, 244, 10933, 10947)) {
                                            CallChecker.isCalled(npe_invocation_var1005, ExpandableStatefulODE.class, 244, 10933, 10947).computeDerivatives(t, y, yDot);
                                        }
                                    } catch (ForceReturn _bcornu_return_t) {
                                        _bcornu_return_t.getDecision().getValue();
                                        return ;
                                    } finally {
                                        _bcornu_methode_context5524.methodEnd();
                                    }
                                }
                            }, t0, y0, t, new double[CallChecker.isCalled(y0, double[].class, 247, 11045, 11046).length]);
                        }
                    }
                }
            } catch (MultistepIntegrator.InitializationCompletedMarkerException icme) {
                _bcornu_try_context_106.catchStart(106);
                if (CallChecker.beforeDeref(starter, FirstOrderIntegrator.class, 254, 11336, 11342)) {
                    final Incrementor npe_invocation_var1006 = getEvaluationsCounter();
                    if (CallChecker.beforeDeref(npe_invocation_var1006, Incrementor.class, 254, 11297, 11319)) {
                        starter = CallChecker.beforeCalled(starter, FirstOrderIntegrator.class, 254, 11336, 11342);
                        CallChecker.isCalled(npe_invocation_var1006, Incrementor.class, 254, 11297, 11319).incrementCount(CallChecker.isCalled(starter, FirstOrderIntegrator.class, 254, 11336, 11342).getEvaluations());
                    }
                }
            } finally {
                _bcornu_try_context_106.finallyStart(106);
            }
            if (CallChecker.beforeDeref(starter, FirstOrderIntegrator.class, 259, 11427, 11433)) {
                starter = CallChecker.beforeCalled(starter, FirstOrderIntegrator.class, 259, 11427, 11433);
                CallChecker.isCalled(starter, FirstOrderIntegrator.class, 259, 11427, 11433).clearStepHandlers();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5525.methodEnd();
        }
    }

    protected abstract Array2DRowRealMatrix initializeHighOrderDerivatives(final double h, final double[] t, final double[][] y, final double[][] yDot);

    public double getMinReduction() {
        MethodContext _bcornu_methode_context5527 = new MethodContext(double.class, 278, 12174, 12352);
        try {
            CallChecker.varInit(this, "this", 278, 12174, 12352);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 278, 12174, 12352);
            CallChecker.varInit(this.isLastStep, "isLastStep", 278, 12174, 12352);
            CallChecker.varInit(this.stepSize, "stepSize", 278, 12174, 12352);
            CallChecker.varInit(this.stepStart, "stepStart", 278, 12174, 12352);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 278, 12174, 12352);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 278, 12174, 12352);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 278, 12174, 12352);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 278, 12174, 12352);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 278, 12174, 12352);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 278, 12174, 12352);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 278, 12174, 12352);
            CallChecker.varInit(this.minReduction, "minReduction", 278, 12174, 12352);
            CallChecker.varInit(this.safety, "safety", 278, 12174, 12352);
            CallChecker.varInit(this.exp, "exp", 278, 12174, 12352);
            CallChecker.varInit(this.nSteps, "nSteps", 278, 12174, 12352);
            CallChecker.varInit(this.starter, "starter", 278, 12174, 12352);
            CallChecker.varInit(this.nordsieck, "nordsieck", 278, 12174, 12352);
            CallChecker.varInit(this.scaled, "scaled", 278, 12174, 12352);
            return minReduction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5527.methodEnd();
        }
    }

    public void setMinReduction(final double minReduction) {
        MethodContext _bcornu_methode_context5528 = new MethodContext(void.class, 285, 12359, 12585);
        try {
            CallChecker.varInit(this, "this", 285, 12359, 12585);
            CallChecker.varInit(minReduction, "minReduction", 285, 12359, 12585);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 285, 12359, 12585);
            CallChecker.varInit(this.isLastStep, "isLastStep", 285, 12359, 12585);
            CallChecker.varInit(this.stepSize, "stepSize", 285, 12359, 12585);
            CallChecker.varInit(this.stepStart, "stepStart", 285, 12359, 12585);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 285, 12359, 12585);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 285, 12359, 12585);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 285, 12359, 12585);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 285, 12359, 12585);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 285, 12359, 12585);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 285, 12359, 12585);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 285, 12359, 12585);
            CallChecker.varInit(this.minReduction, "minReduction", 285, 12359, 12585);
            CallChecker.varInit(this.safety, "safety", 285, 12359, 12585);
            CallChecker.varInit(this.exp, "exp", 285, 12359, 12585);
            CallChecker.varInit(this.nSteps, "nSteps", 285, 12359, 12585);
            CallChecker.varInit(this.starter, "starter", 285, 12359, 12585);
            CallChecker.varInit(this.nordsieck, "nordsieck", 285, 12359, 12585);
            CallChecker.varInit(this.scaled, "scaled", 285, 12359, 12585);
            this.minReduction = minReduction;
            CallChecker.varAssign(this.minReduction, "this.minReduction", 286, 12547, 12579);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5528.methodEnd();
        }
    }

    public double getMaxGrowth() {
        MethodContext _bcornu_methode_context5529 = new MethodContext(double.class, 292, 12592, 12758);
        try {
            CallChecker.varInit(this, "this", 292, 12592, 12758);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 292, 12592, 12758);
            CallChecker.varInit(this.isLastStep, "isLastStep", 292, 12592, 12758);
            CallChecker.varInit(this.stepSize, "stepSize", 292, 12592, 12758);
            CallChecker.varInit(this.stepStart, "stepStart", 292, 12592, 12758);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 292, 12592, 12758);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 292, 12592, 12758);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 292, 12592, 12758);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 292, 12592, 12758);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 292, 12592, 12758);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 292, 12592, 12758);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 292, 12592, 12758);
            CallChecker.varInit(this.minReduction, "minReduction", 292, 12592, 12758);
            CallChecker.varInit(this.safety, "safety", 292, 12592, 12758);
            CallChecker.varInit(this.exp, "exp", 292, 12592, 12758);
            CallChecker.varInit(this.nSteps, "nSteps", 292, 12592, 12758);
            CallChecker.varInit(this.starter, "starter", 292, 12592, 12758);
            CallChecker.varInit(this.nordsieck, "nordsieck", 292, 12592, 12758);
            CallChecker.varInit(this.scaled, "scaled", 292, 12592, 12758);
            return maxGrowth;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5529.methodEnd();
        }
    }

    public void setMaxGrowth(final double maxGrowth) {
        MethodContext _bcornu_methode_context5530 = new MethodContext(void.class, 299, 12765, 12970);
        try {
            CallChecker.varInit(this, "this", 299, 12765, 12970);
            CallChecker.varInit(maxGrowth, "maxGrowth", 299, 12765, 12970);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 299, 12765, 12970);
            CallChecker.varInit(this.isLastStep, "isLastStep", 299, 12765, 12970);
            CallChecker.varInit(this.stepSize, "stepSize", 299, 12765, 12970);
            CallChecker.varInit(this.stepStart, "stepStart", 299, 12765, 12970);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 299, 12765, 12970);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 299, 12765, 12970);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 299, 12765, 12970);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 299, 12765, 12970);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 299, 12765, 12970);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 299, 12765, 12970);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 299, 12765, 12970);
            CallChecker.varInit(this.minReduction, "minReduction", 299, 12765, 12970);
            CallChecker.varInit(this.safety, "safety", 299, 12765, 12970);
            CallChecker.varInit(this.exp, "exp", 299, 12765, 12970);
            CallChecker.varInit(this.nSteps, "nSteps", 299, 12765, 12970);
            CallChecker.varInit(this.starter, "starter", 299, 12765, 12970);
            CallChecker.varInit(this.nordsieck, "nordsieck", 299, 12765, 12970);
            CallChecker.varInit(this.scaled, "scaled", 299, 12765, 12970);
            this.maxGrowth = maxGrowth;
            CallChecker.varAssign(this.maxGrowth, "this.maxGrowth", 300, 12938, 12964);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5530.methodEnd();
        }
    }

    public double getSafety() {
        MethodContext _bcornu_methode_context5531 = new MethodContext(double.class, 306, 12977, 13119);
        try {
            CallChecker.varInit(this, "this", 306, 12977, 13119);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 306, 12977, 13119);
            CallChecker.varInit(this.isLastStep, "isLastStep", 306, 12977, 13119);
            CallChecker.varInit(this.stepSize, "stepSize", 306, 12977, 13119);
            CallChecker.varInit(this.stepStart, "stepStart", 306, 12977, 13119);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 306, 12977, 13119);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 306, 12977, 13119);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 306, 12977, 13119);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 306, 12977, 13119);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 306, 12977, 13119);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 306, 12977, 13119);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 306, 12977, 13119);
            CallChecker.varInit(this.minReduction, "minReduction", 306, 12977, 13119);
            CallChecker.varInit(this.safety, "safety", 306, 12977, 13119);
            CallChecker.varInit(this.exp, "exp", 306, 12977, 13119);
            CallChecker.varInit(this.nSteps, "nSteps", 306, 12977, 13119);
            CallChecker.varInit(this.starter, "starter", 306, 12977, 13119);
            CallChecker.varInit(this.nordsieck, "nordsieck", 306, 12977, 13119);
            CallChecker.varInit(this.scaled, "scaled", 306, 12977, 13119);
            return safety;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5531.methodEnd();
        }
    }

    public void setSafety(final double safety) {
        MethodContext _bcornu_methode_context5532 = new MethodContext(void.class, 313, 13126, 13298);
        try {
            CallChecker.varInit(this, "this", 313, 13126, 13298);
            CallChecker.varInit(safety, "safety", 313, 13126, 13298);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 313, 13126, 13298);
            CallChecker.varInit(this.isLastStep, "isLastStep", 313, 13126, 13298);
            CallChecker.varInit(this.stepSize, "stepSize", 313, 13126, 13298);
            CallChecker.varInit(this.stepStart, "stepStart", 313, 13126, 13298);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 313, 13126, 13298);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 313, 13126, 13298);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 313, 13126, 13298);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 313, 13126, 13298);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 313, 13126, 13298);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 313, 13126, 13298);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 313, 13126, 13298);
            CallChecker.varInit(this.minReduction, "minReduction", 313, 13126, 13298);
            CallChecker.varInit(this.safety, "safety", 313, 13126, 13298);
            CallChecker.varInit(this.exp, "exp", 313, 13126, 13298);
            CallChecker.varInit(this.nSteps, "nSteps", 313, 13126, 13298);
            CallChecker.varInit(this.starter, "starter", 313, 13126, 13298);
            CallChecker.varInit(this.nordsieck, "nordsieck", 313, 13126, 13298);
            CallChecker.varInit(this.scaled, "scaled", 313, 13126, 13298);
            this.safety = safety;
            CallChecker.varAssign(this.safety, "this.safety", 314, 13272, 13292);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5532.methodEnd();
        }
    }

    protected double computeStepGrowShrinkFactor(final double error) {
        MethodContext _bcornu_methode_context5533 = new MethodContext(double.class, 321, 13305, 13663);
        try {
            CallChecker.varInit(this, "this", 321, 13305, 13663);
            CallChecker.varInit(error, "error", 321, 13305, 13663);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 321, 13305, 13663);
            CallChecker.varInit(this.isLastStep, "isLastStep", 321, 13305, 13663);
            CallChecker.varInit(this.stepSize, "stepSize", 321, 13305, 13663);
            CallChecker.varInit(this.stepStart, "stepStart", 321, 13305, 13663);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 321, 13305, 13663);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 321, 13305, 13663);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 321, 13305, 13663);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 321, 13305, 13663);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 321, 13305, 13663);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 321, 13305, 13663);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 321, 13305, 13663);
            CallChecker.varInit(this.minReduction, "minReduction", 321, 13305, 13663);
            CallChecker.varInit(this.safety, "safety", 321, 13305, 13663);
            CallChecker.varInit(this.exp, "exp", 321, 13305, 13663);
            CallChecker.varInit(this.nSteps, "nSteps", 321, 13305, 13663);
            CallChecker.varInit(this.starter, "starter", 321, 13305, 13663);
            CallChecker.varInit(this.nordsieck, "nordsieck", 321, 13305, 13663);
            CallChecker.varInit(this.scaled, "scaled", 321, 13305, 13663);
            return FastMath.min(maxGrowth, FastMath.max(minReduction, ((safety) * (FastMath.pow(error, exp)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5533.methodEnd();
        }
    }
}

