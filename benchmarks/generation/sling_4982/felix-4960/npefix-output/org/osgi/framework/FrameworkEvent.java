package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.EventObject;
import fr.inria.spirals.npefix.resi.CallChecker;

public class FrameworkEvent extends EventObject {
    static final long serialVersionUID = 207051004521261705L;

    private final Bundle bundle;

    private final Throwable throwable;

    private final int type;

    public static final int STARTED = 1;

    public static final int ERROR = 2;

    public static final int PACKAGES_REFRESHED = 4;

    public static final int STARTLEVEL_CHANGED = 8;

    public static final int WARNING = 16;

    public static final int INFO = 32;

    public static final int STOPPED = 64;

    public static final int STOPPED_UPDATE = 128;

    public static final int STOPPED_BOOTCLASSPATH_MODIFIED = 256;

    public static final int WAIT_TIMEDOUT = 512;

    public FrameworkEvent(int type, Object source) {
        super(source);
        MethodContext _bcornu_methode_context149 = new MethodContext(null);
        try {
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 182, 5199, 5215);
            this.bundle = null;
            CallChecker.varAssign(this.bundle, "this.bundle", 183, 5219, 5237);
            this.throwable = null;
            CallChecker.varAssign(this.throwable, "this.throwable", 184, 5241, 5262);
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public FrameworkEvent(int type, Bundle bundle, Throwable throwable) {
        super(bundle);
        MethodContext _bcornu_methode_context150 = new MethodContext(null);
        try {
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 197, 5626, 5642);
            this.bundle = bundle;
            CallChecker.varAssign(this.bundle, "this.bundle", 198, 5646, 5666);
            this.throwable = throwable;
            CallChecker.varAssign(this.throwable, "this.throwable", 199, 5670, 5696);
        } finally {
            _bcornu_methode_context150.methodEnd();
        }
    }

