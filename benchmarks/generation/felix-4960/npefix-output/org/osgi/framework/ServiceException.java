package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ServiceException extends RuntimeException {
    static final long serialVersionUID = 3038963223712959631L;

    private final int type;

    public static final int UNSPECIFIED = 0;

    public static final int UNREGISTERED = 1;

    public static final int FACTORY_ERROR = 2;

    public static final int FACTORY_EXCEPTION = 3;

    public static final int SUBCLASSED = 4;

    public static final int REMOTE = 5;

    public static final int FACTORY_RECURSION = 6;

    public static final int ASYNC_ERROR = 7;

    public ServiceException(String msg, Throwable cause) {
        this(msg, ServiceException.UNSPECIFIED, cause);
        MethodContext _bcornu_methode_context105 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context105.methodEnd();
        }
    }

    public ServiceException(String msg) {
        this(msg, ServiceException.UNSPECIFIED);
        MethodContext _bcornu_methode_context106 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context106.methodEnd();
        }
    }

    public ServiceException(String msg, int type, Throwable cause) {
        super(msg, cause);
        MethodContext _bcornu_methode_context107 = new MethodContext(null);
        try {
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 114, 3339, 3355);
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    public ServiceException(String msg, int type) {
        super(msg);
        MethodContext _bcornu_methode_context108 = new MethodContext(null);
        try {
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 125, 3590, 3606);
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public int getType() {
        MethodContext _bcornu_methode_context1046 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 134, 3613, 3814);
            CallChecker.varInit(ASYNC_ERROR, "org.osgi.framework.ServiceException.ASYNC_ERROR", 134, 3613, 3814);
            CallChecker.varInit(FACTORY_RECURSION, "org.osgi.framework.ServiceException.FACTORY_RECURSION", 134, 3613, 3814);
            CallChecker.varInit(REMOTE, "org.osgi.framework.ServiceException.REMOTE", 134, 3613, 3814);
            CallChecker.varInit(SUBCLASSED, "org.osgi.framework.ServiceException.SUBCLASSED", 134, 3613, 3814);
            CallChecker.varInit(FACTORY_EXCEPTION, "org.osgi.framework.ServiceException.FACTORY_EXCEPTION", 134, 3613, 3814);
            CallChecker.varInit(FACTORY_ERROR, "org.osgi.framework.ServiceException.FACTORY_ERROR", 134, 3613, 3814);
            CallChecker.varInit(UNREGISTERED, "org.osgi.framework.ServiceException.UNREGISTERED", 134, 3613, 3814);
            CallChecker.varInit(UNSPECIFIED, "org.osgi.framework.ServiceException.UNSPECIFIED", 134, 3613, 3814);
            CallChecker.varInit(this.type, "type", 134, 3613, 3814);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServiceException.serialVersionUID", 134, 3613, 3814);
            return type;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1046.methodEnd();
        }
    }
}

