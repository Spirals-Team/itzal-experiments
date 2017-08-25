package org.apache.commons.collections.buffer;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractBufferDecorator<E> extends AbstractCollectionDecorator<E> implements Buffer<E> {
    private static final long serialVersionUID = -2629815475789577029L;

    protected AbstractBufferDecorator() {
        super();
        MethodContext _bcornu_methode_context452 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context452.methodEnd();
        }
    }

    protected AbstractBufferDecorator(Buffer<E> buffer) {
        super(buffer);
        MethodContext _bcornu_methode_context453 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context453.methodEnd();
        }
    }

    @Override
    protected Buffer<E> decorated() {
        MethodContext _bcornu_methode_context2384 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(this, "this", 63, 2032, 2230);
            CallChecker.varInit(this.collection, "collection", 63, 2032, 2230);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.AbstractBufferDecorator.serialVersionUID", 63, 2032, 2230);
            return ((Buffer<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2384.methodEnd();
        }
    }

    public E get() {
        final Buffer<E> npe_invocation_var442 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var442, Buffer.class, 69, 2347, 2357)) {
            return npe_invocation_var442.get();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E remove() {
        final Buffer<E> npe_invocation_var443 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var443, Buffer.class, 73, 2412, 2422)) {
            return npe_invocation_var443.remove();
        }else
            throw new AbnormalExecutionError();
        
    }
}

