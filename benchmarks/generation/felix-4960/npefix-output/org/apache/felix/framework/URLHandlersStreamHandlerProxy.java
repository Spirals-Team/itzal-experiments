package org.apache.felix.framework;

import static java.lang.reflect.Proxy.newProxyInstance;
import org.osgi.service.url.URLStreamHandlerSetter;
import org.osgi.service.url.URLStreamHandlerService;
import java.net.URLStreamHandler;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.lang.reflect.InvocationHandler;
import java.net.InetAddress;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.lang.reflect.Method;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.net.Proxy;
import org.apache.felix.framework.util.SecureAction;

public class URLHandlersStreamHandlerProxy extends URLStreamHandler implements InvocationHandler , URLStreamHandlerSetter {
    private static final Class[] URL_PROXY_CLASS;

    private static final Class[] STRING_TYPES = new Class[]{ String.class };

    private static final Method EQUALS;

    private static final Method GET_DEFAULT_PORT;

    private static final Method GET_HOST_ADDRESS;

    private static final Method HASH_CODE;

    private static final Method HOSTS_EQUAL;

    private static final Method OPEN_CONNECTION;

    private static final Method OPEN_CONNECTION_PROXY;

    private static final Method SAME_FILE;

    private static final Method TO_EXTERNAL_FORM;

