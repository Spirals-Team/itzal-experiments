package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.Collections;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;

public abstract class LinearOptimizer extends MultivariateOptimizer {
    private LinearObjectiveFunction function;

    private Collection<LinearConstraint> linearConstraints;

    private boolean nonNegative;

    protected LinearOptimizer() {
        super(null);
        ConstructorContext _bcornu_methode_context891 = new ConstructorContext(LinearOptimizer.class, 51, 1653, 1807);
        try {
        } finally {
            _bcornu_methode_context891.methodEnd();
        }
    }

    protected boolean isRestrictedToNonNegative() {
        MethodContext _bcornu_methode_context3976 = new MethodContext(boolean.class, 58, 1814, 1994);
        try {
            CallChecker.varInit(this, "this", 58, 1814, 1994);
            CallChecker.varInit(this.iterations, "iterations", 58, 1814, 1994);
            CallChecker.varInit(this.evaluations, "evaluations", 58, 1814, 1994);
            CallChecker.varInit(this.nonNegative, "nonNegative", 58, 1814, 1994);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 58, 1814, 1994);
            CallChecker.varInit(this.function, "function", 58, 1814, 1994);
            return nonNegative;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3976.methodEnd();
        }
    }

    protected LinearObjectiveFunction getFunction() {
        MethodContext _bcornu_methode_context3977 = new MethodContext(LinearObjectiveFunction.class, 65, 2001, 2134);
        try {
            CallChecker.varInit(this, "this", 65, 2001, 2134);
            CallChecker.varInit(this.iterations, "iterations", 65, 2001, 2134);
            CallChecker.varInit(this.evaluations, "evaluations", 65, 2001, 2134);
            CallChecker.varInit(this.nonNegative, "nonNegative", 65, 2001, 2134);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 65, 2001, 2134);
            CallChecker.varInit(this.function, "function", 65, 2001, 2134);
            return function;
        } catch (ForceReturn _bcornu_return_t) {
            return ((LinearObjectiveFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3977.methodEnd();
        }
    }

    protected Collection<LinearConstraint> getConstraints() {
        MethodContext _bcornu_methode_context3978 = new MethodContext(Collection.class, 72, 2141, 2327);
        try {
            CallChecker.varInit(this, "this", 72, 2141, 2327);
            CallChecker.varInit(this.iterations, "iterations", 72, 2141, 2327);
            CallChecker.varInit(this.evaluations, "evaluations", 72, 2141, 2327);
            CallChecker.varInit(this.nonNegative, "nonNegative", 72, 2141, 2327);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 72, 2141, 2327);
            CallChecker.varInit(this.function, "function", 72, 2141, 2327);
            return Collections.unmodifiableCollection(linearConstraints);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<LinearConstraint>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3978.methodEnd();
        }
    }

    @Override
    public PointValuePair optimize(OptimizationData... optData) throws TooManyIterationsException {
        MethodContext _bcornu_methode_context3979 = new MethodContext(PointValuePair.class, 92, 2334, 3118);
        try {
            CallChecker.varInit(this, "this", 92, 2334, 3118);
            CallChecker.varInit(optData, "optData", 92, 2334, 3118);
            CallChecker.varInit(this.iterations, "iterations", 92, 2334, 3118);
            CallChecker.varInit(this.evaluations, "evaluations", 92, 2334, 3118);
            CallChecker.varInit(this.nonNegative, "nonNegative", 92, 2334, 3118);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 92, 2334, 3118);
            CallChecker.varInit(this.function, "function", 92, 2334, 3118);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3979.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context3980 = new MethodContext(void.class, 111, 3125, 4396);
        try {
            CallChecker.varInit(this, "this", 111, 3125, 4396);
            CallChecker.varInit(optData, "optData", 111, 3125, 4396);
            CallChecker.varInit(this.iterations, "iterations", 111, 3125, 4396);
            CallChecker.varInit(this.evaluations, "evaluations", 111, 3125, 4396);
            CallChecker.varInit(this.nonNegative, "nonNegative", 111, 3125, 4396);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 111, 3125, 4396);
            CallChecker.varInit(this.function, "function", 111, 3125, 4396);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 117, 3847, 3853)) {
                for (OptimizationData data : optData) {
                    if (data instanceof LinearObjectiveFunction) {
                        function = ((LinearObjectiveFunction) (data));
                        CallChecker.varAssign(this.function, "this.function", 119, 3933, 3974);
                        continue;
                    }
                    if (data instanceof LinearConstraintSet) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 123, 4130, 4133)) {
                            linearConstraints = CallChecker.isCalled(((LinearConstraintSet) (data)), LinearConstraintSet.class, 123, 4130, 4133).getConstraints();
                            CallChecker.varAssign(this.linearConstraints, "this.linearConstraints", 123, 4087, 4152);
                        }
                        continue;
                    }
                    if (data instanceof NonNegativeConstraint) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 127, 4307, 4310)) {
                            nonNegative = CallChecker.isCalled(((NonNegativeConstraint) (data)), NonNegativeConstraint.class, 127, 4307, 4310).isRestrictedToNonNegative();
                            CallChecker.varAssign(this.nonNegative, "this.nonNegative", 127, 4268, 4340);
                        }
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3980.methodEnd();
        }
    }
}

