package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.security.Principal;
import org.apache.qpid.server.protocol.AMQSessionModel;
import org.apache.qpid.server.transport.AMQPConnection;

public class ChannelLogSubject extends AbstractLogSubject {
    public ChannelLogSubject(AMQSessionModel session) {
        MethodContext _bcornu_methode_context55 = new MethodContext(null);
        try {
            AMQPConnection connection = CallChecker.init(AMQPConnection.class);
            if (CallChecker.beforeDeref(session, AMQSessionModel.class, 46, 1633, 1639)) {
                session = CallChecker.beforeCalled(session, AMQSessionModel.class, 46, 1633, 1639);
                connection = CallChecker.isCalled(session, AMQSessionModel.class, 46, 1633, 1639).getAMQPConnection();
                CallChecker.varAssign(connection, "connection", 46, 1633, 1639);
            }
            if (connection == null) {
                if (CallChecker.beforeDeref(connection, AMQPConnection.class, 49, 1851, 1860)) {
                    if (CallChecker.beforeDeref(connection, AMQPConnection.class, 49, 1904, 1913)) {
                        connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 49, 1851, 1860);
                        connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 49, 1904, 1913);
                        if (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 49, 1851, 1860), AMQPConnection.class, 49, 1851, 1885).getAuthorizedPrincipal()) == null)) || (CallChecker.beforeDeref(CallChecker.isCalled(connection, AMQPConnection.class, 49, 1904, 1913).getAuthorizedPrincipal(), Principal.class, 49, 1904, 1938))) {
                            if (CallChecker.beforeDeref(connection, AMQPConnection.class, 50, 2005, 2014)) {
                                connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 50, 2005, 2014);
                                if (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 50, 2005, 2014), AMQPConnection.class, 50, 2005, 2039).getRemoteAddressString()) == null)) || (CallChecker.beforeDeref(connection, AMQPConnection.class, 50, 2058, 2067))) {
                                    if (CallChecker.beforeDeref(connection, AMQPConnection.class, 51, 2149, 2158)) {
                                        connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 51, 2149, 2158);
                                        if (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 51, 2149, 2158), AMQPConnection.class, 51, 2149, 2179).getVirtualHostName()) == null)) || (CallChecker.beforeDeref(connection, AMQPConnection.class, 51, 2198, 2207))) {
                                            if (CallChecker.beforeDeref(session, AMQSessionModel.class, 52, 2262, 2268)) {
                                                connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 49, 1904, 1913);
                                                connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 50, 2058, 2067);
                                                connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 51, 2198, 2207);
                                                session = CallChecker.beforeCalled(session, AMQSessionModel.class, 52, 2262, 2268);
                                                setLogStringWithFormat(LogSubjectFormat.CHANNEL_FORMAT, (-1L), (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 49, 1851, 1860), AMQPConnection.class, 49, 1851, 1885).getAuthorizedPrincipal()) == null)) ? "?" : CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 49, 1904, 1913).getAuthorizedPrincipal(), Principal.class, 49, 1904, 1938).getName()), (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 50, 2005, 2014), AMQPConnection.class, 50, 2005, 2039).getRemoteAddressString()) == null)) ? "?" : CallChecker.isCalled(connection, AMQPConnection.class, 50, 2058, 2067).getRemoteAddressString()), (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 51, 2149, 2158), AMQPConnection.class, 51, 2149, 2179).getVirtualHostName()) == null)) ? "?" : CallChecker.isCalled(connection, AMQPConnection.class, 51, 2198, 2207).getVirtualHostName()), CallChecker.isCalled(session, AMQSessionModel.class, 52, 2262, 2268).getChannelId());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else {
                connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 49, 1904, 1913);
                if (((connection == null) || ((connection.getAuthorizedPrincipal()) == null)) || (CallChecker.beforeDeref(CallChecker.isCalled(connection, AMQPConnection.class, 49, 1904, 1913).getAuthorizedPrincipal(), Principal.class, 49, 1904, 1938))) {
                    if (CallChecker.beforeDeref(session, AMQSessionModel.class, 52, 2262, 2268)) {
                        session = CallChecker.beforeCalled(session, AMQSessionModel.class, 52, 2262, 2268);
                        setLogStringWithFormat(LogSubjectFormat.CHANNEL_FORMAT, connection.getConnectionId(), (((connection == null) || ((connection.getAuthorizedPrincipal()) == null)) ? "?" : CallChecker.isCalled(connection.getAuthorizedPrincipal(), Principal.class, 49, 1904, 1938).getName()), ((connection == null) || ((connection.getRemoteAddressString()) == null) ? "?" : connection.getRemoteAddressString()), ((connection == null) || ((connection.getVirtualHostName()) == null) ? "?" : connection.getVirtualHostName()), CallChecker.isCalled(session, AMQSessionModel.class, 52, 2262, 2268).getChannelId());
                    }
                }
            }
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }
}

