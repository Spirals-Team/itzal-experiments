package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.qpid.server.configuration.BrokerProperties;

public class StartupAppender extends AppenderBase<ILoggingEvent> {
    private List<ILoggingEvent> _accumulatedLoggingEvents = new ArrayList<>();

    private Level _consoleAppenderAcceptLogLevel = Level.INFO;

    public StartupAppender() {
        super();
        MethodContext _bcornu_methode_context34 = new MethodContext(null);
        try {
            setName(StartupAppender.class.getName());
            String overriddenLogLevel = CallChecker.varInit(System.getProperty(BrokerProperties.PROPERTY_STARTUP_FAILOVER_CONSOLE_LOG_LEVEL), "overriddenLogLevel", 46, 1681, 1789);
            if (overriddenLogLevel != null) {
                _consoleAppenderAcceptLogLevel = Level.valueOf(overriddenLogLevel);
                CallChecker.varAssign(this._consoleAppenderAcceptLogLevel, "this._consoleAppenderAcceptLogLevel", 49, 1853, 1919);
            }
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    @Override
    protected synchronized void append(ILoggingEvent e) {
        MethodContext _bcornu_methode_context520 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 54, 1942, 2060);
            CallChecker.varInit(e, "e", 54, 1942, 2060);
            CallChecker.varInit(this._consoleAppenderAcceptLogLevel, "_consoleAppenderAcceptLogLevel", 54, 1942, 2060);
            CallChecker.varInit(this._accumulatedLoggingEvents, "_accumulatedLoggingEvents", 54, 1942, 2060);
            if (CallChecker.beforeDeref(_accumulatedLoggingEvents, List.class, 56, 2022, 2046)) {
                _accumulatedLoggingEvents = CallChecker.beforeCalled(_accumulatedLoggingEvents, List.class, 56, 2022, 2046);
                CallChecker.isCalled(_accumulatedLoggingEvents, List.class, 56, 2022, 2046).add(e);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context520.methodEnd();
        }
    }

    public synchronized void replayAccumulatedEvents(Appender<ILoggingEvent> appender) {
        MethodContext _bcornu_methode_context521 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 59, 2067, 2279);
            CallChecker.varInit(appender, "appender", 59, 2067, 2279);
            CallChecker.varInit(this._consoleAppenderAcceptLogLevel, "_consoleAppenderAcceptLogLevel", 59, 2067, 2279);
            CallChecker.varInit(this._accumulatedLoggingEvents, "_accumulatedLoggingEvents", 59, 2067, 2279);
            if (CallChecker.beforeDeref(_accumulatedLoggingEvents, void.class, 61, 2190, 2214)) {
                for (ILoggingEvent event : _accumulatedLoggingEvents) {
                    if (CallChecker.beforeDeref(appender, Appender.class, 63, 2239, 2246)) {
                        appender = CallChecker.beforeCalled(appender, Appender.class, 63, 2239, 2246);
                        CallChecker.isCalled(appender, Appender.class, 63, 2239, 2246).doAppend(event);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context521.methodEnd();
        }
    }

    public void logToConsole() {
        MethodContext _bcornu_methode_context523 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 67, 2286, 3349);
            CallChecker.varInit(this._consoleAppenderAcceptLogLevel, "_consoleAppenderAcceptLogLevel", 67, 2286, 3349);
            CallChecker.varInit(this._accumulatedLoggingEvents, "_accumulatedLoggingEvents", 67, 2286, 3349);
            Context context = CallChecker.varInit(getContext(), "context", 69, 2327, 2357);
            ConsoleAppender<ILoggingEvent> consoleAppender = CallChecker.varInit(new ConsoleAppender<>(), "consoleAppender", 70, 2367, 2439);
            if (CallChecker.beforeDeref(consoleAppender, ConsoleAppender.class, 71, 2449, 2463)) {
                consoleAppender = CallChecker.beforeCalled(consoleAppender, ConsoleAppender.class, 71, 2449, 2463);
                CallChecker.isCalled(consoleAppender, ConsoleAppender.class, 71, 2449, 2463).setContext(context);
            }
            PatternLayoutEncoder patternLayoutEncoder = CallChecker.varInit(new PatternLayoutEncoder(), "patternLayoutEncoder", 72, 2494, 2564);
            if (CallChecker.beforeDeref(patternLayoutEncoder, PatternLayoutEncoder.class, 73, 2574, 2593)) {
                patternLayoutEncoder = CallChecker.beforeCalled(patternLayoutEncoder, PatternLayoutEncoder.class, 73, 2574, 2593);
                CallChecker.isCalled(patternLayoutEncoder, PatternLayoutEncoder.class, 73, 2574, 2593).setContext(context);
            }
            if (CallChecker.beforeDeref(patternLayoutEncoder, PatternLayoutEncoder.class, 76, 2691, 2710)) {
                patternLayoutEncoder = CallChecker.beforeCalled(patternLayoutEncoder, PatternLayoutEncoder.class, 76, 2691, 2710);
                CallChecker.isCalled(patternLayoutEncoder, PatternLayoutEncoder.class, 76, 2691, 2710).setPattern("%X{qpid.log.prefix}%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
            }
            if (CallChecker.beforeDeref(patternLayoutEncoder, PatternLayoutEncoder.class, 77, 2811, 2830)) {
                patternLayoutEncoder = CallChecker.beforeCalled(patternLayoutEncoder, PatternLayoutEncoder.class, 77, 2811, 2830);
                CallChecker.isCalled(patternLayoutEncoder, PatternLayoutEncoder.class, 77, 2811, 2830).start();
            }
            if (CallChecker.beforeDeref(consoleAppender, ConsoleAppender.class, 79, 2850, 2864)) {
                consoleAppender = CallChecker.beforeCalled(consoleAppender, ConsoleAppender.class, 79, 2850, 2864);
                CallChecker.isCalled(consoleAppender, ConsoleAppender.class, 79, 2850, 2864).addFilter(new Filter<ILoggingEvent>() {
                    @Override
                    public FilterReply decide(final ILoggingEvent event) {
                        MethodContext _bcornu_methode_context522 = new MethodContext(FilterReply.class);
                        try {
                            CallChecker.varInit(this, "this", 82, 2926, 3157);
                            CallChecker.varInit(event, "event", 82, 2926, 3157);
                            if (CallChecker.beforeDeref(event, ILoggingEvent.class, 84, 3038, 3042)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(event, ILoggingEvent.class, 84, 3038, 3042).getLevel(), Level.class, 84, 3038, 3053)) {
                                    if (CallChecker.isCalled(CallChecker.isCalled(event, ILoggingEvent.class, 84, 3038, 3042).getLevel(), Level.class, 84, 3038, 3053).isGreaterOrEqual(_consoleAppenderAcceptLogLevel)) {
                                        return FilterReply.ACCEPT;
                                    }else {
                                        return FilterReply.DENY;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context522.methodEnd();
                        }
                    }
                });
            }
            if (CallChecker.beforeDeref(consoleAppender, ConsoleAppender.class, 88, 3180, 3194)) {
                consoleAppender = CallChecker.beforeCalled(consoleAppender, ConsoleAppender.class, 88, 3180, 3194);
                CallChecker.isCalled(consoleAppender, ConsoleAppender.class, 88, 3180, 3194).setEncoder(patternLayoutEncoder);
            }
            if (CallChecker.beforeDeref(consoleAppender, ConsoleAppender.class, 89, 3238, 3252)) {
                consoleAppender = CallChecker.beforeCalled(consoleAppender, ConsoleAppender.class, 89, 3238, 3252);
                CallChecker.isCalled(consoleAppender, ConsoleAppender.class, 89, 3238, 3252).start();
            }
            replayAccumulatedEvents(consoleAppender);
            if (CallChecker.beforeDeref(consoleAppender, ConsoleAppender.class, 91, 3321, 3335)) {
                consoleAppender = CallChecker.beforeCalled(consoleAppender, ConsoleAppender.class, 91, 3321, 3335);
                CallChecker.isCalled(consoleAppender, ConsoleAppender.class, 91, 3321, 3335).stop();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context523.methodEnd();
        }
    }

    @Override
    public void stop() {
        MethodContext _bcornu_methode_context524 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 95, 3356, 3516);
            CallChecker.varInit(this._consoleAppenderAcceptLogLevel, "_consoleAppenderAcceptLogLevel", 95, 3356, 3516);
            CallChecker.varInit(this._accumulatedLoggingEvents, "_accumulatedLoggingEvents", 95, 3356, 3516);
            super.stop();
            synchronized(this) {
                if (CallChecker.beforeDeref(_accumulatedLoggingEvents, List.class, 100, 3467, 3491)) {
                    _accumulatedLoggingEvents = CallChecker.beforeCalled(_accumulatedLoggingEvents, List.class, 100, 3467, 3491);
                    CallChecker.isCalled(_accumulatedLoggingEvents, List.class, 100, 3467, 3491).clear();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context524.methodEnd();
        }
    }
}

