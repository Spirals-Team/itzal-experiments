package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;

@Deprecated
public interface BaseMultivariateVectorOptimizer<FUNC extends MultivariateVectorFunction> extends BaseOptimizer<PointVectorValuePair> {
    @Deprecated
    PointVectorValuePair optimize(int maxEval, FUNC f, double[] target, double[] weight, double[] startPoint);
}

