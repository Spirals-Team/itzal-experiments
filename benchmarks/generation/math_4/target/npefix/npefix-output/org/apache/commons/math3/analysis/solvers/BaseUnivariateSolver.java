package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

public interface BaseUnivariateSolver<FUNC extends UnivariateFunction> {
    int getMaxEvaluations();

    int getEvaluations();

    double getAbsoluteAccuracy();

    double getRelativeAccuracy();

    double getFunctionValueAccuracy();

    double solve(int maxEval, FUNC f, double min, double max) throws MathIllegalArgumentException, TooManyEvaluationsException;

    double solve(int maxEval, FUNC f, double min, double max, double startValue) throws MathIllegalArgumentException, TooManyEvaluationsException;

    double solve(int maxEval, FUNC f, double startValue);
}

