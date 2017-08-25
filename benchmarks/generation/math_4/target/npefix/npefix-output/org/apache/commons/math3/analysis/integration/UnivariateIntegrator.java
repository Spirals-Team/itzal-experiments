package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

public interface UnivariateIntegrator {
    double getRelativeAccuracy();

    double getAbsoluteAccuracy();

    int getMinimalIterationCount();

    int getMaximalIterationCount();

    double integrate(int maxEval, UnivariateFunction f, double min, double max) throws MathIllegalArgumentException, MaxCountExceededException, NullArgumentException, TooManyEvaluationsException;

    int getEvaluations();

    int getIterations();
}

