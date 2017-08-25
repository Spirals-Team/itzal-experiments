package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

@Deprecated
public abstract class AbstractDifferentiableUnivariateSolver extends BaseAbstractUnivariateSolver<DifferentiableUnivariateFunction> implements DifferentiableUnivariateSolver {
    private UnivariateFunction functionDerivative;

    protected AbstractDifferentiableUnivariateSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context442 = new ConstructorContext(AbstractDifferentiableUnivariateSolver.class, 44, 1579, 1832);
        try {
        } finally {
            _bcornu_methode_context442.methodEnd();
        }
    }

    protected AbstractDifferentiableUnivariateSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context443 = new ConstructorContext(AbstractDifferentiableUnivariateSolver.class, 55, 1839, 2420);
        try {
        } finally {
            _bcornu_methode_context443.methodEnd();
        }
    }

    protected double computeDerivativeObjectiveValue(double point) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context1883 = new MethodContext(double.class, 68, 2427, 2925);
        try {
            CallChecker.varInit(this, "this", 68, 2427, 2925);
            CallChecker.varInit(point, "point", 68, 2427, 2925);
            CallChecker.varInit(this.functionDerivative, "functionDerivative", 68, 2427, 2925);
            incrementEvaluationCount();
            if (CallChecker.beforeDeref(functionDerivative, UnivariateFunction.class, 71, 2888, 2905)) {
                functionDerivative = CallChecker.beforeCalled(functionDerivative, UnivariateFunction.class, 71, 2888, 2905);
                return CallChecker.isCalled(functionDerivative, UnivariateFunction.class, 71, 2888, 2905).value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1883.methodEnd();
        }
    }

    @Override
    protected void setup(int maxEval, DifferentiableUnivariateFunction f, double min, double max, double startValue) {
        MethodContext _bcornu_methode_context1884 = new MethodContext(void.class, 78, 2932, 3227);
        try {
            CallChecker.varInit(this, "this", 78, 2932, 3227);
            CallChecker.varInit(startValue, "startValue", 78, 2932, 3227);
            CallChecker.varInit(max, "max", 78, 2932, 3227);
            CallChecker.varInit(min, "min", 78, 2932, 3227);
            CallChecker.varInit(f, "f", 78, 2932, 3227);
            CallChecker.varInit(maxEval, "maxEval", 78, 2932, 3227);
            CallChecker.varInit(this.functionDerivative, "functionDerivative", 78, 2932, 3227);
            super.setup(maxEval, f, min, max, startValue);
            if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction.class, 81, 3207, 3207)) {
                f = CallChecker.beforeCalled(f, DifferentiableUnivariateFunction.class, 81, 3207, 3207);
                functionDerivative = CallChecker.isCalled(f, DifferentiableUnivariateFunction.class, 81, 3207, 3207).derivative();
                CallChecker.varAssign(this.functionDerivative, "this.functionDerivative", 81, 3186, 3221);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1884.methodEnd();
        }
    }
}

