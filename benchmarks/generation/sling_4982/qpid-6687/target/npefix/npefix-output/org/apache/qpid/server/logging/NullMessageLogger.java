package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class NullMessageLogger extends AbstractMessageLogger {
    @Override
    public boolean isMessageEnabled(String logHierarchy) {
        MethodContext _bcornu_methode_context68 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 27, 923, 1022);
            CallChecker.varInit(logHierarchy, "logHierarchy", 27, 923, 1022);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 27, 923, 1022);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    public void rawMessage(String message, String logHierarchy) {
        MethodContext _bcornu_methode_context69 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 32, 1029, 1123);
            CallChecker.varInit(logHierarchy, "logHierarchy", 32, 1029, 1123);
            CallChecker.varInit(message, "message", 32, 1029, 1123);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 32, 1029, 1123);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public void rawMessage(String message, Throwable throwable, String logHierarchy) {
        MethodContext _bcornu_methode_context70 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 37, 1130, 1245);
            CallChecker.varInit(logHierarchy, "logHierarchy", 37, 1130, 1245);
            CallChecker.varInit(throwable, "throwable", 37, 1130, 1245);
            CallChecker.varInit(message, "message", 37, 1130, 1245);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 37, 1130, 1245);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }
}

