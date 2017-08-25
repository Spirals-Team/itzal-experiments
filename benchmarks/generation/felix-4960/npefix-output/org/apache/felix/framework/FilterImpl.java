package org.apache.felix.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.StringMap;
import org.osgi.framework.Filter;
import java.util.Enumeration;
import java.util.Dictionary;
import java.util.Collections;
import java.util.Collection;
import org.apache.felix.framework.capabilityset.CapabilitySet;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleRevision;
import org.apache.felix.framework.wiring.BundleCapabilityImpl;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.InvalidSyntaxException;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.ServiceReference;
import java.util.Set;
import org.apache.felix.framework.capabilityset.SimpleFilter;

public class FilterImpl implements Filter {
    private final SimpleFilter m_filter;

    public FilterImpl(String filterStr) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context118 = new MethodContext(null);
        try {
            TryContext _bcornu_try_context_328 = new TryContext(328, FilterImpl.class, "java.lang.Throwable");
            try {
                m_filter = SimpleFilter.parse(filterStr);
                CallChecker.varAssign(this.m_filter, "this.m_filter", 47, 1750, 1790);
            } catch (Throwable th) {
                _bcornu_try_context_328.catchStart(328);
                throw new InvalidSyntaxException(th.getMessage(), filterStr);
            } finally {
                _bcornu_try_context_328.finallyStart(328);
            }
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    public boolean match(ServiceReference sr) {
        MethodContext _bcornu_methode_context1152 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 55, 1936, 2247);
            CallChecker.varInit(sr, "sr", 55, 1936, 2247);
            CallChecker.varInit(this.m_filter, "m_filter", 55, 1936, 2247);
            if (sr instanceof ServiceRegistrationImpl.ServiceReferenceImpl) {
                return CapabilitySet.matches(((ServiceRegistrationImpl.ServiceReferenceImpl) (sr)), m_filter);
            }else {
                return CapabilitySet.matches(new FilterImpl.WrapperCapability(sr), m_filter);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1152.methodEnd();
        }
    }

