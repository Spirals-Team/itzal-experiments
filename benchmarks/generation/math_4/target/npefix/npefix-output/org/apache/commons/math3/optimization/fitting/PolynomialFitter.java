package org.apache.commons.math3.optimization.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;

@Deprecated
public class PolynomialFitter extends CurveFitter<PolynomialFunction.Parametric> {
    @Deprecated
    private final int degree;

    @Deprecated
    public PolynomialFitter(int degree, final DifferentiableMultivariateVectorOptimizer optimizer) {
        super(optimizer);
        ConstructorContext _bcornu_methode_context913 = new ConstructorContext(PolynomialFitter.class, 51, 1505, 2122);
        try {
            this.degree = degree;
            CallChecker.varAssign(this.degree, "this.degree", 53, 2096, 2116);
        } finally {
            _bcornu_methode_context913.methodEnd();
        }
    }

    public PolynomialFitter(DifferentiableMultivariateVectorOptimizer optimizer) {
        super(optimizer);
        ConstructorContext _bcornu_methode_context914 = new ConstructorContext(PolynomialFitter.class, 62, 2129, 2455);
        try {
            degree = -1;
            CallChecker.varAssign(this.degree, "this.degree", 64, 2368, 2379);
        } finally {
            _bcornu_methode_context914.methodEnd();
        }
    }

    @Deprecated
    public double[] fit() {
        MethodContext _bcornu_methode_context4159 = new MethodContext(double[].class, 76, 2462, 2969);
        try {
            CallChecker.varInit(this, "this", 76, 2462, 2969);
            CallChecker.varInit(this.degree, "degree", 76, 2462, 2969);
            return fit(new PolynomialFunction.Parametric(), new double[(degree) + 1]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4159.methodEnd();
        }
    }

    public double[] fit(int maxEval, double[] guess) {
        MethodContext _bcornu_methode_context4160 = new MethodContext(double[].class, 94, 2976, 3838);
        try {
            CallChecker.varInit(this, "this", 94, 2976, 3838);
            CallChecker.varInit(guess, "guess", 94, 2976, 3838);
            CallChecker.varInit(maxEval, "maxEval", 94, 2976, 3838);
            CallChecker.varInit(this.degree, "degree", 94, 2976, 3838);
            return fit(maxEval, new PolynomialFunction.Parametric(), guess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4160.methodEnd();
        }
    }

    public double[] fit(double[] guess) {
        MethodContext _bcornu_methode_context4161 = new MethodContext(double[].class, 109, 3845, 4475);
        try {
            CallChecker.varInit(this, "this", 109, 3845, 4475);
            CallChecker.varInit(guess, "guess", 109, 3845, 4475);
            CallChecker.varInit(this.degree, "degree", 109, 3845, 4475);
            return fit(new PolynomialFunction.Parametric(), guess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4161.methodEnd();
        }
    }
}

