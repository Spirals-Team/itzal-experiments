package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MapIterator;
import java.util.ConcurrentModificationException;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.AbstractSet;
import java.util.AbstractMap;
import java.util.AbstractCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.EmptyMapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import org.apache.commons.collections.IterableMap;
import java.util.Iterator;
import org.apache.commons.collections.KeyValue;
import java.util.Map;

public class AbstractHashedMap<K, V> extends AbstractMap<K, V> implements IterableMap<K, V> {
    protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";

    protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";

    protected static final String REMOVE_INVALID = "remove() can only be called once after next()";

    protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";

    protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";

    protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";

    protected static final int DEFAULT_CAPACITY = 16;

    protected static final int DEFAULT_THRESHOLD = 12;

    protected static final float DEFAULT_LOAD_FACTOR = 0.75F;

    protected static final int MAXIMUM_CAPACITY = 1 << 30;

    protected static final Object NULL = new Object();

    protected transient float loadFactor;

    protected transient int size;

    protected transient AbstractHashedMap.HashEntry<K, V>[] data;

    protected transient int threshold;

    protected transient int modCount;

    protected transient AbstractHashedMap.EntrySet<K, V> entrySet;

    protected transient AbstractHashedMap.KeySet<K> keySet;

    protected transient AbstractHashedMap.Values<V> values;

