package org.apache.felix.framework.util;

import java.util.zip.ZipFile;
import org.osgi.framework.hooks.weaving.WovenClassListener;
import org.osgi.framework.hooks.weaving.WovenClass;
import org.osgi.framework.hooks.weaving.WeavingHook;
import java.net.URLStreamHandler;
import java.net.URLConnection;
import java.net.URLClassLoader;
import java.net.URL;
import java.net.URI;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceEvent;
import java.io.File;
import java.lang.reflect.Field;
import org.osgi.framework.hooks.service.EventListenerHook;
import org.osgi.framework.hooks.bundle.EventHook;
import java.lang.reflect.Constructor;
import org.osgi.framework.hooks.bundle.CollisionHook;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.lang.reflect.AccessibleObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleRevision;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.osgi.framework.hooks.bundle.FindHook;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.Hashtable;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;
import org.osgi.framework.hooks.service.ListenerHook;
import java.net.MalformedURLException;
import java.util.Map;
import java.lang.reflect.Method;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.lang.reflect.Modifier;
import java.security.Policy;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.osgi.framework.hooks.resolver.ResolverHook;
import org.osgi.framework.hooks.resolver.ResolverHookFactory;

public class SecureAction {
    private static final ThreadLocal m_actions = new ThreadLocal() {
        public Object initialValue() {
            MethodContext _bcornu_methode_context254 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 60, 2288, 2369);
                return new SecureAction.Actions();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context254.methodEnd();
            }
        }
    };

    protected static transient int BUFSIZE = 4096;

    private AccessControlContext m_acc = null;

    public SecureAction() {
        MethodContext _bcornu_methode_context22 = new MethodContext(null);
        try {
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_43 = new TryContext(43, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 76, 2644, 2652)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 76, 2644, 2652).get()));
                        CallChecker.varAssign(actions, "actions", 76, 2644, 2652);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 77, 2677, 2683)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 77, 2677, 2683);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 77, 2677, 2683).set(SecureAction.Actions.INITIALIZE_CONTEXT_ACTION, null);
                    }
                    m_acc = ((AccessControlContext) (AccessController.doPrivileged(actions)));
                    CallChecker.varAssign(this.m_acc, "this.m_acc", 78, 2747, 2816);
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_43.catchStart(43);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_43.finallyStart(43);
                }
            }else {
                m_acc = AccessController.getContext();
                CallChecker.varAssign(this.m_acc, "this.m_acc", 87, 3014, 3051);
            }
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public String getSystemProperty(String name, String def) {
        MethodContext _bcornu_methode_context255 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 91, 3074, 3683);
            CallChecker.varInit(def, "def", 91, 3074, 3683);
            CallChecker.varInit(name, "name", 91, 3074, 3683);
            CallChecker.varInit(this.m_acc, "m_acc", 91, 3074, 3683);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 91, 3074, 3683);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 91, 3074, 3683);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_44 = new TryContext(44, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 97, 3270, 3278)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 97, 3270, 3278).get()));
                        CallChecker.varAssign(actions, "actions", 97, 3270, 3278);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 98, 3303, 3309)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 98, 3303, 3309);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 98, 3303, 3309).set(SecureAction.Actions.GET_PROPERTY_ACTION, name, def);
                    }
                    return ((String) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_44.catchStart(44);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_44.finallyStart(44);
                }
            }else {
                return System.getProperty(name, def);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context255.methodEnd();
        }
    }

    public ClassLoader getParentClassLoader(ClassLoader loader) {
        MethodContext _bcornu_methode_context256 = new MethodContext(ClassLoader.class);
        try {
            CallChecker.varInit(this, "this", 112, 3690, 4304);
            CallChecker.varInit(loader, "loader", 112, 3690, 4304);
            CallChecker.varInit(this.m_acc, "m_acc", 112, 3690, 4304);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 112, 3690, 4304);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 112, 3690, 4304);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_45 = new TryContext(45, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 118, 3889, 3897)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 118, 3889, 3897).get()));
                        CallChecker.varAssign(actions, "actions", 118, 3889, 3897);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 119, 3922, 3928)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 119, 3922, 3928);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 119, 3922, 3928).set(SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION, loader);
                    }
                    return ((ClassLoader) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_45.catchStart(45);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_45.finallyStart(45);
                }
            }else {
                if (CallChecker.beforeDeref(loader, ClassLoader.class, 129, 4270, 4275)) {
                    loader = CallChecker.beforeCalled(loader, ClassLoader.class, 129, 4270, 4275);
                    return CallChecker.isCalled(loader, ClassLoader.class, 129, 4270, 4275).getParent();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context256.methodEnd();
        }
    }

    public ClassLoader getSystemClassLoader() {
        MethodContext _bcornu_methode_context257 = new MethodContext(ClassLoader.class);
        try {
            CallChecker.varInit(this, "this", 133, 4311, 4915);
            CallChecker.varInit(this.m_acc, "m_acc", 133, 4311, 4915);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 133, 4311, 4915);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 133, 4311, 4915);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_46 = new TryContext(46, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 139, 4492, 4500)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 139, 4492, 4500).get()));
                        CallChecker.varAssign(actions, "actions", 139, 4492, 4500);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 140, 4525, 4531)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 140, 4525, 4531);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 140, 4525, 4531).set(SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION);
                    }
                    return ((ClassLoader) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_46.catchStart(46);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_46.finallyStart(46);
                }
            }else {
                return ClassLoader.getSystemClassLoader();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context257.methodEnd();
        }
    }

    public ClassLoader getClassLoader(Class clazz) {
        MethodContext _bcornu_methode_context258 = new MethodContext(ClassLoader.class);
        try {
            CallChecker.varInit(this, "this", 154, 4922, 5519);
            CallChecker.varInit(clazz, "clazz", 154, 4922, 5519);
            CallChecker.varInit(this.m_acc, "m_acc", 154, 4922, 5519);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 154, 4922, 5519);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 154, 4922, 5519);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_47 = new TryContext(47, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 160, 5108, 5116)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 160, 5108, 5116).get()));
                        CallChecker.varAssign(actions, "actions", 160, 5108, 5116);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 161, 5141, 5147)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 161, 5141, 5147);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 161, 5141, 5147).set(SecureAction.Actions.GET_CLASS_LOADER_ACTION, clazz);
                    }
                    return ((ClassLoader) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_47.catchStart(47);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_47.finallyStart(47);
                }
            }else {
                if (CallChecker.beforeDeref(clazz, Class.class, 171, 5481, 5485)) {
                    clazz = CallChecker.beforeCalled(clazz, Class.class, 171, 5481, 5485);
                    return CallChecker.isCalled(clazz, Class.class, 171, 5481, 5485).getClassLoader();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ClassLoader) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context258.methodEnd();
        }
    }

    public Class forName(String name, ClassLoader classloader) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context259 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(this, "this", 175, 5526, 6456);
            CallChecker.varInit(classloader, "classloader", 175, 5526, 6456);
            CallChecker.varInit(name, "name", 175, 5526, 6456);
            CallChecker.varInit(this.m_acc, "m_acc", 175, 5526, 6456);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 175, 5526, 6456);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 175, 5526, 6456);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_48 = new TryContext(48, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 181, 5754, 5762)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 181, 5754, 5762).get()));
                        CallChecker.varAssign(actions, "actions", 181, 5754, 5762);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 182, 5787, 5793)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 182, 5787, 5793);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 182, 5787, 5793).set(SecureAction.Actions.FOR_NAME_ACTION, name, classloader);
                    }
                    return ((Class) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_48.catchStart(48);
                    if ((ex.getException()) instanceof ClassNotFoundException) {
                        throw ((ClassNotFoundException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_48.finallyStart(48);
                }
            }else
                if (classloader != null) {
                    return Class.forName(name, true, classloader);
                }else {
                    return Class.forName(name);
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context259.methodEnd();
        }
    }

    public URL createURL(String protocol, String host, int port, String path, URLStreamHandler handler) throws MalformedURLException {
        MethodContext _bcornu_methode_context260 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 204, 6463, 7406);
            CallChecker.varInit(handler, "handler", 204, 6463, 7406);
            CallChecker.varInit(path, "path", 204, 6463, 7406);
            CallChecker.varInit(port, "port", 204, 6463, 7406);
            CallChecker.varInit(host, "host", 204, 6463, 7406);
            CallChecker.varInit(protocol, "protocol", 204, 6463, 7406);
            CallChecker.varInit(this.m_acc, "m_acc", 204, 6463, 7406);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 204, 6463, 7406);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 204, 6463, 7406);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_49 = new TryContext(49, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 212, 6747, 6755)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 212, 6747, 6755).get()));
                        CallChecker.varAssign(actions, "actions", 212, 6747, 6755);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 213, 6780, 6786)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 213, 6780, 6786);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 213, 6780, 6786).set(SecureAction.Actions.CREATE_URL_ACTION, protocol, host, new Integer(port), path, handler);
                    }
                    return ((URL) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_49.catchStart(49);
                    if ((ex.getException()) instanceof MalformedURLException) {
                        throw ((MalformedURLException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_49.finallyStart(49);
                }
            }else {
                return new URL(protocol, host, port, path, handler);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context260.methodEnd();
        }
    }

    public URL createURL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        MethodContext _bcornu_methode_context261 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 232, 7413, 8295);
            CallChecker.varInit(handler, "handler", 232, 7413, 8295);
            CallChecker.varInit(spec, "spec", 232, 7413, 8295);
            CallChecker.varInit(context, "context", 232, 7413, 8295);
            CallChecker.varInit(this.m_acc, "m_acc", 232, 7413, 8295);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 232, 7413, 8295);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 232, 7413, 8295);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_50 = new TryContext(50, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 239, 7662, 7670)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 239, 7662, 7670).get()));
                        CallChecker.varAssign(actions, "actions", 239, 7662, 7670);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 240, 7695, 7701)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 240, 7695, 7701);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 240, 7695, 7701).set(SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION, context, spec, handler);
                    }
                    return ((URL) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_50.catchStart(50);
                    if ((ex.getException()) instanceof MalformedURLException) {
                        throw ((MalformedURLException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_50.finallyStart(50);
                }
            }else {
                return new URL(context, spec, handler);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context261.methodEnd();
        }
    }

    public Process exec(String command) throws IOException {
        MethodContext _bcornu_methode_context262 = new MethodContext(Process.class);
        try {
            CallChecker.varInit(this, "this", 259, 8302, 8905);
            CallChecker.varInit(command, "command", 259, 8302, 8905);
            CallChecker.varInit(this.m_acc, "m_acc", 259, 8302, 8905);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 259, 8302, 8905);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 259, 8302, 8905);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_51 = new TryContext(51, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 265, 8496, 8504)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 265, 8496, 8504).get()));
                        CallChecker.varAssign(actions, "actions", 265, 8496, 8504);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 266, 8529, 8535)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 266, 8529, 8535);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 266, 8529, 8535).set(SecureAction.Actions.EXEC_ACTION, command);
                    }
                    return ((Process) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_51.catchStart(51);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_51.finallyStart(51);
                }
            }else {
                if (CallChecker.beforeDeref(Runtime.getRuntime(), Runtime.class, 276, 8855, 8874)) {
                    return CallChecker.isCalled(Runtime.getRuntime(), Runtime.class, 276, 8855, 8874).exec(command);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Process) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context262.methodEnd();
        }
    }

    public String getAbsolutePath(File file) {
        MethodContext _bcornu_methode_context263 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 280, 8912, 9498);
            CallChecker.varInit(file, "file", 280, 8912, 9498);
            CallChecker.varInit(this.m_acc, "m_acc", 280, 8912, 9498);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 280, 8912, 9498);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 280, 8912, 9498);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_52 = new TryContext(52, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 286, 9092, 9100)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 286, 9092, 9100).get()));
                        CallChecker.varAssign(actions, "actions", 286, 9092, 9100);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 287, 9125, 9131)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 287, 9125, 9131);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 287, 9125, 9131).set(SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION, file);
                    }
                    return ((String) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_52.catchStart(52);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_52.finallyStart(52);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 297, 9460, 9463)) {
                    file = CallChecker.beforeCalled(file, File.class, 297, 9460, 9463);
                    return CallChecker.isCalled(file, File.class, 297, 9460, 9463).getAbsolutePath();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context263.methodEnd();
        }
    }

    public boolean fileExists(File file) {
        MethodContext _bcornu_methode_context264 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 301, 9505, 10111);
            CallChecker.varInit(file, "file", 301, 9505, 10111);
            CallChecker.varInit(this.m_acc, "m_acc", 301, 9505, 10111);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 301, 9505, 10111);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 301, 9505, 10111);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_53 = new TryContext(53, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 307, 9681, 9689)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 307, 9681, 9689).get()));
                        CallChecker.varAssign(actions, "actions", 307, 9681, 9689);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 308, 9714, 9720)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 308, 9714, 9720);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 308, 9714, 9720).set(SecureAction.Actions.FILE_EXISTS_ACTION, file);
                    }
                    if (CallChecker.beforeDeref(AccessController.doPrivileged(actions, m_acc), Object.class, 309, 9795, 9839)) {
                        return CallChecker.isCalled(((Boolean) (AccessController.doPrivileged(actions, m_acc))), Boolean.class, 309, 9795, 9839).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_53.catchStart(53);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_53.finallyStart(53);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 319, 10082, 10085)) {
                    file = CallChecker.beforeCalled(file, File.class, 319, 10082, 10085);
                    return CallChecker.isCalled(file, File.class, 319, 10082, 10085).exists();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context264.methodEnd();
        }
    }

    public boolean isFileDirectory(File file) {
        MethodContext _bcornu_methode_context265 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 323, 10118, 10740);
            CallChecker.varInit(file, "file", 323, 10118, 10740);
            CallChecker.varInit(this.m_acc, "m_acc", 323, 10118, 10740);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 323, 10118, 10740);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 323, 10118, 10740);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_54 = new TryContext(54, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 329, 10299, 10307)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 329, 10299, 10307).get()));
                        CallChecker.varAssign(actions, "actions", 329, 10299, 10307);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 330, 10332, 10338)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 330, 10332, 10338);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 330, 10332, 10338).set(SecureAction.Actions.FILE_IS_DIRECTORY_ACTION, file);
                    }
                    if (CallChecker.beforeDeref(AccessController.doPrivileged(actions, m_acc), Object.class, 331, 10419, 10463)) {
                        return CallChecker.isCalled(((Boolean) (AccessController.doPrivileged(actions, m_acc))), Boolean.class, 331, 10419, 10463).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_54.catchStart(54);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_54.finallyStart(54);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 341, 10706, 10709)) {
                    file = CallChecker.beforeCalled(file, File.class, 341, 10706, 10709);
                    return CallChecker.isCalled(file, File.class, 341, 10706, 10709).isDirectory();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context265.methodEnd();
        }
    }

    public boolean mkdir(File file) {
        MethodContext _bcornu_methode_context266 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 345, 10747, 11350);
            CallChecker.varInit(file, "file", 345, 10747, 11350);
            CallChecker.varInit(this.m_acc, "m_acc", 345, 10747, 11350);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 345, 10747, 11350);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 345, 10747, 11350);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_55 = new TryContext(55, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 351, 10918, 10926)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 351, 10918, 10926).get()));
                        CallChecker.varAssign(actions, "actions", 351, 10918, 10926);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 352, 10951, 10957)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 352, 10951, 10957);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 352, 10951, 10957).set(SecureAction.Actions.MAKE_DIRECTORY_ACTION, file);
                    }
                    if (CallChecker.beforeDeref(AccessController.doPrivileged(actions, m_acc), Object.class, 353, 11035, 11079)) {
                        return CallChecker.isCalled(((Boolean) (AccessController.doPrivileged(actions, m_acc))), Boolean.class, 353, 11035, 11079).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_55.catchStart(55);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_55.finallyStart(55);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 363, 11322, 11325)) {
                    file = CallChecker.beforeCalled(file, File.class, 363, 11322, 11325);
                    return CallChecker.isCalled(file, File.class, 363, 11322, 11325).mkdir();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context266.methodEnd();
        }
    }

    public boolean mkdirs(File file) {
        MethodContext _bcornu_methode_context267 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 367, 11357, 11964);
            CallChecker.varInit(file, "file", 367, 11357, 11964);
            CallChecker.varInit(this.m_acc, "m_acc", 367, 11357, 11964);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 367, 11357, 11964);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 367, 11357, 11964);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_56 = new TryContext(56, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 373, 11529, 11537)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 373, 11529, 11537).get()));
                        CallChecker.varAssign(actions, "actions", 373, 11529, 11537);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 374, 11562, 11568)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 374, 11562, 11568);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 374, 11562, 11568).set(SecureAction.Actions.MAKE_DIRECTORIES_ACTION, file);
                    }
                    if (CallChecker.beforeDeref(AccessController.doPrivileged(actions, m_acc), Object.class, 375, 11648, 11692)) {
                        return CallChecker.isCalled(((Boolean) (AccessController.doPrivileged(actions, m_acc))), Boolean.class, 375, 11648, 11692).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_56.catchStart(56);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_56.finallyStart(56);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 385, 11935, 11938)) {
                    file = CallChecker.beforeCalled(file, File.class, 385, 11935, 11938);
                    return CallChecker.isCalled(file, File.class, 385, 11935, 11938).mkdirs();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context267.methodEnd();
        }
    }

    public File[] listDirectory(File file) {
        MethodContext _bcornu_methode_context268 = new MethodContext(File[].class);
        try {
            CallChecker.varInit(this, "this", 389, 11971, 12546);
            CallChecker.varInit(file, "file", 389, 11971, 12546);
            CallChecker.varInit(this.m_acc, "m_acc", 389, 11971, 12546);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 389, 11971, 12546);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 389, 11971, 12546);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_57 = new TryContext(57, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 395, 12149, 12157)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 395, 12149, 12157).get()));
                        CallChecker.varAssign(actions, "actions", 395, 12149, 12157);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 396, 12182, 12188)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 396, 12182, 12188);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 396, 12182, 12188).set(SecureAction.Actions.LIST_DIRECTORY_ACTION, file);
                    }
                    return ((File[]) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_57.catchStart(57);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_57.finallyStart(57);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 406, 12514, 12517)) {
                    file = CallChecker.beforeCalled(file, File.class, 406, 12514, 12517);
                    return CallChecker.isCalled(file, File.class, 406, 12514, 12517).listFiles();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((File[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context268.methodEnd();
        }
    }

    public boolean renameFile(File oldFile, File newFile) {
        MethodContext _bcornu_methode_context269 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 410, 12553, 13200);
            CallChecker.varInit(newFile, "newFile", 410, 12553, 13200);
            CallChecker.varInit(oldFile, "oldFile", 410, 12553, 13200);
            CallChecker.varInit(this.m_acc, "m_acc", 410, 12553, 13200);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 410, 12553, 13200);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 410, 12553, 13200);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_58 = new TryContext(58, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 416, 12746, 12754)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 416, 12746, 12754).get()));
                        CallChecker.varAssign(actions, "actions", 416, 12746, 12754);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 417, 12779, 12785)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 417, 12779, 12785);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 417, 12779, 12785).set(SecureAction.Actions.RENAME_FILE_ACTION, oldFile, newFile);
                    }
                    if (CallChecker.beforeDeref(AccessController.doPrivileged(actions, m_acc), Object.class, 418, 12872, 12916)) {
                        return CallChecker.isCalled(((Boolean) (AccessController.doPrivileged(actions, m_acc))), Boolean.class, 418, 12872, 12916).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_58.catchStart(58);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_58.finallyStart(58);
                }
            }else {
                if (CallChecker.beforeDeref(oldFile, File.class, 428, 13159, 13165)) {
                    oldFile = CallChecker.beforeCalled(oldFile, File.class, 428, 13159, 13165);
                    return CallChecker.isCalled(oldFile, File.class, 428, 13159, 13165).renameTo(newFile);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context269.methodEnd();
        }
    }

    public FileInputStream getFileInputStream(File file) throws IOException {
        MethodContext _bcornu_methode_context270 = new MethodContext(FileInputStream.class);
        try {
            CallChecker.varInit(this, "this", 432, 13207, 13990);
            CallChecker.varInit(file, "file", 432, 13207, 13990);
            CallChecker.varInit(this.m_acc, "m_acc", 432, 13207, 13990);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 432, 13207, 13990);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 432, 13207, 13990);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_59 = new TryContext(59, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 438, 13418, 13426)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 438, 13418, 13426).get()));
                        CallChecker.varAssign(actions, "actions", 438, 13418, 13426);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 439, 13451, 13457)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 439, 13451, 13457);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 439, 13451, 13457).set(SecureAction.Actions.GET_FILE_INPUT_ACTION, file);
                    }
                    return ((FileInputStream) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_59.catchStart(59);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_59.finallyStart(59);
                }
            }else {
                return new FileInputStream(file);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FileInputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context270.methodEnd();
        }
    }

    public FileOutputStream getFileOutputStream(File file) throws IOException {
        MethodContext _bcornu_methode_context271 = new MethodContext(FileOutputStream.class);
        try {
            CallChecker.varInit(this, "this", 457, 13997, 14785);
            CallChecker.varInit(file, "file", 457, 13997, 14785);
            CallChecker.varInit(this.m_acc, "m_acc", 457, 13997, 14785);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 457, 13997, 14785);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 457, 13997, 14785);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_60 = new TryContext(60, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 463, 14210, 14218)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 463, 14210, 14218).get()));
                        CallChecker.varAssign(actions, "actions", 463, 14210, 14218);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 464, 14243, 14249)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 464, 14243, 14249);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 464, 14243, 14249).set(SecureAction.Actions.GET_FILE_OUTPUT_ACTION, file);
                    }
                    return ((FileOutputStream) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_60.catchStart(60);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_60.finallyStart(60);
                }
            }else {
                return new FileOutputStream(file);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FileOutputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context271.methodEnd();
        }
    }

    public URI toURI(File file) {
        MethodContext _bcornu_methode_context272 = new MethodContext(URI.class);
        try {
            CallChecker.varInit(this, "this", 482, 14792, 15341);
            CallChecker.varInit(file, "file", 482, 14792, 15341);
            CallChecker.varInit(this.m_acc, "m_acc", 482, 14792, 15341);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 482, 14792, 15341);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 482, 14792, 15341);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_61 = new TryContext(61, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 488, 14959, 14967)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 488, 14959, 14967).get()));
                        CallChecker.varAssign(actions, "actions", 488, 14959, 14967);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 489, 14992, 14998)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 489, 14992, 14998);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 489, 14992, 14998).set(SecureAction.Actions.TO_URI_ACTION, file);
                    }
                    return ((URI) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_61.catchStart(61);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_61.finallyStart(61);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 499, 15313, 15316)) {
                    file = CallChecker.beforeCalled(file, File.class, 499, 15313, 15316);
                    return CallChecker.isCalled(file, File.class, 499, 15313, 15316).toURI();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URI) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context272.methodEnd();
        }
    }

    public InputStream getURLConnectionInputStream(URLConnection conn) throws IOException {
        MethodContext _bcornu_methode_context273 = new MethodContext(InputStream.class);
        try {
            CallChecker.varInit(this, "this", 503, 15348, 16144);
            CallChecker.varInit(conn, "conn", 503, 15348, 16144);
            CallChecker.varInit(this.m_acc, "m_acc", 503, 15348, 16144);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 503, 15348, 16144);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 503, 15348, 16144);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_62 = new TryContext(62, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 510, 15581, 15589)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 510, 15581, 15589).get()));
                        CallChecker.varAssign(actions, "actions", 510, 15581, 15589);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 511, 15614, 15620)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 511, 15614, 15620);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 511, 15614, 15620).set(SecureAction.Actions.GET_URL_INPUT_ACTION, conn);
                    }
                    return ((InputStream) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_62.catchStart(62);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_62.finallyStart(62);
                }
            }else {
                if (CallChecker.beforeDeref(conn, URLConnection.class, 525, 16107, 16110)) {
                    conn = CallChecker.beforeCalled(conn, URLConnection.class, 525, 16107, 16110);
                    return CallChecker.isCalled(conn, URLConnection.class, 525, 16107, 16110).getInputStream();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context273.methodEnd();
        }
    }

    public boolean deleteFile(File target) {
        MethodContext _bcornu_methode_context274 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 529, 16151, 16763);
            CallChecker.varInit(target, "target", 529, 16151, 16763);
            CallChecker.varInit(this.m_acc, "m_acc", 529, 16151, 16763);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 529, 16151, 16763);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 529, 16151, 16763);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_63 = new TryContext(63, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 535, 16329, 16337)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 535, 16329, 16337).get()));
                        CallChecker.varAssign(actions, "actions", 535, 16329, 16337);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 536, 16362, 16368)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 536, 16362, 16368);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 536, 16362, 16368).set(SecureAction.Actions.DELETE_FILE_ACTION, target);
                    }
                    if (CallChecker.beforeDeref(AccessController.doPrivileged(actions, m_acc), Object.class, 537, 16445, 16489)) {
                        return CallChecker.isCalled(((Boolean) (AccessController.doPrivileged(actions, m_acc))), Boolean.class, 537, 16445, 16489).booleanValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_63.catchStart(63);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_63.finallyStart(63);
                }
            }else {
                if (CallChecker.beforeDeref(target, File.class, 547, 16732, 16737)) {
                    target = CallChecker.beforeCalled(target, File.class, 547, 16732, 16737);
                    return CallChecker.isCalled(target, File.class, 547, 16732, 16737).delete();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context274.methodEnd();
        }
    }

    public File createTempFile(String prefix, String suffix, File dir) throws IOException {
        MethodContext _bcornu_methode_context275 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 551, 16770, 17594);
            CallChecker.varInit(dir, "dir", 551, 16770, 17594);
            CallChecker.varInit(suffix, "suffix", 551, 16770, 17594);
            CallChecker.varInit(prefix, "prefix", 551, 16770, 17594);
            CallChecker.varInit(this.m_acc, "m_acc", 551, 16770, 17594);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 551, 16770, 17594);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 551, 16770, 17594);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_64 = new TryContext(64, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 558, 17003, 17011)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 558, 17003, 17011).get()));
                        CallChecker.varAssign(actions, "actions", 558, 17003, 17011);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 559, 17036, 17042)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 559, 17036, 17042);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 559, 17036, 17042).set(SecureAction.Actions.CREATE_TMPFILE_ACTION, prefix, suffix, dir);
                    }
                    return ((File) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_64.catchStart(64);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_64.finallyStart(64);
                }
            }else {
                return File.createTempFile(prefix, suffix, dir);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context275.methodEnd();
        }
    }

    public void deleteFileOnExit(File file) throws IOException {
        MethodContext _bcornu_methode_context276 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 577, 17601, 18344);
            CallChecker.varInit(file, "file", 577, 17601, 18344);
            CallChecker.varInit(this.m_acc, "m_acc", 577, 17601, 18344);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 577, 17601, 18344);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 577, 17601, 18344);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_65 = new TryContext(65, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 584, 17807, 17815)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 584, 17807, 17815).get()));
                        CallChecker.varAssign(actions, "actions", 584, 17807, 17815);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 585, 17840, 17846)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 585, 17840, 17846);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 585, 17840, 17846).set(SecureAction.Actions.DELETE_FILEONEXIT_ACTION, file);
                    }
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_65.catchStart(65);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_65.finallyStart(65);
                }
            }else {
                if (CallChecker.beforeDeref(file, File.class, 599, 18309, 18312)) {
                    file = CallChecker.beforeCalled(file, File.class, 599, 18309, 18312);
                    CallChecker.isCalled(file, File.class, 599, 18309, 18312).deleteOnExit();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context276.methodEnd();
        }
    }

    public URLConnection openURLConnection(URL url) throws IOException {
        MethodContext _bcornu_methode_context277 = new MethodContext(URLConnection.class);
        try {
            CallChecker.varInit(this, "this", 603, 18351, 19145);
            CallChecker.varInit(url, "url", 603, 18351, 19145);
            CallChecker.varInit(this.m_acc, "m_acc", 603, 18351, 19145);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 603, 18351, 19145);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 603, 18351, 19145);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_66 = new TryContext(66, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 609, 18557, 18565)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 609, 18557, 18565).get()));
                        CallChecker.varAssign(actions, "actions", 609, 18557, 18565);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 610, 18590, 18596)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 610, 18590, 18596);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 610, 18590, 18596).set(SecureAction.Actions.OPEN_URLCONNECTION_ACTION, url);
                    }
                    return ((URLConnection) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_66.catchStart(66);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_66.finallyStart(66);
                }
            }else {
                if (CallChecker.beforeDeref(url, URL.class, 625, 19109, 19111)) {
                    url = CallChecker.beforeCalled(url, URL.class, 625, 19109, 19111);
                    return CallChecker.isCalled(url, URL.class, 625, 19109, 19111).openConnection();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLConnection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context277.methodEnd();
        }
    }

    public ZipFile openZipFile(File file) throws IOException {
        MethodContext _bcornu_methode_context278 = new MethodContext(ZipFile.class);
        try {
            CallChecker.varInit(this, "this", 629, 19152, 19902);
            CallChecker.varInit(file, "file", 629, 19152, 19902);
            CallChecker.varInit(this.m_acc, "m_acc", 629, 19152, 19902);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 629, 19152, 19902);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 629, 19152, 19902);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_67 = new TryContext(67, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 635, 19348, 19356)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 635, 19348, 19356).get()));
                        CallChecker.varAssign(actions, "actions", 635, 19348, 19356);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 636, 19381, 19387)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 636, 19381, 19387);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 636, 19381, 19387).set(SecureAction.Actions.OPEN_ZIPFILE_ACTION, file);
                    }
                    return ((ZipFile) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_67.catchStart(67);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_67.finallyStart(67);
                }
            }else {
                return new ZipFile(file);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ZipFile) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context278.methodEnd();
        }
    }

    public JarFile openJarFile(File file) throws IOException {
        MethodContext _bcornu_methode_context279 = new MethodContext(JarFile.class);
        try {
            CallChecker.varInit(this, "this", 654, 19909, 20659);
            CallChecker.varInit(file, "file", 654, 19909, 20659);
            CallChecker.varInit(this.m_acc, "m_acc", 654, 19909, 20659);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 654, 19909, 20659);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 654, 19909, 20659);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_68 = new TryContext(68, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 660, 20105, 20113)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 660, 20105, 20113).get()));
                        CallChecker.varAssign(actions, "actions", 660, 20105, 20113);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 661, 20138, 20144)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 661, 20138, 20144);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 661, 20138, 20144).set(SecureAction.Actions.OPEN_JARFILE_ACTION, file);
                    }
                    return ((JarFile) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_68.catchStart(68);
                    if ((ex.getException()) instanceof IOException) {
                        throw ((IOException) (ex.getException()));
                    }
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_68.finallyStart(68);
                }
            }else {
                return new JarFile(file);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((JarFile) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context279.methodEnd();
        }
    }

    public void startActivator(BundleActivator activator, BundleContext context) throws Exception {
        MethodContext _bcornu_methode_context280 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 679, 20666, 21285);
            CallChecker.varInit(context, "context", 679, 20666, 21285);
            CallChecker.varInit(activator, "activator", 679, 20666, 21285);
            CallChecker.varInit(this.m_acc, "m_acc", 679, 20666, 21285);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 679, 20666, 21285);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 679, 20666, 21285);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_69 = new TryContext(69, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 686, 20907, 20915)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 686, 20907, 20915).get()));
                        CallChecker.varAssign(actions, "actions", 686, 20907, 20915);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 687, 20940, 20946)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 687, 20940, 20946);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 687, 20940, 20946).set(SecureAction.Actions.START_ACTIVATOR_ACTION, activator, context);
                    }
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_69.catchStart(69);
                    throw ex.getException();
                } finally {
                    _bcornu_try_context_69.finallyStart(69);
                }
            }else {
                if (CallChecker.beforeDeref(activator, BundleActivator.class, 697, 21245, 21253)) {
                    activator = CallChecker.beforeCalled(activator, BundleActivator.class, 697, 21245, 21253);
                    CallChecker.isCalled(activator, BundleActivator.class, 697, 21245, 21253).start(context);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context280.methodEnd();
        }
    }

    public void stopActivator(BundleActivator activator, BundleContext context) throws Exception {
        MethodContext _bcornu_methode_context281 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 701, 21292, 21908);
            CallChecker.varInit(context, "context", 701, 21292, 21908);
            CallChecker.varInit(activator, "activator", 701, 21292, 21908);
            CallChecker.varInit(this.m_acc, "m_acc", 701, 21292, 21908);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 701, 21292, 21908);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 701, 21292, 21908);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_70 = new TryContext(70, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 708, 21532, 21540)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 708, 21532, 21540).get()));
                        CallChecker.varAssign(actions, "actions", 708, 21532, 21540);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 709, 21565, 21571)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 709, 21565, 21571);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 709, 21565, 21571).set(SecureAction.Actions.STOP_ACTIVATOR_ACTION, activator, context);
                    }
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_70.catchStart(70);
                    throw ex.getException();
                } finally {
                    _bcornu_try_context_70.finallyStart(70);
                }
            }else {
                if (CallChecker.beforeDeref(activator, BundleActivator.class, 719, 21869, 21877)) {
                    activator = CallChecker.beforeCalled(activator, BundleActivator.class, 719, 21869, 21877);
                    CallChecker.isCalled(activator, BundleActivator.class, 719, 21869, 21877).stop(context);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context281.methodEnd();
        }
    }

    public Policy getPolicy() {
        MethodContext _bcornu_methode_context282 = new MethodContext(Policy.class);
        try {
            CallChecker.varInit(this, "this", 723, 21915, 22475);
            CallChecker.varInit(this.m_acc, "m_acc", 723, 21915, 22475);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 723, 21915, 22475);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 723, 21915, 22475);
            if ((System.getSecurityManager()) != null) {
                TryContext _bcornu_try_context_71 = new TryContext(71, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                    if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 729, 22080, 22088)) {
                        actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 729, 22080, 22088).get()));
                        CallChecker.varAssign(actions, "actions", 729, 22080, 22088);
                    }
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 730, 22113, 22119)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 730, 22113, 22119);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 730, 22113, 22119).set(SecureAction.Actions.GET_POLICY_ACTION, null);
                    }
                    return ((Policy) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_71.catchStart(71);
                    throw ((RuntimeException) (ex.getException()));
                } finally {
                    _bcornu_try_context_71.finallyStart(71);
                }
            }else {
                return Policy.getPolicy();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Policy) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context282.methodEnd();
        }
    }

    public void addURLToURLClassLoader(URL extension, ClassLoader loader) throws Exception {
        MethodContext _bcornu_methode_context283 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 744, 22482, 23274);
            CallChecker.varInit(loader, "loader", 744, 22482, 23274);
            CallChecker.varInit(extension, "extension", 744, 22482, 23274);
            CallChecker.varInit(this.m_acc, "m_acc", 744, 22482, 23274);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 744, 22482, 23274);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 744, 22482, 23274);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 748, 22674, 22682)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 748, 22674, 22682).get()));
                    CallChecker.varAssign(actions, "actions", 748, 22674, 22682);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 749, 22703, 22709)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 749, 22703, 22709);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 749, 22703, 22709).set(SecureAction.Actions.ADD_EXTENSION_URL_ACTION, extension, loader);
                }
                TryContext _bcornu_try_context_72 = new TryContext(72, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_72.catchStart(72);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_72.finallyStart(72);
                }
            }else {
                Method addURL = CallChecker.varInit(URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{ URL.class }), "addURL", 761, 23037, 23158);
                if (CallChecker.beforeDeref(addURL, Method.class, 764, 23172, 23177)) {
                    addURL = CallChecker.beforeCalled(addURL, Method.class, 764, 23172, 23177);
                    CallChecker.isCalled(addURL, Method.class, 764, 23172, 23177).setAccessible(true);
                }
                if (CallChecker.beforeDeref(addURL, Method.class, 765, 23212, 23217)) {
                    addURL = CallChecker.beforeCalled(addURL, Method.class, 765, 23212, 23217);
                    CallChecker.isCalled(addURL, Method.class, 765, 23212, 23217).invoke(loader, new Object[]{ extension });
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context283.methodEnd();
        }
    }

    public Constructor getConstructor(Class target, Class[] types) throws Exception {
        MethodContext _bcornu_methode_context284 = new MethodContext(Constructor.class);
        try {
            CallChecker.varInit(this, "this", 769, 23281, 23895);
            CallChecker.varInit(types, "types", 769, 23281, 23895);
            CallChecker.varInit(target, "target", 769, 23281, 23895);
            CallChecker.varInit(this.m_acc, "m_acc", 769, 23281, 23895);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 769, 23281, 23895);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 769, 23281, 23895);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 773, 23466, 23474)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 773, 23466, 23474).get()));
                    CallChecker.varAssign(actions, "actions", 773, 23466, 23474);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 774, 23495, 23501)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 774, 23495, 23501);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 774, 23495, 23501).set(SecureAction.Actions.GET_CONSTRUCTOR_ACTION, target, types);
                }
                TryContext _bcornu_try_context_73 = new TryContext(73, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return ((Constructor) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_73.catchStart(73);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_73.finallyStart(73);
                }
            }else {
                if (CallChecker.beforeDeref(target, Class.class, 786, 23851, 23856)) {
                    target = CallChecker.beforeCalled(target, Class.class, 786, 23851, 23856);
                    return CallChecker.isCalled(target, Class.class, 786, 23851, 23856).getConstructor(types);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Constructor) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context284.methodEnd();
        }
    }

    public Constructor getDeclaredConstructor(Class target, Class[] types) throws Exception {
        MethodContext _bcornu_methode_context285 = new MethodContext(Constructor.class);
        try {
            CallChecker.varInit(this, "this", 790, 23902, 24541);
            CallChecker.varInit(types, "types", 790, 23902, 24541);
            CallChecker.varInit(target, "target", 790, 23902, 24541);
            CallChecker.varInit(this.m_acc, "m_acc", 790, 23902, 24541);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 790, 23902, 24541);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 790, 23902, 24541);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 794, 24095, 24103)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 794, 24095, 24103).get()));
                    CallChecker.varAssign(actions, "actions", 794, 24095, 24103);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 795, 24124, 24130)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 795, 24124, 24130);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 795, 24124, 24130).set(SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION, target, types);
                }
                TryContext _bcornu_try_context_74 = new TryContext(74, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return ((Constructor) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_74.catchStart(74);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_74.finallyStart(74);
                }
            }else {
                if (CallChecker.beforeDeref(target, Class.class, 807, 24489, 24494)) {
                    target = CallChecker.beforeCalled(target, Class.class, 807, 24489, 24494);
                    return CallChecker.isCalled(target, Class.class, 807, 24489, 24494).getDeclaredConstructor(types);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Constructor) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context285.methodEnd();
        }
    }

    public Method getMethod(Class target, String method, Class[] types) throws Exception {
        MethodContext _bcornu_methode_context286 = new MethodContext(Method.class);
        try {
            CallChecker.varInit(this, "this", 811, 24548, 25168);
            CallChecker.varInit(types, "types", 811, 24548, 25168);
            CallChecker.varInit(method, "method", 811, 24548, 25168);
            CallChecker.varInit(target, "target", 811, 24548, 25168);
            CallChecker.varInit(this.m_acc, "m_acc", 811, 24548, 25168);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 811, 24548, 25168);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 811, 24548, 25168);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 815, 24738, 24746)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 815, 24738, 24746).get()));
                    CallChecker.varAssign(actions, "actions", 815, 24738, 24746);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 816, 24767, 24773)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 816, 24767, 24773);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 816, 24767, 24773).set(SecureAction.Actions.GET_METHOD_ACTION, target, method, types);
                }
                TryContext _bcornu_try_context_75 = new TryContext(75, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return ((Method) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_75.catchStart(75);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_75.finallyStart(75);
                }
            }else {
                if (CallChecker.beforeDeref(target, Class.class, 828, 25121, 25126)) {
                    target = CallChecker.beforeCalled(target, Class.class, 828, 25121, 25126);
                    return CallChecker.isCalled(target, Class.class, 828, 25121, 25126).getMethod(method, types);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Method) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context286.methodEnd();
        }
    }

    public Method getDeclaredMethod(Class target, String method, Class[] types) throws Exception {
        MethodContext _bcornu_methode_context287 = new MethodContext(Method.class);
        try {
            CallChecker.varInit(this, "this", 832, 25175, 25820);
            CallChecker.varInit(types, "types", 832, 25175, 25820);
            CallChecker.varInit(method, "method", 832, 25175, 25820);
            CallChecker.varInit(target, "target", 832, 25175, 25820);
            CallChecker.varInit(this.m_acc, "m_acc", 832, 25175, 25820);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 832, 25175, 25820);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 832, 25175, 25820);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 836, 25373, 25381)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 836, 25373, 25381).get()));
                    CallChecker.varAssign(actions, "actions", 836, 25373, 25381);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 837, 25402, 25408)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 837, 25402, 25408);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 837, 25402, 25408).set(SecureAction.Actions.GET_DECLARED_METHOD_ACTION, target, method, types);
                }
                TryContext _bcornu_try_context_76 = new TryContext(76, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return ((Method) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_76.catchStart(76);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_76.finallyStart(76);
                }
            }else {
                if (CallChecker.beforeDeref(target, Class.class, 849, 25765, 25770)) {
                    target = CallChecker.beforeCalled(target, Class.class, 849, 25765, 25770);
                    return CallChecker.isCalled(target, Class.class, 849, 25765, 25770).getDeclaredMethod(method, types);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Method) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context287.methodEnd();
        }
    }

    public void setAccesssible(AccessibleObject ao) {
        MethodContext _bcornu_methode_context288 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 853, 25827, 26382);
            CallChecker.varInit(ao, "ao", 853, 25827, 26382);
            CallChecker.varInit(this.m_acc, "m_acc", 853, 25827, 26382);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 853, 25827, 26382);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 853, 25827, 26382);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 857, 25980, 25988)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 857, 25980, 25988).get()));
                    CallChecker.varAssign(actions, "actions", 857, 25980, 25988);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 858, 26009, 26015)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 858, 26009, 26015);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 858, 26009, 26015).set(SecureAction.Actions.SET_ACCESSIBLE_ACTION, ao);
                }
                TryContext _bcornu_try_context_77 = new TryContext(77, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_77.catchStart(77);
                    throw ((RuntimeException) (e.getException()));
                } finally {
                    _bcornu_try_context_77.finallyStart(77);
                }
            }else {
                if (CallChecker.beforeDeref(ao, AccessibleObject.class, 870, 26344, 26345)) {
                    ao = CallChecker.beforeCalled(ao, AccessibleObject.class, 870, 26344, 26345);
                    CallChecker.isCalled(ao, AccessibleObject.class, 870, 26344, 26345).setAccessible(true);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context288.methodEnd();
        }
    }

    public Object invoke(Method method, Object target, Object[] params) throws Exception {
        MethodContext _bcornu_methode_context289 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 874, 26389, 27042);
            CallChecker.varInit(params, "params", 874, 26389, 27042);
            CallChecker.varInit(target, "target", 874, 26389, 27042);
            CallChecker.varInit(method, "method", 874, 26389, 27042);
            CallChecker.varInit(this.m_acc, "m_acc", 874, 26389, 27042);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 874, 26389, 27042);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 874, 26389, 27042);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 878, 26579, 26587)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 878, 26579, 26587).get()));
                    CallChecker.varAssign(actions, "actions", 878, 26579, 26587);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 879, 26608, 26614)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 879, 26608, 26614);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 879, 26608, 26614).set(SecureAction.Actions.INVOKE_METHOD_ACTION, method, target, params);
                }
                TryContext _bcornu_try_context_78 = new TryContext(78, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_78.catchStart(78);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_78.finallyStart(78);
                }
            }else {
                if (CallChecker.beforeDeref(method, Method.class, 891, 26950, 26955)) {
                    method = CallChecker.beforeCalled(method, Method.class, 891, 26950, 26955);
                    CallChecker.isCalled(method, Method.class, 891, 26950, 26955).setAccessible(true);
                }
                if (CallChecker.beforeDeref(method, Method.class, 892, 26997, 27002)) {
                    method = CallChecker.beforeCalled(method, Method.class, 892, 26997, 27002);
                    return CallChecker.isCalled(method, Method.class, 892, 26997, 27002).invoke(target, params);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context289.methodEnd();
        }
    }

    public Object invokeDirect(Method method, Object target, Object[] params) throws Exception {
        MethodContext _bcornu_methode_context290 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 896, 27049, 27674);
            CallChecker.varInit(params, "params", 896, 27049, 27674);
            CallChecker.varInit(target, "target", 896, 27049, 27674);
            CallChecker.varInit(method, "method", 896, 27049, 27674);
            CallChecker.varInit(this.m_acc, "m_acc", 896, 27049, 27674);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 896, 27049, 27674);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 896, 27049, 27674);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 900, 27245, 27253)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 900, 27245, 27253).get()));
                    CallChecker.varAssign(actions, "actions", 900, 27245, 27253);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 901, 27274, 27280)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 901, 27274, 27280);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 901, 27274, 27280).set(SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION, method, target, params);
                }
                TryContext _bcornu_try_context_79 = new TryContext(79, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_79.catchStart(79);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_79.finallyStart(79);
                }
            }else {
                if (CallChecker.beforeDeref(method, Method.class, 913, 27629, 27634)) {
                    method = CallChecker.beforeCalled(method, Method.class, 913, 27629, 27634);
                    return CallChecker.isCalled(method, Method.class, 913, 27629, 27634).invoke(target, params);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context290.methodEnd();
        }
    }

    public Object invoke(Constructor constructor, Object[] params) throws Exception {
        MethodContext _bcornu_methode_context291 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 917, 27681, 28293);
            CallChecker.varInit(params, "params", 917, 27681, 28293);
            CallChecker.varInit(constructor, "constructor", 917, 27681, 28293);
            CallChecker.varInit(this.m_acc, "m_acc", 917, 27681, 28293);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 917, 27681, 28293);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 917, 27681, 28293);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 921, 27866, 27874)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 921, 27866, 27874).get()));
                    CallChecker.varAssign(actions, "actions", 921, 27866, 27874);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 922, 27895, 27901)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 922, 27895, 27901);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 922, 27895, 27901).set(SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION, constructor, params);
                }
                TryContext _bcornu_try_context_80 = new TryContext(80, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_80.catchStart(80);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_80.finallyStart(80);
                }
            }else {
                if (CallChecker.beforeDeref(constructor, Constructor.class, 934, 28246, 28256)) {
                    constructor = CallChecker.beforeCalled(constructor, Constructor.class, 934, 28246, 28256);
                    return CallChecker.isCalled(constructor, Constructor.class, 934, 28246, 28256).newInstance(params);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context291.methodEnd();
        }
    }

    public Object getDeclaredField(Class targetClass, String name, Object target) throws Exception {
        MethodContext _bcornu_methode_context292 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 938, 28300, 29020);
            CallChecker.varInit(target, "target", 938, 28300, 29020);
            CallChecker.varInit(name, "name", 938, 28300, 29020);
            CallChecker.varInit(targetClass, "targetClass", 938, 28300, 29020);
            CallChecker.varInit(this.m_acc, "m_acc", 938, 28300, 29020);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 938, 28300, 29020);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 938, 28300, 29020);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 943, 28508, 28516)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 943, 28508, 28516).get()));
                    CallChecker.varAssign(actions, "actions", 943, 28508, 28516);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 944, 28537, 28543)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 944, 28537, 28543);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 944, 28537, 28543).set(SecureAction.Actions.GET_FIELD_ACTION, targetClass, name, target);
                }
                TryContext _bcornu_try_context_81 = new TryContext(81, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_81.catchStart(81);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_81.finallyStart(81);
                }
            }else {
                Field field = CallChecker.init(Field.class);
                if (CallChecker.beforeDeref(targetClass, Class.class, 956, 28892, 28902)) {
                    targetClass = CallChecker.beforeCalled(targetClass, Class.class, 956, 28892, 28902);
                    field = CallChecker.isCalled(targetClass, Class.class, 956, 28892, 28902).getDeclaredField(name);
                    CallChecker.varAssign(field, "field", 956, 28892, 28902);
                }
                if (CallChecker.beforeDeref(field, Field.class, 957, 28940, 28944)) {
                    field = CallChecker.beforeCalled(field, Field.class, 957, 28940, 28944);
                    CallChecker.isCalled(field, Field.class, 957, 28940, 28944).setAccessible(true);
                }
                if (CallChecker.beforeDeref(field, Field.class, 959, 28987, 28991)) {
                    field = CallChecker.beforeCalled(field, Field.class, 959, 28987, 28991);
                    return CallChecker.isCalled(field, Field.class, 959, 28987, 28991).get(target);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context292.methodEnd();
        }
    }

    public Object swapStaticFieldIfNotClass(Class targetClazz, Class targetType, Class condition, String lockName) throws Exception {
        MethodContext _bcornu_methode_context293 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 963, 29027, 29785);
            CallChecker.varInit(lockName, "lockName", 963, 29027, 29785);
            CallChecker.varInit(condition, "condition", 963, 29027, 29785);
            CallChecker.varInit(targetType, "targetType", 963, 29027, 29785);
            CallChecker.varInit(targetClazz, "targetClazz", 963, 29027, 29785);
            CallChecker.varInit(this.m_acc, "m_acc", 963, 29027, 29785);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 963, 29027, 29785);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 963, 29027, 29785);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 968, 29268, 29276)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 968, 29268, 29276).get()));
                    CallChecker.varAssign(actions, "actions", 968, 29268, 29276);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 969, 29297, 29303)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 969, 29297, 29303);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 969, 29297, 29303).set(SecureAction.Actions.SWAP_FIELD_ACTION, targetClazz, targetType, condition, lockName);
                }
                TryContext _bcornu_try_context_82 = new TryContext(82, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_82.catchStart(82);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_82.finallyStart(82);
                }
            }else {
                return SecureAction._swapStaticFieldIfNotClass(targetClazz, targetType, condition, lockName);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context293.methodEnd();
        }
    }

    private static Object _swapStaticFieldIfNotClass(Class targetClazz, Class targetType, Class condition, String lockName) throws Exception {
        MethodContext _bcornu_methode_context294 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(lockName, "lockName", 987, 29792, 32119);
            CallChecker.varInit(condition, "condition", 987, 29792, 32119);
            CallChecker.varInit(targetType, "targetType", 987, 29792, 32119);
            CallChecker.varInit(targetClazz, "targetClazz", 987, 29792, 32119);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 987, 29792, 32119);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 987, 29792, 32119);
            Object lock = CallChecker.varInit(null, "lock", 990, 29951, 29969);
            if (lockName != null) {
                TryContext _bcornu_try_context_83 = new TryContext(83, SecureAction.class, "java.lang.NoSuchFieldException");
                try {
                    Field lockField = CallChecker.init(Field.class);
                    if (CallChecker.beforeDeref(targetClazz, Class.class, 996, 30095, 30105)) {
                        targetClazz = CallChecker.beforeCalled(targetClazz, Class.class, 996, 30095, 30105);
                        lockField = CallChecker.isCalled(targetClazz, Class.class, 996, 30095, 30105).getDeclaredField(lockName);
                        CallChecker.varAssign(lockField, "lockField", 996, 30095, 30105);
                    }
                    if (CallChecker.beforeDeref(lockField, Field.class, 997, 30151, 30159)) {
                        lockField = CallChecker.beforeCalled(lockField, Field.class, 997, 30151, 30159);
                        CallChecker.isCalled(lockField, Field.class, 997, 30151, 30159).setAccessible(true);
                    }
                    if (CallChecker.beforeDeref(lockField, Field.class, 998, 30205, 30213)) {
                        lockField = CallChecker.beforeCalled(lockField, Field.class, 998, 30205, 30213);
                        lock = CallChecker.isCalled(lockField, Field.class, 998, 30205, 30213).get(null);
                        CallChecker.varAssign(lock, "lock", 998, 30198, 30224);
                    }
                } catch (NoSuchFieldException ex) {
                    _bcornu_try_context_83.catchStart(83);
                } finally {
                    _bcornu_try_context_83.finallyStart(83);
                }
            }
            if (lock == null) {
                lock = targetClazz;
                CallChecker.varAssign(lock, "lock", 1006, 30370, 30388);
            }
            synchronized(lock) {
                Field[] fields = CallChecker.init(Field[].class);
                if (CallChecker.beforeDeref(targetClazz, Class.class, 1010, 30467, 30477)) {
                    targetClazz = CallChecker.beforeCalled(targetClazz, Class.class, 1010, 30467, 30477);
                    fields = CallChecker.isCalled(targetClazz, Class.class, 1010, 30467, 30477).getDeclaredFields();
                    CallChecker.varAssign(fields, "fields", 1010, 30467, 30477);
                }
                Object result = CallChecker.varInit(null, "result", 1012, 30513, 30533);
                fields = CallChecker.beforeCalled(fields, Field[].class, 1013, 30568, 30573);
                for (int i = 0; (i < (CallChecker.isCalled(fields, Field[].class, 1013, 30568, 30573).length)) && (result == null); i++) {
                    if (CallChecker.beforeDeref(fields, Field[].class, 1015, 30661, 30666)) {
                        fields = CallChecker.beforeCalled(fields, Field[].class, 1015, 30661, 30666);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1015, 30661, 30666)[i], Field.class, 1015, 30661, 30669)) {
                            if (CallChecker.beforeDeref(fields, Field[].class, 1016, 30711, 30716)) {
                                fields = CallChecker.beforeCalled(fields, Field[].class, 1016, 30711, 30716);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1016, 30711, 30716)[i], Field.class, 1016, 30711, 30719)) {
                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1015, 30661, 30666);
                                    CallChecker.isCalled(fields, Field[].class, 1015, 30661, 30666)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1015, 30661, 30666)[i], Field.class, 1015, 30661, 30669);
                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1016, 30711, 30716);
                                    CallChecker.isCalled(fields, Field[].class, 1016, 30711, 30716)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1016, 30711, 30716)[i], Field.class, 1016, 30711, 30719);
                                    if ((Modifier.isStatic(CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1015, 30661, 30666)[i], Field.class, 1015, 30661, 30669).getModifiers())) && ((CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1016, 30711, 30716)[i], Field.class, 1016, 30711, 30719).getType()) == targetType)) {
                                        if (CallChecker.beforeDeref(fields, Field[].class, 1018, 30785, 30790)) {
                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1018, 30785, 30790);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1018, 30785, 30790)[i], Field.class, 1018, 30785, 30793)) {
                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1018, 30785, 30790);
                                                CallChecker.isCalled(fields, Field[].class, 1018, 30785, 30790)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1018, 30785, 30790)[i], Field.class, 1018, 30785, 30793);
                                                CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1018, 30785, 30790)[i], Field.class, 1018, 30785, 30793).setAccessible(true);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(fields, Field[].class, 1020, 30846, 30851)) {
                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1020, 30846, 30851);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1020, 30846, 30851)[i], Field.class, 1020, 30846, 30854)) {
                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1020, 30846, 30851);
                                                CallChecker.isCalled(fields, Field[].class, 1020, 30846, 30851)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1020, 30846, 30851)[i], Field.class, 1020, 30846, 30854);
                                                result = CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1020, 30846, 30851)[i], Field.class, 1020, 30846, 30854).get(null);
                                                CallChecker.varAssign(result, "result", 1020, 30837, 30865);
                                            }
                                        }
                                        if (result != null) {
                                            result = CallChecker.beforeCalled(result, Object.class, 1025, 31010, 31015);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(result, Object.class, 1025, 31010, 31015).getClass(), Class.class, 1025, 31010, 31026)) {
                                                result = CallChecker.beforeCalled(result, Object.class, 1025, 31010, 31015);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(result, Object.class, 1025, 31010, 31015).getClass(), Class.class, 1025, 31010, 31026).getName(), String.class, 1025, 31010, 31036)) {
                                                    if ((condition == null) || (!(CallChecker.isCalled(CallChecker.isCalled(result.getClass(), Class.class, 1025, 31010, 31026).getName(), String.class, 1025, 31010, 31036).equals(condition.getName())))) {
                                                        if (CallChecker.beforeDeref(fields, Field[].class, 1027, 31121, 31126)) {
                                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1027, 31121, 31126);
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1027, 31121, 31126)[i], Field.class, 1027, 31121, 31129)) {
                                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1027, 31121, 31126);
                                                                CallChecker.isCalled(fields, Field[].class, 1027, 31121, 31126)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1027, 31121, 31126)[i], Field.class, 1027, 31121, 31129);
                                                                CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1027, 31121, 31126)[i], Field.class, 1027, 31121, 31129).set(null, null);
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
                }
                if (result != null) {
                    result = CallChecker.beforeCalled(result, Object.class, 1034, 31318, 31323);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Object.class, 1034, 31318, 31323).getClass(), Class.class, 1034, 31318, 31334)) {
                        result = CallChecker.beforeCalled(result, Object.class, 1034, 31318, 31323);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(result, Object.class, 1034, 31318, 31323).getClass(), Class.class, 1034, 31318, 31334).getName(), String.class, 1034, 31318, 31344)) {
                            if ((condition == null) || (!(CallChecker.isCalled(CallChecker.isCalled(result.getClass(), Class.class, 1034, 31318, 31334).getName(), String.class, 1034, 31318, 31344).equals(condition.getName())))) {
                                fields = CallChecker.beforeCalled(fields, Field[].class, 1037, 31468, 31473);
                                for (int i = 0; i < (CallChecker.isCalled(fields, Field[].class, 1037, 31468, 31473).length); i++) {
                                    if (CallChecker.beforeDeref(fields, Field[].class, 1039, 31556, 31561)) {
                                        fields = CallChecker.beforeCalled(fields, Field[].class, 1039, 31556, 31561);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1039, 31556, 31561)[i], Field.class, 1039, 31556, 31564)) {
                                            if (CallChecker.beforeDeref(fields, Field[].class, 1040, 31614, 31619)) {
                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1040, 31614, 31619);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1040, 31614, 31619)[i], Field.class, 1040, 31614, 31622)) {
                                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1039, 31556, 31561);
                                                    CallChecker.isCalled(fields, Field[].class, 1039, 31556, 31561)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1039, 31556, 31561)[i], Field.class, 1039, 31556, 31564);
                                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1040, 31614, 31619);
                                                    CallChecker.isCalled(fields, Field[].class, 1040, 31614, 31619)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1040, 31614, 31619)[i], Field.class, 1040, 31614, 31622);
                                                    if ((Modifier.isStatic(CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1039, 31556, 31561)[i], Field.class, 1039, 31556, 31564).getModifiers())) && ((CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1040, 31614, 31619)[i], Field.class, 1040, 31614, 31622).getType()) == (Hashtable.class))) {
                                                        if (CallChecker.beforeDeref(fields, Field[].class, 1042, 31709, 31714)) {
                                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1042, 31709, 31714);
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1042, 31709, 31714)[i], Field.class, 1042, 31709, 31717)) {
                                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1042, 31709, 31714);
                                                                CallChecker.isCalled(fields, Field[].class, 1042, 31709, 31714)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1042, 31709, 31714)[i], Field.class, 1042, 31709, 31717);
                                                                CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1042, 31709, 31714)[i], Field.class, 1042, 31709, 31717).setAccessible(true);
                                                            }
                                                        }
                                                        Hashtable cache = CallChecker.init(Hashtable.class);
                                                        if (CallChecker.beforeDeref(fields, Field[].class, 1043, 31798, 31803)) {
                                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1043, 31798, 31803);
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1043, 31798, 31803)[i], Field.class, 1043, 31798, 31806)) {
                                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1043, 31798, 31803);
                                                                CallChecker.isCalled(fields, Field[].class, 1043, 31798, 31803)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1043, 31798, 31803)[i], Field.class, 1043, 31798, 31806);
                                                                cache = ((Hashtable) (CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1043, 31798, 31803)[i], Field.class, 1043, 31798, 31806).get(null)));
                                                                CallChecker.varAssign(cache, "cache", 1043, 31798, 31803);
                                                            }
                                                        }
                                                        if (cache != null) {
                                                            cache.clear();
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
                                    
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    return result;
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context294.methodEnd();
        }
    }

    public void flush(Class targetClazz, Object lock) throws Exception {
        MethodContext _bcornu_methode_context295 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1057, 32126, 32696);
            CallChecker.varInit(lock, "lock", 1057, 32126, 32696);
            CallChecker.varInit(targetClazz, "targetClazz", 1057, 32126, 32696);
            CallChecker.varInit(this.m_acc, "m_acc", 1057, 32126, 32696);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1057, 32126, 32696);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1057, 32126, 32696);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1061, 32298, 32306)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1061, 32298, 32306).get()));
                    CallChecker.varAssign(actions, "actions", 1061, 32298, 32306);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1062, 32327, 32333)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1062, 32327, 32333);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1062, 32327, 32333).set(SecureAction.Actions.FLUSH_FIELD_ACTION, targetClazz, lock);
                }
                TryContext _bcornu_try_context_84 = new TryContext(84, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_84.catchStart(84);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_84.finallyStart(84);
                }
            }else {
                SecureAction._flush(targetClazz, lock);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context295.methodEnd();
        }
    }

    private static void _flush(Class targetClazz, Object lock) throws Exception {
        MethodContext _bcornu_methode_context296 = new MethodContext(void.class);
        try {
            CallChecker.varInit(lock, "lock", 1078, 32703, 33865);
            CallChecker.varInit(targetClazz, "targetClazz", 1078, 32703, 33865);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1078, 32703, 33865);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1078, 32703, 33865);
            synchronized(lock) {
                Field[] fields = CallChecker.init(Field[].class);
                if (CallChecker.beforeDeref(targetClazz, Class.class, 1082, 32852, 32862)) {
                    targetClazz = CallChecker.beforeCalled(targetClazz, Class.class, 1082, 32852, 32862);
                    fields = CallChecker.isCalled(targetClazz, Class.class, 1082, 32852, 32862).getDeclaredFields();
                    CallChecker.varAssign(fields, "fields", 1082, 32852, 32862);
                }
                fields = CallChecker.beforeCalled(fields, Field[].class, 1084, 32944, 32949);
                for (int i = 0; i < (CallChecker.isCalled(fields, Field[].class, 1084, 32944, 32949).length); i++) {
                    if (CallChecker.beforeDeref(fields, Field[].class, 1086, 33016, 33021)) {
                        fields = CallChecker.beforeCalled(fields, Field[].class, 1086, 33016, 33021);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1086, 33016, 33021)[i], Field.class, 1086, 33016, 33024)) {
                            if (CallChecker.beforeDeref(fields, Field[].class, 1087, 33067, 33072)) {
                                fields = CallChecker.beforeCalled(fields, Field[].class, 1087, 33067, 33072);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1087, 33067, 33072)[i], Field.class, 1087, 33067, 33075)) {
                                    if (CallChecker.beforeDeref(fields, Field[].class, 1087, 33111, 33116)) {
                                        fields = CallChecker.beforeCalled(fields, Field[].class, 1087, 33111, 33116);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1087, 33111, 33116)[i], Field.class, 1087, 33111, 33119)) {
                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1086, 33016, 33021);
                                            CallChecker.isCalled(fields, Field[].class, 1086, 33016, 33021)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1086, 33016, 33021)[i], Field.class, 1086, 33016, 33024);
                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1087, 33067, 33072);
                                            CallChecker.isCalled(fields, Field[].class, 1087, 33067, 33072)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1087, 33067, 33072)[i], Field.class, 1087, 33067, 33075);
                                            fields = CallChecker.beforeCalled(fields, Field[].class, 1087, 33111, 33116);
                                            CallChecker.isCalled(fields, Field[].class, 1087, 33111, 33116)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1087, 33111, 33116)[i], Field.class, 1087, 33111, 33119);
                                            if ((Modifier.isStatic(CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1086, 33016, 33021)[i], Field.class, 1086, 33016, 33024).getModifiers())) && (((CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1087, 33067, 33072)[i], Field.class, 1087, 33067, 33075).getType()) == (Hashtable.class)) || ((CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1087, 33111, 33116)[i], Field.class, 1087, 33111, 33119).getType()) == (HashMap.class)))) {
                                                if (CallChecker.beforeDeref(fields, Field[].class, 1089, 33189, 33194)) {
                                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1089, 33189, 33194);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1089, 33189, 33194)[i], Field.class, 1089, 33189, 33197)) {
                                                        fields = CallChecker.beforeCalled(fields, Field[].class, 1089, 33189, 33194);
                                                        CallChecker.isCalled(fields, Field[].class, 1089, 33189, 33194)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1089, 33189, 33194)[i], Field.class, 1089, 33189, 33197);
                                                        CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1089, 33189, 33194)[i], Field.class, 1089, 33189, 33197).setAccessible(true);
                                                    }
                                                }
                                                if (CallChecker.beforeDeref(fields, Field[].class, 1090, 33244, 33249)) {
                                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1090, 33244, 33249);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1090, 33244, 33249)[i], Field.class, 1090, 33244, 33252)) {
                                                        fields = CallChecker.beforeCalled(fields, Field[].class, 1090, 33244, 33249);
                                                        CallChecker.isCalled(fields, Field[].class, 1090, 33244, 33249)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1090, 33244, 33249)[i], Field.class, 1090, 33244, 33252);
                                                        if ((CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1090, 33244, 33249)[i], Field.class, 1090, 33244, 33252).getType()) == (Hashtable.class)) {
                                                            Hashtable cache = CallChecker.init(Hashtable.class);
                                                            if (CallChecker.beforeDeref(fields, Field[].class, 1092, 33360, 33365)) {
                                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1092, 33360, 33365);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1092, 33360, 33365)[i], Field.class, 1092, 33360, 33368)) {
                                                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1092, 33360, 33365);
                                                                    CallChecker.isCalled(fields, Field[].class, 1092, 33360, 33365)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1092, 33360, 33365)[i], Field.class, 1092, 33360, 33368);
                                                                    cache = ((Hashtable) (CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1092, 33360, 33365)[i], Field.class, 1092, 33360, 33368).get(null)));
                                                                    CallChecker.varAssign(cache, "cache", 1092, 33360, 33365);
                                                                }
                                                            }
                                                            if (cache != null) {
                                                                cache.clear();
                                                            }
                                                        }else {
                                                            HashMap cache = CallChecker.init(HashMap.class);
                                                            if (CallChecker.beforeDeref(fields, Field[].class, 1100, 33638, 33643)) {
                                                                fields = CallChecker.beforeCalled(fields, Field[].class, 1100, 33638, 33643);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(fields, Field[].class, 1100, 33638, 33643)[i], Field.class, 1100, 33638, 33646)) {
                                                                    fields = CallChecker.beforeCalled(fields, Field[].class, 1100, 33638, 33643);
                                                                    CallChecker.isCalled(fields, Field[].class, 1100, 33638, 33643)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fields, Field[].class, 1100, 33638, 33643)[i], Field.class, 1100, 33638, 33646);
                                                                    cache = ((HashMap) (CallChecker.isCalled(CallChecker.isCalled(fields, Field[].class, 1100, 33638, 33643)[i], Field.class, 1100, 33638, 33646).get(null)));
                                                                    CallChecker.varAssign(cache, "cache", 1100, 33638, 33643);
                                                                }
                                                            }
                                                            if (cache != null) {
                                                                cache.clear();
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
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context296.methodEnd();
        }
    }

    public void invokeBundleCollisionHook(CollisionHook ch, int operationType, Bundle targetBundle, Collection<Bundle> collisionCandidates) throws Exception {
        MethodContext _bcornu_methode_context297 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1111, 33872, 34674);
            CallChecker.varInit(collisionCandidates, "collisionCandidates", 1111, 33872, 34674);
            CallChecker.varInit(targetBundle, "targetBundle", 1111, 33872, 34674);
            CallChecker.varInit(operationType, "operationType", 1111, 33872, 34674);
            CallChecker.varInit(ch, "ch", 1111, 33872, 34674);
            CallChecker.varInit(this.m_acc, "m_acc", 1111, 33872, 34674);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1111, 33872, 34674);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1111, 33872, 34674);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1118, 34187, 34195)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1118, 34187, 34195).get()));
                    CallChecker.varAssign(actions, "actions", 1118, 34187, 34195);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1119, 34216, 34222)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1119, 34216, 34222);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1119, 34216, 34222).set(SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK, ch, operationType, targetBundle, collisionCandidates);
                }
                TryContext _bcornu_try_context_85 = new TryContext(85, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_85.catchStart(85);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_85.finallyStart(85);
                }
            }else {
                if (CallChecker.beforeDeref(ch, CollisionHook.class, 1131, 34589, 34590)) {
                    ch = CallChecker.beforeCalled(ch, CollisionHook.class, 1131, 34589, 34590);
                    CallChecker.isCalled(ch, CollisionHook.class, 1131, 34589, 34590).filterCollisions(operationType, targetBundle, collisionCandidates);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context297.methodEnd();
        }
    }

    public void invokeBundleFindHook(FindHook fh, BundleContext bc, Collection<Bundle> bundles) throws Exception {
        MethodContext _bcornu_methode_context298 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1135, 34681, 35348);
            CallChecker.varInit(bundles, "bundles", 1135, 34681, 35348);
            CallChecker.varInit(bc, "bc", 1135, 34681, 35348);
            CallChecker.varInit(fh, "fh", 1135, 34681, 35348);
            CallChecker.varInit(this.m_acc, "m_acc", 1135, 34681, 35348);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1135, 34681, 35348);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1135, 34681, 35348);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1142, 34952, 34960)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1142, 34952, 34960).get()));
                    CallChecker.varAssign(actions, "actions", 1142, 34952, 34960);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1143, 34981, 34987)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1143, 34981, 34987);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1143, 34981, 34987).set(SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK, fh, bc, bundles);
                }
                TryContext _bcornu_try_context_86 = new TryContext(86, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_86.catchStart(86);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_86.finallyStart(86);
                }
            }else {
                if (CallChecker.beforeDeref(fh, FindHook.class, 1155, 35312, 35313)) {
                    fh = CallChecker.beforeCalled(fh, FindHook.class, 1155, 35312, 35313);
                    CallChecker.isCalled(fh, FindHook.class, 1155, 35312, 35313).find(bc, bundles);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context298.methodEnd();
        }
    }

    public void invokeBundleEventHook(EventHook eh, BundleEvent event, Collection<BundleContext> contexts) throws Exception {
        MethodContext _bcornu_methode_context299 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1159, 35355, 36043);
            CallChecker.varInit(contexts, "contexts", 1159, 35355, 36043);
            CallChecker.varInit(event, "event", 1159, 35355, 36043);
            CallChecker.varInit(eh, "eh", 1159, 35355, 36043);
            CallChecker.varInit(this.m_acc, "m_acc", 1159, 35355, 36043);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1159, 35355, 36043);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1159, 35355, 36043);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1166, 35637, 35645)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1166, 35637, 35645).get()));
                    CallChecker.varAssign(actions, "actions", 1166, 35637, 35645);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1167, 35666, 35672)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1167, 35666, 35672);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1167, 35666, 35672).set(SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK, eh, event, contexts);
                }
                TryContext _bcornu_try_context_87 = new TryContext(87, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_87.catchStart(87);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_87.finallyStart(87);
                }
            }else {
                if (CallChecker.beforeDeref(eh, EventHook.class, 1179, 36002, 36003)) {
                    eh = CallChecker.beforeCalled(eh, EventHook.class, 1179, 36002, 36003);
                    CallChecker.isCalled(eh, EventHook.class, 1179, 36002, 36003).event(event, contexts);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context299.methodEnd();
        }
    }

    public void invokeWeavingHook(WeavingHook wh, WovenClass wc) throws Exception {
        MethodContext _bcornu_methode_context300 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1183, 36050, 36699);
            CallChecker.varInit(wc, "wc", 1183, 36050, 36699);
            CallChecker.varInit(wh, "wh", 1183, 36050, 36699);
            CallChecker.varInit(this.m_acc, "m_acc", 1183, 36050, 36699);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1183, 36050, 36699);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1183, 36050, 36699);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1190, 36324, 36332)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1190, 36324, 36332).get()));
                    CallChecker.varAssign(actions, "actions", 1190, 36324, 36332);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1191, 36353, 36359)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1191, 36353, 36359);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1191, 36353, 36359).set(SecureAction.Actions.INVOKE_WEAVING_HOOK, wh, wc);
                }
                TryContext _bcornu_try_context_88 = new TryContext(88, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_88.catchStart(88);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_88.finallyStart(88);
                }
            }else {
                if (CallChecker.beforeDeref(wh, WeavingHook.class, 1203, 36671, 36672)) {
                    wh = CallChecker.beforeCalled(wh, WeavingHook.class, 1203, 36671, 36672);
                    CallChecker.isCalled(wh, WeavingHook.class, 1203, 36671, 36672).weave(wc);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context300.methodEnd();
        }
    }

    public void invokeServiceEventHook(org.osgi.framework.hooks.service.EventHook eh, ServiceEvent event, Collection<BundleContext> contexts) throws Exception {
        MethodContext _bcornu_methode_context301 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1207, 36706, 37398);
            CallChecker.varInit(contexts, "contexts", 1207, 36706, 37398);
            CallChecker.varInit(event, "event", 1207, 36706, 37398);
            CallChecker.varInit(eh, "eh", 1207, 36706, 37398);
            CallChecker.varInit(this.m_acc, "m_acc", 1207, 36706, 37398);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1207, 36706, 37398);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1207, 36706, 37398);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1214, 36991, 36999)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1214, 36991, 36999).get()));
                    CallChecker.varAssign(actions, "actions", 1214, 36991, 36999);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1215, 37020, 37026)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1215, 37020, 37026);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1215, 37020, 37026).set(SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK, eh, event, contexts);
                }
                TryContext _bcornu_try_context_89 = new TryContext(89, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_89.catchStart(89);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_89.finallyStart(89);
                }
            }else {
                if (CallChecker.beforeDeref(eh, org.osgi.framework.hooks.service.EventHook.class, 1227, 37357, 37358)) {
                    eh = CallChecker.beforeCalled(eh, org.osgi.framework.hooks.service.EventHook.class, 1227, 37357, 37358);
                    CallChecker.isCalled(eh, org.osgi.framework.hooks.service.EventHook.class, 1227, 37357, 37358).event(event, contexts);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context301.methodEnd();
        }
    }

    public void invokeServiceFindHook(org.osgi.framework.hooks.service.FindHook fh, BundleContext context, String name, String filter, boolean allServices, Collection<ServiceReference<?>> references) throws Exception {
        MethodContext _bcornu_methode_context302 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1231, 37405, 38289);
            CallChecker.varInit(references, "references", 1231, 37405, 38289);
            CallChecker.varInit(allServices, "allServices", 1231, 37405, 38289);
            CallChecker.varInit(filter, "filter", 1231, 37405, 38289);
            CallChecker.varInit(name, "name", 1231, 37405, 38289);
            CallChecker.varInit(context, "context", 1231, 37405, 38289);
            CallChecker.varInit(fh, "fh", 1231, 37405, 38289);
            CallChecker.varInit(this.m_acc, "m_acc", 1231, 37405, 38289);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1231, 37405, 38289);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1231, 37405, 38289);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1239, 37756, 37764)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1239, 37756, 37764).get()));
                    CallChecker.varAssign(actions, "actions", 1239, 37756, 37764);
                }
                if (allServices) {
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1240, 37785, 37791)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1240, 37785, 37791);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 1240, 37785, 37791).set(SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK, fh, context, name, filter, Boolean.TRUE, references);
                    }
                }else {
                    if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1240, 37785, 37791)) {
                        actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1240, 37785, 37791);
                        CallChecker.isCalled(actions, SecureAction.Actions.class, 1240, 37785, 37791).set(SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK, fh, context, name, filter, Boolean.FALSE, references);
                    }
                }
                TryContext _bcornu_try_context_90 = new TryContext(90, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_90.catchStart(90);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_90.finallyStart(90);
                }
            }else {
                if (CallChecker.beforeDeref(fh, org.osgi.framework.hooks.service.FindHook.class, 1254, 38218, 38219)) {
                    fh = CallChecker.beforeCalled(fh, org.osgi.framework.hooks.service.FindHook.class, 1254, 38218, 38219);
                    CallChecker.isCalled(fh, org.osgi.framework.hooks.service.FindHook.class, 1254, 38218, 38219).find(context, name, filter, allServices, references);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context302.methodEnd();
        }
    }

    public void invokeServiceListenerHookAdded(ListenerHook lh, Collection<ListenerHook.ListenerInfo> listeners) throws Exception {
        MethodContext _bcornu_methode_context303 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1258, 38296, 38989);
            CallChecker.varInit(listeners, "listeners", 1258, 38296, 38989);
            CallChecker.varInit(lh, "lh", 1258, 38296, 38989);
            CallChecker.varInit(this.m_acc, "m_acc", 1258, 38296, 38989);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1258, 38296, 38989);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1258, 38296, 38989);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1265, 38585, 38593)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1265, 38585, 38593).get()));
                    CallChecker.varAssign(actions, "actions", 1265, 38585, 38593);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1266, 38614, 38620)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1266, 38614, 38620);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1266, 38614, 38620).set(SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED, lh, listeners);
                }
                TryContext _bcornu_try_context_91 = new TryContext(91, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_91.catchStart(91);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_91.finallyStart(91);
                }
            }else {
                if (CallChecker.beforeDeref(lh, ListenerHook.class, 1278, 38954, 38955)) {
                    lh = CallChecker.beforeCalled(lh, ListenerHook.class, 1278, 38954, 38955);
                    CallChecker.isCalled(lh, ListenerHook.class, 1278, 38954, 38955).added(listeners);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context303.methodEnd();
        }
    }

    public void invokeServiceListenerHookRemoved(ListenerHook lh, Collection<ListenerHook.ListenerInfo> listeners) throws Exception {
        MethodContext _bcornu_methode_context304 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1282, 38996, 39695);
            CallChecker.varInit(listeners, "listeners", 1282, 38996, 39695);
            CallChecker.varInit(lh, "lh", 1282, 38996, 39695);
            CallChecker.varInit(this.m_acc, "m_acc", 1282, 38996, 39695);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1282, 38996, 39695);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1282, 38996, 39695);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1289, 39287, 39295)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1289, 39287, 39295).get()));
                    CallChecker.varAssign(actions, "actions", 1289, 39287, 39295);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1290, 39316, 39322)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1290, 39316, 39322);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1290, 39316, 39322).set(SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED, lh, listeners);
                }
                TryContext _bcornu_try_context_92 = new TryContext(92, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_92.catchStart(92);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_92.finallyStart(92);
                }
            }else {
                if (CallChecker.beforeDeref(lh, ListenerHook.class, 1302, 39658, 39659)) {
                    lh = CallChecker.beforeCalled(lh, ListenerHook.class, 1302, 39658, 39659);
                    CallChecker.isCalled(lh, ListenerHook.class, 1302, 39658, 39659).removed(listeners);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context304.methodEnd();
        }
    }

    public void invokeServiceEventListenerHook(EventListenerHook elh, ServiceEvent event, Map<BundleContext, Collection<ListenerHook.ListenerInfo>> listeners) throws Exception {
        MethodContext _bcornu_methode_context305 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1306, 39702, 40465);
            CallChecker.varInit(listeners, "listeners", 1306, 39702, 40465);
            CallChecker.varInit(event, "event", 1306, 39702, 40465);
            CallChecker.varInit(elh, "elh", 1306, 39702, 40465);
            CallChecker.varInit(this.m_acc, "m_acc", 1306, 39702, 40465);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1306, 39702, 40465);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1306, 39702, 40465);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1314, 40045, 40053)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1314, 40045, 40053).get()));
                    CallChecker.varAssign(actions, "actions", 1314, 40045, 40053);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1315, 40074, 40080)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1315, 40074, 40080);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1315, 40074, 40080).set(SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK, elh, event, listeners);
                }
                TryContext _bcornu_try_context_93 = new TryContext(93, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_93.catchStart(93);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_93.finallyStart(93);
                }
            }else {
                if (CallChecker.beforeDeref(elh, EventListenerHook.class, 1327, 40422, 40424)) {
                    elh = CallChecker.beforeCalled(elh, EventListenerHook.class, 1327, 40422, 40424);
                    CallChecker.isCalled(elh, EventListenerHook.class, 1327, 40422, 40424).event(event, listeners);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context305.methodEnd();
        }
    }

    public ResolverHook invokeResolverHookFactory(ResolverHookFactory rhf, Collection<BundleRevision> triggers) throws Exception {
        MethodContext _bcornu_methode_context306 = new MethodContext(ResolverHook.class);
        try {
            CallChecker.varInit(this, "this", 1331, 40472, 41188);
            CallChecker.varInit(triggers, "triggers", 1331, 40472, 41188);
            CallChecker.varInit(rhf, "rhf", 1331, 40472, 41188);
            CallChecker.varInit(this.m_acc, "m_acc", 1331, 40472, 41188);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1331, 40472, 41188);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1331, 40472, 41188);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1338, 40761, 40769)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1338, 40761, 40769).get()));
                    CallChecker.varAssign(actions, "actions", 1338, 40761, 40769);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1339, 40790, 40796)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1339, 40790, 40796);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1339, 40790, 40796).set(SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY, rhf, triggers);
                }
                TryContext _bcornu_try_context_94 = new TryContext(94, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    return ((ResolverHook) (AccessController.doPrivileged(actions, m_acc)));
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_94.catchStart(94);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_94.finallyStart(94);
                }
            }else {
                if (CallChecker.beforeDeref(rhf, ResolverHookFactory.class, 1351, 41153, 41155)) {
                    rhf = CallChecker.beforeCalled(rhf, ResolverHookFactory.class, 1351, 41153, 41155);
                    return CallChecker.isCalled(rhf, ResolverHookFactory.class, 1351, 41153, 41155).begin(triggers);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResolverHook) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context306.methodEnd();
        }
    }

    public void invokeResolverHookResolvable(ResolverHook rh, Collection<BundleRevision> candidates) throws Exception {
        MethodContext _bcornu_methode_context307 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1355, 41195, 41887);
            CallChecker.varInit(candidates, "candidates", 1355, 41195, 41887);
            CallChecker.varInit(rh, "rh", 1355, 41195, 41887);
            CallChecker.varInit(this.m_acc, "m_acc", 1355, 41195, 41887);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1355, 41195, 41887);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1355, 41195, 41887);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1362, 41473, 41481)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1362, 41473, 41481).get()));
                    CallChecker.varAssign(actions, "actions", 1362, 41473, 41481);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1363, 41502, 41508)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1363, 41502, 41508);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1363, 41502, 41508).set(SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE, rh, candidates);
                }
                TryContext _bcornu_try_context_95 = new TryContext(95, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_95.catchStart(95);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_95.finallyStart(95);
                }
            }else {
                if (CallChecker.beforeDeref(rh, ResolverHook.class, 1375, 41840, 41841)) {
                    rh = CallChecker.beforeCalled(rh, ResolverHook.class, 1375, 41840, 41841);
                    CallChecker.isCalled(rh, ResolverHook.class, 1375, 41840, 41841).filterResolvable(candidates);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context307.methodEnd();
        }
    }

    public void invokeResolverHookSingleton(ResolverHook rh, BundleCapability singleton, Collection<BundleCapability> collisions) throws Exception {
        MethodContext _bcornu_methode_context308 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1379, 41894, 42653);
            CallChecker.varInit(collisions, "collisions", 1379, 41894, 42653);
            CallChecker.varInit(singleton, "singleton", 1379, 41894, 42653);
            CallChecker.varInit(rh, "rh", 1379, 41894, 42653);
            CallChecker.varInit(this.m_acc, "m_acc", 1379, 41894, 42653);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1379, 41894, 42653);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1379, 41894, 42653);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1387, 42209, 42217)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1387, 42209, 42217).get()));
                    CallChecker.varAssign(actions, "actions", 1387, 42209, 42217);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1388, 42238, 42244)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1388, 42238, 42244);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1388, 42238, 42244).set(SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON, rh, singleton, collisions);
                }
                TryContext _bcornu_try_context_96 = new TryContext(96, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_96.catchStart(96);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_96.finallyStart(96);
                }
            }else {
                if (CallChecker.beforeDeref(rh, ResolverHook.class, 1400, 42586, 42587)) {
                    rh = CallChecker.beforeCalled(rh, ResolverHook.class, 1400, 42586, 42587);
                    CallChecker.isCalled(rh, ResolverHook.class, 1400, 42586, 42587).filterSingletonCollisions(singleton, collisions);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context308.methodEnd();
        }
    }

    public void invokeResolverHookMatches(ResolverHook rh, BundleRequirement req, Collection<BundleCapability> candidates) throws Exception {
        MethodContext _bcornu_methode_context309 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1404, 42660, 43386);
            CallChecker.varInit(candidates, "candidates", 1404, 42660, 43386);
            CallChecker.varInit(req, "req", 1404, 42660, 43386);
            CallChecker.varInit(rh, "rh", 1404, 42660, 43386);
            CallChecker.varInit(this.m_acc, "m_acc", 1404, 42660, 43386);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1404, 42660, 43386);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1404, 42660, 43386);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1412, 42968, 42976)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1412, 42968, 42976).get()));
                    CallChecker.varAssign(actions, "actions", 1412, 42968, 42976);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1413, 42997, 43003)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1413, 42997, 43003);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1413, 42997, 43003).set(SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES, rh, req, candidates);
                }
                TryContext _bcornu_try_context_97 = new TryContext(97, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_97.catchStart(97);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_97.finallyStart(97);
                }
            }else {
                if (CallChecker.beforeDeref(rh, ResolverHook.class, 1425, 43337, 43338)) {
                    rh = CallChecker.beforeCalled(rh, ResolverHook.class, 1425, 43337, 43338);
                    CallChecker.isCalled(rh, ResolverHook.class, 1425, 43337, 43338).filterMatches(req, candidates);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context309.methodEnd();
        }
    }

    public void invokeResolverHookEnd(ResolverHook rh) throws Exception {
        MethodContext _bcornu_methode_context310 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1429, 43393, 43989);
            CallChecker.varInit(rh, "rh", 1429, 43393, 43989);
            CallChecker.varInit(this.m_acc, "m_acc", 1429, 43393, 43989);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1429, 43393, 43989);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1429, 43393, 43989);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1435, 43617, 43625)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1435, 43617, 43625).get()));
                    CallChecker.varAssign(actions, "actions", 1435, 43617, 43625);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1436, 43646, 43652)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1436, 43646, 43652);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1436, 43646, 43652).set(SecureAction.Actions.INVOKE_RESOLVER_HOOK_END, rh);
                }
                TryContext _bcornu_try_context_98 = new TryContext(98, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_98.catchStart(98);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_98.finallyStart(98);
                }
            }else {
                if (CallChecker.beforeDeref(rh, ResolverHook.class, 1448, 43965, 43966)) {
                    rh = CallChecker.beforeCalled(rh, ResolverHook.class, 1448, 43965, 43966);
                    CallChecker.isCalled(rh, ResolverHook.class, 1448, 43965, 43966).end();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context310.methodEnd();
        }
    }

    public void invokeWovenClassListener(WovenClassListener wcl, WovenClass wc) throws Exception {
        MethodContext _bcornu_methode_context311 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1452, 43996, 44685);
            CallChecker.varInit(wc, "wc", 1452, 43996, 44685);
            CallChecker.varInit(wcl, "wcl", 1452, 43996, 44685);
            CallChecker.varInit(this.m_acc, "m_acc", 1452, 43996, 44685);
            CallChecker.varInit(SecureAction.BUFSIZE, "org.apache.felix.framework.util.SecureAction.BUFSIZE", 1452, 43996, 44685);
            CallChecker.varInit(m_actions, "org.apache.felix.framework.util.SecureAction.m_actions", 1452, 43996, 44685);
            if ((System.getSecurityManager()) != null) {
                SecureAction.Actions actions = CallChecker.init(SecureAction.Actions.class);
                if (CallChecker.beforeDeref(SecureAction.m_actions, ThreadLocal.class, 1459, 44297, 44305)) {
                    actions = ((SecureAction.Actions) (CallChecker.isCalled(SecureAction.m_actions, ThreadLocal.class, 1459, 44297, 44305).get()));
                    CallChecker.varAssign(actions, "actions", 1459, 44297, 44305);
                }
                if (CallChecker.beforeDeref(actions, SecureAction.Actions.class, 1460, 44326, 44332)) {
                    actions = CallChecker.beforeCalled(actions, SecureAction.Actions.class, 1460, 44326, 44332);
                    CallChecker.isCalled(actions, SecureAction.Actions.class, 1460, 44326, 44332).set(SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER, wcl, wc);
                }
                TryContext _bcornu_try_context_99 = new TryContext(99, SecureAction.class, "java.security.PrivilegedActionException");
                try {
                    AccessController.doPrivileged(actions, m_acc);
                } catch (PrivilegedActionException e) {
                    _bcornu_try_context_99.catchStart(99);
                    throw e.getException();
                } finally {
                    _bcornu_try_context_99.finallyStart(99);
                }
            }else {
                if (CallChecker.beforeDeref(wcl, WovenClassListener.class, 1472, 44653, 44655)) {
                    wcl = CallChecker.beforeCalled(wcl, WovenClassListener.class, 1472, 44653, 44655);
                    CallChecker.isCalled(wcl, WovenClassListener.class, 1472, 44653, 44655).modified(wc);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context311.methodEnd();
        }
    }

    private static class Actions implements PrivilegedExceptionAction {
        public static final int INITIALIZE_CONTEXT_ACTION = 0;

        public static final int ADD_EXTENSION_URL_ACTION = 1;

        public static final int CREATE_TMPFILE_ACTION = 2;

        public static final int CREATE_URL_ACTION = 3;

        public static final int CREATE_URL_WITH_CONTEXT_ACTION = 4;

        public static final int DELETE_FILE_ACTION = 5;

        public static final int EXEC_ACTION = 6;

        public static final int FILE_EXISTS_ACTION = 7;

        public static final int FILE_IS_DIRECTORY_ACTION = 8;

        public static final int FOR_NAME_ACTION = 9;

        public static final int GET_ABSOLUTE_PATH_ACTION = 10;

        public static final int GET_CONSTRUCTOR_ACTION = 11;

        public static final int GET_DECLARED_CONSTRUCTOR_ACTION = 12;

        public static final int GET_DECLARED_METHOD_ACTION = 13;

        public static final int GET_FIELD_ACTION = 14;

        public static final int GET_FILE_INPUT_ACTION = 15;

        public static final int GET_FILE_OUTPUT_ACTION = 16;

        public static final int TO_URI_ACTION = 17;

        public static final int GET_METHOD_ACTION = 18;

        public static final int GET_POLICY_ACTION = 19;

        public static final int GET_PROPERTY_ACTION = 20;

        public static final int GET_PARENT_CLASS_LOADER_ACTION = 21;

        public static final int GET_SYSTEM_CLASS_LOADER_ACTION = 22;

        public static final int GET_URL_INPUT_ACTION = 23;

        public static final int INVOKE_CONSTRUCTOR_ACTION = 24;

        public static final int INVOKE_DIRECTMETHOD_ACTION = 25;

        public static final int INVOKE_METHOD_ACTION = 26;

        public static final int LIST_DIRECTORY_ACTION = 27;

        public static final int MAKE_DIRECTORIES_ACTION = 28;

        public static final int MAKE_DIRECTORY_ACTION = 29;

        public static final int OPEN_ZIPFILE_ACTION = 30;

        public static final int OPEN_URLCONNECTION_ACTION = 31;

        public static final int RENAME_FILE_ACTION = 32;

        public static final int SET_ACCESSIBLE_ACTION = 33;

        public static final int START_ACTIVATOR_ACTION = 34;

        public static final int STOP_ACTIVATOR_ACTION = 35;

        public static final int SWAP_FIELD_ACTION = 36;

        public static final int SYSTEM_EXIT_ACTION = 37;

        public static final int FLUSH_FIELD_ACTION = 38;

        public static final int GET_CLASS_LOADER_ACTION = 39;

        public static final int INVOKE_BUNDLE_FIND_HOOK = 40;

        public static final int INVOKE_BUNDLE_EVENT_HOOK = 41;

        public static final int INVOKE_WEAVING_HOOK = 42;

        public static final int INVOKE_SERVICE_EVENT_HOOK = 43;

        public static final int INVOKE_SERVICE_FIND_HOOK = 44;

        public static final int INVOKE_SERVICE_LISTENER_HOOK_ADDED = 45;

        public static final int INVOKE_SERVICE_LISTENER_HOOK_REMOVED = 46;

        public static final int INVOKE_SERVICE_EVENT_LISTENER_HOOK = 47;

        public static final int INVOKE_RESOLVER_HOOK_FACTORY = 48;

        public static final int INVOKE_RESOLVER_HOOK_RESOLVABLE = 49;

        public static final int INVOKE_RESOLVER_HOOK_SINGLETON = 50;

        public static final int INVOKE_RESOLVER_HOOK_MATCHES = 51;

        public static final int INVOKE_RESOLVER_HOOK_END = 52;

        public static final int INVOKE_BUNDLE_COLLISION_HOOK = 53;

        public static final int OPEN_JARFILE_ACTION = 54;

        public static final int DELETE_FILEONEXIT_ACTION = 55;

        public static final int INVOKE_WOVEN_CLASS_LISTENER = 56;

        private int m_action = -1;

        private Object m_arg1 = null;

        private Object m_arg2 = null;

        private Object m_arg3 = null;

        private Object m_arg4 = null;

        private Object m_arg5 = null;

        private Object m_arg6 = null;

        public void set(int action) {
            MethodContext _bcornu_methode_context312 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1544, 48557, 48634);
                CallChecker.varInit(action, "action", 1544, 48557, 48634);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1544, 48557, 48634);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1544, 48557, 48634);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1544, 48557, 48634);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1544, 48557, 48634);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1544, 48557, 48634);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1544, 48557, 48634);
                CallChecker.varInit(this.m_action, "m_action", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1544, 48557, 48634);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1544, 48557, 48634);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1544, 48557, 48634);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1544, 48557, 48634);
                m_action = action;
                CallChecker.varAssign(this.m_action, "this.m_action", 1546, 48607, 48624);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context312.methodEnd();
            }
        }

        public void set(int action, Object arg1) {
            MethodContext _bcornu_methode_context313 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1549, 48645, 48762);
                CallChecker.varInit(arg1, "arg1", 1549, 48645, 48762);
                CallChecker.varInit(action, "action", 1549, 48645, 48762);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1549, 48645, 48762);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1549, 48645, 48762);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1549, 48645, 48762);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1549, 48645, 48762);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1549, 48645, 48762);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1549, 48645, 48762);
                CallChecker.varInit(this.m_action, "m_action", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1549, 48645, 48762);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1549, 48645, 48762);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1549, 48645, 48762);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1549, 48645, 48762);
                m_action = action;
                CallChecker.varAssign(this.m_action, "this.m_action", 1551, 48708, 48725);
                m_arg1 = arg1;
                CallChecker.varAssign(this.m_arg1, "this.m_arg1", 1552, 48739, 48752);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context313.methodEnd();
            }
        }

        public void set(int action, Object arg1, Object arg2) {
            MethodContext _bcornu_methode_context314 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1555, 48773, 48930);
                CallChecker.varInit(arg2, "arg2", 1555, 48773, 48930);
                CallChecker.varInit(arg1, "arg1", 1555, 48773, 48930);
                CallChecker.varInit(action, "action", 1555, 48773, 48930);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1555, 48773, 48930);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1555, 48773, 48930);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1555, 48773, 48930);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1555, 48773, 48930);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1555, 48773, 48930);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1555, 48773, 48930);
                CallChecker.varInit(this.m_action, "m_action", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1555, 48773, 48930);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1555, 48773, 48930);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1555, 48773, 48930);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1555, 48773, 48930);
                m_action = action;
                CallChecker.varAssign(this.m_action, "this.m_action", 1557, 48849, 48866);
                m_arg1 = arg1;
                CallChecker.varAssign(this.m_arg1, "this.m_arg1", 1558, 48880, 48893);
                m_arg2 = arg2;
                CallChecker.varAssign(this.m_arg2, "this.m_arg2", 1559, 48907, 48920);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context314.methodEnd();
            }
        }

        public void set(int action, Object arg1, Object arg2, Object arg3) {
            MethodContext _bcornu_methode_context315 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1562, 48941, 49138);
                CallChecker.varInit(arg3, "arg3", 1562, 48941, 49138);
                CallChecker.varInit(arg2, "arg2", 1562, 48941, 49138);
                CallChecker.varInit(arg1, "arg1", 1562, 48941, 49138);
                CallChecker.varInit(action, "action", 1562, 48941, 49138);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1562, 48941, 49138);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1562, 48941, 49138);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1562, 48941, 49138);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1562, 48941, 49138);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1562, 48941, 49138);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1562, 48941, 49138);
                CallChecker.varInit(this.m_action, "m_action", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1562, 48941, 49138);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1562, 48941, 49138);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1562, 48941, 49138);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1562, 48941, 49138);
                m_action = action;
                CallChecker.varAssign(this.m_action, "this.m_action", 1564, 49030, 49047);
                m_arg1 = arg1;
                CallChecker.varAssign(this.m_arg1, "this.m_arg1", 1565, 49061, 49074);
                m_arg2 = arg2;
                CallChecker.varAssign(this.m_arg2, "this.m_arg2", 1566, 49088, 49101);
                m_arg3 = arg3;
                CallChecker.varAssign(this.m_arg3, "this.m_arg3", 1567, 49115, 49128);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context315.methodEnd();
            }
        }

        public void set(int action, Object arg1, Object arg2, Object arg3, Object arg4) {
            MethodContext _bcornu_methode_context316 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1570, 49149, 49398);
                CallChecker.varInit(arg4, "arg4", 1570, 49149, 49398);
                CallChecker.varInit(arg3, "arg3", 1570, 49149, 49398);
                CallChecker.varInit(arg2, "arg2", 1570, 49149, 49398);
                CallChecker.varInit(arg1, "arg1", 1570, 49149, 49398);
                CallChecker.varInit(action, "action", 1570, 49149, 49398);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1570, 49149, 49398);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1570, 49149, 49398);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1570, 49149, 49398);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1570, 49149, 49398);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1570, 49149, 49398);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1570, 49149, 49398);
                CallChecker.varInit(this.m_action, "m_action", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1570, 49149, 49398);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1570, 49149, 49398);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1570, 49149, 49398);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1570, 49149, 49398);
                m_action = action;
                CallChecker.varAssign(this.m_action, "this.m_action", 1573, 49263, 49280);
                m_arg1 = arg1;
                CallChecker.varAssign(this.m_arg1, "this.m_arg1", 1574, 49294, 49307);
                m_arg2 = arg2;
                CallChecker.varAssign(this.m_arg2, "this.m_arg2", 1575, 49321, 49334);
                m_arg3 = arg3;
                CallChecker.varAssign(this.m_arg3, "this.m_arg3", 1576, 49348, 49361);
                m_arg4 = arg4;
                CallChecker.varAssign(this.m_arg4, "this.m_arg4", 1577, 49375, 49388);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context316.methodEnd();
            }
        }

        public void set(int action, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
            MethodContext _bcornu_methode_context317 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1580, 49409, 49698);
                CallChecker.varInit(arg5, "arg5", 1580, 49409, 49698);
                CallChecker.varInit(arg4, "arg4", 1580, 49409, 49698);
                CallChecker.varInit(arg3, "arg3", 1580, 49409, 49698);
                CallChecker.varInit(arg2, "arg2", 1580, 49409, 49698);
                CallChecker.varInit(arg1, "arg1", 1580, 49409, 49698);
                CallChecker.varInit(action, "action", 1580, 49409, 49698);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1580, 49409, 49698);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1580, 49409, 49698);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1580, 49409, 49698);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1580, 49409, 49698);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1580, 49409, 49698);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1580, 49409, 49698);
                CallChecker.varInit(this.m_action, "m_action", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1580, 49409, 49698);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1580, 49409, 49698);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1580, 49409, 49698);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1580, 49409, 49698);
                m_action = action;
                CallChecker.varAssign(this.m_action, "this.m_action", 1583, 49536, 49553);
                m_arg1 = arg1;
                CallChecker.varAssign(this.m_arg1, "this.m_arg1", 1584, 49567, 49580);
                m_arg2 = arg2;
                CallChecker.varAssign(this.m_arg2, "this.m_arg2", 1585, 49594, 49607);
                m_arg3 = arg3;
                CallChecker.varAssign(this.m_arg3, "this.m_arg3", 1586, 49621, 49634);
                m_arg4 = arg4;
                CallChecker.varAssign(this.m_arg4, "this.m_arg4", 1587, 49648, 49661);
                m_arg5 = arg5;
                CallChecker.varAssign(this.m_arg5, "this.m_arg5", 1588, 49675, 49688);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context317.methodEnd();
            }
        }

        public void set(int action, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
            MethodContext _bcornu_methode_context318 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1591, 49709, 50038);
                CallChecker.varInit(arg6, "arg6", 1591, 49709, 50038);
                CallChecker.varInit(arg5, "arg5", 1591, 49709, 50038);
                CallChecker.varInit(arg4, "arg4", 1591, 49709, 50038);
                CallChecker.varInit(arg3, "arg3", 1591, 49709, 50038);
                CallChecker.varInit(arg2, "arg2", 1591, 49709, 50038);
                CallChecker.varInit(arg1, "arg1", 1591, 49709, 50038);
                CallChecker.varInit(action, "action", 1591, 49709, 50038);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1591, 49709, 50038);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1591, 49709, 50038);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1591, 49709, 50038);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1591, 49709, 50038);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1591, 49709, 50038);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1591, 49709, 50038);
                CallChecker.varInit(this.m_action, "m_action", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1591, 49709, 50038);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1591, 49709, 50038);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1591, 49709, 50038);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1591, 49709, 50038);
                m_action = action;
                CallChecker.varAssign(this.m_action, "this.m_action", 1594, 49849, 49866);
                m_arg1 = arg1;
                CallChecker.varAssign(this.m_arg1, "this.m_arg1", 1595, 49880, 49893);
                m_arg2 = arg2;
                CallChecker.varAssign(this.m_arg2, "this.m_arg2", 1596, 49907, 49920);
                m_arg3 = arg3;
                CallChecker.varAssign(this.m_arg3, "this.m_arg3", 1597, 49934, 49947);
                m_arg4 = arg4;
                CallChecker.varAssign(this.m_arg4, "this.m_arg4", 1598, 49961, 49974);
                m_arg5 = arg5;
                CallChecker.varAssign(this.m_arg5, "this.m_arg5", 1599, 49988, 50001);
                m_arg6 = arg6;
                CallChecker.varAssign(this.m_arg6, "this.m_arg6", 1600, 50015, 50028);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context318.methodEnd();
            }
        }

        private void unset() {
            MethodContext _bcornu_methode_context319 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1603, 50049, 50277);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1603, 50049, 50277);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1603, 50049, 50277);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1603, 50049, 50277);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1603, 50049, 50277);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1603, 50049, 50277);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1603, 50049, 50277);
                CallChecker.varInit(this.m_action, "m_action", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1603, 50049, 50277);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1603, 50049, 50277);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1603, 50049, 50277);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1603, 50049, 50277);
                m_action = -1;
                CallChecker.varAssign(this.m_action, "this.m_action", 1605, 50092, 50105);
                m_arg1 = null;
                CallChecker.varAssign(this.m_arg1, "this.m_arg1", 1606, 50119, 50132);
                m_arg2 = null;
                CallChecker.varAssign(this.m_arg2, "this.m_arg2", 1607, 50146, 50159);
                m_arg3 = null;
                CallChecker.varAssign(this.m_arg3, "this.m_arg3", 1608, 50173, 50186);
                m_arg4 = null;
                CallChecker.varAssign(this.m_arg4, "this.m_arg4", 1609, 50200, 50213);
                m_arg5 = null;
                CallChecker.varAssign(this.m_arg5, "this.m_arg5", 1610, 50227, 50240);
                m_arg6 = null;
                CallChecker.varAssign(this.m_arg6, "this.m_arg6", 1611, 50254, 50267);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context319.methodEnd();
            }
        }

        public Object run() throws Exception {
            MethodContext _bcornu_methode_context320 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 1614, 50288, 60131);
                CallChecker.varInit(this.m_arg6, "m_arg6", 1614, 50288, 60131);
                CallChecker.varInit(this.m_arg5, "m_arg5", 1614, 50288, 60131);
                CallChecker.varInit(this.m_arg4, "m_arg4", 1614, 50288, 60131);
                CallChecker.varInit(this.m_arg3, "m_arg3", 1614, 50288, 60131);
                CallChecker.varInit(this.m_arg2, "m_arg2", 1614, 50288, 60131);
                CallChecker.varInit(this.m_arg1, "m_arg1", 1614, 50288, 60131);
                CallChecker.varInit(this.m_action, "m_action", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_WOVEN_CLASS_LISTENER, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER", 1614, 50288, 60131);
                CallChecker.varInit(DELETE_FILEONEXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILEONEXIT_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(OPEN_JARFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_JARFILE_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_BUNDLE_COLLISION_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_END, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_END", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_MATCHES, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_SINGLETON, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_RESOLVABLE, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_RESOLVER_HOOK_FACTORY, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_LISTENER_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_REMOVED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_SERVICE_LISTENER_HOOK_ADDED, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_SERVICE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_SERVICE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_WEAVING_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_WEAVING_HOOK", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_BUNDLE_EVENT_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_BUNDLE_FIND_HOOK, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK", 1614, 50288, 60131);
                CallChecker.varInit(GET_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CLASS_LOADER_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(FLUSH_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FLUSH_FIELD_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(SYSTEM_EXIT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SYSTEM_EXIT_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(SWAP_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SWAP_FIELD_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(STOP_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.STOP_ACTIVATOR_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(START_ACTIVATOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.START_ACTIVATOR_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(SET_ACCESSIBLE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.SET_ACCESSIBLE_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(RENAME_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.RENAME_FILE_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(OPEN_URLCONNECTION_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_URLCONNECTION_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(OPEN_ZIPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.OPEN_ZIPFILE_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(MAKE_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORY_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(MAKE_DIRECTORIES_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.MAKE_DIRECTORIES_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(LIST_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.LIST_DIRECTORY_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_METHOD_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_DIRECTMETHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(INVOKE_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_URL_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_URL_INPUT_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_SYSTEM_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_PARENT_CLASS_LOADER_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_PROPERTY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_PROPERTY_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_POLICY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_POLICY_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_METHOD_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(TO_URI_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.TO_URI_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_FILE_OUTPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_OUTPUT_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_FILE_INPUT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FILE_INPUT_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_FIELD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_FIELD_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_DECLARED_METHOD_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_METHOD_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_DECLARED_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_CONSTRUCTOR_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_CONSTRUCTOR_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(GET_ABSOLUTE_PATH_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(FOR_NAME_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FOR_NAME_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(FILE_IS_DIRECTORY_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_IS_DIRECTORY_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(FILE_EXISTS_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.FILE_EXISTS_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(EXEC_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.EXEC_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(DELETE_FILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.DELETE_FILE_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(CREATE_URL_WITH_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(CREATE_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_URL_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(CREATE_TMPFILE_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.CREATE_TMPFILE_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(ADD_EXTENSION_URL_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.ADD_EXTENSION_URL_ACTION", 1614, 50288, 60131);
                CallChecker.varInit(INITIALIZE_CONTEXT_ACTION, "org.apache.felix.framework.util.SecureAction.Actions.INITIALIZE_CONTEXT_ACTION", 1614, 50288, 60131);
                int action = CallChecker.varInit(((int) (this.m_action)), "action", 1616, 50347, 50369);
                Object arg1 = CallChecker.varInit(m_arg1, "arg1", 1617, 50383, 50403);
                Object arg2 = CallChecker.varInit(m_arg2, "arg2", 1618, 50417, 50437);
                Object arg3 = CallChecker.varInit(m_arg3, "arg3", 1619, 50451, 50471);
                Object arg4 = CallChecker.varInit(m_arg4, "arg4", 1620, 50485, 50505);
                Object arg5 = CallChecker.varInit(m_arg5, "arg5", 1621, 50519, 50539);
                Object arg6 = CallChecker.varInit(m_arg6, "arg6", 1622, 50553, 50573);
                unset();
                switch (action) {
                    case SecureAction.Actions.INITIALIZE_CONTEXT_ACTION :
                        return AccessController.getContext();
                    case SecureAction.Actions.ADD_EXTENSION_URL_ACTION :
                        Method addURL = CallChecker.varInit(URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{ URL.class }), "addURL", 1631, 50813, 50950);
                        if (CallChecker.beforeDeref(addURL, Method.class, 1634, 50972, 50977)) {
                            addURL = CallChecker.beforeCalled(addURL, Method.class, 1634, 50972, 50977);
                            CallChecker.isCalled(addURL, Method.class, 1634, 50972, 50977).setAccessible(true);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(addURL, Method.class, 1635, 51020, 51025)) {
                            addURL = CallChecker.beforeCalled(addURL, Method.class, 1635, 51020, 51025);
                            CallChecker.isCalled(addURL, Method.class, 1635, 51020, 51025).invoke(arg2, new Object[]{ arg1 });
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.CREATE_TMPFILE_ACTION :
                        return File.createTempFile(((String) (arg1)), ((String) (arg2)), ((File) (arg3)));
                    case SecureAction.Actions.CREATE_URL_ACTION :
                        if (CallChecker.beforeDeref(arg3, Object.class, 1641, 51369, 51372)) {
                            arg3 = CallChecker.beforeCalled(arg3, Integer.class, 1641, 51369, 51372);
                            return new URL(((String) (arg1)), ((String) (arg2)), CallChecker.isCalled(((Integer) (arg3)), Integer.class, 1641, 51369, 51372).intValue(), ((String) (arg4)), ((URLStreamHandler) (arg5)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.CREATE_URL_WITH_CONTEXT_ACTION :
                        return new URL(((URL) (arg1)), ((String) (arg2)), ((URLStreamHandler) (arg3)));
                    case SecureAction.Actions.DELETE_FILE_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1646, 51669, 51672)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1646, 51669, 51672);
                            if (CallChecker.isCalled(((File) (arg1)), File.class, 1646, 51669, 51672).delete()) {
                                return Boolean.TRUE;
                            }else {
                                return Boolean.FALSE;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.EXEC_ACTION :
                        if (CallChecker.beforeDeref(Runtime.getRuntime(), Runtime.class, 1648, 51777, 51796)) {
                            return CallChecker.isCalled(Runtime.getRuntime(), Runtime.class, 1648, 51777, 51796).exec(((String) (arg1)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.FILE_EXISTS_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1650, 51895, 51898)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1650, 51895, 51898);
                            if (CallChecker.isCalled(((File) (arg1)), File.class, 1650, 51895, 51898).exists()) {
                                return Boolean.TRUE;
                            }else {
                                return Boolean.FALSE;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.FILE_IS_DIRECTORY_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1652, 52024, 52027)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1652, 52024, 52027);
                            if (CallChecker.isCalled(((File) (arg1)), File.class, 1652, 52024, 52027).isDirectory()) {
                                return Boolean.TRUE;
                            }else {
                                return Boolean.FALSE;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.FOR_NAME_ACTION :
                        if (arg2 == null) {
                            return Class.forName(((String) (arg1)));
                        }else {
                            return Class.forName(((String) (arg1)), true, ((ClassLoader) (arg2)));
                        }
                    case SecureAction.Actions.GET_ABSOLUTE_PATH_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1657, 52351, 52354)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1657, 52351, 52354);
                            return CallChecker.isCalled(((File) (arg1)), File.class, 1657, 52351, 52354).getAbsolutePath();
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_CONSTRUCTOR_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1659, 52457, 52460)) {
                            arg1 = CallChecker.beforeCalled(arg1, Class.class, 1659, 52457, 52460);
                            return CallChecker.isCalled(((Class) (arg1)), Class.class, 1659, 52457, 52460).getConstructor(((Class[]) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_DECLARED_CONSTRUCTOR_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1661, 52585, 52588)) {
                            arg1 = CallChecker.beforeCalled(arg1, Class.class, 1661, 52585, 52588);
                            return CallChecker.isCalled(((Class) (arg1)), Class.class, 1661, 52585, 52588).getDeclaredConstructor(((Class[]) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_DECLARED_METHOD_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1663, 52716, 52719)) {
                            arg1 = CallChecker.beforeCalled(arg1, Class.class, 1663, 52716, 52719);
                            return CallChecker.isCalled(((Class) (arg1)), Class.class, 1663, 52716, 52719).getDeclaredMethod(((String) (arg2)), ((Class[]) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_FIELD_ACTION :
                        Field field = CallChecker.init(Field.class);
                        if (CallChecker.beforeDeref(arg1, Object.class, 1665, 52854, 52857)) {
                            arg1 = CallChecker.beforeCalled(arg1, Class.class, 1665, 52854, 52857);
                            field = CallChecker.isCalled(((Class) (arg1)), Class.class, 1665, 52854, 52857).getDeclaredField(((String) (arg2)));
                            CallChecker.varAssign(field, "field", 1665, 52854, 52857);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(field, Field.class, 1666, 52913, 52917)) {
                            field = CallChecker.beforeCalled(field, Field.class, 1666, 52913, 52917);
                            CallChecker.isCalled(field, Field.class, 1666, 52913, 52917).setAccessible(true);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(field, Field.class, 1667, 52967, 52971)) {
                            field = CallChecker.beforeCalled(field, Field.class, 1667, 52967, 52971);
                            return CallChecker.isCalled(field, Field.class, 1667, 52967, 52971).get(arg3);
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_FILE_INPUT_ACTION :
                        return new FileInputStream(((File) (arg1)));
                    case SecureAction.Actions.GET_FILE_OUTPUT_ACTION :
                        return new FileOutputStream(((File) (arg1)));
                    case SecureAction.Actions.TO_URI_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1673, 53267, 53270)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1673, 53267, 53270);
                            return CallChecker.isCalled(((File) (arg1)), File.class, 1673, 53267, 53270).toURI();
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_METHOD_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1675, 53358, 53361)) {
                            arg1 = CallChecker.beforeCalled(arg1, Class.class, 1675, 53358, 53361);
                            return CallChecker.isCalled(((Class) (arg1)), Class.class, 1675, 53358, 53361).getMethod(((String) (arg2)), ((Class[]) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_POLICY_ACTION :
                        return Policy.getPolicy();
                    case SecureAction.Actions.GET_PROPERTY_ACTION :
                        return System.getProperty(((String) (arg1)), ((String) (arg2)));
                    case SecureAction.Actions.GET_PARENT_CLASS_LOADER_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1681, 53707, 53710)) {
                            arg1 = CallChecker.beforeCalled(arg1, ClassLoader.class, 1681, 53707, 53710);
                            return CallChecker.isCalled(((ClassLoader) (arg1)), ClassLoader.class, 1681, 53707, 53710).getParent();
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.GET_SYSTEM_CLASS_LOADER_ACTION :
                        return ClassLoader.getSystemClassLoader();
                    case SecureAction.Actions.GET_URL_INPUT_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1685, 53929, 53932)) {
                            arg1 = CallChecker.beforeCalled(arg1, URLConnection.class, 1685, 53929, 53932);
                            return CallChecker.isCalled(((URLConnection) (arg1)), URLConnection.class, 1685, 53929, 53932).getInputStream();
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.INVOKE_CONSTRUCTOR_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1687, 54043, 54046)) {
                            arg1 = CallChecker.beforeCalled(arg1, Constructor.class, 1687, 54043, 54046);
                            return CallChecker.isCalled(((Constructor) (arg1)), Constructor.class, 1687, 54043, 54046).newInstance(((Object[]) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.INVOKE_DIRECTMETHOD_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1689, 54165, 54168)) {
                            arg1 = CallChecker.beforeCalled(arg1, Method.class, 1689, 54165, 54168);
                            return CallChecker.isCalled(((Method) (arg1)), Method.class, 1689, 54165, 54168).invoke(arg2, ((Object[]) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.INVOKE_METHOD_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1691, 54275, 54278)) {
                            arg1 = CallChecker.beforeCalled(arg1, Method.class, 1691, 54275, 54278);
                            CallChecker.isCalled(((Method) (arg1)), Method.class, 1691, 54275, 54278).setAccessible(true);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(arg1, Object.class, 1692, 54339, 54342)) {
                            arg1 = CallChecker.beforeCalled(arg1, Method.class, 1692, 54339, 54342);
                            return CallChecker.isCalled(((Method) (arg1)), Method.class, 1692, 54339, 54342).invoke(arg2, ((Object[]) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.LIST_DIRECTORY_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1694, 54455, 54458)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1694, 54455, 54458);
                            return CallChecker.isCalled(((File) (arg1)), File.class, 1694, 54455, 54458).listFiles();
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.MAKE_DIRECTORIES_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1696, 54555, 54558)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1696, 54555, 54558);
                            if (CallChecker.isCalled(((File) (arg1)), File.class, 1696, 54555, 54558).mkdirs()) {
                                return Boolean.TRUE;
                            }else {
                                return Boolean.FALSE;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.MAKE_DIRECTORY_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1698, 54681, 54684)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1698, 54681, 54684);
                            if (CallChecker.isCalled(((File) (arg1)), File.class, 1698, 54681, 54684).mkdir()) {
                                return Boolean.TRUE;
                            }else {
                                return Boolean.FALSE;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.OPEN_ZIPFILE_ACTION :
                        return new ZipFile(((File) (arg1)));
                    case SecureAction.Actions.OPEN_URLCONNECTION_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1702, 54904, 54907)) {
                            arg1 = CallChecker.beforeCalled(arg1, URL.class, 1702, 54904, 54907);
                            return CallChecker.isCalled(((URL) (arg1)), URL.class, 1702, 54904, 54907).openConnection();
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.RENAME_FILE_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1704, 55004, 55007)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1704, 55004, 55007);
                            if (CallChecker.isCalled(((File) (arg1)), File.class, 1704, 55004, 55007).renameTo(((File) (arg2)))) {
                                return Boolean.TRUE;
                            }else {
                                return Boolean.FALSE;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.SET_ACCESSIBLE_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1706, 55148, 55151)) {
                            arg1 = CallChecker.beforeCalled(arg1, AccessibleObject.class, 1706, 55148, 55151);
                            CallChecker.isCalled(((AccessibleObject) (arg1)), AccessibleObject.class, 1706, 55148, 55151).setAccessible(true);
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.START_ACTIVATOR_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1709, 55292, 55295)) {
                            arg1 = CallChecker.beforeCalled(arg1, BundleActivator.class, 1709, 55292, 55295);
                            CallChecker.isCalled(((BundleActivator) (arg1)), BundleActivator.class, 1709, 55292, 55295).start(((BundleContext) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.STOP_ACTIVATOR_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1712, 55443, 55446)) {
                            arg1 = CallChecker.beforeCalled(arg1, BundleActivator.class, 1712, 55443, 55446);
                            CallChecker.isCalled(((BundleActivator) (arg1)), BundleActivator.class, 1712, 55443, 55446).stop(((BundleContext) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.SWAP_FIELD_ACTION :
                        return SecureAction._swapStaticFieldIfNotClass(((Class) (arg1)), ((Class) (arg2)), ((Class) (arg3)), ((String) (arg4)));
                    case SecureAction.Actions.SYSTEM_EXIT_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1718, 55770, 55773)) {
                            arg1 = CallChecker.beforeCalled(arg1, Integer.class, 1718, 55770, 55773);
                            System.exit(CallChecker.isCalled(((Integer) (arg1)), Integer.class, 1718, 55770, 55773).intValue());
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.FLUSH_FIELD_ACTION :
                        SecureAction._flush(((Class) (arg1)), arg2);
                        return null;
                    case SecureAction.Actions.GET_CLASS_LOADER_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1723, 55995, 55998)) {
                            arg1 = CallChecker.beforeCalled(arg1, Class.class, 1723, 55995, 55998);
                            return CallChecker.isCalled(((Class) (arg1)), Class.class, 1723, 55995, 55998).getClassLoader();
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.INVOKE_BUNDLE_FIND_HOOK :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1725, 56129, 56132)) {
                            arg1 = CallChecker.beforeCalled(arg1, FindHook.class, 1725, 56129, 56132);
                            CallChecker.isCalled(((FindHook) (arg1)), FindHook.class, 1725, 56129, 56132).find(((BundleContext) (arg2)), ((Collection<Bundle>) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_BUNDLE_EVENT_HOOK :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1729, 56360, 56363)) {
                            arg1 = CallChecker.beforeCalled(arg1, EventHook.class, 1729, 56360, 56363);
                            CallChecker.isCalled(((EventHook) (arg1)), EventHook.class, 1729, 56360, 56363).event(((BundleEvent) (arg2)), ((Collection<BundleContext>) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_WEAVING_HOOK :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1733, 56595, 56598)) {
                            arg1 = CallChecker.beforeCalled(arg1, WeavingHook.class, 1733, 56595, 56598);
                            CallChecker.isCalled(((WeavingHook) (arg1)), WeavingHook.class, 1733, 56595, 56598).weave(((WovenClass) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_SERVICE_EVENT_HOOK :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1737, 56832, 56835)) {
                            arg1 = CallChecker.beforeCalled(arg1, org.osgi.framework.hooks.service.EventHook.class, 1737, 56832, 56835);
                            CallChecker.isCalled(((org.osgi.framework.hooks.service.EventHook) (arg1)), org.osgi.framework.hooks.service.EventHook.class, 1737, 56832, 56835).event(((ServiceEvent) (arg2)), ((Collection<BundleContext>) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_SERVICE_FIND_HOOK :
                        if (CallChecker.beforeDeref(arg5, Object.class, 1743, 57193, 57196)) {
                            if (CallChecker.beforeDeref(arg1, Object.class, 1741, 57070, 57073)) {
                                arg5 = CallChecker.beforeCalled(arg5, Boolean.class, 1743, 57193, 57196);
                                arg1 = CallChecker.beforeCalled(arg1, org.osgi.framework.hooks.service.FindHook.class, 1741, 57070, 57073);
                                CallChecker.isCalled(((org.osgi.framework.hooks.service.FindHook) (arg1)), org.osgi.framework.hooks.service.FindHook.class, 1741, 57070, 57073).find(((BundleContext) (arg2)), ((String) (arg3)), ((String) (arg4)), CallChecker.isCalled(((Boolean) (arg5)), Boolean.class, 1743, 57193, 57196).booleanValue(), ((Collection<ServiceReference<?>>) (arg6)));
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_ADDED :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1747, 57439, 57442)) {
                            arg1 = CallChecker.beforeCalled(arg1, ListenerHook.class, 1747, 57439, 57442);
                            CallChecker.isCalled(((ListenerHook) (arg1)), ListenerHook.class, 1747, 57439, 57442).added(((Collection<ListenerHook.ListenerInfo>) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_SERVICE_LISTENER_HOOK_REMOVED :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1751, 57684, 57687)) {
                            arg1 = CallChecker.beforeCalled(arg1, ListenerHook.class, 1751, 57684, 57687);
                            CallChecker.isCalled(((ListenerHook) (arg1)), ListenerHook.class, 1751, 57684, 57687).removed(((Collection<ListenerHook.ListenerInfo>) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_SERVICE_EVENT_LISTENER_HOOK :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1755, 57934, 57937)) {
                            arg1 = CallChecker.beforeCalled(arg1, EventListenerHook.class, 1755, 57934, 57937);
                            CallChecker.isCalled(((EventListenerHook) (arg1)), EventListenerHook.class, 1755, 57934, 57937).event(((ServiceEvent) (arg2)), ((Map<BundleContext, Collection<ListenerHook.ListenerInfo>>) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_RESOLVER_HOOK_FACTORY :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1760, 58251, 58254)) {
                            arg1 = CallChecker.beforeCalled(arg1, ResolverHookFactory.class, 1760, 58251, 58254);
                            return CallChecker.isCalled(((ResolverHookFactory) (arg1)), ResolverHookFactory.class, 1760, 58251, 58254).begin(((Collection<BundleRevision>) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                    case SecureAction.Actions.INVOKE_RESOLVER_HOOK_RESOLVABLE :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1763, 58448, 58451)) {
                            arg1 = CallChecker.beforeCalled(arg1, ResolverHook.class, 1763, 58448, 58451);
                            CallChecker.isCalled(((ResolverHook) (arg1)), ResolverHook.class, 1763, 58448, 58451).filterResolvable(((Collection<BundleRevision>) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_RESOLVER_HOOK_SINGLETON :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1767, 58688, 58691)) {
                            arg1 = CallChecker.beforeCalled(arg1, ResolverHook.class, 1767, 58688, 58691);
                            CallChecker.isCalled(((ResolverHook) (arg1)), ResolverHook.class, 1767, 58688, 58691).filterSingletonCollisions(((BundleCapability) (arg2)), ((Collection<BundleCapability>) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_RESOLVER_HOOK_MATCHES :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1773, 59019, 59022)) {
                            arg1 = CallChecker.beforeCalled(arg1, ResolverHook.class, 1773, 59019, 59022);
                            CallChecker.isCalled(((ResolverHook) (arg1)), ResolverHook.class, 1773, 59019, 59022).filterMatches(((BundleRequirement) (arg2)), ((Collection<BundleCapability>) (arg3)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_RESOLVER_HOOK_END :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1778, 59302, 59305)) {
                            arg1 = CallChecker.beforeCalled(arg1, ResolverHook.class, 1778, 59302, 59305);
                            CallChecker.isCalled(((ResolverHook) (arg1)), ResolverHook.class, 1778, 59302, 59305).end();
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_BUNDLE_COLLISION_HOOK :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1781, 59468, 59471)) {
                            arg1 = CallChecker.beforeCalled(arg1, CollisionHook.class, 1781, 59468, 59471);
                            CallChecker.isCalled(((CollisionHook) (arg1)), CollisionHook.class, 1781, 59468, 59471).filterCollisions(((Integer) (arg2)), ((Bundle) (arg3)), ((Collection<Bundle>) (arg4)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.OPEN_JARFILE_ACTION :
                        return new JarFile(((File) (arg1)));
                    case SecureAction.Actions.DELETE_FILEONEXIT_ACTION :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1787, 59777, 59780)) {
                            arg1 = CallChecker.beforeCalled(arg1, File.class, 1787, 59777, 59780);
                            CallChecker.isCalled(((File) (arg1)), File.class, 1787, 59777, 59780).deleteOnExit();
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                    case SecureAction.Actions.INVOKE_WOVEN_CLASS_LISTENER :
                        if (CallChecker.beforeDeref(arg1, Object.class, 1790, 59957, 59960)) {
                            arg1 = CallChecker.beforeCalled(arg1, WovenClassListener.class, 1790, 59957, 59960);
                            CallChecker.isCalled(((WovenClassListener) (arg1)), WovenClassListener.class, 1790, 59957, 59960).modified(((WovenClass) (arg2)));
                        }else
                            throw new AbnormalExecutionError();
                        
                        return null;
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context320.methodEnd();
            }
        }
    }
}

