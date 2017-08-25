package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;

public interface MultivariateInterpolator {
    MultivariateFunction interpolate(double[][] xval, double[] yval) throws DimensionMismatchException, MathIllegalArgumentException, NoDataException, NullArgumentException;
}

