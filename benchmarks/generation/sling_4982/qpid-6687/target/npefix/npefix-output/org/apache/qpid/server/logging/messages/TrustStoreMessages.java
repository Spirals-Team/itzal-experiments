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

public class TrustStoreMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String TRUSTSTORE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "truststore";

    public static final String OPEN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "truststore.open";

    public static final String CREATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "truststore.create";

    public static final String DELETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "truststore.delete";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "truststore.close";

    static {
        LoggerFactory.getLogger(TrustStoreMessages.TRUSTSTORE_LOG_HIERARCHY);
        LoggerFactory.getLogger(TrustStoreMessages.OPEN_LOG_HIERARCHY);
        LoggerFactory.getLogger(TrustStoreMessages.CREATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(TrustStoreMessages.DELETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(TrustStoreMessages.CLOSE_LOG_HIERARCHY);
        TrustStoreMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.TrustStore_logmessages", TrustStoreMessages._currentLocale);
        CallChecker.varAssign(TrustStoreMessages._messages, "TrustStoreMessages._messages", 61, 2497, 2615);
    }

    public static LogMessage OPEN() {
        MethodContext _bcornu_methode_context897 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CLOSE_LOG_HIERARCHY", 71, 2628, 3996);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.DELETE_LOG_HIERARCHY", 71, 2628, 3996);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CREATE_LOG_HIERARCHY", 71, 2628, 3996);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.OPEN_LOG_HIERARCHY", 71, 2628, 3996);
            CallChecker.varInit(TRUSTSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.TRUSTSTORE_LOG_HIERARCHY", 71, 2628, 3996);
            CallChecker.varInit(TrustStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.TrustStoreMessages._currentLocale", 71, 2628, 3996);
            CallChecker.varInit(TrustStoreMessages._messages, "org.apache.qpid.server.logging.messages.TrustStoreMessages._messages", 71, 2628, 3996);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TrustStoreMessages._messages, ResourceBundle.class, 73, 2913, 2921)) {
                TrustStoreMessages._messages = CallChecker.beforeCalled(TrustStoreMessages._messages, ResourceBundle.class, 73, 2913, 2921);
                rawMessage = CallChecker.isCalled(TrustStoreMessages._messages, ResourceBundle.class, 73, 2913, 2921).getString("OPEN");
                CallChecker.varAssign(rawMessage, "rawMessage", 73, 2913, 2921);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 75, 2951, 2984);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context893 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 79, 3041, 3124);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context893.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context894 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 84, 3139, 3240);
                        return TrustStoreMessages.OPEN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context894.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context895 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 90, 3255, 3742);
                        CallChecker.varInit(o, "o", 90, 3255, 3742);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 101, 3577, 3615);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 103, 3666, 3669)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 103, 3711, 3714)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 103, 3641, 3657).equals(CallChecker.isCalled(that, LogMessage.class, 103, 3666, 3669).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 103, 3693, 3702).equals(CallChecker.isCalled(that, LogMessage.class, 103, 3711, 3714).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context895.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context896 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 108, 3757, 3979);
                        final String npe_invocation_var120 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var120, String.class, 110, 3844, 3853)) {
                            result = CallChecker.isCalled(npe_invocation_var120, String.class, 110, 3844, 3853).hashCode();
                            CallChecker.varAssign(result, "result", 110, 3844, 3853);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 111, 3906, 3922).hashCode());
                        CallChecker.varAssign(result, "result", 111, 3883, 3934);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context896.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context897.methodEnd();
        }
    }

    public static LogMessage CREATE(String param1) {
        MethodContext _bcornu_methode_context902 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 124, 4003, 5696);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CLOSE_LOG_HIERARCHY", 124, 4003, 5696);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.DELETE_LOG_HIERARCHY", 124, 4003, 5696);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CREATE_LOG_HIERARCHY", 124, 4003, 5696);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.OPEN_LOG_HIERARCHY", 124, 4003, 5696);
            CallChecker.varInit(TRUSTSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.TRUSTSTORE_LOG_HIERARCHY", 124, 4003, 5696);
            CallChecker.varInit(TrustStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.TrustStoreMessages._currentLocale", 124, 4003, 5696);
            CallChecker.varInit(TrustStoreMessages._messages, "org.apache.qpid.server.logging.messages.TrustStoreMessages._messages", 124, 4003, 5696);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TrustStoreMessages._messages, ResourceBundle.class, 126, 4311, 4319)) {
                TrustStoreMessages._messages = CallChecker.beforeCalled(TrustStoreMessages._messages, ResourceBundle.class, 126, 4311, 4319);
                rawMessage = CallChecker.isCalled(TrustStoreMessages._messages, ResourceBundle.class, 126, 4311, 4319).getString("CREATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 126, 4311, 4319);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 128, 4351, 4393);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TrustStoreMessages._currentLocale), "formatter", 131, 4543, 4614);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 133, 4648, 4656);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 133, 4648, 4656).format(messageArguments), "message", 133, 4625, 4682);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context898 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 137, 4739, 4822);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context898.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context899 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 142, 4837, 4940);
                        return TrustStoreMessages.CREATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context899.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context900 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 148, 4955, 5442);
                        CallChecker.varInit(o, "o", 148, 4955, 5442);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 159, 5277, 5315);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 161, 5366, 5369)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 161, 5411, 5414)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 161, 5341, 5357).equals(CallChecker.isCalled(that, LogMessage.class, 161, 5366, 5369).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 161, 5393, 5402).equals(CallChecker.isCalled(that, LogMessage.class, 161, 5411, 5414).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context900.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context901 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 166, 5457, 5679);
                        final String npe_invocation_var121 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var121, String.class, 168, 5544, 5553)) {
                            result = CallChecker.isCalled(npe_invocation_var121, String.class, 168, 5544, 5553).hashCode();
                            CallChecker.varAssign(result, "result", 168, 5544, 5553);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 169, 5606, 5622).hashCode());
                        CallChecker.varAssign(result, "result", 169, 5583, 5634);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context901.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context902.methodEnd();
        }
    }

    public static LogMessage DELETE(String param1) {
        MethodContext _bcornu_methode_context907 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 182, 5703, 7396);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CLOSE_LOG_HIERARCHY", 182, 5703, 7396);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.DELETE_LOG_HIERARCHY", 182, 5703, 7396);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CREATE_LOG_HIERARCHY", 182, 5703, 7396);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.OPEN_LOG_HIERARCHY", 182, 5703, 7396);
            CallChecker.varInit(TRUSTSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.TRUSTSTORE_LOG_HIERARCHY", 182, 5703, 7396);
            CallChecker.varInit(TrustStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.TrustStoreMessages._currentLocale", 182, 5703, 7396);
            CallChecker.varInit(TrustStoreMessages._messages, "org.apache.qpid.server.logging.messages.TrustStoreMessages._messages", 182, 5703, 7396);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TrustStoreMessages._messages, ResourceBundle.class, 184, 6011, 6019)) {
                TrustStoreMessages._messages = CallChecker.beforeCalled(TrustStoreMessages._messages, ResourceBundle.class, 184, 6011, 6019);
                rawMessage = CallChecker.isCalled(TrustStoreMessages._messages, ResourceBundle.class, 184, 6011, 6019).getString("DELETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 184, 6011, 6019);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 186, 6051, 6093);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, TrustStoreMessages._currentLocale), "formatter", 189, 6243, 6314);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 191, 6348, 6356);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 191, 6348, 6356).format(messageArguments), "message", 191, 6325, 6382);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context903 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 195, 6439, 6522);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context903.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context904 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 200, 6537, 6640);
                        return TrustStoreMessages.DELETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context904.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context905 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 206, 6655, 7142);
                        CallChecker.varInit(o, "o", 206, 6655, 7142);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 217, 6977, 7015);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7066, 7069)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7111, 7114)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 219, 7041, 7057).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7066, 7069).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 219, 7093, 7102).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7111, 7114).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context905.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context906 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 224, 7157, 7379);
                        final String npe_invocation_var122 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var122, String.class, 226, 7244, 7253)) {
                            result = CallChecker.isCalled(npe_invocation_var122, String.class, 226, 7244, 7253).hashCode();
                            CallChecker.varAssign(result, "result", 226, 7244, 7253);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 227, 7306, 7322).hashCode());
                        CallChecker.varAssign(result, "result", 227, 7283, 7334);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context906.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context907.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context912 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CLOSE_LOG_HIERARCHY", 240, 7403, 8775);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.DELETE_LOG_HIERARCHY", 240, 7403, 8775);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.CREATE_LOG_HIERARCHY", 240, 7403, 8775);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.OPEN_LOG_HIERARCHY", 240, 7403, 8775);
            CallChecker.varInit(TRUSTSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.TrustStoreMessages.TRUSTSTORE_LOG_HIERARCHY", 240, 7403, 8775);
            CallChecker.varInit(TrustStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.TrustStoreMessages._currentLocale", 240, 7403, 8775);
            CallChecker.varInit(TrustStoreMessages._messages, "org.apache.qpid.server.logging.messages.TrustStoreMessages._messages", 240, 7403, 8775);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(TrustStoreMessages._messages, ResourceBundle.class, 242, 7690, 7698)) {
                TrustStoreMessages._messages = CallChecker.beforeCalled(TrustStoreMessages._messages, ResourceBundle.class, 242, 7690, 7698);
                rawMessage = CallChecker.isCalled(TrustStoreMessages._messages, ResourceBundle.class, 242, 7690, 7698).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 242, 7690, 7698);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 244, 7729, 7762);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context908 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 248, 7819, 7902);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context908.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context909 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 253, 7917, 8019);
                        return TrustStoreMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context909.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context910 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 259, 8034, 8521);
                        CallChecker.varInit(o, "o", 259, 8034, 8521);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 270, 8356, 8394);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 272, 8445, 8448)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 272, 8490, 8493)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 272, 8420, 8436).equals(CallChecker.isCalled(that, LogMessage.class, 272, 8445, 8448).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 272, 8472, 8481).equals(CallChecker.isCalled(that, LogMessage.class, 272, 8490, 8493).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context910.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context911 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 277, 8536, 8758);
                        final String npe_invocation_var123 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var123, String.class, 279, 8623, 8632)) {
                            result = CallChecker.isCalled(npe_invocation_var123, String.class, 279, 8623, 8632).hashCode();
                            CallChecker.varAssign(result, "result", 279, 8623, 8632);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 280, 8685, 8701).hashCode());
                        CallChecker.varAssign(result, "result", 280, 8662, 8713);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context911.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context912.methodEnd();
        }
    }

    private TrustStoreMessages() {
        MethodContext _bcornu_methode_context63 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }
}

