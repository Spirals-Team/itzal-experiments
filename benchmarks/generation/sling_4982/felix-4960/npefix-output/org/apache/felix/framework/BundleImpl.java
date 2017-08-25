package org.apache.felix.framework;

import org.osgi.framework.Version;
import org.apache.felix.framework.util.Util;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.StringTokenizer;
import org.apache.felix.framework.util.StringMap;
import org.apache.felix.framework.util.ShrinkableCollection;
import java.util.Enumeration;
import java.util.Dictionary;
import org.osgi.framework.Constants;
import org.osgi.framework.hooks.bundle.CollisionHook;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleRevisions;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.AdaptPermission;
import org.osgi.framework.AdminPermission;
import java.util.ArrayList;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.apache.felix.framework.cache.BundleArchive;
import org.apache.felix.framework.cache.BundleArchiveRevision;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.BundleRevision;
import java.io.File;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Properties;
import java.security.ProtectionDomain;
import org.apache.felix.framework.util.SecureAction;
import org.apache.felix.framework.util.SecurityManagerEx;
import org.osgi.framework.ServicePermission;
import org.osgi.framework.ServiceReference;
import java.util.Set;

class BundleImpl implements Bundle , BundleRevisions {
    private final Felix __m_felix;

    private final BundleArchive m_archive;

    private final List<BundleRevision> m_revisions = new ArrayList<BundleRevision>(0);

    private volatile int m_state;

    private boolean m_useDeclaredActivationPolicy;

    private BundleActivator m_activator = null;

    private volatile BundleContext m_context = null;

    private final Map m_cachedHeaders = new HashMap();

    private Map m_uninstalledHeaders = null;

    private long m_cachedHeadersTimestamp;

    private final Bundle m_installingBundle;

    private boolean m_stale = false;

    private int m_lockCount = 0;

    private Thread m_lockThread = null;

