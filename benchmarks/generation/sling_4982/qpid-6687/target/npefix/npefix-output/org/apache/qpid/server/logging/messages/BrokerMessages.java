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

public class BrokerMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String BROKER_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker";

    public static final String CONFIG_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.config";

    public static final String STATS_DATA_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.stats_data";

    public static final String STOPPED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.stopped";

    public static final String STATS_MSGS_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.stats_msgs";

    public static final String LISTENING_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.listening";

    public static final String FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.flow_to_disk_inactive";

    public static final String FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.flow_to_disk_active";

    public static final String MAX_MEMORY_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.max_memory";

    public static final String PLATFORM_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.platform";

    public static final String PROCESS_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.process";

    public static final String SHUTTING_DOWN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.shutting_down";

    public static final String MANAGEMENT_MODE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.management_mode";

    public static final String STARTUP_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.startup";

    public static final String FATAL_ERROR_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.fatal_error";

    public static final String READY_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "broker.ready";

    static {
        LoggerFactory.getLogger(BrokerMessages.BROKER_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.CONFIG_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.STATS_DATA_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.STOPPED_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.STATS_MSGS_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.LISTENING_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.MAX_MEMORY_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.PLATFORM_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.PROCESS_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.STARTUP_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.FATAL_ERROR_LOG_HIERARCHY);
        LoggerFactory.getLogger(BrokerMessages.READY_LOG_HIERARCHY);
        BrokerMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Broker_logmessages", BrokerMessages._currentLocale);
        CallChecker.varAssign(BrokerMessages._messages, "BrokerMessages._messages", 83, 4401, 4515);
    }

    public static LogMessage CONFIG(String param1) {
        MethodContext _bcornu_methode_context392 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 93, 4528, 6230);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 93, 4528, 6230);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 93, 4528, 6230);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 93, 4528, 6230);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 95, 4845, 4853)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 95, 4845, 4853);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 95, 4845, 4853).getString("CONFIG");
                CallChecker.varAssign(rawMessage, "rawMessage", 95, 4845, 4853);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 97, 4885, 4927);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 100, 5077, 5148);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 102, 5182, 5190);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 102, 5182, 5190).format(messageArguments), "message", 102, 5159, 5216);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context388 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 106, 5273, 5356);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context388.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context389 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 111, 5371, 5474);
                        return BrokerMessages.CONFIG_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context389.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context390 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 117, 5489, 5976);
                        CallChecker.varInit(o, "o", 117, 5489, 5976);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 128, 5811, 5849);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 130, 5900, 5903)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 130, 5945, 5948)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 130, 5875, 5891).equals(CallChecker.isCalled(that, LogMessage.class, 130, 5900, 5903).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 130, 5927, 5936).equals(CallChecker.isCalled(that, LogMessage.class, 130, 5945, 5948).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context390.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context391 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 135, 5991, 6213);
                        final String npe_invocation_var41 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var41, String.class, 137, 6078, 6087)) {
                            result = CallChecker.isCalled(npe_invocation_var41, String.class, 137, 6078, 6087).hashCode();
                            CallChecker.varAssign(result, "result", 137, 6078, 6087);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 138, 6140, 6156).hashCode());
                        CallChecker.varAssign(result, "result", 138, 6117, 6168);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context391.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context392.methodEnd();
        }
    }

    public static LogMessage STATS_DATA(Number param1, Number param2, Number param3) {
        MethodContext _bcornu_methode_context397 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param3, "param3", 151, 6237, 8061);
            CallChecker.varInit(param2, "param2", 151, 6237, 8061);
            CallChecker.varInit(param1, "param1", 151, 6237, 8061);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 151, 6237, 8061);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 151, 6237, 8061);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 151, 6237, 8061);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 153, 6652, 6660)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 153, 6652, 6660);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 153, 6652, 6660).getString("STATS_DATA");
                CallChecker.varAssign(rawMessage, "rawMessage", 153, 6652, 6660);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 }, "messageArguments", 155, 6696, 6754);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 158, 6904, 6975);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 160, 7009, 7017);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 160, 7009, 7017).format(messageArguments), "message", 160, 6986, 7043);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context393 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 164, 7100, 7183);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context393.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context394 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 169, 7198, 7305);
                        return BrokerMessages.STATS_DATA_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context394.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context395 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 175, 7320, 7807);
                        CallChecker.varInit(o, "o", 175, 7320, 7807);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 186, 7642, 7680);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 188, 7731, 7734)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 188, 7776, 7779)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 188, 7706, 7722).equals(CallChecker.isCalled(that, LogMessage.class, 188, 7731, 7734).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 188, 7758, 7767).equals(CallChecker.isCalled(that, LogMessage.class, 188, 7776, 7779).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context395.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context396 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 193, 7822, 8044);
                        final String npe_invocation_var42 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var42, String.class, 195, 7909, 7918)) {
                            result = CallChecker.isCalled(npe_invocation_var42, String.class, 195, 7909, 7918).hashCode();
                            CallChecker.varAssign(result, "result", 195, 7909, 7918);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 196, 7971, 7987).hashCode());
                        CallChecker.varAssign(result, "result", 196, 7948, 7999);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context396.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context397.methodEnd();
        }
    }

    public static LogMessage STOPPED() {
        MethodContext _bcornu_methode_context402 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 209, 8068, 9444);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 209, 8068, 9444);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 209, 8068, 9444);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 211, 8355, 8363)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 211, 8355, 8363);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 211, 8355, 8363).getString("STOPPED");
                CallChecker.varAssign(rawMessage, "rawMessage", 211, 8355, 8363);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 213, 8396, 8429);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context398 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 217, 8486, 8569);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context398.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context399 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 222, 8584, 8688);
                        return BrokerMessages.STOPPED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context399.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context400 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 228, 8703, 9190);
                        CallChecker.varInit(o, "o", 228, 8703, 9190);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 239, 9025, 9063);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 241, 9114, 9117)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 241, 9159, 9162)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 241, 9089, 9105).equals(CallChecker.isCalled(that, LogMessage.class, 241, 9114, 9117).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 241, 9141, 9150).equals(CallChecker.isCalled(that, LogMessage.class, 241, 9159, 9162).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context400.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context401 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 246, 9205, 9427);
                        final String npe_invocation_var43 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var43, String.class, 248, 9292, 9301)) {
                            result = CallChecker.isCalled(npe_invocation_var43, String.class, 248, 9292, 9301).hashCode();
                            CallChecker.varAssign(result, "result", 248, 9292, 9301);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 249, 9354, 9370).hashCode());
                        CallChecker.varAssign(result, "result", 249, 9331, 9382);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context401.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context402.methodEnd();
        }
    }

    public static LogMessage STATS_MSGS(Number param1, Number param2, Number param3) {
        MethodContext _bcornu_methode_context407 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param3, "param3", 262, 9451, 11275);
            CallChecker.varInit(param2, "param2", 262, 9451, 11275);
            CallChecker.varInit(param1, "param1", 262, 9451, 11275);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 262, 9451, 11275);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 262, 9451, 11275);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 262, 9451, 11275);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 264, 9866, 9874)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 264, 9866, 9874);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 264, 9866, 9874).getString("STATS_MSGS");
                CallChecker.varAssign(rawMessage, "rawMessage", 264, 9866, 9874);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 }, "messageArguments", 266, 9910, 9968);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 269, 10118, 10189);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 271, 10223, 10231);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 271, 10223, 10231).format(messageArguments), "message", 271, 10200, 10257);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context403 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 275, 10314, 10397);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context403.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context404 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 280, 10412, 10519);
                        return BrokerMessages.STATS_MSGS_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context404.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context405 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 286, 10534, 11021);
                        CallChecker.varInit(o, "o", 286, 10534, 11021);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 297, 10856, 10894);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 299, 10945, 10948)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 299, 10990, 10993)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 299, 10920, 10936).equals(CallChecker.isCalled(that, LogMessage.class, 299, 10945, 10948).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 299, 10972, 10981).equals(CallChecker.isCalled(that, LogMessage.class, 299, 10990, 10993).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context405.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context406 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 304, 11036, 11258);
                        final String npe_invocation_var44 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var44, String.class, 306, 11123, 11132)) {
                            result = CallChecker.isCalled(npe_invocation_var44, String.class, 306, 11123, 11132).hashCode();
                            CallChecker.varAssign(result, "result", 306, 11123, 11132);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 307, 11185, 11201).hashCode());
                        CallChecker.varAssign(result, "result", 307, 11162, 11213);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context406.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context407.methodEnd();
        }
    }

    public static LogMessage LISTENING(String param1, Number param2) {
        MethodContext _bcornu_methode_context412 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 320, 11282, 13036);
            CallChecker.varInit(param1, "param1", 320, 11282, 13036);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 320, 11282, 13036);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 320, 11282, 13036);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 320, 11282, 13036);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 322, 11637, 11645)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 322, 11637, 11645);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 322, 11637, 11645).getString("LISTENING");
                CallChecker.varAssign(rawMessage, "rawMessage", 322, 11637, 11645);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 324, 11680, 11730);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 327, 11880, 11951);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 329, 11985, 11993);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 329, 11985, 11993).format(messageArguments), "message", 329, 11962, 12019);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context408 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 333, 12076, 12159);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context408.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context409 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 338, 12174, 12280);
                        return BrokerMessages.LISTENING_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context409.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context410 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 344, 12295, 12782);
                        CallChecker.varInit(o, "o", 344, 12295, 12782);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 355, 12617, 12655);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 357, 12706, 12709)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 357, 12751, 12754)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 357, 12681, 12697).equals(CallChecker.isCalled(that, LogMessage.class, 357, 12706, 12709).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 357, 12733, 12742).equals(CallChecker.isCalled(that, LogMessage.class, 357, 12751, 12754).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context410.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context411 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 362, 12797, 13019);
                        final String npe_invocation_var45 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var45, String.class, 364, 12884, 12893)) {
                            result = CallChecker.isCalled(npe_invocation_var45, String.class, 364, 12884, 12893).hashCode();
                            CallChecker.varAssign(result, "result", 364, 12884, 12893);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 365, 12946, 12962).hashCode());
                        CallChecker.varAssign(result, "result", 365, 12923, 12974);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context411.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context412.methodEnd();
        }
    }

    public static LogMessage FLOW_TO_DISK_INACTIVE(Number param1, Number param2) {
        MethodContext _bcornu_methode_context417 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 378, 13043, 14888);
            CallChecker.varInit(param1, "param1", 378, 13043, 14888);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 378, 13043, 14888);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 378, 13043, 14888);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 378, 13043, 14888);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 380, 13465, 13473)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 380, 13465, 13473);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 380, 13465, 13473).getString("FLOW_TO_DISK_INACTIVE");
                CallChecker.varAssign(rawMessage, "rawMessage", 380, 13465, 13473);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 382, 13520, 13570);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 385, 13720, 13791);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 387, 13825, 13833);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 387, 13825, 13833).format(messageArguments), "message", 387, 13802, 13859);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context413 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 391, 13916, 13999);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context413.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context414 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 396, 14014, 14132);
                        return BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context414.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context415 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 402, 14147, 14634);
                        CallChecker.varInit(o, "o", 402, 14147, 14634);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 413, 14469, 14507);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 415, 14558, 14561)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 415, 14603, 14606)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 415, 14533, 14549).equals(CallChecker.isCalled(that, LogMessage.class, 415, 14558, 14561).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 415, 14585, 14594).equals(CallChecker.isCalled(that, LogMessage.class, 415, 14603, 14606).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context415.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context416 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 420, 14649, 14871);
                        final String npe_invocation_var46 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var46, String.class, 422, 14736, 14745)) {
                            result = CallChecker.isCalled(npe_invocation_var46, String.class, 422, 14736, 14745).hashCode();
                            CallChecker.varAssign(result, "result", 422, 14736, 14745);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 423, 14798, 14814).hashCode());
                        CallChecker.varAssign(result, "result", 423, 14775, 14826);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context416.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context417.methodEnd();
        }
    }

    public static LogMessage FLOW_TO_DISK_ACTIVE(Number param1, Number param2) {
        MethodContext _bcornu_methode_context422 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 436, 14895, 16734);
            CallChecker.varInit(param1, "param1", 436, 14895, 16734);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 436, 14895, 16734);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 436, 14895, 16734);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 436, 14895, 16734);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 438, 15315, 15323)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 438, 15315, 15323);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 438, 15315, 15323).getString("FLOW_TO_DISK_ACTIVE");
                CallChecker.varAssign(rawMessage, "rawMessage", 438, 15315, 15323);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 440, 15368, 15418);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 443, 15568, 15639);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 445, 15673, 15681);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 445, 15673, 15681).format(messageArguments), "message", 445, 15650, 15707);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context418 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 449, 15764, 15847);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context418.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context419 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 454, 15862, 15978);
                        return BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context419.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context420 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 460, 15993, 16480);
                        CallChecker.varInit(o, "o", 460, 15993, 16480);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 471, 16315, 16353);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 473, 16404, 16407)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 473, 16449, 16452)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 473, 16379, 16395).equals(CallChecker.isCalled(that, LogMessage.class, 473, 16404, 16407).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 473, 16431, 16440).equals(CallChecker.isCalled(that, LogMessage.class, 473, 16449, 16452).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context420.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context421 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 478, 16495, 16717);
                        final String npe_invocation_var47 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var47, String.class, 480, 16582, 16591)) {
                            result = CallChecker.isCalled(npe_invocation_var47, String.class, 480, 16582, 16591).hashCode();
                            CallChecker.varAssign(result, "result", 480, 16582, 16591);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 481, 16644, 16660).hashCode());
                        CallChecker.varAssign(result, "result", 481, 16621, 16672);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context421.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context422.methodEnd();
        }
    }

    public static LogMessage MAX_MEMORY(Number param1) {
        MethodContext _bcornu_methode_context427 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 494, 16741, 18463);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 494, 16741, 18463);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 494, 16741, 18463);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 494, 16741, 18463);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 496, 17070, 17078)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 496, 17070, 17078);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 496, 17070, 17078).getString("MAX_MEMORY");
                CallChecker.varAssign(rawMessage, "rawMessage", 496, 17070, 17078);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 498, 17114, 17156);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 501, 17306, 17377);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 503, 17411, 17419);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 503, 17411, 17419).format(messageArguments), "message", 503, 17388, 17445);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context423 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 507, 17502, 17585);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context423.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context424 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 512, 17600, 17707);
                        return BrokerMessages.MAX_MEMORY_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context424.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context425 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 518, 17722, 18209);
                        CallChecker.varInit(o, "o", 518, 17722, 18209);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 529, 18044, 18082);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 531, 18133, 18136)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 531, 18178, 18181)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 531, 18108, 18124).equals(CallChecker.isCalled(that, LogMessage.class, 531, 18133, 18136).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 531, 18160, 18169).equals(CallChecker.isCalled(that, LogMessage.class, 531, 18178, 18181).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context425.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context426 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 536, 18224, 18446);
                        final String npe_invocation_var48 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var48, String.class, 538, 18311, 18320)) {
                            result = CallChecker.isCalled(npe_invocation_var48, String.class, 538, 18311, 18320).hashCode();
                            CallChecker.varAssign(result, "result", 538, 18311, 18320);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 539, 18373, 18389).hashCode());
                        CallChecker.varAssign(result, "result", 539, 18350, 18401);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context426.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context427.methodEnd();
        }
    }

    public static LogMessage PLATFORM(String param1, String param2, String param3, String param4, String param5) {
        MethodContext _bcornu_methode_context432 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param5, "param5", 552, 18470, 20310);
            CallChecker.varInit(param4, "param4", 552, 18470, 20310);
            CallChecker.varInit(param3, "param3", 552, 18470, 20310);
            CallChecker.varInit(param2, "param2", 552, 18470, 20310);
            CallChecker.varInit(param1, "param1", 552, 18470, 20310);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 552, 18470, 20310);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 552, 18470, 20310);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 552, 18470, 20310);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 554, 18889, 18897)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 554, 18889, 18897);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 554, 18889, 18897).getString("PLATFORM");
                CallChecker.varAssign(rawMessage, "rawMessage", 554, 18889, 18897);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 , param4 , param5 }, "messageArguments", 556, 18931, 19005);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 559, 19155, 19226);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 561, 19260, 19268);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 561, 19260, 19268).format(messageArguments), "message", 561, 19237, 19294);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context428 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 565, 19351, 19434);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context428.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context429 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 570, 19449, 19554);
                        return BrokerMessages.PLATFORM_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context429.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context430 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 576, 19569, 20056);
                        CallChecker.varInit(o, "o", 576, 19569, 20056);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 587, 19891, 19929);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 589, 19980, 19983)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 589, 20025, 20028)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 589, 19955, 19971).equals(CallChecker.isCalled(that, LogMessage.class, 589, 19980, 19983).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 589, 20007, 20016).equals(CallChecker.isCalled(that, LogMessage.class, 589, 20025, 20028).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context430.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context431 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 594, 20071, 20293);
                        final String npe_invocation_var49 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var49, String.class, 596, 20158, 20167)) {
                            result = CallChecker.isCalled(npe_invocation_var49, String.class, 596, 20158, 20167).hashCode();
                            CallChecker.varAssign(result, "result", 596, 20158, 20167);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 597, 20220, 20236).hashCode());
                        CallChecker.varAssign(result, "result", 597, 20197, 20248);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context431.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context432.methodEnd();
        }
    }

    public static LogMessage PROCESS(String param1) {
        MethodContext _bcornu_methode_context437 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 610, 20317, 22016);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 610, 20317, 22016);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 610, 20317, 22016);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 610, 20317, 22016);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 612, 20629, 20637)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 612, 20629, 20637);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 612, 20629, 20637).getString("PROCESS");
                CallChecker.varAssign(rawMessage, "rawMessage", 612, 20629, 20637);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 614, 20670, 20712);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 617, 20862, 20933);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 619, 20967, 20975);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 619, 20967, 20975).format(messageArguments), "message", 619, 20944, 21001);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context433 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 623, 21058, 21141);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context433.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context434 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 628, 21156, 21260);
                        return BrokerMessages.PROCESS_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context434.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context435 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 634, 21275, 21762);
                        CallChecker.varInit(o, "o", 634, 21275, 21762);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 645, 21597, 21635);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 647, 21686, 21689)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 647, 21731, 21734)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 647, 21661, 21677).equals(CallChecker.isCalled(that, LogMessage.class, 647, 21686, 21689).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 647, 21713, 21722).equals(CallChecker.isCalled(that, LogMessage.class, 647, 21731, 21734).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context435.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context436 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 652, 21777, 21999);
                        final String npe_invocation_var50 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var50, String.class, 654, 21864, 21873)) {
                            result = CallChecker.isCalled(npe_invocation_var50, String.class, 654, 21864, 21873).hashCode();
                            CallChecker.varAssign(result, "result", 654, 21864, 21873);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 655, 21926, 21942).hashCode());
                        CallChecker.varAssign(result, "result", 655, 21903, 21954);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context436.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context437.methodEnd();
        }
    }

    public static LogMessage SHUTTING_DOWN(String param1, Number param2) {
        MethodContext _bcornu_methode_context442 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 668, 22023, 23781);
            CallChecker.varInit(param1, "param1", 668, 22023, 23781);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 668, 22023, 23781);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 668, 22023, 23781);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 668, 22023, 23781);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 670, 22374, 22382)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 670, 22374, 22382);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 670, 22374, 22382).getString("SHUTTING_DOWN");
                CallChecker.varAssign(rawMessage, "rawMessage", 670, 22374, 22382);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 672, 22421, 22471);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 675, 22621, 22692);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 677, 22726, 22734);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 677, 22726, 22734).format(messageArguments), "message", 677, 22703, 22760);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context438 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 681, 22817, 22900);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context438.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context439 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 686, 22915, 23025);
                        return BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context439.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context440 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 692, 23040, 23527);
                        CallChecker.varInit(o, "o", 692, 23040, 23527);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 703, 23362, 23400);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 705, 23451, 23454)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 705, 23496, 23499)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 705, 23426, 23442).equals(CallChecker.isCalled(that, LogMessage.class, 705, 23451, 23454).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 705, 23478, 23487).equals(CallChecker.isCalled(that, LogMessage.class, 705, 23496, 23499).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context440.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context441 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 710, 23542, 23764);
                        final String npe_invocation_var51 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var51, String.class, 712, 23629, 23638)) {
                            result = CallChecker.isCalled(npe_invocation_var51, String.class, 712, 23629, 23638).hashCode();
                            CallChecker.varAssign(result, "result", 712, 23629, 23638);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 713, 23691, 23707).hashCode());
                        CallChecker.varAssign(result, "result", 713, 23668, 23719);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context441.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context442.methodEnd();
        }
    }

    public static LogMessage MANAGEMENT_MODE(String param1, String param2) {
        MethodContext _bcornu_methode_context447 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 726, 23788, 25557);
            CallChecker.varInit(param1, "param1", 726, 23788, 25557);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 726, 23788, 25557);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 726, 23788, 25557);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 726, 23788, 25557);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 728, 24146, 24154)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 728, 24146, 24154);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 728, 24146, 24154).getString("MANAGEMENT_MODE");
                CallChecker.varAssign(rawMessage, "rawMessage", 728, 24146, 24154);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 730, 24195, 24245);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 733, 24395, 24466);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 735, 24500, 24508);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 735, 24500, 24508).format(messageArguments), "message", 735, 24477, 24534);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context443 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 739, 24591, 24674);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context443.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context444 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 744, 24689, 24801);
                        return BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context444.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context445 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 750, 24816, 25303);
                        CallChecker.varInit(o, "o", 750, 24816, 25303);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 761, 25138, 25176);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 763, 25227, 25230)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 763, 25272, 25275)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 763, 25202, 25218).equals(CallChecker.isCalled(that, LogMessage.class, 763, 25227, 25230).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 763, 25254, 25263).equals(CallChecker.isCalled(that, LogMessage.class, 763, 25272, 25275).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context445.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context446 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 768, 25318, 25540);
                        final String npe_invocation_var52 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var52, String.class, 770, 25405, 25414)) {
                            result = CallChecker.isCalled(npe_invocation_var52, String.class, 770, 25405, 25414).hashCode();
                            CallChecker.varAssign(result, "result", 770, 25405, 25414);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 771, 25467, 25483).hashCode());
                        CallChecker.varAssign(result, "result", 771, 25444, 25495);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context446.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context447.methodEnd();
        }
    }

    public static LogMessage STARTUP(String param1, String param2) {
        MethodContext _bcornu_methode_context452 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 784, 25564, 27300);
            CallChecker.varInit(param1, "param1", 784, 25564, 27300);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 784, 25564, 27300);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 784, 25564, 27300);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 784, 25564, 27300);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 786, 25905, 25913)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 786, 25905, 25913);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 786, 25905, 25913).getString("STARTUP");
                CallChecker.varAssign(rawMessage, "rawMessage", 786, 25905, 25913);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 788, 25946, 25996);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 791, 26146, 26217);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 793, 26251, 26259);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 793, 26251, 26259).format(messageArguments), "message", 793, 26228, 26285);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context448 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 797, 26342, 26425);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context448.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context449 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 802, 26440, 26544);
                        return BrokerMessages.STARTUP_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context449.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context450 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 808, 26559, 27046);
                        CallChecker.varInit(o, "o", 808, 26559, 27046);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 819, 26881, 26919);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 821, 26970, 26973)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 821, 27015, 27018)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 821, 26945, 26961).equals(CallChecker.isCalled(that, LogMessage.class, 821, 26970, 26973).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 821, 26997, 27006).equals(CallChecker.isCalled(that, LogMessage.class, 821, 27015, 27018).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context450.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context451 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 826, 27061, 27283);
                        final String npe_invocation_var53 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var53, String.class, 828, 27148, 27157)) {
                            result = CallChecker.isCalled(npe_invocation_var53, String.class, 828, 27148, 27157).hashCode();
                            CallChecker.varAssign(result, "result", 828, 27148, 27157);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 829, 27210, 27226).hashCode());
                        CallChecker.varAssign(result, "result", 829, 27187, 27238);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context451.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context452.methodEnd();
        }
    }

    public static LogMessage FATAL_ERROR(String param1) {
        MethodContext _bcornu_methode_context457 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 842, 27307, 29052);
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 842, 27307, 29052);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 842, 27307, 29052);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 842, 27307, 29052);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 844, 27657, 27665)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 844, 27657, 27665);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 844, 27657, 27665).getString("FATAL_ERROR");
                CallChecker.varAssign(rawMessage, "rawMessage", 844, 27657, 27665);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 846, 27702, 27744);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BrokerMessages._currentLocale), "formatter", 849, 27894, 27965);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 851, 27999, 28007);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 851, 27999, 28007).format(messageArguments), "message", 851, 27976, 28033);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context453 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 855, 28090, 28173);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context453.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context454 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 860, 28188, 28296);
                        return BrokerMessages.FATAL_ERROR_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context454.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context455 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 866, 28311, 28798);
                        CallChecker.varInit(o, "o", 866, 28311, 28798);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 877, 28633, 28671);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 879, 28722, 28725)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 879, 28767, 28770)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 879, 28697, 28713).equals(CallChecker.isCalled(that, LogMessage.class, 879, 28722, 28725).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 879, 28749, 28758).equals(CallChecker.isCalled(that, LogMessage.class, 879, 28767, 28770).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context455.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context456 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 884, 28813, 29035);
                        final String npe_invocation_var54 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var54, String.class, 886, 28900, 28909)) {
                            result = CallChecker.isCalled(npe_invocation_var54, String.class, 886, 28900, 28909).hashCode();
                            CallChecker.varAssign(result, "result", 886, 28900, 28909);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 887, 28962, 28978).hashCode());
                        CallChecker.varAssign(result, "result", 887, 28939, 28990);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context456.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context457.methodEnd();
        }
    }

    public static LogMessage READY() {
        MethodContext _bcornu_methode_context462 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(READY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.READY_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(FATAL_ERROR_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FATAL_ERROR_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(STARTUP_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STARTUP_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(MANAGEMENT_MODE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MANAGEMENT_MODE_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(SHUTTING_DOWN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.SHUTTING_DOWN_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(PROCESS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PROCESS_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(PLATFORM_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.PLATFORM_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(MAX_MEMORY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.MAX_MEMORY_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_ACTIVE_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.FLOW_TO_DISK_INACTIVE_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(LISTENING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.LISTENING_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(STATS_MSGS_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_MSGS_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(STOPPED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STOPPED_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(STATS_DATA_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.STATS_DATA_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(CONFIG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.CONFIG_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(BROKER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BrokerMessages.BROKER_LOG_HIERARCHY", 900, 29059, 30439);
            CallChecker.varInit(BrokerMessages._currentLocale, "org.apache.qpid.server.logging.messages.BrokerMessages._currentLocale", 900, 29059, 30439);
            CallChecker.varInit(BrokerMessages._messages, "org.apache.qpid.server.logging.messages.BrokerMessages._messages", 900, 29059, 30439);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BrokerMessages._messages, ResourceBundle.class, 902, 29354, 29362)) {
                BrokerMessages._messages = CallChecker.beforeCalled(BrokerMessages._messages, ResourceBundle.class, 902, 29354, 29362);
                rawMessage = CallChecker.isCalled(BrokerMessages._messages, ResourceBundle.class, 902, 29354, 29362).getString("READY");
                CallChecker.varAssign(rawMessage, "rawMessage", 902, 29354, 29362);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 904, 29393, 29426);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context458 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 908, 29483, 29566);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context458.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context459 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 913, 29581, 29683);
                        return BrokerMessages.READY_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context459.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context460 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 919, 29698, 30185);
                        CallChecker.varInit(o, "o", 919, 29698, 30185);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 930, 30020, 30058);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 932, 30109, 30112)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 932, 30154, 30157)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 932, 30084, 30100).equals(CallChecker.isCalled(that, LogMessage.class, 932, 30109, 30112).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 932, 30136, 30145).equals(CallChecker.isCalled(that, LogMessage.class, 932, 30154, 30157).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context460.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context461 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 937, 30200, 30422);
                        final String npe_invocation_var55 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var55, String.class, 939, 30287, 30296)) {
                            result = CallChecker.isCalled(npe_invocation_var55, String.class, 939, 30287, 30296).hashCode();
                            CallChecker.varAssign(result, "result", 939, 30287, 30296);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 940, 30349, 30365).hashCode());
                        CallChecker.varAssign(result, "result", 940, 30326, 30377);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context461.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context462.methodEnd();
        }
    }

    private BrokerMessages() {
        MethodContext _bcornu_methode_context30 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }
}

