package org.apache.commons.math3.optimization;


@Deprecated
public interface ConvergenceChecker<PAIR> {
    boolean converged(int iteration, PAIR previous, PAIR current);
}

