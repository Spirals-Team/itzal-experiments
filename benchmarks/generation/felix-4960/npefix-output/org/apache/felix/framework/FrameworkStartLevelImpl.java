package org.apache.felix.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.osgi.framework.startlevel.FrameworkStartLevel;
import org.osgi.framework.FrameworkListener;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.startlevel.BundleStartLevel;
import org.osgi.framework.Bundle;
import java.util.ArrayList;
import org.osgi.framework.AdminPermission;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.startlevel.StartLevel;

class FrameworkStartLevelImpl implements Runnable , FrameworkStartLevel {
    static final String THREAD_NAME = "FelixStartLevel";

    private static final int BUNDLE_IDX = 0;

    private static final int STARTLEVEL_IDX = 1;

    private final Felix m_felix;

    private final ServiceRegistry m_registry;

    private final List m_requests = new ArrayList();

    private final List<FrameworkListener[]> m_requestListeners = new ArrayList<FrameworkListener[]>();

    private ServiceRegistration<StartLevel> m_slReg;

    private Thread m_thread = null;

    FrameworkStartLevelImpl(Felix felix, ServiceRegistry registry) {
        MethodContext _bcornu_methode_context11 = new MethodContext(null);
        try {
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 50, 1908, 1923);
            m_registry = registry;
            CallChecker.varAssign(this.m_registry, "this.m_registry", 51, 1933, 1954);
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    void start() {
        MethodContext _bcornu_methode_context137 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 55, 1967, 2242);
            CallChecker.varInit(this.m_thread, "m_thread", 55, 1967, 2242);
            CallChecker.varInit(this.m_slReg, "m_slReg", 55, 1967, 2242);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 55, 1967, 2242);
            CallChecker.varInit(this.m_requests, "m_requests", 55, 1967, 2242);
            CallChecker.varInit(this.m_registry, "m_registry", 55, 1967, 2242);
            CallChecker.varInit(this.m_felix, "m_felix", 55, 1967, 2242);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 55, 1967, 2242);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 55, 1967, 2242);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 55, 1967, 2242);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 57, 2073, 2082)) {
                m_slReg = ((ServiceRegistration<StartLevel>) (CallChecker.isCalled(m_registry, ServiceRegistry.class, 57, 2073, 2082).registerService(m_felix, new String[]{ StartLevel.class.getName() }, new StartLevelImpl(m_felix), null)));
                CallChecker.varAssign(this.m_slReg, "this.m_slReg", 57, 2029, 2236);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context137.methodEnd();
        }
    }

    private void startThread() {
        MethodContext _bcornu_methode_context138 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 64, 2249, 2579);
            CallChecker.varInit(this.m_thread, "m_thread", 64, 2249, 2579);
            CallChecker.varInit(this.m_slReg, "m_slReg", 64, 2249, 2579);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 64, 2249, 2579);
            CallChecker.varInit(this.m_requests, "m_requests", 64, 2249, 2579);
            CallChecker.varInit(this.m_registry, "m_registry", 64, 2249, 2579);
            CallChecker.varInit(this.m_felix, "m_felix", 64, 2249, 2579);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 64, 2249, 2579);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 64, 2249, 2579);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 64, 2249, 2579);
            if ((m_thread) == null) {
                m_thread = new Thread(this, FrameworkStartLevelImpl.THREAD_NAME);
                CallChecker.varAssign(this.m_thread, "this.m_thread", 69, 2455, 2495);
                if (CallChecker.beforeDeref(m_thread, Thread.class, 70, 2509, 2516)) {
                    m_thread = CallChecker.beforeCalled(m_thread, Thread.class, 70, 2509, 2516);
                    CallChecker.isCalled(m_thread, Thread.class, 70, 2509, 2516).setDaemon(true);
                }
                if (CallChecker.beforeDeref(m_thread, Thread.class, 71, 2547, 2554)) {
                    m_thread = CallChecker.beforeCalled(m_thread, Thread.class, 71, 2547, 2554);
                    CallChecker.isCalled(m_thread, Thread.class, 71, 2547, 2554).start();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context138.methodEnd();
        }
    }

    void stop() {
        MethodContext _bcornu_methode_context139 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 2586, 3425);
            CallChecker.varInit(this.m_thread, "m_thread", 84, 2586, 3425);
            CallChecker.varInit(this.m_slReg, "m_slReg", 84, 2586, 3425);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 84, 2586, 3425);
            CallChecker.varInit(this.m_requests, "m_requests", 84, 2586, 3425);
            CallChecker.varInit(this.m_registry, "m_registry", 84, 2586, 3425);
            CallChecker.varInit(this.m_felix, "m_felix", 84, 2586, 3425);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 84, 2586, 3425);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 84, 2586, 3425);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 84, 2586, 3425);
            synchronized(m_requests) {
                if ((m_thread) != null) {
                    m_thread = null;
                    CallChecker.varAssign(this.m_thread, "this.m_thread", 92, 3227, 3242);
                    if (CallChecker.beforeDeref(m_requests, List.class, 96, 3373, 3382)) {
                        CallChecker.isCalled(m_requests, List.class, 96, 3373, 3382).notifyAll();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context140 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 101, 3432, 3492);
            CallChecker.varInit(this.m_thread, "m_thread", 101, 3432, 3492);
            CallChecker.varInit(this.m_slReg, "m_slReg", 101, 3432, 3492);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 101, 3432, 3492);
            CallChecker.varInit(this.m_requests, "m_requests", 101, 3432, 3492);
            CallChecker.varInit(this.m_registry, "m_registry", 101, 3432, 3492);
            CallChecker.varInit(this.m_felix, "m_felix", 101, 3432, 3492);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 101, 3432, 3492);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 101, 3432, 3492);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 101, 3432, 3492);
            return m_felix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context140.methodEnd();
        }
    }

    public int getStartLevel() {
        MethodContext _bcornu_methode_context141 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 106, 3499, 3582);
            CallChecker.varInit(this.m_thread, "m_thread", 106, 3499, 3582);
            CallChecker.varInit(this.m_slReg, "m_slReg", 106, 3499, 3582);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 106, 3499, 3582);
            CallChecker.varInit(this.m_requests, "m_requests", 106, 3499, 3582);
            CallChecker.varInit(this.m_registry, "m_registry", 106, 3499, 3582);
            CallChecker.varInit(this.m_felix, "m_felix", 106, 3499, 3582);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 106, 3499, 3582);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 106, 3499, 3582);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 106, 3499, 3582);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 108, 3547, 3553)) {
                return CallChecker.isCalled(m_felix, Felix.class, 108, 3547, 3553).getActiveStartLevel();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context141.methodEnd();
        }
    }

    public void setStartLevel(int startlevel, FrameworkListener... listeners) {
        MethodContext _bcornu_methode_context142 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 111, 3589, 4411);
            CallChecker.varInit(listeners, "listeners", 111, 3589, 4411);
            CallChecker.varInit(startlevel, "startlevel", 111, 3589, 4411);
            CallChecker.varInit(this.m_thread, "m_thread", 111, 3589, 4411);
            CallChecker.varInit(this.m_slReg, "m_slReg", 111, 3589, 4411);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 111, 3589, 4411);
            CallChecker.varInit(this.m_requests, "m_requests", 111, 3589, 4411);
            CallChecker.varInit(this.m_registry, "m_registry", 111, 3589, 4411);
            CallChecker.varInit(this.m_felix, "m_felix", 111, 3589, 4411);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 111, 3589, 4411);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 111, 3589, 4411);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 111, 3589, 4411);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 113, 3677, 3716);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(m_felix, AdminPermission.STARTLEVEL));
            }
            if (startlevel <= 0) {
                throw new IllegalArgumentException("Start level must be greater than zero.");
            }
            synchronized(m_requests) {
                if ((m_thread) == null) {
                    throw new IllegalStateException("No inital startlevel yet");
                }
                if (CallChecker.beforeDeref(m_requestListeners, List.class, 134, 4273, 4290)) {
                    CallChecker.isCalled(m_requestListeners, List.class, 134, 4273, 4290).add(listeners);
                }
                if (CallChecker.beforeDeref(m_requests, List.class, 135, 4320, 4329)) {
                    CallChecker.isCalled(m_requests, List.class, 135, 4320, 4329).add(new Integer(startlevel));
                }
                if (CallChecker.beforeDeref(m_requests, List.class, 136, 4373, 4382)) {
                    CallChecker.isCalled(m_requests, List.class, 136, 4373, 4382).notifyAll();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context142.methodEnd();
        }
    }

    void setStartLevelAndWait(int startlevel) {
        MethodContext _bcornu_methode_context143 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 146, 4418, 5517);
            CallChecker.varInit(startlevel, "startlevel", 146, 4418, 5517);
            CallChecker.varInit(this.m_thread, "m_thread", 146, 4418, 5517);
            CallChecker.varInit(this.m_slReg, "m_slReg", 146, 4418, 5517);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 146, 4418, 5517);
            CallChecker.varInit(this.m_requests, "m_requests", 146, 4418, 5517);
            CallChecker.varInit(this.m_registry, "m_registry", 146, 4418, 5517);
            CallChecker.varInit(this.m_felix, "m_felix", 146, 4418, 5517);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 146, 4418, 5517);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 146, 4418, 5517);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 146, 4418, 5517);
            Object request = CallChecker.varInit(new Integer(startlevel), "request", 148, 4705, 4745);
            synchronized(request) {
                synchronized(m_requests) {
                    startThread();
                    if (CallChecker.beforeDeref(m_requestListeners, List.class, 156, 4967, 4984)) {
                        CallChecker.isCalled(m_requestListeners, List.class, 156, 4967, 4984).add(null);
                    }
                    if (CallChecker.beforeDeref(m_requests, List.class, 157, 5013, 5022)) {
                        CallChecker.isCalled(m_requests, List.class, 157, 5013, 5022).add(request);
                    }
                    if (CallChecker.beforeDeref(m_requests, List.class, 158, 5054, 5063)) {
                        CallChecker.isCalled(m_requests, List.class, 158, 5054, 5063).notifyAll();
                    }
                }
                TryContext _bcornu_try_context_19 = new TryContext(19, FrameworkStartLevelImpl.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(request, Object.class, 163, 5139, 5145)) {
                        request = CallChecker.beforeCalled(request, Object.class, 163, 5139, 5145);
                        CallChecker.isCalled(request, Object.class, 163, 5139, 5145).wait();
                    }
                } catch (InterruptedException ex) {
                    _bcornu_try_context_19.catchStart(19);
                    if (CallChecker.beforeDeref(m_felix, Felix.class, 168, 5319, 5325)) {
                        final Logger npe_invocation_var75 = CallChecker.isCalled(m_felix, Felix.class, 168, 5319, 5325).getLogger();
                        if (CallChecker.beforeDeref(npe_invocation_var75, Logger.class, 168, 5319, 5337)) {
                            CallChecker.isCalled(npe_invocation_var75, Logger.class, 168, 5319, 5337).log(Logger.LOG_WARNING, "Wait for start level change during shutdown interrupted.", ex);
                        }
                    }
                } finally {
                    _bcornu_try_context_19.finallyStart(19);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }

    public int getInitialBundleStartLevel() {
        MethodContext _bcornu_methode_context144 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 176, 5524, 5627);
            CallChecker.varInit(this.m_thread, "m_thread", 176, 5524, 5627);
            CallChecker.varInit(this.m_slReg, "m_slReg", 176, 5524, 5627);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 176, 5524, 5627);
            CallChecker.varInit(this.m_requests, "m_requests", 176, 5524, 5627);
            CallChecker.varInit(this.m_registry, "m_registry", 176, 5524, 5627);
            CallChecker.varInit(this.m_felix, "m_felix", 176, 5524, 5627);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 176, 5524, 5627);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 176, 5524, 5627);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 176, 5524, 5627);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 178, 5585, 5591)) {
                return CallChecker.isCalled(m_felix, Felix.class, 178, 5585, 5591).getInitialBundleStartLevel();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public void setInitialBundleStartLevel(int startlevel) {
        MethodContext _bcornu_methode_context145 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 181, 5634, 5976);
            CallChecker.varInit(startlevel, "startlevel", 181, 5634, 5976);
            CallChecker.varInit(this.m_thread, "m_thread", 181, 5634, 5976);
            CallChecker.varInit(this.m_slReg, "m_slReg", 181, 5634, 5976);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 181, 5634, 5976);
            CallChecker.varInit(this.m_requests, "m_requests", 181, 5634, 5976);
            CallChecker.varInit(this.m_registry, "m_registry", 181, 5634, 5976);
            CallChecker.varInit(this.m_felix, "m_felix", 181, 5634, 5976);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 181, 5634, 5976);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 181, 5634, 5976);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 181, 5634, 5976);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 183, 5703, 5742);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(m_felix, AdminPermission.STARTLEVEL));
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 190, 5924, 5930)) {
                CallChecker.isCalled(m_felix, Felix.class, 190, 5924, 5930).setInitialBundleStartLevel(startlevel);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context145.methodEnd();
        }
    }

    BundleStartLevel createBundleStartLevel(BundleImpl bundle) {
        MethodContext _bcornu_methode_context146 = new MethodContext(BundleStartLevel.class);
        try {
            CallChecker.varInit(this, "this", 193, 5983, 6101);
            CallChecker.varInit(bundle, "bundle", 193, 5983, 6101);
            CallChecker.varInit(this.m_thread, "m_thread", 193, 5983, 6101);
            CallChecker.varInit(this.m_slReg, "m_slReg", 193, 5983, 6101);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 193, 5983, 6101);
            CallChecker.varInit(this.m_requests, "m_requests", 193, 5983, 6101);
            CallChecker.varInit(this.m_registry, "m_registry", 193, 5983, 6101);
            CallChecker.varInit(this.m_felix, "m_felix", 193, 5983, 6101);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 193, 5983, 6101);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 193, 5983, 6101);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 193, 5983, 6101);
            return new FrameworkStartLevelImpl.BundleStartLevelImpl(bundle);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleStartLevel) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    class BundleStartLevelImpl implements BundleStartLevel {
        private BundleImpl m_bundle;

        private BundleStartLevelImpl(BundleImpl bundle) {
            MethodContext _bcornu_methode_context12 = new MethodContext(null);
            try {
                m_bundle = bundle;
                CallChecker.varAssign(this.m_bundle, "this.m_bundle", 204, 6285, 6302);
            } finally {
                _bcornu_methode_context12.methodEnd();
            }
        }

        public Bundle getBundle() {
            MethodContext _bcornu_methode_context147 = new MethodContext(Bundle.class);
            try {
                CallChecker.varInit(this, "this", 207, 6323, 6396);
                CallChecker.varInit(this.m_bundle, "m_bundle", 207, 6323, 6396);
                return m_bundle;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context147.methodEnd();
            }
        }

        public int getStartLevel() {
            MethodContext _bcornu_methode_context148 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 212, 6407, 6510);
                CallChecker.varInit(this.m_bundle, "m_bundle", 212, 6407, 6510);
                if (CallChecker.beforeDeref(m_felix, Felix.class, 214, 6463, 6469)) {
                    return CallChecker.isCalled(m_felix, Felix.class, 214, 6463, 6469).getBundleStartLevel(m_bundle);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context148.methodEnd();
            }
        }

        public void setStartLevel(int startlevel) {
            MethodContext _bcornu_methode_context149 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 217, 6521, 7654);
                CallChecker.varInit(startlevel, "startlevel", 217, 6521, 7654);
                CallChecker.varInit(this.m_bundle, "m_bundle", 217, 6521, 7654);
                Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 219, 6585, 6624);
                if (sm != null) {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(m_bundle, AdminPermission.EXECUTE));
                }
                if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 227, 6833, 6840)) {
                    m_bundle = CallChecker.beforeCalled(m_bundle, BundleImpl.class, 227, 6833, 6840);
                    if ((CallChecker.isCalled(m_bundle, BundleImpl.class, 227, 6833, 6840).getBundleId()) == 0) {
                        throw new IllegalArgumentException("Cannot change system bundle start level.");
                    }else
                        if (startlevel <= 0) {
                            throw new IllegalArgumentException("Start level must be greater than zero.");
                        }
                    
                }
                synchronized(m_requests) {
                    startThread();
                    if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 242, 7392, 7399)) {
                        m_bundle = CallChecker.beforeCalled(m_bundle, BundleImpl.class, 242, 7392, 7399);
                        CallChecker.isCalled(m_bundle, BundleImpl.class, 242, 7392, 7399).setStartLevel(startlevel);
                    }
                    if (CallChecker.beforeDeref(m_requestListeners, List.class, 244, 7478, 7495)) {
                        CallChecker.isCalled(m_requestListeners, List.class, 244, 7478, 7495).add(null);
                    }
                    if (CallChecker.beforeDeref(m_requests, List.class, 245, 7524, 7533)) {
                        CallChecker.isCalled(m_requests, List.class, 245, 7524, 7533).add(new Object[]{ m_bundle , new Integer(startlevel) });
                    }
                    if (CallChecker.beforeDeref(m_requests, List.class, 246, 7608, 7617)) {
                        CallChecker.isCalled(m_requests, List.class, 246, 7608, 7617).notifyAll();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context149.methodEnd();
            }
        }

        public boolean isPersistentlyStarted() {
            MethodContext _bcornu_methode_context150 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 250, 7665, 7788);
                CallChecker.varInit(this.m_bundle, "m_bundle", 250, 7665, 7788);
                if (CallChecker.beforeDeref(m_felix, Felix.class, 252, 7733, 7739)) {
                    return CallChecker.isCalled(m_felix, Felix.class, 252, 7733, 7739).isBundlePersistentlyStarted(m_bundle);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context150.methodEnd();
            }
        }

        public boolean isActivationPolicyUsed() {
            MethodContext _bcornu_methode_context151 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 255, 7799, 7924);
                CallChecker.varInit(this.m_bundle, "m_bundle", 255, 7799, 7924);
                if (CallChecker.beforeDeref(m_felix, Felix.class, 257, 7868, 7874)) {
                    return CallChecker.isCalled(m_felix, Felix.class, 257, 7868, 7874).isBundleActivationPolicyUsed(m_bundle);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context151.methodEnd();
            }
        }
    }

    public void run() {
        MethodContext _bcornu_methode_context152 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 261, 7937, 11147);
            CallChecker.varInit(this.m_thread, "m_thread", 261, 7937, 11147);
            CallChecker.varInit(this.m_slReg, "m_slReg", 261, 7937, 11147);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 261, 7937, 11147);
            CallChecker.varInit(this.m_requests, "m_requests", 261, 7937, 11147);
            CallChecker.varInit(this.m_registry, "m_registry", 261, 7937, 11147);
            CallChecker.varInit(this.m_felix, "m_felix", 261, 7937, 11147);
            CallChecker.varInit(STARTLEVEL_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.STARTLEVEL_IDX", 261, 7937, 11147);
            CallChecker.varInit(BUNDLE_IDX, "org.apache.felix.framework.FrameworkStartLevelImpl.BUNDLE_IDX", 261, 7937, 11147);
            CallChecker.varInit(THREAD_NAME, "org.apache.felix.framework.FrameworkStartLevelImpl.THREAD_NAME", 261, 7937, 11147);
            Object previousRequest = CallChecker.varInit(null, "previousRequest", 265, 8053, 8082);
            while (true) {
                Object request = CallChecker.varInit(null, "request", 268, 8127, 8148);
                FrameworkListener[] listeners = CallChecker.varInit(null, "listeners", 269, 8162, 8198);
                synchronized(m_requests) {
                    while (CallChecker.isCalled(m_requests, List.class, 273, 8314, 8323).isEmpty()) {
                        if ((m_thread) == null) {
                            return ;
                        }
                        TryContext _bcornu_try_context_20 = new TryContext(20, FrameworkStartLevelImpl.class, "java.lang.InterruptedException");
                        try {
                            if (CallChecker.beforeDeref(m_requests, List.class, 283, 8623, 8632)) {
                                CallChecker.isCalled(m_requests, List.class, 283, 8623, 8632).wait();
                            }
                        } catch (InterruptedException ex) {
                            _bcornu_try_context_20.catchStart(20);
                        } finally {
                            _bcornu_try_context_20.finallyStart(20);
                        }
                    } 
                    if (CallChecker.beforeDeref(m_requests, List.class, 292, 8890, 8899)) {
                        request = CallChecker.isCalled(m_requests, List.class, 292, 8890, 8899).remove(0);
                        CallChecker.varAssign(request, "request", 292, 8880, 8910);
                    }
                    if (CallChecker.beforeDeref(m_requestListeners, List.class, 293, 8940, 8957)) {
                        listeners = CallChecker.isCalled(m_requestListeners, List.class, 293, 8940, 8957).remove(0);
                        CallChecker.varAssign(listeners, "listeners", 293, 8928, 8968);
                    }
                }
                if (request instanceof Integer) {
                    TryContext _bcornu_try_context_21 = new TryContext(21, FrameworkStartLevelImpl.class, "java.lang.IllegalStateException", "java.lang.Exception");
                    try {
                        if (CallChecker.beforeDeref(request, Object.class, 308, 9629, 9635)) {
                            if (CallChecker.beforeDeref(m_felix, Felix.class, 308, 9590, 9596)) {
                                request = CallChecker.beforeCalled(request, Integer.class, 308, 9629, 9635);
                                CallChecker.isCalled(m_felix, Felix.class, 308, 9590, 9596).setActiveStartLevel(CallChecker.isCalled(((Integer) (request)), Integer.class, 308, 9629, 9635).intValue(), listeners);
                            }
                        }
                    } catch (IllegalStateException ise) {
                        _bcornu_try_context_21.catchStart(21);
                        if (previousRequest == request) {
                            if (CallChecker.beforeDeref(m_felix, Felix.class, 316, 9983, 9989)) {
                                final Logger npe_invocation_var76 = CallChecker.isCalled(m_felix, Felix.class, 316, 9983, 9989).getLogger();
                                if (CallChecker.beforeDeref(npe_invocation_var76, Logger.class, 316, 9983, 10001)) {
                                    CallChecker.isCalled(npe_invocation_var76, Logger.class, 316, 9983, 10001).log(Logger.LOG_ERROR, ("Unexpected problem setting active start level to " + request), ise);
                                }
                            }
                        }else {
                            synchronized(m_requests) {
                                if (CallChecker.beforeDeref(m_requests, List.class, 323, 10295, 10304)) {
                                    CallChecker.isCalled(m_requests, List.class, 323, 10295, 10304).add(0, request);
                                }
                                previousRequest = request;
                                CallChecker.varAssign(previousRequest, "previousRequest", 324, 10351, 10376);
                            }
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_21.catchStart(21);
                        if (CallChecker.beforeDeref(m_felix, Felix.class, 330, 10519, 10525)) {
                            final Logger npe_invocation_var77 = CallChecker.isCalled(m_felix, Felix.class, 330, 10519, 10525).getLogger();
                            if (CallChecker.beforeDeref(npe_invocation_var77, Logger.class, 330, 10519, 10537)) {
                                CallChecker.isCalled(npe_invocation_var77, Logger.class, 330, 10519, 10537).log(Logger.LOG_ERROR, ("Unexpected problem setting active start level to " + request), ex);
                            }
                        }
                    } finally {
                        _bcornu_try_context_21.finallyStart(21);
                    }
                }else {
                    Bundle bundle = CallChecker.init(Bundle.class);
                    if (CallChecker.beforeDeref(request, Object.class, 336, 10769, 10775)) {
                        request = CallChecker.beforeCalled(request, Object[].class, 336, 10769, 10775);
                        bundle = ((Bundle) (CallChecker.isCalled(((Object[]) (request)), Object[].class, 336, 10769, 10775)[FrameworkStartLevelImpl.BUNDLE_IDX]));
                        CallChecker.varAssign(bundle, "bundle", 336, 10769, 10775);
                    }
                    int startlevel = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(request, Object.class, 337, 10847, 10853)) {
                        request = CallChecker.beforeCalled(request, Object[].class, 337, 10847, 10853);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((Object[]) (request)), Object[].class, 337, 10847, 10853)[FrameworkStartLevelImpl.STARTLEVEL_IDX], Object.class, 337, 10835, 10870)) {
                            request = CallChecker.beforeCalled(request, Object[].class, 337, 10847, 10853);
                            CallChecker.isCalled(((Object[]) (request)), Object[].class, 337, 10847, 10853)[FrameworkStartLevelImpl.STARTLEVEL_IDX] = CallChecker.beforeCalled(CallChecker.isCalled(((Object[]) (request)), Object[].class, 337, 10847, 10853)[FrameworkStartLevelImpl.STARTLEVEL_IDX], Integer.class, 337, 10835, 10870);
                            startlevel = CallChecker.isCalled(((Integer) (CallChecker.isCalled(((Object[]) (request)), Object[].class, 337, 10847, 10853)[FrameworkStartLevelImpl.STARTLEVEL_IDX])), Integer.class, 337, 10835, 10870).intValue();
                            CallChecker.varAssign(startlevel, "startlevel", 337, 10847, 10853);
                        }
                    }
                    if (CallChecker.beforeDeref(m_felix, Felix.class, 338, 10901, 10907)) {
                        CallChecker.isCalled(m_felix, Felix.class, 338, 10901, 10907).setBundleStartLevel(bundle, startlevel);
                    }
                }
                synchronized(request) {
                    if (CallChecker.beforeDeref(request, Object.class, 344, 11098, 11104)) {
                        request = CallChecker.beforeCalled(request, Object.class, 344, 11098, 11104);
                        CallChecker.isCalled(request, Object.class, 344, 11098, 11104).notifyAll();
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context152.methodEnd();
        }
    }
}

