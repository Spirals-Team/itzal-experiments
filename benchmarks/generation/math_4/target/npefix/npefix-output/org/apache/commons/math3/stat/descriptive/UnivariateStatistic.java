package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.util.MathArrays;

public interface UnivariateStatistic extends MathArrays.Function {
    double evaluate(double[] values) throws MathIllegalArgumentException;

    double evaluate(double[] values, int begin, int length) throws MathIllegalArgumentException;

    UnivariateStatistic copy();
}

