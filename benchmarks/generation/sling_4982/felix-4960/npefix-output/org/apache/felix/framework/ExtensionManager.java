package org.apache.felix.framework;

import org.osgi.framework.Version;
import org.apache.felix.framework.util.Util;
import java.net.URLStreamHandler;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.StringMap;
import java.util.Set;
import org.apache.felix.framework.cache.Content;
import org.osgi.framework.Constants;
import java.util.Collections;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWiring;
import org.apache.felix.framework.wiring.BundleWireImpl;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleRevision;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.AdminPermission;
import java.security.AllPermission;
import java.util.ArrayList;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.wiring.BundleCapability;
import org.apache.felix.framework.wiring.BundleCapabilityImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.BundleRequirement;
import java.util.Enumeration;
import org.apache.felix.framework.util.FelixConstants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.FrameworkEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.io.IOException;
import org.apache.felix.framework.util.ImmutableList;
import java.net.InetAddress;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.felix.framework.util.manifestparser.ManifestParser;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.felix.framework.util.manifestparser.NativeLibrary;
import org.apache.felix.framework.util.manifestparser.NativeLibraryClause;
import org.osgi.framework.namespace.NativeNamespace;
import java.util.NoSuchElementException;
import org.apache.felix.framework.util.SecureAction;

class ExtensionManager extends URLStreamHandler implements Content {
    static final ExtensionManager m_extensionManager;

