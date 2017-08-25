package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;

public interface SecondOrderIntegrator extends ODEIntegrator {
    void integrate(SecondOrderDifferentialEquations equations, double t0, double[] y0, double[] yDot0, double t, double[] y, double[] yDot) throws MathIllegalArgumentException, MathIllegalStateException;
}

