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

public class KeyStoreMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String KEYSTORE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "keystore";

    public static final String OPEN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "keystore.open";

    public static final String CREATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "keystore.create";

    public static final String DELETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "keystore.delete";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "keystore.close";

    static {
        LoggerFactory.getLogger(KeyStoreMessages.KEYSTORE_LOG_HIERARCHY);
        LoggerFactory.getLogger(KeyStoreMessages.OPEN_LOG_HIERARCHY);
        LoggerFactory.getLogger(KeyStoreMessages.CREATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(KeyStoreMessages.DELETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(KeyStoreMessages.CLOSE_LOG_HIERARCHY);
        KeyStoreMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.KeyStore_logmessages", KeyStoreMessages._currentLocale);
        CallChecker.varAssign(KeyStoreMessages._messages, "KeyStoreMessages._messages", 61, 2479, 2595);
    }

    public static LogMessage OPEN() {
        MethodContext _bcornu_methode_context743 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CLOSE_LOG_HIERARCHY", 71, 2608, 3974);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.DELETE_LOG_HIERARCHY", 71, 2608, 3974);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CREATE_LOG_HIERARCHY", 71, 2608, 3974);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.OPEN_LOG_HIERARCHY", 71, 2608, 3974);
            CallChecker.varInit(KEYSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.KEYSTORE_LOG_HIERARCHY", 71, 2608, 3974);
            CallChecker.varInit(KeyStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.KeyStoreMessages._currentLocale", 71, 2608, 3974);
            CallChecker.varInit(KeyStoreMessages._messages, "org.apache.qpid.server.logging.messages.KeyStoreMessages._messages", 71, 2608, 3974);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(KeyStoreMessages._messages, ResourceBundle.class, 73, 2891, 2899)) {
                KeyStoreMessages._messages = CallChecker.beforeCalled(KeyStoreMessages._messages, ResourceBundle.class, 73, 2891, 2899);
                rawMessage = CallChecker.isCalled(KeyStoreMessages._messages, ResourceBundle.class, 73, 2891, 2899).getString("OPEN");
                CallChecker.varAssign(rawMessage, "rawMessage", 73, 2891, 2899);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 75, 2929, 2962);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context739 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 79, 3019, 3102);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context739.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context740 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 84, 3117, 3218);
                        return KeyStoreMessages.OPEN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context740.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context741 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 90, 3233, 3720);
                        CallChecker.varInit(o, "o", 90, 3233, 3720);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 101, 3555, 3593);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 103, 3644, 3647)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 103, 3689, 3692)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 103, 3619, 3635).equals(CallChecker.isCalled(that, LogMessage.class, 103, 3644, 3647).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 103, 3671, 3680).equals(CallChecker.isCalled(that, LogMessage.class, 103, 3689, 3692).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context741.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context742 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 108, 3735, 3957);
                        final String npe_invocation_var98 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var98, String.class, 110, 3822, 3831)) {
                            result = CallChecker.isCalled(npe_invocation_var98, String.class, 110, 3822, 3831).hashCode();
                            CallChecker.varAssign(result, "result", 110, 3822, 3831);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 111, 3884, 3900).hashCode());
                        CallChecker.varAssign(result, "result", 111, 3861, 3912);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context742.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context743.methodEnd();
        }
    }

    public static LogMessage CREATE(String param1) {
        MethodContext _bcornu_methode_context748 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 124, 3981, 5672);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CLOSE_LOG_HIERARCHY", 124, 3981, 5672);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.DELETE_LOG_HIERARCHY", 124, 3981, 5672);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CREATE_LOG_HIERARCHY", 124, 3981, 5672);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.OPEN_LOG_HIERARCHY", 124, 3981, 5672);
            CallChecker.varInit(KEYSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.KEYSTORE_LOG_HIERARCHY", 124, 3981, 5672);
            CallChecker.varInit(KeyStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.KeyStoreMessages._currentLocale", 124, 3981, 5672);
            CallChecker.varInit(KeyStoreMessages._messages, "org.apache.qpid.server.logging.messages.KeyStoreMessages._messages", 124, 3981, 5672);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(KeyStoreMessages._messages, ResourceBundle.class, 126, 4287, 4295)) {
                KeyStoreMessages._messages = CallChecker.beforeCalled(KeyStoreMessages._messages, ResourceBundle.class, 126, 4287, 4295);
                rawMessage = CallChecker.isCalled(KeyStoreMessages._messages, ResourceBundle.class, 126, 4287, 4295).getString("CREATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 126, 4287, 4295);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 128, 4327, 4369);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, KeyStoreMessages._currentLocale), "formatter", 131, 4519, 4590);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 133, 4624, 4632);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 133, 4624, 4632).format(messageArguments), "message", 133, 4601, 4658);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context744 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 137, 4715, 4798);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context744.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context745 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 142, 4813, 4916);
                        return KeyStoreMessages.CREATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context745.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context746 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 148, 4931, 5418);
                        CallChecker.varInit(o, "o", 148, 4931, 5418);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 159, 5253, 5291);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 161, 5342, 5345)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 161, 5387, 5390)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 161, 5317, 5333).equals(CallChecker.isCalled(that, LogMessage.class, 161, 5342, 5345).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 161, 5369, 5378).equals(CallChecker.isCalled(that, LogMessage.class, 161, 5387, 5390).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context746.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context747 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 166, 5433, 5655);
                        final String npe_invocation_var99 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var99, String.class, 168, 5520, 5529)) {
                            result = CallChecker.isCalled(npe_invocation_var99, String.class, 168, 5520, 5529).hashCode();
                            CallChecker.varAssign(result, "result", 168, 5520, 5529);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 169, 5582, 5598).hashCode());
                        CallChecker.varAssign(result, "result", 169, 5559, 5610);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context747.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context748.methodEnd();
        }
    }

    public static LogMessage DELETE(String param1) {
        MethodContext _bcornu_methode_context753 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 182, 5679, 7370);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CLOSE_LOG_HIERARCHY", 182, 5679, 7370);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.DELETE_LOG_HIERARCHY", 182, 5679, 7370);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CREATE_LOG_HIERARCHY", 182, 5679, 7370);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.OPEN_LOG_HIERARCHY", 182, 5679, 7370);
            CallChecker.varInit(KEYSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.KEYSTORE_LOG_HIERARCHY", 182, 5679, 7370);
            CallChecker.varInit(KeyStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.KeyStoreMessages._currentLocale", 182, 5679, 7370);
            CallChecker.varInit(KeyStoreMessages._messages, "org.apache.qpid.server.logging.messages.KeyStoreMessages._messages", 182, 5679, 7370);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(KeyStoreMessages._messages, ResourceBundle.class, 184, 5985, 5993)) {
                KeyStoreMessages._messages = CallChecker.beforeCalled(KeyStoreMessages._messages, ResourceBundle.class, 184, 5985, 5993);
                rawMessage = CallChecker.isCalled(KeyStoreMessages._messages, ResourceBundle.class, 184, 5985, 5993).getString("DELETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 184, 5985, 5993);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 186, 6025, 6067);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, KeyStoreMessages._currentLocale), "formatter", 189, 6217, 6288);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 191, 6322, 6330);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 191, 6322, 6330).format(messageArguments), "message", 191, 6299, 6356);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context749 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 195, 6413, 6496);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context749.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context750 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 200, 6511, 6614);
                        return KeyStoreMessages.DELETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context750.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context751 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 206, 6629, 7116);
                        CallChecker.varInit(o, "o", 206, 6629, 7116);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 217, 6951, 6989);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7040, 7043)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 219, 7085, 7088)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 219, 7015, 7031).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7040, 7043).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 219, 7067, 7076).equals(CallChecker.isCalled(that, LogMessage.class, 219, 7085, 7088).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context751.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context752 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 224, 7131, 7353);
                        final String npe_invocation_var100 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var100, String.class, 226, 7218, 7227)) {
                            result = CallChecker.isCalled(npe_invocation_var100, String.class, 226, 7218, 7227).hashCode();
                            CallChecker.varAssign(result, "result", 226, 7218, 7227);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 227, 7280, 7296).hashCode());
                        CallChecker.varAssign(result, "result", 227, 7257, 7308);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context752.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context753.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context758 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CLOSE_LOG_HIERARCHY", 240, 7377, 8747);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.DELETE_LOG_HIERARCHY", 240, 7377, 8747);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.CREATE_LOG_HIERARCHY", 240, 7377, 8747);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.OPEN_LOG_HIERARCHY", 240, 7377, 8747);
            CallChecker.varInit(KEYSTORE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.KeyStoreMessages.KEYSTORE_LOG_HIERARCHY", 240, 7377, 8747);
            CallChecker.varInit(KeyStoreMessages._currentLocale, "org.apache.qpid.server.logging.messages.KeyStoreMessages._currentLocale", 240, 7377, 8747);
            CallChecker.varInit(KeyStoreMessages._messages, "org.apache.qpid.server.logging.messages.KeyStoreMessages._messages", 240, 7377, 8747);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(KeyStoreMessages._messages, ResourceBundle.class, 242, 7662, 7670)) {
                KeyStoreMessages._messages = CallChecker.beforeCalled(KeyStoreMessages._messages, ResourceBundle.class, 242, 7662, 7670);
                rawMessage = CallChecker.isCalled(KeyStoreMessages._messages, ResourceBundle.class, 242, 7662, 7670).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 242, 7662, 7670);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 244, 7701, 7734);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context754 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 248, 7791, 7874);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context754.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context755 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 253, 7889, 7991);
                        return KeyStoreMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context755.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context756 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 259, 8006, 8493);
                        CallChecker.varInit(o, "o", 259, 8006, 8493);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 270, 8328, 8366);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 272, 8417, 8420)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 272, 8462, 8465)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 272, 8392, 8408).equals(CallChecker.isCalled(that, LogMessage.class, 272, 8417, 8420).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 272, 8444, 8453).equals(CallChecker.isCalled(that, LogMessage.class, 272, 8462, 8465).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context756.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context757 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 277, 8508, 8730);
                        final String npe_invocation_var101 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var101, String.class, 279, 8595, 8604)) {
                            result = CallChecker.isCalled(npe_invocation_var101, String.class, 279, 8595, 8604).hashCode();
                            CallChecker.varAssign(result, "result", 279, 8595, 8604);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 280, 8657, 8673).hashCode());
                        CallChecker.varAssign(result, "result", 280, 8634, 8685);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context757.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context758.methodEnd();
        }
    }

    private KeyStoreMessages() {
        MethodContext _bcornu_methode_context51 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }
}

