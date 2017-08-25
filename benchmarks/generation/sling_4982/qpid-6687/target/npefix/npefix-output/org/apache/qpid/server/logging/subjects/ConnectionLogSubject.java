package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.MessageFormat;
import org.apache.qpid.server.transport.AMQPConnection;

public class ConnectionLogSubject extends AbstractLogSubject {
    private AMQPConnection<?> _connection;

    private boolean _upToDate = false;

    public ConnectionLogSubject(AMQPConnection<?> connection) {
        MethodContext _bcornu_methode_context1 = new MethodContext(null);
        try {
            _connection = connection;
            CallChecker.varAssign(this._connection, "this._connection", 40, 1478, 1502);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    private void updateLogString() {
        MethodContext _bcornu_methode_context1 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 55, 1633, 4115);
            CallChecker.varInit(this._upToDate, "_upToDate", 55, 1633, 4115);
            CallChecker.varInit(this._connection, "_connection", 55, 1633, 4115);
            if (!(_upToDate)) {
                if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 59, 2076, 2086)) {
                    _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 59, 2076, 2086);
                    if ((CallChecker.isCalled(_connection, AMQPConnection.class, 59, 2076, 2086).getAuthorizedPrincipal()) != null) {
                        if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 61, 2156, 2166)) {
                            _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 61, 2156, 2166);
                            if ((CallChecker.isCalled(_connection, AMQPConnection.class, 61, 2156, 2166).getVirtualHostName()) != null) {
                                if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 74, 2836, 2846)) {
                                    if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 75, 2927, 2937)) {
                                        if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 76, 3035, 3045)) {
                                            if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 77, 3133, 3143)) {
                                                _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 74, 2836, 2846);
                                                _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 75, 2927, 2937);
                                                _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 76, 3035, 3045);
                                                _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 77, 3133, 3143);
                                                setLogString((("[" + (MessageFormat.format(LogSubjectFormat.CONNECTION_FORMAT, CallChecker.isCalled(_connection, AMQPConnection.class, 74, 2836, 2846).getConnectionId(), CallChecker.isCalled(_connection, AMQPConnection.class, 75, 2927, 2937).getAuthorizedPrincipal().getName(), CallChecker.isCalled(_connection, AMQPConnection.class, 76, 3035, 3045).getRemoteAddressString(), CallChecker.isCalled(_connection, AMQPConnection.class, 77, 3133, 3143).getVirtualHostName()))) + "] "));
                                            }
                                        }
                                    }
                                }
                                _upToDate = true;
                                CallChecker.varAssign(this._upToDate, "this._upToDate", 80, 3230, 3246);
                            }else {
                                if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 85, 3438, 3448)) {
                                    if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 86, 3529, 3539)) {
                                        if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 87, 3637, 3647)) {
                                            _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 85, 3438, 3448);
                                            _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 86, 3529, 3539);
                                            _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 87, 3637, 3647);
                                            setLogString((("[" + (MessageFormat.format(LogSubjectFormat.USER_FORMAT, CallChecker.isCalled(_connection, AMQPConnection.class, 85, 3438, 3448).getConnectionId(), CallChecker.isCalled(_connection, AMQPConnection.class, 86, 3529, 3539).getAuthorizedPrincipal().getName(), CallChecker.isCalled(_connection, AMQPConnection.class, 87, 3637, 3647).getRemoteAddressString()))) + "] "));
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 95, 3916, 3926)) {
                            if (CallChecker.beforeDeref(_connection, AMQPConnection.class, 96, 4007, 4017)) {
                                _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 95, 3916, 3926);
                                _connection = CallChecker.beforeCalled(_connection, AMQPConnection.class, 96, 4007, 4017);
                                setLogString((("[" + (MessageFormat.format(LogSubjectFormat.SOCKET_FORMAT, CallChecker.isCalled(_connection, AMQPConnection.class, 95, 3916, 3926).getConnectionId(), CallChecker.isCalled(_connection, AMQPConnection.class, 96, 4007, 4017).getRemoteAddressString()))) + "] "));
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public String toLogString() {
        MethodContext _bcornu_methode_context2 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 102, 4122, 4223);
            CallChecker.varInit(this._upToDate, "_upToDate", 102, 4122, 4223);
            CallChecker.varInit(this._connection, "_connection", 102, 4122, 4223);
            updateLogString();
            return super.toLogString();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }
}

