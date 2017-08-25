package org.apache.commons.collections.buffer;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.commons.collections.collection.SynchronizedCollection;
import java.io.StringWriter;
import java.io.PrintWriter;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class BlockingBuffer<E> extends SynchronizedBuffer<E> {
    private static final long serialVersionUID = 1719328905017860541L;

    private final long timeout;

    public static <T> Buffer<T> decorate(Buffer<T> buffer) {
        MethodContext _bcornu_methode_context1053 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(buffer, "buffer", 67, 2463, 2858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BlockingBuffer.serialVersionUID", 67, 2463, 2858);
            return new BlockingBuffer<T>(buffer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1053.methodEnd();
        }
    }

    public static <T> Buffer<T> decorate(Buffer<T> buffer, long timeoutMillis) {
        MethodContext _bcornu_methode_context1054 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(timeoutMillis, "timeoutMillis", 80, 2865, 3394);
            CallChecker.varInit(buffer, "buffer", 80, 2865, 3394);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BlockingBuffer.serialVersionUID", 80, 2865, 3394);
            return new BlockingBuffer<T>(buffer, timeoutMillis);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1054.methodEnd();
        }
    }

    protected BlockingBuffer(Buffer<E> buffer) {
        super(buffer);
        MethodContext _bcornu_methode_context205 = new MethodContext(null);
        try {
            this.timeout = 0;
            CallChecker.varAssign(this.timeout, "this.timeout", 93, 3750, 3766);
        } finally {
            _bcornu_methode_context205.methodEnd();
        }
    }

    protected BlockingBuffer(Buffer<E> buffer, long timeoutMillis) {
        super(buffer);
        MethodContext _bcornu_methode_context206 = new MethodContext(null);
        try {
            if (timeoutMillis < 0) {
                this.timeout = 0;
                CallChecker.varAssign(this.timeout, "this.timeout", 106, 4197, 4251);
            }else {
                this.timeout = timeoutMillis;
                CallChecker.varAssign(this.timeout, "this.timeout", 106, 4197, 4251);
            }
        } finally {
            _bcornu_methode_context206.methodEnd();
        }
    }

    @Override
    public boolean add(E o) {
        MethodContext _bcornu_methode_context1055 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 111, 4264, 4531);
            CallChecker.varInit(o, "o", 111, 4264, 4531);
            CallChecker.varInit(this.lock, "lock", 111, 4264, 4531);
            CallChecker.varInit(this.collection, "collection", 111, 4264, 4531);
            CallChecker.varInit(this.timeout, "timeout", 111, 4264, 4531);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BlockingBuffer.serialVersionUID", 111, 4264, 4531);
            synchronized(lock) {
                boolean result = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(collection, Collection.class, 113, 4441, 4450)) {
                    result = CallChecker.isCalled(collection, Collection.class, 113, 4441, 4450).add(o);
                    CallChecker.varAssign(result, "result", 113, 4441, 4450);
                }
                if (CallChecker.beforeDeref(lock, Object.class, 114, 4472, 4475)) {
                    CallChecker.isCalled(lock, Object.class, 114, 4472, 4475).notifyAll();
                }
                return result;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1055.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        MethodContext _bcornu_methode_context1056 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 120, 4538, 4755);
            CallChecker.varInit(c, "c", 120, 4538, 4755);
            CallChecker.varInit(this.lock, "lock", 120, 4538, 4755);
            CallChecker.varInit(this.collection, "collection", 120, 4538, 4755);
            CallChecker.varInit(this.timeout, "timeout", 120, 4538, 4755);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BlockingBuffer.serialVersionUID", 120, 4538, 4755);
            synchronized(lock) {
                boolean result = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(collection, Collection.class, 122, 4662, 4671)) {
                    result = CallChecker.isCalled(collection, Collection.class, 122, 4662, 4671).addAll(c);
                    CallChecker.varAssign(result, "result", 122, 4662, 4671);
                }
                if (CallChecker.beforeDeref(lock, Object.class, 123, 4696, 4699)) {
                    CallChecker.isCalled(lock, Object.class, 123, 4696, 4699).notifyAll();
                }
                return result;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1056.methodEnd();
        }
    }

    @Override
    public E get() {
        synchronized(lock) {
            while (CallChecker.isCalled(collection, Collection.class, 138, 5109, 5118).isEmpty()) {
                TryContext _bcornu_try_context_14 = new TryContext(14, BlockingBuffer.class, "java.lang.InterruptedException");
                try {
                    if ((timeout) <= 0) {
                        if (CallChecker.beforeDeref(lock, Object.class, 141, 5219, 5222)) {
                            CallChecker.isCalled(lock, Object.class, 141, 5219, 5222).wait();
                        }
                    }else {
                        return get(timeout);
                    }
                } catch (InterruptedException e) {
                    _bcornu_try_context_14.catchStart(14);
                    PrintWriter out = CallChecker.varInit(new PrintWriter(new StringWriter()), "out", 146, 5399, 5452);
                    e.printStackTrace(out);
                    if (CallChecker.beforeDeref(out, PrintWriter.class, 148, 5590, 5592)) {
                        out = CallChecker.beforeCalled(out, PrintWriter.class, 148, 5590, 5592);
                        throw new BufferUnderflowException(("Caused by InterruptedException: " + (CallChecker.isCalled(out, PrintWriter.class, 148, 5590, 5592).toString())));
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_14.finallyStart(14);
                }
            } 
            final Buffer<E> npe_invocation_var230 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var230, Buffer.class, 151, 5658, 5668)) {
                return npe_invocation_var230.get();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public E get(final long timeout) {
        synchronized(lock) {
            final long expiration = CallChecker.varInit(((long) ((System.currentTimeMillis()) + timeout)), "expiration", 166, 6170, 6230);
            long timeLeft = CallChecker.varInit(((long) (expiration - (System.currentTimeMillis()))), "timeLeft", 167, 6244, 6299);
            while ((timeLeft > 0) && (CallChecker.isCalled(collection, Collection.class, 168, 6336, 6345).isEmpty())) {
                TryContext _bcornu_try_context_15 = new TryContext(15, BlockingBuffer.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(lock, Object.class, 170, 6402, 6405)) {
                        CallChecker.isCalled(lock, Object.class, 170, 6402, 6405).wait(timeLeft);
                    }
                    timeLeft = expiration - (System.currentTimeMillis());
                    CallChecker.varAssign(timeLeft, "timeLeft", 171, 6443, 6493);
                } catch (InterruptedException e) {
                    _bcornu_try_context_15.catchStart(15);
                    PrintWriter out = CallChecker.varInit(new PrintWriter(new StringWriter()), "out", 173, 6565, 6618);
                    e.printStackTrace(out);
                    if (CallChecker.beforeDeref(out, PrintWriter.class, 175, 6756, 6758)) {
                        out = CallChecker.beforeCalled(out, PrintWriter.class, 175, 6756, 6758);
                        throw new BufferUnderflowException(("Caused by InterruptedException: " + (CallChecker.isCalled(out, PrintWriter.class, 175, 6756, 6758).toString())));
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_15.finallyStart(15);
                }
            } 
            if (CallChecker.beforeDeref(collection, Collection.class, 178, 6821, 6830)) {
                if (CallChecker.isCalled(collection, Collection.class, 178, 6821, 6830).isEmpty()) {
                    throw new BufferUnderflowException("Timeout expired");
                }
            }else
                throw new AbnormalExecutionError();
            
            final Buffer<E> npe_invocation_var231 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var231, Buffer.class, 181, 6949, 6959)) {
                return npe_invocation_var231.get();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    @Override
    public E remove() {
        synchronized(lock) {
            while (CallChecker.isCalled(collection, Collection.class, 195, 7342, 7351).isEmpty()) {
                TryContext _bcornu_try_context_16 = new TryContext(16, BlockingBuffer.class, "java.lang.InterruptedException");
                try {
                    if ((timeout) <= 0) {
                        if (CallChecker.beforeDeref(lock, Object.class, 198, 7452, 7455)) {
                            CallChecker.isCalled(lock, Object.class, 198, 7452, 7455).wait();
                        }
                    }else {
                        return remove(timeout);
                    }
                } catch (InterruptedException e) {
                    _bcornu_try_context_16.catchStart(16);
                    PrintWriter out = CallChecker.varInit(new PrintWriter(new StringWriter()), "out", 203, 7635, 7688);
                    e.printStackTrace(out);
                    if (CallChecker.beforeDeref(out, PrintWriter.class, 205, 7826, 7828)) {
                        out = CallChecker.beforeCalled(out, PrintWriter.class, 205, 7826, 7828);
                        throw new BufferUnderflowException(("Caused by InterruptedException: " + (CallChecker.isCalled(out, PrintWriter.class, 205, 7826, 7828).toString())));
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_16.finallyStart(16);
                }
            } 
            final Buffer<E> npe_invocation_var232 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var232, Buffer.class, 208, 7894, 7904)) {
                return npe_invocation_var232.remove();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public E remove(final long timeout) {
        synchronized(lock) {
            final long expiration = CallChecker.varInit(((long) ((System.currentTimeMillis()) + timeout)), "expiration", 223, 8415, 8475);
            long timeLeft = CallChecker.varInit(((long) (expiration - (System.currentTimeMillis()))), "timeLeft", 224, 8489, 8544);
            while ((timeLeft > 0) && (CallChecker.isCalled(collection, Collection.class, 225, 8581, 8590).isEmpty())) {
                TryContext _bcornu_try_context_17 = new TryContext(17, BlockingBuffer.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(lock, Object.class, 227, 8647, 8650)) {
                        CallChecker.isCalled(lock, Object.class, 227, 8647, 8650).wait(timeLeft);
                    }
                    timeLeft = expiration - (System.currentTimeMillis());
                    CallChecker.varAssign(timeLeft, "timeLeft", 228, 8688, 8738);
                } catch (InterruptedException e) {
                    _bcornu_try_context_17.catchStart(17);
                    PrintWriter out = CallChecker.varInit(new PrintWriter(new StringWriter()), "out", 230, 8810, 8863);
                    e.printStackTrace(out);
                    if (CallChecker.beforeDeref(out, PrintWriter.class, 232, 9001, 9003)) {
                        out = CallChecker.beforeCalled(out, PrintWriter.class, 232, 9001, 9003);
                        throw new BufferUnderflowException(("Caused by InterruptedException: " + (CallChecker.isCalled(out, PrintWriter.class, 232, 9001, 9003).toString())));
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_17.finallyStart(17);
                }
            } 
            if (CallChecker.beforeDeref(collection, Collection.class, 235, 9066, 9075)) {
                if (CallChecker.isCalled(collection, Collection.class, 235, 9066, 9075).isEmpty()) {
                    throw new BufferUnderflowException("Timeout expired");
                }
            }else
                throw new AbnormalExecutionError();
            
            final Buffer<E> npe_invocation_var233 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var233, Buffer.class, 238, 9194, 9204)) {
                return npe_invocation_var233.remove();
            }else
                throw new AbnormalExecutionError();
            
        }
    }
}

