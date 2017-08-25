package org.apache.felix.framework;

import org.osgi.resource.Wiring;
import org.osgi.resource.Wire;
import org.osgi.framework.Version;
import org.apache.felix.framework.util.Util;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.StringTokenizer;
import org.apache.felix.framework.capabilityset.SimpleFilter;
import org.apache.felix.framework.util.ShrinkableCollection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.felix.framework.cache.Content;
import org.osgi.framework.Constants;
import java.util.Collections;
import java.util.Collection;
import org.apache.felix.framework.capabilityset.CapabilitySet;
import org.osgi.resource.Capability;
import org.apache.felix.framework.resolver.CandidateComparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWiring;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.BundleRequirement;
import org.apache.felix.framework.wiring.BundleRequirementImpl;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleWire;
import org.apache.felix.framework.wiring.BundleWireImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.felix.framework.util.manifestparser.NativeLibrary;
import org.osgi.framework.PackagePermission;
import org.osgi.resource.Requirement;
import org.osgi.service.resolver.ResolutionException;
import org.apache.felix.framework.resolver.ResolveException;
import org.osgi.service.resolver.Resolver;
import org.osgi.framework.hooks.resolver.ResolverHook;
import org.osgi.framework.hooks.resolver.ResolverHookFactory;
import org.apache.felix.resolver.ResolverImpl;
import org.osgi.resource.Resource;
import org.apache.felix.framework.util.SecureAction;
import org.osgi.framework.ServiceReference;
import java.util.Set;

class StatefulResolver {
    private final Logger m_logger;

    private final Felix m_felix;

    private final ServiceRegistry m_registry;

    private final ResolverImpl m_resolver;

    private boolean m_isResolving = false;

    private final Set<BundleRevision> m_revisions;

    private final Set<BundleRevision> m_fragments;

    private final Map<String, CapabilitySet> m_capSets;

    private final Map<String, List<BundleRevision>> m_singletons;

    private final Set<BundleRevision> m_selectedSingletons;

    private final String m_fwkExecEnvStr;

    private final Set<String> m_fwkExecEnvSet;

