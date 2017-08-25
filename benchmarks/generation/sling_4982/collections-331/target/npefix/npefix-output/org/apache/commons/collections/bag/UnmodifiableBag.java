package org.apache.commons.collections.bag;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.Unmodifiable;
import java.util.Set;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.Bag;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class UnmodifiableBag<E> extends AbstractBagDecorator<E> implements Serializable , Unmodifiable {
    private static final long serialVersionUID = -1873799975157099624L;

    public static <E> Bag<E> decorate(Bag<E> bag) {
        MethodContext _bcornu_methode_context1471 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(bag, "bag", 59, 1892, 2369);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 59, 1892, 2369);
            if (bag instanceof Unmodifiable) {
                return bag;
            }
            return new UnmodifiableBag<E>(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1471.methodEnd();
        }
    }

    private UnmodifiableBag(Bag<E> bag) {
        super(bag);
        MethodContext _bcornu_methode_context276 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context276.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1472 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 2703, 3070);
            CallChecker.varInit(out, "out", 84, 2703, 3070);
            CallChecker.varInit(this.collection, "collection", 84, 2703, 3070);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 84, 2703, 3070);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 85, 3003, 3005)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 85, 3003, 3005);
                CallChecker.isCalled(out, ObjectOutputStream.class, 85, 3003, 3005).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 86, 3037, 3039)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 86, 3037, 3039);
                CallChecker.isCalled(out, ObjectOutputStream.class, 86, 3037, 3039).writeObject(collection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1472.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1473 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 97, 3077, 3471);
            CallChecker.varInit(in, "in", 97, 3077, 3471);
            CallChecker.varInit(this.collection, "collection", 97, 3077, 3471);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 97, 3077, 3471);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 98, 3389, 3390)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 98, 3389, 3390);
                CallChecker.isCalled(in, ObjectInputStream.class, 98, 3389, 3390).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 99, 3450, 3451)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 99, 3450, 3451);
                collection = ((Collection<E>) (CallChecker.isCalled(in, ObjectInputStream.class, 99, 3450, 3451).readObject()));
                CallChecker.varAssign(this.collection, "this.collection", 99, 3421, 3465);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1473.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1474 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 104, 3478, 3679);
            CallChecker.varInit(this.collection, "collection", 104, 3478, 3679);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 104, 3478, 3679);
            final Bag<E> npe_invocation_var289 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var289, Bag.class, 105, 3650, 3660)) {
                return UnmodifiableIterator.<E>decorate(CallChecker.isCalled(npe_invocation_var289, Bag.class, 105, 3650, 3660).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1474.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context1475 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 109, 3686, 3786);
            CallChecker.varInit(object, "object", 109, 3686, 3786);
            CallChecker.varInit(this.collection, "collection", 109, 3686, 3786);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 109, 3686, 3786);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1475.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1476 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 114, 3793, 3916);
            CallChecker.varInit(coll, "coll", 114, 3793, 3916);
            CallChecker.varInit(this.collection, "collection", 114, 3793, 3916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 114, 3793, 3916);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1476.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1477 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 119, 3923, 4014);
            CallChecker.varInit(this.collection, "collection", 119, 3923, 4014);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 119, 3923, 4014);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1477.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context1478 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 124, 4021, 4129);
            CallChecker.varInit(object, "object", 124, 4021, 4129);
            CallChecker.varInit(this.collection, "collection", 124, 4021, 4129);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 124, 4021, 4129);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1478.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1479 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 129, 4136, 4252);
            CallChecker.varInit(coll, "coll", 129, 4136, 4252);
            CallChecker.varInit(this.collection, "collection", 129, 4136, 4252);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 129, 4136, 4252);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1479.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1480 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 134, 4259, 4375);
            CallChecker.varInit(coll, "coll", 134, 4259, 4375);
            CallChecker.varInit(this.collection, "collection", 134, 4259, 4375);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 134, 4259, 4375);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1480.methodEnd();
        }
    }

    @Override
    public boolean add(E object, int count) {
        MethodContext _bcornu_methode_context1481 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 140, 4382, 4571);
            CallChecker.varInit(count, "count", 140, 4382, 4571);
            CallChecker.varInit(object, "object", 140, 4382, 4571);
            CallChecker.varInit(this.collection, "collection", 140, 4382, 4571);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 140, 4382, 4571);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1481.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object, int count) {
        MethodContext _bcornu_methode_context1482 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 145, 4578, 4697);
            CallChecker.varInit(count, "count", 145, 4578, 4697);
            CallChecker.varInit(object, "object", 145, 4578, 4697);
            CallChecker.varInit(this.collection, "collection", 145, 4578, 4697);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 145, 4578, 4697);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1482.methodEnd();
        }
    }

    @Override
    public Set<E> uniqueSet() {
        MethodContext _bcornu_methode_context1483 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 150, 4704, 4845);
            CallChecker.varInit(this.collection, "collection", 150, 4704, 4845);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.UnmodifiableBag.serialVersionUID", 150, 4704, 4845);
            final Bag<E> npe_invocation_var290 = decorated();
            Set<E> set = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(npe_invocation_var290, Bag.class, 151, 4767, 4777)) {
                set = CallChecker.isCalled(npe_invocation_var290, Bag.class, 151, 4767, 4777).uniqueSet();
                CallChecker.varAssign(set, "set", 151, 4767, 4777);
            }
            return UnmodifiableSet.<E>decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1483.methodEnd();
        }
    }
}

