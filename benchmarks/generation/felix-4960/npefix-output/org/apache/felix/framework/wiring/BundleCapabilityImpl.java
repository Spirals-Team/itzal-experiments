package org.apache.felix.framework.wiring;

import org.apache.felix.framework.util.Util;
import java.util.StringTokenizer;
import org.apache.felix.framework.capabilityset.SimpleFilter;
import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import org.apache.felix.framework.util.manifestparser.ManifestParser;
import java.util.List;
import org.apache.felix.framework.util.ImmutableMap;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRevision;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collections;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashSet;

public class BundleCapabilityImpl implements BundleCapability {
    public static final String VERSION_ATTR = "version";

    private final BundleRevision m_revision;

    private final String m_namespace;

    private final Map<String, String> m_dirs;

    private final Map<String, Object> m_attrs;

    private final List<String> m_uses;

    private final List<List<String>> m_includeFilter;

    private final List<List<String>> m_excludeFilter;

    private final Set<String> m_mandatory;

    public BundleCapabilityImpl(BundleRevision revision, String namespace, Map<String, String> dirs, Map<String, Object> attrs) {
        MethodContext _bcornu_methode_context99 = new MethodContext(null);
        try {
            m_namespace = namespace;
            CallChecker.varAssign(this.m_namespace, "this.m_namespace", 53, 2079, 2102);
            m_revision = revision;
            CallChecker.varAssign(this.m_revision, "this.m_revision", 54, 2112, 2133);
            m_dirs = ImmutableMap.newInstance(dirs);
            CallChecker.varAssign(this.m_dirs, "this.m_dirs", 55, 2143, 2182);
            m_attrs = ImmutableMap.newInstance(attrs);
            CallChecker.varAssign(this.m_attrs, "this.m_attrs", 56, 2192, 2233);
            List<String> uses = CallChecker.varInit(Collections.EMPTY_LIST, "uses", 60, 2323, 2365);
            String value = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_dirs, Map.class, 61, 2390, 2395)) {
                value = CallChecker.isCalled(m_dirs, Map.class, 61, 2390, 2395).get(Constants.USES_DIRECTIVE);
                CallChecker.varAssign(value, "value", 61, 2390, 2395);
            }
            if (value != null) {
                StringTokenizer tok = CallChecker.varInit(new StringTokenizer(value, ","), "tok", 65, 2520, 2573);
                if (CallChecker.beforeDeref(tok, StringTokenizer.class, 66, 2608, 2610)) {
                    tok = CallChecker.beforeCalled(tok, StringTokenizer.class, 66, 2608, 2610);
                    uses = new ArrayList(CallChecker.isCalled(tok, StringTokenizer.class, 66, 2608, 2610).countTokens());
                    CallChecker.varAssign(uses, "uses", 66, 2587, 2626);
                }
                tok = CallChecker.beforeCalled(tok, StringTokenizer.class, 67, 2647, 2649);
                while (CallChecker.isCalled(tok, StringTokenizer.class, 67, 2647, 2649).hasMoreTokens()) {
                    if (CallChecker.beforeDeref(tok, StringTokenizer.class, 69, 2707, 2709)) {
                        tok = CallChecker.beforeCalled(tok, StringTokenizer.class, 69, 2707, 2709);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(tok, StringTokenizer.class, 69, 2707, 2709).nextToken(), String.class, 69, 2707, 2721)) {
                            if (CallChecker.beforeDeref(uses, List.class, 69, 2698, 2701)) {
                                tok = CallChecker.beforeCalled(tok, StringTokenizer.class, 69, 2707, 2709);
                                uses = CallChecker.beforeCalled(uses, List.class, 69, 2698, 2701);
                                CallChecker.isCalled(uses, List.class, 69, 2698, 2701).add(CallChecker.isCalled(CallChecker.isCalled(tok, StringTokenizer.class, 69, 2707, 2709).nextToken(), String.class, 69, 2707, 2721).trim());
                            }
                        }
                    }
                } 
            }
            m_uses = uses;
            CallChecker.varAssign(this.m_uses, "this.m_uses", 72, 2764, 2777);
            if (CallChecker.beforeDeref(m_dirs, Map.class, 74, 2796, 2801)) {
                value = CallChecker.isCalled(m_dirs, Map.class, 74, 2796, 2801).get(Constants.INCLUDE_DIRECTIVE);
                CallChecker.varAssign(value, "value", 74, 2788, 2835);
            }
            if (value != null) {
                List<String> filters = CallChecker.varInit(ManifestParser.parseDelimitedString(value, ","), "filters", 77, 2886, 2956);
                filters = CallChecker.beforeCalled(filters, List.class, 78, 3016, 3022);
                m_includeFilter = new ArrayList<List<String>>(CallChecker.isCalled(filters, List.class, 78, 3016, 3022).size());
                CallChecker.varAssign(this.m_includeFilter, "this.m_includeFilter", 78, 2970, 3031);
                filters = CallChecker.beforeCalled(filters, List.class, 79, 3081, 3087);
                for (int filterIdx = 0; filterIdx < (CallChecker.isCalled(filters, List.class, 79, 3081, 3087).size()); filterIdx++) {
                    List<String> substrings = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(filters, List.class, 81, 3194, 3200)) {
                        filters = CallChecker.beforeCalled(filters, List.class, 81, 3194, 3200);
                        substrings = SimpleFilter.parseSubstring(CallChecker.isCalled(filters, List.class, 81, 3194, 3200).get(filterIdx));
                        CallChecker.varAssign(substrings, "substrings", 81, 3194, 3200);
                    }
                    if (CallChecker.beforeDeref(m_includeFilter, List.class, 82, 3235, 3249)) {
                        CallChecker.isCalled(m_includeFilter, List.class, 82, 3235, 3249).add(substrings);
                    }
                }
            }else {
                m_includeFilter = null;
                CallChecker.varAssign(this.m_includeFilter, "this.m_includeFilter", 87, 3327, 3349);
            }
            if (CallChecker.beforeDeref(m_dirs, Map.class, 90, 3378, 3383)) {
                value = CallChecker.isCalled(m_dirs, Map.class, 90, 3378, 3383).get(Constants.EXCLUDE_DIRECTIVE);
                CallChecker.varAssign(value, "value", 90, 3370, 3417);
            }
            if (value != null) {
                List<String> filters = CallChecker.varInit(ManifestParser.parseDelimitedString(value, ","), "filters", 93, 3468, 3538);
                filters = CallChecker.beforeCalled(filters, List.class, 94, 3598, 3604);
                m_excludeFilter = new ArrayList<List<String>>(CallChecker.isCalled(filters, List.class, 94, 3598, 3604).size());
                CallChecker.varAssign(this.m_excludeFilter, "this.m_excludeFilter", 94, 3552, 3613);
                filters = CallChecker.beforeCalled(filters, List.class, 95, 3663, 3669);
                for (int filterIdx = 0; filterIdx < (CallChecker.isCalled(filters, List.class, 95, 3663, 3669).size()); filterIdx++) {
                    List<String> substrings = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(filters, List.class, 97, 3776, 3782)) {
                        filters = CallChecker.beforeCalled(filters, List.class, 97, 3776, 3782);
                        substrings = SimpleFilter.parseSubstring(CallChecker.isCalled(filters, List.class, 97, 3776, 3782).get(filterIdx));
                        CallChecker.varAssign(substrings, "substrings", 97, 3776, 3782);
                    }
                    if (CallChecker.beforeDeref(m_excludeFilter, List.class, 98, 3817, 3831)) {
                        CallChecker.isCalled(m_excludeFilter, List.class, 98, 3817, 3831).add(substrings);
                    }
                }
            }else {
                m_excludeFilter = null;
                CallChecker.varAssign(this.m_excludeFilter, "this.m_excludeFilter", 103, 3909, 3931);
            }
            Set<String> mandatory = CallChecker.varInit(Collections.EMPTY_SET, "mandatory", 106, 3952, 3997);
            if (CallChecker.beforeDeref(m_dirs, Map.class, 107, 4015, 4020)) {
                value = CallChecker.isCalled(m_dirs, Map.class, 107, 4015, 4020).get(Constants.MANDATORY_DIRECTIVE);
                CallChecker.varAssign(value, "value", 107, 4007, 4056);
            }
            if (value != null) {
                List<String> names = CallChecker.varInit(ManifestParser.parseDelimitedString(value, ","), "names", 110, 4107, 4175);
                if (CallChecker.beforeDeref(names, List.class, 111, 4221, 4225)) {
                    names = CallChecker.beforeCalled(names, List.class, 111, 4221, 4225);
                    mandatory = new HashSet<String>(CallChecker.isCalled(names, List.class, 111, 4221, 4225).size());
                    CallChecker.varAssign(mandatory, "mandatory", 111, 4189, 4234);
                }
                if (CallChecker.beforeDeref(names, null, 112, 4267, 4271)) {
                    for (String name : names) {
                        if (CallChecker.beforeDeref(m_attrs, Map.class, 115, 4377, 4383)) {
                            if (CallChecker.isCalled(m_attrs, Map.class, 115, 4377, 4383).containsKey(name)) {
                                if (CallChecker.beforeDeref(mandatory, Set.class, 117, 4442, 4450)) {
                                    mandatory = CallChecker.beforeCalled(mandatory, Set.class, 117, 4442, 4450);
                                    CallChecker.isCalled(mandatory, Set.class, 117, 4442, 4450).add(name);
                                }
                            }else {
                                throw new IllegalArgumentException((("Mandatory attribute '" + name) + "' does not exist."));
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            m_mandatory = mandatory;
            CallChecker.varAssign(this.m_mandatory, "this.m_mandatory", 127, 4752, 4775);
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    public BundleRevision getResource() {
        MethodContext _bcornu_methode_context1012 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 130, 4788, 4861);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 130, 4788, 4861);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 130, 4788, 4861);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 130, 4788, 4861);
            CallChecker.varInit(this.m_uses, "m_uses", 130, 4788, 4861);
            CallChecker.varInit(this.m_attrs, "m_attrs", 130, 4788, 4861);
            CallChecker.varInit(this.m_dirs, "m_dirs", 130, 4788, 4861);
            CallChecker.varInit(this.m_namespace, "m_namespace", 130, 4788, 4861);
            CallChecker.varInit(this.m_revision, "m_revision", 130, 4788, 4861);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 130, 4788, 4861);
            return m_revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1012.methodEnd();
        }
    }

    public BundleRevision getRevision() {
        MethodContext _bcornu_methode_context1013 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 135, 4868, 4941);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 135, 4868, 4941);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 135, 4868, 4941);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 135, 4868, 4941);
            CallChecker.varInit(this.m_uses, "m_uses", 135, 4868, 4941);
            CallChecker.varInit(this.m_attrs, "m_attrs", 135, 4868, 4941);
            CallChecker.varInit(this.m_dirs, "m_dirs", 135, 4868, 4941);
            CallChecker.varInit(this.m_namespace, "m_namespace", 135, 4868, 4941);
            CallChecker.varInit(this.m_revision, "m_revision", 135, 4868, 4941);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 135, 4868, 4941);
            return m_revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1013.methodEnd();
        }
    }

    public String getNamespace() {
        MethodContext _bcornu_methode_context1014 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 140, 4948, 5015);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 140, 4948, 5015);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 140, 4948, 5015);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 140, 4948, 5015);
            CallChecker.varInit(this.m_uses, "m_uses", 140, 4948, 5015);
            CallChecker.varInit(this.m_attrs, "m_attrs", 140, 4948, 5015);
            CallChecker.varInit(this.m_dirs, "m_dirs", 140, 4948, 5015);
            CallChecker.varInit(this.m_namespace, "m_namespace", 140, 4948, 5015);
            CallChecker.varInit(this.m_revision, "m_revision", 140, 4948, 5015);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 140, 4948, 5015);
            return m_namespace;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1014.methodEnd();
        }
    }

    public Map<String, String> getDirectives() {
        MethodContext _bcornu_methode_context1015 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 145, 5022, 5098);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 145, 5022, 5098);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 145, 5022, 5098);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 145, 5022, 5098);
            CallChecker.varInit(this.m_uses, "m_uses", 145, 5022, 5098);
            CallChecker.varInit(this.m_attrs, "m_attrs", 145, 5022, 5098);
            CallChecker.varInit(this.m_dirs, "m_dirs", 145, 5022, 5098);
            CallChecker.varInit(this.m_namespace, "m_namespace", 145, 5022, 5098);
            CallChecker.varInit(this.m_revision, "m_revision", 145, 5022, 5098);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 145, 5022, 5098);
            return m_dirs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1015.methodEnd();
        }
    }

    public Map<String, Object> getAttributes() {
        MethodContext _bcornu_methode_context1016 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 150, 5105, 5182);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 150, 5105, 5182);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 150, 5105, 5182);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 150, 5105, 5182);
            CallChecker.varInit(this.m_uses, "m_uses", 150, 5105, 5182);
            CallChecker.varInit(this.m_attrs, "m_attrs", 150, 5105, 5182);
            CallChecker.varInit(this.m_dirs, "m_dirs", 150, 5105, 5182);
            CallChecker.varInit(this.m_namespace, "m_namespace", 150, 5105, 5182);
            CallChecker.varInit(this.m_revision, "m_revision", 150, 5105, 5182);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 150, 5105, 5182);
            return m_attrs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1016.methodEnd();
        }
    }

    public boolean isAttributeMandatory(String name) {
        MethodContext _bcornu_methode_context1017 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 155, 5189, 5317);
            CallChecker.varInit(name, "name", 155, 5189, 5317);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 155, 5189, 5317);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 155, 5189, 5317);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 155, 5189, 5317);
            CallChecker.varInit(this.m_uses, "m_uses", 155, 5189, 5317);
            CallChecker.varInit(this.m_attrs, "m_attrs", 155, 5189, 5317);
            CallChecker.varInit(this.m_dirs, "m_dirs", 155, 5189, 5317);
            CallChecker.varInit(this.m_namespace, "m_namespace", 155, 5189, 5317);
            CallChecker.varInit(this.m_revision, "m_revision", 155, 5189, 5317);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 155, 5189, 5317);
            if (CallChecker.beforeDeref(m_mandatory, Set.class, 157, 5260, 5270)) {
                return (!(CallChecker.isCalled(m_mandatory, Set.class, 157, 5260, 5270).isEmpty())) && (CallChecker.isCalled(m_mandatory, Set.class, 157, 5285, 5295).contains(name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1017.methodEnd();
        }
    }

    public List<String> getUses() {
        MethodContext _bcornu_methode_context1018 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 160, 5324, 5387);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 160, 5324, 5387);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 160, 5324, 5387);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 160, 5324, 5387);
            CallChecker.varInit(this.m_uses, "m_uses", 160, 5324, 5387);
            CallChecker.varInit(this.m_attrs, "m_attrs", 160, 5324, 5387);
            CallChecker.varInit(this.m_dirs, "m_dirs", 160, 5324, 5387);
            CallChecker.varInit(this.m_namespace, "m_namespace", 160, 5324, 5387);
            CallChecker.varInit(this.m_revision, "m_revision", 160, 5324, 5387);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 160, 5324, 5387);
            return m_uses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1018.methodEnd();
        }
    }

    public boolean isIncluded(String name) {
        MethodContext _bcornu_methode_context1019 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 165, 5394, 6525);
            CallChecker.varInit(name, "name", 165, 5394, 6525);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 165, 5394, 6525);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 165, 5394, 6525);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 165, 5394, 6525);
            CallChecker.varInit(this.m_uses, "m_uses", 165, 5394, 6525);
            CallChecker.varInit(this.m_attrs, "m_attrs", 165, 5394, 6525);
            CallChecker.varInit(this.m_dirs, "m_dirs", 165, 5394, 6525);
            CallChecker.varInit(this.m_namespace, "m_namespace", 165, 5394, 6525);
            CallChecker.varInit(this.m_revision, "m_revision", 165, 5394, 6525);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 165, 5394, 6525);
            if (((m_includeFilter) == null) && ((m_excludeFilter) == null)) {
                return true;
            }
            String className = CallChecker.varInit(Util.getClassName(name), "className", 173, 5620, 5662);
            boolean included = CallChecker.varInit(((boolean) ((this.m_includeFilter) == null)), "included", 177, 5802, 5846);
            for (int i = 0; ((!included) && ((m_includeFilter) != null)) && (i < (m_includeFilter.size())); i++) {
                included = SimpleFilter.compareSubstring(m_includeFilter.get(i), className);
                CallChecker.varAssign(included, "included", 182, 5997, 6072);
            }
            boolean excluded = CallChecker.varInit(((boolean) (false)), "excluded", 187, 6221, 6245);
            for (int i = 0; ((!excluded) && ((m_excludeFilter) != null)) && (i < (m_excludeFilter.size())); i++) {
                excluded = SimpleFilter.compareSubstring(m_excludeFilter.get(i), className);
                CallChecker.varAssign(excluded, "excluded", 192, 6396, 6471);
            }
            return included && (!excluded);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1019.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1020 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 198, 6532, 6743);
            CallChecker.varInit(this.m_mandatory, "m_mandatory", 198, 6532, 6743);
            CallChecker.varInit(this.m_excludeFilter, "m_excludeFilter", 198, 6532, 6743);
            CallChecker.varInit(this.m_includeFilter, "m_includeFilter", 198, 6532, 6743);
            CallChecker.varInit(this.m_uses, "m_uses", 198, 6532, 6743);
            CallChecker.varInit(this.m_attrs, "m_attrs", 198, 6532, 6743);
            CallChecker.varInit(this.m_dirs, "m_dirs", 198, 6532, 6743);
            CallChecker.varInit(this.m_namespace, "m_namespace", 198, 6532, 6743);
            CallChecker.varInit(this.m_revision, "m_revision", 198, 6532, 6743);
            CallChecker.varInit(VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 198, 6532, 6743);
            if ((m_revision) == null) {
                if (CallChecker.beforeDeref(m_attrs, Map.class, 202, 6638, 6644)) {
                    return CallChecker.isCalled(m_attrs, Map.class, 202, 6638, 6644).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return (((("[" + (m_revision)) + "] ") + (m_namespace)) + "; ") + (m_attrs);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1020.methodEnd();
        }
    }
}

