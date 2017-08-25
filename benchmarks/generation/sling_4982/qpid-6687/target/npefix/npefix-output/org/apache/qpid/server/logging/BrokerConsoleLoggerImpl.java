package org.apache.qpid.server.logging;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.Context;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;
import static org.apache.qpid.server.logging.BrokerConsoleLogger.ConsoleStreamTarget.STDERR;

public class BrokerConsoleLoggerImpl extends AbstractBrokerLogger<BrokerConsoleLoggerImpl> implements BrokerConsoleLogger<BrokerConsoleLoggerImpl> {
    @ManagedAttributeField
    private String _layout;

    @ManagedAttributeField
    private BrokerConsoleLogger.ConsoleStreamTarget _consoleStreamTarget;

    @ManagedObjectFactoryConstructor
    protected BrokerConsoleLoggerImpl(final Map<String, Object> attributes, Broker<?> broker) {
        super(attributes, broker);
        MethodContext _bcornu_methode_context44 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    @Override
    public BrokerConsoleLogger.ConsoleStreamTarget getConsoleStreamTarget() {
        MethodContext _bcornu_methode_context707 = new MethodContext(BrokerConsoleLogger.ConsoleStreamTarget.class);
        try {
            CallChecker.varInit(this, "this", 54, 1854, 1967);
            CallChecker.varInit(this.TYPE, "TYPE", 54, 1854, 1967);
            CallChecker.varInit(this._consoleStreamTarget, "_consoleStreamTarget", 54, 1854, 1967);
            CallChecker.varInit(this._layout, "_layout", 54, 1854, 1967);
            return _consoleStreamTarget;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BrokerConsoleLogger.ConsoleStreamTarget) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context707.methodEnd();
        }
    }

    @Override
    public String getLayout() {
        MethodContext _bcornu_methode_context708 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 60, 1974, 2048);
            CallChecker.varInit(this.TYPE, "TYPE", 60, 1974, 2048);
            CallChecker.varInit(this._consoleStreamTarget, "_consoleStreamTarget", 60, 1974, 2048);
            CallChecker.varInit(this._layout, "_layout", 60, 1974, 2048);
            return _layout;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context708.methodEnd();
        }
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context context) {
        MethodContext _bcornu_methode_context709 = new MethodContext(Appender.class);
        try {
            CallChecker.varInit(this, "this", 66, 2055, 2628);
            CallChecker.varInit(context, "context", 66, 2055, 2628);
            CallChecker.varInit(this.TYPE, "TYPE", 66, 2055, 2628);
            CallChecker.varInit(this._consoleStreamTarget, "_consoleStreamTarget", 66, 2055, 2628);
            CallChecker.varInit(this._layout, "_layout", 66, 2055, 2628);
            ConsoleAppender<ILoggingEvent> consoleAppender = CallChecker.varInit(new ConsoleAppender<>(), "consoleAppender", 68, 2157, 2229);
            final PatternLayoutEncoder encoder = CallChecker.varInit(new PatternLayoutEncoder(), "encoder", 70, 2240, 2303);
            if (CallChecker.beforeDeref(encoder, PatternLayoutEncoder.class, 71, 2313, 2319)) {
                CallChecker.isCalled(encoder, PatternLayoutEncoder.class, 71, 2313, 2319).setPattern(getLayout());
            }
            if (CallChecker.beforeDeref(encoder, PatternLayoutEncoder.class, 72, 2354, 2360)) {
                CallChecker.isCalled(encoder, PatternLayoutEncoder.class, 72, 2354, 2360).setContext(context);
            }
            if (CallChecker.beforeDeref(encoder, PatternLayoutEncoder.class, 73, 2391, 2397)) {
                CallChecker.isCalled(encoder, PatternLayoutEncoder.class, 73, 2391, 2397).start();
            }
            if ((_consoleStreamTarget) == (STDERR)) {
                if (CallChecker.beforeDeref(consoleAppender, ConsoleAppender.class, 77, 2495, 2509)) {
                    consoleAppender = CallChecker.beforeCalled(consoleAppender, ConsoleAppender.class, 77, 2495, 2509);
                    CallChecker.isCalled(consoleAppender, ConsoleAppender.class, 77, 2495, 2509).setTarget("System.err");
                }
            }
            if (CallChecker.beforeDeref(consoleAppender, ConsoleAppender.class, 79, 2554, 2568)) {
                consoleAppender = CallChecker.beforeCalled(consoleAppender, ConsoleAppender.class, 79, 2554, 2568);
                CallChecker.isCalled(consoleAppender, ConsoleAppender.class, 79, 2554, 2568).setEncoder(encoder);
            }
            return consoleAppender;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Appender<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context709.methodEnd();
        }
    }

    @SuppressWarnings(value = "unused")
    public static Collection<String> getAllConsoleStreamTarget() {
        MethodContext _bcornu_methode_context710 = new MethodContext(Collection.class);
        try {
            List<String> validValues = CallChecker.varInit(new ArrayList<>(), "validValues", 87, 2742, 2786);
            for (BrokerConsoleLogger.ConsoleStreamTarget level : EnumSet.allOf(BrokerConsoleLogger.ConsoleStreamTarget.class)) {
                if (CallChecker.beforeDeref(level, BrokerConsoleLogger.ConsoleStreamTarget.class, 90, 2909, 2913)) {
                    if (CallChecker.beforeDeref(validValues, List.class, 90, 2893, 2903)) {
                        validValues = CallChecker.beforeCalled(validValues, List.class, 90, 2893, 2903);
                        CallChecker.isCalled(validValues, List.class, 90, 2893, 2903).add(CallChecker.isCalled(level, BrokerConsoleLogger.ConsoleStreamTarget.class, 90, 2909, 2913).name());
                    }
                }
            }
            return validValues;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context710.methodEnd();
        }
    }
}

