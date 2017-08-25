package org.apache.commons.math3.stat.regression;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;

public interface UpdatingMultipleLinearRegression {
    boolean hasIntercept();

    long getN();

    void addObservation(double[] x, double y) throws ModelSpecificationException;

    void addObservations(double[][] x, double[] y) throws ModelSpecificationException;

    void clear();

    RegressionResults regress() throws NoDataException, ModelSpecificationException;

    RegressionResults regress(int[] variablesToInclude) throws MathIllegalArgumentException, ModelSpecificationException;
}

