package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.analysis.UnivariateFunction;

public abstract class AbstractUnivariateSolver extends BaseAbstractUnivariateSolver<UnivariateFunction> implements UnivariateSolver {
    protected AbstractUnivariateSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context1282 = new ConstructorContext(AbstractUnivariateSolver.class, 36, 1133, 1372);
        try {
        } finally {
            _bcornu_methode_context1282.methodEnd();
        }
    }

    protected AbstractUnivariateSolver(final double relativeAccuracy, final double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context1283 = new ConstructorContext(AbstractUnivariateSolver.class, 45, 1378, 1753);
        try {
        } finally {
            _bcornu_methode_context1283.methodEnd();
        }
    }

    protected AbstractUnivariateSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context1284 = new ConstructorContext(AbstractUnivariateSolver.class, 56, 1759, 2298);
        try {
        } finally {
            _bcornu_methode_context1284.methodEnd();
        }
    }
}

