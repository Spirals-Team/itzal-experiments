package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

public interface SecondaryEquations {
    int getDimension();

    void computeDerivatives(double t, double[] primary, double[] primaryDot, double[] secondary, double[] secondaryDot) throws DimensionMismatchException, MaxCountExceededException;
}

