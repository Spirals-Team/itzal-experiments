package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class EventLogger {
    private MessageLogger _messageLogger;

    public EventLogger() {
        this(new NullMessageLogger());
        MethodContext _bcornu_methode_context16 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public EventLogger(final MessageLogger messageLogger) {
        MethodContext _bcornu_methode_context17 = new MethodContext(null);
        try {
            _messageLogger = messageLogger;
            CallChecker.varAssign(this._messageLogger, "this._messageLogger", 34, 1074, 1104);
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public void message(LogSubject subject, LogMessage message) {
        MethodContext _bcornu_methode_context175 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 43, 1117, 1414);
            CallChecker.varInit(message, "message", 43, 1117, 1414);
            CallChecker.varInit(subject, "subject", 43, 1117, 1414);
            CallChecker.varInit(this._messageLogger, "_messageLogger", 43, 1117, 1414);
            if (CallChecker.beforeDeref(_messageLogger, MessageLogger.class, 45, 1368, 1381)) {
                _messageLogger = CallChecker.beforeCalled(_messageLogger, MessageLogger.class, 45, 1368, 1381);
                CallChecker.isCalled(_messageLogger, MessageLogger.class, 45, 1368, 1381).message(subject, message);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context175.methodEnd();
        }
    }

    public void message(LogMessage message) {
        MethodContext _bcornu_methode_context176 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 53, 1421, 1615);
            CallChecker.varInit(message, "message", 53, 1421, 1615);
            CallChecker.varInit(this._messageLogger, "_messageLogger", 53, 1421, 1615);
            if (CallChecker.beforeDeref(_messageLogger, MessageLogger.class, 55, 1576, 1589)) {
                _messageLogger = CallChecker.beforeCalled(_messageLogger, MessageLogger.class, 55, 1576, 1589);
                CallChecker.isCalled(_messageLogger, MessageLogger.class, 55, 1576, 1589).message(message);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context176.methodEnd();
        }
    }

    public void setMessageLogger(final MessageLogger messageLogger) {
        MethodContext _bcornu_methode_context177 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 58, 1622, 1736);
            CallChecker.varInit(messageLogger, "messageLogger", 58, 1622, 1736);
            CallChecker.varInit(this._messageLogger, "_messageLogger", 58, 1622, 1736);
            _messageLogger = messageLogger;
            CallChecker.varAssign(this._messageLogger, "this._messageLogger", 60, 1700, 1730);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context177.methodEnd();
        }
    }

    public MessageLogger getMessageLogger() {
        MethodContext _bcornu_methode_context178 = new MethodContext(MessageLogger.class);
        try {
            CallChecker.varInit(this, "this", 63, 1743, 1824);
            CallChecker.varInit(this._messageLogger, "_messageLogger", 63, 1743, 1824);
            return _messageLogger;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MessageLogger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context178.methodEnd();
        }
    }
}

