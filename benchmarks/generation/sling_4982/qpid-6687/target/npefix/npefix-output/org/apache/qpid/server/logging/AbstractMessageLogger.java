package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.net.SocketAddress;
import java.security.AccessController;
import java.security.Principal;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.Subject;
import org.apache.qpid.server.connection.ConnectionPrincipal;
import org.apache.qpid.server.connection.SessionPrincipal;
import org.apache.qpid.server.logging.subjects.LogSubjectFormat;
import org.apache.qpid.server.protocol.AMQSessionModel;
import org.apache.qpid.server.security.auth.AuthenticatedPrincipal;
import org.apache.qpid.server.security.auth.ManagementConnectionPrincipal;
import org.apache.qpid.server.security.auth.TaskPrincipal;
import org.apache.qpid.server.transport.AMQPConnection;

public abstract class AbstractMessageLogger implements MessageLogger {
    public static final String DEFAULT_LOG_HIERARCHY_PREFIX = "qpid.message.";

    private final String _msgPrefix = System.getProperty("qpid.logging.prefix", "");

    private boolean _enabled = true;

    public AbstractMessageLogger() {
        MethodContext _bcornu_methode_context12 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public AbstractMessageLogger(boolean statusUpdatesEnabled) {
        MethodContext _bcornu_methode_context13 = new MethodContext(null);
        try {
            _enabled = statusUpdatesEnabled;
            CallChecker.varAssign(this._enabled, "this._enabled", 59, 2290, 2321);
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public boolean isEnabled() {
        MethodContext _bcornu_methode_context114 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 62, 2338, 2400);
            CallChecker.varInit(this._enabled, "_enabled", 62, 2338, 2400);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 62, 2338, 2400);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 62, 2338, 2400);
            return _enabled;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    public boolean isMessageEnabled(String logHierarchy) {
        MethodContext _bcornu_methode_context115 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 67, 2407, 2495);
            CallChecker.varInit(logHierarchy, "logHierarchy", 67, 2407, 2495);
            CallChecker.varInit(this._enabled, "_enabled", 67, 2407, 2495);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 67, 2407, 2495);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 67, 2407, 2495);
            return _enabled;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    public void message(LogMessage message) {
        MethodContext _bcornu_methode_context116 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 72, 2502, 2715);
            CallChecker.varInit(message, "message", 72, 2502, 2715);
            CallChecker.varInit(this._enabled, "_enabled", 72, 2502, 2715);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 72, 2502, 2715);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 72, 2502, 2715);
            if (CallChecker.beforeDeref(message, LogMessage.class, 74, 2577, 2583)) {
                message = CallChecker.beforeCalled(message, LogMessage.class, 74, 2577, 2583);
                if (isMessageEnabled(CallChecker.isCalled(message, LogMessage.class, 74, 2577, 2583).getLogHierarchy())) {
                    if (CallChecker.beforeDeref(message, LogMessage.class, 76, 2673, 2679)) {
                        message = CallChecker.beforeCalled(message, LogMessage.class, 76, 2673, 2679);
                        rawMessage((((_msgPrefix) + (getActor())) + message), CallChecker.isCalled(message, LogMessage.class, 76, 2673, 2679).getLogHierarchy());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }

    public void message(LogSubject subject, LogMessage message) {
        MethodContext _bcornu_methode_context117 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 80, 2722, 3002);
            CallChecker.varInit(message, "message", 80, 2722, 3002);
            CallChecker.varInit(subject, "subject", 80, 2722, 3002);
            CallChecker.varInit(this._enabled, "_enabled", 80, 2722, 3002);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 80, 2722, 3002);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 80, 2722, 3002);
            if (CallChecker.beforeDeref(message, LogMessage.class, 82, 2817, 2823)) {
                message = CallChecker.beforeCalled(message, LogMessage.class, 82, 2817, 2823);
                if (isMessageEnabled(CallChecker.isCalled(message, LogMessage.class, 82, 2817, 2823).getLogHierarchy())) {
                    if (CallChecker.beforeDeref(subject, LogSubject.class, 84, 2904, 2910)) {
                        if (CallChecker.beforeDeref(message, LogMessage.class, 85, 2960, 2966)) {
                            subject = CallChecker.beforeCalled(subject, LogSubject.class, 84, 2904, 2910);
                            message = CallChecker.beforeCalled(message, LogMessage.class, 85, 2960, 2966);
                            rawMessage(((((_msgPrefix) + (getActor())) + (CallChecker.isCalled(subject, LogSubject.class, 84, 2904, 2910).toLogString())) + message), CallChecker.isCalled(message, LogMessage.class, 85, 2960, 2966).getLogHierarchy());
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    abstract void rawMessage(String message, String logHierarchy);

    abstract void rawMessage(String message, Throwable throwable, String logHierarchy);

    protected String getActor() {
        MethodContext _bcornu_methode_context120 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 93, 3166, 4668);
            CallChecker.varInit(this._enabled, "_enabled", 93, 3166, 4668);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 93, 3166, 4668);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 93, 3166, 4668);
            Subject subject = CallChecker.varInit(Subject.getSubject(AccessController.getContext()), "subject", 95, 3208, 3275);
            SessionPrincipal sessionPrincipal = CallChecker.varInit(getPrincipal(subject, SessionPrincipal.class), "sessionPrincipal", 97, 3286, 3367);
            String message = CallChecker.init(String.class);
            if (sessionPrincipal != null) {
                message = generateSessionMessage(sessionPrincipal.getSession());
                CallChecker.varAssign(message, "message", 101, 3452, 3516);
            }else {
                ConnectionPrincipal connPrincipal = CallChecker.varInit(getPrincipal(subject, ConnectionPrincipal.class), "connPrincipal", 105, 3563, 3647);
                if (connPrincipal != null) {
                    message = generateConnectionMessage(connPrincipal.getConnection());
                    CallChecker.varAssign(message, "message", 109, 3718, 3784);
                }else {
                    TaskPrincipal taskPrincipal = CallChecker.varInit(getPrincipal(subject, TaskPrincipal.class), "taskPrincipal", 113, 3847, 3919);
                    if (taskPrincipal != null) {
                        message = generateTaskMessage(taskPrincipal);
                        CallChecker.varAssign(message, "message", 116, 4001, 4045);
                    }else {
                        ManagementConnectionPrincipal managementConnection = CallChecker.varInit(getPrincipal(subject, ManagementConnectionPrincipal.class), "managementConnection", 120, 4124, 4234);
                        if (managementConnection != null) {
                            message = generateManagementConnectionMessage(managementConnection, getPrincipal(subject, AuthenticatedPrincipal.class));
                            CallChecker.varAssign(message, "message", 123, 4335, 4455);
                        }else {
                            message = "<<UNKNOWN>> ";
                            CallChecker.varAssign(message, "message", 127, 4550, 4574);
                        }
                    }
                }
            }
            return message;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    private String generateManagementConnectionMessage(final ManagementConnectionPrincipal managementConnection, final AuthenticatedPrincipal userPrincipal) {
        MethodContext _bcornu_methode_context121 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 135, 4675, 5162);
            CallChecker.varInit(userPrincipal, "userPrincipal", 135, 4675, 5162);
            CallChecker.varInit(managementConnection, "managementConnection", 135, 4675, 5162);
            CallChecker.varInit(this._enabled, "_enabled", 135, 4675, 5162);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 135, 4675, 5162);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 135, 4675, 5162);
            String remoteAddress = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(managementConnection, ManagementConnectionPrincipal.class, 138, 4920, 4939)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(managementConnection, ManagementConnectionPrincipal.class, 138, 4920, 4939).getRemoteAddress(), SocketAddress.class, 138, 4920, 4958)) {
                    remoteAddress = CallChecker.isCalled(CallChecker.isCalled(managementConnection, ManagementConnectionPrincipal.class, 138, 4920, 4939).getRemoteAddress(), SocketAddress.class, 138, 4920, 4958).toString();
                    CallChecker.varAssign(remoteAddress, "remoteAddress", 138, 4920, 4939);
                }
            }
            String user = CallChecker.init(String.class);
            if (userPrincipal == null) {
                user = "N/A";
                CallChecker.varAssign(user, "user", 139, 4994, 5048);
            }else {
                user = userPrincipal.getName();
                CallChecker.varAssign(user, "user", 139, 4994, 5048);
            }
            return ("[" + (MessageFormat.format(LogSubjectFormat.MANAGEMENT_FORMAT, user, remoteAddress))) + "] ";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    private String generateTaskMessage(final TaskPrincipal taskPrincipal) {
        MethodContext _bcornu_methode_context122 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 143, 5169, 5298);
            CallChecker.varInit(taskPrincipal, "taskPrincipal", 143, 5169, 5298);
            CallChecker.varInit(this._enabled, "_enabled", 143, 5169, 5298);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 143, 5169, 5298);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 143, 5169, 5298);
            return ("[" + (CallChecker.isCalled(taskPrincipal, TaskPrincipal.class, 145, 5264, 5276).getName())) + "] ";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    protected String generateConnectionMessage(final AMQPConnection<?> connection) {
        MethodContext _bcornu_methode_context123 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 148, 5305, 7124);
            CallChecker.varInit(connection, "connection", 148, 5305, 7124);
            CallChecker.varInit(this._enabled, "_enabled", 148, 5305, 7124);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 148, 5305, 7124);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 148, 5305, 7124);
            if (CallChecker.beforeDeref(connection, AMQPConnection.class, 150, 5402, 5411)) {
                if ((CallChecker.isCalled(connection, AMQPConnection.class, 150, 5402, 5411).getAuthorizedPrincipal()) != null) {
                    if (CallChecker.beforeDeref(connection, AMQPConnection.class, 152, 5473, 5482)) {
                        if ((CallChecker.isCalled(connection, AMQPConnection.class, 152, 5473, 5482).getVirtualHostName()) != null) {
                            if (CallChecker.beforeDeref(connection, AMQPConnection.class, 165, 6088, 6097)) {
                                if (CallChecker.beforeDeref(connection, AMQPConnection.class, 166, 6168, 6177)) {
                                    if (CallChecker.beforeDeref(connection, AMQPConnection.class, 167, 6265, 6274)) {
                                        if (CallChecker.beforeDeref(connection, AMQPConnection.class, 168, 6352, 6361)) {
                                            return ("[" + (MessageFormat.format(LogSubjectFormat.CONNECTION_FORMAT, CallChecker.isCalled(connection, AMQPConnection.class, 165, 6088, 6097).getConnectionId(), CallChecker.isCalled(connection, AMQPConnection.class, 166, 6168, 6177).getAuthorizedPrincipal().getName(), CallChecker.isCalled(connection, AMQPConnection.class, 167, 6265, 6274).getRemoteAddressString(), CallChecker.isCalled(connection, AMQPConnection.class, 168, 6352, 6361).getVirtualHostName()))) + "] ";
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            if (CallChecker.beforeDeref(connection, AMQPConnection.class, 175, 6573, 6582)) {
                                if (CallChecker.beforeDeref(connection, AMQPConnection.class, 176, 6652, 6661)) {
                                    if (CallChecker.beforeDeref(connection, AMQPConnection.class, 177, 6748, 6757)) {
                                        return ("[" + (MessageFormat.format(LogSubjectFormat.USER_FORMAT, CallChecker.isCalled(connection, AMQPConnection.class, 175, 6573, 6582).getConnectionId(), CallChecker.isCalled(connection, AMQPConnection.class, 176, 6652, 6661).getAuthorizedPrincipal().getName(), CallChecker.isCalled(connection, AMQPConnection.class, 177, 6748, 6757).getRemoteAddressString()))) + "] ";
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    if (CallChecker.beforeDeref(connection, AMQPConnection.class, 185, 6970, 6979)) {
                        if (CallChecker.beforeDeref(connection, AMQPConnection.class, 186, 7046, 7055)) {
                            return ("[" + (MessageFormat.format(LogSubjectFormat.SOCKET_FORMAT, CallChecker.isCalled(connection, AMQPConnection.class, 185, 6970, 6979).getConnectionId(), CallChecker.isCalled(connection, AMQPConnection.class, 186, 7046, 7055).getRemoteAddressString()))) + "] ";
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context123.methodEnd();
        }
    }

    protected String generateSessionMessage(final AMQSessionModel session) {
        MethodContext _bcornu_methode_context124 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 191, 7131, 8251);
            CallChecker.varInit(session, "session", 191, 7131, 8251);
            CallChecker.varInit(this._enabled, "_enabled", 191, 7131, 8251);
            CallChecker.varInit(this._msgPrefix, "_msgPrefix", 191, 7131, 8251);
            CallChecker.varInit(DEFAULT_LOG_HIERARCHY_PREFIX, "org.apache.qpid.server.logging.AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX", 191, 7131, 8251);
            AMQPConnection<?> connection = CallChecker.init(AMQPConnection.class);
            if (CallChecker.beforeDeref(session, AMQSessionModel.class, 193, 7247, 7253)) {
                connection = CallChecker.isCalled(session, AMQSessionModel.class, 193, 7247, 7253).getAMQPConnection();
                CallChecker.varAssign(connection, "connection", 193, 7247, 7253);
            }
            if ((connection == null) || (CallChecker.beforeDeref(connection, AMQPConnection.class, 194, 7361, 7370))) {
                if (CallChecker.beforeDeref(connection, AMQPConnection.class, 197, 7609, 7618)) {
                    connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 195, 7456, 7465);
                    connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 197, 7609, 7618);
                    if (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 195, 7456, 7465), AMQPConnection.class, 195, 7456, 7490).getAuthorizedPrincipal()) == null)) || (CallChecker.beforeDeref(CallChecker.isCalled(connection, AMQPConnection.class, 197, 7609, 7618).getAuthorizedPrincipal(), Principal.class, 197, 7609, 7643))) {
                        connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 198, 7721, 7730);
                        if (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 198, 7721, 7730), AMQPConnection.class, 198, 7721, 7755).getRemoteAddressString()) == null)) || (CallChecker.beforeDeref(connection, AMQPConnection.class, 200, 7874, 7883))) {
                            connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 201, 7976, 7985);
                            if (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 201, 7976, 7985), AMQPConnection.class, 201, 7976, 8006).getVirtualHostName()) == null)) || (CallChecker.beforeDeref(connection, AMQPConnection.class, 203, 8125, 8134))) {
                                if (CallChecker.beforeDeref(session, AMQSessionModel.class, 204, 8200, 8206)) {
                                    connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 194, 7361, 7370);
                                    connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 197, 7609, 7618);
                                    connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 200, 7874, 7883);
                                    connection = CallChecker.beforeCalled(connection, AMQPConnection.class, 203, 8125, 8134);
                                    return ("[" + (MessageFormat.format(LogSubjectFormat.CHANNEL_FORMAT, ((connection == null) ? -1L : CallChecker.isCalled(connection, AMQPConnection.class, 194, 7361, 7370).getConnectionId()), (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 195, 7456, 7465), AMQPConnection.class, 195, 7456, 7490).getAuthorizedPrincipal()) == null)) ? "?" : CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 197, 7609, 7618).getAuthorizedPrincipal(), Principal.class, 197, 7609, 7643).getName()), (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 198, 7721, 7730), AMQPConnection.class, 198, 7721, 7755).getRemoteAddressString()) == null)) ? "?" : CallChecker.isCalled(connection, AMQPConnection.class, 200, 7874, 7883).getRemoteAddressString()), (((connection == null) || ((CallChecker.isCalled(CallChecker.isCalled(connection, AMQPConnection.class, 201, 7976, 7985), AMQPConnection.class, 201, 7976, 8006).getVirtualHostName()) == null)) ? "?" : CallChecker.isCalled(connection, AMQPConnection.class, 203, 8125, 8134).getVirtualHostName()), CallChecker.isCalled(session, AMQSessionModel.class, 204, 8200, 8206).getChannelId()))) + "] ";
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    private <P extends Principal> P getPrincipal(Subject subject, Class<P> clazz) {
        if (subject != null) {
            Set<P> principals = CallChecker.varInit(subject.getPrincipals(clazz), "principals", 212, 8392, 8440);
            if ((principals != null) && (!(principals.isEmpty()))) {
                principals = CallChecker.beforeCalled(principals, Set.class, 215, 8539, 8548);
                if (CallChecker.beforeDeref(CallChecker.isCalled(principals, Set.class, 215, 8539, 8548).iterator(), Iterator.class, 215, 8539, 8559)) {
                    return principals.iterator().next();
                }else
                    throw new AbnormalExecutionError();
                
            }
        }
        return null;
    }
}

