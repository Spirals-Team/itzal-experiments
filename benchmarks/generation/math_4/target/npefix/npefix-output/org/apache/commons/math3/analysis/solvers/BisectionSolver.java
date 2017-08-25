package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

public class BisectionSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public BisectionSolver() {
        this(BisectionSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context204 = new ConstructorContext(BisectionSolver.class, 37, 1399, 1543);
        try {
        } finally {
            _bcornu_methode_context204.methodEnd();
        }
    }

    public BisectionSolver(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context205 = new ConstructorContext(BisectionSolver.class, 45, 1549, 1736);
        try {
        } finally {
            _bcornu_methode_context205.methodEnd();
        }
    }

    public BisectionSolver(double relativeAccuracy, double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context206 = new ConstructorContext(BisectionSolver.class, 54, 1742, 2049);
        try {
        } finally {
            _bcornu_methode_context206.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context819 = new MethodContext(double.class, 63, 2056, 2961);
        try {
            CallChecker.varInit(this, "this", 63, 2056, 2961);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BisectionSolver.DEFAULT_ABSOLUTE_ACCURACY", 63, 2056, 2961);
            double min = CallChecker.varInit(((double) (getMin())), "min", 65, 2187, 2208);
            double max = CallChecker.varInit(((double) (getMax())), "max", 66, 2218, 2239);
            verifyInterval(min, max);
            final double absoluteAccuracy = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "absoluteAccuracy", 68, 2283, 2336);
            double m = CallChecker.init(double.class);
            double fm = CallChecker.init(double.class);
            double fmin = CallChecker.init(double.class);
            while (true) {
                m = UnivariateSolverUtils.midpoint(min, max);
                CallChecker.varAssign(m, "m", 74, 2432, 2476);
                fmin = computeObjectiveValue(min);
                CallChecker.varAssign(fmin, "fmin", 75, 2490, 2523);
                fm = computeObjectiveValue(m);
                CallChecker.varAssign(fm, "fm", 76, 2537, 2566);
                if ((fm * fmin) > 0) {
                    min = m;
                    CallChecker.varAssign(min, "min", 80, 2665, 2672);
                }else {
                    max = m;
                    CallChecker.varAssign(max, "max", 83, 2758, 2765);
                }
                if ((FastMath.abs((max - min))) <= absoluteAccuracy) {
                    m = UnivariateSolverUtils.midpoint(min, max);
                    CallChecker.varAssign(m, "m", 87, 2861, 2905);
                    return m;
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context819.methodEnd();
        }
    }
}

