package org.osgi.framework.hooks.weaving;

import fr.inria.spirals.npefix.resi.context.MethodContext;

public class WeavingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public WeavingException(String msg, Throwable cause) {
        super(msg, cause);
        MethodContext _bcornu_methode_context43 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public WeavingException(String msg) {
        super(msg);
        MethodContext _bcornu_methode_context44 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }
}