    public boolean match(Dictionary<String, ?> dctnr) {
        MethodContext _bcornu_methode_context1153 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 67, 2254, 2400);
            CallChecker.varInit(dctnr, "dctnr", 67, 2254, 2400);
            CallChecker.varInit(this.m_filter, "m_filter", 67, 2254, 2400);
            return CapabilitySet.matches(new FilterImpl.WrapperCapability(dctnr, false), m_filter);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1153.methodEnd();
        }
    }

    public boolean matchCase(Dictionary<String, ?> dctnr) {
        MethodContext _bcornu_methode_context1154 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 72, 2407, 2556);
            CallChecker.varInit(dctnr, "dctnr", 72, 2407, 2556);
            CallChecker.varInit(this.m_filter, "m_filter", 72, 2407, 2556);
            return CapabilitySet.matches(new FilterImpl.WrapperCapability(dctnr, true), m_filter);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1154.methodEnd();
        }
    }

    public boolean matches(Map<String, ?> map) {
        MethodContext _bcornu_methode_context1155 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2563, 2692);
            CallChecker.varInit(map, "map", 77, 2563, 2692);
            CallChecker.varInit(this.m_filter, "m_filter", 77, 2563, 2692);
            return CapabilitySet.matches(new FilterImpl.WrapperCapability(map), m_filter);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1155.methodEnd();
        }
    }

    public boolean equals(Object o) {
        MethodContext _bcornu_methode_context1156 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 82, 2699, 2789);
            CallChecker.varInit(o, "o", 82, 2699, 2789);
            CallChecker.varInit(this.m_filter, "m_filter", 82, 2699, 2789);
            if (CallChecker.beforeDeref(o, Object.class, 84, 2770, 2770)) {
                final String npe_invocation_var423 = toString();
                if (CallChecker.beforeDeref(npe_invocation_var423, String.class, 84, 2752, 2761)) {
                    o = CallChecker.beforeCalled(o, Object.class, 84, 2770, 2770);
                    return CallChecker.isCalled(npe_invocation_var423, String.class, 84, 2752, 2761).equals(CallChecker.isCalled(o, Object.class, 84, 2770, 2770).toString());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1156.methodEnd();
        }
    }

    public int hashCode() {
        MethodContext _bcornu_methode_context1157 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 87, 2796, 2866);
            CallChecker.varInit(this.m_filter, "m_filter", 87, 2796, 2866);
            final String npe_invocation_var424 = toString();
            if (CallChecker.beforeDeref(npe_invocation_var424, String.class, 89, 2839, 2848)) {
                return CallChecker.isCalled(npe_invocation_var424, String.class, 89, 2839, 2848).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1157.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context1158 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 92, 2873, 2944);
            CallChecker.varInit(this.m_filter, "m_filter", 92, 2873, 2944);
            if (CallChecker.beforeDeref(m_filter, SimpleFilter.class, 94, 2919, 2926)) {
                return CallChecker.isCalled(m_filter, SimpleFilter.class, 94, 2919, 2926).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1158.methodEnd();
        }
    }

    static class WrapperCapability extends BundleCapabilityImpl {
        private final Map m_map;

        public WrapperCapability(Map map) {
            super(null, null, Collections.EMPTY_MAP, Collections.EMPTY_MAP);
            MethodContext _bcornu_methode_context119 = new MethodContext(null);
            try {
                if (map == null) {
                    m_map = Collections.EMPTY_MAP;
                    CallChecker.varAssign(this.m_map, "this.m_map", 104, 3192, 3243);
                }else {
                    m_map = map;
                    CallChecker.varAssign(this.m_map, "this.m_map", 104, 3192, 3243);
                }
            } finally {
                _bcornu_methode_context119.methodEnd();
            }
        }

        public WrapperCapability(Dictionary dict, boolean caseSensitive) {
            super(null, null, Collections.EMPTY_MAP, Collections.EMPTY_MAP);
            MethodContext _bcornu_methode_context120 = new MethodContext(null);
            try {
                m_map = new FilterImpl.DictionaryToMap(dict, caseSensitive);
                CallChecker.varAssign(this.m_map, "this.m_map", 110, 3428, 3476);
            } finally {
                _bcornu_methode_context120.methodEnd();
            }
        }

        public WrapperCapability(ServiceReference sr) {
            super(null, null, Collections.EMPTY_MAP, Collections.EMPTY_MAP);
            MethodContext _bcornu_methode_context121 = new MethodContext(null);
            try {
                m_map = new StringMap();
                CallChecker.varAssign(this.m_map, "this.m_map", 116, 3642, 3665);
                sr = CallChecker.beforeCalled(sr, ServiceReference.class, 117, 3697, 3698);
                for (String key : CallChecker.isCalled(sr, ServiceReference.class, 117, 3697, 3698).getPropertyKeys()) {
                    if (CallChecker.beforeDeref(sr, ServiceReference.class, 119, 3764, 3765)) {
                        if (CallChecker.beforeDeref(m_map, Map.class, 119, 3749, 3753)) {
                            sr = CallChecker.beforeCalled(sr, ServiceReference.class, 119, 3764, 3765);
                            CallChecker.isCalled(m_map, Map.class, 119, 3749, 3753).put(key, CallChecker.isCalled(sr, ServiceReference.class, 119, 3764, 3765).getProperty(key));
                        }
                    }
                }
            } finally {
                _bcornu_methode_context121.methodEnd();
            }
        }

        @Override
        public BundleRevision getRevision() {
            MethodContext _bcornu_methode_context1159 = new MethodContext(BundleRevision.class);
            try {
                CallChecker.varInit(this, "this", 124, 3819, 3966);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 124, 3819, 3966);
                CallChecker.varInit(this.m_map, "m_map", 124, 3819, 3966);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1159.methodEnd();
            }
        }

        @Override
        public String getNamespace() {
            MethodContext _bcornu_methode_context1160 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 130, 3977, 4117);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 130, 3977, 4117);
                CallChecker.varInit(this.m_map, "m_map", 130, 3977, 4117);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1160.methodEnd();
            }
        }

        @Override
        public Map<String, String> getDirectives() {
            MethodContext _bcornu_methode_context1161 = new MethodContext(Map.class);
            try {
                CallChecker.varInit(this, "this", 136, 4128, 4282);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 136, 4128, 4282);
                CallChecker.varInit(this.m_map, "m_map", 136, 4128, 4282);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1161.methodEnd();
            }
        }

        @Override
        public Map<String, Object> getAttributes() {
            MethodContext _bcornu_methode_context1162 = new MethodContext(Map.class);
            try {
                CallChecker.varInit(this, "this", 142, 4293, 4398);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 142, 4293, 4398);
                CallChecker.varInit(this.m_map, "m_map", 142, 4293, 4398);
                return m_map;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1162.methodEnd();
            }
        }

        @Override
        public List<String> getUses() {
            MethodContext _bcornu_methode_context1163 = new MethodContext(List.class);
            try {
                CallChecker.varInit(this, "this", 148, 4409, 4550);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 148, 4409, 4550);
                CallChecker.varInit(this.m_map, "m_map", 148, 4409, 4550);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1163.methodEnd();
            }
        }
    }

    private static class DictionaryToMap implements Map {
        private final Map m_map;

        private final Dictionary m_dict;

        public DictionaryToMap(Dictionary dict, boolean caseSensitive) {
            MethodContext _bcornu_methode_context122 = new MethodContext(null);
            try {
                if (!caseSensitive) {
                    m_dict = null;
                    CallChecker.varAssign(this.m_dict, "this.m_dict", 163, 4839, 4852);
                    m_map = new StringMap();
                    CallChecker.varAssign(this.m_map, "this.m_map", 164, 4870, 4893);
                    if (dict != null) {
                        Enumeration keys = CallChecker.varInit(dict.keys(), "keys", 167, 4967, 4997);
                        keys = CallChecker.beforeCalled(keys, Enumeration.class, 168, 5026, 5029);
                        while (CallChecker.isCalled(keys, Enumeration.class, 168, 5026, 5029).hasMoreElements()) {
                            Object key = CallChecker.init(Object.class);
                            if (CallChecker.beforeDeref(keys, Enumeration.class, 170, 5109, 5112)) {
                                keys = CallChecker.beforeCalled(keys, Enumeration.class, 170, 5109, 5112);
                                key = CallChecker.isCalled(keys, Enumeration.class, 170, 5109, 5112).nextElement();
                                CallChecker.varAssign(key, "key", 170, 5109, 5112);
                            }
                            if (CallChecker.beforeDeref(m_map, Map.class, 171, 5157, 5161)) {
                                if ((CallChecker.isCalled(m_map, Map.class, 171, 5157, 5161).get(key)) == null) {
                                    if (CallChecker.beforeDeref(m_map, Map.class, 173, 5235, 5239)) {
                                        CallChecker.isCalled(m_map, Map.class, 173, 5235, 5239).put(key, dict.get(key));
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(key, Object.class, 178, 5469, 5471)) {
                                        key = CallChecker.beforeCalled(key, Object.class, 178, 5469, 5471);
                                        throw new IllegalArgumentException(("Duplicate attribute: " + (CallChecker.isCalled(key, Object.class, 178, 5469, 5471).toString())));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        } 
                    }
                }else {
                    m_dict = dict;
                    CallChecker.varAssign(this.m_dict, "this.m_dict", 185, 5613, 5626);
                    m_map = null;
                    CallChecker.varAssign(this.m_map, "this.m_map", 186, 5644, 5656);
                }
            } finally {
                _bcornu_methode_context122.methodEnd();
            }
        }

        public int size() {
            MethodContext _bcornu_methode_context1164 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 190, 5691, 5802);
                CallChecker.varInit(this.m_dict, "m_dict", 190, 5691, 5802);
                CallChecker.varInit(this.m_map, "m_map", 190, 5691, 5802);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1164.methodEnd();
            }
        }

        public boolean isEmpty() {
            MethodContext _bcornu_methode_context1165 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 195, 5813, 5931);
                CallChecker.varInit(this.m_dict, "m_dict", 195, 5813, 5931);
                CallChecker.varInit(this.m_map, "m_map", 195, 5813, 5931);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1165.methodEnd();
            }
        }

        public boolean containsKey(Object o) {
            MethodContext _bcornu_methode_context1166 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 200, 5942, 6072);
                CallChecker.varInit(o, "o", 200, 5942, 6072);
                CallChecker.varInit(this.m_dict, "m_dict", 200, 5942, 6072);
                CallChecker.varInit(this.m_map, "m_map", 200, 5942, 6072);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1166.methodEnd();
            }
        }

        public boolean containsValue(Object o) {
            MethodContext _bcornu_methode_context1167 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 205, 6083, 6215);
                CallChecker.varInit(o, "o", 205, 6083, 6215);
                CallChecker.varInit(this.m_dict, "m_dict", 205, 6083, 6215);
                CallChecker.varInit(this.m_map, "m_map", 205, 6083, 6215);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1167.methodEnd();
            }
        }

        public Object get(Object o) {
            MethodContext _bcornu_methode_context1168 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 210, 6226, 6496);
                CallChecker.varInit(o, "o", 210, 6226, 6496);
                CallChecker.varInit(this.m_dict, "m_dict", 210, 6226, 6496);
                CallChecker.varInit(this.m_map, "m_map", 210, 6226, 6496);
                if ((m_dict) != null) {
                    return m_dict.get(o);
                }else
                    if ((m_map) != null) {
                        return m_map.get(o);
                    }
                
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1168.methodEnd();
            }
        }

        public Object put(Object k, Object v) {
            MethodContext _bcornu_methode_context1169 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 223, 6507, 6638);
                CallChecker.varInit(v, "v", 223, 6507, 6638);
                CallChecker.varInit(k, "k", 223, 6507, 6638);
                CallChecker.varInit(this.m_dict, "m_dict", 223, 6507, 6638);
                CallChecker.varInit(this.m_map, "m_map", 223, 6507, 6638);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1169.methodEnd();
            }
        }

        public Object remove(Object o) {
            MethodContext _bcornu_methode_context1170 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 228, 6649, 6773);
                CallChecker.varInit(o, "o", 228, 6649, 6773);
                CallChecker.varInit(this.m_dict, "m_dict", 228, 6649, 6773);
                CallChecker.varInit(this.m_map, "m_map", 228, 6649, 6773);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1170.methodEnd();
            }
        }

        public void putAll(Map map) {
            MethodContext _bcornu_methode_context1171 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 233, 6784, 6905);
                CallChecker.varInit(map, "map", 233, 6784, 6905);
                CallChecker.varInit(this.m_dict, "m_dict", 233, 6784, 6905);
                CallChecker.varInit(this.m_map, "m_map", 233, 6784, 6905);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1171.methodEnd();
            }
        }

        public void clear() {
            MethodContext _bcornu_methode_context1172 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 238, 6916, 7029);
                CallChecker.varInit(this.m_dict, "m_dict", 238, 6916, 7029);
                CallChecker.varInit(this.m_map, "m_map", 238, 6916, 7029);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1172.methodEnd();
            }
        }

        public Set<Object> keySet() {
            MethodContext _bcornu_methode_context1173 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 243, 7040, 7161);
                CallChecker.varInit(this.m_dict, "m_dict", 243, 7040, 7161);
                CallChecker.varInit(this.m_map, "m_map", 243, 7040, 7161);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1173.methodEnd();
            }
        }

        public Collection<Object> values() {
            MethodContext _bcornu_methode_context1174 = new MethodContext(Collection.class);
            try {
                CallChecker.varInit(this, "this", 248, 7172, 7300);
                CallChecker.varInit(this.m_dict, "m_dict", 248, 7172, 7300);
                CallChecker.varInit(this.m_map, "m_map", 248, 7172, 7300);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Collection<Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1174.methodEnd();
            }
        }

        public Set<Map.Entry<Object, Object>> entrySet() {
            MethodContext _bcornu_methode_context1175 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 253, 7311, 7416);
                CallChecker.varInit(this.m_dict, "m_dict", 253, 7311, 7416);
                CallChecker.varInit(this.m_map, "m_map", 253, 7311, 7416);
                return Collections.EMPTY_SET;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<Object, Object>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1175.methodEnd();
            }
        }
    }
}

