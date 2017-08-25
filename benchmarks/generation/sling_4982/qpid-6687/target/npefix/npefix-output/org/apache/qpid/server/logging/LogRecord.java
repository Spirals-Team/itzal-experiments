package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.qpid.server.model.ManagedAttributeValueType;

@ManagedAttributeValueType
public class LogRecord {
    private final ILoggingEvent _event;

    private final long _id;

    public LogRecord(long id, ILoggingEvent event) {
        MethodContext _bcornu_methode_context21 = new MethodContext(null);
        try {
            _id = id;
            CallChecker.varAssign(this._id, "this._id", 34, 1154, 1162);
            _event = event;
            CallChecker.varAssign(this._event, "this._event", 35, 1172, 1186);
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public long getId() {
        MethodContext _bcornu_methode_context201 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 38, 1199, 1249);
            CallChecker.varInit(this._id, "_id", 38, 1199, 1249);
            CallChecker.varInit(this._event, "_event", 38, 1199, 1249);
            return _id;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context201.methodEnd();
        }
    }

    public long getTimestamp() {
        MethodContext _bcornu_methode_context202 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 43, 1256, 1331);
            CallChecker.varInit(this._id, "_id", 43, 1256, 1331);
            CallChecker.varInit(this._event, "_event", 43, 1256, 1331);
            if (CallChecker.beforeDeref(_event, ILoggingEvent.class, 45, 1304, 1309)) {
                return CallChecker.isCalled(_event, ILoggingEvent.class, 45, 1304, 1309).getTimeStamp();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context202.methodEnd();
        }
    }

    public String getThreadName() {
        MethodContext _bcornu_methode_context203 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 48, 1338, 1417);
            CallChecker.varInit(this._id, "_id", 48, 1338, 1417);
            CallChecker.varInit(this._event, "_event", 48, 1338, 1417);
            if (CallChecker.beforeDeref(_event, ILoggingEvent.class, 50, 1389, 1394)) {
                return CallChecker.isCalled(_event, ILoggingEvent.class, 50, 1389, 1394).getThreadName();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context203.methodEnd();
        }
    }

    public String getLevel() {
        MethodContext _bcornu_methode_context204 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 53, 1424, 1504);
            CallChecker.varInit(this._id, "_id", 53, 1424, 1504);
            CallChecker.varInit(this._event, "_event", 53, 1424, 1504);
            if (CallChecker.beforeDeref(_event, ILoggingEvent.class, 55, 1470, 1475)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(_event, ILoggingEvent.class, 55, 1470, 1475).getLevel(), Level.class, 55, 1470, 1486)) {
                    return CallChecker.isCalled(CallChecker.isCalled(_event, ILoggingEvent.class, 55, 1470, 1475).getLevel(), Level.class, 55, 1470, 1486).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context204.methodEnd();
        }
    }

    public String getMessage() {
        MethodContext _bcornu_methode_context205 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 58, 1511, 1593);
            CallChecker.varInit(this._id, "_id", 58, 1511, 1593);
            CallChecker.varInit(this._event, "_event", 58, 1511, 1593);
            if (CallChecker.beforeDeref(_event, ILoggingEvent.class, 60, 1559, 1564)) {
                return CallChecker.isCalled(_event, ILoggingEvent.class, 60, 1559, 1564).getFormattedMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context205.methodEnd();
        }
    }

    public String getLogger() {
        MethodContext _bcornu_methode_context206 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 63, 1600, 1675);
            CallChecker.varInit(this._id, "_id", 63, 1600, 1675);
            CallChecker.varInit(this._event, "_event", 63, 1600, 1675);
            if (CallChecker.beforeDeref(_event, ILoggingEvent.class, 65, 1647, 1652)) {
                return CallChecker.isCalled(_event, ILoggingEvent.class, 65, 1647, 1652).getLoggerName();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context206.methodEnd();
        }
    }
}

