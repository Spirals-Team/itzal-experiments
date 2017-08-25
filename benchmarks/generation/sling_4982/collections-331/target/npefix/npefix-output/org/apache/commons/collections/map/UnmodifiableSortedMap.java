package org.apache.commons.collections.map;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.Unmodifiable;
import java.util.SortedMap;
import java.util.Set;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;

public final class UnmodifiableSortedMap<K, V> extends AbstractSortedMapDecorator<K, V> implements Serializable , Unmodifiable {
    private static final long serialVersionUID = 5805344239827376360L;

    public static <K, V> SortedMap<K, V> decorate(SortedMap<K, V> map) {
        MethodContext _bcornu_methode_context1721 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(map, "map", 58, 1935, 2334);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 58, 1935, 2334);
            if (map instanceof Unmodifiable) {
                return map;
            }
            return new UnmodifiableSortedMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1721.methodEnd();
        }
    }

    private UnmodifiableSortedMap(SortedMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context331 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context331.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1722 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 2687, 3078);
            CallChecker.varInit(out, "out", 84, 2687, 3078);
            CallChecker.varInit(this.map, "map", 84, 2687, 3078);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 84, 2687, 3078);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 85, 3018, 3020)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 85, 3018, 3020);
                CallChecker.isCalled(out, ObjectOutputStream.class, 85, 3018, 3020).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 86, 3052, 3054)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 86, 3052, 3054);
                CallChecker.isCalled(out, ObjectOutputStream.class, 86, 3052, 3054).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1722.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1723 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 98, 3085, 3499);
            CallChecker.varInit(in, "in", 98, 3085, 3499);
            CallChecker.varInit(this.map, "map", 98, 3085, 3499);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 98, 3085, 3499);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 99, 3428, 3429)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 99, 3428, 3429);
                CallChecker.isCalled(in, ObjectInputStream.class, 99, 3428, 3429).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 100, 3478, 3479)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 100, 3478, 3479);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 100, 3478, 3479).readObject()));
                CallChecker.varAssign(this.map, "this.map", 100, 3460, 3493);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1723.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1724 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 105, 3506, 3675);
            CallChecker.varInit(this.map, "map", 105, 3506, 3675);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 105, 3506, 3675);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1724.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context1726 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 115, 3789, 3920);
            CallChecker.varInit(mapToCopy, "mapToCopy", 115, 3789, 3920);
            CallChecker.varInit(this.map, "map", 115, 3789, 3920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 115, 3789, 3920);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1726.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1728 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 125, 4033, 4156);
            CallChecker.varInit(this.map, "map", 125, 4033, 4156);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 125, 4033, 4156);
            return UnmodifiableEntrySet.decorate(super.entrySet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1728.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1729 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 130, 4163, 4263);
            CallChecker.varInit(this.map, "map", 130, 4163, 4263);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 130, 4163, 4263);
            return UnmodifiableSet.decorate(super.keySet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1729.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context1730 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 135, 4270, 4384);
            CallChecker.varInit(this.map, "map", 135, 4270, 4384);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 135, 4270, 4384);
            return UnmodifiableCollection.decorate(super.values());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1730.methodEnd();
        }
    }

    @Override
    public K firstKey() {
        final SortedMap<K, V> npe_invocation_var351 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var351, SortedMap.class, 142, 4520, 4530)) {
            return npe_invocation_var351.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public K lastKey() {
        final SortedMap<K, V> npe_invocation_var352 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var352, SortedMap.class, 147, 4605, 4615)) {
            return npe_invocation_var352.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public Comparator<? super K> comparator() {
        MethodContext _bcornu_methode_context1733 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 151, 4639, 4742);
            CallChecker.varInit(this.map, "map", 151, 4639, 4742);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 151, 4639, 4742);
            final SortedMap<K, V> npe_invocation_var353 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var353, SortedMap.class, 152, 4712, 4722)) {
                return CallChecker.isCalled(npe_invocation_var353, SortedMap.class, 152, 4712, 4722).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1733.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context1734 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 156, 4749, 4903);
            CallChecker.varInit(toKey, "toKey", 156, 4749, 4903);
            CallChecker.varInit(fromKey, "fromKey", 156, 4749, 4903);
            CallChecker.varInit(this.map, "map", 156, 4749, 4903);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 156, 4749, 4903);
            final SortedMap<K, V> npe_invocation_var354 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var354, SortedMap.class, 157, 4862, 4872)) {
                return new UnmodifiableSortedMap<K, V>(CallChecker.isCalled(npe_invocation_var354, SortedMap.class, 157, 4862, 4872).subMap(fromKey, toKey));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1734.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context1735 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 161, 4910, 5046);
            CallChecker.varInit(toKey, "toKey", 161, 4910, 5046);
            CallChecker.varInit(this.map, "map", 161, 4910, 5046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 161, 4910, 5046);
            final SortedMap<K, V> npe_invocation_var355 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var355, SortedMap.class, 162, 5013, 5023)) {
                return new UnmodifiableSortedMap<K, V>(CallChecker.isCalled(npe_invocation_var355, SortedMap.class, 162, 5013, 5023).headMap(toKey));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1735.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context1736 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 166, 5053, 5193);
            CallChecker.varInit(fromKey, "fromKey", 166, 5053, 5193);
            CallChecker.varInit(this.map, "map", 166, 5053, 5193);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableSortedMap.serialVersionUID", 166, 5053, 5193);
            final SortedMap<K, V> npe_invocation_var356 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var356, SortedMap.class, 167, 5158, 5168)) {
                return new UnmodifiableSortedMap<K, V>(CallChecker.isCalled(npe_invocation_var356, SortedMap.class, 167, 5158, 5168).tailMap(fromKey));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1736.methodEnd();
        }
    }
}

