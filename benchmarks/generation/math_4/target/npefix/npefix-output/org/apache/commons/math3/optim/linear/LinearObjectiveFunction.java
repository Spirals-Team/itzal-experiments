package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.OptimizationData;

public class LinearObjectiveFunction implements Serializable , MultivariateFunction , OptimizationData {
    private static final long serialVersionUID = -4531815507568396090L;

    private final transient RealVector coefficients;

    private final double constantTerm;

    public LinearObjectiveFunction(double[] coefficients, double constantTerm) {
        this(new ArrayRealVector(coefficients), constantTerm);
        ConstructorContext _bcornu_methode_context801 = new ConstructorContext(LinearObjectiveFunction.class, 58, 2099, 2405);
        try {
        } finally {
            _bcornu_methode_context801.methodEnd();
        }
    }

    public LinearObjectiveFunction(RealVector coefficients, double constantTerm) {
        ConstructorContext _bcornu_methode_context802 = new ConstructorContext(LinearObjectiveFunction.class, 66, 2412, 2741);
        try {
            this.coefficients = coefficients;
            CallChecker.varAssign(this.coefficients, "this.coefficients", 67, 2661, 2693);
            this.constantTerm = constantTerm;
            CallChecker.varAssign(this.constantTerm, "this.constantTerm", 68, 2703, 2735);
        } finally {
            _bcornu_methode_context802.methodEnd();
        }
    }

    public RealVector getCoefficients() {
        MethodContext _bcornu_methode_context3521 = new MethodContext(RealVector.class, 76, 2748, 2979);
        try {
            CallChecker.varInit(this, "this", 76, 2748, 2979);
            CallChecker.varInit(this.constantTerm, "constantTerm", 76, 2748, 2979);
            CallChecker.varInit(this.coefficients, "coefficients", 76, 2748, 2979);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 76, 2748, 2979);
            return coefficients;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3521.methodEnd();
        }
    }

    public double getConstantTerm() {
        MethodContext _bcornu_methode_context3522 = new MethodContext(double.class, 85, 2986, 3205);
        try {
            CallChecker.varInit(this, "this", 85, 2986, 3205);
            CallChecker.varInit(this.constantTerm, "constantTerm", 85, 2986, 3205);
            CallChecker.varInit(this.coefficients, "coefficients", 85, 2986, 3205);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 85, 2986, 3205);
            return constantTerm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3522.methodEnd();
        }
    }

    public double value(final double[] point) {
        MethodContext _bcornu_methode_context3523 = new MethodContext(double.class, 95, 3212, 3551);
        try {
            CallChecker.varInit(this, "this", 95, 3212, 3551);
            CallChecker.varInit(point, "point", 95, 3212, 3551);
            CallChecker.varInit(this.constantTerm, "constantTerm", 95, 3212, 3551);
            CallChecker.varInit(this.coefficients, "coefficients", 95, 3212, 3551);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 95, 3212, 3551);
            return value(new ArrayRealVector(point, false));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3523.methodEnd();
        }
    }

    public double value(final RealVector point) {
        MethodContext _bcornu_methode_context3524 = new MethodContext(double.class, 105, 3558, 3904);
        try {
            CallChecker.varInit(this, "this", 105, 3558, 3904);
            CallChecker.varInit(point, "point", 105, 3558, 3904);
            CallChecker.varInit(this.constantTerm, "constantTerm", 105, 3558, 3904);
            CallChecker.varInit(this.coefficients, "coefficients", 105, 3558, 3904);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 105, 3558, 3904);
            return (CallChecker.isCalled(coefficients, RealVector.class, 106, 3853, 3864).dotProduct(point)) + (constantTerm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3524.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context3525 = new MethodContext(boolean.class, 110, 3911, 4289);
        try {
            CallChecker.varInit(this, "this", 110, 3911, 4289);
            CallChecker.varInit(other, "other", 110, 3911, 4289);
            CallChecker.varInit(this.constantTerm, "constantTerm", 110, 3911, 4289);
            CallChecker.varInit(this.coefficients, "coefficients", 110, 3911, 4289);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 110, 3911, 4289);
            if ((this) == other) {
                return true;
            }
            if (other instanceof LinearObjectiveFunction) {
                LinearObjectiveFunction rhs = CallChecker.varInit(((LinearObjectiveFunction) (other)), "rhs", 115, 4095, 4156);
                if (CallChecker.beforeDeref(rhs, LinearObjectiveFunction.class, 116, 4233, 4235)) {
                    rhs = CallChecker.beforeCalled(rhs, LinearObjectiveFunction.class, 116, 4192, 4194);
                    rhs = CallChecker.beforeCalled(rhs, LinearObjectiveFunction.class, 116, 4233, 4235);
                    return ((constantTerm) == (CallChecker.isCalled(rhs, LinearObjectiveFunction.class, 116, 4192, 4194).constantTerm)) && (CallChecker.isCalled(coefficients, RealVector.class, 116, 4213, 4224).equals(CallChecker.isCalled(rhs, LinearObjectiveFunction.class, 116, 4233, 4235).coefficients));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3525.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3526 = new MethodContext(int.class, 123, 4296, 4420);
        try {
            CallChecker.varInit(this, "this", 123, 4296, 4420);
            CallChecker.varInit(this.constantTerm, "constantTerm", 123, 4296, 4420);
            CallChecker.varInit(this.coefficients, "coefficients", 123, 4296, 4420);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 123, 4296, 4420);
            return (CallChecker.isCalled(Double.valueOf(constantTerm), Double.class, 124, 4349, 4376).hashCode()) ^ (CallChecker.isCalled(coefficients, RealVector.class, 124, 4391, 4402).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3526.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context3527 = new MethodContext(void.class, 132, 4427, 4771);
        try {
            CallChecker.varInit(this, "this", 132, 4427, 4771);
            CallChecker.varInit(oos, "oos", 132, 4427, 4771);
            CallChecker.varInit(this.constantTerm, "constantTerm", 132, 4427, 4771);
            CallChecker.varInit(this.coefficients, "coefficients", 132, 4427, 4771);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 132, 4427, 4771);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 134, 4681, 4683)) {
                oos = CallChecker.beforeCalled(oos, ObjectOutputStream.class, 134, 4681, 4683);
                CallChecker.isCalled(oos, ObjectOutputStream.class, 134, 4681, 4683).defaultWriteObject();
            }
            MatrixUtils.serializeRealVector(coefficients, oos);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3527.methodEnd();
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context3528 = new MethodContext(void.class, 144, 4778, 5241);
        try {
            CallChecker.varInit(this, "this", 144, 4778, 5241);
            CallChecker.varInit(ois, "ois", 144, 4778, 5241);
            CallChecker.varInit(this.constantTerm, "constantTerm", 144, 4778, 5241);
            CallChecker.varInit(this.coefficients, "coefficients", 144, 4778, 5241);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearObjectiveFunction.serialVersionUID", 144, 4778, 5241);
            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 146, 5142, 5144)) {
                ois = CallChecker.beforeCalled(ois, ObjectInputStream.class, 146, 5142, 5144);
                CallChecker.isCalled(ois, ObjectInputStream.class, 146, 5142, 5144).defaultReadObject();
            }
            MatrixUtils.deserializeRealVector(this, "coefficients", ois);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3528.methodEnd();
        }
    }
}

