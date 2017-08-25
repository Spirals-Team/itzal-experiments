package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.PrintStream;

public class SystemOutMessageLogger extends AbstractMessageLogger {
    @Override
    public boolean isMessageEnabled(String logHierarchy) {
        MethodContext _bcornu_methode_context763 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 28, 929, 1027);
            CallChecker.varInit(logHierarchy, "logHierarchy", 28, 929, 1027);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 28, 929, 1027);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context763.methodEnd();
        }
    }

    public void rawMessage(String message, String logHierarchy) {
        MethodContext _bcornu_methode_context764 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 33, 1034, 1153);
            CallChecker.varInit(logHierarchy, "logHierarchy", 33, 1034, 1153);
            CallChecker.varInit(message, "message", 33, 1034, 1153);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 33, 1034, 1153);
            rawMessage(message, null, logHierarchy);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context764.methodEnd();
        }
    }

    public void rawMessage(String message, Throwable throwable, String logHierarchy) {
        MethodContext _bcornu_methode_context765 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 38, 1160, 1390);
            CallChecker.varInit(logHierarchy, "logHierarchy", 38, 1160, 1390);
            CallChecker.varInit(throwable, "throwable", 38, 1160, 1390);
            CallChecker.varInit(message, "message", 38, 1160, 1390);
            CallChecker.varInit(AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 38, 1160, 1390);
            if (CallChecker.beforeDeref(System.out, PrintStream.class, 40, 1255, 1264)) {
                CallChecker.isCalled(System.out, PrintStream.class, 40, 1255, 1264).println(message);
            }
            if (throwable != null) {
                throwable.printStackTrace(System.out);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context765.methodEnd();
        }
    }
}

