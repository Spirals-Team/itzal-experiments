package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrixPreservingVisitor;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.MultistepIntegrator;
import org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math3.util.FastMath;

public class AdamsMoultonIntegrator extends AdamsIntegrator {
    private class Corrector implements RealMatrixPreservingVisitor {
        private final double[] previous;

        private final double[] scaled;

        private final double[] before;

        private final double[] after;

        public Corrector(final double[] previous, final double[] scaled, final double[] state) {
            ConstructorContext _bcornu_methode_context925 = new ConstructorContext(AdamsMoultonIntegrator.Corrector.class, 371, 16596, 17063);
            try {
                this.previous = previous;
                CallChecker.varAssign(this.previous, "this.previous", 372, 16915, 16939);
                this.scaled = scaled;
                CallChecker.varAssign(this.scaled, "this.scaled", 373, 16953, 16975);
                this.after = state;
                CallChecker.varAssign(this.after, "this.after", 374, 16989, 17010);
                this.before = CallChecker.isCalled(state, double[].class, 375, 17040, 17044).clone();
                CallChecker.varAssign(this.before, "this.before", 375, 17024, 17053);
            } finally {
                _bcornu_methode_context925.methodEnd();
            }
        }

        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            MethodContext _bcornu_methode_context4223 = new MethodContext(void.class, 379, 17074, 17275);
            try {
                CallChecker.varInit(this, "this", 379, 17074, 17275);
                CallChecker.varInit(endColumn, "endColumn", 379, 17074, 17275);
                CallChecker.varInit(startColumn, "startColumn", 379, 17074, 17275);
                CallChecker.varInit(endRow, "endRow", 379, 17074, 17275);
                CallChecker.varInit(startRow, "startRow", 379, 17074, 17275);
                CallChecker.varInit(columns, "columns", 379, 17074, 17275);
                CallChecker.varInit(rows, "rows", 379, 17074, 17275);
                CallChecker.varInit(this.after, "after", 379, 17074, 17275);
                CallChecker.varInit(this.before, "before", 379, 17074, 17275);
                CallChecker.varInit(this.scaled, "scaled", 379, 17074, 17275);
                CallChecker.varInit(this.previous, "previous", 379, 17074, 17275);
                Arrays.fill(after, 0.0);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4223.methodEnd();
            }
        }

