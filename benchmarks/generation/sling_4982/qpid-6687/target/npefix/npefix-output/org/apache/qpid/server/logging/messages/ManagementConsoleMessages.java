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

public class ManagementConsoleMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String MANAGEMENTCONSOLE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole";

    public static final String OPEN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole.open";

    public static final String LISTENING_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole.listening";

    public static final String STOPPED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole.stopped";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole.close";

    public static final String SHUTTING_DOWN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole.shutting_down";

    public static final String STARTUP_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole.startup";

    public static final String READY_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "managementconsole.ready";

    static {
        LoggerFactory.getLogger(ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ManagementConsoleMessages.OPEN_LOG_HIERARCHY);
        LoggerFactory.getLogger(ManagementConsoleMessages.LISTENING_LOG_HIERARCHY);
        LoggerFactory.getLogger(ManagementConsoleMessages.STOPPED_LOG_HIERARCHY);
        LoggerFactory.getLogger(ManagementConsoleMessages.CLOSE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY);
        LoggerFactory.getLogger(ManagementConsoleMessages.STARTUP_LOG_HIERARCHY);
        LoggerFactory.getLogger(ManagementConsoleMessages.READY_LOG_HIERARCHY);
        ManagementConsoleMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.ManagementConsole_logmessages", ManagementConsoleMessages._currentLocale);
        CallChecker.varAssign(ManagementConsoleMessages._messages, "ManagementConsoleMessages._messages", 67, 3097, 3222);
    }

    public static LogMessage OPEN(String param1) {
        MethodContext _bcornu_methode_context144 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 77, 3235, 4932);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.READY_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STARTUP_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.CLOSE_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STOPPED_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.LISTENING_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.OPEN_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(MANAGEMENTCONSOLE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY", 77, 3235, 4932);
            CallChecker.varInit(ManagementConsoleMessages._currentLocale, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._currentLocale", 77, 3235, 4932);
            CallChecker.varInit(ManagementConsoleMessages._messages, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._messages", 77, 3235, 4932);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ManagementConsoleMessages._messages, ResourceBundle.class, 79, 3551, 3559)) {
                ManagementConsoleMessages._messages = CallChecker.beforeCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 79, 3551, 3559);
                rawMessage = CallChecker.isCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 79, 3551, 3559).getString("OPEN");
                CallChecker.varAssign(rawMessage, "rawMessage", 79, 3551, 3559);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 81, 3589, 3631);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ManagementConsoleMessages._currentLocale), "formatter", 84, 3781, 3852);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 86, 3886, 3894);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 86, 3886, 3894).format(messageArguments), "message", 86, 3863, 3920);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context140 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 90, 3977, 4060);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context140.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context141 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 95, 4075, 4176);
                        return ManagementConsoleMessages.OPEN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context141.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context142 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 101, 4191, 4678);
                        CallChecker.varInit(o, "o", 101, 4191, 4678);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 112, 4513, 4551);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 114, 4602, 4605)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 114, 4647, 4650)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 114, 4577, 4593).equals(CallChecker.isCalled(that, LogMessage.class, 114, 4602, 4605).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 114, 4629, 4638).equals(CallChecker.isCalled(that, LogMessage.class, 114, 4647, 4650).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context142.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context143 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 119, 4693, 4915);
                        final String npe_invocation_var3 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var3, String.class, 121, 4780, 4789)) {
                            result = CallChecker.isCalled(npe_invocation_var3, String.class, 121, 4780, 4789).hashCode();
                            CallChecker.varAssign(result, "result", 121, 4780, 4789);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 122, 4842, 4858).hashCode());
                        CallChecker.varAssign(result, "result", 122, 4819, 4870);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context143.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public static LogMessage LISTENING(String param1, String param2, Number param3) {
        MethodContext _bcornu_methode_context149 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param3, "param3", 135, 4939, 6733);
            CallChecker.varInit(param2, "param2", 135, 4939, 6733);
            CallChecker.varInit(param1, "param1", 135, 4939, 6733);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.READY_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STARTUP_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.CLOSE_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STOPPED_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.LISTENING_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.OPEN_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(MANAGEMENTCONSOLE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY", 135, 4939, 6733);
            CallChecker.varInit(ManagementConsoleMessages._currentLocale, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._currentLocale", 135, 4939, 6733);
            CallChecker.varInit(ManagementConsoleMessages._messages, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._messages", 135, 4939, 6733);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ManagementConsoleMessages._messages, ResourceBundle.class, 137, 5326, 5334)) {
                ManagementConsoleMessages._messages = CallChecker.beforeCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 137, 5326, 5334);
                rawMessage = CallChecker.isCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 137, 5326, 5334).getString("LISTENING");
                CallChecker.varAssign(rawMessage, "rawMessage", 137, 5326, 5334);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 }, "messageArguments", 139, 5369, 5427);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ManagementConsoleMessages._currentLocale), "formatter", 142, 5577, 5648);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 144, 5682, 5690);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 144, 5682, 5690).format(messageArguments), "message", 144, 5659, 5716);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context145 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 148, 5773, 5856);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context145.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context146 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 153, 5871, 5977);
                        return ManagementConsoleMessages.LISTENING_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context146.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context147 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 159, 5992, 6479);
                        CallChecker.varInit(o, "o", 159, 5992, 6479);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 170, 6314, 6352);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 172, 6403, 6406)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 172, 6448, 6451)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 172, 6378, 6394).equals(CallChecker.isCalled(that, LogMessage.class, 172, 6403, 6406).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 172, 6430, 6439).equals(CallChecker.isCalled(that, LogMessage.class, 172, 6448, 6451).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context147.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context148 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 177, 6494, 6716);
                        final String npe_invocation_var4 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var4, String.class, 179, 6581, 6590)) {
                            result = CallChecker.isCalled(npe_invocation_var4, String.class, 179, 6581, 6590).hashCode();
                            CallChecker.varAssign(result, "result", 179, 6581, 6590);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 180, 6643, 6659).hashCode());
                        CallChecker.varAssign(result, "result", 180, 6620, 6671);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context148.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public static LogMessage STOPPED(String param1) {
        MethodContext _bcornu_methode_context154 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 193, 6740, 8453);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.READY_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STARTUP_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.CLOSE_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STOPPED_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.LISTENING_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.OPEN_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(MANAGEMENTCONSOLE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY", 193, 6740, 8453);
            CallChecker.varInit(ManagementConsoleMessages._currentLocale, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._currentLocale", 193, 6740, 8453);
            CallChecker.varInit(ManagementConsoleMessages._messages, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._messages", 193, 6740, 8453);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ManagementConsoleMessages._messages, ResourceBundle.class, 195, 7066, 7074)) {
                ManagementConsoleMessages._messages = CallChecker.beforeCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 195, 7066, 7074);
                rawMessage = CallChecker.isCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 195, 7066, 7074).getString("STOPPED");
                CallChecker.varAssign(rawMessage, "rawMessage", 195, 7066, 7074);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 197, 7107, 7149);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ManagementConsoleMessages._currentLocale), "formatter", 200, 7299, 7370);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 202, 7404, 7412);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 202, 7404, 7412).format(messageArguments), "message", 202, 7381, 7438);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context150 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 206, 7495, 7578);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context150.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context151 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 211, 7593, 7697);
                        return ManagementConsoleMessages.STOPPED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context151.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context152 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 217, 7712, 8199);
                        CallChecker.varInit(o, "o", 217, 7712, 8199);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 228, 8034, 8072);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 230, 8123, 8126)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 230, 8168, 8171)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 230, 8098, 8114).equals(CallChecker.isCalled(that, LogMessage.class, 230, 8123, 8126).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 230, 8150, 8159).equals(CallChecker.isCalled(that, LogMessage.class, 230, 8168, 8171).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context152.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context153 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 235, 8214, 8436);
                        final String npe_invocation_var5 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var5, String.class, 237, 8301, 8310)) {
                            result = CallChecker.isCalled(npe_invocation_var5, String.class, 237, 8301, 8310).hashCode();
                            CallChecker.varAssign(result, "result", 237, 8301, 8310);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 238, 8363, 8379).hashCode());
                        CallChecker.varAssign(result, "result", 238, 8340, 8391);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context153.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    public static LogMessage CLOSE(String param1) {
        MethodContext _bcornu_methode_context159 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 251, 8460, 10161);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.READY_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STARTUP_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.CLOSE_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STOPPED_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.LISTENING_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.OPEN_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(MANAGEMENTCONSOLE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY", 251, 8460, 10161);
            CallChecker.varInit(ManagementConsoleMessages._currentLocale, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._currentLocale", 251, 8460, 10161);
            CallChecker.varInit(ManagementConsoleMessages._messages, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._messages", 251, 8460, 10161);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ManagementConsoleMessages._messages, ResourceBundle.class, 253, 8778, 8786)) {
                ManagementConsoleMessages._messages = CallChecker.beforeCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 253, 8778, 8786);
                rawMessage = CallChecker.isCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 253, 8778, 8786).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 253, 8778, 8786);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 255, 8817, 8859);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ManagementConsoleMessages._currentLocale), "formatter", 258, 9009, 9080);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 260, 9114, 9122);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 260, 9114, 9122).format(messageArguments), "message", 260, 9091, 9148);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context155 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 264, 9205, 9288);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context155.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context156 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 269, 9303, 9405);
                        return ManagementConsoleMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context156.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context157 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 275, 9420, 9907);
                        CallChecker.varInit(o, "o", 275, 9420, 9907);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 286, 9742, 9780);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 288, 9831, 9834)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 288, 9876, 9879)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 288, 9806, 9822).equals(CallChecker.isCalled(that, LogMessage.class, 288, 9831, 9834).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 288, 9858, 9867).equals(CallChecker.isCalled(that, LogMessage.class, 288, 9876, 9879).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context157.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context158 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 293, 9922, 10144);
                        final String npe_invocation_var6 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var6, String.class, 295, 10009, 10018)) {
                            result = CallChecker.isCalled(npe_invocation_var6, String.class, 295, 10009, 10018).hashCode();
                            CallChecker.varAssign(result, "result", 295, 10009, 10018);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 296, 10071, 10087).hashCode());
                        CallChecker.varAssign(result, "result", 296, 10048, 10099);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context158.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context159.methodEnd();
        }
    }

    public static LogMessage SHUTTING_DOWN(String param1, Number param2) {
        MethodContext _bcornu_methode_context164 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 309, 10168, 11939);
            CallChecker.varInit(param1, "param1", 309, 10168, 11939);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.READY_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STARTUP_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.CLOSE_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STOPPED_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.LISTENING_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.OPEN_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(MANAGEMENTCONSOLE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY", 309, 10168, 11939);
            CallChecker.varInit(ManagementConsoleMessages._currentLocale, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._currentLocale", 309, 10168, 11939);
            CallChecker.varInit(ManagementConsoleMessages._messages, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._messages", 309, 10168, 11939);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ManagementConsoleMessages._messages, ResourceBundle.class, 311, 10532, 10540)) {
                ManagementConsoleMessages._messages = CallChecker.beforeCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 311, 10532, 10540);
                rawMessage = CallChecker.isCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 311, 10532, 10540).getString("SHUTTING_DOWN");
                CallChecker.varAssign(rawMessage, "rawMessage", 311, 10532, 10540);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 313, 10579, 10629);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ManagementConsoleMessages._currentLocale), "formatter", 316, 10779, 10850);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 318, 10884, 10892);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 318, 10884, 10892).format(messageArguments), "message", 318, 10861, 10918);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context160 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 322, 10975, 11058);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context160.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context161 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 327, 11073, 11183);
                        return ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context161.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context162 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 333, 11198, 11685);
                        CallChecker.varInit(o, "o", 333, 11198, 11685);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 344, 11520, 11558);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 346, 11609, 11612)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 346, 11654, 11657)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 346, 11584, 11600).equals(CallChecker.isCalled(that, LogMessage.class, 346, 11609, 11612).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 346, 11636, 11645).equals(CallChecker.isCalled(that, LogMessage.class, 346, 11654, 11657).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context162.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context163 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 351, 11700, 11922);
                        final String npe_invocation_var7 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var7, String.class, 353, 11787, 11796)) {
                            result = CallChecker.isCalled(npe_invocation_var7, String.class, 353, 11787, 11796).hashCode();
                            CallChecker.varAssign(result, "result", 353, 11787, 11796);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 354, 11849, 11865).hashCode());
                        CallChecker.varAssign(result, "result", 354, 11826, 11877);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context163.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }

    public static LogMessage STARTUP(String param1) {
        MethodContext _bcornu_methode_context169 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 367, 11946, 13659);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.READY_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STARTUP_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.CLOSE_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STOPPED_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.LISTENING_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.OPEN_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(MANAGEMENTCONSOLE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY", 367, 11946, 13659);
            CallChecker.varInit(ManagementConsoleMessages._currentLocale, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._currentLocale", 367, 11946, 13659);
            CallChecker.varInit(ManagementConsoleMessages._messages, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._messages", 367, 11946, 13659);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ManagementConsoleMessages._messages, ResourceBundle.class, 369, 12272, 12280)) {
                ManagementConsoleMessages._messages = CallChecker.beforeCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 369, 12272, 12280);
                rawMessage = CallChecker.isCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 369, 12272, 12280).getString("STARTUP");
                CallChecker.varAssign(rawMessage, "rawMessage", 369, 12272, 12280);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 371, 12313, 12355);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ManagementConsoleMessages._currentLocale), "formatter", 374, 12505, 12576);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 376, 12610, 12618);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 376, 12610, 12618).format(messageArguments), "message", 376, 12587, 12644);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context165 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 380, 12701, 12784);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context165.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context166 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 385, 12799, 12903);
                        return ManagementConsoleMessages.STARTUP_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context166.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context167 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 391, 12918, 13405);
                        CallChecker.varInit(o, "o", 391, 12918, 13405);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 402, 13240, 13278);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 404, 13329, 13332)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 404, 13374, 13377)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 404, 13304, 13320).equals(CallChecker.isCalled(that, LogMessage.class, 404, 13329, 13332).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 404, 13356, 13365).equals(CallChecker.isCalled(that, LogMessage.class, 404, 13374, 13377).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context167.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context168 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 409, 13420, 13642);
                        final String npe_invocation_var8 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var8, String.class, 411, 13507, 13516)) {
                            result = CallChecker.isCalled(npe_invocation_var8, String.class, 411, 13507, 13516).hashCode();
                            CallChecker.varAssign(result, "result", 411, 13507, 13516);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 412, 13569, 13585).hashCode());
                        CallChecker.varAssign(result, "result", 412, 13546, 13597);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context168.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }

    public static LogMessage READY(String param1) {
        MethodContext _bcornu_methode_context174 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 425, 13666, 15371);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.READY_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STARTUP_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.SHUTTING_DOWN_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.CLOSE_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.STOPPED_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.LISTENING_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.OPEN_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(MANAGEMENTCONSOLE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages.MANAGEMENTCONSOLE_LOG_HIERARCHY", 425, 13666, 15371);
            CallChecker.varInit(ManagementConsoleMessages._currentLocale, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._currentLocale", 425, 13666, 15371);
            CallChecker.varInit(ManagementConsoleMessages._messages, "org.apache.qpid.server.logging.messages.ManagementConsoleMessages._messages", 425, 13666, 15371);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ManagementConsoleMessages._messages, ResourceBundle.class, 427, 13988, 13996)) {
                ManagementConsoleMessages._messages = CallChecker.beforeCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 427, 13988, 13996);
                rawMessage = CallChecker.isCalled(ManagementConsoleMessages._messages, ResourceBundle.class, 427, 13988, 13996).getString("READY");
                CallChecker.varAssign(rawMessage, "rawMessage", 427, 13988, 13996);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 429, 14027, 14069);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ManagementConsoleMessages._currentLocale), "formatter", 432, 14219, 14290);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 434, 14324, 14332);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 434, 14324, 14332).format(messageArguments), "message", 434, 14301, 14358);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context170 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 438, 14415, 14498);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context170.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context171 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 443, 14513, 14615);
                        return ManagementConsoleMessages.READY_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context171.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context172 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 449, 14630, 15117);
                        CallChecker.varInit(o, "o", 449, 14630, 15117);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 460, 14952, 14990);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 462, 15041, 15044)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 462, 15086, 15089)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 462, 15016, 15032).equals(CallChecker.isCalled(that, LogMessage.class, 462, 15041, 15044).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 462, 15068, 15077).equals(CallChecker.isCalled(that, LogMessage.class, 462, 15086, 15089).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context172.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context173 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 467, 15132, 15354);
                        final String npe_invocation_var9 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var9, String.class, 469, 15219, 15228)) {
                            result = CallChecker.isCalled(npe_invocation_var9, String.class, 469, 15219, 15228).hashCode();
                            CallChecker.varAssign(result, "result", 469, 15219, 15228);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 470, 15281, 15297).hashCode());
                        CallChecker.varAssign(result, "result", 470, 15258, 15309);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context173.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    private ManagementConsoleMessages() {
        MethodContext _bcornu_methode_context15 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }
}

