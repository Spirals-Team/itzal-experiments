package org.apache.commons.collections.collection;

import org.apache.commons.collections.iterators.UnmodifiableIterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.BoundedCollection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class UnmodifiableBoundedCollection<E> extends AbstractCollectionDecorator<E> implements BoundedCollection<E> {
    private static final long serialVersionUID = -7112672385450340330L;

    public static <E> BoundedCollection<E> decorate(BoundedCollection<E> coll) {
        MethodContext _bcornu_methode_context1665 = new MethodContext(BoundedCollection.class);
        try {
            CallChecker.varInit(coll, "coll", 57, 2031, 2455);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 57, 2031, 2455);
            return new UnmodifiableBoundedCollection<E>(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BoundedCollection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1665.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> BoundedCollection<E> decorateUsing(Collection<? super E> coll) {
        MethodContext _bcornu_methode_context1666 = new MethodContext(BoundedCollection.class);
        try {
            CallChecker.varInit(coll, "coll", 72, 2462, 3892);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 72, 2462, 3892);
            if (coll == null) {
                throw new IllegalArgumentException("The collection must not be null");
            }
            for (int i = 0; i < 1000; i++) {
                if (coll instanceof BoundedCollection) {
                    break;
                }
                if (coll instanceof AbstractCollectionDecorator) {
                    coll = ((AbstractCollectionDecorator<E>) (coll)).collection;
                    CallChecker.varAssign(coll, "coll", 83, 3425, 3482);
                }else
                    if (coll instanceof SynchronizedCollection) {
                        coll = ((SynchronizedCollection<E>) (coll)).collection;
                        CallChecker.varAssign(coll, "coll", 85, 3565, 3617);
                    }
                
            }
            if ((coll instanceof BoundedCollection) == false) {
                throw new IllegalArgumentException("The collection is not a bounded collection");
            }
            return new UnmodifiableBoundedCollection<E>(((BoundedCollection<E>) (coll)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BoundedCollection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1666.methodEnd();
        }
    }

    private UnmodifiableBoundedCollection(BoundedCollection<E> coll) {
        super(coll);
        MethodContext _bcornu_methode_context323 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context323.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1667 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 107, 4186, 4384);
            CallChecker.varInit(this.collection, "collection", 107, 4186, 4384);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 107, 4186, 4384);
            final BoundedCollection<E> npe_invocation_var329 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var329, BoundedCollection.class, 108, 4355, 4365)) {
                return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var329, BoundedCollection.class, 108, 4355, 4365).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1667.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context1668 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 112, 4391, 4491);
            CallChecker.varInit(object, "object", 112, 4391, 4491);
            CallChecker.varInit(this.collection, "collection", 112, 4391, 4491);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 112, 4391, 4491);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1668.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1669 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 117, 4498, 4621);
            CallChecker.varInit(coll, "coll", 117, 4498, 4621);
            CallChecker.varInit(this.collection, "collection", 117, 4498, 4621);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 117, 4498, 4621);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1669.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1670 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 122, 4628, 4719);
            CallChecker.varInit(this.collection, "collection", 122, 4628, 4719);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 122, 4628, 4719);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1670.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context1671 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 127, 4726, 4834);
            CallChecker.varInit(object, "object", 127, 4726, 4834);
            CallChecker.varInit(this.collection, "collection", 127, 4726, 4834);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 127, 4726, 4834);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1671.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1672 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 132, 4841, 4957);
            CallChecker.varInit(coll, "coll", 132, 4841, 4957);
            CallChecker.varInit(this.collection, "collection", 132, 4841, 4957);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 132, 4841, 4957);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1672.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1673 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 137, 4964, 5080);
            CallChecker.varInit(coll, "coll", 137, 4964, 5080);
            CallChecker.varInit(this.collection, "collection", 137, 4964, 5080);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 137, 4964, 5080);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1673.methodEnd();
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context1674 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 142, 5087, 5232);
            CallChecker.varInit(this.collection, "collection", 142, 5087, 5232);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 142, 5087, 5232);
            final BoundedCollection<E> npe_invocation_var330 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var330, BoundedCollection.class, 143, 5206, 5216)) {
                return CallChecker.isCalled(npe_invocation_var330, BoundedCollection.class, 143, 5206, 5216).isFull();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1674.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context1675 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 146, 5239, 5304);
            CallChecker.varInit(this.collection, "collection", 146, 5239, 5304);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 146, 5239, 5304);
            final BoundedCollection<E> npe_invocation_var331 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var331, BoundedCollection.class, 147, 5277, 5287)) {
                return CallChecker.isCalled(npe_invocation_var331, BoundedCollection.class, 147, 5277, 5287).maxSize();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1675.methodEnd();
        }
    }

    @Override
    protected BoundedCollection<E> decorated() {
        MethodContext _bcornu_methode_context1676 = new MethodContext(BoundedCollection.class);
        try {
            CallChecker.varInit(this, "this", 154, 5311, 5468);
            CallChecker.varInit(this.collection, "collection", 154, 5311, 5468);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableBoundedCollection.serialVersionUID", 154, 5311, 5468);
            return ((BoundedCollection<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BoundedCollection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1676.methodEnd();
        }
    }
}

