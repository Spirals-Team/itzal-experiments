package org.apache.commons.collections.set;

import org.apache.commons.collections.collection.SynchronizedCollection;
import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
    private static final long serialVersionUID = -8304417378626543635L;

    public static <T> Set<T> decorate(Set<T> set) {
        MethodContext _bcornu_methode_context1098 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(set, "set", 47, 1553, 1837);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSet.serialVersionUID", 47, 1553, 1837);
            return new SynchronizedSet<T>(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1098.methodEnd();
        }
    }

    protected SynchronizedSet(Set<E> set) {
        super(set);
        MethodContext _bcornu_methode_context217 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context217.methodEnd();
        }
    }

    protected SynchronizedSet(Set<E> set, Object lock) {
        super(set, lock);
        MethodContext _bcornu_methode_context218 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context218.methodEnd();
        }
    }

    protected Set<E> getSet() {
        MethodContext _bcornu_methode_context1099 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 78, 2508, 2664);
            CallChecker.varInit(this.lock, "lock", 78, 2508, 2664);
            CallChecker.varInit(this.collection, "collection", 78, 2508, 2664);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSet.serialVersionUID", 78, 2508, 2664);
            return ((Set<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1099.methodEnd();
        }
    }
}

