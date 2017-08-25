package org.apache.commons.collections.keyvalue;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.KeyValue;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {
    protected K key;

    protected V value;

    protected AbstractKeyValue(K key, V value) {
        super();
        MethodContext _bcornu_methode_context215 = new MethodContext(null);
        try {
            this.key = key;
            CallChecker.varAssign(this.key, "this.key", 48, 1715, 1729);
            this.value = value;
            CallChecker.varAssign(this.value, "this.value", 49, 1739, 1757);
        } finally {
            _bcornu_methode_context215.methodEnd();
        }
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1087 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 76, 2043, 2350);
            CallChecker.varInit(this.value, "value", 76, 2043, 2350);
            CallChecker.varInit(this.key, "key", 76, 2043, 2350);
            if (CallChecker.beforeDeref(new StringBuilder(), StringBuilder.class, 77, 2214, 2232)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 77, 2214, 2232).append(getKey()), StringBuilder.class, 77, 2214, 2262)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 77, 2214, 2232).append(getKey()), StringBuilder.class, 77, 2214, 2262).append('='), StringBuilder.class, 77, 2214, 2287)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 77, 2214, 2232).append(getKey()), StringBuilder.class, 77, 2214, 2262).append('='), StringBuilder.class, 77, 2214, 2287).append(getValue()), StringBuilder.class, 77, 2214, 2319)) {
                            return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 77, 2214, 2232).append(getKey()), StringBuilder.class, 77, 2214, 2262).append('='), StringBuilder.class, 77, 2214, 2287).append(getValue()), StringBuilder.class, 77, 2214, 2319).toString();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1087.methodEnd();
        }
    }
}

