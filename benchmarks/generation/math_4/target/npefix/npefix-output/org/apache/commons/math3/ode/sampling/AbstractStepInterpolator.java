package org.apache.commons.math3.ode.sampling;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.EquationsMapper;

public abstract class AbstractStepInterpolator implements StepInterpolator {
    protected double h;

    protected double[] currentState;

    protected double interpolatedTime;

    protected double[] interpolatedState;

    protected double[] interpolatedDerivatives;

    protected double[] interpolatedPrimaryState;

    protected double[] interpolatedPrimaryDerivatives;

    protected double[][] interpolatedSecondaryState;

    protected double[][] interpolatedSecondaryDerivatives;

    private double globalPreviousTime;

    private double globalCurrentTime;

    private double softPreviousTime;

    private double softCurrentTime;

    private boolean finalized;

    private boolean forward;

    private boolean dirtyState;

    private EquationsMapper primaryMapper;

    private EquationsMapper[] secondaryMappers;

    protected AbstractStepInterpolator() {
        ConstructorContext _bcornu_methode_context515 = new ConstructorContext(AbstractStepInterpolator.class, 112, 3062, 4124);
        try {
            globalPreviousTime = Double.NaN;
            CallChecker.varAssign(this.globalPreviousTime, "this.globalPreviousTime", 113, 3681, 3712);
            globalCurrentTime = Double.NaN;
            CallChecker.varAssign(this.globalCurrentTime, "this.globalCurrentTime", 114, 3718, 3749);
            softPreviousTime = Double.NaN;
            CallChecker.varAssign(this.softPreviousTime, "this.softPreviousTime", 115, 3755, 3786);
            softCurrentTime = Double.NaN;
            CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 116, 3792, 3823);
            h = Double.NaN;
            CallChecker.varAssign(this.h, "this.h", 117, 3829, 3860);
            interpolatedTime = Double.NaN;
            CallChecker.varAssign(this.interpolatedTime, "this.interpolatedTime", 118, 3866, 3897);
            currentState = null;
            CallChecker.varAssign(this.currentState, "this.currentState", 119, 3903, 3928);
            finalized = false;
            CallChecker.varAssign(this.finalized, "this.finalized", 120, 3934, 3960);
            this.forward = true;
            CallChecker.varAssign(this.forward, "this.forward", 121, 3966, 3991);
            this.dirtyState = true;
            CallChecker.varAssign(this.dirtyState, "this.dirtyState", 122, 3997, 4022);
            primaryMapper = null;
            CallChecker.varAssign(this.primaryMapper, "this.primaryMapper", 123, 4028, 4053);
            secondaryMappers = null;
            CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 124, 4059, 4084);
            allocateInterpolatedArrays((-1));
        } finally {
            _bcornu_methode_context515.methodEnd();
        }
    }

    protected AbstractStepInterpolator(final double[] y, final boolean forward, final EquationsMapper primaryMapper, final EquationsMapper[] secondaryMappers) {
        ConstructorContext _bcornu_methode_context516 = new ConstructorContext(AbstractStepInterpolator.class, 135, 4129, 5247);
        try {
            globalPreviousTime = Double.NaN;
            CallChecker.varAssign(this.globalPreviousTime, "this.globalPreviousTime", 139, 4696, 4730);
            globalCurrentTime = Double.NaN;
            CallChecker.varAssign(this.globalCurrentTime, "this.globalCurrentTime", 140, 4736, 4770);
            softPreviousTime = Double.NaN;
            CallChecker.varAssign(this.softPreviousTime, "this.softPreviousTime", 141, 4776, 4810);
            softCurrentTime = Double.NaN;
            CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 142, 4816, 4850);
            h = Double.NaN;
            CallChecker.varAssign(this.h, "this.h", 143, 4856, 4890);
            interpolatedTime = Double.NaN;
            CallChecker.varAssign(this.interpolatedTime, "this.interpolatedTime", 144, 4896, 4930);
            currentState = y;
            CallChecker.varAssign(this.currentState, "this.currentState", 145, 4936, 4961);
            finalized = false;
            CallChecker.varAssign(this.finalized, "this.finalized", 146, 4967, 4996);
            this.forward = forward;
            CallChecker.varAssign(this.forward, "this.forward", 147, 5002, 5033);
            this.dirtyState = true;
            CallChecker.varAssign(this.dirtyState, "this.dirtyState", 148, 5039, 5067);
            this.primaryMapper = primaryMapper;
            CallChecker.varAssign(this.primaryMapper, "this.primaryMapper", 149, 5073, 5110);
            if (secondaryMappers == null) {
                this.secondaryMappers = null;
                CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 150, 5116, 5200);
            }else {
                this.secondaryMappers = secondaryMappers.clone();
                CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 150, 5116, 5200);
            }
            if (CallChecker.beforeDeref(y, double[].class, 151, 5233, 5233)) {
                allocateInterpolatedArrays(CallChecker.isCalled(y, double[].class, 151, 5233, 5233).length);
            }
        } finally {
            _bcornu_methode_context516.methodEnd();
        }
    }

    protected AbstractStepInterpolator(final AbstractStepInterpolator interpolator) {
        ConstructorContext _bcornu_methode_context517 = new ConstructorContext(AbstractStepInterpolator.class, 172, 5252, 7816);
        try {
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 174, 6065, 6076)) {
                globalPreviousTime = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 174, 6065, 6076).globalPreviousTime;
                CallChecker.varAssign(this.globalPreviousTime, "this.globalPreviousTime", 174, 6044, 6096);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 175, 6123, 6134)) {
                globalCurrentTime = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 175, 6123, 6134).globalCurrentTime;
                CallChecker.varAssign(this.globalCurrentTime, "this.globalCurrentTime", 175, 6102, 6153);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 176, 6180, 6191)) {
                softPreviousTime = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 176, 6180, 6191).softPreviousTime;
                CallChecker.varAssign(this.softPreviousTime, "this.softPreviousTime", 176, 6159, 6209);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 177, 6236, 6247)) {
                softCurrentTime = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 177, 6236, 6247).softCurrentTime;
                CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 177, 6215, 6264);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 178, 6291, 6302)) {
                h = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 178, 6291, 6302).h;
                CallChecker.varAssign(this.h, "this.h", 178, 6270, 6305);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 179, 6332, 6343)) {
                interpolatedTime = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 179, 6332, 6343).interpolatedTime;
                CallChecker.varAssign(this.interpolatedTime, "this.interpolatedTime", 179, 6311, 6361);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 181, 6372, 6383)) {
                if ((CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 181, 6372, 6383).currentState) == null) {
                    currentState = null;
                    CallChecker.varAssign(this.currentState, "this.currentState", 182, 6417, 6440);
                    primaryMapper = null;
                    CallChecker.varAssign(this.primaryMapper, "this.primaryMapper", 183, 6450, 6473);
                    secondaryMappers = null;
                    CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 184, 6483, 6506);
                    allocateInterpolatedArrays((-1));
                }else {
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 187, 6602, 6613)) {
                        currentState = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 187, 6602, 6613).currentState.clone();
                        CallChecker.varAssign(this.currentState, "this.currentState", 187, 6567, 6635);
                    }
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 188, 6678, 6689)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 188, 6678, 6689).interpolatedState, double[].class, 188, 6678, 6707)) {
                            CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 188, 6678, 6689).interpolatedState = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 188, 6678, 6689).interpolatedState, double[].class, 188, 6678, 6707);
                            interpolatedState = CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 188, 6678, 6689).interpolatedState, double[].class, 188, 6678, 6707).clone();
                            CallChecker.varAssign(this.interpolatedState, "this.interpolatedState", 188, 6643, 6716);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 189, 6759, 6770)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 189, 6759, 6770).interpolatedDerivatives, double[].class, 189, 6759, 6794)) {
                            CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 189, 6759, 6770).interpolatedDerivatives = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 189, 6759, 6770).interpolatedDerivatives, double[].class, 189, 6759, 6794);
                            interpolatedDerivatives = CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 189, 6759, 6770).interpolatedDerivatives, double[].class, 189, 6759, 6794).clone();
                            CallChecker.varAssign(this.interpolatedDerivatives, "this.interpolatedDerivatives", 189, 6724, 6803);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 190, 6846, 6857)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 190, 6846, 6857).interpolatedPrimaryState, double[].class, 190, 6846, 6882)) {
                            CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 190, 6846, 6857).interpolatedPrimaryState = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 190, 6846, 6857).interpolatedPrimaryState, double[].class, 190, 6846, 6882);
                            interpolatedPrimaryState = CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 190, 6846, 6857).interpolatedPrimaryState, double[].class, 190, 6846, 6882).clone();
                            CallChecker.varAssign(this.interpolatedPrimaryState, "this.interpolatedPrimaryState", 190, 6811, 6891);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 191, 6934, 6945)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 191, 6934, 6945).interpolatedPrimaryDerivatives, double[].class, 191, 6934, 6976)) {
                            CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 191, 6934, 6945).interpolatedPrimaryDerivatives = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 191, 6934, 6945).interpolatedPrimaryDerivatives, double[].class, 191, 6934, 6976);
                            interpolatedPrimaryDerivatives = CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 191, 6934, 6945).interpolatedPrimaryDerivatives, double[].class, 191, 6934, 6976).clone();
                            CallChecker.varAssign(this.interpolatedPrimaryDerivatives, "this.interpolatedPrimaryDerivatives", 191, 6899, 6985);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 192, 7039, 7050)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 192, 7039, 7050).interpolatedSecondaryState, double[][].class, 192, 7039, 7077)) {
                            CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 192, 7039, 7050).interpolatedSecondaryState = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 192, 7039, 7050).interpolatedSecondaryState, double[][].class, 192, 7039, 7077);
                            interpolatedSecondaryState = new double[CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 192, 7039, 7050).interpolatedSecondaryState, double[][].class, 192, 7039, 7077).length][];
                            CallChecker.varAssign(this.interpolatedSecondaryState, "this.interpolatedSecondaryState", 192, 6993, 7088);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 193, 7142, 7153)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 193, 7142, 7153).interpolatedSecondaryDerivatives, double[][].class, 193, 7142, 7186)) {
                            CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 193, 7142, 7153).interpolatedSecondaryDerivatives = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 193, 7142, 7153).interpolatedSecondaryDerivatives, double[][].class, 193, 7142, 7186);
                            interpolatedSecondaryDerivatives = new double[CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 193, 7142, 7153).interpolatedSecondaryDerivatives, double[][].class, 193, 7142, 7186).length][];
                            CallChecker.varAssign(this.interpolatedSecondaryDerivatives, "this.interpolatedSecondaryDerivatives", 193, 7096, 7197);
                        }
                    }
                    interpolatedSecondaryState = CallChecker.beforeCalled(interpolatedSecondaryState, double[][].class, 194, 7225, 7250);
                    for (int i = 0; i < (CallChecker.isCalled(interpolatedSecondaryState, double[][].class, 194, 7225, 7250).length); ++i) {
                        if (CallChecker.beforeDeref(interpolatedSecondaryState, double[][].class, 195, 7277, 7302)) {
                            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState, double[][].class, 195, 7315, 7353)) {
                                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState, double[][].class, 195, 7315, 7353);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState, double[][].class, 195, 7315, 7353)[i], double[].class, 195, 7315, 7356)) {
                                        interpolatedSecondaryState = CallChecker.beforeCalled(interpolatedSecondaryState, double[][].class, 195, 7277, 7302);
                                        CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState, double[][].class, 195, 7315, 7353);
                                        CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState, double[][].class, 195, 7315, 7353)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState, double[][].class, 195, 7315, 7353)[i], double[].class, 195, 7315, 7356);
                                        CallChecker.isCalled(interpolatedSecondaryState, double[][].class, 195, 7277, 7302)[i] = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 195, 7315, 7326).interpolatedSecondaryState, double[][].class, 195, 7315, 7353)[i], double[].class, 195, 7315, 7356).clone();
                                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedSecondaryState, double[][].class, 195, 7277, 7302)[i], "CallChecker.isCalled(this.interpolatedSecondaryState, double[][].class, 195, 7277, 7302)[i]", 195, 7277, 7365);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(interpolatedSecondaryDerivatives, double[][].class, 196, 7377, 7408)) {
                            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives, double[][].class, 196, 7415, 7459)) {
                                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives, double[][].class, 196, 7415, 7459);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives, double[][].class, 196, 7415, 7459)[i], double[].class, 196, 7415, 7462)) {
                                        interpolatedSecondaryDerivatives = CallChecker.beforeCalled(interpolatedSecondaryDerivatives, double[][].class, 196, 7377, 7408);
                                        CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives, double[][].class, 196, 7415, 7459);
                                        CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives, double[][].class, 196, 7415, 7459)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives, double[][].class, 196, 7415, 7459)[i], double[].class, 196, 7415, 7462);
                                        CallChecker.isCalled(interpolatedSecondaryDerivatives, double[][].class, 196, 7377, 7408)[i] = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 196, 7415, 7426).interpolatedSecondaryDerivatives, double[][].class, 196, 7415, 7459)[i], double[].class, 196, 7415, 7462).clone();
                                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedSecondaryDerivatives, double[][].class, 196, 7377, 7408)[i], "CallChecker.isCalled(this.interpolatedSecondaryDerivatives, double[][].class, 196, 7377, 7408)[i]", 196, 7377, 7471);
                                    }
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 200, 7511, 7522)) {
                finalized = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 200, 7511, 7522).finalized;
                CallChecker.varAssign(this.finalized, "this.finalized", 200, 7492, 7533);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 201, 7558, 7569)) {
                forward = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 201, 7558, 7569).forward;
                CallChecker.varAssign(this.forward, "this.forward", 201, 7539, 7578);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 202, 7603, 7614)) {
                dirtyState = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 202, 7603, 7614).dirtyState;
                CallChecker.varAssign(this.dirtyState, "this.dirtyState", 202, 7584, 7626);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 203, 7651, 7662)) {
                primaryMapper = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 203, 7651, 7662).primaryMapper;
                CallChecker.varAssign(this.primaryMapper, "this.primaryMapper", 203, 7632, 7677);
            }
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 204, 7703, 7714)) {
                if ((CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 204, 7703, 7714).secondaryMappers) == null) {
                    secondaryMappers = null;
                    CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 204, 7683, 7811);
                }else {
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 205, 7774, 7785)) {
                        secondaryMappers = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 205, 7774, 7785).secondaryMappers.clone();
                        CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 204, 7683, 7811);
                    }
                }
            }
        } finally {
            _bcornu_methode_context517.methodEnd();
        }
    }

    private void allocateInterpolatedArrays(final int dimension) {
        MethodContext _bcornu_methode_context2432 = new MethodContext(void.class, 212, 7821, 9343);
        try {
            CallChecker.varInit(this, "this", 212, 7821, 9343);
            CallChecker.varInit(dimension, "dimension", 212, 7821, 9343);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 212, 7821, 9343);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 212, 7821, 9343);
            CallChecker.varInit(this.dirtyState, "dirtyState", 212, 7821, 9343);
            CallChecker.varInit(this.forward, "forward", 212, 7821, 9343);
            CallChecker.varInit(this.finalized, "finalized", 212, 7821, 9343);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 212, 7821, 9343);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 212, 7821, 9343);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 212, 7821, 9343);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 212, 7821, 9343);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 212, 7821, 9343);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 212, 7821, 9343);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 212, 7821, 9343);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 212, 7821, 9343);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 212, 7821, 9343);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 212, 7821, 9343);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 212, 7821, 9343);
            CallChecker.varInit(this.currentState, "currentState", 212, 7821, 9343);
            CallChecker.varInit(this.h, "h", 212, 7821, 9343);
            if (dimension < 0) {
                interpolatedState = null;
                CallChecker.varAssign(this.interpolatedState, "this.interpolatedState", 214, 8063, 8102);
                interpolatedDerivatives = null;
                CallChecker.varAssign(this.interpolatedDerivatives, "this.interpolatedDerivatives", 215, 8114, 8153);
                interpolatedPrimaryState = null;
                CallChecker.varAssign(this.interpolatedPrimaryState, "this.interpolatedPrimaryState", 216, 8165, 8204);
                interpolatedPrimaryDerivatives = null;
                CallChecker.varAssign(this.interpolatedPrimaryDerivatives, "this.interpolatedPrimaryDerivatives", 217, 8216, 8255);
                interpolatedSecondaryState = null;
                CallChecker.varAssign(this.interpolatedSecondaryState, "this.interpolatedSecondaryState", 218, 8267, 8306);
                interpolatedSecondaryDerivatives = null;
                CallChecker.varAssign(this.interpolatedSecondaryDerivatives, "this.interpolatedSecondaryDerivatives", 219, 8318, 8357);
            }else {
                interpolatedState = new double[dimension];
                CallChecker.varAssign(this.interpolatedState, "this.interpolatedState", 221, 8384, 8440);
                interpolatedDerivatives = new double[dimension];
                CallChecker.varAssign(this.interpolatedDerivatives, "this.interpolatedDerivatives", 222, 8452, 8508);
                if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 223, 8566, 8578)) {
                    primaryMapper = CallChecker.beforeCalled(primaryMapper, EquationsMapper.class, 223, 8566, 8578);
                    interpolatedPrimaryState = new double[CallChecker.isCalled(primaryMapper, EquationsMapper.class, 223, 8566, 8578).getDimension()];
                    CallChecker.varAssign(this.interpolatedPrimaryState, "this.interpolatedPrimaryState", 223, 8520, 8595);
                }
                if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 224, 8653, 8665)) {
                    primaryMapper = CallChecker.beforeCalled(primaryMapper, EquationsMapper.class, 224, 8653, 8665);
                    interpolatedPrimaryDerivatives = new double[CallChecker.isCalled(primaryMapper, EquationsMapper.class, 224, 8653, 8665).getDimension()];
                    CallChecker.varAssign(this.interpolatedPrimaryDerivatives, "this.interpolatedPrimaryDerivatives", 224, 8607, 8682);
                }
                if ((secondaryMappers) == null) {
                    interpolatedSecondaryState = null;
                    CallChecker.varAssign(this.interpolatedSecondaryState, "this.interpolatedSecondaryState", 226, 8740, 8779);
                    interpolatedSecondaryDerivatives = null;
                    CallChecker.varAssign(this.interpolatedSecondaryDerivatives, "this.interpolatedSecondaryDerivatives", 227, 8795, 8834);
                }else {
                    interpolatedSecondaryState = new double[secondaryMappers.length][];
                    CallChecker.varAssign(this.interpolatedSecondaryState, "this.interpolatedSecondaryState", 229, 8869, 8941);
                    interpolatedSecondaryDerivatives = new double[secondaryMappers.length][];
                    CallChecker.varAssign(this.interpolatedSecondaryDerivatives, "this.interpolatedSecondaryDerivatives", 230, 8957, 9029);
                    for (int i = 0; i < (secondaryMappers.length); ++i) {
                        if (CallChecker.beforeDeref(interpolatedSecondaryState, double[][].class, 232, 9115, 9140)) {
                            secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 232, 9164, 9179);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 232, 9164, 9179)[i], EquationsMapper.class, 232, 9164, 9182)) {
                                interpolatedSecondaryState = CallChecker.beforeCalled(interpolatedSecondaryState, double[][].class, 232, 9115, 9140);
                                secondaryMappers[i] = CallChecker.beforeCalled(secondaryMappers[i], EquationsMapper.class, 232, 9164, 9182);
                                CallChecker.isCalled(interpolatedSecondaryState, double[][].class, 232, 9115, 9140)[i] = new double[CallChecker.isCalled(secondaryMappers[i], EquationsMapper.class, 232, 9164, 9182).getDimension()];
                                CallChecker.varAssign(CallChecker.isCalled(this.interpolatedSecondaryState, double[][].class, 232, 9115, 9140)[i], "CallChecker.isCalled(this.interpolatedSecondaryState, double[][].class, 232, 9115, 9140)[i]", 232, 9115, 9199);
                            }
                        }
                        if (CallChecker.beforeDeref(interpolatedSecondaryDerivatives, double[][].class, 233, 9219, 9250)) {
                            secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 233, 9268, 9283);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 233, 9268, 9283)[i], EquationsMapper.class, 233, 9268, 9286)) {
                                interpolatedSecondaryDerivatives = CallChecker.beforeCalled(interpolatedSecondaryDerivatives, double[][].class, 233, 9219, 9250);
                                secondaryMappers[i] = CallChecker.beforeCalled(secondaryMappers[i], EquationsMapper.class, 233, 9268, 9286);
                                CallChecker.isCalled(interpolatedSecondaryDerivatives, double[][].class, 233, 9219, 9250)[i] = new double[CallChecker.isCalled(secondaryMappers[i], EquationsMapper.class, 233, 9268, 9286).getDimension()];
                                CallChecker.varAssign(CallChecker.isCalled(this.interpolatedSecondaryDerivatives, double[][].class, 233, 9219, 9250)[i], "CallChecker.isCalled(this.interpolatedSecondaryDerivatives, double[][].class, 233, 9219, 9250)[i]", 233, 9219, 9303);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2432.methodEnd();
        }
    }

    protected void reinitialize(final double[] y, final boolean isForward, final EquationsMapper primary, final EquationsMapper[] secondary) {
        MethodContext _bcornu_methode_context2433 = new MethodContext(void.class, 245, 9348, 10377);
        try {
            CallChecker.varInit(this, "this", 245, 9348, 10377);
            CallChecker.varInit(secondary, "secondary", 245, 9348, 10377);
            CallChecker.varInit(primary, "primary", 245, 9348, 10377);
            CallChecker.varInit(isForward, "isForward", 245, 9348, 10377);
            CallChecker.varInit(y, "y", 245, 9348, 10377);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 245, 9348, 10377);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 245, 9348, 10377);
            CallChecker.varInit(this.dirtyState, "dirtyState", 245, 9348, 10377);
            CallChecker.varInit(this.forward, "forward", 245, 9348, 10377);
            CallChecker.varInit(this.finalized, "finalized", 245, 9348, 10377);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 245, 9348, 10377);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 245, 9348, 10377);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 245, 9348, 10377);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 245, 9348, 10377);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 245, 9348, 10377);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 245, 9348, 10377);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 245, 9348, 10377);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 245, 9348, 10377);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 245, 9348, 10377);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 245, 9348, 10377);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 245, 9348, 10377);
            CallChecker.varInit(this.currentState, "currentState", 245, 9348, 10377);
            CallChecker.varInit(this.h, "h", 245, 9348, 10377);
            globalPreviousTime = Double.NaN;
            CallChecker.varAssign(this.globalPreviousTime, "this.globalPreviousTime", 249, 9873, 9907);
            globalCurrentTime = Double.NaN;
            CallChecker.varAssign(this.globalCurrentTime, "this.globalCurrentTime", 250, 9913, 9947);
            softPreviousTime = Double.NaN;
            CallChecker.varAssign(this.softPreviousTime, "this.softPreviousTime", 251, 9953, 9987);
            softCurrentTime = Double.NaN;
            CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 252, 9993, 10027);
            h = Double.NaN;
            CallChecker.varAssign(this.h, "this.h", 253, 10033, 10067);
            interpolatedTime = Double.NaN;
            CallChecker.varAssign(this.interpolatedTime, "this.interpolatedTime", 254, 10073, 10107);
            currentState = y;
            CallChecker.varAssign(this.currentState, "this.currentState", 255, 10113, 10138);
            finalized = false;
            CallChecker.varAssign(this.finalized, "this.finalized", 256, 10144, 10173);
            this.forward = isForward;
            CallChecker.varAssign(this.forward, "this.forward", 257, 10179, 10212);
            this.dirtyState = true;
            CallChecker.varAssign(this.dirtyState, "this.dirtyState", 258, 10218, 10246);
            this.primaryMapper = primary;
            CallChecker.varAssign(this.primaryMapper, "this.primaryMapper", 259, 10252, 10283);
            if (CallChecker.beforeDeref(secondary, EquationsMapper[].class, 260, 10313, 10321)) {
                this.secondaryMappers = CallChecker.isCalled(secondary, EquationsMapper[].class, 260, 10313, 10321).clone();
                CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 260, 10289, 10330);
            }
            if (CallChecker.beforeDeref(y, double[].class, 261, 10363, 10363)) {
                allocateInterpolatedArrays(CallChecker.isCalled(y, double[].class, 261, 10363, 10363).length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2433.methodEnd();
        }
    }

    public StepInterpolator copy() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2434 = new MethodContext(StepInterpolator.class, 266, 10382, 10614);
        try {
            CallChecker.varInit(this, "this", 266, 10382, 10614);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 266, 10382, 10614);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 266, 10382, 10614);
            CallChecker.varInit(this.dirtyState, "dirtyState", 266, 10382, 10614);
            CallChecker.varInit(this.forward, "forward", 266, 10382, 10614);
            CallChecker.varInit(this.finalized, "finalized", 266, 10382, 10614);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 266, 10382, 10614);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 266, 10382, 10614);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 266, 10382, 10614);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 266, 10382, 10614);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 266, 10382, 10614);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 266, 10382, 10614);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 266, 10382, 10614);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 266, 10382, 10614);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 266, 10382, 10614);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 266, 10382, 10614);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 266, 10382, 10614);
            CallChecker.varInit(this.currentState, "currentState", 266, 10382, 10614);
            CallChecker.varInit(this.h, "h", 266, 10382, 10614);
            finalizeStep();
            return doCopy();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2434.methodEnd();
        }
    }

    protected abstract StepInterpolator doCopy();

    public void shift() {
        MethodContext _bcornu_methode_context2436 = new MethodContext(void.class, 289, 10971, 11302);
        try {
            CallChecker.varInit(this, "this", 289, 10971, 11302);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 289, 10971, 11302);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 289, 10971, 11302);
            CallChecker.varInit(this.dirtyState, "dirtyState", 289, 10971, 11302);
            CallChecker.varInit(this.forward, "forward", 289, 10971, 11302);
            CallChecker.varInit(this.finalized, "finalized", 289, 10971, 11302);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 289, 10971, 11302);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 289, 10971, 11302);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 289, 10971, 11302);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 289, 10971, 11302);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 289, 10971, 11302);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 289, 10971, 11302);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 289, 10971, 11302);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 289, 10971, 11302);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 289, 10971, 11302);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 289, 10971, 11302);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 289, 10971, 11302);
            CallChecker.varInit(this.currentState, "currentState", 289, 10971, 11302);
            CallChecker.varInit(this.h, "h", 289, 10971, 11302);
            globalPreviousTime = globalCurrentTime;
            CallChecker.varAssign(this.globalPreviousTime, "this.globalPreviousTime", 290, 11171, 11209);
            softPreviousTime = globalPreviousTime;
            CallChecker.varAssign(this.softPreviousTime, "this.softPreviousTime", 291, 11215, 11254);
            softCurrentTime = globalCurrentTime;
            CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 292, 11260, 11298);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2436.methodEnd();
        }
    }

    public void storeTime(final double t) {
        MethodContext _bcornu_methode_context2437 = new MethodContext(void.class, 298, 11307, 11647);
        try {
            CallChecker.varInit(this, "this", 298, 11307, 11647);
            CallChecker.varInit(t, "t", 298, 11307, 11647);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 298, 11307, 11647);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 298, 11307, 11647);
            CallChecker.varInit(this.dirtyState, "dirtyState", 298, 11307, 11647);
            CallChecker.varInit(this.forward, "forward", 298, 11307, 11647);
            CallChecker.varInit(this.finalized, "finalized", 298, 11307, 11647);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 298, 11307, 11647);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 298, 11307, 11647);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 298, 11307, 11647);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 298, 11307, 11647);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 298, 11307, 11647);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 298, 11307, 11647);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 298, 11307, 11647);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 298, 11307, 11647);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 298, 11307, 11647);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 298, 11307, 11647);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 298, 11307, 11647);
            CallChecker.varInit(this.currentState, "currentState", 298, 11307, 11647);
            CallChecker.varInit(this.h, "h", 298, 11307, 11647);
            globalCurrentTime = t;
            CallChecker.varAssign(this.globalCurrentTime, "this.globalCurrentTime", 300, 11420, 11441);
            softCurrentTime = globalCurrentTime;
            CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 301, 11447, 11484);
            h = (globalCurrentTime) - (globalPreviousTime);
            CallChecker.varAssign(this.h, "this.h", 302, 11490, 11548);
            setInterpolatedTime(t);
            finalized = false;
            CallChecker.varAssign(this.finalized, "this.finalized", 306, 11624, 11642);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2437.methodEnd();
        }
    }

    public void setSoftPreviousTime(final double softPreviousTime) {
        MethodContext _bcornu_methode_context2438 = new MethodContext(void.class, 320, 11652, 12179);
        try {
            CallChecker.varInit(this, "this", 320, 11652, 12179);
            CallChecker.varInit(softPreviousTime, "softPreviousTime", 320, 11652, 12179);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 320, 11652, 12179);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 320, 11652, 12179);
            CallChecker.varInit(this.dirtyState, "dirtyState", 320, 11652, 12179);
            CallChecker.varInit(this.forward, "forward", 320, 11652, 12179);
            CallChecker.varInit(this.finalized, "finalized", 320, 11652, 12179);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 320, 11652, 12179);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 320, 11652, 12179);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 320, 11652, 12179);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 320, 11652, 12179);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 320, 11652, 12179);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 320, 11652, 12179);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 320, 11652, 12179);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 320, 11652, 12179);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 320, 11652, 12179);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 320, 11652, 12179);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 320, 11652, 12179);
            CallChecker.varInit(this.currentState, "currentState", 320, 11652, 12179);
            CallChecker.varInit(this.h, "h", 320, 11652, 12179);
            this.softPreviousTime = softPreviousTime;
            CallChecker.varAssign(this.softPreviousTime, "this.softPreviousTime", 321, 12135, 12175);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2438.methodEnd();
        }
    }

    public void setSoftCurrentTime(final double softCurrentTime) {
        MethodContext _bcornu_methode_context2439 = new MethodContext(void.class, 334, 12184, 12704);
        try {
            CallChecker.varInit(this, "this", 334, 12184, 12704);
            CallChecker.varInit(softCurrentTime, "softCurrentTime", 334, 12184, 12704);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 334, 12184, 12704);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 334, 12184, 12704);
            CallChecker.varInit(this.dirtyState, "dirtyState", 334, 12184, 12704);
            CallChecker.varInit(this.forward, "forward", 334, 12184, 12704);
            CallChecker.varInit(this.finalized, "finalized", 334, 12184, 12704);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 334, 12184, 12704);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 334, 12184, 12704);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 334, 12184, 12704);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 334, 12184, 12704);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 334, 12184, 12704);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 334, 12184, 12704);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 334, 12184, 12704);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 334, 12184, 12704);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 334, 12184, 12704);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 334, 12184, 12704);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 334, 12184, 12704);
            CallChecker.varInit(this.currentState, "currentState", 334, 12184, 12704);
            CallChecker.varInit(this.h, "h", 334, 12184, 12704);
            this.softCurrentTime = softCurrentTime;
            CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 335, 12661, 12700);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2439.methodEnd();
        }
    }

    public double getGlobalPreviousTime() {
        MethodContext _bcornu_methode_context2440 = new MethodContext(double.class, 342, 12709, 12885);
        try {
            CallChecker.varInit(this, "this", 342, 12709, 12885);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 342, 12709, 12885);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 342, 12709, 12885);
            CallChecker.varInit(this.dirtyState, "dirtyState", 342, 12709, 12885);
            CallChecker.varInit(this.forward, "forward", 342, 12709, 12885);
            CallChecker.varInit(this.finalized, "finalized", 342, 12709, 12885);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 342, 12709, 12885);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 342, 12709, 12885);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 342, 12709, 12885);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 342, 12709, 12885);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 342, 12709, 12885);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 342, 12709, 12885);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 342, 12709, 12885);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 342, 12709, 12885);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 342, 12709, 12885);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 342, 12709, 12885);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 342, 12709, 12885);
            CallChecker.varInit(this.currentState, "currentState", 342, 12709, 12885);
            CallChecker.varInit(this.h, "h", 342, 12709, 12885);
            return globalPreviousTime;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2440.methodEnd();
        }
    }

    public double getGlobalCurrentTime() {
        MethodContext _bcornu_methode_context2441 = new MethodContext(double.class, 350, 12890, 13062);
        try {
            CallChecker.varInit(this, "this", 350, 12890, 13062);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 350, 12890, 13062);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 350, 12890, 13062);
            CallChecker.varInit(this.dirtyState, "dirtyState", 350, 12890, 13062);
            CallChecker.varInit(this.forward, "forward", 350, 12890, 13062);
            CallChecker.varInit(this.finalized, "finalized", 350, 12890, 13062);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 350, 12890, 13062);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 350, 12890, 13062);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 350, 12890, 13062);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 350, 12890, 13062);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 350, 12890, 13062);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 350, 12890, 13062);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 350, 12890, 13062);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 350, 12890, 13062);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 350, 12890, 13062);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 350, 12890, 13062);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 350, 12890, 13062);
            CallChecker.varInit(this.currentState, "currentState", 350, 12890, 13062);
            CallChecker.varInit(this.h, "h", 350, 12890, 13062);
            return globalCurrentTime;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2441.methodEnd();
        }
    }

    public double getPreviousTime() {
        MethodContext _bcornu_methode_context2442 = new MethodContext(double.class, 359, 13067, 13270);
        try {
            CallChecker.varInit(this, "this", 359, 13067, 13270);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 359, 13067, 13270);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 359, 13067, 13270);
            CallChecker.varInit(this.dirtyState, "dirtyState", 359, 13067, 13270);
            CallChecker.varInit(this.forward, "forward", 359, 13067, 13270);
            CallChecker.varInit(this.finalized, "finalized", 359, 13067, 13270);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 359, 13067, 13270);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 359, 13067, 13270);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 359, 13067, 13270);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 359, 13067, 13270);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 359, 13067, 13270);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 359, 13067, 13270);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 359, 13067, 13270);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 359, 13067, 13270);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 359, 13067, 13270);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 359, 13067, 13270);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 359, 13067, 13270);
            CallChecker.varInit(this.currentState, "currentState", 359, 13067, 13270);
            CallChecker.varInit(this.h, "h", 359, 13067, 13270);
            return softPreviousTime;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2442.methodEnd();
        }
    }

    public double getCurrentTime() {
        MethodContext _bcornu_methode_context2443 = new MethodContext(double.class, 368, 13275, 13473);
        try {
            CallChecker.varInit(this, "this", 368, 13275, 13473);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 368, 13275, 13473);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 368, 13275, 13473);
            CallChecker.varInit(this.dirtyState, "dirtyState", 368, 13275, 13473);
            CallChecker.varInit(this.forward, "forward", 368, 13275, 13473);
            CallChecker.varInit(this.finalized, "finalized", 368, 13275, 13473);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 368, 13275, 13473);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 368, 13275, 13473);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 368, 13275, 13473);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 368, 13275, 13473);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 368, 13275, 13473);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 368, 13275, 13473);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 368, 13275, 13473);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 368, 13275, 13473);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 368, 13275, 13473);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 368, 13275, 13473);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 368, 13275, 13473);
            CallChecker.varInit(this.currentState, "currentState", 368, 13275, 13473);
            CallChecker.varInit(this.h, "h", 368, 13275, 13473);
            return softCurrentTime;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2443.methodEnd();
        }
    }

    public double getInterpolatedTime() {
        MethodContext _bcornu_methode_context2444 = new MethodContext(double.class, 373, 13478, 13570);
        try {
            CallChecker.varInit(this, "this", 373, 13478, 13570);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 373, 13478, 13570);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 373, 13478, 13570);
            CallChecker.varInit(this.dirtyState, "dirtyState", 373, 13478, 13570);
            CallChecker.varInit(this.forward, "forward", 373, 13478, 13570);
            CallChecker.varInit(this.finalized, "finalized", 373, 13478, 13570);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 373, 13478, 13570);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 373, 13478, 13570);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 373, 13478, 13570);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 373, 13478, 13570);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 373, 13478, 13570);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 373, 13478, 13570);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 373, 13478, 13570);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 373, 13478, 13570);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 373, 13478, 13570);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 373, 13478, 13570);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 373, 13478, 13570);
            CallChecker.varInit(this.currentState, "currentState", 373, 13478, 13570);
            CallChecker.varInit(this.h, "h", 373, 13478, 13570);
            return interpolatedTime;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2444.methodEnd();
        }
    }

    public void setInterpolatedTime(final double time) {
        MethodContext _bcornu_methode_context2445 = new MethodContext(void.class, 378, 13575, 13715);
        try {
            CallChecker.varInit(this, "this", 378, 13575, 13715);
            CallChecker.varInit(time, "time", 378, 13575, 13715);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 378, 13575, 13715);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 378, 13575, 13715);
            CallChecker.varInit(this.dirtyState, "dirtyState", 378, 13575, 13715);
            CallChecker.varInit(this.forward, "forward", 378, 13575, 13715);
            CallChecker.varInit(this.finalized, "finalized", 378, 13575, 13715);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 378, 13575, 13715);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 378, 13575, 13715);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 378, 13575, 13715);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 378, 13575, 13715);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 378, 13575, 13715);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 378, 13575, 13715);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 378, 13575, 13715);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 378, 13575, 13715);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 378, 13575, 13715);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 378, 13575, 13715);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 378, 13575, 13715);
            CallChecker.varInit(this.currentState, "currentState", 378, 13575, 13715);
            CallChecker.varInit(this.h, "h", 378, 13575, 13715);
            interpolatedTime = time;
            CallChecker.varAssign(this.interpolatedTime, "this.interpolatedTime", 379, 13657, 13680);
            dirtyState = true;
            CallChecker.varAssign(this.dirtyState, "this.dirtyState", 380, 13688, 13711);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2445.methodEnd();
        }
    }

    public boolean isForward() {
        MethodContext _bcornu_methode_context2446 = new MethodContext(boolean.class, 384, 13720, 13794);
        try {
            CallChecker.varInit(this, "this", 384, 13720, 13794);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 384, 13720, 13794);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 384, 13720, 13794);
            CallChecker.varInit(this.dirtyState, "dirtyState", 384, 13720, 13794);
            CallChecker.varInit(this.forward, "forward", 384, 13720, 13794);
            CallChecker.varInit(this.finalized, "finalized", 384, 13720, 13794);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 384, 13720, 13794);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 384, 13720, 13794);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 384, 13720, 13794);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 384, 13720, 13794);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 384, 13720, 13794);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 384, 13720, 13794);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 384, 13720, 13794);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 384, 13720, 13794);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 384, 13720, 13794);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 384, 13720, 13794);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 384, 13720, 13794);
            CallChecker.varInit(this.currentState, "currentState", 384, 13720, 13794);
            CallChecker.varInit(this.h, "h", 384, 13720, 13794);
            return forward;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2446.methodEnd();
        }
    }

    protected abstract void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) throws MaxCountExceededException;

    private void evaluateCompleteInterpolatedState() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2448 = new MethodContext(void.class, 404, 14537, 15105);
        try {
            CallChecker.varInit(this, "this", 404, 14537, 15105);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 404, 14537, 15105);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 404, 14537, 15105);
            CallChecker.varInit(this.dirtyState, "dirtyState", 404, 14537, 15105);
            CallChecker.varInit(this.forward, "forward", 404, 14537, 15105);
            CallChecker.varInit(this.finalized, "finalized", 404, 14537, 15105);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 404, 14537, 15105);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 404, 14537, 15105);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 404, 14537, 15105);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 404, 14537, 15105);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 404, 14537, 15105);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 404, 14537, 15105);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 404, 14537, 15105);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 404, 14537, 15105);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 404, 14537, 15105);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 404, 14537, 15105);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 404, 14537, 15105);
            CallChecker.varInit(this.currentState, "currentState", 404, 14537, 15105);
            CallChecker.varInit(this.h, "h", 404, 14537, 15105);
            if (dirtyState) {
                final double oneMinusThetaH = CallChecker.varInit(((double) ((this.globalCurrentTime) - (this.interpolatedTime))), "oneMinusThetaH", 408, 14852, 14918);
                double theta = CallChecker.init(double.class);
                if ((h) == 0) {
                    theta = 0;
                    CallChecker.varAssign(theta, "theta", 409, 14951, 14989);
                }else {
                    theta = ((h) - oneMinusThetaH) / (h);
                    CallChecker.varAssign(theta, "theta", 409, 14951, 14989);
                }
                computeInterpolatedStateAndDerivatives(theta, oneMinusThetaH);
                dirtyState = false;
                CallChecker.varAssign(this.dirtyState, "this.dirtyState", 411, 15075, 15093);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2448.methodEnd();
        }
    }

    public double[] getInterpolatedState() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2449 = new MethodContext(double[].class, 416, 15110, 15417);
        try {
            CallChecker.varInit(this, "this", 416, 15110, 15417);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 416, 15110, 15417);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 416, 15110, 15417);
            CallChecker.varInit(this.dirtyState, "dirtyState", 416, 15110, 15417);
            CallChecker.varInit(this.forward, "forward", 416, 15110, 15417);
            CallChecker.varInit(this.finalized, "finalized", 416, 15110, 15417);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 416, 15110, 15417);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 416, 15110, 15417);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 416, 15110, 15417);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 416, 15110, 15417);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 416, 15110, 15417);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 416, 15110, 15417);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 416, 15110, 15417);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 416, 15110, 15417);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 416, 15110, 15417);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 416, 15110, 15417);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 416, 15110, 15417);
            CallChecker.varInit(this.currentState, "currentState", 416, 15110, 15417);
            CallChecker.varInit(this.h, "h", 416, 15110, 15417);
            evaluateCompleteInterpolatedState();
            if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 418, 15256, 15268)) {
                primaryMapper = CallChecker.beforeCalled(primaryMapper, EquationsMapper.class, 418, 15256, 15268);
                CallChecker.isCalled(primaryMapper, EquationsMapper.class, 418, 15256, 15268).extractEquationData(interpolatedState, interpolatedPrimaryState);
            }
            return interpolatedPrimaryState;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2449.methodEnd();
        }
    }

    public double[] getInterpolatedDerivatives() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2450 = new MethodContext(double[].class, 424, 15422, 15753);
        try {
            CallChecker.varInit(this, "this", 424, 15422, 15753);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 424, 15422, 15753);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 424, 15422, 15753);
            CallChecker.varInit(this.dirtyState, "dirtyState", 424, 15422, 15753);
            CallChecker.varInit(this.forward, "forward", 424, 15422, 15753);
            CallChecker.varInit(this.finalized, "finalized", 424, 15422, 15753);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 424, 15422, 15753);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 424, 15422, 15753);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 424, 15422, 15753);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 424, 15422, 15753);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 424, 15422, 15753);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 424, 15422, 15753);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 424, 15422, 15753);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 424, 15422, 15753);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 424, 15422, 15753);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 424, 15422, 15753);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 424, 15422, 15753);
            CallChecker.varInit(this.currentState, "currentState", 424, 15422, 15753);
            CallChecker.varInit(this.h, "h", 424, 15422, 15753);
            evaluateCompleteInterpolatedState();
            if (CallChecker.beforeDeref(primaryMapper, EquationsMapper.class, 426, 15574, 15586)) {
                primaryMapper = CallChecker.beforeCalled(primaryMapper, EquationsMapper.class, 426, 15574, 15586);
                CallChecker.isCalled(primaryMapper, EquationsMapper.class, 426, 15574, 15586).extractEquationData(interpolatedDerivatives, interpolatedPrimaryDerivatives);
            }
            return interpolatedPrimaryDerivatives;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2450.methodEnd();
        }
    }

    public double[] getInterpolatedSecondaryState(final int index) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2451 = new MethodContext(double[].class, 432, 15758, 16127);
        try {
            CallChecker.varInit(this, "this", 432, 15758, 16127);
            CallChecker.varInit(index, "index", 432, 15758, 16127);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 432, 15758, 16127);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 432, 15758, 16127);
            CallChecker.varInit(this.dirtyState, "dirtyState", 432, 15758, 16127);
            CallChecker.varInit(this.forward, "forward", 432, 15758, 16127);
            CallChecker.varInit(this.finalized, "finalized", 432, 15758, 16127);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 432, 15758, 16127);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 432, 15758, 16127);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 432, 15758, 16127);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 432, 15758, 16127);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 432, 15758, 16127);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 432, 15758, 16127);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 432, 15758, 16127);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 432, 15758, 16127);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 432, 15758, 16127);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 432, 15758, 16127);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 432, 15758, 16127);
            CallChecker.varInit(this.currentState, "currentState", 432, 15758, 16127);
            CallChecker.varInit(this.h, "h", 432, 15758, 16127);
            evaluateCompleteInterpolatedState();
            if (CallChecker.beforeDeref(secondaryMappers, EquationsMapper[].class, 434, 15928, 15943)) {
                if (CallChecker.beforeDeref(interpolatedSecondaryState, double[][].class, 435, 16041, 16066)) {
                    secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 434, 15928, 15943);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 434, 15928, 15943)[index], EquationsMapper.class, 434, 15928, 15950)) {
                        secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 434, 15928, 15943);
                        interpolatedSecondaryState = CallChecker.beforeCalled(interpolatedSecondaryState, double[][].class, 435, 16041, 16066);
                        CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 434, 15928, 15943)[index] = CallChecker.beforeCalled(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 434, 15928, 15943)[index], EquationsMapper.class, 434, 15928, 15950);
                        CallChecker.isCalled(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 434, 15928, 15943)[index], EquationsMapper.class, 434, 15928, 15950).extractEquationData(interpolatedState, CallChecker.isCalled(interpolatedSecondaryState, double[][].class, 435, 16041, 16066)[index]);
                    }
                }
            }
            if (CallChecker.beforeDeref(interpolatedSecondaryState, double[][].class, 436, 16090, 16115)) {
                interpolatedSecondaryState = CallChecker.beforeCalled(interpolatedSecondaryState, double[][].class, 436, 16090, 16115);
                return CallChecker.isCalled(interpolatedSecondaryState, double[][].class, 436, 16090, 16115)[index];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2451.methodEnd();
        }
    }

    public double[] getInterpolatedSecondaryDerivatives(final int index) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2452 = new MethodContext(double[].class, 440, 16132, 16525);
        try {
            CallChecker.varInit(this, "this", 440, 16132, 16525);
            CallChecker.varInit(index, "index", 440, 16132, 16525);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 440, 16132, 16525);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 440, 16132, 16525);
            CallChecker.varInit(this.dirtyState, "dirtyState", 440, 16132, 16525);
            CallChecker.varInit(this.forward, "forward", 440, 16132, 16525);
            CallChecker.varInit(this.finalized, "finalized", 440, 16132, 16525);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 440, 16132, 16525);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 440, 16132, 16525);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 440, 16132, 16525);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 440, 16132, 16525);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 440, 16132, 16525);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 440, 16132, 16525);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 440, 16132, 16525);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 440, 16132, 16525);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 440, 16132, 16525);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 440, 16132, 16525);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 440, 16132, 16525);
            CallChecker.varInit(this.currentState, "currentState", 440, 16132, 16525);
            CallChecker.varInit(this.h, "h", 440, 16132, 16525);
            evaluateCompleteInterpolatedState();
            if (CallChecker.beforeDeref(secondaryMappers, EquationsMapper[].class, 442, 16308, 16323)) {
                if (CallChecker.beforeDeref(interpolatedSecondaryDerivatives, double[][].class, 443, 16427, 16458)) {
                    secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 442, 16308, 16323);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 442, 16308, 16323)[index], EquationsMapper.class, 442, 16308, 16330)) {
                        secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 442, 16308, 16323);
                        interpolatedSecondaryDerivatives = CallChecker.beforeCalled(interpolatedSecondaryDerivatives, double[][].class, 443, 16427, 16458);
                        CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 442, 16308, 16323)[index] = CallChecker.beforeCalled(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 442, 16308, 16323)[index], EquationsMapper.class, 442, 16308, 16330);
                        CallChecker.isCalled(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 442, 16308, 16323)[index], EquationsMapper.class, 442, 16308, 16330).extractEquationData(interpolatedDerivatives, CallChecker.isCalled(interpolatedSecondaryDerivatives, double[][].class, 443, 16427, 16458)[index]);
                    }
                }
            }
            if (CallChecker.beforeDeref(interpolatedSecondaryDerivatives, double[][].class, 444, 16482, 16513)) {
                interpolatedSecondaryDerivatives = CallChecker.beforeCalled(interpolatedSecondaryDerivatives, double[][].class, 444, 16482, 16513);
                return CallChecker.isCalled(interpolatedSecondaryDerivatives, double[][].class, 444, 16482, 16513)[index];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2452.methodEnd();
        }
    }

    public final void finalizeStep() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2453 = new MethodContext(void.class, 488, 16530, 18783);
        try {
            CallChecker.varInit(this, "this", 488, 16530, 18783);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 488, 16530, 18783);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 488, 16530, 18783);
            CallChecker.varInit(this.dirtyState, "dirtyState", 488, 16530, 18783);
            CallChecker.varInit(this.forward, "forward", 488, 16530, 18783);
            CallChecker.varInit(this.finalized, "finalized", 488, 16530, 18783);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 488, 16530, 18783);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 488, 16530, 18783);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 488, 16530, 18783);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 488, 16530, 18783);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 488, 16530, 18783);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 488, 16530, 18783);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 488, 16530, 18783);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 488, 16530, 18783);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 488, 16530, 18783);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 488, 16530, 18783);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 488, 16530, 18783);
            CallChecker.varInit(this.currentState, "currentState", 488, 16530, 18783);
            CallChecker.varInit(this.h, "h", 488, 16530, 18783);
            if (!(finalized)) {
                doFinalize();
                finalized = true;
                CallChecker.varAssign(this.finalized, "this.finalized", 491, 18757, 18773);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2453.methodEnd();
        }
    }

    protected void doFinalize() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2454 = new MethodContext(void.class, 500, 18788, 19050);
        try {
            CallChecker.varInit(this, "this", 500, 18788, 19050);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 500, 18788, 19050);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 500, 18788, 19050);
            CallChecker.varInit(this.dirtyState, "dirtyState", 500, 18788, 19050);
            CallChecker.varInit(this.forward, "forward", 500, 18788, 19050);
            CallChecker.varInit(this.finalized, "finalized", 500, 18788, 19050);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 500, 18788, 19050);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 500, 18788, 19050);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 500, 18788, 19050);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 500, 18788, 19050);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 500, 18788, 19050);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 500, 18788, 19050);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 500, 18788, 19050);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 500, 18788, 19050);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 500, 18788, 19050);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 500, 18788, 19050);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 500, 18788, 19050);
            CallChecker.varInit(this.currentState, "currentState", 500, 18788, 19050);
            CallChecker.varInit(this.h, "h", 500, 18788, 19050);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2454.methodEnd();
        }
    }

    public abstract void writeExternal(ObjectOutput out) throws IOException;

    public abstract void readExternal(ObjectInput in) throws IOException, ClassNotFoundException;

    protected void writeBaseExternal(final ObjectOutput out) throws IOException {
        MethodContext _bcornu_methode_context2457 = new MethodContext(void.class, 517, 19282, 20683);
        try {
            CallChecker.varInit(this, "this", 517, 19282, 20683);
            CallChecker.varInit(out, "out", 517, 19282, 20683);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 517, 19282, 20683);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 517, 19282, 20683);
            CallChecker.varInit(this.dirtyState, "dirtyState", 517, 19282, 20683);
            CallChecker.varInit(this.forward, "forward", 517, 19282, 20683);
            CallChecker.varInit(this.finalized, "finalized", 517, 19282, 20683);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 517, 19282, 20683);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 517, 19282, 20683);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 517, 19282, 20683);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 517, 19282, 20683);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 517, 19282, 20683);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 517, 19282, 20683);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 517, 19282, 20683);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 517, 19282, 20683);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 517, 19282, 20683);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 517, 19282, 20683);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 517, 19282, 20683);
            CallChecker.varInit(this.currentState, "currentState", 517, 19282, 20683);
            CallChecker.varInit(this.h, "h", 517, 19282, 20683);
            if ((currentState) == null) {
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 521, 19633, 19635)) {
                    CallChecker.isCalled(out, ObjectOutput.class, 521, 19633, 19635).writeInt((-1));
                }
            }else {
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 523, 19672, 19674)) {
                    CallChecker.isCalled(out, ObjectOutput.class, 523, 19672, 19674).writeInt(currentState.length);
                }
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 525, 19717, 19719)) {
                CallChecker.isCalled(out, ObjectOutput.class, 525, 19717, 19719).writeDouble(globalPreviousTime);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 526, 19758, 19760)) {
                CallChecker.isCalled(out, ObjectOutput.class, 526, 19758, 19760).writeDouble(globalCurrentTime);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 527, 19798, 19800)) {
                CallChecker.isCalled(out, ObjectOutput.class, 527, 19798, 19800).writeDouble(softPreviousTime);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 528, 19837, 19839)) {
                CallChecker.isCalled(out, ObjectOutput.class, 528, 19837, 19839).writeDouble(softCurrentTime);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 529, 19875, 19877)) {
                CallChecker.isCalled(out, ObjectOutput.class, 529, 19875, 19877).writeDouble(h);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 530, 19899, 19901)) {
                CallChecker.isCalled(out, ObjectOutput.class, 530, 19899, 19901).writeBoolean(forward);
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 531, 19930, 19932)) {
                CallChecker.isCalled(out, ObjectOutput.class, 531, 19930, 19932).writeObject(primaryMapper);
            }
            if (CallChecker.beforeDeref(secondaryMappers, EquationsMapper[].class, 532, 19976, 19991)) {
                if (CallChecker.beforeDeref(out, ObjectOutput.class, 532, 19966, 19968)) {
                    secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 532, 19976, 19991);
                    CallChecker.isCalled(out, ObjectOutput.class, 532, 19966, 19968).write(CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 532, 19976, 19991).length);
                }
            }
            if (CallChecker.beforeDeref(secondaryMappers, void.class, 533, 20043, 20058)) {
                for (final EquationsMapper mapper : secondaryMappers) {
                    if (CallChecker.beforeDeref(out, ObjectOutput.class, 534, 20071, 20073)) {
                        CallChecker.isCalled(out, ObjectOutput.class, 534, 20071, 20073).writeObject(mapper);
                    }
                }
            }
            if ((currentState) != null) {
                for (int i = 0; i < (currentState.length); ++i) {
                    if (CallChecker.beforeDeref(out, ObjectOutput.class, 539, 20203, 20205)) {
                        CallChecker.isCalled(out, ObjectOutput.class, 539, 20203, 20205).writeDouble(currentState[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 543, 20258, 20260)) {
                CallChecker.isCalled(out, ObjectOutput.class, 543, 20258, 20260).writeDouble(interpolatedTime);
            }
            TryContext _bcornu_try_context_42 = new TryContext(42, AbstractStepInterpolator.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                finalizeStep();
            } catch (MaxCountExceededException mcee) {
                _bcornu_try_context_42.catchStart(42);
                final IOException ioe = CallChecker.varInit(new IOException(mcee.getLocalizedMessage()), "ioe", 552, 20557, 20624);
                if (CallChecker.beforeDeref(ioe, IOException.class, 553, 20634, 20636)) {
                    CallChecker.isCalled(ioe, IOException.class, 553, 20634, 20636).initCause(mcee);
                }
                throw ioe;
            } finally {
                _bcornu_try_context_42.finallyStart(42);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2457.methodEnd();
        }
    }

    protected double readBaseExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2458 = new MethodContext(double.class, 570, 20688, 22364);
        try {
            CallChecker.varInit(this, "this", 570, 20688, 22364);
            CallChecker.varInit(in, "in", 570, 20688, 22364);
            CallChecker.varInit(this.secondaryMappers, "secondaryMappers", 570, 20688, 22364);
            CallChecker.varInit(this.primaryMapper, "primaryMapper", 570, 20688, 22364);
            CallChecker.varInit(this.dirtyState, "dirtyState", 570, 20688, 22364);
            CallChecker.varInit(this.forward, "forward", 570, 20688, 22364);
            CallChecker.varInit(this.finalized, "finalized", 570, 20688, 22364);
            CallChecker.varInit(this.softCurrentTime, "softCurrentTime", 570, 20688, 22364);
            CallChecker.varInit(this.softPreviousTime, "softPreviousTime", 570, 20688, 22364);
            CallChecker.varInit(this.globalCurrentTime, "globalCurrentTime", 570, 20688, 22364);
            CallChecker.varInit(this.globalPreviousTime, "globalPreviousTime", 570, 20688, 22364);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 570, 20688, 22364);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 570, 20688, 22364);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 570, 20688, 22364);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 570, 20688, 22364);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 570, 20688, 22364);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 570, 20688, 22364);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 570, 20688, 22364);
            CallChecker.varInit(this.currentState, "currentState", 570, 20688, 22364);
            CallChecker.varInit(this.h, "h", 570, 20688, 22364);
            final int dimension = CallChecker.varInit(((int) (CallChecker.isCalled(in, ObjectInput.class, 573, 21384, 21385).readInt())), "dimension", 573, 21362, 21396);
            if (CallChecker.beforeDeref(in, ObjectInput.class, 574, 21424, 21425)) {
                globalPreviousTime = CallChecker.isCalled(in, ObjectInput.class, 574, 21424, 21425).readDouble();
                CallChecker.varAssign(this.globalPreviousTime, "this.globalPreviousTime", 574, 21402, 21439);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 575, 21467, 21468)) {
                globalCurrentTime = CallChecker.isCalled(in, ObjectInput.class, 575, 21467, 21468).readDouble();
                CallChecker.varAssign(this.globalCurrentTime, "this.globalCurrentTime", 575, 21445, 21482);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 576, 21510, 21511)) {
                softPreviousTime = CallChecker.isCalled(in, ObjectInput.class, 576, 21510, 21511).readDouble();
                CallChecker.varAssign(this.softPreviousTime, "this.softPreviousTime", 576, 21488, 21525);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 577, 21553, 21554)) {
                softCurrentTime = CallChecker.isCalled(in, ObjectInput.class, 577, 21553, 21554).readDouble();
                CallChecker.varAssign(this.softCurrentTime, "this.softCurrentTime", 577, 21531, 21568);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 578, 21596, 21597)) {
                h = CallChecker.isCalled(in, ObjectInput.class, 578, 21596, 21597).readDouble();
                CallChecker.varAssign(this.h, "this.h", 578, 21574, 21611);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 579, 21639, 21640)) {
                forward = CallChecker.isCalled(in, ObjectInput.class, 579, 21639, 21640).readBoolean();
                CallChecker.varAssign(this.forward, "this.forward", 579, 21617, 21655);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 580, 21701, 21702)) {
                primaryMapper = ((EquationsMapper) (CallChecker.isCalled(in, ObjectInput.class, 580, 21701, 21702).readObject()));
                CallChecker.varAssign(this.primaryMapper, "this.primaryMapper", 580, 21661, 21716);
            }
            if (CallChecker.beforeDeref(in, ObjectInput.class, 581, 21764, 21765)) {
                secondaryMappers = new EquationsMapper[CallChecker.isCalled(in, ObjectInput.class, 581, 21764, 21765).read()];
                CallChecker.varAssign(this.secondaryMappers, "this.secondaryMappers", 581, 21722, 21774);
            }
            secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 582, 21800, 21815);
            for (int i = 0; i < (CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 582, 21800, 21815).length); ++i) {
                if (CallChecker.beforeDeref(secondaryMappers, EquationsMapper[].class, 583, 21840, 21855)) {
                    if (CallChecker.beforeDeref(in, ObjectInput.class, 583, 21880, 21881)) {
                        secondaryMappers = CallChecker.beforeCalled(secondaryMappers, EquationsMapper[].class, 583, 21840, 21855);
                        CallChecker.isCalled(secondaryMappers, EquationsMapper[].class, 583, 21840, 21855)[i] = ((EquationsMapper) (CallChecker.isCalled(in, ObjectInput.class, 583, 21880, 21881).readObject()));
                        CallChecker.varAssign(CallChecker.isCalled(this.secondaryMappers, EquationsMapper[].class, 583, 21840, 21855)[i], "CallChecker.isCalled(this.secondaryMappers, EquationsMapper[].class, 583, 21840, 21855)[i]", 583, 21840, 21895);
                    }
                }
            }
            dirtyState = true;
            CallChecker.varAssign(this.dirtyState, "this.dirtyState", 585, 21907, 21933);
            if (dimension < 0) {
                currentState = null;
                CallChecker.varAssign(this.currentState, "this.currentState", 588, 21969, 21988);
            }else {
                currentState = new double[dimension];
                CallChecker.varAssign(this.currentState, "this.currentState", 590, 22011, 22048);
                currentState = CallChecker.beforeCalled(currentState, double[].class, 591, 22078, 22089);
                for (int i = 0; i < (CallChecker.isCalled(currentState, double[].class, 591, 22078, 22089).length); ++i) {
                    if (CallChecker.beforeDeref(currentState, double[].class, 592, 22118, 22129)) {
                        if (CallChecker.beforeDeref(in, ObjectInput.class, 592, 22136, 22137)) {
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 592, 22118, 22129);
                            CallChecker.isCalled(currentState, double[].class, 592, 22118, 22129)[i] = CallChecker.isCalled(in, ObjectInput.class, 592, 22136, 22137).readDouble();
                            CallChecker.varAssign(CallChecker.isCalled(this.currentState, double[].class, 592, 22118, 22129)[i], "CallChecker.isCalled(this.currentState, double[].class, 592, 22118, 22129)[i]", 592, 22118, 22151);
                        }
                    }
                }
            }
            interpolatedTime = Double.NaN;
            CallChecker.varAssign(this.interpolatedTime, "this.interpolatedTime", 597, 22235, 22264);
            allocateInterpolatedArrays(dimension);
            finalized = true;
            CallChecker.varAssign(this.finalized, "this.finalized", 600, 22314, 22330);
            if (CallChecker.beforeDeref(in, ObjectInput.class, 602, 22344, 22345)) {
                return CallChecker.isCalled(in, ObjectInput.class, 602, 22344, 22345).readDouble();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2458.methodEnd();
        }
    }
}

