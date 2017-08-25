package org.apache.qpid.server.logging;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.RollingPolicyBase;
import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP;
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicyBase;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.rolling.TriggeringPolicy;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import org.apache.qpid.server.configuration.IllegalConfigurationException;
import org.apache.qpid.server.logging.logback.RollingPolicyDecorator;

public class AppenderUtils {
    static class DailyTriggeringPolicy extends SizeAndTimeBasedFNATP<ILoggingEvent> {
        private final boolean _rollOnRestart;

        private boolean _isFirst = true;

        public DailyTriggeringPolicy(boolean isRollOnRestart, String maxFileSize) {
            MethodContext _bcornu_methode_context46 = new MethodContext(null);
            try {
                _rollOnRestart = isRollOnRestart;
                CallChecker.varAssign(this._rollOnRestart, "this._rollOnRestart", 121, 5471, 5503);
                setMaxFileSize(maxFileSize);
            } finally {
                _bcornu_methode_context46.methodEnd();
            }
        }

        @Override
        protected void computeNextCheck() {
            MethodContext _bcornu_methode_context721 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 126, 5565, 5811);
                CallChecker.varInit(this._isFirst, "_isFirst", 126, 5565, 5811);
                CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 126, 5565, 5811);
                super.computeNextCheck();
                if ((_rollOnRestart) && (_isFirst)) {
                    _isFirst = false;
                    CallChecker.varAssign(this._isFirst, "this._isFirst", 131, 5739, 5755);
                    nextCheck = 0L;
                    CallChecker.varAssign(this.nextCheck, "this.nextCheck", 132, 5773, 5787);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context721.methodEnd();
            }
        }

        @Override
        public boolean isTriggeringEvent(final File activeFile, final ILoggingEvent event) {
            MethodContext _bcornu_methode_context722 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 137, 5822, 6232);
                CallChecker.varInit(event, "event", 137, 5822, 6232);
                CallChecker.varInit(activeFile, "activeFile", 137, 5822, 6232);
                CallChecker.varInit(this._isFirst, "_isFirst", 137, 5822, 6232);
                CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 137, 5822, 6232);
                if ((_rollOnRestart) && (_isFirst)) {
                    _isFirst = false;
                    CallChecker.varAssign(this._isFirst, "this._isFirst", 141, 6007, 6023);
                    return (CallChecker.isCalled(activeFile, File.class, 142, 6048, 6057).exists()) && ((CallChecker.isCalled(activeFile, File.class, 142, 6071, 6080).length()) != 0L);
                }else {
                    return super.isTriggeringEvent(activeFile, event);
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context722.methodEnd();
            }
        }
    }

    static class SizeTriggeringPolicy extends SizeBasedTriggeringPolicy<ILoggingEvent> {
        private final boolean _rollOnRestart;

        private boolean _isFirst = true;

        public SizeTriggeringPolicy(boolean isRollOnRestart, String maxFileSize) {
            MethodContext _bcornu_methode_context47 = new MethodContext(null);
            try {
                _rollOnRestart = isRollOnRestart;
                CallChecker.varAssign(this._rollOnRestart, "this._rollOnRestart", 159, 6526, 6558);
                setMaxFileSize(maxFileSize);
            } finally {
                _bcornu_methode_context47.methodEnd();
            }
        }

        @Override
        public boolean isTriggeringEvent(final File activeFile, final ILoggingEvent event) {
            MethodContext _bcornu_methode_context723 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 165, 6621, 7031);
                CallChecker.varInit(event, "event", 165, 6621, 7031);
                CallChecker.varInit(activeFile, "activeFile", 165, 6621, 7031);
                CallChecker.varInit(this._isFirst, "_isFirst", 165, 6621, 7031);
                CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 165, 6621, 7031);
                if ((_rollOnRestart) && (_isFirst)) {
                    _isFirst = false;
                    CallChecker.varAssign(this._isFirst, "this._isFirst", 169, 6806, 6822);
                    return (CallChecker.isCalled(activeFile, File.class, 170, 6847, 6856).exists()) && ((CallChecker.isCalled(activeFile, File.class, 170, 6870, 6879).length()) != 0L);
                }else {
                    return super.isTriggeringEvent(activeFile, event);
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context723.methodEnd();
            }
        }
    }

    static class SimpleRollingPolicy extends FixedWindowRollingPolicy {
        private int _maxFiles;

        public SimpleRollingPolicy(int maxHistory) {
            MethodContext _bcornu_methode_context48 = new MethodContext(null);
            try {
                _maxFiles = maxHistory;
                CallChecker.varAssign(this._maxFiles, "this._maxFiles", 186, 7222, 7244);
                setMaxIndex(maxHistory);
                setMinIndex(1);
            } finally {
                _bcornu_methode_context48.methodEnd();
            }
        }

        @Override
        protected int getMaxWindowSize() {
            MethodContext _bcornu_methode_context724 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 192, 7330, 7429);
                CallChecker.varInit(this._maxFiles, "_maxFiles", 192, 7330, 7429);
                return _maxFiles;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context724.methodEnd();
            }
        }
    }

    public static void configureRollingFileAppender(FileLoggerSettings fileLoggerSettings, Context loggerContext, RollingFileAppender<ILoggingEvent> appender) {
        MethodContext _bcornu_methode_context725 = new MethodContext(void.class);
        try {
            CallChecker.varInit(appender, "appender", 40, 1604, 4583);
            CallChecker.varInit(loggerContext, "loggerContext", 40, 1604, 4583);
            CallChecker.varInit(fileLoggerSettings, "fileLoggerSettings", 40, 1604, 4583);
            String fileName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 44, 1895, 1912)) {
                fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 44, 1895, 1912);
                fileName = CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 44, 1895, 1912).getFileName();
                CallChecker.varAssign(fileName, "fileName", 44, 1895, 1912);
            }
            File file = CallChecker.varInit(new File(fileName), "file", 45, 1937, 1967);
            if (CallChecker.beforeDeref(file, File.class, 46, 1981, 1984)) {
                file = CallChecker.beforeCalled(file, File.class, 46, 1981, 1984);
                if ((CallChecker.isCalled(file, File.class, 46, 1981, 1984).getParentFile()) != null) {
                    if (CallChecker.beforeDeref(file, File.class, 48, 2033, 2036)) {
                        file = CallChecker.beforeCalled(file, File.class, 48, 2033, 2036);
                        CallChecker.isCalled(file, File.class, 48, 2033, 2036).getParentFile().mkdirs();
                    }
                }
            }
            AppenderUtils.validateLogFilePermissions(file);
            if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 51, 2144, 2161)) {
                fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 51, 2144, 2161);
                AppenderUtils.validateMaxFileSize(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 51, 2144, 2161).getMaxFileSize());
            }
            if (CallChecker.beforeDeref(appender, RollingFileAppender.class, 53, 2191, 2198)) {
                appender = CallChecker.beforeCalled(appender, RollingFileAppender.class, 53, 2191, 2198);
                CallChecker.isCalled(appender, RollingFileAppender.class, 53, 2191, 2198).setFile(fileName);
            }
            if (CallChecker.beforeDeref(appender, RollingFileAppender.class, 54, 2227, 2234)) {
                appender = CallChecker.beforeCalled(appender, RollingFileAppender.class, 54, 2227, 2234);
                CallChecker.isCalled(appender, RollingFileAppender.class, 54, 2227, 2234).setAppend(true);
            }
            if (CallChecker.beforeDeref(appender, RollingFileAppender.class, 55, 2261, 2268)) {
                appender = CallChecker.beforeCalled(appender, RollingFileAppender.class, 55, 2261, 2268);
                CallChecker.isCalled(appender, RollingFileAppender.class, 55, 2261, 2268).setContext(loggerContext);
            }
            TriggeringPolicy triggeringPolicy = CallChecker.init(TriggeringPolicy.class);
            RollingPolicyBase rollingPolicy = CallChecker.init(RollingPolicyBase.class);
            fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 59, 2440, 2457);
            final String maxFileSizeAsString = CallChecker.varInit(((String.valueOf(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 59, 2440, 2457).getMaxFileSize())) + "MB"), "maxFileSizeAsString", 59, 2390, 2483);
            if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 60, 2496, 2513)) {
                fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 60, 2496, 2513);
                if (CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 60, 2496, 2513).isRollDaily()) {
                    AppenderUtils.DailyTriggeringPolicy dailyTriggeringPolicy = CallChecker.init(AppenderUtils.DailyTriggeringPolicy.class);
                    if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 62, 2624, 2641)) {
                        fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 62, 2624, 2641);
                        dailyTriggeringPolicy = new AppenderUtils.DailyTriggeringPolicy(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 62, 2624, 2641).isRollOnRestart(), maxFileSizeAsString);
                        CallChecker.varAssign(dailyTriggeringPolicy, "dailyTriggeringPolicy", 62, 2624, 2641);
                    }
                    if (CallChecker.beforeDeref(dailyTriggeringPolicy, AppenderUtils.DailyTriggeringPolicy.class, 63, 2696, 2716)) {
                        dailyTriggeringPolicy = CallChecker.beforeCalled(dailyTriggeringPolicy, AppenderUtils.DailyTriggeringPolicy.class, 63, 2696, 2716);
                        CallChecker.isCalled(dailyTriggeringPolicy, AppenderUtils.DailyTriggeringPolicy.class, 63, 2696, 2716).setContext(loggerContext);
                    }
                    TimeBasedRollingPolicy<ILoggingEvent> timeBasedRollingPolicy = CallChecker.varInit(new TimeBasedRollingPolicy<>(), "timeBasedRollingPolicy", 64, 2757, 2850);
                    if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 65, 2901, 2918)) {
                        if (CallChecker.beforeDeref(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 65, 2864, 2885)) {
                            fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 65, 2901, 2918);
                            timeBasedRollingPolicy = CallChecker.beforeCalled(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 65, 2864, 2885);
                            CallChecker.isCalled(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 65, 2864, 2885).setMaxHistory(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 65, 2901, 2918).getMaxHistory());
                        }
                    }
                    if (CallChecker.beforeDeref(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 66, 2950, 2971)) {
                        timeBasedRollingPolicy = CallChecker.beforeCalled(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 66, 2950, 2971);
                        CallChecker.isCalled(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 66, 2950, 2971).setTimeBasedFileNamingAndTriggeringPolicy(dailyTriggeringPolicy);
                    }
                    fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 67, 3128, 3145);
                    if ((!(CallChecker.isCalled(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 67, 3128, 3145), FileLoggerSettings.class, 67, 3128, 3166).isCompressOldFiles())) || (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 67, 3128, 3145))) {
                        if (CallChecker.beforeDeref(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 67, 3051, 3072)) {
                            timeBasedRollingPolicy = CallChecker.beforeCalled(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 67, 3051, 3072);
                            CallChecker.isCalled(timeBasedRollingPolicy, TimeBasedRollingPolicy.class, 67, 3051, 3072).setFileNamePattern(((fileName + ".%d{yyyy-MM-dd}.%i") + ((CallChecker.isCalled(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 67, 3128, 3145), FileLoggerSettings.class, 67, 3128, 3166).isCompressOldFiles()) ? ".gz" : "")));
                        }
                    }
                    rollingPolicy = timeBasedRollingPolicy;
                    CallChecker.varAssign(rollingPolicy, "rollingPolicy", 70, 3236, 3274);
                    triggeringPolicy = dailyTriggeringPolicy;
                    CallChecker.varAssign(triggeringPolicy, "triggeringPolicy", 71, 3288, 3328);
                }else {
                    AppenderUtils.SizeTriggeringPolicy sizeTriggeringPolicy = CallChecker.init(AppenderUtils.SizeTriggeringPolicy.class);
                    if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 75, 3444, 3461)) {
                        fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 75, 3444, 3461);
                        sizeTriggeringPolicy = new AppenderUtils.SizeTriggeringPolicy(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 75, 3444, 3461).isRollOnRestart(), maxFileSizeAsString);
                        CallChecker.varAssign(sizeTriggeringPolicy, "sizeTriggeringPolicy", 75, 3444, 3461);
                    }
                    if (CallChecker.beforeDeref(sizeTriggeringPolicy, AppenderUtils.SizeTriggeringPolicy.class, 76, 3516, 3535)) {
                        sizeTriggeringPolicy = CallChecker.beforeCalled(sizeTriggeringPolicy, AppenderUtils.SizeTriggeringPolicy.class, 76, 3516, 3535);
                        CallChecker.isCalled(sizeTriggeringPolicy, AppenderUtils.SizeTriggeringPolicy.class, 76, 3516, 3535).setContext(loggerContext);
                    }
                    AppenderUtils.SimpleRollingPolicy simpleRollingPolicy = CallChecker.init(AppenderUtils.SimpleRollingPolicy.class);
                    if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 77, 3642, 3659)) {
                        fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 77, 3642, 3659);
                        simpleRollingPolicy = new AppenderUtils.SimpleRollingPolicy(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 77, 3642, 3659).getMaxHistory());
                        CallChecker.varAssign(simpleRollingPolicy, "simpleRollingPolicy", 77, 3642, 3659);
                    }
                    fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 78, 3750, 3767);
                    if ((!(CallChecker.isCalled(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 78, 3750, 3767), FileLoggerSettings.class, 78, 3750, 3788).isCompressOldFiles())) || (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 78, 3750, 3767))) {
                        if (CallChecker.beforeDeref(simpleRollingPolicy, AppenderUtils.SimpleRollingPolicy.class, 78, 3691, 3709)) {
                            simpleRollingPolicy = CallChecker.beforeCalled(simpleRollingPolicy, AppenderUtils.SimpleRollingPolicy.class, 78, 3691, 3709);
                            CallChecker.isCalled(simpleRollingPolicy, AppenderUtils.SimpleRollingPolicy.class, 78, 3691, 3709).setFileNamePattern(((fileName + ".%i") + ((CallChecker.isCalled(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 78, 3750, 3767), FileLoggerSettings.class, 78, 3750, 3788).isCompressOldFiles()) ? ".gz" : "")));
                        }
                    }
                    rollingPolicy = simpleRollingPolicy;
                    CallChecker.varAssign(rollingPolicy, "rollingPolicy", 79, 3818, 3853);
                    triggeringPolicy = sizeTriggeringPolicy;
                    CallChecker.varAssign(triggeringPolicy, "triggeringPolicy", 80, 3867, 3906);
                }
            }
            if (CallChecker.beforeDeref(rollingPolicy, RollingPolicyBase.class, 83, 3927, 3939)) {
                rollingPolicy = CallChecker.beforeCalled(rollingPolicy, RollingPolicyBase.class, 83, 3927, 3939);
                CallChecker.isCalled(rollingPolicy, RollingPolicyBase.class, 83, 3927, 3939).setContext(loggerContext);
            }
            RollingPolicyDecorator decorator = CallChecker.init(RollingPolicyDecorator.class);
            if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 84, 4053, 4070)) {
                if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 84, 4095, 4112)) {
                    fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 84, 4053, 4070);
                    fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 84, 4095, 4112);
                    decorator = new RollingPolicyDecorator(rollingPolicy, CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 84, 4053, 4070).getRolloverListener(), CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 84, 4095, 4112).getExecutorService());
                    CallChecker.varAssign(decorator, "decorator", 84, 4053, 4070);
                }
            }
            if (CallChecker.beforeDeref(decorator, RollingPolicyDecorator.class, 85, 4145, 4153)) {
                decorator = CallChecker.beforeCalled(decorator, RollingPolicyDecorator.class, 85, 4145, 4153);
                CallChecker.isCalled(decorator, RollingPolicyDecorator.class, 85, 4145, 4153).setParent(appender);
            }
            if (CallChecker.beforeDeref(appender, RollingFileAppender.class, 86, 4184, 4191)) {
                appender = CallChecker.beforeCalled(appender, RollingFileAppender.class, 86, 4184, 4191);
                CallChecker.isCalled(appender, RollingFileAppender.class, 86, 4184, 4191).setRollingPolicy(decorator);
            }
            if (CallChecker.beforeDeref(appender, RollingFileAppender.class, 87, 4230, 4237)) {
                appender = CallChecker.beforeCalled(appender, RollingFileAppender.class, 87, 4230, 4237);
                CallChecker.isCalled(appender, RollingFileAppender.class, 87, 4230, 4237).setTriggeringPolicy(triggeringPolicy);
            }
            if (CallChecker.beforeDeref(decorator, RollingPolicyDecorator.class, 88, 4286, 4294)) {
                decorator = CallChecker.beforeCalled(decorator, RollingPolicyDecorator.class, 88, 4286, 4294);
                CallChecker.isCalled(decorator, RollingPolicyDecorator.class, 88, 4286, 4294).start();
            }
            if (CallChecker.beforeDeref(triggeringPolicy, TriggeringPolicy.class, 89, 4313, 4328)) {
                triggeringPolicy = CallChecker.beforeCalled(triggeringPolicy, TriggeringPolicy.class, 89, 4313, 4328);
                CallChecker.isCalled(triggeringPolicy, TriggeringPolicy.class, 89, 4313, 4328).start();
            }
            final PatternLayoutEncoder encoder = CallChecker.varInit(new PatternLayoutEncoder(), "encoder", 91, 4348, 4411);
            if (CallChecker.beforeDeref(fileLoggerSettings, FileLoggerSettings.class, 92, 4440, 4457)) {
                if (CallChecker.beforeDeref(encoder, PatternLayoutEncoder.class, 92, 4421, 4427)) {
                    fileLoggerSettings = CallChecker.beforeCalled(fileLoggerSettings, FileLoggerSettings.class, 92, 4440, 4457);
                    CallChecker.isCalled(encoder, PatternLayoutEncoder.class, 92, 4421, 4427).setPattern(CallChecker.isCalled(fileLoggerSettings, FileLoggerSettings.class, 92, 4440, 4457).getLayout());
                }
            }
            if (CallChecker.beforeDeref(encoder, PatternLayoutEncoder.class, 93, 4481, 4487)) {
                CallChecker.isCalled(encoder, PatternLayoutEncoder.class, 93, 4481, 4487).setContext(loggerContext);
            }
            if (CallChecker.beforeDeref(encoder, PatternLayoutEncoder.class, 94, 4524, 4530)) {
                CallChecker.isCalled(encoder, PatternLayoutEncoder.class, 94, 4524, 4530).start();
            }
            if (CallChecker.beforeDeref(appender, RollingFileAppender.class, 95, 4549, 4556)) {
                appender = CallChecker.beforeCalled(appender, RollingFileAppender.class, 95, 4549, 4556);
                CallChecker.isCalled(appender, RollingFileAppender.class, 95, 4549, 4556).setEncoder(encoder);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context725.methodEnd();
        }
    }

    static void validateLogFilePermissions(final File file) {
        MethodContext _bcornu_methode_context726 = new MethodContext(void.class);
        try {
            CallChecker.varInit(file, "file", 98, 4590, 4925);
            if (CallChecker.beforeDeref(file, File.class, 100, 4665, 4668)) {
                if (CallChecker.beforeDeref(file, File.class, 100, 4684, 4687)) {
                    if (CallChecker.beforeDeref(file, File.class, 100, 4702, 4705)) {
                        if (CallChecker.beforeDeref(file, File.class, 100, 4724, 4727)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(file, File.class, 100, 4724, 4727).getParentFile(), File.class, 100, 4724, 4743)) {
                                if (((CallChecker.isCalled(file, File.class, 100, 4665, 4668).exists()) && ((!(CallChecker.isCalled(file, File.class, 100, 4684, 4687).isFile())) || (!(CallChecker.isCalled(file, File.class, 100, 4702, 4705).canWrite())))) || (!(CallChecker.isCalled(CallChecker.isCalled(file, File.class, 100, 4724, 4727).getParentFile(), File.class, 100, 4724, 4743).canWrite()))) {
                                    if (CallChecker.beforeDeref(file, File.class, 102, 4885, 4888)) {
                                        throw new IllegalConfigurationException(String.format("Do not have the permissions to log to file '%s'.", CallChecker.isCalled(file, File.class, 102, 4885, 4888).getAbsolutePath()));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context726.methodEnd();
        }
    }

    static void validateMaxFileSize(final int maxFileSize) {
        MethodContext _bcornu_methode_context727 = new MethodContext(void.class);
        try {
            CallChecker.varInit(maxFileSize, "maxFileSize", 106, 4932, 5186);
            if (maxFileSize < 1) {
                throw new IllegalConfigurationException(String.format("Maximum file size must be at least 1. Cannot set to %d.", maxFileSize));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context727.methodEnd();
        }
    }
}

