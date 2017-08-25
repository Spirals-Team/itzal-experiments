package org.apache.felix.framework.util;

import java.util.Set;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.AbstractMap;
import java.util.AbstractSet;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class ImmutableMap<K, V> extends AbstractMap<K, V> {
    final Map.Entry<K, V>[] entries;

    public static <K, V> ImmutableMap<K, V> newInstance(Map.Entry<K, V>... entries) {
        MethodContext _bcornu_methode_context839 = new MethodContext(ImmutableMap.class);
        try {
            CallChecker.varInit(entries, "entries", 31, 1080, 1214);
            return new ImmutableMap<K, V>(entries);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ImmutableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context839.methodEnd();
        }
    }

    public static <K, V> ImmutableMap<K, V> newInstance(Map<K, V> entries) {
        MethodContext _bcornu_methode_context840 = new MethodContext(ImmutableMap.class);
        try {
            CallChecker.varInit(entries, "entries", 36, 1221, 1501);
            if (entries instanceof ImmutableMap) {
                return ((ImmutableMap<K, V>) (entries));
            }else {
                return new ImmutableMap<K, V>(entries);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ImmutableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context840.methodEnd();
        }
    }

    protected ImmutableMap(Map.Entry<K, V>[] entries) {
        MethodContext _bcornu_methode_context72 = new MethodContext(null);
        try {
            entries = CallChecker.beforeCalled(entries, Map.Entry[].class, 50, 1583, 1589);
            this.entries = CallChecker.isCalled(entries, Map.Entry[].class, 50, 1583, 1589).clone();
            CallChecker.varAssign(this.entries, "this.entries", 50, 1568, 1598);
        } finally {
            _bcornu_methode_context72.methodEnd();
        }
    }

    protected ImmutableMap(Map<K, V> map) {
        MethodContext _bcornu_methode_context73 = new MethodContext(null);
        try {
            map = CallChecker.beforeCalled(map, Map.class, 55, 1678, 1680);
            map = CallChecker.beforeCalled(map, Map.class, 55, 1711, 1713);
            this.entries = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 55, 1678, 1680).entrySet(), Set.class, 55, 1678, 1691).toArray(new Map.Entry[CallChecker.isCalled(map, Map.class, 55, 1711, 1713).size()]);
            CallChecker.varAssign(this.entries, "this.entries", 55, 1663, 1723);
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            for (int i = 0; i < (CallChecker.isCalled(entries, Map.Entry[].class, 63, 1848, 1854).length); i++) {
                if (CallChecker.beforeDeref(entries, Map.Entry[].class, 65, 1903, 1909)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(entries, Map.Entry[].class, 65, 1903, 1909)[i], Map.Entry.class, 65, 1903, 1912)) {
                        if ((CallChecker.isCalled(entries, Map.Entry[].class, 65, 1903, 1909)[i].getKey()) == null) {
                            if (CallChecker.beforeDeref(entries, Map.Entry[].class, 67, 1977, 1983)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(entries, Map.Entry[].class, 67, 1977, 1983)[i], Map.Entry.class, 67, 1977, 1986)) {
                                    return CallChecker.isCalled(entries, Map.Entry[].class, 67, 1977, 1983)[i].getValue();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        }else {
            for (int i = 0; i < (CallChecker.isCalled(entries, Map.Entry[].class, 73, 2097, 2103).length); i++) {
                if (CallChecker.beforeDeref(entries, Map.Entry[].class, 75, 2163, 2169)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(entries, Map.Entry[].class, 75, 2163, 2169)[i], Map.Entry.class, 75, 2163, 2172)) {
                        if (key.equals(CallChecker.isCalled(entries, Map.Entry[].class, 75, 2163, 2169)[i].getKey())) {
                            if (CallChecker.beforeDeref(entries, Map.Entry[].class, 77, 2230, 2236)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(entries, Map.Entry[].class, 77, 2230, 2236)[i], Map.Entry.class, 77, 2230, 2239)) {
                                    return CallChecker.isCalled(entries, Map.Entry[].class, 77, 2230, 2236)[i].getValue();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context842 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 85, 2327, 2417);
            CallChecker.varInit(this.entries, "entries", 85, 2327, 2417);
            return new EntrySet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context842.methodEnd();
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context843 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 93, 2494, 2606);
                return new EntryItr(0);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context843.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context844 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 99, 2617, 2706);
                if (CallChecker.beforeDeref(entries, Map.Entry[].class, 101, 2682, 2688)) {
                    return CallChecker.isCalled(entries, Map.Entry[].class, 101, 2682, 2688).length;
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context844.methodEnd();
            }
        }
    }

    private class EntryItr implements Iterator<Map.Entry<K, V>> {
        int cursor;

        private EntryItr(int cursor) {
            MethodContext _bcornu_methode_context74 = new MethodContext(null);
            try {
                this.cursor = cursor;
                CallChecker.varAssign(this.cursor, "this.cursor", 111, 2861, 2881);
            } finally {
                _bcornu_methode_context74.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context845 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 114, 2902, 2982);
                CallChecker.varInit(this.cursor, "cursor", 114, 2902, 2982);
                return (cursor) != (size());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context845.methodEnd();
            }
        }

        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context846 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 119, 2993, 3075);
                CallChecker.varInit(this.cursor, "cursor", 119, 2993, 3075);
                if (CallChecker.beforeDeref(entries, Map.Entry[].class, 121, 3048, 3054)) {
                    return CallChecker.isCalled(entries, Map.Entry[].class, 121, 3048, 3054)[((cursor)++)];
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context846.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context847 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 124, 3086, 3180);
                CallChecker.varInit(this.cursor, "cursor", 124, 3086, 3180);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context847.methodEnd();
            }
        }
    }
}

