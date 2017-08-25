package org.apache.commons.math3.optim.nonlinear.vector;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.OptimizationData;

public class Weight implements OptimizationData {
    private final RealMatrix weightMatrix;

    public Weight(double[] weight) {
        ConstructorContext _bcornu_methode_context1043 = new ConstructorContext(Weight.class, 41, 1350, 1559);
        try {
            weightMatrix = new DiagonalMatrix(weight);
            CallChecker.varAssign(this.weightMatrix, "this.weightMatrix", 42, 1512, 1553);
        } finally {
            _bcornu_methode_context1043.methodEnd();
        }
    }

    public Weight(RealMatrix weight) {
        ConstructorContext _bcornu_methode_context1044 = new ConstructorContext(Weight.class, 50, 1566, 2014);
        try {
            if (CallChecker.beforeDeref(weight, RealMatrix.class, 51, 1752, 1757)) {
                if (CallChecker.beforeDeref(weight, RealMatrix.class, 51, 1783, 1788)) {
                    weight = CallChecker.beforeCalled(weight, RealMatrix.class, 51, 1752, 1757);
                    weight = CallChecker.beforeCalled(weight, RealMatrix.class, 51, 1783, 1788);
                    if ((CallChecker.isCalled(weight, RealMatrix.class, 51, 1752, 1757).getColumnDimension()) != (CallChecker.isCalled(weight, RealMatrix.class, 51, 1783, 1788).getRowDimension())) {
                        if (CallChecker.beforeDeref(weight, RealMatrix.class, 52, 1858, 1863)) {
                            if (CallChecker.beforeDeref(weight, RealMatrix.class, 53, 1934, 1939)) {
                                weight = CallChecker.beforeCalled(weight, RealMatrix.class, 52, 1858, 1863);
                                weight = CallChecker.beforeCalled(weight, RealMatrix.class, 53, 1934, 1939);
                                throw new NonSquareMatrixException(CallChecker.isCalled(weight, RealMatrix.class, 52, 1858, 1863).getColumnDimension(), CallChecker.isCalled(weight, RealMatrix.class, 53, 1934, 1939).getRowDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            weight = CallChecker.beforeCalled(weight, RealMatrix.class, 56, 1995, 2000);
            weightMatrix = CallChecker.isCalled(weight, RealMatrix.class, 56, 1995, 2000).copy();
            CallChecker.varAssign(this.weightMatrix, "this.weightMatrix", 56, 1980, 2008);
        } finally {
            _bcornu_methode_context1044.methodEnd();
        }
    }

    public RealMatrix getWeight() {
        MethodContext _bcornu_methode_context4614 = new MethodContext(RealMatrix.class, 64, 2021, 2181);
        try {
            CallChecker.varInit(this, "this", 64, 2021, 2181);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 64, 2021, 2181);
            if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 65, 2156, 2167)) {
                return CallChecker.isCalled(weightMatrix, RealMatrix.class, 65, 2156, 2167).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4614.methodEnd();
        }
    }
}

