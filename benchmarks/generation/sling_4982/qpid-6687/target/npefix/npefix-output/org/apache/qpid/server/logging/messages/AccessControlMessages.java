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

public class AccessControlMessages {
    private static ResourceBundle _messages;

    private static Locale _currentLocale = BrokerProperties.getLocale();

    public static final String ACCESSCONTROL_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "accesscontrol";

    public static final String OPEN_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "accesscontrol.open";

    public static final String CREATE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "accesscontrol.create";

    public static final String DELETE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "accesscontrol.delete";

    public static final String CLOSE_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "accesscontrol.close";

    public static final String DENIED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "accesscontrol.denied";

    public static final String ALLOWED_LOG_HIERARCHY = (AbstractMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX) + "accesscontrol.allowed";

    static {
        LoggerFactory.getLogger(AccessControlMessages.ACCESSCONTROL_LOG_HIERARCHY);
        LoggerFactory.getLogger(AccessControlMessages.OPEN_LOG_HIERARCHY);
        LoggerFactory.getLogger(AccessControlMessages.CREATE_LOG_HIERARCHY);
        LoggerFactory.getLogger(AccessControlMessages.DELETE_LOG_HIERARCHY);
        LoggerFactory.getLogger(AccessControlMessages.CLOSE_LOG_HIERARCHY);
        LoggerFactory.getLogger(AccessControlMessages.DENIED_LOG_HIERARCHY);
        LoggerFactory.getLogger(AccessControlMessages.ALLOWED_LOG_HIERARCHY);
        AccessControlMessages._messages = ResourceBundle.getBundle("org.apache.qpid.server.logging.messages.AccessControl_logmessages", AccessControlMessages._currentLocale);
        CallChecker.varAssign(AccessControlMessages._messages, "AccessControlMessages._messages", 65, 2855, 2976);
    }

