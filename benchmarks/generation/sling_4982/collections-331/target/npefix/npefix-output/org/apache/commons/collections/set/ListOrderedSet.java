package org.apache.commons.collections.set;

import org.apache.commons.collections.list.UnmodifiableList;
import java.util.Set;
import org.apache.commons.collections.OrderedIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.ListIterator;
import java.util.List;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.iterators.AbstractUntypedIteratorDecorator;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashSet;

public class ListOrderedSet<E> extends AbstractSerializableSetDecorator<E> implements Set<E> {
    private static final long serialVersionUID = -228664372470420141L;

    protected final List<E> setOrder;

    public static <E> ListOrderedSet<E> decorate(Set<E> set, List<E> list) {
        MethodContext _bcornu_methode_context2580 = new MethodContext(ListOrderedSet.class);
        try {
            CallChecker.varInit(list, "list", 74, 2584, 3544);
            CallChecker.varInit(set, "set", 74, 2584, 3544);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 74, 2584, 3544);
            if (set == null) {
                throw new IllegalArgumentException("Set must not be null");
            }
            if (list == null) {
                throw new IllegalArgumentException("List must not be null");
            }
            if (((set.size()) > 0) || ((list.size()) > 0)) {
                throw new IllegalArgumentException("Set and List must be empty");
            }
            return new ListOrderedSet<E>(set, list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListOrderedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2580.methodEnd();
        }
    }

    public static <E> ListOrderedSet<E> decorate(Set<E> set) {
        MethodContext _bcornu_methode_context2581 = new MethodContext(ListOrderedSet.class);
        try {
            CallChecker.varInit(set, "set", 95, 3551, 3909);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 95, 3551, 3909);
            return new ListOrderedSet<E>(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListOrderedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2581.methodEnd();
        }
    }

    public static <E> ListOrderedSet<E> decorate(List<E> list) {
        MethodContext _bcornu_methode_context2582 = new MethodContext(ListOrderedSet.class);
        try {
            CallChecker.varInit(list, "list", 110, 3916, 4633);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 110, 3916, 4633);
            if (list == null) {
                throw new IllegalArgumentException("List must not be null");
            }
            Set<E> set = CallChecker.varInit(new HashSet<E>(list), "set", 114, 4515, 4548);
            list.retainAll(set);
            return new ListOrderedSet<E>(set, list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListOrderedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2582.methodEnd();
        }
    }

    public ListOrderedSet() {
        super(new HashSet<E>());
        MethodContext _bcornu_methode_context483 = new MethodContext(null);
        try {
            setOrder = new ArrayList<E>();
            CallChecker.varAssign(this.setOrder, "this.setOrder", 129, 4982, 5011);
        } finally {
            _bcornu_methode_context483.methodEnd();
        }
    }

    protected ListOrderedSet(Set<E> set) {
        super(set);
        MethodContext _bcornu_methode_context484 = new MethodContext(null);
        try {
            setOrder = new ArrayList<E>(set);
            CallChecker.varAssign(this.setOrder, "this.setOrder", 140, 5270, 5302);
        } finally {
            _bcornu_methode_context484.methodEnd();
        }
    }

    protected ListOrderedSet(Set<E> set, List<E> list) {
        super(set);
        MethodContext _bcornu_methode_context485 = new MethodContext(null);
        try {
            if (list == null) {
                throw new IllegalArgumentException("List must not be null");
            }
            setOrder = list;
            CallChecker.varAssign(this.setOrder, "this.setOrder", 157, 5883, 5898);
        } finally {
            _bcornu_methode_context485.methodEnd();
        }
    }

