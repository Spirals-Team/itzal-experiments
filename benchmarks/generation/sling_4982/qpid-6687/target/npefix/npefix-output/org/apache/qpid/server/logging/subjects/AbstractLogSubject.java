package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.MessageFormat;
import org.apache.qpid.server.logging.LogSubject;

public abstract class AbstractLogSubject implements LogSubject {
    private String _logString;

    protected void setLogStringWithFormat(String format, Object... args) {
        MethodContext _bcornu_methode_context479 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 44, 1302, 1680);
            CallChecker.varInit(args, "args", 44, 1302, 1680);
            CallChecker.varInit(format, "format", 44, 1302, 1680);
            CallChecker.varInit(this._logString, "_logString", 44, 1302, 1680);
            _logString = ("[" + (MessageFormat.format(format, args))) + "] ";
            CallChecker.varAssign(this._logString, "this._logString", 46, 1614, 1674);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context479.methodEnd();
        }
    }

    public String toLogString() {
        MethodContext _bcornu_methode_context480 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 55, 1687, 1924);
            CallChecker.varInit(this._logString, "_logString", 55, 1687, 1924);
            return _logString;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context480.methodEnd();
        }
    }

    public String getLogString() {
        MethodContext _bcornu_methode_context481 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 63, 1931, 2072);
            CallChecker.varInit(this._logString, "_logString", 63, 1931, 2072);
            return _logString;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context481.methodEnd();
        }
    }

    public void setLogString(String logString) {
        MethodContext _bcornu_methode_context482 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 68, 2079, 2164);
            CallChecker.varInit(logString, "logString", 68, 2079, 2164);
            CallChecker.varInit(this._logString, "_logString", 68, 2079, 2164);
            _logString = logString;
            CallChecker.varAssign(this._logString, "this._logString", 70, 2136, 2158);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context482.methodEnd();
        }
    }
}

