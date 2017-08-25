package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.map.UnmodifiableSortedMap;
import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.Unmodifiable;
import java.util.SortedMap;
import org.apache.commons.collections.map.AbstractMapDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.OrderedMapIterator;
import java.util.Set;
import org.apache.commons.collections.SortedBidiMap;

public final class UnmodifiableSortedBidiMap<K, V> extends AbstractSortedBidiMapDecorator<K, V> implements Unmodifiable {
    private UnmodifiableSortedBidiMap<V, K> inverse;

    public static <K, V> SortedBidiMap<K, V> decorate(SortedBidiMap<K, V> map) {
        MethodContext _bcornu_methode_context848 = new MethodContext(SortedBidiMap.class);
        try {
            CallChecker.varInit(map, "map", 58, 2016, 2544);
            if (map instanceof Unmodifiable) {
                return map;
            }
            return new UnmodifiableSortedBidiMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context848.methodEnd();
        }
    }

    private UnmodifiableSortedBidiMap(SortedBidiMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context171 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context171.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context849 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 78, 2900, 3069);
            CallChecker.varInit(this.map, "map", 78, 2900, 3069);
            CallChecker.varInit(this.inverse, "inverse", 78, 2900, 3069);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context849.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context851 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 88, 3183, 3314);
            CallChecker.varInit(mapToCopy, "mapToCopy", 88, 3183, 3314);
            CallChecker.varInit(this.map, "map", 88, 3183, 3314);
            CallChecker.varInit(this.inverse, "inverse", 88, 3183, 3314);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context851.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context853 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 98, 3427, 3590);
            CallChecker.varInit(this.map, "map", 98, 3427, 3590);
            CallChecker.varInit(this.inverse, "inverse", 98, 3427, 3590);
            Set<Map.Entry<K, V>> set = CallChecker.varInit(super.entrySet(), "set", 99, 3490, 3533);
            return UnmodifiableEntrySet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context853.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context854 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 104, 3597, 3723);
            CallChecker.varInit(this.map, "map", 104, 3597, 3723);
            CallChecker.varInit(this.inverse, "inverse", 104, 3597, 3723);
            Set<K> set = CallChecker.varInit(super.keySet(), "set", 105, 3644, 3671);
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context854.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context855 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 110, 3730, 3879);
            CallChecker.varInit(this.map, "map", 110, 3730, 3879);
            CallChecker.varInit(this.inverse, "inverse", 110, 3730, 3879);
            Collection<V> coll = CallChecker.varInit(super.values(), "coll", 111, 3784, 3819);
            return UnmodifiableCollection.decorate(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context855.methodEnd();
        }
    }

    @Override
    public K removeValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context857 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 123, 4077, 4346);
            CallChecker.varInit(this.map, "map", 123, 4077, 4346);
            CallChecker.varInit(this.inverse, "inverse", 123, 4077, 4346);
            final SortedBidiMap<K, V> npe_invocation_var195 = decorated();
            OrderedMapIterator<K, V> it = CallChecker.init(OrderedMapIterator.class);
            if (CallChecker.beforeDeref(npe_invocation_var195, SortedBidiMap.class, 124, 4255, 4265)) {
                it = CallChecker.isCalled(npe_invocation_var195, SortedBidiMap.class, 124, 4255, 4265).mapIterator();
                CallChecker.varAssign(it, "it", 124, 4255, 4265);
            }
            return UnmodifiableOrderedMapIterator.decorate(it);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context857.methodEnd();
        }
    }

    @Override
    public SortedBidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context858 = new MethodContext(SortedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 130, 4353, 4685);
            CallChecker.varInit(this.map, "map", 130, 4353, 4685);
            CallChecker.varInit(this.inverse, "inverse", 130, 4353, 4685);
            if ((inverse) == null) {
                final SortedBidiMap<K, V> npe_invocation_var196 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var196, SortedBidiMap.class, 132, 4580, 4590)) {
                    inverse = new UnmodifiableSortedBidiMap<V, K>(CallChecker.isCalled(npe_invocation_var196, SortedBidiMap.class, 132, 4580, 4590).inverseBidiMap());
                    CallChecker.varAssign(this.inverse, "this.inverse", 132, 4534, 4609);
                }
                if (CallChecker.beforeDeref(inverse, UnmodifiableSortedBidiMap.class, 133, 4623, 4629)) {
                    inverse = CallChecker.beforeCalled(inverse, UnmodifiableSortedBidiMap.class, 133, 4623, 4629);
                    CallChecker.isCalled(inverse, UnmodifiableSortedBidiMap.class, 133, 4623, 4629).inverse = this;
                    CallChecker.varAssign(CallChecker.isCalled(this.inverse, UnmodifiableSortedBidiMap.class, 133, 4623, 4629).inverse, "CallChecker.isCalled(this.inverse, UnmodifiableSortedBidiMap.class, 133, 4623, 4629).inverse", 133, 4623, 4645);
                }
            }
            return inverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context858.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context859 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 139, 4692, 4878);
            CallChecker.varInit(toKey, "toKey", 139, 4692, 4878);
            CallChecker.varInit(fromKey, "fromKey", 139, 4692, 4878);
            CallChecker.varInit(this.map, "map", 139, 4692, 4878);
            CallChecker.varInit(this.inverse, "inverse", 139, 4692, 4878);
            final SortedBidiMap<K, V> npe_invocation_var197 = decorated();
            SortedMap<K, V> sm = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var197, SortedBidiMap.class, 140, 4787, 4797)) {
                sm = CallChecker.isCalled(npe_invocation_var197, SortedBidiMap.class, 140, 4787, 4797).subMap(fromKey, toKey);
                CallChecker.varAssign(sm, "sm", 140, 4787, 4797);
            }
            return UnmodifiableSortedMap.decorate(sm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context859.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context860 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 145, 4885, 5053);
            CallChecker.varInit(toKey, "toKey", 145, 4885, 5053);
            CallChecker.varInit(this.map, "map", 145, 4885, 5053);
            CallChecker.varInit(this.inverse, "inverse", 145, 4885, 5053);
            final SortedBidiMap<K, V> npe_invocation_var198 = decorated();
            SortedMap<K, V> sm = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var198, SortedBidiMap.class, 146, 4970, 4980)) {
                sm = CallChecker.isCalled(npe_invocation_var198, SortedBidiMap.class, 146, 4970, 4980).headMap(toKey);
                CallChecker.varAssign(sm, "sm", 146, 4970, 4980);
            }
            return UnmodifiableSortedMap.decorate(sm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context860.methodEnd();
        }
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context861 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 151, 5060, 5232);
            CallChecker.varInit(fromKey, "fromKey", 151, 5060, 5232);
            CallChecker.varInit(this.map, "map", 151, 5060, 5232);
            CallChecker.varInit(this.inverse, "inverse", 151, 5060, 5232);
            final SortedBidiMap<K, V> npe_invocation_var199 = decorated();
            SortedMap<K, V> sm = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var199, SortedBidiMap.class, 152, 5147, 5157)) {
                sm = CallChecker.isCalled(npe_invocation_var199, SortedBidiMap.class, 152, 5147, 5157).tailMap(fromKey);
                CallChecker.varAssign(sm, "sm", 152, 5147, 5157);
            }
            return UnmodifiableSortedMap.decorate(sm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context861.methodEnd();
        }
    }
}

