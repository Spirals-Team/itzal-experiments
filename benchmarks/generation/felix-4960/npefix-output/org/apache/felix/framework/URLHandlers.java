package org.apache.felix.framework;

import org.osgi.service.url.URLStreamHandlerService;
import java.net.URLStreamHandlerFactory;
import java.net.URLStreamHandler;
import java.util.HashMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.felix.framework.util.FelixConstants;
import java.net.ContentHandlerFactory;
import java.net.ContentHandler;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.felix.framework.util.SecureAction;
import org.apache.felix.framework.util.SecurityManagerEx;
import java.util.StringTokenizer;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.net.URL;
import java.net.URLConnection;

class URLHandlers implements ContentHandlerFactory , URLStreamHandlerFactory {
    private static final Class[] CLASS_TYPE = new Class[]{ Class.class };

    private static final Class URLHANDLERS_CLASS = URLHandlers.class;

    private static final SecureAction m_secureAction = new SecureAction();

    private static volatile SecurityManagerEx m_sm = null;

    private static volatile URLHandlers m_handler = null;

    private static final Map m_classloaderToFrameworkLists = new HashMap();

    private static final List m_frameworks = new ArrayList();

    private static int m_counter = 0;

    private static Map m_contentHandlerCache = null;

    private static Map m_streamHandlerCache = null;

    private static URLStreamHandlerFactory m_streamHandlerFactory;

    private static ContentHandlerFactory m_contentHandlerFactory;

    private static final String STREAM_HANDLER_PACKAGE_PROP = "java.protocol.handler.pkgs";

    private static final String DEFAULT_STREAM_HANDLER_PACKAGE = "sun.net.www.protocol|com.ibm.oti.net.www.protocol|gnu.java.net.protocol|wonka.net|com.acunia.wonka.net|org.apache.harmony.luni.internal.net.www.protocol|weblogic.utils|weblogic.net|javax.net.ssl|COM.newmonics.www.protocols";

    private static Object m_rootURLHandlers;

    private static final String m_streamPkgs;

    private static final Map m_builtIn = new HashMap();

    private static final boolean m_loaded;

    static {
        String pkgs = CallChecker.init(String.class);
        if (CallChecker.beforeDeref(new SecureAction(), SecureAction.class, 110, 4995, 5012)) {
            pkgs = CallChecker.isCalled(new SecureAction(), SecureAction.class, 110, 4995, 5012).getSystemProperty(URLHandlers.STREAM_HANDLER_PACKAGE_PROP, "");
            CallChecker.varAssign(pkgs, "pkgs", 110, 4995, 5012);
        }
        pkgs = CallChecker.beforeCalled(pkgs, String.class, 111, 5090, 5093);
        if (CallChecker.isCalled(pkgs, String.class, 111, 5090, 5093).equals("")) {
            m_streamPkgs = URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE;
            CallChecker.varAssign(m_streamPkgs, "URLHandlers.m_streamPkgs", 111, 5074, 5209);
        }else {
            m_streamPkgs = (pkgs + "|") + (URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE);
            CallChecker.varAssign(m_streamPkgs, "URLHandlers.m_streamPkgs", 111, 5074, 5209);
        }
        m_loaded = ((null != (URLHandlersStreamHandlerProxy.class)) && (null != (URLHandlersContentHandlerProxy.class))) && (null != (URLStreamHandlerService.class));
        CallChecker.varAssign(m_loaded, "URLHandlers.m_loaded", 114, 5219, 5380);
    }

    private static final Map m_handlerToURL = new HashMap();

