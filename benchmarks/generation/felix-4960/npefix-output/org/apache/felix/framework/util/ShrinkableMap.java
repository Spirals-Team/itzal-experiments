package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Set;

public class ShrinkableMap<K, V> implements Map<K, V> {
    private final Map<K, V> m_delegate;

    public ShrinkableMap(Map<K, V> delegate) {
        MethodContext _bcornu_methode_context15 = new MethodContext(null);
        try {
            m_delegate = delegate;
            CallChecker.varAssign(this.m_delegate, "this.m_delegate", 32, 1108, 1129);
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context191 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 35, 1142, 1204);
            CallChecker.varInit(this.m_delegate, "m_delegate", 35, 1142, 1204);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 37, 1181, 1190)) {
                return CallChecker.isCalled(m_delegate, Map.class, 37, 1181, 1190).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context191.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context192 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 40, 1211, 1283);
            CallChecker.varInit(this.m_delegate, "m_delegate", 40, 1211, 1283);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 42, 1257, 1266)) {
                return CallChecker.isCalled(m_delegate, Map.class, 42, 1257, 1266).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context192.methodEnd();
        }
    }

    public boolean containsKey(Object o) {
        MethodContext _bcornu_methode_context193 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 45, 1290, 1379);
            CallChecker.varInit(o, "o", 45, 1290, 1379);
            CallChecker.varInit(this.m_delegate, "m_delegate", 45, 1290, 1379);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 47, 1348, 1357)) {
                return CallChecker.isCalled(m_delegate, Map.class, 47, 1348, 1357).containsKey(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context193.methodEnd();
        }
    }

    public boolean containsValue(Object o) {
        MethodContext _bcornu_methode_context194 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 50, 1386, 1479);
            CallChecker.varInit(o, "o", 50, 1386, 1479);
            CallChecker.varInit(this.m_delegate, "m_delegate", 50, 1386, 1479);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 52, 1446, 1455)) {
                return CallChecker.isCalled(m_delegate, Map.class, 52, 1446, 1455).containsValue(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context194.methodEnd();
        }
    }

    public V get(Object o) {
        if (CallChecker.beforeDeref(m_delegate, Map.class, 57, 1530, 1539)) {
            return m_delegate.get(o);
        }else
            throw new AbnormalExecutionError();
        
    }

    public V put(K k, V v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public V remove(Object o) {
        if (CallChecker.beforeDeref(m_delegate, Map.class, 67, 1718, 1727)) {
            return m_delegate.remove(o);
        }else
            throw new AbnormalExecutionError();
        
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context198 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 70, 1751, 1886);
            CallChecker.varInit(map, "map", 70, 1751, 1886);
            CallChecker.varInit(this.m_delegate, "m_delegate", 70, 1751, 1886);
            throw new UnsupportedOperationException("Not supported yet.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context198.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context199 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 75, 1893, 1951);
            CallChecker.varInit(this.m_delegate, "m_delegate", 75, 1893, 1951);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 77, 1927, 1936)) {
                CallChecker.isCalled(m_delegate, Map.class, 77, 1927, 1936).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context199.methodEnd();
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context200 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 80, 1958, 2027);
            CallChecker.varInit(this.m_delegate, "m_delegate", 80, 1958, 2027);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 82, 2002, 2011)) {
                return CallChecker.isCalled(m_delegate, Map.class, 82, 2002, 2011).keySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context200.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context201 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 85, 2034, 2110);
            CallChecker.varInit(this.m_delegate, "m_delegate", 85, 2034, 2110);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 87, 2085, 2094)) {
                return CallChecker.isCalled(m_delegate, Map.class, 87, 2085, 2094).values();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context201.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context202 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 90, 2117, 2200);
            CallChecker.varInit(this.m_delegate, "m_delegate", 90, 2117, 2200);
            if (CallChecker.beforeDeref(m_delegate, Map.class, 92, 2173, 2182)) {
                return CallChecker.isCalled(m_delegate, Map.class, 92, 2173, 2182).entrySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context202.methodEnd();
        }
    }
}

