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

public class ConnectionMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String CONNECTION_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection";

    public static final String OPEN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection.open";

    public static final String DROPPED_CONNECTION_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection.dropped_connection";

    public static final String CLIENT_VERSION_REJECT_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection.client_version_reject";

    public static final String CLIENT_VERSION_LOG_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection.client_version_log";

    public static final String IDLE_CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection.idle_close";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection.close";

    public static final String MODEL_DELETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "connection.model_delete";

    static {
        LoggerFactory.getLogger(ConnectionMessages.CONNECTION_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConnectionMessages.OPEN_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConnectionMessages.CLOSE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY);
        ConnectionMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.Connection_logmessages", ConnectionMessages._currentLocale);
        CallChecker.varAssign(ConnectionMessages._messages, "ConnectionMessages._messages", 67, 3127, 3245);
    }

    public static LogMessage OPEN(String param1, String param2, String param3, String param4, boolean opt1, boolean opt2, boolean opt3, boolean opt4) {
        MethodContext _bcornu_methode_context487 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(opt4, "opt4", 77, 3258, 6795);
            CallChecker.varInit(opt3, "opt3", 77, 3258, 6795);
            CallChecker.varInit(opt2, "opt2", 77, 3258, 6795);
            CallChecker.varInit(opt1, "opt1", 77, 3258, 6795);
            CallChecker.varInit(param4, "param4", 77, 3258, 6795);
            CallChecker.varInit(param3, "param3", 77, 3258, 6795);
            CallChecker.varInit(param2, "param2", 77, 3258, 6795);
            CallChecker.varInit(param1, "param1", 77, 3258, 6795);
            CallChecker.varInit(MODEL_DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLOSE_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(IDLE_CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(CLIENT_VERSION_LOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(CLIENT_VERSION_REJECT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(DROPPED_CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.OPEN_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CONNECTION_LOG_HIERARCHY", 77, 3258, 6795);
            CallChecker.varInit(ConnectionMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConnectionMessages._currentLocale", 77, 3258, 6795);
            CallChecker.varInit(ConnectionMessages._messages, "org.apache.qpid.server.logging.messages.ConnectionMessages._messages", 77, 3258, 6795);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConnectionMessages._messages, ResourceBundle.class, 79, 3754, 3762)) {
                ConnectionMessages._messages = CallChecker.beforeCalled(ConnectionMessages._messages, ResourceBundle.class, 79, 3754, 3762);
                rawMessage = CallChecker.isCalled(ConnectionMessages._messages, ResourceBundle.class, 79, 3754, 3762).getString("OPEN");
                CallChecker.varAssign(rawMessage, "rawMessage", 79, 3754, 3762);
            }
            StringBuffer msg = CallChecker.varInit(new StringBuffer(), "msg", 80, 3791, 3828);
            String[] parts = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(rawMessage, String.class, 84, 3993, 4002)) {
                rawMessage = CallChecker.beforeCalled(rawMessage, String.class, 84, 3993, 4002);
                parts = CallChecker.isCalled(rawMessage, String.class, 84, 3993, 4002).split("\\[");
                CallChecker.varAssign(parts, "parts", 84, 3993, 4002);
            }
            if (CallChecker.beforeDeref(parts, String[].class, 85, 4037, 4041)) {
                if (CallChecker.beforeDeref(msg, StringBuffer.class, 85, 4026, 4028)) {
                    parts = CallChecker.beforeCalled(parts, String[].class, 85, 4037, 4041);
                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 85, 4026, 4028);
                    CallChecker.isCalled(msg, StringBuffer.class, 85, 4026, 4028).append(CallChecker.isCalled(parts, String[].class, 85, 4037, 4041)[0]);
                }
            }
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(parts, String[].class, 88, 4078, 4082)) {
                parts = CallChecker.beforeCalled(parts, String[].class, 88, 4078, 4082);
                if ((CallChecker.isCalled(parts, String[].class, 88, 4078, 4082).length) > 1) {
                    if (CallChecker.beforeDeref(parts, String[].class, 92, 4172, 4176)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 92, 4172, 4176);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 92, 4172, 4176)[1], String.class, 92, 4172, 4179)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 92, 4172, 4176);
                            CallChecker.isCalled(parts, String[].class, 92, 4172, 4176)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 92, 4172, 4176)[1], String.class, 92, 4172, 4179);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 92, 4172, 4176)[1], String.class, 92, 4172, 4179).indexOf(']');
                            CallChecker.varAssign(end, "end", 92, 4166, 4193);
                        }
                    }
                    if (opt1) {
                        if (CallChecker.beforeDeref(parts, String[].class, 95, 4258, 4262)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 95, 4258, 4262);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 95, 4258, 4262)[1], String.class, 95, 4258, 4265)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 95, 4247, 4249)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 95, 4258, 4262);
                                    CallChecker.isCalled(parts, String[].class, 95, 4258, 4262)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 95, 4258, 4262)[1], String.class, 95, 4258, 4265);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 95, 4247, 4249);
                                    CallChecker.isCalled(msg, StringBuffer.class, 95, 4247, 4249).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 95, 4258, 4262)[1], String.class, 95, 4258, 4265).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 99, 4388, 4392)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 99, 4388, 4392);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 99, 4388, 4392)[1], String.class, 99, 4388, 4395)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 99, 4377, 4379)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 99, 4388, 4392);
                                CallChecker.isCalled(parts, String[].class, 99, 4388, 4392)[1] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 99, 4388, 4392)[1], String.class, 99, 4388, 4395);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 99, 4377, 4379);
                                CallChecker.isCalled(msg, StringBuffer.class, 99, 4377, 4379).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 99, 4388, 4392)[1], String.class, 99, 4388, 4395).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 102, 4491, 4495)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 102, 4491, 4495);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 102, 4491, 4495)[2], String.class, 102, 4491, 4498)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 102, 4491, 4495);
                            CallChecker.isCalled(parts, String[].class, 102, 4491, 4495)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 102, 4491, 4495)[2], String.class, 102, 4491, 4498);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 102, 4491, 4495)[2], String.class, 102, 4491, 4498).indexOf(']');
                            CallChecker.varAssign(end, "end", 102, 4485, 4512);
                        }
                    }
                    if (opt2) {
                        if (CallChecker.beforeDeref(parts, String[].class, 105, 4577, 4581)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 105, 4577, 4581);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 105, 4577, 4581)[2], String.class, 105, 4577, 4584)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 105, 4566, 4568)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 105, 4577, 4581);
                                    CallChecker.isCalled(parts, String[].class, 105, 4577, 4581)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 105, 4577, 4581)[2], String.class, 105, 4577, 4584);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 105, 4566, 4568);
                                    CallChecker.isCalled(msg, StringBuffer.class, 105, 4566, 4568).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 105, 4577, 4581)[2], String.class, 105, 4577, 4584).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 109, 4707, 4711)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 109, 4707, 4711);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 109, 4707, 4711)[2], String.class, 109, 4707, 4714)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 109, 4696, 4698)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 109, 4707, 4711);
                                CallChecker.isCalled(parts, String[].class, 109, 4707, 4711)[2] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 109, 4707, 4711)[2], String.class, 109, 4707, 4714);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 109, 4696, 4698);
                                CallChecker.isCalled(msg, StringBuffer.class, 109, 4696, 4698).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 109, 4707, 4711)[2], String.class, 109, 4707, 4714).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 112, 4808, 4812)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 112, 4808, 4812);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 112, 4808, 4812)[3], String.class, 112, 4808, 4815)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 112, 4808, 4812);
                            CallChecker.isCalled(parts, String[].class, 112, 4808, 4812)[3] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 112, 4808, 4812)[3], String.class, 112, 4808, 4815);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 112, 4808, 4812)[3], String.class, 112, 4808, 4815).indexOf(']');
                            CallChecker.varAssign(end, "end", 112, 4802, 4829);
                        }
                    }
                    if (opt3) {
                        if (CallChecker.beforeDeref(parts, String[].class, 115, 4894, 4898)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 115, 4894, 4898);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 115, 4894, 4898)[3], String.class, 115, 4894, 4901)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 115, 4883, 4885)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 115, 4894, 4898);
                                    CallChecker.isCalled(parts, String[].class, 115, 4894, 4898)[3] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 115, 4894, 4898)[3], String.class, 115, 4894, 4901);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 115, 4883, 4885);
                                    CallChecker.isCalled(msg, StringBuffer.class, 115, 4883, 4885).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 115, 4894, 4898)[3], String.class, 115, 4894, 4901).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 119, 5024, 5028)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 119, 5024, 5028);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 119, 5024, 5028)[3], String.class, 119, 5024, 5031)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 119, 5013, 5015)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 119, 5024, 5028);
                                CallChecker.isCalled(parts, String[].class, 119, 5024, 5028)[3] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 119, 5024, 5028)[3], String.class, 119, 5024, 5031);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 119, 5013, 5015);
                                CallChecker.isCalled(msg, StringBuffer.class, 119, 5013, 5015).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 119, 5024, 5028)[3], String.class, 119, 5024, 5031).substring((end + 1)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 122, 5125, 5129)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 122, 5125, 5129);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 122, 5125, 5129)[4], String.class, 122, 5125, 5132)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 122, 5125, 5129);
                            CallChecker.isCalled(parts, String[].class, 122, 5125, 5129)[4] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 122, 5125, 5129)[4], String.class, 122, 5125, 5132);
                            end = CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 122, 5125, 5129)[4], String.class, 122, 5125, 5132).indexOf(']');
                            CallChecker.varAssign(end, "end", 122, 5119, 5146);
                        }
                    }
                    if (opt4) {
                        if (CallChecker.beforeDeref(parts, String[].class, 125, 5211, 5215)) {
                            parts = CallChecker.beforeCalled(parts, String[].class, 125, 5211, 5215);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 125, 5211, 5215)[4], String.class, 125, 5211, 5218)) {
                                if (CallChecker.beforeDeref(msg, StringBuffer.class, 125, 5200, 5202)) {
                                    parts = CallChecker.beforeCalled(parts, String[].class, 125, 5211, 5215);
                                    CallChecker.isCalled(parts, String[].class, 125, 5211, 5215)[4] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 125, 5211, 5215)[4], String.class, 125, 5211, 5218);
                                    msg = CallChecker.beforeCalled(msg, StringBuffer.class, 125, 5200, 5202);
                                    CallChecker.isCalled(msg, StringBuffer.class, 125, 5200, 5202).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 125, 5211, 5215)[4], String.class, 125, 5211, 5218).substring(0, end));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(parts, String[].class, 129, 5341, 5345)) {
                        parts = CallChecker.beforeCalled(parts, String[].class, 129, 5341, 5345);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parts, String[].class, 129, 5341, 5345)[4], String.class, 129, 5341, 5348)) {
                            if (CallChecker.beforeDeref(msg, StringBuffer.class, 129, 5330, 5332)) {
                                parts = CallChecker.beforeCalled(parts, String[].class, 129, 5341, 5345);
                                CallChecker.isCalled(parts, String[].class, 129, 5341, 5345)[4] = CallChecker.beforeCalled(CallChecker.isCalled(parts, String[].class, 129, 5341, 5345)[4], String.class, 129, 5341, 5348);
                                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 129, 5330, 5332);
                                CallChecker.isCalled(msg, StringBuffer.class, 129, 5330, 5332).append(CallChecker.isCalled(CallChecker.isCalled(parts, String[].class, 129, 5341, 5345)[4], String.class, 129, 5341, 5348).substring((end + 1)));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(msg, StringBuffer.class, 132, 5403, 5405)) {
                msg = CallChecker.beforeCalled(msg, StringBuffer.class, 132, 5403, 5405);
                rawMessage = CallChecker.isCalled(msg, StringBuffer.class, 132, 5403, 5405).toString();
                CallChecker.varAssign(rawMessage, "rawMessage", 132, 5390, 5417);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 , param4 }, "messageArguments", 134, 5428, 5494);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ConnectionMessages._currentLocale), "formatter", 137, 5644, 5715);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 139, 5749, 5757);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 139, 5749, 5757).format(messageArguments), "message", 139, 5726, 5783);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context483 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 143, 5840, 5923);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context483.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context484 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 148, 5938, 6039);
                        return ConnectionMessages.OPEN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context484.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context485 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 154, 6054, 6541);
                        CallChecker.varInit(o, "o", 154, 6054, 6541);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 165, 6376, 6414);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 167, 6465, 6468)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 167, 6510, 6513)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 167, 6440, 6456).equals(CallChecker.isCalled(that, LogMessage.class, 167, 6465, 6468).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 167, 6492, 6501).equals(CallChecker.isCalled(that, LogMessage.class, 167, 6510, 6513).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context485.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context486 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 172, 6556, 6778);
                        final String npe_invocation_var56 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var56, String.class, 174, 6643, 6652)) {
                            result = CallChecker.isCalled(npe_invocation_var56, String.class, 174, 6643, 6652).hashCode();
                            CallChecker.varAssign(result, "result", 174, 6643, 6652);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 175, 6705, 6721).hashCode());
                        CallChecker.varAssign(result, "result", 175, 6682, 6733);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context486.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context487.methodEnd();
        }
    }

    public static LogMessage DROPPED_CONNECTION() {
        MethodContext _bcornu_methode_context492 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(MODEL_DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLOSE_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(IDLE_CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(CLIENT_VERSION_LOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(CLIENT_VERSION_REJECT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(DROPPED_CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.OPEN_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CONNECTION_LOG_HIERARCHY", 188, 6802, 8226);
            CallChecker.varInit(ConnectionMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConnectionMessages._currentLocale", 188, 6802, 8226);
            CallChecker.varInit(ConnectionMessages._messages, "org.apache.qpid.server.logging.messages.ConnectionMessages._messages", 188, 6802, 8226);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConnectionMessages._messages, ResourceBundle.class, 190, 7115, 7123)) {
                ConnectionMessages._messages = CallChecker.beforeCalled(ConnectionMessages._messages, ResourceBundle.class, 190, 7115, 7123);
                rawMessage = CallChecker.isCalled(ConnectionMessages._messages, ResourceBundle.class, 190, 7115, 7123).getString("DROPPED_CONNECTION");
                CallChecker.varAssign(rawMessage, "rawMessage", 190, 7115, 7123);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 192, 7167, 7200);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context488 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 196, 7257, 7340);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context488.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context489 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 201, 7355, 7470);
                        return ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context489.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context490 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 207, 7485, 7972);
                        CallChecker.varInit(o, "o", 207, 7485, 7972);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 218, 7807, 7845);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 220, 7896, 7899)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 220, 7941, 7944)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 220, 7871, 7887).equals(CallChecker.isCalled(that, LogMessage.class, 220, 7896, 7899).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 220, 7923, 7932).equals(CallChecker.isCalled(that, LogMessage.class, 220, 7941, 7944).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context490.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context491 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 225, 7987, 8209);
                        final String npe_invocation_var57 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var57, String.class, 227, 8074, 8083)) {
                            result = CallChecker.isCalled(npe_invocation_var57, String.class, 227, 8074, 8083).hashCode();
                            CallChecker.varAssign(result, "result", 227, 8074, 8083);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 228, 8136, 8152).hashCode());
                        CallChecker.varAssign(result, "result", 228, 8113, 8164);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context491.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context492.methodEnd();
        }
    }

    public static LogMessage CLIENT_VERSION_REJECT(String param1) {
        MethodContext _bcornu_methode_context497 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 241, 8233, 10002);
            CallChecker.varInit(MODEL_DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLOSE_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(IDLE_CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(CLIENT_VERSION_LOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(CLIENT_VERSION_REJECT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(DROPPED_CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.OPEN_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CONNECTION_LOG_HIERARCHY", 241, 8233, 10002);
            CallChecker.varInit(ConnectionMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConnectionMessages._currentLocale", 241, 8233, 10002);
            CallChecker.varInit(ConnectionMessages._messages, "org.apache.qpid.server.logging.messages.ConnectionMessages._messages", 241, 8233, 10002);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConnectionMessages._messages, ResourceBundle.class, 243, 8587, 8595)) {
                ConnectionMessages._messages = CallChecker.beforeCalled(ConnectionMessages._messages, ResourceBundle.class, 243, 8587, 8595);
                rawMessage = CallChecker.isCalled(ConnectionMessages._messages, ResourceBundle.class, 243, 8587, 8595).getString("CLIENT_VERSION_REJECT");
                CallChecker.varAssign(rawMessage, "rawMessage", 243, 8587, 8595);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 245, 8642, 8684);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ConnectionMessages._currentLocale), "formatter", 248, 8834, 8905);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 250, 8939, 8947);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 250, 8939, 8947).format(messageArguments), "message", 250, 8916, 8973);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context493 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 254, 9030, 9113);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context493.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context494 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 259, 9128, 9246);
                        return ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context494.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context495 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 265, 9261, 9748);
                        CallChecker.varInit(o, "o", 265, 9261, 9748);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 276, 9583, 9621);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 278, 9672, 9675)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 278, 9717, 9720)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 278, 9647, 9663).equals(CallChecker.isCalled(that, LogMessage.class, 278, 9672, 9675).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 278, 9699, 9708).equals(CallChecker.isCalled(that, LogMessage.class, 278, 9717, 9720).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context495.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context496 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 283, 9763, 9985);
                        final String npe_invocation_var58 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var58, String.class, 285, 9850, 9859)) {
                            result = CallChecker.isCalled(npe_invocation_var58, String.class, 285, 9850, 9859).hashCode();
                            CallChecker.varAssign(result, "result", 285, 9850, 9859);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 286, 9912, 9928).hashCode());
                        CallChecker.varAssign(result, "result", 286, 9889, 9940);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context496.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context497.methodEnd();
        }
    }

    public static LogMessage CLIENT_VERSION_LOG(String param1) {
        MethodContext _bcornu_methode_context502 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 299, 10009, 11767);
            CallChecker.varInit(MODEL_DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLOSE_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(IDLE_CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(CLIENT_VERSION_LOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(CLIENT_VERSION_REJECT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(DROPPED_CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.OPEN_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CONNECTION_LOG_HIERARCHY", 299, 10009, 11767);
            CallChecker.varInit(ConnectionMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConnectionMessages._currentLocale", 299, 10009, 11767);
            CallChecker.varInit(ConnectionMessages._messages, "org.apache.qpid.server.logging.messages.ConnectionMessages._messages", 299, 10009, 11767);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConnectionMessages._messages, ResourceBundle.class, 301, 10358, 10366)) {
                ConnectionMessages._messages = CallChecker.beforeCalled(ConnectionMessages._messages, ResourceBundle.class, 301, 10358, 10366);
                rawMessage = CallChecker.isCalled(ConnectionMessages._messages, ResourceBundle.class, 301, 10358, 10366).getString("CLIENT_VERSION_LOG");
                CallChecker.varAssign(rawMessage, "rawMessage", 301, 10358, 10366);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 303, 10410, 10452);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ConnectionMessages._currentLocale), "formatter", 306, 10602, 10673);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 308, 10707, 10715);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 308, 10707, 10715).format(messageArguments), "message", 308, 10684, 10741);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context498 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 312, 10798, 10881);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context498.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context499 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 317, 10896, 11011);
                        return ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context499.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context500 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 323, 11026, 11513);
                        CallChecker.varInit(o, "o", 323, 11026, 11513);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 334, 11348, 11386);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 336, 11437, 11440)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 336, 11482, 11485)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 336, 11412, 11428).equals(CallChecker.isCalled(that, LogMessage.class, 336, 11437, 11440).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 336, 11464, 11473).equals(CallChecker.isCalled(that, LogMessage.class, 336, 11482, 11485).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context500.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context501 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 341, 11528, 11750);
                        final String npe_invocation_var59 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var59, String.class, 343, 11615, 11624)) {
                            result = CallChecker.isCalled(npe_invocation_var59, String.class, 343, 11615, 11624).hashCode();
                            CallChecker.varAssign(result, "result", 343, 11615, 11624);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 344, 11677, 11693).hashCode());
                        CallChecker.varAssign(result, "result", 344, 11654, 11705);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context501.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context502.methodEnd();
        }
    }

    public static LogMessage IDLE_CLOSE() {
        MethodContext _bcornu_methode_context507 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(MODEL_DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLOSE_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(IDLE_CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(CLIENT_VERSION_LOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(CLIENT_VERSION_REJECT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(DROPPED_CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.OPEN_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CONNECTION_LOG_HIERARCHY", 357, 11774, 13180);
            CallChecker.varInit(ConnectionMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConnectionMessages._currentLocale", 357, 11774, 13180);
            CallChecker.varInit(ConnectionMessages._messages, "org.apache.qpid.server.logging.messages.ConnectionMessages._messages", 357, 11774, 13180);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConnectionMessages._messages, ResourceBundle.class, 359, 12085, 12093)) {
                ConnectionMessages._messages = CallChecker.beforeCalled(ConnectionMessages._messages, ResourceBundle.class, 359, 12085, 12093);
                rawMessage = CallChecker.isCalled(ConnectionMessages._messages, ResourceBundle.class, 359, 12085, 12093).getString("IDLE_CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 359, 12085, 12093);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 361, 12129, 12162);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context503 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 365, 12219, 12302);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context503.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context504 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 370, 12317, 12424);
                        return ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context504.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context505 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 376, 12439, 12926);
                        CallChecker.varInit(o, "o", 376, 12439, 12926);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 387, 12761, 12799);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 389, 12850, 12853)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 389, 12895, 12898)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 389, 12825, 12841).equals(CallChecker.isCalled(that, LogMessage.class, 389, 12850, 12853).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 389, 12877, 12886).equals(CallChecker.isCalled(that, LogMessage.class, 389, 12895, 12898).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context505.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context506 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 394, 12941, 13163);
                        final String npe_invocation_var60 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var60, String.class, 396, 13028, 13037)) {
                            result = CallChecker.isCalled(npe_invocation_var60, String.class, 396, 13028, 13037).hashCode();
                            CallChecker.varAssign(result, "result", 396, 13028, 13037);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 397, 13090, 13106).hashCode());
                        CallChecker.varAssign(result, "result", 397, 13067, 13118);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context506.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context507.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context512 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(MODEL_DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLOSE_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(IDLE_CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(CLIENT_VERSION_LOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(CLIENT_VERSION_REJECT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(DROPPED_CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.OPEN_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CONNECTION_LOG_HIERARCHY", 410, 13187, 14559);
            CallChecker.varInit(ConnectionMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConnectionMessages._currentLocale", 410, 13187, 14559);
            CallChecker.varInit(ConnectionMessages._messages, "org.apache.qpid.server.logging.messages.ConnectionMessages._messages", 410, 13187, 14559);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConnectionMessages._messages, ResourceBundle.class, 412, 13474, 13482)) {
                ConnectionMessages._messages = CallChecker.beforeCalled(ConnectionMessages._messages, ResourceBundle.class, 412, 13474, 13482);
                rawMessage = CallChecker.isCalled(ConnectionMessages._messages, ResourceBundle.class, 412, 13474, 13482).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 412, 13474, 13482);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 414, 13513, 13546);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context508 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 418, 13603, 13686);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context508.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context509 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 423, 13701, 13803);
                        return ConnectionMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context509.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context510 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 429, 13818, 14305);
                        CallChecker.varInit(o, "o", 429, 13818, 14305);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 440, 14140, 14178);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 442, 14229, 14232)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 442, 14274, 14277)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 442, 14204, 14220).equals(CallChecker.isCalled(that, LogMessage.class, 442, 14229, 14232).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 442, 14256, 14265).equals(CallChecker.isCalled(that, LogMessage.class, 442, 14274, 14277).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context510.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context511 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 447, 14320, 14542);
                        final String npe_invocation_var61 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var61, String.class, 449, 14407, 14416)) {
                            result = CallChecker.isCalled(npe_invocation_var61, String.class, 449, 14407, 14416).hashCode();
                            CallChecker.varAssign(result, "result", 449, 14407, 14416);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 450, 14469, 14485).hashCode());
                        CallChecker.varAssign(result, "result", 450, 14446, 14497);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context511.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context512.methodEnd();
        }
    }

    public static LogMessage MODEL_DELETE() {
        MethodContext _bcornu_methode_context517 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(MODEL_DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLOSE_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(IDLE_CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.IDLE_CLOSE_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(CLIENT_VERSION_LOG_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_LOG_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(CLIENT_VERSION_REJECT_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CLIENT_VERSION_REJECT_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(DROPPED_CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.DROPPED_CONNECTION_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.OPEN_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(CONNECTION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConnectionMessages.CONNECTION_LOG_HIERARCHY", 463, 14566, 15992);
            CallChecker.varInit(ConnectionMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConnectionMessages._currentLocale", 463, 14566, 15992);
            CallChecker.varInit(ConnectionMessages._messages, "org.apache.qpid.server.logging.messages.ConnectionMessages._messages", 463, 14566, 15992);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConnectionMessages._messages, ResourceBundle.class, 465, 14893, 14901)) {
                ConnectionMessages._messages = CallChecker.beforeCalled(ConnectionMessages._messages, ResourceBundle.class, 465, 14893, 14901);
                rawMessage = CallChecker.isCalled(ConnectionMessages._messages, ResourceBundle.class, 465, 14893, 14901).getString("MODEL_DELETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 465, 14893, 14901);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 467, 14939, 14972);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context513 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 471, 15029, 15112);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context513.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context514 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 476, 15127, 15236);
                        return ConnectionMessages.MODEL_DELETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context514.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context515 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 482, 15251, 15738);
                        CallChecker.varInit(o, "o", 482, 15251, 15738);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 493, 15573, 15611);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 495, 15662, 15665)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 495, 15707, 15710)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 495, 15637, 15653).equals(CallChecker.isCalled(that, LogMessage.class, 495, 15662, 15665).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 495, 15689, 15698).equals(CallChecker.isCalled(that, LogMessage.class, 495, 15707, 15710).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context515.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context516 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 500, 15753, 15975);
                        final String npe_invocation_var62 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var62, String.class, 502, 15840, 15849)) {
                            result = CallChecker.isCalled(npe_invocation_var62, String.class, 502, 15840, 15849).hashCode();
                            CallChecker.varAssign(result, "result", 502, 15840, 15849);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 503, 15902, 15918).hashCode());
                        CallChecker.varAssign(result, "result", 503, 15879, 15930);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context516.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context517.methodEnd();
        }
    }

    private ConnectionMessages() {
        MethodContext _bcornu_methode_context32 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }
}

