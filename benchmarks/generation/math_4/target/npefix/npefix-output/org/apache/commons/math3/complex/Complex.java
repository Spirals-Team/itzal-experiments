package org.apache.commons.math3.complex;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class Complex implements Serializable , FieldElement<Complex> {
    public static final Complex I = new Complex(0.0, 1.0);

    public static final Complex NaN = new Complex(Double.NaN, Double.NaN);

    public static final Complex INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

    public static final Complex ONE = new Complex(1.0, 0.0);

    public static final Complex ZERO = new Complex(0.0, 0.0);

    private static final long serialVersionUID = -6195664516687396620L;

    private final double imaginary;

    private final double real;

    private final transient boolean isNaN;

    private final transient boolean isInfinite;

    public Complex(double real) {
        this(real, 0.0);
        ConstructorContext _bcornu_methode_context243 = new ConstructorContext(Complex.class, 88, 3575, 3744);
        try {
        } finally {
            _bcornu_methode_context243.methodEnd();
        }
    }

    public Complex(double real, double imaginary) {
        ConstructorContext _bcornu_methode_context244 = new ConstructorContext(Complex.class, 98, 3751, 4191);
        try {
            this.real = real;
            CallChecker.varAssign(this.real, "this.real", 99, 3967, 3983);
            this.imaginary = imaginary;
            CallChecker.varAssign(this.imaginary, "this.imaginary", 100, 3993, 4019);
            isNaN = (Double.isNaN(real)) || (Double.isNaN(imaginary));
            CallChecker.varAssign(this.isNaN, "this.isNaN", 102, 4030, 4083);
            isInfinite = (!(isNaN)) && ((Double.isInfinite(real)) || (Double.isInfinite(imaginary)));
            CallChecker.varAssign(this.isInfinite, "this.isInfinite", 103, 4093, 4185);
        } finally {
            _bcornu_methode_context244.methodEnd();
        }
    }

    public double abs() {
        MethodContext _bcornu_methode_context987 = new MethodContext(double.class, 115, 4198, 5169);
        try {
            CallChecker.varInit(this, "this", 115, 4198, 5169);
            CallChecker.varInit(this.isInfinite, "isInfinite", 115, 4198, 5169);
            CallChecker.varInit(this.isNaN, "isNaN", 115, 4198, 5169);
            CallChecker.varInit(this.real, "real", 115, 4198, 5169);
            CallChecker.varInit(this.imaginary, "imaginary", 115, 4198, 5169);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 115, 4198, 5169);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 115, 4198, 5169);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 115, 4198, 5169);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 115, 4198, 5169);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 115, 4198, 5169);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 115, 4198, 5169);
            if (isNaN) {
                return Double.NaN;
            }
            if (isInfinite()) {
                return Double.POSITIVE_INFINITY;
            }
            if ((FastMath.abs(real)) < (FastMath.abs(imaginary))) {
                if ((imaginary) == 0.0) {
                    return FastMath.abs(real);
                }
                double q = CallChecker.varInit(((double) ((this.real) / (this.imaginary))), "q", 126, 4838, 4865);
                return (FastMath.abs(imaginary)) * (FastMath.sqrt((1 + (q * q))));
            }else {
                if ((real) == 0.0) {
                    return FastMath.abs(imaginary);
                }
                double q = CallChecker.varInit(((double) ((this.imaginary) / (this.real))), "q", 132, 5060, 5087);
                return (FastMath.abs(real)) * (FastMath.sqrt((1 + (q * q))));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context987.methodEnd();
        }
    }

    public Complex add(Complex addend) throws NullArgumentException {
        MethodContext _bcornu_methode_context988 = new MethodContext(Complex.class, 156, 5176, 6198);
        try {
            CallChecker.varInit(this, "this", 156, 5176, 6198);
            CallChecker.varInit(addend, "addend", 156, 5176, 6198);
            CallChecker.varInit(this.isInfinite, "isInfinite", 156, 5176, 6198);
            CallChecker.varInit(this.isNaN, "isNaN", 156, 5176, 6198);
            CallChecker.varInit(this.real, "real", 156, 5176, 6198);
            CallChecker.varInit(this.imaginary, "imaginary", 156, 5176, 6198);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 156, 5176, 6198);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 156, 5176, 6198);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 156, 5176, 6198);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 156, 5176, 6198);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 156, 5176, 6198);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 156, 5176, 6198);
            MathUtils.checkNotNull(addend);
            if (CallChecker.beforeDeref(addend, Complex.class, 158, 6024, 6029)) {
                addend = CallChecker.beforeCalled(addend, Complex.class, 158, 6024, 6029);
                if ((isNaN) || (CallChecker.isCalled(addend, Complex.class, 158, 6024, 6029).isNaN)) {
                    return Complex.NaN;
                }
            }else
                throw new AbnormalExecutionError();
            
            addend = CallChecker.beforeCalled(addend, Complex.class, 162, 6111, 6116);
            addend = CallChecker.beforeCalled(addend, Complex.class, 163, 6170, 6175);
            return createComplex(((real) + (CallChecker.isCalled(addend, Complex.class, 162, 6111, 6116).getReal())), ((imaginary) + (CallChecker.isCalled(addend, Complex.class, 163, 6170, 6175).getImaginary())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context988.methodEnd();
        }
    }

    public Complex add(double addend) {
        MethodContext _bcornu_methode_context989 = new MethodContext(Complex.class, 174, 6205, 6662);
        try {
            CallChecker.varInit(this, "this", 174, 6205, 6662);
            CallChecker.varInit(addend, "addend", 174, 6205, 6662);
            CallChecker.varInit(this.isInfinite, "isInfinite", 174, 6205, 6662);
            CallChecker.varInit(this.isNaN, "isNaN", 174, 6205, 6662);
            CallChecker.varInit(this.real, "real", 174, 6205, 6662);
            CallChecker.varInit(this.imaginary, "imaginary", 174, 6205, 6662);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 174, 6205, 6662);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 174, 6205, 6662);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 174, 6205, 6662);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 174, 6205, 6662);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 174, 6205, 6662);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 174, 6205, 6662);
            if ((isNaN) || (Double.isNaN(addend))) {
                return Complex.NaN;
            }
            return createComplex(((real) + addend), imaginary);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context989.methodEnd();
        }
    }

    public Complex conjugate() {
        MethodContext _bcornu_methode_context990 = new MethodContext(Complex.class, 196, 6670, 7405);
        try {
            CallChecker.varInit(this, "this", 196, 6670, 7405);
            CallChecker.varInit(this.isInfinite, "isInfinite", 196, 6670, 7405);
            CallChecker.varInit(this.isNaN, "isNaN", 196, 6670, 7405);
            CallChecker.varInit(this.real, "real", 196, 6670, 7405);
            CallChecker.varInit(this.imaginary, "imaginary", 196, 6670, 7405);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 196, 6670, 7405);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 196, 6670, 7405);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 196, 6670, 7405);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 196, 6670, 7405);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 196, 6670, 7405);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 196, 6670, 7405);
            if (isNaN) {
                return Complex.NaN;
            }
            return createComplex(real, (-(imaginary)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context990.methodEnd();
        }
    }

    public Complex divide(Complex divisor) throws NullArgumentException {
        MethodContext _bcornu_methode_context991 = new MethodContext(Complex.class, 246, 7412, 10075);
        try {
            CallChecker.varInit(this, "this", 246, 7412, 10075);
            CallChecker.varInit(divisor, "divisor", 246, 7412, 10075);
            CallChecker.varInit(this.isInfinite, "isInfinite", 246, 7412, 10075);
            CallChecker.varInit(this.isNaN, "isNaN", 246, 7412, 10075);
            CallChecker.varInit(this.real, "real", 246, 7412, 10075);
            CallChecker.varInit(this.imaginary, "imaginary", 246, 7412, 10075);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 246, 7412, 10075);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 246, 7412, 10075);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 246, 7412, 10075);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 246, 7412, 10075);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 246, 7412, 10075);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 246, 7412, 10075);
            MathUtils.checkNotNull(divisor);
            if (CallChecker.beforeDeref(divisor, Complex.class, 249, 9290, 9296)) {
                divisor = CallChecker.beforeCalled(divisor, Complex.class, 249, 9290, 9296);
                if ((isNaN) || (CallChecker.isCalled(divisor, Complex.class, 249, 9290, 9296).isNaN)) {
                    return Complex.NaN;
                }
            }else
                throw new AbnormalExecutionError();
            
            divisor = CallChecker.beforeCalled(divisor, Complex.class, 253, 9367, 9373);
            final double c = CallChecker.varInit(((double) (CallChecker.isCalled(divisor, Complex.class, 253, 9367, 9373).getReal())), "c", 253, 9350, 9384);
            divisor = CallChecker.beforeCalled(divisor, Complex.class, 254, 9411, 9417);
            final double d = CallChecker.varInit(((double) (CallChecker.isCalled(divisor, Complex.class, 254, 9411, 9417).getImaginary())), "d", 254, 9394, 9433);
            if ((c == 0.0) && (d == 0.0)) {
                return Complex.NaN;
            }
            if (CallChecker.beforeDeref(divisor, Complex.class, 259, 9518, 9524)) {
                divisor = CallChecker.beforeCalled(divisor, Complex.class, 259, 9518, 9524);
                if ((CallChecker.isCalled(divisor, Complex.class, 259, 9518, 9524).isInfinite()) && (!(isInfinite()))) {
                    return Complex.ZERO;
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((FastMath.abs(c)) < (FastMath.abs(d))) {
                double q = CallChecker.varInit(((double) (c / d)), "q", 264, 9656, 9672);
                double denominator = CallChecker.varInit(((double) ((c * q) + d)), "denominator", 265, 9686, 9716);
                return createComplex(((((real) * q) + (imaginary)) / denominator), ((((imaginary) * q) - (real)) / denominator));
            }else {
                double q = CallChecker.varInit(((double) (d / c)), "q", 269, 9873, 9889);
                double denominator = CallChecker.varInit(((double) ((d * q) + c)), "denominator", 270, 9903, 9933);
                return createComplex(((((imaginary) * q) + (real)) / denominator), (((imaginary) - ((real) * q)) / denominator));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context991.methodEnd();
        }
    }

    public Complex divide(double divisor) {
        MethodContext _bcornu_methode_context992 = new MethodContext(Complex.class, 284, 10082, 10765);
        try {
            CallChecker.varInit(this, "this", 284, 10082, 10765);
            CallChecker.varInit(divisor, "divisor", 284, 10082, 10765);
            CallChecker.varInit(this.isInfinite, "isInfinite", 284, 10082, 10765);
            CallChecker.varInit(this.isNaN, "isNaN", 284, 10082, 10765);
            CallChecker.varInit(this.real, "real", 284, 10082, 10765);
            CallChecker.varInit(this.imaginary, "imaginary", 284, 10082, 10765);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 284, 10082, 10765);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 284, 10082, 10765);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 284, 10082, 10765);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 284, 10082, 10765);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 284, 10082, 10765);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 284, 10082, 10765);
            if ((isNaN) || (Double.isNaN(divisor))) {
                return Complex.NaN;
            }
            if (divisor == 0.0) {
                return Complex.NaN;
            }
            if (Double.isInfinite(divisor)) {
                if (!(isInfinite())) {
                    return Complex.ZERO;
                }else {
                    return Complex.NaN;
                }
            }
            return createComplex(((real) / divisor), ((imaginary) / divisor));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context992.methodEnd();
        }
    }

    public Complex reciprocal() {
        MethodContext _bcornu_methode_context993 = new MethodContext(Complex.class, 299, 10772, 11418);
        try {
            CallChecker.varInit(this, "this", 299, 10772, 11418);
            CallChecker.varInit(this.isInfinite, "isInfinite", 299, 10772, 11418);
            CallChecker.varInit(this.isNaN, "isNaN", 299, 10772, 11418);
            CallChecker.varInit(this.real, "real", 299, 10772, 11418);
            CallChecker.varInit(this.imaginary, "imaginary", 299, 10772, 11418);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 299, 10772, 11418);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 299, 10772, 11418);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 299, 10772, 11418);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 299, 10772, 11418);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 299, 10772, 11418);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 299, 10772, 11418);
            if (isNaN) {
                return Complex.NaN;
            }
            if (((real) == 0.0) && ((imaginary) == 0.0)) {
                return Complex.INF;
            }
            if (isInfinite) {
                return Complex.ZERO;
            }
            if ((FastMath.abs(real)) < (FastMath.abs(imaginary))) {
                double q = CallChecker.varInit(((double) ((this.real) / (this.imaginary))), "q", 313, 11099, 11126);
                double scale = CallChecker.varInit(((double) (1.0 / (((this.real) * q) + (this.imaginary)))), "scale", 314, 11140, 11182);
                return createComplex((scale * q), (-scale));
            }else {
                double q = CallChecker.varInit(((double) ((this.imaginary) / (this.real))), "q", 317, 11266, 11293);
                double scale = CallChecker.varInit(((double) (1.0 / (((this.imaginary) * q) + (this.real)))), "scale", 318, 11307, 11349);
                return createComplex(scale, ((-scale) * q));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context993.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context994 = new MethodContext(boolean.class, 339, 11425, 12538);
        try {
            CallChecker.varInit(this, "this", 339, 11425, 12538);
            CallChecker.varInit(other, "other", 339, 11425, 12538);
            CallChecker.varInit(this.isInfinite, "isInfinite", 339, 11425, 12538);
            CallChecker.varInit(this.isNaN, "isNaN", 339, 11425, 12538);
            CallChecker.varInit(this.real, "real", 339, 11425, 12538);
            CallChecker.varInit(this.imaginary, "imaginary", 339, 11425, 12538);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 339, 11425, 12538);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 339, 11425, 12538);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 339, 11425, 12538);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 339, 11425, 12538);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 339, 11425, 12538);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 339, 11425, 12538);
            if ((this) == other) {
                return true;
            }
            if (other instanceof Complex) {
                Complex c = CallChecker.varInit(((Complex) (other)), "c", 344, 12311, 12337);
                if (CallChecker.beforeDeref(c, Complex.class, 345, 12355, 12355)) {
                    c = CallChecker.beforeCalled(c, Complex.class, 345, 12355, 12355);
                    if (CallChecker.isCalled(c, Complex.class, 345, 12355, 12355).isNaN) {
                        return isNaN;
                    }else {
                        c = CallChecker.beforeCalled(c, Complex.class, 348, 12449, 12449);
                        c = CallChecker.beforeCalled(c, Complex.class, 348, 12474, 12474);
                        return ((real) == (CallChecker.isCalled(c, Complex.class, 348, 12449, 12449).real)) && ((imaginary) == (CallChecker.isCalled(c, Complex.class, 348, 12474, 12474).imaginary));
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context994.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context995 = new MethodContext(int.class, 362, 12545, 12956);
        try {
            CallChecker.varInit(this, "this", 362, 12545, 12956);
            CallChecker.varInit(this.isInfinite, "isInfinite", 362, 12545, 12956);
            CallChecker.varInit(this.isNaN, "isNaN", 362, 12545, 12956);
            CallChecker.varInit(this.real, "real", 362, 12545, 12956);
            CallChecker.varInit(this.imaginary, "imaginary", 362, 12545, 12956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 362, 12545, 12956);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 362, 12545, 12956);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 362, 12545, 12956);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 362, 12545, 12956);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 362, 12545, 12956);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 362, 12545, 12956);
            if (isNaN) {
                return 7;
            }
            return 37 * ((17 * (MathUtils.hash(imaginary))) + (MathUtils.hash(real)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context995.methodEnd();
        }
    }

    public double getImaginary() {
        MethodContext _bcornu_methode_context996 = new MethodContext(double.class, 375, 12963, 13116);
        try {
            CallChecker.varInit(this, "this", 375, 12963, 13116);
            CallChecker.varInit(this.isInfinite, "isInfinite", 375, 12963, 13116);
            CallChecker.varInit(this.isNaN, "isNaN", 375, 12963, 13116);
            CallChecker.varInit(this.real, "real", 375, 12963, 13116);
            CallChecker.varInit(this.imaginary, "imaginary", 375, 12963, 13116);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 375, 12963, 13116);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 375, 12963, 13116);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 375, 12963, 13116);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 375, 12963, 13116);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 375, 12963, 13116);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 375, 12963, 13116);
            return imaginary;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context996.methodEnd();
        }
    }

    public double getReal() {
        MethodContext _bcornu_methode_context997 = new MethodContext(double.class, 384, 13123, 13256);
        try {
            CallChecker.varInit(this, "this", 384, 13123, 13256);
            CallChecker.varInit(this.isInfinite, "isInfinite", 384, 13123, 13256);
            CallChecker.varInit(this.isNaN, "isNaN", 384, 13123, 13256);
            CallChecker.varInit(this.real, "real", 384, 13123, 13256);
            CallChecker.varInit(this.imaginary, "imaginary", 384, 13123, 13256);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 384, 13123, 13256);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 384, 13123, 13256);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 384, 13123, 13256);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 384, 13123, 13256);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 384, 13123, 13256);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 384, 13123, 13256);
            return real;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context997.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context998 = new MethodContext(boolean.class, 395, 13263, 13533);
        try {
            CallChecker.varInit(this, "this", 395, 13263, 13533);
            CallChecker.varInit(this.isInfinite, "isInfinite", 395, 13263, 13533);
            CallChecker.varInit(this.isNaN, "isNaN", 395, 13263, 13533);
            CallChecker.varInit(this.real, "real", 395, 13263, 13533);
            CallChecker.varInit(this.imaginary, "imaginary", 395, 13263, 13533);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 395, 13263, 13533);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 395, 13263, 13533);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 395, 13263, 13533);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 395, 13263, 13533);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 395, 13263, 13533);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 395, 13263, 13533);
            return isNaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context998.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context999 = new MethodContext(boolean.class, 408, 13540, 13976);
        try {
            CallChecker.varInit(this, "this", 408, 13540, 13976);
            CallChecker.varInit(this.isInfinite, "isInfinite", 408, 13540, 13976);
            CallChecker.varInit(this.isNaN, "isNaN", 408, 13540, 13976);
            CallChecker.varInit(this.real, "real", 408, 13540, 13976);
            CallChecker.varInit(this.imaginary, "imaginary", 408, 13540, 13976);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 408, 13540, 13976);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 408, 13540, 13976);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 408, 13540, 13976);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 408, 13540, 13976);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 408, 13540, 13976);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 408, 13540, 13976);
            return isInfinite;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context999.methodEnd();
        }
    }

    public Complex multiply(Complex factor) throws NullArgumentException {
        MethodContext _bcornu_methode_context1000 = new MethodContext(Complex.class, 436, 13983, 15642);
        try {
            CallChecker.varInit(this, "this", 436, 13983, 15642);
            CallChecker.varInit(factor, "factor", 436, 13983, 15642);
            CallChecker.varInit(this.isInfinite, "isInfinite", 436, 13983, 15642);
            CallChecker.varInit(this.isNaN, "isNaN", 436, 13983, 15642);
            CallChecker.varInit(this.real, "real", 436, 13983, 15642);
            CallChecker.varInit(this.imaginary, "imaginary", 436, 13983, 15642);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 436, 13983, 15642);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 436, 13983, 15642);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 436, 13983, 15642);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 436, 13983, 15642);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 436, 13983, 15642);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 436, 13983, 15642);
            MathUtils.checkNotNull(factor);
            if (CallChecker.beforeDeref(factor, Complex.class, 439, 15141, 15146)) {
                factor = CallChecker.beforeCalled(factor, Complex.class, 439, 15141, 15146);
                if ((isNaN) || (CallChecker.isCalled(factor, Complex.class, 439, 15141, 15146).isNaN)) {
                    return Complex.NaN;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(factor, Complex.class, 444, 15304, 15309)) {
                if (CallChecker.beforeDeref(factor, Complex.class, 445, 15350, 15355)) {
                    factor = CallChecker.beforeCalled(factor, Complex.class, 444, 15304, 15309);
                    factor = CallChecker.beforeCalled(factor, Complex.class, 445, 15350, 15355);
                    if ((((Double.isInfinite(real)) || (Double.isInfinite(imaginary))) || (Double.isInfinite(CallChecker.isCalled(factor, Complex.class, 444, 15304, 15309).real))) || (Double.isInfinite(CallChecker.isCalled(factor, Complex.class, 445, 15350, 15355).imaginary))) {
                        return Complex.INF;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            factor = CallChecker.beforeCalled(factor, Complex.class, 449, 15513, 15518);
            factor = CallChecker.beforeCalled(factor, Complex.class, 449, 15539, 15544);
            factor = CallChecker.beforeCalled(factor, Complex.class, 450, 15593, 15598);
            factor = CallChecker.beforeCalled(factor, Complex.class, 450, 15624, 15629);
            return createComplex((((real) * (CallChecker.isCalled(factor, Complex.class, 449, 15513, 15518).real)) - ((imaginary) * (CallChecker.isCalled(factor, Complex.class, 449, 15539, 15544).imaginary))), (((real) * (CallChecker.isCalled(factor, Complex.class, 450, 15593, 15598).imaginary)) + ((imaginary) * (CallChecker.isCalled(factor, Complex.class, 450, 15624, 15629).real))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1000.methodEnd();
        }
    }

    public Complex multiply(final int factor) {
        MethodContext _bcornu_methode_context1001 = new MethodContext(Complex.class, 461, 15649, 16227);
        try {
            CallChecker.varInit(this, "this", 461, 15649, 16227);
            CallChecker.varInit(factor, "factor", 461, 15649, 16227);
            CallChecker.varInit(this.isInfinite, "isInfinite", 461, 15649, 16227);
            CallChecker.varInit(this.isNaN, "isNaN", 461, 15649, 16227);
            CallChecker.varInit(this.real, "real", 461, 15649, 16227);
            CallChecker.varInit(this.imaginary, "imaginary", 461, 15649, 16227);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 461, 15649, 16227);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 461, 15649, 16227);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 461, 15649, 16227);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 461, 15649, 16227);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 461, 15649, 16227);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 461, 15649, 16227);
            if (isNaN) {
                return Complex.NaN;
            }
            if ((Double.isInfinite(real)) || (Double.isInfinite(imaginary))) {
                return Complex.INF;
            }
            return createComplex(((real) * factor), ((imaginary) * factor));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1001.methodEnd();
        }
    }

    public Complex multiply(double factor) {
        MethodContext _bcornu_methode_context1002 = new MethodContext(Complex.class, 480, 16234, 16943);
        try {
            CallChecker.varInit(this, "this", 480, 16234, 16943);
            CallChecker.varInit(factor, "factor", 480, 16234, 16943);
            CallChecker.varInit(this.isInfinite, "isInfinite", 480, 16234, 16943);
            CallChecker.varInit(this.isNaN, "isNaN", 480, 16234, 16943);
            CallChecker.varInit(this.real, "real", 480, 16234, 16943);
            CallChecker.varInit(this.imaginary, "imaginary", 480, 16234, 16943);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 480, 16234, 16943);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 480, 16234, 16943);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 480, 16234, 16943);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 480, 16234, 16943);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 480, 16234, 16943);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 480, 16234, 16943);
            if ((isNaN) || (Double.isNaN(factor))) {
                return Complex.NaN;
            }
            if (((Double.isInfinite(real)) || (Double.isInfinite(imaginary))) || (Double.isInfinite(factor))) {
                return Complex.INF;
            }
            return createComplex(((real) * factor), ((imaginary) * factor));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1002.methodEnd();
        }
    }

    public Complex negate() {
        MethodContext _bcornu_methode_context1003 = new MethodContext(Complex.class, 500, 16950, 17320);
        try {
            CallChecker.varInit(this, "this", 500, 16950, 17320);
            CallChecker.varInit(this.isInfinite, "isInfinite", 500, 16950, 17320);
            CallChecker.varInit(this.isNaN, "isNaN", 500, 16950, 17320);
            CallChecker.varInit(this.real, "real", 500, 16950, 17320);
            CallChecker.varInit(this.imaginary, "imaginary", 500, 16950, 17320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 500, 16950, 17320);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 500, 16950, 17320);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 500, 16950, 17320);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 500, 16950, 17320);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 500, 16950, 17320);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 500, 16950, 17320);
            if (isNaN) {
                return Complex.NaN;
            }
            return createComplex((-(real)), (-(imaginary)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1003.methodEnd();
        }
    }

    public Complex subtract(Complex subtrahend) throws NullArgumentException {
        MethodContext _bcornu_methode_context1004 = new MethodContext(Complex.class, 526, 17327, 18389);
        try {
            CallChecker.varInit(this, "this", 526, 17327, 18389);
            CallChecker.varInit(subtrahend, "subtrahend", 526, 17327, 18389);
            CallChecker.varInit(this.isInfinite, "isInfinite", 526, 17327, 18389);
            CallChecker.varInit(this.isNaN, "isNaN", 526, 17327, 18389);
            CallChecker.varInit(this.real, "real", 526, 17327, 18389);
            CallChecker.varInit(this.imaginary, "imaginary", 526, 17327, 18389);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 526, 17327, 18389);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 526, 17327, 18389);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 526, 17327, 18389);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 526, 17327, 18389);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 526, 17327, 18389);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 526, 17327, 18389);
            MathUtils.checkNotNull(subtrahend);
            if (CallChecker.beforeDeref(subtrahend, Complex.class, 529, 18203, 18212)) {
                subtrahend = CallChecker.beforeCalled(subtrahend, Complex.class, 529, 18203, 18212);
                if ((isNaN) || (CallChecker.isCalled(subtrahend, Complex.class, 529, 18203, 18212).isNaN)) {
                    return Complex.NaN;
                }
            }else
                throw new AbnormalExecutionError();
            
            subtrahend = CallChecker.beforeCalled(subtrahend, Complex.class, 533, 18294, 18303);
            subtrahend = CallChecker.beforeCalled(subtrahend, Complex.class, 534, 18357, 18366);
            return createComplex(((real) - (CallChecker.isCalled(subtrahend, Complex.class, 533, 18294, 18303).getReal())), ((imaginary) - (CallChecker.isCalled(subtrahend, Complex.class, 534, 18357, 18366).getImaginary())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1004.methodEnd();
        }
    }

    public Complex subtract(double subtrahend) {
        MethodContext _bcornu_methode_context1005 = new MethodContext(Complex.class, 545, 18396, 18844);
        try {
            CallChecker.varInit(this, "this", 545, 18396, 18844);
            CallChecker.varInit(subtrahend, "subtrahend", 545, 18396, 18844);
            CallChecker.varInit(this.isInfinite, "isInfinite", 545, 18396, 18844);
            CallChecker.varInit(this.isNaN, "isNaN", 545, 18396, 18844);
            CallChecker.varInit(this.real, "real", 545, 18396, 18844);
            CallChecker.varInit(this.imaginary, "imaginary", 545, 18396, 18844);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 545, 18396, 18844);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 545, 18396, 18844);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 545, 18396, 18844);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 545, 18396, 18844);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 545, 18396, 18844);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 545, 18396, 18844);
            if ((isNaN) || (Double.isNaN(subtrahend))) {
                return Complex.NaN;
            }
            return createComplex(((real) - subtrahend), imaginary);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1005.methodEnd();
        }
    }

    public Complex acos() {
        MethodContext _bcornu_methode_context1006 = new MethodContext(Complex.class, 568, 18851, 19537);
        try {
            CallChecker.varInit(this, "this", 568, 18851, 19537);
            CallChecker.varInit(this.isInfinite, "isInfinite", 568, 18851, 19537);
            CallChecker.varInit(this.isNaN, "isNaN", 568, 18851, 19537);
            CallChecker.varInit(this.real, "real", 568, 18851, 19537);
            CallChecker.varInit(this.imaginary, "imaginary", 568, 18851, 19537);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 568, 18851, 19537);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 568, 18851, 19537);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 568, 18851, 19537);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 568, 18851, 19537);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 568, 18851, 19537);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 568, 18851, 19537);
            if (isNaN) {
                return Complex.NaN;
            }
            final Complex npe_invocation_var100 = this.sqrt1z();
            if (CallChecker.beforeDeref(npe_invocation_var100, Complex.class, 573, 19478, 19490)) {
                final Complex npe_invocation_var101 = this.add(CallChecker.isCalled(npe_invocation_var100, Complex.class, 573, 19478, 19490).multiply(Complex.I));
                if (CallChecker.beforeDeref(npe_invocation_var101, Complex.class, 573, 19469, 19503)) {
                    if (CallChecker.beforeDeref(Complex.I, Complex.class, 573, 19520, 19520)) {
                        final Complex npe_invocation_var102 = CallChecker.isCalled(npe_invocation_var101, Complex.class, 573, 19469, 19503).log();
                        if (CallChecker.beforeDeref(npe_invocation_var102, Complex.class, 573, 19469, 19509)) {
                            return CallChecker.isCalled(npe_invocation_var102, Complex.class, 573, 19469, 19509).multiply(CallChecker.isCalled(Complex.I, Complex.class, 573, 19520, 19520).negate());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1006.methodEnd();
        }
    }

    public Complex asin() {
        MethodContext _bcornu_methode_context1007 = new MethodContext(Complex.class, 592, 19544, 20216);
        try {
            CallChecker.varInit(this, "this", 592, 19544, 20216);
            CallChecker.varInit(this.isInfinite, "isInfinite", 592, 19544, 20216);
            CallChecker.varInit(this.isNaN, "isNaN", 592, 19544, 20216);
            CallChecker.varInit(this.real, "real", 592, 19544, 20216);
            CallChecker.varInit(this.imaginary, "imaginary", 592, 19544, 20216);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 592, 19544, 20216);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 592, 19544, 20216);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 592, 19544, 20216);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 592, 19544, 20216);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 592, 19544, 20216);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 592, 19544, 20216);
            if (isNaN) {
                return Complex.NaN;
            }
            final Complex npe_invocation_var103 = sqrt1z();
            if (CallChecker.beforeDeref(npe_invocation_var103, Complex.class, 597, 20153, 20160)) {
                final Complex npe_invocation_var104 = CallChecker.isCalled(npe_invocation_var103, Complex.class, 597, 20153, 20160).add(this.multiply(Complex.I));
                if (CallChecker.beforeDeref(npe_invocation_var104, Complex.class, 597, 20153, 20182)) {
                    if (CallChecker.beforeDeref(Complex.I, Complex.class, 597, 20199, 20199)) {
                        final Complex npe_invocation_var105 = CallChecker.isCalled(npe_invocation_var104, Complex.class, 597, 20153, 20182).log();
                        if (CallChecker.beforeDeref(npe_invocation_var105, Complex.class, 597, 20153, 20188)) {
                            return CallChecker.isCalled(npe_invocation_var105, Complex.class, 597, 20153, 20188).multiply(CallChecker.isCalled(Complex.I, Complex.class, 597, 20199, 20199).negate());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1007.methodEnd();
        }
    }

    public Complex atan() {
        MethodContext _bcornu_methode_context1008 = new MethodContext(Complex.class, 616, 20223, 20937);
        try {
            CallChecker.varInit(this, "this", 616, 20223, 20937);
            CallChecker.varInit(this.isInfinite, "isInfinite", 616, 20223, 20937);
            CallChecker.varInit(this.isNaN, "isNaN", 616, 20223, 20937);
            CallChecker.varInit(this.real, "real", 616, 20223, 20937);
            CallChecker.varInit(this.imaginary, "imaginary", 616, 20223, 20937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 616, 20223, 20937);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 616, 20223, 20937);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 616, 20223, 20937);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 616, 20223, 20937);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 616, 20223, 20937);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 616, 20223, 20937);
            if (isNaN) {
                return Complex.NaN;
            }
            if (CallChecker.beforeDeref(Complex.I, Complex.class, 621, 20847, 20847)) {
                final Complex npe_invocation_var106 = this.add(Complex.I);
                if (CallChecker.beforeDeref(npe_invocation_var106, Complex.class, 621, 20828, 20838)) {
                    final Complex npe_invocation_var107 = CallChecker.isCalled(npe_invocation_var106, Complex.class, 621, 20828, 20838).divide(CallChecker.isCalled(Complex.I, Complex.class, 621, 20847, 20847).subtract(this));
                    if (CallChecker.beforeDeref(npe_invocation_var107, Complex.class, 621, 20828, 20863)) {
                        if (CallChecker.beforeDeref(Complex.I, Complex.class, 622, 20897, 20897)) {
                            final Complex npe_invocation_var108 = CallChecker.isCalled(npe_invocation_var107, Complex.class, 621, 20828, 20863).log();
                            if (CallChecker.beforeDeref(npe_invocation_var108, Complex.class, 621, 20828, 20869)) {
                                return CallChecker.isCalled(npe_invocation_var108, Complex.class, 621, 20828, 20869).multiply(CallChecker.isCalled(Complex.I, Complex.class, 622, 20897, 20897).divide(createComplex(2.0, 0.0)));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1008.methodEnd();
        }
    }

    public Complex cos() {
        MethodContext _bcornu_methode_context1009 = new MethodContext(Complex.class, 657, 20944, 22265);
        try {
            CallChecker.varInit(this, "this", 657, 20944, 22265);
            CallChecker.varInit(this.isInfinite, "isInfinite", 657, 20944, 22265);
            CallChecker.varInit(this.isNaN, "isNaN", 657, 20944, 22265);
            CallChecker.varInit(this.real, "real", 657, 20944, 22265);
            CallChecker.varInit(this.imaginary, "imaginary", 657, 20944, 22265);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 657, 20944, 22265);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 657, 20944, 22265);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 657, 20944, 22265);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 657, 20944, 22265);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 657, 20944, 22265);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 657, 20944, 22265);
            if (isNaN) {
                return Complex.NaN;
            }
            return createComplex(((FastMath.cos(real)) * (FastMath.cosh(imaginary))), ((-(FastMath.sin(real))) * (FastMath.sinh(imaginary))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1009.methodEnd();
        }
    }

    public Complex cosh() {
        MethodContext _bcornu_methode_context1010 = new MethodContext(Complex.class, 697, 22272, 23630);
        try {
            CallChecker.varInit(this, "this", 697, 22272, 23630);
            CallChecker.varInit(this.isInfinite, "isInfinite", 697, 22272, 23630);
            CallChecker.varInit(this.isNaN, "isNaN", 697, 22272, 23630);
            CallChecker.varInit(this.real, "real", 697, 22272, 23630);
            CallChecker.varInit(this.imaginary, "imaginary", 697, 22272, 23630);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 697, 22272, 23630);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 697, 22272, 23630);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 697, 22272, 23630);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 697, 22272, 23630);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 697, 22272, 23630);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 697, 22272, 23630);
            if (isNaN) {
                return Complex.NaN;
            }
            return createComplex(((FastMath.cosh(real)) * (FastMath.cos(imaginary))), ((FastMath.sinh(real)) * (FastMath.sin(imaginary))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1010.methodEnd();
        }
    }

    public Complex exp() {
        MethodContext _bcornu_methode_context1011 = new MethodContext(Complex.class, 738, 23637, 25012);
        try {
            CallChecker.varInit(this, "this", 738, 23637, 25012);
            CallChecker.varInit(this.isInfinite, "isInfinite", 738, 23637, 25012);
            CallChecker.varInit(this.isNaN, "isNaN", 738, 23637, 25012);
            CallChecker.varInit(this.real, "real", 738, 23637, 25012);
            CallChecker.varInit(this.imaginary, "imaginary", 738, 23637, 25012);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 738, 23637, 25012);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 738, 23637, 25012);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 738, 23637, 25012);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 738, 23637, 25012);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 738, 23637, 25012);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 738, 23637, 25012);
            if (isNaN) {
                return Complex.NaN;
            }
            double expReal = CallChecker.varInit(((double) (FastMath.exp(this.real))), "expReal", 743, 24841, 24876);
            return createComplex((expReal * (FastMath.cos(imaginary))), (expReal * (FastMath.sin(imaginary))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1011.methodEnd();
        }
    }

    public Complex log() {
        MethodContext _bcornu_methode_context1012 = new MethodContext(Complex.class, 783, 25019, 26563);
        try {
            CallChecker.varInit(this, "this", 783, 25019, 26563);
            CallChecker.varInit(this.isInfinite, "isInfinite", 783, 25019, 26563);
            CallChecker.varInit(this.isNaN, "isNaN", 783, 25019, 26563);
            CallChecker.varInit(this.real, "real", 783, 25019, 26563);
            CallChecker.varInit(this.imaginary, "imaginary", 783, 25019, 26563);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 783, 25019, 26563);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 783, 25019, 26563);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 783, 25019, 26563);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 783, 25019, 26563);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 783, 25019, 26563);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 783, 25019, 26563);
            if (isNaN) {
                return Complex.NaN;
            }
            return createComplex(FastMath.log(abs()), FastMath.atan2(imaginary, real));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1012.methodEnd();
        }
    }

    public Complex pow(Complex x) throws NullArgumentException {
        MethodContext _bcornu_methode_context1013 = new MethodContext(Complex.class, 812, 26570, 27454);
        try {
            CallChecker.varInit(this, "this", 812, 26570, 27454);
            CallChecker.varInit(x, "x", 812, 26570, 27454);
            CallChecker.varInit(this.isInfinite, "isInfinite", 812, 26570, 27454);
            CallChecker.varInit(this.isNaN, "isNaN", 812, 26570, 27454);
            CallChecker.varInit(this.real, "real", 812, 26570, 27454);
            CallChecker.varInit(this.imaginary, "imaginary", 812, 26570, 27454);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 812, 26570, 27454);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 812, 26570, 27454);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 812, 26570, 27454);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 812, 26570, 27454);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 812, 26570, 27454);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 812, 26570, 27454);
            MathUtils.checkNotNull(x);
            final Complex npe_invocation_var109 = this.log();
            if (CallChecker.beforeDeref(npe_invocation_var109, Complex.class, 815, 27420, 27429)) {
                final Complex npe_invocation_var110 = CallChecker.isCalled(npe_invocation_var109, Complex.class, 815, 27420, 27429).multiply(x);
                if (CallChecker.beforeDeref(npe_invocation_var110, Complex.class, 815, 27420, 27441)) {
                    return CallChecker.isCalled(npe_invocation_var110, Complex.class, 815, 27420, 27441).exp();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1013.methodEnd();
        }
    }

    public Complex pow(double x) {
        MethodContext _bcornu_methode_context1014 = new MethodContext(Complex.class, 825, 27461, 27791);
        try {
            CallChecker.varInit(this, "this", 825, 27461, 27791);
            CallChecker.varInit(x, "x", 825, 27461, 27791);
            CallChecker.varInit(this.isInfinite, "isInfinite", 825, 27461, 27791);
            CallChecker.varInit(this.isNaN, "isNaN", 825, 27461, 27791);
            CallChecker.varInit(this.real, "real", 825, 27461, 27791);
            CallChecker.varInit(this.imaginary, "imaginary", 825, 27461, 27791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 825, 27461, 27791);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 825, 27461, 27791);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 825, 27461, 27791);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 825, 27461, 27791);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 825, 27461, 27791);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 825, 27461, 27791);
            final Complex npe_invocation_var111 = this.log();
            if (CallChecker.beforeDeref(npe_invocation_var111, Complex.class, 826, 27757, 27766)) {
                final Complex npe_invocation_var112 = CallChecker.isCalled(npe_invocation_var111, Complex.class, 826, 27757, 27766).multiply(x);
                if (CallChecker.beforeDeref(npe_invocation_var112, Complex.class, 826, 27757, 27778)) {
                    return CallChecker.isCalled(npe_invocation_var112, Complex.class, 826, 27757, 27778).exp();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1014.methodEnd();
        }
    }

    public Complex sin() {
        MethodContext _bcornu_methode_context1015 = new MethodContext(Complex.class, 861, 27798, 29120);
        try {
            CallChecker.varInit(this, "this", 861, 27798, 29120);
            CallChecker.varInit(this.isInfinite, "isInfinite", 861, 27798, 29120);
            CallChecker.varInit(this.isNaN, "isNaN", 861, 27798, 29120);
            CallChecker.varInit(this.real, "real", 861, 27798, 29120);
            CallChecker.varInit(this.imaginary, "imaginary", 861, 27798, 29120);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 861, 27798, 29120);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 861, 27798, 29120);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 861, 27798, 29120);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 861, 27798, 29120);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 861, 27798, 29120);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 861, 27798, 29120);
            if (isNaN) {
                return Complex.NaN;
            }
            return createComplex(((FastMath.sin(real)) * (FastMath.cosh(imaginary))), ((FastMath.cos(real)) * (FastMath.sinh(imaginary))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1015.methodEnd();
        }
    }

    public Complex sinh() {
        MethodContext _bcornu_methode_context1016 = new MethodContext(Complex.class, 901, 29127, 30457);
        try {
            CallChecker.varInit(this, "this", 901, 29127, 30457);
            CallChecker.varInit(this.isInfinite, "isInfinite", 901, 29127, 30457);
            CallChecker.varInit(this.isNaN, "isNaN", 901, 29127, 30457);
            CallChecker.varInit(this.real, "real", 901, 29127, 30457);
            CallChecker.varInit(this.imaginary, "imaginary", 901, 29127, 30457);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 901, 29127, 30457);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 901, 29127, 30457);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 901, 29127, 30457);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 901, 29127, 30457);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 901, 29127, 30457);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 901, 29127, 30457);
            if (isNaN) {
                return Complex.NaN;
            }
            return createComplex(((FastMath.sinh(real)) * (FastMath.cos(imaginary))), ((FastMath.cosh(real)) * (FastMath.sin(imaginary))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1016.methodEnd();
        }
    }

    public Complex sqrt() {
        MethodContext _bcornu_methode_context1017 = new MethodContext(Complex.class, 944, 30464, 32352);
        try {
            CallChecker.varInit(this, "this", 944, 30464, 32352);
            CallChecker.varInit(this.isInfinite, "isInfinite", 944, 30464, 32352);
            CallChecker.varInit(this.isNaN, "isNaN", 944, 30464, 32352);
            CallChecker.varInit(this.real, "real", 944, 30464, 32352);
            CallChecker.varInit(this.imaginary, "imaginary", 944, 30464, 32352);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 944, 30464, 32352);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 944, 30464, 32352);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 944, 30464, 32352);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 944, 30464, 32352);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 944, 30464, 32352);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 944, 30464, 32352);
            if (isNaN) {
                return Complex.NaN;
            }
            if (((real) == 0.0) && ((imaginary) == 0.0)) {
                return createComplex(0.0, 0.0);
            }
            double t = CallChecker.varInit(((double) (FastMath.sqrt((((FastMath.abs(this.real)) + (abs())) / 2.0)))), "t", 953, 32030, 32090);
            if ((real) >= 0.0) {
                return createComplex(t, ((imaginary) / (2.0 * t)));
            }else {
                return createComplex(((FastMath.abs(imaginary)) / (2.0 * t)), ((FastMath.copySign(1.0, imaginary)) * t));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1017.methodEnd();
        }
    }

    public Complex sqrt1z() {
        MethodContext _bcornu_methode_context1018 = new MethodContext(Complex.class, 979, 32359, 33132);
        try {
            CallChecker.varInit(this, "this", 979, 32359, 33132);
            CallChecker.varInit(this.isInfinite, "isInfinite", 979, 32359, 33132);
            CallChecker.varInit(this.isNaN, "isNaN", 979, 32359, 33132);
            CallChecker.varInit(this.real, "real", 979, 32359, 33132);
            CallChecker.varInit(this.imaginary, "imaginary", 979, 32359, 33132);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 979, 32359, 33132);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 979, 32359, 33132);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 979, 32359, 33132);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 979, 32359, 33132);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 979, 32359, 33132);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 979, 32359, 33132);
            final Complex npe_invocation_var113 = createComplex(1.0, 0.0);
            if (CallChecker.beforeDeref(npe_invocation_var113, Complex.class, 980, 33066, 33088)) {
                final Complex npe_invocation_var114 = CallChecker.isCalled(npe_invocation_var113, Complex.class, 980, 33066, 33088).subtract(this.multiply(this));
                if (CallChecker.beforeDeref(npe_invocation_var114, Complex.class, 980, 33066, 33118)) {
                    return CallChecker.isCalled(npe_invocation_var114, Complex.class, 980, 33066, 33118).sqrt();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1018.methodEnd();
        }
    }

    public Complex tan() {
        MethodContext _bcornu_methode_context1019 = new MethodContext(Complex.class, 1015, 33139, 34845);
        try {
            CallChecker.varInit(this, "this", 1015, 33139, 34845);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1015, 33139, 34845);
            CallChecker.varInit(this.isNaN, "isNaN", 1015, 33139, 34845);
            CallChecker.varInit(this.real, "real", 1015, 33139, 34845);
            CallChecker.varInit(this.imaginary, "imaginary", 1015, 33139, 34845);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1015, 33139, 34845);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1015, 33139, 34845);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1015, 33139, 34845);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1015, 33139, 34845);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1015, 33139, 34845);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1015, 33139, 34845);
            if ((isNaN) || (Double.isInfinite(real))) {
                return Complex.NaN;
            }
            if ((imaginary) > 20.0) {
                return createComplex(0.0, 1.0);
            }
            if ((imaginary) < (-20.0)) {
                return createComplex(0.0, (-1.0));
            }
            double real2 = CallChecker.varInit(((double) (2.0 * (this.real))), "real2", 1026, 34585, 34610);
            double imaginary2 = CallChecker.varInit(((double) (2.0 * (this.imaginary))), "imaginary2", 1027, 34620, 34655);
            double d = CallChecker.varInit(((double) ((FastMath.cos(real2)) + (FastMath.cosh(imaginary2)))), "d", 1028, 34665, 34723);
            return createComplex(((FastMath.sin(real2)) / d), ((FastMath.sinh(imaginary2)) / d));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1019.methodEnd();
        }
    }

    public Complex tanh() {
        MethodContext _bcornu_methode_context1020 = new MethodContext(Complex.class, 1066, 34852, 36563);
        try {
            CallChecker.varInit(this, "this", 1066, 34852, 36563);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1066, 34852, 36563);
            CallChecker.varInit(this.isNaN, "isNaN", 1066, 34852, 36563);
            CallChecker.varInit(this.real, "real", 1066, 34852, 36563);
            CallChecker.varInit(this.imaginary, "imaginary", 1066, 34852, 36563);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1066, 34852, 36563);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1066, 34852, 36563);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1066, 34852, 36563);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1066, 34852, 36563);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1066, 34852, 36563);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1066, 34852, 36563);
            if ((isNaN) || (Double.isInfinite(imaginary))) {
                return Complex.NaN;
            }
            if ((real) > 20.0) {
                return createComplex(1.0, 0.0);
            }
            if ((real) < (-20.0)) {
                return createComplex((-1.0), 0.0);
            }
            double real2 = CallChecker.varInit(((double) (2.0 * (this.real))), "real2", 1076, 36303, 36328);
            double imaginary2 = CallChecker.varInit(((double) (2.0 * (this.imaginary))), "imaginary2", 1077, 36338, 36373);
            double d = CallChecker.varInit(((double) ((FastMath.cosh(real2)) + (FastMath.cos(imaginary2)))), "d", 1078, 36383, 36441);
            return createComplex(((FastMath.sinh(real2)) / d), ((FastMath.sin(imaginary2)) / d));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1020.methodEnd();
        }
    }

    public double getArgument() {
        MethodContext _bcornu_methode_context1021 = new MethodContext(double.class, 1103, 36572, 37490);
        try {
            CallChecker.varInit(this, "this", 1103, 36572, 37490);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1103, 36572, 37490);
            CallChecker.varInit(this.isNaN, "isNaN", 1103, 36572, 37490);
            CallChecker.varInit(this.real, "real", 1103, 36572, 37490);
            CallChecker.varInit(this.imaginary, "imaginary", 1103, 36572, 37490);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1103, 36572, 37490);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1103, 36572, 37490);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1103, 36572, 37490);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1103, 36572, 37490);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1103, 36572, 37490);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1103, 36572, 37490);
            return FastMath.atan2(getImaginary(), getReal());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1021.methodEnd();
        }
    }

    public List<Complex> nthRoot(int n) throws NotPositiveException {
        MethodContext _bcornu_methode_context1022 = new MethodContext(List.class, 1129, 37497, 39610);
        try {
            CallChecker.varInit(this, "this", 1129, 37497, 39610);
            CallChecker.varInit(n, "n", 1129, 37497, 39610);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1129, 37497, 39610);
            CallChecker.varInit(this.isNaN, "isNaN", 1129, 37497, 39610);
            CallChecker.varInit(this.real, "real", 1129, 37497, 39610);
            CallChecker.varInit(this.imaginary, "imaginary", 1129, 37497, 39610);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1129, 37497, 39610);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1129, 37497, 39610);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1129, 37497, 39610);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1129, 37497, 39610);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1129, 37497, 39610);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1129, 37497, 39610);
            if (n <= 0) {
                throw new NotPositiveException(LocalizedFormats.CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N, n);
            }
            final List<Complex> result = CallChecker.varInit(new ArrayList<Complex>(), "result", 1136, 38668, 38721);
            if (isNaN) {
                if (CallChecker.beforeDeref(result, List.class, 1139, 38757, 38762)) {
                    CallChecker.isCalled(result, List.class, 1139, 38757, 38762).add(Complex.NaN);
                }
                return result;
            }
            if (isInfinite()) {
                if (CallChecker.beforeDeref(result, List.class, 1143, 38851, 38856)) {
                    CallChecker.isCalled(result, List.class, 1143, 38851, 38856).add(Complex.INF);
                }
                return result;
            }
            final double nthRootOfAbs = CallChecker.varInit(((double) (FastMath.pow(abs(), (1.0 / n)))), "nthRootOfAbs", 1148, 38914, 39045);
            final double nthPhi = CallChecker.varInit(((double) ((getArgument()) / n)), "nthPhi", 1151, 39056, 39165);
            final double slice = CallChecker.varInit(((double) ((2 * (FastMath.PI)) / n)), "slice", 1152, 39175, 39215);
            double innerPart = CallChecker.varInit(((double) (nthPhi)), "innerPart", 1153, 39225, 39250);
            for (int k = 0; k < n; k++) {
                final double realPart = CallChecker.varInit(((double) (nthRootOfAbs * (FastMath.cos(innerPart)))), "realPart", 1156, 39303, 39392);
                final double imaginaryPart = CallChecker.varInit(((double) (nthRootOfAbs * (FastMath.sin(innerPart)))), "imaginaryPart", 1157, 39406, 39474);
                if (CallChecker.beforeDeref(result, List.class, 1158, 39488, 39493)) {
                    CallChecker.isCalled(result, List.class, 1158, 39488, 39493).add(createComplex(realPart, imaginaryPart));
                }
                innerPart += slice;
                CallChecker.varAssign(innerPart, "innerPart", 1159, 39552, 39570);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Complex>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1022.methodEnd();
        }
    }

    protected Complex createComplex(double realPart, double imaginaryPart) {
        MethodContext _bcornu_methode_context1023 = new MethodContext(Complex.class, 1174, 39617, 40052);
        try {
            CallChecker.varInit(this, "this", 1174, 39617, 40052);
            CallChecker.varInit(imaginaryPart, "imaginaryPart", 1174, 39617, 40052);
            CallChecker.varInit(realPart, "realPart", 1174, 39617, 40052);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1174, 39617, 40052);
            CallChecker.varInit(this.isNaN, "isNaN", 1174, 39617, 40052);
            CallChecker.varInit(this.real, "real", 1174, 39617, 40052);
            CallChecker.varInit(this.imaginary, "imaginary", 1174, 39617, 40052);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1174, 39617, 40052);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1174, 39617, 40052);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1174, 39617, 40052);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1174, 39617, 40052);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1174, 39617, 40052);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1174, 39617, 40052);
            return new Complex(realPart, imaginaryPart);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1023.methodEnd();
        }
    }

    public static Complex valueOf(double realPart, double imaginaryPart) {
        MethodContext _bcornu_methode_context1024 = new MethodContext(Complex.class, 1186, 40059, 40539);
        try {
            CallChecker.varInit(imaginaryPart, "imaginaryPart", 1186, 40059, 40539);
            CallChecker.varInit(realPart, "realPart", 1186, 40059, 40539);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1186, 40059, 40539);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1186, 40059, 40539);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1186, 40059, 40539);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1186, 40059, 40539);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1186, 40059, 40539);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1186, 40059, 40539);
            if ((Double.isNaN(realPart)) || (Double.isNaN(imaginaryPart))) {
                return Complex.NaN;
            }
            return new Complex(realPart, imaginaryPart);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1024.methodEnd();
        }
    }

    public static Complex valueOf(double realPart) {
        MethodContext _bcornu_methode_context1025 = new MethodContext(Complex.class, 1201, 40546, 40858);
        try {
            CallChecker.varInit(realPart, "realPart", 1201, 40546, 40858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1201, 40546, 40858);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1201, 40546, 40858);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1201, 40546, 40858);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1201, 40546, 40858);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1201, 40546, 40858);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1201, 40546, 40858);
            if (Double.isNaN(realPart)) {
                return Complex.NaN;
            }
            return new Complex(realPart);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1025.methodEnd();
        }
    }

    protected final Object readResolve() {
        MethodContext _bcornu_methode_context1026 = new MethodContext(Object.class, 1216, 40865, 41221);
        try {
            CallChecker.varInit(this, "this", 1216, 40865, 41221);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1216, 40865, 41221);
            CallChecker.varInit(this.isNaN, "isNaN", 1216, 40865, 41221);
            CallChecker.varInit(this.real, "real", 1216, 40865, 41221);
            CallChecker.varInit(this.imaginary, "imaginary", 1216, 40865, 41221);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1216, 40865, 41221);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1216, 40865, 41221);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1216, 40865, 41221);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1216, 40865, 41221);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1216, 40865, 41221);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1216, 40865, 41221);
            return createComplex(real, imaginary);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1026.methodEnd();
        }
    }

    public ComplexField getField() {
        MethodContext _bcornu_methode_context1027 = new MethodContext(ComplexField.class, 1221, 41228, 41333);
        try {
            CallChecker.varInit(this, "this", 1221, 41228, 41333);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1221, 41228, 41333);
            CallChecker.varInit(this.isNaN, "isNaN", 1221, 41228, 41333);
            CallChecker.varInit(this.real, "real", 1221, 41228, 41333);
            CallChecker.varInit(this.imaginary, "imaginary", 1221, 41228, 41333);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1221, 41228, 41333);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1221, 41228, 41333);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1221, 41228, 41333);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1221, 41228, 41333);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1221, 41228, 41333);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1221, 41228, 41333);
            return ComplexField.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((ComplexField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1027.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1028 = new MethodContext(String.class, 1227, 41340, 41462);
        try {
            CallChecker.varInit(this, "this", 1227, 41340, 41462);
            CallChecker.varInit(this.isInfinite, "isInfinite", 1227, 41340, 41462);
            CallChecker.varInit(this.isNaN, "isNaN", 1227, 41340, 41462);
            CallChecker.varInit(this.real, "real", 1227, 41340, 41462);
            CallChecker.varInit(this.imaginary, "imaginary", 1227, 41340, 41462);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Complex.serialVersionUID", 1227, 41340, 41462);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Complex.ZERO", 1227, 41340, 41462);
            CallChecker.varInit(ONE, "org.apache.commons.math3.complex.Complex.ONE", 1227, 41340, 41462);
            CallChecker.varInit(INF, "org.apache.commons.math3.complex.Complex.INF", 1227, 41340, 41462);
            CallChecker.varInit(NaN, "org.apache.commons.math3.complex.Complex.NaN", 1227, 41340, 41462);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Complex.I", 1227, 41340, 41462);
            return ((("(" + (real)) + ", ") + (imaginary)) + ")";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1028.methodEnd();
        }
    }
}

