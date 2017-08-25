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

public class ConfigStoreMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String CONFIGSTORE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "configstore";

    public static final String RECOVERY_COMPLETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "configstore.recovery_complete";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "configstore.close";

    public static final String CREATED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "configstore.created";

    public static final String STORE_LOCATION_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "configstore.store_location";

    public static final String RECOVERY_START_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "configstore.recovery_start";

    static {
        LoggerFactory.getLogger(ConfigStoreMessages.CONFIGSTORE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConfigStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConfigStoreMessages.CLOSE_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConfigStoreMessages.CREATED_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConfigStoreMessages.STORE_LOCATION_LOG_HIERARCHY);
        LoggerFactory.getLogger(ConfigStoreMessages.RECOVERY_START_LOG_HIERARCHY);
        ConfigStoreMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.ConfigStore_logmessages", ConfigStoreMessages._currentLocale);
        CallChecker.varAssign(ConfigStoreMessages._messages, "ConfigStoreMessages._messages", 63, 2758, 2877);
    }

    public static LogMessage RECOVERY_COMPLETE() {
        MethodContext _bcornu_methode_context217 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_START_LOG_HIERARCHY", 73, 2890, 4311);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 73, 2890, 4311);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CREATED_LOG_HIERARCHY", 73, 2890, 4311);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CLOSE_LOG_HIERARCHY", 73, 2890, 4311);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 73, 2890, 4311);
            CallChecker.varInit(CONFIGSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CONFIGSTORE_LOG_HIERARCHY", 73, 2890, 4311);
            CallChecker.varInit(ConfigStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._currentLocale", 73, 2890, 4311);
            CallChecker.varInit(ConfigStoreMessages._messages, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._messages", 73, 2890, 4311);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConfigStoreMessages._messages, ResourceBundle.class, 75, 3202, 3210)) {
                ConfigStoreMessages._messages = CallChecker.beforeCalled(ConfigStoreMessages._messages, ResourceBundle.class, 75, 3202, 3210);
                rawMessage = CallChecker.isCalled(ConfigStoreMessages._messages, ResourceBundle.class, 75, 3202, 3210).getString("RECOVERY_COMPLETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 75, 3202, 3210);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 77, 3253, 3286);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context213 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 81, 3343, 3426);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context213.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context214 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 86, 3441, 3555);
                        return ConfigStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context214.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context215 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 92, 3570, 4057);
                        CallChecker.varInit(o, "o", 92, 3570, 4057);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 103, 3892, 3930);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 105, 3981, 3984)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 105, 4026, 4029)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 105, 3956, 3972).equals(CallChecker.isCalled(that, LogMessage.class, 105, 3981, 3984).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 105, 4008, 4017).equals(CallChecker.isCalled(that, LogMessage.class, 105, 4026, 4029).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context215.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context216 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 110, 4072, 4294);
                        final String npe_invocation_var10 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var10, String.class, 112, 4159, 4168)) {
                            result = CallChecker.isCalled(npe_invocation_var10, String.class, 112, 4159, 4168).hashCode();
                            CallChecker.varAssign(result, "result", 112, 4159, 4168);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 113, 4221, 4237).hashCode());
                        CallChecker.varAssign(result, "result", 113, 4198, 4249);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context216.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context217.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context222 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_START_LOG_HIERARCHY", 126, 4318, 5692);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 126, 4318, 5692);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CREATED_LOG_HIERARCHY", 126, 4318, 5692);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CLOSE_LOG_HIERARCHY", 126, 4318, 5692);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 126, 4318, 5692);
            CallChecker.varInit(CONFIGSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CONFIGSTORE_LOG_HIERARCHY", 126, 4318, 5692);
            CallChecker.varInit(ConfigStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._currentLocale", 126, 4318, 5692);
            CallChecker.varInit(ConfigStoreMessages._messages, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._messages", 126, 4318, 5692);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConfigStoreMessages._messages, ResourceBundle.class, 128, 4607, 4615)) {
                ConfigStoreMessages._messages = CallChecker.beforeCalled(ConfigStoreMessages._messages, ResourceBundle.class, 128, 4607, 4615);
                rawMessage = CallChecker.isCalled(ConfigStoreMessages._messages, ResourceBundle.class, 128, 4607, 4615).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 128, 4607, 4615);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 130, 4646, 4679);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context218 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 134, 4736, 4819);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context218.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context219 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 139, 4834, 4936);
                        return ConfigStoreMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context219.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context220 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 145, 4951, 5438);
                        CallChecker.varInit(o, "o", 145, 4951, 5438);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 156, 5273, 5311);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 158, 5362, 5365)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 158, 5407, 5410)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 158, 5337, 5353).equals(CallChecker.isCalled(that, LogMessage.class, 158, 5362, 5365).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 158, 5389, 5398).equals(CallChecker.isCalled(that, LogMessage.class, 158, 5407, 5410).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context220.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context221 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 163, 5453, 5675);
                        final String npe_invocation_var11 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var11, String.class, 165, 5540, 5549)) {
                            result = CallChecker.isCalled(npe_invocation_var11, String.class, 165, 5540, 5549).hashCode();
                            CallChecker.varAssign(result, "result", 165, 5540, 5549);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 166, 5602, 5618).hashCode());
                        CallChecker.varAssign(result, "result", 166, 5579, 5630);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context221.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context222.methodEnd();
        }
    }

    public static LogMessage CREATED() {
        MethodContext _bcornu_methode_context227 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_START_LOG_HIERARCHY", 179, 5699, 7080);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 179, 5699, 7080);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CREATED_LOG_HIERARCHY", 179, 5699, 7080);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CLOSE_LOG_HIERARCHY", 179, 5699, 7080);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 179, 5699, 7080);
            CallChecker.varInit(CONFIGSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CONFIGSTORE_LOG_HIERARCHY", 179, 5699, 7080);
            CallChecker.varInit(ConfigStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._currentLocale", 179, 5699, 7080);
            CallChecker.varInit(ConfigStoreMessages._messages, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._messages", 179, 5699, 7080);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConfigStoreMessages._messages, ResourceBundle.class, 181, 5991, 5999)) {
                ConfigStoreMessages._messages = CallChecker.beforeCalled(ConfigStoreMessages._messages, ResourceBundle.class, 181, 5991, 5999);
                rawMessage = CallChecker.isCalled(ConfigStoreMessages._messages, ResourceBundle.class, 181, 5991, 5999).getString("CREATED");
                CallChecker.varAssign(rawMessage, "rawMessage", 181, 5991, 5999);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 183, 6032, 6065);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context223 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 187, 6122, 6205);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context223.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context224 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 192, 6220, 6324);
                        return ConfigStoreMessages.CREATED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context224.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context225 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 198, 6339, 6826);
                        CallChecker.varInit(o, "o", 198, 6339, 6826);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 209, 6661, 6699);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 211, 6750, 6753)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 211, 6795, 6798)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 211, 6725, 6741).equals(CallChecker.isCalled(that, LogMessage.class, 211, 6750, 6753).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 211, 6777, 6786).equals(CallChecker.isCalled(that, LogMessage.class, 211, 6795, 6798).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context225.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context226 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 216, 6841, 7063);
                        final String npe_invocation_var12 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var12, String.class, 218, 6928, 6937)) {
                            result = CallChecker.isCalled(npe_invocation_var12, String.class, 218, 6928, 6937).hashCode();
                            CallChecker.varAssign(result, "result", 218, 6928, 6937);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 219, 6990, 7006).hashCode());
                        CallChecker.varAssign(result, "result", 219, 6967, 7018);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context226.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context227.methodEnd();
        }
    }

    public static LogMessage STORE_LOCATION(String param1) {
        MethodContext _bcornu_methode_context232 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 232, 7087, 8813);
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_START_LOG_HIERARCHY", 232, 7087, 8813);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 232, 7087, 8813);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CREATED_LOG_HIERARCHY", 232, 7087, 8813);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CLOSE_LOG_HIERARCHY", 232, 7087, 8813);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 232, 7087, 8813);
            CallChecker.varInit(CONFIGSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CONFIGSTORE_LOG_HIERARCHY", 232, 7087, 8813);
            CallChecker.varInit(ConfigStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._currentLocale", 232, 7087, 8813);
            CallChecker.varInit(ConfigStoreMessages._messages, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._messages", 232, 7087, 8813);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConfigStoreMessages._messages, ResourceBundle.class, 234, 7412, 7420)) {
                ConfigStoreMessages._messages = CallChecker.beforeCalled(ConfigStoreMessages._messages, ResourceBundle.class, 234, 7412, 7420);
                rawMessage = CallChecker.isCalled(ConfigStoreMessages._messages, ResourceBundle.class, 234, 7412, 7420).getString("STORE_LOCATION");
                CallChecker.varAssign(rawMessage, "rawMessage", 234, 7412, 7420);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 236, 7460, 7502);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, ConfigStoreMessages._currentLocale), "formatter", 239, 7652, 7723);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 241, 7757, 7765);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 241, 7757, 7765).format(messageArguments), "message", 241, 7734, 7791);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context228 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 245, 7848, 7931);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context228.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context229 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 250, 7946, 8057);
                        return ConfigStoreMessages.STORE_LOCATION_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context229.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context230 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 256, 8072, 8559);
                        CallChecker.varInit(o, "o", 256, 8072, 8559);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 267, 8394, 8432);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 269, 8483, 8486)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 269, 8528, 8531)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 269, 8458, 8474).equals(CallChecker.isCalled(that, LogMessage.class, 269, 8483, 8486).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 269, 8510, 8519).equals(CallChecker.isCalled(that, LogMessage.class, 269, 8528, 8531).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context230.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context231 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 274, 8574, 8796);
                        final String npe_invocation_var13 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var13, String.class, 276, 8661, 8670)) {
                            result = CallChecker.isCalled(npe_invocation_var13, String.class, 276, 8661, 8670).hashCode();
                            CallChecker.varAssign(result, "result", 276, 8661, 8670);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 277, 8723, 8739).hashCode());
                        CallChecker.varAssign(result, "result", 277, 8700, 8751);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context231.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context232.methodEnd();
        }
    }

    public static LogMessage RECOVERY_START() {
        MethodContext _bcornu_methode_context237 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(RECOVERY_START_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_START_LOG_HIERARCHY", 290, 8820, 10229);
            CallChecker.varInit(STORE_LOCATION_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.STORE_LOCATION_LOG_HIERARCHY", 290, 8820, 10229);
            CallChecker.varInit(CREATED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CREATED_LOG_HIERARCHY", 290, 8820, 10229);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CLOSE_LOG_HIERARCHY", 290, 8820, 10229);
            CallChecker.varInit(RECOVERY_COMPLETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.RECOVERY_COMPLETE_LOG_HIERARCHY", 290, 8820, 10229);
            CallChecker.varInit(CONFIGSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.ConfigStoreMessages.CONFIGSTORE_LOG_HIERARCHY", 290, 8820, 10229);
            CallChecker.varInit(ConfigStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._currentLocale", 290, 8820, 10229);
            CallChecker.varInit(ConfigStoreMessages._messages, "org.apache.qpid.server.logging.messages.ConfigStoreMessages._messages", 290, 8820, 10229);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(ConfigStoreMessages._messages, ResourceBundle.class, 292, 9126, 9134)) {
                ConfigStoreMessages._messages = CallChecker.beforeCalled(ConfigStoreMessages._messages, ResourceBundle.class, 292, 9126, 9134);
                rawMessage = CallChecker.isCalled(ConfigStoreMessages._messages, ResourceBundle.class, 292, 9126, 9134).getString("RECOVERY_START");
                CallChecker.varAssign(rawMessage, "rawMessage", 292, 9126, 9134);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 294, 9174, 9207);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context233 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 298, 9264, 9347);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context233.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context234 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 303, 9362, 9473);
                        return ConfigStoreMessages.RECOVERY_START_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context234.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context235 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 309, 9488, 9975);
                        CallChecker.varInit(o, "o", 309, 9488, 9975);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 320, 9810, 9848);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 322, 9899, 9902)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 322, 9944, 9947)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 322, 9874, 9890).equals(CallChecker.isCalled(that, LogMessage.class, 322, 9899, 9902).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 322, 9926, 9935).equals(CallChecker.isCalled(that, LogMessage.class, 322, 9944, 9947).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context235.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context236 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 327, 9990, 10212);
                        final String npe_invocation_var14 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var14, String.class, 329, 10077, 10086)) {
                            result = CallChecker.isCalled(npe_invocation_var14, String.class, 329, 10077, 10086).hashCode();
                            CallChecker.varAssign(result, "result", 329, 10077, 10086);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 330, 10139, 10155).hashCode());
                        CallChecker.varAssign(result, "result", 330, 10116, 10167);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context236.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context237.methodEnd();
        }
    }

    private ConfigStoreMessages() {
        MethodContext _bcornu_methode_context23 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }
}

