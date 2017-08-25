package org.apache.felix.framework.cache;

import org.apache.felix.framework.util.WeakZipFileFactory;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.StringMap;
import org.apache.felix.framework.util.SecureAction;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.io.File;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.InputStream;
import org.apache.felix.framework.Logger;
import java.util.jar.Manifest;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

class DirectoryRevision extends BundleArchiveRevision {
    private final WeakZipFileFactory m_zipFactory;

    private final File m_refDir;

    public DirectoryRevision(Logger logger, Map configMap, WeakZipFileFactory zipFactory, File revisionRootDir, String location) throws Exception {
        super(logger, configMap, revisionRootDir, location);
        MethodContext _bcornu_methode_context45 = new MethodContext(null);
        try {
            m_zipFactory = zipFactory;
            CallChecker.varAssign(this.m_zipFactory, "this.m_zipFactory", 48, 1743, 1768);
            location = CallChecker.beforeCalled(location, String.class, 50, 1830, 1837);
            location = CallChecker.beforeCalled(location, String.class, 49, 1798, 1805);
            m_refDir = new File(CallChecker.isCalled(location, String.class, 49, 1798, 1805).substring(((CallChecker.isCalled(location, String.class, 50, 1830, 1837).indexOf(BundleArchive.FILE_PROTOCOL)) + (CallChecker.isCalled(BundleArchive.FILE_PROTOCOL, String.class, 51, 1894, 1920).length()))));
            CallChecker.varAssign(this.m_refDir, "this.m_refDir", 49, 1778, 1932);
            final SecureAction npe_invocation_var179 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var179, SecureAction.class, 55, 2068, 2096)) {
                if (CallChecker.isCalled(npe_invocation_var179, SecureAction.class, 55, 2068, 2096).fileExists(getRevisionRootDir())) {
                    return ;
                }
            }else
                throw new AbnormalExecutionError();
            
            final SecureAction npe_invocation_var180 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var180, SecureAction.class, 63, 2388, 2416)) {
                if (!(CallChecker.isCalled(npe_invocation_var180, SecureAction.class, 63, 2388, 2416).mkdir(getRevisionRootDir()))) {
                    if (CallChecker.beforeDeref(getClass(), Class.class, 67, 2536, 2545)) {
                        final Logger npe_invocation_var181 = getLogger();
                        if (CallChecker.beforeDeref(npe_invocation_var181, Logger.class, 65, 2469, 2479)) {
                            CallChecker.isCalled(npe_invocation_var181, Logger.class, 65, 2469, 2479).log(Logger.LOG_ERROR, ((CallChecker.isCalled(getClass(), Class.class, 67, 2536, 2545).getName()) + ": Unable to create revision directory."));
                        }
                    }
                    throw new IOException("Unable to create archive directory.");
                }
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public synchronized Map getManifestHeader() throws Exception {
        MethodContext _bcornu_methode_context544 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 72, 2697, 3501);
            CallChecker.varInit(this.m_refDir, "m_refDir", 72, 2697, 3501);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 72, 2697, 3501);
            InputStream is = CallChecker.varInit(null, "is", 76, 2842, 2863);
            TryContext _bcornu_try_context_138 = new TryContext(138, DirectoryRevision.class);
            try {
                final SecureAction npe_invocation_var182 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var182, SecureAction.class, 81, 2940, 2968)) {
                    is = CallChecker.isCalled(npe_invocation_var182, SecureAction.class, 81, 2940, 2968).getFileInputStream(new File(m_refDir, "META-INF/MANIFEST.MF"));
                    CallChecker.varAssign(is, "is", 81, 2935, 3049);
                }
                if (is == null) {
                    throw new IOException("No manifest file found.");
                }
                Manifest mf = CallChecker.varInit(new Manifest(is), "mf", 90, 3252, 3282);
                if (CallChecker.beforeDeref(mf, Manifest.class, 92, 3386, 3387)) {
                    mf = CallChecker.beforeCalled(mf, Manifest.class, 92, 3386, 3387);
                    return new StringMap(CallChecker.isCalled(mf, Manifest.class, 92, 3386, 3387).getMainAttributes());
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_138.finallyStart(138);
                if (is != null)
                    is.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context544.methodEnd();
        }
    }

    public synchronized Content getContent() throws Exception {
        MethodContext _bcornu_methode_context545 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 100, 3508, 3703);
            CallChecker.varInit(this.m_refDir, "m_refDir", 100, 3508, 3703);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 100, 3508, 3703);
            return new DirectoryContent(getLogger(), getConfig(), m_zipFactory, this, getRevisionRootDir(), m_refDir);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context545.methodEnd();
        }
    }

    protected void close() throws Exception {
        MethodContext _bcornu_methode_context546 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 106, 3710, 3945);
            CallChecker.varInit(this.m_refDir, "m_refDir", 106, 3710, 3945);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 106, 3710, 3945);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context546.methodEnd();
        }
    }
}

