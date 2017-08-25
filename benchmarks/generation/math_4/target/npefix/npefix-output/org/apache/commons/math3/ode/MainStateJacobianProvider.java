package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

public interface MainStateJacobianProvider extends FirstOrderDifferentialEquations {
    void computeMainStateJacobian(double t, double[] y, double[] yDot, double[][] dFdY) throws DimensionMismatchException, MaxCountExceededException;
}

