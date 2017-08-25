package org.apache.commons.collections.map;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.Unmodifiable;
import java.util.Set;
import java.io.Serializable;
import org.apache.commons.collections.OrderedMapIterator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.collections.OrderedMap;

public final class UnmodifiableOrderedMap<K, V> extends AbstractOrderedMapDecorator<K, V> implements Serializable , Unmodifiable {
    private static final long serialVersionUID = 8136428161720526266L;

    public static <K, V> OrderedMap<K, V> decorate(OrderedMap<K, V> map) {
        MethodContext _bcornu_methode_context1677 = new MethodContext(OrderedMap.class);
        try {
            CallChecker.varInit(map, "map", 58, 2061, 2463);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 58, 2061, 2463);
            if (map instanceof Unmodifiable) {
                return map;
            }
            return new UnmodifiableOrderedMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1677.methodEnd();
        }
    }

    private UnmodifiableOrderedMap(OrderedMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context324 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context324.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1678 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 2814, 3205);
            CallChecker.varInit(out, "out", 84, 2814, 3205);
            CallChecker.varInit(this.map, "map", 84, 2814, 3205);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 84, 2814, 3205);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 85, 3145, 3147)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 85, 3145, 3147);
                CallChecker.isCalled(out, ObjectOutputStream.class, 85, 3145, 3147).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 86, 3179, 3181)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 86, 3179, 3181);
                CallChecker.isCalled(out, ObjectOutputStream.class, 86, 3179, 3181).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1678.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1679 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 98, 3212, 3687);
            CallChecker.varInit(in, "in", 98, 3212, 3687);
            CallChecker.varInit(this.map, "map", 98, 3212, 3687);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 98, 3212, 3687);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 99, 3609, 3610)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 99, 3609, 3610);
                CallChecker.isCalled(in, ObjectInputStream.class, 99, 3609, 3610).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 100, 3659, 3660)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 100, 3659, 3660);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 100, 3659, 3660).readObject()));
                CallChecker.varAssign(this.map, "this.map", 100, 3641, 3674);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1679.methodEnd();
        }
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1680 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 105, 3694, 3963);
            CallChecker.varInit(this.map, "map", 105, 3694, 3963);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 105, 3694, 3963);
            final OrderedMap<K, V> npe_invocation_var332 = decorated();
            OrderedMapIterator<K, V> it = CallChecker.init(OrderedMapIterator.class);
            if (CallChecker.beforeDeref(npe_invocation_var332, OrderedMap.class, 106, 3872, 3882)) {
                it = CallChecker.isCalled(npe_invocation_var332, OrderedMap.class, 106, 3872, 3882).mapIterator();
                CallChecker.varAssign(it, "it", 106, 3872, 3882);
            }
            return UnmodifiableOrderedMapIterator.decorate(it);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1680.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1681 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 111, 3970, 4061);
            CallChecker.varInit(this.map, "map", 111, 3970, 4061);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 111, 3970, 4061);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1681.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context1683 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 121, 4175, 4306);
            CallChecker.varInit(mapToCopy, "mapToCopy", 121, 4175, 4306);
            CallChecker.varInit(this.map, "map", 121, 4175, 4306);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 121, 4175, 4306);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1683.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1685 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 131, 4419, 4582);
            CallChecker.varInit(this.map, "map", 131, 4419, 4582);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 131, 4419, 4582);
            Set<Map.Entry<K, V>> set = CallChecker.varInit(super.entrySet(), "set", 132, 4482, 4525);
            return UnmodifiableEntrySet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1685.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1686 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 137, 4589, 4715);
            CallChecker.varInit(this.map, "map", 137, 4589, 4715);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 137, 4589, 4715);
            Set<K> set = CallChecker.varInit(super.keySet(), "set", 138, 4636, 4663);
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1686.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context1687 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 143, 4722, 4871);
            CallChecker.varInit(this.map, "map", 143, 4722, 4871);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableOrderedMap.serialVersionUID", 143, 4722, 4871);
            Collection<V> coll = CallChecker.varInit(super.values(), "coll", 144, 4776, 4811);
            return UnmodifiableCollection.decorate(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1687.methodEnd();
        }
    }
}

