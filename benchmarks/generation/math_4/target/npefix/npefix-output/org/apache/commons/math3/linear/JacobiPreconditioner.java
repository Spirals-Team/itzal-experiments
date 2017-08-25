package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.util.MathArrays;

public class JacobiPreconditioner extends RealLinearOperator {
    private final ArrayRealVector diag;

    public JacobiPreconditioner(final double[] diag, final boolean deep) {
        ConstructorContext _bcornu_methode_context1196 = new ConstructorContext(JacobiPreconditioner.class, 43, 1352, 1737);
        try {
            this.diag = new ArrayRealVector(diag, deep);
            CallChecker.varAssign(this.diag, "this.diag", 44, 1688, 1731);
        } finally {
            _bcornu_methode_context1196.methodEnd();
        }
    }

    public static JacobiPreconditioner create(final RealLinearOperator a) throws NonSquareOperatorException {
        MethodContext _bcornu_methode_context5370 = new MethodContext(JacobiPreconditioner.class, 60, 1744, 3361);
        try {
            CallChecker.varInit(a, "a", 60, 1744, 3361);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(a, RealLinearOperator.class, 62, 2639, 2639).getColumnDimension())), "n", 62, 2625, 2661);
            if (CallChecker.beforeDeref(a, RealLinearOperator.class, 63, 2675, 2675)) {
                if ((CallChecker.isCalled(a, RealLinearOperator.class, 63, 2675, 2675).getRowDimension()) != n) {
                    if (CallChecker.beforeDeref(a, RealLinearOperator.class, 64, 2752, 2752)) {
                        throw new NonSquareOperatorException(CallChecker.isCalled(a, RealLinearOperator.class, 64, 2752, 2752).getRowDimension(), n);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] diag = CallChecker.varInit(new double[n], "diag", 66, 2795, 2830);
            if (a instanceof AbstractRealMatrix) {
                final AbstractRealMatrix m = CallChecker.varInit(((AbstractRealMatrix) (a)), "m", 68, 2891, 2942);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(diag, double[].class, 70, 3002, 3005)) {
                        if (CallChecker.beforeDeref(m, AbstractRealMatrix.class, 70, 3012, 3012)) {
                            CallChecker.isCalled(diag, double[].class, 70, 3002, 3005)[i] = CallChecker.isCalled(m, AbstractRealMatrix.class, 70, 3012, 3012).getEntry(i, i);
                            CallChecker.varAssign(CallChecker.isCalled(diag, double[].class, 70, 3002, 3005)[i], "CallChecker.isCalled(diag, double[].class, 70, 3002, 3005)[i]", 70, 3002, 3028);
                        }
                    }
                }
            }else {
                final ArrayRealVector x = CallChecker.varInit(new ArrayRealVector(n), "x", 73, 3073, 3121);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(x, ArrayRealVector.class, 75, 3181, 3181)) {
                        CallChecker.isCalled(x, ArrayRealVector.class, 75, 3181, 3181).set(0.0);
                    }
                    if (CallChecker.beforeDeref(x, ArrayRealVector.class, 76, 3208, 3208)) {
                        CallChecker.isCalled(x, ArrayRealVector.class, 76, 3208, 3208).setEntry(i, 1.0);
                    }
                    if (CallChecker.beforeDeref(diag, double[].class, 77, 3243, 3246)) {
                        if (CallChecker.beforeDeref(a, RealLinearOperator.class, 77, 3253, 3253)) {
                            final RealVector npe_invocation_var1002 = CallChecker.isCalled(a, RealLinearOperator.class, 77, 3253, 3253).operate(x);
                            if (CallChecker.beforeDeref(npe_invocation_var1002, RealVector.class, 77, 3253, 3264)) {
                                CallChecker.isCalled(diag, double[].class, 77, 3243, 3246)[i] = CallChecker.isCalled(npe_invocation_var1002, RealVector.class, 77, 3253, 3264).getEntry(i);
                                CallChecker.varAssign(CallChecker.isCalled(diag, double[].class, 77, 3243, 3246)[i], "CallChecker.isCalled(diag, double[].class, 77, 3243, 3246)[i]", 77, 3243, 3277);
                            }
                        }
                    }
                }
            }
            return new JacobiPreconditioner(diag, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((JacobiPreconditioner) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5370.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context5371 = new MethodContext(int.class, 85, 3368, 3481);
        try {
            CallChecker.varInit(this, "this", 85, 3368, 3481);
            CallChecker.varInit(this.diag, "diag", 85, 3368, 3481);
            if (CallChecker.beforeDeref(diag, ArrayRealVector.class, 86, 3456, 3459)) {
                return CallChecker.isCalled(diag, ArrayRealVector.class, 86, 3456, 3459).getDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5371.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context5372 = new MethodContext(int.class, 91, 3488, 3598);
        try {
            CallChecker.varInit(this, "this", 91, 3488, 3598);
            CallChecker.varInit(this.diag, "diag", 91, 3488, 3598);
            if (CallChecker.beforeDeref(diag, ArrayRealVector.class, 92, 3573, 3576)) {
                return CallChecker.isCalled(diag, ArrayRealVector.class, 92, 3573, 3576).getDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5372.methodEnd();
        }
    }

    @Override
    public RealVector operate(final RealVector x) {
        MethodContext _bcornu_methode_context5373 = new MethodContext(RealVector.class, 97, 3605, 3936);
        try {
            CallChecker.varInit(this, "this", 97, 3605, 3936);
            CallChecker.varInit(x, "x", 97, 3605, 3936);
            CallChecker.varInit(this.diag, "diag", 97, 3605, 3936);
            if (CallChecker.beforeDeref(x, RealVector.class, 99, 3803, 3803)) {
                if (CallChecker.beforeDeref(diag, ArrayRealVector.class, 100, 3872, 3875)) {
                    return new ArrayRealVector(MathArrays.ebeDivide(CallChecker.isCalled(x, RealVector.class, 99, 3803, 3803).toArray(), CallChecker.isCalled(diag, ArrayRealVector.class, 100, 3872, 3875).toArray()), false);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5373.methodEnd();
        }
    }

    public RealLinearOperator sqrt() {
        MethodContext _bcornu_methode_context5377 = new MethodContext(RealLinearOperator.class, 112, 3943, 5053);
        try {
            CallChecker.varInit(this, "this", 112, 3943, 5053);
            CallChecker.varInit(this.diag, "diag", 112, 3943, 5053);
            final RealVector sqrtDiag = CallChecker.varInit(CallChecker.isCalled(diag, ArrayRealVector.class, 113, 4307, 4310).map(new Sqrt()), "sqrtDiag", 113, 4279, 4327);
            return new RealLinearOperator() {
                @Override
                public RealVector operate(final RealVector x) {
                    MethodContext _bcornu_methode_context5374 = new MethodContext(RealVector.class, 117, 4383, 4711);
                    try {
                        CallChecker.varInit(this, "this", 117, 4383, 4711);
                        CallChecker.varInit(x, "x", 117, 4383, 4711);
                        if (CallChecker.beforeDeref(x, RealVector.class, 118, 4550, 4550)) {
                            if (CallChecker.beforeDeref(sqrtDiag, RealVector.class, 119, 4627, 4634)) {
                                return new ArrayRealVector(MathArrays.ebeDivide(CallChecker.isCalled(x, RealVector.class, 118, 4550, 4550).toArray(), CallChecker.isCalled(sqrtDiag, RealVector.class, 119, 4627, 4634).toArray()), false);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5374.methodEnd();
                    }
                }

                @Override
                public int getRowDimension() {
                    MethodContext _bcornu_methode_context5375 = new MethodContext(int.class, 125, 4726, 4872);
                    try {
                        CallChecker.varInit(this, "this", 125, 4726, 4872);
                        if (CallChecker.beforeDeref(sqrtDiag, RealVector.class, 126, 4835, 4842)) {
                            return CallChecker.isCalled(sqrtDiag, RealVector.class, 126, 4835, 4842).getDimension();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5375.methodEnd();
                    }
                }

                @Override
                public int getColumnDimension() {
                    MethodContext _bcornu_methode_context5376 = new MethodContext(int.class, 131, 4887, 5036);
                    try {
                        CallChecker.varInit(this, "this", 131, 4887, 5036);
                        if (CallChecker.beforeDeref(sqrtDiag, RealVector.class, 132, 4999, 5006)) {
                            return CallChecker.isCalled(sqrtDiag, RealVector.class, 132, 4999, 5006).getDimension();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5376.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealLinearOperator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5377.methodEnd();
        }
    }
}