    static {
        SecureAction action = CallChecker.varInit(new SecureAction(), "action", 74, 3059, 3099);
        TryContext _bcornu_try_context_455 = new TryContext(455, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
        try {
            EQUALS = URLStreamHandler.class.getDeclaredMethod("equals", new Class[]{ URL.class , URL.class });
            CallChecker.varAssign(EQUALS, "URLHandlersStreamHandlerProxy.EQUALS", 77, 3135, 3245);
            if (CallChecker.beforeDeref(action, SecureAction.class, 79, 3259, 3264)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 79, 3259, 3264);
                CallChecker.isCalled(action, SecureAction.class, 79, 3259, 3264).setAccesssible(URLHandlersStreamHandlerProxy.EQUALS);
            }
            GET_DEFAULT_PORT = URLStreamHandler.class.getDeclaredMethod("getDefaultPort", ((Class[]) (null)));
            CallChecker.varAssign(GET_DEFAULT_PORT, "URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 80, 3302, 3411);
            if (CallChecker.beforeDeref(action, SecureAction.class, 82, 3425, 3430)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 82, 3425, 3430);
                CallChecker.isCalled(action, SecureAction.class, 82, 3425, 3430).setAccesssible(URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT);
            }
            GET_HOST_ADDRESS = URLStreamHandler.class.getDeclaredMethod("getHostAddress", new Class[]{ URL.class });
            CallChecker.varAssign(GET_HOST_ADDRESS, "URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 83, 3478, 3600);
            if (CallChecker.beforeDeref(action, SecureAction.class, 85, 3614, 3619)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 85, 3614, 3619);
                CallChecker.isCalled(action, SecureAction.class, 85, 3614, 3619).setAccesssible(URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS);
            }
            HASH_CODE = URLStreamHandler.class.getDeclaredMethod("hashCode", new Class[]{ URL.class });
            CallChecker.varAssign(HASH_CODE, "URLHandlersStreamHandlerProxy.HASH_CODE", 86, 3667, 3776);
            if (CallChecker.beforeDeref(action, SecureAction.class, 88, 3790, 3795)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 88, 3790, 3795);
                CallChecker.isCalled(action, SecureAction.class, 88, 3790, 3795).setAccesssible(URLHandlersStreamHandlerProxy.HASH_CODE);
            }
            HOSTS_EQUAL = URLStreamHandler.class.getDeclaredMethod("hostsEqual", new Class[]{ URL.class , URL.class });
            CallChecker.varAssign(HOSTS_EQUAL, "URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 89, 3836, 3960);
            if (CallChecker.beforeDeref(action, SecureAction.class, 91, 3974, 3979)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 91, 3974, 3979);
                CallChecker.isCalled(action, SecureAction.class, 91, 3974, 3979).setAccesssible(URLHandlersStreamHandlerProxy.HOSTS_EQUAL);
            }
            OPEN_CONNECTION = URLStreamHandler.class.getDeclaredMethod("openConnection", new Class[]{ URL.class });
            CallChecker.varAssign(OPEN_CONNECTION, "URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 92, 4022, 4143);
            if (CallChecker.beforeDeref(action, SecureAction.class, 94, 4157, 4162)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 94, 4157, 4162);
                CallChecker.isCalled(action, SecureAction.class, 94, 4157, 4162).setAccesssible(URLHandlersStreamHandlerProxy.OPEN_CONNECTION);
            }
            SAME_FILE = URLStreamHandler.class.getDeclaredMethod("sameFile", new Class[]{ URL.class , URL.class });
            CallChecker.varAssign(SAME_FILE, "URLHandlersStreamHandlerProxy.SAME_FILE", 95, 4209, 4329);
            if (CallChecker.beforeDeref(action, SecureAction.class, 97, 4343, 4348)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 97, 4343, 4348);
                CallChecker.isCalled(action, SecureAction.class, 97, 4343, 4348).setAccesssible(URLHandlersStreamHandlerProxy.SAME_FILE);
            }
            TO_EXTERNAL_FORM = URLStreamHandler.class.getDeclaredMethod("toExternalForm", new Class[]{ URL.class });
            CallChecker.varAssign(TO_EXTERNAL_FORM, "URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 98, 4389, 4510);
            if (CallChecker.beforeDeref(action, SecureAction.class, 100, 4524, 4529)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 100, 4524, 4529);
                CallChecker.isCalled(action, SecureAction.class, 100, 4524, 4529).setAccesssible(URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM);
            }
        } catch (Exception ex) {
            _bcornu_try_context_455.catchStart(455);
            throw new RuntimeException(ex.getMessage());
        } finally {
            _bcornu_try_context_455.finallyStart(455);
        }
        Method open_connection_proxy = CallChecker.varInit(null, "open_connection_proxy", 107, 4690, 4725);
        Class[] url_proxy_class = CallChecker.varInit(null, "url_proxy_class", 108, 4735, 4765);
        TryContext _bcornu_try_context_456 = new TryContext(456, URLHandlersStreamHandlerProxy.class, "java.lang.Throwable");
        try {
            url_proxy_class = new Class[]{ URL.class , Proxy.class };
            CallChecker.varAssign(url_proxy_class, "url_proxy_class", 111, 4798, 4860);
            open_connection_proxy = URLStreamHandler.class.getDeclaredMethod("openConnection", url_proxy_class);
            CallChecker.varAssign(open_connection_proxy, "open_connection_proxy", 112, 4874, 4990);
            if (CallChecker.beforeDeref(action, SecureAction.class, 114, 5004, 5009)) {
                action = CallChecker.beforeCalled(action, SecureAction.class, 114, 5004, 5009);
                CallChecker.isCalled(action, SecureAction.class, 114, 5004, 5009).setAccesssible(open_connection_proxy);
            }
        } catch (Throwable ex) {
            _bcornu_try_context_456.catchStart(456);
            open_connection_proxy = null;
            CallChecker.varAssign(open_connection_proxy, "open_connection_proxy", 118, 5110, 5138);
            url_proxy_class = null;
            CallChecker.varAssign(url_proxy_class, "url_proxy_class", 119, 5151, 5173);
        } finally {
            _bcornu_try_context_456.finallyStart(456);
        }
        OPEN_CONNECTION_PROXY = open_connection_proxy;
        CallChecker.varAssign(OPEN_CONNECTION_PROXY, "URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 121, 5193, 5238);
        URL_PROXY_CLASS = url_proxy_class;
        CallChecker.varAssign(URL_PROXY_CLASS, "URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 122, 5248, 5281);
    }

    private final Object m_service;

    private final SecureAction m_action;

    private final URLStreamHandler m_builtIn;

    private final URL m_builtInURL;

    private final String m_protocol;

    public URLHandlersStreamHandlerProxy(String protocol, SecureAction action, URLStreamHandler builtIn, URL builtInURL) {
        MethodContext _bcornu_methode_context169 = new MethodContext(null);
        try {
            m_protocol = protocol;
            CallChecker.varAssign(this.m_protocol, "this.m_protocol", 134, 5630, 5651);
            m_service = null;
            CallChecker.varAssign(this.m_service, "this.m_service", 135, 5661, 5677);
            m_action = action;
            CallChecker.varAssign(this.m_action, "this.m_action", 136, 5687, 5704);
            m_builtIn = builtIn;
            CallChecker.varAssign(this.m_builtIn, "this.m_builtIn", 137, 5714, 5733);
            m_builtInURL = builtInURL;
            CallChecker.varAssign(this.m_builtInURL, "this.m_builtInURL", 138, 5743, 5768);
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }

    private URLHandlersStreamHandlerProxy(Object service, SecureAction action) {
        MethodContext _bcornu_methode_context170 = new MethodContext(null);
        try {
            m_protocol = null;
            CallChecker.varAssign(this.m_protocol, "this.m_protocol", 143, 5870, 5887);
            m_service = service;
            CallChecker.varAssign(this.m_service, "this.m_service", 144, 5897, 5916);
            m_action = action;
            CallChecker.varAssign(this.m_action, "this.m_action", 145, 5926, 5943);
            m_builtIn = null;
            CallChecker.varAssign(this.m_builtIn, "this.m_builtIn", 146, 5953, 5969);
            m_builtInURL = null;
            CallChecker.varAssign(this.m_builtInURL, "this.m_builtInURL", 147, 5979, 5998);
        } finally {
            _bcornu_methode_context170.methodEnd();
        }
    }

    protected boolean equals(URL url1, URL url2) {
        MethodContext _bcornu_methode_context1715 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 153, 6011, 6739);
            CallChecker.varInit(url2, "url2", 153, 6011, 6739);
            CallChecker.varInit(url1, "url1", 153, 6011, 6739);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 153, 6011, 6739);
            CallChecker.varInit(this.m_protocol, "m_protocol", 153, 6011, 6739);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 153, 6011, 6739);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 153, 6011, 6739);
            CallChecker.varInit(this.m_action, "m_action", 153, 6011, 6739);
            CallChecker.varInit(this.m_service, "m_service", 153, 6011, 6739);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 153, 6011, 6739);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 153, 6011, 6739);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 153, 6011, 6739);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 153, 6011, 6739);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 153, 6011, 6739);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 153, 6011, 6739);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 153, 6011, 6739);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 153, 6011, 6739);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 153, 6011, 6739);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 153, 6011, 6739);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 153, 6011, 6739);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 155, 6127, 6165);
            if (svc == null) {
                if (CallChecker.beforeDeref(url1, URL.class, 159, 6286, 6289)) {
                    url1 = CallChecker.beforeCalled(url1, URL.class, 159, 6286, 6289);
                    throw new IllegalStateException(("Unknown protocol: " + (CallChecker.isCalled(url1, URL.class, 159, 6286, 6289).getProtocol())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).equals(url1, url2);
            }
            TryContext _bcornu_try_context_457 = new TryContext(457, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.EQUALS, Method.class, 167, 6512, 6517)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlersStreamHandlerProxy.EQUALS, Method.class, 167, 6512, 6517).invoke(svc, new Object[]{ url1 , url2 }), Object.class, 167, 6512, 6555)) {
                        return CallChecker.isCalled(((Boolean) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.EQUALS, Method.class, 167, 6512, 6517).invoke(svc, new Object[]{ url1 , url2 }))), Boolean.class, 167, 6512, 6555).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_457.catchStart(457);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_457.finallyStart(457);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1715.methodEnd();
        }
    }

    protected int getDefaultPort() {
        MethodContext _bcornu_methode_context1716 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 175, 6746, 7358);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 175, 6746, 7358);
            CallChecker.varInit(this.m_protocol, "m_protocol", 175, 6746, 7358);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 175, 6746, 7358);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 175, 6746, 7358);
            CallChecker.varInit(this.m_action, "m_action", 175, 6746, 7358);
            CallChecker.varInit(this.m_service, "m_service", 175, 6746, 7358);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 175, 6746, 7358);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 175, 6746, 7358);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 175, 6746, 7358);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 175, 6746, 7358);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 175, 6746, 7358);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 175, 6746, 7358);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 175, 6746, 7358);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 175, 6746, 7358);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 175, 6746, 7358);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 175, 6746, 7358);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 175, 6746, 7358);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 177, 6791, 6829);
            if (svc == null) {
                throw new IllegalStateException("Stream handler unavailable.");
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).getDefaultPort();
            }
            TryContext _bcornu_try_context_458 = new TryContext(458, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT, Method.class, 188, 7145, 7160)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT, Method.class, 188, 7145, 7160).invoke(svc, null), Object.class, 188, 7145, 7178)) {
                        return CallChecker.isCalled(((Integer) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT, Method.class, 188, 7145, 7160).invoke(svc, null))), Integer.class, 188, 7145, 7178).intValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_458.catchStart(458);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_458.finallyStart(458);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1716.methodEnd();
        }
    }

    protected InetAddress getHostAddress(URL url) {
        MethodContext _bcornu_methode_context1717 = new MethodContext(InetAddress.class);
        try {
            CallChecker.varInit(this, "this", 196, 7365, 8027);
            CallChecker.varInit(url, "url", 196, 7365, 8027);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 196, 7365, 8027);
            CallChecker.varInit(this.m_protocol, "m_protocol", 196, 7365, 8027);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 196, 7365, 8027);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 196, 7365, 8027);
            CallChecker.varInit(this.m_action, "m_action", 196, 7365, 8027);
            CallChecker.varInit(this.m_service, "m_service", 196, 7365, 8027);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 196, 7365, 8027);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 196, 7365, 8027);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 196, 7365, 8027);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 196, 7365, 8027);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 196, 7365, 8027);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 196, 7365, 8027);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 196, 7365, 8027);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 196, 7365, 8027);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 196, 7365, 8027);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 196, 7365, 8027);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 196, 7365, 8027);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 198, 7425, 7463);
            if (svc == null) {
                if (CallChecker.beforeDeref(url, URL.class, 202, 7584, 7586)) {
                    url = CallChecker.beforeCalled(url, URL.class, 202, 7584, 7586);
                    throw new IllegalStateException(("Unknown protocol: " + (CallChecker.isCalled(url, URL.class, 202, 7584, 7586).getProtocol())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).getHostAddress(url);
            }
            TryContext _bcornu_try_context_459 = new TryContext(459, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS, Method.class, 210, 7813, 7828)) {
                    return ((InetAddress) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS, Method.class, 210, 7813, 7828).invoke(svc, new Object[]{ url })));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_459.catchStart(459);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_459.finallyStart(459);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((InetAddress) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1717.methodEnd();
        }
    }

    protected int hashCode(URL url) {
        MethodContext _bcornu_methode_context1718 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 218, 8034, 8678);
            CallChecker.varInit(url, "url", 218, 8034, 8678);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 218, 8034, 8678);
            CallChecker.varInit(this.m_protocol, "m_protocol", 218, 8034, 8678);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 218, 8034, 8678);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 218, 8034, 8678);
            CallChecker.varInit(this.m_action, "m_action", 218, 8034, 8678);
            CallChecker.varInit(this.m_service, "m_service", 218, 8034, 8678);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 218, 8034, 8678);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 218, 8034, 8678);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 218, 8034, 8678);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 218, 8034, 8678);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 218, 8034, 8678);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 218, 8034, 8678);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 218, 8034, 8678);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 218, 8034, 8678);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 218, 8034, 8678);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 218, 8034, 8678);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 218, 8034, 8678);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 220, 8080, 8118);
            if (svc == null) {
                if (CallChecker.beforeDeref(url, URL.class, 224, 8239, 8241)) {
                    url = CallChecker.beforeCalled(url, URL.class, 224, 8239, 8241);
                    throw new IllegalStateException(("Unknown protocol: " + (CallChecker.isCalled(url, URL.class, 224, 8239, 8241).getProtocol())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).hashCode(url);
            }
            TryContext _bcornu_try_context_460 = new TryContext(460, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.HASH_CODE, Method.class, 232, 8459, 8467)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlersStreamHandlerProxy.HASH_CODE, Method.class, 232, 8459, 8467).invoke(svc, new Object[]{ url }), Object.class, 232, 8459, 8498)) {
                        return CallChecker.isCalled(((Integer) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.HASH_CODE, Method.class, 232, 8459, 8467).invoke(svc, new Object[]{ url }))), Integer.class, 232, 8459, 8498).intValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_460.catchStart(460);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_460.finallyStart(460);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1718.methodEnd();
        }
    }

    protected boolean hostsEqual(URL url1, URL url2) {
        MethodContext _bcornu_methode_context1719 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 240, 8685, 9369);
            CallChecker.varInit(url2, "url2", 240, 8685, 9369);
            CallChecker.varInit(url1, "url1", 240, 8685, 9369);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 240, 8685, 9369);
            CallChecker.varInit(this.m_protocol, "m_protocol", 240, 8685, 9369);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 240, 8685, 9369);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 240, 8685, 9369);
            CallChecker.varInit(this.m_action, "m_action", 240, 8685, 9369);
            CallChecker.varInit(this.m_service, "m_service", 240, 8685, 9369);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 240, 8685, 9369);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 240, 8685, 9369);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 240, 8685, 9369);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 240, 8685, 9369);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 240, 8685, 9369);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 240, 8685, 9369);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 240, 8685, 9369);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 240, 8685, 9369);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 240, 8685, 9369);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 240, 8685, 9369);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 240, 8685, 9369);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 242, 8748, 8786);
            if (svc == null) {
                if (CallChecker.beforeDeref(url1, URL.class, 246, 8907, 8910)) {
                    url1 = CallChecker.beforeCalled(url1, URL.class, 246, 8907, 8910);
                    throw new IllegalStateException(("Unknown protocol: " + (CallChecker.isCalled(url1, URL.class, 246, 8907, 8910).getProtocol())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).hostsEqual(url1, url2);
            }
            TryContext _bcornu_try_context_461 = new TryContext(461, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.HOSTS_EQUAL, Method.class, 254, 9137, 9147)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlersStreamHandlerProxy.HOSTS_EQUAL, Method.class, 254, 9137, 9147).invoke(svc, new Object[]{ url1 , url2 }), Object.class, 254, 9137, 9185)) {
                        return CallChecker.isCalled(((Boolean) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.HOSTS_EQUAL, Method.class, 254, 9137, 9147).invoke(svc, new Object[]{ url1 , url2 }))), Boolean.class, 254, 9137, 9185).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_461.catchStart(461);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_461.finallyStart(461);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1719.methodEnd();
        }
    }

    protected URLConnection openConnection(URL url) throws IOException {
        MethodContext _bcornu_methode_context1720 = new MethodContext(URLConnection.class);
        try {
            CallChecker.varInit(this, "this", 262, 9376, 11164);
            CallChecker.varInit(url, "url", 262, 9376, 11164);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 262, 9376, 11164);
            CallChecker.varInit(this.m_protocol, "m_protocol", 262, 9376, 11164);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 262, 9376, 11164);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 262, 9376, 11164);
            CallChecker.varInit(this.m_action, "m_action", 262, 9376, 11164);
            CallChecker.varInit(this.m_service, "m_service", 262, 9376, 11164);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 262, 9376, 11164);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 262, 9376, 11164);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 262, 9376, 11164);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 262, 9376, 11164);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 262, 9376, 11164);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 262, 9376, 11164);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 262, 9376, 11164);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 262, 9376, 11164);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 262, 9376, 11164);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 262, 9376, 11164);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 262, 9376, 11164);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 264, 9457, 9495);
            if (svc == null) {
                if (CallChecker.beforeDeref(url, URL.class, 267, 9599, 9601)) {
                    url = CallChecker.beforeCalled(url, URL.class, 267, 9599, 9601);
                    throw new MalformedURLException(("Unknown protocol: " + (CallChecker.isCalled(url, URL.class, 267, 9599, 9601).toString())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).openConnection(url);
            }
            TryContext _bcornu_try_context_463 = new TryContext(463, URLHandlersStreamHandlerProxy.class, "java.io.IOException", "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(url, URL.class, 275, 9822, 9824)) {
                    if (CallChecker.beforeDeref("http", String.class, 275, 9808, 9813)) {
                        if (CallChecker.beforeDeref(url, URL.class, 276, 9886, 9888)) {
                            if (CallChecker.beforeDeref("felix.extensions", String.class, 276, 9860, 9877)) {
                                if (CallChecker.beforeDeref(url, URL.class, 277, 9925, 9927)) {
                                    url = CallChecker.beforeCalled(url, URL.class, 275, 9822, 9824);
                                    url = CallChecker.beforeCalled(url, URL.class, 276, 9886, 9888);
                                    url = CallChecker.beforeCalled(url, URL.class, 277, 9925, 9927);
                                    if (((CallChecker.isCalled("http", String.class, 275, 9808, 9813).equals(CallChecker.isCalled(url, URL.class, 275, 9822, 9824).getProtocol())) && (CallChecker.isCalled("felix.extensions", String.class, 276, 9860, 9877).equals(CallChecker.isCalled(url, URL.class, 276, 9886, 9888).getHost()))) && (9 == (CallChecker.isCalled(url, URL.class, 277, 9925, 9927).getPort()))) {
                                        TryContext _bcornu_try_context_462 = new TryContext(462, URLHandlersStreamHandlerProxy.class, "java.io.IOException", "java.lang.Exception");
                                        try {
                                            Object handler = CallChecker.init(Object.class);
                                            if (CallChecker.beforeDeref(m_action, SecureAction.class, 281, 10030, 10037)) {
                                                handler = CallChecker.isCalled(m_action, SecureAction.class, 281, 10030, 10037).getDeclaredField(ExtensionManager.class, "m_extensionManager", null);
                                                CallChecker.varAssign(handler, "handler", 281, 10030, 10037);
                                            }
                                            if (handler != null) {
                                                if (CallChecker.beforeDeref(m_action, SecureAction.class, 287, 10290, 10297)) {
                                                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 286, 10245, 10252)) {
                                                        return ((URLConnection) (CallChecker.isCalled(m_action, SecureAction.class, 286, 10245, 10252).invoke(CallChecker.isCalled(m_action, SecureAction.class, 287, 10290, 10297).getMethod(handler.getClass(), "openConnection", new Class[]{ URL.class }), handler, new Object[]{ url })));
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }
                                            throw new IOException("Extensions not supported or ambiguous context.");
                                        } catch (IOException ex) {
                                            _bcornu_try_context_462.catchStart(462);
                                            throw ex;
                                        } catch (Exception ex) {
                                            _bcornu_try_context_462.catchStart(462);
                                            throw new IOException(ex.getMessage());
                                        } finally {
                                            _bcornu_try_context_462.finallyStart(462);
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
                
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.OPEN_CONNECTION, Method.class, 303, 10878, 10892)) {
                    return ((URLConnection) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.OPEN_CONNECTION, Method.class, 303, 10878, 10892).invoke(svc, new Object[]{ url })));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (IOException ex) {
                _bcornu_try_context_463.catchStart(463);
                throw ex;
            } catch (Exception ex) {
                _bcornu_try_context_463.catchStart(463);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_463.finallyStart(463);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLConnection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1720.methodEnd();
        }
    }

    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        MethodContext _bcornu_methode_context1721 = new MethodContext(URLConnection.class);
        try {
            CallChecker.varInit(this, "this", 315, 11171, 12707);
            CallChecker.varInit(proxy, "proxy", 315, 11171, 12707);
            CallChecker.varInit(url, "url", 315, 11171, 12707);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 315, 11171, 12707);
            CallChecker.varInit(this.m_protocol, "m_protocol", 315, 11171, 12707);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 315, 11171, 12707);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 315, 11171, 12707);
            CallChecker.varInit(this.m_action, "m_action", 315, 11171, 12707);
            CallChecker.varInit(this.m_service, "m_service", 315, 11171, 12707);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 315, 11171, 12707);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 315, 11171, 12707);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 315, 11171, 12707);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 315, 11171, 12707);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 315, 11171, 12707);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 315, 11171, 12707);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 315, 11171, 12707);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 315, 11171, 12707);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 315, 11171, 12707);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 315, 11171, 12707);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 315, 11171, 12707);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 317, 11274, 11312);
            if (svc == null) {
                if (CallChecker.beforeDeref(url, URL.class, 320, 11416, 11418)) {
                    url = CallChecker.beforeCalled(url, URL.class, 320, 11416, 11418);
                    throw new MalformedURLException(("Unknown protocol: " + (CallChecker.isCalled(url, URL.class, 320, 11416, 11418).toString())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                Method method = CallChecker.init(Method.class);
                TryContext _bcornu_try_context_464 = new TryContext(464, URLHandlersStreamHandlerProxy.class, "java.lang.NoSuchMethodException");
                try {
                    svc = CallChecker.beforeCalled(svc, Object.class, 327, 11587, 11589);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(svc, Object.class, 327, 11587, 11589).getClass(), Class.class, 327, 11587, 11600)) {
                        method = CallChecker.isCalled(svc.getClass(), Class.class, 327, 11587, 11600).getMethod("openConnection", URLHandlersStreamHandlerProxy.URL_PROXY_CLASS);
                        CallChecker.varAssign(method, "method", 327, 11578, 11646);
                    }
                } catch (NoSuchMethodException e) {
                    _bcornu_try_context_464.catchStart(464);
                    RuntimeException rte = CallChecker.varInit(new UnsupportedOperationException(e.getMessage()), "rte", 331, 11736, 11808);
                    if (CallChecker.beforeDeref(rte, RuntimeException.class, 332, 11826, 11828)) {
                        rte = CallChecker.beforeCalled(rte, RuntimeException.class, 332, 11826, 11828);
                        CallChecker.isCalled(rte, RuntimeException.class, 332, 11826, 11828).initCause(e);
                    }
                    throw rte;
                } finally {
                    _bcornu_try_context_464.finallyStart(464);
                }
                TryContext _bcornu_try_context_465 = new TryContext(465, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
                try {
                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 337, 11931, 11938)) {
                        CallChecker.isCalled(m_action, SecureAction.class, 337, 11931, 11938).setAccesssible(method);
                    }
                    if (CallChecker.beforeDeref(method, Method.class, 338, 12003, 12008)) {
                        method = CallChecker.beforeCalled(method, Method.class, 338, 12003, 12008);
                        return ((URLConnection) (CallChecker.isCalled(method, Method.class, 338, 12003, 12008).invoke(svc, new Object[]{ url , proxy })));
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (Exception e) {
                    _bcornu_try_context_465.catchStart(465);
                    if (e instanceof IOException) {
                        throw ((IOException) (e));
                    }
                    throw new IOException(e.getMessage());
                } finally {
                    _bcornu_try_context_465.finallyStart(465);
                }
            }
            TryContext _bcornu_try_context_466 = new TryContext(466, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY, Method.class, 351, 12370, 12390)) {
                    return ((URLConnection) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY, Method.class, 351, 12370, 12390).invoke(svc, new Object[]{ url , proxy })));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_466.catchStart(466);
                if (ex instanceof IOException) {
                    throw ((IOException) (ex));
                }
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_466.finallyStart(466);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLConnection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1721.methodEnd();
        }
    }

    private static final ThreadLocal m_loopCheck = new ThreadLocal();

    protected void parseURL(URL url, String spec, int start, int limit) {
        MethodContext _bcornu_methode_context1722 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 367, 13003, 16424);
            CallChecker.varInit(limit, "limit", 367, 13003, 16424);
            CallChecker.varInit(start, "start", 367, 13003, 16424);
            CallChecker.varInit(spec, "spec", 367, 13003, 16424);
            CallChecker.varInit(url, "url", 367, 13003, 16424);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 367, 13003, 16424);
            CallChecker.varInit(this.m_protocol, "m_protocol", 367, 13003, 16424);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 367, 13003, 16424);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 367, 13003, 16424);
            CallChecker.varInit(this.m_action, "m_action", 367, 13003, 16424);
            CallChecker.varInit(this.m_service, "m_service", 367, 13003, 16424);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 367, 13003, 16424);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 367, 13003, 16424);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 367, 13003, 16424);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 367, 13003, 16424);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 367, 13003, 16424);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 367, 13003, 16424);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 367, 13003, 16424);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 367, 13003, 16424);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 367, 13003, 16424);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 367, 13003, 16424);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 367, 13003, 16424);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 369, 13085, 13123);
            if (svc == null) {
                if (CallChecker.beforeDeref(url, URL.class, 373, 13244, 13246)) {
                    url = CallChecker.beforeCalled(url, URL.class, 373, 13244, 13246);
                    throw new IllegalStateException(("Unknown protocol: " + (CallChecker.isCalled(url, URL.class, 373, 13244, 13246).getProtocol())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                ((URLStreamHandlerService) (svc)).parseURL(this, url, spec, start, limit);
            }else {
                TryContext _bcornu_try_context_468 = new TryContext(468, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
                try {
                    URL test = CallChecker.varInit(null, "test", 383, 13500, 13515);
                    if ((m_builtInURL) != null) {
                        if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.m_loopCheck, ThreadLocal.class, 399, 14789, 14799)) {
                            if ((CallChecker.isCalled(URLHandlersStreamHandlerProxy.m_loopCheck, ThreadLocal.class, 399, 14789, 14799).get()) != null) {
                                if (CallChecker.beforeDeref(url, URL.class, 401, 14899, 14901)) {
                                    url = CallChecker.beforeCalled(url, URL.class, 401, 14899, 14901);
                                    test = new URL(new URL(m_builtInURL, CallChecker.isCalled(url, URL.class, 401, 14899, 14901).toExternalForm()), spec, ((URLStreamHandler) (svc)));
                                    CallChecker.varAssign(test, "test", 401, 14862, 14951);
                                }
                            }else {
                                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.m_loopCheck, ThreadLocal.class, 407, 15216, 15226)) {
                                    CallChecker.isCalled(URLHandlersStreamHandlerProxy.m_loopCheck, ThreadLocal.class, 407, 15216, 15226).set(Thread.currentThread());
                                }
                                TryContext _bcornu_try_context_467 = new TryContext(467, URLHandlersStreamHandlerProxy.class);
                                try {
                                    if (CallChecker.beforeDeref(url, URL.class, 410, 15376, 15378)) {
                                        url = CallChecker.beforeCalled(url, URL.class, 410, 15376, 15378);
                                        test = new URL(new URL(m_builtInURL, CallChecker.isCalled(url, URL.class, 410, 15376, 15378).toExternalForm()), spec);
                                        CallChecker.varAssign(test, "test", 410, 15339, 15404);
                                    }
                                } finally {
                                    _bcornu_try_context_467.finallyStart(467);
                                    if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.m_loopCheck, ThreadLocal.class, 414, 15518, 15528)) {
                                        CallChecker.isCalled(URLHandlersStreamHandlerProxy.m_loopCheck, ThreadLocal.class, 414, 15518, 15528).set(null);
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(m_action, SecureAction.class, 423, 15960, 15967)) {
                            test = CallChecker.isCalled(m_action, SecureAction.class, 423, 15960, 15967).createURL(url, spec, ((URLStreamHandler) (svc)));
                            CallChecker.varAssign(test, "test", 423, 15953, 16013);
                        }
                    }
                    if (CallChecker.beforeDeref(test, URL.class, 426, 16068, 16071)) {
                        if (CallChecker.beforeDeref(test, URL.class, 426, 16088, 16091)) {
                            if (CallChecker.beforeDeref(test, URL.class, 426, 16104, 16107)) {
                                if (CallChecker.beforeDeref(test, URL.class, 426, 16119, 16122)) {
                                    if (CallChecker.beforeDeref(test, URL.class, 427, 16160, 16163)) {
                                        if (CallChecker.beforeDeref(test, URL.class, 427, 16180, 16183)) {
                                            if (CallChecker.beforeDeref(test, URL.class, 427, 16196, 16199)) {
                                                if (CallChecker.beforeDeref(test, URL.class, 427, 16213, 16216)) {
                                                    test = CallChecker.beforeCalled(test, URL.class, 426, 16068, 16071);
                                                    test = CallChecker.beforeCalled(test, URL.class, 426, 16088, 16091);
                                                    test = CallChecker.beforeCalled(test, URL.class, 426, 16104, 16107);
                                                    test = CallChecker.beforeCalled(test, URL.class, 426, 16119, 16122);
                                                    test = CallChecker.beforeCalled(test, URL.class, 427, 16160, 16163);
                                                    test = CallChecker.beforeCalled(test, URL.class, 427, 16180, 16183);
                                                    test = CallChecker.beforeCalled(test, URL.class, 427, 16196, 16199);
                                                    test = CallChecker.beforeCalled(test, URL.class, 427, 16213, 16216);
                                                    super.setURL(url, CallChecker.isCalled(test, URL.class, 426, 16068, 16071).getProtocol(), CallChecker.isCalled(test, URL.class, 426, 16088, 16091).getHost(), CallChecker.isCalled(test, URL.class, 426, 16104, 16107).getPort(), CallChecker.isCalled(test, URL.class, 426, 16119, 16122).getAuthority(), CallChecker.isCalled(test, URL.class, 427, 16160, 16163).getUserInfo(), CallChecker.isCalled(test, URL.class, 427, 16180, 16183).getPath(), CallChecker.isCalled(test, URL.class, 427, 16196, 16199).getQuery(), CallChecker.isCalled(test, URL.class, 427, 16213, 16216).getRef());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_468.catchStart(468);
                    throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
                } finally {
                    _bcornu_try_context_468.finallyStart(468);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1722.methodEnd();
        }
    }

    protected boolean sameFile(URL url1, URL url2) {
        MethodContext _bcornu_methode_context1723 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 436, 16431, 17126);
            CallChecker.varInit(url2, "url2", 436, 16431, 17126);
            CallChecker.varInit(url1, "url1", 436, 16431, 17126);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 436, 16431, 17126);
            CallChecker.varInit(this.m_protocol, "m_protocol", 436, 16431, 17126);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 436, 16431, 17126);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 436, 16431, 17126);
            CallChecker.varInit(this.m_action, "m_action", 436, 16431, 17126);
            CallChecker.varInit(this.m_service, "m_service", 436, 16431, 17126);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 436, 16431, 17126);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 436, 16431, 17126);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 436, 16431, 17126);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 436, 16431, 17126);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 436, 16431, 17126);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 436, 16431, 17126);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 436, 16431, 17126);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 436, 16431, 17126);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 436, 16431, 17126);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 436, 16431, 17126);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 436, 16431, 17126);
            Object svc = CallChecker.varInit(getStreamHandlerService(), "svc", 438, 16492, 16530);
            if (svc == null) {
                if (CallChecker.beforeDeref(url1, URL.class, 442, 16651, 16654)) {
                    url1 = CallChecker.beforeCalled(url1, URL.class, 442, 16651, 16654);
                    throw new IllegalStateException(("Unknown protocol: " + (CallChecker.isCalled(url1, URL.class, 442, 16651, 16654).getProtocol())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).sameFile(url1, url2);
            }
            TryContext _bcornu_try_context_469 = new TryContext(469, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.SAME_FILE, Method.class, 450, 16879, 16887)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlersStreamHandlerProxy.SAME_FILE, Method.class, 450, 16879, 16887).invoke(svc, new Object[]{ url1 , url2 }), Object.class, 450, 16879, 16942)) {
                        return CallChecker.isCalled(((Boolean) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.SAME_FILE, Method.class, 450, 16879, 16887).invoke(svc, new Object[]{ url1 , url2 }))), Boolean.class, 450, 16879, 16942).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_469.catchStart(469);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_469.finallyStart(469);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1723.methodEnd();
        }
    }

    public void setURL(URL url, String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref) {
        MethodContext _bcornu_methode_context1724 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 459, 17133, 17390);
            CallChecker.varInit(ref, "ref", 459, 17133, 17390);
            CallChecker.varInit(query, "query", 459, 17133, 17390);
            CallChecker.varInit(path, "path", 459, 17133, 17390);
            CallChecker.varInit(userInfo, "userInfo", 459, 17133, 17390);
            CallChecker.varInit(authority, "authority", 459, 17133, 17390);
            CallChecker.varInit(port, "port", 459, 17133, 17390);
            CallChecker.varInit(host, "host", 459, 17133, 17390);
            CallChecker.varInit(protocol, "protocol", 459, 17133, 17390);
            CallChecker.varInit(url, "url", 459, 17133, 17390);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 459, 17133, 17390);
            CallChecker.varInit(this.m_protocol, "m_protocol", 459, 17133, 17390);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 459, 17133, 17390);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 459, 17133, 17390);
            CallChecker.varInit(this.m_action, "m_action", 459, 17133, 17390);
            CallChecker.varInit(this.m_service, "m_service", 459, 17133, 17390);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 459, 17133, 17390);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 459, 17133, 17390);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 459, 17133, 17390);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 459, 17133, 17390);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 459, 17133, 17390);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 459, 17133, 17390);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 459, 17133, 17390);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 459, 17133, 17390);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 459, 17133, 17390);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 459, 17133, 17390);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 459, 17133, 17390);
            super.setURL(url, protocol, host, port, authority, userInfo, path, query, ref);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1724.methodEnd();
        }
    }

    public void setURL(URL url, String protocol, String host, int port, String file, String ref) {
        MethodContext _bcornu_methode_context1725 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 466, 17397, 17569);
            CallChecker.varInit(ref, "ref", 466, 17397, 17569);
            CallChecker.varInit(file, "file", 466, 17397, 17569);
            CallChecker.varInit(port, "port", 466, 17397, 17569);
            CallChecker.varInit(host, "host", 466, 17397, 17569);
            CallChecker.varInit(protocol, "protocol", 466, 17397, 17569);
            CallChecker.varInit(url, "url", 466, 17397, 17569);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 466, 17397, 17569);
            CallChecker.varInit(this.m_protocol, "m_protocol", 466, 17397, 17569);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 466, 17397, 17569);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 466, 17397, 17569);
            CallChecker.varInit(this.m_action, "m_action", 466, 17397, 17569);
            CallChecker.varInit(this.m_service, "m_service", 466, 17397, 17569);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 466, 17397, 17569);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 466, 17397, 17569);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 466, 17397, 17569);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 466, 17397, 17569);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 466, 17397, 17569);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 466, 17397, 17569);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 466, 17397, 17569);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 466, 17397, 17569);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 466, 17397, 17569);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 466, 17397, 17569);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 466, 17397, 17569);
            super.setURL(url, protocol, host, port, file, ref);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1725.methodEnd();
        }
    }

    protected String toExternalForm(URL url) {
        MethodContext _bcornu_methode_context1726 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 472, 17576, 17690);
            CallChecker.varInit(url, "url", 472, 17576, 17690);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 472, 17576, 17690);
            CallChecker.varInit(this.m_protocol, "m_protocol", 472, 17576, 17690);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 472, 17576, 17690);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 472, 17576, 17690);
            CallChecker.varInit(this.m_action, "m_action", 472, 17576, 17690);
            CallChecker.varInit(this.m_service, "m_service", 472, 17576, 17690);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 472, 17576, 17690);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 472, 17576, 17690);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 472, 17576, 17690);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 472, 17576, 17690);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 472, 17576, 17690);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 472, 17576, 17690);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 472, 17576, 17690);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 472, 17576, 17690);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 472, 17576, 17690);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 472, 17576, 17690);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 472, 17576, 17690);
            return toExternalForm(url, getStreamHandlerService());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1726.methodEnd();
        }
    }

    private String toExternalForm(URL url, Object svc) {
        MethodContext _bcornu_methode_context1727 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 477, 17697, 20439);
            CallChecker.varInit(svc, "svc", 477, 17697, 20439);
            CallChecker.varInit(url, "url", 477, 17697, 20439);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 477, 17697, 20439);
            CallChecker.varInit(this.m_protocol, "m_protocol", 477, 17697, 20439);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 477, 17697, 20439);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 477, 17697, 20439);
            CallChecker.varInit(this.m_action, "m_action", 477, 17697, 20439);
            CallChecker.varInit(this.m_service, "m_service", 477, 17697, 20439);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 477, 17697, 20439);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 477, 17697, 20439);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 477, 17697, 20439);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 477, 17697, 20439);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 477, 17697, 20439);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 477, 17697, 20439);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 477, 17697, 20439);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 477, 17697, 20439);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 477, 17697, 20439);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 477, 17697, 20439);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 477, 17697, 20439);
            if (svc == null) {
                if (CallChecker.beforeDeref(url, URL.class, 482, 17873, 17875)) {
                    url = CallChecker.beforeCalled(url, URL.class, 482, 17873, 17875);
                    throw new IllegalStateException(("Unknown protocol: " + (CallChecker.isCalled(url, URL.class, 482, 17873, 17875).getProtocol())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (svc instanceof URLStreamHandlerService) {
                return ((URLStreamHandlerService) (svc)).toExternalForm(url);
            }
            TryContext _bcornu_try_context_471 = new TryContext(471, URLHandlersStreamHandlerProxy.class, "java.lang.NullPointerException", "java.lang.Exception");
            try {
                TryContext _bcornu_try_context_470 = new TryContext(470, URLHandlersStreamHandlerProxy.class, "java.lang.reflect.InvocationTargetException");
                try {
                    String result = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM, Method.class, 492, 18140, 18155)) {
                        result = ((String) (CallChecker.isCalled(URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM, Method.class, 492, 18140, 18155).invoke(svc, new Object[]{ url })));
                        CallChecker.varAssign(result, "result", 492, 18140, 18155);
                    }
                    if (CallChecker.beforeDeref(url, URL.class, 497, 18421, 18423)) {
                        url = CallChecker.beforeCalled(url, URL.class, 497, 18421, 18423);
                        if ((result != null) && (result.equals(((CallChecker.isCalled(url, URL.class, 497, 18421, 18423).getProtocol()) + "://null")))) {
                            if (CallChecker.beforeDeref(url, URL.class, 499, 18501, 18503)) {
                                url = CallChecker.beforeCalled(url, URL.class, 499, 18501, 18503);
                                result = (CallChecker.isCalled(url, URL.class, 499, 18501, 18503).getProtocol()) + ":";
                                CallChecker.varAssign(result, "result", 499, 18492, 18524);
                            }
                        }
                    }
                    return result;
                } catch (InvocationTargetException ex) {
                    _bcornu_try_context_470.catchStart(470);
                    Throwable t = CallChecker.varInit(ex.getTargetException(), "t", 506, 18668, 18705);
                    if (t instanceof Exception) {
                        throw ((Exception) (t));
                    }else
                        if (t instanceof Error) {
                            throw ((Error) (t));
                        }else {
                            throw new IllegalStateException(("Unknown throwable: " + t));
                        }
                    
                } finally {
                    _bcornu_try_context_470.finallyStart(470);
                }
            } catch (NullPointerException ex) {
                _bcornu_try_context_471.catchStart(471);
                StringBuffer answer = CallChecker.varInit(new StringBuffer(), "answer", 529, 19565, 19605);
                if (CallChecker.beforeDeref(url, URL.class, 530, 19633, 19635)) {
                    if (CallChecker.beforeDeref(answer, StringBuffer.class, 530, 19619, 19624)) {
                        url = CallChecker.beforeCalled(url, URL.class, 530, 19633, 19635);
                        answer = CallChecker.beforeCalled(answer, StringBuffer.class, 530, 19619, 19624);
                        CallChecker.isCalled(answer, StringBuffer.class, 530, 19619, 19624).append(CallChecker.isCalled(url, URL.class, 530, 19633, 19635).getProtocol());
                    }
                }
                if (CallChecker.beforeDeref(answer, StringBuffer.class, 531, 19665, 19670)) {
                    answer = CallChecker.beforeCalled(answer, StringBuffer.class, 531, 19665, 19670);
                    CallChecker.isCalled(answer, StringBuffer.class, 531, 19665, 19670).append(':');
                }
                String authority = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(url, URL.class, 532, 19716, 19718)) {
                    url = CallChecker.beforeCalled(url, URL.class, 532, 19716, 19718);
                    authority = CallChecker.isCalled(url, URL.class, 532, 19716, 19718).getAuthority();
                    CallChecker.varAssign(authority, "authority", 532, 19716, 19718);
                }
                if ((authority != null) && ((authority.length()) > 0)) {
                    if (CallChecker.beforeDeref(answer, StringBuffer.class, 535, 19831, 19836)) {
                        answer = CallChecker.beforeCalled(answer, StringBuffer.class, 535, 19831, 19836);
                        CallChecker.isCalled(answer, StringBuffer.class, 535, 19831, 19836).append("//");
                    }
                    if (CallChecker.beforeDeref(url, URL.class, 536, 19896, 19898)) {
                        if (CallChecker.beforeDeref(answer, StringBuffer.class, 536, 19882, 19887)) {
                            url = CallChecker.beforeCalled(url, URL.class, 536, 19896, 19898);
                            answer = CallChecker.beforeCalled(answer, StringBuffer.class, 536, 19882, 19887);
                            CallChecker.isCalled(answer, StringBuffer.class, 536, 19882, 19887).append(CallChecker.isCalled(url, URL.class, 536, 19896, 19898).getAuthority());
                        }
                    }
                }
                String file = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(url, URL.class, 539, 19958, 19960)) {
                    url = CallChecker.beforeCalled(url, URL.class, 539, 19958, 19960);
                    file = CallChecker.isCalled(url, URL.class, 539, 19958, 19960).getFile();
                    CallChecker.varAssign(file, "file", 539, 19958, 19960);
                }
                String ref = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(url, URL.class, 540, 19998, 20000)) {
                    url = CallChecker.beforeCalled(url, URL.class, 540, 19998, 20000);
                    ref = CallChecker.isCalled(url, URL.class, 540, 19998, 20000).getRef();
                    CallChecker.varAssign(ref, "ref", 540, 19998, 20000);
                }
                if (file != null) {
                    if (CallChecker.beforeDeref(answer, StringBuffer.class, 543, 20072, 20077)) {
                        answer = CallChecker.beforeCalled(answer, StringBuffer.class, 543, 20072, 20077);
                        CallChecker.isCalled(answer, StringBuffer.class, 543, 20072, 20077).append(file);
                    }
                }
                if (ref != null) {
                    if (CallChecker.beforeDeref(answer, StringBuffer.class, 547, 20166, 20171)) {
                        answer = CallChecker.beforeCalled(answer, StringBuffer.class, 547, 20166, 20171);
                        CallChecker.isCalled(answer, StringBuffer.class, 547, 20166, 20171).append('#');
                    }
                    if (CallChecker.beforeDeref(answer, StringBuffer.class, 548, 20202, 20207)) {
                        answer = CallChecker.beforeCalled(answer, StringBuffer.class, 548, 20202, 20207);
                        CallChecker.isCalled(answer, StringBuffer.class, 548, 20202, 20207).append(ref);
                    }
                }
                if (CallChecker.beforeDeref(answer, StringBuffer.class, 550, 20255, 20260)) {
                    answer = CallChecker.beforeCalled(answer, StringBuffer.class, 550, 20255, 20260);
                    return CallChecker.isCalled(answer, StringBuffer.class, 550, 20255, 20260).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_471.catchStart(471);
                throw new IllegalStateException(("Stream handler unavailable due to: " + (ex.getMessage())));
            } finally {
                _bcornu_try_context_471.finallyStart(471);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1727.methodEnd();
        }
    }

    private Object getStreamHandlerService() {
        MethodContext _bcornu_methode_context1728 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 569, 20446, 23023);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 569, 20446, 23023);
            CallChecker.varInit(this.m_protocol, "m_protocol", 569, 20446, 23023);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 569, 20446, 23023);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 569, 20446, 23023);
            CallChecker.varInit(this.m_action, "m_action", 569, 20446, 23023);
            CallChecker.varInit(this.m_service, "m_service", 569, 20446, 23023);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 569, 20446, 23023);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 569, 20446, 23023);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 569, 20446, 23023);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 569, 20446, 23023);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 569, 20446, 23023);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 569, 20446, 23023);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 569, 20446, 23023);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 569, 20446, 23023);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 569, 20446, 23023);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 569, 20446, 23023);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 569, 20446, 23023);
            TryContext _bcornu_try_context_472 = new TryContext(472, URLHandlersStreamHandlerProxy.class, "java.lang.ThreadDeath", "java.lang.Throwable");
            try {
                Object framework = CallChecker.varInit(URLHandlers.getFrameworkFromContext(), "framework", 574, 21083, 21139);
                if (framework == null) {
                    return m_builtIn;
                }
                Object service = CallChecker.varInit(null, "service", 582, 21262, 21283);
                if (framework instanceof Felix) {
                    service = ((Felix) (framework)).getStreamHandlerService(m_protocol);
                    CallChecker.varAssign(service, "service", 585, 21359, 21424);
                }else {
                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 590, 21534, 21541)) {
                        if (CallChecker.beforeDeref(m_action, SecureAction.class, 589, 21497, 21504)) {
                            service = CallChecker.isCalled(m_action, SecureAction.class, 589, 21497, 21504).invoke(CallChecker.isCalled(m_action, SecureAction.class, 590, 21534, 21541).getDeclaredMethod(framework.getClass(), "getStreamHandlerService", URLHandlersStreamHandlerProxy.STRING_TYPES), framework, new Object[]{ m_protocol });
                            CallChecker.varAssign(service, "service", 589, 21487, 21681);
                        }
                    }
                }
                if (service == null) {
                    return m_builtIn;
                }
                if (service instanceof URLStreamHandlerService) {
                    return ((URLStreamHandlerService) (service));
                }
                return ((URLStreamHandlerService) (java.lang.reflect.Proxy.newProxyInstance(URLStreamHandlerService.class.getClassLoader(), new Class[]{ URLStreamHandlerService.class }, new URLHandlersStreamHandlerProxy(service, m_action))));
            } catch (ThreadDeath td) {
                _bcornu_try_context_472.catchStart(472);
                throw td;
            } catch (Throwable t) {
                _bcornu_try_context_472.catchStart(472);
                return m_builtIn;
            } finally {
                _bcornu_try_context_472.finallyStart(472);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1728.methodEnd();
        }
    }

    public Object invoke(Object obj, Method method, Object[] params) throws Throwable {
        MethodContext _bcornu_methode_context1729 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 624, 23030, 24037);
            CallChecker.varInit(params, "params", 624, 23030, 24037);
            CallChecker.varInit(method, "method", 624, 23030, 24037);
            CallChecker.varInit(obj, "obj", 624, 23030, 24037);
            CallChecker.varInit(m_loopCheck, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.m_loopCheck", 624, 23030, 24037);
            CallChecker.varInit(this.m_protocol, "m_protocol", 624, 23030, 24037);
            CallChecker.varInit(this.m_builtInURL, "m_builtInURL", 624, 23030, 24037);
            CallChecker.varInit(this.m_builtIn, "m_builtIn", 624, 23030, 24037);
            CallChecker.varInit(this.m_action, "m_action", 624, 23030, 24037);
            CallChecker.varInit(this.m_service, "m_service", 624, 23030, 24037);
            CallChecker.varInit(TO_EXTERNAL_FORM, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.TO_EXTERNAL_FORM", 624, 23030, 24037);
            CallChecker.varInit(SAME_FILE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.SAME_FILE", 624, 23030, 24037);
            CallChecker.varInit(OPEN_CONNECTION_PROXY, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION_PROXY", 624, 23030, 24037);
            CallChecker.varInit(OPEN_CONNECTION, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.OPEN_CONNECTION", 624, 23030, 24037);
            CallChecker.varInit(HOSTS_EQUAL, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HOSTS_EQUAL", 624, 23030, 24037);
            CallChecker.varInit(HASH_CODE, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.HASH_CODE", 624, 23030, 24037);
            CallChecker.varInit(GET_HOST_ADDRESS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_HOST_ADDRESS", 624, 23030, 24037);
            CallChecker.varInit(GET_DEFAULT_PORT, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.GET_DEFAULT_PORT", 624, 23030, 24037);
            CallChecker.varInit(EQUALS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.EQUALS", 624, 23030, 24037);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.STRING_TYPES", 624, 23030, 24037);
            CallChecker.varInit(URL_PROXY_CLASS, "org.apache.felix.framework.URLHandlersStreamHandlerProxy.URL_PROXY_CLASS", 624, 23030, 24037);
            TryContext _bcornu_try_context_473 = new TryContext(473, URLHandlersStreamHandlerProxy.class, "java.lang.Exception");
            try {
                Class[] types = CallChecker.init(Class[].class);
                if (CallChecker.beforeDeref(method, Method.class, 630, 23177, 23182)) {
                    method = CallChecker.beforeCalled(method, Method.class, 630, 23177, 23182);
                    types = CallChecker.isCalled(method, Method.class, 630, 23177, 23182).getParameterTypes();
                    CallChecker.varAssign(types, "types", 630, 23177, 23182);
                }
                if ((m_service) == null) {
                    if (CallChecker.beforeDeref(method, Method.class, 633, 23329, 23334)) {
                        if (CallChecker.beforeDeref(m_action, SecureAction.class, 633, 23293, 23300)) {
                            if (CallChecker.beforeDeref(m_action, SecureAction.class, 633, 23277, 23284)) {
                                method = CallChecker.beforeCalled(method, Method.class, 633, 23329, 23334);
                                return CallChecker.isCalled(m_action, SecureAction.class, 633, 23277, 23284).invoke(CallChecker.isCalled(m_action, SecureAction.class, 633, 23293, 23300).getMethod(this.getClass(), CallChecker.isCalled(method, Method.class, 633, 23329, 23334).getName(), types), this, params);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(method, Method.class, 635, 23418, 23423)) {
                    if (CallChecker.beforeDeref("parseURL", String.class, 635, 23400, 23409)) {
                        method = CallChecker.beforeCalled(method, Method.class, 635, 23418, 23423);
                        if (CallChecker.isCalled("parseURL", String.class, 635, 23400, 23409).equals(CallChecker.isCalled(method, Method.class, 635, 23418, 23423).getName())) {
                            if (CallChecker.beforeDeref(types, Class[].class, 637, 23467, 23471)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_service, Object.class, 637, 23478, 23486).getClass(), Class.class, 637, 23478, 23497)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(m_service, Object.class, 637, 23478, 23486).getClass(), Class.class, 637, 23478, 23497).getClassLoader(), ClassLoader.class, 637, 23478, 23514)) {
                                        types = CallChecker.beforeCalled(types, Class[].class, 637, 23467, 23471);
                                        CallChecker.isCalled(types, Class[].class, 637, 23467, 23471)[0] = CallChecker.isCalled(CallChecker.isCalled(m_service.getClass(), Class.class, 637, 23478, 23497).getClassLoader(), ClassLoader.class, 637, 23478, 23514).loadClass(URLStreamHandlerSetter.class.getName());
                                        CallChecker.varAssign(CallChecker.isCalled(types, Class[].class, 637, 23467, 23471)[0], "CallChecker.isCalled(types, Class[].class, 637, 23467, 23471)[0]", 637, 23467, 23586);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(params, Object[].class, 639, 23604, 23609)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_service, Object.class, 640, 23660, 23668).getClass(), Class.class, 640, 23660, 23679)) {
                                    if (CallChecker.beforeDeref(types, Class[].class, 640, 23711, 23715)) {
                                        if (CallChecker.beforeDeref(params, Object[].class, 641, 23774, 23779)) {
                                            params = CallChecker.beforeCalled(params, Object[].class, 639, 23604, 23609);
                                            types = CallChecker.beforeCalled(types, Class[].class, 640, 23711, 23715);
                                            params = CallChecker.beforeCalled(params, Object[].class, 641, 23774, 23779);
                                            CallChecker.isCalled(params, Object[].class, 639, 23604, 23609)[0] = java.lang.reflect.Proxy.newProxyInstance(CallChecker.isCalled(m_service.getClass(), Class.class, 640, 23660, 23679).getClassLoader(), new Class[]{ CallChecker.isCalled(types, Class[].class, 640, 23711, 23715)[0] }, ((URLHandlersStreamHandlerProxy) (CallChecker.isCalled(params, Object[].class, 641, 23774, 23779)[0])));
                                            CallChecker.varAssign(CallChecker.isCalled(params, Object[].class, 639, 23604, 23609)[0], "CallChecker.isCalled(params, Object[].class, 639, 23604, 23609)[0]", 639, 23604, 23784);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(method, Method.class, 644, 23906, 23911)) {
                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 643, 23841, 23848)) {
                        if (CallChecker.beforeDeref(m_action, SecureAction.class, 643, 23819, 23826)) {
                            method = CallChecker.beforeCalled(method, Method.class, 644, 23906, 23911);
                            return CallChecker.isCalled(m_action, SecureAction.class, 643, 23819, 23826).invokeDirect(CallChecker.isCalled(m_action, SecureAction.class, 643, 23841, 23848).getDeclaredMethod(m_service.getClass(), CallChecker.isCalled(method, Method.class, 644, 23906, 23911).getName(), types), m_service, params);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_473.catchStart(473);
                throw ex;
            } finally {
                _bcornu_try_context_473.finallyStart(473);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1729.methodEnd();
        }
    }
}

