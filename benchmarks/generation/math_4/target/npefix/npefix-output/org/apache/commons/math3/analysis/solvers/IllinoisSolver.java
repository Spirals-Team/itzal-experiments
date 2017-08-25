package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import static org.apache.commons.math3.analysis.solvers.BaseSecantSolver.Method.ILLINOIS;
import static org.apache.commons.math3.analysis.solvers.BaseSecantSolver.Method.PEGASUS;

public class IllinoisSolver extends BaseSecantSolver {
    public IllinoisSolver() {
        super(BaseSecantSolver.DEFAULT_ABSOLUTE_ACCURACY, ILLINOIS);
        ConstructorContext _bcornu_methode_context40 = new ConstructorContext(IllinoisSolver.class, 47, 1967, 2116);
        try {
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    public IllinoisSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy, ILLINOIS);
        ConstructorContext _bcornu_methode_context41 = new ConstructorContext(IllinoisSolver.class, 56, 2123, 2332);
        try {
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public IllinoisSolver(final double relativeAccuracy, final double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, ILLINOIS);
        ConstructorContext _bcornu_methode_context42 = new ConstructorContext(IllinoisSolver.class, 66, 2339, 2673);
        try {
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public IllinoisSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy, PEGASUS);
        ConstructorContext _bcornu_methode_context43 = new ConstructorContext(IllinoisSolver.class, 78, 2680, 3164);
        try {
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }
}

