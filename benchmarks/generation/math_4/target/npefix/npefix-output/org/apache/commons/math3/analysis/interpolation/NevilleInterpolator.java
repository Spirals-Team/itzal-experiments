package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

public class NevilleInterpolator implements Serializable , UnivariateInterpolator {
    static final long serialVersionUID = 3003707660147873733L;

    public PolynomialFunctionLagrangeForm interpolate(double[] x, double[] y) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5403 = new MethodContext(PolynomialFunctionLagrangeForm.class, 55, 1828, 2561);
        try {
            CallChecker.varInit(this, "this", 55, 1828, 2561);
            CallChecker.varInit(y, "y", 55, 1828, 2561);
            CallChecker.varInit(x, "x", 55, 1828, 2561);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.NevilleInterpolator.serialVersionUID", 55, 1828, 2561);
            return new PolynomialFunctionLagrangeForm(x, y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunctionLagrangeForm) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5403.methodEnd();
        }
    }
}

