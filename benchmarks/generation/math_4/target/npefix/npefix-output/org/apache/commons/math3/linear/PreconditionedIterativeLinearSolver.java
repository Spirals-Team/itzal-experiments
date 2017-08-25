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

public abstract class PreconditionedIterativeLinearSolver extends IterativeLinearSolver {
    public PreconditionedIterativeLinearSolver(final int maxIterations) {
        super(maxIterations);
        ConstructorContext _bcornu_methode_context758 = new ConstructorContext(PreconditionedIterativeLinearSolver.class, 59, 2112, 2377);
        try {
        } finally {
            _bcornu_methode_context758.methodEnd();
        }
    }

    public PreconditionedIterativeLinearSolver(final IterationManager manager) throws NullArgumentException {
        super(manager);
        ConstructorContext _bcornu_methode_context759 = new ConstructorContext(PreconditionedIterativeLinearSolver.class, 69, 2384, 2748);
        try {
        } finally {
            _bcornu_methode_context759.methodEnd();
        }
    }

    public RealVector solve(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final RealVector x0) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context3421 = new MethodContext(RealVector.class, 93, 2755, 4032);
        try {
            CallChecker.varInit(this, "this", 93, 2755, 4032);
            CallChecker.varInit(x0, "x0", 93, 2755, 4032);
            CallChecker.varInit(b, "b", 93, 2755, 4032);
            CallChecker.varInit(m, "m", 93, 2755, 4032);
            CallChecker.varInit(a, "a", 93, 2755, 4032);
            MathUtils.checkNotNull(x0);
            if (CallChecker.beforeDeref(x0, RealVector.class, 98, 4016, 4017)) {
                return solveInPlace(a, m, b, CallChecker.isCalled(x0, RealVector.class, 98, 4016, 4017).copy());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3421.methodEnd();
        }
    }

    @Override
    public RealVector solve(final RealLinearOperator a, final RealVector b) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context3422 = new MethodContext(RealVector.class, 103, 4039, 4456);
        try {
            CallChecker.varInit(this, "this", 103, 4039, 4456);
            CallChecker.varInit(b, "b", 103, 4039, 4456);
            CallChecker.varInit(a, "a", 103, 4039, 4456);
            MathUtils.checkNotNull(a);
            final RealVector x = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(a, RealLinearOperator.class, 107, 4364, 4364).getColumnDimension()), "x", 107, 4323, 4387);
            if (CallChecker.beforeDeref(x, RealVector.class, 108, 4397, 4397)) {
                CallChecker.isCalled(x, RealVector.class, 108, 4397, 4397).set(0.0);
            }
            return solveInPlace(a, null, b, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3422.methodEnd();
        }
    }

    @Override
    public RealVector solve(final RealLinearOperator a, final RealVector b, final RealVector x0) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context3423 = new MethodContext(RealVector.class, 114, 4463, 4845);
        try {
            CallChecker.varInit(this, "this", 114, 4463, 4845);
            CallChecker.varInit(x0, "x0", 114, 4463, 4845);
            CallChecker.varInit(b, "b", 114, 4463, 4845);
            CallChecker.varInit(a, "a", 114, 4463, 4845);
            MathUtils.checkNotNull(x0);
            if (CallChecker.beforeDeref(x0, RealVector.class, 119, 4829, 4830)) {
                return solveInPlace(a, null, b, CallChecker.isCalled(x0, RealVector.class, 119, 4829, 4830).copy());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3423.methodEnd();
        }
    }

    protected static void checkParameters(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final RealVector x0) throws DimensionMismatchException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context3424 = new MethodContext(void.class, 139, 4852, 6482);
        try {
            CallChecker.varInit(x0, "x0", 139, 4852, 6482);
            CallChecker.varInit(b, "b", 139, 4852, 6482);
            CallChecker.varInit(m, "m", 139, 4852, 6482);
            CallChecker.varInit(a, "a", 139, 4852, 6482);
            IterativeLinearSolver.checkParameters(a, b, x0);
            if (m != null) {
                if ((m.getColumnDimension()) != (m.getRowDimension())) {
                    throw new NonSquareOperatorException(m.getColumnDimension(), m.getRowDimension());
                }
                if (CallChecker.beforeDeref(a, RealLinearOperator.class, 149, 6282, 6282)) {
                    if ((m.getRowDimension()) != (CallChecker.isCalled(a, RealLinearOperator.class, 149, 6282, 6282).getRowDimension())) {
                        if (CallChecker.beforeDeref(a, RealLinearOperator.class, 151, 6432, 6432)) {
                            throw new DimensionMismatchException(m.getRowDimension(), CallChecker.isCalled(a, RealLinearOperator.class, 151, 6432, 6432).getRowDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3424.methodEnd();
        }
    }

    public RealVector solve(RealLinearOperator a, RealLinearOperator m, RealVector b) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context3425 = new MethodContext(RealVector.class, 174, 6489, 7721);
        try {
            CallChecker.varInit(this, "this", 174, 6489, 7721);
            CallChecker.varInit(b, "b", 174, 6489, 7721);
            CallChecker.varInit(m, "m", 174, 6489, 7721);
            CallChecker.varInit(a, "a", 174, 6489, 7721);
            MathUtils.checkNotNull(a);
            a = CallChecker.beforeCalled(a, RealLinearOperator.class, 178, 7651, 7651);
            final RealVector x = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(a, RealLinearOperator.class, 178, 7651, 7651).getColumnDimension()), "x", 178, 7610, 7674);
            return solveInPlace(a, m, b, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3425.methodEnd();
        }
    }

    public abstract RealVector solveInPlace(RealLinearOperator a, RealLinearOperator m, RealVector b, RealVector x0) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException;

    @Override
    public RealVector solveInPlace(final RealLinearOperator a, final RealVector b, final RealVector x0) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context3427 = new MethodContext(RealVector.class, 209, 9012, 9338);
        try {
            CallChecker.varInit(this, "this", 209, 9012, 9338);
            CallChecker.varInit(x0, "x0", 209, 9012, 9338);
            CallChecker.varInit(b, "b", 209, 9012, 9338);
            CallChecker.varInit(a, "a", 209, 9012, 9338);
            return solveInPlace(a, null, b, x0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3427.methodEnd();
        }
    }
}

