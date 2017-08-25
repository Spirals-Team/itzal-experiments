package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.util.FastMath;

public class GillIntegrator extends RungeKuttaIntegrator {
    private static final double[] STATIC_C = new double[]{ 1.0 / 2.0 , 1.0 / 2.0 , 1.0 };

    private static final double[][] STATIC_A = new double[][]{ new double[]{ 1.0 / 2.0 } , new double[]{ ((FastMath.sqrt(2.0)) - 1.0) / 2.0 , (2.0 - (FastMath.sqrt(2.0))) / 2.0 } , new double[]{ 0.0 , (-(FastMath.sqrt(2.0))) / 2.0 , (2.0 + (FastMath.sqrt(2.0))) / 2.0 } };

    private static final double[] STATIC_B = new double[]{ 1.0 / 6.0 , (2.0 - (FastMath.sqrt(2.0))) / 6.0 , (2.0 + (FastMath.sqrt(2.0))) / 6.0 , 1.0 / 6.0 };

    public GillIntegrator(final double step) {
        super("Gill", GillIntegrator.STATIC_C, GillIntegrator.STATIC_A, GillIntegrator.STATIC_B, new GillStepInterpolator(), step);
        ConstructorContext _bcornu_methode_context932 = new ConstructorContext(GillIntegrator.class, 70, 2189, 2446);
        try {
        } finally {
            _bcornu_methode_context932.methodEnd();
        }
    }
}