    private void init(String protocol, URLStreamHandlerFactory factory) {
        MethodContext _bcornu_methode_context346 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 120, 5455, 5950);
            CallChecker.varInit(factory, "factory", 120, 5455, 5950);
            CallChecker.varInit(protocol, "protocol", 120, 5455, 5950);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 120, 5455, 5950);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 120, 5455, 5950);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 120, 5455, 5950);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 120, 5455, 5950);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 120, 5455, 5950);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 120, 5455, 5950);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 120, 5455, 5950);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 120, 5455, 5950);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 120, 5455, 5950);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 120, 5455, 5950);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 120, 5455, 5950);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 120, 5455, 5950);
            TryContext _bcornu_try_context_100 = new TryContext(100, URLHandlers.class, "java.lang.Throwable");
            try {
                URLStreamHandler handler = CallChecker.varInit(getBuiltInStreamHandler(protocol, factory), "handler", 124, 5563, 5632);
                if (handler != null) {
                    URL url = CallChecker.varInit(new URL(protocol, null, (-1), "", handler), "url", 127, 5697, 5747);
                    if (CallChecker.beforeDeref(URLHandlers.m_handlerToURL, Map.class, 128, 5765, 5778)) {
                        CallChecker.isCalled(URLHandlers.m_handlerToURL, Map.class, 128, 5765, 5778).put(handler, url);
                    }
                }
            } catch (Throwable ex) {
                _bcornu_try_context_100.catchStart(100);
            } finally {
                _bcornu_try_context_100.finallyStart(100);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context346.methodEnd();
        }
    }

    private URLHandlers() {
        MethodContext _bcornu_methode_context24 = new MethodContext(null);
        try {
            URLHandlers.m_sm = new SecurityManagerEx();
            CallChecker.varAssign(URLHandlers.m_sm, "URLHandlers.m_sm", 147, 6311, 6341);
            synchronized(URL.class) {
                URLStreamHandlerFactory currentFactory = CallChecker.varInit(null, "currentFactory", 150, 6398, 6443);
                TryContext _bcornu_try_context_101 = new TryContext(101, URLHandlers.class, "java.lang.Throwable");
                try {
                    if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 153, 6534, 6547)) {
                        currentFactory = ((URLStreamHandlerFactory) (CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 153, 6534, 6547).swapStaticFieldIfNotClass(URL.class, URLStreamHandlerFactory.class, URLHandlers.URLHANDLERS_CLASS, "streamHandlerLock")));
                        CallChecker.varAssign(currentFactory, "currentFactory", 153, 6491, 6676);
                    }
                } catch (Throwable ex) {
                    _bcornu_try_context_101.catchStart(101);
                } finally {
                    _bcornu_try_context_101.finallyStart(101);
                }
                init("file", currentFactory);
                init("ftp", currentFactory);
                init("http", currentFactory);
                init("https", currentFactory);
                TryContext _bcornu_try_context_102 = new TryContext(102, URLHandlers.class, "java.lang.Throwable");
                try {
                    getBuiltInStreamHandler("jar", currentFactory);
                } catch (Throwable ex) {
                    _bcornu_try_context_102.catchStart(102);
                } finally {
                    _bcornu_try_context_102.finallyStart(102);
                }
                if (currentFactory != null) {
                    TryContext _bcornu_try_context_103 = new TryContext(103, URLHandlers.class, "java.lang.Throwable");
                    try {
                        URL.setURLStreamHandlerFactory(currentFactory);
                    } catch (Throwable ex) {
                        _bcornu_try_context_103.catchStart(103);
                    } finally {
                        _bcornu_try_context_103.finallyStart(103);
                    }
                }
                TryContext _bcornu_try_context_107 = new TryContext(107, URLHandlers.class, "java.lang.Error");
                try {
                    URL.setURLStreamHandlerFactory(this);
                    URLHandlers.m_streamHandlerFactory = this;
                    CallChecker.varAssign(URLHandlers.m_streamHandlerFactory, "URLHandlers.m_streamHandlerFactory", 189, 7693, 7722);
                    URLHandlers.m_rootURLHandlers = this;
                    CallChecker.varAssign(URLHandlers.m_rootURLHandlers, "URLHandlers.m_rootURLHandlers", 190, 7740, 7764);
                    TryContext _bcornu_try_context_104 = new TryContext(104, URLHandlers.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 194, 7903, 7916)) {
                            CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 194, 7903, 7916).flush(URL.class, URL.class);
                        }
                    } catch (Throwable t) {
                        _bcornu_try_context_104.catchStart(104);
                    } finally {
                        _bcornu_try_context_104.finallyStart(104);
                    }
                } catch (Error err) {
                    _bcornu_try_context_107.catchStart(107);
                    TryContext _bcornu_try_context_106 = new TryContext(106, URLHandlers.class, "java.lang.Exception");
                    try {
                        if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 207, 8353, 8366)) {
                            URLHandlers.m_streamHandlerFactory = ((URLStreamHandlerFactory) (CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 207, 8353, 8366).swapStaticFieldIfNotClass(URL.class, URLStreamHandlerFactory.class, URLHandlers.URLHANDLERS_CLASS, "streamHandlerLock")));
                            CallChecker.varAssign(URLHandlers.m_streamHandlerFactory, "URLHandlers.m_streamHandlerFactory", 206, 8278, 8499);
                        }
                        if ((URLHandlers.m_streamHandlerFactory) == null) {
                            throw err;
                        }
                        URLHandlers.m_streamHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 214, 8662, 8683);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 214, 8662, 8683).getClass(), Class.class, 214, 8662, 8694)) {
                            if (CallChecker.beforeDeref(URLHandlers.URLHANDLERS_CLASS, Class.class, 214, 8713, 8729)) {
                                URLHandlers.m_streamHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 214, 8662, 8683);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 214, 8662, 8683).getClass(), Class.class, 214, 8662, 8694).getName(), String.class, 214, 8662, 8704)) {
                                    if (!(CallChecker.isCalled(CallChecker.isCalled(URLHandlers.m_streamHandlerFactory.getClass(), Class.class, 214, 8662, 8694).getName(), String.class, 214, 8662, 8704).equals(CallChecker.isCalled(URLHandlers.URLHANDLERS_CLASS, Class.class, 214, 8713, 8729).getName()))) {
                                        URL.setURLStreamHandlerFactory(this);
                                        URLHandlers.m_rootURLHandlers = this;
                                        CallChecker.varAssign(URLHandlers.m_rootURLHandlers, "URLHandlers.m_rootURLHandlers", 217, 8851, 8875);
                                    }else
                                        if ((URLHandlers.URLHANDLERS_CLASS) != (URLHandlers.m_streamHandlerFactory.getClass())) {
                                            TryContext _bcornu_try_context_105 = new TryContext(105, URLHandlers.class, "java.lang.Exception");
                                            try {
                                                if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 224, 9143, 9156)) {
                                                    if (CallChecker.beforeDeref(URLHandlers.URLHANDLERS_CLASS, Class.class, 227, 9432, 9448)) {
                                                        if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 223, 9088, 9101)) {
                                                            CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 223, 9088, 9101).invoke(CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 224, 9143, 9156).getDeclaredMethod(URLHandlers.m_streamHandlerFactory.getClass(), "registerFrameworkListsForContextSearch", new Class[]{ ClassLoader.class , List.class }), URLHandlers.m_streamHandlerFactory, new Object[]{ CallChecker.isCalled(URLHandlers.URLHANDLERS_CLASS, Class.class, 227, 9432, 9448).getClassLoader() , URLHandlers.m_frameworks });
                                                        }
                                                    }
                                                }
                                                URLHandlers.m_rootURLHandlers = URLHandlers.m_streamHandlerFactory;
                                                CallChecker.varAssign(URLHandlers.m_rootURLHandlers, "URLHandlers.m_rootURLHandlers", 229, 9549, 9591);
                                            } catch (Exception ex) {
                                                _bcornu_try_context_105.catchStart(105);
                                                throw new RuntimeException(ex.getMessage());
                                            } finally {
                                                _bcornu_try_context_105.finallyStart(105);
                                            }
                                        }
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (Exception e) {
                        _bcornu_try_context_106.catchStart(106);
                        throw err;
                    } finally {
                        _bcornu_try_context_106.finallyStart(106);
                    }
                } finally {
                    _bcornu_try_context_107.finallyStart(107);
                }
                TryContext _bcornu_try_context_110 = new TryContext(110, URLHandlers.class, "java.lang.Error");
                try {
                    URLConnection.setContentHandlerFactory(this);
                    URLHandlers.m_contentHandlerFactory = this;
                    CallChecker.varAssign(URLHandlers.m_contentHandlerFactory, "URLHandlers.m_contentHandlerFactory", 246, 10055, 10085);
                    TryContext _bcornu_try_context_108 = new TryContext(108, URLHandlers.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 250, 10224, 10237)) {
                            CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 250, 10224, 10237).flush(URLConnection.class, URLConnection.class);
                        }
                    } catch (Throwable t) {
                        _bcornu_try_context_108.catchStart(108);
                    } finally {
                        _bcornu_try_context_108.finallyStart(108);
                    }
                } catch (Error err) {
                    _bcornu_try_context_110.catchStart(110);
                    TryContext _bcornu_try_context_109 = new TryContext(109, URLHandlers.class, "java.lang.Exception");
                    try {
                        if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 263, 10689, 10702)) {
                            URLHandlers.m_contentHandlerFactory = ((ContentHandlerFactory) (CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 263, 10689, 10702).swapStaticFieldIfNotClass(URLConnection.class, ContentHandlerFactory.class, URLHandlers.URLHANDLERS_CLASS, null)));
                            CallChecker.varAssign(URLHandlers.m_contentHandlerFactory, "URLHandlers.m_contentHandlerFactory", 262, 10615, 10861);
                        }
                        if ((URLHandlers.m_contentHandlerFactory) == null) {
                            throw err;
                        }
                        URLHandlers.m_contentHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_contentHandlerFactory, ContentHandlerFactory.class, 270, 11024, 11046);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlers.m_contentHandlerFactory, ContentHandlerFactory.class, 270, 11024, 11046).getClass(), Class.class, 270, 11024, 11057)) {
                            if (CallChecker.beforeDeref(URLHandlers.URLHANDLERS_CLASS, Class.class, 271, 11101, 11117)) {
                                URLHandlers.m_contentHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_contentHandlerFactory, ContentHandlerFactory.class, 270, 11024, 11046);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(URLHandlers.m_contentHandlerFactory, ContentHandlerFactory.class, 270, 11024, 11046).getClass(), Class.class, 270, 11024, 11057).getName(), String.class, 270, 11024, 11067)) {
                                    if (!(CallChecker.isCalled(CallChecker.isCalled(URLHandlers.m_contentHandlerFactory.getClass(), Class.class, 270, 11024, 11057).getName(), String.class, 270, 11024, 11067).equals(CallChecker.isCalled(URLHandlers.URLHANDLERS_CLASS, Class.class, 271, 11101, 11117).getName()))) {
                                        URLConnection.setContentHandlerFactory(this);
                                    }
                                }
                            }
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_109.catchStart(109);
                        throw err;
                    } finally {
                        _bcornu_try_context_109.finallyStart(109);
                    }
                } finally {
                    _bcornu_try_context_110.finallyStart(110);
                }
            }
            if (CallChecker.beforeDeref(URLHandlers.URLHANDLERS_CLASS, Class.class, 283, 11478, 11494)) {
                if (CallChecker.beforeDeref(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 284, 11526, 11547)) {
                    URLHandlers.m_streamHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 284, 11526, 11547);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 284, 11526, 11547).getClass(), Class.class, 284, 11526, 11558)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(URLHandlers.URLHANDLERS_CLASS, Class.class, 283, 11478, 11494).getName(), String.class, 283, 11478, 11504)) {
                            URLHandlers.m_streamHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 284, 11526, 11547);
                            if (!(((URLHandlers.m_streamHandlerFactory) == (this)) || (!(CallChecker.isCalled(CallChecker.isCalled(URLHandlers.URLHANDLERS_CLASS, Class.class, 283, 11478, 11494).getName(), String.class, 283, 11478, 11504).equals(CallChecker.isCalled(CallChecker.isCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 284, 11526, 11547).getClass(), Class.class, 284, 11526, 11558).getName()))))) {
                                URLHandlers.m_sm = null;
                                CallChecker.varAssign(URLHandlers.m_sm, "URLHandlers.m_sm", 286, 11595, 11606);
                                if (CallChecker.beforeDeref(URLHandlers.m_handlerToURL, Map.class, 287, 11620, 11633)) {
                                    CallChecker.isCalled(URLHandlers.m_handlerToURL, Map.class, 287, 11620, 11633).clear();
                                }
                                if (CallChecker.beforeDeref(URLHandlers.m_builtIn, Map.class, 288, 11656, 11664)) {
                                    CallChecker.isCalled(URLHandlers.m_builtIn, Map.class, 288, 11656, 11664).clear();
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    static void registerFrameworkListsForContextSearch(ClassLoader index, List frameworkLists) {
        MethodContext _bcornu_methode_context347 = new MethodContext(void.class);
        try {
            CallChecker.varInit(frameworkLists, "frameworkLists", 292, 11696, 12017);
            CallChecker.varInit(index, "index", 292, 11696, 12017);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 292, 11696, 12017);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 292, 11696, 12017);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 292, 11696, 12017);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 292, 11696, 12017);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 292, 11696, 12017);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 292, 11696, 12017);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 292, 11696, 12017);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 292, 11696, 12017);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 292, 11696, 12017);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 292, 11696, 12017);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 292, 11696, 12017);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 292, 11696, 12017);
            synchronized(URL.class) {
                synchronized(URLHandlers.m_classloaderToFrameworkLists) {
                    if (CallChecker.beforeDeref(URLHandlers.m_classloaderToFrameworkLists, Map.class, 299, 11931, 11959)) {
                        CallChecker.isCalled(URLHandlers.m_classloaderToFrameworkLists, Map.class, 299, 11931, 11959).put(index, frameworkLists);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context347.methodEnd();
        }
    }

    static void unregisterFrameworkListsForContextSearch(ClassLoader index) {
        MethodContext _bcornu_methode_context348 = new MethodContext(void.class);
        try {
            CallChecker.varInit(index, "index", 304, 12024, 14079);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 304, 12024, 14079);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 304, 12024, 14079);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 304, 12024, 14079);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 304, 12024, 14079);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 304, 12024, 14079);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 304, 12024, 14079);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 304, 12024, 14079);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 304, 12024, 14079);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 304, 12024, 14079);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 304, 12024, 14079);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 304, 12024, 14079);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 304, 12024, 14079);
            synchronized(URL.class) {
                synchronized(URLHandlers.m_classloaderToFrameworkLists) {
                    if (CallChecker.beforeDeref(URLHandlers.m_classloaderToFrameworkLists, Map.class, 310, 12232, 12260)) {
                        CallChecker.isCalled(URLHandlers.m_classloaderToFrameworkLists, Map.class, 310, 12232, 12260).remove(index);
                    }
                    if (CallChecker.beforeDeref(URLHandlers.m_classloaderToFrameworkLists, Map.class, 311, 12297, 12325)) {
                        if (CallChecker.isCalled(URLHandlers.m_classloaderToFrameworkLists, Map.class, 311, 12297, 12325).isEmpty()) {
                            synchronized(URLHandlers.m_frameworks) {
                                if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 315, 12455, 12466)) {
                                    if (CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 315, 12455, 12466).isEmpty()) {
                                        TryContext _bcornu_try_context_111 = new TryContext(111, URLHandlers.class, "java.lang.Exception");
                                        try {
                                            if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 319, 12599, 12612)) {
                                                CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 319, 12599, 12612).swapStaticFieldIfNotClass(URL.class, URLStreamHandlerFactory.class, null, "streamHandlerLock");
                                            }
                                        } catch (Exception ex) {
                                            _bcornu_try_context_111.catchStart(111);
                                            ex.printStackTrace();
                                        } finally {
                                            _bcornu_try_context_111.finallyStart(111);
                                        }
                                        if (CallChecker.beforeDeref(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 328, 13021, 13042)) {
                                            URLHandlers.m_streamHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 328, 13021, 13042);
                                            if ((CallChecker.isCalled(URLHandlers.m_streamHandlerFactory, URLStreamHandlerFactory.class, 328, 13021, 13042).getClass()) != (URLHandlers.URLHANDLERS_CLASS)) {
                                                URL.setURLStreamHandlerFactory(URLHandlers.m_streamHandlerFactory);
                                            }
                                        }
                                        TryContext _bcornu_try_context_112 = new TryContext(112, URLHandlers.class, "java.lang.Exception");
                                        try {
                                            if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 334, 13319, 13332)) {
                                                CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 334, 13319, 13332).swapStaticFieldIfNotClass(URLConnection.class, ContentHandlerFactory.class, null, null);
                                            }
                                        } catch (Exception ex) {
                                            _bcornu_try_context_112.catchStart(112);
                                            ex.printStackTrace();
                                        } finally {
                                            _bcornu_try_context_112.finallyStart(112);
                                        }
                                        if (CallChecker.beforeDeref(URLHandlers.m_contentHandlerFactory, ContentHandlerFactory.class, 344, 13771, 13793)) {
                                            URLHandlers.m_contentHandlerFactory = CallChecker.beforeCalled(URLHandlers.m_contentHandlerFactory, ContentHandlerFactory.class, 344, 13771, 13793);
                                            if ((CallChecker.isCalled(URLHandlers.m_contentHandlerFactory, ContentHandlerFactory.class, 344, 13771, 13793).getClass()) != (URLHandlers.URLHANDLERS_CLASS)) {
                                                URLConnection.setContentHandlerFactory(URLHandlers.m_contentHandlerFactory);
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
            _bcornu_methode_context348.methodEnd();
        }
    }

    private URLStreamHandler getBuiltInStreamHandler(String protocol, URLStreamHandlerFactory factory) {
        MethodContext _bcornu_methode_context349 = new MethodContext(URLStreamHandler.class);
        try {
            CallChecker.varInit(this, "this", 355, 14086, 15001);
            CallChecker.varInit(factory, "factory", 355, 14086, 15001);
            CallChecker.varInit(protocol, "protocol", 355, 14086, 15001);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 355, 14086, 15001);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 355, 14086, 15001);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 355, 14086, 15001);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 355, 14086, 15001);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 355, 14086, 15001);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 355, 14086, 15001);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 355, 14086, 15001);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 355, 14086, 15001);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 355, 14086, 15001);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 355, 14086, 15001);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 355, 14086, 15001);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 355, 14086, 15001);
            synchronized(URLHandlers.m_builtIn) {
                if (CallChecker.beforeDeref(URLHandlers.m_builtIn, Map.class, 359, 14250, 14258)) {
                    if (CallChecker.isCalled(URLHandlers.m_builtIn, Map.class, 359, 14250, 14258).containsKey(protocol)) {
                        if (CallChecker.beforeDeref(URLHandlers.m_builtIn, Map.class, 361, 14339, 14347)) {
                            return ((URLStreamHandler) (CallChecker.isCalled(URLHandlers.m_builtIn, Map.class, 361, 14339, 14347).get(protocol)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (factory != null) {
                URLStreamHandler result = CallChecker.varInit(factory.createURLStreamHandler(protocol), "result", 366, 14439, 14505);
                if (result != null) {
                    return addToCache(protocol, result);
                }
            }
            URLStreamHandler handler = CallChecker.varInit(loadBuiltInStreamHandler(protocol, null), "handler", 374, 14739, 14806);
            if (handler == null) {
                handler = loadBuiltInStreamHandler(protocol, ClassLoader.getSystemClassLoader());
                CallChecker.varAssign(handler, "handler", 377, 14859, 14939);
            }
            return addToCache(protocol, handler);
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLStreamHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context349.methodEnd();
        }
    }

    private URLStreamHandler loadBuiltInStreamHandler(String protocol, ClassLoader classLoader) {
        MethodContext _bcornu_methode_context350 = new MethodContext(URLStreamHandler.class);
        try {
            CallChecker.varInit(this, "this", 382, 15008, 17469);
            CallChecker.varInit(classLoader, "classLoader", 382, 15008, 17469);
            CallChecker.varInit(protocol, "protocol", 382, 15008, 17469);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 382, 15008, 17469);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 382, 15008, 17469);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 382, 15008, 17469);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 382, 15008, 17469);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 382, 15008, 17469);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 382, 15008, 17469);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 382, 15008, 17469);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 382, 15008, 17469);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 382, 15008, 17469);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 382, 15008, 17469);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 382, 15008, 17469);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 382, 15008, 17469);
            StringTokenizer pkgTok = CallChecker.varInit(new StringTokenizer(URLHandlers.m_streamPkgs, "| "), "pkgTok", 383, 15110, 15174);
            pkgTok = CallChecker.beforeCalled(pkgTok, StringTokenizer.class, 384, 15191, 15196);
            while (CallChecker.isCalled(pkgTok, StringTokenizer.class, 384, 15191, 15196).hasMoreTokens()) {
                String pkg = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(pkgTok, StringTokenizer.class, 386, 15250, 15255)) {
                    pkgTok = CallChecker.beforeCalled(pkgTok, StringTokenizer.class, 386, 15250, 15255);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(pkgTok, StringTokenizer.class, 386, 15250, 15255).nextToken(), String.class, 386, 15250, 15267)) {
                        pkgTok = CallChecker.beforeCalled(pkgTok, StringTokenizer.class, 386, 15250, 15255);
                        pkg = CallChecker.isCalled(CallChecker.isCalled(pkgTok, StringTokenizer.class, 386, 15250, 15255).nextToken(), String.class, 386, 15250, 15267).trim();
                        CallChecker.varAssign(pkg, "pkg", 386, 15250, 15255);
                    }
                }
                String className = CallChecker.varInit((((pkg + ".") + protocol) + ".Handler"), "className", 387, 15289, 15341);
                TryContext _bcornu_try_context_113 = new TryContext(113, URLHandlers.class, "java.lang.Throwable");
                try {
                    Class handler = CallChecker.init(Class.class);
                    if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 391, 15480, 15493)) {
                        handler = CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 391, 15480, 15493).forName(className, classLoader);
                        CallChecker.varAssign(handler, "handler", 391, 15480, 15493);
                    }
                    if (handler != null) {
                        return ((URLStreamHandler) (handler.newInstance()));
                    }
                } catch (Throwable ex) {
                    _bcornu_try_context_113.catchStart(113);
                } finally {
                    _bcornu_try_context_113.finallyStart(113);
                }
            } 
            String androidHandler = CallChecker.varInit(null, "androidHandler", 406, 16110, 16138);
            if (CallChecker.beforeDeref("file", String.class, 407, 16152, 16157)) {
                if (CallChecker.isCalled("file", String.class, 407, 16152, 16157).equalsIgnoreCase(protocol)) {
                    androidHandler = "libcore.net.url.FileHandler";
                    CallChecker.varAssign(androidHandler, "androidHandler", 409, 16209, 16255);
                }else
                    if (CallChecker.beforeDeref("ftp", String.class, 411, 16284, 16288)) {
                        if (CallChecker.isCalled("ftp", String.class, 411, 16284, 16288).equalsIgnoreCase(protocol)) {
                            androidHandler = "libcore.net.url.FtpHandler";
                            CallChecker.varAssign(androidHandler, "androidHandler", 413, 16340, 16385);
                        }else
                            if (CallChecker.beforeDeref("http", String.class, 415, 16414, 16419)) {
                                if (CallChecker.isCalled("http", String.class, 415, 16414, 16419).equalsIgnoreCase(protocol)) {
                                    androidHandler = "libcore.net.http.HttpHandler";
                                    CallChecker.varAssign(androidHandler, "androidHandler", 417, 16471, 16518);
                                }else
                                    if (CallChecker.beforeDeref("https", String.class, 419, 16547, 16553)) {
                                        if (CallChecker.isCalled("https", String.class, 419, 16547, 16553).equalsIgnoreCase(protocol)) {
                                            androidHandler = "libcore.net.http.HttpsHandler";
                                            CallChecker.varAssign(androidHandler, "androidHandler", 421, 16605, 16653);
                                        }else
                                            if (CallChecker.beforeDeref("jar", String.class, 423, 16682, 16686)) {
                                                if (CallChecker.isCalled("jar", String.class, 423, 16682, 16686).equalsIgnoreCase(protocol)) {
                                                    androidHandler = "libcore.net.url.JarHandler";
                                                    CallChecker.varAssign(androidHandler, "androidHandler", 425, 16738, 16783);
                                                }
                                            }
                                        
                                    }
                                
                            }
                        
                    }
                
            }
            if (androidHandler != null) {
                TryContext _bcornu_try_context_114 = new TryContext(114, URLHandlers.class, "java.lang.Throwable");
                try {
                    Class handler = CallChecker.init(Class.class);
                    if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 432, 16978, 16991)) {
                        handler = CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 432, 16978, 16991).forName(androidHandler, classLoader);
                        CallChecker.varAssign(handler, "handler", 432, 16978, 16991);
                    }
                    if (handler != null) {
                        return ((URLStreamHandler) (handler.newInstance()));
                    }
                } catch (Throwable ex) {
                    _bcornu_try_context_114.catchStart(114);
                } finally {
                    _bcornu_try_context_114.finallyStart(114);
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLStreamHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context350.methodEnd();
        }
    }

    private synchronized URLStreamHandler addToCache(String protocol, URLStreamHandler result) {
        MethodContext _bcornu_methode_context351 = new MethodContext(URLStreamHandler.class);
        try {
            CallChecker.varInit(this, "this", 448, 17476, 17790);
            CallChecker.varInit(result, "result", 448, 17476, 17790);
            CallChecker.varInit(protocol, "protocol", 448, 17476, 17790);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 448, 17476, 17790);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 448, 17476, 17790);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 448, 17476, 17790);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 448, 17476, 17790);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 448, 17476, 17790);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 448, 17476, 17790);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 448, 17476, 17790);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 448, 17476, 17790);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 448, 17476, 17790);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 448, 17476, 17790);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 448, 17476, 17790);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 448, 17476, 17790);
            if (CallChecker.beforeDeref(URLHandlers.m_builtIn, Map.class, 450, 17586, 17594)) {
                if (!(CallChecker.isCalled(URLHandlers.m_builtIn, Map.class, 450, 17586, 17594).containsKey(protocol))) {
                    if (CallChecker.beforeDeref(URLHandlers.m_builtIn, Map.class, 452, 17649, 17657)) {
                        CallChecker.isCalled(URLHandlers.m_builtIn, Map.class, 452, 17649, 17657).put(protocol, result);
                    }
                    return result;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(URLHandlers.m_builtIn, Map.class, 455, 17761, 17769)) {
                return ((URLStreamHandler) (CallChecker.isCalled(URLHandlers.m_builtIn, Map.class, 455, 17761, 17769).get(protocol)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLStreamHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context351.methodEnd();
        }
    }

    public URLStreamHandler createURLStreamHandler(String protocol) {
        MethodContext _bcornu_methode_context352 = new MethodContext(URLStreamHandler.class);
        try {
            CallChecker.varInit(this, "this", 468, 17797, 19650);
            CallChecker.varInit(protocol, "protocol", 468, 17797, 19650);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 468, 17797, 19650);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 468, 17797, 19650);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 468, 17797, 19650);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 468, 17797, 19650);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 468, 17797, 19650);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 468, 17797, 19650);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 468, 17797, 19650);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 468, 17797, 19650);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 468, 17797, 19650);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 468, 17797, 19650);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 468, 17797, 19650);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 468, 17797, 19650);
            URLStreamHandler handler = CallChecker.varInit(getFromStreamCache(protocol), "handler", 476, 18761, 18816);
            if (handler != null) {
                return handler;
            }
            if (CallChecker.beforeDeref(protocol, String.class, 485, 19082, 19089)) {
                protocol = CallChecker.beforeCalled(protocol, String.class, 485, 19082, 19089);
                if (CallChecker.isCalled(protocol, String.class, 485, 19082, 19089).equals(FelixConstants.BUNDLE_URL_PROTOCOL)) {
                    return addToStreamCache(protocol, new URLHandlersBundleStreamHandler(URLHandlers.m_secureAction));
                }
            }else
                throw new AbnormalExecutionError();
            
            handler = getBuiltInStreamHandler(protocol, ((URLHandlers.m_streamHandlerFactory) != (this) ? URLHandlers.m_streamHandlerFactory : null));
            CallChecker.varAssign(handler, "handler", 491, 19278, 19398);
            if (CallChecker.beforeDeref(URLHandlers.m_handlerToURL, Map.class, 497, 19615, 19628)) {
                return addToStreamCache(protocol, new URLHandlersStreamHandlerProxy(protocol, URLHandlers.m_secureAction, handler, ((URL) (CallChecker.isCalled(URLHandlers.m_handlerToURL, Map.class, 497, 19615, 19628).get(handler)))));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLStreamHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context352.methodEnd();
        }
    }

    public ContentHandler createContentHandler(String mimeType) {
        MethodContext _bcornu_methode_context353 = new MethodContext(ContentHandler.class);
        try {
            CallChecker.varInit(this, "this", 510, 19657, 20962);
            CallChecker.varInit(mimeType, "mimeType", 510, 19657, 20962);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 510, 19657, 20962);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 510, 19657, 20962);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 510, 19657, 20962);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 510, 19657, 20962);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 510, 19657, 20962);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 510, 19657, 20962);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 510, 19657, 20962);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 510, 19657, 20962);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 510, 19657, 20962);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 510, 19657, 20962);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 510, 19657, 20962);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 510, 19657, 20962);
            ContentHandler handler = CallChecker.varInit(getFromContentCache(mimeType), "handler", 518, 20625, 20679);
            if (handler != null) {
                return handler;
            }
            return addToContentCache(mimeType, new URLHandlersContentHandlerProxy(mimeType, URLHandlers.m_secureAction, ((URLHandlers.m_contentHandlerFactory) != (this) ? URLHandlers.m_contentHandlerFactory : null)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ContentHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context353.methodEnd();
        }
    }

    private synchronized ContentHandler addToContentCache(String mimeType, ContentHandler handler) {
        MethodContext _bcornu_methode_context354 = new MethodContext(ContentHandler.class);
        try {
            CallChecker.varInit(this, "this", 530, 20969, 21274);
            CallChecker.varInit(handler, "handler", 530, 20969, 21274);
            CallChecker.varInit(mimeType, "mimeType", 530, 20969, 21274);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 530, 20969, 21274);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 530, 20969, 21274);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 530, 20969, 21274);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 530, 20969, 21274);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 530, 20969, 21274);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 530, 20969, 21274);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 530, 20969, 21274);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 530, 20969, 21274);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 530, 20969, 21274);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 530, 20969, 21274);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 530, 20969, 21274);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 530, 20969, 21274);
            if ((URLHandlers.m_contentHandlerCache) == null) {
                URLHandlers.m_contentHandlerCache = new HashMap();
                CallChecker.varAssign(URLHandlers.m_contentHandlerCache, "URLHandlers.m_contentHandlerCache", 534, 21135, 21172);
            }
            return ((ContentHandler) (addToCache(URLHandlers.m_contentHandlerCache, mimeType, handler)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ContentHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context354.methodEnd();
        }
    }

    private synchronized ContentHandler getFromContentCache(String mimeType) {
        MethodContext _bcornu_methode_context355 = new MethodContext(ContentHandler.class);
        try {
            CallChecker.varInit(this, "this", 539, 21281, 21488);
            CallChecker.varInit(mimeType, "mimeType", 539, 21281, 21488);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 539, 21281, 21488);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 539, 21281, 21488);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 539, 21281, 21488);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 539, 21281, 21488);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 539, 21281, 21488);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 539, 21281, 21488);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 539, 21281, 21488);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 539, 21281, 21488);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 539, 21281, 21488);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 539, 21281, 21488);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 539, 21281, 21488);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 539, 21281, 21488);
            if ((URLHandlers.m_contentHandlerCache) != null) {
                return ((ContentHandler) (URLHandlers.m_contentHandlerCache.get(mimeType)));
            }else {
                return ((ContentHandler) (null));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ContentHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context355.methodEnd();
        }
    }

    private synchronized URLStreamHandler addToStreamCache(String protocol, URLStreamHandler handler) {
        MethodContext _bcornu_methode_context356 = new MethodContext(URLStreamHandler.class);
        try {
            CallChecker.varInit(this, "this", 545, 21495, 21802);
            CallChecker.varInit(handler, "handler", 545, 21495, 21802);
            CallChecker.varInit(protocol, "protocol", 545, 21495, 21802);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 545, 21495, 21802);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 545, 21495, 21802);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 545, 21495, 21802);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 545, 21495, 21802);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 545, 21495, 21802);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 545, 21495, 21802);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 545, 21495, 21802);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 545, 21495, 21802);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 545, 21495, 21802);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 545, 21495, 21802);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 545, 21495, 21802);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 545, 21495, 21802);
            if ((URLHandlers.m_streamHandlerCache) == null) {
                URLHandlers.m_streamHandlerCache = new HashMap();
                CallChecker.varAssign(URLHandlers.m_streamHandlerCache, "URLHandlers.m_streamHandlerCache", 549, 21663, 21699);
            }
            return ((URLStreamHandler) (addToCache(URLHandlers.m_streamHandlerCache, protocol, handler)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLStreamHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context356.methodEnd();
        }
    }

    private synchronized URLStreamHandler getFromStreamCache(String protocol) {
        MethodContext _bcornu_methode_context357 = new MethodContext(URLStreamHandler.class);
        try {
            CallChecker.varInit(this, "this", 554, 21809, 22017);
            CallChecker.varInit(protocol, "protocol", 554, 21809, 22017);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 554, 21809, 22017);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 554, 21809, 22017);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 554, 21809, 22017);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 554, 21809, 22017);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 554, 21809, 22017);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 554, 21809, 22017);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 554, 21809, 22017);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 554, 21809, 22017);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 554, 21809, 22017);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 554, 21809, 22017);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 554, 21809, 22017);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 554, 21809, 22017);
            if ((URLHandlers.m_streamHandlerCache) != null) {
                return ((URLStreamHandler) (URLHandlers.m_streamHandlerCache.get(protocol)));
            }else {
                return ((URLStreamHandler) (null));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLStreamHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context357.methodEnd();
        }
    }

    private Object addToCache(Map cache, String key, Object value) {
        MethodContext _bcornu_methode_context358 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 560, 22024, 22345);
            CallChecker.varInit(value, "value", 560, 22024, 22345);
            CallChecker.varInit(key, "key", 560, 22024, 22345);
            CallChecker.varInit(cache, "cache", 560, 22024, 22345);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 560, 22024, 22345);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 560, 22024, 22345);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 560, 22024, 22345);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 560, 22024, 22345);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 560, 22024, 22345);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 560, 22024, 22345);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 560, 22024, 22345);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 560, 22024, 22345);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 560, 22024, 22345);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 560, 22024, 22345);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 560, 22024, 22345);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 560, 22024, 22345);
            if (value == null) {
                return null;
            }
            Object result = CallChecker.init(Object.class);
            if (CallChecker.beforeDeref(cache, Map.class, 567, 22190, 22194)) {
                cache = CallChecker.beforeCalled(cache, Map.class, 567, 22190, 22194);
                result = CallChecker.isCalled(cache, Map.class, 567, 22190, 22194).get(key);
                CallChecker.varAssign(result, "result", 567, 22190, 22194);
            }
            if (result == null) {
                if (CallChecker.beforeDeref(cache, Map.class, 571, 22257, 22261)) {
                    cache = CallChecker.beforeCalled(cache, Map.class, 571, 22257, 22261);
                    CallChecker.isCalled(cache, Map.class, 571, 22257, 22261).put(key, value);
                }
                result = value;
                CallChecker.varAssign(result, "result", 572, 22292, 22306);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context358.methodEnd();
        }
    }

    public static void registerFrameworkInstance(Object framework, boolean enable) {
        MethodContext _bcornu_methode_context359 = new MethodContext(void.class);
        try {
            CallChecker.varInit(enable, "enable", 587, 22352, 24098);
            CallChecker.varInit(framework, "framework", 587, 22352, 24098);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 587, 22352, 24098);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 587, 22352, 24098);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 587, 22352, 24098);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 587, 22352, 24098);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 587, 22352, 24098);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 587, 22352, 24098);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 587, 22352, 24098);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 587, 22352, 24098);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 587, 22352, 24098);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 587, 22352, 24098);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 587, 22352, 24098);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 587, 22352, 24098);
            boolean register = CallChecker.varInit(((boolean) (false)), "register", 589, 22804, 22828);
            synchronized(URLHandlers.m_frameworks) {
                if (enable) {
                    if ((URLHandlers.m_handler) == null) {
                        register = true;
                        CallChecker.varAssign(register, "register", 601, 23277, 23292);
                    }else {
                        if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 605, 23371, 23382)) {
                            CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 605, 23371, 23382).add(framework);
                        }
                        (URLHandlers.m_counter)++;
                    }
                }else {
                    (URLHandlers.m_counter)++;
                }
            }
            if (register) {
                synchronized(URL.class) {
                    synchronized(URLHandlers.m_classloaderToFrameworkLists) {
                        synchronized(URLHandlers.m_frameworks) {
                            if ((URLHandlers.m_handler) == null) {
                                URLHandlers.m_handler = new URLHandlers();
                                CallChecker.varAssign(URLHandlers.m_handler, "URLHandlers.m_handler", 624, 23883, 23912);
                            }
                            if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 626, 23964, 23975)) {
                                CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 626, 23964, 23975).add(framework);
                            }
                            (URLHandlers.m_counter)++;
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context359.methodEnd();
        }
    }

    public static void unregisterFrameworkInstance(Object framework) {
        MethodContext _bcornu_methode_context360 = new MethodContext(void.class);
        try {
            CallChecker.varInit(framework, "framework", 642, 24105, 26273);
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 642, 24105, 26273);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 642, 24105, 26273);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 642, 24105, 26273);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 642, 24105, 26273);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 642, 24105, 26273);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 642, 24105, 26273);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 642, 24105, 26273);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 642, 24105, 26273);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 642, 24105, 26273);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 642, 24105, 26273);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 642, 24105, 26273);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 642, 24105, 26273);
            boolean unregister = CallChecker.varInit(((boolean) (false)), "unregister", 644, 24428, 24454);
            synchronized(URLHandlers.m_frameworks) {
                if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 647, 24518, 24529)) {
                    if (CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 647, 24518, 24529).contains(framework)) {
                        if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 649, 24586, 24597)) {
                            if (((CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 649, 24586, 24597).size()) == 1) && ((URLHandlers.m_handler) != null)) {
                                unregister = true;
                                CallChecker.varAssign(unregister, "unregister", 651, 24671, 24688);
                            }else {
                                if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 655, 24767, 24778)) {
                                    CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 655, 24767, 24778).remove(framework);
                                }
                                (URLHandlers.m_counter)--;
                            }
                        }
                    }else {
                        (URLHandlers.m_counter)--;
                    }
                }
            }
            if (unregister) {
                synchronized(URL.class) {
                    synchronized(URLHandlers.m_classloaderToFrameworkLists) {
                        synchronized(URLHandlers.m_frameworks) {
                            if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 672, 25206, 25217)) {
                                CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 672, 25206, 25217).remove(framework);
                            }
                            (URLHandlers.m_counter)--;
                            if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 674, 25303, 25314)) {
                                if ((CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 674, 25303, 25314).isEmpty()) && ((URLHandlers.m_handler) != null)) {
                                    URLHandlers.m_handler = null;
                                    CallChecker.varAssign(URLHandlers.m_handler, "URLHandlers.m_handler", 677, 25403, 25419);
                                    TryContext _bcornu_try_context_115 = new TryContext(115, URLHandlers.class, "java.lang.Exception");
                                    try {
                                        if (CallChecker.beforeDeref(URLHandlers.m_rootURLHandlers, Object.class, 681, 25607, 25623)) {
                                            if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 680, 25537, 25550)) {
                                                if (CallChecker.beforeDeref(URLHandlers.URLHANDLERS_CLASS, Class.class, 685, 25892, 25908)) {
                                                    if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 680, 25515, 25528)) {
                                                        URLHandlers.m_rootURLHandlers = CallChecker.beforeCalled(URLHandlers.m_rootURLHandlers, Object.class, 681, 25607, 25623);
                                                        CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 680, 25515, 25528).invoke(CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 680, 25537, 25550).getDeclaredMethod(CallChecker.isCalled(URLHandlers.m_rootURLHandlers, Object.class, 681, 25607, 25623).getClass(), "unregisterFrameworkListsForContextSearch", new Class[]{ ClassLoader.class }), URLHandlers.m_rootURLHandlers, new Object[]{ CallChecker.isCalled(URLHandlers.URLHANDLERS_CLASS, Class.class, 685, 25892, 25908).getClassLoader() });
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        _bcornu_try_context_115.catchStart(115);
                                        e.printStackTrace();
                                    } finally {
                                        _bcornu_try_context_115.finallyStart(115);
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
            _bcornu_methode_context360.methodEnd();
        }
    }

    public static Object getFrameworkFromContext() {
        MethodContext _bcornu_methode_context361 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(m_handlerToURL, "org.apache.felix.framework.URLHandlers.m_handlerToURL", 710, 26280, 30196);
            CallChecker.varInit(m_loaded, "org.apache.felix.framework.URLHandlers.m_loaded", 710, 26280, 30196);
            CallChecker.varInit(m_builtIn, "org.apache.felix.framework.URLHandlers.m_builtIn", 710, 26280, 30196);
            CallChecker.varInit(m_streamPkgs, "org.apache.felix.framework.URLHandlers.m_streamPkgs", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_rootURLHandlers, "org.apache.felix.framework.URLHandlers.m_rootURLHandlers", 710, 26280, 30196);
            CallChecker.varInit(DEFAULT_STREAM_HANDLER_PACKAGE, "org.apache.felix.framework.URLHandlers.DEFAULT_STREAM_HANDLER_PACKAGE", 710, 26280, 30196);
            CallChecker.varInit(STREAM_HANDLER_PACKAGE_PROP, "org.apache.felix.framework.URLHandlers.STREAM_HANDLER_PACKAGE_PROP", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_contentHandlerFactory, "org.apache.felix.framework.URLHandlers.m_contentHandlerFactory", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_streamHandlerFactory, "org.apache.felix.framework.URLHandlers.m_streamHandlerFactory", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_streamHandlerCache, "org.apache.felix.framework.URLHandlers.m_streamHandlerCache", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_contentHandlerCache, "org.apache.felix.framework.URLHandlers.m_contentHandlerCache", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_counter, "org.apache.felix.framework.URLHandlers.m_counter", 710, 26280, 30196);
            CallChecker.varInit(m_frameworks, "org.apache.felix.framework.URLHandlers.m_frameworks", 710, 26280, 30196);
            CallChecker.varInit(m_classloaderToFrameworkLists, "org.apache.felix.framework.URLHandlers.m_classloaderToFrameworkLists", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_handler, "org.apache.felix.framework.URLHandlers.m_handler", 710, 26280, 30196);
            CallChecker.varInit(URLHandlers.m_sm, "org.apache.felix.framework.URLHandlers.m_sm", 710, 26280, 30196);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.URLHandlers.m_secureAction", 710, 26280, 30196);
            CallChecker.varInit(URLHANDLERS_CLASS, "org.apache.felix.framework.URLHandlers.URLHANDLERS_CLASS", 710, 26280, 30196);
            CallChecker.varInit(CLASS_TYPE, "org.apache.felix.framework.URLHandlers.CLASS_TYPE", 710, 26280, 30196);
            synchronized(URLHandlers.m_classloaderToFrameworkLists) {
                if (CallChecker.beforeDeref(URLHandlers.m_classloaderToFrameworkLists, Map.class, 715, 27019, 27047)) {
                    if (CallChecker.isCalled(URLHandlers.m_classloaderToFrameworkLists, Map.class, 715, 27019, 27047).isEmpty()) {
                        synchronized(URLHandlers.m_frameworks) {
                            if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 719, 27181, 27192)) {
                                if (((URLHandlers.m_counter) == 1) && ((CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 719, 27181, 27192).size()) == 1)) {
                                    if (CallChecker.beforeDeref(URLHandlers.m_frameworks, List.class, 721, 27261, 27272)) {
                                        return CallChecker.isCalled(URLHandlers.m_frameworks, List.class, 721, 27261, 27272).get(0);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            Class[] stack = CallChecker.init(Class[].class);
            if (CallChecker.beforeDeref(URLHandlers.m_sm, SecurityManagerEx.class, 727, 27415, 27418)) {
                URLHandlers.m_sm = CallChecker.beforeCalled(URLHandlers.m_sm, SecurityManagerEx.class, 727, 27415, 27418);
                stack = CallChecker.isCalled(URLHandlers.m_sm, SecurityManagerEx.class, 727, 27415, 27418).getClassContext();
                CallChecker.varAssign(stack, "stack", 727, 27415, 27418);
            }
            Class targetClass = CallChecker.varInit(null, "targetClass", 729, 27509, 27533);
            stack = CallChecker.beforeCalled(stack, Class[].class, 730, 27563, 27567);
            for (int i = 0; i < (CallChecker.isCalled(stack, Class[].class, 730, 27563, 27567).length); i++) {
                if (CallChecker.beforeDeref(stack, Class[].class, 732, 27608, 27612)) {
                    stack = CallChecker.beforeCalled(stack, Class[].class, 732, 27608, 27612);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(stack, Class[].class, 732, 27608, 27612)[i], Class.class, 732, 27608, 27615)) {
                        stack = CallChecker.beforeCalled(stack, Class[].class, 732, 27608, 27612);
                        CallChecker.isCalled(stack, Class[].class, 732, 27608, 27612)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stack, Class[].class, 732, 27608, 27612)[i], Class.class, 732, 27608, 27615);
                        if ((CallChecker.isCalled(CallChecker.isCalled(stack, Class[].class, 732, 27608, 27612)[i], Class.class, 732, 27608, 27615).getClassLoader()) != null) {
                            String name = CallChecker.init(String.class);
                            if (CallChecker.beforeDeref(stack, Class[].class, 734, 27687, 27691)) {
                                stack = CallChecker.beforeCalled(stack, Class[].class, 734, 27687, 27691);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(stack, Class[].class, 734, 27687, 27691)[i], Class.class, 734, 27687, 27694)) {
                                    stack = CallChecker.beforeCalled(stack, Class[].class, 734, 27687, 27691);
                                    CallChecker.isCalled(stack, Class[].class, 734, 27687, 27691)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stack, Class[].class, 734, 27687, 27691)[i], Class.class, 734, 27687, 27694);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(stack, Class[].class, 734, 27687, 27691)[i], Class.class, 734, 27687, 27694).getClassLoader(), ClassLoader.class, 734, 27687, 27711).getClass(), Class.class, 734, 27687, 27722)) {
                                        stack = CallChecker.beforeCalled(stack, Class[].class, 734, 27687, 27691);
                                        CallChecker.isCalled(stack, Class[].class, 734, 27687, 27691)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stack, Class[].class, 734, 27687, 27691)[i], Class.class, 734, 27687, 27694);
                                        name = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(stack, Class[].class, 734, 27687, 27691)[i], Class.class, 734, 27687, 27694).getClassLoader().getClass(), Class.class, 734, 27687, 27722).getName();
                                        CallChecker.varAssign(name, "name", 734, 27687, 27691);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(name, String.class, 735, 27755, 27758)) {
                                if (CallChecker.beforeDeref(name, String.class, 736, 27853, 27856)) {
                                    if (CallChecker.beforeDeref(name, String.class, 737, 27950, 27953)) {
                                        name = CallChecker.beforeCalled(name, String.class, 735, 27755, 27758);
                                        name = CallChecker.beforeCalled(name, String.class, 736, 27853, 27856);
                                        name = CallChecker.beforeCalled(name, String.class, 737, 27950, 27953);
                                        if (((CallChecker.isCalled(name, String.class, 735, 27755, 27758).startsWith("org.apache.felix.framework.ModuleImpl$ModuleClassLoader")) || (CallChecker.isCalled(name, String.class, 736, 27853, 27856).equals("org.apache.felix.framework.searchpolicy.ContentClassLoader"))) || (CallChecker.isCalled(name, String.class, 737, 27950, 27953).startsWith("org.apache.felix.framework.BundleWiringImpl$BundleClassLoader"))) {
                                            if (CallChecker.beforeDeref(stack, Class[].class, 739, 28084, 28088)) {
                                                stack = CallChecker.beforeCalled(stack, Class[].class, 739, 28084, 28088);
                                                targetClass = CallChecker.isCalled(stack, Class[].class, 739, 28084, 28088)[i];
                                                CallChecker.varAssign(targetClass, "targetClass", 739, 28070, 28092);
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (targetClass != null) {
                synchronized(URLHandlers.m_classloaderToFrameworkLists) {
                    ClassLoader index = CallChecker.init(ClassLoader.class);
                    targetClass = CallChecker.beforeCalled(targetClass, Class.class, 752, 28494, 28504);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(targetClass, Class.class, 752, 28494, 28504).getClassLoader(), ClassLoader.class, 752, 28494, 28521)) {
                        targetClass = CallChecker.beforeCalled(targetClass, Class.class, 752, 28494, 28504);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(targetClass, Class.class, 752, 28494, 28504).getClassLoader(), ClassLoader.class, 752, 28494, 28521).getClass(), Class.class, 752, 28494, 28532)) {
                            index = CallChecker.isCalled(CallChecker.isCalled(targetClass.getClassLoader(), ClassLoader.class, 752, 28494, 28521).getClass(), Class.class, 752, 28494, 28532).getClassLoader();
                            CallChecker.varAssign(index, "index", 752, 28494, 28521);
                        }
                    }
                    List frameworks = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(URLHandlers.m_classloaderToFrameworkLists, Map.class, 754, 28594, 28622)) {
                        frameworks = ((List) (CallChecker.isCalled(URLHandlers.m_classloaderToFrameworkLists, Map.class, 754, 28594, 28622).get(index)));
                        CallChecker.varAssign(frameworks, "frameworks", 754, 28594, 28622);
                    }
                    if (CallChecker.beforeDeref(URLHandlers.URLHANDLERS_CLASS, Class.class, 757, 28712, 28728)) {
                        if ((frameworks == null) && (index == (CallChecker.isCalled(URLHandlers.URLHANDLERS_CLASS, Class.class, 757, 28712, 28728).getClassLoader()))) {
                            frameworks = URLHandlers.m_frameworks;
                            CallChecker.varAssign(frameworks, "frameworks", 759, 28787, 28812);
                        }
                    }
                    if (frameworks != null) {
                        synchronized(frameworks) {
                            for (int i = 0; i < (frameworks.size()); i++) {
                                Object framework = CallChecker.varInit(frameworks.get(i), "framework", 768, 29149, 29185);
                                TryContext _bcornu_try_context_116 = new TryContext(116, URLHandlers.class, "java.lang.Exception");
                                try {
                                    if (CallChecker.beforeDeref(framework, Object.class, 772, 29377, 29385)) {
                                        if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 772, 29344, 29357)) {
                                            if (CallChecker.beforeDeref(URLHandlers.m_secureAction, SecureAction.class, 771, 29285, 29298)) {
                                                framework = CallChecker.beforeCalled(framework, Object.class, 772, 29377, 29385);
                                                if ((CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 771, 29285, 29298).invoke(CallChecker.isCalled(URLHandlers.m_secureAction, SecureAction.class, 772, 29344, 29357).getDeclaredMethod(CallChecker.isCalled(framework, Object.class, 772, 29377, 29385).getClass(), "getBundle", URLHandlers.CLASS_TYPE), framework, new Object[]{ targetClass })) != null) {
                                                    return framework;
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                } catch (Exception ex) {
                                    _bcornu_try_context_116.catchStart(116);
                                    ex.printStackTrace();
                                } finally {
                                    _bcornu_try_context_116.finallyStart(116);
                                }
                            }
                        }
                    }
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context361.methodEnd();
        }
    }
}

