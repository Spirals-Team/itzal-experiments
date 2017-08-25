package org.apache.commons.math3.complex;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

public class ComplexUtils {
    private ComplexUtils() {
        ConstructorContext _bcornu_methode_context148 = new ConstructorContext(ComplexUtils.class, 35, 1202, 1270);
        try {
        } finally {
            _bcornu_methode_context148.methodEnd();
        }
    }

    public static Complex polar2Complex(double r, double theta) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context534 = new MethodContext(Complex.class, 62, 1277, 2796);
        try {
            CallChecker.varInit(theta, "theta", 62, 1277, 2796);
            CallChecker.varInit(r, "r", 62, 1277, 2796);
            if (r < 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_COMPLEX_MODULE, r);
            }
            return new Complex((r * (FastMath.cos(theta))), (r * (FastMath.sin(theta))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context534.methodEnd();
        }
    }

    public static Complex[] convertToComplex(double[] real) {
        MethodContext _bcornu_methode_context535 = new MethodContext(Complex[].class, 79, 2803, 3321);
        try {
            CallChecker.varInit(real, "real", 79, 2803, 3321);
            real = CallChecker.beforeCalled(real, double[].class, 80, 3182, 3185);
            final Complex[] c = CallChecker.varInit(new Complex[CallChecker.isCalled(real, double[].class, 80, 3182, 3185).length], "c", 80, 3150, 3194);
            real = CallChecker.beforeCalled(real, double[].class, 81, 3224, 3227);
            for (int i = 0; i < (CallChecker.isCalled(real, double[].class, 81, 3224, 3227).length); i++) {
                if (CallChecker.beforeDeref(c, Complex[].class, 82, 3256, 3256)) {
                    if (CallChecker.beforeDeref(real, double[].class, 82, 3275, 3278)) {
                        real = CallChecker.beforeCalled(real, double[].class, 82, 3275, 3278);
                        CallChecker.isCalled(c, Complex[].class, 82, 3256, 3256)[i] = new Complex(CallChecker.isCalled(real, double[].class, 82, 3275, 3278)[i], 0);
                        CallChecker.varAssign(CallChecker.isCalled(c, Complex[].class, 82, 3256, 3256)[i], "CallChecker.isCalled(c, Complex[].class, 82, 3256, 3256)[i]", 82, 3256, 3286);
                    }
                }
            }
            return c;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context535.methodEnd();
        }
    }
}

