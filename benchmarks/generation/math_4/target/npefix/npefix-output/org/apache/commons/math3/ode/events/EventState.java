package org.apache.commons.math3.ode.events;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver;
import org.apache.commons.math3.analysis.solvers.PegasusSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;
import static org.apache.commons.math3.ode.events.EventHandler.Action.CONTINUE;
import static org.apache.commons.math3.ode.events.EventHandler.Action.RESET_DERIVATIVES;
import static org.apache.commons.math3.ode.events.EventHandler.Action.RESET_STATE;
import static org.apache.commons.math3.ode.events.EventHandler.Action.STOP;

public class EventState {
    private static class LocalMaxCountExceededException extends RuntimeException {
        private static final long serialVersionUID = 20120901L;

        private final MaxCountExceededException wrapped;

        public LocalMaxCountExceededException(final MaxCountExceededException exception) {
            ConstructorContext _bcornu_methode_context1117 = new ConstructorContext(EventState.LocalMaxCountExceededException.class, 403, 16626, 16840);
            try {
                wrapped = exception;
                CallChecker.varAssign(this.wrapped, "this.wrapped", 404, 16811, 16830);
            } finally {
                _bcornu_methode_context1117.methodEnd();
            }
        }

        public MaxCountExceededException getException() {
            MethodContext _bcornu_methode_context4971 = new MethodContext(MaxCountExceededException.class, 410, 16851, 17025);
            try {
                CallChecker.varInit(this, "this", 410, 16851, 17025);
                CallChecker.varInit(this.wrapped, "wrapped", 410, 16851, 17025);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.events.EventState.LocalMaxCountExceededException.serialVersionUID", 410, 16851, 17025);
                return wrapped;
            } catch (ForceReturn _bcornu_return_t) {
                return ((MaxCountExceededException) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4971.methodEnd();
            }
        }
    }

    private final EventHandler handler;

    private final double maxCheckInterval;

    private final double convergence;

    private final int maxIterationCount;

    private ExpandableStatefulODE expandable;

    private double t0;

    private double g0;

    private boolean g0Positive;

    private boolean pendingEvent;

    private double pendingEventTime;

    private double previousEventTime;

    private boolean forward;

    private boolean increasing;

    private EventHandler.Action nextAction;

    private final UnivariateSolver solver;

    public EventState(final EventHandler handler, final double maxCheckInterval, final double convergence, final int maxIterationCount, final UnivariateSolver solver) {
        ConstructorContext _bcornu_methode_context1118 = new ConstructorContext(EventState.class, 105, 3566, 4929);
        try {
            this.handler = handler;
            CallChecker.varAssign(this.handler, "this.handler", 108, 4297, 4329);
            this.maxCheckInterval = maxCheckInterval;
            CallChecker.varAssign(this.maxCheckInterval, "this.maxCheckInterval", 109, 4339, 4380);
            this.convergence = FastMath.abs(convergence);
            CallChecker.varAssign(this.convergence, "this.convergence", 110, 4390, 4440);
            this.maxIterationCount = maxIterationCount;
            CallChecker.varAssign(this.maxIterationCount, "this.maxIterationCount", 111, 4450, 4492);
            this.solver = solver;
            CallChecker.varAssign(this.solver, "this.solver", 112, 4502, 4533);
            expandable = null;
            CallChecker.varAssign(this.expandable, "this.expandable", 115, 4577, 4601);
            t0 = Double.NaN;
            CallChecker.varAssign(this.t0, "this.t0", 116, 4611, 4641);
            g0 = Double.NaN;
            CallChecker.varAssign(this.g0, "this.g0", 117, 4651, 4681);
            g0Positive = true;
            CallChecker.varAssign(this.g0Positive, "this.g0Positive", 118, 4691, 4715);
            pendingEvent = false;
            CallChecker.varAssign(this.pendingEvent, "this.pendingEvent", 119, 4725, 4750);
            pendingEventTime = Double.NaN;
            CallChecker.varAssign(this.pendingEventTime, "this.pendingEventTime", 120, 4760, 4790);
            previousEventTime = Double.NaN;
            CallChecker.varAssign(this.previousEventTime, "this.previousEventTime", 121, 4800, 4830);
            increasing = true;
            CallChecker.varAssign(this.increasing, "this.increasing", 122, 4840, 4864);
            nextAction = CONTINUE;
            CallChecker.varAssign(this.nextAction, "this.nextAction", 123, 4874, 4922);
        } finally {
            _bcornu_methode_context1118.methodEnd();
        }
    }

