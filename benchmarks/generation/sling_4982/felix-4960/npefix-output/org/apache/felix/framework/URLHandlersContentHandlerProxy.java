package org.apache.felix.framework;

import java.net.URLConnection;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.StringTokenizer;
import org.apache.felix.framework.util.SecureAction;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.net.ContentHandler;
import java.net.ContentHandlerFactory;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

class URLHandlersContentHandlerProxy extends ContentHandler {
    private static final Class[] STRING_TYPES = new Class[]{ String.class };

    private static final String CONTENT_HANDLER_PACKAGE_PROP = "java.content.handler.pkgs";

    private static final String DEFAULT_CONTENT_HANDLER_PACKAGE = "sun.net.www.content|com.ibm.oti.net.www.content|gnu.java.net.content|org.apache.harmony.luni.internal.net.www.content|COM.newmonics.www.content";

    private static final Map m_builtIn = new HashMap();

    private static final String m_pkgs;

    static {
        String pkgs = CallChecker.init(String.class);
        if (CallChecker.beforeDeref(new SecureAction(), SecureAction.class, 65, 2689, 2706)) {
            pkgs = CallChecker.isCalled(new SecureAction(), SecureAction.class, 65, 2689, 2706).getSystemProperty(URLHandlersContentHandlerProxy.CONTENT_HANDLER_PACKAGE_PROP, "");
            CallChecker.varAssign(pkgs, "pkgs", 65, 2689, 2706);
        }
        pkgs = CallChecker.beforeCalled(pkgs, String.class, 66, 2779, 2782);
        if (CallChecker.isCalled(pkgs, String.class, 66, 2779, 2782).equals("")) {
            m_pkgs = URLHandlersContentHandlerProxy.DEFAULT_CONTENT_HANDLER_PACKAGE;
            CallChecker.varAssign(m_pkgs, "URLHandlersContentHandlerProxy.m_pkgs", 66, 2769, 2900);
        }else {
            m_pkgs = (pkgs + "|") + (URLHandlersContentHandlerProxy.DEFAULT_CONTENT_HANDLER_PACKAGE);
            CallChecker.varAssign(m_pkgs, "URLHandlersContentHandlerProxy.m_pkgs", 66, 2769, 2900);
        }
    }

    private final ContentHandlerFactory m_factory;

    private final String m_mimeType;

    private final SecureAction m_action;

