package org.apache.commons.math3.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;

public class PolynomialFitter extends CurveFitter<PolynomialFunction.Parametric> {
    public PolynomialFitter(MultivariateVectorOptimizer optimizer) {
        super(optimizer);
        ConstructorContext _bcornu_methode_context916 = new ConstructorContext(PolynomialFitter.class, 36, 1381, 1584);
        try {
        } finally {
            _bcornu_methode_context916.methodEnd();
        }
    }

    public double[] fit(int maxEval, double[] guess) {
        MethodContext _bcornu_methode_context4169 = new MethodContext(double[].class, 53, 1591, 2435);
        try {
            CallChecker.varInit(this, "this", 53, 1591, 2435);
            CallChecker.varInit(guess, "guess", 53, 1591, 2435);
            CallChecker.varInit(maxEval, "maxEval", 53, 1591, 2435);
            return fit(maxEval, new PolynomialFunction.Parametric(), guess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4169.methodEnd();
        }
    }

    public double[] fit(double[] guess) {
        MethodContext _bcornu_methode_context4170 = new MethodContext(double[].class, 67, 2442, 3054);
        try {
            CallChecker.varInit(this, "this", 67, 2442, 3054);
            CallChecker.varInit(guess, "guess", 67, 2442, 3054);
            return fit(new PolynomialFunction.Parametric(), guess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4170.methodEnd();
        }
    }
}

