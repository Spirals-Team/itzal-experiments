package org.apache.felix.framework;

import org.osgi.resource.Wiring;
import java.util.Collections;
import java.util.Collection;
import org.osgi.resource.Capability;
import org.apache.felix.framework.resolver.CandidateComparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleCapability;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.felix.resolver.FelixResolveContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.service.resolver.HostedCapability;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.resource.Requirement;
import org.osgi.service.resolver.ResolveContext;
import org.osgi.resource.Resource;

public class ResolveContextImpl extends ResolveContext implements FelixResolveContext {
    private final StatefulResolver m_state;

    private final Map<Resource, Wiring> m_wirings;

    private final StatefulResolver.ResolverHookRecord m_resolverHookrecord;

    private final Collection<BundleRevision> m_mandatory;

    private final Collection<BundleRevision> m_optional;

    private final Collection<BundleRevision> m_ondemand;

    ResolveContextImpl(StatefulResolver state, Map<Resource, Wiring> wirings, StatefulResolver.ResolverHookRecord resolverHookRecord, Collection<BundleRevision> mandatory, Collection<BundleRevision> optional, Collection<BundleRevision> ondemand) {
        MethodContext _bcornu_methode_context141 = new MethodContext(null);
        try {
            m_state = state;
            CallChecker.varAssign(this.m_state, "this.m_state", 58, 2277, 2292);
            m_wirings = wirings;
            CallChecker.varAssign(this.m_wirings, "this.m_wirings", 59, 2302, 2321);
            m_resolverHookrecord = resolverHookRecord;
            CallChecker.varAssign(this.m_resolverHookrecord, "this.m_resolverHookrecord", 60, 2331, 2372);
            m_mandatory = mandatory;
            CallChecker.varAssign(this.m_mandatory, "this.m_mandatory", 61, 2382, 2405);
            m_optional = optional;
            CallChecker.varAssign(this.m_optional, "this.m_optional", 62, 2415, 2436);
            m_ondemand = ondemand;
            CallChecker.varAssign(this.m_ondemand, "this.m_ondemand", 63, 2446, 2467);
        } finally {
            _bcornu_methode_context141.methodEnd();
        }
    }

