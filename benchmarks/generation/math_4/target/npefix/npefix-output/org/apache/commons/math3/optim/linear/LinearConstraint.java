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
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

public class LinearConstraint implements Serializable {
    private static final long serialVersionUID = -764632794033034092L;

    private final transient RealVector coefficients;

    private final Relationship relationship;

    private final double value;

    public LinearConstraint(final double[] coefficients, final Relationship relationship, final double value) {
        this(new ArrayRealVector(coefficients), relationship, value);
        ConstructorContext _bcornu_methode_context1192 = new ConstructorContext(LinearConstraint.class, 73, 2789, 3703);
        try {
        } finally {
            _bcornu_methode_context1192.methodEnd();
        }
    }

    public LinearConstraint(final RealVector coefficients, final Relationship relationship, final double value) {
        ConstructorContext _bcornu_methode_context1193 = new ConstructorContext(LinearConstraint.class, 93, 3710, 4675);
        try {
            this.coefficients = coefficients;
            CallChecker.varAssign(this.coefficients, "this.coefficients", 96, 4560, 4592);
            this.relationship = relationship;
            CallChecker.varAssign(this.relationship, "this.relationship", 97, 4602, 4634);
            this.value = value;
            CallChecker.varAssign(this.value, "this.value", 98, 4644, 4669);
        } finally {
            _bcornu_methode_context1193.methodEnd();
        }
    }

