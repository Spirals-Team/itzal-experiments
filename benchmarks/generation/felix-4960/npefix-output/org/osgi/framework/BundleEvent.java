package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.EventObject;
import fr.inria.spirals.npefix.resi.CallChecker;

public class BundleEvent extends EventObject {
    static final long serialVersionUID = 4080640865971756012L;

    private final Bundle bundle;

    private final int type;

    public static final int INSTALLED = 1;

    public static final int STARTED = 2;

    public static final int STOPPED = 4;

    public static final int UPDATED = 8;

    public static final int UNINSTALLED = 16;

    public static final int RESOLVED = 32;

    public static final int UNRESOLVED = 64;

    public static final int STARTING = 128;

    public static final int STOPPING = 256;

    public static final int LAZY_ACTIVATION = 512;

    private final Bundle origin;

    public BundleEvent(int type, Bundle bundle, Bundle origin) {
        super(bundle);
        MethodContext _bcornu_methode_context16 = new MethodContext(null);
        try {
            if (origin == null) {
                throw new IllegalArgumentException("null origin");
            }
            this.bundle = bundle;
            CallChecker.varAssign(this.bundle, "this.bundle", 172, 4919, 4939);
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 173, 4943, 4959);
            this.origin = origin;
            CallChecker.varAssign(this.origin, "this.origin", 174, 4963, 4983);
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public BundleEvent(int type, Bundle bundle) {
        super(bundle);
        MethodContext _bcornu_methode_context17 = new MethodContext(null);
        try {
            this.bundle = bundle;
            CallChecker.varAssign(this.bundle, "this.bundle", 186, 5270, 5290);
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 187, 5294, 5310);
            this.origin = bundle;
            CallChecker.varAssign(this.origin, "this.origin", 188, 5314, 5334);
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context203 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 197, 5341, 5564);
            CallChecker.varInit(this.origin, "origin", 197, 5341, 5564);
            CallChecker.varInit(LAZY_ACTIVATION, "org.osgi.framework.BundleEvent.LAZY_ACTIVATION", 197, 5341, 5564);
            CallChecker.varInit(STOPPING, "org.osgi.framework.BundleEvent.STOPPING", 197, 5341, 5564);
            CallChecker.varInit(STARTING, "org.osgi.framework.BundleEvent.STARTING", 197, 5341, 5564);
            CallChecker.varInit(UNRESOLVED, "org.osgi.framework.BundleEvent.UNRESOLVED", 197, 5341, 5564);
            CallChecker.varInit(RESOLVED, "org.osgi.framework.BundleEvent.RESOLVED", 197, 5341, 5564);
            CallChecker.varInit(UNINSTALLED, "org.osgi.framework.BundleEvent.UNINSTALLED", 197, 5341, 5564);
            CallChecker.varInit(UPDATED, "org.osgi.framework.BundleEvent.UPDATED", 197, 5341, 5564);
            CallChecker.varInit(STOPPED, "org.osgi.framework.BundleEvent.STOPPED", 197, 5341, 5564);
            CallChecker.varInit(STARTED, "org.osgi.framework.BundleEvent.STARTED", 197, 5341, 5564);
            CallChecker.varInit(INSTALLED, "org.osgi.framework.BundleEvent.INSTALLED", 197, 5341, 5564);
            CallChecker.varInit(this.type, "type", 197, 5341, 5564);
            CallChecker.varInit(this.bundle, "bundle", 197, 5341, 5564);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundleEvent.serialVersionUID", 197, 5341, 5564);
            return bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context203.methodEnd();
        }
    }

    public int getType() {
        MethodContext _bcornu_methode_context204 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 218, 5568, 6063);
            CallChecker.varInit(this.origin, "origin", 218, 5568, 6063);
            CallChecker.varInit(LAZY_ACTIVATION, "org.osgi.framework.BundleEvent.LAZY_ACTIVATION", 218, 5568, 6063);
            CallChecker.varInit(STOPPING, "org.osgi.framework.BundleEvent.STOPPING", 218, 5568, 6063);
            CallChecker.varInit(STARTING, "org.osgi.framework.BundleEvent.STARTING", 218, 5568, 6063);
            CallChecker.varInit(UNRESOLVED, "org.osgi.framework.BundleEvent.UNRESOLVED", 218, 5568, 6063);
            CallChecker.varInit(RESOLVED, "org.osgi.framework.BundleEvent.RESOLVED", 218, 5568, 6063);
            CallChecker.varInit(UNINSTALLED, "org.osgi.framework.BundleEvent.UNINSTALLED", 218, 5568, 6063);
            CallChecker.varInit(UPDATED, "org.osgi.framework.BundleEvent.UPDATED", 218, 5568, 6063);
            CallChecker.varInit(STOPPED, "org.osgi.framework.BundleEvent.STOPPED", 218, 5568, 6063);
            CallChecker.varInit(STARTED, "org.osgi.framework.BundleEvent.STARTED", 218, 5568, 6063);
            CallChecker.varInit(INSTALLED, "org.osgi.framework.BundleEvent.INSTALLED", 218, 5568, 6063);
            CallChecker.varInit(this.type, "type", 218, 5568, 6063);
            CallChecker.varInit(this.bundle, "bundle", 218, 5568, 6063);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundleEvent.serialVersionUID", 218, 5568, 6063);
            return type;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context204.methodEnd();
        }
    }

    public Bundle getOrigin() {
        MethodContext _bcornu_methode_context205 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 232, 6067, 6417);
            CallChecker.varInit(this.origin, "origin", 232, 6067, 6417);
            CallChecker.varInit(LAZY_ACTIVATION, "org.osgi.framework.BundleEvent.LAZY_ACTIVATION", 232, 6067, 6417);
            CallChecker.varInit(STOPPING, "org.osgi.framework.BundleEvent.STOPPING", 232, 6067, 6417);
            CallChecker.varInit(STARTING, "org.osgi.framework.BundleEvent.STARTING", 232, 6067, 6417);
            CallChecker.varInit(UNRESOLVED, "org.osgi.framework.BundleEvent.UNRESOLVED", 232, 6067, 6417);
            CallChecker.varInit(RESOLVED, "org.osgi.framework.BundleEvent.RESOLVED", 232, 6067, 6417);
            CallChecker.varInit(UNINSTALLED, "org.osgi.framework.BundleEvent.UNINSTALLED", 232, 6067, 6417);
            CallChecker.varInit(UPDATED, "org.osgi.framework.BundleEvent.UPDATED", 232, 6067, 6417);
            CallChecker.varInit(STOPPED, "org.osgi.framework.BundleEvent.STOPPED", 232, 6067, 6417);
            CallChecker.varInit(STARTED, "org.osgi.framework.BundleEvent.STARTED", 232, 6067, 6417);
            CallChecker.varInit(INSTALLED, "org.osgi.framework.BundleEvent.INSTALLED", 232, 6067, 6417);
            CallChecker.varInit(this.type, "type", 232, 6067, 6417);
            CallChecker.varInit(this.bundle, "bundle", 232, 6067, 6417);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundleEvent.serialVersionUID", 232, 6067, 6417);
            return origin;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context205.methodEnd();
        }
    }
}

