package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;

abstract class RungeKuttaStepInterpolator extends AbstractStepInterpolator {
    protected double[] previousState;

    protected double[][] yDotK;

    protected AbstractIntegrator integrator;

    protected RungeKuttaStepInterpolator() {
        ConstructorContext _bcornu_methode_context400 = new ConstructorContext(RungeKuttaStepInterpolator.class, 60, 1683, 2356);
        try {
            previousState = null;
            CallChecker.varAssign(this.previousState, "this.previousState", 61, 2280, 2300);
            yDotK = null;
            CallChecker.varAssign(this.yDotK, "this.yDotK", 62, 2306, 2326);
            integrator = null;
            CallChecker.varAssign(this.integrator, "this.integrator", 63, 2332, 2352);
        } finally {
            _bcornu_methode_context400.methodEnd();
        }
    }

    public RungeKuttaStepInterpolator(final RungeKuttaStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context401 = new ConstructorContext(RungeKuttaStepInterpolator.class, 83, 2361, 3651);
        try {
            if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 87, 3163, 3174)) {
                if ((CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 87, 3163, 3174).currentState) != null) {
                    if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 89, 3223, 3234)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 89, 3223, 3234).previousState, double[].class, 89, 3223, 3248)) {
                            CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 89, 3223, 3234).previousState = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 89, 3223, 3234).previousState, double[].class, 89, 3223, 3248);
                            previousState = CallChecker.isCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 89, 3223, 3234).previousState, double[].class, 89, 3223, 3248).clone();
                            CallChecker.varAssign(this.previousState, "this.previousState", 89, 3207, 3257);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 91, 3285, 3296)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 91, 3285, 3296).yDotK, double[][].class, 91, 3285, 3302)) {
                            CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 91, 3285, 3296).yDotK = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 91, 3285, 3296).yDotK, double[][].class, 91, 3285, 3302);
                            yDotK = new double[CallChecker.isCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 91, 3285, 3296).yDotK, double[][].class, 91, 3285, 3302).length][];
                            CallChecker.varAssign(this.yDotK, "this.yDotK", 91, 3266, 3313);
                        }
                    }
                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 92, 3341, 3352).yDotK = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 92, 3341, 3352).yDotK, double[][].class, 92, 3341, 3358);
                    for (int k = 0; k < (CallChecker.isCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 92, 3341, 3352).yDotK, double[][].class, 92, 3341, 3358).length); ++k) {
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 93, 3383, 3387)) {
                            if (CallChecker.beforeDeref(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK, double[][].class, 93, 3394, 3411)) {
                                    CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK, double[][].class, 93, 3394, 3411);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK, double[][].class, 93, 3394, 3411)[k], double[].class, 93, 3394, 3414)) {
                                        yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 93, 3383, 3387);
                                        CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK, double[][].class, 93, 3394, 3411);
                                        CallChecker.isCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK, double[][].class, 93, 3394, 3411)[k] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK, double[][].class, 93, 3394, 3411)[k], double[].class, 93, 3394, 3414);
                                        CallChecker.isCalled(yDotK, double[][].class, 93, 3383, 3387)[k] = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(interpolator, RungeKuttaStepInterpolator.class, 93, 3394, 3405).yDotK, double[][].class, 93, 3394, 3411)[k], double[].class, 93, 3394, 3414).clone();
                                        CallChecker.varAssign(CallChecker.isCalled(this.yDotK, double[][].class, 93, 3383, 3387)[k], "CallChecker.isCalled(this.yDotK, double[][].class, 93, 3383, 3387)[k]", 93, 3383, 3423);
                                    }
                                }
                            }
                        }
                    }
                }else {
                    previousState = null;
                    CallChecker.varAssign(this.previousState, "this.previousState", 97, 3453, 3473);
                    yDotK = null;
                    CallChecker.varAssign(this.yDotK, "this.yDotK", 98, 3481, 3493);
                }
            }else
                throw new AbnormalExecutionError();
            
            integrator = null;
            CallChecker.varAssign(this.integrator, "this.integrator", 103, 3629, 3646);
        } finally {
            _bcornu_methode_context401.methodEnd();
        }
    }

    public void reinitialize(final AbstractIntegrator rkIntegrator, final double[] y, final double[][] yDotArray, final boolean forward, final EquationsMapper primaryMapper, final EquationsMapper[] secondaryMappers) {
        MethodContext _bcornu_methode_context1742 = new MethodContext(void.class, 130, 3656, 5457);
        try {
            CallChecker.varInit(this, "this", 130, 3656, 5457);
            CallChecker.varInit(secondaryMappers, "secondaryMappers", 130, 3656, 5457);
            CallChecker.varInit(primaryMapper, "primaryMapper", 130, 3656, 5457);
            CallChecker.varInit(forward, "forward", 130, 3656, 5457);
            CallChecker.varInit(yDotArray, "yDotArray", 130, 3656, 5457);
            CallChecker.varInit(y, "y", 130, 3656, 5457);
            CallChecker.varInit(rkIntegrator, "rkIntegrator", 130, 3656, 5457);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 130, 3656, 5457);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 130, 3656, 5457);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 130, 3656, 5457);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 130, 3656, 5457);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 130, 3656, 5457);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 130, 3656, 5457);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 130, 3656, 5457);
            CallChecker.varInit(this.currentState, "currentState", 130, 3656, 5457);
            CallChecker.varInit(this.h, "h", 130, 3656, 5457);
            CallChecker.varInit(this.integrator, "integrator", 130, 3656, 5457);
            CallChecker.varInit(this.yDotK, "yDotK", 130, 3656, 5457);
            CallChecker.varInit(this.previousState, "previousState", 130, 3656, 5457);
            reinitialize(y, forward, primaryMapper, secondaryMappers);
            this.previousState = null;
            CallChecker.varAssign(this.previousState, "this.previousState", 135, 5364, 5389);
            this.yDotK = yDotArray;
            CallChecker.varAssign(this.yDotK, "this.yDotK", 136, 5395, 5417);
            this.integrator = rkIntegrator;
            CallChecker.varAssign(this.integrator, "this.integrator", 137, 5423, 5453);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1742.methodEnd();
        }
    }

    @Override
    public void shift() {
        MethodContext _bcornu_methode_context1743 = new MethodContext(void.class, 142, 5462, 5582);
        try {
            CallChecker.varInit(this, "this", 142, 5462, 5582);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 142, 5462, 5582);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 142, 5462, 5582);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 142, 5462, 5582);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 142, 5462, 5582);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 142, 5462, 5582);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 142, 5462, 5582);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 142, 5462, 5582);
            CallChecker.varInit(this.currentState, "currentState", 142, 5462, 5582);
            CallChecker.varInit(this.h, "h", 142, 5462, 5582);
            CallChecker.varInit(this.integrator, "integrator", 142, 5462, 5582);
            CallChecker.varInit(this.yDotK, "yDotK", 142, 5462, 5582);
            CallChecker.varInit(this.previousState, "previousState", 142, 5462, 5582);
            if (CallChecker.beforeDeref(currentState, double[].class, 143, 5539, 5550)) {
                currentState = CallChecker.beforeCalled(currentState, double[].class, 143, 5539, 5550);
                previousState = CallChecker.isCalled(currentState, double[].class, 143, 5539, 5550).clone();
                CallChecker.varAssign(this.previousState, "this.previousState", 143, 5523, 5559);
            }
            super.shift();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1743.methodEnd();
        }
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        MethodContext _bcornu_methode_context1744 = new MethodContext(void.class, 149, 5587, 6215);
        try {
            CallChecker.varInit(this, "this", 149, 5587, 6215);
            CallChecker.varInit(out, "out", 149, 5587, 6215);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 149, 5587, 6215);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 149, 5587, 6215);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 149, 5587, 6215);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 149, 5587, 6215);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 149, 5587, 6215);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 149, 5587, 6215);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 149, 5587, 6215);
            CallChecker.varInit(this.currentState, "currentState", 149, 5587, 6215);
            CallChecker.varInit(this.h, "h", 149, 5587, 6215);
            CallChecker.varInit(this.integrator, "integrator", 149, 5587, 6215);
            CallChecker.varInit(this.yDotK, "yDotK", 149, 5587, 6215);
            CallChecker.varInit(this.previousState, "previousState", 149, 5587, 6215);
            writeBaseExternal(out);
            int n = CallChecker.init(int.class);
            if ((currentState) == null) {
                n = -1;
                CallChecker.varAssign(n, "n", 156, 5818, 5866);
            }else {
                n = currentState.length;
                CallChecker.varAssign(n, "n", 156, 5818, 5866);
            }
            for (int i = 0; i < n; ++i) {
                if (CallChecker.beforeDeref(previousState, double[].class, 158, 5925, 5937)) {
                    if (CallChecker.beforeDeref(out, ObjectOutput.class, 158, 5909, 5911)) {
                        previousState = CallChecker.beforeCalled(previousState, double[].class, 158, 5925, 5937);
                        CallChecker.isCalled(out, ObjectOutput.class, 158, 5909, 5911).writeDouble(CallChecker.isCalled(previousState, double[].class, 158, 5925, 5937)[i]);
                    }
                }
            }
            int kMax = CallChecker.init(int.class);
            if ((yDotK) == null) {
                kMax = -1;
                CallChecker.varAssign(kMax, "kMax", 161, 5972, 6006);
            }else {
                kMax = yDotK.length;
                CallChecker.varAssign(kMax, "kMax", 161, 5972, 6006);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 162, 6013, 6015)) {
                CallChecker.isCalled(out, ObjectOutput.class, 162, 6013, 6015).writeInt(kMax);
            }
            for (int k = 0; k < kMax; ++k) {
                for (int i = 0; i < n; ++i) {
                    if (CallChecker.beforeDeref(yDotK, double[][].class, 165, 6130, 6134)) {
                        yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 165, 6130, 6134);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 165, 6130, 6134)[k], double[].class, 165, 6130, 6137)) {
                            if (CallChecker.beforeDeref(out, ObjectOutput.class, 165, 6114, 6116)) {
                                yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 165, 6130, 6134);
                                CallChecker.isCalled(yDotK, double[][].class, 165, 6130, 6134)[k] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 165, 6130, 6134)[k], double[].class, 165, 6130, 6137);
                                CallChecker.isCalled(out, ObjectOutput.class, 165, 6114, 6116).writeDouble(CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 165, 6130, 6134)[k], double[].class, 165, 6130, 6137)[i]);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1744.methodEnd();
        }
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1745 = new MethodContext(void.class, 175, 6220, 7176);
        try {
            CallChecker.varInit(this, "this", 175, 6220, 7176);
            CallChecker.varInit(in, "in", 175, 6220, 7176);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 175, 6220, 7176);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 175, 6220, 7176);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 175, 6220, 7176);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 175, 6220, 7176);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 175, 6220, 7176);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 175, 6220, 7176);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 175, 6220, 7176);
            CallChecker.varInit(this.currentState, "currentState", 175, 6220, 7176);
            CallChecker.varInit(this.h, "h", 175, 6220, 7176);
            CallChecker.varInit(this.integrator, "integrator", 175, 6220, 7176);
            CallChecker.varInit(this.yDotK, "yDotK", 175, 6220, 7176);
            CallChecker.varInit(this.previousState, "previousState", 175, 6220, 7176);
            final double t = CallChecker.varInit(((double) (readBaseExternal(in))), "t", 179, 6356, 6420);
            int n = CallChecker.init(int.class);
            if ((currentState) == null) {
                n = -1;
                CallChecker.varAssign(n, "n", 182, 6474, 6522);
            }else {
                n = currentState.length;
                CallChecker.varAssign(n, "n", 182, 6474, 6522);
            }
            if (n < 0) {
                previousState = null;
                CallChecker.varAssign(this.previousState, "this.previousState", 184, 6548, 6568);
            }else {
                previousState = new double[n];
                CallChecker.varAssign(this.previousState, "this.previousState", 186, 6589, 6618);
                for (int i = 0; i < n; ++i) {
                    if (CallChecker.beforeDeref(previousState, double[].class, 188, 6664, 6676)) {
                        if (CallChecker.beforeDeref(in, ObjectInput.class, 188, 6683, 6684)) {
                            previousState = CallChecker.beforeCalled(previousState, double[].class, 188, 6664, 6676);
                            CallChecker.isCalled(previousState, double[].class, 188, 6664, 6676)[i] = CallChecker.isCalled(in, ObjectInput.class, 188, 6683, 6684).readDouble();
                            CallChecker.varAssign(CallChecker.isCalled(this.previousState, double[].class, 188, 6664, 6676)[i], "CallChecker.isCalled(this.previousState, double[].class, 188, 6664, 6676)[i]", 188, 6664, 6698);
                        }
                    }
                }
            }
            final int kMax = CallChecker.varInit(((int) (CallChecker.isCalled(in, ObjectInput.class, 192, 6736, 6737).readInt())), "kMax", 192, 6719, 6748);
            if (kMax < 0) {
                yDotK = null;
                CallChecker.varAssign(this.yDotK, "this.yDotK", 193, 6754, 6800);
            }else {
                yDotK = new double[kMax][];
                CallChecker.varAssign(this.yDotK, "this.yDotK", 193, 6754, 6800);
            }
            for (int k = 0; k < kMax; ++k) {
                if (n < 0) {
                    if (CallChecker.beforeDeref(yDotK, double[][].class, 195, 6845, 6849)) {
                        yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 195, 6845, 6849);
                        CallChecker.isCalled(yDotK, double[][].class, 195, 6845, 6849)[k] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.yDotK, double[][].class, 195, 6845, 6849)[k], "CallChecker.isCalled(this.yDotK, double[][].class, 195, 6845, 6849)[k]", 195, 6845, 6886);
                    }
                }else {
                    if (CallChecker.beforeDeref(yDotK, double[][].class, 195, 6845, 6849)) {
                        yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 195, 6845, 6849);
                        CallChecker.isCalled(yDotK, double[][].class, 195, 6845, 6849)[k] = new double[n];
                        CallChecker.varAssign(CallChecker.isCalled(this.yDotK, double[][].class, 195, 6845, 6849)[k], "CallChecker.isCalled(this.yDotK, double[][].class, 195, 6845, 6849)[k]", 195, 6845, 6886);
                    }
                }
                for (int i = 0; i < n; ++i) {
                    if (CallChecker.beforeDeref(yDotK, double[][].class, 197, 6932, 6936)) {
                        yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 197, 6932, 6936);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 197, 6932, 6936)[k], double[].class, 197, 6932, 6939)) {
                            if (CallChecker.beforeDeref(in, ObjectInput.class, 197, 6946, 6947)) {
                                yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 197, 6932, 6936);
                                CallChecker.isCalled(yDotK, double[][].class, 197, 6932, 6936)[k] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 197, 6932, 6936)[k], double[].class, 197, 6932, 6939);
                                CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 197, 6932, 6936)[k], double[].class, 197, 6932, 6939)[i] = CallChecker.isCalled(in, ObjectInput.class, 197, 6946, 6947).readDouble();
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 197, 6932, 6936)[k], double[].class, 197, 6932, 6939)[i], "CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 197, 6932, 6936)[k], double[].class, 197, 6932, 6939)[i]", 197, 6932, 6961);
                            }
                        }
                    }
                }
            }
            integrator = null;
            CallChecker.varAssign(this.integrator, "this.integrator", 201, 6982, 6999);
            if ((currentState) != null) {
                setInterpolatedTime(t);
            }else {
                interpolatedTime = t;
                CallChecker.varAssign(this.interpolatedTime, "this.interpolatedTime", 207, 7145, 7165);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1745.methodEnd();
        }
    }
}

