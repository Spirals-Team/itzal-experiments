package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

public class PredicatedSet<E> extends PredicatedCollection<E> implements Set<E> {
    private static final long serialVersionUID = -684521469108685117L;

    public static <T> Set<T> decorate(Set<T> set, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context972 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(predicate, "predicate", 60, 1918, 2561);
            CallChecker.varInit(set, "set", 60, 1918, 2561);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSet.serialVersionUID", 60, 1918, 2561);
            return new PredicatedSet<T>(set, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context972.methodEnd();
        }
    }

    protected PredicatedSet(Set<E> set, Predicate<? super E> predicate) {
        super(set, predicate);
        MethodContext _bcornu_methode_context185 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context185.methodEnd();
        }
    }

    @Override
    protected Set<E> decorated() {
        MethodContext _bcornu_methode_context973 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 86, 3214, 3400);
            CallChecker.varInit(this.collection, "collection", 86, 3214, 3400);
            CallChecker.varInit(this.predicate, "predicate", 86, 3214, 3400);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSet.serialVersionUID", 86, 3214, 3400);
            return ((Set<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context973.methodEnd();
        }
    }
}

