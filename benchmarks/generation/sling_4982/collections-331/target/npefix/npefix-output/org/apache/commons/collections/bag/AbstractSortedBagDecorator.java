package org.apache.commons.collections.bag;

import org.apache.commons.collections.SortedBag;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractSortedBagDecorator<E> extends AbstractBagDecorator<E> implements SortedBag<E> {
    private static final long serialVersionUID = -8223473624050467718L;

    protected AbstractSortedBagDecorator() {
        super();
        MethodContext _bcornu_methode_context2 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    protected AbstractSortedBagDecorator(SortedBag<E> bag) {
        super(bag);
        MethodContext _bcornu_methode_context3 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    @Override
    protected SortedBag<E> decorated() {
        MethodContext _bcornu_methode_context4 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(this, "this", 63, 1927, 2125);
            CallChecker.varInit(this.collection, "collection", 63, 1927, 2125);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.AbstractSortedBagDecorator.serialVersionUID", 63, 1927, 2125);
            return ((SortedBag<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public E first() {
        final SortedBag<E> npe_invocation_var0 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var0, SortedBag.class, 69, 2244, 2254)) {
            return npe_invocation_var0.first();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E last() {
        final SortedBag<E> npe_invocation_var1 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var1, SortedBag.class, 73, 2309, 2319)) {
            return npe_invocation_var1.last();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context7 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 76, 2340, 2429);
            CallChecker.varInit(this.collection, "collection", 76, 2340, 2429);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.AbstractSortedBagDecorator.serialVersionUID", 76, 2340, 2429);
            final SortedBag<E> npe_invocation_var2 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var2, SortedBag.class, 77, 2399, 2409)) {
                return CallChecker.isCalled(npe_invocation_var2, SortedBag.class, 77, 2399, 2409).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }
}

