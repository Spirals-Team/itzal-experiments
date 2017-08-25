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

public class TransactionLogMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String TRANSACTIONLOG_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog";

    public static final String CLOSED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.closed";

    public static final String RECOVERY_COMPLETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.recovery_complete";

    public static final String XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.xa_incomplete_message";

    public static final String XA_INCOMPLETE_QUEUE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.xa_incomplete_queue";

    public static final String RECOVERED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.recovered";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.created";

    public static final String STORE_LOCATION_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.store_location";

    public static final String RECOVERY_START_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "transactionlog.recovery_start";

    static {
        LoggerFactory.getLogger(TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.CLOSED_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.RECOVERED_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY);
        LoggerFactory.getLogger(TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY);
        TransactionLogMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.TransactionLog_logmessages", TransactionLogMessages._currentLocale);
        CallChecker.varAssign(TransactionLogMessages._messages, "TransactionLogMessages._messages", 69, 3379, 3501);
    }

    public static LogMessage CLOSED() {
        MethodContext _bcornu_methode_context242 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 79, 3514, 4894);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 79, 3514, 4894);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 79, 3514, 4894);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 81, 3807, 3815)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 81, 3807, 3815);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 81, 3807, 3815).getString("CLOSED");
                CallChecker.varAssign(rawMessage, "rawMessage", 81, 3807, 3815);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 83, 3847, 3880);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context238 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 87, 3937, 4020);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context238.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context239 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 92, 4035, 4138);
                        return TransactionLogMessages.CLOSED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context239.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context240 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 98, 4153, 4640);
                        CallChecker.varInit(o, "o", 98, 4153, 4640);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 109, 4475, 4513);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 111, 4564, 4567)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 111, 4609, 4612)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 111, 4539, 4555).equals(CallChecker.isCalled(that, LogMessage.class, 111, 4564, 4567).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 111, 4591, 4600).equals(CallChecker.isCalled(that, LogMessage.class, 111, 4609, 4612).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context240.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context241 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 116, 4655, 4877);
                        final String npe_invocation_var15 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var15, String.class, 118, 4742, 4751)) {
                            result = CallChecker.isCalled(npe_invocation_var15, String.class, 118, 4742, 4751).hashCode();
                            CallChecker.varAssign(result, "result", 118, 4742, 4751);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 119, 4804, 4820).hashCode());
                        CallChecker.varAssign(result, "result", 119, 4781, 4832);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context241.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context242.methodEnd();
        }
    }

    public static LogMessage RECOVERY_COMPLETE(String param1, boolean opt1) {
        MethodContext _bcornu_methode_context247 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(opt1, "opt1", 132, 4901, 7329);
            CallChecker.varInit(param1, "param1", 132, 4901, 7329);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 132, 4901, 7329);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 132, 4901, 7329);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 132, 4901, 7329);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 134, 5251, 5259)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 134, 5251, 5259);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 134, 5251, 5259).getString("RECOVERY_COMPLETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 134, 5251, 5259);
            }
            StringBuffer msg = CallChecker.varInit(new StringBuffer(), "msg", 135, 5301, 5338);
            String[] parts = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(rawMessage, String.class, 139, 5503, 5512)) {
                rawMessage = CallChecker.beforeCalled(rawMessage, String.class, 139, 5503, 5512);
                parts = CallChecker.isCalled(rawMessage, String.class, 139, 5503, 5512).split("\\[");
                CallChecker.varAssign(parts, "parts", 139, 5503, 5512);
            }
            if (CallChecker.beforeDeref(parts, String[].class, 140, 5547, 5551)) {
                if (CallChecker.beforeDeref(msg, StringBuffer.class, 140, 5536, 5538)) {
                    parts = CallChecker.beforeCalled(parts, String[].class, 140, 5547, 5551);
                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 140, 5536, 5538);
                    CallChecker.isCalled(msg, StringBuffer.class, 140, 5536, 5538).append(CallChecker.isCalled(parts, String[].class, 140, 5547, 5551)[0]);
                }
            }
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(parts, String[].class, 143, 5588, 5592)) {
                parts = CallChecker.beforeCalled(parts, String[].class, 143, 5588, 5592);
                if ((CallChecker.isCalled(parts, String[].class, 143, 5588, 5592).length) > 1) {
                    if (CallChecker.beforeDeref(parts, String[].class, 147, 5670, 5674)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 147, 5670, 5674);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 147, 5670, 5674)[1], String.class, 147, 5670, 5677)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 147, 5670, 5674);
                            CallChecker.isCalled(parts, String[].class, 147, 5670, 5674)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 147, 5670, 5674)[1], String.class, 147, 5670, 5677);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 147, 5670, 5674)[1], String.class, 147, 5670, 5677).indexOf(']');
                            CallChecker.varAssign(end, "end", 147, 5664, 5691);
                        }
                    }
                    if (opt1) {
                        if (CallChecker.beforeDeref(parts, String[].class, 150, 5756, 5760)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 150, 5756, 5760);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 150, 5756, 5760)[1], String.class, 150, 5756, 5763)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 150, 5745, 5747)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 150, 5756, 5760);
                                    CallChecker.isCalled(parts, String[].class, 150, 5756, 5760)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 150, 5756, 5760)[1], String.class, 150, 5756, 5763);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 150, 5745, 5747);
                                    CallChecker.isCalled(msg, StringBuffer.class, 150, 5745, 5747).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 150, 5756, 5760)[1], String.class, 150, 5756, 5763).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 154, 5886, 5890)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 154, 5886, 5890);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 154, 5886, 5890)[1], String.class, 154, 5886, 5893)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 154, 5875, 5877)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 154, 5886, 5890);
                                CallChecker.isCalled(parts, String[].class, 154, 5886, 5890)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 154, 5886, 5890)[1], String.class, 154, 5886, 5893);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 154, 5875, 5877);
                                CallChecker.isCalled(msg, StringBuffer.class, 154, 5875, 5877).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 154, 5886, 5890)[1], String.class, 154, 5886, 5893).substring((end + 1)));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(msg, StringBuffer.class, 157, 5948, 5950)) {
                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 157, 5948, 5950);
                rawMessage = CallChecker.isCalled(msg, StringBuffer.class, 157, 5948, 5950).toString();
                CallChecker.varAssign(rawMessage, "rawMessage", 157, 5935, 5962);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 159, 5973, 6015);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TransactionLogMessages._currentLocale), "formatter", 162, 6165, 6236);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 164, 6270, 6278);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 164, 6270, 6278).format(messageArguments), "message", 164, 6247, 6304);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context243 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 168, 6361, 6444);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context243.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context244 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 173, 6459, 6573);
                        return TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context244.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context245 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 179, 6588, 7075);
                        CallChecker.varInit(o, "o", 179, 6588, 7075);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 190, 6910, 6948);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 192, 6999, 7002)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 192, 7044, 7047)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 192, 6974, 6990).equals(CallChecker.isCalled(that, LogMessage.class, 192, 6999, 7002).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 192, 7026, 7035).equals(CallChecker.isCalled(that, LogMessage.class, 192, 7044, 7047).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context245.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context246 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 197, 7090, 7312);
                        final String npe_invocation_var16 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var16, String.class, 199, 7177, 7186)) {
                            result = CallChecker.isCalled(npe_invocation_var16, String.class, 199, 7177, 7186).hashCode();
                            CallChecker.varAssign(result, "result", 199, 7177, 7186);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 200, 7239, 7255).hashCode());
                        CallChecker.varAssign(result, "result", 200, 7216, 7267);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context246.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context247.methodEnd();
        }
    }

    public static LogMessage XA_INCOMPLETE_MESSAGE(String param1, String param2) {
        MethodContext _bcornu_methode_context252 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 213, 7336, 9196);
            CallChecker.varInit(param1, "param1", 213, 7336, 9196);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 213, 7336, 9196);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 213, 7336, 9196);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 213, 7336, 9196);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 215, 7773, 7781)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 215, 7773, 7781);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 215, 7773, 7781).getString("XA_INCOMPLETE_MESSAGE");
                CallChecker.varAssign(rawMessage, "rawMessage", 215, 7773, 7781);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 217, 7828, 7878);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TransactionLogMessages._currentLocale), "formatter", 220, 8028, 8099);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 222, 8133, 8141);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 222, 8133, 8141).format(messageArguments), "message", 222, 8110, 8167);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context248 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 226, 8224, 8307);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context248.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context249 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 231, 8322, 8440);
                        return TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context249.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context250 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 237, 8455, 8942);
                        CallChecker.varInit(o, "o", 237, 8455, 8942);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 248, 8777, 8815);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 250, 8866, 8869)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 250, 8911, 8914)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 250, 8841, 8857).equals(CallChecker.isCalled(that, LogMessage.class, 250, 8866, 8869).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 250, 8893, 8902).equals(CallChecker.isCalled(that, LogMessage.class, 250, 8911, 8914).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context250.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context251 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 255, 8957, 9179);
                        final String npe_invocation_var17 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var17, String.class, 257, 9044, 9053)) {
                            result = CallChecker.isCalled(npe_invocation_var17, String.class, 257, 9044, 9053).hashCode();
                            CallChecker.varAssign(result, "result", 257, 9044, 9053);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 258, 9106, 9122).hashCode());
                        CallChecker.varAssign(result, "result", 258, 9083, 9134);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context251.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context252.methodEnd();
        }
    }

    public static LogMessage XA_INCOMPLETE_QUEUE(String param1, String param2) {
        MethodContext _bcornu_methode_context257 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 271, 9203, 11055);
            CallChecker.varInit(param1, "param1", 271, 9203, 11055);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 271, 9203, 11055);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 271, 9203, 11055);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 271, 9203, 11055);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 273, 9636, 9644)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 273, 9636, 9644);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 273, 9636, 9644).getString("XA_INCOMPLETE_QUEUE");
                CallChecker.varAssign(rawMessage, "rawMessage", 273, 9636, 9644);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 275, 9689, 9739);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TransactionLogMessages._currentLocale), "formatter", 278, 9889, 9960);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 280, 9994, 10002);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 280, 9994, 10002).format(messageArguments), "message", 280, 9971, 10028);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context253 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 284, 10085, 10168);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context253.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context254 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 289, 10183, 10299);
                        return TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context254.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context255 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 295, 10314, 10801);
                        CallChecker.varInit(o, "o", 295, 10314, 10801);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 306, 10636, 10674);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 308, 10725, 10728)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 308, 10770, 10773)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 308, 10700, 10716).equals(CallChecker.isCalled(that, LogMessage.class, 308, 10725, 10728).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 308, 10752, 10761).equals(CallChecker.isCalled(that, LogMessage.class, 308, 10770, 10773).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context255.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context256 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 313, 10816, 11038);
                        final String npe_invocation_var18 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var18, String.class, 315, 10903, 10912)) {
                            result = CallChecker.isCalled(npe_invocation_var18, String.class, 315, 10903, 10912).hashCode();
                            CallChecker.varAssign(result, "result", 315, 10903, 10912);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 316, 10965, 10981).hashCode());
                        CallChecker.varAssign(result, "result", 316, 10942, 10993);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context256.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context257.methodEnd();
        }
    }

    public static LogMessage RECOVERED(Number param1, String param2) {
        MethodContext _bcornu_methode_context262 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param2, "param2", 329, 11062, 12822);
            CallChecker.varInit(param1, "param1", 329, 11062, 12822);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 329, 11062, 12822);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 329, 11062, 12822);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 329, 11062, 12822);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 331, 11423, 11431)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 331, 11423, 11431);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 331, 11423, 11431).getString("RECOVERED");
                CallChecker.varAssign(rawMessage, "rawMessage", 331, 11423, 11431);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 }, "messageArguments", 333, 11466, 11516);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TransactionLogMessages._currentLocale), "formatter", 336, 11666, 11737);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 338, 11771, 11779);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 338, 11771, 11779).format(messageArguments), "message", 338, 11748, 11805);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context258 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 342, 11862, 11945);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context258.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context259 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 347, 11960, 12066);
                        return TransactionLogMessages.RECOVERED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context259.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context260 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 353, 12081, 12568);
                        CallChecker.varInit(o, "o", 353, 12081, 12568);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 364, 12403, 12441);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 366, 12492, 12495)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 366, 12537, 12540)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 366, 12467, 12483).equals(CallChecker.isCalled(that, LogMessage.class, 366, 12492, 12495).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 366, 12519, 12528).equals(CallChecker.isCalled(that, LogMessage.class, 366, 12537, 12540).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context260.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context261 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 371, 12583, 12805);
                        final String npe_invocation_var19 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var19, String.class, 373, 12670, 12679)) {
                            result = CallChecker.isCalled(npe_invocation_var19, String.class, 373, 12670, 12679).hashCode();
                            CallChecker.varAssign(result, "result", 373, 12670, 12679);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 374, 12732, 12748).hashCode());
                        CallChecker.varAssign(result, "result", 374, 12709, 12760);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context261.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context262.methodEnd();
        }
    }

    public static LogMessage CREATED() {
        MethodContext _bcornu_methode_context267 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 387, 12829, 14213);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 387, 12829, 14213);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 387, 12829, 14213);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 389, 13124, 13132)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 389, 13124, 13132);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 389, 13124, 13132).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 389, 13124, 13132);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 391, 13165, 13198);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context263 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 395, 13255, 13338);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context263.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context264 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 400, 13353, 13457);
                        return TransactionLogMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context264.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context265 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 406, 13472, 13959);
                        CallChecker.varInit(o, "o", 406, 13472, 13959);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 417, 13794, 13832);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 419, 13883, 13886)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 419, 13928, 13931)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 419, 13858, 13874).equals(CallChecker.isCalled(that, LogMessage.class, 419, 13883, 13886).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 419, 13910, 13919).equals(CallChecker.isCalled(that, LogMessage.class, 419, 13928, 13931).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context265.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context266 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 424, 13974, 14196);
                        final String npe_invocation_var20 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var20, String.class, 426, 14061, 14070)) {
                            result = CallChecker.isCalled(npe_invocation_var20, String.class, 426, 14061, 14070).hashCode();
                            CallChecker.varAssign(result, "result", 426, 14061, 14070);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 427, 14123, 14139).hashCode());
                        CallChecker.varAssign(result, "result", 427, 14100, 14151);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context266.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context267.methodEnd();
        }
    }

    public static LogMessage STORE_LOCATION(String param1) {
        MethodContext _bcornu_methode_context272 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 440, 14220, 15949);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 440, 14220, 15949);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 440, 14220, 15949);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 440, 14220, 15949);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 442, 14548, 14556)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 442, 14548, 14556);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 442, 14548, 14556).getString("STORE_LOCATION");
                CallChecker.varAssign(rawMessage, "rawMessage", 442, 14548, 14556);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 444, 14596, 14638);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TransactionLogMessages._currentLocale), "formatter", 447, 14788, 14859);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 449, 14893, 14901);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 449, 14893, 14901).format(messageArguments), "message", 449, 14870, 14927);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context268 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 453, 14984, 15067);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context268.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context269 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 458, 15082, 15193);
                        return TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context269.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context270 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 464, 15208, 15695);
                        CallChecker.varInit(o, "o", 464, 15208, 15695);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 475, 15530, 15568);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 477, 15619, 15622)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 477, 15664, 15667)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 477, 15594, 15610).equals(CallChecker.isCalled(that, LogMessage.class, 477, 15619, 15622).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 477, 15646, 15655).equals(CallChecker.isCalled(that, LogMessage.class, 477, 15664, 15667).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context270.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context271 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 482, 15710, 15932);
                        final String npe_invocation_var21 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var21, String.class, 484, 15797, 15806)) {
                            result = CallChecker.isCalled(npe_invocation_var21, String.class, 484, 15797, 15806).hashCode();
                            CallChecker.varAssign(result, "result", 484, 15797, 15806);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 485, 15859, 15875).hashCode());
                        CallChecker.varAssign(result, "result", 485, 15836, 15887);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context271.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context272.methodEnd();
        }
    }

    public static LogMessage RECOVERY_START(String param1, boolean opt1) {
        MethodContext _bcornu_methode_context277 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(opt1, "opt1", 498, 15956, 18372);
            CallChecker.varInit(param1, "param1", 498, 15956, 18372);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.STORE_LOCATION_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CREATED_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERED_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(XA_INCOMPLETE_QUEUE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_QUEUE_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.XA_INCOMPLETE_MESSAGE_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.CLOSED_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(TRANSACTIONLOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TransactionLogMessages.TRANSACTIONLOG_LOG_HIERARCHY", 498, 15956, 18372);
            CallChecker.varInit(TransactionLogMessages._currentLocale, "org.apache.qpid.server.logging.messages.TransactionLogMessages._currentLocale", 498, 15956, 18372);
            CallChecker.varInit(TransactionLogMessages._messages, "org.apache.qpid.server.logging.messages.TransactionLogMessages._messages", 498, 15956, 18372);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TransactionLogMessages._messages, ResourceBundle.class, 500, 16300, 16308)) {
                TransactionLogMessages._messages = CallChecker.beforeCalled(TransactionLogMessages._messages, ResourceBundle.class, 500, 16300, 16308);
                rawMessage = CallChecker.isCalled(TransactionLogMessages._messages, ResourceBundle.class, 500, 16300, 16308).getString("RECOVERY_START");
                CallChecker.varAssign(rawMessage, "rawMessage", 500, 16300, 16308);
            }
            StringBuffer msg = CallChecker.varInit(new StringBuffer(), "msg", 501, 16347, 16384);
            String[] parts = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(rawMessage, String.class, 505, 16549, 16558)) {
                rawMessage = CallChecker.beforeCalled(rawMessage, String.class, 505, 16549, 16558);
                parts = CallChecker.isCalled(rawMessage, String.class, 505, 16549, 16558).split("\\[");
                CallChecker.varAssign(parts, "parts", 505, 16549, 16558);
            }
            if (CallChecker.beforeDeref(parts, String[].class, 506, 16593, 16597)) {
                if (CallChecker.beforeDeref(msg, StringBuffer.class, 506, 16582, 16584)) {
                    parts = CallChecker.beforeCalled(parts, String[].class, 506, 16593, 16597);
                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 506, 16582, 16584);
                    CallChecker.isCalled(msg, StringBuffer.class, 506, 16582, 16584).append(CallChecker.isCalled(parts, String[].class, 506, 16593, 16597)[0]);
                }
            }
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(parts, String[].class, 509, 16634, 16638)) {
                parts = CallChecker.beforeCalled(parts, String[].class, 509, 16634, 16638);
                if ((CallChecker.isCalled(parts, String[].class, 509, 16634, 16638).length) > 1) {
                    if (CallChecker.beforeDeref(parts, String[].class, 513, 16716, 16720)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 513, 16716, 16720);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 513, 16716, 16720)[1], String.class, 513, 16716, 16723)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 513, 16716, 16720);
                            CallChecker.isCalled(parts, String[].class, 513, 16716, 16720)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 513, 16716, 16720)[1], String.class, 513, 16716, 16723);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 513, 16716, 16720)[1], String.class, 513, 16716, 16723).indexOf(']');
                            CallChecker.varAssign(end, "end", 513, 16710, 16737);
                        }
                    }
                    if (opt1) {
                        if (CallChecker.beforeDeref(parts, String[].class, 516, 16802, 16806)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 516, 16802, 16806);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 516, 16802, 16806)[1], String.class, 516, 16802, 16809)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 516, 16791, 16793)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 516, 16802, 16806);
                                    CallChecker.isCalled(parts, String[].class, 516, 16802, 16806)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 516, 16802, 16806)[1], String.class, 516, 16802, 16809);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 516, 16791, 16793);
                                    CallChecker.isCalled(msg, StringBuffer.class, 516, 16791, 16793).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 516, 16802, 16806)[1], String.class, 516, 16802, 16809).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 520, 16932, 16936)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 520, 16932, 16936);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 520, 16932, 16936)[1], String.class, 520, 16932, 16939)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 520, 16921, 16923)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 520, 16932, 16936);
                                CallChecker.isCalled(parts, String[].class, 520, 16932, 16936)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 520, 16932, 16936)[1], String.class, 520, 16932, 16939);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 520, 16921, 16923);
                                CallChecker.isCalled(msg, StringBuffer.class, 520, 16921, 16923).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 520, 16932, 16936)[1], String.class, 520, 16932, 16939).substring((end + 1)));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(msg, StringBuffer.class, 523, 16994, 16996)) {
                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 523, 16994, 16996);
                rawMessage = CallChecker.isCalled(msg, StringBuffer.class, 523, 16994, 16996).toString();
                CallChecker.varAssign(rawMessage, "rawMessage", 523, 16981, 17008);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 525, 17019, 17061);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TransactionLogMessages._currentLocale), "formatter", 528, 17211, 17282);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 530, 17316, 17324);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 530, 17316, 17324).format(messageArguments), "message", 530, 17293, 17350);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context273 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 534, 17407, 17490);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context273.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context274 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 539, 17505, 17616);
                        return TransactionLogMessages.RECOVERY_START_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context274.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context275 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 545, 17631, 18118);
                        CallChecker.varInit(o, "o", 545, 17631, 18118);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 556, 17953, 17991);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 558, 18042, 18045)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 558, 18087, 18090)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 558, 18017, 18033).equals(CallChecker.isCalled(that, LogMessage.class, 558, 18042, 18045).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 558, 18069, 18078).equals(CallChecker.isCalled(that, LogMessage.class, 558, 18087, 18090).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context275.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context276 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 563, 18133, 18355);
                        final String npe_invocation_var22 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var22, String.class, 565, 18220, 18229)) {
                            result = CallChecker.isCalled(npe_invocation_var22, String.class, 565, 18220, 18229).hashCode();
                            CallChecker.varAssign(result, "result", 565, 18220, 18229);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 566, 18282, 18298).hashCode());
                        CallChecker.varAssign(result, "result", 566, 18259, 18310);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context276.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context277.methodEnd();
        }
    }

    private TransactionLogMessages() {
        MethodContext _bcornu_methode_context24 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }
}

