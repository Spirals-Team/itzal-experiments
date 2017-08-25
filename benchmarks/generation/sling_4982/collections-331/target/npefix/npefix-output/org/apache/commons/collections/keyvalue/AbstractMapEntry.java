package org.apache.commons.collections.keyvalue;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractMapEntry<K, V> extends AbstractKeyValue<K, V> implements Map.Entry<K, V> {
    protected AbstractMapEntry(K key, V value) {
        super(key, value);
        MethodContext _bcornu_methode_context292 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context292.methodEnd();
        }
    }

    public V setValue(V value) {
        V answer = CallChecker.varInit(this.value, "answer", 57, 2041, 2062);
        this.value = value;
        CallChecker.varAssign(this.value, "this.value", 58, 2072, 2090);
        return answer;
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1550 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 71, 2126, 2879);
            CallChecker.varInit(obj, "obj", 71, 2126, 2879);
            CallChecker.varInit(this.value, "value", 71, 2126, 2879);
            CallChecker.varInit(this.key, "key", 71, 2126, 2879);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof Map.Entry) == false) {
                return false;
            }
            Map.Entry<?, ?> other = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "other", 78, 2621, 2666);
            if (CallChecker.beforeDeref(other, Map.Entry.class, 80, 2756, 2760)) {
                final K npe_invocation_var296 = getKey();
                if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var296, null, 80, 2740, 2747))) {
                    if (CallChecker.beforeDeref(other, Map.Entry.class, 81, 2855, 2859)) {
                        final V npe_invocation_var297 = getValue();
                        if (((getValue()) == null) || (CallChecker.beforeDeref(npe_invocation_var297, null, 81, 2837, 2846))) {
                            return (((getKey()) == null) ? (other.getKey()) == null : npe_invocation_var296.equals(other.getKey())) && (((getValue()) == null) ? (other.getValue()) == null : npe_invocation_var297.equals(other.getValue()));
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
            _bcornu_methode_context1550.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1551 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 92, 2886, 3268);
            CallChecker.varInit(this.value, "value", 92, 2886, 3268);
            CallChecker.varInit(this.key, "key", 92, 2886, 3268);
            final K npe_invocation_var298 = getKey();
            if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var298, null, 93, 3175, 3182))) {
                final V npe_invocation_var299 = getValue();
                if (((getValue()) == null) || (CallChecker.beforeDeref(npe_invocation_var299, null, 94, 3239, 3248))) {
                    return (((getKey()) == null) ? 0 : npe_invocation_var298.hashCode()) ^ (((getValue()) == null) ? 0 : npe_invocation_var299.hashCode());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1551.methodEnd();
        }
    }
}

