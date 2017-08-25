package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Pair<K, V> {
    private final K key;

    private final V value;

    public Pair(K k, V v) {
        ConstructorContext _bcornu_methode_context764 = new ConstructorContext(Pair.class, 45, 1251, 1539);
        try {
            key = k;
            CallChecker.varAssign(this.key, "this.key", 46, 1507, 1514);
            value = v;
            CallChecker.varAssign(this.value, "this.value", 47, 1524, 1533);
        } finally {
            _bcornu_methode_context764.methodEnd();
        }
    }

    public Pair(Pair<? extends K, ? extends V> entry) {
        this(entry.getKey(), entry.getValue());
        ConstructorContext _bcornu_methode_context765 = new ConstructorContext(Pair.class, 55, 1546, 1785);
        try {
        } finally {
            _bcornu_methode_context765.methodEnd();
        }
    }

    public K getKey() {
        MethodContext _bcornu_methode_context3429 = new MethodContext(null, 64, 1792, 1931);
        try {
            CallChecker.varInit(this, "this", 64, 1792, 1931);
            CallChecker.varInit(this.value, "value", 64, 1792, 1931);
            CallChecker.varInit(this.key, "key", 64, 1792, 1931);
            return key;
        } catch (ForceReturn _bcornu_return_t) {
            return ((K) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3429.methodEnd();
        }
    }

    public V getValue() {
        MethodContext _bcornu_methode_context3430 = new MethodContext(null, 73, 1938, 2086);
        try {
            CallChecker.varInit(this, "this", 73, 1938, 2086);
            CallChecker.varInit(this.value, "value", 73, 1938, 2086);
            CallChecker.varInit(this.key, "key", 73, 1938, 2086);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((V) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3430.methodEnd();
        }
    }

    public K getFirst() {
        MethodContext _bcornu_methode_context3431 = new MethodContext(null, 83, 2093, 2268);
        try {
            CallChecker.varInit(this, "this", 83, 2093, 2268);
            CallChecker.varInit(this.value, "value", 83, 2093, 2268);
            CallChecker.varInit(this.key, "key", 83, 2093, 2268);
            return key;
        } catch (ForceReturn _bcornu_return_t) {
            return ((K) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3431.methodEnd();
        }
    }

    public V getSecond() {
        MethodContext _bcornu_methode_context3432 = new MethodContext(null, 93, 2275, 2455);
        try {
            CallChecker.varInit(this, "this", 93, 2275, 2455);
            CallChecker.varInit(this.value, "value", 93, 2275, 2455);
            CallChecker.varInit(this.key, "key", 93, 2275, 2455);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((V) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3432.methodEnd();
        }
    }

    @Override
    public boolean equals(Object o) {
        MethodContext _bcornu_methode_context3433 = new MethodContext(boolean.class, 105, 2462, 3168);
        try {
            CallChecker.varInit(this, "this", 105, 2462, 3168);
            CallChecker.varInit(o, "o", 105, 2462, 3168);
            CallChecker.varInit(this.value, "value", 105, 2462, 3168);
            CallChecker.varInit(this.key, "key", 105, 2462, 3168);
            if ((this) == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }else {
                Pair<?, ?> oP = CallChecker.varInit(((Pair<?, ?>) (o)), "oP", 112, 2897, 2927);
                if (CallChecker.beforeDeref(oP, Pair.class, 115, 3031, 3032)) {
                    if (((key) == null) || (CallChecker.beforeDeref(key, null, 115, 3020, 3022))) {
                        if (CallChecker.beforeDeref(oP, Pair.class, 118, 3142, 3143)) {
                            if (((value) == null) || (CallChecker.beforeDeref(value, null, 118, 3129, 3133))) {
                                return (((key) == null) ? (oP.key) == null : key.equals(oP.key)) && (((value) == null) ? (oP.value) == null : value.equals(oP.value));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3433.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3434 = new MethodContext(int.class, 128, 3175, 3491);
        try {
            CallChecker.varInit(this, "this", 128, 3175, 3491);
            CallChecker.varInit(this.value, "value", 128, 3175, 3491);
            CallChecker.varInit(this.key, "key", 128, 3175, 3491);
            int result = CallChecker.init(int.class);
            if ((key) == null) {
                result = 0;
                CallChecker.varAssign(result, "result", 129, 3321, 3352);
            }else {
                result = key.hashCode();
                CallChecker.varAssign(result, "result", 129, 3321, 3352);
            }
            int h = CallChecker.init(int.class);
            if ((value) == null) {
                h = 0;
                CallChecker.varAssign(h, "h", 131, 3378, 3413);
            }else {
                h = value.hashCode();
                CallChecker.varAssign(h, "h", 131, 3378, 3413);
            }
            result = ((37 * result) + h) ^ (h >>> 16);
            CallChecker.varAssign(result, "result", 132, 3424, 3461);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3434.methodEnd();
        }
    }
}

