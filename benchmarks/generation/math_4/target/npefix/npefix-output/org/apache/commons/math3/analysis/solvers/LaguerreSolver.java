package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexUtils;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

public class LaguerreSolver extends AbstractPolynomialSolver {
    private class ComplexSolver {
        public boolean isRoot(double min, double max, Complex z) {
            MethodContext _bcornu_methode_context4803 = new MethodContext(boolean.class, 250, 9338, 10104);
            try {
                CallChecker.varInit(this, "this", 250, 9338, 10104);
                CallChecker.varInit(z, "z", 250, 9338, 10104);
                CallChecker.varInit(max, "max", 250, 9338, 10104);
                CallChecker.varInit(min, "min", 250, 9338, 10104);
                if (CallChecker.beforeDeref(z, Complex.class, 251, 9796, 9796)) {
                    z = CallChecker.beforeCalled(z, Complex.class, 251, 9796, 9796);
                    if (isSequence(min, CallChecker.isCalled(z, Complex.class, 251, 9796, 9796).getReal(), max)) {
                        double tolerance = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(z, Complex.class, 252, 9889, 9889)) {
                            z = CallChecker.beforeCalled(z, Complex.class, 252, 9889, 9889);
                            tolerance = FastMath.max(((getRelativeAccuracy()) * (CallChecker.isCalled(z, Complex.class, 252, 9889, 9889).abs())), getAbsoluteAccuracy());
                            CallChecker.varAssign(tolerance, "tolerance", 252, 9889, 9889);
                        }
                        if (CallChecker.beforeDeref(z, Complex.class, 253, 9959, 9959)) {
                            z = CallChecker.beforeCalled(z, Complex.class, 253, 9959, 9959);
                            z = CallChecker.beforeCalled(z, Complex.class, 254, 10016, 10016);
                            return ((FastMath.abs(CallChecker.isCalled(z, Complex.class, 253, 9959, 9959).getImaginary())) <= tolerance) || ((CallChecker.isCalled(z, Complex.class, 254, 10016, 10016).abs()) <= (getFunctionValueAccuracy()));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4803.methodEnd();
            }
        }

        public Complex[] solveAll(Complex[] coefficients, Complex initial) throws NoDataException, NullArgumentException, TooManyEvaluationsException {
            MethodContext _bcornu_methode_context4804 = new MethodContext(Complex[].class, 272, 10115, 12153);
            try {
                CallChecker.varInit(this, "this", 272, 10115, 12153);
                CallChecker.varInit(initial, "initial", 272, 10115, 12153);
                CallChecker.varInit(coefficients, "coefficients", 272, 10115, 12153);
                if (coefficients == null) {
                    throw new NullArgumentException();
                }
                final int n = CallChecker.varInit(((int) ((coefficients.length) - 1)), "n", 279, 11073, 11110);
                if (n == 0) {
                    throw new NoDataException(LocalizedFormats.POLYNOMIAL);
                }
                final Complex[] c = CallChecker.varInit(new Complex[n + 1], "c", 284, 11236, 11327);
                for (int i = 0; i <= n; i++) {
                    if (CallChecker.beforeDeref(c, Complex[].class, 286, 11388, 11388)) {
                        CallChecker.isCalled(c, Complex[].class, 286, 11388, 11388)[i] = coefficients[i];
                        CallChecker.varAssign(CallChecker.isCalled(c, Complex[].class, 286, 11388, 11388)[i], "CallChecker.isCalled(c, Complex[].class, 286, 11388, 11388)[i]", 286, 11388, 11410);
                    }
                }
                final Complex[] root = CallChecker.varInit(new Complex[n], "root", 290, 11439, 11528);
                for (int i = 0; i < n; i++) {
                    final Complex[] subarray = CallChecker.varInit(new Complex[(n - i) + 1], "subarray", 292, 11588, 11637);
                    if (CallChecker.beforeDeref(subarray, Complex[].class, 293, 11691, 11698)) {
                        System.arraycopy(c, 0, subarray, 0, CallChecker.isCalled(subarray, Complex[].class, 293, 11691, 11698).length);
                    }
                    if (CallChecker.beforeDeref(root, Complex[].class, 294, 11725, 11728)) {
                        CallChecker.isCalled(root, Complex[].class, 294, 11725, 11728)[i] = solve(subarray, initial);
                        CallChecker.varAssign(CallChecker.isCalled(root, Complex[].class, 294, 11725, 11728)[i], "CallChecker.isCalled(root, Complex[].class, 294, 11725, 11728)[i]", 294, 11725, 11759);
                    }
                    Complex newc = CallChecker.init(Complex.class);
                    if (CallChecker.beforeDeref(c, Complex[].class, 296, 11858, 11858)) {
                        newc = CallChecker.isCalled(c, Complex[].class, 296, 11858, 11858)[(n - i)];
                        CallChecker.varAssign(newc, "newc", 296, 11858, 11858);
                    }
                    Complex oldc = CallChecker.varInit(null, "oldc", 297, 11884, 11903);
                    for (int j = (n - i) - 1; j >= 0; j--) {
                        if (CallChecker.beforeDeref(c, Complex[].class, 299, 11987, 11987)) {
                            oldc = CallChecker.isCalled(c, Complex[].class, 299, 11987, 11987)[j];
                            CallChecker.varAssign(oldc, "oldc", 299, 11980, 11991);
                        }
                        if (CallChecker.beforeDeref(c, Complex[].class, 300, 12013, 12013)) {
                            CallChecker.isCalled(c, Complex[].class, 300, 12013, 12013)[j] = newc;
                            CallChecker.varAssign(CallChecker.isCalled(c, Complex[].class, 300, 12013, 12013)[j], "CallChecker.isCalled(c, Complex[].class, 300, 12013, 12013)[j]", 300, 12013, 12024);
                        }
                        if (CallChecker.beforeDeref(root, Complex[].class, 301, 12076, 12079)) {
                            if (CallChecker.beforeDeref(newc, Complex.class, 301, 12062, 12065)) {
                                if (CallChecker.beforeDeref(oldc, Complex.class, 301, 12053, 12056)) {
                                    newc = CallChecker.beforeCalled(newc, Complex.class, 301, 12062, 12065);
                                    oldc = CallChecker.beforeCalled(oldc, Complex.class, 301, 12053, 12056);
                                    newc = CallChecker.isCalled(oldc, Complex.class, 301, 12053, 12056).add(CallChecker.isCalled(newc, Complex.class, 301, 12062, 12065).multiply(CallChecker.isCalled(root, Complex[].class, 301, 12076, 12079)[i]));
                                    CallChecker.varAssign(newc, "newc", 301, 12046, 12085);
                                }
                            }
                        }
                    }
                }
                return root;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4804.methodEnd();
            }
        }

        public Complex solve(Complex[] coefficients, Complex initial) throws NoDataException, NullArgumentException, TooManyEvaluationsException {
            MethodContext _bcornu_methode_context4805 = new MethodContext(Complex.class, 321, 12164, 15971);
            try {
                CallChecker.varInit(this, "this", 321, 12164, 15971);
                CallChecker.varInit(initial, "initial", 321, 12164, 15971);
                CallChecker.varInit(coefficients, "coefficients", 321, 12164, 15971);
                if (coefficients == null) {
                    throw new NullArgumentException();
                }
                final int n = CallChecker.varInit(((int) ((coefficients.length) - 1)), "n", 329, 13115, 13152);
                if (n == 0) {
                    throw new NoDataException(LocalizedFormats.POLYNOMIAL);
                }
                final double absoluteAccuracy = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "absoluteAccuracy", 334, 13279, 13332);
                final double relativeAccuracy = CallChecker.varInit(((double) (getRelativeAccuracy())), "relativeAccuracy", 335, 13346, 13399);
                final double functionValueAccuracy = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "functionValueAccuracy", 336, 13413, 13476);
                final Complex nC = CallChecker.varInit(new Complex(n, 0), "nC", 338, 13491, 13528);
                final Complex n1C = CallChecker.varInit(new Complex((n - 1), 0), "n1C", 339, 13542, 13583);
                Complex z = CallChecker.varInit(initial, "z", 341, 13598, 13617);
                Complex oldz = CallChecker.varInit(new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY), "oldz", 342, 13631, 13748);
                while (true) {
                    Complex pv = CallChecker.varInit(coefficients[n], "pv", 347, 13935, 13963);
                    Complex dv = CallChecker.varInit(Complex.ZERO, "dv", 348, 13981, 14006);
                    Complex d2v = CallChecker.varInit(Complex.ZERO, "d2v", 349, 14024, 14050);
                    for (int j = n - 1; j >= 0; j--) {
                        if (CallChecker.beforeDeref(z, Complex.class, 351, 14134, 14134)) {
                            if (CallChecker.beforeDeref(dv, Complex.class, 351, 14127, 14128)) {
                                z = CallChecker.beforeCalled(z, Complex.class, 351, 14134, 14134);
                                dv = CallChecker.beforeCalled(dv, Complex.class, 351, 14127, 14128);
                                d2v = CallChecker.isCalled(dv, Complex.class, 351, 14127, 14128).add(CallChecker.isCalled(z, Complex.class, 351, 14134, 14134).multiply(d2v));
                                CallChecker.varAssign(d2v, "d2v", 351, 14121, 14150);
                            }
                        }
                        if (CallChecker.beforeDeref(z, Complex.class, 352, 14184, 14184)) {
                            if (CallChecker.beforeDeref(pv, Complex.class, 352, 14177, 14178)) {
                                z = CallChecker.beforeCalled(z, Complex.class, 352, 14184, 14184);
                                pv = CallChecker.beforeCalled(pv, Complex.class, 352, 14177, 14178);
                                dv = CallChecker.isCalled(pv, Complex.class, 352, 14177, 14178).add(CallChecker.isCalled(z, Complex.class, 352, 14184, 14184).multiply(dv));
                                CallChecker.varAssign(dv, "dv", 352, 14172, 14199);
                            }
                        }
                        if (CallChecker.beforeDeref(z, Complex.class, 353, 14246, 14246)) {
                            coefficients = CallChecker.beforeCalled(coefficients, Complex[].class, 353, 14226, 14237);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(coefficients, Complex[].class, 353, 14226, 14237)[j], Complex.class, 353, 14226, 14240)) {
                                z = CallChecker.beforeCalled(z, Complex.class, 353, 14246, 14246);
                                coefficients[j] = CallChecker.beforeCalled(coefficients[j], Complex.class, 353, 14226, 14240);
                                pv = CallChecker.isCalled(coefficients[j], Complex.class, 353, 14226, 14240).add(CallChecker.isCalled(z, Complex.class, 353, 14246, 14246).multiply(pv));
                                CallChecker.varAssign(pv, "pv", 353, 14221, 14261);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(d2v, Complex.class, 355, 14303, 14305)) {
                        d2v = CallChecker.beforeCalled(d2v, Complex.class, 355, 14303, 14305);
                        d2v = CallChecker.isCalled(d2v, Complex.class, 355, 14303, 14305).multiply(new Complex(2.0, 0.0));
                        CallChecker.varAssign(d2v, "d2v", 355, 14297, 14338);
                    }
                    z = CallChecker.beforeCalled(z, Complex.class, 358, 14456, 14456);
                    final double tolerance = CallChecker.varInit(((double) (FastMath.max((relativeAccuracy * (CallChecker.isCalled(z, Complex.class, 358, 14456, 14456).abs())), absoluteAccuracy))), "tolerance", 358, 14357, 14536);
                    if (CallChecker.beforeDeref(z, Complex.class, 360, 14559, 14559)) {
                        z = CallChecker.beforeCalled(z, Complex.class, 360, 14559, 14559);
                        final Complex npe_invocation_var959 = CallChecker.isCalled(z, Complex.class, 360, 14559, 14559).subtract(oldz);
                        if (CallChecker.beforeDeref(npe_invocation_var959, Complex.class, 360, 14558, 14575)) {
                            if ((CallChecker.isCalled(npe_invocation_var959, Complex.class, 360, 14558, 14575).abs()) <= tolerance) {
                                return z;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(pv, Complex.class, 363, 14667, 14668)) {
                        pv = CallChecker.beforeCalled(pv, Complex.class, 363, 14667, 14668);
                        if ((CallChecker.isCalled(pv, Complex.class, 363, 14667, 14668).abs()) <= functionValueAccuracy) {
                            return z;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    dv = CallChecker.beforeCalled(dv, Complex.class, 368, 14852, 14853);
                    final Complex G = CallChecker.varInit(CallChecker.isCalled(dv, Complex.class, 368, 14852, 14853).divide(pv), "G", 368, 14769, 14865);
                    final Complex G2 = CallChecker.varInit(CallChecker.isCalled(G, Complex.class, 369, 14902, 14902).multiply(G), "G2", 369, 14883, 14915);
                    d2v = CallChecker.beforeCalled(d2v, Complex.class, 370, 14963, 14965);
                    final Complex H = CallChecker.varInit(CallChecker.isCalled(G2, Complex.class, 370, 14951, 14952).subtract(CallChecker.isCalled(d2v, Complex.class, 370, 14963, 14965).divide(pv)), "H", 370, 14933, 14978);
                    final Complex delta = CallChecker.varInit(CallChecker.isCalled(n1C, Complex.class, 371, 15018, 15020).multiply(CallChecker.isCalled(CallChecker.isCalled(nC, Complex.class, 371, 15032, 15033).multiply(H), Complex.class, 371, 15031, 15046).subtract(G2)), "delta", 371, 14996, 15061);
                    final Complex deltaSqrt = CallChecker.varInit(CallChecker.isCalled(delta, Complex.class, 373, 15166, 15170).sqrt(), "deltaSqrt", 373, 15079, 15178);
                    final Complex dplus = CallChecker.varInit(CallChecker.isCalled(G, Complex.class, 374, 15218, 15218).add(deltaSqrt), "dplus", 374, 15196, 15234);
                    final Complex dminus = CallChecker.varInit(CallChecker.isCalled(G, Complex.class, 375, 15275, 15275).subtract(deltaSqrt), "dminus", 375, 15252, 15296);
                    Complex denominator = CallChecker.init(Complex.class);
                    if (CallChecker.beforeDeref(dplus, Complex.class, 376, 15342, 15346)) {
                        if (CallChecker.beforeDeref(dminus, Complex.class, 376, 15356, 15361)) {
                            if ((CallChecker.isCalled(dplus, Complex.class, 376, 15342, 15346).abs()) > (CallChecker.isCalled(dminus, Complex.class, 376, 15356, 15361).abs())) {
                                denominator = dplus;
                                CallChecker.varAssign(denominator, "denominator", 376, 15342, 15384);
                            }else {
                                denominator = dminus;
                                CallChecker.varAssign(denominator, "denominator", 376, 15342, 15384);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(denominator, Complex.class, 379, 15516, 15526)) {
                        denominator = CallChecker.beforeCalled(denominator, Complex.class, 379, 15516, 15526);
                        if (CallChecker.isCalled(denominator, Complex.class, 379, 15516, 15526).equals(new Complex(0.0, 0.0))) {
                            if (CallChecker.beforeDeref(z, Complex.class, 380, 15585, 15585)) {
                                z = CallChecker.beforeCalled(z, Complex.class, 380, 15585, 15585);
                                z = CallChecker.isCalled(z, Complex.class, 380, 15585, 15585).add(new Complex(absoluteAccuracy, absoluteAccuracy));
                                CallChecker.varAssign(z, "z", 380, 15581, 15639);
                            }
                            oldz = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
                            CallChecker.varAssign(oldz, "oldz", 381, 15661, 15770);
                        }else {
                            oldz = z;
                            CallChecker.varAssign(oldz, "oldz", 384, 15817, 15825);
                            if (CallChecker.beforeDeref(nC, Complex.class, 385, 15862, 15863)) {
                                if (CallChecker.beforeDeref(z, Complex.class, 385, 15851, 15851)) {
                                    z = CallChecker.beforeCalled(z, Complex.class, 385, 15851, 15851);
                                    z = CallChecker.isCalled(z, Complex.class, 385, 15851, 15851).subtract(CallChecker.isCalled(nC, Complex.class, 385, 15862, 15863).divide(denominator));
                                    CallChecker.varAssign(z, "z", 385, 15847, 15885);
                                }
                            }
                        }
                    }
                    incrementEvaluationCount();
                } 
            } catch (ForceReturn _bcornu_return_t) {
                return ((Complex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4805.methodEnd();
            }
        }
    }

    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    private final LaguerreSolver.ComplexSolver complexSolver = new LaguerreSolver.ComplexSolver();

    public LaguerreSolver() {
        this(LaguerreSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context1074 = new ConstructorContext(LaguerreSolver.class, 54, 2256, 2399);
        try {
        } finally {
            _bcornu_methode_context1074.methodEnd();
        }
    }

    public LaguerreSolver(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context1075 = new ConstructorContext(LaguerreSolver.class, 62, 2405, 2591);
        try {
        } finally {
            _bcornu_methode_context1075.methodEnd();
        }
    }

    public LaguerreSolver(double relativeAccuracy, double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context1076 = new ConstructorContext(LaguerreSolver.class, 71, 2597, 2902);
        try {
        } finally {
            _bcornu_methode_context1076.methodEnd();
        }
    }

    public LaguerreSolver(double relativeAccuracy, double absoluteAccuracy, double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context1077 = new ConstructorContext(LaguerreSolver.class, 82, 2908, 3353);
        try {
        } finally {
            _bcornu_methode_context1077.methodEnd();
        }
    }

    @Override
    public double doSolve() throws NoBracketingException, NumberIsTooLargeException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4806 = new MethodContext(double.class, 92, 3360, 4848);
        try {
            CallChecker.varInit(this, "this", 92, 3360, 4848);
            CallChecker.varInit(this.complexSolver, "complexSolver", 92, 3360, 4848);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.LaguerreSolver.DEFAULT_ABSOLUTE_ACCURACY", 92, 3360, 4848);
            final double min = CallChecker.varInit(((double) (getMin())), "min", 96, 3568, 3595);
            final double max = CallChecker.varInit(((double) (getMax())), "max", 97, 3605, 3632);
            final double initial = CallChecker.varInit(((double) (getStartValue())), "initial", 98, 3642, 3680);
            final double functionValueAccuracy = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "functionValueAccuracy", 99, 3690, 3753);
            verifySequence(min, initial, max);
            final double yInitial = CallChecker.varInit(((double) (computeObjectiveValue(initial))), "yInitial", 104, 3808, 3920);
            if ((FastMath.abs(yInitial)) <= functionValueAccuracy) {
                return initial;
            }
            final double yMin = CallChecker.varInit(((double) (computeObjectiveValue(min))), "yMin", 110, 4032, 4137);
            if ((FastMath.abs(yMin)) <= functionValueAccuracy) {
                return min;
            }
            if ((yInitial * yMin) < 0) {
                return laguerre(min, initial, yMin, yInitial);
            }
            final double yMax = CallChecker.varInit(((double) (computeObjectiveValue(max))), "yMax", 121, 4410, 4516);
            if ((FastMath.abs(yMax)) <= functionValueAccuracy) {
                return max;
            }
            if ((yInitial * yMax) < 0) {
                return laguerre(initial, max, yInitial, yMax);
            }
            throw new NoBracketingException(min, max, yMin, yMax);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4806.methodEnd();
        }
    }

    @Deprecated
    public double laguerre(double lo, double hi, double fLo, double fHi) {
        MethodContext _bcornu_methode_context4807 = new MethodContext(double.class, 155, 4855, 6690);
        try {
            CallChecker.varInit(this, "this", 155, 4855, 6690);
            CallChecker.varInit(fHi, "fHi", 155, 4855, 6690);
            CallChecker.varInit(fLo, "fLo", 155, 4855, 6690);
            CallChecker.varInit(hi, "hi", 155, 4855, 6690);
            CallChecker.varInit(lo, "lo", 155, 4855, 6690);
            CallChecker.varInit(this.complexSolver, "complexSolver", 155, 4855, 6690);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.LaguerreSolver.DEFAULT_ABSOLUTE_ACCURACY", 155, 4855, 6690);
            final Complex[] c = CallChecker.varInit(ComplexUtils.convertToComplex(getCoefficients()), "c", 157, 5982, 6050);
            final Complex initial = CallChecker.varInit(new Complex((0.5 * (lo + hi)), 0), "initial", 159, 6061, 6116);
            final Complex z = CallChecker.varInit(CallChecker.isCalled(complexSolver, LaguerreSolver.ComplexSolver.class, 160, 6144, 6156).solve(c, initial), "z", 160, 6126, 6175);
            if (CallChecker.beforeDeref(complexSolver, LaguerreSolver.ComplexSolver.class, 161, 6189, 6201)) {
                if (CallChecker.isCalled(complexSolver, LaguerreSolver.ComplexSolver.class, 161, 6189, 6201).isRoot(lo, hi, z)) {
                    if (CallChecker.beforeDeref(z, Complex.class, 162, 6243, 6243)) {
                        return CallChecker.isCalled(z, Complex.class, 162, 6243, 6243).getReal();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    double r = CallChecker.varInit(((double) (Double.NaN)), "r", 164, 6285, 6306);
                    Complex[] root = CallChecker.init(Complex[].class);
                    if (CallChecker.beforeDeref(complexSolver, LaguerreSolver.ComplexSolver.class, 166, 6403, 6415)) {
                        root = CallChecker.isCalled(complexSolver, LaguerreSolver.ComplexSolver.class, 166, 6403, 6415).solveAll(c, initial);
                        CallChecker.varAssign(root, "root", 166, 6403, 6415);
                    }
                    root = CallChecker.beforeCalled(root, Complex[].class, 167, 6471, 6474);
                    for (int i = 0; i < (CallChecker.isCalled(root, Complex[].class, 167, 6471, 6474).length); i++) {
                        if (CallChecker.beforeDeref(root, Complex[].class, 168, 6540, 6543)) {
                            if (CallChecker.beforeDeref(complexSolver, LaguerreSolver.ComplexSolver.class, 168, 6511, 6523)) {
                                root = CallChecker.beforeCalled(root, Complex[].class, 168, 6540, 6543);
                                if (CallChecker.isCalled(complexSolver, LaguerreSolver.ComplexSolver.class, 168, 6511, 6523).isRoot(lo, hi, CallChecker.isCalled(root, Complex[].class, 168, 6540, 6543)[i])) {
                                    if (CallChecker.beforeDeref(root, Complex[].class, 169, 6576, 6579)) {
                                        root = CallChecker.beforeCalled(root, Complex[].class, 169, 6576, 6579);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(root, Complex[].class, 169, 6576, 6579)[i], Complex.class, 169, 6576, 6582)) {
                                            root = CallChecker.beforeCalled(root, Complex[].class, 169, 6576, 6579);
                                            CallChecker.isCalled(root, Complex[].class, 169, 6576, 6579)[i] = CallChecker.beforeCalled(CallChecker.isCalled(root, Complex[].class, 169, 6576, 6579)[i], Complex.class, 169, 6576, 6582);
                                            r = CallChecker.isCalled(CallChecker.isCalled(root, Complex[].class, 169, 6576, 6579)[i], Complex.class, 169, 6576, 6582).getReal();
                                            CallChecker.varAssign(r, "r", 169, 6572, 6593);
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    return r;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4807.methodEnd();
        }
    }

    public Complex[] solveAllComplex(double[] coefficients, double initial) throws NoDataException, NullArgumentException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4808 = new MethodContext(Complex[].class, 193, 6697, 7969);
        try {
            CallChecker.varInit(this, "this", 193, 6697, 7969);
            CallChecker.varInit(initial, "initial", 193, 6697, 7969);
            CallChecker.varInit(coefficients, "coefficients", 193, 6697, 7969);
            CallChecker.varInit(this.complexSolver, "complexSolver", 193, 6697, 7969);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.LaguerreSolver.DEFAULT_ABSOLUTE_ACCURACY", 193, 6697, 7969);
            setup(Integer.MAX_VALUE, new PolynomialFunction(coefficients), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, initial);
            if (CallChecker.beforeDeref(complexSolver, LaguerreSolver.ComplexSolver.class, 203, 7832, 7844)) {
                return CallChecker.isCalled(complexSolver, LaguerreSolver.ComplexSolver.class, 203, 7832, 7844).solveAll(ComplexUtils.convertToComplex(coefficients), new Complex(initial, 0.0));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4808.methodEnd();
        }
    }

    public Complex solveComplex(double[] coefficients, double initial) throws NoDataException, NullArgumentException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4809 = new MethodContext(Complex.class, 223, 7976, 9229);
        try {
            CallChecker.varInit(this, "this", 223, 7976, 9229);
            CallChecker.varInit(initial, "initial", 223, 7976, 9229);
            CallChecker.varInit(coefficients, "coefficients", 223, 7976, 9229);
            CallChecker.varInit(this.complexSolver, "complexSolver", 223, 7976, 9229);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.LaguerreSolver.DEFAULT_ABSOLUTE_ACCURACY", 223, 7976, 9229);
            setup(Integer.MAX_VALUE, new PolynomialFunction(coefficients), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, initial);
            if (CallChecker.beforeDeref(complexSolver, LaguerreSolver.ComplexSolver.class, 233, 9098, 9110)) {
                return CallChecker.isCalled(complexSolver, LaguerreSolver.ComplexSolver.class, 233, 9098, 9110).solve(ComplexUtils.convertToComplex(coefficients), new Complex(initial, 0.0));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4809.methodEnd();
        }
    }
}

