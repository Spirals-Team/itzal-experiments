package org.apache.commons.collections.buffer;

import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.Unmodifiable;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.Buffer;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class UnmodifiableBuffer<E> extends AbstractBufferDecorator<E> implements Serializable , Unmodifiable {
    private static final long serialVersionUID = 1832948656215393357L;

    public static <E> Buffer<E> decorate(Buffer<E> buffer) {
        MethodContext _bcornu_methode_context1970 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(buffer, "buffer", 58, 1833, 2349);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 58, 1833, 2349);
            if (buffer instanceof Unmodifiable) {
                return buffer;
            }
            return new UnmodifiableBuffer<E>(buffer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1970.methodEnd();
        }
    }

    private UnmodifiableBuffer(Buffer<E> buffer) {
        super(buffer);
        MethodContext _bcornu_methode_context382 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context382.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1971 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 83, 2704, 3071);
            CallChecker.varInit(out, "out", 83, 2704, 3071);
            CallChecker.varInit(this.collection, "collection", 83, 2704, 3071);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 83, 2704, 3071);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 84, 3004, 3006)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 84, 3004, 3006);
                CallChecker.isCalled(out, ObjectOutputStream.class, 84, 3004, 3006).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 85, 3038, 3040)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 85, 3038, 3040);
                CallChecker.isCalled(out, ObjectOutputStream.class, 85, 3038, 3040).writeObject(collection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1971.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1972 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 96, 3078, 3472);
            CallChecker.varInit(in, "in", 96, 3078, 3472);
            CallChecker.varInit(this.collection, "collection", 96, 3078, 3472);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 96, 3078, 3472);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 97, 3390, 3391)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 97, 3390, 3391);
                CallChecker.isCalled(in, ObjectInputStream.class, 97, 3390, 3391).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 98, 3451, 3452)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 98, 3451, 3452);
                collection = ((Collection<E>) (CallChecker.isCalled(in, ObjectInputStream.class, 98, 3451, 3452).readObject()));
                CallChecker.varAssign(this.collection, "this.collection", 98, 3422, 3466);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1972.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1973 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 103, 3479, 3677);
            CallChecker.varInit(this.collection, "collection", 103, 3479, 3677);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 103, 3479, 3677);
            final Buffer<E> npe_invocation_var386 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var386, Buffer.class, 104, 3648, 3658)) {
                return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var386, Buffer.class, 104, 3648, 3658).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1973.methodEnd();
        }
    }

    @Override
    public boolean add(Object object) {
        MethodContext _bcornu_methode_context1974 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 108, 3684, 3789);
            CallChecker.varInit(object, "object", 108, 3684, 3789);
            CallChecker.varInit(this.collection, "collection", 108, 3684, 3789);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 108, 3684, 3789);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1974.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1975 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 113, 3796, 3919);
            CallChecker.varInit(coll, "coll", 113, 3796, 3919);
            CallChecker.varInit(this.collection, "collection", 113, 3796, 3919);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 113, 3796, 3919);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1975.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1976 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 118, 3926, 4017);
            CallChecker.varInit(this.collection, "collection", 118, 3926, 4017);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 118, 3926, 4017);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1976.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context1977 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 123, 4024, 4132);
            CallChecker.varInit(object, "object", 123, 4024, 4132);
            CallChecker.varInit(this.collection, "collection", 123, 4024, 4132);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 123, 4024, 4132);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1977.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1978 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 4139, 4255);
            CallChecker.varInit(coll, "coll", 128, 4139, 4255);
            CallChecker.varInit(this.collection, "collection", 128, 4139, 4255);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 128, 4139, 4255);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1978.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1979 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 133, 4262, 4378);
            CallChecker.varInit(coll, "coll", 133, 4262, 4378);
            CallChecker.varInit(this.collection, "collection", 133, 4262, 4378);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnmodifiableBuffer.serialVersionUID", 133, 4262, 4378);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1979.methodEnd();
        }
    }

    @Override
    public E remove() {
        throw new UnsupportedOperationException();
    }
}

