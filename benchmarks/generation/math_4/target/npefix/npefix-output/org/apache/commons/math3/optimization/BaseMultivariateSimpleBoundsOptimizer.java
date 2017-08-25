package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateFunction;

@Deprecated
public interface BaseMultivariateSimpleBoundsOptimizer<FUNC extends MultivariateFunction> extends BaseMultivariateOptimizer<FUNC> {
    PointValuePair optimize(int maxEval, FUNC f, GoalType goalType, double[] startPoint, double[] lowerBound, double[] upperBound);
}

