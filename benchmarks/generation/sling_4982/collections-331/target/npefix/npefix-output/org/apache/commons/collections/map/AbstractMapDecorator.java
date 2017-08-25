package org.apache.commons.collections.map;

import java.util.Set;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public abstract class AbstractMapDecorator<K, V> extends AbstractIterableMap<K, V> {
    protected transient Map<K, V> map;

    protected AbstractMapDecorator() {
        super();
        MethodContext _bcornu_methode_context297 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context297.methodEnd();
        }
    }

    protected AbstractMapDecorator(Map<K, V> map) {
        MethodContext _bcornu_methode_context298 = new MethodContext(null);
        try {
            if (map == null) {
                throw new IllegalArgumentException("Map must not be null");
            }
            this.map = map;
            CallChecker.varAssign(this.map, "this.map", 67, 2506, 2520);
        } finally {
            _bcornu_methode_context298.methodEnd();
        }
    }

    protected Map<K, V> decorated() {
        MethodContext _bcornu_methode_context1555 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 75, 2533, 2685);
            CallChecker.varInit(this.map, "map", 75, 2533, 2685);
            return map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1555.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context1556 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 80, 2692, 2825);
            CallChecker.varInit(this.map, "map", 80, 2692, 2825);
            final Map<K, V> npe_invocation_var300 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var300, Map.class, 81, 2800, 2810)) {
                CallChecker.isCalled(npe_invocation_var300, Map.class, 81, 2800, 2810).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1556.methodEnd();
        }
    }

    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context1557 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 84, 2832, 2922);
            CallChecker.varInit(key, "key", 84, 2832, 2922);
            CallChecker.varInit(this.map, "map", 84, 2832, 2922);
            final Map<K, V> npe_invocation_var301 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var301, Map.class, 85, 2888, 2898)) {
                return CallChecker.isCalled(npe_invocation_var301, Map.class, 85, 2888, 2898).containsKey(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1557.methodEnd();
        }
    }

    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context1558 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 88, 2929, 3027);
            CallChecker.varInit(value, "value", 88, 2929, 3027);
            CallChecker.varInit(this.map, "map", 88, 2929, 3027);
            final Map<K, V> npe_invocation_var302 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var302, Map.class, 89, 2989, 2999)) {
                return CallChecker.isCalled(npe_invocation_var302, Map.class, 89, 2989, 2999).containsValue(value);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1558.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1559 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 92, 3034, 3118);
            CallChecker.varInit(this.map, "map", 92, 3034, 3118);
            final Map<K, V> npe_invocation_var303 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var303, Map.class, 93, 3090, 3100)) {
                return CallChecker.isCalled(npe_invocation_var303, Map.class, 93, 3090, 3100).entrySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1559.methodEnd();
        }
    }

    public V get(Object key) {
        final Map<K, V> npe_invocation_var304 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var304, Map.class, 97, 3167, 3177)) {
            return npe_invocation_var304.get(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1561 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 100, 3200, 3269);
            CallChecker.varInit(this.map, "map", 100, 3200, 3269);
            final Map<K, V> npe_invocation_var305 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var305, Map.class, 101, 3242, 3252)) {
                return CallChecker.isCalled(npe_invocation_var305, Map.class, 101, 3242, 3252).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1561.methodEnd();
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1562 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 104, 3276, 3342);
            CallChecker.varInit(this.map, "map", 104, 3276, 3342);
            final Map<K, V> npe_invocation_var306 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var306, Map.class, 105, 3316, 3326)) {
                return CallChecker.isCalled(npe_invocation_var306, Map.class, 105, 3316, 3326).keySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1562.methodEnd();
        }
    }

    public V put(K key, V value) {
        final Map<K, V> npe_invocation_var307 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var307, Map.class, 109, 3395, 3405)) {
            return npe_invocation_var307.put(key, value);
        }else
            throw new AbnormalExecutionError();
        
    }

    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context1564 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 112, 3435, 3540);
            CallChecker.varInit(mapToCopy, "mapToCopy", 112, 3435, 3540);
            CallChecker.varInit(this.map, "map", 112, 3435, 3540);
            final Map<K, V> npe_invocation_var308 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var308, Map.class, 113, 3505, 3515)) {
                CallChecker.isCalled(npe_invocation_var308, Map.class, 113, 3505, 3515).putAll(mapToCopy);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1564.methodEnd();
        }
    }

    public V remove(Object key) {
        final Map<K, V> npe_invocation_var309 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var309, Map.class, 117, 3592, 3602)) {
            return npe_invocation_var309.remove(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public int size() {
        MethodContext _bcornu_methode_context1566 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 120, 3628, 3687);
            CallChecker.varInit(this.map, "map", 120, 3628, 3687);
            final Map<K, V> npe_invocation_var310 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var310, Map.class, 121, 3663, 3673)) {
                return CallChecker.isCalled(npe_invocation_var310, Map.class, 121, 3663, 3673).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1566.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context1567 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 124, 3694, 3767);
            CallChecker.varInit(this.map, "map", 124, 3694, 3767);
            final Map<K, V> npe_invocation_var311 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var311, Map.class, 125, 3741, 3751)) {
                return CallChecker.isCalled(npe_invocation_var311, Map.class, 125, 3741, 3751).values();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1567.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context1568 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 129, 3777, 3942);
            CallChecker.varInit(object, "object", 129, 3777, 3942);
            CallChecker.varInit(this.map, "map", 129, 3777, 3942);
            if (object == (this)) {
                return true;
            }
            final Map<K, V> npe_invocation_var312 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var312, Map.class, 133, 3910, 3920)) {
                return CallChecker.isCalled(npe_invocation_var312, Map.class, 133, 3910, 3920).equals(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1568.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1569 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 137, 3949, 4030);
            CallChecker.varInit(this.map, "map", 137, 3949, 4030);
            final Map<K, V> npe_invocation_var313 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var313, Map.class, 138, 4002, 4012)) {
                return CallChecker.isCalled(npe_invocation_var313, Map.class, 138, 4002, 4012).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1569.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1570 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 142, 4037, 4121);
            CallChecker.varInit(this.map, "map", 142, 4037, 4121);
            final Map<K, V> npe_invocation_var314 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var314, Map.class, 143, 4093, 4103)) {
                return CallChecker.isCalled(npe_invocation_var314, Map.class, 143, 4093, 4103).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1570.methodEnd();
        }
    }
}

