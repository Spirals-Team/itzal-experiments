package org.apache.felix.framework;

import org.apache.felix.framework.util.Util;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.security.Permission;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.List;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRevisions;
import org.osgi.framework.wiring.BundleWiring;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.InputStream;

class URLHandlersBundleURLConnection extends URLConnection {
    private Felix m_framework;

    private BundleRevision m_targetRevision;

    private int m_classPathIdx = -1;

    private int m_contentLength;

    private long m_contentTime;

    private String m_contentType;

    private InputStream m_is;

    public URLHandlersBundleURLConnection(URL url) {
        super(url);
        MethodContext _bcornu_methode_context167 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context167.methodEnd();
        }
    }

    public URLHandlersBundleURLConnection(URL url, Felix framework) throws IOException {
        super(url);
        MethodContext _bcornu_methode_context168 = new MethodContext(null);
        try {
            String path = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(url, URL.class, 57, 1999, 2001)) {
                url = CallChecker.beforeCalled(url, URL.class, 57, 1999, 2001);
                path = CallChecker.isCalled(url, URL.class, 57, 1999, 2001).getPath();
                CallChecker.varAssign(path, "path", 57, 1999, 2001);
            }
            if (((path == null) || ((path.length()) == 0)) || (path.equals("/"))) {
                throw new IOException(("Resource does not exist: " + url));
            }
            m_framework = framework;
            CallChecker.varAssign(this.m_framework, "this.m_framework", 63, 2185, 2208);
            if ((m_framework) == null) {
                Object tmp = CallChecker.varInit(URLHandlers.getFrameworkFromContext(), "tmp", 69, 2366, 2416);
                if (tmp instanceof Felix) {
                    m_framework = ((Felix) (tmp));
                    CallChecker.varAssign(this.m_framework, "this.m_framework", 72, 2486, 2511);
                }
            }
            if ((m_framework) == null) {
                throw new IOException(("Unable to find framework for URL: " + url));
            }
            long bundleId = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(url, URL.class, 85, 3026, 3028)) {
                url = CallChecker.beforeCalled(url, URL.class, 85, 3026, 3028);
                bundleId = Util.getBundleIdFromRevisionId(CallChecker.isCalled(url, URL.class, 85, 3026, 3028).getHost());
                CallChecker.varAssign(bundleId, "bundleId", 85, 3026, 3028);
            }
            Bundle bundle = CallChecker.varInit(m_framework.getBundle(bundleId), "bundle", 86, 3050, 3097);
            if (bundle == null) {
                throw new IOException(("No bundle associated with resource: " + url));
            }
            m_contentTime = bundle.getLastModified();
            CallChecker.varAssign(this.m_contentTime, "this.m_contentTime", 91, 3236, 3276);
            BundleRevisions revisions = CallChecker.varInit(bundle.adapt(BundleRevisions.class), "revisions", 94, 3354, 3417);
            revisions = CallChecker.beforeCalled(revisions, BundleRevisions.class, 95, 3454, 3462);
            final List<BundleRevision> npe_invocation_var558 = CallChecker.isCalled(revisions, BundleRevisions.class, 95, 3454, 3462).getRevisions();
            if (CallChecker.beforeDeref(npe_invocation_var558, List.class, 95, 3454, 3477)) {
                if ((revisions == null) || (CallChecker.isCalled(npe_invocation_var558, List.class, 95, 3454, 3477).isEmpty())) {
                    throw new IOException(("Resource does not exist: " + url));
                }
            }else
                throw new AbnormalExecutionError();
            
            for (BundleRevision br : revisions.getRevisions()) {
                if (CallChecker.beforeDeref(br, BundleRevision.class, 103, 3734, 3735)) {
                    if (CallChecker.beforeDeref(url, URL.class, 103, 3753, 3755)) {
                        final String npe_invocation_var559 = CallChecker.isCalled(((BundleRevisionImpl) (br)), BundleRevisionImpl.class, 103, 3734, 3735).getId();
                        if (CallChecker.beforeDeref(npe_invocation_var559, String.class, 103, 3712, 3744)) {
                            url = CallChecker.beforeCalled(url, URL.class, 103, 3753, 3755);
                            if (CallChecker.isCalled(npe_invocation_var559, String.class, 103, 3712, 3744).equals(CallChecker.isCalled(url, URL.class, 103, 3753, 3755).getHost())) {
                                m_targetRevision = br;
                                CallChecker.varAssign(this.m_targetRevision, "this.m_targetRevision", 105, 3799, 3820);
                                break;
                            }
                        }
                    }
                }
            }
            if ((m_targetRevision) == null) {
                revisions = CallChecker.beforeCalled(revisions, BundleRevisions.class, 113, 4003, 4011);
                final List<BundleRevision> npe_invocation_var560 = CallChecker.isCalled(revisions, BundleRevisions.class, 113, 4003, 4011).getRevisions();
                if (CallChecker.beforeDeref(npe_invocation_var560, List.class, 113, 4003, 4026)) {
                    m_targetRevision = CallChecker.isCalled(npe_invocation_var560, List.class, 113, 4003, 4026).get(0);
                    CallChecker.varAssign(this.m_targetRevision, "this.m_targetRevision", 113, 3984, 4034);
                }
            }
            if (CallChecker.beforeDeref(url, URL.class, 123, 4571, 4573)) {
                url = CallChecker.beforeCalled(url, URL.class, 123, 4571, 4573);
                m_classPathIdx = CallChecker.isCalled(url, URL.class, 123, 4571, 4573).getPort();
                CallChecker.varAssign(this.m_classPathIdx, "this.m_classPathIdx", 123, 4554, 4584);
            }
            if ((m_classPathIdx) < 0) {
                m_classPathIdx = 0;
                CallChecker.varAssign(this.m_classPathIdx, "this.m_classPathIdx", 126, 4640, 4658);
            }
            if (CallChecker.beforeDeref(url, URL.class, 129, 4767, 4769)) {
                if (CallChecker.beforeDeref(m_targetRevision, BundleRevision.class, 128, 4705, 4720)) {
                    url = CallChecker.beforeCalled(url, URL.class, 129, 4767, 4769);
                    m_targetRevision = CallChecker.beforeCalled(m_targetRevision, BundleRevisionImpl.class, 128, 4705, 4720);
                    if (!(CallChecker.isCalled(((BundleRevisionImpl) (m_targetRevision)), BundleRevisionImpl.class, 128, 4705, 4720).hasInputStream(m_classPathIdx, CallChecker.isCalled(url, URL.class, 129, 4767, 4769).getPath()))) {
                        BundleWiring wiring = CallChecker.init(BundleWiring.class);
                        if (CallChecker.beforeDeref(m_targetRevision, BundleRevision.class, 131, 4827, 4842)) {
                            m_targetRevision = CallChecker.beforeCalled(m_targetRevision, BundleRevision.class, 131, 4827, 4842);
                            wiring = CallChecker.isCalled(m_targetRevision, BundleRevision.class, 131, 4827, 4842).getWiring();
                            CallChecker.varAssign(wiring, "wiring", 131, 4827, 4842);
                        }
                        ClassLoader cl = CallChecker.init(ClassLoader.class);
                        if (wiring != null) {
                            cl = wiring.getClassLoader();
                            CallChecker.varAssign(cl, "cl", 132, 4886, 4934);
                        }else {
                            cl = null;
                            CallChecker.varAssign(cl, "cl", 132, 4886, 4934);
                        }
                        URL newurl = CallChecker.init(URL.class);
                        if (cl != null) {
                            if (CallChecker.beforeDeref(url, URL.class, 133, 4992, 4994)) {
                                url = CallChecker.beforeCalled(url, URL.class, 133, 4992, 4994);
                                newurl = cl.getResource(CallChecker.isCalled(url, URL.class, 133, 4992, 4994).getPath());
                                CallChecker.varAssign(newurl, "newurl", 133, 4962, 5012);
                            }
                        }else {
                            newurl = null;
                            CallChecker.varAssign(newurl, "newurl", 133, 4962, 5012);
                        }
                        if (newurl == null) {
                            throw new IOException(("Resource does not exist: " + url));
                        }
                        m_classPathIdx = newurl.getPort();
                        CallChecker.varAssign(this.m_classPathIdx, "this.m_classPathIdx", 138, 5161, 5194);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_methode_context168.methodEnd();
        }
    }

    public synchronized void connect() throws IOException {
        MethodContext _bcornu_methode_context1708 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 142, 5217, 5799);
            CallChecker.varInit(this.m_is, "m_is", 142, 5217, 5799);
            CallChecker.varInit(this.m_contentType, "m_contentType", 142, 5217, 5799);
            CallChecker.varInit(this.m_contentTime, "m_contentTime", 142, 5217, 5799);
            CallChecker.varInit(this.m_contentLength, "m_contentLength", 142, 5217, 5799);
            CallChecker.varInit(this.m_classPathIdx, "m_classPathIdx", 142, 5217, 5799);
            CallChecker.varInit(this.m_targetRevision, "m_targetRevision", 142, 5217, 5799);
            CallChecker.varInit(this.m_framework, "m_framework", 142, 5217, 5799);
            if (!(connected)) {
                if (((m_targetRevision) == null) || ((m_classPathIdx) < 0)) {
                    throw new IOException(("Resource does not exist: " + (url)));
                }
                if (CallChecker.beforeDeref(url, URL.class, 151, 5587, 5589)) {
                    m_is = ((BundleRevisionImpl) (m_targetRevision)).getInputStream(m_classPathIdx, CallChecker.isCalled(url, URL.class, 151, 5587, 5589).getPath());
                    CallChecker.varAssign(this.m_is, "this.m_is", 150, 5493, 5601);
                }
                if ((m_is) == null) {
                    m_contentLength = 0;
                    CallChecker.varAssign(this.m_contentLength, "this.m_contentLength", 152, 5615, 5670);
                }else {
                    m_contentLength = m_is.available();
                    CallChecker.varAssign(this.m_contentLength, "this.m_contentLength", 152, 5615, 5670);
                }
                if (CallChecker.beforeDeref(url, URL.class, 153, 5739, 5741)) {
                    m_contentType = URLConnection.guessContentTypeFromName(CallChecker.isCalled(url, URL.class, 153, 5739, 5741).getFile());
                    CallChecker.varAssign(this.m_contentType, "this.m_contentType", 153, 5684, 5753);
                }
                connected = true;
                CallChecker.varAssign(this.connected, "this.connected", 154, 5767, 5783);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1708.methodEnd();
        }
    }

    public InputStream getInputStream() throws IOException {
        MethodContext _bcornu_methode_context1709 = new MethodContext(InputStream.class);
        try {
            CallChecker.varInit(this, "this", 158, 5806, 5920);
            CallChecker.varInit(this.m_is, "m_is", 158, 5806, 5920);
            CallChecker.varInit(this.m_contentType, "m_contentType", 158, 5806, 5920);
            CallChecker.varInit(this.m_contentTime, "m_contentTime", 158, 5806, 5920);
            CallChecker.varInit(this.m_contentLength, "m_contentLength", 158, 5806, 5920);
            CallChecker.varInit(this.m_classPathIdx, "m_classPathIdx", 158, 5806, 5920);
            CallChecker.varInit(this.m_targetRevision, "m_targetRevision", 158, 5806, 5920);
            CallChecker.varInit(this.m_framework, "m_framework", 158, 5806, 5920);
            connect();
            return m_is;
        } catch (ForceReturn _bcornu_return_t) {
            return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1709.methodEnd();
        }
    }

    public int getContentLength() {
        MethodContext _bcornu_methode_context1710 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 166, 5927, 6128);
            CallChecker.varInit(this.m_is, "m_is", 166, 5927, 6128);
            CallChecker.varInit(this.m_contentType, "m_contentType", 166, 5927, 6128);
            CallChecker.varInit(this.m_contentTime, "m_contentTime", 166, 5927, 6128);
            CallChecker.varInit(this.m_contentLength, "m_contentLength", 166, 5927, 6128);
            CallChecker.varInit(this.m_classPathIdx, "m_classPathIdx", 166, 5927, 6128);
            CallChecker.varInit(this.m_targetRevision, "m_targetRevision", 166, 5927, 6128);
            CallChecker.varInit(this.m_framework, "m_framework", 166, 5927, 6128);
            TryContext _bcornu_try_context_452 = new TryContext(452, URLHandlersBundleURLConnection.class, "java.io.IOException");
            try {
                connect();
            } catch (IOException ex) {
                _bcornu_try_context_452.catchStart(452);
                return -1;
            } finally {
                _bcornu_try_context_452.finallyStart(452);
            }
            return m_contentLength;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1710.methodEnd();
        }
    }

    public long getLastModified() {
        MethodContext _bcornu_methode_context1711 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 180, 6135, 6447);
            CallChecker.varInit(this.m_is, "m_is", 180, 6135, 6447);
            CallChecker.varInit(this.m_contentType, "m_contentType", 180, 6135, 6447);
            CallChecker.varInit(this.m_contentTime, "m_contentTime", 180, 6135, 6447);
            CallChecker.varInit(this.m_contentLength, "m_contentLength", 180, 6135, 6447);
            CallChecker.varInit(this.m_classPathIdx, "m_classPathIdx", 180, 6135, 6447);
            CallChecker.varInit(this.m_targetRevision, "m_targetRevision", 180, 6135, 6447);
            CallChecker.varInit(this.m_framework, "m_framework", 180, 6135, 6447);
            TryContext _bcornu_try_context_453 = new TryContext(453, URLHandlersBundleURLConnection.class, "java.io.IOException");
            try {
                connect();
            } catch (IOException ex) {
                _bcornu_try_context_453.catchStart(453);
                return 0;
            } finally {
                _bcornu_try_context_453.finallyStart(453);
            }
            if ((m_contentTime) != (-1L)) {
                return m_contentTime;
            }else {
                return 0L;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1711.methodEnd();
        }
    }

    public String getContentType() {
        MethodContext _bcornu_methode_context1712 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 201, 6454, 6657);
            CallChecker.varInit(this.m_is, "m_is", 201, 6454, 6657);
            CallChecker.varInit(this.m_contentType, "m_contentType", 201, 6454, 6657);
            CallChecker.varInit(this.m_contentTime, "m_contentTime", 201, 6454, 6657);
            CallChecker.varInit(this.m_contentLength, "m_contentLength", 201, 6454, 6657);
            CallChecker.varInit(this.m_classPathIdx, "m_classPathIdx", 201, 6454, 6657);
            CallChecker.varInit(this.m_targetRevision, "m_targetRevision", 201, 6454, 6657);
            CallChecker.varInit(this.m_framework, "m_framework", 201, 6454, 6657);
            TryContext _bcornu_try_context_454 = new TryContext(454, URLHandlersBundleURLConnection.class, "java.io.IOException");
            try {
                connect();
            } catch (IOException ex) {
                _bcornu_try_context_454.catchStart(454);
                return null;
            } finally {
                _bcornu_try_context_454.finallyStart(454);
            }
            return m_contentType;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1712.methodEnd();
        }
    }

    public Permission getPermission() {
        MethodContext _bcornu_methode_context1713 = new MethodContext(Permission.class);
        try {
            CallChecker.varInit(this, "this", 215, 6664, 7031);
            CallChecker.varInit(this.m_is, "m_is", 215, 6664, 7031);
            CallChecker.varInit(this.m_contentType, "m_contentType", 215, 6664, 7031);
            CallChecker.varInit(this.m_contentTime, "m_contentTime", 215, 6664, 7031);
            CallChecker.varInit(this.m_contentLength, "m_contentLength", 215, 6664, 7031);
            CallChecker.varInit(this.m_classPathIdx, "m_classPathIdx", 215, 6664, 7031);
            CallChecker.varInit(this.m_targetRevision, "m_targetRevision", 215, 6664, 7031);
            CallChecker.varInit(this.m_framework, "m_framework", 215, 6664, 7031);
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Permission) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1713.methodEnd();
        }
    }

    URL getLocalURL() {
        MethodContext _bcornu_methode_context1714 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 230, 7038, 7420);
            CallChecker.varInit(this.m_is, "m_is", 230, 7038, 7420);
            CallChecker.varInit(this.m_contentType, "m_contentType", 230, 7038, 7420);
            CallChecker.varInit(this.m_contentTime, "m_contentTime", 230, 7038, 7420);
            CallChecker.varInit(this.m_contentLength, "m_contentLength", 230, 7038, 7420);
            CallChecker.varInit(this.m_classPathIdx, "m_classPathIdx", 230, 7038, 7420);
            CallChecker.varInit(this.m_targetRevision, "m_targetRevision", 230, 7038, 7420);
            CallChecker.varInit(this.m_framework, "m_framework", 230, 7038, 7420);
            if (((m_targetRevision) == null) || ((m_classPathIdx) < 0)) {
                return url;
            }
            if (CallChecker.beforeDeref(url, URL.class, 237, 7400, 7402)) {
                return ((BundleRevisionImpl) (m_targetRevision)).getLocalURL(m_classPathIdx, CallChecker.isCalled(url, URL.class, 237, 7400, 7402).getPath());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1714.methodEnd();
        }
    }
}

