package org.apache.commons.collections;

import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class BufferUnderflowException extends NoSuchElementException {
    private static final long serialVersionUID = 7106567570467436893L;

    public BufferUnderflowException() {
        super();
        MethodContext _bcornu_methode_context125 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    public BufferUnderflowException(String message) {
        super(message);
        MethodContext _bcornu_methode_context126 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context126.methodEnd();
        }
    }

    public BufferUnderflowException(String message, Throwable exception) {
        super(message);
        MethodContext _bcornu_methode_context127 = new MethodContext(null);
        try {
            initCause(exception);
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }
}

