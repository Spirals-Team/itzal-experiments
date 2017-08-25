package org.apache.commons.math3.optim.nonlinear.vector;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.BaseMultivariateOptimizer;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointVectorValuePair;

public abstract class MultivariateVectorOptimizer extends BaseMultivariateOptimizer<PointVectorValuePair> {
    private double[] target;

    private RealMatrix weightMatrix;

    private MultivariateVectorFunction model;

    protected MultivariateVectorOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context864 = new ConstructorContext(MultivariateVectorOptimizer.class, 47, 1807, 1984);
        try {
        } finally {
            _bcornu_methode_context864.methodEnd();
        }
    }

    protected double[] computeObjectiveValue(double[] params) {
        MethodContext _bcornu_methode_context3826 = new MethodContext(double[].class, 61, 1991, 2584);
        try {
            CallChecker.varInit(this, "this", 61, 1991, 2584);
            CallChecker.varInit(params, "params", 61, 1991, 2584);
            CallChecker.varInit(this.iterations, "iterations", 61, 1991, 2584);
            CallChecker.varInit(this.evaluations, "evaluations", 61, 1991, 2584);
            CallChecker.varInit(this.model, "model", 61, 1991, 2584);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 61, 1991, 2584);
            CallChecker.varInit(this.target, "target", 61, 1991, 2584);
            super.incrementEvaluationCount();
            if (CallChecker.beforeDeref(model, MultivariateVectorFunction.class, 63, 2559, 2563)) {
                model = CallChecker.beforeCalled(model, MultivariateVectorFunction.class, 63, 2559, 2563);
                return CallChecker.isCalled(model, MultivariateVectorFunction.class, 63, 2559, 2563).value(params);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3826.methodEnd();
        }
    }

    public PointVectorValuePair optimize(OptimizationData... optData) throws DimensionMismatchException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context3827 = new MethodContext(PointVectorValuePair.class, 83, 2591, 3513);
        try {
            CallChecker.varInit(this, "this", 83, 2591, 3513);
            CallChecker.varInit(optData, "optData", 83, 2591, 3513);
            CallChecker.varInit(this.iterations, "iterations", 83, 2591, 3513);
            CallChecker.varInit(this.evaluations, "evaluations", 83, 2591, 3513);
            CallChecker.varInit(this.model, "model", 83, 2591, 3513);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 83, 2591, 3513);
            CallChecker.varInit(this.target, "target", 83, 2591, 3513);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3827.methodEnd();
        }
    }

    public RealMatrix getWeight() {
        MethodContext _bcornu_methode_context3828 = new MethodContext(RealMatrix.class, 95, 3520, 3700);
        try {
            CallChecker.varInit(this, "this", 95, 3520, 3700);
            CallChecker.varInit(this.iterations, "iterations", 95, 3520, 3700);
            CallChecker.varInit(this.evaluations, "evaluations", 95, 3520, 3700);
            CallChecker.varInit(this.model, "model", 95, 3520, 3700);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 95, 3520, 3700);
            CallChecker.varInit(this.target, "target", 95, 3520, 3700);
            if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 96, 3675, 3686)) {
                weightMatrix = CallChecker.beforeCalled(weightMatrix, RealMatrix.class, 96, 3675, 3686);
                return CallChecker.isCalled(weightMatrix, RealMatrix.class, 96, 3675, 3686).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3828.methodEnd();
        }
    }

    public double[] getTarget() {
        MethodContext _bcornu_methode_context3829 = new MethodContext(double[].class, 104, 3706, 3915);
        try {
            CallChecker.varInit(this, "this", 104, 3706, 3915);
            CallChecker.varInit(this.iterations, "iterations", 104, 3706, 3915);
            CallChecker.varInit(this.evaluations, "evaluations", 104, 3706, 3915);
            CallChecker.varInit(this.model, "model", 104, 3706, 3915);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 104, 3706, 3915);
            CallChecker.varInit(this.target, "target", 104, 3706, 3915);
            if (CallChecker.beforeDeref(target, double[].class, 105, 3895, 3900)) {
                target = CallChecker.beforeCalled(target, double[].class, 105, 3895, 3900);
                return CallChecker.isCalled(target, double[].class, 105, 3895, 3900).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3829.methodEnd();
        }
    }

    public int getTargetSize() {
        MethodContext _bcornu_methode_context3830 = new MethodContext(int.class, 113, 3922, 4099);
        try {
            CallChecker.varInit(this, "this", 113, 3922, 4099);
            CallChecker.varInit(this.iterations, "iterations", 113, 3922, 4099);
            CallChecker.varInit(this.evaluations, "evaluations", 113, 3922, 4099);
            CallChecker.varInit(this.model, "model", 113, 3922, 4099);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 113, 3922, 4099);
            CallChecker.varInit(this.target, "target", 113, 3922, 4099);
            if (CallChecker.beforeDeref(target, double[].class, 114, 4080, 4085)) {
                target = CallChecker.beforeCalled(target, double[].class, 114, 4080, 4085);
                return CallChecker.isCalled(target, double[].class, 114, 4080, 4085).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3830.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context3831 = new MethodContext(void.class, 129, 4106, 5306);
        try {
            CallChecker.varInit(this, "this", 129, 4106, 5306);
            CallChecker.varInit(optData, "optData", 129, 4106, 5306);
            CallChecker.varInit(this.iterations, "iterations", 129, 4106, 5306);
            CallChecker.varInit(this.evaluations, "evaluations", 129, 4106, 5306);
            CallChecker.varInit(this.model, "model", 129, 4106, 5306);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 129, 4106, 5306);
            CallChecker.varInit(this.target, "target", 129, 4106, 5306);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 135, 4783, 4789)) {
                for (OptimizationData data : optData) {
                    if (data instanceof ModelFunction) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 137, 4884, 4887)) {
                            model = CallChecker.isCalled(((ModelFunction) (data)), ModelFunction.class, 137, 4884, 4887).getModelFunction();
                            CallChecker.varAssign(this.model, "this.model", 137, 4859, 4908);
                        }
                        continue;
                    }
                    if (data instanceof Target) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 141, 5027, 5030)) {
                            target = CallChecker.isCalled(((Target) (data)), Target.class, 141, 5027, 5030).getTarget();
                            CallChecker.varAssign(this.target, "this.target", 141, 5008, 5044);
                        }
                        continue;
                    }
                    if (data instanceof Weight) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 145, 5169, 5172)) {
                            weightMatrix = CallChecker.isCalled(((Weight) (data)), Weight.class, 145, 5169, 5172).getWeight();
                            CallChecker.varAssign(this.weightMatrix, "this.weightMatrix", 145, 5144, 5186);
                        }
                        continue;
                    }
                }
            }
            checkParameters();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3831.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context3832 = new MethodContext(void.class, 160, 5313, 5759);
        try {
            CallChecker.varInit(this, "this", 160, 5313, 5759);
            CallChecker.varInit(this.iterations, "iterations", 160, 5313, 5759);
            CallChecker.varInit(this.evaluations, "evaluations", 160, 5313, 5759);
            CallChecker.varInit(this.model, "model", 160, 5313, 5759);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 160, 5313, 5759);
            CallChecker.varInit(this.target, "target", 160, 5313, 5759);
            if (CallChecker.beforeDeref(target, double[].class, 161, 5542, 5547)) {
                if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 161, 5559, 5570)) {
                    target = CallChecker.beforeCalled(target, double[].class, 161, 5542, 5547);
                    weightMatrix = CallChecker.beforeCalled(weightMatrix, RealMatrix.class, 161, 5559, 5570);
                    if ((CallChecker.isCalled(target, double[].class, 161, 5542, 5547).length) != (CallChecker.isCalled(weightMatrix, RealMatrix.class, 161, 5559, 5570).getColumnDimension())) {
                        if (CallChecker.beforeDeref(target, double[].class, 162, 5645, 5650)) {
                            if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 163, 5709, 5720)) {
                                target = CallChecker.beforeCalled(target, double[].class, 162, 5645, 5650);
                                weightMatrix = CallChecker.beforeCalled(weightMatrix, RealMatrix.class, 163, 5709, 5720);
                                throw new DimensionMismatchException(CallChecker.isCalled(target, double[].class, 162, 5645, 5650).length, CallChecker.isCalled(weightMatrix, RealMatrix.class, 163, 5709, 5720).getColumnDimension());
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
            _bcornu_methode_context3832.methodEnd();
        }
    }
}

