package org.apache.qpid.server.logging.logback;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.RollingPolicy;
import ch.qos.logback.core.rolling.RollingPolicyBase;
import ch.qos.logback.core.rolling.RolloverFailure;
import ch.qos.logback.core.rolling.helper.CompressionMode;
import ch.qos.logback.core.rolling.helper.FileNamePattern;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RollingPolicyDecorator implements RollingPolicy {
    public interface RolloverListener {
        void onRollover(Path baseFolder, String[] relativeFileNames);

        void onNoRolloverDetected(Path baseFolder, String[] relativeFileNames);
    }

    private class ScanTask implements Runnable {
        private int _rescanCounter;

        private volatile boolean _canceled;

        @Override
        public void run() {
            MethodContext _bcornu_methode_context47 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 186, 6165, 6843);
                CallChecker.varInit(this._canceled, "_canceled", 186, 6165, 6843);
                CallChecker.varInit(this._rescanCounter, "_rescanCounter", 186, 6165, 6843);
                if (!(isCanceled())) {
                    String[] rolloverFiles = CallChecker.varInit(scan(), "rolloverFiles", 190, 6273, 6304);
                    if ((!(publishScanResults(rolloverFiles))) && (!(isCanceled()))) {
                        if ((_rescanCounter) < (_rescanLimit)) {
                            ++(_rescanCounter);
                            if (CallChecker.beforeDeref(_executorService, ScheduledExecutorService.class, 197, 6541, 6556)) {
                                CallChecker.isCalled(_executorService, ScheduledExecutorService.class, 197, 6541, 6556).schedule(this, _rescanDelayMillis, TimeUnit.MILLISECONDS);
                            }
                        }else {
                            if (CallChecker.beforeDeref(_listener, RollingPolicyDecorator.RolloverListener.class, 201, 6710, 6718)) {
                                CallChecker.isCalled(_listener, RollingPolicyDecorator.RolloverListener.class, 201, 6710, 6718).onNoRolloverDetected(_rolledFilesBaseFolder, rolloverFiles);
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context47.methodEnd();
            }
        }

        private boolean publishScanResults(String[] rolloverFiles) {
            MethodContext _bcornu_methode_context48 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 207, 6854, 7583);
                CallChecker.varInit(rolloverFiles, "rolloverFiles", 207, 6854, 7583);
                CallChecker.varInit(this._canceled, "_canceled", 207, 6854, 7583);
                CallChecker.varInit(this._rescanCounter, "_rescanCounter", 207, 6854, 7583);
                boolean published = CallChecker.varInit(((boolean) (false)), "published", 209, 6935, 6960);
                if ((rolloverFiles != null) && (!(isCanceled()))) {
                    synchronized(_publishResultsLock) {
                        if ((!(isCanceled())) && (((_previousScanResults) == null) || (!(Arrays.equals(rolloverFiles, _previousScanResults))))) {
                            _previousScanResults = rolloverFiles;
                            CallChecker.varAssign(RollingPolicyDecorator.this._previousScanResults, "this._previousScanResults", 217, 7277, 7313);
                            published = true;
                            CallChecker.varAssign(published, "published", 218, 7339, 7355);
                        }
                    }
                }
                if (published) {
                    if (CallChecker.beforeDeref(_listener, RollingPolicyDecorator.RolloverListener.class, 225, 7469, 7477)) {
                        CallChecker.isCalled(_listener, RollingPolicyDecorator.RolloverListener.class, 225, 7469, 7477).onRollover(_rolledFilesBaseFolder, rolloverFiles);
                    }
                }
                return published;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context48.methodEnd();
            }
        }

        public String[] scan() {
            MethodContext _bcornu_methode_context53 = new MethodContext(String[].class);
            try {
                CallChecker.varInit(this, "this", 231, 7594, 9634);
                CallChecker.varInit(this._canceled, "_canceled", 231, 7594, 9634);
                CallChecker.varInit(this._rescanCounter, "_rescanCounter", 231, 7594, 9634);
                final List<Path> rolledFiles = CallChecker.varInit(new ArrayList<>(), "rolledFiles", 233, 7639, 7687);
                TryContext _bcornu_try_context_1 = new TryContext(1, RollingPolicyDecorator.class, "java.io.IOException");
                try {
                    Files.walkFileTree(_rolledFilesBaseFolder, new FileVisitor<Path>() {
                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                            MethodContext _bcornu_methode_context49 = new MethodContext(FileVisitResult.class);
                            try {
                                CallChecker.varInit(this, "this", 239, 7840, 8092);
                                CallChecker.varInit(attrs, "attrs", 239, 7840, 8092);
                                CallChecker.varInit(dir, "dir", 239, 7840, 8092);
                                if (isCanceled()) {
                                    return FileVisitResult.TERMINATE;
                                }else {
                                    return FileVisitResult.CONTINUE;
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((FileVisitResult) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context49.methodEnd();
                            }
                        }

                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            MethodContext _bcornu_methode_context50 = new MethodContext(FileVisitResult.class);
                            try {
                                CallChecker.varInit(this, "this", 245, 8115, 8807);
                                CallChecker.varInit(attrs, "attrs", 245, 8115, 8807);
                                CallChecker.varInit(file, "file", 245, 8115, 8807);
                                String absolutePath = CallChecker.init(String.class);
                                if (CallChecker.beforeDeref(file, Path.class, 247, 8284, 8287)) {
                                    file = CallChecker.beforeCalled(file, Path.class, 247, 8284, 8287);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(file, Path.class, 247, 8284, 8287).toAbsolutePath(), Path.class, 247, 8284, 8304)) {
                                        file = CallChecker.beforeCalled(file, Path.class, 247, 8284, 8287);
                                        absolutePath = CallChecker.isCalled(CallChecker.isCalled(file, Path.class, 247, 8284, 8287).toAbsolutePath(), Path.class, 247, 8284, 8304).toString();
                                        CallChecker.varAssign(absolutePath, "absolutePath", 247, 8284, 8287);
                                    }
                                }
                                if ((File.separatorChar) == '\\') {
                                    if (CallChecker.beforeDeref(absolutePath, String.class, 250, 8443, 8454)) {
                                        absolutePath = CallChecker.beforeCalled(absolutePath, String.class, 250, 8443, 8454);
                                        absolutePath = CallChecker.isCalled(absolutePath, String.class, 250, 8443, 8454).replace('\\', '/');
                                        CallChecker.varAssign(absolutePath, "absolutePath", 250, 8428, 8474);
                                    }
                                }
                                if (CallChecker.beforeDeref(_rolledFileRegExp, Pattern.class, 253, 8531, 8547)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(_rolledFileRegExp, Pattern.class, 253, 8531, 8547).matcher(absolutePath), Matcher.class, 253, 8531, 8569)) {
                                        if (CallChecker.isCalled(CallChecker.isCalled(_rolledFileRegExp, Pattern.class, 253, 8531, 8547).matcher(absolutePath), Matcher.class, 253, 8531, 8569).matches()) {
                                            if (CallChecker.beforeDeref(rolledFiles, List.class, 255, 8636, 8646)) {
                                                CallChecker.isCalled(rolledFiles, List.class, 255, 8636, 8646).add(file);
                                            }
                                        }
                                    }
                                }
                                if (isCanceled()) {
                                    return FileVisitResult.TERMINATE;
                                }else {
                                    return FileVisitResult.CONTINUE;
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((FileVisitResult) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context50.methodEnd();
                            }
                        }

                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException exc) {
                            MethodContext _bcornu_methode_context51 = new MethodContext(FileVisitResult.class);
                            try {
                                CallChecker.varInit(this, "this", 261, 8830, 9071);
                                CallChecker.varInit(exc, "exc", 261, 8830, 9071);
                                CallChecker.varInit(file, "file", 261, 8830, 9071);
                                if (isCanceled()) {
                                    return FileVisitResult.TERMINATE;
                                }else {
                                    return FileVisitResult.CONTINUE;
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((FileVisitResult) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context51.methodEnd();
                            }
                        }

                        @Override
                        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                            MethodContext _bcornu_methode_context52 = new MethodContext(FileVisitResult.class);
                            try {
                                CallChecker.varInit(this, "this", 267, 9094, 9337);
                                CallChecker.varInit(exc, "exc", 267, 9094, 9337);
                                CallChecker.varInit(dir, "dir", 267, 9094, 9337);
                                if (isCanceled()) {
                                    return FileVisitResult.TERMINATE;
                                }else {
                                    return FileVisitResult.CONTINUE;
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((FileVisitResult) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context52.methodEnd();
                            }
                        }
                    });
                } catch (IOException e) {
                    _bcornu_try_context_1.catchStart(1);
                    if (CallChecker.beforeDeref(RollingPolicyDecorator.LOGGER, Logger.class, 275, 9436, 9441)) {
                        CallChecker.isCalled(RollingPolicyDecorator.LOGGER, Logger.class, 275, 9436, 9441).warn("Unexpected IOException while scanning for rollover files.", e);
                    }
                } finally {
                    _bcornu_try_context_1.finallyStart(1);
                }
                if (isCanceled()) {
                    return null;
                }else {
                    return relativizeAndSort(_rolledFilesBaseFolder, rolledFiles);
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((String[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context53.methodEnd();
            }
        }

        public void cancel() {
            MethodContext _bcornu_methode_context54 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 280, 9645, 9714);
                CallChecker.varInit(this._canceled, "_canceled", 280, 9645, 9714);
                CallChecker.varInit(this._rescanCounter, "_rescanCounter", 280, 9645, 9714);
                _canceled = true;
                CallChecker.varAssign(this._canceled, "this._canceled", 282, 9688, 9704);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context54.methodEnd();
            }
        }

        private String[] relativizeAndSort(Path parent, List<Path> rolledFiles) {
            MethodContext _bcornu_methode_context56 = new MethodContext(String[].class);
            try {
                CallChecker.varInit(this, "this", 286, 9726, 10314);
                CallChecker.varInit(rolledFiles, "rolledFiles", 286, 9726, 10314);
                CallChecker.varInit(parent, "parent", 286, 9726, 10314);
                CallChecker.varInit(this._canceled, "_canceled", 286, 9726, 10314);
                CallChecker.varInit(this._rescanCounter, "_rescanCounter", 286, 9726, 10314);
                String[] results = CallChecker.init(String[].class);
                if (CallChecker.beforeDeref(rolledFiles, List.class, 288, 9850, 9860)) {
                    rolledFiles = CallChecker.beforeCalled(rolledFiles, List.class, 288, 9850, 9860);
                    results = new String[CallChecker.isCalled(rolledFiles, List.class, 288, 9850, 9860).size()];
                    CallChecker.varAssign(results, "results", 288, 9850, 9860);
                }
                int i = CallChecker.varInit(((int) (0)), "i", 289, 9883, 9892);
                if (CallChecker.beforeDeref(rolledFiles, String[].class, 290, 9920, 9930)) {
                    for (Path f : rolledFiles) {
                        if (CallChecker.beforeDeref(results, String[].class, 292, 9963, 9969)) {
                            if (CallChecker.beforeDeref(parent, Path.class, 292, 9978, 9983)) {
                                parent = CallChecker.beforeCalled(parent, Path.class, 292, 9978, 9983);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, Path.class, 292, 9978, 9983).relativize(f), Path.class, 292, 9978, 9997)) {
                                    results = CallChecker.beforeCalled(results, String[].class, 292, 9963, 9969);
                                    parent = CallChecker.beforeCalled(parent, Path.class, 292, 9978, 9983);
                                    CallChecker.isCalled(results, String[].class, 292, 9963, 9969)[(i++)] = CallChecker.isCalled(CallChecker.isCalled(parent, Path.class, 292, 9978, 9983).relativize(f), Path.class, 292, 9978, 9997).toString();
                                    CallChecker.varAssign(CallChecker.isCalled(results, String[].class, 292, 9963, 9969)[(i - 1)], "CallChecker.isCalled(results, String[].class, 292, 9963, 9969)[(i - 1)]", 292, 9963, 10009);
                                }
                            }
                        }
                    }
                }
                Arrays.sort(results, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        MethodContext _bcornu_methode_context55 = new MethodContext(int.class);
                        try {
                            CallChecker.varInit(this, "this", 298, 10114, 10260);
                            CallChecker.varInit(o2, "o2", 298, 10114, 10260);
                            CallChecker.varInit(o1, "o1", 298, 10114, 10260);
                            if (CallChecker.beforeDeref(o1, String.class, 300, 10226, 10227)) {
                                o1 = CallChecker.beforeCalled(o1, String.class, 300, 10226, 10227);
                                return CallChecker.isCalled(o1, String.class, 300, 10226, 10227).compareTo(o2);
                            }else
                                throw new AbnormalExecutionError();
                            
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context55.methodEnd();
                        }
                    }
                });
                return results;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context56.methodEnd();
            }
        }

        public boolean isCanceled() {
            MethodContext _bcornu_methode_context57 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 306, 10325, 10443);
                CallChecker.varInit(this._canceled, "_canceled", 306, 10325, 10443);
                CallChecker.varInit(this._rescanCounter, "_rescanCounter", 306, 10325, 10443);
                return (_canceled) || (CallChecker.isCalled(Thread.currentThread(), Thread.class, 308, 10395, 10416).isInterrupted());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context57.methodEnd();
            }
        }
    }

    public static final int DEFAULT_RESCAN_DELAY = 5000;

    public static final String ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME = "qpid.logger_rollover_rescan_delay_ms";

    public static final int DEFAULT_RESCAN_LIMIT = 60;

    public static final String ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME = "qpid.logger_rollover_rescan_limit";

    private static final Logger LOGGER = LoggerFactory.getLogger(RollingPolicyDecorator.class);

    private final RollingPolicyBase _decorated;

    private final RollingPolicyDecorator.RolloverListener _listener;

    private final Path _rolledFilesBaseFolder;

    private final Pattern _rolledFileRegExp;

    private final ScheduledExecutorService _executorService;

    private final long _rescanDelayMillis = Long.getLong(RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, RollingPolicyDecorator.DEFAULT_RESCAN_DELAY);

    private final long _rescanLimit = Long.getLong(RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT);

    private final Lock _publishResultsLock = new ReentrantLock();

    private RollingPolicyDecorator.ScanTask _currentScanTask;

    private String[] _previousScanResults;

    public RollingPolicyDecorator(RollingPolicyBase decorated, RollingPolicyDecorator.RolloverListener listener, ScheduledExecutorService executorService) {
        MethodContext _bcornu_methode_context7 = new MethodContext(null);
        try {
            _decorated = decorated;
            CallChecker.varAssign(this._decorated, "this._decorated", 71, 3047, 3069);
            _listener = listener;
            CallChecker.varAssign(this._listener, "this._listener", 72, 3079, 3099);
            _executorService = executorService;
            CallChecker.varAssign(this._executorService, "this._executorService", 73, 3109, 3143);
            String filePathPattern = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 75, 3179, 3188)) {
                filePathPattern = CallChecker.isCalled(_decorated, RollingPolicyBase.class, 75, 3179, 3188).getFileNamePattern();
                CallChecker.varAssign(filePathPattern, "filePathPattern", 75, 3179, 3188);
            }
            String filePathRegExp = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 76, 3281, 3290)) {
                if (CallChecker.beforeDeref(new FileNamePattern(filePathPattern, CallChecker.isCalled(_decorated, RollingPolicyBase.class, 76, 3281, 3290).getContext()), FileNamePattern.class, 76, 3244, 3304)) {
                    filePathRegExp = CallChecker.isCalled(new FileNamePattern(filePathPattern, CallChecker.isCalled(_decorated, RollingPolicyBase.class, 76, 3281, 3290).getContext()), FileNamePattern.class, 76, 3244, 3304).toRegex();
                    CallChecker.varAssign(filePathRegExp, "filePathRegExp", 76, 3281, 3290);
                }
            }
            _rolledFilesBaseFolder = getRolledFilesBaseFolderFromRegExp(filePathRegExp);
            CallChecker.varAssign(this._rolledFilesBaseFolder, "this._rolledFilesBaseFolder", 77, 3325, 3400);
            _rolledFileRegExp = Pattern.compile(filePathRegExp);
            CallChecker.varAssign(this._rolledFileRegExp, "this._rolledFileRegExp", 78, 3410, 3461);
            _currentScanTask = null;
            CallChecker.varAssign(this._currentScanTask, "this._currentScanTask", 79, 3471, 3494);
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    @Override
    public void rollover() throws RolloverFailure {
        MethodContext _bcornu_methode_context58 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 83, 3507, 3709);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 83, 3507, 3709);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 83, 3507, 3709);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 83, 3507, 3709);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 83, 3507, 3709);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 83, 3507, 3709);
            CallChecker.varInit(this._executorService, "_executorService", 83, 3507, 3709);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 83, 3507, 3709);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 83, 3507, 3709);
            CallChecker.varInit(this._listener, "_listener", 83, 3507, 3709);
            CallChecker.varInit(this._decorated, "_decorated", 83, 3507, 3709);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 83, 3507, 3709);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 83, 3507, 3709);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 83, 3507, 3709);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 83, 3507, 3709);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 83, 3507, 3709);
            RollingPolicyDecorator.ScanTask task = CallChecker.varInit(createScanTaskAndCancelInProgress(), "task", 85, 3581, 3632);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 86, 3642, 3651)) {
                CallChecker.isCalled(_decorated, RollingPolicyBase.class, 86, 3642, 3651).rollover();
            }
            if (CallChecker.beforeDeref(_executorService, ScheduledExecutorService.class, 87, 3673, 3688)) {
                CallChecker.isCalled(_executorService, ScheduledExecutorService.class, 87, 3673, 3688).execute(task);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    @Override
    public String getActiveFileName() {
        MethodContext _bcornu_methode_context59 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 91, 3716, 3821);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 91, 3716, 3821);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 91, 3716, 3821);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 91, 3716, 3821);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 91, 3716, 3821);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 91, 3716, 3821);
            CallChecker.varInit(this._executorService, "_executorService", 91, 3716, 3821);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 91, 3716, 3821);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 91, 3716, 3821);
            CallChecker.varInit(this._listener, "_listener", 91, 3716, 3821);
            CallChecker.varInit(this._decorated, "_decorated", 91, 3716, 3821);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 91, 3716, 3821);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 91, 3716, 3821);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 91, 3716, 3821);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 91, 3716, 3821);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 91, 3716, 3821);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 93, 3785, 3794)) {
                return CallChecker.isCalled(_decorated, RollingPolicyBase.class, 93, 3785, 3794).getActiveFileName();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    @Override
    public CompressionMode getCompressionMode() {
        MethodContext _bcornu_methode_context60 = new MethodContext(CompressionMode.class);
        try {
            CallChecker.varInit(this, "this", 97, 3828, 3944);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 97, 3828, 3944);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 97, 3828, 3944);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 97, 3828, 3944);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 97, 3828, 3944);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 97, 3828, 3944);
            CallChecker.varInit(this._executorService, "_executorService", 97, 3828, 3944);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 97, 3828, 3944);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 97, 3828, 3944);
            CallChecker.varInit(this._listener, "_listener", 97, 3828, 3944);
            CallChecker.varInit(this._decorated, "_decorated", 97, 3828, 3944);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 97, 3828, 3944);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 97, 3828, 3944);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 97, 3828, 3944);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 97, 3828, 3944);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 97, 3828, 3944);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 99, 3907, 3916)) {
                return CallChecker.isCalled(_decorated, RollingPolicyBase.class, 99, 3907, 3916).getCompressionMode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((CompressionMode) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    @Override
    public void setParent(FileAppender appender) {
        MethodContext _bcornu_methode_context61 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 103, 3951, 4060);
            CallChecker.varInit(appender, "appender", 103, 3951, 4060);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 103, 3951, 4060);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 103, 3951, 4060);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 103, 3951, 4060);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 103, 3951, 4060);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 103, 3951, 4060);
            CallChecker.varInit(this._executorService, "_executorService", 103, 3951, 4060);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 103, 3951, 4060);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 103, 3951, 4060);
            CallChecker.varInit(this._listener, "_listener", 103, 3951, 4060);
            CallChecker.varInit(this._decorated, "_decorated", 103, 3951, 4060);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 103, 3951, 4060);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 103, 3951, 4060);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 103, 3951, 4060);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 103, 3951, 4060);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 103, 3951, 4060);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 105, 4024, 4033)) {
                CallChecker.isCalled(_decorated, RollingPolicyBase.class, 105, 4024, 4033).setParent(appender);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    @Override
    public void start() {
        MethodContext _bcornu_methode_context62 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 109, 4067, 4240);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 109, 4067, 4240);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 109, 4067, 4240);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 109, 4067, 4240);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 109, 4067, 4240);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 109, 4067, 4240);
            CallChecker.varInit(this._executorService, "_executorService", 109, 4067, 4240);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 109, 4067, 4240);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 109, 4067, 4240);
            CallChecker.varInit(this._listener, "_listener", 109, 4067, 4240);
            CallChecker.varInit(this._decorated, "_decorated", 109, 4067, 4240);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 109, 4067, 4240);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 109, 4067, 4240);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 109, 4067, 4240);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 109, 4067, 4240);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 109, 4067, 4240);
            RollingPolicyDecorator.ScanTask task = CallChecker.varInit(createScanTaskAndCancelInProgress(), "task", 111, 4115, 4166);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 112, 4176, 4185)) {
                CallChecker.isCalled(_decorated, RollingPolicyBase.class, 112, 4176, 4185).start();
            }
            if (CallChecker.beforeDeref(_executorService, ScheduledExecutorService.class, 113, 4204, 4219)) {
                CallChecker.isCalled(_executorService, ScheduledExecutorService.class, 113, 4204, 4219).execute(task);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    @Override
    public void stop() {
        MethodContext _bcornu_methode_context63 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 117, 4247, 4534);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 117, 4247, 4534);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 117, 4247, 4534);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 117, 4247, 4534);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 117, 4247, 4534);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 117, 4247, 4534);
            CallChecker.varInit(this._executorService, "_executorService", 117, 4247, 4534);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 117, 4247, 4534);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 117, 4247, 4534);
            CallChecker.varInit(this._listener, "_listener", 117, 4247, 4534);
            CallChecker.varInit(this._decorated, "_decorated", 117, 4247, 4534);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 117, 4247, 4534);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 117, 4247, 4534);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 117, 4247, 4534);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 117, 4247, 4534);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 117, 4247, 4534);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 119, 4294, 4303)) {
                CallChecker.isCalled(_decorated, RollingPolicyBase.class, 119, 4294, 4303).stop();
            }
            synchronized(_publishResultsLock) {
                if ((_currentScanTask) != null) {
                    _currentScanTask.cancel();
                }
                _previousScanResults = null;
                CallChecker.varAssign(this._previousScanResults, "this._previousScanResults", 126, 4491, 4518);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }

    @Override
    public boolean isStarted() {
        MethodContext _bcornu_methode_context64 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 131, 4541, 4631);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 131, 4541, 4631);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 131, 4541, 4631);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 131, 4541, 4631);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 131, 4541, 4631);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 131, 4541, 4631);
            CallChecker.varInit(this._executorService, "_executorService", 131, 4541, 4631);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 131, 4541, 4631);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 131, 4541, 4631);
            CallChecker.varInit(this._listener, "_listener", 131, 4541, 4631);
            CallChecker.varInit(this._decorated, "_decorated", 131, 4541, 4631);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 131, 4541, 4631);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 131, 4541, 4631);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 131, 4541, 4631);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 131, 4541, 4631);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 131, 4541, 4631);
            if (CallChecker.beforeDeref(_decorated, RollingPolicyBase.class, 133, 4603, 4612)) {
                return CallChecker.isCalled(_decorated, RollingPolicyBase.class, 133, 4603, 4612).isStarted();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    public RollingPolicyBase getDecorated() {
        MethodContext _bcornu_methode_context65 = new MethodContext(RollingPolicyBase.class);
        try {
            CallChecker.varInit(this, "this", 143, 4840, 4917);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 143, 4840, 4917);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 143, 4840, 4917);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 143, 4840, 4917);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 143, 4840, 4917);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 143, 4840, 4917);
            CallChecker.varInit(this._executorService, "_executorService", 143, 4840, 4917);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 143, 4840, 4917);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 143, 4840, 4917);
            CallChecker.varInit(this._listener, "_listener", 143, 4840, 4917);
            CallChecker.varInit(this._decorated, "_decorated", 143, 4840, 4917);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 143, 4840, 4917);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 143, 4840, 4917);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 143, 4840, 4917);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 143, 4840, 4917);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 143, 4840, 4917);
            return _decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RollingPolicyBase) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    private RollingPolicyDecorator.ScanTask createScanTaskAndCancelInProgress() {
        MethodContext _bcornu_methode_context66 = new MethodContext(RollingPolicyDecorator.ScanTask.class);
        try {
            CallChecker.varInit(this, "this", 148, 4924, 5261);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 148, 4924, 5261);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 148, 4924, 5261);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 148, 4924, 5261);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 148, 4924, 5261);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 148, 4924, 5261);
            CallChecker.varInit(this._executorService, "_executorService", 148, 4924, 5261);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 148, 4924, 5261);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 148, 4924, 5261);
            CallChecker.varInit(this._listener, "_listener", 148, 4924, 5261);
            CallChecker.varInit(this._decorated, "_decorated", 148, 4924, 5261);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 148, 4924, 5261);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 148, 4924, 5261);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 148, 4924, 5261);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 148, 4924, 5261);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 148, 4924, 5261);
            RollingPolicyDecorator.ScanTask task = CallChecker.varInit(new RollingPolicyDecorator.ScanTask(), "task", 150, 4991, 5021);
            synchronized(_publishResultsLock) {
                if ((_currentScanTask) != null) {
                    _currentScanTask.cancel();
                }
                _currentScanTask = task;
                CallChecker.varAssign(this._currentScanTask, "this._currentScanTask", 157, 5201, 5224);
            }
            return task;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RollingPolicyDecorator.ScanTask) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }

    private Path getRolledFilesBaseFolderFromRegExp(String fileNamePattern) {
        MethodContext _bcornu_methode_context67 = new MethodContext(Path.class);
        try {
            CallChecker.varInit(this, "this", 162, 5268, 6020);
            CallChecker.varInit(fileNamePattern, "fileNamePattern", 162, 5268, 6020);
            CallChecker.varInit(this._previousScanResults, "_previousScanResults", 162, 5268, 6020);
            CallChecker.varInit(this._currentScanTask, "_currentScanTask", 162, 5268, 6020);
            CallChecker.varInit(this._publishResultsLock, "_publishResultsLock", 162, 5268, 6020);
            CallChecker.varInit(this._rescanLimit, "_rescanLimit", 162, 5268, 6020);
            CallChecker.varInit(this._rescanDelayMillis, "_rescanDelayMillis", 162, 5268, 6020);
            CallChecker.varInit(this._executorService, "_executorService", 162, 5268, 6020);
            CallChecker.varInit(this._rolledFileRegExp, "_rolledFileRegExp", 162, 5268, 6020);
            CallChecker.varInit(this._rolledFilesBaseFolder, "_rolledFilesBaseFolder", 162, 5268, 6020);
            CallChecker.varInit(this._listener, "_listener", 162, 5268, 6020);
            CallChecker.varInit(this._decorated, "_decorated", 162, 5268, 6020);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.LOGGER", 162, 5268, 6020);
            CallChecker.varInit(ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_LIMIT_PROPERTY_NAME", 162, 5268, 6020);
            CallChecker.varInit(DEFAULT_RESCAN_LIMIT, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_LIMIT", 162, 5268, 6020);
            CallChecker.varInit(ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.ROLLOVER_RESCAN_DELAY_MS_PROPERTY_NAME", 162, 5268, 6020);
            CallChecker.varInit(DEFAULT_RESCAN_DELAY, "org.apache.qpid.server.logging.logback.RollingPolicyDecorator.DEFAULT_RESCAN_DELAY", 162, 5268, 6020);
            int firstDigitPatternPosition = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(fileNamePattern, String.class, 164, 5385, 5399)) {
                fileNamePattern = CallChecker.beforeCalled(fileNamePattern, String.class, 164, 5385, 5399);
                firstDigitPatternPosition = CallChecker.isCalled(fileNamePattern, String.class, 164, 5385, 5399).indexOf("\\d");
                CallChecker.varAssign(firstDigitPatternPosition, "firstDigitPatternPosition", 164, 5385, 5399);
            }
            if (firstDigitPatternPosition == (-1)) {
                throw new RuntimeException("Rolling policy file pattern does not seem to contain date or integer token");
            }
            int slashBeforeDigitPatternPosition = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(fileNamePattern, String.class, 169, 5646, 5660)) {
                fileNamePattern = CallChecker.beforeCalled(fileNamePattern, String.class, 169, 5646, 5660);
                slashBeforeDigitPatternPosition = CallChecker.isCalled(fileNamePattern, String.class, 169, 5646, 5660).lastIndexOf("/", firstDigitPatternPosition);
                CallChecker.varAssign(slashBeforeDigitPatternPosition, "slashBeforeDigitPatternPosition", 169, 5646, 5660);
            }
            if (slashBeforeDigitPatternPosition != (-1)) {
                if (CallChecker.beforeDeref(fileNamePattern, String.class, 172, 5796, 5810)) {
                    fileNamePattern = CallChecker.beforeCalled(fileNamePattern, String.class, 172, 5796, 5810);
                    if (CallChecker.beforeDeref(new File(CallChecker.isCalled(fileNamePattern, String.class, 172, 5796, 5810).substring(0, slashBeforeDigitPatternPosition)), File.class, 172, 5787, 5857)) {
                        fileNamePattern = CallChecker.beforeCalled(fileNamePattern, String.class, 172, 5796, 5810);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(new File(CallChecker.isCalled(fileNamePattern, String.class, 172, 5796, 5810).substring(0, slashBeforeDigitPatternPosition)), File.class, 172, 5787, 5857).toPath(), Path.class, 172, 5787, 5866)) {
                            fileNamePattern = CallChecker.beforeCalled(fileNamePattern, String.class, 172, 5796, 5810);
                            return CallChecker.isCalled(CallChecker.isCalled(new File(CallChecker.isCalled(fileNamePattern, String.class, 172, 5796, 5810).substring(0, slashBeforeDigitPatternPosition)), File.class, 172, 5787, 5857).toPath(), Path.class, 172, 5787, 5866).toAbsolutePath();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                if (CallChecker.beforeDeref(new File(System.getProperty("user.dir")), File.class, 176, 5938, 5977)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(new File(System.getProperty("user.dir")), File.class, 176, 5938, 5977).toPath(), Path.class, 176, 5938, 5986)) {
                        return CallChecker.isCalled(CallChecker.isCalled(new File(System.getProperty("user.dir")), File.class, 176, 5938, 5977).toPath(), Path.class, 176, 5938, 5986).toAbsolutePath();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Path) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }
}

