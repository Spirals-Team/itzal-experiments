package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.events.EventState;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.Precision;

public abstract class AbstractIntegrator implements FirstOrderIntegrator {
    protected Collection<StepHandler> stepHandlers;

    protected double stepStart;

    protected double stepSize;

    protected boolean isLastStep;

    protected boolean resetOccurred;

    private Collection<EventState> eventsStates;

    private boolean statesInitialized;

    private final String name;

    private Incrementor evaluations;

    private transient ExpandableStatefulODE expandable;

    public AbstractIntegrator(final String name) {
        ConstructorContext _bcornu_methode_context5 = new ConstructorContext(AbstractIntegrator.class, 84, 2940, 3400);
        try {
            this.name = name;
            CallChecker.varAssign(this.name, "this.name", 85, 3068, 3084);
            stepHandlers = new ArrayList<StepHandler>();
            CallChecker.varAssign(this.stepHandlers, "this.stepHandlers", 86, 3094, 3137);
            stepStart = Double.NaN;
            CallChecker.varAssign(this.stepStart, "this.stepStart", 87, 3147, 3169);
            stepSize = Double.NaN;
            CallChecker.varAssign(this.stepSize, "this.stepSize", 88, 3179, 3201);
            eventsStates = new ArrayList<EventState>();
            CallChecker.varAssign(this.eventsStates, "this.eventsStates", 89, 3211, 3253);
            statesInitialized = false;
            CallChecker.varAssign(this.statesInitialized, "this.statesInitialized", 90, 3263, 3288);
            evaluations = new Incrementor();
            CallChecker.varAssign(this.evaluations, "this.evaluations", 91, 3298, 3329);
            setMaxEvaluations((-1));
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 93, 3370, 3380)) {
                evaluations = CallChecker.beforeCalled(evaluations, Incrementor.class, 93, 3370, 3380);
                CallChecker.isCalled(evaluations, Incrementor.class, 93, 3370, 3380).resetCount();
            }
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    protected AbstractIntegrator() {
        this(null);
        ConstructorContext _bcornu_methode_context6 = new ConstructorContext(AbstractIntegrator.class, 98, 3407, 3516);
        try {
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public String getName() {
        MethodContext _bcornu_methode_context16 = new MethodContext(String.class, 103, 3523, 3599);
        try {
            CallChecker.varInit(this, "this", 103, 3523, 3599);
            CallChecker.varInit(this.expandable, "expandable", 103, 3523, 3599);
            CallChecker.varInit(this.evaluations, "evaluations", 103, 3523, 3599);
            CallChecker.varInit(this.name, "name", 103, 3523, 3599);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 103, 3523, 3599);
            CallChecker.varInit(this.eventsStates, "eventsStates", 103, 3523, 3599);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 103, 3523, 3599);
            CallChecker.varInit(this.isLastStep, "isLastStep", 103, 3523, 3599);
            CallChecker.varInit(this.stepSize, "stepSize", 103, 3523, 3599);
            CallChecker.varInit(this.stepStart, "stepStart", 103, 3523, 3599);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 103, 3523, 3599);
            return name;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public void addStepHandler(final StepHandler handler) {
        MethodContext _bcornu_methode_context17 = new MethodContext(void.class, 108, 3606, 3726);
        try {
            CallChecker.varInit(this, "this", 108, 3606, 3726);
            CallChecker.varInit(handler, "handler", 108, 3606, 3726);
            CallChecker.varInit(this.expandable, "expandable", 108, 3606, 3726);
            CallChecker.varInit(this.evaluations, "evaluations", 108, 3606, 3726);
            CallChecker.varInit(this.name, "name", 108, 3606, 3726);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 108, 3606, 3726);
            CallChecker.varInit(this.eventsStates, "eventsStates", 108, 3606, 3726);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 108, 3606, 3726);
            CallChecker.varInit(this.isLastStep, "isLastStep", 108, 3606, 3726);
            CallChecker.varInit(this.stepSize, "stepSize", 108, 3606, 3726);
            CallChecker.varInit(this.stepStart, "stepStart", 108, 3606, 3726);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 108, 3606, 3726);
            if (CallChecker.beforeDeref(stepHandlers, Collection.class, 109, 3695, 3706)) {
                stepHandlers = CallChecker.beforeCalled(stepHandlers, Collection.class, 109, 3695, 3706);
                CallChecker.isCalled(stepHandlers, Collection.class, 109, 3695, 3706).add(handler);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public Collection<StepHandler> getStepHandlers() {
        MethodContext _bcornu_methode_context18 = new MethodContext(Collection.class, 113, 3733, 3878);
        try {
            CallChecker.varInit(this, "this", 113, 3733, 3878);
            CallChecker.varInit(this.expandable, "expandable", 113, 3733, 3878);
            CallChecker.varInit(this.evaluations, "evaluations", 113, 3733, 3878);
            CallChecker.varInit(this.name, "name", 113, 3733, 3878);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 113, 3733, 3878);
            CallChecker.varInit(this.eventsStates, "eventsStates", 113, 3733, 3878);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 113, 3733, 3878);
            CallChecker.varInit(this.isLastStep, "isLastStep", 113, 3733, 3878);
            CallChecker.varInit(this.stepSize, "stepSize", 113, 3733, 3878);
            CallChecker.varInit(this.stepStart, "stepStart", 113, 3733, 3878);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 113, 3733, 3878);
            return Collections.unmodifiableCollection(stepHandlers);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<StepHandler>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public void clearStepHandlers() {
        MethodContext _bcornu_methode_context19 = new MethodContext(void.class, 118, 3885, 3978);
        try {
            CallChecker.varInit(this, "this", 118, 3885, 3978);
            CallChecker.varInit(this.expandable, "expandable", 118, 3885, 3978);
            CallChecker.varInit(this.evaluations, "evaluations", 118, 3885, 3978);
            CallChecker.varInit(this.name, "name", 118, 3885, 3978);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 118, 3885, 3978);
            CallChecker.varInit(this.eventsStates, "eventsStates", 118, 3885, 3978);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 118, 3885, 3978);
            CallChecker.varInit(this.isLastStep, "isLastStep", 118, 3885, 3978);
            CallChecker.varInit(this.stepSize, "stepSize", 118, 3885, 3978);
            CallChecker.varInit(this.stepStart, "stepStart", 118, 3885, 3978);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 118, 3885, 3978);
            if (CallChecker.beforeDeref(stepHandlers, Collection.class, 119, 3952, 3963)) {
                stepHandlers = CallChecker.beforeCalled(stepHandlers, Collection.class, 119, 3952, 3963);
                CallChecker.isCalled(stepHandlers, Collection.class, 119, 3952, 3963).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public void addEventHandler(final EventHandler handler, final double maxCheckInterval, final double convergence, final int maxIterationCount) {
        MethodContext _bcornu_methode_context20 = new MethodContext(void.class, 123, 3985, 4437);
        try {
            CallChecker.varInit(this, "this", 123, 3985, 4437);
            CallChecker.varInit(maxIterationCount, "maxIterationCount", 123, 3985, 4437);
            CallChecker.varInit(convergence, "convergence", 123, 3985, 4437);
            CallChecker.varInit(maxCheckInterval, "maxCheckInterval", 123, 3985, 4437);
            CallChecker.varInit(handler, "handler", 123, 3985, 4437);
            CallChecker.varInit(this.expandable, "expandable", 123, 3985, 4437);
            CallChecker.varInit(this.evaluations, "evaluations", 123, 3985, 4437);
            CallChecker.varInit(this.name, "name", 123, 3985, 4437);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 123, 3985, 4437);
            CallChecker.varInit(this.eventsStates, "eventsStates", 123, 3985, 4437);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 123, 3985, 4437);
            CallChecker.varInit(this.isLastStep, "isLastStep", 123, 3985, 4437);
            CallChecker.varInit(this.stepSize, "stepSize", 123, 3985, 4437);
            CallChecker.varInit(this.stepStart, "stepStart", 123, 3985, 4437);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 123, 3985, 4437);
            addEventHandler(handler, maxCheckInterval, convergence, maxIterationCount, new BracketingNthOrderBrentSolver(convergence, 5));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public void addEventHandler(final EventHandler handler, final double maxCheckInterval, final double convergence, final int maxIterationCount, final UnivariateSolver solver) {
        MethodContext _bcornu_methode_context21 = new MethodContext(void.class, 133, 4444, 4925);
        try {
            CallChecker.varInit(this, "this", 133, 4444, 4925);
            CallChecker.varInit(solver, "solver", 133, 4444, 4925);
            CallChecker.varInit(maxIterationCount, "maxIterationCount", 133, 4444, 4925);
            CallChecker.varInit(convergence, "convergence", 133, 4444, 4925);
            CallChecker.varInit(maxCheckInterval, "maxCheckInterval", 133, 4444, 4925);
            CallChecker.varInit(handler, "handler", 133, 4444, 4925);
            CallChecker.varInit(this.expandable, "expandable", 133, 4444, 4925);
            CallChecker.varInit(this.evaluations, "evaluations", 133, 4444, 4925);
            CallChecker.varInit(this.name, "name", 133, 4444, 4925);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 133, 4444, 4925);
            CallChecker.varInit(this.eventsStates, "eventsStates", 133, 4444, 4925);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 133, 4444, 4925);
            CallChecker.varInit(this.isLastStep, "isLastStep", 133, 4444, 4925);
            CallChecker.varInit(this.stepSize, "stepSize", 133, 4444, 4925);
            CallChecker.varInit(this.stepStart, "stepStart", 133, 4444, 4925);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 133, 4444, 4925);
            if (CallChecker.beforeDeref(eventsStates, Collection.class, 138, 4780, 4791)) {
                eventsStates = CallChecker.beforeCalled(eventsStates, Collection.class, 138, 4780, 4791);
                CallChecker.isCalled(eventsStates, Collection.class, 138, 4780, 4791).add(new EventState(handler, maxCheckInterval, convergence, maxIterationCount, solver));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public Collection<EventHandler> getEventHandlers() {
        MethodContext _bcornu_methode_context22 = new MethodContext(Collection.class, 143, 4932, 5247);
        try {
            CallChecker.varInit(this, "this", 143, 4932, 5247);
            CallChecker.varInit(this.expandable, "expandable", 143, 4932, 5247);
            CallChecker.varInit(this.evaluations, "evaluations", 143, 4932, 5247);
            CallChecker.varInit(this.name, "name", 143, 4932, 5247);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 143, 4932, 5247);
            CallChecker.varInit(this.eventsStates, "eventsStates", 143, 4932, 5247);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 143, 4932, 5247);
            CallChecker.varInit(this.isLastStep, "isLastStep", 143, 4932, 5247);
            CallChecker.varInit(this.stepSize, "stepSize", 143, 4932, 5247);
            CallChecker.varInit(this.stepStart, "stepStart", 143, 4932, 5247);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 143, 4932, 5247);
            final List<EventHandler> list = CallChecker.varInit(new ArrayList<EventHandler>(), "list", 144, 5018, 5079);
            if (CallChecker.beforeDeref(eventsStates, Collection.class, 145, 5113, 5124)) {
                for (EventState state : eventsStates) {
                    if (CallChecker.beforeDeref(state, EventState.class, 146, 5150, 5154)) {
                        if (CallChecker.beforeDeref(list, List.class, 146, 5141, 5144)) {
                            CallChecker.isCalled(list, List.class, 146, 5141, 5144).add(CallChecker.isCalled(state, EventState.class, 146, 5150, 5154).getEventHandler());
                        }
                    }
                }
            }
            return Collections.unmodifiableCollection(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<EventHandler>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public void clearEventHandlers() {
        MethodContext _bcornu_methode_context23 = new MethodContext(void.class, 152, 5254, 5348);
        try {
            CallChecker.varInit(this, "this", 152, 5254, 5348);
            CallChecker.varInit(this.expandable, "expandable", 152, 5254, 5348);
            CallChecker.varInit(this.evaluations, "evaluations", 152, 5254, 5348);
            CallChecker.varInit(this.name, "name", 152, 5254, 5348);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 152, 5254, 5348);
            CallChecker.varInit(this.eventsStates, "eventsStates", 152, 5254, 5348);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 152, 5254, 5348);
            CallChecker.varInit(this.isLastStep, "isLastStep", 152, 5254, 5348);
            CallChecker.varInit(this.stepSize, "stepSize", 152, 5254, 5348);
            CallChecker.varInit(this.stepStart, "stepStart", 152, 5254, 5348);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 152, 5254, 5348);
            if (CallChecker.beforeDeref(eventsStates, Collection.class, 153, 5322, 5333)) {
                eventsStates = CallChecker.beforeCalled(eventsStates, Collection.class, 153, 5322, 5333);
                CallChecker.isCalled(eventsStates, Collection.class, 153, 5322, 5333).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public double getCurrentStepStart() {
        MethodContext _bcornu_methode_context24 = new MethodContext(double.class, 157, 5355, 5448);
        try {
            CallChecker.varInit(this, "this", 157, 5355, 5448);
            CallChecker.varInit(this.expandable, "expandable", 157, 5355, 5448);
            CallChecker.varInit(this.evaluations, "evaluations", 157, 5355, 5448);
            CallChecker.varInit(this.name, "name", 157, 5355, 5448);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 157, 5355, 5448);
            CallChecker.varInit(this.eventsStates, "eventsStates", 157, 5355, 5448);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 157, 5355, 5448);
            CallChecker.varInit(this.isLastStep, "isLastStep", 157, 5355, 5448);
            CallChecker.varInit(this.stepSize, "stepSize", 157, 5355, 5448);
            CallChecker.varInit(this.stepStart, "stepStart", 157, 5355, 5448);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 157, 5355, 5448);
            return stepStart;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public double getCurrentSignedStepsize() {
        MethodContext _bcornu_methode_context25 = new MethodContext(double.class, 162, 5455, 5552);
        try {
            CallChecker.varInit(this, "this", 162, 5455, 5552);
            CallChecker.varInit(this.expandable, "expandable", 162, 5455, 5552);
            CallChecker.varInit(this.evaluations, "evaluations", 162, 5455, 5552);
            CallChecker.varInit(this.name, "name", 162, 5455, 5552);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 162, 5455, 5552);
            CallChecker.varInit(this.eventsStates, "eventsStates", 162, 5455, 5552);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 162, 5455, 5552);
            CallChecker.varInit(this.isLastStep, "isLastStep", 162, 5455, 5552);
            CallChecker.varInit(this.stepSize, "stepSize", 162, 5455, 5552);
            CallChecker.varInit(this.stepStart, "stepStart", 162, 5455, 5552);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 162, 5455, 5552);
            return stepSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public void setMaxEvaluations(int maxEvaluations) {
        MethodContext _bcornu_methode_context26 = new MethodContext(void.class, 167, 5559, 5736);
        try {
            CallChecker.varInit(this, "this", 167, 5559, 5736);
            CallChecker.varInit(maxEvaluations, "maxEvaluations", 167, 5559, 5736);
            CallChecker.varInit(this.expandable, "expandable", 167, 5559, 5736);
            CallChecker.varInit(this.evaluations, "evaluations", 167, 5559, 5736);
            CallChecker.varInit(this.name, "name", 167, 5559, 5736);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 167, 5559, 5736);
            CallChecker.varInit(this.eventsStates, "eventsStates", 167, 5559, 5736);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 167, 5559, 5736);
            CallChecker.varInit(this.isLastStep, "isLastStep", 167, 5559, 5736);
            CallChecker.varInit(this.stepSize, "stepSize", 167, 5559, 5736);
            CallChecker.varInit(this.stepStart, "stepStart", 167, 5559, 5736);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 167, 5559, 5736);
            if (maxEvaluations < 0) {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 168, 5644, 5654)) {
                    evaluations = CallChecker.beforeCalled(evaluations, Incrementor.class, 168, 5644, 5654);
                    CallChecker.isCalled(evaluations, Incrementor.class, 168, 5644, 5654).setMaximalCount(Integer.MAX_VALUE);
                }
            }else {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 168, 5644, 5654)) {
                    evaluations = CallChecker.beforeCalled(evaluations, Incrementor.class, 168, 5644, 5654);
                    CallChecker.isCalled(evaluations, Incrementor.class, 168, 5644, 5654).setMaximalCount(maxEvaluations);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context27 = new MethodContext(int.class, 172, 5743, 5851);
        try {
            CallChecker.varInit(this, "this", 172, 5743, 5851);
            CallChecker.varInit(this.expandable, "expandable", 172, 5743, 5851);
            CallChecker.varInit(this.evaluations, "evaluations", 172, 5743, 5851);
            CallChecker.varInit(this.name, "name", 172, 5743, 5851);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 172, 5743, 5851);
            CallChecker.varInit(this.eventsStates, "eventsStates", 172, 5743, 5851);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 172, 5743, 5851);
            CallChecker.varInit(this.isLastStep, "isLastStep", 172, 5743, 5851);
            CallChecker.varInit(this.stepSize, "stepSize", 172, 5743, 5851);
            CallChecker.varInit(this.stepStart, "stepStart", 172, 5743, 5851);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 172, 5743, 5851);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 173, 5816, 5826)) {
                evaluations = CallChecker.beforeCalled(evaluations, Incrementor.class, 173, 5816, 5826);
                return CallChecker.isCalled(evaluations, Incrementor.class, 173, 5816, 5826).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context28 = new MethodContext(int.class, 177, 5858, 5956);
        try {
            CallChecker.varInit(this, "this", 177, 5858, 5956);
            CallChecker.varInit(this.expandable, "expandable", 177, 5858, 5956);
            CallChecker.varInit(this.evaluations, "evaluations", 177, 5858, 5956);
            CallChecker.varInit(this.name, "name", 177, 5858, 5956);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 177, 5858, 5956);
            CallChecker.varInit(this.eventsStates, "eventsStates", 177, 5858, 5956);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 177, 5858, 5956);
            CallChecker.varInit(this.isLastStep, "isLastStep", 177, 5858, 5956);
            CallChecker.varInit(this.stepSize, "stepSize", 177, 5858, 5956);
            CallChecker.varInit(this.stepStart, "stepStart", 177, 5858, 5956);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 177, 5858, 5956);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 178, 5928, 5938)) {
                evaluations = CallChecker.beforeCalled(evaluations, Incrementor.class, 178, 5928, 5938);
                return CallChecker.isCalled(evaluations, Incrementor.class, 178, 5928, 5938).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    protected void initIntegration(final double t0, final double[] y0, final double t) {
        MethodContext _bcornu_methode_context29 = new MethodContext(void.class, 186, 5963, 6627);
        try {
            CallChecker.varInit(this, "this", 186, 5963, 6627);
            CallChecker.varInit(t, "t", 186, 5963, 6627);
            CallChecker.varInit(y0, "y0", 186, 5963, 6627);
            CallChecker.varInit(t0, "t0", 186, 5963, 6627);
            CallChecker.varInit(this.expandable, "expandable", 186, 5963, 6627);
            CallChecker.varInit(this.evaluations, "evaluations", 186, 5963, 6627);
            CallChecker.varInit(this.name, "name", 186, 5963, 6627);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 186, 5963, 6627);
            CallChecker.varInit(this.eventsStates, "eventsStates", 186, 5963, 6627);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 186, 5963, 6627);
            CallChecker.varInit(this.isLastStep, "isLastStep", 186, 5963, 6627);
            CallChecker.varInit(this.stepSize, "stepSize", 186, 5963, 6627);
            CallChecker.varInit(this.stepStart, "stepStart", 186, 5963, 6627);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 186, 5963, 6627);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 188, 6297, 6307)) {
                evaluations = CallChecker.beforeCalled(evaluations, Incrementor.class, 188, 6297, 6307);
                CallChecker.isCalled(evaluations, Incrementor.class, 188, 6297, 6307).resetCount();
            }
            if (CallChecker.beforeDeref(eventsStates, void.class, 190, 6362, 6373)) {
                for (final EventState state : eventsStates) {
                    if (CallChecker.beforeDeref(state, EventState.class, 191, 6390, 6394)) {
                        CallChecker.isCalled(state, EventState.class, 191, 6390, 6394).setExpandable(expandable);
                    }
                    if (CallChecker.beforeDeref(state, EventState.class, 192, 6435, 6439)) {
                        final EventHandler npe_invocation_var1 = CallChecker.isCalled(state, EventState.class, 192, 6435, 6439).getEventHandler();
                        if (CallChecker.beforeDeref(npe_invocation_var1, EventHandler.class, 192, 6435, 6457)) {
                            CallChecker.isCalled(npe_invocation_var1, EventHandler.class, 192, 6435, 6457).init(t0, y0, t);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(stepHandlers, void.class, 195, 6522, 6533)) {
                for (StepHandler handler : stepHandlers) {
                    if (CallChecker.beforeDeref(handler, StepHandler.class, 196, 6550, 6556)) {
                        CallChecker.isCalled(handler, StepHandler.class, 196, 6550, 6556).init(t0, y0, t);
                    }
                }
            }
            setStateInitialized(false);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    protected void setEquations(final ExpandableStatefulODE equations) {
        MethodContext _bcornu_methode_context30 = new MethodContext(void.class, 206, 6634, 6820);
        try {
            CallChecker.varInit(this, "this", 206, 6634, 6820);
            CallChecker.varInit(equations, "equations", 206, 6634, 6820);
            CallChecker.varInit(this.expandable, "expandable", 206, 6634, 6820);
            CallChecker.varInit(this.evaluations, "evaluations", 206, 6634, 6820);
            CallChecker.varInit(this.name, "name", 206, 6634, 6820);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 206, 6634, 6820);
            CallChecker.varInit(this.eventsStates, "eventsStates", 206, 6634, 6820);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 206, 6634, 6820);
            CallChecker.varInit(this.isLastStep, "isLastStep", 206, 6634, 6820);
            CallChecker.varInit(this.stepSize, "stepSize", 206, 6634, 6820);
            CallChecker.varInit(this.stepStart, "stepStart", 206, 6634, 6820);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 206, 6634, 6820);
            this.expandable = equations;
            CallChecker.varAssign(this.expandable, "this.expandable", 207, 6787, 6814);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    protected ExpandableStatefulODE getExpandable() {
        MethodContext _bcornu_methode_context31 = new MethodContext(ExpandableStatefulODE.class, 214, 6827, 7038);
        try {
            CallChecker.varInit(this, "this", 214, 6827, 7038);
            CallChecker.varInit(this.expandable, "expandable", 214, 6827, 7038);
            CallChecker.varInit(this.evaluations, "evaluations", 214, 6827, 7038);
            CallChecker.varInit(this.name, "name", 214, 6827, 7038);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 214, 6827, 7038);
            CallChecker.varInit(this.eventsStates, "eventsStates", 214, 6827, 7038);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 214, 6827, 7038);
            CallChecker.varInit(this.isLastStep, "isLastStep", 214, 6827, 7038);
            CallChecker.varInit(this.stepSize, "stepSize", 214, 6827, 7038);
            CallChecker.varInit(this.stepStart, "stepStart", 214, 6827, 7038);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 214, 6827, 7038);
            return expandable;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExpandableStatefulODE) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    protected Incrementor getEvaluationsCounter() {
        MethodContext _bcornu_methode_context32 = new MethodContext(Incrementor.class, 222, 7045, 7223);
        try {
            CallChecker.varInit(this, "this", 222, 7045, 7223);
            CallChecker.varInit(this.expandable, "expandable", 222, 7045, 7223);
            CallChecker.varInit(this.evaluations, "evaluations", 222, 7045, 7223);
            CallChecker.varInit(this.name, "name", 222, 7045, 7223);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 222, 7045, 7223);
            CallChecker.varInit(this.eventsStates, "eventsStates", 222, 7045, 7223);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 222, 7045, 7223);
            CallChecker.varInit(this.isLastStep, "isLastStep", 222, 7045, 7223);
            CallChecker.varInit(this.stepSize, "stepSize", 222, 7045, 7223);
            CallChecker.varInit(this.stepStart, "stepStart", 222, 7045, 7223);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 222, 7045, 7223);
            return evaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Incrementor) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public double integrate(final FirstOrderDifferentialEquations equations, final double t0, final double[] y0, final double t, final double[] y) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context33 = new MethodContext(double.class, 227, 7230, 8332);
        try {
            CallChecker.varInit(this, "this", 227, 7230, 8332);
            CallChecker.varInit(y, "y", 227, 7230, 8332);
            CallChecker.varInit(t, "t", 227, 7230, 8332);
            CallChecker.varInit(y0, "y0", 227, 7230, 8332);
            CallChecker.varInit(t0, "t0", 227, 7230, 8332);
            CallChecker.varInit(equations, "equations", 227, 7230, 8332);
            CallChecker.varInit(this.expandable, "expandable", 227, 7230, 8332);
            CallChecker.varInit(this.evaluations, "evaluations", 227, 7230, 8332);
            CallChecker.varInit(this.name, "name", 227, 7230, 8332);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 227, 7230, 8332);
            CallChecker.varInit(this.eventsStates, "eventsStates", 227, 7230, 8332);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 227, 7230, 8332);
            CallChecker.varInit(this.isLastStep, "isLastStep", 227, 7230, 8332);
            CallChecker.varInit(this.stepSize, "stepSize", 227, 7230, 8332);
            CallChecker.varInit(this.stepStart, "stepStart", 227, 7230, 8332);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 227, 7230, 8332);
            if (CallChecker.beforeDeref(y0, double[].class, 232, 7575, 7576)) {
                if (CallChecker.beforeDeref(equations, FirstOrderDifferentialEquations.class, 232, 7588, 7596)) {
                    if ((CallChecker.isCalled(y0, double[].class, 232, 7575, 7576).length) != (CallChecker.isCalled(equations, FirstOrderDifferentialEquations.class, 232, 7588, 7596).getDimension())) {
                        if (CallChecker.beforeDeref(y0, double[].class, 233, 7665, 7666)) {
                            if (CallChecker.beforeDeref(equations, FirstOrderDifferentialEquations.class, 233, 7676, 7684)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(y0, double[].class, 233, 7665, 7666).length, CallChecker.isCalled(equations, FirstOrderDifferentialEquations.class, 233, 7676, 7684).getDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(y, double[].class, 235, 7725, 7725)) {
                if (CallChecker.beforeDeref(equations, FirstOrderDifferentialEquations.class, 235, 7737, 7745)) {
                    if ((CallChecker.isCalled(y, double[].class, 235, 7725, 7725).length) != (CallChecker.isCalled(equations, FirstOrderDifferentialEquations.class, 235, 7737, 7745).getDimension())) {
                        if (CallChecker.beforeDeref(y, double[].class, 236, 7814, 7814)) {
                            if (CallChecker.beforeDeref(equations, FirstOrderDifferentialEquations.class, 236, 7824, 7832)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(y, double[].class, 236, 7814, 7814).length, CallChecker.isCalled(equations, FirstOrderDifferentialEquations.class, 236, 7824, 7832).getDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final ExpandableStatefulODE expandableODE = CallChecker.varInit(new ExpandableStatefulODE(equations), "expandableODE", 240, 7870, 7999);
            if (CallChecker.beforeDeref(expandableODE, ExpandableStatefulODE.class, 241, 8009, 8021)) {
                CallChecker.isCalled(expandableODE, ExpandableStatefulODE.class, 241, 8009, 8021).setTime(t0);
            }
            if (CallChecker.beforeDeref(expandableODE, ExpandableStatefulODE.class, 242, 8044, 8056)) {
                CallChecker.isCalled(expandableODE, ExpandableStatefulODE.class, 242, 8044, 8056).setPrimaryState(y0);
            }
            integrate(expandableODE, t);
            if (CallChecker.beforeDeref(expandableODE, ExpandableStatefulODE.class, 248, 8234, 8246)) {
                if (CallChecker.beforeDeref(y, double[].class, 248, 8276, 8276)) {
                    System.arraycopy(CallChecker.isCalled(expandableODE, ExpandableStatefulODE.class, 248, 8234, 8246).getPrimaryState(), 0, y, 0, CallChecker.isCalled(y, double[].class, 248, 8276, 8276).length);
                }
            }
            if (CallChecker.beforeDeref(expandableODE, ExpandableStatefulODE.class, 249, 8302, 8314)) {
                return CallChecker.isCalled(expandableODE, ExpandableStatefulODE.class, 249, 8302, 8314).getTime();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public abstract void integrate(ExpandableStatefulODE equations, double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException;

    public void computeDerivatives(final double t, final double[] y, final double[] yDot) throws DimensionMismatchException, MaxCountExceededException {
        MethodContext _bcornu_methode_context35 = new MethodContext(void.class, 283, 9863, 10614);
        try {
            CallChecker.varInit(this, "this", 283, 9863, 10614);
            CallChecker.varInit(yDot, "yDot", 283, 9863, 10614);
            CallChecker.varInit(y, "y", 283, 9863, 10614);
            CallChecker.varInit(t, "t", 283, 9863, 10614);
            CallChecker.varInit(this.expandable, "expandable", 283, 9863, 10614);
            CallChecker.varInit(this.evaluations, "evaluations", 283, 9863, 10614);
            CallChecker.varInit(this.name, "name", 283, 9863, 10614);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 283, 9863, 10614);
            CallChecker.varInit(this.eventsStates, "eventsStates", 283, 9863, 10614);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 283, 9863, 10614);
            CallChecker.varInit(this.isLastStep, "isLastStep", 283, 9863, 10614);
            CallChecker.varInit(this.stepSize, "stepSize", 283, 9863, 10614);
            CallChecker.varInit(this.stepStart, "stepStart", 283, 9863, 10614);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 283, 9863, 10614);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 285, 10529, 10539)) {
                evaluations = CallChecker.beforeCalled(evaluations, Incrementor.class, 285, 10529, 10539);
                CallChecker.isCalled(evaluations, Incrementor.class, 285, 10529, 10539).incrementCount();
            }
            if (CallChecker.beforeDeref(expandable, ExpandableStatefulODE.class, 286, 10567, 10576)) {
                expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 286, 10567, 10576);
                CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 286, 10567, 10576).computeDerivatives(t, y, yDot);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    protected void setStateInitialized(final boolean stateInitialized) {
        MethodContext _bcornu_methode_context36 = new MethodContext(void.class, 296, 10621, 11067);
        try {
            CallChecker.varInit(this, "this", 296, 10621, 11067);
            CallChecker.varInit(stateInitialized, "stateInitialized", 296, 10621, 11067);
            CallChecker.varInit(this.expandable, "expandable", 296, 10621, 11067);
            CallChecker.varInit(this.evaluations, "evaluations", 296, 10621, 11067);
            CallChecker.varInit(this.name, "name", 296, 10621, 11067);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 296, 10621, 11067);
            CallChecker.varInit(this.eventsStates, "eventsStates", 296, 10621, 11067);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 296, 10621, 11067);
            CallChecker.varInit(this.isLastStep, "isLastStep", 296, 10621, 11067);
            CallChecker.varInit(this.stepSize, "stepSize", 296, 10621, 11067);
            CallChecker.varInit(this.stepStart, "stepStart", 296, 10621, 11067);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 296, 10621, 11067);
            this.statesInitialized = stateInitialized;
            CallChecker.varAssign(this.statesInitialized, "this.statesInitialized", 297, 11020, 11061);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    protected double acceptStep(final AbstractStepInterpolator interpolator, final double[] y, final double[] yDot, final double tEnd) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        MethodContext _bcornu_methode_context38 = new MethodContext(double.class, 313, 11074, 17536);
        try {
            CallChecker.varInit(this, "this", 313, 11074, 17536);
            CallChecker.varInit(tEnd, "tEnd", 313, 11074, 17536);
            CallChecker.varInit(yDot, "yDot", 313, 11074, 17536);
            CallChecker.varInit(y, "y", 313, 11074, 17536);
            CallChecker.varInit(interpolator, "interpolator", 313, 11074, 17536);
            CallChecker.varInit(this.expandable, "expandable", 313, 11074, 17536);
            CallChecker.varInit(this.evaluations, "evaluations", 313, 11074, 17536);
            CallChecker.varInit(this.name, "name", 313, 11074, 17536);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 313, 11074, 17536);
            CallChecker.varInit(this.eventsStates, "eventsStates", 313, 11074, 17536);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 313, 11074, 17536);
            CallChecker.varInit(this.isLastStep, "isLastStep", 313, 11074, 17536);
            CallChecker.varInit(this.stepSize, "stepSize", 313, 11074, 17536);
            CallChecker.varInit(this.stepStart, "stepStart", 313, 11074, 17536);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 313, 11074, 17536);
            double previousT = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 317, 12134, 12145)) {
                previousT = CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 317, 12134, 12145).getGlobalPreviousTime();
                CallChecker.varAssign(previousT, "previousT", 317, 12134, 12145);
            }
            final double currentT = CallChecker.varInit(((double) (CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 318, 12208, 12219).getGlobalCurrentTime())), "currentT", 318, 12184, 12243);
            if (!(statesInitialized)) {
                if (CallChecker.beforeDeref(eventsStates, double.class, 322, 12379, 12390)) {
                    for (EventState state : eventsStates) {
                        if (CallChecker.beforeDeref(state, EventState.class, 323, 12415, 12419)) {
                            CallChecker.isCalled(state, EventState.class, 323, 12415, 12419).reinitializeBegin(interpolator);
                        }
                    }
                }
                statesInitialized = true;
                CallChecker.varAssign(this.statesInitialized, "this.statesInitialized", 325, 12488, 12512);
            }
            final int orderingSign;
            if (CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 329, 12635, 12646).isForward()) {
                orderingSign = +1;
                CallChecker.varAssign(orderingSign, "orderingSign", 329, 12635, 12668);
            }else {
                orderingSign = -1;
                CallChecker.varAssign(orderingSign, "orderingSign", 329, 12635, 12668);
            }
            SortedSet<EventState> occuringEvents = CallChecker.varInit(new TreeSet<EventState>(new Comparator<EventState>() {
                public int compare(EventState es0, EventState es1) {
                    MethodContext _bcornu_methode_context37 = new MethodContext(int.class, 333, 12794, 12998);
                    try {
                        CallChecker.varInit(this, "this", 333, 12794, 12998);
                        CallChecker.varInit(es1, "es1", 333, 12794, 12998);
                        CallChecker.varInit(es0, "es0", 333, 12794, 12998);
                        if (CallChecker.beforeDeref(es0, EventState.class, 334, 12941, 12943)) {
                            if (CallChecker.beforeDeref(es1, EventState.class, 334, 12961, 12963)) {
                                es0 = CallChecker.beforeCalled(es0, EventState.class, 334, 12941, 12943);
                                es1 = CallChecker.beforeCalled(es1, EventState.class, 334, 12961, 12963);
                                return orderingSign * (Double.compare(CallChecker.isCalled(es0, EventState.class, 334, 12941, 12943).getEventTime(), CallChecker.isCalled(es1, EventState.class, 334, 12961, 12963).getEventTime()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context37.methodEnd();
                    }
                }
            }), "occuringEvents", 330, 12683, 13015);
            if (CallChecker.beforeDeref(eventsStates, double.class, 339, 13060, 13071)) {
                for (final EventState state : eventsStates) {
                    if (CallChecker.beforeDeref(state, EventState.class, 340, 13096, 13100)) {
                        if (CallChecker.isCalled(state, EventState.class, 340, 13096, 13100).evaluateStep(interpolator)) {
                            if (CallChecker.beforeDeref(occuringEvents, SortedSet.class, 342, 13216, 13229)) {
                                occuringEvents = CallChecker.beforeCalled(occuringEvents, SortedSet.class, 342, 13216, 13229);
                                CallChecker.isCalled(occuringEvents, SortedSet.class, 342, 13216, 13229).add(state);
                            }
                        }
                    }
                }
            }
            occuringEvents = CallChecker.beforeCalled(occuringEvents, SortedSet.class, 346, 13296, 13309);
            while (!(CallChecker.isCalled(occuringEvents, SortedSet.class, 346, 13296, 13309).isEmpty())) {
                occuringEvents = CallChecker.beforeCalled(occuringEvents, SortedSet.class, 349, 13437, 13450);
                final Iterator<EventState> iterator = CallChecker.varInit(CallChecker.isCalled(occuringEvents, SortedSet.class, 349, 13437, 13450).iterator(), "iterator", 349, 13341, 13462);
                final EventState currentEvent = CallChecker.varInit(CallChecker.isCalled(iterator, Iterator.class, 350, 13512, 13519).next(), "currentEvent", 350, 13480, 13527);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 351, 13545, 13552)) {
                    CallChecker.isCalled(iterator, Iterator.class, 351, 13545, 13552).remove();
                }
                final double eventT = CallChecker.varInit(((double) (CallChecker.isCalled(currentEvent, EventState.class, 354, 13695, 13706).getEventTime())), "eventT", 354, 13581, 13722);
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 355, 13740, 13751)) {
                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 355, 13740, 13751).setSoftPreviousTime(previousT);
                }
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 356, 13801, 13812)) {
                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 356, 13801, 13812).setSoftCurrentTime(eventT);
                }
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 359, 13902, 13913)) {
                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 359, 13902, 13913).setInterpolatedTime(eventT);
                }
                final double[] eventYComplete = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 360, 14003, 14003).length], "eventYComplete", 360, 13960, 14012);
                if (CallChecker.beforeDeref(expandable, ExpandableStatefulODE.class, 361, 14030, 14039)) {
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 361, 14079, 14090)) {
                        expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 361, 14030, 14039);
                        final EquationsMapper npe_invocation_var2 = CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 361, 14030, 14039).getPrimaryMapper();
                        if (CallChecker.beforeDeref(npe_invocation_var2, EquationsMapper.class, 361, 14030, 14058)) {
                            CallChecker.isCalled(npe_invocation_var2, EquationsMapper.class, 361, 14030, 14058).insertEquationData(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 361, 14079, 14090).getInterpolatedState(), eventYComplete);
                        }
                    }
                }
                int index = CallChecker.varInit(((int) (0)), "index", 363, 14214, 14227);
                expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 364, 14278, 14287);
                for (EquationsMapper secondary : CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 364, 14278, 14287).getSecondaryMappers()) {
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 365, 14363, 14374)) {
                        if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 365, 14334, 14342)) {
                            CallChecker.isCalled(secondary, EquationsMapper.class, 365, 14334, 14342).insertEquationData(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 365, 14363, 14374).getInterpolatedSecondaryState((index++)), eventYComplete);
                        }
                    }
                }
                if (CallChecker.beforeDeref(eventsStates, double.class, 370, 14607, 14618)) {
                    for (final EventState state : eventsStates) {
                        if (CallChecker.beforeDeref(state, EventState.class, 371, 14643, 14647)) {
                            CallChecker.isCalled(state, EventState.class, 371, 14643, 14647).stepAccepted(eventT, eventYComplete);
                        }
                        if (CallChecker.beforeDeref(state, EventState.class, 372, 14734, 14738)) {
                            isLastStep = (isLastStep) || (CallChecker.isCalled(state, EventState.class, 372, 14734, 14738).stop());
                            CallChecker.varAssign(this.isLastStep, "this.isLastStep", 372, 14707, 14746);
                        }
                    }
                }
                if (CallChecker.beforeDeref(stepHandlers, double.class, 376, 14886, 14897)) {
                    for (final StepHandler handler : stepHandlers) {
                        if (CallChecker.beforeDeref(handler, StepHandler.class, 377, 14922, 14928)) {
                            CallChecker.isCalled(handler, StepHandler.class, 377, 14922, 14928).handleStep(interpolator, isLastStep);
                        }
                    }
                }
                if (isLastStep) {
                    if (CallChecker.beforeDeref(y, double[].class, 382, 15142, 15142)) {
                        System.arraycopy(eventYComplete, 0, y, 0, CallChecker.isCalled(y, double[].class, 382, 15142, 15142).length);
                    }
                    return eventT;
                }
                boolean needReset = CallChecker.varInit(((boolean) (false)), "needReset", 386, 15223, 15248);
                if (CallChecker.beforeDeref(eventsStates, double.class, 387, 15296, 15307)) {
                    for (final EventState state : eventsStates) {
                        if (CallChecker.beforeDeref(state, EventState.class, 388, 15358, 15362)) {
                            needReset = needReset || (CallChecker.isCalled(state, EventState.class, 388, 15358, 15362).reset(eventT, eventYComplete));
                            CallChecker.varAssign(needReset, "needReset", 388, 15332, 15393);
                        }
                    }
                }
                if (needReset) {
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 393, 15612, 15623)) {
                        CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 393, 15612, 15623).setInterpolatedTime(eventT);
                    }
                    if (CallChecker.beforeDeref(y, double[].class, 394, 15716, 15716)) {
                        System.arraycopy(eventYComplete, 0, y, 0, CallChecker.isCalled(y, double[].class, 394, 15716, 15716).length);
                    }
                    computeDerivatives(eventT, y, yDot);
                    resetOccurred = true;
                    CallChecker.varAssign(this.resetOccurred, "this.resetOccurred", 396, 15804, 15824);
                    return eventT;
                }
                previousT = eventT;
                CallChecker.varAssign(previousT, "previousT", 401, 15966, 15984);
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 402, 16002, 16013)) {
                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 402, 16002, 16013).setSoftPreviousTime(eventT);
                }
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 403, 16060, 16071)) {
                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 403, 16060, 16071).setSoftCurrentTime(currentT);
                }
                if (CallChecker.beforeDeref(currentEvent, EventState.class, 406, 16214, 16225)) {
                    if (CallChecker.isCalled(currentEvent, EventState.class, 406, 16214, 16225).evaluateStep(interpolator)) {
                        if (CallChecker.beforeDeref(occuringEvents, SortedSet.class, 408, 16341, 16354)) {
                            occuringEvents = CallChecker.beforeCalled(occuringEvents, SortedSet.class, 408, 16341, 16354);
                            CallChecker.isCalled(occuringEvents, SortedSet.class, 408, 16341, 16354).add(currentEvent);
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 414, 16480, 16491)) {
                CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 414, 16480, 16491).setInterpolatedTime(currentT);
            }
            final double[] currentY = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 415, 16573, 16573).length], "currentY", 415, 16536, 16582);
            if (CallChecker.beforeDeref(expandable, ExpandableStatefulODE.class, 416, 16596, 16605)) {
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 416, 16645, 16656)) {
                    expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 416, 16596, 16605);
                    final EquationsMapper npe_invocation_var3 = CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 416, 16596, 16605).getPrimaryMapper();
                    if (CallChecker.beforeDeref(npe_invocation_var3, EquationsMapper.class, 416, 16596, 16624)) {
                        CallChecker.isCalled(npe_invocation_var3, EquationsMapper.class, 416, 16596, 16624).insertEquationData(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 416, 16645, 16656).getInterpolatedState(), currentY);
                    }
                }
            }
            int index = CallChecker.varInit(((int) (0)), "index", 418, 16766, 16779);
            expandable = CallChecker.beforeCalled(expandable, ExpandableStatefulODE.class, 419, 16826, 16835);
            for (EquationsMapper secondary : CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 419, 16826, 16835).getSecondaryMappers()) {
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 420, 16907, 16918)) {
                    if (CallChecker.beforeDeref(secondary, EquationsMapper.class, 420, 16878, 16886)) {
                        CallChecker.isCalled(secondary, EquationsMapper.class, 420, 16878, 16886).insertEquationData(CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 420, 16907, 16918).getInterpolatedSecondaryState((index++)), currentY);
                    }
                }
            }
            if (CallChecker.beforeDeref(eventsStates, double.class, 423, 17072, 17083)) {
                for (final EventState state : eventsStates) {
                    if (CallChecker.beforeDeref(state, EventState.class, 424, 17104, 17108)) {
                        CallChecker.isCalled(state, EventState.class, 424, 17104, 17108).stepAccepted(currentT, currentY);
                    }
                    if (CallChecker.beforeDeref(state, EventState.class, 425, 17187, 17191)) {
                        isLastStep = (isLastStep) || (CallChecker.isCalled(state, EventState.class, 425, 17187, 17191).stop());
                        CallChecker.varAssign(this.isLastStep, "this.isLastStep", 425, 17160, 17199);
                    }
                }
            }
            isLastStep = (isLastStep) || (Precision.equals(currentT, tEnd, 1));
            CallChecker.varAssign(this.isLastStep, "this.isLastStep", 427, 17227, 17289);
            if (CallChecker.beforeDeref(stepHandlers, double.class, 430, 17409, 17420)) {
                for (StepHandler handler : stepHandlers) {
                    if (CallChecker.beforeDeref(handler, StepHandler.class, 431, 17441, 17447)) {
                        CallChecker.isCalled(handler, StepHandler.class, 431, 17441, 17447).handleStep(interpolator, isLastStep);
                    }
                }
            }
            return currentT;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    protected void sanityChecks(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context39 = new MethodContext(void.class, 445, 17543, 18543);
        try {
            CallChecker.varInit(this, "this", 445, 17543, 18543);
            CallChecker.varInit(t, "t", 445, 17543, 18543);
            CallChecker.varInit(equations, "equations", 445, 17543, 18543);
            CallChecker.varInit(this.expandable, "expandable", 445, 17543, 18543);
            CallChecker.varInit(this.evaluations, "evaluations", 445, 17543, 18543);
            CallChecker.varInit(this.name, "name", 445, 17543, 18543);
            CallChecker.varInit(this.statesInitialized, "statesInitialized", 445, 17543, 18543);
            CallChecker.varInit(this.eventsStates, "eventsStates", 445, 17543, 18543);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 445, 17543, 18543);
            CallChecker.varInit(this.isLastStep, "isLastStep", 445, 17543, 18543);
            CallChecker.varInit(this.stepSize, "stepSize", 445, 17543, 18543);
            CallChecker.varInit(this.stepStart, "stepStart", 445, 17543, 18543);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 445, 17543, 18543);
            final double threshold = CallChecker.varInit(((double) (1000 * (FastMath.ulp(FastMath.max(FastMath.abs(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 448, 18157, 18165).getTime()), FastMath.abs(t)))))), "threshold", 448, 18086, 18262);
            final double dt = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(equations, ExpandableStatefulODE.class, 450, 18303, 18311).getTime()) - t)))), "dt", 450, 18272, 18327);
            if (dt <= threshold) {
                throw new NumberIsTooSmallException(LocalizedFormats.TOO_SMALL_INTEGRATION_INTERVAL, dt, threshold, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }
}

