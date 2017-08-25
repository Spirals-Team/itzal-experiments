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

public class PortMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String PORT_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "port";

    public static final String OPEN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "port.open";

    public static final String CREATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "port.create";

    public static final String DELETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "port.delete";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "port.close";

    public static final String CONNECTION_REJECTED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "port.connection_rejected";

    public static final String CONNECTION_COUNT_WARN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "port.connection_count_warn";

    static {
        LoggerFactory.getLogger(PortMessages.PORT_LOG_HIERARCHY);
        LoggerFactory.getLogger(PortMessages.OPEN_LOG_HIERARCHY);
        LoggerFactory.getLogger(PortMessages.CREATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(PortMessages.DELETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(PortMessages.CLOSE_LOG_HIERARCHY);
        LoggerFactory.getLogger(PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY);
        LoggerFactory.getLogger(PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY);
        PortMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Port_logmessages", PortMessages._currentLocale);
        CallChecker.varAssign(PortMessages._messages, "PortMessages._messages", 65, 2837, 2949);
    }

    public static LogMessage OPEN() {
        MethodContext _bcornu_methode_context782 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CONNECTION_COUNT_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY", 75, 2962, 4324);
            CallChecker.varInit(CONNECTION_REJECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY", 75, 2962, 4324);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CLOSE_LOG_HIERARCHY", 75, 2962, 4324);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.DELETE_LOG_HIERARCHY", 75, 2962, 4324);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CREATE_LOG_HIERARCHY", 75, 2962, 4324);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.OPEN_LOG_HIERARCHY", 75, 2962, 4324);
            CallChecker.varInit(PORT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.PORT_LOG_HIERARCHY", 75, 2962, 4324);
            CallChecker.varInit(PortMessages._currentLocale, "org.apache.qpid.server.logging.messages.PortMessages._currentLocale", 75, 2962, 4324);
            CallChecker.varInit(PortMessages._messages, "org.apache.qpid.server.logging.messages.PortMessages._messages", 75, 2962, 4324);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(PortMessages._messages, ResourceBundle.class, 77, 3241, 3249)) {
                PortMessages._messages = CallChecker.beforeCalled(PortMessages._messages, ResourceBundle.class, 77, 3241, 3249);
                rawMessage = CallChecker.isCalled(PortMessages._messages, ResourceBundle.class, 77, 3241, 3249).getString("OPEN");
                CallChecker.varAssign(rawMessage, "rawMessage", 77, 3241, 3249);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 79, 3279, 3312);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context778 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 83, 3369, 3452);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context778.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context779 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 88, 3467, 3568);
                        return PortMessages.OPEN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context779.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context780 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 94, 3583, 4070);
                        CallChecker.varInit(o, "o", 94, 3583, 4070);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 105, 3905, 3943);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 107, 3994, 3997)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 107, 4039, 4042)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 107, 3969, 3985).equals(CallChecker.isCalled(that, LogMessage.class, 107, 3994, 3997).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 107, 4021, 4030).equals(CallChecker.isCalled(that, LogMessage.class, 107, 4039, 4042).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context780.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context781 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 112, 4085, 4307);
                        final String npe_invocation_var102 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var102, String.class, 114, 4172, 4181)) {
                            result = CallChecker.isCalled(npe_invocation_var102, String.class, 114, 4172, 4181).hashCode();
                            CallChecker.varAssign(result, "result", 114, 4172, 4181);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 115, 4234, 4250).hashCode());
                        CallChecker.varAssign(result, "result", 115, 4211, 4262);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context781.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context782.methodEnd();
        }
    }

    public static LogMessage CREATE(String param1) {
        MethodContext _bcornu_methode_context787 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 128, 4331, 6018);
            CallChecker.varInit(CONNECTION_COUNT_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY", 128, 4331, 6018);
            CallChecker.varInit(CONNECTION_REJECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY", 128, 4331, 6018);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CLOSE_LOG_HIERARCHY", 128, 4331, 6018);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.DELETE_LOG_HIERARCHY", 128, 4331, 6018);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CREATE_LOG_HIERARCHY", 128, 4331, 6018);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.OPEN_LOG_HIERARCHY", 128, 4331, 6018);
            CallChecker.varInit(PORT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.PORT_LOG_HIERARCHY", 128, 4331, 6018);
            CallChecker.varInit(PortMessages._currentLocale, "org.apache.qpid.server.logging.messages.PortMessages._currentLocale", 128, 4331, 6018);
            CallChecker.varInit(PortMessages._messages, "org.apache.qpid.server.logging.messages.PortMessages._messages", 128, 4331, 6018);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(PortMessages._messages, ResourceBundle.class, 130, 4633, 4641)) {
                PortMessages._messages = CallChecker.beforeCalled(PortMessages._messages, ResourceBundle.class, 130, 4633, 4641);
                rawMessage = CallChecker.isCalled(PortMessages._messages, ResourceBundle.class, 130, 4633, 4641).getString("CREATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 130, 4633, 4641);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 132, 4673, 4715);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, PortMessages._currentLocale), "formatter", 135, 4865, 4936);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 137, 4970, 4978);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 137, 4970, 4978).format(messageArguments), "message", 137, 4947, 5004);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context783 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 141, 5061, 5144);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context783.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context784 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 146, 5159, 5262);
                        return PortMessages.CREATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context784.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context785 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 152, 5277, 5764);
                        CallChecker.varInit(o, "o", 152, 5277, 5764);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 163, 5599, 5637);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 165, 5688, 5691)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 165, 5733, 5736)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 165, 5663, 5679).equals(CallChecker.isCalled(that, LogMessage.class, 165, 5688, 5691).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 165, 5715, 5724).equals(CallChecker.isCalled(that, LogMessage.class, 165, 5733, 5736).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context785.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context786 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 170, 5779, 6001);
                        final String npe_invocation_var103 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var103, String.class, 172, 5866, 5875)) {
                            result = CallChecker.isCalled(npe_invocation_var103, String.class, 172, 5866, 5875).hashCode();
                            CallChecker.varAssign(result, "result", 172, 5866, 5875);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 173, 5928, 5944).hashCode());
                        CallChecker.varAssign(result, "result", 173, 5905, 5956);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context786.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context787.methodEnd();
        }
    }

    public static LogMessage DELETE(String param1, String param2) {
        MethodContext _bcornu_methode_context792 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 186, 6025, 7744);
            CallChecker.varInit(param1, "param1", 186, 6025, 7744);
            CallChecker.varInit(CONNECTION_COUNT_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY", 186, 6025, 7744);
            CallChecker.varInit(CONNECTION_REJECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY", 186, 6025, 7744);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CLOSE_LOG_HIERARCHY", 186, 6025, 7744);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.DELETE_LOG_HIERARCHY", 186, 6025, 7744);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CREATE_LOG_HIERARCHY", 186, 6025, 7744);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.OPEN_LOG_HIERARCHY", 186, 6025, 7744);
            CallChecker.varInit(PORT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.PORT_LOG_HIERARCHY", 186, 6025, 7744);
            CallChecker.varInit(PortMessages._currentLocale, "org.apache.qpid.server.logging.messages.PortMessages._currentLocale", 186, 6025, 7744);
            CallChecker.varInit(PortMessages._messages, "org.apache.qpid.server.logging.messages.PortMessages._messages", 186, 6025, 7744);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(PortMessages._messages, ResourceBundle.class, 188, 6351, 6359)) {
                PortMessages._messages = CallChecker.beforeCalled(PortMessages._messages, ResourceBundle.class, 188, 6351, 6359);
                rawMessage = CallChecker.isCalled(PortMessages._messages, ResourceBundle.class, 188, 6351, 6359).getString("DELETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 188, 6351, 6359);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 190, 6391, 6441);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, PortMessages._currentLocale), "formatter", 193, 6591, 6662);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 195, 6696, 6704);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 195, 6696, 6704).format(messageArguments), "message", 195, 6673, 6730);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context788 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 199, 6787, 6870);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context788.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context789 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 204, 6885, 6988);
                        return PortMessages.DELETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context789.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context790 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 210, 7003, 7490);
                        CallChecker.varInit(o, "o", 210, 7003, 7490);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 221, 7325, 7363);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 223, 7414, 7417)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 223, 7459, 7462)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 223, 7389, 7405).equals(CallChecker.isCalled(that, LogMessage.class, 223, 7414, 7417).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 223, 7441, 7450).equals(CallChecker.isCalled(that, LogMessage.class, 223, 7459, 7462).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context790.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context791 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 228, 7505, 7727);
                        final String npe_invocation_var104 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var104, String.class, 230, 7592, 7601)) {
                            result = CallChecker.isCalled(npe_invocation_var104, String.class, 230, 7592, 7601).hashCode();
                            CallChecker.varAssign(result, "result", 230, 7592, 7601);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 231, 7654, 7670).hashCode());
                        CallChecker.varAssign(result, "result", 231, 7631, 7682);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context791.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context792.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context797 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CONNECTION_COUNT_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY", 244, 7751, 9117);
            CallChecker.varInit(CONNECTION_REJECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY", 244, 7751, 9117);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CLOSE_LOG_HIERARCHY", 244, 7751, 9117);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.DELETE_LOG_HIERARCHY", 244, 7751, 9117);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CREATE_LOG_HIERARCHY", 244, 7751, 9117);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.OPEN_LOG_HIERARCHY", 244, 7751, 9117);
            CallChecker.varInit(PORT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.PORT_LOG_HIERARCHY", 244, 7751, 9117);
            CallChecker.varInit(PortMessages._currentLocale, "org.apache.qpid.server.logging.messages.PortMessages._currentLocale", 244, 7751, 9117);
            CallChecker.varInit(PortMessages._messages, "org.apache.qpid.server.logging.messages.PortMessages._messages", 244, 7751, 9117);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(PortMessages._messages, ResourceBundle.class, 246, 8032, 8040)) {
                PortMessages._messages = CallChecker.beforeCalled(PortMessages._messages, ResourceBundle.class, 246, 8032, 8040);
                rawMessage = CallChecker.isCalled(PortMessages._messages, ResourceBundle.class, 246, 8032, 8040).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 246, 8032, 8040);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 248, 8071, 8104);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context793 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 252, 8161, 8244);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context793.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context794 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 257, 8259, 8361);
                        return PortMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context794.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context795 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 263, 8376, 8863);
                        CallChecker.varInit(o, "o", 263, 8376, 8863);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 274, 8698, 8736);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 276, 8787, 8790)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 276, 8832, 8835)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 276, 8762, 8778).equals(CallChecker.isCalled(that, LogMessage.class, 276, 8787, 8790).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 276, 8814, 8823).equals(CallChecker.isCalled(that, LogMessage.class, 276, 8832, 8835).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context795.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context796 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 281, 8878, 9100);
                        final String npe_invocation_var105 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var105, String.class, 283, 8965, 8974)) {
                            result = CallChecker.isCalled(npe_invocation_var105, String.class, 283, 8965, 8974).hashCode();
                            CallChecker.varAssign(result, "result", 283, 8965, 8974);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 284, 9027, 9043).hashCode());
                        CallChecker.varAssign(result, "result", 284, 9004, 9055);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context796.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context797.methodEnd();
        }
    }

    public static LogMessage CONNECTION_REJECTED(String param1) {
        MethodContext _bcornu_methode_context802 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 297, 9124, 10866);
            CallChecker.varInit(CONNECTION_COUNT_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY", 297, 9124, 10866);
            CallChecker.varInit(CONNECTION_REJECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY", 297, 9124, 10866);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CLOSE_LOG_HIERARCHY", 297, 9124, 10866);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.DELETE_LOG_HIERARCHY", 297, 9124, 10866);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CREATE_LOG_HIERARCHY", 297, 9124, 10866);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.OPEN_LOG_HIERARCHY", 297, 9124, 10866);
            CallChecker.varInit(PORT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.PORT_LOG_HIERARCHY", 297, 9124, 10866);
            CallChecker.varInit(PortMessages._currentLocale, "org.apache.qpid.server.logging.messages.PortMessages._currentLocale", 297, 9124, 10866);
            CallChecker.varInit(PortMessages._messages, "org.apache.qpid.server.logging.messages.PortMessages._messages", 297, 9124, 10866);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(PortMessages._messages, ResourceBundle.class, 299, 9455, 9463)) {
                PortMessages._messages = CallChecker.beforeCalled(PortMessages._messages, ResourceBundle.class, 299, 9455, 9463);
                rawMessage = CallChecker.isCalled(PortMessages._messages, ResourceBundle.class, 299, 9455, 9463).getString("CONNECTION_REJECTED");
                CallChecker.varAssign(rawMessage, "rawMessage", 299, 9455, 9463);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 301, 9508, 9550);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, PortMessages._currentLocale), "formatter", 304, 9700, 9771);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 306, 9805, 9813);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 306, 9805, 9813).format(messageArguments), "message", 306, 9782, 9839);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context798 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 310, 9896, 9979);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context798.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context799 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 315, 9994, 10110);
                        return PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context799.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context800 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 321, 10125, 10612);
                        CallChecker.varInit(o, "o", 321, 10125, 10612);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 332, 10447, 10485);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 334, 10536, 10539)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 334, 10581, 10584)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 334, 10511, 10527).equals(CallChecker.isCalled(that, LogMessage.class, 334, 10536, 10539).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 334, 10563, 10572).equals(CallChecker.isCalled(that, LogMessage.class, 334, 10581, 10584).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context800.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context801 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 339, 10627, 10849);
                        final String npe_invocation_var106 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var106, String.class, 341, 10714, 10723)) {
                            result = CallChecker.isCalled(npe_invocation_var106, String.class, 341, 10714, 10723).hashCode();
                            CallChecker.varAssign(result, "result", 341, 10714, 10723);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 342, 10776, 10792).hashCode());
                        CallChecker.varAssign(result, "result", 342, 10753, 10804);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context801.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context802.methodEnd();
        }
    }

    public static LogMessage CONNECTION_COUNT_WARN(Number param1, Number param2, Number param3) {
        MethodContext _bcornu_methode_context807 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param3, "param3", 355, 10873, 12709);
            CallChecker.varInit(param2, "param2", 355, 10873, 12709);
            CallChecker.varInit(param1, "param1", 355, 10873, 12709);
            CallChecker.varInit(CONNECTION_COUNT_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY", 355, 10873, 12709);
            CallChecker.varInit(CONNECTION_REJECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CONNECTION_REJECTED_LOG_HIERARCHY", 355, 10873, 12709);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CLOSE_LOG_HIERARCHY", 355, 10873, 12709);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.DELETE_LOG_HIERARCHY", 355, 10873, 12709);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.CREATE_LOG_HIERARCHY", 355, 10873, 12709);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.OPEN_LOG_HIERARCHY", 355, 10873, 12709);
            CallChecker.varInit(PORT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.PortMessages.PORT_LOG_HIERARCHY", 355, 10873, 12709);
            CallChecker.varInit(PortMessages._currentLocale, "org.apache.qpid.server.logging.messages.PortMessages._currentLocale", 355, 10873, 12709);
            CallChecker.varInit(PortMessages._messages, "org.apache.qpid.server.logging.messages.PortMessages._messages", 355, 10873, 12709);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(PortMessages._messages, ResourceBundle.class, 357, 11278, 11286)) {
                PortMessages._messages = CallChecker.beforeCalled(PortMessages._messages, ResourceBundle.class, 357, 11278, 11286);
                rawMessage = CallChecker.isCalled(PortMessages._messages, ResourceBundle.class, 357, 11278, 11286).getString("CONNECTION_COUNT_WARN");
                CallChecker.varAssign(rawMessage, "rawMessage", 357, 11278, 11286);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 }, "messageArguments", 359, 11333, 11391);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, PortMessages._currentLocale), "formatter", 362, 11541, 11612);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 364, 11646, 11654);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 364, 11646, 11654).format(messageArguments), "message", 364, 11623, 11680);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context803 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 368, 11737, 11820);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context803.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context804 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 373, 11835, 11953);
                        return PortMessages.CONNECTION_COUNT_WARN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context804.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context805 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 379, 11968, 12455);
                        CallChecker.varInit(o, "o", 379, 11968, 12455);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 390, 12290, 12328);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 392, 12379, 12382)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 392, 12424, 12427)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 392, 12354, 12370).equals(CallChecker.isCalled(that, LogMessage.class, 392, 12379, 12382).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 392, 12406, 12415).equals(CallChecker.isCalled(that, LogMessage.class, 392, 12424, 12427).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context805.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context806 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 397, 12470, 12692);
                        final String npe_invocation_var107 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var107, String.class, 399, 12557, 12566)) {
                            result = CallChecker.isCalled(npe_invocation_var107, String.class, 399, 12557, 12566).hashCode();
                            CallChecker.varAssign(result, "result", 399, 12557, 12566);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 400, 12619, 12635).hashCode());
                        CallChecker.varAssign(result, "result", 400, 12596, 12647);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context806.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context807.methodEnd();
        }
    }

    private PortMessages() {
        MethodContext _bcornu_methode_context54 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }
}

