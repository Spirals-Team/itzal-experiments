package org.apache.commons.collections.list;

import org.apache.commons.collections.set.UnmodifiableSet;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.HashSet;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import org.apache.commons.collections.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Set;

public class SetUniqueList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = 7196982186153478694L;

    protected final Set<E> set;

    public static <E> SetUniqueList<E> decorate(List<E> list) {
        MethodContext _bcornu_methode_context240 = new MethodContext(SetUniqueList.class);
        try {
            CallChecker.varInit(list, "list", 73, 2474, 3320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 73, 2474, 3320);
            if (list == null) {
                throw new IllegalArgumentException("List must not be null");
            }
            if (list.isEmpty()) {
                return new SetUniqueList<E>(list, new HashSet<E>());
            }
            List<E> temp = CallChecker.varInit(new ArrayList<E>(list), "temp", 80, 3135, 3172);
            list.clear();
            SetUniqueList<E> sl = CallChecker.varInit(new SetUniqueList<E>(list, new HashSet<E>()), "sl", 82, 3204, 3270);
            if (CallChecker.beforeDeref(sl, SetUniqueList.class, 83, 3280, 3281)) {
                sl = CallChecker.beforeCalled(sl, SetUniqueList.class, 83, 3280, 3281);
                CallChecker.isCalled(sl, SetUniqueList.class, 83, 3280, 3281).addAll(temp);
            }
            return sl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SetUniqueList<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context240.methodEnd();
        }
    }

    protected SetUniqueList(List<E> list, Set<E> set) {
        super(list);
        MethodContext _bcornu_methode_context34 = new MethodContext(null);
        try {
            if (set == null) {
                throw new IllegalArgumentException("Set must not be null");
            }
            this.set = set;
            CallChecker.varAssign(this.set, "this.set", 102, 3971, 3985);
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public Set<E> asSet() {
        MethodContext _bcornu_methode_context241 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 111, 3998, 4256);
            CallChecker.varInit(this.collection, "collection", 111, 3998, 4256);
            CallChecker.varInit(this.set, "set", 111, 3998, 4256);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 111, 3998, 4256);
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context241.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context242 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 4263, 5029);
            CallChecker.varInit(object, "object", 128, 4263, 5029);
            CallChecker.varInit(this.collection, "collection", 128, 4263, 5029);
            CallChecker.varInit(this.set, "set", 128, 4263, 5029);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 128, 4263, 5029);
            final int sizeBefore = CallChecker.varInit(((int) (size())), "sizeBefore", 130, 4803, 4861);
            add(size(), object);
            return sizeBefore != (size());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context242.methodEnd();
        }
    }

    @Override
    public void add(int index, E object) {
        MethodContext _bcornu_methode_context243 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 150, 5036, 5649);
            CallChecker.varInit(object, "object", 150, 5036, 5649);
            CallChecker.varInit(index, "index", 150, 5036, 5649);
            CallChecker.varInit(this.collection, "collection", 150, 5036, 5649);
            CallChecker.varInit(this.set, "set", 150, 5036, 5649);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 150, 5036, 5649);
            if (CallChecker.beforeDeref(set, Set.class, 152, 5535, 5537)) {
                if ((CallChecker.isCalled(set, Set.class, 152, 5535, 5537).contains(object)) == false) {
                    super.add(index, object);
                    if (CallChecker.beforeDeref(set, Set.class, 154, 5618, 5620)) {
                        CallChecker.isCalled(set, Set.class, 154, 5618, 5620).add(object);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context243.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context244 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 172, 5656, 6314);
            CallChecker.varInit(coll, "coll", 172, 5656, 6314);
            CallChecker.varInit(this.collection, "collection", 172, 5656, 6314);
            CallChecker.varInit(this.set, "set", 172, 5656, 6314);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 172, 5656, 6314);
            return addAll(size(), coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context244.methodEnd();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context245 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 192, 6321, 7318);
            CallChecker.varInit(coll, "coll", 192, 6321, 7318);
            CallChecker.varInit(index, "index", 192, 6321, 7318);
            CallChecker.varInit(this.collection, "collection", 192, 6321, 7318);
            CallChecker.varInit(this.set, "set", 192, 6321, 7318);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 192, 6321, 7318);
            HashSet<E> temp = CallChecker.varInit(new HashSet<E>(coll), "temp", 193, 7015, 7053);
            if (CallChecker.beforeDeref(temp, HashSet.class, 194, 7063, 7066)) {
                temp = CallChecker.beforeCalled(temp, HashSet.class, 194, 7063, 7066);
                CallChecker.isCalled(temp, HashSet.class, 194, 7063, 7066).removeAll(set);
            }
            if (CallChecker.beforeDeref(temp, HashSet.class, 195, 7096, 7099)) {
                temp = CallChecker.beforeCalled(temp, HashSet.class, 195, 7096, 7099);
                if (CallChecker.isCalled(temp, HashSet.class, 195, 7096, 7099).isEmpty()) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(coll, boolean.class, 198, 7169, 7172)) {
                for (E e : coll) {
                    if (CallChecker.beforeDeref(temp, HashSet.class, 199, 7193, 7196)) {
                        temp = CallChecker.beforeCalled(temp, HashSet.class, 199, 7193, 7196);
                        if (CallChecker.isCalled(temp, HashSet.class, 199, 7193, 7196).contains(e)) {
                            add(index, e);
                            index++;
                        }
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context245.methodEnd();
        }
    }

    @Override
    public E set(int index, E object) {
        int pos = CallChecker.varInit(((int) (indexOf(object))), "pos", 222, 7916, 7941);
        E removed = CallChecker.varInit(super.set(index, object), "removed", 223, 7951, 7987);
        if ((pos != (-1)) && (pos != index)) {
            super.remove(pos);
        }
        if (CallChecker.beforeDeref(set, Set.class, 231, 8225, 8227)) {
            CallChecker.isCalled(set, Set.class, 231, 8225, 8227).add(object);
        }
        if (CallChecker.beforeDeref(set, Set.class, 232, 8293, 8295)) {
            CallChecker.isCalled(set, Set.class, 232, 8293, 8295).remove(removed);
        }
        return removed;
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context247 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 238, 8428, 8583);
            CallChecker.varInit(object, "object", 238, 8428, 8583);
            CallChecker.varInit(this.collection, "collection", 238, 8428, 8583);
            CallChecker.varInit(this.set, "set", 238, 8428, 8583);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 238, 8428, 8583);
            boolean result = CallChecker.varInit(((boolean) (super.remove(object))), "result", 239, 8489, 8526);
            if (CallChecker.beforeDeref(set, Set.class, 240, 8536, 8538)) {
                CallChecker.isCalled(set, Set.class, 240, 8536, 8538).remove(object);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context247.methodEnd();
        }
    }

    @Override
    public E remove(int index) {
        E result = CallChecker.varInit(super.remove(index), "result", 246, 8641, 8671);
        if (CallChecker.beforeDeref(set, Set.class, 247, 8681, 8683)) {
            CallChecker.isCalled(set, Set.class, 247, 8681, 8683).remove(result);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context249 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 252, 8735, 8900);
            CallChecker.varInit(coll, "coll", 252, 8735, 8900);
            CallChecker.varInit(this.collection, "collection", 252, 8735, 8900);
            CallChecker.varInit(this.set, "set", 252, 8735, 8900);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 252, 8735, 8900);
            boolean result = CallChecker.varInit(((boolean) (super.removeAll(coll))), "result", 253, 8804, 8842);
            if (CallChecker.beforeDeref(set, Set.class, 254, 8852, 8854)) {
                CallChecker.isCalled(set, Set.class, 254, 8852, 8854).removeAll(coll);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context249.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context250 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 259, 8907, 9072);
            CallChecker.varInit(coll, "coll", 259, 8907, 9072);
            CallChecker.varInit(this.collection, "collection", 259, 8907, 9072);
            CallChecker.varInit(this.set, "set", 259, 8907, 9072);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 259, 8907, 9072);
            boolean result = CallChecker.varInit(((boolean) (super.retainAll(coll))), "result", 260, 8976, 9014);
            if (CallChecker.beforeDeref(set, Set.class, 261, 9024, 9026)) {
                CallChecker.isCalled(set, Set.class, 261, 9024, 9026).retainAll(coll);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context250.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context251 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 266, 9079, 9163);
            CallChecker.varInit(this.collection, "collection", 266, 9079, 9163);
            CallChecker.varInit(this.set, "set", 266, 9079, 9163);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 266, 9079, 9163);
            super.clear();
            if (CallChecker.beforeDeref(set, Set.class, 268, 9146, 9148)) {
                CallChecker.isCalled(set, Set.class, 268, 9146, 9148).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context251.methodEnd();
        }
    }

    @Override
    public boolean contains(Object object) {
        MethodContext _bcornu_methode_context252 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 272, 9170, 9266);
            CallChecker.varInit(object, "object", 272, 9170, 9266);
            CallChecker.varInit(this.collection, "collection", 272, 9170, 9266);
            CallChecker.varInit(this.set, "set", 272, 9170, 9266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 272, 9170, 9266);
            if (CallChecker.beforeDeref(set, Set.class, 273, 9240, 9242)) {
                return CallChecker.isCalled(set, Set.class, 273, 9240, 9242).contains(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context252.methodEnd();
        }
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context253 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 277, 9273, 9378);
            CallChecker.varInit(coll, "coll", 277, 9273, 9378);
            CallChecker.varInit(this.collection, "collection", 277, 9273, 9378);
            CallChecker.varInit(this.set, "set", 277, 9273, 9378);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 277, 9273, 9378);
            if (CallChecker.beforeDeref(set, Set.class, 278, 9351, 9353)) {
                return CallChecker.isCalled(set, Set.class, 278, 9351, 9353).containsAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context253.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context254 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 282, 9385, 9497);
            CallChecker.varInit(this.collection, "collection", 282, 9385, 9497);
            CallChecker.varInit(this.set, "set", 282, 9385, 9497);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 282, 9385, 9497);
            return new SetUniqueList.SetListIterator<E>(super.iterator(), set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context254.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context255 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 287, 9504, 9632);
            CallChecker.varInit(this.collection, "collection", 287, 9504, 9632);
            CallChecker.varInit(this.set, "set", 287, 9504, 9632);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 287, 9504, 9632);
            return new SetUniqueList.SetListListIterator<E>(super.listIterator(), set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context255.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        MethodContext _bcornu_methode_context256 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 292, 9639, 9781);
            CallChecker.varInit(index, "index", 292, 9639, 9781);
            CallChecker.varInit(this.collection, "collection", 292, 9639, 9781);
            CallChecker.varInit(this.set, "set", 292, 9639, 9781);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 292, 9639, 9781);
            return new SetUniqueList.SetListListIterator<E>(super.listIterator(index), set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context256.methodEnd();
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context257 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 297, 9788, 10049);
            CallChecker.varInit(toIndex, "toIndex", 297, 9788, 10049);
            CallChecker.varInit(fromIndex, "fromIndex", 297, 9788, 10049);
            CallChecker.varInit(this.collection, "collection", 297, 9788, 10049);
            CallChecker.varInit(this.set, "set", 297, 9788, 10049);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 297, 9788, 10049);
            List<E> superSubList = CallChecker.varInit(super.subList(fromIndex, toIndex), "superSubList", 298, 9863, 9919);
            Set<E> subSet = CallChecker.varInit(createSetBasedOnList(set, superSubList), "subSet", 299, 9929, 9984);
            return new SetUniqueList<E>(superSubList, subSet);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context257.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected Set<E> createSetBasedOnList(Set<E> set, List<E> list) {
        MethodContext _bcornu_methode_context258 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 304, 10056, 10639);
            CallChecker.varInit(list, "list", 304, 10056, 10639);
            CallChecker.varInit(set, "set", 304, 10056, 10639);
            CallChecker.varInit(this.collection, "collection", 304, 10056, 10639);
            CallChecker.varInit(this.set, "set", 304, 10056, 10639);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SetUniqueList.serialVersionUID", 304, 10056, 10639);
            Set<E> subSet = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(set, Set.class, 306, 10192, 10194)) {
                set = CallChecker.beforeCalled(set, Set.class, 306, 10192, 10194);
                if (CallChecker.beforeDeref(CallChecker.isCalled(set, Set.class, 306, 10192, 10194).getClass(), Class.class, 306, 10192, 10205)) {
                    set = CallChecker.beforeCalled(set, Set.class, 306, 10192, 10194);
                    if (CallChecker.isCalled(CallChecker.isCalled(set, Set.class, 306, 10192, 10194).getClass(), Class.class, 306, 10192, 10205).equals(HashSet.class)) {
                        if (CallChecker.beforeDeref(list, List.class, 307, 10268, 10271)) {
                            list = CallChecker.beforeCalled(list, List.class, 307, 10268, 10271);
                            subSet = new HashSet<E>(CallChecker.isCalled(list, List.class, 307, 10268, 10271).size());
                            CallChecker.varAssign(subSet, "subSet", 307, 10244, 10280);
                        }
                    }else {
                        TryContext _bcornu_try_context_1 = new TryContext(1, SetUniqueList.class, "java.lang.InstantiationException", "java.lang.IllegalAccessException");
                        try {
                            if (CallChecker.beforeDeref(set, Set.class, 310, 10342, 10344)) {
                                set = CallChecker.beforeCalled(set, Set.class, 310, 10342, 10344);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(set, Set.class, 310, 10342, 10344).getClass(), Class.class, 310, 10342, 10355)) {
                                    set = CallChecker.beforeCalled(set, Set.class, 310, 10342, 10344);
                                    subSet = CallChecker.isCalled(set, Set.class, 310, 10342, 10344).getClass().newInstance();
                                    CallChecker.varAssign(subSet, "subSet", 310, 10333, 10370);
                                }
                            }
                        } catch (InstantiationException ie) {
                            _bcornu_try_context_1.catchStart(1);
                            subSet = new HashSet<E>();
                            CallChecker.varAssign(subSet, "subSet", 312, 10438, 10463);
                        } catch (IllegalAccessException iae) {
                            _bcornu_try_context_1.catchStart(1);
                            subSet = new HashSet<E>();
                            CallChecker.varAssign(subSet, "subSet", 314, 10532, 10557);
                        } finally {
                            _bcornu_try_context_1.finallyStart(1);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(subSet, Set.class, 317, 10591, 10596)) {
                subSet = CallChecker.beforeCalled(subSet, Set.class, 317, 10591, 10596);
                CallChecker.isCalled(subSet, Set.class, 317, 10591, 10596).addAll(list);
            }
            return subSet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context258.methodEnd();
        }
    }

    static class SetListIterator<E> extends AbstractIteratorDecorator<E> {
        protected final Set<E> set;

        protected E last = null;

        protected SetListIterator(Iterator<E> it, Set<E> set) {
            super(it);
            MethodContext _bcornu_methode_context35 = new MethodContext(null);
            try {
                this.set = set;
                CallChecker.varAssign(this.set, "this.set", 332, 11010, 11024);
            } finally {
                _bcornu_methode_context35.methodEnd();
            }
        }

        @Override
        public E next() {
            last = super.next();
            CallChecker.varAssign(this.last, "this.last", 337, 11093, 11112);
            return last;
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context260 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 342, 11158, 11290);
                CallChecker.varInit(this.iterator, "iterator", 342, 11158, 11290);
                CallChecker.varInit(this.last, "last", 342, 11158, 11290);
                CallChecker.varInit(this.set, "set", 342, 11158, 11290);
                super.remove();
                if (CallChecker.beforeDeref(set, Set.class, 344, 11239, 11241)) {
                    CallChecker.isCalled(set, Set.class, 344, 11239, 11241).remove(last);
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 345, 11269, 11280);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context260.methodEnd();
            }
        }
    }

    static class SetListListIterator<E> extends AbstractListIteratorDecorator<E> {
        protected final Set<E> set;

        protected E last = null;

        protected SetListListIterator(ListIterator<E> it, Set<E> set) {
            super(it);
            MethodContext _bcornu_methode_context36 = new MethodContext(null);
            try {
                this.set = set;
                CallChecker.varAssign(this.set, "this.set", 359, 11605, 11619);
            } finally {
                _bcornu_methode_context36.methodEnd();
            }
        }

        @Override
        public E next() {
            last = super.next();
            CallChecker.varAssign(this.last, "this.last", 364, 11688, 11707);
            return last;
        }

        @Override
        public E previous() {
            last = super.previous();
            CallChecker.varAssign(this.last, "this.last", 370, 11805, 11828);
            return last;
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context263 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 375, 11874, 12006);
                CallChecker.varInit(this.iterator, "iterator", 375, 11874, 12006);
                CallChecker.varInit(this.last, "last", 375, 11874, 12006);
                CallChecker.varInit(this.set, "set", 375, 11874, 12006);
                super.remove();
                if (CallChecker.beforeDeref(set, Set.class, 377, 11955, 11957)) {
                    CallChecker.isCalled(set, Set.class, 377, 11955, 11957).remove(last);
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 378, 11985, 11996);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context263.methodEnd();
            }
        }

        @Override
        public void add(E object) {
            MethodContext _bcornu_methode_context264 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 382, 12017, 12202);
                CallChecker.varInit(object, "object", 382, 12017, 12202);
                CallChecker.varInit(this.iterator, "iterator", 382, 12017, 12202);
                CallChecker.varInit(this.last, "last", 382, 12017, 12202);
                CallChecker.varInit(this.set, "set", 382, 12017, 12202);
                if (CallChecker.beforeDeref(set, Set.class, 383, 12079, 12081)) {
                    if ((CallChecker.isCalled(set, Set.class, 383, 12079, 12081).contains(object)) == false) {
                        super.add(object);
                        if (CallChecker.beforeDeref(set, Set.class, 385, 12163, 12165)) {
                            CallChecker.isCalled(set, Set.class, 385, 12163, 12165).add(object);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context264.methodEnd();
            }
        }

        @Override
        public void set(E object) {
            MethodContext _bcornu_methode_context265 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 390, 12213, 12357);
                CallChecker.varInit(object, "object", 390, 12213, 12357);
                CallChecker.varInit(this.iterator, "iterator", 390, 12213, 12357);
                CallChecker.varInit(this.last, "last", 390, 12213, 12357);
                CallChecker.varInit(this.set, "set", 390, 12213, 12357);
                throw new UnsupportedOperationException("ListIterator does not support set");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context265.methodEnd();
            }
        }
    }
}

