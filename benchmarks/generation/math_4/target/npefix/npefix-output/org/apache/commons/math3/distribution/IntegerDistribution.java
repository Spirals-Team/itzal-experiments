package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;

public interface IntegerDistribution {
    double probability(int x);

    double cumulativeProbability(int x);

    double cumulativeProbability(int x0, int x1) throws NumberIsTooLargeException;

    int inverseCumulativeProbability(double p) throws OutOfRangeException;

    double getNumericalMean();

    double getNumericalVariance();

    int getSupportLowerBound();

    int getSupportUpperBound();

    boolean isSupportConnected();

    void reseedRandomGenerator(long seed);

    int sample();

    int[] sample(int sampleSize);
}

