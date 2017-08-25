package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.iterators.SingletonIterator;
import java.util.Set;
import java.io.Serializable;
import org.apache.commons.collections.ResettableIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collections;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.BoundedMap;
import java.util.AbstractSet;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import org.apache.commons.collections.KeyValue;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;

public class SingletonMap<K, V> implements Serializable , Cloneable , BoundedMap<K, V> , KeyValue<K, V> , OrderedMap<K, V> {
    private static final long serialVersionUID = -8931271118676803261L;

    private final K key;

    private V value;

    public SingletonMap() {
        super();
        MethodContext _bcornu_methode_context128 = new MethodContext(null);
        try {
            this.key = null;
            CallChecker.varAssign(this.key, "this.key", 77, 2985, 3000);
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public SingletonMap(K key, V value) {
        super();
        MethodContext _bcornu_methode_context129 = new MethodContext(null);
        try {
            this.key = key;
            CallChecker.varAssign(this.key, "this.key", 88, 3220, 3234);
            this.value = value;
            CallChecker.varAssign(this.value, "this.value", 89, 3244, 3262);
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public SingletonMap(KeyValue<K, V> keyValue) {
        super();
        MethodContext _bcornu_methode_context130 = new MethodContext(null);
        try {
            this.key = keyValue.getKey();
            CallChecker.varAssign(this.key, "this.key", 99, 3496, 3524);
            if (CallChecker.beforeDeref(keyValue, KeyValue.class, 100, 3547, 3554)) {
                this.value = keyValue.getValue();
                CallChecker.varAssign(this.value, "this.value", 100, 3534, 3566);
            }
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    public SingletonMap(Map.Entry<K, V> mapEntry) {
        super();
        MethodContext _bcornu_methode_context131 = new MethodContext(null);
        try {
            this.key = mapEntry.getKey();
            CallChecker.varAssign(this.key, "this.key", 110, 3795, 3823);
            if (CallChecker.beforeDeref(mapEntry, Map.Entry.class, 111, 3846, 3853)) {
                this.value = mapEntry.getValue();
                CallChecker.varAssign(this.value, "this.value", 111, 3833, 3865);
            }
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }

    public SingletonMap(Map<K, V> map) {
        super();
        MethodContext _bcornu_methode_context132 = new MethodContext(null);
        try {
            if (CallChecker.beforeDeref(map, Map.class, 123, 4188, 4190)) {
                map = CallChecker.beforeCalled(map, Map.class, 123, 4188, 4190);
                if ((CallChecker.isCalled(map, Map.class, 123, 4188, 4190).size()) != 1) {
                    throw new IllegalArgumentException("The map size must be 1");
                }
            }else
                throw new AbnormalExecutionError();
            
            Map.Entry<K, V> entry = CallChecker.init(Map.Entry.class);
            if (CallChecker.beforeDeref(map, Map.class, 126, 4323, 4325)) {
                map = CallChecker.beforeCalled(map, Map.class, 126, 4323, 4325);
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 126, 4323, 4325).entrySet(), Set.class, 126, 4323, 4336)) {
                    map = CallChecker.beforeCalled(map, Map.class, 126, 4323, 4325);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 126, 4323, 4325).entrySet(), Set.class, 126, 4323, 4336).iterator(), Iterator.class, 126, 4323, 4347)) {
                        map = CallChecker.beforeCalled(map, Map.class, 126, 4323, 4325);
                        entry = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 126, 4323, 4325).entrySet(), Set.class, 126, 4323, 4336).iterator(), Iterator.class, 126, 4323, 4347).next();
                        CallChecker.varAssign(entry, "entry", 126, 4323, 4325);
                    }
                }
            }
            this.key = entry.getKey();
            CallChecker.varAssign(this.key, "this.key", 127, 4365, 4390);
            if (CallChecker.beforeDeref(entry, Map.Entry.class, 128, 4413, 4417)) {
                this.value = entry.getValue();
                CallChecker.varAssign(this.value, "this.value", 128, 4400, 4429);
            }
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V old = CallChecker.varInit(this.value, "old", 158, 4935, 4953);
        this.value = value;
        CallChecker.varAssign(this.value, "this.value", 159, 4963, 4981);
        return old;
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context707 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 170, 5014, 5258);
            CallChecker.varInit(this.value, "value", 170, 5014, 5258);
            CallChecker.varInit(this.key, "key", 170, 5014, 5258);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 170, 5014, 5258);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context707.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context708 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 179, 5265, 5409);
            CallChecker.varInit(this.value, "value", 179, 5265, 5409);
            CallChecker.varInit(this.key, "key", 179, 5265, 5409);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 179, 5265, 5409);
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context708.methodEnd();
        }
    }

    public V get(Object key) {
        if (isEqualKey(key)) {
            return value;
        }
        return null;
    }

    public int size() {
        MethodContext _bcornu_methode_context710 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 203, 5783, 5921);
            CallChecker.varInit(this.value, "value", 203, 5783, 5921);
            CallChecker.varInit(this.key, "key", 203, 5783, 5921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 203, 5783, 5921);
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context710.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context711 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 212, 5928, 6102);
            CallChecker.varInit(this.value, "value", 212, 5928, 6102);
            CallChecker.varInit(this.key, "key", 212, 5928, 6102);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 212, 5928, 6102);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context711.methodEnd();
        }
    }

    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context712 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 223, 6109, 6437);
            CallChecker.varInit(key, "key", 223, 6109, 6437);
            CallChecker.varInit(this.value, "value", 223, 6109, 6437);
            CallChecker.varInit(this.key, "key", 223, 6109, 6437);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 223, 6109, 6437);
            return isEqualKey(key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context712.methodEnd();
        }
    }

    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context713 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 233, 6444, 6708);
            CallChecker.varInit(value, "value", 233, 6444, 6708);
            CallChecker.varInit(this.value, "value", 233, 6444, 6708);
            CallChecker.varInit(this.key, "key", 233, 6444, 6708);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 233, 6444, 6708);
            return isEqualValue(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context713.methodEnd();
        }
    }

    public V put(K key, V value) {
        if (isEqualKey(key)) {
            return setValue(value);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context715 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 267, 7482, 8384);
            CallChecker.varInit(map, "map", 267, 7482, 8384);
            CallChecker.varInit(this.value, "value", 267, 7482, 8384);
            CallChecker.varInit(this.key, "key", 267, 7482, 8384);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 267, 7482, 8384);
            if (CallChecker.beforeDeref(map, Map.class, 268, 8013, 8015)) {
                map = CallChecker.beforeCalled(map, Map.class, 268, 8013, 8015);
                switch (CallChecker.isCalled(map, Map.class, 268, 8013, 8015).size()) {
                    case 0 :
                        return ;
                    case 1 :
                        Map.Entry<? extends K, ? extends V> entry = CallChecker.init(Map.Entry.class);
                        if (CallChecker.beforeDeref(map, Map.class, 273, 8152, 8154)) {
                            map = CallChecker.beforeCalled(map, Map.class, 273, 8152, 8154);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 273, 8152, 8154).entrySet(), Set.class, 273, 8152, 8165)) {
                                map = CallChecker.beforeCalled(map, Map.class, 273, 8152, 8154);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 273, 8152, 8154).entrySet(), Set.class, 273, 8152, 8165).iterator(), Iterator.class, 273, 8152, 8176)) {
                                    map = CallChecker.beforeCalled(map, Map.class, 273, 8152, 8154);
                                    entry = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 273, 8152, 8154).entrySet(), Set.class, 273, 8152, 8165).iterator(), Iterator.class, 273, 8152, 8176).next();
                                    CallChecker.varAssign(entry, "entry", 273, 8152, 8154);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 274, 8206, 8210)) {
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 274, 8222, 8226)) {
                                put(entry.getKey(), entry.getValue());
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        return ;
                    default :
                        throw new IllegalArgumentException("The map size must be 0 or 1");
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context715.methodEnd();
        }
    }

    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        MethodContext _bcornu_methode_context717 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 296, 8709, 8832);
            CallChecker.varInit(this.value, "value", 296, 8709, 8832);
            CallChecker.varInit(this.key, "key", 296, 8709, 8832);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 296, 8709, 8832);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context717.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context718 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 308, 8839, 9315);
            CallChecker.varInit(this.value, "value", 308, 8839, 9315);
            CallChecker.varInit(this.key, "key", 308, 8839, 9315);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 308, 8839, 9315);
            Map.Entry<K, V> entry = CallChecker.varInit(new TiedMapEntry<K, V>(this, getKey()), "entry", 309, 9202, 9264);
            return Collections.singleton(entry);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context718.methodEnd();
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context719 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 320, 9326, 9626);
            CallChecker.varInit(this.value, "value", 320, 9326, 9626);
            CallChecker.varInit(this.key, "key", 320, 9326, 9626);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 320, 9326, 9626);
            return Collections.singleton(key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context719.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context720 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 331, 9633, 9944);
            CallChecker.varInit(this.value, "value", 331, 9633, 9944);
            CallChecker.varInit(this.key, "key", 331, 9633, 9944);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 331, 9633, 9944);
            return new SingletonMap.SingletonValues<V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context720.methodEnd();
        }
    }

    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context721 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 338, 9951, 10093);
            CallChecker.varInit(this.value, "value", 338, 9951, 10093);
            CallChecker.varInit(this.key, "key", 338, 9951, 10093);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 338, 9951, 10093);
            return new SingletonMap.SingletonMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context721.methodEnd();
        }
    }

    public K firstKey() {
        return getKey();
    }

    public K lastKey() {
        return getKey();
    }

    public K nextKey(K key) {
        return null;
    }

    public K previousKey(K key) {
        return null;
    }

    protected boolean isEqualKey(Object key) {
        MethodContext _bcornu_methode_context726 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 387, 10823, 11164);
            CallChecker.varInit(key, "key", 387, 10823, 11164);
            CallChecker.varInit(this.value, "value", 387, 10823, 11164);
            CallChecker.varInit(this.key, "key", 387, 10823, 11164);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 387, 10823, 11164);
            if (key == null) {
                return (getKey()) == null;
            }else {
                return key.equals(getKey());
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context726.methodEnd();
        }
    }

    protected boolean isEqualValue(Object value) {
        MethodContext _bcornu_methode_context727 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 397, 11171, 11454);
            CallChecker.varInit(value, "value", 397, 11171, 11454);
            CallChecker.varInit(this.value, "value", 397, 11171, 11454);
            CallChecker.varInit(this.key, "key", 397, 11171, 11454);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 397, 11171, 11454);
            if (value == null) {
                return (getValue()) == null;
            }else {
                return value.equals(getValue());
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context727.methodEnd();
        }
    }

    static class SingletonMapIterator<K, V> implements OrderedMapIterator<K, V> , ResettableIterator<K> {
        private final SingletonMap<K, V> parent;

        private boolean hasNext = true;

        private boolean canGetSet = false;

        SingletonMapIterator(SingletonMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context133 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 412, 11917, 11937);
            } finally {
                _bcornu_methode_context133.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context728 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 415, 11958, 12021);
                CallChecker.varInit(this.canGetSet, "canGetSet", 415, 11958, 12021);
                CallChecker.varInit(this.hasNext, "hasNext", 415, 11958, 12021);
                CallChecker.varInit(this.parent, "parent", 415, 11958, 12021);
                return hasNext;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context728.methodEnd();
            }
        }

        public K next() {
            if ((hasNext) == false) {
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            hasNext = false;
            CallChecker.varAssign(this.hasNext, "this.hasNext", 423, 12195, 12210);
            canGetSet = true;
            CallChecker.varAssign(this.canGetSet, "this.canGetSet", 424, 12224, 12240);
            if (CallChecker.beforeDeref(parent, SingletonMap.class, 425, 12261, 12266)) {
                return parent.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context730 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 428, 12297, 12375);
                CallChecker.varInit(this.canGetSet, "canGetSet", 428, 12297, 12375);
                CallChecker.varInit(this.hasNext, "hasNext", 428, 12297, 12375);
                CallChecker.varInit(this.parent, "parent", 428, 12297, 12375);
                return (hasNext) == false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context730.methodEnd();
            }
        }

        public K previous() {
            if ((hasNext) == true) {
                throw new NoSuchElementException(AbstractHashedMap.NO_PREVIOUS_ENTRY);
            }
            hasNext = true;
            CallChecker.varAssign(this.hasNext, "this.hasNext", 436, 12556, 12570);
            if (CallChecker.beforeDeref(parent, SingletonMap.class, 437, 12591, 12596)) {
                return parent.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public void remove() {
            MethodContext _bcornu_methode_context732 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 440, 12627, 12713);
                CallChecker.varInit(this.canGetSet, "canGetSet", 440, 12627, 12713);
                CallChecker.varInit(this.hasNext, "hasNext", 440, 12627, 12713);
                CallChecker.varInit(this.parent, "parent", 440, 12627, 12713);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context732.methodEnd();
            }
        }

        public K getKey() {
            if ((canGetSet) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            if (CallChecker.beforeDeref(parent, SingletonMap.class, 448, 12898, 12903)) {
                return parent.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public V getValue() {
            if ((canGetSet) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            if (CallChecker.beforeDeref(parent, SingletonMap.class, 455, 13112, 13117)) {
                return parent.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }

        public V setValue(V value) {
            if ((canGetSet) == false) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            if (CallChecker.beforeDeref(parent, SingletonMap.class, 462, 13335, 13340)) {
                return parent.setValue(value);
            }else
                throw new AbnormalExecutionError();
            
        }

        public void reset() {
            MethodContext _bcornu_methode_context736 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 465, 13386, 13444);
                CallChecker.varInit(this.canGetSet, "canGetSet", 465, 13386, 13444);
                CallChecker.varInit(this.hasNext, "hasNext", 465, 13386, 13444);
                CallChecker.varInit(this.parent, "parent", 465, 13386, 13444);
                hasNext = true;
                CallChecker.varAssign(this.hasNext, "this.hasNext", 466, 13420, 13434);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context736.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context737 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 470, 13463, 13662);
                CallChecker.varInit(this.canGetSet, "canGetSet", 470, 13463, 13662);
                CallChecker.varInit(this.hasNext, "hasNext", 470, 13463, 13662);
                CallChecker.varInit(this.parent, "parent", 470, 13463, 13662);
                if (hasNext) {
                    return "Iterator[]";
                }
                return ((("Iterator[" + (getKey())) + "=") + (getValue())) + "]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context737.methodEnd();
            }
        }
    }

    static class SingletonValues<V> extends AbstractSet<V> implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;

        private final SingletonMap<?, V> parent;

        SingletonValues(SingletonMap<?, V> parent) {
            super();
            MethodContext _bcornu_methode_context134 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 488, 14124, 14144);
            } finally {
                _bcornu_methode_context134.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context738 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 492, 14165, 14233);
                CallChecker.varInit(this.parent, "parent", 492, 14165, 14233);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.SingletonValues.serialVersionUID", 492, 14165, 14233);
                return 1;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context738.methodEnd();
            }
        }

        @Override
        public boolean isEmpty() {
            MethodContext _bcornu_methode_context739 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 496, 14243, 14322);
                CallChecker.varInit(this.parent, "parent", 496, 14243, 14322);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.SingletonValues.serialVersionUID", 496, 14243, 14322);
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context739.methodEnd();
            }
        }

        @Override
        public boolean contains(Object object) {
            MethodContext _bcornu_methode_context740 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 500, 14332, 14448);
                CallChecker.varInit(object, "object", 500, 14332, 14448);
                CallChecker.varInit(this.parent, "parent", 500, 14332, 14448);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.SingletonValues.serialVersionUID", 500, 14332, 14448);
                if (CallChecker.beforeDeref(parent, SingletonMap.class, 501, 14410, 14415)) {
                    return CallChecker.isCalled(parent, SingletonMap.class, 501, 14410, 14415).containsValue(object);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context740.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context741 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 504, 14458, 14561);
                CallChecker.varInit(this.parent, "parent", 504, 14458, 14561);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.SingletonValues.serialVersionUID", 504, 14458, 14561);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context741.methodEnd();
            }
        }

        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context742 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 508, 14571, 14700);
                CallChecker.varInit(this.parent, "parent", 508, 14571, 14700);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.SingletonValues.serialVersionUID", 508, 14571, 14700);
                if (CallChecker.beforeDeref(parent, SingletonMap.class, 509, 14665, 14670)) {
                    return new SingletonIterator<V>(parent.getValue(), false);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context742.methodEnd();
            }
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public SingletonMap<K, V> clone() {
        MethodContext _bcornu_methode_context743 = new MethodContext(SingletonMap.class);
        try {
            CallChecker.varInit(this, "this", 521, 14717, 15162);
            CallChecker.varInit(this.value, "value", 521, 14717, 15162);
            CallChecker.varInit(this.key, "key", 521, 14717, 15162);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 521, 14717, 15162);
            TryContext _bcornu_try_context_6 = new TryContext(6, SingletonMap.class, "java.lang.CloneNotSupportedException");
            try {
                return ((SingletonMap<K, V>) (super.clone()));
            } catch (CloneNotSupportedException ex) {
                _bcornu_try_context_6.catchStart(6);
                throw new InternalError();
            } finally {
                _bcornu_try_context_6.finallyStart(6);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((SingletonMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context743.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context744 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 536, 15169, 15754);
            CallChecker.varInit(obj, "obj", 536, 15169, 15754);
            CallChecker.varInit(this.value, "value", 536, 15169, 15754);
            CallChecker.varInit(this.key, "key", 536, 15169, 15754);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 536, 15169, 15754);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof Map) == false) {
                return false;
            }
            Map<?, ?> other = CallChecker.varInit(((Map<?, ?>) (obj)), "other", 543, 15504, 15535);
            if (CallChecker.beforeDeref(other, Map.class, 544, 15549, 15553)) {
                other = CallChecker.beforeCalled(other, Map.class, 544, 15549, 15553);
                if ((CallChecker.isCalled(other, Map.class, 544, 15549, 15553).size()) != 1) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            Map.Entry<?, ?> entry = CallChecker.init(Map.Entry.class);
            if (CallChecker.beforeDeref(other, Map.class, 547, 15637, 15641)) {
                other = CallChecker.beforeCalled(other, Map.class, 547, 15637, 15641);
                if (CallChecker.beforeDeref(CallChecker.isCalled(other, Map.class, 547, 15637, 15641).entrySet(), Set.class, 547, 15637, 15652)) {
                    other = CallChecker.beforeCalled(other, Map.class, 547, 15637, 15641);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(other, Map.class, 547, 15637, 15641).entrySet(), Set.class, 547, 15637, 15652).iterator(), Iterator.class, 547, 15637, 15663)) {
                        other = CallChecker.beforeCalled(other, Map.class, 547, 15637, 15641);
                        entry = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(other, Map.class, 547, 15637, 15641).entrySet(), Set.class, 547, 15637, 15652).iterator(), Iterator.class, 547, 15637, 15663).next();
                        CallChecker.varAssign(entry, "entry", 547, 15637, 15641);
                    }
                }
            }
            if (CallChecker.beforeDeref(entry, Map.Entry.class, 548, 15699, 15703)) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 548, 15731, 15735)) {
                    return (isEqualKey(entry.getKey())) && (isEqualValue(entry.getValue()));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context744.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context745 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 557, 15761, 16052);
            CallChecker.varInit(this.value, "value", 557, 15761, 16052);
            CallChecker.varInit(this.key, "key", 557, 15761, 16052);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 557, 15761, 16052);
            final K npe_invocation_var178 = getKey();
            if (((getKey()) == null) || (CallChecker.beforeDeref(npe_invocation_var178, null, 558, 15959, 15966))) {
                final V npe_invocation_var179 = getValue();
                if (((getValue()) == null) || (CallChecker.beforeDeref(npe_invocation_var179, null, 559, 16023, 16032))) {
                    return (((getKey()) == null) ? 0 : npe_invocation_var178.hashCode()) ^ (((getValue()) == null) ? 0 : npe_invocation_var179.hashCode());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context745.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context746 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 568, 16059, 16478);
            CallChecker.varInit(this.value, "value", 568, 16059, 16478);
            CallChecker.varInit(this.key, "key", 568, 16059, 16478);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.SingletonMap.serialVersionUID", 568, 16059, 16478);
            if (CallChecker.beforeDeref(new StringBuilder(128), StringBuilder.class, 569, 16215, 16236)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(128), StringBuilder.class, 569, 16215, 16236).append('{'), StringBuilder.class, 569, 16215, 16261)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(128), StringBuilder.class, 569, 16215, 16236).append('{'), StringBuilder.class, 569, 16215, 16261).append(((getKey()) == (this) ? "(this Map)" : getKey())), StringBuilder.class, 569, 16215, 16327)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(128), StringBuilder.class, 569, 16215, 16236).append('{'), StringBuilder.class, 569, 16215, 16261).append(((getKey()) == (this) ? "(this Map)" : getKey())), StringBuilder.class, 569, 16215, 16327).append('='), StringBuilder.class, 569, 16215, 16352)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(128), StringBuilder.class, 569, 16215, 16236).append('{'), StringBuilder.class, 569, 16215, 16261).append(((getKey()) == (this) ? "(this Map)" : getKey())), StringBuilder.class, 569, 16215, 16327).append('='), StringBuilder.class, 569, 16215, 16352).append(((getValue()) == (this) ? "(this Map)" : getValue())), StringBuilder.class, 569, 16215, 16422)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(128), StringBuilder.class, 569, 16215, 16236).append('{'), StringBuilder.class, 569, 16215, 16261).append(((getKey()) == (this) ? "(this Map)" : getKey())), StringBuilder.class, 569, 16215, 16327).append('='), StringBuilder.class, 569, 16215, 16352).append(((getValue()) == (this) ? "(this Map)" : getValue())), StringBuilder.class, 569, 16215, 16422).append('}'), StringBuilder.class, 569, 16215, 16447)) {
                                    return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(128), StringBuilder.class, 569, 16215, 16236).append('{'), StringBuilder.class, 569, 16215, 16261).append(((getKey()) == (this) ? "(this Map)" : getKey())), StringBuilder.class, 569, 16215, 16327).append('='), StringBuilder.class, 569, 16215, 16352).append(((getValue()) == (this) ? "(this Map)" : getValue())), StringBuilder.class, 569, 16215, 16422).append('}'), StringBuilder.class, 569, 16215, 16447).toString();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
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
            _bcornu_methode_context746.methodEnd();
        }
    }
}

