package org.apache.commons.math3.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

@Deprecated
public class LinearObjectiveFunction implements Serializable {
    private static final long serialVersionUID = -4531815507568396090L;

    private final transient RealVector coefficients;

    private final double constantTerm;

    public LinearObjectiveFunction(double[] coefficients, double constantTerm) {
        this(new ArrayRealVector(coefficients), constantTerm);
        ConstructorContext _bcornu_methode_context799 = new ConstructorContext(LinearObjectiveFunction.class, 59, 1971, 2283);
        try {
        } finally {
            _bcornu_methode_context799.methodEnd();
        }
    }

    public LinearObjectiveFunction(RealVector coefficients, double constantTerm) {
        ConstructorContext _bcornu_methode_context800 = new ConstructorContext(LinearObjectiveFunction.class, 67, 2290, 2625);
        try {
            this.coefficients = coefficients;
            CallChecker.varAssign(this.coefficients, "this.coefficients", 68, 2545, 2577);
            this.constantTerm = constantTerm;
            CallChecker.varAssign(this.constantTerm, "this.constantTerm", 69, 2587, 2619);
        } finally {
            _bcornu_methode_context800.methodEnd();
        }
    }

    public RealVector getCoefficients() {
        MethodContext _bcornu_methode_context3513 = new MethodContext(RealVector.class, 76, 2632, 2854);
        try {
            CallChecker.varInit(this, "this", 76, 2632, 2854);
            CallChecker.varInit(this.constantTerm, "constantTerm", 76, 2632, 2854);
            CallChecker.varInit(this.coefficients, "coefficients", 76, 2632, 2854);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 76, 2632, 2854);
            return coefficients;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3513.methodEnd();
        }
    }

    public double getConstantTerm() {
        MethodContext _bcornu_methode_context3514 = new MethodContext(double.class, 84, 2861, 3071);
        try {
            CallChecker.varInit(this, "this", 84, 2861, 3071);
            CallChecker.varInit(this.constantTerm, "constantTerm", 84, 2861, 3071);
            CallChecker.varInit(this.coefficients, "coefficients", 84, 2861, 3071);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 84, 2861, 3071);
            return constantTerm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3514.methodEnd();
        }
    }

    public double getValue(final double[] point) {
        MethodContext _bcornu_methode_context3515 = new MethodContext(double.class, 93, 3078, 3438);
        try {
            CallChecker.varInit(this, "this", 93, 3078, 3438);
            CallChecker.varInit(point, "point", 93, 3078, 3438);
            CallChecker.varInit(this.constantTerm, "constantTerm", 93, 3078, 3438);
            CallChecker.varInit(this.coefficients, "coefficients", 93, 3078, 3438);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 93, 3078, 3438);
            return (CallChecker.isCalled(coefficients, RealVector.class, 94, 3359, 3370).dotProduct(new ArrayRealVector(point, false))) + (constantTerm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3515.methodEnd();
        }
    }

    public double getValue(final RealVector point) {
        MethodContext _bcornu_methode_context3516 = new MethodContext(double.class, 102, 3445, 3779);
        try {
            CallChecker.varInit(this, "this", 102, 3445, 3779);
            CallChecker.varInit(point, "point", 102, 3445, 3779);
            CallChecker.varInit(this.constantTerm, "constantTerm", 102, 3445, 3779);
            CallChecker.varInit(this.coefficients, "coefficients", 102, 3445, 3779);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 102, 3445, 3779);
            return (CallChecker.isCalled(coefficients, RealVector.class, 103, 3728, 3739).dotProduct(point)) + (constantTerm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3516.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context3517 = new MethodContext(boolean.class, 107, 3786, 4150);
        try {
            CallChecker.varInit(this, "this", 107, 3786, 4150);
            CallChecker.varInit(other, "other", 107, 3786, 4150);
            CallChecker.varInit(this.constantTerm, "constantTerm", 107, 3786, 4150);
            CallChecker.varInit(this.coefficients, "coefficients", 107, 3786, 4150);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 107, 3786, 4150);
            if ((this) == other) {
                return true;
            }
            if (other instanceof LinearObjectiveFunction) {
                LinearObjectiveFunction rhs = CallChecker.varInit(((LinearObjectiveFunction) (other)), "rhs", 114, 3960, 4021);
                if (CallChecker.beforeDeref(rhs, LinearObjectiveFunction.class, 115, 4098, 4100)) {
                    rhs = CallChecker.beforeCalled(rhs, LinearObjectiveFunction.class, 115, 4057, 4059);
                    rhs = CallChecker.beforeCalled(rhs, LinearObjectiveFunction.class, 115, 4098, 4100);
                    return ((constantTerm) == (CallChecker.isCalled(rhs, LinearObjectiveFunction.class, 115, 4057, 4059).constantTerm)) && (CallChecker.isCalled(coefficients, RealVector.class, 115, 4078, 4089).equals(CallChecker.isCalled(rhs, LinearObjectiveFunction.class, 115, 4098, 4100).coefficients));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3517.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3518 = new MethodContext(int.class, 122, 4157, 4281);
        try {
            CallChecker.varInit(this, "this", 122, 4157, 4281);
            CallChecker.varInit(this.constantTerm, "constantTerm", 122, 4157, 4281);
            CallChecker.varInit(this.coefficients, "coefficients", 122, 4157, 4281);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 122, 4157, 4281);
            return (CallChecker.isCalled(Double.valueOf(constantTerm), Double.class, 123, 4210, 4237).hashCode()) ^ (CallChecker.isCalled(coefficients, RealVector.class, 123, 4252, 4263).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3518.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context3519 = new MethodContext(void.class, 131, 4288, 4632);
        try {
            CallChecker.varInit(this, "this", 131, 4288, 4632);
            CallChecker.varInit(oos, "oos", 131, 4288, 4632);
            CallChecker.varInit(this.constantTerm, "constantTerm", 131, 4288, 4632);
            CallChecker.varInit(this.coefficients, "coefficients", 131, 4288, 4632);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 131, 4288, 4632);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 133, 4542, 4544)) {
                oos = CallChecker.beforeCalled(oos, ObjectOutputStream.class, 133, 4542, 4544);
                CallChecker.isCalled(oos, ObjectOutputStream.class, 133, 4542, 4544).defaultWriteObject();
            }
            MatrixUtils.serializeRealVector(coefficients, oos);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3519.methodEnd();
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context3520 = new MethodContext(void.class, 143, 4639, 5102);
        try {
            CallChecker.varInit(this, "this", 143, 4639, 5102);
            CallChecker.varInit(ois, "ois", 143, 4639, 5102);
            CallChecker.varInit(this.constantTerm, "constantTerm", 143, 4639, 5102);
            CallChecker.varInit(this.coefficients, "coefficients", 143, 4639, 5102);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearObjectiveFunction.serialVersionUID", 143, 4639, 5102);
            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 145, 5003, 5005)) {
                ois = CallChecker.beforeCalled(ois, ObjectInputStream.class, 145, 5003, 5005);
                CallChecker.isCalled(ois, ObjectInputStream.class, 145, 5003, 5005).defaultReadObject();
            }
            MatrixUtils.deserializeRealVector(this, "coefficients", ois);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3520.methodEnd();
        }
    }
}