    public LinearConstraint(final double[] lhsCoefficients, final double lhsConstant, final Relationship relationship, final double[] rhsCoefficients, final double rhsConstant) {
        ConstructorContext _bcornu_methode_context1194 = new ConstructorContext(LinearConstraint.class, 120, 4682, 6540);
        try {
            double[] sub = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(lhsCoefficients, double[].class, 123, 6234, 6248)) {
                sub = new double[CallChecker.isCalled(lhsCoefficients, double[].class, 123, 6234, 6248).length];
                CallChecker.varAssign(sub, "sub", 123, 6234, 6248);
            }
            sub = CallChecker.beforeCalled(sub, double[].class, 124, 6287, 6289);
            for (int i = 0; i < (CallChecker.isCalled(sub, double[].class, 124, 6287, 6289).length); ++i) {
                if (CallChecker.beforeDeref(sub, double[].class, 125, 6318, 6320)) {
                    if (CallChecker.beforeDeref(lhsCoefficients, double[].class, 125, 6327, 6341)) {
                        if (CallChecker.beforeDeref(rhsCoefficients, double[].class, 125, 6348, 6362)) {
                            sub = CallChecker.beforeCalled(sub, double[].class, 125, 6318, 6320);
                            CallChecker.isCalled(sub, double[].class, 125, 6318, 6320)[i] = (CallChecker.isCalled(lhsCoefficients, double[].class, 125, 6327, 6341)[i]) - (CallChecker.isCalled(rhsCoefficients, double[].class, 125, 6348, 6362)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(sub, double[].class, 125, 6318, 6320)[i], "CallChecker.isCalled(sub, double[].class, 125, 6318, 6320)[i]", 125, 6318, 6366);
                        }
                    }
                }
            }
            this.coefficients = new ArrayRealVector(sub, false);
            CallChecker.varAssign(this.coefficients, "this.coefficients", 127, 6386, 6437);
            this.relationship = relationship;
            CallChecker.varAssign(this.relationship, "this.relationship", 128, 6447, 6479);
            this.value = rhsConstant - lhsConstant;
            CallChecker.varAssign(this.value, "this.value", 129, 6489, 6534);
        } finally {
            _bcornu_methode_context1194.methodEnd();
        }
    }

    public LinearConstraint(final RealVector lhsCoefficients, final double lhsConstant, final Relationship relationship, final RealVector rhsCoefficients, final double rhsConstant) {
        ConstructorContext _bcornu_methode_context1195 = new ConstructorContext(LinearConstraint.class, 151, 6547, 8241);
        try {
            this.coefficients = CallChecker.isCalled(lhsCoefficients, RealVector.class, 154, 8097, 8111).subtract(rhsCoefficients);
            CallChecker.varAssign(this.coefficients, "this.coefficients", 154, 8077, 8138);
            this.relationship = relationship;
            CallChecker.varAssign(this.relationship, "this.relationship", 155, 8148, 8180);
            this.value = rhsConstant - lhsConstant;
            CallChecker.varAssign(this.value, "this.value", 156, 8190, 8235);
        } finally {
            _bcornu_methode_context1195.methodEnd();
        }
    }

    public RealVector getCoefficients() {
        MethodContext _bcornu_methode_context5362 = new MethodContext(RealVector.class, 164, 8248, 8475);
        try {
            CallChecker.varInit(this, "this", 164, 8248, 8475);
            CallChecker.varInit(this.value, "value", 164, 8248, 8475);
            CallChecker.varInit(this.relationship, "relationship", 164, 8248, 8475);
            CallChecker.varInit(this.coefficients, "coefficients", 164, 8248, 8475);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearConstraint.serialVersionUID", 164, 8248, 8475);
            return coefficients;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5362.methodEnd();
        }
    }

    public Relationship getRelationship() {
        MethodContext _bcornu_methode_context5363 = new MethodContext(Relationship.class, 173, 8482, 8709);
        try {
            CallChecker.varInit(this, "this", 173, 8482, 8709);
            CallChecker.varInit(this.value, "value", 173, 8482, 8709);
            CallChecker.varInit(this.relationship, "relationship", 173, 8482, 8709);
            CallChecker.varInit(this.coefficients, "coefficients", 173, 8482, 8709);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearConstraint.serialVersionUID", 173, 8482, 8709);
            return relationship;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Relationship) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5363.methodEnd();
        }
    }

    public double getValue() {
        MethodContext _bcornu_methode_context5364 = new MethodContext(double.class, 182, 8716, 8913);
        try {
            CallChecker.varInit(this, "this", 182, 8716, 8913);
            CallChecker.varInit(this.value, "value", 182, 8716, 8913);
            CallChecker.varInit(this.relationship, "relationship", 182, 8716, 8913);
            CallChecker.varInit(this.coefficients, "coefficients", 182, 8716, 8913);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearConstraint.serialVersionUID", 182, 8716, 8913);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5364.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context5365 = new MethodContext(boolean.class, 187, 8920, 9330);
        try {
            CallChecker.varInit(this, "this", 187, 8920, 9330);
            CallChecker.varInit(other, "other", 187, 8920, 9330);
            CallChecker.varInit(this.value, "value", 187, 8920, 9330);
            CallChecker.varInit(this.relationship, "relationship", 187, 8920, 9330);
            CallChecker.varInit(this.coefficients, "coefficients", 187, 8920, 9330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearConstraint.serialVersionUID", 187, 8920, 9330);
            if ((this) == other) {
                return true;
            }
            if (other instanceof LinearConstraint) {
                LinearConstraint rhs = CallChecker.varInit(((LinearConstraint) (other)), "rhs", 192, 9097, 9144);
                if (CallChecker.beforeDeref(rhs, LinearConstraint.class, 195, 9275, 9277)) {
                    rhs = CallChecker.beforeCalled(rhs, LinearConstraint.class, 193, 9181, 9183);
                    rhs = CallChecker.beforeCalled(rhs, LinearConstraint.class, 194, 9226, 9228);
                    rhs = CallChecker.beforeCalled(rhs, LinearConstraint.class, 195, 9275, 9277);
                    return (((relationship) == (CallChecker.isCalled(rhs, LinearConstraint.class, 193, 9181, 9183).relationship)) && ((value) == (CallChecker.isCalled(rhs, LinearConstraint.class, 194, 9226, 9228).value))) && (CallChecker.isCalled(coefficients, RealVector.class, 195, 9255, 9266).equals(CallChecker.isCalled(rhs, LinearConstraint.class, 195, 9275, 9277).coefficients));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5365.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5366 = new MethodContext(int.class, 201, 9337, 9504);
        try {
            CallChecker.varInit(this, "this", 201, 9337, 9504);
            CallChecker.varInit(this.value, "value", 201, 9337, 9504);
            CallChecker.varInit(this.relationship, "relationship", 201, 9337, 9504);
            CallChecker.varInit(this.coefficients, "coefficients", 201, 9337, 9504);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearConstraint.serialVersionUID", 201, 9337, 9504);
            return ((CallChecker.isCalled(relationship, Relationship.class, 202, 9390, 9401).hashCode()) ^ (CallChecker.isCalled(Double.valueOf(value), Double.class, 203, 9428, 9448).hashCode())) ^ (CallChecker.isCalled(coefficients, RealVector.class, 204, 9475, 9486).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5366.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context5367 = new MethodContext(void.class, 212, 9511, 9855);
        try {
            CallChecker.varInit(this, "this", 212, 9511, 9855);
            CallChecker.varInit(oos, "oos", 212, 9511, 9855);
            CallChecker.varInit(this.value, "value", 212, 9511, 9855);
            CallChecker.varInit(this.relationship, "relationship", 212, 9511, 9855);
            CallChecker.varInit(this.coefficients, "coefficients", 212, 9511, 9855);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearConstraint.serialVersionUID", 212, 9511, 9855);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 214, 9765, 9767)) {
                oos = CallChecker.beforeCalled(oos, ObjectOutputStream.class, 214, 9765, 9767);
                CallChecker.isCalled(oos, ObjectOutputStream.class, 214, 9765, 9767).defaultWriteObject();
            }
            MatrixUtils.serializeRealVector(coefficients, oos);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5367.methodEnd();
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context5368 = new MethodContext(void.class, 224, 9862, 10325);
        try {
            CallChecker.varInit(this, "this", 224, 9862, 10325);
            CallChecker.varInit(ois, "ois", 224, 9862, 10325);
            CallChecker.varInit(this.value, "value", 224, 9862, 10325);
            CallChecker.varInit(this.relationship, "relationship", 224, 9862, 10325);
            CallChecker.varInit(this.coefficients, "coefficients", 224, 9862, 10325);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.LinearConstraint.serialVersionUID", 224, 9862, 10325);
            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 226, 10226, 10228)) {
                ois = CallChecker.beforeCalled(ois, ObjectInputStream.class, 226, 10226, 10228);
                CallChecker.isCalled(ois, ObjectInputStream.class, 226, 10226, 10228).defaultReadObject();
            }
            MatrixUtils.deserializeRealVector(this, "coefficients", ois);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5368.methodEnd();
        }
    }
}

