package org.apache.commons.collections.buffer;

import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class PredicatedBuffer<E> extends PredicatedCollection<E> implements Buffer<E> {
    private static final long serialVersionUID = 2307609000539943581L;

    public static <T> Buffer<T> decorate(Buffer<T> buffer, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context560 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(predicate, "predicate", 59, 1985, 2669);
            CallChecker.varInit(buffer, "buffer", 59, 1985, 2669);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PredicatedBuffer.serialVersionUID", 59, 1985, 2669);
            return new PredicatedBuffer<T>(buffer, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context560.methodEnd();
        }
    }

    protected PredicatedBuffer(Buffer<E> buffer, Predicate<? super E> predicate) {
        super(buffer, predicate);
        MethodContext _bcornu_methode_context101 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }

    @Override
    protected Buffer<E> decorated() {
        MethodContext _bcornu_methode_context561 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(this, "this", 85, 3357, 3555);
            CallChecker.varInit(this.collection, "collection", 85, 3357, 3555);
            CallChecker.varInit(this.predicate, "predicate", 85, 3357, 3555);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PredicatedBuffer.serialVersionUID", 85, 3357, 3555);
            return ((Buffer<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context561.methodEnd();
        }
    }

    public E get() {
        final Buffer<E> npe_invocation_var138 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var138, Buffer.class, 91, 3672, 3682)) {
            return npe_invocation_var138.get();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E remove() {
        final Buffer<E> npe_invocation_var139 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var139, Buffer.class, 95, 3737, 3747)) {
            return npe_invocation_var139.remove();
        }else
            throw new AbnormalExecutionError();
        
    }
}

