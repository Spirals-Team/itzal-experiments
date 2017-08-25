package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class FractionField implements Serializable , Field<Fraction> {
    private static class LazyHolder {
        private static final FractionField INSTANCE = new FractionField();
    }

    private static final long serialVersionUID = -1257768487499119313L;

    private FractionField() {
        ConstructorContext _bcornu_methode_context572 = new ConstructorContext(FractionField.class, 41, 1308, 1393);
        try {
        } finally {
            _bcornu_methode_context572.methodEnd();
        }
    }

    public static FractionField getInstance() {
        MethodContext _bcornu_methode_context2644 = new MethodContext(FractionField.class, 47, 1400, 1560);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionField.serialVersionUID", 47, 1400, 1560);
            return FractionField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FractionField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2644.methodEnd();
        }
    }

    public Fraction getOne() {
        MethodContext _bcornu_methode_context2645 = new MethodContext(Fraction.class, 52, 1567, 1652);
        try {
            CallChecker.varInit(this, "this", 52, 1567, 1652);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionField.serialVersionUID", 52, 1567, 1652);
            return Fraction.ONE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2645.methodEnd();
        }
    }

    public Fraction getZero() {
        MethodContext _bcornu_methode_context2646 = new MethodContext(Fraction.class, 57, 1659, 1746);
        try {
            CallChecker.varInit(this, "this", 57, 1659, 1746);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionField.serialVersionUID", 57, 1659, 1746);
            return Fraction.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2646.methodEnd();
        }
    }

    public Class<? extends FieldElement<Fraction>> getRuntimeClass() {
        MethodContext _bcornu_methode_context2647 = new MethodContext(Class.class, 62, 1753, 1880);
        try {
            CallChecker.varInit(this, "this", 62, 1753, 1880);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionField.serialVersionUID", 62, 1753, 1880);
            return Fraction.class;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<? extends FieldElement<Fraction>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2647.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context2648 = new MethodContext(Object.class, 78, 2205, 2467);
        try {
            CallChecker.varInit(this, "this", 78, 2205, 2467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionField.serialVersionUID", 78, 2205, 2467);
            return FractionField.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2648.methodEnd();
        }
    }
}

