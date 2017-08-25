package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;

@Deprecated
public class Weight implements OptimizationData {
    private final RealMatrix weightMatrix;

    public Weight(double[] weight) {
        ConstructorContext _bcornu_methode_context1041 = new ConstructorContext(Weight.class, 43, 1346, 1555);
        try {
            weightMatrix = new DiagonalMatrix(weight);
            CallChecker.varAssign(this.weightMatrix, "this.weightMatrix", 44, 1508, 1549);
        } finally {
            _bcornu_methode_context1041.methodEnd();
        }
    }

    public Weight(RealMatrix weight) {
        ConstructorContext _bcornu_methode_context1042 = new ConstructorContext(Weight.class, 52, 1562, 2010);
        try {
            if (CallChecker.beforeDeref(weight, RealMatrix.class, 53, 1748, 1753)) {
                if (CallChecker.beforeDeref(weight, RealMatrix.class, 53, 1779, 1784)) {
                    weight = CallChecker.beforeCalled(weight, RealMatrix.class, 53, 1748, 1753);
                    weight = CallChecker.beforeCalled(weight, RealMatrix.class, 53, 1779, 1784);
                    if ((CallChecker.isCalled(weight, RealMatrix.class, 53, 1748, 1753).getColumnDimension()) != (CallChecker.isCalled(weight, RealMatrix.class, 53, 1779, 1784).getRowDimension())) {
                        if (CallChecker.beforeDeref(weight, RealMatrix.class, 54, 1854, 1859)) {
                            if (CallChecker.beforeDeref(weight, RealMatrix.class, 55, 1930, 1935)) {
                                weight = CallChecker.beforeCalled(weight, RealMatrix.class, 54, 1854, 1859);
                                weight = CallChecker.beforeCalled(weight, RealMatrix.class, 55, 1930, 1935);
                                throw new NonSquareMatrixException(CallChecker.isCalled(weight, RealMatrix.class, 54, 1854, 1859).getColumnDimension(), CallChecker.isCalled(weight, RealMatrix.class, 55, 1930, 1935).getRowDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            weight = CallChecker.beforeCalled(weight, RealMatrix.class, 58, 1991, 1996);
            weightMatrix = CallChecker.isCalled(weight, RealMatrix.class, 58, 1991, 1996).copy();
            CallChecker.varAssign(this.weightMatrix, "this.weightMatrix", 58, 1976, 2004);
        } finally {
            _bcornu_methode_context1042.methodEnd();
        }
    }

    public RealMatrix getWeight() {
        MethodContext _bcornu_methode_context4613 = new MethodContext(RealMatrix.class, 66, 2017, 2177);
        try {
            CallChecker.varInit(this, "this", 66, 2017, 2177);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 66, 2017, 2177);
            if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 67, 2152, 2163)) {
                return CallChecker.isCalled(weightMatrix, RealMatrix.class, 67, 2152, 2163).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4613.methodEnd();
        }
    }
}

