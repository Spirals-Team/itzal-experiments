package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;

public interface WeightedEvaluation {
    double evaluate(double[] values, double[] weights) throws MathIllegalArgumentException;

    double evaluate(double[] values, double[] weights, int begin, int length) throws MathIllegalArgumentException;
}

