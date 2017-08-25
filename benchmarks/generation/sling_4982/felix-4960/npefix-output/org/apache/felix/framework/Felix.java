package org.apache.felix.framework;

import java.util.WeakHashMap;
import org.apache.felix.framework.util.Util;
import java.net.URLStreamHandler;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.TreeSet;
import java.util.TreeMap;
import org.apache.felix.framework.util.ThreadGate;
import java.util.StringTokenizer;
import org.apache.felix.framework.util.StringMap;
import java.util.SortedSet;
import org.apache.felix.framework.capabilityset.SimpleFilter;
import java.util.HashMap;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.launch.Framework;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.hooks.bundle.FindHook;
import org.osgi.framework.Filter;
import java.io.FileNotFoundException;
import java.io.File;
import org.apache.felix.framework.util.FelixConstants;
import org.osgi.service.packageadmin.ExportedPackage;
import org.apache.felix.framework.util.EventDispatcher;
import java.util.Enumeration;
import java.util.Dictionary;
import org.osgi.framework.Constants;
import java.util.Collections;
import java.util.Collection;
import java.security.cert.Certificate;
import org.osgi.framework.wiring.BundleCapability;
import org.apache.felix.framework.cache.BundleCache;
import org.apache.felix.framework.cache.BundleArchive;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.Bundle;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import org.osgi.framework.AdminPermission;
import java.security.AccessControlException;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.BundleReference;
import org.apache.felix.framework.wiring.BundleRequirementImpl;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRevisions;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleWiring;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.felix.framework.capabilityset.CapabilitySet;
import java.util.HashSet;
import org.osgi.framework.namespace.HostNamespace;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.osgi.framework.InvalidSyntaxException;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.hooks.service.ListenerHook;
import org.apache.felix.framework.util.ListenerInfo;
import java.net.MalformedURLException;
import java.util.Map;
import org.apache.felix.framework.util.MapToDictionary;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.felix.framework.util.manifestparser.NativeLibraryClause;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.osgi.framework.PackagePermission;
import java.security.Permission;
import java.util.Properties;
import org.osgi.resource.Requirement;
import org.osgi.service.resolver.ResolutionException;
import org.apache.felix.framework.util.SecureAction;
import org.apache.felix.framework.ext.SecurityProvider;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceException;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServicePermission;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import java.util.Set;
import org.apache.felix.framework.util.ShrinkableCollection;

public class Felix extends BundleImpl implements Framework {
    static final SecureAction m_secureAction = new SecureAction();

    private final ExtensionManager m_extensionManager;

    private final FrameworkWiringImpl m_fwkWiring;

    private final FrameworkStartLevelImpl m_fwkStartLevel;

    private final Logger m_logger;

    private final Map m_configMap;

    private final Map m_configMutableMap;

    private final StatefulResolver m_resolver;

    private final Object[] m_bundleLock = new Object[0];

    private final List m_globalLockWaitersList = new ArrayList();

    private Thread m_globalLockThread = null;

    private int m_globalLockCount = 0;

    private final Map m_installRequestMap = new HashMap();

    private final Object[] m_installRequestLock_Priority1 = new Object[0];

    private volatile Map[] m_installedBundles;

    private static final int LOCATION_MAP_IDX = 0;

    private static final int IDENTIFIER_MAP_IDX = 1;

    private volatile List<BundleImpl> m_uninstalledBundles;

    private final BundleRevisionDependencies m_dependencies = new BundleRevisionDependencies();

    private volatile int m_activeStartLevel = FelixConstants.FRAMEWORK_INACTIVE_STARTLEVEL;

    private volatile int m_targetStartLevel = FelixConstants.FRAMEWORK_INACTIVE_STARTLEVEL;

    private final SortedSet<Felix.StartLevelTuple> m_startLevelBundles = new TreeSet<Felix.StartLevelTuple>();

    private BundleCache m_cache = null;

    List m_activatorList = null;

    private long m_nextId = 1L;

    private final Object m_nextIdLock = new Object[0];

    private final ServiceRegistry m_registry;

    private final EventDispatcher m_dispatcher;

    private final URLStreamHandler m_bundleStreamHandler;

    private final String[] m_bootPkgs;

    private final boolean[] m_bootPkgWildcards;

    private volatile ThreadGate m_shutdownGate = null;

    private SecurityManager m_securityManager = null;

    private volatile boolean m_securityDefaultPolicy;

    public Felix(Map configMap) {
        super();
        MethodContext _bcornu_methode_context47 = new MethodContext(null);
        try {
            m_configMutableMap = new StringMap();
            CallChecker.varAssign(this.m_configMutableMap, "this.m_configMutableMap", 348, 16727, 16763);
            if (configMap != null) {
                for (Iterator i = CallChecker.isCalled(configMap.entrySet(), Set.class, 351, 16836, 16855).iterator(); CallChecker.isCalled(i, Iterator.class, 351, 16869, 16869).hasNext();) {
                    Map.Entry entry = CallChecker.init(Map.Entry.class);
                    if (CallChecker.beforeDeref(i, Iterator.class, 353, 16944, 16944)) {
                        entry = ((Map.Entry) (CallChecker.isCalled(i, Iterator.class, 353, 16944, 16944).next()));
                        CallChecker.varAssign(entry, "entry", 353, 16944, 16944);
                    }
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 354, 16993, 16997)) {
                        entry = CallChecker.beforeCalled(entry, Map.Entry.class, 354, 16993, 16997);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 354, 16993, 16997).getKey(), Object.class, 354, 16993, 17006)) {
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 354, 17020, 17024)) {
                                if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 354, 16970, 16987)) {
                                    entry = CallChecker.beforeCalled(entry, Map.Entry.class, 354, 16993, 16997);
                                    entry = CallChecker.beforeCalled(entry, Map.Entry.class, 354, 17020, 17024);
                                    CallChecker.isCalled(m_configMutableMap, Map.class, 354, 16970, 16987).put(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 354, 16993, 16997).getKey(), Object.class, 354, 16993, 17006).toString(), CallChecker.isCalled(entry, Map.Entry.class, 354, 17020, 17024).getValue());
                                }
                            }
                        }
                    }
                }
            }
            m_configMap = createUnmodifiableMap(m_configMutableMap);
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 357, 17071, 17126);
            if ((CallChecker.isCalled(m_configMutableMap, Map.class, 365, 17510, 17527).get(FelixConstants.LOG_LOGGER_PROP)) != null) {
                m_logger = ((Logger) (CallChecker.isCalled(m_configMutableMap, Map.class, 367, 17616, 17633).get(FelixConstants.LOG_LOGGER_PROP)));
                CallChecker.varAssign(this.m_logger, "this.m_logger", 367, 17596, 17670);
            }else {
                m_logger = new Logger();
                CallChecker.varAssign(this.m_logger, "this.m_logger", 371, 17717, 17740);
            }
            TryContext _bcornu_try_context_142 = new TryContext(142, Felix.class, "java.lang.NumberFormatException");
            try {
                if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 377, 17871, 17888)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 375, 17786, 17793)) {
                        CallChecker.isCalled(m_logger, Logger.class, 375, 17786, 17793).setLogLevel(Integer.parseInt(((String) (CallChecker.isCalled(m_configMutableMap, Map.class, 377, 17871, 17888).get(FelixConstants.LOG_LEVEL_PROP)))));
                    }
                }
            } catch (NumberFormatException ex) {
                _bcornu_try_context_142.catchStart(142);
            } finally {
                _bcornu_try_context_142.finallyStart(142);
            }
            initializeFrameworkProperties();
            String s = CallChecker.init(String.class);
            if ((m_configMap) == null) {
                s = null;
                CallChecker.varAssign(s, "s", 388, 18226, 18340);
            }else {
                s = ((String) (m_configMap.get(Constants.FRAMEWORK_BOOTDELEGATION)));
                CallChecker.varAssign(s, "s", 388, 18226, 18340);
            }
            if (s == null) {
                s = "java.*";
                CallChecker.varAssign(s, "s", 391, 18351, 18393);
            }else {
                s = s + ",java.*";
                CallChecker.varAssign(s, "s", 391, 18351, 18393);
            }
            StringTokenizer st = CallChecker.varInit(new StringTokenizer(s, " ,"), "st", 392, 18403, 18452);
            st = CallChecker.beforeCalled(st, StringTokenizer.class, 393, 18486, 18487);
            m_bootPkgs = new String[CallChecker.isCalled(st, StringTokenizer.class, 393, 18486, 18487).countTokens()];
            CallChecker.varAssign(this.m_bootPkgs, "this.m_bootPkgs", 393, 18462, 18503);
            m_bootPkgWildcards = new boolean[CallChecker.isCalled(m_bootPkgs, String[].class, 394, 18546, 18555).length];
            CallChecker.varAssign(this.m_bootPkgWildcards, "this.m_bootPkgWildcards", 394, 18513, 18564);
            for (int i = 0; i < (CallChecker.isCalled(m_bootPkgs, String[].class, 395, 18594, 18603).length); i++) {
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 397, 18644, 18645)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 397, 18644, 18645);
                    s = CallChecker.isCalled(st, StringTokenizer.class, 397, 18644, 18645).nextToken();
                    CallChecker.varAssign(s, "s", 397, 18640, 18658);
                }
                if (CallChecker.beforeDeref(s, String.class, 398, 18676, 18676)) {
                    if (CallChecker.beforeDeref(s, String.class, 398, 18693, 18693)) {
                        s = CallChecker.beforeCalled(s, String.class, 398, 18676, 18676);
                        s = CallChecker.beforeCalled(s, String.class, 398, 18693, 18693);
                        if ((CallChecker.isCalled(s, String.class, 398, 18676, 18676).equals("*")) || (CallChecker.isCalled(s, String.class, 398, 18693, 18693).endsWith(".*"))) {
                            if (CallChecker.beforeDeref(m_bootPkgWildcards, boolean[].class, 400, 18741, 18758)) {
                                CallChecker.isCalled(m_bootPkgWildcards, boolean[].class, 400, 18741, 18758)[i] = true;
                                CallChecker.varAssign(CallChecker.isCalled(this.m_bootPkgWildcards, boolean[].class, 400, 18741, 18758)[i], "CallChecker.isCalled(this.m_bootPkgWildcards, boolean[].class, 400, 18741, 18758)[i]", 400, 18741, 18769);
                            }
                            if (CallChecker.beforeDeref(s, String.class, 401, 18806, 18806)) {
                                if (CallChecker.beforeDeref(s, String.class, 401, 18791, 18791)) {
                                    s = CallChecker.beforeCalled(s, String.class, 401, 18806, 18806);
                                    s = CallChecker.beforeCalled(s, String.class, 401, 18791, 18791);
                                    s = CallChecker.isCalled(s, String.class, 401, 18791, 18791).substring(0, ((CallChecker.isCalled(s, String.class, 401, 18806, 18806).length()) - 1));
                                    CallChecker.varAssign(s, "s", 401, 18787, 18821);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(m_bootPkgs, String[].class, 403, 18849, 18858)) {
                    CallChecker.isCalled(m_bootPkgs, String[].class, 403, 18849, 18858)[i] = s;
                    CallChecker.varAssign(CallChecker.isCalled(this.m_bootPkgs, String[].class, 403, 18849, 18858)[i], "CallChecker.isCalled(this.m_bootPkgs, String[].class, 403, 18849, 18858)[i]", 403, 18849, 18866);
                }
            }
            NativeLibraryClause.initializeNativeAliases(m_configMap);
            if (CallChecker.beforeDeref("true", String.class, 410, 19077, 19082)) {
                m_securityDefaultPolicy = CallChecker.isCalled("true", String.class, 410, 19077, 19082).equals(getProperty(FelixConstants.SECURITY_DEFAULT_POLICY));
                CallChecker.varAssign(this.m_securityDefaultPolicy, "this.m_securityDefaultPolicy", 410, 19051, 19143);
            }
            m_bundleStreamHandler = new URLHandlersBundleStreamHandler(this);
            CallChecker.varAssign(this.m_bundleStreamHandler, "this.m_bundleStreamHandler", 413, 19203, 19267);
            m_registry = new ServiceRegistry(m_logger, new ServiceRegistry.ServiceRegistryCallbacks() {
                public void serviceChanged(ServiceEvent event, Dictionary oldProps) {
                    MethodContext _bcornu_methode_context575 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 417, 19402, 19547);
                        CallChecker.varInit(oldProps, "oldProps", 417, 19402, 19547);
                        CallChecker.varInit(event, "event", 417, 19402, 19547);
                        fireServiceEvent(event, oldProps);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context575.methodEnd();
                    }
                }
            });
            CallChecker.varAssign(this.m_registry, "this.m_registry", 416, 19314, 19559);
            m_resolver = new StatefulResolver(this, m_registry);
            CallChecker.varAssign(this.m_resolver, "this.m_resolver", 424, 19614, 19665);
            m_extensionManager = new ExtensionManager(m_logger, m_configMap, this);
            CallChecker.varAssign(this.m_extensionManager, "this.m_extensionManager", 428, 19785, 19855);
            TryContext _bcornu_try_context_143 = new TryContext(143, Felix.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 431, 19903, 19920)) {
                    addRevision(CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 431, 19903, 19920).getRevision());
                }
            } catch (Exception ex) {
                _bcornu_try_context_143.catchStart(143);
                throw new RuntimeException(ex.getMessage());
            } finally {
                _bcornu_try_context_143.finallyStart(143);
            }
            m_dispatcher = new EventDispatcher(m_logger, m_registry);
            CallChecker.varAssign(this.m_dispatcher, "this.m_dispatcher", 441, 20216, 20272);
            m_fwkWiring = new FrameworkWiringImpl(this, m_registry);
            CallChecker.varAssign(this.m_fwkWiring, "this.m_fwkWiring", 444, 20326, 20381);
            m_fwkStartLevel = new FrameworkStartLevelImpl(this, m_registry);
            CallChecker.varAssign(this.m_fwkStartLevel, "this.m_fwkStartLevel", 446, 20439, 20502);
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    Logger getLogger() {
        MethodContext _bcornu_methode_context576 = new MethodContext(Logger.class);
        try {
            CallChecker.varInit(this, "this", 449, 20515, 20569);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 449, 20515, 20569);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 449, 20515, 20569);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 449, 20515, 20569);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 449, 20515, 20569);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 449, 20515, 20569);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 449, 20515, 20569);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 449, 20515, 20569);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 449, 20515, 20569);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 449, 20515, 20569);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 449, 20515, 20569);
            CallChecker.varInit(this.m_registry, "m_registry", 449, 20515, 20569);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 449, 20515, 20569);
            CallChecker.varInit(this.m_nextId, "m_nextId", 449, 20515, 20569);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 449, 20515, 20569);
            CallChecker.varInit(this.m_cache, "m_cache", 449, 20515, 20569);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 449, 20515, 20569);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 449, 20515, 20569);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 449, 20515, 20569);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 449, 20515, 20569);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 449, 20515, 20569);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 449, 20515, 20569);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 449, 20515, 20569);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 449, 20515, 20569);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 449, 20515, 20569);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 449, 20515, 20569);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 449, 20515, 20569);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 449, 20515, 20569);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 449, 20515, 20569);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 449, 20515, 20569);
            CallChecker.varInit(this.m_resolver, "m_resolver", 449, 20515, 20569);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 449, 20515, 20569);
            CallChecker.varInit(this.m_configMap, "m_configMap", 449, 20515, 20569);
            CallChecker.varInit(this.m_logger, "m_logger", 449, 20515, 20569);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 449, 20515, 20569);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 449, 20515, 20569);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 449, 20515, 20569);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 449, 20515, 20569);
            return m_logger;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Logger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context576.methodEnd();
        }
    }

    Map getConfig() {
        MethodContext _bcornu_methode_context577 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 454, 20576, 20630);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 454, 20576, 20630);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 454, 20576, 20630);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 454, 20576, 20630);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 454, 20576, 20630);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 454, 20576, 20630);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 454, 20576, 20630);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 454, 20576, 20630);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 454, 20576, 20630);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 454, 20576, 20630);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 454, 20576, 20630);
            CallChecker.varInit(this.m_registry, "m_registry", 454, 20576, 20630);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 454, 20576, 20630);
            CallChecker.varInit(this.m_nextId, "m_nextId", 454, 20576, 20630);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 454, 20576, 20630);
            CallChecker.varInit(this.m_cache, "m_cache", 454, 20576, 20630);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 454, 20576, 20630);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 454, 20576, 20630);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 454, 20576, 20630);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 454, 20576, 20630);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 454, 20576, 20630);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 454, 20576, 20630);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 454, 20576, 20630);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 454, 20576, 20630);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 454, 20576, 20630);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 454, 20576, 20630);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 454, 20576, 20630);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 454, 20576, 20630);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 454, 20576, 20630);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 454, 20576, 20630);
            CallChecker.varInit(this.m_resolver, "m_resolver", 454, 20576, 20630);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 454, 20576, 20630);
            CallChecker.varInit(this.m_configMap, "m_configMap", 454, 20576, 20630);
            CallChecker.varInit(this.m_logger, "m_logger", 454, 20576, 20630);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 454, 20576, 20630);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 454, 20576, 20630);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 454, 20576, 20630);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 454, 20576, 20630);
            return m_configMap;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context577.methodEnd();
        }
    }

    StatefulResolver getResolver() {
        MethodContext _bcornu_methode_context578 = new MethodContext(StatefulResolver.class);
        try {
            CallChecker.varInit(this, "this", 459, 20637, 20705);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 459, 20637, 20705);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 459, 20637, 20705);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 459, 20637, 20705);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 459, 20637, 20705);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 459, 20637, 20705);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 459, 20637, 20705);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 459, 20637, 20705);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 459, 20637, 20705);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 459, 20637, 20705);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 459, 20637, 20705);
            CallChecker.varInit(this.m_registry, "m_registry", 459, 20637, 20705);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 459, 20637, 20705);
            CallChecker.varInit(this.m_nextId, "m_nextId", 459, 20637, 20705);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 459, 20637, 20705);
            CallChecker.varInit(this.m_cache, "m_cache", 459, 20637, 20705);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 459, 20637, 20705);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 459, 20637, 20705);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 459, 20637, 20705);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 459, 20637, 20705);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 459, 20637, 20705);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 459, 20637, 20705);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 459, 20637, 20705);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 459, 20637, 20705);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 459, 20637, 20705);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 459, 20637, 20705);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 459, 20637, 20705);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 459, 20637, 20705);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 459, 20637, 20705);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 459, 20637, 20705);
            CallChecker.varInit(this.m_resolver, "m_resolver", 459, 20637, 20705);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 459, 20637, 20705);
            CallChecker.varInit(this.m_configMap, "m_configMap", 459, 20637, 20705);
            CallChecker.varInit(this.m_logger, "m_logger", 459, 20637, 20705);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 459, 20637, 20705);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 459, 20637, 20705);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 459, 20637, 20705);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 459, 20637, 20705);
            return m_resolver;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StatefulResolver) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context578.methodEnd();
        }
    }

    BundleRevisionDependencies getDependencies() {
        MethodContext _bcornu_methode_context579 = new MethodContext(BundleRevisionDependencies.class);
        try {
            CallChecker.varInit(this, "this", 464, 20712, 20798);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 464, 20712, 20798);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 464, 20712, 20798);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 464, 20712, 20798);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 464, 20712, 20798);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 464, 20712, 20798);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 464, 20712, 20798);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 464, 20712, 20798);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 464, 20712, 20798);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 464, 20712, 20798);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 464, 20712, 20798);
            CallChecker.varInit(this.m_registry, "m_registry", 464, 20712, 20798);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 464, 20712, 20798);
            CallChecker.varInit(this.m_nextId, "m_nextId", 464, 20712, 20798);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 464, 20712, 20798);
            CallChecker.varInit(this.m_cache, "m_cache", 464, 20712, 20798);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 464, 20712, 20798);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 464, 20712, 20798);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 464, 20712, 20798);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 464, 20712, 20798);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 464, 20712, 20798);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 464, 20712, 20798);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 464, 20712, 20798);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 464, 20712, 20798);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 464, 20712, 20798);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 464, 20712, 20798);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 464, 20712, 20798);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 464, 20712, 20798);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 464, 20712, 20798);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 464, 20712, 20798);
            CallChecker.varInit(this.m_resolver, "m_resolver", 464, 20712, 20798);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 464, 20712, 20798);
            CallChecker.varInit(this.m_configMap, "m_configMap", 464, 20712, 20798);
            CallChecker.varInit(this.m_logger, "m_logger", 464, 20712, 20798);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 464, 20712, 20798);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 464, 20712, 20798);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 464, 20712, 20798);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 464, 20712, 20798);
            return m_dependencies;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevisionDependencies) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context579.methodEnd();
        }
    }

    URLStreamHandler getBundleStreamHandler() {
        MethodContext _bcornu_methode_context580 = new MethodContext(URLStreamHandler.class);
        try {
            CallChecker.varInit(this, "this", 469, 20805, 20895);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 469, 20805, 20895);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 469, 20805, 20895);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 469, 20805, 20895);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 469, 20805, 20895);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 469, 20805, 20895);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 469, 20805, 20895);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 469, 20805, 20895);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 469, 20805, 20895);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 469, 20805, 20895);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 469, 20805, 20895);
            CallChecker.varInit(this.m_registry, "m_registry", 469, 20805, 20895);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 469, 20805, 20895);
            CallChecker.varInit(this.m_nextId, "m_nextId", 469, 20805, 20895);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 469, 20805, 20895);
            CallChecker.varInit(this.m_cache, "m_cache", 469, 20805, 20895);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 469, 20805, 20895);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 469, 20805, 20895);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 469, 20805, 20895);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 469, 20805, 20895);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 469, 20805, 20895);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 469, 20805, 20895);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 469, 20805, 20895);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 469, 20805, 20895);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 469, 20805, 20895);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 469, 20805, 20895);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 469, 20805, 20895);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 469, 20805, 20895);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 469, 20805, 20895);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 469, 20805, 20895);
            CallChecker.varInit(this.m_resolver, "m_resolver", 469, 20805, 20895);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 469, 20805, 20895);
            CallChecker.varInit(this.m_configMap, "m_configMap", 469, 20805, 20895);
            CallChecker.varInit(this.m_logger, "m_logger", 469, 20805, 20895);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 469, 20805, 20895);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 469, 20805, 20895);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 469, 20805, 20895);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 469, 20805, 20895);
            return m_bundleStreamHandler;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLStreamHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context580.methodEnd();
        }
    }

    String[] getBootPackages() {
        MethodContext _bcornu_methode_context581 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 474, 20902, 20966);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 474, 20902, 20966);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 474, 20902, 20966);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 474, 20902, 20966);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 474, 20902, 20966);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 474, 20902, 20966);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 474, 20902, 20966);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 474, 20902, 20966);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 474, 20902, 20966);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 474, 20902, 20966);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 474, 20902, 20966);
            CallChecker.varInit(this.m_registry, "m_registry", 474, 20902, 20966);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 474, 20902, 20966);
            CallChecker.varInit(this.m_nextId, "m_nextId", 474, 20902, 20966);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 474, 20902, 20966);
            CallChecker.varInit(this.m_cache, "m_cache", 474, 20902, 20966);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 474, 20902, 20966);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 474, 20902, 20966);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 474, 20902, 20966);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 474, 20902, 20966);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 474, 20902, 20966);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 474, 20902, 20966);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 474, 20902, 20966);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 474, 20902, 20966);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 474, 20902, 20966);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 474, 20902, 20966);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 474, 20902, 20966);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 474, 20902, 20966);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 474, 20902, 20966);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 474, 20902, 20966);
            CallChecker.varInit(this.m_resolver, "m_resolver", 474, 20902, 20966);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 474, 20902, 20966);
            CallChecker.varInit(this.m_configMap, "m_configMap", 474, 20902, 20966);
            CallChecker.varInit(this.m_logger, "m_logger", 474, 20902, 20966);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 474, 20902, 20966);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 474, 20902, 20966);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 474, 20902, 20966);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 474, 20902, 20966);
            return m_bootPkgs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context581.methodEnd();
        }
    }

    boolean[] getBootPackageWildcards() {
        MethodContext _bcornu_methode_context582 = new MethodContext(boolean[].class);
        try {
            CallChecker.varInit(this, "this", 479, 20973, 21054);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 479, 20973, 21054);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 479, 20973, 21054);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 479, 20973, 21054);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 479, 20973, 21054);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 479, 20973, 21054);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 479, 20973, 21054);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 479, 20973, 21054);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 479, 20973, 21054);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 479, 20973, 21054);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 479, 20973, 21054);
            CallChecker.varInit(this.m_registry, "m_registry", 479, 20973, 21054);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 479, 20973, 21054);
            CallChecker.varInit(this.m_nextId, "m_nextId", 479, 20973, 21054);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 479, 20973, 21054);
            CallChecker.varInit(this.m_cache, "m_cache", 479, 20973, 21054);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 479, 20973, 21054);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 479, 20973, 21054);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 479, 20973, 21054);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 479, 20973, 21054);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 479, 20973, 21054);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 479, 20973, 21054);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 479, 20973, 21054);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 479, 20973, 21054);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 479, 20973, 21054);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 479, 20973, 21054);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 479, 20973, 21054);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 479, 20973, 21054);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 479, 20973, 21054);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 479, 20973, 21054);
            CallChecker.varInit(this.m_resolver, "m_resolver", 479, 20973, 21054);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 479, 20973, 21054);
            CallChecker.varInit(this.m_configMap, "m_configMap", 479, 20973, 21054);
            CallChecker.varInit(this.m_logger, "m_logger", 479, 20973, 21054);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 479, 20973, 21054);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 479, 20973, 21054);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 479, 20973, 21054);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 479, 20973, 21054);
            return m_bootPkgWildcards;
        } catch (ForceReturn _bcornu_return_t) {
            return ((boolean[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context582.methodEnd();
        }
    }

    private Map createUnmodifiableMap(Map mutableMap) {
        MethodContext _bcornu_methode_context583 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 484, 21061, 21618);
            CallChecker.varInit(mutableMap, "mutableMap", 484, 21061, 21618);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 484, 21061, 21618);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 484, 21061, 21618);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 484, 21061, 21618);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 484, 21061, 21618);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 484, 21061, 21618);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 484, 21061, 21618);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 484, 21061, 21618);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 484, 21061, 21618);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 484, 21061, 21618);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 484, 21061, 21618);
            CallChecker.varInit(this.m_registry, "m_registry", 484, 21061, 21618);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 484, 21061, 21618);
            CallChecker.varInit(this.m_nextId, "m_nextId", 484, 21061, 21618);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 484, 21061, 21618);
            CallChecker.varInit(this.m_cache, "m_cache", 484, 21061, 21618);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 484, 21061, 21618);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 484, 21061, 21618);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 484, 21061, 21618);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 484, 21061, 21618);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 484, 21061, 21618);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 484, 21061, 21618);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 484, 21061, 21618);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 484, 21061, 21618);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 484, 21061, 21618);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 484, 21061, 21618);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 484, 21061, 21618);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 484, 21061, 21618);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 484, 21061, 21618);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 484, 21061, 21618);
            CallChecker.varInit(this.m_resolver, "m_resolver", 484, 21061, 21618);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 484, 21061, 21618);
            CallChecker.varInit(this.m_configMap, "m_configMap", 484, 21061, 21618);
            CallChecker.varInit(this.m_logger, "m_logger", 484, 21061, 21618);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 484, 21061, 21618);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 484, 21061, 21618);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 484, 21061, 21618);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 484, 21061, 21618);
            Map result = CallChecker.varInit(Collections.unmodifiableMap(mutableMap), "result", 486, 21125, 21177);
            TryContext _bcornu_try_context_144 = new TryContext(144, Felix.class, "java.lang.NoClassDefFoundError");
            try {
                if (CallChecker.beforeDeref(result, Map.class, 494, 21461, 21466)) {
                    result = CallChecker.beforeCalled(result, Map.class, 494, 21461, 21466);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Map.class, 494, 21461, 21466).keySet(), Set.class, 494, 21461, 21475)) {
                        result = CallChecker.beforeCalled(result, Map.class, 494, 21461, 21466);
                        CallChecker.isCalled(CallChecker.isCalled(result, Map.class, 494, 21461, 21466).keySet(), Set.class, 494, 21461, 21475).iterator();
                    }
                }
            } catch (NoClassDefFoundError ex) {
                _bcornu_try_context_144.catchStart(144);
                return mutableMap;
            } finally {
                _bcornu_try_context_144.finallyStart(144);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context583.methodEnd();
        }
    }

    @Override
    void close() {
        MethodContext _bcornu_methode_context584 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 507, 21625, 21782);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 507, 21625, 21782);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 507, 21625, 21782);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 507, 21625, 21782);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 507, 21625, 21782);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 507, 21625, 21782);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 507, 21625, 21782);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 507, 21625, 21782);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 507, 21625, 21782);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 507, 21625, 21782);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 507, 21625, 21782);
            CallChecker.varInit(this.m_registry, "m_registry", 507, 21625, 21782);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 507, 21625, 21782);
            CallChecker.varInit(this.m_nextId, "m_nextId", 507, 21625, 21782);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 507, 21625, 21782);
            CallChecker.varInit(this.m_cache, "m_cache", 507, 21625, 21782);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 507, 21625, 21782);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 507, 21625, 21782);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 507, 21625, 21782);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 507, 21625, 21782);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 507, 21625, 21782);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 507, 21625, 21782);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 507, 21625, 21782);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 507, 21625, 21782);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 507, 21625, 21782);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 507, 21625, 21782);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 507, 21625, 21782);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 507, 21625, 21782);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 507, 21625, 21782);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 507, 21625, 21782);
            CallChecker.varInit(this.m_resolver, "m_resolver", 507, 21625, 21782);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 507, 21625, 21782);
            CallChecker.varInit(this.m_configMap, "m_configMap", 507, 21625, 21782);
            CallChecker.varInit(this.m_logger, "m_logger", 507, 21625, 21782);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 507, 21625, 21782);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 507, 21625, 21782);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 507, 21625, 21782);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 507, 21625, 21782);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context584.methodEnd();
        }
    }

    @Override
    Felix getFramework() {
        MethodContext _bcornu_methode_context585 = new MethodContext(Felix.class);
        try {
            CallChecker.varInit(this, "this", 514, 21789, 21994);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 514, 21789, 21994);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 514, 21789, 21994);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 514, 21789, 21994);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 514, 21789, 21994);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 514, 21789, 21994);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 514, 21789, 21994);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 514, 21789, 21994);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 514, 21789, 21994);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 514, 21789, 21994);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 514, 21789, 21994);
            CallChecker.varInit(this.m_registry, "m_registry", 514, 21789, 21994);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 514, 21789, 21994);
            CallChecker.varInit(this.m_nextId, "m_nextId", 514, 21789, 21994);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 514, 21789, 21994);
            CallChecker.varInit(this.m_cache, "m_cache", 514, 21789, 21994);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 514, 21789, 21994);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 514, 21789, 21994);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 514, 21789, 21994);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 514, 21789, 21994);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 514, 21789, 21994);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 514, 21789, 21994);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 514, 21789, 21994);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 514, 21789, 21994);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 514, 21789, 21994);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 514, 21789, 21994);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 514, 21789, 21994);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 514, 21789, 21994);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 514, 21789, 21994);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 514, 21789, 21994);
            CallChecker.varInit(this.m_resolver, "m_resolver", 514, 21789, 21994);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 514, 21789, 21994);
            CallChecker.varInit(this.m_configMap, "m_configMap", 514, 21789, 21994);
            CallChecker.varInit(this.m_logger, "m_logger", 514, 21789, 21994);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 514, 21789, 21994);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 514, 21789, 21994);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 514, 21789, 21994);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 514, 21789, 21994);
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Felix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context585.methodEnd();
        }
    }

    @Override
    public <A> A adapt(Class<A> type) {
        checkAdapt(type);
        if ((type == (Framework.class)) || (type == (Felix.class))) {
            return ((A) (this));
        }else
            if ((type == (org.osgi.framework.wiring.FrameworkWiring.class)) || (type == (FrameworkWiringImpl.class))) {
                return ((A) (m_fwkWiring));
            }else
                if ((type == (org.osgi.framework.startlevel.FrameworkStartLevel.class)) || (type == (FrameworkStartLevelImpl.class))) {
                    return ((A) (m_fwkStartLevel));
                }
            
        
        return super.adapt(type);
    }

    @Override
    public long getBundleId() {
        MethodContext _bcornu_methode_context587 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 542, 22577, 22645);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 542, 22577, 22645);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 542, 22577, 22645);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 542, 22577, 22645);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 542, 22577, 22645);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 542, 22577, 22645);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 542, 22577, 22645);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 542, 22577, 22645);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 542, 22577, 22645);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 542, 22577, 22645);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 542, 22577, 22645);
            CallChecker.varInit(this.m_registry, "m_registry", 542, 22577, 22645);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 542, 22577, 22645);
            CallChecker.varInit(this.m_nextId, "m_nextId", 542, 22577, 22645);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 542, 22577, 22645);
            CallChecker.varInit(this.m_cache, "m_cache", 542, 22577, 22645);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 542, 22577, 22645);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 542, 22577, 22645);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 542, 22577, 22645);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 542, 22577, 22645);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 542, 22577, 22645);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 542, 22577, 22645);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 542, 22577, 22645);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 542, 22577, 22645);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 542, 22577, 22645);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 542, 22577, 22645);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 542, 22577, 22645);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 542, 22577, 22645);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 542, 22577, 22645);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 542, 22577, 22645);
            CallChecker.varInit(this.m_resolver, "m_resolver", 542, 22577, 22645);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 542, 22577, 22645);
            CallChecker.varInit(this.m_configMap, "m_configMap", 542, 22577, 22645);
            CallChecker.varInit(this.m_logger, "m_logger", 542, 22577, 22645);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 542, 22577, 22645);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 542, 22577, 22645);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 542, 22577, 22645);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 542, 22577, 22645);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context587.methodEnd();
        }
    }

    @Override
    public long getLastModified() {
        MethodContext _bcornu_methode_context588 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 548, 22652, 22724);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 548, 22652, 22724);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 548, 22652, 22724);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 548, 22652, 22724);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 548, 22652, 22724);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 548, 22652, 22724);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 548, 22652, 22724);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 548, 22652, 22724);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 548, 22652, 22724);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 548, 22652, 22724);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 548, 22652, 22724);
            CallChecker.varInit(this.m_registry, "m_registry", 548, 22652, 22724);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 548, 22652, 22724);
            CallChecker.varInit(this.m_nextId, "m_nextId", 548, 22652, 22724);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 548, 22652, 22724);
            CallChecker.varInit(this.m_cache, "m_cache", 548, 22652, 22724);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 548, 22652, 22724);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 548, 22652, 22724);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 548, 22652, 22724);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 548, 22652, 22724);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 548, 22652, 22724);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 548, 22652, 22724);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 548, 22652, 22724);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 548, 22652, 22724);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 548, 22652, 22724);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 548, 22652, 22724);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 548, 22652, 22724);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 548, 22652, 22724);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 548, 22652, 22724);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 548, 22652, 22724);
            CallChecker.varInit(this.m_resolver, "m_resolver", 548, 22652, 22724);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 548, 22652, 22724);
            CallChecker.varInit(this.m_configMap, "m_configMap", 548, 22652, 22724);
            CallChecker.varInit(this.m_logger, "m_logger", 548, 22652, 22724);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 548, 22652, 22724);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 548, 22652, 22724);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 548, 22652, 22724);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 548, 22652, 22724);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context588.methodEnd();
        }
    }

    @Override
    void setLastModified(long l) {
        MethodContext _bcornu_methode_context589 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 554, 22731, 22803);
            CallChecker.varInit(l, "l", 554, 22731, 22803);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 554, 22731, 22803);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 554, 22731, 22803);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 554, 22731, 22803);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 554, 22731, 22803);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 554, 22731, 22803);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 554, 22731, 22803);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 554, 22731, 22803);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 554, 22731, 22803);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 554, 22731, 22803);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 554, 22731, 22803);
            CallChecker.varInit(this.m_registry, "m_registry", 554, 22731, 22803);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 554, 22731, 22803);
            CallChecker.varInit(this.m_nextId, "m_nextId", 554, 22731, 22803);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 554, 22731, 22803);
            CallChecker.varInit(this.m_cache, "m_cache", 554, 22731, 22803);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 554, 22731, 22803);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 554, 22731, 22803);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 554, 22731, 22803);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 554, 22731, 22803);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 554, 22731, 22803);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 554, 22731, 22803);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 554, 22731, 22803);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 554, 22731, 22803);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 554, 22731, 22803);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 554, 22731, 22803);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 554, 22731, 22803);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 554, 22731, 22803);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 554, 22731, 22803);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 554, 22731, 22803);
            CallChecker.varInit(this.m_resolver, "m_resolver", 554, 22731, 22803);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 554, 22731, 22803);
            CallChecker.varInit(this.m_configMap, "m_configMap", 554, 22731, 22803);
            CallChecker.varInit(this.m_logger, "m_logger", 554, 22731, 22803);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 554, 22731, 22803);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 554, 22731, 22803);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 554, 22731, 22803);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 554, 22731, 22803);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context589.methodEnd();
        }
    }

    @Override
    String _getLocation() {
        MethodContext _bcornu_methode_context590 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 560, 22810, 22905);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 560, 22810, 22905);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 560, 22810, 22905);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 560, 22810, 22905);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 560, 22810, 22905);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 560, 22810, 22905);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 560, 22810, 22905);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 560, 22810, 22905);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 560, 22810, 22905);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 560, 22810, 22905);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 560, 22810, 22905);
            CallChecker.varInit(this.m_registry, "m_registry", 560, 22810, 22905);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 560, 22810, 22905);
            CallChecker.varInit(this.m_nextId, "m_nextId", 560, 22810, 22905);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 560, 22810, 22905);
            CallChecker.varInit(this.m_cache, "m_cache", 560, 22810, 22905);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 560, 22810, 22905);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 560, 22810, 22905);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 560, 22810, 22905);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 560, 22810, 22905);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 560, 22810, 22905);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 560, 22810, 22905);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 560, 22810, 22905);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 560, 22810, 22905);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 560, 22810, 22905);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 560, 22810, 22905);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 560, 22810, 22905);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 560, 22810, 22905);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 560, 22810, 22905);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 560, 22810, 22905);
            CallChecker.varInit(this.m_resolver, "m_resolver", 560, 22810, 22905);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 560, 22810, 22905);
            CallChecker.varInit(this.m_configMap, "m_configMap", 560, 22810, 22905);
            CallChecker.varInit(this.m_logger, "m_logger", 560, 22810, 22905);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 560, 22810, 22905);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 560, 22810, 22905);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 560, 22810, 22905);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 560, 22810, 22905);
            return Constants.SYSTEM_BUNDLE_LOCATION;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context590.methodEnd();
        }
    }

    @Override
    public int getPersistentState() {
        MethodContext _bcornu_methode_context591 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 566, 22912, 22998);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 566, 22912, 22998);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 566, 22912, 22998);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 566, 22912, 22998);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 566, 22912, 22998);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 566, 22912, 22998);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 566, 22912, 22998);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 566, 22912, 22998);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 566, 22912, 22998);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 566, 22912, 22998);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 566, 22912, 22998);
            CallChecker.varInit(this.m_registry, "m_registry", 566, 22912, 22998);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 566, 22912, 22998);
            CallChecker.varInit(this.m_nextId, "m_nextId", 566, 22912, 22998);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 566, 22912, 22998);
            CallChecker.varInit(this.m_cache, "m_cache", 566, 22912, 22998);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 566, 22912, 22998);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 566, 22912, 22998);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 566, 22912, 22998);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 566, 22912, 22998);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 566, 22912, 22998);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 566, 22912, 22998);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 566, 22912, 22998);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 566, 22912, 22998);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 566, 22912, 22998);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 566, 22912, 22998);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 566, 22912, 22998);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 566, 22912, 22998);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 566, 22912, 22998);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 566, 22912, 22998);
            CallChecker.varInit(this.m_resolver, "m_resolver", 566, 22912, 22998);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 566, 22912, 22998);
            CallChecker.varInit(this.m_configMap, "m_configMap", 566, 22912, 22998);
            CallChecker.varInit(this.m_logger, "m_logger", 566, 22912, 22998);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 566, 22912, 22998);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 566, 22912, 22998);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 566, 22912, 22998);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 566, 22912, 22998);
            return Bundle.ACTIVE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context591.methodEnd();
        }
    }

    @Override
    public void setPersistentStateInactive() {
        MethodContext _bcornu_methode_context592 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 572, 23005, 23089);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 572, 23005, 23089);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 572, 23005, 23089);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 572, 23005, 23089);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 572, 23005, 23089);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 572, 23005, 23089);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 572, 23005, 23089);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 572, 23005, 23089);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 572, 23005, 23089);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 572, 23005, 23089);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 572, 23005, 23089);
            CallChecker.varInit(this.m_registry, "m_registry", 572, 23005, 23089);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 572, 23005, 23089);
            CallChecker.varInit(this.m_nextId, "m_nextId", 572, 23005, 23089);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 572, 23005, 23089);
            CallChecker.varInit(this.m_cache, "m_cache", 572, 23005, 23089);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 572, 23005, 23089);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 572, 23005, 23089);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 572, 23005, 23089);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 572, 23005, 23089);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 572, 23005, 23089);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 572, 23005, 23089);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 572, 23005, 23089);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 572, 23005, 23089);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 572, 23005, 23089);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 572, 23005, 23089);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 572, 23005, 23089);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 572, 23005, 23089);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 572, 23005, 23089);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 572, 23005, 23089);
            CallChecker.varInit(this.m_resolver, "m_resolver", 572, 23005, 23089);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 572, 23005, 23089);
            CallChecker.varInit(this.m_configMap, "m_configMap", 572, 23005, 23089);
            CallChecker.varInit(this.m_logger, "m_logger", 572, 23005, 23089);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 572, 23005, 23089);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 572, 23005, 23089);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 572, 23005, 23089);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 572, 23005, 23089);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context592.methodEnd();
        }
    }

    @Override
    public void setPersistentStateActive() {
        MethodContext _bcornu_methode_context593 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 578, 23096, 23178);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 578, 23096, 23178);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 578, 23096, 23178);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 578, 23096, 23178);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 578, 23096, 23178);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 578, 23096, 23178);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 578, 23096, 23178);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 578, 23096, 23178);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 578, 23096, 23178);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 578, 23096, 23178);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 578, 23096, 23178);
            CallChecker.varInit(this.m_registry, "m_registry", 578, 23096, 23178);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 578, 23096, 23178);
            CallChecker.varInit(this.m_nextId, "m_nextId", 578, 23096, 23178);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 578, 23096, 23178);
            CallChecker.varInit(this.m_cache, "m_cache", 578, 23096, 23178);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 578, 23096, 23178);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 578, 23096, 23178);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 578, 23096, 23178);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 578, 23096, 23178);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 578, 23096, 23178);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 578, 23096, 23178);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 578, 23096, 23178);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 578, 23096, 23178);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 578, 23096, 23178);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 578, 23096, 23178);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 578, 23096, 23178);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 578, 23096, 23178);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 578, 23096, 23178);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 578, 23096, 23178);
            CallChecker.varInit(this.m_resolver, "m_resolver", 578, 23096, 23178);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 578, 23096, 23178);
            CallChecker.varInit(this.m_configMap, "m_configMap", 578, 23096, 23178);
            CallChecker.varInit(this.m_logger, "m_logger", 578, 23096, 23178);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 578, 23096, 23178);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 578, 23096, 23178);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 578, 23096, 23178);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 578, 23096, 23178);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context593.methodEnd();
        }
    }

    @Override
    public void setPersistentStateUninstalled() {
        MethodContext _bcornu_methode_context594 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 584, 23185, 23272);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 584, 23185, 23272);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 584, 23185, 23272);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 584, 23185, 23272);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 584, 23185, 23272);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 584, 23185, 23272);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 584, 23185, 23272);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 584, 23185, 23272);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 584, 23185, 23272);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 584, 23185, 23272);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 584, 23185, 23272);
            CallChecker.varInit(this.m_registry, "m_registry", 584, 23185, 23272);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 584, 23185, 23272);
            CallChecker.varInit(this.m_nextId, "m_nextId", 584, 23185, 23272);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 584, 23185, 23272);
            CallChecker.varInit(this.m_cache, "m_cache", 584, 23185, 23272);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 584, 23185, 23272);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 584, 23185, 23272);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 584, 23185, 23272);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 584, 23185, 23272);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 584, 23185, 23272);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 584, 23185, 23272);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 584, 23185, 23272);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 584, 23185, 23272);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 584, 23185, 23272);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 584, 23185, 23272);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 584, 23185, 23272);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 584, 23185, 23272);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 584, 23185, 23272);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 584, 23185, 23272);
            CallChecker.varInit(this.m_resolver, "m_resolver", 584, 23185, 23272);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 584, 23185, 23272);
            CallChecker.varInit(this.m_configMap, "m_configMap", 584, 23185, 23272);
            CallChecker.varInit(this.m_logger, "m_logger", 584, 23185, 23272);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 584, 23185, 23272);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 584, 23185, 23272);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 584, 23185, 23272);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 584, 23185, 23272);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context594.methodEnd();
        }
    }

    @Override
    int getStartLevel(int defaultLevel) {
        MethodContext _bcornu_methode_context595 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 596, 23279, 23607);
            CallChecker.varInit(defaultLevel, "defaultLevel", 596, 23279, 23607);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 596, 23279, 23607);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 596, 23279, 23607);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 596, 23279, 23607);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 596, 23279, 23607);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 596, 23279, 23607);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 596, 23279, 23607);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 596, 23279, 23607);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 596, 23279, 23607);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 596, 23279, 23607);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 596, 23279, 23607);
            CallChecker.varInit(this.m_registry, "m_registry", 596, 23279, 23607);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 596, 23279, 23607);
            CallChecker.varInit(this.m_nextId, "m_nextId", 596, 23279, 23607);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 596, 23279, 23607);
            CallChecker.varInit(this.m_cache, "m_cache", 596, 23279, 23607);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 596, 23279, 23607);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 596, 23279, 23607);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 596, 23279, 23607);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 596, 23279, 23607);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 596, 23279, 23607);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 596, 23279, 23607);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 596, 23279, 23607);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 596, 23279, 23607);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 596, 23279, 23607);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 596, 23279, 23607);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 596, 23279, 23607);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 596, 23279, 23607);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 596, 23279, 23607);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 596, 23279, 23607);
            CallChecker.varInit(this.m_resolver, "m_resolver", 596, 23279, 23607);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 596, 23279, 23607);
            CallChecker.varInit(this.m_configMap, "m_configMap", 596, 23279, 23607);
            CallChecker.varInit(this.m_logger, "m_logger", 596, 23279, 23607);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 596, 23279, 23607);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 596, 23279, 23607);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 596, 23279, 23607);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 596, 23279, 23607);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context595.methodEnd();
        }
    }

    @Override
    void setStartLevel(int level) {
        MethodContext _bcornu_methode_context596 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 610, 23614, 24146);
            CallChecker.varInit(level, "level", 610, 23614, 24146);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 610, 23614, 24146);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 610, 23614, 24146);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 610, 23614, 24146);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 610, 23614, 24146);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 610, 23614, 24146);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 610, 23614, 24146);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 610, 23614, 24146);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 610, 23614, 24146);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 610, 23614, 24146);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 610, 23614, 24146);
            CallChecker.varInit(this.m_registry, "m_registry", 610, 23614, 24146);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 610, 23614, 24146);
            CallChecker.varInit(this.m_nextId, "m_nextId", 610, 23614, 24146);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 610, 23614, 24146);
            CallChecker.varInit(this.m_cache, "m_cache", 610, 23614, 24146);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 610, 23614, 24146);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 610, 23614, 24146);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 610, 23614, 24146);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 610, 23614, 24146);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 610, 23614, 24146);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 610, 23614, 24146);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 610, 23614, 24146);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 610, 23614, 24146);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 610, 23614, 24146);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 610, 23614, 24146);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 610, 23614, 24146);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 610, 23614, 24146);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 610, 23614, 24146);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 610, 23614, 24146);
            CallChecker.varInit(this.m_resolver, "m_resolver", 610, 23614, 24146);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 610, 23614, 24146);
            CallChecker.varInit(this.m_configMap, "m_configMap", 610, 23614, 24146);
            CallChecker.varInit(this.m_logger, "m_logger", 610, 23614, 24146);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 610, 23614, 24146);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 610, 23614, 24146);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 610, 23614, 24146);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 610, 23614, 24146);
            throw new IllegalArgumentException("Cannot set the system bundle's start level.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context596.methodEnd();
        }
    }

    @Override
    public boolean hasPermission(Object obj) {
        MethodContext _bcornu_methode_context597 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 616, 24153, 24239);
            CallChecker.varInit(obj, "obj", 616, 24153, 24239);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 616, 24153, 24239);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 616, 24153, 24239);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 616, 24153, 24239);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 616, 24153, 24239);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 616, 24153, 24239);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 616, 24153, 24239);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 616, 24153, 24239);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 616, 24153, 24239);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 616, 24153, 24239);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 616, 24153, 24239);
            CallChecker.varInit(this.m_registry, "m_registry", 616, 24153, 24239);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 616, 24153, 24239);
            CallChecker.varInit(this.m_nextId, "m_nextId", 616, 24153, 24239);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 616, 24153, 24239);
            CallChecker.varInit(this.m_cache, "m_cache", 616, 24153, 24239);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 616, 24153, 24239);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 616, 24153, 24239);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 616, 24153, 24239);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 616, 24153, 24239);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 616, 24153, 24239);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 616, 24153, 24239);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 616, 24153, 24239);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 616, 24153, 24239);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 616, 24153, 24239);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 616, 24153, 24239);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 616, 24153, 24239);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 616, 24153, 24239);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 616, 24153, 24239);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 616, 24153, 24239);
            CallChecker.varInit(this.m_resolver, "m_resolver", 616, 24153, 24239);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 616, 24153, 24239);
            CallChecker.varInit(this.m_configMap, "m_configMap", 616, 24153, 24239);
            CallChecker.varInit(this.m_logger, "m_logger", 616, 24153, 24239);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 616, 24153, 24239);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 616, 24153, 24239);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 616, 24153, 24239);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 616, 24153, 24239);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context597.methodEnd();
        }
    }

    public void init() throws BundleException {
        MethodContext _bcornu_methode_context598 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 622, 24247, 24341);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 622, 24247, 24341);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 622, 24247, 24341);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 622, 24247, 24341);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 622, 24247, 24341);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 622, 24247, 24341);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 622, 24247, 24341);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 622, 24247, 24341);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 622, 24247, 24341);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 622, 24247, 24341);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 622, 24247, 24341);
            CallChecker.varInit(this.m_registry, "m_registry", 622, 24247, 24341);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 622, 24247, 24341);
            CallChecker.varInit(this.m_nextId, "m_nextId", 622, 24247, 24341);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 622, 24247, 24341);
            CallChecker.varInit(this.m_cache, "m_cache", 622, 24247, 24341);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 622, 24247, 24341);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 622, 24247, 24341);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 622, 24247, 24341);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 622, 24247, 24341);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 622, 24247, 24341);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 622, 24247, 24341);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 622, 24247, 24341);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 622, 24247, 24341);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 622, 24247, 24341);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 622, 24247, 24341);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 622, 24247, 24341);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 622, 24247, 24341);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 622, 24247, 24341);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 622, 24247, 24341);
            CallChecker.varInit(this.m_resolver, "m_resolver", 622, 24247, 24341);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 622, 24247, 24341);
            CallChecker.varInit(this.m_configMap, "m_configMap", 622, 24247, 24341);
            CallChecker.varInit(this.m_logger, "m_logger", 622, 24247, 24341);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 622, 24247, 24341);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 622, 24247, 24341);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 622, 24247, 24341);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 622, 24247, 24341);
            init(((FrameworkListener[]) (null)));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context598.methodEnd();
        }
    }

    public void init(final FrameworkListener... listeners) throws BundleException {
        MethodContext _bcornu_methode_context599 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 629, 24347, 37526);
            CallChecker.varInit(listeners, "listeners", 629, 24347, 37526);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 629, 24347, 37526);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 629, 24347, 37526);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 629, 24347, 37526);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 629, 24347, 37526);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 629, 24347, 37526);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 629, 24347, 37526);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 629, 24347, 37526);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 629, 24347, 37526);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 629, 24347, 37526);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 629, 24347, 37526);
            CallChecker.varInit(this.m_registry, "m_registry", 629, 24347, 37526);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 629, 24347, 37526);
            CallChecker.varInit(this.m_nextId, "m_nextId", 629, 24347, 37526);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 629, 24347, 37526);
            CallChecker.varInit(this.m_cache, "m_cache", 629, 24347, 37526);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 629, 24347, 37526);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 629, 24347, 37526);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 629, 24347, 37526);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 629, 24347, 37526);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 629, 24347, 37526);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 629, 24347, 37526);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 629, 24347, 37526);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 629, 24347, 37526);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 629, 24347, 37526);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 629, 24347, 37526);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 629, 24347, 37526);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 629, 24347, 37526);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 629, 24347, 37526);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 629, 24347, 37526);
            CallChecker.varInit(this.m_resolver, "m_resolver", 629, 24347, 37526);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 629, 24347, 37526);
            CallChecker.varInit(this.m_configMap, "m_configMap", 629, 24347, 37526);
            CallChecker.varInit(this.m_logger, "m_logger", 629, 24347, 37526);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 629, 24347, 37526);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 629, 24347, 37526);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 629, 24347, 37526);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 629, 24347, 37526);
            acquireBundleLock(this, ((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.STARTING)) | (Bundle.ACTIVE)));
            TryContext _bcornu_try_context_155 = new TryContext(155, Felix.class);
            try {
                if (((getState()) == (Bundle.INSTALLED)) || ((getState()) == (Bundle.RESOLVED))) {
                    String security = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(m_configMap, Map.class, 638, 24903, 24913)) {
                        security = ((String) (CallChecker.isCalled(m_configMap, Map.class, 638, 24903, 24913).get(Constants.FRAMEWORK_SECURITY)));
                        CallChecker.varAssign(security, "security", 638, 24903, 24913);
                    }
                    if (security != null) {
                        if ((System.getSecurityManager()) != null) {
                            throw new SecurityException("SecurityManager already installed");
                        }
                        security = security.trim();
                        CallChecker.varAssign(security, "security", 645, 25221, 25247);
                        if (CallChecker.beforeDeref(Constants.FRAMEWORK_SECURITY_OSGI, String.class, 646, 25273, 25305)) {
                            if ((CallChecker.isCalled(Constants.FRAMEWORK_SECURITY_OSGI, String.class, 646, 25273, 25305).equalsIgnoreCase(security)) || ((security.length()) == 0)) {
                                System.setSecurityManager((m_securityManager = new SecurityManager()));
                                CallChecker.varAssign(this.m_securityManager, "this.m_securityManager", 648, 25435, 25475);
                            }else {
                                TryContext _bcornu_try_context_145 = new TryContext(145, Felix.class, "java.lang.Throwable");
                                try {
                                    if (CallChecker.beforeDeref(Class.forName(security), Class.class, 655, 25726, 25748)) {
                                        System.setSecurityManager((m_securityManager = ((SecurityManager) (Class.forName(security).newInstance()))));
                                        CallChecker.varAssign(this.m_securityManager, "this.m_securityManager", 654, 25656, 25762);
                                    }
                                } catch (Throwable t) {
                                    _bcornu_try_context_145.catchStart(145);
                                    SecurityException se = CallChecker.varInit(new SecurityException(("Unable to install custom SecurityManager: " + security)), "se", 659, 25890, 26060);
                                    if (CallChecker.beforeDeref(se, SecurityException.class, 662, 26090, 26091)) {
                                        se = CallChecker.beforeCalled(se, SecurityException.class, 662, 26090, 26091);
                                        CallChecker.isCalled(se, SecurityException.class, 662, 26090, 26091).initCause(t);
                                    }
                                    throw se;
                                } finally {
                                    _bcornu_try_context_145.finallyStart(145);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 670, 26352, 26369)) {
                        CallChecker.isCalled(m_configMutableMap, Map.class, 670, 26352, 26369).put(FelixConstants.FRAMEWORK_UUID, Util.randomUUID());
                    }
                    if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 675, 26562, 26579)) {
                        m_activatorList = ((List) (CallChecker.isCalled(m_configMutableMap, Map.class, 675, 26562, 26579).get(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP)));
                        CallChecker.varAssign(this.m_activatorList, "this.m_activatorList", 675, 26537, 26629);
                    }
                    if ((m_activatorList) == null) {
                        m_activatorList = new ArrayList();
                        CallChecker.varAssign(this.m_activatorList, "this.m_activatorList", 676, 26647, 26741);
                    }else {
                        m_activatorList = new ArrayList(m_activatorList);
                        CallChecker.varAssign(this.m_activatorList, "this.m_activatorList", 676, 26647, 26741);
                    }
                    if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 679, 26808, 26819)) {
                        CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 679, 26808, 26819).startDispatching();
                    }
                    if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 684, 27024, 27041)) {
                        m_cache = ((BundleCache) (CallChecker.isCalled(m_configMutableMap, Map.class, 684, 27024, 27041).get(FelixConstants.FRAMEWORK_BUNDLECACHE_IMPL)));
                        CallChecker.varAssign(this.m_cache, "this.m_cache", 683, 26980, 27089);
                    }
                    if ((m_cache) == null) {
                        TryContext _bcornu_try_context_146 = new TryContext(146, Felix.class, "java.lang.Exception");
                        try {
                            m_cache = new BundleCache(m_logger, m_configMap);
                            CallChecker.varAssign(this.m_cache, "this.m_cache", 689, 27225, 27273);
                        } catch (Exception ex) {
                            _bcornu_try_context_146.catchStart(146);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 693, 27396, 27403)) {
                                CallChecker.isCalled(m_logger, Logger.class, 693, 27396, 27403).log(Logger.LOG_ERROR, "Error creating bundle cache.", ex);
                            }
                            throw new BundleException("Error creating bundle cache.", ex);
                        } finally {
                            _bcornu_try_context_146.finallyStart(146);
                        }
                    }
                    if ((getState()) == (Bundle.INSTALLED)) {
                        String clean = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(m_configMap, Map.class, 702, 27843, 27853)) {
                            clean = ((String) (CallChecker.isCalled(m_configMap, Map.class, 702, 27843, 27853).get(Constants.FRAMEWORK_STORAGE_CLEAN)));
                            CallChecker.varAssign(clean, "clean", 702, 27843, 27853);
                        }
                        if ((clean != null) && (clean.equalsIgnoreCase(Constants.FRAMEWORK_STORAGE_CLEAN_ONFIRSTINIT))) {
                            TryContext _bcornu_try_context_147 = new TryContext(147, Felix.class, "java.lang.Exception");
                            try {
                                m_cache.delete();
                            } catch (Exception ex) {
                                _bcornu_try_context_147.catchStart(147);
                                throw new BundleException("Unable to flush bundle cache.", ex);
                            } finally {
                                _bcornu_try_context_147.finallyStart(147);
                            }
                        }
                    }
                    Map[] maps = CallChecker.varInit(new Map[]{ new HashMap<String, BundleImpl>(1) , new TreeMap<Long, BundleImpl>() }, "maps", 718, 28491, 28641);
                    m_uninstalledBundles = new ArrayList<BundleImpl>(0);
                    CallChecker.varAssign(this.m_uninstalledBundles, "this.m_uninstalledBundles", 722, 28659, 28710);
                    if (CallChecker.beforeDeref(maps, Map[].class, 725, 28803, 28806)) {
                        maps = CallChecker.beforeCalled(maps, Map[].class, 725, 28803, 28806);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 725, 28803, 28806)[Felix.LOCATION_MAP_IDX], Map.class, 725, 28803, 28824)) {
                            maps = CallChecker.beforeCalled(maps, Map[].class, 725, 28803, 28806);
                            CallChecker.isCalled(maps, Map[].class, 725, 28803, 28806)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 725, 28803, 28806)[Felix.LOCATION_MAP_IDX], Map.class, 725, 28803, 28824);
                            CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 725, 28803, 28806)[Felix.LOCATION_MAP_IDX], Map.class, 725, 28803, 28824).put(_getLocation(), this);
                        }
                    }
                    if (CallChecker.beforeDeref(maps, Map[].class, 726, 28869, 28872)) {
                        maps = CallChecker.beforeCalled(maps, Map[].class, 726, 28869, 28872);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 726, 28869, 28872)[Felix.IDENTIFIER_MAP_IDX], Map.class, 726, 28869, 28892)) {
                            maps = CallChecker.beforeCalled(maps, Map[].class, 726, 28869, 28872);
                            CallChecker.isCalled(maps, Map[].class, 726, 28869, 28872)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 726, 28869, 28872)[Felix.IDENTIFIER_MAP_IDX], Map.class, 726, 28869, 28892);
                            CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 726, 28869, 28872)[Felix.IDENTIFIER_MAP_IDX], Map.class, 726, 28869, 28892).put(new Long(0), this);
                        }
                    }
                    m_installedBundles = maps;
                    CallChecker.varAssign(this.m_installedBundles, "this.m_installedBundles", 727, 28934, 28959);
                    TryContext _bcornu_try_context_148 = new TryContext(148, Felix.class, "org.osgi.service.resolver.ResolutionException");
                    try {
                        if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 733, 29144, 29153)) {
                            CallChecker.isCalled(m_resolver, StatefulResolver.class, 733, 29144, 29153).resolve(Collections.singleton(adapt(BundleRevision.class)), Collections.EMPTY_SET);
                        }
                    } catch (ResolutionException ex) {
                        _bcornu_try_context_148.catchStart(148);
                        throw new BundleException(("Unresolved constraint in System Bundle:" + (ex.getUnresolvedRequirements())));
                    } finally {
                        _bcornu_try_context_148.finallyStart(148);
                    }
                    BundleArchive[] archives = CallChecker.varInit(null, "archives", 749, 29943, 29974);
                    TryContext _bcornu_try_context_149 = new TryContext(149, Felix.class, "java.lang.Exception");
                    try {
                        archives = m_cache.getArchives();
                        CallChecker.varAssign(archives, "archives", 754, 30091, 30123);
                    } catch (Exception ex) {
                        _bcornu_try_context_149.catchStart(149);
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 758, 30218, 30225)) {
                            CallChecker.isCalled(m_logger, Logger.class, 758, 30218, 30225).log(Logger.LOG_ERROR, "Unable to list saved bundles.", ex);
                        }
                        archives = null;
                        CallChecker.varAssign(archives, "archives", 759, 30307, 30322);
                    } finally {
                        _bcornu_try_context_149.finallyStart(149);
                    }
                    setActivator(new Felix.SystemBundleActivator());
                    setBundleContext(new BundleContextImpl(m_logger, this, this));
                    archives = CallChecker.beforeCalled(archives, BundleArchive[].class, 767, 30681, 30688);
                    for (int i = 0; (archives != null) && (i < (CallChecker.isCalled(archives, BundleArchive[].class, 767, 30681, 30688).length)); i++) {
                        TryContext _bcornu_try_context_151 = new TryContext(151, Felix.class, "java.lang.Exception");
                        try {
                            archives = CallChecker.beforeCalled(archives, BundleArchive[].class, 774, 31050, 31057);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(archives, BundleArchive[].class, 774, 31050, 31057)[i], BundleArchive.class, 774, 31050, 31060)) {
                                archives[i] = CallChecker.beforeCalled(archives[i], BundleArchive.class, 774, 31050, 31060);
                                m_nextId = Math.max(m_nextId, ((CallChecker.isCalled(archives[i], BundleArchive.class, 774, 31050, 31060).getId()) + 1));
                                CallChecker.varAssign(this.m_nextId, "this.m_nextId", 774, 31020, 31074);
                            }
                            archives = CallChecker.beforeCalled(archives, BundleArchive[].class, 781, 31473, 31480);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(archives, BundleArchive[].class, 781, 31473, 31480)[i], BundleArchive.class, 781, 31473, 31483)) {
                                archives[i] = CallChecker.beforeCalled(archives[i], BundleArchive.class, 781, 31473, 31483);
                                if ((CallChecker.isCalled(archives[i], BundleArchive.class, 781, 31473, 31483).getPersistentState()) == (Bundle.UNINSTALLED)) {
                                    archives = CallChecker.beforeCalled(archives, BundleArchive[].class, 783, 31583, 31590);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(archives, BundleArchive[].class, 783, 31583, 31590)[i], BundleArchive.class, 783, 31583, 31593)) {
                                        archives[i] = CallChecker.beforeCalled(archives[i], BundleArchive.class, 783, 31583, 31593);
                                        CallChecker.isCalled(archives[i], BundleArchive.class, 783, 31583, 31593).closeAndDelete();
                                    }
                                }else {
                                    reloadBundle(archives[i]);
                                }
                            }
                        } catch (Exception ex) {
                            _bcornu_try_context_151.catchStart(151);
                            fireFrameworkEvent(FrameworkEvent.ERROR, this, ex);
                            TryContext _bcornu_try_context_150 = new TryContext(150, Felix.class, "java.lang.Exception");
                            try {
                                archives = CallChecker.beforeCalled(archives, BundleArchive[].class, 799, 32265, 32272);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(archives, BundleArchive[].class, 799, 32265, 32272)[i], BundleArchive.class, 799, 32265, 32275)) {
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 797, 32143, 32150)) {
                                        archives[i] = CallChecker.beforeCalled(archives[i], BundleArchive.class, 799, 32265, 32275);
                                        CallChecker.isCalled(m_logger, Logger.class, 797, 32143, 32150).log(Logger.LOG_ERROR, ("Unable to re-install " + (CallChecker.isCalled(archives[i], BundleArchive.class, 799, 32265, 32275).getLocation())), ex);
                                    }
                                }
                            } catch (Exception ex2) {
                                _bcornu_try_context_150.catchStart(150);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 804, 32455, 32462)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 804, 32455, 32462).log(Logger.LOG_ERROR, "Unable to re-install cached bundle.", ex);
                                }
                            } finally {
                                _bcornu_try_context_150.finallyStart(150);
                            }
                        } finally {
                            _bcornu_try_context_151.finallyStart(151);
                        }
                    }
                    m_nextId = Math.max(m_nextId, loadNextId());
                    CallChecker.varAssign(this.m_nextId, "this.m_nextId", 817, 33092, 33135);
                    setBundleStateAndNotify(this, Bundle.STARTING);
                    m_shutdownGate = new ThreadGate();
                    CallChecker.varAssign(this.m_shutdownGate, "this.m_shutdownGate", 824, 33423, 33456);
                    if (listeners != null) {
                        for (final FrameworkListener fl : listeners) {
                            addFrameworkListener(this, fl);
                        }
                    }
                    if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 836, 33794, 33803)) {
                        CallChecker.isCalled(m_resolver, StatefulResolver.class, 836, 33794, 33803).start();
                    }
                    if (CallChecker.beforeDeref(m_fwkWiring, FrameworkWiringImpl.class, 837, 33830, 33840)) {
                        CallChecker.isCalled(m_fwkWiring, FrameworkWiringImpl.class, 837, 33830, 33840).start();
                    }
                    if (CallChecker.beforeDeref(m_fwkStartLevel, FrameworkStartLevelImpl.class, 838, 33867, 33881)) {
                        CallChecker.isCalled(m_fwkStartLevel, FrameworkStartLevelImpl.class, 838, 33867, 33881).start();
                    }
                    TryContext _bcornu_try_context_152 = new TryContext(152, Felix.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 842, 33951, 33970)) {
                            CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 842, 33951, 33970).startActivator(getActivator(), _getBundleContext());
                        }
                    } catch (Throwable ex) {
                        _bcornu_try_context_152.catchStart(152);
                        if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 847, 34143, 34154)) {
                            CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 847, 34143, 34154).stopDispatching();
                        }
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 848, 34195, 34202)) {
                            CallChecker.isCalled(m_logger, Logger.class, 848, 34195, 34202).log(Logger.LOG_ERROR, "Unable to start system bundle.", ex);
                        }
                        throw new RuntimeException("Unable to start system bundle.");
                    } finally {
                        _bcornu_try_context_152.finallyStart(152);
                    }
                    final Felix npe_invocation_var184 = getFramework();
                    SecurityProvider sp = CallChecker.init(SecurityProvider.class);
                    if (CallChecker.beforeDeref(npe_invocation_var184, Felix.class, 854, 34579, 34592)) {
                        sp = CallChecker.isCalled(npe_invocation_var184, Felix.class, 854, 34579, 34592).getSecurityProvider();
                        CallChecker.varAssign(sp, "sp", 854, 34579, 34592);
                    }
                    if ((sp != null) && ((System.getSecurityManager()) != null)) {
                        boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 857, 34730, 34766);
                        if (!locked) {
                            throw new BundleException("Unable to acquire the global lock to check the bundle.");
                        }
                        TryContext _bcornu_try_context_154 = new TryContext(154, Felix.class);
                        try {
                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 865, 35074, 35091);
                            CallChecker.isCalled(m_installedBundles, Map[].class, 865, 35074, 35091)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 865, 35074, 35091)[Felix.IDENTIFIER_MAP_IDX], Map.class, 865, 35074, 35111);
                            for (Object bundle : CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 865, 35074, 35091)[Felix.IDENTIFIER_MAP_IDX], Map.class, 865, 35074, 35111).values()) {
                                TryContext _bcornu_try_context_153 = new TryContext(153, Felix.class, "java.lang.Exception");
                                try {
                                    if (bundle != (this)) {
                                        if (CallChecker.beforeDeref(bundle, Object.class, 871, 35394, 35399)) {
                                            setBundleProtectionDomain(((BundleImpl) (bundle)), CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 871, 35394, 35399).adapt(BundleRevisionImpl.class));
                                        }
                                    }
                                } catch (Exception ex) {
                                    _bcornu_try_context_153.catchStart(153);
                                    if (CallChecker.beforeDeref(bundle, Object.class, 876, 35625, 35630)) {
                                        CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 876, 35625, 35630).close();
                                    }
                                    if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 878, 35761, 35778)) {
                                        if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 879, 35866, 35883)) {
                                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 878, 35761, 35778);
                                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 879, 35866, 35883);
                                            maps = new Map[]{ new HashMap<String, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 878, 35761, 35778)[Felix.LOCATION_MAP_IDX]) , new TreeMap<Long, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 879, 35866, 35883)[Felix.IDENTIFIER_MAP_IDX]) };
                                            CallChecker.varAssign(maps, "maps", 877, 35674, 35939);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(maps, Map[].class, 881, 35973, 35976)) {
                                        if (CallChecker.beforeDeref(bundle, Object.class, 881, 36017, 36022)) {
                                            maps = CallChecker.beforeCalled(maps, Map[].class, 881, 35973, 35976);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 881, 35973, 35976)[Felix.LOCATION_MAP_IDX], Map.class, 881, 35973, 35994)) {
                                                maps = CallChecker.beforeCalled(maps, Map[].class, 881, 35973, 35976);
                                                CallChecker.isCalled(maps, Map[].class, 881, 35973, 35976)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 881, 35973, 35976)[Felix.LOCATION_MAP_IDX], Map.class, 881, 35973, 35994);
                                                CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 881, 35973, 35976)[Felix.LOCATION_MAP_IDX], Map.class, 881, 35973, 35994).remove(CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 881, 36017, 36022)._getLocation());
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(maps, Map[].class, 882, 36074, 36077)) {
                                        if (CallChecker.beforeDeref(bundle, Object.class, 882, 36129, 36134)) {
                                            maps = CallChecker.beforeCalled(maps, Map[].class, 882, 36074, 36077);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 882, 36074, 36077)[Felix.IDENTIFIER_MAP_IDX], Map.class, 882, 36074, 36097)) {
                                                maps = CallChecker.beforeCalled(maps, Map[].class, 882, 36074, 36077);
                                                CallChecker.isCalled(maps, Map[].class, 882, 36074, 36077)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 882, 36074, 36077)[Felix.IDENTIFIER_MAP_IDX], Map.class, 882, 36074, 36097);
                                                CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 882, 36074, 36077)[Felix.IDENTIFIER_MAP_IDX], Map.class, 882, 36074, 36097).remove(new Long(CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 882, 36129, 36134).getBundleId()));
                                            }
                                        }
                                    }
                                    m_installedBundles = maps;
                                    CallChecker.varAssign(this.m_installedBundles, "this.m_installedBundles", 883, 36186, 36211);
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 885, 36246, 36253)) {
                                        CallChecker.isCalled(m_logger, Logger.class, 885, 36246, 36253).log(Logger.LOG_ERROR, "Bundle in cache doesn't pass security check anymore.", ex);
                                    }
                                } finally {
                                    _bcornu_try_context_153.finallyStart(153);
                                }
                            }
                        } finally {
                            _bcornu_try_context_154.finallyStart(154);
                            releaseGlobalLock();
                        }
                    }
                    if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 899, 36736, 36753)) {
                        CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 899, 36736, 36753).startPendingExtensionBundles(this);
                    }
                    if (CallChecker.beforeDeref(m_fwkWiring, FrameworkWiringImpl.class, 900, 36813, 36823)) {
                        CallChecker.isCalled(m_fwkWiring, FrameworkWiringImpl.class, 900, 36813, 36823).refreshBundles(null);
                    }
                    synchronized(m_systemBundleClassCache) {
                        if (CallChecker.beforeDeref(m_systemBundleClassCache, Map.class, 907, 37156, 37179)) {
                            CallChecker.isCalled(m_systemBundleClassCache, Map.class, 907, 37156, 37179).clear();
                        }
                    }
                }
            } finally {
                _bcornu_try_context_155.finallyStart(155);
                releaseBundleLock(this);
                if (listeners != null) {
                    for (final FrameworkListener fl : listeners) {
                        removeFrameworkListener(this, fl);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context599.methodEnd();
        }
    }

    void setBundleProtectionDomain(BundleImpl bundleImpl, BundleRevisionImpl revisionImpl) throws Exception {
        MethodContext _bcornu_methode_context600 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 925, 37533, 38174);
            CallChecker.varInit(revisionImpl, "revisionImpl", 925, 37533, 38174);
            CallChecker.varInit(bundleImpl, "bundleImpl", 925, 37533, 38174);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 925, 37533, 38174);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 925, 37533, 38174);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 925, 37533, 38174);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 925, 37533, 38174);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 925, 37533, 38174);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 925, 37533, 38174);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 925, 37533, 38174);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 925, 37533, 38174);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 925, 37533, 38174);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 925, 37533, 38174);
            CallChecker.varInit(this.m_registry, "m_registry", 925, 37533, 38174);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 925, 37533, 38174);
            CallChecker.varInit(this.m_nextId, "m_nextId", 925, 37533, 38174);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 925, 37533, 38174);
            CallChecker.varInit(this.m_cache, "m_cache", 925, 37533, 38174);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 925, 37533, 38174);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 925, 37533, 38174);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 925, 37533, 38174);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 925, 37533, 38174);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 925, 37533, 38174);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 925, 37533, 38174);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 925, 37533, 38174);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 925, 37533, 38174);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 925, 37533, 38174);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 925, 37533, 38174);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 925, 37533, 38174);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 925, 37533, 38174);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 925, 37533, 38174);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 925, 37533, 38174);
            CallChecker.varInit(this.m_resolver, "m_resolver", 925, 37533, 38174);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 925, 37533, 38174);
            CallChecker.varInit(this.m_configMap, "m_configMap", 925, 37533, 38174);
            CallChecker.varInit(this.m_logger, "m_logger", 925, 37533, 38174);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 925, 37533, 38174);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 925, 37533, 38174);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 925, 37533, 38174);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 925, 37533, 38174);
            Object certificates = CallChecker.varInit(null, "certificates", 927, 37651, 37677);
            final Felix npe_invocation_var185 = getFramework();
            SecurityProvider sp = CallChecker.init(SecurityProvider.class);
            if (CallChecker.beforeDeref(npe_invocation_var185, Felix.class, 928, 37709, 37722)) {
                sp = CallChecker.isCalled(npe_invocation_var185, Felix.class, 928, 37709, 37722).getSecurityProvider();
                CallChecker.varAssign(sp, "sp", 928, 37709, 37722);
            }
            if ((sp != null) && ((System.getSecurityManager()) != null)) {
                sp.checkBundle(bundleImpl);
                Map signers = CallChecker.varInit(((Map) (sp.getSignerMatcher(bundleImpl, Bundle.SIGNERS_TRUSTED))), "signers", 932, 37876, 37951);
                if (CallChecker.beforeDeref(signers, Map.class, 933, 37980, 37986)) {
                    signers = CallChecker.beforeCalled(signers, Map.class, 933, 37980, 37986);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(signers, Map.class, 933, 37980, 37986).keySet(), Set.class, 933, 37980, 37995)) {
                        signers = CallChecker.beforeCalled(signers, Map.class, 933, 37980, 37986);
                        certificates = CallChecker.isCalled(CallChecker.isCalled(signers, Map.class, 933, 37980, 37986).keySet(), Set.class, 933, 37980, 37995).toArray(new Certificate[0]);
                        CallChecker.varAssign(certificates, "certificates", 933, 37965, 38043);
                    }
                }
            }
            if (CallChecker.beforeDeref(revisionImpl, BundleRevisionImpl.class, 935, 38063, 38074)) {
                revisionImpl = CallChecker.beforeCalled(revisionImpl, BundleRevisionImpl.class, 935, 38063, 38074);
                CallChecker.isCalled(revisionImpl, BundleRevisionImpl.class, 935, 38063, 38074).setProtectionDomain(new BundleProtectionDomain(this, bundleImpl, certificates));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context600.methodEnd();
        }
    }

    @Override
    public void start() throws BundleException {
        MethodContext _bcornu_methode_context601 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 949, 38181, 40284);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 949, 38181, 40284);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 949, 38181, 40284);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 949, 38181, 40284);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 949, 38181, 40284);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 949, 38181, 40284);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 949, 38181, 40284);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 949, 38181, 40284);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 949, 38181, 40284);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 949, 38181, 40284);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 949, 38181, 40284);
            CallChecker.varInit(this.m_registry, "m_registry", 949, 38181, 40284);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 949, 38181, 40284);
            CallChecker.varInit(this.m_nextId, "m_nextId", 949, 38181, 40284);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 949, 38181, 40284);
            CallChecker.varInit(this.m_cache, "m_cache", 949, 38181, 40284);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 949, 38181, 40284);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 949, 38181, 40284);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 949, 38181, 40284);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 949, 38181, 40284);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 949, 38181, 40284);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 949, 38181, 40284);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 949, 38181, 40284);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 949, 38181, 40284);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 949, 38181, 40284);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 949, 38181, 40284);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 949, 38181, 40284);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 949, 38181, 40284);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 949, 38181, 40284);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 949, 38181, 40284);
            CallChecker.varInit(this.m_resolver, "m_resolver", 949, 38181, 40284);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 949, 38181, 40284);
            CallChecker.varInit(this.m_configMap, "m_configMap", 949, 38181, 40284);
            CallChecker.varInit(this.m_logger, "m_logger", 949, 38181, 40284);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 949, 38181, 40284);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 949, 38181, 40284);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 949, 38181, 40284);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 949, 38181, 40284);
            int startLevel = CallChecker.varInit(((int) (FelixConstants.FRAMEWORK_DEFAULT_STARTLEVEL)), "startLevel", 951, 38710, 38770);
            acquireBundleLock(this, ((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.STARTING)) | (Bundle.ACTIVE)));
            TryContext _bcornu_try_context_157 = new TryContext(157, Felix.class);
            try {
                if (((getState()) == (Bundle.INSTALLED)) || ((getState()) == (Bundle.RESOLVED))) {
                    init();
                }
                if ((getState()) == (Bundle.STARTING)) {
                    String s = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(m_configMap, Map.class, 967, 39333, 39343)) {
                        s = ((String) (CallChecker.isCalled(m_configMap, Map.class, 967, 39333, 39343).get(Constants.FRAMEWORK_BEGINNING_STARTLEVEL)));
                        CallChecker.varAssign(s, "s", 967, 39333, 39343);
                    }
                    if (s != null) {
                        TryContext _bcornu_try_context_156 = new TryContext(156, Felix.class, "java.lang.NumberFormatException");
                        try {
                            startLevel = Integer.parseInt(s);
                            CallChecker.varAssign(startLevel, "startLevel", 972, 39511, 39543);
                        } catch (NumberFormatException ex) {
                            _bcornu_try_context_156.catchStart(156);
                            startLevel = FelixConstants.FRAMEWORK_DEFAULT_STARTLEVEL;
                            CallChecker.varAssign(startLevel, "startLevel", 976, 39666, 39722);
                        } finally {
                            _bcornu_try_context_156.finallyStart(156);
                        }
                    }
                    if (CallChecker.beforeDeref(m_fwkStartLevel, FrameworkStartLevelImpl.class, 980, 39781, 39795)) {
                        CallChecker.isCalled(m_fwkStartLevel, FrameworkStartLevelImpl.class, 980, 39781, 39795).setStartLevelAndWait(startLevel);
                    }
                    setBundleStateAndNotify(this, Bundle.ACTIVE);
                }
            } finally {
                _bcornu_try_context_157.finallyStart(157);
                releaseBundleLock(this);
            }
            fireBundleEvent(BundleEvent.STARTED, this);
            fireFrameworkEvent(FrameworkEvent.STARTED, this, null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context601.methodEnd();
        }
    }

    @Override
    public void start(int options) throws BundleException {
        MethodContext _bcornu_methode_context602 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 999, 40291, 40386);
            CallChecker.varInit(options, "options", 999, 40291, 40386);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 999, 40291, 40386);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 999, 40291, 40386);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 999, 40291, 40386);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 999, 40291, 40386);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 999, 40291, 40386);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 999, 40291, 40386);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 999, 40291, 40386);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 999, 40291, 40386);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 999, 40291, 40386);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 999, 40291, 40386);
            CallChecker.varInit(this.m_registry, "m_registry", 999, 40291, 40386);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 999, 40291, 40386);
            CallChecker.varInit(this.m_nextId, "m_nextId", 999, 40291, 40386);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 999, 40291, 40386);
            CallChecker.varInit(this.m_cache, "m_cache", 999, 40291, 40386);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 999, 40291, 40386);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 999, 40291, 40386);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 999, 40291, 40386);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 999, 40291, 40386);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 999, 40291, 40386);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 999, 40291, 40386);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 999, 40291, 40386);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 999, 40291, 40386);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 999, 40291, 40386);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 999, 40291, 40386);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 999, 40291, 40386);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 999, 40291, 40386);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 999, 40291, 40386);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 999, 40291, 40386);
            CallChecker.varInit(this.m_resolver, "m_resolver", 999, 40291, 40386);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 999, 40291, 40386);
            CallChecker.varInit(this.m_configMap, "m_configMap", 999, 40291, 40386);
            CallChecker.varInit(this.m_logger, "m_logger", 999, 40291, 40386);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 999, 40291, 40386);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 999, 40291, 40386);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 999, 40291, 40386);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 999, 40291, 40386);
            start();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context602.methodEnd();
        }
    }

    @Override
    public void stop() throws BundleException {
        MethodContext _bcornu_methode_context605 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1009, 40393, 41609);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1009, 40393, 41609);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1009, 40393, 41609);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1009, 40393, 41609);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1009, 40393, 41609);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1009, 40393, 41609);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1009, 40393, 41609);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1009, 40393, 41609);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1009, 40393, 41609);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1009, 40393, 41609);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1009, 40393, 41609);
            CallChecker.varInit(this.m_registry, "m_registry", 1009, 40393, 41609);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1009, 40393, 41609);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1009, 40393, 41609);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1009, 40393, 41609);
            CallChecker.varInit(this.m_cache, "m_cache", 1009, 40393, 41609);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1009, 40393, 41609);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1009, 40393, 41609);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1009, 40393, 41609);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1009, 40393, 41609);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1009, 40393, 41609);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1009, 40393, 41609);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1009, 40393, 41609);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1009, 40393, 41609);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1009, 40393, 41609);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1009, 40393, 41609);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1009, 40393, 41609);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1009, 40393, 41609);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1009, 40393, 41609);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1009, 40393, 41609);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1009, 40393, 41609);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1009, 40393, 41609);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1009, 40393, 41609);
            CallChecker.varInit(this.m_logger, "m_logger", 1009, 40393, 41609);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1009, 40393, 41609);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1009, 40393, 41609);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1009, 40393, 41609);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1009, 40393, 41609);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 1011, 40629, 40668);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.EXECUTE));
            }
            if (((getState()) & ((Bundle.INSTALLED) | (Bundle.RESOLVED))) == 0) {
                if (CallChecker.beforeDeref(new Thread(new Runnable() {
                    public void run() {
                        MethodContext _bcornu_methode_context603 = new MethodContext(void.class);
                        try {
                            CallChecker.varInit(this, "this", 1024, 41103, 41552);
                            TryContext _bcornu_try_context_158 = new TryContext(158, Felix.class, "org.osgi.framework.BundleException");
                            try {
                                stopBundle(Felix.this, true);
                            } catch (BundleException ex) {
                                _bcornu_try_context_158.catchStart(158);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 1032, 41354, 41361)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 1032, 41354, 41361).log(Logger.LOG_ERROR, "Exception trying to stop framework.", ex);
                                }
                            } finally {
                                _bcornu_try_context_158.finallyStart(158);
                            }
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context603.methodEnd();
                        }
                    }
                }, "FelixShutdown"), Thread.class, 1023, 41059, 41584)) {
                    CallChecker.isCalled(new Thread(new Runnable() {
                        public void run() {
                            MethodContext _bcornu_methode_context604 = new MethodContext(void.class);
                            try {
                                CallChecker.varInit(this, "this", 1024, 41103, 41552);
                                TryContext _bcornu_try_context_159 = new TryContext(159, Felix.class, "org.osgi.framework.BundleException");
                                try {
                                    stopBundle(Felix.this, true);
                                } catch (BundleException ex) {
                                    _bcornu_try_context_159.catchStart(159);
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1032, 41354, 41361)) {
                                        CallChecker.isCalled(m_logger, Logger.class, 1032, 41354, 41361).log(Logger.LOG_ERROR, "Exception trying to stop framework.", ex);
                                    }
                                } finally {
                                    _bcornu_try_context_159.finallyStart(159);
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                _bcornu_return_t.getDecision().getValue();
                                return ;
                            } finally {
                                _bcornu_methode_context604.methodEnd();
                            }
                        }
                    }, "FelixShutdown"), Thread.class, 1023, 41059, 41584).start();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context605.methodEnd();
        }
    }

    @Override
    public void stop(int options) throws BundleException {
        MethodContext _bcornu_methode_context606 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1043, 41616, 41709);
            CallChecker.varInit(options, "options", 1043, 41616, 41709);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1043, 41616, 41709);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1043, 41616, 41709);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1043, 41616, 41709);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1043, 41616, 41709);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1043, 41616, 41709);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1043, 41616, 41709);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1043, 41616, 41709);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1043, 41616, 41709);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1043, 41616, 41709);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1043, 41616, 41709);
            CallChecker.varInit(this.m_registry, "m_registry", 1043, 41616, 41709);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1043, 41616, 41709);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1043, 41616, 41709);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1043, 41616, 41709);
            CallChecker.varInit(this.m_cache, "m_cache", 1043, 41616, 41709);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1043, 41616, 41709);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1043, 41616, 41709);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1043, 41616, 41709);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1043, 41616, 41709);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1043, 41616, 41709);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1043, 41616, 41709);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1043, 41616, 41709);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1043, 41616, 41709);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1043, 41616, 41709);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1043, 41616, 41709);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1043, 41616, 41709);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1043, 41616, 41709);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1043, 41616, 41709);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1043, 41616, 41709);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1043, 41616, 41709);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1043, 41616, 41709);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1043, 41616, 41709);
            CallChecker.varInit(this.m_logger, "m_logger", 1043, 41616, 41709);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1043, 41616, 41709);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1043, 41616, 41709);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1043, 41616, 41709);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1043, 41616, 41709);
            stop();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context606.methodEnd();
        }
    }

    public FrameworkEvent waitForStop(long timeout) throws InterruptedException {
        MethodContext _bcornu_methode_context607 = new MethodContext(FrameworkEvent.class);
        try {
            CallChecker.varInit(this, "this", 1054, 41716, 42928);
            CallChecker.varInit(timeout, "timeout", 1054, 41716, 42928);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1054, 41716, 42928);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1054, 41716, 42928);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1054, 41716, 42928);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1054, 41716, 42928);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1054, 41716, 42928);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1054, 41716, 42928);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1054, 41716, 42928);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1054, 41716, 42928);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1054, 41716, 42928);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1054, 41716, 42928);
            CallChecker.varInit(this.m_registry, "m_registry", 1054, 41716, 42928);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1054, 41716, 42928);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1054, 41716, 42928);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1054, 41716, 42928);
            CallChecker.varInit(this.m_cache, "m_cache", 1054, 41716, 42928);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1054, 41716, 42928);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1054, 41716, 42928);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1054, 41716, 42928);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1054, 41716, 42928);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1054, 41716, 42928);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1054, 41716, 42928);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1054, 41716, 42928);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1054, 41716, 42928);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1054, 41716, 42928);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1054, 41716, 42928);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1054, 41716, 42928);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1054, 41716, 42928);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1054, 41716, 42928);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1054, 41716, 42928);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1054, 41716, 42928);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1054, 41716, 42928);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1054, 41716, 42928);
            CallChecker.varInit(this.m_logger, "m_logger", 1054, 41716, 42928);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1054, 41716, 42928);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1054, 41716, 42928);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1054, 41716, 42928);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1054, 41716, 42928);
            if (timeout < 0) {
                throw new IllegalArgumentException("Timeout cannot be negative.");
            }
            ThreadGate gate = CallChecker.varInit(m_shutdownGate, "gate", 1064, 42343, 42375);
            boolean open = CallChecker.varInit(((boolean) (false)), "open", 1065, 42385, 42405);
            if (gate != null) {
                open = gate.await(timeout);
                CallChecker.varAssign(open, "open", 1068, 42455, 42481);
            }
            FrameworkEvent event = CallChecker.init(FrameworkEvent.class);
            if (CallChecker.beforeDeref(gate, ThreadGate.class, 1072, 42545, 42548)) {
                gate = CallChecker.beforeCalled(gate, ThreadGate.class, 1072, 42545, 42548);
                if (open && ((CallChecker.isCalled(gate, ThreadGate.class, 1072, 42545, 42548).getMessage()) != null)) {
                    if (CallChecker.beforeDeref(gate, ThreadGate.class, 1074, 42620, 42623)) {
                        gate = CallChecker.beforeCalled(gate, ThreadGate.class, 1074, 42620, 42623);
                        event = ((FrameworkEvent) (CallChecker.isCalled(gate, ThreadGate.class, 1074, 42620, 42623).getMessage()));
                        CallChecker.varAssign(event, "event", 1074, 42595, 42637);
                    }
                }else
                    if ((!open) && (gate != null)) {
                        event = new FrameworkEvent(FrameworkEvent.WAIT_TIMEDOUT, this, null);
                        CallChecker.varAssign(event, "event", 1078, 42713, 42781);
                    }else {
                        event = new FrameworkEvent(FrameworkEvent.STOPPED, this, null);
                        CallChecker.varAssign(event, "event", 1082, 42828, 42890);
                    }
                
            }
            return event;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FrameworkEvent) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context607.methodEnd();
        }
    }

    @Override
    public void uninstall() throws BundleException {
        MethodContext _bcornu_methode_context608 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1088, 42935, 43080);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1088, 42935, 43080);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1088, 42935, 43080);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1088, 42935, 43080);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1088, 42935, 43080);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1088, 42935, 43080);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1088, 42935, 43080);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1088, 42935, 43080);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1088, 42935, 43080);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1088, 42935, 43080);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1088, 42935, 43080);
            CallChecker.varInit(this.m_registry, "m_registry", 1088, 42935, 43080);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1088, 42935, 43080);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1088, 42935, 43080);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1088, 42935, 43080);
            CallChecker.varInit(this.m_cache, "m_cache", 1088, 42935, 43080);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1088, 42935, 43080);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1088, 42935, 43080);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1088, 42935, 43080);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1088, 42935, 43080);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1088, 42935, 43080);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1088, 42935, 43080);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1088, 42935, 43080);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1088, 42935, 43080);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1088, 42935, 43080);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1088, 42935, 43080);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1088, 42935, 43080);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1088, 42935, 43080);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1088, 42935, 43080);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1088, 42935, 43080);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1088, 42935, 43080);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1088, 42935, 43080);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1088, 42935, 43080);
            CallChecker.varInit(this.m_logger, "m_logger", 1088, 42935, 43080);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1088, 42935, 43080);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1088, 42935, 43080);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1088, 42935, 43080);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1088, 42935, 43080);
            throw new BundleException("Cannot uninstall the system bundle.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context608.methodEnd();
        }
    }

    @Override
    public void update() throws BundleException {
        MethodContext _bcornu_methode_context609 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1094, 43087, 43177);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1094, 43087, 43177);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1094, 43087, 43177);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1094, 43087, 43177);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1094, 43087, 43177);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1094, 43087, 43177);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1094, 43087, 43177);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1094, 43087, 43177);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1094, 43087, 43177);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1094, 43087, 43177);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1094, 43087, 43177);
            CallChecker.varInit(this.m_registry, "m_registry", 1094, 43087, 43177);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1094, 43087, 43177);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1094, 43087, 43177);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1094, 43087, 43177);
            CallChecker.varInit(this.m_cache, "m_cache", 1094, 43087, 43177);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1094, 43087, 43177);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1094, 43087, 43177);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1094, 43087, 43177);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1094, 43087, 43177);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1094, 43087, 43177);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1094, 43087, 43177);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1094, 43087, 43177);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1094, 43087, 43177);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1094, 43087, 43177);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1094, 43087, 43177);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1094, 43087, 43177);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1094, 43087, 43177);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1094, 43087, 43177);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1094, 43087, 43177);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1094, 43087, 43177);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1094, 43087, 43177);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1094, 43087, 43177);
            CallChecker.varInit(this.m_logger, "m_logger", 1094, 43087, 43177);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1094, 43087, 43177);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1094, 43087, 43177);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1094, 43087, 43177);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1094, 43087, 43177);
            update(null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context609.methodEnd();
        }
    }

    @Override
    public void update(InputStream is) throws BundleException {
        MethodContext _bcornu_methode_context612 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1100, 43184, 46097);
            CallChecker.varInit(is, "is", 1100, 43184, 46097);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1100, 43184, 46097);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1100, 43184, 46097);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1100, 43184, 46097);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1100, 43184, 46097);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1100, 43184, 46097);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1100, 43184, 46097);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1100, 43184, 46097);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1100, 43184, 46097);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1100, 43184, 46097);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1100, 43184, 46097);
            CallChecker.varInit(this.m_registry, "m_registry", 1100, 43184, 46097);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1100, 43184, 46097);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1100, 43184, 46097);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1100, 43184, 46097);
            CallChecker.varInit(this.m_cache, "m_cache", 1100, 43184, 46097);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1100, 43184, 46097);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1100, 43184, 46097);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1100, 43184, 46097);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1100, 43184, 46097);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1100, 43184, 46097);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1100, 43184, 46097);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1100, 43184, 46097);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1100, 43184, 46097);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1100, 43184, 46097);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1100, 43184, 46097);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1100, 43184, 46097);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1100, 43184, 46097);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1100, 43184, 46097);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1100, 43184, 46097);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1100, 43184, 46097);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1100, 43184, 46097);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1100, 43184, 46097);
            CallChecker.varInit(this.m_logger, "m_logger", 1100, 43184, 46097);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1100, 43184, 46097);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1100, 43184, 46097);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1100, 43184, 46097);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1100, 43184, 46097);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 1102, 43270, 43309);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.EXECUTE));
            }
            TryContext _bcornu_try_context_160 = new TryContext(160, Felix.class, "java.io.IOException");
            try {
                if (is != null)
                    is.close();
                
            } catch (IOException ex) {
                _bcornu_try_context_160.catchStart(160);
                if (CallChecker.beforeDeref(m_logger, Logger.class, 1117, 43652, 43659)) {
                    CallChecker.isCalled(m_logger, Logger.class, 1117, 43652, 43659).log(Logger.LOG_WARNING, "Exception closing input stream.", ex);
                }
            } finally {
                _bcornu_try_context_160.finallyStart(160);
            }
            if (CallChecker.beforeDeref(new Thread(new Runnable() {
                public void run() {
                    MethodContext _bcornu_methode_context610 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 1122, 43856, 46071);
                        TryContext _bcornu_try_context_164 = new TryContext(164, Felix.class, "java.lang.Exception");
                        try {
                            acquireBundleLock(Felix.this, ((Bundle.STARTING) | (Bundle.ACTIVE)));
                            if (CallChecker.beforeDeref(m_shutdownGate, ThreadGate.class, 1129, 44167, 44180)) {
                                m_shutdownGate = CallChecker.beforeCalled(m_shutdownGate, ThreadGate.class, 1129, 44167, 44180);
                                CallChecker.isCalled(m_shutdownGate, ThreadGate.class, 1129, 44167, 44180).setMessage(new FrameworkEvent(FrameworkEvent.STOPPED_UPDATE, Felix.this, null));
                            }
                            int oldState = CallChecker.varInit(((int) (Felix.this.getState())), "oldState", 1132, 44376, 44412);
                            TryContext _bcornu_try_context_161 = new TryContext(161, Felix.class, "org.osgi.framework.BundleException");
                            try {
                                stop();
                            } catch (BundleException ex) {
                                _bcornu_try_context_161.catchStart(161);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 1139, 44607, 44614)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 1139, 44607, 44614).log(Logger.LOG_WARNING, "Exception stopping framework.", ex);
                                }
                            } finally {
                                _bcornu_try_context_161.finallyStart(161);
                                releaseBundleLock(Felix.this);
                            }
                            TryContext _bcornu_try_context_162 = new TryContext(162, Felix.class, "java.lang.InterruptedException");
                            try {
                                waitForStop(0);
                            } catch (InterruptedException ex) {
                                _bcornu_try_context_162.catchStart(162);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 1153, 45093, 45100)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 1153, 45093, 45100).log(Logger.LOG_WARNING, "Did not wait for framework to stop.", ex);
                                }
                            } finally {
                                _bcornu_try_context_162.finallyStart(162);
                            }
                            TryContext _bcornu_try_context_163 = new TryContext(163, Felix.class, "org.osgi.framework.BundleException");
                            try {
                                switch (oldState) {
                                    case Bundle.STARTING :
                                        init();
                                        break;
                                    case Bundle.ACTIVE :
                                        start();
                                        break;
                                }
                            } catch (BundleException ex) {
                                _bcornu_try_context_163.catchStart(163);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 1171, 45779, 45786)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 1171, 45779, 45786).log(Logger.LOG_WARNING, "Exception restarting framework.", ex);
                                }
                            } finally {
                                _bcornu_try_context_163.finallyStart(163);
                            }
                        } catch (Exception ex) {
                            _bcornu_try_context_164.catchStart(164);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 1176, 45967, 45974)) {
                                CallChecker.isCalled(m_logger, Logger.class, 1176, 45967, 45974).log(Logger.LOG_WARNING, "Cannot update an inactive framework.");
                            }
                        } finally {
                            _bcornu_try_context_164.finallyStart(164);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context610.methodEnd();
                    }
                }
            }), Thread.class, 1121, 43816, 46082)) {
                CallChecker.isCalled(new Thread(new Runnable() {
                    public void run() {
                        MethodContext _bcornu_methode_context611 = new MethodContext(void.class);
                        try {
                            CallChecker.varInit(this, "this", 1122, 43856, 46071);
                            TryContext _bcornu_try_context_168 = new TryContext(168, Felix.class, "java.lang.Exception");
                            try {
                                acquireBundleLock(Felix.this, ((Bundle.STARTING) | (Bundle.ACTIVE)));
                                if (CallChecker.beforeDeref(m_shutdownGate, ThreadGate.class, 1129, 44167, 44180)) {
                                    m_shutdownGate = CallChecker.beforeCalled(m_shutdownGate, ThreadGate.class, 1129, 44167, 44180);
                                    CallChecker.isCalled(m_shutdownGate, ThreadGate.class, 1129, 44167, 44180).setMessage(new FrameworkEvent(FrameworkEvent.STOPPED_UPDATE, Felix.this, null));
                                }
                                int oldState = CallChecker.varInit(((int) (Felix.this.getState())), "oldState", 1132, 44376, 44412);
                                TryContext _bcornu_try_context_165 = new TryContext(165, Felix.class, "org.osgi.framework.BundleException");
                                try {
                                    stop();
                                } catch (BundleException ex) {
                                    _bcornu_try_context_165.catchStart(165);
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1139, 44607, 44614)) {
                                        CallChecker.isCalled(m_logger, Logger.class, 1139, 44607, 44614).log(Logger.LOG_WARNING, "Exception stopping framework.", ex);
                                    }
                                } finally {
                                    _bcornu_try_context_165.finallyStart(165);
                                    releaseBundleLock(Felix.this);
                                }
                                TryContext _bcornu_try_context_166 = new TryContext(166, Felix.class, "java.lang.InterruptedException");
                                try {
                                    waitForStop(0);
                                } catch (InterruptedException ex) {
                                    _bcornu_try_context_166.catchStart(166);
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1153, 45093, 45100)) {
                                        CallChecker.isCalled(m_logger, Logger.class, 1153, 45093, 45100).log(Logger.LOG_WARNING, "Did not wait for framework to stop.", ex);
                                    }
                                } finally {
                                    _bcornu_try_context_166.finallyStart(166);
                                }
                                TryContext _bcornu_try_context_167 = new TryContext(167, Felix.class, "org.osgi.framework.BundleException");
                                try {
                                    switch (oldState) {
                                        case Bundle.STARTING :
                                            init();
                                            break;
                                        case Bundle.ACTIVE :
                                            start();
                                            break;
                                    }
                                } catch (BundleException ex) {
                                    _bcornu_try_context_167.catchStart(167);
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1171, 45779, 45786)) {
                                        CallChecker.isCalled(m_logger, Logger.class, 1171, 45779, 45786).log(Logger.LOG_WARNING, "Exception restarting framework.", ex);
                                    }
                                } finally {
                                    _bcornu_try_context_167.finallyStart(167);
                                }
                            } catch (Exception ex) {
                                _bcornu_try_context_168.catchStart(168);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 1176, 45967, 45974)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 1176, 45967, 45974).log(Logger.LOG_WARNING, "Cannot update an inactive framework.");
                                }
                            } finally {
                                _bcornu_try_context_168.finallyStart(168);
                            }
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context611.methodEnd();
                        }
                    }
                }), Thread.class, 1121, 43816, 46082).start();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context612.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context613 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1183, 46104, 46215);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1183, 46104, 46215);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1183, 46104, 46215);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1183, 46104, 46215);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1183, 46104, 46215);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1183, 46104, 46215);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1183, 46104, 46215);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1183, 46104, 46215);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1183, 46104, 46215);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1183, 46104, 46215);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1183, 46104, 46215);
            CallChecker.varInit(this.m_registry, "m_registry", 1183, 46104, 46215);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1183, 46104, 46215);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1183, 46104, 46215);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1183, 46104, 46215);
            CallChecker.varInit(this.m_cache, "m_cache", 1183, 46104, 46215);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1183, 46104, 46215);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1183, 46104, 46215);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1183, 46104, 46215);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1183, 46104, 46215);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1183, 46104, 46215);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1183, 46104, 46215);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1183, 46104, 46215);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1183, 46104, 46215);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1183, 46104, 46215);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1183, 46104, 46215);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1183, 46104, 46215);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1183, 46104, 46215);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1183, 46104, 46215);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1183, 46104, 46215);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1183, 46104, 46215);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1183, 46104, 46215);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1183, 46104, 46215);
            CallChecker.varInit(this.m_logger, "m_logger", 1183, 46104, 46215);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1183, 46104, 46215);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1183, 46104, 46215);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1183, 46104, 46215);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1183, 46104, 46215);
            return (((getSymbolicName()) + " [") + (getBundleId())) + "]";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context613.methodEnd();
        }
    }

    int getActiveStartLevel() {
        MethodContext _bcornu_methode_context614 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1193, 46222, 46494);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1193, 46222, 46494);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1193, 46222, 46494);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1193, 46222, 46494);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1193, 46222, 46494);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1193, 46222, 46494);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1193, 46222, 46494);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1193, 46222, 46494);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1193, 46222, 46494);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1193, 46222, 46494);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1193, 46222, 46494);
            CallChecker.varInit(this.m_registry, "m_registry", 1193, 46222, 46494);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1193, 46222, 46494);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1193, 46222, 46494);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1193, 46222, 46494);
            CallChecker.varInit(this.m_cache, "m_cache", 1193, 46222, 46494);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1193, 46222, 46494);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1193, 46222, 46494);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1193, 46222, 46494);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1193, 46222, 46494);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1193, 46222, 46494);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1193, 46222, 46494);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1193, 46222, 46494);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1193, 46222, 46494);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1193, 46222, 46494);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1193, 46222, 46494);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1193, 46222, 46494);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1193, 46222, 46494);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1193, 46222, 46494);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1193, 46222, 46494);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1193, 46222, 46494);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1193, 46222, 46494);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1193, 46222, 46494);
            CallChecker.varInit(this.m_logger, "m_logger", 1193, 46222, 46494);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1193, 46222, 46494);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1193, 46222, 46494);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1193, 46222, 46494);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1193, 46222, 46494);
            return m_activeStartLevel;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context614.methodEnd();
        }
    }

    void setActiveStartLevel(int requestedLevel, FrameworkListener[] listeners) {
        MethodContext _bcornu_methode_context615 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1208, 46501, 57289);
            CallChecker.varInit(listeners, "listeners", 1208, 46501, 57289);
            CallChecker.varInit(requestedLevel, "requestedLevel", 1208, 46501, 57289);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1208, 46501, 57289);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1208, 46501, 57289);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1208, 46501, 57289);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1208, 46501, 57289);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1208, 46501, 57289);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1208, 46501, 57289);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1208, 46501, 57289);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1208, 46501, 57289);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1208, 46501, 57289);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1208, 46501, 57289);
            CallChecker.varInit(this.m_registry, "m_registry", 1208, 46501, 57289);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1208, 46501, 57289);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1208, 46501, 57289);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1208, 46501, 57289);
            CallChecker.varInit(this.m_cache, "m_cache", 1208, 46501, 57289);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1208, 46501, 57289);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1208, 46501, 57289);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1208, 46501, 57289);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1208, 46501, 57289);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1208, 46501, 57289);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1208, 46501, 57289);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1208, 46501, 57289);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1208, 46501, 57289);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1208, 46501, 57289);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1208, 46501, 57289);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1208, 46501, 57289);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1208, 46501, 57289);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1208, 46501, 57289);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1208, 46501, 57289);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1208, 46501, 57289);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1208, 46501, 57289);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1208, 46501, 57289);
            CallChecker.varInit(this.m_logger, "m_logger", 1208, 46501, 57289);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1208, 46501, 57289);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1208, 46501, 57289);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1208, 46501, 57289);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1208, 46501, 57289);
            Bundle[] bundles = CallChecker.init(Bundle[].class);
            m_targetStartLevel = requestedLevel;
            CallChecker.varAssign(this.m_targetStartLevel, "this.m_targetStartLevel", 1215, 47342, 47377);
            if ((m_targetStartLevel) != (m_activeStartLevel)) {
                boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 1240, 48742, 48778);
                if (!locked) {
                    throw new IllegalStateException("Unable to acquire global lock to create bundle snapshot.");
                }
                boolean bundlesRemaining = CallChecker.init(boolean.class);
                TryContext _bcornu_try_context_169 = new TryContext(169, Felix.class);
                try {
                    synchronized(m_startLevelBundles) {
                        bundles = getBundles();
                        CallChecker.varAssign(bundles, "bundles", 1260, 49638, 49660);
                        if (CallChecker.beforeDeref(bundles, void.class, 1261, 49698, 49704)) {
                            for (Bundle b : bundles) {
                                if (CallChecker.beforeDeref(b, Bundle.class, 1266, 49921, 49921)) {
                                    if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1263, 49753, 49771)) {
                                        CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1263, 49753, 49771).add(new Felix.StartLevelTuple(((BundleImpl) (b)), CallChecker.isCalled(((BundleImpl) (b)), BundleImpl.class, 1266, 49921, 49921).getStartLevel(getInitialBundleStartLevel())));
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1269, 50070, 50088)) {
                            bundlesRemaining = !(CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1269, 50070, 50088).isEmpty());
                            CallChecker.varAssign(bundlesRemaining, "bundlesRemaining", 1269, 50050, 50099);
                        }
                    }
                } finally {
                    _bcornu_try_context_169.finallyStart(169);
                    releaseGlobalLock();
                }
                boolean isLowering = CallChecker.varInit(((boolean) ((this.m_targetStartLevel) < (this.m_activeStartLevel))), "isLowering", 1279, 50325, 50387);
                int low = CallChecker.init(int.class);
                if (isLowering) {
                    low = (m_targetStartLevel) + 1;
                    CallChecker.varAssign(low, "low", 1281, 50474, 50535);
                }else {
                    low = (m_activeStartLevel) + 1;
                    CallChecker.varAssign(low, "low", 1281, 50474, 50535);
                }
                int high = CallChecker.init(int.class);
                if (isLowering) {
                    high = m_activeStartLevel;
                    CallChecker.varAssign(high, "high", 1282, 50561, 50614);
                }else {
                    high = m_targetStartLevel;
                    CallChecker.varAssign(high, "high", 1282, 50561, 50614);
                }
                if (isLowering) {
                    m_activeStartLevel = high;
                    CallChecker.varAssign(this.m_activeStartLevel, "this.m_activeStartLevel", 1283, 50629, 50675);
                }else {
                    m_activeStartLevel = low;
                    CallChecker.varAssign(this.m_activeStartLevel, "this.m_activeStartLevel", 1283, 50629, 50675);
                }
                while (bundlesRemaining) {
                    Felix.StartLevelTuple tuple = CallChecker.init(Felix.StartLevelTuple.class);
                    synchronized(m_startLevelBundles) {
                        if (isLowering) {
                            if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1299, 51373, 51391)) {
                                tuple = CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1299, 51373, 51391).last();
                                CallChecker.varAssign(tuple, "tuple", 1299, 51365, 51399);
                            }
                        }else {
                            if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1303, 51502, 51520)) {
                                tuple = CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1303, 51502, 51520).first();
                                CallChecker.varAssign(tuple, "tuple", 1303, 51494, 51529);
                            }
                        }
                        if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1306, 51579, 51583)) {
                            if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1306, 51605, 51609)) {
                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1306, 51579, 51583);
                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1306, 51605, 51609);
                                if (((CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1306, 51579, 51583).m_level) >= low) && ((CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1306, 51605, 51609).m_level) <= high)) {
                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1308, 51696, 51700)) {
                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1308, 51696, 51700);
                                        m_activeStartLevel = CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1308, 51696, 51700).m_level;
                                        CallChecker.varAssign(this.m_activeStartLevel, "this.m_activeStartLevel", 1308, 51675, 51709);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1315, 51963, 51967)) {
                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1315, 51963, 51967);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1315, 51963, 51967).m_bundle, BundleImpl.class, 1315, 51963, 51976)) {
                            tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1315, 51963, 51967);
                            if ((CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1315, 51963, 51967).m_bundle, BundleImpl.class, 1315, 51963, 51976).getBundleId()) != 0) {
                                TryContext _bcornu_try_context_170 = new TryContext(170, Felix.class, "java.lang.IllegalStateException");
                                try {
                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1320, 52152, 52156)) {
                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1320, 52152, 52156);
                                        acquireBundleLock(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1320, 52152, 52156).m_bundle, (((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.ACTIVE)) | (Bundle.STARTING)) | (Bundle.STOPPING)));
                                    }
                                } catch (IllegalStateException ex) {
                                    _bcornu_try_context_170.catchStart(170);
                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1327, 52508, 52512)) {
                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1327, 52508, 52512);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1327, 52508, 52512).m_bundle, BundleImpl.class, 1327, 52508, 52521)) {
                                            tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1327, 52508, 52512);
                                            if ((CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1327, 52508, 52512).m_bundle, BundleImpl.class, 1327, 52508, 52521).getState()) != (Bundle.UNINSTALLED)) {
                                                if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1329, 52652, 52656)) {
                                                    tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1329, 52652, 52656);
                                                    fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1329, 52652, 52656).m_bundle, ex);
                                                }
                                                if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1330, 52714, 52718)) {
                                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1332, 52831, 52835)) {
                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1332, 52831, 52835);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1332, 52831, 52835).m_bundle, BundleImpl.class, 1332, 52831, 52844)) {
                                                            if (CallChecker.beforeDeref(m_logger, Logger.class, 1330, 52701, 52708)) {
                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1330, 52714, 52718);
                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1332, 52831, 52835);
                                                                CallChecker.isCalled(m_logger, Logger.class, 1330, 52701, 52708).log(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1330, 52714, 52718).m_bundle, Logger.LOG_ERROR, ("Error locking " + (CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1332, 52831, 52835).m_bundle, BundleImpl.class, 1332, 52831, 52844)._getLocation())), ex);
                                                            }
                                                        }
                                                    }
                                                }
                                            }else {
                                                synchronized(m_startLevelBundles) {
                                                    if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1338, 53073, 53091)) {
                                                        CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1338, 53073, 53091).remove(tuple);
                                                    }
                                                    if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1339, 53160, 53178)) {
                                                        bundlesRemaining = !(CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1339, 53160, 53178).isEmpty());
                                                        CallChecker.varAssign(bundlesRemaining, "bundlesRemaining", 1339, 53140, 53189);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    continue;
                                } finally {
                                    _bcornu_try_context_170.finallyStart(170);
                                }
                                TryContext _bcornu_try_context_173 = new TryContext(173, Felix.class);
                                try {
                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1354, 53866, 53870)) {
                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1354, 53866, 53870);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1354, 53866, 53870).m_bundle, BundleImpl.class, 1354, 53866, 53879)) {
                                            if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1355, 53956, 53960)) {
                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1355, 53956, 53960);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1355, 53956, 53960).m_bundle, BundleImpl.class, 1355, 53956, 53969)) {
                                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1356, 54049, 54053)) {
                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1354, 53866, 53870);
                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1355, 53956, 53960);
                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1356, 54049, 54053);
                                                        if ((!isLowering) && ((((CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1354, 53866, 53870).m_bundle, BundleImpl.class, 1354, 53866, 53879).getPersistentState()) == (Bundle.ACTIVE)) || ((CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1355, 53956, 53960).m_bundle, BundleImpl.class, 1355, 53956, 53969).getPersistentState()) == (Bundle.STARTING))) && ((CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1356, 54049, 54053).m_level) == (m_activeStartLevel)))) {
                                                            TryContext _bcornu_try_context_171 = new TryContext(171, Felix.class, "java.lang.Throwable");
                                                            try {
                                                                int options = CallChecker.varInit(((int) (Bundle.START_TRANSIENT)), "options", 1361, 54260, 54296);
                                                                if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1362, 54341, 54345)) {
                                                                    tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1362, 54341, 54345);
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1362, 54341, 54345).m_bundle, BundleImpl.class, 1362, 54341, 54354)) {
                                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1362, 54341, 54345);
                                                                        if ((CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1362, 54341, 54345).m_bundle, BundleImpl.class, 1362, 54341, 54354).getPersistentState()) == (Bundle.STARTING)) {
                                                                            options = options | (Bundle.START_ACTIVATION_POLICY);
                                                                            CallChecker.varAssign(options, "options", 1362, 54330, 54521);
                                                                        }else {
                                                                            options = options;
                                                                            CallChecker.varAssign(options, "options", 1362, 54330, 54521);
                                                                        }
                                                                    }
                                                                }
                                                                if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1365, 54567, 54571)) {
                                                                    tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1365, 54567, 54571);
                                                                    startBundle(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1365, 54567, 54571).m_bundle, options);
                                                                }
                                                            } catch (Throwable th) {
                                                                _bcornu_try_context_171.catchStart(171);
                                                                if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1369, 54775, 54779)) {
                                                                    tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1369, 54775, 54779);
                                                                    fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1369, 54775, 54779).m_bundle, th);
                                                                }
                                                                if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1370, 54841, 54845)) {
                                                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1372, 54967, 54971)) {
                                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1372, 54967, 54971);
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1372, 54967, 54971).m_bundle, BundleImpl.class, 1372, 54967, 54980)) {
                                                                            if (CallChecker.beforeDeref(m_logger, Logger.class, 1370, 54828, 54835)) {
                                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1370, 54841, 54845);
                                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1372, 54967, 54971);
                                                                                CallChecker.isCalled(m_logger, Logger.class, 1370, 54828, 54835).log(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1370, 54841, 54845).m_bundle, Logger.LOG_ERROR, ("Error starting " + (CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1372, 54967, 54971).m_bundle, BundleImpl.class, 1372, 54967, 54980)._getLocation())), th);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } finally {
                                                                _bcornu_try_context_171.finallyStart(171);
                                                            }
                                                        }else
                                                            if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1377, 55194, 55198)) {
                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1377, 55194, 55198);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1377, 55194, 55198).m_bundle, BundleImpl.class, 1377, 55194, 55207)) {
                                                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1378, 55274, 55278)) {
                                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1378, 55274, 55278);
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1378, 55274, 55278).m_bundle, BundleImpl.class, 1378, 55274, 55287)) {
                                                                            if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1379, 55357, 55361)) {
                                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1377, 55194, 55198);
                                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1378, 55274, 55278);
                                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1379, 55357, 55361);
                                                                                if (isLowering && ((((CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1377, 55194, 55198).m_bundle, BundleImpl.class, 1377, 55194, 55207).getState()) == (Bundle.ACTIVE)) || ((CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1378, 55274, 55278).m_bundle, BundleImpl.class, 1378, 55274, 55287).getState()) == (Bundle.STARTING))) && ((CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1379, 55357, 55361).m_level) == (m_activeStartLevel)))) {
                                                                                    TryContext _bcornu_try_context_172 = new TryContext(172, Felix.class, "java.lang.Throwable");
                                                                                    try {
                                                                                        if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1383, 55527, 55531)) {
                                                                                            tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1383, 55527, 55531);
                                                                                            stopBundle(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1383, 55527, 55531).m_bundle, false);
                                                                                        }
                                                                                    } catch (Throwable th) {
                                                                                        _bcornu_try_context_172.catchStart(172);
                                                                                        if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1387, 55733, 55737)) {
                                                                                            tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1387, 55733, 55737);
                                                                                            fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1387, 55733, 55737).m_bundle, th);
                                                                                        }
                                                                                        if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1388, 55799, 55803)) {
                                                                                            if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1390, 55925, 55929)) {
                                                                                                tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1390, 55925, 55929);
                                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1390, 55925, 55929).m_bundle, BundleImpl.class, 1390, 55925, 55938)) {
                                                                                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1388, 55786, 55793)) {
                                                                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1388, 55799, 55803);
                                                                                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1390, 55925, 55929);
                                                                                                        CallChecker.isCalled(m_logger, Logger.class, 1388, 55786, 55793).log(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1388, 55799, 55803).m_bundle, Logger.LOG_ERROR, ("Error stopping " + (CallChecker.isCalled(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1390, 55925, 55929).m_bundle, BundleImpl.class, 1390, 55925, 55938)._getLocation())), th);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } finally {
                                                                                        _bcornu_try_context_172.finallyStart(172);
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
                                } finally {
                                    _bcornu_try_context_173.finallyStart(173);
                                    if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 1397, 56186, 56190)) {
                                        tuple = CallChecker.beforeCalled(tuple, Felix.StartLevelTuple.class, 1397, 56186, 56190);
                                        releaseBundleLock(CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 1397, 56186, 56190).m_bundle);
                                    }
                                }
                            }
                        }
                    }
                    synchronized(m_startLevelBundles) {
                        if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1403, 56333, 56351)) {
                            CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1403, 56333, 56351).remove(tuple);
                        }
                        if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 1404, 56408, 56426)) {
                            bundlesRemaining = !(CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 1404, 56408, 56426).isEmpty());
                            CallChecker.varAssign(bundlesRemaining, "bundlesRemaining", 1404, 56388, 56437);
                        }
                    }
                } 
                m_activeStartLevel = m_targetStartLevel;
                CallChecker.varAssign(this.m_activeStartLevel, "this.m_activeStartLevel", 1408, 56484, 56523);
            }
            if ((getState()) == (Bundle.ACTIVE)) {
                fireFrameworkEvent(FrameworkEvent.STARTLEVEL_CHANGED, this, null);
                if (listeners != null) {
                    FrameworkEvent event = CallChecker.varInit(new FrameworkEvent(FrameworkEvent.STARTLEVEL_CHANGED, this, null), "event", 1417, 56732, 56841);
                    for (FrameworkListener l : listeners) {
                        TryContext _bcornu_try_context_174 = new TryContext(174, Felix.class, "java.lang.Throwable");
                        try {
                            if (CallChecker.beforeDeref(l, FrameworkListener.class, 1423, 56985, 56985)) {
                                CallChecker.isCalled(l, FrameworkListener.class, 1423, 56985, 56985).frameworkEvent(event);
                            }
                        } catch (Throwable th) {
                            _bcornu_try_context_174.catchStart(174);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 1427, 57119, 57126)) {
                                CallChecker.isCalled(m_logger, Logger.class, 1427, 57119, 57126).log(Logger.LOG_ERROR, "Framework listener delivery error.", th);
                            }
                        } finally {
                            _bcornu_try_context_174.finallyStart(174);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context615.methodEnd();
        }
    }

    int getInitialBundleStartLevel() {
        MethodContext _bcornu_methode_context616 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1441, 57296, 58078);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1441, 57296, 58078);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1441, 57296, 58078);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1441, 57296, 58078);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1441, 57296, 58078);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1441, 57296, 58078);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1441, 57296, 58078);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1441, 57296, 58078);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1441, 57296, 58078);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1441, 57296, 58078);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1441, 57296, 58078);
            CallChecker.varInit(this.m_registry, "m_registry", 1441, 57296, 58078);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1441, 57296, 58078);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1441, 57296, 58078);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1441, 57296, 58078);
            CallChecker.varInit(this.m_cache, "m_cache", 1441, 57296, 58078);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1441, 57296, 58078);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1441, 57296, 58078);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1441, 57296, 58078);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1441, 57296, 58078);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1441, 57296, 58078);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1441, 57296, 58078);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1441, 57296, 58078);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1441, 57296, 58078);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1441, 57296, 58078);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1441, 57296, 58078);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1441, 57296, 58078);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1441, 57296, 58078);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1441, 57296, 58078);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1441, 57296, 58078);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1441, 57296, 58078);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1441, 57296, 58078);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1441, 57296, 58078);
            CallChecker.varInit(this.m_logger, "m_logger", 1441, 57296, 58078);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1441, 57296, 58078);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1441, 57296, 58078);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1441, 57296, 58078);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1441, 57296, 58078);
            String s = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 1443, 57620, 57630)) {
                s = ((String) (CallChecker.isCalled(m_configMap, Map.class, 1443, 57620, 57630).get(FelixConstants.BUNDLE_STARTLEVEL_PROP)));
                CallChecker.varAssign(s, "s", 1443, 57620, 57630);
            }
            if (s != null) {
                TryContext _bcornu_try_context_175 = new TryContext(175, Felix.class, "java.lang.NumberFormatException");
                try {
                    int i = CallChecker.varInit(((int) (Integer.parseInt(s))), "i", 1449, 57756, 57783);
                    if (i > 0) {
                        return i;
                    }else {
                        return FelixConstants.BUNDLE_DEFAULT_STARTLEVEL;
                    }
                } catch (NumberFormatException ex) {
                    _bcornu_try_context_175.catchStart(175);
                } finally {
                    _bcornu_try_context_175.finallyStart(175);
                }
            }
            return FelixConstants.BUNDLE_DEFAULT_STARTLEVEL;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context616.methodEnd();
        }
    }

    void setInitialBundleStartLevel(int startLevel) {
        MethodContext _bcornu_methode_context617 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1471, 58085, 58937);
            CallChecker.varInit(startLevel, "startLevel", 1471, 58085, 58937);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1471, 58085, 58937);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1471, 58085, 58937);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1471, 58085, 58937);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1471, 58085, 58937);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1471, 58085, 58937);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1471, 58085, 58937);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1471, 58085, 58937);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1471, 58085, 58937);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1471, 58085, 58937);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1471, 58085, 58937);
            CallChecker.varInit(this.m_registry, "m_registry", 1471, 58085, 58937);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1471, 58085, 58937);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1471, 58085, 58937);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1471, 58085, 58937);
            CallChecker.varInit(this.m_cache, "m_cache", 1471, 58085, 58937);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1471, 58085, 58937);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1471, 58085, 58937);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1471, 58085, 58937);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1471, 58085, 58937);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1471, 58085, 58937);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1471, 58085, 58937);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1471, 58085, 58937);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1471, 58085, 58937);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1471, 58085, 58937);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1471, 58085, 58937);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1471, 58085, 58937);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1471, 58085, 58937);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1471, 58085, 58937);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1471, 58085, 58937);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1471, 58085, 58937);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1471, 58085, 58937);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1471, 58085, 58937);
            CallChecker.varInit(this.m_logger, "m_logger", 1471, 58085, 58937);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1471, 58085, 58937);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1471, 58085, 58937);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1471, 58085, 58937);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1471, 58085, 58937);
            if (startLevel <= 0) {
                throw new IllegalArgumentException("Initial start level must be greater than zero.");
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 1479, 58827, 58844)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 1479, 58827, 58844).put(FelixConstants.BUNDLE_STARTLEVEL_PROP, Integer.toString(startLevel));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context617.methodEnd();
        }
    }

    int getBundleStartLevel(Bundle bundle) {
        MethodContext _bcornu_methode_context618 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1491, 58944, 59581);
            CallChecker.varInit(bundle, "bundle", 1491, 58944, 59581);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1491, 58944, 59581);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1491, 58944, 59581);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1491, 58944, 59581);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1491, 58944, 59581);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1491, 58944, 59581);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1491, 58944, 59581);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1491, 58944, 59581);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1491, 58944, 59581);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1491, 58944, 59581);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1491, 58944, 59581);
            CallChecker.varInit(this.m_registry, "m_registry", 1491, 58944, 59581);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1491, 58944, 59581);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1491, 58944, 59581);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1491, 58944, 59581);
            CallChecker.varInit(this.m_cache, "m_cache", 1491, 58944, 59581);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1491, 58944, 59581);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1491, 58944, 59581);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1491, 58944, 59581);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1491, 58944, 59581);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1491, 58944, 59581);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1491, 58944, 59581);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1491, 58944, 59581);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1491, 58944, 59581);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1491, 58944, 59581);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1491, 58944, 59581);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1491, 58944, 59581);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1491, 58944, 59581);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1491, 58944, 59581);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1491, 58944, 59581);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1491, 58944, 59581);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1491, 58944, 59581);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1491, 58944, 59581);
            CallChecker.varInit(this.m_logger, "m_logger", 1491, 58944, 59581);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1491, 58944, 59581);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1491, 58944, 59581);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1491, 58944, 59581);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1491, 58944, 59581);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 1493, 59359, 59364)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 1493, 59359, 59364);
                if ((CallChecker.isCalled(bundle, Bundle.class, 1493, 59359, 59364).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalArgumentException("Bundle is uninstalled.");
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(bundle, Bundle.class, 1498, 59524, 59529)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1498, 59524, 59529);
                return CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 1498, 59524, 59529).getStartLevel(getInitialBundleStartLevel());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context618.methodEnd();
        }
    }

    void setBundleStartLevel(Bundle bundle, int startLevel) {
        MethodContext _bcornu_methode_context619 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1512, 59588, 63363);
            CallChecker.varInit(startLevel, "startLevel", 1512, 59588, 63363);
            CallChecker.varInit(bundle, "bundle", 1512, 59588, 63363);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1512, 59588, 63363);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1512, 59588, 63363);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1512, 59588, 63363);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1512, 59588, 63363);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1512, 59588, 63363);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1512, 59588, 63363);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1512, 59588, 63363);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1512, 59588, 63363);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1512, 59588, 63363);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1512, 59588, 63363);
            CallChecker.varInit(this.m_registry, "m_registry", 1512, 59588, 63363);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1512, 59588, 63363);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1512, 59588, 63363);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1512, 59588, 63363);
            CallChecker.varInit(this.m_cache, "m_cache", 1512, 59588, 63363);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1512, 59588, 63363);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1512, 59588, 63363);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1512, 59588, 63363);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1512, 59588, 63363);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1512, 59588, 63363);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1512, 59588, 63363);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1512, 59588, 63363);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1512, 59588, 63363);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1512, 59588, 63363);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1512, 59588, 63363);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1512, 59588, 63363);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1512, 59588, 63363);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1512, 59588, 63363);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1512, 59588, 63363);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1512, 59588, 63363);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1512, 59588, 63363);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1512, 59588, 63363);
            CallChecker.varInit(this.m_logger, "m_logger", 1512, 59588, 63363);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1512, 59588, 63363);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1512, 59588, 63363);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1512, 59588, 63363);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1512, 59588, 63363);
            BundleImpl impl = CallChecker.varInit(((BundleImpl) (bundle)), "impl", 1515, 60254, 60291);
            TryContext _bcornu_try_context_176 = new TryContext(176, Felix.class, "java.lang.IllegalStateException");
            try {
                acquireBundleLock(impl, (((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.ACTIVE)) | (Bundle.STARTING)) | (Bundle.STOPPING)));
            } catch (IllegalStateException ex) {
                _bcornu_try_context_176.catchStart(176);
                fireFrameworkEvent(FrameworkEvent.ERROR, impl, ex);
                if (CallChecker.beforeDeref(impl, BundleImpl.class, 1527, 60697, 60700)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1525, 60609, 60616)) {
                        impl = CallChecker.beforeCalled(impl, BundleImpl.class, 1527, 60697, 60700);
                        CallChecker.isCalled(m_logger, Logger.class, 1525, 60609, 60616).log(impl, Logger.LOG_ERROR, ("Error locking " + (CallChecker.isCalled(impl, BundleImpl.class, 1527, 60697, 60700)._getLocation())), ex);
                    }
                }
                return ;
            } finally {
                _bcornu_try_context_176.finallyStart(176);
            }
            Throwable rethrow = CallChecker.varInit(null, "rethrow", 1531, 60762, 60786);
            TryContext _bcornu_try_context_178 = new TryContext(178, Felix.class);
            try {
                if (startLevel >= 1) {
                    TryContext _bcornu_try_context_177 = new TryContext(177, Felix.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(impl, BundleImpl.class, 1548, 61440, 61443)) {
                            if (CallChecker.beforeDeref(impl, BundleImpl.class, 1549, 61512, 61515)) {
                                impl = CallChecker.beforeCalled(impl, BundleImpl.class, 1548, 61440, 61443);
                                impl = CallChecker.beforeCalled(impl, BundleImpl.class, 1549, 61512, 61515);
                                if ((((CallChecker.isCalled(impl, BundleImpl.class, 1548, 61440, 61443).getPersistentState()) == (Bundle.ACTIVE)) || ((CallChecker.isCalled(impl, BundleImpl.class, 1549, 61512, 61515).getPersistentState()) == (Bundle.STARTING))) && (startLevel <= (m_activeStartLevel))) {
                                    int options = CallChecker.varInit(((int) (Bundle.START_TRANSIENT)), "options", 1553, 61720, 61756);
                                    if (CallChecker.beforeDeref(impl, BundleImpl.class, 1554, 61793, 61796)) {
                                        impl = CallChecker.beforeCalled(impl, BundleImpl.class, 1554, 61793, 61796);
                                        if ((CallChecker.isCalled(impl, BundleImpl.class, 1554, 61793, 61796).getPersistentState()) == (Bundle.STARTING)) {
                                            options = options | (Bundle.START_ACTIVATION_POLICY);
                                            CallChecker.varAssign(options, "options", 1554, 61782, 61947);
                                        }else {
                                            options = options;
                                            CallChecker.varAssign(options, "options", 1554, 61782, 61947);
                                        }
                                    }
                                    startBundle(impl, options);
                                }else
                                    if (CallChecker.beforeDeref(impl, BundleImpl.class, 1564, 62382, 62385)) {
                                        if (CallChecker.beforeDeref(impl, BundleImpl.class, 1565, 62444, 62447)) {
                                            impl = CallChecker.beforeCalled(impl, BundleImpl.class, 1564, 62382, 62385);
                                            impl = CallChecker.beforeCalled(impl, BundleImpl.class, 1565, 62444, 62447);
                                            if ((((CallChecker.isCalled(impl, BundleImpl.class, 1564, 62382, 62385).getState()) == (Bundle.ACTIVE)) || ((CallChecker.isCalled(impl, BundleImpl.class, 1565, 62444, 62447).getState()) == (Bundle.STARTING))) && (startLevel > (m_activeStartLevel))) {
                                                stopBundle(impl, false);
                                            }
                                        }
                                    }
                                
                            }
                        }
                    } catch (Throwable th) {
                        _bcornu_try_context_177.catchStart(177);
                        rethrow = th;
                        CallChecker.varAssign(rethrow, "rethrow", 1573, 62729, 62741);
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 1574, 62763, 62770)) {
                            CallChecker.isCalled(m_logger, Logger.class, 1574, 62763, 62770).log(impl, Logger.LOG_ERROR, "Error starting/stopping bundle.", th);
                        }
                    } finally {
                        _bcornu_try_context_177.finallyStart(177);
                    }
                }else {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1581, 62968, 62975)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1581, 62968, 62975).log(impl, Logger.LOG_WARNING, "Bundle start level must be greater than zero.");
                    }
                }
            } finally {
                _bcornu_try_context_178.finallyStart(178);
                releaseBundleLock(impl);
            }
            if (rethrow != null) {
                fireFrameworkEvent(FrameworkEvent.ERROR, bundle, rethrow);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context619.methodEnd();
        }
    }

    boolean isBundlePersistentlyStarted(Bundle bundle) {
        MethodContext _bcornu_methode_context620 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1607, 63370, 64154);
            CallChecker.varInit(bundle, "bundle", 1607, 63370, 64154);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1607, 63370, 64154);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1607, 63370, 64154);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1607, 63370, 64154);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1607, 63370, 64154);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1607, 63370, 64154);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1607, 63370, 64154);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1607, 63370, 64154);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1607, 63370, 64154);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1607, 63370, 64154);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1607, 63370, 64154);
            CallChecker.varInit(this.m_registry, "m_registry", 1607, 63370, 64154);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1607, 63370, 64154);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1607, 63370, 64154);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1607, 63370, 64154);
            CallChecker.varInit(this.m_cache, "m_cache", 1607, 63370, 64154);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1607, 63370, 64154);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1607, 63370, 64154);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1607, 63370, 64154);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1607, 63370, 64154);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1607, 63370, 64154);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1607, 63370, 64154);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1607, 63370, 64154);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1607, 63370, 64154);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1607, 63370, 64154);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1607, 63370, 64154);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1607, 63370, 64154);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1607, 63370, 64154);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1607, 63370, 64154);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1607, 63370, 64154);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1607, 63370, 64154);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1607, 63370, 64154);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1607, 63370, 64154);
            CallChecker.varInit(this.m_logger, "m_logger", 1607, 63370, 64154);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1607, 63370, 64154);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1607, 63370, 64154);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1607, 63370, 64154);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1607, 63370, 64154);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 1609, 63857, 63862)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 1609, 63857, 63862);
                if ((CallChecker.isCalled(bundle, Bundle.class, 1609, 63857, 63862).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalArgumentException("Bundle is uninstalled.");
                }
            }else
                throw new AbnormalExecutionError();
            
            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1614, 64023, 64028);
            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1615, 64100, 64105);
            return ((CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 1614, 64023, 64028).getPersistentState()) == (Bundle.ACTIVE)) || ((CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 1615, 64100, 64105).getPersistentState()) == (Bundle.STARTING));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context620.methodEnd();
        }
    }

    boolean isBundleActivationPolicyUsed(Bundle bundle) {
        MethodContext _bcornu_methode_context621 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1627, 64161, 64883);
            CallChecker.varInit(bundle, "bundle", 1627, 64161, 64883);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1627, 64161, 64883);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1627, 64161, 64883);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1627, 64161, 64883);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1627, 64161, 64883);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1627, 64161, 64883);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1627, 64161, 64883);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1627, 64161, 64883);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1627, 64161, 64883);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1627, 64161, 64883);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1627, 64161, 64883);
            CallChecker.varInit(this.m_registry, "m_registry", 1627, 64161, 64883);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1627, 64161, 64883);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1627, 64161, 64883);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1627, 64161, 64883);
            CallChecker.varInit(this.m_cache, "m_cache", 1627, 64161, 64883);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1627, 64161, 64883);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1627, 64161, 64883);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1627, 64161, 64883);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1627, 64161, 64883);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1627, 64161, 64883);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1627, 64161, 64883);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1627, 64161, 64883);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1627, 64161, 64883);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1627, 64161, 64883);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1627, 64161, 64883);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1627, 64161, 64883);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1627, 64161, 64883);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1627, 64161, 64883);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1627, 64161, 64883);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1627, 64161, 64883);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1627, 64161, 64883);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1627, 64161, 64883);
            CallChecker.varInit(this.m_logger, "m_logger", 1627, 64161, 64883);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1627, 64161, 64883);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1627, 64161, 64883);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1627, 64161, 64883);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1627, 64161, 64883);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 1629, 64672, 64677)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 1629, 64672, 64677);
                if ((CallChecker.isCalled(bundle, Bundle.class, 1629, 64672, 64677).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalArgumentException("Bundle is uninstalled.");
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(bundle, Bundle.class, 1634, 64837, 64842)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1634, 64837, 64842);
                return CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 1634, 64837, 64842).isDeclaredActivationPolicyUsed();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context621.methodEnd();
        }
    }

    Dictionary getBundleHeaders(BundleImpl bundle, String locale) {
        MethodContext _bcornu_methode_context622 = new MethodContext(Dictionary.class);
        try {
            CallChecker.varInit(this, "this", 1647, 64890, 65299);
            CallChecker.varInit(locale, "locale", 1647, 64890, 65299);
            CallChecker.varInit(bundle, "bundle", 1647, 64890, 65299);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1647, 64890, 65299);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1647, 64890, 65299);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1647, 64890, 65299);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1647, 64890, 65299);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1647, 64890, 65299);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1647, 64890, 65299);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1647, 64890, 65299);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1647, 64890, 65299);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1647, 64890, 65299);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1647, 64890, 65299);
            CallChecker.varInit(this.m_registry, "m_registry", 1647, 64890, 65299);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1647, 64890, 65299);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1647, 64890, 65299);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1647, 64890, 65299);
            CallChecker.varInit(this.m_cache, "m_cache", 1647, 64890, 65299);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1647, 64890, 65299);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1647, 64890, 65299);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1647, 64890, 65299);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1647, 64890, 65299);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1647, 64890, 65299);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1647, 64890, 65299);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1647, 64890, 65299);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1647, 64890, 65299);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1647, 64890, 65299);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1647, 64890, 65299);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1647, 64890, 65299);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1647, 64890, 65299);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1647, 64890, 65299);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1647, 64890, 65299);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1647, 64890, 65299);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1647, 64890, 65299);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1647, 64890, 65299);
            CallChecker.varInit(this.m_logger, "m_logger", 1647, 64890, 65299);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1647, 64890, 65299);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1647, 64890, 65299);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1647, 64890, 65299);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1647, 64890, 65299);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1649, 65252, 65257)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1649, 65252, 65257);
                return new MapToDictionary(CallChecker.isCalled(bundle, BundleImpl.class, 1649, 65252, 65257).getCurrentLocalizedHeader(locale));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dictionary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context622.methodEnd();
        }
    }

    URL getBundleResource(BundleImpl bundle, String name) {
        MethodContext _bcornu_methode_context623 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 1655, 65306, 66462);
            CallChecker.varInit(name, "name", 1655, 65306, 66462);
            CallChecker.varInit(bundle, "bundle", 1655, 65306, 66462);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1655, 65306, 66462);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1655, 65306, 66462);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1655, 65306, 66462);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1655, 65306, 66462);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1655, 65306, 66462);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1655, 65306, 66462);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1655, 65306, 66462);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1655, 65306, 66462);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1655, 65306, 66462);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1655, 65306, 66462);
            CallChecker.varInit(this.m_registry, "m_registry", 1655, 65306, 66462);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1655, 65306, 66462);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1655, 65306, 66462);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1655, 65306, 66462);
            CallChecker.varInit(this.m_cache, "m_cache", 1655, 65306, 66462);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1655, 65306, 66462);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1655, 65306, 66462);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1655, 65306, 66462);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1655, 65306, 66462);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1655, 65306, 66462);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1655, 65306, 66462);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1655, 65306, 66462);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1655, 65306, 66462);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1655, 65306, 66462);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1655, 65306, 66462);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1655, 65306, 66462);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1655, 65306, 66462);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1655, 65306, 66462);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1655, 65306, 66462);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1655, 65306, 66462);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1655, 65306, 66462);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1655, 65306, 66462);
            CallChecker.varInit(this.m_logger, "m_logger", 1655, 65306, 66462);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1655, 65306, 66462);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1655, 65306, 66462);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1655, 65306, 66462);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1655, 65306, 66462);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1657, 65442, 65447)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1657, 65442, 65447);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1657, 65442, 65447).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("The bundle is uninstalled.");
                }else
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1661, 65611, 65616)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1661, 65611, 65616);
                        if (Util.isFragment(CallChecker.isCalled(bundle, BundleImpl.class, 1661, 65611, 65616).adapt(BundleRevision.class))) {
                            return null;
                        }else
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1665, 65710, 65715)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1665, 65710, 65715);
                                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1665, 65710, 65715).getState()) == (Bundle.INSTALLED)) {
                                    TryContext _bcornu_try_context_179 = new TryContext(179, Felix.class, "java.lang.Exception");
                                    try {
                                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1669, 65827, 65832)) {
                                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1669, 65827, 65832);
                                            resolveBundleRevision(CallChecker.isCalled(bundle, BundleImpl.class, 1669, 65827, 65832).adapt(BundleRevision.class));
                                        }
                                    } catch (Exception ex) {
                                        _bcornu_try_context_179.catchStart(179);
                                    } finally {
                                        _bcornu_try_context_179.finallyStart(179);
                                    }
                                }
                            }
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1679, 66096, 66101)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1679, 66096, 66101);
                final BundleRevision npe_invocation_var186 = CallChecker.isCalled(bundle, BundleImpl.class, 1679, 66096, 66101).adapt(BundleRevision.class);
                if (CallChecker.beforeDeref(npe_invocation_var186, BundleRevision.class, 1679, 66096, 66129)) {
                    if ((CallChecker.isCalled(npe_invocation_var186, BundleRevision.class, 1679, 66096, 66129).getWiring()) == null) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1681, 66203, 66208)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1681, 66203, 66208);
                            final BundleRevisionImpl npe_invocation_var187 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 1681, 66203, 66208).adapt(BundleRevision.class)));
                            if (CallChecker.beforeDeref(npe_invocation_var187, BundleRevisionImpl.class, 1681, 66203, 66236)) {
                                return CallChecker.isCalled(npe_invocation_var187, BundleRevisionImpl.class, 1681, 66203, 66236).getResourceLocal(name);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1686, 66352, 66357)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1686, 66352, 66357);
                            final BundleRevision npe_invocation_var188 = CallChecker.isCalled(bundle, BundleImpl.class, 1686, 66352, 66357).adapt(BundleRevision.class);
                            if (CallChecker.beforeDeref(npe_invocation_var188, BundleRevision.class, 1686, 66352, 66385)) {
                                final BundleWiringImpl npe_invocation_var189 = ((BundleWiringImpl) (CallChecker.isCalled(npe_invocation_var188, BundleRevision.class, 1686, 66352, 66385).getWiring()));
                                if (CallChecker.beforeDeref(npe_invocation_var189, BundleWiringImpl.class, 1686, 66352, 66397)) {
                                    return CallChecker.isCalled(npe_invocation_var189, BundleWiringImpl.class, 1686, 66352, 66397).getResourceByDelegation(name);
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
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context623.methodEnd();
        }
    }

    Enumeration getBundleResources(BundleImpl bundle, String name) {
        MethodContext _bcornu_methode_context624 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 1694, 66469, 67530);
            CallChecker.varInit(name, "name", 1694, 66469, 67530);
            CallChecker.varInit(bundle, "bundle", 1694, 66469, 67530);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1694, 66469, 67530);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1694, 66469, 67530);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1694, 66469, 67530);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1694, 66469, 67530);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1694, 66469, 67530);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1694, 66469, 67530);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1694, 66469, 67530);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1694, 66469, 67530);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1694, 66469, 67530);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1694, 66469, 67530);
            CallChecker.varInit(this.m_registry, "m_registry", 1694, 66469, 67530);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1694, 66469, 67530);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1694, 66469, 67530);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1694, 66469, 67530);
            CallChecker.varInit(this.m_cache, "m_cache", 1694, 66469, 67530);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1694, 66469, 67530);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1694, 66469, 67530);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1694, 66469, 67530);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1694, 66469, 67530);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1694, 66469, 67530);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1694, 66469, 67530);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1694, 66469, 67530);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1694, 66469, 67530);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1694, 66469, 67530);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1694, 66469, 67530);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1694, 66469, 67530);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1694, 66469, 67530);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1694, 66469, 67530);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1694, 66469, 67530);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1694, 66469, 67530);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1694, 66469, 67530);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1694, 66469, 67530);
            CallChecker.varInit(this.m_logger, "m_logger", 1694, 66469, 67530);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1694, 66469, 67530);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1694, 66469, 67530);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1694, 66469, 67530);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1694, 66469, 67530);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1696, 66615, 66620)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1696, 66615, 66620);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1696, 66615, 66620).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("The bundle is uninstalled.");
                }else
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1700, 66784, 66789)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1700, 66784, 66789);
                        if (Util.isFragment(CallChecker.isCalled(bundle, BundleImpl.class, 1700, 66784, 66789).adapt(BundleRevision.class))) {
                            return null;
                        }else
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1704, 66883, 66888)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1704, 66883, 66888);
                                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1704, 66883, 66888).getState()) == (Bundle.INSTALLED)) {
                                    TryContext _bcornu_try_context_180 = new TryContext(180, Felix.class, "java.lang.Exception");
                                    try {
                                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1708, 67000, 67005)) {
                                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1708, 67000, 67005);
                                            resolveBundleRevision(CallChecker.isCalled(bundle, BundleImpl.class, 1708, 67000, 67005).adapt(BundleRevision.class));
                                        }
                                    } catch (Exception ex) {
                                        _bcornu_try_context_180.catchStart(180);
                                    } finally {
                                        _bcornu_try_context_180.finallyStart(180);
                                    }
                                }
                            }
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1716, 67162, 67167)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1716, 67162, 67167);
                final BundleRevision npe_invocation_var190 = CallChecker.isCalled(bundle, BundleImpl.class, 1716, 67162, 67167).adapt(BundleRevision.class);
                if (CallChecker.beforeDeref(npe_invocation_var190, BundleRevision.class, 1716, 67162, 67195)) {
                    if ((CallChecker.isCalled(npe_invocation_var190, BundleRevision.class, 1716, 67162, 67195).getWiring()) == null) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1718, 67269, 67274)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1718, 67269, 67274);
                            final BundleRevisionImpl npe_invocation_var191 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 1718, 67269, 67274).adapt(BundleRevision.class)));
                            if (CallChecker.beforeDeref(npe_invocation_var191, BundleRevisionImpl.class, 1718, 67269, 67302)) {
                                return CallChecker.isCalled(npe_invocation_var191, BundleRevisionImpl.class, 1718, 67269, 67302).getResourcesLocal(name);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1723, 67419, 67424)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1723, 67419, 67424);
                            final BundleRevision npe_invocation_var192 = CallChecker.isCalled(bundle, BundleImpl.class, 1723, 67419, 67424).adapt(BundleRevision.class);
                            if (CallChecker.beforeDeref(npe_invocation_var192, BundleRevision.class, 1723, 67419, 67452)) {
                                final BundleWiringImpl npe_invocation_var193 = ((BundleWiringImpl) (CallChecker.isCalled(npe_invocation_var192, BundleRevision.class, 1723, 67419, 67452).getWiring()));
                                if (CallChecker.beforeDeref(npe_invocation_var193, BundleWiringImpl.class, 1723, 67419, 67464)) {
                                    return CallChecker.isCalled(npe_invocation_var193, BundleWiringImpl.class, 1723, 67419, 67464).getResourcesByDelegation(name);
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
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context624.methodEnd();
        }
    }

    URL getBundleEntry(BundleImpl bundle, String name) {
        MethodContext _bcornu_methode_context625 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 1731, 67537, 69052);
            CallChecker.varInit(name, "name", 1731, 67537, 69052);
            CallChecker.varInit(bundle, "bundle", 1731, 67537, 69052);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1731, 67537, 69052);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1731, 67537, 69052);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1731, 67537, 69052);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1731, 67537, 69052);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1731, 67537, 69052);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1731, 67537, 69052);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1731, 67537, 69052);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1731, 67537, 69052);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1731, 67537, 69052);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1731, 67537, 69052);
            CallChecker.varInit(this.m_registry, "m_registry", 1731, 67537, 69052);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1731, 67537, 69052);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1731, 67537, 69052);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1731, 67537, 69052);
            CallChecker.varInit(this.m_cache, "m_cache", 1731, 67537, 69052);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1731, 67537, 69052);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1731, 67537, 69052);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1731, 67537, 69052);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1731, 67537, 69052);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1731, 67537, 69052);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1731, 67537, 69052);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1731, 67537, 69052);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1731, 67537, 69052);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1731, 67537, 69052);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1731, 67537, 69052);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1731, 67537, 69052);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1731, 67537, 69052);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1731, 67537, 69052);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1731, 67537, 69052);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1731, 67537, 69052);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1731, 67537, 69052);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1731, 67537, 69052);
            CallChecker.varInit(this.m_logger, "m_logger", 1731, 67537, 69052);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1731, 67537, 69052);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1731, 67537, 69052);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1731, 67537, 69052);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1731, 67537, 69052);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1733, 67667, 67672)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1733, 67667, 67672);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1733, 67667, 67672).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("The bundle is uninstalled.");
                }
            }else
                throw new AbnormalExecutionError();
            
            URL url = CallChecker.init(URL.class);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1738, 67844, 67849)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1738, 67844, 67849);
                final BundleRevisionImpl npe_invocation_var194 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 1738, 67844, 67849).adapt(BundleRevision.class)));
                if (CallChecker.beforeDeref(npe_invocation_var194, BundleRevisionImpl.class, 1738, 67844, 67877)) {
                    url = CallChecker.isCalled(npe_invocation_var194, BundleRevisionImpl.class, 1738, 67844, 67877).getEntry(name);
                    CallChecker.varAssign(url, "url", 1738, 67844, 67849);
                }
            }
            if (CallChecker.beforeDeref(name, String.class, 1743, 68122, 68125)) {
                if (CallChecker.beforeDeref(name, String.class, 1743, 68145, 68148)) {
                    name = CallChecker.beforeCalled(name, String.class, 1743, 68122, 68125);
                    name = CallChecker.beforeCalled(name, String.class, 1743, 68145, 68148);
                    if (((url == null) && (CallChecker.isCalled(name, String.class, 1743, 68122, 68125).endsWith("/"))) && (!(CallChecker.isCalled(name, String.class, 1743, 68145, 68148).equals("/")))) {
                        Enumeration enumeration = CallChecker.init(Enumeration.class);
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1749, 68425, 68430)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1749, 68425, 68430);
                            enumeration = new EntryFilterEnumeration(CallChecker.isCalled(bundle, BundleImpl.class, 1749, 68425, 68430).adapt(BundleRevision.class), false, name, "*", true, true);
                            CallChecker.varAssign(enumeration, "enumeration", 1749, 68425, 68430);
                        }
                        if (CallChecker.beforeDeref(enumeration, Enumeration.class, 1752, 68630, 68640)) {
                            enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 1752, 68630, 68640);
                            if (CallChecker.isCalled(enumeration, Enumeration.class, 1752, 68630, 68640).hasMoreElements()) {
                                URL entryURL = CallChecker.init(URL.class);
                                if (CallChecker.beforeDeref(enumeration, Enumeration.class, 1754, 68712, 68722)) {
                                    enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 1754, 68712, 68722);
                                    entryURL = ((URL) (CallChecker.isCalled(enumeration, Enumeration.class, 1754, 68712, 68722).nextElement()));
                                    CallChecker.varAssign(entryURL, "entryURL", 1754, 68712, 68722);
                                }
                                TryContext _bcornu_try_context_181 = new TryContext(181, Felix.class, "java.net.MalformedURLException");
                                try {
                                    if (CallChecker.beforeDeref(name, String.class, 1757, 68823, 68826)) {
                                        name = CallChecker.beforeCalled(name, String.class, 1757, 68823, 68826);
                                        url = new URL(entryURL, ((CallChecker.isCalled(name, String.class, 1757, 68823, 68826).charAt(0)) == '/' ? name : "/" + name));
                                        CallChecker.varAssign(url, "url", 1757, 68797, 68867);
                                    }
                                } catch (MalformedURLException ex) {
                                    _bcornu_try_context_181.catchStart(181);
                                    url = null;
                                    CallChecker.varAssign(url, "url", 1761, 68974, 68984);
                                } finally {
                                    _bcornu_try_context_181.finallyStart(181);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return url;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context625.methodEnd();
        }
    }

    Enumeration getBundleEntryPaths(BundleImpl bundle, String path) {
        MethodContext _bcornu_methode_context626 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 1771, 69059, 69753);
            CallChecker.varInit(path, "path", 1771, 69059, 69753);
            CallChecker.varInit(bundle, "bundle", 1771, 69059, 69753);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1771, 69059, 69753);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1771, 69059, 69753);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1771, 69059, 69753);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1771, 69059, 69753);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1771, 69059, 69753);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1771, 69059, 69753);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1771, 69059, 69753);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1771, 69059, 69753);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1771, 69059, 69753);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1771, 69059, 69753);
            CallChecker.varInit(this.m_registry, "m_registry", 1771, 69059, 69753);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1771, 69059, 69753);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1771, 69059, 69753);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1771, 69059, 69753);
            CallChecker.varInit(this.m_cache, "m_cache", 1771, 69059, 69753);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1771, 69059, 69753);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1771, 69059, 69753);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1771, 69059, 69753);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1771, 69059, 69753);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1771, 69059, 69753);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1771, 69059, 69753);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1771, 69059, 69753);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1771, 69059, 69753);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1771, 69059, 69753);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1771, 69059, 69753);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1771, 69059, 69753);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1771, 69059, 69753);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1771, 69059, 69753);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1771, 69059, 69753);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1771, 69059, 69753);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1771, 69059, 69753);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1771, 69059, 69753);
            CallChecker.varInit(this.m_logger, "m_logger", 1771, 69059, 69753);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1771, 69059, 69753);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1771, 69059, 69753);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1771, 69059, 69753);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1771, 69059, 69753);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1773, 69207, 69212)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1773, 69207, 69212);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1773, 69207, 69212).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("The bundle is uninstalled.");
                }
            }else
                throw new AbnormalExecutionError();
            
            Enumeration enumeration = CallChecker.init(Enumeration.class);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1782, 69555, 69560)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1782, 69555, 69560);
                enumeration = new EntryFilterEnumeration(CallChecker.isCalled(bundle, BundleImpl.class, 1782, 69555, 69560).adapt(BundleRevision.class), false, path, "*", false, false);
                CallChecker.varAssign(enumeration, "enumeration", 1782, 69555, 69560);
            }
            if (CallChecker.beforeDeref(enumeration, Enumeration.class, 1785, 69696, 69706)) {
                enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 1785, 69696, 69706);
                if (!(CallChecker.isCalled(enumeration, Enumeration.class, 1785, 69696, 69706).hasMoreElements())) {
                    return null;
                }else {
                    return enumeration;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context626.methodEnd();
        }
    }

    Enumeration findBundleEntries(BundleImpl bundle, String path, String filePattern, boolean recurse) {
        MethodContext _bcornu_methode_context627 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 1791, 69760, 70548);
            CallChecker.varInit(recurse, "recurse", 1791, 69760, 70548);
            CallChecker.varInit(filePattern, "filePattern", 1791, 69760, 70548);
            CallChecker.varInit(path, "path", 1791, 69760, 70548);
            CallChecker.varInit(bundle, "bundle", 1791, 69760, 70548);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1791, 69760, 70548);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1791, 69760, 70548);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1791, 69760, 70548);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1791, 69760, 70548);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1791, 69760, 70548);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1791, 69760, 70548);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1791, 69760, 70548);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1791, 69760, 70548);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1791, 69760, 70548);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1791, 69760, 70548);
            CallChecker.varInit(this.m_registry, "m_registry", 1791, 69760, 70548);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1791, 69760, 70548);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1791, 69760, 70548);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1791, 69760, 70548);
            CallChecker.varInit(this.m_cache, "m_cache", 1791, 69760, 70548);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1791, 69760, 70548);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1791, 69760, 70548);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1791, 69760, 70548);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1791, 69760, 70548);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1791, 69760, 70548);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1791, 69760, 70548);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1791, 69760, 70548);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1791, 69760, 70548);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1791, 69760, 70548);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1791, 69760, 70548);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1791, 69760, 70548);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1791, 69760, 70548);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1791, 69760, 70548);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1791, 69760, 70548);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1791, 69760, 70548);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1791, 69760, 70548);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1791, 69760, 70548);
            CallChecker.varInit(this.m_logger, "m_logger", 1791, 69760, 70548);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1791, 69760, 70548);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1791, 69760, 70548);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1791, 69760, 70548);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1791, 69760, 70548);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1794, 69954, 69959)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1794, 69954, 69959);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1794, 69954, 69959).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("The bundle is uninstalled.");
                }else
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1798, 70124, 70129)) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1798, 70163, 70168)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1798, 70124, 70129);
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1798, 70163, 70168);
                            if ((!(Util.isFragment(CallChecker.isCalled(bundle, BundleImpl.class, 1798, 70124, 70129).adapt(BundleRevision.class)))) && ((CallChecker.isCalled(bundle, BundleImpl.class, 1798, 70163, 70168).getState()) == (Bundle.INSTALLED))) {
                                TryContext _bcornu_try_context_182 = new TryContext(182, Felix.class, "java.lang.Exception");
                                try {
                                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1802, 70280, 70285)) {
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1802, 70280, 70285);
                                        resolveBundleRevision(CallChecker.isCalled(bundle, BundleImpl.class, 1802, 70280, 70285).adapt(BundleRevision.class));
                                    }
                                } catch (Exception ex) {
                                    _bcornu_try_context_182.catchStart(182);
                                } finally {
                                    _bcornu_try_context_182.finallyStart(182);
                                }
                            }
                        }
                    }
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1810, 70479, 70484)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1810, 70479, 70484);
                return findBundleEntries(CallChecker.isCalled(bundle, BundleImpl.class, 1810, 70479, 70484).adapt(BundleRevision.class), path, filePattern, recurse);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context627.methodEnd();
        }
    }

    Enumeration findBundleEntries(BundleRevision revision, String path, String filePattern, boolean recurse) {
        MethodContext _bcornu_methode_context628 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 1816, 70555, 71120);
            CallChecker.varInit(recurse, "recurse", 1816, 70555, 71120);
            CallChecker.varInit(filePattern, "filePattern", 1816, 70555, 71120);
            CallChecker.varInit(path, "path", 1816, 70555, 71120);
            CallChecker.varInit(revision, "revision", 1816, 70555, 71120);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1816, 70555, 71120);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1816, 70555, 71120);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1816, 70555, 71120);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1816, 70555, 71120);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1816, 70555, 71120);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1816, 70555, 71120);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1816, 70555, 71120);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1816, 70555, 71120);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1816, 70555, 71120);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1816, 70555, 71120);
            CallChecker.varInit(this.m_registry, "m_registry", 1816, 70555, 71120);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1816, 70555, 71120);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1816, 70555, 71120);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1816, 70555, 71120);
            CallChecker.varInit(this.m_cache, "m_cache", 1816, 70555, 71120);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1816, 70555, 71120);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1816, 70555, 71120);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1816, 70555, 71120);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1816, 70555, 71120);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1816, 70555, 71120);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1816, 70555, 71120);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1816, 70555, 71120);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1816, 70555, 71120);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1816, 70555, 71120);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1816, 70555, 71120);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1816, 70555, 71120);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1816, 70555, 71120);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1816, 70555, 71120);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1816, 70555, 71120);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1816, 70555, 71120);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1816, 70555, 71120);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1816, 70555, 71120);
            CallChecker.varInit(this.m_logger, "m_logger", 1816, 70555, 71120);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1816, 70555, 71120);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1816, 70555, 71120);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1816, 70555, 71120);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1816, 70555, 71120);
            Enumeration enumeration = CallChecker.varInit(new EntryFilterEnumeration(revision, true, path, filePattern, recurse, true), "enumeration", 1821, 70875, 70989);
            if (CallChecker.beforeDeref(enumeration, Enumeration.class, 1825, 71063, 71073)) {
                enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 1825, 71063, 71073);
                if (!(CallChecker.isCalled(enumeration, Enumeration.class, 1825, 71063, 71073).hasMoreElements())) {
                    return null;
                }else {
                    return enumeration;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context628.methodEnd();
        }
    }

    ServiceReference[] getBundleRegisteredServices(BundleImpl bundle) {
        MethodContext _bcornu_methode_context629 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 1828, 71127, 71507);
            CallChecker.varInit(bundle, "bundle", 1828, 71127, 71507);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1828, 71127, 71507);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1828, 71127, 71507);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1828, 71127, 71507);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1828, 71127, 71507);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1828, 71127, 71507);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1828, 71127, 71507);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1828, 71127, 71507);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1828, 71127, 71507);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1828, 71127, 71507);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1828, 71127, 71507);
            CallChecker.varInit(this.m_registry, "m_registry", 1828, 71127, 71507);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1828, 71127, 71507);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1828, 71127, 71507);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1828, 71127, 71507);
            CallChecker.varInit(this.m_cache, "m_cache", 1828, 71127, 71507);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1828, 71127, 71507);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1828, 71127, 71507);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1828, 71127, 71507);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1828, 71127, 71507);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1828, 71127, 71507);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1828, 71127, 71507);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1828, 71127, 71507);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1828, 71127, 71507);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1828, 71127, 71507);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1828, 71127, 71507);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1828, 71127, 71507);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1828, 71127, 71507);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1828, 71127, 71507);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1828, 71127, 71507);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1828, 71127, 71507);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1828, 71127, 71507);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1828, 71127, 71507);
            CallChecker.varInit(this.m_logger, "m_logger", 1828, 71127, 71507);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1828, 71127, 71507);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1828, 71127, 71507);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1828, 71127, 71507);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1828, 71127, 71507);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1830, 71211, 71216)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1830, 71211, 71216);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1830, 71211, 71216).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("The bundle is uninstalled.");
                }
            }else
                throw new AbnormalExecutionError();
            
            ServiceReference[] refs = CallChecker.init(ServiceReference[].class);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 1836, 71439, 71448)) {
                refs = CallChecker.isCalled(m_registry, ServiceRegistry.class, 1836, 71439, 71448).getRegisteredServices(bundle);
                CallChecker.varAssign(refs, "refs", 1836, 71439, 71448);
            }
            return refs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context629.methodEnd();
        }
    }

    ServiceReference[] getBundleServicesInUse(Bundle bundle) {
        MethodContext _bcornu_methode_context630 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 1841, 71514, 71729);
            CallChecker.varInit(bundle, "bundle", 1841, 71514, 71729);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1841, 71514, 71729);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1841, 71514, 71729);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1841, 71514, 71729);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1841, 71514, 71729);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1841, 71514, 71729);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1841, 71514, 71729);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1841, 71514, 71729);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1841, 71514, 71729);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1841, 71514, 71729);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1841, 71514, 71729);
            CallChecker.varInit(this.m_registry, "m_registry", 1841, 71514, 71729);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1841, 71514, 71729);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1841, 71514, 71729);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1841, 71514, 71729);
            CallChecker.varInit(this.m_cache, "m_cache", 1841, 71514, 71729);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1841, 71514, 71729);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1841, 71514, 71729);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1841, 71514, 71729);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1841, 71514, 71729);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1841, 71514, 71729);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1841, 71514, 71729);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1841, 71514, 71729);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1841, 71514, 71729);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1841, 71514, 71729);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1841, 71514, 71729);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1841, 71514, 71729);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1841, 71514, 71729);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1841, 71514, 71729);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1841, 71514, 71729);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1841, 71514, 71729);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1841, 71514, 71729);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1841, 71514, 71729);
            CallChecker.varInit(this.m_logger, "m_logger", 1841, 71514, 71729);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1841, 71514, 71729);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1841, 71514, 71729);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1841, 71514, 71729);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1841, 71514, 71729);
            ServiceReference[] refs = CallChecker.init(ServiceReference[].class);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 1844, 71666, 71675)) {
                refs = CallChecker.isCalled(m_registry, ServiceRegistry.class, 1844, 71666, 71675).getServicesInUse(bundle);
                CallChecker.varAssign(refs, "refs", 1844, 71666, 71675);
            }
            return refs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context630.methodEnd();
        }
    }

    boolean bundleHasPermission(BundleImpl bundle, Object obj) {
        MethodContext _bcornu_methode_context631 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1849, 71736, 72663);
            CallChecker.varInit(obj, "obj", 1849, 71736, 72663);
            CallChecker.varInit(bundle, "bundle", 1849, 71736, 72663);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1849, 71736, 72663);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1849, 71736, 72663);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1849, 71736, 72663);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1849, 71736, 72663);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1849, 71736, 72663);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1849, 71736, 72663);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1849, 71736, 72663);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1849, 71736, 72663);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1849, 71736, 72663);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1849, 71736, 72663);
            CallChecker.varInit(this.m_registry, "m_registry", 1849, 71736, 72663);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1849, 71736, 72663);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1849, 71736, 72663);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1849, 71736, 72663);
            CallChecker.varInit(this.m_cache, "m_cache", 1849, 71736, 72663);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1849, 71736, 72663);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1849, 71736, 72663);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1849, 71736, 72663);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1849, 71736, 72663);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1849, 71736, 72663);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1849, 71736, 72663);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1849, 71736, 72663);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1849, 71736, 72663);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1849, 71736, 72663);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1849, 71736, 72663);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1849, 71736, 72663);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1849, 71736, 72663);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1849, 71736, 72663);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1849, 71736, 72663);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1849, 71736, 72663);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1849, 71736, 72663);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1849, 71736, 72663);
            CallChecker.varInit(this.m_logger, "m_logger", 1849, 71736, 72663);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1849, 71736, 72663);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1849, 71736, 72663);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1849, 71736, 72663);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1849, 71736, 72663);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1851, 71813, 71818)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1851, 71813, 71818);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1851, 71813, 71818).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("The bundle is uninstalled.");
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_183 = new TryContext(183, Felix.class, "java.lang.Exception");
                try {
                    if (obj instanceof Permission) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1863, 72216, 72221)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1863, 72216, 72221);
                            return impliesBundlePermission(((BundleProtectionDomain) (CallChecker.isCalled(bundle, BundleImpl.class, 1863, 72216, 72221).getProtectionDomain())), ((Permission) (obj)), true);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        return false;
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_183.catchStart(183);
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1869, 72410, 72417)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1869, 72410, 72417).log(bundle, Logger.LOG_WARNING, "Exception while evaluating the permission.", ex);
                    }
                    return false;
                } finally {
                    _bcornu_try_context_183.finallyStart(183);
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context631.methodEnd();
        }
    }

    Class loadBundleClass(BundleImpl bundle, String name) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context632 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(this, "this", 1884, 72670, 74222);
            CallChecker.varInit(name, "name", 1884, 72670, 74222);
            CallChecker.varInit(bundle, "bundle", 1884, 72670, 74222);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1884, 72670, 74222);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1884, 72670, 74222);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1884, 72670, 74222);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1884, 72670, 74222);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1884, 72670, 74222);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1884, 72670, 74222);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1884, 72670, 74222);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1884, 72670, 74222);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1884, 72670, 74222);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1884, 72670, 74222);
            CallChecker.varInit(this.m_registry, "m_registry", 1884, 72670, 74222);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1884, 72670, 74222);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1884, 72670, 74222);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1884, 72670, 74222);
            CallChecker.varInit(this.m_cache, "m_cache", 1884, 72670, 74222);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1884, 72670, 74222);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1884, 72670, 74222);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1884, 72670, 74222);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1884, 72670, 74222);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1884, 72670, 74222);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1884, 72670, 74222);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1884, 72670, 74222);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1884, 72670, 74222);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1884, 72670, 74222);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1884, 72670, 74222);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1884, 72670, 74222);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1884, 72670, 74222);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1884, 72670, 74222);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1884, 72670, 74222);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1884, 72670, 74222);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1884, 72670, 74222);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1884, 72670, 74222);
            CallChecker.varInit(this.m_logger, "m_logger", 1884, 72670, 74222);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1884, 72670, 74222);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1884, 72670, 74222);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1884, 72670, 74222);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1884, 72670, 74222);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1886, 72834, 72839)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1886, 72834, 72839);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1886, 72834, 72839).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("Bundle is uninstalled");
                }else
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1890, 72998, 73003)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1890, 72998, 73003);
                        if (Util.isFragment(CallChecker.isCalled(bundle, BundleImpl.class, 1890, 72998, 73003).adapt(BundleRevision.class))) {
                            throw new ClassNotFoundException("Fragments cannot load classes.");
                        }else
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1894, 73152, 73157)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1894, 73152, 73157);
                                if ((CallChecker.isCalled(bundle, BundleImpl.class, 1894, 73152, 73157).getState()) == (Bundle.INSTALLED)) {
                                    TryContext _bcornu_try_context_184 = new TryContext(184, Felix.class, "org.osgi.framework.BundleException");
                                    try {
                                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1898, 73269, 73274)) {
                                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1898, 73269, 73274);
                                            resolveBundleRevision(CallChecker.isCalled(bundle, BundleImpl.class, 1898, 73269, 73274).adapt(BundleRevision.class));
                                        }
                                    } catch (BundleException ex) {
                                        _bcornu_try_context_184.catchStart(184);
                                        fireFrameworkEvent(FrameworkEvent.ERROR, bundle, ex);
                                        throw new ClassNotFoundException(name, ex);
                                    } finally {
                                        _bcornu_try_context_184.finallyStart(184);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            if (((name != null) && ((name.length()) > 0)) && ((name.charAt(0)) == '[')) {
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1915, 74039, 74044)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1915, 74039, 74044);
                    final BundleWiringImpl npe_invocation_var195 = ((BundleWiringImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 1915, 74039, 74044).adapt(BundleWiring.class)));
                    if (CallChecker.beforeDeref(npe_invocation_var195, BundleWiringImpl.class, 1915, 74039, 74070)) {
                        return Class.forName(name, false, CallChecker.isCalled(npe_invocation_var195, BundleWiringImpl.class, 1915, 74039, 74070).getClassLoader());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1919, 74150, 74155)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1919, 74150, 74155);
                final BundleWiringImpl npe_invocation_var196 = ((BundleWiringImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 1919, 74150, 74155).adapt(BundleWiring.class)));
                if (CallChecker.beforeDeref(npe_invocation_var196, BundleWiringImpl.class, 1919, 74150, 74181)) {
                    final ClassLoader npe_invocation_var197 = CallChecker.isCalled(npe_invocation_var196, BundleWiringImpl.class, 1919, 74150, 74181).getClassLoader();
                    if (CallChecker.beforeDeref(npe_invocation_var197, ClassLoader.class, 1918, 74118, 74199)) {
                        return CallChecker.isCalled(npe_invocation_var197, ClassLoader.class, 1918, 74118, 74199).loadClass(name);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context632.methodEnd();
        }
    }

    void startBundle(BundleImpl bundle, int options) throws BundleException {
        MethodContext _bcornu_methode_context633 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1925, 74229, 85972);
            CallChecker.varInit(options, "options", 1925, 74229, 85972);
            CallChecker.varInit(bundle, "bundle", 1925, 74229, 85972);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 1925, 74229, 85972);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 1925, 74229, 85972);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 1925, 74229, 85972);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 1925, 74229, 85972);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 1925, 74229, 85972);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 1925, 74229, 85972);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 1925, 74229, 85972);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 1925, 74229, 85972);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 1925, 74229, 85972);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 1925, 74229, 85972);
            CallChecker.varInit(this.m_registry, "m_registry", 1925, 74229, 85972);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 1925, 74229, 85972);
            CallChecker.varInit(this.m_nextId, "m_nextId", 1925, 74229, 85972);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 1925, 74229, 85972);
            CallChecker.varInit(this.m_cache, "m_cache", 1925, 74229, 85972);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 1925, 74229, 85972);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 1925, 74229, 85972);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 1925, 74229, 85972);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 1925, 74229, 85972);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 1925, 74229, 85972);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 1925, 74229, 85972);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 1925, 74229, 85972);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 1925, 74229, 85972);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 1925, 74229, 85972);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 1925, 74229, 85972);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 1925, 74229, 85972);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 1925, 74229, 85972);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 1925, 74229, 85972);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 1925, 74229, 85972);
            CallChecker.varInit(this.m_resolver, "m_resolver", 1925, 74229, 85972);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 1925, 74229, 85972);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1925, 74229, 85972);
            CallChecker.varInit(this.m_logger, "m_logger", 1925, 74229, 85972);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 1925, 74229, 85972);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 1925, 74229, 85972);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 1925, 74229, 85972);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 1925, 74229, 85972);
            int eventType = CallChecker.init(int.class);
            boolean isTransient = CallChecker.varInit(((boolean) ((options & (Bundle.START_TRANSIENT)) != 0)), "isTransient", 1935, 74789, 74850);
            TryContext _bcornu_try_context_185 = new TryContext(185, Felix.class, "java.lang.IllegalStateException");
            try {
                acquireBundleLock(bundle, (((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.STARTING)) | (Bundle.ACTIVE)) | (Bundle.STOPPING)));
            } catch (IllegalStateException ex) {
                _bcornu_try_context_185.catchStart(185);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1945, 75127, 75132)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1945, 75127, 75132);
                    if ((CallChecker.isCalled(bundle, BundleImpl.class, 1945, 75127, 75132).getState()) == (Bundle.UNINSTALLED)) {
                        throw new IllegalStateException("Cannot start an uninstalled bundle.");
                    }else {
                        throw new BundleException((("Bundle " + bundle) + " cannot be started, since it is either starting or stopping."));
                    }
                }
            } finally {
                _bcornu_try_context_185.finallyStart(185);
            }
            boolean wasDeferred = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1958, 75617, 75622)) {
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1959, 75695, 75700)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1959, 75695, 75700);
                    final BundleRevisionImpl npe_invocation_var198 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 1959, 75695, 75700).adapt(BundleRevision.class)));
                    if (CallChecker.beforeDeref(npe_invocation_var198, BundleRevisionImpl.class, 1959, 75695, 75728)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1958, 75617, 75622);
                        wasDeferred = (CallChecker.isCalled(bundle, BundleImpl.class, 1958, 75617, 75622).isDeclaredActivationPolicyUsed()) && ((CallChecker.isCalled(npe_invocation_var198, BundleRevisionImpl.class, 1959, 75695, 75728).getDeclaredActivationPolicy()) == (BundleRevisionImpl.LAZY_ACTIVATION));
                        CallChecker.varAssign(wasDeferred, "wasDeferred", 1958, 75617, 75622);
                    }
                }
            }
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1961, 75826, 75831)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1961, 75826, 75831);
                CallChecker.isCalled(bundle, BundleImpl.class, 1961, 75826, 75831).setDeclaredActivationPolicyUsed(((options & (Bundle.START_ACTIVATION_POLICY)) != 0));
            }
            BundleException rethrow = CallChecker.varInit(null, "rethrow", 1964, 75937, 75967);
            TryContext _bcornu_try_context_187 = new TryContext(187, Felix.class);
            try {
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1969, 76122, 76127)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1969, 76122, 76127);
                    if (CallChecker.isCalled(bundle, BundleImpl.class, 1969, 76122, 76127).isExtension()) {
                        return ;
                    }
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1976, 76389, 76394)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1976, 76389, 76394);
                    if (Util.isFragment(CallChecker.isCalled(bundle, BundleImpl.class, 1976, 76389, 76394).adapt(BundleRevision.class))) {
                        throw new BundleException("Fragment bundles can not be started.");
                    }
                }
                if (!isTransient) {
                    if ((options & (Bundle.START_ACTIVATION_POLICY)) != 0) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1987, 76815, 76820)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1987, 76815, 76820);
                            CallChecker.isCalled(bundle, BundleImpl.class, 1987, 76815, 76820).setPersistentStateStarting();
                        }
                    }else {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 1991, 76929, 76934)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 1991, 76929, 76934);
                            CallChecker.isCalled(bundle, BundleImpl.class, 1991, 76929, 76934).setPersistentStateActive();
                        }
                    }
                }
                int bundleLevel = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2001, 77469, 77474)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2001, 77469, 77474);
                    bundleLevel = CallChecker.isCalled(bundle, BundleImpl.class, 2001, 77469, 77474).getStartLevel(getInitialBundleStartLevel());
                    CallChecker.varAssign(bundleLevel, "bundleLevel", 2001, 77469, 77474);
                }
                if (isTransient && (bundleLevel > (m_activeStartLevel))) {
                    throw new BundleException((((((("Cannot start bundle " + bundle) + " because its start level is ") + bundleLevel) + ", which is greater than the framework's start level of ") + (m_activeStartLevel)) + "."), BundleException.START_TRANSIENT_ERROR);
                }else
                    if (bundleLevel > (m_targetStartLevel)) {
                        return ;
                    }
                
                if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 2023, 78617, 78638)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(Thread.currentThread(), Thread.class, 2023, 78617, 78638).getName(), String.class, 2023, 78617, 78648)) {
                        if (!(CallChecker.isCalled(CallChecker.isCalled(Thread.currentThread(), Thread.class, 2023, 78617, 78638).getName(), String.class, 2023, 78617, 78648).equals(FrameworkStartLevelImpl.THREAD_NAME))) {
                            synchronized(m_startLevelBundles) {
                                if (isTransient && (bundleLevel > (m_activeStartLevel))) {
                                    throw new BundleException((((((("Cannot start bundle " + bundle) + " because its start level is ") + bundleLevel) + ", which is greater than the framework's start level of ") + (m_activeStartLevel)) + "."), BundleException.START_TRANSIENT_ERROR);
                                }
                                if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 2052, 80524, 80542)) {
                                    if ((!(CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 2052, 80524, 80542).isEmpty())) && (bundleLevel >= (m_activeStartLevel))) {
                                        boolean found = CallChecker.varInit(((boolean) (false)), "found", 2057, 80807, 80828);
                                        if (CallChecker.beforeDeref(m_startLevelBundles, void.class, 2058, 80883, 80901)) {
                                            for (Felix.StartLevelTuple tuple : m_startLevelBundles) {
                                                if (CallChecker.beforeDeref(tuple, Felix.StartLevelTuple.class, 2060, 80962, 80966)) {
                                                    if ((CallChecker.isCalled(tuple, Felix.StartLevelTuple.class, 2060, 80962, 80966).m_bundle) == bundle) {
                                                        found = true;
                                                        CallChecker.varAssign(found, "found", 2062, 81050, 81062);
                                                    }
                                                }
                                            }
                                        }
                                        if (!found) {
                                            if (CallChecker.beforeDeref(m_startLevelBundles, SortedSet.class, 2068, 81211, 81229)) {
                                                CallChecker.isCalled(m_startLevelBundles, SortedSet.class, 2068, 81211, 81229).add(new Felix.StartLevelTuple(bundle, bundleLevel));
                                            }
                                        }
                                        if (!isTransient) {
                                            return ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2092, 82503, 82508)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2092, 82503, 82508);
                    switch (CallChecker.isCalled(bundle, BundleImpl.class, 2092, 82503, 82508).getState()) {
                        case Bundle.UNINSTALLED :
                            throw new IllegalStateException("Cannot start an uninstalled bundle.");
                        case Bundle.STARTING :
                            if (!wasDeferred) {
                                throw new BundleException((("Bundle " + bundle) + " cannot be started, since it is starting."));
                            }
                            break;
                        case Bundle.STOPPING :
                            throw new BundleException((("Bundle " + bundle) + " cannot be started, since it is stopping."));
                        case Bundle.ACTIVE :
                            return ;
                        case Bundle.INSTALLED :
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2111, 83335, 83340)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2111, 83335, 83340);
                                resolveBundleRevision(CallChecker.isCalled(bundle, BundleImpl.class, 2111, 83335, 83340).adapt(BundleRevision.class));
                            }else
                                throw new AbnormalExecutionError();
                            
                        case Bundle.RESOLVED :
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2115, 83512, 83517)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2115, 83512, 83517);
                                CallChecker.isCalled(bundle, BundleImpl.class, 2115, 83512, 83517).setBundleContext(new BundleContextImpl(m_logger, this, bundle));
                            }else
                                throw new AbnormalExecutionError();
                            
                            setBundleStateAndNotify(bundle, Bundle.STARTING);
                            break;
                    }
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2127, 84283, 84288)) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2128, 84365, 84370)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2128, 84365, 84370);
                        final BundleRevisionImpl npe_invocation_var199 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 2128, 84365, 84370).adapt(BundleRevision.class)));
                        if (CallChecker.beforeDeref(npe_invocation_var199, BundleRevisionImpl.class, 2128, 84365, 84398)) {
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2130, 84531, 84536)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2130, 84531, 84536);
                                final BundleWiring npe_invocation_var200 = CallChecker.isCalled(bundle, BundleImpl.class, 2130, 84531, 84536).adapt(BundleWiring.class);
                                if (CallChecker.beforeDeref(npe_invocation_var200, BundleWiring.class, 2130, 84531, 84562)) {
                                    final BundleWiringImpl.BundleClassLoader npe_invocation_var201 = ((BundleWiringImpl.BundleClassLoader) (CallChecker.isCalled(npe_invocation_var200, BundleWiring.class, 2130, 84531, 84562).getClassLoader()));
                                    if (CallChecker.beforeDeref(npe_invocation_var201, BundleWiringImpl.BundleClassLoader.class, 2130, 84531, 84579)) {
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2127, 84283, 84288);
                                        if (((!(CallChecker.isCalled(bundle, BundleImpl.class, 2127, 84283, 84288).isDeclaredActivationPolicyUsed())) || ((CallChecker.isCalled(npe_invocation_var199, BundleRevisionImpl.class, 2128, 84365, 84398).getDeclaredActivationPolicy()) != (BundleRevisionImpl.LAZY_ACTIVATION))) || (CallChecker.isCalled(npe_invocation_var201, BundleWiringImpl.BundleClassLoader.class, 2130, 84531, 84579).isActivationTriggered())) {
                                            eventType = BundleEvent.STARTED;
                                            CallChecker.varAssign(eventType, "eventType", 2134, 84733, 84764);
                                            TryContext _bcornu_try_context_186 = new TryContext(186, Felix.class, "org.osgi.framework.BundleException");
                                            try {
                                                activateBundle(bundle, false);
                                            } catch (BundleException ex) {
                                                _bcornu_try_context_186.catchStart(186);
                                                rethrow = ex;
                                                CallChecker.varAssign(rethrow, "rethrow", 2142, 85044, 85056);
                                            } finally {
                                                _bcornu_try_context_186.finallyStart(186);
                                            }
                                        }else {
                                            eventType = BundleEvent.LAZY_ACTIVATION;
                                            CallChecker.varAssign(eventType, "eventType", 2149, 85250, 85289);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } finally {
                _bcornu_try_context_187.finallyStart(187);
                releaseBundleLock(bundle);
            }
            if (rethrow == null) {
                fireBundleEvent(eventType, bundle);
            }else {
                fireBundleEvent(BundleEvent.STOPPED, bundle);
                throw rethrow;
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context633.methodEnd();
        }
    }

    void activateBundle(BundleImpl bundle, boolean fireEvent) throws BundleException {
        MethodContext _bcornu_methode_context634 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 2175, 85979, 90750);
            CallChecker.varInit(fireEvent, "fireEvent", 2175, 85979, 90750);
            CallChecker.varInit(bundle, "bundle", 2175, 85979, 90750);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 2175, 85979, 90750);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 2175, 85979, 90750);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 2175, 85979, 90750);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 2175, 85979, 90750);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 2175, 85979, 90750);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 2175, 85979, 90750);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 2175, 85979, 90750);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 2175, 85979, 90750);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 2175, 85979, 90750);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 2175, 85979, 90750);
            CallChecker.varInit(this.m_registry, "m_registry", 2175, 85979, 90750);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 2175, 85979, 90750);
            CallChecker.varInit(this.m_nextId, "m_nextId", 2175, 85979, 90750);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 2175, 85979, 90750);
            CallChecker.varInit(this.m_cache, "m_cache", 2175, 85979, 90750);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 2175, 85979, 90750);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 2175, 85979, 90750);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 2175, 85979, 90750);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 2175, 85979, 90750);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 2175, 85979, 90750);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 2175, 85979, 90750);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 2175, 85979, 90750);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 2175, 85979, 90750);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 2175, 85979, 90750);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 2175, 85979, 90750);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 2175, 85979, 90750);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 2175, 85979, 90750);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 2175, 85979, 90750);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 2175, 85979, 90750);
            CallChecker.varInit(this.m_resolver, "m_resolver", 2175, 85979, 90750);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 2175, 85979, 90750);
            CallChecker.varInit(this.m_configMap, "m_configMap", 2175, 85979, 90750);
            CallChecker.varInit(this.m_logger, "m_logger", 2175, 85979, 90750);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 2175, 85979, 90750);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 2175, 85979, 90750);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 2175, 85979, 90750);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 2175, 85979, 90750);
            TryContext _bcornu_try_context_188 = new TryContext(188, Felix.class, "java.lang.IllegalStateException");
            try {
                acquireBundleLock(bundle, ((Bundle.STARTING) | (Bundle.ACTIVE)));
            } catch (IllegalStateException ex) {
                _bcornu_try_context_188.catchStart(188);
                throw new IllegalStateException("Activation only occurs for bundles in STARTING state.");
            } finally {
                _bcornu_try_context_188.finallyStart(188);
            }
            TryContext _bcornu_try_context_190 = new TryContext(190, Felix.class);
            try {
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2203, 87270, 87275)) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2204, 87326, 87331)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2203, 87270, 87275);
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2204, 87326, 87331);
                        if (((CallChecker.isCalled(bundle, BundleImpl.class, 2203, 87270, 87275).getState()) == (Bundle.ACTIVE)) || ((CallChecker.isCalled(bundle, BundleImpl.class, 2204, 87326, 87331).getStartLevel(getInitialBundleStartLevel())) > (m_targetStartLevel))) {
                            return ;
                        }
                    }
                }
                fireBundleEvent(BundleEvent.STARTING, bundle);
                TryContext _bcornu_try_context_189 = new TryContext(189, Felix.class, "java.lang.Throwable");
                try {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2215, 87678, 87683)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2215, 87678, 87683);
                        CallChecker.isCalled(bundle, BundleImpl.class, 2215, 87678, 87683).setActivator(createBundleActivator(bundle));
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2218, 87814, 87819)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2218, 87814, 87819);
                        if ((CallChecker.isCalled(bundle, BundleImpl.class, 2218, 87814, 87819).getActivator()) != null) {
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2221, 87938, 87943)) {
                                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2221, 87961, 87966)) {
                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 2220, 87883, 87896)) {
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2221, 87938, 87943);
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2221, 87961, 87966);
                                        CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 2220, 87883, 87896).startActivator(CallChecker.isCalled(bundle, BundleImpl.class, 2221, 87938, 87943).getActivator(), CallChecker.isCalled(bundle, BundleImpl.class, 2221, 87961, 87966)._getBundleContext());
                                    }
                                }
                            }
                        }
                    }
                    setBundleStateAndNotify(bundle, Bundle.ACTIVE);
                } catch (Throwable th) {
                    _bcornu_try_context_189.catchStart(189);
                    fireBundleEvent(BundleEvent.STOPPING, bundle);
                    setBundleStateAndNotify(bundle, Bundle.RESOLVED);
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2239, 88642, 88647)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2239, 88642, 88647);
                        CallChecker.isCalled(bundle, BundleImpl.class, 2239, 88642, 88647).setActivator(null);
                    }
                    BundleContextImpl bci = CallChecker.init(BundleContextImpl.class);
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2244, 88902, 88907)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2244, 88902, 88907);
                        bci = ((BundleContextImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 2244, 88902, 88907)._getBundleContext()));
                        CallChecker.varAssign(bci, "bci", 2244, 88902, 88907);
                    }
                    if (CallChecker.beforeDeref(bci, BundleContextImpl.class, 2245, 88946, 88948)) {
                        bci = CallChecker.beforeCalled(bci, BundleContextImpl.class, 2245, 88946, 88948);
                        CallChecker.isCalled(bci, BundleContextImpl.class, 2245, 88946, 88948).invalidate();
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2246, 88980, 88985)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2246, 88980, 88985);
                        CallChecker.isCalled(bundle, BundleImpl.class, 2246, 88980, 88985).setBundleContext(null);
                    }
                    if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 2249, 89095, 89104)) {
                        CallChecker.isCalled(m_registry, ServiceRegistry.class, 2249, 89095, 89104).unregisterServices(bundle);
                    }
                    if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 2252, 89218, 89227)) {
                        CallChecker.isCalled(m_registry, ServiceRegistry.class, 2252, 89218, 89227).ungetServices(bundle);
                    }
                    if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 2255, 89336, 89347)) {
                        CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 2255, 89336, 89347).removeListeners(bci);
                    }
                    if (th instanceof BundleException) {
                        throw ((BundleException) (th));
                    }else
                        if (((System.getSecurityManager()) != null) && (th instanceof java.security.PrivilegedActionException)) {
                            th = ((java.security.PrivilegedActionException) (th)).getException();
                            CallChecker.varAssign(th, "th", 2266, 89817, 89883);
                        }
                    
                    throw new BundleException((("Activator start error in bundle " + bundle) + "."), BundleException.ACTIVATOR_ERROR, th);
                } finally {
                    _bcornu_try_context_189.finallyStart(189);
                }
            } finally {
                _bcornu_try_context_190.finallyStart(190);
                releaseBundleLock(bundle);
            }
            if (fireEvent) {
                fireBundleEvent(BundleEvent.STARTED, bundle);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context634.methodEnd();
        }
    }

    void updateBundle(BundleImpl bundle, InputStream is) throws BundleException {
        MethodContext _bcornu_methode_context635 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 2292, 90757, 98986);
            CallChecker.varInit(is, "is", 2292, 90757, 98986);
            CallChecker.varInit(bundle, "bundle", 2292, 90757, 98986);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 2292, 90757, 98986);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 2292, 90757, 98986);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 2292, 90757, 98986);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 2292, 90757, 98986);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 2292, 90757, 98986);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 2292, 90757, 98986);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 2292, 90757, 98986);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 2292, 90757, 98986);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 2292, 90757, 98986);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 2292, 90757, 98986);
            CallChecker.varInit(this.m_registry, "m_registry", 2292, 90757, 98986);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 2292, 90757, 98986);
            CallChecker.varInit(this.m_nextId, "m_nextId", 2292, 90757, 98986);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 2292, 90757, 98986);
            CallChecker.varInit(this.m_cache, "m_cache", 2292, 90757, 98986);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 2292, 90757, 98986);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 2292, 90757, 98986);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 2292, 90757, 98986);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 2292, 90757, 98986);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 2292, 90757, 98986);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 2292, 90757, 98986);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 2292, 90757, 98986);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 2292, 90757, 98986);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 2292, 90757, 98986);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 2292, 90757, 98986);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 2292, 90757, 98986);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 2292, 90757, 98986);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 2292, 90757, 98986);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 2292, 90757, 98986);
            CallChecker.varInit(this.m_resolver, "m_resolver", 2292, 90757, 98986);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 2292, 90757, 98986);
            CallChecker.varInit(this.m_configMap, "m_configMap", 2292, 90757, 98986);
            CallChecker.varInit(this.m_logger, "m_logger", 2292, 90757, 98986);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 2292, 90757, 98986);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 2292, 90757, 98986);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 2292, 90757, 98986);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 2292, 90757, 98986);
            TryContext _bcornu_try_context_191 = new TryContext(191, Felix.class, "java.lang.IllegalStateException");
            try {
                acquireBundleLock(bundle, (((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.ACTIVE)));
            } catch (IllegalStateException ex) {
                _bcornu_try_context_191.catchStart(191);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2302, 91069, 91074)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2302, 91069, 91074);
                    if ((CallChecker.isCalled(bundle, BundleImpl.class, 2302, 91069, 91074).getState()) == (Bundle.UNINSTALLED)) {
                        throw new IllegalStateException("Cannot update an uninstalled bundle.");
                    }else {
                        throw new BundleException((("Bundle " + bundle) + " cannot be update, since it is either starting or stopping."));
                    }
                }
            } finally {
                _bcornu_try_context_191.finallyStart(191);
            }
            TryContext _bcornu_try_context_199 = new TryContext(199, Felix.class);
            try {
                Throwable rethrow = CallChecker.varInit(null, "rethrow", 2319, 91660, 91684);
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2321, 91720, 91725);
                final int oldState = CallChecker.varInit(((int) (CallChecker.isCalled(bundle, BundleImpl.class, 2321, 91720, 91725).getState())), "oldState", 2321, 91699, 91737);
                String updateLocation = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2325, 91880, 91885)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2325, 91880, 91885);
                    final BundleRevisionImpl npe_invocation_var202 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 2325, 91880, 91885).adapt(BundleRevision.class)));
                    if (CallChecker.beforeDeref(npe_invocation_var202, BundleRevisionImpl.class, 2325, 91880, 91913)) {
                        final Map npe_invocation_var203 = CallChecker.isCalled(npe_invocation_var202, BundleRevisionImpl.class, 2325, 91880, 91913).getHeaders();
                        if (CallChecker.beforeDeref(npe_invocation_var203, Map.class, 2325, 91858, 91948)) {
                            updateLocation = ((String) (CallChecker.isCalled(npe_invocation_var203, Map.class, 2325, 91858, 91948).get(Constants.BUNDLE_UPDATELOCATION)));
                            CallChecker.varAssign(updateLocation, "updateLocation", 2325, 91880, 91885);
                        }
                    }
                }
                if (updateLocation == null) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2331, 92147, 92152)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2331, 92147, 92152);
                        updateLocation = CallChecker.isCalled(bundle, BundleImpl.class, 2331, 92147, 92152)._getLocation();
                        CallChecker.varAssign(updateLocation, "updateLocation", 2331, 92130, 92168);
                    }
                }
                if (oldState == (Bundle.ACTIVE)) {
                    stopBundle(bundle, false);
                }
                TryContext _bcornu_try_context_195 = new TryContext(195, Felix.class, "java.lang.Throwable");
                try {
                    boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 2346, 92638, 92674);
                    if (!locked) {
                        throw new BundleException("Cannot acquire global lock to update the bundle.");
                    }
                    TryContext _bcornu_try_context_194 = new TryContext(194, Felix.class);
                    try {
                        boolean wasExtension = CallChecker.init(boolean.class);
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2355, 92984, 92989)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2355, 92984, 92989);
                            wasExtension = CallChecker.isCalled(bundle, BundleImpl.class, 2355, 92984, 92989).isExtension();
                            CallChecker.varAssign(wasExtension, "wasExtension", 2355, 92984, 92989);
                        }
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2356, 93026, 93031)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2356, 93026, 93031);
                            CallChecker.isCalled(bundle, BundleImpl.class, 2356, 93026, 93031).revise(updateLocation, is);
                        }
                        TryContext _bcornu_try_context_193 = new TryContext(193, Felix.class, "java.lang.Throwable");
                        try {
                            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 2361, 93179, 93218);
                            if (sm != null) {
                                ((SecurityManager) (sm)).checkPermission(new AdminPermission(bundle, AdminPermission.LIFECYCLE));
                            }
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2371, 93654, 93659)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2371, 93654, 93659);
                                if ((!wasExtension) && (CallChecker.isCalled(bundle, BundleImpl.class, 2371, 93654, 93659).isExtension())) {
                                    if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 2373, 93730, 93747)) {
                                        CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 2373, 93730, 93747).addExtensionBundle(this, bundle);
                                    }
                                    if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 2375, 93905, 93922)) {
                                        if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 2375, 93882, 93891)) {
                                            CallChecker.isCalled(m_resolver, StatefulResolver.class, 2375, 93882, 93891).addRevision(CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 2375, 93905, 93922).getRevision());
                                        }
                                    }
                                    setBundleStateAndNotify(bundle, Bundle.RESOLVED);
                                }else
                                    if (wasExtension) {
                                        setBundleStateAndNotify(bundle, Bundle.INSTALLED);
                                    }
                                
                            }
                        } catch (Throwable ex) {
                            _bcornu_try_context_193.catchStart(193);
                            TryContext _bcornu_try_context_192 = new TryContext(192, Felix.class, "java.lang.Exception");
                            try {
                                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2388, 94488, 94493)) {
                                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2388, 94488, 94493);
                                    CallChecker.isCalled(bundle, BundleImpl.class, 2388, 94488, 94493).rollbackRevise();
                                }
                            } catch (Exception busted) {
                                _bcornu_try_context_192.catchStart(192);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 2392, 94642, 94649)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 2392, 94642, 94649).log(bundle, Logger.LOG_ERROR, "Unable to rollback.", busted);
                                }
                            } finally {
                                _bcornu_try_context_192.finallyStart(192);
                            }
                            throw ex;
                        } finally {
                            _bcornu_try_context_193.finallyStart(193);
                        }
                    } finally {
                        _bcornu_try_context_194.finallyStart(194);
                        releaseGlobalLock();
                    }
                } catch (Throwable ex) {
                    _bcornu_try_context_195.catchStart(195);
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 2407, 95080, 95087)) {
                        CallChecker.isCalled(m_logger, Logger.class, 2407, 95080, 95087).log(bundle, Logger.LOG_ERROR, "Unable to update the bundle.", ex);
                    }
                    rethrow = ex;
                    CallChecker.varAssign(rethrow, "rethrow", 2409, 95193, 95205);
                } finally {
                    _bcornu_try_context_195.finallyStart(195);
                }
                if (rethrow == null) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2416, 95395, 95400)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2416, 95395, 95400);
                        CallChecker.isCalled(bundle, BundleImpl.class, 2416, 95395, 95400).setLastModified(System.currentTimeMillis());
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2418, 95469, 95474)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2418, 95469, 95474);
                        if (!(CallChecker.isCalled(bundle, BundleImpl.class, 2418, 95469, 95474).isExtension())) {
                            setBundleStateAndNotify(bundle, Bundle.INSTALLED);
                        }else {
                            if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 2424, 95657, 95674)) {
                                CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 2424, 95657, 95674).startExtensionBundle(this, bundle);
                            }
                        }
                    }
                    fireBundleEvent(BundleEvent.UNRESOLVED, bundle);
                    fireBundleEvent(BundleEvent.UPDATED, bundle);
                    boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 2432, 95951, 95987);
                    if (locked) {
                        TryContext _bcornu_try_context_197 = new TryContext(197, Felix.class);
                        try {
                            if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 2439, 96216, 96229)) {
                                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2440, 96285, 96290)) {
                                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2440, 96285, 96290);
                                    if ((!(CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 2439, 96216, 96229).hasDependents(bundle))) && (!(CallChecker.isCalled(bundle, BundleImpl.class, 2440, 96285, 96290).isExtension()))) {
                                        TryContext _bcornu_try_context_196 = new TryContext(196, Felix.class, "java.lang.Exception");
                                        try {
                                            List<Bundle> list = CallChecker.varInit(new ArrayList<Bundle>(1), "list", 2444, 96427, 96471);
                                            if (CallChecker.beforeDeref(list, List.class, 2445, 96505, 96508)) {
                                                list = CallChecker.beforeCalled(list, List.class, 2445, 96505, 96508);
                                                CallChecker.isCalled(list, List.class, 2445, 96505, 96508).add(bundle);
                                            }
                                            refreshPackages(list, null);
                                        } catch (Exception ex) {
                                            _bcornu_try_context_196.catchStart(196);
                                            if (CallChecker.beforeDeref(m_logger, Logger.class, 2450, 96725, 96732)) {
                                                CallChecker.isCalled(m_logger, Logger.class, 2450, 96725, 96732).log(bundle, Logger.LOG_ERROR, "Unable to immediately purge the bundle revisions.", ex);
                                            }
                                        } finally {
                                            _bcornu_try_context_196.finallyStart(196);
                                        }
                                    }
                                }
                            }
                        } finally {
                            _bcornu_try_context_197.finallyStart(197);
                            releaseGlobalLock();
                        }
                    }
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2467, 97399, 97404)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2467, 97399, 97404);
                    if ((oldState == (Bundle.ACTIVE)) && (Util.isFragment(CallChecker.isCalled(bundle, BundleImpl.class, 2467, 97399, 97404).adapt(BundleRevision.class)))) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2469, 97466, 97471)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2469, 97466, 97471);
                            CallChecker.isCalled(bundle, BundleImpl.class, 2469, 97466, 97471).setPersistentStateInactive();
                        }
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 2470, 97519, 97526)) {
                            CallChecker.isCalled(m_logger, Logger.class, 2470, 97519, 97526).log(bundle, Logger.LOG_WARNING, ("Previously active bundle was updated to a fragment, resetting state to inactive: " + bundle));
                        }
                    }else
                        if (oldState == (Bundle.ACTIVE)) {
                            startBundle(bundle, Bundle.START_TRANSIENT);
                        }
                    
                }
                if (rethrow != null) {
                    if (rethrow instanceof AccessControlException) {
                        throw ((AccessControlException) (rethrow));
                    }else
                        if (rethrow instanceof BundleException) {
                            throw ((BundleException) (rethrow));
                        }else {
                            throw new BundleException((("Update of bundle " + bundle) + " failed."), rethrow);
                        }
                    
                }
            } finally {
                _bcornu_try_context_199.finallyStart(199);
                TryContext _bcornu_try_context_198 = new TryContext(198, Felix.class, "java.lang.Exception");
                try {
                    if (is != null)
                        is.close();
                    
                } catch (Exception ex) {
                    _bcornu_try_context_198.catchStart(198);
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 2508, 98805, 98812)) {
                        CallChecker.isCalled(m_logger, Logger.class, 2508, 98805, 98812).log(bundle, Logger.LOG_ERROR, "Unable to close input stream.", ex);
                    }
                } finally {
                    _bcornu_try_context_198.finallyStart(198);
                }
                releaseBundleLock(bundle);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context635.methodEnd();
        }
    }

    void stopBundle(BundleImpl bundle, boolean record) throws BundleException {
        MethodContext _bcornu_methode_context636 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 2516, 98993, 105231);
            CallChecker.varInit(record, "record", 2516, 98993, 105231);
            CallChecker.varInit(bundle, "bundle", 2516, 98993, 105231);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 2516, 98993, 105231);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 2516, 98993, 105231);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 2516, 98993, 105231);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 2516, 98993, 105231);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 2516, 98993, 105231);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 2516, 98993, 105231);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 2516, 98993, 105231);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 2516, 98993, 105231);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 2516, 98993, 105231);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 2516, 98993, 105231);
            CallChecker.varInit(this.m_registry, "m_registry", 2516, 98993, 105231);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 2516, 98993, 105231);
            CallChecker.varInit(this.m_nextId, "m_nextId", 2516, 98993, 105231);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 2516, 98993, 105231);
            CallChecker.varInit(this.m_cache, "m_cache", 2516, 98993, 105231);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 2516, 98993, 105231);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 2516, 98993, 105231);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 2516, 98993, 105231);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 2516, 98993, 105231);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 2516, 98993, 105231);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 2516, 98993, 105231);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 2516, 98993, 105231);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 2516, 98993, 105231);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 2516, 98993, 105231);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 2516, 98993, 105231);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 2516, 98993, 105231);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 2516, 98993, 105231);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 2516, 98993, 105231);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 2516, 98993, 105231);
            CallChecker.varInit(this.m_resolver, "m_resolver", 2516, 98993, 105231);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 2516, 98993, 105231);
            CallChecker.varInit(this.m_configMap, "m_configMap", 2516, 98993, 105231);
            CallChecker.varInit(this.m_logger, "m_logger", 2516, 98993, 105231);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 2516, 98993, 105231);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 2516, 98993, 105231);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 2516, 98993, 105231);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 2516, 98993, 105231);
            TryContext _bcornu_try_context_200 = new TryContext(200, Felix.class, "java.lang.IllegalStateException");
            try {
                acquireBundleLock(bundle, (((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.STARTING)) | (Bundle.ACTIVE)) | (Bundle.STOPPING)));
            } catch (IllegalStateException ex) {
                _bcornu_try_context_200.catchStart(200);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2527, 99355, 99360)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2527, 99355, 99360);
                    if ((CallChecker.isCalled(bundle, BundleImpl.class, 2527, 99355, 99360).getState()) == (Bundle.UNINSTALLED)) {
                        throw new IllegalStateException("Cannot stop an uninstalled bundle.");
                    }else {
                        throw new BundleException((("Bundle " + bundle) + " cannot be stopped since it is already stopping."));
                    }
                }
            } finally {
                _bcornu_try_context_200.finallyStart(200);
            }
            TryContext _bcornu_try_context_202 = new TryContext(202, Felix.class);
            try {
                Throwable rethrow = CallChecker.varInit(null, "rethrow", 2541, 99758, 99782);
                if (record) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2546, 99914, 99919)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2546, 99914, 99919);
                        CallChecker.isCalled(bundle, BundleImpl.class, 2546, 99914, 99919).setPersistentStateInactive();
                    }
                }
                if (!(isBundlePersistentlyStarted(bundle))) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2555, 100273, 100278)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2555, 100273, 100278);
                        CallChecker.isCalled(bundle, BundleImpl.class, 2555, 100273, 100278).setDeclaredActivationPolicyUsed(false);
                    }
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2560, 100526, 100531)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2560, 100526, 100531);
                    if (Util.isFragment(CallChecker.isCalled(bundle, BundleImpl.class, 2560, 100526, 100531).adapt(BundleRevision.class))) {
                        throw new BundleException(("Fragment bundles can not be stopped: " + bundle));
                    }
                }
                boolean wasActive = CallChecker.varInit(((boolean) (false)), "wasActive", 2565, 100697, 100722);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2566, 100744, 100749)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2566, 100744, 100749);
                    switch (CallChecker.isCalled(bundle, BundleImpl.class, 2566, 100744, 100749).getState()) {
                        case Bundle.UNINSTALLED :
                            throw new IllegalStateException("Cannot stop an uninstalled bundle.");
                        case Bundle.STARTING :
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2571, 100971, 100976)) {
                                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2572, 101060, 101065)) {
                                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2572, 101060, 101065);
                                    final BundleRevisionImpl npe_invocation_var204 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 2572, 101060, 101065).adapt(BundleRevision.class)));
                                    if (CallChecker.beforeDeref(npe_invocation_var204, BundleRevisionImpl.class, 2572, 101060, 101093)) {
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2571, 100971, 100976);
                                        if ((CallChecker.isCalled(bundle, BundleImpl.class, 2571, 100971, 100976).isDeclaredActivationPolicyUsed()) && ((CallChecker.isCalled(npe_invocation_var204, BundleRevisionImpl.class, 2572, 101060, 101093).getDeclaredActivationPolicy()) != (BundleRevisionImpl.LAZY_ACTIVATION))) {
                                            throw new BundleException("Stopping a starting or stopping bundle is currently not supported.");
                                        }
                                    }
                                }
                            }
                            break;
                        case Bundle.STOPPING :
                            throw new BundleException("Stopping a starting or stopping bundle is currently not supported.");
                        case Bundle.INSTALLED :
                        case Bundle.RESOLVED :
                            return ;
                        case Bundle.ACTIVE :
                            wasActive = true;
                            CallChecker.varAssign(wasActive, "wasActive", 2586, 101756, 101772);
                            break;
                    }
                }
                setBundleStateAndNotify(bundle, Bundle.STOPPING);
                fireBundleEvent(BundleEvent.STOPPING, bundle);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2598, 102308, 102313)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2598, 102308, 102313);
                    if (wasActive || ((CallChecker.isCalled(bundle, BundleImpl.class, 2598, 102308, 102313).getBundleId()) == 0)) {
                        TryContext _bcornu_try_context_201 = new TryContext(201, Felix.class, "java.lang.Throwable");
                        try {
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2602, 102412, 102417)) {
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2602, 102412, 102417);
                                if ((CallChecker.isCalled(bundle, BundleImpl.class, 2602, 102412, 102417).getActivator()) != null) {
                                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2604, 102518, 102523)) {
                                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2604, 102541, 102546)) {
                                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 2604, 102489, 102502)) {
                                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2604, 102518, 102523);
                                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2604, 102541, 102546);
                                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 2604, 102489, 102502).stopActivator(CallChecker.isCalled(bundle, BundleImpl.class, 2604, 102518, 102523).getActivator(), CallChecker.isCalled(bundle, BundleImpl.class, 2604, 102541, 102546)._getBundleContext());
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            _bcornu_try_context_201.catchStart(201);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 2609, 102685, 102692)) {
                                CallChecker.isCalled(m_logger, Logger.class, 2609, 102685, 102692).log(bundle, Logger.LOG_ERROR, "Error stopping bundle.", th);
                            }
                            rethrow = th;
                            CallChecker.varAssign(rethrow, "rethrow", 2610, 102775, 102787);
                        } finally {
                            _bcornu_try_context_201.finallyStart(201);
                        }
                    }
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2616, 102945, 102950)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2616, 102945, 102950);
                    if ((CallChecker.isCalled(bundle, BundleImpl.class, 2616, 102945, 102950).getBundleId()) != 0) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2619, 103052, 103057)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2619, 103052, 103057);
                            CallChecker.isCalled(bundle, BundleImpl.class, 2619, 103052, 103057).setActivator(null);
                        }
                        BundleContextImpl bci = CallChecker.init(BundleContextImpl.class);
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2624, 103312, 103317)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2624, 103312, 103317);
                            bci = ((BundleContextImpl) (CallChecker.isCalled(bundle, BundleImpl.class, 2624, 103312, 103317)._getBundleContext()));
                            CallChecker.varAssign(bci, "bci", 2624, 103312, 103317);
                        }
                        if (CallChecker.beforeDeref(bci, BundleContextImpl.class, 2625, 103356, 103358)) {
                            bci = CallChecker.beforeCalled(bci, BundleContextImpl.class, 2625, 103356, 103358);
                            CallChecker.isCalled(bci, BundleContextImpl.class, 2625, 103356, 103358).invalidate();
                        }
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2626, 103390, 103395)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2626, 103390, 103395);
                            CallChecker.isCalled(bundle, BundleImpl.class, 2626, 103390, 103395).setBundleContext(null);
                        }
                        if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 2629, 103505, 103514)) {
                            CallChecker.isCalled(m_registry, ServiceRegistry.class, 2629, 103505, 103514).unregisterServices(bundle);
                        }
                        if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 2632, 103628, 103637)) {
                            CallChecker.isCalled(m_registry, ServiceRegistry.class, 2632, 103628, 103637).ungetServices(bundle);
                        }
                        if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 2636, 103804, 103815)) {
                            CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 2636, 103804, 103815).removeListeners(bci);
                        }
                        setBundleStateAndNotify(bundle, Bundle.RESOLVED);
                    }
                }
                if (rethrow != null) {
                    if (rethrow instanceof BundleException) {
                        throw ((BundleException) (rethrow));
                    }else
                        if (((System.getSecurityManager()) != null) && (rethrow instanceof java.security.PrivilegedActionException)) {
                            rethrow = ((java.security.PrivilegedActionException) (rethrow)).getException();
                            CallChecker.varAssign(rethrow, "rethrow", 2656, 104622, 104698);
                        }
                    
                    throw new BundleException((("Activator stop error in bundle " + bundle) + "."), rethrow);
                }
            } finally {
                _bcornu_try_context_202.finallyStart(202);
                releaseBundleLock(bundle);
            }
            fireBundleEvent(BundleEvent.STOPPED, bundle);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context636.methodEnd();
        }
    }

    void uninstallBundle(BundleImpl bundle) throws BundleException {
        MethodContext _bcornu_methode_context637 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 2675, 105238, 111122);
            CallChecker.varInit(bundle, "bundle", 2675, 105238, 111122);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 2675, 105238, 111122);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 2675, 105238, 111122);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 2675, 105238, 111122);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 2675, 105238, 111122);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 2675, 105238, 111122);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 2675, 105238, 111122);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 2675, 105238, 111122);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 2675, 105238, 111122);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 2675, 105238, 111122);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 2675, 105238, 111122);
            CallChecker.varInit(this.m_registry, "m_registry", 2675, 105238, 111122);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 2675, 105238, 111122);
            CallChecker.varInit(this.m_nextId, "m_nextId", 2675, 105238, 111122);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 2675, 105238, 111122);
            CallChecker.varInit(this.m_cache, "m_cache", 2675, 105238, 111122);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 2675, 105238, 111122);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 2675, 105238, 111122);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 2675, 105238, 111122);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 2675, 105238, 111122);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 2675, 105238, 111122);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 2675, 105238, 111122);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 2675, 105238, 111122);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 2675, 105238, 111122);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 2675, 105238, 111122);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 2675, 105238, 111122);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 2675, 105238, 111122);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 2675, 105238, 111122);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 2675, 105238, 111122);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 2675, 105238, 111122);
            CallChecker.varInit(this.m_resolver, "m_resolver", 2675, 105238, 111122);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 2675, 105238, 111122);
            CallChecker.varInit(this.m_configMap, "m_configMap", 2675, 105238, 111122);
            CallChecker.varInit(this.m_logger, "m_logger", 2675, 105238, 111122);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 2675, 105238, 111122);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 2675, 105238, 111122);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 2675, 105238, 111122);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 2675, 105238, 111122);
            TryContext _bcornu_try_context_203 = new TryContext(203, Felix.class, "java.lang.IllegalStateException");
            try {
                acquireBundleLock(bundle, (((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.STARTING)) | (Bundle.ACTIVE)) | (Bundle.STOPPING)));
            } catch (IllegalStateException ex) {
                _bcornu_try_context_203.catchStart(203);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2685, 105581, 105586)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2685, 105581, 105586);
                    if ((CallChecker.isCalled(bundle, BundleImpl.class, 2685, 105581, 105586).getState()) == (Bundle.UNINSTALLED)) {
                        throw new IllegalStateException("Cannot uninstall an uninstalled bundle.");
                    }else {
                        throw new BundleException((("Bundle " + bundle) + " cannot be uninstalled since it is stopping."));
                    }
                }
            } finally {
                _bcornu_try_context_203.finallyStart(203);
            }
            TryContext _bcornu_try_context_206 = new TryContext(206, Felix.class);
            try {
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2702, 106167, 106172)) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2702, 106192, 106197)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2702, 106167, 106172);
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2702, 106192, 106197);
                        if ((!(CallChecker.isCalled(bundle, BundleImpl.class, 2702, 106167, 106172).isExtension())) && ((CallChecker.isCalled(bundle, BundleImpl.class, 2702, 106192, 106197).getState()) == (Bundle.ACTIVE))) {
                            TryContext _bcornu_try_context_204 = new TryContext(204, Felix.class, "org.osgi.framework.BundleException");
                            try {
                                stopBundle(bundle, true);
                            } catch (BundleException ex) {
                                _bcornu_try_context_204.catchStart(204);
                                fireFrameworkEvent(FrameworkEvent.ERROR, bundle, ex);
                            } finally {
                                _bcornu_try_context_204.finallyStart(204);
                            }
                        }
                    }
                }
                BundleImpl target = CallChecker.varInit(null, "target", 2715, 106582, 106606);
                boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 2717, 106656, 106692);
                if (!locked) {
                    throw new IllegalStateException("Unable to acquire global lock to remove bundle.");
                }
                TryContext _bcornu_try_context_205 = new TryContext(205, Felix.class);
                try {
                    Map[] maps = CallChecker.init(Map[].class);
                    if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 2730, 107234, 107251)) {
                        if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 2731, 107323, 107340)) {
                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 2730, 107234, 107251);
                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 2731, 107323, 107340);
                            maps = new Map[]{ new HashMap<String, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 2730, 107234, 107251)[Felix.LOCATION_MAP_IDX]) , new TreeMap<Long, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 2731, 107323, 107340)[Felix.IDENTIFIER_MAP_IDX]) };
                            CallChecker.varAssign(maps, "maps", 2730, 107234, 107251);
                        }
                    }
                    if (CallChecker.beforeDeref(maps, Map[].class, 2733, 107420, 107423)) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2733, 107450, 107455)) {
                            maps = CallChecker.beforeCalled(maps, Map[].class, 2733, 107420, 107423);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 2733, 107420, 107423)[Felix.LOCATION_MAP_IDX], Map.class, 2733, 107420, 107441)) {
                                maps = CallChecker.beforeCalled(maps, Map[].class, 2733, 107420, 107423);
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2733, 107450, 107455);
                                CallChecker.isCalled(maps, Map[].class, 2733, 107420, 107423)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 2733, 107420, 107423)[Felix.LOCATION_MAP_IDX], Map.class, 2733, 107420, 107441);
                                target = ((BundleImpl) (CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 2733, 107420, 107423)[Felix.LOCATION_MAP_IDX], Map.class, 2733, 107420, 107441).remove(CallChecker.isCalled(bundle, BundleImpl.class, 2733, 107450, 107455)._getLocation())));
                                CallChecker.varAssign(target, "target", 2733, 107398, 107472);
                            }
                        }
                    }
                    if (target != null) {
                        if (CallChecker.beforeDeref(maps, Map[].class, 2736, 107548, 107551)) {
                            maps = CallChecker.beforeCalled(maps, Map[].class, 2736, 107548, 107551);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 2736, 107548, 107551)[Felix.IDENTIFIER_MAP_IDX], Map.class, 2736, 107548, 107571)) {
                                maps = CallChecker.beforeCalled(maps, Map[].class, 2736, 107548, 107551);
                                CallChecker.isCalled(maps, Map[].class, 2736, 107548, 107551)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 2736, 107548, 107551)[Felix.IDENTIFIER_MAP_IDX], Map.class, 2736, 107548, 107571);
                                CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 2736, 107548, 107551)[Felix.IDENTIFIER_MAP_IDX], Map.class, 2736, 107548, 107571).remove(new Long(target.getBundleId()));
                            }
                        }
                        m_installedBundles = maps;
                        CallChecker.varAssign(this.m_installedBundles, "this.m_installedBundles", 2737, 107633, 107658);
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2740, 107754, 107759)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2740, 107754, 107759);
                            CallChecker.isCalled(bundle, BundleImpl.class, 2740, 107754, 107759).setPersistentStateUninstalled();
                        }
                        rememberUninstalledBundle(bundle);
                    }
                } finally {
                    _bcornu_try_context_205.finallyStart(205);
                    releaseGlobalLock();
                }
                if (target == null) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 2753, 108093, 108100)) {
                        CallChecker.isCalled(m_logger, Logger.class, 2753, 108093, 108100).log(bundle, Logger.LOG_ERROR, "Unable to remove bundle from installed map!");
                    }
                }
                setBundleStateAndNotify(bundle, Bundle.INSTALLED);
                fireBundleEvent(BundleEvent.UNRESOLVED, bundle);
                setBundleStateAndNotify(bundle, Bundle.UNINSTALLED);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2765, 108598, 108603)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2765, 108598, 108603);
                    CallChecker.isCalled(bundle, BundleImpl.class, 2765, 108598, 108603).setLastModified(System.currentTimeMillis());
                }
            } finally {
                _bcornu_try_context_206.finallyStart(206);
                releaseBundleLock(bundle);
            }
            fireBundleEvent(BundleEvent.UNINSTALLED, bundle);
            boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 2777, 108973, 109009);
            if (locked) {
                List<Bundle> refreshCandidates = CallChecker.varInit(new ArrayList<Bundle>(), "refreshCandidates", 2782, 109219, 109275);
                if (CallChecker.beforeDeref(refreshCandidates, List.class, 2783, 109289, 109305)) {
                    refreshCandidates = CallChecker.beforeCalled(refreshCandidates, List.class, 2783, 109289, 109305);
                    CallChecker.isCalled(refreshCandidates, List.class, 2783, 109289, 109305).add(bundle);
                }
                BundleRevisions bundleRevisions = CallChecker.init(BundleRevisions.class);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2784, 109424, 109429)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2784, 109424, 109429);
                    bundleRevisions = CallChecker.isCalled(bundle, BundleImpl.class, 2784, 109424, 109429).adapt(BundleRevisions.class);
                    CallChecker.varAssign(bundleRevisions, "bundleRevisions", 2784, 109424, 109429);
                }
                if (bundleRevisions != null) {
                    for (BundleRevision br : bundleRevisions.getRevisions()) {
                        BundleWiring bw = CallChecker.init(BundleWiring.class);
                        if (CallChecker.beforeDeref(br, BundleRevision.class, 2789, 109645, 109646)) {
                            bw = CallChecker.isCalled(br, BundleRevision.class, 2789, 109645, 109646).getWiring();
                            CallChecker.varAssign(bw, "bw", 2789, 109645, 109646);
                        }
                        if (bw != null) {
                            for (BundleWire wire : bw.getRequiredWires(null)) {
                                Bundle b = CallChecker.init(Bundle.class);
                                if (CallChecker.beforeDeref(wire, BundleWire.class, 2794, 109858, 109861)) {
                                    final BundleRevision npe_invocation_var205 = CallChecker.isCalled(wire, BundleWire.class, 2794, 109858, 109861).getProvider();
                                    if (CallChecker.beforeDeref(npe_invocation_var205, BundleRevision.class, 2794, 109858, 109875)) {
                                        b = CallChecker.isCalled(npe_invocation_var205, BundleRevision.class, 2794, 109858, 109875).getBundle();
                                        CallChecker.varAssign(b, "b", 2794, 109858, 109861);
                                    }
                                }
                                if (CallChecker.beforeDeref(b, Bundle.class, 2795, 109944, 109944)) {
                                    if (CallChecker.beforeDeref(refreshCandidates, List.class, 2795, 109961, 109977)) {
                                        b = CallChecker.beforeCalled(b, Bundle.class, 2795, 109944, 109944);
                                        refreshCandidates = CallChecker.beforeCalled(refreshCandidates, List.class, 2795, 109961, 109977);
                                        if (((Bundle.UNINSTALLED) == (CallChecker.isCalled(b, Bundle.class, 2795, 109944, 109944).getState())) && (!(CallChecker.isCalled(refreshCandidates, List.class, 2795, 109961, 109977).contains(b))))
                                            if (CallChecker.beforeDeref(refreshCandidates, List.class, 2796, 110024, 110040)) {
                                                refreshCandidates = CallChecker.beforeCalled(refreshCandidates, List.class, 2796, 110024, 110040);
                                                CallChecker.isCalled(refreshCandidates, List.class, 2796, 110024, 110040).add(b);
                                            }
                                        
                                    }
                                }
                            }
                        }
                    }
                }
                TryContext _bcornu_try_context_208 = new TryContext(208, Felix.class);
                try {
                    if (CallChecker.beforeDeref(refreshCandidates, void.class, 2804, 110193, 110209)) {
                        for (Bundle b : refreshCandidates) {
                            if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 2808, 110367, 110380)) {
                                if (!(CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 2808, 110367, 110380).hasDependents(b))) {
                                    TryContext _bcornu_try_context_207 = new TryContext(207, Felix.class, "java.lang.Exception");
                                    try {
                                        List<Bundle> list = CallChecker.varInit(Collections.singletonList(b), "list", 2812, 110504, 110552);
                                        refreshPackages(list, null);
                                    } catch (Exception ex) {
                                        _bcornu_try_context_207.catchStart(207);
                                        if (CallChecker.beforeDeref(m_logger, Logger.class, 2817, 110736, 110743)) {
                                            CallChecker.isCalled(m_logger, Logger.class, 2817, 110736, 110743).log(b, Logger.LOG_ERROR, "Unable to immediately garbage collect the bundle.", ex);
                                        }
                                    } finally {
                                        _bcornu_try_context_207.finallyStart(207);
                                    }
                                }
                            }
                        }
                    }
                } finally {
                    _bcornu_try_context_208.finallyStart(208);
                    releaseGlobalLock();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context637.methodEnd();
        }
    }

    String getProperty(String key) {
        MethodContext _bcornu_methode_context638 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 2843, 111129, 111722);
            CallChecker.varInit(key, "key", 2843, 111129, 111722);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 2843, 111129, 111722);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 2843, 111129, 111722);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 2843, 111129, 111722);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 2843, 111129, 111722);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 2843, 111129, 111722);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 2843, 111129, 111722);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 2843, 111129, 111722);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 2843, 111129, 111722);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 2843, 111129, 111722);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 2843, 111129, 111722);
            CallChecker.varInit(this.m_registry, "m_registry", 2843, 111129, 111722);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 2843, 111129, 111722);
            CallChecker.varInit(this.m_nextId, "m_nextId", 2843, 111129, 111722);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 2843, 111129, 111722);
            CallChecker.varInit(this.m_cache, "m_cache", 2843, 111129, 111722);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 2843, 111129, 111722);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 2843, 111129, 111722);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 2843, 111129, 111722);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 2843, 111129, 111722);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 2843, 111129, 111722);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 2843, 111129, 111722);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 2843, 111129, 111722);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 2843, 111129, 111722);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 2843, 111129, 111722);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 2843, 111129, 111722);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 2843, 111129, 111722);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 2843, 111129, 111722);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 2843, 111129, 111722);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 2843, 111129, 111722);
            CallChecker.varInit(this.m_resolver, "m_resolver", 2843, 111129, 111722);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 2843, 111129, 111722);
            CallChecker.varInit(this.m_configMap, "m_configMap", 2843, 111129, 111722);
            CallChecker.varInit(this.m_logger, "m_logger", 2843, 111129, 111722);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 2843, 111129, 111722);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 2843, 111129, 111722);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 2843, 111129, 111722);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 2843, 111129, 111722);
            String val = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 2846, 111577, 111587)) {
                val = ((String) (CallChecker.isCalled(m_configMap, Map.class, 2846, 111577, 111587).get(key)));
                CallChecker.varAssign(val, "val", 2846, 111577, 111587);
            }
            if (val == null) {
                return System.getProperty(key);
            }else {
                return val;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context638.methodEnd();
        }
    }

    private Bundle reloadBundle(BundleArchive ba) throws BundleException {
        MethodContext _bcornu_methode_context639 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 2851, 111729, 114377);
            CallChecker.varInit(ba, "ba", 2851, 111729, 114377);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 2851, 111729, 114377);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 2851, 111729, 114377);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 2851, 111729, 114377);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 2851, 111729, 114377);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 2851, 111729, 114377);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 2851, 111729, 114377);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 2851, 111729, 114377);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 2851, 111729, 114377);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 2851, 111729, 114377);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 2851, 111729, 114377);
            CallChecker.varInit(this.m_registry, "m_registry", 2851, 111729, 114377);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 2851, 111729, 114377);
            CallChecker.varInit(this.m_nextId, "m_nextId", 2851, 111729, 114377);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 2851, 111729, 114377);
            CallChecker.varInit(this.m_cache, "m_cache", 2851, 111729, 114377);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 2851, 111729, 114377);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 2851, 111729, 114377);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 2851, 111729, 114377);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 2851, 111729, 114377);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 2851, 111729, 114377);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 2851, 111729, 114377);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 2851, 111729, 114377);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 2851, 111729, 114377);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 2851, 111729, 114377);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 2851, 111729, 114377);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 2851, 111729, 114377);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 2851, 111729, 114377);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 2851, 111729, 114377);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 2851, 111729, 114377);
            CallChecker.varInit(this.m_resolver, "m_resolver", 2851, 111729, 114377);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 2851, 111729, 114377);
            CallChecker.varInit(this.m_configMap, "m_configMap", 2851, 111729, 114377);
            CallChecker.varInit(this.m_logger, "m_logger", 2851, 111729, 114377);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 2851, 111729, 114377);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 2851, 111729, 114377);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 2851, 111729, 114377);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 2851, 111729, 114377);
            BundleImpl bundle = CallChecker.varInit(null, "bundle", 2854, 111820, 111844);
            TryContext _bcornu_try_context_209 = new TryContext(209, Felix.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(ba, BundleArchive.class, 2862, 112093, 112094)) {
                    ba = CallChecker.beforeCalled(ba, BundleArchive.class, 2862, 112093, 112094);
                    if (CallChecker.isCalled(ba, BundleArchive.class, 2862, 112093, 112094).isRemovalPending()) {
                        if (CallChecker.beforeDeref(ba, BundleArchive.class, 2864, 112146, 112147)) {
                            ba = CallChecker.beforeCalled(ba, BundleArchive.class, 2864, 112146, 112147);
                            CallChecker.isCalled(ba, BundleArchive.class, 2864, 112146, 112147).purge();
                        }
                    }
                }
            } catch (Exception ex) {
                _bcornu_try_context_209.catchStart(209);
                if (CallChecker.beforeDeref(m_logger, Logger.class, 2869, 112233, 112240)) {
                    CallChecker.isCalled(m_logger, Logger.class, 2869, 112233, 112240).log(Logger.LOG_ERROR, "Could not purge bundle.", ex);
                }
            } finally {
                _bcornu_try_context_209.finallyStart(209);
            }
            TryContext _bcornu_try_context_211 = new TryContext(211, Felix.class, "java.lang.Throwable");
            try {
                boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 2878, 112487, 112523);
                if (!locked) {
                    throw new BundleException("Unable to acquire the global lock to install the bundle.");
                }
                TryContext _bcornu_try_context_210 = new TryContext(210, Felix.class);
                try {
                    bundle = new BundleImpl(this, null, ba);
                    CallChecker.varAssign(bundle, "bundle", 2886, 112748, 112787);
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2889, 112871, 112876)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2889, 112871, 112876);
                        if (CallChecker.isCalled(bundle, BundleImpl.class, 2889, 112871, 112876).isExtension()) {
                            if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 2891, 112931, 112948)) {
                                CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 2891, 112931, 112948).addExtensionBundle(this, bundle);
                            }
                            if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 2892, 113027, 113044)) {
                                if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 2892, 113004, 113013)) {
                                    CallChecker.isCalled(m_resolver, StatefulResolver.class, 2892, 113004, 113013).addRevision(CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 2892, 113027, 113044).getRevision());
                                }
                            }
                        }
                    }
                    Map[] maps = CallChecker.init(Map[].class);
                    if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 2898, 113282, 113299)) {
                        if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 2899, 113371, 113388)) {
                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 2898, 113282, 113299);
                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 2899, 113371, 113388);
                            maps = new Map[]{ new HashMap<String, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 2898, 113282, 113299)[Felix.LOCATION_MAP_IDX]) , new TreeMap<Long, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 2899, 113371, 113388)[Felix.IDENTIFIER_MAP_IDX]) };
                            CallChecker.varAssign(maps, "maps", 2898, 113282, 113299);
                        }
                    }
                    if (CallChecker.beforeDeref(maps, Map[].class, 2901, 113446, 113449)) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2901, 113473, 113478)) {
                            maps = CallChecker.beforeCalled(maps, Map[].class, 2901, 113446, 113449);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 2901, 113446, 113449)[Felix.LOCATION_MAP_IDX], Map.class, 2901, 113446, 113467)) {
                                maps = CallChecker.beforeCalled(maps, Map[].class, 2901, 113446, 113449);
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2901, 113473, 113478);
                                CallChecker.isCalled(maps, Map[].class, 2901, 113446, 113449)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 2901, 113446, 113449)[Felix.LOCATION_MAP_IDX], Map.class, 2901, 113446, 113467);
                                CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 2901, 113446, 113449)[Felix.LOCATION_MAP_IDX], Map.class, 2901, 113446, 113467).put(CallChecker.isCalled(bundle, BundleImpl.class, 2901, 113473, 113478)._getLocation(), bundle);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(maps, Map[].class, 2902, 113521, 113524)) {
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2902, 113559, 113564)) {
                            maps = CallChecker.beforeCalled(maps, Map[].class, 2902, 113521, 113524);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 2902, 113521, 113524)[Felix.IDENTIFIER_MAP_IDX], Map.class, 2902, 113521, 113544)) {
                                maps = CallChecker.beforeCalled(maps, Map[].class, 2902, 113521, 113524);
                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2902, 113559, 113564);
                                CallChecker.isCalled(maps, Map[].class, 2902, 113521, 113524)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 2902, 113521, 113524)[Felix.IDENTIFIER_MAP_IDX], Map.class, 2902, 113521, 113544);
                                CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 2902, 113521, 113524)[Felix.IDENTIFIER_MAP_IDX], Map.class, 2902, 113521, 113544).put(new Long(CallChecker.isCalled(bundle, BundleImpl.class, 2902, 113559, 113564).getBundleId()), bundle);
                            }
                        }
                    }
                    m_installedBundles = maps;
                    CallChecker.varAssign(this.m_installedBundles, "this.m_installedBundles", 2903, 113607, 113632);
                } finally {
                    _bcornu_try_context_210.finallyStart(210);
                    releaseGlobalLock();
                }
            } catch (Throwable ex) {
                _bcornu_try_context_211.catchStart(211);
                if (ex instanceof BundleException) {
                    throw ((BundleException) (ex));
                }else
                    if (ex instanceof AccessControlException) {
                        throw ((AccessControlException) (ex));
                    }else {
                        throw new BundleException("Could not create bundle object.", ex);
                    }
                
            } finally {
                _bcornu_try_context_211.finallyStart(211);
            }
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 2927, 114240, 114245)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 2927, 114240, 114245);
                if (CallChecker.isCalled(bundle, BundleImpl.class, 2927, 114240, 114245).isExtension()) {
                    if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 2929, 114284, 114301)) {
                        CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 2929, 114284, 114301).startExtensionBundle(this, bundle);
                    }
                }
            }
            return bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context639.methodEnd();
        }
    }

    Bundle installBundle(Bundle origin, String location, InputStream is) throws BundleException {
        MethodContext _bcornu_methode_context640 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 2935, 114384, 122809);
            CallChecker.varInit(is, "is", 2935, 114384, 122809);
            CallChecker.varInit(location, "location", 2935, 114384, 122809);
            CallChecker.varInit(origin, "origin", 2935, 114384, 122809);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 2935, 114384, 122809);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 2935, 114384, 122809);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 2935, 114384, 122809);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 2935, 114384, 122809);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 2935, 114384, 122809);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 2935, 114384, 122809);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 2935, 114384, 122809);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 2935, 114384, 122809);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 2935, 114384, 122809);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 2935, 114384, 122809);
            CallChecker.varInit(this.m_registry, "m_registry", 2935, 114384, 122809);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 2935, 114384, 122809);
            CallChecker.varInit(this.m_nextId, "m_nextId", 2935, 114384, 122809);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 2935, 114384, 122809);
            CallChecker.varInit(this.m_cache, "m_cache", 2935, 114384, 122809);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 2935, 114384, 122809);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 2935, 114384, 122809);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 2935, 114384, 122809);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 2935, 114384, 122809);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 2935, 114384, 122809);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 2935, 114384, 122809);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 2935, 114384, 122809);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 2935, 114384, 122809);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 2935, 114384, 122809);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 2935, 114384, 122809);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 2935, 114384, 122809);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 2935, 114384, 122809);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 2935, 114384, 122809);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 2935, 114384, 122809);
            CallChecker.varInit(this.m_resolver, "m_resolver", 2935, 114384, 122809);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 2935, 114384, 122809);
            CallChecker.varInit(this.m_configMap, "m_configMap", 2935, 114384, 122809);
            CallChecker.varInit(this.m_logger, "m_logger", 2935, 114384, 122809);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 2935, 114384, 122809);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 2935, 114384, 122809);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 2935, 114384, 122809);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 2935, 114384, 122809);
            BundleArchive ba = CallChecker.varInit(null, "ba", 2939, 114507, 114530);
            BundleImpl existing = CallChecker.init(BundleImpl.class);
            BundleImpl bundle = CallChecker.varInit(null, "bundle", 2940, 114540, 114574);
            acquireInstallLock(location);
            TryContext _bcornu_try_context_219 = new TryContext(219, Felix.class);
            try {
                if (((getState()) == (Bundle.STOPPING)) || ((getState()) == (Bundle.UNINSTALLED))) {
                    throw new BundleException("The framework has been shutdown.");
                }
                existing = ((BundleImpl) (getBundle(location)));
                CallChecker.varAssign(existing, "existing", 2956, 115085, 115128);
                if (existing == null) {
                    long id = CallChecker.varInit(((long) (getNextId())), "id", 2960, 115250, 115271);
                    TryContext _bcornu_try_context_213 = new TryContext(213, Felix.class, "java.lang.Exception");
                    try {
                        if (CallChecker.beforeDeref(m_cache, BundleCache.class, 2965, 115389, 115395)) {
                            m_cache = CallChecker.beforeCalled(m_cache, BundleCache.class, 2965, 115389, 115395);
                            ba = CallChecker.isCalled(m_cache, BundleCache.class, 2965, 115389, 115395).create(id, getInitialBundleStartLevel(), location, is);
                            CallChecker.varAssign(ba, "ba", 2965, 115384, 115451);
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_213.catchStart(213);
                        throw new BundleException(("Unable to cache bundle: " + location), ex);
                    } finally {
                        _bcornu_try_context_213.finallyStart(213);
                        TryContext _bcornu_try_context_212 = new TryContext(212, Felix.class, "java.io.IOException");
                        try {
                            if (is != null)
                                is.close();
                            
                        } catch (IOException ex) {
                            _bcornu_try_context_212.catchStart(212);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 2980, 115910, 115917)) {
                                CallChecker.isCalled(m_logger, Logger.class, 2980, 115910, 115917).log(Logger.LOG_ERROR, "Unable to close input stream.", ex);
                            }
                        } finally {
                            _bcornu_try_context_212.finallyStart(212);
                        }
                    }
                    TryContext _bcornu_try_context_216 = new TryContext(216, Felix.class, "java.lang.Throwable");
                    try {
                        boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 2990, 116264, 116300);
                        if (!locked) {
                            throw new BundleException("Unable to acquire the global lock to install the bundle.");
                        }
                        TryContext _bcornu_try_context_214 = new TryContext(214, Felix.class);
                        try {
                            bundle = new BundleImpl(this, origin, ba);
                            CallChecker.varAssign(bundle, "bundle", 2998, 116589, 116630);
                        } finally {
                            _bcornu_try_context_214.finallyStart(214);
                            releaseGlobalLock();
                        }
                        if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3006, 116856, 116861)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3006, 116856, 116861);
                            if (!(CallChecker.isCalled(bundle, BundleImpl.class, 3006, 116856, 116861).isExtension())) {
                                Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 3008, 116924, 116963);
                                if (sm != null) {
                                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(bundle, AdminPermission.LIFECYCLE));
                                }
                            }else {
                                if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 3017, 117307, 117324)) {
                                    CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 3017, 117307, 117324).addExtensionBundle(this, bundle);
                                }
                                if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 3018, 117407, 117424)) {
                                    if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 3018, 117384, 117393)) {
                                        CallChecker.isCalled(m_resolver, StatefulResolver.class, 3018, 117384, 117393).addRevision(CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 3018, 117407, 117424).getRevision());
                                    }
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (Throwable ex) {
                        _bcornu_try_context_216.catchStart(216);
                        TryContext _bcornu_try_context_215 = new TryContext(215, Felix.class, "java.lang.Exception");
                        try {
                            if (bundle != null) {
                                bundle.closeAndDelete();
                            }else
                                if (ba != null) {
                                    ba.closeAndDelete();
                                }
                            
                        } catch (Exception ex1) {
                            _bcornu_try_context_215.catchStart(215);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 3037, 118041, 118048)) {
                                CallChecker.isCalled(m_logger, Logger.class, 3037, 118041, 118048).log(bundle, Logger.LOG_ERROR, "Could not remove from cache.", ex1);
                            }
                        } finally {
                            _bcornu_try_context_215.finallyStart(215);
                        }
                        if (ex instanceof BundleException) {
                            throw ((BundleException) (ex));
                        }else
                            if (ex instanceof AccessControlException) {
                                throw ((AccessControlException) (ex));
                            }else {
                                throw new BundleException("Could not create bundle object.", ex);
                            }
                        
                    } finally {
                        _bcornu_try_context_216.finallyStart(216);
                    }
                    boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 3056, 118751, 118787);
                    if (!locked) {
                        throw new IllegalStateException("Unable to acquire global lock to add bundle.");
                    }
                    TryContext _bcornu_try_context_217 = new TryContext(217, Felix.class);
                    try {
                        Map[] maps = CallChecker.init(Map[].class);
                        if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 3069, 119373, 119390)) {
                            if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 3070, 119466, 119483)) {
                                m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3069, 119373, 119390);
                                m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3070, 119466, 119483);
                                maps = new Map[]{ new HashMap<String, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 3069, 119373, 119390)[Felix.LOCATION_MAP_IDX]) , new TreeMap<Long, BundleImpl>(CallChecker.isCalled(m_installedBundles, Map[].class, 3070, 119466, 119483)[Felix.IDENTIFIER_MAP_IDX]) };
                                CallChecker.varAssign(maps, "maps", 3069, 119373, 119390);
                            }
                        }
                        if (CallChecker.beforeDeref(maps, Map[].class, 3072, 119549, 119552)) {
                            maps = CallChecker.beforeCalled(maps, Map[].class, 3072, 119549, 119552);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 3072, 119549, 119552)[Felix.LOCATION_MAP_IDX], Map.class, 3072, 119549, 119570)) {
                                maps = CallChecker.beforeCalled(maps, Map[].class, 3072, 119549, 119552);
                                CallChecker.isCalled(maps, Map[].class, 3072, 119549, 119552)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 3072, 119549, 119552)[Felix.LOCATION_MAP_IDX], Map.class, 3072, 119549, 119570);
                                CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 3072, 119549, 119552)[Felix.LOCATION_MAP_IDX], Map.class, 3072, 119549, 119570).put(location, bundle);
                            }
                        }
                        if (CallChecker.beforeDeref(maps, Map[].class, 3073, 119615, 119618)) {
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3073, 119653, 119658)) {
                                maps = CallChecker.beforeCalled(maps, Map[].class, 3073, 119615, 119618);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(maps, Map[].class, 3073, 119615, 119618)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3073, 119615, 119638)) {
                                    maps = CallChecker.beforeCalled(maps, Map[].class, 3073, 119615, 119618);
                                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3073, 119653, 119658);
                                    CallChecker.isCalled(maps, Map[].class, 3073, 119615, 119618)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(maps, Map[].class, 3073, 119615, 119618)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3073, 119615, 119638);
                                    CallChecker.isCalled(CallChecker.isCalled(maps, Map[].class, 3073, 119615, 119618)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3073, 119615, 119638).put(new Long(CallChecker.isCalled(bundle, BundleImpl.class, 3073, 119653, 119658).getBundleId()), bundle);
                                }
                            }
                        }
                        m_installedBundles = maps;
                        CallChecker.varAssign(this.m_installedBundles, "this.m_installedBundles", 3074, 119705, 119730);
                    } finally {
                        _bcornu_try_context_217.finallyStart(217);
                        releaseGlobalLock();
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3081, 119872, 119877)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3081, 119872, 119877);
                        if (CallChecker.isCalled(bundle, BundleImpl.class, 3081, 119872, 119877).isExtension()) {
                            if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 3083, 119932, 119949)) {
                                CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 3083, 119932, 119949).startExtensionBundle(this, bundle);
                            }
                        }
                    }
                }
            } finally {
                _bcornu_try_context_219.finallyStart(219);
                releaseInstallLock(location);
                TryContext _bcornu_try_context_218 = new TryContext(218, Felix.class, "java.io.IOException");
                try {
                    if (is != null)
                        is.close();
                    
                } catch (IOException ex) {
                    _bcornu_try_context_218.catchStart(218);
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 3099, 120348, 120355)) {
                        CallChecker.isCalled(m_logger, Logger.class, 3099, 120348, 120355).log(bundle, Logger.LOG_ERROR, "Unable to close input stream.", ex);
                    }
                } finally {
                    _bcornu_try_context_218.finallyStart(218);
                }
            }
            if (existing != null) {
                Set<ServiceReference<FindHook>> hooks = CallChecker.varInit(getHooks(FindHook.class), "hooks", 3108, 120586, 120730);
                if (CallChecker.beforeDeref(hooks, Set.class, 3110, 120749, 120753)) {
                    hooks = CallChecker.beforeCalled(hooks, Set.class, 3110, 120749, 120753);
                    if (!(CallChecker.isCalled(hooks, Set.class, 3110, 120749, 120753).isEmpty())) {
                        Collection<Bundle> bundles = CallChecker.varInit(new ArrayList<Bundle>(1), "bundles", 3112, 120796, 120849);
                        if (CallChecker.beforeDeref(bundles, Collection.class, 3113, 120867, 120873)) {
                            bundles = CallChecker.beforeCalled(bundles, Collection.class, 3113, 120867, 120873);
                            CallChecker.isCalled(bundles, Collection.class, 3113, 120867, 120873).add(existing);
                        }
                        bundles = new ShrinkableCollection<Bundle>(bundles);
                        CallChecker.varAssign(bundles, "bundles", 3114, 120906, 120957);
                        if (CallChecker.beforeDeref(hooks, Bundle.class, 3115, 121046, 121050)) {
                            for (ServiceReference<FindHook> hook : hooks) {
                                FindHook fh = CallChecker.varInit(getService(this, hook, false), "fh", 3117, 121091, 121166);
                                if (fh != null) {
                                    TryContext _bcornu_try_context_220 = new TryContext(220, Felix.class, "java.lang.Throwable");
                                    try {
                                        if (CallChecker.beforeDeref(origin, Bundle.class, 3123, 121381, 121386)) {
                                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3122, 121308, 121321)) {
                                                origin = CallChecker.beforeCalled(origin, Bundle.class, 3123, 121381, 121386);
                                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3122, 121308, 121321).invokeBundleFindHook(fh, CallChecker.isCalled(origin, Bundle.class, 3123, 121381, 121386).getBundleContext(), bundles);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        _bcornu_try_context_220.catchStart(220);
                                        if (CallChecker.beforeDeref(hook, ServiceReference.class, 3128, 121591, 121594)) {
                                            if (CallChecker.beforeDeref(m_logger, Logger.class, 3127, 121543, 121550)) {
                                                CallChecker.isCalled(m_logger, Logger.class, 3127, 121543, 121550).doLog(CallChecker.isCalled(hook, ServiceReference.class, 3128, 121591, 121594).getBundle(), hook, Logger.LOG_WARNING, "Problem invoking bundle hook.", th);
                                            }
                                        }
                                    } finally {
                                        _bcornu_try_context_220.finallyStart(220);
                                    }
                                }
                            }
                        }
                        if (origin != (this)) {
                            if (CallChecker.beforeDeref(bundles, Collection.class, 3143, 122296, 122302)) {
                                bundles = CallChecker.beforeCalled(bundles, Collection.class, 3143, 122296, 122302);
                                if (CallChecker.isCalled(bundles, Collection.class, 3143, 122296, 122302).isEmpty()) {
                                    throw new BundleException("Bundle installation rejected by hook.", BundleException.REJECTED_BY_HOOK);
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                fireBundleEvent(BundleEvent.INSTALLED, bundle, origin);
            }
            if (existing != null) {
                return existing;
            }else {
                return bundle;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context640.methodEnd();
        }
    }

    Bundle getBundle(String location) {
        MethodContext _bcornu_methode_context641 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 3169, 122816, 123197);
            CallChecker.varInit(location, "location", 3169, 122816, 123197);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3169, 122816, 123197);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3169, 122816, 123197);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3169, 122816, 123197);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3169, 122816, 123197);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3169, 122816, 123197);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3169, 122816, 123197);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3169, 122816, 123197);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3169, 122816, 123197);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3169, 122816, 123197);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3169, 122816, 123197);
            CallChecker.varInit(this.m_registry, "m_registry", 3169, 122816, 123197);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3169, 122816, 123197);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3169, 122816, 123197);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3169, 122816, 123197);
            CallChecker.varInit(this.m_cache, "m_cache", 3169, 122816, 123197);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3169, 122816, 123197);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3169, 122816, 123197);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3169, 122816, 123197);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3169, 122816, 123197);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3169, 122816, 123197);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3169, 122816, 123197);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3169, 122816, 123197);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3169, 122816, 123197);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3169, 122816, 123197);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3169, 122816, 123197);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3169, 122816, 123197);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3169, 122816, 123197);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3169, 122816, 123197);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3169, 122816, 123197);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3169, 122816, 123197);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3169, 122816, 123197);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3169, 122816, 123197);
            CallChecker.varInit(this.m_logger, "m_logger", 3169, 122816, 123197);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3169, 122816, 123197);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3169, 122816, 123197);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3169, 122816, 123197);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3169, 122816, 123197);
            if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 3171, 123141, 123158)) {
                m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3171, 123141, 123158);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_installedBundles, Map[].class, 3171, 123141, 123158)[Felix.LOCATION_MAP_IDX], Map.class, 3171, 123141, 123176)) {
                    m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3171, 123141, 123158);
                    CallChecker.isCalled(m_installedBundles, Map[].class, 3171, 123141, 123158)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3171, 123141, 123158)[Felix.LOCATION_MAP_IDX], Map.class, 3171, 123141, 123176);
                    return ((Bundle) (CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3171, 123141, 123158)[Felix.LOCATION_MAP_IDX], Map.class, 3171, 123141, 123176).get(location)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context641.methodEnd();
        }
    }

    Bundle getBundle(BundleContext bc, long id) {
        MethodContext _bcornu_methode_context642 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 3182, 123204, 125591);
            CallChecker.varInit(id, "id", 3182, 123204, 125591);
            CallChecker.varInit(bc, "bc", 3182, 123204, 125591);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3182, 123204, 125591);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3182, 123204, 125591);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3182, 123204, 125591);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3182, 123204, 125591);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3182, 123204, 125591);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3182, 123204, 125591);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3182, 123204, 125591);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3182, 123204, 125591);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3182, 123204, 125591);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3182, 123204, 125591);
            CallChecker.varInit(this.m_registry, "m_registry", 3182, 123204, 125591);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3182, 123204, 125591);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3182, 123204, 125591);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3182, 123204, 125591);
            CallChecker.varInit(this.m_cache, "m_cache", 3182, 123204, 125591);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3182, 123204, 125591);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3182, 123204, 125591);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3182, 123204, 125591);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3182, 123204, 125591);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3182, 123204, 125591);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3182, 123204, 125591);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3182, 123204, 125591);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3182, 123204, 125591);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3182, 123204, 125591);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3182, 123204, 125591);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3182, 123204, 125591);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3182, 123204, 125591);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3182, 123204, 125591);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3182, 123204, 125591);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3182, 123204, 125591);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3182, 123204, 125591);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3182, 123204, 125591);
            CallChecker.varInit(this.m_logger, "m_logger", 3182, 123204, 125591);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3182, 123204, 125591);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3182, 123204, 125591);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3182, 123204, 125591);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3182, 123204, 125591);
            BundleImpl bundle = CallChecker.init(BundleImpl.class);
            if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 3185, 123623, 123640)) {
                m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3185, 123623, 123640);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_installedBundles, Map[].class, 3185, 123623, 123640)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3185, 123623, 123660)) {
                    m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3185, 123623, 123640);
                    CallChecker.isCalled(m_installedBundles, Map[].class, 3185, 123623, 123640)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3185, 123623, 123640)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3185, 123623, 123660);
                    bundle = ((BundleImpl) (CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3185, 123623, 123640)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3185, 123623, 123660).get(new Long(id))));
                    CallChecker.varAssign(bundle, "bundle", 3185, 123623, 123640);
                }
            }
            if (bundle != null) {
                List<BundleImpl> uninstalledBundles = CallChecker.varInit(m_uninstalledBundles, "uninstalledBundles", 3188, 123731, 123789);
                uninstalledBundles = CallChecker.beforeCalled(uninstalledBundles, List.class, 3192, 123932, 123949);
                for (int i = 0; ((bundle == null) && (uninstalledBundles != null)) && (i < (CallChecker.isCalled(uninstalledBundles, List.class, 3192, 123932, 123949).size())); i++) {
                    uninstalledBundles = CallChecker.beforeCalled(uninstalledBundles, List.class, 3195, 124015, 124032);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(uninstalledBundles, List.class, 3195, 124015, 124032).get(i), BundleImpl.class, 3195, 124015, 124039)) {
                        if ((CallChecker.isCalled(uninstalledBundles.get(i), BundleImpl.class, 3195, 124015, 124039).getBundleId()) == id) {
                            bundle = uninstalledBundles.get(i);
                            CallChecker.varAssign(bundle, "bundle", 3197, 124100, 124134);
                        }
                    }
                }
            }
            Set<ServiceReference<FindHook>> hooks = CallChecker.varInit(getHooks(FindHook.class), "hooks", 3202, 124187, 124327);
            if (CallChecker.beforeDeref(hooks, Set.class, 3204, 124342, 124346)) {
                hooks = CallChecker.beforeCalled(hooks, Set.class, 3204, 124342, 124346);
                if ((!(CallChecker.isCalled(hooks, Set.class, 3204, 124342, 124346).isEmpty())) && (bundle != null)) {
                    Collection<Bundle> bundles = CallChecker.varInit(new ArrayList<Bundle>(1), "bundles", 3206, 124401, 124454);
                    if (CallChecker.beforeDeref(bundles, Collection.class, 3207, 124468, 124474)) {
                        bundles = CallChecker.beforeCalled(bundles, Collection.class, 3207, 124468, 124474);
                        CallChecker.isCalled(bundles, Collection.class, 3207, 124468, 124474).add(bundle);
                    }
                    bundles = new ShrinkableCollection<Bundle>(bundles);
                    CallChecker.varAssign(bundles, "bundles", 3208, 124501, 124552);
                    if (CallChecker.beforeDeref(hooks, Bundle.class, 3209, 124637, 124641)) {
                        for (ServiceReference<FindHook> hook : hooks) {
                            FindHook fh = CallChecker.varInit(getService(this, hook, false), "fh", 3211, 124674, 124749);
                            if (fh != null) {
                                TryContext _bcornu_try_context_221 = new TryContext(221, Felix.class, "java.lang.Throwable");
                                try {
                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3216, 124871, 124884)) {
                                        CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3216, 124871, 124884).invokeBundleFindHook(fh, bc, bundles);
                                    }
                                } catch (Throwable th) {
                                    _bcornu_try_context_221.catchStart(221);
                                    if (CallChecker.beforeDeref(hook, ServiceReference.class, 3221, 125078, 125081)) {
                                        if (CallChecker.beforeDeref(m_logger, Logger.class, 3220, 125034, 125041)) {
                                            CallChecker.isCalled(m_logger, Logger.class, 3220, 125034, 125041).doLog(CallChecker.isCalled(hook, ServiceReference.class, 3221, 125078, 125081).getBundle(), hook, Logger.LOG_WARNING, "Problem invoking bundle hook.", th);
                                        }
                                    }
                                } finally {
                                    _bcornu_try_context_221.finallyStart(221);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(bc, BundleContext.class, 3230, 125343, 125344)) {
                        bc = CallChecker.beforeCalled(bc, BundleContext.class, 3230, 125343, 125344);
                        if ((CallChecker.isCalled(bc, BundleContext.class, 3230, 125343, 125344).getBundle()) != (this)) {
                            if (CallChecker.beforeDeref(bundles, Collection.class, 3233, 125504, 125510)) {
                                bundles = CallChecker.beforeCalled(bundles, Collection.class, 3233, 125504, 125510);
                                if (CallChecker.isCalled(bundles, Collection.class, 3233, 125504, 125510).isEmpty()) {
                                    bundle = null;
                                    CallChecker.varAssign(bundle, "bundle", 3233, 125494, 125538);
                                }else {
                                    bundle = bundle;
                                    CallChecker.varAssign(bundle, "bundle", 3233, 125494, 125538);
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context642.methodEnd();
        }
    }

    Bundle getBundle(long id) {
        MethodContext _bcornu_methode_context643 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 3244, 125598, 126349);
            CallChecker.varInit(id, "id", 3244, 125598, 126349);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3244, 125598, 126349);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3244, 125598, 126349);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3244, 125598, 126349);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3244, 125598, 126349);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3244, 125598, 126349);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3244, 125598, 126349);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3244, 125598, 126349);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3244, 125598, 126349);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3244, 125598, 126349);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3244, 125598, 126349);
            CallChecker.varInit(this.m_registry, "m_registry", 3244, 125598, 126349);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3244, 125598, 126349);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3244, 125598, 126349);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3244, 125598, 126349);
            CallChecker.varInit(this.m_cache, "m_cache", 3244, 125598, 126349);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3244, 125598, 126349);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3244, 125598, 126349);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3244, 125598, 126349);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3244, 125598, 126349);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3244, 125598, 126349);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3244, 125598, 126349);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3244, 125598, 126349);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3244, 125598, 126349);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3244, 125598, 126349);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3244, 125598, 126349);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3244, 125598, 126349);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3244, 125598, 126349);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3244, 125598, 126349);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3244, 125598, 126349);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3244, 125598, 126349);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3244, 125598, 126349);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3244, 125598, 126349);
            CallChecker.varInit(this.m_logger, "m_logger", 3244, 125598, 126349);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3244, 125598, 126349);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3244, 125598, 126349);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3244, 125598, 126349);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3244, 125598, 126349);
            BundleImpl bundle = CallChecker.init(BundleImpl.class);
            if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 3247, 125842, 125859)) {
                m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3247, 125842, 125859);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_installedBundles, Map[].class, 3247, 125842, 125859)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3247, 125842, 125879)) {
                    m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3247, 125842, 125859);
                    CallChecker.isCalled(m_installedBundles, Map[].class, 3247, 125842, 125859)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3247, 125842, 125859)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3247, 125842, 125879);
                    bundle = ((BundleImpl) (CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3247, 125842, 125859)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3247, 125842, 125879).get(new Long(id))));
                    CallChecker.varAssign(bundle, "bundle", 3247, 125842, 125859);
                }
            }
            if (bundle != null) {
                return bundle;
            }
            List<BundleImpl> uninstalledBundles = CallChecker.varInit(m_uninstalledBundles, "uninstalledBundles", 3253, 125984, 126042);
            uninstalledBundles = CallChecker.beforeCalled(uninstalledBundles, List.class, 3255, 126117, 126134);
            for (int i = 0; (uninstalledBundles != null) && (i < (CallChecker.isCalled(uninstalledBundles, List.class, 3255, 126117, 126134).size())); i++) {
                uninstalledBundles = CallChecker.beforeCalled(uninstalledBundles, List.class, 3258, 126188, 126205);
                if (CallChecker.beforeDeref(CallChecker.isCalled(uninstalledBundles, List.class, 3258, 126188, 126205).get(i), BundleImpl.class, 3258, 126188, 126212)) {
                    if ((CallChecker.isCalled(uninstalledBundles.get(i), BundleImpl.class, 3258, 126188, 126212).getBundleId()) == id) {
                        return uninstalledBundles.get(i);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context643.methodEnd();
        }
    }

    Bundle[] getBundles(BundleContext bc) {
        MethodContext _bcornu_methode_context644 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 3274, 126356, 128195);
            CallChecker.varInit(bc, "bc", 3274, 126356, 128195);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3274, 126356, 128195);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3274, 126356, 128195);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3274, 126356, 128195);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3274, 126356, 128195);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3274, 126356, 128195);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3274, 126356, 128195);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3274, 126356, 128195);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3274, 126356, 128195);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3274, 126356, 128195);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3274, 126356, 128195);
            CallChecker.varInit(this.m_registry, "m_registry", 3274, 126356, 128195);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3274, 126356, 128195);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3274, 126356, 128195);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3274, 126356, 128195);
            CallChecker.varInit(this.m_cache, "m_cache", 3274, 126356, 128195);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3274, 126356, 128195);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3274, 126356, 128195);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3274, 126356, 128195);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3274, 126356, 128195);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3274, 126356, 128195);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3274, 126356, 128195);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3274, 126356, 128195);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3274, 126356, 128195);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3274, 126356, 128195);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3274, 126356, 128195);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3274, 126356, 128195);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3274, 126356, 128195);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3274, 126356, 128195);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3274, 126356, 128195);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3274, 126356, 128195);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3274, 126356, 128195);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3274, 126356, 128195);
            CallChecker.varInit(this.m_logger, "m_logger", 3274, 126356, 128195);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3274, 126356, 128195);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3274, 126356, 128195);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3274, 126356, 128195);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3274, 126356, 128195);
            Collection<Bundle> bundles = CallChecker.init(Collection.class);
            if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 3276, 126669, 126686)) {
                m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3276, 126669, 126686);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_installedBundles, Map[].class, 3276, 126669, 126686)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3276, 126669, 126706)) {
                    m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3276, 126669, 126686);
                    CallChecker.isCalled(m_installedBundles, Map[].class, 3276, 126669, 126686)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3276, 126669, 126686)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3276, 126669, 126706);
                    bundles = CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3276, 126669, 126686)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3276, 126669, 126706).values();
                    CallChecker.varAssign(bundles, "bundles", 3276, 126669, 126686);
                }
            }
            Set<ServiceReference<FindHook>> hooks = CallChecker.varInit(getHooks(FindHook.class), "hooks", 3277, 126726, 126866);
            if (CallChecker.beforeDeref(hooks, Set.class, 3279, 126881, 126885)) {
                hooks = CallChecker.beforeCalled(hooks, Set.class, 3279, 126881, 126885);
                if (!(CallChecker.isCalled(hooks, Set.class, 3279, 126881, 126885).isEmpty())) {
                    Collection<Bundle> shrunkBundles = CallChecker.varInit(new ShrinkableCollection<Bundle>(new ArrayList(bundles)), "shrunkBundles", 3281, 126920, 127011);
                    if (CallChecker.beforeDeref(hooks, Bundle[].class, 3282, 127096, 127100)) {
                        for (ServiceReference<FindHook> hook : hooks) {
                            FindHook fh = CallChecker.varInit(getService(this, hook, false), "fh", 3284, 127133, 127208);
                            if (fh != null) {
                                TryContext _bcornu_try_context_222 = new TryContext(222, Felix.class, "java.lang.Throwable");
                                try {
                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3289, 127330, 127343)) {
                                        CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3289, 127330, 127343).invokeBundleFindHook(fh, bc, shrunkBundles);
                                    }
                                } catch (Throwable th) {
                                    _bcornu_try_context_222.catchStart(222);
                                    if (CallChecker.beforeDeref(hook, ServiceReference.class, 3294, 127543, 127546)) {
                                        if (CallChecker.beforeDeref(m_logger, Logger.class, 3293, 127499, 127506)) {
                                            CallChecker.isCalled(m_logger, Logger.class, 3293, 127499, 127506).doLog(CallChecker.isCalled(hook, ServiceReference.class, 3294, 127543, 127546).getBundle(), hook, Logger.LOG_WARNING, "Problem invoking bundle hook.", th);
                                        }
                                    }
                                } finally {
                                    _bcornu_try_context_222.finallyStart(222);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(bc, BundleContext.class, 3303, 127808, 127809)) {
                        bc = CallChecker.beforeCalled(bc, BundleContext.class, 3303, 127808, 127809);
                        if ((CallChecker.isCalled(bc, BundleContext.class, 3303, 127808, 127809).getBundle()) != (this)) {
                            bundles = shrunkBundles;
                            CallChecker.varAssign(bundles, "bundles", 3307, 128081, 128104);
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(bundles, Collection.class, 3311, 128173, 128179)) {
                if (CallChecker.beforeDeref(bundles, Collection.class, 3311, 128146, 128152)) {
                    bundles = CallChecker.beforeCalled(bundles, Collection.class, 3311, 128173, 128179);
                    bundles = CallChecker.beforeCalled(bundles, Collection.class, 3311, 128146, 128152);
                    return CallChecker.isCalled(bundles, Collection.class, 3311, 128146, 128152).toArray(new Bundle[CallChecker.isCalled(bundles, Collection.class, 3311, 128173, 128179).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context644.methodEnd();
        }
    }

    Bundle[] getBundles() {
        MethodContext _bcornu_methode_context645 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 3320, 128202, 128583);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3320, 128202, 128583);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3320, 128202, 128583);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3320, 128202, 128583);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3320, 128202, 128583);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3320, 128202, 128583);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3320, 128202, 128583);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3320, 128202, 128583);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3320, 128202, 128583);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3320, 128202, 128583);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3320, 128202, 128583);
            CallChecker.varInit(this.m_registry, "m_registry", 3320, 128202, 128583);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3320, 128202, 128583);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3320, 128202, 128583);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3320, 128202, 128583);
            CallChecker.varInit(this.m_cache, "m_cache", 3320, 128202, 128583);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3320, 128202, 128583);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3320, 128202, 128583);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3320, 128202, 128583);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3320, 128202, 128583);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3320, 128202, 128583);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3320, 128202, 128583);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3320, 128202, 128583);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3320, 128202, 128583);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3320, 128202, 128583);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3320, 128202, 128583);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3320, 128202, 128583);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3320, 128202, 128583);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3320, 128202, 128583);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3320, 128202, 128583);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3320, 128202, 128583);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3320, 128202, 128583);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3320, 128202, 128583);
            CallChecker.varInit(this.m_logger, "m_logger", 3320, 128202, 128583);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3320, 128202, 128583);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3320, 128202, 128583);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3320, 128202, 128583);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3320, 128202, 128583);
            Collection<Bundle> bundles = CallChecker.init(Collection.class);
            if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 3322, 128470, 128487)) {
                m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3322, 128470, 128487);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_installedBundles, Map[].class, 3322, 128470, 128487)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3322, 128470, 128507)) {
                    m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 3322, 128470, 128487);
                    CallChecker.isCalled(m_installedBundles, Map[].class, 3322, 128470, 128487)[Felix.IDENTIFIER_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3322, 128470, 128487)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3322, 128470, 128507);
                    bundles = CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 3322, 128470, 128487)[Felix.IDENTIFIER_MAP_IDX], Map.class, 3322, 128470, 128507).values();
                    CallChecker.varAssign(bundles, "bundles", 3322, 128470, 128487);
                }
            }
            if (CallChecker.beforeDeref(bundles, Collection.class, 3323, 128561, 128567)) {
                if (CallChecker.beforeDeref(bundles, Collection.class, 3323, 128534, 128540)) {
                    bundles = CallChecker.beforeCalled(bundles, Collection.class, 3323, 128561, 128567);
                    bundles = CallChecker.beforeCalled(bundles, Collection.class, 3323, 128534, 128540);
                    return CallChecker.isCalled(bundles, Collection.class, 3323, 128534, 128540).toArray(new Bundle[CallChecker.isCalled(bundles, Collection.class, 3323, 128561, 128567).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context645.methodEnd();
        }
    }

    void addBundleListener(BundleImpl bundle, BundleListener l) {
        MethodContext _bcornu_methode_context646 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3326, 128590, 128766);
            CallChecker.varInit(l, "l", 3326, 128590, 128766);
            CallChecker.varInit(bundle, "bundle", 3326, 128590, 128766);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3326, 128590, 128766);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3326, 128590, 128766);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3326, 128590, 128766);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3326, 128590, 128766);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3326, 128590, 128766);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3326, 128590, 128766);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3326, 128590, 128766);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3326, 128590, 128766);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3326, 128590, 128766);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3326, 128590, 128766);
            CallChecker.varInit(this.m_registry, "m_registry", 3326, 128590, 128766);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3326, 128590, 128766);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3326, 128590, 128766);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3326, 128590, 128766);
            CallChecker.varInit(this.m_cache, "m_cache", 3326, 128590, 128766);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3326, 128590, 128766);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3326, 128590, 128766);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3326, 128590, 128766);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3326, 128590, 128766);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3326, 128590, 128766);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3326, 128590, 128766);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3326, 128590, 128766);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3326, 128590, 128766);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3326, 128590, 128766);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3326, 128590, 128766);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3326, 128590, 128766);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3326, 128590, 128766);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3326, 128590, 128766);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3326, 128590, 128766);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3326, 128590, 128766);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3326, 128590, 128766);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3326, 128590, 128766);
            CallChecker.varInit(this.m_logger, "m_logger", 3326, 128590, 128766);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3326, 128590, 128766);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3326, 128590, 128766);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3326, 128590, 128766);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3326, 128590, 128766);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3329, 128702, 128707)) {
                if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 3328, 128664, 128675)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3329, 128702, 128707);
                    CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 3328, 128664, 128675).addListener(CallChecker.isCalled(bundle, BundleImpl.class, 3329, 128702, 128707)._getBundleContext(), BundleListener.class, l, null);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context646.methodEnd();
        }
    }

    void removeBundleListener(BundleImpl bundle, BundleListener l) {
        MethodContext _bcornu_methode_context647 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3332, 128773, 128949);
            CallChecker.varInit(l, "l", 3332, 128773, 128949);
            CallChecker.varInit(bundle, "bundle", 3332, 128773, 128949);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3332, 128773, 128949);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3332, 128773, 128949);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3332, 128773, 128949);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3332, 128773, 128949);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3332, 128773, 128949);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3332, 128773, 128949);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3332, 128773, 128949);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3332, 128773, 128949);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3332, 128773, 128949);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3332, 128773, 128949);
            CallChecker.varInit(this.m_registry, "m_registry", 3332, 128773, 128949);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3332, 128773, 128949);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3332, 128773, 128949);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3332, 128773, 128949);
            CallChecker.varInit(this.m_cache, "m_cache", 3332, 128773, 128949);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3332, 128773, 128949);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3332, 128773, 128949);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3332, 128773, 128949);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3332, 128773, 128949);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3332, 128773, 128949);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3332, 128773, 128949);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3332, 128773, 128949);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3332, 128773, 128949);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3332, 128773, 128949);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3332, 128773, 128949);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3332, 128773, 128949);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3332, 128773, 128949);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3332, 128773, 128949);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3332, 128773, 128949);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3332, 128773, 128949);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3332, 128773, 128949);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3332, 128773, 128949);
            CallChecker.varInit(this.m_logger, "m_logger", 3332, 128773, 128949);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3332, 128773, 128949);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3332, 128773, 128949);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3332, 128773, 128949);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3332, 128773, 128949);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3335, 128891, 128896)) {
                if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 3334, 128850, 128861)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3335, 128891, 128896);
                    CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 3334, 128850, 128861).removeListener(CallChecker.isCalled(bundle, BundleImpl.class, 3335, 128891, 128896)._getBundleContext(), BundleListener.class, l);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context647.methodEnd();
        }
    }

    void addServiceListener(BundleImpl bundle, ServiceListener l, String f) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context648 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3347, 128956, 131972);
            CallChecker.varInit(f, "f", 3347, 128956, 131972);
            CallChecker.varInit(l, "l", 3347, 128956, 131972);
            CallChecker.varInit(bundle, "bundle", 3347, 128956, 131972);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3347, 128956, 131972);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3347, 128956, 131972);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3347, 128956, 131972);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3347, 128956, 131972);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3347, 128956, 131972);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3347, 128956, 131972);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3347, 128956, 131972);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3347, 128956, 131972);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3347, 128956, 131972);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3347, 128956, 131972);
            CallChecker.varInit(this.m_registry, "m_registry", 3347, 128956, 131972);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3347, 128956, 131972);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3347, 128956, 131972);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3347, 128956, 131972);
            CallChecker.varInit(this.m_cache, "m_cache", 3347, 128956, 131972);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3347, 128956, 131972);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3347, 128956, 131972);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3347, 128956, 131972);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3347, 128956, 131972);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3347, 128956, 131972);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3347, 128956, 131972);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3347, 128956, 131972);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3347, 128956, 131972);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3347, 128956, 131972);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3347, 128956, 131972);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3347, 128956, 131972);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3347, 128956, 131972);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3347, 128956, 131972);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3347, 128956, 131972);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3347, 128956, 131972);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3347, 128956, 131972);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3347, 128956, 131972);
            CallChecker.varInit(this.m_logger, "m_logger", 3347, 128956, 131972);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3347, 128956, 131972);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3347, 128956, 131972);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3347, 128956, 131972);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3347, 128956, 131972);
            Filter oldFilter = CallChecker.init(Filter.class);
            Filter newFilter = CallChecker.init(Filter.class);
            if (f == null) {
                newFilter = null;
                CallChecker.varAssign(newFilter, "newFilter", 3351, 129507, 129556);
            }else {
                newFilter = FrameworkUtil.createFilter(f);
                CallChecker.varAssign(newFilter, "newFilter", 3351, 129507, 129556);
            }
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3354, 129618, 129623)) {
                if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 3353, 129580, 129591)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3354, 129618, 129623);
                    oldFilter = CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 3353, 129580, 129591).addListener(CallChecker.isCalled(bundle, BundleImpl.class, 3354, 129618, 129623)._getBundleContext(), ServiceListener.class, l, newFilter);
                    CallChecker.varAssign(oldFilter, "oldFilter", 3353, 129568, 129682);
                }
            }
            Set<ServiceReference<ListenerHook>> listenerHooks = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3358, 129850, 129859)) {
                final HookRegistry npe_invocation_var206 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 3358, 129850, 129859).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var206, HookRegistry.class, 3358, 129850, 129877)) {
                    listenerHooks = CallChecker.isCalled(npe_invocation_var206, HookRegistry.class, 3358, 129850, 129877).getHooks(ListenerHook.class);
                    CallChecker.varAssign(listenerHooks, "listenerHooks", 3358, 129850, 129859);
                }
            }
            if (oldFilter != null) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3362, 130086, 130091);
                final Collection removed = CallChecker.varInit(Collections.singleton(new ListenerInfo(bundle, CallChecker.isCalled(bundle, BundleImpl.class, 3362, 130086, 130091)._getBundleContext(), ServiceListener.class, l, oldFilter, null, true)), "removed", 3361, 129995, 130183);
                if (CallChecker.beforeDeref(listenerHooks, void.class, 3364, 130271, 130283)) {
                    for (ServiceReference<ListenerHook> sr : listenerHooks) {
                        ListenerHook lh = CallChecker.varInit(getService(this, sr, false), "lh", 3366, 130316, 130394);
                        if (lh != null) {
                            TryContext _bcornu_try_context_223 = new TryContext(223, Felix.class, "java.lang.Throwable");
                            try {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3371, 130516, 130529)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3371, 130516, 130529).invokeServiceListenerHookRemoved(lh, removed);
                                }
                            } catch (Throwable th) {
                                _bcornu_try_context_223.catchStart(223);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 3375, 130687, 130694)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 3375, 130687, 130694).log(sr, Logger.LOG_WARNING, "Problem invoking service registry hook", th);
                                }
                            } finally {
                                _bcornu_try_context_223.finallyStart(223);
                                if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3380, 130895, 130904)) {
                                    CallChecker.isCalled(m_registry, ServiceRegistry.class, 3380, 130895, 130904).ungetService(this, sr, null);
                                }
                            }
                        }
                    }
                }
            }
            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3388, 131151, 131156);
            final Collection added = CallChecker.varInit(Collections.singleton(new ListenerInfo(bundle, CallChecker.isCalled(bundle, BundleImpl.class, 3388, 131151, 131156)._getBundleContext(), ServiceListener.class, l, newFilter, null, false)), "added", 3387, 131009, 131245);
            if (CallChecker.beforeDeref(listenerHooks, void.class, 3390, 131329, 131341)) {
                for (ServiceReference<ListenerHook> sr : listenerHooks) {
                    ListenerHook lh = CallChecker.varInit(getService(this, sr, false), "lh", 3392, 131366, 131444);
                    if (lh != null) {
                        TryContext _bcornu_try_context_224 = new TryContext(224, Felix.class, "java.lang.Throwable");
                        try {
                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3397, 131546, 131559)) {
                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3397, 131546, 131559).invokeServiceListenerHookAdded(lh, added);
                            }
                        } catch (Throwable th) {
                            _bcornu_try_context_224.catchStart(224);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 3401, 131697, 131704)) {
                                CallChecker.isCalled(m_logger, Logger.class, 3401, 131697, 131704).log(sr, Logger.LOG_WARNING, "Problem invoking service registry hook", th);
                            }
                        } finally {
                            _bcornu_try_context_224.finallyStart(224);
                            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3406, 131885, 131894)) {
                                CallChecker.isCalled(m_registry, ServiceRegistry.class, 3406, 131885, 131894).ungetService(this, sr, null);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context648.methodEnd();
        }
    }

    void removeServiceListener(BundleImpl bundle, ServiceListener l) {
        MethodContext _bcornu_methode_context649 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3419, 131979, 133706);
            CallChecker.varInit(l, "l", 3419, 131979, 133706);
            CallChecker.varInit(bundle, "bundle", 3419, 131979, 133706);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3419, 131979, 133706);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3419, 131979, 133706);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3419, 131979, 133706);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3419, 131979, 133706);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3419, 131979, 133706);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3419, 131979, 133706);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3419, 131979, 133706);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3419, 131979, 133706);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3419, 131979, 133706);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3419, 131979, 133706);
            CallChecker.varInit(this.m_registry, "m_registry", 3419, 131979, 133706);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3419, 131979, 133706);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3419, 131979, 133706);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3419, 131979, 133706);
            CallChecker.varInit(this.m_cache, "m_cache", 3419, 131979, 133706);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3419, 131979, 133706);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3419, 131979, 133706);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3419, 131979, 133706);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3419, 131979, 133706);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3419, 131979, 133706);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3419, 131979, 133706);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3419, 131979, 133706);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3419, 131979, 133706);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3419, 131979, 133706);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3419, 131979, 133706);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3419, 131979, 133706);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3419, 131979, 133706);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3419, 131979, 133706);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3419, 131979, 133706);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3419, 131979, 133706);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3419, 131979, 133706);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3419, 131979, 133706);
            CallChecker.varInit(this.m_logger, "m_logger", 3419, 131979, 133706);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3419, 131979, 133706);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3419, 131979, 133706);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3419, 131979, 133706);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3419, 131979, 133706);
            ListenerHook.ListenerInfo listener = CallChecker.init(ListenerHook.ListenerInfo.class);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3423, 132457, 132462)) {
                if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 3422, 132412, 132423)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3423, 132457, 132462);
                    listener = CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 3422, 132412, 132423).removeListener(CallChecker.isCalled(bundle, BundleImpl.class, 3423, 132457, 132462)._getBundleContext(), ServiceListener.class, l);
                    CallChecker.varAssign(listener, "listener", 3423, 132457, 132462);
                }
            }
            if (listener != null) {
                Set<ServiceReference<ListenerHook>> listenerHooks = CallChecker.init(Set.class);
                if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3429, 132729, 132738)) {
                    final HookRegistry npe_invocation_var207 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 3429, 132729, 132738).getHookRegistry();
                    if (CallChecker.beforeDeref(npe_invocation_var207, HookRegistry.class, 3429, 132729, 132756)) {
                        listenerHooks = CallChecker.isCalled(npe_invocation_var207, HookRegistry.class, 3429, 132729, 132756).getHooks(ListenerHook.class);
                        CallChecker.varAssign(listenerHooks, "listenerHooks", 3429, 132729, 132738);
                    }
                }
                Collection removed = CallChecker.varInit(Collections.singleton(listener), "removed", 3430, 132833, 132885);
                if (CallChecker.beforeDeref(listenerHooks, void.class, 3431, 132973, 132985)) {
                    for (ServiceReference<ListenerHook> sr : listenerHooks) {
                        ListenerHook lh = CallChecker.varInit(getService(this, sr, false), "lh", 3433, 133018, 133096);
                        if (lh != null) {
                            TryContext _bcornu_try_context_225 = new TryContext(225, Felix.class, "java.lang.Throwable");
                            try {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3438, 133218, 133231)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3438, 133218, 133231).invokeServiceListenerHookRemoved(lh, removed);
                                }
                            } catch (Throwable th) {
                                _bcornu_try_context_225.catchStart(225);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 3442, 133389, 133396)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 3442, 133389, 133396).log(sr, Logger.LOG_WARNING, "Problem invoking service registry hook", th);
                                }
                            } finally {
                                _bcornu_try_context_225.finallyStart(225);
                                if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3447, 133597, 133606)) {
                                    CallChecker.isCalled(m_registry, ServiceRegistry.class, 3447, 133597, 133606).ungetService(this, sr, null);
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
            _bcornu_methode_context649.methodEnd();
        }
    }

    void addFrameworkListener(BundleImpl bundle, FrameworkListener l) {
        MethodContext _bcornu_methode_context650 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3454, 133713, 133898);
            CallChecker.varInit(l, "l", 3454, 133713, 133898);
            CallChecker.varInit(bundle, "bundle", 3454, 133713, 133898);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3454, 133713, 133898);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3454, 133713, 133898);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3454, 133713, 133898);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3454, 133713, 133898);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3454, 133713, 133898);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3454, 133713, 133898);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3454, 133713, 133898);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3454, 133713, 133898);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3454, 133713, 133898);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3454, 133713, 133898);
            CallChecker.varInit(this.m_registry, "m_registry", 3454, 133713, 133898);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3454, 133713, 133898);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3454, 133713, 133898);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3454, 133713, 133898);
            CallChecker.varInit(this.m_cache, "m_cache", 3454, 133713, 133898);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3454, 133713, 133898);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3454, 133713, 133898);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3454, 133713, 133898);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3454, 133713, 133898);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3454, 133713, 133898);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3454, 133713, 133898);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3454, 133713, 133898);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3454, 133713, 133898);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3454, 133713, 133898);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3454, 133713, 133898);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3454, 133713, 133898);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3454, 133713, 133898);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3454, 133713, 133898);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3454, 133713, 133898);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3454, 133713, 133898);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3454, 133713, 133898);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3454, 133713, 133898);
            CallChecker.varInit(this.m_logger, "m_logger", 3454, 133713, 133898);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3454, 133713, 133898);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3454, 133713, 133898);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3454, 133713, 133898);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3454, 133713, 133898);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3457, 133831, 133836)) {
                if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 3456, 133793, 133804)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3457, 133831, 133836);
                    CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 3456, 133793, 133804).addListener(CallChecker.isCalled(bundle, BundleImpl.class, 3457, 133831, 133836)._getBundleContext(), FrameworkListener.class, l, null);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context650.methodEnd();
        }
    }

    void removeFrameworkListener(BundleImpl bundle, FrameworkListener l) {
        MethodContext _bcornu_methode_context651 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3460, 133905, 134090);
            CallChecker.varInit(l, "l", 3460, 133905, 134090);
            CallChecker.varInit(bundle, "bundle", 3460, 133905, 134090);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3460, 133905, 134090);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3460, 133905, 134090);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3460, 133905, 134090);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3460, 133905, 134090);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3460, 133905, 134090);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3460, 133905, 134090);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3460, 133905, 134090);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3460, 133905, 134090);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3460, 133905, 134090);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3460, 133905, 134090);
            CallChecker.varInit(this.m_registry, "m_registry", 3460, 133905, 134090);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3460, 133905, 134090);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3460, 133905, 134090);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3460, 133905, 134090);
            CallChecker.varInit(this.m_cache, "m_cache", 3460, 133905, 134090);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3460, 133905, 134090);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3460, 133905, 134090);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3460, 133905, 134090);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3460, 133905, 134090);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3460, 133905, 134090);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3460, 133905, 134090);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3460, 133905, 134090);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3460, 133905, 134090);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3460, 133905, 134090);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3460, 133905, 134090);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3460, 133905, 134090);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3460, 133905, 134090);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3460, 133905, 134090);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3460, 133905, 134090);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3460, 133905, 134090);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3460, 133905, 134090);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3460, 133905, 134090);
            CallChecker.varInit(this.m_logger, "m_logger", 3460, 133905, 134090);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3460, 133905, 134090);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3460, 133905, 134090);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3460, 133905, 134090);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3460, 133905, 134090);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3463, 134029, 134034)) {
                if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 3462, 133988, 133999)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3463, 134029, 134034);
                    CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 3462, 133988, 133999).removeListener(CallChecker.isCalled(bundle, BundleImpl.class, 3463, 134029, 134034)._getBundleContext(), FrameworkListener.class, l);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context651.methodEnd();
        }
    }

    ServiceRegistration registerService(BundleContextImpl context, String[] classNames, Object svcObj, Dictionary dict) {
        MethodContext _bcornu_methode_context652 = new MethodContext(ServiceRegistration.class);
        try {
            CallChecker.varInit(this, "this", 3477, 134097, 137242);
            CallChecker.varInit(dict, "dict", 3477, 134097, 137242);
            CallChecker.varInit(svcObj, "svcObj", 3477, 134097, 137242);
            CallChecker.varInit(classNames, "classNames", 3477, 134097, 137242);
            CallChecker.varInit(context, "context", 3477, 134097, 137242);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3477, 134097, 137242);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3477, 134097, 137242);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3477, 134097, 137242);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3477, 134097, 137242);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3477, 134097, 137242);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3477, 134097, 137242);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3477, 134097, 137242);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3477, 134097, 137242);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3477, 134097, 137242);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3477, 134097, 137242);
            CallChecker.varInit(this.m_registry, "m_registry", 3477, 134097, 137242);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3477, 134097, 137242);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3477, 134097, 137242);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3477, 134097, 137242);
            CallChecker.varInit(this.m_cache, "m_cache", 3477, 134097, 137242);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3477, 134097, 137242);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3477, 134097, 137242);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3477, 134097, 137242);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3477, 134097, 137242);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3477, 134097, 137242);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3477, 134097, 137242);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3477, 134097, 137242);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3477, 134097, 137242);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3477, 134097, 137242);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3477, 134097, 137242);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3477, 134097, 137242);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3477, 134097, 137242);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3477, 134097, 137242);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3477, 134097, 137242);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3477, 134097, 137242);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3477, 134097, 137242);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3477, 134097, 137242);
            CallChecker.varInit(this.m_logger, "m_logger", 3477, 134097, 137242);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3477, 134097, 137242);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3477, 134097, 137242);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3477, 134097, 137242);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3477, 134097, 137242);
            if (classNames == null) {
                throw new NullPointerException("Service class names cannot be null.");
            }else
                if (svcObj == null) {
                    throw new IllegalArgumentException("Service object cannot be null.");
                }
            
            ServiceRegistration reg = CallChecker.varInit(null, "reg", 3489, 135035, 135065);
            if (!(svcObj instanceof ServiceFactory)) {
                classNames = CallChecker.beforeCalled(classNames, String[].class, 3496, 135321, 135330);
                for (int i = 0; i < (CallChecker.isCalled(classNames, String[].class, 3496, 135321, 135330).length); i++) {
                    Class clazz = CallChecker.init(Class.class);
                    if (CallChecker.beforeDeref(svcObj, Object.class, 3498, 135414, 135419)) {
                        if (CallChecker.beforeDeref(classNames, String[].class, 3498, 135433, 135442)) {
                            svcObj = CallChecker.beforeCalled(svcObj, Object.class, 3498, 135414, 135419);
                            classNames = CallChecker.beforeCalled(classNames, String[].class, 3498, 135433, 135442);
                            clazz = Util.loadClassUsingClass(CallChecker.isCalled(svcObj, Object.class, 3498, 135414, 135419).getClass(), CallChecker.isCalled(classNames, String[].class, 3498, 135433, 135442)[i], Felix.m_secureAction);
                            CallChecker.varAssign(clazz, "clazz", 3498, 135414, 135419);
                        }
                    }
                    if (clazz == null) {
                        if (CallChecker.beforeDeref(classNames, String[].class, 3502, 135624, 135633)) {
                            classNames = CallChecker.beforeCalled(classNames, String[].class, 3502, 135624, 135633);
                            throw new IllegalArgumentException(("Cannot cast service: " + (CallChecker.isCalled(classNames, String[].class, 3502, 135624, 135633)[i])));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (CallChecker.beforeDeref(svcObj, Object.class, 3504, 135707, 135712)) {
                            svcObj = CallChecker.beforeCalled(svcObj, Object.class, 3504, 135707, 135712);
                            if (!(clazz.isAssignableFrom(CallChecker.isCalled(svcObj, Object.class, 3504, 135707, 135712).getClass()))) {
                                if (CallChecker.beforeDeref(classNames, String[].class, 3508, 135893, 135902)) {
                                    classNames = CallChecker.beforeCalled(classNames, String[].class, 3508, 135893, 135902);
                                    throw new IllegalArgumentException((("Service object is not an instance of \"" + (CallChecker.isCalled(classNames, String[].class, 3508, 135893, 135902)[i])) + "\"."));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }
            }
            if (CallChecker.beforeDeref(context, BundleContextImpl.class, 3513, 136001, 136007)) {
                if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3513, 135974, 135983)) {
                    context = CallChecker.beforeCalled(context, BundleContextImpl.class, 3513, 136001, 136007);
                    reg = CallChecker.isCalled(m_registry, ServiceRegistry.class, 3513, 135974, 135983).registerService(CallChecker.isCalled(context, BundleContextImpl.class, 3513, 136001, 136007).getBundle(), classNames, svcObj, dict);
                    CallChecker.varAssign(reg, "reg", 3513, 135968, 136047);
                }
            }
            if (HookRegistry.isHook(classNames, ListenerHook.class, svcObj)) {
                ListenerHook lh = CallChecker.init(ListenerHook.class);
                if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 3522, 136483, 136485)) {
                    reg = CallChecker.beforeCalled(reg, ServiceRegistration.class, 3522, 136483, 136485);
                    lh = ((ListenerHook) (getService(this, CallChecker.isCalled(reg, ServiceRegistration.class, 3522, 136483, 136485).getReference(), false)));
                    CallChecker.varAssign(lh, "lh", 3522, 136483, 136485);
                }
                if (lh != null) {
                    TryContext _bcornu_try_context_226 = new TryContext(226, Felix.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 3528, 136686, 136697)) {
                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3527, 136611, 136624)) {
                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3527, 136611, 136624).invokeServiceListenerHookAdded(lh, CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 3528, 136686, 136697).getAllServiceListeners());
                            }
                        }
                    } catch (Throwable th) {
                        _bcornu_try_context_226.catchStart(226);
                        if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 3532, 136832, 136834)) {
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 3532, 136819, 136826)) {
                                reg = CallChecker.beforeCalled(reg, ServiceRegistration.class, 3532, 136832, 136834);
                                CallChecker.isCalled(m_logger, Logger.class, 3532, 136819, 136826).log(CallChecker.isCalled(reg, ServiceRegistration.class, 3532, 136832, 136834).getReference(), Logger.LOG_WARNING, "Problem invoking service registry hook", th);
                            }
                        }
                    } finally {
                        _bcornu_try_context_226.finallyStart(226);
                        if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 3537, 137047, 137049)) {
                            reg = CallChecker.beforeCalled(reg, ServiceRegistration.class, 3537, 137047, 137049);
                            this.ungetService(this, CallChecker.isCalled(reg, ServiceRegistration.class, 3537, 137047, 137049).getReference(), null);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 3542, 137189, 137191)) {
                reg = CallChecker.beforeCalled(reg, ServiceRegistration.class, 3542, 137189, 137191);
                this.fireServiceEvent(new ServiceEvent(ServiceEvent.REGISTERED, CallChecker.isCalled(reg, ServiceRegistration.class, 3542, 137189, 137191).getReference()), null);
            }
            return reg;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceRegistration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context652.methodEnd();
        }
    }

    ServiceReference[] getServiceReferences(final BundleImpl bundle, final String className, final String expr, final boolean checkAssignable) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context653 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 3557, 137249, 140814);
            CallChecker.varInit(checkAssignable, "checkAssignable", 3557, 137249, 140814);
            CallChecker.varInit(expr, "expr", 3557, 137249, 140814);
            CallChecker.varInit(className, "className", 3557, 137249, 140814);
            CallChecker.varInit(bundle, "bundle", 3557, 137249, 140814);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3557, 137249, 140814);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3557, 137249, 140814);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3557, 137249, 140814);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3557, 137249, 140814);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3557, 137249, 140814);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3557, 137249, 140814);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3557, 137249, 140814);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3557, 137249, 140814);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3557, 137249, 140814);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3557, 137249, 140814);
            CallChecker.varInit(this.m_registry, "m_registry", 3557, 137249, 140814);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3557, 137249, 140814);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3557, 137249, 140814);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3557, 137249, 140814);
            CallChecker.varInit(this.m_cache, "m_cache", 3557, 137249, 140814);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3557, 137249, 140814);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3557, 137249, 140814);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3557, 137249, 140814);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3557, 137249, 140814);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3557, 137249, 140814);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3557, 137249, 140814);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3557, 137249, 140814);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3557, 137249, 140814);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3557, 137249, 140814);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3557, 137249, 140814);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3557, 137249, 140814);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3557, 137249, 140814);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3557, 137249, 140814);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3557, 137249, 140814);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3557, 137249, 140814);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3557, 137249, 140814);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3557, 137249, 140814);
            CallChecker.varInit(this.m_logger, "m_logger", 3557, 137249, 140814);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3557, 137249, 140814);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3557, 137249, 140814);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3557, 137249, 140814);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3557, 137249, 140814);
            SimpleFilter filter = CallChecker.varInit(null, "filter", 3563, 138027, 138053);
            if (expr != null) {
                TryContext _bcornu_try_context_227 = new TryContext(227, Felix.class, "java.lang.Exception");
                try {
                    filter = SimpleFilter.parse(expr);
                    CallChecker.varAssign(filter, "filter", 3568, 138137, 138170);
                } catch (Exception ex) {
                    _bcornu_try_context_227.catchStart(227);
                    throw new InvalidSyntaxException(ex.getMessage(), expr);
                } finally {
                    _bcornu_try_context_227.finallyStart(227);
                }
            }
            final Collection refList = CallChecker.varInit(CallChecker.isCalled(m_registry, ServiceRegistry.class, 3577, 138439, 138448).getServiceReferences(className, filter), "refList", 3577, 138339, 138489);
            if (checkAssignable) {
                for (Iterator refIter = CallChecker.isCalled(refList, Collection.class, 3582, 138610, 138616).iterator(); CallChecker.isCalled(refIter, Iterator.class, 3582, 138630, 138636).hasNext();) {
                    ServiceReference ref = CallChecker.init(ServiceReference.class);
                    if (CallChecker.beforeDeref(refIter, Iterator.class, 3585, 138776, 138782)) {
                        ref = ((ServiceReference) (CallChecker.isCalled(refIter, Iterator.class, 3585, 138776, 138782).next()));
                        CallChecker.varAssign(ref, "ref", 3585, 138776, 138782);
                    }
                    if (!(Util.isServiceAssignable(bundle, ref))) {
                        if (CallChecker.beforeDeref(refIter, Iterator.class, 3590, 138937, 138943)) {
                            CallChecker.isCalled(refIter, Iterator.class, 3590, 138937, 138943).remove();
                        }
                    }
                }
            }
            Collection resRefList = CallChecker.init(Collection.class);
            if (bundle == (this)) {
                resRefList = new ArrayList(refList);
                CallChecker.varAssign(resRefList, "resRefList", 3596, 139124, 139174);
            }else {
                resRefList = refList;
                CallChecker.varAssign(resRefList, "resRefList", 3596, 139124, 139174);
            }
            Set<ServiceReference<org.osgi.framework.hooks.service.FindHook>> findHooks = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3600, 139305, 139314)) {
                final HookRegistry npe_invocation_var208 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 3600, 139305, 139314).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var208, HookRegistry.class, 3600, 139305, 139332)) {
                    findHooks = CallChecker.isCalled(npe_invocation_var208, HookRegistry.class, 3600, 139305, 139332).getHooks(org.osgi.framework.hooks.service.FindHook.class);
                    CallChecker.varAssign(findHooks, "findHooks", 3600, 139305, 139314);
                }
            }
            if (CallChecker.beforeDeref(findHooks, ServiceReference[].class, 3601, 139471, 139479)) {
                for (ServiceReference<org.osgi.framework.hooks.service.FindHook> sr : findHooks) {
                    org.osgi.framework.hooks.service.FindHook fh = CallChecker.varInit(getService(this, sr, false), "fh", 3603, 139504, 139578);
                    if (fh != null) {
                        TryContext _bcornu_try_context_228 = new TryContext(228, Felix.class, "java.lang.Throwable");
                        try {
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3610, 139770, 139775)) {
                                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 3608, 139680, 139693)) {
                                    CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 3608, 139680, 139693).invokeServiceFindHook(fh, CallChecker.isCalled(bundle, BundleImpl.class, 3610, 139770, 139775)._getBundleContext(), className, expr, (!checkAssignable), new ShrinkableCollection(refList));
                                }
                            }
                        } catch (Throwable th) {
                            _bcornu_try_context_228.catchStart(228);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 3618, 140058, 140065)) {
                                CallChecker.isCalled(m_logger, Logger.class, 3618, 140058, 140065).log(sr, Logger.LOG_WARNING, "Problem invoking service registry hook", th);
                            }
                        } finally {
                            _bcornu_try_context_228.finallyStart(228);
                            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3623, 140246, 140255)) {
                                CallChecker.isCalled(m_registry, ServiceRegistry.class, 3623, 140246, 140255).ungetService(this, sr, null);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(resRefList, Collection.class, 3631, 140644, 140653)) {
                resRefList = CallChecker.beforeCalled(resRefList, Collection.class, 3631, 140644, 140653);
                if ((CallChecker.isCalled(resRefList, Collection.class, 3631, 140644, 140653).size()) > 0) {
                    if (CallChecker.beforeDeref(resRefList, Collection.class, 3633, 140757, 140766)) {
                        if (CallChecker.beforeDeref(resRefList, Collection.class, 3633, 140717, 140726)) {
                            resRefList = CallChecker.beforeCalled(resRefList, Collection.class, 3633, 140757, 140766);
                            resRefList = CallChecker.beforeCalled(resRefList, Collection.class, 3633, 140717, 140726);
                            return ((ServiceReference[]) (CallChecker.isCalled(resRefList, Collection.class, 3633, 140717, 140726).toArray(new ServiceReference[CallChecker.isCalled(resRefList, Collection.class, 3633, 140757, 140766).size()])));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context653.methodEnd();
        }
    }

    ServiceReference[] getAllowedServiceReferences(BundleImpl bundle, String className, String expr, boolean checkAssignable) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context654 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 3651, 140821, 142593);
            CallChecker.varInit(checkAssignable, "checkAssignable", 3651, 140821, 142593);
            CallChecker.varInit(expr, "expr", 3651, 140821, 142593);
            CallChecker.varInit(className, "className", 3651, 140821, 142593);
            CallChecker.varInit(bundle, "bundle", 3651, 140821, 142593);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3651, 140821, 142593);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3651, 140821, 142593);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3651, 140821, 142593);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3651, 140821, 142593);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3651, 140821, 142593);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3651, 140821, 142593);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3651, 140821, 142593);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3651, 140821, 142593);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3651, 140821, 142593);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3651, 140821, 142593);
            CallChecker.varInit(this.m_registry, "m_registry", 3651, 140821, 142593);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3651, 140821, 142593);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3651, 140821, 142593);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3651, 140821, 142593);
            CallChecker.varInit(this.m_cache, "m_cache", 3651, 140821, 142593);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3651, 140821, 142593);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3651, 140821, 142593);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3651, 140821, 142593);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3651, 140821, 142593);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3651, 140821, 142593);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3651, 140821, 142593);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3651, 140821, 142593);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3651, 140821, 142593);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3651, 140821, 142593);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3651, 140821, 142593);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3651, 140821, 142593);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3651, 140821, 142593);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3651, 140821, 142593);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3651, 140821, 142593);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3651, 140821, 142593);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3651, 140821, 142593);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3651, 140821, 142593);
            CallChecker.varInit(this.m_logger, "m_logger", 3651, 140821, 142593);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3651, 140821, 142593);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3651, 140821, 142593);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3651, 140821, 142593);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3651, 140821, 142593);
            ServiceReference[] refs = CallChecker.varInit(getServiceReferences(bundle, className, expr, checkAssignable), "refs", 3655, 141767, 141855);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 3657, 141866, 141905);
            if ((sm == null) || (refs == null)) {
                return refs;
            }
            List result = CallChecker.varInit(new ArrayList(), "result", 3664, 142006, 142035);
            for (int i = 0; i < (refs.length); i++) {
                TryContext _bcornu_try_context_229 = new TryContext(229, Felix.class, "java.lang.Exception");
                try {
                    ((SecurityManager) (sm)).checkPermission(new ServicePermission(refs[i], ServicePermission.GET));
                    if (CallChecker.beforeDeref(result, List.class, 3671, 142251, 142256)) {
                        result = CallChecker.beforeCalled(result, List.class, 3671, 142251, 142256);
                        CallChecker.isCalled(result, List.class, 3671, 142251, 142256).add(refs[i]);
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_229.catchStart(229);
                } finally {
                    _bcornu_try_context_229.finallyStart(229);
                }
            }
            if (CallChecker.beforeDeref(result, List.class, 3679, 142435, 142440)) {
                result = CallChecker.beforeCalled(result, List.class, 3679, 142435, 142440);
                if (CallChecker.isCalled(result, List.class, 3679, 142435, 142440).isEmpty()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(result, List.class, 3684, 142571, 142576)) {
                if (CallChecker.beforeDeref(result, List.class, 3684, 142535, 142540)) {
                    result = CallChecker.beforeCalled(result, List.class, 3684, 142571, 142576);
                    result = CallChecker.beforeCalled(result, List.class, 3684, 142535, 142540);
                    return ((ServiceReference[]) (CallChecker.isCalled(result, List.class, 3684, 142535, 142540).toArray(new ServiceReference[CallChecker.isCalled(result, List.class, 3684, 142571, 142576).size()])));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context654.methodEnd();
        }
    }

    <S> S getService(Bundle bundle, ServiceReference<S> ref, boolean isServiceObjetcs) {
        TryContext _bcornu_try_context_230 = new TryContext(230, Felix.class, "org.osgi.framework.ServiceException");
        try {
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3692, 142730, 142739)) {
                return m_registry.getService(bundle, ref, isServiceObjetcs);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ServiceException ex) {
            _bcornu_try_context_230.catchStart(230);
            if (CallChecker.beforeDeref(ref, ServiceReference.class, 3696, 142893, 142895)) {
                ref = CallChecker.beforeCalled(ref, ServiceReference.class, 3696, 142893, 142895);
                fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(ref, ServiceReference.class, 3696, 142893, 142895).getBundle(), ex);
            }
        } finally {
            _bcornu_try_context_230.finallyStart(230);
        }
        return null;
    }

    boolean ungetService(Bundle bundle, ServiceReference ref, Object srvObj) {
        MethodContext _bcornu_methode_context656 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 3702, 142958, 143102);
            CallChecker.varInit(srvObj, "srvObj", 3702, 142958, 143102);
            CallChecker.varInit(ref, "ref", 3702, 142958, 143102);
            CallChecker.varInit(bundle, "bundle", 3702, 142958, 143102);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3702, 142958, 143102);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3702, 142958, 143102);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3702, 142958, 143102);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3702, 142958, 143102);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3702, 142958, 143102);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3702, 142958, 143102);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3702, 142958, 143102);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3702, 142958, 143102);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3702, 142958, 143102);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3702, 142958, 143102);
            CallChecker.varInit(this.m_registry, "m_registry", 3702, 142958, 143102);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3702, 142958, 143102);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3702, 142958, 143102);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3702, 142958, 143102);
            CallChecker.varInit(this.m_cache, "m_cache", 3702, 142958, 143102);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3702, 142958, 143102);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3702, 142958, 143102);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3702, 142958, 143102);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3702, 142958, 143102);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3702, 142958, 143102);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3702, 142958, 143102);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3702, 142958, 143102);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3702, 142958, 143102);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3702, 142958, 143102);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3702, 142958, 143102);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3702, 142958, 143102);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3702, 142958, 143102);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3702, 142958, 143102);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3702, 142958, 143102);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3702, 142958, 143102);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3702, 142958, 143102);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3702, 142958, 143102);
            CallChecker.varInit(this.m_logger, "m_logger", 3702, 142958, 143102);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3702, 142958, 143102);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3702, 142958, 143102);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3702, 142958, 143102);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3702, 142958, 143102);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3704, 143052, 143061)) {
                return CallChecker.isCalled(m_registry, ServiceRegistry.class, 3704, 143052, 143061).ungetService(bundle, ref, srvObj);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context656.methodEnd();
        }
    }

    File getDataFile(BundleImpl bundle, String s) {
        MethodContext _bcornu_methode_context657 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 3707, 143109, 143772);
            CallChecker.varInit(s, "s", 3707, 143109, 143772);
            CallChecker.varInit(bundle, "bundle", 3707, 143109, 143772);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3707, 143109, 143772);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3707, 143109, 143772);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3707, 143109, 143772);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3707, 143109, 143772);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3707, 143109, 143772);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3707, 143109, 143772);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3707, 143109, 143772);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3707, 143109, 143772);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3707, 143109, 143772);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3707, 143109, 143772);
            CallChecker.varInit(this.m_registry, "m_registry", 3707, 143109, 143772);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3707, 143109, 143772);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3707, 143109, 143772);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3707, 143109, 143772);
            CallChecker.varInit(this.m_cache, "m_cache", 3707, 143109, 143772);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3707, 143109, 143772);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3707, 143109, 143772);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3707, 143109, 143772);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3707, 143109, 143772);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3707, 143109, 143772);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3707, 143109, 143772);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3707, 143109, 143772);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3707, 143109, 143772);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3707, 143109, 143772);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3707, 143109, 143772);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3707, 143109, 143772);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3707, 143109, 143772);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3707, 143109, 143772);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3707, 143109, 143772);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3707, 143109, 143772);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3707, 143109, 143772);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3707, 143109, 143772);
            CallChecker.varInit(this.m_logger, "m_logger", 3707, 143109, 143772);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3707, 143109, 143772);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3707, 143109, 143772);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3707, 143109, 143772);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3707, 143109, 143772);
            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3709, 143173, 143178)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3709, 143173, 143178);
                if ((CallChecker.isCalled(bundle, BundleImpl.class, 3709, 143173, 143178).getState()) == (Bundle.UNINSTALLED)) {
                    throw new IllegalStateException("Bundle has been uninstalled");
                }else
                    if (Util.isFragment(adapt(BundleRevision.class))) {
                        return null;
                    }
                
            }else
                throw new AbnormalExecutionError();
            
            TryContext _bcornu_try_context_231 = new TryContext(231, Felix.class, "java.lang.Exception");
            try {
                if (bundle == (this)) {
                    if (CallChecker.beforeDeref(m_cache, BundleCache.class, 3721, 143509, 143515)) {
                        m_cache = CallChecker.beforeCalled(m_cache, BundleCache.class, 3721, 143509, 143515);
                        return CallChecker.isCalled(m_cache, BundleCache.class, 3721, 143509, 143515).getSystemBundleDataFile(s);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 3724, 143579, 143584)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 3724, 143579, 143584);
                    final BundleArchive npe_invocation_var209 = CallChecker.isCalled(bundle, BundleImpl.class, 3724, 143579, 143584).getArchive();
                    if (CallChecker.beforeDeref(npe_invocation_var209, BundleArchive.class, 3724, 143579, 143597)) {
                        return CallChecker.isCalled(npe_invocation_var209, BundleArchive.class, 3724, 143579, 143597).getDataFile(s);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_231.catchStart(231);
                if (CallChecker.beforeDeref(m_logger, Logger.class, 3728, 143676, 143683)) {
                    CallChecker.isCalled(m_logger, Logger.class, 3728, 143676, 143683).log(bundle, Logger.LOG_ERROR, ex.getMessage());
                }
                return null;
            } finally {
                _bcornu_try_context_231.finallyStart(231);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context657.methodEnd();
        }
    }

    boolean isHookBlackListed(final ServiceReference sr) {
        MethodContext _bcornu_methode_context658 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 3737, 143779, 143964);
            CallChecker.varInit(sr, "sr", 3737, 143779, 143964);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3737, 143779, 143964);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3737, 143779, 143964);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3737, 143779, 143964);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3737, 143779, 143964);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3737, 143779, 143964);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3737, 143779, 143964);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3737, 143779, 143964);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3737, 143779, 143964);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3737, 143779, 143964);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3737, 143779, 143964);
            CallChecker.varInit(this.m_registry, "m_registry", 3737, 143779, 143964);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3737, 143779, 143964);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3737, 143779, 143964);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3737, 143779, 143964);
            CallChecker.varInit(this.m_cache, "m_cache", 3737, 143779, 143964);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3737, 143779, 143964);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3737, 143779, 143964);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3737, 143779, 143964);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3737, 143779, 143964);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3737, 143779, 143964);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3737, 143779, 143964);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3737, 143779, 143964);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3737, 143779, 143964);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3737, 143779, 143964);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3737, 143779, 143964);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3737, 143779, 143964);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3737, 143779, 143964);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3737, 143779, 143964);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3737, 143779, 143964);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3737, 143779, 143964);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3737, 143779, 143964);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3737, 143779, 143964);
            CallChecker.varInit(this.m_logger, "m_logger", 3737, 143779, 143964);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3737, 143779, 143964);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3737, 143779, 143964);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3737, 143779, 143964);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3737, 143779, 143964);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3739, 143908, 143917)) {
                final HookRegistry npe_invocation_var210 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 3739, 143908, 143917).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var210, HookRegistry.class, 3739, 143908, 143935)) {
                    return CallChecker.isCalled(npe_invocation_var210, HookRegistry.class, 3739, 143908, 143935).isHookBlackListed(sr);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context658.methodEnd();
        }
    }

    void blackListHook(final ServiceReference sr) {
        MethodContext _bcornu_methode_context659 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3742, 143971, 144083);
            CallChecker.varInit(sr, "sr", 3742, 143971, 144083);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3742, 143971, 144083);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3742, 143971, 144083);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3742, 143971, 144083);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3742, 143971, 144083);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3742, 143971, 144083);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3742, 143971, 144083);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3742, 143971, 144083);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3742, 143971, 144083);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3742, 143971, 144083);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3742, 143971, 144083);
            CallChecker.varInit(this.m_registry, "m_registry", 3742, 143971, 144083);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3742, 143971, 144083);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3742, 143971, 144083);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3742, 143971, 144083);
            CallChecker.varInit(this.m_cache, "m_cache", 3742, 143971, 144083);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3742, 143971, 144083);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3742, 143971, 144083);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3742, 143971, 144083);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3742, 143971, 144083);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3742, 143971, 144083);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3742, 143971, 144083);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3742, 143971, 144083);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3742, 143971, 144083);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3742, 143971, 144083);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3742, 143971, 144083);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3742, 143971, 144083);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3742, 143971, 144083);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3742, 143971, 144083);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3742, 143971, 144083);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3742, 143971, 144083);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3742, 143971, 144083);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3742, 143971, 144083);
            CallChecker.varInit(this.m_logger, "m_logger", 3742, 143971, 144083);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3742, 143971, 144083);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3742, 143971, 144083);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3742, 143971, 144083);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3742, 143971, 144083);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3744, 144031, 144040)) {
                final HookRegistry npe_invocation_var211 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 3744, 144031, 144040).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var211, HookRegistry.class, 3744, 144031, 144058)) {
                    CallChecker.isCalled(npe_invocation_var211, HookRegistry.class, 3744, 144031, 144058).blackListHook(sr);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context659.methodEnd();
        }
    }

    public <S> Set<ServiceReference<S>> getHooks(final Class<S> hookClass) {
        MethodContext _bcornu_methode_context660 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 3747, 144090, 144236);
            CallChecker.varInit(hookClass, "hookClass", 3747, 144090, 144236);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3747, 144090, 144236);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3747, 144090, 144236);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3747, 144090, 144236);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3747, 144090, 144236);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3747, 144090, 144236);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3747, 144090, 144236);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3747, 144090, 144236);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3747, 144090, 144236);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3747, 144090, 144236);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3747, 144090, 144236);
            CallChecker.varInit(this.m_registry, "m_registry", 3747, 144090, 144236);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3747, 144090, 144236);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3747, 144090, 144236);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3747, 144090, 144236);
            CallChecker.varInit(this.m_cache, "m_cache", 3747, 144090, 144236);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3747, 144090, 144236);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3747, 144090, 144236);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3747, 144090, 144236);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3747, 144090, 144236);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3747, 144090, 144236);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3747, 144090, 144236);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3747, 144090, 144236);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3747, 144090, 144236);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3747, 144090, 144236);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3747, 144090, 144236);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3747, 144090, 144236);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3747, 144090, 144236);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3747, 144090, 144236);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3747, 144090, 144236);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3747, 144090, 144236);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3747, 144090, 144236);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3747, 144090, 144236);
            CallChecker.varInit(this.m_logger, "m_logger", 3747, 144090, 144236);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3747, 144090, 144236);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3747, 144090, 144236);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3747, 144090, 144236);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3747, 144090, 144236);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 3749, 144182, 144191)) {
                final HookRegistry npe_invocation_var212 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 3749, 144182, 144191).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var212, HookRegistry.class, 3749, 144182, 144209)) {
                    return CallChecker.isCalled(npe_invocation_var212, HookRegistry.class, 3749, 144182, 144209).getHooks(hookClass);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<ServiceReference<S>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context660.methodEnd();
        }
    }

    private final Map<Class, Boolean> m_systemBundleClassCache = new WeakHashMap<Class, Boolean>();

    Bundle getBundle(Class clazz) {
        MethodContext _bcornu_methode_context661 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 3770, 144404, 146958);
            CallChecker.varInit(clazz, "clazz", 3770, 144404, 146958);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3770, 144404, 146958);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3770, 144404, 146958);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3770, 144404, 146958);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3770, 144404, 146958);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3770, 144404, 146958);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3770, 144404, 146958);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3770, 144404, 146958);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3770, 144404, 146958);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3770, 144404, 146958);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3770, 144404, 146958);
            CallChecker.varInit(this.m_registry, "m_registry", 3770, 144404, 146958);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3770, 144404, 146958);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3770, 144404, 146958);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3770, 144404, 146958);
            CallChecker.varInit(this.m_cache, "m_cache", 3770, 144404, 146958);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3770, 144404, 146958);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3770, 144404, 146958);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3770, 144404, 146958);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3770, 144404, 146958);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3770, 144404, 146958);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3770, 144404, 146958);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3770, 144404, 146958);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3770, 144404, 146958);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3770, 144404, 146958);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3770, 144404, 146958);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3770, 144404, 146958);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3770, 144404, 146958);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3770, 144404, 146958);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3770, 144404, 146958);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3770, 144404, 146958);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3770, 144404, 146958);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3770, 144404, 146958);
            CallChecker.varInit(this.m_logger, "m_logger", 3770, 144404, 146958);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3770, 144404, 146958);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3770, 144404, 146958);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3770, 144404, 146958);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3770, 144404, 146958);
            if (CallChecker.beforeDeref(clazz, Class.class, 3774, 145193, 145197)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 3774, 145193, 145197);
                if ((CallChecker.isCalled(clazz, Class.class, 3774, 145193, 145197).getClassLoader()) instanceof BundleReference) {
                    BundleReference br = CallChecker.init(BundleReference.class);
                    if (CallChecker.beforeDeref(clazz, Class.class, 3777, 145373, 145377)) {
                        clazz = CallChecker.beforeCalled(clazz, Class.class, 3777, 145373, 145377);
                        br = ((BundleReference) (CallChecker.isCalled(clazz, Class.class, 3777, 145373, 145377).getClassLoader()));
                        CallChecker.varAssign(br, "br", 3777, 145373, 145377);
                    }
                    if (CallChecker.beforeDeref(br, BundleReference.class, 3778, 145418, 145419)) {
                        if (CallChecker.beforeDeref(br, BundleReference.class, 3779, 145490, 145491)) {
                            br = CallChecker.beforeCalled(br, BundleReference.class, 3779, 145490, 145491);
                            final BundleImpl npe_invocation_var213 = ((BundleImpl) (CallChecker.isCalled(br, BundleReference.class, 3779, 145490, 145491).getBundle()));
                            if (CallChecker.beforeDeref(npe_invocation_var213, BundleImpl.class, 3779, 145490, 145503)) {
                                br = CallChecker.beforeCalled(br, BundleReference.class, 3778, 145418, 145419);
                                if (((CallChecker.isCalled(br, BundleReference.class, 3778, 145418, 145419).getBundle()) instanceof BundleImpl) && ((CallChecker.isCalled(npe_invocation_var213, BundleImpl.class, 3779, 145490, 145503).getFramework()) == (this))) {
                                    if (CallChecker.beforeDeref(br, BundleReference.class, 3780, 145553, 145554)) {
                                        br = CallChecker.beforeCalled(br, BundleReference.class, 3780, 145553, 145554);
                                        return CallChecker.isCalled(br, BundleReference.class, 3780, 145553, 145554).getBundle();
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else {
                                    return null;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(clazz, Class.class, 3784, 145726, 145730)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 3784, 145726, 145730);
                if (CallChecker.beforeDeref(CallChecker.isCalled(clazz, Class.class, 3784, 145726, 145730).getName(), String.class, 3784, 145726, 145740)) {
                    clazz = CallChecker.beforeCalled(clazz, Class.class, 3784, 145726, 145730);
                    if (!(CallChecker.isCalled(CallChecker.isCalled(clazz, Class.class, 3784, 145726, 145730).getName(), String.class, 3784, 145726, 145740).startsWith("java."))) {
                        Boolean fromSystemBundle = CallChecker.init(Boolean.class);
                        synchronized(m_systemBundleClassCache) {
                            if (CallChecker.beforeDeref(m_systemBundleClassCache, Map.class, 3789, 145912, 145935)) {
                                fromSystemBundle = CallChecker.isCalled(m_systemBundleClassCache, Map.class, 3789, 145912, 145935).get(clazz);
                                CallChecker.varAssign(fromSystemBundle, "fromSystemBundle", 3789, 145893, 145947);
                            }
                        }
                        if (fromSystemBundle == null) {
                            Class sbClass = CallChecker.varInit(null, "sbClass", 3793, 146035, 146055);
                            TryContext _bcornu_try_context_232 = new TryContext(232, Felix.class, "java.lang.ClassNotFoundException");
                            try {
                                if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 3796, 146145, 146162)) {
                                    final BundleRevision npe_invocation_var214 = CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 3796, 146145, 146162).getRevision();
                                    if (CallChecker.beforeDeref(npe_invocation_var214, BundleRevision.class, 3796, 146145, 146201)) {
                                        if (CallChecker.beforeDeref(clazz, Class.class, 3797, 146237, 146241)) {
                                            final BundleWiringImpl npe_invocation_var215 = ((BundleWiringImpl) (CallChecker.isCalled(npe_invocation_var214, BundleRevision.class, 3796, 146145, 146201).getWiring()));
                                            if (CallChecker.beforeDeref(npe_invocation_var215, BundleWiringImpl.class, 3796, 146145, 146213)) {
                                                clazz = CallChecker.beforeCalled(clazz, Class.class, 3797, 146237, 146241);
                                                sbClass = CallChecker.isCalled(npe_invocation_var215, BundleWiringImpl.class, 3796, 146145, 146213).getClassByDelegation(CallChecker.isCalled(clazz, Class.class, 3797, 146237, 146241).getName());
                                                CallChecker.varAssign(sbClass, "sbClass", 3796, 146115, 146253);
                                            }
                                        }
                                    }
                                }
                            } catch (ClassNotFoundException ex) {
                                _bcornu_try_context_232.catchStart(232);
                            } finally {
                                _bcornu_try_context_232.finallyStart(232);
                            }
                            synchronized(m_systemBundleClassCache) {
                                if (sbClass == clazz) {
                                    fromSystemBundle = Boolean.TRUE;
                                    CallChecker.varAssign(fromSystemBundle, "fromSystemBundle", 3807, 146568, 146599);
                                }else {
                                    fromSystemBundle = Boolean.FALSE;
                                    CallChecker.varAssign(fromSystemBundle, "fromSystemBundle", 3811, 146694, 146726);
                                }
                                if (CallChecker.beforeDeref(m_systemBundleClassCache, Map.class, 3813, 146770, 146793)) {
                                    CallChecker.isCalled(m_systemBundleClassCache, Map.class, 3813, 146770, 146793).put(clazz, fromSystemBundle);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(fromSystemBundle, Boolean.class, 3816, 146876, 146891)) {
                            fromSystemBundle = CallChecker.beforeCalled(fromSystemBundle, Boolean.class, 3816, 146876, 146891);
                            if (CallChecker.isCalled(fromSystemBundle, Boolean.class, 3816, 146876, 146891).booleanValue()) {
                                return this;
                            }else {
                                return null;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context661.methodEnd();
        }
    }

    ExportedPackage[] getExportedPackages(String pkgName) {
        MethodContext _bcornu_methode_context662 = new MethodContext(ExportedPackage[].class);
        try {
            CallChecker.varInit(this, "this", 3829, 146965, 151185);
            CallChecker.varInit(pkgName, "pkgName", 3829, 146965, 151185);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3829, 146965, 151185);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3829, 146965, 151185);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3829, 146965, 151185);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3829, 146965, 151185);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3829, 146965, 151185);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3829, 146965, 151185);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3829, 146965, 151185);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3829, 146965, 151185);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3829, 146965, 151185);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3829, 146965, 151185);
            CallChecker.varInit(this.m_registry, "m_registry", 3829, 146965, 151185);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3829, 146965, 151185);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3829, 146965, 151185);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3829, 146965, 151185);
            CallChecker.varInit(this.m_cache, "m_cache", 3829, 146965, 151185);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3829, 146965, 151185);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3829, 146965, 151185);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3829, 146965, 151185);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3829, 146965, 151185);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3829, 146965, 151185);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3829, 146965, 151185);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3829, 146965, 151185);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3829, 146965, 151185);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3829, 146965, 151185);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3829, 146965, 151185);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3829, 146965, 151185);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3829, 146965, 151185);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3829, 146965, 151185);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3829, 146965, 151185);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3829, 146965, 151185);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3829, 146965, 151185);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3829, 146965, 151185);
            CallChecker.varInit(this.m_logger, "m_logger", 3829, 146965, 151185);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3829, 146965, 151185);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3829, 146965, 151185);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3829, 146965, 151185);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3829, 146965, 151185);
            Map<String, Object> attrs = CallChecker.varInit(Collections.singletonMap(BundleRevision.PACKAGE_NAMESPACE, ((Object) (pkgName))), "attrs", 3832, 147402, 147519);
            BundleRequirementImpl req = CallChecker.varInit(new BundleRequirementImpl(null, BundleRevision.PACKAGE_NAMESPACE, Collections.EMPTY_MAP, attrs), "req", 3834, 147529, 147701);
            List<BundleCapability> exports = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 3839, 147744, 147753)) {
                exports = CallChecker.isCalled(m_resolver, StatefulResolver.class, 3839, 147744, 147753).findProviders(req, false);
                CallChecker.varAssign(exports, "exports", 3839, 147744, 147753);
            }
            exports = CallChecker.beforeCalled(exports, List.class, 3842, 147875, 147881);
            for (Iterator<BundleCapability> it = CallChecker.isCalled(exports, List.class, 3842, 147875, 147881).iterator(); CallChecker.isCalled(it, Iterator.class, 3842, 147895, 147896).hasNext();) {
                if (CallChecker.beforeDeref(it, Iterator.class, 3844, 147937, 147938)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(it, Iterator.class, 3844, 147937, 147938).next(), BundleCapability.class, 3844, 147937, 147945)) {
                        final BundleRevision npe_invocation_var216 = CallChecker.isCalled(CallChecker.isCalled(it, Iterator.class, 3844, 147937, 147938).next(), BundleCapability.class, 3844, 147937, 147945).getRevision();
                        if (CallChecker.beforeDeref(npe_invocation_var216, BundleRevision.class, 3844, 147937, 147959)) {
                            if ((CallChecker.isCalled(npe_invocation_var216, BundleRevision.class, 3844, 147937, 147959).getWiring()) == null) {
                                if (CallChecker.beforeDeref(it, Iterator.class, 3846, 148012, 148013)) {
                                    CallChecker.isCalled(it, Iterator.class, 3846, 148012, 148013).remove();
                                }
                            }
                        }
                    }
                }
            }
            if (exports != null) {
                List pkgs = CallChecker.varInit(new ArrayList(), "pkgs", 3852, 148101, 148128);
                for (Iterator<BundleCapability> it = exports.iterator(); CallChecker.isCalled(it, Iterator.class, 3854, 148200, 148201).hasNext();) {
                    Bundle bundle = CallChecker.init(Bundle.class);
                    if (CallChecker.beforeDeref(it, Iterator.class, 3857, 148344, 148345)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(it, Iterator.class, 3857, 148344, 148345).next(), BundleCapability.class, 3857, 148344, 148352)) {
                            final BundleRevision npe_invocation_var217 = CallChecker.isCalled(CallChecker.isCalled(it, Iterator.class, 3857, 148344, 148345).next(), BundleCapability.class, 3857, 148344, 148352).getRevision();
                            if (CallChecker.beforeDeref(npe_invocation_var217, BundleRevision.class, 3857, 148344, 148366)) {
                                bundle = CallChecker.isCalled(npe_invocation_var217, BundleRevision.class, 3857, 148344, 148366).getBundle();
                                CallChecker.varAssign(bundle, "bundle", 3857, 148344, 148345);
                            }
                        }
                    }
                    List<BundleRevision> originRevisions = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(bundle, Bundle.class, 3869, 149166, 149171)) {
                        bundle = CallChecker.beforeCalled(bundle, Bundle.class, 3869, 149166, 149171);
                        final BundleRevisions npe_invocation_var218 = CallChecker.isCalled(bundle, Bundle.class, 3869, 149166, 149171).adapt(BundleRevisions.class);
                        if (CallChecker.beforeDeref(npe_invocation_var218, BundleRevisions.class, 3869, 149166, 149200)) {
                            originRevisions = CallChecker.isCalled(npe_invocation_var218, BundleRevisions.class, 3869, 149166, 149200).getRevisions();
                            CallChecker.varAssign(originRevisions, "originRevisions", 3869, 149166, 149171);
                        }
                    }
                    originRevisions = CallChecker.beforeCalled(originRevisions, List.class, 3870, 149247, 149261);
                    for (int i = (CallChecker.isCalled(originRevisions, List.class, 3870, 149247, 149261).size()) - 1; i >= 0; i--) {
                        BundleRevision originBr = CallChecker.init(BundleRevision.class);
                        if (CallChecker.beforeDeref(originRevisions, List.class, 3872, 149352, 149366)) {
                            originRevisions = CallChecker.beforeCalled(originRevisions, List.class, 3872, 149352, 149366);
                            originBr = CallChecker.isCalled(originRevisions, List.class, 3872, 149352, 149366).get(i);
                            CallChecker.varAssign(originBr, "originBr", 3872, 149352, 149366);
                        }
                        List<BundleRevision> revisions = CallChecker.varInit(Collections.singletonList(originBr), "revisions", 3873, 149396, 149464);
                        if (CallChecker.beforeDeref(originBr, BundleRevision.class, 3875, 149492, 149499)) {
                            originBr = CallChecker.beforeCalled(originBr, BundleRevision.class, 3875, 149492, 149499);
                            if (((CallChecker.isCalled(originBr, BundleRevision.class, 3875, 149492, 149499).getTypes()) & (BundleRevision.TYPE_FRAGMENT)) != 0) {
                                revisions = new ArrayList<BundleRevision>();
                                CallChecker.varAssign(revisions, "revisions", 3880, 149828, 149871);
                                originBr = CallChecker.beforeCalled(originBr, BundleRevision.class, 3882, 149919, 149926);
                                for (BundleWire bw : CallChecker.isCalled(CallChecker.isCalled(originBr, BundleRevision.class, 3882, 149919, 149926).getWiring(), BundleWiring.class, 3882, 149919, 149938).getRequiredWires(HostNamespace.HOST_NAMESPACE)) {
                                    if (CallChecker.beforeDeref(bw, BundleWire.class, 3884, 150056, 150057)) {
                                        final BundleWiring npe_invocation_var219 = CallChecker.isCalled(bw, BundleWire.class, 3884, 150056, 150057).getProviderWiring();
                                        if (CallChecker.beforeDeref(npe_invocation_var219, BundleWiring.class, 3884, 150056, 150077)) {
                                            if (CallChecker.beforeDeref(revisions, List.class, 3884, 150042, 150050)) {
                                                revisions = CallChecker.beforeCalled(revisions, List.class, 3884, 150042, 150050);
                                                CallChecker.isCalled(revisions, List.class, 3884, 150042, 150050).add(CallChecker.isCalled(npe_invocation_var219, BundleWiring.class, 3884, 150056, 150077).getRevision());
                                            }
                                        }
                                    }
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(revisions, ExportedPackage[].class, 3888, 150189, 150197)) {
                            for (BundleRevision br : revisions) {
                                List<BundleCapability> caps = CallChecker.init(List.class);
                                if (CallChecker.beforeDeref(br, BundleRevision.class, 3890, 150277, 150278)) {
                                    if ((CallChecker.isCalled(br, BundleRevision.class, 3890, 150277, 150278).getWiring()) == null) {
                                        if (CallChecker.beforeDeref(br, BundleRevision.class, 3891, 150331, 150332)) {
                                            caps = CallChecker.isCalled(br, BundleRevision.class, 3891, 150331, 150332).getDeclaredCapabilities(null);
                                            CallChecker.varAssign(caps, "caps", 3890, 150276, 150429);
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(br, BundleRevision.class, 3892, 150394, 150395)) {
                                            caps = CallChecker.isCalled(br, BundleRevision.class, 3892, 150394, 150395).getWiring().getCapabilities(null);
                                            CallChecker.varAssign(caps, "caps", 3890, 150276, 150429);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(caps, ExportedPackage[].class, 3893, 150484, 150487)) {
                                    for (BundleCapability cap : caps) {
                                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 3895, 150548, 150550)) {
                                            if (CallChecker.beforeDeref(req, BundleRequirementImpl.class, 3895, 150574, 150576)) {
                                                final String npe_invocation_var220 = CallChecker.isCalled(cap, BundleCapability.class, 3895, 150548, 150550).getNamespace();
                                                if (CallChecker.beforeDeref(npe_invocation_var220, String.class, 3895, 150548, 150565)) {
                                                    if (CallChecker.beforeDeref(req, BundleRequirementImpl.class, 3896, 150656, 150658)) {
                                                        req = CallChecker.beforeCalled(req, BundleRequirementImpl.class, 3895, 150574, 150576);
                                                        req = CallChecker.beforeCalled(req, BundleRequirementImpl.class, 3896, 150656, 150658);
                                                        if ((CallChecker.isCalled(npe_invocation_var220, String.class, 3895, 150548, 150565).equals(CallChecker.isCalled(req, BundleRequirementImpl.class, 3895, 150574, 150576).getNamespace())) && (CapabilitySet.matches(cap, CallChecker.isCalled(req, BundleRequirementImpl.class, 3896, 150656, 150658).getFilter()))) {
                                                            if (CallChecker.beforeDeref(br, BundleRevision.class, 3900, 150866, 150867)) {
                                                                if (CallChecker.beforeDeref(pkgs, List.class, 3898, 150736, 150739)) {
                                                                    pkgs = CallChecker.beforeCalled(pkgs, List.class, 3898, 150736, 150739);
                                                                    CallChecker.isCalled(pkgs, List.class, 3898, 150736, 150739).add(new ExportedPackageImpl(this, ((BundleImpl) (CallChecker.isCalled(br, BundleRevision.class, 3900, 150866, 150867).getBundle())), br, cap));
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
                if (CallChecker.beforeDeref(pkgs, List.class, 3907, 151024, 151027)) {
                    pkgs = CallChecker.beforeCalled(pkgs, List.class, 3907, 151024, 151027);
                    if (CallChecker.isCalled(pkgs, List.class, 3907, 151024, 151027).isEmpty()) {
                        return null;
                    }else {
                        if (CallChecker.beforeDeref(pkgs, List.class, 3909, 151134, 151137)) {
                            if (CallChecker.beforeDeref(pkgs, List.class, 3909, 151101, 151104)) {
                                pkgs = CallChecker.beforeCalled(pkgs, List.class, 3909, 151134, 151137);
                                pkgs = CallChecker.beforeCalled(pkgs, List.class, 3909, 151101, 151104);
                                return ((ExportedPackage[]) (CallChecker.isCalled(pkgs, List.class, 3909, 151101, 151104).toArray(new ExportedPackage[CallChecker.isCalled(pkgs, List.class, 3909, 151134, 151137).size()])));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExportedPackage[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context662.methodEnd();
        }
    }

    ExportedPackage[] getExportedPackages(Bundle b) {
        MethodContext _bcornu_methode_context663 = new MethodContext(ExportedPackage[].class);
        try {
            CallChecker.varInit(this, "this", 3925, 151192, 153589);
            CallChecker.varInit(b, "b", 3925, 151192, 153589);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3925, 151192, 153589);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3925, 151192, 153589);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3925, 151192, 153589);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3925, 151192, 153589);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3925, 151192, 153589);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3925, 151192, 153589);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3925, 151192, 153589);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3925, 151192, 153589);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3925, 151192, 153589);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3925, 151192, 153589);
            CallChecker.varInit(this.m_registry, "m_registry", 3925, 151192, 153589);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3925, 151192, 153589);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3925, 151192, 153589);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3925, 151192, 153589);
            CallChecker.varInit(this.m_cache, "m_cache", 3925, 151192, 153589);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3925, 151192, 153589);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3925, 151192, 153589);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3925, 151192, 153589);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3925, 151192, 153589);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3925, 151192, 153589);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3925, 151192, 153589);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3925, 151192, 153589);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3925, 151192, 153589);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3925, 151192, 153589);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3925, 151192, 153589);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3925, 151192, 153589);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3925, 151192, 153589);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3925, 151192, 153589);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3925, 151192, 153589);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3925, 151192, 153589);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3925, 151192, 153589);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3925, 151192, 153589);
            CallChecker.varInit(this.m_logger, "m_logger", 3925, 151192, 153589);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3925, 151192, 153589);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3925, 151192, 153589);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3925, 151192, 153589);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3925, 151192, 153589);
            List list = CallChecker.varInit(new ArrayList(), "list", 3927, 151709, 151736);
            if (b != null) {
                BundleImpl bundle = CallChecker.varInit(((BundleImpl) (b)), "bundle", 3933, 151867, 151901);
                getExportedPackages(bundle, list);
            }else {
                boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 3941, 152182, 152218);
                if (!locked) {
                    throw new IllegalStateException("Unable to acquire global lock to retrieve exported packages.");
                }
                TryContext _bcornu_try_context_233 = new TryContext(233, Felix.class);
                try {
                    m_uninstalledBundles = CallChecker.beforeCalled(m_uninstalledBundles, List.class, 3953, 152747, 152766);
                    for (int bundleIdx = 0; ((m_uninstalledBundles) != null) && (bundleIdx < (CallChecker.isCalled(m_uninstalledBundles, List.class, 3953, 152747, 152766).size())); bundleIdx++) {
                        BundleImpl bundle = CallChecker.varInit(m_uninstalledBundles.get(bundleIdx), "bundle", 3956, 152848, 152903);
                        getExportedPackages(bundle, list);
                    }
                    Bundle[] bundles = CallChecker.varInit(getBundles(), "bundles", 3961, 153064, 153095);
                    bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 3962, 153149, 153155);
                    for (int bundleIdx = 0; bundleIdx < (CallChecker.isCalled(bundles, Bundle[].class, 3962, 153149, 153155).length); bundleIdx++) {
                        BundleImpl bundle = CallChecker.init(BundleImpl.class);
                        if (CallChecker.beforeDeref(bundles, Bundle[].class, 3964, 153249, 153255)) {
                            bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 3964, 153249, 153255);
                            bundle = ((BundleImpl) (CallChecker.isCalled(bundles, Bundle[].class, 3964, 153249, 153255)[bundleIdx]));
                            CallChecker.varAssign(bundle, "bundle", 3964, 153249, 153255);
                        }
                        getExportedPackages(bundle, list);
                    }
                } finally {
                    _bcornu_try_context_233.finallyStart(233);
                    releaseGlobalLock();
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 3974, 153468, 153471)) {
                list = CallChecker.beforeCalled(list, List.class, 3974, 153468, 153471);
                if (CallChecker.isCalled(list, List.class, 3974, 153468, 153471).isEmpty()) {
                    return null;
                }else {
                    if (CallChecker.beforeDeref(list, List.class, 3976, 153570, 153573)) {
                        if (CallChecker.beforeDeref(list, List.class, 3976, 153537, 153540)) {
                            list = CallChecker.beforeCalled(list, List.class, 3976, 153570, 153573);
                            list = CallChecker.beforeCalled(list, List.class, 3976, 153537, 153540);
                            return ((ExportedPackage[]) (CallChecker.isCalled(list, List.class, 3976, 153537, 153540).toArray(new ExportedPackage[CallChecker.isCalled(list, List.class, 3976, 153570, 153573).size()])));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExportedPackage[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context663.methodEnd();
        }
    }

    private void getExportedPackages(Bundle bundle, List list) {
        MethodContext _bcornu_methode_context664 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 3985, 153596, 154934);
            CallChecker.varInit(list, "list", 3985, 153596, 154934);
            CallChecker.varInit(bundle, "bundle", 3985, 153596, 154934);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 3985, 153596, 154934);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 3985, 153596, 154934);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 3985, 153596, 154934);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 3985, 153596, 154934);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 3985, 153596, 154934);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 3985, 153596, 154934);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 3985, 153596, 154934);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 3985, 153596, 154934);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 3985, 153596, 154934);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 3985, 153596, 154934);
            CallChecker.varInit(this.m_registry, "m_registry", 3985, 153596, 154934);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 3985, 153596, 154934);
            CallChecker.varInit(this.m_nextId, "m_nextId", 3985, 153596, 154934);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 3985, 153596, 154934);
            CallChecker.varInit(this.m_cache, "m_cache", 3985, 153596, 154934);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 3985, 153596, 154934);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 3985, 153596, 154934);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 3985, 153596, 154934);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 3985, 153596, 154934);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 3985, 153596, 154934);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 3985, 153596, 154934);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 3985, 153596, 154934);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 3985, 153596, 154934);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 3985, 153596, 154934);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 3985, 153596, 154934);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 3985, 153596, 154934);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 3985, 153596, 154934);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 3985, 153596, 154934);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 3985, 153596, 154934);
            CallChecker.varInit(this.m_resolver, "m_resolver", 3985, 153596, 154934);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 3985, 153596, 154934);
            CallChecker.varInit(this.m_configMap, "m_configMap", 3985, 153596, 154934);
            CallChecker.varInit(this.m_logger, "m_logger", 3985, 153596, 154934);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 3985, 153596, 154934);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 3985, 153596, 154934);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 3985, 153596, 154934);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 3985, 153596, 154934);
            bundle = CallChecker.beforeCalled(bundle, Bundle.class, 3990, 154127, 154132);
            for (BundleRevision br : CallChecker.isCalled(CallChecker.isCalled(bundle, Bundle.class, 3990, 154127, 154132).adapt(BundleRevisions.class), BundleRevisions.class, 3990, 154127, 154161).getRevisions()) {
                List<BundleCapability> caps = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(br, BundleRevision.class, 3992, 154232, 154233)) {
                    if ((CallChecker.isCalled(br, BundleRevision.class, 3992, 154232, 154233).getWiring()) == null) {
                        if (CallChecker.beforeDeref(br, BundleRevision.class, 3993, 154274, 154275)) {
                            caps = CallChecker.isCalled(br, BundleRevision.class, 3993, 154274, 154275).getDeclaredCapabilities(null);
                            CallChecker.varAssign(caps, "caps", 3992, 154231, 154360);
                        }
                    }else {
                        if (CallChecker.beforeDeref(br, BundleRevision.class, 3994, 154325, 154326)) {
                            caps = CallChecker.isCalled(br, BundleRevision.class, 3994, 154325, 154326).getWiring().getCapabilities(null);
                            CallChecker.varAssign(caps, "caps", 3992, 154231, 154360);
                        }
                    }
                }
                if ((caps != null) && ((caps.size()) > 0)) {
                    for (BundleCapability cap : caps) {
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 3999, 154522, 154524)) {
                            final String npe_invocation_var221 = CallChecker.isCalled(cap, BundleCapability.class, 3999, 154522, 154524).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var221, String.class, 3999, 154522, 154539)) {
                                if (CallChecker.isCalled(npe_invocation_var221, String.class, 3999, 154522, 154539).equals(BundleRevision.PACKAGE_NAMESPACE)) {
                                    String pkgName = CallChecker.init(String.class);
                                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 4002, 154683, 154685)) {
                                        final Map<String, Object> npe_invocation_var222 = CallChecker.isCalled(cap, BundleCapability.class, 4002, 154683, 154685).getAttributes();
                                        if (CallChecker.beforeDeref(npe_invocation_var222, Map.class, 4002, 154683, 154701)) {
                                            pkgName = ((String) (CallChecker.isCalled(npe_invocation_var222, Map.class, 4002, 154683, 154701).get(BundleRevision.PACKAGE_NAMESPACE)));
                                            CallChecker.varAssign(pkgName, "pkgName", 4002, 154683, 154685);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(list, List.class, 4003, 154766, 154769)) {
                                        list = CallChecker.beforeCalled(list, List.class, 4003, 154766, 154769);
                                        CallChecker.isCalled(list, List.class, 4003, 154766, 154769).add(new ExportedPackageImpl(this, ((BundleImpl) (bundle)), br, cap));
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
            _bcornu_methode_context664.methodEnd();
        }
    }

    Set<Bundle> getImportingBundles(BundleImpl exporter, BundleCapability cap) {
        MethodContext _bcornu_methode_context665 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 4012, 154941, 155130);
            CallChecker.varInit(cap, "cap", 4012, 154941, 155130);
            CallChecker.varInit(exporter, "exporter", 4012, 154941, 155130);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4012, 154941, 155130);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4012, 154941, 155130);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4012, 154941, 155130);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4012, 154941, 155130);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4012, 154941, 155130);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4012, 154941, 155130);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4012, 154941, 155130);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4012, 154941, 155130);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4012, 154941, 155130);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4012, 154941, 155130);
            CallChecker.varInit(this.m_registry, "m_registry", 4012, 154941, 155130);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4012, 154941, 155130);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4012, 154941, 155130);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4012, 154941, 155130);
            CallChecker.varInit(this.m_cache, "m_cache", 4012, 154941, 155130);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4012, 154941, 155130);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4012, 154941, 155130);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4012, 154941, 155130);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4012, 154941, 155130);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4012, 154941, 155130);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4012, 154941, 155130);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4012, 154941, 155130);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4012, 154941, 155130);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4012, 154941, 155130);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4012, 154941, 155130);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4012, 154941, 155130);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4012, 154941, 155130);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4012, 154941, 155130);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4012, 154941, 155130);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4012, 154941, 155130);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4012, 154941, 155130);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4012, 154941, 155130);
            CallChecker.varInit(this.m_logger, "m_logger", 4012, 154941, 155130);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4012, 154941, 155130);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4012, 154941, 155130);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4012, 154941, 155130);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4012, 154941, 155130);
            if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 4014, 155075, 155088)) {
                return CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 4014, 155075, 155088).getImportingBundles(exporter, cap);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context665.methodEnd();
        }
    }

    Set<Bundle> getRequiringBundles(BundleImpl bundle) {
        MethodContext _bcornu_methode_context666 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 4018, 155137, 155294);
            CallChecker.varInit(bundle, "bundle", 4018, 155137, 155294);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4018, 155137, 155294);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4018, 155137, 155294);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4018, 155137, 155294);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4018, 155137, 155294);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4018, 155137, 155294);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4018, 155137, 155294);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4018, 155137, 155294);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4018, 155137, 155294);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4018, 155137, 155294);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4018, 155137, 155294);
            CallChecker.varInit(this.m_registry, "m_registry", 4018, 155137, 155294);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4018, 155137, 155294);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4018, 155137, 155294);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4018, 155137, 155294);
            CallChecker.varInit(this.m_cache, "m_cache", 4018, 155137, 155294);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4018, 155137, 155294);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4018, 155137, 155294);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4018, 155137, 155294);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4018, 155137, 155294);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4018, 155137, 155294);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4018, 155137, 155294);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4018, 155137, 155294);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4018, 155137, 155294);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4018, 155137, 155294);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4018, 155137, 155294);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4018, 155137, 155294);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4018, 155137, 155294);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4018, 155137, 155294);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4018, 155137, 155294);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4018, 155137, 155294);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4018, 155137, 155294);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4018, 155137, 155294);
            CallChecker.varInit(this.m_logger, "m_logger", 4018, 155137, 155294);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4018, 155137, 155294);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4018, 155137, 155294);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4018, 155137, 155294);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4018, 155137, 155294);
            if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 4020, 155246, 155259)) {
                return CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 4020, 155246, 155259).getRequiringBundles(bundle);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context666.methodEnd();
        }
    }

    boolean resolveBundles(Collection<Bundle> targets) {
        MethodContext _bcornu_methode_context667 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 4023, 155301, 157956);
            CallChecker.varInit(targets, "targets", 4023, 155301, 157956);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4023, 155301, 157956);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4023, 155301, 157956);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4023, 155301, 157956);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4023, 155301, 157956);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4023, 155301, 157956);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4023, 155301, 157956);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4023, 155301, 157956);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4023, 155301, 157956);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4023, 155301, 157956);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4023, 155301, 157956);
            CallChecker.varInit(this.m_registry, "m_registry", 4023, 155301, 157956);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4023, 155301, 157956);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4023, 155301, 157956);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4023, 155301, 157956);
            CallChecker.varInit(this.m_cache, "m_cache", 4023, 155301, 157956);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4023, 155301, 157956);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4023, 155301, 157956);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4023, 155301, 157956);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4023, 155301, 157956);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4023, 155301, 157956);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4023, 155301, 157956);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4023, 155301, 157956);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4023, 155301, 157956);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4023, 155301, 157956);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4023, 155301, 157956);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4023, 155301, 157956);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4023, 155301, 157956);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4023, 155301, 157956);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4023, 155301, 157956);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4023, 155301, 157956);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4023, 155301, 157956);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4023, 155301, 157956);
            CallChecker.varInit(this.m_logger, "m_logger", 4023, 155301, 157956);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4023, 155301, 157956);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4023, 155301, 157956);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4023, 155301, 157956);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4023, 155301, 157956);
            boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 4026, 155398, 155434);
            if (!locked) {
                if (CallChecker.beforeDeref(m_logger, Logger.class, 4029, 155479, 155486)) {
                    CallChecker.isCalled(m_logger, Logger.class, 4029, 155479, 155486).log(Logger.LOG_WARNING, "Unable to acquire global lock to perform resolve.", null);
                }
                return false;
            }
            TryContext _bcornu_try_context_235 = new TryContext(235, Felix.class);
            try {
                Collection<Bundle> originalTargets = CallChecker.varInit(targets, "originalTargets", 4039, 155734, 155778);
                if (targets == null) {
                    if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 4046, 156035, 156052)) {
                        m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 4046, 156035, 156052);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m_installedBundles, Map[].class, 4046, 156035, 156052)[Felix.LOCATION_MAP_IDX], Map.class, 4046, 156035, 156070)) {
                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 4046, 156035, 156052);
                            CallChecker.isCalled(m_installedBundles, Map[].class, 4046, 156035, 156052)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 4046, 156035, 156052)[Felix.LOCATION_MAP_IDX], Map.class, 4046, 156035, 156070);
                            targets = CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 4046, 156035, 156052)[Felix.LOCATION_MAP_IDX], Map.class, 4046, 156035, 156070).values();
                            CallChecker.varAssign(targets, "targets", 4046, 156025, 156080);
                        }
                    }
                }
                boolean result = CallChecker.varInit(((boolean) (true)), "result", 4050, 156156, 156177);
                if (CallChecker.beforeDeref(targets, Collection.class, 4053, 156257, 156263)) {
                    targets = CallChecker.beforeCalled(targets, Collection.class, 4053, 156257, 156263);
                    if (!(CallChecker.isCalled(targets, Collection.class, 4053, 156257, 156263).isEmpty())) {
                        Set<BundleRevision> revisions = CallChecker.init(Set.class);
                        if (CallChecker.beforeDeref(targets, Collection.class, 4057, 156458, 156464)) {
                            targets = CallChecker.beforeCalled(targets, Collection.class, 4057, 156458, 156464);
                            revisions = new HashSet<BundleRevision>(CallChecker.isCalled(targets, Collection.class, 4057, 156458, 156464).size());
                            CallChecker.varAssign(revisions, "revisions", 4057, 156458, 156464);
                        }
                        if (CallChecker.beforeDeref(targets, boolean.class, 4058, 156507, 156513)) {
                            for (Bundle b : targets) {
                                if (CallChecker.beforeDeref(b, Bundle.class, 4060, 156558, 156558)) {
                                    if ((CallChecker.isCalled(b, Bundle.class, 4060, 156558, 156558).getState()) != (Bundle.UNINSTALLED)) {
                                        if (CallChecker.beforeDeref(b, Bundle.class, 4062, 156654, 156654)) {
                                            if (CallChecker.beforeDeref(revisions, Set.class, 4062, 156640, 156648)) {
                                                revisions = CallChecker.beforeCalled(revisions, Set.class, 4062, 156640, 156648);
                                                CallChecker.isCalled(revisions, Set.class, 4062, 156640, 156648).add(CallChecker.isCalled(b, Bundle.class, 4062, 156654, 156654).adapt(BundleRevision.class));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(revisions, Set.class, 4067, 156938, 156946)) {
                            revisions = CallChecker.beforeCalled(revisions, Set.class, 4067, 156938, 156946);
                            if ((originalTargets != null) && ((originalTargets.size()) != (CallChecker.isCalled(revisions, Set.class, 4067, 156938, 156946).size()))) {
                                result = false;
                                CallChecker.varAssign(result, "result", 4069, 156995, 157009);
                            }
                        }
                        TryContext _bcornu_try_context_234 = new TryContext(234, Felix.class, "org.osgi.service.resolver.ResolutionException", "org.osgi.framework.BundleException");
                        try {
                            if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 4073, 157087, 157096)) {
                                CallChecker.isCalled(m_resolver, StatefulResolver.class, 4073, 157087, 157096).resolve(Collections.EMPTY_SET, revisions);
                            }
                            if (result) {
                                if (CallChecker.beforeDeref(revisions, boolean.class, 4076, 157244, 157252)) {
                                    for (BundleRevision br : revisions) {
                                        if (CallChecker.beforeDeref(br, BundleRevision.class, 4078, 157313, 157314)) {
                                            if ((CallChecker.isCalled(br, BundleRevision.class, 4078, 157313, 157314).getWiring()) == null) {
                                                result = false;
                                                CallChecker.varAssign(result, "result", 4080, 157399, 157413);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (ResolutionException ex) {
                            _bcornu_try_context_234.catchStart(234);
                            result = false;
                            CallChecker.varAssign(result, "result", 4088, 157635, 157649);
                        } catch (BundleException ex) {
                            _bcornu_try_context_234.catchStart(234);
                            result = false;
                            CallChecker.varAssign(result, "result", 4092, 157750, 157764);
                        } finally {
                            _bcornu_try_context_234.finallyStart(234);
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return result;
            } finally {
                _bcornu_try_context_235.finallyStart(235);
                releaseGlobalLock();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context667.methodEnd();
        }
    }

    private void resolveBundleRevision(BundleRevision revision) throws BundleException {
        MethodContext _bcornu_methode_context668 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4105, 157963, 158418);
            CallChecker.varInit(revision, "revision", 4105, 157963, 158418);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4105, 157963, 158418);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4105, 157963, 158418);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4105, 157963, 158418);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4105, 157963, 158418);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4105, 157963, 158418);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4105, 157963, 158418);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4105, 157963, 158418);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4105, 157963, 158418);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4105, 157963, 158418);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4105, 157963, 158418);
            CallChecker.varInit(this.m_registry, "m_registry", 4105, 157963, 158418);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4105, 157963, 158418);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4105, 157963, 158418);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4105, 157963, 158418);
            CallChecker.varInit(this.m_cache, "m_cache", 4105, 157963, 158418);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4105, 157963, 158418);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4105, 157963, 158418);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4105, 157963, 158418);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4105, 157963, 158418);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4105, 157963, 158418);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4105, 157963, 158418);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4105, 157963, 158418);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4105, 157963, 158418);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4105, 157963, 158418);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4105, 157963, 158418);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4105, 157963, 158418);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4105, 157963, 158418);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4105, 157963, 158418);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4105, 157963, 158418);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4105, 157963, 158418);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4105, 157963, 158418);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4105, 157963, 158418);
            CallChecker.varInit(this.m_logger, "m_logger", 4105, 157963, 158418);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4105, 157963, 158418);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4105, 157963, 158418);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4105, 157963, 158418);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4105, 157963, 158418);
            TryContext _bcornu_try_context_236 = new TryContext(236, Felix.class, "org.osgi.service.resolver.ResolutionException");
            try {
                if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 4109, 158086, 158095)) {
                    CallChecker.isCalled(m_resolver, StatefulResolver.class, 4109, 158086, 158095).resolve(Collections.singleton(revision), Collections.EMPTY_SET);
                }
            } catch (ResolutionException ex) {
                _bcornu_try_context_236.catchStart(236);
                throw new BundleException((((ex.getMessage()) + " Unresolved requirements: ") + (ex.getUnresolvedRequirements())), BundleException.RESOLVE_ERROR);
            } finally {
                _bcornu_try_context_236.finallyStart(236);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context668.methodEnd();
        }
    }

    void refreshPackages(Collection<Bundle> targets, FrameworkListener[] listeners) {
        MethodContext _bcornu_methode_context669 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4119, 158425, 164897);
            CallChecker.varInit(listeners, "listeners", 4119, 158425, 164897);
            CallChecker.varInit(targets, "targets", 4119, 158425, 164897);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4119, 158425, 164897);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4119, 158425, 164897);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4119, 158425, 164897);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4119, 158425, 164897);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4119, 158425, 164897);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4119, 158425, 164897);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4119, 158425, 164897);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4119, 158425, 164897);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4119, 158425, 164897);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4119, 158425, 164897);
            CallChecker.varInit(this.m_registry, "m_registry", 4119, 158425, 164897);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4119, 158425, 164897);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4119, 158425, 164897);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4119, 158425, 164897);
            CallChecker.varInit(this.m_cache, "m_cache", 4119, 158425, 164897);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4119, 158425, 164897);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4119, 158425, 164897);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4119, 158425, 164897);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4119, 158425, 164897);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4119, 158425, 164897);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4119, 158425, 164897);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4119, 158425, 164897);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4119, 158425, 164897);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4119, 158425, 164897);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4119, 158425, 164897);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4119, 158425, 164897);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4119, 158425, 164897);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4119, 158425, 164897);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4119, 158425, 164897);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4119, 158425, 164897);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4119, 158425, 164897);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4119, 158425, 164897);
            CallChecker.varInit(this.m_logger, "m_logger", 4119, 158425, 164897);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4119, 158425, 164897);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4119, 158425, 164897);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4119, 158425, 164897);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4119, 158425, 164897);
            boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 4122, 158551, 158587);
            if (!locked) {
                throw new IllegalStateException("Unable to acquire global lock for refresh.");
            }
            Collection<Bundle> newTargets = CallChecker.varInit(targets, "newTargets", 4137, 159281, 159320);
            if (newTargets == null) {
                List<Bundle> list = CallChecker.varInit(new ArrayList<Bundle>(), "list", 4140, 159376, 159419);
                m_uninstalledBundles = CallChecker.beforeCalled(m_uninstalledBundles, List.class, 4144, 159555, 159574);
                for (int i = 0; ((m_uninstalledBundles) != null) && (i < (CallChecker.isCalled(m_uninstalledBundles, List.class, 4144, 159555, 159574).size())); i++) {
                    if (CallChecker.beforeDeref(list, List.class, 4147, 159636, 159639)) {
                        list = CallChecker.beforeCalled(list, List.class, 4147, 159636, 159639);
                        CallChecker.isCalled(list, List.class, 4147, 159636, 159639).add(m_uninstalledBundles.get(i));
                    }
                }
                Iterator iter = CallChecker.init(Iterator.class);
                if (CallChecker.beforeDeref(m_installedBundles, Map[].class, 4151, 159763, 159780)) {
                    m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 4151, 159763, 159780);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_installedBundles, Map[].class, 4151, 159763, 159780)[Felix.LOCATION_MAP_IDX], Map.class, 4151, 159763, 159798)) {
                        m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 4151, 159763, 159780);
                        CallChecker.isCalled(m_installedBundles, Map[].class, 4151, 159763, 159780)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 4151, 159763, 159780)[Felix.LOCATION_MAP_IDX], Map.class, 4151, 159763, 159798);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 4151, 159763, 159780)[Felix.LOCATION_MAP_IDX], Map.class, 4151, 159763, 159798).values(), Collection.class, 4151, 159763, 159807)) {
                            m_installedBundles = CallChecker.beforeCalled(m_installedBundles, Map[].class, 4151, 159763, 159780);
                            CallChecker.isCalled(m_installedBundles, Map[].class, 4151, 159763, 159780)[Felix.LOCATION_MAP_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 4151, 159763, 159780)[Felix.LOCATION_MAP_IDX], Map.class, 4151, 159763, 159798);
                            iter = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(m_installedBundles, Map[].class, 4151, 159763, 159780)[Felix.LOCATION_MAP_IDX], Map.class, 4151, 159763, 159798).values(), Collection.class, 4151, 159763, 159807).iterator();
                            CallChecker.varAssign(iter, "iter", 4151, 159763, 159780);
                        }
                    }
                }
                iter = CallChecker.beforeCalled(iter, Iterator.class, 4152, 159840, 159843);
                while (CallChecker.isCalled(iter, Iterator.class, 4152, 159840, 159843).hasNext()) {
                    BundleImpl bundle = CallChecker.init(BundleImpl.class);
                    if (CallChecker.beforeDeref(iter, Iterator.class, 4154, 159919, 159922)) {
                        iter = CallChecker.beforeCalled(iter, Iterator.class, 4154, 159919, 159922);
                        bundle = ((BundleImpl) (CallChecker.isCalled(iter, Iterator.class, 4154, 159919, 159922).next()));
                        CallChecker.varAssign(bundle, "bundle", 4154, 159919, 159922);
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 4155, 159952, 159957)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 4155, 159952, 159957);
                        if (CallChecker.isCalled(bundle, BundleImpl.class, 4155, 159952, 159957).isRemovalPending()) {
                            if (CallChecker.beforeDeref(list, List.class, 4157, 160017, 160020)) {
                                list = CallChecker.beforeCalled(list, List.class, 4157, 160017, 160020);
                                CallChecker.isCalled(list, List.class, 4157, 160017, 160020).add(bundle);
                            }
                        }
                    }
                } 
                if (CallChecker.beforeDeref(list, List.class, 4161, 160085, 160088)) {
                    list = CallChecker.beforeCalled(list, List.class, 4161, 160085, 160088);
                    if (!(CallChecker.isCalled(list, List.class, 4161, 160085, 160088).isEmpty())) {
                        newTargets = list;
                        CallChecker.varAssign(newTargets, "newTargets", 4163, 160131, 160148);
                    }
                }
            }
            Set<Bundle> bundles = CallChecker.varInit(null, "bundles", 4168, 160257, 160283);
            if (newTargets != null) {
                bundles = new HashSet<Bundle>();
                CallChecker.varAssign(bundles, "bundles", 4173, 160441, 160472);
                for (Bundle target : newTargets) {
                    if (target != null) {
                        if (CallChecker.beforeDeref(bundles, Set.class, 4182, 160816, 160822)) {
                            bundles = CallChecker.beforeCalled(bundles, Set.class, 4182, 160816, 160822);
                            CallChecker.isCalled(bundles, Set.class, 4182, 160816, 160822).add(target);
                        }
                        populateDependentGraph(((BundleImpl) (target)), bundles);
                    }
                }
            }
            TryContext _bcornu_try_context_238 = new TryContext(238, Felix.class);
            try {
                boolean restart = CallChecker.varInit(((boolean) (false)), "restart", 4192, 161081, 161104);
                Bundle systemBundle = CallChecker.varInit(this, "systemBundle", 4194, 161119, 161145);
                if (bundles != null) {
                    for (Bundle b : bundles) {
                        if (CallChecker.beforeDeref(b, Bundle.class, 4203, 161528, 161528)) {
                            if ((systemBundle == b) || (CallChecker.isCalled(((BundleImpl) (b)), BundleImpl.class, 4203, 161528, 161528).isExtension())) {
                                restart = true;
                                CallChecker.varAssign(restart, "restart", 4205, 161592, 161606);
                                break;
                            }
                        }
                    }
                    if (!restart) {
                        List<Felix.RefreshHelper> helpers = CallChecker.varInit(new ArrayList<Felix.RefreshHelper>(bundles.size()), "helpers", 4220, 162217, 162291);
                        for (Bundle b : bundles) {
                            forgetUninstalledBundle(((BundleImpl) (b)));
                            if (CallChecker.beforeDeref(helpers, List.class, 4230, 162780, 162786)) {
                                helpers = CallChecker.beforeCalled(helpers, List.class, 4230, 162780, 162786);
                                CallChecker.isCalled(helpers, List.class, 4230, 162780, 162786).add(new Felix.RefreshHelper(b));
                            }
                        }
                        if (CallChecker.beforeDeref(helpers, void.class, 4234, 162938, 162944)) {
                            for (Felix.RefreshHelper helper : helpers) {
                                if (helper != null) {
                                    helper.stop();
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(helpers, void.class, 4243, 163250, 163256)) {
                            for (Felix.RefreshHelper helper : helpers) {
                                if (helper != null) {
                                    helper.refreshOrRemove();
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(helpers, void.class, 4252, 163585, 163591)) {
                            for (Felix.RefreshHelper helper : helpers) {
                                if (helper != null) {
                                    helper.restart();
                                }
                            }
                        }
                    }else {
                        TryContext _bcornu_try_context_237 = new TryContext(237, Felix.class, "org.osgi.framework.BundleException");
                        try {
                            update();
                        } catch (BundleException ex) {
                            _bcornu_try_context_237.catchStart(237);
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 4268, 164032, 164039)) {
                                CallChecker.isCalled(m_logger, Logger.class, 4268, 164032, 164039).log(Logger.LOG_ERROR, "Framework restart error.", ex);
                            }
                        } finally {
                            _bcornu_try_context_237.finallyStart(237);
                        }
                    }
                }
            } finally {
                _bcornu_try_context_238.finallyStart(238);
                releaseGlobalLock();
            }
            fireFrameworkEvent(FrameworkEvent.PACKAGES_REFRESHED, this, null);
            if (listeners != null) {
                FrameworkEvent event = CallChecker.varInit(new FrameworkEvent(FrameworkEvent.PACKAGES_REFRESHED, this, null), "event", 4283, 164406, 164511);
                for (FrameworkListener l : listeners) {
                    TryContext _bcornu_try_context_239 = new TryContext(239, Felix.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(l, FrameworkListener.class, 4289, 164635, 164635)) {
                            CallChecker.isCalled(l, FrameworkListener.class, 4289, 164635, 164635).frameworkEvent(event);
                        }
                    } catch (Throwable th) {
                        _bcornu_try_context_239.catchStart(239);
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 4293, 164753, 164760)) {
                            CallChecker.isCalled(m_logger, Logger.class, 4293, 164753, 164760).log(Logger.LOG_ERROR, "Framework listener delivery error.", th);
                        }
                    } finally {
                        _bcornu_try_context_239.finallyStart(239);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context669.methodEnd();
        }
    }

    Collection<Bundle> getDependencyClosure(Collection<Bundle> targets) {
        MethodContext _bcornu_methode_context670 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 4300, 164904, 166452);
            CallChecker.varInit(targets, "targets", 4300, 164904, 166452);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4300, 164904, 166452);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4300, 164904, 166452);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4300, 164904, 166452);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4300, 164904, 166452);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4300, 164904, 166452);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4300, 164904, 166452);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4300, 164904, 166452);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4300, 164904, 166452);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4300, 164904, 166452);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4300, 164904, 166452);
            CallChecker.varInit(this.m_registry, "m_registry", 4300, 164904, 166452);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4300, 164904, 166452);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4300, 164904, 166452);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4300, 164904, 166452);
            CallChecker.varInit(this.m_cache, "m_cache", 4300, 164904, 166452);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4300, 164904, 166452);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4300, 164904, 166452);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4300, 164904, 166452);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4300, 164904, 166452);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4300, 164904, 166452);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4300, 164904, 166452);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4300, 164904, 166452);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4300, 164904, 166452);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4300, 164904, 166452);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4300, 164904, 166452);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4300, 164904, 166452);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4300, 164904, 166452);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4300, 164904, 166452);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4300, 164904, 166452);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4300, 164904, 166452);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4300, 164904, 166452);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4300, 164904, 166452);
            CallChecker.varInit(this.m_logger, "m_logger", 4300, 164904, 166452);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4300, 164904, 166452);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4300, 164904, 166452);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4300, 164904, 166452);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4300, 164904, 166452);
            boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 4303, 165018, 165054);
            if (!locked) {
                throw new IllegalStateException("Unable to acquire global lock for refresh.");
            }
            TryContext _bcornu_try_context_240 = new TryContext(240, Felix.class);
            try {
                Set<Bundle> bundles = CallChecker.varInit(Collections.EMPTY_SET, "bundles", 4318, 165660, 165703);
                if (targets != null) {
                    bundles = new HashSet<Bundle>();
                    CallChecker.varAssign(bundles, "bundles", 4323, 165878, 165909);
                    for (Bundle target : targets) {
                        if (CallChecker.beforeDeref(bundles, Set.class, 4328, 166110, 166116)) {
                            bundles = CallChecker.beforeCalled(bundles, Set.class, 4328, 166110, 166116);
                            CallChecker.isCalled(bundles, Set.class, 4328, 166110, 166116).add(target);
                        }
                        populateDependentGraph(((BundleImpl) (target)), bundles);
                    }
                }
                return bundles;
            } finally {
                _bcornu_try_context_240.finallyStart(240);
                releaseGlobalLock();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context670.methodEnd();
        }
    }

    private void populateDependentGraph(BundleImpl exporter, Set<Bundle> set) {
        MethodContext _bcornu_methode_context671 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4343, 166459, 167219);
            CallChecker.varInit(set, "set", 4343, 166459, 167219);
            CallChecker.varInit(exporter, "exporter", 4343, 166459, 167219);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4343, 166459, 167219);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4343, 166459, 167219);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4343, 166459, 167219);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4343, 166459, 167219);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4343, 166459, 167219);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4343, 166459, 167219);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4343, 166459, 167219);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4343, 166459, 167219);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4343, 166459, 167219);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4343, 166459, 167219);
            CallChecker.varInit(this.m_registry, "m_registry", 4343, 166459, 167219);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4343, 166459, 167219);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4343, 166459, 167219);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4343, 166459, 167219);
            CallChecker.varInit(this.m_cache, "m_cache", 4343, 166459, 167219);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4343, 166459, 167219);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4343, 166459, 167219);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4343, 166459, 167219);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4343, 166459, 167219);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4343, 166459, 167219);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4343, 166459, 167219);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4343, 166459, 167219);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4343, 166459, 167219);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4343, 166459, 167219);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4343, 166459, 167219);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4343, 166459, 167219);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4343, 166459, 167219);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4343, 166459, 167219);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4343, 166459, 167219);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4343, 166459, 167219);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4343, 166459, 167219);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4343, 166459, 167219);
            CallChecker.varInit(this.m_logger, "m_logger", 4343, 166459, 167219);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4343, 166459, 167219);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4343, 166459, 167219);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4343, 166459, 167219);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4343, 166459, 167219);
            Set<Bundle> dependents = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 4346, 166680, 166693)) {
                dependents = CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 4346, 166680, 166693).getDependentBundles(exporter);
                CallChecker.varAssign(dependents, "dependents", 4346, 166680, 166693);
            }
            if (dependents != null) {
                for (Bundle b : dependents) {
                    if (CallChecker.beforeDeref(set, Set.class, 4353, 166909, 166911)) {
                        set = CallChecker.beforeCalled(set, Set.class, 4353, 166909, 166911);
                        if (!(CallChecker.isCalled(set, Set.class, 4353, 166909, 166911).contains(b))) {
                            if (CallChecker.beforeDeref(set, Set.class, 4356, 167021, 167023)) {
                                set = CallChecker.beforeCalled(set, Set.class, 4356, 167021, 167023);
                                CallChecker.isCalled(set, Set.class, 4356, 167021, 167023).add(b);
                            }
                            populateDependentGraph(((BundleImpl) (b)), set);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context671.methodEnd();
        }
    }

    Collection<Bundle> getRemovalPendingBundles() {
        MethodContext _bcornu_methode_context672 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 4364, 167226, 168487);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4364, 167226, 168487);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4364, 167226, 168487);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4364, 167226, 168487);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4364, 167226, 168487);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4364, 167226, 168487);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4364, 167226, 168487);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4364, 167226, 168487);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4364, 167226, 168487);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4364, 167226, 168487);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4364, 167226, 168487);
            CallChecker.varInit(this.m_registry, "m_registry", 4364, 167226, 168487);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4364, 167226, 168487);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4364, 167226, 168487);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4364, 167226, 168487);
            CallChecker.varInit(this.m_cache, "m_cache", 4364, 167226, 168487);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4364, 167226, 168487);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4364, 167226, 168487);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4364, 167226, 168487);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4364, 167226, 168487);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4364, 167226, 168487);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4364, 167226, 168487);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4364, 167226, 168487);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4364, 167226, 168487);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4364, 167226, 168487);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4364, 167226, 168487);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4364, 167226, 168487);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4364, 167226, 168487);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4364, 167226, 168487);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4364, 167226, 168487);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4364, 167226, 168487);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4364, 167226, 168487);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4364, 167226, 168487);
            CallChecker.varInit(this.m_logger, "m_logger", 4364, 167226, 168487);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4364, 167226, 168487);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4364, 167226, 168487);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4364, 167226, 168487);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4364, 167226, 168487);
            boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 4367, 167318, 167354);
            if (!locked) {
                throw new IllegalStateException("Unable to acquire global lock for refresh.");
            }
            TryContext _bcornu_try_context_241 = new TryContext(241, Felix.class);
            try {
                List<Bundle> bundles = CallChecker.varInit(new ArrayList<Bundle>(), "bundles", 4381, 167882, 167928);
                if ((m_uninstalledBundles) != null) {
                    for (Bundle b : m_uninstalledBundles) {
                        if (CallChecker.beforeDeref(bundles, List.class, 4386, 168082, 168088)) {
                            bundles = CallChecker.beforeCalled(bundles, List.class, 4386, 168082, 168088);
                            CallChecker.isCalled(bundles, List.class, 4386, 168082, 168088).add(b);
                        }
                    }
                }
                for (Bundle b : getBundles()) {
                    if (CallChecker.beforeDeref(b, Bundle.class, 4391, 168220, 168220)) {
                        if (CallChecker.isCalled(((BundleImpl) (b)), BundleImpl.class, 4391, 168220, 168220).isRemovalPending()) {
                            if (CallChecker.beforeDeref(bundles, List.class, 4393, 168281, 168287)) {
                                bundles = CallChecker.beforeCalled(bundles, List.class, 4393, 168281, 168287);
                                CallChecker.isCalled(bundles, List.class, 4393, 168281, 168287).add(b);
                            }
                        }
                    }
                }
                return bundles;
            } finally {
                _bcornu_try_context_241.finallyStart(241);
                releaseGlobalLock();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context672.methodEnd();
        }
    }

    private volatile SecurityProvider m_securityProvider;

    SecurityProvider getSecurityProvider() {
        MethodContext _bcornu_methode_context673 = new MethodContext(SecurityProvider.class);
        try {
            CallChecker.varInit(this, "this", 4411, 168606, 168690);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4411, 168606, 168690);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4411, 168606, 168690);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4411, 168606, 168690);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4411, 168606, 168690);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4411, 168606, 168690);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4411, 168606, 168690);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4411, 168606, 168690);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4411, 168606, 168690);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4411, 168606, 168690);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4411, 168606, 168690);
            CallChecker.varInit(this.m_registry, "m_registry", 4411, 168606, 168690);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4411, 168606, 168690);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4411, 168606, 168690);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4411, 168606, 168690);
            CallChecker.varInit(this.m_cache, "m_cache", 4411, 168606, 168690);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4411, 168606, 168690);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4411, 168606, 168690);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4411, 168606, 168690);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4411, 168606, 168690);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4411, 168606, 168690);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4411, 168606, 168690);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4411, 168606, 168690);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4411, 168606, 168690);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4411, 168606, 168690);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4411, 168606, 168690);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4411, 168606, 168690);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4411, 168606, 168690);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4411, 168606, 168690);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4411, 168606, 168690);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4411, 168606, 168690);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4411, 168606, 168690);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4411, 168606, 168690);
            CallChecker.varInit(this.m_logger, "m_logger", 4411, 168606, 168690);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4411, 168606, 168690);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4411, 168606, 168690);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4411, 168606, 168690);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4411, 168606, 168690);
            return m_securityProvider;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SecurityProvider) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context673.methodEnd();
        }
    }

    void setSecurityProvider(SecurityProvider securityProvider) {
        MethodContext _bcornu_methode_context674 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4416, 168697, 168814);
            CallChecker.varInit(securityProvider, "securityProvider", 4416, 168697, 168814);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4416, 168697, 168814);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4416, 168697, 168814);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4416, 168697, 168814);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4416, 168697, 168814);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4416, 168697, 168814);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4416, 168697, 168814);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4416, 168697, 168814);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4416, 168697, 168814);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4416, 168697, 168814);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4416, 168697, 168814);
            CallChecker.varInit(this.m_registry, "m_registry", 4416, 168697, 168814);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4416, 168697, 168814);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4416, 168697, 168814);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4416, 168697, 168814);
            CallChecker.varInit(this.m_cache, "m_cache", 4416, 168697, 168814);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4416, 168697, 168814);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4416, 168697, 168814);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4416, 168697, 168814);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4416, 168697, 168814);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4416, 168697, 168814);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4416, 168697, 168814);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4416, 168697, 168814);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4416, 168697, 168814);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4416, 168697, 168814);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4416, 168697, 168814);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4416, 168697, 168814);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4416, 168697, 168814);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4416, 168697, 168814);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4416, 168697, 168814);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4416, 168697, 168814);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4416, 168697, 168814);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4416, 168697, 168814);
            CallChecker.varInit(this.m_logger, "m_logger", 4416, 168697, 168814);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4416, 168697, 168814);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4416, 168697, 168814);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4416, 168697, 168814);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4416, 168697, 168814);
            m_securityProvider = securityProvider;
            CallChecker.varAssign(this.m_securityProvider, "this.m_securityProvider", 4418, 168771, 168808);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context674.methodEnd();
        }
    }

    Object getSignerMatcher(BundleImpl bundle, int signersType) {
        MethodContext _bcornu_methode_context675 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 4421, 168821, 169080);
            CallChecker.varInit(signersType, "signersType", 4421, 168821, 169080);
            CallChecker.varInit(bundle, "bundle", 4421, 168821, 169080);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4421, 168821, 169080);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4421, 168821, 169080);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4421, 168821, 169080);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4421, 168821, 169080);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4421, 168821, 169080);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4421, 168821, 169080);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4421, 168821, 169080);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4421, 168821, 169080);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4421, 168821, 169080);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4421, 168821, 169080);
            CallChecker.varInit(this.m_registry, "m_registry", 4421, 168821, 169080);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4421, 168821, 169080);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4421, 168821, 169080);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4421, 168821, 169080);
            CallChecker.varInit(this.m_cache, "m_cache", 4421, 168821, 169080);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4421, 168821, 169080);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4421, 168821, 169080);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4421, 168821, 169080);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4421, 168821, 169080);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4421, 168821, 169080);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4421, 168821, 169080);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4421, 168821, 169080);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4421, 168821, 169080);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4421, 168821, 169080);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4421, 168821, 169080);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4421, 168821, 169080);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4421, 168821, 169080);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4421, 168821, 169080);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4421, 168821, 169080);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4421, 168821, 169080);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4421, 168821, 169080);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4421, 168821, 169080);
            CallChecker.varInit(this.m_logger, "m_logger", 4421, 168821, 169080);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4421, 168821, 169080);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4421, 168821, 169080);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4421, 168821, 169080);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4421, 168821, 169080);
            if ((bundle != (this)) && ((m_securityProvider) != null)) {
                return m_securityProvider.getSignerMatcher(bundle, signersType);
            }
            return new HashMap();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context675.methodEnd();
        }
    }

    boolean impliesBundlePermission(BundleProtectionDomain bundleProtectionDomain, Permission permission, boolean direct) {
        MethodContext _bcornu_methode_context676 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 4430, 169087, 169849);
            CallChecker.varInit(direct, "direct", 4430, 169087, 169849);
            CallChecker.varInit(permission, "permission", 4430, 169087, 169849);
            CallChecker.varInit(bundleProtectionDomain, "bundleProtectionDomain", 4430, 169087, 169849);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4430, 169087, 169849);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4430, 169087, 169849);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4430, 169087, 169849);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4430, 169087, 169849);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4430, 169087, 169849);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4430, 169087, 169849);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4430, 169087, 169849);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4430, 169087, 169849);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4430, 169087, 169849);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4430, 169087, 169849);
            CallChecker.varInit(this.m_registry, "m_registry", 4430, 169087, 169849);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4430, 169087, 169849);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4430, 169087, 169849);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4430, 169087, 169849);
            CallChecker.varInit(this.m_cache, "m_cache", 4430, 169087, 169849);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4430, 169087, 169849);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4430, 169087, 169849);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4430, 169087, 169849);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4430, 169087, 169849);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4430, 169087, 169849);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4430, 169087, 169849);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4430, 169087, 169849);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4430, 169087, 169849);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4430, 169087, 169849);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4430, 169087, 169849);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4430, 169087, 169849);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4430, 169087, 169849);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4430, 169087, 169849);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4430, 169087, 169849);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4430, 169087, 169849);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4430, 169087, 169849);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4430, 169087, 169849);
            CallChecker.varInit(this.m_logger, "m_logger", 4430, 169087, 169849);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4430, 169087, 169849);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4430, 169087, 169849);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4430, 169087, 169849);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4430, 169087, 169849);
            if (direct && (permission instanceof PackagePermission)) {
                if (CallChecker.beforeDeref(bundleProtectionDomain, BundleProtectionDomain.class, 4434, 169300, 169321)) {
                    bundleProtectionDomain = CallChecker.beforeCalled(bundleProtectionDomain, BundleProtectionDomain.class, 4434, 169300, 169321);
                    if (CallChecker.isCalled(bundleProtectionDomain, BundleProtectionDomain.class, 4434, 169300, 169321).impliesWoven(permission)) {
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((m_securityProvider) != null) {
                return m_securityProvider.hasBundlePermission(bundleProtectionDomain, permission, direct);
            }else {
                Bundle source = CallChecker.init(Bundle.class);
                if (CallChecker.beforeDeref(bundleProtectionDomain, BundleProtectionDomain.class, 4445, 169630, 169651)) {
                    bundleProtectionDomain = CallChecker.beforeCalled(bundleProtectionDomain, BundleProtectionDomain.class, 4445, 169630, 169651);
                    source = CallChecker.isCalled(bundleProtectionDomain, BundleProtectionDomain.class, 4445, 169630, 169651).getBundle();
                    CallChecker.varAssign(source, "source", 4445, 169630, 169651);
                }
                if ((m_securityDefaultPolicy) && ((source == null) || ((source.getBundleId()) != 0))) {
                    if (CallChecker.beforeDeref(bundleProtectionDomain, BundleProtectionDomain.class, 4448, 169779, 169800)) {
                        bundleProtectionDomain = CallChecker.beforeCalled(bundleProtectionDomain, BundleProtectionDomain.class, 4448, 169779, 169800);
                        return CallChecker.isCalled(bundleProtectionDomain, BundleProtectionDomain.class, 4448, 169779, 169800).superImplies(permission);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    return true;
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context676.methodEnd();
        }
    }

    private BundleActivator createBundleActivator(Bundle impl) throws Exception {
        MethodContext _bcornu_methode_context677 = new MethodContext(BundleActivator.class);
        try {
            CallChecker.varInit(this, "this", 4452, 169856, 171019);
            CallChecker.varInit(impl, "impl", 4452, 169856, 171019);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4452, 169856, 171019);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4452, 169856, 171019);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4452, 169856, 171019);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4452, 169856, 171019);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4452, 169856, 171019);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4452, 169856, 171019);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4452, 169856, 171019);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4452, 169856, 171019);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4452, 169856, 171019);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4452, 169856, 171019);
            CallChecker.varInit(this.m_registry, "m_registry", 4452, 169856, 171019);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4452, 169856, 171019);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4452, 169856, 171019);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4452, 169856, 171019);
            CallChecker.varInit(this.m_cache, "m_cache", 4452, 169856, 171019);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4452, 169856, 171019);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4452, 169856, 171019);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4452, 169856, 171019);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4452, 169856, 171019);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4452, 169856, 171019);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4452, 169856, 171019);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4452, 169856, 171019);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4452, 169856, 171019);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4452, 169856, 171019);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4452, 169856, 171019);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4452, 169856, 171019);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4452, 169856, 171019);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4452, 169856, 171019);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4452, 169856, 171019);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4452, 169856, 171019);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4452, 169856, 171019);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4452, 169856, 171019);
            CallChecker.varInit(this.m_logger, "m_logger", 4452, 169856, 171019);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4452, 169856, 171019);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4452, 169856, 171019);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4452, 169856, 171019);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4452, 169856, 171019);
            BundleActivator activator = CallChecker.varInit(null, "activator", 4460, 170207, 170239);
            Map headerMap = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(impl, Bundle.class, 4461, 170287, 170290)) {
                impl = CallChecker.beforeCalled(impl, Bundle.class, 4461, 170287, 170290);
                final BundleRevisionImpl npe_invocation_var223 = ((BundleRevisionImpl) (CallChecker.isCalled(impl, Bundle.class, 4461, 170287, 170290).adapt(BundleRevision.class)));
                if (CallChecker.beforeDeref(npe_invocation_var223, BundleRevisionImpl.class, 4461, 170287, 170318)) {
                    headerMap = CallChecker.isCalled(npe_invocation_var223, BundleRevisionImpl.class, 4461, 170287, 170318).getHeaders();
                    CallChecker.varAssign(headerMap, "headerMap", 4461, 170287, 170290);
                }
            }
            String className = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 4462, 170371, 170379)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 4462, 170371, 170379);
                className = ((String) (CallChecker.isCalled(headerMap, Map.class, 4462, 170371, 170379).get(Constants.BUNDLE_ACTIVATOR)));
                CallChecker.varAssign(className, "className", 4462, 170371, 170379);
            }
            if (className != null) {
                className = className.trim();
                CallChecker.varAssign(className, "className", 4466, 170525, 170553);
                Class clazz = CallChecker.init(Class.class);
                TryContext _bcornu_try_context_242 = new TryContext(242, Felix.class, "java.lang.ClassNotFoundException");
                try {
                    if (CallChecker.beforeDeref(impl, Bundle.class, 4471, 170674, 170677)) {
                        impl = CallChecker.beforeCalled(impl, Bundle.class, 4471, 170674, 170677);
                        final BundleRevision npe_invocation_var224 = CallChecker.isCalled(impl, Bundle.class, 4471, 170674, 170677).adapt(BundleRevision.class);
                        if (CallChecker.beforeDeref(npe_invocation_var224, BundleRevision.class, 4471, 170674, 170705)) {
                            final BundleWiringImpl npe_invocation_var225 = ((BundleWiringImpl) (CallChecker.isCalled(npe_invocation_var224, BundleRevision.class, 4471, 170674, 170705).getWiring()));
                            if (CallChecker.beforeDeref(npe_invocation_var225, BundleWiringImpl.class, 4471, 170674, 170717)) {
                                clazz = CallChecker.isCalled(npe_invocation_var225, BundleWiringImpl.class, 4471, 170674, 170717).getClassByDelegation(className);
                                CallChecker.varAssign(clazz, "clazz", 4470, 170626, 170751);
                            }
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    _bcornu_try_context_242.catchStart(242);
                    throw new BundleException(("Not found: " + className), ex);
                } finally {
                    _bcornu_try_context_242.finallyStart(242);
                }
                if (CallChecker.beforeDeref(clazz, Class.class, 4477, 170957, 170961)) {
                    clazz = CallChecker.beforeCalled(clazz, Class.class, 4477, 170957, 170961);
                    activator = ((BundleActivator) (CallChecker.isCalled(clazz, Class.class, 4477, 170957, 170961).newInstance()));
                    CallChecker.varAssign(activator, "activator", 4477, 170927, 170976);
                }
            }
            return activator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleActivator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context677.methodEnd();
        }
    }

    private void refreshBundle(BundleImpl bundle) throws Exception {
        MethodContext _bcornu_methode_context678 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4483, 171026, 172240);
            CallChecker.varInit(bundle, "bundle", 4483, 171026, 172240);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4483, 171026, 172240);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4483, 171026, 172240);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4483, 171026, 172240);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4483, 171026, 172240);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4483, 171026, 172240);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4483, 171026, 172240);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4483, 171026, 172240);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4483, 171026, 172240);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4483, 171026, 172240);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4483, 171026, 172240);
            CallChecker.varInit(this.m_registry, "m_registry", 4483, 171026, 172240);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4483, 171026, 172240);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4483, 171026, 172240);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4483, 171026, 172240);
            CallChecker.varInit(this.m_cache, "m_cache", 4483, 171026, 172240);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4483, 171026, 172240);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4483, 171026, 172240);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4483, 171026, 172240);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4483, 171026, 172240);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4483, 171026, 172240);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4483, 171026, 172240);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4483, 171026, 172240);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4483, 171026, 172240);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4483, 171026, 172240);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4483, 171026, 172240);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4483, 171026, 172240);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4483, 171026, 172240);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4483, 171026, 172240);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4483, 171026, 172240);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4483, 171026, 172240);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4483, 171026, 172240);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4483, 171026, 172240);
            CallChecker.varInit(this.m_logger, "m_logger", 4483, 171026, 172240);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4483, 171026, 172240);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4483, 171026, 172240);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4483, 171026, 172240);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4483, 171026, 172240);
            TryContext _bcornu_try_context_243 = new TryContext(243, Felix.class, "java.lang.IllegalStateException");
            try {
                acquireBundleLock(bundle, ((Bundle.INSTALLED) | (Bundle.RESOLVED)));
            } catch (IllegalStateException ex) {
                _bcornu_try_context_243.catchStart(243);
                throw new BundleException("Bundle state has changed unexpectedly during refresh.");
            } finally {
                _bcornu_try_context_243.finallyStart(243);
            }
            TryContext _bcornu_try_context_244 = new TryContext(244, Felix.class, "java.lang.Exception");
            try {
                boolean fire = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 4499, 171515, 171520)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 4499, 171515, 171520);
                    fire = (CallChecker.isCalled(bundle, BundleImpl.class, 4499, 171515, 171520).getState()) != (Bundle.INSTALLED);
                    CallChecker.varAssign(fire, "fire", 4499, 171515, 171520);
                }
                if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 4501, 171603, 171616)) {
                    CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 4501, 171603, 171616).removeDependencies(bundle);
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 4503, 171698, 171703)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 4503, 171698, 171703);
                    CallChecker.isCalled(bundle, BundleImpl.class, 4503, 171698, 171703).refresh();
                }
                if (fire) {
                    setBundleStateAndNotify(bundle, Bundle.INSTALLED);
                    fireBundleEvent(BundleEvent.UNRESOLVED, bundle);
                }
            } catch (Exception ex) {
                _bcornu_try_context_244.catchStart(244);
                fireFrameworkEvent(FrameworkEvent.ERROR, bundle, ex);
            } finally {
                _bcornu_try_context_244.finallyStart(244);
                releaseBundleLock(bundle);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context678.methodEnd();
        }
    }

    void fireFrameworkEvent(int type, Bundle bundle, Throwable throwable) {
        MethodContext _bcornu_methode_context679 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4530, 172247, 172511);
            CallChecker.varInit(throwable, "throwable", 4530, 172247, 172511);
            CallChecker.varInit(bundle, "bundle", 4530, 172247, 172511);
            CallChecker.varInit(type, "type", 4530, 172247, 172511);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4530, 172247, 172511);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4530, 172247, 172511);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4530, 172247, 172511);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4530, 172247, 172511);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4530, 172247, 172511);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4530, 172247, 172511);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4530, 172247, 172511);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4530, 172247, 172511);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4530, 172247, 172511);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4530, 172247, 172511);
            CallChecker.varInit(this.m_registry, "m_registry", 4530, 172247, 172511);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4530, 172247, 172511);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4530, 172247, 172511);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4530, 172247, 172511);
            CallChecker.varInit(this.m_cache, "m_cache", 4530, 172247, 172511);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4530, 172247, 172511);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4530, 172247, 172511);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4530, 172247, 172511);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4530, 172247, 172511);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4530, 172247, 172511);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4530, 172247, 172511);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4530, 172247, 172511);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4530, 172247, 172511);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4530, 172247, 172511);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4530, 172247, 172511);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4530, 172247, 172511);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4530, 172247, 172511);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4530, 172247, 172511);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4530, 172247, 172511);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4530, 172247, 172511);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4530, 172247, 172511);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4530, 172247, 172511);
            CallChecker.varInit(this.m_logger, "m_logger", 4530, 172247, 172511);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4530, 172247, 172511);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4530, 172247, 172511);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4530, 172247, 172511);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4530, 172247, 172511);
            if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 4533, 172429, 172440)) {
                CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 4533, 172429, 172440).fireFrameworkEvent(new FrameworkEvent(type, bundle, throwable));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context679.methodEnd();
        }
    }

    void fireBundleEvent(int type, Bundle bundle) {
        MethodContext _bcornu_methode_context680 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4542, 172518, 172812);
            CallChecker.varInit(bundle, "bundle", 4542, 172518, 172812);
            CallChecker.varInit(type, "type", 4542, 172518, 172812);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4542, 172518, 172812);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4542, 172518, 172812);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4542, 172518, 172812);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4542, 172518, 172812);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4542, 172518, 172812);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4542, 172518, 172812);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4542, 172518, 172812);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4542, 172518, 172812);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4542, 172518, 172812);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4542, 172518, 172812);
            CallChecker.varInit(this.m_registry, "m_registry", 4542, 172518, 172812);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4542, 172518, 172812);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4542, 172518, 172812);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4542, 172518, 172812);
            CallChecker.varInit(this.m_cache, "m_cache", 4542, 172518, 172812);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4542, 172518, 172812);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4542, 172518, 172812);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4542, 172518, 172812);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4542, 172518, 172812);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4542, 172518, 172812);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4542, 172518, 172812);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4542, 172518, 172812);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4542, 172518, 172812);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4542, 172518, 172812);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4542, 172518, 172812);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4542, 172518, 172812);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4542, 172518, 172812);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4542, 172518, 172812);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4542, 172518, 172812);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4542, 172518, 172812);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4542, 172518, 172812);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4542, 172518, 172812);
            CallChecker.varInit(this.m_logger, "m_logger", 4542, 172518, 172812);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4542, 172518, 172812);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4542, 172518, 172812);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4542, 172518, 172812);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4542, 172518, 172812);
            if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 4544, 172741, 172752)) {
                CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 4544, 172741, 172752).fireBundleEvent(new BundleEvent(type, bundle), this);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context680.methodEnd();
        }
    }

    void fireBundleEvent(int type, Bundle bundle, Bundle origin) {
        MethodContext _bcornu_methode_context681 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4547, 172819, 172973);
            CallChecker.varInit(origin, "origin", 4547, 172819, 172973);
            CallChecker.varInit(bundle, "bundle", 4547, 172819, 172973);
            CallChecker.varInit(type, "type", 4547, 172819, 172973);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4547, 172819, 172973);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4547, 172819, 172973);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4547, 172819, 172973);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4547, 172819, 172973);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4547, 172819, 172973);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4547, 172819, 172973);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4547, 172819, 172973);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4547, 172819, 172973);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4547, 172819, 172973);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4547, 172819, 172973);
            CallChecker.varInit(this.m_registry, "m_registry", 4547, 172819, 172973);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4547, 172819, 172973);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4547, 172819, 172973);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4547, 172819, 172973);
            CallChecker.varInit(this.m_cache, "m_cache", 4547, 172819, 172973);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4547, 172819, 172973);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4547, 172819, 172973);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4547, 172819, 172973);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4547, 172819, 172973);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4547, 172819, 172973);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4547, 172819, 172973);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4547, 172819, 172973);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4547, 172819, 172973);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4547, 172819, 172973);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4547, 172819, 172973);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4547, 172819, 172973);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4547, 172819, 172973);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4547, 172819, 172973);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4547, 172819, 172973);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4547, 172819, 172973);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4547, 172819, 172973);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4547, 172819, 172973);
            CallChecker.varInit(this.m_logger, "m_logger", 4547, 172819, 172973);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4547, 172819, 172973);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4547, 172819, 172973);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4547, 172819, 172973);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4547, 172819, 172973);
            if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 4549, 172894, 172905)) {
                CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 4549, 172894, 172905).fireBundleEvent(new BundleEvent(type, bundle, origin), this);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context681.methodEnd();
        }
    }

    private void fireServiceEvent(ServiceEvent event, Dictionary oldProps) {
        MethodContext _bcornu_methode_context682 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4558, 172980, 173301);
            CallChecker.varInit(oldProps, "oldProps", 4558, 172980, 173301);
            CallChecker.varInit(event, "event", 4558, 172980, 173301);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4558, 172980, 173301);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4558, 172980, 173301);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4558, 172980, 173301);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4558, 172980, 173301);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4558, 172980, 173301);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4558, 172980, 173301);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4558, 172980, 173301);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4558, 172980, 173301);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4558, 172980, 173301);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4558, 172980, 173301);
            CallChecker.varInit(this.m_registry, "m_registry", 4558, 172980, 173301);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4558, 172980, 173301);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4558, 172980, 173301);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4558, 172980, 173301);
            CallChecker.varInit(this.m_cache, "m_cache", 4558, 172980, 173301);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4558, 172980, 173301);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4558, 172980, 173301);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4558, 172980, 173301);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4558, 172980, 173301);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4558, 172980, 173301);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4558, 172980, 173301);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4558, 172980, 173301);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4558, 172980, 173301);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4558, 172980, 173301);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4558, 172980, 173301);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4558, 172980, 173301);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4558, 172980, 173301);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4558, 172980, 173301);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4558, 172980, 173301);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4558, 172980, 173301);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4558, 172980, 173301);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4558, 172980, 173301);
            CallChecker.varInit(this.m_logger, "m_logger", 4558, 172980, 173301);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4558, 172980, 173301);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4558, 172980, 173301);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4558, 172980, 173301);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4558, 172980, 173301);
            if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 4560, 173243, 173254)) {
                CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 4560, 173243, 173254).fireServiceEvent(event, oldProps, this);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context682.methodEnd();
        }
    }

    private void initializeFrameworkProperties() {
        MethodContext _bcornu_methode_context683 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4567, 173308, 175491);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4567, 173308, 175491);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4567, 173308, 175491);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4567, 173308, 175491);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4567, 173308, 175491);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4567, 173308, 175491);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4567, 173308, 175491);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4567, 173308, 175491);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4567, 173308, 175491);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4567, 173308, 175491);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4567, 173308, 175491);
            CallChecker.varInit(this.m_registry, "m_registry", 4567, 173308, 175491);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4567, 173308, 175491);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4567, 173308, 175491);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4567, 173308, 175491);
            CallChecker.varInit(this.m_cache, "m_cache", 4567, 173308, 175491);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4567, 173308, 175491);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4567, 173308, 175491);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4567, 173308, 175491);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4567, 173308, 175491);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4567, 173308, 175491);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4567, 173308, 175491);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4567, 173308, 175491);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4567, 173308, 175491);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4567, 173308, 175491);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4567, 173308, 175491);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4567, 173308, 175491);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4567, 173308, 175491);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4567, 173308, 175491);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4567, 173308, 175491);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4567, 173308, 175491);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4567, 173308, 175491);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4567, 173308, 175491);
            CallChecker.varInit(this.m_logger, "m_logger", 4567, 173308, 175491);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4567, 173308, 175491);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4567, 173308, 175491);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4567, 173308, 175491);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4567, 173308, 175491);
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4570, 173452, 173469)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4570, 173452, 173469).put(FelixConstants.FRAMEWORK_VERSION, FelixConstants.FRAMEWORK_VERSION_VALUE);
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4573, 173583, 173600)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4573, 173583, 173600).put(FelixConstants.FRAMEWORK_VENDOR, FelixConstants.FRAMEWORK_VENDOR_VALUE);
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4576, 173712, 173729)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4576, 173712, 173729).put(FelixConstants.FRAMEWORK_LANGUAGE, System.getProperty("user.language"));
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4579, 173841, 173858)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4579, 173841, 173858).put(FelixConstants.FRAMEWORK_OS_VERSION, System.getProperty("os.version"));
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4582, 173969, 173986)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4582, 173969, 173986).put(FelixConstants.SUPPORTS_FRAMEWORK_EXTENSION, "true");
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4585, 174079, 174096)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4585, 174079, 174096).put(FelixConstants.SUPPORTS_FRAMEWORK_FRAGMENT, "true");
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4588, 174188, 174205)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4588, 174188, 174205).put(FelixConstants.SUPPORTS_FRAMEWORK_REQUIREBUNDLE, "true");
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4591, 174302, 174319)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4591, 174302, 174319).put(FelixConstants.SUPPORTS_BOOTCLASSPATH_EXTENSION, "false");
            }
            String s = CallChecker.varInit(null, "s", 4595, 174418, 174433);
            s = NativeLibraryClause.normalizeOSName(System.getProperty("os.name"));
            CallChecker.varAssign(s, "s", 4596, 174443, 174513);
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4597, 174523, 174540)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4597, 174523, 174540).put(FelixConstants.FRAMEWORK_OS_NAME, s);
            }
            s = NativeLibraryClause.normalizeProcessor(System.getProperty("os.arch"));
            CallChecker.varAssign(s, "s", 4598, 174592, 174665);
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4599, 174675, 174692)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4599, 174675, 174692).put(FelixConstants.FRAMEWORK_PROCESSOR, s);
            }
            if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4600, 174746, 174763)) {
                CallChecker.isCalled(m_configMutableMap, Map.class, 4600, 174746, 174763).put(FelixConstants.FELIX_VERSION_PROPERTY, Felix.getFrameworkVersion());
            }
            Properties defaultProperties = CallChecker.varInit(Util.loadDefaultProperties(m_logger), "defaultProperties", 4603, 174854, 174921);
            loadFromDefaultIfNotDefined(defaultProperties, Constants.FRAMEWORK_EXECUTIONENVIRONMENT);
            loadPrefixFromDefaultIfNotDefined(m_configMutableMap, defaultProperties, FelixConstants.NATIVE_OS_NAME_ALIAS_PREFIX);
            loadPrefixFromDefaultIfNotDefined(m_configMutableMap, defaultProperties, FelixConstants.NATIVE_PROC_NAME_ALIAS_PREFIX);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context683.methodEnd();
        }
    }

    private void loadFromDefaultIfNotDefined(Properties defaultProperties, String propertyName) {
        MethodContext _bcornu_methode_context684 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4614, 175498, 175867);
            CallChecker.varInit(propertyName, "propertyName", 4614, 175498, 175867);
            CallChecker.varInit(defaultProperties, "defaultProperties", 4614, 175498, 175867);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4614, 175498, 175867);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4614, 175498, 175867);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4614, 175498, 175867);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4614, 175498, 175867);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4614, 175498, 175867);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4614, 175498, 175867);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4614, 175498, 175867);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4614, 175498, 175867);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4614, 175498, 175867);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4614, 175498, 175867);
            CallChecker.varInit(this.m_registry, "m_registry", 4614, 175498, 175867);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4614, 175498, 175867);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4614, 175498, 175867);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4614, 175498, 175867);
            CallChecker.varInit(this.m_cache, "m_cache", 4614, 175498, 175867);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4614, 175498, 175867);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4614, 175498, 175867);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4614, 175498, 175867);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4614, 175498, 175867);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4614, 175498, 175867);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4614, 175498, 175867);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4614, 175498, 175867);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4614, 175498, 175867);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4614, 175498, 175867);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4614, 175498, 175867);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4614, 175498, 175867);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4614, 175498, 175867);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4614, 175498, 175867);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4614, 175498, 175867);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4614, 175498, 175867);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4614, 175498, 175867);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4614, 175498, 175867);
            CallChecker.varInit(this.m_logger, "m_logger", 4614, 175498, 175867);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4614, 175498, 175867);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4614, 175498, 175867);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4614, 175498, 175867);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4614, 175498, 175867);
            String s = CallChecker.init(String.class);
            final Map npe_invocation_var226 = getConfig();
            if (CallChecker.beforeDeref(npe_invocation_var226, Map.class, 4617, 175627, 175637)) {
                if (!(CallChecker.isCalled(npe_invocation_var226, Map.class, 4617, 175627, 175637).containsKey(propertyName))) {
                    s = Util.getDefaultProperty(m_logger, propertyName);
                    CallChecker.varAssign(s, "s", 4619, 175688, 175739);
                    if (s != null) {
                        if (CallChecker.beforeDeref(m_configMutableMap, Map.class, 4622, 175798, 175815)) {
                            CallChecker.isCalled(m_configMutableMap, Map.class, 4622, 175798, 175815).put(propertyName, s);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context684.methodEnd();
        }
    }

    private void loadPrefixFromDefaultIfNotDefined(Map configMap, Properties defaultProperties, String prefix) {
        MethodContext _bcornu_methode_context685 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 4627, 175874, 176403);
            CallChecker.varInit(prefix, "prefix", 4627, 175874, 176403);
            CallChecker.varInit(defaultProperties, "defaultProperties", 4627, 175874, 176403);
            CallChecker.varInit(configMap, "configMap", 4627, 175874, 176403);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4627, 175874, 176403);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4627, 175874, 176403);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4627, 175874, 176403);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4627, 175874, 176403);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4627, 175874, 176403);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4627, 175874, 176403);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4627, 175874, 176403);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4627, 175874, 176403);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4627, 175874, 176403);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4627, 175874, 176403);
            CallChecker.varInit(this.m_registry, "m_registry", 4627, 175874, 176403);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4627, 175874, 176403);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4627, 175874, 176403);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4627, 175874, 176403);
            CallChecker.varInit(this.m_cache, "m_cache", 4627, 175874, 176403);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4627, 175874, 176403);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4627, 175874, 176403);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4627, 175874, 176403);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4627, 175874, 176403);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4627, 175874, 176403);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4627, 175874, 176403);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4627, 175874, 176403);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4627, 175874, 176403);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4627, 175874, 176403);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4627, 175874, 176403);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4627, 175874, 176403);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4627, 175874, 176403);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4627, 175874, 176403);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4627, 175874, 176403);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4627, 175874, 176403);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4627, 175874, 176403);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4627, 175874, 176403);
            CallChecker.varInit(this.m_logger, "m_logger", 4627, 175874, 176403);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4627, 175874, 176403);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4627, 175874, 176403);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4627, 175874, 176403);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4627, 175874, 176403);
            Map<String, String> defaultPropsWithPrefix = CallChecker.varInit(Util.getDefaultPropertiesWithPrefix(defaultProperties, prefix), "defaultPropsWithPrefix", 4629, 175995, 176102);
            defaultPropsWithPrefix = CallChecker.beforeCalled(defaultPropsWithPrefix, Map.class, 4631, 176148, 176169);
            for (String currentDefaultProperty : CallChecker.isCalled(defaultPropsWithPrefix, Map.class, 4631, 176148, 176169).keySet()) {
                if (CallChecker.beforeDeref(configMap, Map.class, 4633, 176207, 176215)) {
                    configMap = CallChecker.beforeCalled(configMap, Map.class, 4633, 176207, 176215);
                    if (!(CallChecker.isCalled(configMap, Map.class, 4633, 176207, 176215).containsKey(currentDefaultProperty))) {
                        if (CallChecker.beforeDeref(defaultPropsWithPrefix, Map.class, 4635, 176322, 176343)) {
                            if (CallChecker.beforeDeref(configMap, Map.class, 4635, 176284, 176292)) {
                                defaultPropsWithPrefix = CallChecker.beforeCalled(defaultPropsWithPrefix, Map.class, 4635, 176322, 176343);
                                configMap = CallChecker.beforeCalled(configMap, Map.class, 4635, 176284, 176292);
                                CallChecker.isCalled(configMap, Map.class, 4635, 176284, 176292).put(currentDefaultProperty, CallChecker.isCalled(defaultPropsWithPrefix, Map.class, 4635, 176322, 176343).get(currentDefaultProperty));
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context685.methodEnd();
        }
    }

    private static String getFrameworkVersion() {
        MethodContext _bcornu_methode_context686 = new MethodContext(String.class);
        try {
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4644, 176410, 177713);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4644, 176410, 177713);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4644, 176410, 177713);
            Properties props = CallChecker.varInit(new Properties(), "props", 4647, 176635, 176670);
            InputStream in = CallChecker.varInit(Felix.class.getResourceAsStream("Felix.properties"), "in", 4648, 176680, 176748);
            if (in != null) {
                TryContext _bcornu_try_context_246 = new TryContext(246, Felix.class, "java.io.IOException");
                try {
                    if (CallChecker.beforeDeref(props, Properties.class, 4653, 176830, 176834)) {
                        props = CallChecker.beforeCalled(props, Properties.class, 4653, 176830, 176834);
                        CallChecker.isCalled(props, Properties.class, 4653, 176830, 176834).load(in);
                    }
                } catch (IOException ex) {
                    _bcornu_try_context_246.catchStart(246);
                    ex.printStackTrace();
                } finally {
                    _bcornu_try_context_246.finallyStart(246);
                    TryContext _bcornu_try_context_245 = new TryContext(245, Felix.class, "java.io.IOException");
                    try {
                        in.close();
                    } catch (IOException ex) {
                        _bcornu_try_context_245.catchStart(245);
                    } finally {
                        _bcornu_try_context_245.finallyStart(245);
                    }
                }
            }
            StringBuffer sb = CallChecker.init(StringBuffer.class);
            if (CallChecker.beforeDeref(props, Properties.class, 4676, 177426, 177430)) {
                props = CallChecker.beforeCalled(props, Properties.class, 4676, 177426, 177430);
                sb = new StringBuffer(CallChecker.isCalled(props, Properties.class, 4676, 177426, 177430).getProperty(FelixConstants.FELIX_VERSION_PROPERTY, "0.0.0"));
                CallChecker.varAssign(sb, "sb", 4676, 177426, 177430);
            }
            String toRet = CallChecker.varInit(Felix.cleanMavenVersion(sb), "toRet", 4678, 177523, 177559);
            if (CallChecker.beforeDeref(toRet, String.class, 4679, 177573, 177577)) {
                toRet = CallChecker.beforeCalled(toRet, String.class, 4679, 177573, 177577);
                if ((CallChecker.isCalled(toRet, String.class, 4679, 177573, 177577).indexOf("${pom")) >= 0) {
                    return "0.0.0";
                }else {
                    return toRet;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context686.methodEnd();
        }
    }

    private static String cleanMavenVersion(StringBuffer sb) {
        MethodContext _bcornu_methode_context687 = new MethodContext(String.class);
        try {
            CallChecker.varInit(sb, "sb", 4698, 177720, 178833);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4698, 177720, 178833);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4698, 177720, 178833);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4698, 177720, 178833);
            int dots = CallChecker.varInit(((int) (0)), "dots", 4700, 178244, 178256);
            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 4701, 178286, 178287);
            for (int i = 0; i < (CallChecker.isCalled(sb, StringBuffer.class, 4701, 178286, 178287).length()); i++) {
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 4703, 178334, 178335)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 4703, 178334, 178335);
                    switch (CallChecker.isCalled(sb, StringBuffer.class, 4703, 178334, 178335).charAt(i)) {
                        case '.' :
                            dots++;
                            break;
                        case '-' :
                            if (dots < 3) {
                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 4711, 178549, 178550)) {
                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 4711, 178549, 178550);
                                    CallChecker.isCalled(sb, StringBuffer.class, 4711, 178549, 178550).setCharAt(i, '.');
                                }
                                for (int j = dots; j < 2; j++) {
                                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 4714, 178680, 178681)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 4714, 178680, 178681);
                                        CallChecker.isCalled(sb, StringBuffer.class, 4714, 178680, 178681).insert(i, ".0");
                                    }
                                }
                            }
                            break;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 4720, 178814, 178815)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 4720, 178814, 178815);
                return CallChecker.isCalled(sb, StringBuffer.class, 4720, 178814, 178815).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context687.methodEnd();
        }
    }

    private long loadNextId() {
        MethodContext _bcornu_methode_context688 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 4730, 178840, 180453);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4730, 178840, 180453);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4730, 178840, 180453);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4730, 178840, 180453);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4730, 178840, 180453);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4730, 178840, 180453);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4730, 178840, 180453);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4730, 178840, 180453);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4730, 178840, 180453);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4730, 178840, 180453);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4730, 178840, 180453);
            CallChecker.varInit(this.m_registry, "m_registry", 4730, 178840, 180453);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4730, 178840, 180453);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4730, 178840, 180453);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4730, 178840, 180453);
            CallChecker.varInit(this.m_cache, "m_cache", 4730, 178840, 180453);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4730, 178840, 180453);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4730, 178840, 180453);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4730, 178840, 180453);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4730, 178840, 180453);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4730, 178840, 180453);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4730, 178840, 180453);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4730, 178840, 180453);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4730, 178840, 180453);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4730, 178840, 180453);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4730, 178840, 180453);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4730, 178840, 180453);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4730, 178840, 180453);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4730, 178840, 180453);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4730, 178840, 180453);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4730, 178840, 180453);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4730, 178840, 180453);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4730, 178840, 180453);
            CallChecker.varInit(this.m_logger, "m_logger", 4730, 178840, 180453);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4730, 178840, 180453);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4730, 178840, 180453);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4730, 178840, 180453);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4730, 178840, 180453);
            synchronized(m_nextIdLock) {
                InputStream is = CallChecker.varInit(null, "is", 4735, 179098, 179119);
                BufferedReader br = CallChecker.varInit(null, "br", 4736, 179133, 179157);
                TryContext _bcornu_try_context_248 = new TryContext(248, Felix.class, "java.io.FileNotFoundException", "java.lang.Exception");
                try {
                    File file = CallChecker.init(File.class);
                    if (CallChecker.beforeDeref(m_cache, BundleCache.class, 4739, 179217, 179223)) {
                        m_cache = CallChecker.beforeCalled(m_cache, BundleCache.class, 4739, 179217, 179223);
                        file = CallChecker.isCalled(m_cache, BundleCache.class, 4739, 179217, 179223).getSystemBundleDataFile("bundle.id");
                        CallChecker.varAssign(file, "file", 4739, 179217, 179223);
                    }
                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 4740, 179284, 179297)) {
                        is = CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 4740, 179284, 179297).getFileInputStream(file);
                        CallChecker.varAssign(is, "is", 4740, 179279, 179323);
                    }
                    br = new BufferedReader(new InputStreamReader(is));
                    CallChecker.varAssign(br, "br", 4741, 179341, 179391);
                    if (CallChecker.beforeDeref(br, BufferedReader.class, 4742, 179431, 179432)) {
                        br = CallChecker.beforeCalled(br, BufferedReader.class, 4742, 179431, 179432);
                        return Long.parseLong(CallChecker.isCalled(br, BufferedReader.class, 4742, 179431, 179432).readLine());
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (FileNotFoundException ex) {
                    _bcornu_try_context_248.catchStart(248);
                } catch (Exception ex) {
                    _bcornu_try_context_248.catchStart(248);
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 4752, 179782, 179789)) {
                        CallChecker.isCalled(m_logger, Logger.class, 4752, 179782, 179789).log(Logger.LOG_WARNING, "Unable to initialize next bundle identifier from persistent storage.", ex);
                    }
                } finally {
                    _bcornu_try_context_248.finallyStart(248);
                    TryContext _bcornu_try_context_247 = new TryContext(247, Felix.class, "java.lang.Exception");
                    try {
                        if (br != null)
                            br.close();
                        
                        if (is != null)
                            is.close();
                        
                    } catch (Exception ex) {
                        _bcornu_try_context_247.catchStart(247);
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 4766, 180228, 180235)) {
                            CallChecker.isCalled(m_logger, Logger.class, 4766, 180228, 180235).log(Logger.LOG_WARNING, "Unable to close next bundle identifier file.", ex);
                        }
                    } finally {
                        _bcornu_try_context_247.finallyStart(247);
                    }
                }
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context688.methodEnd();
        }
    }

    private long getNextId() {
        MethodContext _bcornu_methode_context689 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 4777, 180460, 181858);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 4777, 180460, 181858);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 4777, 180460, 181858);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 4777, 180460, 181858);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 4777, 180460, 181858);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 4777, 180460, 181858);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 4777, 180460, 181858);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 4777, 180460, 181858);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 4777, 180460, 181858);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 4777, 180460, 181858);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 4777, 180460, 181858);
            CallChecker.varInit(this.m_registry, "m_registry", 4777, 180460, 181858);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 4777, 180460, 181858);
            CallChecker.varInit(this.m_nextId, "m_nextId", 4777, 180460, 181858);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 4777, 180460, 181858);
            CallChecker.varInit(this.m_cache, "m_cache", 4777, 180460, 181858);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 4777, 180460, 181858);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 4777, 180460, 181858);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 4777, 180460, 181858);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 4777, 180460, 181858);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 4777, 180460, 181858);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 4777, 180460, 181858);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 4777, 180460, 181858);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 4777, 180460, 181858);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 4777, 180460, 181858);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 4777, 180460, 181858);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 4777, 180460, 181858);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 4777, 180460, 181858);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 4777, 180460, 181858);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 4777, 180460, 181858);
            CallChecker.varInit(this.m_resolver, "m_resolver", 4777, 180460, 181858);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 4777, 180460, 181858);
            CallChecker.varInit(this.m_configMap, "m_configMap", 4777, 180460, 181858);
            CallChecker.varInit(this.m_logger, "m_logger", 4777, 180460, 181858);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 4777, 180460, 181858);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 4777, 180460, 181858);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 4777, 180460, 181858);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 4777, 180460, 181858);
            synchronized(m_nextIdLock) {
                long id = CallChecker.varInit(((long) (this.m_nextId)), "id", 4782, 180585, 180603);
                (m_nextId)++;
                OutputStream os = CallChecker.varInit(null, "os", 4788, 180720, 180742);
                BufferedWriter bw = CallChecker.varInit(null, "bw", 4789, 180756, 180780);
                TryContext _bcornu_try_context_250 = new TryContext(250, Felix.class, "java.lang.Exception");
                try {
                    File file = CallChecker.init(File.class);
                    if (CallChecker.beforeDeref(m_cache, BundleCache.class, 4792, 180840, 180846)) {
                        m_cache = CallChecker.beforeCalled(m_cache, BundleCache.class, 4792, 180840, 180846);
                        file = CallChecker.isCalled(m_cache, BundleCache.class, 4792, 180840, 180846).getSystemBundleDataFile("bundle.id");
                        CallChecker.varAssign(file, "file", 4792, 180840, 180846);
                    }
                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 4793, 180907, 180920)) {
                        os = CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 4793, 180907, 180920).getFileOutputStream(file);
                        CallChecker.varAssign(os, "os", 4793, 180902, 180947);
                    }
                    bw = new BufferedWriter(new OutputStreamWriter(os));
                    CallChecker.varAssign(bw, "bw", 4794, 180965, 181016);
                    String s = CallChecker.varInit(Long.toString(m_nextId), "s", 4795, 181034, 181068);
                    if (CallChecker.beforeDeref(s, String.class, 4796, 181101, 181101)) {
                        if (CallChecker.beforeDeref(bw, BufferedWriter.class, 4796, 181086, 181087)) {
                            s = CallChecker.beforeCalled(s, String.class, 4796, 181101, 181101);
                            bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 4796, 181086, 181087);
                            CallChecker.isCalled(bw, BufferedWriter.class, 4796, 181086, 181087).write(s, 0, CallChecker.isCalled(s, String.class, 4796, 181101, 181101).length());
                        }
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_250.catchStart(250);
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 4800, 181191, 181198)) {
                        CallChecker.isCalled(m_logger, Logger.class, 4800, 181191, 181198).log(Logger.LOG_WARNING, "Unable to save next bundle identifier to persistent storage.", ex);
                    }
                } finally {
                    _bcornu_try_context_250.finallyStart(250);
                    TryContext _bcornu_try_context_249 = new TryContext(249, Felix.class, "java.lang.Exception");
                    try {
                        if (bw != null)
                            bw.close();
                        
                        if (os != null)
                            os.close();
                        
                    } catch (Exception ex) {
                        _bcornu_try_context_249.catchStart(249);
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 4814, 181629, 181636)) {
                            CallChecker.isCalled(m_logger, Logger.class, 4814, 181629, 181636).log(Logger.LOG_WARNING, "Unable to close next bundle identifier file.", ex);
                        }
                    } finally {
                        _bcornu_try_context_249.finallyStart(249);
                    }
                }
                return id;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context689.methodEnd();
        }
    }

    class SystemBundleActivator implements BundleActivator {
        public void start(BundleContext context) throws Exception {
            MethodContext _bcornu_methode_context690 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 4831, 181985, 183010);
                CallChecker.varInit(context, "context", 4831, 181985, 183010);
                if (CallChecker.beforeDeref(m_activatorList, List.class, 4834, 182134, 182148)) {
                    m_activatorList = CallChecker.beforeCalled(m_activatorList, List.class, 4834, 182134, 182148);
                    CallChecker.isCalled(m_activatorList, List.class, 4834, 182134, 182148).add(0, new URLHandlersActivator(m_configMap, Felix.this));
                }
                m_activatorList = CallChecker.beforeCalled(m_activatorList, List.class, 4837, 182297, 182311);
                for (Iterator<BundleActivator> iter = CallChecker.isCalled(m_activatorList, List.class, 4837, 182297, 182311).iterator(); CallChecker.isCalled(iter, Iterator.class, 4837, 182325, 182328).hasNext();) {
                    TryContext _bcornu_try_context_251 = new TryContext(251, Felix.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(iter, Iterator.class, 4842, 182476, 182479)) {
                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 4841, 182415, 182434)) {
                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 4841, 182415, 182434).startActivator(CallChecker.isCalled(iter, Iterator.class, 4842, 182476, 182479).next(), context);
                            }
                        }
                    } catch (Throwable throwable) {
                        _bcornu_try_context_251.catchStart(251);
                        if (CallChecker.beforeDeref(iter, Iterator.class, 4846, 182599, 182602)) {
                            CallChecker.isCalled(iter, Iterator.class, 4846, 182599, 182602).remove();
                        }
                        if (CallChecker.beforeDeref(context, BundleContext.class, 4847, 182675, 182681)) {
                            context = CallChecker.beforeCalled(context, BundleContext.class, 4847, 182675, 182681);
                            fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(context, BundleContext.class, 4847, 182675, 182681).getBundle(), new BundleException("Unable to start Bundle", throwable));
                        }
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 4849, 182803, 182810)) {
                            CallChecker.isCalled(m_logger, Logger.class, 4849, 182803, 182810).log(Logger.LOG_WARNING, "Exception starting a system bundle activator.", throwable);
                        }
                    } finally {
                        _bcornu_try_context_251.finallyStart(251);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context690.methodEnd();
            }
        }

        public void stop(BundleContext context) {
            MethodContext _bcornu_methode_context691 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 4857, 183021, 187733);
                CallChecker.varInit(context, "context", 4857, 183021, 187733);
                acquireBundleLock(Felix.this, Bundle.STOPPING);
                releaseBundleLock(Felix.this);
                if (CallChecker.beforeDeref(m_fwkStartLevel, FrameworkStartLevelImpl.class, 4869, 183661, 183675)) {
                    CallChecker.isCalled(m_fwkStartLevel, FrameworkStartLevelImpl.class, 4869, 183661, 183675).setStartLevelAndWait(0);
                }
                if (CallChecker.beforeDeref(m_fwkWiring, FrameworkWiringImpl.class, 4872, 183760, 183770)) {
                    CallChecker.isCalled(m_fwkWiring, FrameworkWiringImpl.class, 4872, 183760, 183770).stop();
                }
                if (CallChecker.beforeDeref(m_fwkStartLevel, FrameworkStartLevelImpl.class, 4874, 183842, 183856)) {
                    CallChecker.isCalled(m_fwkStartLevel, FrameworkStartLevelImpl.class, 4874, 183842, 183856).stop();
                }
                if (CallChecker.beforeDeref(m_dispatcher, EventDispatcher.class, 4877, 183928, 183939)) {
                    CallChecker.isCalled(m_dispatcher, EventDispatcher.class, 4877, 183928, 183939).stopDispatching();
                }
                Bundle[] bundles = CallChecker.varInit(getBundles(), "bundles", 4884, 184198, 184229);
                bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 4885, 184263, 184269);
                for (int i = 0; i < (CallChecker.isCalled(bundles, Bundle[].class, 4885, 184263, 184269).length); i++) {
                    BundleImpl bundle = CallChecker.init(BundleImpl.class);
                    if (CallChecker.beforeDeref(bundles, Bundle[].class, 4887, 184347, 184353)) {
                        bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 4887, 184347, 184353);
                        bundle = ((BundleImpl) (CallChecker.isCalled(bundles, Bundle[].class, 4887, 184347, 184353)[i]));
                        CallChecker.varAssign(bundle, "bundle", 4887, 184347, 184353);
                    }
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 4888, 184379, 184384)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 4888, 184379, 184384);
                        if (CallChecker.isCalled(bundle, BundleImpl.class, 4888, 184379, 184384).isRemovalPending()) {
                            TryContext _bcornu_try_context_252 = new TryContext(252, Felix.class, "java.lang.Exception");
                            try {
                                refreshBundle(bundle);
                            } catch (Exception ex) {
                                _bcornu_try_context_252.catchStart(252);
                                fireFrameworkEvent(FrameworkEvent.ERROR, bundle, ex);
                                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 4898, 184799, 184804)) {
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 4897, 184704, 184711)) {
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 4898, 184799, 184804);
                                        CallChecker.isCalled(m_logger, Logger.class, 4897, 184704, 184711).log(bundle, Logger.LOG_ERROR, ("Unable to purge bundle " + (CallChecker.isCalled(bundle, BundleImpl.class, 4898, 184799, 184804)._getLocation())), ex);
                                    }
                                }
                            } finally {
                                _bcornu_try_context_252.finallyStart(252);
                            }
                        }
                    }
                }
                m_uninstalledBundles = CallChecker.beforeCalled(m_uninstalledBundles, List.class, 4905, 185008, 185027);
                for (int i = 0; ((m_uninstalledBundles) != null) && (i < (CallChecker.isCalled(m_uninstalledBundles, List.class, 4905, 185008, 185027).size())); i++) {
                    TryContext _bcornu_try_context_253 = new TryContext(253, Felix.class, "java.lang.Exception");
                    try {
                        m_uninstalledBundles = CallChecker.beforeCalled(m_uninstalledBundles, List.class, 4910, 185131, 185150);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m_uninstalledBundles, List.class, 4910, 185131, 185150).get(i), BundleImpl.class, 4910, 185131, 185157)) {
                            CallChecker.isCalled(m_uninstalledBundles.get(i), BundleImpl.class, 4910, 185131, 185157).closeAndDelete();
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_253.catchStart(253);
                        m_uninstalledBundles = CallChecker.beforeCalled(m_uninstalledBundles, List.class, 4917, 185424, 185443);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m_uninstalledBundles, List.class, 4917, 185424, 185443).get(i), BundleImpl.class, 4917, 185424, 185450)) {
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 4914, 185270, 185277)) {
                                CallChecker.isCalled(m_logger, Logger.class, 4914, 185270, 185277).log(m_uninstalledBundles.get(i), Logger.LOG_ERROR, ("Unable to remove " + (CallChecker.isCalled(m_uninstalledBundles.get(i), BundleImpl.class, 4917, 185424, 185450)._getLocation())), ex);
                            }
                        }
                    } finally {
                        _bcornu_try_context_253.finallyStart(253);
                    }
                }
                bundles = getBundles();
                CallChecker.varAssign(bundles, "bundles", 4922, 185592, 185614);
                bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 4923, 185648, 185654);
                for (int i = 0; i < (CallChecker.isCalled(bundles, Bundle[].class, 4923, 185648, 185654).length); i++) {
                    if (CallChecker.beforeDeref(bundles, Bundle[].class, 4925, 185713, 185719)) {
                        bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 4925, 185713, 185719);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(bundles, Bundle[].class, 4925, 185713, 185719)[i], Bundle.class, 4925, 185713, 185722)) {
                            bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 4925, 185713, 185719);
                            CallChecker.isCalled(bundles, Bundle[].class, 4925, 185713, 185719)[i] = CallChecker.beforeCalled(CallChecker.isCalled(bundles, Bundle[].class, 4925, 185713, 185719)[i], BundleImpl.class, 4925, 185713, 185722);
                            CallChecker.isCalled(((BundleImpl) (CallChecker.isCalled(bundles, Bundle[].class, 4925, 185713, 185719)[i])), BundleImpl.class, 4925, 185713, 185722).close();
                        }
                    }
                }
                if (CallChecker.beforeDeref(m_extensionManager, ExtensionManager.class, 4928, 185761, 185778)) {
                    CallChecker.isCalled(m_extensionManager, ExtensionManager.class, 4928, 185761, 185778).stopExtensionBundles(Felix.this);
                }
                m_activatorList = CallChecker.beforeCalled(m_activatorList, List.class, 4930, 185896, 185910);
                for (int i = 0; i < (CallChecker.isCalled(m_activatorList, List.class, 4930, 185896, 185910).size()); i++) {
                    TryContext _bcornu_try_context_254 = new TryContext(254, Felix.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(m_activatorList, List.class, 4935, 186074, 186088)) {
                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 4934, 185997, 186016)) {
                                m_activatorList = CallChecker.beforeCalled(m_activatorList, List.class, 4935, 186074, 186088);
                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 4934, 185997, 186016).stopActivator(((BundleActivator) (CallChecker.isCalled(m_activatorList, List.class, 4935, 186074, 186088).get(i))), _getBundleContext());
                            }
                        }
                    } catch (Throwable throwable) {
                        _bcornu_try_context_254.catchStart(254);
                        if (CallChecker.beforeDeref(context, BundleContext.class, 4939, 186261, 186267)) {
                            context = CallChecker.beforeCalled(context, BundleContext.class, 4939, 186261, 186267);
                            fireFrameworkEvent(FrameworkEvent.ERROR, CallChecker.isCalled(context, BundleContext.class, 4939, 186261, 186267).getBundle(), new BundleException("Unable to stop Bundle", throwable));
                        }
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 4941, 186384, 186391)) {
                            CallChecker.isCalled(m_logger, Logger.class, 4941, 186384, 186391).log(Logger.LOG_WARNING, "Exception stopping a system bundle activator.", throwable);
                        }
                    } finally {
                        _bcornu_try_context_254.finallyStart(254);
                    }
                }
                if ((m_securityManager) != null) {
                    System.setSecurityManager(null);
                    m_securityManager = null;
                    CallChecker.varAssign(Felix.this.m_securityManager, "this.m_securityManager", 4950, 186705, 186729);
                }
                if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 4953, 186758, 186771)) {
                    CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 4953, 186758, 186771).removeDependents(adapt(BundleRevision.class));
                }
                if ((m_extensionManager) != null) {
                    m_extensionManager.removeExtensions(Felix.this);
                }
                if (CallChecker.beforeDeref(m_cache, BundleCache.class, 4961, 187015, 187021)) {
                    m_cache = CallChecker.beforeCalled(m_cache, BundleCache.class, 4961, 187015, 187021);
                    CallChecker.isCalled(m_cache, BundleCache.class, 4961, 187015, 187021).release();
                }
                m_cache = null;
                CallChecker.varAssign(Felix.this.m_cache, "this.m_cache", 4962, 187046, 187060);
                acquireBundleLock(Felix.this, Bundle.STOPPING);
                TryContext _bcornu_try_context_255 = new TryContext(255, Felix.class);
                try {
                    final BundleContextImpl npe_invocation_var227 = ((BundleContextImpl) (_getBundleContext()));
                    if (CallChecker.beforeDeref(npe_invocation_var227, BundleContextImpl.class, 4969, 187290, 187308)) {
                        CallChecker.isCalled(npe_invocation_var227, BundleContextImpl.class, 4969, 187290, 187308).invalidate();
                    }
                    setBundleContext(null);
                    setBundleStateAndNotify(Felix.this, Bundle.RESOLVED);
                    if (CallChecker.beforeDeref(m_shutdownGate, ThreadGate.class, 4975, 187554, 187567)) {
                        m_shutdownGate = CallChecker.beforeCalled(m_shutdownGate, ThreadGate.class, 4975, 187554, 187567);
                        CallChecker.isCalled(m_shutdownGate, ThreadGate.class, 4975, 187554, 187567).open();
                    }
                    m_shutdownGate = null;
                    CallChecker.varAssign(Felix.this.m_shutdownGate, "this.m_shutdownGate", 4976, 187593, 187614);
                } finally {
                    _bcornu_try_context_255.finallyStart(255);
                    releaseBundleLock(Felix.this);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context691.methodEnd();
            }
        }
    }

    private class RefreshHelper {
        private BundleImpl m_bundle = null;

        private int m_oldState = Bundle.INSTALLED;

        public RefreshHelper(Bundle bundle) {
            MethodContext _bcornu_methode_context48 = new MethodContext(null);
            try {
                m_bundle = ((BundleImpl) (bundle));
                CallChecker.varAssign(this.m_bundle, "this.m_bundle", 4997, 188180, 188210);
            } finally {
                _bcornu_methode_context48.methodEnd();
            }
        }

        public void stop() {
            MethodContext _bcornu_methode_context692 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 5000, 188231, 189045);
                CallChecker.varInit(this.m_oldState, "m_oldState", 5000, 188231, 189045);
                CallChecker.varInit(this.m_bundle, "m_bundle", 5000, 188231, 189045);
                acquireBundleLock(m_bundle, ((((((Bundle.INSTALLED) | (Bundle.RESOLVED)) | (Bundle.STARTING)) | (Bundle.ACTIVE)) | (Bundle.STOPPING)) | (Bundle.UNINSTALLED)));
                TryContext _bcornu_try_context_256 = new TryContext(256, Felix.class, "java.lang.Throwable");
                try {
                    if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 5007, 188509, 188516)) {
                        m_bundle = CallChecker.beforeCalled(m_bundle, BundleImpl.class, 5007, 188509, 188516);
                        m_oldState = CallChecker.isCalled(m_bundle, BundleImpl.class, 5007, 188509, 188516).getState();
                        CallChecker.varAssign(this.m_oldState, "this.m_oldState", 5007, 188496, 188528);
                    }
                    if ((m_oldState) != (Bundle.UNINSTALLED)) {
                        if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 5010, 188643, 188650)) {
                            m_bundle = CallChecker.beforeCalled(m_bundle, BundleImpl.class, 5010, 188643, 188650);
                            if (!(Util.isFragment(CallChecker.isCalled(m_bundle, BundleImpl.class, 5010, 188643, 188650).adapt(BundleRevision.class)))) {
                                stopBundle(m_bundle, false);
                            }
                        }
                    }
                } catch (Throwable ex) {
                    _bcornu_try_context_256.catchStart(256);
                    fireFrameworkEvent(FrameworkEvent.ERROR, m_bundle, ex);
                } finally {
                    _bcornu_try_context_256.finallyStart(256);
                    releaseBundleLock(m_bundle);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context692.methodEnd();
            }
        }

        public void refreshOrRemove() {
            MethodContext _bcornu_methode_context693 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 5026, 189056, 189967);
                CallChecker.varInit(this.m_oldState, "m_oldState", 5026, 189056, 189967);
                CallChecker.varInit(this.m_bundle, "m_bundle", 5026, 189056, 189967);
                TryContext _bcornu_try_context_257 = new TryContext(257, Felix.class, "java.lang.Throwable");
                try {
                    if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 5032, 189245, 189252)) {
                        m_bundle = CallChecker.beforeCalled(m_bundle, BundleImpl.class, 5032, 189245, 189252);
                        if ((CallChecker.isCalled(m_bundle, BundleImpl.class, 5032, 189245, 189252).getState()) == (Bundle.UNINSTALLED)) {
                            if (CallChecker.beforeDeref(m_dependencies, BundleRevisionDependencies.class, 5035, 189370, 189383)) {
                                CallChecker.isCalled(m_dependencies, BundleRevisionDependencies.class, 5035, 189370, 189383).removeDependencies(m_bundle);
                            }
                            if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 5036, 189435, 189442)) {
                                m_bundle = CallChecker.beforeCalled(m_bundle, BundleImpl.class, 5036, 189435, 189442);
                                CallChecker.isCalled(m_bundle, BundleImpl.class, 5036, 189435, 189442).closeAndDelete();
                            }
                            m_bundle = null;
                            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 5037, 189482, 189497);
                        }else {
                            refreshBundle(m_bundle);
                        }
                    }
                } catch (Throwable ex) {
                    _bcornu_try_context_257.catchStart(257);
                    fireFrameworkEvent(FrameworkEvent.ERROR, m_bundle, ex);
                } finally {
                    _bcornu_try_context_257.finallyStart(257);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context693.methodEnd();
            }
        }

        public void restart() {
            MethodContext _bcornu_methode_context694 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 5053, 189978, 190665);
                CallChecker.varInit(this.m_oldState, "m_oldState", 5053, 189978, 190665);
                CallChecker.varInit(this.m_bundle, "m_bundle", 5053, 189978, 190665);
                if (((m_bundle) != null) && ((m_oldState) == (Bundle.ACTIVE))) {
                    TryContext _bcornu_try_context_258 = new TryContext(258, Felix.class, "java.lang.Throwable");
                    try {
                        int options = CallChecker.varInit(((int) (Bundle.START_TRANSIENT)), "options", 5060, 190203, 190239);
                        if ((m_bundle.getPersistentState()) == (Bundle.STARTING)) {
                            options = options | (Bundle.START_ACTIVATION_POLICY);
                            CallChecker.varAssign(options, "options", 5061, 190261, 190422);
                        }else {
                            options = options;
                            CallChecker.varAssign(options, "options", 5061, 190261, 190422);
                        }
                        startBundle(m_bundle, options);
                    } catch (Throwable ex) {
                        _bcornu_try_context_258.catchStart(258);
                        fireFrameworkEvent(FrameworkEvent.ERROR, m_bundle, ex);
                    } finally {
                        _bcornu_try_context_258.finallyStart(258);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context694.methodEnd();
            }
        }
    }

    private static class StartLevelTuple implements Comparable<Felix.StartLevelTuple> {
        private final BundleImpl m_bundle;

        private int m_level;

        StartLevelTuple(BundleImpl bundle, int level) {
            MethodContext _bcornu_methode_context49 = new MethodContext(null);
            try {
                m_bundle = bundle;
                CallChecker.varAssign(this.m_bundle, "this.m_bundle", 5083, 191011, 191028);
                m_level = level;
                CallChecker.varAssign(this.m_level, "this.m_level", 5084, 191042, 191057);
            } finally {
                _bcornu_methode_context49.methodEnd();
            }
        }

        public int compareTo(Felix.StartLevelTuple t) {
            MethodContext _bcornu_methode_context695 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 5087, 191078, 191643);
                CallChecker.varInit(t, "t", 5087, 191078, 191643);
                CallChecker.varInit(this.m_level, "m_level", 5087, 191078, 191643);
                CallChecker.varInit(this.m_bundle, "m_bundle", 5087, 191078, 191643);
                int result = CallChecker.varInit(((int) (1)), "result", 5089, 191140, 191154);
                if (CallChecker.beforeDeref(t, Felix.StartLevelTuple.class, 5091, 191183, 191183)) {
                    t = CallChecker.beforeCalled(t, Felix.StartLevelTuple.class, 5091, 191183, 191183);
                    if ((m_level) < (CallChecker.isCalled(t, Felix.StartLevelTuple.class, 5091, 191183, 191183).m_level)) {
                        result = -1;
                        CallChecker.varAssign(result, "result", 5093, 191224, 191235);
                    }else
                        if (CallChecker.beforeDeref(t, Felix.StartLevelTuple.class, 5095, 191282, 191282)) {
                            t = CallChecker.beforeCalled(t, Felix.StartLevelTuple.class, 5095, 191282, 191282);
                            if ((m_level) > (CallChecker.isCalled(t, Felix.StartLevelTuple.class, 5095, 191282, 191282).m_level)) {
                                result = 1;
                                CallChecker.varAssign(result, "result", 5097, 191323, 191333);
                            }else
                                if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 5099, 191370, 191377)) {
                                    if (CallChecker.beforeDeref(t, Felix.StartLevelTuple.class, 5099, 191395, 191395)) {
                                        t = CallChecker.beforeCalled(t, Felix.StartLevelTuple.class, 5099, 191395, 191395);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(t, Felix.StartLevelTuple.class, 5099, 191395, 191395).m_bundle, BundleImpl.class, 5099, 191395, 191404)) {
                                            t = CallChecker.beforeCalled(t, Felix.StartLevelTuple.class, 5099, 191395, 191395);
                                            if ((CallChecker.isCalled(m_bundle, BundleImpl.class, 5099, 191370, 191377).getBundleId()) < (CallChecker.isCalled(CallChecker.isCalled(t, Felix.StartLevelTuple.class, 5099, 191395, 191395).m_bundle, BundleImpl.class, 5099, 191395, 191404).getBundleId())) {
                                                result = -1;
                                                CallChecker.varAssign(result, "result", 5101, 191451, 191462);
                                            }else
                                                if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 5103, 191499, 191506)) {
                                                    if (CallChecker.beforeDeref(t, Felix.StartLevelTuple.class, 5103, 191525, 191525)) {
                                                        t = CallChecker.beforeCalled(t, Felix.StartLevelTuple.class, 5103, 191525, 191525);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(t, Felix.StartLevelTuple.class, 5103, 191525, 191525).m_bundle, BundleImpl.class, 5103, 191525, 191534)) {
                                                            t = CallChecker.beforeCalled(t, Felix.StartLevelTuple.class, 5103, 191525, 191525);
                                                            if ((CallChecker.isCalled(m_bundle, BundleImpl.class, 5103, 191499, 191506).getBundleId()) == (CallChecker.isCalled(CallChecker.isCalled(t, Felix.StartLevelTuple.class, 5103, 191525, 191525).m_bundle, BundleImpl.class, 5103, 191525, 191534).getBundleId())) {
                                                                result = 0;
                                                                CallChecker.varAssign(result, "result", 5105, 191581, 191591);
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
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context695.methodEnd();
            }
        }
    }

    private void rememberUninstalledBundle(BundleImpl bundle) {
        MethodContext _bcornu_methode_context696 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5116, 191656, 192847);
            CallChecker.varInit(bundle, "bundle", 5116, 191656, 192847);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5116, 191656, 192847);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5116, 191656, 192847);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5116, 191656, 192847);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5116, 191656, 192847);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5116, 191656, 192847);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5116, 191656, 192847);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5116, 191656, 192847);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5116, 191656, 192847);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5116, 191656, 192847);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5116, 191656, 192847);
            CallChecker.varInit(this.m_registry, "m_registry", 5116, 191656, 192847);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5116, 191656, 192847);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5116, 191656, 192847);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5116, 191656, 192847);
            CallChecker.varInit(this.m_cache, "m_cache", 5116, 191656, 192847);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5116, 191656, 192847);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5116, 191656, 192847);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5116, 191656, 192847);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5116, 191656, 192847);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5116, 191656, 192847);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5116, 191656, 192847);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5116, 191656, 192847);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5116, 191656, 192847);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5116, 191656, 192847);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5116, 191656, 192847);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5116, 191656, 192847);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5116, 191656, 192847);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5116, 191656, 192847);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5116, 191656, 192847);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5116, 191656, 192847);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5116, 191656, 192847);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5116, 191656, 192847);
            CallChecker.varInit(this.m_logger, "m_logger", 5116, 191656, 192847);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5116, 191656, 192847);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5116, 191656, 192847);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5116, 191656, 192847);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5116, 191656, 192847);
            boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 5118, 191775, 191811);
            if (!locked) {
                throw new IllegalStateException("Unable to acquire global lock to record uninstalled bundle.");
            }
            TryContext _bcornu_try_context_259 = new TryContext(259, Felix.class);
            try {
                m_uninstalledBundles = CallChecker.beforeCalled(m_uninstalledBundles, List.class, 5130, 192273, 192292);
                for (int i = 0; ((m_uninstalledBundles) != null) && (i < (CallChecker.isCalled(m_uninstalledBundles, List.class, 5130, 192273, 192292).size())); i++) {
                    if ((m_uninstalledBundles.get(i)) == bundle) {
                        return ;
                    }
                }
                List<BundleImpl> uninstalledBundles = CallChecker.varInit(new ArrayList(m_uninstalledBundles), "uninstalledBundles", 5141, 192590, 192663);
                if (CallChecker.beforeDeref(uninstalledBundles, List.class, 5142, 192677, 192694)) {
                    uninstalledBundles = CallChecker.beforeCalled(uninstalledBundles, List.class, 5142, 192677, 192694);
                    CallChecker.isCalled(uninstalledBundles, List.class, 5142, 192677, 192694).add(bundle);
                }
                m_uninstalledBundles = uninstalledBundles;
                CallChecker.varAssign(this.m_uninstalledBundles, "this.m_uninstalledBundles", 5143, 192721, 192762);
            } finally {
                _bcornu_try_context_259.finallyStart(259);
                releaseGlobalLock();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context696.methodEnd();
        }
    }

    private void forgetUninstalledBundle(BundleImpl bundle) {
        MethodContext _bcornu_methode_context697 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5151, 192854, 193751);
            CallChecker.varInit(bundle, "bundle", 5151, 192854, 193751);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5151, 192854, 193751);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5151, 192854, 193751);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5151, 192854, 193751);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5151, 192854, 193751);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5151, 192854, 193751);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5151, 192854, 193751);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5151, 192854, 193751);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5151, 192854, 193751);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5151, 192854, 193751);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5151, 192854, 193751);
            CallChecker.varInit(this.m_registry, "m_registry", 5151, 192854, 193751);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5151, 192854, 193751);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5151, 192854, 193751);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5151, 192854, 193751);
            CallChecker.varInit(this.m_cache, "m_cache", 5151, 192854, 193751);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5151, 192854, 193751);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5151, 192854, 193751);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5151, 192854, 193751);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5151, 192854, 193751);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5151, 192854, 193751);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5151, 192854, 193751);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5151, 192854, 193751);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5151, 192854, 193751);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5151, 192854, 193751);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5151, 192854, 193751);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5151, 192854, 193751);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5151, 192854, 193751);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5151, 192854, 193751);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5151, 192854, 193751);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5151, 192854, 193751);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5151, 192854, 193751);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5151, 192854, 193751);
            CallChecker.varInit(this.m_logger, "m_logger", 5151, 192854, 193751);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5151, 192854, 193751);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5151, 192854, 193751);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5151, 192854, 193751);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5151, 192854, 193751);
            boolean locked = CallChecker.varInit(((boolean) (acquireGlobalLock())), "locked", 5153, 192924, 192960);
            if (!locked) {
                throw new IllegalStateException("Unable to acquire global lock to release uninstalled bundle.");
            }
            TryContext _bcornu_try_context_260 = new TryContext(260, Felix.class);
            try {
                if ((m_uninstalledBundles) == null) {
                    return ;
                }
                List<BundleImpl> uninstalledBundles = CallChecker.varInit(new ArrayList(m_uninstalledBundles), "uninstalledBundles", 5170, 193491, 193564);
                if (CallChecker.beforeDeref(uninstalledBundles, List.class, 5171, 193578, 193595)) {
                    uninstalledBundles = CallChecker.beforeCalled(uninstalledBundles, List.class, 5171, 193578, 193595);
                    CallChecker.isCalled(uninstalledBundles, List.class, 5171, 193578, 193595).remove(bundle);
                }
                m_uninstalledBundles = uninstalledBundles;
                CallChecker.varAssign(this.m_uninstalledBundles, "this.m_uninstalledBundles", 5172, 193625, 193666);
            } finally {
                _bcornu_try_context_260.finallyStart(260);
                releaseGlobalLock();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context697.methodEnd();
        }
    }

    void acquireInstallLock(String location) throws BundleException {
        MethodContext _bcornu_methode_context698 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5180, 193758, 194350);
            CallChecker.varInit(location, "location", 5180, 193758, 194350);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5180, 193758, 194350);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5180, 193758, 194350);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5180, 193758, 194350);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5180, 193758, 194350);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5180, 193758, 194350);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5180, 193758, 194350);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5180, 193758, 194350);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5180, 193758, 194350);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5180, 193758, 194350);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5180, 193758, 194350);
            CallChecker.varInit(this.m_registry, "m_registry", 5180, 193758, 194350);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5180, 193758, 194350);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5180, 193758, 194350);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5180, 193758, 194350);
            CallChecker.varInit(this.m_cache, "m_cache", 5180, 193758, 194350);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5180, 193758, 194350);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5180, 193758, 194350);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5180, 193758, 194350);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5180, 193758, 194350);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5180, 193758, 194350);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5180, 193758, 194350);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5180, 193758, 194350);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5180, 193758, 194350);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5180, 193758, 194350);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5180, 193758, 194350);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5180, 193758, 194350);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5180, 193758, 194350);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5180, 193758, 194350);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5180, 193758, 194350);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5180, 193758, 194350);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5180, 193758, 194350);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5180, 193758, 194350);
            CallChecker.varInit(this.m_logger, "m_logger", 5180, 193758, 194350);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5180, 193758, 194350);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5180, 193758, 194350);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5180, 193758, 194350);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5180, 193758, 194350);
            synchronized(m_installRequestLock_Priority1) {
                while ((CallChecker.isCalled(m_installRequestMap, Map.class, 5185, 193919, 193937).get(location)) != null) {
                    TryContext _bcornu_try_context_261 = new TryContext(261, Felix.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(m_installRequestLock_Priority1, Object[].class, 5189, 194034, 194063)) {
                            CallChecker.isCalled(m_installRequestLock_Priority1, Object[].class, 5189, 194034, 194063).wait();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_261.catchStart(261);
                        throw new BundleException("Unable to install, thread interrupted.");
                    } finally {
                        _bcornu_try_context_261.finallyStart(261);
                    }
                } 
                if (CallChecker.beforeDeref(m_installRequestMap, Map.class, 5197, 194291, 194309)) {
                    CallChecker.isCalled(m_installRequestMap, Map.class, 5197, 194291, 194309).put(location, location);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context698.methodEnd();
        }
    }

    void releaseInstallLock(String location) {
        MethodContext _bcornu_methode_context699 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5201, 194357, 194588);
            CallChecker.varInit(location, "location", 5201, 194357, 194588);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5201, 194357, 194588);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5201, 194357, 194588);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5201, 194357, 194588);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5201, 194357, 194588);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5201, 194357, 194588);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5201, 194357, 194588);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5201, 194357, 194588);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5201, 194357, 194588);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5201, 194357, 194588);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5201, 194357, 194588);
            CallChecker.varInit(this.m_registry, "m_registry", 5201, 194357, 194588);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5201, 194357, 194588);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5201, 194357, 194588);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5201, 194357, 194588);
            CallChecker.varInit(this.m_cache, "m_cache", 5201, 194357, 194588);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5201, 194357, 194588);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5201, 194357, 194588);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5201, 194357, 194588);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5201, 194357, 194588);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5201, 194357, 194588);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5201, 194357, 194588);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5201, 194357, 194588);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5201, 194357, 194588);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5201, 194357, 194588);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5201, 194357, 194588);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5201, 194357, 194588);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5201, 194357, 194588);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5201, 194357, 194588);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5201, 194357, 194588);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5201, 194357, 194588);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5201, 194357, 194588);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5201, 194357, 194588);
            CallChecker.varInit(this.m_logger, "m_logger", 5201, 194357, 194588);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5201, 194357, 194588);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5201, 194357, 194588);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5201, 194357, 194588);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5201, 194357, 194588);
            synchronized(m_installRequestLock_Priority1) {
                if (CallChecker.beforeDeref(m_installRequestMap, Map.class, 5205, 194480, 194498)) {
                    CallChecker.isCalled(m_installRequestMap, Map.class, 5205, 194480, 194498).remove(location);
                }
                if (CallChecker.beforeDeref(m_installRequestLock_Priority1, Object[].class, 5206, 194530, 194559)) {
                    CallChecker.isCalled(m_installRequestLock_Priority1, Object[].class, 5206, 194530, 194559).notifyAll();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context699.methodEnd();
        }
    }

    void setBundleStateAndNotify(BundleImpl bundle, int state) {
        MethodContext _bcornu_methode_context700 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5210, 194595, 194796);
            CallChecker.varInit(state, "state", 5210, 194595, 194796);
            CallChecker.varInit(bundle, "bundle", 5210, 194595, 194796);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5210, 194595, 194796);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5210, 194595, 194796);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5210, 194595, 194796);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5210, 194595, 194796);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5210, 194595, 194796);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5210, 194595, 194796);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5210, 194595, 194796);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5210, 194595, 194796);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5210, 194595, 194796);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5210, 194595, 194796);
            CallChecker.varInit(this.m_registry, "m_registry", 5210, 194595, 194796);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5210, 194595, 194796);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5210, 194595, 194796);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5210, 194595, 194796);
            CallChecker.varInit(this.m_cache, "m_cache", 5210, 194595, 194796);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5210, 194595, 194796);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5210, 194595, 194796);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5210, 194595, 194796);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5210, 194595, 194796);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5210, 194595, 194796);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5210, 194595, 194796);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5210, 194595, 194796);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5210, 194595, 194796);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5210, 194595, 194796);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5210, 194595, 194796);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5210, 194595, 194796);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5210, 194595, 194796);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5210, 194595, 194796);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5210, 194595, 194796);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5210, 194595, 194796);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5210, 194595, 194796);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5210, 194595, 194796);
            CallChecker.varInit(this.m_logger, "m_logger", 5210, 194595, 194796);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5210, 194595, 194796);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5210, 194595, 194796);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5210, 194595, 194796);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5210, 194595, 194796);
            synchronized(m_bundleLock) {
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5214, 194718, 194723)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5214, 194718, 194723);
                    CallChecker.isCalled(bundle, BundleImpl.class, 5214, 194718, 194723).__setState(state);
                }
                if (CallChecker.beforeDeref(m_bundleLock, Object[].class, 5215, 194756, 194767)) {
                    CallChecker.isCalled(m_bundleLock, Object[].class, 5215, 194756, 194767).notifyAll();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context700.methodEnd();
        }
    }

    void acquireBundleLock(BundleImpl bundle, int desiredStates) throws IllegalStateException {
        MethodContext _bcornu_methode_context701 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5228, 194803, 197514);
            CallChecker.varInit(desiredStates, "desiredStates", 5228, 194803, 197514);
            CallChecker.varInit(bundle, "bundle", 5228, 194803, 197514);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5228, 194803, 197514);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5228, 194803, 197514);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5228, 194803, 197514);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5228, 194803, 197514);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5228, 194803, 197514);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5228, 194803, 197514);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5228, 194803, 197514);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5228, 194803, 197514);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5228, 194803, 197514);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5228, 194803, 197514);
            CallChecker.varInit(this.m_registry, "m_registry", 5228, 194803, 197514);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5228, 194803, 197514);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5228, 194803, 197514);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5228, 194803, 197514);
            CallChecker.varInit(this.m_cache, "m_cache", 5228, 194803, 197514);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5228, 194803, 197514);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5228, 194803, 197514);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5228, 194803, 197514);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5228, 194803, 197514);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5228, 194803, 197514);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5228, 194803, 197514);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5228, 194803, 197514);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5228, 194803, 197514);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5228, 194803, 197514);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5228, 194803, 197514);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5228, 194803, 197514);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5228, 194803, 197514);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5228, 194803, 197514);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5228, 194803, 197514);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5228, 194803, 197514);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5228, 194803, 197514);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5228, 194803, 197514);
            CallChecker.varInit(this.m_logger, "m_logger", 5228, 194803, 197514);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5228, 194803, 197514);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5228, 194803, 197514);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5228, 194803, 197514);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5228, 194803, 197514);
            synchronized(m_bundleLock) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5236, 195670, 195675);
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5239, 195833, 195838);
                while ((!(CallChecker.isCalled(bundle, BundleImpl.class, 5236, 195670, 195675).isLockable())) || ((((m_globalLockThread) != null) && ((m_globalLockThread) != (Thread.currentThread()))) && ((CallChecker.isCalled(bundle, BundleImpl.class, 5239, 195833, 195838).getLockingThread()) != (Thread.currentThread())))) {
                    if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5243, 196079, 196084)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5243, 196079, 196084);
                        if ((desiredStates & (CallChecker.isCalled(bundle, BundleImpl.class, 5243, 196079, 196084).getState())) == 0) {
                            throw new IllegalStateException("Bundle in unexpected state.");
                        }else
                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5251, 196564, 196569)) {
                                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5252, 196655, 196660)) {
                                    if (CallChecker.beforeDeref(m_globalLockWaitersList, List.class, 5252, 196622, 196644)) {
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5251, 196564, 196569);
                                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5252, 196655, 196660);
                                        if ((((m_globalLockThread) == (Thread.currentThread())) && ((CallChecker.isCalled(bundle, BundleImpl.class, 5251, 196564, 196569).getLockingThread()) != null)) && (CallChecker.isCalled(m_globalLockWaitersList, List.class, 5252, 196622, 196644).contains(CallChecker.isCalled(bundle, BundleImpl.class, 5252, 196655, 196660).getLockingThread()))) {
                                            if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5254, 196721, 196726)) {
                                                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5254, 196721, 196726);
                                                CallChecker.isCalled(bundle, BundleImpl.class, 5254, 196721, 196726).getLockingThread().interrupt();
                                            }
                                        }
                                    }
                                }
                            }
                        
                    }
                    TryContext _bcornu_try_context_262 = new TryContext(262, Felix.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(m_bundleLock, Object[].class, 5259, 196837, 196848)) {
                            CallChecker.isCalled(m_bundleLock, Object[].class, 5259, 196837, 196848).wait();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_262.catchStart(262);
                        throw new IllegalStateException("Unable to acquire bundle lock, thread interrupted.");
                    } finally {
                        _bcornu_try_context_262.finallyStart(262);
                    }
                } 
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5270, 197299, 197304)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5270, 197299, 197304);
                    if ((desiredStates & (CallChecker.isCalled(bundle, BundleImpl.class, 5270, 197299, 197304).getState())) == 0) {
                        throw new IllegalStateException("Bundle in unexpected state.");
                    }
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5276, 197485, 197490)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5276, 197485, 197490);
                    CallChecker.isCalled(bundle, BundleImpl.class, 5276, 197485, 197490).lock();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context701.methodEnd();
        }
    }

    void releaseBundleLock(BundleImpl bundle) {
        MethodContext _bcornu_methode_context702 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5286, 197521, 198156);
            CallChecker.varInit(bundle, "bundle", 5286, 197521, 198156);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5286, 197521, 198156);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5286, 197521, 198156);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5286, 197521, 198156);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5286, 197521, 198156);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5286, 197521, 198156);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5286, 197521, 198156);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5286, 197521, 198156);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5286, 197521, 198156);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5286, 197521, 198156);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5286, 197521, 198156);
            CallChecker.varInit(this.m_registry, "m_registry", 5286, 197521, 198156);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5286, 197521, 198156);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5286, 197521, 198156);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5286, 197521, 198156);
            CallChecker.varInit(this.m_cache, "m_cache", 5286, 197521, 198156);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5286, 197521, 198156);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5286, 197521, 198156);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5286, 197521, 198156);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5286, 197521, 198156);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5286, 197521, 198156);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5286, 197521, 198156);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5286, 197521, 198156);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5286, 197521, 198156);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5286, 197521, 198156);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5286, 197521, 198156);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5286, 197521, 198156);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5286, 197521, 198156);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5286, 197521, 198156);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5286, 197521, 198156);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5286, 197521, 198156);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5286, 197521, 198156);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5286, 197521, 198156);
            CallChecker.varInit(this.m_logger, "m_logger", 5286, 197521, 198156);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5286, 197521, 198156);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5286, 197521, 198156);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5286, 197521, 198156);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5286, 197521, 198156);
            synchronized(m_bundleLock) {
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5291, 197888, 197893)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5291, 197888, 197893);
                    CallChecker.isCalled(bundle, BundleImpl.class, 5291, 197888, 197893).unlock();
                }
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 5294, 198037, 198042)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 5294, 198037, 198042);
                    if ((CallChecker.isCalled(bundle, BundleImpl.class, 5294, 198037, 198042).getLockingThread()) == null) {
                        if (CallChecker.beforeDeref(m_bundleLock, Object[].class, 5296, 198102, 198113)) {
                            CallChecker.isCalled(m_bundleLock, Object[].class, 5296, 198102, 198113).notifyAll();
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context702.methodEnd();
        }
    }

    boolean acquireGlobalLock() {
        MethodContext _bcornu_methode_context703 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 5311, 198163, 200857);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5311, 198163, 200857);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5311, 198163, 200857);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5311, 198163, 200857);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5311, 198163, 200857);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5311, 198163, 200857);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5311, 198163, 200857);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5311, 198163, 200857);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5311, 198163, 200857);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5311, 198163, 200857);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5311, 198163, 200857);
            CallChecker.varInit(this.m_registry, "m_registry", 5311, 198163, 200857);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5311, 198163, 200857);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5311, 198163, 200857);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5311, 198163, 200857);
            CallChecker.varInit(this.m_cache, "m_cache", 5311, 198163, 200857);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5311, 198163, 200857);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5311, 198163, 200857);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5311, 198163, 200857);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5311, 198163, 200857);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5311, 198163, 200857);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5311, 198163, 200857);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5311, 198163, 200857);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5311, 198163, 200857);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5311, 198163, 200857);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5311, 198163, 200857);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5311, 198163, 200857);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5311, 198163, 200857);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5311, 198163, 200857);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5311, 198163, 200857);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5311, 198163, 200857);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5311, 198163, 200857);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5311, 198163, 200857);
            CallChecker.varInit(this.m_logger, "m_logger", 5311, 198163, 200857);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5311, 198163, 200857);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5311, 198163, 200857);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5311, 198163, 200857);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5311, 198163, 200857);
            synchronized(m_bundleLock) {
                boolean interrupted = CallChecker.varInit(((boolean) (false)), "interrupted", 5317, 198962, 198989);
                while (((!interrupted) && ((m_globalLockThread) != null)) && ((m_globalLockThread) != (Thread.currentThread()))) {
                    if (CallChecker.beforeDeref(m_globalLockWaitersList, List.class, 5323, 199235, 199257)) {
                        CallChecker.isCalled(m_globalLockWaitersList, List.class, 5323, 199235, 199257).add(Thread.currentThread());
                    }
                    if (CallChecker.beforeDeref(m_bundleLock, Object[].class, 5328, 199574, 199585)) {
                        CallChecker.isCalled(m_bundleLock, Object[].class, 5328, 199574, 199585).notifyAll();
                    }
                    TryContext _bcornu_try_context_263 = new TryContext(263, Felix.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(m_bundleLock, Object[].class, 5332, 199707, 199718)) {
                            CallChecker.isCalled(m_bundleLock, Object[].class, 5332, 199707, 199718).wait();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_263.catchStart(263);
                        interrupted = true;
                        CallChecker.varAssign(interrupted, "interrupted", 5336, 199832, 199850);
                    } finally {
                        _bcornu_try_context_263.finallyStart(263);
                    }
                    if (CallChecker.beforeDeref(m_globalLockWaitersList, List.class, 5340, 200037, 200059)) {
                        CallChecker.isCalled(m_globalLockWaitersList, List.class, 5340, 200037, 200059).remove(Thread.currentThread());
                    }
                } 
                if (!interrupted) {
                    (m_globalLockCount)++;
                    m_globalLockThread = Thread.currentThread();
                    CallChecker.varAssign(this.m_globalLockThread, "this.m_globalLockThread", 5350, 200450, 200493);
                }
                return !interrupted;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context703.methodEnd();
        }
    }

    void releaseGlobalLock() {
        MethodContext _bcornu_methode_context704 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5367, 200864, 201649);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5367, 200864, 201649);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5367, 200864, 201649);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5367, 200864, 201649);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5367, 200864, 201649);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5367, 200864, 201649);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5367, 200864, 201649);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5367, 200864, 201649);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5367, 200864, 201649);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5367, 200864, 201649);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5367, 200864, 201649);
            CallChecker.varInit(this.m_registry, "m_registry", 5367, 200864, 201649);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5367, 200864, 201649);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5367, 200864, 201649);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5367, 200864, 201649);
            CallChecker.varInit(this.m_cache, "m_cache", 5367, 200864, 201649);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5367, 200864, 201649);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5367, 200864, 201649);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5367, 200864, 201649);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5367, 200864, 201649);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5367, 200864, 201649);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5367, 200864, 201649);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5367, 200864, 201649);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5367, 200864, 201649);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5367, 200864, 201649);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5367, 200864, 201649);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5367, 200864, 201649);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5367, 200864, 201649);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5367, 200864, 201649);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5367, 200864, 201649);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5367, 200864, 201649);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5367, 200864, 201649);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5367, 200864, 201649);
            CallChecker.varInit(this.m_logger, "m_logger", 5367, 200864, 201649);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5367, 200864, 201649);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5367, 200864, 201649);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5367, 200864, 201649);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5367, 200864, 201649);
            synchronized(m_bundleLock) {
                if ((m_globalLockThread) == (Thread.currentThread())) {
                    (m_globalLockCount)--;
                    if ((m_globalLockCount) == 0) {
                        m_globalLockThread = null;
                        CallChecker.varAssign(this.m_globalLockThread, "this.m_globalLockThread", 5377, 201364, 201389);
                        if (CallChecker.beforeDeref(m_bundleLock, Object[].class, 5378, 201411, 201422)) {
                            CallChecker.isCalled(m_bundleLock, Object[].class, 5378, 201411, 201422).notifyAll();
                        }
                    }
                }else {
                    throw new IllegalStateException("The current thread doesn't own the global lock.");
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context704.methodEnd();
        }
    }

    private volatile URLHandlersActivator m_urlHandlersActivator;

    void setURLHandlersActivator(URLHandlersActivator urlHandlersActivator) {
        MethodContext _bcornu_methode_context705 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 5391, 201723, 201860);
            CallChecker.varInit(urlHandlersActivator, "urlHandlersActivator", 5391, 201723, 201860);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5391, 201723, 201860);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5391, 201723, 201860);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5391, 201723, 201860);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5391, 201723, 201860);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5391, 201723, 201860);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5391, 201723, 201860);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5391, 201723, 201860);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5391, 201723, 201860);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5391, 201723, 201860);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5391, 201723, 201860);
            CallChecker.varInit(this.m_registry, "m_registry", 5391, 201723, 201860);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5391, 201723, 201860);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5391, 201723, 201860);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5391, 201723, 201860);
            CallChecker.varInit(this.m_cache, "m_cache", 5391, 201723, 201860);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5391, 201723, 201860);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5391, 201723, 201860);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5391, 201723, 201860);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5391, 201723, 201860);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5391, 201723, 201860);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5391, 201723, 201860);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5391, 201723, 201860);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5391, 201723, 201860);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5391, 201723, 201860);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5391, 201723, 201860);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5391, 201723, 201860);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5391, 201723, 201860);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5391, 201723, 201860);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5391, 201723, 201860);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5391, 201723, 201860);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5391, 201723, 201860);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5391, 201723, 201860);
            CallChecker.varInit(this.m_logger, "m_logger", 5391, 201723, 201860);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5391, 201723, 201860);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5391, 201723, 201860);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5391, 201723, 201860);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5391, 201723, 201860);
            m_urlHandlersActivator = urlHandlersActivator;
            CallChecker.varAssign(this.m_urlHandlersActivator, "this.m_urlHandlersActivator", 5393, 201809, 201854);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context705.methodEnd();
        }
    }

    Object getStreamHandlerService(String protocol) {
        MethodContext _bcornu_methode_context706 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 5396, 201867, 201998);
            CallChecker.varInit(protocol, "protocol", 5396, 201867, 201998);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5396, 201867, 201998);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5396, 201867, 201998);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5396, 201867, 201998);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5396, 201867, 201998);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5396, 201867, 201998);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5396, 201867, 201998);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5396, 201867, 201998);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5396, 201867, 201998);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5396, 201867, 201998);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5396, 201867, 201998);
            CallChecker.varInit(this.m_registry, "m_registry", 5396, 201867, 201998);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5396, 201867, 201998);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5396, 201867, 201998);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5396, 201867, 201998);
            CallChecker.varInit(this.m_cache, "m_cache", 5396, 201867, 201998);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5396, 201867, 201998);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5396, 201867, 201998);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5396, 201867, 201998);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5396, 201867, 201998);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5396, 201867, 201998);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5396, 201867, 201998);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5396, 201867, 201998);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5396, 201867, 201998);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5396, 201867, 201998);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5396, 201867, 201998);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5396, 201867, 201998);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5396, 201867, 201998);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5396, 201867, 201998);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5396, 201867, 201998);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5396, 201867, 201998);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5396, 201867, 201998);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5396, 201867, 201998);
            CallChecker.varInit(this.m_logger, "m_logger", 5396, 201867, 201998);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5396, 201867, 201998);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5396, 201867, 201998);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5396, 201867, 201998);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5396, 201867, 201998);
            if (CallChecker.beforeDeref(m_urlHandlersActivator, URLHandlersActivator.class, 5398, 201936, 201957)) {
                m_urlHandlersActivator = CallChecker.beforeCalled(m_urlHandlersActivator, URLHandlersActivator.class, 5398, 201936, 201957);
                return CallChecker.isCalled(m_urlHandlersActivator, URLHandlersActivator.class, 5398, 201936, 201957).getStreamHandlerService(protocol);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context706.methodEnd();
        }
    }

    Object getContentHandlerService(String mimeType) {
        MethodContext _bcornu_methode_context707 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 5401, 202005, 202138);
            CallChecker.varInit(mimeType, "mimeType", 5401, 202005, 202138);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5401, 202005, 202138);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5401, 202005, 202138);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5401, 202005, 202138);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5401, 202005, 202138);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5401, 202005, 202138);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5401, 202005, 202138);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5401, 202005, 202138);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5401, 202005, 202138);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5401, 202005, 202138);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5401, 202005, 202138);
            CallChecker.varInit(this.m_registry, "m_registry", 5401, 202005, 202138);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5401, 202005, 202138);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5401, 202005, 202138);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5401, 202005, 202138);
            CallChecker.varInit(this.m_cache, "m_cache", 5401, 202005, 202138);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5401, 202005, 202138);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5401, 202005, 202138);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5401, 202005, 202138);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5401, 202005, 202138);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5401, 202005, 202138);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5401, 202005, 202138);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5401, 202005, 202138);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5401, 202005, 202138);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5401, 202005, 202138);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5401, 202005, 202138);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5401, 202005, 202138);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5401, 202005, 202138);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5401, 202005, 202138);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5401, 202005, 202138);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5401, 202005, 202138);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5401, 202005, 202138);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5401, 202005, 202138);
            CallChecker.varInit(this.m_logger, "m_logger", 5401, 202005, 202138);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5401, 202005, 202138);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5401, 202005, 202138);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5401, 202005, 202138);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5401, 202005, 202138);
            if (CallChecker.beforeDeref(m_urlHandlersActivator, URLHandlersActivator.class, 5403, 202075, 202096)) {
                m_urlHandlersActivator = CallChecker.beforeCalled(m_urlHandlersActivator, URLHandlersActivator.class, 5403, 202075, 202096);
                return CallChecker.isCalled(m_urlHandlersActivator, URLHandlersActivator.class, 5403, 202075, 202096).getContentHandlerService(mimeType);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context707.methodEnd();
        }
    }

    Collection<BundleCapability> findProviders(final Requirement requirement) {
        MethodContext _bcornu_methode_context708 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 5406, 202145, 202310);
            CallChecker.varInit(requirement, "requirement", 5406, 202145, 202310);
            CallChecker.varInit(this.m_urlHandlersActivator, "m_urlHandlersActivator", 5406, 202145, 202310);
            CallChecker.varInit(this.m_securityProvider, "m_securityProvider", 5406, 202145, 202310);
            CallChecker.varInit(this.m_systemBundleClassCache, "m_systemBundleClassCache", 5406, 202145, 202310);
            CallChecker.varInit(this.m_securityDefaultPolicy, "m_securityDefaultPolicy", 5406, 202145, 202310);
            CallChecker.varInit(this.m_securityManager, "m_securityManager", 5406, 202145, 202310);
            CallChecker.varInit(this.m_shutdownGate, "m_shutdownGate", 5406, 202145, 202310);
            CallChecker.varInit(this.m_bootPkgWildcards, "m_bootPkgWildcards", 5406, 202145, 202310);
            CallChecker.varInit(this.m_bootPkgs, "m_bootPkgs", 5406, 202145, 202310);
            CallChecker.varInit(this.m_bundleStreamHandler, "m_bundleStreamHandler", 5406, 202145, 202310);
            CallChecker.varInit(this.m_dispatcher, "m_dispatcher", 5406, 202145, 202310);
            CallChecker.varInit(this.m_registry, "m_registry", 5406, 202145, 202310);
            CallChecker.varInit(this.m_nextIdLock, "m_nextIdLock", 5406, 202145, 202310);
            CallChecker.varInit(this.m_nextId, "m_nextId", 5406, 202145, 202310);
            CallChecker.varInit(this.m_activatorList, "m_activatorList", 5406, 202145, 202310);
            CallChecker.varInit(this.m_cache, "m_cache", 5406, 202145, 202310);
            CallChecker.varInit(this.m_startLevelBundles, "m_startLevelBundles", 5406, 202145, 202310);
            CallChecker.varInit(this.m_targetStartLevel, "m_targetStartLevel", 5406, 202145, 202310);
            CallChecker.varInit(this.m_activeStartLevel, "m_activeStartLevel", 5406, 202145, 202310);
            CallChecker.varInit(this.m_dependencies, "m_dependencies", 5406, 202145, 202310);
            CallChecker.varInit(this.m_uninstalledBundles, "m_uninstalledBundles", 5406, 202145, 202310);
            CallChecker.varInit(IDENTIFIER_MAP_IDX, "org.apache.felix.framework.Felix.IDENTIFIER_MAP_IDX", 5406, 202145, 202310);
            CallChecker.varInit(LOCATION_MAP_IDX, "org.apache.felix.framework.Felix.LOCATION_MAP_IDX", 5406, 202145, 202310);
            CallChecker.varInit(this.m_installedBundles, "m_installedBundles", 5406, 202145, 202310);
            CallChecker.varInit(this.m_installRequestLock_Priority1, "m_installRequestLock_Priority1", 5406, 202145, 202310);
            CallChecker.varInit(this.m_installRequestMap, "m_installRequestMap", 5406, 202145, 202310);
            CallChecker.varInit(this.m_globalLockCount, "m_globalLockCount", 5406, 202145, 202310);
            CallChecker.varInit(this.m_globalLockThread, "m_globalLockThread", 5406, 202145, 202310);
            CallChecker.varInit(this.m_globalLockWaitersList, "m_globalLockWaitersList", 5406, 202145, 202310);
            CallChecker.varInit(this.m_bundleLock, "m_bundleLock", 5406, 202145, 202310);
            CallChecker.varInit(this.m_resolver, "m_resolver", 5406, 202145, 202310);
            CallChecker.varInit(this.m_configMutableMap, "m_configMutableMap", 5406, 202145, 202310);
            CallChecker.varInit(this.m_configMap, "m_configMap", 5406, 202145, 202310);
            CallChecker.varInit(this.m_logger, "m_logger", 5406, 202145, 202310);
            CallChecker.varInit(this.m_fwkStartLevel, "m_fwkStartLevel", 5406, 202145, 202310);
            CallChecker.varInit(this.m_fwkWiring, "m_fwkWiring", 5406, 202145, 202310);
            CallChecker.varInit(this.m_extensionManager, "m_extensionManager", 5406, 202145, 202310);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.Felix.m_secureAction", 5406, 202145, 202310);
            if (CallChecker.beforeDeref(m_resolver, StatefulResolver.class, 5408, 202240, 202249)) {
                return CallChecker.isCalled(m_resolver, StatefulResolver.class, 5408, 202240, 202249).findProvidersInternal(null, requirement, true, false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context708.methodEnd();
        }
    }
}

