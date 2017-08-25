package org.apache.felix.framework.cache;

import org.apache.felix.framework.util.WeakZipFileFactory;
import org.apache.felix.framework.util.Util;
import java.net.URL;
import java.net.URI;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.SecureAction;
import java.util.Properties;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import org.apache.felix.framework.util.FelixConstants;
import java.util.Enumeration;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.io.ByteArrayOutputStream;
import java.io.BufferedInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;
import org.apache.felix.framework.Logger;
import java.net.MalformedURLException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class DirectoryContent implements Content {
    private static final int BUFSIZE = 4096;

    private static final transient String EMBEDDED_DIRECTORY = "-embedded";

    private static final transient String LIBRARY_DIRECTORY = "-lib";

    private final Logger m_logger;

    private final Map m_configMap;

    private final WeakZipFileFactory m_zipFactory;

    private final Object m_revisionLock;

    private final File m_rootDir;

    private final File m_dir;

    private Map m_nativeLibMap;

    public DirectoryContent(Logger logger, Map configMap, WeakZipFileFactory zipFactory, Object revisionLock, File rootDir, File dir) {
        MethodContext _bcornu_methode_context100 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 48, 1846, 1863);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 49, 1873, 1896);
            m_zipFactory = zipFactory;
            CallChecker.varAssign(this.m_zipFactory, "this.m_zipFactory", 50, 1906, 1931);
            m_revisionLock = revisionLock;
            CallChecker.varAssign(this.m_revisionLock, "this.m_revisionLock", 51, 1941, 1970);
            m_rootDir = rootDir;
            CallChecker.varAssign(this.m_rootDir, "this.m_rootDir", 52, 1980, 1999);
            m_dir = dir;
            CallChecker.varAssign(this.m_dir, "this.m_dir", 53, 2009, 2020);
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context1021 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 56, 2033, 2095);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 56, 2033, 2095);
            CallChecker.varInit(this.m_dir, "m_dir", 56, 2033, 2095);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 56, 2033, 2095);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 56, 2033, 2095);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 56, 2033, 2095);
            CallChecker.varInit(this.m_configMap, "m_configMap", 56, 2033, 2095);
            CallChecker.varInit(this.m_logger, "m_logger", 56, 2033, 2095);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 56, 2033, 2095);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 56, 2033, 2095);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 56, 2033, 2095);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1021.methodEnd();
        }
    }

    public boolean hasEntry(String name) throws IllegalStateException {
        MethodContext _bcornu_methode_context1022 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 61, 2102, 2710);
            CallChecker.varInit(name, "name", 61, 2102, 2710);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 61, 2102, 2710);
            CallChecker.varInit(this.m_dir, "m_dir", 61, 2102, 2710);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 61, 2102, 2710);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 61, 2102, 2710);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 61, 2102, 2710);
            CallChecker.varInit(this.m_configMap, "m_configMap", 61, 2102, 2710);
            CallChecker.varInit(this.m_logger, "m_logger", 61, 2102, 2710);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 61, 2102, 2710);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 61, 2102, 2710);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 61, 2102, 2710);
            if (CallChecker.beforeDeref(name, String.class, 63, 2187, 2190)) {
                if (CallChecker.beforeDeref(name, String.class, 63, 2210, 2213)) {
                    name = CallChecker.beforeCalled(name, String.class, 63, 2187, 2190);
                    name = CallChecker.beforeCalled(name, String.class, 63, 2210, 2213);
                    if (((CallChecker.isCalled(name, String.class, 63, 2187, 2190).length()) > 0) && ((CallChecker.isCalled(name, String.class, 63, 2210, 2213).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 65, 2263, 2266)) {
                            name = CallChecker.beforeCalled(name, String.class, 65, 2263, 2266);
                            name = CallChecker.isCalled(name, String.class, 65, 2263, 2266).substring(1);
                            CallChecker.varAssign(name, "name", 65, 2256, 2280);
                        }
                    }
                }
            }
            File file = CallChecker.varInit(new File(m_dir, name), "file", 71, 2495, 2528);
            if ((!(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(name, String.class, 73, 2608, 2611), String.class, 73, 2608, 2625), String.class, 73, 2608, 2625).endsWith("/"))) || (CallChecker.beforeDeref(name, String.class, 73, 2608, 2611))) {
                final SecureAction npe_invocation_var391 = BundleCache.getSecureAction();
                name = CallChecker.beforeCalled(name, String.class, 73, 2608, 2611);
                if ((!(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(name, String.class, 73, 2608, 2611), String.class, 73, 2608, 2625), String.class, 73, 2608, 2625).endsWith("/"))) || (CallChecker.beforeDeref(npe_invocation_var391, SecureAction.class, 74, 2645, 2673))) {
                    return (CallChecker.isCalled(BundleCache.getSecureAction(), SecureAction.class, 72, 2545, 2573).fileExists(file)) && ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(name, String.class, 73, 2608, 2611), String.class, 73, 2608, 2625), String.class, 73, 2608, 2625).endsWith("/")) ? CallChecker.isCalled(npe_invocation_var391, SecureAction.class, 74, 2645, 2673).isFileDirectory(file) : true);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1022.methodEnd();
        }
    }

    public Enumeration<String> getEntries() {
        MethodContext _bcornu_methode_context1023 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 77, 2717, 3009);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 77, 2717, 3009);
            CallChecker.varInit(this.m_dir, "m_dir", 77, 2717, 3009);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 77, 2717, 3009);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 77, 2717, 3009);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 77, 2717, 3009);
            CallChecker.varInit(this.m_configMap, "m_configMap", 77, 2717, 3009);
            CallChecker.varInit(this.m_logger, "m_logger", 77, 2717, 3009);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 77, 2717, 3009);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 77, 2717, 3009);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 77, 2717, 3009);
            Enumeration<String> e = CallChecker.varInit(new DirectoryContent.EntriesEnumeration(m_dir), "e", 80, 2839, 2892);
            if (CallChecker.beforeDeref(e, Enumeration.class, 83, 2972, 2972)) {
                e = CallChecker.beforeCalled(e, Enumeration.class, 83, 2972, 2972);
                if (CallChecker.isCalled(e, Enumeration.class, 83, 2972, 2972).hasMoreElements()) {
                    return e;
                }else {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1023.methodEnd();
        }
    }

    public byte[] getEntryAsBytes(String name) throws IllegalStateException {
        MethodContext _bcornu_methode_context1024 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 86, 3016, 4194);
            CallChecker.varInit(name, "name", 86, 3016, 4194);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 86, 3016, 4194);
            CallChecker.varInit(this.m_dir, "m_dir", 86, 3016, 4194);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 86, 3016, 4194);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 86, 3016, 4194);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 86, 3016, 4194);
            CallChecker.varInit(this.m_configMap, "m_configMap", 86, 3016, 4194);
            CallChecker.varInit(this.m_logger, "m_logger", 86, 3016, 4194);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 86, 3016, 4194);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 86, 3016, 4194);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 86, 3016, 4194);
            if (CallChecker.beforeDeref(name, String.class, 88, 3107, 3110)) {
                if (CallChecker.beforeDeref(name, String.class, 88, 3130, 3133)) {
                    name = CallChecker.beforeCalled(name, String.class, 88, 3107, 3110);
                    name = CallChecker.beforeCalled(name, String.class, 88, 3130, 3133);
                    if (((CallChecker.isCalled(name, String.class, 88, 3107, 3110).length()) > 0) && ((CallChecker.isCalled(name, String.class, 88, 3130, 3133).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 90, 3183, 3186)) {
                            name = CallChecker.beforeCalled(name, String.class, 90, 3183, 3186);
                            name = CallChecker.isCalled(name, String.class, 90, 3183, 3186).substring(1);
                            CallChecker.varAssign(name, "name", 90, 3176, 3200);
                        }
                    }
                }
            }
            InputStream is = CallChecker.varInit(null, "is", 94, 3259, 3280);
            ByteArrayOutputStream baos = CallChecker.varInit(null, "baos", 95, 3290, 3323);
            TryContext _bcornu_try_context_316 = new TryContext(316, DirectoryContent.class, "java.lang.Exception");
            try {
                final SecureAction npe_invocation_var392 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var392, SecureAction.class, 100, 3406, 3434)) {
                    is = new BufferedInputStream(CallChecker.isCalled(npe_invocation_var392, SecureAction.class, 100, 3406, 3434).getFileInputStream(new File(m_dir, name)));
                    CallChecker.varAssign(is, "is", 99, 3360, 3478);
                }
                baos = new ByteArrayOutputStream(DirectoryContent.BUFSIZE);
                CallChecker.varAssign(baos, "baos", 101, 3492, 3533);
                byte[] buf = CallChecker.varInit(new byte[DirectoryContent.BUFSIZE], "buf", 102, 3547, 3577);
                int n = CallChecker.varInit(((int) (0)), "n", 103, 3591, 3600);
                buf = CallChecker.beforeCalled(buf, byte[].class, 104, 3642, 3644);
                is = CallChecker.beforeCalled(is, InputStream.class, 104, 3626, 3627);
                while ((n = CallChecker.isCalled(is, InputStream.class, 104, 3626, 3627).read(buf, 0, CallChecker.isCalled(buf, byte[].class, 104, 3642, 3644).length)) >= 0) {
                    CallChecker.varAssign(n, "n", 104, 3621, 3653);
                    if (CallChecker.beforeDeref(baos, ByteArrayOutputStream.class, 106, 3691, 3694)) {
                        baos = CallChecker.beforeCalled(baos, ByteArrayOutputStream.class, 106, 3691, 3694);
                        CallChecker.isCalled(baos, ByteArrayOutputStream.class, 106, 3691, 3694).write(buf, 0, n);
                    }
                } 
                if (CallChecker.beforeDeref(baos, ByteArrayOutputStream.class, 108, 3747, 3750)) {
                    baos = CallChecker.beforeCalled(baos, ByteArrayOutputStream.class, 108, 3747, 3750);
                    return CallChecker.isCalled(baos, ByteArrayOutputStream.class, 108, 3747, 3750).toByteArray();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_316.catchStart(316);
                return null;
            } finally {
                _bcornu_try_context_316.finallyStart(316);
                TryContext _bcornu_try_context_314 = new TryContext(314, DirectoryContent.class, "java.lang.Exception");
                try {
                    if (baos != null)
                        baos.close();
                    
                } catch (Exception ex) {
                    _bcornu_try_context_314.catchStart(314);
                } finally {
                    _bcornu_try_context_314.finallyStart(314);
                }
                TryContext _bcornu_try_context_315 = new TryContext(315, DirectoryContent.class, "java.lang.Exception");
                try {
                    if (is != null)
                        is.close();
                    
                } catch (Exception ex) {
                    _bcornu_try_context_315.catchStart(315);
                } finally {
                    _bcornu_try_context_315.finallyStart(315);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1024.methodEnd();
        }
    }

    public InputStream getEntryAsStream(String name) throws IOException, IllegalStateException {
        MethodContext _bcornu_methode_context1025 = new MethodContext(InputStream.class);
        try {
            CallChecker.varInit(this, "this", 134, 4201, 4517);
            CallChecker.varInit(name, "name", 134, 4201, 4517);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 134, 4201, 4517);
            CallChecker.varInit(this.m_dir, "m_dir", 134, 4201, 4517);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 134, 4201, 4517);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 134, 4201, 4517);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 134, 4201, 4517);
            CallChecker.varInit(this.m_configMap, "m_configMap", 134, 4201, 4517);
            CallChecker.varInit(this.m_logger, "m_logger", 134, 4201, 4517);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 134, 4201, 4517);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 134, 4201, 4517);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 134, 4201, 4517);
            if (CallChecker.beforeDeref(name, String.class, 137, 4319, 4322)) {
                if (CallChecker.beforeDeref(name, String.class, 137, 4342, 4345)) {
                    name = CallChecker.beforeCalled(name, String.class, 137, 4319, 4322);
                    name = CallChecker.beforeCalled(name, String.class, 137, 4342, 4345);
                    if (((CallChecker.isCalled(name, String.class, 137, 4319, 4322).length()) > 0) && ((CallChecker.isCalled(name, String.class, 137, 4342, 4345).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 139, 4395, 4398)) {
                            name = CallChecker.beforeCalled(name, String.class, 139, 4395, 4398);
                            name = CallChecker.isCalled(name, String.class, 139, 4395, 4398).substring(1);
                            CallChecker.varAssign(name, "name", 139, 4388, 4412);
                        }
                    }
                }
            }
            final SecureAction npe_invocation_var393 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var393, SecureAction.class, 142, 4440, 4468)) {
                return CallChecker.isCalled(npe_invocation_var393, SecureAction.class, 142, 4440, 4468).getFileInputStream(new File(m_dir, name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1025.methodEnd();
        }
    }

    public URL getEntryAsURL(String name) {
        MethodContext _bcornu_methode_context1026 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 145, 4524, 4895);
            CallChecker.varInit(name, "name", 145, 4524, 4895);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 145, 4524, 4895);
            CallChecker.varInit(this.m_dir, "m_dir", 145, 4524, 4895);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 145, 4524, 4895);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 145, 4524, 4895);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 145, 4524, 4895);
            CallChecker.varInit(this.m_configMap, "m_configMap", 145, 4524, 4895);
            CallChecker.varInit(this.m_logger, "m_logger", 145, 4524, 4895);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 145, 4524, 4895);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 145, 4524, 4895);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 145, 4524, 4895);
            if (CallChecker.beforeDeref(name, String.class, 147, 4581, 4584)) {
                if (CallChecker.beforeDeref(name, String.class, 147, 4604, 4607)) {
                    name = CallChecker.beforeCalled(name, String.class, 147, 4581, 4584);
                    name = CallChecker.beforeCalled(name, String.class, 147, 4604, 4607);
                    if (((CallChecker.isCalled(name, String.class, 147, 4581, 4584).length()) > 0) && ((CallChecker.isCalled(name, String.class, 147, 4604, 4607).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 149, 4657, 4660)) {
                            name = CallChecker.beforeCalled(name, String.class, 149, 4657, 4660);
                            name = CallChecker.isCalled(name, String.class, 149, 4657, 4660).substring(1);
                            CallChecker.varAssign(name, "name", 149, 4650, 4674);
                        }
                    }
                }
            }
            TryContext _bcornu_try_context_317 = new TryContext(317, DirectoryContent.class, "java.net.MalformedURLException");
            try {
                final SecureAction npe_invocation_var394 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var394, SecureAction.class, 154, 4728, 4756)) {
                    final URI npe_invocation_var395 = CallChecker.isCalled(npe_invocation_var394, SecureAction.class, 154, 4728, 4756).toURI(new File(m_dir, name));
                    if (CallChecker.beforeDeref(npe_invocation_var395, URI.class, 154, 4728, 4785)) {
                        return CallChecker.isCalled(npe_invocation_var395, URI.class, 154, 4728, 4785).toURL();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (MalformedURLException e) {
                _bcornu_try_context_317.catchStart(317);
                return null;
            } finally {
                _bcornu_try_context_317.finallyStart(317);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1026.methodEnd();
        }
    }

    public Content getEntryAsContent(String entryName) {
        MethodContext _bcornu_methode_context1027 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 162, 4902, 7091);
            CallChecker.varInit(entryName, "entryName", 162, 4902, 7091);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 162, 4902, 7091);
            CallChecker.varInit(this.m_dir, "m_dir", 162, 4902, 7091);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 162, 4902, 7091);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 162, 4902, 7091);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 162, 4902, 7091);
            CallChecker.varInit(this.m_configMap, "m_configMap", 162, 4902, 7091);
            CallChecker.varInit(this.m_logger, "m_logger", 162, 4902, 7091);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 162, 4902, 7091);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 162, 4902, 7091);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 162, 4902, 7091);
            if (CallChecker.beforeDeref(entryName, String.class, 166, 5074, 5082)) {
                entryName = CallChecker.beforeCalled(entryName, String.class, 166, 5074, 5082);
                if (CallChecker.isCalled(entryName, String.class, 166, 5074, 5082).equals(FelixConstants.CLASS_PATH_DOT)) {
                    return new DirectoryContent(m_logger, m_configMap, m_zipFactory, m_revisionLock, m_rootDir, m_dir);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(entryName, String.class, 174, 5418, 5426)) {
                entryName = CallChecker.beforeCalled(entryName, String.class, 174, 5418, 5426);
                if (CallChecker.isCalled(entryName, String.class, 174, 5418, 5426).startsWith("/")) {
                    if (CallChecker.beforeDeref(entryName, String.class, 174, 5447, 5455)) {
                        entryName = CallChecker.beforeCalled(entryName, String.class, 174, 5447, 5455);
                        entryName = CallChecker.isCalled(entryName, String.class, 174, 5447, 5455).substring(1);
                        CallChecker.varAssign(entryName, "entryName", 174, 5405, 5481);
                    }
                }else {
                    entryName = entryName;
                    CallChecker.varAssign(entryName, "entryName", 174, 5405, 5481);
                }
            }
            File embedDir = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(m_dir, File.class, 177, 5607, 5611)) {
                embedDir = new File(m_rootDir, ((CallChecker.isCalled(m_dir, File.class, 177, 5607, 5611).getName()) + (DirectoryContent.EMBEDDED_DIRECTORY)));
                CallChecker.varAssign(embedDir, "embedDir", 177, 5607, 5611);
            }
            File file = CallChecker.varInit(new File(m_dir, entryName), "file", 182, 5823, 5861);
            final SecureAction npe_invocation_var396 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var396, SecureAction.class, 183, 5875, 5903)) {
                if (CallChecker.isCalled(npe_invocation_var396, SecureAction.class, 183, 5875, 5903).isFileDirectory(file)) {
                    return new DirectoryContent(m_logger, m_configMap, m_zipFactory, m_revisionLock, m_rootDir, file);
                }else {
                    final SecureAction npe_invocation_var397 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var397, SecureAction.class, 188, 6093, 6121)) {
                        if (CallChecker.beforeDeref(entryName, String.class, 189, 6155, 6163)) {
                            entryName = CallChecker.beforeCalled(entryName, String.class, 189, 6155, 6163);
                            if ((CallChecker.isCalled(npe_invocation_var397, SecureAction.class, 188, 6093, 6121).fileExists(file)) && (CallChecker.isCalled(entryName, String.class, 189, 6155, 6163).endsWith(".jar"))) {
                                File extractDir = CallChecker.init(File.class);
                                if (CallChecker.beforeDeref(entryName, String.class, 192, 6259, 6267)) {
                                    if (CallChecker.beforeDeref(entryName, String.class, 193, 6337, 6345)) {
                                        entryName = CallChecker.beforeCalled(entryName, String.class, 192, 6259, 6267);
                                        if ((!((CallChecker.isCalled(CallChecker.isCalled(entryName, String.class, 192, 6259, 6267), String.class, 192, 6259, 6284).lastIndexOf('/')) >= 0)) || (CallChecker.beforeDeref(entryName, String.class, 193, 6314, 6322))) {
                                            entryName = CallChecker.beforeCalled(entryName, String.class, 193, 6337, 6345);
                                            entryName = CallChecker.beforeCalled(entryName, String.class, 193, 6314, 6322);
                                            extractDir = new File(embedDir, (((CallChecker.isCalled(CallChecker.isCalled(entryName, String.class, 192, 6259, 6267), String.class, 192, 6259, 6284).lastIndexOf('/')) >= 0) ? CallChecker.isCalled(entryName, String.class, 193, 6314, 6322).substring(0, CallChecker.isCalled(entryName, String.class, 193, 6337, 6345).lastIndexOf('/')) : entryName));
                                            CallChecker.varAssign(extractDir, "extractDir", 192, 6259, 6267);
                                        }
                                    }
                                }
                                synchronized(m_revisionLock) {
                                    final SecureAction npe_invocation_var398 = BundleCache.getSecureAction();
                                    if (CallChecker.beforeDeref(npe_invocation_var398, SecureAction.class, 197, 6476, 6504)) {
                                        if (!(CallChecker.isCalled(npe_invocation_var398, SecureAction.class, 197, 6476, 6504).fileExists(extractDir))) {
                                            final SecureAction npe_invocation_var399 = BundleCache.getSecureAction();
                                            if (CallChecker.beforeDeref(npe_invocation_var399, SecureAction.class, 199, 6573, 6601)) {
                                                if (!(CallChecker.isCalled(npe_invocation_var399, SecureAction.class, 199, 6573, 6601).mkdirs(extractDir))) {
                                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 201, 6669, 6676)) {
                                                        CallChecker.isCalled(m_logger, Logger.class, 201, 6669, 6676).log(Logger.LOG_ERROR, "Unable to extract embedded directory.");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return new JarContent(m_logger, m_configMap, m_zipFactory, m_revisionLock, extractDir, file, null);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1027.methodEnd();
        }
    }

    public String getEntryAsNativeLibrary(String entryName) {
        MethodContext _bcornu_methode_context1028 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 217, 7094, 12140);
            CallChecker.varInit(entryName, "entryName", 217, 7094, 12140);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 217, 7094, 12140);
            CallChecker.varInit(this.m_dir, "m_dir", 217, 7094, 12140);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 217, 7094, 12140);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 217, 7094, 12140);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 217, 7094, 12140);
            CallChecker.varInit(this.m_configMap, "m_configMap", 217, 7094, 12140);
            CallChecker.varInit(this.m_logger, "m_logger", 217, 7094, 12140);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 217, 7094, 12140);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 217, 7094, 12140);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 217, 7094, 12140);
            String result = CallChecker.varInit(null, "result", 220, 7251, 7271);
            if (CallChecker.beforeDeref(entryName, String.class, 224, 7419, 7427)) {
                entryName = CallChecker.beforeCalled(entryName, String.class, 224, 7419, 7427);
                if (CallChecker.isCalled(entryName, String.class, 224, 7419, 7427).startsWith("/")) {
                    if (CallChecker.beforeDeref(entryName, String.class, 224, 7448, 7456)) {
                        entryName = CallChecker.beforeCalled(entryName, String.class, 224, 7448, 7456);
                        entryName = CallChecker.isCalled(entryName, String.class, 224, 7448, 7456).substring(1);
                        CallChecker.varAssign(entryName, "entryName", 224, 7406, 7482);
                    }
                }else {
                    entryName = entryName;
                    CallChecker.varAssign(entryName, "entryName", 224, 7406, 7482);
                }
            }
            File libDir = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(m_dir, File.class, 227, 7612, 7616)) {
                libDir = new File(m_rootDir, ((CallChecker.isCalled(m_dir, File.class, 227, 7612, 7616).getName()) + (DirectoryContent.LIBRARY_DIRECTORY)));
                CallChecker.varAssign(libDir, "libDir", 227, 7612, 7616);
            }
            File entryFile = CallChecker.varInit(new File(m_dir, entryName), "entryFile", 231, 7790, 7833);
            final SecureAction npe_invocation_var400 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var400, SecureAction.class, 232, 7847, 7875)) {
                final SecureAction npe_invocation_var401 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var401, SecureAction.class, 233, 7915, 7943)) {
                    if ((CallChecker.isCalled(npe_invocation_var400, SecureAction.class, 232, 7847, 7875).fileExists(entryFile)) && (!(CallChecker.isCalled(npe_invocation_var401, SecureAction.class, 233, 7915, 7943).isFileDirectory(entryFile)))) {
                        synchronized(m_revisionLock) {
                            if ((m_nativeLibMap) == null) {
                                m_nativeLibMap = new HashMap();
                                CallChecker.varAssign(this.m_nativeLibMap, "this.m_nativeLibMap", 246, 8606, 8636);
                            }
                            Integer libCount = CallChecker.init(Integer.class);
                            if (CallChecker.beforeDeref(m_nativeLibMap, Map.class, 248, 8701, 8714)) {
                                m_nativeLibMap = CallChecker.beforeCalled(m_nativeLibMap, Map.class, 248, 8701, 8714);
                                libCount = ((Integer) (CallChecker.isCalled(m_nativeLibMap, Map.class, 248, 8701, 8714).get(entryName)));
                                CallChecker.varAssign(libCount, "libCount", 248, 8701, 8714);
                            }
                            if (libCount == null) {
                                libCount = new Integer(0);
                                CallChecker.varAssign(libCount, "libCount", 250, 8810, 8895);
                            }else {
                                libCount = new Integer(((libCount.intValue()) + 1));
                                CallChecker.varAssign(libCount, "libCount", 250, 8810, 8895);
                            }
                            if (CallChecker.beforeDeref(m_nativeLibMap, Map.class, 251, 8913, 8926)) {
                                m_nativeLibMap = CallChecker.beforeCalled(m_nativeLibMap, Map.class, 251, 8913, 8926);
                                CallChecker.isCalled(m_nativeLibMap, Map.class, 251, 8913, 8926).put(entryName, libCount);
                            }
                            File libFile = CallChecker.init(File.class);
                            if (CallChecker.beforeDeref(libCount, Integer.class, 253, 9023, 9030)) {
                                libCount = CallChecker.beforeCalled(libCount, Integer.class, 253, 9023, 9030);
                                libFile = new File(libDir, (((CallChecker.isCalled(libCount, Integer.class, 253, 9023, 9030).toString()) + (File.separatorChar)) + entryName));
                                CallChecker.varAssign(libFile, "libFile", 253, 9023, 9030);
                            }
                            final SecureAction npe_invocation_var402 = BundleCache.getSecureAction();
                            if (CallChecker.beforeDeref(npe_invocation_var402, SecureAction.class, 255, 9100, 9128)) {
                                if (!(CallChecker.isCalled(npe_invocation_var402, SecureAction.class, 255, 9100, 9128).fileExists(libFile))) {
                                    if (CallChecker.beforeDeref(libFile, File.class, 257, 9235, 9241)) {
                                        final SecureAction npe_invocation_var403 = BundleCache.getSecureAction();
                                        if (CallChecker.beforeDeref(npe_invocation_var403, SecureAction.class, 257, 9194, 9222)) {
                                            if (CallChecker.beforeDeref(libFile, File.class, 258, 9325, 9331)) {
                                                final SecureAction npe_invocation_var404 = BundleCache.getSecureAction();
                                                if (CallChecker.beforeDeref(npe_invocation_var404, SecureAction.class, 258, 9288, 9316)) {
                                                    libFile = CallChecker.beforeCalled(libFile, File.class, 257, 9235, 9241);
                                                    libFile = CallChecker.beforeCalled(libFile, File.class, 258, 9325, 9331);
                                                    if ((!(CallChecker.isCalled(npe_invocation_var403, SecureAction.class, 257, 9194, 9222).fileExists(CallChecker.isCalled(libFile, File.class, 257, 9235, 9241).getParentFile()))) && (!(CallChecker.isCalled(npe_invocation_var404, SecureAction.class, 258, 9288, 9316).mkdirs(CallChecker.isCalled(libFile, File.class, 258, 9325, 9331).getParentFile())))) {
                                                        if (CallChecker.beforeDeref(m_logger, Logger.class, 260, 9397, 9404)) {
                                                            CallChecker.isCalled(m_logger, Logger.class, 260, 9397, 9404).log(Logger.LOG_ERROR, "Unable to create library directory.");
                                                        }
                                                    }else {
                                                        InputStream is = CallChecker.varInit(null, "is", 266, 9618, 9639);
                                                        TryContext _bcornu_try_context_319 = new TryContext(319, DirectoryContent.class, "java.lang.Exception");
                                                        try {
                                                            final SecureAction npe_invocation_var405 = BundleCache.getSecureAction();
                                                            if (CallChecker.beforeDeref(npe_invocation_var405, SecureAction.class, 271, 9786, 9814)) {
                                                                is = new BufferedInputStream(CallChecker.isCalled(npe_invocation_var405, SecureAction.class, 271, 9786, 9814).getFileInputStream(entryFile), BundleCache.BUFSIZE);
                                                                CallChecker.varAssign(is, "is", 270, 9724, 9899);
                                                            }
                                                            if (is == null) {
                                                                throw new IOException(("No input stream: " + entryName));
                                                            }
                                                            BundleCache.copyStreamToFile(is, libFile);
                                                            String command = CallChecker.init(String.class);
                                                            if (CallChecker.beforeDeref(m_configMap, Map.class, 283, 10405, 10415)) {
                                                                command = ((String) (CallChecker.isCalled(m_configMap, Map.class, 283, 10405, 10415).get(Constants.FRAMEWORK_EXECPERMISSION)));
                                                                CallChecker.varAssign(command, "command", 283, 10405, 10415);
                                                            }
                                                            if (command != null) {
                                                                Properties props = CallChecker.varInit(new Properties(), "props", 287, 10602, 10637);
                                                                if (CallChecker.beforeDeref(libFile, File.class, 288, 10700, 10706)) {
                                                                    if (CallChecker.beforeDeref(props, Properties.class, 288, 10671, 10675)) {
                                                                        libFile = CallChecker.beforeCalled(libFile, File.class, 288, 10700, 10706);
                                                                        props = CallChecker.beforeCalled(props, Properties.class, 288, 10671, 10675);
                                                                        CallChecker.isCalled(props, Properties.class, 288, 10671, 10675).setProperty("abspath", CallChecker.isCalled(libFile, File.class, 288, 10700, 10706).toString());
                                                                    }
                                                                }
                                                                command = Util.substVars(command, "command", null, props);
                                                                CallChecker.varAssign(command, "command", 289, 10753, 10810);
                                                                final SecureAction npe_invocation_var406 = BundleCache.getSecureAction();
                                                                Process p = CallChecker.init(Process.class);
                                                                if (CallChecker.beforeDeref(npe_invocation_var406, SecureAction.class, 290, 10856, 10884)) {
                                                                    p = CallChecker.isCalled(npe_invocation_var406, SecureAction.class, 290, 10856, 10884).exec(command);
                                                                    CallChecker.varAssign(p, "p", 290, 10856, 10884);
                                                                }
                                                                if (CallChecker.beforeDeref(p, Process.class, 291, 10933, 10933)) {
                                                                    p = CallChecker.beforeCalled(p, Process.class, 291, 10933, 10933);
                                                                    CallChecker.isCalled(p, Process.class, 291, 10933, 10933).waitFor();
                                                                }
                                                            }
                                                            final SecureAction npe_invocation_var407 = BundleCache.getSecureAction();
                                                            if (CallChecker.beforeDeref(npe_invocation_var407, SecureAction.class, 295, 11094, 11122)) {
                                                                result = CallChecker.isCalled(npe_invocation_var407, SecureAction.class, 295, 11094, 11122).getAbsolutePath(libFile);
                                                                CallChecker.varAssign(result, "result", 295, 11085, 11148);
                                                            }
                                                        } catch (Exception ex) {
                                                            _bcornu_try_context_319.catchStart(319);
                                                            if (CallChecker.beforeDeref(m_logger, Logger.class, 299, 11275, 11282)) {
                                                                CallChecker.isCalled(m_logger, Logger.class, 299, 11275, 11282).log(Logger.LOG_ERROR, "Extracting native library.", ex);
                                                            }
                                                        } finally {
                                                            _bcornu_try_context_319.finallyStart(319);
                                                            TryContext _bcornu_try_context_318 = new TryContext(318, DirectoryContent.class, "java.io.IOException");
                                                            try {
                                                                if (is != null)
                                                                    is.close();
                                                                
                                                            } catch (IOException ex) {
                                                                _bcornu_try_context_318.catchStart(318);
                                                            } finally {
                                                                _bcornu_try_context_318.finallyStart(318);
                                                            }
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
                                    
                                }else {
                                    final SecureAction npe_invocation_var408 = BundleCache.getSecureAction();
                                    if (CallChecker.beforeDeref(npe_invocation_var408, SecureAction.class, 319, 12014, 12042)) {
                                        result = CallChecker.isCalled(npe_invocation_var408, SecureAction.class, 319, 12014, 12042).getAbsolutePath(libFile);
                                        CallChecker.varAssign(result, "result", 319, 12005, 12068);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1028.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context1029 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 327, 12147, 12219);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 327, 12147, 12219);
            CallChecker.varInit(this.m_dir, "m_dir", 327, 12147, 12219);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 327, 12147, 12219);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 327, 12147, 12219);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 327, 12147, 12219);
            CallChecker.varInit(this.m_configMap, "m_configMap", 327, 12147, 12219);
            CallChecker.varInit(this.m_logger, "m_logger", 327, 12147, 12219);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.LIBRARY_DIRECTORY", 327, 12147, 12219);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.DirectoryContent.EMBEDDED_DIRECTORY", 327, 12147, 12219);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.DirectoryContent.BUFSIZE", 327, 12147, 12219);
            return "DIRECTORY " + (m_dir);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1029.methodEnd();
        }
    }

    private static class EntriesEnumeration implements Enumeration {
        private final File m_dir;

        private final File[] m_children;

        private int m_counter = 0;

        public EntriesEnumeration(File dir) {
            MethodContext _bcornu_methode_context101 = new MethodContext(null);
            try {
                m_dir = dir;
                CallChecker.varAssign(this.m_dir, "this.m_dir", 340, 12472, 12483);
                m_children = listFilesRecursive(m_dir);
                CallChecker.varAssign(this.m_children, "this.m_children", 341, 12497, 12535);
            } finally {
                _bcornu_methode_context101.methodEnd();
            }
        }

        public synchronized boolean hasMoreElements() {
            MethodContext _bcornu_methode_context1030 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 344, 12556, 12696);
                CallChecker.varInit(this.m_counter, "m_counter", 344, 12556, 12696);
                CallChecker.varInit(this.m_children, "m_children", 344, 12556, 12696);
                CallChecker.varInit(this.m_dir, "m_dir", 344, 12556, 12696);
                return ((m_children) != null) && ((m_counter) < (CallChecker.isCalled(m_children, File[].class, 346, 12668, 12677).length));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1030.methodEnd();
            }
        }

        public synchronized Object nextElement() {
            MethodContext _bcornu_methode_context1031 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 349, 12707, 13707);
                CallChecker.varInit(this.m_counter, "m_counter", 349, 12707, 13707);
                CallChecker.varInit(this.m_children, "m_children", 349, 12707, 13707);
                CallChecker.varInit(this.m_dir, "m_dir", 349, 12707, 13707);
                if (((m_children) == null) || ((m_counter) >= (m_children.length))) {
                    throw new NoSuchElementException("No more entry paths.");
                }
                final SecureAction npe_invocation_var409 = BundleCache.getSecureAction();
                String abs = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(npe_invocation_var409, SecureAction.class, 357, 13024, 13052)) {
                    final String npe_invocation_var410 = CallChecker.isCalled(npe_invocation_var409, SecureAction.class, 357, 13024, 13052).getAbsolutePath(CallChecker.isCalled(m_children, File[].class, 358, 13087, 13096)[m_counter]);
                    if (CallChecker.beforeDeref(npe_invocation_var410, String.class, 357, 13024, 13108)) {
                        abs = CallChecker.isCalled(npe_invocation_var410, String.class, 357, 13024, 13108).replace(File.separatorChar, '/');
                        CallChecker.varAssign(abs, "abs", 357, 13024, 13052);
                    }
                }
                StringBuffer sb = CallChecker.varInit(new StringBuffer(abs), "sb", 362, 13302, 13341);
                final SecureAction npe_invocation_var411 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var411, SecureAction.class, 363, 13368, 13396)) {
                    final String npe_invocation_var412 = CallChecker.isCalled(npe_invocation_var411, SecureAction.class, 363, 13368, 13396).getAbsolutePath(m_dir);
                    if (CallChecker.beforeDeref(npe_invocation_var412, String.class, 363, 13368, 13419)) {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 363, 13355, 13356)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 363, 13355, 13356);
                            CallChecker.isCalled(sb, StringBuffer.class, 363, 13355, 13356).delete(0, ((CallChecker.isCalled(npe_invocation_var412, String.class, 363, 13368, 13419).length()) + 1));
                        }
                    }
                }
                final SecureAction npe_invocation_var413 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var413, SecureAction.class, 365, 13510, 13538)) {
                    if (CallChecker.isCalled(npe_invocation_var413, SecureAction.class, 365, 13510, 13538).isFileDirectory(m_children[m_counter])) {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 367, 13610, 13611)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 367, 13610, 13611);
                            CallChecker.isCalled(sb, StringBuffer.class, 367, 13610, 13611).append('/');
                        }
                    }
                }
                (m_counter)++;
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 370, 13684, 13685)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 370, 13684, 13685);
                    return CallChecker.isCalled(sb, StringBuffer.class, 370, 13684, 13685).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1031.methodEnd();
            }
        }

        private File[] listFilesRecursive(File dir) {
            MethodContext _bcornu_methode_context1032 = new MethodContext(File[].class);
            try {
                CallChecker.varInit(this, "this", 373, 13718, 14637);
                CallChecker.varInit(dir, "dir", 373, 13718, 14637);
                CallChecker.varInit(this.m_counter, "m_counter", 373, 13718, 14637);
                CallChecker.varInit(this.m_children, "m_children", 373, 13718, 14637);
                CallChecker.varInit(this.m_dir, "m_dir", 373, 13718, 14637);
                final SecureAction npe_invocation_var414 = BundleCache.getSecureAction();
                File[] children = CallChecker.init(File[].class);
                if (CallChecker.beforeDeref(npe_invocation_var414, SecureAction.class, 375, 13802, 13830)) {
                    children = CallChecker.isCalled(npe_invocation_var414, SecureAction.class, 375, 13802, 13830).listDirectory(dir);
                    CallChecker.varAssign(children, "children", 375, 13802, 13830);
                }
                File[] combined = CallChecker.varInit(children, "combined", 376, 13864, 13890);
                children = CallChecker.beforeCalled(children, File[].class, 377, 13924, 13931);
                for (int i = 0; i < (CallChecker.isCalled(children, File[].class, 377, 13924, 13931).length); i++) {
                    if (CallChecker.beforeDeref(children, File[].class, 379, 14026, 14033)) {
                        final SecureAction npe_invocation_var415 = BundleCache.getSecureAction();
                        if (CallChecker.beforeDeref(npe_invocation_var415, SecureAction.class, 379, 13980, 14008)) {
                            children = CallChecker.beforeCalled(children, File[].class, 379, 14026, 14033);
                            if (CallChecker.isCalled(npe_invocation_var415, SecureAction.class, 379, 13980, 14008).isFileDirectory(CallChecker.isCalled(children, File[].class, 379, 14026, 14033)[i])) {
                                File[] grandchildren = CallChecker.init(File[].class);
                                if (CallChecker.beforeDeref(children, File[].class, 381, 14120, 14127)) {
                                    children = CallChecker.beforeCalled(children, File[].class, 381, 14120, 14127);
                                    grandchildren = listFilesRecursive(CallChecker.isCalled(children, File[].class, 381, 14120, 14127)[i]);
                                    CallChecker.varAssign(grandchildren, "grandchildren", 381, 14120, 14127);
                                }
                                if (CallChecker.beforeDeref(grandchildren, File[].class, 382, 14158, 14170)) {
                                    grandchildren = CallChecker.beforeCalled(grandchildren, File[].class, 382, 14158, 14170);
                                    if ((CallChecker.isCalled(grandchildren, File[].class, 382, 14158, 14170).length) > 0) {
                                        File[] tmp = CallChecker.init(File[].class);
                                        if (CallChecker.beforeDeref(combined, File[].class, 384, 14252, 14259)) {
                                            if (CallChecker.beforeDeref(grandchildren, File[].class, 384, 14270, 14282)) {
                                                combined = CallChecker.beforeCalled(combined, File[].class, 384, 14252, 14259);
                                                grandchildren = CallChecker.beforeCalled(grandchildren, File[].class, 384, 14270, 14282);
                                                tmp = new File[(CallChecker.isCalled(combined, File[].class, 384, 14252, 14259).length) + (CallChecker.isCalled(grandchildren, File[].class, 384, 14270, 14282).length)];
                                                CallChecker.varAssign(tmp, "tmp", 384, 14252, 14259);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(combined, File[].class, 385, 14355, 14362)) {
                                            combined = CallChecker.beforeCalled(combined, File[].class, 385, 14355, 14362);
                                            System.arraycopy(combined, 0, tmp, 0, CallChecker.isCalled(combined, File[].class, 385, 14355, 14362).length);
                                        }
                                        if (CallChecker.beforeDeref(combined, File[].class, 387, 14466, 14473)) {
                                            if (CallChecker.beforeDeref(grandchildren, File[].class, 387, 14483, 14495)) {
                                                combined = CallChecker.beforeCalled(combined, File[].class, 387, 14466, 14473);
                                                grandchildren = CallChecker.beforeCalled(grandchildren, File[].class, 387, 14483, 14495);
                                                System.arraycopy(grandchildren, 0, tmp, CallChecker.isCalled(combined, File[].class, 387, 14466, 14473).length, CallChecker.isCalled(grandchildren, File[].class, 387, 14483, 14495).length);
                                            }
                                        }
                                        combined = tmp;
                                        CallChecker.varAssign(combined, "combined", 388, 14530, 14544);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return combined;
            } catch (ForceReturn _bcornu_return_t) {
                return ((File[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1032.methodEnd();
            }
        }
    }
}

