package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import static org.apache.commons.math3.analysis.solvers.BaseSecantSolver.Method.PEGASUS;

public class PegasusSolver extends BaseSecantSolver {
    public PegasusSolver() {
        super(BaseSecantSolver.DEFAULT_ABSOLUTE_ACCURACY, PEGASUS);
        ConstructorContext _bcornu_methode_context629 = new ConstructorContext(PegasusSolver.class, 49, 2119, 2266);
        try {
        } finally {
            _bcornu_methode_context629.methodEnd();
        }
    }

    public PegasusSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy, PEGASUS);
        ConstructorContext _bcornu_methode_context630 = new ConstructorContext(PegasusSolver.class, 58, 2273, 2480);
        try {
        } finally {
            _bcornu_methode_context630.methodEnd();
        }
    }

    public PegasusSolver(final double relativeAccuracy, final double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, PEGASUS);
        ConstructorContext _bcornu_methode_context631 = new ConstructorContext(PegasusSolver.class, 68, 2487, 2818);
        try {
        } finally {
            _bcornu_methode_context631.methodEnd();
        }
    }

    public PegasusSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy, PEGASUS);
        ConstructorContext _bcornu_methode_context632 = new ConstructorContext(PegasusSolver.class, 80, 2825, 3306);
        try {
        } finally {
            _bcornu_methode_context632.methodEnd();
        }
    }
}

