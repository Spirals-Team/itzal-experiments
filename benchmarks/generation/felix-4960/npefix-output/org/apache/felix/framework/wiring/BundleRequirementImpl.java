package org.apache.felix.framework.wiring;

import org.apache.felix.framework.capabilityset.SimpleFilter;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleRevision;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.felix.framework.capabilityset.CapabilitySet;
import java.util.Collections;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.felix.framework.util.ImmutableMap;
import java.util.Map;

public class BundleRequirementImpl implements BundleRequirement {
    private final BundleRevision m_revision;

    private final String m_namespace;

    private final SimpleFilter m_filter;

    private final boolean m_optional;

    private final Map<String, String> m_dirs;

    private final Map<String, Object> m_attrs;

    public BundleRequirementImpl(BundleRevision revision, String namespace, Map<String, String> dirs, Map<String, Object> attrs, SimpleFilter filter) {
        MethodContext _bcornu_methode_context82 = new MethodContext(null);
        try {
            m_revision = revision;
            CallChecker.varAssign(this.m_revision, "this.m_revision", 45, 1810, 1831);
            m_namespace = namespace;
            CallChecker.varAssign(this.m_namespace, "this.m_namespace", 46, 1841, 1864);
            m_dirs = ImmutableMap.newInstance(dirs);
            CallChecker.varAssign(this.m_dirs, "this.m_dirs", 47, 1874, 1913);
            m_attrs = ImmutableMap.newInstance(attrs);
            CallChecker.varAssign(this.m_attrs, "this.m_attrs", 48, 1923, 1964);
            m_filter = filter;
            CallChecker.varAssign(this.m_filter, "this.m_filter", 49, 1974, 1991);
            boolean optional = CallChecker.varInit(((boolean) (false)), "optional", 52, 2048, 2072);
            if (CallChecker.beforeDeref(m_dirs, Map.class, 53, 2086, 2091)) {
                if (CallChecker.beforeDeref(m_dirs, Map.class, 54, 2152, 2157)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_dirs, Map.class, 54, 2152, 2157).get(Constants.RESOLUTION_DIRECTIVE), String.class, 54, 2152, 2193)) {
                        if ((CallChecker.isCalled(m_dirs, Map.class, 53, 2086, 2091).containsKey(Constants.RESOLUTION_DIRECTIVE)) && (CallChecker.isCalled(CallChecker.isCalled(m_dirs, Map.class, 54, 2152, 2157).get(Constants.RESOLUTION_DIRECTIVE), String.class, 54, 2152, 2193).equals(Constants.RESOLUTION_OPTIONAL))) {
                            optional = true;
                            CallChecker.varAssign(optional, "optional", 56, 2256, 2271);
                        }
                    }
                }
            }
            m_optional = optional;
            CallChecker.varAssign(this.m_optional, "this.m_optional", 58, 2291, 2312);
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    public BundleRequirementImpl(BundleRevision revision, String namespace, Map<String, String> dirs, Map<String, Object> attrs) {
        this(revision, namespace, dirs, Collections.EMPTY_MAP, SimpleFilter.convert(attrs));
        MethodContext _bcornu_methode_context83 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context83.methodEnd();
        }
    }

    public String getNamespace() {
        MethodContext _bcornu_methode_context870 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 68, 2577, 2644);
            CallChecker.varInit(this.m_attrs, "m_attrs", 68, 2577, 2644);
            CallChecker.varInit(this.m_dirs, "m_dirs", 68, 2577, 2644);
            CallChecker.varInit(this.m_optional, "m_optional", 68, 2577, 2644);
            CallChecker.varInit(this.m_filter, "m_filter", 68, 2577, 2644);
            CallChecker.varInit(this.m_namespace, "m_namespace", 68, 2577, 2644);
            CallChecker.varInit(this.m_revision, "m_revision", 68, 2577, 2644);
            return m_namespace;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context870.methodEnd();
        }
    }

    public Map<String, String> getDirectives() {
        MethodContext _bcornu_methode_context871 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 73, 2651, 2727);
            CallChecker.varInit(this.m_attrs, "m_attrs", 73, 2651, 2727);
            CallChecker.varInit(this.m_dirs, "m_dirs", 73, 2651, 2727);
            CallChecker.varInit(this.m_optional, "m_optional", 73, 2651, 2727);
            CallChecker.varInit(this.m_filter, "m_filter", 73, 2651, 2727);
            CallChecker.varInit(this.m_namespace, "m_namespace", 73, 2651, 2727);
            CallChecker.varInit(this.m_revision, "m_revision", 73, 2651, 2727);
            return m_dirs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context871.methodEnd();
        }
    }

    public Map<String, Object> getAttributes() {
        MethodContext _bcornu_methode_context872 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 78, 2734, 2811);
            CallChecker.varInit(this.m_attrs, "m_attrs", 78, 2734, 2811);
            CallChecker.varInit(this.m_dirs, "m_dirs", 78, 2734, 2811);
            CallChecker.varInit(this.m_optional, "m_optional", 78, 2734, 2811);
            CallChecker.varInit(this.m_filter, "m_filter", 78, 2734, 2811);
            CallChecker.varInit(this.m_namespace, "m_namespace", 78, 2734, 2811);
            CallChecker.varInit(this.m_revision, "m_revision", 78, 2734, 2811);
            return m_attrs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context872.methodEnd();
        }
    }

    public BundleRevision getResource() {
        MethodContext _bcornu_methode_context873 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 83, 2818, 2891);
            CallChecker.varInit(this.m_attrs, "m_attrs", 83, 2818, 2891);
            CallChecker.varInit(this.m_dirs, "m_dirs", 83, 2818, 2891);
            CallChecker.varInit(this.m_optional, "m_optional", 83, 2818, 2891);
            CallChecker.varInit(this.m_filter, "m_filter", 83, 2818, 2891);
            CallChecker.varInit(this.m_namespace, "m_namespace", 83, 2818, 2891);
            CallChecker.varInit(this.m_revision, "m_revision", 83, 2818, 2891);
            return m_revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context873.methodEnd();
        }
    }

    public BundleRevision getRevision() {
        MethodContext _bcornu_methode_context874 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 88, 2898, 2971);
            CallChecker.varInit(this.m_attrs, "m_attrs", 88, 2898, 2971);
            CallChecker.varInit(this.m_dirs, "m_dirs", 88, 2898, 2971);
            CallChecker.varInit(this.m_optional, "m_optional", 88, 2898, 2971);
            CallChecker.varInit(this.m_filter, "m_filter", 88, 2898, 2971);
            CallChecker.varInit(this.m_namespace, "m_namespace", 88, 2898, 2971);
            CallChecker.varInit(this.m_revision, "m_revision", 88, 2898, 2971);
            return m_revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context874.methodEnd();
        }
    }

    public boolean matches(BundleCapability cap) {
        MethodContext _bcornu_methode_context875 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 93, 2978, 3112);
            CallChecker.varInit(cap, "cap", 93, 2978, 3112);
            CallChecker.varInit(this.m_attrs, "m_attrs", 93, 2978, 3112);
            CallChecker.varInit(this.m_dirs, "m_dirs", 93, 2978, 3112);
            CallChecker.varInit(this.m_optional, "m_optional", 93, 2978, 3112);
            CallChecker.varInit(this.m_filter, "m_filter", 93, 2978, 3112);
            CallChecker.varInit(this.m_namespace, "m_namespace", 93, 2978, 3112);
            CallChecker.varInit(this.m_revision, "m_revision", 93, 2978, 3112);
            return CapabilitySet.matches(((BundleCapabilityImpl) (cap)), getFilter());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context875.methodEnd();
        }
    }

    public boolean isOptional() {
        MethodContext _bcornu_methode_context876 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 98, 3119, 3184);
            CallChecker.varInit(this.m_attrs, "m_attrs", 98, 3119, 3184);
            CallChecker.varInit(this.m_dirs, "m_dirs", 98, 3119, 3184);
            CallChecker.varInit(this.m_optional, "m_optional", 98, 3119, 3184);
            CallChecker.varInit(this.m_filter, "m_filter", 98, 3119, 3184);
            CallChecker.varInit(this.m_namespace, "m_namespace", 98, 3119, 3184);
            CallChecker.varInit(this.m_revision, "m_revision", 98, 3119, 3184);
            return m_optional;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context876.methodEnd();
        }
    }

    public SimpleFilter getFilter() {
        MethodContext _bcornu_methode_context877 = new MethodContext(SimpleFilter.class);
        try {
            CallChecker.varInit(this, "this", 103, 3191, 3258);
            CallChecker.varInit(this.m_attrs, "m_attrs", 103, 3191, 3258);
            CallChecker.varInit(this.m_dirs, "m_dirs", 103, 3191, 3258);
            CallChecker.varInit(this.m_optional, "m_optional", 103, 3191, 3258);
            CallChecker.varInit(this.m_filter, "m_filter", 103, 3191, 3258);
            CallChecker.varInit(this.m_namespace, "m_namespace", 103, 3191, 3258);
            CallChecker.varInit(this.m_revision, "m_revision", 103, 3191, 3258);
            return m_filter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SimpleFilter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context877.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context878 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 109, 3265, 3400);
            CallChecker.varInit(this.m_attrs, "m_attrs", 109, 3265, 3400);
            CallChecker.varInit(this.m_dirs, "m_dirs", 109, 3265, 3400);
            CallChecker.varInit(this.m_optional, "m_optional", 109, 3265, 3400);
            CallChecker.varInit(this.m_filter, "m_filter", 109, 3265, 3400);
            CallChecker.varInit(this.m_namespace, "m_namespace", 109, 3265, 3400);
            CallChecker.varInit(this.m_revision, "m_revision", 109, 3265, 3400);
            return (((("[" + (m_revision)) + "] ") + (m_namespace)) + "; ") + (CallChecker.isCalled(getFilter(), SimpleFilter.class, 111, 3372, 3382).toString());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context878.methodEnd();
        }
    }
}