    StatefulResolver(Felix felix, ServiceRegistry registry) {
        MethodContext _bcornu_methode_context13 = new MethodContext(null);
        try {
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 93, 3725, 3740);
            m_registry = registry;
            CallChecker.varAssign(this.m_registry, "this.m_registry", 94, 3750, 3771);
            m_logger = CallChecker.isCalled(m_felix, Felix.class, 95, 3792, 3798).getLogger();
            CallChecker.varAssign(this.m_logger, "this.m_logger", 95, 3781, 3811);
            m_resolver = new ResolverImpl(m_logger);
            CallChecker.varAssign(this.m_resolver, "this.m_resolver", 96, 3821, 3860);
            m_revisions = new HashSet<BundleRevision>();
            CallChecker.varAssign(this.m_revisions, "this.m_revisions", 98, 3871, 3914);
            m_fragments = new HashSet<BundleRevision>();
            CallChecker.varAssign(this.m_fragments, "this.m_fragments", 99, 3924, 3967);
            m_capSets = new HashMap<String, CapabilitySet>();
            CallChecker.varAssign(this.m_capSets, "this.m_capSets", 100, 3977, 4025);
            m_singletons = new HashMap<String, List<BundleRevision>>();
            CallChecker.varAssign(this.m_singletons, "this.m_singletons", 101, 4035, 4093);
            m_selectedSingletons = new HashSet<BundleRevision>();
            CallChecker.varAssign(this.m_selectedSingletons, "this.m_selectedSingletons", 102, 4103, 4155);
            String fwkExecEnvStr = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 105, 4210, 4216)) {
                final Map npe_invocation_var78 = CallChecker.isCalled(m_felix, Felix.class, 105, 4210, 4216).getConfig();
                if (CallChecker.beforeDeref(npe_invocation_var78, Map.class, 105, 4210, 4228)) {
                    fwkExecEnvStr = ((String) (CallChecker.isCalled(npe_invocation_var78, Map.class, 105, 4210, 4228).get(Constants.FRAMEWORK_EXECUTIONENVIRONMENT)));
                    CallChecker.varAssign(fwkExecEnvStr, "fwkExecEnvStr", 105, 4210, 4216);
                }
            }
            if (fwkExecEnvStr != null) {
                m_fwkExecEnvStr = fwkExecEnvStr.trim();
                CallChecker.varAssign(this.m_fwkExecEnvStr, "this.m_fwkExecEnvStr", 106, 4285, 4356);
            }else {
                m_fwkExecEnvStr = null;
                CallChecker.varAssign(this.m_fwkExecEnvStr, "this.m_fwkExecEnvStr", 106, 4285, 4356);
            }
            m_fwkExecEnvSet = StatefulResolver.parseExecutionEnvironments(fwkExecEnvStr);
            CallChecker.varAssign(this.m_fwkExecEnvSet, "this.m_fwkExecEnvSet", 107, 4366, 4425);
            List<String> indices = CallChecker.varInit(new ArrayList<String>(), "indices", 109, 4436, 4482);
            if (CallChecker.beforeDeref(indices, List.class, 110, 4492, 4498)) {
                indices = CallChecker.beforeCalled(indices, List.class, 110, 4492, 4498);
                CallChecker.isCalled(indices, List.class, 110, 4492, 4498).add(BundleRevision.BUNDLE_NAMESPACE);
            }
            if (CallChecker.beforeDeref(m_capSets, Map.class, 111, 4546, 4554)) {
                CallChecker.isCalled(m_capSets, Map.class, 111, 4546, 4554).put(BundleRevision.BUNDLE_NAMESPACE, new CapabilitySet(indices, true));
            }
            indices = new ArrayList<String>();
            CallChecker.varAssign(indices, "indices", 113, 4637, 4670);
            if (CallChecker.beforeDeref(indices, List.class, 114, 4680, 4686)) {
                indices = CallChecker.beforeCalled(indices, List.class, 114, 4680, 4686);
                CallChecker.isCalled(indices, List.class, 114, 4680, 4686).add(BundleRevision.PACKAGE_NAMESPACE);
            }
            if (CallChecker.beforeDeref(m_capSets, Map.class, 115, 4735, 4743)) {
                CallChecker.isCalled(m_capSets, Map.class, 115, 4735, 4743).put(BundleRevision.PACKAGE_NAMESPACE, new CapabilitySet(indices, true));
            }
            indices = new ArrayList<String>();
            CallChecker.varAssign(indices, "indices", 117, 4827, 4860);
            if (CallChecker.beforeDeref(indices, List.class, 118, 4870, 4876)) {
                indices = CallChecker.beforeCalled(indices, List.class, 118, 4870, 4876);
                CallChecker.isCalled(indices, List.class, 118, 4870, 4876).add(BundleRevision.HOST_NAMESPACE);
            }
            if (CallChecker.beforeDeref(m_capSets, Map.class, 119, 4922, 4930)) {
                CallChecker.isCalled(m_capSets, Map.class, 119, 4922, 4930).put(BundleRevision.HOST_NAMESPACE, new CapabilitySet(indices, true));
            }
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    void start() {
        MethodContext _bcornu_methode_context153 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 122, 5014, 5191);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 122, 5014, 5191);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 122, 5014, 5191);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 122, 5014, 5191);
            CallChecker.varInit(this.m_singletons, "m_singletons", 122, 5014, 5191);
            CallChecker.varInit(this.m_capSets, "m_capSets", 122, 5014, 5191);
            CallChecker.varInit(this.m_fragments, "m_fragments", 122, 5014, 5191);
            CallChecker.varInit(this.m_revisions, "m_revisions", 122, 5014, 5191);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 122, 5014, 5191);
            CallChecker.varInit(this.m_resolver, "m_resolver", 122, 5014, 5191);
            CallChecker.varInit(this.m_registry, "m_registry", 122, 5014, 5191);
            CallChecker.varInit(this.m_felix, "m_felix", 122, 5014, 5191);
            CallChecker.varInit(this.m_logger, "m_logger", 122, 5014, 5191);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 124, 5041, 5050)) {
                CallChecker.isCalled(m_registry, ServiceRegistry.class, 124, 5041, 5050).registerService(m_felix, new String[]{ Resolver.class.getName() }, m_resolver, null);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context153.methodEnd();
        }
    }

    synchronized void addRevision(BundleRevision br) {
        MethodContext _bcornu_methode_context154 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 130, 5198, 6205);
            CallChecker.varInit(br, "br", 130, 5198, 6205);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 130, 5198, 6205);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 130, 5198, 6205);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 130, 5198, 6205);
            CallChecker.varInit(this.m_singletons, "m_singletons", 130, 5198, 6205);
            CallChecker.varInit(this.m_capSets, "m_capSets", 130, 5198, 6205);
            CallChecker.varInit(this.m_fragments, "m_fragments", 130, 5198, 6205);
            CallChecker.varInit(this.m_revisions, "m_revisions", 130, 5198, 6205);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 130, 5198, 6205);
            CallChecker.varInit(this.m_resolver, "m_resolver", 130, 5198, 6205);
            CallChecker.varInit(this.m_registry, "m_registry", 130, 5198, 6205);
            CallChecker.varInit(this.m_felix, "m_felix", 130, 5198, 6205);
            CallChecker.varInit(this.m_logger, "m_logger", 130, 5198, 6205);
            removeRevision(br);
            if (CallChecker.beforeDeref(m_revisions, Set.class, 137, 5447, 5457)) {
                CallChecker.isCalled(m_revisions, Set.class, 137, 5447, 5457).add(br);
            }
            boolean isSingleton = CallChecker.varInit(((boolean) (Util.isSingleton(br))), "isSingleton", 140, 5525, 5567);
            if (isSingleton) {
                StatefulResolver.addToSingletonMap(m_singletons, br);
            }
            if (CallChecker.beforeDeref(br, BundleRevision.class, 151, 6019, 6020)) {
                br = CallChecker.beforeCalled(br, BundleRevision.class, 151, 6019, 6020);
                if ((!isSingleton) || ((CallChecker.isCalled(br, BundleRevision.class, 151, 6019, 6020).getWiring()) != null)) {
                    if (Util.isFragment(br)) {
                        if (CallChecker.beforeDeref(m_fragments, Set.class, 155, 6121, 6131)) {
                            CallChecker.isCalled(m_fragments, Set.class, 155, 6121, 6131).add(br);
                        }
                    }
                    indexCapabilities(br);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    synchronized void removeRevision(BundleRevision br) {
        MethodContext _bcornu_methode_context155 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 161, 6212, 6830);
            CallChecker.varInit(br, "br", 161, 6212, 6830);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 161, 6212, 6830);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 161, 6212, 6830);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 161, 6212, 6830);
            CallChecker.varInit(this.m_singletons, "m_singletons", 161, 6212, 6830);
            CallChecker.varInit(this.m_capSets, "m_capSets", 161, 6212, 6830);
            CallChecker.varInit(this.m_fragments, "m_fragments", 161, 6212, 6830);
            CallChecker.varInit(this.m_revisions, "m_revisions", 161, 6212, 6830);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 161, 6212, 6830);
            CallChecker.varInit(this.m_resolver, "m_resolver", 161, 6212, 6830);
            CallChecker.varInit(this.m_registry, "m_registry", 161, 6212, 6830);
            CallChecker.varInit(this.m_felix, "m_felix", 161, 6212, 6830);
            CallChecker.varInit(this.m_logger, "m_logger", 161, 6212, 6830);
            if (CallChecker.beforeDeref(m_revisions, Set.class, 163, 6282, 6292)) {
                if (CallChecker.isCalled(m_revisions, Set.class, 163, 6282, 6292).remove(br)) {
                    if (CallChecker.beforeDeref(m_fragments, Set.class, 165, 6328, 6338)) {
                        CallChecker.isCalled(m_fragments, Set.class, 165, 6328, 6338).remove(br);
                    }
                    deindexCapabilities(br);
                    List<BundleRevision> revisions = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 170, 6552, 6553)) {
                        if (CallChecker.beforeDeref(m_singletons, Map.class, 170, 6535, 6546)) {
                            br = CallChecker.beforeCalled(br, BundleRevision.class, 170, 6552, 6553);
                            revisions = CallChecker.isCalled(m_singletons, Map.class, 170, 6535, 6546).get(CallChecker.isCalled(br, BundleRevision.class, 170, 6552, 6553).getSymbolicName());
                            CallChecker.varAssign(revisions, "revisions", 170, 6552, 6553);
                        }
                    }
                    if (revisions != null) {
                        revisions.remove(br);
                        if (revisions.isEmpty()) {
                            if (CallChecker.beforeDeref(br, BundleRevision.class, 176, 6761, 6762)) {
                                if (CallChecker.beforeDeref(m_singletons, Map.class, 176, 6741, 6752)) {
                                    br = CallChecker.beforeCalled(br, BundleRevision.class, 176, 6761, 6762);
                                    CallChecker.isCalled(m_singletons, Map.class, 176, 6741, 6752).remove(CallChecker.isCalled(br, BundleRevision.class, 176, 6761, 6762).getSymbolicName());
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
            _bcornu_methode_context155.methodEnd();
        }
    }

    boolean isEffective(Requirement req) {
        MethodContext _bcornu_methode_context156 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 182, 6837, 7054);
            CallChecker.varInit(req, "req", 182, 6837, 7054);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 182, 6837, 7054);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 182, 6837, 7054);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 182, 6837, 7054);
            CallChecker.varInit(this.m_singletons, "m_singletons", 182, 6837, 7054);
            CallChecker.varInit(this.m_capSets, "m_capSets", 182, 6837, 7054);
            CallChecker.varInit(this.m_fragments, "m_fragments", 182, 6837, 7054);
            CallChecker.varInit(this.m_revisions, "m_revisions", 182, 6837, 7054);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 182, 6837, 7054);
            CallChecker.varInit(this.m_resolver, "m_resolver", 182, 6837, 7054);
            CallChecker.varInit(this.m_registry, "m_registry", 182, 6837, 7054);
            CallChecker.varInit(this.m_felix, "m_felix", 182, 6837, 7054);
            CallChecker.varInit(this.m_logger, "m_logger", 182, 6837, 7054);
            String effective = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(req, Requirement.class, 184, 6907, 6909)) {
                req = CallChecker.beforeCalled(req, Requirement.class, 184, 6907, 6909);
                final Map<String, String> npe_invocation_var79 = CallChecker.isCalled(req, Requirement.class, 184, 6907, 6909).getDirectives();
                if (CallChecker.beforeDeref(npe_invocation_var79, Map.class, 184, 6907, 6925)) {
                    effective = CallChecker.isCalled(npe_invocation_var79, Map.class, 184, 6907, 6925).get(Constants.EFFECTIVE_DIRECTIVE);
                    CallChecker.varAssign(effective, "effective", 184, 6907, 6909);
                }
            }
            effective = CallChecker.beforeCalled(effective, String.class, 185, 7002, 7010);
            return (effective == null) || (CallChecker.isCalled(effective, String.class, 185, 7002, 7010).equals(Constants.EFFECTIVE_RESOLVE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    synchronized List<BundleCapability> findProviders(BundleRequirement req, boolean obeyMandatory) {
        MethodContext _bcornu_methode_context157 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 188, 7061, 7404);
            CallChecker.varInit(obeyMandatory, "obeyMandatory", 188, 7061, 7404);
            CallChecker.varInit(req, "req", 188, 7061, 7404);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 188, 7061, 7404);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 188, 7061, 7404);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 188, 7061, 7404);
            CallChecker.varInit(this.m_singletons, "m_singletons", 188, 7061, 7404);
            CallChecker.varInit(this.m_capSets, "m_capSets", 188, 7061, 7404);
            CallChecker.varInit(this.m_fragments, "m_fragments", 188, 7061, 7404);
            CallChecker.varInit(this.m_revisions, "m_revisions", 188, 7061, 7404);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 188, 7061, 7404);
            CallChecker.varInit(this.m_resolver, "m_resolver", 188, 7061, 7404);
            CallChecker.varInit(this.m_registry, "m_registry", 188, 7061, 7404);
            CallChecker.varInit(this.m_felix, "m_felix", 188, 7061, 7404);
            CallChecker.varInit(this.m_logger, "m_logger", 188, 7061, 7404);
            StatefulResolver.ResolverHookRecord record = CallChecker.varInit(new StatefulResolver.ResolverHookRecord(Collections.<ServiceReference<ResolverHookFactory>, ResolverHook>emptyMap(), null), "record", 191, 7180, 7326);
            return findProvidersInternal(record, req, obeyMandatory, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context157.methodEnd();
        }
    }

    synchronized List<BundleCapability> findProvidersInternal(final StatefulResolver.ResolverHookRecord record, final Requirement req, final boolean obeyMandatory, final boolean invokeHooksAndSecurity) {
        MethodContext _bcornu_methode_context158 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 196, 7411, 11221);
            CallChecker.varInit(invokeHooksAndSecurity, "invokeHooksAndSecurity", 196, 7411, 11221);
            CallChecker.varInit(obeyMandatory, "obeyMandatory", 196, 7411, 11221);
            CallChecker.varInit(req, "req", 196, 7411, 11221);
            CallChecker.varInit(record, "record", 196, 7411, 11221);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 196, 7411, 11221);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 196, 7411, 11221);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 196, 7411, 11221);
            CallChecker.varInit(this.m_singletons, "m_singletons", 196, 7411, 11221);
            CallChecker.varInit(this.m_capSets, "m_capSets", 196, 7411, 11221);
            CallChecker.varInit(this.m_fragments, "m_fragments", 196, 7411, 11221);
            CallChecker.varInit(this.m_revisions, "m_revisions", 196, 7411, 11221);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 196, 7411, 11221);
            CallChecker.varInit(this.m_resolver, "m_resolver", 196, 7411, 11221);
            CallChecker.varInit(this.m_registry, "m_registry", 196, 7411, 11221);
            CallChecker.varInit(this.m_felix, "m_felix", 196, 7411, 11221);
            CallChecker.varInit(this.m_logger, "m_logger", 196, 7411, 11221);
            List<BundleCapability> result = CallChecker.varInit(new ArrayList<BundleCapability>(), "result", 202, 7639, 7704);
            CapabilitySet capSet = CallChecker.init(CapabilitySet.class);
            if (CallChecker.beforeDeref(req, Requirement.class, 204, 7752, 7754)) {
                if (CallChecker.beforeDeref(m_capSets, Map.class, 204, 7738, 7746)) {
                    capSet = CallChecker.isCalled(m_capSets, Map.class, 204, 7738, 7746).get(CallChecker.isCalled(req, Requirement.class, 204, 7752, 7754).getNamespace());
                    CallChecker.varAssign(capSet, "capSet", 204, 7752, 7754);
                }
            }
            if (capSet != null) {
                SimpleFilter sf = CallChecker.init(SimpleFilter.class);
                if (req instanceof BundleRequirementImpl) {
                    if (CallChecker.beforeDeref(req, Requirement.class, 213, 8153, 8155)) {
                        sf = CallChecker.isCalled(((BundleRequirementImpl) (req)), BundleRequirementImpl.class, 213, 8153, 8155).getFilter();
                        CallChecker.varAssign(sf, "sf", 213, 8123, 8169);
                    }
                }else {
                    String filter = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(req, Requirement.class, 217, 8248, 8250)) {
                        final Map<String, String> npe_invocation_var80 = CallChecker.isCalled(req, Requirement.class, 217, 8248, 8250).getDirectives();
                        if (CallChecker.beforeDeref(npe_invocation_var80, Map.class, 217, 8248, 8266)) {
                            filter = CallChecker.isCalled(npe_invocation_var80, Map.class, 217, 8248, 8266).get(Constants.FILTER_DIRECTIVE);
                            CallChecker.varAssign(filter, "filter", 217, 8248, 8250);
                        }
                    }
                    if (filter == null) {
                        sf = new SimpleFilter(null, null, SimpleFilter.MATCH_ALL);
                        CallChecker.varAssign(sf, "sf", 220, 8375, 8432);
                    }else {
                        sf = SimpleFilter.parse(filter);
                        CallChecker.varAssign(sf, "sf", 224, 8511, 8542);
                    }
                }
                Set<Capability> matches = CallChecker.varInit(capSet.match(sf, obeyMandatory), "matches", 229, 8634, 8691);
                if (CallChecker.beforeDeref(matches, List.class, 231, 8770, 8776)) {
                    for (Capability cap : matches) {
                        if (!(cap instanceof BundleCapability))
                            continue;
                        
                        BundleCapability bcap = CallChecker.varInit(((BundleCapability) (cap)), "bcap", 236, 8896, 8942);
                        if (invokeHooksAndSecurity && (filteredBySecurity(((BundleRequirement) (req)), bcap))) {
                            continue;
                        }
                        if (CallChecker.beforeDeref(req, Requirement.class, 245, 9301, 9303)) {
                            final String npe_invocation_var81 = CallChecker.isCalled(req, Requirement.class, 245, 9301, 9303).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var81, String.class, 245, 9301, 9318)) {
                                if (CallChecker.beforeDeref(bcap, BundleCapability.class, 246, 9382, 9385)) {
                                    bcap = CallChecker.beforeCalled(bcap, BundleCapability.class, 246, 9382, 9385);
                                    final BundleRevision npe_invocation_var82 = CallChecker.isCalled(bcap, BundleCapability.class, 246, 9382, 9385).getRevision();
                                    if (CallChecker.beforeDeref(npe_invocation_var82, BundleRevision.class, 246, 9382, 9399)) {
                                        if ((CallChecker.isCalled(npe_invocation_var81, String.class, 245, 9301, 9318).equals(BundleRevision.HOST_NAMESPACE)) && ((CallChecker.isCalled(npe_invocation_var82, BundleRevision.class, 246, 9382, 9399).getWiring()) != null)) {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(result, List.class, 251, 9506, 9511)) {
                            result = CallChecker.beforeCalled(result, List.class, 251, 9506, 9511);
                            CallChecker.isCalled(result, List.class, 251, 9506, 9511).add(bcap);
                        }
                    }
                }
            }
            if (invokeHooksAndSecurity) {
                if (CallChecker.beforeDeref(result, List.class, 259, 9772, 9777)) {
                    if (CallChecker.beforeDeref(record, StatefulResolver.ResolverHookRecord.class, 259, 9793, 9798)) {
                        final Set<ServiceReference<ResolverHookFactory>> npe_invocation_var83 = CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 259, 9793, 9798).getResolverHookRefs();
                        if (CallChecker.beforeDeref(npe_invocation_var83, Set.class, 259, 9793, 9820)) {
                            result = CallChecker.beforeCalled(result, List.class, 259, 9772, 9777);
                            if ((!(CallChecker.isCalled(result, List.class, 259, 9772, 9777).isEmpty())) && (!(CallChecker.isCalled(npe_invocation_var83, Set.class, 259, 9793, 9820).isEmpty()))) {
                                if (CallChecker.beforeDeref(record, StatefulResolver.ResolverHookRecord.class, 263, 9989, 9994)) {
                                    if ((CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 263, 9989, 9994).getBundleRevisionWhitelist()) != null) {
                                        result = CallChecker.beforeCalled(result, List.class, 265, 10109, 10114);
                                        for (Iterator<BundleCapability> it = CallChecker.isCalled(result, List.class, 265, 10109, 10114).iterator(); CallChecker.isCalled(it, Iterator.class, 265, 10128, 10129).hasNext();) {
                                            if (CallChecker.beforeDeref(record, StatefulResolver.ResolverHookRecord.class, 267, 10195, 10200)) {
                                                if (CallChecker.beforeDeref(it, Iterator.class, 267, 10240, 10241)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(it, Iterator.class, 267, 10240, 10241).next(), BundleCapability.class, 267, 10240, 10248)) {
                                                        if (!(CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 267, 10195, 10200).getBundleRevisionWhitelist().contains(CallChecker.isCalled(CallChecker.isCalled(it, Iterator.class, 267, 10240, 10241).next(), BundleCapability.class, 267, 10240, 10248).getRevision()))) {
                                                            if (CallChecker.beforeDeref(it, Iterator.class, 269, 10320, 10321)) {
                                                                CallChecker.isCalled(it, Iterator.class, 269, 10320, 10321).remove();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                ShrinkableCollection<BundleCapability> shrinkable = CallChecker.varInit(new ShrinkableCollection<BundleCapability>(result), "shrinkable", 275, 10493, 10615);
                                for (ResolverHook hook : CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 277, 10658, 10663).getResolverHooks()) {
                                    TryContext _bcornu_try_context_22 = new TryContext(22, StatefulResolver.class, "java.lang.Throwable");
                                    try {
                                        if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 281, 10773, 10792)) {
                                            CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 281, 10773, 10792).invokeResolverHookMatches(hook, ((BundleRequirement) (req)), shrinkable);
                                        }
                                    } catch (Throwable th) {
                                        _bcornu_try_context_22.catchStart(22);
                                        if (CallChecker.beforeDeref(m_logger, Logger.class, 286, 11001, 11008)) {
                                            CallChecker.isCalled(m_logger, Logger.class, 286, 11001, 11008).log(Logger.LOG_WARNING, "Resolver hook exception.", th);
                                        }
                                    } finally {
                                        _bcornu_try_context_22.finallyStart(22);
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
            Collections.sort(result, new CandidateComparator());
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context158.methodEnd();
        }
    }

    private boolean filteredBySecurity(BundleRequirement req, BundleCapability cap) {
        MethodContext _bcornu_methode_context159 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 297, 11228, 14488);
            CallChecker.varInit(cap, "cap", 297, 11228, 14488);
            CallChecker.varInit(req, "req", 297, 11228, 14488);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 297, 11228, 14488);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 297, 11228, 14488);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 297, 11228, 14488);
            CallChecker.varInit(this.m_singletons, "m_singletons", 297, 11228, 14488);
            CallChecker.varInit(this.m_capSets, "m_capSets", 297, 11228, 14488);
            CallChecker.varInit(this.m_fragments, "m_fragments", 297, 11228, 14488);
            CallChecker.varInit(this.m_revisions, "m_revisions", 297, 11228, 14488);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 297, 11228, 14488);
            CallChecker.varInit(this.m_resolver, "m_resolver", 297, 11228, 14488);
            CallChecker.varInit(this.m_registry, "m_registry", 297, 11228, 14488);
            CallChecker.varInit(this.m_felix, "m_felix", 297, 11228, 14488);
            CallChecker.varInit(this.m_logger, "m_logger", 297, 11228, 14488);
            if ((System.getSecurityManager()) != null) {
                BundleRevisionImpl reqRevision = CallChecker.init(BundleRevisionImpl.class);
                if (CallChecker.beforeDeref(req, BundleRequirement.class, 301, 11439, 11441)) {
                    req = CallChecker.beforeCalled(req, BundleRequirement.class, 301, 11439, 11441);
                    reqRevision = ((BundleRevisionImpl) (CallChecker.isCalled(req, BundleRequirement.class, 301, 11439, 11441).getRevision()));
                    CallChecker.varAssign(reqRevision, "reqRevision", 301, 11439, 11441);
                }
                if (CallChecker.beforeDeref(req, BundleRequirement.class, 303, 11475, 11477)) {
                    req = CallChecker.beforeCalled(req, BundleRequirement.class, 303, 11475, 11477);
                    final String npe_invocation_var84 = CallChecker.isCalled(req, BundleRequirement.class, 303, 11475, 11477).getNamespace();
                    if (CallChecker.beforeDeref(npe_invocation_var84, String.class, 303, 11475, 11492)) {
                        if (CallChecker.isCalled(npe_invocation_var84, String.class, 303, 11475, 11492).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 305, 11619, 11621)) {
                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 305, 11619, 11621);
                                final BundleRevisionImpl npe_invocation_var85 = ((BundleRevisionImpl) (CallChecker.isCalled(cap, BundleCapability.class, 305, 11619, 11621).getRevision()));
                                if (CallChecker.beforeDeref(npe_invocation_var85, BundleRevisionImpl.class, 305, 11619, 11635)) {
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 306, 11727, 11729)) {
                                        cap = CallChecker.beforeCalled(cap, BundleCapability.class, 306, 11727, 11729);
                                        final Map<String, Object> npe_invocation_var86 = CallChecker.isCalled(cap, BundleCapability.class, 306, 11727, 11729).getAttributes();
                                        if (CallChecker.beforeDeref(npe_invocation_var86, Map.class, 306, 11727, 11745)) {
                                            final BundleProtectionDomain npe_invocation_var87 = ((BundleProtectionDomain) (CallChecker.isCalled(npe_invocation_var85, BundleRevisionImpl.class, 305, 11619, 11635).getProtectionDomain()));
                                            if (CallChecker.beforeDeref(npe_invocation_var87, BundleProtectionDomain.class, 305, 11597, 11658)) {
                                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 310, 12046, 12048)) {
                                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 310, 12046, 12048);
                                                    final Map<String, Object> npe_invocation_var88 = CallChecker.isCalled(cap, BundleCapability.class, 310, 12046, 12048).getAttributes();
                                                    if (CallChecker.beforeDeref(npe_invocation_var88, Map.class, 310, 12046, 12064)) {
                                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 311, 12133, 12135)) {
                                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 311, 12133, 12135);
                                                            final BundleRevision npe_invocation_var89 = CallChecker.isCalled(cap, BundleCapability.class, 311, 12133, 12135).getRevision();
                                                            if (CallChecker.beforeDeref(npe_invocation_var89, BundleRevision.class, 311, 12133, 12149)) {
                                                                reqRevision = CallChecker.beforeCalled(reqRevision, BundleRevisionImpl.class, 309, 11937, 11947);
                                                                final BundleProtectionDomain npe_invocation_var90 = ((BundleProtectionDomain) (CallChecker.isCalled(reqRevision, BundleRevisionImpl.class, 309, 11937, 11947).getProtectionDomain()));
                                                                if (CallChecker.beforeDeref(npe_invocation_var90, BundleProtectionDomain.class, 309, 11937, 11969)) {
                                                                    if ((!(CallChecker.isCalled(npe_invocation_var87, BundleProtectionDomain.class, 305, 11597, 11658).impliesDirect(new PackagePermission(((String) (CallChecker.isCalled(npe_invocation_var86, Map.class, 306, 11727, 11745).get(BundleRevision.PACKAGE_NAMESPACE))), PackagePermission.EXPORTONLY)))) || (!((reqRevision == null) || (CallChecker.isCalled(npe_invocation_var90, BundleProtectionDomain.class, 309, 11937, 11969).impliesDirect(new PackagePermission(((String) (CallChecker.isCalled(npe_invocation_var88, Map.class, 310, 12046, 12064).get(BundleRevision.PACKAGE_NAMESPACE))), CallChecker.isCalled(npe_invocation_var89, BundleRevision.class, 311, 12133, 12149).getBundle(), PackagePermission.IMPORT)))))) {
                                                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 314, 12270, 12272)) {
                                                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 314, 12270, 12272);
                                                                            if (reqRevision != (CallChecker.isCalled(cap, BundleCapability.class, 314, 12270, 12272).getRevision())) {
                                                                                return true;
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
                            if (CallChecker.beforeDeref(req, BundleRequirement.class, 320, 12423, 12425)) {
                                req = CallChecker.beforeCalled(req, BundleRequirement.class, 320, 12423, 12425);
                                final String npe_invocation_var91 = CallChecker.isCalled(req, BundleRequirement.class, 320, 12423, 12425).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var91, String.class, 320, 12423, 12440)) {
                                    if (CallChecker.isCalled(npe_invocation_var91, String.class, 320, 12423, 12440).equals(BundleRevision.BUNDLE_NAMESPACE)) {
                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 321, 12552, 12554)) {
                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 321, 12552, 12554);
                                            final BundleRevisionImpl npe_invocation_var92 = ((BundleRevisionImpl) (CallChecker.isCalled(cap, BundleCapability.class, 321, 12552, 12554).getRevision()));
                                            if (CallChecker.beforeDeref(npe_invocation_var92, BundleRevisionImpl.class, 321, 12552, 12568)) {
                                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 322, 12650, 12652)) {
                                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 322, 12650, 12652);
                                                    final BundleRevision npe_invocation_var93 = CallChecker.isCalled(cap, BundleCapability.class, 322, 12650, 12652).getRevision();
                                                    if (CallChecker.beforeDeref(npe_invocation_var93, BundleRevision.class, 322, 12650, 12666)) {
                                                        final BundleProtectionDomain npe_invocation_var94 = ((BundleProtectionDomain) (CallChecker.isCalled(npe_invocation_var92, BundleRevisionImpl.class, 321, 12552, 12568).getProtectionDomain()));
                                                        if (CallChecker.beforeDeref(npe_invocation_var94, BundleProtectionDomain.class, 321, 12530, 12591)) {
                                                            reqRevision = CallChecker.beforeCalled(reqRevision, BundleRevisionImpl.class, 324, 12814, 12824);
                                                            final BundleProtectionDomain npe_invocation_var95 = ((BundleProtectionDomain) (CallChecker.isCalled(reqRevision, BundleRevisionImpl.class, 324, 12814, 12824).getProtectionDomain()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var95, BundleProtectionDomain.class, 324, 12814, 12846)) {
                                                                if ((!(CallChecker.isCalled(npe_invocation_var94, BundleProtectionDomain.class, 321, 12530, 12591).impliesDirect(new org.osgi.framework.BundlePermission(CallChecker.isCalled(npe_invocation_var93, BundleRevision.class, 322, 12650, 12666).getSymbolicName(), org.osgi.framework.BundlePermission.PROVIDE)))) || (!((reqRevision == null) || (CallChecker.isCalled(npe_invocation_var95, BundleProtectionDomain.class, 324, 12814, 12846).impliesDirect(new org.osgi.framework.BundlePermission(reqRevision.getSymbolicName(), org.osgi.framework.BundlePermission.REQUIRE)))))) {
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
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        if (CallChecker.beforeDeref(req, BundleRequirement.class, 331, 13098, 13100)) {
                                            req = CallChecker.beforeCalled(req, BundleRequirement.class, 331, 13098, 13100);
                                            final String npe_invocation_var96 = CallChecker.isCalled(req, BundleRequirement.class, 331, 13098, 13100).getNamespace();
                                            if (CallChecker.beforeDeref(npe_invocation_var96, String.class, 331, 13098, 13115)) {
                                                if (CallChecker.isCalled(npe_invocation_var96, String.class, 331, 13098, 13115).equals(BundleRevision.HOST_NAMESPACE)) {
                                                    if (CallChecker.beforeDeref(reqRevision, BundleRevisionImpl.class, 333, 13217, 13227)) {
                                                        if (CallChecker.beforeDeref(reqRevision, BundleRevisionImpl.class, 335, 13333, 13343)) {
                                                            reqRevision = CallChecker.beforeCalled(reqRevision, BundleRevisionImpl.class, 333, 13217, 13227);
                                                            final BundleProtectionDomain npe_invocation_var97 = ((BundleProtectionDomain) (CallChecker.isCalled(reqRevision, BundleRevisionImpl.class, 333, 13217, 13227).getProtectionDomain()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var97, BundleProtectionDomain.class, 333, 13217, 13249)) {
                                                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 337, 13484, 13486)) {
                                                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 337, 13484, 13486);
                                                                    final BundleRevisionImpl npe_invocation_var98 = ((BundleRevisionImpl) (CallChecker.isCalled(cap, BundleCapability.class, 337, 13484, 13486).getRevision()));
                                                                    if (CallChecker.beforeDeref(npe_invocation_var98, BundleRevisionImpl.class, 337, 13484, 13500)) {
                                                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 339, 13607, 13609)) {
                                                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 339, 13607, 13609);
                                                                            final BundleRevision npe_invocation_var99 = CallChecker.isCalled(cap, BundleCapability.class, 339, 13607, 13609).getRevision();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var99, BundleRevision.class, 339, 13607, 13623)) {
                                                                                final BundleProtectionDomain npe_invocation_var100 = ((BundleProtectionDomain) (CallChecker.isCalled(npe_invocation_var98, BundleRevisionImpl.class, 337, 13484, 13500).getProtectionDomain()));
                                                                                if (CallChecker.beforeDeref(npe_invocation_var100, BundleProtectionDomain.class, 337, 13462, 13523)) {
                                                                                    reqRevision = CallChecker.beforeCalled(reqRevision, BundleRevisionImpl.class, 335, 13333, 13343);
                                                                                    if ((!(CallChecker.isCalled(npe_invocation_var97, BundleProtectionDomain.class, 333, 13217, 13249).impliesDirect(new org.osgi.framework.BundlePermission(CallChecker.isCalled(reqRevision, BundleRevisionImpl.class, 335, 13333, 13343).getSymbolicName(), org.osgi.framework.BundlePermission.FRAGMENT)))) || (!(CallChecker.isCalled(npe_invocation_var100, BundleProtectionDomain.class, 337, 13462, 13523).impliesDirect(new org.osgi.framework.BundlePermission(CallChecker.isCalled(npe_invocation_var99, BundleRevision.class, 339, 13607, 13623).getSymbolicName(), org.osgi.framework.BundlePermission.HOST))))) {
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
                                                                    
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    if (CallChecker.beforeDeref(req, BundleRequirement.class, 345, 13799, 13801)) {
                                                        req = CallChecker.beforeCalled(req, BundleRequirement.class, 345, 13799, 13801);
                                                        final String npe_invocation_var101 = CallChecker.isCalled(req, BundleRequirement.class, 345, 13799, 13801).getNamespace();
                                                        if (CallChecker.beforeDeref(npe_invocation_var101, String.class, 345, 13799, 13816)) {
                                                            if (!(CallChecker.isCalled(npe_invocation_var101, String.class, 345, 13799, 13816).equals("osgi.ee"))) {
                                                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 347, 13920, 13922)) {
                                                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 347, 13920, 13922);
                                                                    final BundleRevisionImpl npe_invocation_var102 = ((BundleRevisionImpl) (CallChecker.isCalled(cap, BundleCapability.class, 347, 13920, 13922).getRevision()));
                                                                    if (CallChecker.beforeDeref(npe_invocation_var102, BundleRevisionImpl.class, 347, 13920, 13936)) {
                                                                        if (CallChecker.beforeDeref(req, BundleRequirement.class, 348, 14022, 14024)) {
                                                                            final BundleProtectionDomain npe_invocation_var103 = ((BundleProtectionDomain) (CallChecker.isCalled(npe_invocation_var102, BundleRevisionImpl.class, 347, 13920, 13936).getProtectionDomain()));
                                                                            if (CallChecker.beforeDeref(npe_invocation_var103, BundleProtectionDomain.class, 347, 13898, 13959)) {
                                                                                if (CallChecker.beforeDeref(req, BundleRequirement.class, 351, 14264, 14266)) {
                                                                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 351, 14284, 14286)) {
                                                                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 351, 14305, 14307)) {
                                                                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 351, 14305, 14307);
                                                                                            final BundleRevision npe_invocation_var104 = CallChecker.isCalled(cap, BundleCapability.class, 351, 14305, 14307).getRevision();
                                                                                            if (CallChecker.beforeDeref(npe_invocation_var104, BundleRevision.class, 351, 14305, 14321)) {
                                                                                                reqRevision = CallChecker.beforeCalled(reqRevision, BundleRevisionImpl.class, 350, 14169, 14179);
                                                                                                final BundleProtectionDomain npe_invocation_var105 = ((BundleProtectionDomain) (CallChecker.isCalled(reqRevision, BundleRevisionImpl.class, 350, 14169, 14179).getProtectionDomain()));
                                                                                                if (CallChecker.beforeDeref(npe_invocation_var105, BundleProtectionDomain.class, 350, 14169, 14201)) {
                                                                                                    req = CallChecker.beforeCalled(req, BundleRequirement.class, 348, 14022, 14024);
                                                                                                    req = CallChecker.beforeCalled(req, BundleRequirement.class, 351, 14264, 14266);
                                                                                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 351, 14284, 14286);
                                                                                                    if ((!(CallChecker.isCalled(npe_invocation_var103, BundleProtectionDomain.class, 347, 13898, 13959).impliesDirect(new org.osgi.framework.CapabilityPermission(CallChecker.isCalled(req, BundleRequirement.class, 348, 14022, 14024).getNamespace(), org.osgi.framework.CapabilityPermission.PROVIDE)))) || (!((reqRevision == null) || (CallChecker.isCalled(npe_invocation_var105, BundleProtectionDomain.class, 350, 14169, 14201).impliesDirect(new org.osgi.framework.CapabilityPermission(CallChecker.isCalled(req, BundleRequirement.class, 351, 14264, 14266).getNamespace(), CallChecker.isCalled(cap, BundleCapability.class, 351, 14284, 14286).getAttributes(), CallChecker.isCalled(npe_invocation_var104, BundleRevision.class, 351, 14305, 14321).getBundle(), org.osgi.framework.CapabilityPermission.REQUIRE)))))) {
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context159.methodEnd();
        }
    }

    void resolve(Set<BundleRevision> mandatory, Set<BundleRevision> optional) throws BundleException, ResolutionException {
        MethodContext _bcornu_methode_context160 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 360, 14495, 18112);
            CallChecker.varInit(optional, "optional", 360, 14495, 18112);
            CallChecker.varInit(mandatory, "mandatory", 360, 14495, 18112);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 360, 14495, 18112);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 360, 14495, 18112);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 360, 14495, 18112);
            CallChecker.varInit(this.m_singletons, "m_singletons", 360, 14495, 18112);
            CallChecker.varInit(this.m_capSets, "m_capSets", 360, 14495, 18112);
            CallChecker.varInit(this.m_fragments, "m_fragments", 360, 14495, 18112);
            CallChecker.varInit(this.m_revisions, "m_revisions", 360, 14495, 18112);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 360, 14495, 18112);
            CallChecker.varInit(this.m_resolver, "m_resolver", 360, 14495, 18112);
            CallChecker.varInit(this.m_registry, "m_registry", 360, 14495, 18112);
            CallChecker.varInit(this.m_felix, "m_felix", 360, 14495, 18112);
            CallChecker.varInit(this.m_logger, "m_logger", 360, 14495, 18112);
            boolean locked = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 366, 14701, 14707)) {
                locked = CallChecker.isCalled(m_felix, Felix.class, 366, 14701, 14707).acquireGlobalLock();
                CallChecker.varAssign(locked, "locked", 366, 14701, 14707);
            }
            if (!locked) {
                throw new ResolveException("Unable to acquire global lock for resolve.", null, null);
            }
            if (m_isResolving) {
                if (CallChecker.beforeDeref(m_felix, Felix.class, 377, 15059, 15065)) {
                    CallChecker.isCalled(m_felix, Felix.class, 377, 15059, 15065).releaseGlobalLock();
                }
                throw new IllegalStateException("Nested resolve operations not allowed.");
            }
            m_isResolving = true;
            CallChecker.varAssign(this.m_isResolving, "this.m_isResolving", 380, 15193, 15213);
            Map<Resource, List<Wire>> wireMap = CallChecker.varInit(null, "wireMap", 382, 15224, 15264);
            TryContext _bcornu_try_context_24 = new TryContext(24, StatefulResolver.class);
            try {
                if (CallChecker.beforeDeref(mandatory, Set.class, 386, 15360, 15368)) {
                    mandatory = CallChecker.beforeCalled(mandatory, Set.class, 386, 15360, 15368);
                    if (CallChecker.isCalled(mandatory, Set.class, 386, 15360, 15368).isEmpty()) {
                        mandatory = mandatory;
                        CallChecker.varAssign(mandatory, "mandatory", 386, 15347, 15449);
                    }else {
                        mandatory = new HashSet<BundleRevision>(mandatory);
                        CallChecker.varAssign(mandatory, "mandatory", 386, 15347, 15449);
                    }
                }
                if (CallChecker.beforeDeref(optional, Set.class, 388, 15475, 15482)) {
                    optional = CallChecker.beforeCalled(optional, Set.class, 388, 15475, 15482);
                    if (CallChecker.isCalled(optional, Set.class, 388, 15475, 15482).isEmpty()) {
                        optional = optional;
                        CallChecker.varAssign(optional, "optional", 388, 15463, 15561);
                    }else {
                        optional = new HashSet<BundleRevision>(optional);
                        CallChecker.varAssign(optional, "optional", 388, 15463, 15561);
                    }
                }
                StatefulResolver.ResolverHookRecord record = CallChecker.varInit(prepareResolverHooks(mandatory, optional), "record", 392, 15623, 15692);
                selectSingletons(record);
                mandatory = CallChecker.beforeCalled(mandatory, Set.class, 398, 15893, 15901);
                for (Iterator<BundleRevision> it = CallChecker.isCalled(mandatory, Set.class, 398, 15893, 15901).iterator(); CallChecker.isCalled(it, Iterator.class, 398, 15915, 15916).hasNext();) {
                    BundleRevision br = CallChecker.init(BundleRevision.class);
                    if (CallChecker.beforeDeref(it, Iterator.class, 400, 15981, 15982)) {
                        br = CallChecker.isCalled(it, Iterator.class, 400, 15981, 15982).next();
                        CallChecker.varAssign(br, "br", 400, 15981, 15982);
                    }
                    BundleImpl bundle = CallChecker.init(BundleImpl.class);
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 401, 16041, 16042)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 401, 16041, 16042);
                        bundle = ((BundleImpl) (CallChecker.isCalled(br, BundleRevision.class, 401, 16041, 16042).getBundle()));
                        CallChecker.varAssign(bundle, "bundle", 401, 16041, 16042);
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 402, 16077, 16082)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 402, 16077, 16082);
                        if (CallChecker.isCalled(bundle, BundleImpl.class, 402, 16077, 16082).isExtension()) {
                            if (CallChecker.beforeDeref(it, Iterator.class, 404, 16137, 16138)) {
                                CallChecker.isCalled(it, Iterator.class, 404, 16137, 16138).remove();
                            }
                        }else
                            if ((Util.isSingleton(br)) && (!(isSelectedSingleton(br)))) {
                                throw new ResolveException("Singleton conflict.", br, null);
                            }
                        
                    }
                }
                optional = CallChecker.beforeCalled(optional, Set.class, 411, 16421, 16428);
                for (Iterator<BundleRevision> it = CallChecker.isCalled(optional, Set.class, 411, 16421, 16428).iterator(); CallChecker.isCalled(it, Iterator.class, 411, 16442, 16443).hasNext();) {
                    BundleRevision br = CallChecker.init(BundleRevision.class);
                    if (CallChecker.beforeDeref(it, Iterator.class, 413, 16508, 16509)) {
                        br = CallChecker.isCalled(it, Iterator.class, 413, 16508, 16509).next();
                        CallChecker.varAssign(br, "br", 413, 16508, 16509);
                    }
                    BundleImpl bundle = CallChecker.init(BundleImpl.class);
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 414, 16568, 16569)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 414, 16568, 16569);
                        bundle = ((BundleImpl) (CallChecker.isCalled(br, BundleRevision.class, 414, 16568, 16569).getBundle()));
                        CallChecker.varAssign(bundle, "bundle", 414, 16568, 16569);
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 415, 16604, 16609)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 415, 16604, 16609);
                        if (CallChecker.isCalled(bundle, BundleImpl.class, 415, 16604, 16609).isExtension()) {
                            if (CallChecker.beforeDeref(it, Iterator.class, 417, 16664, 16665)) {
                                CallChecker.isCalled(it, Iterator.class, 417, 16664, 16665).remove();
                            }
                        }else
                            if ((Util.isSingleton(br)) && (!(isSelectedSingleton(br)))) {
                                if (CallChecker.beforeDeref(it, Iterator.class, 421, 16808, 16809)) {
                                    CallChecker.isCalled(it, Iterator.class, 421, 16808, 16809).remove();
                                }
                            }
                        
                    }
                }
                ResolutionException rethrow = CallChecker.varInit(null, "rethrow", 427, 16994, 17028);
                TryContext _bcornu_try_context_23 = new TryContext(23, StatefulResolver.class, "org.osgi.service.resolver.ResolutionException");
                try {
                    if (CallChecker.beforeDeref(m_resolver, ResolverImpl.class, 431, 17127, 17136)) {
                        wireMap = CallChecker.isCalled(m_resolver, ResolverImpl.class, 431, 17127, 17136).resolve(new ResolveContextImpl(this, getWirings(), record, mandatory, optional, getFragments()));
                        CallChecker.varAssign(wireMap, "wireMap", 431, 17117, 17400);
                    }
                } catch (ResolutionException ex) {
                    _bcornu_try_context_23.catchStart(23);
                    rethrow = ex;
                    CallChecker.varAssign(rethrow, "rethrow", 442, 17489, 17501);
                } finally {
                    _bcornu_try_context_23.finallyStart(23);
                }
                releaseResolverHooks(record);
                if (rethrow != null) {
                    throw rethrow;
                }
                markResolvedRevisions(wireMap);
            } finally {
                _bcornu_try_context_24.finallyStart(24);
                m_isResolving = false;
                CallChecker.varAssign(this.m_isResolving, "this.m_isResolving", 460, 17949, 17970);
                if (CallChecker.beforeDeref(m_felix, Felix.class, 462, 18031, 18037)) {
                    CallChecker.isCalled(m_felix, Felix.class, 462, 18031, 18037).releaseGlobalLock();
                }
            }
            fireResolvedEvents(wireMap);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context160.methodEnd();
        }
    }

    BundleRevision resolve(BundleRevision revision, String pkgName) throws BundleException, ResolutionException {
        MethodContext _bcornu_methode_context161 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 468, 18119, 27004);
            CallChecker.varInit(pkgName, "pkgName", 468, 18119, 27004);
            CallChecker.varInit(revision, "revision", 468, 18119, 27004);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 468, 18119, 27004);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 468, 18119, 27004);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 468, 18119, 27004);
            CallChecker.varInit(this.m_singletons, "m_singletons", 468, 18119, 27004);
            CallChecker.varInit(this.m_capSets, "m_capSets", 468, 18119, 27004);
            CallChecker.varInit(this.m_fragments, "m_fragments", 468, 18119, 27004);
            CallChecker.varInit(this.m_revisions, "m_revisions", 468, 18119, 27004);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 468, 18119, 27004);
            CallChecker.varInit(this.m_resolver, "m_resolver", 468, 18119, 27004);
            CallChecker.varInit(this.m_registry, "m_registry", 468, 18119, 27004);
            CallChecker.varInit(this.m_felix, "m_felix", 468, 18119, 27004);
            CallChecker.varInit(this.m_logger, "m_logger", 468, 18119, 27004);
            BundleRevision provider = CallChecker.varInit(null, "provider", 471, 18249, 18279);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 478, 18646, 18653)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 478, 18646, 18653);
                if (((CallChecker.isCalled(revision, BundleRevision.class, 478, 18646, 18653).getWiring()) != null) && (isAllowedDynamicImport(revision, pkgName))) {
                    boolean locked = CallChecker.init(boolean.class);
                    if (CallChecker.beforeDeref(m_felix, Felix.class, 481, 18797, 18803)) {
                        locked = CallChecker.isCalled(m_felix, Felix.class, 481, 18797, 18803).acquireGlobalLock();
                        CallChecker.varAssign(locked, "locked", 481, 18797, 18803);
                    }
                    if (!locked) {
                        throw new ResolveException("Unable to acquire global lock for resolve.", revision, null);
                    }
                    if (m_isResolving) {
                        if (CallChecker.beforeDeref(m_felix, Felix.class, 492, 19199, 19205)) {
                            CallChecker.isCalled(m_felix, Felix.class, 492, 19199, 19205).releaseGlobalLock();
                        }
                        throw new IllegalStateException("Nested resolve operations not allowed.");
                    }
                    m_isResolving = true;
                    CallChecker.varAssign(this.m_isResolving, "this.m_isResolving", 495, 19345, 19365);
                    Map<Resource, List<Wire>> wireMap = CallChecker.varInit(null, "wireMap", 497, 19380, 19420);
                    TryContext _bcornu_try_context_26 = new TryContext(26, StatefulResolver.class);
                    try {
                        if (CallChecker.beforeDeref(revision, BundleRevision.class, 504, 19780, 19787)) {
                            revision = CallChecker.beforeCalled(revision, BundleRevision.class, 504, 19780, 19787);
                            final BundleWiringImpl npe_invocation_var106 = ((BundleWiringImpl) (CallChecker.isCalled(revision, BundleRevision.class, 504, 19780, 19787).getWiring()));
                            if (CallChecker.beforeDeref(npe_invocation_var106, BundleWiringImpl.class, 504, 19780, 19799)) {
                                provider = CallChecker.isCalled(npe_invocation_var106, BundleWiringImpl.class, 504, 19780, 19799).getImportedPackageSource(pkgName);
                                CallChecker.varAssign(provider, "provider", 504, 19749, 19856);
                            }
                        }
                        if (provider == null) {
                            StatefulResolver.ResolverHookRecord record = CallChecker.varInit(prepareResolverHooks(Collections.singleton(revision), Collections.EMPTY_SET), "record", 509, 19989, 20146);
                            selectSingletons(record);
                            ResolutionException rethrow = CallChecker.varInit(null, "rethrow", 518, 20428, 20462);
                            TryContext _bcornu_try_context_25 = new TryContext(25, StatefulResolver.class, "org.osgi.service.resolver.ResolutionException");
                            try {
                                List<BundleRequirement> dynamics = CallChecker.init(List.class);
                                if (CallChecker.beforeDeref(revision, BundleRevision.class, 522, 20629, 20636)) {
                                    revision = CallChecker.beforeCalled(revision, BundleRevision.class, 522, 20629, 20636);
                                    dynamics = Util.getDynamicRequirements(CallChecker.isCalled(revision, BundleRevision.class, 522, 20629, 20636).getWiring().getRequirements(null));
                                    CallChecker.varAssign(dynamics, "dynamics", 522, 20629, 20636);
                                }
                                Map<String, Object> attrs = CallChecker.varInit(Collections.singletonMap(BundleRevision.PACKAGE_NAMESPACE, ((Object) (pkgName))), "attrs", 527, 20921, 21058);
                                BundleRequirementImpl req = CallChecker.varInit(new BundleRequirementImpl(revision, BundleRevision.PACKAGE_NAMESPACE, Collections.EMPTY_MAP, attrs), "req", 529, 21084, 21340);
                                List<BundleCapability> candidates = CallChecker.varInit(findProvidersInternal(record, req, false, true), "candidates", 534, 21366, 21449);
                                BundleRequirementImpl dynReq = CallChecker.varInit(null, "dynReq", 537, 21568, 21603);
                                candidates = CallChecker.beforeCalled(candidates, List.class, 539, 21680, 21689);
                                dynamics = CallChecker.beforeCalled(dynamics, List.class, 539, 21736, 21743);
                                for (int dynIdx = 0; (((CallChecker.isCalled(candidates, List.class, 539, 21680, 21689).size()) > 0) && (dynReq == null)) && (dynIdx < (CallChecker.isCalled(dynamics, List.class, 539, 21736, 21743).size())); dynIdx++) {
                                    candidates = CallChecker.beforeCalled(candidates, List.class, 542, 21888, 21897);
                                    for (Iterator<BundleCapability> itCand = CallChecker.isCalled(candidates, List.class, 542, 21888, 21897).iterator(); (dynReq == null) && (CallChecker.isCalled(itCand, Iterator.class, 543, 21964, 21969).hasNext());) {
                                        Capability cap = CallChecker.init(Capability.class);
                                        if (CallChecker.beforeDeref(itCand, Iterator.class, 545, 22063, 22068)) {
                                            cap = CallChecker.isCalled(itCand, Iterator.class, 545, 22063, 22068).next();
                                            CallChecker.varAssign(cap, "cap", 545, 22063, 22068);
                                        }
                                        if (CallChecker.beforeDeref(dynamics, List.class, 548, 22247, 22254)) {
                                            dynamics = CallChecker.beforeCalled(dynamics, List.class, 548, 22247, 22254);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(dynamics, List.class, 548, 22247, 22254).get(dynIdx), BundleRequirement.class, 548, 22247, 22266)) {
                                                dynamics = CallChecker.beforeCalled(dynamics, List.class, 548, 22247, 22254);
                                                if (CapabilitySet.matches(cap, CallChecker.isCalled(((BundleRequirementImpl) (CallChecker.isCalled(dynamics, List.class, 548, 22247, 22254).get(dynIdx))), BundleRequirementImpl.class, 548, 22247, 22266).getFilter())) {
                                                    if (CallChecker.beforeDeref(dynamics, List.class, 550, 22386, 22393)) {
                                                        dynamics = CallChecker.beforeCalled(dynamics, List.class, 550, 22386, 22393);
                                                        dynReq = ((BundleRequirementImpl) (CallChecker.isCalled(dynamics, List.class, 550, 22386, 22393).get(dynIdx)));
                                                        CallChecker.varAssign(dynReq, "dynReq", 550, 22353, 22406);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (dynReq != null) {
                                    candidates = CallChecker.beforeCalled(candidates, List.class, 559, 22789, 22798);
                                    for (Iterator<BundleCapability> itCand = CallChecker.isCalled(candidates, List.class, 559, 22789, 22798).iterator(); CallChecker.isCalled(itCand, Iterator.class, 560, 22845, 22850).hasNext();) {
                                        Capability cap = CallChecker.init(Capability.class);
                                        if (CallChecker.beforeDeref(itCand, Iterator.class, 562, 22944, 22949)) {
                                            cap = CallChecker.isCalled(itCand, Iterator.class, 562, 22944, 22949).next();
                                            CallChecker.varAssign(cap, "cap", 562, 22944, 22949);
                                        }
                                        if (!(CapabilitySet.matches(cap, dynReq.getFilter()))) {
                                            if (CallChecker.beforeDeref(itCand, Iterator.class, 566, 23155, 23160)) {
                                                CallChecker.isCalled(itCand, Iterator.class, 566, 23155, 23160).remove();
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(candidates, List.class, 572, 23345, 23354)) {
                                        candidates = CallChecker.beforeCalled(candidates, List.class, 572, 23345, 23354);
                                        CallChecker.isCalled(candidates, List.class, 572, 23345, 23354).clear();
                                    }
                                }
                                if (CallChecker.beforeDeref(m_resolver, ResolverImpl.class, 575, 23426, 23435)) {
                                    wireMap = CallChecker.isCalled(m_resolver, ResolverImpl.class, 575, 23426, 23435).resolve(new ResolveContextImpl(this, getWirings(), record, Collections.<BundleRevision>emptyList(), Collections.<BundleRevision>emptyList(), getFragments()), revision, dynReq, new ArrayList<Capability>(candidates));
                                    CallChecker.varAssign(wireMap, "wireMap", 575, 23416, 23901);
                                }
                            } catch (ResolutionException ex) {
                                _bcornu_try_context_25.catchStart(25);
                                rethrow = ex;
                                CallChecker.varAssign(rethrow, "rethrow", 587, 24022, 24034);
                            } finally {
                                _bcornu_try_context_25.finallyStart(25);
                            }
                            releaseResolverHooks(record);
                            if (rethrow != null) {
                                throw rethrow;
                            }
                            if ((wireMap != null) && (wireMap.containsKey(revision))) {
                                List<Wire> dynamicWires = CallChecker.varInit(wireMap.remove(revision), "dynamicWires", 601, 24481, 24531);
                                Wire dynamicWire = CallChecker.init(Wire.class);
                                if (CallChecker.beforeDeref(dynamicWires, List.class, 602, 24576, 24587)) {
                                    dynamicWires = CallChecker.beforeCalled(dynamicWires, List.class, 602, 24576, 24587);
                                    dynamicWire = CallChecker.isCalled(dynamicWires, List.class, 602, 24576, 24587).get(0);
                                    CallChecker.varAssign(dynamicWire, "dynamicWire", 602, 24576, 24587);
                                }
                                markResolvedRevisions(wireMap);
                                if (dynamicWire != null) {
                                    if (((((dynamicWire.getRequirer()) instanceof BundleRevision) && ((dynamicWire.getRequirement()) instanceof BundleRequirement)) && ((dynamicWire.getProvider()) instanceof BundleRevision)) && ((dynamicWire.getCapability()) instanceof BundleCapability)) {
                                        BundleRevision dwRequirer = CallChecker.varInit(((BundleRevision) (dynamicWire.getRequirer())), "dwRequirer", 617, 25406, 25476);
                                        BundleRequirement dwRequirement = CallChecker.varInit(((BundleRequirement) (dynamicWire.getRequirement())), "dwRequirement", 618, 25510, 25592);
                                        BundleRevision dwProvider = CallChecker.varInit(((BundleRevision) (dynamicWire.getProvider())), "dwProvider", 619, 25626, 25696);
                                        BundleCapability dwCapability = CallChecker.varInit(((BundleCapability) (dynamicWire.getCapability())), "dwCapability", 620, 25730, 25808);
                                        BundleWire bw = CallChecker.varInit(new BundleWireImpl(dwRequirer, dwRequirement, dwProvider, dwCapability), "bw", 622, 25843, 26075);
                                        if (CallChecker.beforeDeref(m_felix, Felix.class, 628, 26110, 26116)) {
                                            final BundleRevisionDependencies npe_invocation_var107 = CallChecker.isCalled(m_felix, Felix.class, 628, 26110, 26116).getDependencies();
                                            if (CallChecker.beforeDeref(npe_invocation_var107, BundleRevisionDependencies.class, 628, 26110, 26134)) {
                                                CallChecker.isCalled(npe_invocation_var107, BundleRevisionDependencies.class, 628, 26110, 26134).addDependent(bw);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(revision, BundleRevision.class, 630, 26207, 26214)) {
                                            revision = CallChecker.beforeCalled(revision, BundleRevision.class, 630, 26207, 26214);
                                            final BundleWiringImpl npe_invocation_var108 = ((BundleWiringImpl) (CallChecker.isCalled(revision, BundleRevision.class, 630, 26207, 26214).getWiring()));
                                            if (CallChecker.beforeDeref(npe_invocation_var108, BundleWiringImpl.class, 630, 26207, 26226)) {
                                                CallChecker.isCalled(npe_invocation_var108, BundleWiringImpl.class, 630, 26207, 26226).addDynamicWire(bw);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(m_felix, Felix.class, 632, 26282, 26288)) {
                                            final Logger npe_invocation_var109 = CallChecker.isCalled(m_felix, Felix.class, 632, 26282, 26288).getLogger();
                                            if (CallChecker.beforeDeref(npe_invocation_var109, Logger.class, 632, 26282, 26300)) {
                                                CallChecker.isCalled(npe_invocation_var109, Logger.class, 632, 26282, 26300).log(Logger.LOG_DEBUG, ("DYNAMIC WIRE: " + dynamicWire));
                                            }
                                        }
                                        if (CallChecker.beforeDeref(revision, BundleRevision.class, 636, 26494, 26501)) {
                                            revision = CallChecker.beforeCalled(revision, BundleRevision.class, 636, 26494, 26501);
                                            final BundleWiringImpl npe_invocation_var110 = ((BundleWiringImpl) (CallChecker.isCalled(revision, BundleRevision.class, 636, 26494, 26501).getWiring()));
                                            if (CallChecker.beforeDeref(npe_invocation_var110, BundleWiringImpl.class, 636, 26494, 26513)) {
                                                provider = CallChecker.isCalled(npe_invocation_var110, BundleWiringImpl.class, 636, 26494, 26513).getImportedPackageSource(pkgName);
                                                CallChecker.varAssign(provider, "provider", 636, 26463, 26586);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } finally {
                        _bcornu_try_context_26.finallyStart(26);
                        m_isResolving = false;
                        CallChecker.varAssign(this.m_isResolving, "this.m_isResolving", 646, 26789, 26810);
                        if (CallChecker.beforeDeref(m_felix, Felix.class, 648, 26879, 26885)) {
                            CallChecker.isCalled(m_felix, Felix.class, 648, 26879, 26885).releaseGlobalLock();
                        }
                    }
                    fireResolvedEvents(wireMap);
                }
            }else
                throw new AbnormalExecutionError();
            
            return provider;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context161.methodEnd();
        }
    }

    private StatefulResolver.ResolverHookRecord prepareResolverHooks(Set<BundleRevision> mandatory, Set<BundleRevision> optional) throws BundleException, ResolutionException {
        MethodContext _bcornu_methode_context162 = new MethodContext(StatefulResolver.ResolverHookRecord.class);
        try {
            CallChecker.varInit(this, "this", 657, 27011, 33254);
            CallChecker.varInit(optional, "optional", 657, 27011, 33254);
            CallChecker.varInit(mandatory, "mandatory", 657, 27011, 33254);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 657, 27011, 33254);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 657, 27011, 33254);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 657, 27011, 33254);
            CallChecker.varInit(this.m_singletons, "m_singletons", 657, 27011, 33254);
            CallChecker.varInit(this.m_capSets, "m_capSets", 657, 27011, 33254);
            CallChecker.varInit(this.m_fragments, "m_fragments", 657, 27011, 33254);
            CallChecker.varInit(this.m_revisions, "m_revisions", 657, 27011, 33254);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 657, 27011, 33254);
            CallChecker.varInit(this.m_resolver, "m_resolver", 657, 27011, 33254);
            CallChecker.varInit(this.m_registry, "m_registry", 657, 27011, 33254);
            CallChecker.varInit(this.m_felix, "m_felix", 657, 27011, 33254);
            CallChecker.varInit(this.m_logger, "m_logger", 657, 27011, 33254);
            Map<ServiceReference<ResolverHookFactory>, ResolverHook> hookMap = CallChecker.varInit(new LinkedHashMap<ServiceReference<ResolverHookFactory>, ResolverHook>(), "hookMap", 666, 27546, 27697);
            Set<ServiceReference<ResolverHookFactory>> hookRefs = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 671, 27814, 27820)) {
                hookRefs = CallChecker.isCalled(m_felix, Felix.class, 671, 27814, 27820).getHooks(ResolverHookFactory.class);
                CallChecker.varAssign(hookRefs, "hookRefs", 671, 27814, 27820);
            }
            Collection<BundleRevision> whitelist = CallChecker.init(Collection.class);
            if (CallChecker.beforeDeref(hookRefs, Set.class, 674, 27919, 27926)) {
                hookRefs = CallChecker.beforeCalled(hookRefs, Set.class, 674, 27919, 27926);
                if (!(CallChecker.isCalled(hookRefs, Set.class, 674, 27919, 27926).isEmpty())) {
                    Set<BundleRevision> triggers = CallChecker.init(Set.class);
                    if (CallChecker.beforeDeref(mandatory, Set.class, 678, 28045, 28053)) {
                        if (CallChecker.beforeDeref(optional, Set.class, 678, 28069, 28076)) {
                            mandatory = CallChecker.beforeCalled(mandatory, Set.class, 678, 28045, 28053);
                            optional = CallChecker.beforeCalled(optional, Set.class, 678, 28069, 28076);
                            if ((!(CallChecker.isCalled(mandatory, Set.class, 678, 28045, 28053).isEmpty())) && (!(CallChecker.isCalled(optional, Set.class, 678, 28069, 28076).isEmpty()))) {
                                triggers = new HashSet<BundleRevision>(mandatory);
                                CallChecker.varAssign(triggers, "triggers", 680, 28119, 28168);
                                if (CallChecker.beforeDeref(triggers, Set.class, 681, 28186, 28193)) {
                                    triggers = CallChecker.beforeCalled(triggers, Set.class, 681, 28186, 28193);
                                    CallChecker.isCalled(triggers, Set.class, 681, 28186, 28193).addAll(optional);
                                }
                            }else {
                                if (CallChecker.beforeDeref(mandatory, Set.class, 685, 28286, 28294)) {
                                    mandatory = CallChecker.beforeCalled(mandatory, Set.class, 685, 28286, 28294);
                                    if (CallChecker.isCalled(mandatory, Set.class, 685, 28286, 28294).isEmpty()) {
                                        triggers = optional;
                                        CallChecker.varAssign(triggers, "triggers", 685, 28274, 28349);
                                    }else {
                                        triggers = mandatory;
                                        CallChecker.varAssign(triggers, "triggers", 685, 28274, 28349);
                                    }
                                }
                            }
                        }
                    }
                    triggers = Collections.unmodifiableSet(triggers);
                    CallChecker.varAssign(triggers, "triggers", 688, 28377, 28425);
                    BundleException rethrow = CallChecker.varInit(null, "rethrow", 690, 28440, 28470);
                    if (CallChecker.beforeDeref(hookRefs, StatefulResolver.ResolverHookRecord.class, 693, 28609, 28616)) {
                        for (ServiceReference<ResolverHookFactory> ref : hookRefs) {
                            TryContext _bcornu_try_context_27 = new TryContext(27, StatefulResolver.class, "java.lang.Throwable");
                            try {
                                ResolverHookFactory rhf = CallChecker.init(ResolverHookFactory.class);
                                if (CallChecker.beforeDeref(m_felix, Felix.class, 697, 28717, 28723)) {
                                    rhf = CallChecker.isCalled(m_felix, Felix.class, 697, 28717, 28723).getService(m_felix, ref, false);
                                    CallChecker.varAssign(rhf, "rhf", 697, 28717, 28723);
                                }
                                if (rhf != null) {
                                    ResolverHook hook = CallChecker.init(ResolverHook.class);
                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 701, 28889, 28908)) {
                                        hook = CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 701, 28889, 28908).invokeResolverHookFactory(rhf, triggers);
                                        CallChecker.varAssign(hook, "hook", 701, 28889, 28908);
                                    }
                                    if (hook != null) {
                                        if (CallChecker.beforeDeref(hookMap, Map.class, 705, 29081, 29087)) {
                                            hookMap = CallChecker.beforeCalled(hookMap, Map.class, 705, 29081, 29087);
                                            CallChecker.isCalled(hookMap, Map.class, 705, 29081, 29087).put(ref, hook);
                                        }
                                    }
                                }
                            } catch (Throwable ex) {
                                _bcornu_try_context_27.catchStart(27);
                                rethrow = new BundleException(("Resolver hook exception: " + (ex.getMessage())), BundleException.REJECTED_BY_HOOK, ex);
                                CallChecker.varAssign(rethrow, "rethrow", 711, 29246, 29433);
                                break;
                            } finally {
                                _bcornu_try_context_27.finallyStart(27);
                            }
                        }
                    }
                    if (rethrow != null) {
                        hookMap = CallChecker.beforeCalled(hookMap, Map.class, 723, 29785, 29791);
                        for (ResolverHook hook : CallChecker.isCalled(hookMap, Map.class, 723, 29785, 29791).values()) {
                            TryContext _bcornu_try_context_28 = new TryContext(28, StatefulResolver.class, "java.lang.Exception");
                            try {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 727, 29891, 29910)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 727, 29891, 29910).invokeResolverHookEnd(hook);
                                }
                            } catch (Exception ex) {
                                _bcornu_try_context_28.catchStart(28);
                                rethrow = new BundleException(("Resolver hook exception: " + (ex.getMessage())), BundleException.REJECTED_BY_HOOK, ex);
                                CallChecker.varAssign(rethrow, "rethrow", 731, 30050, 30261);
                            } finally {
                                _bcornu_try_context_28.finallyStart(28);
                            }
                        }
                        throw rethrow;
                    }
                    whitelist = new ShrinkableCollection<BundleRevision>(getUnresolvedRevisions());
                    CallChecker.varAssign(whitelist, "whitelist", 742, 30439, 30517);
                    int originalSize = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(whitelist, Collection.class, 743, 30550, 30558)) {
                        whitelist = CallChecker.beforeCalled(whitelist, Collection.class, 743, 30550, 30558);
                        originalSize = CallChecker.isCalled(whitelist, Collection.class, 743, 30550, 30558).size();
                        CallChecker.varAssign(originalSize, "originalSize", 743, 30550, 30558);
                    }
                    hookMap = CallChecker.beforeCalled(hookMap, Map.class, 744, 30605, 30611);
                    for (ResolverHook hook : CallChecker.isCalled(hookMap, Map.class, 744, 30605, 30611).values()) {
                        TryContext _bcornu_try_context_29 = new TryContext(29, StatefulResolver.class, "java.lang.Throwable");
                        try {
                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 748, 30695, 30714)) {
                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 748, 30695, 30714).invokeResolverHookResolvable(hook, whitelist);
                            }
                        } catch (Throwable ex) {
                            _bcornu_try_context_29.catchStart(29);
                            rethrow = new BundleException(("Resolver hook exception: " + (ex.getMessage())), BundleException.REJECTED_BY_HOOK, ex);
                            CallChecker.varAssign(rethrow, "rethrow", 753, 30881, 31068);
                            break;
                        } finally {
                            _bcornu_try_context_29.finallyStart(29);
                        }
                    }
                    if (rethrow != null) {
                        hookMap = CallChecker.beforeCalled(hookMap, Map.class, 765, 31426, 31432);
                        for (ResolverHook hook : CallChecker.isCalled(hookMap, Map.class, 765, 31426, 31432).values()) {
                            TryContext _bcornu_try_context_30 = new TryContext(30, StatefulResolver.class, "java.lang.Exception");
                            try {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 769, 31532, 31551)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 769, 31532, 31551).invokeResolverHookEnd(hook);
                                }
                            } catch (Exception ex) {
                                _bcornu_try_context_30.catchStart(30);
                                rethrow = new BundleException(("Resolver hook exception: " + (ex.getMessage())), BundleException.REJECTED_BY_HOOK, ex);
                                CallChecker.varAssign(rethrow, "rethrow", 773, 31691, 31902);
                            } finally {
                                _bcornu_try_context_30.finallyStart(30);
                            }
                        }
                        throw rethrow;
                    }
                    if (CallChecker.beforeDeref(whitelist, Collection.class, 785, 32110, 32118)) {
                        whitelist = CallChecker.beforeCalled(whitelist, Collection.class, 785, 32110, 32118);
                        if ((CallChecker.isCalled(whitelist, Collection.class, 785, 32110, 32118).size()) == originalSize) {
                            whitelist = null;
                            CallChecker.varAssign(whitelist, "whitelist", 787, 32174, 32190);
                        }
                    }
                    if (whitelist != null) {
                        if (CallChecker.beforeDeref(mandatory, Set.class, 796, 32584, 32592)) {
                            if (CallChecker.beforeDeref(optional, Set.class, 797, 32628, 32635)) {
                                if (CallChecker.beforeDeref(mandatory, Set.class, 798, 32671, 32679)) {
                                    mandatory = CallChecker.beforeCalled(mandatory, Set.class, 798, 32671, 32679);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(mandatory, Set.class, 798, 32671, 32679).iterator(), Iterator.class, 798, 32671, 32690)) {
                                        mandatory = CallChecker.beforeCalled(mandatory, Set.class, 798, 32671, 32679);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(mandatory, Set.class, 798, 32671, 32679).iterator(), Iterator.class, 798, 32671, 32690).next(), BundleRevision.class, 798, 32671, 32697)) {
                                            mandatory = CallChecker.beforeCalled(mandatory, Set.class, 796, 32584, 32592);
                                            optional = CallChecker.beforeCalled(optional, Set.class, 797, 32628, 32635);
                                            mandatory = CallChecker.beforeCalled(mandatory, Set.class, 798, 32671, 32679);
                                            if (((CallChecker.isCalled(mandatory, Set.class, 796, 32584, 32592).isEmpty()) || (!(CallChecker.isCalled(optional, Set.class, 797, 32628, 32635).isEmpty()))) || ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(mandatory, Set.class, 798, 32671, 32679).iterator(), Iterator.class, 798, 32671, 32690).next(), BundleRevision.class, 798, 32671, 32697).getWiring()) == null)) {
                                                if (CallChecker.beforeDeref(mandatory, Set.class, 800, 32759, 32767)) {
                                                    mandatory = CallChecker.beforeCalled(mandatory, Set.class, 800, 32759, 32767);
                                                    CallChecker.isCalled(mandatory, Set.class, 800, 32759, 32767).retainAll(whitelist);
                                                }
                                                if (CallChecker.beforeDeref(optional, Set.class, 801, 32811, 32818)) {
                                                    optional = CallChecker.beforeCalled(optional, Set.class, 801, 32811, 32818);
                                                    CallChecker.isCalled(optional, Set.class, 801, 32811, 32818).retainAll(whitelist);
                                                }
                                                if (CallChecker.beforeDeref(mandatory, Set.class, 802, 32866, 32874)) {
                                                    if (CallChecker.beforeDeref(optional, Set.class, 802, 32889, 32896)) {
                                                        mandatory = CallChecker.beforeCalled(mandatory, Set.class, 802, 32866, 32874);
                                                        optional = CallChecker.beforeCalled(optional, Set.class, 802, 32889, 32896);
                                                        if ((CallChecker.isCalled(mandatory, Set.class, 802, 32866, 32874).isEmpty()) && (CallChecker.isCalled(optional, Set.class, 802, 32889, 32896).isEmpty())) {
                                                            throw new ResolveException("Resolver hook prevented resolution.", null, null);
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else {
                    whitelist = null;
                    CallChecker.varAssign(whitelist, "whitelist", 812, 33162, 33178);
                }
            }else
                throw new AbnormalExecutionError();
            
            return new StatefulResolver.ResolverHookRecord(hookMap, whitelist);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StatefulResolver.ResolverHookRecord) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    private void releaseResolverHooks(StatefulResolver.ResolverHookRecord record) throws BundleException {
        MethodContext _bcornu_methode_context163 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 818, 33261, 34710);
            CallChecker.varInit(record, "record", 818, 33261, 34710);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 818, 33261, 34710);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 818, 33261, 34710);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 818, 33261, 34710);
            CallChecker.varInit(this.m_singletons, "m_singletons", 818, 33261, 34710);
            CallChecker.varInit(this.m_capSets, "m_capSets", 818, 33261, 34710);
            CallChecker.varInit(this.m_fragments, "m_fragments", 818, 33261, 34710);
            CallChecker.varInit(this.m_revisions, "m_revisions", 818, 33261, 34710);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 818, 33261, 34710);
            CallChecker.varInit(this.m_resolver, "m_resolver", 818, 33261, 34710);
            CallChecker.varInit(this.m_registry, "m_registry", 818, 33261, 34710);
            CallChecker.varInit(this.m_felix, "m_felix", 818, 33261, 34710);
            CallChecker.varInit(this.m_logger, "m_logger", 818, 33261, 34710);
            if (CallChecker.beforeDeref(record, StatefulResolver.ResolverHookRecord.class, 822, 33438, 33443)) {
                record = CallChecker.beforeCalled(record, StatefulResolver.ResolverHookRecord.class, 822, 33438, 33443);
                final Set<ServiceReference<ResolverHookFactory>> npe_invocation_var111 = CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 822, 33438, 33443).getResolverHookRefs();
                if (CallChecker.beforeDeref(npe_invocation_var111, Set.class, 822, 33438, 33465)) {
                    if (!(CallChecker.isCalled(npe_invocation_var111, Set.class, 822, 33438, 33465).isEmpty())) {
                        record = CallChecker.beforeCalled(record, StatefulResolver.ResolverHookRecord.class, 826, 33650, 33655);
                        for (ResolverHook hook : CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 826, 33650, 33655).getResolverHooks()) {
                            TryContext _bcornu_try_context_31 = new TryContext(31, StatefulResolver.class, "java.lang.Throwable");
                            try {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 830, 33749, 33768)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 830, 33749, 33768).invokeResolverHookEnd(hook);
                                }
                            } catch (Throwable th) {
                                _bcornu_try_context_31.catchStart(31);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 834, 33892, 33899)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 834, 33892, 33899).log(Logger.LOG_WARNING, "Resolver hook exception.", th);
                                }
                            } finally {
                                _bcornu_try_context_31.finallyStart(31);
                            }
                        }
                        boolean invalid = CallChecker.varInit(((boolean) (false)), "invalid", 840, 34152, 34175);
                        record = CallChecker.beforeCalled(record, StatefulResolver.ResolverHookRecord.class, 841, 34238, 34243);
                        for (ServiceReference<ResolverHookFactory> ref : CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 841, 34238, 34243).getResolverHookRefs()) {
                            if (CallChecker.beforeDeref(ref, ServiceReference.class, 843, 34302, 34304)) {
                                if ((CallChecker.isCalled(ref, ServiceReference.class, 843, 34302, 34304).getBundle()) == null) {
                                    invalid = true;
                                    CallChecker.varAssign(invalid, "invalid", 845, 34365, 34379);
                                }
                            }
                            if (CallChecker.beforeDeref(m_felix, Felix.class, 847, 34415, 34421)) {
                                CallChecker.isCalled(m_felix, Felix.class, 847, 34415, 34421).ungetService(m_felix, ref, null);
                            }
                        }
                        if (invalid) {
                            throw new BundleException("Resolver hook service unregistered during resolve.", BundleException.REJECTED_BY_HOOK);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context163.methodEnd();
        }
    }

    boolean isAllowedDynamicImport(BundleRevision revision, String pkgName) {
        MethodContext _bcornu_methode_context164 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 861, 34717, 38154);
            CallChecker.varInit(pkgName, "pkgName", 861, 34717, 38154);
            CallChecker.varInit(revision, "revision", 861, 34717, 38154);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 861, 34717, 38154);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 861, 34717, 38154);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 861, 34717, 38154);
            CallChecker.varInit(this.m_singletons, "m_singletons", 861, 34717, 38154);
            CallChecker.varInit(this.m_capSets, "m_capSets", 861, 34717, 38154);
            CallChecker.varInit(this.m_fragments, "m_fragments", 861, 34717, 38154);
            CallChecker.varInit(this.m_revisions, "m_revisions", 861, 34717, 38154);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 861, 34717, 38154);
            CallChecker.varInit(this.m_resolver, "m_resolver", 861, 34717, 38154);
            CallChecker.varInit(this.m_registry, "m_registry", 861, 34717, 38154);
            CallChecker.varInit(this.m_felix, "m_felix", 861, 34717, 38154);
            CallChecker.varInit(this.m_logger, "m_logger", 861, 34717, 38154);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 865, 35106, 35113)) {
                if (CallChecker.beforeDeref(pkgName, String.class, 865, 35139, 35145)) {
                    revision = CallChecker.beforeCalled(revision, BundleRevision.class, 865, 35106, 35113);
                    pkgName = CallChecker.beforeCalled(pkgName, String.class, 865, 35139, 35145);
                    if (((CallChecker.isCalled(revision, BundleRevision.class, 865, 35106, 35113).getWiring()) == null) || ((CallChecker.isCalled(pkgName, String.class, 865, 35139, 35145).length()) == 0)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            List<BundleRequirement> dynamics = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 873, 35390, 35397)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 873, 35390, 35397);
                dynamics = Util.getDynamicRequirements(CallChecker.isCalled(revision, BundleRevision.class, 873, 35390, 35397).getWiring().getRequirements(null));
                CallChecker.varAssign(dynamics, "dynamics", 873, 35390, 35397);
            }
            if ((dynamics == null) || (dynamics.isEmpty())) {
                return false;
            }
            revision = CallChecker.beforeCalled(revision, BundleRevision.class, 881, 35681, 35688);
            for (BundleCapability cap : CallChecker.isCalled(revision, BundleRevision.class, 881, 35681, 35688).getWiring().getCapabilities(null)) {
                if (CallChecker.beforeDeref(cap, BundleCapability.class, 883, 35751, 35753)) {
                    final String npe_invocation_var112 = CallChecker.isCalled(cap, BundleCapability.class, 883, 35751, 35753).getNamespace();
                    if (CallChecker.beforeDeref(npe_invocation_var112, String.class, 883, 35751, 35768)) {
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 884, 35830, 35832)) {
                            final Map<String, Object> npe_invocation_var113 = CallChecker.isCalled(cap, BundleCapability.class, 884, 35830, 35832).getAttributes();
                            if (CallChecker.beforeDeref(npe_invocation_var113, Map.class, 884, 35830, 35848)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var113, Map.class, 884, 35830, 35848).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 884, 35830, 35886)) {
                                    if ((CallChecker.isCalled(npe_invocation_var112, String.class, 883, 35751, 35768).equals(BundleRevision.PACKAGE_NAMESPACE)) && (CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var113, Map.class, 884, 35830, 35848).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 884, 35830, 35886).equals(pkgName))) {
                                        return false;
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
                
            }
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 892, 36125, 36132)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 892, 36125, 36132);
                final BundleWiringImpl npe_invocation_var114 = ((BundleWiringImpl) (CallChecker.isCalled(revision, BundleRevision.class, 892, 36125, 36132).getWiring()));
                if (CallChecker.beforeDeref(npe_invocation_var114, BundleWiringImpl.class, 892, 36125, 36144)) {
                    if (CallChecker.isCalled(npe_invocation_var114, BundleWiringImpl.class, 892, 36125, 36144).hasPackageSource(pkgName)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Map<String, Object> attrs = CallChecker.varInit(Collections.singletonMap(BundleRevision.PACKAGE_NAMESPACE, ((Object) (pkgName))), "attrs", 900, 36403, 36520);
            BundleRequirementImpl req = CallChecker.varInit(new BundleRequirementImpl(revision, BundleRevision.PACKAGE_NAMESPACE, Collections.EMPTY_MAP, attrs), "req", 902, 36530, 36706);
            List<BundleCapability> candidates = CallChecker.varInit(findProviders(req, false), "candidates", 907, 36716, 36777);
            BundleRequirementImpl dynReq = CallChecker.varInit(null, "dynReq", 910, 36864, 36899);
            candidates = CallChecker.beforeCalled(candidates, List.class, 912, 36943, 36952);
            for (int dynIdx = 0; (((CallChecker.isCalled(candidates, List.class, 912, 36943, 36952).size()) > 0) && (dynReq == null)) && (dynIdx < (dynamics.size())); dynIdx++) {
                candidates = CallChecker.beforeCalled(candidates, List.class, 915, 37102, 37111);
                for (Iterator<BundleCapability> itCand = CallChecker.isCalled(candidates, List.class, 915, 37102, 37111).iterator(); (dynReq == null) && (CallChecker.isCalled(itCand, Iterator.class, 916, 37161, 37166).hasNext());) {
                    Capability cap = CallChecker.init(Capability.class);
                    if (CallChecker.beforeDeref(itCand, Iterator.class, 918, 37228, 37233)) {
                        cap = CallChecker.isCalled(itCand, Iterator.class, 918, 37228, 37233).next();
                        CallChecker.varAssign(cap, "cap", 918, 37228, 37233);
                    }
                    dynamics = CallChecker.beforeCalled(dynamics, List.class, 921, 37356, 37363);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(dynamics, List.class, 921, 37356, 37363).get(dynIdx), BundleRequirement.class, 921, 37356, 37375)) {
                        if (CapabilitySet.matches(cap, CallChecker.isCalled(((BundleRequirementImpl) (dynamics.get(dynIdx))), BundleRequirementImpl.class, 921, 37356, 37375).getFilter())) {
                            dynReq = ((BundleRequirementImpl) (dynamics.get(dynIdx)));
                            CallChecker.varAssign(dynReq, "dynReq", 923, 37430, 37483);
                        }
                    }
                }
            }
            if (dynReq != null) {
                candidates = CallChecker.beforeCalled(candidates, List.class, 932, 37738, 37747);
                for (Iterator<BundleCapability> itCand = CallChecker.isCalled(candidates, List.class, 932, 37738, 37747).iterator(); CallChecker.isCalled(itCand, Iterator.class, 933, 37777, 37782).hasNext();) {
                    Capability cap = CallChecker.init(Capability.class);
                    if (CallChecker.beforeDeref(itCand, Iterator.class, 935, 37844, 37849)) {
                        cap = CallChecker.isCalled(itCand, Iterator.class, 935, 37844, 37849).next();
                        CallChecker.varAssign(cap, "cap", 935, 37844, 37849);
                    }
                    if (!(CapabilitySet.matches(cap, dynReq.getFilter()))) {
                        if (CallChecker.beforeDeref(itCand, Iterator.class, 939, 37987, 37992)) {
                            CallChecker.isCalled(itCand, Iterator.class, 939, 37987, 37992).remove();
                        }
                    }
                }
            }else {
                if (CallChecker.beforeDeref(candidates, List.class, 945, 38081, 38090)) {
                    candidates = CallChecker.beforeCalled(candidates, List.class, 945, 38081, 38090);
                    CallChecker.isCalled(candidates, List.class, 945, 38081, 38090).clear();
                }
            }
            if (CallChecker.beforeDeref(candidates, List.class, 948, 38128, 38137)) {
                candidates = CallChecker.beforeCalled(candidates, List.class, 948, 38128, 38137);
                return !(CallChecker.isCalled(candidates, List.class, 948, 38128, 38137).isEmpty());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }

    private void markResolvedRevisions(Map<Resource, List<Wire>> wireMap) throws ResolveException {
        MethodContext _bcornu_methode_context165 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 951, 38161, 48263);
            CallChecker.varInit(wireMap, "wireMap", 951, 38161, 48263);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 951, 38161, 48263);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 951, 38161, 48263);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 951, 38161, 48263);
            CallChecker.varInit(this.m_singletons, "m_singletons", 951, 38161, 48263);
            CallChecker.varInit(this.m_capSets, "m_capSets", 951, 38161, 48263);
            CallChecker.varInit(this.m_fragments, "m_fragments", 951, 38161, 48263);
            CallChecker.varInit(this.m_revisions, "m_revisions", 951, 38161, 48263);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 951, 38161, 48263);
            CallChecker.varInit(this.m_resolver, "m_resolver", 951, 38161, 48263);
            CallChecker.varInit(this.m_registry, "m_registry", 951, 38161, 48263);
            CallChecker.varInit(this.m_felix, "m_felix", 951, 38161, 48263);
            CallChecker.varInit(this.m_logger, "m_logger", 951, 38161, 48263);
            boolean debugLog = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 954, 38296, 38302)) {
                final Logger npe_invocation_var115 = CallChecker.isCalled(m_felix, Felix.class, 954, 38296, 38302).getLogger();
                if (CallChecker.beforeDeref(npe_invocation_var115, Logger.class, 954, 38296, 38314)) {
                    debugLog = (CallChecker.isCalled(npe_invocation_var115, Logger.class, 954, 38296, 38314).getLogLevel()) >= (Logger.LOG_DEBUG);
                    CallChecker.varAssign(debugLog, "debugLog", 954, 38296, 38302);
                }
            }
            if (wireMap != null) {
                Map<Resource, List<BundleRevision>> hosts = CallChecker.varInit(new HashMap<Resource, List<BundleRevision>>(), "hosts", 967, 38816, 38921);
                for (Map.Entry<Resource, List<Wire>> entry : wireMap.entrySet()) {
                    Resource revision = CallChecker.init(Resource.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 971, 39046, 39050)) {
                        revision = CallChecker.isCalled(entry, Map.Entry.class, 971, 39046, 39050).getKey();
                        CallChecker.varAssign(revision, "revision", 971, 39046, 39050);
                    }
                    List<Wire> wires = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 972, 39097, 39101)) {
                        wires = CallChecker.isCalled(entry, Map.Entry.class, 972, 39097, 39101).getValue();
                        CallChecker.varAssign(wires, "wires", 972, 39097, 39101);
                    }
                    if (Util.isFragment(revision)) {
                        wires = CallChecker.beforeCalled(wires, List.class, 976, 39231, 39235);
                        for (Iterator<Wire> itWires = CallChecker.isCalled(wires, List.class, 976, 39231, 39235).iterator(); CallChecker.isCalled(itWires, Iterator.class, 977, 39273, 39279).hasNext();) {
                            Wire w = CallChecker.init(Wire.class);
                            if (CallChecker.beforeDeref(itWires, Iterator.class, 979, 39349, 39355)) {
                                w = CallChecker.isCalled(itWires, Iterator.class, 979, 39349, 39355).next();
                                CallChecker.varAssign(w, "w", 979, 39349, 39355);
                            }
                            List<BundleRevision> fragments = CallChecker.init(List.class);
                            if (CallChecker.beforeDeref(w, Wire.class, 980, 39432, 39432)) {
                                if (CallChecker.beforeDeref(hosts, Map.class, 980, 39422, 39426)) {
                                    w = CallChecker.beforeCalled(w, Wire.class, 980, 39432, 39432);
                                    hosts = CallChecker.beforeCalled(hosts, Map.class, 980, 39422, 39426);
                                    fragments = CallChecker.isCalled(hosts, Map.class, 980, 39422, 39426).get(CallChecker.isCalled(w, Wire.class, 980, 39432, 39432).getProvider());
                                    CallChecker.varAssign(fragments, "fragments", 980, 39432, 39432);
                                }
                            }
                            if (fragments == null) {
                                fragments = new ArrayList<BundleRevision>();
                                CallChecker.varAssign(fragments, "fragments", 983, 39551, 39594);
                                if (CallChecker.beforeDeref(w, Wire.class, 984, 39634, 39634)) {
                                    if (CallChecker.beforeDeref(hosts, Map.class, 984, 39624, 39628)) {
                                        w = CallChecker.beforeCalled(w, Wire.class, 984, 39634, 39634);
                                        hosts = CallChecker.beforeCalled(hosts, Map.class, 984, 39624, 39628);
                                        CallChecker.isCalled(hosts, Map.class, 984, 39624, 39628).put(CallChecker.isCalled(w, Wire.class, 984, 39634, 39634).getProvider(), fragments);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(w, Wire.class, 987, 39718, 39718)) {
                                w = CallChecker.beforeCalled(w, Wire.class, 987, 39718, 39718);
                                if ((CallChecker.isCalled(w, Wire.class, 987, 39718, 39718).getRequirer()) instanceof BundleRevision)
                                    if (CallChecker.beforeDeref(w, Wire.class, 988, 39820, 39820)) {
                                        if (CallChecker.beforeDeref(fragments, List.class, 988, 39789, 39797)) {
                                            w = CallChecker.beforeCalled(w, Wire.class, 988, 39820, 39820);
                                            fragments = CallChecker.beforeCalled(fragments, List.class, 988, 39789, 39797);
                                            CallChecker.isCalled(fragments, List.class, 988, 39789, 39797).add(((BundleRevision) (CallChecker.isCalled(w, Wire.class, 988, 39820, 39820).getRequirer())));
                                        }
                                    }
                                
                            }
                        }
                    }
                }
                Map<BundleRevision, BundleWiringImpl> wirings = CallChecker.varInit(new HashMap<BundleRevision, BundleWiringImpl>(wireMap.size()), "wirings", 1000, 40374, 40499);
                for (Map.Entry<Resource, List<Wire>> entry : wireMap.entrySet()) {
                    Resource resource = CallChecker.init(Resource.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1004, 40624, 40628)) {
                        resource = CallChecker.isCalled(entry, Map.Entry.class, 1004, 40624, 40628).getKey();
                        CallChecker.varAssign(resource, "resource", 1004, 40624, 40628);
                    }
                    if (!(resource instanceof BundleRevision))
                        continue;
                    
                    BundleRevision revision = CallChecker.varInit(((BundleRevision) (resource)), "revision", 1008, 40746, 40797);
                    List<Wire> resolverWires = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1009, 40842, 40846)) {
                        resolverWires = CallChecker.isCalled(entry, Map.Entry.class, 1009, 40842, 40846).getValue();
                        CallChecker.varAssign(resolverWires, "resolverWires", 1009, 40842, 40846);
                    }
                    List<BundleWire> bundleWires = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(resolverWires, List.class, 1012, 40954, 40966)) {
                        resolverWires = CallChecker.beforeCalled(resolverWires, List.class, 1012, 40954, 40966);
                        bundleWires = new ArrayList<BundleWire>(CallChecker.isCalled(resolverWires, List.class, 1012, 40954, 40966).size());
                        CallChecker.varAssign(bundleWires, "bundleWires", 1012, 40954, 40966);
                    }
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 1018, 41267, 41274)) {
                        revision = CallChecker.beforeCalled(revision, BundleRevision.class, 1018, 41267, 41274);
                        if (((CallChecker.isCalled(revision, BundleRevision.class, 1018, 41267, 41274).getWiring()) != null) && (Util.isFragment(revision))) {
                            if (CallChecker.beforeDeref(revision, BundleRevision.class, 1021, 41461, 41468)) {
                                if (CallChecker.beforeDeref(bundleWires, List.class, 1021, 41442, 41452)) {
                                    revision = CallChecker.beforeCalled(revision, BundleRevision.class, 1021, 41461, 41468);
                                    bundleWires = CallChecker.beforeCalled(bundleWires, List.class, 1021, 41442, 41452);
                                    CallChecker.isCalled(bundleWires, List.class, 1021, 41442, 41452).addAll(CallChecker.isCalled(revision, BundleRevision.class, 1021, 41461, 41468).getWiring().getRequiredWires(null));
                                }
                            }
                        }
                    }
                    Map<String, BundleRevision> importedPkgs = CallChecker.varInit(new HashMap<String, BundleRevision>(), "importedPkgs", 1027, 41718, 41818);
                    Map<String, List<BundleRevision>> requiredPkgs = CallChecker.varInit(new HashMap<String, List<BundleRevision>>(), "requiredPkgs", 1029, 41836, 41948);
                    if (CallChecker.beforeDeref(resolverWires, void.class, 1031, 41981, 41993)) {
                        for (Wire rw : resolverWires) {
                            if (CallChecker.beforeDeref(rw, Wire.class, 1035, 42148, 42149)) {
                                if (!((CallChecker.isCalled(rw, Wire.class, 1035, 42148, 42149).getRequirer()) instanceof BundleRevision))
                                    continue;
                                
                            }
                            BundleRevision requirer = CallChecker.init(BundleRevision.class);
                            if (CallChecker.beforeDeref(rw, Wire.class, 1037, 42290, 42291)) {
                                requirer = ((BundleRevision) (CallChecker.isCalled(rw, Wire.class, 1037, 42290, 42291).getRequirer()));
                                CallChecker.varAssign(requirer, "requirer", 1037, 42290, 42291);
                            }
                            if (CallChecker.beforeDeref(rw, Wire.class, 1038, 42334, 42335)) {
                                if (!((CallChecker.isCalled(rw, Wire.class, 1038, 42334, 42335).getRequirement()) instanceof BundleRequirement))
                                    continue;
                                
                            }
                            BundleRequirement requirement = CallChecker.init(BundleRequirement.class);
                            if (CallChecker.beforeDeref(rw, Wire.class, 1040, 42491, 42492)) {
                                requirement = ((BundleRequirement) (CallChecker.isCalled(rw, Wire.class, 1040, 42491, 42492).getRequirement()));
                                CallChecker.varAssign(requirement, "requirement", 1040, 42491, 42492);
                            }
                            if (CallChecker.beforeDeref(rw, Wire.class, 1041, 42538, 42539)) {
                                if (!((CallChecker.isCalled(rw, Wire.class, 1041, 42538, 42539).getProvider()) instanceof BundleRevision))
                                    continue;
                                
                            }
                            BundleRevision provider = CallChecker.init(BundleRevision.class);
                            if (CallChecker.beforeDeref(rw, Wire.class, 1043, 42680, 42681)) {
                                provider = ((BundleRevision) (CallChecker.isCalled(rw, Wire.class, 1043, 42680, 42681).getProvider()));
                                CallChecker.varAssign(provider, "provider", 1043, 42680, 42681);
                            }
                            if (CallChecker.beforeDeref(rw, Wire.class, 1044, 42724, 42725)) {
                                if (!((CallChecker.isCalled(rw, Wire.class, 1044, 42724, 42725).getCapability()) instanceof BundleCapability))
                                    continue;
                                
                            }
                            BundleCapability capability = CallChecker.init(BundleCapability.class);
                            if (CallChecker.beforeDeref(rw, Wire.class, 1046, 42876, 42877)) {
                                capability = ((BundleCapability) (CallChecker.isCalled(rw, Wire.class, 1046, 42876, 42877).getCapability()));
                                CallChecker.varAssign(capability, "capability", 1046, 42876, 42877);
                            }
                            BundleWire bw = CallChecker.varInit(new BundleWireImpl(requirer, requirement, provider, capability), "bw", 1048, 42917, 43093);
                            if (CallChecker.beforeDeref(bundleWires, List.class, 1053, 43115, 43125)) {
                                bundleWires = CallChecker.beforeCalled(bundleWires, List.class, 1053, 43115, 43125);
                                CallChecker.isCalled(bundleWires, List.class, 1053, 43115, 43125).add(bw);
                            }
                            if (Util.isFragment(revision)) {
                                if (debugLog) {
                                    if (CallChecker.beforeDeref(m_felix, Felix.class, 1059, 43302, 43308)) {
                                        if (CallChecker.beforeDeref(rw, Wire.class, 1061, 43429, 43430)) {
                                            final Logger npe_invocation_var116 = CallChecker.isCalled(m_felix, Felix.class, 1059, 43302, 43308).getLogger();
                                            if (CallChecker.beforeDeref(npe_invocation_var116, Logger.class, 1059, 43302, 43320)) {
                                                CallChecker.isCalled(npe_invocation_var116, Logger.class, 1059, 43302, 43320).log(Logger.LOG_DEBUG, ("FRAGMENT WIRE: " + (CallChecker.isCalled(rw, Wire.class, 1061, 43429, 43430).toString())));
                                            }
                                        }
                                    }
                                }
                            }else {
                                if (debugLog) {
                                    if (CallChecker.beforeDeref(m_felix, Felix.class, 1068, 43632, 43638)) {
                                        if (CallChecker.beforeDeref(rw, Wire.class, 1068, 43685, 43686)) {
                                            final Logger npe_invocation_var117 = CallChecker.isCalled(m_felix, Felix.class, 1068, 43632, 43638).getLogger();
                                            if (CallChecker.beforeDeref(npe_invocation_var117, Logger.class, 1068, 43632, 43650)) {
                                                CallChecker.isCalled(npe_invocation_var117, Logger.class, 1068, 43632, 43650).log(Logger.LOG_DEBUG, ("WIRE: " + (CallChecker.isCalled(rw, Wire.class, 1068, 43685, 43686).toString())));
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(capability, BundleCapability.class, 1071, 43756, 43765)) {
                                    capability = CallChecker.beforeCalled(capability, BundleCapability.class, 1071, 43756, 43765);
                                    final String npe_invocation_var118 = CallChecker.isCalled(capability, BundleCapability.class, 1071, 43756, 43765).getNamespace();
                                    if (CallChecker.beforeDeref(npe_invocation_var118, String.class, 1071, 43756, 43780)) {
                                        if (CallChecker.isCalled(npe_invocation_var118, String.class, 1071, 43756, 43780).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                            if (CallChecker.beforeDeref(capability, BundleCapability.class, 1075, 43966, 43975)) {
                                                capability = CallChecker.beforeCalled(capability, BundleCapability.class, 1075, 43966, 43975);
                                                final Map<String, Object> npe_invocation_var119 = CallChecker.isCalled(capability, BundleCapability.class, 1075, 43966, 43975).getAttributes();
                                                if (CallChecker.beforeDeref(npe_invocation_var119, Map.class, 1075, 43966, 43991)) {
                                                    if (CallChecker.beforeDeref(importedPkgs, Map.class, 1074, 43907, 43918)) {
                                                        importedPkgs = CallChecker.beforeCalled(importedPkgs, Map.class, 1074, 43907, 43918);
                                                        CallChecker.isCalled(importedPkgs, Map.class, 1074, 43907, 43918).put(((String) (CallChecker.isCalled(npe_invocation_var119, Map.class, 1075, 43966, 43991).get(BundleRevision.PACKAGE_NAMESPACE))), provider);
                                                    }
                                                }
                                            }
                                        }else
                                            if (CallChecker.beforeDeref(capability, BundleCapability.class, 1079, 44171, 44180)) {
                                                capability = CallChecker.beforeCalled(capability, BundleCapability.class, 1079, 44171, 44180);
                                                final String npe_invocation_var120 = CallChecker.isCalled(capability, BundleCapability.class, 1079, 44171, 44180).getNamespace();
                                                if (CallChecker.beforeDeref(npe_invocation_var120, String.class, 1079, 44171, 44195)) {
                                                    if (CallChecker.isCalled(npe_invocation_var120, String.class, 1079, 44171, 44195).equals(BundleRevision.BUNDLE_NAMESPACE)) {
                                                        Set<String> pkgs = CallChecker.varInit(StatefulResolver.calculateExportedAndReexportedPackages(provider, wireMap, new HashSet<String>(), new HashSet<BundleRevision>()), "pkgs", 1082, 44321, 44596);
                                                        if (CallChecker.beforeDeref(pkgs, void.class, 1087, 44644, 44647)) {
                                                            for (String pkg : pkgs) {
                                                                List<BundleRevision> revs = CallChecker.init(List.class);
                                                                if (CallChecker.beforeDeref(requiredPkgs, Map.class, 1089, 44740, 44751)) {
                                                                    requiredPkgs = CallChecker.beforeCalled(requiredPkgs, Map.class, 1089, 44740, 44751);
                                                                    revs = CallChecker.isCalled(requiredPkgs, Map.class, 1089, 44740, 44751).get(pkg);
                                                                    CallChecker.varAssign(revs, "revs", 1089, 44740, 44751);
                                                                }
                                                                if (revs == null) {
                                                                    revs = new ArrayList<BundleRevision>();
                                                                    CallChecker.varAssign(revs, "revs", 1092, 44883, 44921);
                                                                    if (CallChecker.beforeDeref(requiredPkgs, Map.class, 1093, 44959, 44970)) {
                                                                        requiredPkgs = CallChecker.beforeCalled(requiredPkgs, Map.class, 1093, 44959, 44970);
                                                                        CallChecker.isCalled(requiredPkgs, Map.class, 1093, 44959, 44970).put(pkg, revs);
                                                                    }
                                                                }
                                                                if (CallChecker.beforeDeref(revs, List.class, 1095, 45054, 45057)) {
                                                                    revs = CallChecker.beforeCalled(revs, List.class, 1095, 45054, 45057);
                                                                    CallChecker.isCalled(revs, List.class, 1095, 45054, 45057).add(provider);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        
                                    }
                                }
                            }
                        }
                    }
                    List<BundleRevision> fragments = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(hosts, Map.class, 1101, 45220, 45224)) {
                        hosts = CallChecker.beforeCalled(hosts, Map.class, 1101, 45220, 45224);
                        fragments = CallChecker.isCalled(hosts, Map.class, 1101, 45220, 45224).get(revision);
                        CallChecker.varAssign(fragments, "fragments", 1101, 45220, 45224);
                    }
                    TryContext _bcornu_try_context_33 = new TryContext(33, StatefulResolver.class, "java.lang.Exception");
                    try {
                        if (CallChecker.beforeDeref(m_felix, Felix.class, 1107, 45420, 45426)) {
                            if (CallChecker.beforeDeref(m_felix, Felix.class, 1108, 45469, 45475)) {
                                if (CallChecker.beforeDeref(wirings, Map.class, 1104, 45299, 45305)) {
                                    wirings = CallChecker.beforeCalled(wirings, Map.class, 1104, 45299, 45305);
                                    CallChecker.isCalled(wirings, Map.class, 1104, 45299, 45305).put(revision, new BundleWiringImpl(CallChecker.isCalled(m_felix, Felix.class, 1107, 45420, 45426).getLogger(), CallChecker.isCalled(m_felix, Felix.class, 1108, 45469, 45475).getConfig(), this, ((BundleRevisionImpl) (revision)), fragments, bundleWires, importedPkgs, requiredPkgs));
                                }
                            }
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_33.catchStart(33);
                        wirings = CallChecker.beforeCalled(wirings, Map.class, 1121, 46037, 46043);
                        for (Map.Entry<BundleRevision, BundleWiringImpl> wiringEntry : CallChecker.isCalled(wirings, Map.class, 1121, 46037, 46043).entrySet()) {
                            TryContext _bcornu_try_context_32 = new TryContext(32, StatefulResolver.class, "java.lang.Exception");
                            try {
                                if (CallChecker.beforeDeref(wiringEntry, Map.Entry.class, 1126, 46207, 46217)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(wiringEntry, Map.Entry.class, 1126, 46207, 46217).getValue(), BundleWiringImpl.class, 1126, 46207, 46228)) {
                                        CallChecker.isCalled(CallChecker.isCalled(wiringEntry, Map.Entry.class, 1126, 46207, 46217).getValue(), BundleWiringImpl.class, 1126, 46207, 46228).dispose();
                                    }
                                }
                            } catch (Exception ex2) {
                                _bcornu_try_context_32.catchStart(32);
                                RuntimeException rte = CallChecker.varInit(new RuntimeException("Unable to clean up resolver failure.", ex2), "rte", 1131, 46421, 46542);
                                if (CallChecker.beforeDeref(m_felix, Felix.class, 1133, 46572, 46578)) {
                                    if (CallChecker.beforeDeref(rte, RuntimeException.class, 1135, 46679, 46681)) {
                                        final Logger npe_invocation_var121 = CallChecker.isCalled(m_felix, Felix.class, 1133, 46572, 46578).getLogger();
                                        if (CallChecker.beforeDeref(npe_invocation_var121, Logger.class, 1133, 46572, 46590)) {
                                            rte = CallChecker.beforeCalled(rte, RuntimeException.class, 1135, 46679, 46681);
                                            CallChecker.isCalled(npe_invocation_var121, Logger.class, 1133, 46572, 46590).log(Logger.LOG_ERROR, CallChecker.isCalled(rte, RuntimeException.class, 1135, 46679, 46681).getMessage(), ex2);
                                        }
                                    }
                                }
                                throw rte;
                            } finally {
                                _bcornu_try_context_32.finallyStart(32);
                            }
                        }
                        ResolveException re = CallChecker.varInit(new ResolveException(("Unable to resolve " + revision), revision, null), "re", 1140, 46811, 46951);
                        if (CallChecker.beforeDeref(re, ResolveException.class, 1143, 46973, 46974)) {
                            re = CallChecker.beforeCalled(re, ResolveException.class, 1143, 46973, 46974);
                            CallChecker.isCalled(re, ResolveException.class, 1143, 46973, 46974).initCause(ex);
                        }
                        if (CallChecker.beforeDeref(m_felix, Felix.class, 1144, 47011, 47017)) {
                            if (CallChecker.beforeDeref(re, ResolveException.class, 1146, 47102, 47103)) {
                                final Logger npe_invocation_var122 = CallChecker.isCalled(m_felix, Felix.class, 1144, 47011, 47017).getLogger();
                                if (CallChecker.beforeDeref(npe_invocation_var122, Logger.class, 1144, 47011, 47029)) {
                                    re = CallChecker.beforeCalled(re, ResolveException.class, 1146, 47102, 47103);
                                    CallChecker.isCalled(npe_invocation_var122, Logger.class, 1144, 47011, 47029).log(Logger.LOG_ERROR, CallChecker.isCalled(re, ResolveException.class, 1146, 47102, 47103).getMessage(), ex);
                                }
                            }
                        }
                        throw re;
                    } finally {
                        _bcornu_try_context_33.finallyStart(33);
                    }
                }
                wirings = CallChecker.beforeCalled(wirings, Map.class, 1153, 47380, 47386);
                for (Map.Entry<BundleRevision, BundleWiringImpl> entry : CallChecker.isCalled(wirings, Map.class, 1153, 47380, 47386).entrySet()) {
                    BundleRevisionImpl revision = CallChecker.init(BundleRevisionImpl.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1155, 47481, 47485)) {
                        revision = ((BundleRevisionImpl) (CallChecker.isCalled(entry, Map.Entry.class, 1155, 47481, 47485).getKey()));
                        CallChecker.varAssign(revision, "revision", 1155, 47481, 47485);
                    }
                    BundleWiring wiring = CallChecker.init(BundleWiring.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1158, 47582, 47586)) {
                        wiring = CallChecker.isCalled(entry, Map.Entry.class, 1158, 47582, 47586).getValue();
                        CallChecker.varAssign(wiring, "wiring", 1158, 47582, 47586);
                    }
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1159, 47633, 47637)) {
                        if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 1159, 47616, 47623)) {
                            revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 1159, 47616, 47623);
                            CallChecker.isCalled(revision, BundleRevisionImpl.class, 1159, 47616, 47623).resolve(CallChecker.isCalled(entry, Map.Entry.class, 1159, 47633, 47637).getValue());
                        }
                    }
                    wiring = CallChecker.beforeCalled(wiring, BundleWiring.class, 1162, 47730, 47735);
                    for (BundleWire bw : CallChecker.isCalled(wiring, BundleWiring.class, 1162, 47730, 47735).getRequiredWires(null)) {
                        if (CallChecker.beforeDeref(m_felix, Felix.class, 1164, 47799, 47805)) {
                            final BundleRevisionDependencies npe_invocation_var123 = CallChecker.isCalled(m_felix, Felix.class, 1164, 47799, 47805).getDependencies();
                            if (CallChecker.beforeDeref(npe_invocation_var123, BundleRevisionDependencies.class, 1164, 47799, 47823)) {
                                CallChecker.isCalled(npe_invocation_var123, BundleRevisionDependencies.class, 1164, 47799, 47823).addDependent(bw);
                            }
                        }
                    }
                    addRevision(revision);
                    markBundleResolved(revision);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context165.methodEnd();
        }
    }

    private void markBundleResolved(BundleRevision revision) {
        MethodContext _bcornu_methode_context166 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1178, 48270, 49675);
            CallChecker.varInit(revision, "revision", 1178, 48270, 49675);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1178, 48270, 49675);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1178, 48270, 49675);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1178, 48270, 49675);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1178, 48270, 49675);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1178, 48270, 49675);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1178, 48270, 49675);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1178, 48270, 49675);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1178, 48270, 49675);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1178, 48270, 49675);
            CallChecker.varInit(this.m_registry, "m_registry", 1178, 48270, 49675);
            CallChecker.varInit(this.m_felix, "m_felix", 1178, 48270, 49675);
            CallChecker.varInit(this.m_logger, "m_logger", 1178, 48270, 49675);
            BundleImpl bundle = CallChecker.init(BundleImpl.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 1185, 48659, 48666)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 1185, 48659, 48666);
                bundle = ((BundleImpl) (CallChecker.isCalled(revision, BundleRevision.class, 1185, 48659, 48666).getBundle()));
                CallChecker.varAssign(bundle, "bundle", 1185, 48659, 48666);
            }
            TryContext _bcornu_try_context_35 = new TryContext(35, StatefulResolver.class);
            try {
                TryContext _bcornu_try_context_34 = new TryContext(34, StatefulResolver.class, "java.lang.IllegalStateException");
                try {
                    if (CallChecker.beforeDeref(m_felix, Felix.class, 1193, 48820, 48826)) {
                        CallChecker.isCalled(m_felix, Felix.class, 1193, 48820, 48826).acquireBundleLock(bundle, (((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.ACTIVE)));
                    }
                } catch (IllegalStateException ex) {
                    _bcornu_try_context_34.catchStart(34);
                } finally {
                    _bcornu_try_context_34.finallyStart(34);
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1200, 49078, 49083)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1200, 49078, 49083);
                    if ((CallChecker.isCalled(bundle, BundleImpl.class, 1200, 49078, 49083).adapt(BundleRevision.class)) == revision) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1202, 49160, 49165)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1202, 49160, 49165);
                            if ((CallChecker.isCalled(bundle, BundleImpl.class, 1202, 49160, 49165).getState()) != (Bundle.INSTALLED)) {
                                if (CallChecker.beforeDeref(m_felix, Felix.class, 1204, 49237, 49243)) {
                                    final Logger npe_invocation_var124 = CallChecker.isCalled(m_felix, Felix.class, 1204, 49237, 49243).getLogger();
                                    if (CallChecker.beforeDeref(npe_invocation_var124, Logger.class, 1204, 49237, 49255)) {
                                        CallChecker.isCalled(npe_invocation_var124, Logger.class, 1204, 49237, 49255).log(bundle, Logger.LOG_WARNING, "Received a resolve event for a bundle that has already been resolved.");
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(m_felix, Felix.class, 1210, 49488, 49494)) {
                                    CallChecker.isCalled(m_felix, Felix.class, 1210, 49488, 49494).setBundleStateAndNotify(bundle, Bundle.RESOLVED);
                                }
                            }
                        }
                    }
                }
            } finally {
                _bcornu_try_context_35.finallyStart(35);
                if (CallChecker.beforeDeref(m_felix, Felix.class, 1216, 49626, 49632)) {
                    CallChecker.isCalled(m_felix, Felix.class, 1216, 49626, 49632).releaseBundleLock(bundle);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context166.methodEnd();
        }
    }

    private void fireResolvedEvents(Map<Resource, List<Wire>> wireMap) {
        MethodContext _bcornu_methode_context167 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1220, 49682, 50794);
            CallChecker.varInit(wireMap, "wireMap", 1220, 49682, 50794);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1220, 49682, 50794);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1220, 49682, 50794);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1220, 49682, 50794);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1220, 49682, 50794);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1220, 49682, 50794);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1220, 49682, 50794);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1220, 49682, 50794);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1220, 49682, 50794);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1220, 49682, 50794);
            CallChecker.varInit(this.m_registry, "m_registry", 1220, 49682, 50794);
            CallChecker.varInit(this.m_felix, "m_felix", 1220, 49682, 50794);
            CallChecker.varInit(this.m_logger, "m_logger", 1220, 49682, 50794);
            if (wireMap != null) {
                Iterator<Map.Entry<Resource, List<Wire>>> iter = CallChecker.init(Iterator.class);
                wireMap = CallChecker.beforeCalled(wireMap, Map.class, 1225, 49867, 49873);
                if (CallChecker.beforeDeref(CallChecker.isCalled(wireMap, Map.class, 1225, 49867, 49873).entrySet(), Set.class, 1225, 49867, 49884)) {
                    iter = CallChecker.isCalled(wireMap.entrySet(), Set.class, 1225, 49867, 49884).iterator();
                    CallChecker.varAssign(iter, "iter", 1225, 49867, 49884);
                }
                iter = CallChecker.beforeCalled(iter, Iterator.class, 1227, 49988, 49991);
                while (CallChecker.isCalled(iter, Iterator.class, 1227, 49988, 49991).hasNext()) {
                    Map.Entry<Resource, List<Wire>> entry = CallChecker.init(Map.Entry.class);
                    if (CallChecker.beforeDeref(iter, Iterator.class, 1229, 50070, 50073)) {
                        iter = CallChecker.beforeCalled(iter, Iterator.class, 1229, 50070, 50073);
                        entry = CallChecker.isCalled(iter, Iterator.class, 1229, 50070, 50073).next();
                        CallChecker.varAssign(entry, "entry", 1229, 50070, 50073);
                    }
                    Resource resource = CallChecker.init(Resource.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1230, 50119, 50123)) {
                        entry = CallChecker.beforeCalled(entry, Map.Entry.class, 1230, 50119, 50123);
                        resource = CallChecker.isCalled(entry, Map.Entry.class, 1230, 50119, 50123).getKey();
                        CallChecker.varAssign(resource, "resource", 1230, 50119, 50123);
                    }
                    if (!(resource instanceof BundleRevision))
                        continue;
                    
                    BundleRevision revision = CallChecker.varInit(((BundleRevision) (resource)), "revision", 1234, 50241, 50292);
                    List<BundleRevision> fragments = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 1238, 50441, 50448)) {
                        revision = CallChecker.beforeCalled(revision, BundleRevision.class, 1238, 50441, 50448);
                        fragments = Util.getFragments(CallChecker.isCalled(revision, BundleRevision.class, 1238, 50441, 50448).getWiring());
                        CallChecker.varAssign(fragments, "fragments", 1238, 50441, 50448);
                    }
                    fragments = CallChecker.beforeCalled(fragments, List.class, 1239, 50500, 50508);
                    for (int i = 0; i < (CallChecker.isCalled(fragments, List.class, 1239, 50500, 50508).size()); i++) {
                        if (CallChecker.beforeDeref(fragments, List.class, 1242, 50632, 50640)) {
                            fragments = CallChecker.beforeCalled(fragments, List.class, 1242, 50632, 50640);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(fragments, List.class, 1242, 50632, 50640).get(i), BundleRevision.class, 1242, 50632, 50647)) {
                                if (CallChecker.beforeDeref(m_felix, Felix.class, 1241, 50561, 50567)) {
                                    fragments = CallChecker.beforeCalled(fragments, List.class, 1242, 50632, 50640);
                                    CallChecker.isCalled(m_felix, Felix.class, 1241, 50561, 50567).fireBundleEvent(BundleEvent.RESOLVED, CallChecker.isCalled(CallChecker.isCalled(fragments, List.class, 1242, 50632, 50640).get(i), BundleRevision.class, 1242, 50632, 50647).getBundle());
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 1244, 50743, 50750)) {
                        if (CallChecker.beforeDeref(m_felix, Felix.class, 1244, 50697, 50703)) {
                            revision = CallChecker.beforeCalled(revision, BundleRevision.class, 1244, 50743, 50750);
                            CallChecker.isCalled(m_felix, Felix.class, 1244, 50697, 50703).fireBundleEvent(BundleEvent.RESOLVED, CallChecker.isCalled(revision, BundleRevision.class, 1244, 50743, 50750).getBundle());
                        }
                    }
                } 
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context167.methodEnd();
        }
    }

    private static Set<String> calculateExportedAndReexportedPackages(BundleRevision br, Map<Resource, List<Wire>> wireMap, Set<String> pkgs, Set<BundleRevision> cycles) {
        MethodContext _bcornu_methode_context168 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(cycles, "cycles", 1249, 50801, 53435);
            CallChecker.varInit(pkgs, "pkgs", 1249, 50801, 53435);
            CallChecker.varInit(wireMap, "wireMap", 1249, 50801, 53435);
            CallChecker.varInit(br, "br", 1249, 50801, 53435);
            if (CallChecker.beforeDeref(cycles, Set.class, 1255, 51019, 51024)) {
                cycles = CallChecker.beforeCalled(cycles, Set.class, 1255, 51019, 51024);
                if (!(CallChecker.isCalled(cycles, Set.class, 1255, 51019, 51024).contains(br))) {
                    if (CallChecker.beforeDeref(cycles, Set.class, 1257, 51062, 51067)) {
                        cycles = CallChecker.beforeCalled(cycles, Set.class, 1257, 51062, 51067);
                        CallChecker.isCalled(cycles, Set.class, 1257, 51062, 51067).add(br);
                    }
                    br = CallChecker.beforeCalled(br, BundleRevision.class, 1260, 51161, 51162);
                    for (BundleCapability cap : CallChecker.isCalled(br, BundleRevision.class, 1260, 51161, 51162).getDeclaredCapabilities(null)) {
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 1262, 51229, 51231)) {
                            final String npe_invocation_var125 = CallChecker.isCalled(cap, BundleCapability.class, 1262, 51229, 51231).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var125, String.class, 1262, 51229, 51246)) {
                                if (CallChecker.isCalled(npe_invocation_var125, String.class, 1262, 51229, 51246).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 1265, 51370, 51372)) {
                                        final Map<String, Object> npe_invocation_var126 = CallChecker.isCalled(cap, BundleCapability.class, 1265, 51370, 51372).getAttributes();
                                        if (CallChecker.beforeDeref(npe_invocation_var126, Map.class, 1265, 51370, 51388)) {
                                            if (CallChecker.beforeDeref(pkgs, Set.class, 1264, 51328, 51331)) {
                                                pkgs = CallChecker.beforeCalled(pkgs, Set.class, 1264, 51328, 51331);
                                                CallChecker.isCalled(pkgs, Set.class, 1264, 51328, 51331).add(((String) (CallChecker.isCalled(npe_invocation_var126, Map.class, 1265, 51370, 51388).get(BundleRevision.PACKAGE_NAMESPACE))));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 1271, 51634, 51635)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 1271, 51634, 51635);
                        if ((CallChecker.isCalled(br, BundleRevision.class, 1271, 51634, 51635).getWiring()) == null) {
                            wireMap = CallChecker.beforeCalled(wireMap, Map.class, 1273, 51703, 51709);
                            for (Wire rw : CallChecker.isCalled(wireMap, Map.class, 1273, 51703, 51709).get(br)) {
                                if (CallChecker.beforeDeref(rw, Wire.class, 1275, 51762, 51763)) {
                                    final Capability npe_invocation_var127 = CallChecker.isCalled(rw, Wire.class, 1275, 51762, 51763).getCapability();
                                    if (CallChecker.beforeDeref(npe_invocation_var127, Capability.class, 1275, 51762, 51779)) {
                                        final String npe_invocation_var128 = CallChecker.isCalled(npe_invocation_var127, Capability.class, 1275, 51762, 51779).getNamespace();
                                        if (CallChecker.beforeDeref(npe_invocation_var128, String.class, 1275, 51762, 51794)) {
                                            if (CallChecker.isCalled(npe_invocation_var128, String.class, 1275, 51762, 51794).equals(BundleRevision.BUNDLE_NAMESPACE)) {
                                                String dir = CallChecker.init(String.class);
                                                if (CallChecker.beforeDeref(rw, Wire.class, 1278, 51921, 51922)) {
                                                    final Requirement npe_invocation_var129 = CallChecker.isCalled(rw, Wire.class, 1278, 51921, 51922).getRequirement();
                                                    if (CallChecker.beforeDeref(npe_invocation_var129, Requirement.class, 1278, 51921, 51939)) {
                                                        final Map<String, String> npe_invocation_var130 = CallChecker.isCalled(npe_invocation_var129, Requirement.class, 1278, 51921, 51939).getDirectives();
                                                        if (CallChecker.beforeDeref(npe_invocation_var130, Map.class, 1278, 51921, 51984)) {
                                                            dir = CallChecker.isCalled(npe_invocation_var130, Map.class, 1278, 51921, 51984).get(Constants.VISIBILITY_DIRECTIVE);
                                                            CallChecker.varAssign(dir, "dir", 1278, 51921, 51922);
                                                        }
                                                    }
                                                }
                                                if ((dir != null) && (dir.equals(Constants.VISIBILITY_REEXPORT))) {
                                                    if (CallChecker.beforeDeref(rw, Wire.class, 1284, 52317, 52318)) {
                                                        StatefulResolver.calculateExportedAndReexportedPackages(((BundleRevision) (CallChecker.isCalled(rw, Wire.class, 1284, 52317, 52318).getProvider())), wireMap, pkgs, cycles);
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
                        }else {
                            br = CallChecker.beforeCalled(br, BundleRevision.class, 1294, 52603, 52604);
                            for (BundleWire bw : CallChecker.isCalled(br, BundleRevision.class, 1294, 52603, 52604).getWiring().getRequiredWires(null)) {
                                if (CallChecker.beforeDeref(bw, BundleWire.class, 1296, 52684, 52685)) {
                                    final BundleCapability npe_invocation_var131 = CallChecker.isCalled(bw, BundleWire.class, 1296, 52684, 52685).getCapability();
                                    if (CallChecker.beforeDeref(npe_invocation_var131, BundleCapability.class, 1296, 52684, 52701)) {
                                        final String npe_invocation_var132 = CallChecker.isCalled(npe_invocation_var131, BundleCapability.class, 1296, 52684, 52701).getNamespace();
                                        if (CallChecker.beforeDeref(npe_invocation_var132, String.class, 1296, 52684, 52716)) {
                                            if (CallChecker.isCalled(npe_invocation_var132, String.class, 1296, 52684, 52716).equals(BundleRevision.BUNDLE_NAMESPACE)) {
                                                String dir = CallChecker.init(String.class);
                                                if (CallChecker.beforeDeref(bw, BundleWire.class, 1299, 52843, 52844)) {
                                                    final BundleRequirement npe_invocation_var133 = CallChecker.isCalled(bw, BundleWire.class, 1299, 52843, 52844).getRequirement();
                                                    if (CallChecker.beforeDeref(npe_invocation_var133, BundleRequirement.class, 1299, 52843, 52861)) {
                                                        final Map<String, String> npe_invocation_var134 = CallChecker.isCalled(npe_invocation_var133, BundleRequirement.class, 1299, 52843, 52861).getDirectives();
                                                        if (CallChecker.beforeDeref(npe_invocation_var134, Map.class, 1299, 52843, 52906)) {
                                                            dir = CallChecker.isCalled(npe_invocation_var134, Map.class, 1299, 52843, 52906).get(Constants.VISIBILITY_DIRECTIVE);
                                                            CallChecker.varAssign(dir, "dir", 1299, 52843, 52844);
                                                        }
                                                    }
                                                }
                                                if ((dir != null) && (dir.equals(Constants.VISIBILITY_REEXPORT))) {
                                                    if (CallChecker.beforeDeref(bw, BundleWire.class, 1304, 53161, 53162)) {
                                                        final BundleWiring npe_invocation_var135 = CallChecker.isCalled(bw, BundleWire.class, 1304, 53161, 53162).getProviderWiring();
                                                        if (CallChecker.beforeDeref(npe_invocation_var135, BundleWiring.class, 1304, 53161, 53182)) {
                                                            StatefulResolver.calculateExportedAndReexportedPackages(CallChecker.isCalled(npe_invocation_var135, BundleWiring.class, 1304, 53161, 53182).getRevision(), wireMap, pkgs, cycles);
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
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return pkgs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context168.methodEnd();
        }
    }

    private synchronized void indexCapabilities(BundleRevision br) {
        MethodContext _bcornu_methode_context169 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1317, 53442, 54607);
            CallChecker.varInit(br, "br", 1317, 53442, 54607);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1317, 53442, 54607);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1317, 53442, 54607);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1317, 53442, 54607);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1317, 53442, 54607);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1317, 53442, 54607);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1317, 53442, 54607);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1317, 53442, 54607);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1317, 53442, 54607);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1317, 53442, 54607);
            CallChecker.varInit(this.m_registry, "m_registry", 1317, 53442, 54607);
            CallChecker.varInit(this.m_felix, "m_felix", 1317, 53442, 54607);
            CallChecker.varInit(this.m_logger, "m_logger", 1317, 53442, 54607);
            List<BundleCapability> caps = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(br, BundleRevision.class, 1320, 53586, 53587)) {
                br = CallChecker.beforeCalled(br, BundleRevision.class, 1320, 53586, 53587);
                if ((Util.isFragment(br)) || ((CallChecker.isCalled(br, BundleRevision.class, 1320, 53586, 53587).getWiring()) == null)) {
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 1321, 53629, 53630)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 1321, 53629, 53630);
                        caps = CallChecker.isCalled(br, BundleRevision.class, 1321, 53629, 53630).getDeclaredCapabilities(null);
                        CallChecker.varAssign(caps, "caps", 1320, 53561, 53715);
                    }
                }else {
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 1322, 53680, 53681)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 1322, 53680, 53681);
                        caps = CallChecker.isCalled(br, BundleRevision.class, 1322, 53680, 53681).getWiring().getCapabilities(null);
                        CallChecker.varAssign(caps, "caps", 1320, 53561, 53715);
                    }
                }
            }
            if (caps != null) {
                for (BundleCapability cap : caps) {
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 1332, 54178, 54180)) {
                        if ((CallChecker.isCalled(cap, BundleCapability.class, 1332, 54178, 54180).getRevision()) == br) {
                            CapabilitySet capSet = CallChecker.init(CapabilitySet.class);
                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 1334, 54278, 54280)) {
                                if (CallChecker.beforeDeref(m_capSets, Map.class, 1334, 54264, 54272)) {
                                    capSet = CallChecker.isCalled(m_capSets, Map.class, 1334, 54264, 54272).get(CallChecker.isCalled(cap, BundleCapability.class, 1334, 54278, 54280).getNamespace());
                                    CallChecker.varAssign(capSet, "capSet", 1334, 54278, 54280);
                                }
                            }
                            if (capSet == null) {
                                capSet = new CapabilitySet(null, true);
                                CallChecker.varAssign(capSet, "capSet", 1337, 54385, 54423);
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 1338, 54463, 54465)) {
                                    if (CallChecker.beforeDeref(m_capSets, Map.class, 1338, 54449, 54457)) {
                                        CallChecker.isCalled(m_capSets, Map.class, 1338, 54449, 54457).put(CallChecker.isCalled(cap, BundleCapability.class, 1338, 54463, 54465).getNamespace(), capSet);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(capSet, CapabilitySet.class, 1340, 54534, 54539)) {
                                capSet = CallChecker.beforeCalled(capSet, CapabilitySet.class, 1340, 54534, 54539);
                                CallChecker.isCalled(capSet, CapabilitySet.class, 1340, 54534, 54539).addCapability(cap);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }

    private synchronized void deindexCapabilities(BundleRevision br) {
        MethodContext _bcornu_methode_context170 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1346, 54614, 55288);
            CallChecker.varInit(br, "br", 1346, 54614, 55288);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1346, 54614, 55288);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1346, 54614, 55288);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1346, 54614, 55288);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1346, 54614, 55288);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1346, 54614, 55288);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1346, 54614, 55288);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1346, 54614, 55288);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1346, 54614, 55288);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1346, 54614, 55288);
            CallChecker.varInit(this.m_registry, "m_registry", 1346, 54614, 55288);
            CallChecker.varInit(this.m_felix, "m_felix", 1346, 54614, 55288);
            CallChecker.varInit(this.m_logger, "m_logger", 1346, 54614, 55288);
            List<BundleCapability> caps = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(br, BundleRevision.class, 1351, 54934, 54935)) {
                br = CallChecker.beforeCalled(br, BundleRevision.class, 1351, 54934, 54935);
                caps = CallChecker.isCalled(br, BundleRevision.class, 1351, 54934, 54935).getDeclaredCapabilities(null);
                CallChecker.varAssign(caps, "caps", 1351, 54934, 54935);
            }
            if (caps != null) {
                for (BundleCapability cap : caps) {
                    CapabilitySet capSet = CallChecker.init(CapabilitySet.class);
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 1356, 55117, 55119)) {
                        if (CallChecker.beforeDeref(m_capSets, Map.class, 1356, 55103, 55111)) {
                            capSet = CallChecker.isCalled(m_capSets, Map.class, 1356, 55103, 55111).get(CallChecker.isCalled(cap, BundleCapability.class, 1356, 55117, 55119).getNamespace());
                            CallChecker.varAssign(capSet, "capSet", 1356, 55117, 55119);
                        }
                    }
                    if (capSet != null) {
                        capSet.removeCapability(cap);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context170.methodEnd();
        }
    }

    private synchronized boolean isSelectedSingleton(BundleRevision br) {
        MethodContext _bcornu_methode_context171 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1365, 55295, 55423);
            CallChecker.varInit(br, "br", 1365, 55295, 55423);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1365, 55295, 55423);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1365, 55295, 55423);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1365, 55295, 55423);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1365, 55295, 55423);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1365, 55295, 55423);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1365, 55295, 55423);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1365, 55295, 55423);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1365, 55295, 55423);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1365, 55295, 55423);
            CallChecker.varInit(this.m_registry, "m_registry", 1365, 55295, 55423);
            CallChecker.varInit(this.m_felix, "m_felix", 1365, 55295, 55423);
            CallChecker.varInit(this.m_logger, "m_logger", 1365, 55295, 55423);
            if (CallChecker.beforeDeref(m_selectedSingletons, Set.class, 1367, 55384, 55403)) {
                return CallChecker.isCalled(m_selectedSingletons, Set.class, 1367, 55384, 55403).contains(br);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context171.methodEnd();
        }
    }

    private synchronized void selectSingletons(StatefulResolver.ResolverHookRecord record) throws BundleException {
        MethodContext _bcornu_methode_context172 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1370, 55430, 56501);
            CallChecker.varInit(record, "record", 1370, 55430, 56501);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1370, 55430, 56501);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1370, 55430, 56501);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1370, 55430, 56501);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1370, 55430, 56501);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1370, 55430, 56501);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1370, 55430, 56501);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1370, 55430, 56501);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1370, 55430, 56501);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1370, 55430, 56501);
            CallChecker.varInit(this.m_registry, "m_registry", 1370, 55430, 56501);
            CallChecker.varInit(this.m_felix, "m_felix", 1370, 55430, 56501);
            CallChecker.varInit(this.m_logger, "m_logger", 1370, 55430, 56501);
            if (CallChecker.beforeDeref(m_selectedSingletons, Set.class, 1377, 55755, 55774)) {
                CallChecker.isCalled(m_selectedSingletons, Set.class, 1377, 55755, 55774).clear();
            }
            for (Map.Entry<String, List<BundleRevision>> entry : CallChecker.isCalled(m_singletons, Map.class, 1378, 55842, 55853).entrySet()) {
                for (BundleRevision singleton : CallChecker.isCalled(entry, Map.Entry.class, 1380, 55921, 55925).getValue()) {
                    if (CallChecker.beforeDeref(singleton, BundleRevision.class, 1382, 55973, 55981)) {
                        if ((CallChecker.isCalled(singleton, BundleRevision.class, 1382, 55973, 55981).getWiring()) == null) {
                            deindexCapabilities(singleton);
                            if (CallChecker.beforeDeref(m_fragments, Set.class, 1385, 56094, 56104)) {
                                CallChecker.isCalled(m_fragments, Set.class, 1385, 56094, 56104).remove(singleton);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(record, StatefulResolver.ResolverHookRecord.class, 1392, 56311, 56316)) {
                record = CallChecker.beforeCalled(record, StatefulResolver.ResolverHookRecord.class, 1392, 56311, 56316);
                final Set<ServiceReference<ResolverHookFactory>> npe_invocation_var136 = CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 1392, 56311, 56316).getResolverHookRefs();
                if (CallChecker.beforeDeref(npe_invocation_var136, Set.class, 1392, 56311, 56338)) {
                    if (CallChecker.isCalled(npe_invocation_var136, Set.class, 1392, 56311, 56338).isEmpty()) {
                        selectDefaultSingletons(record);
                    }else {
                        selectSingletonsUsingHooks(record);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context172.methodEnd();
        }
    }

    private void selectDefaultSingletons(StatefulResolver.ResolverHookRecord record) {
        MethodContext _bcornu_methode_context173 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1407, 56508, 57008);
            CallChecker.varInit(record, "record", 1407, 56508, 57008);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1407, 56508, 57008);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1407, 56508, 57008);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1407, 56508, 57008);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1407, 56508, 57008);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1407, 56508, 57008);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1407, 56508, 57008);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1407, 56508, 57008);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1407, 56508, 57008);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1407, 56508, 57008);
            CallChecker.varInit(this.m_registry, "m_registry", 1407, 56508, 57008);
            CallChecker.varInit(this.m_felix, "m_felix", 1407, 56508, 57008);
            CallChecker.varInit(this.m_logger, "m_logger", 1407, 56508, 57008);
            for (Map.Entry<String, List<BundleRevision>> entry : CallChecker.isCalled(m_singletons, Map.class, 1410, 56904, 56915).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1412, 56975, 56979)) {
                    selectSingleton(record, CallChecker.isCalled(entry, Map.Entry.class, 1412, 56975, 56979).getValue());
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context173.methodEnd();
        }
    }

    private void selectSingletonsUsingHooks(StatefulResolver.ResolverHookRecord record) throws BundleException {
        MethodContext _bcornu_methode_context174 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1422, 57015, 59997);
            CallChecker.varInit(record, "record", 1422, 57015, 59997);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1422, 57015, 59997);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1422, 57015, 59997);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1422, 57015, 59997);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1422, 57015, 59997);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1422, 57015, 59997);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1422, 57015, 59997);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1422, 57015, 59997);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1422, 57015, 59997);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1422, 57015, 59997);
            CallChecker.varInit(this.m_registry, "m_registry", 1422, 57015, 59997);
            CallChecker.varInit(this.m_felix, "m_felix", 1422, 57015, 59997);
            CallChecker.varInit(this.m_logger, "m_logger", 1422, 57015, 59997);
            Map<BundleCapability, Collection<BundleCapability>> allCollisions = CallChecker.varInit(new HashMap<BundleCapability, Collection<BundleCapability>>(), "allCollisions", 1428, 57569, 57710);
            for (Map.Entry<String, List<BundleRevision>> entry : CallChecker.isCalled(m_singletons, Map.class, 1430, 57769, 57780).entrySet()) {
                Collection<BundleCapability> bundleCaps = CallChecker.varInit(new ArrayList<BundleCapability>(), "bundleCaps", 1432, 57816, 57907);
                for (BundleRevision br : CallChecker.isCalled(entry, Map.Entry.class, 1434, 57946, 57950).getValue()) {
                    List<BundleCapability> caps = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 1437, 58044, 58045)) {
                        caps = CallChecker.isCalled(br, BundleRevision.class, 1437, 58044, 58045).getDeclaredCapabilities(BundleRevision.BUNDLE_NAMESPACE);
                        CallChecker.varAssign(caps, "caps", 1437, 58044, 58045);
                    }
                    if (CallChecker.beforeDeref(caps, List.class, 1438, 58126, 58129)) {
                        caps = CallChecker.beforeCalled(caps, List.class, 1438, 58126, 58129);
                        if (!(CallChecker.isCalled(caps, List.class, 1438, 58126, 58129).isEmpty())) {
                            if (CallChecker.beforeDeref(caps, List.class, 1440, 58195, 58198)) {
                                if (CallChecker.beforeDeref(bundleCaps, Collection.class, 1440, 58180, 58189)) {
                                    caps = CallChecker.beforeCalled(caps, List.class, 1440, 58195, 58198);
                                    bundleCaps = CallChecker.beforeCalled(bundleCaps, Collection.class, 1440, 58180, 58189);
                                    CallChecker.isCalled(bundleCaps, Collection.class, 1440, 58180, 58189).add(CallChecker.isCalled(caps, List.class, 1440, 58195, 58198).get(0));
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(bundleCaps, void.class, 1444, 58281, 58290)) {
                    for (BundleCapability bc : bundleCaps) {
                        Collection<BundleCapability> capCopy = CallChecker.varInit(new ShrinkableCollection<BundleCapability>(new ArrayList<BundleCapability>(bundleCaps)), "capCopy", 1446, 58323, 58494);
                        if (CallChecker.beforeDeref(capCopy, Collection.class, 1449, 58512, 58518)) {
                            capCopy = CallChecker.beforeCalled(capCopy, Collection.class, 1449, 58512, 58518);
                            CallChecker.isCalled(capCopy, Collection.class, 1449, 58512, 58518).remove(bc);
                        }
                        if (CallChecker.beforeDeref(allCollisions, Map.class, 1450, 58548, 58560)) {
                            allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1450, 58548, 58560);
                            CallChecker.isCalled(allCollisions, Map.class, 1450, 58548, 58560).put(bc, capCopy);
                        }
                    }
                }
            }
            record = CallChecker.beforeCalled(record, StatefulResolver.ResolverHookRecord.class, 1455, 58708, 58713);
            for (ResolverHook hook : CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 1455, 58708, 58713).getResolverHooks()) {
                allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1458, 58840, 58852);
                for (Map.Entry<BundleCapability, Collection<BundleCapability>> entry : CallChecker.isCalled(allCollisions, Map.class, 1458, 58840, 58852).entrySet()) {
                    TryContext _bcornu_try_context_36 = new TryContext(36, StatefulResolver.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 1463, 59018, 59022)) {
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 1463, 59034, 59038)) {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 1462, 58938, 58957)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 1462, 58938, 58957).invokeResolverHookSingleton(hook, CallChecker.isCalled(entry, Map.Entry.class, 1463, 59018, 59022).getKey(), CallChecker.isCalled(entry, Map.Entry.class, 1463, 59034, 59038).getValue());
                                }
                            }
                        }
                    } catch (Throwable ex) {
                        _bcornu_try_context_36.catchStart(36);
                        throw new BundleException(("Resolver hook exception: " + (ex.getMessage())), BundleException.REJECTED_BY_HOOK, ex);
                    } finally {
                        _bcornu_try_context_36.finallyStart(36);
                    }
                }
            }
            List<List<BundleRevision>> groups = CallChecker.varInit(new ArrayList<List<BundleRevision>>(), "groups", 1477, 59479, 59552);
            allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1478, 59570, 59582);
            while (!(CallChecker.isCalled(allCollisions, Map.class, 1478, 59570, 59582).isEmpty())) {
                BundleCapability target = CallChecker.init(BundleCapability.class);
                if (CallChecker.beforeDeref(allCollisions, Map.class, 1480, 59643, 59655)) {
                    allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1480, 59643, 59655);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(allCollisions, Map.class, 1480, 59643, 59655).entrySet(), Set.class, 1480, 59643, 59666)) {
                        allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1480, 59643, 59655);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(allCollisions, Map.class, 1480, 59643, 59655).entrySet(), Set.class, 1480, 59643, 59666).iterator(), Iterator.class, 1480, 59643, 59677)) {
                            allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1480, 59643, 59655);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(allCollisions, Map.class, 1480, 59643, 59655).entrySet(), Set.class, 1480, 59643, 59666).iterator(), Iterator.class, 1480, 59643, 59677).next(), Map.Entry.class, 1480, 59643, 59684)) {
                                allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1480, 59643, 59655);
                                target = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(allCollisions, Map.class, 1480, 59643, 59655).entrySet(), Set.class, 1480, 59643, 59666).iterator(), Iterator.class, 1480, 59643, 59677).next(), Map.Entry.class, 1480, 59643, 59684).getKey();
                                CallChecker.varAssign(target, "target", 1480, 59643, 59655);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(groups, List.class, 1481, 59708, 59713)) {
                    groups = CallChecker.beforeCalled(groups, List.class, 1481, 59708, 59713);
                    CallChecker.isCalled(groups, List.class, 1481, 59708, 59713).add(groupSingletons(allCollisions, target, new ArrayList<BundleRevision>()));
                }
            } 
            if (CallChecker.beforeDeref(groups, void.class, 1485, 59921, 59926)) {
                for (List<BundleRevision> group : groups) {
                    selectSingleton(record, group);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    private List<BundleRevision> groupSingletons(Map<BundleCapability, Collection<BundleCapability>> allCollisions, BundleCapability target, List<BundleRevision> group) {
        MethodContext _bcornu_methode_context175 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1491, 60004, 61599);
            CallChecker.varInit(group, "group", 1491, 60004, 61599);
            CallChecker.varInit(target, "target", 1491, 60004, 61599);
            CallChecker.varInit(allCollisions, "allCollisions", 1491, 60004, 61599);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1491, 60004, 61599);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1491, 60004, 61599);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1491, 60004, 61599);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1491, 60004, 61599);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1491, 60004, 61599);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1491, 60004, 61599);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1491, 60004, 61599);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1491, 60004, 61599);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1491, 60004, 61599);
            CallChecker.varInit(this.m_registry, "m_registry", 1491, 60004, 61599);
            CallChecker.varInit(this.m_felix, "m_felix", 1491, 60004, 61599);
            CallChecker.varInit(this.m_logger, "m_logger", 1491, 60004, 61599);
            if (CallChecker.beforeDeref(target, BundleCapability.class, 1495, 60220, 60225)) {
                if (CallChecker.beforeDeref(group, List.class, 1495, 60205, 60209)) {
                    target = CallChecker.beforeCalled(target, BundleCapability.class, 1495, 60220, 60225);
                    group = CallChecker.beforeCalled(group, List.class, 1495, 60205, 60209);
                    if (!(CallChecker.isCalled(group, List.class, 1495, 60205, 60209).contains(CallChecker.isCalled(target, BundleCapability.class, 1495, 60220, 60225).getRevision()))) {
                        if (CallChecker.beforeDeref(target, BundleCapability.class, 1498, 60347, 60352)) {
                            if (CallChecker.beforeDeref(group, List.class, 1498, 60337, 60341)) {
                                target = CallChecker.beforeCalled(target, BundleCapability.class, 1498, 60347, 60352);
                                group = CallChecker.beforeCalled(group, List.class, 1498, 60337, 60341);
                                CallChecker.isCalled(group, List.class, 1498, 60337, 60341).add(CallChecker.isCalled(target, BundleCapability.class, 1498, 60347, 60352).getRevision());
                            }
                        }
                        Collection<BundleCapability> collisions = CallChecker.init(Collection.class);
                        if (CallChecker.beforeDeref(allCollisions, Map.class, 1502, 60532, 60544)) {
                            allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1502, 60532, 60544);
                            collisions = CallChecker.isCalled(allCollisions, Map.class, 1502, 60532, 60544).remove(target);
                            CallChecker.varAssign(collisions, "collisions", 1502, 60532, 60544);
                        }
                        if (CallChecker.beforeDeref(collisions, List.class, 1503, 60608, 60617)) {
                            for (BundleCapability collision : collisions) {
                                groupSingletons(allCollisions, collision, group);
                            }
                        }
                        boolean repeat = CallChecker.init(boolean.class);
                        do {
                            repeat = false;
                            CallChecker.varAssign(repeat, "repeat", 1515, 61089, 61103);
                            allCollisions = CallChecker.beforeCalled(allCollisions, Map.class, 1517, 61207, 61219);
                            for (Map.Entry<BundleCapability, Collection<BundleCapability>> entry : CallChecker.isCalled(allCollisions, Map.class, 1517, 61207, 61219).entrySet()) {
                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1519, 61275, 61279)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 1519, 61275, 61279).getValue(), Collection.class, 1519, 61275, 61290)) {
                                        if (CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 1519, 61275, 61279).getValue(), Collection.class, 1519, 61275, 61290).contains(target)) {
                                            repeat = true;
                                            CallChecker.varAssign(repeat, "repeat", 1521, 61356, 61369);
                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 1522, 61426, 61430)) {
                                                groupSingletons(allCollisions, CallChecker.isCalled(entry, Map.Entry.class, 1522, 61426, 61430).getKey(), group);
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        } while (repeat );
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return group;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context175.methodEnd();
        }
    }

    private void selectSingleton(StatefulResolver.ResolverHookRecord record, List<BundleRevision> singletons) {
        MethodContext _bcornu_methode_context176 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1538, 61606, 63314);
            CallChecker.varInit(singletons, "singletons", 1538, 61606, 63314);
            CallChecker.varInit(record, "record", 1538, 61606, 63314);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1538, 61606, 63314);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1538, 61606, 63314);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1538, 61606, 63314);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1538, 61606, 63314);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1538, 61606, 63314);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1538, 61606, 63314);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1538, 61606, 63314);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1538, 61606, 63314);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1538, 61606, 63314);
            CallChecker.varInit(this.m_registry, "m_registry", 1538, 61606, 63314);
            CallChecker.varInit(this.m_felix, "m_felix", 1538, 61606, 63314);
            CallChecker.varInit(this.m_logger, "m_logger", 1538, 61606, 63314);
            BundleRevision selected = CallChecker.varInit(null, "selected", 1540, 61970, 62000);
            if (CallChecker.beforeDeref(singletons, void.class, 1541, 62042, 62051)) {
                for (BundleRevision singleton : singletons) {
                    if (CallChecker.beforeDeref(singleton, BundleRevision.class, 1545, 62175, 62183)) {
                        if ((CallChecker.isCalled(singleton, BundleRevision.class, 1545, 62175, 62183).getWiring()) != null) {
                            selected = null;
                            CallChecker.varAssign(selected, "selected", 1547, 62236, 62251);
                            break;
                        }
                    }
                    if (CallChecker.beforeDeref(record, StatefulResolver.ResolverHookRecord.class, 1554, 62556, 62561)) {
                        if (CallChecker.beforeDeref(record, StatefulResolver.ResolverHookRecord.class, 1554, 62604, 62609)) {
                            if (CallChecker.beforeDeref(singleton, BundleRevision.class, 1556, 62756, 62764)) {
                                selected = CallChecker.beforeCalled(selected, BundleRevision.class, 1556, 62724, 62731);
                                final Version npe_invocation_var137 = CallChecker.isCalled(selected, BundleRevision.class, 1556, 62724, 62731).getVersion();
                                if (CallChecker.beforeDeref(npe_invocation_var137, Version.class, 1556, 62724, 62744)) {
                                    record = CallChecker.beforeCalled(record, StatefulResolver.ResolverHookRecord.class, 1554, 62556, 62561);
                                    record = CallChecker.beforeCalled(record, StatefulResolver.ResolverHookRecord.class, 1554, 62604, 62609);
                                    if ((((CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 1554, 62556, 62561).getBundleRevisionWhitelist()) == null) || (CallChecker.isCalled(record, StatefulResolver.ResolverHookRecord.class, 1554, 62604, 62609).getBundleRevisionWhitelist().contains(singleton))) && ((selected == null) || ((CallChecker.isCalled(npe_invocation_var137, Version.class, 1556, 62724, 62744).compareTo(CallChecker.isCalled(singleton, BundleRevision.class, 1556, 62756, 62764).getVersion())) > 0))) {
                                        selected = singleton;
                                        CallChecker.varAssign(selected, "selected", 1558, 62817, 62837);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (selected != null) {
                if (CallChecker.beforeDeref(m_selectedSingletons, Set.class, 1564, 62961, 62980)) {
                    CallChecker.isCalled(m_selectedSingletons, Set.class, 1564, 62961, 62980).add(selected);
                }
                indexCapabilities(selected);
                if (Util.isFragment(selected)) {
                    if (CallChecker.beforeDeref(m_fragments, Set.class, 1571, 63259, 63269)) {
                        CallChecker.isCalled(m_fragments, Set.class, 1571, 63259, 63269).add(selected);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context176.methodEnd();
        }
    }

    private synchronized Set<BundleRevision> getFragments() {
        MethodContext _bcornu_methode_context177 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 1576, 63321, 63929);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1576, 63321, 63929);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1576, 63321, 63929);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1576, 63321, 63929);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1576, 63321, 63929);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1576, 63321, 63929);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1576, 63321, 63929);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1576, 63321, 63929);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1576, 63321, 63929);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1576, 63321, 63929);
            CallChecker.varInit(this.m_registry, "m_registry", 1576, 63321, 63929);
            CallChecker.varInit(this.m_felix, "m_felix", 1576, 63321, 63929);
            CallChecker.varInit(this.m_logger, "m_logger", 1576, 63321, 63929);
            Set<BundleRevision> fragments = CallChecker.varInit(new HashSet(m_fragments), "fragments", 1578, 63391, 63447);
            fragments = CallChecker.beforeCalled(fragments, Set.class, 1580, 63563, 63571);
            for (Iterator<BundleRevision> it = CallChecker.isCalled(fragments, Set.class, 1580, 63563, 63571).iterator(); CallChecker.isCalled(it, Iterator.class, 1580, 63585, 63586).hasNext();) {
                BundleRevision fragment = CallChecker.init(BundleRevision.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 1582, 63649, 63650)) {
                    fragment = CallChecker.isCalled(it, Iterator.class, 1582, 63649, 63650).next();
                    CallChecker.varAssign(fragment, "fragment", 1582, 63649, 63650);
                }
                BundleRevision currentFragmentRevision = CallChecker.init(BundleRevision.class);
                if (CallChecker.beforeDeref(fragment, BundleRevision.class, 1584, 63729, 63736)) {
                    fragment = CallChecker.beforeCalled(fragment, BundleRevision.class, 1584, 63729, 63736);
                    final Bundle npe_invocation_var138 = CallChecker.isCalled(fragment, BundleRevision.class, 1584, 63729, 63736).getBundle();
                    if (CallChecker.beforeDeref(npe_invocation_var138, Bundle.class, 1584, 63729, 63748)) {
                        currentFragmentRevision = CallChecker.isCalled(npe_invocation_var138, Bundle.class, 1584, 63729, 63748).adapt(BundleRevision.class);
                        CallChecker.varAssign(currentFragmentRevision, "currentFragmentRevision", 1584, 63729, 63736);
                    }
                }
                if (fragment != currentFragmentRevision) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 1587, 63862, 63863)) {
                        CallChecker.isCalled(it, Iterator.class, 1587, 63862, 63863).remove();
                    }
                }
            }
            return fragments;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context177.methodEnd();
        }
    }

    void checkNativeLibraries(BundleRevision revision) throws ResolveException {
        MethodContext _bcornu_methode_context178 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1593, 63936, 65367);
            CallChecker.varInit(revision, "revision", 1593, 63936, 65367);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1593, 63936, 65367);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1593, 63936, 65367);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1593, 63936, 65367);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1593, 63936, 65367);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1593, 63936, 65367);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1593, 63936, 65367);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1593, 63936, 65367);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1593, 63936, 65367);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1593, 63936, 65367);
            CallChecker.varInit(this.m_registry, "m_registry", 1593, 63936, 65367);
            CallChecker.varInit(this.m_felix, "m_felix", 1593, 63936, 65367);
            CallChecker.varInit(this.m_logger, "m_logger", 1593, 63936, 65367);
            List<NativeLibrary> libs = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 1597, 64208, 64215)) {
                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 1597, 64208, 64215);
                libs = CallChecker.isCalled(((BundleRevisionImpl) (revision)), BundleRevisionImpl.class, 1597, 64208, 64215).getDeclaredNativeLibraries();
                CallChecker.varAssign(libs, "libs", 1597, 64208, 64215);
            }
            if (libs != null) {
                String msg = CallChecker.varInit(null, "msg", 1600, 64296, 64313);
                for (int libIdx = 0; (msg == null) && (libIdx < (libs.size())); libIdx++) {
                    String entryName = CallChecker.init(String.class);
                    libs = CallChecker.beforeCalled(libs, List.class, 1605, 64596, 64599);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(libs, List.class, 1605, 64596, 64599).get(libIdx), NativeLibrary.class, 1605, 64596, 64611)) {
                        entryName = CallChecker.isCalled(libs.get(libIdx), NativeLibrary.class, 1605, 64596, 64611).getEntryName();
                        CallChecker.varAssign(entryName, "entryName", 1605, 64596, 64611);
                    }
                    if (entryName != null) {
                        if (CallChecker.beforeDeref(revision, BundleRevision.class, 1608, 64733, 64740)) {
                            revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 1608, 64733, 64740);
                            final Content npe_invocation_var139 = CallChecker.isCalled(((BundleRevisionImpl) (revision)), BundleRevisionImpl.class, 1608, 64733, 64740).getContent();
                            if (CallChecker.beforeDeref(npe_invocation_var139, Content.class, 1608, 64711, 64754)) {
                                if (!(CallChecker.isCalled(npe_invocation_var139, Content.class, 1608, 64711, 64754).hasEntry(entryName))) {
                                    msg = "Native library does not exist: " + entryName;
                                    CallChecker.varAssign(msg, "msg", 1610, 64823, 64874);
                                }
                            }
                        }
                    }
                }
                if (libs.isEmpty()) {
                    msg = "No matching native libraries found.";
                    CallChecker.varAssign(msg, "msg", 1619, 65172, 65215);
                }
                if (msg != null) {
                    throw new ResolveException(msg, revision, null);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context178.methodEnd();
        }
    }

    private synchronized Set<BundleRevision> getUnresolvedRevisions() {
        MethodContext _bcornu_methode_context179 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 1628, 65374, 65737);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1628, 65374, 65737);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1628, 65374, 65737);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1628, 65374, 65737);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1628, 65374, 65737);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1628, 65374, 65737);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1628, 65374, 65737);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1628, 65374, 65737);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1628, 65374, 65737);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1628, 65374, 65737);
            CallChecker.varInit(this.m_registry, "m_registry", 1628, 65374, 65737);
            CallChecker.varInit(this.m_felix, "m_felix", 1628, 65374, 65737);
            CallChecker.varInit(this.m_logger, "m_logger", 1628, 65374, 65737);
            Set<BundleRevision> unresolved = CallChecker.varInit(new HashSet<BundleRevision>(), "unresolved", 1630, 65454, 65516);
            if (CallChecker.beforeDeref(m_revisions, Set.class, 1631, 65557, 65567)) {
                for (BundleRevision revision : m_revisions) {
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 1633, 65596, 65603)) {
                        if ((CallChecker.isCalled(revision, BundleRevision.class, 1633, 65596, 65603).getWiring()) == null) {
                            if (CallChecker.beforeDeref(unresolved, Set.class, 1635, 65656, 65665)) {
                                unresolved = CallChecker.beforeCalled(unresolved, Set.class, 1635, 65656, 65665);
                                CallChecker.isCalled(unresolved, Set.class, 1635, 65656, 65665).add(revision);
                            }
                        }
                    }
                }
            }
            return unresolved;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context179.methodEnd();
        }
    }

    private synchronized Map<Resource, Wiring> getWirings() {
        MethodContext _bcornu_methode_context180 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 1641, 65744, 66115);
            CallChecker.varInit(this.m_fwkExecEnvSet, "m_fwkExecEnvSet", 1641, 65744, 66115);
            CallChecker.varInit(this.m_fwkExecEnvStr, "m_fwkExecEnvStr", 1641, 65744, 66115);
            CallChecker.varInit(this.m_selectedSingletons, "m_selectedSingletons", 1641, 65744, 66115);
            CallChecker.varInit(this.m_singletons, "m_singletons", 1641, 65744, 66115);
            CallChecker.varInit(this.m_capSets, "m_capSets", 1641, 65744, 66115);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1641, 65744, 66115);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1641, 65744, 66115);
            CallChecker.varInit(this.m_isResolving, "m_isResolving", 1641, 65744, 66115);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1641, 65744, 66115);
            CallChecker.varInit(this.m_registry, "m_registry", 1641, 65744, 66115);
            CallChecker.varInit(this.m_felix, "m_felix", 1641, 65744, 66115);
            CallChecker.varInit(this.m_logger, "m_logger", 1641, 65744, 66115);
            Map<Resource, Wiring> wirings = CallChecker.varInit(new HashMap<Resource, Wiring>(), "wirings", 1643, 65814, 65877);
            if (CallChecker.beforeDeref(m_revisions, Map.class, 1645, 65919, 65929)) {
                for (BundleRevision revision : m_revisions) {
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 1647, 65958, 65965)) {
                        if ((CallChecker.isCalled(revision, BundleRevision.class, 1647, 65958, 65965).getWiring()) != null) {
                            if (CallChecker.beforeDeref(revision, BundleRevision.class, 1649, 66040, 66047)) {
                                if (CallChecker.beforeDeref(wirings, Map.class, 1649, 66018, 66024)) {
                                    wirings = CallChecker.beforeCalled(wirings, Map.class, 1649, 66018, 66024);
                                    CallChecker.isCalled(wirings, Map.class, 1649, 66018, 66024).put(revision, CallChecker.isCalled(revision, BundleRevision.class, 1649, 66040, 66047).getWiring());
                                }
                            }
                        }
                    }
                }
            }
            return wirings;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<Resource, Wiring>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context180.methodEnd();
        }
    }

    private static Set<String> parseExecutionEnvironments(String fwkExecEnvStr) {
        MethodContext _bcornu_methode_context181 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(fwkExecEnvStr, "fwkExecEnvStr", 1662, 66122, 66932);
            Set<String> newSet = CallChecker.varInit(new HashSet<String>(), "newSet", 1664, 66602, 66644);
            if (fwkExecEnvStr != null) {
                StringTokenizer tokens = CallChecker.varInit(new StringTokenizer(fwkExecEnvStr, ","), "tokens", 1667, 66703, 66767);
                tokens = CallChecker.beforeCalled(tokens, StringTokenizer.class, 1668, 66788, 66793);
                while (CallChecker.isCalled(tokens, StringTokenizer.class, 1668, 66788, 66793).hasMoreTokens()) {
                    if (CallChecker.beforeDeref(tokens, StringTokenizer.class, 1670, 66853, 66858)) {
                        tokens = CallChecker.beforeCalled(tokens, StringTokenizer.class, 1670, 66853, 66858);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(tokens, StringTokenizer.class, 1670, 66853, 66858).nextToken(), String.class, 1670, 66853, 66870)) {
                            if (CallChecker.beforeDeref(newSet, Set.class, 1670, 66842, 66847)) {
                                tokens = CallChecker.beforeCalled(tokens, StringTokenizer.class, 1670, 66853, 66858);
                                newSet = CallChecker.beforeCalled(newSet, Set.class, 1670, 66842, 66847);
                                CallChecker.isCalled(newSet, Set.class, 1670, 66842, 66847).add(CallChecker.isCalled(CallChecker.isCalled(tokens, StringTokenizer.class, 1670, 66853, 66858).nextToken(), String.class, 1670, 66853, 66870).trim());
                            }
                        }
                    }
                } 
            }
            return newSet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context181.methodEnd();
        }
    }

    private static void addToSingletonMap(Map<String, List<BundleRevision>> singletons, BundleRevision br) {
        MethodContext _bcornu_methode_context182 = new MethodContext(void.class);
        try {
            CallChecker.varInit(br, "br", 1676, 66939, 67332);
            CallChecker.varInit(singletons, "singletons", 1676, 66939, 67332);
            List<BundleRevision> revisions = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(br, BundleRevision.class, 1679, 67113, 67114)) {
                if (CallChecker.beforeDeref(singletons, Map.class, 1679, 67098, 67107)) {
                    br = CallChecker.beforeCalled(br, BundleRevision.class, 1679, 67113, 67114);
                    singletons = CallChecker.beforeCalled(singletons, Map.class, 1679, 67098, 67107);
                    revisions = CallChecker.isCalled(singletons, Map.class, 1679, 67098, 67107).get(CallChecker.isCalled(br, BundleRevision.class, 1679, 67113, 67114).getSymbolicName());
                    CallChecker.varAssign(revisions, "revisions", 1679, 67113, 67114);
                }
            }
            if (revisions == null) {
                revisions = new ArrayList<BundleRevision>();
                CallChecker.varAssign(revisions, "revisions", 1682, 67189, 67232);
            }
            if (CallChecker.beforeDeref(revisions, List.class, 1684, 67252, 67260)) {
                revisions = CallChecker.beforeCalled(revisions, List.class, 1684, 67252, 67260);
                CallChecker.isCalled(revisions, List.class, 1684, 67252, 67260).add(br);
            }
            if (CallChecker.beforeDeref(br, BundleRevision.class, 1685, 67294, 67295)) {
                if (CallChecker.beforeDeref(singletons, Map.class, 1685, 67279, 67288)) {
                    br = CallChecker.beforeCalled(br, BundleRevision.class, 1685, 67294, 67295);
                    singletons = CallChecker.beforeCalled(singletons, Map.class, 1685, 67279, 67288);
                    CallChecker.isCalled(singletons, Map.class, 1685, 67279, 67288).put(CallChecker.isCalled(br, BundleRevision.class, 1685, 67294, 67295).getSymbolicName(), revisions);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context182.methodEnd();
        }
    }

    static class ResolverHookRecord {
        final Map<ServiceReference<ResolverHookFactory>, ResolverHook> m_resolveHookMap;

        final Collection<BundleRevision> m_brWhitelist;

        ResolverHookRecord(Map<ServiceReference<ResolverHookFactory>, ResolverHook> resolveHookMap, Collection<BundleRevision> brWhiteList) {
            MethodContext _bcornu_methode_context14 = new MethodContext(null);
            try {
                m_resolveHookMap = resolveHookMap;
                CallChecker.varAssign(this.m_resolveHookMap, "this.m_resolveHookMap", 1699, 67838, 67871);
                m_brWhitelist = brWhiteList;
                CallChecker.varAssign(this.m_brWhitelist, "this.m_brWhitelist", 1700, 67885, 67912);
            } finally {
                _bcornu_methode_context14.methodEnd();
            }
        }

        Collection<BundleRevision> getBundleRevisionWhitelist() {
            MethodContext _bcornu_methode_context183 = new MethodContext(Collection.class);
            try {
                CallChecker.varInit(this, "this", 1703, 67933, 68041);
                CallChecker.varInit(this.m_brWhitelist, "m_brWhitelist", 1703, 67933, 68041);
                CallChecker.varInit(this.m_resolveHookMap, "m_resolveHookMap", 1703, 67933, 68041);
                return m_brWhitelist;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Collection<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context183.methodEnd();
            }
        }

        Set<ServiceReference<ResolverHookFactory>> getResolverHookRefs() {
            MethodContext _bcornu_methode_context184 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 1708, 68052, 68181);
                CallChecker.varInit(this.m_brWhitelist, "m_brWhitelist", 1708, 68052, 68181);
                CallChecker.varInit(this.m_resolveHookMap, "m_resolveHookMap", 1708, 68052, 68181);
                if (CallChecker.beforeDeref(m_resolveHookMap, Map.class, 1710, 68146, 68161)) {
                    return CallChecker.isCalled(m_resolveHookMap, Map.class, 1710, 68146, 68161).keySet();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<ServiceReference<ResolverHookFactory>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context184.methodEnd();
            }
        }

        Iterable<ResolverHook> getResolverHooks() {
            MethodContext _bcornu_methode_context190 = new MethodContext(Iterable.class);
            try {
                CallChecker.varInit(this, "this", 1717, 68192, 70681);
                CallChecker.varInit(this.m_brWhitelist, "m_brWhitelist", 1717, 68192, 70681);
                CallChecker.varInit(this.m_resolveHookMap, "m_resolveHookMap", 1717, 68192, 70681);
                return new Iterable<ResolverHook>() {
                    public Iterator<ResolverHook> iterator() {
                        MethodContext _bcornu_methode_context189 = new MethodContext(Iterator.class);
                        try {
                            CallChecker.varInit(this, "this", 1721, 68675, 70656);
                            return new Iterator<ResolverHook>() {
                                private Iterator<Map.Entry<ServiceReference<ResolverHookFactory>, ResolverHook>> it = CallChecker.isCalled(CallChecker.isCalled(m_resolveHookMap, Map.class, 1726, 68950, 68965).entrySet(), Set.class, 1726, 68950, 68976).iterator();

                                private Map.Entry<ServiceReference<ResolverHookFactory>, ResolverHook> next = null;

                                public boolean hasNext() {
                                    MethodContext _bcornu_methode_context185 = new MethodContext(boolean.class);
                                    try {
                                        CallChecker.varInit(this, "this", 1729, 69119, 69334);
                                        if ((next) == null)
                                            findNext();
                                        
                                        return (next) != null;
                                    } catch (ForceReturn _bcornu_return_t) {
                                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                                    } finally {
                                        _bcornu_methode_context185.methodEnd();
                                    }
                                }

                                public ResolverHook next() {
                                    MethodContext _bcornu_methode_context186 = new MethodContext(ResolverHook.class);
                                    try {
                                        CallChecker.varInit(this, "this", 1737, 69361, 69791);
                                        if ((next) == null)
                                            findNext();
                                        
                                        if ((next) == null)
                                            throw new java.util.NoSuchElementException();
                                        
                                        ResolverHook hook = CallChecker.varInit(next.getValue(), "hook", 1745, 69648, 69683);
                                        next = null;
                                        CallChecker.varAssign(this.next, "this.next", 1746, 69713, 69724);
                                        return hook;
                                    } catch (ForceReturn _bcornu_return_t) {
                                        return ((ResolverHook) (_bcornu_return_t.getDecision().getValue()));
                                    } finally {
                                        _bcornu_methode_context186.methodEnd();
                                    }
                                }

                                private void findNext() {
                                    MethodContext _bcornu_methode_context187 = new MethodContext(void.class);
                                    try {
                                        CallChecker.varInit(this, "this", 1752, 69818, 70446);
                                        it = CallChecker.beforeCalled(it, Iterator.class, 1754, 70097, 70098);
                                        while (CallChecker.isCalled(it, Iterator.class, 1754, 70097, 70098).hasNext()) {
                                            if (CallChecker.beforeDeref(it, Iterator.class, 1756, 70180, 70181)) {
                                                it = CallChecker.beforeCalled(it, Iterator.class, 1756, 70180, 70181);
                                                next = CallChecker.isCalled(it, Iterator.class, 1756, 70180, 70181).next();
                                                CallChecker.varAssign(this.next, "this.next", 1756, 70173, 70189);
                                            }
                                            if (CallChecker.beforeDeref(next, Map.Entry.class, 1757, 70227, 70230)) {
                                                next = CallChecker.beforeCalled(next, Map.Entry.class, 1757, 70227, 70230);
                                                if ((CallChecker.isCalled(CallChecker.isCalled(next, Map.Entry.class, 1757, 70227, 70230).getKey(), ServiceReference.class, 1757, 70227, 70239).getBundle()) != null)
                                                    return ;
                                                else {
                                                    next = null;
                                                    CallChecker.varAssign(this.next, "this.next", 1760, 70379, 70390);
                                                }
                                            }
                                        } 
                                    } catch (ForceReturn _bcornu_return_t) {
                                        _bcornu_return_t.getDecision().getValue();
                                        return ;
                                    } finally {
                                        _bcornu_methode_context187.methodEnd();
                                    }
                                }

                                public void remove() {
                                    MethodContext _bcornu_methode_context188 = new MethodContext(void.class);
                                    try {
                                        CallChecker.varInit(this, "this", 1764, 70473, 70615);
                                        throw new UnsupportedOperationException();
                                    } catch (ForceReturn _bcornu_return_t) {
                                        _bcornu_return_t.getDecision().getValue();
                                        return ;
                                    } finally {
                                        _bcornu_methode_context188.methodEnd();
                                    }
                                }
                            };
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Iterator<ResolverHook>) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context189.methodEnd();
                        }
                    }
                };
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterable<ResolverHook>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context190.methodEnd();
            }
        }
    }
}

