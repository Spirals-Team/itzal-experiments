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

public class SubscriptionMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String SUBSCRIPTION_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "subscription";

    public static final String STATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "subscription.state";

    public static final String CREATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "subscription.create";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "subscription.close";

    static {
        LoggerFactory.getLogger(SubscriptionMessages.SUBSCRIPTION_LOG_HIERARCHY);
        LoggerFactory.getLogger(SubscriptionMessages.STATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(SubscriptionMessages.CREATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(SubscriptionMessages.CLOSE_LOG_HIERARCHY);
        SubscriptionMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Subscription_logmessages", SubscriptionMessages._currentLocale);
        CallChecker.varAssign(SubscriptionMessages._messages, "SubscriptionMessages._messages", 59, 2355, 2475);
    }

    public static LogMessage STATE(Number param1) {
        MethodContext _bcornu_methode_context812 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 69, 2488, 4195);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.CLOSE_LOG_HIERARCHY", 69, 2488, 4195);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.CREATE_LOG_HIERARCHY", 69, 2488, 4195);
            CallChecker.varInit(STATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.STATE_LOG_HIERARCHY", 69, 2488, 4195);
            CallChecker.varInit(SUBSCRIPTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.SUBSCRIPTION_LOG_HIERARCHY", 69, 2488, 4195);
            CallChecker.varInit(SubscriptionMessages._currentLocale, "org.apache.qpid.server.logging.messages.SubscriptionMessages._currentLocale", 69, 2488, 4195);
            CallChecker.varInit(SubscriptionMessages._messages, "org.apache.qpid.server.logging.messages.SubscriptionMessages._messages", 69, 2488, 4195);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(SubscriptionMessages._messages, ResourceBundle.class, 71, 2812, 2820)) {
                SubscriptionMessages._messages = CallChecker.beforeCalled(SubscriptionMessages._messages, ResourceBundle.class, 71, 2812, 2820);
                rawMessage = CallChecker.isCalled(SubscriptionMessages._messages, ResourceBundle.class, 71, 2812, 2820).getString("STATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 71, 2812, 2820);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 73, 2851, 2893);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, SubscriptionMessages._currentLocale), "formatter", 76, 3043, 3114);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 78, 3148, 3156);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 78, 3148, 3156).format(messageArguments), "message", 78, 3125, 3182);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context808 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 82, 3239, 3322);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context808.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context809 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 87, 3337, 3439);
                        return SubscriptionMessages.STATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context809.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context810 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 93, 3454, 3941);
                        CallChecker.varInit(o, "o", 93, 3454, 3941);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 104, 3776, 3814);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 106, 3865, 3868)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 106, 3910, 3913)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 106, 3840, 3856).equals(CallChecker.isCalled(that, LogMessage.class, 106, 3865, 3868).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 106, 3892, 3901).equals(CallChecker.isCalled(that, LogMessage.class, 106, 3910, 3913).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context810.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context811 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 111, 3956, 4178);
                        final String npe_invocation_var108 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var108, String.class, 113, 4043, 4052)) {
                            result = CallChecker.isCalled(npe_invocation_var108, String.class, 113, 4043, 4052).hashCode();
                            CallChecker.varAssign(result, "result", 113, 4043, 4052);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 114, 4105, 4121).hashCode());
                        CallChecker.varAssign(result, "result", 114, 4082, 4133);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context811.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context812.methodEnd();
        }
    }

    public static LogMessage CREATE(String param1, boolean opt1, boolean opt2) {
        MethodContext _bcornu_methode_context817 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(opt2, "opt2", 127, 4202, 6938);
            CallChecker.varInit(opt1, "opt1", 127, 4202, 6938);
            CallChecker.varInit(param1, "param1", 127, 4202, 6938);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.CLOSE_LOG_HIERARCHY", 127, 4202, 6938);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.CREATE_LOG_HIERARCHY", 127, 4202, 6938);
            CallChecker.varInit(STATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.STATE_LOG_HIERARCHY", 127, 4202, 6938);
            CallChecker.varInit(SUBSCRIPTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.SUBSCRIPTION_LOG_HIERARCHY", 127, 4202, 6938);
            CallChecker.varInit(SubscriptionMessages._currentLocale, "org.apache.qpid.server.logging.messages.SubscriptionMessages._currentLocale", 127, 4202, 6938);
            CallChecker.varInit(SubscriptionMessages._messages, "org.apache.qpid.server.logging.messages.SubscriptionMessages._messages", 127, 4202, 6938);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(SubscriptionMessages._messages, ResourceBundle.class, 129, 4566, 4574)) {
                SubscriptionMessages._messages = CallChecker.beforeCalled(SubscriptionMessages._messages, ResourceBundle.class, 129, 4566, 4574);
                rawMessage = CallChecker.isCalled(SubscriptionMessages._messages, ResourceBundle.class, 129, 4566, 4574).getString("CREATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 129, 4566, 4574);
            }
            StringBuffer msg = CallChecker.varInit(new StringBuffer(), "msg", 130, 4605, 4642);
            String[] parts = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(rawMessage, String.class, 134, 4807, 4816)) {
                rawMessage = CallChecker.beforeCalled(rawMessage, String.class, 134, 4807, 4816);
                parts = CallChecker.isCalled(rawMessage, String.class, 134, 4807, 4816).split("\\[");
                CallChecker.varAssign(parts, "parts", 134, 4807, 4816);
            }
            if (CallChecker.beforeDeref(parts, String[].class, 135, 4851, 4855)) {
                if (CallChecker.beforeDeref(msg, StringBuffer.class, 135, 4840, 4842)) {
                    parts = CallChecker.beforeCalled(parts, String[].class, 135, 4851, 4855);
                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 135, 4840, 4842);
                    CallChecker.isCalled(msg, StringBuffer.class, 135, 4840, 4842).append(CallChecker.isCalled(parts, String[].class, 135, 4851, 4855)[0]);
                }
            }
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(parts, String[].class, 138, 4892, 4896)) {
                parts = CallChecker.beforeCalled(parts, String[].class, 138, 4892, 4896);
                if ((CallChecker.isCalled(parts, String[].class, 138, 4892, 4896).length) > 1) {
                    if (CallChecker.beforeDeref(parts, String[].class, 142, 4978, 4982)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 142, 4978, 4982);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 142, 4978, 4982)[1], String.class, 142, 4978, 4985)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 142, 4978, 4982);
                            CallChecker.isCalled(parts, String[].class, 142, 4978, 4982)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 142, 4978, 4982)[1], String.class, 142, 4978, 4985);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 142, 4978, 4982)[1], String.class, 142, 4978, 4985).indexOf(']');
                            CallChecker.varAssign(end, "end", 142, 4972, 4999);
                        }
                    }
                    if (opt1) {
                        if (CallChecker.beforeDeref(parts, String[].class, 145, 5064, 5068)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 145, 5064, 5068);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 145, 5064, 5068)[1], String.class, 145, 5064, 5071)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 145, 5053, 5055)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 145, 5064, 5068);
                                    CallChecker.isCalled(parts, String[].class, 145, 5064, 5068)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 145, 5064, 5068)[1], String.class, 145, 5064, 5071);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 145, 5053, 5055);
                                    CallChecker.isCalled(msg, StringBuffer.class, 145, 5053, 5055).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 145, 5064, 5068)[1], String.class, 145, 5064, 5071).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 149, 5194, 5198)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 149, 5194, 5198);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 149, 5194, 5198)[1], String.class, 149, 5194, 5201)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 149, 5183, 5185)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 149, 5194, 5198);
                                CallChecker.isCalled(parts, String[].class, 149, 5194, 5198)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 149, 5194, 5198)[1], String.class, 149, 5194, 5201);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 149, 5183, 5185);
                                CallChecker.isCalled(msg, StringBuffer.class, 149, 5183, 5185).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 149, 5194, 5198)[1], String.class, 149, 5194, 5201).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 152, 5290, 5294)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 152, 5290, 5294);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 152, 5290, 5294)[2], String.class, 152, 5290, 5297)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 152, 5290, 5294);
                            CallChecker.isCalled(parts, String[].class, 152, 5290, 5294)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 152, 5290, 5294)[2], String.class, 152, 5290, 5297);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 152, 5290, 5294)[2], String.class, 152, 5290, 5297).indexOf(']');
                            CallChecker.varAssign(end, "end", 152, 5284, 5311);
                        }
                    }
                    if (opt2) {
                        if (CallChecker.beforeDeref(parts, String[].class, 155, 5376, 5380)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 155, 5376, 5380);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 155, 5376, 5380)[2], String.class, 155, 5376, 5383)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 155, 5365, 5367)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 155, 5376, 5380);
                                    CallChecker.isCalled(parts, String[].class, 155, 5376, 5380)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 155, 5376, 5380)[2], String.class, 155, 5376, 5383);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 155, 5365, 5367);
                                    CallChecker.isCalled(msg, StringBuffer.class, 155, 5365, 5367).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 155, 5376, 5380)[2], String.class, 155, 5376, 5383).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 159, 5506, 5510)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 159, 5506, 5510);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 159, 5506, 5510)[2], String.class, 159, 5506, 5513)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 159, 5495, 5497)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 159, 5506, 5510);
                                CallChecker.isCalled(parts, String[].class, 159, 5506, 5510)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 159, 5506, 5510)[2], String.class, 159, 5506, 5513);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 159, 5495, 5497);
                                CallChecker.isCalled(msg, StringBuffer.class, 159, 5495, 5497).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 159, 5506, 5510)[2], String.class, 159, 5506, 5513).substring((end + 1)));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(msg, StringBuffer.class, 162, 5568, 5570)) {
                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 162, 5568, 5570);
                rawMessage = CallChecker.isCalled(msg, StringBuffer.class, 162, 5568, 5570).toString();
                CallChecker.varAssign(rawMessage, "rawMessage", 162, 5555, 5582);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 164, 5593, 5635);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, SubscriptionMessages._currentLocale), "formatter", 167, 5785, 5856);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 169, 5890, 5898);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 169, 5890, 5898).format(messageArguments), "message", 169, 5867, 5924);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context813 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 173, 5981, 6064);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context813.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context814 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 178, 6079, 6182);
                        return SubscriptionMessages.CREATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context814.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context815 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 184, 6197, 6684);
                        CallChecker.varInit(o, "o", 184, 6197, 6684);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 195, 6519, 6557);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 197, 6608, 6611)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 197, 6653, 6656)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 197, 6583, 6599).equals(CallChecker.isCalled(that, LogMessage.class, 197, 6608, 6611).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 197, 6635, 6644).equals(CallChecker.isCalled(that, LogMessage.class, 197, 6653, 6656).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context815.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context816 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 202, 6699, 6921);
                        final String npe_invocation_var109 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var109, String.class, 204, 6786, 6795)) {
                            result = CallChecker.isCalled(npe_invocation_var109, String.class, 204, 6786, 6795).hashCode();
                            CallChecker.varAssign(result, "result", 204, 6786, 6795);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 205, 6848, 6864).hashCode());
                        CallChecker.varAssign(result, "result", 205, 6825, 6876);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context816.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context817.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context822 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.CLOSE_LOG_HIERARCHY", 218, 6945, 8319);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.CREATE_LOG_HIERARCHY", 218, 6945, 8319);
            CallChecker.varInit(STATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.STATE_LOG_HIERARCHY", 218, 6945, 8319);
            CallChecker.varInit(SUBSCRIPTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.SubscriptionMessages.SUBSCRIPTION_LOG_HIERARCHY", 218, 6945, 8319);
            CallChecker.varInit(SubscriptionMessages._currentLocale, "org.apache.qpid.server.logging.messages.SubscriptionMessages._currentLocale", 218, 6945, 8319);
            CallChecker.varInit(SubscriptionMessages._messages, "org.apache.qpid.server.logging.messages.SubscriptionMessages._messages", 218, 6945, 8319);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(SubscriptionMessages._messages, ResourceBundle.class, 220, 7234, 7242)) {
                SubscriptionMessages._messages = CallChecker.beforeCalled(SubscriptionMessages._messages, ResourceBundle.class, 220, 7234, 7242);
                rawMessage = CallChecker.isCalled(SubscriptionMessages._messages, ResourceBundle.class, 220, 7234, 7242).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 220, 7234, 7242);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 222, 7273, 7306);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context818 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 226, 7363, 7446);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context818.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context819 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 231, 7461, 7563);
                        return SubscriptionMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context819.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context820 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 237, 7578, 8065);
                        CallChecker.varInit(o, "o", 237, 7578, 8065);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 248, 7900, 7938);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 250, 7989, 7992)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 250, 8034, 8037)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 250, 7964, 7980).equals(CallChecker.isCalled(that, LogMessage.class, 250, 7989, 7992).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 250, 8016, 8025).equals(CallChecker.isCalled(that, LogMessage.class, 250, 8034, 8037).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context820.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context821 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 255, 8080, 8302);
                        final String npe_invocation_var110 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var110, String.class, 257, 8167, 8176)) {
                            result = CallChecker.isCalled(npe_invocation_var110, String.class, 257, 8167, 8176).hashCode();
                            CallChecker.varAssign(result, "result", 257, 8167, 8176);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 258, 8229, 8245).hashCode());
                        CallChecker.varAssign(result, "result", 258, 8206, 8257);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context821.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context822.methodEnd();
        }
    }

    private SubscriptionMessages() {
        MethodContext _bcornu_methode_context58 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }
}

