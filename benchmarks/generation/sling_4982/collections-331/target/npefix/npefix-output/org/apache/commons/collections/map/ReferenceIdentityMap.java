package org.apache.commons.collections.map;

import static org.apache.commons.collections.map.AbstractReferenceMap.ReferenceStrength.SOFT;
import static org.apache.commons.collections.map.AbstractReferenceMap.ReferenceStrength.HARD;
import java.io.Serializable;
import java.lang.ref.Reference;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReferenceIdentityMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = -1266190134568365852L;

    public ReferenceIdentityMap() {
        super(HARD, SOFT, AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, false);
        MethodContext _bcornu_methode_context238 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context238.methodEnd();
        }
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType) {
        super(keyType, valueType, AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, false);
        MethodContext _bcornu_methode_context239 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context239.methodEnd();
        }
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType, boolean purgeValues) {
        super(keyType, valueType, AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, purgeValues);
        MethodContext _bcornu_methode_context240 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context240.methodEnd();
        }
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType, int capacity, float loadFactor) {
        super(keyType, valueType, capacity, loadFactor, false);
        MethodContext _bcornu_methode_context241 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context241.methodEnd();
        }
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType, int capacity, float loadFactor, boolean purgeValues) {
        super(keyType, valueType, capacity, loadFactor, purgeValues);
        MethodContext _bcornu_methode_context242 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context242.methodEnd();
        }
    }

    @Override
    protected int hash(Object key) {
        MethodContext _bcornu_methode_context1204 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 176, 7964, 8357);
            CallChecker.varInit(key, "key", 176, 7964, 8357);
            CallChecker.varInit(this.values, "values", 176, 7964, 8357);
            CallChecker.varInit(this.keySet, "keySet", 176, 7964, 8357);
            CallChecker.varInit(this.entrySet, "entrySet", 176, 7964, 8357);
            CallChecker.varInit(this.modCount, "modCount", 176, 7964, 8357);
            CallChecker.varInit(this.threshold, "threshold", 176, 7964, 8357);
            CallChecker.varInit(this.data, "data", 176, 7964, 8357);
            CallChecker.varInit(this.size, "size", 176, 7964, 8357);
            CallChecker.varInit(this.loadFactor, "loadFactor", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 176, 7964, 8357);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 176, 7964, 8357);
            CallChecker.varInit(this.purgeValues, "purgeValues", 176, 7964, 8357);
            CallChecker.varInit(this.valueType, "valueType", 176, 7964, 8357);
            CallChecker.varInit(this.keyType, "keyType", 176, 7964, 8357);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceIdentityMap.serialVersionUID", 176, 7964, 8357);
            return System.identityHashCode(key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1204.methodEnd();
        }
    }

    @Override
    protected int hashEntry(Object key, Object value) {
        MethodContext _bcornu_methode_context1205 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 190, 8364, 8854);
            CallChecker.varInit(value, "value", 190, 8364, 8854);
            CallChecker.varInit(key, "key", 190, 8364, 8854);
            CallChecker.varInit(this.values, "values", 190, 8364, 8854);
            CallChecker.varInit(this.keySet, "keySet", 190, 8364, 8854);
            CallChecker.varInit(this.entrySet, "entrySet", 190, 8364, 8854);
            CallChecker.varInit(this.modCount, "modCount", 190, 8364, 8854);
            CallChecker.varInit(this.threshold, "threshold", 190, 8364, 8854);
            CallChecker.varInit(this.data, "data", 190, 8364, 8854);
            CallChecker.varInit(this.size, "size", 190, 8364, 8854);
            CallChecker.varInit(this.loadFactor, "loadFactor", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 190, 8364, 8854);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 190, 8364, 8854);
            CallChecker.varInit(this.purgeValues, "purgeValues", 190, 8364, 8854);
            CallChecker.varInit(this.valueType, "valueType", 190, 8364, 8854);
            CallChecker.varInit(this.keyType, "keyType", 190, 8364, 8854);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceIdentityMap.serialVersionUID", 190, 8364, 8854);
            return (System.identityHashCode(key)) ^ (System.identityHashCode(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1205.methodEnd();
        }
    }

    @Override
    protected boolean isEqualKey(Object key1, Object key2) {
        MethodContext _bcornu_methode_context1206 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 206, 8861, 9450);
            CallChecker.varInit(key2, "key2", 206, 8861, 9450);
            CallChecker.varInit(key1, "key1", 206, 8861, 9450);
            CallChecker.varInit(this.values, "values", 206, 8861, 9450);
            CallChecker.varInit(this.keySet, "keySet", 206, 8861, 9450);
            CallChecker.varInit(this.entrySet, "entrySet", 206, 8861, 9450);
            CallChecker.varInit(this.modCount, "modCount", 206, 8861, 9450);
            CallChecker.varInit(this.threshold, "threshold", 206, 8861, 9450);
            CallChecker.varInit(this.data, "data", 206, 8861, 9450);
            CallChecker.varInit(this.size, "size", 206, 8861, 9450);
            CallChecker.varInit(this.loadFactor, "loadFactor", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 206, 8861, 9450);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 206, 8861, 9450);
            CallChecker.varInit(this.purgeValues, "purgeValues", 206, 8861, 9450);
            CallChecker.varInit(this.valueType, "valueType", 206, 8861, 9450);
            CallChecker.varInit(this.keyType, "keyType", 206, 8861, 9450);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceIdentityMap.serialVersionUID", 206, 8861, 9450);
            if ((keyType) == (HARD)) {
                key2 = key2;
                CallChecker.varAssign(key2, "key2", 207, 9338, 9415);
            }else {
                if (CallChecker.beforeDeref(key2, Object.class, 207, 9404, 9407)) {
                    key2 = ((Reference<?>) (key2)).get();
                    CallChecker.varAssign(key2, "key2", 207, 9338, 9415);
                }
            }
            return key1 == key2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1206.methodEnd();
        }
    }

    @Override
    protected boolean isEqualValue(Object value1, Object value2) {
        MethodContext _bcornu_methode_context1207 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 221, 9457, 9899);
            CallChecker.varInit(value2, "value2", 221, 9457, 9899);
            CallChecker.varInit(value1, "value1", 221, 9457, 9899);
            CallChecker.varInit(this.values, "values", 221, 9457, 9899);
            CallChecker.varInit(this.keySet, "keySet", 221, 9457, 9899);
            CallChecker.varInit(this.entrySet, "entrySet", 221, 9457, 9899);
            CallChecker.varInit(this.modCount, "modCount", 221, 9457, 9899);
            CallChecker.varInit(this.threshold, "threshold", 221, 9457, 9899);
            CallChecker.varInit(this.data, "data", 221, 9457, 9899);
            CallChecker.varInit(this.size, "size", 221, 9457, 9899);
            CallChecker.varInit(this.loadFactor, "loadFactor", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 221, 9457, 9899);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 221, 9457, 9899);
            CallChecker.varInit(this.purgeValues, "purgeValues", 221, 9457, 9899);
            CallChecker.varInit(this.valueType, "valueType", 221, 9457, 9899);
            CallChecker.varInit(this.keyType, "keyType", 221, 9457, 9899);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceIdentityMap.serialVersionUID", 221, 9457, 9899);
            return value1 == value2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1207.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1208 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 229, 9906, 10185);
            CallChecker.varInit(out, "out", 229, 9906, 10185);
            CallChecker.varInit(this.values, "values", 229, 9906, 10185);
            CallChecker.varInit(this.keySet, "keySet", 229, 9906, 10185);
            CallChecker.varInit(this.entrySet, "entrySet", 229, 9906, 10185);
            CallChecker.varInit(this.modCount, "modCount", 229, 9906, 10185);
            CallChecker.varInit(this.threshold, "threshold", 229, 9906, 10185);
            CallChecker.varInit(this.data, "data", 229, 9906, 10185);
            CallChecker.varInit(this.size, "size", 229, 9906, 10185);
            CallChecker.varInit(this.loadFactor, "loadFactor", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 229, 9906, 10185);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 229, 9906, 10185);
            CallChecker.varInit(this.purgeValues, "purgeValues", 229, 9906, 10185);
            CallChecker.varInit(this.valueType, "valueType", 229, 9906, 10185);
            CallChecker.varInit(this.keyType, "keyType", 229, 9906, 10185);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceIdentityMap.serialVersionUID", 229, 9906, 10185);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 230, 10127, 10129)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 230, 10127, 10129);
                CallChecker.isCalled(out, ObjectOutputStream.class, 230, 10127, 10129).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1208.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1209 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 237, 10192, 10408);
            CallChecker.varInit(in, "in", 237, 10192, 10408);
            CallChecker.varInit(this.values, "values", 237, 10192, 10408);
            CallChecker.varInit(this.keySet, "keySet", 237, 10192, 10408);
            CallChecker.varInit(this.entrySet, "entrySet", 237, 10192, 10408);
            CallChecker.varInit(this.modCount, "modCount", 237, 10192, 10408);
            CallChecker.varInit(this.threshold, "threshold", 237, 10192, 10408);
            CallChecker.varInit(this.data, "data", 237, 10192, 10408);
            CallChecker.varInit(this.size, "size", 237, 10192, 10408);
            CallChecker.varInit(this.loadFactor, "loadFactor", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 237, 10192, 10408);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 237, 10192, 10408);
            CallChecker.varInit(this.purgeValues, "purgeValues", 237, 10192, 10408);
            CallChecker.varInit(this.valueType, "valueType", 237, 10192, 10408);
            CallChecker.varInit(this.keyType, "keyType", 237, 10192, 10408);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceIdentityMap.serialVersionUID", 237, 10192, 10408);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 238, 10354, 10355)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 238, 10354, 10355);
                CallChecker.isCalled(in, ObjectInputStream.class, 238, 10354, 10355).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1209.methodEnd();
        }
    }
}

