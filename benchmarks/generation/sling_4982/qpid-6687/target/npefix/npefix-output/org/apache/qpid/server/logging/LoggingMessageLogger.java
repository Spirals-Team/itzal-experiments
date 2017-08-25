package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMessageLogger extends AbstractMessageLogger {
    public LoggingMessageLogger() {
        super();
        MethodContext _bcornu_methode_context27 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public LoggingMessageLogger(boolean statusUpdatesEnabled) {
        super(statusUpdatesEnabled);
        MethodContext _bcornu_methode_context28 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    @Override
    public boolean isMessageEnabled(String logHierarchy) {
        MethodContext _bcornu_methode_context304 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 39, 1178, 1468);
            CallChecker.varInit(logHierarchy, "logHierarchy", 39, 1178, 1468);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 39, 1178, 1468);
            if (isEnabled()) {
                Logger logger = CallChecker.varInit(LoggerFactory.getLogger(logHierarchy), "logger", 43, 1297, 1350);
                if (CallChecker.beforeDeref(logger, Logger.class, 44, 1371, 1376)) {
                    logger = CallChecker.beforeCalled(logger, Logger.class, 44, 1371, 1376);
                    return CallChecker.isCalled(logger, Logger.class, 44, 1371, 1376).isInfoEnabled();
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                return false;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context304.methodEnd();
        }
    }

    @Override
    void rawMessage(String message, String logHierarchy) {
        MethodContext _bcornu_methode_context305 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 53, 1475, 1601);
            CallChecker.varInit(logHierarchy, "logHierarchy", 53, 1475, 1601);
            CallChecker.varInit(message, "message", 53, 1475, 1601);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 53, 1475, 1601);
            rawMessage(message, null, logHierarchy);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context305.methodEnd();
        }
    }

    @Override
    void rawMessage(String message, Throwable throwable, String logHierarchy) {
        MethodContext _bcornu_methode_context306 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 59, 1608, 1810);
            CallChecker.varInit(logHierarchy, "logHierarchy", 59, 1608, 1810);
            CallChecker.varInit(throwable, "throwable", 59, 1608, 1810);
            CallChecker.varInit(message, "message", 59, 1608, 1810);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 59, 1608, 1810);
            Logger logger = CallChecker.varInit(LoggerFactory.getLogger(logHierarchy), "logger", 61, 1710, 1763);
            if (CallChecker.beforeDeref(logger, Logger.class, 62, 1773, 1778)) {
                logger = CallChecker.beforeCalled(logger, Logger.class, 62, 1773, 1778);
                CallChecker.isCalled(logger, Logger.class, 62, 1773, 1778).info(message, throwable);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context306.methodEnd();
        }
    }
}

