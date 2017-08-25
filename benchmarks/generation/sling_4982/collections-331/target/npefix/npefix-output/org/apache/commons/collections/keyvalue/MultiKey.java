package org.apache.commons.collections.keyvalue;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Arrays;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class MultiKey<K> implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;

    private final K[] keys;

    private transient int hashCode;

    @SuppressWarnings(value = "unchecked")
    public MultiKey(K key1, K key2) {
        this(((K[]) (new Object[]{ key1 , key2 })), false);
        MethodContext _bcornu_methode_context441 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context441.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public MultiKey(K key1, K key2, K key3) {
        this(((K[]) (new Object[]{ key1 , key2 , key3 })), false);
        MethodContext _bcornu_methode_context442 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context442.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public MultiKey(K key1, K key2, K key3, K key4) {
        this(((K[]) (new Object[]{ key1 , key2 , key3 , key4 })), false);
        MethodContext _bcornu_methode_context443 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context443.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public MultiKey(K key1, K key2, K key3, K key4, K key5) {
        this(((K[]) (new Object[]{ key1 , key2 , key3 , key4 , key5 })), false);
        MethodContext _bcornu_methode_context444 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context444.methodEnd();
        }
    }

    public MultiKey(K[] keys) {
        this(keys, true);
        MethodContext _bcornu_methode_context445 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context445.methodEnd();
        }
    }

    public MultiKey(K[] keys, boolean makeClone) {
        super();
        MethodContext _bcornu_methode_context446 = new MethodContext(null);
        try {
            if (keys == null) {
                throw new IllegalArgumentException("The array of keys must not be null");
            }
            if (makeClone) {
                this.keys = keys.clone();
                CallChecker.varAssign(this.keys, "this.keys", 166, 5819, 5843);
            }else {
                this.keys = keys;
                CallChecker.varAssign(this.keys, "this.keys", 168, 5874, 5890);
            }
            calculateHashCode(keys);
        } finally {
            _bcornu_methode_context446.methodEnd();
        }
    }

    public K[] getKeys() {
        MethodContext _bcornu_methode_context2347 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 183, 5947, 6283);
            CallChecker.varInit(this.hashCode, "hashCode", 183, 5947, 6283);
            CallChecker.varInit(this.keys, "keys", 183, 5947, 6283);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.MultiKey.serialVersionUID", 183, 5947, 6283);
            if (CallChecker.beforeDeref(keys, null, 184, 6265, 6268)) {
                return CallChecker.isCalled(keys, null, 184, 6265, 6268).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((K[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2347.methodEnd();
        }
    }

    public K getKey(int index) {
        if (CallChecker.beforeDeref(keys, null, 199, 6680, 6683)) {
            return keys[index];
        }else
            throw new AbnormalExecutionError();
        
    }

    public int size() {
        MethodContext _bcornu_methode_context2349 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 208, 6704, 6904);
            CallChecker.varInit(this.hashCode, "hashCode", 208, 6704, 6904);
            CallChecker.varInit(this.keys, "keys", 208, 6704, 6904);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.MultiKey.serialVersionUID", 208, 6704, 6904);
            if (CallChecker.beforeDeref(keys, null, 209, 6887, 6890)) {
                return CallChecker.isCalled(keys, null, 209, 6887, 6890).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2349.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context2350 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 223, 6911, 7580);
            CallChecker.varInit(other, "other", 223, 6911, 7580);
            CallChecker.varInit(this.hashCode, "hashCode", 223, 6911, 7580);
            CallChecker.varInit(this.keys, "keys", 223, 6911, 7580);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.MultiKey.serialVersionUID", 223, 6911, 7580);
            if (other == (this)) {
                return true;
            }
            if (other instanceof MultiKey) {
                MultiKey<?> otherMulti = CallChecker.varInit(((MultiKey<?>) (other)), "otherMulti", 228, 7441, 7485);
                if (CallChecker.beforeDeref(otherMulti, MultiKey.class, 229, 7526, 7535)) {
                    otherMulti = CallChecker.beforeCalled(otherMulti, MultiKey.class, 229, 7526, 7535);
                    return Arrays.equals(keys, CallChecker.isCalled(otherMulti, MultiKey.class, 229, 7526, 7535).keys);
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2350.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2351 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 245, 7587, 8061);
            CallChecker.varInit(this.hashCode, "hashCode", 245, 7587, 8061);
            CallChecker.varInit(this.keys, "keys", 245, 7587, 8061);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.MultiKey.serialVersionUID", 245, 7587, 8061);
            return hashCode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2351.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2352 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 255, 8068, 8282);
            CallChecker.varInit(this.hashCode, "hashCode", 255, 8068, 8282);
            CallChecker.varInit(this.keys, "keys", 255, 8068, 8282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.MultiKey.serialVersionUID", 255, 8068, 8282);
            return "MultiKey" + (CallChecker.isCalled(Arrays.asList(keys), List.class, 256, 8246, 8264).toString());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2352.methodEnd();
        }
    }

    private void calculateHashCode(Object[] keys) {
        MethodContext _bcornu_methode_context2353 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 263, 8289, 8653);
            CallChecker.varInit(keys, "keys", 263, 8289, 8653);
            CallChecker.varInit(this.hashCode, "hashCode", 263, 8289, 8653);
            CallChecker.varInit(this.keys, "keys", 263, 8289, 8653);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.MultiKey.serialVersionUID", 263, 8289, 8653);
            int total = CallChecker.varInit(((int) (0)), "total", 265, 8456, 8469);
            keys = CallChecker.beforeCalled(keys, Object[].class, 266, 8499, 8502);
            for (int i = 0; i < (CallChecker.isCalled(keys, Object[].class, 266, 8499, 8502).length); i++) {
                if (CallChecker.beforeDeref(keys, Object[].class, 267, 8535, 8538)) {
                    keys = CallChecker.beforeCalled(keys, Object[].class, 267, 8535, 8538);
                    if ((CallChecker.isCalled(keys, Object[].class, 267, 8535, 8538)[i]) != null) {
                        if (CallChecker.beforeDeref(keys, Object[].class, 268, 8579, 8582)) {
                            keys = CallChecker.beforeCalled(keys, Object[].class, 268, 8579, 8582);
                            total ^= CallChecker.isCalled(keys, Object[].class, 268, 8579, 8582)[i].hashCode();
                            CallChecker.varAssign(total, "total", 268, 8570, 8597);
                        }
                    }
                }
            }
            hashCode = total;
            CallChecker.varAssign(this.hashCode, "this.hashCode", 271, 8631, 8647);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2353.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context2354 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 280, 8664, 9022);
            CallChecker.varInit(this.hashCode, "hashCode", 280, 8664, 9022);
            CallChecker.varInit(this.keys, "keys", 280, 8664, 9022);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.keyvalue.MultiKey.serialVersionUID", 280, 8664, 9022);
            calculateHashCode(keys);
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2354.methodEnd();
        }
    }
}

