package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;

public class MidpointIntegrator extends RungeKuttaIntegrator {
    private static final double[] STATIC_C = new double[]{ 1.0 / 2.0 };

    private static final double[][] STATIC_A = new double[][]{ new double[]{ 1.0 / 2.0 } };

    private static final double[] STATIC_B = new double[]{ 0.0 , 1.0 };

    public MidpointIntegrator(final double step) {
        super("midpoint", MidpointIntegrator.STATIC_C, MidpointIntegrator.STATIC_A, MidpointIntegrator.STATIC_B, new MidpointStepInterpolator(), step);
        ConstructorContext _bcornu_methode_context266 = new ConstructorContext(MidpointIntegrator.class, 64, 1678, 1938);
        try {
        } finally {
            _bcornu_methode_context266.methodEnd();
        }
    }
}

