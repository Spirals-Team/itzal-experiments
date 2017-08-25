package org.apache.commons.collections.list;

import org.apache.commons.collections.iterators.UnmodifiableListIterator;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.Unmodifiable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class UnmodifiableList<E> extends AbstractSerializableListDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 6595182819922443652L;

    public static <E> List<E> decorate(List<E> list) {
        MethodContext _bcornu_methode_context2550 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list, "list", 53, 1779, 2152);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 53, 1779, 2152);
            if (list instanceof Unmodifiable) {
                return list;
            }
            return new UnmodifiableList<E>(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2550.methodEnd();
        }
    }

    public UnmodifiableList(List<E> list) {
        super(list);
        MethodContext _bcornu_methode_context472 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context472.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context2551 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 74, 2527, 2725);
            CallChecker.varInit(this.collection, "collection", 74, 2527, 2725);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 74, 2527, 2725);
            final List<E> npe_invocation_var450 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var450, List.class, 75, 2696, 2706)) {
                return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var450, List.class, 75, 2696, 2706).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2551.methodEnd();
        }
    }

    @Override
    public boolean add(Object object) {
        MethodContext _bcornu_methode_context2552 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 79, 2732, 2837);
            CallChecker.varInit(object, "object", 79, 2732, 2837);
            CallChecker.varInit(this.collection, "collection", 79, 2732, 2837);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 79, 2732, 2837);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2552.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2553 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 84, 2844, 2967);
            CallChecker.varInit(coll, "coll", 84, 2844, 2967);
            CallChecker.varInit(this.collection, "collection", 84, 2844, 2967);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 84, 2844, 2967);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2553.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2554 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 89, 2974, 3065);
            CallChecker.varInit(this.collection, "collection", 89, 2974, 3065);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 89, 2974, 3065);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2554.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context2555 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 94, 3072, 3180);
            CallChecker.varInit(object, "object", 94, 3072, 3180);
            CallChecker.varInit(this.collection, "collection", 94, 3072, 3180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 94, 3072, 3180);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2555.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2556 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 99, 3187, 3303);
            CallChecker.varInit(coll, "coll", 99, 3187, 3303);
            CallChecker.varInit(this.collection, "collection", 99, 3187, 3303);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 99, 3187, 3303);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2556.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2557 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 104, 3310, 3426);
            CallChecker.varInit(coll, "coll", 104, 3310, 3426);
            CallChecker.varInit(this.collection, "collection", 104, 3310, 3426);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 104, 3310, 3426);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2557.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context2558 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 110, 3433, 3647);
            CallChecker.varInit(this.collection, "collection", 110, 3433, 3647);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 110, 3433, 3647);
            final List<E> npe_invocation_var451 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var451, List.class, 111, 3614, 3624)) {
                return UnmodifiableListIterator.decorate(CallChecker.isCalled(npe_invocation_var451, List.class, 111, 3614, 3624).listIterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2558.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        MethodContext _bcornu_methode_context2559 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 115, 3654, 3804);
            CallChecker.varInit(index, "index", 115, 3654, 3804);
            CallChecker.varInit(this.collection, "collection", 115, 3654, 3804);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 115, 3654, 3804);
            final List<E> npe_invocation_var452 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var452, List.class, 116, 3766, 3776)) {
                return UnmodifiableListIterator.decorate(CallChecker.isCalled(npe_invocation_var452, List.class, 116, 3766, 3776).listIterator(index));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2559.methodEnd();
        }
    }

    @Override
    public void add(int index, E object) {
        MethodContext _bcornu_methode_context2560 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 120, 3811, 3919);
            CallChecker.varInit(object, "object", 120, 3811, 3919);
            CallChecker.varInit(index, "index", 120, 3811, 3919);
            CallChecker.varInit(this.collection, "collection", 120, 3811, 3919);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 120, 3811, 3919);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2560.methodEnd();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2561 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 125, 3926, 4060);
            CallChecker.varInit(coll, "coll", 125, 3926, 4060);
            CallChecker.varInit(index, "index", 125, 3926, 4060);
            CallChecker.varInit(this.collection, "collection", 125, 3926, 4060);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 125, 3926, 4060);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2561.methodEnd();
        }
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context2564 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 140, 4284, 4463);
            CallChecker.varInit(toIndex, "toIndex", 140, 4284, 4463);
            CallChecker.varInit(fromIndex, "fromIndex", 140, 4284, 4463);
            CallChecker.varInit(this.collection, "collection", 140, 4284, 4463);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.UnmodifiableList.serialVersionUID", 140, 4284, 4463);
            final List<E> npe_invocation_var453 = decorated();
            List<E> sub = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(npe_invocation_var453, List.class, 141, 4373, 4383)) {
                sub = CallChecker.isCalled(npe_invocation_var453, List.class, 141, 4373, 4383).subList(fromIndex, toIndex);
                CallChecker.varAssign(sub, "sub", 141, 4373, 4383);
            }
            return new UnmodifiableList<E>(sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2564.methodEnd();
        }
    }
}

