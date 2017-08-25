package org.apache.commons.math3.ode;

import java.util.Collection;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.sampling.StepHandler;

public interface ODEIntegrator {
    String getName();

    void addStepHandler(StepHandler handler);

    Collection<StepHandler> getStepHandlers();

    void clearStepHandlers();

    void addEventHandler(EventHandler handler, double maxCheckInterval, double convergence, int maxIterationCount);

    void addEventHandler(EventHandler handler, double maxCheckInterval, double convergence, int maxIterationCount, UnivariateSolver solver);

    Collection<EventHandler> getEventHandlers();

    void clearEventHandlers();

    double getCurrentStepStart();

    double getCurrentSignedStepsize();

    void setMaxEvaluations(int maxEvaluations);

    int getMaxEvaluations();

    int getEvaluations();
}

