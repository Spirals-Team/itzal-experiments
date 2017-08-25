package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.EventListener;
import org.osgi.framework.Filter;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.hooks.service.ListenerHook;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class ListenerInfo implements ListenerHook.ListenerInfo {
    private final Bundle m_bundle;

    private final BundleContext m_context;

    private final Class m_listenerClass;

    private final EventListener m_listener;

    private final Filter m_filter;

    private final Object m_acc;

    private final boolean m_removed;

    public ListenerInfo(Bundle bundle, BundleContext context, Class listenerClass, EventListener listener, Filter filter, Object acc, boolean removed) {
        MethodContext _bcornu_methode_context96 = new MethodContext(null);
        try {
            m_bundle = bundle;
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 45, 1765, 1782);
            m_context = context;
            CallChecker.varAssign(this.m_context, "this.m_context", 46, 1792, 1811);
            m_listenerClass = listenerClass;
            CallChecker.varAssign(this.m_listenerClass, "this.m_listenerClass", 47, 1821, 1852);
            m_listener = listener;
            CallChecker.varAssign(this.m_listener, "this.m_listener", 48, 1862, 1883);
            m_filter = filter;
            CallChecker.varAssign(this.m_filter, "this.m_filter", 49, 1893, 1910);
            m_acc = acc;
            CallChecker.varAssign(this.m_acc, "this.m_acc", 50, 1920, 1931);
            m_removed = removed;
            CallChecker.varAssign(this.m_removed, "this.m_removed", 51, 1941, 1960);
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    public ListenerInfo(ListenerInfo info, boolean removed) {
        MethodContext _bcornu_methode_context97 = new MethodContext(null);
        try {
            info = CallChecker.beforeCalled(info, ListenerInfo.class, 56, 2054, 2057);
            m_bundle = CallChecker.isCalled(info, ListenerInfo.class, 56, 2054, 2057).m_bundle;
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 56, 2043, 2067);
            info = CallChecker.beforeCalled(info, ListenerInfo.class, 57, 2089, 2092);
            m_context = CallChecker.isCalled(info, ListenerInfo.class, 57, 2089, 2092).m_context;
            CallChecker.varAssign(this.m_context, "this.m_context", 57, 2077, 2103);
            info = CallChecker.beforeCalled(info, ListenerInfo.class, 58, 2131, 2134);
            m_listenerClass = CallChecker.isCalled(info, ListenerInfo.class, 58, 2131, 2134).m_listenerClass;
            CallChecker.varAssign(this.m_listenerClass, "this.m_listenerClass", 58, 2113, 2151);
            info = CallChecker.beforeCalled(info, ListenerInfo.class, 59, 2174, 2177);
            m_listener = CallChecker.isCalled(info, ListenerInfo.class, 59, 2174, 2177).m_listener;
            CallChecker.varAssign(this.m_listener, "this.m_listener", 59, 2161, 2189);
            info = CallChecker.beforeCalled(info, ListenerInfo.class, 60, 2210, 2213);
            m_filter = CallChecker.isCalled(info, ListenerInfo.class, 60, 2210, 2213).m_filter;
            CallChecker.varAssign(this.m_filter, "this.m_filter", 60, 2199, 2223);
            info = CallChecker.beforeCalled(info, ListenerInfo.class, 61, 2241, 2244);
            m_acc = CallChecker.isCalled(info, ListenerInfo.class, 61, 2241, 2244).m_acc;
            CallChecker.varAssign(this.m_acc, "this.m_acc", 61, 2233, 2251);
            m_removed = removed;
            CallChecker.varAssign(this.m_removed, "this.m_removed", 62, 2261, 2280);
        } finally {
            _bcornu_methode_context97.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context1002 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 65, 2293, 2354);
            CallChecker.varInit(this.m_removed, "m_removed", 65, 2293, 2354);
            CallChecker.varInit(this.m_acc, "m_acc", 65, 2293, 2354);
            CallChecker.varInit(this.m_filter, "m_filter", 65, 2293, 2354);
            CallChecker.varInit(this.m_listener, "m_listener", 65, 2293, 2354);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 65, 2293, 2354);
            CallChecker.varInit(this.m_context, "m_context", 65, 2293, 2354);
            CallChecker.varInit(this.m_bundle, "m_bundle", 65, 2293, 2354);
            return m_bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1002.methodEnd();
        }
    }

    public BundleContext getBundleContext() {
        MethodContext _bcornu_methode_context1003 = new MethodContext(BundleContext.class);
        try {
            CallChecker.varInit(this, "this", 70, 2361, 2437);
            CallChecker.varInit(this.m_removed, "m_removed", 70, 2361, 2437);
            CallChecker.varInit(this.m_acc, "m_acc", 70, 2361, 2437);
            CallChecker.varInit(this.m_filter, "m_filter", 70, 2361, 2437);
            CallChecker.varInit(this.m_listener, "m_listener", 70, 2361, 2437);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 70, 2361, 2437);
            CallChecker.varInit(this.m_context, "m_context", 70, 2361, 2437);
            CallChecker.varInit(this.m_bundle, "m_bundle", 70, 2361, 2437);
            return m_context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1003.methodEnd();
        }
    }

    public Class getListenerClass() {
        MethodContext _bcornu_methode_context1004 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(this, "this", 75, 2444, 2518);
            CallChecker.varInit(this.m_removed, "m_removed", 75, 2444, 2518);
            CallChecker.varInit(this.m_acc, "m_acc", 75, 2444, 2518);
            CallChecker.varInit(this.m_filter, "m_filter", 75, 2444, 2518);
            CallChecker.varInit(this.m_listener, "m_listener", 75, 2444, 2518);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 75, 2444, 2518);
            CallChecker.varInit(this.m_context, "m_context", 75, 2444, 2518);
            CallChecker.varInit(this.m_bundle, "m_bundle", 75, 2444, 2518);
            return m_listenerClass;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1004.methodEnd();
        }
    }

    public EventListener getListener() {
        MethodContext _bcornu_methode_context1005 = new MethodContext(EventListener.class);
        try {
            CallChecker.varInit(this, "this", 80, 2525, 2597);
            CallChecker.varInit(this.m_removed, "m_removed", 80, 2525, 2597);
            CallChecker.varInit(this.m_acc, "m_acc", 80, 2525, 2597);
            CallChecker.varInit(this.m_filter, "m_filter", 80, 2525, 2597);
            CallChecker.varInit(this.m_listener, "m_listener", 80, 2525, 2597);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 80, 2525, 2597);
            CallChecker.varInit(this.m_context, "m_context", 80, 2525, 2597);
            CallChecker.varInit(this.m_bundle, "m_bundle", 80, 2525, 2597);
            return m_listener;
        } catch (ForceReturn _bcornu_return_t) {
            return ((EventListener) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1005.methodEnd();
        }
    }

    public Filter getParsedFilter() {
        MethodContext _bcornu_methode_context1006 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 85, 2604, 2671);
            CallChecker.varInit(this.m_removed, "m_removed", 85, 2604, 2671);
            CallChecker.varInit(this.m_acc, "m_acc", 85, 2604, 2671);
            CallChecker.varInit(this.m_filter, "m_filter", 85, 2604, 2671);
            CallChecker.varInit(this.m_listener, "m_listener", 85, 2604, 2671);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 85, 2604, 2671);
            CallChecker.varInit(this.m_context, "m_context", 85, 2604, 2671);
            CallChecker.varInit(this.m_bundle, "m_bundle", 85, 2604, 2671);
            return m_filter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1006.methodEnd();
        }
    }

    public String getFilter() {
        MethodContext _bcornu_methode_context1007 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 90, 2678, 2825);
            CallChecker.varInit(this.m_removed, "m_removed", 90, 2678, 2825);
            CallChecker.varInit(this.m_acc, "m_acc", 90, 2678, 2825);
            CallChecker.varInit(this.m_filter, "m_filter", 90, 2678, 2825);
            CallChecker.varInit(this.m_listener, "m_listener", 90, 2678, 2825);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 90, 2678, 2825);
            CallChecker.varInit(this.m_context, "m_context", 90, 2678, 2825);
            CallChecker.varInit(this.m_bundle, "m_bundle", 90, 2678, 2825);
            if ((m_filter) != null) {
                return m_filter.toString();
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1007.methodEnd();
        }
    }

    public Object getSecurityContext() {
        MethodContext _bcornu_methode_context1008 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 99, 2832, 2899);
            CallChecker.varInit(this.m_removed, "m_removed", 99, 2832, 2899);
            CallChecker.varInit(this.m_acc, "m_acc", 99, 2832, 2899);
            CallChecker.varInit(this.m_filter, "m_filter", 99, 2832, 2899);
            CallChecker.varInit(this.m_listener, "m_listener", 99, 2832, 2899);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 99, 2832, 2899);
            CallChecker.varInit(this.m_context, "m_context", 99, 2832, 2899);
            CallChecker.varInit(this.m_bundle, "m_bundle", 99, 2832, 2899);
            return m_acc;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1008.methodEnd();
        }
    }

    public boolean isRemoved() {
        MethodContext _bcornu_methode_context1009 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 104, 2906, 2969);
            CallChecker.varInit(this.m_removed, "m_removed", 104, 2906, 2969);
            CallChecker.varInit(this.m_acc, "m_acc", 104, 2906, 2969);
            CallChecker.varInit(this.m_filter, "m_filter", 104, 2906, 2969);
            CallChecker.varInit(this.m_listener, "m_listener", 104, 2906, 2969);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 104, 2906, 2969);
            CallChecker.varInit(this.m_context, "m_context", 104, 2906, 2969);
            CallChecker.varInit(this.m_bundle, "m_bundle", 104, 2906, 2969);
            return m_removed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1009.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1010 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 110, 2976, 3535);
            CallChecker.varInit(obj, "obj", 110, 2976, 3535);
            CallChecker.varInit(this.m_removed, "m_removed", 110, 2976, 3535);
            CallChecker.varInit(this.m_acc, "m_acc", 110, 2976, 3535);
            CallChecker.varInit(this.m_filter, "m_filter", 110, 2976, 3535);
            CallChecker.varInit(this.m_listener, "m_listener", 110, 2976, 3535);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 110, 2976, 3535);
            CallChecker.varInit(this.m_context, "m_context", 110, 2976, 3535);
            CallChecker.varInit(this.m_bundle, "m_bundle", 110, 2976, 3535);
            if (obj == (this)) {
                return true;
            }
            if (!(obj instanceof ListenerInfo)) {
                return false;
            }
            ListenerInfo other = CallChecker.varInit(((ListenerInfo) (obj)), "other", 122, 3200, 3239);
            if (CallChecker.beforeDeref(other, ListenerInfo.class, 127, 3513, 3517)) {
                if (((m_filter) == null) || (CallChecker.beforeDeref(m_filter, Filter.class, 127, 3497, 3504))) {
                    other = CallChecker.beforeCalled(other, ListenerInfo.class, 123, 3257, 3261);
                    other = CallChecker.beforeCalled(other, ListenerInfo.class, 124, 3301, 3305);
                    other = CallChecker.beforeCalled(other, ListenerInfo.class, 125, 3347, 3351);
                    other = CallChecker.beforeCalled(other, ListenerInfo.class, 126, 3405, 3409);
                    other = CallChecker.beforeCalled(other, ListenerInfo.class, 127, 3472, 3476);
                    other = CallChecker.beforeCalled(other, ListenerInfo.class, 127, 3513, 3517);
                    return (((((CallChecker.isCalled(other, ListenerInfo.class, 123, 3257, 3261).m_bundle) == (m_bundle)) && ((CallChecker.isCalled(other, ListenerInfo.class, 124, 3301, 3305).m_context) == (m_context))) && ((CallChecker.isCalled(other, ListenerInfo.class, 125, 3347, 3351).m_listenerClass) == (m_listenerClass))) && ((CallChecker.isCalled(other, ListenerInfo.class, 126, 3405, 3409).m_listener) == (m_listener))) && (((m_filter) == null) ? (CallChecker.isCalled(other, ListenerInfo.class, 127, 3472, 3476).m_filter) == null : CallChecker.isCalled(m_filter, Filter.class, 127, 3497, 3504).equals(CallChecker.isCalled(other, ListenerInfo.class, 127, 3513, 3517).m_filter));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1010.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1011 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 131, 3542, 4066);
            CallChecker.varInit(this.m_removed, "m_removed", 131, 3542, 4066);
            CallChecker.varInit(this.m_acc, "m_acc", 131, 3542, 4066);
            CallChecker.varInit(this.m_filter, "m_filter", 131, 3542, 4066);
            CallChecker.varInit(this.m_listener, "m_listener", 131, 3542, 4066);
            CallChecker.varInit(this.m_listenerClass, "m_listenerClass", 131, 3542, 4066);
            CallChecker.varInit(this.m_context, "m_context", 131, 3542, 4066);
            CallChecker.varInit(this.m_bundle, "m_bundle", 131, 3542, 4066);
            int hash = CallChecker.varInit(((int) (7)), "hash", 133, 3592, 3604);
            if ((this.m_bundle) != null) {
                hash = (59 * hash) + (this.m_bundle.hashCode());
                CallChecker.varAssign(hash, "hash", 134, 3614, 3687);
            }else {
                hash = (59 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 134, 3614, 3687);
            }
            if ((this.m_context) != null) {
                hash = (59 * hash) + (this.m_context.hashCode());
                CallChecker.varAssign(hash, "hash", 135, 3697, 3772);
            }else {
                hash = (59 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 135, 3697, 3772);
            }
            if ((this.m_listenerClass) != null) {
                hash = (59 * hash) + (this.m_listenerClass.hashCode());
                CallChecker.varAssign(hash, "hash", 136, 3782, 3869);
            }else {
                hash = (59 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 136, 3782, 3869);
            }
            if ((this.m_listener) != null) {
                hash = (59 * hash) + (this.m_listener.hashCode());
                CallChecker.varAssign(hash, "hash", 137, 3879, 3956);
            }else {
                hash = (59 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 137, 3879, 3956);
            }
            if ((this.m_filter) != null) {
                hash = (59 * hash) + (this.m_filter.hashCode());
                CallChecker.varAssign(hash, "hash", 138, 3966, 4039);
            }else {
                hash = (59 * hash) + 0;
                CallChecker.varAssign(hash, "hash", 138, 3966, 4039);
            }
            return hash;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1011.methodEnd();
        }
    }
}