        public void visit(int row, int column, double value) {
            MethodContext _bcornu_methode_context4224 = new MethodContext(void.class, 385, 17286, 17529);
            try {
                CallChecker.varInit(this, "this", 385, 17286, 17529);
                CallChecker.varInit(value, "value", 385, 17286, 17529);
                CallChecker.varInit(column, "column", 385, 17286, 17529);
                CallChecker.varInit(row, "row", 385, 17286, 17529);
                CallChecker.varInit(this.after, "after", 385, 17286, 17529);
                CallChecker.varInit(this.before, "before", 385, 17286, 17529);
                CallChecker.varInit(this.scaled, "scaled", 385, 17286, 17529);
                CallChecker.varInit(this.previous, "previous", 385, 17286, 17529);
                if ((row & 1) == 0) {
                    if (CallChecker.beforeDeref(after, double[].class, 387, 17422, 17426)) {
                        CallChecker.isCalled(after, double[].class, 387, 17422, 17426)[column] -= value;
                        CallChecker.varAssign(CallChecker.isCalled(this.after, double[].class, 387, 17422, 17426)[column], "CallChecker.isCalled(this.after, double[].class, 387, 17422, 17426)[column]", 387, 17422, 17444);
                    }
                }else {
                    if (CallChecker.beforeDeref(after, double[].class, 389, 17483, 17487)) {
                        CallChecker.isCalled(after, double[].class, 389, 17483, 17487)[column] += value;
                        CallChecker.varAssign(CallChecker.isCalled(this.after, double[].class, 389, 17483, 17487)[column], "CallChecker.isCalled(this.after, double[].class, 389, 17483, 17487)[column]", 389, 17483, 17505);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4224.methodEnd();
            }
        }

        public double end() {
            MethodContext _bcornu_methode_context4225 = new MethodContext(double.class, 402, 17540, 18818);
            try {
                CallChecker.varInit(this, "this", 402, 17540, 18818);
                CallChecker.varInit(this.after, "after", 402, 17540, 18818);
                CallChecker.varInit(this.before, "before", 402, 17540, 18818);
                CallChecker.varInit(this.scaled, "scaled", 402, 17540, 18818);
                CallChecker.varInit(this.previous, "previous", 402, 17540, 18818);
                double error = CallChecker.varInit(((double) (0)), "error", 404, 18054, 18070);
                for (int i = 0; i < (CallChecker.isCalled(after, double[].class, 405, 18104, 18108).length); ++i) {
                    if (CallChecker.beforeDeref(after, double[].class, 406, 18141, 18145)) {
                        if (CallChecker.beforeDeref(previous, double[].class, 406, 18153, 18160)) {
                            if (CallChecker.beforeDeref(scaled, double[].class, 406, 18167, 18172)) {
                                CallChecker.isCalled(after, double[].class, 406, 18141, 18145)[i] += (CallChecker.isCalled(previous, double[].class, 406, 18153, 18160)[i]) + (CallChecker.isCalled(scaled, double[].class, 406, 18167, 18172)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(this.after, double[].class, 406, 18141, 18145)[i], "CallChecker.isCalled(this.after, double[].class, 406, 18141, 18145)[i]", 406, 18141, 18176);
                            }
                        }
                    }
                    if (i < (mainSetDimension)) {
                        final double yScale = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(CallChecker.isCalled(this.previous, double[].class, 408, 18290, 18297)[i]), FastMath.abs(CallChecker.isCalled(this.after, double[].class, 408, 18317, 18321)[i])))), "yScale", 408, 18242, 18327);
                        double tol = CallChecker.init(double.class);
                        if ((vecAbsoluteTolerance) == null) {
                            tol = (scalAbsoluteTolerance) + ((scalRelativeTolerance) * yScale);
                            CallChecker.varAssign(tol, "tol", 409, 18368, 18597);
                        }else {
                            if (CallChecker.beforeDeref(vecRelativeTolerance, double[].class, 411, 18565, 18584)) {
                                vecRelativeTolerance = CallChecker.beforeCalled(vecRelativeTolerance, double[].class, 411, 18565, 18584);
                                tol = (vecAbsoluteTolerance[i]) + ((CallChecker.isCalled(vecRelativeTolerance, double[].class, 411, 18565, 18584)[i]) * yScale);
                                CallChecker.varAssign(tol, "tol", 409, 18368, 18597);
                            }
                        }
                        final double ratio = CallChecker.varInit(((double) (((CallChecker.isCalled(this.after, double[].class, 412, 18643, 18647)[i]) - (CallChecker.isCalled(this.before, double[].class, 412, 18654, 18659)[i])) / tol)), "ratio", 412, 18620, 18670);
                        error += ratio * ratio;
                        CallChecker.varAssign(error, "error", 413, 18692, 18714);
                    }
                }
                return FastMath.sqrt((error / (mainSetDimension)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4225.methodEnd();
            }
        }
    }

    private static final String METHOD_NAME = "Adams-Moulton";

    public AdamsMoultonIntegrator(final int nSteps, final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) throws NumberIsTooSmallException {
        super(AdamsMoultonIntegrator.METHOD_NAME, nSteps, (nSteps + 1), minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context926 = new ConstructorContext(AdamsMoultonIntegrator.class, 177, 7891, 9042);
        try {
        } finally {
            _bcornu_methode_context926.methodEnd();
        }
    }

    public AdamsMoultonIntegrator(final int nSteps, final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) throws IllegalArgumentException {
        super(AdamsMoultonIntegrator.METHOD_NAME, nSteps, (nSteps + 1), minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context927 = new ConstructorContext(AdamsMoultonIntegrator.class, 199, 9049, 10196);
        try {
        } finally {
            _bcornu_methode_context927.methodEnd();
        }
    }

    @Override
    public void integrate(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context4226 = new MethodContext(void.class, 211, 10204, 15895);
        try {
            CallChecker.varInit(this, "this", 211, 10204, 15895);
            CallChecker.varInit(t, "t", 211, 10204, 15895);
            CallChecker.varInit(equations, "equations", 211, 10204, 15895);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 211, 10204, 15895);
            CallChecker.varInit(this.isLastStep, "isLastStep", 211, 10204, 15895);
            CallChecker.varInit(this.stepSize, "stepSize", 211, 10204, 15895);
            CallChecker.varInit(this.stepStart, "stepStart", 211, 10204, 15895);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 211, 10204, 15895);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 211, 10204, 15895);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 211, 10204, 15895);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 211, 10204, 15895);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 211, 10204, 15895);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 211, 10204, 15895);
            CallChecker.varInit(this.nordsieck, "nordsieck", 211, 10204, 15895);
            CallChecker.varInit(this.scaled, "scaled", 211, 10204, 15895);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.AdamsMoultonIntegrator.METHOD_NAME", 211, 10204, 15895);
            sanityChecks(equations, t);
            setEquations(equations);
            final boolean forward = CallChecker.varInit(((boolean) (t > (CallChecker.isCalled(equations, ExpandableStatefulODE.class, 217, 10561, 10569).getTime()))), "forward", 217, 10533, 10580);
            final double[] y0 = CallChecker.varInit(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 220, 10650, 10658).getCompleteState(), "y0", 220, 10628, 10678);
            final double[] y = CallChecker.varInit(CallChecker.isCalled(y0, double[].class, 221, 10710, 10711).clone(), "y", 221, 10688, 10720);
            final double[] yDot = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 222, 10763, 10763).length], "yDot", 222, 10730, 10772);
            final double[] yTmp = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 223, 10815, 10815).length], "yTmp", 223, 10782, 10824);
            final double[] predictedScaled = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 224, 10878, 10878).length], "predictedScaled", 224, 10834, 10887);
            Array2DRowRealMatrix nordsieckTmp = CallChecker.varInit(null, "nordsieckTmp", 225, 10897, 10937);
            final NordsieckStepInterpolator interpolator = CallChecker.varInit(new NordsieckStepInterpolator(), "interpolator", 228, 10948, 11092);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 230, 11174, 11182)) {
                if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 230, 11204, 11212)) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 229, 11102, 11113)) {
                        CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 229, 11102, 11113).reinitialize(y, forward, CallChecker.isCalled(equations, ExpandableStatefulODE.class, 230, 11174, 11182).getPrimaryMapper(), CallChecker.isCalled(equations, ExpandableStatefulODE.class, 230, 11204, 11212).getSecondaryMappers());
                    }
                }
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 233, 11309, 11317)) {
                initIntegration(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 233, 11309, 11317).getTime(), y0, t);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 236, 11441, 11449)) {
                start(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 236, 11441, 11449).getTime(), y, t);
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 237, 11477, 11488)) {
                CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 237, 11477, 11488).reinitialize(stepStart, stepSize, scaled, nordsieck);
            }
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 238, 11552, 11563)) {
                CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 238, 11552, 11563).storeTime(stepStart);
            }
            double hNew = CallChecker.varInit(((double) (this.stepSize)), "hNew", 240, 11596, 11618);
            if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 241, 11628, 11639)) {
                CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 241, 11628, 11639).rescale(hNew);
            }
            isLastStep = false;
            CallChecker.varAssign(this.isLastStep, "this.isLastStep", 243, 11665, 11683);
            do {
                double error = CallChecker.varInit(((double) (10)), "error", 246, 11711, 11728);
                while (error >= 1.0) {
                    stepSize = hNew;
                    CallChecker.varAssign(this.stepSize, "this.stepSize", 249, 11782, 11797);
                    final double stepEnd = CallChecker.varInit(((double) ((this.stepStart) + (this.stepSize))), "stepEnd", 252, 11816, 11953);
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 253, 11971, 11982)) {
                        CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 253, 11971, 11982).setInterpolatedTime(stepEnd);
                    }
                    final ExpandableStatefulODE expandable = CallChecker.varInit(getExpandable(), "expandable", 254, 12030, 12086);
                    final EquationsMapper primary = CallChecker.varInit(CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 255, 12136, 12145).getPrimaryMapper(), "primary", 255, 12104, 12165);
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 256, 12210, 12221)) {
                        if (CallChecker.beforeDeref(primary, EquationsMapper.class, 256, 12183, 12189)) {
                            CallChecker.isCalled(primary, EquationsMapper.class, 256, 12183, 12189).insertEquationData(CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 256, 12210, 12221).getInterpolatedState(), yTmp);
                        }
                    }
                    int index = CallChecker.varInit(((int) (0)), "index", 257, 12270, 12283);
                    for (final EquationsMapper secondary : CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 258, 12340, 12349).getSecondaryMappers()) {
                        if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 259, 12425, 12436)) {
                            if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 259, 12396, 12404)) {
                                CallChecker.isCalled(secondary, EquationsMapper.class, 259, 12396, 12404).insertEquationData(CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 259, 12425, 12436).getInterpolatedSecondaryState(index), yTmp);
                            }
                        }
                        ++index;
                    }
                    computeDerivatives(stepEnd, yTmp, yDot);
                    for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 267, 12762, 12763).length); ++j) {
                        if (CallChecker.beforeDeref(predictedScaled, double[].class, 268, 12800, 12814)) {
                            if (CallChecker.beforeDeref(yDot, double[].class, 268, 12832, 12835)) {
                                CallChecker.isCalled(predictedScaled, double[].class, 268, 12800, 12814)[j] = (stepSize) * (CallChecker.isCalled(yDot, double[].class, 268, 12832, 12835)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(predictedScaled, double[].class, 268, 12800, 12814)[j], "CallChecker.isCalled(predictedScaled, double[].class, 268, 12800, 12814)[j]", 268, 12800, 12839);
                            }
                        }
                    }
                    nordsieckTmp = updateHighOrderDerivativesPhase1(nordsieck);
                    CallChecker.varAssign(nordsieckTmp, "nordsieckTmp", 270, 12875, 12933);
                    updateHighOrderDerivativesPhase2(scaled, predictedScaled, nordsieckTmp);
                    if (CallChecker.beforeDeref(nordsieckTmp, Array2DRowRealMatrix.class, 274, 13110, 13121)) {
                        nordsieckTmp = CallChecker.beforeCalled(nordsieckTmp, Array2DRowRealMatrix.class, 274, 13110, 13121);
                        error = CallChecker.isCalled(nordsieckTmp, Array2DRowRealMatrix.class, 274, 13110, 13121).walkInOptimizedOrder(new AdamsMoultonIntegrator.Corrector(y, predictedScaled, yTmp));
                        CallChecker.varAssign(error, "error", 274, 13102, 13184);
                    }
                    if (error >= 1.0) {
                        final double factor = CallChecker.varInit(((double) (computeStepGrowShrinkFactor(error))), "factor", 278, 13243, 13386);
                        hNew = filterStep(((stepSize) * factor), forward, false);
                        CallChecker.varAssign(hNew, "hNew", 279, 13408, 13460);
                        if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 280, 13482, 13493)) {
                            CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 280, 13482, 13493).rescale(hNew);
                        }
                    }
                } 
                final double stepEnd = CallChecker.varInit(((double) ((this.stepStart) + (this.stepSize))), "stepEnd", 285, 13555, 13689);
                computeDerivatives(stepEnd, yTmp, yDot);
                final double[] correctedScaled = CallChecker.varInit(new double[CallChecker.isCalled(y0, double[].class, 289, 13840, 13841).length], "correctedScaled", 289, 13796, 13850);
                for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 290, 13884, 13885).length); ++j) {
                    if (CallChecker.beforeDeref(correctedScaled, double[].class, 291, 13918, 13932)) {
                        if (CallChecker.beforeDeref(yDot, double[].class, 291, 13950, 13953)) {
                            CallChecker.isCalled(correctedScaled, double[].class, 291, 13918, 13932)[j] = (stepSize) * (CallChecker.isCalled(yDot, double[].class, 291, 13950, 13953)[j]);
                            CallChecker.varAssign(CallChecker.isCalled(correctedScaled, double[].class, 291, 13918, 13932)[j], "CallChecker.isCalled(correctedScaled, double[].class, 291, 13918, 13932)[j]", 291, 13918, 13957);
                        }
                    }
                }
                updateHighOrderDerivativesPhase2(predictedScaled, correctedScaled, nordsieckTmp);
                if (CallChecker.beforeDeref(y, double[].class, 296, 14152, 14152)) {
                    System.arraycopy(yTmp, 0, y, 0, CallChecker.isCalled(y, double[].class, 296, 14152, 14152).length);
                }
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 297, 14175, 14186)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 297, 14175, 14186).reinitialize(stepEnd, stepSize, correctedScaled, nordsieckTmp);
                }
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 298, 14264, 14275)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 298, 14264, 14275).storeTime(stepStart);
                }
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 299, 14311, 14322)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 299, 14311, 14322).shift();
                }
                if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 300, 14345, 14356)) {
                    CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 300, 14345, 14356).storeTime(stepEnd);
                }
                stepStart = acceptStep(interpolator, y, yDot, t);
                CallChecker.varAssign(this.stepStart, "this.stepStart", 301, 14390, 14438);
                scaled = correctedScaled;
                CallChecker.varAssign(this.scaled, "this.scaled", 302, 14452, 14479);
                nordsieck = nordsieckTmp;
                CallChecker.varAssign(this.nordsieck, "this.nordsieck", 303, 14493, 14517);
                if (!(isLastStep)) {
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 308, 14605, 14616)) {
                        CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 308, 14605, 14616).storeTime(stepStart);
                    }
                    if (resetOccurred) {
                        start(stepStart, y, t);
                        if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 314, 14895, 14906)) {
                            CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 314, 14895, 14906).reinitialize(stepStart, stepSize, scaled, nordsieck);
                        }
                    }
                    final double factor = CallChecker.varInit(((double) (computeStepGrowShrinkFactor(error))), "factor", 319, 14998, 15109);
                    final double scaledH = CallChecker.varInit(((double) ((this.stepSize) * factor)), "scaledH", 320, 15127, 15171);
                    final double nextT = CallChecker.varInit(((double) ((this.stepStart) + scaledH)), "nextT", 321, 15189, 15235);
                    boolean nextIsLast = CallChecker.init(boolean.class);
                    if (forward) {
                        nextIsLast = nextT >= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 322, 15280, 15316);
                    }else {
                        nextIsLast = nextT <= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 322, 15280, 15316);
                    }
                    hNew = filterStep(scaledH, forward, nextIsLast);
                    CallChecker.varAssign(hNew, "hNew", 323, 15335, 15382);
                    final double filteredNextT = CallChecker.varInit(((double) ((this.stepStart) + hNew)), "filteredNextT", 325, 15401, 15452);
                    boolean filteredNextIsLast = CallChecker.init(boolean.class);
                    if (forward) {
                        filteredNextIsLast = filteredNextT >= t;
                        CallChecker.varAssign(filteredNextIsLast, "filteredNextIsLast", 326, 15505, 15557);
                    }else {
                        filteredNextIsLast = filteredNextT <= t;
                        CallChecker.varAssign(filteredNextIsLast, "filteredNextIsLast", 326, 15505, 15557);
                    }
                    if (filteredNextIsLast) {
                        hNew = t - (stepStart);
                        CallChecker.varAssign(hNew, "hNew", 328, 15622, 15642);
                    }
                    if (CallChecker.beforeDeref(interpolator, NordsieckStepInterpolator.class, 331, 15679, 15690)) {
                        CallChecker.isCalled(interpolator, NordsieckStepInterpolator.class, 331, 15679, 15690).rescale(hNew);
                    }
                }
            } while (!(isLastStep) );
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 337, 15790, 15798)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 337, 15790, 15798).setTime(stepStart);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 338, 15828, 15836)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 338, 15828, 15836).setCompleteState(y);
            }
            resetInternalState();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4226.methodEnd();
        }
    }
}

