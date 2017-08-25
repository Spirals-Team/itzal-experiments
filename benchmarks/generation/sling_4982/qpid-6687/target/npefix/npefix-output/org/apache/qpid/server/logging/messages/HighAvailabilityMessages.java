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

public class HighAvailabilityMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String HIGHAVAILABILITY_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability";

    public static final String INTRUDER_DETECTED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.intruder_detected";

    public static final String TRANSFER_MASTER_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.transfer_master";

    public static final String QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.quorum_override_changed";

    public static final String REMOVED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.removed";

    public static final String LEFT_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.left";

    public static final String JOINED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.joined";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.created";

    public static final String QUORUM_LOST_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.quorum_lost";

    public static final String PRIORITY_CHANGED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.priority_changed";

    public static final String ADDED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.added";

    public static final String DELETED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.deleted";

    public static final String ROLE_CHANGED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.role_changed";

    public static final String DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.designated_primary_changed";

    public static final String NODE_ROLLEDBACK_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "highavailability.node_rolledback";

    static {
        LoggerFactory.getLogger(HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.REMOVED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.LEFT_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.JOINED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.ADDED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.DELETED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY);
        LoggerFactory.getLogger(HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY);
        HighAvailabilityMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.HighAvailability_logmessages", HighAvailabilityMessages._currentLocale);
        CallChecker.varAssign(HighAvailabilityMessages._messages, "HighAvailabilityMessages._messages", 81, 4491, 4615);
    }

    public static LogMessage INTRUDER_DETECTED(String param1, String param2) {
        MethodContext _bcornu_methode_context311 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 91, 4628, 6408);
            CallChecker.varInit(param1, "param1", 91, 4628, 6408);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 91, 4628, 6408);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 91, 4628, 6408);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 91, 4628, 6408);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 93, 4993, 5001)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 93, 4993, 5001);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 93, 4993, 5001).getString("INTRUDER_DETECTED");
                CallChecker.varAssign(rawMessage, "rawMessage", 93, 4993, 5001);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 95, 5044, 5094);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 98, 5244, 5315);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 100, 5349, 5357);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 100, 5349, 5357).format(messageArguments), "message", 100, 5326, 5383);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context307 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 104, 5440, 5523);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context307.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context308 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 109, 5538, 5652);
                        return HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context308.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context309 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 115, 5667, 6154);
                        CallChecker.varInit(o, "o", 115, 5667, 6154);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 126, 5989, 6027);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 128, 6078, 6081)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 128, 6123, 6126)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 128, 6053, 6069).equals(CallChecker.isCalled(that, LogMessage.class, 128, 6078, 6081).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 128, 6105, 6114).equals(CallChecker.isCalled(that, LogMessage.class, 128, 6123, 6126).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context309.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context310 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 133, 6169, 6391);
                        final String npe_invocation_var27 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var27, String.class, 135, 6256, 6265)) {
                            result = CallChecker.isCalled(npe_invocation_var27, String.class, 135, 6256, 6265).hashCode();
                            CallChecker.varAssign(result, "result", 135, 6256, 6265);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 136, 6318, 6334).hashCode());
                        CallChecker.varAssign(result, "result", 136, 6295, 6346);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context310.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context311.methodEnd();
        }
    }

    public static LogMessage TRANSFER_MASTER(String param1, String param2) {
        MethodContext _bcornu_methode_context316 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 149, 6415, 8195);
            CallChecker.varInit(param1, "param1", 149, 6415, 8195);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 149, 6415, 8195);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 149, 6415, 8195);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 149, 6415, 8195);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 151, 6784, 6792)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 151, 6784, 6792);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 151, 6784, 6792).getString("TRANSFER_MASTER");
                CallChecker.varAssign(rawMessage, "rawMessage", 151, 6784, 6792);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 153, 6833, 6883);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 156, 7033, 7104);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 158, 7138, 7146);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 158, 7138, 7146).format(messageArguments), "message", 158, 7115, 7172);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context312 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 162, 7229, 7312);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context312.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context313 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 167, 7327, 7439);
                        return HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context313.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context314 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 173, 7454, 7941);
                        CallChecker.varInit(o, "o", 173, 7454, 7941);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 184, 7776, 7814);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 186, 7865, 7868)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 186, 7910, 7913)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 186, 7840, 7856).equals(CallChecker.isCalled(that, LogMessage.class, 186, 7865, 7868).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 186, 7892, 7901).equals(CallChecker.isCalled(that, LogMessage.class, 186, 7910, 7913).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context314.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context315 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 191, 7956, 8178);
                        final String npe_invocation_var28 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var28, String.class, 193, 8043, 8052)) {
                            result = CallChecker.isCalled(npe_invocation_var28, String.class, 193, 8043, 8052).hashCode();
                            CallChecker.varAssign(result, "result", 193, 8043, 8052);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 194, 8105, 8121).hashCode());
                        CallChecker.varAssign(result, "result", 194, 8082, 8133);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context315.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context316.methodEnd();
        }
    }

    public static LogMessage QUORUM_OVERRIDE_CHANGED(String param1) {
        MethodContext _bcornu_methode_context321 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 207, 8202, 9963);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 207, 8202, 9963);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 207, 8202, 9963);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 207, 8202, 9963);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 209, 8544, 8552)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 209, 8544, 8552);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 209, 8544, 8552).getString("QUORUM_OVERRIDE_CHANGED");
                CallChecker.varAssign(rawMessage, "rawMessage", 209, 8544, 8552);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 211, 8601, 8643);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 214, 8793, 8864);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 216, 8898, 8906);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 216, 8898, 8906).format(messageArguments), "message", 216, 8875, 8932);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context317 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 220, 8989, 9072);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context317.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context318 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 225, 9087, 9207);
                        return HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context318.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context319 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 231, 9222, 9709);
                        CallChecker.varInit(o, "o", 231, 9222, 9709);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 242, 9544, 9582);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 244, 9633, 9636)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 244, 9678, 9681)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 244, 9608, 9624).equals(CallChecker.isCalled(that, LogMessage.class, 244, 9633, 9636).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 244, 9660, 9669).equals(CallChecker.isCalled(that, LogMessage.class, 244, 9678, 9681).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context319.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context320 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 249, 9724, 9946);
                        final String npe_invocation_var29 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var29, String.class, 251, 9811, 9820)) {
                            result = CallChecker.isCalled(npe_invocation_var29, String.class, 251, 9811, 9820).hashCode();
                            CallChecker.varAssign(result, "result", 251, 9811, 9820);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 252, 9873, 9889).hashCode());
                        CallChecker.varAssign(result, "result", 252, 9850, 9901);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context320.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context321.methodEnd();
        }
    }

    public static LogMessage REMOVED(String param1, String param2) {
        MethodContext _bcornu_methode_context326 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 265, 9970, 11712);
            CallChecker.varInit(param1, "param1", 265, 9970, 11712);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 265, 9970, 11712);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 265, 9970, 11712);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 265, 9970, 11712);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 267, 10317, 10325)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 267, 10317, 10325);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 267, 10317, 10325).getString("REMOVED");
                CallChecker.varAssign(rawMessage, "rawMessage", 267, 10317, 10325);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 269, 10358, 10408);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 272, 10558, 10629);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 274, 10663, 10671);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 274, 10663, 10671).format(messageArguments), "message", 274, 10640, 10697);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context322 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 278, 10754, 10837);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context322.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context323 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 283, 10852, 10956);
                        return HighAvailabilityMessages.REMOVED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context323.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context324 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 289, 10971, 11458);
                        CallChecker.varInit(o, "o", 289, 10971, 11458);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 300, 11293, 11331);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 302, 11382, 11385)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 302, 11427, 11430)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 302, 11357, 11373).equals(CallChecker.isCalled(that, LogMessage.class, 302, 11382, 11385).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 302, 11409, 11418).equals(CallChecker.isCalled(that, LogMessage.class, 302, 11427, 11430).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context324.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context325 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 307, 11473, 11695);
                        final String npe_invocation_var30 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var30, String.class, 309, 11560, 11569)) {
                            result = CallChecker.isCalled(npe_invocation_var30, String.class, 309, 11560, 11569).hashCode();
                            CallChecker.varAssign(result, "result", 309, 11560, 11569);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 310, 11622, 11638).hashCode());
                        CallChecker.varAssign(result, "result", 310, 11599, 11650);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context325.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context326.methodEnd();
        }
    }

    public static LogMessage LEFT(String param1, String param2) {
        MethodContext _bcornu_methode_context331 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 323, 11719, 13449);
            CallChecker.varInit(param1, "param1", 323, 11719, 13449);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 323, 11719, 13449);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 323, 11719, 13449);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 323, 11719, 13449);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 325, 12060, 12068)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 325, 12060, 12068);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 325, 12060, 12068).getString("LEFT");
                CallChecker.varAssign(rawMessage, "rawMessage", 325, 12060, 12068);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 327, 12098, 12148);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 330, 12298, 12369);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 332, 12403, 12411);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 332, 12403, 12411).format(messageArguments), "message", 332, 12380, 12437);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context327 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 336, 12494, 12577);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context327.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context328 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 341, 12592, 12693);
                        return HighAvailabilityMessages.LEFT_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context328.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context329 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 347, 12708, 13195);
                        CallChecker.varInit(o, "o", 347, 12708, 13195);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 358, 13030, 13068);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 360, 13119, 13122)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 360, 13164, 13167)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 360, 13094, 13110).equals(CallChecker.isCalled(that, LogMessage.class, 360, 13119, 13122).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 360, 13146, 13155).equals(CallChecker.isCalled(that, LogMessage.class, 360, 13164, 13167).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context329.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context330 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 365, 13210, 13432);
                        final String npe_invocation_var31 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var31, String.class, 367, 13297, 13306)) {
                            result = CallChecker.isCalled(npe_invocation_var31, String.class, 367, 13297, 13306).hashCode();
                            CallChecker.varAssign(result, "result", 367, 13297, 13306);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 368, 13359, 13375).hashCode());
                        CallChecker.varAssign(result, "result", 368, 13336, 13387);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context330.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context331.methodEnd();
        }
    }

    public static LogMessage JOINED(String param1, String param2) {
        MethodContext _bcornu_methode_context336 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 381, 13456, 15194);
            CallChecker.varInit(param1, "param1", 381, 13456, 15194);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 381, 13456, 15194);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 381, 13456, 15194);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 381, 13456, 15194);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 383, 13801, 13809)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 383, 13801, 13809);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 383, 13801, 13809).getString("JOINED");
                CallChecker.varAssign(rawMessage, "rawMessage", 383, 13801, 13809);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 385, 13841, 13891);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 388, 14041, 14112);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 390, 14146, 14154);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 390, 14146, 14154).format(messageArguments), "message", 390, 14123, 14180);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context332 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 394, 14237, 14320);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context332.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context333 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 399, 14335, 14438);
                        return HighAvailabilityMessages.JOINED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context333.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context334 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 405, 14453, 14940);
                        CallChecker.varInit(o, "o", 405, 14453, 14940);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 416, 14775, 14813);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 418, 14864, 14867)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 418, 14909, 14912)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 418, 14839, 14855).equals(CallChecker.isCalled(that, LogMessage.class, 418, 14864, 14867).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 418, 14891, 14900).equals(CallChecker.isCalled(that, LogMessage.class, 418, 14909, 14912).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context334.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context335 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 423, 14955, 15177);
                        final String npe_invocation_var32 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var32, String.class, 425, 15042, 15051)) {
                            result = CallChecker.isCalled(npe_invocation_var32, String.class, 425, 15042, 15051).hashCode();
                            CallChecker.varAssign(result, "result", 425, 15042, 15051);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 426, 15104, 15120).hashCode());
                        CallChecker.varAssign(result, "result", 426, 15081, 15132);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context335.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context336.methodEnd();
        }
    }

    public static LogMessage CREATED() {
        MethodContext _bcornu_methode_context341 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 439, 15201, 16586);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 439, 15201, 16586);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 439, 15201, 16586);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 441, 15497, 15505)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 441, 15497, 15505);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 441, 15497, 15505).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 441, 15497, 15505);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 443, 15538, 15571);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context337 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 447, 15628, 15711);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context337.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context338 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 452, 15726, 15830);
                        return HighAvailabilityMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context338.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context339 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 458, 15845, 16332);
                        CallChecker.varInit(o, "o", 458, 15845, 16332);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 469, 16167, 16205);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 471, 16256, 16259)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 471, 16301, 16304)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 471, 16231, 16247).equals(CallChecker.isCalled(that, LogMessage.class, 471, 16256, 16259).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 471, 16283, 16292).equals(CallChecker.isCalled(that, LogMessage.class, 471, 16301, 16304).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context339.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context340 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 476, 16347, 16569);
                        final String npe_invocation_var33 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var33, String.class, 478, 16434, 16443)) {
                            result = CallChecker.isCalled(npe_invocation_var33, String.class, 478, 16434, 16443).hashCode();
                            CallChecker.varAssign(result, "result", 478, 16434, 16443);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 479, 16496, 16512).hashCode());
                        CallChecker.varAssign(result, "result", 479, 16473, 16524);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context340.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context341.methodEnd();
        }
    }

    public static LogMessage QUORUM_LOST() {
        MethodContext _bcornu_methode_context346 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 492, 16593, 18016);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 492, 16593, 18016);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 492, 16593, 18016);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 494, 16919, 16927)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 494, 16919, 16927);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 494, 16919, 16927).getString("QUORUM_LOST");
                CallChecker.varAssign(rawMessage, "rawMessage", 494, 16919, 16927);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 496, 16964, 16997);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context342 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 500, 17054, 17137);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context342.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context343 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 505, 17152, 17260);
                        return HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context343.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context344 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 511, 17275, 17762);
                        CallChecker.varInit(o, "o", 511, 17275, 17762);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 522, 17597, 17635);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 524, 17686, 17689)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 524, 17731, 17734)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 524, 17661, 17677).equals(CallChecker.isCalled(that, LogMessage.class, 524, 17686, 17689).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 524, 17713, 17722).equals(CallChecker.isCalled(that, LogMessage.class, 524, 17731, 17734).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context344.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context345 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 529, 17777, 17999);
                        final String npe_invocation_var34 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var34, String.class, 531, 17864, 17873)) {
                            result = CallChecker.isCalled(npe_invocation_var34, String.class, 531, 17864, 17873).hashCode();
                            CallChecker.varAssign(result, "result", 531, 17864, 17873);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 532, 17926, 17942).hashCode());
                        CallChecker.varAssign(result, "result", 532, 17903, 17954);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context345.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context346.methodEnd();
        }
    }

    public static LogMessage PRIORITY_CHANGED(String param1) {
        MethodContext _bcornu_methode_context351 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 545, 18023, 19753);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 545, 18023, 19753);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 545, 18023, 19753);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 545, 18023, 19753);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 547, 18348, 18356)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 547, 18348, 18356);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 547, 18348, 18356).getString("PRIORITY_CHANGED");
                CallChecker.varAssign(rawMessage, "rawMessage", 547, 18348, 18356);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 549, 18398, 18440);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 552, 18590, 18661);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 554, 18695, 18703);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 554, 18695, 18703).format(messageArguments), "message", 554, 18672, 18729);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context347 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 558, 18786, 18869);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context347.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context348 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 563, 18884, 18997);
                        return HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context348.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context349 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 569, 19012, 19499);
                        CallChecker.varInit(o, "o", 569, 19012, 19499);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 580, 19334, 19372);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 582, 19423, 19426)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 582, 19468, 19471)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 582, 19398, 19414).equals(CallChecker.isCalled(that, LogMessage.class, 582, 19423, 19426).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 582, 19450, 19459).equals(CallChecker.isCalled(that, LogMessage.class, 582, 19468, 19471).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context349.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context350 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 587, 19514, 19736);
                        final String npe_invocation_var35 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var35, String.class, 589, 19601, 19610)) {
                            result = CallChecker.isCalled(npe_invocation_var35, String.class, 589, 19601, 19610).hashCode();
                            CallChecker.varAssign(result, "result", 589, 19601, 19610);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 590, 19663, 19679).hashCode());
                        CallChecker.varAssign(result, "result", 590, 19640, 19691);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context350.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context351.methodEnd();
        }
    }

    public static LogMessage ADDED(String param1, String param2) {
        MethodContext _bcornu_methode_context356 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 603, 19760, 21494);
            CallChecker.varInit(param1, "param1", 603, 19760, 21494);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 603, 19760, 21494);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 603, 19760, 21494);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 603, 19760, 21494);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 605, 20103, 20111)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 605, 20103, 20111);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 605, 20103, 20111).getString("ADDED");
                CallChecker.varAssign(rawMessage, "rawMessage", 605, 20103, 20111);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 607, 20142, 20192);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 610, 20342, 20413);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 612, 20447, 20455);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 612, 20447, 20455).format(messageArguments), "message", 612, 20424, 20481);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context352 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 616, 20538, 20621);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context352.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context353 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 621, 20636, 20738);
                        return HighAvailabilityMessages.ADDED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context353.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context354 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 627, 20753, 21240);
                        CallChecker.varInit(o, "o", 627, 20753, 21240);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 638, 21075, 21113);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 640, 21164, 21167)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 640, 21209, 21212)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 640, 21139, 21155).equals(CallChecker.isCalled(that, LogMessage.class, 640, 21164, 21167).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 640, 21191, 21200).equals(CallChecker.isCalled(that, LogMessage.class, 640, 21209, 21212).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context354.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context355 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 645, 21255, 21477);
                        final String npe_invocation_var36 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var36, String.class, 647, 21342, 21351)) {
                            result = CallChecker.isCalled(npe_invocation_var36, String.class, 647, 21342, 21351).hashCode();
                            CallChecker.varAssign(result, "result", 647, 21342, 21351);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 648, 21404, 21420).hashCode());
                        CallChecker.varAssign(result, "result", 648, 21381, 21432);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context355.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context356.methodEnd();
        }
    }

    public static LogMessage DELETED() {
        MethodContext _bcornu_methode_context361 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 661, 21501, 22886);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 661, 21501, 22886);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 661, 21501, 22886);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 663, 21797, 21805)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 663, 21797, 21805);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 663, 21797, 21805).getString("DELETED");
                CallChecker.varAssign(rawMessage, "rawMessage", 663, 21797, 21805);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 665, 21838, 21871);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context357 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 669, 21928, 22011);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context357.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context358 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 674, 22026, 22130);
                        return HighAvailabilityMessages.DELETED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context358.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context359 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 680, 22145, 22632);
                        CallChecker.varInit(o, "o", 680, 22145, 22632);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 691, 22467, 22505);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 693, 22556, 22559)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 693, 22601, 22604)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 693, 22531, 22547).equals(CallChecker.isCalled(that, LogMessage.class, 693, 22556, 22559).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 693, 22583, 22592).equals(CallChecker.isCalled(that, LogMessage.class, 693, 22601, 22604).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context359.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context360 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 698, 22647, 22869);
                        final String npe_invocation_var37 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var37, String.class, 700, 22734, 22743)) {
                            result = CallChecker.isCalled(npe_invocation_var37, String.class, 700, 22734, 22743).hashCode();
                            CallChecker.varAssign(result, "result", 700, 22734, 22743);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 701, 22796, 22812).hashCode());
                        CallChecker.varAssign(result, "result", 701, 22773, 22824);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context360.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context361.methodEnd();
        }
    }

    public static LogMessage ROLE_CHANGED(String param1, String param2, String param3, String param4) {
        MethodContext _bcornu_methode_context366 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param4, "param4", 714, 22893, 24734);
            CallChecker.varInit(param3, "param3", 714, 22893, 24734);
            CallChecker.varInit(param2, "param2", 714, 22893, 24734);
            CallChecker.varInit(param1, "param1", 714, 22893, 24734);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 714, 22893, 24734);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 714, 22893, 24734);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 714, 22893, 24734);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 716, 23313, 23321)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 716, 23313, 23321);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 716, 23313, 23321).getString("ROLE_CHANGED");
                CallChecker.varAssign(rawMessage, "rawMessage", 716, 23313, 23321);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 , param4 }, "messageArguments", 718, 23359, 23425);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 721, 23575, 23646);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 723, 23680, 23688);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 723, 23680, 23688).format(messageArguments), "message", 723, 23657, 23714);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context362 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 727, 23771, 23854);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context362.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context363 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 732, 23869, 23978);
                        return HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context363.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context364 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 738, 23993, 24480);
                        CallChecker.varInit(o, "o", 738, 23993, 24480);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 749, 24315, 24353);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 751, 24404, 24407)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 751, 24449, 24452)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 751, 24379, 24395).equals(CallChecker.isCalled(that, LogMessage.class, 751, 24404, 24407).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 751, 24431, 24440).equals(CallChecker.isCalled(that, LogMessage.class, 751, 24449, 24452).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context364.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context365 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 756, 24495, 24717);
                        final String npe_invocation_var38 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var38, String.class, 758, 24582, 24591)) {
                            result = CallChecker.isCalled(npe_invocation_var38, String.class, 758, 24582, 24591).hashCode();
                            CallChecker.varAssign(result, "result", 758, 24582, 24591);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 759, 24644, 24660).hashCode());
                        CallChecker.varAssign(result, "result", 759, 24621, 24672);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context365.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context366.methodEnd();
        }
    }

    public static LogMessage DESIGNATED_PRIMARY_CHANGED(String param1) {
        MethodContext _bcornu_methode_context371 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 772, 24741, 26511);
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 772, 24741, 26511);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 772, 24741, 26511);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 772, 24741, 26511);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 774, 25086, 25094)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 774, 25086, 25094);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 774, 25086, 25094).getString("DESIGNATED_PRIMARY_CHANGED");
                CallChecker.varAssign(rawMessage, "rawMessage", 774, 25086, 25094);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 776, 25146, 25188);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, HighAvailabilityMessages._currentLocale), "formatter", 779, 25338, 25409);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 781, 25443, 25451);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 781, 25443, 25451).format(messageArguments), "message", 781, 25420, 25477);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context367 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 785, 25534, 25617);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context367.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context368 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 790, 25632, 25755);
                        return HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context368.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context369 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 796, 25770, 26257);
                        CallChecker.varInit(o, "o", 796, 25770, 26257);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 807, 26092, 26130);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 809, 26181, 26184)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 809, 26226, 26229)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 809, 26156, 26172).equals(CallChecker.isCalled(that, LogMessage.class, 809, 26181, 26184).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 809, 26208, 26217).equals(CallChecker.isCalled(that, LogMessage.class, 809, 26226, 26229).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context369.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context370 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 814, 26272, 26494);
                        final String npe_invocation_var39 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var39, String.class, 816, 26359, 26368)) {
                            result = CallChecker.isCalled(npe_invocation_var39, String.class, 816, 26359, 26368).hashCode();
                            CallChecker.varAssign(result, "result", 816, 26359, 26368);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 817, 26421, 26437).hashCode());
                        CallChecker.varAssign(result, "result", 817, 26398, 26449);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context370.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context371.methodEnd();
        }
    }

    public static LogMessage NODE_ROLLEDBACK() {
        MethodContext _bcornu_methode_context376 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(NODE_ROLLEDBACK_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DESIGNATED_PRIMARY_CHANGED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(ROLE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ROLE_CHANGED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.DELETED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(ADDED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.ADDED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(PRIORITY_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.PRIORITY_CHANGED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(QUORUM_LOST_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_LOST_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.CREATED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(JOINED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.JOINED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(LEFT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.LEFT_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(REMOVED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.REMOVED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.QUORUM_OVERRIDE_CHANGED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(TRANSFER_MASTER_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.TRANSFER_MASTER_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(INTRUDER_DETECTED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.INTRUDER_DETECTED_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(HIGHAVAILABILITY_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages.HIGHAVAILABILITY_LOG_HIERARCHY", 830, 26518, 27951);
            CallChecker.varInit(HighAvailabilityMessages._currentLocale, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._currentLocale", 830, 26518, 27951);
            CallChecker.varInit(HighAvailabilityMessages._messages, "org.apache.qpid.server.logging.messages.HighAvailabilityMessages._messages", 830, 26518, 27951);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(HighAvailabilityMessages._messages, ResourceBundle.class, 832, 26846, 26854)) {
                HighAvailabilityMessages._messages = CallChecker.beforeCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 832, 26846, 26854);
                rawMessage = CallChecker.isCalled(HighAvailabilityMessages._messages, ResourceBundle.class, 832, 26846, 26854).getString("NODE_ROLLEDBACK");
                CallChecker.varAssign(rawMessage, "rawMessage", 832, 26846, 26854);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 834, 26895, 26928);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context372 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 838, 26985, 27068);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context372.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context373 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 843, 27083, 27195);
                        return HighAvailabilityMessages.NODE_ROLLEDBACK_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context373.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context374 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 849, 27210, 27697);
                        CallChecker.varInit(o, "o", 849, 27210, 27697);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 860, 27532, 27570);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 862, 27621, 27624)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 862, 27666, 27669)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 862, 27596, 27612).equals(CallChecker.isCalled(that, LogMessage.class, 862, 27621, 27624).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 862, 27648, 27657).equals(CallChecker.isCalled(that, LogMessage.class, 862, 27666, 27669).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context374.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context375 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 867, 27712, 27934);
                        final String npe_invocation_var40 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var40, String.class, 869, 27799, 27808)) {
                            result = CallChecker.isCalled(npe_invocation_var40, String.class, 869, 27799, 27808).hashCode();
                            CallChecker.varAssign(result, "result", 869, 27799, 27808);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 870, 27861, 27877).hashCode());
                        CallChecker.varAssign(result, "result", 870, 27838, 27889);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context375.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context376.methodEnd();
        }
    }

    private HighAvailabilityMessages() {
        MethodContext _bcornu_methode_context29 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }
}