    BundleImpl() {
        MethodContext _bcornu_methode_context132 = new MethodContext(null);
        try {
            __m_felix = null;
            CallChecker.varAssign(this.__m_felix, "this.__m_felix", 92, 3489, 3505);
            m_archive = null;
            CallChecker.varAssign(this.m_archive, "this.m_archive", 93, 3515, 3531);
            m_state = Bundle.INSTALLED;
            CallChecker.varAssign(this.m_state, "this.m_state", 94, 3541, 3567);
            m_useDeclaredActivationPolicy = false;
            CallChecker.varAssign(this.m_useDeclaredActivationPolicy, "this.m_useDeclaredActivationPolicy", 95, 3577, 3614);
            m_stale = false;
            CallChecker.varAssign(this.m_stale, "this.m_stale", 96, 3624, 3639);
            m_activator = null;
            CallChecker.varAssign(this.m_activator, "this.m_activator", 97, 3649, 3667);
            m_context = null;
            CallChecker.varAssign(this.m_context, "this.m_context", 98, 3677, 3693);
            m_installingBundle = null;
            CallChecker.varAssign(this.m_installingBundle, "this.m_installingBundle", 99, 3703, 3728);
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    BundleImpl(Felix felix, Bundle installingBundle, BundleArchive archive) throws Exception {
        MethodContext _bcornu_methode_context133 = new MethodContext(null);
        try {
            __m_felix = felix;
            CallChecker.varAssign(this.__m_felix, "this.__m_felix", 104, 3844, 3861);
            m_archive = archive;
            CallChecker.varAssign(this.m_archive, "this.m_archive", 105, 3871, 3890);
            m_state = Bundle.INSTALLED;
            CallChecker.varAssign(this.m_state, "this.m_state", 106, 3900, 3926);
            m_useDeclaredActivationPolicy = false;
            CallChecker.varAssign(this.m_useDeclaredActivationPolicy, "this.m_useDeclaredActivationPolicy", 107, 3936, 3973);
            m_stale = false;
            CallChecker.varAssign(this.m_stale, "this.m_stale", 108, 3983, 3998);
            m_activator = null;
            CallChecker.varAssign(this.m_activator, "this.m_activator", 109, 4008, 4026);
            m_context = null;
            CallChecker.varAssign(this.m_context, "this.m_context", 110, 4036, 4052);
            m_installingBundle = installingBundle;
            CallChecker.varAssign(this.m_installingBundle, "this.m_installingBundle", 111, 4062, 4099);
            BundleRevision revision = CallChecker.varInit(createRevision(false), "revision", 113, 4110, 4157);
            addRevision(revision);
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    Felix getFramework() {
        MethodContext _bcornu_methode_context1300 = new MethodContext(Felix.class);
        try {
            CallChecker.varInit(this, "this", 121, 4201, 4518);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 121, 4201, 4518);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 121, 4201, 4518);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 121, 4201, 4518);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 121, 4201, 4518);
            CallChecker.varInit(this.m_stale, "m_stale", 121, 4201, 4518);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 121, 4201, 4518);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 121, 4201, 4518);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 121, 4201, 4518);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 121, 4201, 4518);
            CallChecker.varInit(this.m_context, "m_context", 121, 4201, 4518);
            CallChecker.varInit(this.m_activator, "m_activator", 121, 4201, 4518);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 121, 4201, 4518);
            CallChecker.varInit(this.m_state, "m_state", 121, 4201, 4518);
            CallChecker.varInit(this.m_revisions, "m_revisions", 121, 4201, 4518);
            CallChecker.varInit(this.m_archive, "m_archive", 121, 4201, 4518);
            CallChecker.varInit(this.__m_felix, "__m_felix", 121, 4201, 4518);
            return __m_felix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Felix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1300.methodEnd();
        }
    }

    BundleArchive getArchive() {
        MethodContext _bcornu_methode_context1301 = new MethodContext(BundleArchive.class);
        try {
            CallChecker.varInit(this, "this", 126, 4525, 4588);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 126, 4525, 4588);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 126, 4525, 4588);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 126, 4525, 4588);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 126, 4525, 4588);
            CallChecker.varInit(this.m_stale, "m_stale", 126, 4525, 4588);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 126, 4525, 4588);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 126, 4525, 4588);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 126, 4525, 4588);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 126, 4525, 4588);
            CallChecker.varInit(this.m_context, "m_context", 126, 4525, 4588);
            CallChecker.varInit(this.m_activator, "m_activator", 126, 4525, 4588);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 126, 4525, 4588);
            CallChecker.varInit(this.m_state, "m_state", 126, 4525, 4588);
            CallChecker.varInit(this.m_revisions, "m_revisions", 126, 4525, 4588);
            CallChecker.varInit(this.m_archive, "m_archive", 126, 4525, 4588);
            CallChecker.varInit(this.__m_felix, "__m_felix", 126, 4525, 4588);
            return m_archive;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleArchive) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1301.methodEnd();
        }
    }

    synchronized void close() {
        MethodContext _bcornu_methode_context1302 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 132, 4591, 5012);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 132, 4591, 5012);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 132, 4591, 5012);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 132, 4591, 5012);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 132, 4591, 5012);
            CallChecker.varInit(this.m_stale, "m_stale", 132, 4591, 5012);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 132, 4591, 5012);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 132, 4591, 5012);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 132, 4591, 5012);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 132, 4591, 5012);
            CallChecker.varInit(this.m_context, "m_context", 132, 4591, 5012);
            CallChecker.varInit(this.m_activator, "m_activator", 132, 4591, 5012);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 132, 4591, 5012);
            CallChecker.varInit(this.m_state, "m_state", 132, 4591, 5012);
            CallChecker.varInit(this.m_revisions, "m_revisions", 132, 4591, 5012);
            CallChecker.varInit(this.m_archive, "m_archive", 132, 4591, 5012);
            CallChecker.varInit(this.__m_felix, "__m_felix", 132, 4591, 5012);
            closeRevisions();
            TryContext _bcornu_try_context_357 = new TryContext(357, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 137, 4771, 4779)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 137, 4771, 4779).close();
                }
            } catch (Exception ex) {
                _bcornu_try_context_357.catchStart(357);
                final Felix npe_invocation_var448 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var448, Felix.class, 141, 4851, 4864)) {
                    final Logger npe_invocation_var449 = CallChecker.isCalled(npe_invocation_var448, Felix.class, 141, 4851, 4864).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var449, Logger.class, 141, 4851, 4876)) {
                        CallChecker.isCalled(npe_invocation_var449, Logger.class, 141, 4851, 4876).log(this, Logger.LOG_ERROR, "Unable to close archive revisions.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_357.finallyStart(357);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1302.methodEnd();
        }
    }

    synchronized void closeAndDelete() throws Exception {
        MethodContext _bcornu_methode_context1303 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 151, 5015, 5570);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 151, 5015, 5570);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 151, 5015, 5570);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 151, 5015, 5570);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 151, 5015, 5570);
            CallChecker.varInit(this.m_stale, "m_stale", 151, 5015, 5570);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 151, 5015, 5570);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 151, 5015, 5570);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 151, 5015, 5570);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 151, 5015, 5570);
            CallChecker.varInit(this.m_context, "m_context", 151, 5015, 5570);
            CallChecker.varInit(this.m_activator, "m_activator", 151, 5015, 5570);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 151, 5015, 5570);
            CallChecker.varInit(this.m_state, "m_state", 151, 5015, 5570);
            CallChecker.varInit(this.m_revisions, "m_revisions", 151, 5015, 5570);
            CallChecker.varInit(this.m_archive, "m_archive", 151, 5015, 5570);
            CallChecker.varInit(this.__m_felix, "__m_felix", 151, 5015, 5570);
            if (!(m_stale)) {
                m_stale = true;
                CallChecker.varAssign(this.m_stale, "this.m_stale", 156, 5368, 5382);
                closeRevisions();
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 160, 5528, 5536)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 160, 5528, 5536).closeAndDelete();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1303.methodEnd();
        }
    }

    private void closeRevisions() {
        MethodContext _bcornu_methode_context1304 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 165, 5573, 6089);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 165, 5573, 6089);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 165, 5573, 6089);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 165, 5573, 6089);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 165, 5573, 6089);
            CallChecker.varInit(this.m_stale, "m_stale", 165, 5573, 6089);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 165, 5573, 6089);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 165, 5573, 6089);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 165, 5573, 6089);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 165, 5573, 6089);
            CallChecker.varInit(this.m_context, "m_context", 165, 5573, 6089);
            CallChecker.varInit(this.m_activator, "m_activator", 165, 5573, 6089);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 165, 5573, 6089);
            CallChecker.varInit(this.m_state, "m_state", 165, 5573, 6089);
            CallChecker.varInit(this.m_revisions, "m_revisions", 165, 5573, 6089);
            CallChecker.varInit(this.m_archive, "m_archive", 165, 5573, 6089);
            CallChecker.varInit(this.__m_felix, "__m_felix", 165, 5573, 6089);
            if (CallChecker.beforeDeref(m_revisions, void.class, 169, 5838, 5848)) {
                for (BundleRevision br : m_revisions) {
                    final Felix npe_invocation_var450 = getFramework();
                    if (CallChecker.beforeDeref(npe_invocation_var450, Felix.class, 172, 5933, 5946)) {
                        final StatefulResolver npe_invocation_var451 = CallChecker.isCalled(npe_invocation_var450, Felix.class, 172, 5933, 5946).getResolver();
                        if (CallChecker.beforeDeref(npe_invocation_var451, StatefulResolver.class, 172, 5933, 5960)) {
                            CallChecker.isCalled(npe_invocation_var451, StatefulResolver.class, 172, 5933, 5960).removeRevision(br);
                        }
                    }
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 175, 6062, 6063)) {
                        CallChecker.isCalled(((BundleRevisionImpl) (br)), BundleRevisionImpl.class, 175, 6062, 6063).close();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1304.methodEnd();
        }
    }

    synchronized void refresh() throws Exception {
        MethodContext _bcornu_methode_context1305 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 180, 6092, 7392);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 180, 6092, 7392);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 180, 6092, 7392);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 180, 6092, 7392);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 180, 6092, 7392);
            CallChecker.varInit(this.m_stale, "m_stale", 180, 6092, 7392);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 180, 6092, 7392);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 180, 6092, 7392);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 180, 6092, 7392);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 180, 6092, 7392);
            CallChecker.varInit(this.m_context, "m_context", 180, 6092, 7392);
            CallChecker.varInit(this.m_activator, "m_activator", 180, 6092, 7392);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 180, 6092, 7392);
            CallChecker.varInit(this.m_state, "m_state", 180, 6092, 7392);
            CallChecker.varInit(this.m_revisions, "m_revisions", 180, 6092, 7392);
            CallChecker.varInit(this.m_archive, "m_archive", 180, 6092, 7392);
            CallChecker.varInit(this.__m_felix, "__m_felix", 180, 6092, 7392);
            final Felix npe_invocation_var452 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var452, Felix.class, 182, 6252, 6265)) {
                if ((isExtension()) && ((CallChecker.isCalled(npe_invocation_var452, Felix.class, 182, 6252, 6265).getState()) != (Bundle.STOPPING))) {
                    final Felix npe_invocation_var453 = getFramework();
                    if (CallChecker.beforeDeref(npe_invocation_var453, Felix.class, 184, 6321, 6334)) {
                        final Logger npe_invocation_var454 = CallChecker.isCalled(npe_invocation_var453, Felix.class, 184, 6321, 6334).getLogger();
                        if (CallChecker.beforeDeref(npe_invocation_var454, Logger.class, 184, 6321, 6346)) {
                            CallChecker.isCalled(npe_invocation_var454, Logger.class, 184, 6321, 6346).log(this, Logger.LOG_WARNING, "Framework restart on extension bundle refresh not implemented.");
                        }
                    }
                }else {
                    BundleRevisionImpl current = CallChecker.varInit(adapt(BundleRevisionImpl.class), "current", 190, 6566, 6626);
                    closeRevisions();
                    if (CallChecker.beforeDeref(m_revisions, List.class, 194, 6751, 6761)) {
                        CallChecker.isCalled(m_revisions, List.class, 194, 6751, 6761).clear();
                    }
                    if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 197, 6862, 6870)) {
                        CallChecker.isCalled(m_archive, BundleArchive.class, 197, 6862, 6870).purge();
                    }
                    if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 200, 6980, 6988)) {
                        final BundleArchiveRevision npe_invocation_var455 = CallChecker.isCalled(m_archive, BundleArchive.class, 200, 6980, 6988).getCurrentRevision();
                        if (CallChecker.beforeDeref(npe_invocation_var455, BundleArchiveRevision.class, 200, 6980, 7009)) {
                            if (CallChecker.beforeDeref(current, BundleRevisionImpl.class, 200, 6959, 6965)) {
                                current = CallChecker.beforeCalled(current, BundleRevisionImpl.class, 200, 6959, 6965);
                                CallChecker.isCalled(current, BundleRevisionImpl.class, 200, 6959, 6965).resetContent(CallChecker.isCalled(npe_invocation_var455, BundleArchiveRevision.class, 200, 6980, 7009).getContent());
                            }
                        }
                    }
                    addRevision(current);
                    m_state = Bundle.INSTALLED;
                    CallChecker.varAssign(this.m_state, "this.m_state", 205, 7162, 7188);
                    m_stale = false;
                    CallChecker.varAssign(this.m_stale, "this.m_stale", 206, 7202, 7217);
                    synchronized(m_cachedHeaders) {
                        if (CallChecker.beforeDeref(m_cachedHeaders, Map.class, 210, 7293, 7307)) {
                            CallChecker.isCalled(m_cachedHeaders, Map.class, 210, 7293, 7307).clear();
                        }
                        m_cachedHeadersTimestamp = 0;
                        CallChecker.varAssign(this.m_cachedHeadersTimestamp, "this.m_cachedHeadersTimestamp", 211, 7334, 7362);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1305.methodEnd();
        }
    }

    synchronized boolean isDeclaredActivationPolicyUsed() {
        MethodContext _bcornu_methode_context1306 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 216, 7399, 7509);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 216, 7399, 7509);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 216, 7399, 7509);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 216, 7399, 7509);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 216, 7399, 7509);
            CallChecker.varInit(this.m_stale, "m_stale", 216, 7399, 7509);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 216, 7399, 7509);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 216, 7399, 7509);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 216, 7399, 7509);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 216, 7399, 7509);
            CallChecker.varInit(this.m_context, "m_context", 216, 7399, 7509);
            CallChecker.varInit(this.m_activator, "m_activator", 216, 7399, 7509);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 216, 7399, 7509);
            CallChecker.varInit(this.m_state, "m_state", 216, 7399, 7509);
            CallChecker.varInit(this.m_revisions, "m_revisions", 216, 7399, 7509);
            CallChecker.varInit(this.m_archive, "m_archive", 216, 7399, 7509);
            CallChecker.varInit(this.__m_felix, "__m_felix", 216, 7399, 7509);
            return m_useDeclaredActivationPolicy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1306.methodEnd();
        }
    }

    synchronized void setDeclaredActivationPolicyUsed(boolean b) {
        MethodContext _bcornu_methode_context1307 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 221, 7516, 7630);
            CallChecker.varInit(b, "b", 221, 7516, 7630);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 221, 7516, 7630);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 221, 7516, 7630);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 221, 7516, 7630);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 221, 7516, 7630);
            CallChecker.varInit(this.m_stale, "m_stale", 221, 7516, 7630);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 221, 7516, 7630);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 221, 7516, 7630);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 221, 7516, 7630);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 221, 7516, 7630);
            CallChecker.varInit(this.m_context, "m_context", 221, 7516, 7630);
            CallChecker.varInit(this.m_activator, "m_activator", 221, 7516, 7630);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 221, 7516, 7630);
            CallChecker.varInit(this.m_state, "m_state", 221, 7516, 7630);
            CallChecker.varInit(this.m_revisions, "m_revisions", 221, 7516, 7630);
            CallChecker.varInit(this.m_archive, "m_archive", 221, 7516, 7630);
            CallChecker.varInit(this.__m_felix, "__m_felix", 221, 7516, 7630);
            m_useDeclaredActivationPolicy = b;
            CallChecker.varAssign(this.m_useDeclaredActivationPolicy, "this.m_useDeclaredActivationPolicy", 223, 7591, 7624);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1307.methodEnd();
        }
    }

    synchronized BundleActivator getActivator() {
        MethodContext _bcornu_methode_context1308 = new MethodContext(BundleActivator.class);
        try {
            CallChecker.varInit(this, "this", 226, 7637, 7719);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 226, 7637, 7719);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 226, 7637, 7719);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 226, 7637, 7719);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 226, 7637, 7719);
            CallChecker.varInit(this.m_stale, "m_stale", 226, 7637, 7719);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 226, 7637, 7719);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 226, 7637, 7719);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 226, 7637, 7719);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 226, 7637, 7719);
            CallChecker.varInit(this.m_context, "m_context", 226, 7637, 7719);
            CallChecker.varInit(this.m_activator, "m_activator", 226, 7637, 7719);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 226, 7637, 7719);
            CallChecker.varInit(this.m_state, "m_state", 226, 7637, 7719);
            CallChecker.varInit(this.m_revisions, "m_revisions", 226, 7637, 7719);
            CallChecker.varInit(this.m_archive, "m_archive", 226, 7637, 7719);
            CallChecker.varInit(this.__m_felix, "__m_felix", 226, 7637, 7719);
            return m_activator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleActivator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1308.methodEnd();
        }
    }

    synchronized void setActivator(BundleActivator activator) {
        MethodContext _bcornu_methode_context1309 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 231, 7726, 7827);
            CallChecker.varInit(activator, "activator", 231, 7726, 7827);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 231, 7726, 7827);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 231, 7726, 7827);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 231, 7726, 7827);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 231, 7726, 7827);
            CallChecker.varInit(this.m_stale, "m_stale", 231, 7726, 7827);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 231, 7726, 7827);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 231, 7726, 7827);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 231, 7726, 7827);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 231, 7726, 7827);
            CallChecker.varInit(this.m_context, "m_context", 231, 7726, 7827);
            CallChecker.varInit(this.m_activator, "m_activator", 231, 7726, 7827);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 231, 7726, 7827);
            CallChecker.varInit(this.m_state, "m_state", 231, 7726, 7827);
            CallChecker.varInit(this.m_revisions, "m_revisions", 231, 7726, 7827);
            CallChecker.varInit(this.m_archive, "m_archive", 231, 7726, 7827);
            CallChecker.varInit(this.__m_felix, "__m_felix", 231, 7726, 7827);
            m_activator = activator;
            CallChecker.varAssign(this.m_activator, "this.m_activator", 233, 7798, 7821);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1309.methodEnd();
        }
    }

    public BundleContext getBundleContext() {
        MethodContext _bcornu_methode_context1310 = new MethodContext(BundleContext.class);
        try {
            CallChecker.varInit(this, "this", 236, 7834, 8124);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 236, 7834, 8124);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 236, 7834, 8124);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 236, 7834, 8124);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 236, 7834, 8124);
            CallChecker.varInit(this.m_stale, "m_stale", 236, 7834, 8124);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 236, 7834, 8124);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 236, 7834, 8124);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 236, 7834, 8124);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 236, 7834, 8124);
            CallChecker.varInit(this.m_context, "m_context", 236, 7834, 8124);
            CallChecker.varInit(this.m_activator, "m_activator", 236, 7834, 8124);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 236, 7834, 8124);
            CallChecker.varInit(this.m_state, "m_state", 236, 7834, 8124);
            CallChecker.varInit(this.m_revisions, "m_revisions", 236, 7834, 8124);
            CallChecker.varInit(this.m_archive, "m_archive", 236, 7834, 8124);
            CallChecker.varInit(this.__m_felix, "__m_felix", 236, 7834, 8124);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 238, 7888, 7927);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.CONTEXT));
            }
            return m_context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1310.methodEnd();
        }
    }

    void setBundleContext(BundleContext context) {
        MethodContext _bcornu_methode_context1311 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 249, 8131, 8215);
            CallChecker.varInit(context, "context", 249, 8131, 8215);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 249, 8131, 8215);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 249, 8131, 8215);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 249, 8131, 8215);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 249, 8131, 8215);
            CallChecker.varInit(this.m_stale, "m_stale", 249, 8131, 8215);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 249, 8131, 8215);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 249, 8131, 8215);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 249, 8131, 8215);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 249, 8131, 8215);
            CallChecker.varInit(this.m_context, "m_context", 249, 8131, 8215);
            CallChecker.varInit(this.m_activator, "m_activator", 249, 8131, 8215);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 249, 8131, 8215);
            CallChecker.varInit(this.m_state, "m_state", 249, 8131, 8215);
            CallChecker.varInit(this.m_revisions, "m_revisions", 249, 8131, 8215);
            CallChecker.varInit(this.m_archive, "m_archive", 249, 8131, 8215);
            CallChecker.varInit(this.__m_felix, "__m_felix", 249, 8131, 8215);
            m_context = context;
            CallChecker.varAssign(this.m_context, "this.m_context", 251, 8190, 8209);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1311.methodEnd();
        }
    }

    public long getBundleId() {
        MethodContext _bcornu_methode_context1312 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 254, 8222, 8590);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 254, 8222, 8590);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 254, 8222, 8590);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 254, 8222, 8590);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 254, 8222, 8590);
            CallChecker.varInit(this.m_stale, "m_stale", 254, 8222, 8590);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 254, 8222, 8590);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 254, 8222, 8590);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 254, 8222, 8590);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 254, 8222, 8590);
            CallChecker.varInit(this.m_context, "m_context", 254, 8222, 8590);
            CallChecker.varInit(this.m_activator, "m_activator", 254, 8222, 8590);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 254, 8222, 8590);
            CallChecker.varInit(this.m_state, "m_state", 254, 8222, 8590);
            CallChecker.varInit(this.m_revisions, "m_revisions", 254, 8222, 8590);
            CallChecker.varInit(this.m_archive, "m_archive", 254, 8222, 8590);
            CallChecker.varInit(this.__m_felix, "__m_felix", 254, 8222, 8590);
            TryContext _bcornu_try_context_358 = new TryContext(358, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 258, 8295, 8303)) {
                    return CallChecker.isCalled(m_archive, BundleArchive.class, 258, 8295, 8303).getId();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_358.catchStart(358);
                final Felix npe_invocation_var456 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var456, Felix.class, 262, 8375, 8388)) {
                    final Logger npe_invocation_var457 = CallChecker.isCalled(npe_invocation_var456, Felix.class, 262, 8375, 8388).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var457, Logger.class, 262, 8375, 8400)) {
                        CallChecker.isCalled(npe_invocation_var457, Logger.class, 262, 8375, 8400).log(this, Logger.LOG_ERROR, "Error getting the identifier from bundle archive.", ex);
                    }
                }
                return -1;
            } finally {
                _bcornu_try_context_358.finallyStart(358);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1312.methodEnd();
        }
    }

    public URL getEntry(String name) {
        MethodContext _bcornu_methode_context1313 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 271, 8597, 9072);
            CallChecker.varInit(name, "name", 271, 8597, 9072);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 271, 8597, 9072);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 271, 8597, 9072);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 271, 8597, 9072);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 271, 8597, 9072);
            CallChecker.varInit(this.m_stale, "m_stale", 271, 8597, 9072);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 271, 8597, 9072);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 271, 8597, 9072);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 271, 8597, 9072);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 271, 8597, 9072);
            CallChecker.varInit(this.m_context, "m_context", 271, 8597, 9072);
            CallChecker.varInit(this.m_activator, "m_activator", 271, 8597, 9072);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 271, 8597, 9072);
            CallChecker.varInit(this.m_state, "m_state", 271, 8597, 9072);
            CallChecker.varInit(this.m_revisions, "m_revisions", 271, 8597, 9072);
            CallChecker.varInit(this.m_archive, "m_archive", 271, 8597, 9072);
            CallChecker.varInit(this.__m_felix, "__m_felix", 271, 8597, 9072);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 273, 8644, 8683);
            if (sm != null) {
                TryContext _bcornu_try_context_359 = new TryContext(359, BundleImpl.class, "java.lang.Exception");
                try {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.RESOURCE));
                } catch (Exception e) {
                    _bcornu_try_context_359.catchStart(359);
                    return null;
                } finally {
                    _bcornu_try_context_359.finallyStart(359);
                }
            }
            final Felix npe_invocation_var458 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var458, Felix.class, 288, 9025, 9038)) {
                return CallChecker.isCalled(npe_invocation_var458, Felix.class, 288, 9025, 9038).getBundleEntry(this, name);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1313.methodEnd();
        }
    }

    public Enumeration getEntryPaths(String path) {
        MethodContext _bcornu_methode_context1314 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 291, 9079, 9572);
            CallChecker.varInit(path, "path", 291, 9079, 9572);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 291, 9079, 9572);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 291, 9079, 9572);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 291, 9079, 9572);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 291, 9079, 9572);
            CallChecker.varInit(this.m_stale, "m_stale", 291, 9079, 9572);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 291, 9079, 9572);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 291, 9079, 9572);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 291, 9079, 9572);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 291, 9079, 9572);
            CallChecker.varInit(this.m_context, "m_context", 291, 9079, 9572);
            CallChecker.varInit(this.m_activator, "m_activator", 291, 9079, 9572);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 291, 9079, 9572);
            CallChecker.varInit(this.m_state, "m_state", 291, 9079, 9572);
            CallChecker.varInit(this.m_revisions, "m_revisions", 291, 9079, 9572);
            CallChecker.varInit(this.m_archive, "m_archive", 291, 9079, 9572);
            CallChecker.varInit(this.__m_felix, "__m_felix", 291, 9079, 9572);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 293, 9139, 9178);
            if (sm != null) {
                TryContext _bcornu_try_context_360 = new TryContext(360, BundleImpl.class, "java.lang.Exception");
                try {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.RESOURCE));
                } catch (Exception e) {
                    _bcornu_try_context_360.catchStart(360);
                    return null;
                } finally {
                    _bcornu_try_context_360.finallyStart(360);
                }
            }
            final Felix npe_invocation_var459 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var459, Felix.class, 308, 9520, 9533)) {
                return CallChecker.isCalled(npe_invocation_var459, Felix.class, 308, 9520, 9533).getBundleEntryPaths(this, path);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1314.methodEnd();
        }
    }

    public Enumeration findEntries(String path, String filePattern, boolean recurse) {
        MethodContext _bcornu_methode_context1315 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 311, 9579, 10144);
            CallChecker.varInit(recurse, "recurse", 311, 9579, 10144);
            CallChecker.varInit(filePattern, "filePattern", 311, 9579, 10144);
            CallChecker.varInit(path, "path", 311, 9579, 10144);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 311, 9579, 10144);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 311, 9579, 10144);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 311, 9579, 10144);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 311, 9579, 10144);
            CallChecker.varInit(this.m_stale, "m_stale", 311, 9579, 10144);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 311, 9579, 10144);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 311, 9579, 10144);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 311, 9579, 10144);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 311, 9579, 10144);
            CallChecker.varInit(this.m_context, "m_context", 311, 9579, 10144);
            CallChecker.varInit(this.m_activator, "m_activator", 311, 9579, 10144);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 311, 9579, 10144);
            CallChecker.varInit(this.m_state, "m_state", 311, 9579, 10144);
            CallChecker.varInit(this.m_revisions, "m_revisions", 311, 9579, 10144);
            CallChecker.varInit(this.m_archive, "m_archive", 311, 9579, 10144);
            CallChecker.varInit(this.__m_felix, "__m_felix", 311, 9579, 10144);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 313, 9674, 9713);
            if (sm != null) {
                TryContext _bcornu_try_context_361 = new TryContext(361, BundleImpl.class, "java.lang.Exception");
                try {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.RESOURCE));
                } catch (Exception e) {
                    _bcornu_try_context_361.catchStart(361);
                    return null;
                } finally {
                    _bcornu_try_context_361.finallyStart(361);
                }
            }
            final Felix npe_invocation_var460 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var460, Felix.class, 328, 10055, 10068)) {
                return CallChecker.isCalled(npe_invocation_var460, Felix.class, 328, 10055, 10068).findBundleEntries(this, path, filePattern, recurse);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1315.methodEnd();
        }
    }

    public Dictionary getHeaders() {
        MethodContext _bcornu_methode_context1316 = new MethodContext(Dictionary.class);
        try {
            CallChecker.varInit(this, "this", 332, 10151, 10251);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 332, 10151, 10251);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 332, 10151, 10251);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 332, 10151, 10251);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 332, 10151, 10251);
            CallChecker.varInit(this.m_stale, "m_stale", 332, 10151, 10251);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 332, 10151, 10251);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 332, 10151, 10251);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 332, 10151, 10251);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 332, 10151, 10251);
            CallChecker.varInit(this.m_context, "m_context", 332, 10151, 10251);
            CallChecker.varInit(this.m_activator, "m_activator", 332, 10151, 10251);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 332, 10151, 10251);
            CallChecker.varInit(this.m_state, "m_state", 332, 10151, 10251);
            CallChecker.varInit(this.m_revisions, "m_revisions", 332, 10151, 10251);
            CallChecker.varInit(this.m_archive, "m_archive", 332, 10151, 10251);
            CallChecker.varInit(this.__m_felix, "__m_felix", 332, 10151, 10251);
            if (CallChecker.beforeDeref(Locale.getDefault(), Locale.class, 334, 10214, 10232)) {
                return getHeaders(CallChecker.isCalled(Locale.getDefault(), Locale.class, 334, 10214, 10232).toString());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dictionary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1316.methodEnd();
        }
    }

    public Dictionary getHeaders(String locale) {
        MethodContext _bcornu_methode_context1317 = new MethodContext(Dictionary.class);
        try {
            CallChecker.varInit(this, "this", 337, 10258, 10692);
            CallChecker.varInit(locale, "locale", 337, 10258, 10692);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 337, 10258, 10692);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 337, 10258, 10692);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 337, 10258, 10692);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 337, 10258, 10692);
            CallChecker.varInit(this.m_stale, "m_stale", 337, 10258, 10692);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 337, 10258, 10692);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 337, 10258, 10692);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 337, 10258, 10692);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 337, 10258, 10692);
            CallChecker.varInit(this.m_context, "m_context", 337, 10258, 10692);
            CallChecker.varInit(this.m_activator, "m_activator", 337, 10258, 10692);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 337, 10258, 10692);
            CallChecker.varInit(this.m_state, "m_state", 337, 10258, 10692);
            CallChecker.varInit(this.m_revisions, "m_revisions", 337, 10258, 10692);
            CallChecker.varInit(this.m_archive, "m_archive", 337, 10258, 10692);
            CallChecker.varInit(this.__m_felix, "__m_felix", 337, 10258, 10692);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 339, 10316, 10355);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.METADATA));
            }
            if (locale == null) {
                if (CallChecker.beforeDeref(Locale.getDefault(), Locale.class, 349, 10583, 10601)) {
                    locale = CallChecker.isCalled(Locale.getDefault(), Locale.class, 349, 10583, 10601).toString();
                    CallChecker.varAssign(locale, "locale", 349, 10574, 10613);
                }
            }
            final Felix npe_invocation_var461 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var461, Felix.class, 352, 10641, 10654)) {
                return CallChecker.isCalled(npe_invocation_var461, Felix.class, 352, 10641, 10654).getBundleHeaders(this, locale);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dictionary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1317.methodEnd();
        }
    }

    Map getCurrentLocalizedHeader(String locale) {
        MethodContext _bcornu_methode_context1318 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 355, 10699, 16308);
            CallChecker.varInit(locale, "locale", 355, 10699, 16308);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 355, 10699, 16308);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 355, 10699, 16308);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 355, 10699, 16308);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 355, 10699, 16308);
            CallChecker.varInit(this.m_stale, "m_stale", 355, 10699, 16308);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 355, 10699, 16308);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 355, 10699, 16308);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 355, 10699, 16308);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 355, 10699, 16308);
            CallChecker.varInit(this.m_context, "m_context", 355, 10699, 16308);
            CallChecker.varInit(this.m_activator, "m_activator", 355, 10699, 16308);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 355, 10699, 16308);
            CallChecker.varInit(this.m_state, "m_state", 355, 10699, 16308);
            CallChecker.varInit(this.m_revisions, "m_revisions", 355, 10699, 16308);
            CallChecker.varInit(this.m_archive, "m_archive", 355, 10699, 16308);
            CallChecker.varInit(this.__m_felix, "__m_felix", 355, 10699, 16308);
            Map result = CallChecker.varInit(null, "result", 357, 10758, 10775);
            if (CallChecker.beforeDeref(locale, String.class, 360, 10844, 10849)) {
                locale = CallChecker.beforeCalled(locale, String.class, 360, 10844, 10849);
                if ((CallChecker.isCalled(locale, String.class, 360, 10844, 10849).length()) == 0) {
                    final BundleRevisionImpl npe_invocation_var462 = adapt(BundleRevisionImpl.class);
                    if (CallChecker.beforeDeref(npe_invocation_var462, BundleRevisionImpl.class, 362, 10911, 10941)) {
                        result = new StringMap(CallChecker.isCalled(npe_invocation_var462, BundleRevisionImpl.class, 362, 10911, 10941).getHeaders());
                        CallChecker.varAssign(result, "result", 362, 10888, 10956);
                    }
                }
            }
            if (result == null) {
                synchronized(m_cachedHeaders) {
                    if ((m_uninstalledHeaders) != null) {
                        result = m_uninstalledHeaders;
                        CallChecker.varAssign(result, "result", 375, 11411, 11440);
                    }else
                        if ((getLastModified()) > (m_cachedHeadersTimestamp)) {
                            if (CallChecker.beforeDeref(m_cachedHeaders, Map.class, 380, 11646, 11660)) {
                                CallChecker.isCalled(m_cachedHeaders, Map.class, 380, 11646, 11660).clear();
                            }
                        }else {
                            if (CallChecker.beforeDeref(m_cachedHeaders, Map.class, 386, 11908, 11922)) {
                                if (CallChecker.isCalled(m_cachedHeaders, Map.class, 386, 11908, 11922).containsKey(locale)) {
                                    if (CallChecker.beforeDeref(m_cachedHeaders, Map.class, 388, 12006, 12020)) {
                                        result = ((Map) (CallChecker.isCalled(m_cachedHeaders, Map.class, 388, 12006, 12020).get(locale)));
                                        CallChecker.varAssign(result, "result", 388, 11991, 12033);
                                    }
                                }
                            }
                        }
                    
                }
            }
            if (result == null) {
                final BundleRevisionImpl npe_invocation_var463 = adapt(BundleRevisionImpl.class);
                Map headers = CallChecker.init(Map.class);
                if (CallChecker.beforeDeref(npe_invocation_var463, BundleRevisionImpl.class, 398, 12308, 12338)) {
                    headers = new StringMap(CallChecker.isCalled(npe_invocation_var463, BundleRevisionImpl.class, 398, 12308, 12338).getHeaders());
                    CallChecker.varAssign(headers, "headers", 398, 12308, 12338);
                }
                result = headers;
                CallChecker.varAssign(result, "result", 400, 12427, 12443);
                boolean localize = CallChecker.varInit(((boolean) (false)), "localize", 403, 12527, 12551);
                headers = CallChecker.beforeCalled(headers, Map.class, 404, 12584, 12590);
                for (Iterator it = CallChecker.isCalled(CallChecker.isCalled(headers, Map.class, 404, 12584, 12590).values(), Collection.class, 404, 12584, 12599).iterator(); (!localize) && (CallChecker.isCalled(it, Iterator.class, 404, 12626, 12627).hasNext());) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 406, 12686, 12687)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(it, Iterator.class, 406, 12686, 12687).next(), Object.class, 406, 12686, 12694)) {
                            if (CallChecker.isCalled(((String) (CallChecker.isCalled(it, Iterator.class, 406, 12686, 12687).next())), String.class, 406, 12686, 12694).startsWith("%")) {
                                localize = true;
                                CallChecker.varAssign(localize, "localize", 408, 12752, 12767);
                            }
                        }
                    }
                }
                if (!localize) {
                    updateHeaderCache(locale, headers);
                }else {
                    String basename = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(headers, Map.class, 421, 13198, 13204)) {
                        headers = CallChecker.beforeCalled(headers, Map.class, 421, 13198, 13204);
                        basename = ((String) (CallChecker.isCalled(headers, Map.class, 421, 13198, 13204).get(Constants.BUNDLE_LOCALIZATION)));
                        CallChecker.varAssign(basename, "basename", 421, 13198, 13204);
                    }
                    if (basename == null) {
                        basename = Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME;
                        CallChecker.varAssign(basename, "basename", 424, 13318, 13375);
                    }
                    List<BundleRevision> revisionList = CallChecker.varInit(BundleImpl.createLocalizationRevisionList(adapt(BundleRevisionImpl.class)), "revisionList", 429, 13530, 13650);
                    List<String> resourceList = CallChecker.varInit(BundleImpl.createLocalizationResourceList(basename, locale), "resourceList", 433, 13741, 13817);
                    boolean found = CallChecker.varInit(((boolean) (false)), "found", 436, 13923, 13944);
                    Properties mergedProperties = CallChecker.varInit(new Properties(), "mergedProperties", 437, 13962, 14008);
                    if (CallChecker.beforeDeref(revisionList, Map.class, 438, 14051, 14062)) {
                        for (BundleRevision br : revisionList) {
                            if (CallChecker.beforeDeref(resourceList, Map.class, 440, 14121, 14132)) {
                                for (String res : resourceList) {
                                    URL temp = CallChecker.init(URL.class);
                                    if (CallChecker.beforeDeref(br, BundleRevision.class, 442, 14214, 14215)) {
                                        temp = CallChecker.isCalled(((BundleRevisionImpl) (br)), BundleRevisionImpl.class, 442, 14214, 14215).getEntry((res + ".properties"));
                                        CallChecker.varAssign(temp, "temp", 442, 14214, 14215);
                                    }
                                    if (temp != null) {
                                        found = true;
                                        CallChecker.varAssign(found, "found", 445, 14345, 14357);
                                        TryContext _bcornu_try_context_362 = new TryContext(362, BundleImpl.class, "java.io.IOException");
                                        try {
                                            temp = CallChecker.beforeCalled(temp, URL.class, 449, 14512, 14515);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(temp, URL.class, 449, 14512, 14515).openConnection(), URLConnection.class, 449, 14512, 14532)) {
                                                if (CallChecker.beforeDeref(mergedProperties, Properties.class, 448, 14453, 14468)) {
                                                    mergedProperties = CallChecker.beforeCalled(mergedProperties, Properties.class, 448, 14453, 14468);
                                                    CallChecker.isCalled(mergedProperties, Properties.class, 448, 14453, 14468).load(CallChecker.isCalled(temp.openConnection(), URLConnection.class, 449, 14512, 14532).getInputStream());
                                                }
                                            }
                                        } catch (IOException ex) {
                                            _bcornu_try_context_362.catchStart(362);
                                        } finally {
                                            _bcornu_try_context_362.finallyStart(362);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(Locale.getDefault(), Locale.class, 461, 15019, 15037)) {
                        if (CallChecker.beforeDeref(locale, String.class, 461, 15005, 15010)) {
                            locale = CallChecker.beforeCalled(locale, String.class, 461, 15005, 15010);
                            if ((!found) && (!(CallChecker.isCalled(locale, String.class, 461, 15005, 15010).equals(CallChecker.isCalled(Locale.getDefault(), Locale.class, 461, 15019, 15037).toString())))) {
                                if (CallChecker.beforeDeref(Locale.getDefault(), Locale.class, 463, 15125, 15143)) {
                                    result = getCurrentLocalizedHeader(CallChecker.isCalled(Locale.getDefault(), Locale.class, 463, 15125, 15143).toString());
                                    CallChecker.varAssign(result, "result", 463, 15090, 15156);
                                }
                            }else {
                                headers = CallChecker.beforeCalled(headers, Map.class, 470, 15445, 15451);
                                for (Iterator it = CallChecker.isCalled(CallChecker.isCalled(headers, Map.class, 470, 15445, 15451).entrySet(), Set.class, 470, 15445, 15462).iterator(); CallChecker.isCalled(it, Iterator.class, 470, 15476, 15477).hasNext();) {
                                    Map.Entry entry = CallChecker.init(Map.Entry.class);
                                    if (CallChecker.beforeDeref(it, Iterator.class, 472, 15568, 15569)) {
                                        entry = ((Map.Entry) (CallChecker.isCalled(it, Iterator.class, 472, 15568, 15569).next()));
                                        CallChecker.varAssign(entry, "entry", 472, 15568, 15569);
                                    }
                                    String value = CallChecker.init(String.class);
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 473, 15627, 15631)) {
                                        entry = CallChecker.beforeCalled(entry, Map.Entry.class, 473, 15627, 15631);
                                        value = ((String) (CallChecker.isCalled(entry, Map.Entry.class, 473, 15627, 15631).getValue()));
                                        CallChecker.varAssign(value, "value", 473, 15627, 15631);
                                    }
                                    if (CallChecker.beforeDeref(value, String.class, 474, 15673, 15677)) {
                                        value = CallChecker.beforeCalled(value, String.class, 474, 15673, 15677);
                                        if (CallChecker.isCalled(value, String.class, 474, 15673, 15677).startsWith("%")) {
                                            String newvalue = CallChecker.init(String.class);
                                            String key = CallChecker.init(String.class);
                                            if (CallChecker.beforeDeref(value, String.class, 477, 15824, 15828)) {
                                                if (CallChecker.beforeDeref(value, String.class, 477, 15808, 15812)) {
                                                    value = CallChecker.beforeCalled(value, String.class, 477, 15824, 15828);
                                                    value = CallChecker.beforeCalled(value, String.class, 477, 15808, 15812);
                                                    key = CallChecker.isCalled(value, String.class, 477, 15808, 15812).substring(((CallChecker.isCalled(value, String.class, 477, 15824, 15828).indexOf("%")) + 1));
                                                    CallChecker.varAssign(key, "key", 477, 15824, 15828);
                                                }
                                            }
                                            if (CallChecker.beforeDeref(mergedProperties, Properties.class, 478, 15888, 15903)) {
                                                mergedProperties = CallChecker.beforeCalled(mergedProperties, Properties.class, 478, 15888, 15903);
                                                newvalue = CallChecker.isCalled(mergedProperties, Properties.class, 478, 15888, 15903).getProperty(key);
                                                CallChecker.varAssign(newvalue, "newvalue", 478, 15877, 15921);
                                            }
                                            if (newvalue == null) {
                                                newvalue = key;
                                                CallChecker.varAssign(newvalue, "newvalue", 481, 16033, 16047);
                                            }
                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 483, 16107, 16111)) {
                                                entry = CallChecker.beforeCalled(entry, Map.Entry.class, 483, 16107, 16111);
                                                CallChecker.isCalled(entry, Map.Entry.class, 483, 16107, 16111).setValue(newvalue);
                                            }
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                                updateHeaderCache(locale, headers);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1318.methodEnd();
        }
    }

    private void updateHeaderCache(String locale, Map localizedHeaders) {
        MethodContext _bcornu_methode_context1319 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 495, 16315, 16660);
            CallChecker.varInit(localizedHeaders, "localizedHeaders", 495, 16315, 16660);
            CallChecker.varInit(locale, "locale", 495, 16315, 16660);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 495, 16315, 16660);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 495, 16315, 16660);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 495, 16315, 16660);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 495, 16315, 16660);
            CallChecker.varInit(this.m_stale, "m_stale", 495, 16315, 16660);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 495, 16315, 16660);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 495, 16315, 16660);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 495, 16315, 16660);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 495, 16315, 16660);
            CallChecker.varInit(this.m_context, "m_context", 495, 16315, 16660);
            CallChecker.varInit(this.m_activator, "m_activator", 495, 16315, 16660);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 495, 16315, 16660);
            CallChecker.varInit(this.m_state, "m_state", 495, 16315, 16660);
            CallChecker.varInit(this.m_revisions, "m_revisions", 495, 16315, 16660);
            CallChecker.varInit(this.m_archive, "m_archive", 495, 16315, 16660);
            CallChecker.varInit(this.__m_felix, "__m_felix", 495, 16315, 16660);
            synchronized(m_cachedHeaders) {
                if ((m_uninstalledHeaders) == null) {
                    if (CallChecker.beforeDeref(m_cachedHeaders, Map.class, 501, 16514, 16528)) {
                        CallChecker.isCalled(m_cachedHeaders, Map.class, 501, 16514, 16528).put(locale, localizedHeaders);
                    }
                    m_cachedHeadersTimestamp = System.currentTimeMillis();
                    CallChecker.varAssign(this.m_cachedHeadersTimestamp, "this.m_cachedHeadersTimestamp", 502, 16577, 16630);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1319.methodEnd();
        }
    }

    private static List<BundleRevision> createLocalizationRevisionList(BundleRevision br) {
        MethodContext _bcornu_methode_context1320 = new MethodContext(List.class);
        try {
            CallChecker.varInit(br, "br", 507, 16667, 18462);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 507, 16667, 18462);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 507, 16667, 18462);
            if (Util.isFragment(br)) {
                if (CallChecker.beforeDeref(br, BundleRevision.class, 518, 17237, 17238)) {
                    br = CallChecker.beforeCalled(br, BundleRevision.class, 518, 17237, 17238);
                    if ((CallChecker.isCalled(br, BundleRevision.class, 518, 17237, 17238).getWiring()) != null) {
                        List<BundleWire> hostWires = CallChecker.init(List.class);
                        if (CallChecker.beforeDeref(br, BundleRevision.class, 520, 17320, 17321)) {
                            br = CallChecker.beforeCalled(br, BundleRevision.class, 520, 17320, 17321);
                            hostWires = CallChecker.isCalled(br, BundleRevision.class, 520, 17320, 17321).getWiring().getRequiredWires(null);
                            CallChecker.varAssign(hostWires, "hostWires", 520, 17320, 17321);
                        }
                        if ((hostWires != null) && ((hostWires.size()) > 0)) {
                            hostWires = CallChecker.beforeCalled(hostWires, List.class, 523, 17469, 17477);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(hostWires, List.class, 523, 17469, 17477).get(0), BundleWire.class, 523, 17469, 17484)) {
                                hostWires = CallChecker.beforeCalled(hostWires, List.class, 523, 17469, 17477);
                                final BundleWiring npe_invocation_var464 = CallChecker.isCalled(CallChecker.isCalled(hostWires, List.class, 523, 17469, 17477).get(0), BundleWire.class, 523, 17469, 17484).getProviderWiring();
                                if (CallChecker.beforeDeref(npe_invocation_var464, BundleWiring.class, 523, 17469, 17504)) {
                                    br = CallChecker.isCalled(npe_invocation_var464, BundleWiring.class, 523, 17469, 17504).getRevision();
                                    CallChecker.varAssign(br, "br", 523, 17464, 17519);
                                }
                            }
                            for (int hostIdx = 1; hostIdx < (hostWires.size()); hostIdx++) {
                                if (CallChecker.beforeDeref(br, BundleRevision.class, 526, 17652, 17653)) {
                                    hostWires = CallChecker.beforeCalled(hostWires, List.class, 527, 17707, 17715);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(hostWires, List.class, 527, 17707, 17715).get(hostIdx), BundleWire.class, 527, 17707, 17728)) {
                                        hostWires = CallChecker.beforeCalled(hostWires, List.class, 527, 17707, 17715);
                                        final BundleWiring npe_invocation_var465 = CallChecker.isCalled(CallChecker.isCalled(hostWires, List.class, 527, 17707, 17715).get(hostIdx), BundleWire.class, 527, 17707, 17728).getProviderWiring();
                                        if (CallChecker.beforeDeref(npe_invocation_var465, BundleWiring.class, 527, 17707, 17748)) {
                                            final BundleRevision npe_invocation_var466 = CallChecker.isCalled(npe_invocation_var465, BundleWiring.class, 527, 17707, 17748).getRevision();
                                            if (CallChecker.beforeDeref(npe_invocation_var466, BundleRevision.class, 527, 17707, 17762)) {
                                                br = CallChecker.beforeCalled(br, BundleRevision.class, 526, 17652, 17653);
                                                final Version npe_invocation_var467 = CallChecker.isCalled(br, BundleRevision.class, 526, 17652, 17653).getVersion();
                                                if (CallChecker.beforeDeref(npe_invocation_var467, Version.class, 526, 17652, 17666)) {
                                                    if ((CallChecker.isCalled(npe_invocation_var467, Version.class, 526, 17652, 17666).compareTo(CallChecker.isCalled(npe_invocation_var466, BundleRevision.class, 527, 17707, 17762).getVersion())) < 0) {
                                                        hostWires = CallChecker.beforeCalled(hostWires, List.class, 529, 17842, 17850);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(hostWires, List.class, 529, 17842, 17850).get(hostIdx), BundleWire.class, 529, 17842, 17863)) {
                                                            hostWires = CallChecker.beforeCalled(hostWires, List.class, 529, 17842, 17850);
                                                            final BundleWiring npe_invocation_var468 = CallChecker.isCalled(CallChecker.isCalled(hostWires, List.class, 529, 17842, 17850).get(hostIdx), BundleWire.class, 529, 17842, 17863).getProviderWiring();
                                                            if (CallChecker.beforeDeref(npe_invocation_var468, BundleWiring.class, 529, 17842, 17883)) {
                                                                br = CallChecker.isCalled(npe_invocation_var468, BundleWiring.class, 529, 17842, 17883).getRevision();
                                                                CallChecker.varAssign(br, "br", 529, 17837, 17898);
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
                }else
                    throw new AbnormalExecutionError();
                
            }
            List<BundleRevision> result = CallChecker.varInit(new ArrayList<BundleRevision>(), "result", 537, 18077, 18138);
            if (CallChecker.beforeDeref(result, List.class, 538, 18148, 18153)) {
                result = CallChecker.beforeCalled(result, List.class, 538, 18148, 18153);
                CallChecker.isCalled(result, List.class, 538, 18148, 18153).add(br);
            }
            BundleWiring wiring = CallChecker.init(BundleWiring.class);
            if (CallChecker.beforeDeref(br, BundleRevision.class, 539, 18194, 18195)) {
                br = CallChecker.beforeCalled(br, BundleRevision.class, 539, 18194, 18195);
                wiring = CallChecker.isCalled(br, BundleRevision.class, 539, 18194, 18195).getWiring();
                CallChecker.varAssign(wiring, "wiring", 539, 18194, 18195);
            }
            if (wiring != null) {
                List<BundleRevision> fragments = CallChecker.varInit(Util.getFragments(wiring), "fragments", 542, 18260, 18318);
                if (fragments != null) {
                    if (CallChecker.beforeDeref(result, List.class, 545, 18385, 18390)) {
                        result = CallChecker.beforeCalled(result, List.class, 545, 18385, 18390);
                        CallChecker.isCalled(result, List.class, 545, 18385, 18390).addAll(fragments);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1320.methodEnd();
        }
    }

    private static List<String> createLocalizationResourceList(String basename, String locale) {
        MethodContext _bcornu_methode_context1321 = new MethodContext(List.class);
        try {
            CallChecker.varInit(locale, "locale", 551, 18469, 19078);
            CallChecker.varInit(basename, "basename", 551, 18469, 19078);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 551, 18469, 19078);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 551, 18469, 19078);
            List<String> result = CallChecker.varInit(new ArrayList(4), "result", 553, 18574, 18612);
            StringTokenizer tokens = CallChecker.init(StringTokenizer.class);
            StringBuffer tempLocale = CallChecker.varInit(new StringBuffer(basename), "tempLocale", 556, 18655, 18707);
            if (CallChecker.beforeDeref(tempLocale, StringBuffer.class, 558, 18729, 18738)) {
                if (CallChecker.beforeDeref(result, List.class, 558, 18718, 18723)) {
                    tempLocale = CallChecker.beforeCalled(tempLocale, StringBuffer.class, 558, 18729, 18738);
                    result = CallChecker.beforeCalled(result, List.class, 558, 18718, 18723);
                    CallChecker.isCalled(result, List.class, 558, 18718, 18723).add(CallChecker.isCalled(tempLocale, StringBuffer.class, 558, 18729, 18738).toString());
                }
            }
            if (CallChecker.beforeDeref(locale, String.class, 560, 18766, 18771)) {
                locale = CallChecker.beforeCalled(locale, String.class, 560, 18766, 18771);
                if ((CallChecker.isCalled(locale, String.class, 560, 18766, 18771).length()) > 0) {
                    tokens = new StringTokenizer(locale, "_");
                    CallChecker.varAssign(tokens, "tokens", 562, 18809, 18850);
                    tokens = CallChecker.beforeCalled(tokens, StringTokenizer.class, 563, 18871, 18876);
                    while (CallChecker.isCalled(tokens, StringTokenizer.class, 563, 18871, 18876).hasMoreTokens()) {
                        if (CallChecker.beforeDeref(tempLocale, StringBuffer.class, 565, 18925, 18934)) {
                            if (CallChecker.beforeDeref(tokens, StringTokenizer.class, 565, 18955, 18960)) {
                                tempLocale = CallChecker.beforeCalled(tempLocale, StringBuffer.class, 565, 18925, 18934);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(tempLocale, StringBuffer.class, 565, 18925, 18934).append("_"), StringBuffer.class, 565, 18925, 18946)) {
                                    tempLocale = CallChecker.beforeCalled(tempLocale, StringBuffer.class, 565, 18925, 18934);
                                    tokens = CallChecker.beforeCalled(tokens, StringTokenizer.class, 565, 18955, 18960);
                                    CallChecker.isCalled(CallChecker.isCalled(tempLocale, StringBuffer.class, 565, 18925, 18934).append("_"), StringBuffer.class, 565, 18925, 18946).append(CallChecker.isCalled(tokens, StringTokenizer.class, 565, 18955, 18960).nextToken());
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(tempLocale, StringBuffer.class, 566, 19003, 19012)) {
                            if (CallChecker.beforeDeref(result, List.class, 566, 18992, 18997)) {
                                tempLocale = CallChecker.beforeCalled(tempLocale, StringBuffer.class, 566, 19003, 19012);
                                result = CallChecker.beforeCalled(result, List.class, 566, 18992, 18997);
                                CallChecker.isCalled(result, List.class, 566, 18992, 18997).add(CallChecker.isCalled(tempLocale, StringBuffer.class, 566, 19003, 19012).toString());
                            }
                        }
                    } 
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1321.methodEnd();
        }
    }

    public long getLastModified() {
        MethodContext _bcornu_methode_context1322 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 572, 19085, 19474);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 572, 19085, 19474);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 572, 19085, 19474);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 572, 19085, 19474);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 572, 19085, 19474);
            CallChecker.varInit(this.m_stale, "m_stale", 572, 19085, 19474);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 572, 19085, 19474);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 572, 19085, 19474);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 572, 19085, 19474);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 572, 19085, 19474);
            CallChecker.varInit(this.m_context, "m_context", 572, 19085, 19474);
            CallChecker.varInit(this.m_activator, "m_activator", 572, 19085, 19474);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 572, 19085, 19474);
            CallChecker.varInit(this.m_state, "m_state", 572, 19085, 19474);
            CallChecker.varInit(this.m_revisions, "m_revisions", 572, 19085, 19474);
            CallChecker.varInit(this.m_archive, "m_archive", 572, 19085, 19474);
            CallChecker.varInit(this.__m_felix, "__m_felix", 572, 19085, 19474);
            TryContext _bcornu_try_context_363 = new TryContext(363, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 576, 19162, 19170)) {
                    return CallChecker.isCalled(m_archive, BundleArchive.class, 576, 19162, 19170).getLastModified();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_363.catchStart(363);
                final Felix npe_invocation_var469 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var469, Felix.class, 580, 19252, 19265)) {
                    final Logger npe_invocation_var470 = CallChecker.isCalled(npe_invocation_var469, Felix.class, 580, 19252, 19265).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var470, Logger.class, 580, 19252, 19277)) {
                        CallChecker.isCalled(npe_invocation_var470, Logger.class, 580, 19252, 19277).log(this, Logger.LOG_ERROR, "Error reading last modification time from bundle archive.", ex);
                    }
                }
                return 0;
            } finally {
                _bcornu_try_context_363.finallyStart(363);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1322.methodEnd();
        }
    }

    void setLastModified(long l) {
        MethodContext _bcornu_methode_context1323 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 589, 19481, 19839);
            CallChecker.varInit(l, "l", 589, 19481, 19839);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 589, 19481, 19839);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 589, 19481, 19839);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 589, 19481, 19839);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 589, 19481, 19839);
            CallChecker.varInit(this.m_stale, "m_stale", 589, 19481, 19839);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 589, 19481, 19839);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 589, 19481, 19839);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 589, 19481, 19839);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 589, 19481, 19839);
            CallChecker.varInit(this.m_context, "m_context", 589, 19481, 19839);
            CallChecker.varInit(this.m_activator, "m_activator", 589, 19481, 19839);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 589, 19481, 19839);
            CallChecker.varInit(this.m_state, "m_state", 589, 19481, 19839);
            CallChecker.varInit(this.m_revisions, "m_revisions", 589, 19481, 19839);
            CallChecker.varInit(this.m_archive, "m_archive", 589, 19481, 19839);
            CallChecker.varInit(this.__m_felix, "__m_felix", 589, 19481, 19839);
            TryContext _bcornu_try_context_364 = new TryContext(364, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 593, 19550, 19558)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 593, 19550, 19558).setLastModified(l);
                }
            } catch (Exception ex) {
                _bcornu_try_context_364.catchStart(364);
                final Felix npe_invocation_var471 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var471, Felix.class, 597, 19641, 19654)) {
                    final Logger npe_invocation_var472 = CallChecker.isCalled(npe_invocation_var471, Felix.class, 597, 19641, 19654).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var472, Logger.class, 597, 19641, 19666)) {
                        CallChecker.isCalled(npe_invocation_var472, Logger.class, 597, 19641, 19666).log(this, Logger.LOG_ERROR, "Error writing last modification time to bundle archive.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_364.finallyStart(364);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1323.methodEnd();
        }
    }

    public String getLocation() {
        MethodContext _bcornu_methode_context1324 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 605, 19846, 20130);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 605, 19846, 20130);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 605, 19846, 20130);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 605, 19846, 20130);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 605, 19846, 20130);
            CallChecker.varInit(this.m_stale, "m_stale", 605, 19846, 20130);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 605, 19846, 20130);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 605, 19846, 20130);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 605, 19846, 20130);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 605, 19846, 20130);
            CallChecker.varInit(this.m_context, "m_context", 605, 19846, 20130);
            CallChecker.varInit(this.m_activator, "m_activator", 605, 19846, 20130);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 605, 19846, 20130);
            CallChecker.varInit(this.m_state, "m_state", 605, 19846, 20130);
            CallChecker.varInit(this.m_revisions, "m_revisions", 605, 19846, 20130);
            CallChecker.varInit(this.m_archive, "m_archive", 605, 19846, 20130);
            CallChecker.varInit(this.__m_felix, "__m_felix", 605, 19846, 20130);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 607, 19888, 19927);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.METADATA));
            }
            return _getLocation();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1324.methodEnd();
        }
    }

    String _getLocation() {
        MethodContext _bcornu_methode_context1325 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 617, 20137, 20503);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 617, 20137, 20503);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 617, 20137, 20503);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 617, 20137, 20503);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 617, 20137, 20503);
            CallChecker.varInit(this.m_stale, "m_stale", 617, 20137, 20503);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 617, 20137, 20503);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 617, 20137, 20503);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 617, 20137, 20503);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 617, 20137, 20503);
            CallChecker.varInit(this.m_context, "m_context", 617, 20137, 20503);
            CallChecker.varInit(this.m_activator, "m_activator", 617, 20137, 20503);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 617, 20137, 20503);
            CallChecker.varInit(this.m_state, "m_state", 617, 20137, 20503);
            CallChecker.varInit(this.m_revisions, "m_revisions", 617, 20137, 20503);
            CallChecker.varInit(this.m_archive, "m_archive", 617, 20137, 20503);
            CallChecker.varInit(this.__m_felix, "__m_felix", 617, 20137, 20503);
            TryContext _bcornu_try_context_365 = new TryContext(365, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 621, 20206, 20214)) {
                    return CallChecker.isCalled(m_archive, BundleArchive.class, 621, 20206, 20214).getLocation();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_365.catchStart(365);
                final Felix npe_invocation_var473 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var473, Felix.class, 625, 20292, 20305)) {
                    final Logger npe_invocation_var474 = CallChecker.isCalled(npe_invocation_var473, Felix.class, 625, 20292, 20305).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var474, Logger.class, 625, 20292, 20317)) {
                        CallChecker.isCalled(npe_invocation_var474, Logger.class, 625, 20292, 20317).log(this, Logger.LOG_ERROR, "Error getting location from bundle archive.", ex);
                    }
                }
                return null;
            } finally {
                _bcornu_try_context_365.finallyStart(365);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1325.methodEnd();
        }
    }

    public URL getResource(String name) {
        MethodContext _bcornu_methode_context1326 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 639, 20510, 21133);
            CallChecker.varInit(name, "name", 639, 20510, 21133);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 639, 20510, 21133);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 639, 20510, 21133);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 639, 20510, 21133);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 639, 20510, 21133);
            CallChecker.varInit(this.m_stale, "m_stale", 639, 20510, 21133);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 639, 20510, 21133);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 639, 20510, 21133);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 639, 20510, 21133);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 639, 20510, 21133);
            CallChecker.varInit(this.m_context, "m_context", 639, 20510, 21133);
            CallChecker.varInit(this.m_activator, "m_activator", 639, 20510, 21133);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 639, 20510, 21133);
            CallChecker.varInit(this.m_state, "m_state", 639, 20510, 21133);
            CallChecker.varInit(this.m_revisions, "m_revisions", 639, 20510, 21133);
            CallChecker.varInit(this.m_archive, "m_archive", 639, 20510, 21133);
            CallChecker.varInit(this.__m_felix, "__m_felix", 639, 20510, 21133);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 641, 20701, 20740);
            if (sm != null) {
                TryContext _bcornu_try_context_366 = new TryContext(366, BundleImpl.class, "java.lang.Exception");
                try {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.RESOURCE));
                } catch (Exception e) {
                    _bcornu_try_context_366.catchStart(366);
                    return null;
                } finally {
                    _bcornu_try_context_366.finallyStart(366);
                }
            }
            final Felix npe_invocation_var475 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var475, Felix.class, 656, 21083, 21096)) {
                return CallChecker.isCalled(npe_invocation_var475, Felix.class, 656, 21083, 21096).getBundleResource(this, name);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1326.methodEnd();
        }
    }

    public Enumeration getResources(String name) throws IOException {
        MethodContext _bcornu_methode_context1327 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 659, 21140, 21871);
            CallChecker.varInit(name, "name", 659, 21140, 21871);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 659, 21140, 21871);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 659, 21140, 21871);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 659, 21140, 21871);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 659, 21140, 21871);
            CallChecker.varInit(this.m_stale, "m_stale", 659, 21140, 21871);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 659, 21140, 21871);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 659, 21140, 21871);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 659, 21140, 21871);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 659, 21140, 21871);
            CallChecker.varInit(this.m_context, "m_context", 659, 21140, 21871);
            CallChecker.varInit(this.m_activator, "m_activator", 659, 21140, 21871);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 659, 21140, 21871);
            CallChecker.varInit(this.m_state, "m_state", 659, 21140, 21871);
            CallChecker.varInit(this.m_revisions, "m_revisions", 659, 21140, 21871);
            CallChecker.varInit(this.m_archive, "m_archive", 659, 21140, 21871);
            CallChecker.varInit(this.__m_felix, "__m_felix", 659, 21140, 21871);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 661, 21218, 21257);
            if (sm != null) {
                TryContext _bcornu_try_context_367 = new TryContext(367, BundleImpl.class, "java.lang.Exception");
                try {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.RESOURCE));
                } catch (Exception e) {
                    _bcornu_try_context_367.catchStart(367);
                    return null;
                } finally {
                    _bcornu_try_context_367.finallyStart(367);
                }
            }
            final Felix npe_invocation_var476 = getFramework();
            Enumeration e = CallChecker.init(Enumeration.class);
            if (CallChecker.beforeDeref(npe_invocation_var476, Felix.class, 678, 21755, 21768)) {
                e = CallChecker.isCalled(npe_invocation_var476, Felix.class, 678, 21755, 21768).getBundleResources(this, name);
                CallChecker.varAssign(e, "e", 678, 21755, 21768);
            }
            if ((e == null) || (!(e.hasMoreElements()))) {
                return null;
            }else {
                return e;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1327.methodEnd();
        }
    }

    public ServiceReference[] getRegisteredServices() {
        MethodContext _bcornu_methode_context1328 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 688, 21878, 23152);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 688, 21878, 23152);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 688, 21878, 23152);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 688, 21878, 23152);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 688, 21878, 23152);
            CallChecker.varInit(this.m_stale, "m_stale", 688, 21878, 23152);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 688, 21878, 23152);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 688, 21878, 23152);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 688, 21878, 23152);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 688, 21878, 23152);
            CallChecker.varInit(this.m_context, "m_context", 688, 21878, 23152);
            CallChecker.varInit(this.m_activator, "m_activator", 688, 21878, 23152);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 688, 21878, 23152);
            CallChecker.varInit(this.m_state, "m_state", 688, 21878, 23152);
            CallChecker.varInit(this.m_revisions, "m_revisions", 688, 21878, 23152);
            CallChecker.varInit(this.m_archive, "m_archive", 688, 21878, 23152);
            CallChecker.varInit(this.__m_felix, "__m_felix", 688, 21878, 23152);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 690, 22124, 22163);
            if (sm != null) {
                final Felix npe_invocation_var477 = getFramework();
                ServiceReference[] refs = CallChecker.init(ServiceReference[].class);
                if (CallChecker.beforeDeref(npe_invocation_var477, Felix.class, 694, 22238, 22251)) {
                    refs = CallChecker.isCalled(npe_invocation_var477, Felix.class, 694, 22238, 22251).getBundleRegisteredServices(this);
                    CallChecker.varAssign(refs, "refs", 694, 22238, 22251);
                }
                if (refs == null) {
                    return refs;
                }
                List result = CallChecker.varInit(new ArrayList(), "result", 701, 22389, 22418);
                for (int i = 0; i < (refs.length); i++) {
                    TryContext _bcornu_try_context_368 = new TryContext(368, BundleImpl.class, "java.lang.Exception");
                    try {
                        ((SecurityManager) (sm)).checkPermission(new ServicePermission(refs[i], ServicePermission.GET));
                        if (CallChecker.beforeDeref(result, List.class, 710, 22684, 22689)) {
                            result = CallChecker.beforeCalled(result, List.class, 710, 22684, 22689);
                            CallChecker.isCalled(result, List.class, 710, 22684, 22689).add(refs[i]);
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_368.catchStart(368);
                    } finally {
                        _bcornu_try_context_368.finallyStart(368);
                    }
                }
                if (CallChecker.beforeDeref(result, List.class, 718, 22867, 22872)) {
                    result = CallChecker.beforeCalled(result, List.class, 718, 22867, 22872);
                    if (CallChecker.isCalled(result, List.class, 718, 22867, 22872).isEmpty()) {
                        return null;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(result, List.class, 723, 23019, 23024)) {
                    if (CallChecker.beforeDeref(result, List.class, 723, 22983, 22988)) {
                        result = CallChecker.beforeCalled(result, List.class, 723, 23019, 23024);
                        result = CallChecker.beforeCalled(result, List.class, 723, 22983, 22988);
                        return ((ServiceReference[]) (CallChecker.isCalled(result, List.class, 723, 22983, 22988).toArray(new ServiceReference[CallChecker.isCalled(result, List.class, 723, 23019, 23024).size()])));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                final Felix npe_invocation_var478 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var478, Felix.class, 727, 23088, 23101)) {
                    return CallChecker.isCalled(npe_invocation_var478, Felix.class, 727, 23088, 23101).getBundleRegisteredServices(this);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1328.methodEnd();
        }
    }

    public ServiceReference[] getServicesInUse() {
        MethodContext _bcornu_methode_context1329 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 731, 23159, 24200);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 731, 23159, 24200);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 731, 23159, 24200);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 731, 23159, 24200);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 731, 23159, 24200);
            CallChecker.varInit(this.m_stale, "m_stale", 731, 23159, 24200);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 731, 23159, 24200);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 731, 23159, 24200);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 731, 23159, 24200);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 731, 23159, 24200);
            CallChecker.varInit(this.m_context, "m_context", 731, 23159, 24200);
            CallChecker.varInit(this.m_activator, "m_activator", 731, 23159, 24200);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 731, 23159, 24200);
            CallChecker.varInit(this.m_state, "m_state", 731, 23159, 24200);
            CallChecker.varInit(this.m_revisions, "m_revisions", 731, 23159, 24200);
            CallChecker.varInit(this.m_archive, "m_archive", 731, 23159, 24200);
            CallChecker.varInit(this.__m_felix, "__m_felix", 731, 23159, 24200);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 733, 23218, 23257);
            if (sm != null) {
                final Felix npe_invocation_var479 = getFramework();
                ServiceReference[] refs = CallChecker.init(ServiceReference[].class);
                if (CallChecker.beforeDeref(npe_invocation_var479, Felix.class, 737, 23332, 23345)) {
                    refs = CallChecker.isCalled(npe_invocation_var479, Felix.class, 737, 23332, 23345).getBundleServicesInUse(this);
                    CallChecker.varAssign(refs, "refs", 737, 23332, 23345);
                }
                if (refs == null) {
                    return refs;
                }
                List result = CallChecker.varInit(new ArrayList(), "result", 744, 23478, 23507);
                for (int i = 0; i < (refs.length); i++) {
                    TryContext _bcornu_try_context_369 = new TryContext(369, BundleImpl.class, "java.lang.Exception");
                    try {
                        ((SecurityManager) (sm)).checkPermission(new ServicePermission(refs[i], ServicePermission.GET));
                        if (CallChecker.beforeDeref(result, List.class, 753, 23773, 23778)) {
                            result = CallChecker.beforeCalled(result, List.class, 753, 23773, 23778);
                            CallChecker.isCalled(result, List.class, 753, 23773, 23778).add(refs[i]);
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_369.catchStart(369);
                    } finally {
                        _bcornu_try_context_369.finallyStart(369);
                    }
                }
                if (CallChecker.beforeDeref(result, List.class, 761, 23956, 23961)) {
                    result = CallChecker.beforeCalled(result, List.class, 761, 23956, 23961);
                    if (CallChecker.isCalled(result, List.class, 761, 23956, 23961).isEmpty()) {
                        return null;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(result, List.class, 766, 24108, 24113)) {
                    if (CallChecker.beforeDeref(result, List.class, 766, 24072, 24077)) {
                        result = CallChecker.beforeCalled(result, List.class, 766, 24108, 24113);
                        result = CallChecker.beforeCalled(result, List.class, 766, 24072, 24077);
                        return ((ServiceReference[]) (CallChecker.isCalled(result, List.class, 766, 24072, 24077).toArray(new ServiceReference[CallChecker.isCalled(result, List.class, 766, 24108, 24113).size()])));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            final Felix npe_invocation_var480 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var480, Felix.class, 769, 24151, 24164)) {
                return CallChecker.isCalled(npe_invocation_var480, Felix.class, 769, 24151, 24164).getBundleServicesInUse(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1329.methodEnd();
        }
    }

    public int getState() {
        MethodContext _bcornu_methode_context1330 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 772, 24207, 24263);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 772, 24207, 24263);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 772, 24207, 24263);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 772, 24207, 24263);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 772, 24207, 24263);
            CallChecker.varInit(this.m_stale, "m_stale", 772, 24207, 24263);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 772, 24207, 24263);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 772, 24207, 24263);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 772, 24207, 24263);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 772, 24207, 24263);
            CallChecker.varInit(this.m_context, "m_context", 772, 24207, 24263);
            CallChecker.varInit(this.m_activator, "m_activator", 772, 24207, 24263);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 772, 24207, 24263);
            CallChecker.varInit(this.m_state, "m_state", 772, 24207, 24263);
            CallChecker.varInit(this.m_revisions, "m_revisions", 772, 24207, 24263);
            CallChecker.varInit(this.m_archive, "m_archive", 772, 24207, 24263);
            CallChecker.varInit(this.__m_felix, "__m_felix", 772, 24207, 24263);
            return m_state;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1330.methodEnd();
        }
    }

    void __setState(int i) {
        MethodContext _bcornu_methode_context1331 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 778, 24270, 24374);
            CallChecker.varInit(i, "i", 778, 24270, 24374);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 778, 24270, 24374);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 778, 24270, 24374);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 778, 24270, 24374);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 778, 24270, 24374);
            CallChecker.varInit(this.m_stale, "m_stale", 778, 24270, 24374);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 778, 24270, 24374);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 778, 24270, 24374);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 778, 24270, 24374);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 778, 24270, 24374);
            CallChecker.varInit(this.m_context, "m_context", 778, 24270, 24374);
            CallChecker.varInit(this.m_activator, "m_activator", 778, 24270, 24374);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 778, 24270, 24374);
            CallChecker.varInit(this.m_state, "m_state", 778, 24270, 24374);
            CallChecker.varInit(this.m_revisions, "m_revisions", 778, 24270, 24374);
            CallChecker.varInit(this.m_archive, "m_archive", 778, 24270, 24374);
            CallChecker.varInit(this.__m_felix, "__m_felix", 778, 24270, 24374);
            m_state = i;
            CallChecker.varAssign(this.m_state, "this.m_state", 780, 24357, 24368);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1331.methodEnd();
        }
    }

    int getPersistentState() {
        MethodContext _bcornu_methode_context1332 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 783, 24381, 24777);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 783, 24381, 24777);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 783, 24381, 24777);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 783, 24381, 24777);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 783, 24381, 24777);
            CallChecker.varInit(this.m_stale, "m_stale", 783, 24381, 24777);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 783, 24381, 24777);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 783, 24381, 24777);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 783, 24381, 24777);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 783, 24381, 24777);
            CallChecker.varInit(this.m_context, "m_context", 783, 24381, 24777);
            CallChecker.varInit(this.m_activator, "m_activator", 783, 24381, 24777);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 783, 24381, 24777);
            CallChecker.varInit(this.m_state, "m_state", 783, 24381, 24777);
            CallChecker.varInit(this.m_revisions, "m_revisions", 783, 24381, 24777);
            CallChecker.varInit(this.m_archive, "m_archive", 783, 24381, 24777);
            CallChecker.varInit(this.__m_felix, "__m_felix", 783, 24381, 24777);
            TryContext _bcornu_try_context_370 = new TryContext(370, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 787, 24453, 24461)) {
                    return CallChecker.isCalled(m_archive, BundleArchive.class, 787, 24453, 24461).getPersistentState();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_370.catchStart(370);
                final Felix npe_invocation_var481 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var481, Felix.class, 791, 24546, 24559)) {
                    final Logger npe_invocation_var482 = CallChecker.isCalled(npe_invocation_var481, Felix.class, 791, 24546, 24559).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var482, Logger.class, 791, 24546, 24571)) {
                        CallChecker.isCalled(npe_invocation_var482, Logger.class, 791, 24546, 24571).log(this, Logger.LOG_ERROR, "Error reading persistent state from bundle archive.", ex);
                    }
                }
                return Bundle.INSTALLED;
            } finally {
                _bcornu_try_context_370.finallyStart(370);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1332.methodEnd();
        }
    }

    void setPersistentStateInactive() {
        MethodContext _bcornu_methode_context1333 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 800, 24784, 25126);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 800, 24784, 25126);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 800, 24784, 25126);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 800, 24784, 25126);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 800, 24784, 25126);
            CallChecker.varInit(this.m_stale, "m_stale", 800, 24784, 25126);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 800, 24784, 25126);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 800, 24784, 25126);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 800, 24784, 25126);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 800, 24784, 25126);
            CallChecker.varInit(this.m_context, "m_context", 800, 24784, 25126);
            CallChecker.varInit(this.m_activator, "m_activator", 800, 24784, 25126);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 800, 24784, 25126);
            CallChecker.varInit(this.m_state, "m_state", 800, 24784, 25126);
            CallChecker.varInit(this.m_revisions, "m_revisions", 800, 24784, 25126);
            CallChecker.varInit(this.m_archive, "m_archive", 800, 24784, 25126);
            CallChecker.varInit(this.__m_felix, "__m_felix", 800, 24784, 25126);
            TryContext _bcornu_try_context_371 = new TryContext(371, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 804, 24858, 24866)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 804, 24858, 24866).setPersistentState(Bundle.INSTALLED);
                }
            } catch (Exception ex) {
                _bcornu_try_context_371.catchStart(371);
                final Felix npe_invocation_var483 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var483, Felix.class, 808, 24967, 24980)) {
                    final Logger npe_invocation_var484 = CallChecker.isCalled(npe_invocation_var483, Felix.class, 808, 24967, 24980).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var484, Logger.class, 808, 24967, 24992)) {
                        CallChecker.isCalled(npe_invocation_var484, Logger.class, 808, 24967, 24992).log(this, Logger.LOG_ERROR, "Error writing persistent state to bundle archive.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_371.finallyStart(371);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1333.methodEnd();
        }
    }

    void setPersistentStateActive() {
        MethodContext _bcornu_methode_context1334 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 814, 25133, 25503);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 814, 25133, 25503);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 814, 25133, 25503);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 814, 25133, 25503);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 814, 25133, 25503);
            CallChecker.varInit(this.m_stale, "m_stale", 814, 25133, 25503);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 814, 25133, 25503);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 814, 25133, 25503);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 814, 25133, 25503);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 814, 25133, 25503);
            CallChecker.varInit(this.m_context, "m_context", 814, 25133, 25503);
            CallChecker.varInit(this.m_activator, "m_activator", 814, 25133, 25503);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 814, 25133, 25503);
            CallChecker.varInit(this.m_state, "m_state", 814, 25133, 25503);
            CallChecker.varInit(this.m_revisions, "m_revisions", 814, 25133, 25503);
            CallChecker.varInit(this.m_archive, "m_archive", 814, 25133, 25503);
            CallChecker.varInit(this.__m_felix, "__m_felix", 814, 25133, 25503);
            TryContext _bcornu_try_context_372 = new TryContext(372, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 818, 25205, 25213)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 818, 25205, 25213).setPersistentState(Bundle.ACTIVE);
                }
            } catch (Exception ex) {
                _bcornu_try_context_372.catchStart(372);
                final Felix npe_invocation_var485 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var485, Felix.class, 822, 25311, 25324)) {
                    final Logger npe_invocation_var486 = CallChecker.isCalled(npe_invocation_var485, Felix.class, 822, 25311, 25324).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var486, Logger.class, 822, 25311, 25336)) {
                        CallChecker.isCalled(npe_invocation_var486, Logger.class, 822, 25311, 25336).log(this, Logger.LOG_ERROR, "Error writing persistent state to bundle archive.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_372.finallyStart(372);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1334.methodEnd();
        }
    }

    void setPersistentStateStarting() {
        MethodContext _bcornu_methode_context1335 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 830, 25510, 25884);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 830, 25510, 25884);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 830, 25510, 25884);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 830, 25510, 25884);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 830, 25510, 25884);
            CallChecker.varInit(this.m_stale, "m_stale", 830, 25510, 25884);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 830, 25510, 25884);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 830, 25510, 25884);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 830, 25510, 25884);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 830, 25510, 25884);
            CallChecker.varInit(this.m_context, "m_context", 830, 25510, 25884);
            CallChecker.varInit(this.m_activator, "m_activator", 830, 25510, 25884);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 830, 25510, 25884);
            CallChecker.varInit(this.m_state, "m_state", 830, 25510, 25884);
            CallChecker.varInit(this.m_revisions, "m_revisions", 830, 25510, 25884);
            CallChecker.varInit(this.m_archive, "m_archive", 830, 25510, 25884);
            CallChecker.varInit(this.__m_felix, "__m_felix", 830, 25510, 25884);
            TryContext _bcornu_try_context_373 = new TryContext(373, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 834, 25584, 25592)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 834, 25584, 25592).setPersistentState(Bundle.STARTING);
                }
            } catch (Exception ex) {
                _bcornu_try_context_373.catchStart(373);
                final Felix npe_invocation_var487 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var487, Felix.class, 838, 25692, 25705)) {
                    final Logger npe_invocation_var488 = CallChecker.isCalled(npe_invocation_var487, Felix.class, 838, 25692, 25705).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var488, Logger.class, 838, 25692, 25717)) {
                        CallChecker.isCalled(npe_invocation_var488, Logger.class, 838, 25692, 25717).log(this, Logger.LOG_ERROR, "Error writing persistent state to bundle archive.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_373.finallyStart(373);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1335.methodEnd();
        }
    }

    void setPersistentStateUninstalled() {
        MethodContext _bcornu_methode_context1336 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 845, 25890, 26270);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 845, 25890, 26270);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 845, 25890, 26270);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 845, 25890, 26270);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 845, 25890, 26270);
            CallChecker.varInit(this.m_stale, "m_stale", 845, 25890, 26270);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 845, 25890, 26270);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 845, 25890, 26270);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 845, 25890, 26270);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 845, 25890, 26270);
            CallChecker.varInit(this.m_context, "m_context", 845, 25890, 26270);
            CallChecker.varInit(this.m_activator, "m_activator", 845, 25890, 26270);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 845, 25890, 26270);
            CallChecker.varInit(this.m_state, "m_state", 845, 25890, 26270);
            CallChecker.varInit(this.m_revisions, "m_revisions", 845, 25890, 26270);
            CallChecker.varInit(this.m_archive, "m_archive", 845, 25890, 26270);
            CallChecker.varInit(this.__m_felix, "__m_felix", 845, 25890, 26270);
            TryContext _bcornu_try_context_374 = new TryContext(374, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 849, 25967, 25975)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 849, 25967, 25975).setPersistentState(Bundle.UNINSTALLED);
                }
            } catch (Exception ex) {
                _bcornu_try_context_374.catchStart(374);
                final Felix npe_invocation_var489 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var489, Felix.class, 853, 26078, 26091)) {
                    final Logger npe_invocation_var490 = CallChecker.isCalled(npe_invocation_var489, Felix.class, 853, 26078, 26091).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var490, Logger.class, 853, 26078, 26103)) {
                        CallChecker.isCalled(npe_invocation_var490, Logger.class, 853, 26078, 26103).log(this, Logger.LOG_ERROR, "Error writing persistent state to bundle archive.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_374.finallyStart(374);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1336.methodEnd();
        }
    }

    int getStartLevel(int defaultLevel) {
        MethodContext _bcornu_methode_context1337 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 861, 26277, 26798);
            CallChecker.varInit(defaultLevel, "defaultLevel", 861, 26277, 26798);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 861, 26277, 26798);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 861, 26277, 26798);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 861, 26277, 26798);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 861, 26277, 26798);
            CallChecker.varInit(this.m_stale, "m_stale", 861, 26277, 26798);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 861, 26277, 26798);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 861, 26277, 26798);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 861, 26277, 26798);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 861, 26277, 26798);
            CallChecker.varInit(this.m_context, "m_context", 861, 26277, 26798);
            CallChecker.varInit(this.m_activator, "m_activator", 861, 26277, 26798);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 861, 26277, 26798);
            CallChecker.varInit(this.m_state, "m_state", 861, 26277, 26798);
            CallChecker.varInit(this.m_revisions, "m_revisions", 861, 26277, 26798);
            CallChecker.varInit(this.m_archive, "m_archive", 861, 26277, 26798);
            CallChecker.varInit(this.__m_felix, "__m_felix", 861, 26277, 26798);
            TryContext _bcornu_try_context_375 = new TryContext(375, BundleImpl.class, "java.lang.Exception");
            try {
                int level = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 865, 26365, 26373)) {
                    level = CallChecker.isCalled(m_archive, BundleArchive.class, 865, 26365, 26373).getStartLevel();
                    CallChecker.varAssign(level, "level", 865, 26365, 26373);
                }
                if (level == (-1)) {
                    level = defaultLevel;
                    CallChecker.varAssign(level, "level", 868, 26453, 26473);
                }
                return level;
            } catch (Exception ex) {
                _bcornu_try_context_375.catchStart(375);
                final Felix npe_invocation_var491 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var491, Felix.class, 874, 26576, 26589)) {
                    final Logger npe_invocation_var492 = CallChecker.isCalled(npe_invocation_var491, Felix.class, 874, 26576, 26589).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var492, Logger.class, 874, 26576, 26601)) {
                        CallChecker.isCalled(npe_invocation_var492, Logger.class, 874, 26576, 26601).log(this, Logger.LOG_ERROR, "Error reading start level from bundle archive.", ex);
                    }
                }
                return defaultLevel;
            } finally {
                _bcornu_try_context_375.finallyStart(375);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1337.methodEnd();
        }
    }

    void setStartLevel(int i) {
        MethodContext _bcornu_methode_context1338 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 883, 26805, 27147);
            CallChecker.varInit(i, "i", 883, 26805, 27147);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 883, 26805, 27147);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 883, 26805, 27147);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 883, 26805, 27147);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 883, 26805, 27147);
            CallChecker.varInit(this.m_stale, "m_stale", 883, 26805, 27147);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 883, 26805, 27147);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 883, 26805, 27147);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 883, 26805, 27147);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 883, 26805, 27147);
            CallChecker.varInit(this.m_context, "m_context", 883, 26805, 27147);
            CallChecker.varInit(this.m_activator, "m_activator", 883, 26805, 27147);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 883, 26805, 27147);
            CallChecker.varInit(this.m_state, "m_state", 883, 26805, 27147);
            CallChecker.varInit(this.m_revisions, "m_revisions", 883, 26805, 27147);
            CallChecker.varInit(this.m_archive, "m_archive", 883, 26805, 27147);
            CallChecker.varInit(this.__m_felix, "__m_felix", 883, 26805, 27147);
            TryContext _bcornu_try_context_376 = new TryContext(376, BundleImpl.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 887, 26871, 26879)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 887, 26871, 26879).setStartLevel(i);
                }
            } catch (Exception ex) {
                _bcornu_try_context_376.catchStart(376);
                final Felix npe_invocation_var493 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var493, Felix.class, 891, 26960, 26973)) {
                    final Logger npe_invocation_var494 = CallChecker.isCalled(npe_invocation_var493, Felix.class, 891, 26960, 26973).getLogger();
                    if (CallChecker.beforeDeref(npe_invocation_var494, Logger.class, 891, 26960, 26985)) {
                        CallChecker.isCalled(npe_invocation_var494, Logger.class, 891, 26960, 26985).log(this, Logger.LOG_ERROR, "Error writing start level to bundle archive.", ex);
                    }
                }
            } finally {
                _bcornu_try_context_376.finallyStart(376);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1338.methodEnd();
        }
    }

    synchronized boolean isStale() {
        MethodContext _bcornu_methode_context1339 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 899, 27154, 27219);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 899, 27154, 27219);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 899, 27154, 27219);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 899, 27154, 27219);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 899, 27154, 27219);
            CallChecker.varInit(this.m_stale, "m_stale", 899, 27154, 27219);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 899, 27154, 27219);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 899, 27154, 27219);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 899, 27154, 27219);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 899, 27154, 27219);
            CallChecker.varInit(this.m_context, "m_context", 899, 27154, 27219);
            CallChecker.varInit(this.m_activator, "m_activator", 899, 27154, 27219);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 899, 27154, 27219);
            CallChecker.varInit(this.m_state, "m_state", 899, 27154, 27219);
            CallChecker.varInit(this.m_revisions, "m_revisions", 899, 27154, 27219);
            CallChecker.varInit(this.m_archive, "m_archive", 899, 27154, 27219);
            CallChecker.varInit(this.__m_felix, "__m_felix", 899, 27154, 27219);
            return m_stale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1339.methodEnd();
        }
    }

    synchronized boolean isExtension() {
        MethodContext _bcornu_methode_context1340 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 904, 27226, 27485);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 904, 27226, 27485);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 904, 27226, 27485);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 904, 27226, 27485);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 904, 27226, 27485);
            CallChecker.varInit(this.m_stale, "m_stale", 904, 27226, 27485);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 904, 27226, 27485);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 904, 27226, 27485);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 904, 27226, 27485);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 904, 27226, 27485);
            CallChecker.varInit(this.m_context, "m_context", 904, 27226, 27485);
            CallChecker.varInit(this.m_activator, "m_activator", 904, 27226, 27485);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 904, 27226, 27485);
            CallChecker.varInit(this.m_state, "m_state", 904, 27226, 27485);
            CallChecker.varInit(this.m_revisions, "m_revisions", 904, 27226, 27485);
            CallChecker.varInit(this.m_archive, "m_archive", 904, 27226, 27485);
            CallChecker.varInit(this.__m_felix, "__m_felix", 904, 27226, 27485);
            if (CallChecker.beforeDeref(m_revisions, boolean.class, 906, 27306, 27316)) {
                for (BundleRevision revision : m_revisions) {
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 908, 27367, 27374)) {
                        if (CallChecker.isCalled(((BundleRevisionImpl) (revision)), BundleRevisionImpl.class, 908, 27367, 27374).isExtension()) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1340.methodEnd();
        }
    }

    public String getSymbolicName() {
        MethodContext _bcornu_methode_context1341 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 916, 27492, 27600);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 916, 27492, 27600);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 916, 27492, 27600);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 916, 27492, 27600);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 916, 27492, 27600);
            CallChecker.varInit(this.m_stale, "m_stale", 916, 27492, 27600);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 916, 27492, 27600);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 916, 27492, 27600);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 916, 27492, 27600);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 916, 27492, 27600);
            CallChecker.varInit(this.m_context, "m_context", 916, 27492, 27600);
            CallChecker.varInit(this.m_activator, "m_activator", 916, 27492, 27600);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 916, 27492, 27600);
            CallChecker.varInit(this.m_state, "m_state", 916, 27492, 27600);
            CallChecker.varInit(this.m_revisions, "m_revisions", 916, 27492, 27600);
            CallChecker.varInit(this.m_archive, "m_archive", 916, 27492, 27600);
            CallChecker.varInit(this.__m_felix, "__m_felix", 916, 27492, 27600);
            final BundleRevisionImpl npe_invocation_var495 = adapt(BundleRevisionImpl.class);
            if (CallChecker.beforeDeref(npe_invocation_var495, BundleRevisionImpl.class, 918, 27545, 27575)) {
                return CallChecker.isCalled(npe_invocation_var495, BundleRevisionImpl.class, 918, 27545, 27575).getSymbolicName();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1341.methodEnd();
        }
    }

    public Version getVersion() {
        MethodContext _bcornu_methode_context1342 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 921, 27607, 27706);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 921, 27607, 27706);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 921, 27607, 27706);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 921, 27607, 27706);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 921, 27607, 27706);
            CallChecker.varInit(this.m_stale, "m_stale", 921, 27607, 27706);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 921, 27607, 27706);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 921, 27607, 27706);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 921, 27607, 27706);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 921, 27607, 27706);
            CallChecker.varInit(this.m_context, "m_context", 921, 27607, 27706);
            CallChecker.varInit(this.m_activator, "m_activator", 921, 27607, 27706);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 921, 27607, 27706);
            CallChecker.varInit(this.m_state, "m_state", 921, 27607, 27706);
            CallChecker.varInit(this.m_revisions, "m_revisions", 921, 27607, 27706);
            CallChecker.varInit(this.m_archive, "m_archive", 921, 27607, 27706);
            CallChecker.varInit(this.__m_felix, "__m_felix", 921, 27607, 27706);
            final BundleRevisionImpl npe_invocation_var496 = adapt(BundleRevisionImpl.class);
            if (CallChecker.beforeDeref(npe_invocation_var496, BundleRevisionImpl.class, 923, 27656, 27686)) {
                return CallChecker.isCalled(npe_invocation_var496, BundleRevisionImpl.class, 923, 27656, 27686).getVersion();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1342.methodEnd();
        }
    }

    public boolean hasPermission(Object obj) {
        MethodContext _bcornu_methode_context1343 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 926, 27713, 27826);
            CallChecker.varInit(obj, "obj", 926, 27713, 27826);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 926, 27713, 27826);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 926, 27713, 27826);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 926, 27713, 27826);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 926, 27713, 27826);
            CallChecker.varInit(this.m_stale, "m_stale", 926, 27713, 27826);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 926, 27713, 27826);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 926, 27713, 27826);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 926, 27713, 27826);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 926, 27713, 27826);
            CallChecker.varInit(this.m_context, "m_context", 926, 27713, 27826);
            CallChecker.varInit(this.m_activator, "m_activator", 926, 27713, 27826);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 926, 27713, 27826);
            CallChecker.varInit(this.m_state, "m_state", 926, 27713, 27826);
            CallChecker.varInit(this.m_revisions, "m_revisions", 926, 27713, 27826);
            CallChecker.varInit(this.m_archive, "m_archive", 926, 27713, 27826);
            CallChecker.varInit(this.__m_felix, "__m_felix", 926, 27713, 27826);
            final Felix npe_invocation_var497 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var497, Felix.class, 928, 27775, 27788)) {
                return CallChecker.isCalled(npe_invocation_var497, Felix.class, 928, 27775, 27788).bundleHasPermission(this, obj);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1343.methodEnd();
        }
    }

    public Map getSignerCertificates(int signersType) {
        MethodContext _bcornu_methode_context1344 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 931, 27833, 28047);
            CallChecker.varInit(signersType, "signersType", 931, 27833, 28047);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 931, 27833, 28047);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 931, 27833, 28047);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 931, 27833, 28047);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 931, 27833, 28047);
            CallChecker.varInit(this.m_stale, "m_stale", 931, 27833, 28047);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 931, 27833, 28047);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 931, 27833, 28047);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 931, 27833, 28047);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 931, 27833, 28047);
            CallChecker.varInit(this.m_context, "m_context", 931, 27833, 28047);
            CallChecker.varInit(this.m_activator, "m_activator", 931, 27833, 28047);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 931, 27833, 28047);
            CallChecker.varInit(this.m_state, "m_state", 931, 27833, 28047);
            CallChecker.varInit(this.m_revisions, "m_revisions", 931, 27833, 28047);
            CallChecker.varInit(this.m_archive, "m_archive", 931, 27833, 28047);
            CallChecker.varInit(this.__m_felix, "__m_felix", 931, 27833, 28047);
            final Felix npe_invocation_var498 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var498, Felix.class, 934, 27991, 28004)) {
                return ((Map) (CallChecker.isCalled(npe_invocation_var498, Felix.class, 934, 27991, 28004).getSignerMatcher(this, signersType)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1344.methodEnd();
        }
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context1345 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(this, "this", 937, 28054, 28723);
            CallChecker.varInit(name, "name", 937, 28054, 28723);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 937, 28054, 28723);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 937, 28054, 28723);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 937, 28054, 28723);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 937, 28054, 28723);
            CallChecker.varInit(this.m_stale, "m_stale", 937, 28054, 28723);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 937, 28054, 28723);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 937, 28054, 28723);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 937, 28054, 28723);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 937, 28054, 28723);
            CallChecker.varInit(this.m_context, "m_context", 937, 28054, 28723);
            CallChecker.varInit(this.m_activator, "m_activator", 937, 28054, 28723);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 937, 28054, 28723);
            CallChecker.varInit(this.m_state, "m_state", 937, 28054, 28723);
            CallChecker.varInit(this.m_revisions, "m_revisions", 937, 28054, 28723);
            CallChecker.varInit(this.m_archive, "m_archive", 937, 28054, 28723);
            CallChecker.varInit(this.__m_felix, "__m_felix", 937, 28054, 28723);
            if (isExtension()) {
                throw new ClassNotFoundException("Extension bundles cannot load classes.");
            }
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 944, 28270, 28309);
            if (sm != null) {
                TryContext _bcornu_try_context_377 = new TryContext(377, BundleImpl.class, "java.lang.Exception");
                try {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.CLASS));
                } catch (Exception ex) {
                    _bcornu_try_context_377.catchStart(377);
                    throw new ClassNotFoundException("No permission.", ex);
                } finally {
                    _bcornu_try_context_377.finallyStart(377);
                }
            }
            final Felix npe_invocation_var499 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var499, Felix.class, 959, 28675, 28688)) {
                return CallChecker.isCalled(npe_invocation_var499, Felix.class, 959, 28675, 28688).loadBundleClass(this, name);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1345.methodEnd();
        }
    }

    public void start() throws BundleException {
        MethodContext _bcornu_methode_context1346 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 962, 28730, 28801);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 962, 28730, 28801);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 962, 28730, 28801);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 962, 28730, 28801);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 962, 28730, 28801);
            CallChecker.varInit(this.m_stale, "m_stale", 962, 28730, 28801);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 962, 28730, 28801);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 962, 28730, 28801);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 962, 28730, 28801);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 962, 28730, 28801);
            CallChecker.varInit(this.m_context, "m_context", 962, 28730, 28801);
            CallChecker.varInit(this.m_activator, "m_activator", 962, 28730, 28801);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 962, 28730, 28801);
            CallChecker.varInit(this.m_state, "m_state", 962, 28730, 28801);
            CallChecker.varInit(this.m_revisions, "m_revisions", 962, 28730, 28801);
            CallChecker.varInit(this.m_archive, "m_archive", 962, 28730, 28801);
            CallChecker.varInit(this.__m_felix, "__m_felix", 962, 28730, 28801);
            start(0);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1346.methodEnd();
        }
    }

    public void start(int options) throws BundleException {
        MethodContext _bcornu_methode_context1347 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 967, 28808, 29138);
            CallChecker.varInit(options, "options", 967, 28808, 29138);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 967, 28808, 29138);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 967, 28808, 29138);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 967, 28808, 29138);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 967, 28808, 29138);
            CallChecker.varInit(this.m_stale, "m_stale", 967, 28808, 29138);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 967, 28808, 29138);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 967, 28808, 29138);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 967, 28808, 29138);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 967, 28808, 29138);
            CallChecker.varInit(this.m_context, "m_context", 967, 28808, 29138);
            CallChecker.varInit(this.m_activator, "m_activator", 967, 28808, 29138);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 967, 28808, 29138);
            CallChecker.varInit(this.m_state, "m_state", 967, 28808, 29138);
            CallChecker.varInit(this.m_revisions, "m_revisions", 967, 28808, 29138);
            CallChecker.varInit(this.m_archive, "m_archive", 967, 28808, 29138);
            CallChecker.varInit(this.__m_felix, "__m_felix", 967, 28808, 29138);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 969, 28876, 28915);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.EXECUTE));
            }
            final Felix npe_invocation_var500 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var500, Felix.class, 977, 29091, 29104)) {
                CallChecker.isCalled(npe_invocation_var500, Felix.class, 977, 29091, 29104).startBundle(this, options);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1347.methodEnd();
        }
    }

    public void update() throws BundleException {
        MethodContext _bcornu_methode_context1348 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 980, 29145, 29221);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 980, 29145, 29221);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 980, 29145, 29221);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 980, 29145, 29221);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 980, 29145, 29221);
            CallChecker.varInit(this.m_stale, "m_stale", 980, 29145, 29221);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 980, 29145, 29221);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 980, 29145, 29221);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 980, 29145, 29221);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 980, 29145, 29221);
            CallChecker.varInit(this.m_context, "m_context", 980, 29145, 29221);
            CallChecker.varInit(this.m_activator, "m_activator", 980, 29145, 29221);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 980, 29145, 29221);
            CallChecker.varInit(this.m_state, "m_state", 980, 29145, 29221);
            CallChecker.varInit(this.m_revisions, "m_revisions", 980, 29145, 29221);
            CallChecker.varInit(this.m_archive, "m_archive", 980, 29145, 29221);
            CallChecker.varInit(this.__m_felix, "__m_felix", 980, 29145, 29221);
            update(null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1348.methodEnd();
        }
    }

    public void update(InputStream is) throws BundleException {
        MethodContext _bcornu_methode_context1349 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 985, 29228, 29560);
            CallChecker.varInit(is, "is", 985, 29228, 29560);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 985, 29228, 29560);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 985, 29228, 29560);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 985, 29228, 29560);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 985, 29228, 29560);
            CallChecker.varInit(this.m_stale, "m_stale", 985, 29228, 29560);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 985, 29228, 29560);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 985, 29228, 29560);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 985, 29228, 29560);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 985, 29228, 29560);
            CallChecker.varInit(this.m_context, "m_context", 985, 29228, 29560);
            CallChecker.varInit(this.m_activator, "m_activator", 985, 29228, 29560);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 985, 29228, 29560);
            CallChecker.varInit(this.m_state, "m_state", 985, 29228, 29560);
            CallChecker.varInit(this.m_revisions, "m_revisions", 985, 29228, 29560);
            CallChecker.varInit(this.m_archive, "m_archive", 985, 29228, 29560);
            CallChecker.varInit(this.__m_felix, "__m_felix", 985, 29228, 29560);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 987, 29300, 29339);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.LIFECYCLE));
            }
            final Felix npe_invocation_var501 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var501, Felix.class, 995, 29517, 29530)) {
                CallChecker.isCalled(npe_invocation_var501, Felix.class, 995, 29517, 29530).updateBundle(this, is);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1349.methodEnd();
        }
    }

    public void stop() throws BundleException {
        MethodContext _bcornu_methode_context1350 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 998, 29567, 29636);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 998, 29567, 29636);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 998, 29567, 29636);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 998, 29567, 29636);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 998, 29567, 29636);
            CallChecker.varInit(this.m_stale, "m_stale", 998, 29567, 29636);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 998, 29567, 29636);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 998, 29567, 29636);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 998, 29567, 29636);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 998, 29567, 29636);
            CallChecker.varInit(this.m_context, "m_context", 998, 29567, 29636);
            CallChecker.varInit(this.m_activator, "m_activator", 998, 29567, 29636);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 998, 29567, 29636);
            CallChecker.varInit(this.m_state, "m_state", 998, 29567, 29636);
            CallChecker.varInit(this.m_revisions, "m_revisions", 998, 29567, 29636);
            CallChecker.varInit(this.m_archive, "m_archive", 998, 29567, 29636);
            CallChecker.varInit(this.__m_felix, "__m_felix", 998, 29567, 29636);
            stop(0);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1350.methodEnd();
        }
    }

    public void stop(int options) throws BundleException {
        MethodContext _bcornu_methode_context1351 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1003, 29643, 30004);
            CallChecker.varInit(options, "options", 1003, 29643, 30004);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1003, 29643, 30004);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1003, 29643, 30004);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1003, 29643, 30004);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1003, 29643, 30004);
            CallChecker.varInit(this.m_stale, "m_stale", 1003, 29643, 30004);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1003, 29643, 30004);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1003, 29643, 30004);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1003, 29643, 30004);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1003, 29643, 30004);
            CallChecker.varInit(this.m_context, "m_context", 1003, 29643, 30004);
            CallChecker.varInit(this.m_activator, "m_activator", 1003, 29643, 30004);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1003, 29643, 30004);
            CallChecker.varInit(this.m_state, "m_state", 1003, 29643, 30004);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1003, 29643, 30004);
            CallChecker.varInit(this.m_archive, "m_archive", 1003, 29643, 30004);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1003, 29643, 30004);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 1005, 29710, 29749);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.EXECUTE));
            }
            final Felix npe_invocation_var502 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var502, Felix.class, 1013, 29925, 29938)) {
                CallChecker.isCalled(npe_invocation_var502, Felix.class, 1013, 29925, 29938).stopBundle(this, ((options & (Bundle.STOP_TRANSIENT)) == 0));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1351.methodEnd();
        }
    }

    public void uninstall() throws BundleException {
        MethodContext _bcornu_methode_context1352 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1016, 30011, 31276);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1016, 30011, 31276);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1016, 30011, 31276);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1016, 30011, 31276);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1016, 30011, 31276);
            CallChecker.varInit(this.m_stale, "m_stale", 1016, 30011, 31276);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1016, 30011, 31276);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1016, 30011, 31276);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1016, 30011, 31276);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1016, 30011, 31276);
            CallChecker.varInit(this.m_context, "m_context", 1016, 30011, 31276);
            CallChecker.varInit(this.m_activator, "m_activator", 1016, 30011, 31276);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1016, 30011, 31276);
            CallChecker.varInit(this.m_state, "m_state", 1016, 30011, 31276);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1016, 30011, 31276);
            CallChecker.varInit(this.m_archive, "m_archive", 1016, 30011, 31276);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1016, 30011, 31276);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 1018, 30072, 30111);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(this, AdminPermission.LIFECYCLE));
            }
            Map headers = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(Locale.getDefault(), Locale.class, 1026, 30329, 30347)) {
                headers = getCurrentLocalizedHeader(CallChecker.isCalled(Locale.getDefault(), Locale.class, 1026, 30329, 30347).toString());
                CallChecker.varAssign(headers, "headers", 1026, 30329, 30347);
            }
            final Felix npe_invocation_var503 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var503, Felix.class, 1029, 30404, 30417)) {
                CallChecker.isCalled(npe_invocation_var503, Felix.class, 1029, 30404, 30417).uninstallBundle(this);
            }
            synchronized(m_cachedHeaders) {
                if ((m_uninstalledHeaders) == null) {
                    m_uninstalledHeaders = headers;
                    CallChecker.varAssign(this.m_uninstalledHeaders, "this.m_uninstalledHeaders", 1043, 31175, 31205);
                    if (CallChecker.beforeDeref(m_cachedHeaders, Map.class, 1044, 31223, 31237)) {
                        CallChecker.isCalled(m_cachedHeaders, Map.class, 1044, 31223, 31237).clear();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1352.methodEnd();
        }
    }

    private static final SecurityManagerEx m_smEx = new SecurityManagerEx();

    private static final ClassLoader m_classloader = Felix.class.getClassLoader();

    <A> void checkAdapt(Class<A> type) {
        MethodContext _bcornu_methode_context1353 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1052, 31444, 32022);
            CallChecker.varInit(type, "type", 1052, 31444, 32022);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1052, 31444, 32022);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1052, 31444, 32022);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1052, 31444, 32022);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1052, 31444, 32022);
            CallChecker.varInit(this.m_stale, "m_stale", 1052, 31444, 32022);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1052, 31444, 32022);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1052, 31444, 32022);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1052, 31444, 32022);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1052, 31444, 32022);
            CallChecker.varInit(this.m_context, "m_context", 1052, 31444, 32022);
            CallChecker.varInit(this.m_activator, "m_activator", 1052, 31444, 32022);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1052, 31444, 32022);
            CallChecker.varInit(this.m_state, "m_state", 1052, 31444, 32022);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1052, 31444, 32022);
            CallChecker.varInit(this.m_archive, "m_archive", 1052, 31444, 32022);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1052, 31444, 32022);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 1054, 31493, 31532);
            final Felix npe_invocation_var504 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var504, Felix.class, 1055, 31563, 31576)) {
                if ((sm != null) && ((CallChecker.isCalled(npe_invocation_var504, Felix.class, 1055, 31563, 31576).getSecurityProvider()) != null)) {
                    Class caller = CallChecker.init(Class.class);
                    if (CallChecker.beforeDeref(BundleImpl.m_smEx, SecurityManagerEx.class, 1057, 31647, 31652)) {
                        final Class[] npe_invocation_var505 = CallChecker.isCalled(BundleImpl.m_smEx, SecurityManagerEx.class, 1057, 31647, 31652).getClassContext();
                        if (CallChecker.beforeDeref(npe_invocation_var505, Class[].class, 1057, 31647, 31670)) {
                            caller = CallChecker.isCalled(npe_invocation_var505, Class[].class, 1057, 31647, 31670)[3];
                            CallChecker.varAssign(caller, "caller", 1057, 31647, 31652);
                        }
                    }
                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 1058, 31694, 31713)) {
                        if (CallChecker.beforeDeref(caller, Class.class, 1059, 31776, 31781)) {
                            caller = CallChecker.beforeCalled(caller, Class.class, 1059, 31776, 31781);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(caller, Class.class, 1059, 31776, 31781).getName(), String.class, 1059, 31776, 31791)) {
                                caller = CallChecker.beforeCalled(caller, Class.class, 1059, 31776, 31781);
                                if (((CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 1058, 31694, 31713).getClassLoader(caller)) != (BundleImpl.m_classloader)) || (!(CallChecker.isCalled(CallChecker.isCalled(caller, Class.class, 1059, 31776, 31781).getName(), String.class, 1059, 31776, 31791).startsWith("org.apache.felix.framework.")))) {
                                    if (CallChecker.beforeDeref(type, Class.class, 1062, 31947, 31950)) {
                                        type = CallChecker.beforeCalled(type, Class.class, 1062, 31947, 31950);
                                        ((SecurityManager) (sm)).checkPermission(new AdaptPermission(CallChecker.isCalled(type, Class.class, 1062, 31947, 31950).getName(), this, AdaptPermission.ADAPT));
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
            _bcornu_methode_context1353.methodEnd();
        }
    }

    public synchronized <A> A adapt(Class<A> type) {
        checkAdapt(type);
        if (type == (BundleContext.class)) {
            return ((A) (m_context));
        }else
            if (type == (org.osgi.framework.startlevel.BundleStartLevel.class)) {
                final Felix npe_invocation_var506 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var506, Felix.class, 1076, 32285, 32298)) {
                    final FrameworkStartLevelImpl npe_invocation_var507 = CallChecker.isCalled(npe_invocation_var506, Felix.class, 1076, 32285, 32298).adapt(FrameworkStartLevelImpl.class);
                    if (CallChecker.beforeDeref(npe_invocation_var507, FrameworkStartLevelImpl.class, 1076, 32285, 32335)) {
                        return ((A) (CallChecker.isCalled(npe_invocation_var507, FrameworkStartLevelImpl.class, 1076, 32285, 32335).createBundleStartLevel(this)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (type == (BundleRevision.class)) {
                    if ((m_state) == (Bundle.UNINSTALLED)) {
                        return null;
                    }
                    if (CallChecker.beforeDeref(m_revisions, List.class, 1085, 32578, 32588)) {
                        return ((A) (CallChecker.isCalled(m_revisions, List.class, 1085, 32578, 32588).get(0)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (type == (BundleRevisionImpl.class)) {
                        if (CallChecker.beforeDeref(m_revisions, List.class, 1092, 32868, 32878)) {
                            return ((A) (CallChecker.isCalled(m_revisions, List.class, 1092, 32868, 32878).get(0)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (type == (BundleRevisions.class)) {
                            return ((A) (this));
                        }else
                            if (type == (BundleWiring.class)) {
                                if ((m_state) == (Bundle.UNINSTALLED)) {
                                    return null;
                                }
                                if (CallChecker.beforeDeref(m_revisions, List.class, 1104, 33177, 33187)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_revisions, List.class, 1104, 33177, 33187).get(0), BundleRevision.class, 1104, 33177, 33194)) {
                                        return ((A) (CallChecker.isCalled(CallChecker.isCalled(m_revisions, List.class, 1104, 33177, 33187).get(0), BundleRevision.class, 1104, 33177, 33194).getWiring()));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                if (type == (java.security.AccessControlContext.class)) {
                                    if ((m_state) == (Bundle.UNINSTALLED)) {
                                        return null;
                                    }
                                    final ProtectionDomain pd = CallChecker.varInit(this.getProtectionDomain(), "pd", 1112, 33399, 33453);
                                    if (pd == null) {
                                        return null;
                                    }
                                    return ((A) (new java.security.AccessControlContext(new ProtectionDomain[]{ pd })));
                                }else
                                    if ((org.osgi.dto.DTO.class.isAssignableFrom(type)) || (org.osgi.dto.DTO[].class.isAssignableFrom(type))) {
                                        return DTOFactory.createDTO(this, type);
                                    }
                                
                            
                        
                    
                
            
        
        return null;
    }

    public File getDataFile(String filename) {
        MethodContext _bcornu_methode_context1355 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 1128, 33839, 33949);
            CallChecker.varInit(filename, "filename", 1128, 33839, 33949);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1128, 33839, 33949);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1128, 33839, 33949);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1128, 33839, 33949);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1128, 33839, 33949);
            CallChecker.varInit(this.m_stale, "m_stale", 1128, 33839, 33949);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1128, 33839, 33949);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1128, 33839, 33949);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1128, 33839, 33949);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1128, 33839, 33949);
            CallChecker.varInit(this.m_context, "m_context", 1128, 33839, 33949);
            CallChecker.varInit(this.m_activator, "m_activator", 1128, 33839, 33949);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1128, 33839, 33949);
            CallChecker.varInit(this.m_state, "m_state", 1128, 33839, 33949);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1128, 33839, 33949);
            CallChecker.varInit(this.m_archive, "m_archive", 1128, 33839, 33949);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1128, 33839, 33949);
            final Felix npe_invocation_var508 = getFramework();
            if (CallChecker.beforeDeref(npe_invocation_var508, Felix.class, 1130, 33901, 33914)) {
                return CallChecker.isCalled(npe_invocation_var508, Felix.class, 1130, 33901, 33914).getDataFile(this, filename);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1355.methodEnd();
        }
    }

    public int compareTo(Bundle t) {
        MethodContext _bcornu_methode_context1356 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1133, 33956, 34182);
            CallChecker.varInit(t, "t", 1133, 33956, 34182);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1133, 33956, 34182);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1133, 33956, 34182);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1133, 33956, 34182);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1133, 33956, 34182);
            CallChecker.varInit(this.m_stale, "m_stale", 1133, 33956, 34182);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1133, 33956, 34182);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1133, 33956, 34182);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1133, 33956, 34182);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1133, 33956, 34182);
            CallChecker.varInit(this.m_context, "m_context", 1133, 33956, 34182);
            CallChecker.varInit(this.m_activator, "m_activator", 1133, 33956, 34182);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1133, 33956, 34182);
            CallChecker.varInit(this.m_state, "m_state", 1133, 33956, 34182);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1133, 33956, 34182);
            CallChecker.varInit(this.m_archive, "m_archive", 1133, 33956, 34182);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1133, 33956, 34182);
            long thisBundleId = CallChecker.varInit(((long) (this.getBundleId())), "thisBundleId", 1135, 34001, 34039);
            long thatBundleId = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(t, Bundle.class, 1136, 34069, 34069)) {
                t = CallChecker.beforeCalled(t, Bundle.class, 1136, 34069, 34069);
                thatBundleId = CallChecker.isCalled(t, Bundle.class, 1136, 34069, 34069).getBundleId();
                CallChecker.varAssign(thatBundleId, "thatBundleId", 1136, 34069, 34069);
            }
            if (thisBundleId < thatBundleId) {
                return -1;
            }else {
                return thisBundleId == thatBundleId ? 0 : 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1356.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1357 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1141, 34189, 34416);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1141, 34189, 34416);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1141, 34189, 34416);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1141, 34189, 34416);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1141, 34189, 34416);
            CallChecker.varInit(this.m_stale, "m_stale", 1141, 34189, 34416);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1141, 34189, 34416);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1141, 34189, 34416);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1141, 34189, 34416);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1141, 34189, 34416);
            CallChecker.varInit(this.m_context, "m_context", 1141, 34189, 34416);
            CallChecker.varInit(this.m_activator, "m_activator", 1141, 34189, 34416);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1141, 34189, 34416);
            CallChecker.varInit(this.m_state, "m_state", 1141, 34189, 34416);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1141, 34189, 34416);
            CallChecker.varInit(this.m_archive, "m_archive", 1141, 34189, 34416);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1141, 34189, 34416);
            String sym = CallChecker.varInit(getSymbolicName(), "sym", 1143, 34242, 34272);
            if (sym != null) {
                return ((sym + " [") + (getBundleId())) + "]";
            }
            return ("[" + (getBundleId())) + "]";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1357.methodEnd();
        }
    }

    synchronized boolean isRemovalPending() {
        MethodContext _bcornu_methode_context1358 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1151, 34423, 34561);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1151, 34423, 34561);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1151, 34423, 34561);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1151, 34423, 34561);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1151, 34423, 34561);
            CallChecker.varInit(this.m_stale, "m_stale", 1151, 34423, 34561);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1151, 34423, 34561);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1151, 34423, 34561);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1151, 34423, 34561);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1151, 34423, 34561);
            CallChecker.varInit(this.m_context, "m_context", 1151, 34423, 34561);
            CallChecker.varInit(this.m_activator, "m_activator", 1151, 34423, 34561);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1151, 34423, 34561);
            CallChecker.varInit(this.m_state, "m_state", 1151, 34423, 34561);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1151, 34423, 34561);
            CallChecker.varInit(this.m_archive, "m_archive", 1151, 34423, 34561);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1151, 34423, 34561);
            return (((m_state) == (Bundle.UNINSTALLED)) || ((CallChecker.isCalled(m_revisions, List.class, 1153, 34520, 34530).size()) > 1)) || (m_stale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1358.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context1359 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 1160, 34568, 34668);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1160, 34568, 34668);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1160, 34568, 34668);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1160, 34568, 34668);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1160, 34568, 34668);
            CallChecker.varInit(this.m_stale, "m_stale", 1160, 34568, 34668);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1160, 34568, 34668);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1160, 34568, 34668);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1160, 34568, 34668);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1160, 34568, 34668);
            CallChecker.varInit(this.m_context, "m_context", 1160, 34568, 34668);
            CallChecker.varInit(this.m_activator, "m_activator", 1160, 34568, 34668);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1160, 34568, 34668);
            CallChecker.varInit(this.m_state, "m_state", 1160, 34568, 34668);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1160, 34568, 34668);
            CallChecker.varInit(this.m_archive, "m_archive", 1160, 34568, 34668);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1160, 34568, 34668);
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1359.methodEnd();
        }
    }

    public synchronized List<BundleRevision> getRevisions() {
        MethodContext _bcornu_methode_context1360 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1165, 34675, 34800);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1165, 34675, 34800);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1165, 34675, 34800);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1165, 34675, 34800);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1165, 34675, 34800);
            CallChecker.varInit(this.m_stale, "m_stale", 1165, 34675, 34800);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1165, 34675, 34800);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1165, 34675, 34800);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1165, 34675, 34800);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1165, 34675, 34800);
            CallChecker.varInit(this.m_context, "m_context", 1165, 34675, 34800);
            CallChecker.varInit(this.m_activator, "m_activator", 1165, 34675, 34800);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1165, 34675, 34800);
            CallChecker.varInit(this.m_state, "m_state", 1165, 34675, 34800);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1165, 34675, 34800);
            CallChecker.varInit(this.m_archive, "m_archive", 1165, 34675, 34800);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1165, 34675, 34800);
            return new ArrayList<BundleRevision>(m_revisions);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1360.methodEnd();
        }
    }

    synchronized boolean hasRevision(BundleRevision revision) {
        MethodContext _bcornu_methode_context1361 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1176, 34807, 35246);
            CallChecker.varInit(revision, "revision", 1176, 34807, 35246);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1176, 34807, 35246);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1176, 34807, 35246);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1176, 34807, 35246);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1176, 34807, 35246);
            CallChecker.varInit(this.m_stale, "m_stale", 1176, 34807, 35246);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1176, 34807, 35246);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1176, 34807, 35246);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1176, 34807, 35246);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1176, 34807, 35246);
            CallChecker.varInit(this.m_context, "m_context", 1176, 34807, 35246);
            CallChecker.varInit(this.m_activator, "m_activator", 1176, 34807, 35246);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1176, 34807, 35246);
            CallChecker.varInit(this.m_state, "m_state", 1176, 34807, 35246);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1176, 34807, 35246);
            CallChecker.varInit(this.m_archive, "m_archive", 1176, 34807, 35246);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1176, 34807, 35246);
            if (CallChecker.beforeDeref(m_revisions, List.class, 1178, 35210, 35220)) {
                return CallChecker.isCalled(m_revisions, List.class, 1178, 35210, 35220).contains(revision);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1361.methodEnd();
        }
    }

    synchronized void revise(String location, InputStream is) throws Exception {
        MethodContext _bcornu_methode_context1362 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1181, 35253, 35699);
            CallChecker.varInit(is, "is", 1181, 35253, 35699);
            CallChecker.varInit(location, "location", 1181, 35253, 35699);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1181, 35253, 35699);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1181, 35253, 35699);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1181, 35253, 35699);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1181, 35253, 35699);
            CallChecker.varInit(this.m_stale, "m_stale", 1181, 35253, 35699);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1181, 35253, 35699);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1181, 35253, 35699);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1181, 35253, 35699);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1181, 35253, 35699);
            CallChecker.varInit(this.m_context, "m_context", 1181, 35253, 35699);
            CallChecker.varInit(this.m_activator, "m_activator", 1181, 35253, 35699);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1181, 35253, 35699);
            CallChecker.varInit(this.m_state, "m_state", 1181, 35253, 35699);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1181, 35253, 35699);
            CallChecker.varInit(this.m_archive, "m_archive", 1181, 35253, 35699);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1181, 35253, 35699);
            if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 1185, 35425, 35433)) {
                CallChecker.isCalled(m_archive, BundleArchive.class, 1185, 35425, 35433).revise(location, is);
            }
            TryContext _bcornu_try_context_378 = new TryContext(378, BundleImpl.class, "java.lang.Exception");
            try {
                BundleRevision revision = CallChecker.varInit(createRevision(true), "revision", 1188, 35491, 35537);
                addRevision(revision);
            } catch (Exception ex) {
                _bcornu_try_context_378.catchStart(378);
                if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 1193, 35635, 35643)) {
                    CallChecker.isCalled(m_archive, BundleArchive.class, 1193, 35635, 35643).rollbackRevise();
                }
                throw ex;
            } finally {
                _bcornu_try_context_378.finallyStart(378);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1362.methodEnd();
        }
    }

    synchronized boolean rollbackRevise() throws Exception {
        MethodContext _bcornu_methode_context1363 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1198, 35706, 36161);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1198, 35706, 36161);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1198, 35706, 36161);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1198, 35706, 36161);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1198, 35706, 36161);
            CallChecker.varInit(this.m_stale, "m_stale", 1198, 35706, 36161);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1198, 35706, 36161);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1198, 35706, 36161);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1198, 35706, 36161);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1198, 35706, 36161);
            CallChecker.varInit(this.m_context, "m_context", 1198, 35706, 36161);
            CallChecker.varInit(this.m_activator, "m_activator", 1198, 35706, 36161);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1198, 35706, 36161);
            CallChecker.varInit(this.m_state, "m_state", 1198, 35706, 36161);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1198, 35706, 36161);
            CallChecker.varInit(this.m_archive, "m_archive", 1198, 35706, 36161);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1198, 35706, 36161);
            boolean isExtension = CallChecker.varInit(((boolean) (isExtension())), "isExtension", 1200, 35775, 35810);
            BundleRevision br = CallChecker.init(BundleRevision.class);
            if (CallChecker.beforeDeref(m_revisions, List.class, 1201, 35840, 35850)) {
                br = CallChecker.isCalled(m_revisions, List.class, 1201, 35840, 35850).remove(0);
                CallChecker.varAssign(br, "br", 1201, 35840, 35850);
            }
            if (!isExtension) {
                final Felix npe_invocation_var509 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var509, Felix.class, 1206, 36055, 36068)) {
                    final StatefulResolver npe_invocation_var510 = CallChecker.isCalled(npe_invocation_var509, Felix.class, 1206, 36055, 36068).getResolver();
                    if (CallChecker.beforeDeref(npe_invocation_var510, StatefulResolver.class, 1206, 36055, 36082)) {
                        CallChecker.isCalled(npe_invocation_var510, StatefulResolver.class, 1206, 36055, 36082).removeRevision(br);
                    }
                }
            }
            if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 1208, 36129, 36137)) {
                return CallChecker.isCalled(m_archive, BundleArchive.class, 1208, 36129, 36137).rollbackRevise();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1363.methodEnd();
        }
    }

    synchronized void addRevision(BundleRevision revision) throws Exception {
        MethodContext _bcornu_methode_context1364 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1215, 36168, 37147);
            CallChecker.varInit(revision, "revision", 1215, 36168, 37147);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1215, 36168, 37147);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1215, 36168, 37147);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1215, 36168, 37147);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1215, 36168, 37147);
            CallChecker.varInit(this.m_stale, "m_stale", 1215, 36168, 37147);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1215, 36168, 37147);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1215, 36168, 37147);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1215, 36168, 37147);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1215, 36168, 37147);
            CallChecker.varInit(this.m_context, "m_context", 1215, 36168, 37147);
            CallChecker.varInit(this.m_activator, "m_activator", 1215, 36168, 37147);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1215, 36168, 37147);
            CallChecker.varInit(this.m_state, "m_state", 1215, 36168, 37147);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1215, 36168, 37147);
            CallChecker.varInit(this.m_archive, "m_archive", 1215, 36168, 37147);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1215, 36168, 37147);
            if (CallChecker.beforeDeref(m_revisions, List.class, 1217, 36494, 36504)) {
                CallChecker.isCalled(m_revisions, List.class, 1217, 36494, 36504).add(0, revision);
            }
            TryContext _bcornu_try_context_379 = new TryContext(379, BundleImpl.class, "java.lang.Exception");
            try {
                final Felix npe_invocation_var511 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var511, Felix.class, 1221, 36559, 36572)) {
                    CallChecker.isCalled(npe_invocation_var511, Felix.class, 1221, 36559, 36572).setBundleProtectionDomain(this, ((BundleRevisionImpl) (revision)));
                }
            } catch (Exception ex) {
                _bcornu_try_context_379.catchStart(379);
                if (CallChecker.beforeDeref(m_revisions, List.class, 1225, 36699, 36709)) {
                    CallChecker.isCalled(m_revisions, List.class, 1225, 36699, 36709).remove(0);
                }
                throw ex;
            } finally {
                _bcornu_try_context_379.finallyStart(379);
            }
            if (!(isExtension())) {
                final Felix npe_invocation_var512 = getFramework();
                if (CallChecker.beforeDeref(npe_invocation_var512, Felix.class, 1235, 37081, 37094)) {
                    final StatefulResolver npe_invocation_var513 = CallChecker.isCalled(npe_invocation_var512, Felix.class, 1235, 37081, 37094).getResolver();
                    if (CallChecker.beforeDeref(npe_invocation_var513, StatefulResolver.class, 1235, 37081, 37108)) {
                        CallChecker.isCalled(npe_invocation_var513, StatefulResolver.class, 1235, 37081, 37108).addRevision(revision);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1364.methodEnd();
        }
    }

    private BundleRevision createRevision(boolean isUpdate) throws Exception {
        MethodContext _bcornu_methode_context1365 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 1239, 37154, 40944);
            CallChecker.varInit(isUpdate, "isUpdate", 1239, 37154, 40944);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1239, 37154, 40944);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1239, 37154, 40944);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1239, 37154, 40944);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1239, 37154, 40944);
            CallChecker.varInit(this.m_stale, "m_stale", 1239, 37154, 40944);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1239, 37154, 40944);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1239, 37154, 40944);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1239, 37154, 40944);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1239, 37154, 40944);
            CallChecker.varInit(this.m_context, "m_context", 1239, 37154, 40944);
            CallChecker.varInit(this.m_activator, "m_activator", 1239, 37154, 40944);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1239, 37154, 40944);
            CallChecker.varInit(this.m_state, "m_state", 1239, 37154, 40944);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1239, 37154, 40944);
            CallChecker.varInit(this.m_archive, "m_archive", 1239, 37154, 40944);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1239, 37154, 40944);
            Map headerMap = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 1243, 37385, 37393)) {
                final BundleArchiveRevision npe_invocation_var514 = CallChecker.isCalled(m_archive, BundleArchive.class, 1243, 37385, 37393).getCurrentRevision();
                if (CallChecker.beforeDeref(npe_invocation_var514, BundleArchiveRevision.class, 1243, 37385, 37414)) {
                    headerMap = CallChecker.isCalled(npe_invocation_var514, BundleArchiveRevision.class, 1243, 37385, 37414).getManifestHeader();
                    CallChecker.varAssign(headerMap, "headerMap", 1243, 37385, 37393);
                }
            }
            BundleRevisionImpl revision = CallChecker.init(BundleRevisionImpl.class);
            if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 1249, 37631, 37639)) {
                final Long npe_invocation_var515 = CallChecker.isCalled(m_archive, BundleArchive.class, 1249, 37631, 37639).getCurrentRevisionNumber();
                if (CallChecker.beforeDeref(npe_invocation_var515, Long.class, 1249, 37631, 37666)) {
                    if (CallChecker.beforeDeref(m_archive, BundleArchive.class, 1251, 37715, 37723)) {
                        final BundleArchiveRevision npe_invocation_var516 = CallChecker.isCalled(m_archive, BundleArchive.class, 1251, 37715, 37723).getCurrentRevision();
                        if (CallChecker.beforeDeref(npe_invocation_var516, BundleArchiveRevision.class, 1251, 37715, 37744)) {
                            revision = new BundleRevisionImpl(this, (((Long.toString(getBundleId())) + ".") + (CallChecker.isCalled(npe_invocation_var515, Long.class, 1249, 37631, 37666).toString())), headerMap, CallChecker.isCalled(npe_invocation_var516, BundleArchiveRevision.class, 1251, 37715, 37744).getContent());
                            CallChecker.varAssign(revision, "revision", 1249, 37631, 37639);
                        }
                    }
                }
            }
            final Felix npe_invocation_var517 = getFramework();
            String allowMultiple = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(npe_invocation_var517, Felix.class, 1256, 37946, 37959)) {
                final Map npe_invocation_var518 = CallChecker.isCalled(npe_invocation_var517, Felix.class, 1256, 37946, 37959).getConfig();
                if (CallChecker.beforeDeref(npe_invocation_var518, Map.class, 1256, 37946, 37971)) {
                    allowMultiple = ((String) (CallChecker.isCalled(npe_invocation_var518, Map.class, 1256, 37946, 37971).get(Constants.FRAMEWORK_BSNVERSION)));
                    CallChecker.varAssign(allowMultiple, "allowMultiple", 1256, 37946, 37959);
                }
            }
            if (allowMultiple == null) {
                allowMultiple = Constants.FRAMEWORK_BSNVERSION_MANAGED;
                CallChecker.varAssign(allowMultiple, "allowMultiple", 1257, 38018, 38138);
            }else {
                allowMultiple = allowMultiple;
                CallChecker.varAssign(allowMultiple, "allowMultiple", 1257, 38018, 38138);
            }
            if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 1260, 38152, 38159)) {
                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 1260, 38152, 38159);
                final String npe_invocation_var519 = CallChecker.isCalled(revision, BundleRevisionImpl.class, 1260, 38152, 38159).getManifestVersion();
                if (CallChecker.beforeDeref(npe_invocation_var519, String.class, 1260, 38152, 38180)) {
                    if (CallChecker.beforeDeref(allowMultiple, String.class, 1261, 38210, 38222)) {
                        allowMultiple = CallChecker.beforeCalled(allowMultiple, String.class, 1261, 38210, 38222);
                        if ((CallChecker.isCalled(npe_invocation_var519, String.class, 1260, 38152, 38180).equals("2")) && (!(CallChecker.isCalled(allowMultiple, String.class, 1261, 38210, 38222).equals(Constants.FRAMEWORK_BSNVERSION_MULTIPLE)))) {
                            Version bundleVersion = CallChecker.init(Version.class);
                            if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 1263, 38319, 38326)) {
                                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 1263, 38319, 38326);
                                bundleVersion = CallChecker.isCalled(revision, BundleRevisionImpl.class, 1263, 38319, 38326).getVersion();
                                CallChecker.varAssign(bundleVersion, "bundleVersion", 1263, 38319, 38326);
                            }
                            if (bundleVersion == null) {
                                bundleVersion = Version.emptyVersion;
                                CallChecker.varAssign(bundleVersion, "bundleVersion", 1264, 38354, 38432);
                            }else {
                                bundleVersion = bundleVersion;
                                CallChecker.varAssign(bundleVersion, "bundleVersion", 1264, 38354, 38432);
                            }
                            String symName = CallChecker.init(String.class);
                            if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 1265, 38463, 38470)) {
                                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 1265, 38463, 38470);
                                symName = CallChecker.isCalled(revision, BundleRevisionImpl.class, 1265, 38463, 38470).getSymbolicName();
                                CallChecker.varAssign(symName, "symName", 1265, 38463, 38470);
                            }
                            List<Bundle> collisionCanditates = CallChecker.varInit(new ArrayList<Bundle>(), "collisionCanditates", 1267, 38504, 38562);
                            final Felix npe_invocation_var520 = getFramework();
                            Bundle[] bundles = CallChecker.init(Bundle[].class);
                            if (CallChecker.beforeDeref(npe_invocation_var520, Felix.class, 1268, 38595, 38608)) {
                                bundles = CallChecker.isCalled(npe_invocation_var520, Felix.class, 1268, 38595, 38608).getBundles();
                                CallChecker.varAssign(bundles, "bundles", 1268, 38595, 38608);
                            }
                            bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 1269, 38678, 38684);
                            for (int i = 0; (bundles != null) && (i < (CallChecker.isCalled(bundles, Bundle[].class, 1269, 38678, 38684).length)); i++) {
                                long id = CallChecker.init(long.class);
                                bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 1271, 38754, 38760);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(bundles, Bundle[].class, 1271, 38754, 38760)[i], Bundle.class, 1271, 38754, 38763)) {
                                    bundles[i] = CallChecker.beforeCalled(bundles[i], BundleImpl.class, 1271, 38754, 38763);
                                    id = CallChecker.isCalled(((BundleImpl) (bundles[i])), BundleImpl.class, 1271, 38754, 38763).getBundleId();
                                    CallChecker.varAssign(id, "id", 1271, 38754, 38763);
                                }
                                if (id != (getBundleId())) {
                                    bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 1274, 38879, 38885);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(bundles, Bundle[].class, 1274, 38879, 38885)[i], Bundle.class, 1274, 38879, 38888)) {
                                        if (CallChecker.beforeDeref(symName, String.class, 1274, 38864, 38870)) {
                                            bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 1275, 38957, 38963);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(bundles, Bundle[].class, 1275, 38957, 38963)[i], Bundle.class, 1275, 38957, 38966)) {
                                                if (CallChecker.beforeDeref(bundleVersion, Version.class, 1275, 38936, 38948)) {
                                                    bundles[i] = CallChecker.beforeCalled(bundles[i], Bundle.class, 1274, 38879, 38888);
                                                    symName = CallChecker.beforeCalled(symName, String.class, 1274, 38864, 38870);
                                                    bundles[i] = CallChecker.beforeCalled(bundles[i], Bundle.class, 1275, 38957, 38966);
                                                    bundleVersion = CallChecker.beforeCalled(bundleVersion, Version.class, 1275, 38936, 38948);
                                                    if ((CallChecker.isCalled(symName, String.class, 1274, 38864, 38870).equals(CallChecker.isCalled(bundles[i], Bundle.class, 1274, 38879, 38888).getSymbolicName())) && (CallChecker.isCalled(bundleVersion, Version.class, 1275, 38936, 38948).equals(CallChecker.isCalled(bundles[i], Bundle.class, 1275, 38957, 38966).getVersion()))) {
                                                        if (CallChecker.beforeDeref(collisionCanditates, List.class, 1277, 39029, 39047)) {
                                                            collisionCanditates = CallChecker.beforeCalled(collisionCanditates, List.class, 1277, 39029, 39047);
                                                            CallChecker.isCalled(collisionCanditates, List.class, 1277, 39029, 39047).add(bundles[i]);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(collisionCanditates, List.class, 1281, 39137, 39155)) {
                                if (CallChecker.beforeDeref(allowMultiple, String.class, 1281, 39170, 39182)) {
                                    collisionCanditates = CallChecker.beforeCalled(collisionCanditates, List.class, 1281, 39137, 39155);
                                    allowMultiple = CallChecker.beforeCalled(allowMultiple, String.class, 1281, 39170, 39182);
                                    if ((!(CallChecker.isCalled(collisionCanditates, List.class, 1281, 39137, 39155).isEmpty())) && (CallChecker.isCalled(allowMultiple, String.class, 1281, 39170, 39182).equals(Constants.FRAMEWORK_BSNVERSION_MANAGED))) {
                                        final Felix npe_invocation_var521 = getFramework();
                                        Set<ServiceReference<CollisionHook>> hooks = CallChecker.init(Set.class);
                                        if (CallChecker.beforeDeref(npe_invocation_var521, Felix.class, 1283, 39307, 39320)) {
                                            hooks = CallChecker.isCalled(npe_invocation_var521, Felix.class, 1283, 39307, 39320).getHooks(CollisionHook.class);
                                            CallChecker.varAssign(hooks, "hooks", 1283, 39307, 39320);
                                        }
                                        if (CallChecker.beforeDeref(hooks, Set.class, 1284, 39374, 39378)) {
                                            hooks = CallChecker.beforeCalled(hooks, Set.class, 1284, 39374, 39378);
                                            if (!(CallChecker.isCalled(hooks, Set.class, 1284, 39374, 39378).isEmpty())) {
                                                Collection<Bundle> shrinkableCollisionCandidates = CallChecker.varInit(new ShrinkableCollection<Bundle>(collisionCanditates), "shrinkableCollisionCandidates", 1286, 39429, 39533);
                                                if (CallChecker.beforeDeref(hooks, BundleRevision.class, 1287, 39599, 39603)) {
                                                    for (ServiceReference<CollisionHook> hook : hooks) {
                                                        final Felix npe_invocation_var522 = getFramework();
                                                        CollisionHook ch = CallChecker.init(CollisionHook.class);
                                                        if (CallChecker.beforeDeref(npe_invocation_var522, Felix.class, 1289, 39671, 39684)) {
                                                            ch = CallChecker.isCalled(npe_invocation_var522, Felix.class, 1289, 39671, 39684).getService(getFramework(), hook, false);
                                                            CallChecker.varAssign(ch, "ch", 1289, 39671, 39684);
                                                        }
                                                        if (ch != null) {
                                                            int operationType = CallChecker.init(int.class);
                                                            Bundle target = CallChecker.init(Bundle.class);
                                                            if (isUpdate) {
                                                                operationType = CollisionHook.UPDATING;
                                                                CallChecker.varAssign(operationType, "operationType", 1296, 39987, 40025);
                                                                target = this;
                                                                CallChecker.varAssign(target, "target", 1297, 40059, 40072);
                                                            }else {
                                                                operationType = CollisionHook.INSTALLING;
                                                                CallChecker.varAssign(operationType, "operationType", 1301, 40199, 40239);
                                                                if ((m_installingBundle) == null) {
                                                                    target = this;
                                                                    CallChecker.varAssign(target, "target", 1302, 40273, 40336);
                                                                }else {
                                                                    target = m_installingBundle;
                                                                    CallChecker.varAssign(target, "target", 1302, 40273, 40336);
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 1305, 40397, 40416)) {
                                                                CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 1305, 40397, 40416).invokeBundleCollisionHook(ch, operationType, target, shrinkableCollisionCandidates);
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
                            
                            if (CallChecker.beforeDeref(collisionCanditates, List.class, 1311, 40636, 40654)) {
                                collisionCanditates = CallChecker.beforeCalled(collisionCanditates, List.class, 1311, 40636, 40654);
                                if (!(CallChecker.isCalled(collisionCanditates, List.class, 1311, 40636, 40654).isEmpty())) {
                                    throw new BundleException(((("Bundle symbolic name and version are not unique: " + symName) + ':') + bundleVersion), BundleException.DUPLICATE_BUNDLE_ERROR);
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
            
            return revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1365.methodEnd();
        }
    }

    synchronized ProtectionDomain getProtectionDomain() {
        MethodContext _bcornu_methode_context1366 = new MethodContext(ProtectionDomain.class);
        try {
            CallChecker.varInit(this, "this", 1322, 40951, 41248);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1322, 40951, 41248);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1322, 40951, 41248);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1322, 40951, 41248);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1322, 40951, 41248);
            CallChecker.varInit(this.m_stale, "m_stale", 1322, 40951, 41248);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1322, 40951, 41248);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1322, 40951, 41248);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1322, 40951, 41248);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1322, 40951, 41248);
            CallChecker.varInit(this.m_context, "m_context", 1322, 40951, 41248);
            CallChecker.varInit(this.m_activator, "m_activator", 1322, 40951, 41248);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1322, 40951, 41248);
            CallChecker.varInit(this.m_state, "m_state", 1322, 40951, 41248);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1322, 40951, 41248);
            CallChecker.varInit(this.m_archive, "m_archive", 1322, 40951, 41248);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1322, 40951, 41248);
            ProtectionDomain pd = CallChecker.varInit(null, "pd", 1324, 41017, 41043);
            for (int i = (CallChecker.isCalled(m_revisions, List.class, 1326, 41067, 41077).size()) - 1; (i >= 0) && (pd == null); i--) {
                if (CallChecker.beforeDeref(m_revisions, List.class, 1328, 41171, 41181)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_revisions, List.class, 1328, 41171, 41181).get(i), BundleRevision.class, 1328, 41171, 41188)) {
                        pd = CallChecker.isCalled(((BundleRevisionImpl) (CallChecker.isCalled(m_revisions, List.class, 1328, 41171, 41181).get(i))), BundleRevisionImpl.class, 1328, 41171, 41188).getProtectionDomain();
                        CallChecker.varAssign(pd, "pd", 1328, 41144, 41212);
                    }
                }
            }
            return pd;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ProtectionDomain) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1366.methodEnd();
        }
    }

    synchronized boolean isLockable() {
        MethodContext _bcornu_methode_context1367 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1338, 41255, 41425);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1338, 41255, 41425);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1338, 41255, 41425);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1338, 41255, 41425);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1338, 41255, 41425);
            CallChecker.varInit(this.m_stale, "m_stale", 1338, 41255, 41425);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1338, 41255, 41425);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1338, 41255, 41425);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1338, 41255, 41425);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1338, 41255, 41425);
            CallChecker.varInit(this.m_context, "m_context", 1338, 41255, 41425);
            CallChecker.varInit(this.m_activator, "m_activator", 1338, 41255, 41425);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1338, 41255, 41425);
            CallChecker.varInit(this.m_state, "m_state", 1338, 41255, 41425);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1338, 41255, 41425);
            CallChecker.varInit(this.m_archive, "m_archive", 1338, 41255, 41425);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1338, 41255, 41425);
            return ((m_lockCount) == 0) || ((m_lockThread) == (Thread.currentThread()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1367.methodEnd();
        }
    }

    synchronized Thread getLockingThread() {
        MethodContext _bcornu_methode_context1368 = new MethodContext(Thread.class);
        try {
            CallChecker.varInit(this, "this", 1343, 41432, 41510);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1343, 41432, 41510);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1343, 41432, 41510);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1343, 41432, 41510);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1343, 41432, 41510);
            CallChecker.varInit(this.m_stale, "m_stale", 1343, 41432, 41510);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1343, 41432, 41510);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1343, 41432, 41510);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1343, 41432, 41510);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1343, 41432, 41510);
            CallChecker.varInit(this.m_context, "m_context", 1343, 41432, 41510);
            CallChecker.varInit(this.m_activator, "m_activator", 1343, 41432, 41510);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1343, 41432, 41510);
            CallChecker.varInit(this.m_state, "m_state", 1343, 41432, 41510);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1343, 41432, 41510);
            CallChecker.varInit(this.m_archive, "m_archive", 1343, 41432, 41510);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1343, 41432, 41510);
            return m_lockThread;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Thread) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1368.methodEnd();
        }
    }

    synchronized void lock() {
        MethodContext _bcornu_methode_context1369 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1348, 41517, 41801);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1348, 41517, 41801);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1348, 41517, 41801);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1348, 41517, 41801);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1348, 41517, 41801);
            CallChecker.varInit(this.m_stale, "m_stale", 1348, 41517, 41801);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1348, 41517, 41801);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1348, 41517, 41801);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1348, 41517, 41801);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1348, 41517, 41801);
            CallChecker.varInit(this.m_context, "m_context", 1348, 41517, 41801);
            CallChecker.varInit(this.m_activator, "m_activator", 1348, 41517, 41801);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1348, 41517, 41801);
            CallChecker.varInit(this.m_state, "m_state", 1348, 41517, 41801);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1348, 41517, 41801);
            CallChecker.varInit(this.m_archive, "m_archive", 1348, 41517, 41801);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1348, 41517, 41801);
            if (((m_lockCount) > 0) && ((m_lockThread) != (Thread.currentThread()))) {
                throw new IllegalStateException("Bundle is locked by another thread.");
            }
            (m_lockCount)++;
            m_lockThread = Thread.currentThread();
            CallChecker.varAssign(this.m_lockThread, "this.m_lockThread", 1355, 41758, 41795);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1369.methodEnd();
        }
    }

    synchronized void unlock() {
        MethodContext _bcornu_methode_context1370 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1358, 41808, 42250);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1358, 41808, 42250);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1358, 41808, 42250);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1358, 41808, 42250);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1358, 41808, 42250);
            CallChecker.varInit(this.m_stale, "m_stale", 1358, 41808, 42250);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1358, 41808, 42250);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1358, 41808, 42250);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1358, 41808, 42250);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1358, 41808, 42250);
            CallChecker.varInit(this.m_context, "m_context", 1358, 41808, 42250);
            CallChecker.varInit(this.m_activator, "m_activator", 1358, 41808, 42250);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1358, 41808, 42250);
            CallChecker.varInit(this.m_state, "m_state", 1358, 41808, 42250);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1358, 41808, 42250);
            CallChecker.varInit(this.m_archive, "m_archive", 1358, 41808, 42250);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1358, 41808, 42250);
            if ((m_lockCount) == 0) {
                throw new IllegalStateException("Bundle is not locked.");
            }
            if (((m_lockCount) > 0) && ((m_lockThread) != (Thread.currentThread()))) {
                throw new IllegalStateException("Bundle is locked by another thread.");
            }
            (m_lockCount)--;
            if ((m_lockCount) == 0) {
                m_lockThread = null;
                CallChecker.varAssign(this.m_lockThread, "this.m_lockThread", 1371, 42215, 42234);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1370.methodEnd();
        }
    }

    BundleContext _getBundleContext() {
        MethodContext _bcornu_methode_context1371 = new MethodContext(BundleContext.class);
        try {
            CallChecker.varInit(this, "this", 1375, 42257, 42327);
            CallChecker.varInit(m_classloader, "org.apache.felix.framework.BundleImpl.m_classloader", 1375, 42257, 42327);
            CallChecker.varInit(m_smEx, "org.apache.felix.framework.BundleImpl.m_smEx", 1375, 42257, 42327);
            CallChecker.varInit(this.m_lockThread, "m_lockThread", 1375, 42257, 42327);
            CallChecker.varInit(this.m_lockCount, "m_lockCount", 1375, 42257, 42327);
            CallChecker.varInit(this.m_stale, "m_stale", 1375, 42257, 42327);
            CallChecker.varInit(this.m_installingBundle, "m_installingBundle", 1375, 42257, 42327);
            CallChecker.varInit(this.m_cachedHeadersTimestamp, "m_cachedHeadersTimestamp", 1375, 42257, 42327);
            CallChecker.varInit(this.m_uninstalledHeaders, "m_uninstalledHeaders", 1375, 42257, 42327);
            CallChecker.varInit(this.m_cachedHeaders, "m_cachedHeaders", 1375, 42257, 42327);
            CallChecker.varInit(this.m_context, "m_context", 1375, 42257, 42327);
            CallChecker.varInit(this.m_activator, "m_activator", 1375, 42257, 42327);
            CallChecker.varInit(this.m_useDeclaredActivationPolicy, "m_useDeclaredActivationPolicy", 1375, 42257, 42327);
            CallChecker.varInit(this.m_state, "m_state", 1375, 42257, 42327);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1375, 42257, 42327);
            CallChecker.varInit(this.m_archive, "m_archive", 1375, 42257, 42327);
            CallChecker.varInit(this.__m_felix, "__m_felix", 1375, 42257, 42327);
            return m_context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1371.methodEnd();
        }
    }
}

