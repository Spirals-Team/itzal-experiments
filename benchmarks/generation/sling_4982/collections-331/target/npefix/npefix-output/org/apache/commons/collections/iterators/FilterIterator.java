package org.apache.commons.collections.iterators;

import org.apache.commons.collections.Predicate;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class FilterIterator<E> implements Iterator<E> {
    private Iterator<? extends E> iterator;

    private Predicate<? super E> predicate;

    private E nextObject;

    private boolean nextObjectSet = false;

    public FilterIterator() {
        super();
        MethodContext _bcornu_methode_context374 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context374.methodEnd();
        }
    }

    public FilterIterator(Iterator<? extends E> iterator) {
        super();
        MethodContext _bcornu_methode_context375 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 66, 2422, 2446);
        } finally {
            _bcornu_methode_context375.methodEnd();
        }
    }

    public FilterIterator(Iterator<? extends E> iterator, Predicate<? super E> predicate) {
        super();
        MethodContext _bcornu_methode_context376 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 78, 2792, 2816);
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 79, 2826, 2852);
        } finally {
            _bcornu_methode_context376.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1936 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 90, 2865, 3304);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 90, 2865, 3304);
            CallChecker.varInit(this.nextObject, "nextObject", 90, 2865, 3304);
            CallChecker.varInit(this.predicate, "predicate", 90, 2865, 3304);
            CallChecker.varInit(this.iterator, "iterator", 90, 2865, 3304);
            return (nextObjectSet) || (setNextObject());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1936.methodEnd();
        }
    }

    public E next() {
        if (!(nextObjectSet)) {
            if (!(setNextObject())) {
                throw new NoSuchElementException();
            }
        }
        nextObjectSet = false;
        CallChecker.varAssign(this.nextObjectSet, "this.nextObjectSet", 108, 3810, 3831);
        return nextObject;
    }

    public void remove() {
        MethodContext _bcornu_methode_context1938 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 123, 3871, 4474);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 123, 3871, 4474);
            CallChecker.varInit(this.nextObject, "nextObject", 123, 3871, 4474);
            CallChecker.varInit(this.predicate, "predicate", 123, 3871, 4474);
            CallChecker.varInit(this.iterator, "iterator", 123, 3871, 4474);
            if (nextObjectSet) {
                throw new IllegalStateException("remove() cannot be called");
            }
            if (CallChecker.beforeDeref(iterator, Iterator.class, 127, 4451, 4458)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 127, 4451, 4458);
                CallChecker.isCalled(iterator, Iterator.class, 127, 4451, 4458).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1938.methodEnd();
        }
    }

    public Iterator<? extends E> getIterator() {
        MethodContext _bcornu_methode_context1939 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 136, 4481, 4734);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 136, 4481, 4734);
            CallChecker.varInit(this.nextObject, "nextObject", 136, 4481, 4734);
            CallChecker.varInit(this.predicate, "predicate", 136, 4481, 4734);
            CallChecker.varInit(this.iterator, "iterator", 136, 4481, 4734);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<? extends E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1939.methodEnd();
        }
    }

    public void setIterator(Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context1940 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 146, 4741, 5085);
            CallChecker.varInit(iterator, "iterator", 146, 4741, 5085);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 146, 4741, 5085);
            CallChecker.varInit(this.nextObject, "nextObject", 146, 4741, 5085);
            CallChecker.varInit(this.predicate, "predicate", 146, 4741, 5085);
            CallChecker.varInit(this.iterator, "iterator", 146, 4741, 5085);
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 147, 4997, 5021);
            nextObject = null;
            CallChecker.varAssign(this.nextObject, "this.nextObject", 148, 5031, 5048);
            nextObjectSet = false;
            CallChecker.varAssign(this.nextObjectSet, "this.nextObjectSet", 149, 5058, 5079);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1940.methodEnd();
        }
    }

    public Predicate<? super E> getPredicate() {
        MethodContext _bcornu_methode_context1941 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(this, "this", 158, 5092, 5348);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 158, 5092, 5348);
            CallChecker.varInit(this.nextObject, "nextObject", 158, 5092, 5348);
            CallChecker.varInit(this.predicate, "predicate", 158, 5092, 5348);
            CallChecker.varInit(this.iterator, "iterator", 158, 5092, 5348);
            return predicate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1941.methodEnd();
        }
    }

    public void setPredicate(Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context1942 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 167, 5355, 5634);
            CallChecker.varInit(predicate, "predicate", 167, 5355, 5634);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 167, 5355, 5634);
            CallChecker.varInit(this.nextObject, "nextObject", 167, 5355, 5634);
            CallChecker.varInit(this.predicate, "predicate", 167, 5355, 5634);
            CallChecker.varInit(this.iterator, "iterator", 167, 5355, 5634);
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 168, 5544, 5570);
            nextObject = null;
            CallChecker.varAssign(this.nextObject, "this.nextObject", 169, 5580, 5597);
            nextObjectSet = false;
            CallChecker.varAssign(this.nextObjectSet, "this.nextObjectSet", 170, 5607, 5628);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1942.methodEnd();
        }
    }

    private boolean setNextObject() {
        MethodContext _bcornu_methode_context1943 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 178, 5641, 6168);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 178, 5641, 6168);
            CallChecker.varInit(this.nextObject, "nextObject", 178, 5641, 6168);
            CallChecker.varInit(this.predicate, "predicate", 178, 5641, 6168);
            CallChecker.varInit(this.iterator, "iterator", 178, 5641, 6168);
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 179, 5906, 5913);
            while (CallChecker.isCalled(iterator, Iterator.class, 179, 5906, 5913).hasNext()) {
                E object = CallChecker.init(null);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 180, 5951, 5958)) {
                    object = iterator.next();
                    CallChecker.varAssign(object, "object", 180, 5951, 5958);
                }
                if (CallChecker.beforeDeref(predicate, Predicate.class, 181, 5984, 5992)) {
                    predicate = CallChecker.beforeCalled(predicate, Predicate.class, 181, 5984, 5992);
                    if (CallChecker.isCalled(predicate, Predicate.class, 181, 5984, 5992).evaluate(object)) {
                        nextObject = object;
                        CallChecker.varAssign(this.nextObject, "this.nextObject", 182, 6030, 6049);
                        nextObjectSet = true;
                        CallChecker.varAssign(this.nextObjectSet, "this.nextObjectSet", 183, 6067, 6087);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1943.methodEnd();
        }
    }
}

