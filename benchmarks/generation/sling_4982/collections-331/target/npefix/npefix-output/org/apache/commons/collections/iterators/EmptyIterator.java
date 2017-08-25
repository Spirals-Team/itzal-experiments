package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class EmptyIterator<E> extends AbstractEmptyIterator<E> implements ResettableIterator<E> {
    public static final ResettableIterator<Object> RESETTABLE_INSTANCE = new EmptyIterator<Object>();

    public static final Iterator<Object> INSTANCE = EmptyIterator.RESETTABLE_INSTANCE;

    @SuppressWarnings(value = "unchecked")
    public static <E> ResettableIterator<E> getResettableInstance() {
        MethodContext _bcornu_methode_context1506 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.iterators.EmptyIterator.INSTANCE", 55, 1865, 2156);
            CallChecker.varInit(RESETTABLE_INSTANCE, "org.apache.commons.collections.iterators.EmptyIterator.RESETTABLE_INSTANCE", 55, 1865, 2156);
            return ((ResettableIterator<E>) (EmptyIterator.RESETTABLE_INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1506.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Iterator<E> getInstance() {
        MethodContext _bcornu_methode_context1507 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.iterators.EmptyIterator.INSTANCE", 65, 2163, 2392);
            CallChecker.varInit(RESETTABLE_INSTANCE, "org.apache.commons.collections.iterators.EmptyIterator.RESETTABLE_INSTANCE", 65, 2163, 2392);
            return ((Iterator<E>) (EmptyIterator.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1507.methodEnd();
        }
    }

    protected EmptyIterator() {
        super();
        MethodContext _bcornu_methode_context283 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context283.methodEnd();
        }
    }
}

