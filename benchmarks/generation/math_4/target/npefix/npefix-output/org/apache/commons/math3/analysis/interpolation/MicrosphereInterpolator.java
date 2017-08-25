package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;

public class MicrosphereInterpolator implements MultivariateInterpolator {
    public static final int DEFAULT_MICROSPHERE_ELEMENTS = 2000;

    public static final int DEFAULT_BRIGHTNESS_EXPONENT = 2;

    private final int microsphereElements;

    private final int brightnessExponent;

    public MicrosphereInterpolator() {
        this(MicrosphereInterpolator.DEFAULT_MICROSPHERE_ELEMENTS, MicrosphereInterpolator.DEFAULT_BRIGHTNESS_EXPONENT);
        ConstructorContext _bcornu_methode_context415 = new ConstructorContext(MicrosphereInterpolator.class, 62, 2156, 2598);
        try {
        } finally {
            _bcornu_methode_context415.methodEnd();
        }
    }

    public MicrosphereInterpolator(final int elements, final int exponent) throws NotPositiveException, NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context416 = new ConstructorContext(MicrosphereInterpolator.class, 73, 2605, 3456);
        try {
            if (exponent < 0) {
                throw new NotPositiveException(exponent);
            }
            if (elements <= 0) {
                throw new NotStrictlyPositiveException(elements);
            }
            microsphereElements = elements;
            CallChecker.varAssign(this.microsphereElements, "this.microsphereElements", 84, 3381, 3411);
            brightnessExponent = exponent;
            CallChecker.varAssign(this.brightnessExponent, "this.brightnessExponent", 85, 3421, 3450);
        } finally {
            _bcornu_methode_context416.methodEnd();
        }
    }

    public MultivariateFunction interpolate(final double[][] xval, final double[] yval) throws DimensionMismatchException, NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context1786 = new MethodContext(MultivariateFunction.class, 91, 3463, 4132);
        try {
            CallChecker.varInit(this, "this", 91, 3463, 4132);
            CallChecker.varInit(yval, "yval", 91, 3463, 4132);
            CallChecker.varInit(xval, "xval", 91, 3463, 4132);
            CallChecker.varInit(this.brightnessExponent, "brightnessExponent", 91, 3463, 4132);
            CallChecker.varInit(this.microsphereElements, "microsphereElements", 91, 3463, 4132);
            CallChecker.varInit(DEFAULT_BRIGHTNESS_EXPONENT, "org.apache.commons.math3.analysis.interpolation.MicrosphereInterpolator.DEFAULT_BRIGHTNESS_EXPONENT", 91, 3463, 4132);
            CallChecker.varInit(DEFAULT_MICROSPHERE_ELEMENTS, "org.apache.commons.math3.analysis.interpolation.MicrosphereInterpolator.DEFAULT_MICROSPHERE_ELEMENTS", 91, 3463, 4132);
            CallChecker.isCalled(xval, double[][].class, 97, 3843, 3846)[0] = CallChecker.beforeCalled(CallChecker.isCalled(xval, double[][].class, 97, 3843, 3846)[0], double[].class, 97, 3843, 3849);
            final UnitSphereRandomVectorGenerator rand = CallChecker.varInit(new UnitSphereRandomVectorGenerator(CallChecker.isCalled(CallChecker.isCalled(xval, double[][].class, 97, 3843, 3846)[0], double[].class, 97, 3843, 3849).length), "rand", 96, 3750, 3858);
            return new MicrosphereInterpolatingFunction(xval, yval, brightnessExponent, microsphereElements, rand);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1786.methodEnd();
        }
    }
}

