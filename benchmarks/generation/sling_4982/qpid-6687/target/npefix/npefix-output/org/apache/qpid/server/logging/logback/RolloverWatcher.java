package org.apache.qpid.server.logging.logback;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.qpid.server.logging.LogFileDetails;
import org.apache.qpid.server.logging.PathContent;
import org.apache.qpid.server.logging.ZippedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RolloverWatcher implements RollingPolicyDecorator.RolloverListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RolloverWatcher.class);

    private static final Comparator<LogFileDetails> LAST_MODIFIED_COMPARATOR = new Comparator<LogFileDetails>() {
        @Override
        public int compare(final LogFileDetails o1, final LogFileDetails o2) {
            MethodContext _bcornu_methode_context180 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 49, 1686, 1863);
                CallChecker.varInit(o2, "o2", 49, 1686, 1863);
                CallChecker.varInit(o1, "o1", 49, 1686, 1863);
                return ((int) ((CallChecker.isCalled(o2, LogFileDetails.class, 51, 1809, 1810).getLastModified()) - (CallChecker.isCalled(o1, LogFileDetails.class, 51, 1832, 1833).getLastModified())));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context180.methodEnd();
            }
        }
    };

    private final Path _activeFilePath;

    private volatile Collection<String> _rolledFiles;

    private volatile Path _baseFolder;

    public RolloverWatcher(final String activeFileName) {
        MethodContext _bcornu_methode_context19 = new MethodContext(null);
        try {
            _activeFilePath = CallChecker.isCalled(new File(activeFileName), File.class, 60, 2094, 2117).toPath();
            CallChecker.varAssign(this._activeFilePath, "this._activeFilePath", 60, 2076, 2127);
            _rolledFiles = Collections.emptyList();
            CallChecker.varAssign(this._rolledFiles, "this._rolledFiles", 61, 2137, 2175);
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    @Override
    public void onRollover(Path baseFolder, String[] relativeFileNames) {
        MethodContext _bcornu_methode_context181 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 65, 2188, 2407);
            CallChecker.varInit(relativeFileNames, "relativeFileNames", 65, 2188, 2407);
            CallChecker.varInit(baseFolder, "baseFolder", 65, 2188, 2407);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 65, 2188, 2407);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 65, 2188, 2407);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 65, 2188, 2407);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 65, 2188, 2407);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 65, 2188, 2407);
            _rolledFiles = Collections.unmodifiableCollection(Arrays.asList(relativeFileNames));
            CallChecker.varAssign(this._rolledFiles, "this._rolledFiles", 67, 2284, 2367);
            _baseFolder = baseFolder;
            CallChecker.varAssign(this._baseFolder, "this._baseFolder", 68, 2377, 2401);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context181.methodEnd();
        }
    }

    @Override
    public void onNoRolloverDetected(final Path baseFolder, final String[] relativeFileNames) {
        MethodContext _bcornu_methode_context182 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 72, 2414, 2718);
            CallChecker.varInit(relativeFileNames, "relativeFileNames", 72, 2414, 2718);
            CallChecker.varInit(baseFolder, "baseFolder", 72, 2414, 2718);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 72, 2414, 2718);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 72, 2414, 2718);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 72, 2414, 2718);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 72, 2414, 2718);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 72, 2414, 2718);
            if ((_baseFolder) == null) {
                _baseFolder = baseFolder;
                CallChecker.varAssign(this._baseFolder, "this._baseFolder", 76, 2579, 2603);
            }
            if (CallChecker.beforeDeref(RolloverWatcher.LOGGER, Logger.class, 78, 2623, 2628)) {
                CallChecker.isCalled(RolloverWatcher.LOGGER, Logger.class, 78, 2623, 2628).warn("Exceeded maximum number of rescans without detecting rolled over log file.");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context182.methodEnd();
        }
    }

    public PathContent getFileContent(String fileName) {
        MethodContext _bcornu_methode_context183 = new MethodContext(PathContent.class);
        try {
            CallChecker.varInit(this, "this", 81, 2725, 3016);
            CallChecker.varInit(fileName, "fileName", 81, 2725, 3016);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 81, 2725, 3016);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 81, 2725, 3016);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 81, 2725, 3016);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 81, 2725, 3016);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 81, 2725, 3016);
            if (fileName == null) {
                throw new IllegalArgumentException("File name cannot be null");
            }
            Path path = CallChecker.varInit(getPath(fileName), "path", 88, 2917, 2946);
            return new PathContent(path, getContentType(fileName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PathContent) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context183.methodEnd();
        }
    }

    private Path getPath(String fileName) {
        MethodContext _bcornu_methode_context184 = new MethodContext(Path.class);
        try {
            CallChecker.varInit(this, "this", 92, 3023, 3390);
            CallChecker.varInit(fileName, "fileName", 92, 3023, 3390);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 92, 3023, 3390);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 92, 3023, 3390);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 92, 3023, 3390);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 92, 3023, 3390);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 92, 3023, 3390);
            Path path = CallChecker.varInit(null, "path", 94, 3075, 3091);
            File active = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(_activeFilePath, Path.class, 95, 3115, 3129)) {
                active = CallChecker.isCalled(_activeFilePath, Path.class, 95, 3115, 3129).toFile();
                CallChecker.varAssign(active, "active", 95, 3115, 3129);
            }
            if (CallChecker.beforeDeref(active, File.class, 96, 3169, 3174)) {
                if (CallChecker.beforeDeref(fileName, String.class, 96, 3153, 3160)) {
                    active = CallChecker.beforeCalled(active, File.class, 96, 3169, 3174);
                    fileName = CallChecker.beforeCalled(fileName, String.class, 96, 3153, 3160);
                    if (CallChecker.isCalled(fileName, String.class, 96, 3153, 3160).equals(CallChecker.isCalled(active, File.class, 96, 3169, 3174).getName())) {
                        if (CallChecker.beforeDeref(active, File.class, 98, 3218, 3223)) {
                            active = CallChecker.beforeCalled(active, File.class, 98, 3218, 3223);
                            path = CallChecker.isCalled(active, File.class, 98, 3218, 3223).toPath();
                            CallChecker.varAssign(path, "path", 98, 3210, 3233);
                        }
                    }else
                        if (CallChecker.beforeDeref(_rolledFiles, Collection.class, 100, 3262, 3273)) {
                            _rolledFiles = CallChecker.beforeCalled(_rolledFiles, Collection.class, 100, 3262, 3273);
                            if (CallChecker.isCalled(_rolledFiles, Collection.class, 100, 3262, 3273).contains(fileName)) {
                                if (CallChecker.beforeDeref(_baseFolder, Path.class, 102, 3324, 3334)) {
                                    _baseFolder = CallChecker.beforeCalled(_baseFolder, Path.class, 102, 3324, 3334);
                                    path = CallChecker.isCalled(_baseFolder, Path.class, 102, 3324, 3334).resolve(fileName);
                                    CallChecker.varAssign(path, "path", 102, 3317, 3353);
                                }
                            }
                        }
                    
                }
            }
            return path;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Path) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context184.methodEnd();
        }
    }

    public Collection<String> getRolledFiles() {
        MethodContext _bcornu_methode_context185 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 107, 3397, 3479);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 107, 3397, 3479);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 107, 3397, 3479);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 107, 3397, 3479);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 107, 3397, 3479);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 107, 3397, 3479);
            return _rolledFiles;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context185.methodEnd();
        }
    }

    public List<LogFileDetails> getLogFileDetails() {
        MethodContext _bcornu_methode_context186 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 112, 3486, 4019);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 112, 3486, 4019);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 112, 3486, 4019);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 112, 3486, 4019);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 112, 3486, 4019);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 112, 3486, 4019);
            List<LogFileDetails> results = CallChecker.varInit(new ArrayList<>(), "results", 114, 3548, 3596);
            if (CallChecker.beforeDeref(results, List.class, 115, 3606, 3612)) {
                results = CallChecker.beforeCalled(results, List.class, 115, 3606, 3612);
                CallChecker.isCalled(results, List.class, 115, 3606, 3612).add(getFileDetails(_activeFilePath));
            }
            List<String> rolledFiles = CallChecker.varInit(new ArrayList<>(_rolledFiles), "rolledFiles", 116, 3660, 3716);
            if (CallChecker.beforeDeref(rolledFiles, List.class, 117, 3749, 3759)) {
                for (String fileName : rolledFiles) {
                    Path file = CallChecker.init(Path.class);
                    if (CallChecker.beforeDeref(_baseFolder, Path.class, 119, 3796, 3806)) {
                        _baseFolder = CallChecker.beforeCalled(_baseFolder, Path.class, 119, 3796, 3806);
                        file = CallChecker.isCalled(_baseFolder, Path.class, 119, 3796, 3806).resolve(fileName);
                        CallChecker.varAssign(file, "file", 119, 3796, 3806);
                    }
                    LogFileDetails details = CallChecker.varInit(getFileDetails(file), "details", 120, 3839, 3884);
                    if (CallChecker.beforeDeref(results, List.class, 121, 3898, 3904)) {
                        results = CallChecker.beforeCalled(results, List.class, 121, 3898, 3904);
                        CallChecker.isCalled(results, List.class, 121, 3898, 3904).add(details);
                    }
                }
            }
            Collections.sort(results, RolloverWatcher.LAST_MODIFIED_COMPARATOR);
            return results;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<LogFileDetails>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context186.methodEnd();
        }
    }

    private LogFileDetails getFileDetails(Path path) {
        MethodContext _bcornu_methode_context187 = new MethodContext(LogFileDetails.class);
        try {
            CallChecker.varInit(this, "this", 127, 4026, 4213);
            CallChecker.varInit(path, "path", 127, 4026, 4213);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 127, 4026, 4213);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 127, 4026, 4213);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 127, 4026, 4213);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 127, 4026, 4213);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 127, 4026, 4213);
            File file = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(path, Path.class, 129, 4101, 4104)) {
                path = CallChecker.beforeCalled(path, Path.class, 129, 4101, 4104);
                file = CallChecker.isCalled(path, Path.class, 129, 4101, 4104).toFile();
                CallChecker.varAssign(file, "file", 129, 4101, 4104);
            }
            if (CallChecker.beforeDeref(file, File.class, 130, 4172, 4175)) {
                if (CallChecker.beforeDeref(file, File.class, 130, 4193, 4196)) {
                    file = CallChecker.beforeCalled(file, File.class, 130, 4172, 4175);
                    file = CallChecker.beforeCalled(file, File.class, 130, 4193, 4196);
                    return new LogFileDetails(getDisplayName(path), CallChecker.isCalled(file, File.class, 130, 4172, 4175).lastModified(), CallChecker.isCalled(file, File.class, 130, 4193, 4196).length());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogFileDetails) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context187.methodEnd();
        }
    }

    private String getDisplayName(Path path) {
        MethodContext _bcornu_methode_context188 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 133, 4220, 4739);
            CallChecker.varInit(path, "path", 133, 4220, 4739);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 133, 4220, 4739);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 133, 4220, 4739);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 133, 4220, 4739);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 133, 4220, 4739);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 133, 4220, 4739);
            String displayName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(path, Path.class, 135, 4296, 4299)) {
                path = CallChecker.beforeCalled(path, Path.class, 135, 4296, 4299);
                if (CallChecker.beforeDeref(CallChecker.isCalled(path, Path.class, 135, 4296, 4299).getFileName(), Path.class, 135, 4296, 4313)) {
                    path = CallChecker.beforeCalled(path, Path.class, 135, 4296, 4299);
                    displayName = CallChecker.isCalled(CallChecker.isCalled(path, Path.class, 135, 4296, 4299).getFileName(), Path.class, 135, 4296, 4313).toString();
                    CallChecker.varAssign(displayName, "displayName", 135, 4296, 4299);
                }
            }
            if (CallChecker.beforeDeref(_activeFilePath, Path.class, 136, 4340, 4354)) {
                if ((!(CallChecker.isCalled(_activeFilePath, Path.class, 136, 4340, 4354).equals(path))) && ((_baseFolder) != null)) {
                    TryContext _bcornu_try_context_3 = new TryContext(3, RolloverWatcher.class, "java.lang.IllegalArgumentException");
                    try {
                        _baseFolder = CallChecker.beforeCalled(_baseFolder, Path.class, 140, 4465, 4475);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(_baseFolder, Path.class, 140, 4465, 4475).relativize(path), Path.class, 140, 4465, 4492)) {
                            displayName = CallChecker.isCalled(_baseFolder.relativize(path), Path.class, 140, 4465, 4492).toString();
                            CallChecker.varAssign(displayName, "displayName", 140, 4451, 4504);
                        }
                    } catch (IllegalArgumentException e) {
                        _bcornu_try_context_3.catchStart(3);
                    } finally {
                        _bcornu_try_context_3.finallyStart(3);
                    }
                }
            }
            return displayName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context188.methodEnd();
        }
    }

    public String getContentType(String fileName) {
        MethodContext _bcornu_methode_context189 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 151, 4746, 5136);
            CallChecker.varInit(fileName, "fileName", 151, 4746, 5136);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 151, 4746, 5136);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 151, 4746, 5136);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 151, 4746, 5136);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 151, 4746, 5136);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 151, 4746, 5136);
            String fileNameLower = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(fileName, String.class, 153, 4829, 4836)) {
                fileName = CallChecker.beforeCalled(fileName, String.class, 153, 4829, 4836);
                fileNameLower = CallChecker.isCalled(fileName, String.class, 153, 4829, 4836).toLowerCase();
                CallChecker.varAssign(fileNameLower, "fileNameLower", 153, 4829, 4836);
            }
            if (CallChecker.beforeDeref(fileNameLower, String.class, 154, 4865, 4877)) {
                fileNameLower = CallChecker.beforeCalled(fileNameLower, String.class, 154, 4865, 4877);
                if (CallChecker.isCalled(fileNameLower, String.class, 154, 4865, 4877).endsWith(".gz")) {
                    return "application/x-gzip";
                }else
                    if (CallChecker.beforeDeref(fileNameLower, String.class, 158, 4974, 4986)) {
                        fileNameLower = CallChecker.beforeCalled(fileNameLower, String.class, 158, 4974, 4986);
                        if (CallChecker.isCalled(fileNameLower, String.class, 158, 4974, 4986).endsWith(".zip")) {
                            return "application/x-zip";
                        }else {
                            return "text/plain";
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context189.methodEnd();
        }
    }

    public ZippedContent getFilesAsZippedContent(Set<String> fileNames) {
        MethodContext _bcornu_methode_context190 = new MethodContext(ZippedContent.class);
        try {
            CallChecker.varInit(this, "this", 168, 5143, 5647);
            CallChecker.varInit(fileNames, "fileNames", 168, 5143, 5647);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 168, 5143, 5647);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 168, 5143, 5647);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 168, 5143, 5647);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 168, 5143, 5647);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 168, 5143, 5647);
            if (fileNames == null) {
                throw new IllegalArgumentException("File name cannot be null");
            }
            Map<String, Path> paths = CallChecker.varInit(new TreeMap<>(), "paths", 175, 5353, 5394);
            for (String name : fileNames) {
                Path filePath = CallChecker.varInit(getPath(name), "filePath", 178, 5455, 5484);
                if (filePath != null) {
                    if (CallChecker.beforeDeref(paths, Map.class, 181, 5550, 5554)) {
                        paths = CallChecker.beforeCalled(paths, Map.class, 181, 5550, 5554);
                        CallChecker.isCalled(paths, Map.class, 181, 5550, 5554).put(name, filePath);
                    }
                }
            }
            return new ZippedContent(paths);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ZippedContent) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context190.methodEnd();
        }
    }

    public ZippedContent getAllFilesAsZippedContent() {
        MethodContext _bcornu_methode_context191 = new MethodContext(ZippedContent.class);
        try {
            CallChecker.varInit(this, "this", 188, 5654, 5883);
            CallChecker.varInit(this._baseFolder, "_baseFolder", 188, 5654, 5883);
            CallChecker.varInit(this._rolledFiles, "_rolledFiles", 188, 5654, 5883);
            CallChecker.varInit(this._activeFilePath, "_activeFilePath", 188, 5654, 5883);
            CallChecker.varInit(LAST_MODIFIED_COMPARATOR, "org.apache.qpid.server.logging.logback.RolloverWatcher.LAST_MODIFIED_COMPARATOR", 188, 5654, 5883);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RolloverWatcher.LOGGER", 188, 5654, 5883);
            Set<String> fileNames = CallChecker.varInit(new HashSet<>(_rolledFiles), "fileNames", 190, 5718, 5769);
            if (CallChecker.beforeDeref(fileNames, Set.class, 191, 5779, 5787)) {
                fileNames = CallChecker.beforeCalled(fileNames, Set.class, 191, 5779, 5787);
                CallChecker.isCalled(fileNames, Set.class, 191, 5779, 5787).add(getDisplayName(_activeFilePath));
            }
            return getFilesAsZippedContent(fileNames);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ZippedContent) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context191.methodEnd();
        }
    }
}

