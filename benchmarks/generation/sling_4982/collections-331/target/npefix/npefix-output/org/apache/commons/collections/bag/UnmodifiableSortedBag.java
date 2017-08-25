package org.apache.commons.collections.bag;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.SortedBag;
import java.util.Set;
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

public final class UnmodifiableSortedBag<E> extends AbstractSortedBagDecorator<E> implements Serializable , Unmodifiable {
    private static final long serialVersionUID = -3190437252665717841L;

    public static <E> SortedBag<E> decorate(SortedBag<E> bag) {
        MethodContext _bcornu_methode_context1536 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(bag, "bag", 59, 1916, 2417);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 59, 1916, 2417);
            if (bag instanceof Unmodifiable) {
                return bag;
            }
            return new UnmodifiableSortedBag<E>(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1536.methodEnd();
        }
    }

    private UnmodifiableSortedBag(SortedBag<E> bag) {
        super(bag);
        MethodContext _bcornu_methode_context291 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context291.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1537 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 2763, 3130);
            CallChecker.varInit(out, "out", 84, 2763, 3130);
            CallChecker.varInit(this.collection, "collection", 84, 2763, 3130);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 84, 2763, 3130);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 85, 3063, 3065)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 85, 3063, 3065);
                CallChecker.isCalled(out, ObjectOutputStream.class, 85, 3063, 3065).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 86, 3097, 3099)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 86, 3097, 3099);
                CallChecker.isCalled(out, ObjectOutputStream.class, 86, 3097, 3099).writeObject(collection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1537.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1538 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 97, 3137, 3531);
            CallChecker.varInit(in, "in", 97, 3137, 3531);
            CallChecker.varInit(this.collection, "collection", 97, 3137, 3531);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 97, 3137, 3531);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 98, 3449, 3450)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 98, 3449, 3450);
                CallChecker.isCalled(in, ObjectInputStream.class, 98, 3449, 3450).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 99, 3510, 3511)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 99, 3510, 3511);
                collection = ((Collection<E>) (CallChecker.isCalled(in, ObjectInputStream.class, 99, 3510, 3511).readObject()));
                CallChecker.varAssign(this.collection, "this.collection", 99, 3481, 3525);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1538.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1539 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 104, 3538, 3736);
            CallChecker.varInit(this.collection, "collection", 104, 3538, 3736);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 104, 3538, 3736);
            final SortedBag<E> npe_invocation_var294 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var294, SortedBag.class, 105, 3707, 3717)) {
                return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var294, SortedBag.class, 105, 3707, 3717).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1539.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context1540 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 109, 3743, 3843);
            CallChecker.varInit(object, "object", 109, 3743, 3843);
            CallChecker.varInit(this.collection, "collection", 109, 3743, 3843);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 109, 3743, 3843);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1540.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1541 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 114, 3850, 3973);
            CallChecker.varInit(coll, "coll", 114, 3850, 3973);
            CallChecker.varInit(this.collection, "collection", 114, 3850, 3973);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 114, 3850, 3973);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1541.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1542 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 119, 3980, 4071);
            CallChecker.varInit(this.collection, "collection", 119, 3980, 4071);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 119, 3980, 4071);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1542.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context1543 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 124, 4078, 4186);
            CallChecker.varInit(object, "object", 124, 4078, 4186);
            CallChecker.varInit(this.collection, "collection", 124, 4078, 4186);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 124, 4078, 4186);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1543.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1544 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 129, 4193, 4309);
            CallChecker.varInit(coll, "coll", 129, 4193, 4309);
            CallChecker.varInit(this.collection, "collection", 129, 4193, 4309);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 129, 4193, 4309);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1544.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1545 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 134, 4316, 4432);
            CallChecker.varInit(coll, "coll", 134, 4316, 4432);
            CallChecker.varInit(this.collection, "collection", 134, 4316, 4432);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 134, 4316, 4432);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1545.methodEnd();
        }
    }

    @Override
    public boolean add(E object, int count) {
        MethodContext _bcornu_methode_context1546 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 140, 4439, 4628);
            CallChecker.varInit(count, "count", 140, 4439, 4628);
            CallChecker.varInit(object, "object", 140, 4439, 4628);
            CallChecker.varInit(this.collection, "collection", 140, 4439, 4628);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 140, 4439, 4628);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1546.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object, int count) {
        MethodContext _bcornu_methode_context1547 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 145, 4635, 4754);
            CallChecker.varInit(count, "count", 145, 4635, 4754);
            CallChecker.varInit(object, "object", 145, 4635, 4754);
            CallChecker.varInit(this.collection, "collection", 145, 4635, 4754);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 145, 4635, 4754);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1547.methodEnd();
        }
    }

    @Override
    public Set<E> uniqueSet() {
        MethodContext _bcornu_methode_context1548 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 150, 4761, 4899);
            CallChecker.varInit(this.collection, "collection", 150, 4761, 4899);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableSortedBag.serialVersionUID", 150, 4761, 4899);
            final SortedBag<E> npe_invocation_var295 = decorated();
            Set<E> set = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(npe_invocation_var295, SortedBag.class, 151, 4824, 4834)) {
                set = CallChecker.isCalled(npe_invocation_var295, SortedBag.class, 151, 4824, 4834).uniqueSet();
                CallChecker.varAssign(set, "set", 151, 4824, 4834);
            }
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1548.methodEnd();
        }
    }
}

