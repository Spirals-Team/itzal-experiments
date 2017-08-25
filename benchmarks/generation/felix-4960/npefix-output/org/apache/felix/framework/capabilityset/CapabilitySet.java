package org.apache.felix.framework.capabilityset;

import org.apache.felix.framework.util.VersionRange;
import org.osgi.framework.Version;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.StringComparator;
import java.util.SortedMap;
import java.util.Set;
import org.apache.felix.framework.util.SecureAction;
import java.io.PrintStream;
import org.osgi.resource.Capability;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleRevision;
import org.apache.felix.framework.wiring.BundleCapabilityImpl;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.Bundle;
import java.util.ArrayList;
import java.lang.reflect.Array;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class CapabilitySet {
    private final SortedMap<String, Map<Object, Set<BundleCapability>>> m_indices;

    private final Set<Capability> m_capSet = Collections.newSetFromMap(new ConcurrentHashMap<Capability, Boolean>());

    private static final SecureAction m_secureAction = new SecureAction();

    public void dump() {
        MethodContext _bcornu_methode_context754 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 52, 2066, 3094);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 52, 2066, 3094);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 52, 2066, 3094);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 52, 2066, 3094);
            CallChecker.varInit(this.m_capSet, "m_capSet", 52, 2066, 3094);
            CallChecker.varInit(this.m_indices, "m_indices", 52, 2066, 3094);
            for (Map.Entry<String, Map<Object, Set<BundleCapability>>> entry : CallChecker.isCalled(m_indices, SortedMap.class, 54, 2162, 2170).entrySet()) {
                boolean header1 = CallChecker.varInit(((boolean) (false)), "header1", 56, 2206, 2229);
                for (Map.Entry<Object, Set<BundleCapability>> entry2 : CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 57, 2294, 2298).getValue(), Map.class, 57, 2294, 2309).entrySet()) {
                    boolean header2 = CallChecker.varInit(((boolean) (false)), "header2", 59, 2353, 2376);
                    for (BundleCapability cap : CallChecker.isCalled(entry2, Map.Entry.class, 60, 2422, 2427).getValue()) {
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 62, 2483, 2485)) {
                            final BundleRevision npe_invocation_var237 = CallChecker.isCalled(cap, BundleCapability.class, 62, 2483, 2485).getRevision();
                            if (CallChecker.beforeDeref(npe_invocation_var237, BundleRevision.class, 62, 2483, 2499)) {
                                final Bundle npe_invocation_var238 = CallChecker.isCalled(npe_invocation_var237, BundleRevision.class, 62, 2483, 2499).getBundle();
                                if (CallChecker.beforeDeref(npe_invocation_var238, Bundle.class, 62, 2483, 2511)) {
                                    if ((CallChecker.isCalled(npe_invocation_var238, Bundle.class, 62, 2483, 2511).getBundleId()) != 0) {
                                        if (!header1) {
                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 66, 2666, 2670)) {
                                                if (CallChecker.beforeDeref(System.out, PrintStream.class, 66, 2647, 2656)) {
                                                    CallChecker.isCalled(System.out, PrintStream.class, 66, 2647, 2656).println(((CallChecker.isCalled(entry, Map.Entry.class, 66, 2666, 2670).getKey()) + ":"));
                                                }
                                            }
                                            header1 = true;
                                            CallChecker.varAssign(header1, "header1", 67, 2717, 2731);
                                        }
                                        if (!header2) {
                                            if (CallChecker.beforeDeref(entry2, Map.Entry.class, 71, 2878, 2883)) {
                                                if (CallChecker.beforeDeref(System.out, PrintStream.class, 71, 2851, 2860)) {
                                                    CallChecker.isCalled(System.out, PrintStream.class, 71, 2851, 2860).println(("   " + (CallChecker.isCalled(entry2, Map.Entry.class, 71, 2878, 2883).getKey())));
                                                }
                                            }
                                            header2 = true;
                                            CallChecker.varAssign(header2, "header2", 72, 2924, 2938);
                                        }
                                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 74, 2990, 2999)) {
                                            CallChecker.isCalled(System.out, PrintStream.class, 74, 2990, 2999).println(("      " + cap));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context754.methodEnd();
        }
    }

    public CapabilitySet(final List<String> indexProps, final boolean caseSensitive) {
        MethodContext _bcornu_methode_context56 = new MethodContext(null);
        try {
            if (caseSensitive) {
                m_indices = new ConcurrentSkipListMap<String, Map<Object, Set<BundleCapability>>>();
                CallChecker.varAssign(this.m_indices, "this.m_indices", 83, 3196, 3439);
            }else {
                m_indices = new ConcurrentSkipListMap<String, Map<Object, Set<BundleCapability>>>(StringComparator.COMPARATOR);
                CallChecker.varAssign(this.m_indices, "this.m_indices", 83, 3196, 3439);
            }
            for (int i = 0; (indexProps != null) && (i < (CallChecker.isCalled(indexProps, List.class, 87, 3494, 3503).size())); i++) {
                if (CallChecker.beforeDeref(m_indices, SortedMap.class, 89, 3541, 3549)) {
                    CallChecker.isCalled(m_indices, SortedMap.class, 89, 3541, 3549).put(indexProps.get(i), new ConcurrentHashMap<Object, Set<BundleCapability>>());
                }
            }
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public void addCapability(final BundleCapability cap) {
        MethodContext _bcornu_methode_context755 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 94, 3669, 4721);
            CallChecker.varInit(cap, "cap", 94, 3669, 4721);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 94, 3669, 4721);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 94, 3669, 4721);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 94, 3669, 4721);
            CallChecker.varInit(this.m_capSet, "m_capSet", 94, 3669, 4721);
            CallChecker.varInit(this.m_indices, "m_indices", 94, 3669, 4721);
            if (CallChecker.beforeDeref(m_capSet, Set.class, 96, 3737, 3744)) {
                CallChecker.isCalled(m_capSet, Set.class, 96, 3737, 3744).add(cap);
            }
            for (Map.Entry<String, Map<Object, Set<BundleCapability>>> entry : CallChecker.isCalled(m_indices, SortedMap.class, 99, 3857, 3865).entrySet()) {
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(cap, BundleCapability.class, 101, 3916, 3918)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 101, 3940, 3944)) {
                        final Map<String, Object> npe_invocation_var239 = CallChecker.isCalled(cap, BundleCapability.class, 101, 3916, 3918).getAttributes();
                        if (CallChecker.beforeDeref(npe_invocation_var239, Map.class, 101, 3916, 3934)) {
                            value = CallChecker.isCalled(npe_invocation_var239, Map.class, 101, 3916, 3934).get(CallChecker.isCalled(entry, Map.Entry.class, 101, 3940, 3944).getKey());
                            CallChecker.varAssign(value, "value", 101, 3916, 3918);
                        }
                    }
                }
                if (value != null) {
                    value = CallChecker.beforeCalled(value, Object.class, 104, 4022, 4026);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(value, Object.class, 104, 4022, 4026).getClass(), Class.class, 104, 4022, 4037)) {
                        if (CallChecker.isCalled(value.getClass(), Class.class, 104, 4022, 4037).isArray()) {
                            value = CapabilitySet.convertArrayToList(value);
                            CallChecker.varAssign(value, "value", 106, 4088, 4121);
                        }
                    }
                    ConcurrentMap<Object, Set<BundleCapability>> index = CallChecker.init(ConcurrentMap.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 110, 4282, 4286)) {
                        index = ((ConcurrentMap<Object, Set<BundleCapability>>) (CallChecker.isCalled(entry, Map.Entry.class, 110, 4282, 4286).getValue()));
                        CallChecker.varAssign(index, "index", 110, 4282, 4286);
                    }
                    if (value instanceof Collection) {
                        Collection c = CallChecker.varInit(((Collection) (value)), "c", 114, 4388, 4421);
                        if (CallChecker.beforeDeref(c, void.class, 115, 4459, 4459)) {
                            for (Object o : c) {
                                indexCapability(index, cap, o);
                            }
                        }
                    }else {
                        indexCapability(index, cap, value);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context755.methodEnd();
        }
    }

    private void indexCapability(ConcurrentMap<Object, Set<BundleCapability>> index, BundleCapability cap, Object capValue) {
        MethodContext _bcornu_methode_context756 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 128, 4728, 5138);
            CallChecker.varInit(capValue, "capValue", 128, 4728, 5138);
            CallChecker.varInit(cap, "cap", 128, 4728, 5138);
            CallChecker.varInit(index, "index", 128, 4728, 5138);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 128, 4728, 5138);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 128, 4728, 5138);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 128, 4728, 5138);
            CallChecker.varInit(this.m_capSet, "m_capSet", 128, 4728, 5138);
            CallChecker.varInit(this.m_indices, "m_indices", 128, 4728, 5138);
            Set<BundleCapability> caps = CallChecker.varInit(Collections.newSetFromMap(new ConcurrentHashMap<BundleCapability, Boolean>()), "caps", 131, 4871, 4977);
            Set<BundleCapability> prevval = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(index, ConcurrentMap.class, 132, 5019, 5023)) {
                index = CallChecker.beforeCalled(index, ConcurrentMap.class, 132, 5019, 5023);
                prevval = CallChecker.isCalled(index, ConcurrentMap.class, 132, 5019, 5023).putIfAbsent(capValue, caps);
                CallChecker.varAssign(prevval, "prevval", 132, 5019, 5023);
            }
            if (prevval != null) {
                caps = prevval;
                CallChecker.varAssign(caps, "caps", 134, 5095, 5109);
            }
            if (CallChecker.beforeDeref(caps, Set.class, 135, 5119, 5122)) {
                caps = CallChecker.beforeCalled(caps, Set.class, 135, 5119, 5122);
                CallChecker.isCalled(caps, Set.class, 135, 5119, 5122).add(cap);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context756.methodEnd();
        }
    }

    public void removeCapability(final BundleCapability cap) {
        MethodContext _bcornu_methode_context757 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 138, 5145, 6216);
            CallChecker.varInit(cap, "cap", 138, 5145, 6216);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 138, 5145, 6216);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 138, 5145, 6216);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 138, 5145, 6216);
            CallChecker.varInit(this.m_capSet, "m_capSet", 138, 5145, 6216);
            CallChecker.varInit(this.m_indices, "m_indices", 138, 5145, 6216);
            if (CallChecker.beforeDeref(m_capSet, Set.class, 140, 5220, 5227)) {
                if (CallChecker.isCalled(m_capSet, Set.class, 140, 5220, 5227).remove(cap)) {
                    for (Map.Entry<String, Map<Object, Set<BundleCapability>>> entry : CallChecker.isCalled(m_indices, SortedMap.class, 142, 5327, 5335).entrySet()) {
                        Object value = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 144, 5394, 5396)) {
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 144, 5418, 5422)) {
                                final Map<String, Object> npe_invocation_var240 = CallChecker.isCalled(cap, BundleCapability.class, 144, 5394, 5396).getAttributes();
                                if (CallChecker.beforeDeref(npe_invocation_var240, Map.class, 144, 5394, 5412)) {
                                    value = CallChecker.isCalled(npe_invocation_var240, Map.class, 144, 5394, 5412).get(CallChecker.isCalled(entry, Map.Entry.class, 144, 5418, 5422).getKey());
                                    CallChecker.varAssign(value, "value", 144, 5394, 5396);
                                }
                            }
                        }
                        if (value != null) {
                            value = CallChecker.beforeCalled(value, Object.class, 147, 5512, 5516);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(value, Object.class, 147, 5512, 5516).getClass(), Class.class, 147, 5512, 5527)) {
                                if (CallChecker.isCalled(value.getClass(), Class.class, 147, 5512, 5527).isArray()) {
                                    value = CapabilitySet.convertArrayToList(value);
                                    CallChecker.varAssign(value, "value", 149, 5586, 5619);
                                }
                            }
                            Map<Object, Set<BundleCapability>> index = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 152, 5707, 5711)) {
                                index = CallChecker.isCalled(entry, Map.Entry.class, 152, 5707, 5711).getValue();
                                CallChecker.varAssign(index, "index", 152, 5707, 5711);
                            }
                            if (value instanceof Collection) {
                                Collection c = CallChecker.varInit(((Collection) (value)), "c", 156, 5825, 5858);
                                if (CallChecker.beforeDeref(c, void.class, 157, 5900, 5900)) {
                                    for (Object o : c) {
                                        deindexCapability(index, cap, o);
                                    }
                                }
                            }else {
                                deindexCapability(index, cap, value);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context757.methodEnd();
        }
    }

    private void deindexCapability(Map<Object, Set<BundleCapability>> index, BundleCapability cap, Object value) {
        MethodContext _bcornu_methode_context758 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 171, 6223, 6579);
            CallChecker.varInit(value, "value", 171, 6223, 6579);
            CallChecker.varInit(cap, "cap", 171, 6223, 6579);
            CallChecker.varInit(index, "index", 171, 6223, 6579);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 171, 6223, 6579);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 171, 6223, 6579);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 171, 6223, 6579);
            CallChecker.varInit(this.m_capSet, "m_capSet", 171, 6223, 6579);
            CallChecker.varInit(this.m_indices, "m_indices", 171, 6223, 6579);
            Set<BundleCapability> caps = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(index, Map.class, 174, 6384, 6388)) {
                index = CallChecker.beforeCalled(index, Map.class, 174, 6384, 6388);
                caps = CallChecker.isCalled(index, Map.class, 174, 6384, 6388).get(value);
                CallChecker.varAssign(caps, "caps", 174, 6384, 6388);
            }
            if (caps != null) {
                caps.remove(cap);
                if (caps.isEmpty()) {
                    if (CallChecker.beforeDeref(index, Map.class, 180, 6530, 6534)) {
                        index = CallChecker.beforeCalled(index, Map.class, 180, 6530, 6534);
                        CallChecker.isCalled(index, Map.class, 180, 6530, 6534).remove(value);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context758.methodEnd();
        }
    }

    public Set<Capability> match(final SimpleFilter sf, final boolean obeyMandatory) {
        MethodContext _bcornu_methode_context759 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 185, 6586, 6834);
            CallChecker.varInit(obeyMandatory, "obeyMandatory", 185, 6586, 6834);
            CallChecker.varInit(sf, "sf", 185, 6586, 6834);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 185, 6586, 6834);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 185, 6586, 6834);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 185, 6586, 6834);
            CallChecker.varInit(this.m_capSet, "m_capSet", 185, 6586, 6834);
            CallChecker.varInit(this.m_indices, "m_indices", 185, 6586, 6834);
            final Set<Capability> matches = CallChecker.varInit(match(m_capSet, sf), "matches", 187, 6681, 6732);
            if (obeyMandatory) {
                return CapabilitySet.matchMandatory(matches, sf);
            }else {
                return matches;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context759.methodEnd();
        }
    }

    private Set<Capability> match(Set<Capability> caps, final SimpleFilter sf) {
        MethodContext _bcornu_methode_context760 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 193, 6841, 9742);
            CallChecker.varInit(sf, "sf", 193, 6841, 9742);
            CallChecker.varInit(caps, "caps", 193, 6841, 9742);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 193, 6841, 9742);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 193, 6841, 9742);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 193, 6841, 9742);
            CallChecker.varInit(this.m_capSet, "m_capSet", 193, 6841, 9742);
            CallChecker.varInit(this.m_indices, "m_indices", 193, 6841, 9742);
            Set<Capability> matches = CallChecker.varInit(Collections.newSetFromMap(new ConcurrentHashMap<Capability, Boolean>()), "matches", 195, 6930, 7027);
            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 197, 7042, 7043)) {
                if ((CallChecker.isCalled(sf, SimpleFilter.class, 197, 7042, 7043).getOperation()) == (SimpleFilter.MATCH_ALL)) {
                    if (CallChecker.beforeDeref(matches, Set.class, 199, 7109, 7115)) {
                        matches = CallChecker.beforeCalled(matches, Set.class, 199, 7109, 7115);
                        CallChecker.isCalled(matches, Set.class, 199, 7109, 7115).addAll(caps);
                    }
                }else
                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 201, 7158, 7159)) {
                        if ((CallChecker.isCalled(sf, SimpleFilter.class, 201, 7158, 7159).getOperation()) == (SimpleFilter.AND)) {
                            final List<SimpleFilter> sfs = CallChecker.varInit(((List<SimpleFilter>) (CallChecker.isCalled(sf, SimpleFilter.class, 207, 7527, 7528).getValue())), "sfs", 207, 7219, 7540);
                            caps = CallChecker.beforeCalled(caps, Set.class, 208, 7571, 7574);
                            for (int i = 0; ((CallChecker.isCalled(caps, Set.class, 208, 7571, 7574).size()) > 0) && (i < (CallChecker.isCalled(sfs, List.class, 208, 7596, 7598).size())); i++) {
                                if (CallChecker.beforeDeref(sfs, List.class, 210, 7666, 7668)) {
                                    matches = match(caps, CallChecker.isCalled(sfs, List.class, 210, 7666, 7668).get(i));
                                    CallChecker.varAssign(matches, "matches", 210, 7644, 7677);
                                }
                                caps = matches;
                                CallChecker.varAssign(caps, "caps", 211, 7695, 7709);
                            }
                        }else
                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 214, 7752, 7753)) {
                                if ((CallChecker.isCalled(sf, SimpleFilter.class, 214, 7752, 7753).getOperation()) == (SimpleFilter.OR)) {
                                    List<SimpleFilter> sfs = CallChecker.init(List.class);
                                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 218, 7997, 7998)) {
                                        sfs = ((List<SimpleFilter>) (CallChecker.isCalled(sf, SimpleFilter.class, 218, 7997, 7998).getValue()));
                                        CallChecker.varAssign(sfs, "sfs", 218, 7997, 7998);
                                    }
                                    sfs = CallChecker.beforeCalled(sfs, List.class, 219, 8044, 8046);
                                    for (int i = 0; i < (CallChecker.isCalled(sfs, List.class, 219, 8044, 8046).size()); i++) {
                                        if (CallChecker.beforeDeref(sfs, List.class, 221, 8118, 8120)) {
                                            if (CallChecker.beforeDeref(matches, Set.class, 221, 8091, 8097)) {
                                                sfs = CallChecker.beforeCalled(sfs, List.class, 221, 8118, 8120);
                                                matches = CallChecker.beforeCalled(matches, Set.class, 221, 8091, 8097);
                                                CallChecker.isCalled(matches, Set.class, 221, 8091, 8097).addAll(match(caps, CallChecker.isCalled(sfs, List.class, 221, 8118, 8120).get(i)));
                                            }
                                        }
                                    }
                                }else
                                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 224, 8173, 8174)) {
                                        if ((CallChecker.isCalled(sf, SimpleFilter.class, 224, 8173, 8174).getOperation()) == (SimpleFilter.NOT)) {
                                            if (CallChecker.beforeDeref(matches, Set.class, 228, 8373, 8379)) {
                                                matches = CallChecker.beforeCalled(matches, Set.class, 228, 8373, 8379);
                                                CallChecker.isCalled(matches, Set.class, 228, 8373, 8379).addAll(caps);
                                            }
                                            List<SimpleFilter> sfs = CallChecker.init(List.class);
                                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 229, 8453, 8454)) {
                                                sfs = ((List<SimpleFilter>) (CallChecker.isCalled(sf, SimpleFilter.class, 229, 8453, 8454).getValue()));
                                                CallChecker.varAssign(sfs, "sfs", 229, 8453, 8454);
                                            }
                                            sfs = CallChecker.beforeCalled(sfs, List.class, 230, 8500, 8502);
                                            for (int i = 0; i < (CallChecker.isCalled(sfs, List.class, 230, 8500, 8502).size()); i++) {
                                                if (CallChecker.beforeDeref(sfs, List.class, 232, 8577, 8579)) {
                                                    if (CallChecker.beforeDeref(matches, Set.class, 232, 8547, 8553)) {
                                                        sfs = CallChecker.beforeCalled(sfs, List.class, 232, 8577, 8579);
                                                        matches = CallChecker.beforeCalled(matches, Set.class, 232, 8547, 8553);
                                                        CallChecker.isCalled(matches, Set.class, 232, 8547, 8553).removeAll(match(caps, CallChecker.isCalled(sfs, List.class, 232, 8577, 8579).get(i)));
                                                    }
                                                }
                                            }
                                        }else {
                                            Map<Object, Set<BundleCapability>> index = CallChecker.init(Map.class);
                                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 237, 8707, 8708)) {
                                                if (CallChecker.beforeDeref(m_indices, SortedMap.class, 237, 8693, 8701)) {
                                                    index = CallChecker.isCalled(m_indices, SortedMap.class, 237, 8693, 8701).get(CallChecker.isCalled(sf, SimpleFilter.class, 237, 8707, 8708).getName());
                                                    CallChecker.varAssign(index, "index", 237, 8707, 8708);
                                                }
                                            }
                                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 238, 8739, 8740)) {
                                                if (((CallChecker.isCalled(sf, SimpleFilter.class, 238, 8739, 8740).getOperation()) == (SimpleFilter.EQ)) && (index != null)) {
                                                    Set<BundleCapability> existingCaps = CallChecker.init(Set.class);
                                                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 240, 8874, 8875)) {
                                                        existingCaps = index.get(CallChecker.isCalled(sf, SimpleFilter.class, 240, 8874, 8875).getValue());
                                                        CallChecker.varAssign(existingCaps, "existingCaps", 240, 8874, 8875);
                                                    }
                                                    if (existingCaps != null) {
                                                        if (CallChecker.beforeDeref(matches, Set.class, 243, 8970, 8976)) {
                                                            matches = CallChecker.beforeCalled(matches, Set.class, 243, 8970, 8976);
                                                            CallChecker.isCalled(matches, Set.class, 243, 8970, 8976).addAll(existingCaps);
                                                        }
                                                        if (caps != (m_capSet)) {
                                                            if (CallChecker.beforeDeref(matches, Set.class, 246, 9088, 9094)) {
                                                                matches = CallChecker.beforeCalled(matches, Set.class, 246, 9088, 9094);
                                                                CallChecker.isCalled(matches, Set.class, 246, 9088, 9094).retainAll(caps);
                                                            }
                                                        }
                                                    }
                                                }else {
                                                    caps = CallChecker.beforeCalled(caps, Set.class, 252, 9245, 9248);
                                                    for (Iterator<Capability> it = CallChecker.isCalled(caps, Set.class, 252, 9245, 9248).iterator(); CallChecker.isCalled(it, Iterator.class, 252, 9262, 9263).hasNext();) {
                                                        Capability cap = CallChecker.init(Capability.class);
                                                        if (CallChecker.beforeDeref(it, Iterator.class, 254, 9333, 9334)) {
                                                            cap = CallChecker.isCalled(it, Iterator.class, 254, 9333, 9334).next();
                                                            CallChecker.varAssign(cap, "cap", 254, 9333, 9334);
                                                        }
                                                        Object lhs = CallChecker.init(Object.class);
                                                        if (CallChecker.beforeDeref(cap, Capability.class, 255, 9377, 9379)) {
                                                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 255, 9401, 9402)) {
                                                                cap = CallChecker.beforeCalled(cap, Capability.class, 255, 9377, 9379);
                                                                final Map<String, Object> npe_invocation_var241 = CallChecker.isCalled(cap, Capability.class, 255, 9377, 9379).getAttributes();
                                                                if (CallChecker.beforeDeref(npe_invocation_var241, Map.class, 255, 9377, 9395)) {
                                                                    lhs = CallChecker.isCalled(npe_invocation_var241, Map.class, 255, 9377, 9395).get(CallChecker.isCalled(sf, SimpleFilter.class, 255, 9401, 9402).getName());
                                                                    CallChecker.varAssign(lhs, "lhs", 255, 9377, 9379);
                                                                }
                                                            }
                                                        }
                                                        if (lhs != null) {
                                                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 258, 9516, 9517)) {
                                                                if (CallChecker.beforeDeref(sf, SimpleFilter.class, 258, 9531, 9532)) {
                                                                    if (CapabilitySet.compare(lhs, CallChecker.isCalled(sf, SimpleFilter.class, 258, 9516, 9517).getValue(), CallChecker.isCalled(sf, SimpleFilter.class, 258, 9531, 9532).getOperation())) {
                                                                        if (CallChecker.beforeDeref(matches, Set.class, 260, 9605, 9611)) {
                                                                            matches = CallChecker.beforeCalled(matches, Set.class, 260, 9605, 9611);
                                                                            CallChecker.isCalled(matches, Set.class, 260, 9605, 9611).add(cap);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            return matches;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context760.methodEnd();
        }
    }

    public static boolean matches(Capability cap, SimpleFilter sf) {
        MethodContext _bcornu_methode_context761 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(sf, "sf", 270, 9749, 9890);
            CallChecker.varInit(cap, "cap", 270, 9749, 9890);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 270, 9749, 9890);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 270, 9749, 9890);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 270, 9749, 9890);
            return (CapabilitySet.matchesInternal(cap, sf)) && (CapabilitySet.matchMandatory(cap, sf));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context761.methodEnd();
        }
    }

    private static boolean matchesInternal(Capability cap, SimpleFilter sf) {
        MethodContext _bcornu_methode_context762 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(sf, "sf", 275, 9897, 11849);
            CallChecker.varInit(cap, "cap", 275, 9897, 11849);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 275, 9897, 11849);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 275, 9897, 11849);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 275, 9897, 11849);
            boolean matched = CallChecker.varInit(((boolean) (true)), "matched", 277, 9983, 10005);
            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 279, 10020, 10021)) {
                sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 279, 10020, 10021);
                if ((CallChecker.isCalled(sf, SimpleFilter.class, 279, 10020, 10021).getOperation()) == (SimpleFilter.MATCH_ALL)) {
                    matched = true;
                    CallChecker.varAssign(matched, "matched", 281, 10087, 10101);
                }else
                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 283, 10130, 10131)) {
                        sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 283, 10130, 10131);
                        if ((CallChecker.isCalled(sf, SimpleFilter.class, 283, 10130, 10131).getOperation()) == (SimpleFilter.AND)) {
                            List<SimpleFilter> sfs = CallChecker.init(List.class);
                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 289, 10493, 10494)) {
                                sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 289, 10493, 10494);
                                sfs = ((List<SimpleFilter>) (CallChecker.isCalled(sf, SimpleFilter.class, 289, 10493, 10494).getValue()));
                                CallChecker.varAssign(sfs, "sfs", 289, 10493, 10494);
                            }
                            sfs = CallChecker.beforeCalled(sfs, List.class, 290, 10552, 10554);
                            for (int i = 0; matched && (i < (CallChecker.isCalled(sfs, List.class, 290, 10552, 10554).size())); i++) {
                                if (CallChecker.beforeDeref(sfs, List.class, 292, 10631, 10633)) {
                                    sfs = CallChecker.beforeCalled(sfs, List.class, 292, 10631, 10633);
                                    matched = CapabilitySet.matchesInternal(cap, CallChecker.isCalled(sfs, List.class, 292, 10631, 10633).get(i));
                                    CallChecker.varAssign(matched, "matched", 292, 10600, 10642);
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 295, 10685, 10686)) {
                                sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 295, 10685, 10686);
                                if ((CallChecker.isCalled(sf, SimpleFilter.class, 295, 10685, 10686).getOperation()) == (SimpleFilter.OR)) {
                                    matched = false;
                                    CallChecker.varAssign(matched, "matched", 299, 10884, 10899);
                                    List<SimpleFilter> sfs = CallChecker.init(List.class);
                                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 300, 10959, 10960)) {
                                        sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 300, 10959, 10960);
                                        sfs = ((List<SimpleFilter>) (CallChecker.isCalled(sf, SimpleFilter.class, 300, 10959, 10960).getValue()));
                                        CallChecker.varAssign(sfs, "sfs", 300, 10959, 10960);
                                    }
                                    sfs = CallChecker.beforeCalled(sfs, List.class, 301, 11019, 11021);
                                    for (int i = 0; (!matched) && (i < (CallChecker.isCalled(sfs, List.class, 301, 11019, 11021).size())); i++) {
                                        if (CallChecker.beforeDeref(sfs, List.class, 303, 11098, 11100)) {
                                            sfs = CallChecker.beforeCalled(sfs, List.class, 303, 11098, 11100);
                                            matched = CapabilitySet.matchesInternal(cap, CallChecker.isCalled(sfs, List.class, 303, 11098, 11100).get(i));
                                            CallChecker.varAssign(matched, "matched", 303, 11067, 11109);
                                        }
                                    }
                                }else
                                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 306, 11152, 11153)) {
                                        sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 306, 11152, 11153);
                                        if ((CallChecker.isCalled(sf, SimpleFilter.class, 306, 11152, 11153).getOperation()) == (SimpleFilter.NOT)) {
                                            List<SimpleFilter> sfs = CallChecker.init(List.class);
                                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 310, 11398, 11399)) {
                                                sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 310, 11398, 11399);
                                                sfs = ((List<SimpleFilter>) (CallChecker.isCalled(sf, SimpleFilter.class, 310, 11398, 11399).getValue()));
                                                CallChecker.varAssign(sfs, "sfs", 310, 11398, 11399);
                                            }
                                            sfs = CallChecker.beforeCalled(sfs, List.class, 311, 11445, 11447);
                                            for (int i = 0; i < (CallChecker.isCalled(sfs, List.class, 311, 11445, 11447).size()); i++) {
                                                if (CallChecker.beforeDeref(sfs, List.class, 313, 11525, 11527)) {
                                                    sfs = CallChecker.beforeCalled(sfs, List.class, 313, 11525, 11527);
                                                    matched = !(CapabilitySet.matchesInternal(cap, CallChecker.isCalled(sfs, List.class, 313, 11525, 11527).get(i)));
                                                    CallChecker.varAssign(matched, "matched", 313, 11492, 11537);
                                                }
                                            }
                                        }else {
                                            matched = false;
                                            CallChecker.varAssign(matched, "matched", 318, 11598, 11613);
                                            Object lhs = CallChecker.init(Object.class);
                                            if (CallChecker.beforeDeref(cap, Capability.class, 319, 11640, 11642)) {
                                                if (CallChecker.beforeDeref(sf, SimpleFilter.class, 319, 11664, 11665)) {
                                                    cap = CallChecker.beforeCalled(cap, Capability.class, 319, 11640, 11642);
                                                    final Map<String, Object> npe_invocation_var242 = CallChecker.isCalled(cap, Capability.class, 319, 11640, 11642).getAttributes();
                                                    if (CallChecker.beforeDeref(npe_invocation_var242, Map.class, 319, 11640, 11658)) {
                                                        sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 319, 11664, 11665);
                                                        lhs = CallChecker.isCalled(npe_invocation_var242, Map.class, 319, 11640, 11658).get(CallChecker.isCalled(sf, SimpleFilter.class, 319, 11664, 11665).getName());
                                                        CallChecker.varAssign(lhs, "lhs", 319, 11640, 11642);
                                                    }
                                                }
                                            }
                                            if (lhs != null) {
                                                if (CallChecker.beforeDeref(sf, SimpleFilter.class, 322, 11761, 11762)) {
                                                    if (CallChecker.beforeDeref(sf, SimpleFilter.class, 322, 11776, 11777)) {
                                                        sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 322, 11761, 11762);
                                                        sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 322, 11776, 11777);
                                                        matched = CapabilitySet.compare(lhs, CallChecker.isCalled(sf, SimpleFilter.class, 322, 11761, 11762).getValue(), CallChecker.isCalled(sf, SimpleFilter.class, 322, 11776, 11777).getOperation());
                                                        CallChecker.varAssign(matched, "matched", 322, 11738, 11794);
                                                    }
                                                }
                                            }
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            return matched;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context762.methodEnd();
        }
    }

    private static Set<Capability> matchMandatory(Set<Capability> caps, SimpleFilter sf) {
        MethodContext _bcornu_methode_context763 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(sf, "sf", 329, 11856, 12212);
            CallChecker.varInit(caps, "caps", 329, 11856, 12212);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 329, 11856, 12212);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 329, 11856, 12212);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 329, 11856, 12212);
            caps = CallChecker.beforeCalled(caps, Set.class, 332, 11995, 11998);
            for (Iterator<Capability> it = CallChecker.isCalled(caps, Set.class, 332, 11995, 11998).iterator(); CallChecker.isCalled(it, Iterator.class, 332, 12012, 12013).hasNext();) {
                Capability cap = CallChecker.init(Capability.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 334, 12067, 12068)) {
                    cap = CallChecker.isCalled(it, Iterator.class, 334, 12067, 12068).next();
                    CallChecker.varAssign(cap, "cap", 334, 12067, 12068);
                }
                if (!(CapabilitySet.matchMandatory(cap, sf))) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 337, 12150, 12151)) {
                        CallChecker.isCalled(it, Iterator.class, 337, 12150, 12151).remove();
                    }
                }
            }
            return caps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context763.methodEnd();
        }
    }

    private static boolean matchMandatory(Capability cap, SimpleFilter sf) {
        MethodContext _bcornu_methode_context764 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(sf, "sf", 343, 12219, 12663);
            CallChecker.varInit(cap, "cap", 343, 12219, 12663);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 343, 12219, 12663);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 343, 12219, 12663);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 343, 12219, 12663);
            Map<String, Object> attrs = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(cap, Capability.class, 345, 12332, 12334)) {
                cap = CallChecker.beforeCalled(cap, Capability.class, 345, 12332, 12334);
                attrs = CallChecker.isCalled(cap, Capability.class, 345, 12332, 12334).getAttributes();
                CallChecker.varAssign(attrs, "attrs", 345, 12332, 12334);
            }
            attrs = CallChecker.beforeCalled(attrs, Map.class, 346, 12396, 12400);
            for (Map.Entry<String, Object> entry : CallChecker.isCalled(attrs, Map.class, 346, 12396, 12400).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 348, 12490, 12494)) {
                    if (CallChecker.beforeDeref(cap, Capability.class, 348, 12464, 12466)) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 349, 12549, 12553)) {
                            cap = CallChecker.beforeCalled(cap, BundleCapabilityImpl.class, 348, 12464, 12466);
                            if ((CallChecker.isCalled(((BundleCapabilityImpl) (cap)), BundleCapabilityImpl.class, 348, 12464, 12466).isAttributeMandatory(CallChecker.isCalled(entry, Map.Entry.class, 348, 12490, 12494).getKey())) && (!(CapabilitySet.matchMandatoryAttrbute(CallChecker.isCalled(entry, Map.Entry.class, 349, 12549, 12553).getKey(), sf)))) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context764.methodEnd();
        }
    }

    private static boolean matchMandatoryAttrbute(String attrName, SimpleFilter sf) {
        MethodContext _bcornu_methode_context765 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(sf, "sf", 357, 12670, 13327);
            CallChecker.varInit(attrName, "attrName", 357, 12670, 13327);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 357, 12670, 13327);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 357, 12670, 13327);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 357, 12670, 13327);
            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 359, 12769, 12770)) {
                if (CallChecker.beforeDeref(sf, SimpleFilter.class, 359, 12794, 12795)) {
                    sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 359, 12769, 12770);
                    sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 359, 12794, 12795);
                    if (((CallChecker.isCalled(sf, SimpleFilter.class, 359, 12769, 12770).getName()) != null) && (CallChecker.isCalled(sf, SimpleFilter.class, 359, 12794, 12795).getName().equals(attrName))) {
                        return true;
                    }else
                        if (CallChecker.beforeDeref(sf, SimpleFilter.class, 363, 12887, 12888)) {
                            sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 363, 12887, 12888);
                            if ((CallChecker.isCalled(sf, SimpleFilter.class, 363, 12887, 12888).getOperation()) == (SimpleFilter.AND)) {
                                List list = CallChecker.init(List.class);
                                if (CallChecker.beforeDeref(sf, SimpleFilter.class, 365, 12967, 12968)) {
                                    sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 365, 12967, 12968);
                                    list = ((List) (CallChecker.isCalled(sf, SimpleFilter.class, 365, 12967, 12968).getValue()));
                                    CallChecker.varAssign(list, "list", 365, 12967, 12968);
                                }
                                list = CallChecker.beforeCalled(list, List.class, 366, 13014, 13017);
                                for (int i = 0; i < (CallChecker.isCalled(list, List.class, 366, 13014, 13017).size()); i++) {
                                    SimpleFilter sf2 = CallChecker.init(SimpleFilter.class);
                                    if (CallChecker.beforeDeref(list, List.class, 368, 13096, 13099)) {
                                        list = CallChecker.beforeCalled(list, List.class, 368, 13096, 13099);
                                        sf2 = ((SimpleFilter) (CallChecker.isCalled(list, List.class, 368, 13096, 13099).get(i)));
                                        CallChecker.varAssign(sf2, "sf2", 368, 13096, 13099);
                                    }
                                    if (CallChecker.beforeDeref(sf2, SimpleFilter.class, 369, 13130, 13132)) {
                                        if (CallChecker.beforeDeref(sf2, SimpleFilter.class, 370, 13176, 13178)) {
                                            sf2 = CallChecker.beforeCalled(sf2, SimpleFilter.class, 369, 13130, 13132);
                                            sf2 = CallChecker.beforeCalled(sf2, SimpleFilter.class, 370, 13176, 13178);
                                            if (((CallChecker.isCalled(sf2, SimpleFilter.class, 369, 13130, 13132).getName()) != null) && (CallChecker.isCalled(sf2, SimpleFilter.class, 370, 13176, 13178).getName().equals(attrName))) {
                                                return true;
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context765.methodEnd();
        }
    }

    private static final Class<?>[] STRING_CLASS = new Class[]{ String.class };

    private static final String VALUE_OF_METHOD_NAME = "valueOf";

    private static boolean compare(Object lhs, Object rhsUnknown, int op) {
        MethodContext _bcornu_methode_context766 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(op, "op", 382, 13482, 18556);
            CallChecker.varInit(rhsUnknown, "rhsUnknown", 382, 13482, 18556);
            CallChecker.varInit(lhs, "lhs", 382, 13482, 18556);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 382, 13482, 18556);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 382, 13482, 18556);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 382, 13482, 18556);
            if (lhs == null) {
                return false;
            }
            if (op == (SimpleFilter.PRESENT)) {
                return true;
            }
            if ((lhs instanceof Version) && (op == (SimpleFilter.EQ))) {
                Object rhs = CallChecker.varInit(null, "rhs", 400, 14091, 14108);
                TryContext _bcornu_try_context_266 = new TryContext(266, CapabilitySet.class, "java.lang.Exception");
                try {
                    rhs = CapabilitySet.coerceType(lhs, ((String) (rhsUnknown)));
                    CallChecker.varAssign(rhs, "rhs", 403, 14156, 14198);
                } catch (Exception ex) {
                    _bcornu_try_context_266.catchStart(266);
                } finally {
                    _bcornu_try_context_266.finallyStart(266);
                }
                if ((rhs != null) && (rhs instanceof VersionRange)) {
                    return ((VersionRange) (rhs)).isInRange(((Version) (lhs)));
                }
            }
            if (lhs instanceof Comparable) {
                if ((op == (SimpleFilter.SUBSTRING)) && (!(lhs instanceof String))) {
                    return false;
                }
                Object rhs = CallChecker.init(Object.class);
                if (op == (SimpleFilter.SUBSTRING)) {
                    rhs = rhsUnknown;
                    CallChecker.varAssign(rhs, "rhs", 429, 14961, 14977);
                }else {
                    TryContext _bcornu_try_context_267 = new TryContext(267, CapabilitySet.class, "java.lang.Exception");
                    try {
                        rhs = CapabilitySet.coerceType(lhs, ((String) (rhsUnknown)));
                        CallChecker.varAssign(rhs, "rhs", 435, 15082, 15124);
                    } catch (Exception ex) {
                        _bcornu_try_context_267.catchStart(267);
                        return false;
                    } finally {
                        _bcornu_try_context_267.finallyStart(267);
                    }
                }
                switch (op) {
                    case SimpleFilter.EQ :
                        TryContext _bcornu_try_context_268 = new TryContext(268, CapabilitySet.class, "java.lang.Exception");
                        try {
                            return (((Comparable) (lhs)).compareTo(rhs)) == 0;
                        } catch (Exception ex) {
                            _bcornu_try_context_268.catchStart(268);
                            return false;
                        } finally {
                            _bcornu_try_context_268.finallyStart(268);
                        }
                    case SimpleFilter.GTE :
                        TryContext _bcornu_try_context_269 = new TryContext(269, CapabilitySet.class, "java.lang.Exception");
                        try {
                            return (((Comparable) (lhs)).compareTo(rhs)) >= 0;
                        } catch (Exception ex) {
                            _bcornu_try_context_269.catchStart(269);
                            return false;
                        } finally {
                            _bcornu_try_context_269.finallyStart(269);
                        }
                    case SimpleFilter.LTE :
                        TryContext _bcornu_try_context_270 = new TryContext(270, CapabilitySet.class, "java.lang.Exception");
                        try {
                            return (((Comparable) (lhs)).compareTo(rhs)) <= 0;
                        } catch (Exception ex) {
                            _bcornu_try_context_270.catchStart(270);
                            return false;
                        } finally {
                            _bcornu_try_context_270.finallyStart(270);
                        }
                    case SimpleFilter.APPROX :
                        return CapabilitySet.compareApproximate(lhs, rhs);
                    case SimpleFilter.SUBSTRING :
                        return SimpleFilter.compareSubstring(((List<String>) (rhs)), ((String) (lhs)));
                    default :
                        throw new RuntimeException(("Unknown comparison operator: " + op));
                }
            }else
                if (lhs instanceof Boolean) {
                    Object rhs = CallChecker.init(Object.class);
                    TryContext _bcornu_try_context_271 = new TryContext(271, CapabilitySet.class, "java.lang.Exception");
                    try {
                        rhs = CapabilitySet.coerceType(lhs, ((String) (rhsUnknown)));
                        CallChecker.varAssign(rhs, "rhs", 487, 16805, 16847);
                    } catch (Exception ex) {
                        _bcornu_try_context_271.catchStart(271);
                        return false;
                    } finally {
                        _bcornu_try_context_271.finallyStart(271);
                    }
                    switch (op) {
                        case SimpleFilter.EQ :
                        case SimpleFilter.GTE :
                        case SimpleFilter.LTE :
                        case SimpleFilter.APPROX :
                            return lhs.equals(rhs);
                        default :
                            throw new RuntimeException(("Unknown comparison operator: " + op));
                    }
                }
            
            lhs = CallChecker.beforeCalled(lhs, Object.class, 510, 17539, 17541);
            if (CallChecker.beforeDeref(CallChecker.isCalled(lhs, Object.class, 510, 17539, 17541).getClass(), Class.class, 510, 17539, 17552)) {
                if (CallChecker.isCalled(lhs.getClass(), Class.class, 510, 17539, 17552).isArray()) {
                    lhs = CapabilitySet.convertArrayToList(lhs);
                    CallChecker.varAssign(lhs, "lhs", 512, 17587, 17616);
                }
            }
            if (lhs instanceof Collection) {
                for (Iterator iter = ((Collection) (lhs)).iterator(); CallChecker.isCalled(iter, Iterator.class, 519, 17866, 17869).hasNext();) {
                    if (CallChecker.beforeDeref(iter, Iterator.class, 521, 17926, 17929)) {
                        if (CapabilitySet.compare(CallChecker.isCalled(iter, Iterator.class, 521, 17926, 17929).next(), rhsUnknown, op)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return false;
            }
            if ((op == (SimpleFilter.SUBSTRING)) && (!(lhs instanceof String))) {
                return false;
            }
            TryContext _bcornu_try_context_272 = new TryContext(272, CapabilitySet.class, "java.lang.Exception");
            try {
                return lhs.equals(CapabilitySet.coerceType(lhs, ((String) (rhsUnknown))));
            } catch (Exception ex) {
                _bcornu_try_context_272.catchStart(272);
                return false;
            } finally {
                _bcornu_try_context_272.finallyStart(272);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context766.methodEnd();
        }
    }

    private static boolean compareApproximate(Object lhs, Object rhs) {
        MethodContext _bcornu_methode_context767 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(rhs, "rhs", 548, 18563, 19027);
            CallChecker.varInit(lhs, "lhs", 548, 18563, 19027);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 548, 18563, 19027);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 548, 18563, 19027);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 548, 18563, 19027);
            if (rhs instanceof String) {
                final String npe_invocation_var243 = CapabilitySet.removeWhitespace(((String) (lhs)));
                if (CallChecker.beforeDeref(npe_invocation_var243, String.class, 552, 18699, 18728)) {
                    return CallChecker.isCalled(npe_invocation_var243, String.class, 552, 18699, 18728).equalsIgnoreCase(CapabilitySet.removeWhitespace(((String) (rhs))));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (rhs instanceof Character) {
                    return (Character.toLowerCase(((Character) (lhs)))) == (Character.toLowerCase(((Character) (rhs))));
                }
            
            if (CallChecker.beforeDeref(lhs, Object.class, 560, 19006, 19008)) {
                lhs = CallChecker.beforeCalled(lhs, Object.class, 560, 19006, 19008);
                return CallChecker.isCalled(lhs, Object.class, 560, 19006, 19008).equals(rhs);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context767.methodEnd();
        }
    }

    private static String removeWhitespace(String s) {
        MethodContext _bcornu_methode_context768 = new MethodContext(String.class);
        try {
            CallChecker.varInit(s, "s", 563, 19034, 19366);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 563, 19034, 19366);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 563, 19034, 19366);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 563, 19034, 19366);
            StringBuffer sb = CallChecker.init(StringBuffer.class);
            if (CallChecker.beforeDeref(s, String.class, 565, 19132, 19132)) {
                s = CallChecker.beforeCalled(s, String.class, 565, 19132, 19132);
                sb = new StringBuffer(CallChecker.isCalled(s, String.class, 565, 19132, 19132).length());
                CallChecker.varAssign(sb, "sb", 565, 19132, 19132);
            }
            s = CallChecker.beforeCalled(s, String.class, 566, 19173, 19173);
            for (int i = 0; i < (CallChecker.isCalled(s, String.class, 566, 19173, 19173).length()); i++) {
                if (CallChecker.beforeDeref(s, String.class, 568, 19240, 19240)) {
                    s = CallChecker.beforeCalled(s, String.class, 568, 19240, 19240);
                    if (!(Character.isWhitespace(CallChecker.isCalled(s, String.class, 568, 19240, 19240).charAt(i)))) {
                        if (CallChecker.beforeDeref(s, String.class, 570, 19294, 19294)) {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 570, 19284, 19285)) {
                                s = CallChecker.beforeCalled(s, String.class, 570, 19294, 19294);
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 570, 19284, 19285);
                                CallChecker.isCalled(sb, StringBuffer.class, 570, 19284, 19285).append(CallChecker.isCalled(s, String.class, 570, 19294, 19294).charAt(i));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 573, 19347, 19348)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 573, 19347, 19348);
                return CallChecker.isCalled(sb, StringBuffer.class, 573, 19347, 19348).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context768.methodEnd();
        }
    }

    private static Object coerceType(Object lhs, String rhsString) throws Exception {
        MethodContext _bcornu_methode_context769 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(rhsString, "rhsString", 576, 19373, 21963);
            CallChecker.varInit(lhs, "lhs", 576, 19373, 21963);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 576, 19373, 21963);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 576, 19373, 21963);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 576, 19373, 21963);
            if (CallChecker.beforeDeref(lhs, Object.class, 580, 19576, 19578)) {
                if (CallChecker.beforeDeref(rhsString, String.class, 580, 19594, 19602)) {
                    lhs = CallChecker.beforeCalled(lhs, Object.class, 580, 19576, 19578);
                    rhsString = CallChecker.beforeCalled(rhsString, String.class, 580, 19594, 19602);
                    if ((CallChecker.isCalled(lhs, Object.class, 580, 19576, 19578).getClass()) == (CallChecker.isCalled(rhsString, String.class, 580, 19594, 19602).getClass())) {
                        return rhsString;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Object rhs = CallChecker.varInit(null, "rhs", 587, 19806, 19823);
            TryContext _bcornu_try_context_274 = new TryContext(274, CapabilitySet.class, "java.lang.Exception");
            try {
                if (lhs instanceof Character) {
                    if (CallChecker.beforeDeref(rhsString, String.class, 594, 20079, 20087)) {
                        rhsString = CallChecker.beforeCalled(rhsString, String.class, 594, 20079, 20087);
                        rhs = new Character(CallChecker.isCalled(rhsString, String.class, 594, 20079, 20087).charAt(0));
                        CallChecker.varAssign(rhs, "rhs", 594, 20059, 20099);
                    }
                }else
                    if (CallChecker.beforeDeref(rhsString, String.class, 596, 20161, 20169)) {
                        rhsString = CallChecker.beforeCalled(rhsString, String.class, 596, 20161, 20169);
                        if ((lhs instanceof Version) && ((CallChecker.isCalled(rhsString, String.class, 596, 20161, 20169).indexOf(',')) >= 0)) {
                            rhs = VersionRange.parse(rhsString);
                            CallChecker.varAssign(rhs, "rhs", 598, 20220, 20255);
                        }else {
                            if ((lhs instanceof Number) || (lhs instanceof Boolean)) {
                                if (CallChecker.beforeDeref(rhsString, String.class, 605, 20483, 20491)) {
                                    rhsString = CallChecker.beforeCalled(rhsString, String.class, 605, 20483, 20491);
                                    rhsString = CallChecker.isCalled(rhsString, String.class, 605, 20483, 20491).trim();
                                    CallChecker.varAssign(rhsString, "rhsString", 605, 20471, 20499);
                                }
                            }
                            TryContext _bcornu_try_context_273 = new TryContext(273, CapabilitySet.class, "java.lang.Exception");
                            try {
                                java.lang.reflect.Method valueOfMethod = CallChecker.init(java.lang.reflect.Method.class);
                                if (CallChecker.beforeDeref(lhs, Object.class, 612, 20727, 20729)) {
                                    if (CallChecker.beforeDeref(CapabilitySet.m_secureAction, SecureAction.class, 611, 20669, 20682)) {
                                        lhs = CallChecker.beforeCalled(lhs, Object.class, 612, 20727, 20729);
                                        valueOfMethod = CallChecker.isCalled(CapabilitySet.m_secureAction, SecureAction.class, 611, 20669, 20682).getDeclaredMethod(CallChecker.isCalled(lhs, Object.class, 612, 20727, 20729).getClass(), CapabilitySet.VALUE_OF_METHOD_NAME, CapabilitySet.STRING_CLASS);
                                        CallChecker.varAssign(valueOfMethod, "valueOfMethod", 612, 20727, 20729);
                                    }
                                }
                                if (CallChecker.beforeDeref(valueOfMethod, java.lang.reflect.Method.class, 613, 20804, 20816)) {
                                    if (CallChecker.beforeDeref(lhs, Object.class, 613, 20851, 20853)) {
                                        valueOfMethod = CallChecker.beforeCalled(valueOfMethod, java.lang.reflect.Method.class, 613, 20804, 20816);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(valueOfMethod, java.lang.reflect.Method.class, 613, 20804, 20816).getReturnType(), Class.class, 613, 20804, 20832)) {
                                            if (CallChecker.beforeDeref(valueOfMethod, java.lang.reflect.Method.class, 614, 20896, 20908)) {
                                                valueOfMethod = CallChecker.beforeCalled(valueOfMethod, java.lang.reflect.Method.class, 613, 20804, 20816);
                                                lhs = CallChecker.beforeCalled(lhs, Object.class, 613, 20851, 20853);
                                                valueOfMethod = CallChecker.beforeCalled(valueOfMethod, java.lang.reflect.Method.class, 614, 20896, 20908);
                                                if ((CallChecker.isCalled(CallChecker.isCalled(valueOfMethod, java.lang.reflect.Method.class, 613, 20804, 20816).getReturnType(), Class.class, 613, 20804, 20832).isAssignableFrom(CallChecker.isCalled(lhs, Object.class, 613, 20851, 20853).getClass())) && (((CallChecker.isCalled(valueOfMethod, java.lang.reflect.Method.class, 614, 20896, 20908).getModifiers()) & (java.lang.reflect.Modifier.STATIC)) > 0)) {
                                                    if (CallChecker.beforeDeref(CapabilitySet.m_secureAction, SecureAction.class, 616, 20996, 21009)) {
                                                        CallChecker.isCalled(CapabilitySet.m_secureAction, SecureAction.class, 616, 20996, 21009).setAccesssible(valueOfMethod);
                                                    }
                                                    if (CallChecker.beforeDeref(valueOfMethod, java.lang.reflect.Method.class, 617, 21072, 21084)) {
                                                        valueOfMethod = CallChecker.beforeCalled(valueOfMethod, java.lang.reflect.Method.class, 617, 21072, 21084);
                                                        rhs = CallChecker.isCalled(valueOfMethod, java.lang.reflect.Method.class, 617, 21072, 21084).invoke(null, new Object[]{ rhsString });
                                                        CallChecker.varAssign(rhs, "rhs", 617, 21066, 21126);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (Exception ex) {
                                _bcornu_try_context_273.catchStart(273);
                            } finally {
                                _bcornu_try_context_273.finallyStart(273);
                            }
                            if (rhs == null) {
                                java.lang.reflect.Constructor ctor = CallChecker.init(java.lang.reflect.Constructor.class);
                                if (CallChecker.beforeDeref(lhs, Object.class, 627, 21441, 21443)) {
                                    if (CallChecker.beforeDeref(CapabilitySet.m_secureAction, SecureAction.class, 627, 21411, 21424)) {
                                        lhs = CallChecker.beforeCalled(lhs, Object.class, 627, 21441, 21443);
                                        ctor = CallChecker.isCalled(CapabilitySet.m_secureAction, SecureAction.class, 627, 21411, 21424).getConstructor(CallChecker.isCalled(lhs, Object.class, 627, 21441, 21443).getClass(), CapabilitySet.STRING_CLASS);
                                        CallChecker.varAssign(ctor, "ctor", 627, 21441, 21443);
                                    }
                                }
                                if (CallChecker.beforeDeref(CapabilitySet.m_secureAction, SecureAction.class, 628, 21492, 21505)) {
                                    CallChecker.isCalled(CapabilitySet.m_secureAction, SecureAction.class, 628, 21492, 21505).setAccesssible(ctor);
                                }
                                if (CallChecker.beforeDeref(ctor, java.lang.reflect.Constructor.class, 629, 21555, 21558)) {
                                    ctor = CallChecker.beforeCalled(ctor, java.lang.reflect.Constructor.class, 629, 21555, 21558);
                                    rhs = CallChecker.isCalled(ctor, java.lang.reflect.Constructor.class, 629, 21555, 21558).newInstance(new Object[]{ rhsString });
                                    CallChecker.varAssign(rhs, "rhs", 629, 21549, 21599);
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            } catch (Exception ex) {
                _bcornu_try_context_274.catchStart(274);
                if (CallChecker.beforeDeref(lhs, Object.class, 637, 21784, 21786)) {
                    lhs = CallChecker.beforeCalled(lhs, Object.class, 637, 21784, 21786);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(lhs, Object.class, 637, 21784, 21786).getClass(), Class.class, 637, 21784, 21797)) {
                        lhs = CallChecker.beforeCalled(lhs, Object.class, 637, 21784, 21786);
                        throw new Exception(((((("Could not instantiate class " + (CallChecker.isCalled(CallChecker.isCalled(lhs, Object.class, 637, 21784, 21786).getClass(), Class.class, 637, 21784, 21797).getName())) + " from string constructor with argument '") + rhsString) + "' because ") + ex));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_274.finallyStart(274);
            }
            return rhs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context769.methodEnd();
        }
    }

    private static List convertArrayToList(Object array) {
        MethodContext _bcornu_methode_context770 = new MethodContext(List.class);
        try {
            CallChecker.varInit(array, "array", 653, 21970, 22612);
            CallChecker.varInit(VALUE_OF_METHOD_NAME, "org.apache.felix.framework.capabilityset.CapabilitySet.VALUE_OF_METHOD_NAME", 653, 21970, 22612);
            CallChecker.varInit(STRING_CLASS, "org.apache.felix.framework.capabilityset.CapabilitySet.STRING_CLASS", 653, 21970, 22612);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.capabilityset.CapabilitySet.m_secureAction", 653, 21970, 22612);
            int len = CallChecker.varInit(((int) (Array.getLength(array))), "len", 655, 22412, 22444);
            List list = CallChecker.varInit(new ArrayList(len), "list", 656, 22454, 22484);
            for (int i = 0; i < len; i++) {
                if (CallChecker.beforeDeref(list, List.class, 659, 22546, 22549)) {
                    list = CallChecker.beforeCalled(list, List.class, 659, 22546, 22549);
                    CallChecker.isCalled(list, List.class, 659, 22546, 22549).add(Array.get(array, i));
                }
            }
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context770.methodEnd();
        }
    }
}