    static {
        ExtensionManager extensionManager = CallChecker.varInit(null, "extensionManager", 99, 4048, 4088);
        if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 101, 4128, 4147)) {
            if (CallChecker.beforeDeref("true", String.class, 101, 4104, 4109)) {
                if (!(CallChecker.isCalled("true", String.class, 101, 4104, 4109).equalsIgnoreCase(CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 101, 4128, 4147).getSystemProperty(FelixConstants.FELIX_EXTENSIONS_DISABLE, "false")))) {
                    TryContext _bcornu_try_context_329 = new TryContext(329, ExtensionManager.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(new URL("http://felix.extensions:9/"), URL.class, 106, 4288, 4326)) {
                            CallChecker.isCalled(new URL("http://felix.extensions:9/"), URL.class, 106, 4288, 4326).openConnection();
                        }
                    } catch (Throwable t) {
                        _bcornu_try_context_329.catchStart(329);
                    } finally {
                        _bcornu_try_context_329.finallyStart(329);
                    }
                    TryContext _bcornu_try_context_330 = new TryContext(330, ExtensionManager.class, "java.lang.Throwable");
                    try {
                        extensionManager = new ExtensionManager();
                        CallChecker.varAssign(extensionManager, "extensionManager", 117, 4675, 4716);
                        if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 120, 4831, 4850)) {
                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 119, 4779, 4798)) {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 119, 4735, 4754)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 119, 4735, 4754).addURLToURLClassLoader(CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 119, 4779, 4798).createURL(CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 120, 4831, 4850).createURL(null, "http:", extensionManager), "http://felix.extensions:9/", extensionManager), Felix.class.getClassLoader());
                                }
                            }
                        }
                    } catch (Throwable ex) {
                        _bcornu_try_context_330.catchStart(330);
                        extensionManager = null;
                        CallChecker.varAssign(extensionManager, "extensionManager", 127, 5153, 5176);
                    } finally {
                        _bcornu_try_context_330.finallyStart(330);
                    }
                }
            }
        }
        m_extensionManager = extensionManager;
        CallChecker.varAssign(m_extensionManager, "ExtensionManager.m_extensionManager", 131, 5211, 5248);
    }

    private final Logger m_logger;

    private final Map m_configMap;

    private final Map m_headerMap = new StringMap();

    private final BundleRevision m_systemBundleRevision;

    private volatile List<BundleCapability> m_capabilities = Collections.EMPTY_LIST;

    private volatile Set<String> m_exportNames = Collections.EMPTY_SET;

    private volatile Object m_securityContext = null;

    private final List m_extensions;

    private volatile Bundle[] m_extensionsCache;

    private final Set m_names;

    private final Map m_sourceToExtensions;

    private final List<ExtensionManager.ExtensionTuple> m_extensionTuples = Collections.synchronizedList(new ArrayList<ExtensionManager.ExtensionTuple>());

    private static class ExtensionTuple {
        private final BundleActivator m_activator;

        private final Bundle m_bundle;

        private volatile boolean m_failed;

        private volatile boolean m_started;

        public ExtensionTuple(BundleActivator activator, Bundle bundle) {
            MethodContext _bcornu_methode_context123 = new MethodContext(null);
            try {
                m_activator = activator;
                CallChecker.varAssign(this.m_activator, "this.m_activator", 156, 6250, 6273);
                m_bundle = bundle;
                CallChecker.varAssign(this.m_bundle, "this.m_bundle", 157, 6287, 6304);
            } finally {
                _bcornu_methode_context123.methodEnd();
            }
        }
    }

    private ExtensionManager() {
        MethodContext _bcornu_methode_context124 = new MethodContext(null);
        try {
            m_logger = null;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 166, 6471, 6486);
            m_configMap = null;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 167, 6496, 6514);
            m_systemBundleRevision = null;
            CallChecker.varAssign(this.m_systemBundleRevision, "this.m_systemBundleRevision", 168, 6524, 6553);
            m_extensions = new ArrayList();
            CallChecker.varAssign(this.m_extensions, "this.m_extensions", 169, 6563, 6593);
            m_extensionsCache = new Bundle[0];
            CallChecker.varAssign(this.m_extensionsCache, "this.m_extensionsCache", 170, 6603, 6636);
            m_names = new HashSet();
            CallChecker.varAssign(this.m_names, "this.m_names", 171, 6646, 6669);
            m_sourceToExtensions = new HashMap();
            CallChecker.varAssign(this.m_sourceToExtensions, "this.m_sourceToExtensions", 172, 6679, 6715);
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    ExtensionManager(Logger logger, Map configMap, Felix felix) {
        MethodContext _bcornu_methode_context125 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 188, 7350, 7367);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 189, 7377, 7400);
            m_systemBundleRevision = new ExtensionManager.ExtensionManagerRevision(felix);
            CallChecker.varAssign(this.m_systemBundleRevision, "this.m_systemBundleRevision", 190, 7410, 7470);
            m_extensions = null;
            CallChecker.varAssign(this.m_extensions, "this.m_extensions", 191, 7480, 7499);
            m_extensionsCache = null;
            CallChecker.varAssign(this.m_extensionsCache, "this.m_extensionsCache", 192, 7509, 7533);
            m_names = null;
            CallChecker.varAssign(this.m_names, "this.m_names", 193, 7543, 7557);
            m_sourceToExtensions = null;
            CallChecker.varAssign(this.m_sourceToExtensions, "this.m_sourceToExtensions", 194, 7567, 7594);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 199, 7797, 7807)) {
                if (CallChecker.beforeDeref(m_headerMap, Map.class, 198, 7738, 7748)) {
                    CallChecker.isCalled(m_headerMap, Map.class, 198, 7738, 7748).put(FelixConstants.BUNDLE_VERSION, CallChecker.isCalled(m_configMap, Map.class, 199, 7797, 7807).get(FelixConstants.FELIX_VERSION_PROPERTY));
                }
            }
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 200, 7862, 7872)) {
                CallChecker.isCalled(m_headerMap, Map.class, 200, 7862, 7872).put(FelixConstants.BUNDLE_SYMBOLICNAME, FelixConstants.SYSTEM_BUNDLE_SYMBOLICNAME);
            }
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 202, 7978, 7988)) {
                CallChecker.isCalled(m_headerMap, Map.class, 202, 7978, 7988).put(FelixConstants.BUNDLE_NAME, "System Bundle");
            }
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 203, 8048, 8058)) {
                CallChecker.isCalled(m_headerMap, Map.class, 203, 8048, 8058).put(FelixConstants.BUNDLE_DESCRIPTION, "This bundle is system specific; it implements various system services.");
            }
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 205, 8194, 8204)) {
                CallChecker.isCalled(m_headerMap, Map.class, 205, 8194, 8204).put(FelixConstants.EXPORT_SERVICE, ("org.osgi.service.packageadmin.PackageAdmin," + ("org.osgi.service.startlevel.StartLevel," + "org.osgi.service.url.URLHandlers")));
            }
            String syspkgs = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 216, 8788, 8798)) {
                syspkgs = ((String) (CallChecker.isCalled(m_configMap, Map.class, 216, 8788, 8798).get(FelixConstants.FRAMEWORK_SYSTEMPACKAGES)));
                CallChecker.varAssign(syspkgs, "syspkgs", 216, 8788, 8798);
            }
            if (syspkgs == null) {
                syspkgs = Util.getDefaultProperty(logger, Constants.FRAMEWORK_SYSTEMPACKAGES);
                CallChecker.varAssign(syspkgs, "syspkgs", 218, 8927, 9058);
            }else {
                syspkgs = syspkgs;
                CallChecker.varAssign(syspkgs, "syspkgs", 218, 8927, 9058);
            }
            if (syspkgs == null) {
                syspkgs = "";
                CallChecker.varAssign(syspkgs, "syspkgs", 221, 9068, 9110);
            }else {
                syspkgs = syspkgs;
                CallChecker.varAssign(syspkgs, "syspkgs", 221, 9068, 9110);
            }
            String pkgextra = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 224, 9225, 9235)) {
                pkgextra = ((String) (CallChecker.isCalled(m_configMap, Map.class, 224, 9225, 9235).get(FelixConstants.FRAMEWORK_SYSTEMPACKAGES_EXTRA)));
                CallChecker.varAssign(pkgextra, "pkgextra", 224, 9225, 9235);
            }
            pkgextra = CallChecker.beforeCalled(pkgextra, String.class, 225, 9331, 9338);
            if (CallChecker.beforeDeref(CallChecker.isCalled(pkgextra, String.class, 225, 9331, 9338).trim(), String.class, 225, 9331, 9345)) {
                if ((pkgextra == null) || ((CallChecker.isCalled(pkgextra.trim(), String.class, 225, 9331, 9345).length()) == 0)) {
                    syspkgs = syspkgs;
                    CallChecker.varAssign(syspkgs, "syspkgs", 225, 9297, 9411);
                }else {
                    syspkgs = (syspkgs + ",") + pkgextra;
                    CallChecker.varAssign(syspkgs, "syspkgs", 225, 9297, 9411);
                }
            }
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 227, 9421, 9431)) {
                CallChecker.isCalled(m_headerMap, Map.class, 227, 9421, 9431).put(FelixConstants.BUNDLE_MANIFESTVERSION, "2");
            }
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 228, 9490, 9500)) {
                CallChecker.isCalled(m_headerMap, Map.class, 228, 9490, 9500).put(FelixConstants.EXPORT_PACKAGE, syspkgs);
            }
            String syscaps = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 236, 9934, 9944)) {
                syscaps = ((String) (CallChecker.isCalled(m_configMap, Map.class, 236, 9934, 9944).get(FelixConstants.FRAMEWORK_SYSTEMCAPABILITIES)));
                CallChecker.varAssign(syscaps, "syscaps", 236, 9934, 9944);
            }
            if (syscaps == null) {
                syscaps = Util.getDefaultProperty(logger, Constants.FRAMEWORK_SYSTEMCAPABILITIES);
                CallChecker.varAssign(syscaps, "syscaps", 238, 10081, 10216);
            }else {
                syscaps = syscaps;
                CallChecker.varAssign(syscaps, "syscaps", 238, 10081, 10216);
            }
            if (syscaps == null) {
                syscaps = "";
                CallChecker.varAssign(syscaps, "syscaps", 241, 10226, 10268);
            }else {
                syscaps = syscaps;
                CallChecker.varAssign(syscaps, "syscaps", 241, 10226, 10268);
            }
            String capextra = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 244, 10387, 10397)) {
                capextra = ((String) (CallChecker.isCalled(m_configMap, Map.class, 244, 10387, 10397).get(FelixConstants.FRAMEWORK_SYSTEMCAPABILITIES_EXTRA)));
                CallChecker.varAssign(capextra, "capextra", 244, 10387, 10397);
            }
            capextra = CallChecker.beforeCalled(capextra, String.class, 245, 10497, 10504);
            if (CallChecker.beforeDeref(CallChecker.isCalled(capextra, String.class, 245, 10497, 10504).trim(), String.class, 245, 10497, 10511)) {
                if ((capextra == null) || ((CallChecker.isCalled(capextra.trim(), String.class, 245, 10497, 10511).length()) == 0)) {
                    syscaps = syscaps;
                    CallChecker.varAssign(syscaps, "syscaps", 245, 10463, 10577);
                }else {
                    syscaps = (syscaps + ",") + capextra;
                    CallChecker.varAssign(syscaps, "syscaps", 245, 10463, 10577);
                }
            }
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 247, 10587, 10597)) {
                CallChecker.isCalled(m_headerMap, Map.class, 247, 10587, 10597).put(FelixConstants.PROVIDE_CAPABILITY, syscaps);
            }
            TryContext _bcornu_try_context_331 = new TryContext(331, ExtensionManager.class, "java.lang.Exception");
            try {
                ManifestParser mp = CallChecker.varInit(new ManifestParser(m_logger, m_configMap, m_systemBundleRevision, m_headerMap), "mp", 250, 10682, 10797);
                List<BundleCapability> caps = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(mp, ManifestParser.class, 252, 10859, 10860)) {
                    mp = CallChecker.beforeCalled(mp, ManifestParser.class, 252, 10859, 10860);
                    caps = ExtensionManager.aliasSymbolicName(CallChecker.isCalled(mp, ManifestParser.class, 252, 10859, 10860).getCapabilities());
                    CallChecker.varAssign(caps, "caps", 252, 10859, 10860);
                }
                if (CallChecker.beforeDeref(caps, List.class, 253, 10894, 10897)) {
                    caps = CallChecker.beforeCalled(caps, List.class, 253, 10894, 10897);
                    CallChecker.isCalled(caps, List.class, 253, 10894, 10897).add(buildNativeCapabilites());
                }
                appendCapabilities(caps);
            } catch (Exception ex) {
                _bcornu_try_context_331.catchStart(331);
                m_capabilities = Collections.EMPTY_LIST;
                CallChecker.varAssign(this.m_capabilities, "this.m_capabilities", 258, 11029, 11068);
                if (CallChecker.beforeDeref(m_logger, Logger.class, 259, 11082, 11089)) {
                    CallChecker.isCalled(m_logger, Logger.class, 259, 11082, 11089).log(Logger.LOG_ERROR, ("Error parsing system bundle export statement: " + syspkgs), ex);
                }
            } finally {
                _bcornu_try_context_331.finallyStart(331);
            }
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    protected BundleCapability buildNativeCapabilites() {
        MethodContext _bcornu_methode_context1178 = new MethodContext(BundleCapability.class);
        try {
            CallChecker.varInit(this, "this", 266, 11248, 12729);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 266, 11248, 12729);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 266, 11248, 12729);
            CallChecker.varInit(this.m_names, "m_names", 266, 11248, 12729);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 266, 11248, 12729);
            CallChecker.varInit(this.m_extensions, "m_extensions", 266, 11248, 12729);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 266, 11248, 12729);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 266, 11248, 12729);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 266, 11248, 12729);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 266, 11248, 12729);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 266, 11248, 12729);
            CallChecker.varInit(this.m_configMap, "m_configMap", 266, 11248, 12729);
            CallChecker.varInit(this.m_logger, "m_logger", 266, 11248, 12729);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 266, 11248, 12729);
            String osArchitecture = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 267, 11342, 11352)) {
                osArchitecture = ((String) (CallChecker.isCalled(m_configMap, Map.class, 267, 11342, 11352).get(FelixConstants.FRAMEWORK_PROCESSOR)));
                CallChecker.varAssign(osArchitecture, "osArchitecture", 267, 11342, 11352);
            }
            String osName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 268, 11427, 11437)) {
                osName = ((String) (CallChecker.isCalled(m_configMap, Map.class, 268, 11427, 11437).get(FelixConstants.FRAMEWORK_OS_NAME)));
                CallChecker.varAssign(osName, "osName", 268, 11427, 11437);
            }
            String osVersion = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 269, 11513, 11523)) {
                osVersion = ((String) (CallChecker.isCalled(m_configMap, Map.class, 269, 11513, 11523).get(FelixConstants.FRAMEWORK_OS_VERSION)));
                CallChecker.varAssign(osVersion, "osVersion", 269, 11513, 11523);
            }
            String userLang = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 270, 11601, 11611)) {
                userLang = ((String) (CallChecker.isCalled(m_configMap, Map.class, 270, 11601, 11611).get(FelixConstants.FRAMEWORK_LANGUAGE)));
                CallChecker.varAssign(userLang, "userLang", 270, 11601, 11611);
            }
            Map<String, Object> attributes = CallChecker.varInit(new HashMap<String, Object>(), "attributes", 271, 11661, 11723);
            if (CallChecker.beforeDeref(attributes, Map.class, 274, 11813, 11822)) {
                attributes = CallChecker.beforeCalled(attributes, Map.class, 274, 11813, 11822);
                CallChecker.isCalled(attributes, Map.class, 274, 11813, 11822).putAll(m_configMap);
            }
            if (osArchitecture != null) {
                if (CallChecker.beforeDeref(attributes, Map.class, 278, 11905, 11914)) {
                    attributes = CallChecker.beforeCalled(attributes, Map.class, 278, 11905, 11914);
                    CallChecker.isCalled(attributes, Map.class, 278, 11905, 11914).put(NativeNamespace.CAPABILITY_PROCESSOR_ATTRIBUTE, NativeLibraryClause.getProcessorWithAliases(osArchitecture));
                }
            }
            if (osName != null) {
                if (CallChecker.beforeDeref(attributes, Map.class, 283, 12091, 12100)) {
                    attributes = CallChecker.beforeCalled(attributes, Map.class, 283, 12091, 12100);
                    CallChecker.isCalled(attributes, Map.class, 283, 12091, 12100).put(NativeNamespace.CAPABILITY_OSNAME_ATTRIBUTE, NativeLibraryClause.getOsNameWithAliases(osName));
                }
            }
            if (osVersion != null) {
                osVersion = NativeLibraryClause.formatOSVersion(osVersion);
                CallChecker.varAssign(osVersion, "osVersion", 288, 12266, 12324);
                if (CallChecker.beforeDeref(attributes, Map.class, 289, 12338, 12347)) {
                    attributes = CallChecker.beforeCalled(attributes, Map.class, 289, 12338, 12347);
                    CallChecker.isCalled(attributes, Map.class, 289, 12338, 12347).put(NativeNamespace.CAPABILITY_OSVERSION_ATTRIBUTE, Version.parseVersion(osVersion));
                }
            }
            if (userLang != null) {
                if (CallChecker.beforeDeref(attributes, Map.class, 294, 12498, 12507)) {
                    attributes = CallChecker.beforeCalled(attributes, Map.class, 294, 12498, 12507);
                    CallChecker.isCalled(attributes, Map.class, 294, 12498, 12507).put(NativeNamespace.CAPABILITY_LANGUAGE_ATTRIBUTE, userLang);
                }
            }
            return new BundleCapabilityImpl(getRevision(), NativeNamespace.NATIVE_NAMESPACE, Collections.<String, String>emptyMap(), attributes);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleCapability) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1178.methodEnd();
        }
    }

    private static List<BundleCapability> aliasSymbolicName(List<BundleCapability> caps) {
        MethodContext _bcornu_methode_context1179 = new MethodContext(List.class);
        try {
            CallChecker.varInit(caps, "caps", 300, 12736, 15333);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 300, 12736, 15333);
            if (caps == null) {
                return new ArrayList<BundleCapability>(0);
            }
            List<BundleCapability> aliasCaps = CallChecker.varInit(new ArrayList<BundleCapability>(caps), "aliasCaps", 307, 12937, 13009);
            String[] aliases = CallChecker.varInit(new String[]{ FelixConstants.SYSTEM_BUNDLE_SYMBOLICNAME , Constants.SYSTEM_BUNDLE_SYMBOLICNAME }, "aliases", 309, 13020, 13146);
            aliasCaps = CallChecker.beforeCalled(aliasCaps, List.class, 313, 13187, 13195);
            for (int capIdx = 0; capIdx < (CallChecker.isCalled(aliasCaps, List.class, 313, 13187, 13195).size()); capIdx++) {
                BundleCapability cap = CallChecker.init(BundleCapability.class);
                if (CallChecker.beforeDeref(aliasCaps, List.class, 315, 13260, 13268)) {
                    aliasCaps = CallChecker.beforeCalled(aliasCaps, List.class, 315, 13260, 13268);
                    cap = CallChecker.isCalled(aliasCaps, List.class, 315, 13260, 13268).get(capIdx);
                    CallChecker.varAssign(cap, "cap", 315, 13260, 13268);
                }
                if (CallChecker.beforeDeref(cap, BundleCapability.class, 318, 13359, 13361)) {
                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 318, 13359, 13361);
                    final String npe_invocation_var425 = CallChecker.isCalled(cap, BundleCapability.class, 318, 13359, 13361).getNamespace();
                    if (CallChecker.beforeDeref(npe_invocation_var425, String.class, 318, 13359, 13376)) {
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 319, 13437, 13439)) {
                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 319, 13437, 13439);
                            final String npe_invocation_var426 = CallChecker.isCalled(cap, BundleCapability.class, 319, 13437, 13439).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var426, String.class, 319, 13437, 13454)) {
                                if ((CallChecker.isCalled(npe_invocation_var425, String.class, 318, 13359, 13376).equals(BundleRevision.BUNDLE_NAMESPACE)) || (CallChecker.isCalled(npe_invocation_var426, String.class, 319, 13437, 13454).equals(BundleRevision.HOST_NAMESPACE))) {
                                    Map<String, Object> aliasAttrs = CallChecker.init(Map.class);
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 323, 13661, 13663)) {
                                        cap = CallChecker.beforeCalled(cap, BundleCapability.class, 323, 13661, 13663);
                                        aliasAttrs = new HashMap<String, Object>(CallChecker.isCalled(cap, BundleCapability.class, 323, 13661, 13663).getAttributes());
                                        CallChecker.varAssign(aliasAttrs, "aliasAttrs", 323, 13661, 13663);
                                    }
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 325, 13756, 13758)) {
                                        if (CallChecker.beforeDeref(aliasAttrs, Map.class, 325, 13741, 13750)) {
                                            cap = CallChecker.beforeCalled(cap, BundleCapability.class, 325, 13756, 13758);
                                            aliasAttrs = CallChecker.beforeCalled(aliasAttrs, Map.class, 325, 13741, 13750);
                                            CallChecker.isCalled(aliasAttrs, Map.class, 325, 13741, 13750).put(CallChecker.isCalled(cap, BundleCapability.class, 325, 13756, 13758).getNamespace(), aliases);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 328, 13934, 13936)) {
                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 329, 13973, 13975)) {
                                            if (CallChecker.beforeDeref(cap, BundleCapability.class, 330, 14013, 14015)) {
                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 328, 13934, 13936);
                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 329, 13973, 13975);
                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 330, 14013, 14015);
                                                cap = new BundleCapabilityImpl(CallChecker.isCalled(cap, BundleCapability.class, 328, 13934, 13936).getRevision(), CallChecker.isCalled(cap, BundleCapability.class, 329, 13973, 13975).getNamespace(), CallChecker.isCalled(cap, BundleCapability.class, 330, 14013, 14015).getDirectives(), aliasAttrs);
                                                CallChecker.varAssign(cap, "cap", 327, 13882, 14065);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(aliasCaps, List.class, 332, 14083, 14091)) {
                                        aliasCaps = CallChecker.beforeCalled(aliasCaps, List.class, 332, 14083, 14091);
                                        CallChecker.isCalled(aliasCaps, List.class, 332, 14083, 14091).set(capIdx, cap);
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
                
                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 336, 14258, 14260);
                for (Map.Entry<String, Object> entry : CallChecker.isCalled(CallChecker.isCalled(cap, BundleCapability.class, 336, 14258, 14260).getAttributes(), Map.class, 336, 14258, 14276).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 340, 14443, 14447)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 340, 14443, 14447).getKey(), String.class, 340, 14443, 14456)) {
                            if (CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 340, 14443, 14447).getKey(), String.class, 340, 14443, 14456).equalsIgnoreCase(Constants.BUNDLE_SYMBOLICNAME_ATTRIBUTE)) {
                                Map<String, Object> aliasAttrs = CallChecker.init(Map.class);
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 344, 14699, 14701)) {
                                    cap = CallChecker.beforeCalled(cap, BundleCapability.class, 344, 14699, 14701);
                                    aliasAttrs = new HashMap<String, Object>(CallChecker.isCalled(cap, BundleCapability.class, 344, 14699, 14701).getAttributes());
                                    CallChecker.varAssign(aliasAttrs, "aliasAttrs", 344, 14699, 14701);
                                }
                                if (CallChecker.beforeDeref(aliasAttrs, Map.class, 346, 14787, 14796)) {
                                    aliasAttrs = CallChecker.beforeCalled(aliasAttrs, Map.class, 346, 14787, 14796);
                                    CallChecker.isCalled(aliasAttrs, Map.class, 346, 14787, 14796).put(Constants.BUNDLE_SYMBOLICNAME_ATTRIBUTE, aliases);
                                }
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 349, 15029, 15031)) {
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 350, 15072, 15074)) {
                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 351, 15116, 15118)) {
                                            if (CallChecker.beforeDeref(aliasCaps, List.class, 348, 14957, 14965)) {
                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 349, 15029, 15031);
                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 350, 15072, 15074);
                                                cap = CallChecker.beforeCalled(cap, BundleCapability.class, 351, 15116, 15118);
                                                aliasCaps = CallChecker.beforeCalled(aliasCaps, List.class, 348, 14957, 14965);
                                                CallChecker.isCalled(aliasCaps, List.class, 348, 14957, 14965).set(capIdx, new BundleCapabilityImpl(CallChecker.isCalled(cap, BundleCapability.class, 349, 15029, 15031).getRevision(), CallChecker.isCalled(cap, BundleCapability.class, 350, 15072, 15074).getNamespace(), CallChecker.isCalled(cap, BundleCapability.class, 351, 15116, 15118).getDirectives(), aliasAttrs));
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return aliasCaps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1179.methodEnd();
        }
    }

    public BundleRevision getRevision() {
        MethodContext _bcornu_methode_context1180 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 362, 15340, 15425);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 362, 15340, 15425);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 362, 15340, 15425);
            CallChecker.varInit(this.m_names, "m_names", 362, 15340, 15425);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 362, 15340, 15425);
            CallChecker.varInit(this.m_extensions, "m_extensions", 362, 15340, 15425);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 362, 15340, 15425);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 362, 15340, 15425);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 362, 15340, 15425);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 362, 15340, 15425);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 362, 15340, 15425);
            CallChecker.varInit(this.m_configMap, "m_configMap", 362, 15340, 15425);
            CallChecker.varInit(this.m_logger, "m_logger", 362, 15340, 15425);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 362, 15340, 15425);
            return m_systemBundleRevision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1180.methodEnd();
        }
    }

    public Object getSecurityContext() {
        MethodContext _bcornu_methode_context1181 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 367, 15432, 15511);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 367, 15432, 15511);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 367, 15432, 15511);
            CallChecker.varInit(this.m_names, "m_names", 367, 15432, 15511);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 367, 15432, 15511);
            CallChecker.varInit(this.m_extensions, "m_extensions", 367, 15432, 15511);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 367, 15432, 15511);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 367, 15432, 15511);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 367, 15432, 15511);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 367, 15432, 15511);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 367, 15432, 15511);
            CallChecker.varInit(this.m_configMap, "m_configMap", 367, 15432, 15511);
            CallChecker.varInit(this.m_logger, "m_logger", 367, 15432, 15511);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 367, 15432, 15511);
            return m_securityContext;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1181.methodEnd();
        }
    }

    public synchronized void setSecurityContext(Object securityContext) {
        MethodContext _bcornu_methode_context1182 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 372, 15518, 15641);
            CallChecker.varInit(securityContext, "securityContext", 372, 15518, 15641);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 372, 15518, 15641);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 372, 15518, 15641);
            CallChecker.varInit(this.m_names, "m_names", 372, 15518, 15641);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 372, 15518, 15641);
            CallChecker.varInit(this.m_extensions, "m_extensions", 372, 15518, 15641);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 372, 15518, 15641);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 372, 15518, 15641);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 372, 15518, 15641);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 372, 15518, 15641);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 372, 15518, 15641);
            CallChecker.varInit(this.m_configMap, "m_configMap", 372, 15518, 15641);
            CallChecker.varInit(this.m_logger, "m_logger", 372, 15518, 15641);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 372, 15518, 15641);
            m_securityContext = securityContext;
            CallChecker.varAssign(this.m_securityContext, "this.m_securityContext", 374, 15600, 15635);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1182.methodEnd();
        }
    }

    synchronized void addExtensionBundle(Felix felix, BundleImpl bundle) throws Exception, SecurityException, BundleException {
        MethodContext _bcornu_methode_context1183 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 391, 15648, 20261);
            CallChecker.varInit(bundle, "bundle", 391, 15648, 20261);
            CallChecker.varInit(felix, "felix", 391, 15648, 20261);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 391, 15648, 20261);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 391, 15648, 20261);
            CallChecker.varInit(this.m_names, "m_names", 391, 15648, 20261);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 391, 15648, 20261);
            CallChecker.varInit(this.m_extensions, "m_extensions", 391, 15648, 20261);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 391, 15648, 20261);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 391, 15648, 20261);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 391, 15648, 20261);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 391, 15648, 20261);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 391, 15648, 20261);
            CallChecker.varInit(this.m_configMap, "m_configMap", 391, 15648, 20261);
            CallChecker.varInit(this.m_logger, "m_logger", 391, 15648, 20261);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 391, 15648, 20261);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 394, 16553, 16592);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(bundle, AdminPermission.EXTENSIONLIFECYCLE));
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 400, 16806, 16811)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 400, 16806, 16811);
                    final BundleProtectionDomain npe_invocation_var427 = ((BundleProtectionDomain) (CallChecker.isCalled(bundle, BundleImpl.class, 400, 16806, 16811).getProtectionDomain()));
                    if (CallChecker.beforeDeref(npe_invocation_var427, BundleProtectionDomain.class, 400, 16806, 16833)) {
                        if (!(CallChecker.isCalled(npe_invocation_var427, BundleProtectionDomain.class, 400, 16806, 16833).impliesDirect(new AllPermission()))) {
                            throw new SecurityException("Extension Bundles must have AllPermission");
                        }
                    }
                }
            }
            String directive = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 407, 17113, 17118)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 407, 17113, 17118);
                final BundleRevisionImpl npe_invocation_var428 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 407, 17113, 17118).adapt(BundleRevision.class)));
                if (CallChecker.beforeDeref(npe_invocation_var428, BundleRevisionImpl.class, 407, 17113, 17146)) {
                    final Map npe_invocation_var429 = CallChecker.isCalled(npe_invocation_var428, BundleRevisionImpl.class, 407, 17113, 17146).getHeaders();
                    if (CallChecker.beforeDeref(npe_invocation_var429, Map.class, 407, 17091, 17177)) {
                        directive = ManifestParser.parseExtensionBundleHeader(((String) (CallChecker.isCalled(npe_invocation_var429, Map.class, 407, 17091, 17177).get(Constants.FRAGMENT_HOST))));
                        CallChecker.varAssign(directive, "directive", 407, 17113, 17118);
                    }
                }
            }
            if (CallChecker.beforeDeref(Constants.EXTENSION_FRAMEWORK, String.class, 411, 17293, 17321)) {
                if (!(CallChecker.isCalled(Constants.EXTENSION_FRAMEWORK, String.class, 411, 17293, 17321).equals(directive))) {
                    throw new BundleException(("Unsupported Extension Bundle type: " + directive), new UnsupportedOperationException("Unsupported Extension Bundle type!"));
                }
            }
            TryContext _bcornu_try_context_333 = new TryContext(333, ExtensionManager.class, "java.lang.Exception");
            try {
                List<BundleCapability> exports = CallChecker.varInit(null, "exports", 421, 17684, 17721);
                TryContext _bcornu_try_context_332 = new TryContext(332, ExtensionManager.class, "java.lang.Exception");
                try {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 426, 17918, 17923)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 426, 17918, 17923);
                        final BundleRevisionImpl npe_invocation_var430 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 426, 17918, 17923).adapt(BundleRevisionImpl.class)));
                        if (CallChecker.beforeDeref(npe_invocation_var430, BundleRevisionImpl.class, 426, 17918, 17955)) {
                            final Map npe_invocation_var431 = CallChecker.isCalled(npe_invocation_var430, BundleRevisionImpl.class, 426, 17918, 17955).getHeaders();
                            if (CallChecker.beforeDeref(npe_invocation_var431, Map.class, 426, 17896, 17994)) {
                                if (CallChecker.beforeDeref(m_systemBundleRevision, BundleRevision.class, 428, 18047, 18068)) {
                                    if (CallChecker.beforeDeref(m_systemBundleRevision, BundleRevision.class, 428, 18089, 18110)) {
                                        exports = ManifestParser.parseExportHeader(m_logger, m_systemBundleRevision, ((String) (CallChecker.isCalled(npe_invocation_var431, Map.class, 426, 17896, 17994).get(Constants.EXPORT_PACKAGE))), CallChecker.isCalled(m_systemBundleRevision, BundleRevision.class, 428, 18047, 18068).getSymbolicName(), CallChecker.isCalled(m_systemBundleRevision, BundleRevision.class, 428, 18089, 18110).getVersion());
                                        CallChecker.varAssign(exports, "exports", 424, 17769, 18125);
                                    }
                                }
                            }
                        }
                    }
                    exports = ExtensionManager.aliasSymbolicName(exports);
                    CallChecker.varAssign(exports, "exports", 429, 18143, 18179);
                } catch (Exception ex) {
                    _bcornu_try_context_332.catchStart(332);
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 437, 18454, 18459)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 437, 18454, 18459);
                        final BundleRevisionImpl npe_invocation_var432 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 437, 18454, 18459).adapt(BundleRevisionImpl.class)));
                        if (CallChecker.beforeDeref(npe_invocation_var432, BundleRevisionImpl.class, 437, 18454, 18491)) {
                            final Map npe_invocation_var433 = CallChecker.isCalled(npe_invocation_var432, BundleRevisionImpl.class, 437, 18454, 18491).getHeaders();
                            if (CallChecker.beforeDeref(npe_invocation_var433, Map.class, 437, 18432, 18530)) {
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 433, 18258, 18265)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 433, 18258, 18265).log(bundle, Logger.LOG_ERROR, ("Error parsing extension bundle export statement: " + (CallChecker.isCalled(npe_invocation_var433, Map.class, 437, 18432, 18530).get(Constants.EXPORT_PACKAGE))), ex);
                                }
                            }
                        }
                    }
                    return ;
                } finally {
                    _bcornu_try_context_332.finallyStart(332);
                }
                if ((ExtensionManager.m_extensionManager) != null) {
                    ExtensionManager.m_extensionManager.addExtension(felix, bundle);
                }else {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 451, 19008, 19015)) {
                        CallChecker.isCalled(m_logger, Logger.class, 451, 19008, 19015).log(bundle, Logger.LOG_WARNING, "Unable to add extension bundle to FrameworkClassLoader - Maybe not an URLClassLoader?");
                    }
                    throw new UnsupportedOperationException("Unable to add extension bundle to FrameworkClassLoader - Maybe not an URLClassLoader?");
                }
                appendCapabilities(exports);
            } catch (Exception ex) {
                _bcornu_try_context_333.catchStart(333);
                throw ex;
            } finally {
                _bcornu_try_context_333.finallyStart(333);
            }
            BundleRevisionImpl bri = CallChecker.init(BundleRevisionImpl.class);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 463, 19517, 19522)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 463, 19517, 19522);
                bri = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 463, 19517, 19522).adapt(BundleRevisionImpl.class)));
                CallChecker.varAssign(bri, "bri", 463, 19517, 19522);
            }
            List<BundleRequirement> reqs = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(bri, BundleRevisionImpl.class, 464, 19596, 19598)) {
                bri = CallChecker.beforeCalled(bri, BundleRevisionImpl.class, 464, 19596, 19598);
                reqs = CallChecker.isCalled(bri, BundleRevisionImpl.class, 464, 19596, 19598).getDeclaredRequirements(BundleRevision.HOST_NAMESPACE);
                CallChecker.varAssign(reqs, "reqs", 464, 19596, 19598);
            }
            List<BundleCapability> caps = CallChecker.varInit(getCapabilities(BundleRevision.HOST_NAMESPACE), "caps", 465, 19664, 19740);
            BundleWire bw = CallChecker.init(BundleWire.class);
            if (CallChecker.beforeDeref(reqs, List.class, 466, 19790, 19793)) {
                if (CallChecker.beforeDeref(caps, List.class, 466, 19827, 19830)) {
                    reqs = CallChecker.beforeCalled(reqs, List.class, 466, 19790, 19793);
                    caps = CallChecker.beforeCalled(caps, List.class, 466, 19827, 19830);
                    bw = new BundleWireImpl(bri, CallChecker.isCalled(reqs, List.class, 466, 19790, 19793).get(0), m_systemBundleRevision, CallChecker.isCalled(caps, List.class, 466, 19827, 19830).get(0));
                    CallChecker.varAssign(bw, "bw", 466, 19790, 19793);
                }
            }
            if (CallChecker.beforeDeref(bri, BundleRevisionImpl.class, 467, 19849, 19851)) {
                bri = CallChecker.beforeCalled(bri, BundleRevisionImpl.class, 467, 19849, 19851);
                CallChecker.isCalled(bri, BundleRevisionImpl.class, 467, 19849, 19851).resolve(new BundleWiringImpl(m_logger, m_configMap, null, bri, null, Collections.singletonList(bw), Collections.EMPTY_MAP, Collections.EMPTY_MAP));
            }
            if (CallChecker.beforeDeref(felix, Felix.class, 477, 20151, 20155)) {
                felix = CallChecker.beforeCalled(felix, Felix.class, 477, 20151, 20155);
                final BundleRevisionDependencies npe_invocation_var434 = CallChecker.isCalled(felix, Felix.class, 477, 20151, 20155).getDependencies();
                if (CallChecker.beforeDeref(npe_invocation_var434, BundleRevisionDependencies.class, 477, 20151, 20173)) {
                    CallChecker.isCalled(npe_invocation_var434, BundleRevisionDependencies.class, 477, 20151, 20173).addDependent(bw);
                }
            }
            if (CallChecker.beforeDeref(felix, Felix.class, 478, 20201, 20205)) {
                felix = CallChecker.beforeCalled(felix, Felix.class, 478, 20201, 20205);
                CallChecker.isCalled(felix, Felix.class, 478, 20201, 20205).setBundleStateAndNotify(bundle, Bundle.RESOLVED);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1183.methodEnd();
        }
    }

    void startExtensionBundle(Felix felix, BundleImpl bundle) {
        MethodContext _bcornu_methode_context1184 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 488, 20268, 22733);
            CallChecker.varInit(bundle, "bundle", 488, 20268, 22733);
            CallChecker.varInit(felix, "felix", 488, 20268, 22733);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 488, 20268, 22733);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 488, 20268, 22733);
            CallChecker.varInit(this.m_names, "m_names", 488, 20268, 22733);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 488, 20268, 22733);
            CallChecker.varInit(this.m_extensions, "m_extensions", 488, 20268, 22733);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 488, 20268, 22733);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 488, 20268, 22733);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 488, 20268, 22733);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 488, 20268, 22733);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 488, 20268, 22733);
            CallChecker.varInit(this.m_configMap, "m_configMap", 488, 20268, 22733);
            CallChecker.varInit(this.m_logger, "m_logger", 488, 20268, 22733);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 488, 20268, 22733);
            Map<?, ?> headers = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 490, 20692, 20697)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 490, 20692, 20697);
                final BundleRevisionImpl npe_invocation_var435 = CallChecker.isCalled(bundle, BundleImpl.class, 490, 20692, 20697).adapt(BundleRevisionImpl.class);
                if (CallChecker.beforeDeref(npe_invocation_var435, BundleRevisionImpl.class, 490, 20692, 20729)) {
                    headers = CallChecker.isCalled(npe_invocation_var435, BundleRevisionImpl.class, 490, 20692, 20729).getHeaders();
                    CallChecker.varAssign(headers, "headers", 490, 20692, 20697);
                }
            }
            String activatorClass = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(headers, Map.class, 491, 20786, 20792)) {
                activatorClass = ((String) (headers.get(Constants.EXTENSION_BUNDLE_ACTIVATOR)));
                CallChecker.varAssign(activatorClass, "activatorClass", 491, 20786, 20792);
            }
            boolean felixExtension = CallChecker.varInit(((boolean) (false)), "felixExtension", 492, 20845, 20875);
            if (activatorClass == null) {
                felixExtension = true;
                CallChecker.varAssign(felixExtension, "felixExtension", 495, 20935, 20956);
                if (CallChecker.beforeDeref(headers, Map.class, 496, 20996, 21002)) {
                    activatorClass = ((String) (headers.get(FelixConstants.FELIX_EXTENSION_ACTIVATOR)));
                    CallChecker.varAssign(activatorClass, "activatorClass", 496, 20970, 21049);
                }
            }
            if (activatorClass != null) {
                ExtensionManager.ExtensionTuple tuple = CallChecker.varInit(null, "tuple", 501, 21120, 21147);
                TryContext _bcornu_try_context_334 = new TryContext(334, ExtensionManager.class, "java.lang.Throwable");
                try {
                    BundleActivator activator = CallChecker.init(BundleActivator.class);
                    if (CallChecker.beforeDeref(felix, Felix.class, 506, 21312, 21316)) {
                        felix = CallChecker.beforeCalled(felix, Felix.class, 506, 21312, 21316);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(felix, Felix.class, 506, 21312, 21316).getClass(), Class.class, 506, 21312, 21327)) {
                            felix = CallChecker.beforeCalled(felix, Felix.class, 506, 21312, 21316);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(felix, Felix.class, 506, 21312, 21316).getClass(), Class.class, 506, 21312, 21327).getClassLoader(), ClassLoader.class, 506, 21312, 21344)) {
                                felix = CallChecker.beforeCalled(felix, Felix.class, 506, 21312, 21316);
                                activatorClass = CallChecker.beforeCalled(activatorClass, String.class, 507, 21381, 21394);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(felix, Felix.class, 506, 21312, 21316).getClass(), Class.class, 506, 21312, 21327).getClassLoader(), ClassLoader.class, 506, 21312, 21344).loadClass(CallChecker.isCalled(activatorClass, String.class, 507, 21381, 21394).trim()), Class.class, 506, 21312, 21402)) {
                                    felix = CallChecker.beforeCalled(felix, Felix.class, 506, 21312, 21316);
                                    activator = ((BundleActivator) (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(felix, Felix.class, 506, 21312, 21316).getClass(), Class.class, 506, 21312, 21327).getClassLoader(), ClassLoader.class, 506, 21312, 21344).loadClass(activatorClass.trim()).newInstance()));
                                    CallChecker.varAssign(activator, "activator", 506, 21312, 21316);
                                }
                            }
                        }
                    }
                    BundleContext context = CallChecker.init(BundleContext.class);
                    if (CallChecker.beforeDeref(felix, Felix.class, 509, 21460, 21464)) {
                        felix = CallChecker.beforeCalled(felix, Felix.class, 509, 21460, 21464);
                        context = CallChecker.isCalled(felix, Felix.class, 509, 21460, 21464)._getBundleContext();
                        CallChecker.varAssign(context, "context", 509, 21460, 21464);
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 511, 21504, 21509)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 511, 21504, 21509);
                        CallChecker.isCalled(bundle, BundleImpl.class, 511, 21504, 21509).setBundleContext(context);
                    }
                    if (!felixExtension) {
                        tuple = new ExtensionManager.ExtensionTuple(activator, bundle);
                        CallChecker.varAssign(tuple, "tuple", 516, 21684, 21729);
                        if (CallChecker.beforeDeref(m_extensionTuples, List.class, 517, 21751, 21767)) {
                            CallChecker.isCalled(m_extensionTuples, List.class, 517, 21751, 21767).add(tuple);
                        }
                    }else {
                        if (CallChecker.beforeDeref(felix, Felix.class, 521, 21858, 21862)) {
                            felix = CallChecker.beforeCalled(felix, Felix.class, 521, 21858, 21862);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(felix, Felix.class, 521, 21858, 21862).m_activatorList, List.class, 521, 21858, 21878)) {
                                felix = CallChecker.beforeCalled(felix, Felix.class, 521, 21858, 21862);
                                CallChecker.isCalled(felix, Felix.class, 521, 21858, 21862).m_activatorList = CallChecker.beforeCalled(CallChecker.isCalled(felix, Felix.class, 521, 21858, 21862).m_activatorList, List.class, 521, 21858, 21878);
                                CallChecker.isCalled(CallChecker.isCalled(felix, Felix.class, 521, 21858, 21862).m_activatorList, List.class, 521, 21858, 21878).add(activator);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(felix, Felix.class, 524, 21936, 21940)) {
                        if (CallChecker.beforeDeref(felix, Felix.class, 524, 21975, 21979)) {
                            felix = CallChecker.beforeCalled(felix, Felix.class, 524, 21936, 21940);
                            felix = CallChecker.beforeCalled(felix, Felix.class, 524, 21975, 21979);
                            if (((CallChecker.isCalled(felix, Felix.class, 524, 21936, 21940).getState()) == (Bundle.ACTIVE)) || ((CallChecker.isCalled(felix, Felix.class, 524, 21975, 21979).getState()) == (Bundle.STARTING))) {
                                if (tuple != null) {
                                    tuple.m_started = true;
                                    CallChecker.varAssign(tuple.m_started, "tuple.m_started", 528, 22116, 22138);
                                }
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 530, 22182, 22201)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 530, 22182, 22201).startActivator(activator, context);
                                }
                            }
                        }
                    }
                } catch (Throwable ex) {
                    _bcornu_try_context_334.catchStart(334);
                    if (tuple != null) {
                        tuple.m_failed = true;
                        CallChecker.varAssign(tuple.m_failed, "tuple.m_failed", 537, 22391, 22412);
                    }
                    if (CallChecker.beforeDeref(felix, Felix.class, 539, 22448, 22452)) {
                        felix = CallChecker.beforeCalled(felix, Felix.class, 539, 22448, 22452);
                        CallChecker.isCalled(felix, Felix.class, 539, 22448, 22452).fireFrameworkEvent(FrameworkEvent.ERROR, bundle, new BundleException("Unable to start Bundle", ex));
                    }
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 542, 22600, 22607)) {
                        CallChecker.isCalled(m_logger, Logger.class, 542, 22600, 22607).log(bundle, Logger.LOG_WARNING, "Unable to start Extension Activator", ex);
                    }
                } finally {
                    _bcornu_try_context_334.finallyStart(334);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1184.methodEnd();
        }
    }

    void startPendingExtensionBundles(Felix felix) {
        MethodContext _bcornu_methode_context1185 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 548, 22740, 23704);
            CallChecker.varInit(felix, "felix", 548, 22740, 23704);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 548, 22740, 23704);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 548, 22740, 23704);
            CallChecker.varInit(this.m_names, "m_names", 548, 22740, 23704);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 548, 22740, 23704);
            CallChecker.varInit(this.m_extensions, "m_extensions", 548, 22740, 23704);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 548, 22740, 23704);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 548, 22740, 23704);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 548, 22740, 23704);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 548, 22740, 23704);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 548, 22740, 23704);
            CallChecker.varInit(this.m_configMap, "m_configMap", 548, 22740, 23704);
            CallChecker.varInit(this.m_logger, "m_logger", 548, 22740, 23704);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 548, 22740, 23704);
            for (int i = 0; i < (CallChecker.isCalled(m_extensionTuples, List.class, 550, 22820, 22836).size()); i++) {
                if (CallChecker.beforeDeref(m_extensionTuples, List.class, 552, 22877, 22893)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 552, 22877, 22893).get(i), ExtensionManager.ExtensionTuple.class, 552, 22877, 22900)) {
                        if (!(CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 552, 22877, 22893).get(i), ExtensionManager.ExtensionTuple.class, 552, 22877, 22900).m_started)) {
                            if (CallChecker.beforeDeref(m_extensionTuples, List.class, 554, 22943, 22959)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 554, 22943, 22959).get(i), ExtensionManager.ExtensionTuple.class, 554, 22943, 22966)) {
                                    CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 554, 22943, 22959).get(i), ExtensionManager.ExtensionTuple.class, 554, 22943, 22966).m_started = true;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.m_extensionTuples, List.class, 554, 22943, 22959).get(i), ExtensionManager.ExtensionTuple.class, 554, 22943, 22966).m_started, "CallChecker.isCalled(CallChecker.isCalled(this.m_extensionTuples, List.class, 554, 22943, 22959).get(i), ExtensionManager.ExtensionTuple.class, 554, 22943, 22966).m_started", 554, 22943, 22984);
                                }
                            }
                            TryContext _bcornu_try_context_335 = new TryContext(335, ExtensionManager.class, "java.lang.Throwable");
                            try {
                                if (CallChecker.beforeDeref(m_extensionTuples, List.class, 557, 23080, 23096)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 557, 23080, 23096).get(i), ExtensionManager.ExtensionTuple.class, 557, 23080, 23103)) {
                                        if (CallChecker.beforeDeref(felix, Felix.class, 557, 23118, 23122)) {
                                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 557, 23044, 23063)) {
                                                felix = CallChecker.beforeCalled(felix, Felix.class, 557, 23118, 23122);
                                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 557, 23044, 23063).startActivator(CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 557, 23080, 23096).get(i), ExtensionManager.ExtensionTuple.class, 557, 23080, 23103).m_activator, CallChecker.isCalled(felix, Felix.class, 557, 23118, 23122)._getBundleContext());
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable ex) {
                                _bcornu_try_context_335.catchStart(335);
                                if (CallChecker.beforeDeref(m_extensionTuples, List.class, 561, 23239, 23255)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 561, 23239, 23255).get(i), ExtensionManager.ExtensionTuple.class, 561, 23239, 23262)) {
                                        CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 561, 23239, 23255).get(i), ExtensionManager.ExtensionTuple.class, 561, 23239, 23262).m_failed = true;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.m_extensionTuples, List.class, 561, 23239, 23255).get(i), ExtensionManager.ExtensionTuple.class, 561, 23239, 23262).m_failed, "CallChecker.isCalled(CallChecker.isCalled(this.m_extensionTuples, List.class, 561, 23239, 23255).get(i), ExtensionManager.ExtensionTuple.class, 561, 23239, 23262).m_failed", 561, 23239, 23279);
                                    }
                                }
                                if (CallChecker.beforeDeref(m_extensionTuples, List.class, 563, 23349, 23365)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 563, 23349, 23365).get(i), ExtensionManager.ExtensionTuple.class, 563, 23349, 23372)) {
                                        if (CallChecker.beforeDeref(felix, Felix.class, 563, 23302, 23306)) {
                                            felix = CallChecker.beforeCalled(felix, Felix.class, 563, 23302, 23306);
                                            CallChecker.isCalled(felix, Felix.class, 563, 23302, 23306).fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 563, 23349, 23365).get(i), ExtensionManager.ExtensionTuple.class, 563, 23349, 23372).m_bundle, new BundleException("Unable to start Bundle", BundleException.ACTIVATOR_ERROR, ex));
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(m_extensionTuples, List.class, 566, 23535, 23551)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 566, 23535, 23551).get(i), ExtensionManager.ExtensionTuple.class, 566, 23535, 23558)) {
                                        if (CallChecker.beforeDeref(m_logger, Logger.class, 566, 23522, 23529)) {
                                            CallChecker.isCalled(m_logger, Logger.class, 566, 23522, 23529).log(CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 566, 23535, 23551).get(i), ExtensionManager.ExtensionTuple.class, 566, 23535, 23558).m_bundle, Logger.LOG_WARNING, "Unable to start Extension Activator", ex);
                                        }
                                    }
                                }
                            } finally {
                                _bcornu_try_context_335.finallyStart(335);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1185.methodEnd();
        }
    }

    void stopExtensionBundles(Felix felix) {
        MethodContext _bcornu_methode_context1186 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 573, 23711, 24620);
            CallChecker.varInit(felix, "felix", 573, 23711, 24620);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 573, 23711, 24620);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 573, 23711, 24620);
            CallChecker.varInit(this.m_names, "m_names", 573, 23711, 24620);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 573, 23711, 24620);
            CallChecker.varInit(this.m_extensions, "m_extensions", 573, 23711, 24620);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 573, 23711, 24620);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 573, 23711, 24620);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 573, 23711, 24620);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 573, 23711, 24620);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 573, 23711, 24620);
            CallChecker.varInit(this.m_configMap, "m_configMap", 573, 23711, 24620);
            CallChecker.varInit(this.m_logger, "m_logger", 573, 23711, 24620);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 573, 23711, 24620);
            for (int i = (CallChecker.isCalled(m_extensionTuples, List.class, 575, 23777, 23793).size()) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(m_extensionTuples, List.class, 577, 23845, 23861)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 577, 23845, 23861).get(i), ExtensionManager.ExtensionTuple.class, 577, 23845, 23868)) {
                        if (CallChecker.beforeDeref(m_extensionTuples, List.class, 577, 23884, 23900)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 577, 23884, 23900).get(i), ExtensionManager.ExtensionTuple.class, 577, 23884, 23907)) {
                                if ((CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 577, 23845, 23861).get(i), ExtensionManager.ExtensionTuple.class, 577, 23845, 23868).m_started) && (!(CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 577, 23884, 23900).get(i), ExtensionManager.ExtensionTuple.class, 577, 23884, 23907).m_failed))) {
                                    TryContext _bcornu_try_context_336 = new TryContext(336, ExtensionManager.class, "java.lang.Throwable");
                                    try {
                                        if (CallChecker.beforeDeref(m_extensionTuples, List.class, 581, 24026, 24042)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 581, 24026, 24042).get(i), ExtensionManager.ExtensionTuple.class, 581, 24026, 24049)) {
                                                if (CallChecker.beforeDeref(felix, Felix.class, 581, 24064, 24068)) {
                                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 581, 23991, 24010)) {
                                                        felix = CallChecker.beforeCalled(felix, Felix.class, 581, 24064, 24068);
                                                        CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 581, 23991, 24010).stopActivator(CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 581, 24026, 24042).get(i), ExtensionManager.ExtensionTuple.class, 581, 24026, 24049).m_activator, CallChecker.isCalled(felix, Felix.class, 581, 24064, 24068)._getBundleContext());
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Throwable ex) {
                                        _bcornu_try_context_336.catchStart(336);
                                        if (CallChecker.beforeDeref(m_extensionTuples, List.class, 585, 24232, 24248)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 585, 24232, 24248).get(i), ExtensionManager.ExtensionTuple.class, 585, 24232, 24255)) {
                                                if (CallChecker.beforeDeref(felix, Felix.class, 585, 24185, 24189)) {
                                                    felix = CallChecker.beforeCalled(felix, Felix.class, 585, 24185, 24189);
                                                    CallChecker.isCalled(felix, Felix.class, 585, 24185, 24189).fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 585, 24232, 24248).get(i), ExtensionManager.ExtensionTuple.class, 585, 24232, 24255).m_bundle, new BundleException("Unable to stop Bundle", BundleException.ACTIVATOR_ERROR, ex));
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(m_extensionTuples, List.class, 588, 24417, 24433)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_extensionTuples, List.class, 588, 24417, 24433).get(i), ExtensionManager.ExtensionTuple.class, 588, 24417, 24440)) {
                                                if (CallChecker.beforeDeref(m_logger, Logger.class, 588, 24404, 24411)) {
                                                    CallChecker.isCalled(m_logger, Logger.class, 588, 24404, 24411).log(CallChecker.isCalled(CallChecker.isCalled(m_extensionTuples, List.class, 588, 24417, 24433).get(i), ExtensionManager.ExtensionTuple.class, 588, 24417, 24440).m_bundle, Logger.LOG_WARNING, "Unable to stop Extension Activator", ex);
                                                }
                                            }
                                        }
                                    } finally {
                                        _bcornu_try_context_336.finallyStart(336);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_extensionTuples, List.class, 593, 24589, 24605)) {
                CallChecker.isCalled(m_extensionTuples, List.class, 593, 24589, 24605).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1186.methodEnd();
        }
    }

    void removeExtensions(Felix felix) {
        MethodContext _bcornu_methode_context1187 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 603, 24627, 25114);
            CallChecker.varInit(felix, "felix", 603, 24627, 25114);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 603, 24627, 25114);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 603, 24627, 25114);
            CallChecker.varInit(this.m_names, "m_names", 603, 24627, 25114);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 603, 24627, 25114);
            CallChecker.varInit(this.m_extensions, "m_extensions", 603, 24627, 25114);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 603, 24627, 25114);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 603, 24627, 25114);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 603, 24627, 25114);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 603, 24627, 25114);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 603, 24627, 25114);
            CallChecker.varInit(this.m_configMap, "m_configMap", 603, 24627, 25114);
            CallChecker.varInit(this.m_logger, "m_logger", 603, 24627, 25114);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 603, 24627, 25114);
            if ((ExtensionManager.m_extensionManager) != null) {
                ExtensionManager.m_extensionManager._removeExtensions(felix);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1187.methodEnd();
        }
    }

    private List<BundleCapability> getCapabilities(String namespace) {
        MethodContext _bcornu_methode_context1188 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 611, 25121, 25631);
            CallChecker.varInit(namespace, "namespace", 611, 25121, 25631);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 611, 25121, 25631);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 611, 25121, 25631);
            CallChecker.varInit(this.m_names, "m_names", 611, 25121, 25631);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 611, 25121, 25631);
            CallChecker.varInit(this.m_extensions, "m_extensions", 611, 25121, 25631);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 611, 25121, 25631);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 611, 25121, 25631);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 611, 25121, 25631);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 611, 25121, 25631);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 611, 25121, 25631);
            CallChecker.varInit(this.m_configMap, "m_configMap", 611, 25121, 25631);
            CallChecker.varInit(this.m_logger, "m_logger", 611, 25121, 25631);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 611, 25121, 25631);
            List<BundleCapability> caps = CallChecker.varInit(m_capabilities, "caps", 613, 25200, 25244);
            List<BundleCapability> result = CallChecker.varInit(caps, "result", 614, 25254, 25290);
            if (namespace != null) {
                result = new ArrayList<BundleCapability>();
                CallChecker.varAssign(result, "result", 617, 25345, 25387);
                if (CallChecker.beforeDeref(caps, List.class, 618, 25429, 25432)) {
                    for (BundleCapability cap : caps) {
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 620, 25469, 25471)) {
                            final String npe_invocation_var436 = CallChecker.isCalled(cap, BundleCapability.class, 620, 25469, 25471).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var436, String.class, 620, 25469, 25486)) {
                                if (CallChecker.isCalled(npe_invocation_var436, String.class, 620, 25469, 25486).equals(namespace)) {
                                    if (CallChecker.beforeDeref(result, List.class, 622, 25545, 25550)) {
                                        result = CallChecker.beforeCalled(result, List.class, 622, 25545, 25550);
                                        CallChecker.isCalled(result, List.class, 622, 25545, 25550).add(cap);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1188.methodEnd();
        }
    }

    private synchronized void appendCapabilities(List<BundleCapability> caps) {
        MethodContext _bcornu_methode_context1189 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 629, 25638, 26070);
            CallChecker.varInit(caps, "caps", 629, 25638, 26070);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 629, 25638, 26070);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 629, 25638, 26070);
            CallChecker.varInit(this.m_names, "m_names", 629, 25638, 26070);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 629, 25638, 26070);
            CallChecker.varInit(this.m_extensions, "m_extensions", 629, 25638, 26070);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 629, 25638, 26070);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 629, 25638, 26070);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 629, 25638, 26070);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 629, 25638, 26070);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 629, 25638, 26070);
            CallChecker.varInit(this.m_configMap, "m_configMap", 629, 25638, 26070);
            CallChecker.varInit(this.m_logger, "m_logger", 629, 25638, 26070);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 629, 25638, 26070);
            List<BundleCapability> newCaps = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_capabilities, List.class, 632, 25803, 25816)) {
                if (CallChecker.beforeDeref(caps, List.class, 632, 25827, 25830)) {
                    m_capabilities = CallChecker.beforeCalled(m_capabilities, List.class, 632, 25803, 25816);
                    caps = CallChecker.beforeCalled(caps, List.class, 632, 25827, 25830);
                    newCaps = new ArrayList<BundleCapability>(((CallChecker.isCalled(m_capabilities, List.class, 632, 25803, 25816).size()) + (CallChecker.isCalled(caps, List.class, 632, 25827, 25830).size())));
                    CallChecker.varAssign(newCaps, "newCaps", 632, 25803, 25816);
                }
            }
            if (CallChecker.beforeDeref(newCaps, List.class, 633, 25849, 25855)) {
                newCaps = CallChecker.beforeCalled(newCaps, List.class, 633, 25849, 25855);
                CallChecker.isCalled(newCaps, List.class, 633, 25849, 25855).addAll(m_capabilities);
            }
            if (CallChecker.beforeDeref(newCaps, List.class, 634, 25889, 25895)) {
                newCaps = CallChecker.beforeCalled(newCaps, List.class, 634, 25889, 25895);
                CallChecker.isCalled(newCaps, List.class, 634, 25889, 25895).addAll(caps);
            }
            m_capabilities = ImmutableList.newInstance(newCaps);
            CallChecker.varAssign(this.m_capabilities, "this.m_capabilities", 635, 25919, 25970);
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 636, 25980, 25990)) {
                CallChecker.isCalled(m_headerMap, Map.class, 636, 25980, 25990).put(Constants.EXPORT_PACKAGE, convertCapabilitiesToHeaders(m_headerMap));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1189.methodEnd();
        }
    }

    private String convertCapabilitiesToHeaders(Map headers) {
        MethodContext _bcornu_methode_context1190 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 639, 26077, 28104);
            CallChecker.varInit(headers, "headers", 639, 26077, 28104);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 639, 26077, 28104);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 639, 26077, 28104);
            CallChecker.varInit(this.m_names, "m_names", 639, 26077, 28104);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 639, 26077, 28104);
            CallChecker.varInit(this.m_extensions, "m_extensions", 639, 26077, 28104);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 639, 26077, 28104);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 639, 26077, 28104);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 639, 26077, 28104);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 639, 26077, 28104);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 639, 26077, 28104);
            CallChecker.varInit(this.m_configMap, "m_configMap", 639, 26077, 28104);
            CallChecker.varInit(this.m_logger, "m_logger", 639, 26077, 28104);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 639, 26077, 28104);
            StringBuffer exportSB = CallChecker.varInit(new StringBuffer(""), "exportSB", 641, 26148, 26192);
            Set<String> exportNames = CallChecker.varInit(new HashSet<String>(), "exportNames", 642, 26202, 26249);
            List<BundleCapability> caps = CallChecker.varInit(m_capabilities, "caps", 644, 26260, 26304);
            if (CallChecker.beforeDeref(caps, String.class, 645, 26342, 26345)) {
                for (BundleCapability cap : caps) {
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 647, 26374, 26376)) {
                        final String npe_invocation_var437 = CallChecker.isCalled(cap, BundleCapability.class, 647, 26374, 26376).getNamespace();
                        if (CallChecker.beforeDeref(npe_invocation_var437, String.class, 647, 26374, 26391)) {
                            if (CallChecker.isCalled(npe_invocation_var437, String.class, 647, 26374, 26391).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 650, 26542, 26549)) {
                                    exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 650, 26542, 26549);
                                    if ((CallChecker.isCalled(exportSB, StringBuffer.class, 650, 26542, 26549).length()) > 0) {
                                        if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 652, 26603, 26610)) {
                                            exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 652, 26603, 26610);
                                            CallChecker.isCalled(exportSB, StringBuffer.class, 652, 26603, 26610).append(", ");
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 656, 26733, 26735)) {
                                    final Map<String, Object> npe_invocation_var438 = CallChecker.isCalled(cap, BundleCapability.class, 656, 26733, 26735).getAttributes();
                                    if (CallChecker.beforeDeref(npe_invocation_var438, Map.class, 656, 26733, 26751)) {
                                        if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 656, 26717, 26724)) {
                                            exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 656, 26717, 26724);
                                            CallChecker.isCalled(exportSB, StringBuffer.class, 656, 26717, 26724).append(CallChecker.isCalled(npe_invocation_var438, Map.class, 656, 26733, 26751).get(BundleRevision.PACKAGE_NAMESPACE));
                                        }
                                    }
                                }
                                for (Map.Entry<String, String> entry : CallChecker.isCalled(CallChecker.isCalled(cap, BundleCapability.class, 657, 26844, 26846).getDirectives(), Map.class, 657, 26844, 26862).entrySet()) {
                                    if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 659, 26914, 26921)) {
                                        exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 659, 26914, 26921);
                                        CallChecker.isCalled(exportSB, StringBuffer.class, 659, 26914, 26921).append("; ");
                                    }
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 660, 26973, 26977)) {
                                        if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 660, 26957, 26964)) {
                                            exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 660, 26957, 26964);
                                            CallChecker.isCalled(exportSB, StringBuffer.class, 660, 26957, 26964).append(CallChecker.isCalled(entry, Map.Entry.class, 660, 26973, 26977).getKey());
                                        }
                                    }
                                    if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 661, 27010, 27017)) {
                                        exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 661, 27010, 27017);
                                        CallChecker.isCalled(exportSB, StringBuffer.class, 661, 27010, 27017).append(":=\"");
                                    }
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 662, 27071, 27075)) {
                                        if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 662, 27055, 27062)) {
                                            exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 662, 27055, 27062);
                                            CallChecker.isCalled(exportSB, StringBuffer.class, 662, 27055, 27062).append(CallChecker.isCalled(entry, Map.Entry.class, 662, 27071, 27075).getValue());
                                        }
                                    }
                                    if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 663, 27110, 27117)) {
                                        exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 663, 27110, 27117);
                                        CallChecker.isCalled(exportSB, StringBuffer.class, 663, 27110, 27117).append("\"");
                                    }
                                }
                                for (Map.Entry<String, Object> entry : CallChecker.isCalled(CallChecker.isCalled(cap, BundleCapability.class, 665, 27202, 27204).getAttributes(), Map.class, 665, 27202, 27220).entrySet()) {
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 667, 27277, 27281)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 667, 27277, 27281).getKey(), String.class, 667, 27277, 27290)) {
                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 668, 27361, 27365)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 668, 27361, 27365).getKey(), String.class, 668, 27361, 27374)) {
                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 669, 27452, 27456)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 669, 27452, 27456).getKey(), String.class, 669, 27452, 27465)) {
                                                            if (((!(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 667, 27277, 27281).getKey(), String.class, 667, 27277, 27290).equals(BundleRevision.PACKAGE_NAMESPACE))) && (!(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 668, 27361, 27365).getKey(), String.class, 668, 27361, 27374).equals(Constants.BUNDLE_SYMBOLICNAME_ATTRIBUTE)))) && (!(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 669, 27452, 27456).getKey(), String.class, 669, 27452, 27465).equals(Constants.BUNDLE_VERSION_ATTRIBUTE)))) {
                                                                if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 671, 27557, 27564)) {
                                                                    exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 671, 27557, 27564);
                                                                    CallChecker.isCalled(exportSB, StringBuffer.class, 671, 27557, 27564).append("; ");
                                                                }
                                                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 672, 27620, 27624)) {
                                                                    if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 672, 27604, 27611)) {
                                                                        exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 672, 27604, 27611);
                                                                        CallChecker.isCalled(exportSB, StringBuffer.class, 672, 27604, 27611).append(CallChecker.isCalled(entry, Map.Entry.class, 672, 27620, 27624).getKey());
                                                                    }
                                                                }
                                                                if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 673, 27661, 27668)) {
                                                                    exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 673, 27661, 27668);
                                                                    CallChecker.isCalled(exportSB, StringBuffer.class, 673, 27661, 27668).append("=\"");
                                                                }
                                                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 674, 27725, 27729)) {
                                                                    if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 674, 27709, 27716)) {
                                                                        exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 674, 27709, 27716);
                                                                        CallChecker.isCalled(exportSB, StringBuffer.class, 674, 27709, 27716).append(CallChecker.isCalled(entry, Map.Entry.class, 674, 27725, 27729).getValue());
                                                                    }
                                                                }
                                                                if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 675, 27768, 27775)) {
                                                                    exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 675, 27768, 27775);
                                                                    CallChecker.isCalled(exportSB, StringBuffer.class, 675, 27768, 27775).append("\"");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(cap, BundleCapability.class, 681, 27941, 27943)) {
                                    final Map<String, Object> npe_invocation_var439 = CallChecker.isCalled(cap, BundleCapability.class, 681, 27941, 27943).getAttributes();
                                    if (CallChecker.beforeDeref(npe_invocation_var439, Map.class, 681, 27941, 27959)) {
                                        if (CallChecker.beforeDeref(exportNames, Set.class, 680, 27895, 27905)) {
                                            exportNames = CallChecker.beforeCalled(exportNames, Set.class, 680, 27895, 27905);
                                            CallChecker.isCalled(exportNames, Set.class, 680, 27895, 27905).add(((String) (CallChecker.isCalled(npe_invocation_var439, Map.class, 681, 27941, 27959).get(BundleRevision.PACKAGE_NAMESPACE))));
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
            m_exportNames = exportNames;
            CallChecker.varAssign(this.m_exportNames, "this.m_exportNames", 685, 28034, 28061);
            if (CallChecker.beforeDeref(exportSB, StringBuffer.class, 687, 28079, 28086)) {
                exportSB = CallChecker.beforeCalled(exportSB, StringBuffer.class, 687, 28079, 28086);
                return CallChecker.isCalled(exportSB, StringBuffer.class, 687, 28079, 28086).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1190.methodEnd();
        }
    }

    public URLConnection openConnection(URL url) throws IOException {
        MethodContext _bcornu_methode_context1192 = new MethodContext(URLConnection.class);
        try {
            CallChecker.varInit(this, "this", 698, 28111, 29428);
            CallChecker.varInit(url, "url", 698, 28111, 29428);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 698, 28111, 29428);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 698, 28111, 29428);
            CallChecker.varInit(this.m_names, "m_names", 698, 28111, 29428);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 698, 28111, 29428);
            CallChecker.varInit(this.m_extensions, "m_extensions", 698, 28111, 29428);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 698, 28111, 29428);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 698, 28111, 29428);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 698, 28111, 29428);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 698, 28111, 29428);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 698, 28111, 29428);
            CallChecker.varInit(this.m_configMap, "m_configMap", 698, 28111, 29428);
            CallChecker.varInit(this.m_logger, "m_logger", 698, 28111, 29428);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 698, 28111, 29428);
            String path = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(url, URL.class, 700, 28370, 28372)) {
                url = CallChecker.beforeCalled(url, URL.class, 700, 28370, 28372);
                path = CallChecker.isCalled(url, URL.class, 700, 28370, 28372).getPath();
                CallChecker.varAssign(path, "path", 700, 28370, 28372);
            }
            if (CallChecker.beforeDeref(path, String.class, 702, 28398, 28401)) {
                path = CallChecker.beforeCalled(path, String.class, 702, 28398, 28401);
                if (CallChecker.beforeDeref(CallChecker.isCalled(path, String.class, 702, 28398, 28401).trim(), String.class, 702, 28398, 28408)) {
                    path = CallChecker.beforeCalled(path, String.class, 702, 28398, 28401);
                    if (CallChecker.isCalled(CallChecker.isCalled(path, String.class, 702, 28398, 28401).trim(), String.class, 702, 28398, 28408).equals("/")) {
                        return new URLHandlersBundleURLConnection(url);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Bundle[] extensions = CallChecker.varInit(m_extensionsCache, "extensions", 707, 28512, 28551);
            URL result = CallChecker.varInit(null, "result", 708, 28561, 28578);
            if (CallChecker.beforeDeref(extensions, URLConnection.class, 709, 28612, 28621)) {
                for (Bundle extBundle : extensions) {
                    TryContext _bcornu_try_context_337 = new TryContext(337, ExtensionManager.class, "java.lang.Exception");
                    try {
                        BundleRevisionImpl bri = CallChecker.init(BundleRevisionImpl.class);
                        if (CallChecker.beforeDeref(extBundle, Bundle.class, 714, 28746, 28754)) {
                            bri = ((BundleRevisionImpl) (CallChecker.isCalled(extBundle, Bundle.class, 714, 28746, 28754).adapt(BundleRevision.class)));
                            CallChecker.varAssign(bri, "bri", 714, 28746, 28754);
                        }
                        if (bri != null) {
                            result = bri.getResourceLocal(path);
                            CallChecker.varAssign(result, "result", 717, 28856, 28891);
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_337.catchStart(337);
                    } finally {
                        _bcornu_try_context_337.finallyStart(337);
                    }
                    if (result != null) {
                        return result.openConnection();
                    }
                }
            }
            return new URLConnection(url) {
                public void connect() throws IOException {
                    MethodContext _bcornu_methode_context1191 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 732, 29246, 29407);
                        throw new IOException("Resource not provided by any extension!");
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1191.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLConnection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1192.methodEnd();
        }
    }

    @Override
    protected InetAddress getHostAddress(URL u) {
        MethodContext _bcornu_methode_context1193 = new MethodContext(InetAddress.class);
        try {
            CallChecker.varInit(this, "this", 740, 29435, 29580);
            CallChecker.varInit(u, "u", 740, 29435, 29580);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 740, 29435, 29580);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 740, 29435, 29580);
            CallChecker.varInit(this.m_names, "m_names", 740, 29435, 29580);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 740, 29435, 29580);
            CallChecker.varInit(this.m_extensions, "m_extensions", 740, 29435, 29580);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 740, 29435, 29580);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 740, 29435, 29580);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 740, 29435, 29580);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 740, 29435, 29580);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 740, 29435, 29580);
            CallChecker.varInit(this.m_configMap, "m_configMap", 740, 29435, 29580);
            CallChecker.varInit(this.m_logger, "m_logger", 740, 29435, 29580);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 740, 29435, 29580);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((InetAddress) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1193.methodEnd();
        }
    }

    private synchronized void addExtension(Object source, Bundle extension) {
        MethodContext _bcornu_methode_context1194 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 746, 29587, 30120);
            CallChecker.varInit(extension, "extension", 746, 29587, 30120);
            CallChecker.varInit(source, "source", 746, 29587, 30120);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 746, 29587, 30120);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 746, 29587, 30120);
            CallChecker.varInit(this.m_names, "m_names", 746, 29587, 30120);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 746, 29587, 30120);
            CallChecker.varInit(this.m_extensions, "m_extensions", 746, 29587, 30120);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 746, 29587, 30120);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 746, 29587, 30120);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 746, 29587, 30120);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 746, 29587, 30120);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 746, 29587, 30120);
            CallChecker.varInit(this.m_configMap, "m_configMap", 746, 29587, 30120);
            CallChecker.varInit(this.m_logger, "m_logger", 746, 29587, 30120);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 746, 29587, 30120);
            List sourceExtensions = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_sourceToExtensions, Map.class, 748, 29704, 29723)) {
                sourceExtensions = ((List) (CallChecker.isCalled(m_sourceToExtensions, Map.class, 748, 29704, 29723).get(source)));
                CallChecker.varAssign(sourceExtensions, "sourceExtensions", 748, 29704, 29723);
            }
            if (sourceExtensions == null) {
                sourceExtensions = new ArrayList();
                CallChecker.varAssign(sourceExtensions, "sourceExtensions", 752, 29799, 29833);
                if (CallChecker.beforeDeref(m_sourceToExtensions, Map.class, 753, 29847, 29866)) {
                    CallChecker.isCalled(m_sourceToExtensions, Map.class, 753, 29847, 29866).put(source, sourceExtensions);
                }
            }
            if (CallChecker.beforeDeref(sourceExtensions, List.class, 756, 29918, 29933)) {
                sourceExtensions = CallChecker.beforeCalled(sourceExtensions, List.class, 756, 29918, 29933);
                CallChecker.isCalled(sourceExtensions, List.class, 756, 29918, 29933).add(extension);
            }
            if (CallChecker.beforeDeref(extension, Bundle.class, 758, 29965, 29973)) {
                extension = CallChecker.beforeCalled(extension, Bundle.class, 758, 29965, 29973);
                _add(CallChecker.isCalled(extension, Bundle.class, 758, 29965, 29973).getSymbolicName(), extension);
            }
            if (CallChecker.beforeDeref(m_extensions, List.class, 760, 30093, 30104)) {
                if (CallChecker.beforeDeref(m_extensions, List.class, 760, 30061, 30072)) {
                    m_extensionsCache = ((Bundle[]) (CallChecker.isCalled(m_extensions, List.class, 760, 30061, 30072).toArray(new Bundle[CallChecker.isCalled(m_extensions, List.class, 760, 30093, 30104).size()])));
                    CallChecker.varAssign(this.m_extensionsCache, "this.m_extensionsCache", 759, 30014, 30114);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1194.methodEnd();
        }
    }

    private synchronized void _removeExtensions(Object source) {
        MethodContext _bcornu_methode_context1195 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 763, 30127, 30842);
            CallChecker.varInit(source, "source", 763, 30127, 30842);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 763, 30127, 30842);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 763, 30127, 30842);
            CallChecker.varInit(this.m_names, "m_names", 763, 30127, 30842);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 763, 30127, 30842);
            CallChecker.varInit(this.m_extensions, "m_extensions", 763, 30127, 30842);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 763, 30127, 30842);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 763, 30127, 30842);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 763, 30127, 30842);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 763, 30127, 30842);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 763, 30127, 30842);
            CallChecker.varInit(this.m_configMap, "m_configMap", 763, 30127, 30842);
            CallChecker.varInit(this.m_logger, "m_logger", 763, 30127, 30842);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 763, 30127, 30842);
            if (CallChecker.beforeDeref(m_sourceToExtensions, Map.class, 765, 30204, 30223)) {
                if ((CallChecker.isCalled(m_sourceToExtensions, Map.class, 765, 30204, 30223).remove(source)) == null) {
                    return ;
                }
            }
            if (CallChecker.beforeDeref(m_extensions, List.class, 770, 30298, 30309)) {
                CallChecker.isCalled(m_extensions, List.class, 770, 30298, 30309).clear();
            }
            if (CallChecker.beforeDeref(m_names, Set.class, 771, 30328, 30334)) {
                CallChecker.isCalled(m_names, Set.class, 771, 30328, 30334).clear();
            }
            for (Iterator iter = CallChecker.isCalled(CallChecker.isCalled(m_sourceToExtensions, Map.class, 773, 30375, 30394).values(), Collection.class, 773, 30375, 30403).iterator(); CallChecker.isCalled(iter, Iterator.class, 773, 30417, 30420).hasNext();) {
                List extensions = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(iter, Iterator.class, 775, 30481, 30484)) {
                    extensions = ((List) (CallChecker.isCalled(iter, Iterator.class, 775, 30481, 30484).next()));
                    CallChecker.varAssign(extensions, "extensions", 775, 30481, 30484);
                }
                extensions = CallChecker.beforeCalled(extensions, List.class, 776, 30530, 30539);
                for (Iterator extIter = CallChecker.isCalled(extensions, List.class, 776, 30530, 30539).iterator(); CallChecker.isCalled(extIter, Iterator.class, 776, 30553, 30559).hasNext();) {
                    Bundle bundle = CallChecker.init(Bundle.class);
                    if (CallChecker.beforeDeref(extIter, Iterator.class, 778, 30628, 30634)) {
                        bundle = ((Bundle) (CallChecker.isCalled(extIter, Iterator.class, 778, 30628, 30634).next()));
                        CallChecker.varAssign(bundle, "bundle", 778, 30628, 30634);
                    }
                    if (CallChecker.beforeDeref(bundle, Bundle.class, 779, 30665, 30670)) {
                        bundle = CallChecker.beforeCalled(bundle, Bundle.class, 779, 30665, 30670);
                        _add(CallChecker.isCalled(bundle, Bundle.class, 779, 30665, 30670).getSymbolicName(), bundle);
                    }
                }
                if (CallChecker.beforeDeref(m_extensions, List.class, 782, 30805, 30816)) {
                    if (CallChecker.beforeDeref(m_extensions, List.class, 782, 30773, 30784)) {
                        m_extensionsCache = ((Bundle[]) (CallChecker.isCalled(m_extensions, List.class, 782, 30773, 30784).toArray(new Bundle[CallChecker.isCalled(m_extensions, List.class, 782, 30805, 30816).size()])));
                        CallChecker.varAssign(this.m_extensionsCache, "this.m_extensionsCache", 781, 30726, 30826);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1195.methodEnd();
        }
    }

    private void _add(String name, Bundle extension) {
        MethodContext _bcornu_methode_context1196 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 786, 30849, 31037);
            CallChecker.varInit(extension, "extension", 786, 30849, 31037);
            CallChecker.varInit(name, "name", 786, 30849, 31037);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 786, 30849, 31037);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 786, 30849, 31037);
            CallChecker.varInit(this.m_names, "m_names", 786, 30849, 31037);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 786, 30849, 31037);
            CallChecker.varInit(this.m_extensions, "m_extensions", 786, 30849, 31037);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 786, 30849, 31037);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 786, 30849, 31037);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 786, 30849, 31037);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 786, 30849, 31037);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 786, 30849, 31037);
            CallChecker.varInit(this.m_configMap, "m_configMap", 786, 30849, 31037);
            CallChecker.varInit(this.m_logger, "m_logger", 786, 30849, 31037);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 786, 30849, 31037);
            if (CallChecker.beforeDeref(m_names, Set.class, 788, 30917, 30923)) {
                if (!(CallChecker.isCalled(m_names, Set.class, 788, 30917, 30923).contains(name))) {
                    if (CallChecker.beforeDeref(m_names, Set.class, 790, 30963, 30969)) {
                        CallChecker.isCalled(m_names, Set.class, 790, 30963, 30969).add(name);
                    }
                    if (CallChecker.beforeDeref(m_extensions, List.class, 791, 30994, 31005)) {
                        CallChecker.isCalled(m_extensions, List.class, 791, 30994, 31005).add(extension);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1196.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context1197 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 795, 31044, 31134);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 795, 31044, 31134);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 795, 31044, 31134);
            CallChecker.varInit(this.m_names, "m_names", 795, 31044, 31134);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 795, 31044, 31134);
            CallChecker.varInit(this.m_extensions, "m_extensions", 795, 31044, 31134);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 795, 31044, 31134);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 795, 31044, 31134);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 795, 31044, 31134);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 795, 31044, 31134);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 795, 31044, 31134);
            CallChecker.varInit(this.m_configMap, "m_configMap", 795, 31044, 31134);
            CallChecker.varInit(this.m_logger, "m_logger", 795, 31044, 31134);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 795, 31044, 31134);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1197.methodEnd();
        }
    }

    public Enumeration getEntries() {
        MethodContext _bcornu_methode_context1200 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 800, 31141, 31491);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 800, 31141, 31491);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 800, 31141, 31491);
            CallChecker.varInit(this.m_names, "m_names", 800, 31141, 31491);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 800, 31141, 31491);
            CallChecker.varInit(this.m_extensions, "m_extensions", 800, 31141, 31491);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 800, 31141, 31491);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 800, 31141, 31491);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 800, 31141, 31491);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 800, 31141, 31491);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 800, 31141, 31491);
            CallChecker.varInit(this.m_configMap, "m_configMap", 800, 31141, 31491);
            CallChecker.varInit(this.m_logger, "m_logger", 800, 31141, 31491);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 800, 31141, 31491);
            return new Enumeration() {
                public boolean hasMoreElements() {
                    MethodContext _bcornu_methode_context1198 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 804, 31234, 31323);
                        return false;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1198.methodEnd();
                    }
                }

                public Object nextElement() throws NoSuchElementException {
                    MethodContext _bcornu_methode_context1199 = new MethodContext(Object.class);
                    try {
                        CallChecker.varInit(this, "this", 809, 31338, 31474);
                        throw new NoSuchElementException();
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Object) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1199.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1200.methodEnd();
        }
    }

    public boolean hasEntry(String name) {
        MethodContext _bcornu_methode_context1201 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 816, 31498, 31563);
            CallChecker.varInit(name, "name", 816, 31498, 31563);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 816, 31498, 31563);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 816, 31498, 31563);
            CallChecker.varInit(this.m_names, "m_names", 816, 31498, 31563);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 816, 31498, 31563);
            CallChecker.varInit(this.m_extensions, "m_extensions", 816, 31498, 31563);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 816, 31498, 31563);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 816, 31498, 31563);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 816, 31498, 31563);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 816, 31498, 31563);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 816, 31498, 31563);
            CallChecker.varInit(this.m_configMap, "m_configMap", 816, 31498, 31563);
            CallChecker.varInit(this.m_logger, "m_logger", 816, 31498, 31563);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 816, 31498, 31563);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1201.methodEnd();
        }
    }

    public byte[] getEntryAsBytes(String name) {
        MethodContext _bcornu_methode_context1202 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 820, 31570, 31644);
            CallChecker.varInit(name, "name", 820, 31570, 31644);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 820, 31570, 31644);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 820, 31570, 31644);
            CallChecker.varInit(this.m_names, "m_names", 820, 31570, 31644);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 820, 31570, 31644);
            CallChecker.varInit(this.m_extensions, "m_extensions", 820, 31570, 31644);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 820, 31570, 31644);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 820, 31570, 31644);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 820, 31570, 31644);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 820, 31570, 31644);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 820, 31570, 31644);
            CallChecker.varInit(this.m_configMap, "m_configMap", 820, 31570, 31644);
            CallChecker.varInit(this.m_logger, "m_logger", 820, 31570, 31644);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 820, 31570, 31644);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1202.methodEnd();
        }
    }

    public InputStream getEntryAsStream(String name) throws IOException {
        MethodContext _bcornu_methode_context1203 = new MethodContext(InputStream.class);
        try {
            CallChecker.varInit(this, "this", 825, 31651, 31750);
            CallChecker.varInit(name, "name", 825, 31651, 31750);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 825, 31651, 31750);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 825, 31651, 31750);
            CallChecker.varInit(this.m_names, "m_names", 825, 31651, 31750);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 825, 31651, 31750);
            CallChecker.varInit(this.m_extensions, "m_extensions", 825, 31651, 31750);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 825, 31651, 31750);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 825, 31651, 31750);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 825, 31651, 31750);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 825, 31651, 31750);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 825, 31651, 31750);
            CallChecker.varInit(this.m_configMap, "m_configMap", 825, 31651, 31750);
            CallChecker.varInit(this.m_logger, "m_logger", 825, 31651, 31750);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 825, 31651, 31750);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1203.methodEnd();
        }
    }

    public Content getEntryAsContent(String name) {
        MethodContext _bcornu_methode_context1204 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 830, 31757, 31834);
            CallChecker.varInit(name, "name", 830, 31757, 31834);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 830, 31757, 31834);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 830, 31757, 31834);
            CallChecker.varInit(this.m_names, "m_names", 830, 31757, 31834);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 830, 31757, 31834);
            CallChecker.varInit(this.m_extensions, "m_extensions", 830, 31757, 31834);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 830, 31757, 31834);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 830, 31757, 31834);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 830, 31757, 31834);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 830, 31757, 31834);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 830, 31757, 31834);
            CallChecker.varInit(this.m_configMap, "m_configMap", 830, 31757, 31834);
            CallChecker.varInit(this.m_logger, "m_logger", 830, 31757, 31834);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 830, 31757, 31834);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1204.methodEnd();
        }
    }

    public String getEntryAsNativeLibrary(String name) {
        MethodContext _bcornu_methode_context1205 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 835, 31841, 31923);
            CallChecker.varInit(name, "name", 835, 31841, 31923);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 835, 31841, 31923);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 835, 31841, 31923);
            CallChecker.varInit(this.m_names, "m_names", 835, 31841, 31923);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 835, 31841, 31923);
            CallChecker.varInit(this.m_extensions, "m_extensions", 835, 31841, 31923);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 835, 31841, 31923);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 835, 31841, 31923);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 835, 31841, 31923);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 835, 31841, 31923);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 835, 31841, 31923);
            CallChecker.varInit(this.m_configMap, "m_configMap", 835, 31841, 31923);
            CallChecker.varInit(this.m_logger, "m_logger", 835, 31841, 31923);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 835, 31841, 31923);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1205.methodEnd();
        }
    }

    public URL getEntryAsURL(String name) {
        MethodContext _bcornu_methode_context1206 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 840, 31930, 31999);
            CallChecker.varInit(name, "name", 840, 31930, 31999);
            CallChecker.varInit(this.m_extensionTuples, "m_extensionTuples", 840, 31930, 31999);
            CallChecker.varInit(this.m_sourceToExtensions, "m_sourceToExtensions", 840, 31930, 31999);
            CallChecker.varInit(this.m_names, "m_names", 840, 31930, 31999);
            CallChecker.varInit(this.m_extensionsCache, "m_extensionsCache", 840, 31930, 31999);
            CallChecker.varInit(this.m_extensions, "m_extensions", 840, 31930, 31999);
            CallChecker.varInit(this.m_securityContext, "m_securityContext", 840, 31930, 31999);
            CallChecker.varInit(this.m_exportNames, "m_exportNames", 840, 31930, 31999);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 840, 31930, 31999);
            CallChecker.varInit(this.m_systemBundleRevision, "m_systemBundleRevision", 840, 31930, 31999);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 840, 31930, 31999);
            CallChecker.varInit(this.m_configMap, "m_configMap", 840, 31930, 31999);
            CallChecker.varInit(this.m_logger, "m_logger", 840, 31930, 31999);
            CallChecker.varInit(m_extensionManager, "org.apache.felix.framework.ExtensionManager.m_extensionManager", 840, 31930, 31999);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1206.methodEnd();
        }
    }

    class ExtensionManagerRevision extends BundleRevisionImpl {
        private final Version m_version;

        private volatile BundleWiring m_wiring;

        ExtensionManagerRevision(Felix felix) {
            super(felix, "0");
            MethodContext _bcornu_methode_context126 = new MethodContext(null);
            try {
                m_version = new Version(((String) (CallChecker.isCalled(m_configMap, Map.class, 858, 32347, 32357).get(FelixConstants.FELIX_VERSION_PROPERTY))));
                CallChecker.varAssign(this.m_version, "this.m_version", 857, 32298, 32402);
            } finally {
                _bcornu_methode_context126.methodEnd();
            }
        }

        @Override
        public Map getHeaders() {
            MethodContext _bcornu_methode_context1207 = new MethodContext(Map.class);
            try {
                CallChecker.varInit(this, "this", 862, 32423, 32596);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 862, 32423, 32596);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 862, 32423, 32596);
                CallChecker.varInit(this.m_wiring, "m_wiring", 862, 32423, 32596);
                CallChecker.varInit(this.m_version, "m_version", 862, 32423, 32596);
                synchronized(ExtensionManager.this) {
                    return ExtensionManager.this.m_headerMap;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1207.methodEnd();
            }
        }

        @Override
        public List<BundleCapability> getDeclaredCapabilities(String namespace) {
            MethodContext _bcornu_methode_context1208 = new MethodContext(List.class);
            try {
                CallChecker.varInit(this, "this", 871, 32607, 32784);
                CallChecker.varInit(namespace, "namespace", 871, 32607, 32784);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 871, 32607, 32784);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 871, 32607, 32784);
                CallChecker.varInit(this.m_wiring, "m_wiring", 871, 32607, 32784);
                CallChecker.varInit(this.m_version, "m_version", 871, 32607, 32784);
                return ExtensionManager.this.getCapabilities(namespace);
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1208.methodEnd();
            }
        }

        @Override
        public String getSymbolicName() {
            MethodContext _bcornu_methode_context1209 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 877, 32795, 32925);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 877, 32795, 32925);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 877, 32795, 32925);
                CallChecker.varInit(this.m_wiring, "m_wiring", 877, 32795, 32925);
                CallChecker.varInit(this.m_version, "m_version", 877, 32795, 32925);
                return FelixConstants.SYSTEM_BUNDLE_SYMBOLICNAME;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1209.methodEnd();
            }
        }

        @Override
        public Version getVersion() {
            MethodContext _bcornu_methode_context1210 = new MethodContext(Version.class);
            try {
                CallChecker.varInit(this, "this", 883, 32936, 33030);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 883, 32936, 33030);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 883, 32936, 33030);
                CallChecker.varInit(this.m_wiring, "m_wiring", 883, 32936, 33030);
                CallChecker.varInit(this.m_version, "m_version", 883, 32936, 33030);
                return m_version;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Version) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1210.methodEnd();
            }
        }

        @Override
        public void close() {
            MethodContext _bcornu_methode_context1211 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 889, 33041, 33133);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 889, 33041, 33133);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 889, 33041, 33133);
                CallChecker.varInit(this.m_wiring, "m_wiring", 889, 33041, 33133);
                CallChecker.varInit(this.m_version, "m_version", 889, 33041, 33133);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1211.methodEnd();
            }
        }

        @Override
        public Content getContent() {
            MethodContext _bcornu_methode_context1212 = new MethodContext(Content.class);
            try {
                CallChecker.varInit(this, "this", 895, 33144, 33250);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 895, 33144, 33250);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 895, 33144, 33250);
                CallChecker.varInit(this.m_wiring, "m_wiring", 895, 33144, 33250);
                CallChecker.varInit(this.m_version, "m_version", 895, 33144, 33250);
                return ExtensionManager.this;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Content) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1212.methodEnd();
            }
        }

        @Override
        public URL getEntry(String name) {
            MethodContext _bcornu_methode_context1213 = new MethodContext(URL.class);
            try {
                CallChecker.varInit(this, "this", 901, 33261, 33429);
                CallChecker.varInit(name, "name", 901, 33261, 33429);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 901, 33261, 33429);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 901, 33261, 33429);
                CallChecker.varInit(this.m_wiring, "m_wiring", 901, 33261, 33429);
                CallChecker.varInit(this.m_version, "m_version", 901, 33261, 33429);
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((URL) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1213.methodEnd();
            }
        }

        @Override
        public boolean hasInputStream(int index, String urlPath) {
            MethodContext _bcornu_methode_context1214 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 908, 33440, 33612);
                CallChecker.varInit(urlPath, "urlPath", 908, 33440, 33612);
                CallChecker.varInit(index, "index", 908, 33440, 33612);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 908, 33440, 33612);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 908, 33440, 33612);
                CallChecker.varInit(this.m_wiring, "m_wiring", 908, 33440, 33612);
                CallChecker.varInit(this.m_version, "m_version", 908, 33440, 33612);
                if (CallChecker.beforeDeref(getClass(), Class.class, 910, 33545, 33554)) {
                    return (CallChecker.isCalled(CallChecker.isCalled(getClass(), Class.class, 910, 33545, 33554).getClassLoader(), ClassLoader.class, 910, 33545, 33571).getResource(urlPath)) != null;
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1214.methodEnd();
            }
        }

        @Override
        public InputStream getInputStream(int index, String urlPath) {
            MethodContext _bcornu_methode_context1215 = new MethodContext(InputStream.class);
            try {
                CallChecker.varInit(this, "this", 914, 33623, 33797);
                CallChecker.varInit(urlPath, "urlPath", 914, 33623, 33797);
                CallChecker.varInit(index, "index", 914, 33623, 33797);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 914, 33623, 33797);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 914, 33623, 33797);
                CallChecker.varInit(this.m_wiring, "m_wiring", 914, 33623, 33797);
                CallChecker.varInit(this.m_version, "m_version", 914, 33623, 33797);
                if (CallChecker.beforeDeref(getClass(), Class.class, 916, 33731, 33740)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(getClass(), Class.class, 916, 33731, 33740).getClassLoader(), ClassLoader.class, 916, 33731, 33757)) {
                        return CallChecker.isCalled(CallChecker.isCalled(getClass(), Class.class, 916, 33731, 33740).getClassLoader(), ClassLoader.class, 916, 33731, 33757).getResourceAsStream(urlPath);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1215.methodEnd();
            }
        }

        @Override
        public URL getLocalURL(int index, String urlPath) {
            MethodContext _bcornu_methode_context1216 = new MethodContext(URL.class);
            try {
                CallChecker.varInit(this, "this", 920, 33808, 33963);
                CallChecker.varInit(urlPath, "urlPath", 920, 33808, 33963);
                CallChecker.varInit(index, "index", 920, 33808, 33963);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 920, 33808, 33963);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 920, 33808, 33963);
                CallChecker.varInit(this.m_wiring, "m_wiring", 920, 33808, 33963);
                CallChecker.varInit(this.m_version, "m_version", 920, 33808, 33963);
                if (CallChecker.beforeDeref(getClass(), Class.class, 922, 33905, 33914)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(getClass(), Class.class, 922, 33905, 33914).getClassLoader(), ClassLoader.class, 922, 33905, 33931)) {
                        return CallChecker.isCalled(CallChecker.isCalled(getClass(), Class.class, 922, 33905, 33914).getClassLoader(), ClassLoader.class, 922, 33905, 33931).getResource(urlPath);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((URL) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1216.methodEnd();
            }
        }

        @Override
        public void resolve(BundleWiringImpl wire) {
            MethodContext _bcornu_methode_context1217 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 926, 33974, 34308);
                CallChecker.varInit(wire, "wire", 926, 33974, 34308);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 926, 33974, 34308);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 926, 33974, 34308);
                CallChecker.varInit(this.m_wiring, "m_wiring", 926, 33974, 34308);
                CallChecker.varInit(this.m_version, "m_version", 926, 33974, 34308);
                TryContext _bcornu_try_context_338 = new TryContext(338, ExtensionManager.class, "java.lang.Exception");
                try {
                    m_wiring = new ExtensionManager.ExtensionManagerWiring(m_logger, m_configMap, this);
                    CallChecker.varAssign(this.m_wiring, "this.m_wiring", 930, 34091, 34178);
                } catch (Exception ex) {
                    _bcornu_try_context_338.catchStart(338);
                } finally {
                    _bcornu_try_context_338.finallyStart(338);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1217.methodEnd();
            }
        }

        @Override
        public BundleWiring getWiring() {
            MethodContext _bcornu_methode_context1218 = new MethodContext(BundleWiring.class);
            try {
                CallChecker.varInit(this, "this", 940, 34319, 34416);
                CallChecker.varInit(BundleRevisionImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 940, 34319, 34416);
                CallChecker.varInit(BundleRevisionImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 940, 34319, 34416);
                CallChecker.varInit(this.m_wiring, "m_wiring", 940, 34319, 34416);
                CallChecker.varInit(this.m_version, "m_version", 940, 34319, 34416);
                return m_wiring;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BundleWiring) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1218.methodEnd();
            }
        }
    }

    class ExtensionManagerWiring extends BundleWiringImpl {
        ExtensionManagerWiring(Logger logger, Map configMap, BundleRevisionImpl revision) throws Exception {
            super(logger, configMap, null, revision, null, Collections.EMPTY_LIST, null, null);
            MethodContext _bcornu_methode_context127 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context127.methodEnd();
            }
        }

        @Override
        public ClassLoader getClassLoader() {
            MethodContext _bcornu_methode_context1219 = new MethodContext(ClassLoader.class);
            try {
                CallChecker.varInit(this, "this", 957, 34762, 34882);
                CallChecker.varInit(BundleWiringImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 957, 34762, 34882);
                CallChecker.varInit(BundleWiringImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 957, 34762, 34882);
                CallChecker.varInit(BundleWiringImpl.LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 957, 34762, 34882);
                if (CallChecker.beforeDeref(getClass(), Class.class, 959, 34845, 34854)) {
                    return CallChecker.isCalled(getClass(), Class.class, 959, 34845, 34854).getClassLoader();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1219.methodEnd();
            }
        }

        @Override
        public List<BundleCapability> getCapabilities(String namespace) {
            MethodContext _bcornu_methode_context1220 = new MethodContext(List.class);
            try {
                CallChecker.varInit(this, "this", 963, 34893, 35062);
                CallChecker.varInit(namespace, "namespace", 963, 34893, 35062);
                CallChecker.varInit(BundleWiringImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 963, 34893, 35062);
                CallChecker.varInit(BundleWiringImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 963, 34893, 35062);
                CallChecker.varInit(BundleWiringImpl.LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 963, 34893, 35062);
                return ExtensionManager.this.getCapabilities(namespace);
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1220.methodEnd();
            }
        }

        @Override
        public List<NativeLibrary> getNativeLibraries() {
            MethodContext _bcornu_methode_context1221 = new MethodContext(List.class);
            try {
                CallChecker.varInit(this, "this", 969, 35073, 35200);
                CallChecker.varInit(BundleWiringImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 969, 35073, 35200);
                CallChecker.varInit(BundleWiringImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 969, 35073, 35200);
                CallChecker.varInit(BundleWiringImpl.LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 969, 35073, 35200);
                return Collections.EMPTY_LIST;
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<NativeLibrary>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1221.methodEnd();
            }
        }

        @Override
        public Class getClassByDelegation(String name) throws ClassNotFoundException {
            MethodContext _bcornu_methode_context1222 = new MethodContext(Class.class);
            try {
                CallChecker.varInit(this, "this", 975, 35211, 36748);
                CallChecker.varInit(name, "name", 975, 35211, 36748);
                CallChecker.varInit(BundleWiringImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 975, 35211, 36748);
                CallChecker.varInit(BundleWiringImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 975, 35211, 36748);
                CallChecker.varInit(BundleWiringImpl.LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 975, 35211, 36748);
                Class clazz = CallChecker.varInit(null, "clazz", 977, 35328, 35346);
                String pkgName = CallChecker.varInit(Util.getClassPackage(name), "pkgName", 978, 35360, 35403);
                if (shouldBootDelegate(pkgName)) {
                    TryContext _bcornu_try_context_339 = new TryContext(339, ExtensionManager.class, "java.lang.ClassNotFoundException");
                    try {
                        ClassLoader bdcl = CallChecker.varInit(getBootDelegationClassLoader(), "bdcl", 984, 35594, 35643);
                        if (CallChecker.beforeDeref(bdcl, ClassLoader.class, 985, 35673, 35676)) {
                            bdcl = CallChecker.beforeCalled(bdcl, ClassLoader.class, 985, 35673, 35676);
                            clazz = CallChecker.isCalled(bdcl, ClassLoader.class, 985, 35673, 35676).loadClass(name);
                            CallChecker.varAssign(clazz, "clazz", 985, 35665, 35693);
                        }
                        if (CallChecker.beforeDeref(pkgName, String.class, 988, 35878, 35884)) {
                            pkgName = CallChecker.beforeCalled(pkgName, String.class, 988, 35878, 35884);
                            if ((CallChecker.isCalled(pkgName, String.class, 988, 35878, 35884).startsWith("java.")) || (clazz != null)) {
                                return clazz;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ClassNotFoundException ex) {
                        _bcornu_try_context_339.catchStart(339);
                        if (CallChecker.beforeDeref(pkgName, String.class, 997, 36277, 36283)) {
                            pkgName = CallChecker.beforeCalled(pkgName, String.class, 997, 36277, 36283);
                            if (CallChecker.isCalled(pkgName, String.class, 997, 36277, 36283).startsWith("java.")) {
                                throw ex;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    } finally {
                        _bcornu_try_context_339.finallyStart(339);
                    }
                }
                if (clazz == null) {
                    if (CallChecker.beforeDeref(m_exportNames, Set.class, 1005, 36482, 36494)) {
                        m_exportNames = CallChecker.beforeCalled(m_exportNames, Set.class, 1005, 36482, 36494);
                        if (!(CallChecker.isCalled(m_exportNames, Set.class, 1005, 36482, 36494).contains(Util.getClassPackage(name)))) {
                            throw new ClassNotFoundException(name);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(getClass(), Class.class, 1010, 36655, 36664)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(getClass(), Class.class, 1010, 36655, 36664).getClassLoader(), ClassLoader.class, 1010, 36655, 36681)) {
                            clazz = CallChecker.isCalled(CallChecker.isCalled(getClass(), Class.class, 1010, 36655, 36664).getClassLoader(), ClassLoader.class, 1010, 36655, 36681).loadClass(name);
                            CallChecker.varAssign(clazz, "clazz", 1010, 36647, 36698);
                        }
                    }
                }
                return clazz;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Class) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1222.methodEnd();
            }
        }

        @Override
        public URL getResourceByDelegation(String name) {
            MethodContext _bcornu_methode_context1223 = new MethodContext(URL.class);
            try {
                CallChecker.varInit(this, "this", 1016, 36759, 36909);
                CallChecker.varInit(name, "name", 1016, 36759, 36909);
                CallChecker.varInit(BundleWiringImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1016, 36759, 36909);
                CallChecker.varInit(BundleWiringImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1016, 36759, 36909);
                CallChecker.varInit(BundleWiringImpl.LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1016, 36759, 36909);
                if (CallChecker.beforeDeref(getClass(), Class.class, 1018, 36854, 36863)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(getClass(), Class.class, 1018, 36854, 36863).getClassLoader(), ClassLoader.class, 1018, 36854, 36880)) {
                        return CallChecker.isCalled(CallChecker.isCalled(getClass(), Class.class, 1018, 36854, 36863).getClassLoader(), ClassLoader.class, 1018, 36854, 36880).getResource(name);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((URL) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1223.methodEnd();
            }
        }

        @Override
        public Enumeration getResourcesByDelegation(String name) {
            MethodContext _bcornu_methode_context1224 = new MethodContext(Enumeration.class);
            try {
                CallChecker.varInit(this, "this", 1022, 36920, 37212);
                CallChecker.varInit(name, "name", 1022, 36920, 37212);
                CallChecker.varInit(BundleWiringImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1022, 36920, 37212);
                CallChecker.varInit(BundleWiringImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1022, 36920, 37212);
                CallChecker.varInit(BundleWiringImpl.LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1022, 36920, 37212);
                TryContext _bcornu_try_context_340 = new TryContext(340, ExtensionManager.class, "java.io.IOException");
                try {
                    if (CallChecker.beforeDeref(getClass(), Class.class, 1026, 37055, 37064)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(getClass(), Class.class, 1026, 37055, 37064).getClassLoader(), ClassLoader.class, 1026, 37055, 37081)) {
                            return CallChecker.isCalled(CallChecker.isCalled(getClass(), Class.class, 1026, 37055, 37064).getClassLoader(), ClassLoader.class, 1026, 37055, 37081).getResources(name);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (IOException ex) {
                    _bcornu_try_context_340.catchStart(340);
                    return null;
                } finally {
                    _bcornu_try_context_340.finallyStart(340);
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1224.methodEnd();
            }
        }

        @Override
        public void dispose() {
            MethodContext _bcornu_methode_context1225 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1035, 37223, 37317);
                CallChecker.varInit(BundleWiringImpl.LAZY_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.LAZY_ACTIVATION", 1035, 37223, 37317);
                CallChecker.varInit(BundleWiringImpl.EAGER_ACTIVATION, "org.apache.felix.framework.BundleWiringImpl.EAGER_ACTIVATION", 1035, 37223, 37317);
                CallChecker.varInit(BundleWiringImpl.LISTRESOURCES_DEBUG, "org.apache.felix.framework.BundleWiringImpl.LISTRESOURCES_DEBUG", 1035, 37223, 37317);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1225.methodEnd();
            }
        }
    }
}

