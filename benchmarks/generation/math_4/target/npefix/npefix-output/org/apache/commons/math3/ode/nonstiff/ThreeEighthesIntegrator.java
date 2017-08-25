package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;

public class ThreeEighthesIntegrator extends RungeKuttaIntegrator {
    private static final double[] STATIC_C = new double[]{ 1.0 / 3.0 , 2.0 / 3.0 , 1.0 };

    private static final double[][] STATIC_A = new double[][]{ new double[]{ 1.0 / 3.0 } , new double[]{ (-1.0) / 3.0 , 1.0 } , new double[]{ 1.0 , -1.0 , 1.0 } };

    private static final double[] STATIC_B = new double[]{ 1.0 / 8.0 , 3.0 / 8.0 , 3.0 / 8.0 , 1.0 / 8.0 };

    public ThreeEighthesIntegrator(final double step) {
        super("3/8", ThreeEighthesIntegrator.STATIC_C, ThreeEighthesIntegrator.STATIC_A, ThreeEighthesIntegrator.STATIC_B, new ThreeEighthesStepInterpolator(), step);
        ConstructorContext _bcornu_methode_context1269 = new ConstructorContext(ThreeEighthesIntegrator.class, 68, 1913, 2173);
        try {
        } finally {
            _bcornu_methode_context1269.methodEnd();
        }
    }
}

