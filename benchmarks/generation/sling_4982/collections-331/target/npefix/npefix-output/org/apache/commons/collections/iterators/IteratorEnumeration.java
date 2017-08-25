package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class IteratorEnumeration<E> implements Enumeration<E> {
    private Iterator<? extends E> iterator;

    public IteratorEnumeration() {
        super();
        MethodContext _bcornu_methode_context9 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public IteratorEnumeration(Iterator<? extends E> iterator) {
        super();
        MethodContext _bcornu_methode_context10 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 52, 1864, 1888);
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public boolean hasMoreElements() {
        MethodContext _bcornu_methode_context41 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 63, 1901, 2237);
            CallChecker.varInit(this.iterator, "iterator", 63, 1901, 2237);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 64, 2213, 2220)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 64, 2213, 2220);
                return CallChecker.isCalled(iterator, Iterator.class, 64, 2213, 2220).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public E nextElement() {
        if (CallChecker.beforeDeref(iterator, Iterator.class, 75, 2535, 2542)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Iterator<? extends E> getIterator() {
        MethodContext _bcornu_methode_context43 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 86, 2563, 2839);
            CallChecker.varInit(this.iterator, "iterator", 86, 2563, 2839);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<? extends E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public void setIterator(Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context44 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 95, 2846, 3054);
            CallChecker.varInit(iterator, "iterator", 95, 2846, 3054);
            CallChecker.varInit(this.iterator, "iterator", 95, 2846, 3054);
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 96, 3024, 3048);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }
}