    public URLHandlersContentHandlerProxy(String mimeType, SecureAction action, ContentHandlerFactory factory) {
        MethodContext _bcornu_methode_context46 = new MethodContext(null);
        try {
            m_mimeType = mimeType;
            CallChecker.varAssign(this.m_mimeType, "this.m_mimeType", 79, 3173, 3194);
            m_action = action;
            CallChecker.varAssign(this.m_action, "this.m_action", 80, 3204, 3221);
            m_factory = factory;
            CallChecker.varAssign(this.m_factory, "this.m_factory", 81, 3231, 3250);
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public Object getContent(URLConnection urlc) throws IOException {
        MethodContext _bcornu_methode_context565 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 88, 3263, 3573);
            CallChecker.varInit(urlc, "urlc", 88, 3263, 3573);
            CallChecker.varInit(this.m_action, "m_action", 88, 3263, 3573);
            CallChecker.varInit(this.m_mimeType, "m_mimeType", 88, 3263, 3573);
            CallChecker.varInit(this.m_factory, "m_factory", 88, 3263, 3573);
            CallChecker.varInit(m_pkgs, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_pkgs", 88, 3263, 3573);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_builtIn", 88, 3263, 3573);
            CallChecker.varInit(DEFAULT_CONTENT_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlersContentHandlerProxy.DEFAULT_CONTENT_HANDLER_PACKAGE", 88, 3263, 3573);
            CallChecker.varInit(CONTENT_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlersContentHandlerProxy.CONTENT_HANDLER_PACKAGE_PROP", 88, 3263, 3573);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersContentHandlerProxy.STRING_TYPES", 88, 3263, 3573);
            ContentHandler svc = CallChecker.varInit(getContentHandlerService(), "svc", 90, 3396, 3443);
            if (svc == null) {
                if (CallChecker.beforeDeref(urlc, URLConnection.class, 93, 3499, 3502)) {
                    urlc = CallChecker.beforeCalled(urlc, URLConnection.class, 93, 3499, 3502);
                    return CallChecker.isCalled(urlc, URLConnection.class, 93, 3499, 3502).getInputStream();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return svc.getContent(urlc);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context565.methodEnd();
        }
    }

    private ContentHandler getContentHandlerService() {
        MethodContext _bcornu_methode_context566 = new MethodContext(ContentHandler.class);
        try {
            CallChecker.varInit(this, "this", 109, 3580, 5076);
            CallChecker.varInit(this.m_action, "m_action", 109, 3580, 5076);
            CallChecker.varInit(this.m_mimeType, "m_mimeType", 109, 3580, 5076);
            CallChecker.varInit(this.m_factory, "m_factory", 109, 3580, 5076);
            CallChecker.varInit(m_pkgs, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_pkgs", 109, 3580, 5076);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_builtIn", 109, 3580, 5076);
            CallChecker.varInit(DEFAULT_CONTENT_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlersContentHandlerProxy.DEFAULT_CONTENT_HANDLER_PACKAGE", 109, 3580, 5076);
            CallChecker.varInit(CONTENT_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlersContentHandlerProxy.CONTENT_HANDLER_PACKAGE_PROP", 109, 3580, 5076);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersContentHandlerProxy.STRING_TYPES", 109, 3580, 5076);
            Object framework = CallChecker.varInit(URLHandlers.getFrameworkFromContext(), "framework", 112, 4198, 4254);
            if (framework == null) {
                return getBuiltIn();
            }
            TryContext _bcornu_try_context_140 = new TryContext(140, URLHandlersContentHandlerProxy.class, "java.lang.Exception");
            try {
                ContentHandler service = CallChecker.init(ContentHandler.class);
                if (framework instanceof Felix) {
                    service = ((ContentHandler) (((Felix) (framework)).getContentHandlerService(m_mimeType)));
                    CallChecker.varAssign(service, "service", 123, 4473, 4556);
                }else {
                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 128, 4683, 4690)) {
                        if (CallChecker.beforeDeref(m_action, SecureAction.class, 127, 4646, 4653)) {
                            service = ((ContentHandler) (CallChecker.isCalled(m_action, SecureAction.class, 127, 4646, 4653).invoke(CallChecker.isCalled(m_action, SecureAction.class, 128, 4683, 4690).getDeclaredMethod(framework.getClass(), "getContentHandlerService", URLHandlersContentHandlerProxy.STRING_TYPES), framework, new Object[]{ m_mimeType })));
                            CallChecker.varAssign(service, "service", 127, 4619, 4831);
                        }
                    }
                }
                if (service == null) {
                    return getBuiltIn();
                }else {
                    return service;
                }
            } catch (Exception ex) {
                _bcornu_try_context_140.catchStart(140);
                ex.printStackTrace();
                return null;
            } finally {
                _bcornu_try_context_140.finallyStart(140);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ContentHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context566.methodEnd();
        }
    }

    private ContentHandler getBuiltIn() {
        MethodContext _bcornu_methode_context567 = new MethodContext(ContentHandler.class);
        try {
            CallChecker.varInit(this, "this", 142, 5083, 6731);
            CallChecker.varInit(this.m_action, "m_action", 142, 5083, 6731);
            CallChecker.varInit(this.m_mimeType, "m_mimeType", 142, 5083, 6731);
            CallChecker.varInit(this.m_factory, "m_factory", 142, 5083, 6731);
            CallChecker.varInit(m_pkgs, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_pkgs", 142, 5083, 6731);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_builtIn", 142, 5083, 6731);
            CallChecker.varInit(DEFAULT_CONTENT_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlersContentHandlerProxy.DEFAULT_CONTENT_HANDLER_PACKAGE", 142, 5083, 6731);
            CallChecker.varInit(CONTENT_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlersContentHandlerProxy.CONTENT_HANDLER_PACKAGE_PROP", 142, 5083, 6731);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersContentHandlerProxy.STRING_TYPES", 142, 5083, 6731);
            synchronized(URLHandlersContentHandlerProxy.m_builtIn) {
                if (CallChecker.beforeDeref(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 146, 5184, 5192)) {
                    if (CallChecker.isCalled(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 146, 5184, 5192).containsKey(m_mimeType)) {
                        if (CallChecker.beforeDeref(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 148, 5273, 5281)) {
                            return ((ContentHandler) (CallChecker.isCalled(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 148, 5273, 5281).get(m_mimeType)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((m_factory) != null) {
                ContentHandler result = CallChecker.varInit(m_factory.createContentHandler(m_mimeType), "result", 153, 5377, 5443);
                if (result != null) {
                    return addToCache(m_mimeType, result);
                }
            }
            String fixedType = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_mimeType, String.class, 161, 5718, 5727)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_mimeType, String.class, 161, 5718, 5727).replace('.', '_'), String.class, 161, 5718, 5745)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(m_mimeType, String.class, 161, 5718, 5727).replace('.', '_'), String.class, 161, 5718, 5745).replace('/', '.'), String.class, 161, 5718, 5763)) {
                        fixedType = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(m_mimeType, String.class, 161, 5718, 5727).replace('.', '_'), String.class, 161, 5718, 5745).replace('/', '.'), String.class, 161, 5718, 5763).replace('-', '_');
                        CallChecker.varAssign(fixedType, "fixedType", 161, 5718, 5727);
                    }
                }
            }
            StringTokenizer pkgTok = CallChecker.varInit(new StringTokenizer(URLHandlersContentHandlerProxy.m_pkgs, "| "), "pkgTok", 164, 5836, 5894);
            pkgTok = CallChecker.beforeCalled(pkgTok, StringTokenizer.class, 165, 5911, 5916);
            while (CallChecker.isCalled(pkgTok, StringTokenizer.class, 165, 5911, 5916).hasMoreTokens()) {
                String pkg = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(pkgTok, StringTokenizer.class, 167, 5970, 5975)) {
                    pkgTok = CallChecker.beforeCalled(pkgTok, StringTokenizer.class, 167, 5970, 5975);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(pkgTok, StringTokenizer.class, 167, 5970, 5975).nextToken(), String.class, 167, 5970, 5987)) {
                        pkgTok = CallChecker.beforeCalled(pkgTok, StringTokenizer.class, 167, 5970, 5975);
                        pkg = CallChecker.isCalled(CallChecker.isCalled(pkgTok, StringTokenizer.class, 167, 5970, 5975).nextToken(), String.class, 167, 5970, 5987).trim();
                        CallChecker.varAssign(pkg, "pkg", 167, 5970, 5975);
                    }
                }
                String className = CallChecker.varInit(((pkg + ".") + fixedType), "className", 168, 6009, 6049);
                TryContext _bcornu_try_context_141 = new TryContext(141, URLHandlersContentHandlerProxy.class, "java.lang.Exception");
                try {
                    Class handler = CallChecker.init(Class.class);
                    if (CallChecker.beforeDeref(m_action, SecureAction.class, 172, 6188, 6195)) {
                        handler = CallChecker.isCalled(m_action, SecureAction.class, 172, 6188, 6195).forName(className, null);
                        CallChecker.varAssign(handler, "handler", 172, 6188, 6195);
                    }
                    if (handler != null) {
                        return addToCache(m_mimeType, ((ContentHandler) (handler.newInstance())));
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_141.catchStart(141);
                } finally {
                    _bcornu_try_context_141.finallyStart(141);
                }
            } 
            return addToCache(m_mimeType, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ContentHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context567.methodEnd();
        }
    }

    private synchronized ContentHandler addToCache(String mimeType, ContentHandler handler) {
        MethodContext _bcornu_methode_context568 = new MethodContext(ContentHandler.class);
        try {
            CallChecker.varInit(this, "this", 189, 6738, 7033);
            CallChecker.varInit(handler, "handler", 189, 6738, 7033);
            CallChecker.varInit(mimeType, "mimeType", 189, 6738, 7033);
            CallChecker.varInit(this.m_action, "m_action", 189, 6738, 7033);
            CallChecker.varInit(this.m_mimeType, "m_mimeType", 189, 6738, 7033);
            CallChecker.varInit(this.m_factory, "m_factory", 189, 6738, 7033);
            CallChecker.varInit(m_pkgs, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_pkgs", 189, 6738, 7033);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlersContentHandlerProxy.m_builtIn", 189, 6738, 7033);
            CallChecker.varInit(DEFAULT_CONTENT_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlersContentHandlerProxy.DEFAULT_CONTENT_HANDLER_PACKAGE", 189, 6738, 7033);
            CallChecker.varInit(CONTENT_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlersContentHandlerProxy.CONTENT_HANDLER_PACKAGE_PROP", 189, 6738, 7033);
            CallChecker.varInit(STRING_TYPES, "org.apache.felix.framework.URLHandlersContentHandlerProxy.STRING_TYPES", 189, 6738, 7033);
            if (CallChecker.beforeDeref(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 191, 6845, 6853)) {
                if (!(CallChecker.isCalled(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 191, 6845, 6853).containsKey(mimeType))) {
                    if (CallChecker.beforeDeref(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 193, 6900, 6908)) {
                        CallChecker.isCalled(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 193, 6900, 6908).put(mimeType, handler);
                    }
                    return handler;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 196, 7004, 7012)) {
                return ((ContentHandler) (CallChecker.isCalled(URLHandlersContentHandlerProxy.m_builtIn, Map.class, 196, 7004, 7012).get(mimeType)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ContentHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context568.methodEnd();
        }
    }
}

