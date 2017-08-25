package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.map.AbstractMapDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMapIterator;
import java.util.Set;

public final class UnmodifiableOrderedBidiMap<K, V> extends AbstractOrderedBidiMapDecorator<K, V> implements Unmodifiable {
    private UnmodifiableOrderedBidiMap<V, K> inverse;

    public static <K, V> OrderedBidiMap<K, V> decorate(OrderedBidiMap<K, V> map) {
        MethodContext _bcornu_methode_context360 = new MethodContext(OrderedBidiMap.class);
        try {
            CallChecker.varInit(map, "map", 56, 1928, 2460);
            if (map instanceof Unmodifiable) {
                return map;
            }
            return new UnmodifiableOrderedBidiMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedBidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context360.methodEnd();
        }
    }

    private UnmodifiableOrderedBidiMap(OrderedBidiMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context57 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context361 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 76, 2818, 2987);
            CallChecker.varInit(this.map, "map", 76, 2818, 2987);
            CallChecker.varInit(this.inverse, "inverse", 76, 2818, 2987);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context361.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context363 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 3101, 3232);
            CallChecker.varInit(mapToCopy, "mapToCopy", 86, 3101, 3232);
            CallChecker.varInit(this.map, "map", 86, 3101, 3232);
            CallChecker.varInit(this.inverse, "inverse", 86, 3101, 3232);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context363.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context365 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 96, 3345, 3508);
            CallChecker.varInit(this.map, "map", 96, 3345, 3508);
            CallChecker.varInit(this.inverse, "inverse", 96, 3345, 3508);
            Set<Map.Entry<K, V>> set = CallChecker.varInit(super.entrySet(), "set", 97, 3408, 3451);
            return UnmodifiableEntrySet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context365.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context366 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 102, 3515, 3641);
            CallChecker.varInit(this.map, "map", 102, 3515, 3641);
            CallChecker.varInit(this.inverse, "inverse", 102, 3515, 3641);
            Set<K> set = CallChecker.varInit(super.keySet(), "set", 103, 3562, 3589);
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context366.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context367 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 108, 3648, 3797);
            CallChecker.varInit(this.map, "map", 108, 3648, 3797);
            CallChecker.varInit(this.inverse, "inverse", 108, 3648, 3797);
            Collection<V> coll = CallChecker.varInit(super.values(), "coll", 109, 3702, 3737);
            return UnmodifiableCollection.decorate(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context367.methodEnd();
        }
    }

    @Override
    public K removeValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public OrderedBidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context369 = new MethodContext(OrderedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 120, 3995, 4100);
            CallChecker.varInit(this.map, "map", 120, 3995, 4100);
            CallChecker.varInit(this.inverse, "inverse", 120, 3995, 4100);
            return inverseOrderedBidiMap();
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context369.methodEnd();
        }
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context370 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 126, 4107, 4376);
            CallChecker.varInit(this.map, "map", 126, 4107, 4376);
            CallChecker.varInit(this.inverse, "inverse", 126, 4107, 4376);
            final OrderedBidiMap<K, V> npe_invocation_var113 = decorated();
            OrderedMapIterator<K, V> it = CallChecker.init(OrderedMapIterator.class);
            if (CallChecker.beforeDeref(npe_invocation_var113, OrderedBidiMap.class, 127, 4285, 4295)) {
                it = CallChecker.isCalled(npe_invocation_var113, OrderedBidiMap.class, 127, 4285, 4295).mapIterator();
                CallChecker.varAssign(it, "it", 127, 4285, 4295);
            }
            return UnmodifiableOrderedMapIterator.decorate(it);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context370.methodEnd();
        }
    }

    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        MethodContext _bcornu_methode_context371 = new MethodContext(OrderedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 131, 4383, 4632);
            CallChecker.varInit(this.map, "map", 131, 4383, 4632);
            CallChecker.varInit(this.inverse, "inverse", 131, 4383, 4632);
            if ((inverse) == null) {
                final OrderedBidiMap<K, V> npe_invocation_var114 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var114, OrderedBidiMap.class, 133, 4527, 4537)) {
                    inverse = new UnmodifiableOrderedBidiMap<V, K>(CallChecker.isCalled(npe_invocation_var114, OrderedBidiMap.class, 133, 4527, 4537).inverseBidiMap());
                    CallChecker.varAssign(this.inverse, "this.inverse", 133, 4480, 4556);
                }
                if (CallChecker.beforeDeref(inverse, UnmodifiableOrderedBidiMap.class, 134, 4570, 4576)) {
                    inverse = CallChecker.beforeCalled(inverse, UnmodifiableOrderedBidiMap.class, 134, 4570, 4576);
                    CallChecker.isCalled(inverse, UnmodifiableOrderedBidiMap.class, 134, 4570, 4576).inverse = this;
                    CallChecker.varAssign(CallChecker.isCalled(this.inverse, UnmodifiableOrderedBidiMap.class, 134, 4570, 4576).inverse, "CallChecker.isCalled(this.inverse, UnmodifiableOrderedBidiMap.class, 134, 4570, 4576).inverse", 134, 4570, 4592);
                }
            }
            return inverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context371.methodEnd();
        }
    }
}

