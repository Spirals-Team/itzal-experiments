package org.apache.felix.framework.cache;

import java.util.zip.ZipEntry;
import org.apache.felix.framework.util.WeakZipFileFactory;
import org.apache.felix.framework.util.Util;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.StringMap;
import java.lang.ref.SoftReference;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.io.File;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import org.apache.felix.framework.Logger;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.felix.framework.util.SecureAction;

class JarRevision extends BundleArchiveRevision {
    private static final transient String BUNDLE_JAR_FILE = "bundle.jar";

    private final WeakZipFileFactory m_zipFactory;

    private final File m_bundleFile;

    private final WeakZipFileFactory.WeakZipFile m_zipFile;

    public JarRevision(Logger logger, Map configMap, WeakZipFileFactory zipFactory, File revisionRootDir, String location, boolean byReference, InputStream is) throws Exception {
        super(logger, configMap, revisionRootDir, location);
        MethodContext _bcornu_methode_context112 = new MethodContext(null);
        try {
            m_zipFactory = zipFactory;
            CallChecker.varAssign(this.m_zipFactory, "this.m_zipFactory", 63, 2440, 2465);
            if (byReference) {
                location = CallChecker.beforeCalled(location, String.class, 68, 2575, 2582);
                location = CallChecker.beforeCalled(location, String.class, 67, 2539, 2546);
                m_bundleFile = new File(CallChecker.isCalled(location, String.class, 67, 2539, 2546).substring(((CallChecker.isCalled(location, String.class, 68, 2575, 2582).indexOf(BundleArchive.FILE_PROTOCOL)) + (CallChecker.isCalled(BundleArchive.FILE_PROTOCOL, String.class, 69, 2643, 2669).length()))));
                CallChecker.varAssign(this.m_bundleFile, "this.m_bundleFile", 67, 2515, 2681);
            }else {
                m_bundleFile = new File(getRevisionRootDir(), JarRevision.BUNDLE_JAR_FILE);
                CallChecker.varAssign(this.m_bundleFile, "this.m_bundleFile", 73, 2728, 2790);
            }
            initialize(byReference, is);
            WeakZipFileFactory.WeakZipFile zipFile = CallChecker.varInit(null, "zipFile", 80, 2938, 2964);
            TryContext _bcornu_try_context_323 = new TryContext(323, JarRevision.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(m_zipFactory, WeakZipFileFactory.class, 84, 3047, 3058)) {
                    zipFile = CallChecker.isCalled(m_zipFactory, WeakZipFileFactory.class, 84, 3047, 3058).create(m_bundleFile);
                    CallChecker.varAssign(zipFile, "zipFile", 84, 3037, 3080);
                }
                if (zipFile == null) {
                    throw new IOException("No JAR file found.");
                }
                m_zipFile = zipFile;
                CallChecker.varAssign(this.m_zipFile, "this.m_zipFile", 90, 3253, 3272);
            } catch (Exception ex) {
                _bcornu_try_context_323.catchStart(323);
                if (zipFile != null)
                    zipFile.close();
                
                throw ex;
            } finally {
                _bcornu_try_context_323.finallyStart(323);
            }
        } finally {
            _bcornu_methode_context112.methodEnd();
        }
    }

    public Map getManifestHeader() throws Exception {
        MethodContext _bcornu_methode_context1060 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 99, 3416, 3684);
            CallChecker.varInit(DEFAULT_BUFFER, "org.apache.felix.framework.cache.JarRevision.DEFAULT_BUFFER", 99, 3416, 3684);
            CallChecker.varInit(m_defaultBuffer, "org.apache.felix.framework.cache.JarRevision.m_defaultBuffer", 99, 3416, 3684);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 99, 3416, 3684);
            CallChecker.varInit(this.m_bundleFile, "m_bundleFile", 99, 3416, 3684);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 99, 3416, 3684);
            CallChecker.varInit(BUNDLE_JAR_FILE, "org.apache.felix.framework.cache.JarRevision.BUNDLE_JAR_FILE", 99, 3416, 3684);
            Map headers = CallChecker.varInit(new StringMap(), "headers", 102, 3543, 3572);
            JarRevision.getMainAttributes(headers, m_zipFile);
            return headers;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1060.methodEnd();
        }
    }

    public synchronized Content getContent() throws Exception {
        MethodContext _bcornu_methode_context1061 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 108, 3691, 3895);
            CallChecker.varInit(DEFAULT_BUFFER, "org.apache.felix.framework.cache.JarRevision.DEFAULT_BUFFER", 108, 3691, 3895);
            CallChecker.varInit(m_defaultBuffer, "org.apache.felix.framework.cache.JarRevision.m_defaultBuffer", 108, 3691, 3895);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 108, 3691, 3895);
            CallChecker.varInit(this.m_bundleFile, "m_bundleFile", 108, 3691, 3895);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 108, 3691, 3895);
            CallChecker.varInit(BUNDLE_JAR_FILE, "org.apache.felix.framework.cache.JarRevision.BUNDLE_JAR_FILE", 108, 3691, 3895);
            return new JarContent(getLogger(), getConfig(), m_zipFactory, this, getRevisionRootDir(), m_bundleFile, m_zipFile);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1061.methodEnd();
        }
    }

    protected void close() throws Exception {
        MethodContext _bcornu_methode_context1062 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 114, 3902, 3979);
            CallChecker.varInit(DEFAULT_BUFFER, "org.apache.felix.framework.cache.JarRevision.DEFAULT_BUFFER", 114, 3902, 3979);
            CallChecker.varInit(m_defaultBuffer, "org.apache.felix.framework.cache.JarRevision.m_defaultBuffer", 114, 3902, 3979);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 114, 3902, 3979);
            CallChecker.varInit(this.m_bundleFile, "m_bundleFile", 114, 3902, 3979);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 114, 3902, 3979);
            CallChecker.varInit(BUNDLE_JAR_FILE, "org.apache.felix.framework.cache.JarRevision.BUNDLE_JAR_FILE", 114, 3902, 3979);
            if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 116, 3956, 3964)) {
                CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 116, 3956, 3964).close();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1062.methodEnd();
        }
    }

    private void initialize(boolean byReference, InputStream is) throws Exception {
        MethodContext _bcornu_methode_context1063 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 123, 3986, 6873);
            CallChecker.varInit(is, "is", 123, 3986, 6873);
            CallChecker.varInit(byReference, "byReference", 123, 3986, 6873);
            CallChecker.varInit(DEFAULT_BUFFER, "org.apache.felix.framework.cache.JarRevision.DEFAULT_BUFFER", 123, 3986, 6873);
            CallChecker.varInit(m_defaultBuffer, "org.apache.felix.framework.cache.JarRevision.m_defaultBuffer", 123, 3986, 6873);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 123, 3986, 6873);
            CallChecker.varInit(this.m_bundleFile, "m_bundleFile", 123, 3986, 6873);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 123, 3986, 6873);
            CallChecker.varInit(BUNDLE_JAR_FILE, "org.apache.felix.framework.cache.JarRevision.BUNDLE_JAR_FILE", 123, 3986, 6873);
            TryContext _bcornu_try_context_325 = new TryContext(325, JarRevision.class);
            try {
                final SecureAction npe_invocation_var417 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var417, SecureAction.class, 129, 4229, 4257)) {
                    if (!(CallChecker.isCalled(npe_invocation_var417, SecureAction.class, 129, 4229, 4257).fileExists(getRevisionRootDir()))) {
                        final SecureAction npe_invocation_var418 = BundleCache.getSecureAction();
                        if (CallChecker.beforeDeref(npe_invocation_var418, SecureAction.class, 131, 4328, 4356)) {
                            if (!(CallChecker.isCalled(npe_invocation_var418, SecureAction.class, 131, 4328, 4356).mkdir(getRevisionRootDir()))) {
                                if (CallChecker.beforeDeref(getClass(), Class.class, 135, 4508, 4517)) {
                                    final Logger npe_invocation_var419 = getLogger();
                                    if (CallChecker.beforeDeref(npe_invocation_var419, Logger.class, 133, 4425, 4435)) {
                                        CallChecker.isCalled(npe_invocation_var419, Logger.class, 133, 4425, 4435).log(Logger.LOG_ERROR, ((CallChecker.isCalled(getClass(), Class.class, 135, 4508, 4517).getName()) + ": Unable to create revision directory."));
                                    }
                                }
                                throw new IOException("Unable to create archive directory.");
                            }
                        }
                        if (!byReference) {
                            URLConnection conn = CallChecker.varInit(null, "conn", 141, 4747, 4772);
                            TryContext _bcornu_try_context_324 = new TryContext(324, JarRevision.class);
                            try {
                                if (is == null) {
                                    final SecureAction npe_invocation_var420 = BundleCache.getSecureAction();
                                    URL url = CallChecker.init(URL.class);
                                    if (CallChecker.beforeDeref(npe_invocation_var420, SecureAction.class, 148, 5070, 5098)) {
                                        url = CallChecker.isCalled(npe_invocation_var420, SecureAction.class, 148, 5070, 5098).createURL(null, getLocation(), null);
                                        CallChecker.varAssign(url, "url", 148, 5070, 5098);
                                    }
                                    if (CallChecker.beforeDeref(url, URL.class, 150, 5206, 5208)) {
                                        url = CallChecker.beforeCalled(url, URL.class, 150, 5206, 5208);
                                        conn = CallChecker.isCalled(url, URL.class, 150, 5206, 5208).openConnection();
                                        CallChecker.varAssign(conn, "conn", 150, 5199, 5226);
                                    }
                                    final SecureAction npe_invocation_var421 = BundleCache.getSecureAction();
                                    String auth = CallChecker.init(String.class);
                                    if (CallChecker.beforeDeref(npe_invocation_var421, SecureAction.class, 153, 5341, 5369)) {
                                        auth = CallChecker.isCalled(npe_invocation_var421, SecureAction.class, 153, 5341, 5369).getSystemProperty("http.proxyAuth", null);
                                        CallChecker.varAssign(auth, "auth", 153, 5341, 5369);
                                    }
                                    if ((auth != null) && ((auth.length()) > 0)) {
                                        if (CallChecker.beforeDeref(url, URL.class, 157, 5598, 5600)) {
                                            if (CallChecker.beforeDeref("http", String.class, 157, 5584, 5589)) {
                                                if (CallChecker.beforeDeref(url, URL.class, 158, 5671, 5673)) {
                                                    if (CallChecker.beforeDeref("https", String.class, 158, 5656, 5662)) {
                                                        url = CallChecker.beforeCalled(url, URL.class, 157, 5598, 5600);
                                                        url = CallChecker.beforeCalled(url, URL.class, 158, 5671, 5673);
                                                        if ((CallChecker.isCalled("http", String.class, 157, 5584, 5589).equals(CallChecker.isCalled(url, URL.class, 157, 5598, 5600).getProtocol())) || (CallChecker.isCalled("https", String.class, 158, 5656, 5662).equals(CallChecker.isCalled(url, URL.class, 158, 5671, 5673).getProtocol()))) {
                                                            String base64 = CallChecker.varInit(Util.base64Encode(auth), "base64", 160, 5761, 5800);
                                                            if (CallChecker.beforeDeref(conn, URLConnection.class, 161, 5838, 5841)) {
                                                                conn = CallChecker.beforeCalled(conn, URLConnection.class, 161, 5838, 5841);
                                                                CallChecker.isCalled(conn, URLConnection.class, 161, 5838, 5841).setRequestProperty("Proxy-Authorization", ("Basic " + base64));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    final SecureAction npe_invocation_var422 = BundleCache.getSecureAction();
                                    if (CallChecker.beforeDeref(npe_invocation_var422, SecureAction.class, 165, 6043, 6071)) {
                                        is = CallChecker.isCalled(npe_invocation_var422, SecureAction.class, 165, 6043, 6071).getURLConnectionInputStream(conn);
                                        CallChecker.varAssign(is, "is", 165, 6038, 6139);
                                    }
                                }
                                BundleCache.copyStreamToFile(is, m_bundleFile);
                            } finally {
                                _bcornu_try_context_324.finallyStart(324);
                                if ((conn != null) && (conn instanceof HttpURLConnection)) {
                                    ((HttpURLConnection) (conn)).disconnect();
                                }
                            }
                        }
                    }
                }
            } finally {
                _bcornu_try_context_325.finallyStart(325);
                if (is != null)
                    is.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1063.methodEnd();
        }
    }

    private static final ThreadLocal m_defaultBuffer = new ThreadLocal();

    private static final int DEFAULT_BUFFER = 1024 * 64;

    private static void getMainAttributes(Map result, WeakZipFileFactory.WeakZipFile zipFile) throws Exception {
        MethodContext _bcornu_methode_context1064 = new MethodContext(void.class);
        try {
            CallChecker.varInit(zipFile, "zipFile", 197, 7012, 11645);
            CallChecker.varInit(result, "result", 197, 7012, 11645);
            CallChecker.varInit(DEFAULT_BUFFER, "org.apache.felix.framework.cache.JarRevision.DEFAULT_BUFFER", 197, 7012, 11645);
            CallChecker.varInit(m_defaultBuffer, "org.apache.felix.framework.cache.JarRevision.m_defaultBuffer", 197, 7012, 11645);
            CallChecker.varInit(BUNDLE_JAR_FILE, "org.apache.felix.framework.cache.JarRevision.BUNDLE_JAR_FILE", 197, 7012, 11645);
            ZipEntry entry = CallChecker.init(ZipEntry.class);
            if (CallChecker.beforeDeref(zipFile, WeakZipFileFactory.WeakZipFile.class, 199, 7387, 7393)) {
                zipFile = CallChecker.beforeCalled(zipFile, WeakZipFileFactory.WeakZipFile.class, 199, 7387, 7393);
                entry = CallChecker.isCalled(zipFile, WeakZipFileFactory.WeakZipFile.class, 199, 7387, 7393).getEntry("META-INF/MANIFEST.MF");
                CallChecker.varAssign(entry, "entry", 199, 7387, 7393);
            }
            SoftReference ref = CallChecker.init(SoftReference.class);
            if (CallChecker.beforeDeref(JarRevision.m_defaultBuffer, ThreadLocal.class, 204, 7676, 7690)) {
                ref = ((SoftReference) (CallChecker.isCalled(JarRevision.m_defaultBuffer, ThreadLocal.class, 204, 7676, 7690).get()));
                CallChecker.varAssign(ref, "ref", 204, 7676, 7690);
            }
            byte[] bytes = CallChecker.varInit(null, "bytes", 205, 7707, 7726);
            if (ref != null) {
                bytes = ((byte[]) (ref.get()));
                CallChecker.varAssign(bytes, "bytes", 208, 7775, 7801);
            }
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(entry, ZipEntry.class, 210, 7838, 7842)) {
                entry = CallChecker.beforeCalled(entry, ZipEntry.class, 210, 7838, 7842);
                size = ((int) (CallChecker.isCalled(entry, ZipEntry.class, 210, 7838, 7842).getSize()));
                CallChecker.varAssign(size, "size", 210, 7838, 7842);
            }
            if (bytes == null) {
                bytes = new byte[size > (JarRevision.DEFAULT_BUFFER) ? size : JarRevision.DEFAULT_BUFFER];
                CallChecker.varAssign(bytes, "bytes", 213, 7904, 7967);
                if (CallChecker.beforeDeref(JarRevision.m_defaultBuffer, ThreadLocal.class, 214, 7981, 7995)) {
                    CallChecker.isCalled(JarRevision.m_defaultBuffer, ThreadLocal.class, 214, 7981, 7995).set(new SoftReference(bytes));
                }
            }else
                if (size > (bytes.length)) {
                    bytes = new byte[size];
                    CallChecker.varAssign(bytes, "bytes", 218, 8098, 8120);
                    if (CallChecker.beforeDeref(JarRevision.m_defaultBuffer, ThreadLocal.class, 219, 8134, 8148)) {
                        CallChecker.isCalled(JarRevision.m_defaultBuffer, ThreadLocal.class, 219, 8134, 8148).set(new SoftReference(bytes));
                    }
                }
            
            InputStream is = CallChecker.varInit(null, "is", 225, 8370, 8391);
            TryContext _bcornu_try_context_326 = new TryContext(326, JarRevision.class);
            try {
                if (CallChecker.beforeDeref(zipFile, WeakZipFileFactory.WeakZipFile.class, 228, 8432, 8438)) {
                    zipFile = CallChecker.beforeCalled(zipFile, WeakZipFileFactory.WeakZipFile.class, 228, 8432, 8438);
                    is = CallChecker.isCalled(zipFile, WeakZipFileFactory.WeakZipFile.class, 228, 8432, 8438).getInputStream(entry);
                    CallChecker.varAssign(is, "is", 228, 8427, 8461);
                }
                int i = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(is, InputStream.class, 229, 8483, 8484)) {
                    is = CallChecker.beforeCalled(is, InputStream.class, 229, 8483, 8484);
                    i = CallChecker.isCalled(is, InputStream.class, 229, 8483, 8484).read(bytes);
                    CallChecker.varAssign(i, "i", 229, 8483, 8484);
                }
                while (i < size) {
                    if (CallChecker.beforeDeref(bytes, byte[].class, 232, 8581, 8585)) {
                        if (CallChecker.beforeDeref(is, InputStream.class, 232, 8563, 8564)) {
                            bytes = CallChecker.beforeCalled(bytes, byte[].class, 232, 8581, 8585);
                            is = CallChecker.beforeCalled(is, InputStream.class, 232, 8563, 8564);
                            i += CallChecker.isCalled(is, InputStream.class, 232, 8563, 8564).read(bytes, i, ((CallChecker.isCalled(bytes, byte[].class, 232, 8581, 8585).length) - i));
                            CallChecker.varAssign(i, "i", 232, 8558, 8598);
                        }
                    }
                } 
            } finally {
                _bcornu_try_context_326.finallyStart(326);
                if (CallChecker.beforeDeref(is, InputStream.class, 237, 8662, 8663)) {
                    is = CallChecker.beforeCalled(is, InputStream.class, 237, 8662, 8663);
                    CallChecker.isCalled(is, InputStream.class, 237, 8662, 8663).close();
                }
            }
            String key = CallChecker.varInit(null, "key", 247, 9208, 9225);
            int last = CallChecker.varInit(((int) (0)), "last", 248, 9235, 9247);
            int current = CallChecker.varInit(((int) (0)), "current", 249, 9257, 9272);
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(bytes, byte[].class, 254, 9468, 9472)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 254, 9468, 9472);
                    if ((CallChecker.isCalled(bytes, byte[].class, 254, 9468, 9472)[i]) == '\r') {
                        if (CallChecker.beforeDeref(bytes, byte[].class, 256, 9539, 9543)) {
                            bytes = CallChecker.beforeCalled(bytes, byte[].class, 256, 9539, 9543);
                            if (((i + 1) < size) && ((CallChecker.isCalled(bytes, byte[].class, 256, 9539, 9543)[(i + 1)]) == '\n')) {
                                continue;
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(bytes, byte[].class, 261, 9658, 9662)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 261, 9658, 9662);
                    if ((CallChecker.isCalled(bytes, byte[].class, 261, 9658, 9662)[i]) == '\n') {
                        if (CallChecker.beforeDeref(bytes, byte[].class, 263, 9729, 9733)) {
                            bytes = CallChecker.beforeCalled(bytes, byte[].class, 263, 9729, 9733);
                            if (((i + 1) < size) && ((CallChecker.isCalled(bytes, byte[].class, 263, 9729, 9733)[(i + 1)]) == ' ')) {
                                i++;
                                continue;
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(bytes, byte[].class, 271, 10029, 10033)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 271, 10029, 10033);
                    if ((key == null) && ((CallChecker.isCalled(bytes, byte[].class, 271, 10029, 10033)[i]) == ':')) {
                        key = new String(bytes, last, (current - last), "UTF-8");
                        CallChecker.varAssign(key, "key", 273, 10077, 10133);
                        if (CallChecker.beforeDeref(bytes, byte[].class, 274, 10174, 10178)) {
                            bytes = CallChecker.beforeCalled(bytes, byte[].class, 274, 10174, 10178);
                            if (((i + 1) < size) && ((CallChecker.isCalled(bytes, byte[].class, 274, 10174, 10178)[(i + 1)]) == ' ')) {
                                last = current + 1;
                                CallChecker.varAssign(last, "last", 276, 10234, 10252);
                                continue;
                            }else {
                                throw new Exception(("Manifest error: Missing space separator - " + key));
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(bytes, byte[].class, 286, 10553, 10557)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 286, 10553, 10557);
                    if ((CallChecker.isCalled(bytes, byte[].class, 286, 10553, 10557)[i]) == '\n') {
                        if ((last == current) && (key == null)) {
                            break;
                        }
                        String value = CallChecker.varInit(new String(bytes, last, (current - last), "UTF-8"), "value", 295, 10961, 11026);
                        if (key == null) {
                            throw new Exception(("Manifst error: Missing attribute name - " + value));
                        }else
                            if (CallChecker.beforeDeref(result, Map.class, 300, 11215, 11220)) {
                                result = CallChecker.beforeCalled(result, Map.class, 300, 11215, 11220);
                                if ((CallChecker.isCalled(result, Map.class, 300, 11215, 11220).put(key, value)) != null) {
                                    throw new Exception(("Manifst error: Duplicate attribute name - " + key));
                                }
                            }
                        
                        last = current;
                        CallChecker.varAssign(last, "last", 304, 11392, 11406);
                        key = null;
                        CallChecker.varAssign(key, "key", 305, 11424, 11434);
                    }else {
                        if (CallChecker.beforeDeref(bytes, byte[].class, 310, 11588, 11592)) {
                            if (CallChecker.beforeDeref(bytes, byte[].class, 310, 11607, 11611)) {
                                bytes = CallChecker.beforeCalled(bytes, byte[].class, 310, 11588, 11592);
                                bytes = CallChecker.beforeCalled(bytes, byte[].class, 310, 11607, 11611);
                                CallChecker.isCalled(bytes, byte[].class, 310, 11588, 11592)[(current++)] = CallChecker.isCalled(bytes, byte[].class, 310, 11607, 11611)[i];
                                CallChecker.varAssign(CallChecker.isCalled(bytes, byte[].class, 310, 11588, 11592)[(current - 1)], "CallChecker.isCalled(bytes, byte[].class, 310, 11588, 11592)[(current - 1)]", 310, 11588, 11615);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1064.methodEnd();
        }
    }
}

