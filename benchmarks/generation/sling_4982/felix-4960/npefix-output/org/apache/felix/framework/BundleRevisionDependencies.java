package org.apache.felix.framework;

import org.apache.felix.framework.util.Util;
import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRevisions;
import org.osgi.framework.wiring.BundleWire;
import org.apache.felix.framework.wiring.BundleWireImpl;
import org.osgi.framework.wiring.BundleWiring;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

class BundleRevisionDependencies {
    private final Map<BundleRevision, Map<BundleCapability, Set<BundleWire>>> m_dependentsMap = new HashMap<BundleRevision, Map<BundleCapability, Set<BundleWire>>>();

    public synchronized void addDependent(BundleWire bw) {
        MethodContext _bcornu_methode_context441 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 42, 1614, 2243);
            CallChecker.varInit(bw, "bw", 42, 1614, 2243);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 42, 1614, 2243);
            BundleRevision provider = CallChecker.init(BundleRevision.class);
            if (CallChecker.beforeDeref(bw, BundleWire.class, 44, 1707, 1708)) {
                bw = CallChecker.beforeCalled(bw, BundleWire.class, 44, 1707, 1708);
                provider = CallChecker.isCalled(bw, BundleWire.class, 44, 1707, 1708).getProvider();
                CallChecker.varAssign(provider, "provider", 44, 1707, 1708);
            }
            Map<BundleCapability, Set<BundleWire>> caps = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 46, 1791, 1805)) {
                caps = CallChecker.isCalled(m_dependentsMap, Map.class, 46, 1791, 1805).get(provider);
                CallChecker.varAssign(caps, "caps", 46, 1791, 1805);
            }
            if (caps == null) {
                caps = new HashMap<BundleCapability, Set<BundleWire>>();
                CallChecker.varAssign(caps, "caps", 49, 1870, 1925);
                if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 50, 1939, 1953)) {
                    CallChecker.isCalled(m_dependentsMap, Map.class, 50, 1939, 1953).put(provider, caps);
                }
            }
            Set<BundleWire> dependents = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(bw, BundleWire.class, 52, 2032, 2033)) {
                if (CallChecker.beforeDeref(caps, Map.class, 52, 2023, 2026)) {
                    bw = CallChecker.beforeCalled(bw, BundleWire.class, 52, 2032, 2033);
                    caps = CallChecker.beforeCalled(caps, Map.class, 52, 2023, 2026);
                    dependents = CallChecker.isCalled(caps, Map.class, 52, 2023, 2026).get(CallChecker.isCalled(bw, BundleWire.class, 52, 2032, 2033).getCapability());
                    CallChecker.varAssign(dependents, "dependents", 52, 2032, 2033);
                }
            }
            if (dependents == null) {
                dependents = new HashSet<BundleWire>();
                CallChecker.varAssign(dependents, "dependents", 55, 2107, 2145);
                if (CallChecker.beforeDeref(bw, BundleWire.class, 56, 2168, 2169)) {
                    if (CallChecker.beforeDeref(caps, Map.class, 56, 2159, 2162)) {
                        bw = CallChecker.beforeCalled(bw, BundleWire.class, 56, 2168, 2169);
                        caps = CallChecker.beforeCalled(caps, Map.class, 56, 2159, 2162);
                        CallChecker.isCalled(caps, Map.class, 56, 2159, 2162).put(CallChecker.isCalled(bw, BundleWire.class, 56, 2168, 2169).getCapability(), dependents);
                    }
                }
            }
            if (CallChecker.beforeDeref(dependents, Set.class, 58, 2219, 2228)) {
                dependents = CallChecker.beforeCalled(dependents, Set.class, 58, 2219, 2228);
                CallChecker.isCalled(dependents, Set.class, 58, 2219, 2228).add(bw);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context441.methodEnd();
        }
    }

    public synchronized void removeDependents(BundleRevision provider) {
        MethodContext _bcornu_methode_context442 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 2246, 3075);
            CallChecker.varInit(provider, "provider", 84, 2246, 3075);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 84, 2246, 3075);
            if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 86, 3037, 3051)) {
                CallChecker.isCalled(m_dependentsMap, Map.class, 86, 3037, 3051).remove(provider);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context442.methodEnd();
        }
    }

    public synchronized Map<BundleCapability, Set<BundleWire>> getDependents(BundleRevision provider) {
        MethodContext _bcornu_methode_context443 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 90, 3082, 3244);
            CallChecker.varInit(provider, "provider", 90, 3082, 3244);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 90, 3082, 3244);
            if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 92, 3209, 3223)) {
                return CallChecker.isCalled(m_dependentsMap, Map.class, 92, 3209, 3223).get(provider);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<BundleCapability, Set<BundleWire>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context443.methodEnd();
        }
    }

    public synchronized boolean hasDependents(BundleRevision revision) {
        MethodContext _bcornu_methode_context444 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 95, 3251, 3852);
            CallChecker.varInit(revision, "revision", 95, 3251, 3852);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 95, 3251, 3852);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 101, 3579, 3586)) {
                if (CallChecker.beforeDeref(revision, BundleRevision.class, 102, 3625, 3632)) {
                    revision = CallChecker.beforeCalled(revision, BundleRevision.class, 102, 3625, 3632);
                    final List<BundleWire> npe_invocation_var164 = CallChecker.isCalled(CallChecker.isCalled(revision, BundleRevision.class, 102, 3625, 3632).getWiring(), BundleWiring.class, 102, 3625, 3644).getRequiredWires(null);
                    if (CallChecker.beforeDeref(npe_invocation_var164, List.class, 102, 3625, 3667)) {
                        revision = CallChecker.beforeCalled(revision, BundleRevision.class, 101, 3579, 3586);
                        if (((Util.isFragment(revision)) && ((CallChecker.isCalled(revision, BundleRevision.class, 101, 3579, 3586).getWiring()) != null)) && (!(CallChecker.isCalled(npe_invocation_var164, List.class, 102, 3625, 3667).isEmpty()))) {
                            return true;
                        }else
                            if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 106, 3742, 3756)) {
                                if (CallChecker.isCalled(m_dependentsMap, Map.class, 106, 3742, 3756).containsKey(revision)) {
                                    return true;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        
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
            _bcornu_methode_context444.methodEnd();
        }
    }

    public synchronized boolean hasDependents(Bundle bundle) {
        MethodContext _bcornu_methode_context445 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 113, 3859, 4209);
            CallChecker.varInit(bundle, "bundle", 113, 3859, 4209);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 113, 3859, 4209);
            List<BundleRevision> revisions = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 115, 3963, 3968)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 115, 3963, 3968);
                final BundleRevisions npe_invocation_var165 = CallChecker.isCalled(bundle, Bundle.class, 115, 3963, 3968).adapt(BundleRevisions.class);
                if (CallChecker.beforeDeref(npe_invocation_var165, BundleRevisions.class, 115, 3963, 3997)) {
                    revisions = CallChecker.isCalled(npe_invocation_var165, BundleRevisions.class, 115, 3963, 3997).getRevisions();
                    CallChecker.varAssign(revisions, "revisions", 115, 3963, 3968);
                }
            }
            if (CallChecker.beforeDeref(revisions, boolean.class, 116, 4054, 4062)) {
                for (BundleRevision revision : revisions) {
                    if (hasDependents(revision)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context445.methodEnd();
        }
    }

    public synchronized List<BundleWire> getProvidedWires(BundleRevision revision, String namespace) {
        MethodContext _bcornu_methode_context446 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 126, 4216, 5425);
            CallChecker.varInit(namespace, "namespace", 126, 4216, 5425);
            CallChecker.varInit(revision, "revision", 126, 4216, 5425);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 126, 4216, 5425);
            List<BundleWire> providedWires = CallChecker.varInit(new ArrayList<BundleWire>(), "providedWires", 129, 4336, 4396);
            Map<BundleCapability, Set<BundleWire>> providedCaps = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 132, 4473, 4487)) {
                providedCaps = CallChecker.isCalled(m_dependentsMap, Map.class, 132, 4473, 4487).get(revision);
                CallChecker.varAssign(providedCaps, "providedCaps", 132, 4473, 4487);
            }
            if (providedCaps != null) {
                BundleWiring wiring = CallChecker.init(BundleWiring.class);
                if (CallChecker.beforeDeref(revision, BundleRevision.class, 139, 4869, 4876)) {
                    revision = CallChecker.beforeCalled(revision, BundleRevision.class, 139, 4869, 4876);
                    wiring = CallChecker.isCalled(revision, BundleRevision.class, 139, 4869, 4876).getWiring();
                    CallChecker.varAssign(wiring, "wiring", 139, 4869, 4876);
                }
                if (wiring != null) {
                    List<BundleCapability> resolvedCaps = CallChecker.varInit(wiring.getCapabilities(namespace), "resolvedCaps", 142, 4953, 5024);
                    if (CallChecker.beforeDeref(resolvedCaps, List.class, 143, 5078, 5089)) {
                        for (BundleCapability resolvedCap : resolvedCaps) {
                            Set<BundleWire> dependentWires = CallChecker.varInit(providedCaps.get(resolvedCap), "dependentWires", 145, 5130, 5192);
                            if (dependentWires != null) {
                                if (CallChecker.beforeDeref(providedWires, List.class, 148, 5288, 5300)) {
                                    providedWires = CallChecker.beforeCalled(providedWires, List.class, 148, 5288, 5300);
                                    CallChecker.isCalled(providedWires, List.class, 148, 5288, 5300).addAll(dependentWires);
                                }
                            }
                        }
                    }
                }
            }
            return providedWires;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleWire>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context446.methodEnd();
        }
    }

    public synchronized Set<Bundle> getDependentBundles(Bundle bundle) {
        MethodContext _bcornu_methode_context447 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 157, 5432, 6828);
            CallChecker.varInit(bundle, "bundle", 157, 5432, 6828);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 157, 5432, 6828);
            Set<Bundle> result = CallChecker.varInit(new HashSet<Bundle>(), "result", 159, 5513, 5555);
            List<BundleRevision> revisions = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 161, 5599, 5604)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 161, 5599, 5604);
                final BundleRevisions npe_invocation_var166 = CallChecker.isCalled(bundle, Bundle.class, 161, 5599, 5604).adapt(BundleRevisions.class);
                if (CallChecker.beforeDeref(npe_invocation_var166, BundleRevisions.class, 161, 5599, 5633)) {
                    revisions = CallChecker.isCalled(npe_invocation_var166, BundleRevisions.class, 161, 5599, 5633).getRevisions();
                    CallChecker.varAssign(revisions, "revisions", 161, 5599, 5604);
                }
            }
            if (CallChecker.beforeDeref(revisions, Set.class, 162, 5690, 5698)) {
                for (BundleRevision revision : revisions) {
                    if (Util.isFragment(revision)) {
                        BundleWiring wiring = CallChecker.init(BundleWiring.class);
                        if (CallChecker.beforeDeref(revision, BundleRevision.class, 168, 5911, 5918)) {
                            wiring = CallChecker.isCalled(revision, BundleRevision.class, 168, 5911, 5918).getWiring();
                            CallChecker.varAssign(wiring, "wiring", 168, 5911, 5918);
                        }
                        if (wiring != null) {
                            for (BundleWire bw : wiring.getRequiredWires(null)) {
                                if (CallChecker.beforeDeref(bw, BundleWire.class, 173, 6134, 6135)) {
                                    final BundleRevision npe_invocation_var167 = CallChecker.isCalled(((BundleWireImpl) (bw)), BundleWireImpl.class, 173, 6134, 6135).getProvider();
                                    if (CallChecker.beforeDeref(npe_invocation_var167, BundleRevision.class, 173, 6116, 6150)) {
                                        if (CallChecker.beforeDeref(result, Set.class, 173, 6105, 6110)) {
                                            result = CallChecker.beforeCalled(result, Set.class, 173, 6105, 6110);
                                            CallChecker.isCalled(result, Set.class, 173, 6105, 6110).add(CallChecker.isCalled(npe_invocation_var167, BundleRevision.class, 173, 6116, 6150).getBundle());
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        Map<BundleCapability, Set<BundleWire>> caps = CallChecker.init(Map.class);
                        if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 180, 6333, 6347)) {
                            caps = CallChecker.isCalled(m_dependentsMap, Map.class, 180, 6333, 6347).get(revision);
                            CallChecker.varAssign(caps, "caps", 180, 6333, 6347);
                        }
                        if (caps != null) {
                            for (Map.Entry<BundleCapability, Set<BundleWire>> entry : caps.entrySet()) {
                                for (BundleWire dependentWire : CallChecker.isCalled(entry, Map.Entry.class, 185, 6585, 6589).getValue()) {
                                    if (CallChecker.beforeDeref(dependentWire, BundleWire.class, 187, 6668, 6680)) {
                                        final BundleRevision npe_invocation_var168 = CallChecker.isCalled(dependentWire, BundleWire.class, 187, 6668, 6680).getRequirer();
                                        if (CallChecker.beforeDeref(npe_invocation_var168, BundleRevision.class, 187, 6668, 6694)) {
                                            if (CallChecker.beforeDeref(result, Set.class, 187, 6657, 6662)) {
                                                result = CallChecker.beforeCalled(result, Set.class, 187, 6657, 6662);
                                                CallChecker.isCalled(result, Set.class, 187, 6657, 6662).add(CallChecker.isCalled(npe_invocation_var168, BundleRevision.class, 187, 6668, 6694).getBundle());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context447.methodEnd();
        }
    }

    public synchronized Set<Bundle> getImportingBundles(Bundle exporter, BundleCapability exportCap) {
        MethodContext _bcornu_methode_context448 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 197, 6835, 8430);
            CallChecker.varInit(exportCap, "exportCap", 197, 6835, 8430);
            CallChecker.varInit(exporter, "exporter", 197, 6835, 8430);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 197, 6835, 8430);
            Set<Bundle> result = CallChecker.varInit(new HashSet<Bundle>(), "result", 201, 7008, 7050);
            String pkgName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(exportCap, BundleCapability.class, 205, 7137, 7145)) {
                exportCap = CallChecker.beforeCalled(exportCap, BundleCapability.class, 205, 7137, 7145);
                final Map<String, Object> npe_invocation_var169 = CallChecker.isCalled(exportCap, BundleCapability.class, 205, 7137, 7145).getAttributes();
                if (CallChecker.beforeDeref(npe_invocation_var169, Map.class, 205, 7137, 7161)) {
                    pkgName = ((String) (CallChecker.isCalled(npe_invocation_var169, Map.class, 205, 7137, 7161).get(BundleRevision.PACKAGE_NAMESPACE)));
                    CallChecker.varAssign(pkgName, "pkgName", 205, 7137, 7145);
                }
            }
            exporter = CallChecker.beforeCalled(exporter, Bundle.class, 209, 7398, 7405);
            for (BundleRevision revision : CallChecker.isCalled(CallChecker.isCalled(exporter, Bundle.class, 209, 7398, 7405).adapt(BundleRevisions.class), BundleRevisions.class, 209, 7398, 7434).getRevisions()) {
                Map<BundleCapability, Set<BundleWire>> caps = CallChecker.init(Map.class);
                if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 212, 7536, 7550)) {
                    caps = CallChecker.isCalled(m_dependentsMap, Map.class, 212, 7536, 7550).get(revision);
                    CallChecker.varAssign(caps, "caps", 212, 7536, 7550);
                }
                if (caps != null) {
                    for (Map.Entry<BundleCapability, Set<BundleWire>> entry : caps.entrySet()) {
                        BundleCapability cap = CallChecker.init(BundleCapability.class);
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 217, 7759, 7763)) {
                            cap = CallChecker.isCalled(entry, Map.Entry.class, 217, 7759, 7763).getKey();
                            CallChecker.varAssign(cap, "cap", 217, 7759, 7763);
                        }
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 218, 7800, 7802)) {
                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 218, 7800, 7802);
                            final String npe_invocation_var170 = CallChecker.isCalled(cap, BundleCapability.class, 218, 7800, 7802).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var170, String.class, 218, 7800, 7817)) {
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 219, 7887, 7889)) {
                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 219, 7887, 7889);
                                    final Map<String, Object> npe_invocation_var171 = CallChecker.isCalled(cap, BundleCapability.class, 219, 7887, 7889).getAttributes();
                                    if (CallChecker.beforeDeref(npe_invocation_var171, Map.class, 219, 7887, 7905)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var171, Map.class, 219, 7887, 7905).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 219, 7887, 7943)) {
                                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 221, 8018, 8020)) {
                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 221, 8018, 8020);
                                                final String npe_invocation_var172 = CallChecker.isCalled(cap, BundleCapability.class, 221, 8018, 8020).getNamespace();
                                                if (CallChecker.beforeDeref(npe_invocation_var172, String.class, 221, 8018, 8035)) {
                                                    if (((CallChecker.isCalled(npe_invocation_var170, String.class, 218, 7800, 7817).equals(BundleRevision.PACKAGE_NAMESPACE)) && (CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var171, Map.class, 219, 7887, 7905).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 219, 7887, 7943).equals(pkgName))) || (CallChecker.isCalled(npe_invocation_var172, String.class, 221, 8018, 8035).equals(BundleRevision.BUNDLE_NAMESPACE))) {
                                                        for (BundleWire dependentWire : CallChecker.isCalled(entry, Map.Entry.class, 223, 8156, 8160).getValue()) {
                                                            if (CallChecker.beforeDeref(dependentWire, BundleWire.class, 225, 8239, 8251)) {
                                                                final BundleRevision npe_invocation_var173 = CallChecker.isCalled(dependentWire, BundleWire.class, 225, 8239, 8251).getRequirer();
                                                                if (CallChecker.beforeDeref(npe_invocation_var173, BundleRevision.class, 225, 8239, 8265)) {
                                                                    if (CallChecker.beforeDeref(result, Set.class, 225, 8228, 8233)) {
                                                                        result = CallChecker.beforeCalled(result, Set.class, 225, 8228, 8233);
                                                                        CallChecker.isCalled(result, Set.class, 225, 8228, 8233).add(CallChecker.isCalled(npe_invocation_var173, BundleRevision.class, 225, 8239, 8265).getBundle());
                                                                    }
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
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context448.methodEnd();
        }
    }

    public synchronized Set<Bundle> getRequiringBundles(Bundle bundle) {
        MethodContext _bcornu_methode_context449 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 236, 8437, 9505);
            CallChecker.varInit(bundle, "bundle", 236, 8437, 9505);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 236, 8437, 9505);
            Set<Bundle> result = CallChecker.varInit(new HashSet<Bundle>(), "result", 239, 8571, 8613);
            bundle = CallChecker.beforeCalled(bundle, Bundle.class, 242, 8717, 8722);
            for (BundleRevision revision : CallChecker.isCalled(CallChecker.isCalled(bundle, Bundle.class, 242, 8717, 8722).adapt(BundleRevisions.class), BundleRevisions.class, 242, 8717, 8751).getRevisions()) {
                Map<BundleCapability, Set<BundleWire>> caps = CallChecker.init(Map.class);
                if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 245, 8853, 8867)) {
                    caps = CallChecker.isCalled(m_dependentsMap, Map.class, 245, 8853, 8867).get(revision);
                    CallChecker.varAssign(caps, "caps", 245, 8853, 8867);
                }
                if (caps != null) {
                    for (Map.Entry<BundleCapability, Set<BundleWire>> entry : caps.entrySet()) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 250, 9057, 9061)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 250, 9057, 9061).getKey(), BundleCapability.class, 250, 9057, 9070)) {
                                final String npe_invocation_var174 = CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 250, 9057, 9061).getKey(), BundleCapability.class, 250, 9057, 9070).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var174, String.class, 250, 9057, 9085)) {
                                    if (CallChecker.isCalled(npe_invocation_var174, String.class, 250, 9057, 9085).equals(BundleRevision.BUNDLE_NAMESPACE)) {
                                        for (BundleWire dependentWire : CallChecker.isCalled(entry, Map.Entry.class, 253, 9231, 9235).getValue()) {
                                            if (CallChecker.beforeDeref(dependentWire, BundleWire.class, 255, 9314, 9326)) {
                                                final BundleRevision npe_invocation_var175 = CallChecker.isCalled(dependentWire, BundleWire.class, 255, 9314, 9326).getRequirer();
                                                if (CallChecker.beforeDeref(npe_invocation_var175, BundleRevision.class, 255, 9314, 9340)) {
                                                    if (CallChecker.beforeDeref(result, Set.class, 255, 9303, 9308)) {
                                                        result = CallChecker.beforeCalled(result, Set.class, 255, 9303, 9308);
                                                        CallChecker.isCalled(result, Set.class, 255, 9303, 9308).add(CallChecker.isCalled(npe_invocation_var175, BundleRevision.class, 255, 9314, 9340).getBundle());
                                                    }
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
                        
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context449.methodEnd();
        }
    }

    public synchronized void removeDependencies(Bundle bundle) {
        MethodContext _bcornu_methode_context450 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 266, 9512, 10970);
            CallChecker.varInit(bundle, "bundle", 266, 9512, 10970);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 266, 9512, 10970);
            List<BundleRevision> revs = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 268, 9613, 9618)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 268, 9613, 9618);
                final BundleRevisions npe_invocation_var176 = CallChecker.isCalled(bundle, Bundle.class, 268, 9613, 9618).adapt(BundleRevisions.class);
                if (CallChecker.beforeDeref(npe_invocation_var176, BundleRevisions.class, 268, 9613, 9647)) {
                    revs = CallChecker.isCalled(npe_invocation_var176, BundleRevisions.class, 268, 9613, 9647).getRevisions();
                    CallChecker.varAssign(revs, "revs", 268, 9613, 9618);
                }
            }
            if (CallChecker.beforeDeref(revs, void.class, 269, 9699, 9702)) {
                for (BundleRevision rev : revs) {
                    BundleWiring wiring = CallChecker.init(BundleWiring.class);
                    if (CallChecker.beforeDeref(rev, BundleRevision.class, 271, 9749, 9751)) {
                        wiring = CallChecker.isCalled(rev, BundleRevision.class, 271, 9749, 9751).getWiring();
                        CallChecker.varAssign(wiring, "wiring", 271, 9749, 9751);
                    }
                    if (wiring != null) {
                        for (BundleWire bw : wiring.getRequiredWires(null)) {
                            Map<BundleCapability, Set<BundleWire>> caps = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(bw, BundleWire.class, 277, 10008, 10009)) {
                                if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 277, 9988, 10002)) {
                                    caps = CallChecker.isCalled(m_dependentsMap, Map.class, 277, 9988, 10002).get(CallChecker.isCalled(bw, BundleWire.class, 277, 10008, 10009).getProvider());
                                    CallChecker.varAssign(caps, "caps", 277, 10008, 10009);
                                }
                            }
                            if (caps != null) {
                                List<BundleCapability> gc = CallChecker.varInit(new ArrayList<BundleCapability>(), "gc", 280, 10111, 10172);
                                for (Map.Entry<BundleCapability, Set<BundleWire>> entry : caps.entrySet()) {
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 284, 10351, 10355)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 284, 10351, 10355).getValue(), Set.class, 284, 10351, 10366)) {
                                            CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 284, 10351, 10355).getValue(), Set.class, 284, 10351, 10366).remove(bw);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 285, 10412, 10416)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 285, 10412, 10416).getValue(), Set.class, 285, 10412, 10427)) {
                                            if (CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 285, 10412, 10416).getValue(), Set.class, 285, 10412, 10427).isEmpty()) {
                                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 287, 10509, 10513)) {
                                                    if (CallChecker.beforeDeref(gc, List.class, 287, 10502, 10503)) {
                                                        gc = CallChecker.beforeCalled(gc, List.class, 287, 10502, 10503);
                                                        CallChecker.isCalled(gc, List.class, 287, 10502, 10503).add(CallChecker.isCalled(entry, Map.Entry.class, 287, 10509, 10513).getKey());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(gc, void.class, 290, 10634, 10635)) {
                                    for (BundleCapability cap : gc) {
                                        caps.remove(cap);
                                    }
                                }
                                if (caps.isEmpty()) {
                                    if (CallChecker.beforeDeref(bw, BundleWire.class, 296, 10857, 10858)) {
                                        if (CallChecker.beforeDeref(m_dependentsMap, Map.class, 296, 10834, 10848)) {
                                            CallChecker.isCalled(m_dependentsMap, Map.class, 296, 10834, 10848).remove(CallChecker.isCalled(bw, BundleWire.class, 296, 10857, 10858).getProvider());
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
            _bcornu_methode_context450.methodEnd();
        }
    }

    public synchronized void dump() {
        MethodContext _bcornu_methode_context451 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 304, 10977, 11505);
            CallChecker.varInit(this.m_dependentsMap, "m_dependentsMap", 304, 10977, 11505);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context451.methodEnd();
        }
    }
}

