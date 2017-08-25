package org.apache.commons.collections.map;

import org.apache.commons.collections.IterableMap;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
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
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.set.UnmodifiableSet;

public class FixedSizeMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable , Map<K, V> , BoundedMap<K, V> {
    private static final long serialVersionUID = 7450927208116179316L;

    public static <K, V> IterableMap<K, V> decorate(Map<K, V> map) {
        MethodContext _bcornu_methode_context1958 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(map, "map", 72, 2762, 3061);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 72, 2762, 3061);
            return new FixedSizeMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1958.methodEnd();
        }
    }

    protected FixedSizeMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context381 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context381.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1959 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 95, 3397, 3788);
            CallChecker.varInit(out, "out", 95, 3397, 3788);
            CallChecker.varInit(this.map, "map", 95, 3397, 3788);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 95, 3397, 3788);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 96, 3728, 3730)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 96, 3728, 3730);
                CallChecker.isCalled(out, ObjectOutputStream.class, 96, 3728, 3730).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 97, 3762, 3764)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 97, 3762, 3764);
                CallChecker.isCalled(out, ObjectOutputStream.class, 97, 3762, 3764).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1959.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1960 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 109, 3795, 4270);
            CallChecker.varInit(in, "in", 109, 3795, 4270);
            CallChecker.varInit(this.map, "map", 109, 3795, 4270);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 109, 3795, 4270);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 110, 4192, 4193)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 110, 4192, 4193);
                CallChecker.isCalled(in, ObjectInputStream.class, 110, 4192, 4193).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 111, 4242, 4243)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 111, 4242, 4243);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 111, 4242, 4243).readObject()));
                CallChecker.varAssign(this.map, "this.map", 111, 4224, 4257);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1960.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        if (CallChecker.beforeDeref(map, Map.class, 117, 4412, 4414)) {
            map = CallChecker.beforeCalled(map, Map.class, 117, 4412, 4414);
            if ((CallChecker.isCalled(map, Map.class, 117, 4412, 4414).containsKey(key)) == false) {
                throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(map, Map.class, 120, 4571, 4573)) {
            return map.put(key, value);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context1962 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 124, 4603, 4923);
            CallChecker.varInit(mapToCopy, "mapToCopy", 124, 4603, 4923);
            CallChecker.varInit(this.map, "map", 124, 4603, 4923);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 124, 4603, 4923);
            mapToCopy = CallChecker.beforeCalled(mapToCopy, Map.class, 125, 4700, 4708);
            for (K key : CallChecker.isCalled(mapToCopy, Map.class, 125, 4700, 4708).keySet()) {
                if (!(containsKey(key))) {
                    throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
                }
            }
            if (CallChecker.beforeDeref(map, Map.class, 130, 4896, 4898)) {
                map = CallChecker.beforeCalled(map, Map.class, 130, 4896, 4898);
                CallChecker.isCalled(map, Map.class, 130, 4896, 4898).putAll(mapToCopy);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1962.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1963 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 134, 4930, 5040);
            CallChecker.varInit(this.map, "map", 134, 4930, 5040);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 134, 4930, 5040);
            throw new UnsupportedOperationException("Map is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1963.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1965 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 144, 5172, 5408);
            CallChecker.varInit(this.map, "map", 144, 5172, 5408);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 144, 5172, 5408);
            Set<Map.Entry<K, V>> set = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(map, Map.class, 145, 5262, 5264)) {
                map = CallChecker.beforeCalled(map, Map.class, 145, 5262, 5264);
                set = CallChecker.isCalled(map, Map.class, 145, 5262, 5264).entrySet();
                CallChecker.varAssign(set, "set", 145, 5262, 5264);
            }
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1965.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1966 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 151, 5415, 5539);
            CallChecker.varInit(this.map, "map", 151, 5415, 5539);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 151, 5415, 5539);
            Set<K> set = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(map, Map.class, 152, 5475, 5477)) {
                map = CallChecker.beforeCalled(map, Map.class, 152, 5475, 5477);
                set = CallChecker.isCalled(map, Map.class, 152, 5475, 5477).keySet();
                CallChecker.varAssign(set, "set", 152, 5475, 5477);
            }
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1966.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context1967 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 157, 5546, 5693);
            CallChecker.varInit(this.map, "map", 157, 5546, 5693);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 157, 5546, 5693);
            Collection<V> coll = CallChecker.init(Collection.class);
            if (CallChecker.beforeDeref(map, Map.class, 158, 5621, 5623)) {
                map = CallChecker.beforeCalled(map, Map.class, 158, 5621, 5623);
                coll = CallChecker.isCalled(map, Map.class, 158, 5621, 5623).values();
                CallChecker.varAssign(coll, "coll", 158, 5621, 5623);
            }
            return UnmodifiableCollection.decorate(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1967.methodEnd();
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context1968 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 162, 5700, 5751);
            CallChecker.varInit(this.map, "map", 162, 5700, 5751);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 162, 5700, 5751);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1968.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context1969 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 166, 5758, 5808);
            CallChecker.varInit(this.map, "map", 166, 5758, 5808);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.FixedSizeMap.serialVersionUID", 166, 5758, 5808);
            return size();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1969.methodEnd();
        }
    }
}

