package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

public interface FirstOrderIntegrator extends ODEIntegrator {
    double integrate(FirstOrderDifferentialEquations equations, double t0, double[] y0, double t, double[] y) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException;
}

