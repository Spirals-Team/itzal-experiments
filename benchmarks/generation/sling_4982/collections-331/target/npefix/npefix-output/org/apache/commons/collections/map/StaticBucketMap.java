package org.apache.commons.collections.map;

import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import org.apache.commons.collections.KeyValue;

public final class StaticBucketMap<K, V> extends AbstractIterableMap<K, V> {
    private static final int DEFAULT_BUCKETS = 255;

    private final StaticBucketMap.Node<K, V>[] buckets;

    private final StaticBucketMap.Lock[] locks;

    public StaticBucketMap() {
        this(StaticBucketMap.DEFAULT_BUCKETS);
        MethodContext _bcornu_methode_context392 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context392.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public StaticBucketMap(int numBuckets) {
        MethodContext _bcornu_methode_context393 = new MethodContext(null);
        try {
            int size = CallChecker.varInit(((int) (Math.max(17, numBuckets))), "size", 132, 5704, 5739);
            if ((size % 2) == 0) {
                size--;
            }
            buckets = new StaticBucketMap.Node[size];
            CallChecker.varAssign(this.buckets, "this.buckets", 139, 5899, 5923);
            locks = new StaticBucketMap.Lock[size];
            CallChecker.varAssign(this.locks, "this.locks", 140, 5933, 5955);
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 143, 6011, 6015)) {
                    CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 143, 6011, 6015)[i] = new StaticBucketMap.Lock();
                    CallChecker.varAssign(CallChecker.isCalled(this.locks, StaticBucketMap.Lock[].class, 143, 6011, 6015)[i], "CallChecker.isCalled(this.locks, StaticBucketMap.Lock[].class, 143, 6011, 6015)[i]", 143, 6011, 6032);
                }
            }
        } finally {
            _bcornu_methode_context393.methodEnd();
        }
    }

    private final int getHash(Object key) {
        MethodContext _bcornu_methode_context2003 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 161, 6055, 6862);
            CallChecker.varInit(key, "key", 161, 6055, 6862);
            CallChecker.varInit(this.locks, "locks", 161, 6055, 6862);
            CallChecker.varInit(this.buckets, "buckets", 161, 6055, 6862);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 161, 6055, 6862);
            if (key == null) {
                return 0;
            }
            int hash = CallChecker.varInit(((int) (key.hashCode())), "hash", 165, 6570, 6595);
            hash += ~(hash << 15);
            CallChecker.varAssign(hash, "hash", 166, 6605, 6626);
            hash ^= hash >>> 10;
            CallChecker.varAssign(hash, "hash", 167, 6636, 6657);
            hash += hash << 3;
            CallChecker.varAssign(hash, "hash", 168, 6667, 6686);
            hash ^= hash >>> 6;
            CallChecker.varAssign(hash, "hash", 169, 6696, 6716);
            hash += ~(hash << 11);
            CallChecker.varAssign(hash, "hash", 170, 6726, 6747);
            hash ^= hash >>> 16;
            CallChecker.varAssign(hash, "hash", 171, 6757, 6778);
            if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 172, 6796, 6802)) {
                hash %= CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 172, 6796, 6802).length;
                CallChecker.varAssign(hash, "hash", 172, 6788, 6810);
            }
            if (hash < 0) {
                return hash * (-1);
            }else {
                return hash;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2003.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context2004 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 182, 6869, 7249);
            CallChecker.varInit(this.locks, "locks", 182, 6869, 7249);
            CallChecker.varInit(this.buckets, "buckets", 182, 6869, 7249);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 182, 6869, 7249);
            int cnt = CallChecker.varInit(((int) (0)), "cnt", 183, 7061, 7072);
            for (int i = 0; i < (CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 185, 7103, 7109).length); i++) {
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 186, 7151, 7155)) {
                    synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 186, 7151, 7155)[i]) {
                        if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 187, 7186, 7190)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 187, 7186, 7190)[i], StaticBucketMap.Lock.class, 187, 7186, 7193)) {
                                CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 187, 7186, 7190)[i] = CallChecker.beforeCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 187, 7186, 7190)[i], StaticBucketMap.Lock.class, 187, 7186, 7193);
                                cnt += CallChecker.isCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 187, 7186, 7190)[i], StaticBucketMap.Lock.class, 187, 7186, 7193).size;
                                CallChecker.varAssign(cnt, "cnt", 187, 7179, 7199);
                            }
                        }
                    }
                }
            }
            return cnt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2004.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context2005 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 198, 7256, 7415);
            CallChecker.varInit(this.locks, "locks", 198, 7256, 7415);
            CallChecker.varInit(this.buckets, "buckets", 198, 7256, 7415);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 198, 7256, 7415);
            return (size()) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2005.methodEnd();
        }
    }

    public V get(final Object key) {
        int hash = CallChecker.varInit(((int) (getHash(key))), "hash", 209, 7609, 7632);
        if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 211, 7657, 7661)) {
            synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 211, 7657, 7661)[hash]) {
                StaticBucketMap.Node<K, V> n = CallChecker.init(StaticBucketMap.Node.class);
                if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 212, 7699, 7705)) {
                    n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 212, 7699, 7705)[hash];
                    CallChecker.varAssign(n, "n", 212, 7699, 7705);
                }
                while (n != null) {
                    if (((n.key) == key) || (((n.key) != null) && (n.key.equals(key)))) {
                        return n.value;
                    }
                    n = n.next;
                    CallChecker.varAssign(n, "n", 219, 7894, 7904);
                } 
            }
        }else
            throw new AbnormalExecutionError();
        
        return null;
    }

    public boolean containsKey(final Object key) {
        MethodContext _bcornu_methode_context2007 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 231, 7962, 8503);
            CallChecker.varInit(key, "key", 231, 7962, 8503);
            CallChecker.varInit(this.locks, "locks", 231, 7962, 8503);
            CallChecker.varInit(this.buckets, "buckets", 231, 7962, 8503);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 231, 7962, 8503);
            int hash = CallChecker.varInit(((int) (getHash(key))), "hash", 232, 8159, 8182);
            if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 234, 8207, 8211)) {
                synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 234, 8207, 8211)[hash]) {
                    StaticBucketMap.Node<K, V> n = CallChecker.init(StaticBucketMap.Node.class);
                    if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 235, 8249, 8255)) {
                        n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 235, 8249, 8255)[hash];
                        CallChecker.varAssign(n, "n", 235, 8249, 8255);
                    }
                    while (n != null) {
                        if (((n.key) == key) || (((n.key) != null) && (n.key.equals(key)))) {
                            return true;
                        }
                        n = n.next;
                        CallChecker.varAssign(n, "n", 242, 8441, 8451);
                    } 
                }
            }else
                throw new AbnormalExecutionError();
            
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2007.methodEnd();
        }
    }

    public boolean containsValue(final Object value) {
        MethodContext _bcornu_methode_context2008 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 254, 8510, 9128);
            CallChecker.varInit(value, "value", 254, 8510, 9128);
            CallChecker.varInit(this.locks, "locks", 254, 8510, 9128);
            CallChecker.varInit(this.buckets, "buckets", 254, 8510, 9128);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 254, 8510, 9128);
            for (int i = 0; i < (CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 255, 8737, 8743).length); i++) {
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 256, 8786, 8790)) {
                    synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 256, 8786, 8790)[i]) {
                        StaticBucketMap.Node<K, V> n = CallChecker.init(StaticBucketMap.Node.class);
                        if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 257, 8829, 8835)) {
                            n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 257, 8829, 8835)[i];
                            CallChecker.varAssign(n, "n", 257, 8829, 8835);
                        }
                        while (n != null) {
                            if (((n.value) == value) || (((n.value) != null) && (n.value.equals(value)))) {
                                return true;
                            }
                            n = n.next;
                            CallChecker.varAssign(n, "n", 264, 9048, 9058);
                        } 
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2008.methodEnd();
        }
    }

    public V put(final K key, final V value) {
        int hash = CallChecker.varInit(((int) (getHash(key))), "hash", 280, 9458, 9481);
        if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 282, 9506, 9510)) {
            synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 282, 9506, 9510)[hash]) {
                StaticBucketMap.Node<K, V> n = CallChecker.init(StaticBucketMap.Node.class);
                if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 283, 9548, 9554)) {
                    n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 283, 9548, 9554)[hash];
                    CallChecker.varAssign(n, "n", 283, 9548, 9554);
                }
                if (n == null) {
                    n = new StaticBucketMap.Node<K, V>();
                    CallChecker.varAssign(n, "n", 286, 9609, 9629);
                    if (CallChecker.beforeDeref(n, StaticBucketMap.Node.class, 287, 9647, 9647)) {
                        n.key = key;
                        CallChecker.varAssign(n.key, "n.key", 287, 9647, 9658);
                    }
                    if (CallChecker.beforeDeref(n, StaticBucketMap.Node.class, 288, 9676, 9676)) {
                        n.value = value;
                        CallChecker.varAssign(n.value, "n.value", 288, 9676, 9691);
                    }
                    if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 289, 9709, 9715)) {
                        CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 289, 9709, 9715)[hash] = n;
                        CallChecker.varAssign(CallChecker.isCalled(this.buckets, StaticBucketMap.Node[].class, 289, 9709, 9715)[hash], "CallChecker.isCalled(this.buckets, StaticBucketMap.Node[].class, 289, 9709, 9715)[hash]", 289, 9709, 9726);
                    }
                    if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 290, 9744, 9748)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 290, 9744, 9748)[hash], StaticBucketMap.Lock.class, 290, 9744, 9754)) {
                            CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 290, 9744, 9748)[hash] = CallChecker.beforeCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 290, 9744, 9748)[hash], StaticBucketMap.Lock.class, 290, 9744, 9754);
                            (CallChecker.isCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 290, 9744, 9748)[hash], StaticBucketMap.Lock.class, 290, 9744, 9754).size)++;
                        }
                    }
                    return null;
                }
                for (StaticBucketMap.Node<K, V> next = n; next != null; next = CallChecker.isCalled(next, StaticBucketMap.Node.class, 297, 10069, 10072).next) {
                    CallChecker.varAssign(next, "next", 297, 10062, 10077);
                    n = next;
                    CallChecker.varAssign(n, "n", 298, 10098, 10106);
                    if (((n.key) == key) || (((n.key) != null) && (n.key.equals(key)))) {
                        V returnVal = CallChecker.varInit(n.value, "returnVal", 301, 10205, 10226);
                        n.value = value;
                        CallChecker.varAssign(n.value, "n.value", 302, 10248, 10263);
                        return returnVal;
                    }
                }
                StaticBucketMap.Node<K, V> newNode = CallChecker.varInit(new StaticBucketMap.Node<K, V>(), "newNode", 309, 10464, 10501);
                if (CallChecker.beforeDeref(newNode, StaticBucketMap.Node.class, 310, 10515, 10521)) {
                    newNode.key = key;
                    CallChecker.varAssign(newNode.key, "newNode.key", 310, 10515, 10532);
                }
                if (CallChecker.beforeDeref(newNode, StaticBucketMap.Node.class, 311, 10546, 10552)) {
                    newNode.value = value;
                    CallChecker.varAssign(newNode.value, "newNode.value", 311, 10546, 10567);
                }
                n.next = newNode;
                CallChecker.varAssign(n.next, "n.next", 312, 10581, 10597);
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 313, 10611, 10615)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 313, 10611, 10615)[hash], StaticBucketMap.Lock.class, 313, 10611, 10621)) {
                        CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 313, 10611, 10615)[hash] = CallChecker.beforeCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 313, 10611, 10615)[hash], StaticBucketMap.Lock.class, 313, 10611, 10621);
                        (CallChecker.isCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 313, 10611, 10615)[hash], StaticBucketMap.Lock.class, 313, 10611, 10621).size)++;
                    }
                }
            }
        }else
            throw new AbnormalExecutionError();
        
        return null;
    }

    public V remove(Object key) {
        int hash = CallChecker.varInit(((int) (getHash(key))), "hash", 325, 10865, 10888);
        if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 327, 10913, 10917)) {
            synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 327, 10913, 10917)[hash]) {
                StaticBucketMap.Node<K, V> n = CallChecker.init(StaticBucketMap.Node.class);
                if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 328, 10955, 10961)) {
                    n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 328, 10955, 10961)[hash];
                    CallChecker.varAssign(n, "n", 328, 10955, 10961);
                }
                StaticBucketMap.Node<K, V> prev = CallChecker.varInit(null, "prev", 329, 10982, 11004);
                while (n != null) {
                    if (((n.key) == key) || (((n.key) != null) && (n.key.equals(key)))) {
                        if (null == prev) {
                            if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 336, 11339, 11345)) {
                                CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 336, 11339, 11345)[hash] = n.next;
                                CallChecker.varAssign(CallChecker.isCalled(this.buckets, StaticBucketMap.Node[].class, 336, 11339, 11345)[hash], "CallChecker.isCalled(this.buckets, StaticBucketMap.Node[].class, 336, 11339, 11345)[hash]", 336, 11339, 11361);
                            }
                        }else {
                            prev.next = n.next;
                            CallChecker.varAssign(prev.next, "prev.next", 339, 11513, 11531);
                        }
                        if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 341, 11575, 11579)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 341, 11575, 11579)[hash], StaticBucketMap.Lock.class, 341, 11575, 11585)) {
                                CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 341, 11575, 11579)[hash] = CallChecker.beforeCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 341, 11575, 11579)[hash], StaticBucketMap.Lock.class, 341, 11575, 11585);
                                (CallChecker.isCalled(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 341, 11575, 11579)[hash], StaticBucketMap.Lock.class, 341, 11575, 11585).size)--;
                            }
                        }
                        return n.value;
                    }
                    prev = n;
                    CallChecker.varAssign(prev, "prev", 345, 11666, 11674);
                    n = n.next;
                    CallChecker.varAssign(n, "n", 346, 11692, 11702);
                } 
            }
        }else
            throw new AbnormalExecutionError();
        
        return null;
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context2011 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 358, 11760, 11972);
            CallChecker.varInit(this.locks, "locks", 358, 11760, 11972);
            CallChecker.varInit(this.buckets, "buckets", 358, 11760, 11972);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 358, 11760, 11972);
            return new KeySet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2011.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context2012 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 367, 11979, 12118);
            CallChecker.varInit(this.locks, "locks", 367, 11979, 12118);
            CallChecker.varInit(this.buckets, "buckets", 367, 11979, 12118);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 367, 11979, 12118);
            return new Values();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2012.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context2013 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 376, 12125, 12281);
            CallChecker.varInit(this.locks, "locks", 376, 12125, 12281);
            CallChecker.varInit(this.buckets, "buckets", 376, 12125, 12281);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 376, 12125, 12281);
            return new EntrySet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2013.methodEnd();
        }
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context2014 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 387, 12288, 12772);
            CallChecker.varInit(map, "map", 387, 12288, 12772);
            CallChecker.varInit(this.locks, "locks", 387, 12288, 12772);
            CallChecker.varInit(this.buckets, "buckets", 387, 12288, 12772);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 387, 12288, 12772);
            map = CallChecker.beforeCalled(map, Map.class, 388, 12689, 12691);
            for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(map, Map.class, 388, 12689, 12691).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 389, 12723, 12727)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 389, 12739, 12743)) {
                        put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2014.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context2015 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 396, 12779, 13068);
            CallChecker.varInit(this.locks, "locks", 396, 12779, 13068);
            CallChecker.varInit(this.buckets, "buckets", 396, 12779, 13068);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 396, 12779, 13068);
            for (int i = 0; i < (CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 397, 12883, 12889).length); i++) {
                StaticBucketMap.Lock lock = CallChecker.init(StaticBucketMap.Lock.class);
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 398, 12930, 12934)) {
                    lock = CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 398, 12930, 12934)[i];
                    CallChecker.varAssign(lock, "lock", 398, 12930, 12934);
                }
                synchronized(lock) {
                    if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 400, 12990, 12996)) {
                        CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 400, 12990, 12996)[i] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.buckets, StaticBucketMap.Node[].class, 400, 12990, 12996)[i], "CallChecker.isCalled(this.buckets, StaticBucketMap.Node[].class, 400, 12990, 12996)[i]", 400, 12990, 13007);
                    }
                    if (CallChecker.beforeDeref(lock, StaticBucketMap.Lock.class, 401, 13025, 13028)) {
                        lock = CallChecker.beforeCalled(lock, StaticBucketMap.Lock.class, 401, 13025, 13028);
                        CallChecker.isCalled(lock, StaticBucketMap.Lock.class, 401, 13025, 13028).size = 0;
                        CallChecker.varAssign(CallChecker.isCalled(lock, StaticBucketMap.Lock.class, 401, 13025, 13028).size, "CallChecker.isCalled(lock, StaticBucketMap.Lock.class, 401, 13025, 13028).size", 401, 13025, 13038);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2015.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context2016 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 413, 13075, 13535);
            CallChecker.varInit(obj, "obj", 413, 13075, 13535);
            CallChecker.varInit(this.locks, "locks", 413, 13075, 13535);
            CallChecker.varInit(this.buckets, "buckets", 413, 13075, 13535);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 413, 13075, 13535);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof Map<?, ?>) == false) {
                return false;
            }
            Map<?, ?> other = CallChecker.varInit(((Map<?, ?>) (obj)), "other", 420, 13444, 13477);
            if (CallChecker.beforeDeref(other, Map.class, 421, 13512, 13516)) {
                final Set<Map.Entry<K, V>> npe_invocation_var389 = entrySet();
                if (CallChecker.beforeDeref(npe_invocation_var389, Set.class, 421, 13494, 13503)) {
                    other = CallChecker.beforeCalled(other, Map.class, 421, 13512, 13516);
                    return CallChecker.isCalled(npe_invocation_var389, Set.class, 421, 13494, 13503).equals(CallChecker.isCalled(other, Map.class, 421, 13512, 13516).entrySet());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2016.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2017 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 430, 13542, 14035);
            CallChecker.varInit(this.locks, "locks", 430, 13542, 14035);
            CallChecker.varInit(this.buckets, "buckets", 430, 13542, 14035);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 430, 13542, 14035);
            int hashCode = CallChecker.varInit(((int) (0)), "hashCode", 431, 13698, 13714);
            for (int i = 0; i < (CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 433, 13745, 13751).length); i++) {
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 434, 13794, 13798)) {
                    synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 434, 13794, 13798)[i]) {
                        StaticBucketMap.Node<K, V> n = CallChecker.init(StaticBucketMap.Node.class);
                        if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 435, 13837, 13843)) {
                            n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 435, 13837, 13843)[i];
                            CallChecker.varAssign(n, "n", 435, 13837, 13843);
                        }
                        while (n != null) {
                            hashCode += n.hashCode();
                            CallChecker.varAssign(hashCode, "hashCode", 438, 13906, 13930);
                            n = n.next;
                            CallChecker.varAssign(n, "n", 439, 13952, 13962);
                        } 
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return hashCode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2017.methodEnd();
        }
    }

    private static final class Node<K, V> implements Map.Entry<K, V> , KeyValue<K, V> {
        protected K key;

        protected V value;

        protected StaticBucketMap.Node<K, V> next;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2020 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 464, 14491, 14659);
                CallChecker.varInit(this.next, "next", 464, 14491, 14659);
                CallChecker.varInit(this.value, "value", 464, 14491, 14659);
                CallChecker.varInit(this.key, "key", 464, 14491, 14659);
                if (((key) == null) || (CallChecker.beforeDeref(key, null, 465, 14572, 14574))) {
                    if (((value) == null) || (CallChecker.beforeDeref(value, null, 466, 14631, 14635))) {
                        return (((key) == null) ? 0 : key.hashCode()) ^ (((value) == null) ? 0 : value.hashCode());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2020.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context2021 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 470, 14670, 15156);
                CallChecker.varInit(obj, "obj", 470, 14670, 15156);
                CallChecker.varInit(this.next, "next", 470, 14670, 15156);
                CallChecker.varInit(this.value, "value", 470, 14670, 15156);
                CallChecker.varInit(this.key, "key", 470, 14670, 15156);
                if (obj == (this)) {
                    return true;
                }
                if ((obj instanceof Map.Entry<?, ?>) == false) {
                    return false;
                }
                Map.Entry<?, ?> e2 = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "e2", 478, 14914, 14956);
                if (CallChecker.beforeDeref(e2, Map.Entry.class, 480, 15043, 15044)) {
                    if (((key) == null) || (CallChecker.beforeDeref(key, null, 480, 15032, 15034))) {
                        if (CallChecker.beforeDeref(e2, Map.Entry.class, 481, 15130, 15131)) {
                            if (((value) == null) || (CallChecker.beforeDeref(value, null, 481, 15117, 15121))) {
                                return (((key) == null) ? (e2.getKey()) == null : key.equals(e2.getKey())) && (((value) == null) ? (e2.getValue()) == null : value.equals(e2.getValue()));
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
                _bcornu_methode_context2021.methodEnd();
            }
        }

        public V setValue(V obj) {
            V retVal = CallChecker.varInit(value, "retVal", 485, 15206, 15222);
            value = obj;
            CallChecker.varAssign(this.value, "this.value", 486, 15236, 15247);
            return retVal;
        }
    }

    private static final class Lock {
        public int size;
    }

    private class BaseIterator {
        private ArrayList<Map.Entry<K, V>> current = new ArrayList<Map.Entry<K, V>>();

        private int bucket;

        private Map.Entry<K, V> last;

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2023 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 504, 15730, 16242);
                CallChecker.varInit(this.last, "last", 504, 15730, 16242);
                CallChecker.varInit(this.bucket, "bucket", 504, 15730, 16242);
                CallChecker.varInit(this.current, "current", 504, 15730, 16242);
                if (CallChecker.beforeDeref(current, ArrayList.class, 505, 15773, 15779)) {
                    current = CallChecker.beforeCalled(current, ArrayList.class, 505, 15773, 15779);
                    if ((CallChecker.isCalled(current, ArrayList.class, 505, 15773, 15779).size()) > 0)
                        return true;
                    
                }else
                    throw new AbnormalExecutionError();
                
                while ((bucket) < (CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 506, 15834, 15840).length)) {
                    if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 507, 15882, 15886)) {
                        synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 507, 15882, 15886)[bucket]) {
                            StaticBucketMap.Node<K, V> n = CallChecker.init(StaticBucketMap.Node.class);
                            if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 508, 15934, 15940)) {
                                n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 508, 15934, 15940)[bucket];
                                CallChecker.varAssign(n, "n", 508, 15934, 15940);
                            }
                            while (n != null) {
                                if (CallChecker.beforeDeref(current, ArrayList.class, 510, 16015, 16021)) {
                                    current = CallChecker.beforeCalled(current, ArrayList.class, 510, 16015, 16021);
                                    CallChecker.isCalled(current, ArrayList.class, 510, 16015, 16021).add(n);
                                }
                                n = n.next;
                                CallChecker.varAssign(n, "n", 511, 16055, 16065);
                            } 
                            (bucket)++;
                            if (CallChecker.beforeDeref(current, ArrayList.class, 514, 16143, 16149)) {
                                current = CallChecker.beforeCalled(current, ArrayList.class, 514, 16143, 16149);
                                if ((CallChecker.isCalled(current, ArrayList.class, 514, 16143, 16149).size()) > 0)
                                    return true;
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                } 
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2023.methodEnd();
            }
        }

        protected Map.Entry<K, V> nextEntry() {
            MethodContext _bcornu_methode_context2024 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 520, 16253, 16445);
                CallChecker.varInit(this.last, "last", 520, 16253, 16445);
                CallChecker.varInit(this.bucket, "bucket", 520, 16253, 16445);
                CallChecker.varInit(this.current, "current", 520, 16253, 16445);
                if (!(hasNext()))
                    throw new java.util.NoSuchElementException();
                
                if (CallChecker.beforeDeref(current, ArrayList.class, 522, 16391, 16397)) {
                    if (CallChecker.beforeDeref(current, ArrayList.class, 522, 16376, 16382)) {
                        current = CallChecker.beforeCalled(current, ArrayList.class, 522, 16391, 16397);
                        current = CallChecker.beforeCalled(current, ArrayList.class, 522, 16376, 16382);
                        last = CallChecker.isCalled(current, ArrayList.class, 522, 16376, 16382).remove(((CallChecker.isCalled(current, ArrayList.class, 522, 16391, 16397).size()) - 1));
                        CallChecker.varAssign(this.last, "this.last", 522, 16369, 16410);
                    }
                }
                return last;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2024.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context2025 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 526, 16456, 16633);
                CallChecker.varInit(this.last, "last", 526, 16456, 16633);
                CallChecker.varInit(this.bucket, "bucket", 526, 16456, 16633);
                CallChecker.varInit(this.current, "current", 526, 16456, 16633);
                if ((last) == null)
                    throw new IllegalStateException();
                
                StaticBucketMap.this.remove(last.getKey());
                last = null;
                CallChecker.varAssign(this.last, "this.last", 529, 16612, 16623);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2025.methodEnd();
            }
        }
    }

    private class EntryIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<Map.Entry<K, V>> {
        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context2026 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 535, 16743, 16815);
                return nextEntry();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2026.methodEnd();
            }
        }
    }

    private class ValueIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<V> {
        public V next() {
            final Map.Entry<K, V> npe_invocation_var390 = nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var390, Map.Entry.class, 544, 16949, 16959)) {
                return npe_invocation_var390.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    private class KeyIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<K> {
        public K next() {
            final Map.Entry<K, V> npe_invocation_var391 = nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var391, Map.Entry.class, 552, 17113, 17123)) {
                return npe_invocation_var391.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public int size() {
            MethodContext _bcornu_methode_context2029 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 560, 17228, 17322);
                return StaticBucketMap.this.size();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2029.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context2030 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 565, 17333, 17423);
                StaticBucketMap.this.clear();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2030.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context2031 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 570, 17434, 17546);
                return new EntryIterator();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2031.methodEnd();
            }
        }

        @Override
        public boolean contains(Object obj) {
            MethodContext _bcornu_methode_context2032 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 575, 17557, 17957);
                CallChecker.varInit(obj, "obj", 575, 17557, 17957);
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 576, 17625, 17670);
                int hash = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 577, 17703, 17707)) {
                    hash = getHash(entry.getKey());
                    CallChecker.varAssign(hash, "hash", 577, 17703, 17707);
                }
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 578, 17746, 17750)) {
                    synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 578, 17746, 17750)[hash]) {
                        for (StaticBucketMap.Node<K, V> n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 579, 17797, 17803)[hash]; n != null; n = CallChecker.isCalled(n, StaticBucketMap.Node.class, 579, 17827, 17827).next) {
                            CallChecker.varAssign(n, "n", 579, 17823, 17832);
                            if (n.equals(entry))
                                return true;
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2032.methodEnd();
            }
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context2033 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 587, 17968, 18582);
                CallChecker.varInit(obj, "obj", 587, 17968, 18582);
                if ((obj instanceof Map.Entry<?, ?>) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 591, 18137, 18182);
                int hash = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 592, 18215, 18219)) {
                    hash = getHash(entry.getKey());
                    CallChecker.varAssign(hash, "hash", 592, 18215, 18219);
                }
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 593, 18258, 18262)) {
                    synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 593, 18258, 18262)[hash]) {
                        for (StaticBucketMap.Node<K, V> n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 594, 18309, 18315)[hash]; n != null; n = CallChecker.isCalled(n, StaticBucketMap.Node.class, 594, 18339, 18339).next) {
                            CallChecker.varAssign(n, "n", 594, 18335, 18344);
                            if (n.equals(entry)) {
                                StaticBucketMap.this.remove(n.getKey());
                                return true;
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2033.methodEnd();
            }
        }
    }

    private class KeySet extends AbstractSet<K> {
        @Override
        public int size() {
            MethodContext _bcornu_methode_context2034 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 609, 18651, 18745);
                return StaticBucketMap.this.size();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2034.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context2035 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 614, 18756, 18846);
                StaticBucketMap.this.clear();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2035.methodEnd();
            }
        }

        @Override
        public Iterator<K> iterator() {
            MethodContext _bcornu_methode_context2036 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 619, 18857, 18953);
                return new KeyIterator();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2036.methodEnd();
            }
        }

        @Override
        public boolean contains(Object obj) {
            MethodContext _bcornu_methode_context2037 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 624, 18964, 19086);
                CallChecker.varInit(obj, "obj", 624, 18964, 19086);
                return StaticBucketMap.this.containsKey(obj);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2037.methodEnd();
            }
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context2038 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 629, 19097, 19601);
                CallChecker.varInit(obj, "obj", 629, 19097, 19601);
                int hash = CallChecker.varInit(((int) (getHash(obj))), "hash", 630, 19163, 19186);
                if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 631, 19214, 19218)) {
                    synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 631, 19214, 19218)[hash]) {
                        for (StaticBucketMap.Node<K, V> n = CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 632, 19265, 19271)[hash]; n != null; n = CallChecker.isCalled(n, StaticBucketMap.Node.class, 632, 19295, 19295).next) {
                            CallChecker.varAssign(n, "n", 632, 19291, 19300);
                            Object k = CallChecker.varInit(n.getKey(), "k", 633, 19325, 19346);
                            if ((k == obj) || ((k != null) && (k.equals(obj)))) {
                                StaticBucketMap.this.remove(k);
                                return true;
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2038.methodEnd();
            }
        }
    }

    private class Values extends AbstractCollection<V> {
        @Override
        public int size() {
            MethodContext _bcornu_methode_context2039 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 649, 19678, 19772);
                return StaticBucketMap.this.size();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2039.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context2040 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 654, 19783, 19873);
                StaticBucketMap.this.clear();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2040.methodEnd();
            }
        }

        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context2041 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 659, 19884, 19982);
                return new ValueIterator();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2041.methodEnd();
            }
        }
    }

    public void atomic(Runnable r) {
        MethodContext _bcornu_methode_context2042 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 699, 19996, 21355);
            CallChecker.varInit(r, "r", 699, 19996, 21355);
            CallChecker.varInit(this.locks, "locks", 699, 19996, 21355);
            CallChecker.varInit(this.buckets, "buckets", 699, 19996, 21355);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 699, 19996, 21355);
            if (r == null)
                throw new NullPointerException();
            
            atomic(r, 0);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2042.methodEnd();
        }
    }

    private void atomic(Runnable r, int bucket) {
        MethodContext _bcornu_methode_context2043 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 704, 21362, 21587);
            CallChecker.varInit(bucket, "bucket", 704, 21362, 21587);
            CallChecker.varInit(r, "r", 704, 21362, 21587);
            CallChecker.varInit(this.locks, "locks", 704, 21362, 21587);
            CallChecker.varInit(this.buckets, "buckets", 704, 21362, 21587);
            CallChecker.varInit(DEFAULT_BUCKETS, "org.apache.commons.collections.map.StaticBucketMap.DEFAULT_BUCKETS", 704, 21362, 21587);
            if (CallChecker.beforeDeref(buckets, StaticBucketMap.Node[].class, 705, 21430, 21436)) {
                if (bucket >= (CallChecker.isCalled(buckets, StaticBucketMap.Node[].class, 705, 21430, 21436).length)) {
                    if (CallChecker.beforeDeref(r, Runnable.class, 706, 21460, 21460)) {
                        r = CallChecker.beforeCalled(r, Runnable.class, 706, 21460, 21460);
                        CallChecker.isCalled(r, Runnable.class, 706, 21460, 21460).run();
                    }
                    return ;
                }
            }
            if (CallChecker.beforeDeref(locks, StaticBucketMap.Lock[].class, 709, 21521, 21525)) {
                synchronized(CallChecker.isCalled(locks, StaticBucketMap.Lock[].class, 709, 21521, 21525)[bucket]) {
                    atomic(r, (bucket + 1));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2043.methodEnd();
        }
    }
}

