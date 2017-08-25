package org.apache.commons.collections.buffer;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;

public class CircularFifoBuffer<E> extends BoundedFifoBuffer<E> {
    private static final long serialVersionUID = -8423413834657610406L;

    public CircularFifoBuffer() {
        super(32);
        MethodContext _bcornu_methode_context144 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public CircularFifoBuffer(int size) {
        super(size);
        MethodContext _bcornu_methode_context145 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context145.methodEnd();
        }
    }

    public CircularFifoBuffer(Collection<E> coll) {
        super(coll);
        MethodContext _bcornu_methode_context146 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    @Override
    public boolean add(E element) {
        MethodContext _bcornu_methode_context772 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 90, 2957, 3312);
            CallChecker.varInit(element, "element", 90, 2957, 3312);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.CircularFifoBuffer.serialVersionUID", 90, 2957, 3312);
            if (isFull()) {
                remove();
            }
            return super.add(element);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context772.methodEnd();
        }
    }
}

