package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.OrderedIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class EmptyOrderedIterator<E> extends AbstractEmptyIterator<E> implements OrderedIterator<E> , ResettableIterator<E> {
    public static final OrderedIterator<Object> INSTANCE = new EmptyOrderedIterator<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <E> OrderedIterator<E> getInstance() {
        MethodContext _bcornu_methode_context26 = new MethodContext(OrderedIterator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.iterators.EmptyOrderedIterator.INSTANCE", 44, 1519, 1764);
            return ((OrderedIterator<E>) (EmptyOrderedIterator.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    protected EmptyOrderedIterator() {
        super();
        MethodContext _bcornu_methode_context6 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }
}

