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

public class ExchangeMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String EXCHANGE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "exchange";

    public static final String DISCARDMSG_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "exchange.discardmsg";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "exchange.created";

    public static final String DELETED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "exchange.deleted";

    static {
        LoggerFactory.getLogger(ExchangeMessages.EXCHANGE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ExchangeMessages.DISCARDMSG_LOG_HIERARCHY);
        LoggerFactory.getLogger(ExchangeMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(ExchangeMessages.DELETED_LOG_HIERARCHY);
        ExchangeMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Exchange_logmessages", ExchangeMessages._currentLocale);
        CallChecker.varAssign(ExchangeMessages._messages, "ExchangeMessages._messages", 59, 2347, 2463);
    }

    public static LogMessage DISCARDMSG(String param1, String param2) {
        MethodContext _bcornu_methode_context103 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 69, 2476, 4240);
            CallChecker.varInit(param1, "param1", 69, 2476, 4240);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.DELETED_LOG_HIERARCHY", 69, 2476, 4240);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.CREATED_LOG_HIERARCHY", 69, 2476, 4240);
            CallChecker.varInit(DISCARDMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.DISCARDMSG_LOG_HIERARCHY", 69, 2476, 4240);
            CallChecker.varInit(EXCHANGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.EXCHANGE_LOG_HIERARCHY", 69, 2476, 4240);
            CallChecker.varInit(ExchangeMessages._currentLocale, "org.apache.qpid.server.logging.messages.ExchangeMessages._currentLocale", 69, 2476, 4240);
            CallChecker.varInit(ExchangeMessages._messages, "org.apache.qpid.server.logging.messages.ExchangeMessages._messages", 69, 2476, 4240);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ExchangeMessages._messages, ResourceBundle.class, 71, 2839, 2847)) {
                ExchangeMessages._messages = CallChecker.beforeCalled(ExchangeMessages._messages, ResourceBundle.class, 71, 2839, 2847);
                rawMessage = CallChecker.isCalled(ExchangeMessages._messages, ResourceBundle.class, 71, 2839, 2847).getString("DISCARDMSG");
                CallChecker.varAssign(rawMessage, "rawMessage", 71, 2839, 2847);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 73, 2883, 2933);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ExchangeMessages._currentLocale), "formatter", 76, 3083, 3154);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 78, 3188, 3196);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 78, 3188, 3196).format(messageArguments), "message", 78, 3165, 3222);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context99 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 82, 3279, 3362);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context99.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context100 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 87, 3377, 3484);
                        return ExchangeMessages.DISCARDMSG_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context100.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context101 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 93, 3499, 3986);
                        CallChecker.varInit(o, "o", 93, 3499, 3986);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 104, 3821, 3859);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 106, 3910, 3913)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 106, 3955, 3958)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 106, 3885, 3901).equals(CallChecker.isCalled(that, LogMessage.class, 106, 3910, 3913).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 106, 3937, 3946).equals(CallChecker.isCalled(that, LogMessage.class, 106, 3955, 3958).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context101.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context102 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 111, 4001, 4223);
                        final String npe_invocation_var0 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var0, String.class, 113, 4088, 4097)) {
                            result = CallChecker.isCalled(npe_invocation_var0, String.class, 113, 4088, 4097).hashCode();
                            CallChecker.varAssign(result, "result", 113, 4088, 4097);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 114, 4150, 4166).hashCode());
                        CallChecker.varAssign(result, "result", 114, 4127, 4178);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context102.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public static LogMessage CREATED(String param1, String param2, boolean opt1) {
        MethodContext _bcornu_methode_context108 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(opt1, "opt1", 127, 4247, 6677);
            CallChecker.varInit(param2, "param2", 127, 4247, 6677);
            CallChecker.varInit(param1, "param1", 127, 4247, 6677);
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.DELETED_LOG_HIERARCHY", 127, 4247, 6677);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.CREATED_LOG_HIERARCHY", 127, 4247, 6677);
            CallChecker.varInit(DISCARDMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.DISCARDMSG_LOG_HIERARCHY", 127, 4247, 6677);
            CallChecker.varInit(EXCHANGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.EXCHANGE_LOG_HIERARCHY", 127, 4247, 6677);
            CallChecker.varInit(ExchangeMessages._currentLocale, "org.apache.qpid.server.logging.messages.ExchangeMessages._currentLocale", 127, 4247, 6677);
            CallChecker.varInit(ExchangeMessages._messages, "org.apache.qpid.server.logging.messages.ExchangeMessages._messages", 127, 4247, 6677);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ExchangeMessages._messages, ResourceBundle.class, 129, 4609, 4617)) {
                ExchangeMessages._messages = CallChecker.beforeCalled(ExchangeMessages._messages, ResourceBundle.class, 129, 4609, 4617);
                rawMessage = CallChecker.isCalled(ExchangeMessages._messages, ResourceBundle.class, 129, 4609, 4617).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 129, 4609, 4617);
            }
            StringBuffer msg = CallChecker.varInit(new StringBuffer(), "msg", 130, 4649, 4686);
            String[] parts = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(rawMessage, String.class, 134, 4851, 4860)) {
                rawMessage = CallChecker.beforeCalled(rawMessage, String.class, 134, 4851, 4860);
                parts = CallChecker.isCalled(rawMessage, String.class, 134, 4851, 4860).split("\\[");
                CallChecker.varAssign(parts, "parts", 134, 4851, 4860);
            }
            if (CallChecker.beforeDeref(parts, String[].class, 135, 4895, 4899)) {
                if (CallChecker.beforeDeref(msg, StringBuffer.class, 135, 4884, 4886)) {
                    parts = CallChecker.beforeCalled(parts, String[].class, 135, 4895, 4899);
                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 135, 4884, 4886);
                    CallChecker.isCalled(msg, StringBuffer.class, 135, 4884, 4886).append(CallChecker.isCalled(parts, String[].class, 135, 4895, 4899)[0]);
                }
            }
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(parts, String[].class, 138, 4936, 4940)) {
                parts = CallChecker.beforeCalled(parts, String[].class, 138, 4936, 4940);
                if ((CallChecker.isCalled(parts, String[].class, 138, 4936, 4940).length) > 1) {
                    if (CallChecker.beforeDeref(parts, String[].class, 142, 5020, 5024)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 142, 5020, 5024);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 142, 5020, 5024)[1], String.class, 142, 5020, 5027)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 142, 5020, 5024);
                            CallChecker.isCalled(parts, String[].class, 142, 5020, 5024)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 142, 5020, 5024)[1], String.class, 142, 5020, 5027);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 142, 5020, 5024)[1], String.class, 142, 5020, 5027).indexOf(']');
                            CallChecker.varAssign(end, "end", 142, 5014, 5041);
                        }
                    }
                    if (opt1) {
                        if (CallChecker.beforeDeref(parts, String[].class, 145, 5106, 5110)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 145, 5106, 5110);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 145, 5106, 5110)[1], String.class, 145, 5106, 5113)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 145, 5095, 5097)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 145, 5106, 5110);
                                    CallChecker.isCalled(parts, String[].class, 145, 5106, 5110)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 145, 5106, 5110)[1], String.class, 145, 5106, 5113);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 145, 5095, 5097);
                                    CallChecker.isCalled(msg, StringBuffer.class, 145, 5095, 5097).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 145, 5106, 5110)[1], String.class, 145, 5106, 5113).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 149, 5236, 5240)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 149, 5236, 5240);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 149, 5236, 5240)[1], String.class, 149, 5236, 5243)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 149, 5225, 5227)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 149, 5236, 5240);
                                CallChecker.isCalled(parts, String[].class, 149, 5236, 5240)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 149, 5236, 5240)[1], String.class, 149, 5236, 5243);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 149, 5225, 5227);
                                CallChecker.isCalled(msg, StringBuffer.class, 149, 5225, 5227).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 149, 5236, 5240)[1], String.class, 149, 5236, 5243).substring((end + 1)));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(msg, StringBuffer.class, 152, 5298, 5300)) {
                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 152, 5298, 5300);
                rawMessage = CallChecker.isCalled(msg, StringBuffer.class, 152, 5298, 5300).toString();
                CallChecker.varAssign(rawMessage, "rawMessage", 152, 5285, 5312);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 154, 5323, 5373);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ExchangeMessages._currentLocale), "formatter", 157, 5523, 5594);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 159, 5628, 5636);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 159, 5628, 5636).format(messageArguments), "message", 159, 5605, 5662);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context104 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 163, 5719, 5802);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context104.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context105 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 168, 5817, 5921);
                        return ExchangeMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context105.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context106 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 174, 5936, 6423);
                        CallChecker.varInit(o, "o", 174, 5936, 6423);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 185, 6258, 6296);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 187, 6347, 6350)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 187, 6392, 6395)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 187, 6322, 6338).equals(CallChecker.isCalled(that, LogMessage.class, 187, 6347, 6350).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 187, 6374, 6383).equals(CallChecker.isCalled(that, LogMessage.class, 187, 6392, 6395).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context106.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context107 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 192, 6438, 6660);
                        final String npe_invocation_var1 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var1, String.class, 194, 6525, 6534)) {
                            result = CallChecker.isCalled(npe_invocation_var1, String.class, 194, 6525, 6534).hashCode();
                            CallChecker.varAssign(result, "result", 194, 6525, 6534);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 195, 6587, 6603).hashCode());
                        CallChecker.varAssign(result, "result", 195, 6564, 6615);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context107.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public static LogMessage DELETED() {
        MethodContext _bcornu_methode_context113 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(DELETED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.DELETED_LOG_HIERARCHY", 208, 6684, 8062);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.CREATED_LOG_HIERARCHY", 208, 6684, 8062);
            CallChecker.varInit(DISCARDMSG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.DISCARDMSG_LOG_HIERARCHY", 208, 6684, 8062);
            CallChecker.varInit(EXCHANGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ExchangeMessages.EXCHANGE_LOG_HIERARCHY", 208, 6684, 8062);
            CallChecker.varInit(ExchangeMessages._currentLocale, "org.apache.qpid.server.logging.messages.ExchangeMessages._currentLocale", 208, 6684, 8062);
            CallChecker.varInit(ExchangeMessages._messages, "org.apache.qpid.server.logging.messages.ExchangeMessages._messages", 208, 6684, 8062);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ExchangeMessages._messages, ResourceBundle.class, 210, 6973, 6981)) {
                ExchangeMessages._messages = CallChecker.beforeCalled(ExchangeMessages._messages, ResourceBundle.class, 210, 6973, 6981);
                rawMessage = CallChecker.isCalled(ExchangeMessages._messages, ResourceBundle.class, 210, 6973, 6981).getString("DELETED");
                CallChecker.varAssign(rawMessage, "rawMessage", 210, 6973, 6981);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 212, 7014, 7047);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context109 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 216, 7104, 7187);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context109.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context110 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 221, 7202, 7306);
                        return ExchangeMessages.DELETED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context110.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context111 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 227, 7321, 7808);
                        CallChecker.varInit(o, "o", 227, 7321, 7808);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 238, 7643, 7681);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 240, 7732, 7735)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 240, 7777, 7780)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 240, 7707, 7723).equals(CallChecker.isCalled(that, LogMessage.class, 240, 7732, 7735).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 240, 7759, 7768).equals(CallChecker.isCalled(that, LogMessage.class, 240, 7777, 7780).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context111.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context112 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 245, 7823, 8045);
                        final String npe_invocation_var2 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var2, String.class, 247, 7910, 7919)) {
                            result = CallChecker.isCalled(npe_invocation_var2, String.class, 247, 7910, 7919).hashCode();
                            CallChecker.varAssign(result, "result", 247, 7910, 7919);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 248, 7972, 7988).hashCode());
                        CallChecker.varAssign(result, "result", 248, 7949, 8000);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context112.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    private ExchangeMessages() {
        MethodContext _bcornu_methode_context11 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }
}

