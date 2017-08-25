package org.apache.qpid.server.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.rolling.RollingFileAppender;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import java.security.AccessControlException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.apache.qpid.server.logging.logback.RollingPolicyDecorator;
import org.apache.qpid.server.logging.logback.RolloverWatcher;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.Content;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;
import org.apache.qpid.server.model.Param;
import org.apache.qpid.server.model.VirtualHost;
import org.apache.qpid.server.security.SecurityManager;
import org.apache.qpid.server.util.DaemonThreadFactory;

public class VirtualHostFileLoggerImpl extends AbstractVirtualHostLogger<VirtualHostFileLoggerImpl> implements FileLoggerSettings , VirtualHostFileLogger<VirtualHostFileLoggerImpl> {
    private RolloverWatcher _rolloverWatcher;

    private ScheduledExecutorService _rolledPolicyExecutor;

    @ManagedAttributeField
    private String _layout;

    @ManagedAttributeField
    private String _fileName;

    @ManagedAttributeField
    private boolean _rollDaily;

    @ManagedAttributeField
    private boolean _rollOnRestart;

    @ManagedAttributeField
    private boolean _compressOldFiles;

    @ManagedAttributeField
    private int _maxHistory;

    @ManagedAttributeField
    private int _maxFileSize;

    @ManagedAttributeField
    private boolean _safeMode;

