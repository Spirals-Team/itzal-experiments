package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;

public class EulerIntegrator extends RungeKuttaIntegrator {
    private static final double[] STATIC_C = new double[]{  };

    private static final double[][] STATIC_A = new double[][]{  };

    private static final double[] STATIC_B = new double[]{ 1.0 };

    public EulerIntegrator(final double step) {
        super("Euler", EulerIntegrator.STATIC_C, EulerIntegrator.STATIC_A, EulerIntegrator.STATIC_B, new EulerStepInterpolator(), step);
        ConstructorContext _bcornu_methode_context875 = new ConstructorContext(EulerIntegrator.class, 68, 2231, 2480);
        try {
        } finally {
            _bcornu_methode_context875.methodEnd();
        }
    }
}

