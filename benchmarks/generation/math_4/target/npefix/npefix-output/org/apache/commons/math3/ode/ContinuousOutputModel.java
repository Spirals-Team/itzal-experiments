package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

public class ContinuousOutputModel implements Serializable , StepHandler {
    private static final long serialVersionUID = -1417964919405031606L;

    private double initialTime;

    private double finalTime;

    private boolean forward;

    private int index;

    private List<StepInterpolator> steps;

    public ContinuousOutputModel() {
        ConstructorContext _bcornu_methode_context281 = new ConstructorContext(ContinuousOutputModel.class, 114, 4794, 5058);
        try {
            steps = new ArrayList<StepInterpolator>();
            CallChecker.varAssign(this.steps, "this.steps", 115, 4908, 4949);
            initialTime = Double.NaN;
            CallChecker.varAssign(this.initialTime, "this.initialTime", 116, 4955, 4979);
            finalTime = Double.NaN;
            CallChecker.varAssign(this.finalTime, "this.finalTime", 117, 4985, 5009);
            forward = true;
            CallChecker.varAssign(this.forward, "this.forward", 118, 5015, 5033);
            index = 0;
            CallChecker.varAssign(this.index, "this.index", 119, 5039, 5054);
        } finally {
            _bcornu_methode_context281.methodEnd();
        }
    }

