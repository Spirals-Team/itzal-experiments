package org.apache.commons.collections.map;

import java.lang.ref.WeakReference;
import java.lang.ref.SoftReference;
import java.util.Set;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.Reference;
import java.io.ObjectOutputStream;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.keyvalue.DefaultMapEntry;
import java.util.ConcurrentModificationException;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import java.io.ObjectInputStream;

public abstract class AbstractReferenceMap<K, V> extends AbstractHashedMap<K, V> {
    public static enum ReferenceStrength {
HARD(0), SOFT(1), WEAK(2);
        public final int value;

        public static AbstractReferenceMap.ReferenceStrength resolve(int value) {
            MethodContext _bcornu_methode_context2603 = new MethodContext(AbstractReferenceMap.ReferenceStrength.class);
            try {
                CallChecker.varInit(value, "value", 102, 4048, 4568);
                switch (value) {
                    case 0 :
                        return AbstractReferenceMap.ReferenceStrength.HARD;
                    case 1 :
                        return AbstractReferenceMap.ReferenceStrength.SOFT;
                    case 2 :
                        return AbstractReferenceMap.ReferenceStrength.WEAK;
                    default :
                        throw new IllegalArgumentException();
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractReferenceMap.ReferenceStrength) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2603.methodEnd();
            }
        }