    public Throwable getThrowable() {
        MethodContext _bcornu_methode_context1492 = new MethodContext(Throwable.class);
        try {
            CallChecker.varInit(this, "this", 207, 5703, 5881);
            CallChecker.varInit(WAIT_TIMEDOUT, "org.osgi.framework.FrameworkEvent.WAIT_TIMEDOUT", 207, 5703, 5881);
            CallChecker.varInit(STOPPED_BOOTCLASSPATH_MODIFIED, "org.osgi.framework.FrameworkEvent.STOPPED_BOOTCLASSPATH_MODIFIED", 207, 5703, 5881);
            CallChecker.varInit(STOPPED_UPDATE, "org.osgi.framework.FrameworkEvent.STOPPED_UPDATE", 207, 5703, 5881);
            CallChecker.varInit(STOPPED, "org.osgi.framework.FrameworkEvent.STOPPED", 207, 5703, 5881);
            CallChecker.varInit(INFO, "org.osgi.framework.FrameworkEvent.INFO", 207, 5703, 5881);
            CallChecker.varInit(WARNING, "org.osgi.framework.FrameworkEvent.WARNING", 207, 5703, 5881);
            CallChecker.varInit(STARTLEVEL_CHANGED, "org.osgi.framework.FrameworkEvent.STARTLEVEL_CHANGED", 207, 5703, 5881);
            CallChecker.varInit(PACKAGES_REFRESHED, "org.osgi.framework.FrameworkEvent.PACKAGES_REFRESHED", 207, 5703, 5881);
            CallChecker.varInit(ERROR, "org.osgi.framework.FrameworkEvent.ERROR", 207, 5703, 5881);
            CallChecker.varInit(STARTED, "org.osgi.framework.FrameworkEvent.STARTED", 207, 5703, 5881);
            CallChecker.varInit(this.type, "type", 207, 5703, 5881);
            CallChecker.varInit(this.throwable, "throwable", 207, 5703, 5881);
            CallChecker.varInit(this.bundle, "bundle", 207, 5703, 5881);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.FrameworkEvent.serialVersionUID", 207, 5703, 5881);
            return throwable;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Throwable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1492.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context1493 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 217, 5885, 6095);
            CallChecker.varInit(WAIT_TIMEDOUT, "org.osgi.framework.FrameworkEvent.WAIT_TIMEDOUT", 217, 5885, 6095);
            CallChecker.varInit(STOPPED_BOOTCLASSPATH_MODIFIED, "org.osgi.framework.FrameworkEvent.STOPPED_BOOTCLASSPATH_MODIFIED", 217, 5885, 6095);
            CallChecker.varInit(STOPPED_UPDATE, "org.osgi.framework.FrameworkEvent.STOPPED_UPDATE", 217, 5885, 6095);
            CallChecker.varInit(STOPPED, "org.osgi.framework.FrameworkEvent.STOPPED", 217, 5885, 6095);
            CallChecker.varInit(INFO, "org.osgi.framework.FrameworkEvent.INFO", 217, 5885, 6095);
            CallChecker.varInit(WARNING, "org.osgi.framework.FrameworkEvent.WARNING", 217, 5885, 6095);
            CallChecker.varInit(STARTLEVEL_CHANGED, "org.osgi.framework.FrameworkEvent.STARTLEVEL_CHANGED", 217, 5885, 6095);
            CallChecker.varInit(PACKAGES_REFRESHED, "org.osgi.framework.FrameworkEvent.PACKAGES_REFRESHED", 217, 5885, 6095);
            CallChecker.varInit(ERROR, "org.osgi.framework.FrameworkEvent.ERROR", 217, 5885, 6095);
            CallChecker.varInit(STARTED, "org.osgi.framework.FrameworkEvent.STARTED", 217, 5885, 6095);
            CallChecker.varInit(this.type, "type", 217, 5885, 6095);
            CallChecker.varInit(this.throwable, "throwable", 217, 5885, 6095);
            CallChecker.varInit(this.bundle, "bundle", 217, 5885, 6095);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.FrameworkEvent.serialVersionUID", 217, 5885, 6095);
            return bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1493.methodEnd();
        }
    }

    public int getType() {
        MethodContext _bcornu_methode_context1494 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 241, 6099, 6638);
            CallChecker.varInit(WAIT_TIMEDOUT, "org.osgi.framework.FrameworkEvent.WAIT_TIMEDOUT", 241, 6099, 6638);
            CallChecker.varInit(STOPPED_BOOTCLASSPATH_MODIFIED, "org.osgi.framework.FrameworkEvent.STOPPED_BOOTCLASSPATH_MODIFIED", 241, 6099, 6638);
            CallChecker.varInit(STOPPED_UPDATE, "org.osgi.framework.FrameworkEvent.STOPPED_UPDATE", 241, 6099, 6638);
            CallChecker.varInit(STOPPED, "org.osgi.framework.FrameworkEvent.STOPPED", 241, 6099, 6638);
            CallChecker.varInit(INFO, "org.osgi.framework.FrameworkEvent.INFO", 241, 6099, 6638);
            CallChecker.varInit(WARNING, "org.osgi.framework.FrameworkEvent.WARNING", 241, 6099, 6638);
            CallChecker.varInit(STARTLEVEL_CHANGED, "org.osgi.framework.FrameworkEvent.STARTLEVEL_CHANGED", 241, 6099, 6638);
            CallChecker.varInit(PACKAGES_REFRESHED, "org.osgi.framework.FrameworkEvent.PACKAGES_REFRESHED", 241, 6099, 6638);
            CallChecker.varInit(ERROR, "org.osgi.framework.FrameworkEvent.ERROR", 241, 6099, 6638);
            CallChecker.varInit(STARTED, "org.osgi.framework.FrameworkEvent.STARTED", 241, 6099, 6638);
            CallChecker.varInit(this.type, "type", 241, 6099, 6638);
            CallChecker.varInit(this.throwable, "throwable", 241, 6099, 6638);
            CallChecker.varInit(this.bundle, "bundle", 241, 6099, 6638);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.FrameworkEvent.serialVersionUID", 241, 6099, 6638);
            return type;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1494.methodEnd();
        }
    }
}

