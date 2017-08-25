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

public class QueueMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String QUEUE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "queue";

    public static final String OVERFULL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "queue.overfull";

    public static final String UNDERFULL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "queue.underfull";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "queue.created";

    public static final String DELETED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "queue.deleted";

    static {
        LoggerFactory.getLogger(QueueMessages.QUEUE_LOG_HIERARCHY);
        LoggerFactory.getLogger(QueueMessages.OVERFULL_LOG_HIERARCHY);
        LoggerFactory.getLogger(QueueMessages.UNDERFULL_LOG_HIERARCHY);
        LoggerFactory.getLogger(QueueMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(QueueMessages.DELETED_LOG_HIERARCHY);
        QueueMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Queue_logmessages", QueueMessages._currentLocale);
        CallChecker.varAssign(QueueMessages._messages, "QueueMessages._messages", 61, 2482, 2595);
    }

    public static LogMessage OVERFULL(Number param1, Number param2) {
        MethodContext _bcornu_methode_context282 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 71, 2608, 4370);
            CallChecker.varInit(param1, "param1", 71, 2608, 4370);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.DELETED_LOG_HIERARCHY", 71, 2608, 4370);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.CREATED_LOG_HIERARCHY", 71, 2608, 4370);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.UNDERFULL_LOG_HIERARCHY", 71, 2608, 4370);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.OVERFULL_LOG_HIERARCHY", 71, 2608, 4370);
            CallChecker.varInit(QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.QUEUE_LOG_HIERARCHY", 71, 2608, 4370);
            CallChecker.varInit(QueueMessages._currentLocale, "org.apache.qpid.server.logging.messages.QueueMessages._currentLocale", 71, 2608, 4370);
            CallChecker.varInit(QueueMessages._messages, "org.apache.qpid.server.logging.messages.QueueMessages._messages", 71, 2608, 4370);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(QueueMessages._messages, ResourceBundle.class, 73, 2973, 2981)) {
                QueueMessages._messages = CallChecker.beforeCalled(QueueMessages._messages, ResourceBundle.class, 73, 2973, 2981);
                rawMessage = CallChecker.isCalled(QueueMessages._messages, ResourceBundle.class, 73, 2973, 2981).getString("OVERFULL");
                CallChecker.varAssign(rawMessage, "rawMessage", 73, 2973, 2981);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 75, 3015, 3065);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, QueueMessages._currentLocale), "formatter", 78, 3215, 3286);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 80, 3320, 3328);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 80, 3320, 3328).format(messageArguments), "message", 80, 3297, 3354);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context278 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 84, 3411, 3494);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context278.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context279 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 89, 3509, 3614);
                        return QueueMessages.OVERFULL_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context279.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context280 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 95, 3629, 4116);
                        CallChecker.varInit(o, "o", 95, 3629, 4116);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 106, 3951, 3989);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 108, 4040, 4043)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 108, 4085, 4088)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 108, 4015, 4031).equals(CallChecker.isCalled(that, LogMessage.class, 108, 4040, 4043).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 108, 4067, 4076).equals(CallChecker.isCalled(that, LogMessage.class, 108, 4085, 4088).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context280.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context281 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 113, 4131, 4353);
                        final String npe_invocation_var23 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var23, String.class, 115, 4218, 4227)) {
                            result = CallChecker.isCalled(npe_invocation_var23, String.class, 115, 4218, 4227).hashCode();
                            CallChecker.varAssign(result, "result", 115, 4218, 4227);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 116, 4280, 4296).hashCode());
                        CallChecker.varAssign(result, "result", 116, 4257, 4308);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context281.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context282.methodEnd();
        }
    }

    public static LogMessage UNDERFULL(Number param1, Number param2) {
        MethodContext _bcornu_methode_context287 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 129, 4377, 6150);
            CallChecker.varInit(param1, "param1", 129, 4377, 6150);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.DELETED_LOG_HIERARCHY", 129, 4377, 6150);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.CREATED_LOG_HIERARCHY", 129, 4377, 6150);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.UNDERFULL_LOG_HIERARCHY", 129, 4377, 6150);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.OVERFULL_LOG_HIERARCHY", 129, 4377, 6150);
            CallChecker.varInit(QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.QUEUE_LOG_HIERARCHY", 129, 4377, 6150);
            CallChecker.varInit(QueueMessages._currentLocale, "org.apache.qpid.server.logging.messages.QueueMessages._currentLocale", 129, 4377, 6150);
            CallChecker.varInit(QueueMessages._messages, "org.apache.qpid.server.logging.messages.QueueMessages._messages", 129, 4377, 6150);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(QueueMessages._messages, ResourceBundle.class, 131, 4751, 4759)) {
                QueueMessages._messages = CallChecker.beforeCalled(QueueMessages._messages, ResourceBundle.class, 131, 4751, 4759);
                rawMessage = CallChecker.isCalled(QueueMessages._messages, ResourceBundle.class, 131, 4751, 4759).getString("UNDERFULL");
                CallChecker.varAssign(rawMessage, "rawMessage", 131, 4751, 4759);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 133, 4794, 4844);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, QueueMessages._currentLocale), "formatter", 136, 4994, 5065);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 138, 5099, 5107);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 138, 5099, 5107).format(messageArguments), "message", 138, 5076, 5133);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context283 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 142, 5190, 5273);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context283.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context284 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 147, 5288, 5394);
                        return QueueMessages.UNDERFULL_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context284.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context285 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 153, 5409, 5896);
                        CallChecker.varInit(o, "o", 153, 5409, 5896);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 164, 5731, 5769);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 166, 5820, 5823)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 166, 5865, 5868)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 166, 5795, 5811).equals(CallChecker.isCalled(that, LogMessage.class, 166, 5820, 5823).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 166, 5847, 5856).equals(CallChecker.isCalled(that, LogMessage.class, 166, 5865, 5868).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context285.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context286 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 171, 5911, 6133);
                        final String npe_invocation_var24 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var24, String.class, 173, 5998, 6007)) {
                            result = CallChecker.isCalled(npe_invocation_var24, String.class, 173, 5998, 6007).hashCode();
                            CallChecker.varAssign(result, "result", 173, 5998, 6007);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 174, 6060, 6076).hashCode());
                        CallChecker.varAssign(result, "result", 174, 6037, 6088);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context286.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context287.methodEnd();
        }
    }

    public static LogMessage CREATED(String param1, Number param2, boolean opt1, boolean opt2, boolean opt3, boolean opt4, boolean opt5) {
        MethodContext _bcornu_methode_context292 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(opt5, "opt5", 187, 6157, 9914);
            CallChecker.varInit(opt4, "opt4", 187, 6157, 9914);
            CallChecker.varInit(opt3, "opt3", 187, 6157, 9914);
            CallChecker.varInit(opt2, "opt2", 187, 6157, 9914);
            CallChecker.varInit(opt1, "opt1", 187, 6157, 9914);
            CallChecker.varInit(param2, "param2", 187, 6157, 9914);
            CallChecker.varInit(param1, "param1", 187, 6157, 9914);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.DELETED_LOG_HIERARCHY", 187, 6157, 9914);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.CREATED_LOG_HIERARCHY", 187, 6157, 9914);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.UNDERFULL_LOG_HIERARCHY", 187, 6157, 9914);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.OVERFULL_LOG_HIERARCHY", 187, 6157, 9914);
            CallChecker.varInit(QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.QUEUE_LOG_HIERARCHY", 187, 6157, 9914);
            CallChecker.varInit(QueueMessages._currentLocale, "org.apache.qpid.server.logging.messages.QueueMessages._currentLocale", 187, 6157, 9914);
            CallChecker.varInit(QueueMessages._messages, "org.apache.qpid.server.logging.messages.QueueMessages._messages", 187, 6157, 9914);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(QueueMessages._messages, ResourceBundle.class, 189, 6615, 6623)) {
                QueueMessages._messages = CallChecker.beforeCalled(QueueMessages._messages, ResourceBundle.class, 189, 6615, 6623);
                rawMessage = CallChecker.isCalled(QueueMessages._messages, ResourceBundle.class, 189, 6615, 6623).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 189, 6615, 6623);
            }
            StringBuffer msg = CallChecker.varInit(new StringBuffer(), "msg", 190, 6655, 6692);
            String[] parts = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(rawMessage, String.class, 194, 6857, 6866)) {
                rawMessage = CallChecker.beforeCalled(rawMessage, String.class, 194, 6857, 6866);
                parts = CallChecker.isCalled(rawMessage, String.class, 194, 6857, 6866).split("\\[");
                CallChecker.varAssign(parts, "parts", 194, 6857, 6866);
            }
            if (CallChecker.beforeDeref(parts, String[].class, 195, 6901, 6905)) {
                if (CallChecker.beforeDeref(msg, StringBuffer.class, 195, 6890, 6892)) {
                    parts = CallChecker.beforeCalled(parts, String[].class, 195, 6901, 6905);
                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 195, 6890, 6892);
                    CallChecker.isCalled(msg, StringBuffer.class, 195, 6890, 6892).append(CallChecker.isCalled(parts, String[].class, 195, 6901, 6905)[0]);
                }
            }
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(parts, String[].class, 198, 6942, 6946)) {
                parts = CallChecker.beforeCalled(parts, String[].class, 198, 6942, 6946);
                if ((CallChecker.isCalled(parts, String[].class, 198, 6942, 6946).length) > 1) {
                    if (CallChecker.beforeDeref(parts, String[].class, 202, 7029, 7033)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 202, 7029, 7033);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 202, 7029, 7033)[1], String.class, 202, 7029, 7036)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 202, 7029, 7033);
                            CallChecker.isCalled(parts, String[].class, 202, 7029, 7033)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 202, 7029, 7033)[1], String.class, 202, 7029, 7036);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 202, 7029, 7033)[1], String.class, 202, 7029, 7036).indexOf(']');
                            CallChecker.varAssign(end, "end", 202, 7023, 7050);
                        }
                    }
                    if (opt1) {
                        if (CallChecker.beforeDeref(parts, String[].class, 205, 7115, 7119)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 205, 7115, 7119);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 205, 7115, 7119)[1], String.class, 205, 7115, 7122)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 205, 7104, 7106)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 205, 7115, 7119);
                                    CallChecker.isCalled(parts, String[].class, 205, 7115, 7119)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 205, 7115, 7119)[1], String.class, 205, 7115, 7122);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 205, 7104, 7106);
                                    CallChecker.isCalled(msg, StringBuffer.class, 205, 7104, 7106).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 205, 7115, 7119)[1], String.class, 205, 7115, 7122).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 209, 7245, 7249)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 209, 7245, 7249);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 209, 7245, 7249)[1], String.class, 209, 7245, 7252)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 209, 7234, 7236)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 209, 7245, 7249);
                                CallChecker.isCalled(parts, String[].class, 209, 7245, 7249)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 209, 7245, 7249)[1], String.class, 209, 7245, 7252);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 209, 7234, 7236);
                                CallChecker.isCalled(msg, StringBuffer.class, 209, 7234, 7236).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 209, 7245, 7249)[1], String.class, 209, 7245, 7252).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 212, 7334, 7338)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 212, 7334, 7338);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 212, 7334, 7338)[2], String.class, 212, 7334, 7341)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 212, 7334, 7338);
                            CallChecker.isCalled(parts, String[].class, 212, 7334, 7338)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 212, 7334, 7338)[2], String.class, 212, 7334, 7341);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 212, 7334, 7338)[2], String.class, 212, 7334, 7341).indexOf(']');
                            CallChecker.varAssign(end, "end", 212, 7328, 7355);
                        }
                    }
                    if (opt2) {
                        if (CallChecker.beforeDeref(parts, String[].class, 215, 7420, 7424)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 215, 7420, 7424);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 215, 7420, 7424)[2], String.class, 215, 7420, 7427)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 215, 7409, 7411)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 215, 7420, 7424);
                                    CallChecker.isCalled(parts, String[].class, 215, 7420, 7424)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 215, 7420, 7424)[2], String.class, 215, 7420, 7427);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 215, 7409, 7411);
                                    CallChecker.isCalled(msg, StringBuffer.class, 215, 7409, 7411).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 215, 7420, 7424)[2], String.class, 215, 7420, 7427).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 219, 7550, 7554)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 219, 7550, 7554);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 219, 7550, 7554)[2], String.class, 219, 7550, 7557)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 219, 7539, 7541)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 219, 7550, 7554);
                                CallChecker.isCalled(parts, String[].class, 219, 7550, 7554)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 219, 7550, 7554)[2], String.class, 219, 7550, 7557);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 219, 7539, 7541);
                                CallChecker.isCalled(msg, StringBuffer.class, 219, 7539, 7541).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 219, 7550, 7554)[2], String.class, 219, 7550, 7557).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 222, 7636, 7640)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 222, 7636, 7640);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 222, 7636, 7640)[3], String.class, 222, 7636, 7643)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 222, 7636, 7640);
                            CallChecker.isCalled(parts, String[].class, 222, 7636, 7640)[3] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 222, 7636, 7640)[3], String.class, 222, 7636, 7643);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 222, 7636, 7640)[3], String.class, 222, 7636, 7643).indexOf(']');
                            CallChecker.varAssign(end, "end", 222, 7630, 7657);
                        }
                    }
                    if (opt3) {
                        if (CallChecker.beforeDeref(parts, String[].class, 225, 7722, 7726)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 225, 7722, 7726);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 225, 7722, 7726)[3], String.class, 225, 7722, 7729)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 225, 7711, 7713)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 225, 7722, 7726);
                                    CallChecker.isCalled(parts, String[].class, 225, 7722, 7726)[3] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 225, 7722, 7726)[3], String.class, 225, 7722, 7729);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 225, 7711, 7713);
                                    CallChecker.isCalled(msg, StringBuffer.class, 225, 7711, 7713).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 225, 7722, 7726)[3], String.class, 225, 7722, 7729).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 229, 7852, 7856)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 229, 7852, 7856);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 229, 7852, 7856)[3], String.class, 229, 7852, 7859)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 229, 7841, 7843)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 229, 7852, 7856);
                                CallChecker.isCalled(parts, String[].class, 229, 7852, 7856)[3] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 229, 7852, 7856)[3], String.class, 229, 7852, 7859);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 229, 7841, 7843);
                                CallChecker.isCalled(msg, StringBuffer.class, 229, 7841, 7843).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 229, 7852, 7856)[3], String.class, 229, 7852, 7859).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 232, 7940, 7944)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 232, 7940, 7944);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 232, 7940, 7944)[4], String.class, 232, 7940, 7947)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 232, 7940, 7944);
                            CallChecker.isCalled(parts, String[].class, 232, 7940, 7944)[4] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 232, 7940, 7944)[4], String.class, 232, 7940, 7947);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 232, 7940, 7944)[4], String.class, 232, 7940, 7947).indexOf(']');
                            CallChecker.varAssign(end, "end", 232, 7934, 7961);
                        }
                    }
                    if (opt4) {
                        if (CallChecker.beforeDeref(parts, String[].class, 235, 8026, 8030)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 235, 8026, 8030);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 235, 8026, 8030)[4], String.class, 235, 8026, 8033)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 235, 8015, 8017)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 235, 8026, 8030);
                                    CallChecker.isCalled(parts, String[].class, 235, 8026, 8030)[4] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 235, 8026, 8030)[4], String.class, 235, 8026, 8033);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 235, 8015, 8017);
                                    CallChecker.isCalled(msg, StringBuffer.class, 235, 8015, 8017).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 235, 8026, 8030)[4], String.class, 235, 8026, 8033).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 239, 8156, 8160)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 239, 8156, 8160);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 239, 8156, 8160)[4], String.class, 239, 8156, 8163)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 239, 8145, 8147)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 239, 8156, 8160);
                                CallChecker.isCalled(parts, String[].class, 239, 8156, 8160)[4] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 239, 8156, 8160)[4], String.class, 239, 8156, 8163);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 239, 8145, 8147);
                                CallChecker.isCalled(msg, StringBuffer.class, 239, 8145, 8147).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 239, 8156, 8160)[4], String.class, 239, 8156, 8163).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 242, 8257, 8261)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 242, 8257, 8261);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 242, 8257, 8261)[5], String.class, 242, 8257, 8264)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 242, 8257, 8261);
                            CallChecker.isCalled(parts, String[].class, 242, 8257, 8261)[5] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 242, 8257, 8261)[5], String.class, 242, 8257, 8264);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 242, 8257, 8261)[5], String.class, 242, 8257, 8264).indexOf(']');
                            CallChecker.varAssign(end, "end", 242, 8251, 8278);
                        }
                    }
                    if (opt5) {
                        if (CallChecker.beforeDeref(parts, String[].class, 245, 8343, 8347)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 245, 8343, 8347);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 245, 8343, 8347)[5], String.class, 245, 8343, 8350)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 245, 8332, 8334)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 245, 8343, 8347);
                                    CallChecker.isCalled(parts, String[].class, 245, 8343, 8347)[5] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 245, 8343, 8347)[5], String.class, 245, 8343, 8350);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 245, 8332, 8334);
                                    CallChecker.isCalled(msg, StringBuffer.class, 245, 8332, 8334).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 245, 8343, 8347)[5], String.class, 245, 8343, 8350).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 249, 8473, 8477)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 249, 8473, 8477);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 249, 8473, 8477)[5], String.class, 249, 8473, 8480)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 249, 8462, 8464)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 249, 8473, 8477);
                                CallChecker.isCalled(parts, String[].class, 249, 8473, 8477)[5] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 249, 8473, 8477)[5], String.class, 249, 8473, 8480);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 249, 8462, 8464);
                                CallChecker.isCalled(msg, StringBuffer.class, 249, 8462, 8464).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 249, 8473, 8477)[5], String.class, 249, 8473, 8480).substring((end + 1)));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(msg, StringBuffer.class, 252, 8535, 8537)) {
                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 252, 8535, 8537);
                rawMessage = CallChecker.isCalled(msg, StringBuffer.class, 252, 8535, 8537).toString();
                CallChecker.varAssign(rawMessage, "rawMessage", 252, 8522, 8549);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 254, 8560, 8610);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, QueueMessages._currentLocale), "formatter", 257, 8760, 8831);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 259, 8865, 8873);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 259, 8865, 8873).format(messageArguments), "message", 259, 8842, 8899);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context288 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 263, 8956, 9039);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context288.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context289 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 268, 9054, 9158);
                        return QueueMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context289.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context290 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 274, 9173, 9660);
                        CallChecker.varInit(o, "o", 274, 9173, 9660);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 285, 9495, 9533);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 287, 9584, 9587)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 287, 9629, 9632)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 287, 9559, 9575).equals(CallChecker.isCalled(that, LogMessage.class, 287, 9584, 9587).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 287, 9611, 9620).equals(CallChecker.isCalled(that, LogMessage.class, 287, 9629, 9632).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context290.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context291 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 292, 9675, 9897);
                        final String npe_invocation_var25 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var25, String.class, 294, 9762, 9771)) {
                            result = CallChecker.isCalled(npe_invocation_var25, String.class, 294, 9762, 9771).hashCode();
                            CallChecker.varAssign(result, "result", 294, 9762, 9771);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 295, 9824, 9840).hashCode());
                        CallChecker.varAssign(result, "result", 295, 9801, 9852);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context291.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context292.methodEnd();
        }
    }

    public static LogMessage DELETED() {
        MethodContext _bcornu_methode_context297 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.DELETED_LOG_HIERARCHY", 308, 9921, 11296);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.CREATED_LOG_HIERARCHY", 308, 9921, 11296);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.UNDERFULL_LOG_HIERARCHY", 308, 9921, 11296);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.OVERFULL_LOG_HIERARCHY", 308, 9921, 11296);
            CallChecker.varInit(QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.QueueMessages.QUEUE_LOG_HIERARCHY", 308, 9921, 11296);
            CallChecker.varInit(QueueMessages._currentLocale, "org.apache.qpid.server.logging.messages.QueueMessages._currentLocale", 308, 9921, 11296);
            CallChecker.varInit(QueueMessages._messages, "org.apache.qpid.server.logging.messages.QueueMessages._messages", 308, 9921, 11296);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(QueueMessages._messages, ResourceBundle.class, 310, 10207, 10215)) {
                QueueMessages._messages = CallChecker.beforeCalled(QueueMessages._messages, ResourceBundle.class, 310, 10207, 10215);
                rawMessage = CallChecker.isCalled(QueueMessages._messages, ResourceBundle.class, 310, 10207, 10215).getString("DELETED");
                CallChecker.varAssign(rawMessage, "rawMessage", 310, 10207, 10215);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 312, 10248, 10281);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context293 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 316, 10338, 10421);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context293.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context294 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 321, 10436, 10540);
                        return QueueMessages.DELETED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context294.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context295 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 327, 10555, 11042);
                        CallChecker.varInit(o, "o", 327, 10555, 11042);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 338, 10877, 10915);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 340, 10966, 10969)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 340, 11011, 11014)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 340, 10941, 10957).equals(CallChecker.isCalled(that, LogMessage.class, 340, 10966, 10969).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 340, 10993, 11002).equals(CallChecker.isCalled(that, LogMessage.class, 340, 11011, 11014).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context295.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context296 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 345, 11057, 11279);
                        final String npe_invocation_var26 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var26, String.class, 347, 11144, 11153)) {
                            result = CallChecker.isCalled(npe_invocation_var26, String.class, 347, 11144, 11153).hashCode();
                            CallChecker.varAssign(result, "result", 347, 11144, 11153);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 348, 11206, 11222).hashCode());
                        CallChecker.varAssign(result, "result", 348, 11183, 11234);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context296.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context297.methodEnd();
        }
    }

    private QueueMessages() {
        MethodContext _bcornu_methode_context25 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }
}

