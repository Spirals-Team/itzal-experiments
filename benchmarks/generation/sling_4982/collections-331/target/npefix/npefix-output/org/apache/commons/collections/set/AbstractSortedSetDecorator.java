package org.apache.commons.collections.set;

import java.util.SortedSet;
import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractSortedSetDecorator<E> extends AbstractSetDecorator<E> implements SortedSet<E> {
    private static final long serialVersionUID = -3462240946294214398L;

    protected AbstractSortedSetDecorator() {
        super();
        MethodContext _bcornu_methode_context208 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context208.methodEnd();
        }
    }

    protected AbstractSortedSetDecorator(Set<E> set) {
        super(set);
        MethodContext _bcornu_methode_context209 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context209.methodEnd();
        }
    }

    @Override
    protected SortedSet<E> decorated() {
        MethodContext _bcornu_methode_context1066 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 65, 1985, 2183);
            CallChecker.varInit(this.collection, "collection", 65, 1985, 2183);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSortedSetDecorator.serialVersionUID", 65, 1985, 2183);
            return ((SortedSet<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1066.methodEnd();
        }
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        MethodContext _bcornu_methode_context1067 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 70, 2190, 2388);
            CallChecker.varInit(toElement, "toElement", 70, 2190, 2388);
            CallChecker.varInit(fromElement, "fromElement", 70, 2190, 2388);
            CallChecker.varInit(this.collection, "collection", 70, 2190, 2388);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSortedSetDecorator.serialVersionUID", 70, 2190, 2388);
            final SortedSet<E> npe_invocation_var237 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var237, SortedSet.class, 71, 2340, 2350)) {
                return CallChecker.isCalled(npe_invocation_var237, SortedSet.class, 71, 2340, 2350).subSet(fromElement, toElement);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1067.methodEnd();
        }
    }

    public SortedSet<E> headSet(E toElement) {
        MethodContext _bcornu_methode_context1068 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 74, 2395, 2489);
            CallChecker.varInit(toElement, "toElement", 74, 2395, 2489);
            CallChecker.varInit(this.collection, "collection", 74, 2395, 2489);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSortedSetDecorator.serialVersionUID", 74, 2395, 2489);
            final SortedSet<E> npe_invocation_var238 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var238, SortedSet.class, 75, 2453, 2463)) {
                return CallChecker.isCalled(npe_invocation_var238, SortedSet.class, 75, 2453, 2463).headSet(toElement);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1068.methodEnd();
        }
    }

    public SortedSet<E> tailSet(E fromElement) {
        MethodContext _bcornu_methode_context1069 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 78, 2496, 2594);
            CallChecker.varInit(fromElement, "fromElement", 78, 2496, 2594);
            CallChecker.varInit(this.collection, "collection", 78, 2496, 2594);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSortedSetDecorator.serialVersionUID", 78, 2496, 2594);
            final SortedSet<E> npe_invocation_var239 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var239, SortedSet.class, 79, 2556, 2566)) {
                return CallChecker.isCalled(npe_invocation_var239, SortedSet.class, 79, 2556, 2566).tailSet(fromElement);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1069.methodEnd();
        }
    }

    public E first() {
        final SortedSet<E> npe_invocation_var240 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var240, SortedSet.class, 83, 2635, 2645)) {
            return npe_invocation_var240.first();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E last() {
        final SortedSet<E> npe_invocation_var241 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var241, SortedSet.class, 87, 2700, 2710)) {
            return npe_invocation_var241.last();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context1072 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 90, 2731, 2820);
            CallChecker.varInit(this.collection, "collection", 90, 2731, 2820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSortedSetDecorator.serialVersionUID", 90, 2731, 2820);
            final SortedSet<E> npe_invocation_var242 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var242, SortedSet.class, 91, 2790, 2800)) {
                return CallChecker.isCalled(npe_invocation_var242, SortedSet.class, 91, 2790, 2800).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1072.methodEnd();
        }
    }
}

