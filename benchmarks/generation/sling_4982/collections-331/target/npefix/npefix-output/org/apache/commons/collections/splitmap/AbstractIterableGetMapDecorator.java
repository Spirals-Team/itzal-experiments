package org.apache.commons.collections.splitmap;

import java.util.Set;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import org.apache.commons.collections.map.EntrySetToMapIteratorAdapter;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.IterableGet;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class AbstractIterableGetMapDecorator<K, V> implements IterableGet<K, V> {
    protected transient Map<K, V> map;

    public AbstractIterableGetMapDecorator(Map<K, V> decorated) {
        MethodContext _bcornu_methode_context7 = new MethodContext(null);
        try {
            this.map = decorated;
            CallChecker.varAssign(this.map, "this.map", 47, 1756, 1776);
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    protected AbstractIterableGetMapDecorator() {
        super();
        MethodContext _bcornu_methode_context8 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    protected Map<K, V> decorated() {
        MethodContext _bcornu_methode_context27 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 62, 1950, 2101);
            CallChecker.varInit(this.map, "map", 62, 1950, 2101);
            return map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context28 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 69, 2108, 2235);
            CallChecker.varInit(key, "key", 69, 2108, 2235);
            CallChecker.varInit(this.map, "map", 69, 2108, 2235);
            final Map<K, V> npe_invocation_var18 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var18, Map.class, 70, 2201, 2211)) {
                return CallChecker.isCalled(npe_invocation_var18, Map.class, 70, 2201, 2211).containsKey(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context29 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 76, 2242, 2377);
            CallChecker.varInit(value, "value", 76, 2242, 2377);
            CallChecker.varInit(this.map, "map", 76, 2242, 2377);
            final Map<K, V> npe_invocation_var19 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var19, Map.class, 77, 2339, 2349)) {
                return CallChecker.isCalled(npe_invocation_var19, Map.class, 77, 2339, 2349).containsValue(value);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context30 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 83, 2384, 2505);
            CallChecker.varInit(this.map, "map", 83, 2384, 2505);
            final Map<K, V> npe_invocation_var20 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var20, Map.class, 84, 2477, 2487)) {
                return CallChecker.isCalled(npe_invocation_var20, Map.class, 84, 2477, 2487).entrySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public V get(Object key) {
        final Map<K, V> npe_invocation_var21 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var21, Map.class, 91, 2591, 2601)) {
            return npe_invocation_var21.get(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public V remove(Object key) {
        final Map<K, V> npe_invocation_var22 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var22, Map.class, 98, 2706, 2716)) {
            return npe_invocation_var22.remove(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context33 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 104, 2742, 2848);
            CallChecker.varInit(this.map, "map", 104, 2742, 2848);
            final Map<K, V> npe_invocation_var23 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var23, Map.class, 105, 2821, 2831)) {
                return CallChecker.isCalled(npe_invocation_var23, Map.class, 105, 2821, 2831).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context34 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 111, 2855, 2958);
            CallChecker.varInit(this.map, "map", 111, 2855, 2958);
            final Map<K, V> npe_invocation_var24 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var24, Map.class, 112, 2932, 2942)) {
                return CallChecker.isCalled(npe_invocation_var24, Map.class, 112, 2932, 2942).keySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context35 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 118, 2965, 3061);
            CallChecker.varInit(this.map, "map", 118, 2965, 3061);
            final Map<K, V> npe_invocation_var25 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var25, Map.class, 119, 3037, 3047)) {
                return CallChecker.isCalled(npe_invocation_var25, Map.class, 119, 3037, 3047).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context36 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 125, 3068, 3178);
            CallChecker.varInit(this.map, "map", 125, 3068, 3178);
            final Map<K, V> npe_invocation_var26 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var26, Map.class, 126, 3152, 3162)) {
                return CallChecker.isCalled(npe_invocation_var26, Map.class, 126, 3152, 3162).values();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context37 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 133, 3185, 3386);
            CallChecker.varInit(this.map, "map", 133, 3185, 3386);
            return new EntrySetToMapIteratorAdapter<K, V>(entrySet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context38 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 141, 3393, 3595);
            CallChecker.varInit(object, "object", 141, 3393, 3595);
            CallChecker.varInit(this.map, "map", 141, 3393, 3595);
            if (object == (this)) {
                return true;
            }
            final Map<K, V> npe_invocation_var27 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var27, Map.class, 145, 3563, 3573)) {
                return CallChecker.isCalled(npe_invocation_var27, Map.class, 145, 3563, 3573).equals(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context39 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 152, 3602, 3720);
            CallChecker.varInit(this.map, "map", 152, 3602, 3720);
            final Map<K, V> npe_invocation_var28 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var28, Map.class, 153, 3692, 3702)) {
                return CallChecker.isCalled(npe_invocation_var28, Map.class, 153, 3692, 3702).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context40 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 160, 3727, 3848);
            CallChecker.varInit(this.map, "map", 160, 3727, 3848);
            final Map<K, V> npe_invocation_var29 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var29, Map.class, 161, 3820, 3830)) {
                return CallChecker.isCalled(npe_invocation_var29, Map.class, 161, 3820, 3830).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }
}

