package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class EmptyListIterator<E> extends AbstractEmptyIterator<E> implements ResettableListIterator<E> {
    public static final ResettableListIterator<Object> RESETTABLE_INSTANCE = new EmptyListIterator<Object>();

    public static final ListIterator<Object> INSTANCE = EmptyListIterator.RESETTABLE_INSTANCE;

    @SuppressWarnings(value = "unchecked")
    public static <E> ResettableListIterator<E> getResettableInstance() {
        MethodContext _bcornu_methode_context2376 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.iterators.EmptyListIterator.INSTANCE", 56, 1910, 2211);
            CallChecker.varInit(RESETTABLE_INSTANCE, "org.apache.commons.collections.iterators.EmptyListIterator.RESETTABLE_INSTANCE", 56, 1910, 2211);
            return ((ResettableListIterator<E>) (EmptyListIterator.RESETTABLE_INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2376.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> ListIterator<E> getInstance() {
        MethodContext _bcornu_methode_context2377 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.iterators.EmptyListIterator.INSTANCE", 66, 2218, 2468);
            CallChecker.varInit(RESETTABLE_INSTANCE, "org.apache.commons.collections.iterators.EmptyListIterator.RESETTABLE_INSTANCE", 66, 2218, 2468);
            return ((ListIterator<E>) (EmptyListIterator.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2377.methodEnd();
        }
    }

    protected EmptyListIterator() {
        super();
        MethodContext _bcornu_methode_context449 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context449.methodEnd();
        }
    }
}

