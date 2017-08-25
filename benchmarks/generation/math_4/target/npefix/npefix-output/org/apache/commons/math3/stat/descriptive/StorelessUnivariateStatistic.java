package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;

public interface StorelessUnivariateStatistic extends UnivariateStatistic {
    void increment(double d);

    void incrementAll(double[] values) throws MathIllegalArgumentException;

    void incrementAll(double[] values, int start, int length) throws MathIllegalArgumentException;

    double getResult();

    long getN();

    void clear();

    StorelessUnivariateStatistic copy();
}

