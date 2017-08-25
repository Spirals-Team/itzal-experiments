package org.apache.commons.collections;

import org.apache.commons.collections.buffer.UnmodifiableBuffer;
import org.apache.commons.collections.buffer.BlockingBuffer;
import org.apache.commons.collections.buffer.BoundedBuffer;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.buffer.PredicatedBuffer;
import org.apache.commons.collections.buffer.SynchronizedBuffer;
import org.apache.commons.collections.buffer.TransformedBuffer;

public class BufferUtils {
    public static final Buffer<Object> EMPTY_BUFFER = UnmodifiableBuffer.decorate(new ArrayStack<Object>(1));

    public BufferUtils() {
        MethodContext _bcornu_methode_context253 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context253.methodEnd();
        }
    }

    public static <E> Buffer<E> synchronizedBuffer(Buffer<E> buffer) {
        MethodContext _bcornu_methode_context1270 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(buffer, "buffer", 69, 1799, 2728);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 69, 1799, 2728);
            return SynchronizedBuffer.decorate(buffer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1270.methodEnd();
        }
    }

    public static <E> Buffer<E> blockingBuffer(Buffer<E> buffer) {
        MethodContext _bcornu_methode_context1271 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(buffer, "buffer", 85, 2735, 3458);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 85, 2735, 3458);
            return BlockingBuffer.decorate(buffer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1271.methodEnd();
        }
    }

    public static <E> Buffer<E> blockingBuffer(Buffer<E> buffer, long timeoutMillis) {
        MethodContext _bcornu_methode_context1272 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(timeoutMillis, "timeoutMillis", 103, 3465, 4389);
            CallChecker.varInit(buffer, "buffer", 103, 3465, 4389);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 103, 3465, 4389);
            return BlockingBuffer.decorate(buffer, timeoutMillis);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1272.methodEnd();
        }
    }

    public static <E> Buffer<E> boundedBuffer(Buffer<E> buffer, int maximumSize) {
        MethodContext _bcornu_methode_context1273 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(maximumSize, "maximumSize", 120, 4396, 5148);
            CallChecker.varInit(buffer, "buffer", 120, 4396, 5148);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 120, 4396, 5148);
            return BoundedBuffer.decorate(buffer, maximumSize);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1273.methodEnd();
        }
    }

    public static <E> Buffer<E> boundedBuffer(Buffer<E> buffer, int maximumSize, long timeoutMillis) {
        MethodContext _bcornu_methode_context1274 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(timeoutMillis, "timeoutMillis", 138, 5155, 6054);
            CallChecker.varInit(maximumSize, "maximumSize", 138, 5155, 6054);
            CallChecker.varInit(buffer, "buffer", 138, 5155, 6054);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 138, 5155, 6054);
            return BoundedBuffer.decorate(buffer, maximumSize, timeoutMillis);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1274.methodEnd();
        }
    }

    public static <E> Buffer<E> unmodifiableBuffer(Buffer<E> buffer) {
        MethodContext _bcornu_methode_context1275 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(buffer, "buffer", 149, 6061, 6468);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 149, 6061, 6468);
            return UnmodifiableBuffer.decorate(buffer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1275.methodEnd();
        }
    }

    public static <E> Buffer<E> predicatedBuffer(Buffer<E> buffer, Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context1276 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(predicate, "predicate", 166, 6475, 7315);
            CallChecker.varInit(buffer, "buffer", 166, 6475, 7315);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 166, 6475, 7315);
            return PredicatedBuffer.decorate(buffer, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1276.methodEnd();
        }
    }

    public static <E> Buffer<E> transformedBuffer(Buffer<E> buffer, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context1277 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(transformer, "transformer", 185, 7322, 8279);
            CallChecker.varInit(buffer, "buffer", 185, 7322, 8279);
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 185, 7322, 8279);
            return TransformedBuffer.decorate(buffer, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1277.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Buffer<E> emptyBuffer() {
        MethodContext _bcornu_methode_context1278 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(EMPTY_BUFFER, "org.apache.commons.collections.BufferUtils.EMPTY_BUFFER", 195, 8286, 8510);
            return ((Buffer<E>) (BufferUtils.EMPTY_BUFFER));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1278.methodEnd();
        }
    }
}

