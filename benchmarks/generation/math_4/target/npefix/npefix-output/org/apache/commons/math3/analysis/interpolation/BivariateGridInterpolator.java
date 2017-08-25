package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

public interface BivariateGridInterpolator {
    BivariateFunction interpolate(double[] xval, double[] yval, double[][] fval) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NumberIsTooSmallException;
}

