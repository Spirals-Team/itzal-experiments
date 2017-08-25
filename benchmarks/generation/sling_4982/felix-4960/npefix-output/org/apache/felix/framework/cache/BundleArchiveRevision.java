package org.apache.felix.framework.cache;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import org.apache.felix.framework.Logger;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import fr.inria.spirals.npefix.resi.CallChecker;

public abstract class BundleArchiveRevision {
    private final Logger m_logger;

    private final Map m_configMap;

    private final File m_revisionRootDir;

    private final String m_location;

    public BundleArchiveRevision(Logger logger, Map configMap, File revisionRootDir, String location) throws Exception {
        MethodContext _bcornu_methode_context70 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 70, 3186, 3203);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 71, 3213, 3236);
            m_revisionRootDir = revisionRootDir;
            CallChecker.varAssign(this.m_revisionRootDir, "this.m_revisionRootDir", 72, 3246, 3281);
            m_location = location;
            CallChecker.varAssign(this.m_location, "this.m_location", 73, 3291, 3312);
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }

    public Logger getLogger() {
        MethodContext _bcornu_methode_context825 = new MethodContext(Logger.class);
        try {
            CallChecker.varInit(this, "this", 82, 3325, 3524);
            CallChecker.varInit(this.m_location, "m_location", 82, 3325, 3524);
            CallChecker.varInit(this.m_revisionRootDir, "m_revisionRootDir", 82, 3325, 3524);
            CallChecker.varInit(this.m_configMap, "m_configMap", 82, 3325, 3524);
            CallChecker.varInit(this.m_logger, "m_logger", 82, 3325, 3524);
            return m_logger;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Logger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context825.methodEnd();
        }
    }

    public Map getConfig() {
        MethodContext _bcornu_methode_context826 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 93, 3531, 3743);
            CallChecker.varInit(this.m_location, "m_location", 93, 3531, 3743);
            CallChecker.varInit(this.m_revisionRootDir, "m_revisionRootDir", 93, 3531, 3743);
            CallChecker.varInit(this.m_configMap, "m_configMap", 93, 3531, 3743);
            CallChecker.varInit(this.m_logger, "m_logger", 93, 3531, 3743);
            return m_configMap;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context826.methodEnd();
        }
    }

    public File getRevisionRootDir() {
        MethodContext _bcornu_methode_context827 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 104, 3750, 3972);
            CallChecker.varInit(this.m_location, "m_location", 104, 3750, 3972);
            CallChecker.varInit(this.m_revisionRootDir, "m_revisionRootDir", 104, 3750, 3972);
            CallChecker.varInit(this.m_configMap, "m_configMap", 104, 3750, 3972);
            CallChecker.varInit(this.m_logger, "m_logger", 104, 3750, 3972);
            return m_revisionRootDir;
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context827.methodEnd();
        }
    }

    public String getLocation() {
        MethodContext _bcornu_methode_context828 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 115, 3979, 4187);
            CallChecker.varInit(this.m_location, "m_location", 115, 3979, 4187);
            CallChecker.varInit(this.m_revisionRootDir, "m_revisionRootDir", 115, 3979, 4187);
            CallChecker.varInit(this.m_configMap, "m_configMap", 115, 3979, 4187);
            CallChecker.varInit(this.m_logger, "m_logger", 115, 3979, 4187);
            return m_location;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context828.methodEnd();
        }
    }

    public abstract Map getManifestHeader() throws Exception;

    public abstract Content getContent() throws Exception;

    protected abstract void close() throws Exception;
}