    public static LogMessage OPEN() {
        MethodContext _bcornu_methode_context604 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(ALLOWED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ALLOWED_LOG_HIERARCHY", 75, 2989, 4360);
            CallChecker.varInit(DENIED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DENIED_LOG_HIERARCHY", 75, 2989, 4360);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CLOSE_LOG_HIERARCHY", 75, 2989, 4360);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DELETE_LOG_HIERARCHY", 75, 2989, 4360);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CREATE_LOG_HIERARCHY", 75, 2989, 4360);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.OPEN_LOG_HIERARCHY", 75, 2989, 4360);
            CallChecker.varInit(ACCESSCONTROL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ACCESSCONTROL_LOG_HIERARCHY", 75, 2989, 4360);
            CallChecker.varInit(AccessControlMessages._currentLocale, "org.apache.qpid.server.logging.messages.AccessControlMessages._currentLocale", 75, 2989, 4360);
            CallChecker.varInit(AccessControlMessages._messages, "org.apache.qpid.server.logging.messages.AccessControlMessages._messages", 75, 2989, 4360);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AccessControlMessages._messages, ResourceBundle.class, 77, 3277, 3285)) {
                AccessControlMessages._messages = CallChecker.beforeCalled(AccessControlMessages._messages, ResourceBundle.class, 77, 3277, 3285);
                rawMessage = CallChecker.isCalled(AccessControlMessages._messages, ResourceBundle.class, 77, 3277, 3285).getString("OPEN");
                CallChecker.varAssign(rawMessage, "rawMessage", 77, 3277, 3285);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 79, 3315, 3348);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context600 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 83, 3405, 3488);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context600.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context601 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 88, 3503, 3604);
                        return AccessControlMessages.OPEN_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context601.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context602 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 94, 3619, 4106);
                        CallChecker.varInit(o, "o", 94, 3619, 4106);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 105, 3941, 3979);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 107, 4030, 4033)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 107, 4075, 4078)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 107, 4005, 4021).equals(CallChecker.isCalled(that, LogMessage.class, 107, 4030, 4033).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 107, 4057, 4066).equals(CallChecker.isCalled(that, LogMessage.class, 107, 4075, 4078).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context602.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context603 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 112, 4121, 4343);
                        final String npe_invocation_var76 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var76, String.class, 114, 4208, 4217)) {
                            result = CallChecker.isCalled(npe_invocation_var76, String.class, 114, 4208, 4217).hashCode();
                            CallChecker.varAssign(result, "result", 114, 4208, 4217);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 115, 4270, 4286).hashCode());
                        CallChecker.varAssign(result, "result", 115, 4247, 4298);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context603.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context604.methodEnd();
        }
    }

    public static LogMessage CREATE(String param1) {
        MethodContext _bcornu_methode_context609 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 128, 4367, 6063);
            CallChecker.varInit(ALLOWED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ALLOWED_LOG_HIERARCHY", 128, 4367, 6063);
            CallChecker.varInit(DENIED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DENIED_LOG_HIERARCHY", 128, 4367, 6063);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CLOSE_LOG_HIERARCHY", 128, 4367, 6063);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DELETE_LOG_HIERARCHY", 128, 4367, 6063);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CREATE_LOG_HIERARCHY", 128, 4367, 6063);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.OPEN_LOG_HIERARCHY", 128, 4367, 6063);
            CallChecker.varInit(ACCESSCONTROL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ACCESSCONTROL_LOG_HIERARCHY", 128, 4367, 6063);
            CallChecker.varInit(AccessControlMessages._currentLocale, "org.apache.qpid.server.logging.messages.AccessControlMessages._currentLocale", 128, 4367, 6063);
            CallChecker.varInit(AccessControlMessages._messages, "org.apache.qpid.server.logging.messages.AccessControlMessages._messages", 128, 4367, 6063);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AccessControlMessages._messages, ResourceBundle.class, 130, 4678, 4686)) {
                AccessControlMessages._messages = CallChecker.beforeCalled(AccessControlMessages._messages, ResourceBundle.class, 130, 4678, 4686);
                rawMessage = CallChecker.isCalled(AccessControlMessages._messages, ResourceBundle.class, 130, 4678, 4686).getString("CREATE");
                CallChecker.varAssign(rawMessage, "rawMessage", 130, 4678, 4686);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 132, 4718, 4760);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, AccessControlMessages._currentLocale), "formatter", 135, 4910, 4981);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 137, 5015, 5023);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 137, 5015, 5023).format(messageArguments), "message", 137, 4992, 5049);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context605 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 141, 5106, 5189);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context605.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context606 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 146, 5204, 5307);
                        return AccessControlMessages.CREATE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context606.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context607 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 152, 5322, 5809);
                        CallChecker.varInit(o, "o", 152, 5322, 5809);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 163, 5644, 5682);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 165, 5733, 5736)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 165, 5778, 5781)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 165, 5708, 5724).equals(CallChecker.isCalled(that, LogMessage.class, 165, 5733, 5736).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 165, 5760, 5769).equals(CallChecker.isCalled(that, LogMessage.class, 165, 5778, 5781).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context607.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context608 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 170, 5824, 6046);
                        final String npe_invocation_var77 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var77, String.class, 172, 5911, 5920)) {
                            result = CallChecker.isCalled(npe_invocation_var77, String.class, 172, 5911, 5920).hashCode();
                            CallChecker.varAssign(result, "result", 172, 5911, 5920);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 173, 5973, 5989).hashCode());
                        CallChecker.varAssign(result, "result", 173, 5950, 6001);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context608.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context609.methodEnd();
        }
    }

    public static LogMessage DELETE(String param1) {
        MethodContext _bcornu_methode_context614 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param1, "param1", 186, 6070, 7766);
            CallChecker.varInit(ALLOWED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ALLOWED_LOG_HIERARCHY", 186, 6070, 7766);
            CallChecker.varInit(DENIED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DENIED_LOG_HIERARCHY", 186, 6070, 7766);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CLOSE_LOG_HIERARCHY", 186, 6070, 7766);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DELETE_LOG_HIERARCHY", 186, 6070, 7766);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CREATE_LOG_HIERARCHY", 186, 6070, 7766);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.OPEN_LOG_HIERARCHY", 186, 6070, 7766);
            CallChecker.varInit(ACCESSCONTROL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ACCESSCONTROL_LOG_HIERARCHY", 186, 6070, 7766);
            CallChecker.varInit(AccessControlMessages._currentLocale, "org.apache.qpid.server.logging.messages.AccessControlMessages._currentLocale", 186, 6070, 7766);
            CallChecker.varInit(AccessControlMessages._messages, "org.apache.qpid.server.logging.messages.AccessControlMessages._messages", 186, 6070, 7766);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AccessControlMessages._messages, ResourceBundle.class, 188, 6381, 6389)) {
                AccessControlMessages._messages = CallChecker.beforeCalled(AccessControlMessages._messages, ResourceBundle.class, 188, 6381, 6389);
                rawMessage = CallChecker.isCalled(AccessControlMessages._messages, ResourceBundle.class, 188, 6381, 6389).getString("DELETE");
                CallChecker.varAssign(rawMessage, "rawMessage", 188, 6381, 6389);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 }, "messageArguments", 190, 6421, 6463);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, AccessControlMessages._currentLocale), "formatter", 193, 6613, 6684);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 195, 6718, 6726);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 195, 6718, 6726).format(messageArguments), "message", 195, 6695, 6752);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context610 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 199, 6809, 6892);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context610.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context611 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 204, 6907, 7010);
                        return AccessControlMessages.DELETE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context611.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context612 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 210, 7025, 7512);
                        CallChecker.varInit(o, "o", 210, 7025, 7512);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 221, 7347, 7385);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 223, 7436, 7439)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 223, 7481, 7484)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 223, 7411, 7427).equals(CallChecker.isCalled(that, LogMessage.class, 223, 7436, 7439).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 223, 7463, 7472).equals(CallChecker.isCalled(that, LogMessage.class, 223, 7481, 7484).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context612.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context613 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 228, 7527, 7749);
                        final String npe_invocation_var78 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var78, String.class, 230, 7614, 7623)) {
                            result = CallChecker.isCalled(npe_invocation_var78, String.class, 230, 7614, 7623).hashCode();
                            CallChecker.varAssign(result, "result", 230, 7614, 7623);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 231, 7676, 7692).hashCode());
                        CallChecker.varAssign(result, "result", 231, 7653, 7704);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context613.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context614.methodEnd();
        }
    }

    public static LogMessage CLOSE() {
        MethodContext _bcornu_methode_context619 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(ALLOWED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ALLOWED_LOG_HIERARCHY", 244, 7773, 9148);
            CallChecker.varInit(DENIED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DENIED_LOG_HIERARCHY", 244, 7773, 9148);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CLOSE_LOG_HIERARCHY", 244, 7773, 9148);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DELETE_LOG_HIERARCHY", 244, 7773, 9148);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CREATE_LOG_HIERARCHY", 244, 7773, 9148);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.OPEN_LOG_HIERARCHY", 244, 7773, 9148);
            CallChecker.varInit(ACCESSCONTROL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ACCESSCONTROL_LOG_HIERARCHY", 244, 7773, 9148);
            CallChecker.varInit(AccessControlMessages._currentLocale, "org.apache.qpid.server.logging.messages.AccessControlMessages._currentLocale", 244, 7773, 9148);
            CallChecker.varInit(AccessControlMessages._messages, "org.apache.qpid.server.logging.messages.AccessControlMessages._messages", 244, 7773, 9148);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AccessControlMessages._messages, ResourceBundle.class, 246, 8063, 8071)) {
                AccessControlMessages._messages = CallChecker.beforeCalled(AccessControlMessages._messages, ResourceBundle.class, 246, 8063, 8071);
                rawMessage = CallChecker.isCalled(AccessControlMessages._messages, ResourceBundle.class, 246, 8063, 8071).getString("CLOSE");
                CallChecker.varAssign(rawMessage, "rawMessage", 246, 8063, 8071);
            }
            final String message = CallChecker.varInit(rawMessage, "message", 248, 8102, 8135);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context615 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 252, 8192, 8275);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context615.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context616 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 257, 8290, 8392);
                        return AccessControlMessages.CLOSE_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context616.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context617 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 263, 8407, 8894);
                        CallChecker.varInit(o, "o", 263, 8407, 8894);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 274, 8729, 8767);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 276, 8818, 8821)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 276, 8863, 8866)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 276, 8793, 8809).equals(CallChecker.isCalled(that, LogMessage.class, 276, 8818, 8821).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 276, 8845, 8854).equals(CallChecker.isCalled(that, LogMessage.class, 276, 8863, 8866).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context617.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context618 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 281, 8909, 9131);
                        final String npe_invocation_var79 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var79, String.class, 283, 8996, 9005)) {
                            result = CallChecker.isCalled(npe_invocation_var79, String.class, 283, 8996, 9005).hashCode();
                            CallChecker.varAssign(result, "result", 283, 8996, 9005);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 284, 9058, 9074).hashCode());
                        CallChecker.varAssign(result, "result", 284, 9035, 9086);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context618.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context619.methodEnd();
        }
    }

    public static LogMessage DENIED(String param1, String param2, String param3) {
        MethodContext _bcornu_methode_context624 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param3, "param3", 297, 9155, 10905);
            CallChecker.varInit(param2, "param2", 297, 9155, 10905);
            CallChecker.varInit(param1, "param1", 297, 9155, 10905);
            CallChecker.varInit(ALLOWED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ALLOWED_LOG_HIERARCHY", 297, 9155, 10905);
            CallChecker.varInit(DENIED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DENIED_LOG_HIERARCHY", 297, 9155, 10905);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CLOSE_LOG_HIERARCHY", 297, 9155, 10905);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DELETE_LOG_HIERARCHY", 297, 9155, 10905);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CREATE_LOG_HIERARCHY", 297, 9155, 10905);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.OPEN_LOG_HIERARCHY", 297, 9155, 10905);
            CallChecker.varInit(ACCESSCONTROL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ACCESSCONTROL_LOG_HIERARCHY", 297, 9155, 10905);
            CallChecker.varInit(AccessControlMessages._currentLocale, "org.apache.qpid.server.logging.messages.AccessControlMessages._currentLocale", 297, 9155, 10905);
            CallChecker.varInit(AccessControlMessages._messages, "org.apache.qpid.server.logging.messages.AccessControlMessages._messages", 297, 9155, 10905);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AccessControlMessages._messages, ResourceBundle.class, 299, 9504, 9512)) {
                AccessControlMessages._messages = CallChecker.beforeCalled(AccessControlMessages._messages, ResourceBundle.class, 299, 9504, 9512);
                rawMessage = CallChecker.isCalled(AccessControlMessages._messages, ResourceBundle.class, 299, 9504, 9512).getString("DENIED");
                CallChecker.varAssign(rawMessage, "rawMessage", 299, 9504, 9512);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 }, "messageArguments", 301, 9544, 9602);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, AccessControlMessages._currentLocale), "formatter", 304, 9752, 9823);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 306, 9857, 9865);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 306, 9857, 9865).format(messageArguments), "message", 306, 9834, 9891);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context620 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 310, 9948, 10031);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context620.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context621 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 315, 10046, 10149);
                        return AccessControlMessages.DENIED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context621.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context622 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 321, 10164, 10651);
                        CallChecker.varInit(o, "o", 321, 10164, 10651);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 332, 10486, 10524);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 334, 10575, 10578)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 334, 10620, 10623)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 334, 10550, 10566).equals(CallChecker.isCalled(that, LogMessage.class, 334, 10575, 10578).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 334, 10602, 10611).equals(CallChecker.isCalled(that, LogMessage.class, 334, 10620, 10623).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context622.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context623 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 339, 10666, 10888);
                        final String npe_invocation_var80 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var80, String.class, 341, 10753, 10762)) {
                            result = CallChecker.isCalled(npe_invocation_var80, String.class, 341, 10753, 10762).hashCode();
                            CallChecker.varAssign(result, "result", 341, 10753, 10762);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 342, 10815, 10831).hashCode());
                        CallChecker.varAssign(result, "result", 342, 10792, 10843);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context623.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context624.methodEnd();
        }
    }

    public static LogMessage ALLOWED(String param1, String param2, String param3) {
        MethodContext _bcornu_methode_context629 = new MethodContext(LogMessage.class);
        try {
            CallChecker.varInit(param3, "param3", 355, 10912, 12666);
            CallChecker.varInit(param2, "param2", 355, 10912, 12666);
            CallChecker.varInit(param1, "param1", 355, 10912, 12666);
            CallChecker.varInit(ALLOWED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ALLOWED_LOG_HIERARCHY", 355, 10912, 12666);
            CallChecker.varInit(DENIED_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DENIED_LOG_HIERARCHY", 355, 10912, 12666);
            CallChecker.varInit(CLOSE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CLOSE_LOG_HIERARCHY", 355, 10912, 12666);
            CallChecker.varInit(DELETE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.DELETE_LOG_HIERARCHY", 355, 10912, 12666);
            CallChecker.varInit(CREATE_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.CREATE_LOG_HIERARCHY", 355, 10912, 12666);
            CallChecker.varInit(OPEN_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.OPEN_LOG_HIERARCHY", 355, 10912, 12666);
            CallChecker.varInit(ACCESSCONTROL_LOG_HIERARCHY, "org.apache.qpid.server.logging.messages.AccessControlMessages.ACCESSCONTROL_LOG_HIERARCHY", 355, 10912, 12666);
            CallChecker.varInit(AccessControlMessages._currentLocale, "org.apache.qpid.server.logging.messages.AccessControlMessages._currentLocale", 355, 10912, 12666);
            CallChecker.varInit(AccessControlMessages._messages, "org.apache.qpid.server.logging.messages.AccessControlMessages._messages", 355, 10912, 12666);
            String rawMessage = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(AccessControlMessages._messages, ResourceBundle.class, 357, 11263, 11271)) {
                AccessControlMessages._messages = CallChecker.beforeCalled(AccessControlMessages._messages, ResourceBundle.class, 357, 11263, 11271);
                rawMessage = CallChecker.isCalled(AccessControlMessages._messages, ResourceBundle.class, 357, 11263, 11271).getString("ALLOWED");
                CallChecker.varAssign(rawMessage, "rawMessage", 357, 11263, 11271);
            }
            final Object[] messageArguments = CallChecker.varInit(new Object[]{ param1 , param2 , param3 }, "messageArguments", 359, 11304, 11362);
            MessageFormat formatter = CallChecker.varInit(new MessageFormat(rawMessage, AccessControlMessages._currentLocale), "formatter", 362, 11512, 11583);
            formatter = CallChecker.beforeCalled(formatter, MessageFormat.class, 364, 11617, 11625);
            final String message = CallChecker.varInit(CallChecker.isCalled(formatter, MessageFormat.class, 364, 11617, 11625).format(messageArguments), "message", 364, 11594, 11651);
            return new LogMessage() {
                public String toString() {
                    MethodContext _bcornu_methode_context625 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 368, 11708, 11791);
                        return message;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context625.methodEnd();
                    }
                }

                public String getLogHierarchy() {
                    MethodContext _bcornu_methode_context626 = new MethodContext(String.class);
                    try {
                        CallChecker.varInit(this, "this", 373, 11806, 11910);
                        return AccessControlMessages.ALLOWED_LOG_HIERARCHY;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((String) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context626.methodEnd();
                    }
                }

                @Override
                public boolean equals(final Object o) {
                    MethodContext _bcornu_methode_context627 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 379, 11925, 12412);
                        CallChecker.varInit(o, "o", 379, 11925, 12412);
                        if ((this) == o) {
                            return true;
                        }
                        if ((o == null) || ((getClass()) != (o.getClass()))) {
                            return false;
                        }
                        final LogMessage that = CallChecker.varInit(((LogMessage) (o)), "that", 390, 12247, 12285);
                        if (CallChecker.beforeDeref(that, LogMessage.class, 392, 12336, 12339)) {
                            if (CallChecker.beforeDeref(that, LogMessage.class, 392, 12381, 12384)) {
                                return (CallChecker.isCalled(getLogHierarchy(), String.class, 392, 12311, 12327).equals(CallChecker.isCalled(that, LogMessage.class, 392, 12336, 12339).getLogHierarchy())) && (CallChecker.isCalled(toString(), String.class, 392, 12363, 12372).equals(CallChecker.isCalled(that, LogMessage.class, 392, 12381, 12384).toString()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context627.methodEnd();
                    }
                }

                @Override
                public int hashCode() {
                    MethodContext _bcornu_methode_context628 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 397, 12427, 12649);
                        final String npe_invocation_var81 = toString();
                        int result = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(npe_invocation_var81, String.class, 399, 12514, 12523)) {
                            result = CallChecker.isCalled(npe_invocation_var81, String.class, 399, 12514, 12523).hashCode();
                            CallChecker.varAssign(result, "result", 399, 12514, 12523);
                        }
                        result = (31 * result) + (CallChecker.isCalled(getLogHierarchy(), String.class, 400, 12576, 12592).hashCode());
                        CallChecker.varAssign(result, "result", 400, 12553, 12604);
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context628.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogMessage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context629.methodEnd();
        }
    }

    private AccessControlMessages() {
        MethodContext _bcornu_methode_context38 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }
}

