package org.apache.commons.collections.iterators;

import org.apache.commons.collections.functors.UniquePredicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;

public class UniqueFilterIterator<E> extends FilterIterator<E> {
    public UniqueFilterIterator(Iterator<E> iterator) {
        super(iterator, UniquePredicate.getInstance());
        MethodContext _bcornu_methode_context75 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }
}

