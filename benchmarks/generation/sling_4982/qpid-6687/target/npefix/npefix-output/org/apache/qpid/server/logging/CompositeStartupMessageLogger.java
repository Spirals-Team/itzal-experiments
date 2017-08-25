package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class CompositeStartupMessageLogger implements MessageLogger {
    private MessageLogger[] _loggers;

    public CompositeStartupMessageLogger(MessageLogger[] loggers) {
        super();
        MethodContext _bcornu_methode_context39 = new MethodContext(null);
        try {
            _loggers = loggers;
            CallChecker.varAssign(this._loggers, "this._loggers", 30, 1065, 1083);
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    @Override
    public boolean isEnabled() {
        MethodContext _bcornu_methode_context630 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 35, 1097, 1317);
            CallChecker.varInit(this._loggers, "_loggers", 35, 1097, 1317);
            if (CallChecker.beforeDeref(_loggers, boolean.class, 37, 1174, 1181)) {
                for (MessageLogger l : _loggers) {
                    if (CallChecker.beforeDeref(l, MessageLogger.class, 39, 1209, 1209)) {
                        if (CallChecker.isCalled(l, MessageLogger.class, 39, 1209, 1209).isEnabled()) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context630.methodEnd();
        }
    }

    @Override
    public boolean isMessageEnabled(final String logHierarchy) {
        MethodContext _bcornu_methode_context631 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 48, 1324, 1595);
            CallChecker.varInit(logHierarchy, "logHierarchy", 48, 1324, 1595);
            CallChecker.varInit(this._loggers, "_loggers", 48, 1324, 1595);
            if (CallChecker.beforeDeref(_loggers, boolean.class, 50, 1433, 1440)) {
                for (MessageLogger l : _loggers) {
                    if (CallChecker.beforeDeref(l, MessageLogger.class, 52, 1468, 1468)) {
                        if (CallChecker.isCalled(l, MessageLogger.class, 52, 1468, 1468).isMessageEnabled(logHierarchy)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context631.methodEnd();
        }
    }

    @Override
    public void message(final LogMessage message) {
        MethodContext _bcornu_methode_context632 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 61, 1602, 1764);
            CallChecker.varInit(message, "message", 61, 1602, 1764);
            CallChecker.varInit(this._loggers, "_loggers", 61, 1602, 1764);
            if (CallChecker.beforeDeref(_loggers, void.class, 63, 1698, 1705)) {
                for (MessageLogger l : _loggers) {
                    if (CallChecker.beforeDeref(l, MessageLogger.class, 65, 1730, 1730)) {
                        CallChecker.isCalled(l, MessageLogger.class, 65, 1730, 1730).message(message);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context632.methodEnd();
        }
    }

    @Override
    public void message(final LogSubject subject, final LogMessage message) {
        MethodContext _bcornu_methode_context633 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 70, 1771, 1968);
            CallChecker.varInit(message, "message", 70, 1771, 1968);
            CallChecker.varInit(subject, "subject", 70, 1771, 1968);
            CallChecker.varInit(this._loggers, "_loggers", 70, 1771, 1968);
            if (CallChecker.beforeDeref(_loggers, void.class, 72, 1893, 1900)) {
                for (MessageLogger l : _loggers) {
                    if (CallChecker.beforeDeref(l, MessageLogger.class, 74, 1925, 1925)) {
                        CallChecker.isCalled(l, MessageLogger.class, 74, 1925, 1925).message(subject, message);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context633.methodEnd();
        }
    }
}

