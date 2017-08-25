package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.map.AbstractMapDecorator;
import org.apache.commons.collections.BidiMap;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Set;

public final class UnmodifiableBidiMap<K, V> extends AbstractBidiMapDecorator<K, V> implements Unmodifiable {
    private UnmodifiableBidiMap<V, K> inverse;

    public static <K, V> BidiMap<K, V> decorate(BidiMap<K, V> map) {
        MethodContext _bcornu_methode_context1122 = new MethodContext(BidiMap.class);
        try {
            CallChecker.varInit(map, "map", 56, 1879, 2383);
            if (map instanceof Unmodifiable) {
                return map;
            }
            return new UnmodifiableBidiMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1122.methodEnd();
        }
    }

    private UnmodifiableBidiMap(BidiMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context223 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context223.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1123 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 76, 2727, 2896);
            CallChecker.varInit(this.map, "map", 76, 2727, 2896);
            CallChecker.varInit(this.inverse, "inverse", 76, 2727, 2896);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1123.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context1125 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 3010, 3141);
            CallChecker.varInit(mapToCopy, "mapToCopy", 86, 3010, 3141);
            CallChecker.varInit(this.map, "map", 86, 3010, 3141);
            CallChecker.varInit(this.inverse, "inverse", 86, 3010, 3141);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1125.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1127 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 96, 3254, 3417);
            CallChecker.varInit(this.map, "map", 96, 3254, 3417);
            CallChecker.varInit(this.inverse, "inverse", 96, 3254, 3417);
            Set<Map.Entry<K, V>> set = CallChecker.varInit(super.entrySet(), "set", 97, 3317, 3360);
            return UnmodifiableEntrySet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1127.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1128 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 102, 3424, 3550);
            CallChecker.varInit(this.map, "map", 102, 3424, 3550);
            CallChecker.varInit(this.inverse, "inverse", 102, 3424, 3550);
            Set<K> set = CallChecker.varInit(super.keySet(), "set", 103, 3471, 3498);
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1128.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context1129 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 108, 3557, 3706);
            CallChecker.varInit(this.map, "map", 108, 3557, 3706);
            CallChecker.varInit(this.inverse, "inverse", 108, 3557, 3706);
            Collection<V> coll = CallChecker.varInit(super.values(), "coll", 109, 3611, 3646);
            return UnmodifiableCollection.decorate(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1129.methodEnd();
        }
    }

    @Override
    public K removeValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1131 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 120, 3904, 4074);
            CallChecker.varInit(this.map, "map", 120, 3904, 4074);
            CallChecker.varInit(this.inverse, "inverse", 120, 3904, 4074);
            final BidiMap<K, V> npe_invocation_var260 = decorated();
            MapIterator<K, V> it = CallChecker.init(MapIterator.class);
            if (CallChecker.beforeDeref(npe_invocation_var260, BidiMap.class, 121, 3990, 4000)) {
                it = CallChecker.isCalled(npe_invocation_var260, BidiMap.class, 121, 3990, 4000).mapIterator();
                CallChecker.varAssign(it, "it", 121, 3990, 4000);
            }
            return UnmodifiableMapIterator.decorate(it);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1131.methodEnd();
        }
    }

    @Override
    public synchronized BidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context1132 = new MethodContext(BidiMap.class);
        try {
            CallChecker.varInit(this, "this", 126, 4081, 4336);
            CallChecker.varInit(this.map, "map", 126, 4081, 4336);
            CallChecker.varInit(this.inverse, "inverse", 126, 4081, 4336);
            if ((inverse) == null) {
                final BidiMap<K, V> npe_invocation_var261 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var261, BidiMap.class, 128, 4231, 4241)) {
                    inverse = new UnmodifiableBidiMap<V, K>(CallChecker.isCalled(npe_invocation_var261, BidiMap.class, 128, 4231, 4241).inverseBidiMap());
                    CallChecker.varAssign(this.inverse, "this.inverse", 128, 4191, 4260);
                }
                if (CallChecker.beforeDeref(inverse, UnmodifiableBidiMap.class, 129, 4274, 4280)) {
                    inverse = CallChecker.beforeCalled(inverse, UnmodifiableBidiMap.class, 129, 4274, 4280);
                    CallChecker.isCalled(inverse, UnmodifiableBidiMap.class, 129, 4274, 4280).inverse = this;
                    CallChecker.varAssign(CallChecker.isCalled(this.inverse, UnmodifiableBidiMap.class, 129, 4274, 4280).inverse, "CallChecker.isCalled(this.inverse, UnmodifiableBidiMap.class, 129, 4274, 4280).inverse", 129, 4274, 4296);
                }
            }
            return inverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1132.methodEnd();
        }
    }
}

