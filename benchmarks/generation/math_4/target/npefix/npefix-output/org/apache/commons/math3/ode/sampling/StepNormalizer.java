package org.apache.commons.math3.ode.sampling;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class StepNormalizer implements StepHandler {
    private double h;

    private final FixedStepHandler handler;

    private double firstTime;

    private double lastTime;

    private double[] lastState;

    private double[] lastDerivatives;

    private boolean forward;

    private final StepNormalizerBounds bounds;

    private final StepNormalizerMode mode;

    public StepNormalizer(final double h, final FixedStepHandler handler) {
        this(h, handler, StepNormalizerMode.INCREMENT, StepNormalizerBounds.FIRST);
        ConstructorContext _bcornu_methode_context245 = new ConstructorContext(StepNormalizer.class, 126, 9377, 9853);
        try {
        } finally {
            _bcornu_methode_context245.methodEnd();
        }
    }

    public StepNormalizer(final double h, final FixedStepHandler handler, final StepNormalizerMode mode) {
        this(h, handler, mode, StepNormalizerBounds.FIRST);
        ConstructorContext _bcornu_methode_context246 = new ConstructorContext(StepNormalizer.class, 138, 9860, 10328);
        try {
        } finally {
            _bcornu_methode_context246.methodEnd();
        }
    }

    public StepNormalizer(final double h, final FixedStepHandler handler, final StepNormalizerBounds bounds) {
        this(h, handler, StepNormalizerMode.INCREMENT, bounds);
        ConstructorContext _bcornu_methode_context247 = new ConstructorContext(StepNormalizer.class, 150, 10335, 10819);
        try {
        } finally {
            _bcornu_methode_context247.methodEnd();
        }
    }

    public StepNormalizer(final double h, final FixedStepHandler handler, final StepNormalizerMode mode, final StepNormalizerBounds bounds) {
        ConstructorContext _bcornu_methode_context248 = new ConstructorContext(StepNormalizer.class, 162, 10826, 11601);
        try {
            this.h = FastMath.abs(h);
            CallChecker.varAssign(this.h, "this.h", 165, 11289, 11322);
            this.handler = handler;
            CallChecker.varAssign(this.handler, "this.handler", 166, 11332, 11357);
            this.mode = mode;
            CallChecker.varAssign(this.mode, "this.mode", 167, 11367, 11389);
            this.bounds = bounds;
            CallChecker.varAssign(this.bounds, "this.bounds", 168, 11399, 11423);
            firstTime = Double.NaN;
            CallChecker.varAssign(this.firstTime, "this.firstTime", 169, 11433, 11461);
            lastTime = Double.NaN;
            CallChecker.varAssign(this.lastTime, "this.lastTime", 170, 11471, 11499);
            lastState = null;
            CallChecker.varAssign(this.lastState, "this.lastState", 171, 11509, 11531);
            lastDerivatives = null;
            CallChecker.varAssign(this.lastDerivatives, "this.lastDerivatives", 172, 11541, 11563);
            forward = true;
            CallChecker.varAssign(this.forward, "this.forward", 173, 11573, 11595);
        } finally {
            _bcornu_methode_context248.methodEnd();
        }
    }

    public void init(double t0, double[] y0, double t) {
        MethodContext _bcornu_methode_context1029 = new MethodContext(void.class, 177, 11608, 11943);
        try {
            CallChecker.varInit(this, "this", 177, 11608, 11943);
            CallChecker.varInit(t, "t", 177, 11608, 11943);
            CallChecker.varInit(y0, "y0", 177, 11608, 11943);
            CallChecker.varInit(t0, "t0", 177, 11608, 11943);
            CallChecker.varInit(this.mode, "mode", 177, 11608, 11943);
            CallChecker.varInit(this.bounds, "bounds", 177, 11608, 11943);
            CallChecker.varInit(this.forward, "forward", 177, 11608, 11943);
            CallChecker.varInit(this.lastDerivatives, "lastDerivatives", 177, 11608, 11943);
            CallChecker.varInit(this.lastState, "lastState", 177, 11608, 11943);
            CallChecker.varInit(this.lastTime, "lastTime", 177, 11608, 11943);
            CallChecker.varInit(this.firstTime, "firstTime", 177, 11608, 11943);
            CallChecker.varInit(this.handler, "handler", 177, 11608, 11943);
            CallChecker.varInit(this.h, "h", 177, 11608, 11943);
            firstTime = Double.NaN;
            CallChecker.varAssign(this.firstTime, "this.firstTime", 179, 11695, 11723);
            lastTime = Double.NaN;
            CallChecker.varAssign(this.lastTime, "this.lastTime", 180, 11733, 11761);
            lastState = null;
            CallChecker.varAssign(this.lastState, "this.lastState", 181, 11771, 11793);
            lastDerivatives = null;
            CallChecker.varAssign(this.lastDerivatives, "this.lastDerivatives", 182, 11803, 11825);
            forward = true;
            CallChecker.varAssign(this.forward, "this.forward", 183, 11835, 11857);
            if (CallChecker.beforeDeref(handler, FixedStepHandler.class, 186, 11913, 11919)) {
                CallChecker.isCalled(handler, FixedStepHandler.class, 186, 11913, 11919).init(t0, y0, t);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1029.methodEnd();
        }
    }

    public void handleStep(final StepInterpolator interpolator, final boolean isLast) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context1030 = new MethodContext(void.class, 203, 11950, 14829);
        try {
            CallChecker.varInit(this, "this", 203, 11950, 14829);
            CallChecker.varInit(isLast, "isLast", 203, 11950, 14829);
            CallChecker.varInit(interpolator, "interpolator", 203, 11950, 14829);
            CallChecker.varInit(this.mode, "mode", 203, 11950, 14829);
            CallChecker.varInit(this.bounds, "bounds", 203, 11950, 14829);
            CallChecker.varInit(this.forward, "forward", 203, 11950, 14829);
            CallChecker.varInit(this.lastDerivatives, "lastDerivatives", 203, 11950, 14829);
            CallChecker.varInit(this.lastState, "lastState", 203, 11950, 14829);
            CallChecker.varInit(this.lastTime, "lastTime", 203, 11950, 14829);
            CallChecker.varInit(this.firstTime, "firstTime", 203, 11950, 14829);
            CallChecker.varInit(this.handler, "handler", 203, 11950, 14829);
            CallChecker.varInit(this.h, "h", 203, 11950, 14829);
            if ((lastState) == null) {
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 207, 12889, 12900)) {
                    firstTime = CallChecker.isCalled(interpolator, StepInterpolator.class, 207, 12889, 12900).getPreviousTime();
                    CallChecker.varAssign(this.firstTime, "this.firstTime", 207, 12877, 12919);
                }
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 208, 12944, 12955)) {
                    lastTime = CallChecker.isCalled(interpolator, StepInterpolator.class, 208, 12944, 12955).getPreviousTime();
                    CallChecker.varAssign(this.lastTime, "this.lastTime", 208, 12933, 12974);
                }
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 209, 12988, 12999)) {
                    CallChecker.isCalled(interpolator, StepInterpolator.class, 209, 12988, 12999).setInterpolatedTime(lastTime);
                }
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 210, 13056, 13067)) {
                    final double[] npe_invocation_var115 = CallChecker.isCalled(interpolator, StepInterpolator.class, 210, 13056, 13067).getInterpolatedState();
                    if (CallChecker.beforeDeref(npe_invocation_var115, double[].class, 210, 13056, 13090)) {
                        lastState = CallChecker.isCalled(npe_invocation_var115, double[].class, 210, 13056, 13090).clone();
                        CallChecker.varAssign(this.lastState, "this.lastState", 210, 13044, 13099);
                    }
                }
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 211, 13131, 13142)) {
                    final double[] npe_invocation_var116 = CallChecker.isCalled(interpolator, StepInterpolator.class, 211, 13131, 13142).getInterpolatedDerivatives();
                    if (CallChecker.beforeDeref(npe_invocation_var116, double[].class, 211, 13131, 13171)) {
                        lastDerivatives = CallChecker.isCalled(npe_invocation_var116, double[].class, 211, 13131, 13171).clone();
                        CallChecker.varAssign(this.lastDerivatives, "this.lastDerivatives", 211, 13113, 13180);
                    }
                }
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 214, 13265, 13276)) {
                    forward = (CallChecker.isCalled(interpolator, StepInterpolator.class, 214, 13265, 13276).getCurrentTime()) >= (lastTime);
                    CallChecker.varAssign(this.forward, "this.forward", 214, 13255, 13306);
                }
                if (!(forward)) {
                    h = -(h);
                    CallChecker.varAssign(this.h, "this.h", 216, 13352, 13358);
                }
            }
            double nextTime = CallChecker.init(double.class);
            if ((mode) == (StepNormalizerMode.INCREMENT)) {
                nextTime = (lastTime) + (h);
                CallChecker.varAssign(nextTime, "nextTime", 221, 13459, 13604);
            }else {
                nextTime = ((FastMath.floor(((lastTime) / (h)))) + 1) * (h);
                CallChecker.varAssign(nextTime, "nextTime", 221, 13459, 13604);
            }
            if (((mode) == (StepNormalizerMode.MULTIPLES)) && (Precision.equals(nextTime, lastTime, 1))) {
                nextTime += h;
                CallChecker.varAssign(nextTime, "nextTime", 226, 13726, 13739);
            }
            boolean nextInStep = CallChecker.varInit(((boolean) (isNextInStep(nextTime, interpolator))), "nextInStep", 230, 13837, 13894);
            while (nextInStep) {
                doNormalizedStep(false);
                storeStep(interpolator, nextTime);
                nextTime += h;
                CallChecker.varAssign(nextTime, "nextTime", 239, 14161, 14174);
                nextInStep = isNextInStep(nextTime, interpolator);
                CallChecker.varAssign(nextInStep, "nextInStep", 240, 14188, 14237);
            } 
            if (isLast) {
                boolean addLast = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(bounds, StepNormalizerBounds.class, 247, 14524, 14529)) {
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 248, 14591, 14602)) {
                        addLast = (CallChecker.isCalled(bounds, StepNormalizerBounds.class, 247, 14524, 14529).lastIncluded()) && ((lastTime) != (CallChecker.isCalled(interpolator, StepInterpolator.class, 248, 14591, 14602).getCurrentTime()));
                        CallChecker.varAssign(addLast, "addLast", 247, 14524, 14529);
                    }
                }
                doNormalizedStep((!addLast));
                if (addLast) {
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 251, 14729, 14740)) {
                        storeStep(interpolator, CallChecker.isCalled(interpolator, StepInterpolator.class, 251, 14729, 14740).getCurrentTime());
                    }
                    doNormalizedStep(true);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1030.methodEnd();
        }
    }

    private boolean isNextInStep(double nextTime, StepInterpolator interpolator) {
        MethodContext _bcornu_methode_context1031 = new MethodContext(boolean.class, 266, 14836, 15473);
        try {
            CallChecker.varInit(this, "this", 266, 14836, 15473);
            CallChecker.varInit(interpolator, "interpolator", 266, 14836, 15473);
            CallChecker.varInit(nextTime, "nextTime", 266, 14836, 15473);
            CallChecker.varInit(this.mode, "mode", 266, 14836, 15473);
            CallChecker.varInit(this.bounds, "bounds", 266, 14836, 15473);
            CallChecker.varInit(this.forward, "forward", 266, 14836, 15473);
            CallChecker.varInit(this.lastDerivatives, "lastDerivatives", 266, 14836, 15473);
            CallChecker.varInit(this.lastState, "lastState", 266, 14836, 15473);
            CallChecker.varInit(this.lastTime, "lastTime", 266, 14836, 15473);
            CallChecker.varInit(this.firstTime, "firstTime", 266, 14836, 15473);
            CallChecker.varInit(this.handler, "handler", 266, 14836, 15473);
            CallChecker.varInit(this.h, "h", 266, 14836, 15473);
            if (forward) {
                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 269, 15379, 15390);
                return nextTime <= (CallChecker.isCalled(interpolator, StepInterpolator.class, 269, 15379, 15390).getCurrentTime());
            }else {
                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 270, 15438, 15449);
                return nextTime >= (CallChecker.isCalled(interpolator, StepInterpolator.class, 270, 15438, 15449).getCurrentTime());
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1031.methodEnd();
        }
    }

    private void doNormalizedStep(boolean isLast) {
        MethodContext _bcornu_methode_context1032 = new MethodContext(void.class, 277, 15480, 15846);
        try {
            CallChecker.varInit(this, "this", 277, 15480, 15846);
            CallChecker.varInit(isLast, "isLast", 277, 15480, 15846);
            CallChecker.varInit(this.mode, "mode", 277, 15480, 15846);
            CallChecker.varInit(this.bounds, "bounds", 277, 15480, 15846);
            CallChecker.varInit(this.forward, "forward", 277, 15480, 15846);
            CallChecker.varInit(this.lastDerivatives, "lastDerivatives", 277, 15480, 15846);
            CallChecker.varInit(this.lastState, "lastState", 277, 15480, 15846);
            CallChecker.varInit(this.lastTime, "lastTime", 277, 15480, 15846);
            CallChecker.varInit(this.firstTime, "firstTime", 277, 15480, 15846);
            CallChecker.varInit(this.handler, "handler", 277, 15480, 15846);
            CallChecker.varInit(this.h, "h", 277, 15480, 15846);
            if (CallChecker.beforeDeref(bounds, StepNormalizerBounds.class, 278, 15687, 15692)) {
                if ((!(CallChecker.isCalled(bounds, StepNormalizerBounds.class, 278, 15687, 15692).firstIncluded())) && ((firstTime) == (lastTime))) {
                    return ;
                }
            }
            if (CallChecker.beforeDeref(handler, FixedStepHandler.class, 281, 15776, 15782)) {
                CallChecker.isCalled(handler, FixedStepHandler.class, 281, 15776, 15782).handleStep(lastTime, lastState, lastDerivatives, isLast);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1032.methodEnd();
        }
    }

    private void storeStep(StepInterpolator interpolator, double t) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context1033 = new MethodContext(void.class, 292, 15853, 16731);
        try {
            CallChecker.varInit(this, "this", 292, 15853, 16731);
            CallChecker.varInit(t, "t", 292, 15853, 16731);
            CallChecker.varInit(interpolator, "interpolator", 292, 15853, 16731);
            CallChecker.varInit(this.mode, "mode", 292, 15853, 16731);
            CallChecker.varInit(this.bounds, "bounds", 292, 15853, 16731);
            CallChecker.varInit(this.forward, "forward", 292, 15853, 16731);
            CallChecker.varInit(this.lastDerivatives, "lastDerivatives", 292, 15853, 16731);
            CallChecker.varInit(this.lastState, "lastState", 292, 15853, 16731);
            CallChecker.varInit(this.lastTime, "lastTime", 292, 15853, 16731);
            CallChecker.varInit(this.firstTime, "firstTime", 292, 15853, 16731);
            CallChecker.varInit(this.handler, "handler", 292, 15853, 16731);
            CallChecker.varInit(this.h, "h", 292, 15853, 16731);
            lastTime = t;
            CallChecker.varAssign(this.lastTime, "this.lastTime", 294, 16397, 16409);
            if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 295, 16419, 16430)) {
                interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 295, 16419, 16430);
                CallChecker.isCalled(interpolator, StepInterpolator.class, 295, 16419, 16430).setInterpolatedTime(lastTime);
            }
            if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 296, 16488, 16499)) {
                if (CallChecker.beforeDeref(lastState, double[].class, 297, 16567, 16575)) {
                    interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 296, 16488, 16499);
                    lastState = CallChecker.beforeCalled(lastState, double[].class, 297, 16567, 16575);
                    System.arraycopy(CallChecker.isCalled(interpolator, StepInterpolator.class, 296, 16488, 16499).getInterpolatedState(), 0, lastState, 0, CallChecker.isCalled(lastState, double[].class, 297, 16567, 16575).length);
                }
            }
            if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 298, 16611, 16622)) {
                if (CallChecker.beforeDeref(lastDerivatives, double[].class, 299, 16702, 16716)) {
                    interpolator = CallChecker.beforeCalled(interpolator, StepInterpolator.class, 298, 16611, 16622);
                    lastDerivatives = CallChecker.beforeCalled(lastDerivatives, double[].class, 299, 16702, 16716);
                    System.arraycopy(CallChecker.isCalled(interpolator, StepInterpolator.class, 298, 16611, 16622).getInterpolatedDerivatives(), 0, lastDerivatives, 0, CallChecker.isCalled(lastDerivatives, double[].class, 299, 16702, 16716).length);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1033.methodEnd();
        }
    }
}

