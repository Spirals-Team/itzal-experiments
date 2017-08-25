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

public class VirtualHostMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String VIRTUALHOST_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost";

    public static final String CLOSED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost.closed";

    public static final String STATS_DATA_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost.stats_data";

    public static final String STATS_MSGS_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost.stats_msgs";

    public static final String FILESYSTEM_FULL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost.filesystem_full";

    public static final String FILESYSTEM_NOTFULL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost.filesystem_notfull";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost.created";

    public static final String ERRORED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "virtualhost.errored";

    static {
        LoggerFactory.getLogger(VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY);
        LoggerFactory.getLogger(VirtualHostMessages.CLOSED_LOG_HIERARCHY);
        LoggerFactory.getLogger(VirtualHostMessages.STATS_DATA_LOG_HIERARCHY);
        LoggerFactory.getLogger(VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY);
        LoggerFactory.getLogger(VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY);
        LoggerFactory.getLogger(VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY);
        LoggerFactory.getLogger(VirtualHostMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(VirtualHostMessages.ERRORED_LOG_HIERARCHY);
        VirtualHostMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.VirtualHost_logmessages", VirtualHostMessages._currentLocale);
        CallChecker.varAssign(VirtualHostMessages._messages, "VirtualHostMessages._messages", 67, 3094, 3213);
    }

    public static LogMessage CLOSED(String param1) {
        MethodContext _bcornu_methode_context538 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 77, 3226, 4920);
            CallChecker.varInit(ERRORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.ERRORED_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CREATED_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(FILESYSTEM_NOTFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(FILESYSTEM_FULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_DATA_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CLOSED_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(VIRTUALHOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY", 77, 3226, 4920);
            CallChecker.varInit(VirtualHostMessages._currentLocale, "org.apache.qpid.server.logging.messages.VirtualHostMessages._currentLocale", 77, 3226, 4920);
            CallChecker.varInit(VirtualHostMessages._messages, "org.apache.qpid.server.logging.messages.VirtualHostMessages._messages", 77, 3226, 4920);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(VirtualHostMessages._messages, ResourceBundle.class, 79, 3535, 3543)) {
                VirtualHostMessages._messages = CallChecker.beforeCalled(VirtualHostMessages._messages, ResourceBundle.class, 79, 3535, 3543);
                rawMessage = CallChecker.isCalled(VirtualHostMessages._messages, ResourceBundle.class, 79, 3535, 3543).getString("CLOSED");
                CallChecker.varAssign(rawMessage, "rawMessage", 79, 3535, 3543);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 81, 3575, 3617);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, VirtualHostMessages._currentLocale), "formatter", 84, 3767, 3838);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 86, 3872, 3880);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 86, 3872, 3880).format(messageArguments), "message", 86, 3849, 3906);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context534 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 90, 3963, 4046);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context534.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context535 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 95, 4061, 4164);
                        return VirtualHostMessages.CLOSED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context535.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context536 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 101, 4179, 4666);
                        CallChecker.varInit(o, "o", 101, 4179, 4666);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 112, 4501, 4539);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 114, 4590, 4593)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 114, 4635, 4638)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 114, 4565, 4581).equals(CallChecker.isCalled(that, LogMessage.class, 114, 4590, 4593).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 114, 4617, 4626).equals(CallChecker.isCalled(that, LogMessage.class, 114, 4635, 4638).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context536.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context537 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 119, 4681, 4903);
                        final String npe_invocation_var63 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var63, String.class, 121, 4768, 4777)) {
                            result = CallChecker.isCalled(npe_invocation_var63, String.class, 121, 4768, 4777).hashCode();
                            CallChecker.varAssign(result, "result", 121, 4768, 4777);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 122, 4830, 4846).hashCode());
                        CallChecker.varAssign(result, "result", 122, 4807, 4858);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context537.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context538.methodEnd();
        }
    }

    public static LogMessage STATS_DATA(String param1, Number param2, Number param3, Number param4) {
        MethodContext _bcornu_methode_context543 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param4, "param4", 135, 4927, 6785);
            CallChecker.varInit(param3, "param3", 135, 4927, 6785);
            CallChecker.varInit(param2, "param2", 135, 4927, 6785);
            CallChecker.varInit(param1, "param1", 135, 4927, 6785);
            CallChecker.varInit(ERRORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.ERRORED_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CREATED_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(FILESYSTEM_NOTFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(FILESYSTEM_FULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_DATA_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CLOSED_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(VIRTUALHOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY", 135, 4927, 6785);
            CallChecker.varInit(VirtualHostMessages._currentLocale, "org.apache.qpid.server.logging.messages.VirtualHostMessages._currentLocale", 135, 4927, 6785);
            CallChecker.varInit(VirtualHostMessages._messages, "org.apache.qpid.server.logging.messages.VirtualHostMessages._messages", 135, 4927, 6785);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(VirtualHostMessages._messages, ResourceBundle.class, 137, 5368, 5376)) {
                VirtualHostMessages._messages = CallChecker.beforeCalled(VirtualHostMessages._messages, ResourceBundle.class, 137, 5368, 5376);
                rawMessage = CallChecker.isCalled(VirtualHostMessages._messages, ResourceBundle.class, 137, 5368, 5376).getString("STATS_DATA");
                CallChecker.varAssign(rawMessage, "rawMessage", 137, 5368, 5376);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 , param4 }, "messageArguments", 139, 5412, 5478);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, VirtualHostMessages._currentLocale), "formatter", 142, 5628, 5699);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 144, 5733, 5741);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 144, 5733, 5741).format(messageArguments), "message", 144, 5710, 5767);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context539 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 148, 5824, 5907);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context539.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context540 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 153, 5922, 6029);
                        return VirtualHostMessages.STATS_DATA_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context540.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context541 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 159, 6044, 6531);
                        CallChecker.varInit(o, "o", 159, 6044, 6531);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 170, 6366, 6404);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 172, 6455, 6458)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 172, 6500, 6503)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 172, 6430, 6446).equals(CallChecker.isCalled(that, LogMessage.class, 172, 6455, 6458).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 172, 6482, 6491).equals(CallChecker.isCalled(that, LogMessage.class, 172, 6500, 6503).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context541.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context542 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 177, 6546, 6768);
                        final String npe_invocation_var64 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var64, String.class, 179, 6633, 6642)) {
                            result = CallChecker.isCalled(npe_invocation_var64, String.class, 179, 6633, 6642).hashCode();
                            CallChecker.varAssign(result, "result", 179, 6633, 6642);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 180, 6695, 6711).hashCode());
                        CallChecker.varAssign(result, "result", 180, 6672, 6723);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context542.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context543.methodEnd();
        }
    }

    public static LogMessage STATS_MSGS(String param1, Number param2, Number param3, Number param4) {
        MethodContext _bcornu_methode_context548 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param4, "param4", 193, 6792, 8650);
            CallChecker.varInit(param3, "param3", 193, 6792, 8650);
            CallChecker.varInit(param2, "param2", 193, 6792, 8650);
            CallChecker.varInit(param1, "param1", 193, 6792, 8650);
            CallChecker.varInit(ERRORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.ERRORED_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CREATED_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(FILESYSTEM_NOTFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(FILESYSTEM_FULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_DATA_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CLOSED_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(VIRTUALHOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY", 193, 6792, 8650);
            CallChecker.varInit(VirtualHostMessages._currentLocale, "org.apache.qpid.server.logging.messages.VirtualHostMessages._currentLocale", 193, 6792, 8650);
            CallChecker.varInit(VirtualHostMessages._messages, "org.apache.qpid.server.logging.messages.VirtualHostMessages._messages", 193, 6792, 8650);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(VirtualHostMessages._messages, ResourceBundle.class, 195, 7233, 7241)) {
                VirtualHostMessages._messages = CallChecker.beforeCalled(VirtualHostMessages._messages, ResourceBundle.class, 195, 7233, 7241);
                rawMessage = CallChecker.isCalled(VirtualHostMessages._messages, ResourceBundle.class, 195, 7233, 7241).getString("STATS_MSGS");
                CallChecker.varAssign(rawMessage, "rawMessage", 195, 7233, 7241);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 , param4 }, "messageArguments", 197, 7277, 7343);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, VirtualHostMessages._currentLocale), "formatter", 200, 7493, 7564);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 202, 7598, 7606);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 202, 7598, 7606).format(messageArguments), "message", 202, 7575, 7632);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context544 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 206, 7689, 7772);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context544.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context545 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 211, 7787, 7894);
                        return VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context545.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context546 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 217, 7909, 8396);
                        CallChecker.varInit(o, "o", 217, 7909, 8396);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 228, 8231, 8269);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 230, 8320, 8323)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 230, 8365, 8368)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 230, 8295, 8311).equals(CallChecker.isCalled(that, LogMessage.class, 230, 8320, 8323).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 230, 8347, 8356).equals(CallChecker.isCalled(that, LogMessage.class, 230, 8365, 8368).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context546.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context547 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 235, 8411, 8633);
                        final String npe_invocation_var65 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var65, String.class, 237, 8498, 8507)) {
                            result = CallChecker.isCalled(npe_invocation_var65, String.class, 237, 8498, 8507).hashCode();
                            CallChecker.varAssign(result, "result", 237, 8498, 8507);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 238, 8560, 8576).hashCode());
                        CallChecker.varAssign(result, "result", 238, 8537, 8588);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context547.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context548.methodEnd();
        }
    }

    public static LogMessage FILESYSTEM_FULL(Number param1) {
        MethodContext _bcornu_methode_context553 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 251, 8657, 10434);
            CallChecker.varInit(ERRORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.ERRORED_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CREATED_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(FILESYSTEM_NOTFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(FILESYSTEM_FULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_DATA_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CLOSED_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(VIRTUALHOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY", 251, 8657, 10434);
            CallChecker.varInit(VirtualHostMessages._currentLocale, "org.apache.qpid.server.logging.messages.VirtualHostMessages._currentLocale", 251, 8657, 10434);
            CallChecker.varInit(VirtualHostMessages._messages, "org.apache.qpid.server.logging.messages.VirtualHostMessages._messages", 251, 8657, 10434);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(VirtualHostMessages._messages, ResourceBundle.class, 253, 9031, 9039)) {
                VirtualHostMessages._messages = CallChecker.beforeCalled(VirtualHostMessages._messages, ResourceBundle.class, 253, 9031, 9039);
                rawMessage = CallChecker.isCalled(VirtualHostMessages._messages, ResourceBundle.class, 253, 9031, 9039).getString("FILESYSTEM_FULL");
                CallChecker.varAssign(rawMessage, "rawMessage", 253, 9031, 9039);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 255, 9080, 9122);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, VirtualHostMessages._currentLocale), "formatter", 258, 9272, 9343);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 260, 9377, 9385);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 260, 9377, 9385).format(messageArguments), "message", 260, 9354, 9411);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context549 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 264, 9468, 9551);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context549.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context550 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 269, 9566, 9678);
                        return VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context550.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context551 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 275, 9693, 10180);
                        CallChecker.varInit(o, "o", 275, 9693, 10180);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 286, 10015, 10053);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 288, 10104, 10107)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 288, 10149, 10152)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 288, 10079, 10095).equals(CallChecker.isCalled(that, LogMessage.class, 288, 10104, 10107).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 288, 10131, 10140).equals(CallChecker.isCalled(that, LogMessage.class, 288, 10149, 10152).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context551.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context552 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 293, 10195, 10417);
                        final String npe_invocation_var66 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var66, String.class, 295, 10282, 10291)) {
                            result = CallChecker.isCalled(npe_invocation_var66, String.class, 295, 10282, 10291).hashCode();
                            CallChecker.varAssign(result, "result", 295, 10282, 10291);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 296, 10344, 10360).hashCode());
                        CallChecker.varAssign(result, "result", 296, 10321, 10372);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context552.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context553.methodEnd();
        }
    }

    public static LogMessage FILESYSTEM_NOTFULL(Number param1) {
        MethodContext _bcornu_methode_context558 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 309, 10441, 12213);
            CallChecker.varInit(ERRORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.ERRORED_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CREATED_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(FILESYSTEM_NOTFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(FILESYSTEM_FULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_DATA_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CLOSED_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(VIRTUALHOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY", 309, 10441, 12213);
            CallChecker.varInit(VirtualHostMessages._currentLocale, "org.apache.qpid.server.logging.messages.VirtualHostMessages._currentLocale", 309, 10441, 12213);
            CallChecker.varInit(VirtualHostMessages._messages, "org.apache.qpid.server.logging.messages.VirtualHostMessages._messages", 309, 10441, 12213);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(VirtualHostMessages._messages, ResourceBundle.class, 311, 10804, 10812)) {
                VirtualHostMessages._messages = CallChecker.beforeCalled(VirtualHostMessages._messages, ResourceBundle.class, 311, 10804, 10812);
                rawMessage = CallChecker.isCalled(VirtualHostMessages._messages, ResourceBundle.class, 311, 10804, 10812).getString("FILESYSTEM_NOTFULL");
                CallChecker.varAssign(rawMessage, "rawMessage", 311, 10804, 10812);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 313, 10856, 10898);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, VirtualHostMessages._currentLocale), "formatter", 316, 11048, 11119);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 318, 11153, 11161);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 318, 11153, 11161).format(messageArguments), "message", 318, 11130, 11187);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context554 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 322, 11244, 11327);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context554.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context555 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 327, 11342, 11457);
                        return VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context555.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context556 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 333, 11472, 11959);
                        CallChecker.varInit(o, "o", 333, 11472, 11959);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 344, 11794, 11832);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 346, 11883, 11886)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 346, 11928, 11931)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 346, 11858, 11874).equals(CallChecker.isCalled(that, LogMessage.class, 346, 11883, 11886).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 346, 11910, 11919).equals(CallChecker.isCalled(that, LogMessage.class, 346, 11928, 11931).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context556.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context557 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 351, 11974, 12196);
                        final String npe_invocation_var67 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var67, String.class, 353, 12061, 12070)) {
                            result = CallChecker.isCalled(npe_invocation_var67, String.class, 353, 12061, 12070).hashCode();
                            CallChecker.varAssign(result, "result", 353, 12061, 12070);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 354, 12123, 12139).hashCode());
                        CallChecker.varAssign(result, "result", 354, 12100, 12151);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context557.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context558.methodEnd();
        }
    }

    public static LogMessage CREATED(String param1) {
        MethodContext _bcornu_methode_context563 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 367, 12220, 13918);
            CallChecker.varInit(ERRORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.ERRORED_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CREATED_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(FILESYSTEM_NOTFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(FILESYSTEM_FULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_DATA_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CLOSED_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(VIRTUALHOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY", 367, 12220, 13918);
            CallChecker.varInit(VirtualHostMessages._currentLocale, "org.apache.qpid.server.logging.messages.VirtualHostMessages._currentLocale", 367, 12220, 13918);
            CallChecker.varInit(VirtualHostMessages._messages, "org.apache.qpid.server.logging.messages.VirtualHostMessages._messages", 367, 12220, 13918);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(VirtualHostMessages._messages, ResourceBundle.class, 369, 12531, 12539)) {
                VirtualHostMessages._messages = CallChecker.beforeCalled(VirtualHostMessages._messages, ResourceBundle.class, 369, 12531, 12539);
                rawMessage = CallChecker.isCalled(VirtualHostMessages._messages, ResourceBundle.class, 369, 12531, 12539).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 369, 12531, 12539);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 371, 12572, 12614);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, VirtualHostMessages._currentLocale), "formatter", 374, 12764, 12835);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 376, 12869, 12877);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 376, 12869, 12877).format(messageArguments), "message", 376, 12846, 12903);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context559 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 380, 12960, 13043);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context559.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context560 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 385, 13058, 13162);
                        return VirtualHostMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context560.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context561 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 391, 13177, 13664);
                        CallChecker.varInit(o, "o", 391, 13177, 13664);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 402, 13499, 13537);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 404, 13588, 13591)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 404, 13633, 13636)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 404, 13563, 13579).equals(CallChecker.isCalled(that, LogMessage.class, 404, 13588, 13591).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 404, 13615, 13624).equals(CallChecker.isCalled(that, LogMessage.class, 404, 13633, 13636).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context561.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context562 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 409, 13679, 13901);
                        final String npe_invocation_var68 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var68, String.class, 411, 13766, 13775)) {
                            result = CallChecker.isCalled(npe_invocation_var68, String.class, 411, 13766, 13775).hashCode();
                            CallChecker.varAssign(result, "result", 411, 13766, 13775);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 412, 13828, 13844).hashCode());
                        CallChecker.varAssign(result, "result", 412, 13805, 13856);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context562.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context563.methodEnd();
        }
    }

    public static LogMessage ERRORED(String param1) {
        MethodContext _bcornu_methode_context568 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 425, 13925, 15636);
            CallChecker.varInit(ERRORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.ERRORED_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CREATED_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(FILESYSTEM_NOTFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_NOTFULL_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(FILESYSTEM_FULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.FILESYSTEM_FULL_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_MSGS_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.STATS_DATA_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.CLOSED_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(VIRTUALHOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.VirtualHostMessages.VIRTUALHOST_LOG_HIERARCHY", 425, 13925, 15636);
            CallChecker.varInit(VirtualHostMessages._currentLocale, "org.apache.qpid.server.logging.messages.VirtualHostMessages._currentLocale", 425, 13925, 15636);
            CallChecker.varInit(VirtualHostMessages._messages, "org.apache.qpid.server.logging.messages.VirtualHostMessages._messages", 425, 13925, 15636);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(VirtualHostMessages._messages, ResourceBundle.class, 427, 14249, 14257)) {
                VirtualHostMessages._messages = CallChecker.beforeCalled(VirtualHostMessages._messages, ResourceBundle.class, 427, 14249, 14257);
                rawMessage = CallChecker.isCalled(VirtualHostMessages._messages, ResourceBundle.class, 427, 14249, 14257).getString("ERRORED");
                CallChecker.varAssign(rawMessage, "rawMessage", 427, 14249, 14257);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 429, 14290, 14332);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, VirtualHostMessages._currentLocale), "formatter", 432, 14482, 14553);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 434, 14587, 14595);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 434, 14587, 14595).format(messageArguments), "message", 434, 14564, 14621);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context564 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 438, 14678, 14761);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context564.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context565 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 443, 14776, 14880);
                        return VirtualHostMessages.ERRORED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context565.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context566 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 449, 14895, 15382);
                        CallChecker.varInit(o, "o", 449, 14895, 15382);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 460, 15217, 15255);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 462, 15306, 15309)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 462, 15351, 15354)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 462, 15281, 15297).equals(CallChecker.isCalled(that, LogMessage.class, 462, 15306, 15309).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 462, 15333, 15342).equals(CallChecker.isCalled(that, LogMessage.class, 462, 15351, 15354).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context566.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context567 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 467, 15397, 15619);
                        final String npe_invocation_var69 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var69, String.class, 469, 15484, 15493)) {
                            result = CallChecker.isCalled(npe_invocation_var69, String.class, 469, 15484, 15493).hashCode();
                            CallChecker.varAssign(result, "result", 469, 15484, 15493);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 470, 15546, 15562).hashCode());
                        CallChecker.varAssign(result, "result", 470, 15523, 15574);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context567.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context568.methodEnd();
        }
    }

    private VirtualHostMessages() {
        MethodContext _bcornu_methode_context35 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }
}

