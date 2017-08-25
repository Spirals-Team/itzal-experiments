package org.apache.commons.collections.map;

import org.apache.commons.collections.set.UnmodifiableSet;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.CollectionUtils;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.BoundedMap;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections.collection.UnmodifiableCollection;

public class FixedSizeSortedMap<K, V> extends AbstractSortedMapDecorator<K, V> implements Serializable , SortedMap<K, V> , BoundedMap<K, V> {
    private static final long serialVersionUID = 3126019624511683653L;

    public static <K, V> SortedMap<K, V> decorate(SortedMap<K, V> map) {
        MethodContext _bcornu_methode_context2119 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(map, "map", 73, 2822, 3138);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 73, 2822, 3138);
            return new FixedSizeSortedMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2119.methodEnd();
        }
    }

    protected FixedSizeSortedMap(SortedMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context406 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context406.methodEnd();
        }
    }

    protected SortedMap<K, V> getSortedMap() {
        MethodContext _bcornu_methode_context2120 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 93, 3486, 3665);
            CallChecker.varInit(this.map, "map", 93, 3486, 3665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 93, 3486, 3665);
            return ((SortedMap<K, V>) (map));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2120.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2121 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 101, 3672, 3953);
            CallChecker.varInit(out, "out", 101, 3672, 3953);
            CallChecker.varInit(this.map, "map", 101, 3672, 3953);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 101, 3672, 3953);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 102, 3893, 3895)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 102, 3893, 3895);
                CallChecker.isCalled(out, ObjectOutputStream.class, 102, 3893, 3895).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 103, 3927, 3929)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 103, 3927, 3929);
                CallChecker.isCalled(out, ObjectOutputStream.class, 103, 3927, 3929).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2121.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2122 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 110, 3960, 4289);
            CallChecker.varInit(in, "in", 110, 3960, 4289);
            CallChecker.varInit(this.map, "map", 110, 3960, 4289);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 110, 3960, 4289);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 111, 4211, 4212)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 111, 4211, 4212);
                CallChecker.isCalled(in, ObjectInputStream.class, 111, 4211, 4212).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 112, 4261, 4262)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 112, 4261, 4262);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 112, 4261, 4262).readObject()));
                CallChecker.varAssign(this.map, "this.map", 112, 4243, 4276);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2122.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        if (CallChecker.beforeDeref(map, Map.class, 118, 4431, 4433)) {
            map = CallChecker.beforeCalled(map, Map.class, 118, 4431, 4433);
            if ((CallChecker.isCalled(map, Map.class, 118, 4431, 4433).containsKey(key)) == false) {
                throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(map, Map.class, 121, 4590, 4592)) {
            return map.put(key, value);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context2124 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 125, 4622, 4921);
            CallChecker.varInit(mapToCopy, "mapToCopy", 125, 4622, 4921);
            CallChecker.varInit(this.map, "map", 125, 4622, 4921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 125, 4622, 4921);
            if (CallChecker.beforeDeref(mapToCopy, Map.class, 126, 4742, 4750)) {
                mapToCopy = CallChecker.beforeCalled(mapToCopy, Map.class, 126, 4742, 4750);
                if (CollectionUtils.isSubCollection(CallChecker.isCalled(mapToCopy, Map.class, 126, 4742, 4750).keySet(), keySet())) {
                    throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
                }
            }
            if (CallChecker.beforeDeref(map, Map.class, 129, 4894, 4896)) {
                map = CallChecker.beforeCalled(map, Map.class, 129, 4894, 4896);
                CallChecker.isCalled(map, Map.class, 129, 4894, 4896).putAll(mapToCopy);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2124.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2125 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 133, 4928, 5038);
            CallChecker.varInit(this.map, "map", 133, 4928, 5038);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 133, 4928, 5038);
            throw new UnsupportedOperationException("Map is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2125.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context2127 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 143, 5170, 5286);
            CallChecker.varInit(this.map, "map", 143, 5170, 5286);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 143, 5170, 5286);
            if (CallChecker.beforeDeref(map, Map.class, 144, 5265, 5267)) {
                map = CallChecker.beforeCalled(map, Map.class, 144, 5265, 5267);
                return UnmodifiableSet.decorate(CallChecker.isCalled(map, Map.class, 144, 5265, 5267).entrySet());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2127.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context2128 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 148, 5293, 5391);
            CallChecker.varInit(this.map, "map", 148, 5293, 5391);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 148, 5293, 5391);
            if (CallChecker.beforeDeref(map, Map.class, 149, 5372, 5374)) {
                map = CallChecker.beforeCalled(map, Map.class, 149, 5372, 5374);
                return UnmodifiableSet.decorate(CallChecker.isCalled(map, Map.class, 149, 5372, 5374).keySet());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2128.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context2129 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 153, 5398, 5510);
            CallChecker.varInit(this.map, "map", 153, 5398, 5510);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 153, 5398, 5510);
            if (CallChecker.beforeDeref(map, Map.class, 154, 5491, 5493)) {
                map = CallChecker.beforeCalled(map, Map.class, 154, 5491, 5493);
                return UnmodifiableCollection.decorate(CallChecker.isCalled(map, Map.class, 154, 5491, 5493).values());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2129.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context2130 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 159, 5517, 5749);
            CallChecker.varInit(toKey, "toKey", 159, 5517, 5749);
            CallChecker.varInit(fromKey, "fromKey", 159, 5517, 5749);
            CallChecker.varInit(this.map, "map", 159, 5517, 5749);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 159, 5517, 5749);
            final SortedMap<K, V> npe_invocation_var400 = getSortedMap();
            if (CallChecker.beforeDeref(npe_invocation_var400, SortedMap.class, 160, 5705, 5718)) {
                return new FixedSizeSortedMap<K, V>(CallChecker.isCalled(npe_invocation_var400, SortedMap.class, 160, 5705, 5718).subMap(fromKey, toKey));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2130.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context2131 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 164, 5756, 5892);
            CallChecker.varInit(toKey, "toKey", 164, 5756, 5892);
            CallChecker.varInit(this.map, "map", 164, 5756, 5892);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 164, 5756, 5892);
            final SortedMap<K, V> npe_invocation_var401 = getSortedMap();
            if (CallChecker.beforeDeref(npe_invocation_var401, SortedMap.class, 165, 5856, 5869)) {
                return new FixedSizeSortedMap<K, V>(CallChecker.isCalled(npe_invocation_var401, SortedMap.class, 165, 5856, 5869).headMap(toKey));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2131.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context2132 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 169, 5899, 6039);
            CallChecker.varInit(fromKey, "fromKey", 169, 5899, 6039);
            CallChecker.varInit(this.map, "map", 169, 5899, 6039);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 169, 5899, 6039);
            final SortedMap<K, V> npe_invocation_var402 = getSortedMap();
            if (CallChecker.beforeDeref(npe_invocation_var402, SortedMap.class, 170, 6001, 6014)) {
                return new FixedSizeSortedMap<K, V>(CallChecker.isCalled(npe_invocation_var402, SortedMap.class, 170, 6001, 6014).tailMap(fromKey));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2132.methodEnd();
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context2133 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 173, 6046, 6097);
            CallChecker.varInit(this.map, "map", 173, 6046, 6097);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 173, 6046, 6097);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2133.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context2134 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 177, 6104, 6154);
            CallChecker.varInit(this.map, "map", 177, 6104, 6154);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeSortedMap.serialVersionUID", 177, 6104, 6154);
            return size();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2134.methodEnd();
        }
    }
}

