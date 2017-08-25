package org.apache.commons.collections.set;

import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.Unmodifiable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Set;

public final class UnmodifiableSet<E> extends AbstractSerializableSetDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 6499119872185240161L;

    public static <E> Set<E> decorate(Set<E> set) {
        MethodContext _bcornu_methode_context638 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(set, "set", 51, 1669, 2031);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 51, 1669, 2031);
            if (set instanceof Unmodifiable) {
                return set;
            }
            return new UnmodifiableSet<E>(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context638.methodEnd();
        }
    }

    private UnmodifiableSet(Set<E> set) {
        super(set);
        MethodContext _bcornu_methode_context114 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context639 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 71, 2365, 2566);
            CallChecker.varInit(this.collection, "collection", 71, 2365, 2566);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 71, 2365, 2566);
            final Set<E> npe_invocation_var146 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var146, Set.class, 72, 2537, 2547)) {
                return UnmodifiableIterator.<E>decorate(CallChecker.isCalled(npe_invocation_var146, Set.class, 72, 2537, 2547).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context639.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context640 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 76, 2573, 2673);
            CallChecker.varInit(object, "object", 76, 2573, 2673);
            CallChecker.varInit(this.collection, "collection", 76, 2573, 2673);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 76, 2573, 2673);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context640.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context641 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 81, 2680, 2803);
            CallChecker.varInit(coll, "coll", 81, 2680, 2803);
            CallChecker.varInit(this.collection, "collection", 81, 2680, 2803);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 81, 2680, 2803);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context641.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context642 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 2810, 2901);
            CallChecker.varInit(this.collection, "collection", 86, 2810, 2901);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 86, 2810, 2901);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context642.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context643 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 91, 2908, 3016);
            CallChecker.varInit(object, "object", 91, 2908, 3016);
            CallChecker.varInit(this.collection, "collection", 91, 2908, 3016);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 91, 2908, 3016);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context643.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context644 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 96, 3023, 3139);
            CallChecker.varInit(coll, "coll", 96, 3023, 3139);
            CallChecker.varInit(this.collection, "collection", 96, 3023, 3139);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 96, 3023, 3139);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context644.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context645 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 101, 3146, 3262);
            CallChecker.varInit(coll, "coll", 101, 3146, 3262);
            CallChecker.varInit(this.collection, "collection", 101, 3146, 3262);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.UnmodifiableSet.serialVersionUID", 101, 3146, 3262);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context645.methodEnd();
        }
    }
}

