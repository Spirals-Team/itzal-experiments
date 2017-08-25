package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public abstract class AbstractPolynomialSolver extends BaseAbstractUnivariateSolver<PolynomialFunction> implements PolynomialSolver {
    private PolynomialFunction polynomialFunction;

    protected AbstractPolynomialSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context18 = new ConstructorContext(AbstractPolynomialSolver.class, 39, 1218, 1457);
        try {
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    protected AbstractPolynomialSolver(final double relativeAccuracy, final double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context19 = new ConstructorContext(AbstractPolynomialSolver.class, 48, 1463, 1838);
        try {
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    protected AbstractPolynomialSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context20 = new ConstructorContext(AbstractPolynomialSolver.class, 59, 1844, 2383);
        try {
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    @Override
    protected void setup(int maxEval, PolynomialFunction f, double min, double max, double startValue) {
        MethodContext _bcornu_methode_context87 = new MethodContext(void.class, 69, 2390, 2662);
        try {
            CallChecker.varInit(this, "this", 69, 2390, 2662);
            CallChecker.varInit(startValue, "startValue", 69, 2390, 2662);
            CallChecker.varInit(max, "max", 69, 2390, 2662);
            CallChecker.varInit(min, "min", 69, 2390, 2662);
            CallChecker.varInit(f, "f", 69, 2390, 2662);
            CallChecker.varInit(maxEval, "maxEval", 69, 2390, 2662);
            CallChecker.varInit(this.polynomialFunction, "polynomialFunction", 69, 2390, 2662);
            super.setup(maxEval, f, min, max, startValue);
            polynomialFunction = f;
            CallChecker.varAssign(this.polynomialFunction, "this.polynomialFunction", 72, 2634, 2656);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    protected double[] getCoefficients() {
        MethodContext _bcornu_methode_context88 = new MethodContext(double[].class, 78, 2669, 2841);
        try {
            CallChecker.varInit(this, "this", 78, 2669, 2841);
            CallChecker.varInit(this.polynomialFunction, "polynomialFunction", 78, 2669, 2841);
            if (CallChecker.beforeDeref(polynomialFunction, PolynomialFunction.class, 79, 2799, 2816)) {
                polynomialFunction = CallChecker.beforeCalled(polynomialFunction, PolynomialFunction.class, 79, 2799, 2816);
                return CallChecker.isCalled(polynomialFunction, PolynomialFunction.class, 79, 2799, 2816).getCoefficients();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }
}

