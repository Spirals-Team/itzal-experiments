package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractIteratorDecorator<E> extends AbstractUntypedIteratorDecorator<E, E> {
    protected AbstractIteratorDecorator(Iterator<E> iterator) {
        super(iterator);
        MethodContext _bcornu_methode_context122 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    public E next() {
        final Iterator<E> npe_invocation_var177 = getIterator();
        if (CallChecker.beforeDeref(npe_invocation_var177, Iterator.class, 46, 1745, 1757)) {
            return npe_invocation_var177.next();
        }else
            throw new AbnormalExecutionError();
        
    }
}

