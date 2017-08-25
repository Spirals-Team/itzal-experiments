package org.apache.felix.framework;

import org.apache.felix.framework.util.Util;
import java.net.URLStreamHandler;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.SecureAction;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.AdminPermission;
import org.osgi.framework.Bundle;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.lang.reflect.Constructor;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.net.InetAddress;

class URLHandlersBundleStreamHandler extends URLStreamHandler {
    private final Felix m_framework;

    private final SecureAction m_action;

    public URLHandlersBundleStreamHandler(Felix framework) {
        MethodContext _bcornu_methode_context29 = new MethodContext(null);
        try {
            m_framework = framework;
            CallChecker.varAssign(this.m_framework, "this.m_framework", 37, 1324, 1347);
            m_action = null;
            CallChecker.varAssign(this.m_action, "this.m_action", 38, 1357, 1372);
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public URLHandlersBundleStreamHandler(SecureAction action) {
        MethodContext _bcornu_methode_context30 = new MethodContext(null);
        try {
            m_framework = null;
            CallChecker.varAssign(this.m_framework, "this.m_framework", 43, 1458, 1476);
            m_action = action;
            CallChecker.varAssign(this.m_action, "this.m_action", 44, 1486, 1503);
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    protected synchronized URLConnection openConnection(URL url) throws IOException {
        MethodContext _bcornu_methode_context436 = new MethodContext(URLConnection.class);
        try {
            CallChecker.varInit(this, "this", 47, 1516, 2905);
            CallChecker.varInit(url, "url", 47, 1516, 2905);
            CallChecker.varInit(this.m_action, "m_action", 47, 1516, 2905);
            CallChecker.varInit(this.m_framework, "m_framework", 47, 1516, 2905);
            if (CallChecker.beforeDeref(url, URL.class, 49, 1630, 1632)) {
                if (CallChecker.beforeDeref("felix", String.class, 49, 1615, 1621)) {
                    url = CallChecker.beforeCalled(url, URL.class, 49, 1630, 1632);
                    if (!(CallChecker.isCalled("felix", String.class, 49, 1615, 1621).equals(CallChecker.isCalled(url, URL.class, 49, 1630, 1632).getAuthority()))) {
                        checkPermission(url);
                    }
                }
            }
            if ((m_framework) != null) {
                return new URLHandlersBundleURLConnection(url, m_framework);
            }
            Object framework = CallChecker.varInit(URLHandlers.getFrameworkFromContext(), "framework", 58, 1848, 1904);
            if (framework != null) {
                if (framework instanceof Felix) {
                    return new URLHandlersBundleURLConnection(url, ((Felix) (framework)));
                }
                TryContext _bcornu_try_context_126 = new TryContext(126, URLHandlersBundleStreamHandler.class, "java.lang.Exception");
                try {
                    Class targetClass = CallChecker.init(Class.class);
                    framework = CallChecker.beforeCalled(framework, Object.class, 68, 2177, 2185);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(framework, Object.class, 68, 2177, 2185).getClass(), Class.class, 68, 2177, 2196)) {
                        framework = CallChecker.beforeCalled(framework, Object.class, 68, 2177, 2185);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(framework, Object.class, 68, 2177, 2185).getClass(), Class.class, 68, 2177, 2196).getClassLoader(), ClassLoader.class, 68, 2177, 2213)) {
                            targetClass = CallChecker.isCalled(CallChecker.isCalled(framework.getClass(), Class.class, 68, 2177, 2196).getClassLoader(), ClassLoader.class, 68, 2177, 2213).loadClass(URLHandlersBundleURLConnection.class.getName());
                            CallChecker.varAssign(targetClass, "targetClass", 68, 2177, 2196);
                        }
                    }
                    Constructor constructor = CallChecker.init(Constructor.class);
                    framework = CallChecker.beforeCalled(framework, Object.class, 72, 2439, 2447);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(framework, Object.class, 72, 2439, 2447).getClass(), Class.class, 72, 2439, 2458)) {
                        framework = CallChecker.beforeCalled(framework, Object.class, 72, 2439, 2447);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(framework, Object.class, 72, 2439, 2447).getClass(), Class.class, 72, 2439, 2458).getClassLoader(), ClassLoader.class, 72, 2439, 2475)) {
                            if (CallChecker.beforeDeref(m_action, SecureAction.class, 71, 2354, 2361)) {
                                constructor = CallChecker.isCalled(m_action, SecureAction.class, 71, 2354, 2361).getConstructor(targetClass, new Class[]{ URL.class , CallChecker.isCalled(CallChecker.isCalled(framework.getClass(), Class.class, 72, 2439, 2458).getClassLoader(), ClassLoader.class, 72, 2439, 2475).loadClass(Felix.class.getName()) });
                                CallChecker.varAssign(constructor, "constructor", 72, 2439, 2458);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 74, 2562, 2569)) {
                        CallChecker.isCalled(m_action, SecureAction.class, 74, 2562, 2569).setAccesssible(constructor);
                    }
                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 75, 2639, 2646)) {
                        return ((URLConnection) (CallChecker.isCalled(m_action, SecureAction.class, 75, 2639, 2646).invoke(constructor, new Object[]{ url , framework })));
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (Exception ex) {
                    _bcornu_try_context_126.catchStart(126);
                    throw new IOException(ex.getMessage());
                } finally {
                    _bcornu_try_context_126.finallyStart(126);
                }
            }
            throw new IOException("No framework context found");
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLConnection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context436.methodEnd();
        }
    }

    protected void parseURL(URL u, String spec, int start, int limit) {
        MethodContext _bcornu_methode_context437 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 85, 2912, 3226);
            CallChecker.varInit(limit, "limit", 85, 2912, 3226);
            CallChecker.varInit(start, "start", 85, 2912, 3226);
            CallChecker.varInit(spec, "spec", 85, 2912, 3226);
            CallChecker.varInit(u, "u", 85, 2912, 3226);
            CallChecker.varInit(this.m_action, "m_action", 85, 2912, 3226);
            CallChecker.varInit(this.m_framework, "m_framework", 85, 2912, 3226);
            super.parseURL(u, spec, start, limit);
            if (checkPermission(u)) {
                if (CallChecker.beforeDeref(u, URL.class, 91, 3103, 3103)) {
                    if (CallChecker.beforeDeref(u, URL.class, 91, 3120, 3120)) {
                        if (CallChecker.beforeDeref(u, URL.class, 91, 3133, 3133)) {
                            if (CallChecker.beforeDeref(u, URL.class, 91, 3155, 3155)) {
                                if (CallChecker.beforeDeref(u, URL.class, 91, 3172, 3172)) {
                                    if (CallChecker.beforeDeref(u, URL.class, 91, 3185, 3185)) {
                                        if (CallChecker.beforeDeref(u, URL.class, 91, 3199, 3199)) {
                                            u = CallChecker.beforeCalled(u, URL.class, 91, 3103, 3103);
                                            u = CallChecker.beforeCalled(u, URL.class, 91, 3120, 3120);
                                            u = CallChecker.beforeCalled(u, URL.class, 91, 3133, 3133);
                                            u = CallChecker.beforeCalled(u, URL.class, 91, 3155, 3155);
                                            u = CallChecker.beforeCalled(u, URL.class, 91, 3172, 3172);
                                            u = CallChecker.beforeCalled(u, URL.class, 91, 3185, 3185);
                                            u = CallChecker.beforeCalled(u, URL.class, 91, 3199, 3199);
                                            super.setURL(u, CallChecker.isCalled(u, URL.class, 91, 3103, 3103).getProtocol(), CallChecker.isCalled(u, URL.class, 91, 3120, 3120).getHost(), CallChecker.isCalled(u, URL.class, 91, 3133, 3133).getPort(), "felix", CallChecker.isCalled(u, URL.class, 91, 3155, 3155).getUserInfo(), CallChecker.isCalled(u, URL.class, 91, 3172, 3172).getPath(), CallChecker.isCalled(u, URL.class, 91, 3185, 3185).getQuery(), CallChecker.isCalled(u, URL.class, 91, 3199, 3199).getRef());
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
            _bcornu_methode_context437.methodEnd();
        }
    }

    protected String toExternalForm(URL u) {
        MethodContext _bcornu_methode_context438 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 95, 3233, 3883);
            CallChecker.varInit(u, "u", 95, 3233, 3883);
            CallChecker.varInit(this.m_action, "m_action", 95, 3233, 3883);
            CallChecker.varInit(this.m_framework, "m_framework", 95, 3233, 3883);
            StringBuffer result = CallChecker.varInit(new StringBuffer(), "result", 97, 3287, 3327);
            if (CallChecker.beforeDeref(u, URL.class, 98, 3351, 3351)) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 98, 3337, 3342)) {
                    u = CallChecker.beforeCalled(u, URL.class, 98, 3351, 3351);
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 98, 3337, 3342);
                    CallChecker.isCalled(result, StringBuffer.class, 98, 3337, 3342).append(CallChecker.isCalled(u, URL.class, 98, 3351, 3351).getProtocol());
                }
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 99, 3377, 3382)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 99, 3377, 3382);
                CallChecker.isCalled(result, StringBuffer.class, 99, 3377, 3382).append("://");
            }
            if (CallChecker.beforeDeref(u, URL.class, 100, 3421, 3421)) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 100, 3407, 3412)) {
                    u = CallChecker.beforeCalled(u, URL.class, 100, 3421, 3421);
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 100, 3407, 3412);
                    CallChecker.isCalled(result, StringBuffer.class, 100, 3407, 3412).append(CallChecker.isCalled(u, URL.class, 100, 3421, 3421).getHost());
                }
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 101, 3443, 3448)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 101, 3443, 3448);
                CallChecker.isCalled(result, StringBuffer.class, 101, 3443, 3448).append(':');
            }
            if (CallChecker.beforeDeref(u, URL.class, 102, 3485, 3485)) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 102, 3471, 3476)) {
                    u = CallChecker.beforeCalled(u, URL.class, 102, 3485, 3485);
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 102, 3471, 3476);
                    CallChecker.isCalled(result, StringBuffer.class, 102, 3471, 3476).append(CallChecker.isCalled(u, URL.class, 102, 3485, 3485).getPort());
                }
            }
            if (CallChecker.beforeDeref(u, URL.class, 103, 3511, 3511)) {
                u = CallChecker.beforeCalled(u, URL.class, 103, 3511, 3511);
                if ((CallChecker.isCalled(u, URL.class, 103, 3511, 3511).getPath()) != null) {
                    if (CallChecker.beforeDeref(u, URL.class, 105, 3569, 3569)) {
                        if (CallChecker.beforeDeref(result, StringBuffer.class, 105, 3555, 3560)) {
                            u = CallChecker.beforeCalled(u, URL.class, 105, 3569, 3569);
                            result = CallChecker.beforeCalled(result, StringBuffer.class, 105, 3555, 3560);
                            CallChecker.isCalled(result, StringBuffer.class, 105, 3555, 3560).append(CallChecker.isCalled(u, URL.class, 105, 3569, 3569).getPath());
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(u, URL.class, 107, 3605, 3605)) {
                u = CallChecker.beforeCalled(u, URL.class, 107, 3605, 3605);
                if ((CallChecker.isCalled(u, URL.class, 107, 3605, 3605).getQuery()) != null) {
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 109, 3650, 3655)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 109, 3650, 3655);
                        CallChecker.isCalled(result, StringBuffer.class, 109, 3650, 3655).append('?');
                    }
                    if (CallChecker.beforeDeref(u, URL.class, 110, 3696, 3696)) {
                        if (CallChecker.beforeDeref(result, StringBuffer.class, 110, 3682, 3687)) {
                            u = CallChecker.beforeCalled(u, URL.class, 110, 3696, 3696);
                            result = CallChecker.beforeCalled(result, StringBuffer.class, 110, 3682, 3687);
                            CallChecker.isCalled(result, StringBuffer.class, 110, 3682, 3687).append(CallChecker.isCalled(u, URL.class, 110, 3696, 3696).getQuery());
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(u, URL.class, 112, 3733, 3733)) {
                u = CallChecker.beforeCalled(u, URL.class, 112, 3733, 3733);
                if ((CallChecker.isCalled(u, URL.class, 112, 3733, 3733).getRef()) != null) {
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 114, 3776, 3781)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 114, 3776, 3781);
                        CallChecker.isCalled(result, StringBuffer.class, 114, 3776, 3781).append("#");
                    }
                    if (CallChecker.beforeDeref(u, URL.class, 115, 3822, 3822)) {
                        if (CallChecker.beforeDeref(result, StringBuffer.class, 115, 3808, 3813)) {
                            u = CallChecker.beforeCalled(u, URL.class, 115, 3822, 3822);
                            result = CallChecker.beforeCalled(result, StringBuffer.class, 115, 3808, 3813);
                            CallChecker.isCalled(result, StringBuffer.class, 115, 3808, 3813).append(CallChecker.isCalled(u, URL.class, 115, 3822, 3822).getRef());
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 117, 3860, 3865)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 117, 3860, 3865);
                return CallChecker.isCalled(result, StringBuffer.class, 117, 3860, 3865).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context438.methodEnd();
        }
    }

    protected InetAddress getHostAddress(URL u) {
        MethodContext _bcornu_methode_context439 = new MethodContext(InetAddress.class);
        try {
            CallChecker.varInit(this, "this", 120, 3894, 3978);
            CallChecker.varInit(u, "u", 120, 3894, 3978);
            CallChecker.varInit(this.m_action, "m_action", 120, 3894, 3978);
            CallChecker.varInit(this.m_framework, "m_framework", 120, 3894, 3978);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((InetAddress) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context439.methodEnd();
        }
    }

    private boolean checkPermission(URL u) {
        MethodContext _bcornu_methode_context440 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 125, 3985, 4864);
            CallChecker.varInit(u, "u", 125, 3985, 4864);
            CallChecker.varInit(this.m_action, "m_action", 125, 3985, 4864);
            CallChecker.varInit(this.m_framework, "m_framework", 125, 3985, 4864);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 127, 4038, 4086);
            if (sm != null) {
                Object framework = CallChecker.varInit(m_framework, "framework", 130, 4134, 4164);
                if (framework == null) {
                    framework = URLHandlers.getFrameworkFromContext();
                    CallChecker.varAssign(framework, "framework", 133, 4231, 4280);
                    if (!(framework instanceof Felix)) {
                        return false;
                    }
                }
                Felix felix = CallChecker.varInit(((Felix) (framework)), "felix", 139, 4429, 4460);
                long bundleId = CallChecker.init(long.class);
                if (CallChecker.beforeDeref(u, URL.class, 140, 4521, 4521)) {
                    u = CallChecker.beforeCalled(u, URL.class, 140, 4521, 4521);
                    bundleId = Util.getBundleIdFromRevisionId(CallChecker.isCalled(u, URL.class, 140, 4521, 4521).getHost());
                    CallChecker.varAssign(bundleId, "bundleId", 140, 4521, 4521);
                }
                Bundle bundle = CallChecker.init(Bundle.class);
                if (CallChecker.beforeDeref(felix, Felix.class, 141, 4563, 4567)) {
                    felix = CallChecker.beforeCalled(felix, Felix.class, 141, 4563, 4567);
                    bundle = CallChecker.isCalled(felix, Felix.class, 141, 4563, 4567).getBundle(bundleId);
                    CallChecker.varAssign(bundle, "bundle", 141, 4563, 4567);
                }
                if (bundle != null) {
                    sm.checkPermission(new AdminPermission(bundle, AdminPermission.RESOURCE));
                    return true;
                }
            }else {
                return true;
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context440.methodEnd();
        }
    }
}

