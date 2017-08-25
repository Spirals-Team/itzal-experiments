package org.apache.felix.framework;

import static org.apache.felix.resolver.Logger.LOG_WARNING;
import static org.apache.felix.resolver.Logger.LOG_INFO;
import static org.apache.felix.resolver.Logger.LOG_ERROR;
import static org.apache.felix.resolver.Logger.LOG_DEBUG;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.PrintStream;
import org.osgi.framework.ServiceReference;

public class Logger extends org.apache.felix.resolver.Logger {
    public Logger() {
        super(LOG_ERROR);
        MethodContext _bcornu_methode_context40 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    public final void log(ServiceReference sr, int level, String msg) {
        MethodContext _bcornu_methode_context511 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 45, 1655, 1773);
            CallChecker.varInit(msg, "msg", 45, 1655, 1773);
            CallChecker.varInit(level, "level", 45, 1655, 1773);
            CallChecker.varInit(sr, "sr", 45, 1655, 1773);
            _log(null, sr, level, msg, null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context511.methodEnd();
        }
    }

    public final void log(ServiceReference sr, int level, String msg, Throwable throwable) {
        MethodContext _bcornu_methode_context512 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 50, 1780, 1924);
            CallChecker.varInit(throwable, "throwable", 50, 1780, 1924);
            CallChecker.varInit(msg, "msg", 50, 1780, 1924);
            CallChecker.varInit(level, "level", 50, 1780, 1924);
            CallChecker.varInit(sr, "sr", 50, 1780, 1924);
            _log(null, sr, level, msg, throwable);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context512.methodEnd();
        }
    }

    public final void log(Bundle bundle, int level, String msg) {
        MethodContext _bcornu_methode_context513 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 55, 1931, 2047);
            CallChecker.varInit(msg, "msg", 55, 1931, 2047);
            CallChecker.varInit(level, "level", 55, 1931, 2047);
            CallChecker.varInit(bundle, "bundle", 55, 1931, 2047);
            _log(bundle, null, level, msg, null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context513.methodEnd();
        }
    }

    public final void log(Bundle bundle, int level, String msg, Throwable throwable) {
        MethodContext _bcornu_methode_context514 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 60, 2054, 2196);
            CallChecker.varInit(throwable, "throwable", 60, 2054, 2196);
            CallChecker.varInit(msg, "msg", 60, 2054, 2196);
            CallChecker.varInit(level, "level", 60, 2054, 2196);
            CallChecker.varInit(bundle, "bundle", 60, 2054, 2196);
            _log(bundle, null, level, msg, throwable);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context514.methodEnd();
        }
    }

    protected void doLog(Bundle bundle, ServiceReference sr, int level, String msg, Throwable throwable) {
        MethodContext _bcornu_methode_context515 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 65, 2203, 3617);
            CallChecker.varInit(throwable, "throwable", 65, 2203, 3617);
            CallChecker.varInit(msg, "msg", 65, 2203, 3617);
            CallChecker.varInit(level, "level", 65, 2203, 3617);
            CallChecker.varInit(sr, "sr", 65, 2203, 3617);
            CallChecker.varInit(bundle, "bundle", 65, 2203, 3617);
            String s = CallChecker.varInit("", "s", 69, 2335, 2348);
            if (sr != null) {
                s = ((s + "SvcRef ") + sr) + " ";
                CallChecker.varAssign(s, "s", 72, 2396, 2425);
            }else
                if (bundle != null) {
                    s = ((s + "Bundle ") + (bundle.toString())) + " ";
                    CallChecker.varAssign(s, "s", 76, 2492, 2535);
                }
            
            s = s + msg;
            CallChecker.varAssign(s, "s", 78, 2555, 2566);
            if (throwable != null) {
                s = ((s + " (") + throwable) + ")";
                CallChecker.varAssign(s, "s", 81, 2621, 2651);
            }
            switch (level) {
                case LOG_DEBUG :
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 86, 2740, 2749)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 86, 2740, 2749).println(("DEBUG: " + s));
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case LOG_ERROR :
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 89, 2842, 2851)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 89, 2842, 2851).println(("ERROR: " + s));
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (throwable != null) {
                        if ((throwable instanceof BundleException) && ((((BundleException) (throwable)).getNestedException()) != null)) {
                            throwable = ((BundleException) (throwable)).getNestedException();
                            CallChecker.varAssign(throwable, "throwable", 95, 3132, 3194);
                        }
                        throwable.printStackTrace();
                    }
                    break;
                case LOG_INFO :
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 101, 3351, 3360)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 101, 3351, 3360).println(("INFO: " + s));
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case LOG_WARNING :
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 104, 3454, 3463)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 104, 3454, 3463).println(("WARNING: " + s));
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                default :
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 107, 3551, 3560)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 107, 3551, 3560).println(((("UNKNOWN[" + level) + "]: ") + s));
                    }else
                        throw new AbnormalExecutionError();
                    
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context515.methodEnd();
        }
    }

    private void _log(Bundle bundle, ServiceReference sr, int level, String msg, Throwable throwable) {
        MethodContext _bcornu_methode_context516 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 111, 3624, 3898);
            CallChecker.varInit(throwable, "throwable", 111, 3624, 3898);
            CallChecker.varInit(msg, "msg", 111, 3624, 3898);
            CallChecker.varInit(level, "level", 111, 3624, 3898);
            CallChecker.varInit(sr, "sr", 111, 3624, 3898);
            CallChecker.varInit(bundle, "bundle", 111, 3624, 3898);
            if ((getLogLevel()) >= level) {
                doLog(bundle, sr, level, msg, throwable);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context516.methodEnd();
        }
    }
}

