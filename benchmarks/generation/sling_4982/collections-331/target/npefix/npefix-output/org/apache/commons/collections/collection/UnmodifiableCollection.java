package org.apache.commons.collections.collection;

import org.apache.commons.collections.iterators.UnmodifiableIterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Unmodifiable;

public final class UnmodifiableCollection<E> extends AbstractCollectionDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = -239892006883819945L;

    public static <T> Collection<T> decorate(Collection<T> coll) {
        MethodContext _bcornu_methode_context1897 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(coll, "coll", 55, 1720, 2319);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 55, 1720, 2319);
            if (coll instanceof Unmodifiable) {
                return coll;
            }
            return new UnmodifiableCollection<T>(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1897.methodEnd();
        }
    }

    private UnmodifiableCollection(Collection<E> coll) {
        super(coll);
        MethodContext _bcornu_methode_context364 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context364.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1898 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 75, 2684, 2882);
            CallChecker.varInit(this.collection, "collection", 75, 2684, 2882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 75, 2684, 2882);
            final Collection<E> npe_invocation_var370 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var370, Collection.class, 76, 2853, 2863)) {
                return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var370, Collection.class, 76, 2853, 2863).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1898.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context1899 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 80, 2889, 2989);
            CallChecker.varInit(object, "object", 80, 2889, 2989);
            CallChecker.varInit(this.collection, "collection", 80, 2889, 2989);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 80, 2889, 2989);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1899.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1900 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 85, 2996, 3119);
            CallChecker.varInit(coll, "coll", 85, 2996, 3119);
            CallChecker.varInit(this.collection, "collection", 85, 2996, 3119);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 85, 2996, 3119);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1900.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1901 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 90, 3126, 3217);
            CallChecker.varInit(this.collection, "collection", 90, 3126, 3217);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 90, 3126, 3217);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1901.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context1902 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 95, 3224, 3332);
            CallChecker.varInit(object, "object", 95, 3224, 3332);
            CallChecker.varInit(this.collection, "collection", 95, 3224, 3332);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 95, 3224, 3332);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1902.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1903 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 100, 3339, 3455);
            CallChecker.varInit(coll, "coll", 100, 3339, 3455);
            CallChecker.varInit(this.collection, "collection", 100, 3339, 3455);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 100, 3339, 3455);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1903.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1904 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 105, 3462, 3578);
            CallChecker.varInit(coll, "coll", 105, 3462, 3578);
            CallChecker.varInit(this.collection, "collection", 105, 3462, 3578);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.UnmodifiableCollection.serialVersionUID", 105, 3462, 3578);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1904.methodEnd();
        }
    }
}

