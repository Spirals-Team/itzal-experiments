package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class EnumerationIterator<E> implements Iterator<E> {
    private final Collection<? super E> collection;

    private Enumeration<? extends E> enumeration;

    private E last;

    public EnumerationIterator() {
        this(null, null);
        MethodContext _bcornu_methode_context315 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context315.methodEnd();
        }
    }

    public EnumerationIterator(final Enumeration<? extends E> enumeration) {
        this(enumeration, null);
        MethodContext _bcornu_methode_context316 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context316.methodEnd();
        }
    }

    public EnumerationIterator(final Enumeration<? extends E> enumeration, final Collection<? super E> collection) {
        super();
        MethodContext _bcornu_methode_context317 = new MethodContext(null);
        try {
            this.enumeration = enumeration;
            CallChecker.varAssign(this.enumeration, "this.enumeration", 71, 2685, 2715);
            this.collection = collection;
            CallChecker.varAssign(this.collection, "this.collection", 72, 2725, 2753);
            this.last = null;
            CallChecker.varAssign(this.last, "this.last", 73, 2763, 2779);
        } finally {
            _bcornu_methode_context317.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1613 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 84, 2792, 3208);
            CallChecker.varInit(this.last, "last", 84, 2792, 3208);
            CallChecker.varInit(this.enumeration, "enumeration", 84, 2792, 3208);
            CallChecker.varInit(this.collection, "collection", 84, 2792, 3208);
            if (CallChecker.beforeDeref(enumeration, Enumeration.class, 85, 3173, 3183)) {
                enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 85, 3173, 3183);
                return CallChecker.isCalled(enumeration, Enumeration.class, 85, 3173, 3183).hasMoreElements();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1613.methodEnd();
        }
    }

    public E next() {
        if (CallChecker.beforeDeref(enumeration, Enumeration.class, 95, 3439, 3449)) {
            last = enumeration.nextElement();
            CallChecker.varAssign(this.last, "this.last", 95, 3432, 3464);
        }
        return last;
    }

    public void remove() {
        MethodContext _bcornu_methode_context1615 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 109, 3498, 4347);
            CallChecker.varInit(this.last, "last", 109, 3498, 4347);
            CallChecker.varInit(this.enumeration, "enumeration", 109, 3498, 4347);
            CallChecker.varInit(this.collection, "collection", 109, 3498, 4347);
            if ((collection) != null) {
                if ((last) != null) {
                    collection.remove(last);
                }else {
                    throw new IllegalStateException("next() must have been called for remove() to function");
                }
            }else {
                throw new UnsupportedOperationException("No Collection associated with this Iterator");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1615.methodEnd();
        }
    }

    public Enumeration<? extends E> getEnumeration() {
        MethodContext _bcornu_methode_context1616 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 128, 4354, 4641);
            CallChecker.varInit(this.last, "last", 128, 4354, 4641);
            CallChecker.varInit(this.enumeration, "enumeration", 128, 4354, 4641);
            CallChecker.varInit(this.collection, "collection", 128, 4354, 4641);
            return enumeration;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<? extends E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1616.methodEnd();
        }
    }

    public void setEnumeration(final Enumeration<? extends E> enumeration) {
        MethodContext _bcornu_methode_context1617 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 137, 4648, 4886);
            CallChecker.varInit(enumeration, "enumeration", 137, 4648, 4886);
            CallChecker.varInit(this.last, "last", 137, 4648, 4886);
            CallChecker.varInit(this.enumeration, "enumeration", 137, 4648, 4886);
            CallChecker.varInit(this.collection, "collection", 137, 4648, 4886);
            this.enumeration = enumeration;
            CallChecker.varAssign(this.enumeration, "this.enumeration", 138, 4850, 4880);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1617.methodEnd();
        }
    }
}

