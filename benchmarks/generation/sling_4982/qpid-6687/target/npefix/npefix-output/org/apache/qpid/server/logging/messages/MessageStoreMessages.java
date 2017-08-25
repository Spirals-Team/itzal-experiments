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

public class MessageStoreMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String MESSAGESTORE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore";

    public static final String RECOVERY_COMPLETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.recovery_complete";

    public static final String CLOSED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.closed";

    public static final String OVERFULL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.overfull";

    public static final String RECOVERED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.recovered";

    public static final String UNDERFULL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.underfull";

    public static final String PASSIVATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.passivate";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.created";

    public static final String STORE_LOCATION_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.store_location";

    public static final String RECOVERY_START_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "messagestore.recovery_start";

    static {
        LoggerFactory.getLogger(MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.CLOSED_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.OVERFULL_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.RECOVERED_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.UNDERFULL_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.PASSIVATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY);
        LoggerFactory.getLogger(MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY);
        MessageStoreMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.MessageStore_logmessages", MessageStoreMessages._currentLocale);
        CallChecker.varAssign(MessageStoreMessages._messages, "MessageStoreMessages._messages", 71, 3456, 3576);
    }

    public static LogMessage RECOVERY_COMPLETE() {
        MethodContext _bcornu_methode_context852 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 81, 3589, 5011);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 81, 3589, 5011);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 81, 3589, 5011);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 83, 3902, 3910)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 83, 3902, 3910);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 83, 3902, 3910).getString("RECOVERY_COMPLETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 83, 3902, 3910);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 85, 3953, 3986);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context848 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 89, 4043, 4126);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context848.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context849 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 94, 4141, 4255);
                        return MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context849.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context850 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 100, 4270, 4757);
                        CallChecker.varInit(o, "o", 100, 4270, 4757);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 111, 4592, 4630);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 113, 4681, 4684)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 113, 4726, 4729)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 113, 4656, 4672).equals(CallChecker.isCalled(that, LogMessage.class, 113, 4681, 4684).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 113, 4708, 4717).equals(CallChecker.isCalled(that, LogMessage.class, 113, 4726, 4729).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context850.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context851 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 118, 4772, 4994);
                        final String npe_invocation_var111 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var111, String.class, 120, 4859, 4868)) {
                            result = CallChecker.isCalled(npe_invocation_var111, String.class, 120, 4859, 4868).hashCode();
                            CallChecker.varAssign(result, "result", 120, 4859, 4868);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 121, 4921, 4937).hashCode());
                        CallChecker.varAssign(result, "result", 121, 4898, 4949);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context851.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context852.methodEnd();
        }
    }

    public static LogMessage CLOSED() {
        MethodContext _bcornu_methode_context857 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 134, 5018, 6396);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 134, 5018, 6396);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 134, 5018, 6396);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 136, 5309, 5317)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 136, 5309, 5317);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 136, 5309, 5317).getString("CLOSED");
                CallChecker.varAssign(rawMessage, "rawMessage", 136, 5309, 5317);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 138, 5349, 5382);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context853 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 142, 5439, 5522);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context853.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context854 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 147, 5537, 5640);
                        return MessageStoreMessages.CLOSED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context854.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context855 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 153, 5655, 6142);
                        CallChecker.varInit(o, "o", 153, 5655, 6142);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 164, 5977, 6015);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 166, 6066, 6069)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 166, 6111, 6114)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 166, 6041, 6057).equals(CallChecker.isCalled(that, LogMessage.class, 166, 6066, 6069).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 166, 6093, 6102).equals(CallChecker.isCalled(that, LogMessage.class, 166, 6111, 6114).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context855.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context856 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 171, 6157, 6379);
                        final String npe_invocation_var112 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var112, String.class, 173, 6244, 6253)) {
                            result = CallChecker.isCalled(npe_invocation_var112, String.class, 173, 6244, 6253).hashCode();
                            CallChecker.varAssign(result, "result", 173, 6244, 6253);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 174, 6306, 6322).hashCode());
                        CallChecker.varAssign(result, "result", 174, 6283, 6334);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context856.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context857.methodEnd();
        }
    }

    public static LogMessage OVERFULL() {
        MethodContext _bcornu_methode_context862 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 187, 6403, 7826);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 187, 6403, 7826);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 187, 6403, 7826);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 189, 6735, 6743)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 189, 6735, 6743);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 189, 6735, 6743).getString("OVERFULL");
                CallChecker.varAssign(rawMessage, "rawMessage", 189, 6735, 6743);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 191, 6777, 6810);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context858 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 195, 6867, 6950);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context858.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context859 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 200, 6965, 7070);
                        return MessageStoreMessages.OVERFULL_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context859.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context860 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 206, 7085, 7572);
                        CallChecker.varInit(o, "o", 206, 7085, 7572);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 217, 7407, 7445);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7496, 7499)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7541, 7544)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 219, 7471, 7487).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7496, 7499).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 219, 7523, 7532).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7541, 7544).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context860.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context861 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 224, 7587, 7809);
                        final String npe_invocation_var113 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var113, String.class, 226, 7674, 7683)) {
                            result = CallChecker.isCalled(npe_invocation_var113, String.class, 226, 7674, 7683).hashCode();
                            CallChecker.varAssign(result, "result", 226, 7674, 7683);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 227, 7736, 7752).hashCode());
                        CallChecker.varAssign(result, "result", 227, 7713, 7764);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context861.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context862.methodEnd();
        }
    }

    public static LogMessage RECOVERED(Number param1) {
        MethodContext _bcornu_methode_context867 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 240, 7833, 9554);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 240, 7833, 9554);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 240, 7833, 9554);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 240, 7833, 9554);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 242, 8163, 8171)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 242, 8163, 8171);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 242, 8163, 8171).getString("RECOVERED");
                CallChecker.varAssign(rawMessage, "rawMessage", 242, 8163, 8171);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 244, 8206, 8248);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, MessageStoreMessages._currentLocale), "formatter", 247, 8398, 8469);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 249, 8503, 8511);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 249, 8503, 8511).format(messageArguments), "message", 249, 8480, 8537);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context863 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 253, 8594, 8677);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context863.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context864 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 258, 8692, 8798);
                        return MessageStoreMessages.RECOVERED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context864.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context865 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 264, 8813, 9300);
                        CallChecker.varInit(o, "o", 264, 8813, 9300);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 275, 9135, 9173);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 277, 9224, 9227)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 277, 9269, 9272)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 277, 9199, 9215).equals(CallChecker.isCalled(that, LogMessage.class, 277, 9224, 9227).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 277, 9251, 9260).equals(CallChecker.isCalled(that, LogMessage.class, 277, 9269, 9272).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context865.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context866 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 282, 9315, 9537);
                        final String npe_invocation_var114 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var114, String.class, 284, 9402, 9411)) {
                            result = CallChecker.isCalled(npe_invocation_var114, String.class, 284, 9402, 9411).hashCode();
                            CallChecker.varAssign(result, "result", 284, 9402, 9411);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 285, 9464, 9480).hashCode());
                        CallChecker.varAssign(result, "result", 285, 9441, 9492);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context866.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context867.methodEnd();
        }
    }

    public static LogMessage UNDERFULL() {
        MethodContext _bcornu_methode_context872 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 298, 9561, 10974);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 298, 9561, 10974);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 298, 9561, 10974);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 300, 9881, 9889)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 300, 9881, 9889);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 300, 9881, 9889).getString("UNDERFULL");
                CallChecker.varAssign(rawMessage, "rawMessage", 300, 9881, 9889);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 302, 9924, 9957);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context868 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 306, 10014, 10097);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context868.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context869 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 311, 10112, 10218);
                        return MessageStoreMessages.UNDERFULL_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context869.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context870 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 317, 10233, 10720);
                        CallChecker.varInit(o, "o", 317, 10233, 10720);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 328, 10555, 10593);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 330, 10644, 10647)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 330, 10689, 10692)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 330, 10619, 10635).equals(CallChecker.isCalled(that, LogMessage.class, 330, 10644, 10647).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 330, 10671, 10680).equals(CallChecker.isCalled(that, LogMessage.class, 330, 10689, 10692).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context870.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context871 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 335, 10735, 10957);
                        final String npe_invocation_var115 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var115, String.class, 337, 10822, 10831)) {
                            result = CallChecker.isCalled(npe_invocation_var115, String.class, 337, 10822, 10831).hashCode();
                            CallChecker.varAssign(result, "result", 337, 10822, 10831);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 338, 10884, 10900).hashCode());
                        CallChecker.varAssign(result, "result", 338, 10861, 10912);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context871.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context872.methodEnd();
        }
    }

    public static LogMessage PASSIVATE() {
        MethodContext _bcornu_methode_context877 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 351, 10981, 12378);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 351, 10981, 12378);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 351, 10981, 12378);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 353, 11285, 11293)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 353, 11285, 11293);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 353, 11285, 11293).getString("PASSIVATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 353, 11285, 11293);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 355, 11328, 11361);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context873 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 359, 11418, 11501);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context873.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context874 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 364, 11516, 11622);
                        return MessageStoreMessages.PASSIVATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context874.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context875 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 370, 11637, 12124);
                        CallChecker.varInit(o, "o", 370, 11637, 12124);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 381, 11959, 11997);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 383, 12048, 12051)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 383, 12093, 12096)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 383, 12023, 12039).equals(CallChecker.isCalled(that, LogMessage.class, 383, 12048, 12051).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 383, 12075, 12084).equals(CallChecker.isCalled(that, LogMessage.class, 383, 12093, 12096).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context875.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context876 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 388, 12139, 12361);
                        final String npe_invocation_var116 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var116, String.class, 390, 12226, 12235)) {
                            result = CallChecker.isCalled(npe_invocation_var116, String.class, 390, 12226, 12235).hashCode();
                            CallChecker.varAssign(result, "result", 390, 12226, 12235);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 391, 12288, 12304).hashCode());
                        CallChecker.varAssign(result, "result", 391, 12265, 12316);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context876.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context877.methodEnd();
        }
    }

    public static LogMessage CREATED() {
        MethodContext _bcornu_methode_context882 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 404, 12385, 13767);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 404, 12385, 13767);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 404, 12385, 13767);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 406, 12678, 12686)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 406, 12678, 12686);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 406, 12678, 12686).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 406, 12678, 12686);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 408, 12719, 12752);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context878 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 412, 12809, 12892);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context878.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context879 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 417, 12907, 13011);
                        return MessageStoreMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context879.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context880 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 423, 13026, 13513);
                        CallChecker.varInit(o, "o", 423, 13026, 13513);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 434, 13348, 13386);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 436, 13437, 13440)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 436, 13482, 13485)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 436, 13412, 13428).equals(CallChecker.isCalled(that, LogMessage.class, 436, 13437, 13440).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 436, 13464, 13473).equals(CallChecker.isCalled(that, LogMessage.class, 436, 13482, 13485).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context880.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context881 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 441, 13528, 13750);
                        final String npe_invocation_var117 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var117, String.class, 443, 13615, 13624)) {
                            result = CallChecker.isCalled(npe_invocation_var117, String.class, 443, 13615, 13624).hashCode();
                            CallChecker.varAssign(result, "result", 443, 13615, 13624);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 444, 13677, 13693).hashCode());
                        CallChecker.varAssign(result, "result", 444, 13654, 13705);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context881.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context882.methodEnd();
        }
    }

    public static LogMessage STORE_LOCATION(String param1) {
        MethodContext _bcornu_methode_context887 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 457, 13774, 15501);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 457, 13774, 15501);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 457, 13774, 15501);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 457, 13774, 15501);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 459, 14100, 14108)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 459, 14100, 14108);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 459, 14100, 14108).getString("STORE_LOCATION");
                CallChecker.varAssign(rawMessage, "rawMessage", 459, 14100, 14108);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 461, 14148, 14190);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, MessageStoreMessages._currentLocale), "formatter", 464, 14340, 14411);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 466, 14445, 14453);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 466, 14445, 14453).format(messageArguments), "message", 466, 14422, 14479);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context883 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 470, 14536, 14619);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context883.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context884 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 475, 14634, 14745);
                        return MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context884.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context885 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 481, 14760, 15247);
                        CallChecker.varInit(o, "o", 481, 14760, 15247);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 492, 15082, 15120);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 494, 15171, 15174)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 494, 15216, 15219)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 494, 15146, 15162).equals(CallChecker.isCalled(that, LogMessage.class, 494, 15171, 15174).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 494, 15198, 15207).equals(CallChecker.isCalled(that, LogMessage.class, 494, 15216, 15219).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context885.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context886 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 499, 15262, 15484);
                        final String npe_invocation_var118 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var118, String.class, 501, 15349, 15358)) {
                            result = CallChecker.isCalled(npe_invocation_var118, String.class, 501, 15349, 15358).hashCode();
                            CallChecker.varAssign(result, "result", 501, 15349, 15358);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 502, 15411, 15427).hashCode());
                        CallChecker.varAssign(result, "result", 502, 15388, 15439);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context886.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context887.methodEnd();
        }
    }

    public static LogMessage RECOVERY_START() {
        MethodContext _bcornu_methode_context892 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CREATED_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(PASSIVATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.PASSIVATE_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(UNDERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.UNDERFULL_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(RECOVERED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERED_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(OVERFULL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.OVERFULL_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(CLOSED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.CLOSED_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(MESSAGESTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.MessageStoreMessages.MESSAGESTORE_LOG_HIERARCHY", 515, 15508, 16918);
            CallChecker.varInit(MessageStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.MessageStoreMessages._currentLocale", 515, 15508, 16918);
            CallChecker.varInit(MessageStoreMessages._messages, "org.apache.qpid.server.logging.messages.MessageStoreMessages._messages", 515, 15508, 16918);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(MessageStoreMessages._messages, ResourceBundle.class, 517, 15815, 15823)) {
                MessageStoreMessages._messages = CallChecker.beforeCalled(MessageStoreMessages._messages, ResourceBundle.class, 517, 15815, 15823);
                rawMessage = CallChecker.isCalled(MessageStoreMessages._messages, ResourceBundle.class, 517, 15815, 15823).getString("RECOVERY_START");
                CallChecker.varAssign(rawMessage, "rawMessage", 517, 15815, 15823);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 519, 15863, 15896);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context888 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 523, 15953, 16036);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context888.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context889 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 528, 16051, 16162);
                        return MessageStoreMessages.RECOVERY_START_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context889.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context890 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 534, 16177, 16664);
                        CallChecker.varInit(o, "o", 534, 16177, 16664);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 545, 16499, 16537);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 547, 16588, 16591)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 547, 16633, 16636)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 547, 16563, 16579).equals(CallChecker.isCalled(that, LogMessage.class, 547, 16588, 16591).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 547, 16615, 16624).equals(CallChecker.isCalled(that, LogMessage.class, 547, 16633, 16636).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context890.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context891 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 552, 16679, 16901);
                        final String npe_invocation_var119 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var119, String.class, 554, 16766, 16775)) {
                            result = CallChecker.isCalled(npe_invocation_var119, String.class, 554, 16766, 16775).hashCode();
                            CallChecker.varAssign(result, "result", 554, 16766, 16775);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 555, 16828, 16844).hashCode());
                        CallChecker.varAssign(result, "result", 555, 16805, 16856);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context891.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context892.methodEnd();
        }
    }

    private MessageStoreMessages() {
        MethodContext _bcornu_methode_context62 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }
}