    public void append(final ContinuousOutputModel model) throws MathIllegalArgumentException, MaxCountExceededException {
        MethodContext _bcornu_methode_context1281 = new MethodContext(void.class, 130, 5063, 6924);
        try {
            CallChecker.varInit(this, "this", 130, 5063, 6924);
            CallChecker.varInit(model, "model", 130, 5063, 6924);
            CallChecker.varInit(this.steps, "steps", 130, 5063, 6924);
            CallChecker.varInit(this.index, "index", 130, 5063, 6924);
            CallChecker.varInit(this.forward, "forward", 130, 5063, 6924);
            CallChecker.varInit(this.finalTime, "finalTime", 130, 5063, 6924);
            CallChecker.varInit(this.initialTime, "initialTime", 130, 5063, 6924);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 130, 5063, 6924);
            if (CallChecker.beforeDeref(model, ContinuousOutputModel.class, 133, 5630, 5634)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(model, ContinuousOutputModel.class, 133, 5630, 5634).steps, List.class, 133, 5630, 5640)) {
                    if ((CallChecker.isCalled(CallChecker.isCalled(model, ContinuousOutputModel.class, 133, 5630, 5634).steps, List.class, 133, 5630, 5640).size()) == 0) {
                        return ;
                    }
                }
            }
            if (CallChecker.beforeDeref(steps, List.class, 137, 5686, 5690)) {
                steps = CallChecker.beforeCalled(steps, List.class, 137, 5686, 5690);
                if ((CallChecker.isCalled(steps, List.class, 137, 5686, 5690).size()) == 0) {
                    if (CallChecker.beforeDeref(model, ContinuousOutputModel.class, 138, 5727, 5731)) {
                        initialTime = CallChecker.isCalled(model, ContinuousOutputModel.class, 138, 5727, 5731).initialTime;
                        CallChecker.varAssign(this.initialTime, "this.initialTime", 138, 5713, 5744);
                    }
                    if (CallChecker.beforeDeref(model, ContinuousOutputModel.class, 139, 5766, 5770)) {
                        forward = CallChecker.isCalled(model, ContinuousOutputModel.class, 139, 5766, 5770).forward;
                        CallChecker.varAssign(this.forward, "this.forward", 139, 5752, 5779);
                    }
                }else {
                    final double[] npe_invocation_var122 = getInterpolatedState();
                    if (CallChecker.beforeDeref(npe_invocation_var122, double[].class, 142, 5805, 5826)) {
                        if (CallChecker.beforeDeref(model, ContinuousOutputModel.class, 142, 5838, 5842)) {
                            final double[] npe_invocation_var123 = CallChecker.isCalled(model, ContinuousOutputModel.class, 142, 5838, 5842).getInterpolatedState();
                            if (CallChecker.beforeDeref(npe_invocation_var123, double[].class, 142, 5838, 5865)) {
                                if ((CallChecker.isCalled(npe_invocation_var122, double[].class, 142, 5805, 5826).length) != (CallChecker.isCalled(npe_invocation_var123, double[].class, 142, 5838, 5865).length)) {
                                    if (CallChecker.beforeDeref(model, ContinuousOutputModel.class, 143, 5924, 5928)) {
                                        final double[] npe_invocation_var124 = CallChecker.isCalled(model, ContinuousOutputModel.class, 143, 5924, 5928).getInterpolatedState();
                                        if (CallChecker.beforeDeref(npe_invocation_var124, double[].class, 143, 5924, 5951)) {
                                            final double[] npe_invocation_var125 = getInterpolatedState();
                                            if (CallChecker.beforeDeref(npe_invocation_var125, double[].class, 144, 6008, 6029)) {
                                                throw new DimensionMismatchException(CallChecker.isCalled(npe_invocation_var124, double[].class, 143, 5924, 5951).length, CallChecker.isCalled(npe_invocation_var125, double[].class, 144, 6008, 6029).length);
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(model, ContinuousOutputModel.class, 147, 6069, 6073)) {
                        if ((forward) ^ (CallChecker.isCalled(model, ContinuousOutputModel.class, 147, 6069, 6073).forward)) {
                            throw new MathIllegalArgumentException(LocalizedFormats.PROPAGATION_DIRECTION_MISMATCH);
                        }
                    }
                    steps = CallChecker.beforeCalled(steps, List.class, 151, 6242, 6246);
                    final StepInterpolator lastInterpolator = CallChecker.varInit(CallChecker.isCalled(steps, List.class, 151, 6242, 6246).get(index), "lastInterpolator", 151, 6200, 6258);
                    final double current = CallChecker.varInit(((double) (CallChecker.isCalled(lastInterpolator, StepInterpolator.class, 152, 6290, 6305).getCurrentTime())), "current", 152, 6266, 6323);
                    final double previous = CallChecker.varInit(((double) (CallChecker.isCalled(lastInterpolator, StepInterpolator.class, 153, 6355, 6370).getPreviousTime())), "previous", 153, 6331, 6389);
                    final double step = CallChecker.varInit(((double) (current - previous)), "step", 154, 6397, 6435);
                    final double gap = CallChecker.varInit(((double) ((CallChecker.isCalled(model, ContinuousOutputModel.class, 155, 6462, 6466).getInitialTime()) - current)), "gap", 155, 6443, 6494);
                    if ((FastMath.abs(gap)) > (0.001 * (FastMath.abs(step)))) {
                        throw new MathIllegalArgumentException(LocalizedFormats.HOLE_BETWEEN_MODELS_TIME_RANGES, FastMath.abs(gap));
                    }
                }
            }
            if (CallChecker.beforeDeref(CallChecker.isCalled(model, ContinuousOutputModel.class, 163, 6778, 6782).steps, void.class, 163, 6778, 6788)) {
                for (StepInterpolator interpolator : CallChecker.isCalled(model, ContinuousOutputModel.class, 163, 6778, 6782).steps) {
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 164, 6809, 6820)) {
                        if (CallChecker.beforeDeref(steps, List.class, 164, 6799, 6803)) {
                            steps = CallChecker.beforeCalled(steps, List.class, 164, 6799, 6803);
                            CallChecker.isCalled(steps, List.class, 164, 6799, 6803).add(CallChecker.isCalled(interpolator, StepInterpolator.class, 164, 6809, 6820).copy());
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(steps, List.class, 167, 6850, 6854)) {
                steps = CallChecker.beforeCalled(steps, List.class, 167, 6850, 6854);
                index = (CallChecker.isCalled(steps, List.class, 167, 6850, 6854).size()) - 1;
                CallChecker.varAssign(this.index, "this.index", 167, 6842, 6866);
            }
            if (CallChecker.beforeDeref(steps, List.class, 168, 6885, 6889)) {
                steps = CallChecker.beforeCalled(steps, List.class, 168, 6885, 6889);
                if (CallChecker.beforeDeref(CallChecker.isCalled(steps, List.class, 168, 6885, 6889).get(index), StepInterpolator.class, 168, 6884, 6901)) {
                    steps = CallChecker.beforeCalled(steps, List.class, 168, 6885, 6889);
                    finalTime = CallChecker.isCalled(CallChecker.isCalled(steps, List.class, 168, 6885, 6889).get(index), StepInterpolator.class, 168, 6884, 6901).getCurrentTime();
                    CallChecker.varAssign(this.finalTime, "this.finalTime", 168, 6872, 6919);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1281.methodEnd();
        }
    }

    public void init(double t0, double[] y0, double t) {
        MethodContext _bcornu_methode_context1282 = new MethodContext(void.class, 173, 6929, 7131);
        try {
            CallChecker.varInit(this, "this", 173, 6929, 7131);
            CallChecker.varInit(t, "t", 173, 6929, 7131);
            CallChecker.varInit(y0, "y0", 173, 6929, 7131);
            CallChecker.varInit(t0, "t0", 173, 6929, 7131);
            CallChecker.varInit(this.steps, "steps", 173, 6929, 7131);
            CallChecker.varInit(this.index, "index", 173, 6929, 7131);
            CallChecker.varInit(this.forward, "forward", 173, 6929, 7131);
            CallChecker.varInit(this.finalTime, "finalTime", 173, 6929, 7131);
            CallChecker.varInit(this.initialTime, "initialTime", 173, 6929, 7131);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 173, 6929, 7131);
            initialTime = Double.NaN;
            CallChecker.varAssign(this.initialTime, "this.initialTime", 174, 7009, 7033);
            finalTime = Double.NaN;
            CallChecker.varAssign(this.finalTime, "this.finalTime", 175, 7039, 7063);
            forward = true;
            CallChecker.varAssign(this.forward, "this.forward", 176, 7069, 7087);
            index = 0;
            CallChecker.varAssign(this.index, "this.index", 177, 7093, 7108);
            if (CallChecker.beforeDeref(steps, List.class, 178, 7114, 7118)) {
                steps = CallChecker.beforeCalled(steps, List.class, 178, 7114, 7118);
                CallChecker.isCalled(steps, List.class, 178, 7114, 7118).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1282.methodEnd();
        }
    }

    public void handleStep(final StepInterpolator interpolator, final boolean isLast) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context1283 = new MethodContext(void.class, 189, 7136, 7930);
        try {
            CallChecker.varInit(this, "this", 189, 7136, 7930);
            CallChecker.varInit(isLast, "isLast", 189, 7136, 7930);
            CallChecker.varInit(interpolator, "interpolator", 189, 7136, 7930);
            CallChecker.varInit(this.steps, "steps", 189, 7136, 7930);
            CallChecker.varInit(this.index, "index", 189, 7136, 7930);
            CallChecker.varInit(this.forward, "forward", 189, 7136, 7930);
            CallChecker.varInit(this.finalTime, "finalTime", 189, 7136, 7930);
            CallChecker.varInit(this.initialTime, "initialTime", 189, 7136, 7930);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 189, 7136, 7930);
            if (CallChecker.beforeDeref(steps, List.class, 192, 7655, 7659)) {
                steps = CallChecker.beforeCalled(steps, List.class, 192, 7655, 7659);
                if ((CallChecker.isCalled(steps, List.class, 192, 7655, 7659).size()) == 0) {
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 193, 7696, 7707)) {
                        initialTime = CallChecker.isCalled(interpolator, StepInterpolator.class, 193, 7696, 7707).getPreviousTime();
                        CallChecker.varAssign(this.initialTime, "this.initialTime", 193, 7682, 7726);
                    }
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 194, 7748, 7759)) {
                        forward = CallChecker.isCalled(interpolator, StepInterpolator.class, 194, 7748, 7759).isForward();
                        CallChecker.varAssign(this.forward, "this.forward", 194, 7734, 7772);
                    }
                }
            }
            if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 197, 7795, 7806)) {
                if (CallChecker.beforeDeref(steps, List.class, 197, 7785, 7789)) {
                    steps = CallChecker.beforeCalled(steps, List.class, 197, 7785, 7789);
                    CallChecker.isCalled(steps, List.class, 197, 7785, 7789).add(CallChecker.isCalled(interpolator, StepInterpolator.class, 197, 7795, 7806).copy());
                }
            }
            if (isLast) {
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 200, 7854, 7865)) {
                    finalTime = CallChecker.isCalled(interpolator, StepInterpolator.class, 200, 7854, 7865).getCurrentTime();
                    CallChecker.varAssign(this.finalTime, "this.finalTime", 200, 7842, 7883);
                }
                if (CallChecker.beforeDeref(steps, List.class, 201, 7903, 7907)) {
                    steps = CallChecker.beforeCalled(steps, List.class, 201, 7903, 7907);
                    index = (CallChecker.isCalled(steps, List.class, 201, 7903, 7907).size()) - 1;
                    CallChecker.varAssign(this.index, "this.index", 201, 7891, 7919);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1283.methodEnd();
        }
    }

    public double getInitialTime() {
        MethodContext _bcornu_methode_context1284 = new MethodContext(double.class, 210, 7935, 8083);
        try {
            CallChecker.varInit(this, "this", 210, 7935, 8083);
            CallChecker.varInit(this.steps, "steps", 210, 7935, 8083);
            CallChecker.varInit(this.index, "index", 210, 7935, 8083);
            CallChecker.varInit(this.forward, "forward", 210, 7935, 8083);
            CallChecker.varInit(this.finalTime, "finalTime", 210, 7935, 8083);
            CallChecker.varInit(this.initialTime, "initialTime", 210, 7935, 8083);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 210, 7935, 8083);
            return initialTime;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1284.methodEnd();
        }
    }

    public double getFinalTime() {
        MethodContext _bcornu_methode_context1285 = new MethodContext(double.class, 218, 8088, 8228);
        try {
            CallChecker.varInit(this, "this", 218, 8088, 8228);
            CallChecker.varInit(this.steps, "steps", 218, 8088, 8228);
            CallChecker.varInit(this.index, "index", 218, 8088, 8228);
            CallChecker.varInit(this.forward, "forward", 218, 8088, 8228);
            CallChecker.varInit(this.finalTime, "finalTime", 218, 8088, 8228);
            CallChecker.varInit(this.initialTime, "initialTime", 218, 8088, 8228);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 218, 8088, 8228);
            return finalTime;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1285.methodEnd();
        }
    }

    public double getInterpolatedTime() {
        MethodContext _bcornu_methode_context1286 = new MethodContext(double.class, 228, 8233, 8521);
        try {
            CallChecker.varInit(this, "this", 228, 8233, 8521);
            CallChecker.varInit(this.steps, "steps", 228, 8233, 8521);
            CallChecker.varInit(this.index, "index", 228, 8233, 8521);
            CallChecker.varInit(this.forward, "forward", 228, 8233, 8521);
            CallChecker.varInit(this.finalTime, "finalTime", 228, 8233, 8521);
            CallChecker.varInit(this.initialTime, "initialTime", 228, 8233, 8521);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 228, 8233, 8521);
            if (CallChecker.beforeDeref(steps, List.class, 229, 8479, 8483)) {
                steps = CallChecker.beforeCalled(steps, List.class, 229, 8479, 8483);
                if (CallChecker.beforeDeref(CallChecker.isCalled(steps, List.class, 229, 8479, 8483).get(index), StepInterpolator.class, 229, 8479, 8494)) {
                    steps = CallChecker.beforeCalled(steps, List.class, 229, 8479, 8483);
                    return CallChecker.isCalled(CallChecker.isCalled(steps, List.class, 229, 8479, 8483).get(index), StepInterpolator.class, 229, 8479, 8494).getInterpolatedTime();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1286.methodEnd();
        }
    }

    public void setInterpolatedTime(final double time) {
        MethodContext _bcornu_methode_context1287 = new MethodContext(void.class, 244, 8526, 12459);
        try {
            CallChecker.varInit(this, "this", 244, 8526, 12459);
            CallChecker.varInit(time, "time", 244, 8526, 12459);
            CallChecker.varInit(this.steps, "steps", 244, 8526, 12459);
            CallChecker.varInit(this.index, "index", 244, 8526, 12459);
            CallChecker.varInit(this.forward, "forward", 244, 8526, 12459);
            CallChecker.varInit(this.finalTime, "finalTime", 244, 8526, 12459);
            CallChecker.varInit(this.initialTime, "initialTime", 244, 8526, 12459);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 244, 8526, 12459);
            int iMin = CallChecker.varInit(((int) (0)), "iMin", 247, 9315, 9327);
            steps = CallChecker.beforeCalled(steps, List.class, 248, 9365, 9369);
            final StepInterpolator sMin = CallChecker.varInit(CallChecker.isCalled(steps, List.class, 248, 9365, 9369).get(iMin), "sMin", 248, 9335, 9380);
            double tMin = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(sMin, StepInterpolator.class, 249, 9409, 9412)) {
                if (CallChecker.beforeDeref(sMin, StepInterpolator.class, 249, 9434, 9437)) {
                    tMin = 0.5 * ((CallChecker.isCalled(sMin, StepInterpolator.class, 249, 9409, 9412).getPreviousTime()) + (CallChecker.isCalled(sMin, StepInterpolator.class, 249, 9434, 9437).getCurrentTime()));
                    CallChecker.varAssign(tMin, "tMin", 249, 9409, 9412);
                }
            }
            int iMax = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(steps, List.class, 251, 9476, 9480)) {
                steps = CallChecker.beforeCalled(steps, List.class, 251, 9476, 9480);
                iMax = (CallChecker.isCalled(steps, List.class, 251, 9476, 9480).size()) - 1;
                CallChecker.varAssign(iMax, "iMax", 251, 9476, 9480);
            }
            steps = CallChecker.beforeCalled(steps, List.class, 252, 9530, 9534);
            final StepInterpolator sMax = CallChecker.varInit(CallChecker.isCalled(steps, List.class, 252, 9530, 9534).get(iMax), "sMax", 252, 9500, 9545);
            double tMax = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(sMax, StepInterpolator.class, 253, 9574, 9577)) {
                if (CallChecker.beforeDeref(sMax, StepInterpolator.class, 253, 9599, 9602)) {
                    tMax = 0.5 * ((CallChecker.isCalled(sMax, StepInterpolator.class, 253, 9574, 9577).getPreviousTime()) + (CallChecker.isCalled(sMax, StepInterpolator.class, 253, 9599, 9602).getCurrentTime()));
                    CallChecker.varAssign(tMax, "tMax", 253, 9574, 9577);
                }
            }
            if ((locatePoint(time, sMin)) <= 0) {
                index = iMin;
                CallChecker.varAssign(this.index, "this.index", 258, 9772, 9784);
                if (CallChecker.beforeDeref(sMin, StepInterpolator.class, 259, 9794, 9797)) {
                    CallChecker.isCalled(sMin, StepInterpolator.class, 259, 9794, 9797).setInterpolatedTime(time);
                }
                return ;
            }
            if ((locatePoint(time, sMax)) >= 0) {
                index = iMax;
                CallChecker.varAssign(this.index, "this.index", 263, 9900, 9912);
                if (CallChecker.beforeDeref(sMax, StepInterpolator.class, 264, 9922, 9925)) {
                    CallChecker.isCalled(sMax, StepInterpolator.class, 264, 9922, 9925).setInterpolatedTime(time);
                }
                return ;
            }
            while ((iMax - iMin) > 5) {
                steps = CallChecker.beforeCalled(steps, List.class, 272, 10154, 10158);
                final StepInterpolator si = CallChecker.varInit(CallChecker.isCalled(steps, List.class, 272, 10154, 10158).get(index), "si", 272, 10063, 10170);
                final int location = CallChecker.varInit(((int) (locatePoint(time, si))), "location", 273, 10180, 10222);
                if (location < 0) {
                    iMax = index;
                    CallChecker.varAssign(iMax, "iMax", 275, 10262, 10274);
                    if (CallChecker.beforeDeref(si, StepInterpolator.class, 276, 10300, 10301)) {
                        if (CallChecker.beforeDeref(si, StepInterpolator.class, 276, 10323, 10324)) {
                            tMax = 0.5 * ((CallChecker.isCalled(si, StepInterpolator.class, 276, 10300, 10301).getPreviousTime()) + (CallChecker.isCalled(si, StepInterpolator.class, 276, 10323, 10324).getCurrentTime()));
                            CallChecker.varAssign(tMax, "tMax", 276, 10286, 10343);
                        }
                    }
                }else
                    if (location > 0) {
                        iMin = index;
                        CallChecker.varAssign(iMin, "iMin", 278, 10390, 10402);
                        if (CallChecker.beforeDeref(si, StepInterpolator.class, 279, 10428, 10429)) {
                            if (CallChecker.beforeDeref(si, StepInterpolator.class, 279, 10451, 10452)) {
                                tMin = 0.5 * ((CallChecker.isCalled(si, StepInterpolator.class, 279, 10428, 10429).getPreviousTime()) + (CallChecker.isCalled(si, StepInterpolator.class, 279, 10451, 10452).getCurrentTime()));
                                CallChecker.varAssign(tMin, "tMin", 279, 10414, 10471);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(si, StepInterpolator.class, 282, 10574, 10575)) {
                            CallChecker.isCalled(si, StepInterpolator.class, 282, 10574, 10575).setInterpolatedTime(time);
                        }
                        return ;
                    }
                
                final int iMed = CallChecker.varInit(((int) ((iMin + iMax) / 2)), "iMed", 287, 10641, 10749);
                steps = CallChecker.beforeCalled(steps, List.class, 288, 10789, 10793);
                final StepInterpolator sMed = CallChecker.varInit(CallChecker.isCalled(steps, List.class, 288, 10789, 10793).get(iMed), "sMed", 288, 10759, 10804);
                final double tMed = CallChecker.varInit(((double) (0.5 * ((CallChecker.isCalled(sMed, StepInterpolator.class, 289, 10841, 10844).getPreviousTime()) + (CallChecker.isCalled(sMed, StepInterpolator.class, 289, 10866, 10869).getCurrentTime())))), "tMed", 289, 10814, 10888);
                if (((FastMath.abs((tMed - tMin))) < 1.0E-6) || ((FastMath.abs((tMax - tMed))) < 1.0E-6)) {
                    index = iMed;
                    CallChecker.varAssign(this.index, "this.index", 293, 11064, 11076);
                }else {
                    final double d12 = CallChecker.varInit(((double) (tMax - tMed)), "d12", 298, 11105, 11350);
                    final double d23 = CallChecker.varInit(((double) (tMed - tMin)), "d23", 299, 11362, 11392);
                    final double d13 = CallChecker.varInit(((double) (tMax - tMin)), "d13", 300, 11404, 11434);
                    final double dt1 = CallChecker.varInit(((double) (time - tMax)), "dt1", 301, 11446, 11476);
                    final double dt2 = CallChecker.varInit(((double) (time - tMed)), "dt2", 302, 11488, 11518);
                    final double dt3 = CallChecker.varInit(((double) (time - tMin)), "dt3", 303, 11530, 11560);
                    final double iLagrange = CallChecker.varInit(((double) ((((((dt2 * dt3) * d23) * iMax) - (((dt1 * dt3) * d13) * iMed)) + (((dt1 * dt2) * d12) * iMin)) / ((d12 * d23) * d13))), "iLagrange", 304, 11572, 11804);
                    index = ((int) (FastMath.rint(iLagrange)));
                    CallChecker.varAssign(this.index, "this.index", 308, 11816, 11854);
                }
                final int low = CallChecker.varInit(((int) (FastMath.max((iMin + 1), (((9 * iMin) + iMax) / 10)))), "low", 312, 11875, 12004);
                final int high = CallChecker.varInit(((int) (FastMath.min((iMax - 1), ((iMin + (9 * iMax)) / 10)))), "high", 313, 12014, 12077);
                if ((index) < low) {
                    index = low;
                    CallChecker.varAssign(this.index, "this.index", 315, 12116, 12127);
                }else
                    if ((index) > high) {
                        index = high;
                        CallChecker.varAssign(this.index, "this.index", 317, 12174, 12186);
                    }
                
            } 
            index = iMin;
            CallChecker.varAssign(this.index, "this.index", 323, 12289, 12301);
            steps = CallChecker.beforeCalled(steps, List.class, 324, 12354, 12358);
            while (((index) <= iMax) && ((locatePoint(time, CallChecker.isCalled(steps, List.class, 324, 12354, 12358).get(index))) > 0)) {
                ++(index);
            } 
            if (CallChecker.beforeDeref(steps, List.class, 328, 12412, 12416)) {
                steps = CallChecker.beforeCalled(steps, List.class, 328, 12412, 12416);
                if (CallChecker.beforeDeref(CallChecker.isCalled(steps, List.class, 328, 12412, 12416).get(index), StepInterpolator.class, 328, 12412, 12427)) {
                    steps = CallChecker.beforeCalled(steps, List.class, 328, 12412, 12416);
                    CallChecker.isCalled(CallChecker.isCalled(steps, List.class, 328, 12412, 12416).get(index), StepInterpolator.class, 328, 12412, 12427).setInterpolatedTime(time);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1287.methodEnd();
        }
    }

    public double[] getInterpolatedState() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context1288 = new MethodContext(double[].class, 338, 12464, 12859);
        try {
            CallChecker.varInit(this, "this", 338, 12464, 12859);
            CallChecker.varInit(this.steps, "steps", 338, 12464, 12859);
            CallChecker.varInit(this.index, "index", 338, 12464, 12859);
            CallChecker.varInit(this.forward, "forward", 338, 12464, 12859);
            CallChecker.varInit(this.finalTime, "finalTime", 338, 12464, 12859);
            CallChecker.varInit(this.initialTime, "initialTime", 338, 12464, 12859);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 338, 12464, 12859);
            if (CallChecker.beforeDeref(steps, List.class, 339, 12816, 12820)) {
                steps = CallChecker.beforeCalled(steps, List.class, 339, 12816, 12820);
                if (CallChecker.beforeDeref(CallChecker.isCalled(steps, List.class, 339, 12816, 12820).get(index), StepInterpolator.class, 339, 12816, 12831)) {
                    steps = CallChecker.beforeCalled(steps, List.class, 339, 12816, 12820);
                    return CallChecker.isCalled(CallChecker.isCalled(steps, List.class, 339, 12816, 12820).get(index), StepInterpolator.class, 339, 12816, 12831).getInterpolatedState();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1288.methodEnd();
        }
    }

    public double[] getInterpolatedSecondaryState(final int secondaryStateIndex) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context1289 = new MethodContext(double[].class, 352, 12864, 13657);
        try {
            CallChecker.varInit(this, "this", 352, 12864, 13657);
            CallChecker.varInit(secondaryStateIndex, "secondaryStateIndex", 352, 12864, 13657);
            CallChecker.varInit(this.steps, "steps", 352, 12864, 13657);
            CallChecker.varInit(this.index, "index", 352, 12864, 13657);
            CallChecker.varInit(this.forward, "forward", 352, 12864, 13657);
            CallChecker.varInit(this.finalTime, "finalTime", 352, 12864, 13657);
            CallChecker.varInit(this.initialTime, "initialTime", 352, 12864, 13657);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 352, 12864, 13657);
            if (CallChecker.beforeDeref(steps, List.class, 354, 13586, 13590)) {
                steps = CallChecker.beforeCalled(steps, List.class, 354, 13586, 13590);
                if (CallChecker.beforeDeref(CallChecker.isCalled(steps, List.class, 354, 13586, 13590).get(index), StepInterpolator.class, 354, 13586, 13601)) {
                    steps = CallChecker.beforeCalled(steps, List.class, 354, 13586, 13590);
                    return CallChecker.isCalled(CallChecker.isCalled(steps, List.class, 354, 13586, 13590).get(index), StepInterpolator.class, 354, 13586, 13601).getInterpolatedSecondaryState(secondaryStateIndex);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1289.methodEnd();
        }
    }

    private int locatePoint(final double time, final StepInterpolator interval) {
        MethodContext _bcornu_methode_context1290 = new MethodContext(int.class, 364, 13662, 14393);
        try {
            CallChecker.varInit(this, "this", 364, 13662, 14393);
            CallChecker.varInit(interval, "interval", 364, 13662, 14393);
            CallChecker.varInit(time, "time", 364, 13662, 14393);
            CallChecker.varInit(this.steps, "steps", 364, 13662, 14393);
            CallChecker.varInit(this.index, "index", 364, 13662, 14393);
            CallChecker.varInit(this.forward, "forward", 364, 13662, 14393);
            CallChecker.varInit(this.finalTime, "finalTime", 364, 13662, 14393);
            CallChecker.varInit(this.initialTime, "initialTime", 364, 13662, 14393);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ContinuousOutputModel.serialVersionUID", 364, 13662, 14393);
            if (forward) {
                if (CallChecker.beforeDeref(interval, StepInterpolator.class, 366, 14058, 14065)) {
                    if (time < (CallChecker.isCalled(interval, StepInterpolator.class, 366, 14058, 14065).getPreviousTime())) {
                        return -1;
                    }else
                        if (CallChecker.beforeDeref(interval, StepInterpolator.class, 368, 14131, 14138)) {
                            if (time > (CallChecker.isCalled(interval, StepInterpolator.class, 368, 14131, 14138).getCurrentTime())) {
                                return +1;
                            }else {
                                return 0;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(interval, StepInterpolator.class, 374, 14241, 14248)) {
                if (time > (CallChecker.isCalled(interval, StepInterpolator.class, 374, 14241, 14248).getPreviousTime())) {
                    return -1;
                }else
                    if (CallChecker.beforeDeref(interval, StepInterpolator.class, 376, 14310, 14317)) {
                        if (time < (CallChecker.isCalled(interval, StepInterpolator.class, 376, 14310, 14317).getCurrentTime())) {
                            return +1;
                        }else {
                            return 0;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1290.methodEnd();
        }
    }
}

