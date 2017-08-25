package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.MultistepIntegrator;
import org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math3.util.FastMath;

public class AdamsBashforthIntegrator extends AdamsIntegrator {
    private static final String METHOD_NAME = "Adams-Bashforth";

    public AdamsBashforthIntegrator(final int nSteps, final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) throws NumberIsTooSmallException {
        super(AdamsBashforthIntegrator.METHOD_NAME, nSteps, nSteps, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context1252 = new ConstructorContext(AdamsBashforthIntegrator.class, 161, 6893, 8049);
        try {
        } finally {
            _bcornu_methode_context1252.methodEnd();
        }
    }

    public AdamsBashforthIntegrator(final int nSteps, final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) throws IllegalArgumentException {
        super(AdamsBashforthIntegrator.METHOD_NAME, nSteps, nSteps, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context1253 = new ConstructorContext(AdamsBashforthIntegrator.class, 183, 8056, 9208);
        try {
        } finally {
            _bcornu_methode_context1253.methodEnd();
        }
    }

    @Override
    public void integrate(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5621 = new MethodContext(void.class, 194, 9215, 14832);
        try {
            CallChecker.varInit(this, "this", 194, 9215, 14832);
            CallChecker.varInit(t, "t", 194, 9215, 14832);
            CallChecker.varInit(equations, "equations", 194, 9215, 14832);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 194, 9215, 14832);
            CallChecker.varInit(this.isLastStep, "isLastStep", 194, 9215, 14832);
            CallChecker.varInit(this.stepSize, "stepSize", 194, 9215, 14832);
            CallChecker.varInit(this.stepStart, "stepStart", 194, 9215, 14832);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 194, 9215, 14832);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 194, 9215, 14832);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 194, 9215, 14832);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 194, 9215, 14832);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 194, 9215, 14832);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 194, 9215, 14832);
            CallChecker.varInit(this.nordsieck, "nordsieck", 194, 9215, 14832);
            CallChecker.varInit(this.scaled, "scaled", 194, 9215, 14832);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.AdamsBashforthIntegrator.METHOD_NAME", 194, 9215, 14832);
            sanityChecks(equations, t);
            setEquations(equations);
            final boolean forward = CallChecker.varInit(((boolean) (t > (CallChecker.isCalled(equations, ExpandableStatefulODE.class, 200, 9573, 9581).getTime()))), "forward", 200, 9545, 9592);
            final double[] y0 = CallChecker.varInit(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 203, 9662, 9670).getCompleteState(), "y0", 203, 9640, 9690);
            final double[] y = CallChecker.varInit(CallChecker.isCalled(y0, double[].class, 204, 9722, 9723).clone(), "y", 204, 9700, 9732);
            final double[] yDot = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 205, 9775, 9775).length], "yDot", 205, 9742, 9784);
            final NordsieckStepInterpolator interpolator = CallChecker.varInit(new NordsieckStepInterpolator(), "interpolator", 208, 9795, 9937);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 210, 10019, 10027)) {
                if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 210, 10049, 10057)) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 209, 9947, 9958)) {
                        CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 209, 9947, 9958).reinitialize(y, forward, CallChecker.isCalled(equations, ExpandableStatefulODE.class, 210, 10019, 10027).getPrimaryMapper(), CallChecker.isCalled(equations, ExpandableStatefulODE.class, 210, 10049, 10057).getSecondaryMappers());
                    }
                }
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 213, 10154, 10162)) {
                initIntegration(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 213, 10154, 10162).getTime(), y0, t);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 216, 10286, 10294)) {
                start(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 216, 10286, 10294).getTime(), y, t);
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 217, 10322, 10333)) {
                CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 217, 10322, 10333).reinitialize(stepStart, stepSize, scaled, nordsieck);
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 218, 10397, 10408)) {
                CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 218, 10397, 10408).storeTime(stepStart);
            }
            nordsieck = CallChecker.beforeCalled(nordsieck, Array2DRowRealMatrix.class, 219, 10460, 10468);
            final int lastRow = CallChecker.varInit(((int) ((CallChecker.isCalled(this.nordsieck, Array2DRowRealMatrix.class, 219, 10460, 10468).getRowDimension()) - 1)), "lastRow", 219, 10440, 10491);
            double hNew = CallChecker.varInit(((double) (this.stepSize)), "hNew", 222, 10570, 10592);
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 223, 10602, 10613)) {
                CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 223, 10602, 10613).rescale(hNew);
            }
            isLastStep = false;
            CallChecker.varAssign(this.isLastStep, "this.isLastStep", 226, 10672, 10690);
            do {
                double error = CallChecker.varInit(((double) (10)), "error", 229, 10718, 10735);
                while (error >= 1.0) {
                    stepSize = hNew;
                    CallChecker.varAssign(this.stepSize, "this.stepSize", 232, 10789, 10804);
                    error = 0;
                    CallChecker.varAssign(error, "error", 235, 10901, 10910);
                    for (int i = 0; i < (mainSetDimension); ++i) {
                        final double yScale = CallChecker.varInit(((double) (FastMath.abs(CallChecker.isCalled(y, double[].class, 237, 11028, 11028)[i]))), "yScale", 237, 10993, 11033);
                        double tol = CallChecker.init(double.class);
                        if ((vecAbsoluteTolerance) == null) {
                            tol = (scalAbsoluteTolerance) + ((scalRelativeTolerance) * yScale);
                            CallChecker.varAssign(tol, "tol", 238, 11074, 11303);
                        }else {
                            if (CallChecker.beforeDeref(vecRelativeTolerance, double[].class, 240, 11271, 11290)) {
                                vecRelativeTolerance = CallChecker.beforeCalled(vecRelativeTolerance, double[].class, 240, 11271, 11290);
                                tol = (vecAbsoluteTolerance[i]) + ((CallChecker.isCalled(vecRelativeTolerance, double[].class, 240, 11271, 11290)[i]) * yScale);
                                CallChecker.varAssign(tol, "tol", 238, 11074, 11303);
                            }
                        }
                        nordsieck = CallChecker.beforeCalled(nordsieck, Array2DRowRealMatrix.class, 241, 11348, 11356);
                        final double ratio = CallChecker.varInit(((double) ((CallChecker.isCalled(this.nordsieck, Array2DRowRealMatrix.class, 241, 11348, 11356).getEntry(lastRow, i)) / tol)), "ratio", 241, 11326, 11384);
                        error += ratio * ratio;
                        CallChecker.varAssign(error, "error", 242, 11406, 11428);
                    }
                    error = FastMath.sqrt((error / (mainSetDimension)));
                    CallChecker.varAssign(error, "error", 244, 11464, 11511);
                    if (error >= 1.0) {
                        final double factor = CallChecker.varInit(((double) (computeStepGrowShrinkFactor(error))), "factor", 248, 11570, 11713);
                        hNew = filterStep(((stepSize) * factor), forward, false);
                        CallChecker.varAssign(hNew, "hNew", 249, 11735, 11787);
                        if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 250, 11809, 11820)) {
                            CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 250, 11809, 11820).rescale(hNew);
                        }
                    }
                } 
                final double stepEnd = CallChecker.varInit(((double) ((this.stepStart) + (this.stepSize))), "stepEnd", 256, 11883, 11991);
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 257, 12005, 12016)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 257, 12005, 12016).shift();
                }
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 258, 12039, 12050)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 258, 12039, 12050).setInterpolatedTime(stepEnd);
                }
                final ExpandableStatefulODE expandable = CallChecker.varInit(getExpandable(), "expandable", 259, 12094, 12150);
                final EquationsMapper primary = CallChecker.varInit(CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 260, 12196, 12205).getPrimaryMapper(), "primary", 260, 12164, 12225);
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 261, 12266, 12277)) {
                    if (CallChecker.beforeDeref(primary, EquationsMapper.class, 261, 12239, 12245)) {
                        CallChecker.isCalled(primary, EquationsMapper.class, 261, 12239, 12245).insertEquationData(CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 261, 12266, 12277).getInterpolatedState(), y);
                    }
                }
                int index = CallChecker.varInit(((int) (0)), "index", 262, 12319, 12332);
                for (final EquationsMapper secondary : CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 263, 12385, 12394).getSecondaryMappers()) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 264, 12466, 12477)) {
                        if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 264, 12437, 12445)) {
                            CallChecker.isCalled(secondary, EquationsMapper.class, 264, 12437, 12445).insertEquationData(CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 264, 12466, 12477).getInterpolatedSecondaryState(index), y);
                        }
                    }
                    ++index;
                }
                computeDerivatives(stepEnd, y, yDot);
                final double[] predictedScaled = CallChecker.varInit(new double[CallChecker.isCalled(y0, double[].class, 272, 12746, 12747).length], "predictedScaled", 272, 12702, 12756);
                for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 273, 12790, 12791).length); ++j) {
                    if (CallChecker.beforeDeref(predictedScaled, double[].class, 274, 12824, 12838)) {
                        if (CallChecker.beforeDeref(yDot, double[].class, 274, 12856, 12859)) {
                            CallChecker.isCalled(predictedScaled, double[].class, 274, 12824, 12838)[j] = (stepSize) * (CallChecker.isCalled(yDot, double[].class, 274, 12856, 12859)[j]);
                            CallChecker.varAssign(CallChecker.isCalled(predictedScaled, double[].class, 274, 12824, 12838)[j], "CallChecker.isCalled(predictedScaled, double[].class, 274, 12824, 12838)[j]", 274, 12824, 12863);
                        }
                    }
                }
                final Array2DRowRealMatrix nordsieckTmp = CallChecker.varInit(updateHighOrderDerivativesPhase1(nordsieck), "nordsieckTmp", 276, 12891, 12976);
                updateHighOrderDerivativesPhase2(scaled, predictedScaled, nordsieckTmp);
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 278, 13075, 13086)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 278, 13075, 13086).reinitialize(stepEnd, stepSize, predictedScaled, nordsieckTmp);
                }
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 281, 13205, 13216)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 281, 13205, 13216).storeTime(stepEnd);
                }
                stepStart = acceptStep(interpolator, y, yDot, t);
                CallChecker.varAssign(this.stepStart, "this.stepStart", 282, 13250, 13298);
                scaled = predictedScaled;
                CallChecker.varAssign(this.scaled, "this.scaled", 283, 13312, 13339);
                nordsieck = nordsieckTmp;
                CallChecker.varAssign(this.nordsieck, "this.nordsieck", 284, 13353, 13377);
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 285, 13391, 13402)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 285, 13391, 13402).reinitialize(stepEnd, stepSize, scaled, nordsieck);
                }
                if (!(isLastStep)) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 290, 13542, 13553)) {
                        CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 290, 13542, 13553).storeTime(stepStart);
                    }
                    if (resetOccurred) {
                        start(stepStart, y, t);
                        if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 296, 13832, 13843)) {
                            CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 296, 13832, 13843).reinitialize(stepStart, stepSize, scaled, nordsieck);
                        }
                    }
                    final double factor = CallChecker.varInit(((double) (computeStepGrowShrinkFactor(error))), "factor", 300, 13934, 14045);
                    final double scaledH = CallChecker.varInit(((double) ((this.stepSize) * factor)), "scaledH", 301, 14063, 14107);
                    final double nextT = CallChecker.varInit(((double) ((this.stepStart) + scaledH)), "nextT", 302, 14125, 14171);
                    boolean nextIsLast = CallChecker.init(boolean.class);
                    if (forward) {
                        nextIsLast = nextT >= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 303, 14216, 14252);
                    }else {
                        nextIsLast = nextT <= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 303, 14216, 14252);
                    }
                    hNew = filterStep(scaledH, forward, nextIsLast);
                    CallChecker.varAssign(hNew, "hNew", 304, 14271, 14318);
                    final double filteredNextT = CallChecker.varInit(((double) ((this.stepStart) + hNew)), "filteredNextT", 306, 14337, 14388);
                    boolean filteredNextIsLast = CallChecker.init(boolean.class);
                    if (forward) {
                        filteredNextIsLast = filteredNextT >= t;
                        CallChecker.varAssign(filteredNextIsLast, "filteredNextIsLast", 307, 14441, 14493);
                    }else {
                        filteredNextIsLast = filteredNextT <= t;
                        CallChecker.varAssign(filteredNextIsLast, "filteredNextIsLast", 307, 14441, 14493);
                    }
                    if (filteredNextIsLast) {
                        hNew = t - (stepStart);
                        CallChecker.varAssign(hNew, "hNew", 309, 14558, 14578);
                    }
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 312, 14615, 14626)) {
                        CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 312, 14615, 14626).rescale(hNew);
                    }
                }
            } while (!(isLastStep) );
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 319, 14727, 14735)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 319, 14727, 14735).setTime(stepStart);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 320, 14765, 14773)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 320, 14765, 14773).setCompleteState(y);
            }
            resetInternalState();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5621.methodEnd();
        }
    }
}

