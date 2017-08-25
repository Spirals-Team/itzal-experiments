package org.apache.commons.collections.keyvalue;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.KeyValue;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class DefaultKeyValue<K, V> extends AbstractKeyValue<K, V> {
    public DefaultKeyValue() {
        super(null, null);
        MethodContext _bcornu_methode_context167 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context167.methodEnd();
        }
    }

    public DefaultKeyValue(final K key, final V value) {
        super(key, value);
        MethodContext _bcornu_methode_context168 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context168.methodEnd();
        }
    }

    public DefaultKeyValue(final KeyValue<K, V> pair) {
        super(pair.getKey(), pair.getValue());
        MethodContext _bcornu_methode_context169 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }

    public DefaultKeyValue(final Map.Entry<K, V> entry) {
        super(entry.getKey(), entry.getValue());
        MethodContext _bcornu_methode_context170 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context170.methodEnd();
        }
    }

    public K setKey(final K key) {
        if (key == (this)) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
        }
        final K old = CallChecker.varInit(this.key, "old", 90, 2949, 2971);
        this.key = key;
        CallChecker.varAssign(this.key, "this.key", 91, 2981, 2995);
        return old;
    }

    public V setValue(final V value) {
        if (value == (this)) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
        }
        final V old = CallChecker.varInit(this.value, "old", 107, 3400, 3424);
        this.value = value;
        CallChecker.varAssign(this.value, "this.value", 108, 3434, 3452);
        return old;
    }

    public Map.Entry<K, V> toMapEntry() {
        MethodContext _bcornu_methode_context845 = new MethodContext(Map.Entry.class);
        try {
            CallChecker.varInit(this, "this", 118, 3485, 3798);
            CallChecker.varInit(this.value, "value", 118, 3485, 3798);
            CallChecker.varInit(this.key, "key", 118, 3485, 3798);
            return new DefaultMapEntry<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context845.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object obj) {
        MethodContext _bcornu_methode_context846 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 133, 3805, 4729);
            CallChecker.varInit(obj, "obj", 133, 3805, 4729);
            CallChecker.varInit(this.value, "value", 133, 3805, 4729);
            CallChecker.varInit(this.key, "key", 133, 3805, 4729);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof DefaultKeyValue) == false) {
                return false;
            }
            DefaultKeyValue<?, ?> other = CallChecker.varInit(((DefaultKeyValue<?, ?>) (obj)), "other", 141, 4458, 4515);
            if (CallChecker.beforeDeref(other, DefaultKeyValue.class, 143, 4606, 4610)) {
                final K npe_invocation_var191 = getKey();
                if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var191, null, 143, 4590, 4597))) {
                    if (CallChecker.beforeDeref(other, DefaultKeyValue.class, 144, 4705, 4709)) {
                        final V npe_invocation_var192 = getValue();
                        if (((getValue()) == null) || (CallChecker.beforeDeref(npe_invocation_var192, null, 144, 4687, 4696))) {
                            return (((getKey()) == null) ? (other.getKey()) == null : npe_invocation_var191.equals(other.getKey())) && (((getValue()) == null) ? (other.getValue()) == null : npe_invocation_var192.equals(other.getValue()));
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
            _bcornu_methode_context846.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context847 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 156, 4736, 5163);
            CallChecker.varInit(this.value, "value", 156, 4736, 5163);
            CallChecker.varInit(this.key, "key", 156, 4736, 5163);
            final K npe_invocation_var193 = getKey();
            if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var193, null, 157, 5071, 5078))) {
                final V npe_invocation_var194 = getValue();
                if (((getValue()) == null) || (CallChecker.beforeDeref(npe_invocation_var194, null, 158, 5135, 5144))) {
                    return (((getKey()) == null) ? 0 : npe_invocation_var193.hashCode()) ^ (((getValue()) == null) ? 0 : npe_invocation_var194.hashCode());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context847.methodEnd();
        }
    }
}

