package org.apache.commons.math3.complex;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class ComplexField implements Serializable , Field<Complex> {
    private static class LazyHolder {
        private static final ComplexField INSTANCE = new ComplexField();
    }

    private static final long serialVersionUID = -6130362688700788798L;

    private ComplexField() {
        ConstructorContext _bcornu_methode_context1094 = new ConstructorContext(ComplexField.class, 41, 1302, 1386);
        try {
        } finally {
            _bcornu_methode_context1094.methodEnd();
        }
    }

    public static ComplexField getInstance() {
        MethodContext _bcornu_methode_context4884 = new MethodContext(ComplexField.class, 47, 1393, 1552);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.ComplexField.serialVersionUID", 47, 1393, 1552);
            return ComplexField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ComplexField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4884.methodEnd();
        }
    }

    public Complex getOne() {
        MethodContext _bcornu_methode_context4885 = new MethodContext(Complex.class, 52, 1559, 1642);
        try {
            CallChecker.varInit(this, "this", 52, 1559, 1642);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.ComplexField.serialVersionUID", 52, 1559, 1642);
            return Complex.ONE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4885.methodEnd();
        }
    }

    public Complex getZero() {
        MethodContext _bcornu_methode_context4886 = new MethodContext(Complex.class, 57, 1649, 1734);
        try {
            CallChecker.varInit(this, "this", 57, 1649, 1734);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.ComplexField.serialVersionUID", 57, 1649, 1734);
            return Complex.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4886.methodEnd();
        }
    }

    public Class<? extends FieldElement<Complex>> getRuntimeClass() {
        MethodContext _bcornu_methode_context4887 = new MethodContext(Class.class, 62, 1741, 1866);
        try {
            CallChecker.varInit(this, "this", 62, 1741, 1866);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.ComplexField.serialVersionUID", 62, 1741, 1866);
            return Complex.class;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<? extends FieldElement<Complex>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4887.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context4888 = new MethodContext(Object.class, 79, 2190, 2452);
        try {
            CallChecker.varInit(this, "this", 79, 2190, 2452);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.ComplexField.serialVersionUID", 79, 2190, 2452);
            return ComplexField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4888.methodEnd();
        }
    }
}

