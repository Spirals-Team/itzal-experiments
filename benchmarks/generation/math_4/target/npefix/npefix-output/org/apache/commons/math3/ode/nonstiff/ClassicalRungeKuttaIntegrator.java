package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;

public class ClassicalRungeKuttaIntegrator extends RungeKuttaIntegrator {
    private static final double[] STATIC_C = new double[]{ 1.0 / 2.0 , 1.0 / 2.0 , 1.0 };

    private static final double[][] STATIC_A = new double[][]{ new double[]{ 1.0 / 2.0 } , new double[]{ 0.0 , 1.0 / 2.0 } , new double[]{ 0.0 , 0.0 , 1.0 } };

    private static final double[] STATIC_B = new double[]{ 1.0 / 6.0 , 1.0 / 3.0 , 1.0 / 3.0 , 1.0 / 6.0 };

    public ClassicalRungeKuttaIntegrator(final double step) {
        super("classical Runge-Kutta", ClassicalRungeKuttaIntegrator.STATIC_C, ClassicalRungeKuttaIntegrator.STATIC_A, ClassicalRungeKuttaIntegrator.STATIC_B, new ClassicalRungeKuttaStepInterpolator(), step);
        ConstructorContext _bcornu_methode_context267 = new ConstructorContext(ClassicalRungeKuttaIntegrator.class, 70, 1965, 2291);
        try {
        } finally {
            _bcornu_methode_context267.methodEnd();
        }
    }
}

