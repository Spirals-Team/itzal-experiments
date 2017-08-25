package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class MapToDictionary extends Dictionary {
    private Map m_map = null;

    public MapToDictionary(Map map) {
        MethodContext _bcornu_methode_context155 = new MethodContext(null);
        try {
            if (map == null) {
                throw new IllegalArgumentException("Source map cannot be null.");
            }
            m_map = map;
            CallChecker.varAssign(this.m_map, "this.m_map", 41, 1297, 1308);
        } finally {
            _bcornu_methode_context155.methodEnd();
        }
    }

    public Enumeration elements() {
        MethodContext _bcornu_methode_context1555 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 44, 1321, 1417);
            CallChecker.varInit(this.m_map, "m_map", 44, 1321, 1417);
            if (CallChecker.beforeDeref(m_map, Map.class, 46, 1396, 1400)) {
                m_map = CallChecker.beforeCalled(m_map, Map.class, 46, 1396, 1400);
                return Collections.enumeration(CallChecker.isCalled(m_map, Map.class, 46, 1396, 1400).values());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1555.methodEnd();
        }
    }

    public Object get(Object key) {
        MethodContext _bcornu_methode_context1556 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 49, 1424, 1495);
            CallChecker.varInit(key, "key", 49, 1424, 1495);
            CallChecker.varInit(this.m_map, "m_map", 49, 1424, 1495);
            if (CallChecker.beforeDeref(m_map, Map.class, 51, 1475, 1479)) {
                m_map = CallChecker.beforeCalled(m_map, Map.class, 51, 1475, 1479);
                return CallChecker.isCalled(m_map, Map.class, 51, 1475, 1479).get(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1556.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1557 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 54, 1502, 1569);
            CallChecker.varInit(this.m_map, "m_map", 54, 1502, 1569);
            if (CallChecker.beforeDeref(m_map, Map.class, 56, 1548, 1552)) {
                m_map = CallChecker.beforeCalled(m_map, Map.class, 56, 1548, 1552);
                return CallChecker.isCalled(m_map, Map.class, 56, 1548, 1552).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1557.methodEnd();
        }
    }

    public Enumeration keys() {
        MethodContext _bcornu_methode_context1558 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 59, 1576, 1668);
            CallChecker.varInit(this.m_map, "m_map", 59, 1576, 1668);
            if (CallChecker.beforeDeref(m_map, Map.class, 61, 1647, 1651)) {
                m_map = CallChecker.beforeCalled(m_map, Map.class, 61, 1647, 1651);
                return Collections.enumeration(CallChecker.isCalled(m_map, Map.class, 61, 1647, 1651).keySet());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1558.methodEnd();
        }
    }

    public Object put(Object key, Object value) {
        MethodContext _bcornu_methode_context1559 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 64, 1675, 1780);
            CallChecker.varInit(value, "value", 64, 1675, 1780);
            CallChecker.varInit(key, "key", 64, 1675, 1780);
            CallChecker.varInit(this.m_map, "m_map", 64, 1675, 1780);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1559.methodEnd();
        }
    }

    public Object remove(Object key) {
        MethodContext _bcornu_methode_context1560 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 69, 1787, 1881);
            CallChecker.varInit(key, "key", 69, 1787, 1881);
            CallChecker.varInit(this.m_map, "m_map", 69, 1787, 1881);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1560.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context1561 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 74, 1888, 1945);
            CallChecker.varInit(this.m_map, "m_map", 74, 1888, 1945);
            if (CallChecker.beforeDeref(m_map, Map.class, 76, 1927, 1931)) {
                m_map = CallChecker.beforeCalled(m_map, Map.class, 76, 1927, 1931);
                return CallChecker.isCalled(m_map, Map.class, 76, 1927, 1931).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1561.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context1562 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 79, 1952, 2020);
            CallChecker.varInit(this.m_map, "m_map", 79, 1952, 2020);
            if (CallChecker.beforeDeref(m_map, Map.class, 81, 1998, 2002)) {
                m_map = CallChecker.beforeCalled(m_map, Map.class, 81, 1998, 2002);
                return CallChecker.isCalled(m_map, Map.class, 81, 1998, 2002).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1562.methodEnd();
        }
    }
}