        private ReferenceStrength(int value) {
            MethodContext _bcornu_methode_context487 = new MethodContext(null);
            try {
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 116, 4630, 4648);
            } finally {
                _bcornu_methode_context487.methodEnd();
            }
        }
    }

    protected AbstractReferenceMap.ReferenceStrength keyType;

    protected AbstractReferenceMap.ReferenceStrength valueType;

    protected boolean purgeValues;

    private transient ReferenceQueue<Object> queue;

    protected AbstractReferenceMap() {
        super();
        MethodContext _bcornu_methode_context488 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context488.methodEnd();
        }
    }

    protected AbstractReferenceMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType, int capacity, float loadFactor, boolean purgeValues) {
        super(capacity, loadFactor);
        MethodContext _bcornu_methode_context489 = new MethodContext(null);
        try {
            this.keyType = keyType;
            CallChecker.varAssign(this.keyType, "this.keyType", 167, 6174, 6196);
            this.valueType = valueType;
            CallChecker.varAssign(this.valueType, "this.valueType", 168, 6206, 6232);
            this.purgeValues = purgeValues;
            CallChecker.varAssign(this.purgeValues, "this.purgeValues", 169, 6242, 6272);
        } finally {
            _bcornu_methode_context489.methodEnd();
        }
    }

    @Override
    protected void init() {
        MethodContext _bcornu_methode_context2604 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 176, 6285, 6470);
            CallChecker.varInit(this.values, "values", 176, 6285, 6470);
            CallChecker.varInit(this.keySet, "keySet", 176, 6285, 6470);
            CallChecker.varInit(this.entrySet, "entrySet", 176, 6285, 6470);
            CallChecker.varInit(this.modCount, "modCount", 176, 6285, 6470);
            CallChecker.varInit(this.threshold, "threshold", 176, 6285, 6470);
            CallChecker.varInit(this.data, "data", 176, 6285, 6470);
            CallChecker.varInit(this.size, "size", 176, 6285, 6470);
            CallChecker.varInit(this.loadFactor, "loadFactor", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 176, 6285, 6470);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 176, 6285, 6470);
            CallChecker.varInit(this.queue, "queue", 176, 6285, 6470);
            CallChecker.varInit(this.purgeValues, "purgeValues", 176, 6285, 6470);
            CallChecker.varInit(this.valueType, "valueType", 176, 6285, 6470);
            CallChecker.varInit(this.keyType, "keyType", 176, 6285, 6470);
            queue = new ReferenceQueue<Object>();
            CallChecker.varAssign(this.queue, "this.queue", 177, 6428, 6464);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2604.methodEnd();
        }
    }

    @Override
    public int size() {
        MethodContext _bcornu_methode_context2605 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 187, 6477, 6729);
            CallChecker.varInit(this.values, "values", 187, 6477, 6729);
            CallChecker.varInit(this.keySet, "keySet", 187, 6477, 6729);
            CallChecker.varInit(this.entrySet, "entrySet", 187, 6477, 6729);
            CallChecker.varInit(this.modCount, "modCount", 187, 6477, 6729);
            CallChecker.varInit(this.threshold, "threshold", 187, 6477, 6729);
            CallChecker.varInit(this.data, "data", 187, 6477, 6729);
            CallChecker.varInit(this.size, "size", 187, 6477, 6729);
            CallChecker.varInit(this.loadFactor, "loadFactor", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 187, 6477, 6729);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 187, 6477, 6729);
            CallChecker.varInit(this.queue, "queue", 187, 6477, 6729);
            CallChecker.varInit(this.purgeValues, "purgeValues", 187, 6477, 6729);
            CallChecker.varInit(this.valueType, "valueType", 187, 6477, 6729);
            CallChecker.varInit(this.keyType, "keyType", 187, 6477, 6729);
            purgeBeforeRead();
            return super.size();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2605.methodEnd();
        }
    }

    @Override
    public boolean isEmpty() {
        MethodContext _bcornu_methode_context2606 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 198, 6736, 6967);
            CallChecker.varInit(this.values, "values", 198, 6736, 6967);
            CallChecker.varInit(this.keySet, "keySet", 198, 6736, 6967);
            CallChecker.varInit(this.entrySet, "entrySet", 198, 6736, 6967);
            CallChecker.varInit(this.modCount, "modCount", 198, 6736, 6967);
            CallChecker.varInit(this.threshold, "threshold", 198, 6736, 6967);
            CallChecker.varInit(this.data, "data", 198, 6736, 6967);
            CallChecker.varInit(this.size, "size", 198, 6736, 6967);
            CallChecker.varInit(this.loadFactor, "loadFactor", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 198, 6736, 6967);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 198, 6736, 6967);
            CallChecker.varInit(this.queue, "queue", 198, 6736, 6967);
            CallChecker.varInit(this.purgeValues, "purgeValues", 198, 6736, 6967);
            CallChecker.varInit(this.valueType, "valueType", 198, 6736, 6967);
            CallChecker.varInit(this.keyType, "keyType", 198, 6736, 6967);
            purgeBeforeRead();
            return super.isEmpty();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2606.methodEnd();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context2607 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 210, 6974, 7381);
            CallChecker.varInit(key, "key", 210, 6974, 7381);
            CallChecker.varInit(this.values, "values", 210, 6974, 7381);
            CallChecker.varInit(this.keySet, "keySet", 210, 6974, 7381);
            CallChecker.varInit(this.entrySet, "entrySet", 210, 6974, 7381);
            CallChecker.varInit(this.modCount, "modCount", 210, 6974, 7381);
            CallChecker.varInit(this.threshold, "threshold", 210, 6974, 7381);
            CallChecker.varInit(this.data, "data", 210, 6974, 7381);
            CallChecker.varInit(this.size, "size", 210, 6974, 7381);
            CallChecker.varInit(this.loadFactor, "loadFactor", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 210, 6974, 7381);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 210, 6974, 7381);
            CallChecker.varInit(this.queue, "queue", 210, 6974, 7381);
            CallChecker.varInit(this.purgeValues, "purgeValues", 210, 6974, 7381);
            CallChecker.varInit(this.valueType, "valueType", 210, 6974, 7381);
            CallChecker.varInit(this.keyType, "keyType", 210, 6974, 7381);
            purgeBeforeRead();
            Map.Entry<K, V> entry = CallChecker.varInit(getEntry(key), "entry", 212, 7234, 7267);
            if (entry == null) {
                return false;
            }
            return (entry.getValue()) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2607.methodEnd();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context2608 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 226, 7388, 7764);
            CallChecker.varInit(value, "value", 226, 7388, 7764);
            CallChecker.varInit(this.values, "values", 226, 7388, 7764);
            CallChecker.varInit(this.keySet, "keySet", 226, 7388, 7764);
            CallChecker.varInit(this.entrySet, "entrySet", 226, 7388, 7764);
            CallChecker.varInit(this.modCount, "modCount", 226, 7388, 7764);
            CallChecker.varInit(this.threshold, "threshold", 226, 7388, 7764);
            CallChecker.varInit(this.data, "data", 226, 7388, 7764);
            CallChecker.varInit(this.size, "size", 226, 7388, 7764);
            CallChecker.varInit(this.loadFactor, "loadFactor", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 226, 7388, 7764);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 226, 7388, 7764);
            CallChecker.varInit(this.queue, "queue", 226, 7388, 7764);
            CallChecker.varInit(this.purgeValues, "purgeValues", 226, 7388, 7764);
            CallChecker.varInit(this.valueType, "valueType", 226, 7388, 7764);
            CallChecker.varInit(this.keyType, "keyType", 226, 7388, 7764);
            purgeBeforeRead();
            if (value == null) {
                return false;
            }
            return super.containsValue(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2608.methodEnd();
        }
    }

    @Override
    public V get(Object key) {
        purgeBeforeRead();
        Map.Entry<K, V> entry = CallChecker.varInit(getEntry(key), "entry", 243, 7998, 8031);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("null keys not allowed");
        }
        if (value == null) {
            throw new NullPointerException("null values not allowed");
        }
        purgeBeforeWrite();
        return super.put(key, value);
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            return null;
        }
        purgeBeforeWrite();
        return super.remove(key);
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2612 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 292, 9219, 9381);
            CallChecker.varInit(this.values, "values", 292, 9219, 9381);
            CallChecker.varInit(this.keySet, "keySet", 292, 9219, 9381);
            CallChecker.varInit(this.entrySet, "entrySet", 292, 9219, 9381);
            CallChecker.varInit(this.modCount, "modCount", 292, 9219, 9381);
            CallChecker.varInit(this.threshold, "threshold", 292, 9219, 9381);
            CallChecker.varInit(this.data, "data", 292, 9219, 9381);
            CallChecker.varInit(this.size, "size", 292, 9219, 9381);
            CallChecker.varInit(this.loadFactor, "loadFactor", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 292, 9219, 9381);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 292, 9219, 9381);
            CallChecker.varInit(this.queue, "queue", 292, 9219, 9381);
            CallChecker.varInit(this.purgeValues, "purgeValues", 292, 9219, 9381);
            CallChecker.varInit(this.valueType, "valueType", 292, 9219, 9381);
            CallChecker.varInit(this.keyType, "keyType", 292, 9219, 9381);
            super.clear();
            queue = CallChecker.beforeCalled(queue, ReferenceQueue.class, 294, 9333, 9337);
            while ((CallChecker.isCalled(queue, ReferenceQueue.class, 294, 9333, 9337).poll()) != null) {
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2612.methodEnd();
        }
    }

    @Override
    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context2613 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 305, 9388, 9737);
            CallChecker.varInit(this.values, "values", 305, 9388, 9737);
            CallChecker.varInit(this.keySet, "keySet", 305, 9388, 9737);
            CallChecker.varInit(this.entrySet, "entrySet", 305, 9388, 9737);
            CallChecker.varInit(this.modCount, "modCount", 305, 9388, 9737);
            CallChecker.varInit(this.threshold, "threshold", 305, 9388, 9737);
            CallChecker.varInit(this.data, "data", 305, 9388, 9737);
            CallChecker.varInit(this.size, "size", 305, 9388, 9737);
            CallChecker.varInit(this.loadFactor, "loadFactor", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 305, 9388, 9737);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 305, 9388, 9737);
            CallChecker.varInit(this.queue, "queue", 305, 9388, 9737);
            CallChecker.varInit(this.purgeValues, "purgeValues", 305, 9388, 9737);
            CallChecker.varInit(this.valueType, "valueType", 305, 9388, 9737);
            CallChecker.varInit(this.keyType, "keyType", 305, 9388, 9737);
            return new AbstractReferenceMap.ReferenceMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2613.methodEnd();
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context2614 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 317, 9744, 10227);
            CallChecker.varInit(this.values, "values", 317, 9744, 10227);
            CallChecker.varInit(this.keySet, "keySet", 317, 9744, 10227);
            CallChecker.varInit(this.entrySet, "entrySet", 317, 9744, 10227);
            CallChecker.varInit(this.modCount, "modCount", 317, 9744, 10227);
            CallChecker.varInit(this.threshold, "threshold", 317, 9744, 10227);
            CallChecker.varInit(this.data, "data", 317, 9744, 10227);
            CallChecker.varInit(this.size, "size", 317, 9744, 10227);
            CallChecker.varInit(this.loadFactor, "loadFactor", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 317, 9744, 10227);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 317, 9744, 10227);
            CallChecker.varInit(this.queue, "queue", 317, 9744, 10227);
            CallChecker.varInit(this.purgeValues, "purgeValues", 317, 9744, 10227);
            CallChecker.varInit(this.valueType, "valueType", 317, 9744, 10227);
            CallChecker.varInit(this.keyType, "keyType", 317, 9744, 10227);
            if ((entrySet) == null) {
                entrySet = new AbstractReferenceMap.ReferenceEntrySet<K, V>(this);
                CallChecker.varAssign(this.entrySet, "this.entrySet", 319, 10142, 10186);
            }
            return entrySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2614.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context2615 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 330, 10234, 10505);
            CallChecker.varInit(this.values, "values", 330, 10234, 10505);
            CallChecker.varInit(this.keySet, "keySet", 330, 10234, 10505);
            CallChecker.varInit(this.entrySet, "entrySet", 330, 10234, 10505);
            CallChecker.varInit(this.modCount, "modCount", 330, 10234, 10505);
            CallChecker.varInit(this.threshold, "threshold", 330, 10234, 10505);
            CallChecker.varInit(this.data, "data", 330, 10234, 10505);
            CallChecker.varInit(this.size, "size", 330, 10234, 10505);
            CallChecker.varInit(this.loadFactor, "loadFactor", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 330, 10234, 10505);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 330, 10234, 10505);
            CallChecker.varInit(this.queue, "queue", 330, 10234, 10505);
            CallChecker.varInit(this.purgeValues, "purgeValues", 330, 10234, 10505);
            CallChecker.varInit(this.valueType, "valueType", 330, 10234, 10505);
            CallChecker.varInit(this.keyType, "keyType", 330, 10234, 10505);
            if ((keySet) == null) {
                keySet = new AbstractReferenceMap.ReferenceKeySet<K>(this);
                CallChecker.varAssign(this.keySet, "this.keySet", 332, 10429, 10466);
            }
            return keySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2615.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context2616 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 343, 10512, 10801);
            CallChecker.varInit(this.values, "values", 343, 10512, 10801);
            CallChecker.varInit(this.keySet, "keySet", 343, 10512, 10801);
            CallChecker.varInit(this.entrySet, "entrySet", 343, 10512, 10801);
            CallChecker.varInit(this.modCount, "modCount", 343, 10512, 10801);
            CallChecker.varInit(this.threshold, "threshold", 343, 10512, 10801);
            CallChecker.varInit(this.data, "data", 343, 10512, 10801);
            CallChecker.varInit(this.size, "size", 343, 10512, 10801);
            CallChecker.varInit(this.loadFactor, "loadFactor", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 343, 10512, 10801);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 343, 10512, 10801);
            CallChecker.varInit(this.queue, "queue", 343, 10512, 10801);
            CallChecker.varInit(this.purgeValues, "purgeValues", 343, 10512, 10801);
            CallChecker.varInit(this.valueType, "valueType", 343, 10512, 10801);
            CallChecker.varInit(this.keyType, "keyType", 343, 10512, 10801);
            if ((values) == null) {
                values = new AbstractReferenceMap.ReferenceValues<V>(this);
                CallChecker.varAssign(this.values, "this.values", 345, 10725, 10762);
            }
            return values;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2616.methodEnd();
        }
    }

    protected void purgeBeforeRead() {
        MethodContext _bcornu_methode_context2617 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 356, 10808, 11118);
            CallChecker.varInit(this.values, "values", 356, 10808, 11118);
            CallChecker.varInit(this.keySet, "keySet", 356, 10808, 11118);
            CallChecker.varInit(this.entrySet, "entrySet", 356, 10808, 11118);
            CallChecker.varInit(this.modCount, "modCount", 356, 10808, 11118);
            CallChecker.varInit(this.threshold, "threshold", 356, 10808, 11118);
            CallChecker.varInit(this.data, "data", 356, 10808, 11118);
            CallChecker.varInit(this.size, "size", 356, 10808, 11118);
            CallChecker.varInit(this.loadFactor, "loadFactor", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 356, 10808, 11118);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 356, 10808, 11118);
            CallChecker.varInit(this.queue, "queue", 356, 10808, 11118);
            CallChecker.varInit(this.purgeValues, "purgeValues", 356, 10808, 11118);
            CallChecker.varInit(this.valueType, "valueType", 356, 10808, 11118);
            CallChecker.varInit(this.keyType, "keyType", 356, 10808, 11118);
            purge();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2617.methodEnd();
        }
    }

    protected void purgeBeforeWrite() {
        MethodContext _bcornu_methode_context2618 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 365, 11125, 11359);
            CallChecker.varInit(this.values, "values", 365, 11125, 11359);
            CallChecker.varInit(this.keySet, "keySet", 365, 11125, 11359);
            CallChecker.varInit(this.entrySet, "entrySet", 365, 11125, 11359);
            CallChecker.varInit(this.modCount, "modCount", 365, 11125, 11359);
            CallChecker.varInit(this.threshold, "threshold", 365, 11125, 11359);
            CallChecker.varInit(this.data, "data", 365, 11125, 11359);
            CallChecker.varInit(this.size, "size", 365, 11125, 11359);
            CallChecker.varInit(this.loadFactor, "loadFactor", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 365, 11125, 11359);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 365, 11125, 11359);
            CallChecker.varInit(this.queue, "queue", 365, 11125, 11359);
            CallChecker.varInit(this.purgeValues, "purgeValues", 365, 11125, 11359);
            CallChecker.varInit(this.valueType, "valueType", 365, 11125, 11359);
            CallChecker.varInit(this.keyType, "keyType", 365, 11125, 11359);
            purge();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2618.methodEnd();
        }
    }

    protected void purge() {
        MethodContext _bcornu_methode_context2619 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 377, 11366, 11805);
            CallChecker.varInit(this.values, "values", 377, 11366, 11805);
            CallChecker.varInit(this.keySet, "keySet", 377, 11366, 11805);
            CallChecker.varInit(this.entrySet, "entrySet", 377, 11366, 11805);
            CallChecker.varInit(this.modCount, "modCount", 377, 11366, 11805);
            CallChecker.varInit(this.threshold, "threshold", 377, 11366, 11805);
            CallChecker.varInit(this.data, "data", 377, 11366, 11805);
            CallChecker.varInit(this.size, "size", 377, 11366, 11805);
            CallChecker.varInit(this.loadFactor, "loadFactor", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 377, 11366, 11805);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 377, 11366, 11805);
            CallChecker.varInit(this.queue, "queue", 377, 11366, 11805);
            CallChecker.varInit(this.purgeValues, "purgeValues", 377, 11366, 11805);
            CallChecker.varInit(this.valueType, "valueType", 377, 11366, 11805);
            CallChecker.varInit(this.keyType, "keyType", 377, 11366, 11805);
            Reference<?> ref = CallChecker.init(Reference.class);
            if (CallChecker.beforeDeref(queue, ReferenceQueue.class, 378, 11691, 11695)) {
                queue = CallChecker.beforeCalled(queue, ReferenceQueue.class, 378, 11691, 11695);
                ref = CallChecker.isCalled(queue, ReferenceQueue.class, 378, 11691, 11695).poll();
                CallChecker.varAssign(ref, "ref", 378, 11691, 11695);
            }
            while (ref != null) {
                purge(ref);
                if (CallChecker.beforeDeref(queue, ReferenceQueue.class, 381, 11777, 11781)) {
                    queue = CallChecker.beforeCalled(queue, ReferenceQueue.class, 381, 11777, 11781);
                    ref = CallChecker.isCalled(queue, ReferenceQueue.class, 381, 11777, 11781).poll();
                    CallChecker.varAssign(ref, "ref", 381, 11771, 11789);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2619.methodEnd();
        }
    }

    protected void purge(Reference<?> ref) {
        MethodContext _bcornu_methode_context2620 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 390, 11812, 12694);
            CallChecker.varInit(ref, "ref", 390, 11812, 12694);
            CallChecker.varInit(this.values, "values", 390, 11812, 12694);
            CallChecker.varInit(this.keySet, "keySet", 390, 11812, 12694);
            CallChecker.varInit(this.entrySet, "entrySet", 390, 11812, 12694);
            CallChecker.varInit(this.modCount, "modCount", 390, 11812, 12694);
            CallChecker.varInit(this.threshold, "threshold", 390, 11812, 12694);
            CallChecker.varInit(this.data, "data", 390, 11812, 12694);
            CallChecker.varInit(this.size, "size", 390, 11812, 12694);
            CallChecker.varInit(this.loadFactor, "loadFactor", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 390, 11812, 12694);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 390, 11812, 12694);
            CallChecker.varInit(this.queue, "queue", 390, 11812, 12694);
            CallChecker.varInit(this.purgeValues, "purgeValues", 390, 11812, 12694);
            CallChecker.varInit(this.valueType, "valueType", 390, 11812, 12694);
            CallChecker.varInit(this.keyType, "keyType", 390, 11812, 12694);
            int hash = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(ref, Reference.class, 394, 12128, 12130)) {
                ref = CallChecker.beforeCalled(ref, Reference.class, 394, 12128, 12130);
                hash = CallChecker.isCalled(ref, Reference.class, 394, 12128, 12130).hashCode();
                CallChecker.varAssign(hash, "hash", 394, 12128, 12130);
            }
            int index = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 395, 12180, 12183)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 395, 12180, 12183);
                index = hashIndex(hash, CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 395, 12180, 12183).length);
                CallChecker.varAssign(index, "index", 395, 12180, 12183);
            }
            AbstractHashedMap.HashEntry<K, V> previous = CallChecker.varInit(null, "previous", 396, 12202, 12233);
            AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 397, 12267, 12270)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 397, 12267, 12270);
                entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 397, 12267, 12270)[index];
                CallChecker.varAssign(entry, "entry", 397, 12267, 12270);
            }
            while (entry != null) {
                if (((AbstractReferenceMap.ReferenceEntry<K, V>) (entry)).purge(ref)) {
                    if (previous == null) {
                        if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 401, 12433, 12436)) {
                            data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 401, 12433, 12436);
                            CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 401, 12433, 12436)[index] = entry.next;
                            CallChecker.varAssign(CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 401, 12433, 12436)[index], "CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 401, 12433, 12436)[index]", 401, 12433, 12457);
                        }
                    }else {
                        previous.next = entry.next;
                        CallChecker.varAssign(previous.next, "previous.next", 403, 12504, 12530);
                    }
                    (this.size)--;
                    return ;
                }
                previous = entry;
                CallChecker.varAssign(previous, "previous", 408, 12629, 12645);
                entry = entry.next;
                CallChecker.varAssign(entry, "entry", 409, 12659, 12677);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2620.methodEnd();
        }
    }

    @Override
    protected AbstractHashedMap.HashEntry<K, V> getEntry(Object key) {
        MethodContext _bcornu_methode_context2621 = new MethodContext(AbstractHashedMap.HashEntry.class);
        try {
            CallChecker.varInit(this, "this", 422, 12701, 13088);
            CallChecker.varInit(key, "key", 422, 12701, 13088);
            CallChecker.varInit(this.values, "values", 422, 12701, 13088);
            CallChecker.varInit(this.keySet, "keySet", 422, 12701, 13088);
            CallChecker.varInit(this.entrySet, "entrySet", 422, 12701, 13088);
            CallChecker.varInit(this.modCount, "modCount", 422, 12701, 13088);
            CallChecker.varInit(this.threshold, "threshold", 422, 12701, 13088);
            CallChecker.varInit(this.data, "data", 422, 12701, 13088);
            CallChecker.varInit(this.size, "size", 422, 12701, 13088);
            CallChecker.varInit(this.loadFactor, "loadFactor", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 422, 12701, 13088);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 422, 12701, 13088);
            CallChecker.varInit(this.queue, "queue", 422, 12701, 13088);
            CallChecker.varInit(this.purgeValues, "purgeValues", 422, 12701, 13088);
            CallChecker.varInit(this.valueType, "valueType", 422, 12701, 13088);
            CallChecker.varInit(this.keyType, "keyType", 422, 12701, 13088);
            if (key == null) {
                return null;
            }
            return super.getEntry(key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractHashedMap.HashEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2621.methodEnd();
        }
    }

    protected int hashEntry(Object key, Object value) {
        MethodContext _bcornu_methode_context2622 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 437, 13095, 13595);
            CallChecker.varInit(value, "value", 437, 13095, 13595);
            CallChecker.varInit(key, "key", 437, 13095, 13595);
            CallChecker.varInit(this.values, "values", 437, 13095, 13595);
            CallChecker.varInit(this.keySet, "keySet", 437, 13095, 13595);
            CallChecker.varInit(this.entrySet, "entrySet", 437, 13095, 13595);
            CallChecker.varInit(this.modCount, "modCount", 437, 13095, 13595);
            CallChecker.varInit(this.threshold, "threshold", 437, 13095, 13595);
            CallChecker.varInit(this.data, "data", 437, 13095, 13595);
            CallChecker.varInit(this.size, "size", 437, 13095, 13595);
            CallChecker.varInit(this.loadFactor, "loadFactor", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 437, 13095, 13595);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 437, 13095, 13595);
            CallChecker.varInit(this.queue, "queue", 437, 13095, 13595);
            CallChecker.varInit(this.purgeValues, "purgeValues", 437, 13095, 13595);
            CallChecker.varInit(this.valueType, "valueType", 437, 13095, 13595);
            CallChecker.varInit(this.keyType, "keyType", 437, 13095, 13595);
            if ((key == null) || (CallChecker.beforeDeref(key, Object.class, 438, 13518, 13520))) {
                if ((value == null) || (CallChecker.beforeDeref(value, Object.class, 439, 13572, 13576))) {
                    key = CallChecker.beforeCalled(key, Object.class, 438, 13518, 13520);
                    value = CallChecker.beforeCalled(value, Object.class, 439, 13572, 13576);
                    return ((key == null) ? 0 : CallChecker.isCalled(key, Object.class, 438, 13518, 13520).hashCode()) ^ ((value == null) ? 0 : CallChecker.isCalled(value, Object.class, 439, 13572, 13576).hashCode());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2622.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    protected boolean isEqualKey(Object key1, Object key2) {
        MethodContext _bcornu_methode_context2623 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 454, 13602, 14256);
            CallChecker.varInit(key2, "key2", 454, 13602, 14256);
            CallChecker.varInit(key1, "key1", 454, 13602, 14256);
            CallChecker.varInit(this.values, "values", 454, 13602, 14256);
            CallChecker.varInit(this.keySet, "keySet", 454, 13602, 14256);
            CallChecker.varInit(this.entrySet, "entrySet", 454, 13602, 14256);
            CallChecker.varInit(this.modCount, "modCount", 454, 13602, 14256);
            CallChecker.varInit(this.threshold, "threshold", 454, 13602, 14256);
            CallChecker.varInit(this.data, "data", 454, 13602, 14256);
            CallChecker.varInit(this.size, "size", 454, 13602, 14256);
            CallChecker.varInit(this.loadFactor, "loadFactor", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 454, 13602, 14256);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 454, 13602, 14256);
            CallChecker.varInit(this.queue, "queue", 454, 13602, 14256);
            CallChecker.varInit(this.purgeValues, "purgeValues", 454, 13602, 14256);
            CallChecker.varInit(this.valueType, "valueType", 454, 13602, 14256);
            CallChecker.varInit(this.keyType, "keyType", 454, 13602, 14256);
            if ((keyType) == (AbstractReferenceMap.ReferenceStrength.HARD)) {
                key2 = key2;
                CallChecker.varAssign(key2, "key2", 455, 14119, 14198);
            }else {
                if (CallChecker.beforeDeref(key2, Object.class, 455, 14186, 14189)) {
                    key2 = ((Reference<K>) (key2)).get();
                    CallChecker.varAssign(key2, "key2", 455, 14119, 14198);
                }
            }
            key1 = CallChecker.beforeCalled(key1, Object.class, 456, 14232, 14235);
            return (key1 == key2) || (CallChecker.isCalled(key1, Object.class, 456, 14232, 14235).equals(key2));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2623.methodEnd();
        }
    }

    @Override
    protected AbstractReferenceMap.ReferenceEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> next, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context2624 = new MethodContext(AbstractReferenceMap.ReferenceEntry.class);
        try {
            CallChecker.varInit(this, "this", 469, 14263, 14739);
            CallChecker.varInit(value, "value", 469, 14263, 14739);
            CallChecker.varInit(key, "key", 469, 14263, 14739);
            CallChecker.varInit(hashCode, "hashCode", 469, 14263, 14739);
            CallChecker.varInit(next, "next", 469, 14263, 14739);
            CallChecker.varInit(this.values, "values", 469, 14263, 14739);
            CallChecker.varInit(this.keySet, "keySet", 469, 14263, 14739);
            CallChecker.varInit(this.entrySet, "entrySet", 469, 14263, 14739);
            CallChecker.varInit(this.modCount, "modCount", 469, 14263, 14739);
            CallChecker.varInit(this.threshold, "threshold", 469, 14263, 14739);
            CallChecker.varInit(this.data, "data", 469, 14263, 14739);
            CallChecker.varInit(this.size, "size", 469, 14263, 14739);
            CallChecker.varInit(this.loadFactor, "loadFactor", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 469, 14263, 14739);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 469, 14263, 14739);
            CallChecker.varInit(this.queue, "queue", 469, 14263, 14739);
            CallChecker.varInit(this.purgeValues, "purgeValues", 469, 14263, 14739);
            CallChecker.varInit(this.valueType, "valueType", 469, 14263, 14739);
            CallChecker.varInit(this.keyType, "keyType", 469, 14263, 14739);
            return new AbstractReferenceMap.ReferenceEntry<K, V>(this, next, hashCode, key, value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractReferenceMap.ReferenceEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2624.methodEnd();
        }
    }

    @Override
    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        MethodContext _bcornu_methode_context2625 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 479, 14746, 14983);
            CallChecker.varInit(this.values, "values", 479, 14746, 14983);
            CallChecker.varInit(this.keySet, "keySet", 479, 14746, 14983);
            CallChecker.varInit(this.entrySet, "entrySet", 479, 14746, 14983);
            CallChecker.varInit(this.modCount, "modCount", 479, 14746, 14983);
            CallChecker.varInit(this.threshold, "threshold", 479, 14746, 14983);
            CallChecker.varInit(this.data, "data", 479, 14746, 14983);
            CallChecker.varInit(this.size, "size", 479, 14746, 14983);
            CallChecker.varInit(this.loadFactor, "loadFactor", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 479, 14746, 14983);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 479, 14746, 14983);
            CallChecker.varInit(this.queue, "queue", 479, 14746, 14983);
            CallChecker.varInit(this.purgeValues, "purgeValues", 479, 14746, 14983);
            CallChecker.varInit(this.valueType, "valueType", 479, 14746, 14983);
            CallChecker.varInit(this.keyType, "keyType", 479, 14746, 14983);
            return new AbstractReferenceMap.ReferenceEntrySetIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2625.methodEnd();
        }
    }

    @Override
    protected Iterator<K> createKeySetIterator() {
        MethodContext _bcornu_methode_context2626 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 489, 14990, 15202);
            CallChecker.varInit(this.values, "values", 489, 14990, 15202);
            CallChecker.varInit(this.keySet, "keySet", 489, 14990, 15202);
            CallChecker.varInit(this.entrySet, "entrySet", 489, 14990, 15202);
            CallChecker.varInit(this.modCount, "modCount", 489, 14990, 15202);
            CallChecker.varInit(this.threshold, "threshold", 489, 14990, 15202);
            CallChecker.varInit(this.data, "data", 489, 14990, 15202);
            CallChecker.varInit(this.size, "size", 489, 14990, 15202);
            CallChecker.varInit(this.loadFactor, "loadFactor", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 489, 14990, 15202);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 489, 14990, 15202);
            CallChecker.varInit(this.queue, "queue", 489, 14990, 15202);
            CallChecker.varInit(this.purgeValues, "purgeValues", 489, 14990, 15202);
            CallChecker.varInit(this.valueType, "valueType", 489, 14990, 15202);
            CallChecker.varInit(this.keyType, "keyType", 489, 14990, 15202);
            return new AbstractReferenceMap.ReferenceKeySetIterator<K>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2626.methodEnd();
        }
    }

    @Override
    protected Iterator<V> createValuesIterator() {
        MethodContext _bcornu_methode_context2627 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 499, 15209, 15420);
            CallChecker.varInit(this.values, "values", 499, 15209, 15420);
            CallChecker.varInit(this.keySet, "keySet", 499, 15209, 15420);
            CallChecker.varInit(this.entrySet, "entrySet", 499, 15209, 15420);
            CallChecker.varInit(this.modCount, "modCount", 499, 15209, 15420);
            CallChecker.varInit(this.threshold, "threshold", 499, 15209, 15420);
            CallChecker.varInit(this.data, "data", 499, 15209, 15420);
            CallChecker.varInit(this.size, "size", 499, 15209, 15420);
            CallChecker.varInit(this.loadFactor, "loadFactor", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 499, 15209, 15420);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 499, 15209, 15420);
            CallChecker.varInit(this.queue, "queue", 499, 15209, 15420);
            CallChecker.varInit(this.purgeValues, "purgeValues", 499, 15209, 15420);
            CallChecker.varInit(this.valueType, "valueType", 499, 15209, 15420);
            CallChecker.varInit(this.keyType, "keyType", 499, 15209, 15420);
            return new AbstractReferenceMap.ReferenceValuesIterator<V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2627.methodEnd();
        }
    }

    static class ReferenceEntrySet<K, V> extends AbstractHashedMap.EntrySet<K, V> {
        protected ReferenceEntrySet(AbstractHashedMap<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context490 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context490.methodEnd();
            }
        }

        @Override
        public Object[] toArray() {
            MethodContext _bcornu_methode_context2628 = new MethodContext(Object[].class);
            try {
                CallChecker.varInit(this, "this", 514, 15732, 15829);
                CallChecker.varInit(this.parent, "parent", 514, 15732, 15829);
                return toArray(new Object[0]);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2628.methodEnd();
            }
        }

        @Override
        public <T> T[] toArray(T[] arr) {
            MethodContext _bcornu_methode_context2629 = new MethodContext(null);
            try {
                CallChecker.varInit(this, "this", 519, 15840, 16210);
                CallChecker.varInit(arr, "arr", 519, 15840, 16210);
                CallChecker.varInit(this.parent, "parent", 519, 15840, 16210);
                ArrayList<Map.Entry<K, V>> list = CallChecker.varInit(new ArrayList<Map.Entry<K, V>>(), "list", 521, 15973, 16039);
                for (Map.Entry<K, V> entry : this) {
                    if (CallChecker.beforeDeref(list, ArrayList.class, 523, 16106, 16109)) {
                        list = CallChecker.beforeCalled(list, ArrayList.class, 523, 16106, 16109);
                        CallChecker.isCalled(list, ArrayList.class, 523, 16106, 16109).add(new DefaultMapEntry<K, V>(entry));
                    }
                }
                if (CallChecker.beforeDeref(list, ArrayList.class, 525, 16183, 16186)) {
                    list = CallChecker.beforeCalled(list, ArrayList.class, 525, 16183, 16186);
                    return CallChecker.isCalled(list, ArrayList.class, 525, 16183, 16186).toArray(arr);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((T[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2629.methodEnd();
            }
        }
    }

    static class ReferenceKeySet<K> extends AbstractHashedMap.KeySet<K> {
        protected ReferenceKeySet(AbstractHashedMap<K, ?> parent) {
            super(parent);
            MethodContext _bcornu_methode_context491 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context491.methodEnd();
            }
        }

        @Override
        public Object[] toArray() {
            MethodContext _bcornu_methode_context2630 = new MethodContext(Object[].class);
            try {
                CallChecker.varInit(this, "this", 540, 16514, 16611);
                CallChecker.varInit(this.parent, "parent", 540, 16514, 16611);
                return toArray(new Object[0]);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2630.methodEnd();
            }
        }

        @Override
        public <T> T[] toArray(T[] arr) {
            MethodContext _bcornu_methode_context2631 = new MethodContext(null);
            try {
                CallChecker.varInit(this, "this", 545, 16622, 16924);
                CallChecker.varInit(arr, "arr", 545, 16622, 16924);
                CallChecker.varInit(this.parent, "parent", 545, 16622, 16924);
                List<K> list = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 547, 16784, 16789)) {
                    list = new ArrayList<K>(CallChecker.isCalled(parent, AbstractHashedMap.class, 547, 16784, 16789).size());
                    CallChecker.varAssign(list, "list", 547, 16784, 16789);
                }
                for (K key : this) {
                    if (CallChecker.beforeDeref(list, List.class, 549, 16849, 16852)) {
                        list = CallChecker.beforeCalled(list, List.class, 549, 16849, 16852);
                        CallChecker.isCalled(list, List.class, 549, 16849, 16852).add(key);
                    }
                }
                if (CallChecker.beforeDeref(list, List.class, 551, 16897, 16900)) {
                    list = CallChecker.beforeCalled(list, List.class, 551, 16897, 16900);
                    return CallChecker.isCalled(list, List.class, 551, 16897, 16900).toArray(arr);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((T[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2631.methodEnd();
            }
        }
    }

    static class ReferenceValues<V> extends AbstractHashedMap.Values<V> {
        protected ReferenceValues(AbstractHashedMap<?, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context492 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context492.methodEnd();
            }
        }

        @Override
        public Object[] toArray() {
            MethodContext _bcornu_methode_context2632 = new MethodContext(Object[].class);
            try {
                CallChecker.varInit(this, "this", 566, 17228, 17325);
                CallChecker.varInit(this.parent, "parent", 566, 17228, 17325);
                return toArray(new Object[0]);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2632.methodEnd();
            }
        }

        @Override
        public <T> T[] toArray(T[] arr) {
            MethodContext _bcornu_methode_context2633 = new MethodContext(null);
            try {
                CallChecker.varInit(this, "this", 571, 17336, 17644);
                CallChecker.varInit(arr, "arr", 571, 17336, 17644);
                CallChecker.varInit(this.parent, "parent", 571, 17336, 17644);
                List<V> list = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 573, 17500, 17505)) {
                    list = new ArrayList<V>(CallChecker.isCalled(parent, AbstractHashedMap.class, 573, 17500, 17505).size());
                    CallChecker.varAssign(list, "list", 573, 17500, 17505);
                }
                for (V value : this) {
                    if (CallChecker.beforeDeref(list, List.class, 575, 17567, 17570)) {
                        list = CallChecker.beforeCalled(list, List.class, 575, 17567, 17570);
                        CallChecker.isCalled(list, List.class, 575, 17567, 17570).add(value);
                    }
                }
                if (CallChecker.beforeDeref(list, List.class, 577, 17617, 17620)) {
                    list = CallChecker.beforeCalled(list, List.class, 577, 17617, 17620);
                    return CallChecker.isCalled(list, List.class, 577, 17617, 17620).toArray(arr);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((T[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2633.methodEnd();
            }
        }
    }

    protected static class ReferenceEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected final AbstractReferenceMap<K, V> parent;

        public ReferenceEntry(AbstractReferenceMap<K, V> parent, AbstractHashedMap.HashEntry<K, V> next, int hashCode, K key, V value) {
            super(next, hashCode, null, null);
            MethodContext _bcornu_methode_context493 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 605, 18611, 18631);
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 606, 18668, 18673)) {
                    parent = CallChecker.beforeCalled(parent, AbstractReferenceMap.class, 606, 18668, 18673);
                    this.key = toReference(CallChecker.isCalled(parent, AbstractReferenceMap.class, 606, 18668, 18673).keyType, key, hashCode);
                    CallChecker.varAssign(this.key, "this.key", 606, 18645, 18698);
                }
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 607, 18737, 18742)) {
                    parent = CallChecker.beforeCalled(parent, AbstractReferenceMap.class, 607, 18737, 18742);
                    this.value = toReference(CallChecker.isCalled(parent, AbstractReferenceMap.class, 607, 18737, 18742).valueType, value, hashCode);
                    CallChecker.varAssign(this.value, "this.value", 607, 18712, 18771);
                }
            } finally {
                _bcornu_methode_context493.methodEnd();
            }
        }

        @Override
        @SuppressWarnings(value = "unchecked")
        public K getKey() {
            if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 619, 19170, 19175)) {
                if ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 619, 19170, 19175).keyType) == (AbstractReferenceMap.ReferenceStrength.HARD)) {
                    return ((K) (key));
                }else {
                    if (CallChecker.beforeDeref(key, Object.class, 619, 19236, 19238)) {
                        return ((K) (((Reference<K>) (key)).get()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        @SuppressWarnings(value = "unchecked")
        public V getValue() {
            if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 631, 19607, 19612)) {
                if ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 631, 19607, 19612).valueType) == (AbstractReferenceMap.ReferenceStrength.HARD)) {
                    return ((V) (value));
                }else {
                    if (CallChecker.beforeDeref(value, Object.class, 631, 19677, 19681)) {
                        return ((V) (((Reference<V>) (value)).get()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        @SuppressWarnings(value = "unchecked")
        public V setValue(V obj) {
            V old = CallChecker.varInit(getValue(), "old", 643, 19963, 19981);
            if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 644, 19999, 20004)) {
                if ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 644, 19999, 20004).valueType) != (AbstractReferenceMap.ReferenceStrength.HARD)) {
                    if (CallChecker.beforeDeref(value, Object.class, 645, 20077, 20081)) {
                        value = CallChecker.beforeCalled(value, Reference.class, 645, 20077, 20081);
                        CallChecker.isCalled(((Reference<V>) (value)), Reference.class, 645, 20077, 20081).clear();
                    }
                }
            }
            if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 647, 20139, 20144)) {
                value = toReference(CallChecker.isCalled(parent, AbstractReferenceMap.class, 647, 20139, 20144).valueType, obj, hashCode);
                CallChecker.varAssign(this.value, "this.value", 647, 20119, 20171);
            }
            return old;
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context2637 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 661, 20216, 21360);
                CallChecker.varInit(obj, "obj", 661, 20216, 21360);
                CallChecker.varInit(this.value, "value", 661, 20216, 21360);
                CallChecker.varInit(this.key, "key", 661, 20216, 21360);
                CallChecker.varInit(this.hashCode, "hashCode", 661, 20216, 21360);
                CallChecker.varInit(this.next, "next", 661, 20216, 21360);
                CallChecker.varInit(this.parent, "parent", 661, 20216, 21360);
                if (obj == (this)) {
                    return true;
                }
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 669, 20788, 20832);
                Object entryKey = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 670, 20864, 20868)) {
                    entryKey = entry.getKey();
                    CallChecker.varAssign(entryKey, "entryKey", 670, 20864, 20868);
                }
                Object entryValue = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 671, 20942, 20946)) {
                    entryValue = entry.getValue();
                    CallChecker.varAssign(entryValue, "entryValue", 671, 20942, 20946);
                }
                if ((entryKey == null) || (entryValue == null)) {
                    return false;
                }
                return (CallChecker.isCalled(parent, AbstractReferenceMap.class, 677, 21252, 21257).isEqualKey(entryKey, key)) && (CallChecker.isCalled(parent, AbstractReferenceMap.class, 678, 21307, 21312).isEqualValue(entryValue, getValue()));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2637.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2638 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 689, 21371, 21726);
                CallChecker.varInit(this.value, "value", 689, 21371, 21726);
                CallChecker.varInit(this.key, "key", 689, 21371, 21726);
                CallChecker.varInit(this.hashCode, "hashCode", 689, 21371, 21726);
                CallChecker.varInit(this.next, "next", 689, 21371, 21726);
                CallChecker.varInit(this.parent, "parent", 689, 21371, 21726);
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 690, 21678, 21683)) {
                    return CallChecker.isCalled(parent, AbstractReferenceMap.class, 690, 21678, 21683).hashEntry(getKey(), getValue());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2638.methodEnd();
            }
        }

        protected <T> Object toReference(AbstractReferenceMap.ReferenceStrength type, T referent, int hash) {
            MethodContext _bcornu_methode_context2639 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 703, 21737, 22702);
                CallChecker.varInit(hash, "hash", 703, 21737, 22702);
                CallChecker.varInit(referent, "referent", 703, 21737, 22702);
                CallChecker.varInit(type, "type", 703, 21737, 22702);
                CallChecker.varInit(this.value, "value", 703, 21737, 22702);
                CallChecker.varInit(this.key, "key", 703, 21737, 22702);
                CallChecker.varInit(this.hashCode, "hashCode", 703, 21737, 22702);
                CallChecker.varInit(this.next, "next", 703, 21737, 22702);
                CallChecker.varInit(this.parent, "parent", 703, 21737, 22702);
                if (type == (AbstractReferenceMap.ReferenceStrength.HARD)) {
                    return referent;
                }
                if (type == (AbstractReferenceMap.ReferenceStrength.SOFT)) {
                    if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 708, 22501, 22506)) {
                        return new AbstractReferenceMap.SoftRef<T>(hash, referent, CallChecker.isCalled(parent, AbstractReferenceMap.class, 708, 22501, 22506).queue);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (type == (AbstractReferenceMap.ReferenceStrength.WEAK)) {
                    if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 711, 22634, 22639)) {
                        return new AbstractReferenceMap.WeakRef<T>(hash, referent, CallChecker.isCalled(parent, AbstractReferenceMap.class, 711, 22634, 22639).queue);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                throw new Error();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2639.methodEnd();
            }
        }

        boolean purge(Reference<?> ref) {
            MethodContext _bcornu_methode_context2640 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 721, 22713, 23479);
                CallChecker.varInit(ref, "ref", 721, 22713, 23479);
                CallChecker.varInit(this.value, "value", 721, 22713, 23479);
                CallChecker.varInit(this.key, "key", 721, 22713, 23479);
                CallChecker.varInit(this.hashCode, "hashCode", 721, 22713, 23479);
                CallChecker.varInit(this.next, "next", 721, 22713, 23479);
                CallChecker.varInit(this.parent, "parent", 721, 22713, 23479);
                boolean r = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 722, 22917, 22922)) {
                    r = ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 722, 22917, 22922).keyType) != (AbstractReferenceMap.ReferenceStrength.HARD)) && ((key) == ref);
                    CallChecker.varAssign(r, "r", 722, 22917, 22922);
                }
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 723, 22999, 23004)) {
                    r = r || (((CallChecker.isCalled(parent, AbstractReferenceMap.class, 723, 22999, 23004).valueType) != (AbstractReferenceMap.ReferenceStrength.HARD)) && ((value) == ref));
                    CallChecker.varAssign(r, "r", 723, 22988, 23061);
                }
                if (r) {
                    if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 725, 23104, 23109)) {
                        if ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 725, 23104, 23109).keyType) != (AbstractReferenceMap.ReferenceStrength.HARD)) {
                            if (CallChecker.beforeDeref(key, Object.class, 726, 23184, 23186)) {
                                key = CallChecker.beforeCalled(key, Reference.class, 726, 23184, 23186);
                                CallChecker.isCalled(((Reference<?>) (key)), Reference.class, 726, 23184, 23186).clear();
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 728, 23236, 23241)) {
                        if ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 728, 23236, 23241).valueType) != (AbstractReferenceMap.ReferenceStrength.HARD)) {
                            if (CallChecker.beforeDeref(value, Object.class, 729, 23318, 23322)) {
                                value = CallChecker.beforeCalled(value, Reference.class, 729, 23318, 23322);
                                CallChecker.isCalled(((Reference<?>) (value)), Reference.class, 729, 23318, 23322).clear();
                            }
                        }else
                            if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 730, 23361, 23366)) {
                                if (CallChecker.isCalled(parent, AbstractReferenceMap.class, 730, 23361, 23366).purgeValues) {
                                    value = null;
                                    CallChecker.varAssign(this.value, "this.value", 731, 23403, 23415);
                                }
                            }
                        
                    }
                }
                return r;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2640.methodEnd();
            }
        }

        protected AbstractReferenceMap.ReferenceEntry<K, V> next() {
            MethodContext _bcornu_methode_context2641 = new MethodContext(AbstractReferenceMap.ReferenceEntry.class);
            try {
                CallChecker.varInit(this, "this", 742, 23490, 23715);
                CallChecker.varInit(this.value, "value", 742, 23490, 23715);
                CallChecker.varInit(this.key, "key", 742, 23490, 23715);
                CallChecker.varInit(this.hashCode, "hashCode", 742, 23490, 23715);
                CallChecker.varInit(this.next, "next", 742, 23490, 23715);
                CallChecker.varInit(this.parent, "parent", 742, 23490, 23715);
                return ((AbstractReferenceMap.ReferenceEntry<K, V>) (next));
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractReferenceMap.ReferenceEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2641.methodEnd();
            }
        }
    }

    static class ReferenceBaseIterator<K, V> {
        final AbstractReferenceMap<K, V> parent;

        int index;

        AbstractReferenceMap.ReferenceEntry<K, V> entry;

        AbstractReferenceMap.ReferenceEntry<K, V> previous;

        K currentKey;

        K nextKey;

        V currentValue;

        V nextValue;

        int expectedModCount;

        public ReferenceBaseIterator(AbstractReferenceMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context494 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 770, 24536, 24556);
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 771, 24579, 24584)) {
                    parent = CallChecker.beforeCalled(parent, AbstractReferenceMap.class, 771, 24579, 24584);
                    if ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 771, 24579, 24584).size()) != 0) {
                        if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 771, 24600, 24605)) {
                            parent = CallChecker.beforeCalled(parent, AbstractReferenceMap.class, 771, 24600, 24605);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractReferenceMap.class, 771, 24600, 24605).data, AbstractHashedMap.HashEntry[].class, 771, 24600, 24610)) {
                                parent = CallChecker.beforeCalled(parent, AbstractReferenceMap.class, 771, 24600, 24605);
                                index = CallChecker.isCalled(CallChecker.isCalled(parent, AbstractReferenceMap.class, 771, 24600, 24605).data, AbstractHashedMap.HashEntry[].class, 771, 24600, 24610).length;
                                CallChecker.varAssign(this.index, "this.index", 771, 24570, 24623);
                            }
                        }
                    }else {
                        index = 0;
                        CallChecker.varAssign(this.index, "this.index", 771, 24570, 24623);
                    }
                }
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 774, 24764, 24769)) {
                    parent = CallChecker.beforeCalled(parent, AbstractReferenceMap.class, 774, 24764, 24769);
                    expectedModCount = CallChecker.isCalled(parent, AbstractReferenceMap.class, 774, 24764, 24769).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 774, 24745, 24779);
                }
            } finally {
                _bcornu_methode_context494.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2642 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 777, 24800, 25558);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 777, 24800, 25558);
                CallChecker.varInit(this.nextValue, "nextValue", 777, 24800, 25558);
                CallChecker.varInit(this.currentValue, "currentValue", 777, 24800, 25558);
                CallChecker.varInit(this.nextKey, "nextKey", 777, 24800, 25558);
                CallChecker.varInit(this.currentKey, "currentKey", 777, 24800, 25558);
                CallChecker.varInit(this.previous, "previous", 777, 24800, 25558);
                CallChecker.varInit(this.entry, "entry", 777, 24800, 25558);
                CallChecker.varInit(this.index, "index", 777, 24800, 25558);
                CallChecker.varInit(this.parent, "parent", 777, 24800, 25558);
                checkMod();
                while (nextNull()) {
                    AbstractReferenceMap.ReferenceEntry<K, V> e = CallChecker.varInit(entry, "e", 780, 24900, 24930);
                    int i = CallChecker.varInit(((int) (this.index)), "i", 781, 24948, 24961);
                    while ((e == null) && (i > 0)) {
                        i--;
                        if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 784, 25084, 25089)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractReferenceMap.class, 784, 25084, 25089).data, AbstractHashedMap.HashEntry[].class, 784, 25084, 25094)) {
                                e = ((AbstractReferenceMap.ReferenceEntry<K, V>) (CallChecker.isCalled(CallChecker.isCalled(parent, AbstractReferenceMap.class, 784, 25084, 25089).data, AbstractHashedMap.HashEntry[].class, 784, 25084, 25094)[i]));
                                CallChecker.varAssign(e, "e", 784, 25057, 25098);
                            }
                        }
                    } 
                    entry = e;
                    CallChecker.varAssign(this.entry, "this.entry", 786, 25134, 25143);
                    index = i;
                    CallChecker.varAssign(this.index, "this.index", 787, 25161, 25170);
                    if (e == null) {
                        currentKey = null;
                        CallChecker.varAssign(this.currentKey, "this.currentKey", 789, 25225, 25242);
                        currentValue = null;
                        CallChecker.varAssign(this.currentValue, "this.currentValue", 790, 25264, 25283);
                        return false;
                    }
                    nextKey = e.getKey();
                    CallChecker.varAssign(this.nextKey, "this.nextKey", 793, 25353, 25373);
                    nextValue = e.getValue();
                    CallChecker.varAssign(this.nextValue, "this.nextValue", 794, 25391, 25415);
                    if (nextNull()) {
                        if (CallChecker.beforeDeref(entry, AbstractReferenceMap.ReferenceEntry.class, 796, 25479, 25483)) {
                            entry = CallChecker.beforeCalled(entry, AbstractReferenceMap.ReferenceEntry.class, 796, 25479, 25483);
                            entry = CallChecker.isCalled(entry, AbstractReferenceMap.ReferenceEntry.class, 796, 25479, 25483).next();
                            CallChecker.varAssign(this.entry, "this.entry", 796, 25471, 25491);
                        }
                    }
                } 
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2642.methodEnd();
            }
        }

        private void checkMod() {
            MethodContext _bcornu_methode_context2643 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 802, 25569, 25733);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 802, 25569, 25733);
                CallChecker.varInit(this.nextValue, "nextValue", 802, 25569, 25733);
                CallChecker.varInit(this.currentValue, "currentValue", 802, 25569, 25733);
                CallChecker.varInit(this.nextKey, "nextKey", 802, 25569, 25733);
                CallChecker.varInit(this.currentKey, "currentKey", 802, 25569, 25733);
                CallChecker.varInit(this.previous, "previous", 802, 25569, 25733);
                CallChecker.varInit(this.entry, "entry", 802, 25569, 25733);
                CallChecker.varInit(this.index, "index", 802, 25569, 25733);
                CallChecker.varInit(this.parent, "parent", 802, 25569, 25733);
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 803, 25611, 25616)) {
                    if ((CallChecker.isCalled(parent, AbstractReferenceMap.class, 803, 25611, 25616).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2643.methodEnd();
            }
        }

        private boolean nextNull() {
            MethodContext _bcornu_methode_context2644 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 808, 25744, 25842);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 808, 25744, 25842);
                CallChecker.varInit(this.nextValue, "nextValue", 808, 25744, 25842);
                CallChecker.varInit(this.currentValue, "currentValue", 808, 25744, 25842);
                CallChecker.varInit(this.nextKey, "nextKey", 808, 25744, 25842);
                CallChecker.varInit(this.currentKey, "currentKey", 808, 25744, 25842);
                CallChecker.varInit(this.previous, "previous", 808, 25744, 25842);
                CallChecker.varInit(this.entry, "entry", 808, 25744, 25842);
                CallChecker.varInit(this.index, "index", 808, 25744, 25842);
                CallChecker.varInit(this.parent, "parent", 808, 25744, 25842);
                return ((nextKey) == null) || ((nextValue) == null);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2644.methodEnd();
            }
        }

        protected AbstractReferenceMap.ReferenceEntry<K, V> nextEntry() {
            MethodContext _bcornu_methode_context2645 = new MethodContext(AbstractReferenceMap.ReferenceEntry.class);
            try {
                CallChecker.varInit(this, "this", 812, 25853, 26263);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 812, 25853, 26263);
                CallChecker.varInit(this.nextValue, "nextValue", 812, 25853, 26263);
                CallChecker.varInit(this.currentValue, "currentValue", 812, 25853, 26263);
                CallChecker.varInit(this.nextKey, "nextKey", 812, 25853, 26263);
                CallChecker.varInit(this.currentKey, "currentKey", 812, 25853, 26263);
                CallChecker.varInit(this.previous, "previous", 812, 25853, 26263);
                CallChecker.varInit(this.entry, "entry", 812, 25853, 26263);
                CallChecker.varInit(this.index, "index", 812, 25853, 26263);
                CallChecker.varInit(this.parent, "parent", 812, 25853, 26263);
                checkMod();
                if ((nextNull()) && (!(hasNext()))) {
                    throw new NoSuchElementException();
                }
                previous = entry;
                CallChecker.varAssign(this.previous, "this.previous", 817, 26044, 26060);
                if (CallChecker.beforeDeref(entry, AbstractReferenceMap.ReferenceEntry.class, 818, 26082, 26086)) {
                    entry = CallChecker.beforeCalled(entry, AbstractReferenceMap.ReferenceEntry.class, 818, 26082, 26086);
                    entry = CallChecker.isCalled(entry, AbstractReferenceMap.ReferenceEntry.class, 818, 26082, 26086).next();
                    CallChecker.varAssign(this.entry, "this.entry", 818, 26074, 26094);
                }
                currentKey = nextKey;
                CallChecker.varAssign(this.currentKey, "this.currentKey", 819, 26108, 26128);
                currentValue = nextValue;
                CallChecker.varAssign(this.currentValue, "this.currentValue", 820, 26142, 26166);
                nextKey = null;
                CallChecker.varAssign(this.nextKey, "this.nextKey", 821, 26180, 26194);
                nextValue = null;
                CallChecker.varAssign(this.nextValue, "this.nextValue", 822, 26208, 26224);
                return previous;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractReferenceMap.ReferenceEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2645.methodEnd();
            }
        }

        protected AbstractReferenceMap.ReferenceEntry<K, V> currentEntry() {
            MethodContext _bcornu_methode_context2646 = new MethodContext(AbstractReferenceMap.ReferenceEntry.class);
            try {
                CallChecker.varInit(this, "this", 826, 26274, 26383);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 826, 26274, 26383);
                CallChecker.varInit(this.nextValue, "nextValue", 826, 26274, 26383);
                CallChecker.varInit(this.currentValue, "currentValue", 826, 26274, 26383);
                CallChecker.varInit(this.nextKey, "nextKey", 826, 26274, 26383);
                CallChecker.varInit(this.currentKey, "currentKey", 826, 26274, 26383);
                CallChecker.varInit(this.previous, "previous", 826, 26274, 26383);
                CallChecker.varInit(this.entry, "entry", 826, 26274, 26383);
                CallChecker.varInit(this.index, "index", 826, 26274, 26383);
                CallChecker.varInit(this.parent, "parent", 826, 26274, 26383);
                checkMod();
                return previous;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractReferenceMap.ReferenceEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2646.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context2647 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 831, 26394, 26730);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 831, 26394, 26730);
                CallChecker.varInit(this.nextValue, "nextValue", 831, 26394, 26730);
                CallChecker.varInit(this.currentValue, "currentValue", 831, 26394, 26730);
                CallChecker.varInit(this.nextKey, "nextKey", 831, 26394, 26730);
                CallChecker.varInit(this.currentKey, "currentKey", 831, 26394, 26730);
                CallChecker.varInit(this.previous, "previous", 831, 26394, 26730);
                CallChecker.varInit(this.entry, "entry", 831, 26394, 26730);
                CallChecker.varInit(this.index, "index", 831, 26394, 26730);
                CallChecker.varInit(this.parent, "parent", 831, 26394, 26730);
                checkMod();
                if ((previous) == null) {
                    throw new IllegalStateException();
                }
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 836, 26554, 26559)) {
                    parent.remove(currentKey);
                }
                previous = null;
                CallChecker.varAssign(this.previous, "this.previous", 837, 26593, 26608);
                currentKey = null;
                CallChecker.varAssign(this.currentKey, "this.currentKey", 838, 26622, 26639);
                currentValue = null;
                CallChecker.varAssign(this.currentValue, "this.currentValue", 839, 26653, 26672);
                if (CallChecker.beforeDeref(parent, AbstractReferenceMap.class, 840, 26705, 26710)) {
                    expectedModCount = CallChecker.isCalled(parent, AbstractReferenceMap.class, 840, 26705, 26710).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 840, 26686, 26720);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2647.methodEnd();
            }
        }
    }

    static class ReferenceEntrySetIterator<K, V> extends AbstractReferenceMap.ReferenceBaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        public ReferenceEntrySetIterator(AbstractReferenceMap<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context495 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context495.methodEnd();
            }
        }

        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context2648 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 853, 27034, 27106);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 853, 27034, 27106);
                CallChecker.varInit(this.nextValue, "nextValue", 853, 27034, 27106);
                CallChecker.varInit(this.currentValue, "currentValue", 853, 27034, 27106);
                CallChecker.varInit(this.nextKey, "nextKey", 853, 27034, 27106);
                CallChecker.varInit(this.currentKey, "currentKey", 853, 27034, 27106);
                CallChecker.varInit(this.previous, "previous", 853, 27034, 27106);
                CallChecker.varInit(this.entry, "entry", 853, 27034, 27106);
                CallChecker.varInit(this.index, "index", 853, 27034, 27106);
                CallChecker.varInit(this.parent, "parent", 853, 27034, 27106);
                return nextEntry();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2648.methodEnd();
            }
        }
    }

    static class ReferenceKeySetIterator<K> extends AbstractReferenceMap.ReferenceBaseIterator<K, Object> implements Iterator<K> {
        @SuppressWarnings(value = "unchecked")
        ReferenceKeySetIterator(AbstractReferenceMap<K, ?> parent) {
            super(((AbstractReferenceMap<K, Object>) (parent)));
            MethodContext _bcornu_methode_context496 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context496.methodEnd();
            }
        }

        public K next() {
            final AbstractReferenceMap.ReferenceEntry<K, Object> npe_invocation_var454 = nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var454, AbstractReferenceMap.ReferenceEntry.class, 870, 27496, 27506)) {
                return npe_invocation_var454.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    static class ReferenceValuesIterator<V> extends AbstractReferenceMap.ReferenceBaseIterator<Object, V> implements Iterator<V> {
        @SuppressWarnings(value = "unchecked")
        ReferenceValuesIterator(AbstractReferenceMap<?, V> parent) {
            super(((AbstractReferenceMap<Object, V>) (parent)));
            MethodContext _bcornu_methode_context497 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context497.methodEnd();
            }
        }

        public V next() {
            final AbstractReferenceMap.ReferenceEntry<Object, V> npe_invocation_var455 = nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var455, AbstractReferenceMap.ReferenceEntry.class, 885, 27915, 27925)) {
                return npe_invocation_var455.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    static class ReferenceMapIterator<K, V> extends AbstractReferenceMap.ReferenceBaseIterator<K, V> implements MapIterator<K, V> {
        protected ReferenceMapIterator(AbstractReferenceMap<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context498 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context498.methodEnd();
            }
        }

        public K next() {
            final AbstractReferenceMap.ReferenceEntry<K, V> npe_invocation_var456 = nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var456, AbstractReferenceMap.ReferenceEntry.class, 899, 28282, 28292)) {
                return npe_invocation_var456.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public K getKey() {
            AbstractHashedMap.HashEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 903, 28355, 28395);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            return current.getKey();
        }

        public V getValue() {
            AbstractHashedMap.HashEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 911, 28619, 28659);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            return current.getValue();
        }

        public V setValue(V value) {
            AbstractHashedMap.HashEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 919, 28894, 28934);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            return current.setValue(value);
        }
    }

    static class SoftRef<T> extends SoftReference<T> {
        private final int hash;

        public SoftRef(int hash, T r, ReferenceQueue<? super T> q) {
            super(r, q);
            MethodContext _bcornu_methode_context499 = new MethodContext(null);
            try {
                this.hash = hash;
                CallChecker.varAssign(this.hash, "this.hash", 941, 29705, 29721);
            } finally {
                _bcornu_methode_context499.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2655 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 945, 29742, 29817);
                CallChecker.varInit(this.hash, "hash", 945, 29742, 29817);
                return hash;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2655.methodEnd();
            }
        }
    }

    static class WeakRef<T> extends WeakReference<T> {
        private final int hash;

        public WeakRef(int hash, T r, ReferenceQueue<? super T> q) {
            super(r, q);
            MethodContext _bcornu_methode_context500 = new MethodContext(null);
            try {
                this.hash = hash;
                CallChecker.varAssign(this.hash, "this.hash", 959, 30149, 30165);
            } finally {
                _bcornu_methode_context500.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2656 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 963, 30186, 30261);
                CallChecker.varInit(this.hash, "hash", 963, 30186, 30261);
                return hash;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2656.methodEnd();
            }
        }
    }

    @Override
    protected void doWriteObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2657 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 988, 30274, 31820);
            CallChecker.varInit(out, "out", 988, 30274, 31820);
            CallChecker.varInit(this.values, "values", 988, 30274, 31820);
            CallChecker.varInit(this.keySet, "keySet", 988, 30274, 31820);
            CallChecker.varInit(this.entrySet, "entrySet", 988, 30274, 31820);
            CallChecker.varInit(this.modCount, "modCount", 988, 30274, 31820);
            CallChecker.varInit(this.threshold, "threshold", 988, 30274, 31820);
            CallChecker.varInit(this.data, "data", 988, 30274, 31820);
            CallChecker.varInit(this.size, "size", 988, 30274, 31820);
            CallChecker.varInit(this.loadFactor, "loadFactor", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 988, 30274, 31820);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 988, 30274, 31820);
            CallChecker.varInit(this.queue, "queue", 988, 30274, 31820);
            CallChecker.varInit(this.purgeValues, "purgeValues", 988, 30274, 31820);
            CallChecker.varInit(this.valueType, "valueType", 988, 30274, 31820);
            CallChecker.varInit(this.keyType, "keyType", 988, 30274, 31820);
            if (CallChecker.beforeDeref(keyType, AbstractReferenceMap.ReferenceStrength.class, 989, 31345, 31351)) {
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 989, 31332, 31334)) {
                    keyType = CallChecker.beforeCalled(keyType, AbstractReferenceMap.ReferenceStrength.class, 989, 31345, 31351);
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 989, 31332, 31334);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 989, 31332, 31334).writeInt(CallChecker.isCalled(keyType, AbstractReferenceMap.ReferenceStrength.class, 989, 31345, 31351).value);
                }
            }
            if (CallChecker.beforeDeref(valueType, AbstractReferenceMap.ReferenceStrength.class, 990, 31382, 31390)) {
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 990, 31369, 31371)) {
                    valueType = CallChecker.beforeCalled(valueType, AbstractReferenceMap.ReferenceStrength.class, 990, 31382, 31390);
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 990, 31369, 31371);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 990, 31369, 31371).writeInt(CallChecker.isCalled(valueType, AbstractReferenceMap.ReferenceStrength.class, 990, 31382, 31390).value);
                }
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 991, 31408, 31410)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 991, 31408, 31410);
                CallChecker.isCalled(out, ObjectOutputStream.class, 991, 31408, 31410).writeBoolean(purgeValues);
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 992, 31447, 31449)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 992, 31447, 31449);
                CallChecker.isCalled(out, ObjectOutputStream.class, 992, 31447, 31449).writeFloat(loadFactor);
            }
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 993, 31496, 31499)) {
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 993, 31483, 31485)) {
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 993, 31496, 31499);
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 993, 31483, 31485);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 993, 31483, 31485).writeInt(CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 993, 31496, 31499).length);
                }
            }
            for (MapIterator<K, V> it = mapIterator(); CallChecker.isCalled(it, MapIterator.class, 994, 31561, 31562).hasNext();) {
                if (CallChecker.beforeDeref(it, MapIterator.class, 995, 31606, 31607)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 995, 31590, 31592)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 995, 31590, 31592);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 995, 31590, 31592).writeObject(it.next());
                    }
                }
                if (CallChecker.beforeDeref(it, MapIterator.class, 996, 31646, 31647)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 996, 31630, 31632)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 996, 31630, 31632);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 996, 31630, 31632).writeObject(it.getValue());
                    }
                }
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 998, 31680, 31682)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 998, 31680, 31682);
                CallChecker.isCalled(out, ObjectOutputStream.class, 998, 31680, 31682).writeObject(null);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2657.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    protected void doReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2658 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1021, 31827, 33500);
            CallChecker.varInit(in, "in", 1021, 31827, 33500);
            CallChecker.varInit(this.values, "values", 1021, 31827, 33500);
            CallChecker.varInit(this.keySet, "keySet", 1021, 31827, 33500);
            CallChecker.varInit(this.entrySet, "entrySet", 1021, 31827, 33500);
            CallChecker.varInit(this.modCount, "modCount", 1021, 31827, 33500);
            CallChecker.varInit(this.threshold, "threshold", 1021, 31827, 33500);
            CallChecker.varInit(this.data, "data", 1021, 31827, 33500);
            CallChecker.varInit(this.size, "size", 1021, 31827, 33500);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1021, 31827, 33500);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1021, 31827, 33500);
            CallChecker.varInit(this.queue, "queue", 1021, 31827, 33500);
            CallChecker.varInit(this.purgeValues, "purgeValues", 1021, 31827, 33500);
            CallChecker.varInit(this.valueType, "valueType", 1021, 31827, 33500);
            CallChecker.varInit(this.keyType, "keyType", 1021, 31827, 33500);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1022, 32867, 32868)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1022, 32867, 32868);
                this.keyType = AbstractReferenceMap.ReferenceStrength.resolve(CallChecker.isCalled(in, ObjectInputStream.class, 1022, 32867, 32868).readInt());
                CallChecker.varAssign(this.keyType, "this.keyType", 1022, 32826, 32880);
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1023, 32933, 32934)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1023, 32933, 32934);
                this.valueType = AbstractReferenceMap.ReferenceStrength.resolve(CallChecker.isCalled(in, ObjectInputStream.class, 1023, 32933, 32934).readInt());
                CallChecker.varAssign(this.valueType, "this.valueType", 1023, 32890, 32946);
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1024, 32975, 32976)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1024, 32975, 32976);
                this.purgeValues = CallChecker.isCalled(in, ObjectInputStream.class, 1024, 32975, 32976).readBoolean();
                CallChecker.varAssign(this.purgeValues, "this.purgeValues", 1024, 32956, 32991);
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1025, 33019, 33020)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1025, 33019, 33020);
                this.loadFactor = CallChecker.isCalled(in, ObjectInputStream.class, 1025, 33019, 33020).readFloat();
                CallChecker.varAssign(this.loadFactor, "this.loadFactor", 1025, 33001, 33033);
            }
            int capacity = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1026, 33058, 33059)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1026, 33058, 33059);
                capacity = CallChecker.isCalled(in, ObjectInputStream.class, 1026, 33058, 33059).readInt();
                CallChecker.varAssign(capacity, "capacity", 1026, 33058, 33059);
            }
            init();
            data = new AbstractHashedMap.HashEntry[capacity];
            CallChecker.varAssign(this.data, "this.data", 1028, 33096, 33126);
            while (true) {
                K key = CallChecker.init(null);
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1030, 33175, 33176)) {
                    in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1030, 33175, 33176);
                    key = ((K) (CallChecker.isCalled(in, ObjectInputStream.class, 1030, 33175, 33176).readObject()));
                    CallChecker.varAssign(key, "key", 1030, 33175, 33176);
                }
                if (key == null) {
                    break;
                }
                V value = CallChecker.init(null);
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1034, 33286, 33287)) {
                    in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1034, 33286, 33287);
                    value = ((V) (CallChecker.isCalled(in, ObjectInputStream.class, 1034, 33286, 33287).readObject()));
                    CallChecker.varAssign(value, "value", 1034, 33286, 33287);
                }
                put(key, value);
            } 
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 1037, 33381, 33384)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 1037, 33381, 33384);
                threshold = calculateThreshold(CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 1037, 33381, 33384).length, loadFactor);
                CallChecker.varAssign(this.threshold, "this.threshold", 1037, 33350, 33405);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2658.methodEnd();
        }
    }
}

