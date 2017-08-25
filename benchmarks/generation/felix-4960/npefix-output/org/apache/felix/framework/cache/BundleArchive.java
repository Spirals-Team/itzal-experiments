package org.apache.felix.framework.cache;

import org.apache.felix.framework.util.WeakZipFileFactory;
import java.io.UnsupportedEncodingException;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.TreeMap;
import java.util.SortedMap;
import org.apache.felix.framework.util.SecureAction;
import java.io.OutputStreamWriter;
import java.io.File;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.io.ByteArrayOutputStream;
import org.osgi.framework.Bundle;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.io.FileNotFoundException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.felix.framework.Logger;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.OutputStream;

public class BundleArchive {
    public static final transient String FILE_PROTOCOL = "file:";

    public static final transient String REFERENCE_PROTOCOL = "reference:";

    public static final transient String INPUTSTREAM_PROTOCOL = "inputstream:";

    private static final transient String BUNDLE_INFO_FILE = "bundle.info";

    private static final transient String REVISION_LOCATION_FILE = "revision.location";

    private static final transient String REVISION_DIRECTORY = "version";

    private static final transient String DATA_DIRECTORY = "data";

    private final Logger m_logger;

    private final Map m_configMap;

    private final WeakZipFileFactory m_zipFactory;

    private final File m_archiveRootDir;

    private final boolean m_isSingleBundleFile;

    private long m_id = -1;

    private String m_originalLocation = null;

    private int m_persistentState = -1;

    private int m_startLevel = -1;

    private long m_lastModified = -1;

    private long m_refreshCount = -1;

    private final SortedMap<Long, BundleArchiveRevision> m_revisions = new TreeMap<Long, BundleArchiveRevision>();

