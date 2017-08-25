package org.apache.commons.collections.buffer;

import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.BufferUnderflowException;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.collections.collection.SynchronizedCollection;

public class BoundedBuffer<E> extends SynchronizedBuffer<E> implements BoundedCollection<E> {
    private static final long serialVersionUID = 1536432911093974264L;

    private final int maximumSize;

    private final long timeout;

    public static <E> BoundedBuffer<E> decorate(Buffer<E> buffer, int maximumSize) {
        MethodContext _bcornu_methode_context903 = new MethodContext(BoundedBuffer.class);
        try {
            CallChecker.varInit(maximumSize, "maximumSize", 70, 2423, 3099);
            CallChecker.varInit(buffer, "buffer", 70, 2423, 3099);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 70, 2423, 3099);
            return new BoundedBuffer<E>(buffer, maximumSize, 0L);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BoundedBuffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context903.methodEnd();
        }
    }

    public static <E> BoundedBuffer<E> decorate(Buffer<E> buffer, int maximumSize, long timeout) {
        MethodContext _bcornu_methode_context904 = new MethodContext(BoundedBuffer.class);
        try {
            CallChecker.varInit(timeout, "timeout", 85, 3106, 3777);
            CallChecker.varInit(maximumSize, "maximumSize", 85, 3106, 3777);
            CallChecker.varInit(buffer, "buffer", 85, 3106, 3777);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 85, 3106, 3777);
            return new BoundedBuffer<E>(buffer, maximumSize, timeout);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BoundedBuffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context904.methodEnd();
        }
    }

    protected BoundedBuffer(Buffer<E> buffer, int maximumSize, long timeout) {
        super(buffer);
        MethodContext _bcornu_methode_context179 = new MethodContext(null);
        try {
            if (maximumSize < 1) {
                throw new IllegalArgumentException();
            }
            this.maximumSize = maximumSize;
            CallChecker.varAssign(this.maximumSize, "this.maximumSize", 105, 4539, 4569);
            this.timeout = timeout;
            CallChecker.varAssign(this.timeout, "this.timeout", 106, 4579, 4601);
        } finally {
            _bcornu_methode_context179.methodEnd();
        }
    }

    @Override
    public E remove() {
        synchronized(lock) {
            final Buffer<E> npe_invocation_var203 = decorated();
            E returnValue = CallChecker.init(null);
            if (CallChecker.beforeDeref(npe_invocation_var203, Buffer.class, 113, 4784, 4794)) {
                returnValue = npe_invocation_var203.remove();
                CallChecker.varAssign(returnValue, "returnValue", 113, 4784, 4794);
            }
            if (CallChecker.beforeDeref(lock, Object.class, 114, 4818, 4821)) {
                CallChecker.isCalled(lock, Object.class, 114, 4818, 4821).notifyAll();
            }
            return returnValue;
        }
    }

    @Override
    public boolean add(E o) {
        MethodContext _bcornu_methode_context906 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 120, 4889, 5040);
            CallChecker.varInit(o, "o", 120, 4889, 5040);
            CallChecker.varInit(this.lock, "lock", 120, 4889, 5040);
            CallChecker.varInit(this.collection, "collection", 120, 4889, 5040);
            CallChecker.varInit(this.timeout, "timeout", 120, 4889, 5040);
            CallChecker.varInit(this.maximumSize, "maximumSize", 120, 4889, 5040);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 120, 4889, 5040);
            synchronized(lock) {
                timeoutWait(1);
                final Buffer<E> npe_invocation_var204 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var204, Buffer.class, 123, 5006, 5016)) {
                    return CallChecker.isCalled(npe_invocation_var204, Buffer.class, 123, 5006, 5016).add(o);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context906.methodEnd();
        }
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        MethodContext _bcornu_methode_context907 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 5047, 5239);
            CallChecker.varInit(c, "c", 128, 5047, 5239);
            CallChecker.varInit(this.lock, "lock", 128, 5047, 5239);
            CallChecker.varInit(this.collection, "collection", 128, 5047, 5239);
            CallChecker.varInit(this.timeout, "timeout", 128, 5047, 5239);
            CallChecker.varInit(this.maximumSize, "maximumSize", 128, 5047, 5239);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 128, 5047, 5239);
            synchronized(lock) {
                if (CallChecker.beforeDeref(c, Collection.class, 130, 5172, 5172)) {
                    timeoutWait(CallChecker.isCalled(c, Collection.class, 130, 5172, 5172).size());
                }
                final Buffer<E> npe_invocation_var205 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var205, Buffer.class, 131, 5202, 5212)) {
                    return CallChecker.isCalled(npe_invocation_var205, Buffer.class, 131, 5202, 5212).addAll(c);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context907.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context908 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 136, 5246, 5357);
            CallChecker.varInit(this.lock, "lock", 136, 5246, 5357);
            CallChecker.varInit(this.collection, "collection", 136, 5246, 5357);
            CallChecker.varInit(this.timeout, "timeout", 136, 5246, 5357);
            CallChecker.varInit(this.maximumSize, "maximumSize", 136, 5246, 5357);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 136, 5246, 5357);
            if (CallChecker.beforeDeref(collection, Collection.class, 137, 5329, 5338)) {
                return new NotifyingIterator(CallChecker.isCalled(collection, Collection.class, 137, 5329, 5338).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context908.methodEnd();
        }
    }

    private void timeoutWait(final int nAdditions) {
        MethodContext _bcornu_methode_context909 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 140, 5364, 6713);
            CallChecker.varInit(nAdditions, "nAdditions", 140, 5364, 6713);
            CallChecker.varInit(this.lock, "lock", 140, 5364, 6713);
            CallChecker.varInit(this.collection, "collection", 140, 5364, 6713);
            CallChecker.varInit(this.timeout, "timeout", 140, 5364, 6713);
            CallChecker.varInit(this.maximumSize, "maximumSize", 140, 5364, 6713);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 140, 5364, 6713);
            if (nAdditions > (maximumSize)) {
                throw new BufferOverflowException(("Buffer size cannot exceed " + (maximumSize)));
            }
            if ((timeout) <= 0) {
                final Buffer<E> npe_invocation_var206 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var206, Buffer.class, 148, 5711, 5721)) {
                    if (((CallChecker.isCalled(npe_invocation_var206, Buffer.class, 148, 5711, 5721).size()) + nAdditions) > (maximumSize)) {
                        throw new BufferOverflowException(("Buffer size cannot exceed " + (maximumSize)));
                    }
                }
                return ;
            }
            final long expiration = CallChecker.varInit(((long) ((System.currentTimeMillis()) + (this.timeout))), "expiration", 154, 5932, 5992);
            long timeLeft = CallChecker.varInit(((long) (expiration - (System.currentTimeMillis()))), "timeLeft", 155, 6002, 6057);
            while ((timeLeft > 0) && (((CallChecker.isCalled(decorated(), Buffer.class, 156, 6090, 6100).size()) + nAdditions) > (maximumSize))) {
                TryContext _bcornu_try_context_8 = new TryContext(8, BoundedBuffer.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(lock, Object.class, 158, 6173, 6176)) {
                        CallChecker.isCalled(lock, Object.class, 158, 6173, 6176).wait(timeLeft);
                    }
                    timeLeft = expiration - (System.currentTimeMillis());
                    CallChecker.varAssign(timeLeft, "timeLeft", 159, 6210, 6260);
                } catch (InterruptedException ex) {
                    _bcornu_try_context_8.catchStart(8);
                    PrintWriter out = CallChecker.varInit(new PrintWriter(new StringWriter()), "out", 161, 6326, 6379);
                    ex.printStackTrace(out);
                    if (CallChecker.beforeDeref(out, PrintWriter.class, 164, 6531, 6533)) {
                        out = CallChecker.beforeCalled(out, PrintWriter.class, 164, 6531, 6533);
                        throw new BufferUnderflowException(("Caused by InterruptedException: " + (CallChecker.isCalled(out, PrintWriter.class, 164, 6531, 6533).toString())));
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_8.finallyStart(8);
                }
            } 
            final Buffer<E> npe_invocation_var207 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var207, Buffer.class, 167, 6584, 6594)) {
                if (((CallChecker.isCalled(npe_invocation_var207, Buffer.class, 167, 6584, 6594).size()) + nAdditions) > (maximumSize)) {
                    throw new BufferOverflowException("Timeout expired");
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context909.methodEnd();
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context910 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 172, 6720, 6822);
            CallChecker.varInit(this.lock, "lock", 172, 6720, 6822);
            CallChecker.varInit(this.collection, "collection", 172, 6720, 6822);
            CallChecker.varInit(this.timeout, "timeout", 172, 6720, 6822);
            CallChecker.varInit(this.maximumSize, "maximumSize", 172, 6720, 6822);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 172, 6720, 6822);
            return (size()) == (maxSize());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context910.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context911 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 177, 6829, 6884);
            CallChecker.varInit(this.lock, "lock", 177, 6829, 6884);
            CallChecker.varInit(this.collection, "collection", 177, 6829, 6884);
            CallChecker.varInit(this.timeout, "timeout", 177, 6829, 6884);
            CallChecker.varInit(this.maximumSize, "maximumSize", 177, 6829, 6884);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedBuffer.serialVersionUID", 177, 6829, 6884);
            return maximumSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context911.methodEnd();
        }
    }

    private class NotifyingIterator extends AbstractIteratorDecorator<E> {
        public NotifyingIterator(Iterator<E> it) {
            super(it);
            MethodContext _bcornu_methode_context180 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context180.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context912 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 192, 7181, 7347);
                CallChecker.varInit(this.iterator, "iterator", 192, 7181, 7347);
                synchronized(lock) {
                    if (CallChecker.beforeDeref(iterator, Iterator.class, 194, 7272, 7279)) {
                        CallChecker.isCalled(iterator, Iterator.class, 194, 7272, 7279).remove();
                    }
                    if (CallChecker.beforeDeref(lock, Object.class, 195, 7307, 7310)) {
                        CallChecker.isCalled(lock, Object.class, 195, 7307, 7310).notifyAll();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context912.methodEnd();
            }
        }
    }
}

