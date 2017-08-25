package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.util.FastMath;

public abstract class EmbeddedRungeKuttaIntegrator extends AdaptiveStepsizeIntegrator {
    private final boolean fsal;

    private final double[] c;

    private final double[][] a;

    private final double[] b;

    private final RungeKuttaStepInterpolator prototype;

    private final double exp;

    private double safety;

    private double minReduction;

    private double maxGrowth;

    protected EmbeddedRungeKuttaIntegrator(final String name, final boolean fsal, final double[] c, final double[][] a, final double[] b, final RungeKuttaStepInterpolator prototype, final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) {
        super(name, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context179 = new ConstructorContext(EmbeddedRungeKuttaIntegrator.class, 110, 3457, 5241);
        try {
            this.fsal = fsal;
            CallChecker.varAssign(this.fsal, "this.fsal", 119, 4944, 4965);
            this.c = c;
            CallChecker.varAssign(this.c, "this.c", 120, 4971, 4989);
            this.a = a;
            CallChecker.varAssign(this.a, "this.a", 121, 4995, 5013);
            this.b = b;
            CallChecker.varAssign(this.b, "this.b", 122, 5019, 5037);
            this.prototype = prototype;
            CallChecker.varAssign(this.prototype, "this.prototype", 123, 5043, 5069);
            exp = (-1.0) / (getOrder());
            CallChecker.varAssign(this.exp, "this.exp", 125, 5076, 5099);
            setSafety(0.9);
            setMinReduction(0.2);
            setMaxGrowth(10.0);
        } finally {
            _bcornu_methode_context179.methodEnd();
        }
    }

    protected EmbeddedRungeKuttaIntegrator(final String name, final boolean fsal, final double[] c, final double[][] a, final double[] b, final RungeKuttaStepInterpolator prototype, final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) {
        super(name, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context180 = new ConstructorContext(EmbeddedRungeKuttaIntegrator.class, 148, 5246, 6920);
        try {
            this.fsal = fsal;
            CallChecker.varAssign(this.fsal, "this.fsal", 157, 6623, 6644);
            this.c = c;
            CallChecker.varAssign(this.c, "this.c", 158, 6650, 6668);
            this.a = a;
            CallChecker.varAssign(this.a, "this.a", 159, 6674, 6692);
            this.b = b;
            CallChecker.varAssign(this.b, "this.b", 160, 6698, 6716);
            this.prototype = prototype;
            CallChecker.varAssign(this.prototype, "this.prototype", 161, 6722, 6748);
            exp = (-1.0) / (getOrder());
            CallChecker.varAssign(this.exp, "this.exp", 163, 6755, 6778);
            setSafety(0.9);
            setMinReduction(0.2);
            setMaxGrowth(10.0);
        } finally {
            _bcornu_methode_context180.methodEnd();
        }
    }

    public abstract int getOrder();

    public double getSafety() {
        MethodContext _bcornu_methode_context666 = new MethodContext(double.class, 180, 7034, 7166);
        try {
            CallChecker.varInit(this, "this", 180, 7034, 7166);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 180, 7034, 7166);
            CallChecker.varInit(this.isLastStep, "isLastStep", 180, 7034, 7166);
            CallChecker.varInit(this.stepSize, "stepSize", 180, 7034, 7166);
            CallChecker.varInit(this.stepStart, "stepStart", 180, 7034, 7166);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 180, 7034, 7166);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 180, 7034, 7166);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 180, 7034, 7166);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 180, 7034, 7166);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 180, 7034, 7166);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 180, 7034, 7166);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 180, 7034, 7166);
            CallChecker.varInit(this.minReduction, "minReduction", 180, 7034, 7166);
            CallChecker.varInit(this.safety, "safety", 180, 7034, 7166);
            CallChecker.varInit(this.exp, "exp", 180, 7034, 7166);
            CallChecker.varInit(this.prototype, "prototype", 180, 7034, 7166);
            CallChecker.varInit(this.b, "b", 180, 7034, 7166);
            CallChecker.varInit(this.a, "a", 180, 7034, 7166);
            CallChecker.varInit(this.c, "c", 180, 7034, 7166);
            CallChecker.varInit(this.fsal, "fsal", 180, 7034, 7166);
            return safety;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context666.methodEnd();
        }
    }

    public void setSafety(final double safety) {
        MethodContext _bcornu_methode_context667 = new MethodContext(void.class, 187, 7171, 7333);
        try {
            CallChecker.varInit(this, "this", 187, 7171, 7333);
            CallChecker.varInit(safety, "safety", 187, 7171, 7333);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 187, 7171, 7333);
            CallChecker.varInit(this.isLastStep, "isLastStep", 187, 7171, 7333);
            CallChecker.varInit(this.stepSize, "stepSize", 187, 7171, 7333);
            CallChecker.varInit(this.stepStart, "stepStart", 187, 7171, 7333);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 187, 7171, 7333);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 187, 7171, 7333);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 187, 7171, 7333);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 187, 7171, 7333);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 187, 7171, 7333);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 187, 7171, 7333);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 187, 7171, 7333);
            CallChecker.varInit(this.minReduction, "minReduction", 187, 7171, 7333);
            CallChecker.varInit(this.safety, "safety", 187, 7171, 7333);
            CallChecker.varInit(this.exp, "exp", 187, 7171, 7333);
            CallChecker.varInit(this.prototype, "prototype", 187, 7171, 7333);
            CallChecker.varInit(this.b, "b", 187, 7171, 7333);
            CallChecker.varInit(this.a, "a", 187, 7171, 7333);
            CallChecker.varInit(this.c, "c", 187, 7171, 7333);
            CallChecker.varInit(this.fsal, "fsal", 187, 7171, 7333);
            this.safety = safety;
            CallChecker.varAssign(this.safety, "this.safety", 188, 7309, 7329);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context667.methodEnd();
        }
    }

    @Override
    public void integrate(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context668 = new MethodContext(void.class, 193, 7338, 12523);
        try {
            CallChecker.varInit(this, "this", 193, 7338, 12523);
            CallChecker.varInit(t, "t", 193, 7338, 12523);
            CallChecker.varInit(equations, "equations", 193, 7338, 12523);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 193, 7338, 12523);
            CallChecker.varInit(this.isLastStep, "isLastStep", 193, 7338, 12523);
            CallChecker.varInit(this.stepSize, "stepSize", 193, 7338, 12523);
            CallChecker.varInit(this.stepStart, "stepStart", 193, 7338, 12523);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 193, 7338, 12523);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 193, 7338, 12523);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 193, 7338, 12523);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 193, 7338, 12523);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 193, 7338, 12523);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 193, 7338, 12523);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 193, 7338, 12523);
            CallChecker.varInit(this.minReduction, "minReduction", 193, 7338, 12523);
            CallChecker.varInit(this.safety, "safety", 193, 7338, 12523);
            CallChecker.varInit(this.exp, "exp", 193, 7338, 12523);
            CallChecker.varInit(this.prototype, "prototype", 193, 7338, 12523);
            CallChecker.varInit(this.b, "b", 193, 7338, 12523);
            CallChecker.varInit(this.a, "a", 193, 7338, 12523);
            CallChecker.varInit(this.c, "c", 193, 7338, 12523);
            CallChecker.varInit(this.fsal, "fsal", 193, 7338, 12523);
            sanityChecks(equations, t);
            setEquations(equations);
            final boolean forward = CallChecker.varInit(((boolean) (t > (CallChecker.isCalled(equations, ExpandableStatefulODE.class, 199, 7676, 7684).getTime()))), "forward", 199, 7648, 7695);
            final double[] y0 = CallChecker.varInit(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 202, 7766, 7774).getCompleteState(), "y0", 202, 7745, 7794);
            final double[] y = CallChecker.varInit(CallChecker.isCalled(y0, double[].class, 203, 7819, 7820).clone(), "y", 203, 7800, 7829);
            final int stages = CallChecker.varInit(((int) ((CallChecker.isCalled(this.c, double[].class, 204, 7854, 7854).length) + 1)), "stages", 204, 7835, 7866);
            final double[][] yDotK = CallChecker.varInit(new double[stages][CallChecker.isCalled(y, double[].class, 205, 7916, 7916).length], "yDotK", 205, 7872, 7925);
            final double[] yTmp = CallChecker.varInit(CallChecker.isCalled(y0, double[].class, 206, 7956, 7957).clone(), "yTmp", 206, 7931, 7966);
            final double[] yDotTmp = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 207, 8008, 8008).length], "yDotTmp", 207, 7972, 8017);
            final RungeKuttaStepInterpolator interpolator = CallChecker.varInit(((RungeKuttaStepInterpolator) (CallChecker.isCalled(prototype, RungeKuttaStepInterpolator.class, 210, 8161, 8169).copy())), "interpolator", 210, 8024, 8177);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 212, 8267, 8275)) {
                if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 212, 8297, 8305)) {
                    if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 211, 8183, 8194)) {
                        CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 211, 8183, 8194).reinitialize(this, yTmp, yDotK, forward, CallChecker.isCalled(equations, ExpandableStatefulODE.class, 212, 8267, 8275).getPrimaryMapper(), CallChecker.isCalled(equations, ExpandableStatefulODE.class, 212, 8297, 8305).getSecondaryMappers());
                    }
                }
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 213, 8358, 8366)) {
                if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 213, 8335, 8346)) {
                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 213, 8335, 8346).storeTime(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 213, 8358, 8366).getTime());
                }
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 216, 8447, 8455)) {
                stepStart = CallChecker.isCalled(equations, ExpandableStatefulODE.class, 216, 8447, 8455).getTime();
                CallChecker.varAssign(this.stepStart, "this.stepStart", 216, 8427, 8466);
            }
            double hNew = CallChecker.varInit(((double) (0)), "hNew", 217, 8472, 8493);
            boolean firstTime = CallChecker.varInit(((boolean) (true)), "firstTime", 218, 8499, 8523);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 219, 8545, 8553)) {
                initIntegration(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 219, 8545, 8553).getTime(), y0, t);
            }
            isLastStep = false;
            CallChecker.varAssign(this.isLastStep, "this.isLastStep", 222, 8608, 8626);
            do {
                if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 225, 8644, 8655)) {
                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 225, 8644, 8655).shift();
                }
                double error = CallChecker.varInit(((double) (10)), "error", 228, 8756, 8773);
                while (error >= 1.0) {
                    if (firstTime || (!(fsal))) {
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 233, 8907, 8911)) {
                            computeDerivatives(stepStart, y, CallChecker.isCalled(yDotK, double[][].class, 233, 8907, 8911)[0]);
                        }
                    }
                    if (firstTime) {
                        final double[] scale = CallChecker.varInit(new double[mainSetDimension], "scale", 237, 8964, 9015);
                        if ((vecAbsoluteTolerance) == null) {
                            for (int i = 0; i < (CallChecker.isCalled(scale, double[].class, 239, 9097, 9101).length); ++i) {
                                if (CallChecker.beforeDeref(scale, double[].class, 240, 9134, 9138)) {
                                    if (CallChecker.beforeDeref(y, double[].class, 240, 9206, 9206)) {
                                        CallChecker.isCalled(scale, double[].class, 240, 9134, 9138)[i] = (scalAbsoluteTolerance) + ((scalRelativeTolerance) * (FastMath.abs(CallChecker.isCalled(y, double[].class, 240, 9206, 9206)[i])));
                                        CallChecker.varAssign(CallChecker.isCalled(scale, double[].class, 240, 9134, 9138)[i], "CallChecker.isCalled(scale, double[].class, 240, 9134, 9138)[i]", 240, 9134, 9211);
                                    }
                                }
                            }
                        }else {
                            for (int i = 0; i < (CallChecker.isCalled(scale, double[].class, 243, 9282, 9286).length); ++i) {
                                if (CallChecker.beforeDeref(scale, double[].class, 244, 9319, 9323)) {
                                    if (CallChecker.beforeDeref(vecRelativeTolerance, double[].class, 244, 9356, 9375)) {
                                        if (CallChecker.beforeDeref(y, double[].class, 244, 9395, 9395)) {
                                            vecRelativeTolerance = CallChecker.beforeCalled(vecRelativeTolerance, double[].class, 244, 9356, 9375);
                                            CallChecker.isCalled(scale, double[].class, 244, 9319, 9323)[i] = (vecAbsoluteTolerance[i]) + ((CallChecker.isCalled(vecRelativeTolerance, double[].class, 244, 9356, 9375)[i]) * (FastMath.abs(CallChecker.isCalled(y, double[].class, 244, 9395, 9395)[i])));
                                            CallChecker.varAssign(CallChecker.isCalled(scale, double[].class, 244, 9319, 9323)[i], "CallChecker.isCalled(scale, double[].class, 244, 9319, 9323)[i]", 244, 9319, 9400);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 248, 9536, 9540)) {
                            if (CallChecker.beforeDeref(yDotK, double[][].class, 248, 9552, 9556)) {
                                hNew = initializeStep(forward, getOrder(), scale, stepStart, y, CallChecker.isCalled(yDotK, double[][].class, 248, 9536, 9540)[0], yTmp, CallChecker.isCalled(yDotK, double[][].class, 248, 9552, 9556)[1]);
                                CallChecker.varAssign(hNew, "hNew", 247, 9440, 9561);
                            }
                        }
                        firstTime = false;
                        CallChecker.varAssign(firstTime, "firstTime", 249, 9573, 9590);
                    }
                    stepSize = hNew;
                    CallChecker.varAssign(this.stepSize, "this.stepSize", 252, 9611, 9626);
                    if (forward) {
                        if (((stepStart) + (stepSize)) >= t) {
                            stepSize = t - (stepStart);
                            CallChecker.varAssign(this.stepSize, "this.stepSize", 255, 9712, 9736);
                        }
                    }else {
                        if (((stepStart) + (stepSize)) <= t) {
                            stepSize = t - (stepStart);
                            CallChecker.varAssign(this.stepSize, "this.stepSize", 259, 9830, 9854);
                        }
                    }
                    for (int k = 1; k < stages; ++k) {
                        for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 266, 9978, 9979).length); ++j) {
                            double sum = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(a, double[][].class, 267, 10021, 10021)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(a, double[][].class, 267, 10021, 10021)[(k - 1)], double[].class, 267, 10021, 10026)) {
                                    if (CallChecker.beforeDeref(yDotK, double[][].class, 267, 10033, 10037)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 267, 10033, 10037)[0], double[].class, 267, 10033, 10040)) {
                                            CallChecker.isCalled(a, double[][].class, 267, 10021, 10021)[(k - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][].class, 267, 10021, 10021)[(k - 1)], double[].class, 267, 10021, 10026);
                                            CallChecker.isCalled(yDotK, double[][].class, 267, 10033, 10037)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 267, 10033, 10037)[0], double[].class, 267, 10033, 10040);
                                            sum = (CallChecker.isCalled(CallChecker.isCalled(a, double[][].class, 267, 10021, 10021)[(k - 1)], double[].class, 267, 10021, 10026)[0]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 267, 10033, 10037)[0], double[].class, 267, 10033, 10040)[j]);
                                            CallChecker.varAssign(sum, "sum", 267, 10021, 10021);
                                        }
                                    }
                                }
                            }
                            for (int l = 1; l < k; ++l) {
                                if (CallChecker.beforeDeref(a, double[][].class, 269, 10109, 10109)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, double[][].class, 269, 10109, 10109)[(k - 1)], double[].class, 269, 10109, 10114)) {
                                        if (CallChecker.beforeDeref(yDotK, double[][].class, 269, 10121, 10125)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 269, 10121, 10125)[l], double[].class, 269, 10121, 10128)) {
                                                CallChecker.isCalled(a, double[][].class, 269, 10109, 10109)[(k - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][].class, 269, 10109, 10109)[(k - 1)], double[].class, 269, 10109, 10114);
                                                CallChecker.isCalled(yDotK, double[][].class, 269, 10121, 10125)[l] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 269, 10121, 10125)[l], double[].class, 269, 10121, 10128);
                                                sum += (CallChecker.isCalled(CallChecker.isCalled(a, double[][].class, 269, 10109, 10109)[(k - 1)], double[].class, 269, 10109, 10114)[l]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 269, 10121, 10125)[l], double[].class, 269, 10121, 10128)[j]);
                                                CallChecker.varAssign(sum, "sum", 269, 10102, 10132);
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(yTmp, double[].class, 271, 10160, 10163)) {
                                if (CallChecker.beforeDeref(y, double[].class, 271, 10170, 10170)) {
                                    CallChecker.isCalled(yTmp, double[].class, 271, 10160, 10163)[j] = (CallChecker.isCalled(y, double[].class, 271, 10170, 10170)[j]) + ((stepSize) * sum);
                                    CallChecker.varAssign(CallChecker.isCalled(yTmp, double[].class, 271, 10160, 10163)[j], "CallChecker.isCalled(yTmp, double[].class, 271, 10160, 10163)[j]", 271, 10160, 10191);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(c, double[].class, 274, 10247, 10247)) {
                            if (CallChecker.beforeDeref(yDotK, double[][].class, 274, 10272, 10276)) {
                                computeDerivatives(((stepStart) + ((CallChecker.isCalled(c, double[].class, 274, 10247, 10247)[(k - 1)]) * (stepSize))), yTmp, CallChecker.isCalled(yDotK, double[][].class, 274, 10272, 10276)[k]);
                            }
                        }
                    }
                    for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 279, 10376, 10377).length); ++j) {
                        double sum = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(b, double[].class, 280, 10420, 10420)) {
                            if (CallChecker.beforeDeref(yDotK, double[][].class, 280, 10427, 10431)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 280, 10427, 10431)[0], double[].class, 280, 10427, 10434)) {
                                    CallChecker.isCalled(yDotK, double[][].class, 280, 10427, 10431)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 280, 10427, 10431)[0], double[].class, 280, 10427, 10434);
                                    sum = (CallChecker.isCalled(b, double[].class, 280, 10420, 10420)[0]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 280, 10427, 10431)[0], double[].class, 280, 10427, 10434)[j]);
                                    CallChecker.varAssign(sum, "sum", 280, 10420, 10420);
                                }
                            }
                        }
                        for (int l = 1; l < stages; ++l) {
                            if (CallChecker.beforeDeref(b, double[].class, 282, 10507, 10507)) {
                                if (CallChecker.beforeDeref(yDotK, double[][].class, 282, 10514, 10518)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 282, 10514, 10518)[l], double[].class, 282, 10514, 10521)) {
                                        CallChecker.isCalled(yDotK, double[][].class, 282, 10514, 10518)[l] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 282, 10514, 10518)[l], double[].class, 282, 10514, 10521);
                                        sum += (CallChecker.isCalled(b, double[].class, 282, 10507, 10507)[l]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 282, 10514, 10518)[l], double[].class, 282, 10514, 10521)[j]);
                                        CallChecker.varAssign(sum, "sum", 282, 10497, 10525);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(yTmp, double[].class, 284, 10549, 10552)) {
                            if (CallChecker.beforeDeref(y, double[].class, 284, 10559, 10559)) {
                                CallChecker.isCalled(yTmp, double[].class, 284, 10549, 10552)[j] = (CallChecker.isCalled(y, double[].class, 284, 10559, 10559)[j]) + ((stepSize) * sum);
                                CallChecker.varAssign(CallChecker.isCalled(yTmp, double[].class, 284, 10549, 10552)[j], "CallChecker.isCalled(yTmp, double[].class, 284, 10549, 10552)[j]", 284, 10549, 10580);
                            }
                        }
                    }
                    error = estimateError(yDotK, y, yTmp, stepSize);
                    CallChecker.varAssign(error, "error", 288, 10654, 10701);
                    if (error >= 1.0) {
                        final double factor = CallChecker.varInit(((double) (FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, ((this.safety) * (FastMath.pow(error, this.exp))))))), "factor", 291, 10741, 10967);
                        hNew = filterStep(((stepSize) * factor), forward, false);
                        CallChecker.varAssign(hNew, "hNew", 294, 10979, 11031);
                    }
                } 
                if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 300, 11147, 11158)) {
                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 300, 11147, 11158).storeTime(((stepStart) + (stepSize)));
                }
                if (CallChecker.beforeDeref(y0, double[].class, 301, 11231, 11232)) {
                    System.arraycopy(yTmp, 0, y, 0, CallChecker.isCalled(y0, double[].class, 301, 11231, 11232).length);
                }
                if (CallChecker.beforeDeref(yDotK, double[][].class, 302, 11266, 11270)) {
                    if (CallChecker.beforeDeref(y0, double[].class, 302, 11300, 11301)) {
                        System.arraycopy(CallChecker.isCalled(yDotK, double[][].class, 302, 11266, 11270)[(stages - 1)], 0, yDotTmp, 0, CallChecker.isCalled(y0, double[].class, 302, 11300, 11301).length);
                    }
                }
                stepStart = acceptStep(interpolator, y, yDotTmp, t);
                CallChecker.varAssign(this.stepStart, "this.stepStart", 303, 11318, 11369);
                if (CallChecker.beforeDeref(y, double[].class, 304, 11409, 11409)) {
                    System.arraycopy(y, 0, yTmp, 0, CallChecker.isCalled(y, double[].class, 304, 11409, 11409).length);
                }
                if (!(isLastStep)) {
                    if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 309, 11488, 11499)) {
                        CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 309, 11488, 11499).storeTime(stepStart);
                    }
                    if (fsal) {
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 313, 11649, 11653)) {
                            if (CallChecker.beforeDeref(y0, double[].class, 313, 11662, 11663)) {
                                System.arraycopy(yDotTmp, 0, CallChecker.isCalled(yDotK, double[][].class, 313, 11649, 11653)[0], 0, CallChecker.isCalled(y0, double[].class, 313, 11662, 11663).length);
                            }
                        }
                    }
                    final double factor = CallChecker.varInit(((double) (FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, ((this.safety) * (FastMath.pow(error, this.exp))))))), "factor", 317, 11697, 11863);
                    final double scaledH = CallChecker.varInit(((double) ((this.stepSize) * factor)), "scaledH", 319, 11875, 11919);
                    final double nextT = CallChecker.varInit(((double) ((this.stepStart) + scaledH)), "nextT", 320, 11931, 11977);
                    boolean nextIsLast = CallChecker.init(boolean.class);
                    if (forward) {
                        nextIsLast = nextT >= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 321, 12016, 12052);
                    }else {
                        nextIsLast = nextT <= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 321, 12016, 12052);
                    }
                    hNew = filterStep(scaledH, forward, nextIsLast);
                    CallChecker.varAssign(hNew, "hNew", 322, 12065, 12112);
                    final double filteredNextT = CallChecker.varInit(((double) ((this.stepStart) + hNew)), "filteredNextT", 324, 12125, 12176);
                    boolean filteredNextIsLast = CallChecker.init(boolean.class);
                    if (forward) {
                        filteredNextIsLast = filteredNextT >= t;
                        CallChecker.varAssign(filteredNextIsLast, "filteredNextIsLast", 325, 12223, 12275);
                    }else {
                        filteredNextIsLast = filteredNextT <= t;
                        CallChecker.varAssign(filteredNextIsLast, "filteredNextIsLast", 325, 12223, 12275);
                    }
                    if (filteredNextIsLast) {
                        hNew = t - (stepStart);
                        CallChecker.varAssign(hNew, "hNew", 327, 12328, 12348);
                    }
                }
            } while (!(isLastStep) );
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 335, 12428, 12436)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 335, 12428, 12436).setTime(stepStart);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 336, 12462, 12470)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 336, 12462, 12470).setCompleteState(y);
            }
            resetInternalState();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context668.methodEnd();
        }
    }

    public double getMinReduction() {
        MethodContext _bcornu_methode_context669 = new MethodContext(double.class, 345, 12528, 12694);
        try {
            CallChecker.varInit(this, "this", 345, 12528, 12694);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 345, 12528, 12694);
            CallChecker.varInit(this.isLastStep, "isLastStep", 345, 12528, 12694);
            CallChecker.varInit(this.stepSize, "stepSize", 345, 12528, 12694);
            CallChecker.varInit(this.stepStart, "stepStart", 345, 12528, 12694);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 345, 12528, 12694);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 345, 12528, 12694);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 345, 12528, 12694);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 345, 12528, 12694);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 345, 12528, 12694);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 345, 12528, 12694);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 345, 12528, 12694);
            CallChecker.varInit(this.minReduction, "minReduction", 345, 12528, 12694);
            CallChecker.varInit(this.safety, "safety", 345, 12528, 12694);
            CallChecker.varInit(this.exp, "exp", 345, 12528, 12694);
            CallChecker.varInit(this.prototype, "prototype", 345, 12528, 12694);
            CallChecker.varInit(this.b, "b", 345, 12528, 12694);
            CallChecker.varInit(this.a, "a", 345, 12528, 12694);
            CallChecker.varInit(this.c, "c", 345, 12528, 12694);
            CallChecker.varInit(this.fsal, "fsal", 345, 12528, 12694);
            return minReduction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context669.methodEnd();
        }
    }

    public void setMinReduction(final double minReduction) {
        MethodContext _bcornu_methode_context670 = new MethodContext(void.class, 352, 12699, 12913);
        try {
            CallChecker.varInit(this, "this", 352, 12699, 12913);
            CallChecker.varInit(minReduction, "minReduction", 352, 12699, 12913);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 352, 12699, 12913);
            CallChecker.varInit(this.isLastStep, "isLastStep", 352, 12699, 12913);
            CallChecker.varInit(this.stepSize, "stepSize", 352, 12699, 12913);
            CallChecker.varInit(this.stepStart, "stepStart", 352, 12699, 12913);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 352, 12699, 12913);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 352, 12699, 12913);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 352, 12699, 12913);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 352, 12699, 12913);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 352, 12699, 12913);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 352, 12699, 12913);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 352, 12699, 12913);
            CallChecker.varInit(this.minReduction, "minReduction", 352, 12699, 12913);
            CallChecker.varInit(this.safety, "safety", 352, 12699, 12913);
            CallChecker.varInit(this.exp, "exp", 352, 12699, 12913);
            CallChecker.varInit(this.prototype, "prototype", 352, 12699, 12913);
            CallChecker.varInit(this.b, "b", 352, 12699, 12913);
            CallChecker.varInit(this.a, "a", 352, 12699, 12913);
            CallChecker.varInit(this.c, "c", 352, 12699, 12913);
            CallChecker.varInit(this.fsal, "fsal", 352, 12699, 12913);
            this.minReduction = minReduction;
            CallChecker.varAssign(this.minReduction, "this.minReduction", 353, 12877, 12909);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context670.methodEnd();
        }
    }

    public double getMaxGrowth() {
        MethodContext _bcornu_methode_context671 = new MethodContext(double.class, 359, 12918, 13072);
        try {
            CallChecker.varInit(this, "this", 359, 12918, 13072);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 359, 12918, 13072);
            CallChecker.varInit(this.isLastStep, "isLastStep", 359, 12918, 13072);
            CallChecker.varInit(this.stepSize, "stepSize", 359, 12918, 13072);
            CallChecker.varInit(this.stepStart, "stepStart", 359, 12918, 13072);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 359, 12918, 13072);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 359, 12918, 13072);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 359, 12918, 13072);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 359, 12918, 13072);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 359, 12918, 13072);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 359, 12918, 13072);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 359, 12918, 13072);
            CallChecker.varInit(this.minReduction, "minReduction", 359, 12918, 13072);
            CallChecker.varInit(this.safety, "safety", 359, 12918, 13072);
            CallChecker.varInit(this.exp, "exp", 359, 12918, 13072);
            CallChecker.varInit(this.prototype, "prototype", 359, 12918, 13072);
            CallChecker.varInit(this.b, "b", 359, 12918, 13072);
            CallChecker.varInit(this.a, "a", 359, 12918, 13072);
            CallChecker.varInit(this.c, "c", 359, 12918, 13072);
            CallChecker.varInit(this.fsal, "fsal", 359, 12918, 13072);
            return maxGrowth;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context671.methodEnd();
        }
    }

    public void setMaxGrowth(final double maxGrowth) {
        MethodContext _bcornu_methode_context672 = new MethodContext(void.class, 366, 13077, 13270);
        try {
            CallChecker.varInit(this, "this", 366, 13077, 13270);
            CallChecker.varInit(maxGrowth, "maxGrowth", 366, 13077, 13270);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 366, 13077, 13270);
            CallChecker.varInit(this.isLastStep, "isLastStep", 366, 13077, 13270);
            CallChecker.varInit(this.stepSize, "stepSize", 366, 13077, 13270);
            CallChecker.varInit(this.stepStart, "stepStart", 366, 13077, 13270);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 366, 13077, 13270);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 366, 13077, 13270);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 366, 13077, 13270);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 366, 13077, 13270);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 366, 13077, 13270);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 366, 13077, 13270);
            CallChecker.varInit(this.maxGrowth, "maxGrowth", 366, 13077, 13270);
            CallChecker.varInit(this.minReduction, "minReduction", 366, 13077, 13270);
            CallChecker.varInit(this.safety, "safety", 366, 13077, 13270);
            CallChecker.varInit(this.exp, "exp", 366, 13077, 13270);
            CallChecker.varInit(this.prototype, "prototype", 366, 13077, 13270);
            CallChecker.varInit(this.b, "b", 366, 13077, 13270);
            CallChecker.varInit(this.a, "a", 366, 13077, 13270);
            CallChecker.varInit(this.c, "c", 366, 13077, 13270);
            CallChecker.varInit(this.fsal, "fsal", 366, 13077, 13270);
            this.maxGrowth = maxGrowth;
            CallChecker.varAssign(this.maxGrowth, "this.maxGrowth", 367, 13240, 13266);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context672.methodEnd();
        }
    }

    protected abstract double estimateError(double[][] yDotK, double[] y0, double[] y1, double h);
}

