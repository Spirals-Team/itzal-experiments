package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

public abstract class AbstractUnivariateDifferentiableSolver extends BaseAbstractUnivariateSolver<UnivariateDifferentiableFunction> implements UnivariateDifferentiableSolver {
    private UnivariateDifferentiableFunction function;

    protected AbstractUnivariateDifferentiableSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context559 = new ConstructorContext(AbstractUnivariateDifferentiableSolver.class, 43, 1502, 1755);
        try {
        } finally {
            _bcornu_methode_context559.methodEnd();
        }
    }

    protected AbstractUnivariateDifferentiableSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context560 = new ConstructorContext(AbstractUnivariateDifferentiableSolver.class, 54, 1762, 2343);
        try {
        } finally {
            _bcornu_methode_context560.methodEnd();
        }
    }

    protected DerivativeStructure computeObjectiveValueAndDerivative(double point) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2598 = new MethodContext(DerivativeStructure.class, 68, 2350, 2910);
        try {
            CallChecker.varInit(this, "this", 68, 2350, 2910);
            CallChecker.varInit(point, "point", 68, 2350, 2910);
            CallChecker.varInit(this.function, "function", 68, 2350, 2910);
            incrementEvaluationCount();
            if (CallChecker.beforeDeref(function, UnivariateDifferentiableFunction.class, 71, 2849, 2856)) {
                function = CallChecker.beforeCalled(function, UnivariateDifferentiableFunction.class, 71, 2849, 2856);
                return CallChecker.isCalled(function, UnivariateDifferentiableFunction.class, 71, 2849, 2856).value(new DerivativeStructure(1, 1, 0, point));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2598.methodEnd();
        }
    }

    @Override
    protected void setup(int maxEval, UnivariateDifferentiableFunction f, double min, double max, double startValue) {
        MethodContext _bcornu_methode_context2599 = new MethodContext(void.class, 78, 2917, 3189);
        try {
            CallChecker.varInit(this, "this", 78, 2917, 3189);
            CallChecker.varInit(startValue, "startValue", 78, 2917, 3189);
            CallChecker.varInit(max, "max", 78, 2917, 3189);
            CallChecker.varInit(min, "min", 78, 2917, 3189);
            CallChecker.varInit(f, "f", 78, 2917, 3189);
            CallChecker.varInit(maxEval, "maxEval", 78, 2917, 3189);
            CallChecker.varInit(this.function, "function", 78, 2917, 3189);
            super.setup(maxEval, f, min, max, startValue);
            function = f;
            CallChecker.varAssign(this.function, "this.function", 81, 3171, 3183);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2599.methodEnd();
        }
    }
}