    @Override
    public Collection<Resource> getMandatoryResources() {
        MethodContext _bcornu_methode_context1433 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 67, 2480, 2609);
            CallChecker.varInit(this.m_ondemand, "m_ondemand", 67, 2480, 2609);
            CallChecker.varInit(this.m_optional, "m_optional", 67, 2480, 2609);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 67, 2480, 2609);
            CallChecker.varInit(this.m_resolverHookrecord, "m_resolverHookrecord", 67, 2480, 2609);
            CallChecker.varInit(this.m_wirings, "m_wirings", 67, 2480, 2609);
            CallChecker.varInit(this.m_state, "m_state", 67, 2480, 2609);
            return new ArrayList<Resource>(m_mandatory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Resource>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1433.methodEnd();
        }
    }

    @Override
    public Collection<Resource> getOptionalResources() {
        MethodContext _bcornu_methode_context1434 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 73, 2616, 2743);
            CallChecker.varInit(this.m_ondemand, "m_ondemand", 73, 2616, 2743);
            CallChecker.varInit(this.m_optional, "m_optional", 73, 2616, 2743);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 73, 2616, 2743);
            CallChecker.varInit(this.m_resolverHookrecord, "m_resolverHookrecord", 73, 2616, 2743);
            CallChecker.varInit(this.m_wirings, "m_wirings", 73, 2616, 2743);
            CallChecker.varInit(this.m_state, "m_state", 73, 2616, 2743);
            return new ArrayList<Resource>(m_optional);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Resource>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1434.methodEnd();
        }
    }

    public Collection<Resource> getOndemandResources(Resource host) {
        MethodContext _bcornu_methode_context1435 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 78, 2750, 2876);
            CallChecker.varInit(host, "host", 78, 2750, 2876);
            CallChecker.varInit(this.m_ondemand, "m_ondemand", 78, 2750, 2876);
            CallChecker.varInit(this.m_optional, "m_optional", 78, 2750, 2876);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 78, 2750, 2876);
            CallChecker.varInit(this.m_resolverHookrecord, "m_resolverHookrecord", 78, 2750, 2876);
            CallChecker.varInit(this.m_wirings, "m_wirings", 78, 2750, 2876);
            CallChecker.varInit(this.m_state, "m_state", 78, 2750, 2876);
            return new ArrayList<Resource>(m_ondemand);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Resource>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1435.methodEnd();
        }
    }

    @Override
    public List<Capability> findProviders(Requirement br) {
        MethodContext _bcornu_methode_context1436 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 84, 2883, 3488);
            CallChecker.varInit(br, "br", 84, 2883, 3488);
            CallChecker.varInit(this.m_ondemand, "m_ondemand", 84, 2883, 3488);
            CallChecker.varInit(this.m_optional, "m_optional", 84, 2883, 3488);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 84, 2883, 3488);
            CallChecker.varInit(this.m_resolverHookrecord, "m_resolverHookrecord", 84, 2883, 3488);
            CallChecker.varInit(this.m_wirings, "m_wirings", 84, 2883, 3488);
            CallChecker.varInit(this.m_state, "m_state", 84, 2883, 3488);
            if (!(br instanceof BundleRequirement))
                throw new IllegalStateException("Expected a BundleRequirement");
            
            List<BundleCapability> result = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_state, StatefulResolver.class, 89, 3123, 3129)) {
                result = CallChecker.isCalled(m_state, StatefulResolver.class, 89, 3123, 3129).findProvidersInternal(m_resolverHookrecord, br, true, true);
                CallChecker.varAssign(result, "result", 89, 3123, 3129);
            }
            @SuppressWarnings(value = "unchecked")
            List<Capability> caps = CallChecker.varInit(((List<Capability>) ((List<? extends Capability>) (result))), "caps", 95, 3214, 3461);
            return caps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1436.methodEnd();
        }
    }

    @Override
    public int insertHostedCapability(List<Capability> caps, HostedCapability hc) {
        MethodContext _bcornu_methode_context1437 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 101, 3495, 3803);
            CallChecker.varInit(hc, "hc", 101, 3495, 3803);
            CallChecker.varInit(caps, "caps", 101, 3495, 3803);
            CallChecker.varInit(this.m_ondemand, "m_ondemand", 101, 3495, 3803);
            CallChecker.varInit(this.m_optional, "m_optional", 101, 3495, 3803);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 101, 3495, 3803);
            CallChecker.varInit(this.m_resolverHookrecord, "m_resolverHookrecord", 101, 3495, 3803);
            CallChecker.varInit(this.m_wirings, "m_wirings", 101, 3495, 3803);
            CallChecker.varInit(this.m_state, "m_state", 101, 3495, 3803);
            int idx = CallChecker.varInit(((int) (Collections.binarySearch(caps, hc, new CandidateComparator()))), "idx", 103, 3601, 3672);
            if (idx < 0) {
                idx = Math.abs((idx + 1));
                CallChecker.varAssign(idx, "idx", 106, 3717, 3740);
            }
            if (CallChecker.beforeDeref(caps, List.class, 108, 3760, 3763)) {
                caps = CallChecker.beforeCalled(caps, List.class, 108, 3760, 3763);
                CallChecker.isCalled(caps, List.class, 108, 3760, 3763).add(idx, hc);
            }
            return idx;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1437.methodEnd();
        }
    }

    @Override
    public boolean isEffective(Requirement br) {
        MethodContext _bcornu_methode_context1438 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 113, 3810, 3917);
            CallChecker.varInit(br, "br", 113, 3810, 3917);
            CallChecker.varInit(this.m_ondemand, "m_ondemand", 113, 3810, 3917);
            CallChecker.varInit(this.m_optional, "m_optional", 113, 3810, 3917);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 113, 3810, 3917);
            CallChecker.varInit(this.m_resolverHookrecord, "m_resolverHookrecord", 113, 3810, 3917);
            CallChecker.varInit(this.m_wirings, "m_wirings", 113, 3810, 3917);
            CallChecker.varInit(this.m_state, "m_state", 113, 3810, 3917);
            if (CallChecker.beforeDeref(m_state, StatefulResolver.class, 115, 3888, 3894)) {
                return CallChecker.isCalled(m_state, StatefulResolver.class, 115, 3888, 3894).isEffective(br);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1438.methodEnd();
        }
    }

    @Override
    public Map<Resource, Wiring> getWirings() {
        MethodContext _bcornu_methode_context1439 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 119, 3924, 4016);
            CallChecker.varInit(this.m_ondemand, "m_ondemand", 119, 3924, 4016);
            CallChecker.varInit(this.m_optional, "m_optional", 119, 3924, 4016);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 119, 3924, 4016);
            CallChecker.varInit(this.m_resolverHookrecord, "m_resolverHookrecord", 119, 3924, 4016);
            CallChecker.varInit(this.m_wirings, "m_wirings", 119, 3924, 4016);
            CallChecker.varInit(this.m_state, "m_state", 119, 3924, 4016);
            return m_wirings;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<Resource, Wiring>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1439.methodEnd();
        }
    }
}

