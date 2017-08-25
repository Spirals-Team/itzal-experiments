package org.apache.commons.math3.linear;


public interface DecompositionSolver {
    RealVector solve(final RealVector b);

    RealMatrix solve(final RealMatrix b);

    boolean isNonSingular();

    RealMatrix getInverse();
}

