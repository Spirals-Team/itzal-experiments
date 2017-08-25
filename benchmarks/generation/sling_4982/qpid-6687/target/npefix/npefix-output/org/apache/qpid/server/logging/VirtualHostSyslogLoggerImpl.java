package org.apache.qpid.server.logging;

import ch.qos.logback.classic.net.SyslogAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;
import org.apache.qpid.server.model.VirtualHost;

public class VirtualHostSyslogLoggerImpl extends AbstractVirtualHostLogger<VirtualHostSyslogLoggerImpl> implements VirtualHostSyslogLogger<VirtualHostSyslogLoggerImpl> {
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
    protected VirtualHostSyslogLoggerImpl(final Map<String, Object> attributes, VirtualHost<?, ?, ?> virtualHost) {
        super(attributes, virtualHost);
        MethodContext _bcornu_methode_context31 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    @Override
    public String getSyslogHost() {
        MethodContext _bcornu_methode_context468 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 53, 1909, 1991);
            CallChecker.varInit(this.TYPE, "TYPE", 53, 1909, 1991);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 53, 1909, 1991);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 53, 1909, 1991);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 53, 1909, 1991);
            CallChecker.varInit(this._port, "_port", 53, 1909, 1991);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 53, 1909, 1991);
            return _syslogHost;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context468.methodEnd();
        }
    }

    @Override
    public int getPort() {
        MethodContext _bcornu_methode_context469 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 59, 1998, 2065);
            CallChecker.varInit(this.TYPE, "TYPE", 59, 1998, 2065);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 59, 1998, 2065);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 59, 1998, 2065);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 59, 1998, 2065);
            CallChecker.varInit(this._port, "_port", 59, 1998, 2065);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 59, 1998, 2065);
            return _port;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context469.methodEnd();
        }
    }

    @Override
    public String getSuffixPattern() {
        MethodContext _bcornu_methode_context470 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 65, 2072, 2160);
            CallChecker.varInit(this.TYPE, "TYPE", 65, 2072, 2160);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 65, 2072, 2160);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 65, 2072, 2160);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 65, 2072, 2160);
            CallChecker.varInit(this._port, "_port", 65, 2072, 2160);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 65, 2072, 2160);
            return _suffixPattern;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context470.methodEnd();
        }
    }

    @Override
    public String getStackTracePattern() {
        MethodContext _bcornu_methode_context471 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 71, 2167, 2263);
            CallChecker.varInit(this.TYPE, "TYPE", 71, 2167, 2263);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 71, 2167, 2263);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 71, 2167, 2263);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 71, 2167, 2263);
            CallChecker.varInit(this._port, "_port", 71, 2167, 2263);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 71, 2167, 2263);
            return _stackTracePattern;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context471.methodEnd();
        }
    }

    @Override
    public boolean isThrowableExcluded() {
        MethodContext _bcornu_methode_context472 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2270, 2366);
            CallChecker.varInit(this.TYPE, "TYPE", 77, 2270, 2366);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 77, 2270, 2366);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 77, 2270, 2366);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 77, 2270, 2366);
            CallChecker.varInit(this._port, "_port", 77, 2270, 2366);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 77, 2270, 2366);
            return _throwableExcluded;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context472.methodEnd();
        }
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context context) {
        MethodContext _bcornu_methode_context473 = new MethodContext(Appender.class);
        try {
            CallChecker.varInit(this, "this", 83, 2373, 2885);
            CallChecker.varInit(context, "context", 83, 2373, 2885);
            CallChecker.varInit(this.TYPE, "TYPE", 83, 2373, 2885);
            CallChecker.varInit(this._throwableExcluded, "_throwableExcluded", 83, 2373, 2885);
            CallChecker.varInit(this._stackTracePattern, "_stackTracePattern", 83, 2373, 2885);
            CallChecker.varInit(this._suffixPattern, "_suffixPattern", 83, 2373, 2885);
            CallChecker.varInit(this._port, "_port", 83, 2373, 2885);
            CallChecker.varInit(this._syslogHost, "_syslogHost", 83, 2373, 2885);
            SyslogAppender syslogAppender = CallChecker.varInit(new SyslogAppender(), "syslogAppender", 85, 2475, 2527);
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 86, 2537, 2550)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 86, 2537, 2550);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 86, 2537, 2550).setSyslogHost(_syslogHost);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 87, 2588, 2601)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 87, 2588, 2601);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 87, 2588, 2601).setPort(_port);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 88, 2627, 2640)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 88, 2627, 2640);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 88, 2627, 2640).setSuffixPattern(_suffixPattern);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 89, 2684, 2697)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 89, 2684, 2697);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 89, 2684, 2697).setStackTracePattern(_stackTracePattern);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 90, 2749, 2762)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 90, 2749, 2762);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 90, 2749, 2762).setThrowableExcluded(_throwableExcluded);
            }
            if (CallChecker.beforeDeref(syslogAppender, SyslogAppender.class, 91, 2814, 2827)) {
                syslogAppender = CallChecker.beforeCalled(syslogAppender, SyslogAppender.class, 91, 2814, 2827);
                CallChecker.isCalled(syslogAppender, SyslogAppender.class, 91, 2814, 2827).setFacility("USER");
            }
            return syslogAppender;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Appender<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context473.methodEnd();
        }
    }
}

