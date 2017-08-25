package org.apache.felix.framework.util;

import org.osgi.framework.UnfilteredServiceListener;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.HashMap;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.launch.Framework;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.Filter;
import java.util.EventObject;
import org.osgi.framework.hooks.service.EventListenerHook;
import java.util.EventListener;
import org.osgi.framework.hooks.bundle.EventHook;
import java.util.Dictionary;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.security.AccessController;
import org.osgi.framework.AllServiceListener;
import java.util.ArrayList;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.apache.felix.framework.HookRegistry;
import java.util.List;
import org.osgi.framework.hooks.service.ListenerHook;
import org.apache.felix.framework.Logger;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.security.PrivilegedAction;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServicePermission;
import org.osgi.framework.ServiceReference;
import org.apache.felix.framework.ServiceRegistry;
import java.util.Set;
import org.osgi.framework.SynchronousBundleListener;

public class EventDispatcher {
    private final Logger m_logger;

    private final ServiceRegistry m_registry;

    private Map<BundleContext, List<ListenerInfo>> m_fwkListeners = Collections.EMPTY_MAP;

    private Map<BundleContext, List<ListenerInfo>> m_bndlListeners = Collections.EMPTY_MAP;

    private Map<BundleContext, List<ListenerInfo>> m_syncBndlListeners = Collections.EMPTY_MAP;

    private Map<BundleContext, List<ListenerInfo>> m_svcListeners = Collections.EMPTY_MAP;

    private static Thread m_thread = null;

    private static final String m_threadLock = new String("thread lock");

    private static int m_references = 0;

    private static volatile boolean m_stopping = false;

    private static final List<EventDispatcher.Request> m_requestList = new ArrayList<EventDispatcher.Request>();

    private static final List<EventDispatcher.Request> m_requestPool = new ArrayList<EventDispatcher.Request>();

    private static final SecureAction m_secureAction = new SecureAction();

