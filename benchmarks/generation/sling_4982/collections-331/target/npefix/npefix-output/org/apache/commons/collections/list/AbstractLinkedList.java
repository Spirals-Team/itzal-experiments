package org.apache.commons.collections.list;

import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ConcurrentModificationException;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.lang.reflect.Array;
import java.util.AbstractList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.collections.OrderedIterator;

public abstract class AbstractLinkedList<E> implements List<E> {
    protected transient AbstractLinkedList.Node<E> header;

    protected transient int size;

    protected transient int modCount;

    protected AbstractLinkedList() {
        super();
        MethodContext _bcornu_methode_context21 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    protected AbstractLinkedList(Collection<? extends E> coll) {
        super();
        MethodContext _bcornu_methode_context22 = new MethodContext(null);
        try {
            init();
            addAll(coll);
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    protected void init() {
        MethodContext _bcornu_methode_context87 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 101, 3231, 3572);
            CallChecker.varInit(this.modCount, "modCount", 101, 3231, 3572);
            CallChecker.varInit(this.size, "size", 101, 3231, 3572);
            CallChecker.varInit(this.header, "header", 101, 3231, 3572);
            header = createHeaderNode();
            CallChecker.varAssign(this.header, "this.header", 102, 3539, 3566);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context88 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 106, 3579, 3702);
            CallChecker.varInit(this.modCount, "modCount", 106, 3579, 3702);
            CallChecker.varInit(this.size, "size", 106, 3579, 3702);
            CallChecker.varInit(this.header, "header", 106, 3579, 3702);
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context89 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 110, 3709, 3770);
            CallChecker.varInit(this.modCount, "modCount", 110, 3709, 3770);
            CallChecker.varInit(this.size, "size", 110, 3709, 3770);
            CallChecker.varInit(this.header, "header", 110, 3709, 3770);
            return (size()) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public E get(int index) {
        AbstractLinkedList.Node<E> node = CallChecker.varInit(getNode(index, false), "node", 115, 3811, 3847);
        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 116, 3864, 3867)) {
            return node.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context91 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 120, 3892, 4037);
            CallChecker.varInit(this.modCount, "modCount", 120, 3892, 4037);
            CallChecker.varInit(this.size, "size", 120, 3892, 4037);
            CallChecker.varInit(this.header, "header", 120, 3892, 4037);
            return listIterator();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context92 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 124, 4044, 4139);
            CallChecker.varInit(this.modCount, "modCount", 124, 4044, 4139);
            CallChecker.varInit(this.size, "size", 124, 4044, 4139);
            CallChecker.varInit(this.header, "header", 124, 4044, 4139);
            return new AbstractLinkedList.LinkedListIterator<E>(this, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    public ListIterator<E> listIterator(int fromIndex) {
        MethodContext _bcornu_methode_context93 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 128, 4146, 4262);
            CallChecker.varInit(fromIndex, "fromIndex", 128, 4146, 4262);
            CallChecker.varInit(this.modCount, "modCount", 128, 4146, 4262);
            CallChecker.varInit(this.size, "size", 128, 4146, 4262);
            CallChecker.varInit(this.header, "header", 128, 4146, 4262);
            return new AbstractLinkedList.LinkedListIterator<E>(this, fromIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    public int indexOf(Object value) {
        MethodContext _bcornu_methode_context94 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 133, 4269, 4624);
            CallChecker.varInit(value, "value", 133, 4269, 4624);
            CallChecker.varInit(this.modCount, "modCount", 133, 4269, 4624);
            CallChecker.varInit(this.size, "size", 133, 4269, 4624);
            CallChecker.varInit(this.header, "header", 133, 4269, 4624);
            int i = CallChecker.varInit(((int) (0)), "i", 134, 4390, 4399);
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 135, 4429, 4434);
            for (AbstractLinkedList.Node<E> node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 135, 4429, 4434).next; node != (header); node = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 135, 4465, 4468).next) {
                CallChecker.varAssign(node, "node", 135, 4458, 4473);
                if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 136, 4507, 4510)) {
                    if (isEqualValue(node.getValue(), value)) {
                        return i;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                i++;
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    public int lastIndexOf(Object value) {
        MethodContext _bcornu_methode_context95 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 144, 4631, 4927);
            CallChecker.varInit(value, "value", 144, 4631, 4927);
            CallChecker.varInit(this.modCount, "modCount", 144, 4631, 4927);
            CallChecker.varInit(this.size, "size", 144, 4631, 4927);
            CallChecker.varInit(this.header, "header", 144, 4631, 4927);
            int i = CallChecker.varInit(((int) ((this.size) - 1)), "i", 145, 4678, 4694);
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 146, 4724, 4729);
            for (AbstractLinkedList.Node<E> node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 146, 4724, 4729).previous; node != (header); node = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 146, 4764, 4767).previous) {
                CallChecker.varAssign(node, "node", 146, 4757, 4776);
                if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 147, 4810, 4813)) {
                    if (isEqualValue(node.getValue(), value)) {
                        return i;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                i--;
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    public boolean contains(Object value) {
        MethodContext _bcornu_methode_context96 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 155, 4934, 5015);
            CallChecker.varInit(value, "value", 155, 4934, 5015);
            CallChecker.varInit(this.modCount, "modCount", 155, 4934, 5015);
            CallChecker.varInit(this.size, "size", 155, 4934, 5015);
            CallChecker.varInit(this.header, "header", 155, 4934, 5015);
            return (indexOf(value)) != (-1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context97 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 159, 5022, 5214);
            CallChecker.varInit(coll, "coll", 159, 5022, 5214);
            CallChecker.varInit(this.modCount, "modCount", 159, 5022, 5214);
            CallChecker.varInit(this.size, "size", 159, 5022, 5214);
            CallChecker.varInit(this.header, "header", 159, 5022, 5214);
            if (CallChecker.beforeDeref(coll, boolean.class, 160, 5095, 5098)) {
                for (Object o : coll) {
                    if (!(contains(o))) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context97.methodEnd();
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context98 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 169, 5221, 5373);
            CallChecker.varInit(this.modCount, "modCount", 169, 5221, 5373);
            CallChecker.varInit(this.size, "size", 169, 5221, 5373);
            CallChecker.varInit(this.header, "header", 169, 5221, 5373);
            return toArray(new Object[size]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public <T> T[] toArray(T[] array) {
        MethodContext _bcornu_methode_context99 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 174, 5380, 6028);
            CallChecker.varInit(array, "array", 174, 5380, 6028);
            CallChecker.varInit(this.modCount, "modCount", 174, 5380, 6028);
            CallChecker.varInit(this.size, "size", 174, 5380, 6028);
            CallChecker.varInit(this.header, "header", 174, 5380, 6028);
            if (CallChecker.beforeDeref(array, null, 176, 5501, 5505)) {
                array = CallChecker.beforeCalled(array, null, 176, 5501, 5505);
                if ((CallChecker.isCalled(array, null, 176, 5501, 5505).length) < (size)) {
                    Class<?> componentType = CallChecker.init(Class.class);
                    if (CallChecker.beforeDeref(array, null, 177, 5561, 5565)) {
                        array = CallChecker.beforeCalled(array, null, 177, 5561, 5565);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 177, 5561, 5565).getClass(), Class.class, 177, 5561, 5576)) {
                            array = CallChecker.beforeCalled(array, null, 177, 5561, 5565);
                            componentType = CallChecker.isCalled(CallChecker.isCalled(array, null, 177, 5561, 5565).getClass(), Class.class, 177, 5561, 5576).getComponentType();
                            CallChecker.varAssign(componentType, "componentType", 177, 5561, 5565);
                        }
                    }
                    array = ((T[]) (Array.newInstance(componentType, size)));
                    CallChecker.varAssign(array, "array", 178, 5610, 5662);
                }
            }else
                throw new AbnormalExecutionError();
            
            int i = CallChecker.varInit(((int) (0)), "i", 181, 5724, 5733);
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 182, 5763, 5768);
            for (AbstractLinkedList.Node<E> node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 182, 5763, 5768).next; node != (header); node = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 182, 5799, 5802).next , i++) {
                CallChecker.varAssign(node, "node", 182, 5792, 5807);
                if (CallChecker.beforeDeref(array, null, 183, 5829, 5833)) {
                    if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 183, 5844, 5847)) {
                        array[i] = ((T) (node.getValue()));
                        CallChecker.varAssign(array[i], "array[i]", 183, 5829, 5859);
                    }
                }
            }
            if (CallChecker.beforeDeref(array, null, 186, 5937, 5941)) {
                array = CallChecker.beforeCalled(array, null, 186, 5937, 5941);
                if ((CallChecker.isCalled(array, null, 186, 5937, 5941).length) > (size)) {
                    if (CallChecker.beforeDeref(array, null, 187, 5972, 5976)) {
                        array[size] = null;
                        CallChecker.varAssign(array[this.size], "array[this.size]", 187, 5972, 5990);
                    }
                }
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    public List<E> subList(int fromIndexInclusive, int toIndexExclusive) {
        MethodContext _bcornu_methode_context100 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 199, 6035, 6395);
            CallChecker.varInit(toIndexExclusive, "toIndexExclusive", 199, 6035, 6395);
            CallChecker.varInit(fromIndexInclusive, "fromIndexInclusive", 199, 6035, 6395);
            CallChecker.varInit(this.modCount, "modCount", 199, 6035, 6395);
            CallChecker.varInit(this.size, "size", 199, 6035, 6395);
            CallChecker.varInit(this.header, "header", 199, 6035, 6395);
            return new AbstractLinkedList.LinkedSubList<E>(this, fromIndexInclusive, toIndexExclusive);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    public boolean add(E value) {
        MethodContext _bcornu_methode_context101 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 204, 6402, 6559);
            CallChecker.varInit(value, "value", 204, 6402, 6559);
            CallChecker.varInit(this.modCount, "modCount", 204, 6402, 6559);
            CallChecker.varInit(this.size, "size", 204, 6402, 6559);
            CallChecker.varInit(this.header, "header", 204, 6402, 6559);
            addLast(value);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }

    public void add(int index, E value) {
        MethodContext _bcornu_methode_context102 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 209, 6566, 6689);
            CallChecker.varInit(value, "value", 209, 6566, 6689);
            CallChecker.varInit(index, "index", 209, 6566, 6689);
            CallChecker.varInit(this.modCount, "modCount", 209, 6566, 6689);
            CallChecker.varInit(this.size, "size", 209, 6566, 6689);
            CallChecker.varInit(this.header, "header", 209, 6566, 6689);
            AbstractLinkedList.Node<E> node = CallChecker.varInit(getNode(index, true), "node", 210, 6612, 6647);
            addNodeBefore(node, value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context103 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 214, 6696, 6789);
            CallChecker.varInit(coll, "coll", 214, 6696, 6789);
            CallChecker.varInit(this.modCount, "modCount", 214, 6696, 6789);
            CallChecker.varInit(this.size, "size", 214, 6696, 6789);
            CallChecker.varInit(this.header, "header", 214, 6696, 6789);
            return addAll(size, coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context104 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 218, 6796, 7004);
            CallChecker.varInit(coll, "coll", 218, 6796, 7004);
            CallChecker.varInit(index, "index", 218, 6796, 7004);
            CallChecker.varInit(this.modCount, "modCount", 218, 6796, 7004);
            CallChecker.varInit(this.size, "size", 218, 6796, 7004);
            CallChecker.varInit(this.header, "header", 218, 6796, 7004);
            AbstractLinkedList.Node<E> node = CallChecker.varInit(getNode(index, true), "node", 219, 6869, 6904);
            if (CallChecker.beforeDeref(coll, boolean.class, 220, 6925, 6928)) {
                for (E e : coll) {
                    addNodeBefore(node, e);
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context104.methodEnd();
        }
    }

    public E remove(int index) {
        AbstractLinkedList.Node<E> node = CallChecker.varInit(getNode(index, false), "node", 228, 7126, 7162);
        E oldValue = CallChecker.init(null);
        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 229, 7185, 7188)) {
            oldValue = node.getValue();
            CallChecker.varAssign(oldValue, "oldValue", 229, 7185, 7188);
        }
        removeNode(node);
        return oldValue;
    }

    public boolean remove(Object value) {
        MethodContext _bcornu_methode_context106 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 234, 7264, 7548);
            CallChecker.varInit(value, "value", 234, 7264, 7548);
            CallChecker.varInit(this.modCount, "modCount", 234, 7264, 7548);
            CallChecker.varInit(this.size, "size", 234, 7264, 7548);
            CallChecker.varInit(this.header, "header", 234, 7264, 7548);
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 235, 7330, 7335);
            for (AbstractLinkedList.Node<E> node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 235, 7330, 7335).next; node != (header); node = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 235, 7366, 7369).next) {
                CallChecker.varAssign(node, "node", 235, 7359, 7374);
                if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 236, 7408, 7411)) {
                    if (isEqualValue(node.getValue(), value)) {
                        removeNode(node);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context106.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context107 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 244, 7555, 7863);
            CallChecker.varInit(coll, "coll", 244, 7555, 7863);
            CallChecker.varInit(this.modCount, "modCount", 244, 7555, 7863);
            CallChecker.varInit(this.size, "size", 244, 7555, 7863);
            CallChecker.varInit(this.header, "header", 244, 7555, 7863);
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 245, 7610, 7634);
            Iterator<E> it = CallChecker.varInit(iterator(), "it", 246, 7644, 7671);
            it = CallChecker.beforeCalled(it, Iterator.class, 247, 7688, 7689);
            while (CallChecker.isCalled(it, Iterator.class, 247, 7688, 7689).hasNext()) {
                if (CallChecker.beforeDeref(it, Iterator.class, 248, 7734, 7735)) {
                    if (CallChecker.beforeDeref(coll, Collection.class, 248, 7720, 7723)) {
                        coll = CallChecker.beforeCalled(coll, Collection.class, 248, 7720, 7723);
                        if (CallChecker.isCalled(coll, Collection.class, 248, 7720, 7723).contains(it.next())) {
                            if (CallChecker.beforeDeref(it, Iterator.class, 249, 7764, 7765)) {
                                it = CallChecker.beforeCalled(it, Iterator.class, 249, 7764, 7765);
                                CallChecker.isCalled(it, Iterator.class, 249, 7764, 7765).remove();
                            }
                            modified = true;
                            CallChecker.varAssign(modified, "modified", 250, 7793, 7808);
                        }
                    }
                }
            } 
            return modified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context108 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 257, 7870, 8265);
            CallChecker.varInit(coll, "coll", 257, 7870, 8265);
            CallChecker.varInit(this.modCount, "modCount", 257, 7870, 8265);
            CallChecker.varInit(this.size, "size", 257, 7870, 8265);
            CallChecker.varInit(this.header, "header", 257, 7870, 8265);
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 258, 8003, 8027);
            Iterator<E> it = CallChecker.varInit(iterator(), "it", 259, 8037, 8064);
            it = CallChecker.beforeCalled(it, Iterator.class, 260, 8081, 8082);
            while (CallChecker.isCalled(it, Iterator.class, 260, 8081, 8082).hasNext()) {
                if (CallChecker.beforeDeref(it, Iterator.class, 261, 8127, 8128)) {
                    if (CallChecker.beforeDeref(coll, Collection.class, 261, 8113, 8116)) {
                        coll = CallChecker.beforeCalled(coll, Collection.class, 261, 8113, 8116);
                        if ((CallChecker.isCalled(coll, Collection.class, 261, 8113, 8116).contains(it.next())) == false) {
                            if (CallChecker.beforeDeref(it, Iterator.class, 262, 8166, 8167)) {
                                it = CallChecker.beforeCalled(it, Iterator.class, 262, 8166, 8167);
                                CallChecker.isCalled(it, Iterator.class, 262, 8166, 8167).remove();
                            }
                            modified = true;
                            CallChecker.varAssign(modified, "modified", 263, 8195, 8210);
                        }
                    }
                }
            } 
            return modified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public E set(int index, E value) {
        AbstractLinkedList.Node<E> node = CallChecker.varInit(getNode(index, false), "node", 270, 8315, 8351);
        E oldValue = CallChecker.init(null);
        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 271, 8374, 8377)) {
            oldValue = node.getValue();
            CallChecker.varAssign(oldValue, "oldValue", 271, 8374, 8377);
        }
        updateNode(node, value);
        return oldValue;
    }

    public void clear() {
        MethodContext _bcornu_methode_context110 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 276, 8460, 8512);
            CallChecker.varInit(this.modCount, "modCount", 276, 8460, 8512);
            CallChecker.varInit(this.size, "size", 276, 8460, 8512);
            CallChecker.varInit(this.header, "header", 276, 8460, 8512);
            removeAllNodes();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context110.methodEnd();
        }
    }

    public E getFirst() {
        AbstractLinkedList.Node<E> node = CallChecker.init(AbstractLinkedList.Node.class);
        if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 282, 8642, 8647)) {
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 282, 8642, 8647);
            node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 282, 8642, 8647).next;
            CallChecker.varAssign(node, "node", 282, 8642, 8647);
        }
        if (node == (header)) {
            throw new NoSuchElementException();
        }
        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 286, 8758, 8761)) {
            return node.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E getLast() {
        AbstractLinkedList.Node<E> node = CallChecker.init(AbstractLinkedList.Node.class);
        if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 290, 8830, 8835)) {
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 290, 8830, 8835);
            node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 290, 8830, 8835).previous;
            CallChecker.varAssign(node, "node", 290, 8830, 8835);
        }
        if (node == (header)) {
            throw new NoSuchElementException();
        }
        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 294, 8950, 8953)) {
            return node.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public boolean addFirst(E o) {
        MethodContext _bcornu_methode_context113 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 297, 8978, 9067);
            CallChecker.varInit(o, "o", 297, 8978, 9067);
            CallChecker.varInit(this.modCount, "modCount", 297, 8978, 9067);
            CallChecker.varInit(this.size, "size", 297, 8978, 9067);
            CallChecker.varInit(this.header, "header", 297, 8978, 9067);
            addNodeAfter(header, o);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    public boolean addLast(E o) {
        MethodContext _bcornu_methode_context114 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 302, 9074, 9163);
            CallChecker.varInit(o, "o", 302, 9074, 9163);
            CallChecker.varInit(this.modCount, "modCount", 302, 9074, 9163);
            CallChecker.varInit(this.size, "size", 302, 9074, 9163);
            CallChecker.varInit(this.header, "header", 302, 9074, 9163);
            addNodeBefore(header, o);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    public E removeFirst() {
        AbstractLinkedList.Node<E> node = CallChecker.init(AbstractLinkedList.Node.class);
        if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 308, 9218, 9223)) {
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 308, 9218, 9223);
            node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 308, 9218, 9223).next;
            CallChecker.varAssign(node, "node", 308, 9218, 9223);
        }
        if (node == (header)) {
            throw new NoSuchElementException();
        }
        E oldValue = CallChecker.init(null);
        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 312, 9340, 9343)) {
            oldValue = node.getValue();
            CallChecker.varAssign(oldValue, "oldValue", 312, 9340, 9343);
        }
        removeNode(node);
        return oldValue;
    }

    public E removeLast() {
        AbstractLinkedList.Node<E> node = CallChecker.init(AbstractLinkedList.Node.class);
        if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 318, 9466, 9471)) {
            header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 318, 9466, 9471);
            node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 318, 9466, 9471).previous;
            CallChecker.varAssign(node, "node", 318, 9466, 9471);
        }
        if (node == (header)) {
            throw new NoSuchElementException();
        }
        E oldValue = CallChecker.init(null);
        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 322, 9592, 9595)) {
            oldValue = node.getValue();
            CallChecker.varAssign(oldValue, "oldValue", 322, 9592, 9595);
        }
        removeNode(node);
        return oldValue;
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context117 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 329, 9671, 10427);
            CallChecker.varInit(obj, "obj", 329, 9671, 10427);
            CallChecker.varInit(this.modCount, "modCount", 329, 9671, 10427);
            CallChecker.varInit(this.size, "size", 329, 9671, 10427);
            CallChecker.varInit(this.header, "header", 329, 9671, 10427);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof List) == false) {
                return false;
            }
            List<?> other = CallChecker.varInit(((List<?>) (obj)), "other", 336, 9949, 9978);
            if (CallChecker.beforeDeref(other, List.class, 337, 9992, 9996)) {
                other = CallChecker.beforeCalled(other, List.class, 337, 9992, 9996);
                if ((CallChecker.isCalled(other, List.class, 337, 9992, 9996).size()) != (size())) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            ListIterator<?> it1 = CallChecker.varInit(listIterator(), "it1", 340, 10062, 10098);
            ListIterator<?> it2 = CallChecker.init(ListIterator.class);
            if (CallChecker.beforeDeref(other, List.class, 341, 10130, 10134)) {
                other = CallChecker.beforeCalled(other, List.class, 341, 10130, 10134);
                it2 = CallChecker.isCalled(other, List.class, 341, 10130, 10134).listIterator();
                CallChecker.varAssign(it2, "it2", 341, 10130, 10134);
            }
            it1 = CallChecker.beforeCalled(it1, ListIterator.class, 342, 10167, 10169);
            it2 = CallChecker.beforeCalled(it2, ListIterator.class, 342, 10184, 10186);
            while ((CallChecker.isCalled(it1, ListIterator.class, 342, 10167, 10169).hasNext()) && (CallChecker.isCalled(it2, ListIterator.class, 342, 10184, 10186).hasNext())) {
                Object o1 = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(it1, ListIterator.class, 343, 10225, 10227)) {
                    o1 = it1.next();
                    CallChecker.varAssign(o1, "o1", 343, 10225, 10227);
                }
                Object o2 = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(it2, ListIterator.class, 344, 10261, 10263)) {
                    o2 = it2.next();
                    CallChecker.varAssign(o2, "o2", 344, 10261, 10263);
                }
                if (!(o1 == null ? o2 == null : o1.equals(o2)))
                    return false;
                
            } 
            it1 = CallChecker.beforeCalled(it1, ListIterator.class, 348, 10390, 10392);
            it2 = CallChecker.beforeCalled(it2, ListIterator.class, 348, 10407, 10409);
            return !((CallChecker.isCalled(it1, ListIterator.class, 348, 10390, 10392).hasNext()) || (CallChecker.isCalled(it2, ListIterator.class, 348, 10407, 10409).hasNext()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context118 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 352, 10434, 10635);
            CallChecker.varInit(this.modCount, "modCount", 352, 10434, 10635);
            CallChecker.varInit(this.size, "size", 352, 10434, 10635);
            CallChecker.varInit(this.header, "header", 352, 10434, 10635);
            int hashCode = CallChecker.varInit(((int) (1)), "hashCode", 353, 10480, 10496);
            for (E e : this) {
                if (e == null) {
                    hashCode = (31 * hashCode) + 0;
                    CallChecker.varAssign(hashCode, "hashCode", 355, 10537, 10594);
                }else {
                    hashCode = (31 * hashCode) + (e.hashCode());
                    CallChecker.varAssign(hashCode, "hashCode", 355, 10537, 10594);
                }
            }
            return hashCode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context119 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 361, 10642, 11222);
            CallChecker.varInit(this.modCount, "modCount", 361, 10642, 11222);
            CallChecker.varInit(this.size, "size", 361, 10642, 11222);
            CallChecker.varInit(this.header, "header", 361, 10642, 11222);
            if ((size()) == 0) {
                return "[]";
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder((16 * (size()))), "buf", 365, 10753, 10803);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 366, 10813, 10815)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 366, 10813, 10815);
                CallChecker.isCalled(buf, StringBuilder.class, 366, 10813, 10815).append("[");
            }
            Iterator<E> it = CallChecker.varInit(iterator(), "it", 368, 10839, 10866);
            boolean hasNext = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(it, Iterator.class, 369, 10894, 10895)) {
                it = CallChecker.beforeCalled(it, Iterator.class, 369, 10894, 10895);
                hasNext = CallChecker.isCalled(it, Iterator.class, 369, 10894, 10895).hasNext();
                CallChecker.varAssign(hasNext, "hasNext", 369, 10894, 10895);
            }
            while (hasNext) {
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 371, 10961, 10962)) {
                    value = it.next();
                    CallChecker.varAssign(value, "value", 371, 10961, 10962);
                }
                if (value == (this)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 372, 10984, 10986)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 372, 10984, 10986);
                        CallChecker.isCalled(buf, StringBuilder.class, 372, 10984, 10986).append("(this Collection)");
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 372, 10984, 10986)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 372, 10984, 10986);
                        CallChecker.isCalled(buf, StringBuilder.class, 372, 10984, 10986).append(value);
                    }
                }
                if (CallChecker.beforeDeref(it, Iterator.class, 373, 11063, 11064)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 373, 11063, 11064);
                    hasNext = CallChecker.isCalled(it, Iterator.class, 373, 11063, 11064).hasNext();
                    CallChecker.varAssign(hasNext, "hasNext", 373, 11053, 11075);
                }
                if (hasNext) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 375, 11120, 11122)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 375, 11120, 11122);
                        CallChecker.isCalled(buf, StringBuilder.class, 375, 11120, 11122).append(", ");
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 378, 11170, 11172)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 378, 11170, 11172);
                CallChecker.isCalled(buf, StringBuilder.class, 378, 11170, 11172).append("]");
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 379, 11202, 11204)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 379, 11202, 11204);
                return CallChecker.isCalled(buf, StringBuilder.class, 379, 11202, 11204).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context119.methodEnd();
        }
    }

    protected boolean isEqualValue(Object value1, Object value2) {
        MethodContext _bcornu_methode_context120 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 392, 11229, 11786);
            CallChecker.varInit(value2, "value2", 392, 11229, 11786);
            CallChecker.varInit(value1, "value1", 392, 11229, 11786);
            CallChecker.varInit(this.modCount, "modCount", 392, 11229, 11786);
            CallChecker.varInit(this.size, "size", 392, 11229, 11786);
            CallChecker.varInit(this.header, "header", 392, 11229, 11786);
            if ((value1 == null) || (CallChecker.beforeDeref(value1, Object.class, 393, 11757, 11762))) {
                value1 = CallChecker.beforeCalled(value1, Object.class, 393, 11757, 11762);
                return (value1 == value2) || ((value1 == null) ? false : CallChecker.isCalled(value1, Object.class, 393, 11757, 11762).equals(value2));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    protected void updateNode(AbstractLinkedList.Node<E> node, E value) {
        MethodContext _bcornu_methode_context121 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 404, 11793, 12134);
            CallChecker.varInit(value, "value", 404, 11793, 12134);
            CallChecker.varInit(node, "node", 404, 11793, 12134);
            CallChecker.varInit(this.modCount, "modCount", 404, 11793, 12134);
            CallChecker.varInit(this.size, "size", 404, 11793, 12134);
            CallChecker.varInit(this.header, "header", 404, 11793, 12134);
            if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 405, 12108, 12111)) {
                node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 405, 12108, 12111);
                CallChecker.isCalled(node, AbstractLinkedList.Node.class, 405, 12108, 12111).setValue(value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    protected AbstractLinkedList.Node<E> createHeaderNode() {
        MethodContext _bcornu_methode_context122 = new MethodContext(AbstractLinkedList.Node.class);
        try {
            CallChecker.varInit(this, "this", 415, 12141, 12465);
            CallChecker.varInit(this.modCount, "modCount", 415, 12141, 12465);
            CallChecker.varInit(this.size, "size", 415, 12141, 12465);
            CallChecker.varInit(this.header, "header", 415, 12141, 12465);
            return new AbstractLinkedList.Node<E>();
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    protected AbstractLinkedList.Node<E> createNode(E value) {
        MethodContext _bcornu_methode_context123 = new MethodContext(AbstractLinkedList.Node.class);
        try {
            CallChecker.varInit(this, "this", 426, 12472, 12796);
            CallChecker.varInit(value, "value", 426, 12472, 12796);
            CallChecker.varInit(this.modCount, "modCount", 426, 12472, 12796);
            CallChecker.varInit(this.size, "size", 426, 12472, 12796);
            CallChecker.varInit(this.header, "header", 426, 12472, 12796);
            return new AbstractLinkedList.Node<E>(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context123.methodEnd();
        }
    }

    protected void addNodeBefore(AbstractLinkedList.Node<E> node, E value) {
        MethodContext _bcornu_methode_context124 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 441, 12803, 13394);
            CallChecker.varInit(value, "value", 441, 12803, 13394);
            CallChecker.varInit(node, "node", 441, 12803, 13394);
            CallChecker.varInit(this.modCount, "modCount", 441, 12803, 13394);
            CallChecker.varInit(this.size, "size", 441, 12803, 13394);
            CallChecker.varInit(this.header, "header", 441, 12803, 13394);
            AbstractLinkedList.Node<E> newNode = CallChecker.varInit(createNode(value), "newNode", 442, 13321, 13356);
            addNode(newNode, node);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    protected void addNodeAfter(AbstractLinkedList.Node<E> node, E value) {
        MethodContext _bcornu_methode_context125 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 457, 13401, 13994);
            CallChecker.varInit(value, "value", 457, 13401, 13994);
            CallChecker.varInit(node, "node", 457, 13401, 13994);
            CallChecker.varInit(this.modCount, "modCount", 457, 13401, 13994);
            CallChecker.varInit(this.size, "size", 457, 13401, 13994);
            CallChecker.varInit(this.header, "header", 457, 13401, 13994);
            AbstractLinkedList.Node<E> newNode = CallChecker.varInit(createNode(value), "newNode", 458, 13916, 13951);
            if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 459, 13978, 13981)) {
                node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 459, 13978, 13981);
                addNode(newNode, CallChecker.isCalled(node, AbstractLinkedList.Node.class, 459, 13978, 13981).next);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    protected void addNode(AbstractLinkedList.Node<E> nodeToInsert, AbstractLinkedList.Node<E> insertBeforeNode) {
        MethodContext _bcornu_methode_context126 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 469, 14001, 14548);
            CallChecker.varInit(insertBeforeNode, "insertBeforeNode", 469, 14001, 14548);
            CallChecker.varInit(nodeToInsert, "nodeToInsert", 469, 14001, 14548);
            CallChecker.varInit(this.modCount, "modCount", 469, 14001, 14548);
            CallChecker.varInit(this.size, "size", 469, 14001, 14548);
            CallChecker.varInit(this.header, "header", 469, 14001, 14548);
            if (CallChecker.beforeDeref(nodeToInsert, AbstractLinkedList.Node.class, 470, 14306, 14317)) {
                nodeToInsert = CallChecker.beforeCalled(nodeToInsert, AbstractLinkedList.Node.class, 470, 14306, 14317);
                CallChecker.isCalled(nodeToInsert, AbstractLinkedList.Node.class, 470, 14306, 14317).next = insertBeforeNode;
                CallChecker.varAssign(CallChecker.isCalled(nodeToInsert, AbstractLinkedList.Node.class, 470, 14306, 14317).next, "CallChecker.isCalled(nodeToInsert, AbstractLinkedList.Node.class, 470, 14306, 14317).next", 470, 14306, 14342);
            }
            if (CallChecker.beforeDeref(nodeToInsert, AbstractLinkedList.Node.class, 471, 14352, 14363)) {
                if (CallChecker.beforeDeref(insertBeforeNode, AbstractLinkedList.Node.class, 471, 14376, 14391)) {
                    nodeToInsert = CallChecker.beforeCalled(nodeToInsert, AbstractLinkedList.Node.class, 471, 14352, 14363);
                    insertBeforeNode = CallChecker.beforeCalled(insertBeforeNode, AbstractLinkedList.Node.class, 471, 14376, 14391);
                    CallChecker.isCalled(nodeToInsert, AbstractLinkedList.Node.class, 471, 14352, 14363).previous = CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 471, 14376, 14391).previous;
                    CallChecker.varAssign(CallChecker.isCalled(nodeToInsert, AbstractLinkedList.Node.class, 471, 14352, 14363).previous, "CallChecker.isCalled(nodeToInsert, AbstractLinkedList.Node.class, 471, 14352, 14363).previous", 471, 14352, 14401);
                }
            }
            if (CallChecker.beforeDeref(insertBeforeNode, AbstractLinkedList.Node.class, 472, 14411, 14426)) {
                insertBeforeNode = CallChecker.beforeCalled(insertBeforeNode, AbstractLinkedList.Node.class, 472, 14411, 14426);
                if (CallChecker.beforeDeref(CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 472, 14411, 14426).previous, AbstractLinkedList.Node.class, 472, 14411, 14435)) {
                    insertBeforeNode = CallChecker.beforeCalled(insertBeforeNode, AbstractLinkedList.Node.class, 472, 14411, 14426);
                    CallChecker.isCalled(CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 472, 14411, 14426).previous, AbstractLinkedList.Node.class, 472, 14411, 14435).next = nodeToInsert;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 472, 14411, 14426).previous, AbstractLinkedList.Node.class, 472, 14411, 14435).next, "CallChecker.isCalled(CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 472, 14411, 14426).previous, AbstractLinkedList.Node.class, 472, 14411, 14435).next", 472, 14411, 14456);
                }
            }
            if (CallChecker.beforeDeref(insertBeforeNode, AbstractLinkedList.Node.class, 473, 14466, 14481)) {
                insertBeforeNode = CallChecker.beforeCalled(insertBeforeNode, AbstractLinkedList.Node.class, 473, 14466, 14481);
                CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 473, 14466, 14481).previous = nodeToInsert;
                CallChecker.varAssign(CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 473, 14466, 14481).previous, "CallChecker.isCalled(insertBeforeNode, AbstractLinkedList.Node.class, 473, 14466, 14481).previous", 473, 14466, 14506);
            }
            (size)++;
            (modCount)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context126.methodEnd();
        }
    }

    protected void removeNode(AbstractLinkedList.Node<E> node) {
        MethodContext _bcornu_methode_context127 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 484, 14555, 14897);
            CallChecker.varInit(node, "node", 484, 14555, 14897);
            CallChecker.varInit(this.modCount, "modCount", 484, 14555, 14897);
            CallChecker.varInit(this.size, "size", 484, 14555, 14897);
            CallChecker.varInit(this.header, "header", 484, 14555, 14897);
            if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 485, 14781, 14784)) {
                node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 485, 14781, 14784);
                if (CallChecker.beforeDeref(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 485, 14781, 14784).previous, AbstractLinkedList.Node.class, 485, 14781, 14793)) {
                    if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 485, 14802, 14805)) {
                        node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 485, 14781, 14784);
                        node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 485, 14802, 14805);
                        CallChecker.isCalled(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 485, 14781, 14784).previous, AbstractLinkedList.Node.class, 485, 14781, 14793).next = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 485, 14802, 14805).next;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 485, 14781, 14784).previous, AbstractLinkedList.Node.class, 485, 14781, 14793).next, "CallChecker.isCalled(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 485, 14781, 14784).previous, AbstractLinkedList.Node.class, 485, 14781, 14793).next", 485, 14781, 14811);
                    }
                }
            }
            if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 486, 14821, 14824)) {
                node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 486, 14821, 14824);
                if (CallChecker.beforeDeref(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 486, 14821, 14824).next, AbstractLinkedList.Node.class, 486, 14821, 14829)) {
                    if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 486, 14842, 14845)) {
                        node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 486, 14821, 14824);
                        node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 486, 14842, 14845);
                        CallChecker.isCalled(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 486, 14821, 14824).next, AbstractLinkedList.Node.class, 486, 14821, 14829).previous = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 486, 14842, 14845).previous;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 486, 14821, 14824).next, AbstractLinkedList.Node.class, 486, 14821, 14829).previous, "CallChecker.isCalled(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 486, 14821, 14824).next, AbstractLinkedList.Node.class, 486, 14821, 14829).previous", 486, 14821, 14855);
                    }
                }
            }
            (size)--;
            (modCount)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }

    protected void removeAllNodes() {
        MethodContext _bcornu_methode_context128 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 494, 14904, 15124);
            CallChecker.varInit(this.modCount, "modCount", 494, 14904, 15124);
            CallChecker.varInit(this.size, "size", 494, 14904, 15124);
            CallChecker.varInit(this.header, "header", 494, 14904, 15124);
            if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 495, 15026, 15031)) {
                header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 495, 15026, 15031);
                CallChecker.isCalled(header, AbstractLinkedList.Node.class, 495, 15026, 15031).next = header;
                CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedList.Node.class, 495, 15026, 15031).next, "CallChecker.isCalled(this.header, AbstractLinkedList.Node.class, 495, 15026, 15031).next", 495, 15026, 15046);
            }
            if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 496, 15056, 15061)) {
                header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 496, 15056, 15061);
                CallChecker.isCalled(header, AbstractLinkedList.Node.class, 496, 15056, 15061).previous = header;
                CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedList.Node.class, 496, 15056, 15061).previous, "CallChecker.isCalled(this.header, AbstractLinkedList.Node.class, 496, 15056, 15061).previous", 496, 15056, 15080);
            }
            size = 0;
            CallChecker.varAssign(this.size, "this.size", 497, 15090, 15098);
            (modCount)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    protected AbstractLinkedList.Node<E> getNode(int index, boolean endMarkerAllowed) throws IndexOutOfBoundsException {
        MethodContext _bcornu_methode_context129 = new MethodContext(AbstractLinkedList.Node.class);
        try {
            CallChecker.varInit(this, "this", 511, 15131, 16848);
            CallChecker.varInit(endMarkerAllowed, "endMarkerAllowed", 511, 15131, 16848);
            CallChecker.varInit(index, "index", 511, 15131, 16848);
            CallChecker.varInit(this.modCount, "modCount", 511, 15131, 16848);
            CallChecker.varInit(this.size, "size", 511, 15131, 16848);
            CallChecker.varInit(this.header, "header", 511, 15131, 16848);
            if (index < 0) {
                throw new IndexOutOfBoundsException(((("Couldn't get the node: " + "index (") + index) + ") less than zero."));
            }
            if ((!endMarkerAllowed) && (index == (size))) {
                throw new IndexOutOfBoundsException(((("Couldn't get the node: " + "index (") + index) + ") is the size of the list."));
            }
            if (index > (size)) {
                throw new IndexOutOfBoundsException((((((("Couldn't get the node: " + "index (") + index) + ") greater than the size of the ") + "list (") + (size)) + ")."));
            }
            AbstractLinkedList.Node<E> node = CallChecker.init(AbstractLinkedList.Node.class);
            if (index < ((size) / 2)) {
                if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 530, 16463, 16468)) {
                    header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 530, 16463, 16468);
                    node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 530, 16463, 16468).next;
                    CallChecker.varAssign(node, "node", 530, 16456, 16474);
                }
                for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                    if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 532, 16578, 16581)) {
                        node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 532, 16578, 16581);
                        node = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 532, 16578, 16581).next;
                        CallChecker.varAssign(node, "node", 532, 16571, 16587);
                    }
                }
            }else {
                node = header;
                CallChecker.varAssign(node, "node", 536, 16664, 16677);
                for (int currentIndex = size; currentIndex > index; currentIndex--) {
                    if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 538, 16784, 16787)) {
                        node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 538, 16784, 16787);
                        node = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 538, 16784, 16787).previous;
                        CallChecker.varAssign(node, "node", 538, 16777, 16797);
                    }
                }
            }
            return node;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    protected Iterator<E> createSubListIterator(AbstractLinkedList.LinkedSubList<E> subList) {
        MethodContext _bcornu_methode_context130 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 550, 16855, 17188);
            CallChecker.varInit(subList, "subList", 550, 16855, 17188);
            CallChecker.varInit(this.modCount, "modCount", 550, 16855, 17188);
            CallChecker.varInit(this.size, "size", 550, 16855, 17188);
            CallChecker.varInit(this.header, "header", 550, 16855, 17188);
            return createSubListListIterator(subList, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    protected ListIterator<E> createSubListListIterator(AbstractLinkedList.LinkedSubList<E> subList, int fromIndex) {
        MethodContext _bcornu_methode_context131 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 560, 17195, 17562);
            CallChecker.varInit(fromIndex, "fromIndex", 560, 17195, 17562);
            CallChecker.varInit(subList, "subList", 560, 17195, 17562);
            CallChecker.varInit(this.modCount, "modCount", 560, 17195, 17562);
            CallChecker.varInit(this.size, "size", 560, 17195, 17562);
            CallChecker.varInit(this.header, "header", 560, 17195, 17562);
            return new AbstractLinkedList.LinkedSubListIterator<E>(subList, fromIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }

    protected void doWriteObject(ObjectOutputStream outputStream) throws IOException {
        MethodContext _bcornu_methode_context132 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 571, 17569, 18157);
            CallChecker.varInit(outputStream, "outputStream", 571, 17569, 18157);
            CallChecker.varInit(this.modCount, "modCount", 571, 17569, 18157);
            CallChecker.varInit(this.size, "size", 571, 17569, 18157);
            CallChecker.varInit(this.header, "header", 571, 17569, 18157);
            if (CallChecker.beforeDeref(outputStream, ObjectOutputStream.class, 573, 18001, 18012)) {
                outputStream = CallChecker.beforeCalled(outputStream, ObjectOutputStream.class, 573, 18001, 18012);
                CallChecker.isCalled(outputStream, ObjectOutputStream.class, 573, 18001, 18012).writeInt(size());
            }
            for (Iterator<E> itr = iterator(); CallChecker.isCalled(itr, Iterator.class, 574, 18075, 18077).hasNext();) {
                if (CallChecker.beforeDeref(itr, Iterator.class, 575, 18130, 18132)) {
                    if (CallChecker.beforeDeref(outputStream, ObjectOutputStream.class, 575, 18105, 18116)) {
                        outputStream = CallChecker.beforeCalled(outputStream, ObjectOutputStream.class, 575, 18105, 18116);
                        CallChecker.isCalled(outputStream, ObjectOutputStream.class, 575, 18105, 18116).writeObject(itr.next());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected void doReadObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context133 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 586, 18164, 18662);
            CallChecker.varInit(inputStream, "inputStream", 586, 18164, 18662);
            CallChecker.varInit(this.modCount, "modCount", 586, 18164, 18662);
            CallChecker.varInit(this.size, "size", 586, 18164, 18662);
            CallChecker.varInit(this.header, "header", 586, 18164, 18662);
            init();
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(inputStream, ObjectInputStream.class, 588, 18537, 18547)) {
                inputStream = CallChecker.beforeCalled(inputStream, ObjectInputStream.class, 588, 18537, 18547);
                size = CallChecker.isCalled(inputStream, ObjectInputStream.class, 588, 18537, 18547).readInt();
                CallChecker.varAssign(size, "size", 588, 18537, 18547);
            }
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(inputStream, ObjectInputStream.class, 590, 18621, 18631)) {
                    inputStream = CallChecker.beforeCalled(inputStream, ObjectInputStream.class, 590, 18621, 18631);
                    add(((E) (CallChecker.isCalled(inputStream, ObjectInputStream.class, 590, 18621, 18631).readObject())));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    protected static class Node<E> {
        protected AbstractLinkedList.Node<E> previous;

        protected AbstractLinkedList.Node<E> next;

        protected E value;

        protected Node() {
            super();
            MethodContext _bcornu_methode_context23 = new MethodContext(null);
            try {
                previous = this;
                CallChecker.varAssign(this.previous, "this.previous", 615, 19351, 19366);
                next = this;
                CallChecker.varAssign(this.next, "this.next", 616, 19380, 19391);
            } finally {
                _bcornu_methode_context23.methodEnd();
            }
        }

        protected Node(E value) {
            super();
            MethodContext _bcornu_methode_context24 = new MethodContext(null);
            try {
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 626, 19584, 19602);
            } finally {
                _bcornu_methode_context24.methodEnd();
            }
        }

        protected Node(AbstractLinkedList.Node<E> previous, AbstractLinkedList.Node<E> next, E value) {
            super();
            MethodContext _bcornu_methode_context25 = new MethodContext(null);
            try {
                this.previous = previous;
                CallChecker.varAssign(this.previous, "this.previous", 638, 19935, 19959);
                this.next = next;
                CallChecker.varAssign(this.next, "this.next", 639, 19973, 19989);
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 640, 20003, 20021);
            } finally {
                _bcornu_methode_context25.methodEnd();
            }
        }

        protected E getValue() {
            return value;
        }

        protected void setValue(E value) {
            MethodContext _bcornu_methode_context135 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 659, 20257, 20483);
                CallChecker.varInit(value, "value", 659, 20257, 20483);
                CallChecker.varInit(this.value, "value", 659, 20257, 20483);
                CallChecker.varInit(this.next, "next", 659, 20257, 20483);
                CallChecker.varInit(this.previous, "previous", 659, 20257, 20483);
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 660, 20455, 20473);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context135.methodEnd();
            }
        }

        protected AbstractLinkedList.Node<E> getPreviousNode() {
            MethodContext _bcornu_methode_context136 = new MethodContext(AbstractLinkedList.Node.class);
            try {
                CallChecker.varInit(this, "this", 669, 20494, 20718);
                CallChecker.varInit(this.value, "value", 669, 20494, 20718);
                CallChecker.varInit(this.next, "next", 669, 20494, 20718);
                CallChecker.varInit(this.previous, "previous", 669, 20494, 20718);
                return previous;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context136.methodEnd();
            }
        }

        protected void setPreviousNode(AbstractLinkedList.Node<E> previous) {
            MethodContext _bcornu_methode_context137 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 679, 20729, 20984);
                CallChecker.varInit(previous, "previous", 679, 20729, 20984);
                CallChecker.varInit(this.value, "value", 679, 20729, 20984);
                CallChecker.varInit(this.next, "next", 679, 20729, 20984);
                CallChecker.varInit(this.previous, "previous", 679, 20729, 20984);
                this.previous = previous;
                CallChecker.varAssign(this.previous, "this.previous", 680, 20950, 20974);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context137.methodEnd();
            }
        }

        protected AbstractLinkedList.Node<E> getNextNode() {
            MethodContext _bcornu_methode_context138 = new MethodContext(AbstractLinkedList.Node.class);
            try {
                CallChecker.varInit(this, "this", 689, 20995, 21203);
                CallChecker.varInit(this.value, "value", 689, 20995, 21203);
                CallChecker.varInit(this.next, "next", 689, 20995, 21203);
                CallChecker.varInit(this.previous, "previous", 689, 20995, 21203);
                return next;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context138.methodEnd();
            }
        }

        protected void setNextNode(AbstractLinkedList.Node<E> next) {
            MethodContext _bcornu_methode_context139 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 699, 21214, 21441);
                CallChecker.varInit(next, "next", 699, 21214, 21441);
                CallChecker.varInit(this.value, "value", 699, 21214, 21441);
                CallChecker.varInit(this.next, "next", 699, 21214, 21441);
                CallChecker.varInit(this.previous, "previous", 699, 21214, 21441);
                this.next = next;
                CallChecker.varAssign(this.next, "this.next", 700, 21415, 21431);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context139.methodEnd();
            }
        }
    }

    protected static class LinkedListIterator<E> implements ListIterator<E> , OrderedIterator<E> {
        protected final AbstractLinkedList<E> parent;

        protected AbstractLinkedList.Node<E> next;

        protected int nextIndex;

        protected AbstractLinkedList.Node<E> current;

        protected int expectedModCount;

        protected LinkedListIterator(AbstractLinkedList<E> parent, int fromIndex) throws IndexOutOfBoundsException {
            super();
            MethodContext _bcornu_methode_context26 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 750, 23189, 23209);
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 751, 23247, 23252)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 751, 23247, 23252);
                    this.expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 751, 23247, 23252).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 751, 23223, 23262);
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 752, 23288, 23293)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 752, 23288, 23293);
                    this.next = CallChecker.isCalled(parent, AbstractLinkedList.class, 752, 23288, 23293).getNode(fromIndex, true);
                    CallChecker.varAssign(this.next, "this.next", 752, 23276, 23319);
                }
                this.nextIndex = fromIndex;
                CallChecker.varAssign(this.nextIndex, "this.nextIndex", 753, 23333, 23359);
            } finally {
                _bcornu_methode_context26.methodEnd();
            }
        }

        protected void checkModCount() {
            MethodContext _bcornu_methode_context140 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 763, 23380, 23819);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 763, 23380, 23819);
                CallChecker.varInit(this.current, "current", 763, 23380, 23819);
                CallChecker.varInit(this.nextIndex, "nextIndex", 763, 23380, 23819);
                CallChecker.varInit(this.next, "next", 763, 23380, 23819);
                CallChecker.varInit(this.parent, "parent", 763, 23380, 23819);
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 764, 23697, 23702)) {
                    if ((CallChecker.isCalled(parent, AbstractLinkedList.class, 764, 23697, 23702).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context140.methodEnd();
            }
        }

        protected AbstractLinkedList.Node<E> getLastNodeReturned() throws IllegalStateException {
            MethodContext _bcornu_methode_context141 = new MethodContext(AbstractLinkedList.Node.class);
            try {
                CallChecker.varInit(this, "this", 776, 23830, 24340);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 776, 23830, 24340);
                CallChecker.varInit(this.current, "current", 776, 23830, 24340);
                CallChecker.varInit(this.nextIndex, "nextIndex", 776, 23830, 24340);
                CallChecker.varInit(this.next, "next", 776, 23830, 24340);
                CallChecker.varInit(this.parent, "parent", 776, 23830, 24340);
                if ((current) == null) {
                    throw new IllegalStateException();
                }
                return current;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context141.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context142 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 783, 24351, 24428);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 783, 24351, 24428);
                CallChecker.varInit(this.current, "current", 783, 24351, 24428);
                CallChecker.varInit(this.nextIndex, "nextIndex", 783, 24351, 24428);
                CallChecker.varInit(this.next, "next", 783, 24351, 24428);
                CallChecker.varInit(this.parent, "parent", 783, 24351, 24428);
                return (next) != (CallChecker.isCalled(parent, AbstractLinkedList.class, 784, 24405, 24410).header);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context142.methodEnd();
            }
        }

        public E next() {
            checkModCount();
            if (!(hasNext())) {
                throw new NoSuchElementException((("No element at index " + (nextIndex)) + "."));
            }
            E value = CallChecker.init(null);
            if (CallChecker.beforeDeref(next, AbstractLinkedList.Node.class, 792, 24644, 24647)) {
                value = next.getValue();
                CallChecker.varAssign(value, "value", 792, 24644, 24647);
            }
            current = next;
            CallChecker.varAssign(this.current, "this.current", 793, 24673, 24687);
            if (CallChecker.beforeDeref(next, AbstractLinkedList.Node.class, 794, 24708, 24711)) {
                next = CallChecker.beforeCalled(next, AbstractLinkedList.Node.class, 794, 24708, 24711);
                next = CallChecker.isCalled(next, AbstractLinkedList.Node.class, 794, 24708, 24711).next;
                CallChecker.varAssign(this.next, "this.next", 794, 24701, 24717);
            }
            (nextIndex)++;
            return value;
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context144 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 799, 24789, 24879);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 799, 24789, 24879);
                CallChecker.varInit(this.current, "current", 799, 24789, 24879);
                CallChecker.varInit(this.nextIndex, "nextIndex", 799, 24789, 24879);
                CallChecker.varInit(this.next, "next", 799, 24789, 24879);
                CallChecker.varInit(this.parent, "parent", 799, 24789, 24879);
                next = CallChecker.beforeCalled(next, AbstractLinkedList.Node.class, 800, 24839, 24842);
                return (CallChecker.isCalled(next, AbstractLinkedList.Node.class, 800, 24839, 24842).previous) != (CallChecker.isCalled(parent, AbstractLinkedList.class, 800, 24856, 24861).header);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context144.methodEnd();
            }
        }

        public E previous() {
            checkModCount();
            if (!(hasPrevious())) {
                throw new NoSuchElementException("Already at start of list.");
            }
            if (CallChecker.beforeDeref(next, AbstractLinkedList.Node.class, 808, 25087, 25090)) {
                next = CallChecker.beforeCalled(next, AbstractLinkedList.Node.class, 808, 25087, 25090);
                next = CallChecker.isCalled(next, AbstractLinkedList.Node.class, 808, 25087, 25090).previous;
                CallChecker.varAssign(this.next, "this.next", 808, 25080, 25100);
            }
            E value = CallChecker.init(null);
            if (CallChecker.beforeDeref(next, AbstractLinkedList.Node.class, 809, 25124, 25127)) {
                value = next.getValue();
                CallChecker.varAssign(value, "value", 809, 25124, 25127);
            }
            current = next;
            CallChecker.varAssign(this.current, "this.current", 810, 25153, 25167);
            (nextIndex)--;
            return value;
        }

        public int nextIndex() {
            MethodContext _bcornu_methode_context146 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 815, 25239, 25302);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 815, 25239, 25302);
                CallChecker.varInit(this.current, "current", 815, 25239, 25302);
                CallChecker.varInit(this.nextIndex, "nextIndex", 815, 25239, 25302);
                CallChecker.varInit(this.next, "next", 815, 25239, 25302);
                CallChecker.varInit(this.parent, "parent", 815, 25239, 25302);
                return nextIndex;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context146.methodEnd();
            }
        }

        public int previousIndex() {
            MethodContext _bcornu_methode_context147 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 819, 25313, 25453);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 819, 25313, 25453);
                CallChecker.varInit(this.current, "current", 819, 25313, 25453);
                CallChecker.varInit(this.nextIndex, "nextIndex", 819, 25313, 25453);
                CallChecker.varInit(this.next, "next", 819, 25313, 25453);
                CallChecker.varInit(this.parent, "parent", 819, 25313, 25453);
                return (nextIndex()) - 1;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context147.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context148 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 824, 25464, 25927);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 824, 25464, 25927);
                CallChecker.varInit(this.current, "current", 824, 25464, 25927);
                CallChecker.varInit(this.nextIndex, "nextIndex", 824, 25464, 25927);
                CallChecker.varInit(this.next, "next", 824, 25464, 25927);
                CallChecker.varInit(this.parent, "parent", 824, 25464, 25927);
                checkModCount();
                if ((current) == (next)) {
                    if (CallChecker.beforeDeref(next, AbstractLinkedList.Node.class, 828, 25623, 25626)) {
                        next = CallChecker.beforeCalled(next, AbstractLinkedList.Node.class, 828, 25623, 25626);
                        next = CallChecker.isCalled(next, AbstractLinkedList.Node.class, 828, 25623, 25626).next;
                        CallChecker.varAssign(this.next, "this.next", 828, 25616, 25632);
                    }
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 829, 25650, 25655)) {
                        CallChecker.isCalled(parent, AbstractLinkedList.class, 829, 25650, 25655).removeNode(getLastNodeReturned());
                    }
                }else {
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 832, 25774, 25779)) {
                        CallChecker.isCalled(parent, AbstractLinkedList.class, 832, 25774, 25779).removeNode(getLastNodeReturned());
                    }
                    (nextIndex)--;
                }
                current = null;
                CallChecker.varAssign(this.current, "this.current", 835, 25871, 25885);
                (expectedModCount)++;
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context148.methodEnd();
            }
        }

        public void set(E obj) {
            MethodContext _bcornu_methode_context149 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 839, 25938, 26049);
                CallChecker.varInit(obj, "obj", 839, 25938, 26049);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 839, 25938, 26049);
                CallChecker.varInit(this.current, "current", 839, 25938, 26049);
                CallChecker.varInit(this.nextIndex, "nextIndex", 839, 25938, 26049);
                CallChecker.varInit(this.next, "next", 839, 25938, 26049);
                CallChecker.varInit(this.parent, "parent", 839, 25938, 26049);
                checkModCount();
                final AbstractLinkedList.Node<E> npe_invocation_var32 = getLastNodeReturned();
                if (CallChecker.beforeDeref(npe_invocation_var32, AbstractLinkedList.Node.class, 841, 26004, 26024)) {
                    CallChecker.isCalled(npe_invocation_var32, AbstractLinkedList.Node.class, 841, 26004, 26024).setValue(obj);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context149.methodEnd();
            }
        }

        public void add(E obj) {
            MethodContext _bcornu_methode_context150 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 844, 26060, 26252);
                CallChecker.varInit(obj, "obj", 844, 26060, 26252);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 844, 26060, 26252);
                CallChecker.varInit(this.current, "current", 844, 26060, 26252);
                CallChecker.varInit(this.nextIndex, "nextIndex", 844, 26060, 26252);
                CallChecker.varInit(this.next, "next", 844, 26060, 26252);
                CallChecker.varInit(this.parent, "parent", 844, 26060, 26252);
                checkModCount();
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 846, 26126, 26131)) {
                    CallChecker.isCalled(parent, AbstractLinkedList.class, 846, 26126, 26131).addNodeBefore(next, obj);
                }
                current = null;
                CallChecker.varAssign(this.current, "this.current", 847, 26171, 26185);
                (nextIndex)++;
                (expectedModCount)++;
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context150.methodEnd();
            }
        }
    }

    protected static class LinkedSubListIterator<E> extends AbstractLinkedList.LinkedListIterator<E> {
        protected final AbstractLinkedList.LinkedSubList<E> sub;

        protected LinkedSubListIterator(AbstractLinkedList.LinkedSubList<E> sub, int startIndex) {
            super(CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 864, 26666, 26668).parent, (startIndex + (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 864, 26691, 26693).offset)));
            MethodContext _bcornu_methode_context27 = new MethodContext(null);
            try {
                this.sub = sub;
                CallChecker.varAssign(this.sub, "this.sub", 865, 26716, 26730);
            } finally {
                _bcornu_methode_context27.methodEnd();
            }
        }

        @Override
        public boolean hasNext() {
            MethodContext _bcornu_methode_context151 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 869, 26751, 26849);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 869, 26751, 26849);
                CallChecker.varInit(this.current, "current", 869, 26751, 26849);
                CallChecker.varInit(this.nextIndex, "nextIndex", 869, 26751, 26849);
                CallChecker.varInit(this.next, "next", 869, 26751, 26849);
                CallChecker.varInit(this.parent, "parent", 869, 26751, 26849);
                CallChecker.varInit(this.sub, "sub", 869, 26751, 26849);
                return (nextIndex()) < (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 870, 26830, 26832).size);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context151.methodEnd();
            }
        }

        @Override
        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context152 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 874, 26860, 26960);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 874, 26860, 26960);
                CallChecker.varInit(this.current, "current", 874, 26860, 26960);
                CallChecker.varInit(this.nextIndex, "nextIndex", 874, 26860, 26960);
                CallChecker.varInit(this.next, "next", 874, 26860, 26960);
                CallChecker.varInit(this.parent, "parent", 874, 26860, 26960);
                CallChecker.varInit(this.sub, "sub", 874, 26860, 26960);
                return (previousIndex()) >= 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context152.methodEnd();
            }
        }

        @Override
        public int nextIndex() {
            MethodContext _bcornu_methode_context153 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 879, 26971, 27075);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 879, 26971, 27075);
                CallChecker.varInit(this.current, "current", 879, 26971, 27075);
                CallChecker.varInit(this.nextIndex, "nextIndex", 879, 26971, 27075);
                CallChecker.varInit(this.next, "next", 879, 26971, 27075);
                CallChecker.varInit(this.parent, "parent", 879, 26971, 27075);
                CallChecker.varInit(this.sub, "sub", 879, 26971, 27075);
                return (super.nextIndex()) - (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 880, 27054, 27056).offset);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context153.methodEnd();
            }
        }

        @Override
        public void add(E obj) {
            MethodContext _bcornu_methode_context154 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 884, 27086, 27241);
                CallChecker.varInit(obj, "obj", 884, 27086, 27241);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 884, 27086, 27241);
                CallChecker.varInit(this.current, "current", 884, 27086, 27241);
                CallChecker.varInit(this.nextIndex, "nextIndex", 884, 27086, 27241);
                CallChecker.varInit(this.next, "next", 884, 27086, 27241);
                CallChecker.varInit(this.parent, "parent", 884, 27086, 27241);
                CallChecker.varInit(this.sub, "sub", 884, 27086, 27241);
                super.add(obj);
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 886, 27169, 27171)) {
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 886, 27192, 27197)) {
                        CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 886, 27169, 27171).expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 886, 27192, 27197).modCount;
                        CallChecker.varAssign(CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 886, 27169, 27171).expectedModCount, "CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 886, 27169, 27171).expectedModCount", 886, 27169, 27207);
                    }
                }
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 887, 27221, 27223)) {
                    (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 887, 27221, 27223).size)++;
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context154.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context155 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 891, 27252, 27405);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 891, 27252, 27405);
                CallChecker.varInit(this.current, "current", 891, 27252, 27405);
                CallChecker.varInit(this.nextIndex, "nextIndex", 891, 27252, 27405);
                CallChecker.varInit(this.next, "next", 891, 27252, 27405);
                CallChecker.varInit(this.parent, "parent", 891, 27252, 27405);
                CallChecker.varInit(this.sub, "sub", 891, 27252, 27405);
                super.remove();
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 893, 27333, 27335)) {
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 893, 27356, 27361)) {
                        CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 893, 27333, 27335).expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 893, 27356, 27361).modCount;
                        CallChecker.varAssign(CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 893, 27333, 27335).expectedModCount, "CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 893, 27333, 27335).expectedModCount", 893, 27333, 27371);
                    }
                }
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 894, 27385, 27387)) {
                    (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 894, 27385, 27387).size)--;
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context155.methodEnd();
            }
        }
    }

    protected static class LinkedSubList<E> extends AbstractList<E> {
        AbstractLinkedList<E> parent;

        int offset;

        int size;

        int expectedModCount;

        protected LinkedSubList(AbstractLinkedList<E> parent, int fromIndex, int toIndex) {
            MethodContext _bcornu_methode_context28 = new MethodContext(null);
            try {
                if (fromIndex < 0) {
                    throw new IndexOutOfBoundsException(("fromIndex = " + fromIndex));
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 916, 28119, 28124)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 916, 28119, 28124);
                    if (toIndex > (CallChecker.isCalled(parent, AbstractLinkedList.class, 916, 28119, 28124).size())) {
                        throw new IndexOutOfBoundsException(("toIndex = " + toIndex));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (fromIndex > toIndex) {
                    throw new IllegalArgumentException((((("fromIndex(" + fromIndex) + ") > toIndex(") + toIndex) + ")"));
                }
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 922, 28403, 28423);
                this.offset = fromIndex;
                CallChecker.varAssign(this.offset, "this.offset", 923, 28437, 28460);
                this.size = toIndex - fromIndex;
                CallChecker.varAssign(this.size, "this.size", 924, 28474, 28505);
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 925, 28543, 28548)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 925, 28543, 28548);
                    this.expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 925, 28543, 28548).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 925, 28519, 28558);
                }
            } finally {
                _bcornu_methode_context28.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context156 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 929, 28579, 28679);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 929, 28579, 28679);
                CallChecker.varInit(this.size, "size", 929, 28579, 28679);
                CallChecker.varInit(this.offset, "offset", 929, 28579, 28679);
                CallChecker.varInit(this.parent, "parent", 929, 28579, 28679);
                checkModCount();
                return size;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context156.methodEnd();
            }
        }

        @Override
        public E get(int index) {
            rangeCheck(index, size);
            checkModCount();
            if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 938, 28819, 28824)) {
                return parent.get((index + (offset)));
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public void add(int index, E obj) {
            MethodContext _bcornu_methode_context158 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 942, 28866, 29154);
                CallChecker.varInit(obj, "obj", 942, 28866, 29154);
                CallChecker.varInit(index, "index", 942, 28866, 29154);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 942, 28866, 29154);
                CallChecker.varInit(this.size, "size", 942, 28866, 29154);
                CallChecker.varInit(this.offset, "offset", 942, 28866, 29154);
                CallChecker.varInit(this.parent, "parent", 942, 28866, 29154);
                rangeCheck(index, ((size) + 1));
                checkModCount();
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 945, 29002, 29007)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 945, 29002, 29007);
                    CallChecker.isCalled(parent, AbstractLinkedList.class, 945, 29002, 29007).add((index + (offset)), obj);
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 946, 29066, 29071)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 946, 29066, 29071);
                    expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 946, 29066, 29071).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 946, 29047, 29081);
                }
                (size)++;
                (this.modCount)++;
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context158.methodEnd();
            }
        }

        @Override
        public E remove(int index) {
            rangeCheck(index, size);
            checkModCount();
            E result = CallChecker.init(null);
            if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 955, 29301, 29306)) {
                result = parent.remove((index + (offset)));
                CallChecker.varAssign(result, "result", 955, 29301, 29306);
            }
            if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 956, 29363, 29368)) {
                parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 956, 29363, 29368);
                expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 956, 29363, 29368).modCount;
                CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 956, 29344, 29378);
            }
            (size)--;
            (this.modCount)++;
            return result;
        }

        @Override
        public boolean addAll(Collection<? extends E> coll) {
            MethodContext _bcornu_methode_context160 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 963, 29489, 29608);
                CallChecker.varInit(coll, "coll", 963, 29489, 29608);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 963, 29489, 29608);
                CallChecker.varInit(this.size, "size", 963, 29489, 29608);
                CallChecker.varInit(this.offset, "offset", 963, 29489, 29608);
                CallChecker.varInit(this.parent, "parent", 963, 29489, 29608);
                return addAll(size, coll);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context160.methodEnd();
            }
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> coll) {
            MethodContext _bcornu_methode_context161 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 968, 29619, 30084);
                CallChecker.varInit(coll, "coll", 968, 29619, 30084);
                CallChecker.varInit(index, "index", 968, 29619, 30084);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 968, 29619, 30084);
                CallChecker.varInit(this.size, "size", 968, 29619, 30084);
                CallChecker.varInit(this.offset, "offset", 968, 29619, 30084);
                CallChecker.varInit(this.parent, "parent", 968, 29619, 30084);
                rangeCheck(index, ((size) + 1));
                int cSize = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(coll, Collection.class, 970, 29767, 29770)) {
                    coll = CallChecker.beforeCalled(coll, Collection.class, 970, 29767, 29770);
                    cSize = CallChecker.isCalled(coll, Collection.class, 970, 29767, 29770).size();
                    CallChecker.varAssign(cSize, "cSize", 970, 29767, 29770);
                }
                if (cSize == 0) {
                    return false;
                }
                checkModCount();
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 976, 29896, 29901)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 976, 29896, 29901);
                    CallChecker.isCalled(parent, AbstractLinkedList.class, 976, 29896, 29901).addAll(((offset) + index), coll);
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 977, 29964, 29969)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 977, 29964, 29969);
                    expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 977, 29964, 29969).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 977, 29945, 29979);
                }
                size += cSize;
                CallChecker.varAssign(this.size, "this.size", 978, 29993, 30006);
                (this.modCount)++;
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context161.methodEnd();
            }
        }

        @Override
        public E set(int index, E obj) {
            rangeCheck(index, size);
            checkModCount();
            if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 987, 30231, 30236)) {
                return parent.set((index + (offset)), obj);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context163 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 991, 30283, 30506);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 991, 30283, 30506);
                CallChecker.varInit(this.size, "size", 991, 30283, 30506);
                CallChecker.varInit(this.offset, "offset", 991, 30283, 30506);
                CallChecker.varInit(this.parent, "parent", 991, 30283, 30506);
                checkModCount();
                Iterator<E> it = CallChecker.varInit(iterator(), "it", 993, 30364, 30391);
                it = CallChecker.beforeCalled(it, Iterator.class, 994, 30412, 30413);
                while (CallChecker.isCalled(it, Iterator.class, 994, 30412, 30413).hasNext()) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 995, 30444, 30445)) {
                        it.next();
                    }
                    if (CallChecker.beforeDeref(it, Iterator.class, 996, 30471, 30472)) {
                        it = CallChecker.beforeCalled(it, Iterator.class, 996, 30471, 30472);
                        CallChecker.isCalled(it, Iterator.class, 996, 30471, 30472).remove();
                    }
                } 
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context163.methodEnd();
            }
        }

        @Override
        public Iterator<E> iterator() {
            MethodContext _bcornu_methode_context164 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 1001, 30517, 30659);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1001, 30517, 30659);
                CallChecker.varInit(this.size, "size", 1001, 30517, 30659);
                CallChecker.varInit(this.offset, "offset", 1001, 30517, 30659);
                CallChecker.varInit(this.parent, "parent", 1001, 30517, 30659);
                checkModCount();
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 1003, 30615, 30620)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 1003, 30615, 30620);
                    return CallChecker.isCalled(parent, AbstractLinkedList.class, 1003, 30615, 30620).createSubListIterator(this);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context164.methodEnd();
            }
        }

        @Override
        public ListIterator<E> listIterator(final int index) {
            MethodContext _bcornu_methode_context165 = new MethodContext(ListIterator.class);
            try {
                CallChecker.varInit(this, "this", 1007, 30670, 30887);
                CallChecker.varInit(index, "index", 1007, 30670, 30887);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1007, 30670, 30887);
                CallChecker.varInit(this.size, "size", 1007, 30670, 30887);
                CallChecker.varInit(this.offset, "offset", 1007, 30670, 30887);
                CallChecker.varInit(this.parent, "parent", 1007, 30670, 30887);
                rangeCheck(index, ((size) + 1));
                checkModCount();
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 1010, 30832, 30837)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 1010, 30832, 30837);
                    return CallChecker.isCalled(parent, AbstractLinkedList.class, 1010, 30832, 30837).createSubListListIterator(this, index);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context165.methodEnd();
            }
        }

        @Override
        public List<E> subList(int fromIndexInclusive, int toIndexExclusive) {
            MethodContext _bcornu_methode_context166 = new MethodContext(List.class);
            try {
                CallChecker.varInit(this, "this", 1014, 30898, 31100);
                CallChecker.varInit(toIndexExclusive, "toIndexExclusive", 1014, 30898, 31100);
                CallChecker.varInit(fromIndexInclusive, "fromIndexInclusive", 1014, 30898, 31100);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1014, 30898, 31100);
                CallChecker.varInit(this.size, "size", 1014, 30898, 31100);
                CallChecker.varInit(this.offset, "offset", 1014, 30898, 31100);
                CallChecker.varInit(this.parent, "parent", 1014, 30898, 31100);
                return new AbstractLinkedList.LinkedSubList<E>(parent, (fromIndexInclusive + (offset)), (toIndexExclusive + (offset)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context166.methodEnd();
            }
        }

        protected void rangeCheck(int index, int beyond) {
            MethodContext _bcornu_methode_context167 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1018, 31111, 31348);
                CallChecker.varInit(beyond, "beyond", 1018, 31111, 31348);
                CallChecker.varInit(index, "index", 1018, 31111, 31348);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1018, 31111, 31348);
                CallChecker.varInit(this.size, "size", 1018, 31111, 31348);
                CallChecker.varInit(this.offset, "offset", 1018, 31111, 31348);
                CallChecker.varInit(this.parent, "parent", 1018, 31111, 31348);
                if ((index < 0) || (index >= beyond)) {
                    throw new IndexOutOfBoundsException((((("Index '" + index) + "' out of bounds for size '") + (size)) + "'"));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context167.methodEnd();
            }
        }

        protected void checkModCount() {
            MethodContext _bcornu_methode_context168 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1024, 31359, 31530);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 1024, 31359, 31530);
                CallChecker.varInit(this.size, "size", 1024, 31359, 31530);
                CallChecker.varInit(this.offset, "offset", 1024, 31359, 31530);
                CallChecker.varInit(this.parent, "parent", 1024, 31359, 31530);
                if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 1025, 31408, 31413)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedList.class, 1025, 31408, 31413);
                    if ((CallChecker.isCalled(parent, AbstractLinkedList.class, 1025, 31408, 31413).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context168.methodEnd();
            }
        }
    }
}

