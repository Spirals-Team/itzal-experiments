package org.apache.commons.collections.map;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.Unmodifiable;
import java.util.Set;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import org.apache.commons.collections.iterators.EntrySetMapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import org.apache.commons.collections.IterableMap;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class UnmodifiableMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable , IterableMap<K, V> , Unmodifiable {
    private static final long serialVersionUID = 2737023427269031941L;

    public static <K, V> Map<K, V> decorate(Map<K, V> map) {
        MethodContext _bcornu_methode_context2336 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(map, "map", 60, 2123, 2497);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 60, 2123, 2497);
            if (map instanceof Unmodifiable) {
                return map;
            }
            return new UnmodifiableMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2336.methodEnd();
        }
    }

    private UnmodifiableMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context440 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context440.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2337 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 2834, 3225);
            CallChecker.varInit(out, "out", 86, 2834, 3225);
            CallChecker.varInit(this.map, "map", 86, 2834, 3225);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 86, 2834, 3225);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 87, 3165, 3167)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 87, 3165, 3167);
                CallChecker.isCalled(out, ObjectOutputStream.class, 87, 3165, 3167).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 88, 3199, 3201)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 88, 3199, 3201);
                CallChecker.isCalled(out, ObjectOutputStream.class, 88, 3199, 3201).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2337.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2338 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 100, 3232, 3646);
            CallChecker.varInit(in, "in", 100, 3232, 3646);
            CallChecker.varInit(this.map, "map", 100, 3232, 3646);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 100, 3232, 3646);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 101, 3575, 3576)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 101, 3575, 3576);
                CallChecker.isCalled(in, ObjectInputStream.class, 101, 3575, 3576).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 102, 3625, 3626)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 102, 3625, 3626);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 102, 3625, 3626).readObject()));
                CallChecker.varAssign(this.map, "this.map", 102, 3607, 3640);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2338.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2339 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 107, 3653, 3822);
            CallChecker.varInit(this.map, "map", 107, 3653, 3822);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 107, 3653, 3822);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2339.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context2341 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 117, 3936, 4067);
            CallChecker.varInit(mapToCopy, "mapToCopy", 117, 3936, 4067);
            CallChecker.varInit(this.map, "map", 117, 3936, 4067);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 117, 3936, 4067);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2341.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context2343 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 127, 4180, 4544);
            CallChecker.varInit(this.map, "map", 127, 4180, 4544);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 127, 4180, 4544);
            if ((map) instanceof IterableMap) {
                MapIterator<K, V> it = CallChecker.init(MapIterator.class);
                if (CallChecker.beforeDeref(map, Map.class, 129, 4333, 4335)) {
                    map = CallChecker.beforeCalled(map, IterableMap.class, 129, 4333, 4335);
                    it = CallChecker.isCalled(((IterableMap<K, V>) (map)), IterableMap.class, 129, 4333, 4335).mapIterator();
                    CallChecker.varAssign(it, "it", 129, 4333, 4335);
                }
                return UnmodifiableMapIterator.decorate(it);
            }
            MapIterator<K, V> it = CallChecker.varInit(new EntrySetMapIterator<K, V>(map), "it", 132, 4428, 4485);
            return UnmodifiableMapIterator.decorate(it);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2343.methodEnd();
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context2344 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 137, 4551, 4714);
            CallChecker.varInit(this.map, "map", 137, 4551, 4714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 137, 4551, 4714);
            Set<Map.Entry<K, V>> set = CallChecker.varInit(super.entrySet(), "set", 138, 4614, 4657);
            return UnmodifiableEntrySet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2344.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context2345 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 143, 4721, 4847);
            CallChecker.varInit(this.map, "map", 143, 4721, 4847);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 143, 4721, 4847);
            Set<K> set = CallChecker.varInit(super.keySet(), "set", 144, 4768, 4795);
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2345.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context2346 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 149, 4854, 5003);
            CallChecker.varInit(this.map, "map", 149, 4854, 5003);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableMap.serialVersionUID", 149, 4854, 5003);
            Collection<V> coll = CallChecker.varInit(super.values(), "coll", 150, 4908, 4943);
            return UnmodifiableCollection.decorate(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2346.methodEnd();
        }
    }
}

