package org.apache.felix.framework.cache;

import java.util.zip.ZipEntry;
import org.apache.felix.framework.util.WeakZipFileFactory;
import org.apache.felix.framework.util.Util;
import java.net.URL;
import java.net.URI;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.SecureAction;
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
import java.util.Properties;

public class JarContent implements Content {
    private static final int BUFSIZE = 4096;

    private static final transient String EMBEDDED_DIRECTORY = "-embedded";

    private static final transient String LIBRARY_DIRECTORY = "-lib";

    private final Logger m_logger;

    private final Map m_configMap;

    private final WeakZipFileFactory m_zipFactory;

    private final Object m_revisionLock;

    private final File m_rootDir;

    private final File m_file;

    private final WeakZipFileFactory.WeakZipFile m_zipFile;

    private final boolean m_isZipFileOwner;

    private Map m_nativeLibMap;

    public JarContent(Logger logger, Map configMap, WeakZipFileFactory zipFactory, Object revisionLock, File rootDir, File file, WeakZipFileFactory.WeakZipFile zipFile) {
        MethodContext _bcornu_methode_context134 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 59, 2264, 2281);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 60, 2291, 2314);
            m_zipFactory = zipFactory;
            CallChecker.varAssign(this.m_zipFactory, "this.m_zipFactory", 61, 2324, 2349);
            m_revisionLock = revisionLock;
            CallChecker.varAssign(this.m_revisionLock, "this.m_revisionLock", 62, 2359, 2388);
            m_rootDir = rootDir;
            CallChecker.varAssign(this.m_rootDir, "this.m_rootDir", 63, 2398, 2417);
            m_file = file;
            CallChecker.varAssign(this.m_file, "this.m_file", 64, 2427, 2440);
            if (zipFile == null) {
                TryContext _bcornu_try_context_380 = new TryContext(380, JarContent.class, "java.io.IOException");
                try {
                    m_zipFile = CallChecker.isCalled(m_zipFactory, WeakZipFileFactory.class, 69, 2539, 2550).create(m_file);
                    CallChecker.varAssign(this.m_zipFile, "this.m_zipFile", 69, 2527, 2566);
                } catch (IOException ex) {
                    _bcornu_try_context_380.catchStart(380);
                    throw new RuntimeException(("Unable to open JAR file, probably deleted: " + (ex.getMessage())));
                } finally {
                    _bcornu_try_context_380.finallyStart(380);
                }
            }else {
                m_zipFile = zipFile;
                CallChecker.varAssign(this.m_zipFile, "this.m_zipFile", 79, 2820, 2839);
            }
            m_isZipFileOwner = zipFile == null;
            CallChecker.varAssign(this.m_isZipFileOwner, "this.m_isZipFileOwner", 81, 2859, 2895);
        } finally {
            _bcornu_methode_context134.methodEnd();
        }
    }

    protected void finalize() {
        MethodContext _bcornu_methode_context1372 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 2908, 2961);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 84, 2908, 2961);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 84, 2908, 2961);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 84, 2908, 2961);
            CallChecker.varInit(this.m_file, "m_file", 84, 2908, 2961);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 84, 2908, 2961);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 84, 2908, 2961);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 84, 2908, 2961);
            CallChecker.varInit(this.m_configMap, "m_configMap", 84, 2908, 2961);
            CallChecker.varInit(this.m_logger, "m_logger", 84, 2908, 2961);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 84, 2908, 2961);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 84, 2908, 2961);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 84, 2908, 2961);
            close();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1372.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context1373 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 89, 2968, 3298);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 89, 2968, 3298);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 89, 2968, 3298);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 89, 2968, 3298);
            CallChecker.varInit(this.m_file, "m_file", 89, 2968, 3298);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 89, 2968, 3298);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 89, 2968, 3298);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 89, 2968, 3298);
            CallChecker.varInit(this.m_configMap, "m_configMap", 89, 2968, 3298);
            CallChecker.varInit(this.m_logger, "m_logger", 89, 2968, 3298);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 89, 2968, 3298);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 89, 2968, 3298);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 89, 2968, 3298);
            TryContext _bcornu_try_context_381 = new TryContext(381, JarContent.class, "java.lang.Exception");
            try {
                if (m_isZipFileOwner) {
                    if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 95, 3080, 3088)) {
                        CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 95, 3080, 3088).close();
                    }
                }
            } catch (Exception ex) {
                _bcornu_try_context_381.catchStart(381);
                if (CallChecker.beforeDeref(m_logger, Logger.class, 100, 3174, 3181)) {
                    CallChecker.isCalled(m_logger, Logger.class, 100, 3174, 3181).log(Logger.LOG_ERROR, "JarContent: Unable to close JAR file.", ex);
                }
            } finally {
                _bcornu_try_context_381.finallyStart(381);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1373.methodEnd();
        }
    }

    public boolean hasEntry(String name) throws IllegalStateException {
        MethodContext _bcornu_methode_context1374 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 106, 3305, 3607);
            CallChecker.varInit(name, "name", 106, 3305, 3607);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 106, 3305, 3607);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 106, 3305, 3607);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 106, 3305, 3607);
            CallChecker.varInit(this.m_file, "m_file", 106, 3305, 3607);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 106, 3305, 3607);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 106, 3305, 3607);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 106, 3305, 3607);
            CallChecker.varInit(this.m_configMap, "m_configMap", 106, 3305, 3607);
            CallChecker.varInit(this.m_logger, "m_logger", 106, 3305, 3607);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 106, 3305, 3607);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 106, 3305, 3607);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 106, 3305, 3607);
            TryContext _bcornu_try_context_382 = new TryContext(382, JarContent.class, "java.lang.Exception");
            try {
                ZipEntry ze = CallChecker.init(ZipEntry.class);
                if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 110, 3425, 3433)) {
                    ze = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 110, 3425, 3433).getEntry(name);
                    CallChecker.varAssign(ze, "ze", 110, 3425, 3433);
                }
                return ze != null;
            } catch (Exception ex) {
                _bcornu_try_context_382.catchStart(382);
                return false;
            } finally {
                _bcornu_try_context_382.finallyStart(382);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1374.methodEnd();
        }
    }

    public Enumeration<String> getEntries() {
        MethodContext _bcornu_methode_context1375 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 122, 3614, 3920);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 122, 3614, 3920);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 122, 3614, 3920);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 122, 3614, 3920);
            CallChecker.varInit(this.m_file, "m_file", 122, 3614, 3920);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 122, 3614, 3920);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 122, 3614, 3920);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 122, 3614, 3920);
            CallChecker.varInit(this.m_configMap, "m_configMap", 122, 3614, 3920);
            CallChecker.varInit(this.m_logger, "m_logger", 122, 3614, 3920);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 122, 3614, 3920);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 122, 3614, 3920);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 122, 3614, 3920);
            Enumeration<String> e = CallChecker.init(Enumeration.class);
            if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 125, 3783, 3791)) {
                e = new JarContent.EntriesEnumeration(CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 125, 3783, 3791).entries());
                CallChecker.varAssign(e, "e", 125, 3783, 3791);
            }
            if (CallChecker.beforeDeref(e, Enumeration.class, 128, 3883, 3883)) {
                e = CallChecker.beforeCalled(e, Enumeration.class, 128, 3883, 3883);
                if (CallChecker.isCalled(e, Enumeration.class, 128, 3883, 3883).hasMoreElements()) {
                    return e;
                }else {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1375.methodEnd();
        }
    }

    public byte[] getEntryAsBytes(String name) throws IllegalStateException {
        MethodContext _bcornu_methode_context1376 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 131, 3927, 5302);
            CallChecker.varInit(name, "name", 131, 3927, 5302);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 131, 3927, 5302);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 131, 3927, 5302);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 131, 3927, 5302);
            CallChecker.varInit(this.m_file, "m_file", 131, 3927, 5302);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 131, 3927, 5302);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 131, 3927, 5302);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 131, 3927, 5302);
            CallChecker.varInit(this.m_configMap, "m_configMap", 131, 3927, 5302);
            CallChecker.varInit(this.m_logger, "m_logger", 131, 3927, 5302);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 131, 3927, 5302);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 131, 3927, 5302);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 131, 3927, 5302);
            InputStream is = CallChecker.varInit(null, "is", 134, 4051, 4072);
            ByteArrayOutputStream baos = CallChecker.varInit(null, "baos", 135, 4082, 4115);
            TryContext _bcornu_try_context_385 = new TryContext(385, JarContent.class, "java.lang.Exception");
            try {
                ZipEntry ze = CallChecker.init(ZipEntry.class);
                if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 139, 4166, 4174)) {
                    ze = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 139, 4166, 4174).getEntry(name);
                    CallChecker.varAssign(ze, "ze", 139, 4166, 4174);
                }
                if (ze == null) {
                    return null;
                }
                if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 144, 4294, 4302)) {
                    is = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 144, 4294, 4302).getInputStream(ze);
                    CallChecker.varAssign(is, "is", 144, 4289, 4322);
                }
                if (is == null) {
                    return null;
                }
                baos = new ByteArrayOutputStream(JarContent.BUFSIZE);
                CallChecker.varAssign(baos, "baos", 149, 4421, 4462);
                byte[] buf = CallChecker.varInit(new byte[JarContent.BUFSIZE], "buf", 150, 4476, 4506);
                int n = CallChecker.varInit(((int) (0)), "n", 151, 4520, 4529);
                buf = CallChecker.beforeCalled(buf, byte[].class, 152, 4571, 4573);
                while ((n = is.read(buf, 0, CallChecker.isCalled(buf, byte[].class, 152, 4571, 4573).length)) >= 0) {
                    CallChecker.varAssign(n, "n", 152, 4550, 4582);
                    if (CallChecker.beforeDeref(baos, ByteArrayOutputStream.class, 154, 4620, 4623)) {
                        baos = CallChecker.beforeCalled(baos, ByteArrayOutputStream.class, 154, 4620, 4623);
                        CallChecker.isCalled(baos, ByteArrayOutputStream.class, 154, 4620, 4623).write(buf, 0, n);
                    }
                } 
                if (CallChecker.beforeDeref(baos, ByteArrayOutputStream.class, 156, 4676, 4679)) {
                    baos = CallChecker.beforeCalled(baos, ByteArrayOutputStream.class, 156, 4676, 4679);
                    return CallChecker.isCalled(baos, ByteArrayOutputStream.class, 156, 4676, 4679).toByteArray();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_385.catchStart(385);
                if (CallChecker.beforeDeref(m_file, File.class, 163, 4894, 4899)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 161, 4758, 4765)) {
                        CallChecker.isCalled(m_logger, Logger.class, 161, 4758, 4765).log(Logger.LOG_ERROR, ((("JarContent: Unable to read bytes for file " + name) + " in ZIP file ") + (CallChecker.isCalled(m_file, File.class, 163, 4894, 4899).getAbsolutePath())), ex);
                    }
                }
                return null;
            } finally {
                _bcornu_try_context_385.finallyStart(385);
                TryContext _bcornu_try_context_383 = new TryContext(383, JarContent.class, "java.lang.Exception");
                try {
                    if (baos != null)
                        baos.close();
                    
                } catch (Exception ex) {
                    _bcornu_try_context_383.catchStart(383);
                } finally {
                    _bcornu_try_context_383.finallyStart(383);
                }
                TryContext _bcornu_try_context_384 = new TryContext(384, JarContent.class, "java.lang.Exception");
                try {
                    if (is != null)
                        is.close();
                    
                } catch (Exception ex) {
                    _bcornu_try_context_384.catchStart(384);
                } finally {
                    _bcornu_try_context_384.finallyStart(384);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1376.methodEnd();
        }
    }

    public InputStream getEntryAsStream(String name) throws IOException, IllegalStateException {
        MethodContext _bcornu_methode_context1377 = new MethodContext(InputStream.class);
        try {
            CallChecker.varInit(this, "this", 185, 5309, 5883);
            CallChecker.varInit(name, "name", 185, 5309, 5883);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 185, 5309, 5883);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 185, 5309, 5883);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 185, 5309, 5883);
            CallChecker.varInit(this.m_file, "m_file", 185, 5309, 5883);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 185, 5309, 5883);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 185, 5309, 5883);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 185, 5309, 5883);
            CallChecker.varInit(this.m_configMap, "m_configMap", 185, 5309, 5883);
            CallChecker.varInit(this.m_logger, "m_logger", 185, 5309, 5883);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 185, 5309, 5883);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 185, 5309, 5883);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 185, 5309, 5883);
            InputStream is = CallChecker.varInit(null, "is", 189, 5460, 5481);
            TryContext _bcornu_try_context_386 = new TryContext(386, JarContent.class, "java.lang.Exception");
            try {
                ZipEntry ze = CallChecker.init(ZipEntry.class);
                if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 193, 5532, 5540)) {
                    ze = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 193, 5532, 5540).getEntry(name);
                    CallChecker.varAssign(ze, "ze", 193, 5532, 5540);
                }
                if (ze == null) {
                    return null;
                }
                if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 198, 5660, 5668)) {
                    is = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 198, 5660, 5668).getInputStream(ze);
                    CallChecker.varAssign(is, "is", 198, 5655, 5688);
                }
                if (is == null) {
                    return null;
                }
            } catch (Exception ex) {
                _bcornu_try_context_386.catchStart(386);
                return null;
            } finally {
                _bcornu_try_context_386.finallyStart(386);
            }
            return is;
        } catch (ForceReturn _bcornu_return_t) {
            return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1377.methodEnd();
        }
    }

    public URL getEntryAsURL(String name) {
        MethodContext _bcornu_methode_context1378 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 212, 5890, 6147);
            CallChecker.varInit(name, "name", 212, 5890, 6147);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 212, 5890, 6147);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 212, 5890, 6147);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 212, 5890, 6147);
            CallChecker.varInit(this.m_file, "m_file", 212, 5890, 6147);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 212, 5890, 6147);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 212, 5890, 6147);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 212, 5890, 6147);
            CallChecker.varInit(this.m_configMap, "m_configMap", 212, 5890, 6147);
            CallChecker.varInit(this.m_logger, "m_logger", 212, 5890, 6147);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 212, 5890, 6147);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 212, 5890, 6147);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 212, 5890, 6147);
            TryContext _bcornu_try_context_387 = new TryContext(387, JarContent.class, "java.net.MalformedURLException");
            try {
                if (CallChecker.beforeDeref(m_file, File.class, 216, 5992, 5997)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_file, File.class, 216, 5992, 5997).toURI(), URI.class, 216, 5992, 6005)) {
                        return new URL(((("jar:" + (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(m_file, File.class, 216, 5992, 5997).toURI(), URI.class, 216, 5992, 6005).toURL(), URL.class, 216, 5992, 6013).toExternalForm())) + "!/") + name));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (MalformedURLException e) {
                _bcornu_try_context_387.catchStart(387);
                return null;
            } finally {
                _bcornu_try_context_387.finallyStart(387);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1378.methodEnd();
        }
    }

    public Content getEntryAsContent(String entryName) {
        MethodContext _bcornu_methode_context1379 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 224, 6154, 9290);
            CallChecker.varInit(entryName, "entryName", 224, 6154, 9290);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 224, 6154, 9290);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 224, 6154, 9290);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 224, 6154, 9290);
            CallChecker.varInit(this.m_file, "m_file", 224, 6154, 9290);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 224, 6154, 9290);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 224, 6154, 9290);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 224, 6154, 9290);
            CallChecker.varInit(this.m_configMap, "m_configMap", 224, 6154, 9290);
            CallChecker.varInit(this.m_logger, "m_logger", 224, 6154, 9290);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 224, 6154, 9290);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 224, 6154, 9290);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 224, 6154, 9290);
            if (CallChecker.beforeDeref(entryName, String.class, 228, 6326, 6334)) {
                entryName = CallChecker.beforeCalled(entryName, String.class, 228, 6326, 6334);
                if (CallChecker.isCalled(entryName, String.class, 228, 6326, 6334).equals(FelixConstants.CLASS_PATH_DOT)) {
                    return new JarContent(m_logger, m_configMap, m_zipFactory, m_revisionLock, m_rootDir, m_file, m_zipFile);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(entryName, String.class, 235, 6588, 6596)) {
                entryName = CallChecker.beforeCalled(entryName, String.class, 235, 6588, 6596);
                if (CallChecker.isCalled(entryName, String.class, 235, 6588, 6596).startsWith("/")) {
                    if (CallChecker.beforeDeref(entryName, String.class, 235, 6617, 6625)) {
                        entryName = CallChecker.beforeCalled(entryName, String.class, 235, 6617, 6625);
                        entryName = CallChecker.isCalled(entryName, String.class, 235, 6617, 6625).substring(1);
                        CallChecker.varAssign(entryName, "entryName", 235, 6575, 6651);
                    }
                }else {
                    entryName = entryName;
                    CallChecker.varAssign(entryName, "entryName", 235, 6575, 6651);
                }
            }
            File embedDir = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(m_file, File.class, 240, 6938, 6943)) {
                embedDir = new File(m_rootDir, ((CallChecker.isCalled(m_file, File.class, 240, 6938, 6943).getName()) + (JarContent.EMBEDDED_DIRECTORY)));
                CallChecker.varAssign(embedDir, "embedDir", 240, 6938, 6943);
            }
            ZipEntry ze = CallChecker.init(ZipEntry.class);
            if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 248, 7271, 7279)) {
                ze = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 248, 7271, 7279).getEntry(entryName);
                CallChecker.varAssign(ze, "ze", 248, 7271, 7279);
            }
            if ((ze != null) && (ze.isDirectory())) {
                File extractDir = CallChecker.varInit(new File(embedDir, entryName), "extractDir", 251, 7370, 7417);
                synchronized(m_revisionLock) {
                    final SecureAction npe_invocation_var523 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var523, SecureAction.class, 259, 7782, 7810)) {
                        if (!(CallChecker.isCalled(npe_invocation_var523, SecureAction.class, 259, 7782, 7810).fileExists(extractDir))) {
                            final SecureAction npe_invocation_var524 = BundleCache.getSecureAction();
                            if (CallChecker.beforeDeref(npe_invocation_var524, SecureAction.class, 261, 7879, 7907)) {
                                if (!(CallChecker.isCalled(npe_invocation_var524, SecureAction.class, 261, 7879, 7907).mkdirs(extractDir))) {
                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 263, 7975, 7982)) {
                                        CallChecker.isCalled(m_logger, Logger.class, 263, 7975, 7982).log(Logger.LOG_ERROR, "Unable to extract embedded directory.");
                                    }
                                }
                            }
                        }
                    }
                }
                return new ContentDirectoryContent(this, entryName);
            }else {
                ze = CallChecker.beforeCalled(ze, ZipEntry.class, 271, 8267, 8268);
                if (CallChecker.beforeDeref(CallChecker.isCalled(ze, ZipEntry.class, 271, 8267, 8268).getName(), String.class, 271, 8267, 8278)) {
                    if ((ze != null) && (CallChecker.isCalled(ze.getName(), String.class, 271, 8267, 8278).endsWith(".jar"))) {
                        File extractJar = CallChecker.varInit(new File(embedDir, entryName), "extractJar", 273, 8320, 8367);
                        synchronized(m_revisionLock) {
                            TryContext _bcornu_try_context_388 = new TryContext(388, JarContent.class, "java.lang.Exception");
                            try {
                                extractEmbeddedJar(entryName);
                            } catch (Exception ex) {
                                _bcornu_try_context_388.catchStart(388);
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 287, 8873, 8880)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 287, 8873, 8880).log(Logger.LOG_ERROR, "Unable to extract embedded JAR file.", ex);
                                }
                            } finally {
                                _bcornu_try_context_388.finallyStart(388);
                            }
                        }
                        if (CallChecker.beforeDeref(extractJar, File.class, 294, 9150, 9159)) {
                            extractJar = CallChecker.beforeCalled(extractJar, File.class, 294, 9150, 9159);
                            return new JarContent(m_logger, m_configMap, m_zipFactory, m_revisionLock, CallChecker.isCalled(extractJar, File.class, 294, 9150, 9159).getParentFile(), extractJar, null);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1379.methodEnd();
        }
    }

    public String getEntryAsNativeLibrary(String entryName) {
        MethodContext _bcornu_methode_context1380 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 302, 9293, 15084);
            CallChecker.varInit(entryName, "entryName", 302, 9293, 15084);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 302, 9293, 15084);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 302, 9293, 15084);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 302, 9293, 15084);
            CallChecker.varInit(this.m_file, "m_file", 302, 9293, 15084);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 302, 9293, 15084);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 302, 9293, 15084);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 302, 9293, 15084);
            CallChecker.varInit(this.m_configMap, "m_configMap", 302, 9293, 15084);
            CallChecker.varInit(this.m_logger, "m_logger", 302, 9293, 15084);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 302, 9293, 15084);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 302, 9293, 15084);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 302, 9293, 15084);
            String result = CallChecker.varInit(null, "result", 305, 9450, 9470);
            if (CallChecker.beforeDeref(entryName, String.class, 308, 9531, 9539)) {
                entryName = CallChecker.beforeCalled(entryName, String.class, 308, 9531, 9539);
                if (CallChecker.isCalled(entryName, String.class, 308, 9531, 9539).startsWith("/")) {
                    if (CallChecker.beforeDeref(entryName, String.class, 308, 9560, 9568)) {
                        entryName = CallChecker.beforeCalled(entryName, String.class, 308, 9560, 9568);
                        entryName = CallChecker.isCalled(entryName, String.class, 308, 9560, 9568).substring(1);
                        CallChecker.varAssign(entryName, "entryName", 308, 9518, 9594);
                    }
                }else {
                    entryName = entryName;
                    CallChecker.varAssign(entryName, "entryName", 308, 9518, 9594);
                }
            }
            File libDir = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(m_file, File.class, 313, 9889, 9894)) {
                libDir = new File(m_rootDir, ((CallChecker.isCalled(m_file, File.class, 313, 9889, 9894).getName()) + (JarContent.LIBRARY_DIRECTORY)));
                CallChecker.varAssign(libDir, "libDir", 313, 9889, 9894);
            }
            ZipEntry ze = CallChecker.init(ZipEntry.class);
            if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 317, 10062, 10070)) {
                ze = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 317, 10062, 10070).getEntry(entryName);
                CallChecker.varAssign(ze, "ze", 317, 10062, 10070);
            }
            if ((ze != null) && (!(ze.isDirectory()))) {
                synchronized(m_revisionLock) {
                    if ((m_nativeLibMap) == null) {
                        m_nativeLibMap = new HashMap();
                        CallChecker.varAssign(this.m_nativeLibMap, "this.m_nativeLibMap", 331, 10773, 10803);
                    }
                    Integer libCount = CallChecker.init(Integer.class);
                    if (CallChecker.beforeDeref(m_nativeLibMap, Map.class, 333, 10868, 10881)) {
                        m_nativeLibMap = CallChecker.beforeCalled(m_nativeLibMap, Map.class, 333, 10868, 10881);
                        libCount = ((Integer) (CallChecker.isCalled(m_nativeLibMap, Map.class, 333, 10868, 10881).get(entryName)));
                        CallChecker.varAssign(libCount, "libCount", 333, 10868, 10881);
                    }
                    if (libCount == null) {
                        libCount = new Integer(0);
                        CallChecker.varAssign(libCount, "libCount", 335, 10977, 11062);
                    }else {
                        libCount = new Integer(((libCount.intValue()) + 1));
                        CallChecker.varAssign(libCount, "libCount", 335, 10977, 11062);
                    }
                    if (CallChecker.beforeDeref(m_nativeLibMap, Map.class, 336, 11080, 11093)) {
                        m_nativeLibMap = CallChecker.beforeCalled(m_nativeLibMap, Map.class, 336, 11080, 11093);
                        CallChecker.isCalled(m_nativeLibMap, Map.class, 336, 11080, 11093).put(entryName, libCount);
                    }
                    File libFile = CallChecker.init(File.class);
                    if (CallChecker.beforeDeref(libCount, Integer.class, 338, 11190, 11197)) {
                        libCount = CallChecker.beforeCalled(libCount, Integer.class, 338, 11190, 11197);
                        libFile = new File(libDir, (((CallChecker.isCalled(libCount, Integer.class, 338, 11190, 11197).toString()) + (File.separatorChar)) + entryName));
                        CallChecker.varAssign(libFile, "libFile", 338, 11190, 11197);
                    }
                    final SecureAction npe_invocation_var525 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var525, SecureAction.class, 340, 11267, 11295)) {
                        if (!(CallChecker.isCalled(npe_invocation_var525, SecureAction.class, 340, 11267, 11295).fileExists(libFile))) {
                            if (CallChecker.beforeDeref(libFile, File.class, 342, 11402, 11408)) {
                                final SecureAction npe_invocation_var526 = BundleCache.getSecureAction();
                                if (CallChecker.beforeDeref(npe_invocation_var526, SecureAction.class, 342, 11361, 11389)) {
                                    if (CallChecker.beforeDeref(libFile, File.class, 343, 11492, 11498)) {
                                        final SecureAction npe_invocation_var527 = BundleCache.getSecureAction();
                                        if (CallChecker.beforeDeref(npe_invocation_var527, SecureAction.class, 343, 11455, 11483)) {
                                            libFile = CallChecker.beforeCalled(libFile, File.class, 342, 11402, 11408);
                                            libFile = CallChecker.beforeCalled(libFile, File.class, 343, 11492, 11498);
                                            if ((!(CallChecker.isCalled(npe_invocation_var526, SecureAction.class, 342, 11361, 11389).fileExists(CallChecker.isCalled(libFile, File.class, 342, 11402, 11408).getParentFile()))) && (!(CallChecker.isCalled(npe_invocation_var527, SecureAction.class, 343, 11455, 11483).mkdirs(CallChecker.isCalled(libFile, File.class, 343, 11492, 11498).getParentFile())))) {
                                                if (CallChecker.beforeDeref(m_logger, Logger.class, 345, 11564, 11571)) {
                                                    CallChecker.isCalled(m_logger, Logger.class, 345, 11564, 11571).log(Logger.LOG_ERROR, "Unable to create library directory.");
                                                }
                                            }else {
                                                InputStream is = CallChecker.varInit(null, "is", 351, 11785, 11806);
                                                TryContext _bcornu_try_context_390 = new TryContext(390, JarContent.class, "java.lang.Exception");
                                                try {
                                                    if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 356, 11953, 11961)) {
                                                        is = new BufferedInputStream(CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 356, 11953, 11961).getInputStream(ze), BundleCache.BUFSIZE);
                                                        CallChecker.varAssign(is, "is", 355, 11891, 12035);
                                                    }
                                                    if (is == null) {
                                                        throw new IOException(("No input stream: " + entryName));
                                                    }
                                                    BundleCache.copyStreamToFile(is, libFile);
                                                    String command = CallChecker.init(String.class);
                                                    if (CallChecker.beforeDeref(m_configMap, Map.class, 368, 12541, 12551)) {
                                                        command = ((String) (CallChecker.isCalled(m_configMap, Map.class, 368, 12541, 12551).get(Constants.FRAMEWORK_EXECPERMISSION)));
                                                        CallChecker.varAssign(command, "command", 368, 12541, 12551);
                                                    }
                                                    if (command != null) {
                                                        Properties props = CallChecker.varInit(new Properties(), "props", 372, 12738, 12773);
                                                        if (CallChecker.beforeDeref(libFile, File.class, 373, 12836, 12842)) {
                                                            if (CallChecker.beforeDeref(props, Properties.class, 373, 12807, 12811)) {
                                                                libFile = CallChecker.beforeCalled(libFile, File.class, 373, 12836, 12842);
                                                                props = CallChecker.beforeCalled(props, Properties.class, 373, 12807, 12811);
                                                                CallChecker.isCalled(props, Properties.class, 373, 12807, 12811).setProperty("abspath", CallChecker.isCalled(libFile, File.class, 373, 12836, 12842).toString());
                                                            }
                                                        }
                                                        command = Util.substVars(command, "command", null, props);
                                                        CallChecker.varAssign(command, "command", 374, 12889, 12946);
                                                        final SecureAction npe_invocation_var528 = BundleCache.getSecureAction();
                                                        Process p = CallChecker.init(Process.class);
                                                        if (CallChecker.beforeDeref(npe_invocation_var528, SecureAction.class, 375, 12992, 13020)) {
                                                            p = CallChecker.isCalled(npe_invocation_var528, SecureAction.class, 375, 12992, 13020).exec(command);
                                                            CallChecker.varAssign(p, "p", 375, 12992, 13020);
                                                        }
                                                        Thread stdOut = CallChecker.init(Thread.class);
                                                        if (CallChecker.beforeDeref(p, Process.class, 380, 13383, 13383)) {
                                                            p = CallChecker.beforeCalled(p, Process.class, 380, 13383, 13383);
                                                            stdOut = new Thread(new JarContent.DevNullRunnable(CallChecker.isCalled(p, Process.class, 380, 13383, 13383).getInputStream()));
                                                            CallChecker.varAssign(stdOut, "stdOut", 380, 13383, 13383);
                                                        }
                                                        Thread stdErr = CallChecker.init(Thread.class);
                                                        if (CallChecker.beforeDeref(p, Process.class, 382, 13521, 13521)) {
                                                            p = CallChecker.beforeCalled(p, Process.class, 382, 13521, 13521);
                                                            stdErr = new Thread(new JarContent.DevNullRunnable(CallChecker.isCalled(p, Process.class, 382, 13521, 13521).getErrorStream()));
                                                            CallChecker.varAssign(stdErr, "stdErr", 382, 13521, 13521);
                                                        }
                                                        if (CallChecker.beforeDeref(stdOut, Thread.class, 383, 13575, 13580)) {
                                                            stdOut = CallChecker.beforeCalled(stdOut, Thread.class, 383, 13575, 13580);
                                                            CallChecker.isCalled(stdOut, Thread.class, 383, 13575, 13580).setDaemon(true);
                                                        }
                                                        if (CallChecker.beforeDeref(stdErr, Thread.class, 384, 13631, 13636)) {
                                                            stdErr = CallChecker.beforeCalled(stdErr, Thread.class, 384, 13631, 13636);
                                                            CallChecker.isCalled(stdErr, Thread.class, 384, 13631, 13636).setDaemon(true);
                                                        }
                                                        if (CallChecker.beforeDeref(stdOut, Thread.class, 385, 13687, 13692)) {
                                                            stdOut = CallChecker.beforeCalled(stdOut, Thread.class, 385, 13687, 13692);
                                                            CallChecker.isCalled(stdOut, Thread.class, 385, 13687, 13692).start();
                                                        }
                                                        if (CallChecker.beforeDeref(stdErr, Thread.class, 386, 13735, 13740)) {
                                                            stdErr = CallChecker.beforeCalled(stdErr, Thread.class, 386, 13735, 13740);
                                                            CallChecker.isCalled(stdErr, Thread.class, 386, 13735, 13740).start();
                                                        }
                                                        if (CallChecker.beforeDeref(p, Process.class, 387, 13783, 13783)) {
                                                            p = CallChecker.beforeCalled(p, Process.class, 387, 13783, 13783);
                                                            CallChecker.isCalled(p, Process.class, 387, 13783, 13783).waitFor();
                                                        }
                                                        if (CallChecker.beforeDeref(stdOut, Thread.class, 388, 13828, 13833)) {
                                                            stdOut = CallChecker.beforeCalled(stdOut, Thread.class, 388, 13828, 13833);
                                                            CallChecker.isCalled(stdOut, Thread.class, 388, 13828, 13833).join();
                                                        }
                                                        if (CallChecker.beforeDeref(stdErr, Thread.class, 389, 13875, 13880)) {
                                                            stdErr = CallChecker.beforeCalled(stdErr, Thread.class, 389, 13875, 13880);
                                                            CallChecker.isCalled(stdErr, Thread.class, 389, 13875, 13880).join();
                                                        }
                                                    }
                                                    final SecureAction npe_invocation_var529 = BundleCache.getSecureAction();
                                                    if (CallChecker.beforeDeref(npe_invocation_var529, SecureAction.class, 393, 14038, 14066)) {
                                                        result = CallChecker.isCalled(npe_invocation_var529, SecureAction.class, 393, 14038, 14066).getAbsolutePath(libFile);
                                                        CallChecker.varAssign(result, "result", 393, 14029, 14092);
                                                    }
                                                } catch (Exception ex) {
                                                    _bcornu_try_context_390.catchStart(390);
                                                    if (CallChecker.beforeDeref(m_logger, Logger.class, 397, 14219, 14226)) {
                                                        CallChecker.isCalled(m_logger, Logger.class, 397, 14219, 14226).log(Logger.LOG_ERROR, "Extracting native library.", ex);
                                                    }
                                                } finally {
                                                    _bcornu_try_context_390.finallyStart(390);
                                                    TryContext _bcornu_try_context_389 = new TryContext(389, JarContent.class, "java.io.IOException");
                                                    try {
                                                        if (is != null)
                                                            is.close();
                                                        
                                                    } catch (IOException ex) {
                                                        _bcornu_try_context_389.catchStart(389);
                                                    } finally {
                                                        _bcornu_try_context_389.finallyStart(389);
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
                            final SecureAction npe_invocation_var530 = BundleCache.getSecureAction();
                            if (CallChecker.beforeDeref(npe_invocation_var530, SecureAction.class, 417, 14958, 14986)) {
                                result = CallChecker.isCalled(npe_invocation_var530, SecureAction.class, 417, 14958, 14986).getAbsolutePath(libFile);
                                CallChecker.varAssign(result, "result", 417, 14949, 15012);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1380.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context1381 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 425, 15091, 15168);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 425, 15091, 15168);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 425, 15091, 15168);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 425, 15091, 15168);
            CallChecker.varInit(this.m_file, "m_file", 425, 15091, 15168);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 425, 15091, 15168);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 425, 15091, 15168);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 425, 15091, 15168);
            CallChecker.varInit(this.m_configMap, "m_configMap", 425, 15091, 15168);
            CallChecker.varInit(this.m_logger, "m_logger", 425, 15091, 15168);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 425, 15091, 15168);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 425, 15091, 15168);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 425, 15091, 15168);
            return "JAR " + (CallChecker.isCalled(m_file, File.class, 427, 15146, 15151).getPath());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1381.methodEnd();
        }
    }

    public File getFile() {
        MethodContext _bcornu_methode_context1382 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 430, 15175, 15230);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 430, 15175, 15230);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 430, 15175, 15230);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 430, 15175, 15230);
            CallChecker.varInit(this.m_file, "m_file", 430, 15175, 15230);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 430, 15175, 15230);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 430, 15175, 15230);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 430, 15175, 15230);
            CallChecker.varInit(this.m_configMap, "m_configMap", 430, 15175, 15230);
            CallChecker.varInit(this.m_logger, "m_logger", 430, 15175, 15230);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 430, 15175, 15230);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 430, 15175, 15230);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 430, 15175, 15230);
            return m_file;
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1382.methodEnd();
        }
    }

    private void extractEmbeddedJar(String jarPath) throws Exception {
        MethodContext _bcornu_methode_context1383 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 441, 15237, 17833);
            CallChecker.varInit(jarPath, "jarPath", 441, 15237, 17833);
            CallChecker.varInit(this.m_nativeLibMap, "m_nativeLibMap", 441, 15237, 17833);
            CallChecker.varInit(this.m_isZipFileOwner, "m_isZipFileOwner", 441, 15237, 17833);
            CallChecker.varInit(this.m_zipFile, "m_zipFile", 441, 15237, 17833);
            CallChecker.varInit(this.m_file, "m_file", 441, 15237, 17833);
            CallChecker.varInit(this.m_rootDir, "m_rootDir", 441, 15237, 17833);
            CallChecker.varInit(this.m_revisionLock, "m_revisionLock", 441, 15237, 17833);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 441, 15237, 17833);
            CallChecker.varInit(this.m_configMap, "m_configMap", 441, 15237, 17833);
            CallChecker.varInit(this.m_logger, "m_logger", 441, 15237, 17833);
            CallChecker.varInit(LIBRARY_DIRECTORY, "org.apache.felix.framework.cache.JarContent.LIBRARY_DIRECTORY", 441, 15237, 17833);
            CallChecker.varInit(EMBEDDED_DIRECTORY, "org.apache.felix.framework.cache.JarContent.EMBEDDED_DIRECTORY", 441, 15237, 17833);
            CallChecker.varInit(BUFSIZE, "org.apache.felix.framework.cache.JarContent.BUFSIZE", 441, 15237, 17833);
            if (CallChecker.beforeDeref(jarPath, String.class, 445, 15642, 15648)) {
                if (CallChecker.beforeDeref(jarPath, String.class, 445, 15668, 15674)) {
                    jarPath = CallChecker.beforeCalled(jarPath, String.class, 445, 15642, 15648);
                    jarPath = CallChecker.beforeCalled(jarPath, String.class, 445, 15668, 15674);
                    if (((CallChecker.isCalled(jarPath, String.class, 445, 15642, 15648).length()) > 0) && ((CallChecker.isCalled(jarPath, String.class, 445, 15668, 15674).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(jarPath, String.class, 446, 15708, 15714)) {
                            jarPath = CallChecker.beforeCalled(jarPath, String.class, 446, 15708, 15714);
                            jarPath = CallChecker.isCalled(jarPath, String.class, 446, 15708, 15714).substring(1);
                            CallChecker.varAssign(jarPath, "jarPath", 445, 15631, 15738);
                        }
                    }else {
                        jarPath = jarPath;
                        CallChecker.varAssign(jarPath, "jarPath", 445, 15631, 15738);
                    }
                }
            }
            File embedDir = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(m_file, File.class, 451, 16025, 16030)) {
                embedDir = new File(m_rootDir, ((CallChecker.isCalled(m_file, File.class, 451, 16025, 16030).getName()) + (JarContent.EMBEDDED_DIRECTORY)));
                CallChecker.varAssign(embedDir, "embedDir", 451, 16025, 16030);
            }
            File jarFile = CallChecker.varInit(new File(embedDir, jarPath), "jarFile", 452, 16073, 16115);
            final SecureAction npe_invocation_var531 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var531, SecureAction.class, 454, 16131, 16159)) {
                if (!(CallChecker.isCalled(npe_invocation_var531, SecureAction.class, 454, 16131, 16159).fileExists(jarFile))) {
                    InputStream is = CallChecker.varInit(null, "is", 456, 16204, 16225);
                    TryContext _bcornu_try_context_391 = new TryContext(391, JarContent.class);
                    try {
                        ZipEntry ze = CallChecker.init(ZipEntry.class);
                        if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 460, 16348, 16356)) {
                            ze = CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 460, 16348, 16356).getEntry(jarPath);
                            CallChecker.varAssign(ze, "ze", 460, 16348, 16356);
                        }
                        if (ze == null) {
                            return ;
                        }else
                            if (!(ze.isDirectory())) {
                                File jarDir = CallChecker.init(File.class);
                                if (CallChecker.beforeDeref(jarFile, File.class, 472, 16904, 16910)) {
                                    jarFile = CallChecker.beforeCalled(jarFile, File.class, 472, 16904, 16910);
                                    jarDir = CallChecker.isCalled(jarFile, File.class, 472, 16904, 16910).getParentFile();
                                    CallChecker.varAssign(jarDir, "jarDir", 472, 16904, 16910);
                                }
                                final SecureAction npe_invocation_var532 = BundleCache.getSecureAction();
                                if (CallChecker.beforeDeref(npe_invocation_var532, SecureAction.class, 473, 16954, 16982)) {
                                    if (!(CallChecker.isCalled(npe_invocation_var532, SecureAction.class, 473, 16954, 16982).fileExists(jarDir))) {
                                        final SecureAction npe_invocation_var533 = BundleCache.getSecureAction();
                                        if (CallChecker.beforeDeref(npe_invocation_var533, SecureAction.class, 475, 17055, 17083)) {
                                            if (!(CallChecker.isCalled(npe_invocation_var533, SecureAction.class, 475, 17055, 17083).mkdirs(jarDir))) {
                                                throw new IOException("Unable to create embedded JAR directory.");
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 482, 17384, 17392)) {
                                    is = new BufferedInputStream(CallChecker.isCalled(m_zipFile, WeakZipFileFactory.WeakZipFile.class, 482, 17384, 17392).getInputStream(ze), BundleCache.BUFSIZE);
                                    CallChecker.varAssign(is, "is", 482, 17355, 17434);
                                }
                                if (is == null) {
                                    throw new IOException(("No input stream: " + jarPath));
                                }
                                BundleCache.copyStreamToFile(is, jarFile);
                            }
                        
                    } finally {
                        _bcornu_try_context_391.finallyStart(391);
                        if (is != null)
                            is.close();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1383.methodEnd();
        }
    }

    private static class EntriesEnumeration implements Enumeration<String> {
        private final Enumeration m_enumeration;

        public EntriesEnumeration(Enumeration enumeration) {
            MethodContext _bcornu_methode_context135 = new MethodContext(null);
            try {
                m_enumeration = enumeration;
                CallChecker.varAssign(this.m_enumeration, "this.m_enumeration", 504, 18048, 18075);
            } finally {
                _bcornu_methode_context135.methodEnd();
            }
        }

        public boolean hasMoreElements() {
            MethodContext _bcornu_methode_context1384 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 507, 18096, 18199);
                CallChecker.varInit(this.m_enumeration, "m_enumeration", 507, 18096, 18199);
                if (CallChecker.beforeDeref(m_enumeration, Enumeration.class, 509, 18158, 18170)) {
                    return CallChecker.isCalled(m_enumeration, Enumeration.class, 509, 18158, 18170).hasMoreElements();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1384.methodEnd();
            }
        }

        public String nextElement() {
            MethodContext _bcornu_methode_context1385 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 512, 18210, 18327);
                CallChecker.varInit(this.m_enumeration, "m_enumeration", 512, 18210, 18327);
                if (CallChecker.beforeDeref(m_enumeration, Enumeration.class, 514, 18279, 18291)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_enumeration, Enumeration.class, 514, 18279, 18291).nextElement(), Object.class, 514, 18279, 18305)) {
                        return CallChecker.isCalled(((ZipEntry) (CallChecker.isCalled(m_enumeration, Enumeration.class, 514, 18279, 18291).nextElement())), ZipEntry.class, 514, 18279, 18305).getName();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1385.methodEnd();
            }
        }
    }

    private static class DevNullRunnable implements Runnable {
        private final InputStream m_in;

        public DevNullRunnable(InputStream in) {
            MethodContext _bcornu_methode_context136 = new MethodContext(null);
            try {
                m_in = in;
                CallChecker.varAssign(this.m_in, "this.m_in", 524, 18513, 18522);
            } finally {
                _bcornu_methode_context136.methodEnd();
            }
        }

        public void run() {
            MethodContext _bcornu_methode_context1386 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 527, 18543, 18946);
                CallChecker.varInit(this.m_in, "m_in", 527, 18543, 18946);
                TryContext _bcornu_try_context_393 = new TryContext(393, JarContent.class, "java.lang.Exception");
                try {
                    TryContext _bcornu_try_context_392 = new TryContext(392, JarContent.class);
                    try {
                        while ((CallChecker.isCalled(m_in, InputStream.class, 533, 18666, 18669).read()) != (-1)) {
                        } 
                    } finally {
                        _bcornu_try_context_392.finallyStart(392);
                        if (CallChecker.beforeDeref(m_in, InputStream.class, 537, 18767, 18770)) {
                            CallChecker.isCalled(m_in, InputStream.class, 537, 18767, 18770).close();
                        }
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_393.catchStart(393);
                } finally {
                    _bcornu_try_context_393.finallyStart(393);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1386.methodEnd();
            }
        }
    }
}

