package org.apache.commons.collections.set;

import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.Unmodifiable;
import java.util.SortedSet;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class UnmodifiableSortedSet<E> extends AbstractSortedSetDecorator<E> implements Serializable , Unmodifiable {
    private static final long serialVersionUID = -725356885467962424L;

    public static <T> SortedSet<T> decorate(SortedSet<T> set) {
        MethodContext _bcornu_methode_context2684 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(set, "set", 55, 1821, 2201);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 55, 1821, 2201);
            if (set instanceof Unmodifiable) {
                return set;
            }
            return new UnmodifiableSortedSet<T>(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2684.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2685 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 69, 2208, 2575);
            CallChecker.varInit(out, "out", 69, 2208, 2575);
            CallChecker.varInit(this.collection, "collection", 69, 2208, 2575);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 69, 2208, 2575);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 70, 2508, 2510)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 70, 2508, 2510);
                CallChecker.isCalled(out, ObjectOutputStream.class, 70, 2508, 2510).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 71, 2542, 2544)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 71, 2542, 2544);
                CallChecker.isCalled(out, ObjectOutputStream.class, 71, 2542, 2544).writeObject(collection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2685.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2686 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 82, 2582, 3037);
            CallChecker.varInit(in, "in", 82, 2582, 3037);
            CallChecker.varInit(this.collection, "collection", 82, 2582, 3037);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 82, 2582, 3037);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 83, 2948, 2949)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 83, 2948, 2949);
                CallChecker.isCalled(in, ObjectInputStream.class, 83, 2948, 2949).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 84, 3009, 3010)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 84, 3009, 3010);
                collection = ((Collection<E>) (CallChecker.isCalled(in, ObjectInputStream.class, 84, 3009, 3010).readObject()));
                CallChecker.varAssign(this.collection, "this.collection", 84, 2980, 3024);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2686.methodEnd();
        }
    }

    private UnmodifiableSortedSet(SortedSet<E> set) {
        super(set);
        MethodContext _bcornu_methode_context504 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context504.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context2687 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 100, 3383, 3581);
            CallChecker.varInit(this.collection, "collection", 100, 3383, 3581);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 100, 3383, 3581);
            final SortedSet<E> npe_invocation_var465 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var465, SortedSet.class, 101, 3552, 3562)) {
                return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var465, SortedSet.class, 101, 3552, 3562).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2687.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context2688 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 105, 3588, 3688);
            CallChecker.varInit(object, "object", 105, 3588, 3688);
            CallChecker.varInit(this.collection, "collection", 105, 3588, 3688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 105, 3588, 3688);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2688.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2689 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 110, 3695, 3818);
            CallChecker.varInit(coll, "coll", 110, 3695, 3818);
            CallChecker.varInit(this.collection, "collection", 110, 3695, 3818);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 110, 3695, 3818);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2689.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2690 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 115, 3825, 3916);
            CallChecker.varInit(this.collection, "collection", 115, 3825, 3916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 115, 3825, 3916);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2690.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context2691 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 120, 3923, 4031);
            CallChecker.varInit(object, "object", 120, 3923, 4031);
            CallChecker.varInit(this.collection, "collection", 120, 3923, 4031);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 120, 3923, 4031);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2691.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2692 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 125, 4038, 4154);
            CallChecker.varInit(coll, "coll", 125, 4038, 4154);
            CallChecker.varInit(this.collection, "collection", 125, 4038, 4154);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 125, 4038, 4154);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2692.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2693 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 130, 4161, 4277);
            CallChecker.varInit(coll, "coll", 130, 4161, 4277);
            CallChecker.varInit(this.collection, "collection", 130, 4161, 4277);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 130, 4161, 4277);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2693.methodEnd();
        }
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        MethodContext _bcornu_methode_context2694 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 136, 4284, 4558);
            CallChecker.varInit(toElement, "toElement", 136, 4284, 4558);
            CallChecker.varInit(fromElement, "fromElement", 136, 4284, 4558);
            CallChecker.varInit(this.collection, "collection", 136, 4284, 4558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 136, 4284, 4558);
            final SortedSet<E> npe_invocation_var466 = decorated();
            SortedSet<E> sub = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var466, SortedSet.class, 137, 4460, 4470)) {
                sub = CallChecker.isCalled(npe_invocation_var466, SortedSet.class, 137, 4460, 4470).subSet(fromElement, toElement);
                CallChecker.varAssign(sub, "sub", 137, 4460, 4470);
            }
            return new UnmodifiableSortedSet<E>(sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2694.methodEnd();
        }
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        MethodContext _bcornu_methode_context2695 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 142, 4565, 4735);
            CallChecker.varInit(toElement, "toElement", 142, 4565, 4735);
            CallChecker.varInit(this.collection, "collection", 142, 4565, 4735);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 142, 4565, 4735);
            final SortedSet<E> npe_invocation_var467 = decorated();
            SortedSet<E> sub = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var467, SortedSet.class, 143, 4649, 4659)) {
                sub = CallChecker.isCalled(npe_invocation_var467, SortedSet.class, 143, 4649, 4659).headSet(toElement);
                CallChecker.varAssign(sub, "sub", 143, 4649, 4659);
            }
            return new UnmodifiableSortedSet<E>(sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2695.methodEnd();
        }
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        MethodContext _bcornu_methode_context2696 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 148, 4742, 4916);
            CallChecker.varInit(fromElement, "fromElement", 148, 4742, 4916);
            CallChecker.varInit(this.collection, "collection", 148, 4742, 4916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSortedSet.serialVersionUID", 148, 4742, 4916);
            final SortedSet<E> npe_invocation_var468 = decorated();
            SortedSet<E> sub = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var468, SortedSet.class, 149, 4828, 4838)) {
                sub = CallChecker.isCalled(npe_invocation_var468, SortedSet.class, 149, 4828, 4838).tailSet(fromElement);
                CallChecker.varAssign(sub, "sub", 149, 4828, 4838);
            }
            return new UnmodifiableSortedSet<E>(sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2696.methodEnd();
        }
    }
}

