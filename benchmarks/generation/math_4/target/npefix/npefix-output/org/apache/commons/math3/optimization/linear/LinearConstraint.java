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
public class LinearConstraint implements Serializable {
    private static final long serialVersionUID = -764632794033034092L;

    private final transient RealVector coefficients;

    private final Relationship relationship;

    private final double value;

    public LinearConstraint(final double[] coefficients, final Relationship relationship, final double value) {
        this(new ArrayRealVector(coefficients), relationship, value);
        ConstructorContext _bcornu_methode_context1188 = new ConstructorContext(LinearConstraint.class, 81, 2861, 3747);
        try {
        } finally {
            _bcornu_methode_context1188.methodEnd();
        }
    }

    public LinearConstraint(final RealVector coefficients, final Relationship relationship, final double value) {
        ConstructorContext _bcornu_methode_context1189 = new ConstructorContext(LinearConstraint.class, 100, 3754, 4691);
        try {
            this.coefficients = coefficients;
            CallChecker.varAssign(this.coefficients, "this.coefficients", 102, 4576, 4608);
            this.relationship = relationship;
            CallChecker.varAssign(this.relationship, "this.relationship", 103, 4618, 4650);
            this.value = value;
            CallChecker.varAssign(this.value, "this.value", 104, 4660, 4685);
        } finally {
            _bcornu_methode_context1189.methodEnd();
        }
    }