    public List<E> asList() {
        MethodContext _bcornu_methode_context2583 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 166, 5911, 6193);
            CallChecker.varInit(this.collection, "collection", 166, 5911, 6193);
            CallChecker.varInit(this.setOrder, "setOrder", 166, 5911, 6193);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 166, 5911, 6193);
            return UnmodifiableList.decorate(setOrder);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2583.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2584 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 172, 6200, 6372);
            CallChecker.varInit(this.collection, "collection", 172, 6200, 6372);
            CallChecker.varInit(this.setOrder, "setOrder", 172, 6200, 6372);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 172, 6200, 6372);
            if (CallChecker.beforeDeref(collection, Collection.class, 173, 6322, 6331)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 173, 6322, 6331);
                CallChecker.isCalled(collection, Collection.class, 173, 6322, 6331).clear();
            }
            if (CallChecker.beforeDeref(setOrder, List.class, 174, 6350, 6357)) {
                CallChecker.isCalled(setOrder, List.class, 174, 6350, 6357).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2584.methodEnd();
        }
    }

    @Override
    public OrderedIterator<E> iterator() {
        MethodContext _bcornu_methode_context2585 = new MethodContext(OrderedIterator.class);
        try {
            CallChecker.varInit(this, "this", 178, 6379, 6515);
            CallChecker.varInit(this.collection, "collection", 178, 6379, 6515);
            CallChecker.varInit(this.setOrder, "setOrder", 178, 6379, 6515);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 178, 6379, 6515);
            if (CallChecker.beforeDeref(setOrder, List.class, 179, 6473, 6480)) {
                return new ListOrderedSet.OrderedSetIterator<E>(CallChecker.isCalled(setOrder, List.class, 179, 6473, 6480).listIterator(), collection);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2585.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context2586 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 183, 6522, 6700);
            CallChecker.varInit(object, "object", 183, 6522, 6700);
            CallChecker.varInit(this.collection, "collection", 183, 6522, 6700);
            CallChecker.varInit(this.setOrder, "setOrder", 183, 6522, 6700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 183, 6522, 6700);
            if (CallChecker.beforeDeref(collection, Collection.class, 184, 6579, 6588)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 184, 6579, 6588);
                if (CallChecker.isCalled(collection, Collection.class, 184, 6579, 6588).add(object)) {
                    if (CallChecker.beforeDeref(setOrder, List.class, 185, 6617, 6624)) {
                        CallChecker.isCalled(setOrder, List.class, 185, 6617, 6624).add(object);
                    }
                    return true;
                }
            }else
                throw new AbnormalExecutionError();
            
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2586.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2587 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 192, 6707, 6901);
            CallChecker.varInit(coll, "coll", 192, 6707, 6901);
            CallChecker.varInit(this.collection, "collection", 192, 6707, 6901);
            CallChecker.varInit(this.setOrder, "setOrder", 192, 6707, 6901);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 192, 6707, 6901);
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 193, 6783, 6805);
            if (CallChecker.beforeDeref(coll, boolean.class, 194, 6826, 6829)) {
                for (E e : coll) {
                    result |= add(e);
                    CallChecker.varAssign(result, "result", 195, 6846, 6862);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2587.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context2588 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 201, 6908, 7073);
            CallChecker.varInit(object, "object", 201, 6908, 7073);
            CallChecker.varInit(this.collection, "collection", 201, 6908, 7073);
            CallChecker.varInit(this.setOrder, "setOrder", 201, 6908, 7073);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 201, 6908, 7073);
            boolean result = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(collection, Collection.class, 202, 6986, 6995)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 202, 6986, 6995);
                result = CallChecker.isCalled(collection, Collection.class, 202, 6986, 6995).remove(object);
                CallChecker.varAssign(result, "result", 202, 6986, 6995);
            }
            if (CallChecker.beforeDeref(setOrder, List.class, 203, 7021, 7028)) {
                CallChecker.isCalled(setOrder, List.class, 203, 7021, 7028).remove(object);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2588.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2589 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 208, 7080, 7315);
            CallChecker.varInit(coll, "coll", 208, 7080, 7315);
            CallChecker.varInit(this.collection, "collection", 208, 7080, 7315);
            CallChecker.varInit(this.setOrder, "setOrder", 208, 7080, 7315);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 208, 7080, 7315);
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 209, 7149, 7171);
            coll = CallChecker.beforeCalled(coll, Collection.class, 210, 7203, 7206);
            for (Iterator<?> it = CallChecker.isCalled(coll, Collection.class, 210, 7203, 7206).iterator(); CallChecker.isCalled(it, Iterator.class, 210, 7220, 7221).hasNext();) {
                if (CallChecker.beforeDeref(it, Iterator.class, 211, 7266, 7267)) {
                    result |= remove(it.next());
                    CallChecker.varAssign(result, "result", 211, 7249, 7276);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2589.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2590 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 217, 7322, 7817);
            CallChecker.varInit(coll, "coll", 217, 7322, 7817);
            CallChecker.varInit(this.collection, "collection", 217, 7322, 7817);
            CallChecker.varInit(this.setOrder, "setOrder", 217, 7322, 7817);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 217, 7322, 7817);
            boolean result = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(collection, Collection.class, 218, 7408, 7417)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 218, 7408, 7417);
                result = CallChecker.isCalled(collection, Collection.class, 218, 7408, 7417).retainAll(coll);
                CallChecker.varAssign(result, "result", 218, 7408, 7417);
            }
            if (result == false) {
                return false;
            }
            if (CallChecker.beforeDeref(collection, Collection.class, 222, 7515, 7524)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 222, 7515, 7524);
                if ((CallChecker.isCalled(collection, Collection.class, 222, 7515, 7524).size()) == 0) {
                    if (CallChecker.beforeDeref(setOrder, List.class, 223, 7553, 7560)) {
                        CallChecker.isCalled(setOrder, List.class, 223, 7553, 7560).clear();
                    }
                }else {
                    for (Iterator<E> it = CallChecker.isCalled(setOrder, List.class, 225, 7622, 7629).iterator(); CallChecker.isCalled(it, Iterator.class, 225, 7643, 7644).hasNext();) {
                        if (CallChecker.beforeDeref(it, Iterator.class, 226, 7701, 7702)) {
                            if (CallChecker.beforeDeref(collection, Collection.class, 226, 7681, 7690)) {
                                collection = CallChecker.beforeCalled(collection, Collection.class, 226, 7681, 7690);
                                if (!(CallChecker.isCalled(collection, Collection.class, 226, 7681, 7690).contains(it.next()))) {
                                    if (CallChecker.beforeDeref(it, Iterator.class, 227, 7735, 7736)) {
                                        CallChecker.isCalled(it, Iterator.class, 227, 7735, 7736).remove();
                                    }
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2590.methodEnd();
        }
    }

    @Override
    public Object[] toArray() {
        MethodContext _bcornu_methode_context2591 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 235, 7824, 7905);
            CallChecker.varInit(this.collection, "collection", 235, 7824, 7905);
            CallChecker.varInit(this.setOrder, "setOrder", 235, 7824, 7905);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 235, 7824, 7905);
            if (CallChecker.beforeDeref(setOrder, List.class, 236, 7881, 7888)) {
                return CallChecker.isCalled(setOrder, List.class, 236, 7881, 7888).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2591.methodEnd();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        MethodContext _bcornu_methode_context2592 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 240, 7912, 7998);
            CallChecker.varInit(a, "a", 240, 7912, 7998);
            CallChecker.varInit(this.collection, "collection", 240, 7912, 7998);
            CallChecker.varInit(this.setOrder, "setOrder", 240, 7912, 7998);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 240, 7912, 7998);
            if (CallChecker.beforeDeref(setOrder, List.class, 241, 7973, 7980)) {
                return CallChecker.isCalled(setOrder, List.class, 241, 7973, 7980).toArray(a);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2592.methodEnd();
        }
    }

    public E get(int index) {
        if (CallChecker.beforeDeref(setOrder, List.class, 246, 8124, 8131)) {
            return setOrder.get(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public int indexOf(Object object) {
        MethodContext _bcornu_methode_context2594 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 249, 8156, 8237);
            CallChecker.varInit(object, "object", 249, 8156, 8237);
            CallChecker.varInit(this.collection, "collection", 249, 8156, 8237);
            CallChecker.varInit(this.setOrder, "setOrder", 249, 8156, 8237);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 249, 8156, 8237);
            if (CallChecker.beforeDeref(setOrder, List.class, 250, 8207, 8214)) {
                return CallChecker.isCalled(setOrder, List.class, 250, 8207, 8214).indexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2594.methodEnd();
        }
    }

    public void add(int index, E object) {
        MethodContext _bcornu_methode_context2595 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 253, 8244, 8407);
            CallChecker.varInit(object, "object", 253, 8244, 8407);
            CallChecker.varInit(index, "index", 253, 8244, 8407);
            CallChecker.varInit(this.collection, "collection", 253, 8244, 8407);
            CallChecker.varInit(this.setOrder, "setOrder", 253, 8244, 8407);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 253, 8244, 8407);
            if (!(contains(object))) {
                if (CallChecker.beforeDeref(collection, Collection.class, 255, 8328, 8337)) {
                    collection = CallChecker.beforeCalled(collection, Collection.class, 255, 8328, 8337);
                    CallChecker.isCalled(collection, Collection.class, 255, 8328, 8337).add(object);
                }
                if (CallChecker.beforeDeref(setOrder, List.class, 256, 8364, 8371)) {
                    CallChecker.isCalled(setOrder, List.class, 256, 8364, 8371).add(index, object);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2595.methodEnd();
        }
    }

    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2596 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 260, 8414, 8745);
            CallChecker.varInit(coll, "coll", 260, 8414, 8745);
            CallChecker.varInit(index, "index", 260, 8414, 8745);
            CallChecker.varInit(this.collection, "collection", 260, 8414, 8745);
            CallChecker.varInit(this.setOrder, "setOrder", 260, 8414, 8745);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 260, 8414, 8745);
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 261, 8487, 8510);
            if (CallChecker.beforeDeref(coll, boolean.class, 262, 8531, 8534)) {
                for (E e : coll) {
                    if (contains(e)) {
                        continue;
                    }
                    if (CallChecker.beforeDeref(collection, Collection.class, 266, 8622, 8631)) {
                        collection = CallChecker.beforeCalled(collection, Collection.class, 266, 8622, 8631);
                        CallChecker.isCalled(collection, Collection.class, 266, 8622, 8631).add(e);
                    }
                    if (CallChecker.beforeDeref(setOrder, List.class, 267, 8653, 8660)) {
                        CallChecker.isCalled(setOrder, List.class, 267, 8653, 8660).add((index++), e);
                    }
                    changed = true;
                    CallChecker.varAssign(changed, "changed", 268, 8691, 8705);
                }
            }
            return changed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2596.methodEnd();
        }
    }

    public Object remove(int index) {
        MethodContext _bcornu_methode_context2597 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 273, 8752, 8876);
            CallChecker.varInit(index, "index", 273, 8752, 8876);
            CallChecker.varInit(this.collection, "collection", 273, 8752, 8876);
            CallChecker.varInit(this.setOrder, "setOrder", 273, 8752, 8876);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 273, 8752, 8876);
            Object obj = CallChecker.init(Object.class);
            if (CallChecker.beforeDeref(setOrder, List.class, 274, 8807, 8814)) {
                obj = setOrder.remove(index);
                CallChecker.varAssign(obj, "obj", 274, 8807, 8814);
            }
            remove(obj);
            return obj;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2597.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2598 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 286, 8883, 9227);
            CallChecker.varInit(this.collection, "collection", 286, 8883, 9227);
            CallChecker.varInit(this.setOrder, "setOrder", 286, 8883, 9227);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.ListOrderedSet.serialVersionUID", 286, 8883, 9227);
            if (CallChecker.beforeDeref(setOrder, List.class, 287, 9202, 9209)) {
                return CallChecker.isCalled(setOrder, List.class, 287, 9202, 9209).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2598.methodEnd();
        }
    }

    static class OrderedSetIterator<E> extends AbstractIteratorDecorator<E> implements OrderedIterator<E> {
        protected final Collection<E> set;

        protected E last;

        private OrderedSetIterator(ListIterator<E> iterator, Collection<E> set) {
            super(iterator);
            MethodContext _bcornu_methode_context486 = new MethodContext(null);
            try {
                this.set = set;
                CallChecker.varAssign(this.set, "this.set", 304, 9740, 9754);
            } finally {
                _bcornu_methode_context486.methodEnd();
            }
        }

        @Override
        public E next() {
            if (CallChecker.beforeDeref(iterator, Iterator.class, 309, 9830, 9837)) {
                last = iterator.next();
                CallChecker.varAssign(this.last, "this.last", 309, 9823, 9845);
            }
            return last;
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context2600 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 314, 9891, 10026);
                CallChecker.varInit(this.iterator, "iterator", 314, 9891, 10026);
                CallChecker.varInit(this.last, "last", 314, 9891, 10026);
                CallChecker.varInit(this.set, "set", 314, 9891, 10026);
                if (CallChecker.beforeDeref(set, Collection.class, 315, 9944, 9946)) {
                    CallChecker.isCalled(set, Collection.class, 315, 9944, 9946).remove(last);
                }
                if (CallChecker.beforeDeref(iterator, Iterator.class, 316, 9974, 9981)) {
                    CallChecker.isCalled(iterator, Iterator.class, 316, 9974, 9981).remove();
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 317, 10005, 10016);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2600.methodEnd();
            }
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context2601 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 320, 10037, 10139);
                CallChecker.varInit(this.iterator, "iterator", 320, 10037, 10139);
                CallChecker.varInit(this.last, "last", 320, 10037, 10139);
                CallChecker.varInit(this.set, "set", 320, 10037, 10139);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 321, 10106, 10113)) {
                    return CallChecker.isCalled(((ListIterator<E>) (iterator)), ListIterator.class, 321, 10106, 10113).hasPrevious();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2601.methodEnd();
            }
        }

        public E previous() {
            if (CallChecker.beforeDeref(iterator, Iterator.class, 325, 10210, 10217)) {
                last = ((ListIterator<E>) (iterator)).previous();
                CallChecker.varAssign(this.last, "this.last", 325, 10184, 10230);
            }
            return last;
        }
    }
}

