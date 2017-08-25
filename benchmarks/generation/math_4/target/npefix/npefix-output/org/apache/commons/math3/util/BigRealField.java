package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class BigRealField implements Serializable , Field<BigReal> {
    private static class LazyHolder {
        private static final BigRealField INSTANCE = new BigRealField();
    }

    private static final long serialVersionUID = 4756431066541037559L;

    private BigRealField() {
        ConstructorContext _bcornu_methode_context561 = new ConstructorContext(BigRealField.class, 41, 1315, 1399);
        try {
        } finally {
            _bcornu_methode_context561.methodEnd();
        }
    }

    public static BigRealField getInstance() {
        MethodContext _bcornu_methode_context2600 = new MethodContext(BigRealField.class, 47, 1406, 1565);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigRealField.serialVersionUID", 47, 1406, 1565);
            return BigRealField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigRealField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2600.methodEnd();
        }
    }

    public BigReal getOne() {
        MethodContext _bcornu_methode_context2601 = new MethodContext(BigReal.class, 52, 1572, 1655);
        try {
            CallChecker.varInit(this, "this", 52, 1572, 1655);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigRealField.serialVersionUID", 52, 1572, 1655);
            return BigReal.ONE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2601.methodEnd();
        }
    }

    public BigReal getZero() {
        MethodContext _bcornu_methode_context2602 = new MethodContext(BigReal.class, 57, 1662, 1747);
        try {
            CallChecker.varInit(this, "this", 57, 1662, 1747);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigRealField.serialVersionUID", 57, 1662, 1747);
            return BigReal.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2602.methodEnd();
        }
    }

    public Class<? extends FieldElement<BigReal>> getRuntimeClass() {
        MethodContext _bcornu_methode_context2603 = new MethodContext(Class.class, 62, 1754, 1879);
        try {
            CallChecker.varInit(this, "this", 62, 1754, 1879);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigRealField.serialVersionUID", 62, 1754, 1879);
            return BigReal.class;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<? extends FieldElement<BigReal>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2603.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context2604 = new MethodContext(Object.class, 79, 2203, 2465);
        try {
            CallChecker.varInit(this, "this", 79, 2203, 2465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigRealField.serialVersionUID", 79, 2203, 2465);
            return BigRealField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2604.methodEnd();
        }
    }
}