    protected AbstractHashedMap() {
        super();
        MethodContext _bcornu_methode_context59 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected AbstractHashedMap(int initialCapacity, float loadFactor, int threshold) {
        super();
        MethodContext _bcornu_methode_context60 = new MethodContext(null);
        try {
            this.loadFactor = loadFactor;
            CallChecker.varAssign(this.loadFactor, "this.loadFactor", 116, 4995, 5023);
            this.data = new AbstractHashedMap.HashEntry[initialCapacity];
            CallChecker.varAssign(this.data, "this.data", 117, 5033, 5075);
            this.threshold = threshold;
            CallChecker.varAssign(this.threshold, "this.threshold", 118, 5085, 5111);
            init();
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    protected AbstractHashedMap(int initialCapacity) {
        this(initialCapacity, AbstractHashedMap.DEFAULT_LOAD_FACTOR);
        MethodContext _bcornu_methode_context61 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected AbstractHashedMap(int initialCapacity, float loadFactor) {
        super();
        MethodContext _bcornu_methode_context62 = new MethodContext(null);
        try {
            if (initialCapacity < 1) {
                throw new IllegalArgumentException("Initial capacity must be greater than 0");
            }
            if ((loadFactor <= 0.0F) || (Float.isNaN(loadFactor))) {
                throw new IllegalArgumentException("Load factor must be greater than 0");
            }
            this.loadFactor = loadFactor;
            CallChecker.varAssign(this.loadFactor, "this.loadFactor", 151, 6317, 6345);
            initialCapacity = calculateNewCapacity(initialCapacity);
            CallChecker.varAssign(initialCapacity, "initialCapacity", 152, 6355, 6410);
            this.threshold = calculateThreshold(initialCapacity, loadFactor);
            CallChecker.varAssign(this.threshold, "this.threshold", 153, 6420, 6484);
            this.data = new AbstractHashedMap.HashEntry[initialCapacity];
            CallChecker.varAssign(this.data, "this.data", 154, 6494, 6536);
            init();
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    protected AbstractHashedMap(Map<K, V> map) {
        this(Math.max((2 * (CallChecker.isCalled(map, Map.class, 165, 6803, 6805).size())), AbstractHashedMap.DEFAULT_CAPACITY), AbstractHashedMap.DEFAULT_LOAD_FACTOR);
        MethodContext _bcornu_methode_context63 = new MethodContext(null);
        try {
            _putAll(map);
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }

    protected void init() {
        MethodContext _bcornu_methode_context375 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 172, 6889, 7011);
            CallChecker.varInit(this.values, "values", 172, 6889, 7011);
            CallChecker.varInit(this.keySet, "keySet", 172, 6889, 7011);
            CallChecker.varInit(this.entrySet, "entrySet", 172, 6889, 7011);
            CallChecker.varInit(this.modCount, "modCount", 172, 6889, 7011);
            CallChecker.varInit(this.threshold, "threshold", 172, 6889, 7011);
            CallChecker.varInit(this.data, "data", 172, 6889, 7011);
            CallChecker.varInit(this.size, "size", 172, 6889, 7011);
            CallChecker.varInit(this.loadFactor, "loadFactor", 172, 6889, 7011);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 172, 6889, 7011);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 172, 6889, 7011);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 172, 6889, 7011);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 172, 6889, 7011);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 172, 6889, 7011);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 172, 6889, 7011);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 172, 6889, 7011);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 172, 6889, 7011);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 172, 6889, 7011);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 172, 6889, 7011);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 172, 6889, 7011);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context375.methodEnd();
        }
    }

    @Override
    public V get(Object key) {
        key = convertKey(key);
        CallChecker.varAssign(key, "key", 184, 7296, 7317);
        int hashCode = CallChecker.varInit(((int) (hash(key))), "hashCode", 185, 7327, 7351);
        AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 186, 7410, 7413)) {
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 186, 7385, 7388)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 186, 7410, 7413);
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 186, 7385, 7388);
                entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 186, 7385, 7388)[hashIndex(hashCode, CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 186, 7410, 7413).length)];
                CallChecker.varAssign(entry, "entry", 186, 7410, 7413);
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(key, entry.key))) {
                return entry.getValue();
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 191, 7627, 7645);
        } 
        return null;
    }

    @Override
    public int size() {
        MethodContext _bcornu_methode_context377 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 202, 7689, 7828);
            CallChecker.varInit(this.values, "values", 202, 7689, 7828);
            CallChecker.varInit(this.keySet, "keySet", 202, 7689, 7828);
            CallChecker.varInit(this.entrySet, "entrySet", 202, 7689, 7828);
            CallChecker.varInit(this.modCount, "modCount", 202, 7689, 7828);
            CallChecker.varInit(this.threshold, "threshold", 202, 7689, 7828);
            CallChecker.varInit(this.data, "data", 202, 7689, 7828);
            CallChecker.varInit(this.size, "size", 202, 7689, 7828);
            CallChecker.varInit(this.loadFactor, "loadFactor", 202, 7689, 7828);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 202, 7689, 7828);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 202, 7689, 7828);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 202, 7689, 7828);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 202, 7689, 7828);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 202, 7689, 7828);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 202, 7689, 7828);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 202, 7689, 7828);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 202, 7689, 7828);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 202, 7689, 7828);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 202, 7689, 7828);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 202, 7689, 7828);
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context377.methodEnd();
        }
    }

    @Override
    public boolean isEmpty() {
        MethodContext _bcornu_methode_context378 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 212, 7835, 8035);
            CallChecker.varInit(this.values, "values", 212, 7835, 8035);
            CallChecker.varInit(this.keySet, "keySet", 212, 7835, 8035);
            CallChecker.varInit(this.entrySet, "entrySet", 212, 7835, 8035);
            CallChecker.varInit(this.modCount, "modCount", 212, 7835, 8035);
            CallChecker.varInit(this.threshold, "threshold", 212, 7835, 8035);
            CallChecker.varInit(this.data, "data", 212, 7835, 8035);
            CallChecker.varInit(this.size, "size", 212, 7835, 8035);
            CallChecker.varInit(this.loadFactor, "loadFactor", 212, 7835, 8035);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 212, 7835, 8035);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 212, 7835, 8035);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 212, 7835, 8035);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 212, 7835, 8035);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 212, 7835, 8035);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 212, 7835, 8035);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 212, 7835, 8035);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 212, 7835, 8035);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 212, 7835, 8035);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 212, 7835, 8035);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 212, 7835, 8035);
            return (size) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context378.methodEnd();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context379 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 224, 8042, 8728);
            CallChecker.varInit(key, "key", 224, 8042, 8728);
            CallChecker.varInit(this.values, "values", 224, 8042, 8728);
            CallChecker.varInit(this.keySet, "keySet", 224, 8042, 8728);
            CallChecker.varInit(this.entrySet, "entrySet", 224, 8042, 8728);
            CallChecker.varInit(this.modCount, "modCount", 224, 8042, 8728);
            CallChecker.varInit(this.threshold, "threshold", 224, 8042, 8728);
            CallChecker.varInit(this.data, "data", 224, 8042, 8728);
            CallChecker.varInit(this.size, "size", 224, 8042, 8728);
            CallChecker.varInit(this.loadFactor, "loadFactor", 224, 8042, 8728);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 224, 8042, 8728);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 224, 8042, 8728);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 224, 8042, 8728);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 224, 8042, 8728);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 224, 8042, 8728);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 224, 8042, 8728);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 224, 8042, 8728);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 224, 8042, 8728);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 224, 8042, 8728);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 224, 8042, 8728);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 224, 8042, 8728);
            key = convertKey(key);
            CallChecker.varAssign(key, "key", 225, 8353, 8374);
            int hashCode = CallChecker.varInit(((int) (hash(key))), "hashCode", 226, 8384, 8408);
            AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 227, 8467, 8470)) {
                if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 227, 8442, 8445)) {
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 227, 8467, 8470);
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 227, 8442, 8445);
                    entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 227, 8442, 8445)[hashIndex(hashCode, CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 227, 8467, 8470).length)];
                    CallChecker.varAssign(entry, "entry", 227, 8467, 8470);
                }
            }
            while (entry != null) {
                if (((entry.hashCode) == hashCode) && (isEqualKey(key, entry.key))) {
                    return true;
                }
                entry = entry.next;
                CallChecker.varAssign(entry, "entry", 232, 8672, 8690);
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context379.methodEnd();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context380 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 244, 8735, 9745);
            CallChecker.varInit(value, "value", 244, 8735, 9745);
            CallChecker.varInit(this.values, "values", 244, 8735, 9745);
            CallChecker.varInit(this.keySet, "keySet", 244, 8735, 9745);
            CallChecker.varInit(this.entrySet, "entrySet", 244, 8735, 9745);
            CallChecker.varInit(this.modCount, "modCount", 244, 8735, 9745);
            CallChecker.varInit(this.threshold, "threshold", 244, 8735, 9745);
            CallChecker.varInit(this.data, "data", 244, 8735, 9745);
            CallChecker.varInit(this.size, "size", 244, 8735, 9745);
            CallChecker.varInit(this.loadFactor, "loadFactor", 244, 8735, 9745);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 244, 8735, 9745);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 244, 8735, 9745);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 244, 8735, 9745);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 244, 8735, 9745);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 244, 8735, 9745);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 244, 8735, 9745);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 244, 8735, 9745);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 244, 8735, 9745);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 244, 8735, 9745);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 244, 8735, 9745);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 244, 8735, 9745);
            if (value == null) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 246, 9037, 9040);
                for (int i = 0, isize = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 246, 9037, 9040).length; i < isize; i++) {
                    AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
                    if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 247, 9108, 9111)) {
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 247, 9108, 9111);
                        entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 247, 9108, 9111)[i];
                        CallChecker.varAssign(entry, "entry", 247, 9108, 9111);
                    }
                    while (entry != null) {
                        if ((entry.getValue()) == null) {
                            return true;
                        }
                        entry = entry.next;
                        CallChecker.varAssign(entry, "entry", 252, 9288, 9306);
                    } 
                }
            }else {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 256, 9393, 9396);
                for (int i = 0, isize = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 256, 9393, 9396).length; i < isize; i++) {
                    AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
                    if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 257, 9464, 9467)) {
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 257, 9464, 9467);
                        entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 257, 9464, 9467)[i];
                        CallChecker.varAssign(entry, "entry", 257, 9464, 9467);
                    }
                    while (entry != null) {
                        if (isEqualValue(value, entry.getValue())) {
                            return true;
                        }
                        entry = entry.next;
                        CallChecker.varAssign(entry, "entry", 262, 9657, 9675);
                    } 
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context380.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        Object convertedKey = CallChecker.varInit(convertKey(key), "convertedKey", 279, 10094, 10131);
        int hashCode = CallChecker.varInit(((int) (hash(convertedKey))), "hashCode", 280, 10141, 10174);
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 281, 10216, 10219)) {
            data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 281, 10216, 10219);
            index = hashIndex(hashCode, CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 281, 10216, 10219).length);
            CallChecker.varAssign(index, "index", 281, 10216, 10219);
        }
        AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 282, 10262, 10265)) {
            data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 282, 10262, 10265);
            entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 282, 10262, 10265)[index];
            CallChecker.varAssign(entry, "entry", 282, 10262, 10265);
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(convertedKey, entry.key))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 285, 10408, 10437);
                updateEntry(entry, value);
                return oldValue;
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 289, 10541, 10559);
        } 
        addMapping(index, hashCode, key, value);
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context382 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 306, 10653, 11044);
            CallChecker.varInit(map, "map", 306, 10653, 11044);
            CallChecker.varInit(this.values, "values", 306, 10653, 11044);
            CallChecker.varInit(this.keySet, "keySet", 306, 10653, 11044);
            CallChecker.varInit(this.entrySet, "entrySet", 306, 10653, 11044);
            CallChecker.varInit(this.modCount, "modCount", 306, 10653, 11044);
            CallChecker.varInit(this.threshold, "threshold", 306, 10653, 11044);
            CallChecker.varInit(this.data, "data", 306, 10653, 11044);
            CallChecker.varInit(this.size, "size", 306, 10653, 11044);
            CallChecker.varInit(this.loadFactor, "loadFactor", 306, 10653, 11044);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 306, 10653, 11044);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 306, 10653, 11044);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 306, 10653, 11044);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 306, 10653, 11044);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 306, 10653, 11044);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 306, 10653, 11044);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 306, 10653, 11044);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 306, 10653, 11044);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 306, 10653, 11044);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 306, 10653, 11044);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 306, 10653, 11044);
            _putAll(map);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context382.methodEnd();
        }
    }

    private void _putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context383 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 322, 11051, 11870);
            CallChecker.varInit(map, "map", 322, 11051, 11870);
            CallChecker.varInit(this.values, "values", 322, 11051, 11870);
            CallChecker.varInit(this.keySet, "keySet", 322, 11051, 11870);
            CallChecker.varInit(this.entrySet, "entrySet", 322, 11051, 11870);
            CallChecker.varInit(this.modCount, "modCount", 322, 11051, 11870);
            CallChecker.varInit(this.threshold, "threshold", 322, 11051, 11870);
            CallChecker.varInit(this.data, "data", 322, 11051, 11870);
            CallChecker.varInit(this.size, "size", 322, 11051, 11870);
            CallChecker.varInit(this.loadFactor, "loadFactor", 322, 11051, 11870);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 322, 11051, 11870);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 322, 11051, 11870);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 322, 11051, 11870);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 322, 11051, 11870);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 322, 11051, 11870);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 322, 11051, 11870);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 322, 11051, 11870);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 322, 11051, 11870);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 322, 11051, 11870);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 322, 11051, 11870);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 322, 11051, 11870);
            int mapSize = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(map, Map.class, 323, 11541, 11543)) {
                map = CallChecker.beforeCalled(map, Map.class, 323, 11541, 11543);
                mapSize = CallChecker.isCalled(map, Map.class, 323, 11541, 11543).size();
                CallChecker.varAssign(mapSize, "mapSize", 323, 11541, 11543);
            }
            if (mapSize == 0) {
                return ;
            }
            int newSize = CallChecker.varInit(((int) ((int) ((((this.size) + mapSize) / (this.loadFactor)) + 1))), "newSize", 327, 11619, 11674);
            ensureCapacity(calculateNewCapacity(newSize));
            map = CallChecker.beforeCalled(map, Map.class, 329, 11787, 11789);
            for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(map, Map.class, 329, 11787, 11789).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 330, 11821, 11825)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 330, 11837, 11841)) {
                        put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context383.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        key = convertKey(key);
        CallChecker.varAssign(key, "key", 342, 12120, 12141);
        int hashCode = CallChecker.varInit(((int) (hash(key))), "hashCode", 343, 12151, 12175);
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 344, 12217, 12220)) {
            data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 344, 12217, 12220);
            index = hashIndex(hashCode, CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 344, 12217, 12220).length);
            CallChecker.varAssign(index, "index", 344, 12217, 12220);
        }
        AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 345, 12263, 12266)) {
            data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 345, 12263, 12266);
            entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 345, 12263, 12266)[index];
            CallChecker.varAssign(entry, "entry", 345, 12263, 12266);
        }
        AbstractHashedMap.HashEntry<K, V> previous = CallChecker.varInit(null, "previous", 346, 12284, 12315);
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(key, entry.key))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 349, 12441, 12470);
                removeMapping(entry, index, previous);
                return oldValue;
            }
            previous = entry;
            CallChecker.varAssign(previous, "previous", 353, 12586, 12602);
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 354, 12616, 12634);
        } 
        return null;
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context385 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 364, 12678, 13026);
            CallChecker.varInit(this.values, "values", 364, 12678, 13026);
            CallChecker.varInit(this.keySet, "keySet", 364, 12678, 13026);
            CallChecker.varInit(this.entrySet, "entrySet", 364, 12678, 13026);
            CallChecker.varInit(this.modCount, "modCount", 364, 12678, 13026);
            CallChecker.varInit(this.threshold, "threshold", 364, 12678, 13026);
            CallChecker.varInit(this.data, "data", 364, 12678, 13026);
            CallChecker.varInit(this.size, "size", 364, 12678, 13026);
            CallChecker.varInit(this.loadFactor, "loadFactor", 364, 12678, 13026);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 364, 12678, 13026);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 364, 12678, 13026);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 364, 12678, 13026);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 364, 12678, 13026);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 364, 12678, 13026);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 364, 12678, 13026);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 364, 12678, 13026);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 364, 12678, 13026);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 364, 12678, 13026);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 364, 12678, 13026);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 364, 12678, 13026);
            (modCount)++;
            AbstractHashedMap.HashEntry<K, V>[] data = CallChecker.varInit(this.data, "data", 366, 12877, 12911);
            data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 367, 12934, 12937);
            for (int i = (CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 367, 12934, 12937).length) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 368, 12978, 12981)) {
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 368, 12978, 12981);
                    CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 368, 12978, 12981)[i] = null;
                    CallChecker.varAssign(CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 368, 12978, 12981)[i], "CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 368, 12978, 12981)[i]", 368, 12978, 12992);
                }
            }
            size = 0;
            CallChecker.varAssign(this.size, "this.size", 370, 13012, 13020);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context385.methodEnd();
        }
    }

    protected Object convertKey(Object key) {
        MethodContext _bcornu_methode_context386 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 385, 13033, 13604);
            CallChecker.varInit(key, "key", 385, 13033, 13604);
            CallChecker.varInit(this.values, "values", 385, 13033, 13604);
            CallChecker.varInit(this.keySet, "keySet", 385, 13033, 13604);
            CallChecker.varInit(this.entrySet, "entrySet", 385, 13033, 13604);
            CallChecker.varInit(this.modCount, "modCount", 385, 13033, 13604);
            CallChecker.varInit(this.threshold, "threshold", 385, 13033, 13604);
            CallChecker.varInit(this.data, "data", 385, 13033, 13604);
            CallChecker.varInit(this.size, "size", 385, 13033, 13604);
            CallChecker.varInit(this.loadFactor, "loadFactor", 385, 13033, 13604);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 385, 13033, 13604);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 385, 13033, 13604);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 385, 13033, 13604);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 385, 13033, 13604);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 385, 13033, 13604);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 385, 13033, 13604);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 385, 13033, 13604);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 385, 13033, 13604);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 385, 13033, 13604);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 385, 13033, 13604);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 385, 13033, 13604);
            if (key == null) {
                return AbstractHashedMap.NULL;
            }else {
                return key;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context386.methodEnd();
        }
    }

    protected int hash(Object key) {
        MethodContext _bcornu_methode_context387 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 397, 13611, 14120);
            CallChecker.varInit(key, "key", 397, 13611, 14120);
            CallChecker.varInit(this.values, "values", 397, 13611, 14120);
            CallChecker.varInit(this.keySet, "keySet", 397, 13611, 14120);
            CallChecker.varInit(this.entrySet, "entrySet", 397, 13611, 14120);
            CallChecker.varInit(this.modCount, "modCount", 397, 13611, 14120);
            CallChecker.varInit(this.threshold, "threshold", 397, 13611, 14120);
            CallChecker.varInit(this.data, "data", 397, 13611, 14120);
            CallChecker.varInit(this.size, "size", 397, 13611, 14120);
            CallChecker.varInit(this.loadFactor, "loadFactor", 397, 13611, 14120);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 397, 13611, 14120);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 397, 13611, 14120);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 397, 13611, 14120);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 397, 13611, 14120);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 397, 13611, 14120);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 397, 13611, 14120);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 397, 13611, 14120);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 397, 13611, 14120);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 397, 13611, 14120);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 397, 13611, 14120);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 397, 13611, 14120);
            int h = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(key, Object.class, 399, 13982, 13984)) {
                key = CallChecker.beforeCalled(key, Object.class, 399, 13982, 13984);
                h = CallChecker.isCalled(key, Object.class, 399, 13982, 13984).hashCode();
                CallChecker.varAssign(h, "h", 399, 13982, 13984);
            }
            h += ~(h << 9);
            CallChecker.varAssign(h, "h", 400, 14006, 14020);
            h ^= h >>> 14;
            CallChecker.varAssign(h, "h", 401, 14030, 14046);
            h += h << 4;
            CallChecker.varAssign(h, "h", 402, 14056, 14070);
            h ^= h >>> 10;
            CallChecker.varAssign(h, "h", 403, 14080, 14096);
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context387.methodEnd();
        }
    }

    protected boolean isEqualKey(Object key1, Object key2) {
        MethodContext _bcornu_methode_context388 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 416, 14127, 14668);
            CallChecker.varInit(key2, "key2", 416, 14127, 14668);
            CallChecker.varInit(key1, "key1", 416, 14127, 14668);
            CallChecker.varInit(this.values, "values", 416, 14127, 14668);
            CallChecker.varInit(this.keySet, "keySet", 416, 14127, 14668);
            CallChecker.varInit(this.entrySet, "entrySet", 416, 14127, 14668);
            CallChecker.varInit(this.modCount, "modCount", 416, 14127, 14668);
            CallChecker.varInit(this.threshold, "threshold", 416, 14127, 14668);
            CallChecker.varInit(this.data, "data", 416, 14127, 14668);
            CallChecker.varInit(this.size, "size", 416, 14127, 14668);
            CallChecker.varInit(this.loadFactor, "loadFactor", 416, 14127, 14668);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 416, 14127, 14668);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 416, 14127, 14668);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 416, 14127, 14668);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 416, 14127, 14668);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 416, 14127, 14668);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 416, 14127, 14668);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 416, 14127, 14668);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 416, 14127, 14668);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 416, 14127, 14668);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 416, 14127, 14668);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 416, 14127, 14668);
            key1 = CallChecker.beforeCalled(key1, Object.class, 417, 14644, 14647);
            return (key1 == key2) || (CallChecker.isCalled(key1, Object.class, 417, 14644, 14647).equals(key2));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context388.methodEnd();
        }
    }

    protected boolean isEqualValue(Object value1, Object value2) {
        MethodContext _bcornu_methode_context389 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 429, 14675, 15233);
            CallChecker.varInit(value2, "value2", 429, 14675, 15233);
            CallChecker.varInit(value1, "value1", 429, 14675, 15233);
            CallChecker.varInit(this.values, "values", 429, 14675, 15233);
            CallChecker.varInit(this.keySet, "keySet", 429, 14675, 15233);
            CallChecker.varInit(this.entrySet, "entrySet", 429, 14675, 15233);
            CallChecker.varInit(this.modCount, "modCount", 429, 14675, 15233);
            CallChecker.varInit(this.threshold, "threshold", 429, 14675, 15233);
            CallChecker.varInit(this.data, "data", 429, 14675, 15233);
            CallChecker.varInit(this.size, "size", 429, 14675, 15233);
            CallChecker.varInit(this.loadFactor, "loadFactor", 429, 14675, 15233);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 429, 14675, 15233);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 429, 14675, 15233);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 429, 14675, 15233);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 429, 14675, 15233);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 429, 14675, 15233);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 429, 14675, 15233);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 429, 14675, 15233);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 429, 14675, 15233);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 429, 14675, 15233);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 429, 14675, 15233);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 429, 14675, 15233);
            value1 = CallChecker.beforeCalled(value1, Object.class, 430, 15205, 15210);
            return (value1 == value2) || (CallChecker.isCalled(value1, Object.class, 430, 15205, 15210).equals(value2));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context389.methodEnd();
        }
    }

    protected int hashIndex(int hashCode, int dataSize) {
        MethodContext _bcornu_methode_context390 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 442, 15240, 15722);
            CallChecker.varInit(dataSize, "dataSize", 442, 15240, 15722);
            CallChecker.varInit(hashCode, "hashCode", 442, 15240, 15722);
            CallChecker.varInit(this.values, "values", 442, 15240, 15722);
            CallChecker.varInit(this.keySet, "keySet", 442, 15240, 15722);
            CallChecker.varInit(this.entrySet, "entrySet", 442, 15240, 15722);
            CallChecker.varInit(this.modCount, "modCount", 442, 15240, 15722);
            CallChecker.varInit(this.threshold, "threshold", 442, 15240, 15722);
            CallChecker.varInit(this.data, "data", 442, 15240, 15722);
            CallChecker.varInit(this.size, "size", 442, 15240, 15722);
            CallChecker.varInit(this.loadFactor, "loadFactor", 442, 15240, 15722);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 442, 15240, 15722);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 442, 15240, 15722);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 442, 15240, 15722);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 442, 15240, 15722);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 442, 15240, 15722);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 442, 15240, 15722);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 442, 15240, 15722);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 442, 15240, 15722);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 442, 15240, 15722);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 442, 15240, 15722);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 442, 15240, 15722);
            return hashCode & (dataSize - 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context390.methodEnd();
        }
    }

    protected AbstractHashedMap.HashEntry<K, V> getEntry(Object key) {
        MethodContext _bcornu_methode_context391 = new MethodContext(AbstractHashedMap.HashEntry.class);
        try {
            CallChecker.varInit(this, "this", 457, 15729, 16606);
            CallChecker.varInit(key, "key", 457, 15729, 16606);
            CallChecker.varInit(this.values, "values", 457, 15729, 16606);
            CallChecker.varInit(this.keySet, "keySet", 457, 15729, 16606);
            CallChecker.varInit(this.entrySet, "entrySet", 457, 15729, 16606);
            CallChecker.varInit(this.modCount, "modCount", 457, 15729, 16606);
            CallChecker.varInit(this.threshold, "threshold", 457, 15729, 16606);
            CallChecker.varInit(this.data, "data", 457, 15729, 16606);
            CallChecker.varInit(this.size, "size", 457, 15729, 16606);
            CallChecker.varInit(this.loadFactor, "loadFactor", 457, 15729, 16606);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 457, 15729, 16606);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 457, 15729, 16606);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 457, 15729, 16606);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 457, 15729, 16606);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 457, 15729, 16606);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 457, 15729, 16606);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 457, 15729, 16606);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 457, 15729, 16606);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 457, 15729, 16606);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 457, 15729, 16606);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 457, 15729, 16606);
            key = convertKey(key);
            CallChecker.varAssign(key, "key", 458, 16231, 16252);
            int hashCode = CallChecker.varInit(((int) (hash(key))), "hashCode", 459, 16262, 16286);
            AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 460, 16345, 16348)) {
                if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 460, 16320, 16323)) {
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 460, 16345, 16348);
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 460, 16320, 16323);
                    entry = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 460, 16320, 16323)[hashIndex(hashCode, CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 460, 16345, 16348).length)];
                    CallChecker.varAssign(entry, "entry", 460, 16345, 16348);
                }
            }
            while (entry != null) {
                if (((entry.hashCode) == hashCode) && (isEqualKey(key, entry.key))) {
                    return entry;
                }
                entry = entry.next;
                CallChecker.varAssign(entry, "entry", 465, 16551, 16569);
            } 
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractHashedMap.HashEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context391.methodEnd();
        }
    }

    protected void updateEntry(AbstractHashedMap.HashEntry<K, V> entry, V newValue) {
        MethodContext _bcornu_methode_context392 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 480, 16613, 17115);
            CallChecker.varInit(newValue, "newValue", 480, 16613, 17115);
            CallChecker.varInit(entry, "entry", 480, 16613, 17115);
            CallChecker.varInit(this.values, "values", 480, 16613, 17115);
            CallChecker.varInit(this.keySet, "keySet", 480, 16613, 17115);
            CallChecker.varInit(this.entrySet, "entrySet", 480, 16613, 17115);
            CallChecker.varInit(this.modCount, "modCount", 480, 16613, 17115);
            CallChecker.varInit(this.threshold, "threshold", 480, 16613, 17115);
            CallChecker.varInit(this.data, "data", 480, 16613, 17115);
            CallChecker.varInit(this.size, "size", 480, 16613, 17115);
            CallChecker.varInit(this.loadFactor, "loadFactor", 480, 16613, 17115);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 480, 16613, 17115);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 480, 16613, 17115);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 480, 16613, 17115);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 480, 16613, 17115);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 480, 16613, 17115);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 480, 16613, 17115);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 480, 16613, 17115);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 480, 16613, 17115);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 480, 16613, 17115);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 480, 16613, 17115);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 480, 16613, 17115);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 481, 17085, 17089)) {
                entry.setValue(newValue);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context392.methodEnd();
        }
    }

    protected void reuseEntry(AbstractHashedMap.HashEntry<K, V> entry, int hashIndex, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context393 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 496, 17122, 17813);
            CallChecker.varInit(value, "value", 496, 17122, 17813);
            CallChecker.varInit(key, "key", 496, 17122, 17813);
            CallChecker.varInit(hashCode, "hashCode", 496, 17122, 17813);
            CallChecker.varInit(hashIndex, "hashIndex", 496, 17122, 17813);
            CallChecker.varInit(entry, "entry", 496, 17122, 17813);
            CallChecker.varInit(this.values, "values", 496, 17122, 17813);
            CallChecker.varInit(this.keySet, "keySet", 496, 17122, 17813);
            CallChecker.varInit(this.entrySet, "entrySet", 496, 17122, 17813);
            CallChecker.varInit(this.modCount, "modCount", 496, 17122, 17813);
            CallChecker.varInit(this.threshold, "threshold", 496, 17122, 17813);
            CallChecker.varInit(this.data, "data", 496, 17122, 17813);
            CallChecker.varInit(this.size, "size", 496, 17122, 17813);
            CallChecker.varInit(this.loadFactor, "loadFactor", 496, 17122, 17813);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 496, 17122, 17813);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 496, 17122, 17813);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 496, 17122, 17813);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 496, 17122, 17813);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 496, 17122, 17813);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 496, 17122, 17813);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 496, 17122, 17813);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 496, 17122, 17813);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 496, 17122, 17813);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 496, 17122, 17813);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 496, 17122, 17813);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 497, 17690, 17694)) {
                if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 497, 17703, 17706)) {
                    entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 497, 17690, 17694);
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 497, 17703, 17706);
                    CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 497, 17690, 17694).next = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 497, 17703, 17706)[hashIndex];
                    CallChecker.varAssign(CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 497, 17690, 17694).next, "CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 497, 17690, 17694).next", 497, 17690, 17718);
                }
            }
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 498, 17728, 17732)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 498, 17728, 17732);
                CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 498, 17728, 17732).hashCode = hashCode;
                CallChecker.varAssign(CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 498, 17728, 17732).hashCode, "CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 498, 17728, 17732).hashCode", 498, 17728, 17753);
            }
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 499, 17763, 17767)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 499, 17763, 17767);
                CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 499, 17763, 17767).key = key;
                CallChecker.varAssign(CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 499, 17763, 17767).key, "CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 499, 17763, 17767).key", 499, 17763, 17778);
            }
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 500, 17788, 17792)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 500, 17788, 17792);
                CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 500, 17788, 17792).value = value;
                CallChecker.varAssign(CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 500, 17788, 17792).value, "CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 500, 17788, 17792).value", 500, 17788, 17807);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context393.methodEnd();
        }
    }

    protected void addMapping(int hashIndex, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context394 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 517, 17820, 18708);
            CallChecker.varInit(value, "value", 517, 17820, 18708);
            CallChecker.varInit(key, "key", 517, 17820, 18708);
            CallChecker.varInit(hashCode, "hashCode", 517, 17820, 18708);
            CallChecker.varInit(hashIndex, "hashIndex", 517, 17820, 18708);
            CallChecker.varInit(this.values, "values", 517, 17820, 18708);
            CallChecker.varInit(this.keySet, "keySet", 517, 17820, 18708);
            CallChecker.varInit(this.entrySet, "entrySet", 517, 17820, 18708);
            CallChecker.varInit(this.modCount, "modCount", 517, 17820, 18708);
            CallChecker.varInit(this.threshold, "threshold", 517, 17820, 18708);
            CallChecker.varInit(this.data, "data", 517, 17820, 18708);
            CallChecker.varInit(this.size, "size", 517, 17820, 18708);
            CallChecker.varInit(this.loadFactor, "loadFactor", 517, 17820, 18708);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 517, 17820, 18708);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 517, 17820, 18708);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 517, 17820, 18708);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 517, 17820, 18708);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 517, 17820, 18708);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 517, 17820, 18708);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 517, 17820, 18708);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 517, 17820, 18708);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 517, 17820, 18708);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 517, 17820, 18708);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 517, 17820, 18708);
            (modCount)++;
            AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 519, 18587, 18590)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 519, 18587, 18590);
                entry = createEntry(CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 519, 18587, 18590)[hashIndex], hashCode, key, value);
                CallChecker.varAssign(entry, "entry", 519, 18587, 18590);
            }
            addEntry(entry, hashIndex);
            (size)++;
            checkCapacity();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context394.methodEnd();
        }
    }

    protected AbstractHashedMap.HashEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> next, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context395 = new MethodContext(AbstractHashedMap.HashEntry.class);
        try {
            CallChecker.varInit(this, "this", 538, 18715, 19344);
            CallChecker.varInit(value, "value", 538, 18715, 19344);
            CallChecker.varInit(key, "key", 538, 18715, 19344);
            CallChecker.varInit(hashCode, "hashCode", 538, 18715, 19344);
            CallChecker.varInit(next, "next", 538, 18715, 19344);
            CallChecker.varInit(this.values, "values", 538, 18715, 19344);
            CallChecker.varInit(this.keySet, "keySet", 538, 18715, 19344);
            CallChecker.varInit(this.entrySet, "entrySet", 538, 18715, 19344);
            CallChecker.varInit(this.modCount, "modCount", 538, 18715, 19344);
            CallChecker.varInit(this.threshold, "threshold", 538, 18715, 19344);
            CallChecker.varInit(this.data, "data", 538, 18715, 19344);
            CallChecker.varInit(this.size, "size", 538, 18715, 19344);
            CallChecker.varInit(this.loadFactor, "loadFactor", 538, 18715, 19344);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 538, 18715, 19344);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 538, 18715, 19344);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 538, 18715, 19344);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 538, 18715, 19344);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 538, 18715, 19344);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 538, 18715, 19344);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 538, 18715, 19344);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 538, 18715, 19344);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 538, 18715, 19344);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 538, 18715, 19344);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 538, 18715, 19344);
            return new AbstractHashedMap.HashEntry<K, V>(next, hashCode, convertKey(key), value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractHashedMap.HashEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context395.methodEnd();
        }
    }

    protected void addEntry(AbstractHashedMap.HashEntry<K, V> entry, int hashIndex) {
        MethodContext _bcornu_methode_context396 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 551, 19351, 19759);
            CallChecker.varInit(hashIndex, "hashIndex", 551, 19351, 19759);
            CallChecker.varInit(entry, "entry", 551, 19351, 19759);
            CallChecker.varInit(this.values, "values", 551, 19351, 19759);
            CallChecker.varInit(this.keySet, "keySet", 551, 19351, 19759);
            CallChecker.varInit(this.entrySet, "entrySet", 551, 19351, 19759);
            CallChecker.varInit(this.modCount, "modCount", 551, 19351, 19759);
            CallChecker.varInit(this.threshold, "threshold", 551, 19351, 19759);
            CallChecker.varInit(this.data, "data", 551, 19351, 19759);
            CallChecker.varInit(this.size, "size", 551, 19351, 19759);
            CallChecker.varInit(this.loadFactor, "loadFactor", 551, 19351, 19759);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 551, 19351, 19759);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 551, 19351, 19759);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 551, 19351, 19759);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 551, 19351, 19759);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 551, 19351, 19759);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 551, 19351, 19759);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 551, 19351, 19759);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 551, 19351, 19759);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 551, 19351, 19759);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 551, 19351, 19759);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 551, 19351, 19759);
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 552, 19730, 19733)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 552, 19730, 19733);
                CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 552, 19730, 19733)[hashIndex] = entry;
                CallChecker.varAssign(CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 552, 19730, 19733)[hashIndex], "CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 552, 19730, 19733)[hashIndex]", 552, 19730, 19753);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context396.methodEnd();
        }
    }

    protected void removeMapping(AbstractHashedMap.HashEntry<K, V> entry, int hashIndex, AbstractHashedMap.HashEntry<K, V> previous) {
        MethodContext _bcornu_methode_context397 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 567, 19766, 20531);
            CallChecker.varInit(previous, "previous", 567, 19766, 20531);
            CallChecker.varInit(hashIndex, "hashIndex", 567, 19766, 20531);
            CallChecker.varInit(entry, "entry", 567, 19766, 20531);
            CallChecker.varInit(this.values, "values", 567, 19766, 20531);
            CallChecker.varInit(this.keySet, "keySet", 567, 19766, 20531);
            CallChecker.varInit(this.entrySet, "entrySet", 567, 19766, 20531);
            CallChecker.varInit(this.modCount, "modCount", 567, 19766, 20531);
            CallChecker.varInit(this.threshold, "threshold", 567, 19766, 20531);
            CallChecker.varInit(this.data, "data", 567, 19766, 20531);
            CallChecker.varInit(this.size, "size", 567, 19766, 20531);
            CallChecker.varInit(this.loadFactor, "loadFactor", 567, 19766, 20531);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 567, 19766, 20531);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 567, 19766, 20531);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 567, 19766, 20531);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 567, 19766, 20531);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 567, 19766, 20531);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 567, 19766, 20531);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 567, 19766, 20531);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 567, 19766, 20531);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 567, 19766, 20531);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 567, 19766, 20531);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 567, 19766, 20531);
            (modCount)++;
            removeEntry(entry, hashIndex, previous);
            (size)--;
            destroyEntry(entry);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context397.methodEnd();
        }
    }

    protected void removeEntry(AbstractHashedMap.HashEntry<K, V> entry, int hashIndex, AbstractHashedMap.HashEntry<K, V> previous) {
        MethodContext _bcornu_methode_context398 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 585, 20538, 21204);
            CallChecker.varInit(previous, "previous", 585, 20538, 21204);
            CallChecker.varInit(hashIndex, "hashIndex", 585, 20538, 21204);
            CallChecker.varInit(entry, "entry", 585, 20538, 21204);
            CallChecker.varInit(this.values, "values", 585, 20538, 21204);
            CallChecker.varInit(this.keySet, "keySet", 585, 20538, 21204);
            CallChecker.varInit(this.entrySet, "entrySet", 585, 20538, 21204);
            CallChecker.varInit(this.modCount, "modCount", 585, 20538, 21204);
            CallChecker.varInit(this.threshold, "threshold", 585, 20538, 21204);
            CallChecker.varInit(this.data, "data", 585, 20538, 21204);
            CallChecker.varInit(this.size, "size", 585, 20538, 21204);
            CallChecker.varInit(this.loadFactor, "loadFactor", 585, 20538, 21204);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 585, 20538, 21204);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 585, 20538, 21204);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 585, 20538, 21204);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 585, 20538, 21204);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 585, 20538, 21204);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 585, 20538, 21204);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 585, 20538, 21204);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 585, 20538, 21204);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 585, 20538, 21204);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 585, 20538, 21204);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 585, 20538, 21204);
            if (previous == null) {
                if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 587, 21103, 21106)) {
                    if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 587, 21121, 21125)) {
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 587, 21103, 21106);
                        entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 587, 21121, 21125);
                        CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 587, 21103, 21106)[hashIndex] = CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 587, 21121, 21125).next;
                        CallChecker.varAssign(CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 587, 21103, 21106)[hashIndex], "CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 587, 21103, 21106)[hashIndex]", 587, 21103, 21131);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 589, 21178, 21182)) {
                    entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 589, 21178, 21182);
                    previous.next = CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 589, 21178, 21182).next;
                    CallChecker.varAssign(previous.next, "previous.next", 589, 21162, 21188);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context398.methodEnd();
        }
    }

    protected void destroyEntry(AbstractHashedMap.HashEntry<K, V> entry) {
        MethodContext _bcornu_methode_context399 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 601, 21211, 21637);
            CallChecker.varInit(entry, "entry", 601, 21211, 21637);
            CallChecker.varInit(this.values, "values", 601, 21211, 21637);
            CallChecker.varInit(this.keySet, "keySet", 601, 21211, 21637);
            CallChecker.varInit(this.entrySet, "entrySet", 601, 21211, 21637);
            CallChecker.varInit(this.modCount, "modCount", 601, 21211, 21637);
            CallChecker.varInit(this.threshold, "threshold", 601, 21211, 21637);
            CallChecker.varInit(this.data, "data", 601, 21211, 21637);
            CallChecker.varInit(this.size, "size", 601, 21211, 21637);
            CallChecker.varInit(this.loadFactor, "loadFactor", 601, 21211, 21637);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 601, 21211, 21637);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 601, 21211, 21637);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 601, 21211, 21637);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 601, 21211, 21637);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 601, 21211, 21637);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 601, 21211, 21637);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 601, 21211, 21637);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 601, 21211, 21637);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 601, 21211, 21637);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 601, 21211, 21637);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 601, 21211, 21637);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 602, 21560, 21564)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 602, 21560, 21564);
                CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 602, 21560, 21564).next = null;
                CallChecker.varAssign(CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 602, 21560, 21564).next, "CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 602, 21560, 21564).next", 602, 21560, 21577);
            }
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 603, 21587, 21591)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 603, 21587, 21591);
                CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 603, 21587, 21591).key = null;
                CallChecker.varAssign(CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 603, 21587, 21591).key, "CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 603, 21587, 21591).key", 603, 21587, 21603);
            }
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 604, 21613, 21617)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 604, 21613, 21617);
                CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 604, 21613, 21617).value = null;
                CallChecker.varAssign(CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 604, 21613, 21617).value, "CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 604, 21613, 21617).value", 604, 21613, 21631);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context399.methodEnd();
        }
    }

    protected void checkCapacity() {
        MethodContext _bcornu_methode_context400 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 613, 21644, 22136);
            CallChecker.varInit(this.values, "values", 613, 21644, 22136);
            CallChecker.varInit(this.keySet, "keySet", 613, 21644, 22136);
            CallChecker.varInit(this.entrySet, "entrySet", 613, 21644, 22136);
            CallChecker.varInit(this.modCount, "modCount", 613, 21644, 22136);
            CallChecker.varInit(this.threshold, "threshold", 613, 21644, 22136);
            CallChecker.varInit(this.data, "data", 613, 21644, 22136);
            CallChecker.varInit(this.size, "size", 613, 21644, 22136);
            CallChecker.varInit(this.loadFactor, "loadFactor", 613, 21644, 22136);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 613, 21644, 22136);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 613, 21644, 22136);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 613, 21644, 22136);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 613, 21644, 22136);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 613, 21644, 22136);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 613, 21644, 22136);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 613, 21644, 22136);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 613, 21644, 22136);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 613, 21644, 22136);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 613, 21644, 22136);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 613, 21644, 22136);
            if ((size) >= (threshold)) {
                int newCapacity = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 615, 21995, 21998)) {
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 615, 21995, 21998);
                    newCapacity = (CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 615, 21995, 21998).length) * 2;
                    CallChecker.varAssign(newCapacity, "newCapacity", 615, 21995, 21998);
                }
                if (newCapacity <= (AbstractHashedMap.MAXIMUM_CAPACITY)) {
                    ensureCapacity(newCapacity);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context400.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected void ensureCapacity(int newCapacity) {
        MethodContext _bcornu_methode_context401 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 628, 22143, 23526);
            CallChecker.varInit(newCapacity, "newCapacity", 628, 22143, 23526);
            CallChecker.varInit(this.values, "values", 628, 22143, 23526);
            CallChecker.varInit(this.keySet, "keySet", 628, 22143, 23526);
            CallChecker.varInit(this.entrySet, "entrySet", 628, 22143, 23526);
            CallChecker.varInit(this.modCount, "modCount", 628, 22143, 23526);
            CallChecker.varInit(this.threshold, "threshold", 628, 22143, 23526);
            CallChecker.varInit(this.data, "data", 628, 22143, 23526);
            CallChecker.varInit(this.size, "size", 628, 22143, 23526);
            CallChecker.varInit(this.loadFactor, "loadFactor", 628, 22143, 23526);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 628, 22143, 23526);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 628, 22143, 23526);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 628, 22143, 23526);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 628, 22143, 23526);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 628, 22143, 23526);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 628, 22143, 23526);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 628, 22143, 23526);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 628, 22143, 23526);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 628, 22143, 23526);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 628, 22143, 23526);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 628, 22143, 23526);
            int oldCapacity = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 629, 22444, 22447)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 629, 22444, 22447);
                oldCapacity = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 629, 22444, 22447).length;
                CallChecker.varAssign(oldCapacity, "oldCapacity", 629, 22444, 22447);
            }
            if (newCapacity <= oldCapacity) {
                return ;
            }
            if ((size) == 0) {
                threshold = calculateThreshold(newCapacity, loadFactor);
                CallChecker.varAssign(this.threshold, "this.threshold", 634, 22566, 22621);
                data = new AbstractHashedMap.HashEntry[newCapacity];
                CallChecker.varAssign(this.data, "this.data", 635, 22635, 22668);
            }else {
                AbstractHashedMap.HashEntry<K, V>[] oldEntries = CallChecker.varInit(data, "oldEntries", 637, 22699, 22734);
                AbstractHashedMap.HashEntry<K, V>[] newEntries = CallChecker.varInit(new AbstractHashedMap.HashEntry[newCapacity], "newEntries", 638, 22748, 22805);
                (modCount)++;
                for (int i = oldCapacity - 1; i >= 0; i--) {
                    AbstractHashedMap.HashEntry<K, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
                    if (CallChecker.beforeDeref(oldEntries, AbstractHashedMap.HashEntry[].class, 642, 22929, 22938)) {
                        oldEntries = CallChecker.beforeCalled(oldEntries, AbstractHashedMap.HashEntry[].class, 642, 22929, 22938);
                        entry = CallChecker.isCalled(oldEntries, AbstractHashedMap.HashEntry[].class, 642, 22929, 22938)[i];
                        CallChecker.varAssign(entry, "entry", 642, 22929, 22938);
                    }
                    if (entry != null) {
                        if (CallChecker.beforeDeref(oldEntries, AbstractHashedMap.HashEntry[].class, 644, 23001, 23010)) {
                            oldEntries = CallChecker.beforeCalled(oldEntries, AbstractHashedMap.HashEntry[].class, 644, 23001, 23010);
                            CallChecker.isCalled(oldEntries, AbstractHashedMap.HashEntry[].class, 644, 23001, 23010)[i] = null;
                            CallChecker.varAssign(CallChecker.isCalled(oldEntries, AbstractHashedMap.HashEntry[].class, 644, 23001, 23010)[i], "CallChecker.isCalled(oldEntries, AbstractHashedMap.HashEntry[].class, 644, 23001, 23010)[i]", 644, 23001, 23021);
                        }
                        do {
                            AbstractHashedMap.HashEntry<K, V> next = CallChecker.varInit(entry.next, "next", 646, 23079, 23112);
                            int index = CallChecker.varInit(((int) (hashIndex(entry.hashCode, newCapacity))), "index", 647, 23138, 23188);
                            if (CallChecker.beforeDeref(newEntries, AbstractHashedMap.HashEntry[].class, 648, 23227, 23236)) {
                                newEntries = CallChecker.beforeCalled(newEntries, AbstractHashedMap.HashEntry[].class, 648, 23227, 23236);
                                entry.next = CallChecker.isCalled(newEntries, AbstractHashedMap.HashEntry[].class, 648, 23227, 23236)[index];
                                CallChecker.varAssign(entry.next, "entry.next", 648, 23214, 23244);
                            }
                            if (CallChecker.beforeDeref(newEntries, AbstractHashedMap.HashEntry[].class, 649, 23270, 23279)) {
                                newEntries = CallChecker.beforeCalled(newEntries, AbstractHashedMap.HashEntry[].class, 649, 23270, 23279);
                                CallChecker.isCalled(newEntries, AbstractHashedMap.HashEntry[].class, 649, 23270, 23279)[index] = entry;
                                CallChecker.varAssign(CallChecker.isCalled(newEntries, AbstractHashedMap.HashEntry[].class, 649, 23270, 23279)[index], "CallChecker.isCalled(newEntries, AbstractHashedMap.HashEntry[].class, 649, 23270, 23279)[index]", 649, 23270, 23295);
                            }
                            entry = next;
                            CallChecker.varAssign(entry, "entry", 650, 23321, 23333);
                        } while (entry != null );
                    }
                }
                threshold = calculateThreshold(newCapacity, loadFactor);
                CallChecker.varAssign(this.threshold, "this.threshold", 654, 23424, 23479);
                data = newEntries;
                CallChecker.varAssign(this.data, "this.data", 655, 23493, 23510);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context401.methodEnd();
        }
    }

    protected int calculateNewCapacity(int proposedCapacity) {
        MethodContext _bcornu_methode_context402 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 666, 23533, 24246);
            CallChecker.varInit(proposedCapacity, "proposedCapacity", 666, 23533, 24246);
            CallChecker.varInit(this.values, "values", 666, 23533, 24246);
            CallChecker.varInit(this.keySet, "keySet", 666, 23533, 24246);
            CallChecker.varInit(this.entrySet, "entrySet", 666, 23533, 24246);
            CallChecker.varInit(this.modCount, "modCount", 666, 23533, 24246);
            CallChecker.varInit(this.threshold, "threshold", 666, 23533, 24246);
            CallChecker.varInit(this.data, "data", 666, 23533, 24246);
            CallChecker.varInit(this.size, "size", 666, 23533, 24246);
            CallChecker.varInit(this.loadFactor, "loadFactor", 666, 23533, 24246);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 666, 23533, 24246);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 666, 23533, 24246);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 666, 23533, 24246);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 666, 23533, 24246);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 666, 23533, 24246);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 666, 23533, 24246);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 666, 23533, 24246);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 666, 23533, 24246);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 666, 23533, 24246);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 666, 23533, 24246);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 666, 23533, 24246);
            int newCapacity = CallChecker.varInit(((int) (1)), "newCapacity", 667, 23837, 23856);
            if (proposedCapacity > (AbstractHashedMap.MAXIMUM_CAPACITY)) {
                newCapacity = AbstractHashedMap.MAXIMUM_CAPACITY;
                CallChecker.varAssign(newCapacity, "newCapacity", 669, 23921, 23951);
            }else {
                while (newCapacity < proposedCapacity) {
                    newCapacity <<= 1;
                    CallChecker.varAssign(newCapacity, "newCapacity", 672, 24039, 24056);
                } 
                if (newCapacity > (AbstractHashedMap.MAXIMUM_CAPACITY)) {
                    newCapacity = AbstractHashedMap.MAXIMUM_CAPACITY;
                    CallChecker.varAssign(newCapacity, "newCapacity", 675, 24158, 24188);
                }
            }
            return newCapacity;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context402.methodEnd();
        }
    }

    protected int calculateThreshold(int newCapacity, float factor) {
        MethodContext _bcornu_methode_context403 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 689, 24253, 24636);
            CallChecker.varInit(factor, "factor", 689, 24253, 24636);
            CallChecker.varInit(newCapacity, "newCapacity", 689, 24253, 24636);
            CallChecker.varInit(this.values, "values", 689, 24253, 24636);
            CallChecker.varInit(this.keySet, "keySet", 689, 24253, 24636);
            CallChecker.varInit(this.entrySet, "entrySet", 689, 24253, 24636);
            CallChecker.varInit(this.modCount, "modCount", 689, 24253, 24636);
            CallChecker.varInit(this.threshold, "threshold", 689, 24253, 24636);
            CallChecker.varInit(this.data, "data", 689, 24253, 24636);
            CallChecker.varInit(this.size, "size", 689, 24253, 24636);
            CallChecker.varInit(this.loadFactor, "loadFactor", 689, 24253, 24636);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 689, 24253, 24636);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 689, 24253, 24636);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 689, 24253, 24636);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 689, 24253, 24636);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 689, 24253, 24636);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 689, 24253, 24636);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 689, 24253, 24636);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 689, 24253, 24636);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 689, 24253, 24636);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 689, 24253, 24636);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 689, 24253, 24636);
            return ((int) (newCapacity * factor));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context403.methodEnd();
        }
    }

    protected AbstractHashedMap.HashEntry<K, V> entryNext(AbstractHashedMap.HashEntry<K, V> entry) {
        MethodContext _bcornu_methode_context404 = new MethodContext(AbstractHashedMap.HashEntry.class);
        try {
            CallChecker.varInit(this, "this", 703, 24643, 25180);
            CallChecker.varInit(entry, "entry", 703, 24643, 25180);
            CallChecker.varInit(this.values, "values", 703, 24643, 25180);
            CallChecker.varInit(this.keySet, "keySet", 703, 24643, 25180);
            CallChecker.varInit(this.entrySet, "entrySet", 703, 24643, 25180);
            CallChecker.varInit(this.modCount, "modCount", 703, 24643, 25180);
            CallChecker.varInit(this.threshold, "threshold", 703, 24643, 25180);
            CallChecker.varInit(this.data, "data", 703, 24643, 25180);
            CallChecker.varInit(this.size, "size", 703, 24643, 25180);
            CallChecker.varInit(this.loadFactor, "loadFactor", 703, 24643, 25180);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 703, 24643, 25180);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 703, 24643, 25180);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 703, 24643, 25180);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 703, 24643, 25180);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 703, 24643, 25180);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 703, 24643, 25180);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 703, 24643, 25180);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 703, 24643, 25180);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 703, 24643, 25180);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 703, 24643, 25180);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 703, 24643, 25180);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 704, 25164, 25168)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 704, 25164, 25168);
                return CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 704, 25164, 25168).next;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractHashedMap.HashEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context404.methodEnd();
        }
    }

    protected int entryHashCode(AbstractHashedMap.HashEntry<K, V> entry) {
        MethodContext _bcornu_methode_context405 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 716, 25187, 25650);
            CallChecker.varInit(entry, "entry", 716, 25187, 25650);
            CallChecker.varInit(this.values, "values", 716, 25187, 25650);
            CallChecker.varInit(this.keySet, "keySet", 716, 25187, 25650);
            CallChecker.varInit(this.entrySet, "entrySet", 716, 25187, 25650);
            CallChecker.varInit(this.modCount, "modCount", 716, 25187, 25650);
            CallChecker.varInit(this.threshold, "threshold", 716, 25187, 25650);
            CallChecker.varInit(this.data, "data", 716, 25187, 25650);
            CallChecker.varInit(this.size, "size", 716, 25187, 25650);
            CallChecker.varInit(this.loadFactor, "loadFactor", 716, 25187, 25650);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 716, 25187, 25650);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 716, 25187, 25650);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 716, 25187, 25650);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 716, 25187, 25650);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 716, 25187, 25650);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 716, 25187, 25650);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 716, 25187, 25650);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 716, 25187, 25650);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 716, 25187, 25650);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 716, 25187, 25650);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 716, 25187, 25650);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 717, 25630, 25634)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 717, 25630, 25634);
                return CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 717, 25630, 25634).hashCode;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context405.methodEnd();
        }
    }

    protected K entryKey(AbstractHashedMap.HashEntry<K, V> entry) {
        if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 730, 26083, 26087)) {
            return entry.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    protected V entryValue(AbstractHashedMap.HashEntry<K, V> entry) {
        if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 743, 26542, 26546)) {
            return entry.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context408 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 758, 26571, 27252);
            CallChecker.varInit(this.values, "values", 758, 26571, 27252);
            CallChecker.varInit(this.keySet, "keySet", 758, 26571, 27252);
            CallChecker.varInit(this.entrySet, "entrySet", 758, 26571, 27252);
            CallChecker.varInit(this.modCount, "modCount", 758, 26571, 27252);
            CallChecker.varInit(this.threshold, "threshold", 758, 26571, 27252);
            CallChecker.varInit(this.data, "data", 758, 26571, 27252);
            CallChecker.varInit(this.size, "size", 758, 26571, 27252);
            CallChecker.varInit(this.loadFactor, "loadFactor", 758, 26571, 27252);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 758, 26571, 27252);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 758, 26571, 27252);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 758, 26571, 27252);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 758, 26571, 27252);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 758, 26571, 27252);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 758, 26571, 27252);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 758, 26571, 27252);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 758, 26571, 27252);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 758, 26571, 27252);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 758, 26571, 27252);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 758, 26571, 27252);
            if ((size) == 0) {
                return EmptyMapIterator.<K, V>getInstance();
            }
            return new AbstractHashedMap.HashMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context408.methodEnd();
        }
    }

    protected static class HashMapIterator<K, V> extends AbstractHashedMap.HashIterator<K, V> implements MapIterator<K, V> {
        protected HashMapIterator(AbstractHashedMap<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context64 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context64.methodEnd();
            }
        }

        public K next() {
            final AbstractHashedMap.HashEntry<K, V> npe_invocation_var115 = super.nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var115, AbstractHashedMap.HashEntry.class, 775, 27565, 27581)) {
                return npe_invocation_var115.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public K getKey() {
            AbstractHashedMap.HashEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 779, 27644, 27684);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            return current.getKey();
        }

        public V getValue() {
            AbstractHashedMap.HashEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 787, 27908, 27948);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            return current.getValue();
        }

        public V setValue(V value) {
            AbstractHashedMap.HashEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 795, 28183, 28223);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            return current.setValue(value);
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context413 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 812, 28424, 28898);
            CallChecker.varInit(this.values, "values", 812, 28424, 28898);
            CallChecker.varInit(this.keySet, "keySet", 812, 28424, 28898);
            CallChecker.varInit(this.entrySet, "entrySet", 812, 28424, 28898);
            CallChecker.varInit(this.modCount, "modCount", 812, 28424, 28898);
            CallChecker.varInit(this.threshold, "threshold", 812, 28424, 28898);
            CallChecker.varInit(this.data, "data", 812, 28424, 28898);
            CallChecker.varInit(this.size, "size", 812, 28424, 28898);
            CallChecker.varInit(this.loadFactor, "loadFactor", 812, 28424, 28898);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 812, 28424, 28898);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 812, 28424, 28898);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 812, 28424, 28898);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 812, 28424, 28898);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 812, 28424, 28898);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 812, 28424, 28898);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 812, 28424, 28898);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 812, 28424, 28898);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 812, 28424, 28898);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 812, 28424, 28898);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 812, 28424, 28898);
            if ((entrySet) == null) {
                entrySet = new AbstractHashedMap.EntrySet<K, V>(this);
                CallChecker.varAssign(this.entrySet, "this.entrySet", 814, 28822, 28857);
            }
            return entrySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context413.methodEnd();
        }
    }

    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        MethodContext _bcornu_methode_context414 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 825, 28905, 29304);
            CallChecker.varInit(this.values, "values", 825, 28905, 29304);
            CallChecker.varInit(this.keySet, "keySet", 825, 28905, 29304);
            CallChecker.varInit(this.entrySet, "entrySet", 825, 28905, 29304);
            CallChecker.varInit(this.modCount, "modCount", 825, 28905, 29304);
            CallChecker.varInit(this.threshold, "threshold", 825, 28905, 29304);
            CallChecker.varInit(this.data, "data", 825, 28905, 29304);
            CallChecker.varInit(this.size, "size", 825, 28905, 29304);
            CallChecker.varInit(this.loadFactor, "loadFactor", 825, 28905, 29304);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 825, 28905, 29304);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 825, 28905, 29304);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 825, 28905, 29304);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 825, 28905, 29304);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 825, 28905, 29304);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 825, 28905, 29304);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 825, 28905, 29304);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 825, 28905, 29304);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 825, 28905, 29304);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 825, 28905, 29304);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 825, 28905, 29304);
            if ((size()) == 0) {
                return EmptyIterator.<Map.Entry<K, V>>getInstance();
            }
            return new AbstractHashedMap.EntrySetIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context414.methodEnd();
        }
    }

    protected static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        protected final AbstractHashedMap<K, V> parent;

        protected EntrySet(AbstractHashedMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context65 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 841, 29617, 29637);
            } finally {
                _bcornu_methode_context65.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context415 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 845, 29658, 29738);
                CallChecker.varInit(this.parent, "parent", 845, 29658, 29738);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 846, 29715, 29720)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 846, 29715, 29720).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context415.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context416 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 850, 29749, 29825);
                CallChecker.varInit(this.parent, "parent", 850, 29749, 29825);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 851, 29801, 29806)) {
                    CallChecker.isCalled(parent, AbstractHashedMap.class, 851, 29801, 29806).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context416.methodEnd();
            }
        }

        @Override
        public boolean contains(Object entry) {
            MethodContext _bcornu_methode_context417 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 855, 29836, 30173);
                CallChecker.varInit(entry, "entry", 855, 29836, 30173);
                CallChecker.varInit(this.parent, "parent", 855, 29836, 30173);
                if (entry instanceof Map.Entry) {
                    Map.Entry<?, ?> e = CallChecker.varInit(((Map.Entry<?, ?>) (entry)), "e", 857, 29956, 29999);
                    Map.Entry<K, V> match = CallChecker.init(Map.Entry.class);
                    if (CallChecker.beforeDeref(e, Map.Entry.class, 858, 30053, 30053)) {
                        if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 858, 30037, 30042)) {
                            match = CallChecker.isCalled(parent, AbstractHashedMap.class, 858, 30037, 30042).getEntry(e.getKey());
                            CallChecker.varAssign(match, "match", 858, 30053, 30053);
                        }
                    }
                    match = CallChecker.beforeCalled(match, Map.Entry.class, 859, 30107, 30111);
                    return (match != null) && (CallChecker.isCalled(match, Map.Entry.class, 859, 30107, 30111).equals(e));
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context417.methodEnd();
            }
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context418 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 865, 30184, 30556);
                CallChecker.varInit(obj, "obj", 865, 30184, 30556);
                CallChecker.varInit(this.parent, "parent", 865, 30184, 30556);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                if ((contains(obj)) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 872, 30433, 30478);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 873, 30506, 30510)) {
                    if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 873, 30492, 30497)) {
                        parent.remove(entry.getKey());
                    }
                }
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context418.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context419 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 878, 30567, 30691);
                CallChecker.varInit(this.parent, "parent", 878, 30567, 30691);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 879, 30650, 30655)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 879, 30650, 30655).createEntrySetIterator();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context419.methodEnd();
            }
        }
    }

    protected static class EntrySetIterator<K, V> extends AbstractHashedMap.HashIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        protected EntrySetIterator(AbstractHashedMap<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context66 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context66.methodEnd();
            }
        }

        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context420 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 892, 30974, 31052);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 892, 30974, 31052);
                CallChecker.varInit(this.next, "next", 892, 30974, 31052);
                CallChecker.varInit(this.last, "last", 892, 30974, 31052);
                CallChecker.varInit(this.hashIndex, "hashIndex", 892, 30974, 31052);
                CallChecker.varInit(this.parent, "parent", 892, 30974, 31052);
                return super.nextEntry();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context420.methodEnd();
            }
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context421 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 906, 31065, 31505);
            CallChecker.varInit(this.values, "values", 906, 31065, 31505);
            CallChecker.varInit(this.keySet, "keySet", 906, 31065, 31505);
            CallChecker.varInit(this.entrySet, "entrySet", 906, 31065, 31505);
            CallChecker.varInit(this.modCount, "modCount", 906, 31065, 31505);
            CallChecker.varInit(this.threshold, "threshold", 906, 31065, 31505);
            CallChecker.varInit(this.data, "data", 906, 31065, 31505);
            CallChecker.varInit(this.size, "size", 906, 31065, 31505);
            CallChecker.varInit(this.loadFactor, "loadFactor", 906, 31065, 31505);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 906, 31065, 31505);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 906, 31065, 31505);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 906, 31065, 31505);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 906, 31065, 31505);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 906, 31065, 31505);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 906, 31065, 31505);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 906, 31065, 31505);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 906, 31065, 31505);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 906, 31065, 31505);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 906, 31065, 31505);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 906, 31065, 31505);
            if ((keySet) == null) {
                keySet = new AbstractHashedMap.KeySet<K>(this);
                CallChecker.varAssign(this.keySet, "this.keySet", 908, 31438, 31466);
            }
            return keySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context421.methodEnd();
        }
    }

    protected Iterator<K> createKeySetIterator() {
        MethodContext _bcornu_methode_context422 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 919, 31512, 31871);
            CallChecker.varInit(this.values, "values", 919, 31512, 31871);
            CallChecker.varInit(this.keySet, "keySet", 919, 31512, 31871);
            CallChecker.varInit(this.entrySet, "entrySet", 919, 31512, 31871);
            CallChecker.varInit(this.modCount, "modCount", 919, 31512, 31871);
            CallChecker.varInit(this.threshold, "threshold", 919, 31512, 31871);
            CallChecker.varInit(this.data, "data", 919, 31512, 31871);
            CallChecker.varInit(this.size, "size", 919, 31512, 31871);
            CallChecker.varInit(this.loadFactor, "loadFactor", 919, 31512, 31871);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 919, 31512, 31871);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 919, 31512, 31871);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 919, 31512, 31871);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 919, 31512, 31871);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 919, 31512, 31871);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 919, 31512, 31871);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 919, 31512, 31871);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 919, 31512, 31871);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 919, 31512, 31871);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 919, 31512, 31871);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 919, 31512, 31871);
            if ((size()) == 0) {
                return EmptyIterator.<K>getInstance();
            }
            return new AbstractHashedMap.KeySetIterator<K>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context422.methodEnd();
        }
    }

    protected static class KeySet<K> extends AbstractSet<K> {
        protected final AbstractHashedMap<K, ?> parent;

        protected KeySet(AbstractHashedMap<K, ?> parent) {
            super();
            MethodContext _bcornu_methode_context67 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 935, 32161, 32181);
            } finally {
                _bcornu_methode_context67.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context423 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 939, 32202, 32282);
                CallChecker.varInit(this.parent, "parent", 939, 32202, 32282);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 940, 32259, 32264)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 940, 32259, 32264).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context423.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context424 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 944, 32293, 32369);
                CallChecker.varInit(this.parent, "parent", 944, 32293, 32369);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 945, 32345, 32350)) {
                    CallChecker.isCalled(parent, AbstractHashedMap.class, 945, 32345, 32350).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context424.methodEnd();
            }
        }

        @Override
        public boolean contains(Object key) {
            MethodContext _bcornu_methode_context425 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 949, 32380, 32488);
                CallChecker.varInit(key, "key", 949, 32380, 32488);
                CallChecker.varInit(this.parent, "parent", 949, 32380, 32488);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 950, 32455, 32460)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 950, 32455, 32460).containsKey(key);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context425.methodEnd();
            }
        }

        @Override
        public boolean remove(Object key) {
            MethodContext _bcornu_methode_context426 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 954, 32499, 32674);
                CallChecker.varInit(key, "key", 954, 32499, 32674);
                CallChecker.varInit(this.parent, "parent", 954, 32499, 32674);
                boolean result = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 955, 32582, 32587)) {
                    result = CallChecker.isCalled(parent, AbstractHashedMap.class, 955, 32582, 32587).containsKey(key);
                    CallChecker.varAssign(result, "result", 955, 32582, 32587);
                }
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 956, 32619, 32624)) {
                    parent.remove(key);
                }
                return result;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context426.methodEnd();
            }
        }

        @Override
        public Iterator<K> iterator() {
            MethodContext _bcornu_methode_context427 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 961, 32685, 32793);
                CallChecker.varInit(this.parent, "parent", 961, 32685, 32793);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 962, 32754, 32759)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 962, 32754, 32759).createKeySetIterator();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context427.methodEnd();
            }
        }
    }

    protected static class KeySetIterator<K> extends AbstractHashedMap.HashIterator<K, Object> implements Iterator<K> {
        @SuppressWarnings(value = "unchecked")
        protected KeySetIterator(AbstractHashedMap<K, ?> parent) {
            super(((AbstractHashedMap<K, Object>) (parent)));
            MethodContext _bcornu_methode_context68 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context68.methodEnd();
            }
        }

        public K next() {
            final AbstractHashedMap.HashEntry<K, Object> npe_invocation_var116 = super.nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var116, AbstractHashedMap.HashEntry.class, 977, 33165, 33181)) {
                return npe_invocation_var116.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context429 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 990, 33214, 33663);
            CallChecker.varInit(this.values, "values", 990, 33214, 33663);
            CallChecker.varInit(this.keySet, "keySet", 990, 33214, 33663);
            CallChecker.varInit(this.entrySet, "entrySet", 990, 33214, 33663);
            CallChecker.varInit(this.modCount, "modCount", 990, 33214, 33663);
            CallChecker.varInit(this.threshold, "threshold", 990, 33214, 33663);
            CallChecker.varInit(this.data, "data", 990, 33214, 33663);
            CallChecker.varInit(this.size, "size", 990, 33214, 33663);
            CallChecker.varInit(this.loadFactor, "loadFactor", 990, 33214, 33663);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 990, 33214, 33663);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 990, 33214, 33663);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 990, 33214, 33663);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 990, 33214, 33663);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 990, 33214, 33663);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 990, 33214, 33663);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 990, 33214, 33663);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 990, 33214, 33663);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 990, 33214, 33663);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 990, 33214, 33663);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 990, 33214, 33663);
            if ((values) == null) {
                values = new AbstractHashedMap.Values<V>(this);
                CallChecker.varAssign(this.values, "this.values", 992, 33596, 33624);
            }
            return values;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context429.methodEnd();
        }
    }

    protected Iterator<V> createValuesIterator() {
        MethodContext _bcornu_methode_context430 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 1003, 33670, 34028);
            CallChecker.varInit(this.values, "values", 1003, 33670, 34028);
            CallChecker.varInit(this.keySet, "keySet", 1003, 33670, 34028);
            CallChecker.varInit(this.entrySet, "entrySet", 1003, 33670, 34028);
            CallChecker.varInit(this.modCount, "modCount", 1003, 33670, 34028);
            CallChecker.varInit(this.threshold, "threshold", 1003, 33670, 34028);
            CallChecker.varInit(this.data, "data", 1003, 33670, 34028);
            CallChecker.varInit(this.size, "size", 1003, 33670, 34028);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1003, 33670, 34028);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1003, 33670, 34028);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1003, 33670, 34028);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1003, 33670, 34028);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1003, 33670, 34028);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1003, 33670, 34028);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1003, 33670, 34028);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1003, 33670, 34028);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1003, 33670, 34028);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1003, 33670, 34028);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1003, 33670, 34028);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1003, 33670, 34028);
            if ((size()) == 0) {
                return EmptyIterator.<V>getInstance();
            }
            return new AbstractHashedMap.ValuesIterator<V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context430.methodEnd();
        }
    }

    protected static class Values<V> extends AbstractCollection<V> {
        protected final AbstractHashedMap<?, V> parent;

        protected Values(AbstractHashedMap<?, V> parent) {
            super();
            MethodContext _bcornu_methode_context69 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 1019, 34325, 34345);
            } finally {
                _bcornu_methode_context69.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context431 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 1023, 34366, 34446);
                CallChecker.varInit(this.parent, "parent", 1023, 34366, 34446);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1024, 34423, 34428)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 1024, 34423, 34428).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context431.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context432 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1028, 34457, 34533);
                CallChecker.varInit(this.parent, "parent", 1028, 34457, 34533);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1029, 34509, 34514)) {
                    CallChecker.isCalled(parent, AbstractHashedMap.class, 1029, 34509, 34514).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context432.methodEnd();
            }
        }

        @Override
        public boolean contains(Object value) {
            MethodContext _bcornu_methode_context433 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1033, 34544, 34658);
                CallChecker.varInit(value, "value", 1033, 34544, 34658);
                CallChecker.varInit(this.parent, "parent", 1033, 34544, 34658);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1034, 34621, 34626)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 1034, 34621, 34626).containsValue(value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context433.methodEnd();
            }
        }

        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context434 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 1038, 34669, 34777);
                CallChecker.varInit(this.parent, "parent", 1038, 34669, 34777);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1039, 34738, 34743)) {
                    return CallChecker.isCalled(parent, AbstractHashedMap.class, 1039, 34738, 34743).createValuesIterator();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context434.methodEnd();
            }
        }
    }

    protected static class ValuesIterator<V> extends AbstractHashedMap.HashIterator<Object, V> implements Iterator<V> {
        @SuppressWarnings(value = "unchecked")
        protected ValuesIterator(AbstractHashedMap<?, V> parent) {
            super(((AbstractHashedMap<Object, V>) (parent)));
            MethodContext _bcornu_methode_context70 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context70.methodEnd();
            }
        }

        public V next() {
            final AbstractHashedMap.HashEntry<Object, V> npe_invocation_var117 = super.nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var117, AbstractHashedMap.HashEntry.class, 1054, 35149, 35165)) {
                return npe_invocation_var117.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    protected static class HashEntry<K, V> implements Map.Entry<K, V> , KeyValue<K, V> {
        protected AbstractHashedMap.HashEntry<K, V> next;

        protected int hashCode;

        protected Object key;

        protected Object value;

        protected HashEntry(AbstractHashedMap.HashEntry<K, V> next, int hashCode, Object key, V value) {
            super();
            MethodContext _bcornu_methode_context71 = new MethodContext(null);
            try {
                this.next = next;
                CallChecker.varAssign(this.next, "this.next", 1079, 36094, 36110);
                this.hashCode = hashCode;
                CallChecker.varAssign(this.hashCode, "this.hashCode", 1080, 36124, 36148);
                this.key = key;
                CallChecker.varAssign(this.key, "this.key", 1081, 36162, 36176);
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 1082, 36190, 36208);
            } finally {
                _bcornu_methode_context71.methodEnd();
            }
        }

        @SuppressWarnings(value = "unchecked")
        public K getKey() {
            if ((key) == (AbstractHashedMap.NULL)) {
                return null;
            }
            return ((K) (key));
        }

        @SuppressWarnings(value = "unchecked")
        public V getValue() {
            return ((V) (value));
        }

        @SuppressWarnings(value = "unchecked")
        public V setValue(V value) {
            Object old = CallChecker.varInit(this.value, "old", 1100, 36599, 36622);
            this.value = value;
            CallChecker.varAssign(this.value, "this.value", 1101, 36636, 36654);
            return ((V) (old));
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context439 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1106, 36703, 37214);
                CallChecker.varInit(obj, "obj", 1106, 36703, 37214);
                CallChecker.varInit(this.value, "value", 1106, 36703, 37214);
                CallChecker.varInit(this.key, "key", 1106, 36703, 37214);
                CallChecker.varInit(this.hashCode, "hashCode", 1106, 36703, 37214);
                CallChecker.varInit(this.next, "next", 1106, 36703, 37214);
                if (obj == (this)) {
                    return true;
                }
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> other = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "other", 1113, 36940, 36985);
                if (CallChecker.beforeDeref(other, Map.Entry.class, 1115, 37083, 37087)) {
                    final K npe_invocation_var118 = getKey();
                    if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var118, null, 1115, 37067, 37074))) {
                        if (CallChecker.beforeDeref(other, Map.Entry.class, 1116, 37186, 37190)) {
                            final V npe_invocation_var119 = getValue();
                            if (((getValue()) == null) || (CallChecker.beforeDeref(npe_invocation_var119, null, 1116, 37168, 37177))) {
                                return (((getKey()) == null) ? (other.getKey()) == null : npe_invocation_var118.equals(other.getKey())) && (((getValue()) == null) ? (other.getValue()) == null : npe_invocation_var119.equals(other.getValue()));
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
                _bcornu_methode_context439.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context440 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 1120, 37225, 37410);
                CallChecker.varInit(this.value, "value", 1120, 37225, 37410);
                CallChecker.varInit(this.key, "key", 1120, 37225, 37410);
                CallChecker.varInit(this.hashCode, "hashCode", 1120, 37225, 37410);
                CallChecker.varInit(this.next, "next", 1120, 37225, 37410);
                final K npe_invocation_var120 = getKey();
                if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var120, null, 1121, 37310, 37317))) {
                    final V npe_invocation_var121 = getValue();
                    if (((getValue()) == null) || (CallChecker.beforeDeref(npe_invocation_var121, null, 1122, 37378, 37387))) {
                        return (((getKey()) == null) ? 0 : npe_invocation_var120.hashCode()) ^ (((getValue()) == null) ? 0 : npe_invocation_var121.hashCode());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context440.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context441 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 1126, 37421, 37573);
                CallChecker.varInit(this.value, "value", 1126, 37421, 37573);
                CallChecker.varInit(this.key, "key", 1126, 37421, 37573);
                CallChecker.varInit(this.hashCode, "hashCode", 1126, 37421, 37573);
                CallChecker.varInit(this.next, "next", 1126, 37421, 37573);
                if (CallChecker.beforeDeref(new StringBuilder(), StringBuilder.class, 1127, 37485, 37503)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 1127, 37485, 37503).append(getKey()), StringBuilder.class, 1127, 37485, 37520)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 1127, 37485, 37503).append(getKey()), StringBuilder.class, 1127, 37485, 37520).append('='), StringBuilder.class, 1127, 37485, 37532)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 1127, 37485, 37503).append(getKey()), StringBuilder.class, 1127, 37485, 37520).append('='), StringBuilder.class, 1127, 37485, 37532).append(getValue()), StringBuilder.class, 1127, 37485, 37551)) {
                                return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 1127, 37485, 37503).append(getKey()), StringBuilder.class, 1127, 37485, 37520).append('='), StringBuilder.class, 1127, 37485, 37532).append(getValue()), StringBuilder.class, 1127, 37485, 37551).toString();
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
                _bcornu_methode_context441.methodEnd();
            }
        }
    }

    protected abstract static class HashIterator<K, V> {
        protected final AbstractHashedMap<K, V> parent;

        protected int hashIndex;

        protected AbstractHashedMap.HashEntry<K, V> last;

        protected AbstractHashedMap.HashEntry<K, V> next;

        protected int expectedModCount;

        protected HashIterator(AbstractHashedMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context72 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 1149, 38190, 38210);
                AbstractHashedMap.HashEntry<K, V>[] data = CallChecker.init(AbstractHashedMap.HashEntry[].class);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1150, 38249, 38254)) {
                    parent = CallChecker.beforeCalled(parent, AbstractHashedMap.class, 1150, 38249, 38254);
                    data = CallChecker.isCalled(parent, AbstractHashedMap.class, 1150, 38249, 38254).data;
                    CallChecker.varAssign(data, "data", 1150, 38249, 38254);
                }
                int i = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 1151, 38282, 38285)) {
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 1151, 38282, 38285);
                    i = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 1151, 38282, 38285).length;
                    CallChecker.varAssign(i, "i", 1151, 38282, 38285);
                }
                AbstractHashedMap.HashEntry<K, V> next = CallChecker.varInit(null, "next", 1152, 38307, 38334);
                while ((i > 0) && (next == null)) {
                    if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 1154, 38403, 38406)) {
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 1154, 38403, 38406);
                        next = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 1154, 38403, 38406)[(--i)];
                        CallChecker.varAssign(next, "next", 1154, 38396, 38412);
                    }
                } 
                this.next = next;
                CallChecker.varAssign(this.next, "this.next", 1156, 38440, 38456);
                this.hashIndex = i;
                CallChecker.varAssign(this.hashIndex, "this.hashIndex", 1157, 38470, 38488);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1158, 38526, 38531)) {
                    parent = CallChecker.beforeCalled(parent, AbstractHashedMap.class, 1158, 38526, 38531);
                    this.expectedModCount = CallChecker.isCalled(parent, AbstractHashedMap.class, 1158, 38526, 38531).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 1158, 38502, 38541);
                }
            } finally {
                _bcornu_methode_context72.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context442 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1161, 38562, 38632);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1161, 38562, 38632);
                CallChecker.varInit(this.next, "next", 1161, 38562, 38632);
                CallChecker.varInit(this.last, "last", 1161, 38562, 38632);
                CallChecker.varInit(this.hashIndex, "hashIndex", 1161, 38562, 38632);
                CallChecker.varInit(this.parent, "parent", 1161, 38562, 38632);
                return (next) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context442.methodEnd();
            }
        }

        protected AbstractHashedMap.HashEntry<K, V> nextEntry() {
            MethodContext _bcornu_methode_context443 = new MethodContext(AbstractHashedMap.HashEntry.class);
            try {
                CallChecker.varInit(this, "this", 1165, 38643, 39331);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1165, 38643, 39331);
                CallChecker.varInit(this.next, "next", 1165, 38643, 39331);
                CallChecker.varInit(this.last, "last", 1165, 38643, 39331);
                CallChecker.varInit(this.hashIndex, "hashIndex", 1165, 38643, 39331);
                CallChecker.varInit(this.parent, "parent", 1165, 38643, 39331);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1166, 38699, 38704)) {
                    if ((CallChecker.isCalled(parent, AbstractHashedMap.class, 1166, 38699, 38704).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                AbstractHashedMap.HashEntry<K, V> newCurrent = CallChecker.varInit(next, "newCurrent", 1169, 38825, 38858);
                if (newCurrent == null) {
                    throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
                }
                AbstractHashedMap.HashEntry<K, V>[] data = CallChecker.init(AbstractHashedMap.HashEntry[].class);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1173, 39033, 39038)) {
                    data = CallChecker.isCalled(parent, AbstractHashedMap.class, 1173, 39033, 39038).data;
                    CallChecker.varAssign(data, "data", 1173, 39033, 39038);
                }
                int i = CallChecker.varInit(((int) (this.hashIndex)), "i", 1174, 39058, 39075);
                AbstractHashedMap.HashEntry<K, V> n = CallChecker.varInit(newCurrent.next, "n", 1175, 39089, 39124);
                while ((n == null) && (i > 0)) {
                    if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 1177, 39187, 39190)) {
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 1177, 39187, 39190);
                        n = CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 1177, 39187, 39190)[(--i)];
                        CallChecker.varAssign(n, "n", 1177, 39183, 39196);
                    }
                } 
                next = n;
                CallChecker.varAssign(this.next, "this.next", 1179, 39224, 39232);
                hashIndex = i;
                CallChecker.varAssign(this.hashIndex, "this.hashIndex", 1180, 39246, 39259);
                last = newCurrent;
                CallChecker.varAssign(this.last, "this.last", 1181, 39273, 39290);
                return newCurrent;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractHashedMap.HashEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context443.methodEnd();
            }
        }

        protected AbstractHashedMap.HashEntry<K, V> currentEntry() {
            MethodContext _bcornu_methode_context444 = new MethodContext(AbstractHashedMap.HashEntry.class);
            try {
                CallChecker.varInit(this, "this", 1185, 39342, 39418);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1185, 39342, 39418);
                CallChecker.varInit(this.next, "next", 1185, 39342, 39418);
                CallChecker.varInit(this.last, "last", 1185, 39342, 39418);
                CallChecker.varInit(this.hashIndex, "hashIndex", 1185, 39342, 39418);
                CallChecker.varInit(this.parent, "parent", 1185, 39342, 39418);
                return last;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractHashedMap.HashEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context444.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context445 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1189, 39429, 39834);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1189, 39429, 39834);
                CallChecker.varInit(this.next, "next", 1189, 39429, 39834);
                CallChecker.varInit(this.last, "last", 1189, 39429, 39834);
                CallChecker.varInit(this.hashIndex, "hashIndex", 1189, 39429, 39834);
                CallChecker.varInit(this.parent, "parent", 1189, 39429, 39834);
                if ((last) == null) {
                    throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
                }
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1193, 39597, 39602)) {
                    if ((CallChecker.isCalled(parent, AbstractHashedMap.class, 1193, 39597, 39602).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1196, 39723, 39728)) {
                    parent.remove(last.getKey());
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 1197, 39765, 39776);
                if (CallChecker.beforeDeref(parent, AbstractHashedMap.class, 1198, 39809, 39814)) {
                    expectedModCount = CallChecker.isCalled(parent, AbstractHashedMap.class, 1198, 39809, 39814).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 1198, 39790, 39824);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context445.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context446 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 1202, 39845, 40059);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1202, 39845, 40059);
                CallChecker.varInit(this.next, "next", 1202, 39845, 40059);
                CallChecker.varInit(this.last, "last", 1202, 39845, 40059);
                CallChecker.varInit(this.hashIndex, "hashIndex", 1202, 39845, 40059);
                CallChecker.varInit(this.parent, "parent", 1202, 39845, 40059);
                if ((last) != null) {
                    return ((("Iterator[" + (last.getKey())) + "=") + (last.getValue())) + "]";
                }
                return "Iterator[]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context446.methodEnd();
            }
        }
    }

    protected void doWriteObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context447 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1230, 40072, 41444);
            CallChecker.varInit(out, "out", 1230, 40072, 41444);
            CallChecker.varInit(this.values, "values", 1230, 40072, 41444);
            CallChecker.varInit(this.keySet, "keySet", 1230, 40072, 41444);
            CallChecker.varInit(this.entrySet, "entrySet", 1230, 40072, 41444);
            CallChecker.varInit(this.modCount, "modCount", 1230, 40072, 41444);
            CallChecker.varInit(this.threshold, "threshold", 1230, 40072, 41444);
            CallChecker.varInit(this.data, "data", 1230, 40072, 41444);
            CallChecker.varInit(this.size, "size", 1230, 40072, 41444);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1230, 40072, 41444);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1230, 40072, 41444);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1230, 40072, 41444);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1230, 40072, 41444);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1230, 40072, 41444);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1230, 40072, 41444);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1230, 40072, 41444);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1230, 40072, 41444);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1230, 40072, 41444);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1230, 40072, 41444);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1230, 40072, 41444);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1230, 40072, 41444);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1231, 41187, 41189)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1231, 41187, 41189);
                CallChecker.isCalled(out, ObjectOutputStream.class, 1231, 41187, 41189).writeFloat(loadFactor);
            }
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 1232, 41236, 41239)) {
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1232, 41223, 41225)) {
                    data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 1232, 41236, 41239);
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1232, 41223, 41225);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 1232, 41223, 41225).writeInt(CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 1232, 41236, 41239).length);
                }
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1233, 41258, 41260)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1233, 41258, 41260);
                CallChecker.isCalled(out, ObjectOutputStream.class, 1233, 41258, 41260).writeInt(size);
            }
            for (MapIterator<K, V> it = mapIterator(); CallChecker.isCalled(it, MapIterator.class, 1234, 41329, 41330).hasNext();) {
                if (CallChecker.beforeDeref(it, MapIterator.class, 1235, 41374, 41375)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1235, 41358, 41360)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1235, 41358, 41360);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 1235, 41358, 41360).writeObject(it.next());
                    }
                }
                if (CallChecker.beforeDeref(it, MapIterator.class, 1236, 41414, 41415)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1236, 41398, 41400)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1236, 41398, 41400);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 1236, 41398, 41400).writeObject(it.getValue());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context447.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected void doReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context448 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1259, 41451, 42893);
            CallChecker.varInit(in, "in", 1259, 41451, 42893);
            CallChecker.varInit(this.values, "values", 1259, 41451, 42893);
            CallChecker.varInit(this.keySet, "keySet", 1259, 41451, 42893);
            CallChecker.varInit(this.entrySet, "entrySet", 1259, 41451, 42893);
            CallChecker.varInit(this.modCount, "modCount", 1259, 41451, 42893);
            CallChecker.varInit(this.threshold, "threshold", 1259, 41451, 42893);
            CallChecker.varInit(this.data, "data", 1259, 41451, 42893);
            CallChecker.varInit(this.size, "size", 1259, 41451, 42893);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1259, 41451, 42893);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1259, 41451, 42893);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1259, 41451, 42893);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1259, 41451, 42893);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1259, 41451, 42893);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1259, 41451, 42893);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1259, 41451, 42893);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1259, 41451, 42893);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1259, 41451, 42893);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1259, 41451, 42893);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1259, 41451, 42893);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1259, 41451, 42893);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1260, 42521, 42522)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1260, 42521, 42522);
                loadFactor = CallChecker.isCalled(in, ObjectInputStream.class, 1260, 42521, 42522).readFloat();
                CallChecker.varAssign(this.loadFactor, "this.loadFactor", 1260, 42508, 42535);
            }
            int capacity = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1261, 42560, 42561)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1261, 42560, 42561);
                capacity = CallChecker.isCalled(in, ObjectInputStream.class, 1261, 42560, 42561).readInt();
                CallChecker.varAssign(capacity, "capacity", 1261, 42560, 42561);
            }
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1262, 42593, 42594)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1262, 42593, 42594);
                size = CallChecker.isCalled(in, ObjectInputStream.class, 1262, 42593, 42594).readInt();
                CallChecker.varAssign(size, "size", 1262, 42593, 42594);
            }
            init();
            threshold = calculateThreshold(capacity, loadFactor);
            CallChecker.varAssign(this.threshold, "this.threshold", 1264, 42631, 42683);
            data = new AbstractHashedMap.HashEntry[capacity];
            CallChecker.varAssign(this.data, "this.data", 1265, 42693, 42723);
            for (int i = 0; i < size; i++) {
                K key = CallChecker.init(null);
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1267, 42790, 42791)) {
                    in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1267, 42790, 42791);
                    key = ((K) (CallChecker.isCalled(in, ObjectInputStream.class, 1267, 42790, 42791).readObject()));
                    CallChecker.varAssign(key, "key", 1267, 42790, 42791);
                }
                V value = CallChecker.init(null);
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1268, 42833, 42834)) {
                    in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1268, 42833, 42834);
                    value = ((V) (CallChecker.isCalled(in, ObjectInputStream.class, 1268, 42833, 42834).readObject()));
                    CallChecker.varAssign(value, "value", 1268, 42833, 42834);
                }
                put(key, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context448.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    protected AbstractHashedMap<K, V> clone() {
        MethodContext _bcornu_methode_context449 = new MethodContext(AbstractHashedMap.class);
        try {
            CallChecker.varInit(this, "this", 1284, 42900, 43855);
            CallChecker.varInit(this.values, "values", 1284, 42900, 43855);
            CallChecker.varInit(this.keySet, "keySet", 1284, 42900, 43855);
            CallChecker.varInit(this.entrySet, "entrySet", 1284, 42900, 43855);
            CallChecker.varInit(this.modCount, "modCount", 1284, 42900, 43855);
            CallChecker.varInit(this.threshold, "threshold", 1284, 42900, 43855);
            CallChecker.varInit(this.data, "data", 1284, 42900, 43855);
            CallChecker.varInit(this.size, "size", 1284, 42900, 43855);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1284, 42900, 43855);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1284, 42900, 43855);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1284, 42900, 43855);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1284, 42900, 43855);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1284, 42900, 43855);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1284, 42900, 43855);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1284, 42900, 43855);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1284, 42900, 43855);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1284, 42900, 43855);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1284, 42900, 43855);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1284, 42900, 43855);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1284, 42900, 43855);
            TryContext _bcornu_try_context_4 = new TryContext(4, AbstractHashedMap.class, "java.lang.CloneNotSupportedException");
            try {
                AbstractHashedMap<K, V> cloned = CallChecker.varInit(((AbstractHashedMap<K, V>) (super.clone())), "cloned", 1286, 43361, 43433);
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1287, 43447, 43452)) {
                    if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 1287, 43475, 43478)) {
                        cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1287, 43447, 43452);
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 1287, 43475, 43478);
                        CallChecker.isCalled(cloned, AbstractHashedMap.class, 1287, 43447, 43452).data = new AbstractHashedMap.HashEntry[CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 1287, 43475, 43478).length];
                        CallChecker.varAssign(CallChecker.isCalled(cloned, AbstractHashedMap.class, 1287, 43447, 43452).data, "CallChecker.isCalled(cloned, AbstractHashedMap.class, 1287, 43447, 43452).data", 1287, 43447, 43487);
                    }
                }
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1288, 43501, 43506)) {
                    cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1288, 43501, 43506);
                    CallChecker.isCalled(cloned, AbstractHashedMap.class, 1288, 43501, 43506).entrySet = null;
                    CallChecker.varAssign(CallChecker.isCalled(cloned, AbstractHashedMap.class, 1288, 43501, 43506).entrySet, "CallChecker.isCalled(cloned, AbstractHashedMap.class, 1288, 43501, 43506).entrySet", 1288, 43501, 43523);
                }
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1289, 43537, 43542)) {
                    cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1289, 43537, 43542);
                    CallChecker.isCalled(cloned, AbstractHashedMap.class, 1289, 43537, 43542).keySet = null;
                    CallChecker.varAssign(CallChecker.isCalled(cloned, AbstractHashedMap.class, 1289, 43537, 43542).keySet, "CallChecker.isCalled(cloned, AbstractHashedMap.class, 1289, 43537, 43542).keySet", 1289, 43537, 43557);
                }
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1290, 43571, 43576)) {
                    cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1290, 43571, 43576);
                    CallChecker.isCalled(cloned, AbstractHashedMap.class, 1290, 43571, 43576).values = null;
                    CallChecker.varAssign(CallChecker.isCalled(cloned, AbstractHashedMap.class, 1290, 43571, 43576).values, "CallChecker.isCalled(cloned, AbstractHashedMap.class, 1290, 43571, 43576).values", 1290, 43571, 43591);
                }
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1291, 43605, 43610)) {
                    cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1291, 43605, 43610);
                    CallChecker.isCalled(cloned, AbstractHashedMap.class, 1291, 43605, 43610).modCount = 0;
                    CallChecker.varAssign(CallChecker.isCalled(cloned, AbstractHashedMap.class, 1291, 43605, 43610).modCount, "CallChecker.isCalled(cloned, AbstractHashedMap.class, 1291, 43605, 43610).modCount", 1291, 43605, 43624);
                }
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1292, 43638, 43643)) {
                    cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1292, 43638, 43643);
                    CallChecker.isCalled(cloned, AbstractHashedMap.class, 1292, 43638, 43643).size = 0;
                    CallChecker.varAssign(CallChecker.isCalled(cloned, AbstractHashedMap.class, 1292, 43638, 43643).size, "CallChecker.isCalled(cloned, AbstractHashedMap.class, 1292, 43638, 43643).size", 1292, 43638, 43653);
                }
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1293, 43667, 43672)) {
                    cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1293, 43667, 43672);
                    CallChecker.isCalled(cloned, AbstractHashedMap.class, 1293, 43667, 43672).init();
                }
                if (CallChecker.beforeDeref(cloned, AbstractHashedMap.class, 1294, 43694, 43699)) {
                    cloned = CallChecker.beforeCalled(cloned, AbstractHashedMap.class, 1294, 43694, 43699);
                    CallChecker.isCalled(cloned, AbstractHashedMap.class, 1294, 43694, 43699).putAll(this);
                }
                return cloned;
            } catch (CloneNotSupportedException ex) {
                _bcornu_try_context_4.catchStart(4);
                return null;
            } finally {
                _bcornu_try_context_4.finallyStart(4);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractHashedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context449.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context450 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1308, 43862, 45022);
            CallChecker.varInit(obj, "obj", 1308, 43862, 45022);
            CallChecker.varInit(this.values, "values", 1308, 43862, 45022);
            CallChecker.varInit(this.keySet, "keySet", 1308, 43862, 45022);
            CallChecker.varInit(this.entrySet, "entrySet", 1308, 43862, 45022);
            CallChecker.varInit(this.modCount, "modCount", 1308, 43862, 45022);
            CallChecker.varInit(this.threshold, "threshold", 1308, 43862, 45022);
            CallChecker.varInit(this.data, "data", 1308, 43862, 45022);
            CallChecker.varInit(this.size, "size", 1308, 43862, 45022);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1308, 43862, 45022);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1308, 43862, 45022);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1308, 43862, 45022);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1308, 43862, 45022);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1308, 43862, 45022);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1308, 43862, 45022);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1308, 43862, 45022);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1308, 43862, 45022);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1308, 43862, 45022);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1308, 43862, 45022);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1308, 43862, 45022);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1308, 43862, 45022);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof Map) == false) {
                return false;
            }
            Map<?, ?> map = CallChecker.varInit(((Map<?, ?>) (obj)), "map", 1315, 44196, 44225);
            if (CallChecker.beforeDeref(map, Map.class, 1316, 44239, 44241)) {
                map = CallChecker.beforeCalled(map, Map.class, 1316, 44239, 44241);
                if ((CallChecker.isCalled(map, Map.class, 1316, 44239, 44241).size()) != (size())) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            MapIterator<?, ?> it = CallChecker.varInit(mapIterator(), "it", 1319, 44307, 44342);
            TryContext _bcornu_try_context_5 = new TryContext(5, AbstractHashedMap.class, "java.lang.ClassCastException", "java.lang.NullPointerException");
            try {
                it = CallChecker.beforeCalled(it, MapIterator.class, 1321, 44377, 44378);
                while (CallChecker.isCalled(it, MapIterator.class, 1321, 44377, 44378).hasNext()) {
                    Object key = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(it, MapIterator.class, 1322, 44422, 44423)) {
                        key = it.next();
                        CallChecker.varAssign(key, "key", 1322, 44422, 44423);
                    }
                    Object value = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(it, MapIterator.class, 1323, 44464, 44465)) {
                        value = it.getValue();
                        CallChecker.varAssign(value, "value", 1323, 44464, 44465);
                    }
                    if (value == null) {
                        if (CallChecker.beforeDeref(map, Map.class, 1325, 44540, 44542)) {
                            if (CallChecker.beforeDeref(map, Map.class, 1325, 44564, 44566)) {
                                map = CallChecker.beforeCalled(map, Map.class, 1325, 44564, 44566);
                                if (((map.get(key)) != null) || ((CallChecker.isCalled(map, Map.class, 1325, 44564, 44566).containsKey(key)) == false)) {
                                    return false;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        if (CallChecker.beforeDeref(map, Map.class, 1329, 44719, 44721)) {
                            if ((value.equals(map.get(key))) == false) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                } 
            } catch (ClassCastException ignored) {
                _bcornu_try_context_5.catchStart(5);
                return false;
            } catch (NullPointerException ignored) {
                _bcornu_try_context_5.catchStart(5);
                return false;
            } finally {
                _bcornu_try_context_5.finallyStart(5);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context450.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context451 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1348, 45029, 45385);
            CallChecker.varInit(this.values, "values", 1348, 45029, 45385);
            CallChecker.varInit(this.keySet, "keySet", 1348, 45029, 45385);
            CallChecker.varInit(this.entrySet, "entrySet", 1348, 45029, 45385);
            CallChecker.varInit(this.modCount, "modCount", 1348, 45029, 45385);
            CallChecker.varInit(this.threshold, "threshold", 1348, 45029, 45385);
            CallChecker.varInit(this.data, "data", 1348, 45029, 45385);
            CallChecker.varInit(this.size, "size", 1348, 45029, 45385);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1348, 45029, 45385);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1348, 45029, 45385);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1348, 45029, 45385);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1348, 45029, 45385);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1348, 45029, 45385);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1348, 45029, 45385);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1348, 45029, 45385);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1348, 45029, 45385);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1348, 45029, 45385);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1348, 45029, 45385);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1348, 45029, 45385);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1348, 45029, 45385);
            int total = CallChecker.varInit(((int) (0)), "total", 1349, 45195, 45208);
            Iterator<Map.Entry<K, V>> it = CallChecker.varInit(createEntrySetIterator(), "it", 1350, 45218, 45273);
            it = CallChecker.beforeCalled(it, Iterator.class, 1351, 45290, 45291);
            while (CallChecker.isCalled(it, Iterator.class, 1351, 45290, 45291).hasNext()) {
                if (CallChecker.beforeDeref(it, Iterator.class, 1352, 45327, 45328)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 1352, 45327, 45328);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(it, Iterator.class, 1352, 45327, 45328).next(), Map.Entry.class, 1352, 45327, 45335)) {
                        it = CallChecker.beforeCalled(it, Iterator.class, 1352, 45327, 45328);
                        total += CallChecker.isCalled(CallChecker.isCalled(it, Iterator.class, 1352, 45327, 45328).next(), Map.Entry.class, 1352, 45327, 45335).hashCode();
                        CallChecker.varAssign(total, "total", 1352, 45318, 45347);
                    }
                }
            } 
            return total;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context451.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context452 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1363, 45392, 46201);
            CallChecker.varInit(this.values, "values", 1363, 45392, 46201);
            CallChecker.varInit(this.keySet, "keySet", 1363, 45392, 46201);
            CallChecker.varInit(this.entrySet, "entrySet", 1363, 45392, 46201);
            CallChecker.varInit(this.modCount, "modCount", 1363, 45392, 46201);
            CallChecker.varInit(this.threshold, "threshold", 1363, 45392, 46201);
            CallChecker.varInit(this.data, "data", 1363, 45392, 46201);
            CallChecker.varInit(this.size, "size", 1363, 45392, 46201);
            CallChecker.varInit(this.loadFactor, "loadFactor", 1363, 45392, 46201);
            CallChecker.varInit(NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 1363, 45392, 46201);
            CallChecker.varInit(MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 1363, 45392, 46201);
            CallChecker.varInit(DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 1363, 45392, 46201);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 1363, 45392, 46201);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 1363, 45392, 46201);
            CallChecker.varInit(SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 1363, 45392, 46201);
            CallChecker.varInit(GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 1363, 45392, 46201);
            CallChecker.varInit(GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 1363, 45392, 46201);
            CallChecker.varInit(REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 1363, 45392, 46201);
            CallChecker.varInit(NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 1363, 45392, 46201);
            CallChecker.varInit(NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 1363, 45392, 46201);
            if ((size()) == 0) {
                return "{}";
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder((32 * (size()))), "buf", 1367, 45602, 45652);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1368, 45662, 45664)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1368, 45662, 45664);
                CallChecker.isCalled(buf, StringBuilder.class, 1368, 45662, 45664).append('{');
            }
            MapIterator<K, V> it = CallChecker.varInit(mapIterator(), "it", 1370, 45688, 45724);
            boolean hasNext = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(it, MapIterator.class, 1371, 45752, 45753)) {
                it = CallChecker.beforeCalled(it, MapIterator.class, 1371, 45752, 45753);
                hasNext = CallChecker.isCalled(it, MapIterator.class, 1371, 45752, 45753).hasNext();
                CallChecker.varAssign(hasNext, "hasNext", 1371, 45752, 45753);
            }
            while (hasNext) {
                K key = CallChecker.init(null);
                if (CallChecker.beforeDeref(it, MapIterator.class, 1373, 45812, 45813)) {
                    key = it.next();
                    CallChecker.varAssign(key, "key", 1373, 45812, 45813);
                }
                V value = CallChecker.init(null);
                if (CallChecker.beforeDeref(it, MapIterator.class, 1374, 45845, 45846)) {
                    value = it.getValue();
                    CallChecker.varAssign(value, "value", 1374, 45845, 45846);
                }
                if (value == (this)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1375, 45872, 45874)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1375, 45872, 45874);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 1375, 45872, 45874).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1375, 45872, 45915)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1375, 45872, 45874);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1375, 45872, 45874).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1375, 45872, 45915).append('='), StringBuilder.class, 1375, 45872, 45943)) {
                                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1375, 45872, 45874);
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1375, 45872, 45874).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1375, 45872, 45915).append('='), StringBuilder.class, 1375, 45872, 45943).append("(this Map)");
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1375, 45872, 45874)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1375, 45872, 45874);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 1375, 45872, 45874).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1375, 45872, 45915)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1375, 45872, 45874);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1375, 45872, 45874).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1375, 45872, 45915).append('='), StringBuilder.class, 1375, 45872, 45943)) {
                                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1375, 45872, 45874);
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1375, 45872, 45874).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1375, 45872, 45915).append('='), StringBuilder.class, 1375, 45872, 45943).append(value);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(it, MapIterator.class, 1379, 46030, 46031)) {
                    it = CallChecker.beforeCalled(it, MapIterator.class, 1379, 46030, 46031);
                    hasNext = CallChecker.isCalled(it, MapIterator.class, 1379, 46030, 46031).hasNext();
                    CallChecker.varAssign(hasNext, "hasNext", 1379, 46020, 46042);
                }
                if (hasNext) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1381, 46087, 46089)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1381, 46087, 46089);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 1381, 46087, 46089).append(','), StringBuilder.class, 1381, 46087, 46101)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1381, 46087, 46089);
                            CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1381, 46087, 46089).append(','), StringBuilder.class, 1381, 46087, 46101).append(' ');
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1385, 46149, 46151)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1385, 46149, 46151);
                CallChecker.isCalled(buf, StringBuilder.class, 1385, 46149, 46151).append('}');
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1386, 46181, 46183)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1386, 46181, 46183);
                return CallChecker.isCalled(buf, StringBuilder.class, 1386, 46181, 46183).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context452.methodEnd();
        }
    }
}

