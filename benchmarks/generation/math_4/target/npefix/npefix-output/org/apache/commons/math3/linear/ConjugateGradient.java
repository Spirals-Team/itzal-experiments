package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.util.IterationManager;

public class ConjugateGradient extends PreconditionedIterativeLinearSolver {
    public static final String OPERATOR = "operator";

    public static final String VECTOR = "vector";

    private boolean check;

    private final double delta;

    public ConjugateGradient(final int maxIterations, final double delta, final boolean check) {
        super(maxIterations);
        ConstructorContext _bcornu_methode_context59 = new ConstructorContext(ConjugateGradient.class, 106, 4168, 4767);
        try {
            this.delta = delta;
            CallChecker.varAssign(this.delta, "this.delta", 109, 4715, 4733);
            this.check = check;
            CallChecker.varAssign(this.check, "this.check", 110, 4743, 4761);
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public ConjugateGradient(final IterationManager manager, final double delta, final boolean check) throws NullArgumentException {
        super(manager);
        ConstructorContext _bcornu_methode_context60 = new ConstructorContext(ConjugateGradient.class, 123, 4774, 5502);
        try {
            this.delta = delta;
            CallChecker.varAssign(this.delta, "this.delta", 127, 5450, 5468);
            this.check = check;
            CallChecker.varAssign(this.check, "this.check", 128, 5478, 5496);
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public final boolean getCheck() {
        MethodContext _bcornu_methode_context238 = new MethodContext(boolean.class, 137, 5509, 5767);
        try {
            CallChecker.varInit(this, "this", 137, 5509, 5767);
            CallChecker.varInit(this.delta, "delta", 137, 5509, 5767);
            CallChecker.varInit(this.check, "check", 137, 5509, 5767);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.ConjugateGradient.VECTOR", 137, 5509, 5767);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.ConjugateGradient.OPERATOR", 137, 5509, 5767);
            return check;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context238.methodEnd();
        }
    }

    @Override
    public RealVector solveInPlace(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final RealVector x0) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonPositiveDefiniteOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context239 = new MethodContext(RealVector.class, 148, 5774, 9645);
        try {
            CallChecker.varInit(this, "this", 148, 5774, 9645);
            CallChecker.varInit(x0, "x0", 148, 5774, 9645);
            CallChecker.varInit(b, "b", 148, 5774, 9645);
            CallChecker.varInit(m, "m", 148, 5774, 9645);
            CallChecker.varInit(a, "a", 148, 5774, 9645);
            CallChecker.varInit(this.delta, "delta", 148, 5774, 9645);
            CallChecker.varInit(this.check, "check", 148, 5774, 9645);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.ConjugateGradient.VECTOR", 148, 5774, 9645);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.ConjugateGradient.OPERATOR", 148, 5774, 9645);
            PreconditionedIterativeLinearSolver.checkParameters(a, m, b, x0);
            final IterationManager manager = CallChecker.varInit(getIterationManager(), "manager", 156, 6435, 6489);
            if (CallChecker.beforeDeref(manager, IterationManager.class, 158, 6555, 6561)) {
                CallChecker.isCalled(manager, IterationManager.class, 158, 6555, 6561).resetIterationCount();
            }
            final double rmax = CallChecker.varInit(((double) ((this.delta) * (CallChecker.isCalled(b, RealVector.class, 159, 6622, 6622).getNorm()))), "rmax", 159, 6594, 6633);
            final RealVector bro = CallChecker.varInit(RealVector.unmodifiableRealVector(b), "bro", 160, 6643, 6702);
            if (CallChecker.beforeDeref(manager, IterationManager.class, 163, 6770, 6776)) {
                CallChecker.isCalled(manager, IterationManager.class, 163, 6770, 6776).incrementIterationCount();
            }
            final RealVector x = CallChecker.varInit(x0, "x", 167, 6813, 7009);
            final RealVector xro = CallChecker.varInit(RealVector.unmodifiableRealVector(x), "xro", 168, 7019, 7078);
            final RealVector p = CallChecker.varInit(CallChecker.isCalled(x, RealVector.class, 169, 7109, 7109).copy(), "p", 169, 7088, 7117);
            RealVector q = CallChecker.init(RealVector.class);
            if (CallChecker.beforeDeref(a, RealLinearOperator.class, 170, 7142, 7142)) {
                q = CallChecker.isCalled(a, RealLinearOperator.class, 170, 7142, 7142).operate(p);
                CallChecker.varAssign(q, "q", 170, 7142, 7142);
            }
            final RealVector r = CallChecker.varInit(CallChecker.isCalled(b, RealVector.class, 172, 7186, 7186).combine(1, (-1), q), "r", 172, 7165, 7205);
            final RealVector rro = CallChecker.varInit(RealVector.unmodifiableRealVector(r), "rro", 173, 7215, 7274);
            double rnorm = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(r, RealVector.class, 174, 7299, 7299)) {
                rnorm = CallChecker.isCalled(r, RealVector.class, 174, 7299, 7299).getNorm();
                CallChecker.varAssign(rnorm, "rnorm", 174, 7299, 7299);
            }
            RealVector z = CallChecker.init(RealVector.class);
            if (m == null) {
                z = r;
                CallChecker.varAssign(z, "z", 177, 7371, 7376);
            }else {
                z = null;
                CallChecker.varAssign(z, "z", 179, 7407, 7415);
            }
            IterativeLinearSolverEvent evt = CallChecker.init(IterativeLinearSolverEvent.class);
            if (CallChecker.beforeDeref(manager, IterationManager.class, 183, 7537, 7543)) {
                evt = new DefaultIterativeLinearSolverEvent(this, CallChecker.isCalled(manager, IterationManager.class, 183, 7537, 7543).getIterations(), xro, bro, rro, rnorm);
                CallChecker.varAssign(evt, "evt", 182, 7475, 7583);
            }
            if (CallChecker.beforeDeref(manager, IterationManager.class, 184, 7593, 7599)) {
                CallChecker.isCalled(manager, IterationManager.class, 184, 7593, 7599).fireInitializationEvent(evt);
            }
            if (rnorm <= rmax) {
                if (CallChecker.beforeDeref(manager, IterationManager.class, 186, 7672, 7678)) {
                    CallChecker.isCalled(manager, IterationManager.class, 186, 7672, 7678).fireTerminationEvent(evt);
                }
                return x;
            }
            double rhoPrev = CallChecker.varInit(((double) (0.0)), "rhoPrev", 189, 7747, 7766);
            while (true) {
                if (CallChecker.beforeDeref(manager, IterationManager.class, 191, 7803, 7809)) {
                    CallChecker.isCalled(manager, IterationManager.class, 191, 7803, 7809).incrementIterationCount();
                }
                if (CallChecker.beforeDeref(manager, IterationManager.class, 193, 7916, 7922)) {
                    evt = new DefaultIterativeLinearSolverEvent(this, CallChecker.isCalled(manager, IterationManager.class, 193, 7916, 7922).getIterations(), xro, bro, rro, rnorm);
                    CallChecker.varAssign(evt, "evt", 192, 7850, 7962);
                }
                if (CallChecker.beforeDeref(manager, IterationManager.class, 194, 7976, 7982)) {
                    CallChecker.isCalled(manager, IterationManager.class, 194, 7976, 7982).fireIterationStartedEvent(evt);
                }
                if (m != null) {
                    z = m.operate(r);
                    CallChecker.varAssign(z, "z", 196, 8061, 8077);
                }
                final double rhoNext = CallChecker.varInit(((double) (CallChecker.isCalled(r, RealVector.class, 198, 8128, 8128).dotProduct(z))), "rhoNext", 198, 8105, 8143);
                if ((check) && (rhoNext <= 0.0)) {
                    NonPositiveDefiniteOperatorException e = CallChecker.init(NonPositiveDefiniteOperatorException.class);
                    e = new NonPositiveDefiniteOperatorException();
                    CallChecker.varAssign(e, "e", 201, 8267, 8313);
                    e = CallChecker.beforeCalled(e, NonPositiveDefiniteOperatorException.class, 202, 8364, 8364);
                    final ExceptionContext context = CallChecker.varInit(CallChecker.isCalled(e, NonPositiveDefiniteOperatorException.class, 202, 8364, 8364).getContext(), "context", 202, 8331, 8378);
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 203, 8396, 8402)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 203, 8396, 8402).setValue(ConjugateGradient.OPERATOR, m);
                    }
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 204, 8443, 8449)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 204, 8443, 8449).setValue(ConjugateGradient.VECTOR, r);
                    }
                    throw e;
                }
                if (CallChecker.beforeDeref(manager, IterationManager.class, 207, 8527, 8533)) {
                    if ((CallChecker.isCalled(manager, IterationManager.class, 207, 8527, 8533).getIterations()) == 2) {
                        if (CallChecker.beforeDeref(p, RealVector.class, 208, 8575, 8575)) {
                            CallChecker.isCalled(p, RealVector.class, 208, 8575, 8575).setSubVector(0, z);
                        }
                    }else {
                        if (CallChecker.beforeDeref(p, RealVector.class, 210, 8634, 8634)) {
                            CallChecker.isCalled(p, RealVector.class, 210, 8634, 8634).combineToSelf((rhoNext / rhoPrev), 1.0, z);
                        }
                    }
                }
                if (CallChecker.beforeDeref(a, RealLinearOperator.class, 212, 8707, 8707)) {
                    q = CallChecker.isCalled(a, RealLinearOperator.class, 212, 8707, 8707).operate(p);
                    CallChecker.varAssign(q, "q", 212, 8703, 8719);
                }
                final double pq = CallChecker.varInit(((double) (CallChecker.isCalled(p, RealVector.class, 213, 8751, 8751).dotProduct(q))), "pq", 213, 8733, 8766);
                if ((check) && (pq <= 0.0)) {
                    NonPositiveDefiniteOperatorException e = CallChecker.init(NonPositiveDefiniteOperatorException.class);
                    e = new NonPositiveDefiniteOperatorException();
                    CallChecker.varAssign(e, "e", 216, 8885, 8931);
                    e = CallChecker.beforeCalled(e, NonPositiveDefiniteOperatorException.class, 217, 8982, 8982);
                    final ExceptionContext context = CallChecker.varInit(CallChecker.isCalled(e, NonPositiveDefiniteOperatorException.class, 217, 8982, 8982).getContext(), "context", 217, 8949, 8996);
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 218, 9014, 9020)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 218, 9014, 9020).setValue(ConjugateGradient.OPERATOR, a);
                    }
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 219, 9061, 9067)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 219, 9061, 9067).setValue(ConjugateGradient.VECTOR, p);
                    }
                    throw e;
                }
                final double alpha = CallChecker.varInit(((double) (rhoNext / pq)), "alpha", 222, 9141, 9174);
                if (CallChecker.beforeDeref(x, RealVector.class, 223, 9188, 9188)) {
                    CallChecker.isCalled(x, RealVector.class, 223, 9188, 9188).combineToSelf(1.0, alpha, p);
                }
                if (CallChecker.beforeDeref(r, RealVector.class, 224, 9231, 9231)) {
                    CallChecker.isCalled(r, RealVector.class, 224, 9231, 9231).combineToSelf(1.0, (-alpha), q);
                }
                rhoPrev = rhoNext;
                CallChecker.varAssign(rhoPrev, "rhoPrev", 225, 9275, 9292);
                if (CallChecker.beforeDeref(r, RealVector.class, 226, 9314, 9314)) {
                    rnorm = CallChecker.isCalled(r, RealVector.class, 226, 9314, 9314).getNorm();
                    CallChecker.varAssign(rnorm, "rnorm", 226, 9306, 9325);
                }
                if (CallChecker.beforeDeref(manager, IterationManager.class, 228, 9405, 9411)) {
                    evt = new DefaultIterativeLinearSolverEvent(this, CallChecker.isCalled(manager, IterationManager.class, 228, 9405, 9411).getIterations(), xro, bro, rro, rnorm);
                    CallChecker.varAssign(evt, "evt", 227, 9339, 9451);
                }
                if (CallChecker.beforeDeref(manager, IterationManager.class, 229, 9465, 9471)) {
                    CallChecker.isCalled(manager, IterationManager.class, 229, 9465, 9471).fireIterationPerformedEvent(evt);
                }
                if (rnorm <= rmax) {
                    if (CallChecker.beforeDeref(manager, IterationManager.class, 231, 9556, 9562)) {
                        CallChecker.isCalled(manager, IterationManager.class, 231, 9556, 9562).fireTerminationEvent(evt);
                    }
                    return x;
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context239.methodEnd();
        }
    }
}

