package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class BigFractionField implements Serializable , Field<BigFraction> {
    private static class LazyHolder {
        private static final BigFractionField INSTANCE = new BigFractionField();
    }

    private static final long serialVersionUID = -1699294557189741703L;

    private BigFractionField() {
        ConstructorContext _bcornu_methode_context367 = new ConstructorContext(BigFractionField.class, 41, 1336, 1424);
        try {
        } finally {
            _bcornu_methode_context367.methodEnd();
        }
    }

    public static BigFractionField getInstance() {
        MethodContext _bcornu_methode_context1617 = new MethodContext(BigFractionField.class, 47, 1431, 1594);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionField.serialVersionUID", 47, 1431, 1594);
            return BigFractionField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFractionField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1617.methodEnd();
        }
    }

    public BigFraction getOne() {
        MethodContext _bcornu_methode_context1618 = new MethodContext(BigFraction.class, 52, 1601, 1692);
        try {
            CallChecker.varInit(this, "this", 52, 1601, 1692);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionField.serialVersionUID", 52, 1601, 1692);
            return BigFraction.ONE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1618.methodEnd();
        }
    }

    public BigFraction getZero() {
        MethodContext _bcornu_methode_context1619 = new MethodContext(BigFraction.class, 57, 1699, 1792);
        try {
            CallChecker.varInit(this, "this", 57, 1699, 1792);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionField.serialVersionUID", 57, 1699, 1792);
            return BigFraction.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1619.methodEnd();
        }
    }

    public Class<? extends FieldElement<BigFraction>> getRuntimeClass() {
        MethodContext _bcornu_methode_context1620 = new MethodContext(Class.class, 62, 1799, 1932);
        try {
            CallChecker.varInit(this, "this", 62, 1799, 1932);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionField.serialVersionUID", 62, 1799, 1932);
            return BigFraction.class;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<? extends FieldElement<BigFraction>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1620.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1621 = new MethodContext(Object.class, 78, 2263, 2525);
        try {
            CallChecker.varInit(this, "this", 78, 2263, 2525);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionField.serialVersionUID", 78, 2263, 2525);
            return BigFractionField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1621.methodEnd();
        }
    }
}

