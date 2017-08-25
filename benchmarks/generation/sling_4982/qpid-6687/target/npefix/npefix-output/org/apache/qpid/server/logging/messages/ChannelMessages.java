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

public class ChannelMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String CHANNEL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel";

    public static final String FLOW_ENFORCED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.flow_enforced";

    public static final String CREATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.create";

    public static final String FLOW_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.flow";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.close";

    public static final String PREFETCH_SIZE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.prefetch_size";

    public static final String CLOSE_FORCED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.close_forced";

    public static final String LARGE_TRANSACTION_WARN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.large_transaction_warn";

    public static final String DEADLETTERMSG_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.deadlettermsg";

    public static final String DISCARDMSG_NOALTEXCH_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.discardmsg_noaltexch";

    public static final String IDLE_TXN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.idle_txn";

    public static final String FLOW_CONTROL_IGNORED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.flow_control_ignored";

    public static final String DISCARDMSG_NOROUTE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.discardmsg_noroute";

    public static final String OPEN_TXN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.open_txn";

    public static final String FLOW_REMOVED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "channel.flow_removed";

    static {
        LoggerFactory.getLogger(ChannelMessages.CHANNEL_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.CREATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.FLOW_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.CLOSE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.IDLE_TXN_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.OPEN_TXN_LOG_HIERARCHY);
        LoggerFactory.getLogger(ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY);
        ChannelMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Channel_logmessages", ChannelMessages._currentLocale);
        CallChecker.varAssign(ChannelMessages._messages, "ChannelMessages._messages", 81, 4329, 4444);
    }

    public static LogMessage FLOW_ENFORCED(String param1) {
        MethodContext _bcornu_methode_context641 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 91, 4457, 6189);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 91, 4457, 6189);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 91, 4457, 6189);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 91, 4457, 6189);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 93, 4790, 4798)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 93, 4790, 4798);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 93, 4790, 4798).getString("FLOW_ENFORCED");
                CallChecker.varAssign(rawMessage, "rawMessage", 93, 4790, 4798);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 95, 4837, 4879);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 98, 5029, 5100);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 100, 5134, 5142);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 100, 5134, 5142).format(messageArguments), "message", 100, 5111, 5168);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context637 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 104, 5225, 5308);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context637.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context638 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 109, 5323, 5433);
                        return ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context638.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context639 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 115, 5448, 5935);
                        CallChecker.varInit(o, "o", 115, 5448, 5935);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 126, 5770, 5808);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 128, 5859, 5862)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 128, 5904, 5907)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 128, 5834, 5850).equals(CallChecker.isCalled(that, LogMessage.class, 128, 5859, 5862).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 128, 5886, 5895).equals(CallChecker.isCalled(that, LogMessage.class, 128, 5904, 5907).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context639.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context640 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 133, 5950, 6172);
                        final String npe_invocation_var82 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var82, String.class, 135, 6037, 6046)) {
                            result = CallChecker.isCalled(npe_invocation_var82, String.class, 135, 6037, 6046).hashCode();
                            CallChecker.varAssign(result, "result", 135, 6037, 6046);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 136, 6099, 6115).hashCode());
                        CallChecker.varAssign(result, "result", 136, 6076, 6127);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context640.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context641.methodEnd();
        }
    }

    public static LogMessage CREATE() {
        MethodContext _bcornu_methode_context646 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 149, 6196, 7569);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 149, 6196, 7569);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 149, 6196, 7569);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 151, 6482, 6490)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 151, 6482, 6490);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 151, 6482, 6490).getString("CREATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 151, 6482, 6490);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 153, 6522, 6555);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context642 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 157, 6612, 6695);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context642.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context643 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 162, 6710, 6813);
                        return ChannelMessages.CREATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context643.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context644 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 168, 6828, 7315);
                        CallChecker.varInit(o, "o", 168, 6828, 7315);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 179, 7150, 7188);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 181, 7239, 7242)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 181, 7284, 7287)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 181, 7214, 7230).equals(CallChecker.isCalled(that, LogMessage.class, 181, 7239, 7242).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 181, 7266, 7275).equals(CallChecker.isCalled(that, LogMessage.class, 181, 7284, 7287).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context644.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context645 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 186, 7330, 7552);
                        final String npe_invocation_var83 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var83, String.class, 188, 7417, 7426)) {
                            result = CallChecker.isCalled(npe_invocation_var83, String.class, 188, 7417, 7426).hashCode();
                            CallChecker.varAssign(result, "result", 188, 7417, 7426);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 189, 7479, 7495).hashCode());
                        CallChecker.varAssign(result, "result", 189, 7456, 7507);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context645.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context646.methodEnd();
        }
    }

    public static LogMessage FLOW(String param1) {
        MethodContext _bcornu_methode_context651 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 202, 7576, 9256);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 202, 7576, 9256);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 202, 7576, 9256);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 202, 7576, 9256);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 204, 7875, 7883)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 204, 7875, 7883);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 204, 7875, 7883).getString("FLOW");
                CallChecker.varAssign(rawMessage, "rawMessage", 204, 7875, 7883);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 206, 7913, 7955);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 209, 8105, 8176);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 211, 8210, 8218);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 211, 8210, 8218).format(messageArguments), "message", 211, 8187, 8244);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context647 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 215, 8301, 8384);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context647.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context648 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 220, 8399, 8500);
                        return ChannelMessages.FLOW_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context648.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context649 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 226, 8515, 9002);
                        CallChecker.varInit(o, "o", 226, 8515, 9002);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 237, 8837, 8875);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 239, 8926, 8929)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 239, 8971, 8974)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 239, 8901, 8917).equals(CallChecker.isCalled(that, LogMessage.class, 239, 8926, 8929).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 239, 8953, 8962).equals(CallChecker.isCalled(that, LogMessage.class, 239, 8971, 8974).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context649.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context650 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 244, 9017, 9239);
                        final String npe_invocation_var84 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var84, String.class, 246, 9104, 9113)) {
                            result = CallChecker.isCalled(npe_invocation_var84, String.class, 246, 9104, 9113).hashCode();
                            CallChecker.varAssign(result, "result", 246, 9104, 9113);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 247, 9166, 9182).hashCode());
                        CallChecker.varAssign(result, "result", 247, 9143, 9194);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context650.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context651.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context656 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 260, 9263, 10632);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 260, 9263, 10632);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 260, 9263, 10632);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 262, 9547, 9555)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 262, 9547, 9555);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 262, 9547, 9555).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 262, 9547, 9555);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 264, 9586, 9619);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context652 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 268, 9676, 9759);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context652.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context653 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 273, 9774, 9876);
                        return ChannelMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context653.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context654 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 279, 9891, 10378);
                        CallChecker.varInit(o, "o", 279, 9891, 10378);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 290, 10213, 10251);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 292, 10302, 10305)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 292, 10347, 10350)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 292, 10277, 10293).equals(CallChecker.isCalled(that, LogMessage.class, 292, 10302, 10305).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 292, 10329, 10338).equals(CallChecker.isCalled(that, LogMessage.class, 292, 10347, 10350).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context654.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context655 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 297, 10393, 10615);
                        final String npe_invocation_var85 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var85, String.class, 299, 10480, 10489)) {
                            result = CallChecker.isCalled(npe_invocation_var85, String.class, 299, 10480, 10489).hashCode();
                            CallChecker.varAssign(result, "result", 299, 10480, 10489);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 300, 10542, 10558).hashCode());
                        CallChecker.varAssign(result, "result", 300, 10519, 10570);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context655.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context656.methodEnd();
        }
    }

    public static LogMessage PREFETCH_SIZE(Number param1, Number param2) {
        MethodContext _bcornu_methode_context661 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 313, 10639, 12412);
            CallChecker.varInit(param1, "param1", 313, 10639, 12412);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 313, 10639, 12412);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 313, 10639, 12412);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 313, 10639, 12412);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 315, 11005, 11013)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 315, 11005, 11013);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 315, 11005, 11013).getString("PREFETCH_SIZE");
                CallChecker.varAssign(rawMessage, "rawMessage", 315, 11005, 11013);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 317, 11052, 11102);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 320, 11252, 11323);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 322, 11357, 11365);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 322, 11357, 11365).format(messageArguments), "message", 322, 11334, 11391);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context657 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 326, 11448, 11531);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context657.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context658 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 331, 11546, 11656);
                        return ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context658.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context659 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 337, 11671, 12158);
                        CallChecker.varInit(o, "o", 337, 11671, 12158);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 348, 11993, 12031);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 350, 12082, 12085)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 350, 12127, 12130)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 350, 12057, 12073).equals(CallChecker.isCalled(that, LogMessage.class, 350, 12082, 12085).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 350, 12109, 12118).equals(CallChecker.isCalled(that, LogMessage.class, 350, 12127, 12130).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context659.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context660 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 355, 12173, 12395);
                        final String npe_invocation_var86 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var86, String.class, 357, 12260, 12269)) {
                            result = CallChecker.isCalled(npe_invocation_var86, String.class, 357, 12260, 12269).hashCode();
                            CallChecker.varAssign(result, "result", 357, 12260, 12269);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 358, 12322, 12338).hashCode());
                        CallChecker.varAssign(result, "result", 358, 12299, 12350);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context660.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context661.methodEnd();
        }
    }

    public static LogMessage CLOSE_FORCED(Number param1, String param2) {
        MethodContext _bcornu_methode_context666 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 371, 12419, 14162);
            CallChecker.varInit(param1, "param1", 371, 12419, 14162);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 371, 12419, 14162);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 371, 12419, 14162);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 371, 12419, 14162);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 373, 12757, 12765)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 373, 12757, 12765);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 373, 12757, 12765).getString("CLOSE_FORCED");
                CallChecker.varAssign(rawMessage, "rawMessage", 373, 12757, 12765);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 375, 12803, 12853);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 378, 13003, 13074);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 380, 13108, 13116);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 380, 13108, 13116).format(messageArguments), "message", 380, 13085, 13142);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context662 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 384, 13199, 13282);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context662.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context663 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 389, 13297, 13406);
                        return ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context663.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context664 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 395, 13421, 13908);
                        CallChecker.varInit(o, "o", 395, 13421, 13908);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 406, 13743, 13781);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 408, 13832, 13835)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 408, 13877, 13880)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 408, 13807, 13823).equals(CallChecker.isCalled(that, LogMessage.class, 408, 13832, 13835).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 408, 13859, 13868).equals(CallChecker.isCalled(that, LogMessage.class, 408, 13877, 13880).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context664.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context665 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 413, 13923, 14145);
                        final String npe_invocation_var87 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var87, String.class, 415, 14010, 14019)) {
                            result = CallChecker.isCalled(npe_invocation_var87, String.class, 415, 14010, 14019).hashCode();
                            CallChecker.varAssign(result, "result", 415, 14010, 14019);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 416, 14072, 14088).hashCode());
                        CallChecker.varAssign(result, "result", 416, 14049, 14100);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context665.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context666.methodEnd();
        }
    }

    public static LogMessage LARGE_TRANSACTION_WARN(Number param1) {
        MethodContext _bcornu_methode_context671 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 429, 14169, 15970);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 429, 14169, 15970);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 429, 14169, 15970);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 429, 14169, 15970);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 431, 14553, 14561)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 431, 14553, 14561);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 431, 14553, 14561).getString("LARGE_TRANSACTION_WARN");
                CallChecker.varAssign(rawMessage, "rawMessage", 431, 14553, 14561);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 433, 14609, 14651);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 436, 14801, 14872);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 438, 14906, 14914);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 438, 14906, 14914).format(messageArguments), "message", 438, 14883, 14940);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context667 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 442, 14997, 15080);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context667.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context668 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 447, 15095, 15214);
                        return ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context668.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context669 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 453, 15229, 15716);
                        CallChecker.varInit(o, "o", 453, 15229, 15716);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 464, 15551, 15589);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 466, 15640, 15643)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 466, 15685, 15688)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 466, 15615, 15631).equals(CallChecker.isCalled(that, LogMessage.class, 466, 15640, 15643).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 466, 15667, 15676).equals(CallChecker.isCalled(that, LogMessage.class, 466, 15685, 15688).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context669.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context670 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 471, 15731, 15953);
                        final String npe_invocation_var88 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var88, String.class, 473, 15818, 15827)) {
                            result = CallChecker.isCalled(npe_invocation_var88, String.class, 473, 15818, 15827).hashCode();
                            CallChecker.varAssign(result, "result", 473, 15818, 15827);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 474, 15880, 15896).hashCode());
                        CallChecker.varAssign(result, "result", 474, 15857, 15908);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context670.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context671.methodEnd();
        }
    }

    public static LogMessage DEADLETTERMSG(Number param1, String param2) {
        MethodContext _bcornu_methode_context676 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 487, 15977, 17752);
            CallChecker.varInit(param1, "param1", 487, 15977, 17752);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 487, 15977, 17752);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 487, 15977, 17752);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 487, 15977, 17752);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 489, 16345, 16353)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 489, 16345, 16353);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 489, 16345, 16353).getString("DEADLETTERMSG");
                CallChecker.varAssign(rawMessage, "rawMessage", 489, 16345, 16353);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 491, 16392, 16442);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 494, 16592, 16663);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 496, 16697, 16705);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 496, 16697, 16705).format(messageArguments), "message", 496, 16674, 16731);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context672 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 500, 16788, 16871);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context672.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context673 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 505, 16886, 16996);
                        return ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context673.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context674 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 511, 17011, 17498);
                        CallChecker.varInit(o, "o", 511, 17011, 17498);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 522, 17333, 17371);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 524, 17422, 17425)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 524, 17467, 17470)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 524, 17397, 17413).equals(CallChecker.isCalled(that, LogMessage.class, 524, 17422, 17425).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 524, 17449, 17458).equals(CallChecker.isCalled(that, LogMessage.class, 524, 17467, 17470).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context674.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context675 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 529, 17513, 17735);
                        final String npe_invocation_var89 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var89, String.class, 531, 17600, 17609)) {
                            result = CallChecker.isCalled(npe_invocation_var89, String.class, 531, 17600, 17609).hashCode();
                            CallChecker.varAssign(result, "result", 531, 17600, 17609);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 532, 17662, 17678).hashCode());
                        CallChecker.varAssign(result, "result", 532, 17639, 17690);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context675.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context676.methodEnd();
        }
    }

    public static LogMessage DISCARDMSG_NOALTEXCH(Number param1, String param2, String param3) {
        MethodContext _bcornu_methode_context681 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param3, "param3", 545, 17759, 19625);
            CallChecker.varInit(param2, "param2", 545, 17759, 19625);
            CallChecker.varInit(param1, "param1", 545, 17759, 19625);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 545, 17759, 19625);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 545, 17759, 19625);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 545, 17759, 19625);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 547, 18196, 18204)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 547, 18196, 18204);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 547, 18196, 18204).getString("DISCARDMSG_NOALTEXCH");
                CallChecker.varAssign(rawMessage, "rawMessage", 547, 18196, 18204);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 }, "messageArguments", 549, 18250, 18308);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 552, 18458, 18529);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 554, 18563, 18571);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 554, 18563, 18571).format(messageArguments), "message", 554, 18540, 18597);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context677 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 558, 18654, 18737);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context677.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context678 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 563, 18752, 18869);
                        return ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context678.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context679 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 569, 18884, 19371);
                        CallChecker.varInit(o, "o", 569, 18884, 19371);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 580, 19206, 19244);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 582, 19295, 19298)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 582, 19340, 19343)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 582, 19270, 19286).equals(CallChecker.isCalled(that, LogMessage.class, 582, 19295, 19298).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 582, 19322, 19331).equals(CallChecker.isCalled(that, LogMessage.class, 582, 19340, 19343).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context679.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context680 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 587, 19386, 19608);
                        final String npe_invocation_var90 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var90, String.class, 589, 19473, 19482)) {
                            result = CallChecker.isCalled(npe_invocation_var90, String.class, 589, 19473, 19482).hashCode();
                            CallChecker.varAssign(result, "result", 589, 19473, 19482);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 590, 19535, 19551).hashCode());
                        CallChecker.varAssign(result, "result", 590, 19512, 19563);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context680.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context681.methodEnd();
        }
    }

    public static LogMessage IDLE_TXN(Number param1) {
        MethodContext _bcornu_methode_context686 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 603, 19632, 21348);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 603, 19632, 21348);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 603, 19632, 21348);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 603, 19632, 21348);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 605, 19959, 19967)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 605, 19959, 19967);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 605, 19959, 19967).getString("IDLE_TXN");
                CallChecker.varAssign(rawMessage, "rawMessage", 605, 19959, 19967);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 607, 20001, 20043);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 610, 20193, 20264);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 612, 20298, 20306);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 612, 20298, 20306).format(messageArguments), "message", 612, 20275, 20332);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context682 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 616, 20389, 20472);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context682.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context683 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 621, 20487, 20592);
                        return ChannelMessages.IDLE_TXN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context683.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context684 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 627, 20607, 21094);
                        CallChecker.varInit(o, "o", 627, 20607, 21094);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 638, 20929, 20967);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 640, 21018, 21021)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 640, 21063, 21066)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 640, 20993, 21009).equals(CallChecker.isCalled(that, LogMessage.class, 640, 21018, 21021).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 640, 21045, 21054).equals(CallChecker.isCalled(that, LogMessage.class, 640, 21063, 21066).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context684.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context685 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 645, 21109, 21331);
                        final String npe_invocation_var91 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var91, String.class, 647, 21196, 21205)) {
                            result = CallChecker.isCalled(npe_invocation_var91, String.class, 647, 21196, 21205).hashCode();
                            CallChecker.varAssign(result, "result", 647, 21196, 21205);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 648, 21258, 21274).hashCode());
                        CallChecker.varAssign(result, "result", 648, 21235, 21286);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context685.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context686.methodEnd();
        }
    }

    public static LogMessage FLOW_CONTROL_IGNORED() {
        MethodContext _bcornu_methode_context691 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 661, 21355, 22809);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 661, 21355, 22809);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 661, 21355, 22809);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 663, 21694, 21702)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 663, 21694, 21702);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 663, 21694, 21702).getString("FLOW_CONTROL_IGNORED");
                CallChecker.varAssign(rawMessage, "rawMessage", 663, 21694, 21702);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 665, 21748, 21781);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context687 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 669, 21838, 21921);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context687.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context688 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 674, 21936, 22053);
                        return ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context688.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context689 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 680, 22068, 22555);
                        CallChecker.varInit(o, "o", 680, 22068, 22555);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 691, 22390, 22428);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 693, 22479, 22482)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 693, 22524, 22527)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 693, 22454, 22470).equals(CallChecker.isCalled(that, LogMessage.class, 693, 22479, 22482).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 693, 22506, 22515).equals(CallChecker.isCalled(that, LogMessage.class, 693, 22524, 22527).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context689.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context690 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 698, 22570, 22792);
                        final String npe_invocation_var92 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var92, String.class, 700, 22657, 22666)) {
                            result = CallChecker.isCalled(npe_invocation_var92, String.class, 700, 22657, 22666).hashCode();
                            CallChecker.varAssign(result, "result", 700, 22657, 22666);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 701, 22719, 22735).hashCode());
                        CallChecker.varAssign(result, "result", 701, 22696, 22747);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context690.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context691.methodEnd();
        }
    }

    public static LogMessage DISCARDMSG_NOROUTE(Number param1, String param2) {
        MethodContext _bcornu_methode_context696 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 714, 22816, 24625);
            CallChecker.varInit(param1, "param1", 714, 22816, 24625);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 714, 22816, 24625);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 714, 22816, 24625);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 714, 22816, 24625);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 716, 23208, 23216)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 716, 23208, 23216);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 716, 23208, 23216).getString("DISCARDMSG_NOROUTE");
                CallChecker.varAssign(rawMessage, "rawMessage", 716, 23208, 23216);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 718, 23260, 23310);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 721, 23460, 23531);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 723, 23565, 23573);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 723, 23565, 23573).format(messageArguments), "message", 723, 23542, 23599);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context692 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 727, 23656, 23739);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context692.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context693 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 732, 23754, 23869);
                        return ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context693.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context694 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 738, 23884, 24371);
                        CallChecker.varInit(o, "o", 738, 23884, 24371);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 749, 24206, 24244);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 751, 24295, 24298)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 751, 24340, 24343)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 751, 24270, 24286).equals(CallChecker.isCalled(that, LogMessage.class, 751, 24295, 24298).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 751, 24322, 24331).equals(CallChecker.isCalled(that, LogMessage.class, 751, 24340, 24343).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context694.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context695 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 756, 24386, 24608);
                        final String npe_invocation_var93 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var93, String.class, 758, 24473, 24482)) {
                            result = CallChecker.isCalled(npe_invocation_var93, String.class, 758, 24473, 24482).hashCode();
                            CallChecker.varAssign(result, "result", 758, 24473, 24482);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 759, 24535, 24551).hashCode());
                        CallChecker.varAssign(result, "result", 759, 24512, 24563);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context695.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context696.methodEnd();
        }
    }

    public static LogMessage OPEN_TXN(Number param1) {
        MethodContext _bcornu_methode_context701 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 772, 24632, 26348);
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 772, 24632, 26348);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 772, 24632, 26348);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 772, 24632, 26348);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 774, 24959, 24967)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 774, 24959, 24967);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 774, 24959, 24967).getString("OPEN_TXN");
                CallChecker.varAssign(rawMessage, "rawMessage", 774, 24959, 24967);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 776, 25001, 25043);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ChannelMessages._currentLocale), "formatter", 779, 25193, 25264);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 781, 25298, 25306);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 781, 25298, 25306).format(messageArguments), "message", 781, 25275, 25332);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context697 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 785, 25389, 25472);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context697.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context698 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 790, 25487, 25592);
                        return ChannelMessages.OPEN_TXN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context698.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context699 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 796, 25607, 26094);
                        CallChecker.varInit(o, "o", 796, 25607, 26094);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 807, 25929, 25967);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 809, 26018, 26021)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 809, 26063, 26066)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 809, 25993, 26009).equals(CallChecker.isCalled(that, LogMessage.class, 809, 26018, 26021).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 809, 26045, 26054).equals(CallChecker.isCalled(that, LogMessage.class, 809, 26063, 26066).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context699.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context700 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 814, 26109, 26331);
                        final String npe_invocation_var94 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var94, String.class, 816, 26196, 26205)) {
                            result = CallChecker.isCalled(npe_invocation_var94, String.class, 816, 26196, 26205).hashCode();
                            CallChecker.varAssign(result, "result", 816, 26196, 26205);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 817, 26258, 26274).hashCode());
                        CallChecker.varAssign(result, "result", 817, 26235, 26286);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context700.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context701.methodEnd();
        }
    }

    public static LogMessage FLOW_REMOVED() {
        MethodContext _bcornu_methode_context706 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(FLOW_REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(OPEN_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.OPEN_TXN_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(DISCARDMSG_NOROUTE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOROUTE_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(FLOW_CONTROL_IGNORED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_CONTROL_IGNORED_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(IDLE_TXN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.IDLE_TXN_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(DISCARDMSG_NOALTEXCH_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DISCARDMSG_NOALTEXCH_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(DEADLETTERMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.DEADLETTERMSG_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(LARGE_TRANSACTION_WARN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.LARGE_TRANSACTION_WARN_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(CLOSE_FORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_FORCED_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(PREFETCH_SIZE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.PREFETCH_SIZE_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CLOSE_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(FLOW_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CREATE_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(FLOW_ENFORCED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.FLOW_ENFORCED_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(CHANNEL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ChannelMessages.CHANNEL_LOG_HIERARCHY", 830, 26355, 27760);
            CallChecker.varInit(ChannelMessages._currentLocale, "org.apache.qpid.server.logging.messages.ChannelMessages._currentLocale", 830, 26355, 27760);
            CallChecker.varInit(ChannelMessages._messages, "org.apache.qpid.server.logging.messages.ChannelMessages._messages", 830, 26355, 27760);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ChannelMessages._messages, ResourceBundle.class, 832, 26661, 26669)) {
                ChannelMessages._messages = CallChecker.beforeCalled(ChannelMessages._messages, ResourceBundle.class, 832, 26661, 26669);
                rawMessage = CallChecker.isCalled(ChannelMessages._messages, ResourceBundle.class, 832, 26661, 26669).getString("FLOW_REMOVED");
                CallChecker.varAssign(rawMessage, "rawMessage", 832, 26661, 26669);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 834, 26707, 26740);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context702 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 838, 26797, 26880);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context702.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context703 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 843, 26895, 27004);
                        return ChannelMessages.FLOW_REMOVED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context703.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context704 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 849, 27019, 27506);
                        CallChecker.varInit(o, "o", 849, 27019, 27506);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 860, 27341, 27379);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 862, 27430, 27433)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 862, 27475, 27478)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 862, 27405, 27421).equals(CallChecker.isCalled(that, LogMessage.class, 862, 27430, 27433).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 862, 27457, 27466).equals(CallChecker.isCalled(that, LogMessage.class, 862, 27475, 27478).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context704.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context705 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 867, 27521, 27743);
                        final String npe_invocation_var95 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var95, String.class, 869, 27608, 27617)) {
                            result = CallChecker.isCalled(npe_invocation_var95, String.class, 869, 27608, 27617).hashCode();
                            CallChecker.varAssign(result, "result", 869, 27608, 27617);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 870, 27670, 27686).hashCode());
                        CallChecker.varAssign(result, "result", 870, 27647, 27698);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context705.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context706.methodEnd();
        }
    }

    private ChannelMessages() {
        MethodContext _bcornu_methode_context42 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }
}

