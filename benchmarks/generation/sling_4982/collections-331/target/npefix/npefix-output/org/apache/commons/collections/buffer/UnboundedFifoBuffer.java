package org.apache.commons.collections.buffer;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.AbstractCollection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;

public class UnboundedFifoBuffer<E> extends AbstractCollection<E> implements Serializable , Buffer<E> {
    private static final long serialVersionUID = -3482960336579541419L;

    protected transient E[] buffer;

    protected transient int head;

    protected transient int tail;

    public UnboundedFifoBuffer() {
        this(32);
        MethodContext _bcornu_methode_context19 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public UnboundedFifoBuffer(int initialSize) {
        MethodContext _bcornu_methode_context20 = new MethodContext(null);
        try {
            if (initialSize <= 0) {
                throw new IllegalArgumentException("The size must be greater than 0");
            }
            buffer = ((E[]) (new Object[initialSize + 1]));
            CallChecker.varAssign(this.buffer, "this.buffer", 106, 3963, 4005);
            head = 0;
            CallChecker.varAssign(this.head, "this.head", 107, 4015, 4023);
            tail = 0;
            CallChecker.varAssign(this.tail, "this.tail", 108, 4033, 4041);
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context74 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 118, 4054, 4555);
            CallChecker.varInit(out, "out", 118, 4054, 4555);
            CallChecker.varInit(this.tail, "tail", 118, 4054, 4555);
            CallChecker.varInit(this.head, "head", 118, 4054, 4555);
            CallChecker.varInit(this.buffer, "buffer", 118, 4054, 4555);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 118, 4054, 4555);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 119, 4349, 4351)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 119, 4349, 4351);
                CallChecker.isCalled(out, ObjectOutputStream.class, 119, 4349, 4351).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 120, 4383, 4385)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 120, 4383, 4385);
                CallChecker.isCalled(out, ObjectOutputStream.class, 120, 4383, 4385).writeInt(size());
            }
            if (CallChecker.beforeDeref(buffer, null, 121, 4426, 4431)) {
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 121, 4413, 4415)) {
                    buffer = CallChecker.beforeCalled(buffer, null, 121, 4426, 4431);
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 121, 4413, 4415);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 121, 4413, 4415).writeInt(CallChecker.isCalled(buffer, null, 121, 4426, 4431).length);
                }
            }
            for (Iterator<E> it = iterator(); CallChecker.isCalled(it, Iterator.class, 122, 4484, 4485).hasNext();) {
                if (CallChecker.beforeDeref(it, Iterator.class, 123, 4529, 4530)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 123, 4513, 4515)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 123, 4513, 4515);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 123, 4513, 4515).writeObject(it.next());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context75 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 135, 4562, 5143);
            CallChecker.varInit(in, "in", 135, 4562, 5143);
            CallChecker.varInit(this.tail, "tail", 135, 4562, 5143);
            CallChecker.varInit(this.head, "head", 135, 4562, 5143);
            CallChecker.varInit(this.buffer, "buffer", 135, 4562, 5143);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 135, 4562, 5143);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 136, 4869, 4870)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 136, 4869, 4870);
                CallChecker.isCalled(in, ObjectInputStream.class, 136, 4869, 4870).defaultReadObject();
            }
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 137, 4912, 4913)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 137, 4912, 4913);
                size = CallChecker.isCalled(in, ObjectInputStream.class, 137, 4912, 4913).readInt();
                CallChecker.varAssign(size, "size", 137, 4912, 4913);
            }
            int length = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 138, 4947, 4948)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 138, 4947, 4948);
                length = CallChecker.isCalled(in, ObjectInputStream.class, 138, 4947, 4948).readInt();
                CallChecker.varAssign(length, "length", 138, 4947, 4948);
            }
            buffer = ((E[]) (new Object[length]));
            CallChecker.varAssign(this.buffer, "this.buffer", 139, 4969, 5002);
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(buffer, null, 141, 5057, 5062)) {
                    if (CallChecker.beforeDeref(in, ObjectInputStream.class, 141, 5073, 5074)) {
                        in = CallChecker.beforeCalled(in, ObjectInputStream.class, 141, 5073, 5074);
                        buffer[i] = ((E) (CallChecker.isCalled(in, ObjectInputStream.class, 141, 5073, 5074).readObject()));
                        CallChecker.varAssign(this.buffer[i], "this.buffer[i]", 141, 5057, 5088);
                    }
                }
            }
            head = 0;
            CallChecker.varAssign(this.head, "this.head", 143, 5108, 5116);
            tail = size;
            CallChecker.varAssign(this.tail, "this.tail", 144, 5126, 5137);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }

    @Override
    public int size() {
        MethodContext _bcornu_methode_context76 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 154, 5150, 5562);
            CallChecker.varInit(this.tail, "tail", 154, 5150, 5562);
            CallChecker.varInit(this.head, "head", 154, 5150, 5562);
            CallChecker.varInit(this.buffer, "buffer", 154, 5150, 5562);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 154, 5150, 5562);
            int size = CallChecker.varInit(((int) (0)), "size", 155, 5387, 5399);
            if ((tail) < (head)) {
                if (CallChecker.beforeDeref(buffer, null, 158, 5448, 5453)) {
                    buffer = CallChecker.beforeCalled(buffer, null, 158, 5448, 5453);
                    size = ((CallChecker.isCalled(buffer, null, 158, 5448, 5453).length) - (head)) + (tail);
                    CallChecker.varAssign(size, "size", 158, 5441, 5475);
                }
            }else {
                size = (tail) - (head);
                CallChecker.varAssign(size, "size", 160, 5506, 5524);
            }
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    @Override
    public boolean isEmpty() {
        MethodContext _bcornu_methode_context77 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 172, 5569, 5773);
            CallChecker.varInit(this.tail, "tail", 172, 5569, 5773);
            CallChecker.varInit(this.head, "head", 172, 5569, 5773);
            CallChecker.varInit(this.buffer, "buffer", 172, 5569, 5773);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 172, 5569, 5773);
            return (size()) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public boolean add(final E obj) {
        MethodContext _bcornu_methode_context78 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 185, 5780, 6785);
            CallChecker.varInit(obj, "obj", 185, 5780, 6785);
            CallChecker.varInit(this.tail, "tail", 185, 5780, 6785);
            CallChecker.varInit(this.head, "head", 185, 5780, 6785);
            CallChecker.varInit(this.buffer, "buffer", 185, 5780, 6785);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 185, 5780, 6785);
            if (obj == null) {
                throw new NullPointerException("Attempted to add null object to buffer");
            }
            if (CallChecker.beforeDeref(buffer, null, 190, 6214, 6219)) {
                buffer = CallChecker.beforeCalled(buffer, null, 190, 6214, 6219);
                if (((size()) + 1) >= (CallChecker.isCalled(buffer, null, 190, 6214, 6219).length)) {
                    E[] tmp = CallChecker.init(null);
                    if (CallChecker.beforeDeref(buffer, null, 192, 6323, 6328)) {
                        buffer = CallChecker.beforeCalled(buffer, null, 192, 6323, 6328);
                        tmp = ((E[]) (new Object[(((CallChecker.isCalled(buffer, null, 192, 6323, 6328).length) - 1) * 2) + 1]));
                        CallChecker.varAssign(tmp, "tmp", 192, 6323, 6328);
                    }
                    int j = CallChecker.varInit(((int) (0)), "j", 193, 6365, 6374);
                    for (int i = head; i != (tail);) {
                        if (CallChecker.beforeDeref(tmp, null, 196, 6495, 6497)) {
                            if (CallChecker.beforeDeref(buffer, null, 196, 6504, 6509)) {
                                tmp[j] = buffer[i];
                                CallChecker.varAssign(tmp[j], "tmp[j]", 196, 6495, 6513);
                            }
                        }
                        if (CallChecker.beforeDeref(buffer, null, 197, 6531, 6536)) {
                            buffer[i] = null;
                            CallChecker.varAssign(this.buffer[i], "this.buffer[i]", 197, 6531, 6547);
                        }
                        j++;
                        i = increment(i);
                        CallChecker.varAssign(i, "i", 200, 6587, 6603);
                    }
                    buffer = tmp;
                    CallChecker.varAssign(this.buffer, "this.buffer", 202, 6631, 6643);
                    head = 0;
                    CallChecker.varAssign(this.head, "this.head", 203, 6657, 6665);
                    tail = j;
                    CallChecker.varAssign(this.tail, "this.tail", 204, 6679, 6687);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(buffer, null, 207, 6708, 6713)) {
                buffer[tail] = obj;
                CallChecker.varAssign(this.buffer[this.tail], "this.buffer[this.tail]", 207, 6708, 6726);
            }
            tail = increment(tail);
            CallChecker.varAssign(this.tail, "this.tail", 208, 6736, 6758);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    public E get() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        if (CallChecker.beforeDeref(buffer, null, 223, 7118, 7123)) {
            return buffer[head];
        }else
            throw new AbnormalExecutionError();
        
    }

    public E remove() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        E element = CallChecker.init(null);
        if (CallChecker.beforeDeref(buffer, null, 237, 7467, 7472)) {
            element = buffer[head];
            CallChecker.varAssign(element, "element", 237, 7467, 7472);
        }
        if (element != null) {
            if (CallChecker.beforeDeref(buffer, null, 239, 7524, 7529)) {
                buffer[head] = null;
                CallChecker.varAssign(this.buffer[this.head], "this.buffer[this.head]", 239, 7524, 7543);
            }
            head = increment(head);
            CallChecker.varAssign(this.head, "this.head", 240, 7557, 7579);
        }
        return element;
    }

    private int increment(int index) {
        MethodContext _bcornu_methode_context81 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 251, 7626, 7913);
            CallChecker.varInit(index, "index", 251, 7626, 7913);
            CallChecker.varInit(this.tail, "tail", 251, 7626, 7913);
            CallChecker.varInit(this.head, "head", 251, 7626, 7913);
            CallChecker.varInit(this.buffer, "buffer", 251, 7626, 7913);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 251, 7626, 7913);
            index++;
            if (CallChecker.beforeDeref(buffer, null, 253, 7837, 7842)) {
                buffer = CallChecker.beforeCalled(buffer, null, 253, 7837, 7842);
                if (index >= (CallChecker.isCalled(buffer, null, 253, 7837, 7842).length)) {
                    index = 0;
                    CallChecker.varAssign(index, "index", 254, 7866, 7875);
                }
            }
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    private int decrement(int index) {
        MethodContext _bcornu_methode_context82 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 265, 7920, 8210);
            CallChecker.varInit(index, "index", 265, 7920, 8210);
            CallChecker.varInit(this.tail, "tail", 265, 7920, 8210);
            CallChecker.varInit(this.head, "head", 265, 7920, 8210);
            CallChecker.varInit(this.buffer, "buffer", 265, 7920, 8210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 265, 7920, 8210);
            index--;
            if (index < 0) {
                if (CallChecker.beforeDeref(buffer, null, 268, 8155, 8160)) {
                    buffer = CallChecker.beforeCalled(buffer, null, 268, 8155, 8160);
                    index = (CallChecker.isCalled(buffer, null, 268, 8155, 8160).length) - 1;
                    CallChecker.varAssign(index, "index", 268, 8147, 8172);
                }
            }
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context86 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 279, 8217, 9776);
            CallChecker.varInit(this.tail, "tail", 279, 8217, 9776);
            CallChecker.varInit(this.head, "head", 279, 8217, 9776);
            CallChecker.varInit(this.buffer, "buffer", 279, 8217, 9776);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.UnboundedFifoBuffer.serialVersionUID", 279, 8217, 9776);
            return new Iterator<E>() {
                private int index = head;

                private int lastReturnedIndex = -1;

                public boolean hasNext() {
                    MethodContext _bcornu_methode_context83 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 285, 8532, 8610);
                        return (index) != (tail);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context83.methodEnd();
                    }
                }

                public E next() {
                    if (!(hasNext())) {
                        throw new NoSuchElementException();
                    }
                    lastReturnedIndex = index;
                    CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 294, 8767, 8792);
                    index = increment(index);
                    CallChecker.varAssign(this.index, "this.index", 295, 8810, 8834);
                    if (CallChecker.beforeDeref(buffer, null, 296, 8859, 8864)) {
                        return buffer[lastReturnedIndex];
                    }else
                        throw new AbnormalExecutionError();
                    
                }

                public void remove() {
                    MethodContext _bcornu_methode_context85 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 299, 8913, 9758);
                        if ((lastReturnedIndex) == (-1)) {
                            throw new IllegalStateException();
                        }
                        if ((lastReturnedIndex) == (head)) {
                            UnboundedFifoBuffer.this.remove();
                            lastReturnedIndex = -1;
                            CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 307, 9237, 9259);
                            return ;
                        }
                        int i = CallChecker.varInit(((int) (increment(this.lastReturnedIndex))), "i", 312, 9402, 9438);
                        while (i != (tail)) {
                            if (CallChecker.beforeDeref(buffer, null, 314, 9496, 9501)) {
                                if (CallChecker.beforeDeref(buffer, null, 314, 9519, 9524)) {
                                    buffer[decrement(i)] = buffer[i];
                                    CallChecker.varAssign(UnboundedFifoBuffer.this.buffer[decrement(i)], "this.buffer[decrement(i)]", 314, 9496, 9528);
                                }
                            }
                            i = increment(i);
                            CallChecker.varAssign(i, "i", 315, 9550, 9566);
                        } 
                        lastReturnedIndex = -1;
                        CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 318, 9603, 9625);
                        tail = decrement(tail);
                        CallChecker.varAssign(UnboundedFifoBuffer.this.tail, "this.tail", 319, 9643, 9665);
                        if (CallChecker.beforeDeref(buffer, null, 320, 9683, 9688)) {
                            buffer[tail] = null;
                            CallChecker.varAssign(UnboundedFifoBuffer.this.buffer[UnboundedFifoBuffer.this.tail], "this.buffer[this.tail]", 320, 9683, 9702);
                        }
                        index = decrement(index);
                        CallChecker.varAssign(this.index, "this.index", 321, 9720, 9744);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context85.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }
}

