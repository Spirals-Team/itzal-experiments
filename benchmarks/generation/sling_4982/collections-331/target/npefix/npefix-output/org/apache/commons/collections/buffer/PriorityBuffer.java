package org.apache.commons.collections.buffer;

import java.io.Serializable;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.AbstractCollection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.comparators.ComparableComparator;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class PriorityBuffer<E> extends AbstractCollection<E> implements Serializable , Buffer<E> {
    private static final long serialVersionUID = 6891186490470027896L;

    private static final int DEFAULT_CAPACITY = 13;

    protected E[] elements;

    protected int size;

    protected boolean ascendingOrder;

    protected Comparator<? super E> comparator;

    public PriorityBuffer() {
        this(PriorityBuffer.DEFAULT_CAPACITY, true, null);
        MethodContext _bcornu_methode_context89 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public PriorityBuffer(Comparator<? super E> comparator) {
        this(PriorityBuffer.DEFAULT_CAPACITY, true, comparator);
        MethodContext _bcornu_methode_context90 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    public PriorityBuffer(boolean ascendingOrder) {
        this(PriorityBuffer.DEFAULT_CAPACITY, ascendingOrder, null);
        MethodContext _bcornu_methode_context91 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    public PriorityBuffer(boolean ascendingOrder, Comparator<? super E> comparator) {
        this(PriorityBuffer.DEFAULT_CAPACITY, ascendingOrder, comparator);
        MethodContext _bcornu_methode_context92 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    public PriorityBuffer(int capacity) {
        this(capacity, true, null);
        MethodContext _bcornu_methode_context93 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    public PriorityBuffer(int capacity, Comparator<? super E> comparator) {
        this(capacity, true, comparator);
        MethodContext _bcornu_methode_context94 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    public PriorityBuffer(int capacity, boolean ascendingOrder) {
        this(capacity, ascendingOrder, null);
        MethodContext _bcornu_methode_context95 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public PriorityBuffer(int capacity, boolean ascendingOrder, Comparator<? super E> comparator) {
        super();
        MethodContext _bcornu_methode_context96 = new MethodContext(null);
        try {
            if (capacity <= 0) {
                throw new IllegalArgumentException("invalid capacity");
            }
            this.ascendingOrder = ascendingOrder;
            CallChecker.varAssign(this.ascendingOrder, "this.ascendingOrder", 195, 7614, 7650);
            this.elements = ((E[]) (new Object[capacity + 1]));
            CallChecker.varAssign(this.elements, "this.elements", 198, 7687, 7733);
            if (comparator == null) {
                this.comparator = ((Comparator<? super E>) (ComparableComparator.INSTANCE));
                CallChecker.varAssign(this.comparator, "this.comparator", 199, 7743, 7850);
            }else {
                this.comparator = ((Comparator<? super E>) (comparator));
                CallChecker.varAssign(this.comparator, "this.comparator", 199, 7743, 7850);
            }
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    public boolean isAscendingOrder() {
        MethodContext _bcornu_methode_context515 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 208, 7863, 8153);
            CallChecker.varInit(this.comparator, "comparator", 208, 7863, 8153);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 208, 7863, 8153);
            CallChecker.varInit(this.size, "size", 208, 7863, 8153);
            CallChecker.varInit(this.elements, "elements", 208, 7863, 8153);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 208, 7863, 8153);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 208, 7863, 8153);
            return ascendingOrder;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context515.methodEnd();
        }
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context516 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 217, 8164, 8401);
            CallChecker.varInit(this.comparator, "comparator", 217, 8164, 8401);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 217, 8164, 8401);
            CallChecker.varInit(this.size, "size", 217, 8164, 8401);
            CallChecker.varInit(this.elements, "elements", 217, 8164, 8401);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 217, 8164, 8401);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 217, 8164, 8401);
            return comparator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context516.methodEnd();
        }
    }

    @Override
    public int size() {
        MethodContext _bcornu_methode_context517 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 228, 8412, 8679);
            CallChecker.varInit(this.comparator, "comparator", 228, 8412, 8679);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 228, 8412, 8679);
            CallChecker.varInit(this.size, "size", 228, 8412, 8679);
            CallChecker.varInit(this.elements, "elements", 228, 8412, 8679);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 228, 8412, 8679);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 228, 8412, 8679);
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context517.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public void clear() {
        MethodContext _bcornu_methode_context518 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 237, 8686, 8903);
            CallChecker.varInit(this.comparator, "comparator", 237, 8686, 8903);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 237, 8686, 8903);
            CallChecker.varInit(this.size, "size", 237, 8686, 8903);
            CallChecker.varInit(this.elements, "elements", 237, 8686, 8903);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 237, 8686, 8903);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 237, 8686, 8903);
            if (CallChecker.beforeDeref(elements, null, 238, 8853, 8860)) {
                elements = CallChecker.beforeCalled(elements, null, 238, 8853, 8860);
                elements = ((E[]) (new Object[CallChecker.isCalled(elements, null, 238, 8853, 8860).length]));
                CallChecker.varAssign(this.elements, "this.elements", 238, 8825, 8869);
            }
            size = 0;
            CallChecker.varAssign(this.size, "this.size", 239, 8889, 8897);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context518.methodEnd();
        }
    }

    @Override
    public boolean add(E element) {
        MethodContext _bcornu_methode_context519 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 251, 8910, 9452);
            CallChecker.varInit(element, "element", 251, 8910, 9452);
            CallChecker.varInit(this.comparator, "comparator", 251, 8910, 9452);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 251, 8910, 9452);
            CallChecker.varInit(this.size, "size", 251, 8910, 9452);
            CallChecker.varInit(this.elements, "elements", 251, 8910, 9452);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 251, 8910, 9452);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 251, 8910, 9452);
            if (isAtCapacity()) {
                grow();
            }
            if (ascendingOrder) {
                percolateUpMinHeap(element);
            }else {
                percolateUpMaxHeap(element);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context519.methodEnd();
        }
    }

    public E get() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        if (CallChecker.beforeDeref(elements, null, 274, 9774, 9781)) {
            return elements[1];
        }else
            throw new AbnormalExecutionError();
        
    }

    public E remove() {
        final E result = CallChecker.varInit(get(), "result", 284, 9992, 10014);
        if (CallChecker.beforeDeref(elements, null, 285, 10024, 10031)) {
            if (CallChecker.beforeDeref(elements, null, 285, 10038, 10045)) {
                elements[1] = elements[((size)--)];
                CallChecker.varAssign(this.elements[1], "this.elements[1]", 285, 10024, 10054);
            }
        }
        if (CallChecker.beforeDeref(elements, null, 289, 10215, 10222)) {
            elements[((size) + 1)] = null;
            CallChecker.varAssign(this.elements[((this.size) + 1)], "this.elements[((this.size) + 1)]", 289, 10215, 10240);
        }
        if ((size) != 0) {
            if (ascendingOrder) {
                percolateDownMinHeap(1);
            }else {
                percolateDownMaxHeap(1);
            }
        }
        return result;
    }

    protected boolean isAtCapacity() {
        MethodContext _bcornu_methode_context522 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 309, 10523, 10866);
            CallChecker.varInit(this.comparator, "comparator", 309, 10523, 10866);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 309, 10523, 10866);
            CallChecker.varInit(this.size, "size", 309, 10523, 10866);
            CallChecker.varInit(this.elements, "elements", 309, 10523, 10866);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 309, 10523, 10866);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 309, 10523, 10866);
            elements = CallChecker.beforeCalled(elements, null, 311, 10833, 10840);
            return (CallChecker.isCalled(elements, null, 311, 10833, 10840).length) == ((size) + 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context522.methodEnd();
        }
    }

    protected void percolateDownMinHeap(final int index) {
        MethodContext _bcornu_methode_context523 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 322, 10878, 11804);
            CallChecker.varInit(index, "index", 322, 10878, 11804);
            CallChecker.varInit(this.comparator, "comparator", 322, 10878, 11804);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 322, 10878, 11804);
            CallChecker.varInit(this.size, "size", 322, 10878, 11804);
            CallChecker.varInit(this.elements, "elements", 322, 10878, 11804);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 322, 10878, 11804);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 322, 10878, 11804);
            final E element = CallChecker.varInit(elements[index], "element", 323, 11132, 11165);
            int hole = CallChecker.varInit(((int) (index)), "hole", 324, 11175, 11191);
            while ((hole * 2) <= (size)) {
                int child = CallChecker.varInit(((int) (hole * 2)), "child", 327, 11243, 11263);
                if (CallChecker.beforeDeref(elements, null, 331, 11429, 11436)) {
                    if (CallChecker.beforeDeref(elements, null, 331, 11450, 11457)) {
                        if ((child != (size)) && ((compare(elements[(child + 1)], elements[child])) < 0)) {
                            child++;
                        }
                    }
                }
                if (CallChecker.beforeDeref(elements, null, 336, 11611, 11618)) {
                    if ((compare(elements[child], element)) >= 0) {
                        break;
                    }
                }
                if (CallChecker.beforeDeref(elements, null, 340, 11695, 11702)) {
                    if (CallChecker.beforeDeref(elements, null, 340, 11712, 11719)) {
                        elements[hole] = elements[child];
                        CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 340, 11695, 11727);
                    }
                }
                hole = child;
                CallChecker.varAssign(hole, "hole", 341, 11741, 11753);
            } 
            if (CallChecker.beforeDeref(elements, null, 344, 11774, 11781)) {
                elements[hole] = element;
                CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 344, 11774, 11798);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context523.methodEnd();
        }
    }

    protected void percolateDownMaxHeap(final int index) {
        MethodContext _bcornu_methode_context524 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 354, 11811, 12736);
            CallChecker.varInit(index, "index", 354, 11811, 12736);
            CallChecker.varInit(this.comparator, "comparator", 354, 11811, 12736);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 354, 11811, 12736);
            CallChecker.varInit(this.size, "size", 354, 11811, 12736);
            CallChecker.varInit(this.elements, "elements", 354, 11811, 12736);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 354, 11811, 12736);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 354, 11811, 12736);
            final E element = CallChecker.varInit(elements[index], "element", 355, 12064, 12097);
            int hole = CallChecker.varInit(((int) (index)), "hole", 356, 12107, 12123);
            while ((hole * 2) <= (size)) {
                int child = CallChecker.varInit(((int) (hole * 2)), "child", 359, 12175, 12195);
                if (CallChecker.beforeDeref(elements, null, 363, 12361, 12368)) {
                    if (CallChecker.beforeDeref(elements, null, 363, 12382, 12389)) {
                        if ((child != (size)) && ((compare(elements[(child + 1)], elements[child])) > 0)) {
                            child++;
                        }
                    }
                }
                if (CallChecker.beforeDeref(elements, null, 368, 12543, 12550)) {
                    if ((compare(elements[child], element)) <= 0) {
                        break;
                    }
                }
                if (CallChecker.beforeDeref(elements, null, 372, 12627, 12634)) {
                    if (CallChecker.beforeDeref(elements, null, 372, 12644, 12651)) {
                        elements[hole] = elements[child];
                        CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 372, 12627, 12659);
                    }
                }
                hole = child;
                CallChecker.varAssign(hole, "hole", 373, 12673, 12685);
            } 
            if (CallChecker.beforeDeref(elements, null, 376, 12706, 12713)) {
                elements[hole] = element;
                CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 376, 12706, 12730);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context524.methodEnd();
        }
    }

    protected void percolateUpMinHeap(final int index) {
        MethodContext _bcornu_methode_context525 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 386, 12743, 13404);
            CallChecker.varInit(index, "index", 386, 12743, 13404);
            CallChecker.varInit(this.comparator, "comparator", 386, 12743, 13404);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 386, 12743, 13404);
            CallChecker.varInit(this.size, "size", 386, 12743, 13404);
            CallChecker.varInit(this.elements, "elements", 386, 12743, 13404);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 386, 12743, 13404);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 386, 12743, 13404);
            int hole = CallChecker.varInit(((int) (index)), "hole", 387, 13012, 13028);
            E element = CallChecker.init(null);
            if (CallChecker.beforeDeref(elements, null, 388, 13050, 13057)) {
                element = elements[hole];
                CallChecker.varAssign(element, "element", 388, 13050, 13057);
            }
            while ((hole > 1) && ((compare(element, elements[(hole / 2)])) < 0)) {
                final int next = CallChecker.varInit(((int) (hole / 2)), "next", 392, 13149, 13284);
                if (CallChecker.beforeDeref(elements, null, 393, 13298, 13305)) {
                    if (CallChecker.beforeDeref(elements, null, 393, 13315, 13322)) {
                        elements[hole] = elements[next];
                        CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 393, 13298, 13329);
                    }
                }
                hole = next;
                CallChecker.varAssign(hole, "hole", 394, 13343, 13354);
            } 
            if (CallChecker.beforeDeref(elements, null, 396, 13374, 13381)) {
                elements[hole] = element;
                CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 396, 13374, 13398);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context525.methodEnd();
        }
    }

    protected void percolateUpMinHeap(final E element) {
        MethodContext _bcornu_methode_context526 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 406, 13411, 13700);
            CallChecker.varInit(element, "element", 406, 13411, 13700);
            CallChecker.varInit(this.comparator, "comparator", 406, 13411, 13700);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 406, 13411, 13700);
            CallChecker.varInit(this.size, "size", 406, 13411, 13700);
            CallChecker.varInit(this.elements, "elements", 406, 13411, 13700);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 406, 13411, 13700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 406, 13411, 13700);
            if (CallChecker.beforeDeref(elements, null, 407, 13634, 13641)) {
                elements[(++(size))] = element;
                CallChecker.varAssign(this.elements[this.size], "this.elements[this.size]", 407, 13634, 13660);
            }
            percolateUpMinHeap(size);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context526.methodEnd();
        }
    }

    protected void percolateUpMaxHeap(final int index) {
        MethodContext _bcornu_methode_context527 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 418, 13707, 14374);
            CallChecker.varInit(index, "index", 418, 13707, 14374);
            CallChecker.varInit(this.comparator, "comparator", 418, 13707, 14374);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 418, 13707, 14374);
            CallChecker.varInit(this.size, "size", 418, 13707, 14374);
            CallChecker.varInit(this.elements, "elements", 418, 13707, 14374);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 418, 13707, 14374);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 418, 13707, 14374);
            int hole = CallChecker.varInit(((int) (index)), "hole", 419, 13980, 13996);
            E element = CallChecker.init(null);
            if (CallChecker.beforeDeref(elements, null, 420, 14018, 14025)) {
                element = elements[hole];
                CallChecker.varAssign(element, "element", 420, 14018, 14025);
            }
            while ((hole > 1) && ((compare(element, elements[(hole / 2)])) > 0)) {
                final int next = CallChecker.varInit(((int) (hole / 2)), "next", 425, 14118, 14253);
                if (CallChecker.beforeDeref(elements, null, 426, 14267, 14274)) {
                    if (CallChecker.beforeDeref(elements, null, 426, 14284, 14291)) {
                        elements[hole] = elements[next];
                        CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 426, 14267, 14298);
                    }
                }
                hole = next;
                CallChecker.varAssign(hole, "hole", 427, 14312, 14323);
            } 
            if (CallChecker.beforeDeref(elements, null, 430, 14344, 14351)) {
                elements[hole] = element;
                CallChecker.varAssign(this.elements[hole], "this.elements[hole]", 430, 14344, 14368);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context527.methodEnd();
        }
    }

    protected void percolateUpMaxHeap(final E element) {
        MethodContext _bcornu_methode_context528 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 440, 14381, 14669);
            CallChecker.varInit(element, "element", 440, 14381, 14669);
            CallChecker.varInit(this.comparator, "comparator", 440, 14381, 14669);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 440, 14381, 14669);
            CallChecker.varInit(this.size, "size", 440, 14381, 14669);
            CallChecker.varInit(this.elements, "elements", 440, 14381, 14669);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 440, 14381, 14669);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 440, 14381, 14669);
            if (CallChecker.beforeDeref(elements, null, 441, 14603, 14610)) {
                elements[(++(size))] = element;
                CallChecker.varAssign(this.elements[this.size], "this.elements[this.size]", 441, 14603, 14629);
            }
            percolateUpMaxHeap(size);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context528.methodEnd();
        }
    }

    protected int compare(E a, E b) {
        MethodContext _bcornu_methode_context529 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 453, 14676, 15032);
            CallChecker.varInit(b, "b", 453, 14676, 15032);
            CallChecker.varInit(a, "a", 453, 14676, 15032);
            CallChecker.varInit(this.comparator, "comparator", 453, 14676, 15032);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 453, 14676, 15032);
            CallChecker.varInit(this.size, "size", 453, 14676, 15032);
            CallChecker.varInit(this.elements, "elements", 453, 14676, 15032);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 453, 14676, 15032);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 453, 14676, 15032);
            if (CallChecker.beforeDeref(comparator, Comparator.class, 454, 15002, 15011)) {
                comparator = CallChecker.beforeCalled(comparator, Comparator.class, 454, 15002, 15011);
                return CallChecker.isCalled(comparator, Comparator.class, 454, 15002, 15011).compare(a, b);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context529.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected void grow() {
        MethodContext _bcornu_methode_context530 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 461, 15039, 15344);
            CallChecker.varInit(this.comparator, "comparator", 461, 15039, 15344);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 461, 15039, 15344);
            CallChecker.varInit(this.size, "size", 461, 15039, 15344);
            CallChecker.varInit(this.elements, "elements", 461, 15039, 15344);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 461, 15039, 15344);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 461, 15039, 15344);
            elements = CallChecker.beforeCalled(elements, null, 462, 15226, 15233);
            final E[] array = CallChecker.varInit(((E[]) (new Object[(CallChecker.isCalled(elements, null, 462, 15226, 15233).length) * 2])), "array", 462, 15191, 15246);
            if (CallChecker.beforeDeref(elements, null, 463, 15296, 15303)) {
                elements = CallChecker.beforeCalled(elements, null, 463, 15296, 15303);
                System.arraycopy(elements, 0, array, 0, CallChecker.isCalled(elements, null, 463, 15296, 15303).length);
            }
            elements = array;
            CallChecker.varAssign(this.elements, "this.elements", 464, 15322, 15338);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context530.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context534 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 474, 15351, 17474);
            CallChecker.varInit(this.comparator, "comparator", 474, 15351, 17474);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 474, 15351, 17474);
            CallChecker.varInit(this.size, "size", 474, 15351, 17474);
            CallChecker.varInit(this.elements, "elements", 474, 15351, 17474);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 474, 15351, 17474);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 474, 15351, 17474);
            return new Iterator<E>() {
                private int index = 1;

                private int lastReturnedIndex = -1;

                public boolean hasNext() {
                    MethodContext _bcornu_methode_context531 = new MethodContext(boolean.class);
                    try {
                        CallChecker.varInit(this, "this", 480, 15737, 15814);
                        return (index) <= (size);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context531.methodEnd();
                    }
                }

                public E next() {
                    if (!(hasNext())) {
                        throw new NoSuchElementException();
                    }
                    lastReturnedIndex = index;
                    CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 488, 15971, 15996);
                    (index)++;
                    if (CallChecker.beforeDeref(elements, null, 490, 16046, 16053)) {
                        return elements[lastReturnedIndex];
                    }else
                        throw new AbnormalExecutionError();
                    
                }

                public void remove() {
                    MethodContext _bcornu_methode_context533 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 493, 16102, 17456);
                        if ((lastReturnedIndex) == (-1)) {
                            throw new IllegalStateException();
                        }
                        if (CallChecker.beforeDeref(elements, null, 497, 16261, 16268)) {
                            if (CallChecker.beforeDeref(elements, null, 497, 16293, 16300)) {
                                elements[lastReturnedIndex] = elements[size];
                                CallChecker.varAssign(PriorityBuffer.this.elements[this.lastReturnedIndex], "this.elements[this.lastReturnedIndex]", 497, 16261, 16309);
                            }
                        }
                        if (CallChecker.beforeDeref(elements, null, 498, 16327, 16334)) {
                            elements[size] = null;
                            CallChecker.varAssign(PriorityBuffer.this.elements[PriorityBuffer.this.size], "this.elements[this.size]", 498, 16327, 16350);
                        }
                        (size)--;
                        if (((size) != 0) && ((lastReturnedIndex) <= (size))) {
                            int compareToParent = CallChecker.varInit(((int) (0)), "compareToParent", 501, 16460, 16483);
                            if ((lastReturnedIndex) > 1) {
                                if (CallChecker.beforeDeref(elements, null, 503, 16584, 16591)) {
                                    if (CallChecker.beforeDeref(elements, null, 504, 16642, 16649)) {
                                        compareToParent = compare(elements[lastReturnedIndex], elements[((lastReturnedIndex) / 2)]);
                                        CallChecker.varAssign(compareToParent, "compareToParent", 503, 16558, 16674);
                                    }
                                }
                            }
                            if (ascendingOrder) {
                                if (((lastReturnedIndex) > 1) && (compareToParent < 0)) {
                                    percolateUpMinHeap(lastReturnedIndex);
                                }else {
                                    percolateDownMinHeap(lastReturnedIndex);
                                }
                            }else {
                                if (((lastReturnedIndex) > 1) && (compareToParent > 0)) {
                                    percolateUpMaxHeap(lastReturnedIndex);
                                }else {
                                    percolateDownMaxHeap(lastReturnedIndex);
                                }
                            }
                        }
                        (index)--;
                        lastReturnedIndex = -1;
                        CallChecker.varAssign(this.lastReturnedIndex, "this.lastReturnedIndex", 521, 17419, 17441);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context533.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context534.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context535 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 534, 17481, 18042);
            CallChecker.varInit(this.comparator, "comparator", 534, 17481, 18042);
            CallChecker.varInit(this.ascendingOrder, "ascendingOrder", 534, 17481, 18042);
            CallChecker.varInit(this.size, "size", 534, 17481, 18042);
            CallChecker.varInit(this.elements, "elements", 534, 17481, 18042);
            CallChecker.varInit(DEFAULT_CAPACITY, "org.apache.commons.collections.buffer.PriorityBuffer.DEFAULT_CAPACITY", 534, 17481, 18042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.PriorityBuffer.serialVersionUID", 534, 17481, 18042);
            final StringBuilder sb = CallChecker.varInit(new StringBuilder(), "sb", 535, 17744, 17788);
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 537, 17799, 17800)) {
                CallChecker.isCalled(sb, StringBuilder.class, 537, 17799, 17800).append("[ ");
            }
            for (int i = 1; i < ((size) + 1); i++) {
                if (i != 1) {
                    if (CallChecker.beforeDeref(sb, StringBuilder.class, 541, 17904, 17905)) {
                        CallChecker.isCalled(sb, StringBuilder.class, 541, 17904, 17905).append(", ");
                    }
                }
                if (CallChecker.beforeDeref(elements, null, 543, 17957, 17964)) {
                    if (CallChecker.beforeDeref(sb, StringBuilder.class, 543, 17947, 17948)) {
                        CallChecker.isCalled(sb, StringBuilder.class, 543, 17947, 17948).append(elements[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 546, 17990, 17991)) {
                CallChecker.isCalled(sb, StringBuilder.class, 546, 17990, 17991).append(" ]");
            }
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 548, 18023, 18024)) {
                return CallChecker.isCalled(sb, StringBuilder.class, 548, 18023, 18024).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context535.methodEnd();
        }
    }
}

