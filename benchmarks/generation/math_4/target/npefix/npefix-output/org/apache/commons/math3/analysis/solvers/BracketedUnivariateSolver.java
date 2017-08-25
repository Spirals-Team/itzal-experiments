package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;

public interface BracketedUnivariateSolver<FUNC extends UnivariateFunction> extends BaseUnivariateSolver<FUNC> {
    double solve(int maxEval, FUNC f, double min, double max, AllowedSolution allowedSolution);

    double solve(int maxEval, FUNC f, double min, double max, double startValue, AllowedSolution allowedSolution);
}

