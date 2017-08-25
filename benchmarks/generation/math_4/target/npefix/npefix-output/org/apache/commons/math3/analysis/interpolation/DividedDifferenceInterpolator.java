package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionNewtonForm;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

public class DividedDifferenceInterpolator implements Serializable , UnivariateInterpolator {
    private static final long serialVersionUID = 107049519551235069L;

    public PolynomialFunctionNewtonForm interpolate(double[] x, double[] y) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5564 = new MethodContext(PolynomialFunctionNewtonForm.class, 55, 1967, 3572);
        try {
            CallChecker.varInit(this, "this", 55, 1967, 3572);
            CallChecker.varInit(y, "y", 55, 1967, 3572);
            CallChecker.varInit(x, "x", 55, 1967, 3572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.DividedDifferenceInterpolator.serialVersionUID", 55, 1967, 3572);
            PolynomialFunctionLagrangeForm.verifyInterpolationArray(x, y, true);
            x = CallChecker.beforeCalled(x, double[].class, 74, 3392, 3392);
            final double[] c = CallChecker.varInit(new double[(CallChecker.isCalled(x, double[].class, 74, 3392, 3392).length) - 1], "c", 74, 3362, 3403);
            if (CallChecker.beforeDeref(c, double[].class, 75, 3442, 3442)) {
                System.arraycopy(x, 0, c, 0, CallChecker.isCalled(c, double[].class, 75, 3442, 3442).length);
            }
            final double[] a = CallChecker.varInit(DividedDifferenceInterpolator.computeDividedDifference(x, y), "a", 77, 3462, 3511);
            return new PolynomialFunctionNewtonForm(a, c);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunctionNewtonForm) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5564.methodEnd();
        }
    }

    protected static double[] computeDividedDifference(final double[] x, final double[] y) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5565 = new MethodContext(double[].class, 99, 3579, 5076);
        try {
            CallChecker.varInit(y, "y", 99, 3579, 5076);
            CallChecker.varInit(x, "x", 99, 3579, 5076);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.DividedDifferenceInterpolator.serialVersionUID", 99, 3579, 5076);
            PolynomialFunctionLagrangeForm.verifyInterpolationArray(x, y, true);
            final double[] divdiff = CallChecker.varInit(CallChecker.isCalled(y, double[].class, 105, 4654, 4654).clone(), "divdiff", 105, 4629, 4663);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 107, 4706, 4706).length)), "n", 107, 4692, 4714);
            final double[] a = CallChecker.varInit(new double[n], "a", 108, 4724, 4757);
            if (CallChecker.beforeDeref(a, double[].class, 109, 4767, 4767)) {
                if (CallChecker.beforeDeref(divdiff, double[].class, 109, 4774, 4780)) {
                    CallChecker.isCalled(a, double[].class, 109, 4767, 4767)[0] = CallChecker.isCalled(divdiff, double[].class, 109, 4774, 4780)[0];
                    CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 109, 4767, 4767)[0], "CallChecker.isCalled(a, double[].class, 109, 4767, 4767)[0]", 109, 4767, 4784);
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < (n - i); j++) {
                    final double denominator = CallChecker.varInit(((double) ((CallChecker.isCalled(x, double[].class, 112, 4911, 4911)[(j + i)]) - (CallChecker.isCalled(x, double[].class, 112, 4920, 4920)[j]))), "denominator", 112, 4884, 4924);
                    if (CallChecker.beforeDeref(divdiff, double[].class, 113, 4942, 4948)) {
                        if (CallChecker.beforeDeref(divdiff, double[].class, 113, 4956, 4962)) {
                            if (CallChecker.beforeDeref(divdiff, double[].class, 113, 4971, 4977)) {
                                CallChecker.isCalled(divdiff, double[].class, 113, 4942, 4948)[j] = ((CallChecker.isCalled(divdiff, double[].class, 113, 4956, 4962)[(j + 1)]) - (CallChecker.isCalled(divdiff, double[].class, 113, 4971, 4977)[j])) / denominator;
                                CallChecker.varAssign(CallChecker.isCalled(divdiff, double[].class, 113, 4942, 4948)[j], "CallChecker.isCalled(divdiff, double[].class, 113, 4942, 4948)[j]", 113, 4942, 4996);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(a, double[].class, 115, 5024, 5024)) {
                    if (CallChecker.beforeDeref(divdiff, double[].class, 115, 5031, 5037)) {
                        CallChecker.isCalled(a, double[].class, 115, 5024, 5024)[i] = CallChecker.isCalled(divdiff, double[].class, 115, 5031, 5037)[0];
                        CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 115, 5024, 5024)[i], "CallChecker.isCalled(a, double[].class, 115, 5024, 5024)[i]", 115, 5024, 5041);
                    }
                }
            }
            return a;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5565.methodEnd();
        }
    }
}

