package org.apache.commons.math3.optimization.univariate;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.optimization.BaseOptimizer;
import org.apache.commons.math3.optimization.GoalType;

@Deprecated
public interface BaseUnivariateOptimizer<FUNC extends UnivariateFunction> extends BaseOptimizer<UnivariatePointValuePair> {
    UnivariatePointValuePair optimize(int maxEval, FUNC f, GoalType goalType, double min, double max);

    UnivariatePointValuePair optimize(int maxEval, FUNC f, GoalType goalType, double min, double max, double startValue);
}

