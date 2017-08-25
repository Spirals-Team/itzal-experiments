package org.apache.commons.collections.buffer;

import java.io.Serializable;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.BufferUnderflowException;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BoundedCollection;
import java.util.Arrays;
import java.util.AbstractCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BoundedFifoBuffer<E> extends AbstractCollection<E> implements Serializable , BoundedCollection<E> , Buffer<E> {
    private static final long serialVersionUID = 5603722811189451017L;

    private transient E[] elements;

    private transient int start = 0;

    private transient int end = 0;

    private transient boolean full = false;

    private final int maxElements;

    public BoundedFifoBuffer() {
        this(32);
        MethodContext _bcornu_methode_context234 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context234.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public BoundedFifoBuffer(int size) {
        MethodContext _bcornu_methode_context235 = new MethodContext(null);
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("The size must be greater than 0");
            }
            elements = ((E[]) (new Object[size]));
            CallChecker.varAssign(this.elements, "this.elements", 112, 4144, 4177);
            elements = CallChecker.beforeCalled(elements, null, 113, 4201, 4208);
            maxElements = CallChecker.isCalled(elements, null, 113, 4201, 4208).length;
            CallChecker.varAssign(this.maxElements, "this.maxElements", 113, 4187, 4216);
        } finally {
            _bcornu_methode_context235.methodEnd();
        }
    }

    public BoundedFifoBuffer(Collection<? extends E> coll) {
        this(CallChecker.isCalled(coll, Collection.class, 125, 4656, 4659).size());
        MethodContext _bcornu_methode_context236 = new MethodContext(null);
        try {
            addAll(coll);
        } finally {
            _bcornu_methode_context236.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1185 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 136, 4703, 5167);
            CallChecker.varInit(out, "out", 136, 4703, 5167);
            CallChecker.varInit(this.maxElements, "maxElements", 136, 4703, 5167);
            CallChecker.varInit(this.full, "full", 136, 4703, 5167);
            CallChecker.varInit(this.end, "end", 136, 4703, 5167);
            CallChecker.varInit(this.start, "start", 136, 4703, 5167);
            CallChecker.varInit(this.elements, "elements", 136, 4703, 5167);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 136, 4703, 5167);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 137, 4998, 5000)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 137, 4998, 5000);
                CallChecker.isCalled(out, ObjectOutputStream.class, 137, 4998, 5000).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 138, 5032, 5034)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 138, 5032, 5034);
                CallChecker.isCalled(out, ObjectOutputStream.class, 138, 5032, 5034).writeInt(size());
            }
            for (Iterator<E> it = iterator(); CallChecker.isCalled(it, Iterator.class, 139, 5096, 5097).hasNext();) {
                if (CallChecker.beforeDeref(it, Iterator.class, 140, 5141, 5142)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 140, 5125, 5127)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 140, 5125, 5127);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 140, 5125, 5127).writeObject(it.next());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1185.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1186 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 152, 5174, 5839);
            CallChecker.varInit(in, "in", 152, 5174, 5839);
            CallChecker.varInit(this.maxElements, "maxElements", 152, 5174, 5839);
            CallChecker.varInit(this.full, "full", 152, 5174, 5839);
            CallChecker.varInit(this.end, "end", 152, 5174, 5839);
            CallChecker.varInit(this.start, "start", 152, 5174, 5839);
            CallChecker.varInit(this.elements, "elements", 152, 5174, 5839);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 152, 5174, 5839);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 153, 5481, 5482)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 153, 5481, 5482);
                CallChecker.isCalled(in, ObjectInputStream.class, 153, 5481, 5482).defaultReadObject();
            }
            elements = ((E[]) (new Object[maxElements]));
            CallChecker.varAssign(this.elements, "this.elements", 154, 5513, 5553);
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 155, 5574, 5575)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 155, 5574, 5575);
                size = CallChecker.isCalled(in, ObjectInputStream.class, 155, 5574, 5575).readInt();
                CallChecker.varAssign(size, "size", 155, 5574, 5575);
            }
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(elements, null, 157, 5641, 5648)) {
                    if (CallChecker.beforeDeref(in, ObjectInputStream.class, 157, 5659, 5660)) {
                        in = CallChecker.beforeCalled(in, ObjectInputStream.class, 157, 5659, 5660);
                        elements[i] = ((E) (CallChecker.isCalled(in, ObjectInputStream.class, 157, 5659, 5660).readObject()));
                        CallChecker.varAssign(this.elements[i], "this.elements[i]", 157, 5641, 5674);
                    }
                }
            }
            start = 0;
            CallChecker.varAssign(this.start, "this.start", 159, 5694, 5703);
            full = size == (maxElements);
            CallChecker.varAssign(this.full, "this.full", 160, 5713, 5741);
            if (full) {
                end = 0;
                CallChecker.varAssign(this.end, "this.end", 162, 5775, 5782);
            }else {
                end = size;
                CallChecker.varAssign(this.end, "this.end", 164, 5813, 5823);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1186.methodEnd();
        }
    }

    @Override
    public int size() {
        MethodContext _bcornu_methode_context1187 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 175, 5846, 6336);
            CallChecker.varInit(this.maxElements, "maxElements", 175, 5846, 6336);
            CallChecker.varInit(this.full, "full", 175, 5846, 6336);
            CallChecker.varInit(this.end, "end", 175, 5846, 6336);
            CallChecker.varInit(this.start, "start", 175, 5846, 6336);
            CallChecker.varInit(this.elements, "elements", 175, 5846, 6336);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 175, 5846, 6336);
            int size = CallChecker.varInit(((int) (0)), "size", 176, 6083, 6095);
            if ((end) < (start)) {
                size = ((maxElements) - (start)) + (end);
                CallChecker.varAssign(size, "size", 179, 6137, 6169);
            }else
                if ((end) == (start)) {
                    if (full) {
                        size = maxElements;
                        CallChecker.varAssign(size, "size", 181, 6218, 6249);
                    }else {
                        size = 0;
                        CallChecker.varAssign(size, "size", 181, 6218, 6249);
                    }
                }else {
                    size = (end) - (start);
                    CallChecker.varAssign(size, "size", 183, 6280, 6298);
                }
            
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1187.methodEnd();
        }
    }

    @Override
    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1188 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 195, 6343, 6545);
            CallChecker.varInit(this.maxElements, "maxElements", 195, 6343, 6545);
            CallChecker.varInit(this.full, "full", 195, 6343, 6545);
            CallChecker.varInit(this.end, "end", 195, 6343, 6545);
            CallChecker.varInit(this.start, "start", 195, 6343, 6545);
            CallChecker.varInit(this.elements, "elements", 195, 6343, 6545);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 195, 6343, 6545);
            return (size()) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1188.methodEnd();
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context1189 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 204, 6552, 6783);
            CallChecker.varInit(this.maxElements, "maxElements", 204, 6552, 6783);
            CallChecker.varInit(this.full, "full", 204, 6552, 6783);
            CallChecker.varInit(this.end, "end", 204, 6552, 6783);
            CallChecker.varInit(this.start, "start", 204, 6552, 6783);
            CallChecker.varInit(this.elements, "elements", 204, 6552, 6783);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 204, 6552, 6783);
            return (size()) == (maxElements);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1189.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context1190 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 213, 6790, 6998);
            CallChecker.varInit(this.maxElements, "maxElements", 213, 6790, 6998);
            CallChecker.varInit(this.full, "full", 213, 6790, 6998);
            CallChecker.varInit(this.end, "end", 213, 6790, 6998);
            CallChecker.varInit(this.start, "start", 213, 6790, 6998);
            CallChecker.varInit(this.elements, "elements", 213, 6790, 6998);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 213, 6790, 6998);
            return maxElements;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1190.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1191 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 221, 7005, 7183);
            CallChecker.varInit(this.maxElements, "maxElements", 221, 7005, 7183);
            CallChecker.varInit(this.full, "full", 221, 7005, 7183);
            CallChecker.varInit(this.end, "end", 221, 7005, 7183);
            CallChecker.varInit(this.start, "start", 221, 7005, 7183);
            CallChecker.varInit(this.elements, "elements", 221, 7005, 7183);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 221, 7005, 7183);
            full = false;
            CallChecker.varAssign(this.full, "this.full", 222, 7092, 7104);
            start = 0;
            CallChecker.varAssign(this.start, "this.start", 223, 7114, 7123);
            end = 0;
            CallChecker.varAssign(this.end, "this.end", 224, 7133, 7140);
            Arrays.fill(elements, null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1191.methodEnd();
        }
    }

    @Override
    public boolean add(E element) {
        MethodContext _bcornu_methode_context1192 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 237, 7190, 7966);
            CallChecker.varInit(element, "element", 237, 7190, 7966);
            CallChecker.varInit(this.maxElements, "maxElements", 237, 7190, 7966);
            CallChecker.varInit(this.full, "full", 237, 7190, 7966);
            CallChecker.varInit(this.end, "end", 237, 7190, 7966);
            CallChecker.varInit(this.start, "start", 237, 7190, 7966);
            CallChecker.varInit(this.elements, "elements", 237, 7190, 7966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 237, 7190, 7966);
            if (null == element) {
                throw new NullPointerException("Attempted to add null object to buffer");
            }
            if (full) {
                throw new BufferOverflowException((("The buffer cannot hold more than " + (maxElements)) + " objects."));
            }
            if (CallChecker.beforeDeref(elements, null, 246, 7783, 7790)) {
                elements[((end)++)] = element;
                CallChecker.varAssign(this.elements[((this.end) - 1)], "this.elements[((this.end) - 1)]", 246, 7783, 7808);
            }
            if ((end) >= (maxElements)) {
                end = 0;
                CallChecker.varAssign(this.end, "this.end", 249, 7857, 7864);
            }
            if ((end) == (start)) {
                full = true;
                CallChecker.varAssign(this.full, "this.full", 253, 7917, 7928);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1192.methodEnd();
        }
    }

    public E get() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        if (CallChecker.beforeDeref(elements, null, 269, 8324, 8331)) {
            return elements[start];
        }else
            throw new AbnormalExecutionError();
        
    }

    public E remove() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        E element = CallChecker.init(null);
        if (CallChecker.beforeDeref(elements, null, 283, 8714, 8721)) {
            element = elements[start];
            CallChecker.varAssign(element, "element", 283, 8714, 8721);
        }
        if (null != element) {
            if (CallChecker.beforeDeref(elements, null, 286, 8775, 8782)) {
                elements[((start)++)] = null;
                CallChecker.varAssign(this.elements[((this.start) - 1)], "this.elements[((this.start) - 1)]", 286, 8775, 8799);
            }
            if ((start) >= (maxElements)) {
                start = 0;
                CallChecker.varAssign(this.start, "this.start", 289, 8858, 8867);
            }
            full = false;
            CallChecker.varAssign(this.full, "this.full", 291, 8895, 8907);
        }
        return element;
    }

    private int increment(int index) {
        MethodContext _bcornu_methode_context1195 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 302, 8954, 9239);
            CallChecker.varInit(index, "index", 302, 8954, 9239);
            CallChecker.varInit(this.maxElements, "maxElements", 302, 8954, 9239);
            CallChecker.varInit(this.full, "full", 302, 8954, 9239);
            CallChecker.varInit(this.end, "end", 302, 8954, 9239);
            CallChecker.varInit(this.start, "start", 302, 8954, 9239);
            CallChecker.varInit(this.elements, "elements", 302, 8954, 9239);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 302, 8954, 9239);
            index++;
            if (index >= (maxElements)) {
                index = 0;
                CallChecker.varAssign(index, "index", 305, 9192, 9201);
            }
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1195.methodEnd();
        }
    }

    private int decrement(int index) {
        MethodContext _bcornu_methode_context1196 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 316, 9246, 9534);
            CallChecker.varInit(index, "index", 316, 9246, 9534);
            CallChecker.varInit(this.maxElements, "maxElements", 316, 9246, 9534);
            CallChecker.varInit(this.full, "full", 316, 9246, 9534);
            CallChecker.varInit(this.end, "end", 316, 9246, 9534);
            CallChecker.varInit(this.start, "start", 316, 9246, 9534);
            CallChecker.varInit(this.elements, "elements", 316, 9246, 9534);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 316, 9246, 9534);
            index--;
            if (index < 0) {
                index = (maxElements) - 1;
                CallChecker.varAssign(index, "index", 319, 9473, 9496);
            }
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1196.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1200 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 330, 9541, 11729);
            CallChecker.varInit(this.maxElements, "maxElements", 330, 9541, 11729);
            CallChecker.varInit(this.full, "full", 330, 9541, 11729);
            CallChecker.varInit(this.end, "end", 330, 9541, 11729);
            CallChecker.varInit(this.start, "start", 330, 9541, 11729);
            CallChecker.varInit(this.elements, "elements", 330, 9541, 11729);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.BoundedFifoBuffer.serialVersionUID", 330, 9541, 11729);
            return new Iterator<E>() {
                private int index = start;

                private int lastReturnedIndex = -1;

                private boolean isFirst = full;

                public boolean hasNext() {
                    MethodContext _bcornu_methode_context1197 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 337, 9901, 9990);
                        return (isFirst) || ((index) != (end));
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1197.methodEnd();
                    }
                }

                public E next() {
                    if (!(hasNext())) {
                        throw new NoSuchElementException();
                    }
                    isFirst = false;
                    CallChecker.varAssign(this.isFirst, "this.isFirst", 345, 10147, 10162);
                    lastReturnedIndex = index;
                    CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 346, 10180, 10205);
                    index = increment(index);
                    CallChecker.varAssign(this.index, "this.index", 347, 10223, 10247);
                    if (CallChecker.beforeDeref(elements, null, 348, 10272, 10279)) {
                        return elements[lastReturnedIndex];
                    }else
                        throw new AbnormalExecutionError();
                    
                }

                public void remove() {
                    MethodContext _bcornu_methode_context1199 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 351, 10328, 11711);
                        if ((lastReturnedIndex) == (-1)) {
                            throw new IllegalStateException();
                        }
                        if ((lastReturnedIndex) == (start)) {
                            BoundedFifoBuffer.this.remove();
                            lastReturnedIndex = -1;
                            CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 359, 10651, 10673);
                            return ;
                        }
                        int pos = CallChecker.varInit(((int) ((this.lastReturnedIndex) + 1)), "pos", 363, 10738, 10769);
                        if (((start) < (lastReturnedIndex)) && (pos < (end))) {
                            System.arraycopy(elements, pos, elements, lastReturnedIndex, ((end) - pos));
                        }else {
                            while (pos != (end)) {
                                if (pos >= (maxElements)) {
                                    if (CallChecker.beforeDeref(elements, null, 372, 11221, 11228)) {
                                        if (CallChecker.beforeDeref(elements, null, 372, 11241, 11248)) {
                                            elements[(pos - 1)] = elements[0];
                                            CallChecker.varAssign(BoundedFifoBuffer.this.elements[(pos - 1)], "this.elements[(pos - 1)]", 372, 11221, 11252);
                                        }
                                    }
                                    pos = 0;
                                    CallChecker.varAssign(pos, "pos", 373, 11282, 11289);
                                }else {
                                    if (CallChecker.beforeDeref(elements, null, 375, 11352, 11359)) {
                                        if (CallChecker.beforeDeref(elements, null, 375, 11379, 11386)) {
                                            elements[decrement(pos)] = elements[pos];
                                            CallChecker.varAssign(BoundedFifoBuffer.this.elements[decrement(pos)], "this.elements[decrement(pos)]", 375, 11352, 11392);
                                        }
                                    }
                                    pos = increment(pos);
                                    CallChecker.varAssign(pos, "pos", 376, 11422, 11442);
                                }
                            } 
                        }
                        lastReturnedIndex = -1;
                        CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 381, 11527, 11549);
                        end = decrement(end);
                        CallChecker.varAssign(BoundedFifoBuffer.this.end, "this.end", 382, 11567, 11587);
                        if (CallChecker.beforeDeref(elements, null, 383, 11605, 11612)) {
                            elements[end] = null;
                            CallChecker.varAssign(BoundedFifoBuffer.this.elements[BoundedFifoBuffer.this.end], "this.elements[this.end]", 383, 11605, 11625);
                        }
                        full = false;
                        CallChecker.varAssign(BoundedFifoBuffer.this.full, "this.full", 384, 11643, 11655);
                        index = decrement(index);
                        CallChecker.varAssign(this.index, "this.index", 385, 11673, 11697);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1199.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1200.methodEnd();
        }
    }
}

