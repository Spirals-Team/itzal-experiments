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

public abstract class RungeKuttaIntegrator extends AbstractIntegrator {
    private final double[] c;

    private final double[][] a;

    private final double[] b;

    private final RungeKuttaStepInterpolator prototype;

    private final double step;

    protected RungeKuttaIntegrator(final String name, final double[] c, final double[][] a, final double[] b, final RungeKuttaStepInterpolator prototype, final double step) {
        super(name);
        ConstructorContext _bcornu_methode_context1122 = new ConstructorContext(RungeKuttaIntegrator.class, 81, 2419, 3353);
        try {
            this.c = c;
            CallChecker.varAssign(this.c, "this.c", 86, 3205, 3224);
            this.a = a;
            CallChecker.varAssign(this.a, "this.a", 87, 3230, 3249);
            this.b = b;
            CallChecker.varAssign(this.b, "this.b", 88, 3255, 3274);
            this.prototype = prototype;
            CallChecker.varAssign(this.prototype, "this.prototype", 89, 3280, 3307);
            this.step = FastMath.abs(step);
            CallChecker.varAssign(this.step, "this.step", 90, 3313, 3349);
        } finally {
            _bcornu_methode_context1122.methodEnd();
        }
    }

    @Override
    public void integrate(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5006 = new MethodContext(void.class, 95, 3358, 6360);
        try {
            CallChecker.varInit(this, "this", 95, 3358, 6360);
            CallChecker.varInit(t, "t", 95, 3358, 6360);
            CallChecker.varInit(equations, "equations", 95, 3358, 6360);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 95, 3358, 6360);
            CallChecker.varInit(this.isLastStep, "isLastStep", 95, 3358, 6360);
            CallChecker.varInit(this.stepSize, "stepSize", 95, 3358, 6360);
            CallChecker.varInit(this.stepStart, "stepStart", 95, 3358, 6360);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 95, 3358, 6360);
            CallChecker.varInit(this.step, "step", 95, 3358, 6360);
            CallChecker.varInit(this.prototype, "prototype", 95, 3358, 6360);
            CallChecker.varInit(this.b, "b", 95, 3358, 6360);
            CallChecker.varInit(this.a, "a", 95, 3358, 6360);
            CallChecker.varInit(this.c, "c", 95, 3358, 6360);
            sanityChecks(equations, t);
            setEquations(equations);
            final boolean forward = CallChecker.varInit(((boolean) (t > (CallChecker.isCalled(equations, ExpandableStatefulODE.class, 101, 3696, 3704).getTime()))), "forward", 101, 3668, 3715);
            final double[] y0 = CallChecker.varInit(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 104, 3790, 3798).getCompleteState(), "y0", 104, 3765, 3818);
            final double[] y = CallChecker.varInit(CallChecker.isCalled(y0, double[].class, 105, 3849, 3850).clone(), "y", 105, 3824, 3859);
            final int stages = CallChecker.varInit(((int) ((CallChecker.isCalled(this.c, double[].class, 106, 3890, 3890).length) + 1)), "stages", 106, 3865, 3902);
            final double[][] yDotK = CallChecker.varInit(new double[stages][], "yDotK", 107, 3908, 3953);
            for (int i = 0; i < stages; ++i) {
                if (CallChecker.beforeDeref(yDotK, double[][].class, 109, 4000, 4004)) {
                    if (CallChecker.beforeDeref(y0, double[].class, 109, 4023, 4024)) {
                        CallChecker.isCalled(yDotK, double[][].class, 109, 4000, 4004)[i] = new double[CallChecker.isCalled(y0, double[].class, 109, 4023, 4024).length];
                        CallChecker.varAssign(CallChecker.isCalled(yDotK, double[][].class, 109, 4000, 4004)[i], "CallChecker.isCalled(yDotK, double[][].class, 109, 4000, 4004)[i]", 109, 4000, 4033);
                    }
                }
            }
            final double[] yTmp = CallChecker.varInit(CallChecker.isCalled(y0, double[].class, 111, 4070, 4071).clone(), "yTmp", 111, 4045, 4080);
            final double[] yDotTmp = CallChecker.varInit(new double[CallChecker.isCalled(y0, double[].class, 112, 4122, 4123).length], "yDotTmp", 112, 4086, 4132);
            final RungeKuttaStepInterpolator interpolator = CallChecker.varInit(((RungeKuttaStepInterpolator) (CallChecker.isCalled(prototype, RungeKuttaStepInterpolator.class, 115, 4276, 4284).copy())), "interpolator", 115, 4139, 4292);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 117, 4382, 4390)) {
                if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 117, 4412, 4420)) {
                    if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 116, 4298, 4309)) {
                        CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 116, 4298, 4309).reinitialize(this, yTmp, yDotK, forward, CallChecker.isCalled(equations, ExpandableStatefulODE.class, 117, 4382, 4390).getPrimaryMapper(), CallChecker.isCalled(equations, ExpandableStatefulODE.class, 117, 4412, 4420).getSecondaryMappers());
                    }
                }
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 118, 4473, 4481)) {
                if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 118, 4450, 4461)) {
                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 118, 4450, 4461).storeTime(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 118, 4473, 4481).getTime());
                }
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 121, 4554, 4562)) {
                stepStart = CallChecker.isCalled(equations, ExpandableStatefulODE.class, 121, 4554, 4562).getTime();
                CallChecker.varAssign(this.stepStart, "this.stepStart", 121, 4542, 4573);
            }
            if (forward) {
                stepSize = step;
                CallChecker.varAssign(this.stepSize, "this.stepSize", 122, 4579, 4613);
            }else {
                stepSize = -(step);
                CallChecker.varAssign(this.stepSize, "this.stepSize", 122, 4579, 4613);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 123, 4635, 4643)) {
                initIntegration(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 123, 4635, 4643).getTime(), y0, t);
            }
            isLastStep = false;
            CallChecker.varAssign(this.isLastStep, "this.isLastStep", 126, 4698, 4716);
            do {
                if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 129, 4734, 4745)) {
                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 129, 4734, 4745).shift();
                }
                if (CallChecker.beforeDeref(yDotK, double[][].class, 132, 4817, 4821)) {
                    computeDerivatives(stepStart, y, CallChecker.isCalled(yDotK, double[][].class, 132, 4817, 4821)[0]);
                }
                for (int k = 1; k < stages; ++k) {
                    for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 137, 4922, 4923).length); ++j) {
                        double sum = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(a, double[][].class, 138, 4967, 4967)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(a, double[][].class, 138, 4967, 4967)[(k - 1)], double[].class, 138, 4967, 4972)) {
                                if (CallChecker.beforeDeref(yDotK, double[][].class, 138, 4979, 4983)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 138, 4979, 4983)[0], double[].class, 138, 4979, 4986)) {
                                        CallChecker.isCalled(a, double[][].class, 138, 4967, 4967)[(k - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][].class, 138, 4967, 4967)[(k - 1)], double[].class, 138, 4967, 4972);
                                        CallChecker.isCalled(yDotK, double[][].class, 138, 4979, 4983)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 138, 4979, 4983)[0], double[].class, 138, 4979, 4986);
                                        sum = (CallChecker.isCalled(CallChecker.isCalled(a, double[][].class, 138, 4967, 4967)[(k - 1)], double[].class, 138, 4967, 4972)[0]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 138, 4979, 4983)[0], double[].class, 138, 4979, 4986)[j]);
                                        CallChecker.varAssign(sum, "sum", 138, 4967, 4967);
                                    }
                                }
                            }
                        }
                        for (int l = 1; l < k; ++l) {
                            if (CallChecker.beforeDeref(a, double[][].class, 140, 5061, 5061)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(a, double[][].class, 140, 5061, 5061)[(k - 1)], double[].class, 140, 5061, 5066)) {
                                    if (CallChecker.beforeDeref(yDotK, double[][].class, 140, 5073, 5077)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 140, 5073, 5077)[l], double[].class, 140, 5073, 5080)) {
                                            CallChecker.isCalled(a, double[][].class, 140, 5061, 5061)[(k - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][].class, 140, 5061, 5061)[(k - 1)], double[].class, 140, 5061, 5066);
                                            CallChecker.isCalled(yDotK, double[][].class, 140, 5073, 5077)[l] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 140, 5073, 5077)[l], double[].class, 140, 5073, 5080);
                                            sum += (CallChecker.isCalled(CallChecker.isCalled(a, double[][].class, 140, 5061, 5061)[(k - 1)], double[].class, 140, 5061, 5066)[l]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 140, 5073, 5077)[l], double[].class, 140, 5073, 5080)[j]);
                                            CallChecker.varAssign(sum, "sum", 140, 5054, 5084);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(yTmp, double[].class, 142, 5116, 5119)) {
                            if (CallChecker.beforeDeref(y, double[].class, 142, 5126, 5126)) {
                                CallChecker.isCalled(yTmp, double[].class, 142, 5116, 5119)[j] = (CallChecker.isCalled(y, double[].class, 142, 5126, 5126)[j]) + ((stepSize) * sum);
                                CallChecker.varAssign(CallChecker.isCalled(yTmp, double[].class, 142, 5116, 5119)[j], "CallChecker.isCalled(yTmp, double[].class, 142, 5116, 5119)[j]", 142, 5116, 5147);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(c, double[].class, 145, 5203, 5203)) {
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 145, 5228, 5232)) {
                            computeDerivatives(((stepStart) + ((CallChecker.isCalled(c, double[].class, 145, 5203, 5203)[(k - 1)]) * (stepSize))), yTmp, CallChecker.isCalled(yDotK, double[][].class, 145, 5228, 5232)[k]);
                        }
                    }
                }
                for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 150, 5326, 5327).length); ++j) {
                    double sum = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(b, double[].class, 151, 5370, 5370)) {
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 151, 5377, 5381)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 151, 5377, 5381)[0], double[].class, 151, 5377, 5384)) {
                                CallChecker.isCalled(yDotK, double[][].class, 151, 5377, 5381)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 151, 5377, 5381)[0], double[].class, 151, 5377, 5384);
                                sum = (CallChecker.isCalled(b, double[].class, 151, 5370, 5370)[0]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 151, 5377, 5381)[0], double[].class, 151, 5377, 5384)[j]);
                                CallChecker.varAssign(sum, "sum", 151, 5370, 5370);
                            }
                        }
                    }
                    for (int l = 1; l < stages; ++l) {
                        if (CallChecker.beforeDeref(b, double[].class, 153, 5459, 5459)) {
                            if (CallChecker.beforeDeref(yDotK, double[][].class, 153, 5466, 5470)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 153, 5466, 5470)[l], double[].class, 153, 5466, 5473)) {
                                    CallChecker.isCalled(yDotK, double[][].class, 153, 5466, 5470)[l] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 153, 5466, 5470)[l], double[].class, 153, 5466, 5473);
                                    sum += (CallChecker.isCalled(b, double[].class, 153, 5459, 5459)[l]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 153, 5466, 5470)[l], double[].class, 153, 5466, 5473)[j]);
                                    CallChecker.varAssign(sum, "sum", 153, 5449, 5477);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(yTmp, double[].class, 155, 5501, 5504)) {
                        if (CallChecker.beforeDeref(y, double[].class, 155, 5511, 5511)) {
                            CallChecker.isCalled(yTmp, double[].class, 155, 5501, 5504)[j] = (CallChecker.isCalled(y, double[].class, 155, 5511, 5511)[j]) + ((stepSize) * sum);
                            CallChecker.varAssign(CallChecker.isCalled(yTmp, double[].class, 155, 5501, 5504)[j], "CallChecker.isCalled(yTmp, double[].class, 155, 5501, 5504)[j]", 155, 5501, 5532);
                        }
                    }
                }
                if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 159, 5583, 5594)) {
                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 159, 5583, 5594).storeTime(((stepStart) + (stepSize)));
                }
                if (CallChecker.beforeDeref(y0, double[].class, 160, 5667, 5668)) {
                    System.arraycopy(yTmp, 0, y, 0, CallChecker.isCalled(y0, double[].class, 160, 5667, 5668).length);
                }
                if (CallChecker.beforeDeref(yDotK, double[][].class, 161, 5702, 5706)) {
                    if (CallChecker.beforeDeref(y0, double[].class, 161, 5736, 5737)) {
                        System.arraycopy(CallChecker.isCalled(yDotK, double[][].class, 161, 5702, 5706)[(stages - 1)], 0, yDotTmp, 0, CallChecker.isCalled(y0, double[].class, 161, 5736, 5737).length);
                    }
                }
                stepStart = acceptStep(interpolator, y, yDotTmp, t);
                CallChecker.varAssign(this.stepStart, "this.stepStart", 162, 5754, 5805);
                if (!(isLastStep)) {
                    if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 167, 5875, 5886)) {
                        CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 167, 5875, 5886).storeTime(stepStart);
                    }
                    final double nextT = CallChecker.varInit(((double) ((this.stepStart) + (this.stepSize))), "nextT", 170, 5921, 6012);
                    boolean nextIsLast = CallChecker.init(boolean.class);
                    if (forward) {
                        nextIsLast = nextT >= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 171, 6051, 6087);
                    }else {
                        nextIsLast = nextT <= t;
                        CallChecker.varAssign(nextIsLast, "nextIsLast", 171, 6051, 6087);
                    }
                    if (nextIsLast) {
                        stepSize = t - (stepStart);
                        CallChecker.varAssign(this.stepSize, "this.stepSize", 173, 6132, 6156);
                    }
                }
            } while (!(isLastStep) );
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 180, 6235, 6243)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 180, 6235, 6243).setTime(stepStart);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 181, 6269, 6277)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 181, 6269, 6277).setCompleteState(y);
            }
            stepStart = Double.NaN;
            CallChecker.varAssign(this.stepStart, "this.stepStart", 183, 6305, 6327);
            stepSize = Double.NaN;
            CallChecker.varAssign(this.stepSize, "this.stepSize", 184, 6333, 6355);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5006.methodEnd();
        }
    }
}