    public EventHandler getEventHandler() {
        MethodContext _bcornu_methode_context4972 = new MethodContext(EventHandler.class, 130, 4936, 5094);
        try {
            CallChecker.varInit(this, "this", 130, 4936, 5094);
            CallChecker.varInit(this.solver, "solver", 130, 4936, 5094);
            CallChecker.varInit(this.nextAction, "nextAction", 130, 4936, 5094);
            CallChecker.varInit(this.increasing, "increasing", 130, 4936, 5094);
            CallChecker.varInit(this.forward, "forward", 130, 4936, 5094);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 130, 4936, 5094);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 130, 4936, 5094);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 130, 4936, 5094);
            CallChecker.varInit(this.g0Positive, "g0Positive", 130, 4936, 5094);
            CallChecker.varInit(this.g0, "g0", 130, 4936, 5094);
            CallChecker.varInit(this.t0, "t0", 130, 4936, 5094);
            CallChecker.varInit(this.expandable, "expandable", 130, 4936, 5094);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 130, 4936, 5094);
            CallChecker.varInit(this.convergence, "convergence", 130, 4936, 5094);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 130, 4936, 5094);
            CallChecker.varInit(this.handler, "handler", 130, 4936, 5094);
            return handler;
        } catch (ForceReturn _bcornu_return_t) {
            return ((EventHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4972.methodEnd();
        }
    }

    public void setExpandable(final ExpandableStatefulODE expandable) {
        MethodContext _bcornu_methode_context4973 = new MethodContext(void.class, 137, 5101, 5296);
        try {
            CallChecker.varInit(this, "this", 137, 5101, 5296);
            CallChecker.varInit(expandable, "expandable", 137, 5101, 5296);
            CallChecker.varInit(this.solver, "solver", 137, 5101, 5296);
            CallChecker.varInit(this.nextAction, "nextAction", 137, 5101, 5296);
            CallChecker.varInit(this.increasing, "increasing", 137, 5101, 5296);
            CallChecker.varInit(this.forward, "forward", 137, 5101, 5296);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 137, 5101, 5296);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 137, 5101, 5296);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 137, 5101, 5296);
            CallChecker.varInit(this.g0Positive, "g0Positive", 137, 5101, 5296);
            CallChecker.varInit(this.g0, "g0", 137, 5101, 5296);
            CallChecker.varInit(this.t0, "t0", 137, 5101, 5296);
            CallChecker.varInit(this.expandable, "expandable", 137, 5101, 5296);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 137, 5101, 5296);
            CallChecker.varInit(this.convergence, "convergence", 137, 5101, 5296);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 137, 5101, 5296);
            CallChecker.varInit(this.handler, "handler", 137, 5101, 5296);
            this.expandable = expandable;
            CallChecker.varAssign(this.expandable, "this.expandable", 138, 5262, 5290);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4973.methodEnd();
        }
    }

    public double getMaxCheckInterval() {
        MethodContext _bcornu_methode_context4974 = new MethodContext(double.class, 144, 5303, 5522);
        try {
            CallChecker.varInit(this, "this", 144, 5303, 5522);
            CallChecker.varInit(this.solver, "solver", 144, 5303, 5522);
            CallChecker.varInit(this.nextAction, "nextAction", 144, 5303, 5522);
            CallChecker.varInit(this.increasing, "increasing", 144, 5303, 5522);
            CallChecker.varInit(this.forward, "forward", 144, 5303, 5522);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 144, 5303, 5522);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 144, 5303, 5522);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 144, 5303, 5522);
            CallChecker.varInit(this.g0Positive, "g0Positive", 144, 5303, 5522);
            CallChecker.varInit(this.g0, "g0", 144, 5303, 5522);
            CallChecker.varInit(this.t0, "t0", 144, 5303, 5522);
            CallChecker.varInit(this.expandable, "expandable", 144, 5303, 5522);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 144, 5303, 5522);
            CallChecker.varInit(this.convergence, "convergence", 144, 5303, 5522);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 144, 5303, 5522);
            CallChecker.varInit(this.handler, "handler", 144, 5303, 5522);
            return maxCheckInterval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4974.methodEnd();
        }
    }

    public double getConvergence() {
        MethodContext _bcornu_methode_context4975 = new MethodContext(double.class, 151, 5529, 5724);
        try {
            CallChecker.varInit(this, "this", 151, 5529, 5724);
            CallChecker.varInit(this.solver, "solver", 151, 5529, 5724);
            CallChecker.varInit(this.nextAction, "nextAction", 151, 5529, 5724);
            CallChecker.varInit(this.increasing, "increasing", 151, 5529, 5724);
            CallChecker.varInit(this.forward, "forward", 151, 5529, 5724);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 151, 5529, 5724);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 151, 5529, 5724);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 151, 5529, 5724);
            CallChecker.varInit(this.g0Positive, "g0Positive", 151, 5529, 5724);
            CallChecker.varInit(this.g0, "g0", 151, 5529, 5724);
            CallChecker.varInit(this.t0, "t0", 151, 5529, 5724);
            CallChecker.varInit(this.expandable, "expandable", 151, 5529, 5724);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 151, 5529, 5724);
            CallChecker.varInit(this.convergence, "convergence", 151, 5529, 5724);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 151, 5529, 5724);
            CallChecker.varInit(this.handler, "handler", 151, 5529, 5724);
            return convergence;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4975.methodEnd();
        }
    }

    public int getMaxIterationCount() {
        MethodContext _bcornu_methode_context4976 = new MethodContext(int.class, 158, 5731, 5961);
        try {
            CallChecker.varInit(this, "this", 158, 5731, 5961);
            CallChecker.varInit(this.solver, "solver", 158, 5731, 5961);
            CallChecker.varInit(this.nextAction, "nextAction", 158, 5731, 5961);
            CallChecker.varInit(this.increasing, "increasing", 158, 5731, 5961);
            CallChecker.varInit(this.forward, "forward", 158, 5731, 5961);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 158, 5731, 5961);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 158, 5731, 5961);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 158, 5731, 5961);
            CallChecker.varInit(this.g0Positive, "g0Positive", 158, 5731, 5961);
            CallChecker.varInit(this.g0, "g0", 158, 5731, 5961);
            CallChecker.varInit(this.t0, "t0", 158, 5731, 5961);
            CallChecker.varInit(this.expandable, "expandable", 158, 5731, 5961);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 158, 5731, 5961);
            CallChecker.varInit(this.convergence, "convergence", 158, 5731, 5961);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 158, 5731, 5961);
            CallChecker.varInit(this.handler, "handler", 158, 5731, 5961);
            return maxIterationCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4976.methodEnd();
        }
    }

    public void reinitializeBegin(final StepInterpolator interpolator) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context4977 = new MethodContext(void.class, 167, 5968, 7790);
        try {
            CallChecker.varInit(this, "this", 167, 5968, 7790);
            CallChecker.varInit(interpolator, "interpolator", 167, 5968, 7790);
            CallChecker.varInit(this.solver, "solver", 167, 5968, 7790);
            CallChecker.varInit(this.nextAction, "nextAction", 167, 5968, 7790);
            CallChecker.varInit(this.increasing, "increasing", 167, 5968, 7790);
            CallChecker.varInit(this.forward, "forward", 167, 5968, 7790);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 167, 5968, 7790);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 167, 5968, 7790);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 167, 5968, 7790);
            CallChecker.varInit(this.g0Positive, "g0Positive", 167, 5968, 7790);
            CallChecker.varInit(this.g0, "g0", 167, 5968, 7790);
            CallChecker.varInit(this.t0, "t0", 167, 5968, 7790);
            CallChecker.varInit(this.expandable, "expandable", 167, 5968, 7790);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 167, 5968, 7790);
            CallChecker.varInit(this.convergence, "convergence", 167, 5968, 7790);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 167, 5968, 7790);
            CallChecker.varInit(this.handler, "handler", 167, 5968, 7790);
            if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 170, 6340, 6351)) {
                t0 = CallChecker.isCalled(interpolator, StepInterpolator.class, 170, 6340, 6351).getPreviousTime();
                CallChecker.varAssign(this.t0, "this.t0", 170, 6335, 6370);
            }
            if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 171, 6380, 6391)) {
                CallChecker.isCalled(interpolator, StepInterpolator.class, 171, 6380, 6391).setInterpolatedTime(t0);
            }
            if (CallChecker.beforeDeref(handler, EventHandler.class, 172, 6431, 6437)) {
                g0 = CallChecker.isCalled(handler, EventHandler.class, 172, 6431, 6437).g(t0, getCompleteState(interpolator));
                CallChecker.varAssign(this.g0, "this.g0", 172, 6426, 6476);
            }
            if ((g0) == 0) {
                final double epsilon = CallChecker.varInit(((double) (FastMath.max(CallChecker.isCalled(this.solver, UnivariateSolver.class, 187, 7441, 7446).getAbsoluteAccuracy(), FastMath.abs(((CallChecker.isCalled(this.solver, UnivariateSolver.class, 188, 7532, 7537).getRelativeAccuracy()) * (this.t0)))))), "epsilon", 187, 6513, 7567);
                final double tStart = CallChecker.varInit(((double) ((this.t0) + (0.5 * epsilon))), "tStart", 189, 7581, 7621);
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 190, 7635, 7646)) {
                    CallChecker.isCalled(interpolator, StepInterpolator.class, 190, 7635, 7646).setInterpolatedTime(tStart);
                }
                if (CallChecker.beforeDeref(handler, EventHandler.class, 191, 7694, 7700)) {
                    g0 = CallChecker.isCalled(handler, EventHandler.class, 191, 7694, 7700).g(tStart, getCompleteState(interpolator));
                    CallChecker.varAssign(this.g0, "this.g0", 191, 7689, 7743);
                }
            }
            g0Positive = (g0) >= 0;
            CallChecker.varAssign(this.g0Positive, "this.g0Positive", 193, 7763, 7783);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4977.methodEnd();
        }
    }

    private double[] getCompleteState(final StepInterpolator interpolator) {
        MethodContext _bcornu_methode_context4978 = new MethodContext(double[].class, 201, 7797, 8540);
        try {
            CallChecker.varInit(this, "this", 201, 7797, 8540);
            CallChecker.varInit(interpolator, "interpolator", 201, 7797, 8540);
            CallChecker.varInit(this.solver, "solver", 201, 7797, 8540);
            CallChecker.varInit(this.nextAction, "nextAction", 201, 7797, 8540);
            CallChecker.varInit(this.increasing, "increasing", 201, 7797, 8540);
            CallChecker.varInit(this.forward, "forward", 201, 7797, 8540);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 201, 7797, 8540);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 201, 7797, 8540);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 201, 7797, 8540);
            CallChecker.varInit(this.g0Positive, "g0Positive", 201, 7797, 8540);
            CallChecker.varInit(this.g0, "g0", 201, 7797, 8540);
            CallChecker.varInit(this.t0, "t0", 201, 7797, 8540);
            CallChecker.varInit(this.expandable, "expandable", 201, 7797, 8540);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 201, 7797, 8540);
            CallChecker.varInit(this.convergence, "convergence", 201, 7797, 8540);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 201, 7797, 8540);
            CallChecker.varInit(this.handler, "handler", 201, 7797, 8540);
            expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 203, 8057, 8066);
            final double[] complete = CallChecker.varInit(new double[CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 203, 8057, 8066).getTotalDimension()], "complete", 203, 8020, 8088);
            if (CallChecker.beforeDeref(expandable, ExpandableStatefulODE.class, 205, 8099, 8108)) {
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 205, 8148, 8159)) {
                    expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 205, 8099, 8108);
                    final EquationsMapper npe_invocation_var975 = CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 205, 8099, 8108).getPrimaryMapper();
                    if (CallChecker.beforeDeref(npe_invocation_var975, EquationsMapper.class, 205, 8099, 8127)) {
                        CallChecker.isCalled(npe_invocation_var975, EquationsMapper.class, 205, 8099, 8127).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 205, 8148, 8159).getInterpolatedState(), complete);
                    }
                }
            }
            int index = CallChecker.varInit(((int) (0)), "index", 207, 8261, 8274);
            expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 208, 8317, 8326);
            for (EquationsMapper secondary : CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 208, 8317, 8326).getSecondaryMappers()) {
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 209, 8394, 8405)) {
                    if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 209, 8365, 8373)) {
                        CallChecker.isCalled(secondary, EquationsMapper.class, 209, 8365, 8373).insertEquationData(CallChecker.isCalled(interpolator, StepInterpolator.class, 209, 8394, 8405).getInterpolatedSecondaryState((index++)), complete);
                    }
                }
            }
            return complete;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4978.methodEnd();
        }
    }

    public boolean evaluateStep(final StepInterpolator interpolator) throws MaxCountExceededException, NoBracketingException {
        MethodContext _bcornu_methode_context4980 = new MethodContext(boolean.class, 225, 8547, 13975);
        try {
            CallChecker.varInit(this, "this", 225, 8547, 13975);
            CallChecker.varInit(interpolator, "interpolator", 225, 8547, 13975);
            CallChecker.varInit(this.solver, "solver", 225, 8547, 13975);
            CallChecker.varInit(this.nextAction, "nextAction", 225, 8547, 13975);
            CallChecker.varInit(this.increasing, "increasing", 225, 8547, 13975);
            CallChecker.varInit(this.forward, "forward", 225, 8547, 13975);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 225, 8547, 13975);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 225, 8547, 13975);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 225, 8547, 13975);
            CallChecker.varInit(this.g0Positive, "g0Positive", 225, 8547, 13975);
            CallChecker.varInit(this.g0, "g0", 225, 8547, 13975);
            CallChecker.varInit(this.t0, "t0", 225, 8547, 13975);
            CallChecker.varInit(this.expandable, "expandable", 225, 8547, 13975);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 225, 8547, 13975);
            CallChecker.varInit(this.convergence, "convergence", 225, 8547, 13975);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 225, 8547, 13975);
            CallChecker.varInit(this.handler, "handler", 225, 8547, 13975);
            TryContext _bcornu_try_context_101 = new TryContext(101, EventState.class, "org.apache.commons.math3.ode.events.EventState$LocalMaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 229, 9174, 9185)) {
                    forward = CallChecker.isCalled(interpolator, StepInterpolator.class, 229, 9174, 9185).isForward();
                    CallChecker.varAssign(this.forward, "this.forward", 229, 9164, 9198);
                }
                final double t1 = CallChecker.varInit(((double) (CallChecker.isCalled(interpolator, StepInterpolator.class, 230, 9230, 9241).getCurrentTime())), "t1", 230, 9212, 9259);
                final double dt = CallChecker.varInit(((double) (t1 - (this.t0))), "dt", 231, 9273, 9298);
                if ((FastMath.abs(dt)) < (convergence)) {
                    return false;
                }
                final int n = CallChecker.varInit(((int) (FastMath.max(1, ((int) (FastMath.ceil(((FastMath.abs(dt)) / (this.maxCheckInterval)))))))), "n", 236, 9494, 9584);
                final double h = CallChecker.varInit(((double) (dt / n)), "h", 237, 9598, 9621);
                final UnivariateFunction f = new UnivariateFunction() {
                    public double value(final double t) throws EventState.LocalMaxCountExceededException {
                        MethodContext _bcornu_methode_context4979 = new MethodContext(double.class, 240, 9708, 10121);
                        try {
                            CallChecker.varInit(this, "this", 240, 9708, 10121);
                            CallChecker.varInit(t, "t", 240, 9708, 10121);
                            TryContext _bcornu_try_context_100 = new TryContext(100, EventState.class, "org.apache.commons.math3.exception.MaxCountExceededException");
                            try {
                                if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 242, 9834, 9845)) {
                                    CallChecker.isCalled(interpolator, StepInterpolator.class, 242, 9834, 9845).setInterpolatedTime(t);
                                }
                                if (CallChecker.beforeDeref(handler, EventHandler.class, 243, 9902, 9908)) {
                                    return CallChecker.isCalled(handler, EventHandler.class, 243, 9902, 9908).g(t, getCompleteState(interpolator));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            } catch (MaxCountExceededException mcee) {
                                _bcornu_try_context_100.catchStart(100);
                                throw new EventState.LocalMaxCountExceededException(mcee);
                            } finally {
                                _bcornu_try_context_100.finallyStart(100);
                            }
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Double) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context4979.methodEnd();
                        }
                    }
                };
                double ta = CallChecker.varInit(((double) (this.t0)), "ta", 250, 10151, 10165);
                double ga = CallChecker.varInit(((double) (this.g0)), "ga", 251, 10179, 10193);
                for (int i = 0; i < n; ++i) {
                    final double tb = CallChecker.varInit(((double) ((this.t0) + ((i + 1) * h))), "tb", 255, 10254, 10356);
                    if (CallChecker.beforeDeref(interpolator, StepInterpolator.class, 256, 10374, 10385)) {
                        CallChecker.isCalled(interpolator, StepInterpolator.class, 256, 10374, 10385).setInterpolatedTime(tb);
                    }
                    final double gb = CallChecker.varInit(((double) (CallChecker.isCalled(this.handler, EventHandler.class, 257, 10446, 10452).g(tb, getCompleteState(interpolator)))), "gb", 257, 10428, 10491);
                    if ((g0Positive) ^ (gb >= 0)) {
                        increasing = gb >= ga;
                        CallChecker.varAssign(this.increasing, "this.increasing", 264, 10775, 10796);
                        double root = CallChecker.init(double.class);
                        if ((solver) instanceof BracketedUnivariateSolver<?>) {
                            @SuppressWarnings(value = "unchecked")
                            BracketedUnivariateSolver<UnivariateFunction> bracketing = CallChecker.varInit(((BracketedUnivariateSolver<UnivariateFunction>) (solver)), "bracketing", 270, 11043, 11243);
                            if (forward) {
                                if (CallChecker.beforeDeref(bracketing, BracketedUnivariateSolver.class, 273, 11317, 11326)) {
                                    bracketing = CallChecker.beforeCalled(bracketing, BracketedUnivariateSolver.class, 273, 11317, 11326);
                                    root = CallChecker.isCalled(bracketing, BracketedUnivariateSolver.class, 273, 11317, 11326).solve(maxIterationCount, f, ta, tb, AllowedSolution.RIGHT_SIDE);
                                    CallChecker.varAssign(root, "root", 272, 11269, 11498);
                                }
                            }else {
                                if (CallChecker.beforeDeref(bracketing, BracketedUnivariateSolver.class, 274, 11425, 11434)) {
                                    bracketing = CallChecker.beforeCalled(bracketing, BracketedUnivariateSolver.class, 274, 11425, 11434);
                                    root = CallChecker.isCalled(bracketing, BracketedUnivariateSolver.class, 274, 11425, 11434).solve(maxIterationCount, f, tb, ta, AllowedSolution.LEFT_SIDE);
                                    CallChecker.varAssign(root, "root", 272, 11269, 11498);
                                }
                            }
                        }else {
                            double baseRoot = CallChecker.init(double.class);
                            if (forward) {
                                if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 277, 11635, 11640)) {
                                    baseRoot = CallChecker.isCalled(solver, UnivariateSolver.class, 277, 11635, 11640).solve(maxIterationCount, f, ta, tb);
                                    CallChecker.varAssign(baseRoot, "baseRoot", 276, 11577, 11769);
                                }
                            }else {
                                if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 278, 11728, 11733)) {
                                    baseRoot = CallChecker.isCalled(solver, UnivariateSolver.class, 278, 11728, 11733).solve(maxIterationCount, f, tb, ta);
                                    CallChecker.varAssign(baseRoot, "baseRoot", 276, 11577, 11769);
                                }
                            }
                            final int remainingEval = CallChecker.varInit(((int) ((this.maxIterationCount) - (CallChecker.isCalled(this.solver, UnivariateSolver.class, 279, 11842, 11847).getEvaluations()))), "remainingEval", 279, 11796, 11865);
                            BracketedUnivariateSolver<UnivariateFunction> bracketing = CallChecker.init(BracketedUnivariateSolver.class);
                            if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 281, 12000, 12005)) {
                                if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 281, 12030, 12035)) {
                                    bracketing = new PegasusSolver(CallChecker.isCalled(solver, UnivariateSolver.class, 281, 12000, 12005).getRelativeAccuracy(), CallChecker.isCalled(solver, UnivariateSolver.class, 281, 12030, 12035).getAbsoluteAccuracy());
                                    CallChecker.varAssign(bracketing, "bracketing", 281, 12000, 12005);
                                }
                            }
                            if (forward) {
                                root = UnivariateSolverUtils.forceSide(remainingEval, f, bracketing, baseRoot, ta, tb, AllowedSolution.RIGHT_SIDE);
                                CallChecker.varAssign(root, "root", 282, 12085, 12514);
                            }else {
                                root = UnivariateSolverUtils.forceSide(remainingEval, f, bracketing, baseRoot, tb, ta, AllowedSolution.LEFT_SIDE);
                                CallChecker.varAssign(root, "root", 282, 12085, 12514);
                            }
                        }
                        if (((!(Double.isNaN(previousEventTime))) && ((FastMath.abs((root - ta))) <= (convergence))) && ((FastMath.abs((root - (previousEventTime)))) <= (convergence))) {
                            if (forward) {
                                ta = ta + (convergence);
                                CallChecker.varAssign(ta, "ta", 294, 12931, 12981);
                            }else {
                                ta = ta - (convergence);
                                CallChecker.varAssign(ta, "ta", 294, 12931, 12981);
                            }
                            if (CallChecker.beforeDeref(f, UnivariateFunction.class, 295, 13012, 13012)) {
                                ga = CallChecker.isCalled(f, UnivariateFunction.class, 295, 13012, 13012).value(ta);
                                CallChecker.varAssign(ga, "ga", 295, 13007, 13023);
                            }
                            --i;
                        }else
                            if ((Double.isNaN(previousEventTime)) || ((FastMath.abs(((previousEventTime) - root))) > (convergence))) {
                                pendingEventTime = root;
                                CallChecker.varAssign(this.pendingEventTime, "this.pendingEventTime", 299, 13233, 13256);
                                pendingEvent = true;
                                CallChecker.varAssign(this.pendingEvent, "this.pendingEvent", 300, 13282, 13301);
                                return true;
                            }else {
                                ta = tb;
                                CallChecker.varAssign(ta, "ta", 304, 13462, 13469);
                                ga = gb;
                                CallChecker.varAssign(ga, "ga", 305, 13495, 13502);
                            }
                        
                    }else {
                        ta = tb;
                        CallChecker.varAssign(ta, "ta", 310, 13637, 13644);
                        ga = gb;
                        CallChecker.varAssign(ga, "ga", 311, 13666, 13673);
                    }
                }
                pendingEvent = false;
                CallChecker.varAssign(this.pendingEvent, "this.pendingEvent", 317, 13767, 13791);
                pendingEventTime = Double.NaN;
                CallChecker.varAssign(this.pendingEventTime, "this.pendingEventTime", 318, 13805, 13834);
                return false;
            } catch (EventState.LocalMaxCountExceededException lmcee) {
                _bcornu_try_context_101.catchStart(101);
                throw lmcee.getException();
            } finally {
                _bcornu_try_context_101.finallyStart(101);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4980.methodEnd();
        }
    }

    public double getEventTime() {
        MethodContext _bcornu_methode_context4981 = new MethodContext(double.class, 331, 13982, 14365);
        try {
            CallChecker.varInit(this, "this", 331, 13982, 14365);
            CallChecker.varInit(this.solver, "solver", 331, 13982, 14365);
            CallChecker.varInit(this.nextAction, "nextAction", 331, 13982, 14365);
            CallChecker.varInit(this.increasing, "increasing", 331, 13982, 14365);
            CallChecker.varInit(this.forward, "forward", 331, 13982, 14365);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 331, 13982, 14365);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 331, 13982, 14365);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 331, 13982, 14365);
            CallChecker.varInit(this.g0Positive, "g0Positive", 331, 13982, 14365);
            CallChecker.varInit(this.g0, "g0", 331, 13982, 14365);
            CallChecker.varInit(this.t0, "t0", 331, 13982, 14365);
            CallChecker.varInit(this.expandable, "expandable", 331, 13982, 14365);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 331, 13982, 14365);
            CallChecker.varInit(this.convergence, "convergence", 331, 13982, 14365);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 331, 13982, 14365);
            CallChecker.varInit(this.handler, "handler", 331, 13982, 14365);
            if (pendingEvent) {
                return pendingEventTime;
            }else {
                return forward ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4981.methodEnd();
        }
    }

    public void stepAccepted(final double t, final double[] y) {
        MethodContext _bcornu_methode_context4982 = new MethodContext(void.class, 343, 14372, 15191);
        try {
            CallChecker.varInit(this, "this", 343, 14372, 15191);
            CallChecker.varInit(y, "y", 343, 14372, 15191);
            CallChecker.varInit(t, "t", 343, 14372, 15191);
            CallChecker.varInit(this.solver, "solver", 343, 14372, 15191);
            CallChecker.varInit(this.nextAction, "nextAction", 343, 14372, 15191);
            CallChecker.varInit(this.increasing, "increasing", 343, 14372, 15191);
            CallChecker.varInit(this.forward, "forward", 343, 14372, 15191);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 343, 14372, 15191);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 343, 14372, 15191);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 343, 14372, 15191);
            CallChecker.varInit(this.g0Positive, "g0Positive", 343, 14372, 15191);
            CallChecker.varInit(this.g0, "g0", 343, 14372, 15191);
            CallChecker.varInit(this.t0, "t0", 343, 14372, 15191);
            CallChecker.varInit(this.expandable, "expandable", 343, 14372, 15191);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 343, 14372, 15191);
            CallChecker.varInit(this.convergence, "convergence", 343, 14372, 15191);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 343, 14372, 15191);
            CallChecker.varInit(this.handler, "handler", 343, 14372, 15191);
            t0 = t;
            CallChecker.varAssign(this.t0, "this.t0", 345, 14718, 14724);
            if (CallChecker.beforeDeref(handler, EventHandler.class, 346, 14739, 14745)) {
                g0 = CallChecker.isCalled(handler, EventHandler.class, 346, 14739, 14745).g(t, y);
                CallChecker.varAssign(this.g0, "this.g0", 346, 14734, 14754);
            }
            if ((pendingEvent) && ((FastMath.abs(((pendingEventTime) - t))) <= (convergence))) {
                previousEventTime = t;
                CallChecker.varAssign(this.previousEventTime, "this.previousEventTime", 350, 14918, 14939);
                g0Positive = increasing;
                CallChecker.varAssign(this.g0Positive, "this.g0Positive", 351, 14953, 14983);
                if (CallChecker.beforeDeref(handler, EventHandler.class, 352, 15017, 15023)) {
                    nextAction = CallChecker.isCalled(handler, EventHandler.class, 352, 15017, 15023).eventOccurred(t, y, (!((increasing) ^ (forward))));
                    CallChecker.varAssign(this.nextAction, "this.nextAction", 352, 14997, 15069);
                }
            }else {
                g0Positive = (g0) >= 0;
                CallChecker.varAssign(this.g0Positive, "this.g0Positive", 354, 15100, 15120);
                nextAction = CONTINUE;
                CallChecker.varAssign(this.nextAction, "this.nextAction", 355, 15134, 15175);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4982.methodEnd();
        }
    }

    public boolean stop() {
        MethodContext _bcornu_methode_context4983 = new MethodContext(boolean.class, 363, 15198, 15436);
        try {
            CallChecker.varInit(this, "this", 363, 15198, 15436);
            CallChecker.varInit(this.solver, "solver", 363, 15198, 15436);
            CallChecker.varInit(this.nextAction, "nextAction", 363, 15198, 15436);
            CallChecker.varInit(this.increasing, "increasing", 363, 15198, 15436);
            CallChecker.varInit(this.forward, "forward", 363, 15198, 15436);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 363, 15198, 15436);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 363, 15198, 15436);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 363, 15198, 15436);
            CallChecker.varInit(this.g0Positive, "g0Positive", 363, 15198, 15436);
            CallChecker.varInit(this.g0, "g0", 363, 15198, 15436);
            CallChecker.varInit(this.t0, "t0", 363, 15198, 15436);
            CallChecker.varInit(this.expandable, "expandable", 363, 15198, 15436);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 363, 15198, 15436);
            CallChecker.varInit(this.convergence, "convergence", 363, 15198, 15436);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 363, 15198, 15436);
            CallChecker.varInit(this.handler, "handler", 363, 15198, 15436);
            return (nextAction) == (STOP);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4983.methodEnd();
        }
    }

    public boolean reset(final double t, final double[] y) {
        MethodContext _bcornu_methode_context4984 = new MethodContext(boolean.class, 374, 15443, 16291);
        try {
            CallChecker.varInit(this, "this", 374, 15443, 16291);
            CallChecker.varInit(y, "y", 374, 15443, 16291);
            CallChecker.varInit(t, "t", 374, 15443, 16291);
            CallChecker.varInit(this.solver, "solver", 374, 15443, 16291);
            CallChecker.varInit(this.nextAction, "nextAction", 374, 15443, 16291);
            CallChecker.varInit(this.increasing, "increasing", 374, 15443, 16291);
            CallChecker.varInit(this.forward, "forward", 374, 15443, 16291);
            CallChecker.varInit(this.previousEventTime, "previousEventTime", 374, 15443, 16291);
            CallChecker.varInit(this.pendingEventTime, "pendingEventTime", 374, 15443, 16291);
            CallChecker.varInit(this.pendingEvent, "pendingEvent", 374, 15443, 16291);
            CallChecker.varInit(this.g0Positive, "g0Positive", 374, 15443, 16291);
            CallChecker.varInit(this.g0, "g0", 374, 15443, 16291);
            CallChecker.varInit(this.t0, "t0", 374, 15443, 16291);
            CallChecker.varInit(this.expandable, "expandable", 374, 15443, 16291);
            CallChecker.varInit(this.maxIterationCount, "maxIterationCount", 374, 15443, 16291);
            CallChecker.varInit(this.convergence, "convergence", 374, 15443, 16291);
            CallChecker.varInit(this.maxCheckInterval, "maxCheckInterval", 374, 15443, 16291);
            CallChecker.varInit(this.handler, "handler", 374, 15443, 16291);
            if (!((pendingEvent) && ((FastMath.abs(((pendingEventTime) - t))) <= (convergence)))) {
                return false;
            }
            if ((nextAction) == (RESET_STATE)) {
                if (CallChecker.beforeDeref(handler, EventHandler.class, 381, 16038, 16044)) {
                    CallChecker.isCalled(handler, EventHandler.class, 381, 16038, 16044).resetState(t, y);
                }
            }
            pendingEvent = false;
            CallChecker.varAssign(this.pendingEvent, "this.pendingEvent", 383, 16082, 16107);
            pendingEventTime = Double.NaN;
            CallChecker.varAssign(this.pendingEventTime, "this.pendingEventTime", 384, 16117, 16147);
            return ((nextAction) == (RESET_STATE)) || ((nextAction) == (RESET_DERIVATIVES));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4984.methodEnd();
        }
    }
}

