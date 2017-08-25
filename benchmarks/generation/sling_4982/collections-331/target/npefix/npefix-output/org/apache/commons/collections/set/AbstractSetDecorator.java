package org.apache.commons.collections.set;

import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

public abstract class AbstractSetDecorator<E> extends AbstractCollectionDecorator<E> implements Set<E> {
    private static final long serialVersionUID = -4678668309576958546L;

    protected AbstractSetDecorator() {
        super();
        MethodContext _bcornu_methode_context403 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context403.methodEnd();
        }
    }

    protected AbstractSetDecorator(Set<E> set) {
        super(set);
        MethodContext _bcornu_methode_context404 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context404.methodEnd();
        }
    }

    @Override
    protected Set<E> decorated() {
        MethodContext _bcornu_methode_context2116 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 64, 1969, 2155);
            CallChecker.varInit(this.collection, "collection", 64, 1969, 2155);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSetDecorator.serialVersionUID", 64, 1969, 2155);
            return ((Set<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2116.methodEnd();
        }
    }
}

