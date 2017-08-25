package org.apache.felix.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.osgi.framework.wiring.FrameworkWiring;
import org.osgi.framework.FrameworkListener;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.Bundle;
import java.util.ArrayList;
import org.osgi.framework.AdminPermission;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.resource.Requirement;
import org.osgi.framework.ServiceRegistration;

class FrameworkWiringImpl implements Runnable , FrameworkWiring {
    private final Felix m_felix;

    private final ServiceRegistry m_registry;

    private final List<Collection<Bundle>> m_requests = new ArrayList();

    private final List<FrameworkListener[]> m_requestListeners = new ArrayList<FrameworkListener[]>();

    private ServiceRegistration<PackageAdmin> m_paReg;

    private Thread m_thread = null;

    public FrameworkWiringImpl(Felix felix, ServiceRegistry registry) {
        MethodContext _bcornu_methode_context31 = new MethodContext(null);
        try {
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 48, 1832, 1847);
            m_registry = registry;
            CallChecker.varAssign(this.m_registry, "this.m_registry", 49, 1857, 1878);
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    void start() {
        MethodContext _bcornu_methode_context452 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 53, 1891, 2172);
            CallChecker.varInit(this.m_thread, "m_thread", 53, 1891, 2172);
            CallChecker.varInit(this.m_paReg, "m_paReg", 53, 1891, 2172);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 53, 1891, 2172);
            CallChecker.varInit(this.m_requests, "m_requests", 53, 1891, 2172);
            CallChecker.varInit(this.m_registry, "m_registry", 53, 1891, 2172);
            CallChecker.varInit(this.m_felix, "m_felix", 53, 1891, 2172);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 55, 1999, 2008)) {
                m_paReg = ((ServiceRegistration<PackageAdmin>) (CallChecker.isCalled(m_registry, ServiceRegistry.class, 55, 1999, 2008).registerService(m_felix, new String[]{ PackageAdmin.class.getName() }, new PackageAdminImpl(m_felix), null)));
                CallChecker.varAssign(this.m_paReg, "this.m_paReg", 55, 1953, 2166);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context452.methodEnd();
        }
    }

    void stop() {
        MethodContext _bcornu_methode_context453 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 70, 2179, 3030);
            CallChecker.varInit(this.m_thread, "m_thread", 70, 2179, 3030);
            CallChecker.varInit(this.m_paReg, "m_paReg", 70, 2179, 3030);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 70, 2179, 3030);
            CallChecker.varInit(this.m_requests, "m_requests", 70, 2179, 3030);
            CallChecker.varInit(this.m_registry, "m_registry", 70, 2179, 3030);
            CallChecker.varInit(this.m_felix, "m_felix", 70, 2179, 3030);
            synchronized(m_requests) {
                if ((m_thread) != null) {
                    m_thread = null;
                    CallChecker.varAssign(this.m_thread, "this.m_thread", 78, 2832, 2847);
                    if (CallChecker.beforeDeref(m_requests, List.class, 82, 2978, 2987)) {
                        CallChecker.isCalled(m_requests, List.class, 82, 2978, 2987).notifyAll();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context453.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context454 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 87, 3037, 3097);
            CallChecker.varInit(this.m_thread, "m_thread", 87, 3037, 3097);
            CallChecker.varInit(this.m_paReg, "m_paReg", 87, 3037, 3097);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 87, 3037, 3097);
            CallChecker.varInit(this.m_requests, "m_requests", 87, 3037, 3097);
            CallChecker.varInit(this.m_registry, "m_registry", 87, 3037, 3097);
            CallChecker.varInit(this.m_felix, "m_felix", 87, 3037, 3097);
            return m_felix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context454.methodEnd();
        }
    }

    public void refreshBundles(Collection<Bundle> bundles, FrameworkListener... listeners) {
        MethodContext _bcornu_methode_context455 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 92, 3104, 3922);
            CallChecker.varInit(listeners, "listeners", 92, 3104, 3922);
            CallChecker.varInit(bundles, "bundles", 92, 3104, 3922);
            CallChecker.varInit(this.m_thread, "m_thread", 92, 3104, 3922);
            CallChecker.varInit(this.m_paReg, "m_paReg", 92, 3104, 3922);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 92, 3104, 3922);
            CallChecker.varInit(this.m_requests, "m_requests", 92, 3104, 3922);
            CallChecker.varInit(this.m_registry, "m_registry", 92, 3104, 3922);
            CallChecker.varInit(this.m_felix, "m_felix", 92, 3104, 3922);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 94, 3205, 3244);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(m_felix, AdminPermission.RESOLVE));
            }
            synchronized(m_requests) {
                if ((m_thread) == null) {
                    m_thread = new Thread(this, "FelixFrameworkWiring");
                    CallChecker.varAssign(this.m_thread, "this.m_thread", 106, 3596, 3647);
                    if (CallChecker.beforeDeref(m_thread, Thread.class, 107, 3665, 3672)) {
                        m_thread = CallChecker.beforeCalled(m_thread, Thread.class, 107, 3665, 3672);
                        CallChecker.isCalled(m_thread, Thread.class, 107, 3665, 3672).setDaemon(true);
                    }
                    if (CallChecker.beforeDeref(m_thread, Thread.class, 108, 3707, 3714)) {
                        m_thread = CallChecker.beforeCalled(m_thread, Thread.class, 108, 3707, 3714);
                        CallChecker.isCalled(m_thread, Thread.class, 108, 3707, 3714).start();
                    }
                }
                if (CallChecker.beforeDeref(m_requests, List.class, 112, 3800, 3809)) {
                    CallChecker.isCalled(m_requests, List.class, 112, 3800, 3809).add(bundles);
                }
                if (CallChecker.beforeDeref(m_requestListeners, List.class, 113, 3837, 3854)) {
                    CallChecker.isCalled(m_requestListeners, List.class, 113, 3837, 3854).add(listeners);
                }
                if (CallChecker.beforeDeref(m_requests, List.class, 114, 3884, 3893)) {
                    CallChecker.isCalled(m_requests, List.class, 114, 3884, 3893).notifyAll();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context455.methodEnd();
        }
    }

    public boolean resolveBundles(Collection<Bundle> bundles) {
        MethodContext _bcornu_methode_context456 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 118, 3929, 4341);
            CallChecker.varInit(bundles, "bundles", 118, 3929, 4341);
            CallChecker.varInit(this.m_thread, "m_thread", 118, 3929, 4341);
            CallChecker.varInit(this.m_paReg, "m_paReg", 118, 3929, 4341);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 118, 3929, 4341);
            CallChecker.varInit(this.m_requests, "m_requests", 118, 3929, 4341);
            CallChecker.varInit(this.m_registry, "m_registry", 118, 3929, 4341);
            CallChecker.varInit(this.m_felix, "m_felix", 118, 3929, 4341);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 120, 4001, 4040);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(m_felix, AdminPermission.RESOLVE));
            }
            if ((m_thread) == null) {
                return false;
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 133, 4304, 4310)) {
                return CallChecker.isCalled(m_felix, Felix.class, 133, 4304, 4310).resolveBundles(bundles);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context456.methodEnd();
        }
    }

    public Collection<Bundle> getRemovalPendingBundles() {
        MethodContext _bcornu_methode_context457 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 136, 4348, 4462);
            CallChecker.varInit(this.m_thread, "m_thread", 136, 4348, 4462);
            CallChecker.varInit(this.m_paReg, "m_paReg", 136, 4348, 4462);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 136, 4348, 4462);
            CallChecker.varInit(this.m_requests, "m_requests", 136, 4348, 4462);
            CallChecker.varInit(this.m_registry, "m_registry", 136, 4348, 4462);
            CallChecker.varInit(this.m_felix, "m_felix", 136, 4348, 4462);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 138, 4422, 4428)) {
                return CallChecker.isCalled(m_felix, Felix.class, 138, 4422, 4428).getRemovalPendingBundles();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context457.methodEnd();
        }
    }

    public Collection<Bundle> getDependencyClosure(Collection<Bundle> targets) {
        MethodContext _bcornu_methode_context458 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 141, 4469, 4608);
            CallChecker.varInit(targets, "targets", 141, 4469, 4608);
            CallChecker.varInit(this.m_thread, "m_thread", 141, 4469, 4608);
            CallChecker.varInit(this.m_paReg, "m_paReg", 141, 4469, 4608);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 141, 4469, 4608);
            CallChecker.varInit(this.m_requests, "m_requests", 141, 4469, 4608);
            CallChecker.varInit(this.m_registry, "m_registry", 141, 4469, 4608);
            CallChecker.varInit(this.m_felix, "m_felix", 141, 4469, 4608);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 143, 4565, 4571)) {
                return CallChecker.isCalled(m_felix, Felix.class, 143, 4565, 4571).getDependencyClosure(targets);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Bundle>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context458.methodEnd();
        }
    }

    public void run() {
        MethodContext _bcornu_methode_context459 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 151, 4615, 6317);
            CallChecker.varInit(this.m_thread, "m_thread", 151, 4615, 6317);
            CallChecker.varInit(this.m_paReg, "m_paReg", 151, 4615, 6317);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 151, 4615, 6317);
            CallChecker.varInit(this.m_requests, "m_requests", 151, 4615, 6317);
            CallChecker.varInit(this.m_registry, "m_registry", 151, 4615, 6317);
            CallChecker.varInit(this.m_felix, "m_felix", 151, 4615, 6317);
            while (true) {
                Collection<Bundle> bundles = CallChecker.varInit(null, "bundles", 157, 4939, 4972);
                FrameworkListener[] listeners = CallChecker.varInit(null, "listeners", 158, 4986, 5022);
                synchronized(m_requests) {
                    while (CallChecker.isCalled(m_requests, List.class, 162, 5146, 5155).isEmpty()) {
                        if ((m_thread) == null) {
                            return ;
                        }
                        TryContext _bcornu_try_context_127 = new TryContext(127, FrameworkWiringImpl.class, "java.lang.InterruptedException");
                        try {
                            if (CallChecker.beforeDeref(m_requests, List.class, 172, 5455, 5464)) {
                                CallChecker.isCalled(m_requests, List.class, 172, 5455, 5464).wait();
                            }
                        } catch (InterruptedException ex) {
                            _bcornu_try_context_127.catchStart(127);
                        } finally {
                            _bcornu_try_context_127.finallyStart(127);
                        }
                    } 
                    if (CallChecker.beforeDeref(m_requests, List.class, 180, 5715, 5724)) {
                        bundles = CallChecker.isCalled(m_requests, List.class, 180, 5715, 5724).get(0);
                        CallChecker.varAssign(bundles, "bundles", 180, 5705, 5732);
                    }
                    if (CallChecker.beforeDeref(m_requestListeners, List.class, 181, 5762, 5779)) {
                        listeners = CallChecker.isCalled(m_requestListeners, List.class, 181, 5762, 5779).get(0);
                        CallChecker.varAssign(listeners, "listeners", 181, 5750, 5787);
                    }
                }
                if (CallChecker.beforeDeref(m_felix, Felix.class, 188, 6040, 6046)) {
                    CallChecker.isCalled(m_felix, Felix.class, 188, 6040, 6046).refreshPackages(bundles, listeners);
                }
                synchronized(m_requests) {
                    if (CallChecker.beforeDeref(m_requests, List.class, 193, 6221, 6230)) {
                        CallChecker.isCalled(m_requests, List.class, 193, 6221, 6230).remove(0);
                    }
                    if (CallChecker.beforeDeref(m_requestListeners, List.class, 194, 6259, 6276)) {
                        CallChecker.isCalled(m_requestListeners, List.class, 194, 6259, 6276).remove(0);
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context459.methodEnd();
        }
    }

    public Collection<BundleCapability> findProviders(final Requirement requirement) {
        MethodContext _bcornu_methode_context460 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 202, 6324, 6581);
            CallChecker.varInit(requirement, "requirement", 202, 6324, 6581);
            CallChecker.varInit(this.m_thread, "m_thread", 202, 6324, 6581);
            CallChecker.varInit(this.m_paReg, "m_paReg", 202, 6324, 6581);
            CallChecker.varInit(this.m_requestListeners, "m_requestListeners", 202, 6324, 6581);
            CallChecker.varInit(this.m_requests, "m_requests", 202, 6324, 6581);
            CallChecker.varInit(this.m_registry, "m_registry", 202, 6324, 6581);
            CallChecker.varInit(this.m_felix, "m_felix", 202, 6324, 6581);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 204, 6541, 6547)) {
                return CallChecker.isCalled(m_felix, Felix.class, 204, 6541, 6547).findProviders(requirement);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context460.methodEnd();
        }
    }
}

