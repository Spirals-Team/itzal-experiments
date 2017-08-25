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

public class BindingMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String BINDING_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "binding";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "binding.created";

    public static final String DELETED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "binding.deleted";

    static {
        LoggerFactory.getLogger(BindingMessages.BINDING_LOG_HIERARCHY);
        LoggerFactory.getLogger(BindingMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(BindingMessages.DELETED_LOG_HIERARCHY);
        BindingMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Binding_logmessages", BindingMessages._currentLocale);
        CallChecker.varAssign(BindingMessages._messages, "BindingMessages._messages", 57, 2169, 2284);
    }

    public static LogMessage CREATED(String param1, boolean opt1) {
        MethodContext _bcornu_methode_context715 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(opt1, "opt1", 67, 2297, 4701);
            CallChecker.varInit(param1, "param1", 67, 2297, 4701);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BindingMessages.DELETED_LOG_HIERARCHY", 67, 2297, 4701);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BindingMessages.CREATED_LOG_HIERARCHY", 67, 2297, 4701);
            CallChecker.varInit(BINDING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BindingMessages.BINDING_LOG_HIERARCHY", 67, 2297, 4701);
            CallChecker.varInit(BindingMessages._currentLocale, "org.apache.qpid.server.logging.messages.BindingMessages._currentLocale", 67, 2297, 4701);
            CallChecker.varInit(BindingMessages._messages, "org.apache.qpid.server.logging.messages.BindingMessages._messages", 67, 2297, 4701);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BindingMessages._messages, ResourceBundle.class, 69, 2631, 2639)) {
                BindingMessages._messages = CallChecker.beforeCalled(BindingMessages._messages, ResourceBundle.class, 69, 2631, 2639);
                rawMessage = CallChecker.isCalled(BindingMessages._messages, ResourceBundle.class, 69, 2631, 2639).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 69, 2631, 2639);
            }
            StringBuffer msg = CallChecker.varInit(new StringBuffer(), "msg", 70, 2671, 2708);
            String[] parts = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(rawMessage, String.class, 74, 2873, 2882)) {
                rawMessage = CallChecker.beforeCalled(rawMessage, String.class, 74, 2873, 2882);
                parts = CallChecker.isCalled(rawMessage, String.class, 74, 2873, 2882).split("\\[");
                CallChecker.varAssign(parts, "parts", 74, 2873, 2882);
            }
            if (CallChecker.beforeDeref(parts, String[].class, 75, 2917, 2921)) {
                if (CallChecker.beforeDeref(msg, StringBuffer.class, 75, 2906, 2908)) {
                    parts = CallChecker.beforeCalled(parts, String[].class, 75, 2917, 2921);
                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 75, 2906, 2908);
                    CallChecker.isCalled(msg, StringBuffer.class, 75, 2906, 2908).append(CallChecker.isCalled(parts, String[].class, 75, 2917, 2921)[0]);
                }
            }
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(parts, String[].class, 78, 2958, 2962)) {
                parts = CallChecker.beforeCalled(parts, String[].class, 78, 2958, 2962);
                if ((CallChecker.isCalled(parts, String[].class, 78, 2958, 2962).length) > 1) {
                    if (CallChecker.beforeDeref(parts, String[].class, 82, 3052, 3056)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 82, 3052, 3056);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 82, 3052, 3056)[1], String.class, 82, 3052, 3059)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 82, 3052, 3056);
                            CallChecker.isCalled(parts, String[].class, 82, 3052, 3056)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 82, 3052, 3056)[1], String.class, 82, 3052, 3059);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 82, 3052, 3056)[1], String.class, 82, 3052, 3059).indexOf(']');
                            CallChecker.varAssign(end, "end", 82, 3046, 3073);
                        }
                    }
                    if (opt1) {
                        if (CallChecker.beforeDeref(parts, String[].class, 85, 3138, 3142)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 85, 3138, 3142);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 85, 3138, 3142)[1], String.class, 85, 3138, 3145)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 85, 3127, 3129)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 85, 3138, 3142);
                                    CallChecker.isCalled(parts, String[].class, 85, 3138, 3142)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 85, 3138, 3142)[1], String.class, 85, 3138, 3145);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 85, 3127, 3129);
                                    CallChecker.isCalled(msg, StringBuffer.class, 85, 3127, 3129).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 85, 3138, 3142)[1], String.class, 85, 3138, 3145).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 89, 3268, 3272)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 89, 3268, 3272);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 89, 3268, 3272)[1], String.class, 89, 3268, 3275)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 89, 3257, 3259)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 89, 3268, 3272);
                                CallChecker.isCalled(parts, String[].class, 89, 3268, 3272)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 89, 3268, 3272)[1], String.class, 89, 3268, 3275);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 89, 3257, 3259);
                                CallChecker.isCalled(msg, StringBuffer.class, 89, 3257, 3259).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 89, 3268, 3272)[1], String.class, 89, 3268, 3275).substring((end + 1)));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(msg, StringBuffer.class, 92, 3330, 3332)) {
                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 92, 3330, 3332);
                rawMessage = CallChecker.isCalled(msg, StringBuffer.class, 92, 3330, 3332).toString();
                CallChecker.varAssign(rawMessage, "rawMessage", 92, 3317, 3344);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 94, 3355, 3397);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, BindingMessages._currentLocale), "formatter", 97, 3547, 3618);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 99, 3652, 3660);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 99, 3652, 3660).format(messageArguments), "message", 99, 3629, 3686);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context711 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 103, 3743, 3826);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context711.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context712 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 108, 3841, 3945);
                        return BindingMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context712.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context713 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 114, 3960, 4447);
                        CallChecker.varInit(o, "o", 114, 3960, 4447);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 125, 4282, 4320);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 127, 4371, 4374)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 127, 4416, 4419)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 127, 4346, 4362).equals(CallChecker.isCalled(that, LogMessage.class, 127, 4371, 4374).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 127, 4398, 4407).equals(CallChecker.isCalled(that, LogMessage.class, 127, 4416, 4419).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context713.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context714 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 132, 4462, 4684);
                        final String npe_invocation_var96 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var96, String.class, 134, 4549, 4558)) {
                            result = CallChecker.isCalled(npe_invocation_var96, String.class, 134, 4549, 4558).hashCode();
                            CallChecker.varAssign(result, "result", 134, 4549, 4558);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 135, 4611, 4627).hashCode());
                        CallChecker.varAssign(result, "result", 135, 4588, 4639);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context714.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context715.methodEnd();
        }
    }

    public static LogMessage DELETED() {
        MethodContext _bcornu_methode_context720 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BindingMessages.DELETED_LOG_HIERARCHY", 148, 4708, 6085);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BindingMessages.CREATED_LOG_HIERARCHY", 148, 4708, 6085);
            CallChecker.varInit(BINDING_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.BindingMessages.BINDING_LOG_HIERARCHY", 148, 4708, 6085);
            CallChecker.varInit(BindingMessages._currentLocale, "org.apache.qpid.server.logging.messages.BindingMessages._currentLocale", 148, 4708, 6085);
            CallChecker.varInit(BindingMessages._messages, "org.apache.qpid.server.logging.messages.BindingMessages._messages", 148, 4708, 6085);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(BindingMessages._messages, ResourceBundle.class, 150, 4996, 5004)) {
                BindingMessages._messages = CallChecker.beforeCalled(BindingMessages._messages, ResourceBundle.class, 150, 4996, 5004);
                rawMessage = CallChecker.isCalled(BindingMessages._messages, ResourceBundle.class, 150, 4996, 5004).getString("DELETED");
                CallChecker.varAssign(rawMessage, "rawMessage", 150, 4996, 5004);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 152, 5037, 5070);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context716 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 156, 5127, 5210);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context716.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context717 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 161, 5225, 5329);
                        return BindingMessages.DELETED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context717.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context718 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 167, 5344, 5831);
                        CallChecker.varInit(o, "o", 167, 5344, 5831);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 178, 5666, 5704);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 180, 5755, 5758)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 180, 5800, 5803)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 180, 5730, 5746).equals(CallChecker.isCalled(that, LogMessage.class, 180, 5755, 5758).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 180, 5782, 5791).equals(CallChecker.isCalled(that, LogMessage.class, 180, 5800, 5803).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context718.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context719 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 185, 5846, 6068);
                        final String npe_invocation_var97 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var97, String.class, 187, 5933, 5942)) {
                            result = CallChecker.isCalled(npe_invocation_var97, String.class, 187, 5933, 5942).hashCode();
                            CallChecker.varAssign(result, "result", 187, 5933, 5942);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 188, 5995, 6011).hashCode());
                        CallChecker.varAssign(result, "result", 188, 5972, 6023);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context719.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context720.methodEnd();
        }
    }

    private BindingMessages() {
        MethodContext _bcornu_methode_context45 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }
}

