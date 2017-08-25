package org.apache.felix.framework;

import org.osgi.service.url.URLStreamHandlerService;
import java.util.Set;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.net.ContentHandler;
import org.apache.felix.framework.util.FelixConstants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.ServiceReference;

class URLHandlersActivator implements BundleActivator {
    private final Map m_configMap;

    private final Felix m_framework;

    public URLHandlersActivator(Map configMap, Felix framework) {
        MethodContext _bcornu_methode_context143 = new MethodContext(null);
        try {
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 47, 1677, 1700);
            m_framework = framework;
            CallChecker.varAssign(this.m_framework, "this.m_framework", 48, 1710, 1733);
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }

    public void start(BundleContext context) {
        MethodContext _bcornu_methode_context1440 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 55, 1746, 2341);
            CallChecker.varInit(context, "context", 55, 1746, 2341);
            CallChecker.varInit(this.m_framework, "m_framework", 55, 1746, 2341);
            CallChecker.varInit(this.m_configMap, "m_configMap", 55, 1746, 2341);
            boolean enable = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 59, 1974, 1984)) {
                if ((CallChecker.isCalled(m_configMap, Map.class, 59, 1974, 1984).get(FelixConstants.SERVICE_URLHANDLERS_PROP)) == null) {
                    enable = true;
                    CallChecker.varAssign(enable, "enable", 59, 1973, 2170);
                }else {
                    if (CallChecker.beforeDeref(m_configMap, Map.class, 62, 2099, 2109)) {
                        enable = !(CallChecker.isCalled(m_configMap, Map.class, 62, 2099, 2109).get(FelixConstants.SERVICE_URLHANDLERS_PROP).equals("false"));
                        CallChecker.varAssign(enable, "enable", 59, 1973, 2170);
                    }
                }
            }
            if (enable) {
                if (CallChecker.beforeDeref(m_framework, Felix.class, 66, 2216, 2226)) {
                    CallChecker.isCalled(m_framework, Felix.class, 66, 2216, 2226).setURLHandlersActivator(this);
                }
            }
            URLHandlers.registerFrameworkInstance(m_framework, enable);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1440.methodEnd();
        }
    }

    public void stop(BundleContext context) {
        MethodContext _bcornu_methode_context1441 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 71, 2348, 2511);
            CallChecker.varInit(context, "context", 71, 2348, 2511);
            CallChecker.varInit(this.m_framework, "m_framework", 71, 2348, 2511);
            CallChecker.varInit(this.m_configMap, "m_configMap", 71, 2348, 2511);
            URLHandlers.unregisterFrameworkInstance(m_framework);
            if (CallChecker.beforeDeref(m_framework, Felix.class, 74, 2464, 2474)) {
                CallChecker.isCalled(m_framework, Felix.class, 74, 2464, 2474).setURLHandlersActivator(null);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1441.methodEnd();
        }
    }

    protected Object getStreamHandlerService(String protocol) {
        MethodContext _bcornu_methode_context1442 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 77, 2518, 2718);
            CallChecker.varInit(protocol, "protocol", 77, 2518, 2718);
            CallChecker.varInit(this.m_framework, "m_framework", 77, 2518, 2718);
            CallChecker.varInit(this.m_configMap, "m_configMap", 77, 2518, 2718);
            if (CallChecker.beforeDeref(m_framework, Felix.class, 80, 2614, 2624)) {
                return get(CallChecker.isCalled(m_framework, Felix.class, 80, 2614, 2624).getHooks(URLStreamHandlerService.class), "url.handler.protocol", protocol);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1442.methodEnd();
        }
    }

    protected Object getContentHandlerService(String mimeType) {
        MethodContext _bcornu_methode_context1443 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 84, 2725, 2917);
            CallChecker.varInit(mimeType, "mimeType", 84, 2725, 2917);
            CallChecker.varInit(this.m_framework, "m_framework", 84, 2725, 2917);
            CallChecker.varInit(this.m_configMap, "m_configMap", 84, 2725, 2917);
            if (CallChecker.beforeDeref(m_framework, Felix.class, 87, 2822, 2832)) {
                return get(CallChecker.isCalled(m_framework, Felix.class, 87, 2822, 2832).getHooks(ContentHandler.class), "url.content.mimetype", mimeType);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1443.methodEnd();
        }
    }

    private <S> S get(Set<ServiceReference<S>> hooks, String key, String value) {
        Object service = CallChecker.varInit(null, "service", 93, 3011, 3032);
        if (CallChecker.beforeDeref(hooks, Set.class, 94, 3047, 3051)) {
            hooks = CallChecker.beforeCalled(hooks, Set.class, 94, 3047, 3051);
            if (!(CallChecker.isCalled(hooks, Set.class, 94, 3047, 3051).isEmpty())) {
                if (CallChecker.beforeDeref(hooks, null, 96, 3117, 3121)) {
                    for (ServiceReference<S> ref : hooks) {
                        Object values = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(ref, ServiceReference.class, 98, 3170, 3172)) {
                            values = CallChecker.isCalled(ref, ServiceReference.class, 98, 3170, 3172).getProperty(key);
                            CallChecker.varAssign(values, "values", 98, 3170, 3172);
                        }
                        if (values instanceof String[]) {
                            values = CallChecker.beforeCalled(values, String[].class, 102, 3349, 3354);
                            for (int valueIdx = 0; (valueIdx < (CallChecker.isCalled(((String[]) (values)), String[].class, 102, 3349, 3354).length)) && (service == null); valueIdx++) {
                                if (CallChecker.beforeDeref(values, Object.class, 105, 3498, 3503)) {
                                    if (CallChecker.beforeDeref(value, String.class, 105, 3473, 3477)) {
                                        values = CallChecker.beforeCalled(values, String[].class, 105, 3498, 3503);
                                        value = CallChecker.beforeCalled(value, String.class, 105, 3473, 3477);
                                        if (CallChecker.isCalled(value, String.class, 105, 3473, 3477).equals(CallChecker.isCalled(((String[]) (values)), String[].class, 105, 3498, 3503)[valueIdx])) {
                                            if (CallChecker.beforeDeref(m_framework, Felix.class, 107, 3579, 3589)) {
                                                return m_framework.getService(m_framework, ref, false);
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            if (CallChecker.beforeDeref(value, String.class, 111, 3719, 3723)) {
                                value = CallChecker.beforeCalled(value, String.class, 111, 3719, 3723);
                                if (CallChecker.isCalled(value, String.class, 111, 3719, 3723).equals(values)) {
                                    if (CallChecker.beforeDeref(m_framework, Felix.class, 113, 3786, 3796)) {
                                        return m_framework.getService(m_framework, ref, false);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }
                }
            }
        }else
            throw new AbnormalExecutionError();
        
        return null;
    }
}

