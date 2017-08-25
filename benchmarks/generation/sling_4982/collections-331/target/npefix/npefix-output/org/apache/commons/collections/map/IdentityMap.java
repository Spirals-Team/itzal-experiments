package org.apache.commons.collections.map;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;

public class IdentityMap<K, V> extends AbstractHashedMap<K, V> implements Serializable , Cloneable {
    private static final long serialVersionUID = 2028493495224302329L;

    public IdentityMap() {
        super(AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, AbstractHashedMap.DEFAULT_THRESHOLD);
        MethodContext _bcornu_methode_context136 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context136.methodEnd();
        }
    }

    public IdentityMap(int initialCapacity) {
        super(initialCapacity);
        MethodContext _bcornu_methode_context137 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context137.methodEnd();
        }
    }

    public IdentityMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        MethodContext _bcornu_methode_context138 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context138.methodEnd();
        }
    }

    public IdentityMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context139 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }

    @Override
    protected int hash(Object key) {
        MethodContext _bcornu_methode_context751 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 101, 3456, 3837);
            CallChecker.varInit(key, "key", 101, 3456, 3837);
            CallChecker.varInit(this.values, "values", 101, 3456, 3837);
            CallChecker.varInit(this.keySet, "keySet", 101, 3456, 3837);
            CallChecker.varInit(this.entrySet, "entrySet", 101, 3456, 3837);
            CallChecker.varInit(this.modCount, "modCount", 101, 3456, 3837);
            CallChecker.varInit(this.threshold, "threshold", 101, 3456, 3837);
            CallChecker.varInit(this.data, "data", 101, 3456, 3837);
            CallChecker.varInit(this.size, "size", 101, 3456, 3837);
            CallChecker.varInit(this.loadFactor, "loadFactor", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 101, 3456, 3837);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 101, 3456, 3837);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.IdentityMap.serialVersionUID", 101, 3456, 3837);
            return System.identityHashCode(key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context751.methodEnd();
        }
    }

    @Override
    protected boolean isEqualKey(Object key1, Object key2) {
        MethodContext _bcornu_methode_context752 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 114, 3844, 4191);
            CallChecker.varInit(key2, "key2", 114, 3844, 4191);
            CallChecker.varInit(key1, "key1", 114, 3844, 4191);
            CallChecker.varInit(this.values, "values", 114, 3844, 4191);
            CallChecker.varInit(this.keySet, "keySet", 114, 3844, 4191);
            CallChecker.varInit(this.entrySet, "entrySet", 114, 3844, 4191);
            CallChecker.varInit(this.modCount, "modCount", 114, 3844, 4191);
            CallChecker.varInit(this.threshold, "threshold", 114, 3844, 4191);
            CallChecker.varInit(this.data, "data", 114, 3844, 4191);
            CallChecker.varInit(this.size, "size", 114, 3844, 4191);
            CallChecker.varInit(this.loadFactor, "loadFactor", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 114, 3844, 4191);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 114, 3844, 4191);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.IdentityMap.serialVersionUID", 114, 3844, 4191);
            return key1 == key2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context752.methodEnd();
        }
    }

    @Override
    protected boolean isEqualValue(Object value1, Object value2) {
        MethodContext _bcornu_methode_context753 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 127, 4198, 4565);
            CallChecker.varInit(value2, "value2", 127, 4198, 4565);
            CallChecker.varInit(value1, "value1", 127, 4198, 4565);
            CallChecker.varInit(this.values, "values", 127, 4198, 4565);
            CallChecker.varInit(this.keySet, "keySet", 127, 4198, 4565);
            CallChecker.varInit(this.entrySet, "entrySet", 127, 4198, 4565);
            CallChecker.varInit(this.modCount, "modCount", 127, 4198, 4565);
            CallChecker.varInit(this.threshold, "threshold", 127, 4198, 4565);
            CallChecker.varInit(this.data, "data", 127, 4198, 4565);
            CallChecker.varInit(this.size, "size", 127, 4198, 4565);
            CallChecker.varInit(this.loadFactor, "loadFactor", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 127, 4198, 4565);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 127, 4198, 4565);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.IdentityMap.serialVersionUID", 127, 4198, 4565);
            return value1 == value2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context753.methodEnd();
        }
    }

    @Override
    protected IdentityMap.IdentityEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> next, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context754 = new MethodContext(IdentityMap.IdentityEntry.class);
        try {
            CallChecker.varInit(this, "this", 142, 4572, 5089);
            CallChecker.varInit(value, "value", 142, 4572, 5089);
            CallChecker.varInit(key, "key", 142, 4572, 5089);
            CallChecker.varInit(hashCode, "hashCode", 142, 4572, 5089);
            CallChecker.varInit(next, "next", 142, 4572, 5089);
            CallChecker.varInit(this.values, "values", 142, 4572, 5089);
            CallChecker.varInit(this.keySet, "keySet", 142, 4572, 5089);
            CallChecker.varInit(this.entrySet, "entrySet", 142, 4572, 5089);
            CallChecker.varInit(this.modCount, "modCount", 142, 4572, 5089);
            CallChecker.varInit(this.threshold, "threshold", 142, 4572, 5089);
            CallChecker.varInit(this.data, "data", 142, 4572, 5089);
            CallChecker.varInit(this.size, "size", 142, 4572, 5089);
            CallChecker.varInit(this.loadFactor, "loadFactor", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 142, 4572, 5089);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 142, 4572, 5089);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.IdentityMap.serialVersionUID", 142, 4572, 5089);
            return new IdentityMap.IdentityEntry<K, V>(next, hashCode, key, value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IdentityMap.IdentityEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context754.methodEnd();
        }
    }

    protected static class IdentityEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected IdentityEntry(AbstractHashedMap.HashEntry<K, V> next, int hashCode, K key, V value) {
            super(next, hashCode, key, value);
            MethodContext _bcornu_methode_context140 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context140.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context755 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 157, 5429, 5838);
                CallChecker.varInit(obj, "obj", 157, 5429, 5838);
                CallChecker.varInit(this.value, "value", 157, 5429, 5838);
                CallChecker.varInit(this.key, "key", 157, 5429, 5838);
                CallChecker.varInit(this.hashCode, "hashCode", 157, 5429, 5838);
                CallChecker.varInit(this.next, "next", 157, 5429, 5838);
                if (obj == (this)) {
                    return true;
                }
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> other = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "other", 164, 5666, 5711);
                return ((getKey()) == (other.getKey())) && ((getValue()) == (other.getValue()));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context755.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context756 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 171, 5849, 6010);
                CallChecker.varInit(this.value, "value", 171, 5849, 6010);
                CallChecker.varInit(this.key, "key", 171, 5849, 6010);
                CallChecker.varInit(this.hashCode, "hashCode", 171, 5849, 6010);
                CallChecker.varInit(this.next, "next", 171, 5849, 6010);
                return (System.identityHashCode(getKey())) ^ (System.identityHashCode(getValue()));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context756.methodEnd();
            }
        }
    }

    @Override
    public IdentityMap<K, V> clone() {
        MethodContext _bcornu_methode_context757 = new MethodContext(IdentityMap.class);
        try {
            CallChecker.varInit(this, "this", 184, 6023, 6316);
            CallChecker.varInit(this.values, "values", 184, 6023, 6316);
            CallChecker.varInit(this.keySet, "keySet", 184, 6023, 6316);
            CallChecker.varInit(this.entrySet, "entrySet", 184, 6023, 6316);
            CallChecker.varInit(this.modCount, "modCount", 184, 6023, 6316);
            CallChecker.varInit(this.threshold, "threshold", 184, 6023, 6316);
            CallChecker.varInit(this.data, "data", 184, 6023, 6316);
            CallChecker.varInit(this.size, "size", 184, 6023, 6316);
            CallChecker.varInit(this.loadFactor, "loadFactor", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 184, 6023, 6316);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 184, 6023, 6316);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.IdentityMap.serialVersionUID", 184, 6023, 6316);
            return ((IdentityMap<K, V>) (super.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((IdentityMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context757.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context758 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 191, 6323, 6524);
            CallChecker.varInit(out, "out", 191, 6323, 6524);
            CallChecker.varInit(this.values, "values", 191, 6323, 6524);
            CallChecker.varInit(this.keySet, "keySet", 191, 6323, 6524);
            CallChecker.varInit(this.entrySet, "entrySet", 191, 6323, 6524);
            CallChecker.varInit(this.modCount, "modCount", 191, 6323, 6524);
            CallChecker.varInit(this.threshold, "threshold", 191, 6323, 6524);
            CallChecker.varInit(this.data, "data", 191, 6323, 6524);
            CallChecker.varInit(this.size, "size", 191, 6323, 6524);
            CallChecker.varInit(this.loadFactor, "loadFactor", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 191, 6323, 6524);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 191, 6323, 6524);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.IdentityMap.serialVersionUID", 191, 6323, 6524);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 192, 6466, 6468)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 192, 6466, 6468);
                CallChecker.isCalled(out, ObjectOutputStream.class, 192, 6466, 6468).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context758.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context759 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 199, 6531, 6747);
            CallChecker.varInit(in, "in", 199, 6531, 6747);
            CallChecker.varInit(this.values, "values", 199, 6531, 6747);
            CallChecker.varInit(this.keySet, "keySet", 199, 6531, 6747);
            CallChecker.varInit(this.entrySet, "entrySet", 199, 6531, 6747);
            CallChecker.varInit(this.modCount, "modCount", 199, 6531, 6747);
            CallChecker.varInit(this.threshold, "threshold", 199, 6531, 6747);
            CallChecker.varInit(this.data, "data", 199, 6531, 6747);
            CallChecker.varInit(this.size, "size", 199, 6531, 6747);
            CallChecker.varInit(this.loadFactor, "loadFactor", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 199, 6531, 6747);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 199, 6531, 6747);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.IdentityMap.serialVersionUID", 199, 6531, 6747);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 200, 6693, 6694)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 200, 6693, 6694);
                CallChecker.isCalled(in, ObjectInputStream.class, 200, 6693, 6694).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context759.methodEnd();
        }
    }
}

