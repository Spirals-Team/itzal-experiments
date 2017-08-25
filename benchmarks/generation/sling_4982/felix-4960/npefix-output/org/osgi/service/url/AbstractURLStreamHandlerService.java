package org.osgi.service.url;

import java.net.URLStreamHandler;
import java.net.URLConnection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.annotation.versioning.ConsumerType;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.net.InetAddress;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.net.URL;

@ConsumerType
public abstract class AbstractURLStreamHandlerService extends URLStreamHandler implements URLStreamHandlerService {
    @Override
    public abstract URLConnection openConnection(URL u) throws IOException;

    protected volatile URLStreamHandlerSetter realHandler;

    public void parseURL(@SuppressWarnings(value = "hiding")
    URLStreamHandlerSetter realHandler, URL u, String spec, int start, int limit) {
        MethodContext _bcornu_methode_context525 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 59, 1777, 2390);
            CallChecker.varInit(limit, "limit", 59, 1777, 2390);
            CallChecker.varInit(start, "start", 59, 1777, 2390);
            CallChecker.varInit(spec, "spec", 59, 1777, 2390);
            CallChecker.varInit(u, "u", 59, 1777, 2390);
            CallChecker.varInit(realHandler, "realHandler", 59, 1777, 2390);
            CallChecker.varInit(this.realHandler, "realHandler", 59, 1777, 2390);
            this.realHandler = realHandler;
            CallChecker.varAssign(this.realHandler, "this.realHandler", 60, 2322, 2352);
            parseURL(u, spec, start, limit);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context525.methodEnd();
        }
    }

    @Override
    public String toExternalForm(URL u) {
        MethodContext _bcornu_methode_context526 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 70, 2394, 2597);
            CallChecker.varInit(u, "u", 70, 2394, 2597);
            CallChecker.varInit(this.realHandler, "realHandler", 70, 2394, 2597);
            return super.toExternalForm(u);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context526.methodEnd();
        }
    }

    @Override
    public boolean equals(URL u1, URL u2) {
        MethodContext _bcornu_methode_context527 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 80, 2601, 2805);
            CallChecker.varInit(u2, "u2", 80, 2601, 2805);
            CallChecker.varInit(u1, "u1", 80, 2601, 2805);
            CallChecker.varInit(this.realHandler, "realHandler", 80, 2601, 2805);
            return super.equals(u1, u2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context527.methodEnd();
        }
    }

    @Override
    public int getDefaultPort() {
        MethodContext _bcornu_methode_context528 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 90, 2809, 3003);
            CallChecker.varInit(this.realHandler, "realHandler", 90, 2809, 3003);
            return super.getDefaultPort();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context528.methodEnd();
        }
    }

    @Override
    public InetAddress getHostAddress(URL u) {
        MethodContext _bcornu_methode_context529 = new MethodContext(InetAddress.class);
        try {
            CallChecker.varInit(this, "this", 100, 3007, 3215);
            CallChecker.varInit(u, "u", 100, 3007, 3215);
            CallChecker.varInit(this.realHandler, "realHandler", 100, 3007, 3215);
            return super.getHostAddress(u);
        } catch (ForceReturn _bcornu_return_t) {
            return ((InetAddress) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context529.methodEnd();
        }
    }

    @Override
    public int hashCode(URL u) {
        MethodContext _bcornu_methode_context530 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 110, 3219, 3405);
            CallChecker.varInit(u, "u", 110, 3219, 3405);
            CallChecker.varInit(this.realHandler, "realHandler", 110, 3219, 3405);
            return super.hashCode(u);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context530.methodEnd();
        }
    }

    @Override
    public boolean hostsEqual(URL u1, URL u2) {
        MethodContext _bcornu_methode_context531 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 120, 3409, 3611);
            CallChecker.varInit(u2, "u2", 120, 3409, 3611);
            CallChecker.varInit(u1, "u1", 120, 3409, 3611);
            CallChecker.varInit(this.realHandler, "realHandler", 120, 3409, 3611);
            return super.hostsEqual(u1, u2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context531.methodEnd();
        }
    }

    @Override
    public boolean sameFile(URL u1, URL u2) {
        MethodContext _bcornu_methode_context532 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 130, 3615, 3809);
            CallChecker.varInit(u2, "u2", 130, 3615, 3809);
            CallChecker.varInit(u1, "u1", 130, 3615, 3809);
            CallChecker.varInit(this.realHandler, "realHandler", 130, 3615, 3809);
            return super.sameFile(u1, u2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context532.methodEnd();
        }
    }

    @SuppressWarnings(value = "javadoc")
    protected void setURL(URL u, String proto, String host, int port, String file, String ref) {
        MethodContext _bcornu_methode_context533 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 143, 3813, 4284);
            CallChecker.varInit(ref, "ref", 143, 3813, 4284);
            CallChecker.varInit(file, "file", 143, 3813, 4284);
            CallChecker.varInit(port, "port", 143, 3813, 4284);
            CallChecker.varInit(host, "host", 143, 3813, 4284);
            CallChecker.varInit(proto, "proto", 143, 3813, 4284);
            CallChecker.varInit(u, "u", 143, 3813, 4284);
            CallChecker.varInit(this.realHandler, "realHandler", 143, 3813, 4284);
            if (CallChecker.beforeDeref(realHandler, URLStreamHandlerSetter.class, 144, 4230, 4240)) {
                realHandler = CallChecker.beforeCalled(realHandler, URLStreamHandlerSetter.class, 144, 4230, 4240);
                CallChecker.isCalled(realHandler, URLStreamHandlerSetter.class, 144, 4230, 4240).setURL(u, proto, host, port, file, ref);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context533.methodEnd();
        }
    }

    @Override
    protected void setURL(URL u, String proto, String host, int port, String auth, String user, String path, String query, String ref) {
        MethodContext _bcornu_methode_context534 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 155, 4288, 4727);
            CallChecker.varInit(ref, "ref", 155, 4288, 4727);
            CallChecker.varInit(query, "query", 155, 4288, 4727);
            CallChecker.varInit(path, "path", 155, 4288, 4727);
            CallChecker.varInit(user, "user", 155, 4288, 4727);
            CallChecker.varInit(auth, "auth", 155, 4288, 4727);
            CallChecker.varInit(port, "port", 155, 4288, 4727);
            CallChecker.varInit(host, "host", 155, 4288, 4727);
            CallChecker.varInit(proto, "proto", 155, 4288, 4727);
            CallChecker.varInit(u, "u", 155, 4288, 4727);
            CallChecker.varInit(this.realHandler, "realHandler", 155, 4288, 4727);
            if (CallChecker.beforeDeref(realHandler, URLStreamHandlerSetter.class, 156, 4654, 4664)) {
                realHandler = CallChecker.beforeCalled(realHandler, URLStreamHandlerSetter.class, 156, 4654, 4664);
                CallChecker.isCalled(realHandler, URLStreamHandlerSetter.class, 156, 4654, 4664).setURL(u, proto, host, port, auth, user, path, query, ref);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context534.methodEnd();
        }
    }
}

