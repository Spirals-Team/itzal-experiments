package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateFunction;

@Deprecated
public interface BaseMultivariateOptimizer<FUNC extends MultivariateFunction> extends BaseOptimizer<PointValuePair> {
    @Deprecated
    PointValuePair optimize(int maxEval, FUNC f, GoalType goalType, double[] startPoint);
}

