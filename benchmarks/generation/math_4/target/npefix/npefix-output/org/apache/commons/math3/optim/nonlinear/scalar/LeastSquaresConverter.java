package org.apache.commons.math3.optim.nonlinear.scalar;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;

public class LeastSquaresConverter implements MultivariateFunction {
    private final MultivariateVectorFunction function;

    private final double[] observations;

    private final double[] weights;

    private final RealMatrix scale;

    public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations) {
        ConstructorContext _bcornu_methode_context340 = new ConstructorContext(LeastSquaresConverter.class, 72, 3021, 3589);
        try {
            this.function = function;
            CallChecker.varAssign(this.function, "this.function", 74, 3437, 3465);
            this.observations = CallChecker.isCalled(observations, double[].class, 75, 3495, 3506).clone();
            CallChecker.varAssign(this.observations, "this.observations", 75, 3475, 3515);
            this.weights = null;
            CallChecker.varAssign(this.weights, "this.weights", 76, 3525, 3549);
            this.scale = null;
            CallChecker.varAssign(this.scale, "this.scale", 77, 3559, 3583);
        } finally {
            _bcornu_methode_context340.methodEnd();
        }
    }

    public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations, final double[] weights) {
        ConstructorContext _bcornu_methode_context341 = new ConstructorContext(LeastSquaresConverter.class, 111, 3596, 5710);
        try {
            if (CallChecker.beforeDeref(observations, double[].class, 114, 5401, 5412)) {
                if (CallChecker.beforeDeref(weights, double[].class, 114, 5424, 5430)) {
                    if ((CallChecker.isCalled(observations, double[].class, 114, 5401, 5412).length) != (CallChecker.isCalled(weights, double[].class, 114, 5424, 5430).length)) {
                        if (CallChecker.beforeDeref(observations, double[].class, 115, 5491, 5502)) {
                            if (CallChecker.beforeDeref(weights, double[].class, 115, 5512, 5518)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(observations, double[].class, 115, 5491, 5502).length, CallChecker.isCalled(weights, double[].class, 115, 5512, 5518).length);
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
            CallChecker.varAssign(this.function, "this.function", 117, 5547, 5575);
            this.observations = CallChecker.isCalled(observations, double[].class, 118, 5605, 5616).clone();
            CallChecker.varAssign(this.observations, "this.observations", 118, 5585, 5625);
            this.weights = CallChecker.isCalled(weights, double[].class, 119, 5655, 5661).clone();
            CallChecker.varAssign(this.weights, "this.weights", 119, 5635, 5670);
            this.scale = null;
            CallChecker.varAssign(this.scale, "this.scale", 120, 5680, 5704);
        } finally {
            _bcornu_methode_context341.methodEnd();
        }
    }

    public LeastSquaresConverter(final MultivariateVectorFunction function, final double[] observations, final RealMatrix scale) {
        ConstructorContext _bcornu_methode_context342 = new ConstructorContext(LeastSquaresConverter.class, 145, 5717, 7238);
        try {
            if (CallChecker.beforeDeref(observations, double[].class, 148, 6908, 6919)) {
                if (CallChecker.beforeDeref(scale, RealMatrix.class, 148, 6931, 6935)) {
                    if ((CallChecker.isCalled(observations, double[].class, 148, 6908, 6919).length) != (CallChecker.isCalled(scale, RealMatrix.class, 148, 6931, 6935).getColumnDimension())) {
                        if (CallChecker.beforeDeref(observations, double[].class, 149, 7010, 7021)) {
                            if (CallChecker.beforeDeref(scale, RealMatrix.class, 149, 7031, 7035)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(observations, double[].class, 149, 7010, 7021).length, CallChecker.isCalled(scale, RealMatrix.class, 149, 7031, 7035).getColumnDimension());
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
            CallChecker.varAssign(this.function, "this.function", 151, 7078, 7106);
            this.observations = CallChecker.isCalled(observations, double[].class, 152, 7136, 7147).clone();
            CallChecker.varAssign(this.observations, "this.observations", 152, 7116, 7156);
            this.weights = null;
            CallChecker.varAssign(this.weights, "this.weights", 153, 7166, 7190);
            this.scale = CallChecker.isCalled(scale, RealMatrix.class, 154, 7220, 7224).copy();
            CallChecker.varAssign(this.scale, "this.scale", 154, 7200, 7232);
        } finally {
            _bcornu_methode_context342.methodEnd();
        }
    }

    public double value(final double[] point) {
        MethodContext _bcornu_methode_context1561 = new MethodContext(double.class, 158, 7245, 8244);
        try {
            CallChecker.varInit(this, "this", 158, 7245, 8244);
            CallChecker.varInit(point, "point", 158, 7245, 8244);
            CallChecker.varInit(this.scale, "scale", 158, 7245, 8244);
            CallChecker.varInit(this.weights, "weights", 158, 7245, 8244);
            CallChecker.varInit(this.observations, "observations", 158, 7245, 8244);
            CallChecker.varInit(this.function, "function", 158, 7245, 8244);
            final double[] residuals = CallChecker.varInit(CallChecker.isCalled(function, MultivariateVectorFunction.class, 160, 7378, 7385).value(point), "residuals", 160, 7351, 7399);
            if (CallChecker.beforeDeref(residuals, double[].class, 161, 7413, 7421)) {
                if (CallChecker.beforeDeref(observations, double[].class, 161, 7433, 7444)) {
                    if ((CallChecker.isCalled(residuals, double[].class, 161, 7413, 7421).length) != (CallChecker.isCalled(observations, double[].class, 161, 7433, 7444).length)) {
                        if (CallChecker.beforeDeref(residuals, double[].class, 162, 7505, 7513)) {
                            if (CallChecker.beforeDeref(observations, double[].class, 162, 7523, 7534)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(residuals, double[].class, 162, 7505, 7513).length, CallChecker.isCalled(observations, double[].class, 162, 7523, 7534).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < (CallChecker.isCalled(residuals, double[].class, 164, 7583, 7591).length); ++i) {
                if (CallChecker.beforeDeref(residuals, double[].class, 165, 7620, 7628)) {
                    if (CallChecker.beforeDeref(observations, double[].class, 165, 7636, 7647)) {
                        CallChecker.isCalled(residuals, double[].class, 165, 7620, 7628)[i] -= CallChecker.isCalled(observations, double[].class, 165, 7636, 7647)[i];
                        CallChecker.varAssign(CallChecker.isCalled(residuals, double[].class, 165, 7620, 7628)[i], "CallChecker.isCalled(residuals, double[].class, 165, 7620, 7628)[i]", 165, 7620, 7651);
                    }
                }
            }
            double sumSquares = CallChecker.varInit(((double) (0)), "sumSquares", 169, 7706, 7727);
            if ((weights) != null) {
                for (int i = 0; i < (CallChecker.isCalled(residuals, double[].class, 171, 7792, 7800).length); ++i) {
                    final double ri = CallChecker.varInit(((double) (CallChecker.isCalled(residuals, double[].class, 172, 7851, 7859)[i])), "ri", 172, 7833, 7863);
                    sumSquares += ((weights[i]) * ri) * ri;
                    CallChecker.varAssign(sumSquares, "sumSquares", 173, 7881, 7916);
                }
            }else
                if ((scale) != null) {
                    for (final double yi : scale.operate(residuals)) {
                        sumSquares += yi * yi;
                        CallChecker.varAssign(sumSquares, "sumSquares", 177, 8047, 8068);
                    }
                }else {
                    if (CallChecker.beforeDeref(residuals, double.class, 180, 8136, 8144)) {
                        for (final double ri : residuals) {
                            sumSquares += ri * ri;
                            CallChecker.varAssign(sumSquares, "sumSquares", 181, 8165, 8186);
                        }
                    }
                }
            
            return sumSquares;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1561.methodEnd();
        }
    }
}

