package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

public abstract class IterativeLinearSolver {
    private final IterationManager manager;

    public IterativeLinearSolver(final int maxIterations) {
        ConstructorContext _bcornu_methode_context1236 = new ConstructorContext(IterativeLinearSolver.class, 44, 1658, 1939);
        try {
            this.manager = new IterationManager(maxIterations);
            CallChecker.varAssign(this.manager, "this.manager", 45, 1883, 1933);
        } finally {
            _bcornu_methode_context1236.methodEnd();
        }
    }

    public IterativeLinearSolver(final IterationManager manager) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context1237 = new ConstructorContext(IterativeLinearSolver.class, 54, 1946, 2345);
        try {
            MathUtils.checkNotNull(manager);
            this.manager = manager;
            CallChecker.varAssign(this.manager, "this.manager", 57, 2317, 2339);
        } finally {
            _bcornu_methode_context1237.methodEnd();
        }
    }

    protected static void checkParameters(final RealLinearOperator a, final RealVector b, final RealVector x0) throws DimensionMismatchException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context5556 = new MethodContext(void.class, 74, 2352, 4031);
        try {
            CallChecker.varInit(x0, "x0", 74, 2352, 4031);
            CallChecker.varInit(b, "b", 74, 2352, 4031);
            CallChecker.varInit(a, "a", 74, 2352, 4031);
            MathUtils.checkNotNull(a);
            MathUtils.checkNotNull(b);
            MathUtils.checkNotNull(x0);
            if (CallChecker.beforeDeref(a, RealLinearOperator.class, 81, 3404, 3404)) {
                if (CallChecker.beforeDeref(a, RealLinearOperator.class, 81, 3427, 3427)) {
                    if ((CallChecker.isCalled(a, RealLinearOperator.class, 81, 3404, 3404).getRowDimension()) != (CallChecker.isCalled(a, RealLinearOperator.class, 81, 3427, 3427).getColumnDimension())) {
                        if (CallChecker.beforeDeref(a, RealLinearOperator.class, 82, 3502, 3502)) {
                            if (CallChecker.beforeDeref(a, RealLinearOperator.class, 83, 3578, 3578)) {
                                throw new NonSquareOperatorException(CallChecker.isCalled(a, RealLinearOperator.class, 82, 3502, 3502).getRowDimension(), CallChecker.isCalled(a, RealLinearOperator.class, 83, 3578, 3578).getColumnDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(b, RealVector.class, 85, 3625, 3625)) {
                if (CallChecker.beforeDeref(a, RealLinearOperator.class, 85, 3645, 3645)) {
                    if ((CallChecker.isCalled(b, RealVector.class, 85, 3625, 3625).getDimension()) != (CallChecker.isCalled(a, RealLinearOperator.class, 85, 3645, 3645).getRowDimension())) {
                        if (CallChecker.beforeDeref(b, RealVector.class, 86, 3717, 3717)) {
                            if (CallChecker.beforeDeref(a, RealLinearOperator.class, 87, 3784, 3784)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(b, RealVector.class, 86, 3717, 3717).getDimension(), CallChecker.isCalled(a, RealLinearOperator.class, 87, 3784, 3784).getRowDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(x0, RealVector.class, 89, 3828, 3829)) {
                if (CallChecker.beforeDeref(a, RealLinearOperator.class, 89, 3849, 3849)) {
                    if ((CallChecker.isCalled(x0, RealVector.class, 89, 3828, 3829).getDimension()) != (CallChecker.isCalled(a, RealLinearOperator.class, 89, 3849, 3849).getColumnDimension())) {
                        if (CallChecker.beforeDeref(x0, RealVector.class, 90, 3924, 3925)) {
                            if (CallChecker.beforeDeref(a, RealLinearOperator.class, 91, 3992, 3992)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(x0, RealVector.class, 90, 3924, 3925).getDimension(), CallChecker.isCalled(a, RealLinearOperator.class, 91, 3992, 3992).getColumnDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5556.methodEnd();
        }
    }

    public IterationManager getIterationManager() {
        MethodContext _bcornu_methode_context5557 = new MethodContext(IterationManager.class, 100, 4038, 4226);
        try {
            CallChecker.varInit(this, "this", 100, 4038, 4226);
            CallChecker.varInit(this.manager, "manager", 100, 4038, 4226);
            return manager;
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterationManager) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5557.methodEnd();
        }
    }

    public RealVector solve(final RealLinearOperator a, final RealVector b) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context5558 = new MethodContext(RealVector.class, 120, 4233, 5377);
        try {
            CallChecker.varInit(this, "this", 120, 4233, 5377);
            CallChecker.varInit(b, "b", 120, 4233, 5377);
            CallChecker.varInit(a, "a", 120, 4233, 5377);
            CallChecker.varInit(this.manager, "manager", 120, 4233, 5377);
            MathUtils.checkNotNull(a);
            final RealVector x = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(a, RealLinearOperator.class, 124, 5291, 5291).getColumnDimension()), "x", 124, 5250, 5314);
            if (CallChecker.beforeDeref(x, RealVector.class, 125, 5324, 5324)) {
                CallChecker.isCalled(x, RealVector.class, 125, 5324, 5324).set(0.0);
            }
            return solveInPlace(a, b, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5558.methodEnd();
        }
    }

    public RealVector solve(RealLinearOperator a, RealVector b, RealVector x0) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context5559 = new MethodContext(RealVector.class, 146, 5384, 6513);
        try {
            CallChecker.varInit(this, "this", 146, 5384, 6513);
            CallChecker.varInit(x0, "x0", 146, 5384, 6513);
            CallChecker.varInit(b, "b", 146, 5384, 6513);
            CallChecker.varInit(a, "a", 146, 5384, 6513);
            CallChecker.varInit(this.manager, "manager", 146, 5384, 6513);
            MathUtils.checkNotNull(x0);
            if (CallChecker.beforeDeref(x0, RealVector.class, 150, 6497, 6498)) {
                x0 = CallChecker.beforeCalled(x0, RealVector.class, 150, 6497, 6498);
                return solveInPlace(a, b, CallChecker.isCalled(x0, RealVector.class, 150, 6497, 6498).copy());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5559.methodEnd();
        }
    }

    public abstract RealVector solveInPlace(RealLinearOperator a, RealVector b, RealVector x0) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException;
}

