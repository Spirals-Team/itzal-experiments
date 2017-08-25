package org.apache.qpid.server.logging;

import ch.qos.logback.classic.net.SyslogAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;

public class BrokerSyslogLoggerImpl extends AbstractBrokerLogger<BrokerSyslogLoggerImpl> implements BrokerSyslogLogger<BrokerSyslogLoggerImpl> {
    @ManagedAttributeField
    private String _syslogHost;

    @ManagedAttributeField
    private int _port;

    @ManagedAttributeField
    private String _suffixPattern;

    @ManagedAttributeField
    private String _stackTracePattern;

    @ManagedAttributeField
    private boolean _throwableExcluded;

    @ManagedObjectFactoryConstructor
    protected BrokerSyslogLoggerImpl(final Map<String, Object> attributes, Broker<?> broker) {
        super(attributes, broker);
        MethodContext _bcornu_methode_context59 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    @Override
    public String getSyslogHost() {
        MethodContext _bcornu_methode_context823 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 53, 1855, 1937);
            CallChecker.varInit(this.TYPE, "TYPE", 53, 1855, 1937);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 53, 1855, 1937);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 53, 1855, 1937);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 53, 1855, 1937);
            CallChecker.varInit(this._port, "_port", 53, 1855, 1937);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 53, 1855, 1937);
            return _syslogHost;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context823.methodEnd();
        }
    }

    @Override
    public int getPort() {
        MethodContext _bcornu_methode_context824 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 59, 1944, 2011);
            CallChecker.varInit(this.TYPE, "TYPE", 59, 1944, 2011);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 59, 1944, 2011);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 59, 1944, 2011);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 59, 1944, 2011);
            CallChecker.varInit(this._port, "_port", 59, 1944, 2011);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 59, 1944, 2011);
            return _port;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context824.methodEnd();
        }
    }

    @Override
    public String getSuffixPattern() {
        MethodContext _bcornu_methode_context825 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 65, 2018, 2106);
            CallChecker.varInit(this.TYPE, "TYPE", 65, 2018, 2106);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 65, 2018, 2106);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 65, 2018, 2106);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 65, 2018, 2106);
            CallChecker.varInit(this._port, "_port", 65, 2018, 2106);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 65, 2018, 2106);
            return _suffixPattern;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context825.methodEnd();
        }
    }

    @Override
    public String getStackTracePattern() {
        MethodContext _bcornu_methode_context826 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 71, 2113, 2209);
            CallChecker.varInit(this.TYPE, "TYPE", 71, 2113, 2209);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 71, 2113, 2209);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 71, 2113, 2209);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 71, 2113, 2209);
            CallChecker.varInit(this._port, "_port", 71, 2113, 2209);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 71, 2113, 2209);
            return _stackTracePattern;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context826.methodEnd();
        }
    }

    @Override
    public boolean isThrowableExcluded() {
        MethodContext _bcornu_methode_context827 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2216, 2312);
            CallChecker.varInit(this.TYPE, "TYPE", 77, 2216, 2312);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 77, 2216, 2312);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 77, 2216, 2312);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 77, 2216, 2312);
            CallChecker.varInit(this._port, "_port", 77, 2216, 2312);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 77, 2216, 2312);
            return _throwableExcluded;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context827.methodEnd();
        }
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context context) {
        MethodContext _bcornu_methode_context828 = new MethodContext(Appender.class);
        try {
            CallChecker.varInit(this, "this", 83, 2319, 2831);
            CallChecker.varInit(context, "context", 83, 2319, 2831);
            CallChecker.varInit(this.TYPE, "TYPE", 83, 2319, 2831);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 83, 2319, 2831);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 83, 2319, 2831);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 83, 2319, 2831);
            CallChecker.varInit(this._port, "_port", 83, 2319, 2831);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 83, 2319, 2831);
            SyslogAppender syslogAppender = CallChecker.varInit(new SyslogAppender(), "syslogAppender", 85, 2421, 2473);
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 86, 2483, 2496)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 86, 2483, 2496);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 86, 2483, 2496).setSyslogHost(_syslogHost);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 87, 2534, 2547)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 87, 2534, 2547);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 87, 2534, 2547).setPort(_port);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 88, 2573, 2586)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 88, 2573, 2586);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 88, 2573, 2586).setSuffixPattern(_suffixPattern);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 89, 2630, 2643)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 89, 2630, 2643);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 89, 2630, 2643).setStackTracePattern(_stackTracePattern);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 90, 2695, 2708)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 90, 2695, 2708);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 90, 2695, 2708).setThrowableExcluded(_throwableExcluded);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 91, 2760, 2773)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 91, 2760, 2773);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 91, 2760, 2773).setFacility("USER");
            }
            return syslogAppender;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Appender<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context828.methodEnd();
        }
    }
}

