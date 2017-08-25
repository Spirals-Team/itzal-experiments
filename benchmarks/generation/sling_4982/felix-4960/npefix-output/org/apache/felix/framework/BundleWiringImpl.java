package org.apache.felix.framework;

import org.osgi.framework.hooks.weaving.WovenClassListener;
import org.osgi.framework.hooks.weaving.WovenClass;
import org.osgi.resource.Wire;
import org.osgi.framework.hooks.weaving.WeavingHook;
import org.osgi.framework.hooks.weaving.WeavingException;
import org.apache.felix.framework.util.Util;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.SortedMap;
import org.apache.felix.framework.capabilityset.SimpleFilter;
import java.util.Set;
import org.osgi.framework.ServiceReference;
import org.apache.felix.framework.util.SecurityManagerEx;
import java.security.SecureClassLoader;
import org.apache.felix.framework.util.SecureAction;
import org.apache.felix.framework.resolver.ResourceNotFoundException;
import org.osgi.service.resolver.ResolutionException;
import org.osgi.resource.Requirement;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;
import java.io.PrintStream;
import org.osgi.framework.PackagePermission;
import org.apache.felix.framework.util.manifestparser.NativeLibrary;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.Constants;
import org.apache.felix.framework.util.CompoundEnumeration;
import java.util.Collections;
import java.util.Collection;
import org.osgi.resource.Capability;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWiring;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.security.AccessController;
import java.util.ArrayList;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleReference;
import org.osgi.framework.wiring.BundleRequirement;
import org.apache.felix.framework.wiring.BundleRequirementImpl;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleWire;
import java.lang.reflect.Constructor;
import org.apache.felix.framework.cache.Content;
import java.util.Enumeration;
import org.apache.felix.framework.util.FelixConstants;
import java.io.File;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.FrameworkEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.io.IOException;
import org.osgi.framework.namespace.IdentityNamespace;
import org.apache.felix.framework.util.ImmutableList;
import java.util.Iterator;
import org.apache.felix.framework.cache.JarContent;
import java.util.List;
import java.net.MalformedURLException;
import org.apache.felix.framework.util.manifestparser.ManifestParser;
import java.util.Map;
import java.lang.reflect.Method;

public class BundleWiringImpl implements BundleWiring {
    public static final int LISTRESOURCES_DEBUG = 1048576;

    public static final int EAGER_ACTIVATION = 0;

    public static final int LAZY_ACTIVATION = 1;

    private final Logger m_logger;

    private final Map m_configMap;

    private final StatefulResolver m_resolver;

    private final BundleRevisionImpl m_revision;

    private final List<BundleRevision> m_fragments;

    private volatile List<BundleWire> m_wires;

    private volatile Map<String, BundleRevision> m_importedPkgs;

    private final Map<String, List<BundleRevision>> m_requiredPkgs;

    private final List<BundleCapability> m_resolvedCaps;

    private final Map<String, List<List<String>>> m_includedPkgFilters;

    private final Map<String, List<List<String>>> m_excludedPkgFilters;

    private final List<BundleRequirement> m_resolvedReqs;

    private final List<NativeLibrary> m_resolvedNativeLibs;

    private final List<Content> m_fragmentContents;

    private volatile List<BundleRequirement> m_wovenReqs = null;

    private BundleWiringImpl.BundleClassLoader m_classLoader;

    private final ClassLoader m_bootClassLoader;

    private static final ClassLoader m_defBootClassLoader;

    static {
        ClassLoader cl = CallChecker.varInit(null, "cl", 117, 4840, 4861);
        TryContext _bcornu_try_context_278 = new TryContext(278, BundleWiringImpl.class, "java.lang.Throwable");
        try {
            final SecureAction npe_invocation_var246 = BundleRevisionImpl.getSecureAction();
            Constructor ctor = CallChecker.init(Constructor.class);
            if (CallChecker.beforeDeref(npe_invocation_var246, SecureAction.class, 120, 4916, 4951)) {
                ctor = CallChecker.isCalled(npe_invocation_var246, SecureAction.class, 120, 4916, 4951).getDeclaredConstructor(SecureClassLoader.class, new Class[]{ ClassLoader.class });
                CallChecker.varAssign(ctor, "ctor", 120, 4916, 4951);
            }
            final SecureAction npe_invocation_var247 = BundleRevisionImpl.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var247, SecureAction.class, 122, 5066, 5101)) {
                CallChecker.isCalled(npe_invocation_var247, SecureAction.class, 122, 5066, 5101).setAccesssible(ctor);
            }
            final SecureAction npe_invocation_var248 = BundleRevisionImpl.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var248, SecureAction.class, 123, 5156, 5191)) {
                cl = ((ClassLoader) (CallChecker.isCalled(npe_invocation_var248, SecureAction.class, 123, 5156, 5191).invoke(ctor, new Object[]{ null })));
                CallChecker.varAssign(cl, "cl", 123, 5137, 5245);
            }
        } catch (Throwable ex) {
            _bcornu_try_context_278.catchStart(278);
            cl = null;
            CallChecker.varAssign(cl, "cl", 131, 5549, 5558);
            if (CallChecker.beforeDeref(System.err, PrintStream.class, 132, 5572, 5581)) {
                CallChecker.isCalled(System.err, PrintStream.class, 132, 5572, 5581).println(("Problem creating boot delegation class loader: " + ex));
            }
        } finally {
            _bcornu_try_context_278.finallyStart(278);
        }
        m_defBootClassLoader = cl;
        CallChecker.varAssign(m_defBootClassLoader, "BundleWiringImpl.m_defBootClassLoader", 134, 5666, 5691);
    }

    private final boolean m_implicitBootDelegation;

    private final boolean m_useLocalURLs;

    private static SecurityManagerEx m_sm = new SecurityManagerEx();

    private final ThreadLocal m_cycleCheck = new ThreadLocal();

    private static final ThreadLocal m_deferredActivation = new ThreadLocal();

    private static volatile boolean m_isPreJava5 = false;

    private volatile boolean m_isDisposed = false;

    BundleWiringImpl(Logger logger, Map configMap, StatefulResolver resolver, BundleRevisionImpl revision, List<BundleRevision> fragments, List<BundleWire> wires, Map<String, BundleRevision> importedPkgs, Map<String, List<BundleRevision>> requiredPkgs) throws Exception {
        MethodContext _bcornu_methode_context86 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 165, 6863, 6880);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 166, 6890, 6913);
            m_resolver = resolver;
            CallChecker.varAssign(this.m_resolver, "this.m_resolver", 167, 6923, 6944);
            m_revision = revision;
            CallChecker.varAssign(this.m_revision, "this.m_revision", 168, 6954, 6975);
            m_importedPkgs = importedPkgs;
            CallChecker.varAssign(this.m_importedPkgs, "this.m_importedPkgs", 169, 6985, 7014);
            m_requiredPkgs = requiredPkgs;
            CallChecker.varAssign(this.m_requiredPkgs, "this.m_requiredPkgs", 170, 7024, 7053);
            m_wires = ImmutableList.newInstance(wires);
            CallChecker.varAssign(this.m_wires, "this.m_wires", 171, 7063, 7105);
            List<Content> fragmentContents = CallChecker.varInit(null, "fragmentContents", 176, 7307, 7344);
            if (fragments != null) {
                if ((fragments.size()) > 1) {
                    SortedMap<String, BundleRevision> sorted = CallChecker.varInit(new TreeMap<String, BundleRevision>(), "sorted", 185, 7708, 7788);
                    for (BundleRevision f : fragments) {
                        if (CallChecker.beforeDeref(f, BundleRevision.class, 188, 7912, 7912)) {
                            if (CallChecker.beforeDeref(sorted, SortedMap.class, 188, 7879, 7884)) {
                                sorted = CallChecker.beforeCalled(sorted, SortedMap.class, 188, 7879, 7884);
                                CallChecker.isCalled(sorted, SortedMap.class, 188, 7879, 7884).put(CallChecker.isCalled(((BundleRevisionImpl) (f)), BundleRevisionImpl.class, 188, 7912, 7912).getId(), f);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(sorted, SortedMap.class, 190, 7988, 7993)) {
                        sorted = CallChecker.beforeCalled(sorted, SortedMap.class, 190, 7988, 7993);
                        fragments = new ArrayList(CallChecker.isCalled(sorted, SortedMap.class, 190, 7988, 7993).values());
                        CallChecker.varAssign(fragments, "fragments", 190, 7962, 8004);
                    }
                }
                fragmentContents = new ArrayList<Content>(fragments.size());
                CallChecker.varAssign(fragmentContents, "fragmentContents", 192, 8032, 8091);
                for (int i = 0; (fragments != null) && (i < (fragments.size())); i++) {
                    fragments = CallChecker.beforeCalled(fragments, List.class, 196, 8267, 8275);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(fragments, List.class, 196, 8267, 8275).get(i), BundleRevision.class, 196, 8267, 8282)) {
                        fragments = CallChecker.beforeCalled(fragments, List.class, 196, 8267, 8275);
                        final Content npe_invocation_var249 = CallChecker.isCalled(((BundleRevisionImpl) (CallChecker.isCalled(fragments, List.class, 196, 8267, 8275).get(i))), BundleRevisionImpl.class, 196, 8267, 8282).getContent();
                        if (CallChecker.beforeDeref(npe_invocation_var249, Content.class, 196, 8245, 8296)) {
                            if (CallChecker.beforeDeref(fragmentContents, List.class, 195, 8203, 8218)) {
                                fragmentContents = CallChecker.beforeCalled(fragmentContents, List.class, 195, 8203, 8218);
                                CallChecker.isCalled(fragmentContents, List.class, 195, 8203, 8218).add(CallChecker.isCalled(npe_invocation_var249, Content.class, 196, 8245, 8296).getEntryAsContent(FelixConstants.CLASS_PATH_DOT));
                            }
                        }
                    }
                }
            }
            m_fragments = fragments;
            CallChecker.varAssign(this.m_fragments, "this.m_fragments", 200, 8406, 8429);
            m_fragmentContents = fragmentContents;
            CallChecker.varAssign(this.m_fragmentContents, "this.m_fragmentContents", 201, 8439, 8476);
            Set<String> imports = CallChecker.varInit(new HashSet<String>(), "imports", 208, 8814, 8857);
            List<BundleRequirement> reqList = CallChecker.varInit(new ArrayList<BundleRequirement>(), "reqList", 209, 8867, 8935);
            if (CallChecker.beforeDeref(wires, null, 211, 9021, 9025)) {
                for (BundleWire bw : wires) {
                    if (CallChecker.beforeDeref(bw, BundleWire.class, 215, 9204, 9205)) {
                        final BundleRequirement npe_invocation_var250 = CallChecker.isCalled(bw, BundleWire.class, 215, 9204, 9205).getRequirement();
                        if (CallChecker.beforeDeref(npe_invocation_var250, BundleRequirement.class, 215, 9204, 9222)) {
                            final String npe_invocation_var251 = CallChecker.isCalled(npe_invocation_var250, BundleRequirement.class, 215, 9204, 9222).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var251, String.class, 215, 9204, 9237)) {
                                if (CallChecker.beforeDeref(bw, BundleWire.class, 216, 9314, 9315)) {
                                    if (CallChecker.beforeDeref(reqList, List.class, 216, 9297, 9303)) {
                                        reqList = CallChecker.beforeCalled(reqList, List.class, 216, 9297, 9303);
                                        if ((!(CallChecker.isCalled(npe_invocation_var251, String.class, 215, 9204, 9237).equals(BundleRevision.HOST_NAMESPACE))) || (!(CallChecker.isCalled(reqList, List.class, 216, 9297, 9303).contains(CallChecker.isCalled(bw, BundleWire.class, 216, 9314, 9315).getRequirement())))) {
                                            if (CallChecker.beforeDeref(bw, BundleWire.class, 218, 9378, 9379)) {
                                                if (CallChecker.beforeDeref(reqList, List.class, 218, 9366, 9372)) {
                                                    reqList = CallChecker.beforeCalled(reqList, List.class, 218, 9366, 9372);
                                                    CallChecker.isCalled(reqList, List.class, 218, 9366, 9372).add(CallChecker.isCalled(bw, BundleWire.class, 218, 9378, 9379).getRequirement());
                                                }
                                            }
                                            if (CallChecker.beforeDeref(bw, BundleWire.class, 219, 9420, 9421)) {
                                                final BundleRequirement npe_invocation_var252 = CallChecker.isCalled(bw, BundleWire.class, 219, 9420, 9421).getRequirement();
                                                if (CallChecker.beforeDeref(npe_invocation_var252, BundleRequirement.class, 219, 9420, 9438)) {
                                                    final String npe_invocation_var253 = CallChecker.isCalled(npe_invocation_var252, BundleRequirement.class, 219, 9420, 9438).getNamespace();
                                                    if (CallChecker.beforeDeref(npe_invocation_var253, String.class, 219, 9420, 9453)) {
                                                        if (CallChecker.isCalled(npe_invocation_var253, String.class, 219, 9420, 9453).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                                            if (CallChecker.beforeDeref(bw, BundleWire.class, 222, 9580, 9581)) {
                                                                final BundleCapability npe_invocation_var254 = CallChecker.isCalled(bw, BundleWire.class, 222, 9580, 9581).getCapability();
                                                                if (CallChecker.beforeDeref(npe_invocation_var254, BundleCapability.class, 222, 9580, 9597)) {
                                                                    final Map<String, Object> npe_invocation_var255 = CallChecker.isCalled(npe_invocation_var254, BundleCapability.class, 222, 9580, 9597).getAttributes();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var255, Map.class, 222, 9580, 9613)) {
                                                                        if (CallChecker.beforeDeref(imports, Set.class, 221, 9535, 9541)) {
                                                                            imports = CallChecker.beforeCalled(imports, Set.class, 221, 9535, 9541);
                                                                            CallChecker.isCalled(imports, Set.class, 221, 9535, 9541).add(((String) (CallChecker.isCalled(npe_invocation_var255, Map.class, 222, 9580, 9613).get(BundleRevision.PACKAGE_NAMESPACE))));
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
                            }
                        }
                    }
                }
            }
            for (BundleRequirement req : CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 227, 9786, 9795).getDeclaredRequirements(null)) {
                if (CallChecker.beforeDeref(req, BundleRequirement.class, 229, 9854, 9856)) {
                    final String npe_invocation_var256 = CallChecker.isCalled(req, BundleRequirement.class, 229, 9854, 9856).getNamespace();
                    if (CallChecker.beforeDeref(npe_invocation_var256, String.class, 229, 9854, 9871)) {
                        if (CallChecker.isCalled(npe_invocation_var256, String.class, 229, 9854, 9871).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                            String resolution = CallChecker.init(String.class);
                            if (CallChecker.beforeDeref(req, BundleRequirement.class, 231, 9965, 9967)) {
                                final Map<String, String> npe_invocation_var257 = CallChecker.isCalled(req, BundleRequirement.class, 231, 9965, 9967).getDirectives();
                                if (CallChecker.beforeDeref(npe_invocation_var257, Map.class, 231, 9965, 9983)) {
                                    resolution = CallChecker.isCalled(npe_invocation_var257, Map.class, 231, 9965, 9983).get(Constants.RESOLUTION_DIRECTIVE);
                                    CallChecker.varAssign(resolution, "resolution", 231, 9965, 9967);
                                }
                            }
                            if ((resolution != null) && (resolution.equals("dynamic"))) {
                                if (CallChecker.beforeDeref(reqList, List.class, 234, 10136, 10142)) {
                                    reqList = CallChecker.beforeCalled(reqList, List.class, 234, 10136, 10142);
                                    CallChecker.isCalled(reqList, List.class, 234, 10136, 10142).add(req);
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((m_fragments) != null) {
                for (BundleRevision fragment : m_fragments) {
                    for (BundleRequirement req : CallChecker.isCalled(fragment, BundleRevision.class, 243, 10415, 10422).getDeclaredRequirements(null)) {
                        if (CallChecker.beforeDeref(req, BundleRequirement.class, 245, 10497, 10499)) {
                            final String npe_invocation_var258 = CallChecker.isCalled(req, BundleRequirement.class, 245, 10497, 10499).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var258, String.class, 245, 10497, 10514)) {
                                if (CallChecker.isCalled(npe_invocation_var258, String.class, 245, 10497, 10514).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                    String resolution = CallChecker.init(String.class);
                                    if (CallChecker.beforeDeref(req, BundleRequirement.class, 247, 10624, 10626)) {
                                        final Map<String, String> npe_invocation_var259 = CallChecker.isCalled(req, BundleRequirement.class, 247, 10624, 10626).getDirectives();
                                        if (CallChecker.beforeDeref(npe_invocation_var259, Map.class, 247, 10624, 10642)) {
                                            resolution = CallChecker.isCalled(npe_invocation_var259, Map.class, 247, 10624, 10642).get(Constants.RESOLUTION_DIRECTIVE);
                                            CallChecker.varAssign(resolution, "resolution", 247, 10624, 10626);
                                        }
                                    }
                                    if ((resolution != null) && (resolution.equals("dynamic"))) {
                                        if (CallChecker.beforeDeref(reqList, List.class, 250, 10819, 10825)) {
                                            reqList = CallChecker.beforeCalled(reqList, List.class, 250, 10819, 10825);
                                            CallChecker.isCalled(reqList, List.class, 250, 10819, 10825).add(req);
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            m_resolvedReqs = ImmutableList.newInstance(reqList);
            CallChecker.varAssign(this.m_resolvedReqs, "this.m_resolvedReqs", 256, 10935, 10986);
            boolean isFragment = CallChecker.varInit(((boolean) (Util.isFragment(revision))), "isFragment", 263, 11326, 11372);
            List<BundleCapability> capList = CallChecker.varInit(new ArrayList<BundleCapability>(), "capList", 264, 11382, 11448);
            Map<String, List<List<String>>> includedPkgFilters = CallChecker.varInit(new HashMap<String, List<List<String>>>(), "includedPkgFilters", 266, 11544, 11650);
            Map<String, List<List<String>>> excludedPkgFilters = CallChecker.varInit(new HashMap<String, List<List<String>>>(), "excludedPkgFilters", 268, 11660, 11766);
            if (isFragment) {
                for (BundleCapability cap : CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 274, 11906, 11915).getDeclaredCapabilities(null)) {
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 276, 12026, 12028)) {
                        if (CallChecker.beforeDeref(IdentityNamespace.IDENTITY_NAMESPACE, String.class, 276, 11982, 12017)) {
                            if (CallChecker.isCalled(IdentityNamespace.IDENTITY_NAMESPACE, String.class, 276, 11982, 12017).equals(CallChecker.isCalled(cap, BundleCapability.class, 276, 12026, 12028).getNamespace())) {
                                String effective = CallChecker.init(String.class);
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 278, 12104, 12106)) {
                                    final Map<String, String> npe_invocation_var260 = CallChecker.isCalled(cap, BundleCapability.class, 278, 12104, 12106).getDirectives();
                                    if (CallChecker.beforeDeref(npe_invocation_var260, Map.class, 278, 12104, 12122)) {
                                        effective = CallChecker.isCalled(npe_invocation_var260, Map.class, 278, 12104, 12122).get(Constants.EFFECTIVE_DIRECTIVE);
                                        CallChecker.varAssign(effective, "effective", 278, 12104, 12106);
                                    }
                                }
                                if ((effective == null) || (effective.equals(Constants.EFFECTIVE_RESOLVE))) {
                                    if (CallChecker.beforeDeref(capList, List.class, 281, 12302, 12308)) {
                                        capList = CallChecker.beforeCalled(capList, List.class, 281, 12302, 12308);
                                        CallChecker.isCalled(capList, List.class, 281, 12302, 12308).add(cap);
                                    }
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else {
                for (BundleCapability cap : CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 288, 12447, 12456).getDeclaredCapabilities(null)) {
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 290, 12524, 12526)) {
                        final String npe_invocation_var261 = CallChecker.isCalled(cap, BundleCapability.class, 290, 12524, 12526).getNamespace();
                        if (CallChecker.beforeDeref(npe_invocation_var261, String.class, 290, 12524, 12541)) {
                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 291, 12608, 12610)) {
                                final String npe_invocation_var262 = CallChecker.isCalled(cap, BundleCapability.class, 291, 12608, 12610).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var262, String.class, 291, 12608, 12625)) {
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 292, 12713, 12715)) {
                                        final Map<String, Object> npe_invocation_var263 = CallChecker.isCalled(cap, BundleCapability.class, 292, 12713, 12715).getAttributes();
                                        if (CallChecker.beforeDeref(npe_invocation_var263, Map.class, 292, 12713, 12731)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var263, Map.class, 292, 12713, 12731).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 292, 12713, 12798)) {
                                                if (CallChecker.beforeDeref(imports, Set.class, 292, 12696, 12702)) {
                                                    imports = CallChecker.beforeCalled(imports, Set.class, 292, 12696, 12702);
                                                    if ((!(CallChecker.isCalled(npe_invocation_var261, String.class, 290, 12524, 12541).equals(BundleRevision.PACKAGE_NAMESPACE))) || ((CallChecker.isCalled(npe_invocation_var262, String.class, 291, 12608, 12625).equals(BundleRevision.PACKAGE_NAMESPACE)) && (!(CallChecker.isCalled(imports, Set.class, 292, 12696, 12702).contains(CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var263, Map.class, 292, 12713, 12731).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 292, 12713, 12798).toString()))))) {
                                                        String effective = CallChecker.init(String.class);
                                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 297, 13051, 13053)) {
                                                            final Map<String, String> npe_invocation_var264 = CallChecker.isCalled(cap, BundleCapability.class, 297, 13051, 13053).getDirectives();
                                                            if (CallChecker.beforeDeref(npe_invocation_var264, Map.class, 297, 13051, 13069)) {
                                                                effective = CallChecker.isCalled(npe_invocation_var264, Map.class, 297, 13051, 13069).get(Constants.EFFECTIVE_DIRECTIVE);
                                                                CallChecker.varAssign(effective, "effective", 297, 13051, 13053);
                                                            }
                                                        }
                                                        if ((effective == null) || (effective.equals(Constants.EFFECTIVE_RESOLVE))) {
                                                            if (CallChecker.beforeDeref(capList, List.class, 300, 13249, 13255)) {
                                                                capList = CallChecker.beforeCalled(capList, List.class, 300, 13249, 13255);
                                                                CallChecker.isCalled(capList, List.class, 300, 13249, 13255).add(cap);
                                                            }
                                                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 301, 13295, 13297)) {
                                                                final String npe_invocation_var265 = CallChecker.isCalled(cap, BundleCapability.class, 301, 13295, 13297).getNamespace();
                                                                if (CallChecker.beforeDeref(npe_invocation_var265, String.class, 301, 13295, 13312)) {
                                                                    if (CallChecker.isCalled(npe_invocation_var265, String.class, 301, 13295, 13312).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                                                        List<List<String>> filters = CallChecker.varInit(BundleWiringImpl.parsePkgFilters(cap, Constants.INCLUDE_DIRECTIVE), "filters", 303, 13410, 13520);
                                                                        if (filters != null) {
                                                                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 308, 13701, 13703)) {
                                                                                final Map<String, Object> npe_invocation_var266 = CallChecker.isCalled(cap, BundleCapability.class, 308, 13701, 13703).getAttributes();
                                                                                if (CallChecker.beforeDeref(npe_invocation_var266, Map.class, 308, 13701, 13719)) {
                                                                                    if (CallChecker.beforeDeref(includedPkgFilters, Map.class, 307, 13633, 13650)) {
                                                                                        includedPkgFilters = CallChecker.beforeCalled(includedPkgFilters, Map.class, 307, 13633, 13650);
                                                                                        CallChecker.isCalled(includedPkgFilters, Map.class, 307, 13633, 13650).put(((String) (CallChecker.isCalled(npe_invocation_var266, Map.class, 308, 13701, 13719).get(BundleRevision.PACKAGE_NAMESPACE))), filters);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        filters = BundleWiringImpl.parsePkgFilters(cap, Constants.EXCLUDE_DIRECTIVE);
                                                                        CallChecker.varAssign(filters, "filters", 311, 13864, 13923);
                                                                        if (filters != null) {
                                                                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 315, 14104, 14106)) {
                                                                                final Map<String, Object> npe_invocation_var267 = CallChecker.isCalled(cap, BundleCapability.class, 315, 14104, 14106).getAttributes();
                                                                                if (CallChecker.beforeDeref(npe_invocation_var267, Map.class, 315, 14104, 14122)) {
                                                                                    if (CallChecker.beforeDeref(excludedPkgFilters, Map.class, 314, 14036, 14053)) {
                                                                                        excludedPkgFilters = CallChecker.beforeCalled(excludedPkgFilters, Map.class, 314, 14036, 14053);
                                                                                        CallChecker.isCalled(excludedPkgFilters, Map.class, 314, 14036, 14053).put(((String) (CallChecker.isCalled(npe_invocation_var267, Map.class, 315, 14104, 14122).get(BundleRevision.PACKAGE_NAMESPACE))), filters);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
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
                if ((m_fragments) != null) {
                    for (BundleRevision fragment : m_fragments) {
                        for (BundleCapability cap : CallChecker.isCalled(fragment, BundleRevision.class, 326, 14496, 14503).getDeclaredCapabilities(null)) {
                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 328, 14630, 14632)) {
                                if (CallChecker.beforeDeref(IdentityNamespace.IDENTITY_NAMESPACE, String.class, 328, 14586, 14621)) {
                                    if (CallChecker.isCalled(IdentityNamespace.IDENTITY_NAMESPACE, String.class, 328, 14586, 14621).equals(CallChecker.isCalled(cap, BundleCapability.class, 328, 14630, 14632).getNamespace())) {
                                        continue;
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 333, 14853, 14855)) {
                                final String npe_invocation_var268 = CallChecker.isCalled(cap, BundleCapability.class, 333, 14853, 14855).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var268, String.class, 333, 14853, 14870)) {
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 334, 14945, 14947)) {
                                        final String npe_invocation_var269 = CallChecker.isCalled(cap, BundleCapability.class, 334, 14945, 14947).getNamespace();
                                        if (CallChecker.beforeDeref(npe_invocation_var269, String.class, 334, 14945, 14962)) {
                                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 335, 15058, 15060)) {
                                                final Map<String, Object> npe_invocation_var270 = CallChecker.isCalled(cap, BundleCapability.class, 335, 15058, 15060).getAttributes();
                                                if (CallChecker.beforeDeref(npe_invocation_var270, Map.class, 335, 15058, 15076)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var270, Map.class, 335, 15058, 15076).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 335, 15058, 15151)) {
                                                        if (CallChecker.beforeDeref(imports, Set.class, 335, 15041, 15047)) {
                                                            imports = CallChecker.beforeCalled(imports, Set.class, 335, 15041, 15047);
                                                            if ((!(CallChecker.isCalled(npe_invocation_var268, String.class, 333, 14853, 14870).equals(BundleRevision.PACKAGE_NAMESPACE))) || ((CallChecker.isCalled(npe_invocation_var269, String.class, 334, 14945, 14962).equals(BundleRevision.PACKAGE_NAMESPACE)) && (!(CallChecker.isCalled(imports, Set.class, 335, 15041, 15047).contains(CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var270, Map.class, 335, 15058, 15076).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 335, 15058, 15151).toString()))))) {
                                                                String effective = CallChecker.init(String.class);
                                                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 340, 15420, 15422)) {
                                                                    final Map<String, String> npe_invocation_var271 = CallChecker.isCalled(cap, BundleCapability.class, 340, 15420, 15422).getDirectives();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var271, Map.class, 340, 15420, 15438)) {
                                                                        effective = CallChecker.isCalled(npe_invocation_var271, Map.class, 340, 15420, 15438).get(Constants.EFFECTIVE_DIRECTIVE);
                                                                        CallChecker.varAssign(effective, "effective", 340, 15420, 15422);
                                                                    }
                                                                }
                                                                if ((effective == null) || (effective.equals(Constants.EFFECTIVE_RESOLVE))) {
                                                                    if (CallChecker.beforeDeref(capList, List.class, 343, 15642, 15648)) {
                                                                        capList = CallChecker.beforeCalled(capList, List.class, 343, 15642, 15648);
                                                                        CallChecker.isCalled(capList, List.class, 343, 15642, 15648).add(cap);
                                                                    }
                                                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 344, 15696, 15698)) {
                                                                        final String npe_invocation_var272 = CallChecker.isCalled(cap, BundleCapability.class, 344, 15696, 15698).getNamespace();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var272, String.class, 344, 15696, 15713)) {
                                                                            if (CallChecker.isCalled(npe_invocation_var272, String.class, 344, 15696, 15713).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                                                                List<List<String>> filters = CallChecker.varInit(BundleWiringImpl.parsePkgFilters(cap, Constants.INCLUDE_DIRECTIVE), "filters", 347, 15864, 16027);
                                                                                if (filters != null) {
                                                                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 353, 16240, 16242)) {
                                                                                        final Map<String, Object> npe_invocation_var273 = CallChecker.isCalled(cap, BundleCapability.class, 353, 16240, 16242).getAttributes();
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var273, Map.class, 353, 16240, 16258)) {
                                                                                            if (CallChecker.beforeDeref(includedPkgFilters, Map.class, 352, 16164, 16181)) {
                                                                                                includedPkgFilters = CallChecker.beforeCalled(includedPkgFilters, Map.class, 352, 16164, 16181);
                                                                                                CallChecker.isCalled(includedPkgFilters, Map.class, 352, 16164, 16181).put(((String) (CallChecker.isCalled(npe_invocation_var273, Map.class, 353, 16240, 16258).get(BundleRevision.PACKAGE_NAMESPACE))), filters);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                filters = BundleWiringImpl.parsePkgFilters(cap, Constants.EXCLUDE_DIRECTIVE);
                                                                                CallChecker.varAssign(filters, "filters", 357, 16476, 16535);
                                                                                if (filters != null) {
                                                                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 361, 16748, 16750)) {
                                                                                        final Map<String, Object> npe_invocation_var274 = CallChecker.isCalled(cap, BundleCapability.class, 361, 16748, 16750).getAttributes();
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var274, Map.class, 361, 16748, 16766)) {
                                                                                            if (CallChecker.beforeDeref(excludedPkgFilters, Map.class, 360, 16672, 16689)) {
                                                                                                excludedPkgFilters = CallChecker.beforeCalled(excludedPkgFilters, Map.class, 360, 16672, 16689);
                                                                                                CallChecker.isCalled(excludedPkgFilters, Map.class, 360, 16672, 16689).put(((String) (CallChecker.isCalled(npe_invocation_var274, Map.class, 361, 16748, 16766).get(BundleRevision.PACKAGE_NAMESPACE))), filters);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
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
            }
            if ((System.getSecurityManager()) != null) {
                capList = CallChecker.beforeCalled(capList, List.class, 375, 17213, 17219);
                for (Iterator<BundleCapability> iter = CallChecker.isCalled(capList, List.class, 375, 17213, 17219).iterator(); CallChecker.isCalled(iter, Iterator.class, 375, 17232, 17235).hasNext();) {
                    BundleCapability cap = CallChecker.init(BundleCapability.class);
                    if (CallChecker.beforeDeref(iter, Iterator.class, 377, 17302, 17305)) {
                        cap = CallChecker.isCalled(iter, Iterator.class, 377, 17302, 17305).next();
                        CallChecker.varAssign(cap, "cap", 377, 17302, 17305);
                    }
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 378, 17335, 17337)) {
                        cap = CallChecker.beforeCalled(cap, BundleCapability.class, 378, 17335, 17337);
                        final String npe_invocation_var275 = CallChecker.isCalled(cap, BundleCapability.class, 378, 17335, 17337).getNamespace();
                        if (CallChecker.beforeDeref(npe_invocation_var275, String.class, 378, 17335, 17352)) {
                            if (CallChecker.isCalled(npe_invocation_var275, String.class, 378, 17335, 17352).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 380, 17487, 17489)) {
                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 380, 17487, 17489);
                                    final BundleRevisionImpl npe_invocation_var276 = ((BundleRevisionImpl) (CallChecker.isCalled(cap, BundleCapability.class, 380, 17487, 17489).getRevision()));
                                    if (CallChecker.beforeDeref(npe_invocation_var276, BundleRevisionImpl.class, 380, 17487, 17503)) {
                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 381, 17599, 17601)) {
                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 381, 17599, 17601);
                                            final Map<String, Object> npe_invocation_var277 = CallChecker.isCalled(cap, BundleCapability.class, 381, 17599, 17601).getAttributes();
                                            if (CallChecker.beforeDeref(npe_invocation_var277, Map.class, 381, 17599, 17617)) {
                                                final BundleProtectionDomain npe_invocation_var278 = ((BundleProtectionDomain) (CallChecker.isCalled(npe_invocation_var276, BundleRevisionImpl.class, 380, 17487, 17503).getProtectionDomain()));
                                                if (CallChecker.beforeDeref(npe_invocation_var278, BundleProtectionDomain.class, 380, 17465, 17526)) {
                                                    if (!(CallChecker.isCalled(npe_invocation_var278, BundleProtectionDomain.class, 380, 17465, 17526).impliesDirect(new PackagePermission(((String) (CallChecker.isCalled(npe_invocation_var277, Map.class, 381, 17599, 17617).get(BundleRevision.PACKAGE_NAMESPACE))), PackagePermission.EXPORTONLY)))) {
                                                        if (CallChecker.beforeDeref(iter, Iterator.class, 383, 17736, 17739)) {
                                                            CallChecker.isCalled(iter, Iterator.class, 383, 17736, 17739).remove();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }else
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 386, 17817, 17819)) {
                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 386, 17817, 17819);
                                    final String npe_invocation_var279 = CallChecker.isCalled(cap, BundleCapability.class, 386, 17817, 17819).getNamespace();
                                    if (CallChecker.beforeDeref(npe_invocation_var279, String.class, 386, 17817, 17834)) {
                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 386, 17878, 17880)) {
                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 386, 17878, 17880);
                                            final String npe_invocation_var280 = CallChecker.isCalled(cap, BundleCapability.class, 386, 17878, 17880).getNamespace();
                                            if (CallChecker.beforeDeref(npe_invocation_var280, String.class, 386, 17878, 17895)) {
                                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 387, 17961, 17963)) {
                                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 387, 17961, 17963);
                                                    final String npe_invocation_var281 = CallChecker.isCalled(cap, BundleCapability.class, 387, 17961, 17963).getNamespace();
                                                    if (CallChecker.beforeDeref(npe_invocation_var281, String.class, 387, 17961, 17978)) {
                                                        if (((!(CallChecker.isCalled(npe_invocation_var279, String.class, 386, 17817, 17834).equals(BundleRevision.HOST_NAMESPACE))) && (!(CallChecker.isCalled(npe_invocation_var280, String.class, 386, 17878, 17895).equals(BundleRevision.BUNDLE_NAMESPACE)))) && (!(CallChecker.isCalled(npe_invocation_var281, String.class, 387, 17961, 17978).equals("osgi.ee")))) {
                                                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 389, 18090, 18092)) {
                                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 389, 18090, 18092);
                                                                final BundleRevisionImpl npe_invocation_var282 = ((BundleRevisionImpl) (CallChecker.isCalled(cap, BundleCapability.class, 389, 18090, 18092).getRevision()));
                                                                if (CallChecker.beforeDeref(npe_invocation_var282, BundleRevisionImpl.class, 389, 18090, 18106)) {
                                                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 390, 18196, 18198)) {
                                                                        final BundleProtectionDomain npe_invocation_var283 = ((BundleProtectionDomain) (CallChecker.isCalled(npe_invocation_var282, BundleRevisionImpl.class, 389, 18090, 18106).getProtectionDomain()));
                                                                        if (CallChecker.beforeDeref(npe_invocation_var283, BundleProtectionDomain.class, 389, 18068, 18129)) {
                                                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 390, 18196, 18198);
                                                                            if (!(CallChecker.isCalled(npe_invocation_var283, BundleProtectionDomain.class, 389, 18068, 18129).impliesDirect(new org.osgi.framework.CapabilityPermission(CallChecker.isCalled(cap, BundleCapability.class, 390, 18196, 18198).getNamespace(), org.osgi.framework.CapabilityPermission.PROVIDE)))) {
                                                                                if (CallChecker.beforeDeref(iter, Iterator.class, 392, 18294, 18297)) {
                                                                                    CallChecker.isCalled(iter, Iterator.class, 392, 18294, 18297).remove();
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
                                    }
                                }
                            
                        }
                    }
                }
            }
            m_resolvedCaps = ImmutableList.newInstance(capList);
            CallChecker.varAssign(this.m_resolvedCaps, "this.m_resolvedCaps", 398, 18382, 18433);
            includedPkgFilters = CallChecker.beforeCalled(includedPkgFilters, Map.class, 399, 18467, 18484);
            if (CallChecker.isCalled(includedPkgFilters, Map.class, 399, 18467, 18484).isEmpty()) {
                m_includedPkgFilters = Collections.EMPTY_MAP;
                CallChecker.varAssign(this.m_includedPkgFilters, "this.m_includedPkgFilters", 399, 18443, 18553);
            }else {
                m_includedPkgFilters = includedPkgFilters;
                CallChecker.varAssign(this.m_includedPkgFilters, "this.m_includedPkgFilters", 399, 18443, 18553);
            }
            excludedPkgFilters = CallChecker.beforeCalled(excludedPkgFilters, Map.class, 401, 18587, 18604);
            if (CallChecker.isCalled(excludedPkgFilters, Map.class, 401, 18587, 18604).isEmpty()) {
                m_excludedPkgFilters = Collections.EMPTY_MAP;
                CallChecker.varAssign(this.m_excludedPkgFilters, "this.m_excludedPkgFilters", 401, 18563, 18673);
            }else {
                m_excludedPkgFilters = excludedPkgFilters;
                CallChecker.varAssign(this.m_excludedPkgFilters, "this.m_excludedPkgFilters", 401, 18563, 18673);
            }
            List<NativeLibrary> libList = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 404, 18715, 18724)) {
                if ((CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 404, 18715, 18724).getDeclaredNativeLibraries()) == null) {
                    libList = new ArrayList<NativeLibrary>();
                    CallChecker.varAssign(libList, "libList", 404, 18714, 18891);
                }else {
                    if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 406, 18852, 18861)) {
                        libList = new ArrayList<NativeLibrary>(CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 406, 18852, 18861).getDeclaredNativeLibraries());
                        CallChecker.varAssign(libList, "libList", 404, 18714, 18891);
                    }
                }
            }
            for (int fragIdx = 0; ((m_fragments) != null) && (fragIdx < (CallChecker.isCalled(m_fragments, List.class, 408, 18972, 18982).size())); fragIdx++) {
                List<NativeLibrary> libs = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_fragments, List.class, 412, 19103, 19113).get(fragIdx), BundleRevision.class, 412, 19103, 19126)) {
                    libs = CallChecker.isCalled(((BundleRevisionImpl) (m_fragments.get(fragIdx))), BundleRevisionImpl.class, 412, 19103, 19126).getDeclaredNativeLibraries();
                    CallChecker.varAssign(libs, "libs", 412, 19103, 19126);
                }
                libs = CallChecker.beforeCalled(libs, List.class, 415, 19257, 19260);
                for (int reqIdx = 0; (libs != null) && (reqIdx < (CallChecker.isCalled(libs, List.class, 415, 19257, 19260).size())); reqIdx++) {
                    if (CallChecker.beforeDeref(libList, List.class, 418, 19327, 19333)) {
                        libList = CallChecker.beforeCalled(libList, List.class, 418, 19327, 19333);
                        CallChecker.isCalled(libList, List.class, 418, 19327, 19333).add(libs.get(reqIdx));
                    }
                }
            }
            libList = CallChecker.beforeCalled(libList, List.class, 424, 19630, 19636);
            if (CallChecker.isCalled(libList, List.class, 424, 19630, 19636).isEmpty()) {
                m_resolvedNativeLibs = null;
                CallChecker.varAssign(this.m_resolvedNativeLibs, "this.m_resolvedNativeLibs", 424, 19606, 19716);
            }else {
                m_resolvedNativeLibs = ImmutableList.newInstance(libList);
                CallChecker.varAssign(this.m_resolvedNativeLibs, "this.m_resolvedNativeLibs", 424, 19606, 19716);
            }
            ClassLoader bootLoader = CallChecker.varInit(BundleWiringImpl.m_defBootClassLoader, "bootLoader", 428, 19727, 19772);
            if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 429, 19786, 19793)) {
                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 429, 19786, 19793);
                final Bundle npe_invocation_var284 = CallChecker.isCalled(revision, BundleRevisionImpl.class, 429, 19786, 19793).getBundle();
                if (CallChecker.beforeDeref(npe_invocation_var284, Bundle.class, 429, 19786, 19805)) {
                    if ((CallChecker.isCalled(npe_invocation_var284, Bundle.class, 429, 19786, 19805).getBundleId()) != 0) {
                        Object map = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(m_configMap, Map.class, 431, 19862, 19872)) {
                            map = CallChecker.isCalled(m_configMap, Map.class, 431, 19862, 19872).get(FelixConstants.BOOT_CLASSLOADERS_PROP);
                            CallChecker.varAssign(map, "map", 431, 19862, 19872);
                        }
                        if (map instanceof Map) {
                            Object l = CallChecker.init(Object.class);
                            if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 434, 20011, 20020)) {
                                if (CallChecker.beforeDeref(map, Object.class, 434, 20002, 20004)) {
                                    map = CallChecker.beforeCalled(map, Map.class, 434, 20002, 20004);
                                    l = CallChecker.isCalled(((Map) (map)), Map.class, 434, 20002, 20004).get(CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 434, 20011, 20020).getBundle());
                                    CallChecker.varAssign(l, "l", 434, 20011, 20020);
                                }
                            }
                            if (l instanceof ClassLoader) {
                                bootLoader = ((ClassLoader) (l));
                                CallChecker.varAssign(bootLoader, "bootLoader", 437, 20120, 20148);
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            m_bootClassLoader = bootLoader;
            CallChecker.varAssign(this.m_bootClassLoader, "this.m_bootClassLoader", 441, 20200, 20230);
            m_implicitBootDelegation = ((CallChecker.isCalled(m_configMap, Map.class, 444, 20281, 20291).get(FelixConstants.IMPLICIT_BOOT_DELEGATION_PROP)) == null) || (CallChecker.isCalled(Boolean.valueOf(((String) (CallChecker.isCalled(m_configMap, Map.class, 446, 20409, 20419).get(FelixConstants.IMPLICIT_BOOT_DELEGATION_PROP)))), Boolean.class, 445, 20367, 20491).booleanValue());
            CallChecker.varAssign(this.m_implicitBootDelegation, "this.m_implicitBootDelegation", 443, 20241, 20507);
            if ((CallChecker.isCalled(m_configMap, Map.class, 450, 20548, 20558).get(FelixConstants.USE_LOCALURLS_PROP)) == null) {
                m_useLocalURLs = false;
                CallChecker.varAssign(this.m_useLocalURLs, "this.m_useLocalURLs", 449, 20518, 20638);
            }else {
                m_useLocalURLs = true;
                CallChecker.varAssign(this.m_useLocalURLs, "this.m_useLocalURLs", 449, 20518, 20638);
            }
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }

    private static List<List<String>> parsePkgFilters(BundleCapability cap, String filtername) {
        MethodContext _bcornu_methode_context894 = new MethodContext(List.class);
        try {
            CallChecker.varInit(filtername, "filtername", 454, 20651, 21369);
            CallChecker.varInit(cap, "cap", 454, 20651, 21369);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 454, 20651, 21369);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 454, 20651, 21369);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 454, 20651, 21369);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 454, 20651, 21369);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 454, 20651, 21369);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 454, 20651, 21369);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 454, 20651, 21369);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 454, 20651, 21369);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 454, 20651, 21369);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 454, 20651, 21369);
            List<List<String>> filters = CallChecker.varInit(null, "filters", 456, 20756, 20789);
            String include = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(cap, BundleCapability.class, 457, 20816, 20818)) {
                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 457, 20816, 20818);
                final Map<String, String> npe_invocation_var285 = CallChecker.isCalled(cap, BundleCapability.class, 457, 20816, 20818).getDirectives();
                if (CallChecker.beforeDeref(npe_invocation_var285, Map.class, 457, 20816, 20834)) {
                    include = CallChecker.isCalled(npe_invocation_var285, Map.class, 457, 20816, 20834).get(filtername);
                    CallChecker.varAssign(include, "include", 457, 20816, 20818);
                }
            }
            if (include != null) {
                List<String> filterStrings = CallChecker.varInit(ManifestParser.parseDelimitedString(include, ","), "filterStrings", 460, 20904, 20982);
                if (CallChecker.beforeDeref(filterStrings, List.class, 461, 21034, 21046)) {
                    filterStrings = CallChecker.beforeCalled(filterStrings, List.class, 461, 21034, 21046);
                    filters = new ArrayList<List<String>>(CallChecker.isCalled(filterStrings, List.class, 461, 21034, 21046).size());
                    CallChecker.varAssign(filters, "filters", 461, 20996, 21055);
                }
                filterStrings = CallChecker.beforeCalled(filterStrings, List.class, 463, 21106, 21118);
                for (int filterIdx = 0; filterIdx < (CallChecker.isCalled(filterStrings, List.class, 463, 21106, 21118).size()); filterIdx++) {
                    List<String> substrings = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(filterStrings, List.class, 466, 21245, 21257)) {
                        filterStrings = CallChecker.beforeCalled(filterStrings, List.class, 466, 21245, 21257);
                        substrings = SimpleFilter.parseSubstring(CallChecker.isCalled(filterStrings, List.class, 466, 21245, 21257).get(filterIdx));
                        CallChecker.varAssign(substrings, "substrings", 466, 21245, 21257);
                    }
                    if (CallChecker.beforeDeref(filters, List.class, 467, 21292, 21298)) {
                        filters = CallChecker.beforeCalled(filters, List.class, 467, 21292, 21298);
                        CallChecker.isCalled(filters, List.class, 467, 21292, 21298).add(substrings);
                    }
                }
            }
            return filters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<List<String>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context894.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context895 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 474, 21376, 21475);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 474, 21376, 21475);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 474, 21376, 21475);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 474, 21376, 21475);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 474, 21376, 21475);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 474, 21376, 21475);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 474, 21376, 21475);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 474, 21376, 21475);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 474, 21376, 21475);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 474, 21376, 21475);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 474, 21376, 21475);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 474, 21376, 21475);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 474, 21376, 21475);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 474, 21376, 21475);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 474, 21376, 21475);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 474, 21376, 21475);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 474, 21376, 21475);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 474, 21376, 21475);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 474, 21376, 21475);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 474, 21376, 21475);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 474, 21376, 21475);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 474, 21376, 21475);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 474, 21376, 21475);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 474, 21376, 21475);
            CallChecker.varInit(this.m_wires, "m_wires", 474, 21376, 21475);
            CallChecker.varInit(this.m_fragments, "m_fragments", 474, 21376, 21475);
            CallChecker.varInit(this.m_revision, "m_revision", 474, 21376, 21475);
            CallChecker.varInit(this.m_resolver, "m_resolver", 474, 21376, 21475);
            CallChecker.varInit(this.m_configMap, "m_configMap", 474, 21376, 21475);
            CallChecker.varInit(this.m_logger, "m_logger", 474, 21376, 21475);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 474, 21376, 21475);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 474, 21376, 21475);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 474, 21376, 21475);
            if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 476, 21436, 21445)) {
                final Bundle npe_invocation_var286 = CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 476, 21436, 21445).getBundle();
                if (CallChecker.beforeDeref(npe_invocation_var286, Bundle.class, 476, 21436, 21457)) {
                    return CallChecker.isCalled(npe_invocation_var286, Bundle.class, 476, 21436, 21457).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context895.methodEnd();
        }
    }

    public synchronized void dispose() {
        MethodContext _bcornu_methode_context896 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 479, 21482, 21762);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 479, 21482, 21762);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 479, 21482, 21762);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 479, 21482, 21762);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 479, 21482, 21762);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 479, 21482, 21762);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 479, 21482, 21762);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 479, 21482, 21762);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 479, 21482, 21762);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 479, 21482, 21762);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 479, 21482, 21762);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 479, 21482, 21762);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 479, 21482, 21762);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 479, 21482, 21762);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 479, 21482, 21762);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 479, 21482, 21762);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 479, 21482, 21762);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 479, 21482, 21762);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 479, 21482, 21762);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 479, 21482, 21762);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 479, 21482, 21762);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 479, 21482, 21762);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 479, 21482, 21762);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 479, 21482, 21762);
            CallChecker.varInit(this.m_wires, "m_wires", 479, 21482, 21762);
            CallChecker.varInit(this.m_fragments, "m_fragments", 479, 21482, 21762);
            CallChecker.varInit(this.m_revision, "m_revision", 479, 21482, 21762);
            CallChecker.varInit(this.m_resolver, "m_resolver", 479, 21482, 21762);
            CallChecker.varInit(this.m_configMap, "m_configMap", 479, 21482, 21762);
            CallChecker.varInit(this.m_logger, "m_logger", 479, 21482, 21762);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 479, 21482, 21762);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 479, 21482, 21762);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 479, 21482, 21762);
            if ((m_fragmentContents) != null) {
                for (Content content : m_fragmentContents) {
                    if (CallChecker.beforeDeref(content, Content.class, 485, 21658, 21664)) {
                        CallChecker.isCalled(content, Content.class, 485, 21658, 21664).close();
                    }
                }
            }
            m_classLoader = null;
            CallChecker.varAssign(this.m_classLoader, "this.m_classLoader", 488, 21707, 21727);
            m_isDisposed = true;
            CallChecker.varAssign(this.m_isDisposed, "this.m_isDisposed", 489, 21737, 21756);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context896.methodEnd();
        }
    }

    public boolean hasPackageSource(String pkgName) {
        MethodContext _bcornu_methode_context897 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 494, 21765, 22065);
            CallChecker.varInit(pkgName, "pkgName", 494, 21765, 22065);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 494, 21765, 22065);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 494, 21765, 22065);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 494, 21765, 22065);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 494, 21765, 22065);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 494, 21765, 22065);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 494, 21765, 22065);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 494, 21765, 22065);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 494, 21765, 22065);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 494, 21765, 22065);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 494, 21765, 22065);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 494, 21765, 22065);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 494, 21765, 22065);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 494, 21765, 22065);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 494, 21765, 22065);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 494, 21765, 22065);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 494, 21765, 22065);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 494, 21765, 22065);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 494, 21765, 22065);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 494, 21765, 22065);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 494, 21765, 22065);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 494, 21765, 22065);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 494, 21765, 22065);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 494, 21765, 22065);
            CallChecker.varInit(this.m_wires, "m_wires", 494, 21765, 22065);
            CallChecker.varInit(this.m_fragments, "m_fragments", 494, 21765, 22065);
            CallChecker.varInit(this.m_revision, "m_revision", 494, 21765, 22065);
            CallChecker.varInit(this.m_resolver, "m_resolver", 494, 21765, 22065);
            CallChecker.varInit(this.m_configMap, "m_configMap", 494, 21765, 22065);
            CallChecker.varInit(this.m_logger, "m_logger", 494, 21765, 22065);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 494, 21765, 22065);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 494, 21765, 22065);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 494, 21765, 22065);
            m_importedPkgs = CallChecker.beforeCalled(m_importedPkgs, Map.class, 496, 21984, 21997);
            return (CallChecker.isCalled(m_importedPkgs, Map.class, 496, 21984, 21997).containsKey(pkgName)) || (CallChecker.isCalled(m_requiredPkgs, Map.class, 496, 22023, 22036).containsKey(pkgName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context897.methodEnd();
        }
    }

    public BundleRevision getImportedPackageSource(String pkgName) {
        MethodContext _bcornu_methode_context898 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 501, 22068, 22306);
            CallChecker.varInit(pkgName, "pkgName", 501, 22068, 22306);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 501, 22068, 22306);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 501, 22068, 22306);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 501, 22068, 22306);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 501, 22068, 22306);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 501, 22068, 22306);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 501, 22068, 22306);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 501, 22068, 22306);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 501, 22068, 22306);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 501, 22068, 22306);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 501, 22068, 22306);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 501, 22068, 22306);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 501, 22068, 22306);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 501, 22068, 22306);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 501, 22068, 22306);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 501, 22068, 22306);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 501, 22068, 22306);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 501, 22068, 22306);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 501, 22068, 22306);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 501, 22068, 22306);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 501, 22068, 22306);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 501, 22068, 22306);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 501, 22068, 22306);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 501, 22068, 22306);
            CallChecker.varInit(this.m_wires, "m_wires", 501, 22068, 22306);
            CallChecker.varInit(this.m_fragments, "m_fragments", 501, 22068, 22306);
            CallChecker.varInit(this.m_revision, "m_revision", 501, 22068, 22306);
            CallChecker.varInit(this.m_resolver, "m_resolver", 501, 22068, 22306);
            CallChecker.varInit(this.m_configMap, "m_configMap", 501, 22068, 22306);
            CallChecker.varInit(this.m_logger, "m_logger", 501, 22068, 22306);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 501, 22068, 22306);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 501, 22068, 22306);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 501, 22068, 22306);
            if (CallChecker.beforeDeref(m_importedPkgs, Map.class, 503, 22273, 22286)) {
                m_importedPkgs = CallChecker.beforeCalled(m_importedPkgs, Map.class, 503, 22273, 22286);
                return CallChecker.isCalled(m_importedPkgs, Map.class, 503, 22273, 22286).get(pkgName);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context898.methodEnd();
        }
    }

    List<BundleRevision> getFragments() {
        MethodContext _bcornu_methode_context899 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 506, 22313, 22387);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 506, 22313, 22387);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 506, 22313, 22387);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 506, 22313, 22387);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 506, 22313, 22387);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 506, 22313, 22387);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 506, 22313, 22387);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 506, 22313, 22387);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 506, 22313, 22387);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 506, 22313, 22387);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 506, 22313, 22387);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 506, 22313, 22387);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 506, 22313, 22387);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 506, 22313, 22387);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 506, 22313, 22387);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 506, 22313, 22387);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 506, 22313, 22387);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 506, 22313, 22387);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 506, 22313, 22387);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 506, 22313, 22387);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 506, 22313, 22387);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 506, 22313, 22387);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 506, 22313, 22387);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 506, 22313, 22387);
            CallChecker.varInit(this.m_wires, "m_wires", 506, 22313, 22387);
            CallChecker.varInit(this.m_fragments, "m_fragments", 506, 22313, 22387);
            CallChecker.varInit(this.m_revision, "m_revision", 506, 22313, 22387);
            CallChecker.varInit(this.m_resolver, "m_resolver", 506, 22313, 22387);
            CallChecker.varInit(this.m_configMap, "m_configMap", 506, 22313, 22387);
            CallChecker.varInit(this.m_logger, "m_logger", 506, 22313, 22387);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 506, 22313, 22387);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 506, 22313, 22387);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 506, 22313, 22387);
            return m_fragments;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context899.methodEnd();
        }
    }

    List<Content> getFragmentContents() {
        MethodContext _bcornu_methode_context900 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 511, 22394, 22475);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 511, 22394, 22475);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 511, 22394, 22475);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 511, 22394, 22475);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 511, 22394, 22475);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 511, 22394, 22475);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 511, 22394, 22475);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 511, 22394, 22475);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 511, 22394, 22475);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 511, 22394, 22475);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 511, 22394, 22475);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 511, 22394, 22475);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 511, 22394, 22475);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 511, 22394, 22475);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 511, 22394, 22475);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 511, 22394, 22475);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 511, 22394, 22475);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 511, 22394, 22475);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 511, 22394, 22475);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 511, 22394, 22475);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 511, 22394, 22475);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 511, 22394, 22475);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 511, 22394, 22475);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 511, 22394, 22475);
            CallChecker.varInit(this.m_wires, "m_wires", 511, 22394, 22475);
            CallChecker.varInit(this.m_fragments, "m_fragments", 511, 22394, 22475);
            CallChecker.varInit(this.m_revision, "m_revision", 511, 22394, 22475);
            CallChecker.varInit(this.m_resolver, "m_resolver", 511, 22394, 22475);
            CallChecker.varInit(this.m_configMap, "m_configMap", 511, 22394, 22475);
            CallChecker.varInit(this.m_logger, "m_logger", 511, 22394, 22475);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 511, 22394, 22475);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 511, 22394, 22475);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 511, 22394, 22475);
            return m_fragmentContents;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Content>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context900.methodEnd();
        }
    }

    public boolean isCurrent() {
        MethodContext _bcornu_methode_context901 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 516, 22482, 22660);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 516, 22482, 22660);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 516, 22482, 22660);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 516, 22482, 22660);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 516, 22482, 22660);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 516, 22482, 22660);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 516, 22482, 22660);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 516, 22482, 22660);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 516, 22482, 22660);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 516, 22482, 22660);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 516, 22482, 22660);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 516, 22482, 22660);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 516, 22482, 22660);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 516, 22482, 22660);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 516, 22482, 22660);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 516, 22482, 22660);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 516, 22482, 22660);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 516, 22482, 22660);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 516, 22482, 22660);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 516, 22482, 22660);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 516, 22482, 22660);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 516, 22482, 22660);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 516, 22482, 22660);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 516, 22482, 22660);
            CallChecker.varInit(this.m_wires, "m_wires", 516, 22482, 22660);
            CallChecker.varInit(this.m_fragments, "m_fragments", 516, 22482, 22660);
            CallChecker.varInit(this.m_revision, "m_revision", 516, 22482, 22660);
            CallChecker.varInit(this.m_resolver, "m_resolver", 516, 22482, 22660);
            CallChecker.varInit(this.m_configMap, "m_configMap", 516, 22482, 22660);
            CallChecker.varInit(this.m_logger, "m_logger", 516, 22482, 22660);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 516, 22482, 22660);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 516, 22482, 22660);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 516, 22482, 22660);
            final Bundle npe_invocation_var287 = getBundle();
            BundleRevision current = CallChecker.init(BundleRevision.class);
            if (CallChecker.beforeDeref(npe_invocation_var287, Bundle.class, 518, 22548, 22558)) {
                current = CallChecker.isCalled(npe_invocation_var287, Bundle.class, 518, 22548, 22558).adapt(BundleRevision.class);
                CallChecker.varAssign(current, "current", 518, 22548, 22558);
            }
            current = CallChecker.beforeCalled(current, BundleRevision.class, 519, 22626, 22632);
            return (current != null) && ((CallChecker.isCalled(current, BundleRevision.class, 519, 22626, 22632).getWiring()) == (this));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context901.methodEnd();
        }
    }

    public synchronized boolean isInUse() {
        MethodContext _bcornu_methode_context902 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 522, 22667, 22745);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 522, 22667, 22745);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 522, 22667, 22745);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 522, 22667, 22745);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 522, 22667, 22745);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 522, 22667, 22745);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 522, 22667, 22745);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 522, 22667, 22745);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 522, 22667, 22745);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 522, 22667, 22745);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 522, 22667, 22745);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 522, 22667, 22745);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 522, 22667, 22745);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 522, 22667, 22745);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 522, 22667, 22745);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 522, 22667, 22745);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 522, 22667, 22745);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 522, 22667, 22745);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 522, 22667, 22745);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 522, 22667, 22745);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 522, 22667, 22745);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 522, 22667, 22745);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 522, 22667, 22745);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 522, 22667, 22745);
            CallChecker.varInit(this.m_wires, "m_wires", 522, 22667, 22745);
            CallChecker.varInit(this.m_fragments, "m_fragments", 522, 22667, 22745);
            CallChecker.varInit(this.m_revision, "m_revision", 522, 22667, 22745);
            CallChecker.varInit(this.m_resolver, "m_resolver", 522, 22667, 22745);
            CallChecker.varInit(this.m_configMap, "m_configMap", 522, 22667, 22745);
            CallChecker.varInit(this.m_logger, "m_logger", 522, 22667, 22745);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 522, 22667, 22745);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 522, 22667, 22745);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 522, 22667, 22745);
            return !(m_isDisposed);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context902.methodEnd();
        }
    }

    public List<Capability> getResourceCapabilities(String namespace) {
        MethodContext _bcornu_methode_context903 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 527, 22752, 22908);
            CallChecker.varInit(namespace, "namespace", 527, 22752, 22908);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 527, 22752, 22908);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 527, 22752, 22908);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 527, 22752, 22908);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 527, 22752, 22908);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 527, 22752, 22908);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 527, 22752, 22908);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 527, 22752, 22908);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 527, 22752, 22908);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 527, 22752, 22908);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 527, 22752, 22908);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 527, 22752, 22908);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 527, 22752, 22908);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 527, 22752, 22908);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 527, 22752, 22908);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 527, 22752, 22908);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 527, 22752, 22908);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 527, 22752, 22908);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 527, 22752, 22908);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 527, 22752, 22908);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 527, 22752, 22908);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 527, 22752, 22908);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 527, 22752, 22908);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 527, 22752, 22908);
            CallChecker.varInit(this.m_wires, "m_wires", 527, 22752, 22908);
            CallChecker.varInit(this.m_fragments, "m_fragments", 527, 22752, 22908);
            CallChecker.varInit(this.m_revision, "m_revision", 527, 22752, 22908);
            CallChecker.varInit(this.m_resolver, "m_resolver", 527, 22752, 22908);
            CallChecker.varInit(this.m_configMap, "m_configMap", 527, 22752, 22908);
            CallChecker.varInit(this.m_logger, "m_logger", 527, 22752, 22908);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 527, 22752, 22908);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 527, 22752, 22908);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 527, 22752, 22908);
            return BundleRevisionImpl.asCapabilityList(getCapabilities(namespace));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context903.methodEnd();
        }
    }

    public List<BundleCapability> getCapabilities(String namespace) {
        MethodContext _bcornu_methode_context904 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 532, 22915, 23506);
            CallChecker.varInit(namespace, "namespace", 532, 22915, 23506);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 532, 22915, 23506);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 532, 22915, 23506);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 532, 22915, 23506);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 532, 22915, 23506);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 532, 22915, 23506);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 532, 22915, 23506);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 532, 22915, 23506);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 532, 22915, 23506);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 532, 22915, 23506);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 532, 22915, 23506);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 532, 22915, 23506);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 532, 22915, 23506);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 532, 22915, 23506);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 532, 22915, 23506);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 532, 22915, 23506);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 532, 22915, 23506);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 532, 22915, 23506);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 532, 22915, 23506);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 532, 22915, 23506);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 532, 22915, 23506);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 532, 22915, 23506);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 532, 22915, 23506);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 532, 22915, 23506);
            CallChecker.varInit(this.m_wires, "m_wires", 532, 22915, 23506);
            CallChecker.varInit(this.m_fragments, "m_fragments", 532, 22915, 23506);
            CallChecker.varInit(this.m_revision, "m_revision", 532, 22915, 23506);
            CallChecker.varInit(this.m_resolver, "m_resolver", 532, 22915, 23506);
            CallChecker.varInit(this.m_configMap, "m_configMap", 532, 22915, 23506);
            CallChecker.varInit(this.m_logger, "m_logger", 532, 22915, 23506);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 532, 22915, 23506);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 532, 22915, 23506);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 532, 22915, 23506);
            if (isInUse()) {
                List<BundleCapability> result = CallChecker.varInit(m_resolvedCaps, "result", 536, 23030, 23076);
                if (namespace != null) {
                    result = new ArrayList<BundleCapability>();
                    CallChecker.varAssign(result, "result", 539, 23143, 23185);
                    if (CallChecker.beforeDeref(m_resolvedCaps, List.class, 540, 23231, 23244)) {
                        for (BundleCapability cap : m_resolvedCaps) {
                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 542, 23289, 23291)) {
                                final String npe_invocation_var288 = CallChecker.isCalled(cap, BundleCapability.class, 542, 23289, 23291).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var288, String.class, 542, 23289, 23306)) {
                                    if (CallChecker.isCalled(npe_invocation_var288, String.class, 542, 23289, 23306).equals(namespace)) {
                                        if (CallChecker.beforeDeref(result, List.class, 544, 23373, 23378)) {
                                            result = CallChecker.beforeCalled(result, List.class, 544, 23373, 23378);
                                            CallChecker.isCalled(result, List.class, 544, 23373, 23378).add(cap);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return result;
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context904.methodEnd();
        }
    }

    public List<Requirement> getResourceRequirements(String namespace) {
        MethodContext _bcornu_methode_context905 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 553, 23513, 23671);
            CallChecker.varInit(namespace, "namespace", 553, 23513, 23671);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 553, 23513, 23671);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 553, 23513, 23671);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 553, 23513, 23671);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 553, 23513, 23671);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 553, 23513, 23671);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 553, 23513, 23671);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 553, 23513, 23671);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 553, 23513, 23671);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 553, 23513, 23671);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 553, 23513, 23671);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 553, 23513, 23671);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 553, 23513, 23671);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 553, 23513, 23671);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 553, 23513, 23671);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 553, 23513, 23671);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 553, 23513, 23671);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 553, 23513, 23671);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 553, 23513, 23671);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 553, 23513, 23671);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 553, 23513, 23671);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 553, 23513, 23671);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 553, 23513, 23671);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 553, 23513, 23671);
            CallChecker.varInit(this.m_wires, "m_wires", 553, 23513, 23671);
            CallChecker.varInit(this.m_fragments, "m_fragments", 553, 23513, 23671);
            CallChecker.varInit(this.m_revision, "m_revision", 553, 23513, 23671);
            CallChecker.varInit(this.m_resolver, "m_resolver", 553, 23513, 23671);
            CallChecker.varInit(this.m_configMap, "m_configMap", 553, 23513, 23671);
            CallChecker.varInit(this.m_logger, "m_logger", 553, 23513, 23671);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 553, 23513, 23671);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 553, 23513, 23671);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 553, 23513, 23671);
            return BundleRevisionImpl.asRequirementList(getRequirements(namespace));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Requirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context905.methodEnd();
        }
    }

    public List<BundleRequirement> getRequirements(String namespace) {
        MethodContext _bcornu_methode_context906 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 558, 23678, 24622);
            CallChecker.varInit(namespace, "namespace", 558, 23678, 24622);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 558, 23678, 24622);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 558, 23678, 24622);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 558, 23678, 24622);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 558, 23678, 24622);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 558, 23678, 24622);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 558, 23678, 24622);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 558, 23678, 24622);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 558, 23678, 24622);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 558, 23678, 24622);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 558, 23678, 24622);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 558, 23678, 24622);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 558, 23678, 24622);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 558, 23678, 24622);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 558, 23678, 24622);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 558, 23678, 24622);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 558, 23678, 24622);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 558, 23678, 24622);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 558, 23678, 24622);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 558, 23678, 24622);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 558, 23678, 24622);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 558, 23678, 24622);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 558, 23678, 24622);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 558, 23678, 24622);
            CallChecker.varInit(this.m_wires, "m_wires", 558, 23678, 24622);
            CallChecker.varInit(this.m_fragments, "m_fragments", 558, 23678, 24622);
            CallChecker.varInit(this.m_revision, "m_revision", 558, 23678, 24622);
            CallChecker.varInit(this.m_resolver, "m_resolver", 558, 23678, 24622);
            CallChecker.varInit(this.m_configMap, "m_configMap", 558, 23678, 24622);
            CallChecker.varInit(this.m_logger, "m_logger", 558, 23678, 24622);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 558, 23678, 24622);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 558, 23678, 24622);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 558, 23678, 24622);
            if (isInUse()) {
                List<BundleRequirement> searchReqs = CallChecker.varInit(m_resolvedReqs, "searchReqs", 562, 23794, 23845);
                List<BundleRequirement> wovenReqs = CallChecker.varInit(m_wovenReqs, "wovenReqs", 563, 23859, 23906);
                List<BundleRequirement> result = CallChecker.varInit(m_resolvedReqs, "result", 564, 23920, 23967);
                if (wovenReqs != null) {
                    searchReqs = new ArrayList<BundleRequirement>(m_resolvedReqs);
                    CallChecker.varAssign(searchReqs, "searchReqs", 568, 24035, 24096);
                    if (CallChecker.beforeDeref(searchReqs, List.class, 569, 24114, 24123)) {
                        searchReqs = CallChecker.beforeCalled(searchReqs, List.class, 569, 24114, 24123);
                        CallChecker.isCalled(searchReqs, List.class, 569, 24114, 24123).addAll(wovenReqs);
                    }
                    result = searchReqs;
                    CallChecker.varAssign(result, "result", 570, 24160, 24179);
                }
                if (namespace != null) {
                    result = new ArrayList<BundleRequirement>();
                    CallChecker.varAssign(result, "result", 575, 24261, 24304);
                    if (CallChecker.beforeDeref(searchReqs, List.class, 576, 24351, 24360)) {
                        for (BundleRequirement req : searchReqs) {
                            if (CallChecker.beforeDeref(req, BundleRequirement.class, 578, 24405, 24407)) {
                                final String npe_invocation_var289 = CallChecker.isCalled(req, BundleRequirement.class, 578, 24405, 24407).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var289, String.class, 578, 24405, 24422)) {
                                    if (CallChecker.isCalled(npe_invocation_var289, String.class, 578, 24405, 24422).equals(namespace)) {
                                        if (CallChecker.beforeDeref(result, List.class, 580, 24489, 24494)) {
                                            result = CallChecker.beforeCalled(result, List.class, 580, 24489, 24494);
                                            CallChecker.isCalled(result, List.class, 580, 24489, 24494).add(req);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return result;
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context906.methodEnd();
        }
    }

    public List<NativeLibrary> getNativeLibraries() {
        MethodContext _bcornu_methode_context907 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 589, 24629, 24724);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 589, 24629, 24724);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 589, 24629, 24724);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 589, 24629, 24724);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 589, 24629, 24724);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 589, 24629, 24724);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 589, 24629, 24724);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 589, 24629, 24724);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 589, 24629, 24724);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 589, 24629, 24724);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 589, 24629, 24724);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 589, 24629, 24724);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 589, 24629, 24724);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 589, 24629, 24724);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 589, 24629, 24724);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 589, 24629, 24724);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 589, 24629, 24724);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 589, 24629, 24724);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 589, 24629, 24724);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 589, 24629, 24724);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 589, 24629, 24724);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 589, 24629, 24724);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 589, 24629, 24724);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 589, 24629, 24724);
            CallChecker.varInit(this.m_wires, "m_wires", 589, 24629, 24724);
            CallChecker.varInit(this.m_fragments, "m_fragments", 589, 24629, 24724);
            CallChecker.varInit(this.m_revision, "m_revision", 589, 24629, 24724);
            CallChecker.varInit(this.m_resolver, "m_resolver", 589, 24629, 24724);
            CallChecker.varInit(this.m_configMap, "m_configMap", 589, 24629, 24724);
            CallChecker.varInit(this.m_logger, "m_logger", 589, 24629, 24724);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 589, 24629, 24724);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 589, 24629, 24724);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 589, 24629, 24724);
            return m_resolvedNativeLibs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<NativeLibrary>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context907.methodEnd();
        }
    }

    private static List<Wire> asWireList(List wires) {
        MethodContext _bcornu_methode_context908 = new MethodContext(List.class);
        try {
            CallChecker.varInit(wires, "wires", 594, 24731, 24812);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 594, 24731, 24812);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 594, 24731, 24812);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 594, 24731, 24812);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 594, 24731, 24812);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 594, 24731, 24812);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 594, 24731, 24812);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 594, 24731, 24812);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 594, 24731, 24812);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 594, 24731, 24812);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 594, 24731, 24812);
            return wires;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Wire>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context908.methodEnd();
        }
    }

    public List<Wire> getProvidedResourceWires(String namespace) {
        MethodContext _bcornu_methode_context909 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 599, 24819, 24946);
            CallChecker.varInit(namespace, "namespace", 599, 24819, 24946);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 599, 24819, 24946);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 599, 24819, 24946);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 599, 24819, 24946);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 599, 24819, 24946);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 599, 24819, 24946);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 599, 24819, 24946);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 599, 24819, 24946);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 599, 24819, 24946);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 599, 24819, 24946);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 599, 24819, 24946);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 599, 24819, 24946);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 599, 24819, 24946);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 599, 24819, 24946);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 599, 24819, 24946);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 599, 24819, 24946);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 599, 24819, 24946);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 599, 24819, 24946);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 599, 24819, 24946);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 599, 24819, 24946);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 599, 24819, 24946);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 599, 24819, 24946);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 599, 24819, 24946);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 599, 24819, 24946);
            CallChecker.varInit(this.m_wires, "m_wires", 599, 24819, 24946);
            CallChecker.varInit(this.m_fragments, "m_fragments", 599, 24819, 24946);
            CallChecker.varInit(this.m_revision, "m_revision", 599, 24819, 24946);
            CallChecker.varInit(this.m_resolver, "m_resolver", 599, 24819, 24946);
            CallChecker.varInit(this.m_configMap, "m_configMap", 599, 24819, 24946);
            CallChecker.varInit(this.m_logger, "m_logger", 599, 24819, 24946);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 599, 24819, 24946);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 599, 24819, 24946);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 599, 24819, 24946);
            return BundleWiringImpl.asWireList(getProvidedWires(namespace));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Wire>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context909.methodEnd();
        }
    }

    public List<BundleWire> getProvidedWires(String namespace) {
        MethodContext _bcornu_methode_context910 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 604, 24953, 25234);
            CallChecker.varInit(namespace, "namespace", 604, 24953, 25234);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 604, 24953, 25234);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 604, 24953, 25234);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 604, 24953, 25234);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 604, 24953, 25234);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 604, 24953, 25234);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 604, 24953, 25234);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 604, 24953, 25234);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 604, 24953, 25234);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 604, 24953, 25234);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 604, 24953, 25234);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 604, 24953, 25234);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 604, 24953, 25234);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 604, 24953, 25234);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 604, 24953, 25234);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 604, 24953, 25234);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 604, 24953, 25234);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 604, 24953, 25234);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 604, 24953, 25234);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 604, 24953, 25234);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 604, 24953, 25234);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 604, 24953, 25234);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 604, 24953, 25234);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 604, 24953, 25234);
            CallChecker.varInit(this.m_wires, "m_wires", 604, 24953, 25234);
            CallChecker.varInit(this.m_fragments, "m_fragments", 604, 24953, 25234);
            CallChecker.varInit(this.m_revision, "m_revision", 604, 24953, 25234);
            CallChecker.varInit(this.m_resolver, "m_resolver", 604, 24953, 25234);
            CallChecker.varInit(this.m_configMap, "m_configMap", 604, 24953, 25234);
            CallChecker.varInit(this.m_logger, "m_logger", 604, 24953, 25234);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 604, 24953, 25234);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 604, 24953, 25234);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 604, 24953, 25234);
            if (isInUse()) {
                if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 608, 25084, 25093)) {
                    final BundleImpl npe_invocation_var290 = ((BundleImpl) (CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 608, 25084, 25093).getBundle()));
                    if (CallChecker.beforeDeref(npe_invocation_var290, BundleImpl.class, 608, 25084, 25105)) {
                        final Felix npe_invocation_var291 = CallChecker.isCalled(npe_invocation_var290, BundleImpl.class, 608, 25084, 25105).getFramework();
                        if (CallChecker.beforeDeref(npe_invocation_var291, Felix.class, 608, 25070, 25138)) {
                            final BundleRevisionDependencies npe_invocation_var292 = CallChecker.isCalled(npe_invocation_var291, Felix.class, 608, 25070, 25138).getDependencies();
                            if (CallChecker.beforeDeref(npe_invocation_var292, BundleRevisionDependencies.class, 608, 25070, 25156)) {
                                return CallChecker.isCalled(npe_invocation_var292, BundleRevisionDependencies.class, 608, 25070, 25156).getProvidedWires(m_revision, namespace);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleWire>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context910.methodEnd();
        }
    }

    public List<Wire> getRequiredResourceWires(String namespace) {
        MethodContext _bcornu_methode_context911 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 614, 25241, 25368);
            CallChecker.varInit(namespace, "namespace", 614, 25241, 25368);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 614, 25241, 25368);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 614, 25241, 25368);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 614, 25241, 25368);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 614, 25241, 25368);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 614, 25241, 25368);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 614, 25241, 25368);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 614, 25241, 25368);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 614, 25241, 25368);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 614, 25241, 25368);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 614, 25241, 25368);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 614, 25241, 25368);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 614, 25241, 25368);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 614, 25241, 25368);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 614, 25241, 25368);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 614, 25241, 25368);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 614, 25241, 25368);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 614, 25241, 25368);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 614, 25241, 25368);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 614, 25241, 25368);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 614, 25241, 25368);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 614, 25241, 25368);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 614, 25241, 25368);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 614, 25241, 25368);
            CallChecker.varInit(this.m_wires, "m_wires", 614, 25241, 25368);
            CallChecker.varInit(this.m_fragments, "m_fragments", 614, 25241, 25368);
            CallChecker.varInit(this.m_revision, "m_revision", 614, 25241, 25368);
            CallChecker.varInit(this.m_resolver, "m_resolver", 614, 25241, 25368);
            CallChecker.varInit(this.m_configMap, "m_configMap", 614, 25241, 25368);
            CallChecker.varInit(this.m_logger, "m_logger", 614, 25241, 25368);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 614, 25241, 25368);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 614, 25241, 25368);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 614, 25241, 25368);
            return BundleWiringImpl.asWireList(getRequiredWires(namespace));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Wire>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context911.methodEnd();
        }
    }

    public List<BundleWire> getRequiredWires(String namespace) {
        MethodContext _bcornu_methode_context912 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 619, 25375, 25943);
            CallChecker.varInit(namespace, "namespace", 619, 25375, 25943);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 619, 25375, 25943);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 619, 25375, 25943);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 619, 25375, 25943);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 619, 25375, 25943);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 619, 25375, 25943);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 619, 25375, 25943);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 619, 25375, 25943);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 619, 25375, 25943);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 619, 25375, 25943);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 619, 25375, 25943);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 619, 25375, 25943);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 619, 25375, 25943);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 619, 25375, 25943);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 619, 25375, 25943);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 619, 25375, 25943);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 619, 25375, 25943);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 619, 25375, 25943);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 619, 25375, 25943);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 619, 25375, 25943);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 619, 25375, 25943);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 619, 25375, 25943);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 619, 25375, 25943);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 619, 25375, 25943);
            CallChecker.varInit(this.m_wires, "m_wires", 619, 25375, 25943);
            CallChecker.varInit(this.m_fragments, "m_fragments", 619, 25375, 25943);
            CallChecker.varInit(this.m_revision, "m_revision", 619, 25375, 25943);
            CallChecker.varInit(this.m_resolver, "m_resolver", 619, 25375, 25943);
            CallChecker.varInit(this.m_configMap, "m_configMap", 619, 25375, 25943);
            CallChecker.varInit(this.m_logger, "m_logger", 619, 25375, 25943);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 619, 25375, 25943);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 619, 25375, 25943);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 619, 25375, 25943);
            if (isInUse()) {
                List<BundleWire> result = CallChecker.varInit(m_wires, "result", 623, 25485, 25518);
                if (namespace != null) {
                    result = new ArrayList<BundleWire>();
                    CallChecker.varAssign(result, "result", 626, 25585, 25621);
                    if (CallChecker.beforeDeref(m_wires, List.class, 627, 25660, 25666)) {
                        for (BundleWire bw : m_wires) {
                            if (CallChecker.beforeDeref(bw, BundleWire.class, 629, 25711, 25712)) {
                                final BundleRequirement npe_invocation_var293 = CallChecker.isCalled(bw, BundleWire.class, 629, 25711, 25712).getRequirement();
                                if (CallChecker.beforeDeref(npe_invocation_var293, BundleRequirement.class, 629, 25711, 25729)) {
                                    final String npe_invocation_var294 = CallChecker.isCalled(npe_invocation_var293, BundleRequirement.class, 629, 25711, 25729).getNamespace();
                                    if (CallChecker.beforeDeref(npe_invocation_var294, String.class, 629, 25711, 25744)) {
                                        if (CallChecker.isCalled(npe_invocation_var294, String.class, 629, 25711, 25744).equals(namespace)) {
                                            if (CallChecker.beforeDeref(result, List.class, 631, 25811, 25816)) {
                                                result = CallChecker.beforeCalled(result, List.class, 631, 25811, 25816);
                                                CallChecker.isCalled(result, List.class, 631, 25811, 25816).add(bw);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return result;
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleWire>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context912.methodEnd();
        }
    }

    public synchronized void addDynamicWire(BundleWire wire) {
        MethodContext _bcornu_methode_context913 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 640, 25950, 26786);
            CallChecker.varInit(wire, "wire", 640, 25950, 26786);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 640, 25950, 26786);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 640, 25950, 26786);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 640, 25950, 26786);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 640, 25950, 26786);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 640, 25950, 26786);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 640, 25950, 26786);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 640, 25950, 26786);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 640, 25950, 26786);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 640, 25950, 26786);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 640, 25950, 26786);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 640, 25950, 26786);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 640, 25950, 26786);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 640, 25950, 26786);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 640, 25950, 26786);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 640, 25950, 26786);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 640, 25950, 26786);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 640, 25950, 26786);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 640, 25950, 26786);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 640, 25950, 26786);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 640, 25950, 26786);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 640, 25950, 26786);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 640, 25950, 26786);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 640, 25950, 26786);
            CallChecker.varInit(this.m_wires, "m_wires", 640, 25950, 26786);
            CallChecker.varInit(this.m_fragments, "m_fragments", 640, 25950, 26786);
            CallChecker.varInit(this.m_revision, "m_revision", 640, 25950, 26786);
            CallChecker.varInit(this.m_resolver, "m_resolver", 640, 25950, 26786);
            CallChecker.varInit(this.m_configMap, "m_configMap", 640, 25950, 26786);
            CallChecker.varInit(this.m_logger, "m_logger", 640, 25950, 26786);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 640, 25950, 26786);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 640, 25950, 26786);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 640, 25950, 26786);
            List<BundleWire> wires = CallChecker.varInit(new ArrayList<BundleWire>(m_wires), "wires", 643, 26053, 26112);
            if (CallChecker.beforeDeref(wires, List.class, 644, 26122, 26126)) {
                wires = CallChecker.beforeCalled(wires, List.class, 644, 26122, 26126);
                CallChecker.isCalled(wires, List.class, 644, 26122, 26126).add(wire);
            }
            Map<String, BundleRevision> importedPkgs = CallChecker.varInit(new HashMap<String, BundleRevision>(m_importedPkgs), "importedPkgs", 646, 26189, 26295);
            if (CallChecker.beforeDeref(wire, BundleWire.class, 649, 26344, 26347)) {
                wire = CallChecker.beforeCalled(wire, BundleWire.class, 649, 26344, 26347);
                final BundleCapability npe_invocation_var295 = CallChecker.isCalled(wire, BundleWire.class, 649, 26344, 26347).getCapability();
                if (CallChecker.beforeDeref(npe_invocation_var295, BundleCapability.class, 649, 26344, 26363)) {
                    final Map<String, Object> npe_invocation_var296 = CallChecker.isCalled(npe_invocation_var295, BundleCapability.class, 649, 26344, 26363).getAttributes();
                    if (CallChecker.beforeDeref(npe_invocation_var296, Map.class, 649, 26344, 26379)) {
                        if (CallChecker.beforeDeref(wire, BundleWire.class, 650, 26432, 26435)) {
                            wire = CallChecker.beforeCalled(wire, BundleWire.class, 650, 26432, 26435);
                            final BundleWiring npe_invocation_var297 = CallChecker.isCalled(wire, BundleWire.class, 650, 26432, 26435).getProviderWiring();
                            if (CallChecker.beforeDeref(npe_invocation_var297, BundleWiring.class, 650, 26432, 26455)) {
                                if (CallChecker.beforeDeref(importedPkgs, Map.class, 648, 26305, 26316)) {
                                    importedPkgs = CallChecker.beforeCalled(importedPkgs, Map.class, 648, 26305, 26316);
                                    CallChecker.isCalled(importedPkgs, Map.class, 648, 26305, 26316).put(((String) (CallChecker.isCalled(npe_invocation_var296, Map.class, 649, 26344, 26379).get(BundleRevision.PACKAGE_NAMESPACE))), CallChecker.isCalled(npe_invocation_var297, BundleWiring.class, 650, 26432, 26455).getRevision());
                                }
                            }
                        }
                    }
                }
            }
            m_wires = ImmutableList.newInstance(wires);
            CallChecker.varAssign(this.m_wires, "this.m_wires", 655, 26699, 26741);
            m_importedPkgs = importedPkgs;
            CallChecker.varAssign(this.m_importedPkgs, "this.m_importedPkgs", 656, 26751, 26780);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context913.methodEnd();
        }
    }

    public BundleRevision getResource() {
        MethodContext _bcornu_methode_context914 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 659, 26793, 26866);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 659, 26793, 26866);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 659, 26793, 26866);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 659, 26793, 26866);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 659, 26793, 26866);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 659, 26793, 26866);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 659, 26793, 26866);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 659, 26793, 26866);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 659, 26793, 26866);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 659, 26793, 26866);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 659, 26793, 26866);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 659, 26793, 26866);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 659, 26793, 26866);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 659, 26793, 26866);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 659, 26793, 26866);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 659, 26793, 26866);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 659, 26793, 26866);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 659, 26793, 26866);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 659, 26793, 26866);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 659, 26793, 26866);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 659, 26793, 26866);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 659, 26793, 26866);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 659, 26793, 26866);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 659, 26793, 26866);
            CallChecker.varInit(this.m_wires, "m_wires", 659, 26793, 26866);
            CallChecker.varInit(this.m_fragments, "m_fragments", 659, 26793, 26866);
            CallChecker.varInit(this.m_revision, "m_revision", 659, 26793, 26866);
            CallChecker.varInit(this.m_resolver, "m_resolver", 659, 26793, 26866);
            CallChecker.varInit(this.m_configMap, "m_configMap", 659, 26793, 26866);
            CallChecker.varInit(this.m_logger, "m_logger", 659, 26793, 26866);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 659, 26793, 26866);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 659, 26793, 26866);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 659, 26793, 26866);
            return m_revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context914.methodEnd();
        }
    }

    public BundleRevision getRevision() {
        MethodContext _bcornu_methode_context915 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 664, 26873, 26946);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 664, 26873, 26946);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 664, 26873, 26946);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 664, 26873, 26946);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 664, 26873, 26946);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 664, 26873, 26946);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 664, 26873, 26946);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 664, 26873, 26946);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 664, 26873, 26946);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 664, 26873, 26946);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 664, 26873, 26946);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 664, 26873, 26946);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 664, 26873, 26946);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 664, 26873, 26946);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 664, 26873, 26946);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 664, 26873, 26946);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 664, 26873, 26946);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 664, 26873, 26946);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 664, 26873, 26946);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 664, 26873, 26946);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 664, 26873, 26946);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 664, 26873, 26946);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 664, 26873, 26946);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 664, 26873, 26946);
            CallChecker.varInit(this.m_wires, "m_wires", 664, 26873, 26946);
            CallChecker.varInit(this.m_fragments, "m_fragments", 664, 26873, 26946);
            CallChecker.varInit(this.m_revision, "m_revision", 664, 26873, 26946);
            CallChecker.varInit(this.m_resolver, "m_resolver", 664, 26873, 26946);
            CallChecker.varInit(this.m_configMap, "m_configMap", 664, 26873, 26946);
            CallChecker.varInit(this.m_logger, "m_logger", 664, 26873, 26946);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 664, 26873, 26946);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 664, 26873, 26946);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 664, 26873, 26946);
            return m_revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context915.methodEnd();
        }
    }

    public ClassLoader getClassLoader() {
        MethodContext _bcornu_methode_context916 = new MethodContext(ClassLoader.class);
        try {
            CallChecker.varInit(this, "this", 669, 26953, 27111);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 669, 26953, 27111);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 669, 26953, 27111);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 669, 26953, 27111);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 669, 26953, 27111);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 669, 26953, 27111);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 669, 26953, 27111);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 669, 26953, 27111);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 669, 26953, 27111);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 669, 26953, 27111);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 669, 26953, 27111);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 669, 26953, 27111);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 669, 26953, 27111);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 669, 26953, 27111);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 669, 26953, 27111);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 669, 26953, 27111);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 669, 26953, 27111);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 669, 26953, 27111);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 669, 26953, 27111);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 669, 26953, 27111);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 669, 26953, 27111);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 669, 26953, 27111);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 669, 26953, 27111);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 669, 26953, 27111);
            CallChecker.varInit(this.m_wires, "m_wires", 669, 26953, 27111);
            CallChecker.varInit(this.m_fragments, "m_fragments", 669, 26953, 27111);
            CallChecker.varInit(this.m_revision, "m_revision", 669, 26953, 27111);
            CallChecker.varInit(this.m_resolver, "m_resolver", 669, 26953, 27111);
            CallChecker.varInit(this.m_configMap, "m_configMap", 669, 26953, 27111);
            CallChecker.varInit(this.m_logger, "m_logger", 669, 26953, 27111);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 669, 26953, 27111);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 669, 26953, 27111);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 669, 26953, 27111);
            if (m_isDisposed) {
                return null;
            }
            return getClassLoaderInternal();
        } catch (ForceReturn _bcornu_return_t) {
            return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context916.methodEnd();
        }
    }

    private synchronized ClassLoader getClassLoaderInternal() {
        MethodContext _bcornu_methode_context917 = new MethodContext(ClassLoader.class);
        try {
            CallChecker.varInit(this, "this", 678, 27118, 28953);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 678, 27118, 28953);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 678, 27118, 28953);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 678, 27118, 28953);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 678, 27118, 28953);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 678, 27118, 28953);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 678, 27118, 28953);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 678, 27118, 28953);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 678, 27118, 28953);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 678, 27118, 28953);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 678, 27118, 28953);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 678, 27118, 28953);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 678, 27118, 28953);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 678, 27118, 28953);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 678, 27118, 28953);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 678, 27118, 28953);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 678, 27118, 28953);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 678, 27118, 28953);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 678, 27118, 28953);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 678, 27118, 28953);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 678, 27118, 28953);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 678, 27118, 28953);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 678, 27118, 28953);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 678, 27118, 28953);
            CallChecker.varInit(this.m_wires, "m_wires", 678, 27118, 28953);
            CallChecker.varInit(this.m_fragments, "m_fragments", 678, 27118, 28953);
            CallChecker.varInit(this.m_revision, "m_revision", 678, 27118, 28953);
            CallChecker.varInit(this.m_resolver, "m_resolver", 678, 27118, 28953);
            CallChecker.varInit(this.m_configMap, "m_configMap", 678, 27118, 28953);
            CallChecker.varInit(this.m_logger, "m_logger", 678, 27118, 28953);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 678, 27118, 28953);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 678, 27118, 28953);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 678, 27118, 28953);
            if ((!(m_isDisposed)) && ((m_classLoader) == null)) {
                Class clazz = CallChecker.init(Class.class);
                if (BundleWiringImpl.m_isPreJava5) {
                    clazz = BundleWiringImpl.BundleClassLoader.class;
                    CallChecker.varAssign(clazz, "clazz", 689, 27534, 27565);
                }else {
                    TryContext _bcornu_try_context_279 = new TryContext(279, BundleWiringImpl.class, "java.lang.Throwable");
                    try {
                        clazz = BundleWiringImpl.BundleClassLoaderJava5.class;
                        CallChecker.varAssign(clazz, "clazz", 695, 27670, 27706);
                    } catch (Throwable th) {
                        _bcornu_try_context_279.catchStart(279);
                        BundleWiringImpl.m_isPreJava5 = true;
                        CallChecker.varAssign(BundleWiringImpl.m_isPreJava5, "BundleWiringImpl.m_isPreJava5", 702, 28010, 28029);
                        clazz = BundleWiringImpl.BundleClassLoader.class;
                        CallChecker.varAssign(clazz, "clazz", 703, 28051, 28082);
                    } finally {
                        _bcornu_try_context_279.finallyStart(279);
                    }
                }
                TryContext _bcornu_try_context_280 = new TryContext(280, BundleWiringImpl.class, "java.lang.Exception");
                try {
                    final SecureAction npe_invocation_var298 = BundleRevisionImpl.getSecureAction();
                    Constructor ctor = CallChecker.init(Constructor.class);
                    if (CallChecker.beforeDeref(npe_invocation_var298, SecureAction.class, 711, 28311, 28346)) {
                        ctor = CallChecker.isCalled(npe_invocation_var298, SecureAction.class, 711, 28311, 28346).getConstructor(clazz, new Class[]{ BundleWiringImpl.class , ClassLoader.class , Logger.class });
                        CallChecker.varAssign(ctor, "ctor", 711, 28311, 28346);
                    }
                    final SecureAction npe_invocation_var299 = BundleRevisionImpl.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var299, SecureAction.class, 714, 28537, 28572)) {
                        m_classLoader = ((BundleWiringImpl.BundleClassLoader) (CallChecker.isCalled(npe_invocation_var299, SecureAction.class, 714, 28537, 28572).invoke(ctor, new Object[]{ this , determineParentClassLoader() , m_logger })));
                        CallChecker.varAssign(this.m_classLoader, "this.m_classLoader", 713, 28481, 28669);
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_280.catchStart(280);
                    if (CallChecker.beforeDeref(ex.getClass(), Class.class, 720, 28863, 28875)) {
                        throw new RuntimeException((((("Unable to create module class loader: " + (ex.getMessage())) + " [") + (CallChecker.isCalled(ex.getClass(), Class.class, 720, 28863, 28875).getName())) + "]"));
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_280.finallyStart(280);
                }
            }
            return m_classLoader;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context917.methodEnd();
        }
    }

    public List<URL> findEntries(String path, String filePattern, int options) {
        MethodContext _bcornu_methode_context918 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 726, 28960, 29750);
            CallChecker.varInit(options, "options", 726, 28960, 29750);
            CallChecker.varInit(filePattern, "filePattern", 726, 28960, 29750);
            CallChecker.varInit(path, "path", 726, 28960, 29750);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 726, 28960, 29750);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 726, 28960, 29750);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 726, 28960, 29750);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 726, 28960, 29750);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 726, 28960, 29750);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 726, 28960, 29750);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 726, 28960, 29750);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 726, 28960, 29750);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 726, 28960, 29750);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 726, 28960, 29750);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 726, 28960, 29750);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 726, 28960, 29750);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 726, 28960, 29750);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 726, 28960, 29750);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 726, 28960, 29750);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 726, 28960, 29750);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 726, 28960, 29750);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 726, 28960, 29750);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 726, 28960, 29750);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 726, 28960, 29750);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 726, 28960, 29750);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 726, 28960, 29750);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 726, 28960, 29750);
            CallChecker.varInit(this.m_wires, "m_wires", 726, 28960, 29750);
            CallChecker.varInit(this.m_fragments, "m_fragments", 726, 28960, 29750);
            CallChecker.varInit(this.m_revision, "m_revision", 726, 28960, 29750);
            CallChecker.varInit(this.m_resolver, "m_resolver", 726, 28960, 29750);
            CallChecker.varInit(this.m_configMap, "m_configMap", 726, 28960, 29750);
            CallChecker.varInit(this.m_logger, "m_logger", 726, 28960, 29750);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 726, 28960, 29750);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 726, 28960, 29750);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 726, 28960, 29750);
            if (isInUse()) {
                if (!(Util.isFragment(m_revision))) {
                    Enumeration<URL> e = CallChecker.init(Enumeration.class);
                    if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 733, 29205, 29214)) {
                        final BundleImpl npe_invocation_var300 = ((BundleImpl) (CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 733, 29205, 29214).getBundle()));
                        if (CallChecker.beforeDeref(npe_invocation_var300, BundleImpl.class, 733, 29205, 29226)) {
                            final Felix npe_invocation_var301 = CallChecker.isCalled(npe_invocation_var300, BundleImpl.class, 733, 29205, 29226).getFramework();
                            if (CallChecker.beforeDeref(npe_invocation_var301, Felix.class, 733, 29191, 29242)) {
                                e = CallChecker.isCalled(npe_invocation_var301, Felix.class, 733, 29191, 29242).findBundleEntries(m_revision, path, filePattern, ((options & (BundleWiring.FINDENTRIES_RECURSE)) > 0));
                                CallChecker.varAssign(e, "e", 733, 29205, 29214);
                            }
                        }
                    }
                    List<URL> entries = CallChecker.varInit(new ArrayList<URL>(), "entries", 736, 29412, 29452);
                    e = CallChecker.beforeCalled(e, Enumeration.class, 737, 29492, 29492);
                    while ((e != null) && (CallChecker.isCalled(e, Enumeration.class, 737, 29492, 29492).hasMoreElements())) {
                        if (CallChecker.beforeDeref(entries, List.class, 739, 29551, 29557)) {
                            entries = CallChecker.beforeCalled(entries, List.class, 739, 29551, 29557);
                            CallChecker.isCalled(entries, List.class, 739, 29551, 29557).add(e.nextElement());
                        }
                    } 
                    return ImmutableList.newInstance(entries);
                }
                return Collections.EMPTY_LIST;
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<URL>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context918.methodEnd();
        }
    }

    private final ThreadLocal m_listResourcesCycleCheck = new ThreadLocal();

    public synchronized Collection<String> listResources(String path, String filePattern, int options) {
        MethodContext _bcornu_methode_context919 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 752, 29883, 31989);
            CallChecker.varInit(options, "options", 752, 29883, 31989);
            CallChecker.varInit(filePattern, "filePattern", 752, 29883, 31989);
            CallChecker.varInit(path, "path", 752, 29883, 31989);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 752, 29883, 31989);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 752, 29883, 31989);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 752, 29883, 31989);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 752, 29883, 31989);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 752, 29883, 31989);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 752, 29883, 31989);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 752, 29883, 31989);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 752, 29883, 31989);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 752, 29883, 31989);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 752, 29883, 31989);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 752, 29883, 31989);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 752, 29883, 31989);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 752, 29883, 31989);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 752, 29883, 31989);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 752, 29883, 31989);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 752, 29883, 31989);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 752, 29883, 31989);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 752, 29883, 31989);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 752, 29883, 31989);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 752, 29883, 31989);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 752, 29883, 31989);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 752, 29883, 31989);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 752, 29883, 31989);
            CallChecker.varInit(this.m_wires, "m_wires", 752, 29883, 31989);
            CallChecker.varInit(this.m_fragments, "m_fragments", 752, 29883, 31989);
            CallChecker.varInit(this.m_revision, "m_revision", 752, 29883, 31989);
            CallChecker.varInit(this.m_resolver, "m_resolver", 752, 29883, 31989);
            CallChecker.varInit(this.m_configMap, "m_configMap", 752, 29883, 31989);
            CallChecker.varInit(this.m_logger, "m_logger", 752, 29883, 31989);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 752, 29883, 31989);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 752, 29883, 31989);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 752, 29883, 31989);
            Collection<String> resources = CallChecker.varInit(null, "resources", 767, 30778, 30813);
            if (CallChecker.beforeDeref(path, String.class, 770, 30856, 30859)) {
                if (CallChecker.beforeDeref(path, String.class, 770, 30879, 30882)) {
                    path = CallChecker.beforeCalled(path, String.class, 770, 30856, 30859);
                    path = CallChecker.beforeCalled(path, String.class, 770, 30879, 30882);
                    if (((CallChecker.isCalled(path, String.class, 770, 30856, 30859).length()) > 0) && ((CallChecker.isCalled(path, String.class, 770, 30879, 30882).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(path, String.class, 772, 30932, 30935)) {
                            path = CallChecker.beforeCalled(path, String.class, 772, 30932, 30935);
                            path = CallChecker.isCalled(path, String.class, 772, 30932, 30935).substring(1);
                            CallChecker.varAssign(path, "path", 772, 30925, 30949);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(path, String.class, 774, 30974, 30977)) {
                if (CallChecker.beforeDeref(path, String.class, 774, 31009, 31012)) {
                    if (CallChecker.beforeDeref(path, String.class, 774, 30997, 31000)) {
                        path = CallChecker.beforeCalled(path, String.class, 774, 30974, 30977);
                        path = CallChecker.beforeCalled(path, String.class, 774, 31009, 31012);
                        path = CallChecker.beforeCalled(path, String.class, 774, 30997, 31000);
                        if (((CallChecker.isCalled(path, String.class, 774, 30974, 30977).length()) > 0) && ((CallChecker.isCalled(path, String.class, 774, 30997, 31000).charAt(((CallChecker.isCalled(path, String.class, 774, 31009, 31012).length()) - 1))) != '/')) {
                            path = path + '/';
                            CallChecker.varAssign(path, "path", 776, 31059, 31076);
                        }
                    }
                }
            }
            if (filePattern == null) {
                filePattern = "*";
                CallChecker.varAssign(filePattern, "filePattern", 780, 31131, 31186);
            }else {
                filePattern = filePattern;
                CallChecker.varAssign(filePattern, "filePattern", 780, 31131, 31186);
            }
            List<String> pattern = CallChecker.varInit(SimpleFilter.parseSubstring(filePattern), "pattern", 781, 31196, 31259);
            Collection<BundleWiringImpl.ResourceSource> sources = CallChecker.varInit(listResourcesInternal(path, pattern, options), "sources", 785, 31408, 31490);
            if (sources != null) {
                boolean debug = CallChecker.varInit(((boolean) ((options & (BundleWiringImpl.LISTRESOURCES_DEBUG)) > 0)), "debug", 788, 31543, 31594);
                resources = new TreeSet<String>();
                CallChecker.varAssign(resources, "resources", 789, 31608, 31641);
                for (BundleWiringImpl.ResourceSource source : sources) {
                    if (debug) {
                        if (CallChecker.beforeDeref(source, BundleWiringImpl.ResourceSource.class, 794, 31786, 31791)) {
                            if (CallChecker.beforeDeref(resources, Collection.class, 794, 31772, 31780)) {
                                resources = CallChecker.beforeCalled(resources, Collection.class, 794, 31772, 31780);
                                CallChecker.isCalled(resources, Collection.class, 794, 31772, 31780).add(CallChecker.isCalled(source, BundleWiringImpl.ResourceSource.class, 794, 31786, 31791).toString());
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, BundleWiringImpl.ResourceSource.class, 798, 31897, 31902)) {
                            if (CallChecker.beforeDeref(resources, Collection.class, 798, 31883, 31891)) {
                                resources = CallChecker.beforeCalled(resources, Collection.class, 798, 31883, 31891);
                                CallChecker.isCalled(resources, Collection.class, 798, 31883, 31891).add(CallChecker.isCalled(source, BundleWiringImpl.ResourceSource.class, 798, 31897, 31902).m_resource);
                            }
                        }
                    }
                }
            }
            return resources;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context919.methodEnd();
        }
    }

    private Collection<BundleWiringImpl.ResourceSource> listResourcesInternal(String path, List<String> pattern, int options) {
        MethodContext _bcornu_methode_context920 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 805, 31996, 38971);
            CallChecker.varInit(options, "options", 805, 31996, 38971);
            CallChecker.varInit(pattern, "pattern", 805, 31996, 38971);
            CallChecker.varInit(path, "path", 805, 31996, 38971);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 805, 31996, 38971);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 805, 31996, 38971);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 805, 31996, 38971);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 805, 31996, 38971);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 805, 31996, 38971);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 805, 31996, 38971);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 805, 31996, 38971);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 805, 31996, 38971);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 805, 31996, 38971);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 805, 31996, 38971);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 805, 31996, 38971);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 805, 31996, 38971);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 805, 31996, 38971);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 805, 31996, 38971);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 805, 31996, 38971);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 805, 31996, 38971);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 805, 31996, 38971);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 805, 31996, 38971);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 805, 31996, 38971);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 805, 31996, 38971);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 805, 31996, 38971);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 805, 31996, 38971);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 805, 31996, 38971);
            CallChecker.varInit(this.m_wires, "m_wires", 805, 31996, 38971);
            CallChecker.varInit(this.m_fragments, "m_fragments", 805, 31996, 38971);
            CallChecker.varInit(this.m_revision, "m_revision", 805, 31996, 38971);
            CallChecker.varInit(this.m_resolver, "m_resolver", 805, 31996, 38971);
            CallChecker.varInit(this.m_configMap, "m_configMap", 805, 31996, 38971);
            CallChecker.varInit(this.m_logger, "m_logger", 805, 31996, 38971);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 805, 31996, 38971);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 805, 31996, 38971);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 805, 31996, 38971);
            if (isInUse()) {
                boolean recurse = CallChecker.varInit(((boolean) ((options & (BundleWiring.LISTRESOURCES_RECURSE)) > 0)), "recurse", 810, 32161, 32229);
                boolean localOnly = CallChecker.varInit(((boolean) ((options & (BundleWiring.LISTRESOURCES_LOCAL)) > 0)), "localOnly", 811, 32243, 32311);
                Set<String> cycles = CallChecker.init(Set.class);
                if (CallChecker.beforeDeref(m_listResourcesCycleCheck, ThreadLocal.class, 814, 32432, 32456)) {
                    cycles = ((Set<String>) (CallChecker.isCalled(m_listResourcesCycleCheck, ThreadLocal.class, 814, 32432, 32456).get()));
                    CallChecker.varAssign(cycles, "cycles", 814, 32432, 32456);
                }
                if (cycles == null) {
                    cycles = new HashSet<String>();
                    CallChecker.varAssign(cycles, "cycles", 817, 32527, 32557);
                    if (CallChecker.beforeDeref(m_listResourcesCycleCheck, ThreadLocal.class, 818, 32575, 32599)) {
                        CallChecker.isCalled(m_listResourcesCycleCheck, ThreadLocal.class, 818, 32575, 32599).set(cycles);
                    }
                }
                if (CallChecker.beforeDeref(cycles, Set.class, 820, 32644, 32649)) {
                    cycles = CallChecker.beforeCalled(cycles, Set.class, 820, 32644, 32649);
                    if (CallChecker.isCalled(cycles, Set.class, 820, 32644, 32649).contains(path)) {
                        return Collections.EMPTY_LIST;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(cycles, Set.class, 824, 32754, 32759)) {
                    cycles = CallChecker.beforeCalled(cycles, Set.class, 824, 32754, 32759);
                    CallChecker.isCalled(cycles, Set.class, 824, 32754, 32759).add(path);
                }
                TryContext _bcornu_try_context_281 = new TryContext(281, BundleWiringImpl.class);
                try {
                    Collection<BundleWiringImpl.ResourceSource> remoteResources = CallChecker.varInit(new TreeSet<BundleWiringImpl.ResourceSource>(), "remoteResources", 830, 32934, 33008);
                    Set<String> noMerging = CallChecker.varInit(new HashSet<String>(), "noMerging", 833, 33154, 33199);
                    if (CallChecker.beforeDeref(m_wires, Collection.class, 835, 33305, 33311)) {
                        for (BundleWire bw : m_wires) {
                            if (CallChecker.beforeDeref(bw, BundleWire.class, 837, 33356, 33357)) {
                                final BundleCapability npe_invocation_var302 = CallChecker.isCalled(bw, BundleWire.class, 837, 33356, 33357).getCapability();
                                if (CallChecker.beforeDeref(npe_invocation_var302, BundleCapability.class, 837, 33356, 33373)) {
                                    final String npe_invocation_var303 = CallChecker.isCalled(npe_invocation_var302, BundleCapability.class, 837, 33356, 33373).getNamespace();
                                    if (CallChecker.beforeDeref(npe_invocation_var303, String.class, 837, 33356, 33388)) {
                                        if (CallChecker.isCalled(npe_invocation_var303, String.class, 837, 33356, 33388).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                            if (CallChecker.beforeDeref(bw, BundleWire.class, 844, 33782, 33783)) {
                                                if (CallChecker.beforeDeref(remoteResources, Collection.class, 842, 33661, 33675)) {
                                                    remoteResources = CallChecker.beforeCalled(remoteResources, Collection.class, 842, 33661, 33675);
                                                    CallChecker.isCalled(remoteResources, Collection.class, 842, 33661, 33675).addAll(calculateRemotePackageResources(bw, CallChecker.isCalled(bw, BundleWire.class, 844, 33782, 33783).getCapability(), recurse, path, pattern, noMerging));
                                                }
                                            }
                                        }else
                                            if (CallChecker.beforeDeref(bw, BundleWire.class, 847, 33926, 33927)) {
                                                final BundleCapability npe_invocation_var304 = CallChecker.isCalled(bw, BundleWire.class, 847, 33926, 33927).getCapability();
                                                if (CallChecker.beforeDeref(npe_invocation_var304, BundleCapability.class, 847, 33926, 33943)) {
                                                    final String npe_invocation_var305 = CallChecker.isCalled(npe_invocation_var304, BundleCapability.class, 847, 33926, 33943).getNamespace();
                                                    if (CallChecker.beforeDeref(npe_invocation_var305, String.class, 847, 33926, 33958)) {
                                                        if (CallChecker.isCalled(npe_invocation_var305, String.class, 847, 33926, 33958).equals(BundleRevision.BUNDLE_NAMESPACE)) {
                                                            List<BundleCapability> exports = CallChecker.init(List.class);
                                                            if (CallChecker.beforeDeref(bw, BundleWire.class, 857, 34579, 34580)) {
                                                                final BundleWiring npe_invocation_var306 = CallChecker.isCalled(bw, BundleWire.class, 857, 34579, 34580).getProviderWiring();
                                                                if (CallChecker.beforeDeref(npe_invocation_var306, BundleWiring.class, 857, 34579, 34600)) {
                                                                    final BundleRevision npe_invocation_var307 = CallChecker.isCalled(npe_invocation_var306, BundleWiring.class, 857, 34579, 34600).getRevision();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var307, BundleRevision.class, 857, 34579, 34614)) {
                                                                        exports = CallChecker.isCalled(npe_invocation_var307, BundleRevision.class, 857, 34579, 34614).getDeclaredCapabilities(BundleRevision.PACKAGE_NAMESPACE);
                                                                        CallChecker.varAssign(exports, "exports", 857, 34579, 34580);
                                                                    }
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(exports, Collection.class, 859, 34763, 34769)) {
                                                                for (BundleCapability export : exports) {
                                                                    if (CallChecker.beforeDeref(remoteResources, Collection.class, 861, 34826, 34840)) {
                                                                        remoteResources = CallChecker.beforeCalled(remoteResources, Collection.class, 861, 34826, 34840);
                                                                        CallChecker.isCalled(remoteResources, Collection.class, 861, 34826, 34840).addAll(calculateRemotePackageResources(bw, export, recurse, path, pattern, null));
                                                                    }
                                                                }
                                                            }
                                                            List<BundleWire> requiredBundles = CallChecker.init(List.class);
                                                            if (CallChecker.beforeDeref(bw, BundleWire.class, 869, 35250, 35251)) {
                                                                final BundleWiring npe_invocation_var308 = CallChecker.isCalled(bw, BundleWire.class, 869, 35250, 35251).getProviderWiring();
                                                                if (CallChecker.beforeDeref(npe_invocation_var308, BundleWiring.class, 869, 35250, 35271)) {
                                                                    requiredBundles = CallChecker.isCalled(npe_invocation_var308, BundleWiring.class, 869, 35250, 35271).getRequiredWires(BundleRevision.BUNDLE_NAMESPACE);
                                                                    CallChecker.varAssign(requiredBundles, "requiredBundles", 869, 35250, 35251);
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(requiredBundles, Collection.class, 871, 35406, 35420)) {
                                                                for (BundleWire rbWire : requiredBundles) {
                                                                    String visibility = CallChecker.init(String.class);
                                                                    if (CallChecker.beforeDeref(rbWire, BundleWire.class, 874, 35529, 35534)) {
                                                                        final BundleRequirement npe_invocation_var309 = CallChecker.isCalled(rbWire, BundleWire.class, 874, 35529, 35534).getRequirement();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var309, BundleRequirement.class, 874, 35529, 35551)) {
                                                                            final Map<String, String> npe_invocation_var310 = CallChecker.isCalled(npe_invocation_var309, BundleRequirement.class, 874, 35529, 35551).getDirectives();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var310, Map.class, 874, 35529, 35567)) {
                                                                                visibility = CallChecker.isCalled(npe_invocation_var310, Map.class, 874, 35529, 35567).get(Constants.VISIBILITY_DIRECTIVE);
                                                                                CallChecker.varAssign(visibility, "visibility", 874, 35529, 35534);
                                                                            }
                                                                        }
                                                                    }
                                                                    if ((visibility != null) && (visibility.equals(Constants.VISIBILITY_REEXPORT))) {
                                                                        List<BundleCapability> reexports = CallChecker.init(List.class);
                                                                        if (CallChecker.beforeDeref(rbWire, BundleWire.class, 885, 36283, 36288)) {
                                                                            final BundleWiring npe_invocation_var311 = CallChecker.isCalled(rbWire, BundleWire.class, 885, 36283, 36288).getProviderWiring();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var311, BundleWiring.class, 885, 36283, 36308)) {
                                                                                final BundleRevision npe_invocation_var312 = CallChecker.isCalled(npe_invocation_var311, BundleWiring.class, 885, 36283, 36308).getRevision();
                                                                                if (CallChecker.beforeDeref(npe_invocation_var312, BundleRevision.class, 885, 36283, 36322)) {
                                                                                    reexports = CallChecker.isCalled(npe_invocation_var312, BundleRevision.class, 885, 36283, 36322).getDeclaredCapabilities(BundleRevision.PACKAGE_NAMESPACE);
                                                                                    CallChecker.varAssign(reexports, "reexports", 885, 36283, 36288);
                                                                                }
                                                                            }
                                                                        }
                                                                        if (CallChecker.beforeDeref(reexports, Collection.class, 887, 36489, 36497)) {
                                                                            for (BundleCapability reexport : reexports) {
                                                                                if (CallChecker.beforeDeref(remoteResources, Collection.class, 889, 36570, 36584)) {
                                                                                    remoteResources = CallChecker.beforeCalled(remoteResources, Collection.class, 889, 36570, 36584);
                                                                                    CallChecker.isCalled(remoteResources, Collection.class, 889, 36570, 36584).addAll(calculateRemotePackageResources(bw, reexport, recurse, path, pattern, null));
                                                                                }
                                                                            }
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
                            
                        }
                    }
                    Collection<BundleWiringImpl.ResourceSource> localResources = CallChecker.varInit(new TreeSet<BundleWiringImpl.ResourceSource>(), "localResources", 900, 37033, 37106);
                    List<Content> contentPath = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 903, 37263, 37272)) {
                        contentPath = CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 903, 37263, 37272).getContentPath();
                        CallChecker.varAssign(contentPath, "contentPath", 903, 37263, 37272);
                    }
                    if (CallChecker.beforeDeref(contentPath, Collection.class, 904, 37331, 37341)) {
                        for (Content content : contentPath) {
                            Enumeration<String> e = CallChecker.init(Enumeration.class);
                            if (CallChecker.beforeDeref(content, Content.class, 906, 37406, 37412)) {
                                e = CallChecker.isCalled(content, Content.class, 906, 37406, 37412).getEntries();
                                CallChecker.varAssign(e, "e", 906, 37406, 37412);
                            }
                            if (e != null) {
                                while (e.hasMoreElements()) {
                                    String resource = CallChecker.varInit(e.nextElement(), "resource", 911, 37591, 37624);
                                    String resourcePath = CallChecker.varInit(BundleWiringImpl.getTrailingPath(resource), "resourcePath", 912, 37654, 37701);
                                    if (CallChecker.beforeDeref(noMerging, Set.class, 913, 37736, 37744)) {
                                        noMerging = CallChecker.beforeCalled(noMerging, Set.class, 913, 37736, 37744);
                                        if (!(CallChecker.isCalled(noMerging, Set.class, 913, 37736, 37744).contains(resourcePath))) {
                                            if (CallChecker.beforeDeref(resourcePath, String.class, 915, 37849, 37860)) {
                                                if (CallChecker.beforeDeref(resourcePath, String.class, 916, 37927, 37938)) {
                                                    resourcePath = CallChecker.beforeCalled(resourcePath, String.class, 915, 37849, 37860);
                                                    resourcePath = CallChecker.beforeCalled(resourcePath, String.class, 916, 37927, 37938);
                                                    if (((!recurse) && (CallChecker.isCalled(resourcePath, String.class, 915, 37849, 37860).equals(path))) || (recurse && (CallChecker.isCalled(resourcePath, String.class, 916, 37927, 37938).startsWith(path)))) {
                                                        if (BundleWiringImpl.matchesPattern(pattern, BundleWiringImpl.getPathHead(resource))) {
                                                            if (CallChecker.beforeDeref(localResources, Collection.class, 920, 38159, 38172)) {
                                                                localResources = CallChecker.beforeCalled(localResources, Collection.class, 920, 38159, 38172);
                                                                CallChecker.isCalled(localResources, Collection.class, 920, 38159, 38172).add(new BundleWiringImpl.ResourceSource(resource, m_revision));
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
                    if (localOnly) {
                        return localResources;
                    }else {
                        if (CallChecker.beforeDeref(remoteResources, Collection.class, 935, 38604, 38618)) {
                            remoteResources = CallChecker.beforeCalled(remoteResources, Collection.class, 935, 38604, 38618);
                            CallChecker.isCalled(remoteResources, Collection.class, 935, 38604, 38618).addAll(localResources);
                        }
                        return remoteResources;
                    }
                } finally {
                    _bcornu_try_context_281.finallyStart(281);
                    if (CallChecker.beforeDeref(cycles, Set.class, 941, 38770, 38775)) {
                        cycles = CallChecker.beforeCalled(cycles, Set.class, 941, 38770, 38775);
                        CallChecker.isCalled(cycles, Set.class, 941, 38770, 38775).remove(path);
                    }
                    if (CallChecker.beforeDeref(cycles, Set.class, 942, 38811, 38816)) {
                        cycles = CallChecker.beforeCalled(cycles, Set.class, 942, 38811, 38816);
                        if (CallChecker.isCalled(cycles, Set.class, 942, 38811, 38816).isEmpty()) {
                            if (CallChecker.beforeDeref(m_listResourcesCycleCheck, ThreadLocal.class, 944, 38867, 38891)) {
                                CallChecker.isCalled(m_listResourcesCycleCheck, ThreadLocal.class, 944, 38867, 38891).set(null);
                            }
                        }
                    }
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<BundleWiringImpl.ResourceSource>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context920.methodEnd();
        }
    }

    private Collection<BundleWiringImpl.ResourceSource> calculateRemotePackageResources(BundleWire bw, BundleCapability cap, boolean recurse, String path, List<String> pattern, Set<String> noMerging) {
        MethodContext _bcornu_methode_context921 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 951, 38978, 41747);
            CallChecker.varInit(noMerging, "noMerging", 951, 38978, 41747);
            CallChecker.varInit(pattern, "pattern", 951, 38978, 41747);
            CallChecker.varInit(path, "path", 951, 38978, 41747);
            CallChecker.varInit(recurse, "recurse", 951, 38978, 41747);
            CallChecker.varInit(cap, "cap", 951, 38978, 41747);
            CallChecker.varInit(bw, "bw", 951, 38978, 41747);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 951, 38978, 41747);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 951, 38978, 41747);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 951, 38978, 41747);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 951, 38978, 41747);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 951, 38978, 41747);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 951, 38978, 41747);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 951, 38978, 41747);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 951, 38978, 41747);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 951, 38978, 41747);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 951, 38978, 41747);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 951, 38978, 41747);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 951, 38978, 41747);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 951, 38978, 41747);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 951, 38978, 41747);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 951, 38978, 41747);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 951, 38978, 41747);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 951, 38978, 41747);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 951, 38978, 41747);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 951, 38978, 41747);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 951, 38978, 41747);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 951, 38978, 41747);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 951, 38978, 41747);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 951, 38978, 41747);
            CallChecker.varInit(this.m_wires, "m_wires", 951, 38978, 41747);
            CallChecker.varInit(this.m_fragments, "m_fragments", 951, 38978, 41747);
            CallChecker.varInit(this.m_revision, "m_revision", 951, 38978, 41747);
            CallChecker.varInit(this.m_resolver, "m_resolver", 951, 38978, 41747);
            CallChecker.varInit(this.m_configMap, "m_configMap", 951, 38978, 41747);
            CallChecker.varInit(this.m_logger, "m_logger", 951, 38978, 41747);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 951, 38978, 41747);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 951, 38978, 41747);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 951, 38978, 41747);
            Collection<BundleWiringImpl.ResourceSource> resources = CallChecker.varInit(Collections.EMPTY_SET, "resources", 955, 39188, 39248);
            String subpath = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(cap, BundleCapability.class, 958, 39328, 39330)) {
                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 958, 39328, 39330);
                final Map<String, Object> npe_invocation_var313 = CallChecker.isCalled(cap, BundleCapability.class, 958, 39328, 39330).getAttributes();
                if (CallChecker.beforeDeref(npe_invocation_var313, Map.class, 958, 39328, 39346)) {
                    subpath = ((String) (CallChecker.isCalled(npe_invocation_var313, Map.class, 958, 39328, 39346).get(BundleRevision.PACKAGE_NAMESPACE)));
                    CallChecker.varAssign(subpath, "subpath", 958, 39328, 39330);
                }
            }
            if (CallChecker.beforeDeref(subpath, String.class, 959, 39405, 39411)) {
                subpath = CallChecker.beforeCalled(subpath, String.class, 959, 39405, 39411);
                subpath = (CallChecker.isCalled(subpath, String.class, 959, 39405, 39411).replace('.', '/')) + '/';
                CallChecker.varAssign(subpath, "subpath", 959, 39395, 39436);
            }
            if (noMerging != null) {
                noMerging.add(subpath);
            }
            if (CallChecker.beforeDeref(subpath, String.class, 970, 39810, 39816)) {
                if (CallChecker.beforeDeref(subpath, String.class, 971, 39859, 39865)) {
                    subpath = CallChecker.beforeCalled(subpath, String.class, 970, 39810, 39816);
                    subpath = CallChecker.beforeCalled(subpath, String.class, 971, 39859, 39865);
                    if (((!recurse) && (CallChecker.isCalled(subpath, String.class, 970, 39810, 39816).equals(path))) || (recurse && (CallChecker.isCalled(subpath, String.class, 971, 39859, 39865).startsWith(path)))) {
                        if (CallChecker.beforeDeref(bw, BundleWire.class, 977, 40175, 40176)) {
                            bw = CallChecker.beforeCalled(bw, BundleWire.class, 977, 40175, 40176);
                            final BundleWiringImpl npe_invocation_var314 = ((BundleWiringImpl) (CallChecker.isCalled(bw, BundleWire.class, 977, 40175, 40176).getProviderWiring()));
                            if (CallChecker.beforeDeref(npe_invocation_var314, BundleWiringImpl.class, 977, 40175, 40196)) {
                                resources = CallChecker.isCalled(npe_invocation_var314, BundleWiringImpl.class, 977, 40175, 40196).listResourcesInternal(subpath, pattern, 0);
                                CallChecker.varAssign(resources, "resources", 976, 40127, 40262);
                            }
                        }
                        resources = CallChecker.beforeCalled(resources, Collection.class, 984, 40580, 40588);
                        for (Iterator<BundleWiringImpl.ResourceSource> it = CallChecker.isCalled(resources, Collection.class, 984, 40580, 40588).iterator(); CallChecker.isCalled(it, Iterator.class, 985, 40618, 40619).hasNext();) {
                            BundleWiringImpl.ResourceSource reqResource = CallChecker.init(BundleWiringImpl.ResourceSource.class);
                            if (CallChecker.beforeDeref(it, Iterator.class, 987, 40693, 40694)) {
                                reqResource = CallChecker.isCalled(it, Iterator.class, 987, 40693, 40694).next();
                                CallChecker.varAssign(reqResource, "reqResource", 987, 40693, 40694);
                            }
                            if (CallChecker.beforeDeref(reqResource, BundleWiringImpl.ResourceSource.class, 988, 40724, 40734)) {
                                if (CallChecker.beforeDeref(reqResource, BundleWiringImpl.ResourceSource.class, 989, 40775, 40785)) {
                                    reqResource = CallChecker.beforeCalled(reqResource, BundleWiringImpl.ResourceSource.class, 989, 40775, 40785);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(reqResource, BundleWiringImpl.ResourceSource.class, 989, 40775, 40785).m_resource, String.class, 989, 40775, 40796)) {
                                        reqResource = CallChecker.beforeCalled(reqResource, BundleWiringImpl.ResourceSource.class, 988, 40724, 40734);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(reqResource, BundleWiringImpl.ResourceSource.class, 988, 40724, 40734).m_resource, String.class, 988, 40724, 40745)) {
                                            reqResource = CallChecker.beforeCalled(reqResource, BundleWiringImpl.ResourceSource.class, 988, 40724, 40734);
                                            reqResource = CallChecker.beforeCalled(reqResource, BundleWiringImpl.ResourceSource.class, 989, 40775, 40785);
                                            if ((CallChecker.isCalled(CallChecker.isCalled(reqResource, BundleWiringImpl.ResourceSource.class, 988, 40724, 40734).m_resource, String.class, 988, 40724, 40745).charAt(((CallChecker.isCalled(CallChecker.isCalled(reqResource, BundleWiringImpl.ResourceSource.class, 989, 40775, 40785).m_resource, String.class, 989, 40775, 40796).length()) - 1))) == '/') {
                                                if (CallChecker.beforeDeref(it, Iterator.class, 991, 40858, 40859)) {
                                                    CallChecker.isCalled(it, Iterator.class, 991, 40858, 40859).remove();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        if (CallChecker.beforeDeref(subpath, String.class, 1001, 41270, 41276)) {
                            subpath = CallChecker.beforeCalled(subpath, String.class, 1001, 41270, 41276);
                            if ((!recurse) && (CallChecker.isCalled(subpath, String.class, 1001, 41270, 41276).startsWith(path))) {
                                int idx = CallChecker.init(int.class);
                                if (CallChecker.beforeDeref(path, String.class, 1003, 41349, 41352)) {
                                    if (CallChecker.beforeDeref(subpath, String.class, 1003, 41328, 41334)) {
                                        path = CallChecker.beforeCalled(path, String.class, 1003, 41349, 41352);
                                        subpath = CallChecker.beforeCalled(subpath, String.class, 1003, 41328, 41334);
                                        idx = CallChecker.isCalled(subpath, String.class, 1003, 41328, 41334).indexOf('/', CallChecker.isCalled(path, String.class, 1003, 41349, 41352).length());
                                        CallChecker.varAssign(idx, "idx", 1003, 41349, 41352);
                                    }
                                }
                                if (idx >= 0) {
                                    if (CallChecker.beforeDeref(subpath, String.class, 1006, 41431, 41437)) {
                                        subpath = CallChecker.beforeCalled(subpath, String.class, 1006, 41431, 41437);
                                        subpath = CallChecker.isCalled(subpath, String.class, 1006, 41431, 41437).substring(0, (idx + 1));
                                        CallChecker.varAssign(subpath, "subpath", 1006, 41421, 41460);
                                    }
                                }
                                if (BundleWiringImpl.matchesPattern(pattern, BundleWiringImpl.getPathHead(subpath))) {
                                    if (CallChecker.beforeDeref(bw, BundleWire.class, 1011, 41652, 41653)) {
                                        bw = CallChecker.beforeCalled(bw, BundleWire.class, 1011, 41652, 41653);
                                        final BundleWiring npe_invocation_var315 = CallChecker.isCalled(bw, BundleWire.class, 1011, 41652, 41653).getProviderWiring();
                                        if (CallChecker.beforeDeref(npe_invocation_var315, BundleWiring.class, 1011, 41652, 41673)) {
                                            resources = Collections.singleton(new BundleWiringImpl.ResourceSource(subpath, CallChecker.isCalled(npe_invocation_var315, BundleWiring.class, 1011, 41652, 41673).getRevision()));
                                            CallChecker.varAssign(resources, "resources", 1010, 41569, 41690);
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
            
            return resources;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<BundleWiringImpl.ResourceSource>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context921.methodEnd();
        }
    }

    private static String getPathHead(String resource) {
        MethodContext _bcornu_methode_context922 = new MethodContext(String.class);
        try {
            CallChecker.varInit(resource, "resource", 1018, 41754, 42184);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1018, 41754, 42184);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1018, 41754, 42184);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1018, 41754, 42184);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1018, 41754, 42184);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1018, 41754, 42184);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1018, 41754, 42184);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1018, 41754, 42184);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1018, 41754, 42184);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1018, 41754, 42184);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1018, 41754, 42184);
            if (CallChecker.beforeDeref(resource, String.class, 1020, 41823, 41830)) {
                resource = CallChecker.beforeCalled(resource, String.class, 1020, 41823, 41830);
                if ((CallChecker.isCalled(resource, String.class, 1020, 41823, 41830).length()) == 0) {
                    return resource;
                }
            }else
                throw new AbnormalExecutionError();
            
            int idx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(resource, String.class, 1024, 41931, 41938)) {
                if (CallChecker.beforeDeref(resource, String.class, 1024, 41915, 41922)) {
                    resource = CallChecker.beforeCalled(resource, String.class, 1024, 41931, 41938);
                    resource = CallChecker.beforeCalled(resource, String.class, 1024, 41915, 41922);
                    if ((CallChecker.isCalled(resource, String.class, 1024, 41915, 41922).charAt(((CallChecker.isCalled(resource, String.class, 1024, 41931, 41938).length()) - 1))) == '/') {
                        if (CallChecker.beforeDeref(resource, String.class, 1025, 42002, 42009)) {
                            if (CallChecker.beforeDeref(resource, String.class, 1025, 41976, 41983)) {
                                resource = CallChecker.beforeCalled(resource, String.class, 1025, 42002, 42009);
                                resource = CallChecker.beforeCalled(resource, String.class, 1025, 41976, 41983);
                                idx = CallChecker.isCalled(resource, String.class, 1025, 41976, 41983).lastIndexOf('/', ((CallChecker.isCalled(resource, String.class, 1025, 42002, 42009).length()) - 2));
                                CallChecker.varAssign(idx, "idx", 1024, 41914, 42063);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(resource, String.class, 1026, 42039, 42046)) {
                            resource = CallChecker.beforeCalled(resource, String.class, 1026, 42039, 42046);
                            idx = CallChecker.isCalled(resource, String.class, 1026, 42039, 42046).lastIndexOf('/');
                            CallChecker.varAssign(idx, "idx", 1024, 41914, 42063);
                        }
                    }
                }
            }
            if (idx < 0) {
                return resource;
            }
            if (CallChecker.beforeDeref(resource, String.class, 1031, 42151, 42158)) {
                resource = CallChecker.beforeCalled(resource, String.class, 1031, 42151, 42158);
                return CallChecker.isCalled(resource, String.class, 1031, 42151, 42158).substring((idx + 1));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context922.methodEnd();
        }
    }

    private static String getTrailingPath(String resource) {
        MethodContext _bcornu_methode_context923 = new MethodContext(String.class);
        try {
            CallChecker.varInit(resource, "resource", 1034, 42191, 42618);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1034, 42191, 42618);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1034, 42191, 42618);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1034, 42191, 42618);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1034, 42191, 42618);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1034, 42191, 42618);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1034, 42191, 42618);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1034, 42191, 42618);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1034, 42191, 42618);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1034, 42191, 42618);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1034, 42191, 42618);
            if (CallChecker.beforeDeref(resource, String.class, 1036, 42264, 42271)) {
                resource = CallChecker.beforeCalled(resource, String.class, 1036, 42264, 42271);
                if ((CallChecker.isCalled(resource, String.class, 1036, 42264, 42271).length()) == 0) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            int idx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(resource, String.class, 1040, 42368, 42375)) {
                if (CallChecker.beforeDeref(resource, String.class, 1040, 42352, 42359)) {
                    resource = CallChecker.beforeCalled(resource, String.class, 1040, 42368, 42375);
                    resource = CallChecker.beforeCalled(resource, String.class, 1040, 42352, 42359);
                    if ((CallChecker.isCalled(resource, String.class, 1040, 42352, 42359).charAt(((CallChecker.isCalled(resource, String.class, 1040, 42368, 42375).length()) - 1))) == '/') {
                        if (CallChecker.beforeDeref(resource, String.class, 1041, 42439, 42446)) {
                            if (CallChecker.beforeDeref(resource, String.class, 1041, 42413, 42420)) {
                                resource = CallChecker.beforeCalled(resource, String.class, 1041, 42439, 42446);
                                resource = CallChecker.beforeCalled(resource, String.class, 1041, 42413, 42420);
                                idx = CallChecker.isCalled(resource, String.class, 1041, 42413, 42420).lastIndexOf('/', ((CallChecker.isCalled(resource, String.class, 1041, 42439, 42446).length()) - 2));
                                CallChecker.varAssign(idx, "idx", 1040, 42351, 42500);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(resource, String.class, 1042, 42476, 42483)) {
                            resource = CallChecker.beforeCalled(resource, String.class, 1042, 42476, 42483);
                            idx = CallChecker.isCalled(resource, String.class, 1042, 42476, 42483).lastIndexOf('/');
                            CallChecker.varAssign(idx, "idx", 1040, 42351, 42500);
                        }
                    }
                }
            }
            if (idx < 0) {
                return "";
            }
            if (CallChecker.beforeDeref(resource, String.class, 1047, 42582, 42589)) {
                resource = CallChecker.beforeCalled(resource, String.class, 1047, 42582, 42589);
                return CallChecker.isCalled(resource, String.class, 1047, 42582, 42589).substring(0, (idx + 1));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context923.methodEnd();
        }
    }

    private static boolean matchesPattern(List<String> pattern, String resource) {
        MethodContext _bcornu_methode_context924 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(resource, "resource", 1050, 42625, 42925);
            CallChecker.varInit(pattern, "pattern", 1050, 42625, 42925);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1050, 42625, 42925);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1050, 42625, 42925);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1050, 42625, 42925);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1050, 42625, 42925);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1050, 42625, 42925);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1050, 42625, 42925);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1050, 42625, 42925);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1050, 42625, 42925);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1050, 42625, 42925);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1050, 42625, 42925);
            if (CallChecker.beforeDeref(resource, String.class, 1052, 42736, 42743)) {
                if (CallChecker.beforeDeref(resource, String.class, 1052, 42720, 42727)) {
                    resource = CallChecker.beforeCalled(resource, String.class, 1052, 42736, 42743);
                    resource = CallChecker.beforeCalled(resource, String.class, 1052, 42720, 42727);
                    if ((CallChecker.isCalled(resource, String.class, 1052, 42720, 42727).charAt(((CallChecker.isCalled(resource, String.class, 1052, 42736, 42743).length()) - 1))) == '/') {
                        if (CallChecker.beforeDeref(resource, String.class, 1054, 42822, 42829)) {
                            if (CallChecker.beforeDeref(resource, String.class, 1054, 42800, 42807)) {
                                resource = CallChecker.beforeCalled(resource, String.class, 1054, 42822, 42829);
                                resource = CallChecker.beforeCalled(resource, String.class, 1054, 42800, 42807);
                                resource = CallChecker.isCalled(resource, String.class, 1054, 42800, 42807).substring(0, ((CallChecker.isCalled(resource, String.class, 1054, 42822, 42829).length()) - 1));
                                CallChecker.varAssign(resource, "resource", 1054, 42789, 42844);
                            }
                        }
                    }
                }
            }
            return SimpleFilter.compareSubstring(pattern, resource);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context924.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context925 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 1059, 42932, 43007);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1059, 42932, 43007);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1059, 42932, 43007);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1059, 42932, 43007);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1059, 42932, 43007);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1059, 42932, 43007);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1059, 42932, 43007);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1059, 42932, 43007);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1059, 42932, 43007);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1059, 42932, 43007);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1059, 42932, 43007);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1059, 42932, 43007);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1059, 42932, 43007);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1059, 42932, 43007);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1059, 42932, 43007);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1059, 42932, 43007);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1059, 42932, 43007);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1059, 42932, 43007);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1059, 42932, 43007);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1059, 42932, 43007);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1059, 42932, 43007);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1059, 42932, 43007);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1059, 42932, 43007);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1059, 42932, 43007);
            CallChecker.varInit(this.m_wires, "m_wires", 1059, 42932, 43007);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1059, 42932, 43007);
            CallChecker.varInit(this.m_revision, "m_revision", 1059, 42932, 43007);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1059, 42932, 43007);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1059, 42932, 43007);
            CallChecker.varInit(this.m_logger, "m_logger", 1059, 42932, 43007);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1059, 42932, 43007);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1059, 42932, 43007);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1059, 42932, 43007);
            if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 1061, 42979, 42988)) {
                return CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1061, 42979, 42988).getBundle();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context925.methodEnd();
        }
    }

    private URL createURL(int port, String path) {
        MethodContext _bcornu_methode_context926 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 1068, 43014, 43909);
            CallChecker.varInit(path, "path", 1068, 43014, 43909);
            CallChecker.varInit(port, "port", 1068, 43014, 43909);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1068, 43014, 43909);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1068, 43014, 43909);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1068, 43014, 43909);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1068, 43014, 43909);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1068, 43014, 43909);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1068, 43014, 43909);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1068, 43014, 43909);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1068, 43014, 43909);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1068, 43014, 43909);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1068, 43014, 43909);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1068, 43014, 43909);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1068, 43014, 43909);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1068, 43014, 43909);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1068, 43014, 43909);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1068, 43014, 43909);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1068, 43014, 43909);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1068, 43014, 43909);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1068, 43014, 43909);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1068, 43014, 43909);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1068, 43014, 43909);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1068, 43014, 43909);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1068, 43014, 43909);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1068, 43014, 43909);
            CallChecker.varInit(this.m_wires, "m_wires", 1068, 43014, 43909);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1068, 43014, 43909);
            CallChecker.varInit(this.m_revision, "m_revision", 1068, 43014, 43909);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1068, 43014, 43909);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1068, 43014, 43909);
            CallChecker.varInit(this.m_logger, "m_logger", 1068, 43014, 43909);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1068, 43014, 43909);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1068, 43014, 43909);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1068, 43014, 43909);
            if (CallChecker.beforeDeref(path, String.class, 1073, 43289, 43292)) {
                path = CallChecker.beforeCalled(path, String.class, 1073, 43289, 43292);
                if (!(CallChecker.isCalled(path, String.class, 1073, 43289, 43292).startsWith("/"))) {
                    path = "/" + path;
                    CallChecker.varAssign(path, "path", 1075, 43333, 43350);
                }
            }
            TryContext _bcornu_try_context_282 = new TryContext(282, BundleWiringImpl.class, "java.net.MalformedURLException");
            try {
                final BundleImpl npe_invocation_var316 = ((BundleImpl) (getBundle()));
                if (CallChecker.beforeDeref(npe_invocation_var316, BundleImpl.class, 1083, 43604, 43614)) {
                    final Felix npe_invocation_var317 = CallChecker.isCalled(npe_invocation_var316, BundleImpl.class, 1083, 43604, 43614).getFramework();
                    if (CallChecker.beforeDeref(npe_invocation_var317, Felix.class, 1083, 43590, 43630)) {
                        final SecureAction npe_invocation_var318 = BundleRevisionImpl.getSecureAction();
                        if (CallChecker.beforeDeref(npe_invocation_var318, SecureAction.class, 1080, 43404, 43439)) {
                            return CallChecker.isCalled(npe_invocation_var318, SecureAction.class, 1080, 43404, 43439).createURL(null, ((((((FelixConstants.BUNDLE_URL_PROTOCOL) + "://") + (CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1082, 43534, 43543).getId())) + ":") + port) + path), CallChecker.isCalled(npe_invocation_var317, Felix.class, 1083, 43590, 43630).getBundleStreamHandler());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (MalformedURLException ex) {
                _bcornu_try_context_282.catchStart(282);
                if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 1087, 43745, 43754)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1087, 43732, 43739)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1087, 43732, 43739).log(CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1087, 43745, 43754).getBundle(), Logger.LOG_ERROR, "Unable to create resource URL.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_282.finallyStart(282);
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context926.methodEnd();
        }
    }

    public Enumeration getResourcesByDelegation(String name) {
        MethodContext _bcornu_methode_context927 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 1095, 43916, 44473);
            CallChecker.varInit(name, "name", 1095, 43916, 44473);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1095, 43916, 44473);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1095, 43916, 44473);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1095, 43916, 44473);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1095, 43916, 44473);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1095, 43916, 44473);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1095, 43916, 44473);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1095, 43916, 44473);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1095, 43916, 44473);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1095, 43916, 44473);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1095, 43916, 44473);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1095, 43916, 44473);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1095, 43916, 44473);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1095, 43916, 44473);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1095, 43916, 44473);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1095, 43916, 44473);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1095, 43916, 44473);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1095, 43916, 44473);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1095, 43916, 44473);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1095, 43916, 44473);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1095, 43916, 44473);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1095, 43916, 44473);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1095, 43916, 44473);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1095, 43916, 44473);
            CallChecker.varInit(this.m_wires, "m_wires", 1095, 43916, 44473);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1095, 43916, 44473);
            CallChecker.varInit(this.m_revision, "m_revision", 1095, 43916, 44473);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1095, 43916, 44473);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1095, 43916, 44473);
            CallChecker.varInit(this.m_logger, "m_logger", 1095, 43916, 44473);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1095, 43916, 44473);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1095, 43916, 44473);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1095, 43916, 44473);
            Set requestSet = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_cycleCheck, ThreadLocal.class, 1097, 44010, 44021)) {
                requestSet = ((Set) (CallChecker.isCalled(m_cycleCheck, ThreadLocal.class, 1097, 44010, 44021).get()));
                CallChecker.varAssign(requestSet, "requestSet", 1097, 44010, 44021);
            }
            if (requestSet == null) {
                requestSet = new HashSet();
                CallChecker.varAssign(requestSet, "requestSet", 1100, 44084, 44110);
                if (CallChecker.beforeDeref(m_cycleCheck, ThreadLocal.class, 1101, 44124, 44135)) {
                    CallChecker.isCalled(m_cycleCheck, ThreadLocal.class, 1101, 44124, 44135).set(requestSet);
                }
            }
            if (CallChecker.beforeDeref(requestSet, Set.class, 1103, 44177, 44186)) {
                requestSet = CallChecker.beforeCalled(requestSet, Set.class, 1103, 44177, 44186);
                if (!(CallChecker.isCalled(requestSet, Set.class, 1103, 44177, 44186).contains(name))) {
                    if (CallChecker.beforeDeref(requestSet, Set.class, 1105, 44226, 44235)) {
                        requestSet = CallChecker.beforeCalled(requestSet, Set.class, 1105, 44226, 44235);
                        CallChecker.isCalled(requestSet, Set.class, 1105, 44226, 44235).add(name);
                    }
                    TryContext _bcornu_try_context_283 = new TryContext(283, BundleWiringImpl.class);
                    try {
                        return findResourcesByDelegation(name);
                    } finally {
                        _bcornu_try_context_283.finallyStart(283);
                        if (CallChecker.beforeDeref(requestSet, Set.class, 1112, 44398, 44407)) {
                            requestSet = CallChecker.beforeCalled(requestSet, Set.class, 1112, 44398, 44407);
                            CallChecker.isCalled(requestSet, Set.class, 1112, 44398, 44407).remove(name);
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context927.methodEnd();
        }
    }

    private Enumeration findResourcesByDelegation(String name) {
        MethodContext _bcornu_methode_context928 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 1119, 44480, 49062);
            CallChecker.varInit(name, "name", 1119, 44480, 49062);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1119, 44480, 49062);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1119, 44480, 49062);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1119, 44480, 49062);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1119, 44480, 49062);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1119, 44480, 49062);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1119, 44480, 49062);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1119, 44480, 49062);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1119, 44480, 49062);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1119, 44480, 49062);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1119, 44480, 49062);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1119, 44480, 49062);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1119, 44480, 49062);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1119, 44480, 49062);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1119, 44480, 49062);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1119, 44480, 49062);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1119, 44480, 49062);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1119, 44480, 49062);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1119, 44480, 49062);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1119, 44480, 49062);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1119, 44480, 49062);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1119, 44480, 49062);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1119, 44480, 49062);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1119, 44480, 49062);
            CallChecker.varInit(this.m_wires, "m_wires", 1119, 44480, 49062);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1119, 44480, 49062);
            CallChecker.varInit(this.m_revision, "m_revision", 1119, 44480, 49062);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1119, 44480, 49062);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1119, 44480, 49062);
            CallChecker.varInit(this.m_logger, "m_logger", 1119, 44480, 49062);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1119, 44480, 49062);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1119, 44480, 49062);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1119, 44480, 49062);
            Enumeration urls = CallChecker.varInit(null, "urls", 1121, 44553, 44576);
            List completeUrlList = CallChecker.varInit(new ArrayList(), "completeUrlList", 1122, 44586, 44624);
            String pkgName = CallChecker.varInit(Util.getResourcePackage(name), "pkgName", 1125, 44692, 44738);
            if (shouldBootDelegate(pkgName)) {
                TryContext _bcornu_try_context_284 = new TryContext(284, BundleWiringImpl.class, "java.io.IOException");
                try {
                    ClassLoader bdcl = CallChecker.varInit(getBootDelegationClassLoader(), "bdcl", 1134, 45017, 45066);
                    if (CallChecker.beforeDeref(bdcl, ClassLoader.class, 1135, 45091, 45094)) {
                        bdcl = CallChecker.beforeCalled(bdcl, ClassLoader.class, 1135, 45091, 45094);
                        urls = CallChecker.isCalled(bdcl, ClassLoader.class, 1135, 45091, 45094).getResources(name);
                        CallChecker.varAssign(urls, "urls", 1135, 45084, 45114);
                    }
                } catch (IOException ex) {
                    _bcornu_try_context_284.catchStart(284);
                } finally {
                    _bcornu_try_context_284.finallyStart(284);
                }
                if (CallChecker.beforeDeref(pkgName, String.class, 1144, 45467, 45473)) {
                    pkgName = CallChecker.beforeCalled(pkgName, String.class, 1144, 45467, 45473);
                    if (CallChecker.isCalled(pkgName, String.class, 1144, 45467, 45473).startsWith("java.")) {
                        return urls;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(completeUrlList, List.class, 1149, 45566, 45580)) {
                    completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1149, 45566, 45580);
                    CallChecker.isCalled(completeUrlList, List.class, 1149, 45566, 45580).add(urls);
                }
            }
            BundleRevision provider = CallChecker.init(BundleRevision.class);
            if (CallChecker.beforeDeref(m_importedPkgs, Map.class, 1155, 45827, 45840)) {
                m_importedPkgs = CallChecker.beforeCalled(m_importedPkgs, Map.class, 1155, 45827, 45840);
                provider = CallChecker.isCalled(m_importedPkgs, Map.class, 1155, 45827, 45840).get(pkgName);
                CallChecker.varAssign(provider, "provider", 1155, 45827, 45840);
            }
            if (provider != null) {
                provider = CallChecker.beforeCalled(provider, BundleRevision.class, 1159, 45985, 45992);
                final BundleWiringImpl npe_invocation_var319 = ((BundleWiringImpl) (CallChecker.isCalled(provider, BundleRevision.class, 1159, 45985, 45992).getWiring()));
                if (CallChecker.beforeDeref(npe_invocation_var319, BundleWiringImpl.class, 1159, 45985, 46004)) {
                    urls = CallChecker.isCalled(npe_invocation_var319, BundleWiringImpl.class, 1159, 45985, 46004).getResourcesByDelegation(name);
                    CallChecker.varAssign(urls, "urls", 1159, 45958, 46037);
                }
                if ((urls != null) && (urls.hasMoreElements())) {
                    if (CallChecker.beforeDeref(completeUrlList, List.class, 1164, 46186, 46200)) {
                        completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1164, 46186, 46200);
                        CallChecker.isCalled(completeUrlList, List.class, 1164, 46186, 46200).add(urls);
                    }
                }
                if (CallChecker.beforeDeref(completeUrlList, List.class, 1170, 46483, 46497)) {
                    if (CallChecker.beforeDeref(completeUrlList, List.class, 1170, 46443, 46457)) {
                        completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1170, 46483, 46497);
                        completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1170, 46443, 46457);
                        return new CompoundEnumeration(((Enumeration[]) (CallChecker.isCalled(completeUrlList, List.class, 1170, 46443, 46457).toArray(new Enumeration[CallChecker.isCalled(completeUrlList, List.class, 1170, 46483, 46497).size()]))));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            List<BundleRevision> providers = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_requiredPkgs, Map.class, 1176, 46792, 46805)) {
                providers = CallChecker.isCalled(m_requiredPkgs, Map.class, 1176, 46792, 46805).get(pkgName);
                CallChecker.varAssign(providers, "providers", 1176, 46792, 46805);
            }
            if (providers != null) {
                for (BundleRevision p : providers) {
                    if (CallChecker.beforeDeref(p, BundleRevision.class, 1182, 47020, 47020)) {
                        final BundleWiringImpl npe_invocation_var320 = ((BundleWiringImpl) (CallChecker.isCalled(p, BundleRevision.class, 1182, 47020, 47020).getWiring()));
                        if (CallChecker.beforeDeref(npe_invocation_var320, BundleWiringImpl.class, 1182, 47020, 47032)) {
                            urls = CallChecker.isCalled(npe_invocation_var320, BundleWiringImpl.class, 1182, 47020, 47032).getResourcesByDelegation(name);
                            CallChecker.varAssign(urls, "urls", 1182, 46993, 47065);
                        }
                    }
                    if ((urls != null) && (urls.hasMoreElements())) {
                        if (CallChecker.beforeDeref(completeUrlList, List.class, 1187, 47230, 47244)) {
                            completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1187, 47230, 47244);
                            CallChecker.isCalled(completeUrlList, List.class, 1187, 47230, 47244).add(urls);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 1198, 47644, 47653)) {
                urls = CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1198, 47644, 47653).getResourcesLocal(name);
                CallChecker.varAssign(urls, "urls", 1198, 47637, 47678);
            }
            if ((urls != null) && (urls.hasMoreElements())) {
                if (CallChecker.beforeDeref(completeUrlList, List.class, 1201, 47758, 47772)) {
                    completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1201, 47758, 47772);
                    CallChecker.isCalled(completeUrlList, List.class, 1201, 47758, 47772).add(urls);
                }
            }else {
                TryContext _bcornu_try_context_285 = new TryContext(285, BundleWiringImpl.class, "org.osgi.service.resolver.ResolutionException", "org.osgi.framework.BundleException");
                try {
                    if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 1211, 48160, 48169)) {
                        provider = CallChecker.isCalled(m_resolver, StatefulResolver.class, 1211, 48160, 48169).resolve(m_revision, pkgName);
                        CallChecker.varAssign(provider, "provider", 1211, 48149, 48199);
                    }
                } catch (ResolutionException ex) {
                    _bcornu_try_context_285.catchStart(285);
                } catch (BundleException ex) {
                    _bcornu_try_context_285.catchStart(285);
                } finally {
                    _bcornu_try_context_285.finallyStart(285);
                }
                if (provider != null) {
                    provider = CallChecker.beforeCalled(provider, BundleRevision.class, 1224, 48637, 48644);
                    final BundleWiringImpl npe_invocation_var321 = ((BundleWiringImpl) (CallChecker.isCalled(provider, BundleRevision.class, 1224, 48637, 48644).getWiring()));
                    if (CallChecker.beforeDeref(npe_invocation_var321, BundleWiringImpl.class, 1224, 48637, 48656)) {
                        urls = CallChecker.isCalled(npe_invocation_var321, BundleWiringImpl.class, 1224, 48637, 48656).getResourcesByDelegation(name);
                        CallChecker.varAssign(urls, "urls", 1224, 48610, 48689);
                    }
                    if ((urls != null) && (urls.hasMoreElements())) {
                        if (CallChecker.beforeDeref(completeUrlList, List.class, 1229, 48854, 48868)) {
                            completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1229, 48854, 48868);
                            CallChecker.isCalled(completeUrlList, List.class, 1229, 48854, 48868).add(urls);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(completeUrlList, List.class, 1235, 49031, 49045)) {
                if (CallChecker.beforeDeref(completeUrlList, List.class, 1235, 48991, 49005)) {
                    completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1235, 49031, 49045);
                    completeUrlList = CallChecker.beforeCalled(completeUrlList, List.class, 1235, 48991, 49005);
                    return new CompoundEnumeration(((Enumeration[]) (CallChecker.isCalled(completeUrlList, List.class, 1235, 48991, 49005).toArray(new Enumeration[CallChecker.isCalled(completeUrlList, List.class, 1235, 49031, 49045).size()]))));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context928.methodEnd();
        }
    }

    private ClassLoader determineParentClassLoader() {
        MethodContext _bcornu_methode_context929 = new MethodContext(ClassLoader.class);
        try {
            CallChecker.varInit(this, "this", 1238, 49069, 50558);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1238, 49069, 50558);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1238, 49069, 50558);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1238, 49069, 50558);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1238, 49069, 50558);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1238, 49069, 50558);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1238, 49069, 50558);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1238, 49069, 50558);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1238, 49069, 50558);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1238, 49069, 50558);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1238, 49069, 50558);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1238, 49069, 50558);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1238, 49069, 50558);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1238, 49069, 50558);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1238, 49069, 50558);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1238, 49069, 50558);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1238, 49069, 50558);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1238, 49069, 50558);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1238, 49069, 50558);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1238, 49069, 50558);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1238, 49069, 50558);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1238, 49069, 50558);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1238, 49069, 50558);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1238, 49069, 50558);
            CallChecker.varInit(this.m_wires, "m_wires", 1238, 49069, 50558);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1238, 49069, 50558);
            CallChecker.varInit(this.m_revision, "m_revision", 1238, 49069, 50558);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1238, 49069, 50558);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1238, 49069, 50558);
            CallChecker.varInit(this.m_logger, "m_logger", 1238, 49069, 50558);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1238, 49069, 50558);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1238, 49069, 50558);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1238, 49069, 50558);
            String cfg = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 1243, 49294, 49304)) {
                cfg = ((String) (CallChecker.isCalled(m_configMap, Map.class, 1243, 49294, 49304).get(Constants.FRAMEWORK_BUNDLE_PARENT)));
                CallChecker.varAssign(cfg, "cfg", 1243, 49294, 49304);
            }
            if (cfg == null) {
                cfg = Constants.FRAMEWORK_BUNDLE_PARENT_BOOT;
                CallChecker.varAssign(cfg, "cfg", 1244, 49354, 49420);
            }else {
                cfg = cfg;
                CallChecker.varAssign(cfg, "cfg", 1244, 49354, 49420);
            }
            ClassLoader parent = CallChecker.init(ClassLoader.class);
            if (CallChecker.beforeDeref(cfg, String.class, 1246, 49468, 49470)) {
                cfg = CallChecker.beforeCalled(cfg, String.class, 1246, 49468, 49470);
                if (CallChecker.isCalled(cfg, String.class, 1246, 49468, 49470).equalsIgnoreCase(Constants.FRAMEWORK_BUNDLE_PARENT_APP)) {
                    final SecureAction npe_invocation_var322 = BundleRevisionImpl.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var322, SecureAction.class, 1248, 49560, 49595)) {
                        parent = CallChecker.isCalled(npe_invocation_var322, SecureAction.class, 1248, 49560, 49595).getSystemClassLoader();
                        CallChecker.varAssign(parent, "parent", 1248, 49551, 49619);
                    }
                }else
                    if (CallChecker.beforeDeref(cfg, String.class, 1250, 49648, 49650)) {
                        cfg = CallChecker.beforeCalled(cfg, String.class, 1250, 49648, 49650);
                        if (CallChecker.isCalled(cfg, String.class, 1250, 49648, 49650).equalsIgnoreCase(Constants.FRAMEWORK_BUNDLE_PARENT_EXT)) {
                            final SecureAction npe_invocation_var323 = BundleRevisionImpl.getSecureAction();
                            if (CallChecker.beforeDeref(npe_invocation_var323, SecureAction.class, 1253, 49815, 49850)) {
                                final SecureAction npe_invocation_var324 = BundleRevisionImpl.getSecureAction();
                                if (CallChecker.beforeDeref(npe_invocation_var324, SecureAction.class, 1252, 49740, 49775)) {
                                    parent = CallChecker.isCalled(npe_invocation_var324, SecureAction.class, 1252, 49740, 49775).getParentClassLoader(CallChecker.isCalled(npe_invocation_var323, SecureAction.class, 1253, 49815, 49850).getSystemClassLoader());
                                    CallChecker.varAssign(parent, "parent", 1252, 49731, 49875);
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(cfg, String.class, 1255, 49904, 49906)) {
                                cfg = CallChecker.beforeCalled(cfg, String.class, 1255, 49904, 49906);
                                if (CallChecker.isCalled(cfg, String.class, 1255, 49904, 49906).equalsIgnoreCase(Constants.FRAMEWORK_BUNDLE_PARENT_FRAMEWORK)) {
                                    final SecureAction npe_invocation_var325 = BundleRevisionImpl.getSecureAction();
                                    if (CallChecker.beforeDeref(npe_invocation_var325, SecureAction.class, 1257, 50002, 50037)) {
                                        parent = CallChecker.isCalled(npe_invocation_var325, SecureAction.class, 1257, 50002, 50037).getClassLoader(BundleRevisionImpl.class);
                                        CallChecker.varAssign(parent, "parent", 1257, 49993, 50096);
                                    }
                                }else
                                    if ((m_bootClassLoader) == null) {
                                        final SecureAction npe_invocation_var326 = BundleRevisionImpl.getSecureAction();
                                        if (CallChecker.beforeDeref(npe_invocation_var326, SecureAction.class, 1265, 50400, 50435)) {
                                            parent = CallChecker.isCalled(npe_invocation_var326, SecureAction.class, 1265, 50400, 50435).getSystemClassLoader();
                                            CallChecker.varAssign(parent, "parent", 1265, 50391, 50459);
                                        }
                                    }else {
                                        parent = null;
                                        CallChecker.varAssign(parent, "parent", 1269, 50506, 50519);
                                    }
                                
                            }
                        
                    }
                
            }
            return parent;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context929.methodEnd();
        }
    }

    boolean shouldBootDelegate(String pkgName) {
        MethodContext _bcornu_methode_context930 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1274, 50565, 52122);
            CallChecker.varInit(pkgName, "pkgName", 1274, 50565, 52122);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1274, 50565, 52122);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1274, 50565, 52122);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1274, 50565, 52122);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1274, 50565, 52122);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1274, 50565, 52122);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1274, 50565, 52122);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1274, 50565, 52122);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1274, 50565, 52122);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1274, 50565, 52122);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1274, 50565, 52122);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1274, 50565, 52122);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1274, 50565, 52122);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1274, 50565, 52122);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1274, 50565, 52122);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1274, 50565, 52122);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1274, 50565, 52122);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1274, 50565, 52122);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1274, 50565, 52122);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1274, 50565, 52122);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1274, 50565, 52122);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1274, 50565, 52122);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1274, 50565, 52122);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1274, 50565, 52122);
            CallChecker.varInit(this.m_wires, "m_wires", 1274, 50565, 52122);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1274, 50565, 52122);
            CallChecker.varInit(this.m_revision, "m_revision", 1274, 50565, 52122);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1274, 50565, 52122);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1274, 50565, 52122);
            CallChecker.varInit(this.m_logger, "m_logger", 1274, 50565, 52122);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1274, 50565, 52122);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1274, 50565, 52122);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1274, 50565, 52122);
            if ((m_bootClassLoader) != (BundleWiringImpl.m_defBootClassLoader)) {
                return true;
            }
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 1283, 50816, 50838);
            if (CallChecker.beforeDeref(pkgName, String.class, 1288, 51036, 51042)) {
                pkgName = CallChecker.beforeCalled(pkgName, String.class, 1288, 51036, 51042);
                if ((CallChecker.isCalled(pkgName, String.class, 1288, 51036, 51042).length()) > 0) {
                    for (int i = 0; (!result) && (i < (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (getBundle())), BundleImpl.class, 1292, 51162, 51172).getFramework(), Felix.class, 1292, 51148, 51213).getBootPackages(), String[].class, 1292, 51148, 51231).length)); i++) {
                        final BundleImpl npe_invocation_var327 = ((BundleImpl) (getBundle()));
                        if (CallChecker.beforeDeref(npe_invocation_var327, BundleImpl.class, 1300, 51548, 51558)) {
                            final Felix npe_invocation_var328 = CallChecker.isCalled(npe_invocation_var327, BundleImpl.class, 1300, 51548, 51558).getFramework();
                            if (CallChecker.beforeDeref(npe_invocation_var328, Felix.class, 1300, 51534, 51574)) {
                                final boolean[] npe_invocation_var329 = CallChecker.isCalled(npe_invocation_var328, Felix.class, 1300, 51534, 51574).getBootPackageWildcards();
                                if (CallChecker.beforeDeref(npe_invocation_var329, boolean[].class, 1300, 51534, 51600)) {
                                    final BundleImpl npe_invocation_var330 = ((BundleImpl) (getBundle()));
                                    if (CallChecker.beforeDeref(npe_invocation_var330, BundleImpl.class, 1302, 51686, 51696)) {
                                        final Felix npe_invocation_var331 = CallChecker.isCalled(npe_invocation_var330, BundleImpl.class, 1302, 51686, 51696).getFramework();
                                        if (CallChecker.beforeDeref(npe_invocation_var331, Felix.class, 1302, 51672, 51712)) {
                                            final String[] npe_invocation_var332 = CallChecker.isCalled(npe_invocation_var331, Felix.class, 1302, 51672, 51712).getBootPackages();
                                            if (CallChecker.beforeDeref(npe_invocation_var332, String[].class, 1302, 51672, 51730)) {
                                                if (CallChecker.beforeDeref(pkgName, String.class, 1301, 51628, 51634)) {
                                                    pkgName = CallChecker.beforeCalled(pkgName, String.class, 1301, 51628, 51634);
                                                    if ((CallChecker.isCalled(npe_invocation_var329, boolean[].class, 1300, 51534, 51600)[i]) && (CallChecker.isCalled(pkgName, String.class, 1301, 51628, 51634).startsWith(CallChecker.isCalled(npe_invocation_var332, String[].class, 1302, 51672, 51730)[i]))) {
                                                        return true;
                                                    }else {
                                                        final BundleImpl npe_invocation_var333 = ((BundleImpl) (getBundle()));
                                                        if (CallChecker.beforeDeref(npe_invocation_var333, BundleImpl.class, 1307, 51914, 51924)) {
                                                            final Felix npe_invocation_var334 = CallChecker.isCalled(npe_invocation_var333, BundleImpl.class, 1307, 51914, 51924).getFramework();
                                                            if (CallChecker.beforeDeref(npe_invocation_var334, Felix.class, 1307, 51900, 51961)) {
                                                                final String[] npe_invocation_var335 = CallChecker.isCalled(npe_invocation_var334, Felix.class, 1307, 51900, 51961).getBootPackages();
                                                                if (CallChecker.beforeDeref(npe_invocation_var335, String[].class, 1307, 51900, 51979)) {
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var335, String[].class, 1307, 51900, 51979)[i], String.class, 1307, 51900, 51982)) {
                                                                        CallChecker.isCalled(npe_invocation_var335, String[].class, 1307, 51900, 51979)[i] = CallChecker.beforeCalled(CallChecker.isCalled(npe_invocation_var335, String[].class, 1307, 51900, 51979)[i], String.class, 1307, 51900, 51982);
                                                                        if (CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var335, String[].class, 1307, 51900, 51979)[i], String.class, 1307, 51900, 51982).equals(pkgName)) {
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
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context930.methodEnd();
        }
    }

    synchronized ClassLoader getBootDelegationClassLoader() {
        MethodContext _bcornu_methode_context931 = new MethodContext(ClassLoader.class);
        try {
            CallChecker.varInit(this, "this", 1318, 52129, 52501);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1318, 52129, 52501);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1318, 52129, 52501);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1318, 52129, 52501);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1318, 52129, 52501);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1318, 52129, 52501);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1318, 52129, 52501);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1318, 52129, 52501);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1318, 52129, 52501);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1318, 52129, 52501);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1318, 52129, 52501);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1318, 52129, 52501);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1318, 52129, 52501);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1318, 52129, 52501);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1318, 52129, 52501);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1318, 52129, 52501);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1318, 52129, 52501);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1318, 52129, 52501);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1318, 52129, 52501);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1318, 52129, 52501);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1318, 52129, 52501);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1318, 52129, 52501);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1318, 52129, 52501);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1318, 52129, 52501);
            CallChecker.varInit(this.m_wires, "m_wires", 1318, 52129, 52501);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1318, 52129, 52501);
            CallChecker.varInit(this.m_revision, "m_revision", 1318, 52129, 52501);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1318, 52129, 52501);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1318, 52129, 52501);
            CallChecker.varInit(this.m_logger, "m_logger", 1318, 52129, 52501);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1318, 52129, 52501);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1318, 52129, 52501);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1318, 52129, 52501);
            ClassLoader parent = CallChecker.init(ClassLoader.class);
            if ((m_classLoader) == null) {
                parent = determineParentClassLoader();
                CallChecker.varAssign(parent, "parent", 1321, 52280, 52432);
            }else {
                final SecureAction npe_invocation_var336 = BundleRevisionImpl.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var336, SecureAction.class, 1323, 52361, 52396)) {
                    parent = CallChecker.isCalled(npe_invocation_var336, SecureAction.class, 1323, 52361, 52396).getParentClassLoader(m_classLoader);
                    CallChecker.varAssign(parent, "parent", 1321, 52280, 52432);
                }
            }
            if (parent == null) {
                return m_bootClassLoader;
            }else {
                return parent;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context931.methodEnd();
        }
    }

    private static final Constructor m_dexFileClassConstructor;

    private static final Method m_dexFileClassLoadDex;

    private static final Method m_dexFileClassLoadClass;

    static {
        Constructor dexFileClassConstructor = CallChecker.varInit(null, "dexFileClassConstructor", 1333, 52706, 52748);
        Method dexFileClassLoadDex = CallChecker.varInit(null, "dexFileClassLoadDex", 1334, 52758, 52791);
        Method dexFileClassLoadClass = CallChecker.varInit(null, "dexFileClassLoadClass", 1335, 52801, 52836);
        TryContext _bcornu_try_context_288 = new TryContext(288, BundleWiringImpl.class, "java.lang.Throwable");
        try {
            Class dexFileClass = CallChecker.init(Class.class);
            TryContext _bcornu_try_context_286 = new TryContext(286, BundleWiringImpl.class, "java.lang.Exception");
            try {
                dexFileClass = Class.forName("dalvik.system.DexFile");
                CallChecker.varAssign(dexFileClass, "dexFileClass", 1341, 52938, 52991);
            } catch (Exception ex) {
                _bcornu_try_context_286.catchStart(286);
                dexFileClass = Class.forName("android.dalvik.DexFile");
                CallChecker.varAssign(dexFileClass, "dexFileClass", 1345, 53070, 53124);
            } finally {
                _bcornu_try_context_286.finallyStart(286);
            }
            TryContext _bcornu_try_context_287 = new TryContext(287, BundleWiringImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(dexFileClass, Class.class, 1350, 53209, 53220)) {
                    dexFileClass = CallChecker.beforeCalled(dexFileClass, Class.class, 1350, 53209, 53220);
                    dexFileClassLoadDex = CallChecker.isCalled(dexFileClass, Class.class, 1350, 53209, 53220).getMethod("loadDex", new Class[]{ String.class , String.class , Integer.TYPE });
                    CallChecker.varAssign(dexFileClassLoadDex, "dexFileClassLoadDex", 1350, 53187, 53317);
                }
            } catch (Exception ex) {
                _bcornu_try_context_287.catchStart(287);
            } finally {
                _bcornu_try_context_287.finallyStart(287);
            }
            if (CallChecker.beforeDeref(dexFileClass, Class.class, 1357, 53473, 53484)) {
                dexFileClass = CallChecker.beforeCalled(dexFileClass, Class.class, 1357, 53473, 53484);
                dexFileClassConstructor = CallChecker.isCalled(dexFileClass, Class.class, 1357, 53473, 53484).getConstructor(new Class[]{ File.class });
                CallChecker.varAssign(dexFileClassConstructor, "dexFileClassConstructor", 1357, 53447, 53553);
            }
            if (CallChecker.beforeDeref(dexFileClass, Class.class, 1359, 53591, 53602)) {
                dexFileClass = CallChecker.beforeCalled(dexFileClass, Class.class, 1359, 53591, 53602);
                dexFileClassLoadClass = CallChecker.isCalled(dexFileClass, Class.class, 1359, 53591, 53602).getMethod("loadClass", new Class[]{ String.class , ClassLoader.class });
                CallChecker.varAssign(dexFileClassLoadClass, "dexFileClassLoadClass", 1359, 53567, 53691);
            }
        } catch (Throwable ex) {
            _bcornu_try_context_288.catchStart(288);
            dexFileClassConstructor = null;
            CallChecker.varAssign(dexFileClassConstructor, "dexFileClassConstructor", 1364, 53753, 53783);
            dexFileClassLoadDex = null;
            CallChecker.varAssign(dexFileClassLoadDex, "dexFileClassLoadDex", 1365, 53796, 53822);
            dexFileClassLoadClass = null;
            CallChecker.varAssign(dexFileClassLoadClass, "dexFileClassLoadClass", 1366, 53835, 53863);
        } finally {
            _bcornu_try_context_288.finallyStart(288);
        }
        m_dexFileClassConstructor = dexFileClassConstructor;
        CallChecker.varAssign(m_dexFileClassConstructor, "BundleWiringImpl.m_dexFileClassConstructor", 1368, 53883, 53934);
        m_dexFileClassLoadDex = dexFileClassLoadDex;
        CallChecker.varAssign(m_dexFileClassLoadDex, "BundleWiringImpl.m_dexFileClassLoadDex", 1369, 53944, 53987);
        m_dexFileClassLoadClass = dexFileClassLoadClass;
        CallChecker.varAssign(m_dexFileClassLoadClass, "BundleWiringImpl.m_dexFileClassLoadClass", 1370, 53997, 54044);
    }

    public Class getClassByDelegation(String name) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context932 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(this, "this", 1373, 54057, 55071);
            CallChecker.varInit(name, "name", 1373, 54057, 55071);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1373, 54057, 55071);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1373, 54057, 55071);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1373, 54057, 55071);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1373, 54057, 55071);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1373, 54057, 55071);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1373, 54057, 55071);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1373, 54057, 55071);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1373, 54057, 55071);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1373, 54057, 55071);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1373, 54057, 55071);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1373, 54057, 55071);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1373, 54057, 55071);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1373, 54057, 55071);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1373, 54057, 55071);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1373, 54057, 55071);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1373, 54057, 55071);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1373, 54057, 55071);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1373, 54057, 55071);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1373, 54057, 55071);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1373, 54057, 55071);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1373, 54057, 55071);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1373, 54057, 55071);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1373, 54057, 55071);
            CallChecker.varInit(this.m_wires, "m_wires", 1373, 54057, 55071);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1373, 54057, 55071);
            CallChecker.varInit(this.m_revision, "m_revision", 1373, 54057, 55071);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1373, 54057, 55071);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1373, 54057, 55071);
            CallChecker.varInit(this.m_logger, "m_logger", 1373, 54057, 55071);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1373, 54057, 55071);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1373, 54057, 55071);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1373, 54057, 55071);
            if (((name != null) && ((name.length()) > 0)) && ((name.charAt(0)) == '[')) {
                return Class.forName(name, false, getClassLoader());
            }
            if (isFiltered(name)) {
                throw new ClassNotFoundException(name);
            }
            ClassLoader cl = CallChecker.varInit(getClassLoaderInternal(), "cl", 1389, 54692, 54733);
            if (cl == null) {
                if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 1396, 54950, 54959)) {
                    throw new ClassNotFoundException((((("Unable to load class '" + name) + "' because the bundle wiring for ") + (CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1396, 54950, 54959).getSymbolicName())) + " is no longer valid."));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return cl.loadClass(name);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context932.methodEnd();
        }
    }

    private boolean isFiltered(String name) {
        MethodContext _bcornu_methode_context933 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1402, 55078, 56414);
            CallChecker.varInit(name, "name", 1402, 55078, 56414);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1402, 55078, 56414);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1402, 55078, 56414);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1402, 55078, 56414);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1402, 55078, 56414);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1402, 55078, 56414);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1402, 55078, 56414);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1402, 55078, 56414);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1402, 55078, 56414);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1402, 55078, 56414);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1402, 55078, 56414);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1402, 55078, 56414);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1402, 55078, 56414);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1402, 55078, 56414);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1402, 55078, 56414);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1402, 55078, 56414);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1402, 55078, 56414);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1402, 55078, 56414);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1402, 55078, 56414);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1402, 55078, 56414);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1402, 55078, 56414);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1402, 55078, 56414);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1402, 55078, 56414);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1402, 55078, 56414);
            CallChecker.varInit(this.m_wires, "m_wires", 1402, 55078, 56414);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1402, 55078, 56414);
            CallChecker.varInit(this.m_revision, "m_revision", 1402, 55078, 56414);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1402, 55078, 56414);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1402, 55078, 56414);
            CallChecker.varInit(this.m_logger, "m_logger", 1402, 55078, 56414);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1402, 55078, 56414);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1402, 55078, 56414);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1402, 55078, 56414);
            String pkgName = CallChecker.varInit(Util.getClassPackage(name), "pkgName", 1404, 55132, 55175);
            List<List<String>> includeFilters = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_includedPkgFilters, Map.class, 1405, 55221, 55240)) {
                includeFilters = CallChecker.isCalled(m_includedPkgFilters, Map.class, 1405, 55221, 55240).get(pkgName);
                CallChecker.varAssign(includeFilters, "includeFilters", 1405, 55221, 55240);
            }
            List<List<String>> excludeFilters = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_excludedPkgFilters, Map.class, 1406, 55300, 55319)) {
                excludeFilters = CallChecker.isCalled(m_excludedPkgFilters, Map.class, 1406, 55300, 55319).get(pkgName);
                CallChecker.varAssign(excludeFilters, "excludeFilters", 1406, 55300, 55319);
            }
            if ((includeFilters == null) && (excludeFilters == null)) {
                return false;
            }
            String className = CallChecker.varInit(Util.getClassName(name), "className", 1414, 55516, 55558);
            boolean included = CallChecker.varInit(((boolean) (includeFilters == null)), "included", 1418, 55698, 55741);
            for (int i = 0; ((!included) && (includeFilters != null)) && (i < (includeFilters.size())); i++) {
                included = SimpleFilter.compareSubstring(includeFilters.get(i), className);
                CallChecker.varAssign(included, "included", 1423, 55890, 55964);
            }
            boolean excluded = CallChecker.varInit(((boolean) (false)), "excluded", 1428, 56113, 56137);
            for (int i = 0; ((!excluded) && (excludeFilters != null)) && (i < (excludeFilters.size())); i++) {
                excluded = SimpleFilter.compareSubstring(excludeFilters.get(i), className);
                CallChecker.varAssign(excluded, "excluded", 1433, 56286, 56360);
            }
            return (!included) || excluded;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context933.methodEnd();
        }
    }

    public URL getResourceByDelegation(String name) {
        MethodContext _bcornu_methode_context934 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 1438, 56421, 56924);
            CallChecker.varInit(name, "name", 1438, 56421, 56924);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1438, 56421, 56924);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1438, 56421, 56924);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1438, 56421, 56924);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1438, 56421, 56924);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1438, 56421, 56924);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1438, 56421, 56924);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1438, 56421, 56924);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1438, 56421, 56924);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1438, 56421, 56924);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1438, 56421, 56924);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1438, 56421, 56924);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1438, 56421, 56924);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1438, 56421, 56924);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1438, 56421, 56924);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1438, 56421, 56924);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1438, 56421, 56924);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1438, 56421, 56924);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1438, 56421, 56924);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1438, 56421, 56924);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1438, 56421, 56924);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1438, 56421, 56924);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1438, 56421, 56924);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1438, 56421, 56924);
            CallChecker.varInit(this.m_wires, "m_wires", 1438, 56421, 56924);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1438, 56421, 56924);
            CallChecker.varInit(this.m_revision, "m_revision", 1438, 56421, 56924);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1438, 56421, 56924);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1438, 56421, 56924);
            CallChecker.varInit(this.m_logger, "m_logger", 1438, 56421, 56924);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1438, 56421, 56924);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1438, 56421, 56924);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1438, 56421, 56924);
            TryContext _bcornu_try_context_289 = new TryContext(289, BundleWiringImpl.class, "java.lang.ClassNotFoundException", "org.apache.felix.framework.resolver.ResourceNotFoundException");
            try {
                return ((URL) (findClassOrResourceByDelegation(name, false)));
            } catch (ClassNotFoundException ex) {
                _bcornu_try_context_289.catchStart(289);
            } catch (ResourceNotFoundException ex) {
                _bcornu_try_context_289.catchStart(289);
                if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 1450, 56797, 56806)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1450, 56784, 56791)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1450, 56784, 56791).log(CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1450, 56797, 56806).getBundle(), Logger.LOG_DEBUG, ex.getMessage());
                    }
                }
            } finally {
                _bcornu_try_context_289.finallyStart(289);
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context934.methodEnd();
        }
    }

    private Object findClassOrResourceByDelegation(String name, boolean isClass) throws ClassNotFoundException, ResourceNotFoundException {
        MethodContext _bcornu_methode_context935 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 1457, 56931, 61191);
            CallChecker.varInit(isClass, "isClass", 1457, 56931, 61191);
            CallChecker.varInit(name, "name", 1457, 56931, 61191);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1457, 56931, 61191);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1457, 56931, 61191);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1457, 56931, 61191);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1457, 56931, 61191);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1457, 56931, 61191);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1457, 56931, 61191);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1457, 56931, 61191);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1457, 56931, 61191);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1457, 56931, 61191);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1457, 56931, 61191);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1457, 56931, 61191);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1457, 56931, 61191);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1457, 56931, 61191);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1457, 56931, 61191);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1457, 56931, 61191);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1457, 56931, 61191);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1457, 56931, 61191);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1457, 56931, 61191);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1457, 56931, 61191);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1457, 56931, 61191);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1457, 56931, 61191);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1457, 56931, 61191);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1457, 56931, 61191);
            CallChecker.varInit(this.m_wires, "m_wires", 1457, 56931, 61191);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1457, 56931, 61191);
            CallChecker.varInit(this.m_revision, "m_revision", 1457, 56931, 61191);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1457, 56931, 61191);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1457, 56931, 61191);
            CallChecker.varInit(this.m_logger, "m_logger", 1457, 56931, 61191);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1457, 56931, 61191);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1457, 56931, 61191);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1457, 56931, 61191);
            Object result = CallChecker.varInit(null, "result", 1460, 57087, 57107);
            Set requestSet = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_cycleCheck, ThreadLocal.class, 1462, 57141, 57152)) {
                requestSet = ((Set) (CallChecker.isCalled(m_cycleCheck, ThreadLocal.class, 1462, 57141, 57152).get()));
                CallChecker.varAssign(requestSet, "requestSet", 1462, 57141, 57152);
            }
            if (requestSet == null) {
                requestSet = new HashSet();
                CallChecker.varAssign(requestSet, "requestSet", 1465, 57215, 57241);
                if (CallChecker.beforeDeref(m_cycleCheck, ThreadLocal.class, 1466, 57255, 57266)) {
                    CallChecker.isCalled(m_cycleCheck, ThreadLocal.class, 1466, 57255, 57266).set(requestSet);
                }
            }
            if (CallChecker.beforeDeref(requestSet, Set.class, 1468, 57307, 57316)) {
                requestSet = CallChecker.beforeCalled(requestSet, Set.class, 1468, 57307, 57316);
                if (CallChecker.isCalled(requestSet, Set.class, 1468, 57307, 57316).add(name)) {
                    TryContext _bcornu_try_context_291 = new TryContext(291, BundleWiringImpl.class);
                    try {
                        String pkgName = CallChecker.init(String.class);
                        if (isClass) {
                            pkgName = Util.getClassPackage(name);
                            CallChecker.varAssign(pkgName, "pkgName", 1473, 57467, 57576);
                        }else {
                            pkgName = Util.getResourcePackage(name);
                            CallChecker.varAssign(pkgName, "pkgName", 1473, 57467, 57576);
                        }
                        if (shouldBootDelegate(pkgName)) {
                            TryContext _bcornu_try_context_290 = new TryContext(290, BundleWiringImpl.class, "java.lang.ClassNotFoundException");
                            try {
                                ClassLoader bdcl = CallChecker.varInit(getBootDelegationClassLoader(), "bdcl", 1484, 57920, 57969);
                                if (isClass) {
                                    if (CallChecker.beforeDeref(bdcl, ClassLoader.class, 1486, 58053, 58056)) {
                                        bdcl = CallChecker.beforeCalled(bdcl, ClassLoader.class, 1486, 58053, 58056);
                                        result = ((Object) (CallChecker.isCalled(bdcl, ClassLoader.class, 1486, 58053, 58056).loadClass(name)));
                                        CallChecker.varAssign(result, "result", 1485, 57995, 58135);
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(bdcl, ClassLoader.class, 1487, 58113, 58116)) {
                                        bdcl = CallChecker.beforeCalled(bdcl, ClassLoader.class, 1487, 58113, 58116);
                                        result = ((Object) (CallChecker.isCalled(bdcl, ClassLoader.class, 1487, 58113, 58116).getResource(name)));
                                        CallChecker.varAssign(result, "result", 1485, 57995, 58135);
                                    }
                                }
                                if (CallChecker.beforeDeref(pkgName, String.class, 1490, 58332, 58338)) {
                                    pkgName = CallChecker.beforeCalled(pkgName, String.class, 1490, 58332, 58338);
                                    if ((CallChecker.isCalled(pkgName, String.class, 1490, 58332, 58338).startsWith("java.")) || (result != null)) {
                                        return result;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            } catch (ClassNotFoundException ex) {
                                _bcornu_try_context_290.catchStart(290);
                                if (CallChecker.beforeDeref(pkgName, String.class, 1499, 58769, 58775)) {
                                    pkgName = CallChecker.beforeCalled(pkgName, String.class, 1499, 58769, 58775);
                                    if (CallChecker.isCalled(pkgName, String.class, 1499, 58769, 58775).startsWith("java.")) {
                                        throw ex;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            } finally {
                                _bcornu_try_context_290.finallyStart(290);
                            }
                        }
                        result = searchImports(pkgName, name, isClass);
                        CallChecker.varAssign(result, "result", 1509, 59152, 59198);
                        if (result == null) {
                            if (isClass) {
                                ClassLoader cl = CallChecker.varInit(getClassLoaderInternal(), "cl", 1516, 59402, 59443);
                                if (cl == null) {
                                    if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 1523, 59772, 59781)) {
                                        throw new ClassNotFoundException((((("Unable to load class '" + name) + "' because the bundle wiring for ") + (CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1523, 59772, 59781).getSymbolicName())) + " is no longer valid."));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                                result = ((BundleWiringImpl.BundleClassLoader) (cl)).findClass(name);
                                CallChecker.varAssign(result, "result", 1526, 59910, 59959);
                            }else {
                                if (CallChecker.beforeDeref(m_revision, BundleRevisionImpl.class, 1530, 60063, 60072)) {
                                    result = CallChecker.isCalled(m_revision, BundleRevisionImpl.class, 1530, 60063, 60072).getResourceLocal(name);
                                    CallChecker.varAssign(result, "result", 1530, 60054, 60096);
                                }
                            }
                            if (result == null) {
                                result = searchDynamicImports(pkgName, name, isClass);
                                CallChecker.varAssign(result, "result", 1536, 60291, 60344);
                            }
                        }
                    } finally {
                        _bcornu_try_context_291.finallyStart(291);
                        if (CallChecker.beforeDeref(requestSet, Set.class, 1542, 60450, 60459)) {
                            requestSet = CallChecker.beforeCalled(requestSet, Set.class, 1542, 60450, 60459);
                            CallChecker.isCalled(requestSet, Set.class, 1542, 60450, 60459).remove(name);
                        }
                    }
                }else {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (result == null) {
                if (isClass) {
                    throw new ClassNotFoundException(((name + " not found by ") + (this.getBundle())));
                }else {
                    throw new ResourceNotFoundException(((name + " not found by ") + (this.getBundle())));
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context935.methodEnd();
        }
    }

    private Object searchImports(String pkgName, String name, boolean isClass) throws ClassNotFoundException, ResourceNotFoundException {
        MethodContext _bcornu_methode_context936 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 1570, 61198, 63396);
            CallChecker.varInit(isClass, "isClass", 1570, 61198, 63396);
            CallChecker.varInit(name, "name", 1570, 61198, 63396);
            CallChecker.varInit(pkgName, "pkgName", 1570, 61198, 63396);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1570, 61198, 63396);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1570, 61198, 63396);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1570, 61198, 63396);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1570, 61198, 63396);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1570, 61198, 63396);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1570, 61198, 63396);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1570, 61198, 63396);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1570, 61198, 63396);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1570, 61198, 63396);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1570, 61198, 63396);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1570, 61198, 63396);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1570, 61198, 63396);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1570, 61198, 63396);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1570, 61198, 63396);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1570, 61198, 63396);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1570, 61198, 63396);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1570, 61198, 63396);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1570, 61198, 63396);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1570, 61198, 63396);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1570, 61198, 63396);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1570, 61198, 63396);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1570, 61198, 63396);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1570, 61198, 63396);
            CallChecker.varInit(this.m_wires, "m_wires", 1570, 61198, 63396);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1570, 61198, 63396);
            CallChecker.varInit(this.m_revision, "m_revision", 1570, 61198, 63396);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1570, 61198, 63396);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1570, 61198, 63396);
            CallChecker.varInit(this.m_logger, "m_logger", 1570, 61198, 63396);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1570, 61198, 63396);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1570, 61198, 63396);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1570, 61198, 63396);
            BundleRevision provider = CallChecker.init(BundleRevision.class);
            if (CallChecker.beforeDeref(m_importedPkgs, Map.class, 1574, 61423, 61436)) {
                m_importedPkgs = CallChecker.beforeCalled(m_importedPkgs, Map.class, 1574, 61423, 61436);
                provider = CallChecker.isCalled(m_importedPkgs, Map.class, 1574, 61423, 61436).get(pkgName);
                CallChecker.varAssign(provider, "provider", 1574, 61423, 61436);
            }
            if (provider != null) {
                Object result = CallChecker.init(Object.class);
                if (isClass) {
                    provider = CallChecker.beforeCalled(provider, BundleRevision.class, 1579, 61642, 61649);
                    final BundleWiringImpl npe_invocation_var337 = ((BundleWiringImpl) (CallChecker.isCalled(provider, BundleRevision.class, 1579, 61642, 61649).getWiring()));
                    if (CallChecker.beforeDeref(npe_invocation_var337, BundleWiringImpl.class, 1579, 61642, 61661)) {
                        result = ((Object) (CallChecker.isCalled(npe_invocation_var337, BundleWiringImpl.class, 1579, 61642, 61661).getClassByDelegation(name)));
                        CallChecker.varAssign(result, "result", 1578, 61585, 61788);
                    }
                }else {
                    provider = CallChecker.beforeCalled(provider, BundleRevision.class, 1580, 61738, 61745);
                    final BundleWiringImpl npe_invocation_var338 = ((BundleWiringImpl) (CallChecker.isCalled(provider, BundleRevision.class, 1580, 61738, 61745).getWiring()));
                    if (CallChecker.beforeDeref(npe_invocation_var338, BundleWiringImpl.class, 1580, 61738, 61757)) {
                        result = ((Object) (CallChecker.isCalled(npe_invocation_var338, BundleWiringImpl.class, 1580, 61738, 61757).getResourceByDelegation(name)));
                        CallChecker.varAssign(result, "result", 1578, 61585, 61788);
                    }
                }
                if (result != null) {
                    return result;
                }
                if (isClass) {
                    throw new ClassNotFoundException(name);
                }
                throw new ResourceNotFoundException(name);
            }
            List<BundleRevision> providers = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_requiredPkgs, Map.class, 1597, 62361, 62374)) {
                providers = CallChecker.isCalled(m_requiredPkgs, Map.class, 1597, 62361, 62374).get(pkgName);
                CallChecker.varAssign(providers, "providers", 1597, 62361, 62374);
            }
            if (providers != null) {
                for (BundleRevision p : providers) {
                    TryContext _bcornu_try_context_292 = new TryContext(292, BundleWiringImpl.class, "java.lang.ClassNotFoundException");
                    try {
                        Object result = CallChecker.init(Object.class);
                        if (isClass) {
                            if (CallChecker.beforeDeref(p, BundleRevision.class, 1606, 62700, 62700)) {
                                final BundleWiringImpl npe_invocation_var339 = ((BundleWiringImpl) (CallChecker.isCalled(p, BundleRevision.class, 1606, 62700, 62700).getWiring()));
                                if (CallChecker.beforeDeref(npe_invocation_var339, BundleWiringImpl.class, 1606, 62700, 62712)) {
                                    result = ((Object) (CallChecker.isCalled(npe_invocation_var339, BundleWiringImpl.class, 1606, 62700, 62712).getClassByDelegation(name)));
                                    CallChecker.varAssign(result, "result", 1605, 62635, 62840);
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(p, BundleRevision.class, 1607, 62797, 62797)) {
                                final BundleWiringImpl npe_invocation_var340 = ((BundleWiringImpl) (CallChecker.isCalled(p, BundleRevision.class, 1607, 62797, 62797).getWiring()));
                                if (CallChecker.beforeDeref(npe_invocation_var340, BundleWiringImpl.class, 1607, 62797, 62809)) {
                                    result = ((Object) (CallChecker.isCalled(npe_invocation_var340, BundleWiringImpl.class, 1607, 62797, 62809).getResourceByDelegation(name)));
                                    CallChecker.varAssign(result, "result", 1605, 62635, 62840);
                                }
                            }
                        }
                        if (result != null) {
                            return result;
                        }
                    } catch (ClassNotFoundException ex) {
                        _bcornu_try_context_292.catchStart(292);
                    } finally {
                        _bcornu_try_context_292.finallyStart(292);
                    }
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context936.methodEnd();
        }
    }

    private Object searchDynamicImports(final String pkgName, final String name, final boolean isClass) throws ClassNotFoundException, ResourceNotFoundException {
        MethodContext _bcornu_methode_context938 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 1626, 63403, 67566);
            CallChecker.varInit(isClass, "isClass", 1626, 63403, 67566);
            CallChecker.varInit(name, "name", 1626, 63403, 67566);
            CallChecker.varInit(pkgName, "pkgName", 1626, 63403, 67566);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1626, 63403, 67566);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1626, 63403, 67566);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1626, 63403, 67566);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1626, 63403, 67566);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1626, 63403, 67566);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1626, 63403, 67566);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1626, 63403, 67566);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1626, 63403, 67566);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1626, 63403, 67566);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1626, 63403, 67566);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1626, 63403, 67566);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1626, 63403, 67566);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1626, 63403, 67566);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1626, 63403, 67566);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1626, 63403, 67566);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1626, 63403, 67566);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1626, 63403, 67566);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1626, 63403, 67566);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1626, 63403, 67566);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1626, 63403, 67566);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1626, 63403, 67566);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1626, 63403, 67566);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1626, 63403, 67566);
            CallChecker.varInit(this.m_wires, "m_wires", 1626, 63403, 67566);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1626, 63403, 67566);
            CallChecker.varInit(this.m_revision, "m_revision", 1626, 63403, 67566);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1626, 63403, 67566);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1626, 63403, 67566);
            CallChecker.varInit(this.m_logger, "m_logger", 1626, 63403, 67566);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1626, 63403, 67566);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1626, 63403, 67566);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1626, 63403, 67566);
            BundleRevision provider = CallChecker.varInit(null, "provider", 1633, 63796, 63826);
            TryContext _bcornu_try_context_293 = new TryContext(293, BundleWiringImpl.class, "org.osgi.service.resolver.ResolutionException", "org.osgi.framework.BundleException");
            try {
                if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 1636, 63873, 63882)) {
                    provider = CallChecker.isCalled(m_resolver, StatefulResolver.class, 1636, 63873, 63882).resolve(m_revision, pkgName);
                    CallChecker.varAssign(provider, "provider", 1636, 63862, 63912);
                }
            } catch (ResolutionException ex) {
                _bcornu_try_context_293.catchStart(293);
            } catch (BundleException ex) {
                _bcornu_try_context_293.catchStart(293);
            } finally {
                _bcornu_try_context_293.finallyStart(293);
            }
            if (provider != null) {
                if (isClass) {
                    provider = CallChecker.beforeCalled(provider, BundleRevision.class, 1656, 64648, 64655);
                    final BundleWiringImpl npe_invocation_var341 = ((BundleWiringImpl) (CallChecker.isCalled(provider, BundleRevision.class, 1656, 64648, 64655).getWiring()));
                    if (CallChecker.beforeDeref(npe_invocation_var341, BundleWiringImpl.class, 1656, 64648, 64667)) {
                        return ((Object) (CallChecker.isCalled(npe_invocation_var341, BundleWiringImpl.class, 1656, 64648, 64667).getClassByDelegation(name)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    provider = CallChecker.beforeCalled(provider, BundleRevision.class, 1657, 64744, 64751);
                    final BundleWiringImpl npe_invocation_var342 = ((BundleWiringImpl) (CallChecker.isCalled(provider, BundleRevision.class, 1657, 64744, 64751).getWiring()));
                    if (CallChecker.beforeDeref(npe_invocation_var342, BundleWiringImpl.class, 1657, 64744, 64763)) {
                        return ((Object) (CallChecker.isCalled(npe_invocation_var342, BundleWiringImpl.class, 1657, 64744, 64763).getResourceByDelegation(name)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (m_implicitBootDelegation) {
                BundleWiringImpl.m_sm = CallChecker.beforeCalled(BundleWiringImpl.m_sm, SecurityManagerEx.class, 1683, 66415, 66418);
                final Class[] classes = CallChecker.varInit(CallChecker.isCalled(BundleWiringImpl.m_sm, SecurityManagerEx.class, 1683, 66415, 66418).getClassContext(), "classes", 1683, 66391, 66437);
                TryContext _bcornu_try_context_294 = new TryContext(294, BundleWiringImpl.class, "java.security.PrivilegedActionException");
                try {
                    if ((System.getSecurityManager()) != null) {
                        return AccessController.doPrivileged(new PrivilegedExceptionAction() {
                            public Object run() throws Exception {
                                MethodContext _bcornu_methode_context937 = new MethodContext(Object.class);
                                try {
                                    CallChecker.varInit(this, "this", 1691, 66712, 66932);
                                    return doImplicitBootDelegation(classes, name, isClass);
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Object) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context937.methodEnd();
                                }
                            }
                        });
                    }else {
                        return doImplicitBootDelegation(classes, name, isClass);
                    }
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_294.catchStart(294);
                    Exception cause = CallChecker.varInit(ex.getException(), "cause", 1705, 67207, 67242);
                    if (cause instanceof ClassNotFoundException) {
                        throw ((ClassNotFoundException) (cause));
                    }else {
                        throw ((ResourceNotFoundException) (cause));
                    }
                } finally {
                    _bcornu_try_context_294.finallyStart(294);
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context938.methodEnd();
        }
    }

    private Object doImplicitBootDelegation(Class[] classes, String name, boolean isClass) throws ClassNotFoundException, ResourceNotFoundException {
        MethodContext _bcornu_methode_context939 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 1719, 67573, 70343);
            CallChecker.varInit(isClass, "isClass", 1719, 67573, 70343);
            CallChecker.varInit(name, "name", 1719, 67573, 70343);
            CallChecker.varInit(classes, "classes", 1719, 67573, 70343);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1719, 67573, 70343);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1719, 67573, 70343);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1719, 67573, 70343);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1719, 67573, 70343);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1719, 67573, 70343);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1719, 67573, 70343);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1719, 67573, 70343);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1719, 67573, 70343);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1719, 67573, 70343);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1719, 67573, 70343);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1719, 67573, 70343);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1719, 67573, 70343);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1719, 67573, 70343);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1719, 67573, 70343);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1719, 67573, 70343);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1719, 67573, 70343);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1719, 67573, 70343);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1719, 67573, 70343);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1719, 67573, 70343);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1719, 67573, 70343);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1719, 67573, 70343);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1719, 67573, 70343);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1719, 67573, 70343);
            CallChecker.varInit(this.m_wires, "m_wires", 1719, 67573, 70343);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1719, 67573, 70343);
            CallChecker.varInit(this.m_revision, "m_revision", 1719, 67573, 70343);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1719, 67573, 70343);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1719, 67573, 70343);
            CallChecker.varInit(this.m_logger, "m_logger", 1719, 67573, 70343);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1719, 67573, 70343);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1719, 67573, 70343);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1719, 67573, 70343);
            classes = CallChecker.beforeCalled(classes, Class[].class, 1723, 67815, 67821);
            for (int i = 1; i < (CallChecker.isCalled(classes, Class[].class, 1723, 67815, 67821).length); i++) {
                if (CallChecker.beforeDeref(classes, Class[].class, 1742, 69013, 69019)) {
                    classes = CallChecker.beforeCalled(classes, Class[].class, 1742, 69013, 69019);
                    if (Thread.class.equals(CallChecker.isCalled(classes, Class[].class, 1742, 69013, 69019)[i])) {
                        break;
                    }else
                        if (CallChecker.beforeDeref(classes, Class[].class, 1748, 69266, 69272)) {
                            classes = CallChecker.beforeCalled(classes, Class[].class, 1748, 69266, 69272);
                            if (isClassLoadedFromBundleRevision(CallChecker.isCalled(classes, Class[].class, 1748, 69266, 69272)[i])) {
                                break;
                            }else
                                if (CallChecker.beforeDeref(classes, Class[].class, 1754, 69534, 69540)) {
                                    classes = CallChecker.beforeCalled(classes, Class[].class, 1754, 69534, 69540);
                                    if (BundleImpl.class.equals(CallChecker.isCalled(classes, Class[].class, 1754, 69534, 69540)[i])) {
                                        break;
                                    }else
                                        if (CallChecker.beforeDeref(classes, Class[].class, 1758, 69635, 69641)) {
                                            classes = CallChecker.beforeCalled(classes, Class[].class, 1758, 69635, 69641);
                                            if (isClassExternal(CallChecker.isCalled(classes, Class[].class, 1758, 69635, 69641)[i])) {
                                                TryContext _bcornu_try_context_295 = new TryContext(295, BundleWiringImpl.class, "java.lang.NoClassDefFoundError");
                                                try {
                                                    if (isClass) {
                                                        final SecureAction npe_invocation_var343 = BundleRevisionImpl.getSecureAction();
                                                        if (CallChecker.beforeDeref(npe_invocation_var343, SecureAction.class, 1764, 69854, 69889)) {
                                                            final ClassLoader npe_invocation_var344 = CallChecker.isCalled(npe_invocation_var343, SecureAction.class, 1764, 69854, 69889).getClassLoader(this.getClass());
                                                            if (CallChecker.beforeDeref(npe_invocation_var344, ClassLoader.class, 1764, 69854, 69950)) {
                                                                return ((Object) (CallChecker.isCalled(npe_invocation_var344, ClassLoader.class, 1764, 69854, 69950).loadClass(name)));
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else {
                                                        final SecureAction npe_invocation_var345 = BundleRevisionImpl.getSecureAction();
                                                        if (CallChecker.beforeDeref(npe_invocation_var345, SecureAction.class, 1766, 70003, 70038)) {
                                                            final ClassLoader npe_invocation_var346 = CallChecker.isCalled(npe_invocation_var345, SecureAction.class, 1766, 70003, 70038).getClassLoader(this.getClass());
                                                            if (CallChecker.beforeDeref(npe_invocation_var346, ClassLoader.class, 1766, 70003, 70099)) {
                                                                return ((Object) (CallChecker.isCalled(npe_invocation_var346, ClassLoader.class, 1766, 70003, 70099).getResource(name)));
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }
                                                } catch (NoClassDefFoundError ex) {
                                                    _bcornu_try_context_295.catchStart(295);
                                                } finally {
                                                    _bcornu_try_context_295.finallyStart(295);
                                                }
                                                break;
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context939.methodEnd();
        }
    }

    private boolean isClassLoadedFromBundleRevision(Class clazz) {
        MethodContext _bcornu_methode_context940 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1780, 70350, 71226);
            CallChecker.varInit(clazz, "clazz", 1780, 70350, 71226);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1780, 70350, 71226);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1780, 70350, 71226);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1780, 70350, 71226);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1780, 70350, 71226);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1780, 70350, 71226);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1780, 70350, 71226);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1780, 70350, 71226);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1780, 70350, 71226);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1780, 70350, 71226);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1780, 70350, 71226);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1780, 70350, 71226);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1780, 70350, 71226);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1780, 70350, 71226);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1780, 70350, 71226);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1780, 70350, 71226);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1780, 70350, 71226);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1780, 70350, 71226);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1780, 70350, 71226);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1780, 70350, 71226);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1780, 70350, 71226);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1780, 70350, 71226);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1780, 70350, 71226);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1780, 70350, 71226);
            CallChecker.varInit(this.m_wires, "m_wires", 1780, 70350, 71226);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1780, 70350, 71226);
            CallChecker.varInit(this.m_revision, "m_revision", 1780, 70350, 71226);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1780, 70350, 71226);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1780, 70350, 71226);
            CallChecker.varInit(this.m_logger, "m_logger", 1780, 70350, 71226);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1780, 70350, 71226);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1780, 70350, 71226);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1780, 70350, 71226);
            final SecureAction npe_invocation_var347 = BundleRevisionImpl.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var347, SecureAction.class, 1785, 70570, 70605)) {
                if (BundleWiringImpl.BundleClassLoader.class.isInstance(CallChecker.isCalled(npe_invocation_var347, SecureAction.class, 1785, 70570, 70605).getClassLoader(clazz))) {
                    return true;
                }
            }else
                throw new AbnormalExecutionError();
            
            ClassLoader last = CallChecker.varInit(null, "last", 1792, 70801, 70824);
            for (ClassLoader cl = CallChecker.isCalled(BundleRevisionImpl.getSecureAction(), SecureAction.class, 1793, 70856, 70891).getClassLoader(clazz); (cl != null) && (last != cl); cl = CallChecker.isCalled(BundleRevisionImpl.getSecureAction(), SecureAction.class, 1795, 70975, 71010).getClassLoader(CallChecker.isCalled(cl, ClassLoader.class, 1795, 71027, 71028).getClass())) {
                CallChecker.varAssign(cl, "cl", 1795, 70970, 71040);
                last = cl;
                CallChecker.varAssign(last, "last", 1797, 71065, 71074);
                if (BundleWiringImpl.BundleClassLoader.class.isInstance(cl)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context940.methodEnd();
        }
    }

    private boolean isClassExternal(Class clazz) {
        MethodContext _bcornu_methode_context941 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1824, 71233, 72881);
            CallChecker.varInit(clazz, "clazz", 1824, 71233, 72881);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 1824, 71233, 72881);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 1824, 71233, 72881);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 1824, 71233, 72881);
            CallChecker.varInit(this.m_listResourcesCycleCheck, "m_listResourcesCycleCheck", 1824, 71233, 72881);
            CallChecker.varInit(this.m_isDisposed, "m_isDisposed", 1824, 71233, 72881);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 1824, 71233, 72881);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 1824, 71233, 72881);
            CallChecker.varInit(this.m_cycleCheck, "m_cycleCheck", 1824, 71233, 72881);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 1824, 71233, 72881);
            CallChecker.varInit(this.m_useLocalURLs, "m_useLocalURLs", 1824, 71233, 72881);
            CallChecker.varInit(this.m_implicitBootDelegation, "m_implicitBootDelegation", 1824, 71233, 72881);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 1824, 71233, 72881);
            CallChecker.varInit(this.m_bootClassLoader, "m_bootClassLoader", 1824, 71233, 72881);
            CallChecker.varInit(this.m_classLoader, "m_classLoader", 1824, 71233, 72881);
            CallChecker.varInit(this.m_wovenReqs, "m_wovenReqs", 1824, 71233, 72881);
            CallChecker.varInit(this.m_fragmentContents, "m_fragmentContents", 1824, 71233, 72881);
            CallChecker.varInit(this.m_resolvedNativeLibs, "m_resolvedNativeLibs", 1824, 71233, 72881);
            CallChecker.varInit(this.m_resolvedReqs, "m_resolvedReqs", 1824, 71233, 72881);
            CallChecker.varInit(this.m_excludedPkgFilters, "m_excludedPkgFilters", 1824, 71233, 72881);
            CallChecker.varInit(this.m_includedPkgFilters, "m_includedPkgFilters", 1824, 71233, 72881);
            CallChecker.varInit(this.m_resolvedCaps, "m_resolvedCaps", 1824, 71233, 72881);
            CallChecker.varInit(this.m_requiredPkgs, "m_requiredPkgs", 1824, 71233, 72881);
            CallChecker.varInit(this.m_importedPkgs, "m_importedPkgs", 1824, 71233, 72881);
            CallChecker.varInit(this.m_wires, "m_wires", 1824, 71233, 72881);
            CallChecker.varInit(this.m_fragments, "m_fragments", 1824, 71233, 72881);
            CallChecker.varInit(this.m_revision, "m_revision", 1824, 71233, 72881);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1824, 71233, 72881);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1824, 71233, 72881);
            CallChecker.varInit(this.m_logger, "m_logger", 1824, 71233, 72881);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1824, 71233, 72881);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1824, 71233, 72881);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1824, 71233, 72881);
            if (CallChecker.beforeDeref(clazz, Class.class, 1826, 72451, 72455)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 1826, 72451, 72455);
                if (CallChecker.beforeDeref(CallChecker.isCalled(clazz, Class.class, 1826, 72451, 72455).getName(), String.class, 1826, 72451, 72465)) {
                    clazz = CallChecker.beforeCalled(clazz, Class.class, 1826, 72451, 72455);
                    if (CallChecker.isCalled(CallChecker.isCalled(clazz, Class.class, 1826, 72451, 72455).getName(), String.class, 1826, 72451, 72465).startsWith("org.apache.felix.framework.")) {
                        return false;
                    }else
                        if (CallChecker.beforeDeref(clazz, Class.class, 1830, 72573, 72577)) {
                            clazz = CallChecker.beforeCalled(clazz, Class.class, 1830, 72573, 72577);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clazz, Class.class, 1830, 72573, 72577).getName(), String.class, 1830, 72573, 72587)) {
                                clazz = CallChecker.beforeCalled(clazz, Class.class, 1830, 72573, 72577);
                                if (CallChecker.isCalled(CallChecker.isCalled(clazz, Class.class, 1830, 72573, 72577).getName(), String.class, 1830, 72573, 72587).startsWith("org.osgi.framework.")) {
                                    return false;
                                }else
                                    if (ClassLoader.class.equals(clazz)) {
                                        return false;
                                    }else
                                        if (Class.class.equals(clazz)) {
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
            
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context941.methodEnd();
        }
    }

    static class ToLocalUrlEnumeration implements Enumeration {
        final Enumeration m_enumeration;

        ToLocalUrlEnumeration(Enumeration enumeration) {
            MethodContext _bcornu_methode_context87 = new MethodContext(null);
            try {
                m_enumeration = enumeration;
                CallChecker.varAssign(this.m_enumeration, "this.m_enumeration", 1851, 73071, 73098);
            } finally {
                _bcornu_methode_context87.methodEnd();
            }
        }

        public boolean hasMoreElements() {
            MethodContext _bcornu_methode_context942 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1854, 73119, 73222);
                CallChecker.varInit(this.m_enumeration, "m_enumeration", 1854, 73119, 73222);
                if (CallChecker.beforeDeref(m_enumeration, Enumeration.class, 1856, 73181, 73193)) {
                    return CallChecker.isCalled(m_enumeration, Enumeration.class, 1856, 73181, 73193).hasMoreElements();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context942.methodEnd();
            }
        }

        public Object nextElement() {
            MethodContext _bcornu_methode_context943 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 1859, 73233, 73352);
                CallChecker.varInit(this.m_enumeration, "m_enumeration", 1859, 73233, 73352);
                if (CallChecker.beforeDeref(m_enumeration, Enumeration.class, 1861, 73314, 73326)) {
                    return BundleWiringImpl.convertToLocalUrl(((URL) (CallChecker.isCalled(m_enumeration, Enumeration.class, 1861, 73314, 73326).nextElement())));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context943.methodEnd();
            }
        }
    }

    public static class BundleClassLoaderJava5 extends BundleWiringImpl.BundleClassLoader {
        static final boolean m_isParallel;

        static {
            boolean registered = CallChecker.varInit(((boolean) (false)), "registered", 1870, 73520, 73546);
            TryContext _bcornu_try_context_296 = new TryContext(296, BundleWiringImpl.class, "java.lang.Throwable");
            try {
                final SecureAction npe_invocation_var348 = BundleRevisionImpl.getSecureAction();
                Method method = CallChecker.init(Method.class);
                if (CallChecker.beforeDeref(npe_invocation_var348, SecureAction.class, 1873, 73610, 73645)) {
                    method = CallChecker.isCalled(npe_invocation_var348, SecureAction.class, 1873, 73610, 73645).getDeclaredMethod(ClassLoader.class, "registerAsParallelCapable", null);
                    CallChecker.varAssign(method, "method", 1873, 73610, 73645);
                }
                final SecureAction npe_invocation_var349 = BundleRevisionImpl.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var349, SecureAction.class, 1876, 73758, 73793)) {
                    CallChecker.isCalled(npe_invocation_var349, SecureAction.class, 1876, 73758, 73793).setAccesssible(method);
                }
                if (CallChecker.beforeDeref(method, Method.class, 1878, 73860, 73865)) {
                    method = CallChecker.beforeCalled(method, Method.class, 1878, 73860, 73865);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(method, Method.class, 1878, 73860, 73865).invoke(null), Object.class, 1878, 73860, 73878)) {
                        method = CallChecker.beforeCalled(method, Method.class, 1878, 73860, 73865);
                        registered = CallChecker.isCalled(((Boolean) (CallChecker.isCalled(method, Method.class, 1878, 73860, 73865).invoke(null))), Boolean.class, 1878, 73860, 73878).booleanValue();
                        CallChecker.varAssign(registered, "registered", 1878, 73836, 73895);
                    }
                }
            } catch (Throwable th) {
                _bcornu_try_context_296.catchStart(296);
            } finally {
                _bcornu_try_context_296.finallyStart(296);
            }
            m_isParallel = registered;
            CallChecker.varAssign(m_isParallel, "m_isParallel", 1885, 74038, 74063);
        }

        @Override
        protected boolean isParallel() {
            MethodContext _bcornu_methode_context944 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1889, 74084, 74184);
                CallChecker.varInit(this.m_wiring, "m_wiring", 1889, 74084, 74184);
                CallChecker.varInit(m_isParallel, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoaderJava5.m_isParallel", 1889, 74084, 74184);
                return BundleWiringImpl.BundleClassLoaderJava5.m_isParallel;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context944.methodEnd();
            }
        }

        private final BundleWiringImpl m_wiring;

        public BundleClassLoaderJava5(BundleWiringImpl wiring, ClassLoader parent, Logger logger) {
            super(wiring, parent, logger);
            MethodContext _bcornu_methode_context88 = new MethodContext(null);
            try {
                m_wiring = wiring;
                CallChecker.varAssign(this.m_wiring, "this.m_wiring", 1899, 74400, 74417);
            } finally {
                _bcornu_methode_context88.methodEnd();
            }
        }

        @Override
        public Enumeration getResources(String name) {
            MethodContext _bcornu_methode_context945 = new MethodContext(Enumeration.class);
            try {
                CallChecker.varInit(this, "this", 1903, 74438, 74741);
                CallChecker.varInit(name, "name", 1903, 74438, 74741);
                CallChecker.varInit(this.m_wiring, "m_wiring", 1903, 74438, 74741);
                CallChecker.varInit(m_isParallel, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoaderJava5.m_isParallel", 1903, 74438, 74741);
                Enumeration urls = CallChecker.init(Enumeration.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 1905, 74542, 74549)) {
                    urls = CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 1905, 74542, 74549).getResourcesByDelegation(name);
                    CallChecker.varAssign(urls, "urls", 1905, 74542, 74549);
                }
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 1906, 74599, 74606)) {
                    if (CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 1906, 74599, 74606).m_useLocalURLs) {
                        urls = new BundleWiringImpl.ToLocalUrlEnumeration(urls);
                        CallChecker.varAssign(urls, "urls", 1908, 74654, 74692);
                    }
                }
                return urls;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context945.methodEnd();
            }
        }

        @Override
        protected Enumeration findResources(String name) {
            MethodContext _bcornu_methode_context946 = new MethodContext(Enumeration.class);
            try {
                CallChecker.varInit(this, "this", 1914, 74752, 74901);
                CallChecker.varInit(name, "name", 1914, 74752, 74901);
                CallChecker.varInit(this.m_wiring, "m_wiring", 1914, 74752, 74901);
                CallChecker.varInit(m_isParallel, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoaderJava5.m_isParallel", 1914, 74752, 74901);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 1916, 74848, 74855)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 1916, 74848, 74855).m_revision, BundleRevisionImpl.class, 1916, 74848, 74866)) {
                        return CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 1916, 74848, 74855).m_revision, BundleRevisionImpl.class, 1916, 74848, 74866).getResourcesLocal(name);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context946.methodEnd();
            }
        }
    }

    public static class BundleClassLoader extends SecureClassLoader implements BundleReference {
        static {
            TryContext _bcornu_try_context_297 = new TryContext(297, BundleWiringImpl.class, "java.lang.Throwable");
            try {
                final SecureAction npe_invocation_var350 = BundleRevisionImpl.getSecureAction();
                Method method = CallChecker.init(Method.class);
                if (CallChecker.beforeDeref(npe_invocation_var350, SecureAction.class, 1926, 75103, 75138)) {
                    method = CallChecker.isCalled(npe_invocation_var350, SecureAction.class, 1926, 75103, 75138).getDeclaredMethod(ClassLoader.class, "registerAsParallelCapable", null);
                    CallChecker.varAssign(method, "method", 1926, 75103, 75138);
                }
                final SecureAction npe_invocation_var351 = BundleRevisionImpl.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var351, SecureAction.class, 1929, 75252, 75287)) {
                    CallChecker.isCalled(npe_invocation_var351, SecureAction.class, 1929, 75252, 75287).setAccesssible(method);
                }
                if (CallChecker.beforeDeref(method, Method.class, 1931, 75331, 75336)) {
                    method = CallChecker.beforeCalled(method, Method.class, 1931, 75331, 75336);
                    CallChecker.isCalled(method, Method.class, 1931, 75331, 75336).invoke(null);
                }
            } catch (Throwable th) {
                _bcornu_try_context_297.catchStart(297);
            } finally {
                _bcornu_try_context_297.finallyStart(297);
            }
        }

        private volatile boolean m_isActivationTriggered = false;

        private final Map m_jarContentToDexFile;

        private Object[][] m_cachedLibs = new Object[0][];

        private static final int LIBNAME_IDX = 0;

        private static final int LIBPATH_IDX = 1;

        private final Map<String, Thread> m_classLocks = new HashMap<String, Thread>();

        private final BundleWiringImpl m_wiring;

        private final Logger m_logger;

        public BundleClassLoader(BundleWiringImpl wiring, ClassLoader parent, Logger logger) {
            super(parent);
            MethodContext _bcornu_methode_context89 = new MethodContext(null);
            try {
                if ((BundleWiringImpl.m_dexFileClassLoadClass) != null) {
                    m_jarContentToDexFile = new HashMap();
                    CallChecker.varAssign(this.m_jarContentToDexFile, "this.m_jarContentToDexFile", 1956, 76261, 76298);
                }else {
                    m_jarContentToDexFile = null;
                    CallChecker.varAssign(this.m_jarContentToDexFile, "this.m_jarContentToDexFile", 1960, 76361, 76389);
                }
                m_wiring = wiring;
                CallChecker.varAssign(this.m_wiring, "this.m_wiring", 1962, 76417, 76434);
                m_logger = logger;
                CallChecker.varAssign(this.m_logger, "this.m_logger", 1963, 76448, 76465);
            } finally {
                _bcornu_methode_context89.methodEnd();
            }
        }

        protected boolean isParallel() {
            MethodContext _bcornu_methode_context947 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1966, 76486, 76561);
                CallChecker.varInit(this.m_logger, "m_logger", 1966, 76486, 76561);
                CallChecker.varInit(this.m_wiring, "m_wiring", 1966, 76486, 76561);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 1966, 76486, 76561);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 1966, 76486, 76561);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 1966, 76486, 76561);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 1966, 76486, 76561);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 1966, 76486, 76561);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 1966, 76486, 76561);
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context947.methodEnd();
            }
        }

        public boolean isActivationTriggered() {
            MethodContext _bcornu_methode_context948 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1971, 76572, 76673);
                CallChecker.varInit(this.m_logger, "m_logger", 1971, 76572, 76673);
                CallChecker.varInit(this.m_wiring, "m_wiring", 1971, 76572, 76673);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 1971, 76572, 76673);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 1971, 76572, 76673);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 1971, 76572, 76673);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 1971, 76572, 76673);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 1971, 76572, 76673);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 1971, 76572, 76673);
                return m_isActivationTriggered;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context948.methodEnd();
            }
        }

        public Bundle getBundle() {
            MethodContext _bcornu_methode_context949 = new MethodContext(Bundle.class);
            try {
                CallChecker.varInit(this, "this", 1976, 76684, 76769);
                CallChecker.varInit(this.m_logger, "m_logger", 1976, 76684, 76769);
                CallChecker.varInit(this.m_wiring, "m_wiring", 1976, 76684, 76769);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 1976, 76684, 76769);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 1976, 76684, 76769);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 1976, 76684, 76769);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 1976, 76684, 76769);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 1976, 76684, 76769);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 1976, 76684, 76769);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 1978, 76739, 76746)) {
                    return CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 1978, 76739, 76746).getBundle();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context949.methodEnd();
            }
        }

        @Override
        protected Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
            MethodContext _bcornu_methode_context950 = new MethodContext(Class.class);
            try {
                CallChecker.varInit(this, "this", 1982, 76780, 78291);
                CallChecker.varInit(resolve, "resolve", 1982, 76780, 78291);
                CallChecker.varInit(name, "name", 1982, 76780, 78291);
                CallChecker.varInit(this.m_logger, "m_logger", 1982, 76780, 78291);
                CallChecker.varInit(this.m_wiring, "m_wiring", 1982, 76780, 78291);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 1982, 76780, 78291);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 1982, 76780, 78291);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 1982, 76780, 78291);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 1982, 76780, 78291);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 1982, 76780, 78291);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 1982, 76780, 78291);
                Class clazz = CallChecker.init(Class.class);
                Object lock = CallChecker.init(Object.class);
                if (isParallel()) {
                    lock = m_classLocks;
                    CallChecker.varAssign(lock, "lock", 1988, 77017, 77052);
                }else {
                    lock = this;
                    CallChecker.varAssign(lock, "lock", 1988, 77017, 77052);
                }
                synchronized(lock) {
                    clazz = findLoadedClass(name);
                    CallChecker.varAssign(clazz, "clazz", 1991, 77117, 77146);
                }
                if (clazz == null) {
                    TryContext _bcornu_try_context_298 = new TryContext(298, BundleWiringImpl.class, "org.apache.felix.framework.resolver.ResourceNotFoundException", "java.lang.ClassNotFoundException");
                    try {
                        if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 1998, 77282, 77289)) {
                            clazz = ((Class) (CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 1998, 77282, 77289).findClassOrResourceByDelegation(name, true)));
                            CallChecker.varAssign(clazz, "clazz", 1998, 77266, 77334);
                        }
                    } catch (ResourceNotFoundException ex) {
                        _bcornu_try_context_298.catchStart(298);
                    } catch (ClassNotFoundException cnfe) {
                        _bcornu_try_context_298.catchStart(298);
                        ClassNotFoundException ex = CallChecker.varInit(cnfe, "ex", 2007, 77656, 77688);
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 2008, 77714, 77721)) {
                            if ((CallChecker.isCalled(m_logger, Logger.class, 2008, 77714, 77721).getLogLevel()) >= (Logger.LOG_DEBUG)) {
                                String msg = CallChecker.init(String.class);
                                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2010, 77840, 77847)) {
                                    if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2010, 77861, 77868)) {
                                        msg = BundleWiringImpl.diagnoseClassLoadError(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2010, 77840, 77847).m_resolver, CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2010, 77861, 77868).m_revision, name);
                                        CallChecker.varAssign(msg, "msg", 2010, 77840, 77847);
                                    }
                                }
                                if (msg != null) {
                                    ex = new ClassNotFoundException(msg, cnfe);
                                    CallChecker.varAssign(ex, "ex", 2011, 77913, 78032);
                                }else {
                                    ex = ex;
                                    CallChecker.varAssign(ex, "ex", 2011, 77913, 78032);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        throw ex;
                    } finally {
                        _bcornu_try_context_298.finallyStart(298);
                    }
                }
                if (resolve) {
                    resolveClass(clazz);
                }
                return clazz;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Class) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context950.methodEnd();
            }
        }

        @Override
        protected Class findClass(String name) throws ClassNotFoundException {
            MethodContext _bcornu_methode_context951 = new MethodContext(Class.class);
            try {
                CallChecker.varInit(this, "this", 2028, 78302, 85181);
                CallChecker.varInit(name, "name", 2028, 78302, 85181);
                CallChecker.varInit(this.m_logger, "m_logger", 2028, 78302, 85181);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2028, 78302, 85181);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2028, 78302, 85181);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2028, 78302, 85181);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2028, 78302, 85181);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2028, 78302, 85181);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2028, 78302, 85181);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2028, 78302, 85181);
                Class clazz = CallChecker.varInit(null, "clazz", 2030, 78411, 78429);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2037, 78781, 78788)) {
                    if (CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2037, 78781, 78788).m_isDisposed) {
                        if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2043, 79019, 79026)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2043, 79019, 79026).m_revision, BundleRevisionImpl.class, 2043, 79019, 79037)) {
                                throw new ClassNotFoundException((((("Unable to load class '" + name) + "' because the bundle wiring for ") + (CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2043, 79019, 79026).m_revision, BundleRevisionImpl.class, 2043, 79019, 79037).getSymbolicName())) + " is no longer valid."));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (clazz == null) {
                    String actual = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(name, String.class, 2050, 79248, 79251)) {
                        name = CallChecker.beforeCalled(name, String.class, 2050, 79248, 79251);
                        actual = (CallChecker.isCalled(name, String.class, 2050, 79248, 79251).replace('.', '/')) + ".class";
                        CallChecker.varAssign(actual, "actual", 2050, 79248, 79251);
                    }
                    byte[] bytes = CallChecker.varInit(null, "bytes", 2052, 79300, 79319);
                    List<Content> contentPath = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2055, 79414, 79421)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2055, 79414, 79421).m_revision, BundleRevisionImpl.class, 2055, 79414, 79432)) {
                            contentPath = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2055, 79414, 79421).m_revision, BundleRevisionImpl.class, 2055, 79414, 79432).getContentPath();
                            CallChecker.varAssign(contentPath, "contentPath", 2055, 79414, 79421);
                        }
                    }
                    Content content = CallChecker.varInit(null, "content", 2056, 79468, 79490);
                    contentPath = CallChecker.beforeCalled(contentPath, List.class, 2059, 79588, 79598);
                    for (int i = 0; (bytes == null) && (i < (CallChecker.isCalled(contentPath, List.class, 2059, 79588, 79598).size())); i++) {
                        if (CallChecker.beforeDeref(contentPath, List.class, 2061, 79660, 79670)) {
                            contentPath = CallChecker.beforeCalled(contentPath, List.class, 2061, 79660, 79670);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(contentPath, List.class, 2061, 79660, 79670).get(i), Content.class, 2061, 79660, 79677)) {
                                contentPath = CallChecker.beforeCalled(contentPath, List.class, 2061, 79660, 79670);
                                bytes = CallChecker.isCalled(CallChecker.isCalled(contentPath, List.class, 2061, 79660, 79670).get(i), Content.class, 2061, 79660, 79677).getEntryAsBytes(actual);
                                CallChecker.varAssign(bytes, "bytes", 2061, 79652, 79702);
                            }
                        }
                        if (CallChecker.beforeDeref(contentPath, List.class, 2062, 79734, 79744)) {
                            contentPath = CallChecker.beforeCalled(contentPath, List.class, 2062, 79734, 79744);
                            content = CallChecker.isCalled(contentPath, List.class, 2062, 79734, 79744).get(i);
                            CallChecker.varAssign(content, "content", 2062, 79724, 79752);
                        }
                    }
                    if (bytes != null) {
                        String pkgName = CallChecker.varInit(Util.getClassPackage(name), "pkgName", 2068, 79887, 79930);
                        Felix felix = CallChecker.init(Felix.class);
                        if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2077, 80433, 80440)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2077, 80433, 80440).m_revision, BundleRevisionImpl.class, 2077, 80433, 80451)) {
                                final BundleImpl npe_invocation_var352 = ((BundleImpl) (CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2077, 80433, 80440).m_revision, BundleRevisionImpl.class, 2077, 80433, 80451).getBundle()));
                                if (CallChecker.beforeDeref(npe_invocation_var352, BundleImpl.class, 2077, 80433, 80463)) {
                                    felix = CallChecker.isCalled(npe_invocation_var352, BundleImpl.class, 2077, 80433, 80463).getFramework();
                                    CallChecker.varAssign(felix, "felix", 2077, 80433, 80440);
                                }
                            }
                        }
                        Set<ServiceReference<WeavingHook>> hooks = CallChecker.init(Set.class);
                        if (CallChecker.beforeDeref(felix, Felix.class, 2080, 80570, 80574)) {
                            felix = CallChecker.beforeCalled(felix, Felix.class, 2080, 80570, 80574);
                            hooks = CallChecker.isCalled(felix, Felix.class, 2080, 80570, 80574).getHooks(WeavingHook.class);
                            CallChecker.varAssign(hooks, "hooks", 2080, 80570, 80574);
                        }
                        Set<ServiceReference<WovenClassListener>> wovenClassListeners = CallChecker.init(Set.class);
                        if (CallChecker.beforeDeref(felix, Felix.class, 2083, 80714, 80718)) {
                            felix = CallChecker.beforeCalled(felix, Felix.class, 2083, 80714, 80718);
                            wovenClassListeners = CallChecker.isCalled(felix, Felix.class, 2083, 80714, 80718).getHooks(WovenClassListener.class);
                            CallChecker.varAssign(wovenClassListeners, "wovenClassListeners", 2083, 80714, 80718);
                        }
                        WovenClassImpl wci = CallChecker.varInit(null, "wci", 2085, 80777, 80802);
                        if (CallChecker.beforeDeref(hooks, Set.class, 2086, 80829, 80833)) {
                            hooks = CallChecker.beforeCalled(hooks, Set.class, 2086, 80829, 80833);
                            if (!(CallChecker.isCalled(hooks, Set.class, 2086, 80829, 80833).isEmpty())) {
                                wci = new WovenClassImpl(name, m_wiring, bytes);
                                CallChecker.varAssign(wci, "wci", 2089, 80960, 81007);
                                TryContext _bcornu_try_context_299 = new TryContext(299, BundleWiringImpl.class, "java.lang.Error");
                                try {
                                    transformClass(felix, wci, hooks, wovenClassListeners, name, bytes);
                                } catch (Error e) {
                                    _bcornu_try_context_299.catchStart(299);
                                    if (CallChecker.beforeDeref(wci, WovenClassImpl.class, 2098, 81383, 81385)) {
                                        wci = CallChecker.beforeCalled(wci, WovenClassImpl.class, 2098, 81383, 81385);
                                        CallChecker.isCalled(wci, WovenClassImpl.class, 2098, 81383, 81385).complete(null, null, null);
                                    }
                                    if (CallChecker.beforeDeref(wci, WovenClassImpl.class, 2099, 81443, 81445)) {
                                        wci = CallChecker.beforeCalled(wci, WovenClassImpl.class, 2099, 81443, 81445);
                                        CallChecker.isCalled(wci, WovenClassImpl.class, 2099, 81443, 81445).setState(WovenClass.TRANSFORMING_FAILED);
                                    }
                                    callWovenClassListeners(felix, wovenClassListeners, wci);
                                    throw e;
                                } finally {
                                    _bcornu_try_context_299.finallyStart(299);
                                }
                            }
                        }
                        Object lock = CallChecker.init(Object.class);
                        if (isParallel()) {
                            lock = m_classLocks;
                            CallChecker.varAssign(lock, "lock", 2107, 81922, 81957);
                        }else {
                            lock = this;
                            CallChecker.varAssign(lock, "lock", 2107, 81922, 81957);
                        }
                        synchronized(lock) {
                            Thread me = CallChecker.varInit(Thread.currentThread(), "me", 2110, 82046, 82080);
                            while ((CallChecker.isCalled(m_classLocks, Map.class, 2111, 82113, 82124).containsKey(name)) && ((CallChecker.isCalled(m_classLocks, Map.class, 2111, 82148, 82159).get(name)) != me)) {
                                TryContext _bcornu_try_context_300 = new TryContext(300, BundleWiringImpl.class, "java.lang.InterruptedException");
                                try {
                                    if (CallChecker.beforeDeref(lock, Object.class, 2115, 82299, 82302)) {
                                        lock = CallChecker.beforeCalled(lock, Object.class, 2115, 82299, 82302);
                                        CallChecker.isCalled(lock, Object.class, 2115, 82299, 82302).wait();
                                    }
                                } catch (InterruptedException e) {
                                    _bcornu_try_context_300.catchStart(300);
                                    throw new RuntimeException(e);
                                } finally {
                                    _bcornu_try_context_300.finallyStart(300);
                                }
                            } 
                            clazz = findLoadedClass(name);
                            CallChecker.varAssign(clazz, "clazz", 2124, 82693, 82722);
                            if (clazz == null) {
                                if (CallChecker.beforeDeref(m_classLocks, Map.class, 2128, 82886, 82897)) {
                                    CallChecker.isCalled(m_classLocks, Map.class, 2128, 82886, 82897).put(name, me);
                                }
                            }
                        }
                        TryContext _bcornu_try_context_301 = new TryContext(301, BundleWiringImpl.class, "java.lang.ClassFormatError");
                        try {
                            clazz = defineClass(felix, wovenClassListeners, wci, name, clazz, bytes, content, pkgName, lock);
                            CallChecker.varAssign(clazz, "clazz", 2134, 83033, 83161);
                        } catch (ClassFormatError e) {
                            _bcornu_try_context_301.catchStart(301);
                            if (wci != null) {
                                wci.setState(WovenClass.DEFINE_FAILED);
                                callWovenClassListeners(felix, wovenClassListeners, wci);
                            }
                            throw e;
                        } finally {
                            _bcornu_try_context_301.finallyStart(301);
                        }
                        List deferredList = CallChecker.init(List.class);
                        if (CallChecker.beforeDeref(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2149, 83772, 83791)) {
                            deferredList = ((List) (CallChecker.isCalled(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2149, 83772, 83791).get()));
                            CallChecker.varAssign(deferredList, "deferredList", 2149, 83772, 83791);
                        }
                        deferredList = CallChecker.beforeCalled(deferredList, List.class, 2152, 83939, 83950);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(deferredList, List.class, 2152, 83939, 83950).get(0), Object.class, 2152, 83939, 83957)) {
                            deferredList = CallChecker.beforeCalled(deferredList, List.class, 2152, 83939, 83950);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(((Object[]) (CallChecker.isCalled(deferredList, List.class, 2152, 83939, 83950).get(0))), Object[].class, 2152, 83939, 83957)[0], Object.class, 2152, 83927, 83961)) {
                                CallChecker.isCalled(((Object[]) (deferredList.get(0))), Object[].class, 2152, 83939, 83957)[0] = CallChecker.beforeCalled(CallChecker.isCalled(((Object[]) (deferredList.get(0))), Object[].class, 2152, 83939, 83957)[0], Object.class, 2152, 83927, 83961);
                                if (((deferredList != null) && ((deferredList.size()) > 0)) && (CallChecker.isCalled(CallChecker.isCalled(((Object[]) (deferredList.get(0))), Object[].class, 2152, 83939, 83957)[0], Object.class, 2152, 83927, 83961).equals(name))) {
                                    if (CallChecker.beforeDeref(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2155, 84074, 84093)) {
                                        CallChecker.isCalled(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2155, 84074, 84093).set(null);
                                    }
                                    while (!(deferredList.isEmpty())) {
                                        Object[] lazy = CallChecker.varInit(((Object[]) (deferredList.remove(((deferredList.size()) - 1)))), "lazy", 2161, 84457, 84528);
                                        TryContext _bcornu_try_context_302 = new TryContext(302, BundleWiringImpl.class, "java.lang.Throwable");
                                        try {
                                            if (CallChecker.beforeDeref(felix, Felix.class, 2164, 84624, 84628)) {
                                                if (CallChecker.beforeDeref(lazy, Object[].class, 2164, 84673, 84678)) {
                                                    felix = CallChecker.beforeCalled(felix, Felix.class, 2164, 84624, 84628);
                                                    final Felix npe_invocation_var353 = CallChecker.isCalled(felix, Felix.class, 2164, 84624, 84628).getFramework();
                                                    if (CallChecker.beforeDeref(npe_invocation_var353, Felix.class, 2164, 84624, 84643)) {
                                                        lazy = CallChecker.beforeCalled(lazy, Object[].class, 2164, 84673, 84678);
                                                        CallChecker.isCalled(npe_invocation_var353, Felix.class, 2164, 84624, 84643).activateBundle(((BundleImpl) (CallChecker.isCalled(lazy, Object[].class, 2164, 84673, 84678)[1])), true);
                                                    }
                                                }
                                            }
                                        } catch (Throwable ex) {
                                            _bcornu_try_context_302.catchStart(302);
                                            if (CallChecker.beforeDeref(lazy, Object[].class, 2168, 84858, 84863)) {
                                                if (CallChecker.beforeDeref(m_logger, Logger.class, 2168, 84832, 84839)) {
                                                    lazy = CallChecker.beforeCalled(lazy, Object[].class, 2168, 84858, 84863);
                                                    CallChecker.isCalled(m_logger, Logger.class, 2168, 84832, 84839).log(((BundleImpl) (CallChecker.isCalled(lazy, Object[].class, 2168, 84858, 84863)[1])), Logger.LOG_WARNING, "Unable to lazily start bundle.", ex);
                                                }
                                            }
                                        } finally {
                                            _bcornu_try_context_302.finallyStart(302);
                                        }
                                    } 
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
                return clazz;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Class) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context951.methodEnd();
            }
        }

        Class defineClass(Felix felix, Set<ServiceReference<WovenClassListener>> wovenClassListeners, WovenClassImpl wci, String name, Class clazz, byte[] bytes, Content content, String pkgName, Object lock) throws ClassFormatError {
            MethodContext _bcornu_methode_context952 = new MethodContext(Class.class);
            try {
                CallChecker.varInit(this, "this", 2181, 85192, 95042);
                CallChecker.varInit(lock, "lock", 2181, 85192, 95042);
                CallChecker.varInit(pkgName, "pkgName", 2181, 85192, 95042);
                CallChecker.varInit(content, "content", 2181, 85192, 95042);
                CallChecker.varInit(bytes, "bytes", 2181, 85192, 95042);
                CallChecker.varInit(clazz, "clazz", 2181, 85192, 95042);
                CallChecker.varInit(name, "name", 2181, 85192, 95042);
                CallChecker.varInit(wci, "wci", 2181, 85192, 95042);
                CallChecker.varInit(wovenClassListeners, "wovenClassListeners", 2181, 85192, 95042);
                CallChecker.varInit(felix, "felix", 2181, 85192, 95042);
                CallChecker.varInit(this.m_logger, "m_logger", 2181, 85192, 95042);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2181, 85192, 95042);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2181, 85192, 95042);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2181, 85192, 95042);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2181, 85192, 95042);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2181, 85192, 95042);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2181, 85192, 95042);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2181, 85192, 95042);
                TryContext _bcornu_try_context_306 = new TryContext(306, BundleWiringImpl.class);
                try {
                    if (clazz == null) {
                        if (wci != null) {
                            bytes = wci._getBytes();
                            CallChecker.varAssign(bytes, "bytes", 2204, 86374, 86397);
                            List<String> wovenImports = CallChecker.varInit(wci.getDynamicImportsInternal(), "wovenImports", 2205, 86423, 86482);
                            List<BundleRequirement> allWovenReqs = CallChecker.varInit(new ArrayList<BundleRequirement>(), "allWovenReqs", 2209, 86665, 86770);
                            if (CallChecker.beforeDeref(wovenImports, Class.class, 2211, 86812, 86823)) {
                                for (String s : wovenImports) {
                                    TryContext _bcornu_try_context_303 = new TryContext(303, BundleWiringImpl.class, "org.osgi.framework.BundleException");
                                    try {
                                        List<BundleRequirement> wovenReqs = CallChecker.init(List.class);
                                        if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2217, 87101, 87108)) {
                                            wovenReqs = ManifestParser.parseDynamicImportHeader(m_logger, CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2217, 87101, 87108).m_revision, s);
                                            CallChecker.varAssign(wovenReqs, "wovenReqs", 2217, 87101, 87108);
                                        }
                                        if (CallChecker.beforeDeref(allWovenReqs, List.class, 2218, 87156, 87167)) {
                                            allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2218, 87156, 87167);
                                            CallChecker.isCalled(allWovenReqs, List.class, 2218, 87156, 87167).addAll(wovenReqs);
                                        }
                                    } catch (BundleException ex) {
                                        _bcornu_try_context_303.catchStart(303);
                                    } finally {
                                        _bcornu_try_context_303.finallyStart(303);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(allWovenReqs, List.class, 2228, 87654, 87665)) {
                                allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2228, 87654, 87665);
                                if (!(CallChecker.isCalled(allWovenReqs, List.class, 2228, 87654, 87665).isEmpty())) {
                                    Set<String> filters = CallChecker.varInit(new HashSet<String>(), "filters", 2232, 87872, 87915);
                                    if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2233, 87949, 87956)) {
                                        if ((CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2233, 87949, 87956).m_wovenReqs) != null) {
                                            for (BundleRequirement req : CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2235, 88070, 88077).m_wovenReqs) {
                                                if (CallChecker.beforeDeref(req, BundleRequirement.class, 2238, 88244, 88246)) {
                                                    final SimpleFilter npe_invocation_var354 = CallChecker.isCalled(((BundleRequirementImpl) (req)), BundleRequirementImpl.class, 2238, 88244, 88246).getFilter();
                                                    if (CallChecker.beforeDeref(npe_invocation_var354, SimpleFilter.class, 2238, 88219, 88304)) {
                                                        if (CallChecker.beforeDeref(filters, Set.class, 2237, 88162, 88168)) {
                                                            filters = CallChecker.beforeCalled(filters, Set.class, 2237, 88162, 88168);
                                                            CallChecker.isCalled(filters, Set.class, 2237, 88162, 88168).add(CallChecker.isCalled(npe_invocation_var354, SimpleFilter.class, 2238, 88219, 88304).toString());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    int idx = CallChecker.init(int.class);
                                    if (CallChecker.beforeDeref(allWovenReqs, List.class, 2244, 88554, 88565)) {
                                        allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2244, 88554, 88565);
                                        idx = CallChecker.isCalled(allWovenReqs, List.class, 2244, 88554, 88565).size();
                                        CallChecker.varAssign(idx, "idx", 2244, 88554, 88565);
                                    }
                                    allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2245, 88616, 88627);
                                    while (idx < (CallChecker.isCalled(allWovenReqs, List.class, 2245, 88616, 88627).size())) {
                                        BundleRequirement wovenReq = CallChecker.init(BundleRequirement.class);
                                        if (CallChecker.beforeDeref(allWovenReqs, List.class, 2247, 88728, 88739)) {
                                            allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2247, 88728, 88739);
                                            wovenReq = CallChecker.isCalled(allWovenReqs, List.class, 2247, 88728, 88739).get(idx);
                                            CallChecker.varAssign(wovenReq, "wovenReq", 2247, 88728, 88739);
                                        }
                                        String filter = CallChecker.init(String.class);
                                        if (CallChecker.beforeDeref(wovenReq, BundleRequirement.class, 2249, 88864, 88871)) {
                                            wovenReq = CallChecker.beforeCalled(wovenReq, BundleRequirementImpl.class, 2249, 88864, 88871);
                                            final SimpleFilter npe_invocation_var355 = CallChecker.isCalled(((BundleRequirementImpl) (wovenReq)), BundleRequirementImpl.class, 2249, 88864, 88871).getFilter();
                                            if (CallChecker.beforeDeref(npe_invocation_var355, SimpleFilter.class, 2248, 88799, 88884)) {
                                                filter = CallChecker.isCalled(npe_invocation_var355, SimpleFilter.class, 2248, 88799, 88884).toString();
                                                CallChecker.varAssign(filter, "filter", 2249, 88864, 88871);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(filters, Set.class, 2250, 88935, 88941)) {
                                            filters = CallChecker.beforeCalled(filters, Set.class, 2250, 88935, 88941);
                                            if (!(CallChecker.isCalled(filters, Set.class, 2250, 88935, 88941).contains(filter))) {
                                                if (CallChecker.beforeDeref(filters, Set.class, 2252, 89031, 89037)) {
                                                    filters = CallChecker.beforeCalled(filters, Set.class, 2252, 89031, 89037);
                                                    CallChecker.isCalled(filters, Set.class, 2252, 89031, 89037).add(filter);
                                                }
                                                idx++;
                                            }else {
                                                if (CallChecker.beforeDeref(allWovenReqs, List.class, 2257, 89236, 89247)) {
                                                    allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2257, 89236, 89247);
                                                    CallChecker.isCalled(allWovenReqs, List.class, 2257, 89236, 89247).remove(idx);
                                                }
                                            }
                                        }
                                    } 
                                    if (CallChecker.beforeDeref(allWovenReqs, List.class, 2261, 89431, 89442)) {
                                        allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2261, 89431, 89442);
                                        if (!(CallChecker.isCalled(allWovenReqs, List.class, 2261, 89431, 89442).isEmpty())) {
                                            if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2263, 89521, 89528)) {
                                                if ((CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2263, 89521, 89528).m_wovenReqs) != null) {
                                                    if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2265, 89644, 89651)) {
                                                        if (CallChecker.beforeDeref(allWovenReqs, List.class, 2265, 89621, 89632)) {
                                                            allWovenReqs = CallChecker.beforeCalled(allWovenReqs, List.class, 2265, 89621, 89632);
                                                            CallChecker.isCalled(allWovenReqs, List.class, 2265, 89621, 89632).addAll(0, CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2265, 89644, 89651).m_wovenReqs);
                                                        }
                                                    }
                                                }
                                            }
                                            if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2267, 89733, 89740)) {
                                                CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2267, 89733, 89740).m_wovenReqs = allWovenReqs;
                                                CallChecker.varAssign(CallChecker.isCalled(this.m_wiring, BundleWiringImpl.class, 2267, 89733, 89740).m_wovenReqs, "CallChecker.isCalled(this.m_wiring, BundleWiringImpl.class, 2267, 89733, 89740).m_wovenReqs", 2267, 89733, 89768);
                                            }
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        int activationPolicy = CallChecker.init(int.class);
                        final BundleImpl npe_invocation_var356 = ((BundleImpl) (getBundle()));
                        if (CallChecker.beforeDeref(npe_invocation_var356, BundleImpl.class, 2273, 89934, 89944)) {
                            if (CallChecker.isCalled(npe_invocation_var356, BundleImpl.class, 2273, 89934, 89944).isDeclaredActivationPolicyUsed()) {
                                final Bundle npe_invocation_var357 = getBundle();
                                if (CallChecker.beforeDeref(npe_invocation_var357, Bundle.class, 2274, 90032, 90042)) {
                                    final BundleRevisionImpl npe_invocation_var358 = ((BundleRevisionImpl) (CallChecker.isCalled(npe_invocation_var357, Bundle.class, 2274, 90032, 90042).adapt(BundleRevision.class)));
                                    if (CallChecker.beforeDeref(npe_invocation_var358, BundleRevisionImpl.class, 2274, 90032, 90107)) {
                                        activationPolicy = CallChecker.isCalled(npe_invocation_var358, BundleRevisionImpl.class, 2274, 90032, 90107).getDeclaredActivationPolicy();
                                        CallChecker.varAssign(activationPolicy, "activationPolicy", 2273, 89920, 90193);
                                    }
                                }
                            }else {
                                activationPolicy = BundleWiringImpl.EAGER_ACTIVATION;
                                CallChecker.varAssign(activationPolicy, "activationPolicy", 2273, 89920, 90193);
                            }
                        }
                        boolean isTriggerClass = CallChecker.init(boolean.class);
                        if (m_isActivationTriggered) {
                            isTriggerClass = false;
                            CallChecker.varAssign(isTriggerClass, "isTriggerClass", 2283, 90586, 90695);
                        }else {
                            if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2284, 90648, 90655)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2284, 90648, 90655).m_revision, BundleRevisionImpl.class, 2284, 90648, 90666)) {
                                    isTriggerClass = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2284, 90648, 90655).m_revision, BundleRevisionImpl.class, 2284, 90648, 90666).isActivationTrigger(pkgName);
                                    CallChecker.varAssign(isTriggerClass, "isTriggerClass", 2283, 90586, 90695);
                                }
                            }
                        }
                        final Bundle npe_invocation_var359 = getBundle();
                        if (CallChecker.beforeDeref(npe_invocation_var359, Bundle.class, 2288, 90913, 90923)) {
                            if ((((!(m_isActivationTriggered)) && isTriggerClass) && (activationPolicy == (BundleRevisionImpl.LAZY_ACTIVATION))) && ((CallChecker.isCalled(npe_invocation_var359, Bundle.class, 2288, 90913, 90923).getState()) == (Bundle.STARTING))) {
                                List deferredList = CallChecker.init(List.class);
                                if (CallChecker.beforeDeref(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2290, 91030, 91049)) {
                                    deferredList = ((List) (CallChecker.isCalled(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2290, 91030, 91049).get()));
                                    CallChecker.varAssign(deferredList, "deferredList", 2290, 91030, 91049);
                                }
                                if (deferredList == null) {
                                    deferredList = new ArrayList();
                                    CallChecker.varAssign(deferredList, "deferredList", 2293, 91162, 91192);
                                    if (CallChecker.beforeDeref(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2294, 91222, 91241)) {
                                        CallChecker.isCalled(BundleWiringImpl.m_deferredActivation, ThreadLocal.class, 2294, 91222, 91241).set(deferredList);
                                    }
                                }
                                if (CallChecker.beforeDeref(deferredList, List.class, 2296, 91312, 91323)) {
                                    deferredList = CallChecker.beforeCalled(deferredList, List.class, 2296, 91312, 91323);
                                    CallChecker.isCalled(deferredList, List.class, 2296, 91312, 91323).add(new Object[]{ name , getBundle() });
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(pkgName, String.class, 2301, 91600, 91606)) {
                            pkgName = CallChecker.beforeCalled(pkgName, String.class, 2301, 91600, 91606);
                            if ((CallChecker.isCalled(pkgName, String.class, 2301, 91600, 91606).length()) > 0) {
                                if ((getPackage(pkgName)) == null) {
                                    Object[] params = CallChecker.varInit(definePackage(pkgName), "params", 2305, 91755, 91795);
                                    TryContext _bcornu_try_context_304 = new TryContext(304, BundleWiringImpl.class, "java.lang.IllegalArgumentException");
                                    try {
                                        if (CallChecker.beforeDeref(params, Object[].class, 2315, 92298, 92303)) {
                                            if (CallChecker.beforeDeref(params, Object[].class, 2316, 92358, 92363)) {
                                                if (CallChecker.beforeDeref(params, Object[].class, 2317, 92418, 92423)) {
                                                    if (CallChecker.beforeDeref(params, Object[].class, 2318, 92478, 92483)) {
                                                        if (CallChecker.beforeDeref(params, Object[].class, 2319, 92538, 92543)) {
                                                            if (CallChecker.beforeDeref(params, Object[].class, 2320, 92598, 92603)) {
                                                                params = CallChecker.beforeCalled(params, Object[].class, 2315, 92298, 92303);
                                                                params = CallChecker.beforeCalled(params, Object[].class, 2316, 92358, 92363);
                                                                params = CallChecker.beforeCalled(params, Object[].class, 2317, 92418, 92423);
                                                                params = CallChecker.beforeCalled(params, Object[].class, 2318, 92478, 92483);
                                                                params = CallChecker.beforeCalled(params, Object[].class, 2319, 92538, 92543);
                                                                params = CallChecker.beforeCalled(params, Object[].class, 2320, 92598, 92603);
                                                                definePackage(pkgName, ((String) (CallChecker.isCalled(params, Object[].class, 2315, 92298, 92303)[0])), ((String) (CallChecker.isCalled(params, Object[].class, 2316, 92358, 92363)[1])), ((String) (CallChecker.isCalled(params, Object[].class, 2317, 92418, 92423)[2])), ((String) (CallChecker.isCalled(params, Object[].class, 2318, 92478, 92483)[3])), ((String) (CallChecker.isCalled(params, Object[].class, 2319, 92538, 92543)[4])), ((String) (CallChecker.isCalled(params, Object[].class, 2320, 92598, 92603)[5])), null);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } catch (IllegalArgumentException ex) {
                                        _bcornu_try_context_304.catchStart(304);
                                    } finally {
                                        _bcornu_try_context_304.finallyStart(304);
                                    }
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (content instanceof JarContent) {
                            TryContext _bcornu_try_context_305 = new TryContext(305, BundleWiringImpl.class, "java.lang.Exception");
                            try {
                                clazz = getDexFileClass(((JarContent) (content)), name, this);
                                CallChecker.varAssign(clazz, "clazz", 2335, 93131, 93188);
                            } catch (Exception ex) {
                                _bcornu_try_context_305.catchStart(305);
                            } finally {
                                _bcornu_try_context_305.finallyStart(305);
                            }
                        }
                        if (clazz == null) {
                            if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2348, 93707, 93714)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2348, 93707, 93714).m_revision, BundleRevisionImpl.class, 2348, 93707, 93725)) {
                                    if ((CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2348, 93707, 93714).m_revision, BundleRevisionImpl.class, 2348, 93707, 93725).getProtectionDomain()) != null) {
                                        if (CallChecker.beforeDeref(bytes, byte[].class, 2350, 93848, 93852)) {
                                            if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2351, 93898, 93905)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2351, 93898, 93905).m_revision, BundleRevisionImpl.class, 2351, 93898, 93916)) {
                                                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 2350, 93848, 93852);
                                                    clazz = defineClass(name, bytes, 0, CallChecker.isCalled(bytes, byte[].class, 2350, 93848, 93852).length, CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2351, 93898, 93905).m_revision, BundleRevisionImpl.class, 2351, 93898, 93916).getProtectionDomain());
                                                    CallChecker.varAssign(clazz, "clazz", 2350, 93812, 93940);
                                                }
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(bytes, byte[].class, 2355, 94087, 94091)) {
                                            bytes = CallChecker.beforeCalled(bytes, byte[].class, 2355, 94087, 94091);
                                            clazz = defineClass(name, bytes, 0, CallChecker.isCalled(bytes, byte[].class, 2355, 94087, 94091).length);
                                            CallChecker.varAssign(clazz, "clazz", 2355, 94051, 94100);
                                        }
                                    }
                                }
                            }
                            if (wci != null) {
                                wci.completeDefine(clazz);
                                wci.setState(WovenClass.DEFINED);
                                callWovenClassListeners(felix, wovenClassListeners, wci);
                            }
                        }
                        if (((!(m_isActivationTriggered)) && isTriggerClass) && (clazz != null)) {
                            m_isActivationTriggered = true;
                            CallChecker.varAssign(this.m_isActivationTriggered, "this.m_isActivationTriggered", 2369, 94717, 94747);
                        }
                    }
                } finally {
                    _bcornu_try_context_306.finallyStart(306);
                    synchronized(lock) {
                        if (CallChecker.beforeDeref(m_classLocks, Map.class, 2377, 94911, 94922)) {
                            CallChecker.isCalled(m_classLocks, Map.class, 2377, 94911, 94922).remove(name);
                        }
                        if (CallChecker.beforeDeref(lock, Object.class, 2378, 94958, 94961)) {
                            lock = CallChecker.beforeCalled(lock, Object.class, 2378, 94958, 94961);
                            CallChecker.isCalled(lock, Object.class, 2378, 94958, 94961).notifyAll();
                        }
                    }
                }
                return clazz;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Class) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context952.methodEnd();
            }
        }

        void transformClass(Felix felix, WovenClassImpl wci, Set<ServiceReference<WeavingHook>> hooks, Set<ServiceReference<WovenClassListener>> wovenClassListeners, String name, byte[] bytes) throws Error {
            MethodContext _bcornu_methode_context953 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 2384, 95053, 97202);
                CallChecker.varInit(bytes, "bytes", 2384, 95053, 97202);
                CallChecker.varInit(name, "name", 2384, 95053, 97202);
                CallChecker.varInit(wovenClassListeners, "wovenClassListeners", 2384, 95053, 97202);
                CallChecker.varInit(hooks, "hooks", 2384, 95053, 97202);
                CallChecker.varInit(wci, "wci", 2384, 95053, 97202);
                CallChecker.varInit(felix, "felix", 2384, 95053, 97202);
                CallChecker.varInit(this.m_logger, "m_logger", 2384, 95053, 97202);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2384, 95053, 97202);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2384, 95053, 97202);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2384, 95053, 97202);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2384, 95053, 97202);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2384, 95053, 97202);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2384, 95053, 97202);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2384, 95053, 97202);
                if (CallChecker.beforeDeref(hooks, void.class, 2390, 95414, 95418)) {
                    for (ServiceReference<WeavingHook> sr : hooks) {
                        if (CallChecker.beforeDeref(felix, Felix.class, 2393, 95520, 95524)) {
                            felix = CallChecker.beforeCalled(felix, Felix.class, 2393, 95520, 95524);
                            if (!(CallChecker.isCalled(felix, Felix.class, 2393, 95520, 95524).isHookBlackListed(sr))) {
                                WeavingHook wh = CallChecker.init(WeavingHook.class);
                                if (CallChecker.beforeDeref(felix, Felix.class, 2399, 95836, 95840)) {
                                    felix = CallChecker.beforeCalled(felix, Felix.class, 2399, 95836, 95840);
                                    wh = CallChecker.isCalled(felix, Felix.class, 2399, 95836, 95840).getService(felix, sr, false);
                                    CallChecker.varAssign(wh, "wh", 2399, 95836, 95840);
                                }
                                if (wh != null) {
                                    TryContext _bcornu_try_context_307 = new TryContext(307, BundleWiringImpl.class, "java.lang.Throwable");
                                    try {
                                        final SecureAction npe_invocation_var360 = BundleRevisionImpl.getSecureAction();
                                        if (CallChecker.beforeDeref(npe_invocation_var360, SecureAction.class, 2404, 96012, 96047)) {
                                            CallChecker.isCalled(npe_invocation_var360, SecureAction.class, 2404, 96012, 96047).invokeWeavingHook(wh, wci);
                                        }
                                    } catch (Throwable th) {
                                        _bcornu_try_context_307.catchStart(307);
                                        if (!(th instanceof WeavingException)) {
                                            if (CallChecker.beforeDeref(felix, Felix.class, 2411, 96336, 96340)) {
                                                felix = CallChecker.beforeCalled(felix, Felix.class, 2411, 96336, 96340);
                                                CallChecker.isCalled(felix, Felix.class, 2411, 96336, 96340).blackListHook(sr);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(sr, ServiceReference.class, 2415, 96539, 96540)) {
                                            if (CallChecker.beforeDeref(felix, Felix.class, 2413, 96419, 96423)) {
                                                felix = CallChecker.beforeCalled(felix, Felix.class, 2413, 96419, 96423);
                                                CallChecker.isCalled(felix, Felix.class, 2413, 96419, 96423).fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(sr, ServiceReference.class, 2415, 96539, 96540).getBundle(), th);
                                            }
                                        }
                                        Error error = CallChecker.varInit(new ClassFormatError("Weaving hook failed."), "error", 2419, 96695, 96753);
                                        if (CallChecker.beforeDeref(error, Error.class, 2420, 96783, 96787)) {
                                            error = CallChecker.beforeCalled(error, Error.class, 2420, 96783, 96787);
                                            CallChecker.isCalled(error, Error.class, 2420, 96783, 96787).initCause(th);
                                        }
                                        throw error;
                                    } finally {
                                        _bcornu_try_context_307.finallyStart(307);
                                        if (CallChecker.beforeDeref(felix, Felix.class, 2425, 96957, 96961)) {
                                            felix = CallChecker.beforeCalled(felix, Felix.class, 2425, 96957, 96961);
                                            CallChecker.isCalled(felix, Felix.class, 2425, 96957, 96961).ungetService(felix, sr, null);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(wci, WovenClassImpl.class, 2430, 97086, 97088)) {
                    wci = CallChecker.beforeCalled(wci, WovenClassImpl.class, 2430, 97086, 97088);
                    CallChecker.isCalled(wci, WovenClassImpl.class, 2430, 97086, 97088).setState(WovenClass.TRANSFORMED);
                }
                callWovenClassListeners(felix, wovenClassListeners, wci);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context953.methodEnd();
            }
        }

        protected void callWovenClassListeners(Felix felix, Set<ServiceReference<WovenClassListener>> wovenClassListeners, WovenClass wovenClass) {
            MethodContext _bcornu_methode_context954 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 2434, 97213, 98240);
                CallChecker.varInit(wovenClass, "wovenClass", 2434, 97213, 98240);
                CallChecker.varInit(wovenClassListeners, "wovenClassListeners", 2434, 97213, 98240);
                CallChecker.varInit(felix, "felix", 2434, 97213, 98240);
                CallChecker.varInit(this.m_logger, "m_logger", 2434, 97213, 98240);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2434, 97213, 98240);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2434, 97213, 98240);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2434, 97213, 98240);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2434, 97213, 98240);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2434, 97213, 98240);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2434, 97213, 98240);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2434, 97213, 98240);
                if (wovenClassListeners != null) {
                    for (ServiceReference<WovenClassListener> currentWovenClassListenerRef : wovenClassListeners) {
                        WovenClassListener currentWovenClassListner = CallChecker.init(WovenClassListener.class);
                        if (CallChecker.beforeDeref(felix, Felix.class, 2440, 97612, 97616)) {
                            felix = CallChecker.beforeCalled(felix, Felix.class, 2440, 97612, 97616);
                            currentWovenClassListner = CallChecker.isCalled(felix, Felix.class, 2440, 97612, 97616).getService(felix, currentWovenClassListenerRef, false);
                            CallChecker.varAssign(currentWovenClassListner, "currentWovenClassListner", 2440, 97612, 97616);
                        }
                        TryContext _bcornu_try_context_308 = new TryContext(308, BundleWiringImpl.class, "java.lang.Exception");
                        try {
                            final SecureAction npe_invocation_var361 = BundleRevisionImpl.getSecureAction();
                            if (CallChecker.beforeDeref(npe_invocation_var361, SecureAction.class, 2443, 97744, 97779)) {
                                CallChecker.isCalled(npe_invocation_var361, SecureAction.class, 2443, 97744, 97779).invokeWovenClassListener(currentWovenClassListner, wovenClass);
                            }
                        } catch (Exception e) {
                            _bcornu_try_context_308.catchStart(308);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 2447, 97953, 97960)) {
                                CallChecker.isCalled(m_logger, Logger.class, 2447, 97953, 97960).log(Logger.LOG_ERROR, "Woven Class Listner failed.", e);
                            }
                        } finally {
                            _bcornu_try_context_308.finallyStart(308);
                            if (CallChecker.beforeDeref(felix, Felix.class, 2451, 98115, 98119)) {
                                felix = CallChecker.beforeCalled(felix, Felix.class, 2451, 98115, 98119);
                                CallChecker.isCalled(felix, Felix.class, 2451, 98115, 98119).ungetService(felix, currentWovenClassListenerRef, null);
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context954.methodEnd();
            }
        }

        private Object[] definePackage(String pkgName) {
            MethodContext _bcornu_methode_context955 = new MethodContext(Object[].class);
            try {
                CallChecker.varInit(this, "this", 2457, 98251, 99421);
                CallChecker.varInit(pkgName, "pkgName", 2457, 98251, 99421);
                CallChecker.varInit(this.m_logger, "m_logger", 2457, 98251, 99421);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2457, 98251, 99421);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2457, 98251, 99421);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2457, 98251, 99421);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2457, 98251, 99421);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2457, 98251, 99421);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2457, 98251, 99421);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2457, 98251, 99421);
                String spectitle = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2459, 98348, 98355)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2459, 98348, 98355).m_revision, BundleRevisionImpl.class, 2459, 98348, 98366)) {
                        final Map npe_invocation_var362 = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2459, 98348, 98355).m_revision, BundleRevisionImpl.class, 2459, 98348, 98366).getHeaders();
                        if (CallChecker.beforeDeref(npe_invocation_var362, Map.class, 2459, 98348, 98379)) {
                            spectitle = ((String) (CallChecker.isCalled(npe_invocation_var362, Map.class, 2459, 98348, 98379).get("Specification-Title")));
                            CallChecker.varAssign(spectitle, "spectitle", 2459, 98348, 98355);
                        }
                    }
                }
                String specversion = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2460, 98451, 98458)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2460, 98451, 98458).m_revision, BundleRevisionImpl.class, 2460, 98451, 98469)) {
                        final Map npe_invocation_var363 = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2460, 98451, 98458).m_revision, BundleRevisionImpl.class, 2460, 98451, 98469).getHeaders();
                        if (CallChecker.beforeDeref(npe_invocation_var363, Map.class, 2460, 98451, 98482)) {
                            specversion = ((String) (CallChecker.isCalled(npe_invocation_var363, Map.class, 2460, 98451, 98482).get("Specification-Version")));
                            CallChecker.varAssign(specversion, "specversion", 2460, 98451, 98458);
                        }
                    }
                }
                String specvendor = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2461, 98555, 98562)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2461, 98555, 98562).m_revision, BundleRevisionImpl.class, 2461, 98555, 98573)) {
                        final Map npe_invocation_var364 = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2461, 98555, 98562).m_revision, BundleRevisionImpl.class, 2461, 98555, 98573).getHeaders();
                        if (CallChecker.beforeDeref(npe_invocation_var364, Map.class, 2461, 98555, 98586)) {
                            specvendor = ((String) (CallChecker.isCalled(npe_invocation_var364, Map.class, 2461, 98555, 98586).get("Specification-Vendor")));
                            CallChecker.varAssign(specvendor, "specvendor", 2461, 98555, 98562);
                        }
                    }
                }
                String impltitle = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2462, 98657, 98664)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2462, 98657, 98664).m_revision, BundleRevisionImpl.class, 2462, 98657, 98675)) {
                        final Map npe_invocation_var365 = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2462, 98657, 98664).m_revision, BundleRevisionImpl.class, 2462, 98657, 98675).getHeaders();
                        if (CallChecker.beforeDeref(npe_invocation_var365, Map.class, 2462, 98657, 98688)) {
                            impltitle = ((String) (CallChecker.isCalled(npe_invocation_var365, Map.class, 2462, 98657, 98688).get("Implementation-Title")));
                            CallChecker.varAssign(impltitle, "impltitle", 2462, 98657, 98664);
                        }
                    }
                }
                String implversion = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2463, 98761, 98768)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2463, 98761, 98768).m_revision, BundleRevisionImpl.class, 2463, 98761, 98779)) {
                        final Map npe_invocation_var366 = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2463, 98761, 98768).m_revision, BundleRevisionImpl.class, 2463, 98761, 98779).getHeaders();
                        if (CallChecker.beforeDeref(npe_invocation_var366, Map.class, 2463, 98761, 98792)) {
                            implversion = ((String) (CallChecker.isCalled(npe_invocation_var366, Map.class, 2463, 98761, 98792).get("Implementation-Version")));
                            CallChecker.varAssign(implversion, "implversion", 2463, 98761, 98768);
                        }
                    }
                }
                String implvendor = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2464, 98866, 98873)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2464, 98866, 98873).m_revision, BundleRevisionImpl.class, 2464, 98866, 98884)) {
                        final Map npe_invocation_var367 = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2464, 98866, 98873).m_revision, BundleRevisionImpl.class, 2464, 98866, 98884).getHeaders();
                        if (CallChecker.beforeDeref(npe_invocation_var367, Map.class, 2464, 98866, 98897)) {
                            implvendor = ((String) (CallChecker.isCalled(npe_invocation_var367, Map.class, 2464, 98866, 98897).get("Implementation-Vendor")));
                            CallChecker.varAssign(implvendor, "implvendor", 2464, 98866, 98873);
                        }
                    }
                }
                if ((((((spectitle != null) || (specversion != null)) || (specvendor != null)) || (impltitle != null)) || (implversion != null)) || (implvendor != null)) {
                    return new Object[]{ spectitle , specversion , specvendor , impltitle , implversion , implvendor };
                }
                return new Object[]{ null , null , null , null , null , null };
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context955.methodEnd();
            }
        }

        private Class getDexFileClass(JarContent content, String name, ClassLoader loader) throws Exception {
            MethodContext _bcornu_methode_context956 = new MethodContext(Class.class);
            try {
                CallChecker.varInit(this, "this", 2479, 99432, 100856);
                CallChecker.varInit(loader, "loader", 2479, 99432, 100856);
                CallChecker.varInit(name, "name", 2479, 99432, 100856);
                CallChecker.varInit(content, "content", 2479, 99432, 100856);
                CallChecker.varInit(this.m_logger, "m_logger", 2479, 99432, 100856);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2479, 99432, 100856);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2479, 99432, 100856);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2479, 99432, 100856);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2479, 99432, 100856);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2479, 99432, 100856);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2479, 99432, 100856);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2479, 99432, 100856);
                if ((m_jarContentToDexFile) == null) {
                    return null;
                }
                Object dexFile = CallChecker.varInit(null, "dexFile", 2487, 99671, 99692);
                if (!(m_jarContentToDexFile.containsKey(content))) {
                    TryContext _bcornu_try_context_309 = new TryContext(309, BundleWiringImpl.class);
                    try {
                        if ((BundleWiringImpl.m_dexFileClassLoadDex) != null) {
                            if (CallChecker.beforeDeref(content, JarContent.class, 2496, 99995, 100001)) {
                                content = CallChecker.beforeCalled(content, JarContent.class, 2496, 99995, 100001);
                                final File npe_invocation_var368 = CallChecker.isCalled(content, JarContent.class, 2496, 99995, 100001).getFile();
                                if (CallChecker.beforeDeref(npe_invocation_var368, File.class, 2496, 99995, 100011)) {
                                    if (CallChecker.beforeDeref(content, JarContent.class, 2497, 100064, 100070)) {
                                        content = CallChecker.beforeCalled(content, JarContent.class, 2497, 100064, 100070);
                                        final File npe_invocation_var369 = CallChecker.isCalled(content, JarContent.class, 2497, 100064, 100070).getFile();
                                        if (CallChecker.beforeDeref(npe_invocation_var369, File.class, 2497, 100064, 100080)) {
                                            dexFile = BundleWiringImpl.m_dexFileClassLoadDex.invoke(null, new Object[]{ CallChecker.isCalled(npe_invocation_var368, File.class, 2496, 99995, 100011).getAbsolutePath() , (CallChecker.isCalled(npe_invocation_var369, File.class, 2497, 100064, 100080).getAbsolutePath()) + ".dex" , new Integer(0) });
                                            CallChecker.varAssign(dexFile, "dexFile", 2495, 99909, 100126);
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(content, JarContent.class, 2502, 100313, 100319)) {
                                if (CallChecker.beforeDeref(BundleWiringImpl.m_dexFileClassConstructor, Constructor.class, 2501, 100231, 100255)) {
                                    content = CallChecker.beforeCalled(content, JarContent.class, 2502, 100313, 100319);
                                    dexFile = CallChecker.isCalled(BundleWiringImpl.m_dexFileClassConstructor, Constructor.class, 2501, 100231, 100255).newInstance(new Object[]{ CallChecker.isCalled(content, JarContent.class, 2502, 100313, 100319).getFile() });
                                    CallChecker.varAssign(dexFile, "dexFile", 2501, 100221, 100333);
                                }
                            }
                        }
                    } finally {
                        _bcornu_try_context_309.finallyStart(309);
                        m_jarContentToDexFile.put(content, dexFile);
                    }
                }else {
                    dexFile = m_jarContentToDexFile.get(content);
                    CallChecker.varAssign(dexFile, "dexFile", 2512, 100561, 100605);
                }
                if (dexFile != null) {
                    if (CallChecker.beforeDeref(name, String.class, 2518, 100775, 100778)) {
                        if (CallChecker.beforeDeref(BundleWiringImpl.m_dexFileClassLoadClass, Method.class, 2517, 100700, 100722)) {
                            name = CallChecker.beforeCalled(name, String.class, 2518, 100775, 100778);
                            return ((Class) (CallChecker.isCalled(BundleWiringImpl.m_dexFileClassLoadClass, Method.class, 2517, 100700, 100722).invoke(dexFile, new Object[]{ CallChecker.isCalled(name, String.class, 2518, 100775, 100778).replace('.', '/') , loader })));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Class) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context956.methodEnd();
            }
        }

        @Override
        public URL getResource(String name) {
            MethodContext _bcornu_methode_context957 = new MethodContext(URL.class);
            try {
                CallChecker.varInit(this, "this", 2524, 100867, 101140);
                CallChecker.varInit(name, "name", 2524, 100867, 101140);
                CallChecker.varInit(this.m_logger, "m_logger", 2524, 100867, 101140);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2524, 100867, 101140);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2524, 100867, 101140);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2524, 100867, 101140);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2524, 100867, 101140);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2524, 100867, 101140);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2524, 100867, 101140);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2524, 100867, 101140);
                URL url = CallChecker.init(URL.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2526, 100953, 100960)) {
                    url = CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2526, 100953, 100960).getResourceByDelegation(name);
                    CallChecker.varAssign(url, "url", 2526, 100953, 100960);
                }
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2527, 101009, 101016)) {
                    if (CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2527, 101009, 101016).m_useLocalURLs) {
                        url = BundleWiringImpl.convertToLocalUrl(url);
                        CallChecker.varAssign(url, "url", 2529, 101064, 101092);
                    }
                }
                return url;
            } catch (ForceReturn _bcornu_return_t) {
                return ((URL) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context957.methodEnd();
            }
        }

        @Override
        protected URL findResource(String name) {
            MethodContext _bcornu_methode_context958 = new MethodContext(URL.class);
            try {
                CallChecker.varInit(this, "this", 2535, 101151, 101290);
                CallChecker.varInit(name, "name", 2535, 101151, 101290);
                CallChecker.varInit(this.m_logger, "m_logger", 2535, 101151, 101290);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2535, 101151, 101290);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2535, 101151, 101290);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2535, 101151, 101290);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2535, 101151, 101290);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2535, 101151, 101290);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2535, 101151, 101290);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2535, 101151, 101290);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2537, 101238, 101245)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2537, 101238, 101245).m_revision, BundleRevisionImpl.class, 2537, 101238, 101256)) {
                        return CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2537, 101238, 101245).m_revision, BundleRevisionImpl.class, 2537, 101238, 101256).getResourceLocal(name);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((URL) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context958.methodEnd();
            }
        }

        @Override
        protected Enumeration findResources(String name) {
            MethodContext _bcornu_methode_context959 = new MethodContext(Enumeration.class);
            try {
                CallChecker.varInit(this, "this", 2546, 101301, 102013);
                CallChecker.varInit(name, "name", 2546, 101301, 102013);
                CallChecker.varInit(this.m_logger, "m_logger", 2546, 101301, 102013);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2546, 101301, 102013);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2546, 101301, 102013);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2546, 101301, 102013);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2546, 101301, 102013);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2546, 101301, 102013);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2546, 101301, 102013);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2546, 101301, 102013);
                Enumeration urls = CallChecker.init(Enumeration.class);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2548, 101814, 101821)) {
                    urls = CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2548, 101814, 101821).getResourcesByDelegation(name);
                    CallChecker.varAssign(urls, "urls", 2548, 101814, 101821);
                }
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2549, 101871, 101878)) {
                    if (CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2549, 101871, 101878).m_useLocalURLs) {
                        urls = new BundleWiringImpl.ToLocalUrlEnumeration(urls);
                        CallChecker.varAssign(urls, "urls", 2551, 101926, 101964);
                    }
                }
                return urls;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context959.methodEnd();
            }
        }

        @Override
        protected String findLibrary(String name) {
            MethodContext _bcornu_methode_context960 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 2557, 102024, 104758);
                CallChecker.varInit(name, "name", 2557, 102024, 104758);
                CallChecker.varInit(this.m_logger, "m_logger", 2557, 102024, 104758);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2557, 102024, 104758);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2557, 102024, 104758);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2557, 102024, 104758);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2557, 102024, 104758);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2557, 102024, 104758);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2557, 102024, 104758);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2557, 102024, 104758);
                if (CallChecker.beforeDeref(name, String.class, 2560, 102159, 102162)) {
                    name = CallChecker.beforeCalled(name, String.class, 2560, 102159, 102162);
                    if (CallChecker.isCalled(name, String.class, 2560, 102159, 102162).startsWith("/")) {
                        if (CallChecker.beforeDeref(name, String.class, 2562, 102218, 102221)) {
                            name = CallChecker.beforeCalled(name, String.class, 2562, 102218, 102221);
                            name = CallChecker.isCalled(name, String.class, 2562, 102218, 102221).substring(1);
                            CallChecker.varAssign(name, "name", 2562, 102211, 102235);
                        }
                    }
                }
                String result = CallChecker.varInit(null, "result", 2565, 102264, 102284);
                synchronized(this) {
                    m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2572, 102685, 102696);
                    for (int i = 0; (result == null) && (i < (CallChecker.isCalled(m_cachedLibs, Object[][].class, 2572, 102685, 102696).length)); i++) {
                        if (CallChecker.beforeDeref(m_cachedLibs, Object[][].class, 2574, 102754, 102765)) {
                            m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i], Object[].class, 2574, 102754, 102768)) {
                                m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765);
                                CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i] = CallChecker.beforeCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i], Object[].class, 2574, 102754, 102768);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i], Object[].class, 2574, 102754, 102768)[BundleWiringImpl.BundleClassLoader.LIBNAME_IDX], Object.class, 2574, 102754, 102781)) {
                                    m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765);
                                    CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i] = CallChecker.beforeCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i], Object[].class, 2574, 102754, 102768);
                                    CallChecker.isCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i], Object[].class, 2574, 102754, 102768)[BundleWiringImpl.BundleClassLoader.LIBNAME_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i], Object[].class, 2574, 102754, 102768)[BundleWiringImpl.BundleClassLoader.LIBNAME_IDX], Object.class, 2574, 102754, 102781);
                                    if (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2574, 102754, 102765)[i], Object[].class, 2574, 102754, 102768)[BundleWiringImpl.BundleClassLoader.LIBNAME_IDX], Object.class, 2574, 102754, 102781).equals(name)) {
                                        if (CallChecker.beforeDeref(m_cachedLibs, Object[][].class, 2576, 102861, 102872)) {
                                            m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2576, 102861, 102872);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2576, 102861, 102872)[i], Object[].class, 2576, 102861, 102875)) {
                                                m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2576, 102861, 102872);
                                                CallChecker.isCalled(m_cachedLibs, Object[][].class, 2576, 102861, 102872)[i] = CallChecker.beforeCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2576, 102861, 102872)[i], Object[].class, 2576, 102861, 102875);
                                                result = ((String) (CallChecker.isCalled(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2576, 102861, 102872)[i], Object[].class, 2576, 102861, 102875)[BundleWiringImpl.BundleClassLoader.LIBPATH_IDX]));
                                                CallChecker.varAssign(result, "result", 2576, 102843, 102889);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (result == null) {
                        List<NativeLibrary> libs = CallChecker.init(List.class);
                        if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2584, 103147, 103154)) {
                            libs = CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2584, 103147, 103154).getNativeLibraries();
                            CallChecker.varAssign(libs, "libs", 2584, 103147, 103154);
                        }
                        libs = CallChecker.beforeCalled(libs, List.class, 2585, 103247, 103250);
                        for (int libIdx = 0; (libs != null) && (libIdx < (CallChecker.isCalled(libs, List.class, 2585, 103247, 103250).size())); libIdx++) {
                            if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2587, 103344, 103351)) {
                                libs = CallChecker.beforeCalled(libs, List.class, 2587, 103321, 103324);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(libs, List.class, 2587, 103321, 103324).get(libIdx), NativeLibrary.class, 2587, 103321, 103336)) {
                                    if (CallChecker.isCalled(libs.get(libIdx), NativeLibrary.class, 2587, 103321, 103336).match(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2587, 103344, 103351).m_configMap, name)) {
                                        if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2590, 103515, 103522)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2590, 103515, 103522).m_revision, BundleRevisionImpl.class, 2590, 103515, 103533)) {
                                                libs = CallChecker.beforeCalled(libs, List.class, 2591, 103605, 103608);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(libs, List.class, 2591, 103605, 103608).get(libIdx), NativeLibrary.class, 2591, 103605, 103620)) {
                                                    final Content npe_invocation_var370 = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2590, 103515, 103522).m_revision, BundleRevisionImpl.class, 2590, 103515, 103533).getContent();
                                                    if (CallChecker.beforeDeref(npe_invocation_var370, Content.class, 2590, 103515, 103546)) {
                                                        result = CallChecker.isCalled(npe_invocation_var370, Content.class, 2590, 103515, 103546).getEntryAsNativeLibrary(CallChecker.isCalled(libs.get(libIdx), NativeLibrary.class, 2591, 103605, 103620).getEntryName());
                                                        CallChecker.varAssign(result, "result", 2590, 103506, 103637);
                                                    }
                                                }
                                            }
                                        }
                                        for (int i = 0; ((result == null) && ((CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2594, 103813, 103820).m_fragmentContents) != null)) && (i < (CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2595, 103894, 103901).m_fragmentContents, List.class, 2595, 103894, 103920).size())); i++) {
                                            if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2598, 104039, 104046)) {
                                                libs = CallChecker.beforeCalled(libs, List.class, 2599, 104135, 104138);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(libs, List.class, 2599, 104135, 104138).get(libIdx), NativeLibrary.class, 2599, 104135, 104150)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2598, 104039, 104046).m_fragmentContents, List.class, 2598, 104039, 104065).get(i), Content.class, 2598, 104039, 104072)) {
                                                        result = CallChecker.isCalled(CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2598, 104039, 104046).m_fragmentContents.get(i), Content.class, 2598, 104039, 104072).getEntryAsNativeLibrary(CallChecker.isCalled(libs.get(libIdx), NativeLibrary.class, 2599, 104135, 104150).getEntryName());
                                                        CallChecker.varAssign(result, "result", 2598, 104030, 104167);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        if (result != null) {
                            Object[][] tmp = CallChecker.init(Object[][].class);
                            if (CallChecker.beforeDeref(m_cachedLibs, Object[][].class, 2607, 104426, 104437)) {
                                m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2607, 104426, 104437);
                                tmp = new Object[(CallChecker.isCalled(m_cachedLibs, Object[][].class, 2607, 104426, 104437).length) + 1][];
                                CallChecker.varAssign(tmp, "tmp", 2607, 104426, 104437);
                            }
                            if (CallChecker.beforeDeref(m_cachedLibs, Object[][].class, 2608, 104520, 104531)) {
                                m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2608, 104520, 104531);
                                System.arraycopy(m_cachedLibs, 0, tmp, 0, CallChecker.isCalled(m_cachedLibs, Object[][].class, 2608, 104520, 104531).length);
                            }
                            if (CallChecker.beforeDeref(m_cachedLibs, Object[][].class, 2609, 104570, 104581)) {
                                if (CallChecker.beforeDeref(tmp, Object[][].class, 2609, 104566, 104568)) {
                                    m_cachedLibs = CallChecker.beforeCalled(m_cachedLibs, Object[][].class, 2609, 104570, 104581);
                                    tmp = CallChecker.beforeCalled(tmp, Object[][].class, 2609, 104566, 104568);
                                    CallChecker.isCalled(tmp, Object[][].class, 2609, 104566, 104568)[CallChecker.isCalled(m_cachedLibs, Object[][].class, 2609, 104570, 104581).length] = new Object[]{ name , result };
                                    CallChecker.varAssign(CallChecker.isCalled(tmp, Object[][].class, 2609, 104566, 104568)[CallChecker.isCalled(this.m_cachedLibs, Object[][].class, 2609, 104570, 104581).length], "CallChecker.isCalled(tmp, Object[][].class, 2609, 104566, 104568)[CallChecker.isCalled(this.m_cachedLibs, Object[][].class, 2609, 104570, 104581).length]", 2609, 104566, 104622);
                                }
                            }
                            m_cachedLibs = tmp;
                            CallChecker.varAssign(this.m_cachedLibs, "this.m_cachedLibs", 2610, 104648, 104666);
                        }
                    }
                }
                return result;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context960.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context961 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 2619, 104769, 104870);
                CallChecker.varInit(this.m_logger, "m_logger", 2619, 104769, 104870);
                CallChecker.varInit(this.m_wiring, "m_wiring", 2619, 104769, 104870);
                CallChecker.varInit(this.m_classLocks, "m_classLocks", 2619, 104769, 104870);
                CallChecker.varInit(LIBPATH_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBPATH_IDX", 2619, 104769, 104870);
                CallChecker.varInit(LIBNAME_IDX, "org.apache.felix.framework.BundleWiringImpl.BundleClassLoader.LIBNAME_IDX", 2619, 104769, 104870);
                CallChecker.varInit(this.m_cachedLibs, "m_cachedLibs", 2619, 104769, 104870);
                CallChecker.varInit(this.m_jarContentToDexFile, "m_jarContentToDexFile", 2619, 104769, 104870);
                CallChecker.varInit(this.m_isActivationTriggered, "m_isActivationTriggered", 2619, 104769, 104870);
                if (CallChecker.beforeDeref(m_wiring, BundleWiringImpl.class, 2621, 104841, 104848)) {
                    return CallChecker.isCalled(m_wiring, BundleWiringImpl.class, 2621, 104841, 104848).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context961.methodEnd();
            }
        }
    }

    static URL convertToLocalUrl(URL url) {
        MethodContext _bcornu_methode_context962 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(url, "url", 2625, 104883, 105287);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 2625, 104883, 105287);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 2625, 104883, 105287);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 2625, 104883, 105287);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 2625, 104883, 105287);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 2625, 104883, 105287);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 2625, 104883, 105287);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 2625, 104883, 105287);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 2625, 104883, 105287);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 2625, 104883, 105287);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 2625, 104883, 105287);
            if (CallChecker.beforeDeref(url, URL.class, 2627, 104939, 104941)) {
                url = CallChecker.beforeCalled(url, URL.class, 2627, 104939, 104941);
                if (CallChecker.beforeDeref(CallChecker.isCalled(url, URL.class, 2627, 104939, 104941).getProtocol(), String.class, 2627, 104939, 104955)) {
                    url = CallChecker.beforeCalled(url, URL.class, 2627, 104939, 104941);
                    if (CallChecker.isCalled(CallChecker.isCalled(url, URL.class, 2627, 104939, 104941).getProtocol(), String.class, 2627, 104939, 104955).equals("bundle")) {
                        TryContext _bcornu_try_context_310 = new TryContext(310, BundleWiringImpl.class, "java.io.IOException");
                        try {
                            if (CallChecker.beforeDeref(url, URL.class, 2632, 105091, 105093)) {
                                url = CallChecker.beforeCalled(url, URL.class, 2632, 105091, 105093);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(url, URL.class, 2632, 105091, 105093).openConnection(), URLConnection.class, 2632, 105091, 105110)) {
                                    url = CallChecker.beforeCalled(url, URL.class, 2632, 105091, 105093);
                                    url = CallChecker.isCalled(((URLHandlersBundleURLConnection) (CallChecker.isCalled(url, URL.class, 2632, 105091, 105093).openConnection())), URLHandlersBundleURLConnection.class, 2632, 105091, 105110).getLocalURL();
                                    CallChecker.varAssign(url, "url", 2631, 105031, 105126);
                                }
                            }
                        } catch (IOException ex) {
                            _bcornu_try_context_310.catchStart(310);
                        } finally {
                            _bcornu_try_context_310.finallyStart(310);
                        }
                    }
                }
            }
            return url;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context962.methodEnd();
        }
    }

    private static class ResourceSource implements Comparable<BundleWiringImpl.ResourceSource> {
        public final String m_resource;

        public final BundleRevision m_revision;

        public ResourceSource(String resource, BundleRevision revision) {
            MethodContext _bcornu_methode_context90 = new MethodContext(null);
            try {
                m_resource = resource;
                CallChecker.varAssign(this.m_resource, "this.m_resource", 2649, 105557, 105578);
                m_revision = revision;
                CallChecker.varAssign(this.m_revision, "this.m_revision", 2650, 105592, 105613);
            } finally {
                _bcornu_methode_context90.methodEnd();
            }
        }

        @Override
        public boolean equals(Object o) {
            MethodContext _bcornu_methode_context963 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 2654, 105634, 105876);
                CallChecker.varInit(o, "o", 2654, 105634, 105876);
                CallChecker.varInit(this.m_revision, "m_revision", 2654, 105634, 105876);
                CallChecker.varInit(this.m_resource, "m_resource", 2654, 105634, 105876);
                if (o instanceof BundleWiringImpl.ResourceSource) {
                    if (CallChecker.beforeDeref(o, Object.class, 2658, 105812, 105812)) {
                        if (CallChecker.beforeDeref(m_resource, String.class, 2658, 105776, 105785)) {
                            o = CallChecker.beforeCalled(o, BundleWiringImpl.ResourceSource.class, 2658, 105812, 105812);
                            return CallChecker.isCalled(m_resource, String.class, 2658, 105776, 105785).equals(CallChecker.isCalled(((BundleWiringImpl.ResourceSource) (o)), BundleWiringImpl.ResourceSource.class, 2658, 105812, 105812).m_resource);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context963.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context964 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 2664, 105887, 105987);
                CallChecker.varInit(this.m_revision, "m_revision", 2664, 105887, 105987);
                CallChecker.varInit(this.m_resource, "m_resource", 2664, 105887, 105987);
                if (CallChecker.beforeDeref(m_resource, String.class, 2666, 105956, 105965)) {
                    return CallChecker.isCalled(m_resource, String.class, 2666, 105956, 105965).hashCode();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context964.methodEnd();
            }
        }

        public int compareTo(BundleWiringImpl.ResourceSource t) {
            MethodContext _bcornu_methode_context965 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 2669, 105998, 106110);
                CallChecker.varInit(t, "t", 2669, 105998, 106110);
                CallChecker.varInit(this.m_revision, "m_revision", 2669, 105998, 106110);
                CallChecker.varInit(this.m_resource, "m_resource", 2669, 105998, 106110);
                if (CallChecker.beforeDeref(t, BundleWiringImpl.ResourceSource.class, 2671, 106087, 106087)) {
                    if (CallChecker.beforeDeref(m_resource, String.class, 2671, 106066, 106075)) {
                        t = CallChecker.beforeCalled(t, BundleWiringImpl.ResourceSource.class, 2671, 106087, 106087);
                        return CallChecker.isCalled(m_resource, String.class, 2671, 106066, 106075).compareTo(CallChecker.isCalled(t, BundleWiringImpl.ResourceSource.class, 2671, 106087, 106087).m_resource);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context965.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context966 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 2675, 106121, 106327);
                CallChecker.varInit(this.m_revision, "m_revision", 2675, 106121, 106327);
                CallChecker.varInit(this.m_resource, "m_resource", 2675, 106121, 106327);
                return (((((m_resource) + " -> ") + (CallChecker.isCalled(m_revision, BundleRevision.class, 2679, 106247, 106256).getSymbolicName())) + " [") + (m_revision)) + "]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context966.methodEnd();
            }
        }
    }

    private static String diagnoseClassLoadError(StatefulResolver resolver, BundleRevision revision, String name) {
        MethodContext _bcornu_methode_context967 = new MethodContext(String.class);
        try {
            CallChecker.varInit(name, "name", 2684, 106340, 117562);
            CallChecker.varInit(revision, "revision", 2684, 106340, 117562);
            CallChecker.varInit(resolver, "resolver", 2684, 106340, 117562);
            CallChecker.varInit(m_dexFileClassLoadClass, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadClass", 2684, 106340, 117562);
            CallChecker.varInit(m_dexFileClassLoadDex, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassLoadDex", 2684, 106340, 117562);
            CallChecker.varInit(m_dexFileClassConstructor, "org.apache.felix.framework.BundleWiringImpl.m_dexFileClassConstructor", 2684, 106340, 117562);
            CallChecker.varInit(BundleWiringImpl.m_isPreJava5, "org.apache.felix.framework.BundleWiringImpl.m_isPreJava5", 2684, 106340, 117562);
            CallChecker.varInit(m_deferredActivation, "org.apache.felix.framework.BundleWiringImpl.m_deferredActivation", 2684, 106340, 117562);
            CallChecker.varInit(BundleWiringImpl.m_sm, "org.apache.felix.framework.BundleWiringImpl.m_sm", 2684, 106340, 117562);
            CallChecker.varInit(m_defBootClassLoader, "org.apache.felix.framework.BundleWiringImpl.m_defBootClassLoader", 2684, 106340, 117562);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 2684, 106340, 117562);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 2684, 106340, 117562);
            CallChecker.varInit(LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 2684, 106340, 117562);
            String pkgName = CallChecker.varInit(Util.getClassPackage(name), "pkgName", 2691, 106613, 106656);
            if (CallChecker.beforeDeref(pkgName, String.class, 2692, 106670, 106676)) {
                pkgName = CallChecker.beforeCalled(pkgName, String.class, 2692, 106670, 106676);
                if ((CallChecker.isCalled(pkgName, String.class, 2692, 106670, 106676).length()) == 0) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            String importer = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 2698, 106845, 106852)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 2698, 106845, 106852);
                final Bundle npe_invocation_var371 = CallChecker.isCalled(revision, BundleRevision.class, 2698, 106845, 106852).getBundle();
                if (CallChecker.beforeDeref(npe_invocation_var371, Bundle.class, 2698, 106845, 106864)) {
                    importer = CallChecker.isCalled(npe_invocation_var371, Bundle.class, 2698, 106845, 106864).toString();
                    CallChecker.varAssign(importer, "importer", 2698, 106845, 106852);
                }
            }
            List<BundleWire> wires = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 2701, 106980, 106987)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 2701, 106980, 106987);
                if ((CallChecker.isCalled(revision, BundleRevision.class, 2701, 106980, 106987).getWiring()) == null) {
                    wires = null;
                    CallChecker.varAssign(wires, "wires", 2701, 106979, 107073);
                }else {
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 2702, 107031, 107038)) {
                        revision = CallChecker.beforeCalled(revision, BundleRevision.class, 2702, 107031, 107038);
                        wires = CallChecker.isCalled(revision, BundleRevision.class, 2702, 107031, 107038).getWiring().getProvidedWires(null);
                        CallChecker.varAssign(wires, "wires", 2701, 106979, 107073);
                    }
                }
            }
            wires = CallChecker.beforeCalled(wires, List.class, 2703, 107124, 107128);
            for (int i = 0; (wires != null) && (i < (CallChecker.isCalled(wires, List.class, 2703, 107124, 107128).size())); i++) {
                wires = CallChecker.beforeCalled(wires, List.class, 2705, 107170, 107174);
                if (CallChecker.beforeDeref(CallChecker.isCalled(wires, List.class, 2705, 107170, 107174).get(i), BundleWire.class, 2705, 107170, 107181)) {
                    wires = CallChecker.beforeCalled(wires, List.class, 2705, 107170, 107174);
                    final BundleCapability npe_invocation_var372 = CallChecker.isCalled(CallChecker.isCalled(wires, List.class, 2705, 107170, 107174).get(i), BundleWire.class, 2705, 107170, 107181).getCapability();
                    if (CallChecker.beforeDeref(npe_invocation_var372, BundleCapability.class, 2705, 107170, 107197)) {
                        final String npe_invocation_var373 = CallChecker.isCalled(npe_invocation_var372, BundleCapability.class, 2705, 107170, 107197).getNamespace();
                        if (CallChecker.beforeDeref(npe_invocation_var373, String.class, 2705, 107170, 107212)) {
                            wires = CallChecker.beforeCalled(wires, List.class, 2706, 107274, 107278);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(wires, List.class, 2706, 107274, 107278).get(i), BundleWire.class, 2706, 107274, 107285)) {
                                wires = CallChecker.beforeCalled(wires, List.class, 2706, 107274, 107278);
                                final BundleCapability npe_invocation_var374 = CallChecker.isCalled(CallChecker.isCalled(wires, List.class, 2706, 107274, 107278).get(i), BundleWire.class, 2706, 107274, 107285).getCapability();
                                if (CallChecker.beforeDeref(npe_invocation_var374, BundleCapability.class, 2706, 107274, 107301)) {
                                    final Map<String, Object> npe_invocation_var375 = CallChecker.isCalled(npe_invocation_var374, BundleCapability.class, 2706, 107274, 107301).getAttributes();
                                    if (CallChecker.beforeDeref(npe_invocation_var375, Map.class, 2706, 107274, 107317)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var375, Map.class, 2706, 107274, 107317).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 2706, 107274, 107355)) {
                                            if ((CallChecker.isCalled(npe_invocation_var373, String.class, 2705, 107170, 107212).equals(BundleRevision.PACKAGE_NAMESPACE)) && (CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var375, Map.class, 2706, 107274, 107317).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 2706, 107274, 107355).equals(pkgName))) {
                                                String exporter = CallChecker.init(String.class);
                                                wires = CallChecker.beforeCalled(wires, List.class, 2708, 107422, 107426);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(wires, List.class, 2708, 107422, 107426).get(i), BundleWire.class, 2708, 107422, 107433)) {
                                                    wires = CallChecker.beforeCalled(wires, List.class, 2708, 107422, 107426);
                                                    final BundleWiring npe_invocation_var376 = CallChecker.isCalled(CallChecker.isCalled(wires, List.class, 2708, 107422, 107426).get(i), BundleWire.class, 2708, 107422, 107433).getProviderWiring();
                                                    if (CallChecker.beforeDeref(npe_invocation_var376, BundleWiring.class, 2708, 107422, 107453)) {
                                                        final Bundle npe_invocation_var377 = CallChecker.isCalled(npe_invocation_var376, BundleWiring.class, 2708, 107422, 107453).getBundle();
                                                        if (CallChecker.beforeDeref(npe_invocation_var377, Bundle.class, 2708, 107422, 107465)) {
                                                            exporter = CallChecker.isCalled(npe_invocation_var377, Bundle.class, 2708, 107422, 107465).toString();
                                                            CallChecker.varAssign(exporter, "exporter", 2708, 107422, 107433);
                                                        }
                                                    }
                                                }
                                                StringBuffer sb = CallChecker.varInit(new StringBuffer("*** Package '"), "sb", 2710, 107496, 107547);
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2711, 107565, 107566)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2711, 107565, 107566);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2711, 107565, 107566).append(pkgName);
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2712, 107601, 107602)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2712, 107601, 107602);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2712, 107601, 107602).append("' is imported by bundle ");
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2713, 107656, 107657)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2713, 107656, 107657);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2713, 107656, 107657).append(importer);
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2714, 107693, 107694)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2714, 107693, 107694);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2714, 107693, 107694).append(" from bundle ");
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2715, 107737, 107738)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2715, 107737, 107738);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2715, 107737, 107738).append(exporter);
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2716, 107774, 107775)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2716, 107774, 107775);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2716, 107774, 107775).append(", but the exported package from bundle ");
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2717, 107844, 107845)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2717, 107844, 107845);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2717, 107844, 107845).append(exporter);
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2718, 107881, 107882)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2718, 107881, 107882);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2718, 107881, 107882).append(" does not contain the requested class '");
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2719, 107951, 107952)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2719, 107951, 107952);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2719, 107951, 107952).append(name);
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2720, 107984, 107985)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2720, 107984, 107985);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2720, 107984, 107985).append("'. Please verify that the class name is correct in the importing bundle ");
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2721, 108087, 108088)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2721, 108087, 108088);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2721, 108087, 108088).append(importer);
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2722, 108124, 108125)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2722, 108124, 108125);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2722, 108124, 108125).append(" and/or that the exported package is correctly bundled in ");
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2723, 108213, 108214)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2723, 108213, 108214);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2723, 108213, 108214).append(exporter);
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2724, 108250, 108251)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2724, 108250, 108251);
                                                    CallChecker.isCalled(sb, StringBuffer.class, 2724, 108250, 108251).append(". ***");
                                                }
                                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2726, 108294, 108295)) {
                                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2726, 108294, 108295);
                                                    return CallChecker.isCalled(sb, StringBuffer.class, 2726, 108294, 108295).toString();
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
                
            }
            List<BundleRequirement> reqs = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 2732, 108504, 108511)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 2732, 108504, 108511);
                final BundleWiring npe_invocation_var378 = CallChecker.isCalled(revision, BundleRevision.class, 2732, 108504, 108511).getWiring();
                if (CallChecker.beforeDeref(npe_invocation_var378, BundleWiring.class, 2732, 108504, 108523)) {
                    reqs = CallChecker.isCalled(npe_invocation_var378, BundleWiring.class, 2732, 108504, 108523).getRequirements(null);
                    CallChecker.varAssign(reqs, "reqs", 2732, 108504, 108511);
                }
            }
            if (CallChecker.beforeDeref(resolver, StatefulResolver.class, 2792, 111273, 111280)) {
                resolver = CallChecker.beforeCalled(resolver, StatefulResolver.class, 2792, 111273, 111280);
                if (CallChecker.isCalled(resolver, StatefulResolver.class, 2792, 111273, 111280).isAllowedDynamicImport(revision, pkgName)) {
                    Map<String, String> dirs = CallChecker.varInit(Collections.EMPTY_MAP, "dirs", 2795, 111408, 111456);
                    Map<String, Object> attrs = CallChecker.varInit(Collections.singletonMap(BundleRevision.PACKAGE_NAMESPACE, ((Object) (pkgName))), "attrs", 2796, 111470, 111591);
                    BundleRequirementImpl req = CallChecker.varInit(new BundleRequirementImpl(revision, BundleRevision.PACKAGE_NAMESPACE, dirs, attrs), "req", 2798, 111605, 111732);
                    List<BundleCapability> exporters = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(resolver, StatefulResolver.class, 2800, 111781, 111788)) {
                        resolver = CallChecker.beforeCalled(resolver, StatefulResolver.class, 2800, 111781, 111788);
                        exporters = CallChecker.isCalled(resolver, StatefulResolver.class, 2800, 111781, 111788).findProviders(req, false);
                        CallChecker.varAssign(exporters, "exporters", 2800, 111781, 111788);
                    }
                    BundleRevision provider = CallChecker.varInit(null, "provider", 2802, 111830, 111860);
                    TryContext _bcornu_try_context_311 = new TryContext(311, BundleWiringImpl.class, "java.lang.Exception");
                    try {
                        if (CallChecker.beforeDeref(resolver, StatefulResolver.class, 2805, 111919, 111926)) {
                            resolver = CallChecker.beforeCalled(resolver, StatefulResolver.class, 2805, 111919, 111926);
                            provider = CallChecker.isCalled(resolver, StatefulResolver.class, 2805, 111919, 111926).resolve(revision, pkgName);
                            CallChecker.varAssign(provider, "provider", 2805, 111908, 111954);
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_311.catchStart(311);
                        provider = null;
                        CallChecker.varAssign(provider, "provider", 2809, 112033, 112048);
                    } finally {
                        _bcornu_try_context_311.finallyStart(311);
                    }
                    String exporter = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(exporters, List.class, 2812, 112096, 112104)) {
                        exporters = CallChecker.beforeCalled(exporters, List.class, 2812, 112096, 112104);
                        if (CallChecker.isCalled(exporters, List.class, 2812, 112096, 112104).isEmpty()) {
                            exporter = null;
                            CallChecker.varAssign(exporter, "exporter", 2812, 112095, 112179);
                        }else {
                            if (CallChecker.beforeDeref(exporters, List.class, 2813, 112142, 112150)) {
                                exporters = CallChecker.beforeCalled(exporters, List.class, 2813, 112142, 112150);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(exporters, List.class, 2813, 112142, 112150).iterator(), Iterator.class, 2813, 112142, 112161)) {
                                    exporters = CallChecker.beforeCalled(exporters, List.class, 2813, 112142, 112150);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(exporters, List.class, 2813, 112142, 112150).iterator(), Iterator.class, 2813, 112142, 112161).next(), BundleCapability.class, 2813, 112142, 112168)) {
                                        exporters = CallChecker.beforeCalled(exporters, List.class, 2813, 112142, 112150);
                                        exporter = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(exporters, List.class, 2813, 112142, 112150).iterator(), Iterator.class, 2813, 112142, 112161).next(), BundleCapability.class, 2813, 112142, 112168).toString();
                                        CallChecker.varAssign(exporter, "exporter", 2812, 112095, 112179);
                                    }
                                }
                            }
                        }
                    }
                    StringBuffer sb = CallChecker.varInit(new StringBuffer("*** Class '"), "sb", 2815, 112195, 112244);
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2816, 112258, 112259)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2816, 112258, 112259);
                        CallChecker.isCalled(sb, StringBuffer.class, 2816, 112258, 112259).append(name);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2817, 112287, 112288)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2817, 112287, 112288);
                        CallChecker.isCalled(sb, StringBuffer.class, 2817, 112287, 112288).append("' was not found, but this is likely normal since package '");
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2818, 112372, 112373)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2818, 112372, 112373);
                        CallChecker.isCalled(sb, StringBuffer.class, 2818, 112372, 112373).append(pkgName);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2819, 112404, 112405)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2819, 112404, 112405);
                        CallChecker.isCalled(sb, StringBuffer.class, 2819, 112404, 112405).append("' is dynamically imported by bundle ");
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2820, 112467, 112468)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2820, 112467, 112468);
                        CallChecker.isCalled(sb, StringBuffer.class, 2820, 112467, 112468).append(importer);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2821, 112500, 112501)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2821, 112500, 112501);
                        CallChecker.isCalled(sb, StringBuffer.class, 2821, 112500, 112501).append(".");
                    }
                    if (CallChecker.beforeDeref(exporters, List.class, 2822, 112533, 112541)) {
                        exporters = CallChecker.beforeCalled(exporters, List.class, 2822, 112533, 112541);
                        if (((CallChecker.isCalled(exporters, List.class, 2822, 112533, 112541).size()) > 0) && (provider == null)) {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2824, 112608, 112609)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2824, 112608, 112609);
                                CallChecker.isCalled(sb, StringBuffer.class, 2824, 112608, 112609).append(" However, bundle ");
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2825, 112656, 112657)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2825, 112656, 112657);
                                CallChecker.isCalled(sb, StringBuffer.class, 2825, 112656, 112657).append(exporter);
                            }
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2826, 112693, 112694)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2826, 112693, 112694);
                                CallChecker.isCalled(sb, StringBuffer.class, 2826, 112693, 112694).append(" does export this package with attributes that do not match.");
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2828, 112794, 112795)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2828, 112794, 112795);
                        CallChecker.isCalled(sb, StringBuffer.class, 2828, 112794, 112795).append(" ***");
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2830, 112833, 112834)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2830, 112833, 112834);
                        return CallChecker.isCalled(sb, StringBuffer.class, 2830, 112833, 112834).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            Map<String, String> dirs = CallChecker.varInit(Collections.EMPTY_MAP, "dirs", 2834, 112948, 112996);
            Map<String, Object> attrs = CallChecker.varInit(Collections.singletonMap(BundleRevision.PACKAGE_NAMESPACE, ((Object) (pkgName))), "attrs", 2835, 113006, 113123);
            BundleRequirementImpl req = CallChecker.varInit(new BundleRequirementImpl(revision, BundleRevision.PACKAGE_NAMESPACE, dirs, attrs), "req", 2837, 113133, 113256);
            List<BundleCapability> exports = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(resolver, StatefulResolver.class, 2839, 113299, 113306)) {
                resolver = CallChecker.beforeCalled(resolver, StatefulResolver.class, 2839, 113299, 113306);
                exports = CallChecker.isCalled(resolver, StatefulResolver.class, 2839, 113299, 113306).findProviders(req, false);
                CallChecker.varAssign(exports, "exports", 2839, 113299, 113306);
            }
            if (CallChecker.beforeDeref(exports, List.class, 2840, 113347, 113353)) {
                exports = CallChecker.beforeCalled(exports, List.class, 2840, 113347, 113353);
                if ((CallChecker.isCalled(exports, List.class, 2840, 113347, 113353).size()) > 0) {
                    boolean classpath = CallChecker.varInit(((boolean) (false)), "classpath", 2842, 113389, 113414);
                    TryContext _bcornu_try_context_312 = new TryContext(312, BundleWiringImpl.class, "java.lang.NoClassDefFoundError", "java.lang.Exception");
                    try {
                        final SecureAction npe_invocation_var379 = BundleRevisionImpl.getSecureAction();
                        if (CallChecker.beforeDeref(npe_invocation_var379, SecureAction.class, 2845, 113462, 113497)) {
                            final ClassLoader npe_invocation_var380 = CallChecker.isCalled(npe_invocation_var379, SecureAction.class, 2845, 113462, 113497).getClassLoader(BundleWiringImpl.BundleClassLoader.class);
                            if (CallChecker.beforeDeref(npe_invocation_var380, ClassLoader.class, 2845, 113462, 113558)) {
                                CallChecker.isCalled(npe_invocation_var380, ClassLoader.class, 2845, 113462, 113558).loadClass(name);
                            }
                        }
                        classpath = true;
                        CallChecker.varAssign(classpath, "classpath", 2847, 113593, 113609);
                    } catch (NoClassDefFoundError err) {
                        _bcornu_try_context_312.catchStart(312);
                    } catch (Exception ex) {
                        _bcornu_try_context_312.catchStart(312);
                    } finally {
                        _bcornu_try_context_312.finallyStart(312);
                    }
                    String exporter = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(exports, List.class, 2858, 113842, 113848)) {
                        exports = CallChecker.beforeCalled(exports, List.class, 2858, 113842, 113848);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(exports, List.class, 2858, 113842, 113848).iterator(), Iterator.class, 2858, 113842, 113859)) {
                            exports = CallChecker.beforeCalled(exports, List.class, 2858, 113842, 113848);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(exports, List.class, 2858, 113842, 113848).iterator(), Iterator.class, 2858, 113842, 113859).next(), BundleCapability.class, 2858, 113842, 113866)) {
                                exports = CallChecker.beforeCalled(exports, List.class, 2858, 113842, 113848);
                                exporter = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(exports, List.class, 2858, 113842, 113848).iterator(), Iterator.class, 2858, 113842, 113859).next(), BundleCapability.class, 2858, 113842, 113866).toString();
                                CallChecker.varAssign(exporter, "exporter", 2858, 113842, 113848);
                            }
                        }
                    }
                    StringBuffer sb = CallChecker.varInit(new StringBuffer("*** Class '"), "sb", 2860, 113893, 113942);
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2861, 113956, 113957)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2861, 113956, 113957);
                        CallChecker.isCalled(sb, StringBuffer.class, 2861, 113956, 113957).append(name);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2862, 113985, 113986)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2862, 113985, 113986);
                        CallChecker.isCalled(sb, StringBuffer.class, 2862, 113985, 113986).append("' was not found because bundle ");
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2863, 114043, 114044)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2863, 114043, 114044);
                        CallChecker.isCalled(sb, StringBuffer.class, 2863, 114043, 114044).append(importer);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2864, 114076, 114077)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2864, 114076, 114077);
                        CallChecker.isCalled(sb, StringBuffer.class, 2864, 114076, 114077).append(" does not import '");
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2865, 114121, 114122)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2865, 114121, 114122);
                        CallChecker.isCalled(sb, StringBuffer.class, 2865, 114121, 114122).append(pkgName);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2866, 114153, 114154)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2866, 114153, 114154);
                        CallChecker.isCalled(sb, StringBuffer.class, 2866, 114153, 114154).append("' even though bundle ");
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2867, 114201, 114202)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2867, 114201, 114202);
                        CallChecker.isCalled(sb, StringBuffer.class, 2867, 114201, 114202).append(exporter);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2868, 114234, 114235)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2868, 114234, 114235);
                        CallChecker.isCalled(sb, StringBuffer.class, 2868, 114234, 114235).append(" does export it.");
                    }
                    if (classpath) {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2871, 114322, 114323)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2871, 114322, 114323);
                            CallChecker.isCalled(sb, StringBuffer.class, 2871, 114322, 114323).append(" Additionally, the class is also available from the system class loader. There are two fixes: 1) Add an import for '");
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2872, 114469, 114470)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2872, 114469, 114470);
                            CallChecker.isCalled(sb, StringBuffer.class, 2872, 114469, 114470).append(pkgName);
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2873, 114505, 114506)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2873, 114505, 114506);
                            CallChecker.isCalled(sb, StringBuffer.class, 2873, 114505, 114506).append("' to bundle ");
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2874, 114548, 114549)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2874, 114548, 114549);
                            CallChecker.isCalled(sb, StringBuffer.class, 2874, 114548, 114549).append(importer);
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2875, 114585, 114586)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2875, 114585, 114586);
                            CallChecker.isCalled(sb, StringBuffer.class, 2875, 114585, 114586).append("; imports are necessary for each class directly touched by bundle code or indirectly touched, such as super classes if their methods are used. ");
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2876, 114759, 114760)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2876, 114759, 114760);
                            CallChecker.isCalled(sb, StringBuffer.class, 2876, 114759, 114760).append("2) Add package '");
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2877, 114806, 114807)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2877, 114806, 114807);
                            CallChecker.isCalled(sb, StringBuffer.class, 2877, 114806, 114807).append(pkgName);
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2878, 114842, 114843)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2878, 114842, 114843);
                            CallChecker.isCalled(sb, StringBuffer.class, 2878, 114842, 114843).append("' to the '");
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2879, 114883, 114884)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2879, 114883, 114884);
                            CallChecker.isCalled(sb, StringBuffer.class, 2879, 114883, 114884).append(Constants.FRAMEWORK_BOOTDELEGATION);
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2880, 114946, 114947)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2880, 114946, 114947);
                            CallChecker.isCalled(sb, StringBuffer.class, 2880, 114946, 114947).append("' property; a library or VM bug can cause classes to be loaded by the wrong class loader. The first approach is preferable for preserving modularity.");
                        }
                    }else {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2884, 115171, 115172)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2884, 115171, 115172);
                            CallChecker.isCalled(sb, StringBuffer.class, 2884, 115171, 115172).append(" To resolve this issue, add an import for '");
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2885, 115245, 115246)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2885, 115245, 115246);
                            CallChecker.isCalled(sb, StringBuffer.class, 2885, 115245, 115246).append(pkgName);
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2886, 115281, 115282)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2886, 115281, 115282);
                            CallChecker.isCalled(sb, StringBuffer.class, 2886, 115281, 115282).append("' to bundle ");
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2887, 115324, 115325)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2887, 115324, 115325);
                            CallChecker.isCalled(sb, StringBuffer.class, 2887, 115324, 115325).append(importer);
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2888, 115361, 115362)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2888, 115361, 115362);
                            CallChecker.isCalled(sb, StringBuffer.class, 2888, 115361, 115362).append(".");
                        }
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2890, 115403, 115404)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2890, 115403, 115404);
                        CallChecker.isCalled(sb, StringBuffer.class, 2890, 115403, 115404).append(" ***");
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2892, 115442, 115443)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2892, 115442, 115443);
                        return CallChecker.isCalled(sb, StringBuffer.class, 2892, 115442, 115443).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            TryContext _bcornu_try_context_313 = new TryContext(313, BundleWiringImpl.class, "java.lang.Exception");
            try {
                final SecureAction npe_invocation_var381 = BundleRevisionImpl.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var381, SecureAction.class, 2899, 115597, 115632)) {
                    final ClassLoader npe_invocation_var382 = CallChecker.isCalled(npe_invocation_var381, SecureAction.class, 2899, 115597, 115632).getClassLoader(BundleWiringImpl.BundleClassLoader.class);
                    if (CallChecker.beforeDeref(npe_invocation_var382, ClassLoader.class, 2899, 115597, 115689)) {
                        CallChecker.isCalled(npe_invocation_var382, ClassLoader.class, 2899, 115597, 115689).loadClass(name);
                    }
                }
                StringBuffer sb = CallChecker.varInit(new StringBuffer("*** Package '"), "sb", 2902, 115721, 115772);
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2903, 115786, 115787)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2903, 115786, 115787);
                    CallChecker.isCalled(sb, StringBuffer.class, 2903, 115786, 115787).append(pkgName);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2904, 115818, 115819)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2904, 115818, 115819);
                    CallChecker.isCalled(sb, StringBuffer.class, 2904, 115818, 115819).append("' is not imported by bundle ");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2905, 115873, 115874)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2905, 115873, 115874);
                    CallChecker.isCalled(sb, StringBuffer.class, 2905, 115873, 115874).append(importer);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2906, 115906, 115907)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2906, 115906, 115907);
                    CallChecker.isCalled(sb, StringBuffer.class, 2906, 115906, 115907).append(", nor is there any bundle that exports package '");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2907, 115981, 115982)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2907, 115981, 115982);
                    CallChecker.isCalled(sb, StringBuffer.class, 2907, 115981, 115982).append(pkgName);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2908, 116013, 116014)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2908, 116013, 116014);
                    CallChecker.isCalled(sb, StringBuffer.class, 2908, 116013, 116014).append("'. However, the class '");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2909, 116063, 116064)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2909, 116063, 116064);
                    CallChecker.isCalled(sb, StringBuffer.class, 2909, 116063, 116064).append(name);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2910, 116092, 116093)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2910, 116092, 116093);
                    CallChecker.isCalled(sb, StringBuffer.class, 2910, 116092, 116093).append("' is available from the system class loader. There are two fixes: 1) Add package '");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2911, 116201, 116202)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2911, 116201, 116202);
                    CallChecker.isCalled(sb, StringBuffer.class, 2911, 116201, 116202).append(pkgName);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2912, 116233, 116234)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2912, 116233, 116234);
                    CallChecker.isCalled(sb, StringBuffer.class, 2912, 116233, 116234).append("' to the '");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2913, 116270, 116271)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2913, 116270, 116271);
                    CallChecker.isCalled(sb, StringBuffer.class, 2913, 116270, 116271).append(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2914, 116335, 116336)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2914, 116335, 116336);
                    CallChecker.isCalled(sb, StringBuffer.class, 2914, 116335, 116336).append("' property and modify bundle ");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2915, 116391, 116392)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2915, 116391, 116392);
                    CallChecker.isCalled(sb, StringBuffer.class, 2915, 116391, 116392).append(importer);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2916, 116424, 116425)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2916, 116424, 116425);
                    CallChecker.isCalled(sb, StringBuffer.class, 2916, 116424, 116425).append(" to import this package; this causes the system bundle to export class path packages. 2) Add package '");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2917, 116553, 116554)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2917, 116553, 116554);
                    CallChecker.isCalled(sb, StringBuffer.class, 2917, 116553, 116554).append(pkgName);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2918, 116585, 116586)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2918, 116585, 116586);
                    CallChecker.isCalled(sb, StringBuffer.class, 2918, 116585, 116586).append("' to the '");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2919, 116622, 116623)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2919, 116622, 116623);
                    CallChecker.isCalled(sb, StringBuffer.class, 2919, 116622, 116623).append(Constants.FRAMEWORK_BOOTDELEGATION);
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2920, 116681, 116682)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2920, 116681, 116682);
                    CallChecker.isCalled(sb, StringBuffer.class, 2920, 116681, 116682).append("' property; a library or VM bug can cause classes to be loaded by the wrong class loader. The first approach is preferable for preserving modularity.");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2921, 116857, 116858)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2921, 116857, 116858);
                    CallChecker.isCalled(sb, StringBuffer.class, 2921, 116857, 116858).append(" ***");
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2923, 116896, 116897)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2923, 116896, 116897);
                    return CallChecker.isCalled(sb, StringBuffer.class, 2923, 116896, 116897).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex2) {
                _bcornu_try_context_313.catchStart(313);
            } finally {
                _bcornu_try_context_313.finallyStart(313);
            }
            StringBuffer sb = CallChecker.varInit(new StringBuffer("*** Class '"), "sb", 2932, 117155, 117204);
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2933, 117214, 117215)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2933, 117214, 117215);
                CallChecker.isCalled(sb, StringBuffer.class, 2933, 117214, 117215).append(name);
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2934, 117239, 117240)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2934, 117239, 117240);
                CallChecker.isCalled(sb, StringBuffer.class, 2934, 117239, 117240).append("' was not found. Bundle ");
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2935, 117286, 117287)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2935, 117286, 117287);
                CallChecker.isCalled(sb, StringBuffer.class, 2935, 117286, 117287).append(importer);
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2936, 117315, 117316)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2936, 117315, 117316);
                CallChecker.isCalled(sb, StringBuffer.class, 2936, 117315, 117316).append(" does not import package '");
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2937, 117364, 117365)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2937, 117364, 117365);
                CallChecker.isCalled(sb, StringBuffer.class, 2937, 117364, 117365).append(pkgName);
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2938, 117392, 117393)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2938, 117392, 117393);
                CallChecker.isCalled(sb, StringBuffer.class, 2938, 117392, 117393).append("', nor is the package exported by any other bundle or available from the system class loader.");
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2939, 117508, 117509)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2939, 117508, 117509);
                CallChecker.isCalled(sb, StringBuffer.class, 2939, 117508, 117509).append(" ***");
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2941, 117543, 117544)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2941, 117543, 117544);
                return CallChecker.isCalled(sb, StringBuffer.class, 2941, 117543, 117544).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context967.methodEnd();
        }
    }
}

