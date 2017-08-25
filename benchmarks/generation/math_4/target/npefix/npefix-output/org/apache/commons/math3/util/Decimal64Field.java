package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class Decimal64Field implements Field<Decimal64> {
    private static final Decimal64Field INSTANCE = new Decimal64Field();

    private Decimal64Field() {
        ConstructorContext _bcornu_methode_context12 = new ConstructorContext(Decimal64Field.class, 35, 1229, 1314);
        try {
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public static final Decimal64Field getInstance() {
        MethodContext _bcornu_methode_context56 = new MethodContext(Decimal64Field.class, 44, 1321, 1523);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.math3.util.Decimal64Field.INSTANCE", 44, 1321, 1523);
            return Decimal64Field.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64Field) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public Decimal64 getZero() {
        MethodContext _bcornu_methode_context57 = new MethodContext(Decimal64.class, 49, 1530, 1619);
        try {
            CallChecker.varInit(this, "this", 49, 1530, 1619);
            CallChecker.varInit(INSTANCE, "org.apache.commons.math3.util.Decimal64Field.INSTANCE", 49, 1530, 1619);
            return Decimal64.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    public Decimal64 getOne() {
        MethodContext _bcornu_methode_context58 = new MethodContext(Decimal64.class, 54, 1626, 1713);
        try {
            CallChecker.varInit(this, "this", 54, 1626, 1713);
            CallChecker.varInit(INSTANCE, "org.apache.commons.math3.util.Decimal64Field.INSTANCE", 54, 1626, 1713);
            return Decimal64.ONE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public Class<? extends FieldElement<Decimal64>> getRuntimeClass() {
        MethodContext _bcornu_methode_context59 = new MethodContext(Class.class, 59, 1720, 1849);
        try {
            CallChecker.varInit(this, "this", 59, 1720, 1849);
            CallChecker.varInit(INSTANCE, "org.apache.commons.math3.util.Decimal64Field.INSTANCE", 59, 1720, 1849);
            return Decimal64.class;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<? extends FieldElement<Decimal64>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }
}