    public EventDispatcher(Logger logger, ServiceRegistry registry) {
        MethodContext _bcornu_methode_context128 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 84, 3245, 3262);
            m_registry = registry;
            CallChecker.varAssign(this.m_registry, "this.m_registry", 85, 3272, 3293);
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public void startDispatching() {
        MethodContext _bcornu_methode_context1231 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 88, 3306, 4574);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 88, 3306, 4574);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 88, 3306, 4574);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 88, 3306, 4574);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 88, 3306, 4574);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 88, 3306, 4574);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 88, 3306, 4574);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 88, 3306, 4574);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 88, 3306, 4574);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 88, 3306, 4574);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 88, 3306, 4574);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 88, 3306, 4574);
            CallChecker.varInit(this.m_registry, "m_registry", 88, 3306, 4574);
            CallChecker.varInit(this.m_logger, "m_logger", 88, 3306, 4574);
            synchronized(EventDispatcher.m_threadLock) {
                if (((EventDispatcher.m_thread) == null) || (!(EventDispatcher.m_thread.isAlive()))) {
                    EventDispatcher.m_stopping = false;
                    CallChecker.varAssign(EventDispatcher.m_stopping, "EventDispatcher.m_stopping", 95, 3536, 3554);
                    EventDispatcher.m_thread = new Thread(new Runnable() {
                        public void run() {
                            MethodContext _bcornu_methode_context1230 = new MethodContext(void.class);
                            try {
                                CallChecker.varInit(this, "this", 98, 3632, 4395);
                                TryContext _bcornu_try_context_341 = new TryContext(341, EventDispatcher.class);
                                try {
                                    EventDispatcher.run();
                                } finally {
                                    _bcornu_try_context_341.finallyStart(341);
                                    synchronized(EventDispatcher.m_threadLock) {
                                        EventDispatcher.m_thread = null;
                                        CallChecker.varAssign(EventDispatcher.m_thread, "EventDispatcher.m_thread", 110, 4142, 4157);
                                        EventDispatcher.m_stopping = false;
                                        CallChecker.varAssign(EventDispatcher.m_stopping, "EventDispatcher.m_stopping", 111, 4191, 4209);
                                        EventDispatcher.m_references = 0;
                                        CallChecker.varAssign(EventDispatcher.m_references, "EventDispatcher.m_references", 112, 4243, 4259);
                                        if (CallChecker.beforeDeref(EventDispatcher.m_threadLock, String.class, 113, 4293, 4304)) {
                                            CallChecker.isCalled(EventDispatcher.m_threadLock, String.class, 113, 4293, 4304).notifyAll();
                                        }
                                    }
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                _bcornu_return_t.getDecision().getValue();
                                return ;
                            } finally {
                                _bcornu_methode_context1230.methodEnd();
                            }
                        }
                    }, "FelixDispatchQueue");
                    CallChecker.varAssign(EventDispatcher.m_thread, "EventDispatcher.m_thread", 97, 3573, 4437);
                    if (CallChecker.beforeDeref(EventDispatcher.m_thread, Thread.class, 118, 4455, 4462)) {
                        EventDispatcher.m_thread = CallChecker.beforeCalled(EventDispatcher.m_thread, Thread.class, 118, 4455, 4462);
                        CallChecker.isCalled(EventDispatcher.m_thread, Thread.class, 118, 4455, 4462).start();
                    }
                }
                (EventDispatcher.m_references)++;
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1231.methodEnd();
        }
    }

    public void stopDispatching() {
        MethodContext _bcornu_methode_context1232 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 126, 4581, 5567);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 126, 4581, 5567);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 126, 4581, 5567);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 126, 4581, 5567);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 126, 4581, 5567);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 126, 4581, 5567);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 126, 4581, 5567);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 126, 4581, 5567);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 126, 4581, 5567);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 126, 4581, 5567);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 126, 4581, 5567);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 126, 4581, 5567);
            CallChecker.varInit(this.m_registry, "m_registry", 126, 4581, 5567);
            CallChecker.varInit(this.m_logger, "m_logger", 126, 4581, 5567);
            synchronized(EventDispatcher.m_threadLock) {
                if (((EventDispatcher.m_thread) == null) || (EventDispatcher.m_stopping)) {
                    return ;
                }
                (EventDispatcher.m_references)--;
                if ((EventDispatcher.m_references) > 0) {
                    return ;
                }
                EventDispatcher.m_stopping = true;
                CallChecker.varAssign(EventDispatcher.m_stopping, "EventDispatcher.m_stopping", 143, 5014, 5031);
            }
            synchronized(EventDispatcher.m_requestList) {
                if (CallChecker.beforeDeref(EventDispatcher.m_requestList, List.class, 149, 5138, 5150)) {
                    CallChecker.isCalled(EventDispatcher.m_requestList, List.class, 149, 5138, 5150).notify();
                }
            }
            synchronized(EventDispatcher.m_threadLock) {
                while ((EventDispatcher.m_thread) != null) {
                    TryContext _bcornu_try_context_342 = new TryContext(342, EventDispatcher.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(EventDispatcher.m_threadLock, String.class, 159, 5416, 5427)) {
                            CallChecker.isCalled(EventDispatcher.m_threadLock, String.class, 159, 5416, 5427).wait();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_342.catchStart(342);
                    } finally {
                        _bcornu_try_context_342.finallyStart(342);
                    }
                } 
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1232.methodEnd();
        }
    }

    public Filter addListener(BundleContext bc, Class clazz, EventListener l, Filter filter) {
        MethodContext _bcornu_methode_context1233 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 168, 5574, 8852);
            CallChecker.varInit(filter, "filter", 168, 5574, 8852);
            CallChecker.varInit(l, "l", 168, 5574, 8852);
            CallChecker.varInit(clazz, "clazz", 168, 5574, 8852);
            CallChecker.varInit(bc, "bc", 168, 5574, 8852);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 168, 5574, 8852);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 168, 5574, 8852);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 168, 5574, 8852);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 168, 5574, 8852);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 168, 5574, 8852);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 168, 5574, 8852);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 168, 5574, 8852);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 168, 5574, 8852);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 168, 5574, 8852);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 168, 5574, 8852);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 168, 5574, 8852);
            CallChecker.varInit(this.m_registry, "m_registry", 168, 5574, 8852);
            CallChecker.varInit(this.m_logger, "m_logger", 168, 5574, 8852);
            if (l == null) {
                throw new IllegalArgumentException("Listener is null");
            }else
                if (CallChecker.beforeDeref(clazz, Class.class, 175, 5830, 5834)) {
                    clazz = CallChecker.beforeCalled(clazz, Class.class, 175, 5830, 5834);
                    if (!(CallChecker.isCalled(clazz, Class.class, 175, 5830, 5834).isInstance(l))) {
                        if (CallChecker.beforeDeref(clazz, Class.class, 178, 5951, 5955)) {
                            clazz = CallChecker.beforeCalled(clazz, Class.class, 178, 5951, 5955);
                            throw new IllegalArgumentException(("Listener not of type " + (CallChecker.isCalled(clazz, Class.class, 178, 5951, 5955).getName())));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            
            Filter oldFilter = CallChecker.varInit(updateListener(bc, clazz, l, filter), "oldFilter", 183, 6083, 6138);
            if (oldFilter != null) {
                return oldFilter;
            }
            synchronized(this) {
                TryContext _bcornu_try_context_343 = new TryContext(343, EventDispatcher.class, "java.lang.IllegalStateException");
                try {
                    if (CallChecker.beforeDeref(bc, BundleContext.class, 195, 6416, 6417)) {
                        bc = CallChecker.beforeCalled(bc, BundleContext.class, 195, 6416, 6417);
                        CallChecker.isCalled(bc, BundleContext.class, 195, 6416, 6417).getBundle();
                    }
                } catch (IllegalStateException ex) {
                    _bcornu_try_context_343.catchStart(343);
                    return null;
                } finally {
                    _bcornu_try_context_343.finallyStart(343);
                }
                Map<BundleContext, List<ListenerInfo>> listeners = CallChecker.varInit(null, "listeners", 203, 6631, 6686);
                Object acc = CallChecker.varInit(null, "acc", 204, 6700, 6717);
                if (clazz == (FrameworkListener.class)) {
                    listeners = m_fwkListeners;
                    CallChecker.varAssign(listeners, "listeners", 208, 6800, 6826);
                }else
                    if (clazz == (BundleListener.class)) {
                        if (SynchronousBundleListener.class.isInstance(l)) {
                            listeners = m_syncBndlListeners;
                            CallChecker.varAssign(listeners, "listeners", 214, 7013, 7044);
                        }else {
                            listeners = m_bndlListeners;
                            CallChecker.varAssign(listeners, "listeners", 218, 7123, 7150);
                        }
                    }else
                        if (clazz == (ServiceListener.class)) {
                            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 224, 7342, 7381);
                            if (sm != null) {
                                acc = ((SecurityManager) (sm)).getSecurityContext();
                                CallChecker.varAssign(acc, "acc", 227, 7453, 7502);
                            }
                            listeners = m_svcListeners;
                            CallChecker.varAssign(listeners, "listeners", 233, 7847, 7873);
                        }else {
                            if (CallChecker.beforeDeref(l, EventListener.class, 237, 7994, 7994)) {
                                l = CallChecker.beforeCalled(l, EventListener.class, 237, 7994, 7994);
                                throw new IllegalArgumentException(("Unknown listener: " + (CallChecker.isCalled(l, EventListener.class, 237, 7994, 7994).getClass())));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    
                
                ListenerInfo info = CallChecker.init(ListenerInfo.class);
                if (CallChecker.beforeDeref(bc, BundleContext.class, 242, 8118, 8119)) {
                    bc = CallChecker.beforeCalled(bc, BundleContext.class, 242, 8118, 8119);
                    info = new ListenerInfo(CallChecker.isCalled(bc, BundleContext.class, 242, 8118, 8119).getBundle(), bc, clazz, l, filter, acc, false);
                    CallChecker.varAssign(info, "info", 242, 8118, 8119);
                }
                listeners = EventDispatcher.addListenerInfo(listeners, info);
                CallChecker.varAssign(listeners, "listeners", 243, 8181, 8225);
                if (clazz == (FrameworkListener.class)) {
                    m_fwkListeners = listeners;
                    CallChecker.varAssign(this.m_fwkListeners, "this.m_fwkListeners", 247, 8308, 8334);
                }else
                    if (clazz == (BundleListener.class)) {
                        if (SynchronousBundleListener.class.isInstance(l)) {
                            m_syncBndlListeners = listeners;
                            CallChecker.varAssign(this.m_syncBndlListeners, "this.m_syncBndlListeners", 253, 8521, 8552);
                        }else {
                            m_bndlListeners = listeners;
                            CallChecker.varAssign(this.m_bndlListeners, "this.m_bndlListeners", 257, 8631, 8658);
                        }
                    }else
                        if (clazz == (ServiceListener.class)) {
                            m_svcListeners = listeners;
                            CallChecker.varAssign(this.m_svcListeners, "this.m_svcListeners", 262, 8775, 8801);
                        }
                    
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1233.methodEnd();
        }
    }

    public ListenerHook.ListenerInfo removeListener(BundleContext bc, Class clazz, EventListener l) {
        MethodContext _bcornu_methode_context1234 = new MethodContext(ListenerHook.ListenerInfo.class);
        try {
            CallChecker.varInit(this, "this", 268, 8859, 12164);
            CallChecker.varInit(l, "l", 268, 8859, 12164);
            CallChecker.varInit(clazz, "clazz", 268, 8859, 12164);
            CallChecker.varInit(bc, "bc", 268, 8859, 12164);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 268, 8859, 12164);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 268, 8859, 12164);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 268, 8859, 12164);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 268, 8859, 12164);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 268, 8859, 12164);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 268, 8859, 12164);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 268, 8859, 12164);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 268, 8859, 12164);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 268, 8859, 12164);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 268, 8859, 12164);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 268, 8859, 12164);
            CallChecker.varInit(this.m_registry, "m_registry", 268, 8859, 12164);
            CallChecker.varInit(this.m_logger, "m_logger", 268, 8859, 12164);
            ListenerHook.ListenerInfo returnInfo = CallChecker.varInit(null, "returnInfo", 271, 8978, 9021);
            if (l == null) {
                throw new IllegalArgumentException("Listener is null");
            }else
                if (CallChecker.beforeDeref(clazz, Class.class, 278, 9181, 9185)) {
                    clazz = CallChecker.beforeCalled(clazz, Class.class, 278, 9181, 9185);
                    if (!(CallChecker.isCalled(clazz, Class.class, 278, 9181, 9185).isInstance(l))) {
                        if (CallChecker.beforeDeref(clazz, Class.class, 281, 9302, 9306)) {
                            clazz = CallChecker.beforeCalled(clazz, Class.class, 281, 9302, 9306);
                            throw new IllegalArgumentException(("Listener not of type " + (CallChecker.isCalled(clazz, Class.class, 281, 9302, 9306).getName())));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            
            synchronized(this) {
                Map<BundleContext, List<ListenerInfo>> listeners = CallChecker.varInit(null, "listeners", 287, 9432, 9487);
                if (clazz == (FrameworkListener.class)) {
                    listeners = m_fwkListeners;
                    CallChecker.varAssign(listeners, "listeners", 291, 9570, 9596);
                }else
                    if (clazz == (BundleListener.class)) {
                        if (SynchronousBundleListener.class.isInstance(l)) {
                            listeners = m_syncBndlListeners;
                            CallChecker.varAssign(listeners, "listeners", 297, 9783, 9814);
                        }else {
                            listeners = m_bndlListeners;
                            CallChecker.varAssign(listeners, "listeners", 301, 9893, 9920);
                        }
                    }else
                        if (clazz == (ServiceListener.class)) {
                            listeners = m_svcListeners;
                            CallChecker.varAssign(listeners, "listeners", 306, 10037, 10063);
                        }else {
                            if (CallChecker.beforeDeref(l, EventListener.class, 310, 10184, 10184)) {
                                l = CallChecker.beforeCalled(l, EventListener.class, 310, 10184, 10184);
                                throw new IllegalArgumentException(("Unknown listener: " + (CallChecker.isCalled(l, EventListener.class, 310, 10184, 10184).getClass())));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    
                
                int idx = CallChecker.varInit(((int) (-1)), "idx", 314, 10279, 10291);
                listeners = CallChecker.beforeCalled(listeners, Map.class, 315, 10359, 10367);
                for (Map.Entry<BundleContext, List<ListenerInfo>> entry : CallChecker.isCalled(listeners, Map.class, 315, 10359, 10367).entrySet()) {
                    List<ListenerInfo> infos = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 317, 10438, 10442)) {
                        infos = CallChecker.isCalled(entry, Map.Entry.class, 317, 10438, 10442).getValue();
                        CallChecker.varAssign(infos, "infos", 317, 10438, 10442);
                    }
                    infos = CallChecker.beforeCalled(infos, List.class, 318, 10492, 10496);
                    for (int i = 0; i < (CallChecker.isCalled(infos, List.class, 318, 10492, 10496).size()); i++) {
                        ListenerInfo info = CallChecker.init(ListenerInfo.class);
                        if (CallChecker.beforeDeref(infos, List.class, 320, 10569, 10573)) {
                            infos = CallChecker.beforeCalled(infos, List.class, 320, 10569, 10573);
                            info = CallChecker.isCalled(infos, List.class, 320, 10569, 10573).get(i);
                            CallChecker.varAssign(info, "info", 320, 10569, 10573);
                        }
                        if (CallChecker.beforeDeref(info, ListenerInfo.class, 321, 10607, 10610)) {
                            info = CallChecker.beforeCalled(info, ListenerInfo.class, 321, 10607, 10610);
                            final BundleContext npe_invocation_var440 = CallChecker.isCalled(info, ListenerInfo.class, 321, 10607, 10610).getBundleContext();
                            if (CallChecker.beforeDeref(npe_invocation_var440, BundleContext.class, 321, 10607, 10629)) {
                                if (CallChecker.beforeDeref(info, ListenerInfo.class, 322, 10670, 10673)) {
                                    if (CallChecker.beforeDeref(info, ListenerInfo.class, 323, 10732, 10735)) {
                                        info = CallChecker.beforeCalled(info, ListenerInfo.class, 322, 10670, 10673);
                                        info = CallChecker.beforeCalled(info, ListenerInfo.class, 323, 10732, 10735);
                                        if (((CallChecker.isCalled(npe_invocation_var440, BundleContext.class, 321, 10607, 10629).equals(bc)) && ((CallChecker.isCalled(info, ListenerInfo.class, 322, 10670, 10673).getListenerClass()) == clazz)) && ((CallChecker.isCalled(info, ListenerInfo.class, 323, 10732, 10735).getListener()) == l)) {
                                            if ((ServiceListener.class) == clazz) {
                                                if (CallChecker.beforeDeref(infos, List.class, 329, 11076, 11080)) {
                                                    infos = CallChecker.beforeCalled(infos, List.class, 329, 11076, 11080);
                                                    returnInfo = new ListenerInfo(CallChecker.isCalled(infos, List.class, 329, 11076, 11080).get(i), true);
                                                    CallChecker.varAssign(returnInfo, "returnInfo", 329, 11046, 11095);
                                                }
                                            }
                                            idx = i;
                                            CallChecker.varAssign(idx, "idx", 331, 11147, 11154);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (idx >= 0) {
                    listeners = EventDispatcher.removeListenerInfo(listeners, bc, idx);
                    CallChecker.varAssign(listeners, "listeners", 340, 11354, 11404);
                }
                if (clazz == (FrameworkListener.class)) {
                    m_fwkListeners = listeners;
                    CallChecker.varAssign(this.m_fwkListeners, "this.m_fwkListeners", 345, 11501, 11527);
                }else
                    if (clazz == (BundleListener.class)) {
                        if (SynchronousBundleListener.class.isInstance(l)) {
                            m_syncBndlListeners = listeners;
                            CallChecker.varAssign(this.m_syncBndlListeners, "this.m_syncBndlListeners", 351, 11714, 11745);
                        }else {
                            m_bndlListeners = listeners;
                            CallChecker.varAssign(this.m_bndlListeners, "this.m_bndlListeners", 355, 11824, 11851);
                        }
                    }else
                        if (clazz == (ServiceListener.class)) {
                            m_svcListeners = listeners;
                            CallChecker.varAssign(this.m_svcListeners, "this.m_svcListeners", 360, 11968, 11994);
                        }
                    
                
            }
            return returnInfo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListenerHook.ListenerInfo) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1234.methodEnd();
        }
    }

    public void removeListeners(BundleContext bc) {
        MethodContext _bcornu_methode_context1235 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 369, 12171, 12990);
            CallChecker.varInit(bc, "bc", 369, 12171, 12990);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 369, 12171, 12990);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 369, 12171, 12990);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 369, 12171, 12990);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 369, 12171, 12990);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 369, 12171, 12990);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 369, 12171, 12990);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 369, 12171, 12990);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 369, 12171, 12990);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 369, 12171, 12990);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 369, 12171, 12990);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 369, 12171, 12990);
            CallChecker.varInit(this.m_registry, "m_registry", 369, 12171, 12990);
            CallChecker.varInit(this.m_logger, "m_logger", 369, 12171, 12990);
            if (bc == null) {
                return ;
            }
            synchronized(this) {
                m_fwkListeners = EventDispatcher.removeListenerInfos(m_fwkListeners, bc);
                CallChecker.varAssign(this.m_fwkListeners, "this.m_fwkListeners", 379, 12422, 12478);
                m_bndlListeners = EventDispatcher.removeListenerInfos(m_bndlListeners, bc);
                CallChecker.varAssign(this.m_bndlListeners, "this.m_bndlListeners", 382, 12574, 12632);
                m_syncBndlListeners = EventDispatcher.removeListenerInfos(m_syncBndlListeners, bc);
                CallChecker.varAssign(this.m_syncBndlListeners, "this.m_syncBndlListeners", 386, 12755, 12821);
                m_svcListeners = EventDispatcher.removeListenerInfos(m_svcListeners, bc);
                CallChecker.varAssign(this.m_svcListeners, "this.m_svcListeners", 389, 12918, 12974);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1235.methodEnd();
        }
    }

    public Filter updateListener(BundleContext bc, Class clazz, EventListener l, Filter filter) {
        MethodContext _bcornu_methode_context1236 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 393, 12997, 14824);
            CallChecker.varInit(filter, "filter", 393, 12997, 14824);
            CallChecker.varInit(l, "l", 393, 12997, 14824);
            CallChecker.varInit(clazz, "clazz", 393, 12997, 14824);
            CallChecker.varInit(bc, "bc", 393, 12997, 14824);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 393, 12997, 14824);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 393, 12997, 14824);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 393, 12997, 14824);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 393, 12997, 14824);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 393, 12997, 14824);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 393, 12997, 14824);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 393, 12997, 14824);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 393, 12997, 14824);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 393, 12997, 14824);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 393, 12997, 14824);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 393, 12997, 14824);
            CallChecker.varInit(this.m_registry, "m_registry", 393, 12997, 14824);
            CallChecker.varInit(this.m_logger, "m_logger", 393, 12997, 14824);
            if (clazz == (ServiceListener.class)) {
                synchronized(this) {
                    TryContext _bcornu_try_context_344 = new TryContext(344, EventDispatcher.class, "java.lang.IllegalStateException");
                    try {
                        if (CallChecker.beforeDeref(bc, BundleContext.class, 402, 13319, 13320)) {
                            bc = CallChecker.beforeCalled(bc, BundleContext.class, 402, 13319, 13320);
                            CallChecker.isCalled(bc, BundleContext.class, 402, 13319, 13320).getBundle();
                        }
                    } catch (IllegalStateException ex) {
                        _bcornu_try_context_344.catchStart(344);
                    } finally {
                        _bcornu_try_context_344.finallyStart(344);
                    }
                    List<ListenerInfo> infos = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(m_svcListeners, Map.class, 411, 13688, 13701)) {
                        m_svcListeners = CallChecker.beforeCalled(m_svcListeners, Map.class, 411, 13688, 13701);
                        infos = CallChecker.isCalled(m_svcListeners, Map.class, 411, 13688, 13701).get(bc);
                        CallChecker.varAssign(infos, "infos", 411, 13688, 13701);
                    }
                    infos = CallChecker.beforeCalled(infos, List.class, 412, 13768, 13772);
                    for (int i = 0; (infos != null) && (i < (CallChecker.isCalled(infos, List.class, 412, 13768, 13772).size())); i++) {
                        ListenerInfo info = CallChecker.varInit(infos.get(i), "info", 414, 13826, 13858);
                        if (CallChecker.beforeDeref(info, ListenerInfo.class, 415, 13884, 13887)) {
                            info = CallChecker.beforeCalled(info, ListenerInfo.class, 415, 13884, 13887);
                            final BundleContext npe_invocation_var441 = CallChecker.isCalled(info, ListenerInfo.class, 415, 13884, 13887).getBundleContext();
                            if (CallChecker.beforeDeref(npe_invocation_var441, BundleContext.class, 415, 13884, 13906)) {
                                if (CallChecker.beforeDeref(info, ListenerInfo.class, 416, 13947, 13950)) {
                                    if (CallChecker.beforeDeref(info, ListenerInfo.class, 417, 14009, 14012)) {
                                        info = CallChecker.beforeCalled(info, ListenerInfo.class, 416, 13947, 13950);
                                        info = CallChecker.beforeCalled(info, ListenerInfo.class, 417, 14009, 14012);
                                        if (((CallChecker.isCalled(npe_invocation_var441, BundleContext.class, 415, 13884, 13906).equals(bc)) && ((CallChecker.isCalled(info, ListenerInfo.class, 416, 13947, 13950).getListenerClass()) == clazz)) && ((CallChecker.isCalled(info, ListenerInfo.class, 417, 14009, 14012).getListener()) == l)) {
                                            Filter oldFilter = CallChecker.init(Filter.class);
                                            if (CallChecker.beforeDeref(info, ListenerInfo.class, 420, 14176, 14179)) {
                                                info = CallChecker.beforeCalled(info, ListenerInfo.class, 420, 14176, 14179);
                                                oldFilter = CallChecker.isCalled(info, ListenerInfo.class, 420, 14176, 14179).getParsedFilter();
                                                CallChecker.varAssign(oldFilter, "oldFilter", 420, 14176, 14179);
                                            }
                                            ListenerInfo newInfo = CallChecker.init(ListenerInfo.class);
                                            if (CallChecker.beforeDeref(info, ListenerInfo.class, 422, 14293, 14296)) {
                                                if (CallChecker.beforeDeref(info, ListenerInfo.class, 423, 14339, 14342)) {
                                                    if (CallChecker.beforeDeref(info, ListenerInfo.class, 424, 14392, 14395)) {
                                                        if (CallChecker.beforeDeref(info, ListenerInfo.class, 425, 14445, 14448)) {
                                                            if (CallChecker.beforeDeref(info, ListenerInfo.class, 427, 14529, 14532)) {
                                                                if (CallChecker.beforeDeref(info, ListenerInfo.class, 428, 14584, 14587)) {
                                                                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 422, 14293, 14296);
                                                                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 423, 14339, 14342);
                                                                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 424, 14392, 14395);
                                                                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 425, 14445, 14448);
                                                                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 427, 14529, 14532);
                                                                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 428, 14584, 14587);
                                                                    newInfo = new ListenerInfo(CallChecker.isCalled(info, ListenerInfo.class, 422, 14293, 14296).getBundle(), CallChecker.isCalled(info, ListenerInfo.class, 423, 14339, 14342).getBundleContext(), CallChecker.isCalled(info, ListenerInfo.class, 424, 14392, 14395).getListenerClass(), CallChecker.isCalled(info, ListenerInfo.class, 425, 14445, 14448).getListener(), filter, CallChecker.isCalled(info, ListenerInfo.class, 427, 14529, 14532).getSecurityContext(), CallChecker.isCalled(info, ListenerInfo.class, 428, 14584, 14587).isRemoved());
                                                                    CallChecker.varAssign(newInfo, "newInfo", 422, 14293, 14296);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            m_svcListeners = EventDispatcher.updateListenerInfo(m_svcListeners, i, newInfo);
                                            CallChecker.varAssign(this.m_svcListeners, "this.m_svcListeners", 429, 14627, 14690);
                                            return oldFilter;
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
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1236.methodEnd();
        }
    }

    public Collection<ListenerHook.ListenerInfo> getAllServiceListeners() {
        MethodContext _bcornu_methode_context1237 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 446, 14831, 15644);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 446, 14831, 15644);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 446, 14831, 15644);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 446, 14831, 15644);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 446, 14831, 15644);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 446, 14831, 15644);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 446, 14831, 15644);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 446, 14831, 15644);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 446, 14831, 15644);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 446, 14831, 15644);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 446, 14831, 15644);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 446, 14831, 15644);
            CallChecker.varInit(this.m_registry, "m_registry", 446, 14831, 15644);
            CallChecker.varInit(this.m_logger, "m_logger", 446, 14831, 15644);
            List<ListenerHook.ListenerInfo> listeners = CallChecker.varInit(new ArrayList<ListenerHook.ListenerInfo>(), "listeners", 448, 15305, 15391);
            synchronized(this) {
                m_svcListeners = CallChecker.beforeCalled(m_svcListeners, Map.class, 451, 15497, 15510);
                for (Map.Entry<BundleContext, List<ListenerInfo>> entry : CallChecker.isCalled(m_svcListeners, Map.class, 451, 15497, 15510).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 453, 15571, 15575)) {
                        if (CallChecker.beforeDeref(listeners, List.class, 453, 15554, 15562)) {
                            listeners = CallChecker.beforeCalled(listeners, List.class, 453, 15554, 15562);
                            CallChecker.isCalled(listeners, List.class, 453, 15554, 15562).addAll(CallChecker.isCalled(entry, Map.Entry.class, 453, 15571, 15575).getValue());
                        }
                    }
                }
            }
            return listeners;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<ListenerHook.ListenerInfo>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1237.methodEnd();
        }
    }

    public void fireFrameworkEvent(FrameworkEvent event) {
        MethodContext _bcornu_methode_context1238 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 459, 15651, 16062);
            CallChecker.varInit(event, "event", 459, 15651, 16062);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 459, 15651, 16062);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 459, 15651, 16062);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 459, 15651, 16062);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 459, 15651, 16062);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 459, 15651, 16062);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 459, 15651, 16062);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 459, 15651, 16062);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 459, 15651, 16062);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 459, 15651, 16062);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 459, 15651, 16062);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 459, 15651, 16062);
            CallChecker.varInit(this.m_registry, "m_registry", 459, 15651, 16062);
            CallChecker.varInit(this.m_logger, "m_logger", 459, 15651, 16062);
            Map<BundleContext, List<ListenerInfo>> listeners = CallChecker.varInit(null, "listeners", 462, 15768, 15823);
            synchronized(this) {
                listeners = m_fwkListeners;
                CallChecker.varAssign(listeners, "listeners", 465, 15875, 15901);
            }
            EventDispatcher.fireEventAsynchronously(this, EventDispatcher.Request.FRAMEWORK_EVENT, listeners, event);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1238.methodEnd();
        }
    }

    public void fireBundleEvent(BundleEvent event, Framework felix) {
        MethodContext _bcornu_methode_context1239 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 472, 16069, 18329);
            CallChecker.varInit(felix, "felix", 472, 16069, 18329);
            CallChecker.varInit(event, "event", 472, 16069, 18329);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 472, 16069, 18329);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 472, 16069, 18329);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 472, 16069, 18329);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 472, 16069, 18329);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 472, 16069, 18329);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 472, 16069, 18329);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 472, 16069, 18329);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 472, 16069, 18329);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 472, 16069, 18329);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 472, 16069, 18329);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 472, 16069, 18329);
            CallChecker.varInit(this.m_registry, "m_registry", 472, 16069, 18329);
            CallChecker.varInit(this.m_logger, "m_logger", 472, 16069, 18329);
            Map<BundleContext, List<ListenerInfo>> listeners = CallChecker.varInit(null, "listeners", 475, 16197, 16252);
            Map<BundleContext, List<ListenerInfo>> syncListeners = CallChecker.varInit(null, "syncListeners", 476, 16262, 16321);
            synchronized(this) {
                listeners = m_bndlListeners;
                CallChecker.varAssign(listeners, "listeners", 479, 16373, 16400);
                syncListeners = m_syncBndlListeners;
                CallChecker.varAssign(syncListeners, "syncListeners", 480, 16414, 16449);
            }
            Set<BundleContext> whitelist = CallChecker.varInit(createWhitelistFromHooks(event, felix, listeners, syncListeners, EventHook.class), "whitelist", 485, 16569, 16725);
            if (whitelist != null) {
                Map<BundleContext, List<ListenerInfo>> copy = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(), "copy", 492, 16881, 16991);
                for (BundleContext bc : whitelist) {
                    List<ListenerInfo> infos = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(listeners, Map.class, 496, 17097, 17105)) {
                        listeners = CallChecker.beforeCalled(listeners, Map.class, 496, 17097, 17105);
                        infos = CallChecker.isCalled(listeners, Map.class, 496, 17097, 17105).get(bc);
                        CallChecker.varAssign(infos, "infos", 496, 17097, 17105);
                    }
                    if (infos != null) {
                        if (CallChecker.beforeDeref(copy, Map.class, 499, 17189, 17192)) {
                            copy = CallChecker.beforeCalled(copy, Map.class, 499, 17189, 17192);
                            CallChecker.isCalled(copy, Map.class, 499, 17189, 17192).put(bc, infos);
                        }
                    }
                }
                listeners = copy;
                CallChecker.varAssign(listeners, "listeners", 502, 17254, 17270);
                copy = new HashMap<BundleContext, List<ListenerInfo>>();
                CallChecker.varAssign(copy, "copy", 503, 17284, 17339);
                for (BundleContext bc : whitelist) {
                    List<ListenerInfo> infos = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(syncListeners, Map.class, 506, 17445, 17457)) {
                        syncListeners = CallChecker.beforeCalled(syncListeners, Map.class, 506, 17445, 17457);
                        infos = CallChecker.isCalled(syncListeners, Map.class, 506, 17445, 17457).get(bc);
                        CallChecker.varAssign(infos, "infos", 506, 17445, 17457);
                    }
                    if (infos != null) {
                        if (CallChecker.beforeDeref(copy, Map.class, 509, 17541, 17544)) {
                            copy = CallChecker.beforeCalled(copy, Map.class, 509, 17541, 17544);
                            CallChecker.isCalled(copy, Map.class, 509, 17541, 17544).put(bc, infos);
                        }
                    }
                }
                syncListeners = copy;
                CallChecker.varAssign(syncListeners, "syncListeners", 512, 17606, 17626);
            }
            EventDispatcher.fireEventImmediately(this, EventDispatcher.Request.BUNDLE_EVENT, syncListeners, event, null);
            if (CallChecker.beforeDeref(event, BundleEvent.class, 521, 17970, 17974)) {
                if (CallChecker.beforeDeref(event, BundleEvent.class, 522, 18027, 18031)) {
                    if (CallChecker.beforeDeref(event, BundleEvent.class, 523, 18084, 18088)) {
                        event = CallChecker.beforeCalled(event, BundleEvent.class, 521, 17970, 17974);
                        event = CallChecker.beforeCalled(event, BundleEvent.class, 522, 18027, 18031);
                        event = CallChecker.beforeCalled(event, BundleEvent.class, 523, 18084, 18088);
                        if ((((CallChecker.isCalled(event, BundleEvent.class, 521, 17970, 17974).getType()) != (BundleEvent.STARTING)) && ((CallChecker.isCalled(event, BundleEvent.class, 522, 18027, 18031).getType()) != (BundleEvent.STOPPING))) && ((CallChecker.isCalled(event, BundleEvent.class, 523, 18084, 18088).getType()) != (BundleEvent.LAZY_ACTIVATION))) {
                            EventDispatcher.fireEventAsynchronously(this, EventDispatcher.Request.BUNDLE_EVENT, listeners, event);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1239.methodEnd();
        }
    }

    public void fireServiceEvent(final ServiceEvent event, final Dictionary oldProps, final Framework felix) {
        MethodContext _bcornu_methode_context1240 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 531, 18336, 18973);
            CallChecker.varInit(felix, "felix", 531, 18336, 18973);
            CallChecker.varInit(oldProps, "oldProps", 531, 18336, 18973);
            CallChecker.varInit(event, "event", 531, 18336, 18973);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 531, 18336, 18973);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 531, 18336, 18973);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 531, 18336, 18973);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 531, 18336, 18973);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 531, 18336, 18973);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 531, 18336, 18973);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 531, 18336, 18973);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 531, 18336, 18973);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 531, 18336, 18973);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 531, 18336, 18973);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 531, 18336, 18973);
            CallChecker.varInit(this.m_registry, "m_registry", 531, 18336, 18973);
            CallChecker.varInit(this.m_logger, "m_logger", 531, 18336, 18973);
            Map<BundleContext, List<ListenerInfo>> listeners = CallChecker.varInit(null, "listeners", 535, 18514, 18569);
            synchronized(this) {
                listeners = m_svcListeners;
                CallChecker.varAssign(listeners, "listeners", 538, 18621, 18647);
            }
            listeners = filterListenersUsingHooks(event, felix, listeners);
            CallChecker.varAssign(listeners, "listeners", 542, 18734, 18796);
            EventDispatcher.fireEventImmediately(this, EventDispatcher.Request.SERVICE_EVENT, listeners, event, oldProps);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1240.methodEnd();
        }
    }

    private Map<BundleContext, List<ListenerInfo>> filterListenersUsingHooks(ServiceEvent event, Framework felix, Map<BundleContext, List<ListenerInfo>> listeners) {
        MethodContext _bcornu_methode_context1241 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 550, 18976, 24627);
            CallChecker.varInit(listeners, "listeners", 550, 18976, 24627);
            CallChecker.varInit(felix, "felix", 550, 18976, 24627);
            CallChecker.varInit(event, "event", 550, 18976, 24627);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 550, 18976, 24627);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 550, 18976, 24627);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 550, 18976, 24627);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 550, 18976, 24627);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 550, 18976, 24627);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 550, 18976, 24627);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 550, 18976, 24627);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 550, 18976, 24627);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 550, 18976, 24627);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 550, 18976, 24627);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 550, 18976, 24627);
            CallChecker.varInit(this.m_registry, "m_registry", 550, 18976, 24627);
            CallChecker.varInit(this.m_logger, "m_logger", 550, 18976, 24627);
            Set<ServiceReference<org.osgi.framework.hooks.service.EventHook>> ehs = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 554, 19298, 19307)) {
                final HookRegistry npe_invocation_var442 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 554, 19298, 19307).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var442, HookRegistry.class, 554, 19298, 19325)) {
                    ehs = CallChecker.isCalled(npe_invocation_var442, HookRegistry.class, 554, 19298, 19325).getHooks(org.osgi.framework.hooks.service.EventHook.class);
                    CallChecker.varAssign(ehs, "ehs", 554, 19298, 19307);
                }
            }
            if ((ehs != null) && (!(ehs.isEmpty()))) {
                Set<BundleContext> whitelist = CallChecker.varInit(createWhitelistFromHooks(event, felix, listeners, null, org.osgi.framework.hooks.service.EventHook.class), "whitelist", 559, 19561, 19713);
                if (whitelist != null) {
                    Map<BundleContext, List<ListenerInfo>> copy = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(), "copy", 566, 19889, 20003);
                    for (BundleContext bc : whitelist) {
                        if (CallChecker.beforeDeref(listeners, Map.class, 570, 20107, 20115)) {
                            if (CallChecker.beforeDeref(copy, Map.class, 570, 20094, 20097)) {
                                listeners = CallChecker.beforeCalled(listeners, Map.class, 570, 20107, 20115);
                                copy = CallChecker.beforeCalled(copy, Map.class, 570, 20094, 20097);
                                CallChecker.isCalled(copy, Map.class, 570, 20094, 20097).put(bc, CallChecker.isCalled(listeners, Map.class, 570, 20107, 20115).get(bc));
                            }
                        }
                    }
                    listeners = copy;
                    CallChecker.varAssign(listeners, "listeners", 572, 20161, 20177);
                }
            }
            Set<ServiceReference<EventListenerHook>> elhs = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 577, 20305, 20314)) {
                final HookRegistry npe_invocation_var443 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 577, 20305, 20314).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var443, HookRegistry.class, 577, 20305, 20332)) {
                    elhs = CallChecker.isCalled(npe_invocation_var443, HookRegistry.class, 577, 20305, 20332).getHooks(EventListenerHook.class);
                    CallChecker.varAssign(elhs, "elhs", 577, 20305, 20314);
                }
            }
            if ((elhs != null) && (!(elhs.isEmpty()))) {
                List<ListenerInfo> systemBundleListeners = CallChecker.varInit(null, "systemBundleListeners", 580, 20471, 20518);
                Map<BundleContext, List<ListenerInfo>> mutableMap = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(), "mutableMap", 583, 20632, 20752);
                Map<BundleContext, Collection<ListenerHook.ListenerInfo>> shrinkableMap = CallChecker.varInit(new HashMap<BundleContext, Collection<ListenerHook.ListenerInfo>>(), "shrinkableMap", 586, 20821, 20978);
                listeners = CallChecker.beforeCalled(listeners, Map.class, 588, 21046, 21054);
                for (Map.Entry<BundleContext, List<ListenerInfo>> entry : CallChecker.isCalled(listeners, Map.class, 588, 21046, 21054).entrySet()) {
                    BundleContext bc = CallChecker.init(BundleContext.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 590, 21117, 21121)) {
                        bc = CallChecker.isCalled(entry, Map.Entry.class, 590, 21117, 21121).getKey();
                        CallChecker.varAssign(bc, "bc", 590, 21117, 21121);
                    }
                    ArrayList<ListenerInfo> mutableList = CallChecker.init(ArrayList.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 591, 21215, 21219)) {
                        mutableList = new ArrayList<ListenerInfo>(CallChecker.isCalled(entry, Map.Entry.class, 591, 21215, 21219).getValue());
                        CallChecker.varAssign(mutableList, "mutableList", 591, 21215, 21219);
                    }
                    if (CallChecker.beforeDeref(mutableMap, Map.class, 592, 21250, 21259)) {
                        mutableMap = CallChecker.beforeCalled(mutableMap, Map.class, 592, 21250, 21259);
                        CallChecker.isCalled(mutableMap, Map.class, 592, 21250, 21259).put(bc, mutableList);
                    }
                    ArrayList ml = CallChecker.varInit(mutableList, "ml", 596, 21466, 21492);
                    Collection<ListenerHook.ListenerInfo> shrinkableCollection = CallChecker.varInit(new ShrinkableCollection<ListenerHook.ListenerInfo>(ml), "shrinkableCollection", 598, 21511, 21651);
                    if (CallChecker.beforeDeref(shrinkableMap, Map.class, 600, 21669, 21681)) {
                        shrinkableMap = CallChecker.beforeCalled(shrinkableMap, Map.class, 600, 21669, 21681);
                        CallChecker.isCalled(shrinkableMap, Map.class, 600, 21669, 21681).put(bc, shrinkableCollection);
                    }
                    if (CallChecker.beforeDeref(felix, Framework.class, 604, 21908, 21912)) {
                        felix = CallChecker.beforeCalled(felix, Framework.class, 604, 21908, 21912);
                        if (bc == (CallChecker.isCalled(felix, Framework.class, 604, 21908, 21912).getBundleContext()))
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 605, 22006, 22010)) {
                                systemBundleListeners = new ArrayList<ListenerInfo>(CallChecker.isCalled(entry, Map.Entry.class, 605, 22006, 22010).getValue());
                                CallChecker.varAssign(systemBundleListeners, "systemBundleListeners", 605, 21954, 22023);
                            }
                        
                    }
                }
                shrinkableMap = new ShrinkableMap<BundleContext, Collection<ListenerHook.ListenerInfo>>(shrinkableMap);
                CallChecker.varAssign(shrinkableMap, "shrinkableMap", 607, 22051, 22190);
                for (ServiceReference<EventListenerHook> sr : elhs) {
                    if (felix != null) {
                        EventListenerHook elh = CallChecker.varInit(null, "elh", 615, 22377, 22438);
                        TryContext _bcornu_try_context_345 = new TryContext(345, EventDispatcher.class, "java.lang.Exception");
                        try {
                            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 618, 22516, 22525)) {
                                elh = CallChecker.isCalled(m_registry, ServiceRegistry.class, 618, 22516, 22525).getService(felix, sr, false);
                                CallChecker.varAssign(elh, "elh", 618, 22510, 22555);
                            }
                        } catch (Exception ex) {
                            _bcornu_try_context_345.catchStart(345);
                        } finally {
                            _bcornu_try_context_345.finallyStart(345);
                        }
                        if (elh != null) {
                            TryContext _bcornu_try_context_346 = new TryContext(346, EventDispatcher.class, "java.lang.Throwable");
                            try {
                                if (CallChecker.beforeDeref(EventDispatcher.m_secureAction, SecureAction.class, 628, 22874, 22887)) {
                                    CallChecker.isCalled(EventDispatcher.m_secureAction, SecureAction.class, 628, 22874, 22887).invokeServiceEventListenerHook(elh, event, shrinkableMap);
                                }
                            } catch (Throwable th) {
                                _bcornu_try_context_346.catchStart(346);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 633, 23106, 23113)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 633, 23106, 23113).log(sr, Logger.LOG_WARNING, "Problem invoking event hook", th);
                                }
                            } finally {
                                _bcornu_try_context_346.finallyStart(346);
                                if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 638, 23323, 23332)) {
                                    CallChecker.isCalled(m_registry, ServiceRegistry.class, 638, 23323, 23332).ungetService(felix, sr, null);
                                }
                            }
                        }
                    }
                }
                Map<BundleContext, List<ListenerInfo>> newMap = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(), "newMap", 650, 23842, 23954);
                shrinkableMap = CallChecker.beforeCalled(shrinkableMap, Map.class, 652, 24045, 24057);
                for (Map.Entry<BundleContext, Collection<ListenerHook.ListenerInfo>> entry : CallChecker.isCalled(shrinkableMap, Map.class, 652, 24045, 24057).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 654, 24106, 24110)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 654, 24106, 24110).getValue(), Collection.class, 654, 24106, 24121)) {
                            if (!(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 654, 24106, 24110).getValue(), Collection.class, 654, 24106, 24121).isEmpty())) {
                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 656, 24183, 24187)) {
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 656, 24214, 24218)) {
                                        if (CallChecker.beforeDeref(mutableMap, Map.class, 656, 24199, 24208)) {
                                            if (CallChecker.beforeDeref(newMap, Map.class, 656, 24172, 24177)) {
                                                mutableMap = CallChecker.beforeCalled(mutableMap, Map.class, 656, 24199, 24208);
                                                newMap = CallChecker.beforeCalled(newMap, Map.class, 656, 24172, 24177);
                                                CallChecker.isCalled(newMap, Map.class, 656, 24172, 24177).put(CallChecker.isCalled(entry, Map.Entry.class, 656, 24183, 24187).getKey(), CallChecker.isCalled(mutableMap, Map.class, 656, 24199, 24208).get(CallChecker.isCalled(entry, Map.Entry.class, 656, 24214, 24218).getKey()));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (systemBundleListeners != null)
                    if (CallChecker.beforeDeref(felix, Framework.class, 663, 24503, 24507)) {
                        if (CallChecker.beforeDeref(newMap, Map.class, 663, 24492, 24497)) {
                            felix = CallChecker.beforeCalled(felix, Framework.class, 663, 24503, 24507);
                            newMap = CallChecker.beforeCalled(newMap, Map.class, 663, 24492, 24497);
                            CallChecker.isCalled(newMap, Map.class, 663, 24492, 24497).put(CallChecker.isCalled(felix, Framework.class, 663, 24503, 24507).getBundleContext(), systemBundleListeners);
                        }
                    }
                
                listeners = newMap;
                CallChecker.varAssign(listeners, "listeners", 665, 24566, 24584);
            }
            return listeners;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<BundleContext, List<ListenerInfo>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1241.methodEnd();
        }
    }

    private <T> Set<BundleContext> createWhitelistFromHooks(EventObject event, Framework felix, Map<BundleContext, List<ListenerInfo>> listeners1, Map<BundleContext, List<ListenerInfo>> listeners2, Class<T> hookClass) {
        MethodContext _bcornu_methode_context1242 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 671, 24634, 28696);
            CallChecker.varInit(hookClass, "hookClass", 671, 24634, 28696);
            CallChecker.varInit(listeners2, "listeners2", 671, 24634, 28696);
            CallChecker.varInit(listeners1, "listeners1", 671, 24634, 28696);
            CallChecker.varInit(felix, "felix", 671, 24634, 28696);
            CallChecker.varInit(event, "event", 671, 24634, 28696);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 671, 24634, 28696);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 671, 24634, 28696);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 671, 24634, 28696);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 671, 24634, 28696);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 671, 24634, 28696);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 671, 24634, 28696);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 671, 24634, 28696);
            CallChecker.varInit(this.m_svcListeners, "m_svcListeners", 671, 24634, 28696);
            CallChecker.varInit(this.m_syncBndlListeners, "m_syncBndlListeners", 671, 24634, 28696);
            CallChecker.varInit(this.m_bndlListeners, "m_bndlListeners", 671, 24634, 28696);
            CallChecker.varInit(this.m_fwkListeners, "m_fwkListeners", 671, 24634, 28696);
            CallChecker.varInit(this.m_registry, "m_registry", 671, 24634, 28696);
            CallChecker.varInit(this.m_logger, "m_logger", 671, 24634, 28696);
            Set<BundleContext> whitelist = CallChecker.varInit(null, "whitelist", 678, 24962, 24997);
            Set<ServiceReference<T>> hooks = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 679, 25040, 25049)) {
                final HookRegistry npe_invocation_var444 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 679, 25040, 25049).getHookRegistry();
                if (CallChecker.beforeDeref(npe_invocation_var444, HookRegistry.class, 679, 25040, 25067)) {
                    hooks = CallChecker.isCalled(npe_invocation_var444, HookRegistry.class, 679, 25040, 25067).getHooks(hookClass);
                    CallChecker.varAssign(hooks, "hooks", 679, 25040, 25049);
                }
            }
            if ((hooks != null) && (!(hooks.isEmpty()))) {
                boolean systemBundleListener = CallChecker.varInit(((boolean) (false)), "systemBundleListener", 682, 25161, 25197);
                BundleContext systemBundleContext = CallChecker.init(BundleContext.class);
                if (CallChecker.beforeDeref(felix, Framework.class, 683, 25247, 25251)) {
                    felix = CallChecker.beforeCalled(felix, Framework.class, 683, 25247, 25251);
                    systemBundleContext = CallChecker.isCalled(felix, Framework.class, 683, 25247, 25251).getBundleContext();
                    CallChecker.varAssign(systemBundleContext, "systemBundleContext", 683, 25247, 25251);
                }
                whitelist = new HashSet<BundleContext>();
                CallChecker.varAssign(whitelist, "whitelist", 685, 25286, 25326);
                listeners1 = CallChecker.beforeCalled(listeners1, Map.class, 686, 25394, 25403);
                for (Map.Entry<BundleContext, List<ListenerInfo>> entry : CallChecker.isCalled(listeners1, Map.class, 686, 25394, 25403).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 688, 25461, 25465)) {
                        if (CallChecker.beforeDeref(whitelist, Set.class, 688, 25447, 25455)) {
                            whitelist = CallChecker.beforeCalled(whitelist, Set.class, 688, 25447, 25455);
                            CallChecker.isCalled(whitelist, Set.class, 688, 25447, 25455).add(CallChecker.isCalled(entry, Map.Entry.class, 688, 25461, 25465).getKey());
                        }
                    }
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 689, 25498, 25502)) {
                        if ((CallChecker.isCalled(entry, Map.Entry.class, 689, 25498, 25502).getKey()) == systemBundleContext) {
                            systemBundleListener = true;
                            CallChecker.varAssign(systemBundleListener, "systemBundleListener", 690, 25557, 25584);
                        }
                    }
                }
                if (listeners2 != null) {
                    for (Map.Entry<BundleContext, List<ListenerInfo>> entry : listeners2.entrySet()) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 696, 25795, 25799)) {
                            if (CallChecker.beforeDeref(whitelist, Set.class, 696, 25781, 25789)) {
                                whitelist = CallChecker.beforeCalled(whitelist, Set.class, 696, 25781, 25789);
                                CallChecker.isCalled(whitelist, Set.class, 696, 25781, 25789).add(CallChecker.isCalled(entry, Map.Entry.class, 696, 25795, 25799).getKey());
                            }
                        }
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 697, 25836, 25840)) {
                            if ((CallChecker.isCalled(entry, Map.Entry.class, 697, 25836, 25840).getKey()) == systemBundleContext) {
                                systemBundleListener = true;
                                CallChecker.varAssign(systemBundleListener, "systemBundleListener", 698, 25899, 25926);
                            }
                        }
                    }
                }
                int originalSize = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(whitelist, Set.class, 702, 25992, 26000)) {
                    whitelist = CallChecker.beforeCalled(whitelist, Set.class, 702, 25992, 26000);
                    originalSize = CallChecker.isCalled(whitelist, Set.class, 702, 25992, 26000).size();
                    CallChecker.varAssign(originalSize, "originalSize", 702, 25992, 26000);
                }
                ShrinkableCollection<BundleContext> shrinkable = CallChecker.varInit(new ShrinkableCollection<BundleContext>(whitelist), "shrinkable", 703, 26022, 26137);
                for (ServiceReference<T> sr : hooks) {
                    if (felix != null) {
                        T eh = CallChecker.varInit(null, "eh", 709, 26275, 26286);
                        TryContext _bcornu_try_context_347 = new TryContext(347, EventDispatcher.class, "java.lang.Exception");
                        try {
                            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 712, 26363, 26372)) {
                                eh = m_registry.getService(felix, sr, false);
                                CallChecker.varAssign(eh, "eh", 712, 26358, 26402);
                            }
                        } catch (Exception ex) {
                            _bcornu_try_context_347.catchStart(347);
                        } finally {
                            _bcornu_try_context_347.finallyStart(347);
                        }
                        if (eh != null) {
                            TryContext _bcornu_try_context_348 = new TryContext(348, EventDispatcher.class, "java.lang.Throwable");
                            try {
                                if (eh instanceof org.osgi.framework.hooks.service.EventHook) {
                                    if (CallChecker.beforeDeref(EventDispatcher.m_secureAction, SecureAction.class, 724, 26844, 26857)) {
                                        CallChecker.isCalled(EventDispatcher.m_secureAction, SecureAction.class, 724, 26844, 26857).invokeServiceEventHook(((org.osgi.framework.hooks.service.EventHook) (eh)), ((ServiceEvent) (event)), shrinkable);
                                    }
                                }else
                                    if (eh instanceof EventHook) {
                                        if (CallChecker.beforeDeref(EventDispatcher.m_secureAction, SecureAction.class, 730, 27225, 27238)) {
                                            CallChecker.isCalled(EventDispatcher.m_secureAction, SecureAction.class, 730, 27225, 27238).invokeBundleEventHook(((EventHook) (eh)), ((BundleEvent) (event)), shrinkable);
                                        }
                                    }
                                
                            } catch (Throwable th) {
                                _bcornu_try_context_348.catchStart(348);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 737, 27572, 27579)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 737, 27572, 27579).log(sr, Logger.LOG_WARNING, "Problem invoking event hook", th);
                                }
                            } finally {
                                _bcornu_try_context_348.finallyStart(348);
                                if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 742, 27789, 27798)) {
                                    CallChecker.isCalled(m_registry, ServiceRegistry.class, 742, 27789, 27798).ungetService(felix, sr, null);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(whitelist, Set.class, 748, 27953, 27961)) {
                    whitelist = CallChecker.beforeCalled(whitelist, Set.class, 748, 27953, 27961);
                    if (systemBundleListener && (!(CallChecker.isCalled(whitelist, Set.class, 748, 27953, 27961).contains(systemBundleContext)))) {
                        if (CallChecker.beforeDeref(whitelist, Set.class, 754, 28354, 28362)) {
                            whitelist = CallChecker.beforeCalled(whitelist, Set.class, 754, 28354, 28362);
                            CallChecker.isCalled(whitelist, Set.class, 754, 28354, 28362).add(systemBundleContext);
                        }
                    }
                }
                if (CallChecker.beforeDeref(whitelist, Set.class, 759, 28576, 28584)) {
                    whitelist = CallChecker.beforeCalled(whitelist, Set.class, 759, 28576, 28584);
                    if (originalSize == (CallChecker.isCalled(whitelist, Set.class, 759, 28576, 28584).size())) {
                        whitelist = null;
                        CallChecker.varAssign(whitelist, "whitelist", 761, 28624, 28640);
                    }
                }
            }
            return whitelist;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<BundleContext>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1242.methodEnd();
        }
    }

    private static void fireEventAsynchronously(EventDispatcher dispatcher, int type, Map<BundleContext, List<ListenerInfo>> listeners, EventObject event) {
        MethodContext _bcornu_methode_context1243 = new MethodContext(void.class);
        try {
            CallChecker.varInit(event, "event", 767, 28703, 29945);
            CallChecker.varInit(listeners, "listeners", 767, 28703, 29945);
            CallChecker.varInit(type, "type", 767, 28703, 29945);
            CallChecker.varInit(dispatcher, "dispatcher", 767, 28703, 29945);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 767, 28703, 29945);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 767, 28703, 29945);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 767, 28703, 29945);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 767, 28703, 29945);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 767, 28703, 29945);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 767, 28703, 29945);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 767, 28703, 29945);
            if ((EventDispatcher.m_stopping) || ((EventDispatcher.m_thread) == null)) {
                return ;
            }
            EventDispatcher.Request req = CallChecker.varInit(null, "req", 780, 29216, 29234);
            synchronized(EventDispatcher.m_requestPool) {
                if (CallChecker.beforeDeref(EventDispatcher.m_requestPool, List.class, 783, 29299, 29311)) {
                    if ((CallChecker.isCalled(EventDispatcher.m_requestPool, List.class, 783, 29299, 29311).size()) > 0) {
                        if (CallChecker.beforeDeref(EventDispatcher.m_requestPool, List.class, 785, 29361, 29373)) {
                            req = CallChecker.isCalled(EventDispatcher.m_requestPool, List.class, 785, 29361, 29373).remove(0);
                            CallChecker.varAssign(req, "req", 785, 29355, 29384);
                        }
                    }else {
                        req = new EventDispatcher.Request();
                        CallChecker.varAssign(req, "req", 789, 29447, 29466);
                    }
                }
            }
            if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 794, 29541, 29543)) {
                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 794, 29541, 29543);
                CallChecker.isCalled(req, EventDispatcher.Request.class, 794, 29541, 29543).m_dispatcher = dispatcher;
                CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 794, 29541, 29543).m_dispatcher, "CallChecker.isCalled(req, EventDispatcher.Request.class, 794, 29541, 29543).m_dispatcher", 794, 29541, 29570);
            }
            if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 795, 29580, 29582)) {
                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 795, 29580, 29582);
                CallChecker.isCalled(req, EventDispatcher.Request.class, 795, 29580, 29582).m_type = type;
                CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 795, 29580, 29582).m_type, "CallChecker.isCalled(req, EventDispatcher.Request.class, 795, 29580, 29582).m_type", 795, 29580, 29597);
            }
            if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 796, 29607, 29609)) {
                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 796, 29607, 29609);
                CallChecker.isCalled(req, EventDispatcher.Request.class, 796, 29607, 29609).m_listeners = listeners;
                CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 796, 29607, 29609).m_listeners, "CallChecker.isCalled(req, EventDispatcher.Request.class, 796, 29607, 29609).m_listeners", 796, 29607, 29634);
            }
            if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 797, 29644, 29646)) {
                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 797, 29644, 29646);
                CallChecker.isCalled(req, EventDispatcher.Request.class, 797, 29644, 29646).m_event = event;
                CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 797, 29644, 29646).m_event, "CallChecker.isCalled(req, EventDispatcher.Request.class, 797, 29644, 29646).m_event", 797, 29644, 29663);
            }
            synchronized(EventDispatcher.m_requestList) {
                if (CallChecker.beforeDeref(EventDispatcher.m_requestList, List.class, 803, 29803, 29815)) {
                    CallChecker.isCalled(EventDispatcher.m_requestList, List.class, 803, 29803, 29815).add(req);
                }
                if (CallChecker.beforeDeref(EventDispatcher.m_requestList, List.class, 805, 29907, 29919)) {
                    CallChecker.isCalled(EventDispatcher.m_requestList, List.class, 805, 29907, 29919).notify();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1243.methodEnd();
        }
    }

    private static void fireEventImmediately(EventDispatcher dispatcher, int type, Map<BundleContext, List<ListenerInfo>> listeners, EventObject event, Dictionary oldProps) {
        MethodContext _bcornu_methode_context1244 = new MethodContext(void.class);
        try {
            CallChecker.varInit(oldProps, "oldProps", 809, 29952, 32027);
            CallChecker.varInit(event, "event", 809, 29952, 32027);
            CallChecker.varInit(listeners, "listeners", 809, 29952, 32027);
            CallChecker.varInit(type, "type", 809, 29952, 32027);
            CallChecker.varInit(dispatcher, "dispatcher", 809, 29952, 32027);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 809, 29952, 32027);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 809, 29952, 32027);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 809, 29952, 32027);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 809, 29952, 32027);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 809, 29952, 32027);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 809, 29952, 32027);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 809, 29952, 32027);
            if (CallChecker.beforeDeref(listeners, Map.class, 814, 30165, 30173)) {
                listeners = CallChecker.beforeCalled(listeners, Map.class, 814, 30165, 30173);
                if (!(CallChecker.isCalled(listeners, Map.class, 814, 30165, 30173).isEmpty())) {
                    listeners = CallChecker.beforeCalled(listeners, Map.class, 817, 30307, 30315);
                    for (Map.Entry<BundleContext, List<ListenerInfo>> entry : CallChecker.isCalled(listeners, Map.class, 817, 30307, 30315).entrySet()) {
                        for (ListenerInfo info : CallChecker.isCalled(entry, Map.Entry.class, 819, 30384, 30388).getValue()) {
                            Bundle bundle = CallChecker.init(Bundle.class);
                            if (CallChecker.beforeDeref(info, ListenerInfo.class, 821, 30456, 30459)) {
                                bundle = CallChecker.isCalled(info, ListenerInfo.class, 821, 30456, 30459).getBundle();
                                CallChecker.varAssign(bundle, "bundle", 821, 30456, 30459);
                            }
                            EventListener l = CallChecker.init(EventListener.class);
                            if (CallChecker.beforeDeref(info, ListenerInfo.class, 822, 30512, 30515)) {
                                l = CallChecker.isCalled(info, ListenerInfo.class, 822, 30512, 30515).getListener();
                                CallChecker.varAssign(l, "l", 822, 30512, 30515);
                            }
                            Filter filter = CallChecker.init(Filter.class);
                            if (CallChecker.beforeDeref(info, ListenerInfo.class, 823, 30568, 30571)) {
                                filter = CallChecker.isCalled(info, ListenerInfo.class, 823, 30568, 30571).getParsedFilter();
                                CallChecker.varAssign(filter, "filter", 823, 30568, 30571);
                            }
                            Object acc = CallChecker.init(Object.class);
                            if (CallChecker.beforeDeref(info, ListenerInfo.class, 824, 30625, 30628)) {
                                acc = CallChecker.isCalled(info, ListenerInfo.class, 824, 30625, 30628).getSecurityContext();
                                CallChecker.varAssign(acc, "acc", 824, 30625, 30628);
                            }
                            TryContext _bcornu_try_context_349 = new TryContext(349, EventDispatcher.class, "java.lang.Throwable");
                            try {
                                if (type == (EventDispatcher.Request.FRAMEWORK_EVENT)) {
                                    EventDispatcher.invokeFrameworkListenerCallback(bundle, l, event);
                                }else
                                    if (type == (EventDispatcher.Request.BUNDLE_EVENT)) {
                                        EventDispatcher.invokeBundleListenerCallback(bundle, l, event);
                                    }else
                                        if (type == (EventDispatcher.Request.SERVICE_EVENT)) {
                                            EventDispatcher.invokeServiceListenerCallback(bundle, l, filter, acc, event, oldProps);
                                        }
                                    
                                
                            } catch (Throwable th) {
                                _bcornu_try_context_349.catchStart(349);
                                if (CallChecker.beforeDeref(event, EventObject.class, 845, 31528, 31532)) {
                                    event = CallChecker.beforeCalled(event, FrameworkEvent.class, 845, 31528, 31532);
                                    if ((type != (EventDispatcher.Request.FRAMEWORK_EVENT)) || ((CallChecker.isCalled(((FrameworkEvent) (event)), FrameworkEvent.class, 845, 31528, 31532).getType()) != (FrameworkEvent.ERROR))) {
                                        if (CallChecker.beforeDeref(dispatcher, EventDispatcher.class, 847, 31625, 31634)) {
                                            dispatcher = CallChecker.beforeCalled(dispatcher, EventDispatcher.class, 847, 31625, 31634);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(dispatcher, EventDispatcher.class, 847, 31625, 31634).m_logger, Logger.class, 847, 31625, 31643)) {
                                                dispatcher = CallChecker.beforeCalled(dispatcher, EventDispatcher.class, 847, 31625, 31634);
                                                CallChecker.isCalled(CallChecker.isCalled(dispatcher, EventDispatcher.class, 847, 31625, 31634).m_logger, Logger.class, 847, 31625, 31643).log(bundle, Logger.LOG_ERROR, "EventDispatcher: Error during dispatch.", th);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(dispatcher, EventDispatcher.class, 850, 31815, 31824)) {
                                            dispatcher = CallChecker.beforeCalled(dispatcher, EventDispatcher.class, 850, 31815, 31824);
                                            CallChecker.isCalled(dispatcher, EventDispatcher.class, 850, 31815, 31824).fireFrameworkEvent(new FrameworkEvent(FrameworkEvent.ERROR, bundle, th));
                                        }
                                    }
                                }
                            } finally {
                                _bcornu_try_context_349.finallyStart(349);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1244.methodEnd();
        }
    }

    private static void invokeFrameworkListenerCallback(Bundle bundle, final EventListener l, final EventObject event) {
        MethodContext _bcornu_methode_context1246 = new MethodContext(void.class);
        try {
            CallChecker.varInit(event, "event", 859, 32034, 32981);
            CallChecker.varInit(l, "l", 859, 32034, 32981);
            CallChecker.varInit(bundle, "bundle", 859, 32034, 32981);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 859, 32034, 32981);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 859, 32034, 32981);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 859, 32034, 32981);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 859, 32034, 32981);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 859, 32034, 32981);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 859, 32034, 32981);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 859, 32034, 32981);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 865, 32360, 32365)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 866, 32414, 32419)) {
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 865, 32360, 32365);
                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 866, 32414, 32419);
                    if (((CallChecker.isCalled(bundle, Bundle.class, 865, 32360, 32365).getState()) == (Bundle.STARTING)) || ((CallChecker.isCalled(bundle, Bundle.class, 866, 32414, 32419).getState()) == (Bundle.ACTIVE))) {
                        if ((System.getSecurityManager()) != null) {
                            AccessController.doPrivileged(new PrivilegedAction() {
                                public Object run() {
                                    MethodContext _bcornu_methode_context1245 = new MethodContext(Object.class);
                                    try {
                                        CallChecker.varInit(this, "this", 871, 32619, 32806);
                                        if (CallChecker.beforeDeref(l, EventListener.class, 873, 32706, 32706)) {
                                            CallChecker.isCalled(((FrameworkListener) (l)), FrameworkListener.class, 873, 32706, 32706).frameworkEvent(((FrameworkEvent) (event)));
                                        }
                                        return null;
                                    } catch (ForceReturn _bcornu_return_t) {
                                        return ((Object) (_bcornu_return_t.getDecision().getValue()));
                                    } finally {
                                        _bcornu_methode_context1245.methodEnd();
                                    }
                                }
                            });
                        }else {
                            if (CallChecker.beforeDeref(l, EventListener.class, 880, 32910, 32910)) {
                                CallChecker.isCalled(((FrameworkListener) (l)), FrameworkListener.class, 880, 32910, 32910).frameworkEvent(((FrameworkEvent) (event)));
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1246.methodEnd();
        }
    }

    private static void invokeBundleListenerCallback(Bundle bundle, final EventListener l, final EventObject event) {
        MethodContext _bcornu_methode_context1248 = new MethodContext(void.class);
        try {
            CallChecker.varInit(event, "event", 885, 32988, 34326);
            CallChecker.varInit(l, "l", 885, 32988, 34326);
            CallChecker.varInit(bundle, "bundle", 885, 32988, 34326);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 885, 32988, 34326);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 885, 32988, 34326);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 885, 32988, 34326);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 885, 32988, 34326);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 885, 32988, 34326);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 885, 32988, 34326);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 885, 32988, 34326);
            if (CallChecker.beforeDeref(l, EventListener.class, 893, 33511, 33511)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 894, 33543, 33548)) {
                    if (CallChecker.beforeDeref(bundle, Bundle.class, 895, 33597, 33602)) {
                        if (CallChecker.beforeDeref(bundle, Bundle.class, 896, 33651, 33656)) {
                            if (CallChecker.beforeDeref(bundle, Bundle.class, 898, 33718, 33723)) {
                                if (CallChecker.beforeDeref(bundle, Bundle.class, 899, 33772, 33777)) {
                                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 894, 33543, 33548);
                                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 895, 33597, 33602);
                                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 896, 33651, 33656);
                                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 898, 33718, 33723);
                                    bundle = CallChecker.beforeCalled(bundle, Bundle.class, 899, 33772, 33777);
                                    if (((SynchronousBundleListener.class.isAssignableFrom(CallChecker.isCalled(l, EventListener.class, 893, 33511, 33511).getClass())) && ((((CallChecker.isCalled(bundle, Bundle.class, 894, 33543, 33548).getState()) == (Bundle.STARTING)) || ((CallChecker.isCalled(bundle, Bundle.class, 895, 33597, 33602).getState()) == (Bundle.STOPPING))) || ((CallChecker.isCalled(bundle, Bundle.class, 896, 33651, 33656).getState()) == (Bundle.ACTIVE)))) || (((CallChecker.isCalled(bundle, Bundle.class, 898, 33718, 33723).getState()) == (Bundle.STARTING)) || ((CallChecker.isCalled(bundle, Bundle.class, 899, 33772, 33777).getState()) == (Bundle.ACTIVE)))) {
                                        if ((System.getSecurityManager()) != null) {
                                            AccessController.doPrivileged(new PrivilegedAction() {
                                                public Object run() {
                                                    MethodContext _bcornu_methode_context1247 = new MethodContext(Object.class);
                                                    try {
                                                        CallChecker.varInit(this, "this", 904, 33978, 34158);
                                                        if (CallChecker.beforeDeref(l, EventListener.class, 906, 34062, 34062)) {
                                                            CallChecker.isCalled(((BundleListener) (l)), BundleListener.class, 906, 34062, 34062).bundleChanged(((BundleEvent) (event)));
                                                        }
                                                        return null;
                                                    } catch (ForceReturn _bcornu_return_t) {
                                                        return ((Object) (_bcornu_return_t.getDecision().getValue()));
                                                    } finally {
                                                        _bcornu_methode_context1247.methodEnd();
                                                    }
                                                }
                                            });
                                        }else {
                                            if (CallChecker.beforeDeref(l, EventListener.class, 913, 34259, 34259)) {
                                                CallChecker.isCalled(((BundleListener) (l)), BundleListener.class, 913, 34259, 34259).bundleChanged(((BundleEvent) (event)));
                                            }
                                        }
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
            _bcornu_methode_context1248.methodEnd();
        }
    }

    private static void invokeServiceListenerCallback(Bundle bundle, final EventListener l, Filter filter, Object acc, final EventObject event, final Dictionary oldProps) {
        MethodContext _bcornu_methode_context1251 = new MethodContext(void.class);
        try {
            CallChecker.varInit(oldProps, "oldProps", 918, 34333, 38142);
            CallChecker.varInit(event, "event", 918, 34333, 38142);
            CallChecker.varInit(acc, "acc", 918, 34333, 38142);
            CallChecker.varInit(filter, "filter", 918, 34333, 38142);
            CallChecker.varInit(l, "l", 918, 34333, 38142);
            CallChecker.varInit(bundle, "bundle", 918, 34333, 38142);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 918, 34333, 38142);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 918, 34333, 38142);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 918, 34333, 38142);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 918, 34333, 38142);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 918, 34333, 38142);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 918, 34333, 38142);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 918, 34333, 38142);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 924, 34636, 34641)) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 925, 34690, 34695)) {
                    if (CallChecker.beforeDeref(bundle, Bundle.class, 926, 34744, 34749)) {
                        bundle = CallChecker.beforeCalled(bundle, Bundle.class, 924, 34636, 34641);
                        bundle = CallChecker.beforeCalled(bundle, Bundle.class, 925, 34690, 34695);
                        bundle = CallChecker.beforeCalled(bundle, Bundle.class, 926, 34744, 34749);
                        if ((((CallChecker.isCalled(bundle, Bundle.class, 924, 34636, 34641).getState()) != (Bundle.STARTING)) && ((CallChecker.isCalled(bundle, Bundle.class, 925, 34690, 34695).getState()) != (Bundle.STOPPING))) && ((CallChecker.isCalled(bundle, Bundle.class, 926, 34744, 34749).getState()) != (Bundle.ACTIVE))) {
                            return ;
                        }
                    }
                }
            }
            ServiceReference ref = CallChecker.init(ServiceReference.class);
            if (CallChecker.beforeDeref(event, EventObject.class, 934, 35057, 35061)) {
                ref = CallChecker.isCalled(((ServiceEvent) (event)), ServiceEvent.class, 934, 35057, 35061).getServiceReference();
                CallChecker.varAssign(ref, "ref", 934, 35057, 35061);
            }
            boolean hasPermission = CallChecker.varInit(((boolean) (true)), "hasPermission", 936, 35096, 35124);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 937, 35134, 35173);
            if ((acc != null) && (sm != null)) {
                TryContext _bcornu_try_context_350 = new TryContext(350, EventDispatcher.class, "java.lang.Exception");
                try {
                    ServicePermission perm = CallChecker.varInit(new ServicePermission(ref, ServicePermission.GET), "perm", 942, 35274, 35393);
                    ((SecurityManager) (sm)).checkPermission(perm, acc);
                } catch (Exception ex) {
                    _bcornu_try_context_350.catchStart(350);
                    hasPermission = false;
                    CallChecker.varAssign(hasPermission, "hasPermission", 949, 35539, 35560);
                } finally {
                    _bcornu_try_context_350.finallyStart(350);
                }
            }
            if (hasPermission) {
                boolean matched = CallChecker.init(boolean.class);
                if (l instanceof UnfilteredServiceListener) {
                    matched = true;
                    CallChecker.varAssign(matched, "matched", 961, 35958, 35972);
                }else {
                    if (CallChecker.beforeDeref(event, EventObject.class, 966, 36118, 36122)) {
                        if (CallChecker.beforeDeref(filter, Filter.class, 966, 36089, 36094)) {
                            filter = CallChecker.beforeCalled(filter, Filter.class, 966, 36089, 36094);
                            matched = (filter == null) || (CallChecker.isCalled(filter, Filter.class, 966, 36089, 36094).match(CallChecker.isCalled(((ServiceEvent) (event)), ServiceEvent.class, 966, 36118, 36122).getServiceReference()));
                            CallChecker.varAssign(matched, "matched", 965, 36035, 36147);
                        }
                    }
                }
                if (matched) {
                    if (CallChecker.beforeDeref(event, EventObject.class, 972, 36329, 36333)) {
                        if ((l instanceof AllServiceListener) || (Util.isServiceAssignable(bundle, CallChecker.isCalled(((ServiceEvent) (event)), ServiceEvent.class, 972, 36329, 36333).getServiceReference()))) {
                            if ((System.getSecurityManager()) != null) {
                                AccessController.doPrivileged(new PrivilegedAction() {
                                    public Object run() {
                                        MethodContext _bcornu_methode_context1249 = new MethodContext(Object.class);
                                        try {
                                            CallChecker.varInit(this, "this", 978, 36592, 36807);
                                            if (CallChecker.beforeDeref(l, EventListener.class, 980, 36693, 36693)) {
                                                CallChecker.isCalled(((ServiceListener) (l)), ServiceListener.class, 980, 36693, 36693).serviceChanged(((ServiceEvent) (event)));
                                            }
                                            return null;
                                        } catch (ForceReturn _bcornu_return_t) {
                                            return ((Object) (_bcornu_return_t.getDecision().getValue()));
                                        } finally {
                                            _bcornu_methode_context1249.methodEnd();
                                        }
                                    }
                                });
                            }else {
                                if (CallChecker.beforeDeref(l, EventListener.class, 987, 36949, 36949)) {
                                    CallChecker.isCalled(((ServiceListener) (l)), ServiceListener.class, 987, 36949, 36949).serviceChanged(((ServiceEvent) (event)));
                                }
                            }
                        }
                    }
                }else
                    if (CallChecker.beforeDeref(event, EventObject.class, 993, 37190, 37194)) {
                        if ((CallChecker.isCalled(((ServiceEvent) (event)), ServiceEvent.class, 993, 37190, 37194).getType()) == (ServiceEvent.MODIFIED)) {
                            if (CallChecker.beforeDeref(filter, Filter.class, 995, 37267, 37272)) {
                                filter = CallChecker.beforeCalled(filter, Filter.class, 995, 37267, 37272);
                                if (CallChecker.isCalled(filter, Filter.class, 995, 37267, 37272).match(oldProps)) {
                                    final ServiceEvent se = CallChecker.varInit(new ServiceEvent(ServiceEvent.MODIFIED_ENDMATCH, CallChecker.isCalled(((ServiceEvent) (event)), ServiceEvent.class, 999, 37467, 37471).getServiceReference()), "se", 997, 37329, 37496);
                                    if ((System.getSecurityManager()) != null) {
                                        AccessController.doPrivileged(new PrivilegedAction() {
                                            public Object run() {
                                                MethodContext _bcornu_methode_context1250 = new MethodContext(Object.class);
                                                try {
                                                    CallChecker.varInit(this, "this", 1004, 37712, 37909);
                                                    if (CallChecker.beforeDeref(l, EventListener.class, 1006, 37813, 37813)) {
                                                        CallChecker.isCalled(((ServiceListener) (l)), ServiceListener.class, 1006, 37813, 37813).serviceChanged(se);
                                                    }
                                                    return null;
                                                } catch (ForceReturn _bcornu_return_t) {
                                                    return ((Object) (_bcornu_return_t.getDecision().getValue()));
                                                } finally {
                                                    _bcornu_methode_context1250.methodEnd();
                                                }
                                            }
                                        });
                                    }else {
                                        if (CallChecker.beforeDeref(l, EventListener.class, 1013, 38051, 38051)) {
                                            CallChecker.isCalled(((ServiceListener) (l)), ServiceListener.class, 1013, 38051, 38051).serviceChanged(se);
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
            _bcornu_methode_context1251.methodEnd();
        }
    }

    private static Map<BundleContext, List<ListenerInfo>> addListenerInfo(Map<BundleContext, List<ListenerInfo>> listeners, ListenerInfo info) {
        MethodContext _bcornu_methode_context1252 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(info, "info", 1020, 38149, 39039);
            CallChecker.varInit(listeners, "listeners", 1020, 38149, 39039);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 1020, 38149, 39039);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 1020, 38149, 39039);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 1020, 38149, 39039);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 1020, 38149, 39039);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 1020, 38149, 39039);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 1020, 38149, 39039);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 1020, 38149, 39039);
            Map<BundleContext, List<ListenerInfo>> copy = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(listeners), "copy", 1024, 38376, 38491);
            List<ListenerInfo> infos = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(info, ListenerInfo.class, 1027, 38614, 38617)) {
                if (CallChecker.beforeDeref(copy, Map.class, 1027, 38602, 38605)) {
                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 1027, 38614, 38617);
                    copy = CallChecker.beforeCalled(copy, Map.class, 1027, 38602, 38605);
                    infos = CallChecker.isCalled(copy, Map.class, 1027, 38602, 38605).remove(CallChecker.isCalled(info, ListenerInfo.class, 1027, 38614, 38617).getBundleContext());
                    CallChecker.varAssign(infos, "infos", 1027, 38614, 38617);
                }
            }
            if (infos == null) {
                infos = new ArrayList<ListenerInfo>();
                CallChecker.varAssign(infos, "infos", 1030, 38689, 38726);
            }else {
                infos = new ArrayList<ListenerInfo>(infos);
                CallChecker.varAssign(infos, "infos", 1034, 38773, 38815);
            }
            if (CallChecker.beforeDeref(infos, List.class, 1037, 38873, 38877)) {
                infos = CallChecker.beforeCalled(infos, List.class, 1037, 38873, 38877);
                CallChecker.isCalled(infos, List.class, 1037, 38873, 38877).add(info);
            }
            if (CallChecker.beforeDeref(info, ListenerInfo.class, 1039, 38981, 38984)) {
                if (CallChecker.beforeDeref(copy, Map.class, 1039, 38972, 38975)) {
                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 1039, 38981, 38984);
                    copy = CallChecker.beforeCalled(copy, Map.class, 1039, 38972, 38975);
                    CallChecker.isCalled(copy, Map.class, 1039, 38972, 38975).put(CallChecker.isCalled(info, ListenerInfo.class, 1039, 38981, 38984).getBundleContext(), infos);
                }
            }
            return copy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<BundleContext, List<ListenerInfo>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1252.methodEnd();
        }
    }

    private static Map<BundleContext, List<ListenerInfo>> updateListenerInfo(Map<BundleContext, List<ListenerInfo>> listeners, int idx, ListenerInfo info) {
        MethodContext _bcornu_methode_context1253 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(info, "info", 1043, 39046, 39926);
            CallChecker.varInit(idx, "idx", 1043, 39046, 39926);
            CallChecker.varInit(listeners, "listeners", 1043, 39046, 39926);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 1043, 39046, 39926);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 1043, 39046, 39926);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 1043, 39046, 39926);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 1043, 39046, 39926);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 1043, 39046, 39926);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 1043, 39046, 39926);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 1043, 39046, 39926);
            Map<BundleContext, List<ListenerInfo>> copy = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(listeners), "copy", 1048, 39293, 39408);
            List<ListenerInfo> infos = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(info, ListenerInfo.class, 1051, 39531, 39534)) {
                if (CallChecker.beforeDeref(copy, Map.class, 1051, 39519, 39522)) {
                    info = CallChecker.beforeCalled(info, ListenerInfo.class, 1051, 39531, 39534);
                    copy = CallChecker.beforeCalled(copy, Map.class, 1051, 39519, 39522);
                    infos = CallChecker.isCalled(copy, Map.class, 1051, 39519, 39522).remove(CallChecker.isCalled(info, ListenerInfo.class, 1051, 39531, 39534).getBundleContext());
                    CallChecker.varAssign(infos, "infos", 1051, 39531, 39534);
                }
            }
            if (infos != null) {
                infos = new ArrayList<ListenerInfo>(infos);
                CallChecker.varAssign(infos, "infos", 1054, 39606, 39648);
                infos.set(idx, info);
                if (CallChecker.beforeDeref(info, ListenerInfo.class, 1058, 39828, 39831)) {
                    if (CallChecker.beforeDeref(copy, Map.class, 1058, 39819, 39822)) {
                        info = CallChecker.beforeCalled(info, ListenerInfo.class, 1058, 39828, 39831);
                        copy = CallChecker.beforeCalled(copy, Map.class, 1058, 39819, 39822);
                        CallChecker.isCalled(copy, Map.class, 1058, 39819, 39822).put(CallChecker.isCalled(info, ListenerInfo.class, 1058, 39828, 39831).getBundleContext(), infos);
                    }
                }
                return copy;
            }
            return listeners;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<BundleContext, List<ListenerInfo>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1253.methodEnd();
        }
    }

    private static Map<BundleContext, List<ListenerInfo>> removeListenerInfo(Map<BundleContext, List<ListenerInfo>> listeners, BundleContext bc, int idx) {
        MethodContext _bcornu_methode_context1254 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(idx, "idx", 1064, 39933, 40825);
            CallChecker.varInit(bc, "bc", 1064, 39933, 40825);
            CallChecker.varInit(listeners, "listeners", 1064, 39933, 40825);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 1064, 39933, 40825);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 1064, 39933, 40825);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 1064, 39933, 40825);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 1064, 39933, 40825);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 1064, 39933, 40825);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 1064, 39933, 40825);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 1064, 39933, 40825);
            Map<BundleContext, List<ListenerInfo>> copy = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(listeners), "copy", 1068, 40171, 40286);
            List<ListenerInfo> infos = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(copy, Map.class, 1071, 40397, 40400)) {
                copy = CallChecker.beforeCalled(copy, Map.class, 1071, 40397, 40400);
                infos = CallChecker.isCalled(copy, Map.class, 1071, 40397, 40400).remove(bc);
                CallChecker.varAssign(infos, "infos", 1071, 40397, 40400);
            }
            if (infos != null) {
                infos = new ArrayList<ListenerInfo>(infos);
                CallChecker.varAssign(infos, "infos", 1074, 40463, 40505);
                infos.remove(idx);
                if (!(infos.isEmpty())) {
                    if (CallChecker.beforeDeref(copy, Map.class, 1080, 40725, 40728)) {
                        copy = CallChecker.beforeCalled(copy, Map.class, 1080, 40725, 40728);
                        CallChecker.isCalled(copy, Map.class, 1080, 40725, 40728).put(bc, infos);
                    }
                }
                return copy;
            }
            return listeners;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<BundleContext, List<ListenerInfo>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1254.methodEnd();
        }
    }

    private static Map<BundleContext, List<ListenerInfo>> removeListenerInfos(Map<BundleContext, List<ListenerInfo>> listeners, BundleContext bc) {
        MethodContext _bcornu_methode_context1255 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(bc, "bc", 1087, 40832, 41287);
            CallChecker.varInit(listeners, "listeners", 1087, 40832, 41287);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 1087, 40832, 41287);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 1087, 40832, 41287);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 1087, 40832, 41287);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 1087, 40832, 41287);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 1087, 40832, 41287);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 1087, 40832, 41287);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 1087, 40832, 41287);
            Map<BundleContext, List<ListenerInfo>> copy = CallChecker.varInit(new HashMap<BundleContext, List<ListenerInfo>>(listeners), "copy", 1091, 41062, 41177);
            if (CallChecker.beforeDeref(copy, Map.class, 1094, 41245, 41248)) {
                copy = CallChecker.beforeCalled(copy, Map.class, 1094, 41245, 41248);
                CallChecker.isCalled(copy, Map.class, 1094, 41245, 41248).remove(bc);
            }
            return copy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<BundleContext, List<ListenerInfo>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1255.methodEnd();
        }
    }

    private static void run() {
        MethodContext _bcornu_methode_context1256 = new MethodContext(void.class);
        try {
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.EventDispatcher.m_secureAction", 1101, 41294, 43442);
            CallChecker.varInit(m_requestPool, "org.apache.felix.framework.util.EventDispatcher.m_requestPool", 1101, 41294, 43442);
            CallChecker.varInit(m_requestList, "org.apache.felix.framework.util.EventDispatcher.m_requestList", 1101, 41294, 43442);
            CallChecker.varInit(EventDispatcher.m_stopping, "org.apache.felix.framework.util.EventDispatcher.m_stopping", 1101, 41294, 43442);
            CallChecker.varInit(EventDispatcher.m_references, "org.apache.felix.framework.util.EventDispatcher.m_references", 1101, 41294, 43442);
            CallChecker.varInit(m_threadLock, "org.apache.felix.framework.util.EventDispatcher.m_threadLock", 1101, 41294, 43442);
            CallChecker.varInit(EventDispatcher.m_thread, "org.apache.felix.framework.util.EventDispatcher.m_thread", 1101, 41294, 43442);
            EventDispatcher.Request req = CallChecker.varInit(null, "req", 1103, 41401, 41419);
            while (true) {
                synchronized(EventDispatcher.m_requestList) {
                    while ((CallChecker.isCalled(EventDispatcher.m_requestList, List.class, 1113, 41835, 41847).isEmpty()) && (!(EventDispatcher.m_stopping))) {
                        TryContext _bcornu_try_context_351 = new TryContext(351, EventDispatcher.class, "java.lang.InterruptedException");
                        try {
                            if (CallChecker.beforeDeref(EventDispatcher.m_requestList, List.class, 1118, 42023, 42035)) {
                                CallChecker.isCalled(EventDispatcher.m_requestList, List.class, 1118, 42023, 42035).wait();
                            }
                        } catch (InterruptedException ex) {
                            _bcornu_try_context_351.catchStart(351);
                        } finally {
                            _bcornu_try_context_351.finallyStart(351);
                        }
                    } 
                    if (CallChecker.beforeDeref(EventDispatcher.m_requestList, List.class, 1128, 42417, 42429)) {
                        if ((CallChecker.isCalled(EventDispatcher.m_requestList, List.class, 1128, 42417, 42429).isEmpty()) && (EventDispatcher.m_stopping)) {
                            return ;
                        }
                    }
                    if (CallChecker.beforeDeref(EventDispatcher.m_requestList, List.class, 1134, 42588, 42600)) {
                        req = CallChecker.isCalled(EventDispatcher.m_requestList, List.class, 1134, 42588, 42600).remove(0);
                        CallChecker.varAssign(req, "req", 1134, 42582, 42611);
                    }
                }
                if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1144, 43039, 43041)) {
                    if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1144, 43057, 43059)) {
                        if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1144, 43069, 43071)) {
                            if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1145, 43102, 43104)) {
                                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1144, 43039, 43041);
                                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1144, 43057, 43059);
                                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1144, 43069, 43071);
                                req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1145, 43102, 43104);
                                EventDispatcher.fireEventImmediately(CallChecker.isCalled(req, EventDispatcher.Request.class, 1144, 43039, 43041).m_dispatcher, CallChecker.isCalled(req, EventDispatcher.Request.class, 1144, 43057, 43059).m_type, CallChecker.isCalled(req, EventDispatcher.Request.class, 1144, 43069, 43071).m_listeners, CallChecker.isCalled(req, EventDispatcher.Request.class, 1145, 43102, 43104).m_event, null);
                            }
                        }
                    }
                }
                synchronized(EventDispatcher.m_requestPool) {
                    if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1150, 43240, 43242)) {
                        req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1150, 43240, 43242);
                        CallChecker.isCalled(req, EventDispatcher.Request.class, 1150, 43240, 43242).m_dispatcher = null;
                        CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 1150, 43240, 43242).m_dispatcher, "CallChecker.isCalled(req, EventDispatcher.Request.class, 1150, 43240, 43242).m_dispatcher", 1150, 43240, 43263);
                    }
                    if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1151, 43281, 43283)) {
                        req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1151, 43281, 43283);
                        CallChecker.isCalled(req, EventDispatcher.Request.class, 1151, 43281, 43283).m_type = -1;
                        CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 1151, 43281, 43283).m_type, "CallChecker.isCalled(req, EventDispatcher.Request.class, 1151, 43281, 43283).m_type", 1151, 43281, 43296);
                    }
                    if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1152, 43314, 43316)) {
                        req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1152, 43314, 43316);
                        CallChecker.isCalled(req, EventDispatcher.Request.class, 1152, 43314, 43316).m_listeners = null;
                        CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 1152, 43314, 43316).m_listeners, "CallChecker.isCalled(req, EventDispatcher.Request.class, 1152, 43314, 43316).m_listeners", 1152, 43314, 43336);
                    }
                    if (CallChecker.beforeDeref(req, EventDispatcher.Request.class, 1153, 43354, 43356)) {
                        req = CallChecker.beforeCalled(req, EventDispatcher.Request.class, 1153, 43354, 43356);
                        CallChecker.isCalled(req, EventDispatcher.Request.class, 1153, 43354, 43356).m_event = null;
                        CallChecker.varAssign(CallChecker.isCalled(req, EventDispatcher.Request.class, 1153, 43354, 43356).m_event, "CallChecker.isCalled(req, EventDispatcher.Request.class, 1153, 43354, 43356).m_event", 1153, 43354, 43372);
                    }
                    if (CallChecker.beforeDeref(EventDispatcher.m_requestPool, List.class, 1154, 43390, 43402)) {
                        CallChecker.isCalled(EventDispatcher.m_requestPool, List.class, 1154, 43390, 43402).add(req);
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1256.methodEnd();
        }
    }

    private static class Request {
        public static final int FRAMEWORK_EVENT = 0;

        public static final int BUNDLE_EVENT = 1;

        public static final int SERVICE_EVENT = 2;

        public EventDispatcher m_dispatcher = null;

        public int m_type = -1;

        public Map<BundleContext, List<ListenerInfo>> m_listeners = null;

        public EventObject m_event = null;
    }
}