    @ManagedObjectFactoryConstructor
    protected VirtualHostFileLoggerImpl(final Map<String, Object> attributes, VirtualHost<?, ?, ?> virtualHost) {
        super(attributes, virtualHost);
        MethodContext _bcornu_methode_context3 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    @Override
    protected void postResolveChildren() {
        MethodContext _bcornu_methode_context17 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 75, 2764, 3061);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 75, 2764, 3061);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 75, 2764, 3061);
            CallChecker.varInit(this.TYPE, "TYPE", 75, 2764, 3061);
            CallChecker.varInit(this._safeMode, "_safeMode", 75, 2764, 3061);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 75, 2764, 3061);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 75, 2764, 3061);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 75, 2764, 3061);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 75, 2764, 3061);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 75, 2764, 3061);
            CallChecker.varInit(this._fileName, "_fileName", 75, 2764, 3061);
            CallChecker.varInit(this._layout, "_layout", 75, 2764, 3061);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 75, 2764, 3061);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 75, 2764, 3061);
            _rolloverWatcher = new RolloverWatcher(getFileName());
            CallChecker.varAssign(this._rolloverWatcher, "this._rolloverWatcher", 77, 2829, 2882);
            _rolledPolicyExecutor = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory(("RolledFileScanner-" + (getName()))));
            CallChecker.varAssign(this._rolledPolicyExecutor, "this._rolledPolicyExecutor", 78, 2892, 3017);
            super.postResolveChildren();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    @Override
    protected void validateChange(ConfiguredObject<?> proxyForValidation, Set<String> changedAttributes) {
        MethodContext _bcornu_methode_context18 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 3068, 3743);
            CallChecker.varInit(changedAttributes, "changedAttributes", 84, 3068, 3743);
            CallChecker.varInit(proxyForValidation, "proxyForValidation", 84, 3068, 3743);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 84, 3068, 3743);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 84, 3068, 3743);
            CallChecker.varInit(this.TYPE, "TYPE", 84, 3068, 3743);
            CallChecker.varInit(this._safeMode, "_safeMode", 84, 3068, 3743);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 84, 3068, 3743);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 84, 3068, 3743);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 84, 3068, 3743);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 84, 3068, 3743);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 84, 3068, 3743);
            CallChecker.varInit(this._fileName, "_fileName", 84, 3068, 3743);
            CallChecker.varInit(this._layout, "_layout", 84, 3068, 3743);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 84, 3068, 3743);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 84, 3068, 3743);
            super.validateChange(proxyForValidation, changedAttributes);
            VirtualHostFileLogger virtualHostFileLogger = CallChecker.varInit(((VirtualHostFileLogger) (proxyForValidation)), "virtualHostFileLogger", 87, 3266, 3354);
            if (CallChecker.beforeDeref(changedAttributes, Set.class, 88, 3368, 3384)) {
                if (CallChecker.beforeDeref(virtualHostFileLogger, VirtualHostFileLogger.class, 88, 3410, 3430)) {
                    changedAttributes = CallChecker.beforeCalled(changedAttributes, Set.class, 88, 3368, 3384);
                    virtualHostFileLogger = CallChecker.beforeCalled(virtualHostFileLogger, VirtualHostFileLogger.class, 88, 3410, 3430);
                    if ((CallChecker.isCalled(changedAttributes, Set.class, 88, 3368, 3384).contains(VirtualHostFileLogger.FILE_NAME)) && ((CallChecker.isCalled(virtualHostFileLogger, VirtualHostFileLogger.class, 88, 3410, 3430).getFileName()) != null)) {
                        if (CallChecker.beforeDeref(virtualHostFileLogger, VirtualHostFileLogger.class, 90, 3528, 3548)) {
                            virtualHostFileLogger = CallChecker.beforeCalled(virtualHostFileLogger, VirtualHostFileLogger.class, 90, 3528, 3548);
                            AppenderUtils.validateLogFilePermissions(new File(CallChecker.isCalled(virtualHostFileLogger, VirtualHostFileLogger.class, 90, 3528, 3548).getFileName()));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(changedAttributes, Set.class, 92, 3589, 3605)) {
                changedAttributes = CallChecker.beforeCalled(changedAttributes, Set.class, 92, 3589, 3605);
                if (CallChecker.isCalled(changedAttributes, Set.class, 92, 3589, 3605).contains(VirtualHostFileLogger.MAX_FILE_SIZE)) {
                    if (CallChecker.beforeDeref(virtualHostFileLogger, VirtualHostFileLogger.class, 94, 3688, 3708)) {
                        virtualHostFileLogger = CallChecker.beforeCalled(virtualHostFileLogger, VirtualHostFileLogger.class, 94, 3688, 3708);
                        AppenderUtils.validateMaxFileSize(CallChecker.isCalled(virtualHostFileLogger, VirtualHostFileLogger.class, 94, 3688, 3708).getMaxFileSize());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    @Override
    public String getFileName() {
        MethodContext _bcornu_methode_context19 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 99, 3750, 3828);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 99, 3750, 3828);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 99, 3750, 3828);
            CallChecker.varInit(this.TYPE, "TYPE", 99, 3750, 3828);
            CallChecker.varInit(this._safeMode, "_safeMode", 99, 3750, 3828);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 99, 3750, 3828);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 99, 3750, 3828);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 99, 3750, 3828);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 99, 3750, 3828);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 99, 3750, 3828);
            CallChecker.varInit(this._fileName, "_fileName", 99, 3750, 3828);
            CallChecker.varInit(this._layout, "_layout", 99, 3750, 3828);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 99, 3750, 3828);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 99, 3750, 3828);
            return _fileName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    @Override
    public boolean isRollDaily() {
        MethodContext _bcornu_methode_context20 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 105, 3835, 3915);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 105, 3835, 3915);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 105, 3835, 3915);
            CallChecker.varInit(this.TYPE, "TYPE", 105, 3835, 3915);
            CallChecker.varInit(this._safeMode, "_safeMode", 105, 3835, 3915);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 105, 3835, 3915);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 105, 3835, 3915);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 105, 3835, 3915);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 105, 3835, 3915);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 105, 3835, 3915);
            CallChecker.varInit(this._fileName, "_fileName", 105, 3835, 3915);
            CallChecker.varInit(this._layout, "_layout", 105, 3835, 3915);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 105, 3835, 3915);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 105, 3835, 3915);
            return _rollDaily;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    @Override
    public boolean isRollOnRestart() {
        MethodContext _bcornu_methode_context21 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 111, 3922, 4010);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 111, 3922, 4010);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 111, 3922, 4010);
            CallChecker.varInit(this.TYPE, "TYPE", 111, 3922, 4010);
            CallChecker.varInit(this._safeMode, "_safeMode", 111, 3922, 4010);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 111, 3922, 4010);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 111, 3922, 4010);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 111, 3922, 4010);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 111, 3922, 4010);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 111, 3922, 4010);
            CallChecker.varInit(this._fileName, "_fileName", 111, 3922, 4010);
            CallChecker.varInit(this._layout, "_layout", 111, 3922, 4010);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 111, 3922, 4010);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 111, 3922, 4010);
            return _rollOnRestart;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    @Override
    public boolean isCompressOldFiles() {
        MethodContext _bcornu_methode_context22 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 117, 4017, 4111);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 117, 4017, 4111);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 117, 4017, 4111);
            CallChecker.varInit(this.TYPE, "TYPE", 117, 4017, 4111);
            CallChecker.varInit(this._safeMode, "_safeMode", 117, 4017, 4111);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 117, 4017, 4111);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 117, 4017, 4111);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 117, 4017, 4111);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 117, 4017, 4111);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 117, 4017, 4111);
            CallChecker.varInit(this._fileName, "_fileName", 117, 4017, 4111);
            CallChecker.varInit(this._layout, "_layout", 117, 4017, 4111);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 117, 4017, 4111);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 117, 4017, 4111);
            return _compressOldFiles;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    @Override
    public int getMaxHistory() {
        MethodContext _bcornu_methode_context23 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 123, 4118, 4197);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 123, 4118, 4197);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 123, 4118, 4197);
            CallChecker.varInit(this.TYPE, "TYPE", 123, 4118, 4197);
            CallChecker.varInit(this._safeMode, "_safeMode", 123, 4118, 4197);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 123, 4118, 4197);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 123, 4118, 4197);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 123, 4118, 4197);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 123, 4118, 4197);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 123, 4118, 4197);
            CallChecker.varInit(this._fileName, "_fileName", 123, 4118, 4197);
            CallChecker.varInit(this._layout, "_layout", 123, 4118, 4197);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 123, 4118, 4197);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 123, 4118, 4197);
            return _maxHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    @Override
    public int getMaxFileSize() {
        MethodContext _bcornu_methode_context24 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 129, 4204, 4285);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 129, 4204, 4285);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 129, 4204, 4285);
            CallChecker.varInit(this.TYPE, "TYPE", 129, 4204, 4285);
            CallChecker.varInit(this._safeMode, "_safeMode", 129, 4204, 4285);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 129, 4204, 4285);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 129, 4204, 4285);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 129, 4204, 4285);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 129, 4204, 4285);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 129, 4204, 4285);
            CallChecker.varInit(this._fileName, "_fileName", 129, 4204, 4285);
            CallChecker.varInit(this._layout, "_layout", 129, 4204, 4285);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 129, 4204, 4285);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 129, 4204, 4285);
            return _maxFileSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    @Override
    public String getLayout() {
        MethodContext _bcornu_methode_context25 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 135, 4292, 4366);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 135, 4292, 4366);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 135, 4292, 4366);
            CallChecker.varInit(this.TYPE, "TYPE", 135, 4292, 4366);
            CallChecker.varInit(this._safeMode, "_safeMode", 135, 4292, 4366);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 135, 4292, 4366);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 135, 4292, 4366);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 135, 4292, 4366);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 135, 4292, 4366);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 135, 4292, 4366);
            CallChecker.varInit(this._fileName, "_fileName", 135, 4292, 4366);
            CallChecker.varInit(this._layout, "_layout", 135, 4292, 4366);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 135, 4292, 4366);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 135, 4292, 4366);
            return _layout;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    @Override
    public List<LogFileDetails> getLogFiles() {
        MethodContext _bcornu_methode_context26 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 141, 4373, 4561);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 141, 4373, 4561);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 141, 4373, 4561);
            CallChecker.varInit(this.TYPE, "TYPE", 141, 4373, 4561);
            CallChecker.varInit(this._safeMode, "_safeMode", 141, 4373, 4561);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 141, 4373, 4561);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 141, 4373, 4561);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 141, 4373, 4561);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 141, 4373, 4561);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 141, 4373, 4561);
            CallChecker.varInit(this._fileName, "_fileName", 141, 4373, 4561);
            CallChecker.varInit(this._layout, "_layout", 141, 4373, 4561);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 141, 4373, 4561);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 141, 4373, 4561);
            if ((_rolloverWatcher) == null) {
                return Collections.<LogFileDetails>emptyList();
            }else {
                return _rolloverWatcher.getLogFileDetails();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<LogFileDetails>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    @Override
    public Content getFile(final String fileName) {
        MethodContext _bcornu_methode_context27 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 147, 4568, 4901);
            CallChecker.varInit(fileName, "fileName", 147, 4568, 4901);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 147, 4568, 4901);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 147, 4568, 4901);
            CallChecker.varInit(this.TYPE, "TYPE", 147, 4568, 4901);
            CallChecker.varInit(this._safeMode, "_safeMode", 147, 4568, 4901);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 147, 4568, 4901);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 147, 4568, 4901);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 147, 4568, 4901);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 147, 4568, 4901);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 147, 4568, 4901);
            CallChecker.varInit(this._fileName, "_fileName", 147, 4568, 4901);
            CallChecker.varInit(this._layout, "_layout", 147, 4568, 4901);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 147, 4568, 4901);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 147, 4568, 4901);
            if (CallChecker.beforeDeref(getSecurityManager(), SecurityManager.class, 149, 4647, 4666)) {
                if (!(CallChecker.isCalled(getSecurityManager(), SecurityManager.class, 149, 4647, 4666).authoriseLogsAccess(this))) {
                    throw new AccessControlException("Permission denied to access log content");
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((_rolloverWatcher) == null) {
                return null;
            }else {
                return _rolloverWatcher.getFileContent(fileName);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    @Override
    public Content getFiles(@Param(name = "fileName")
    Set<String> fileName) {
        MethodContext _bcornu_methode_context28 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 158, 4908, 5276);
            CallChecker.varInit(fileName, "fileName", 158, 4908, 5276);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 158, 4908, 5276);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 158, 4908, 5276);
            CallChecker.varInit(this.TYPE, "TYPE", 158, 4908, 5276);
            CallChecker.varInit(this._safeMode, "_safeMode", 158, 4908, 5276);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 158, 4908, 5276);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 158, 4908, 5276);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 158, 4908, 5276);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 158, 4908, 5276);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 158, 4908, 5276);
            CallChecker.varInit(this._fileName, "_fileName", 158, 4908, 5276);
            CallChecker.varInit(this._layout, "_layout", 158, 4908, 5276);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 158, 4908, 5276);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 158, 4908, 5276);
            if (CallChecker.beforeDeref(getSecurityManager(), SecurityManager.class, 160, 5013, 5032)) {
                if (!(CallChecker.isCalled(getSecurityManager(), SecurityManager.class, 160, 5013, 5032).authoriseLogsAccess(this))) {
                    throw new AccessControlException("Permission denied to access log content");
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((_rolloverWatcher) == null) {
                return null;
            }else {
                return _rolloverWatcher.getFilesAsZippedContent(fileName);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    @Override
    public Content getAllFiles() {
        MethodContext _bcornu_methode_context29 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 170, 5284, 5604);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 170, 5284, 5604);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 170, 5284, 5604);
            CallChecker.varInit(this.TYPE, "TYPE", 170, 5284, 5604);
            CallChecker.varInit(this._safeMode, "_safeMode", 170, 5284, 5604);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 170, 5284, 5604);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 170, 5284, 5604);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 170, 5284, 5604);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 170, 5284, 5604);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 170, 5284, 5604);
            CallChecker.varInit(this._fileName, "_fileName", 170, 5284, 5604);
            CallChecker.varInit(this._layout, "_layout", 170, 5284, 5604);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 170, 5284, 5604);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 170, 5284, 5604);
            if (CallChecker.beforeDeref(getSecurityManager(), SecurityManager.class, 172, 5346, 5365)) {
                if (!(CallChecker.isCalled(getSecurityManager(), SecurityManager.class, 172, 5346, 5365).authoriseLogsAccess(this))) {
                    throw new AccessControlException("Permission denied to access log content");
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((_rolloverWatcher) == null) {
                return null;
            }else {
                return _rolloverWatcher.getAllFilesAsZippedContent();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    @Override
    public void stopLogging() {
        MethodContext _bcornu_methode_context30 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 181, 5611, 5732);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 181, 5611, 5732);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 181, 5611, 5732);
            CallChecker.varInit(this.TYPE, "TYPE", 181, 5611, 5732);
            CallChecker.varInit(this._safeMode, "_safeMode", 181, 5611, 5732);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 181, 5611, 5732);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 181, 5611, 5732);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 181, 5611, 5732);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 181, 5611, 5732);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 181, 5611, 5732);
            CallChecker.varInit(this._fileName, "_fileName", 181, 5611, 5732);
            CallChecker.varInit(this._layout, "_layout", 181, 5611, 5732);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 181, 5611, 5732);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 181, 5611, 5732);
            super.stopLogging();
            if (CallChecker.beforeDeref(_rolledPolicyExecutor, ScheduledExecutorService.class, 184, 5694, 5714)) {
                _rolledPolicyExecutor = CallChecker.beforeCalled(_rolledPolicyExecutor, ScheduledExecutorService.class, 184, 5694, 5714);
                CallChecker.isCalled(_rolledPolicyExecutor, ScheduledExecutorService.class, 184, 5694, 5714).shutdown();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    @Override
    public RollingPolicyDecorator.RolloverListener getRolloverListener() {
        MethodContext _bcornu_methode_context31 = new MethodContext(RollingPolicyDecorator.RolloverListener.class);
        try {
            CallChecker.varInit(this, "this", 188, 5739, 5865);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 188, 5739, 5865);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 188, 5739, 5865);
            CallChecker.varInit(this.TYPE, "TYPE", 188, 5739, 5865);
            CallChecker.varInit(this._safeMode, "_safeMode", 188, 5739, 5865);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 188, 5739, 5865);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 188, 5739, 5865);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 188, 5739, 5865);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 188, 5739, 5865);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 188, 5739, 5865);
            CallChecker.varInit(this._fileName, "_fileName", 188, 5739, 5865);
            CallChecker.varInit(this._layout, "_layout", 188, 5739, 5865);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 188, 5739, 5865);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 188, 5739, 5865);
            return _rolloverWatcher;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RollingPolicyDecorator.RolloverListener) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    @Override
    public ScheduledExecutorService getExecutorService() {
        MethodContext _bcornu_methode_context32 = new MethodContext(ScheduledExecutorService.class);
        try {
            CallChecker.varInit(this, "this", 194, 5872, 5987);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 194, 5872, 5987);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 194, 5872, 5987);
            CallChecker.varInit(this.TYPE, "TYPE", 194, 5872, 5987);
            CallChecker.varInit(this._safeMode, "_safeMode", 194, 5872, 5987);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 194, 5872, 5987);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 194, 5872, 5987);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 194, 5872, 5987);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 194, 5872, 5987);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 194, 5872, 5987);
            CallChecker.varInit(this._fileName, "_fileName", 194, 5872, 5987);
            CallChecker.varInit(this._layout, "_layout", 194, 5872, 5987);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 194, 5872, 5987);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 194, 5872, 5987);
            return _rolledPolicyExecutor;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ScheduledExecutorService) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context loggerContext) {
        MethodContext _bcornu_methode_context33 = new MethodContext(Appender.class);
        try {
            CallChecker.varInit(this, "this", 200, 5994, 6295);
            CallChecker.varInit(loggerContext, "loggerContext", 200, 5994, 6295);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 200, 5994, 6295);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 200, 5994, 6295);
            CallChecker.varInit(this.TYPE, "TYPE", 200, 5994, 6295);
            CallChecker.varInit(this._safeMode, "_safeMode", 200, 5994, 6295);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 200, 5994, 6295);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 200, 5994, 6295);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 200, 5994, 6295);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 200, 5994, 6295);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 200, 5994, 6295);
            CallChecker.varInit(this._fileName, "_fileName", 200, 5994, 6295);
            CallChecker.varInit(this._layout, "_layout", 200, 5994, 6295);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 200, 5994, 6295);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 200, 5994, 6295);
            final RollingFileAppender<ILoggingEvent> appender = CallChecker.varInit(new RollingFileAppender<>(), "appender", 202, 6102, 6181);
            AppenderUtils.configureRollingFileAppender(this, loggerContext, appender);
            return appender;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Appender<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }
}

