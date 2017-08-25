package org.apache.felix.framework.cache;

import org.apache.felix.framework.util.WeakZipFileFactory;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.SecureAction;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.nio.channels.FileChannel;
import java.io.File;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.felix.framework.Logger;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.OutputStream;

public class BundleCache {
    public static final String CACHE_BUFSIZE_PROP = "felix.cache.bufsize";

    public static final String CACHE_ROOTDIR_PROP = "felix.cache.rootdir";

    public static final String CACHE_LOCKING_PROP = "felix.cache.locking";

    public static final String CACHE_FILELIMIT_PROP = "felix.cache.filelimit";

    public static final String CACHE_SINGLEBUNDLEFILE_PROP = "felix.cache.singlebundlefile";

    protected static transient int BUFSIZE = 4096;

    private static final transient String CACHE_DIR_NAME = "felix-cache";

    private static final transient String CACHE_ROOTDIR_DEFAULT = ".";

    private static final transient String CACHE_LOCK_NAME = "cache.lock";

    static final transient String BUNDLE_DIR_PREFIX = "bundle";

    private static final SecureAction m_secureAction = new SecureAction();

    private final Logger m_logger;

    private final Map m_configMap;

    private final WeakZipFileFactory m_zipFactory;

    private final Object m_lock;

    public BundleCache(Logger logger, Map configMap) throws Exception {
        MethodContext _bcornu_methode_context2 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 104, 4796, 4813);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 105, 4823, 4846);
            int limit = CallChecker.varInit(((int) (0)), "limit", 107, 4857, 4870);
            String limitStr = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 108, 4907, 4917)) {
                limitStr = ((String) (CallChecker.isCalled(m_configMap, Map.class, 108, 4907, 4917).get(BundleCache.CACHE_FILELIMIT_PROP)));
                CallChecker.varAssign(limitStr, "limitStr", 108, 4907, 4917);
            }
            if (limitStr != null) {
                TryContext _bcornu_try_context_7 = new TryContext(7, BundleCache.class, "java.lang.NumberFormatException");
                try {
                    limit = Integer.parseInt(limitStr);
                    CallChecker.varAssign(limit, "limit", 113, 5032, 5066);
                } catch (NumberFormatException ex) {
                    _bcornu_try_context_7.catchStart(7);
                    limit = 0;
                    CallChecker.varAssign(limit, "limit", 117, 5157, 5166);
                } finally {
                    _bcornu_try_context_7.finallyStart(7);
                }
            }
            m_zipFactory = new WeakZipFileFactory(limit);
            CallChecker.varAssign(this.m_zipFactory, "this.m_zipFactory", 120, 5200, 5244);
            File cacheDir = CallChecker.varInit(BundleCache.determineCacheDir(m_configMap), "cacheDir", 123, 5316, 5362);
            final SecureAction npe_invocation_var12 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var12, SecureAction.class, 124, 5377, 5393)) {
                if (!(CallChecker.isCalled(npe_invocation_var12, SecureAction.class, 124, 5377, 5393).fileExists(cacheDir))) {
                    final SecureAction npe_invocation_var13 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var13, SecureAction.class, 126, 5444, 5460)) {
                        if (!(CallChecker.isCalled(npe_invocation_var13, SecureAction.class, 126, 5444, 5460).mkdirs(cacheDir))) {
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 128, 5510, 5517)) {
                                CallChecker.isCalled(m_logger, Logger.class, 128, 5510, 5517).log(Logger.LOG_ERROR, ("Unable to create cache directory: " + cacheDir));
                            }
                            throw new RuntimeException("Unable to create cache directory.");
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            Object locking = CallChecker.init(Object.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 135, 5763, 5773)) {
                locking = CallChecker.isCalled(m_configMap, Map.class, 135, 5763, 5773).get(BundleCache.CACHE_LOCKING_PROP);
                CallChecker.varAssign(locking, "locking", 135, 5763, 5773);
            }
            if (locking == null) {
                if (CallChecker.beforeDeref(Boolean.TRUE, Boolean.class, 137, 5850, 5861)) {
                    locking = CallChecker.isCalled(Boolean.TRUE, Boolean.class, 137, 5850, 5861).toString();
                    CallChecker.varAssign(locking, "locking", 136, 5808, 5920);
                }
            }else {
                locking = CallChecker.beforeCalled(locking, Object.class, 138, 5888, 5894);
                if (CallChecker.beforeDeref(CallChecker.isCalled(locking, Object.class, 138, 5888, 5894).toString(), String.class, 138, 5888, 5905)) {
                    locking = CallChecker.isCalled(locking.toString(), String.class, 138, 5888, 5905).toLowerCase();
                    CallChecker.varAssign(locking, "locking", 136, 5808, 5920);
                }
            }
            if (CallChecker.beforeDeref(Boolean.TRUE, Boolean.class, 139, 5960, 5971)) {
                if (CallChecker.beforeDeref(locking, Object.class, 139, 5944, 5950)) {
                    locking = CallChecker.beforeCalled(locking, String.class, 139, 5944, 5950);
                    if (CallChecker.isCalled(((String) (locking)), String.class, 139, 5944, 5950).equals(CallChecker.isCalled(Boolean.TRUE, Boolean.class, 139, 5960, 5971).toString())) {
                        File lockFile = CallChecker.varInit(new File(cacheDir, BundleCache.CACHE_LOCK_NAME), "lockFile", 141, 6008, 6059);
                        FileChannel fc = CallChecker.varInit(null, "fc", 142, 6073, 6094);
                        FileOutputStream fos = CallChecker.varInit(null, "fos", 143, 6108, 6135);
                        TryContext _bcornu_try_context_9 = new TryContext(9, BundleCache.class, "java.lang.Exception");
                        try {
                            final SecureAction npe_invocation_var14 = BundleCache.getSecureAction();
                            if (CallChecker.beforeDeref(npe_invocation_var14, SecureAction.class, 146, 6188, 6204)) {
                                if (!(CallChecker.isCalled(npe_invocation_var14, SecureAction.class, 146, 6188, 6204).fileExists(lockFile))) {
                                    final SecureAction npe_invocation_var15 = BundleCache.getSecureAction();
                                    if (CallChecker.beforeDeref(npe_invocation_var15, SecureAction.class, 148, 6272, 6288)) {
                                        fos = CallChecker.isCalled(npe_invocation_var15, SecureAction.class, 148, 6272, 6288).getFileOutputStream(lockFile);
                                        CallChecker.varAssign(fos, "fos", 148, 6266, 6319);
                                    }
                                    if (CallChecker.beforeDeref(fos, FileOutputStream.class, 149, 6346, 6348)) {
                                        fos = CallChecker.beforeCalled(fos, FileOutputStream.class, 149, 6346, 6348);
                                        fc = CallChecker.isCalled(fos, FileOutputStream.class, 149, 6346, 6348).getChannel();
                                        CallChecker.varAssign(fc, "fc", 149, 6341, 6362);
                                    }
                                }else {
                                    final SecureAction npe_invocation_var16 = BundleCache.getSecureAction();
                                    if (CallChecker.beforeDeref(npe_invocation_var16, SecureAction.class, 153, 6447, 6463)) {
                                        fos = CallChecker.isCalled(npe_invocation_var16, SecureAction.class, 153, 6447, 6463).getFileOutputStream(lockFile);
                                        CallChecker.varAssign(fos, "fos", 153, 6441, 6494);
                                    }
                                    if (CallChecker.beforeDeref(fos, FileOutputStream.class, 154, 6521, 6523)) {
                                        fos = CallChecker.beforeCalled(fos, FileOutputStream.class, 154, 6521, 6523);
                                        fc = CallChecker.isCalled(fos, FileOutputStream.class, 154, 6521, 6523).getChannel();
                                        CallChecker.varAssign(fc, "fc", 154, 6516, 6537);
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            _bcornu_try_context_9.catchStart(9);
                            TryContext _bcornu_try_context_8 = new TryContext(8, BundleCache.class, "java.lang.Exception");
                            try {
                                if (fos != null)
                                    fos.close();
                                
                                if (fc != null)
                                    fc.close();
                                
                            } catch (Exception ex2) {
                                _bcornu_try_context_8.catchStart(8);
                            } finally {
                                _bcornu_try_context_8.finallyStart(8);
                            }
                            throw new Exception(("Unable to create bundle cache lock file: " + ex));
                        } finally {
                            _bcornu_try_context_9.finallyStart(9);
                        }
                        TryContext _bcornu_try_context_10 = new TryContext(10, BundleCache.class, "java.lang.Exception");
                        try {
                            fc = CallChecker.beforeCalled(fc, FileChannel.class, 172, 7033, 7034);
                            m_lock = CallChecker.isCalled(fc, FileChannel.class, 172, 7033, 7034).tryLock();
                            CallChecker.varAssign(this.m_lock, "this.m_lock", 172, 7024, 7045);
                        } catch (Exception ex) {
                            _bcornu_try_context_10.catchStart(10);
                            throw new Exception(("Unable to lock bundle cache: " + ex));
                        } finally {
                            _bcornu_try_context_10.finallyStart(10);
                        }
                    }else {
                        m_lock = null;
                        CallChecker.varAssign(this.m_lock, "this.m_lock", 181, 7242, 7255);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public synchronized void release() {
        MethodContext _bcornu_methode_context26 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 185, 7278, 7767);
            CallChecker.varInit(this.m_lock, "m_lock", 185, 7278, 7767);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 185, 7278, 7767);
            CallChecker.varInit(this.m_configMap, "m_configMap", 185, 7278, 7767);
            CallChecker.varInit(this.m_logger, "m_logger", 185, 7278, 7767);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 185, 7278, 7767);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 185, 7278, 7767);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 185, 7278, 7767);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 185, 7278, 7767);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 185, 7278, 7767);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 185, 7278, 7767);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 185, 7278, 7767);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 185, 7278, 7767);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 185, 7278, 7767);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 185, 7278, 7767);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 185, 7278, 7767);
            if ((m_lock) != null) {
                TryContext _bcornu_try_context_11 = new TryContext(11, BundleCache.class, "java.lang.Exception");
                try {
                    ((FileLock) (m_lock)).release();
                    if (CallChecker.beforeDeref(CallChecker.isCalled(((FileLock) (m_lock)), FileLock.class, 192, 7462, 7467).channel(), FileChannel.class, 192, 7450, 7478)) {
                        CallChecker.isCalled(((FileLock) (m_lock)).channel(), FileChannel.class, 192, 7450, 7478).close();
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_11.catchStart(11);
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 197, 7623, 7630)) {
                        CallChecker.isCalled(m_logger, Logger.class, 197, 7623, 7630).log(Logger.LOG_WARNING, "Exception releasing bundle cache.", ex);
                    }
                } finally {
                    _bcornu_try_context_11.finallyStart(11);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    static SecureAction getSecureAction() {
        MethodContext _bcornu_methode_context27 = new MethodContext(SecureAction.class);
        try {
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 204, 7774, 7867);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 204, 7774, 7867);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 204, 7774, 7867);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 204, 7774, 7867);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 204, 7774, 7867);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 204, 7774, 7867);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 204, 7774, 7867);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 204, 7774, 7867);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 204, 7774, 7867);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 204, 7774, 7867);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 204, 7774, 7867);
            return BundleCache.m_secureAction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SecureAction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public synchronized void delete() throws Exception {
        MethodContext _bcornu_methode_context28 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 209, 7874, 8069);
            CallChecker.varInit(this.m_lock, "m_lock", 209, 7874, 8069);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 209, 7874, 8069);
            CallChecker.varInit(this.m_configMap, "m_configMap", 209, 7874, 8069);
            CallChecker.varInit(this.m_logger, "m_logger", 209, 7874, 8069);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 209, 7874, 8069);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 209, 7874, 8069);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 209, 7874, 8069);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 209, 7874, 8069);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 209, 7874, 8069);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 209, 7874, 8069);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 209, 7874, 8069);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 209, 7874, 8069);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 209, 7874, 8069);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 209, 7874, 8069);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 209, 7874, 8069);
            File cacheDir = CallChecker.varInit(BundleCache.determineCacheDir(m_configMap), "cacheDir", 212, 7978, 8024);
            BundleCache.deleteDirectoryTree(cacheDir);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public BundleArchive[] getArchives() throws Exception {
        MethodContext _bcornu_methode_context29 = new MethodContext(BundleArchive[].class);
        try {
            CallChecker.varInit(this, "this", 216, 8076, 9860);
            CallChecker.varInit(this.m_lock, "m_lock", 216, 8076, 9860);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 216, 8076, 9860);
            CallChecker.varInit(this.m_configMap, "m_configMap", 216, 8076, 9860);
            CallChecker.varInit(this.m_logger, "m_logger", 216, 8076, 9860);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 216, 8076, 9860);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 216, 8076, 9860);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 216, 8076, 9860);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 216, 8076, 9860);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 216, 8076, 9860);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 216, 8076, 9860);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 216, 8076, 9860);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 216, 8076, 9860);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 216, 8076, 9860);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 216, 8076, 9860);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 216, 8076, 9860);
            TryContext _bcornu_try_context_12 = new TryContext(12, BundleCache.class, "java.lang.NumberFormatException");
            try {
                String sBufSize = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(m_configMap, Map.class, 222, 8239, 8249)) {
                    sBufSize = ((String) (CallChecker.isCalled(m_configMap, Map.class, 222, 8239, 8249).get(BundleCache.CACHE_BUFSIZE_PROP)));
                    CallChecker.varAssign(sBufSize, "sBufSize", 222, 8239, 8249);
                }
                if (sBufSize != null) {
                    BundleCache.BUFSIZE = Integer.parseInt(sBufSize);
                    CallChecker.varAssign(BundleCache.BUFSIZE, "BundleCache.BUFSIZE", 225, 8340, 8376);
                }
            } catch (NumberFormatException ne) {
                _bcornu_try_context_12.catchStart(12);
            } finally {
                _bcornu_try_context_12.finallyStart(12);
            }
            File cacheDir = CallChecker.varInit(BundleCache.determineCacheDir(m_configMap), "cacheDir", 234, 8589, 8635);
            List archiveList = CallChecker.varInit(new ArrayList(), "archiveList", 235, 8645, 8679);
            final SecureAction npe_invocation_var17 = BundleCache.getSecureAction();
            File[] children = CallChecker.init(File[].class);
            if (CallChecker.beforeDeref(npe_invocation_var17, SecureAction.class, 236, 8707, 8723)) {
                children = CallChecker.isCalled(npe_invocation_var17, SecureAction.class, 236, 8707, 8723).listDirectory(cacheDir);
                CallChecker.varAssign(children, "children", 236, 8707, 8723);
            }
            children = CallChecker.beforeCalled(children, File[].class, 237, 8801, 8808);
            for (int i = 0; (children != null) && (i < (CallChecker.isCalled(children, File[].class, 237, 8801, 8808).length)); i++) {
                children = CallChecker.beforeCalled(children, File[].class, 241, 8965, 8972);
                if (CallChecker.beforeDeref(CallChecker.isCalled(children, File[].class, 241, 8965, 8972)[i], File.class, 241, 8965, 8975)) {
                    children = CallChecker.beforeCalled(children, File[].class, 241, 8965, 8972);
                    CallChecker.isCalled(children, File[].class, 241, 8965, 8972)[i] = CallChecker.beforeCalled(CallChecker.isCalled(children, File[].class, 241, 8965, 8972)[i], File.class, 241, 8965, 8975);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(children, File[].class, 241, 8965, 8972)[i], File.class, 241, 8965, 8975).getName(), String.class, 241, 8965, 8985)) {
                        children = CallChecker.beforeCalled(children, File[].class, 242, 9037, 9044);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(children, File[].class, 242, 9037, 9044)[i], File.class, 242, 9037, 9047)) {
                            children = CallChecker.beforeCalled(children, File[].class, 242, 9037, 9044);
                            CallChecker.isCalled(children, File[].class, 242, 9037, 9044)[i] = CallChecker.beforeCalled(CallChecker.isCalled(children, File[].class, 242, 9037, 9044)[i], File.class, 242, 9037, 9047);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(children, File[].class, 242, 9037, 9044)[i], File.class, 242, 9037, 9047).getName(), String.class, 242, 9037, 9057)) {
                                children[i] = CallChecker.beforeCalled(children[i], File.class, 241, 8965, 8975);
                                children[i] = CallChecker.beforeCalled(children[i], File.class, 242, 9037, 9047);
                                if ((CallChecker.isCalled(CallChecker.isCalled(children[i], File.class, 241, 8965, 8975).getName(), String.class, 241, 8965, 8985).startsWith(BundleCache.BUNDLE_DIR_PREFIX)) && (!(CallChecker.isCalled(CallChecker.isCalled(children[i], File.class, 242, 9037, 9047).getName(), String.class, 242, 9037, 9057).equals(((BundleCache.BUNDLE_DIR_PREFIX) + (Long.toString(0))))))) {
                                    TryContext _bcornu_try_context_13 = new TryContext(13, BundleCache.class, "java.lang.Exception");
                                    try {
                                        if (CallChecker.beforeDeref(archiveList, List.class, 247, 9225, 9235)) {
                                            archiveList = CallChecker.beforeCalled(archiveList, List.class, 247, 9225, 9235);
                                            CallChecker.isCalled(archiveList, List.class, 247, 9225, 9235).add(new BundleArchive(m_logger, m_configMap, m_zipFactory, children[i]));
                                        }
                                    } catch (Exception ex) {
                                        _bcornu_try_context_13.catchStart(13);
                                        if (CallChecker.beforeDeref(m_logger, Logger.class, 254, 9532, 9539)) {
                                            CallChecker.isCalled(m_logger, Logger.class, 254, 9532, 9539).log(Logger.LOG_ERROR, ("Error reloading cached bundle, removing it: " + (children[i])), ex);
                                        }
                                        BundleCache.deleteDirectoryTree(children[i]);
                                    } finally {
                                        _bcornu_try_context_13.finallyStart(13);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(archiveList, List.class, 262, 9834, 9844)) {
                if (CallChecker.beforeDeref(archiveList, List.class, 262, 9796, 9806)) {
                    archiveList = CallChecker.beforeCalled(archiveList, List.class, 262, 9834, 9844);
                    archiveList = CallChecker.beforeCalled(archiveList, List.class, 262, 9796, 9806);
                    return ((BundleArchive[]) (CallChecker.isCalled(archiveList, List.class, 262, 9796, 9806).toArray(new BundleArchive[CallChecker.isCalled(archiveList, List.class, 262, 9834, 9844).size()])));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleArchive[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public BundleArchive create(long id, int startLevel, String location, InputStream is) throws Exception {
        MethodContext _bcornu_methode_context30 = new MethodContext(BundleArchive.class);
        try {
            CallChecker.varInit(this, "this", 265, 9867, 10961);
            CallChecker.varInit(is, "is", 265, 9867, 10961);
            CallChecker.varInit(location, "location", 265, 9867, 10961);
            CallChecker.varInit(startLevel, "startLevel", 265, 9867, 10961);
            CallChecker.varInit(id, "id", 265, 9867, 10961);
            CallChecker.varInit(this.m_lock, "m_lock", 265, 9867, 10961);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 265, 9867, 10961);
            CallChecker.varInit(this.m_configMap, "m_configMap", 265, 9867, 10961);
            CallChecker.varInit(this.m_logger, "m_logger", 265, 9867, 10961);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 265, 9867, 10961);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 265, 9867, 10961);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 265, 9867, 10961);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 265, 9867, 10961);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 265, 9867, 10961);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 265, 9867, 10961);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 265, 9867, 10961);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 265, 9867, 10961);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 265, 9867, 10961);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 265, 9867, 10961);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 265, 9867, 10961);
            File cacheDir = CallChecker.varInit(BundleCache.determineCacheDir(m_configMap), "cacheDir", 268, 9992, 10038);
            File archiveRootDir = CallChecker.varInit(new File(cacheDir, ((BundleCache.BUNDLE_DIR_PREFIX) + (Long.toString(id)))), "archiveRootDir", 271, 10094, 10185);
            TryContext _bcornu_try_context_14 = new TryContext(14, BundleCache.class, "java.lang.Exception");
            try {
                BundleArchive ba = CallChecker.varInit(new BundleArchive(m_logger, m_configMap, m_zipFactory, archiveRootDir, id, startLevel, location, is), "ba", 277, 10292, 10468);
                return ba;
            } catch (Exception ex) {
                _bcornu_try_context_14.catchStart(14);
                if (CallChecker.beforeDeref(BundleCache.m_secureAction, SecureAction.class, 285, 10558, 10571)) {
                    if (CallChecker.isCalled(BundleCache.m_secureAction, SecureAction.class, 285, 10558, 10571).fileExists(archiveRootDir)) {
                        if (!(BundleCache.deleteDirectoryTree(archiveRootDir))) {
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 289, 10723, 10730)) {
                                CallChecker.isCalled(m_logger, Logger.class, 289, 10723, 10730).log(Logger.LOG_ERROR, ("Unable to delete the archive directory: " + archiveRootDir));
                            }
                        }
                    }
                }
                throw ex;
            } finally {
                _bcornu_try_context_14.finallyStart(14);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleArchive) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public File getSystemBundleDataFile(String fileName) throws Exception {
        MethodContext _bcornu_methode_context31 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 307, 10968, 12671);
            CallChecker.varInit(fileName, "fileName", 307, 10968, 12671);
            CallChecker.varInit(this.m_lock, "m_lock", 307, 10968, 12671);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 307, 10968, 12671);
            CallChecker.varInit(this.m_configMap, "m_configMap", 307, 10968, 12671);
            CallChecker.varInit(this.m_logger, "m_logger", 307, 10968, 12671);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 307, 10968, 12671);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 307, 10968, 12671);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 307, 10968, 12671);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 307, 10968, 12671);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 307, 10968, 12671);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 307, 10968, 12671);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 307, 10968, 12671);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 307, 10968, 12671);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 307, 10968, 12671);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 307, 10968, 12671);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 307, 10968, 12671);
            File sbDir = CallChecker.varInit(new File(BundleCache.determineCacheDir(m_configMap), ((BundleCache.BUNDLE_DIR_PREFIX) + (Long.toString(0)))), "sbDir", 311, 11546, 11637);
            final SecureAction npe_invocation_var18 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var18, SecureAction.class, 315, 11779, 11795)) {
                if (!(CallChecker.isCalled(npe_invocation_var18, SecureAction.class, 315, 11779, 11795).fileExists(sbDir))) {
                    final SecureAction npe_invocation_var19 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var19, SecureAction.class, 318, 11912, 11928)) {
                        if (!(CallChecker.isCalled(npe_invocation_var19, SecureAction.class, 318, 11912, 11928).mkdirs(sbDir))) {
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 320, 11975, 11982)) {
                                CallChecker.isCalled(m_logger, Logger.class, 320, 11975, 11982).log(Logger.LOG_ERROR, "Unable to create system bundle directory.");
                            }
                            throw new IOException("Unable to create system bundle directory.");
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(fileName, String.class, 328, 12251, 12258)) {
                if (CallChecker.beforeDeref(fileName, String.class, 328, 12278, 12285)) {
                    fileName = CallChecker.beforeCalled(fileName, String.class, 328, 12251, 12258);
                    fileName = CallChecker.beforeCalled(fileName, String.class, 328, 12278, 12285);
                    if (((CallChecker.isCalled(fileName, String.class, 328, 12251, 12258).length()) > 0) && ((CallChecker.isCalled(fileName, String.class, 328, 12278, 12285).charAt(0)) == (File.separatorChar)))
                        throw new IllegalArgumentException("The data file path must be relative, not absolute.");
                    else
                        if (CallChecker.beforeDeref(fileName, String.class, 330, 12440, 12447)) {
                            fileName = CallChecker.beforeCalled(fileName, String.class, 330, 12440, 12447);
                            if ((CallChecker.isCalled(fileName, String.class, 330, 12440, 12447).indexOf("..")) >= 0)
                                throw new IllegalArgumentException("The data file path cannot contain a reference to the \"..\" directory.");
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return new File(sbDir, fileName);
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    static void copyStreamToFile(InputStream is, File outputFile) throws IOException {
        MethodContext _bcornu_methode_context32 = new MethodContext(void.class);
        try {
            CallChecker.varInit(outputFile, "outputFile", 346, 12678, 13520);
            CallChecker.varInit(is, "is", 346, 12678, 13520);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 346, 12678, 13520);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 346, 12678, 13520);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 346, 12678, 13520);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 346, 12678, 13520);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 346, 12678, 13520);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 346, 12678, 13520);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 346, 12678, 13520);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 346, 12678, 13520);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 346, 12678, 13520);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 346, 12678, 13520);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 346, 12678, 13520);
            OutputStream os = CallChecker.varInit(null, "os", 349, 13042, 13064);
            TryContext _bcornu_try_context_15 = new TryContext(15, BundleCache.class);
            try {
                final SecureAction npe_invocation_var20 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var20, SecureAction.class, 353, 13106, 13122)) {
                    os = CallChecker.isCalled(npe_invocation_var20, SecureAction.class, 353, 13106, 13122).getFileOutputStream(outputFile);
                    CallChecker.varAssign(os, "os", 353, 13101, 13155);
                }
                os = new BufferedOutputStream(os, BundleCache.BUFSIZE);
                CallChecker.varAssign(os, "os", 354, 13169, 13211);
                byte[] b = CallChecker.varInit(new byte[BundleCache.BUFSIZE], "b", 355, 13225, 13253);
                int len = CallChecker.varInit(((int) (0)), "len", 356, 13267, 13278);
                is = CallChecker.beforeCalled(is, InputStream.class, 357, 13306, 13307);
                while ((len = CallChecker.isCalled(is, InputStream.class, 357, 13306, 13307).read(b)) != (-1)) {
                    CallChecker.varAssign(len, "len", 357, 13299, 13316);
                    if (CallChecker.beforeDeref(os, OutputStream.class, 359, 13355, 13356)) {
                        os = CallChecker.beforeCalled(os, OutputStream.class, 359, 13355, 13356);
                        CallChecker.isCalled(os, OutputStream.class, 359, 13355, 13356).write(b, 0, len);
                    }
                } 
            } finally {
                _bcornu_try_context_15.finallyStart(15);
                if (is != null)
                    is.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    static boolean deleteDirectoryTree(File target) {
        MethodContext _bcornu_methode_context33 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(target, "target", 369, 13527, 14092);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 369, 13527, 14092);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 369, 13527, 14092);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 369, 13527, 14092);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 369, 13527, 14092);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 369, 13527, 14092);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 369, 13527, 14092);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 369, 13527, 14092);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 369, 13527, 14092);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 369, 13527, 14092);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 369, 13527, 14092);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 369, 13527, 14092);
            if (!(BundleCache.deleteDirectoryTreeRecursive(target))) {
                System.gc();
                System.gc();
                return BundleCache.deleteDirectoryTreeRecursive(target);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    private static File determineCacheDir(Map configMap) {
        MethodContext _bcornu_methode_context34 = new MethodContext(File.class);
        try {
            CallChecker.varInit(configMap, "configMap", 389, 14099, 15250);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 389, 14099, 15250);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 389, 14099, 15250);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 389, 14099, 15250);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 389, 14099, 15250);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 389, 14099, 15250);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 389, 14099, 15250);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 389, 14099, 15250);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 389, 14099, 15250);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 389, 14099, 15250);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 389, 14099, 15250);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 389, 14099, 15250);
            File cacheDir = CallChecker.init(File.class);
            String cacheDirStr = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(configMap, Map.class, 395, 14369, 14377)) {
                configMap = CallChecker.beforeCalled(configMap, Map.class, 395, 14369, 14377);
                cacheDirStr = ((String) (CallChecker.isCalled(configMap, Map.class, 395, 14369, 14377).get(Constants.FRAMEWORK_STORAGE)));
                CallChecker.varAssign(cacheDirStr, "cacheDirStr", 395, 14369, 14377);
            }
            String rootDirStr = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(configMap, Map.class, 397, 14530, 14538)) {
                configMap = CallChecker.beforeCalled(configMap, Map.class, 397, 14530, 14538);
                rootDirStr = ((String) (CallChecker.isCalled(configMap, Map.class, 397, 14530, 14538).get(BundleCache.CACHE_ROOTDIR_PROP)));
                CallChecker.varAssign(rootDirStr, "rootDirStr", 397, 14530, 14538);
            }
            if (rootDirStr == null) {
                rootDirStr = BundleCache.CACHE_ROOTDIR_DEFAULT;
                CallChecker.varAssign(rootDirStr, "rootDirStr", 398, 14573, 14643);
            }else {
                rootDirStr = rootDirStr;
                CallChecker.varAssign(rootDirStr, "rootDirStr", 398, 14573, 14643);
            }
            if (cacheDirStr != null) {
                cacheDir = new File(cacheDirStr);
                CallChecker.varAssign(cacheDir, "cacheDir", 403, 14836, 14868);
                if (CallChecker.beforeDeref(cacheDir, File.class, 404, 14887, 14894)) {
                    cacheDir = CallChecker.beforeCalled(cacheDir, File.class, 404, 14887, 14894);
                    if (!(CallChecker.isCalled(cacheDir, File.class, 404, 14887, 14894).isAbsolute())) {
                        cacheDir = new File(rootDirStr, cacheDirStr);
                        CallChecker.varAssign(cacheDir, "cacheDir", 406, 14940, 14984);
                    }
                }
            }else {
                cacheDir = new File(rootDirStr, BundleCache.CACHE_DIR_NAME);
                CallChecker.varAssign(cacheDir, "cacheDir", 413, 15161, 15208);
            }
            return cacheDir;
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    private static boolean deleteDirectoryTreeRecursive(File target) {
        MethodContext _bcornu_methode_context35 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(target, "target", 419, 15257, 15833);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.cache.BundleCache.m_secureAction", 419, 15257, 15833);
            CallChecker.varInit(BUNDLE_DIR_PREFIX, "org.apache.felix.framework.cache.BundleCache.BUNDLE_DIR_PREFIX", 419, 15257, 15833);
            CallChecker.varInit(CACHE_LOCK_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCK_NAME", 419, 15257, 15833);
            CallChecker.varInit(CACHE_ROOTDIR_DEFAULT, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_DEFAULT", 419, 15257, 15833);
            CallChecker.varInit(CACHE_DIR_NAME, "org.apache.felix.framework.cache.BundleCache.CACHE_DIR_NAME", 419, 15257, 15833);
            CallChecker.varInit(BundleCache.BUFSIZE, "org.apache.felix.framework.cache.BundleCache.BUFSIZE", 419, 15257, 15833);
            CallChecker.varInit(CACHE_SINGLEBUNDLEFILE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_SINGLEBUNDLEFILE_PROP", 419, 15257, 15833);
            CallChecker.varInit(CACHE_FILELIMIT_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_FILELIMIT_PROP", 419, 15257, 15833);
            CallChecker.varInit(CACHE_LOCKING_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_LOCKING_PROP", 419, 15257, 15833);
            CallChecker.varInit(CACHE_ROOTDIR_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_ROOTDIR_PROP", 419, 15257, 15833);
            CallChecker.varInit(CACHE_BUFSIZE_PROP, "org.apache.felix.framework.cache.BundleCache.CACHE_BUFSIZE_PROP", 419, 15257, 15833);
            final SecureAction npe_invocation_var21 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var21, SecureAction.class, 421, 15338, 15354)) {
                if (!(CallChecker.isCalled(npe_invocation_var21, SecureAction.class, 421, 15338, 15354).fileExists(target))) {
                    return true;
                }
            }else
                throw new AbnormalExecutionError();
            
            final SecureAction npe_invocation_var22 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var22, SecureAction.class, 426, 15434, 15450)) {
                if (CallChecker.isCalled(npe_invocation_var22, SecureAction.class, 426, 15434, 15450).isFileDirectory(target)) {
                    final SecureAction npe_invocation_var23 = BundleCache.getSecureAction();
                    File[] files = CallChecker.init(File[].class);
                    if (CallChecker.beforeDeref(npe_invocation_var23, SecureAction.class, 428, 15514, 15530)) {
                        files = CallChecker.isCalled(npe_invocation_var23, SecureAction.class, 428, 15514, 15530).listDirectory(target);
                        CallChecker.varAssign(files, "files", 428, 15514, 15530);
                    }
                    if (files != null) {
                        for (int i = 0; i < (files.length); i++) {
                            BundleCache.deleteDirectoryTreeRecursive(files[i]);
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            final SecureAction npe_invocation_var24 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var24, SecureAction.class, 438, 15791, 15807)) {
                return CallChecker.isCalled(npe_invocation_var24, SecureAction.class, 438, 15791, 15807).deleteFile(target);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }
}