    public BundleArchive(Logger logger, Map configMap, WeakZipFileFactory zipFactory, File archiveRootDir, long id, int startLevel, String location, InputStream is) throws Exception {
        MethodContext _bcornu_methode_context176 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 130, 6142, 6159);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 131, 6169, 6192);
            m_zipFactory = zipFactory;
            CallChecker.varAssign(this.m_zipFactory, "this.m_zipFactory", 132, 6202, 6227);
            m_archiveRootDir = archiveRootDir;
            CallChecker.varAssign(this.m_archiveRootDir, "this.m_archiveRootDir", 133, 6237, 6270);
            m_id = id;
            CallChecker.varAssign(this.m_id, "this.m_id", 134, 6280, 6289);
            if ((m_id) <= 0) {
                throw new IllegalArgumentException("Bundle ID cannot be less than or equal to zero.");
            }
            m_originalLocation = location;
            CallChecker.varAssign(this.m_originalLocation, "this.m_originalLocation", 140, 6458, 6487);
            m_persistentState = Bundle.INSTALLED;
            CallChecker.varAssign(this.m_persistentState, "this.m_persistentState", 141, 6497, 6533);
            m_startLevel = startLevel;
            CallChecker.varAssign(this.m_startLevel, "this.m_startLevel", 142, 6543, 6568);
            m_lastModified = System.currentTimeMillis();
            CallChecker.varAssign(this.m_lastModified, "this.m_lastModified", 143, 6578, 6621);
            m_refreshCount = 0;
            CallChecker.varAssign(this.m_refreshCount, "this.m_refreshCount", 144, 6631, 6649);
            String s = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 146, 6680, 6690)) {
                s = ((String) (CallChecker.isCalled(m_configMap, Map.class, 146, 6680, 6690).get(BundleCache.CACHE_SINGLEBUNDLEFILE_PROP)));
                CallChecker.varAssign(s, "s", 146, 6680, 6690);
            }
            if ((s == null) || (s.equalsIgnoreCase("true"))) {
                m_isSingleBundleFile = true;
                CallChecker.varAssign(this.m_isSingleBundleFile, "this.m_isSingleBundleFile", 147, 6746, 6827);
            }else {
                m_isSingleBundleFile = false;
                CallChecker.varAssign(this.m_isSingleBundleFile, "this.m_isSingleBundleFile", 147, 6746, 6827);
            }
            initialize();
            reviseInternal(false, new Long(0), m_originalLocation, is);
        } finally {
            _bcornu_methode_context176.methodEnd();
        }
    }

    public BundleArchive(Logger logger, Map configMap, WeakZipFileFactory zipFactory, File archiveRootDir) throws Exception {
        MethodContext _bcornu_methode_context177 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 172, 7709, 7726);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 173, 7736, 7759);
            m_zipFactory = zipFactory;
            CallChecker.varAssign(this.m_zipFactory, "this.m_zipFactory", 174, 7769, 7794);
            m_archiveRootDir = archiveRootDir;
            CallChecker.varAssign(this.m_archiveRootDir, "this.m_archiveRootDir", 175, 7804, 7837);
            String s = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(m_configMap, Map.class, 177, 7868, 7878)) {
                s = ((String) (CallChecker.isCalled(m_configMap, Map.class, 177, 7868, 7878).get(BundleCache.CACHE_SINGLEBUNDLEFILE_PROP)));
                CallChecker.varAssign(s, "s", 177, 7868, 7878);
            }
            if ((s == null) || (s.equalsIgnoreCase("true"))) {
                m_isSingleBundleFile = true;
                CallChecker.varAssign(this.m_isSingleBundleFile, "this.m_isSingleBundleFile", 178, 7934, 8015);
            }else {
                m_isSingleBundleFile = false;
                CallChecker.varAssign(this.m_isSingleBundleFile, "this.m_isSingleBundleFile", 178, 7934, 8015);
            }
            if (m_isSingleBundleFile) {
                readBundleInfo();
            }
            File[] children = CallChecker.init(File[].class);
            if (CallChecker.beforeDeref(m_archiveRootDir, File.class, 194, 8687, 8702)) {
                children = CallChecker.isCalled(m_archiveRootDir, File.class, 194, 8687, 8702).listFiles();
                CallChecker.varAssign(children, "children", 194, 8687, 8702);
            }
            if (CallChecker.beforeDeref(children, null, 195, 8743, 8750)) {
                for (File child : children) {
                    if (CallChecker.beforeDeref(child, File.class, 197, 8779, 8783)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(child, File.class, 197, 8779, 8783).getName(), String.class, 197, 8779, 8793)) {
                            if (CallChecker.beforeDeref(child, File.class, 198, 8845, 8849)) {
                                if ((CallChecker.isCalled(CallChecker.isCalled(child, File.class, 197, 8779, 8783).getName(), String.class, 197, 8779, 8793).startsWith(BundleArchive.REVISION_DIRECTORY)) && (CallChecker.isCalled(child, File.class, 198, 8845, 8849).isDirectory())) {
                                    int idx = CallChecker.init(int.class);
                                    if (CallChecker.beforeDeref(child, File.class, 201, 8987, 8991)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(child, File.class, 201, 8987, 8991).getName(), String.class, 201, 8987, 9001)) {
                                            idx = CallChecker.isCalled(CallChecker.isCalled(child, File.class, 201, 8987, 8991).getName(), String.class, 201, 8987, 9001).lastIndexOf('.');
                                            CallChecker.varAssign(idx, "idx", 201, 8987, 8991);
                                        }
                                    }
                                    if (idx > 0) {
                                        Long revNum = CallChecker.init(Long.class);
                                        if (CallChecker.beforeDeref(child, File.class, 204, 9114, 9118)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(child, File.class, 204, 9114, 9118).getName(), String.class, 204, 9114, 9128)) {
                                                revNum = Long.decode(CallChecker.isCalled(CallChecker.isCalled(child, File.class, 204, 9114, 9118).getName(), String.class, 204, 9114, 9128).substring((idx + 1)));
                                                CallChecker.varAssign(revNum, "revNum", 204, 9114, 9118);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 205, 9171, 9181)) {
                                            CallChecker.isCalled(m_revisions, SortedMap.class, 205, 9171, 9181).put(revNum, null);
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 210, 9257, 9267)) {
                if (CallChecker.isCalled(m_revisions, SortedMap.class, 210, 9257, 9267).isEmpty()) {
                    throw new Exception(("No valid revisions in bundle archive directory: " + archiveRootDir));
                }
            }else
                throw new AbnormalExecutionError();
            
            Long currentRevNum = CallChecker.init(Long.class);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 222, 9782, 9792)) {
                currentRevNum = CallChecker.isCalled(m_revisions, SortedMap.class, 222, 9782, 9792).lastKey();
                CallChecker.varAssign(currentRevNum, "currentRevNum", 222, 9782, 9792);
            }
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 223, 9813, 9823)) {
                CallChecker.isCalled(m_revisions, SortedMap.class, 223, 9813, 9823).remove(currentRevNum);
            }
            reviseInternal(true, currentRevNum, getRevisionLocation(currentRevNum), null);
        } finally {
            _bcornu_methode_context177.methodEnd();
        }
    }

    public synchronized long getId() throws Exception {
        MethodContext _bcornu_methode_context1778 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 236, 10012, 10384);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 236, 10012, 10384);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 236, 10012, 10384);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 236, 10012, 10384);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 236, 10012, 10384);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 236, 10012, 10384);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 236, 10012, 10384);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 236, 10012, 10384);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 236, 10012, 10384);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 236, 10012, 10384);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 236, 10012, 10384);
            CallChecker.varInit(this.m_revisions, "m_revisions", 236, 10012, 10384);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 236, 10012, 10384);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 236, 10012, 10384);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 236, 10012, 10384);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 236, 10012, 10384);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 236, 10012, 10384);
            CallChecker.varInit(this.m_id, "m_id", 236, 10012, 10384);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 236, 10012, 10384);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 236, 10012, 10384);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 236, 10012, 10384);
            CallChecker.varInit(this.m_configMap, "m_configMap", 236, 10012, 10384);
            CallChecker.varInit(this.m_logger, "m_logger", 236, 10012, 10384);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 236, 10012, 10384);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 236, 10012, 10384);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 236, 10012, 10384);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 236, 10012, 10384);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 236, 10012, 10384);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 236, 10012, 10384);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 236, 10012, 10384);
            if ((m_id) <= 0) {
                m_id = readId();
                CallChecker.varAssign(this.m_id, "this.m_id", 240, 10332, 10347);
            }
            return m_id;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1778.methodEnd();
        }
    }

    public synchronized String getLocation() throws Exception {
        MethodContext _bcornu_methode_context1779 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 252, 10391, 10818);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 252, 10391, 10818);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 252, 10391, 10818);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 252, 10391, 10818);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 252, 10391, 10818);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 252, 10391, 10818);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 252, 10391, 10818);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 252, 10391, 10818);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 252, 10391, 10818);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 252, 10391, 10818);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 252, 10391, 10818);
            CallChecker.varInit(this.m_revisions, "m_revisions", 252, 10391, 10818);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 252, 10391, 10818);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 252, 10391, 10818);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 252, 10391, 10818);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 252, 10391, 10818);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 252, 10391, 10818);
            CallChecker.varInit(this.m_id, "m_id", 252, 10391, 10818);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 252, 10391, 10818);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 252, 10391, 10818);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 252, 10391, 10818);
            CallChecker.varInit(this.m_configMap, "m_configMap", 252, 10391, 10818);
            CallChecker.varInit(this.m_logger, "m_logger", 252, 10391, 10818);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 252, 10391, 10818);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 252, 10391, 10818);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 252, 10391, 10818);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 252, 10391, 10818);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 252, 10391, 10818);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 252, 10391, 10818);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 252, 10391, 10818);
            if ((m_originalLocation) == null) {
                m_originalLocation = readLocation();
                CallChecker.varAssign(this.m_originalLocation, "this.m_originalLocation", 256, 10732, 10767);
            }
            return m_originalLocation;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1779.methodEnd();
        }
    }

    public synchronized int getPersistentState() throws Exception {
        MethodContext _bcornu_methode_context1780 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 270, 10825, 11373);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 270, 10825, 11373);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 270, 10825, 11373);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 270, 10825, 11373);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 270, 10825, 11373);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 270, 10825, 11373);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 270, 10825, 11373);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 270, 10825, 11373);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 270, 10825, 11373);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 270, 10825, 11373);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 270, 10825, 11373);
            CallChecker.varInit(this.m_revisions, "m_revisions", 270, 10825, 11373);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 270, 10825, 11373);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 270, 10825, 11373);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 270, 10825, 11373);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 270, 10825, 11373);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 270, 10825, 11373);
            CallChecker.varInit(this.m_id, "m_id", 270, 10825, 11373);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 270, 10825, 11373);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 270, 10825, 11373);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 270, 10825, 11373);
            CallChecker.varInit(this.m_configMap, "m_configMap", 270, 10825, 11373);
            CallChecker.varInit(this.m_logger, "m_logger", 270, 10825, 11373);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 270, 10825, 11373);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 270, 10825, 11373);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 270, 10825, 11373);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 270, 10825, 11373);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 270, 10825, 11373);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 270, 10825, 11373);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 270, 10825, 11373);
            if ((m_persistentState) < 0) {
                m_persistentState = readPersistentState();
                CallChecker.varAssign(this.m_persistentState, "this.m_persistentState", 274, 11282, 11323);
            }
            return m_persistentState;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1780.methodEnd();
        }
    }

    public synchronized void setPersistentState(int state) throws Exception {
        MethodContext _bcornu_methode_context1781 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 288, 11380, 12086);
            CallChecker.varInit(state, "state", 288, 11380, 12086);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 288, 11380, 12086);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 288, 11380, 12086);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 288, 11380, 12086);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 288, 11380, 12086);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 288, 11380, 12086);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 288, 11380, 12086);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 288, 11380, 12086);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 288, 11380, 12086);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 288, 11380, 12086);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 288, 11380, 12086);
            CallChecker.varInit(this.m_revisions, "m_revisions", 288, 11380, 12086);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 288, 11380, 12086);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 288, 11380, 12086);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 288, 11380, 12086);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 288, 11380, 12086);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 288, 11380, 12086);
            CallChecker.varInit(this.m_id, "m_id", 288, 11380, 12086);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 288, 11380, 12086);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 288, 11380, 12086);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 288, 11380, 12086);
            CallChecker.varInit(this.m_configMap, "m_configMap", 288, 11380, 12086);
            CallChecker.varInit(this.m_logger, "m_logger", 288, 11380, 12086);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 288, 11380, 12086);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 288, 11380, 12086);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 288, 11380, 12086);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 288, 11380, 12086);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 288, 11380, 12086);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 288, 11380, 12086);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 288, 11380, 12086);
            if ((m_persistentState) != state) {
                m_persistentState = state;
                CallChecker.varAssign(this.m_persistentState, "this.m_persistentState", 292, 11859, 11884);
                if (m_isSingleBundleFile) {
                    writeBundleInfo();
                }else {
                    writePersistentState();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1781.methodEnd();
        }
    }

    public synchronized int getStartLevel() throws Exception {
        MethodContext _bcornu_methode_context1782 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 311, 12093, 12465);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 311, 12093, 12465);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 311, 12093, 12465);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 311, 12093, 12465);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 311, 12093, 12465);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 311, 12093, 12465);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 311, 12093, 12465);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 311, 12093, 12465);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 311, 12093, 12465);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 311, 12093, 12465);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 311, 12093, 12465);
            CallChecker.varInit(this.m_revisions, "m_revisions", 311, 12093, 12465);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 311, 12093, 12465);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 311, 12093, 12465);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 311, 12093, 12465);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 311, 12093, 12465);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 311, 12093, 12465);
            CallChecker.varInit(this.m_id, "m_id", 311, 12093, 12465);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 311, 12093, 12465);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 311, 12093, 12465);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 311, 12093, 12465);
            CallChecker.varInit(this.m_configMap, "m_configMap", 311, 12093, 12465);
            CallChecker.varInit(this.m_logger, "m_logger", 311, 12093, 12465);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 311, 12093, 12465);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 311, 12093, 12465);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 311, 12093, 12465);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 311, 12093, 12465);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 311, 12093, 12465);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 311, 12093, 12465);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 311, 12093, 12465);
            if ((m_startLevel) < 0) {
                m_startLevel = readStartLevel();
                CallChecker.varAssign(this.m_startLevel, "this.m_startLevel", 315, 12389, 12420);
            }
            return m_startLevel;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1782.methodEnd();
        }
    }

    public synchronized void setStartLevel(int level) throws Exception {
        MethodContext _bcornu_methode_context1783 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 327, 12472, 13027);
            CallChecker.varInit(level, "level", 327, 12472, 13027);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 327, 12472, 13027);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 327, 12472, 13027);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 327, 12472, 13027);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 327, 12472, 13027);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 327, 12472, 13027);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 327, 12472, 13027);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 327, 12472, 13027);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 327, 12472, 13027);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 327, 12472, 13027);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 327, 12472, 13027);
            CallChecker.varInit(this.m_revisions, "m_revisions", 327, 12472, 13027);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 327, 12472, 13027);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 327, 12472, 13027);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 327, 12472, 13027);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 327, 12472, 13027);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 327, 12472, 13027);
            CallChecker.varInit(this.m_id, "m_id", 327, 12472, 13027);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 327, 12472, 13027);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 327, 12472, 13027);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 327, 12472, 13027);
            CallChecker.varInit(this.m_configMap, "m_configMap", 327, 12472, 13027);
            CallChecker.varInit(this.m_logger, "m_logger", 327, 12472, 13027);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 327, 12472, 13027);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 327, 12472, 13027);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 327, 12472, 13027);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 327, 12472, 13027);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 327, 12472, 13027);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 327, 12472, 13027);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 327, 12472, 13027);
            if ((m_startLevel) != level) {
                m_startLevel = level;
                CallChecker.varAssign(this.m_startLevel, "this.m_startLevel", 331, 12810, 12830);
                if (m_isSingleBundleFile) {
                    writeBundleInfo();
                }else {
                    writeStartLevel();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1783.methodEnd();
        }
    }

    public synchronized long getLastModified() throws Exception {
        MethodContext _bcornu_methode_context1784 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 350, 13034, 13439);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 350, 13034, 13439);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 350, 13034, 13439);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 350, 13034, 13439);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 350, 13034, 13439);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 350, 13034, 13439);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 350, 13034, 13439);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 350, 13034, 13439);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 350, 13034, 13439);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 350, 13034, 13439);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 350, 13034, 13439);
            CallChecker.varInit(this.m_revisions, "m_revisions", 350, 13034, 13439);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 350, 13034, 13439);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 350, 13034, 13439);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 350, 13034, 13439);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 350, 13034, 13439);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 350, 13034, 13439);
            CallChecker.varInit(this.m_id, "m_id", 350, 13034, 13439);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 350, 13034, 13439);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 350, 13034, 13439);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 350, 13034, 13439);
            CallChecker.varInit(this.m_configMap, "m_configMap", 350, 13034, 13439);
            CallChecker.varInit(this.m_logger, "m_logger", 350, 13034, 13439);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 350, 13034, 13439);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 350, 13034, 13439);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 350, 13034, 13439);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 350, 13034, 13439);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 350, 13034, 13439);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 350, 13034, 13439);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 350, 13034, 13439);
            if ((m_lastModified) < 0) {
                m_lastModified = readLastModified();
                CallChecker.varAssign(this.m_lastModified, "this.m_lastModified", 354, 13357, 13392);
            }
            return m_lastModified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1784.methodEnd();
        }
    }

    public synchronized void setLastModified(long lastModified) throws Exception {
        MethodContext _bcornu_methode_context1785 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 369, 13446, 14195);
            CallChecker.varInit(lastModified, "lastModified", 369, 13446, 14195);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 369, 13446, 14195);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 369, 13446, 14195);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 369, 13446, 14195);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 369, 13446, 14195);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 369, 13446, 14195);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 369, 13446, 14195);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 369, 13446, 14195);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 369, 13446, 14195);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 369, 13446, 14195);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 369, 13446, 14195);
            CallChecker.varInit(this.m_revisions, "m_revisions", 369, 13446, 14195);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 369, 13446, 14195);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 369, 13446, 14195);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 369, 13446, 14195);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 369, 13446, 14195);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 369, 13446, 14195);
            CallChecker.varInit(this.m_id, "m_id", 369, 13446, 14195);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 369, 13446, 14195);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 369, 13446, 14195);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 369, 13446, 14195);
            CallChecker.varInit(this.m_configMap, "m_configMap", 369, 13446, 14195);
            CallChecker.varInit(this.m_logger, "m_logger", 369, 13446, 14195);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 369, 13446, 14195);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 369, 13446, 14195);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 369, 13446, 14195);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 369, 13446, 14195);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 369, 13446, 14195);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 369, 13446, 14195);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 369, 13446, 14195);
            if ((m_lastModified) != lastModified) {
                m_lastModified = lastModified;
                CallChecker.varAssign(this.m_lastModified, "this.m_lastModified", 373, 13967, 13996);
                if (m_isSingleBundleFile) {
                    writeBundleInfo();
                }else {
                    writeLastModified();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1785.methodEnd();
        }
    }

    private long getRefreshCount() throws Exception {
        MethodContext _bcornu_methode_context1786 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 399, 14202, 15334);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 399, 14202, 15334);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 399, 14202, 15334);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 399, 14202, 15334);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 399, 14202, 15334);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 399, 14202, 15334);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 399, 14202, 15334);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 399, 14202, 15334);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 399, 14202, 15334);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 399, 14202, 15334);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 399, 14202, 15334);
            CallChecker.varInit(this.m_revisions, "m_revisions", 399, 14202, 15334);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 399, 14202, 15334);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 399, 14202, 15334);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 399, 14202, 15334);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 399, 14202, 15334);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 399, 14202, 15334);
            CallChecker.varInit(this.m_id, "m_id", 399, 14202, 15334);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 399, 14202, 15334);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 399, 14202, 15334);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 399, 14202, 15334);
            CallChecker.varInit(this.m_configMap, "m_configMap", 399, 14202, 15334);
            CallChecker.varInit(this.m_logger, "m_logger", 399, 14202, 15334);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 399, 14202, 15334);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 399, 14202, 15334);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 399, 14202, 15334);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 399, 14202, 15334);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 399, 14202, 15334);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 399, 14202, 15334);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 399, 14202, 15334);
            if ((m_refreshCount) < 0) {
                m_refreshCount = readRefreshCount();
                CallChecker.varAssign(this.m_refreshCount, "this.m_refreshCount", 404, 15251, 15286);
            }
            return m_refreshCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1786.methodEnd();
        }
    }

    private void setRefreshCount(long count) throws Exception {
        MethodContext _bcornu_methode_context1787 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 424, 15341, 16565);
            CallChecker.varInit(count, "count", 424, 15341, 16565);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 424, 15341, 16565);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 424, 15341, 16565);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 424, 15341, 16565);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 424, 15341, 16565);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 424, 15341, 16565);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 424, 15341, 16565);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 424, 15341, 16565);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 424, 15341, 16565);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 424, 15341, 16565);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 424, 15341, 16565);
            CallChecker.varInit(this.m_revisions, "m_revisions", 424, 15341, 16565);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 424, 15341, 16565);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 424, 15341, 16565);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 424, 15341, 16565);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 424, 15341, 16565);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 424, 15341, 16565);
            CallChecker.varInit(this.m_id, "m_id", 424, 15341, 16565);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 424, 15341, 16565);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 424, 15341, 16565);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 424, 15341, 16565);
            CallChecker.varInit(this.m_configMap, "m_configMap", 424, 15341, 16565);
            CallChecker.varInit(this.m_logger, "m_logger", 424, 15341, 16565);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 424, 15341, 16565);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 424, 15341, 16565);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 424, 15341, 16565);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 424, 15341, 16565);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 424, 15341, 16565);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 424, 15341, 16565);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 424, 15341, 16565);
            if ((m_refreshCount) != count) {
                m_refreshCount = count;
                CallChecker.varAssign(this.m_refreshCount, "this.m_refreshCount", 429, 16344, 16366);
                if (m_isSingleBundleFile) {
                    writeBundleInfo();
                }else {
                    writeRefreshCount();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1787.methodEnd();
        }
    }

    public synchronized File getDataFile(String fileName) throws Exception {
        MethodContext _bcornu_methode_context1788 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 449, 16572, 17895);
            CallChecker.varInit(fileName, "fileName", 449, 16572, 17895);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 449, 16572, 17895);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 449, 16572, 17895);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 449, 16572, 17895);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 449, 16572, 17895);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 449, 16572, 17895);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 449, 16572, 17895);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 449, 16572, 17895);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 449, 16572, 17895);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 449, 16572, 17895);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 449, 16572, 17895);
            CallChecker.varInit(this.m_revisions, "m_revisions", 449, 16572, 17895);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 449, 16572, 17895);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 449, 16572, 17895);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 449, 16572, 17895);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 449, 16572, 17895);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 449, 16572, 17895);
            CallChecker.varInit(this.m_id, "m_id", 449, 16572, 17895);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 449, 16572, 17895);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 449, 16572, 17895);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 449, 16572, 17895);
            CallChecker.varInit(this.m_configMap, "m_configMap", 449, 16572, 17895);
            CallChecker.varInit(this.m_logger, "m_logger", 449, 16572, 17895);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 449, 16572, 17895);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 449, 16572, 17895);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 449, 16572, 17895);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 449, 16572, 17895);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 449, 16572, 17895);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 449, 16572, 17895);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 449, 16572, 17895);
            if (CallChecker.beforeDeref(fileName, String.class, 452, 16985, 16992)) {
                if (CallChecker.beforeDeref(fileName, String.class, 452, 17012, 17019)) {
                    fileName = CallChecker.beforeCalled(fileName, String.class, 452, 16985, 16992);
                    fileName = CallChecker.beforeCalled(fileName, String.class, 452, 17012, 17019);
                    if (((CallChecker.isCalled(fileName, String.class, 452, 16985, 16992).length()) > 0) && ((CallChecker.isCalled(fileName, String.class, 452, 17012, 17019).charAt(0)) == (File.separatorChar))) {
                        throw new IllegalArgumentException("The data file path must be relative, not absolute.");
                    }else
                        if (CallChecker.beforeDeref(fileName, String.class, 457, 17211, 17218)) {
                            fileName = CallChecker.beforeCalled(fileName, String.class, 457, 17211, 17218);
                            if ((CallChecker.isCalled(fileName, String.class, 457, 17211, 17218).indexOf("..")) >= 0) {
                                throw new IllegalArgumentException("The data file path cannot contain a reference to the \"..\" directory.");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            File dataDir = CallChecker.varInit(new File(m_archiveRootDir, BundleArchive.DATA_DIRECTORY), "dataDir", 464, 17446, 17503);
            final SecureAction npe_invocation_var563 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var563, SecureAction.class, 466, 17569, 17597)) {
                if (!(CallChecker.isCalled(npe_invocation_var563, SecureAction.class, 466, 17569, 17597).fileExists(dataDir))) {
                    final SecureAction npe_invocation_var564 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var564, SecureAction.class, 468, 17647, 17675)) {
                        if (!(CallChecker.isCalled(npe_invocation_var564, SecureAction.class, 468, 17647, 17675).mkdir(dataDir))) {
                            throw new IOException("Unable to create bundle data directory.");
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return new File(dataDir, fileName);
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1788.methodEnd();
        }
    }

    public synchronized Long getCurrentRevisionNumber() {
        MethodContext _bcornu_methode_context1789 = new MethodContext(Long.class);
        try {
            CallChecker.varInit(this, "this", 484, 17902, 18194);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 484, 17902, 18194);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 484, 17902, 18194);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 484, 17902, 18194);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 484, 17902, 18194);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 484, 17902, 18194);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 484, 17902, 18194);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 484, 17902, 18194);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 484, 17902, 18194);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 484, 17902, 18194);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 484, 17902, 18194);
            CallChecker.varInit(this.m_revisions, "m_revisions", 484, 17902, 18194);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 484, 17902, 18194);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 484, 17902, 18194);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 484, 17902, 18194);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 484, 17902, 18194);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 484, 17902, 18194);
            CallChecker.varInit(this.m_id, "m_id", 484, 17902, 18194);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 484, 17902, 18194);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 484, 17902, 18194);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 484, 17902, 18194);
            CallChecker.varInit(this.m_configMap, "m_configMap", 484, 17902, 18194);
            CallChecker.varInit(this.m_logger, "m_logger", 484, 17902, 18194);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 484, 17902, 18194);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 484, 17902, 18194);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 484, 17902, 18194);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 484, 17902, 18194);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 484, 17902, 18194);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 484, 17902, 18194);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 484, 17902, 18194);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 486, 18135, 18145)) {
                if (CallChecker.isCalled(m_revisions, SortedMap.class, 486, 18135, 18145).isEmpty()) {
                    return null;
                }else {
                    if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 486, 18167, 18177)) {
                        return CallChecker.isCalled(m_revisions, SortedMap.class, 486, 18167, 18177).lastKey();
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1789.methodEnd();
        }
    }

    public synchronized BundleArchiveRevision getCurrentRevision() {
        MethodContext _bcornu_methode_context1790 = new MethodContext(BundleArchiveRevision.class);
        try {
            CallChecker.varInit(this, "this", 495, 18201, 18521);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 495, 18201, 18521);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 495, 18201, 18521);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 495, 18201, 18521);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 495, 18201, 18521);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 495, 18201, 18521);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 495, 18201, 18521);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 495, 18201, 18521);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 495, 18201, 18521);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 495, 18201, 18521);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 495, 18201, 18521);
            CallChecker.varInit(this.m_revisions, "m_revisions", 495, 18201, 18521);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 495, 18201, 18521);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 495, 18201, 18521);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 495, 18201, 18521);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 495, 18201, 18521);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 495, 18201, 18521);
            CallChecker.varInit(this.m_id, "m_id", 495, 18201, 18521);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 495, 18201, 18521);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 495, 18201, 18521);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 495, 18201, 18521);
            CallChecker.varInit(this.m_configMap, "m_configMap", 495, 18201, 18521);
            CallChecker.varInit(this.m_logger, "m_logger", 495, 18201, 18521);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 495, 18201, 18521);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 495, 18201, 18521);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 495, 18201, 18521);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 495, 18201, 18521);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 495, 18201, 18521);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 495, 18201, 18521);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 495, 18201, 18521);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 497, 18445, 18455)) {
                if (CallChecker.isCalled(m_revisions, SortedMap.class, 497, 18445, 18455).isEmpty()) {
                    return null;
                }else {
                    if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 497, 18493, 18503)) {
                        if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 497, 18477, 18487)) {
                            return CallChecker.isCalled(m_revisions, SortedMap.class, 497, 18477, 18487).get(CallChecker.isCalled(m_revisions, SortedMap.class, 497, 18493, 18503).lastKey());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleArchiveRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1790.methodEnd();
        }
    }

    public synchronized boolean isRemovalPending() {
        MethodContext _bcornu_methode_context1791 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 500, 18528, 18626);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 500, 18528, 18626);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 500, 18528, 18626);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 500, 18528, 18626);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 500, 18528, 18626);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 500, 18528, 18626);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 500, 18528, 18626);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 500, 18528, 18626);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 500, 18528, 18626);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 500, 18528, 18626);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 500, 18528, 18626);
            CallChecker.varInit(this.m_revisions, "m_revisions", 500, 18528, 18626);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 500, 18528, 18626);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 500, 18528, 18626);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 500, 18528, 18626);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 500, 18528, 18626);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 500, 18528, 18626);
            CallChecker.varInit(this.m_id, "m_id", 500, 18528, 18626);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 500, 18528, 18626);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 500, 18528, 18626);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 500, 18528, 18626);
            CallChecker.varInit(this.m_configMap, "m_configMap", 500, 18528, 18626);
            CallChecker.varInit(this.m_logger, "m_logger", 500, 18528, 18626);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 500, 18528, 18626);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 500, 18528, 18626);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 500, 18528, 18626);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 500, 18528, 18626);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 500, 18528, 18626);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 500, 18528, 18626);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 500, 18528, 18626);
            return (CallChecker.isCalled(m_revisions, SortedMap.class, 502, 18597, 18607).size()) > 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1791.methodEnd();
        }
    }

    public synchronized void revise(String location, InputStream is) throws Exception {
        MethodContext _bcornu_methode_context1792 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 515, 18633, 19347);
            CallChecker.varInit(is, "is", 515, 18633, 19347);
            CallChecker.varInit(location, "location", 515, 18633, 19347);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 515, 18633, 19347);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 515, 18633, 19347);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 515, 18633, 19347);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 515, 18633, 19347);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 515, 18633, 19347);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 515, 18633, 19347);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 515, 18633, 19347);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 515, 18633, 19347);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 515, 18633, 19347);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 515, 18633, 19347);
            CallChecker.varInit(this.m_revisions, "m_revisions", 515, 18633, 19347);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 515, 18633, 19347);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 515, 18633, 19347);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 515, 18633, 19347);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 515, 18633, 19347);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 515, 18633, 19347);
            CallChecker.varInit(this.m_id, "m_id", 515, 18633, 19347);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 515, 18633, 19347);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 515, 18633, 19347);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 515, 18633, 19347);
            CallChecker.varInit(this.m_configMap, "m_configMap", 515, 18633, 19347);
            CallChecker.varInit(this.m_logger, "m_logger", 515, 18633, 19347);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 515, 18633, 19347);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 515, 18633, 19347);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 515, 18633, 19347);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 515, 18633, 19347);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 515, 18633, 19347);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 515, 18633, 19347);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 515, 18633, 19347);
            Long revNum = CallChecker.init(Long.class);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 518, 19177, 19187)) {
                if (CallChecker.isCalled(m_revisions, SortedMap.class, 518, 19177, 19187).isEmpty()) {
                    revNum = new Long(0);
                    CallChecker.varAssign(revNum, "revNum", 518, 19176, 19286);
                }else {
                    if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 520, 19249, 19259)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m_revisions, SortedMap.class, 520, 19249, 19259).lastKey(), Long.class, 520, 19249, 19269)) {
                            revNum = new Long(((CallChecker.isCalled(CallChecker.isCalled(m_revisions, SortedMap.class, 520, 19249, 19259).lastKey(), Long.class, 520, 19249, 19269).longValue()) + 1));
                            CallChecker.varAssign(revNum, "revNum", 518, 19176, 19286);
                        }
                    }
                }
            }
            reviseInternal(false, revNum, location, is);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1792.methodEnd();
        }
    }

    private void reviseInternal(boolean isReload, Long revNum, String location, InputStream is) throws Exception {
        MethodContext _bcornu_methode_context1793 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 536, 19354, 20806);
            CallChecker.varInit(is, "is", 536, 19354, 20806);
            CallChecker.varInit(location, "location", 536, 19354, 20806);
            CallChecker.varInit(revNum, "revNum", 536, 19354, 20806);
            CallChecker.varInit(isReload, "isReload", 536, 19354, 20806);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 536, 19354, 20806);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 536, 19354, 20806);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 536, 19354, 20806);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 536, 19354, 20806);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 536, 19354, 20806);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 536, 19354, 20806);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 536, 19354, 20806);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 536, 19354, 20806);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 536, 19354, 20806);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 536, 19354, 20806);
            CallChecker.varInit(this.m_revisions, "m_revisions", 536, 19354, 20806);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 536, 19354, 20806);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 536, 19354, 20806);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 536, 19354, 20806);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 536, 19354, 20806);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 536, 19354, 20806);
            CallChecker.varInit(this.m_id, "m_id", 536, 19354, 20806);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 536, 19354, 20806);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 536, 19354, 20806);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 536, 19354, 20806);
            CallChecker.varInit(this.m_configMap, "m_configMap", 536, 19354, 20806);
            CallChecker.varInit(this.m_logger, "m_logger", 536, 19354, 20806);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 536, 19354, 20806);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 536, 19354, 20806);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 536, 19354, 20806);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 536, 19354, 20806);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 536, 19354, 20806);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 536, 19354, 20806);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 536, 19354, 20806);
            if (is != null) {
                location = "inputstream:";
                CallChecker.varAssign(location, "location", 546, 20320, 20345);
            }
            BundleArchiveRevision revision = CallChecker.varInit(createRevisionFromLocation(location, is, revNum), "revision", 550, 20423, 20504);
            if (revision == null) {
                throw new Exception("Unable to revise archive.");
            }
            if (!isReload) {
                setRevisionLocation(location, revNum);
            }
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 562, 20767, 20777)) {
                CallChecker.isCalled(m_revisions, SortedMap.class, 562, 20767, 20777).put(revNum, revision);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1793.methodEnd();
        }
    }

    public synchronized boolean rollbackRevise() throws Exception {
        MethodContext _bcornu_methode_context1794 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 577, 20813, 22272);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 577, 20813, 22272);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 577, 20813, 22272);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 577, 20813, 22272);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 577, 20813, 22272);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 577, 20813, 22272);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 577, 20813, 22272);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 577, 20813, 22272);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 577, 20813, 22272);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 577, 20813, 22272);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 577, 20813, 22272);
            CallChecker.varInit(this.m_revisions, "m_revisions", 577, 20813, 22272);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 577, 20813, 22272);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 577, 20813, 22272);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 577, 20813, 22272);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 577, 20813, 22272);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 577, 20813, 22272);
            CallChecker.varInit(this.m_id, "m_id", 577, 20813, 22272);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 577, 20813, 22272);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 577, 20813, 22272);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 577, 20813, 22272);
            CallChecker.varInit(this.m_configMap, "m_configMap", 577, 20813, 22272);
            CallChecker.varInit(this.m_logger, "m_logger", 577, 20813, 22272);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 577, 20813, 22272);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 577, 20813, 22272);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 577, 20813, 22272);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 577, 20813, 22272);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 577, 20813, 22272);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 577, 20813, 22272);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 577, 20813, 22272);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 580, 21545, 21555)) {
                if ((CallChecker.isCalled(m_revisions, SortedMap.class, 580, 21545, 21555).size()) <= 1) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            Long revNum = CallChecker.init(Long.class);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 585, 21639, 21649)) {
                revNum = CallChecker.isCalled(m_revisions, SortedMap.class, 585, 21639, 21649).lastKey();
                CallChecker.varAssign(revNum, "revNum", 585, 21639, 21649);
            }
            BundleArchiveRevision revision = CallChecker.init(BundleArchiveRevision.class);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 586, 21703, 21713)) {
                revision = CallChecker.isCalled(m_revisions, SortedMap.class, 586, 21703, 21713).remove(revNum);
                CallChecker.varAssign(revision, "revision", 586, 21703, 21713);
            }
            TryContext _bcornu_try_context_481 = new TryContext(481, BundleArchive.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(revision, BundleArchiveRevision.class, 590, 21766, 21773)) {
                    revision = CallChecker.beforeCalled(revision, BundleArchiveRevision.class, 590, 21766, 21773);
                    CallChecker.isCalled(revision, BundleArchiveRevision.class, 590, 21766, 21773).close();
                }
            } catch (Exception ex) {
                _bcornu_try_context_481.catchStart(481);
                if (CallChecker.beforeDeref(getClass(), Class.class, 594, 21874, 21883)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 594, 21843, 21850)) {
                        CallChecker.isCalled(m_logger, Logger.class, 594, 21843, 21850).log(Logger.LOG_ERROR, ((CallChecker.isCalled(getClass(), Class.class, 594, 21874, 21883).getName()) + ": Unable to dispose latest revision"), ex);
                    }
                }
            } finally {
                _bcornu_try_context_481.finallyStart(481);
            }
            File revisionDir = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(revNum, Long.class, 599, 22080, 22085)) {
                revNum = CallChecker.beforeCalled(revNum, Long.class, 599, 22080, 22085);
                revisionDir = new File(m_archiveRootDir, ((((BundleArchive.REVISION_DIRECTORY) + (getRefreshCount())) + ".") + (CallChecker.isCalled(revNum, Long.class, 599, 22080, 22085).toString())));
                CallChecker.varAssign(revisionDir, "revisionDir", 599, 22080, 22085);
            }
            final SecureAction npe_invocation_var565 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var565, SecureAction.class, 601, 22113, 22141)) {
                if (CallChecker.isCalled(npe_invocation_var565, SecureAction.class, 601, 22113, 22141).fileExists(revisionDir)) {
                    BundleCache.deleteDirectoryTree(revisionDir);
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1794.methodEnd();
        }
    }

    private synchronized String getRevisionLocation(Long revNum) throws Exception {
        MethodContext _bcornu_methode_context1795 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 609, 22279, 22907);
            CallChecker.varInit(revNum, "revNum", 609, 22279, 22907);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 609, 22279, 22907);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 609, 22279, 22907);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 609, 22279, 22907);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 609, 22279, 22907);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 609, 22279, 22907);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 609, 22279, 22907);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 609, 22279, 22907);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 609, 22279, 22907);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 609, 22279, 22907);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 609, 22279, 22907);
            CallChecker.varInit(this.m_revisions, "m_revisions", 609, 22279, 22907);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 609, 22279, 22907);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 609, 22279, 22907);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 609, 22279, 22907);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 609, 22279, 22907);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 609, 22279, 22907);
            CallChecker.varInit(this.m_id, "m_id", 609, 22279, 22907);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 609, 22279, 22907);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 609, 22279, 22907);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 609, 22279, 22907);
            CallChecker.varInit(this.m_configMap, "m_configMap", 609, 22279, 22907);
            CallChecker.varInit(this.m_logger, "m_logger", 609, 22279, 22907);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 609, 22279, 22907);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 609, 22279, 22907);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 609, 22279, 22907);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 609, 22279, 22907);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 609, 22279, 22907);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 609, 22279, 22907);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 609, 22279, 22907);
            InputStream is = CallChecker.varInit(null, "is", 611, 22371, 22392);
            BufferedReader br = CallChecker.varInit(null, "br", 612, 22402, 22426);
            TryContext _bcornu_try_context_482 = new TryContext(482, BundleArchive.class);
            try {
                if (CallChecker.beforeDeref(revNum, Long.class, 617, 22632, 22637)) {
                    final SecureAction npe_invocation_var566 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var566, SecureAction.class, 615, 22467, 22495)) {
                        revNum = CallChecker.beforeCalled(revNum, Long.class, 617, 22632, 22637);
                        is = CallChecker.isCalled(npe_invocation_var566, SecureAction.class, 615, 22467, 22495).getFileInputStream(new File(new File(m_archiveRootDir, ((((BundleArchive.REVISION_DIRECTORY) + (getRefreshCount())) + ".") + (CallChecker.isCalled(revNum, Long.class, 617, 22632, 22637).toString()))), BundleArchive.REVISION_LOCATION_FILE));
                        CallChecker.varAssign(is, "is", 615, 22462, 22676);
                    }
                }
                br = new BufferedReader(new InputStreamReader(is));
                CallChecker.varAssign(br, "br", 619, 22691, 22741);
                if (CallChecker.beforeDeref(br, BufferedReader.class, 620, 22762, 22763)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 620, 22762, 22763);
                    return CallChecker.isCalled(br, BufferedReader.class, 620, 22762, 22763).readLine();
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_482.finallyStart(482);
                if (br != null)
                    br.close();
                
                if (is != null)
                    is.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1795.methodEnd();
        }
    }

    private synchronized void setRevisionLocation(String location, Long revNum) throws Exception {
        MethodContext _bcornu_methode_context1796 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 629, 22914, 23655);
            CallChecker.varInit(revNum, "revNum", 629, 22914, 23655);
            CallChecker.varInit(location, "location", 629, 22914, 23655);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 629, 22914, 23655);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 629, 22914, 23655);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 629, 22914, 23655);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 629, 22914, 23655);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 629, 22914, 23655);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 629, 22914, 23655);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 629, 22914, 23655);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 629, 22914, 23655);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 629, 22914, 23655);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 629, 22914, 23655);
            CallChecker.varInit(this.m_revisions, "m_revisions", 629, 22914, 23655);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 629, 22914, 23655);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 629, 22914, 23655);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 629, 22914, 23655);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 629, 22914, 23655);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 629, 22914, 23655);
            CallChecker.varInit(this.m_id, "m_id", 629, 22914, 23655);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 629, 22914, 23655);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 629, 22914, 23655);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 629, 22914, 23655);
            CallChecker.varInit(this.m_configMap, "m_configMap", 629, 22914, 23655);
            CallChecker.varInit(this.m_logger, "m_logger", 629, 22914, 23655);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 629, 22914, 23655);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 629, 22914, 23655);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 629, 22914, 23655);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 629, 22914, 23655);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 629, 22914, 23655);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 629, 22914, 23655);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 629, 22914, 23655);
            OutputStream os = CallChecker.varInit(null, "os", 633, 23072, 23094);
            BufferedWriter bw = CallChecker.varInit(null, "bw", 634, 23104, 23128);
            TryContext _bcornu_try_context_483 = new TryContext(483, BundleArchive.class);
            try {
                if (CallChecker.beforeDeref(revNum, Long.class, 640, 23360, 23365)) {
                    final SecureAction npe_invocation_var567 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var567, SecureAction.class, 637, 23169, 23197)) {
                        revNum = CallChecker.beforeCalled(revNum, Long.class, 640, 23360, 23365);
                        os = CallChecker.isCalled(npe_invocation_var567, SecureAction.class, 637, 23169, 23197).getFileOutputStream(new File(new File(m_archiveRootDir, ((((BundleArchive.REVISION_DIRECTORY) + (getRefreshCount())) + ".") + (CallChecker.isCalled(revNum, Long.class, 640, 23360, 23365).toString()))), BundleArchive.REVISION_LOCATION_FILE));
                        CallChecker.varAssign(os, "os", 637, 23164, 23404);
                    }
                }
                bw = new BufferedWriter(new OutputStreamWriter(os));
                CallChecker.varAssign(bw, "bw", 641, 23418, 23469);
                if (CallChecker.beforeDeref(location, String.class, 642, 23505, 23512)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 642, 23483, 23484)) {
                        location = CallChecker.beforeCalled(location, String.class, 642, 23505, 23512);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 642, 23483, 23484);
                        CallChecker.isCalled(bw, BufferedWriter.class, 642, 23483, 23484).write(location, 0, CallChecker.isCalled(location, String.class, 642, 23505, 23512).length());
                    }
                }
            } finally {
                _bcornu_try_context_483.finallyStart(483);
                if (bw != null)
                    bw.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1796.methodEnd();
        }
    }

    public synchronized void close() {
        MethodContext _bcornu_methode_context1797 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 651, 23662, 24562);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 651, 23662, 24562);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 651, 23662, 24562);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 651, 23662, 24562);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 651, 23662, 24562);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 651, 23662, 24562);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 651, 23662, 24562);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 651, 23662, 24562);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 651, 23662, 24562);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 651, 23662, 24562);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 651, 23662, 24562);
            CallChecker.varInit(this.m_revisions, "m_revisions", 651, 23662, 24562);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 651, 23662, 24562);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 651, 23662, 24562);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 651, 23662, 24562);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 651, 23662, 24562);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 651, 23662, 24562);
            CallChecker.varInit(this.m_id, "m_id", 651, 23662, 24562);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 651, 23662, 24562);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 651, 23662, 24562);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 651, 23662, 24562);
            CallChecker.varInit(this.m_configMap, "m_configMap", 651, 23662, 24562);
            CallChecker.varInit(this.m_logger, "m_logger", 651, 23662, 24562);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 651, 23662, 24562);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 651, 23662, 24562);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 651, 23662, 24562);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 651, 23662, 24562);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 651, 23662, 24562);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 651, 23662, 24562);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 651, 23662, 24562);
            for (BundleArchiveRevision revision : CallChecker.isCalled(m_revisions, SortedMap.class, 654, 23790, 23800).values()) {
                if (revision != null) {
                    TryContext _bcornu_try_context_484 = new TryContext(484, BundleArchive.class, "java.lang.Exception");
                    try {
                        revision.close();
                    } catch (Exception ex) {
                        _bcornu_try_context_484.catchStart(484);
                        if (CallChecker.beforeDeref(m_logger, Logger.class, 668, 24336, 24343)) {
                            CallChecker.isCalled(m_logger, Logger.class, 668, 24336, 24343).log(Logger.LOG_ERROR, ("Unable to close revision - " + (revision.getRevisionRootDir())), ex);
                        }
                    } finally {
                        _bcornu_try_context_484.finallyStart(484);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1797.methodEnd();
        }
    }

    public synchronized void closeAndDelete() {
        MethodContext _bcornu_methode_context1798 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 683, 24569, 25091);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 683, 24569, 25091);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 683, 24569, 25091);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 683, 24569, 25091);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 683, 24569, 25091);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 683, 24569, 25091);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 683, 24569, 25091);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 683, 24569, 25091);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 683, 24569, 25091);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 683, 24569, 25091);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 683, 24569, 25091);
            CallChecker.varInit(this.m_revisions, "m_revisions", 683, 24569, 25091);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 683, 24569, 25091);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 683, 24569, 25091);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 683, 24569, 25091);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 683, 24569, 25091);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 683, 24569, 25091);
            CallChecker.varInit(this.m_id, "m_id", 683, 24569, 25091);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 683, 24569, 25091);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 683, 24569, 25091);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 683, 24569, 25091);
            CallChecker.varInit(this.m_configMap, "m_configMap", 683, 24569, 25091);
            CallChecker.varInit(this.m_logger, "m_logger", 683, 24569, 25091);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 683, 24569, 25091);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 683, 24569, 25091);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 683, 24569, 25091);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 683, 24569, 25091);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 683, 24569, 25091);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 683, 24569, 25091);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 683, 24569, 25091);
            close();
            if (!(BundleCache.deleteDirectoryTree(m_archiveRootDir))) {
                if (CallChecker.beforeDeref(m_logger, Logger.class, 689, 24952, 24959)) {
                    CallChecker.isCalled(m_logger, Logger.class, 689, 24952, 24959).log(Logger.LOG_ERROR, ("Unable to delete archive directory - " + (m_archiveRootDir)));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1798.methodEnd();
        }
    }

    public synchronized void purge() throws Exception {
        MethodContext _bcornu_methode_context1799 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 702, 25098, 27707);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 702, 25098, 27707);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 702, 25098, 27707);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 702, 25098, 27707);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 702, 25098, 27707);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 702, 25098, 27707);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 702, 25098, 27707);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 702, 25098, 27707);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 702, 25098, 27707);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 702, 25098, 27707);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 702, 25098, 27707);
            CallChecker.varInit(this.m_revisions, "m_revisions", 702, 25098, 27707);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 702, 25098, 27707);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 702, 25098, 27707);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 702, 25098, 27707);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 702, 25098, 27707);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 702, 25098, 27707);
            CallChecker.varInit(this.m_id, "m_id", 702, 25098, 27707);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 702, 25098, 27707);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 702, 25098, 27707);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 702, 25098, 27707);
            CallChecker.varInit(this.m_configMap, "m_configMap", 702, 25098, 27707);
            CallChecker.varInit(this.m_logger, "m_logger", 702, 25098, 27707);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 702, 25098, 27707);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 702, 25098, 27707);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 702, 25098, 27707);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 702, 25098, 27707);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 702, 25098, 27707);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 702, 25098, 27707);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 702, 25098, 27707);
            Long currentRevNum = CallChecker.varInit(getCurrentRevisionNumber(), "currentRevNum", 705, 25409, 25456);
            final BundleArchiveRevision npe_invocation_var568 = getCurrentRevision();
            boolean hasNativeLibs = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(npe_invocation_var568, BundleArchiveRevision.class, 709, 25642, 25661)) {
                final Map npe_invocation_var569 = CallChecker.isCalled(npe_invocation_var568, BundleArchiveRevision.class, 709, 25642, 25661).getManifestHeader();
                if (CallChecker.beforeDeref(npe_invocation_var569, Map.class, 709, 25642, 25681)) {
                    hasNativeLibs = CallChecker.isCalled(npe_invocation_var569, Map.class, 709, 25642, 25681).containsKey(Constants.BUNDLE_NATIVECODE);
                    CallChecker.varAssign(hasNativeLibs, "hasNativeLibs", 709, 25642, 25661);
                }
            }
            close();
            long refreshCount = CallChecker.varInit(((long) (getRefreshCount())), "refreshCount", 718, 25997, 26034);
            for (Long revNum : CallChecker.isCalled(m_revisions, SortedMap.class, 719, 26063, 26073).keySet()) {
                if (CallChecker.beforeDeref(revNum, Long.class, 721, 26112, 26117)) {
                    if (!(CallChecker.isCalled(revNum, Long.class, 721, 26112, 26117).equals(currentRevNum))) {
                        File revisionDir = CallChecker.init(File.class);
                        if (CallChecker.beforeDeref(revNum, Long.class, 725, 26301, 26306)) {
                            revisionDir = new File(m_archiveRootDir, ((((BundleArchive.REVISION_DIRECTORY) + refreshCount) + ".") + (CallChecker.isCalled(revNum, Long.class, 725, 26301, 26306).toString())));
                            CallChecker.varAssign(revisionDir, "revisionDir", 725, 26301, 26306);
                        }
                        final SecureAction npe_invocation_var570 = BundleCache.getSecureAction();
                        if (CallChecker.beforeDeref(npe_invocation_var570, SecureAction.class, 726, 26341, 26369)) {
                            if (CallChecker.isCalled(npe_invocation_var570, SecureAction.class, 726, 26341, 26369).fileExists(revisionDir)) {
                                BundleCache.deleteDirectoryTree(revisionDir);
                            }
                        }
                    }
                }
            }
            if (hasNativeLibs) {
                setRefreshCount((refreshCount + 1));
                File currentDir = CallChecker.init(File.class);
                if (CallChecker.beforeDeref(currentRevNum, Long.class, 743, 27050, 27062)) {
                    currentRevNum = CallChecker.beforeCalled(currentRevNum, Long.class, 743, 27050, 27062);
                    currentDir = new File(m_archiveRootDir, ((((BundleArchive.REVISION_DIRECTORY) + (refreshCount + 1)) + ".") + (CallChecker.isCalled(currentRevNum, Long.class, 743, 27050, 27062).toString())));
                    CallChecker.varAssign(currentDir, "currentDir", 743, 27050, 27062);
                }
                File revisionDir = CallChecker.init(File.class);
                if (CallChecker.beforeDeref(currentRevNum, Long.class, 745, 27193, 27205)) {
                    currentRevNum = CallChecker.beforeCalled(currentRevNum, Long.class, 745, 27193, 27205);
                    revisionDir = new File(m_archiveRootDir, ((((BundleArchive.REVISION_DIRECTORY) + refreshCount) + ".") + (CallChecker.isCalled(currentRevNum, Long.class, 745, 27193, 27205).toString())));
                    CallChecker.varAssign(revisionDir, "revisionDir", 745, 27193, 27205);
                }
                final SecureAction npe_invocation_var571 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var571, SecureAction.class, 746, 27232, 27260)) {
                    CallChecker.isCalled(npe_invocation_var571, SecureAction.class, 746, 27232, 27260).renameFile(revisionDir, currentDir);
                }
            }
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 750, 27384, 27394)) {
                CallChecker.isCalled(m_revisions, SortedMap.class, 750, 27384, 27394).clear();
            }
            BundleArchiveRevision revision = CallChecker.varInit(createRevisionFromLocation(getRevisionLocation(currentRevNum), null, currentRevNum), "revision", 753, 27473, 27602);
            if (CallChecker.beforeDeref(m_revisions, SortedMap.class, 756, 27661, 27671)) {
                CallChecker.isCalled(m_revisions, SortedMap.class, 756, 27661, 27671).put(currentRevNum, revision);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1799.methodEnd();
        }
    }

    private void initialize() throws Exception {
        MethodContext _bcornu_methode_context1800 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 766, 27714, 29158);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 766, 27714, 29158);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 766, 27714, 29158);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 766, 27714, 29158);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 766, 27714, 29158);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 766, 27714, 29158);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 766, 27714, 29158);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 766, 27714, 29158);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 766, 27714, 29158);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 766, 27714, 29158);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 766, 27714, 29158);
            CallChecker.varInit(this.m_revisions, "m_revisions", 766, 27714, 29158);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 766, 27714, 29158);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 766, 27714, 29158);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 766, 27714, 29158);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 766, 27714, 29158);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 766, 27714, 29158);
            CallChecker.varInit(this.m_id, "m_id", 766, 27714, 29158);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 766, 27714, 29158);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 766, 27714, 29158);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 766, 27714, 29158);
            CallChecker.varInit(this.m_configMap, "m_configMap", 766, 27714, 29158);
            CallChecker.varInit(this.m_logger, "m_logger", 766, 27714, 29158);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 766, 27714, 29158);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 766, 27714, 29158);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 766, 27714, 29158);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 766, 27714, 29158);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 766, 27714, 29158);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 766, 27714, 29158);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 766, 27714, 29158);
            OutputStream os = CallChecker.varInit(null, "os", 768, 27977, 27999);
            BufferedWriter bw = CallChecker.varInit(null, "bw", 769, 28009, 28033);
            TryContext _bcornu_try_context_485 = new TryContext(485, BundleArchive.class);
            try {
                final SecureAction npe_invocation_var572 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var572, SecureAction.class, 775, 28202, 28230)) {
                    if (CallChecker.isCalled(npe_invocation_var572, SecureAction.class, 775, 28202, 28230).fileExists(m_archiveRootDir)) {
                        return ;
                    }
                }
                final SecureAction npe_invocation_var573 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var573, SecureAction.class, 781, 28395, 28423)) {
                    if (!(CallChecker.isCalled(npe_invocation_var573, SecureAction.class, 781, 28395, 28423).mkdir(m_archiveRootDir))) {
                        if (CallChecker.beforeDeref(getClass(), Class.class, 785, 28552, 28561)) {
                            if (CallChecker.beforeDeref(m_logger, Logger.class, 783, 28480, 28487)) {
                                CallChecker.isCalled(m_logger, Logger.class, 783, 28480, 28487).log(Logger.LOG_ERROR, ((CallChecker.isCalled(getClass(), Class.class, 785, 28552, 28561).getName()) + ": Unable to create archive directory."));
                            }
                        }
                        throw new IOException("Unable to create archive directory.");
                    }
                }
                if (m_isSingleBundleFile) {
                    writeBundleInfo();
                }else {
                    writeId();
                    writeLocation();
                    writePersistentState();
                    writeStartLevel();
                    writeLastModified();
                }
            } finally {
                _bcornu_try_context_485.finallyStart(485);
                if (bw != null)
                    bw.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1800.methodEnd();
        }
    }

    private BundleArchiveRevision createRevisionFromLocation(String location, InputStream is, Long revNum) throws Exception {
        MethodContext _bcornu_methode_context1801 = new MethodContext(BundleArchiveRevision.class);
        try {
            CallChecker.varInit(this, "this", 815, 29165, 33002);
            CallChecker.varInit(revNum, "revNum", 815, 29165, 33002);
            CallChecker.varInit(is, "is", 815, 29165, 33002);
            CallChecker.varInit(location, "location", 815, 29165, 33002);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 815, 29165, 33002);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 815, 29165, 33002);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 815, 29165, 33002);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 815, 29165, 33002);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 815, 29165, 33002);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 815, 29165, 33002);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 815, 29165, 33002);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 815, 29165, 33002);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 815, 29165, 33002);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 815, 29165, 33002);
            CallChecker.varInit(this.m_revisions, "m_revisions", 815, 29165, 33002);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 815, 29165, 33002);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 815, 29165, 33002);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 815, 29165, 33002);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 815, 29165, 33002);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 815, 29165, 33002);
            CallChecker.varInit(this.m_id, "m_id", 815, 29165, 33002);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 815, 29165, 33002);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 815, 29165, 33002);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 815, 29165, 33002);
            CallChecker.varInit(this.m_configMap, "m_configMap", 815, 29165, 33002);
            CallChecker.varInit(this.m_logger, "m_logger", 815, 29165, 33002);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 815, 29165, 33002);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 815, 29165, 33002);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 815, 29165, 33002);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 815, 29165, 33002);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 815, 29165, 33002);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 815, 29165, 33002);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 815, 29165, 33002);
            File revisionRootDir = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(revNum, Long.class, 829, 30215, 30220)) {
                revNum = CallChecker.beforeCalled(revNum, Long.class, 829, 30215, 30220);
                revisionRootDir = new File(m_archiveRootDir, ((((BundleArchive.REVISION_DIRECTORY) + (getRefreshCount())) + ".") + (CallChecker.isCalled(revNum, Long.class, 829, 30215, 30220).toString())));
                CallChecker.varAssign(revisionRootDir, "revisionRootDir", 829, 30215, 30220);
            }
            BundleArchiveRevision result = CallChecker.varInit(null, "result", 831, 30244, 30279);
            TryContext _bcornu_try_context_486 = new TryContext(486, BundleArchive.class, "java.lang.Exception");
            try {
                if ((location != null) && (location.startsWith(BundleArchive.REFERENCE_PROTOCOL))) {
                    if (CallChecker.beforeDeref(BundleArchive.REFERENCE_PROTOCOL, String.class, 839, 30581, 30598)) {
                        location = location.substring(CallChecker.isCalled(BundleArchive.REFERENCE_PROTOCOL, String.class, 839, 30581, 30598).length());
                        CallChecker.varAssign(location, "location", 839, 30551, 30609);
                    }
                    if (!(location.startsWith(BundleArchive.FILE_PROTOCOL))) {
                        throw new IOException(("Reference URLs can only be files: " + location));
                    }
                    location = BundleArchive.decode(location);
                    CallChecker.varAssign(location, "location", 846, 30866, 30893);
                    File file = CallChecker.init(File.class);
                    if (CallChecker.beforeDeref(BundleArchive.FILE_PROTOCOL, String.class, 849, 31009, 31021)) {
                        file = new File(location.substring(CallChecker.isCalled(BundleArchive.FILE_PROTOCOL, String.class, 849, 31009, 31021).length()));
                        CallChecker.varAssign(file, "file", 849, 31009, 31021);
                    }
                    final SecureAction npe_invocation_var574 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var574, SecureAction.class, 850, 31056, 31084)) {
                        if (!(CallChecker.isCalled(npe_invocation_var574, SecureAction.class, 850, 31056, 31084).fileExists(file))) {
                            throw new IOException(("Referenced file does not exist: " + file));
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    final SecureAction npe_invocation_var575 = BundleCache.getSecureAction();
                    if (CallChecker.beforeDeref(npe_invocation_var575, SecureAction.class, 858, 31447, 31475)) {
                        if (CallChecker.isCalled(npe_invocation_var575, SecureAction.class, 858, 31447, 31475).isFileDirectory(file)) {
                            result = new DirectoryRevision(m_logger, m_configMap, m_zipFactory, revisionRootDir, location);
                            CallChecker.varAssign(result, "result", 860, 31538, 31656);
                        }else {
                            result = new JarRevision(m_logger, m_configMap, m_zipFactory, revisionRootDir, location, true, null);
                            CallChecker.varAssign(result, "result", 865, 31735, 31859);
                        }
                    }
                }else
                    if (CallChecker.beforeDeref(location, String.class, 869, 31914, 31921)) {
                        location = CallChecker.beforeCalled(location, String.class, 869, 31914, 31921);
                        if (CallChecker.isCalled(location, String.class, 869, 31914, 31921).startsWith(BundleArchive.INPUTSTREAM_PROTOCOL)) {
                            result = new JarRevision(m_logger, m_configMap, m_zipFactory, revisionRootDir, location, false, is);
                            CallChecker.varAssign(result, "result", 872, 32051, 32170);
                        }else {
                            result = new JarRevision(m_logger, m_configMap, m_zipFactory, revisionRootDir, location, false, null);
                            CallChecker.varAssign(result, "result", 878, 32304, 32425);
                        }
                    }
                
            } catch (Exception ex) {
                _bcornu_try_context_486.catchStart(486);
                final SecureAction npe_invocation_var576 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var576, SecureAction.class, 884, 32506, 32534)) {
                    if (CallChecker.isCalled(npe_invocation_var576, SecureAction.class, 884, 32506, 32534).fileExists(revisionRootDir)) {
                        if (!(BundleCache.deleteDirectoryTree(revisionRootDir))) {
                            if (CallChecker.beforeDeref(getClass(), Class.class, 890, 32768, 32777)) {
                                if (CallChecker.beforeDeref(m_logger, Logger.class, 888, 32688, 32695)) {
                                    CallChecker.isCalled(m_logger, Logger.class, 888, 32688, 32695).log(Logger.LOG_ERROR, (((CallChecker.isCalled(getClass(), Class.class, 890, 32768, 32777).getName()) + ": Unable to delete revision directory - ") + revisionRootDir));
                                }
                            }
                        }
                    }
                }
                throw ex;
            } finally {
                _bcornu_try_context_486.finallyStart(486);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleArchiveRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1801.methodEnd();
        }
    }

    private static String decode(String s) throws UnsupportedEncodingException {
        MethodContext _bcornu_methode_context1802 = new MethodContext(String.class);
        try {
            CallChecker.varInit(s, "s", 903, 33009, 34507);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 903, 33009, 34507);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 903, 33009, 34507);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 903, 33009, 34507);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 903, 33009, 34507);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 903, 33009, 34507);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 903, 33009, 34507);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 903, 33009, 34507);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 903, 33009, 34507);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 903, 33009, 34507);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 903, 33009, 34507);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 903, 33009, 34507);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 903, 33009, 34507);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 903, 33009, 34507);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 903, 33009, 34507);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 903, 33009, 34507);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 903, 33009, 34507);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 903, 33009, 34507);
            StringBuffer result = CallChecker.varInit(new StringBuffer(), "result", 905, 33215, 33255);
            ByteArrayOutputStream out = CallChecker.varInit(new ByteArrayOutputStream(), "out", 906, 33265, 33320);
            s = CallChecker.beforeCalled(s, String.class, 907, 33350, 33350);
            for (int i = 0; i < (CallChecker.isCalled(s, String.class, 907, 33350, 33350).length());) {
                char c = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(s, String.class, 909, 33394, 33394)) {
                    s = CallChecker.beforeCalled(s, String.class, 909, 33394, 33394);
                    c = CallChecker.isCalled(s, String.class, 909, 33394, 33394).charAt(i);
                    CallChecker.varAssign(c, "c", 909, 33394, 33394);
                }
                if (c == '%') {
                    if (CallChecker.beforeDeref(out, ByteArrayOutputStream.class, 912, 33463, 33465)) {
                        out = CallChecker.beforeCalled(out, ByteArrayOutputStream.class, 912, 33463, 33465);
                        CallChecker.isCalled(out, ByteArrayOutputStream.class, 912, 33463, 33465).reset();
                    }
                    s = CallChecker.beforeCalled(s, String.class, 931, 34280, 34280);
                    s = CallChecker.beforeCalled(s, String.class, 931, 34296, 34296);
                    do {
                        if (CallChecker.beforeDeref(s, String.class, 915, 33548, 33548)) {
                            s = CallChecker.beforeCalled(s, String.class, 915, 33548, 33548);
                            if ((i + 2) >= (CallChecker.isCalled(s, String.class, 915, 33548, 33548).length())) {
                                throw new IllegalArgumentException(("Incomplete % sequence at: " + i));
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        int d1 = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(s, String.class, 920, 33772, 33772)) {
                            s = CallChecker.beforeCalled(s, String.class, 920, 33772, 33772);
                            d1 = Character.digit(CallChecker.isCalled(s, String.class, 920, 33772, 33772).charAt((i + 1)), 16);
                            CallChecker.varAssign(d1, "d1", 920, 33772, 33772);
                        }
                        int d2 = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(s, String.class, 921, 33839, 33839)) {
                            s = CallChecker.beforeCalled(s, String.class, 921, 33839, 33839);
                            d2 = Character.digit(CallChecker.isCalled(s, String.class, 921, 33839, 33839).charAt((i + 2)), 16);
                            CallChecker.varAssign(d2, "d2", 921, 33839, 33839);
                        }
                        if ((d1 == (-1)) || (d2 == (-1))) {
                            if (CallChecker.beforeDeref(s, String.class, 925, 34045, 34045)) {
                                s = CallChecker.beforeCalled(s, String.class, 925, 34045, 34045);
                                throw new IllegalArgumentException(((("Invalid % sequence (" + (CallChecker.isCalled(s, String.class, 925, 34045, 34045).substring(i, (i + 3)))) + ") at: ") + (String.valueOf(i))));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        if (CallChecker.beforeDeref(out, ByteArrayOutputStream.class, 928, 34170, 34172)) {
                            out = CallChecker.beforeCalled(out, ByteArrayOutputStream.class, 928, 34170, 34172);
                            CallChecker.isCalled(out, ByteArrayOutputStream.class, 928, 34170, 34172).write(((byte) ((d1 << 4) + d2)));
                        }
                        i += 3;
                        CallChecker.varAssign(i, "i", 929, 34226, 34232);
                    } while ((i < (CallChecker.isCalled(s, String.class, 931, 34280, 34280).length())) && ((CallChecker.isCalled(s, String.class, 931, 34296, 34296).charAt(i)) == '%') );
                    if (CallChecker.beforeDeref(out, ByteArrayOutputStream.class, 932, 34348, 34350)) {
                        if (CallChecker.beforeDeref(result, StringBuffer.class, 932, 34334, 34339)) {
                            out = CallChecker.beforeCalled(out, ByteArrayOutputStream.class, 932, 34348, 34350);
                            result = CallChecker.beforeCalled(result, StringBuffer.class, 932, 34334, 34339);
                            CallChecker.isCalled(result, StringBuffer.class, 932, 34334, 34339).append(CallChecker.isCalled(out, ByteArrayOutputStream.class, 932, 34348, 34350).toString("UTF-8"));
                        }
                    }
                    continue;
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 935, 34424, 34429)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 935, 34424, 34429);
                    CallChecker.isCalled(result, StringBuffer.class, 935, 34424, 34429).append(c);
                }
                i++;
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 938, 34484, 34489)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 938, 34484, 34489);
                return CallChecker.isCalled(result, StringBuffer.class, 938, 34484, 34489).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1802.methodEnd();
        }
    }

    private void readBundleInfo() throws Exception {
        MethodContext _bcornu_methode_context1803 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 941, 34514, 36108);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 941, 34514, 36108);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 941, 34514, 36108);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 941, 34514, 36108);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 941, 34514, 36108);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 941, 34514, 36108);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 941, 34514, 36108);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 941, 34514, 36108);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 941, 34514, 36108);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 941, 34514, 36108);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 941, 34514, 36108);
            CallChecker.varInit(this.m_revisions, "m_revisions", 941, 34514, 36108);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 941, 34514, 36108);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 941, 34514, 36108);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 941, 34514, 36108);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 941, 34514, 36108);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 941, 34514, 36108);
            CallChecker.varInit(this.m_id, "m_id", 941, 34514, 36108);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 941, 34514, 36108);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 941, 34514, 36108);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 941, 34514, 36108);
            CallChecker.varInit(this.m_configMap, "m_configMap", 941, 34514, 36108);
            CallChecker.varInit(this.m_logger, "m_logger", 941, 34514, 36108);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 941, 34514, 36108);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 941, 34514, 36108);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 941, 34514, 36108);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 941, 34514, 36108);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 941, 34514, 36108);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 941, 34514, 36108);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 941, 34514, 36108);
            File infoFile = CallChecker.varInit(new File(m_archiveRootDir, BundleArchive.BUNDLE_INFO_FILE), "infoFile", 943, 34575, 34635);
            InputStream is = CallChecker.varInit(null, "is", 946, 34686, 34707);
            BufferedReader br = CallChecker.varInit(null, "br", 947, 34717, 34740);
            TryContext _bcornu_try_context_487 = new TryContext(487, BundleArchive.class, "java.io.FileNotFoundException");
            try {
                final SecureAction npe_invocation_var577 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var577, SecureAction.class, 950, 34781, 34809)) {
                    is = CallChecker.isCalled(npe_invocation_var577, SecureAction.class, 950, 34781, 34809).getFileInputStream(infoFile);
                    CallChecker.varAssign(is, "is", 950, 34776, 34856);
                }
                br = new BufferedReader(new InputStreamReader(is));
                CallChecker.varAssign(br, "br", 952, 34870, 34920);
                if (CallChecker.beforeDeref(br, BufferedReader.class, 955, 34981, 34982)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 955, 34981, 34982);
                    m_id = Long.parseLong(CallChecker.isCalled(br, BufferedReader.class, 955, 34981, 34982).readLine());
                    CallChecker.varAssign(this.m_id, "this.m_id", 955, 34959, 34995);
                }
                if (CallChecker.beforeDeref(br, BufferedReader.class, 957, 35060, 35061)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 957, 35060, 35061);
                    m_originalLocation = CallChecker.isCalled(br, BufferedReader.class, 957, 35060, 35061).readLine();
                    CallChecker.varAssign(this.m_originalLocation, "this.m_originalLocation", 957, 35039, 35073);
                }
                if (CallChecker.beforeDeref(br, BufferedReader.class, 959, 35151, 35152)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 959, 35151, 35152);
                    m_persistentState = Integer.parseInt(CallChecker.isCalled(br, BufferedReader.class, 959, 35151, 35152).readLine());
                    CallChecker.varAssign(this.m_persistentState, "this.m_persistentState", 959, 35114, 35165);
                }
                if (CallChecker.beforeDeref(br, BufferedReader.class, 961, 35244, 35245)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 961, 35244, 35245);
                    m_startLevel = Integer.parseInt(CallChecker.isCalled(br, BufferedReader.class, 961, 35244, 35245).readLine());
                    CallChecker.varAssign(this.m_startLevel, "this.m_startLevel", 961, 35212, 35258);
                }
                if (CallChecker.beforeDeref(br, BufferedReader.class, 963, 35339, 35340)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 963, 35339, 35340);
                    m_lastModified = Long.parseLong(CallChecker.isCalled(br, BufferedReader.class, 963, 35339, 35340).readLine());
                    CallChecker.varAssign(this.m_lastModified, "this.m_lastModified", 963, 35307, 35353);
                }
                if (CallChecker.beforeDeref(br, BufferedReader.class, 965, 35434, 35435)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 965, 35434, 35435);
                    m_refreshCount = Long.parseLong(CallChecker.isCalled(br, BufferedReader.class, 965, 35434, 35435).readLine());
                    CallChecker.varAssign(this.m_refreshCount, "this.m_refreshCount", 965, 35402, 35448);
                }
            } catch (FileNotFoundException ex) {
                _bcornu_try_context_487.catchStart(487);
                m_id = readId();
                CallChecker.varAssign(this.m_id, "this.m_id", 972, 35714, 35729);
                m_originalLocation = readLocation();
                CallChecker.varAssign(this.m_originalLocation, "this.m_originalLocation", 973, 35743, 35778);
                m_persistentState = readPersistentState();
                CallChecker.varAssign(this.m_persistentState, "this.m_persistentState", 974, 35792, 35833);
                m_startLevel = readStartLevel();
                CallChecker.varAssign(this.m_startLevel, "this.m_startLevel", 975, 35847, 35878);
                m_lastModified = readLastModified();
                CallChecker.varAssign(this.m_lastModified, "this.m_lastModified", 976, 35892, 35927);
                m_refreshCount = readRefreshCount();
                CallChecker.varAssign(this.m_refreshCount, "this.m_refreshCount", 977, 35941, 35976);
            } finally {
                _bcornu_try_context_487.finallyStart(487);
                if (br != null)
                    br.close();
                
                if (is != null)
                    is.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1803.methodEnd();
        }
    }

    private void writeBundleInfo() throws Exception {
        MethodContext _bcornu_methode_context1804 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 986, 36115, 37736);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 986, 36115, 37736);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 986, 36115, 37736);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 986, 36115, 37736);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 986, 36115, 37736);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 986, 36115, 37736);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 986, 36115, 37736);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 986, 36115, 37736);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 986, 36115, 37736);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 986, 36115, 37736);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 986, 36115, 37736);
            CallChecker.varInit(this.m_revisions, "m_revisions", 986, 36115, 37736);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 986, 36115, 37736);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 986, 36115, 37736);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 986, 36115, 37736);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 986, 36115, 37736);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 986, 36115, 37736);
            CallChecker.varInit(this.m_id, "m_id", 986, 36115, 37736);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 986, 36115, 37736);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 986, 36115, 37736);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 986, 36115, 37736);
            CallChecker.varInit(this.m_configMap, "m_configMap", 986, 36115, 37736);
            CallChecker.varInit(this.m_logger, "m_logger", 986, 36115, 37736);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 986, 36115, 37736);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 986, 36115, 37736);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 986, 36115, 37736);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 986, 36115, 37736);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 986, 36115, 37736);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 986, 36115, 37736);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 986, 36115, 37736);
            OutputStream os = CallChecker.varInit(null, "os", 989, 36218, 36240);
            BufferedWriter bw = CallChecker.varInit(null, "bw", 990, 36250, 36274);
            TryContext _bcornu_try_context_488 = new TryContext(488, BundleArchive.class, "java.io.IOException");
            try {
                final SecureAction npe_invocation_var578 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var578, SecureAction.class, 993, 36315, 36343)) {
                    os = CallChecker.isCalled(npe_invocation_var578, SecureAction.class, 993, 36315, 36343).getFileOutputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_INFO_FILE));
                    CallChecker.varAssign(os, "os", 993, 36310, 36427);
                }
                bw = new BufferedWriter(new OutputStreamWriter(os));
                CallChecker.varAssign(bw, "bw", 995, 36441, 36492);
                String s = CallChecker.varInit(Long.toString(m_id), "s", 998, 36532, 36562);
                if (CallChecker.beforeDeref(s, String.class, 999, 36591, 36591)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 999, 36576, 36577)) {
                        s = CallChecker.beforeCalled(s, String.class, 999, 36591, 36591);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 999, 36576, 36577);
                        CallChecker.isCalled(bw, BufferedWriter.class, 999, 36576, 36577).write(s, 0, CallChecker.isCalled(s, String.class, 999, 36591, 36591).length());
                    }
                }
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1000, 36616, 36617)) {
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1000, 36616, 36617);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1000, 36616, 36617).newLine();
                }
                if ((m_originalLocation) == null) {
                    s = "";
                    CallChecker.varAssign(s, "s", 1002, 36673, 36731);
                }else {
                    s = m_originalLocation;
                    CallChecker.varAssign(s, "s", 1002, 36673, 36731);
                }
                if (CallChecker.beforeDeref(s, String.class, 1003, 36760, 36760)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1003, 36745, 36746)) {
                        s = CallChecker.beforeCalled(s, String.class, 1003, 36760, 36760);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1003, 36745, 36746);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1003, 36745, 36746).write(s, 0, CallChecker.isCalled(s, String.class, 1003, 36760, 36760).length());
                    }
                }
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1004, 36785, 36786)) {
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1004, 36785, 36786);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1004, 36785, 36786).newLine();
                }
                s = Integer.toString(m_persistentState);
                CallChecker.varAssign(s, "s", 1006, 36839, 36878);
                if (CallChecker.beforeDeref(s, String.class, 1007, 36907, 36907)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1007, 36892, 36893)) {
                        s = CallChecker.beforeCalled(s, String.class, 1007, 36907, 36907);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1007, 36892, 36893);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1007, 36892, 36893).write(s, 0, CallChecker.isCalled(s, String.class, 1007, 36907, 36907).length());
                    }
                }
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1008, 36932, 36933)) {
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1008, 36932, 36933);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1008, 36932, 36933).newLine();
                }
                s = Integer.toString(m_startLevel);
                CallChecker.varAssign(s, "s", 1010, 36992, 37026);
                if (CallChecker.beforeDeref(s, String.class, 1011, 37055, 37055)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1011, 37040, 37041)) {
                        s = CallChecker.beforeCalled(s, String.class, 1011, 37055, 37055);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1011, 37040, 37041);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1011, 37040, 37041).write(s, 0, CallChecker.isCalled(s, String.class, 1011, 37055, 37055).length());
                    }
                }
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1012, 37080, 37081)) {
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1012, 37080, 37081);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1012, 37080, 37081).newLine();
                }
                s = Long.toString(m_lastModified);
                CallChecker.varAssign(s, "s", 1014, 37142, 37175);
                if (CallChecker.beforeDeref(s, String.class, 1015, 37204, 37204)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1015, 37189, 37190)) {
                        s = CallChecker.beforeCalled(s, String.class, 1015, 37204, 37204);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1015, 37189, 37190);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1015, 37189, 37190).write(s, 0, CallChecker.isCalled(s, String.class, 1015, 37204, 37204).length());
                    }
                }
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1016, 37229, 37230)) {
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1016, 37229, 37230);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1016, 37229, 37230).newLine();
                }
                s = Long.toString(m_refreshCount);
                CallChecker.varAssign(s, "s", 1018, 37291, 37324);
                if (CallChecker.beforeDeref(s, String.class, 1019, 37353, 37353)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1019, 37338, 37339)) {
                        s = CallChecker.beforeCalled(s, String.class, 1019, 37353, 37353);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1019, 37338, 37339);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1019, 37338, 37339).write(s, 0, CallChecker.isCalled(s, String.class, 1019, 37353, 37353).length());
                    }
                }
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1020, 37378, 37379)) {
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1020, 37378, 37379);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1020, 37378, 37379).newLine();
                }
            } catch (IOException ex) {
                _bcornu_try_context_488.catchStart(488);
                if (CallChecker.beforeDeref(getClass(), Class.class, 1026, 37519, 37528)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1024, 37455, 37462)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1024, 37455, 37462).log(Logger.LOG_ERROR, (((CallChecker.isCalled(getClass(), Class.class, 1026, 37519, 37528).getName()) + ": Unable to cache bundle info - ") + ex));
                    }
                }
                throw ex;
            } finally {
                _bcornu_try_context_488.finallyStart(488);
                if (bw != null)
                    bw.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1804.methodEnd();
        }
    }

    private static final transient String BUNDLE_ID_FILE = "bundle.id";

    private static final transient String BUNDLE_LOCATION_FILE = "bundle.location";

    private static final transient String BUNDLE_STATE_FILE = "bundle.state";

    private static final transient String BUNDLE_START_LEVEL_FILE = "bundle.startlevel";

    private static final transient String BUNDLE_LASTMODIFIED_FILE = "bundle.lastmodified";

    private static final transient String REFRESH_COUNTER_FILE = "refresh.counter";

    private void writeId() throws Exception {
        MethodContext _bcornu_methode_context1805 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1047, 38322, 38694);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1047, 38322, 38694);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1047, 38322, 38694);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1047, 38322, 38694);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1047, 38322, 38694);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1047, 38322, 38694);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1047, 38322, 38694);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1047, 38322, 38694);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1047, 38322, 38694);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1047, 38322, 38694);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1047, 38322, 38694);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1047, 38322, 38694);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1047, 38322, 38694);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1047, 38322, 38694);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1047, 38322, 38694);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1047, 38322, 38694);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1047, 38322, 38694);
            CallChecker.varInit(this.m_id, "m_id", 1047, 38322, 38694);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1047, 38322, 38694);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1047, 38322, 38694);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1047, 38322, 38694);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1047, 38322, 38694);
            CallChecker.varInit(this.m_logger, "m_logger", 1047, 38322, 38694);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1047, 38322, 38694);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1047, 38322, 38694);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1047, 38322, 38694);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1047, 38322, 38694);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1047, 38322, 38694);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1047, 38322, 38694);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1047, 38322, 38694);
            final SecureAction npe_invocation_var579 = BundleCache.getSecureAction();
            OutputStream os = CallChecker.init(OutputStream.class);
            if (CallChecker.beforeDeref(npe_invocation_var579, SecureAction.class, 1049, 38394, 38422)) {
                os = CallChecker.isCalled(npe_invocation_var579, SecureAction.class, 1049, 38394, 38422).getFileOutputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_ID_FILE));
                CallChecker.varAssign(os, "os", 1049, 38394, 38422);
            }
            BufferedWriter bw = CallChecker.varInit(new BufferedWriter(new OutputStreamWriter(os)), "bw", 1051, 38510, 38576);
            if (CallChecker.beforeDeref(Long.toString(m_id), String.class, 1052, 38619, 38637)) {
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1052, 38586, 38587)) {
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1052, 38586, 38587);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1052, 38586, 38587).write(Long.toString(m_id), 0, CallChecker.isCalled(Long.toString(m_id), String.class, 1052, 38619, 38637).length());
                }
            }
            if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1053, 38658, 38659)) {
                bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1053, 38658, 38659);
                CallChecker.isCalled(bw, BufferedWriter.class, 1053, 38658, 38659).close();
            }
            if (CallChecker.beforeDeref(os, OutputStream.class, 1054, 38678, 38679)) {
                os = CallChecker.beforeCalled(os, OutputStream.class, 1054, 38678, 38679);
                CallChecker.isCalled(os, OutputStream.class, 1054, 38678, 38679).close();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1805.methodEnd();
        }
    }

    private long readId() throws Exception {
        MethodContext _bcornu_methode_context1806 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 1057, 38701, 39829);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1057, 38701, 39829);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1057, 38701, 39829);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1057, 38701, 39829);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1057, 38701, 39829);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1057, 38701, 39829);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1057, 38701, 39829);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1057, 38701, 39829);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1057, 38701, 39829);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1057, 38701, 39829);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1057, 38701, 39829);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1057, 38701, 39829);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1057, 38701, 39829);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1057, 38701, 39829);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1057, 38701, 39829);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1057, 38701, 39829);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1057, 38701, 39829);
            CallChecker.varInit(this.m_id, "m_id", 1057, 38701, 39829);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1057, 38701, 39829);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1057, 38701, 39829);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1057, 38701, 39829);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1057, 38701, 39829);
            CallChecker.varInit(this.m_logger, "m_logger", 1057, 38701, 39829);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1057, 38701, 39829);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1057, 38701, 39829);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1057, 38701, 39829);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1057, 38701, 39829);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1057, 38701, 39829);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1057, 38701, 39829);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1057, 38701, 39829);
            long id = CallChecker.init(long.class);
            InputStream is = CallChecker.varInit(null, "is", 1061, 38772, 38793);
            BufferedReader br = CallChecker.varInit(null, "br", 1062, 38803, 38827);
            TryContext _bcornu_try_context_489 = new TryContext(489, BundleArchive.class, "java.io.FileNotFoundException");
            try {
                final SecureAction npe_invocation_var580 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var580, SecureAction.class, 1065, 38868, 38896)) {
                    is = CallChecker.isCalled(npe_invocation_var580, SecureAction.class, 1065, 38868, 38896).getFileInputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_ID_FILE));
                    CallChecker.varAssign(is, "is", 1065, 38863, 38977);
                }
                br = new BufferedReader(new InputStreamReader(is));
                CallChecker.varAssign(br, "br", 1067, 38991, 39041);
                if (CallChecker.beforeDeref(br, BufferedReader.class, 1068, 39075, 39076)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 1068, 39075, 39076);
                    id = Long.parseLong(CallChecker.isCalled(br, BufferedReader.class, 1068, 39075, 39076).readLine());
                    CallChecker.varAssign(id, "id", 1068, 39055, 39089);
                }
            } catch (FileNotFoundException ex) {
                _bcornu_try_context_489.catchStart(489);
                if (CallChecker.beforeDeref(m_archiveRootDir, File.class, 1078, 39579, 39594)) {
                    if (CallChecker.beforeDeref(BundleCache.BUNDLE_DIR_PREFIX, String.class, 1079, 39637, 39665)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m_archiveRootDir, File.class, 1078, 39579, 39594).getName(), String.class, 1078, 39579, 39604)) {
                            id = Long.parseLong(CallChecker.isCalled(CallChecker.isCalled(m_archiveRootDir, File.class, 1078, 39579, 39594).getName(), String.class, 1078, 39579, 39604).substring(CallChecker.isCalled(BundleCache.BUNDLE_DIR_PREFIX, String.class, 1079, 39637, 39665).length()));
                            CallChecker.varAssign(id, "id", 1077, 39542, 39677);
                        }
                    }
                }
            } finally {
                _bcornu_try_context_489.finallyStart(489);
                if (br != null)
                    br.close();
                
                if (is != null)
                    is.close();
                
            }
            return id;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1806.methodEnd();
        }
    }

    private void writeLocation() throws Exception {
        MethodContext _bcornu_methode_context1807 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1090, 39836, 40218);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1090, 39836, 40218);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1090, 39836, 40218);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1090, 39836, 40218);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1090, 39836, 40218);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1090, 39836, 40218);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1090, 39836, 40218);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1090, 39836, 40218);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1090, 39836, 40218);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1090, 39836, 40218);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1090, 39836, 40218);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1090, 39836, 40218);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1090, 39836, 40218);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1090, 39836, 40218);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1090, 39836, 40218);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1090, 39836, 40218);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1090, 39836, 40218);
            CallChecker.varInit(this.m_id, "m_id", 1090, 39836, 40218);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1090, 39836, 40218);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1090, 39836, 40218);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1090, 39836, 40218);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1090, 39836, 40218);
            CallChecker.varInit(this.m_logger, "m_logger", 1090, 39836, 40218);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1090, 39836, 40218);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1090, 39836, 40218);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1090, 39836, 40218);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1090, 39836, 40218);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1090, 39836, 40218);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1090, 39836, 40218);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1090, 39836, 40218);
            final SecureAction npe_invocation_var581 = BundleCache.getSecureAction();
            OutputStream os = CallChecker.init(OutputStream.class);
            if (CallChecker.beforeDeref(npe_invocation_var581, SecureAction.class, 1092, 39914, 39942)) {
                os = CallChecker.isCalled(npe_invocation_var581, SecureAction.class, 1092, 39914, 39942).getFileOutputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_LOCATION_FILE));
                CallChecker.varAssign(os, "os", 1092, 39914, 39942);
            }
            BufferedWriter bw = CallChecker.varInit(new BufferedWriter(new OutputStreamWriter(os)), "bw", 1094, 40036, 40102);
            if (CallChecker.beforeDeref(m_originalLocation, String.class, 1095, 40144, 40161)) {
                if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1095, 40112, 40113)) {
                    m_originalLocation = CallChecker.beforeCalled(m_originalLocation, String.class, 1095, 40144, 40161);
                    bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1095, 40112, 40113);
                    CallChecker.isCalled(bw, BufferedWriter.class, 1095, 40112, 40113).write(m_originalLocation, 0, CallChecker.isCalled(m_originalLocation, String.class, 1095, 40144, 40161).length());
                }
            }
            if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1096, 40182, 40183)) {
                bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1096, 40182, 40183);
                CallChecker.isCalled(bw, BufferedWriter.class, 1096, 40182, 40183).close();
            }
            if (CallChecker.beforeDeref(os, OutputStream.class, 1097, 40202, 40203)) {
                os = CallChecker.beforeCalled(os, OutputStream.class, 1097, 40202, 40203);
                CallChecker.isCalled(os, OutputStream.class, 1097, 40202, 40203).close();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1807.methodEnd();
        }
    }

    private String readLocation() throws Exception {
        MethodContext _bcornu_methode_context1808 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1100, 40225, 40727);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1100, 40225, 40727);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1100, 40225, 40727);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1100, 40225, 40727);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1100, 40225, 40727);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1100, 40225, 40727);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1100, 40225, 40727);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1100, 40225, 40727);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1100, 40225, 40727);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1100, 40225, 40727);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1100, 40225, 40727);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1100, 40225, 40727);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1100, 40225, 40727);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1100, 40225, 40727);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1100, 40225, 40727);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1100, 40225, 40727);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1100, 40225, 40727);
            CallChecker.varInit(this.m_id, "m_id", 1100, 40225, 40727);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1100, 40225, 40727);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1100, 40225, 40727);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1100, 40225, 40727);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1100, 40225, 40727);
            CallChecker.varInit(this.m_logger, "m_logger", 1100, 40225, 40727);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1100, 40225, 40727);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1100, 40225, 40727);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1100, 40225, 40727);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1100, 40225, 40727);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1100, 40225, 40727);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1100, 40225, 40727);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1100, 40225, 40727);
            InputStream is = CallChecker.varInit(null, "is", 1102, 40286, 40307);
            BufferedReader br = CallChecker.varInit(null, "br", 1103, 40317, 40341);
            TryContext _bcornu_try_context_490 = new TryContext(490, BundleArchive.class);
            try {
                final SecureAction npe_invocation_var582 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var582, SecureAction.class, 1106, 40382, 40410)) {
                    is = CallChecker.isCalled(npe_invocation_var582, SecureAction.class, 1106, 40382, 40410).getFileInputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_LOCATION_FILE));
                    CallChecker.varAssign(is, "is", 1106, 40377, 40497);
                }
                br = new BufferedReader(new InputStreamReader(is));
                CallChecker.varAssign(br, "br", 1108, 40511, 40561);
                if (CallChecker.beforeDeref(br, BufferedReader.class, 1109, 40582, 40583)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 1109, 40582, 40583);
                    return CallChecker.isCalled(br, BufferedReader.class, 1109, 40582, 40583).readLine();
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_490.finallyStart(490);
                if (br != null)
                    br.close();
                
                if (is != null)
                    is.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1808.methodEnd();
        }
    }

    private static final transient String ACTIVE_STATE = "active";

    private static final transient String STARTING_STATE = "starting";

    private static final transient String INSTALLED_STATE = "installed";

    private static final transient String UNINSTALLED_STATE = "uninstalled";

    private void writePersistentState() throws Exception {
        MethodContext _bcornu_methode_context1809 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1123, 41023, 42252);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1123, 41023, 42252);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1123, 41023, 42252);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1123, 41023, 42252);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1123, 41023, 42252);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1123, 41023, 42252);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1123, 41023, 42252);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1123, 41023, 42252);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1123, 41023, 42252);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1123, 41023, 42252);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1123, 41023, 42252);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1123, 41023, 42252);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1123, 41023, 42252);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1123, 41023, 42252);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1123, 41023, 42252);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1123, 41023, 42252);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1123, 41023, 42252);
            CallChecker.varInit(this.m_id, "m_id", 1123, 41023, 42252);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1123, 41023, 42252);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1123, 41023, 42252);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1123, 41023, 42252);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1123, 41023, 42252);
            CallChecker.varInit(this.m_logger, "m_logger", 1123, 41023, 42252);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1123, 41023, 42252);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1123, 41023, 42252);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1123, 41023, 42252);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1123, 41023, 42252);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1123, 41023, 42252);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1123, 41023, 42252);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1123, 41023, 42252);
            OutputStream os = CallChecker.varInit(null, "os", 1125, 41090, 41112);
            BufferedWriter bw = CallChecker.varInit(null, "bw", 1126, 41122, 41146);
            TryContext _bcornu_try_context_491 = new TryContext(491, BundleArchive.class, "java.io.IOException");
            try {
                final SecureAction npe_invocation_var583 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var583, SecureAction.class, 1129, 41187, 41215)) {
                    os = CallChecker.isCalled(npe_invocation_var583, SecureAction.class, 1129, 41187, 41215).getFileOutputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_STATE_FILE));
                    CallChecker.varAssign(os, "os", 1129, 41182, 41300);
                }
                bw = new BufferedWriter(new OutputStreamWriter(os));
                CallChecker.varAssign(bw, "bw", 1131, 41314, 41365);
                String s = CallChecker.varInit(null, "s", 1132, 41379, 41394);
                switch (m_persistentState) {
                    case Bundle.ACTIVE :
                        s = BundleArchive.ACTIVE_STATE;
                        CallChecker.varAssign(s, "s", 1136, 41505, 41521);
                        break;
                    case Bundle.STARTING :
                        s = BundleArchive.STARTING_STATE;
                        CallChecker.varAssign(s, "s", 1139, 41608, 41626);
                        break;
                    case Bundle.UNINSTALLED :
                        s = BundleArchive.UNINSTALLED_STATE;
                        CallChecker.varAssign(s, "s", 1142, 41716, 41737);
                        break;
                    default :
                        s = BundleArchive.INSTALLED_STATE;
                        CallChecker.varAssign(s, "s", 1145, 41811, 41830);
                        break;
                }
                if (CallChecker.beforeDeref(s, String.class, 1148, 41900, 41900)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1148, 41885, 41886)) {
                        s = CallChecker.beforeCalled(s, String.class, 1148, 41900, 41900);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1148, 41885, 41886);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1148, 41885, 41886).write(s, 0, CallChecker.isCalled(s, String.class, 1148, 41900, 41900).length());
                    }
                }
            } catch (IOException ex) {
                _bcornu_try_context_491.catchStart(491);
                if (CallChecker.beforeDeref(getClass(), Class.class, 1154, 42040, 42049)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1152, 41976, 41983)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1152, 41976, 41983).log(Logger.LOG_ERROR, (((CallChecker.isCalled(getClass(), Class.class, 1154, 42040, 42049).getName()) + ": Unable to record state - ") + ex));
                    }
                }
                throw ex;
            } finally {
                _bcornu_try_context_491.finallyStart(491);
                if (bw != null)
                    bw.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1809.methodEnd();
        }
    }

    private int readPersistentState() throws Exception {
        MethodContext _bcornu_methode_context1810 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1164, 42259, 43815);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1164, 42259, 43815);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1164, 42259, 43815);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1164, 42259, 43815);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1164, 42259, 43815);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1164, 42259, 43815);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1164, 42259, 43815);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1164, 42259, 43815);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1164, 42259, 43815);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1164, 42259, 43815);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1164, 42259, 43815);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1164, 42259, 43815);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1164, 42259, 43815);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1164, 42259, 43815);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1164, 42259, 43815);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1164, 42259, 43815);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1164, 42259, 43815);
            CallChecker.varInit(this.m_id, "m_id", 1164, 42259, 43815);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1164, 42259, 43815);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1164, 42259, 43815);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1164, 42259, 43815);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1164, 42259, 43815);
            CallChecker.varInit(this.m_logger, "m_logger", 1164, 42259, 43815);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1164, 42259, 43815);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1164, 42259, 43815);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1164, 42259, 43815);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1164, 42259, 43815);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1164, 42259, 43815);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1164, 42259, 43815);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1164, 42259, 43815);
            int state = CallChecker.varInit(((int) (Bundle.INSTALLED)), "state", 1166, 42324, 42352);
            File stateFile = CallChecker.varInit(new File(m_archiveRootDir, BundleArchive.BUNDLE_STATE_FILE), "stateFile", 1169, 42397, 42459);
            final SecureAction npe_invocation_var584 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var584, SecureAction.class, 1173, 42567, 42595)) {
                if (CallChecker.isCalled(npe_invocation_var584, SecureAction.class, 1173, 42567, 42595).fileExists(stateFile)) {
                    InputStream is = CallChecker.varInit(null, "is", 1176, 42680, 42701);
                    BufferedReader br = CallChecker.varInit(null, "br", 1177, 42715, 42739);
                    TryContext _bcornu_try_context_492 = new TryContext(492, BundleArchive.class, "java.lang.Exception");
                    try {
                        final SecureAction npe_invocation_var585 = BundleCache.getSecureAction();
                        if (CallChecker.beforeDeref(npe_invocation_var585, SecureAction.class, 1180, 42792, 42820)) {
                            is = CallChecker.isCalled(npe_invocation_var585, SecureAction.class, 1180, 42792, 42820).getFileInputStream(stateFile);
                            CallChecker.varAssign(is, "is", 1180, 42787, 42872);
                        }
                        br = new BufferedReader(new InputStreamReader(is));
                        CallChecker.varAssign(br, "br", 1182, 42890, 42940);
                        String s = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(br, BufferedReader.class, 1183, 42969, 42970)) {
                            br = CallChecker.beforeCalled(br, BufferedReader.class, 1183, 42969, 42970);
                            s = CallChecker.isCalled(br, BufferedReader.class, 1183, 42969, 42970).readLine();
                            CallChecker.varAssign(s, "s", 1183, 42969, 42970);
                        }
                        if ((s != null) && (s.equals(BundleArchive.ACTIVE_STATE))) {
                            state = Bundle.ACTIVE;
                            CallChecker.varAssign(state, "state", 1186, 43081, 43102);
                        }else
                            if ((s != null) && (s.equals(BundleArchive.STARTING_STATE))) {
                                state = Bundle.STARTING;
                                CallChecker.varAssign(state, "state", 1190, 43226, 43249);
                            }else
                                if ((s != null) && (s.equals(BundleArchive.UNINSTALLED_STATE))) {
                                    state = Bundle.UNINSTALLED;
                                    CallChecker.varAssign(state, "state", 1194, 43376, 43402);
                                }else {
                                    state = Bundle.INSTALLED;
                                    CallChecker.varAssign(state, "state", 1198, 43481, 43505);
                                }
                            
                        
                    } catch (Exception ex) {
                        _bcornu_try_context_492.catchStart(492);
                        state = Bundle.INSTALLED;
                        CallChecker.varAssign(state, "state", 1203, 43602, 43626);
                    } finally {
                        _bcornu_try_context_492.finallyStart(492);
                        if (br != null)
                            br.close();
                        
                        if (is != null)
                            is.close();
                        
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return state;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1810.methodEnd();
        }
    }

    private void writeStartLevel() throws Exception {
        MethodContext _bcornu_methode_context1811 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1215, 43822, 44607);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1215, 43822, 44607);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1215, 43822, 44607);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1215, 43822, 44607);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1215, 43822, 44607);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1215, 43822, 44607);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1215, 43822, 44607);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1215, 43822, 44607);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1215, 43822, 44607);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1215, 43822, 44607);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1215, 43822, 44607);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1215, 43822, 44607);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1215, 43822, 44607);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1215, 43822, 44607);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1215, 43822, 44607);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1215, 43822, 44607);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1215, 43822, 44607);
            CallChecker.varInit(this.m_id, "m_id", 1215, 43822, 44607);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1215, 43822, 44607);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1215, 43822, 44607);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1215, 43822, 44607);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1215, 43822, 44607);
            CallChecker.varInit(this.m_logger, "m_logger", 1215, 43822, 44607);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1215, 43822, 44607);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1215, 43822, 44607);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1215, 43822, 44607);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1215, 43822, 44607);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1215, 43822, 44607);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1215, 43822, 44607);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1215, 43822, 44607);
            OutputStream os = CallChecker.varInit(null, "os", 1217, 43884, 43906);
            BufferedWriter bw = CallChecker.varInit(null, "bw", 1218, 43916, 43940);
            TryContext _bcornu_try_context_493 = new TryContext(493, BundleArchive.class, "java.io.IOException");
            try {
                final SecureAction npe_invocation_var586 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var586, SecureAction.class, 1221, 43981, 44009)) {
                    os = CallChecker.isCalled(npe_invocation_var586, SecureAction.class, 1221, 43981, 44009).getFileOutputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_START_LEVEL_FILE));
                    CallChecker.varAssign(os, "os", 1221, 43976, 44100);
                }
                bw = new BufferedWriter(new OutputStreamWriter(os));
                CallChecker.varAssign(bw, "bw", 1223, 44114, 44165);
                String s = CallChecker.varInit(Integer.toString(m_startLevel), "s", 1224, 44179, 44220);
                if (CallChecker.beforeDeref(s, String.class, 1225, 44249, 44249)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1225, 44234, 44235)) {
                        s = CallChecker.beforeCalled(s, String.class, 1225, 44249, 44249);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1225, 44234, 44235);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1225, 44234, 44235).write(s, 0, CallChecker.isCalled(s, String.class, 1225, 44249, 44249).length());
                    }
                }
            } catch (IOException ex) {
                _bcornu_try_context_493.catchStart(493);
                if (CallChecker.beforeDeref(getClass(), Class.class, 1231, 44389, 44398)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1229, 44325, 44332)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1229, 44325, 44332).log(Logger.LOG_ERROR, (((CallChecker.isCalled(getClass(), Class.class, 1231, 44389, 44398).getName()) + ": Unable to record start level - ") + ex));
                    }
                }
                throw ex;
            } finally {
                _bcornu_try_context_493.finallyStart(493);
                if (bw != null)
                    bw.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1811.methodEnd();
        }
    }

    private int readStartLevel() throws Exception {
        MethodContext _bcornu_methode_context1812 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1241, 44614, 45586);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1241, 44614, 45586);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1241, 44614, 45586);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1241, 44614, 45586);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1241, 44614, 45586);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1241, 44614, 45586);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1241, 44614, 45586);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1241, 44614, 45586);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1241, 44614, 45586);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1241, 44614, 45586);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1241, 44614, 45586);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1241, 44614, 45586);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1241, 44614, 45586);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1241, 44614, 45586);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1241, 44614, 45586);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1241, 44614, 45586);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1241, 44614, 45586);
            CallChecker.varInit(this.m_id, "m_id", 1241, 44614, 45586);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1241, 44614, 45586);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1241, 44614, 45586);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1241, 44614, 45586);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1241, 44614, 45586);
            CallChecker.varInit(this.m_logger, "m_logger", 1241, 44614, 45586);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1241, 44614, 45586);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1241, 44614, 45586);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1241, 44614, 45586);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1241, 44614, 45586);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1241, 44614, 45586);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1241, 44614, 45586);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1241, 44614, 45586);
            int level = CallChecker.varInit(((int) (-1)), "level", 1243, 44674, 44688);
            File levelFile = CallChecker.varInit(new File(m_archiveRootDir, BundleArchive.BUNDLE_START_LEVEL_FILE), "levelFile", 1246, 44739, 44807);
            final SecureAction npe_invocation_var587 = BundleCache.getSecureAction();
            if (CallChecker.beforeDeref(npe_invocation_var587, SecureAction.class, 1250, 44906, 44934)) {
                if (!(CallChecker.isCalled(npe_invocation_var587, SecureAction.class, 1250, 44906, 44934).fileExists(levelFile))) {
                    level = -1;
                    CallChecker.varAssign(level, "level", 1252, 44981, 44991);
                }else {
                    InputStream is = CallChecker.varInit(null, "is", 1257, 45082, 45103);
                    BufferedReader br = CallChecker.varInit(null, "br", 1258, 45117, 45140);
                    TryContext _bcornu_try_context_494 = new TryContext(494, BundleArchive.class);
                    try {
                        final SecureAction npe_invocation_var588 = BundleCache.getSecureAction();
                        if (CallChecker.beforeDeref(npe_invocation_var588, SecureAction.class, 1261, 45193, 45221)) {
                            is = CallChecker.isCalled(npe_invocation_var588, SecureAction.class, 1261, 45193, 45221).getFileInputStream(levelFile);
                            CallChecker.varAssign(is, "is", 1261, 45188, 45273);
                        }
                        br = new BufferedReader(new InputStreamReader(is));
                        CallChecker.varAssign(br, "br", 1263, 45291, 45341);
                        if (CallChecker.beforeDeref(br, BufferedReader.class, 1264, 45384, 45385)) {
                            br = CallChecker.beforeCalled(br, BufferedReader.class, 1264, 45384, 45385);
                            level = Integer.parseInt(CallChecker.isCalled(br, BufferedReader.class, 1264, 45384, 45385).readLine());
                            CallChecker.varAssign(level, "level", 1264, 45359, 45398);
                        }
                    } finally {
                        _bcornu_try_context_494.finallyStart(494);
                        if (br != null)
                            br.close();
                        
                        if (is != null)
                            is.close();
                        
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return level;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1812.methodEnd();
        }
    }

    private void writeLastModified() throws Exception {
        MethodContext _bcornu_methode_context1813 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1275, 45593, 46380);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1275, 45593, 46380);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1275, 45593, 46380);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1275, 45593, 46380);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1275, 45593, 46380);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1275, 45593, 46380);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1275, 45593, 46380);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1275, 45593, 46380);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1275, 45593, 46380);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1275, 45593, 46380);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1275, 45593, 46380);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1275, 45593, 46380);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1275, 45593, 46380);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1275, 45593, 46380);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1275, 45593, 46380);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1275, 45593, 46380);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1275, 45593, 46380);
            CallChecker.varInit(this.m_id, "m_id", 1275, 45593, 46380);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1275, 45593, 46380);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1275, 45593, 46380);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1275, 45593, 46380);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1275, 45593, 46380);
            CallChecker.varInit(this.m_logger, "m_logger", 1275, 45593, 46380);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1275, 45593, 46380);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1275, 45593, 46380);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1275, 45593, 46380);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1275, 45593, 46380);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1275, 45593, 46380);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1275, 45593, 46380);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1275, 45593, 46380);
            OutputStream os = CallChecker.varInit(null, "os", 1277, 45657, 45679);
            BufferedWriter bw = CallChecker.varInit(null, "bw", 1278, 45689, 45713);
            TryContext _bcornu_try_context_495 = new TryContext(495, BundleArchive.class, "java.io.IOException");
            try {
                final SecureAction npe_invocation_var589 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var589, SecureAction.class, 1281, 45754, 45782)) {
                    os = CallChecker.isCalled(npe_invocation_var589, SecureAction.class, 1281, 45754, 45782).getFileOutputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_LASTMODIFIED_FILE));
                    CallChecker.varAssign(os, "os", 1281, 45749, 45874);
                }
                bw = new BufferedWriter(new OutputStreamWriter(os));
                CallChecker.varAssign(bw, "bw", 1283, 45888, 45939);
                String s = CallChecker.varInit(Long.toString(m_lastModified), "s", 1284, 45953, 45993);
                if (CallChecker.beforeDeref(s, String.class, 1285, 46022, 46022)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1285, 46007, 46008)) {
                        s = CallChecker.beforeCalled(s, String.class, 1285, 46022, 46022);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1285, 46007, 46008);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1285, 46007, 46008).write(s, 0, CallChecker.isCalled(s, String.class, 1285, 46022, 46022).length());
                    }
                }
            } catch (IOException ex) {
                _bcornu_try_context_495.catchStart(495);
                if (CallChecker.beforeDeref(getClass(), Class.class, 1291, 46162, 46171)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1289, 46098, 46105)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1289, 46098, 46105).log(Logger.LOG_ERROR, (((CallChecker.isCalled(getClass(), Class.class, 1291, 46162, 46171).getName()) + ": Unable to record start level - ") + ex));
                    }
                }
                throw ex;
            } finally {
                _bcornu_try_context_495.finallyStart(495);
                if (bw != null)
                    bw.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1813.methodEnd();
        }
    }

    private long readLastModified() throws Exception {
        MethodContext _bcornu_methode_context1814 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 1301, 46387, 47028);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1301, 46387, 47028);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1301, 46387, 47028);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1301, 46387, 47028);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1301, 46387, 47028);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1301, 46387, 47028);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1301, 46387, 47028);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1301, 46387, 47028);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1301, 46387, 47028);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1301, 46387, 47028);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1301, 46387, 47028);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1301, 46387, 47028);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1301, 46387, 47028);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1301, 46387, 47028);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1301, 46387, 47028);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1301, 46387, 47028);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1301, 46387, 47028);
            CallChecker.varInit(this.m_id, "m_id", 1301, 46387, 47028);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1301, 46387, 47028);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1301, 46387, 47028);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1301, 46387, 47028);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1301, 46387, 47028);
            CallChecker.varInit(this.m_logger, "m_logger", 1301, 46387, 47028);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1301, 46387, 47028);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1301, 46387, 47028);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1301, 46387, 47028);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1301, 46387, 47028);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1301, 46387, 47028);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1301, 46387, 47028);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1301, 46387, 47028);
            long last = CallChecker.varInit(((long) (0)), "last", 1303, 46450, 46463);
            InputStream is = CallChecker.varInit(null, "is", 1305, 46474, 46495);
            BufferedReader br = CallChecker.varInit(null, "br", 1306, 46505, 46529);
            TryContext _bcornu_try_context_496 = new TryContext(496, BundleArchive.class, "java.lang.Exception");
            try {
                final SecureAction npe_invocation_var590 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var590, SecureAction.class, 1309, 46570, 46598)) {
                    is = CallChecker.isCalled(npe_invocation_var590, SecureAction.class, 1309, 46570, 46598).getFileInputStream(new File(m_archiveRootDir, BundleArchive.BUNDLE_LASTMODIFIED_FILE));
                    CallChecker.varAssign(is, "is", 1309, 46565, 46689);
                }
                br = new BufferedReader(new InputStreamReader(is));
                CallChecker.varAssign(br, "br", 1311, 46703, 46753);
                if (CallChecker.beforeDeref(br, BufferedReader.class, 1312, 46789, 46790)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 1312, 46789, 46790);
                    last = Long.parseLong(CallChecker.isCalled(br, BufferedReader.class, 1312, 46789, 46790).readLine());
                    CallChecker.varAssign(last, "last", 1312, 46767, 46803);
                }
            } catch (Exception ex) {
                _bcornu_try_context_496.catchStart(496);
                last = 0;
                CallChecker.varAssign(last, "last", 1316, 46866, 46874);
            } finally {
                _bcornu_try_context_496.finallyStart(496);
                if (br != null)
                    br.close();
                
                if (is != null)
                    is.close();
                
            }
            return last;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1814.methodEnd();
        }
    }

    private void writeRefreshCount() throws Exception {
        MethodContext _bcornu_methode_context1815 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1327, 47035, 47818);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1327, 47035, 47818);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1327, 47035, 47818);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1327, 47035, 47818);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1327, 47035, 47818);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1327, 47035, 47818);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1327, 47035, 47818);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1327, 47035, 47818);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1327, 47035, 47818);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1327, 47035, 47818);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1327, 47035, 47818);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1327, 47035, 47818);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1327, 47035, 47818);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1327, 47035, 47818);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1327, 47035, 47818);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1327, 47035, 47818);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1327, 47035, 47818);
            CallChecker.varInit(this.m_id, "m_id", 1327, 47035, 47818);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1327, 47035, 47818);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1327, 47035, 47818);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1327, 47035, 47818);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1327, 47035, 47818);
            CallChecker.varInit(this.m_logger, "m_logger", 1327, 47035, 47818);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1327, 47035, 47818);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1327, 47035, 47818);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1327, 47035, 47818);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1327, 47035, 47818);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1327, 47035, 47818);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1327, 47035, 47818);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1327, 47035, 47818);
            OutputStream os = CallChecker.varInit(null, "os", 1329, 47099, 47121);
            BufferedWriter bw = CallChecker.varInit(null, "bw", 1330, 47131, 47155);
            TryContext _bcornu_try_context_497 = new TryContext(497, BundleArchive.class, "java.io.IOException");
            try {
                final SecureAction npe_invocation_var591 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var591, SecureAction.class, 1333, 47196, 47224)) {
                    os = CallChecker.isCalled(npe_invocation_var591, SecureAction.class, 1333, 47196, 47224).getFileOutputStream(new File(m_archiveRootDir, BundleArchive.REFRESH_COUNTER_FILE));
                    CallChecker.varAssign(os, "os", 1333, 47191, 47312);
                }
                bw = new BufferedWriter(new OutputStreamWriter(os));
                CallChecker.varAssign(bw, "bw", 1335, 47326, 47377);
                String s = CallChecker.varInit(Long.toString(m_refreshCount), "s", 1336, 47391, 47431);
                if (CallChecker.beforeDeref(s, String.class, 1337, 47460, 47460)) {
                    if (CallChecker.beforeDeref(bw, BufferedWriter.class, 1337, 47445, 47446)) {
                        s = CallChecker.beforeCalled(s, String.class, 1337, 47460, 47460);
                        bw = CallChecker.beforeCalled(bw, BufferedWriter.class, 1337, 47445, 47446);
                        CallChecker.isCalled(bw, BufferedWriter.class, 1337, 47445, 47446).write(s, 0, CallChecker.isCalled(s, String.class, 1337, 47460, 47460).length());
                    }
                }
            } catch (IOException ex) {
                _bcornu_try_context_497.catchStart(497);
                if (CallChecker.beforeDeref(getClass(), Class.class, 1343, 47600, 47609)) {
                    if (CallChecker.beforeDeref(m_logger, Logger.class, 1341, 47536, 47543)) {
                        CallChecker.isCalled(m_logger, Logger.class, 1341, 47536, 47543).log(Logger.LOG_ERROR, (((CallChecker.isCalled(getClass(), Class.class, 1343, 47600, 47609).getName()) + ": Unable to write refresh count: ") + ex));
                    }
                }
                throw ex;
            } finally {
                _bcornu_try_context_497.finallyStart(497);
                if (bw != null)
                    bw.close();
                
                if (os != null)
                    os.close();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1815.methodEnd();
        }
    }

    private long readRefreshCount() throws Exception {
        MethodContext _bcornu_methode_context1816 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 1353, 47825, 48466);
            CallChecker.varInit(UNINSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.UNINSTALLED_STATE", 1353, 47825, 48466);
            CallChecker.varInit(INSTALLED_STATE, "org.apache.felix.framework.cache.BundleArchive.INSTALLED_STATE", 1353, 47825, 48466);
            CallChecker.varInit(STARTING_STATE, "org.apache.felix.framework.cache.BundleArchive.STARTING_STATE", 1353, 47825, 48466);
            CallChecker.varInit(ACTIVE_STATE, "org.apache.felix.framework.cache.BundleArchive.ACTIVE_STATE", 1353, 47825, 48466);
            CallChecker.varInit(REFRESH_COUNTER_FILE, "org.apache.felix.framework.cache.BundleArchive.REFRESH_COUNTER_FILE", 1353, 47825, 48466);
            CallChecker.varInit(BUNDLE_LASTMODIFIED_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LASTMODIFIED_FILE", 1353, 47825, 48466);
            CallChecker.varInit(BUNDLE_START_LEVEL_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_START_LEVEL_FILE", 1353, 47825, 48466);
            CallChecker.varInit(BUNDLE_STATE_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_STATE_FILE", 1353, 47825, 48466);
            CallChecker.varInit(BUNDLE_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_LOCATION_FILE", 1353, 47825, 48466);
            CallChecker.varInit(BUNDLE_ID_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_ID_FILE", 1353, 47825, 48466);
            CallChecker.varInit(this.m_revisions, "m_revisions", 1353, 47825, 48466);
            CallChecker.varInit(this.m_refreshCount, "m_refreshCount", 1353, 47825, 48466);
            CallChecker.varInit(this.m_lastModified, "m_lastModified", 1353, 47825, 48466);
            CallChecker.varInit(this.m_startLevel, "m_startLevel", 1353, 47825, 48466);
            CallChecker.varInit(this.m_persistentState, "m_persistentState", 1353, 47825, 48466);
            CallChecker.varInit(this.m_originalLocation, "m_originalLocation", 1353, 47825, 48466);
            CallChecker.varInit(this.m_id, "m_id", 1353, 47825, 48466);
            CallChecker.varInit(this.m_isSingleBundleFile, "m_isSingleBundleFile", 1353, 47825, 48466);
            CallChecker.varInit(this.m_archiveRootDir, "m_archiveRootDir", 1353, 47825, 48466);
            CallChecker.varInit(this.m_zipFactory, "m_zipFactory", 1353, 47825, 48466);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1353, 47825, 48466);
            CallChecker.varInit(this.m_logger, "m_logger", 1353, 47825, 48466);
            CallChecker.varInit(DATA_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.DATA_DIRECTORY", 1353, 47825, 48466);
            CallChecker.varInit(REVISION_DIRECTORY, "org.apache.felix.framework.cache.BundleArchive.REVISION_DIRECTORY", 1353, 47825, 48466);
            CallChecker.varInit(REVISION_LOCATION_FILE, "org.apache.felix.framework.cache.BundleArchive.REVISION_LOCATION_FILE", 1353, 47825, 48466);
            CallChecker.varInit(BUNDLE_INFO_FILE, "org.apache.felix.framework.cache.BundleArchive.BUNDLE_INFO_FILE", 1353, 47825, 48466);
            CallChecker.varInit(INPUTSTREAM_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.INPUTSTREAM_PROTOCOL", 1353, 47825, 48466);
            CallChecker.varInit(REFERENCE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.REFERENCE_PROTOCOL", 1353, 47825, 48466);
            CallChecker.varInit(FILE_PROTOCOL, "org.apache.felix.framework.cache.BundleArchive.FILE_PROTOCOL", 1353, 47825, 48466);
            long count = CallChecker.varInit(((long) (0)), "count", 1355, 47888, 47902);
            InputStream is = CallChecker.varInit(null, "is", 1357, 47913, 47934);
            BufferedReader br = CallChecker.varInit(null, "br", 1358, 47944, 47968);
            TryContext _bcornu_try_context_498 = new TryContext(498, BundleArchive.class, "java.lang.Exception");
            try {
                final SecureAction npe_invocation_var592 = BundleCache.getSecureAction();
                if (CallChecker.beforeDeref(npe_invocation_var592, SecureAction.class, 1361, 48009, 48037)) {
                    is = CallChecker.isCalled(npe_invocation_var592, SecureAction.class, 1361, 48009, 48037).getFileInputStream(new File(m_archiveRootDir, BundleArchive.REFRESH_COUNTER_FILE));
                    CallChecker.varAssign(is, "is", 1361, 48004, 48124);
                }
                br = new BufferedReader(new InputStreamReader(is));
                CallChecker.varAssign(br, "br", 1363, 48138, 48188);
                if (CallChecker.beforeDeref(br, BufferedReader.class, 1364, 48225, 48226)) {
                    br = CallChecker.beforeCalled(br, BufferedReader.class, 1364, 48225, 48226);
                    count = Long.parseLong(CallChecker.isCalled(br, BufferedReader.class, 1364, 48225, 48226).readLine());
                    CallChecker.varAssign(count, "count", 1364, 48202, 48239);
                }
            } catch (Exception ex) {
                _bcornu_try_context_498.catchStart(498);
                count = 0;
                CallChecker.varAssign(count, "count", 1368, 48302, 48311);
            } finally {
                _bcornu_try_context_498.finallyStart(498);
                if (br != null)
                    br.close();
                
                if (is != null)
                    is.close();
                
            }
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1816.methodEnd();
        }
    }
}

