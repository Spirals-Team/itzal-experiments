package org.apache.qpid.server.logging.messages;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.qpid.server.configuration.BrokerProperties;
import org.apache.qpid.server.logging.AbstractMessageLogger;
import org.apache.qpid.server.logging.LogMessage;
import org.slf4j.LoggerFactory;

public class AuthenticationProviderMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String AUTHENTICATIONPROVIDER_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "authenticationprovider";

    public static final String OPEN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "authenticationprovider.open";

    public static final String CREATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "authenticationprovider.create";

    public static final String DELETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "authenticationprovider.delete";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "authenticationprovider.close";

    static {
        LoggerFactory.getLogger(AuthenticationProviderMessages.AUTHENTICATIONPROVIDER_LOG_HIERARCHY);
        LoggerFactory.getLogger(AuthenticationProviderMessages.OPEN_LOG_HIERARCHY);
        LoggerFactory.getLogger(AuthenticationProviderMessages.CREATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(AuthenticationProviderMessages.DELETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(AuthenticationProviderMessages.CLOSE_LOG_HIERARCHY);
        AuthenticationProviderMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.AuthenticationProvider_logmessages", AuthenticationProviderMessages._currentLocale);
        CallChecker.varAssign(AuthenticationProviderMessages._messages, "AuthenticationProviderMessages._messages", 61, 2605, 2735);
    }

    public static LogMessage OPEN() {
        MethodContext _bcornu_methode_context573 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CLOSE_LOG_HIERARCHY", 71, 2748, 4128);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.DELETE_LOG_HIERARCHY", 71, 2748, 4128);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CREATE_LOG_HIERARCHY", 71, 2748, 4128);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.OPEN_LOG_HIERARCHY", 71, 2748, 4128);
            CallChecker.varInit(AUTHENTICATIONPROVIDER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.AUTHENTICATIONPROVIDER_LOG_HIERARCHY", 71, 2748, 4128);
            CallChecker.varInit(AuthenticationProviderMessages._currentLocale, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._currentLocale", 71, 2748, 4128);
            CallChecker.varInit(AuthenticationProviderMessages._messages, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._messages", 71, 2748, 4128);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AuthenticationProviderMessages._messages, ResourceBundle.class, 73, 3045, 3053)) {
                AuthenticationProviderMessages._messages = CallChecker.beforeCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 73, 3045, 3053);
                rawMessage = CallChecker.isCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 73, 3045, 3053).getString("OPEN");
                CallChecker.varAssign(rawMessage, "rawMessage", 73, 3045, 3053);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 75, 3083, 3116);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context569 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 79, 3173, 3256);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context569.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context570 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 84, 3271, 3372);
                        return AuthenticationProviderMessages.OPEN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context570.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context571 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 90, 3387, 3874);
                        CallChecker.varInit(o, "o", 90, 3387, 3874);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 101, 3709, 3747);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 103, 3798, 3801)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 103, 3843, 3846)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 103, 3773, 3789).equals(CallChecker.isCalled(that, LogMessage.class, 103, 3798, 3801).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 103, 3825, 3834).equals(CallChecker.isCalled(that, LogMessage.class, 103, 3843, 3846).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context571.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context572 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 108, 3889, 4111);
                        final String npe_invocation_var70 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var70, String.class, 110, 3976, 3985)) {
                            result = CallChecker.isCalled(npe_invocation_var70, String.class, 110, 3976, 3985).hashCode();
                            CallChecker.varAssign(result, "result", 110, 3976, 3985);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 111, 4038, 4054).hashCode());
                        CallChecker.varAssign(result, "result", 111, 4015, 4066);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context572.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context573.methodEnd();
        }
    }

    public static LogMessage CREATE(String param1) {
        MethodContext _bcornu_methode_context578 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 124, 4135, 5840);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CLOSE_LOG_HIERARCHY", 124, 4135, 5840);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.DELETE_LOG_HIERARCHY", 124, 4135, 5840);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CREATE_LOG_HIERARCHY", 124, 4135, 5840);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.OPEN_LOG_HIERARCHY", 124, 4135, 5840);
            CallChecker.varInit(AUTHENTICATIONPROVIDER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.AUTHENTICATIONPROVIDER_LOG_HIERARCHY", 124, 4135, 5840);
            CallChecker.varInit(AuthenticationProviderMessages._currentLocale, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._currentLocale", 124, 4135, 5840);
            CallChecker.varInit(AuthenticationProviderMessages._messages, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._messages", 124, 4135, 5840);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AuthenticationProviderMessages._messages, ResourceBundle.class, 126, 4455, 4463)) {
                AuthenticationProviderMessages._messages = CallChecker.beforeCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 126, 4455, 4463);
                rawMessage = CallChecker.isCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 126, 4455, 4463).getString("CREATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 126, 4455, 4463);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 128, 4495, 4537);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, AuthenticationProviderMessages._currentLocale), "formatter", 131, 4687, 4758);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 133, 4792, 4800);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 133, 4792, 4800).format(messageArguments), "message", 133, 4769, 4826);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context574 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 137, 4883, 4966);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context574.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context575 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 142, 4981, 5084);
                        return AuthenticationProviderMessages.CREATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context575.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context576 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 148, 5099, 5586);
                        CallChecker.varInit(o, "o", 148, 5099, 5586);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 159, 5421, 5459);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 161, 5510, 5513)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 161, 5555, 5558)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 161, 5485, 5501).equals(CallChecker.isCalled(that, LogMessage.class, 161, 5510, 5513).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 161, 5537, 5546).equals(CallChecker.isCalled(that, LogMessage.class, 161, 5555, 5558).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context576.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context577 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 166, 5601, 5823);
                        final String npe_invocation_var71 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var71, String.class, 168, 5688, 5697)) {
                            result = CallChecker.isCalled(npe_invocation_var71, String.class, 168, 5688, 5697).hashCode();
                            CallChecker.varAssign(result, "result", 168, 5688, 5697);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 169, 5750, 5766).hashCode());
                        CallChecker.varAssign(result, "result", 169, 5727, 5778);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context577.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context578.methodEnd();
        }
    }

    public static LogMessage DELETE(String param1) {
        MethodContext _bcornu_methode_context583 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 182, 5847, 7552);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CLOSE_LOG_HIERARCHY", 182, 5847, 7552);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.DELETE_LOG_HIERARCHY", 182, 5847, 7552);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CREATE_LOG_HIERARCHY", 182, 5847, 7552);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.OPEN_LOG_HIERARCHY", 182, 5847, 7552);
            CallChecker.varInit(AUTHENTICATIONPROVIDER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.AUTHENTICATIONPROVIDER_LOG_HIERARCHY", 182, 5847, 7552);
            CallChecker.varInit(AuthenticationProviderMessages._currentLocale, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._currentLocale", 182, 5847, 7552);
            CallChecker.varInit(AuthenticationProviderMessages._messages, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._messages", 182, 5847, 7552);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AuthenticationProviderMessages._messages, ResourceBundle.class, 184, 6167, 6175)) {
                AuthenticationProviderMessages._messages = CallChecker.beforeCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 184, 6167, 6175);
                rawMessage = CallChecker.isCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 184, 6167, 6175).getString("DELETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 184, 6167, 6175);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 186, 6207, 6249);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, AuthenticationProviderMessages._currentLocale), "formatter", 189, 6399, 6470);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 191, 6504, 6512);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 191, 6504, 6512).format(messageArguments), "message", 191, 6481, 6538);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context579 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 195, 6595, 6678);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context579.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context580 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 200, 6693, 6796);
                        return AuthenticationProviderMessages.DELETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context580.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context581 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 206, 6811, 7298);
                        CallChecker.varInit(o, "o", 206, 6811, 7298);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 217, 7133, 7171);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7222, 7225)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7267, 7270)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 219, 7197, 7213).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7222, 7225).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 219, 7249, 7258).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7267, 7270).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context581.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context582 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 224, 7313, 7535);
                        final String npe_invocation_var72 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var72, String.class, 226, 7400, 7409)) {
                            result = CallChecker.isCalled(npe_invocation_var72, String.class, 226, 7400, 7409).hashCode();
                            CallChecker.varAssign(result, "result", 226, 7400, 7409);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 227, 7462, 7478).hashCode());
                        CallChecker.varAssign(result, "result", 227, 7439, 7490);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context582.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context583.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context588 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CLOSE_LOG_HIERARCHY", 240, 7559, 8943);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.DELETE_LOG_HIERARCHY", 240, 7559, 8943);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.CREATE_LOG_HIERARCHY", 240, 7559, 8943);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.OPEN_LOG_HIERARCHY", 240, 7559, 8943);
            CallChecker.varInit(AUTHENTICATIONPROVIDER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages.AUTHENTICATIONPROVIDER_LOG_HIERARCHY", 240, 7559, 8943);
            CallChecker.varInit(AuthenticationProviderMessages._currentLocale, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._currentLocale", 240, 7559, 8943);
            CallChecker.varInit(AuthenticationProviderMessages._messages, "org.apache.qpid.server.logging.messages.AuthenticationProviderMessages._messages", 240, 7559, 8943);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AuthenticationProviderMessages._messages, ResourceBundle.class, 242, 7858, 7866)) {
                AuthenticationProviderMessages._messages = CallChecker.beforeCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 242, 7858, 7866);
                rawMessage = CallChecker.isCalled(AuthenticationProviderMessages._messages, ResourceBundle.class, 242, 7858, 7866).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 242, 7858, 7866);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 244, 7897, 7930);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context584 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 248, 7987, 8070);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context584.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context585 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 253, 8085, 8187);
                        return AuthenticationProviderMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context585.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context586 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 259, 8202, 8689);
                        CallChecker.varInit(o, "o", 259, 8202, 8689);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 270, 8524, 8562);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 272, 8613, 8616)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 272, 8658, 8661)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 272, 8588, 8604).equals(CallChecker.isCalled(that, LogMessage.class, 272, 8613, 8616).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 272, 8640, 8649).equals(CallChecker.isCalled(that, LogMessage.class, 272, 8658, 8661).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context586.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context587 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 277, 8704, 8926);
                        final String npe_invocation_var73 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var73, String.class, 279, 8791, 8800)) {
                            result = CallChecker.isCalled(npe_invocation_var73, String.class, 279, 8791, 8800).hashCode();
                            CallChecker.varAssign(result, "result", 279, 8791, 8800);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 280, 8853, 8869).hashCode());
                        CallChecker.varAssign(result, "result", 280, 8830, 8881);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context587.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context588.methodEnd();
        }
    }

    private AuthenticationProviderMessages() {
        MethodContext _bcornu_methode_context36 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }
}

