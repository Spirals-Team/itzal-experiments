package org.apache.commons.collections.keyvalue;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.KeyValue;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class TiedMapEntry<K, V> implements Serializable , Map.Entry<K, V> , KeyValue<K, V> {
    private static final long serialVersionUID = -8453869361373831205L;

    private final Map<K, V> map;

    private final K key;

    public TiedMapEntry(Map<K, V> map, K key) {
        super();
        MethodContext _bcornu_methode_context360 = new MethodContext(null);
        try {
            this.map = map;
            CallChecker.varAssign(this.map, "this.map", 54, 1873, 1887);
            this.key = key;
            CallChecker.varAssign(this.key, "this.key", 55, 1897, 1911);
        } finally {
            _bcornu_methode_context360.methodEnd();
        }
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        if (CallChecker.beforeDeref(map, Map.class, 75, 2306, 2308)) {
            return map.get(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public V setValue(V value) {
        if (value == (this)) {
            throw new IllegalArgumentException("Cannot set value to this map entry");
        }
        if (CallChecker.beforeDeref(map, Map.class, 89, 2733, 2735)) {
            return map.put(key, value);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1839 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 101, 2765, 3531);
            CallChecker.varInit(obj, "obj", 101, 2765, 3531);
            CallChecker.varInit(this.key, "key", 101, 2765, 3531);
            CallChecker.varInit(this.map, "map", 101, 2765, 3531);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.TiedMapEntry.serialVersionUID", 101, 2765, 3531);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof Map.Entry) == false) {
                return false;
            }
            Map.Entry<?, ?> other = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "other", 108, 3260, 3303);
            Object value = CallChecker.varInit(getValue(), "value", 109, 3313, 3338);
            if (CallChecker.beforeDeref(other, Map.Entry.class, 111, 3418, 3422)) {
                if (((key) == null) || (CallChecker.beforeDeref(key, null, 111, 3407, 3409))) {
                    if (CallChecker.beforeDeref(other, Map.Entry.class, 112, 3507, 3511)) {
                        if ((value == null) || (CallChecker.beforeDeref(value, Object.class, 112, 3494, 3498))) {
                            value = CallChecker.beforeCalled(value, Object.class, 112, 3494, 3498);
                            return (((key) == null) ? (other.getKey()) == null : key.equals(other.getKey())) && ((value == null) ? (other.getValue()) == null : CallChecker.isCalled(value, Object.class, 112, 3494, 3498).equals(other.getValue()));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1839.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1840 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 123, 3538, 3945);
            CallChecker.varInit(this.key, "key", 123, 3538, 3945);
            CallChecker.varInit(this.map, "map", 123, 3538, 3945);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.TiedMapEntry.serialVersionUID", 123, 3538, 3945);
            Object value = CallChecker.varInit(getValue(), "value", 124, 3796, 3821);
            final K npe_invocation_var368 = getKey();
            if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var368, null, 125, 3862, 3869))) {
                if ((value == null) || (CallChecker.beforeDeref(value, Object.class, 126, 3921, 3925))) {
                    value = CallChecker.beforeCalled(value, Object.class, 126, 3921, 3925);
                    return (((getKey()) == null) ? 0 : npe_invocation_var368.hashCode()) ^ ((value == null) ? 0 : CallChecker.isCalled(value, Object.class, 126, 3921, 3925).hashCode());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1840.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1841 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 135, 3952, 4141);
            CallChecker.varInit(this.key, "key", 135, 3952, 4141);
            CallChecker.varInit(this.map, "map", 135, 3952, 4141);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.TiedMapEntry.serialVersionUID", 135, 3952, 4141);
            return ((getKey()) + "=") + (getValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1841.methodEnd();
        }
    }
}

