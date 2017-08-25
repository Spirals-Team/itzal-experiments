package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;

@Deprecated
public class LeastSquaresConverter implements MultivariateFunction {
    private final MultivariateVectorFunction function;

    private final double[] observations;

    private final double[] weights;

    private final RealMatrix scale;

    public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations) {
        ConstructorContext _bcornu_methode_context337 = new ConstructorContext(LeastSquaresConverter.class, 76, 3088, 3632);
        try {
            this.function = function;
            CallChecker.varAssign(this.function, "this.function", 78, 3480, 3508);
            this.observations = CallChecker.isCalled(observations, double[].class, 79, 3538, 3549).clone();
            CallChecker.varAssign(this.observations, "this.observations", 79, 3518, 3558);
            this.weights = null;
            CallChecker.varAssign(this.weights, "this.weights", 80, 3568, 3592);
            this.scale = null;
            CallChecker.varAssign(this.scale, "this.scale", 81, 3602, 3626);
        } finally {
            _bcornu_methode_context337.methodEnd();
        }
    }

    public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations, final double[] weights) {
        ConstructorContext _bcornu_methode_context338 = new ConstructorContext(LeastSquaresConverter.class, 112, 3639, 5700);
        try {
            if (CallChecker.beforeDeref(observations, double[].class, 114, 5391, 5402)) {
                if (CallChecker.beforeDeref(weights, double[].class, 114, 5414, 5420)) {
                    if ((CallChecker.isCalled(observations, double[].class, 114, 5391, 5402).length) != (CallChecker.isCalled(weights, double[].class, 114, 5414, 5420).length)) {
                        if (CallChecker.beforeDeref(observations, double[].class, 115, 5481, 5492)) {
                            if (CallChecker.beforeDeref(weights, double[].class, 115, 5502, 5508)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(observations, double[].class, 115, 5481, 5492).length, CallChecker.isCalled(weights, double[].class, 115, 5502, 5508).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            this.function = function;
            CallChecker.varAssign(this.function, "this.function", 117, 5537, 5565);
            this.observations = CallChecker.isCalled(observations, double[].class, 118, 5595, 5606).clone();
            CallChecker.varAssign(this.observations, "this.observations", 118, 5575, 5615);
            this.weights = CallChecker.isCalled(weights, double[].class, 119, 5645, 5651).clone();
            CallChecker.varAssign(this.weights, "this.weights", 119, 5625, 5660);
            this.scale = null;
            CallChecker.varAssign(this.scale, "this.scale", 120, 5670, 5694);
        } finally {
            _bcornu_methode_context338.methodEnd();
        }
    }

    public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations, final RealMatrix scale) {
        ConstructorContext _bcornu_methode_context339 = new ConstructorContext(LeastSquaresConverter.class, 142, 5707, 7172);
        try {
            if (CallChecker.beforeDeref(observations, double[].class, 144, 6842, 6853)) {
                if (CallChecker.beforeDeref(scale, RealMatrix.class, 144, 6865, 6869)) {
                    if ((CallChecker.isCalled(observations, double[].class, 144, 6842, 6853).length) != (CallChecker.isCalled(scale, RealMatrix.class, 144, 6865, 6869).getColumnDimension())) {
                        if (CallChecker.beforeDeref(observations, double[].class, 145, 6944, 6955)) {
                            if (CallChecker.beforeDeref(scale, RealMatrix.class, 145, 6965, 6969)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(observations, double[].class, 145, 6944, 6955).length, CallChecker.isCalled(scale, RealMatrix.class, 145, 6965, 6969).getColumnDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            this.function = function;
            CallChecker.varAssign(this.function, "this.function", 147, 7012, 7040);
            this.observations = CallChecker.isCalled(observations, double[].class, 148, 7070, 7081).clone();
            CallChecker.varAssign(this.observations, "this.observations", 148, 7050, 7090);
            this.weights = null;
            CallChecker.varAssign(this.weights, "this.weights", 149, 7100, 7124);
            this.scale = CallChecker.isCalled(scale, RealMatrix.class, 150, 7154, 7158).copy();
            CallChecker.varAssign(this.scale, "this.scale", 150, 7134, 7166);
        } finally {
            _bcornu_methode_context339.methodEnd();
        }
    }

    public double value(final double[] point) {
        MethodContext _bcornu_methode_context1560 = new MethodContext(double.class, 154, 7179, 8178);
        try {
            CallChecker.varInit(this, "this", 154, 7179, 8178);
            CallChecker.varInit(point, "point", 154, 7179, 8178);
            CallChecker.varInit(this.scale, "scale", 154, 7179, 8178);
            CallChecker.varInit(this.weights, "weights", 154, 7179, 8178);
            CallChecker.varInit(this.observations, "observations", 154, 7179, 8178);
            CallChecker.varInit(this.function, "function", 154, 7179, 8178);
            final double[] residuals = CallChecker.varInit(CallChecker.isCalled(function, MultivariateVectorFunction.class, 156, 7312, 7319).value(point), "residuals", 156, 7285, 7333);
            if (CallChecker.beforeDeref(residuals, double[].class, 157, 7347, 7355)) {
                if (CallChecker.beforeDeref(observations, double[].class, 157, 7367, 7378)) {
                    if ((CallChecker.isCalled(residuals, double[].class, 157, 7347, 7355).length) != (CallChecker.isCalled(observations, double[].class, 157, 7367, 7378).length)) {
                        if (CallChecker.beforeDeref(residuals, double[].class, 158, 7439, 7447)) {
                            if (CallChecker.beforeDeref(observations, double[].class, 158, 7457, 7468)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(residuals, double[].class, 158, 7439, 7447).length, CallChecker.isCalled(observations, double[].class, 158, 7457, 7468).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < (CallChecker.isCalled(residuals, double[].class, 160, 7517, 7525).length); ++i) {
                if (CallChecker.beforeDeref(residuals, double[].class, 161, 7554, 7562)) {
                    if (CallChecker.beforeDeref(observations, double[].class, 161, 7570, 7581)) {
                        CallChecker.isCalled(residuals, double[].class, 161, 7554, 7562)[i] -= CallChecker.isCalled(observations, double[].class, 161, 7570, 7581)[i];
                        CallChecker.varAssign(CallChecker.isCalled(residuals, double[].class, 161, 7554, 7562)[i], "CallChecker.isCalled(residuals, double[].class, 161, 7554, 7562)[i]", 161, 7554, 7585);
                    }
                }
            }
            double sumSquares = CallChecker.varInit(((double) (0)), "sumSquares", 165, 7640, 7661);
            if ((weights) != null) {
                for (int i = 0; i < (CallChecker.isCalled(residuals, double[].class, 167, 7726, 7734).length); ++i) {
                    final double ri = CallChecker.varInit(((double) (CallChecker.isCalled(residuals, double[].class, 168, 7785, 7793)[i])), "ri", 168, 7767, 7797);
                    sumSquares += ((weights[i]) * ri) * ri;
                    CallChecker.varAssign(sumSquares, "sumSquares", 169, 7815, 7850);
                }
            }else
                if ((scale) != null) {
                    for (final double yi : scale.operate(residuals)) {
                        sumSquares += yi * yi;
                        CallChecker.varAssign(sumSquares, "sumSquares", 173, 7981, 8002);
                    }
                }else {
                    if (CallChecker.beforeDeref(residuals, double.class, 176, 8070, 8078)) {
                        for (final double ri : residuals) {
                            sumSquares += ri * ri;
                            CallChecker.varAssign(sumSquares, "sumSquares", 177, 8099, 8120);
                        }
                    }
                }
            
            return sumSquares;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1560.methodEnd();
        }
    }
}

