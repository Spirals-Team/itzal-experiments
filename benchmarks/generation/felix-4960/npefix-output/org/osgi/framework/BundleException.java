package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class BundleException extends Exception {
    static final long serialVersionUID = 3571095144220455665L;

    private final int type;

    public static final int UNSPECIFIED = 0;

    public static final int UNSUPPORTED_OPERATION = 1;

    public static final int INVALID_OPERATION = 2;

    public static final int MANIFEST_ERROR = 3;

    public static final int RESOLVE_ERROR = 4;

    public static final int ACTIVATOR_ERROR = 5;

    public static final int SECURITY_ERROR = 6;

    public static final int STATECHANGE_ERROR = 7;

    public static final int NATIVECODE_ERROR = 8;

    public static final int DUPLICATE_BUNDLE_ERROR = 9;

    public static final int START_TRANSIENT_ERROR = 10;

    public static final int READ_ERROR = 11;

    public static final int REJECTED_BY_HOOK = 12;

    public BundleException(String msg, Throwable cause) {
        this(msg, BundleException.UNSPECIFIED, cause);
        MethodContext _bcornu_methode_context75 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }

    public BundleException(String msg) {
        this(msg, BundleException.UNSPECIFIED);
        MethodContext _bcornu_methode_context76 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    public BundleException(String msg, int type, Throwable cause) {
        super(msg, cause);
        MethodContext _bcornu_methode_context77 = new MethodContext(null);
        try {
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 170, 4405, 4421);
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    public BundleException(String msg, int type) {
        super(msg);
        MethodContext _bcornu_methode_context78 = new MethodContext(null);
        try {
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 182, 4669, 4685);
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    public Throwable getNestedException() {
        MethodContext _bcornu_methode_context848 = new MethodContext(Throwable.class);
        try {
            CallChecker.varInit(this, "this", 196, 4692, 5126);
            CallChecker.varInit(REJECTED_BY_HOOK, "org.osgi.framework.BundleException.REJECTED_BY_HOOK", 196, 4692, 5126);
            CallChecker.varInit(READ_ERROR, "org.osgi.framework.BundleException.READ_ERROR", 196, 4692, 5126);
            CallChecker.varInit(START_TRANSIENT_ERROR, "org.osgi.framework.BundleException.START_TRANSIENT_ERROR", 196, 4692, 5126);
            CallChecker.varInit(DUPLICATE_BUNDLE_ERROR, "org.osgi.framework.BundleException.DUPLICATE_BUNDLE_ERROR", 196, 4692, 5126);
            CallChecker.varInit(NATIVECODE_ERROR, "org.osgi.framework.BundleException.NATIVECODE_ERROR", 196, 4692, 5126);
            CallChecker.varInit(STATECHANGE_ERROR, "org.osgi.framework.BundleException.STATECHANGE_ERROR", 196, 4692, 5126);
            CallChecker.varInit(SECURITY_ERROR, "org.osgi.framework.BundleException.SECURITY_ERROR", 196, 4692, 5126);
            CallChecker.varInit(ACTIVATOR_ERROR, "org.osgi.framework.BundleException.ACTIVATOR_ERROR", 196, 4692, 5126);
            CallChecker.varInit(RESOLVE_ERROR, "org.osgi.framework.BundleException.RESOLVE_ERROR", 196, 4692, 5126);
            CallChecker.varInit(MANIFEST_ERROR, "org.osgi.framework.BundleException.MANIFEST_ERROR", 196, 4692, 5126);
            CallChecker.varInit(INVALID_OPERATION, "org.osgi.framework.BundleException.INVALID_OPERATION", 196, 4692, 5126);
            CallChecker.varInit(UNSUPPORTED_OPERATION, "org.osgi.framework.BundleException.UNSUPPORTED_OPERATION", 196, 4692, 5126);
            CallChecker.varInit(UNSPECIFIED, "org.osgi.framework.BundleException.UNSPECIFIED", 196, 4692, 5126);
            CallChecker.varInit(this.type, "type", 196, 4692, 5126);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundleException.serialVersionUID", 196, 4692, 5126);
            return getCause();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Throwable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context848.methodEnd();
        }
    }

    @Override
    public Throwable getCause() {
        MethodContext _bcornu_methode_context849 = new MethodContext(Throwable.class);
        try {
            CallChecker.varInit(this, "this", 207, 5130, 5383);
            CallChecker.varInit(REJECTED_BY_HOOK, "org.osgi.framework.BundleException.REJECTED_BY_HOOK", 207, 5130, 5383);
            CallChecker.varInit(READ_ERROR, "org.osgi.framework.BundleException.READ_ERROR", 207, 5130, 5383);
            CallChecker.varInit(START_TRANSIENT_ERROR, "org.osgi.framework.BundleException.START_TRANSIENT_ERROR", 207, 5130, 5383);
            CallChecker.varInit(DUPLICATE_BUNDLE_ERROR, "org.osgi.framework.BundleException.DUPLICATE_BUNDLE_ERROR", 207, 5130, 5383);
            CallChecker.varInit(NATIVECODE_ERROR, "org.osgi.framework.BundleException.NATIVECODE_ERROR", 207, 5130, 5383);
            CallChecker.varInit(STATECHANGE_ERROR, "org.osgi.framework.BundleException.STATECHANGE_ERROR", 207, 5130, 5383);
            CallChecker.varInit(SECURITY_ERROR, "org.osgi.framework.BundleException.SECURITY_ERROR", 207, 5130, 5383);
            CallChecker.varInit(ACTIVATOR_ERROR, "org.osgi.framework.BundleException.ACTIVATOR_ERROR", 207, 5130, 5383);
            CallChecker.varInit(RESOLVE_ERROR, "org.osgi.framework.BundleException.RESOLVE_ERROR", 207, 5130, 5383);
            CallChecker.varInit(MANIFEST_ERROR, "org.osgi.framework.BundleException.MANIFEST_ERROR", 207, 5130, 5383);
            CallChecker.varInit(INVALID_OPERATION, "org.osgi.framework.BundleException.INVALID_OPERATION", 207, 5130, 5383);
            CallChecker.varInit(UNSUPPORTED_OPERATION, "org.osgi.framework.BundleException.UNSUPPORTED_OPERATION", 207, 5130, 5383);
            CallChecker.varInit(UNSPECIFIED, "org.osgi.framework.BundleException.UNSPECIFIED", 207, 5130, 5383);
            CallChecker.varInit(this.type, "type", 207, 5130, 5383);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundleException.serialVersionUID", 207, 5130, 5383);
            return super.getCause();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Throwable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context849.methodEnd();
        }
    }

    @Override
    public Throwable initCause(Throwable cause) {
        MethodContext _bcornu_methode_context850 = new MethodContext(Throwable.class);
        try {
            CallChecker.varInit(this, "this", 223, 5387, 5840);
            CallChecker.varInit(cause, "cause", 223, 5387, 5840);
            CallChecker.varInit(REJECTED_BY_HOOK, "org.osgi.framework.BundleException.REJECTED_BY_HOOK", 223, 5387, 5840);
            CallChecker.varInit(READ_ERROR, "org.osgi.framework.BundleException.READ_ERROR", 223, 5387, 5840);
            CallChecker.varInit(START_TRANSIENT_ERROR, "org.osgi.framework.BundleException.START_TRANSIENT_ERROR", 223, 5387, 5840);
            CallChecker.varInit(DUPLICATE_BUNDLE_ERROR, "org.osgi.framework.BundleException.DUPLICATE_BUNDLE_ERROR", 223, 5387, 5840);
            CallChecker.varInit(NATIVECODE_ERROR, "org.osgi.framework.BundleException.NATIVECODE_ERROR", 223, 5387, 5840);
            CallChecker.varInit(STATECHANGE_ERROR, "org.osgi.framework.BundleException.STATECHANGE_ERROR", 223, 5387, 5840);
            CallChecker.varInit(SECURITY_ERROR, "org.osgi.framework.BundleException.SECURITY_ERROR", 223, 5387, 5840);
            CallChecker.varInit(ACTIVATOR_ERROR, "org.osgi.framework.BundleException.ACTIVATOR_ERROR", 223, 5387, 5840);
            CallChecker.varInit(RESOLVE_ERROR, "org.osgi.framework.BundleException.RESOLVE_ERROR", 223, 5387, 5840);
            CallChecker.varInit(MANIFEST_ERROR, "org.osgi.framework.BundleException.MANIFEST_ERROR", 223, 5387, 5840);
            CallChecker.varInit(INVALID_OPERATION, "org.osgi.framework.BundleException.INVALID_OPERATION", 223, 5387, 5840);
            CallChecker.varInit(UNSUPPORTED_OPERATION, "org.osgi.framework.BundleException.UNSUPPORTED_OPERATION", 223, 5387, 5840);
            CallChecker.varInit(UNSPECIFIED, "org.osgi.framework.BundleException.UNSPECIFIED", 223, 5387, 5840);
            CallChecker.varInit(this.type, "type", 223, 5387, 5840);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundleException.serialVersionUID", 223, 5387, 5840);
            return super.initCause(cause);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Throwable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context850.methodEnd();
        }
    }

    public int getType() {
        MethodContext _bcornu_methode_context851 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 234, 5844, 6060);
            CallChecker.varInit(REJECTED_BY_HOOK, "org.osgi.framework.BundleException.REJECTED_BY_HOOK", 234, 5844, 6060);
            CallChecker.varInit(READ_ERROR, "org.osgi.framework.BundleException.READ_ERROR", 234, 5844, 6060);
            CallChecker.varInit(START_TRANSIENT_ERROR, "org.osgi.framework.BundleException.START_TRANSIENT_ERROR", 234, 5844, 6060);
            CallChecker.varInit(DUPLICATE_BUNDLE_ERROR, "org.osgi.framework.BundleException.DUPLICATE_BUNDLE_ERROR", 234, 5844, 6060);
            CallChecker.varInit(NATIVECODE_ERROR, "org.osgi.framework.BundleException.NATIVECODE_ERROR", 234, 5844, 6060);
            CallChecker.varInit(STATECHANGE_ERROR, "org.osgi.framework.BundleException.STATECHANGE_ERROR", 234, 5844, 6060);
            CallChecker.varInit(SECURITY_ERROR, "org.osgi.framework.BundleException.SECURITY_ERROR", 234, 5844, 6060);
            CallChecker.varInit(ACTIVATOR_ERROR, "org.osgi.framework.BundleException.ACTIVATOR_ERROR", 234, 5844, 6060);
            CallChecker.varInit(RESOLVE_ERROR, "org.osgi.framework.BundleException.RESOLVE_ERROR", 234, 5844, 6060);
            CallChecker.varInit(MANIFEST_ERROR, "org.osgi.framework.BundleException.MANIFEST_ERROR", 234, 5844, 6060);
            CallChecker.varInit(INVALID_OPERATION, "org.osgi.framework.BundleException.INVALID_OPERATION", 234, 5844, 6060);
            CallChecker.varInit(UNSUPPORTED_OPERATION, "org.osgi.framework.BundleException.UNSUPPORTED_OPERATION", 234, 5844, 6060);
            CallChecker.varInit(UNSPECIFIED, "org.osgi.framework.BundleException.UNSPECIFIED", 234, 5844, 6060);
            CallChecker.varInit(this.type, "type", 234, 5844, 6060);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.BundleException.serialVersionUID", 234, 5844, 6060);
            return type;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context851.methodEnd();
        }
    }
}

