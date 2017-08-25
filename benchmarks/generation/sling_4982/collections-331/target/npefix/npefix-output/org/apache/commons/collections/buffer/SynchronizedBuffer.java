package org.apache.commons.collections.buffer;

import org.apache.commons.collections.collection.SynchronizedCollection;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Buffer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class SynchronizedBuffer<E> extends SynchronizedCollection<E> implements Buffer<E> {
    private static final long serialVersionUID = -6859936183953626253L;

    public static <T> Buffer<T> decorate(Buffer<T> buffer) {
        MethodContext _bcornu_methode_context2378 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(buffer, "buffer", 51, 1660, 2069);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.SynchronizedBuffer.serialVersionUID", 51, 1660, 2069);
            return new SynchronizedBuffer<T>(buffer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2378.methodEnd();
        }
    }

    protected SynchronizedBuffer(Buffer<E> buffer) {
        super(buffer);
        MethodContext _bcornu_methode_context450 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context450.methodEnd();
        }
    }

    protected SynchronizedBuffer(Buffer<E> buffer, Object lock) {
        super(buffer, lock);
        MethodContext _bcornu_methode_context451 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context451.methodEnd();
        }
    }

    @Override
    protected Buffer<E> decorated() {
        MethodContext _bcornu_methode_context2379 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(this, "this", 83, 2786, 2984);
            CallChecker.varInit(this.lock, "lock", 83, 2786, 2984);
            CallChecker.varInit(this.collection, "collection", 83, 2786, 2984);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.SynchronizedBuffer.serialVersionUID", 83, 2786, 2984);
            return ((Buffer<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2379.methodEnd();
        }
    }

    public E get() {
        synchronized(lock) {
            final Buffer<E> npe_invocation_var440 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var440, Buffer.class, 90, 3135, 3145)) {
                return npe_invocation_var440.get();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public E remove() {
        synchronized(lock) {
            final Buffer<E> npe_invocation_var441 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var441, Buffer.class, 96, 3244, 3254)) {
                return npe_invocation_var441.remove();
            }else
                throw new AbnormalExecutionError();
            
        }
    }
}