    public LinearConstraint(final double[] lhsCoefficients, final double lhsConstant, final Relationship relationship, final double[] rhsCoefficients, final double rhsConstant) {
        ConstructorContext _bcornu_methode_context1190 = new ConstructorContext(LinearConstraint.class, 126, 4698, 6556);
        try {
            double[] sub = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(lhsCoefficients, double[].class, 129, 6250, 6264)) {
                sub = new double[CallChecker.isCalled(lhsCoefficients, double[].class, 129, 6250, 6264).length];
                CallChecker.varAssign(sub, "sub", 129, 6250, 6264);
            }
            sub = CallChecker.beforeCalled(sub, double[].class, 130, 6303, 6305);
            for (int i = 0; i < (CallChecker.isCalled(sub, double[].class, 130, 6303, 6305).length); ++i) {
                if (CallChecker.beforeDeref(sub, double[].class, 131, 6334, 6336)) {
                    if (CallChecker.beforeDeref(lhsCoefficients, double[].class, 131, 6343, 6357)) {
                        if (CallChecker.beforeDeref(rhsCoefficients, double[].class, 131, 6364, 6378)) {
                            sub = CallChecker.beforeCalled(sub, double[].class, 131, 6334, 6336);
                            CallChecker.isCalled(sub, double[].class, 131, 6334, 6336)[i] = (CallChecker.isCalled(lhsCoefficients, double[].class, 131, 6343, 6357)[i]) - (CallChecker.isCalled(rhsCoefficients, double[].class, 131, 6364, 6378)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(sub, double[].class, 131, 6334, 6336)[i], "CallChecker.isCalled(sub, double[].class, 131, 6334, 6336)[i]", 131, 6334, 6382);
                        }
                    }
                }
            }
            this.coefficients = new ArrayRealVector(sub, false);
            CallChecker.varAssign(this.coefficients, "this.coefficients", 133, 6402, 6453);
            this.relationship = relationship;
            CallChecker.varAssign(this.relationship, "this.relationship", 134, 6463, 6495);
            this.value = rhsConstant - lhsConstant;
            CallChecker.varAssign(this.value, "this.value", 135, 6505, 6550);
        } finally {
            _bcornu_methode_context1190.methodEnd();
        }
    }

    public LinearConstraint(final RealVector lhsCoefficients, final double lhsConstant, final Relationship relationship, final RealVector rhsCoefficients, final double rhsConstant) {
        ConstructorContext _bcornu_methode_context1191 = new ConstructorContext(LinearConstraint.class, 157, 6563, 8257);
        try {
            this.coefficients = CallChecker.isCalled(lhsCoefficients, RealVector.class, 160, 8113, 8127).subtract(rhsCoefficients);
            CallChecker.varAssign(this.coefficients, "this.coefficients", 160, 8093, 8154);
            this.relationship = relationship;
            CallChecker.varAssign(this.relationship, "this.relationship", 161, 8164, 8196);
            this.value = rhsConstant - lhsConstant;
            CallChecker.varAssign(this.value, "this.value", 162, 8206, 8251);
        } finally {
            _bcornu_methode_context1191.methodEnd();
        }
    }

    public RealVector getCoefficients() {
        MethodContext _bcornu_methode_context5355 = new MethodContext(RealVector.class, 169, 8264, 8478);
        try {
            CallChecker.varInit(this, "this", 169, 8264, 8478);
            CallChecker.varInit(this.value, "value", 169, 8264, 8478);
            CallChecker.varInit(this.relationship, "relationship", 169, 8264, 8478);
            CallChecker.varInit(this.coefficients, "coefficients", 169, 8264, 8478);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearConstraint.serialVersionUID", 169, 8264, 8478);
            return coefficients;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5355.methodEnd();
        }
    }

    public Relationship getRelationship() {
        MethodContext _bcornu_methode_context5356 = new MethodContext(Relationship.class, 177, 8485, 8699);
        try {
            CallChecker.varInit(this, "this", 177, 8485, 8699);
            CallChecker.varInit(this.value, "value", 177, 8485, 8699);
            CallChecker.varInit(this.relationship, "relationship", 177, 8485, 8699);
            CallChecker.varInit(this.coefficients, "coefficients", 177, 8485, 8699);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearConstraint.serialVersionUID", 177, 8485, 8699);
            return relationship;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Relationship) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5356.methodEnd();
        }
    }

    public double getValue() {
        MethodContext _bcornu_methode_context5357 = new MethodContext(double.class, 185, 8706, 8890);
        try {
            CallChecker.varInit(this, "this", 185, 8706, 8890);
            CallChecker.varInit(this.value, "value", 185, 8706, 8890);
            CallChecker.varInit(this.relationship, "relationship", 185, 8706, 8890);
            CallChecker.varInit(this.coefficients, "coefficients", 185, 8706, 8890);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearConstraint.serialVersionUID", 185, 8706, 8890);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5357.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context5358 = new MethodContext(boolean.class, 190, 8897, 9304);
        try {
            CallChecker.varInit(this, "this", 190, 8897, 9304);
            CallChecker.varInit(other, "other", 190, 8897, 9304);
            CallChecker.varInit(this.value, "value", 190, 8897, 9304);
            CallChecker.varInit(this.relationship, "relationship", 190, 8897, 9304);
            CallChecker.varInit(this.coefficients, "coefficients", 190, 8897, 9304);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearConstraint.serialVersionUID", 190, 8897, 9304);
            if ((this) == other) {
                return true;
            }
            if (other instanceof LinearConstraint) {
                LinearConstraint rhs = CallChecker.varInit(((LinearConstraint) (other)), "rhs", 197, 9064, 9111);
                if (CallChecker.beforeDeref(rhs, LinearConstraint.class, 200, 9253, 9255)) {
                    rhs = CallChecker.beforeCalled(rhs, LinearConstraint.class, 198, 9147, 9149);
                    rhs = CallChecker.beforeCalled(rhs, LinearConstraint.class, 199, 9202, 9204);
                    rhs = CallChecker.beforeCalled(rhs, LinearConstraint.class, 200, 9253, 9255);
                    return (((relationship) == (CallChecker.isCalled(rhs, LinearConstraint.class, 198, 9147, 9149).relationship)) && ((value) == (CallChecker.isCalled(rhs, LinearConstraint.class, 199, 9202, 9204).value))) && (CallChecker.isCalled(coefficients, RealVector.class, 200, 9233, 9244).equals(CallChecker.isCalled(rhs, LinearConstraint.class, 200, 9253, 9255).coefficients));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5358.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5359 = new MethodContext(int.class, 206, 9311, 9484);
        try {
            CallChecker.varInit(this, "this", 206, 9311, 9484);
            CallChecker.varInit(this.value, "value", 206, 9311, 9484);
            CallChecker.varInit(this.relationship, "relationship", 206, 9311, 9484);
            CallChecker.varInit(this.coefficients, "coefficients", 206, 9311, 9484);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearConstraint.serialVersionUID", 206, 9311, 9484);
            return ((CallChecker.isCalled(relationship, Relationship.class, 207, 9364, 9375).hashCode()) ^ (CallChecker.isCalled(Double.valueOf(value), Double.class, 208, 9405, 9425).hashCode())) ^ (CallChecker.isCalled(coefficients, RealVector.class, 209, 9455, 9466).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5359.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context5360 = new MethodContext(void.class, 217, 9491, 9835);
        try {
            CallChecker.varInit(this, "this", 217, 9491, 9835);
            CallChecker.varInit(oos, "oos", 217, 9491, 9835);
            CallChecker.varInit(this.value, "value", 217, 9491, 9835);
            CallChecker.varInit(this.relationship, "relationship", 217, 9491, 9835);
            CallChecker.varInit(this.coefficients, "coefficients", 217, 9491, 9835);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearConstraint.serialVersionUID", 217, 9491, 9835);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 219, 9745, 9747)) {
                oos = CallChecker.beforeCalled(oos, ObjectOutputStream.class, 219, 9745, 9747);
                CallChecker.isCalled(oos, ObjectOutputStream.class, 219, 9745, 9747).defaultWriteObject();
            }
            MatrixUtils.serializeRealVector(coefficients, oos);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5360.methodEnd();
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context5361 = new MethodContext(void.class, 229, 9842, 10305);
        try {
            CallChecker.varInit(this, "this", 229, 9842, 10305);
            CallChecker.varInit(ois, "ois", 229, 9842, 10305);
            CallChecker.varInit(this.value, "value", 229, 9842, 10305);
            CallChecker.varInit(this.relationship, "relationship", 229, 9842, 10305);
            CallChecker.varInit(this.coefficients, "coefficients", 229, 9842, 10305);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.LinearConstraint.serialVersionUID", 229, 9842, 10305);
            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 231, 10206, 10208)) {
                ois = CallChecker.beforeCalled(ois, ObjectInputStream.class, 231, 10206, 10208);
                CallChecker.isCalled(ois, ObjectInputStream.class, 231, 10206, 10208).defaultReadObject();
            }
            MatrixUtils.deserializeRealVector(this, "coefficients", ois);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5361.methodEnd();
        }
    }
}

