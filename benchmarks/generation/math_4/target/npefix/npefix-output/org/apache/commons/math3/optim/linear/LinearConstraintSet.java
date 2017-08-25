package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.math3.optim.OptimizationData;

public class LinearConstraintSet implements OptimizationData {
    private final Set<LinearConstraint> linearConstraints = new HashSet<LinearConstraint>();

    public LinearConstraintSet(LinearConstraint... constraints) {
        ConstructorContext _bcornu_methode_context661 = new ConstructorContext(LinearConstraintSet.class, 41, 1336, 1616);
        try {
            if (CallChecker.beforeDeref(constraints, null, 42, 1549, 1559)) {
                for (LinearConstraint c : constraints) {
                    if (CallChecker.beforeDeref(linearConstraints, Set.class, 43, 1576, 1592)) {
                        CallChecker.isCalled(linearConstraints, Set.class, 43, 1576, 1592).add(c);
                    }
                }
            }
        } finally {
            _bcornu_methode_context661.methodEnd();
        }
    }

    public LinearConstraintSet(Collection<LinearConstraint> constraints) {
        ConstructorContext _bcornu_methode_context662 = new ConstructorContext(LinearConstraintSet.class, 52, 1623, 1862);
        try {
            if (CallChecker.beforeDeref(linearConstraints, Set.class, 53, 1819, 1835)) {
                CallChecker.isCalled(linearConstraints, Set.class, 53, 1819, 1835).addAll(constraints);
            }
        } finally {
            _bcornu_methode_context662.methodEnd();
        }
    }

    public Collection<LinearConstraint> getConstraints() {
        MethodContext _bcornu_methode_context2935 = new MethodContext(Collection.class, 61, 1869, 2089);
        try {
            CallChecker.varInit(this, "this", 61, 1869, 2089);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 61, 1869, 2089);
            return Collections.unmodifiableSet(linearConstraints);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<LinearConstraint>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2935.methodEnd();
        }
    }
}

