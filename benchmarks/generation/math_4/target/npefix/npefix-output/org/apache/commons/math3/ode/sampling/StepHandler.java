package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.exception.MaxCountExceededException;

public interface StepHandler {
    void init(double t0, double[] y0, double t);

    void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException;
}

