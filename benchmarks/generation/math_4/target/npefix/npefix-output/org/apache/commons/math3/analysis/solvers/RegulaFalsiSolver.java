package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import static org.apache.commons.math3.analysis.solvers.BaseSecantSolver.Method.REGULA_FALSI;

public class RegulaFalsiSolver extends BaseSecantSolver {
    public RegulaFalsiSolver() {
        super(BaseSecantSolver.DEFAULT_ABSOLUTE_ACCURACY, REGULA_FALSI);
        ConstructorContext _bcornu_methode_context131 = new ConstructorContext(RegulaFalsiSolver.class, 59, 2793, 2949);
        try {
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }

    public RegulaFalsiSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy, REGULA_FALSI);
        ConstructorContext _bcornu_methode_context132 = new ConstructorContext(RegulaFalsiSolver.class, 68, 2956, 3172);
        try {
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    public RegulaFalsiSolver(final double relativeAccuracy, final double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, REGULA_FALSI);
        ConstructorContext _bcornu_methode_context133 = new ConstructorContext(RegulaFalsiSolver.class, 78, 3179, 3523);
        try {
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    public RegulaFalsiSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy, REGULA_FALSI);
        ConstructorContext _bcornu_methode_context134 = new ConstructorContext(RegulaFalsiSolver.class, 90, 3530, 4028);
        try {
        } finally {
            _bcornu_methode_context134.methodEnd();
        }
    }
}

