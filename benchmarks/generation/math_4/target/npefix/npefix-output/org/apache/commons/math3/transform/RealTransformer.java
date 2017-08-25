package org.apache.commons.math3.transform;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;

public interface RealTransformer {
    double[] transform(double[] f, TransformType type) throws MathIllegalArgumentException;

    double[] transform(UnivariateFunction f, double min, double max, int n, TransformType type) throws MathIllegalArgumentException, NonMonotonicSequenceException, NotStrictlyPositiveException;
}

