package org.apache.commons.math3.ode;


public interface ParameterizedODE extends Parameterizable {
    double getParameter(String name) throws UnknownParameterException;

    void setParameter(String name, double value) throws UnknownParameterException;
}

