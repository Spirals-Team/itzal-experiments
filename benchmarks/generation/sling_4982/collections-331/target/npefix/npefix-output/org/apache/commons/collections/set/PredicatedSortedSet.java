package org.apache.commons.collections.set;

import java.util.SortedSet;
import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class PredicatedSortedSet<E> extends PredicatedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -9110948148132275052L;

    public static <T> SortedSet<T> decorate(SortedSet<T> set, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1713 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(predicate, "predicate", 60, 1906, 2587);
            CallChecker.varInit(set, "set", 60, 1906, 2587);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSortedSet.serialVersionUID", 60, 1906, 2587);
            return new PredicatedSortedSet<T>(set, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1713.methodEnd();
        }
    }

    protected PredicatedSortedSet(SortedSet<E> set, Predicate<? super E> predicate) {
        super(set, predicate);
        MethodContext _bcornu_methode_context330 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context330.methodEnd();
        }
    }

    @Override
    protected SortedSet<E> decorated() {
        MethodContext _bcornu_methode_context1714 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 86, 3252, 3464);
            CallChecker.varInit(this.collection, "collection", 86, 3252, 3464);
            CallChecker.varInit(this.predicate, "predicate", 86, 3252, 3464);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSortedSet.serialVersionUID", 86, 3252, 3464);
            return ((SortedSet<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1714.methodEnd();
        }
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context1715 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 91, 3471, 3638);
            CallChecker.varInit(this.collection, "collection", 91, 3471, 3638);
            CallChecker.varInit(this.predicate, "predicate", 91, 3471, 3638);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSortedSet.serialVersionUID", 91, 3471, 3638);
            final SortedSet<E> npe_invocation_var345 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var345, SortedSet.class, 92, 3608, 3618)) {
                return CallChecker.isCalled(npe_invocation_var345, SortedSet.class, 92, 3608, 3618).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1715.methodEnd();
        }
    }

    public E first() {
        final SortedSet<E> npe_invocation_var346 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var346, SortedSet.class, 96, 3679, 3689)) {
            return npe_invocation_var346.first();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E last() {
        final SortedSet<E> npe_invocation_var347 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var347, SortedSet.class, 100, 3744, 3754)) {
            return npe_invocation_var347.last();
        }else
            throw new AbnormalExecutionError();
        
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        MethodContext _bcornu_methode_context1718 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 103, 3775, 3966);
            CallChecker.varInit(toElement, "toElement", 103, 3775, 3966);
            CallChecker.varInit(fromElement, "fromElement", 103, 3775, 3966);
            CallChecker.varInit(this.collection, "collection", 103, 3775, 3966);
            CallChecker.varInit(this.predicate, "predicate", 103, 3775, 3966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSortedSet.serialVersionUID", 103, 3775, 3966);
            final SortedSet<E> npe_invocation_var348 = decorated();
            SortedSet<E> sub = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var348, SortedSet.class, 104, 3859, 3869)) {
                sub = CallChecker.isCalled(npe_invocation_var348, SortedSet.class, 104, 3859, 3869).subSet(fromElement, toElement);
                CallChecker.varAssign(sub, "sub", 104, 3859, 3869);
            }
            return new PredicatedSortedSet<E>(sub, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1718.methodEnd();
        }
    }

    public SortedSet<E> headSet(E toElement) {
        MethodContext _bcornu_methode_context1719 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 108, 3973, 4138);
            CallChecker.varInit(toElement, "toElement", 108, 3973, 4138);
            CallChecker.varInit(this.collection, "collection", 108, 3973, 4138);
            CallChecker.varInit(this.predicate, "predicate", 108, 3973, 4138);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSortedSet.serialVersionUID", 108, 3973, 4138);
            final SortedSet<E> npe_invocation_var349 = decorated();
            SortedSet<E> sub = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var349, SortedSet.class, 109, 4043, 4053)) {
                sub = CallChecker.isCalled(npe_invocation_var349, SortedSet.class, 109, 4043, 4053).headSet(toElement);
                CallChecker.varAssign(sub, "sub", 109, 4043, 4053);
            }
            return new PredicatedSortedSet<E>(sub, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1719.methodEnd();
        }
    }

    public SortedSet<E> tailSet(E fromElement) {
        MethodContext _bcornu_methode_context1720 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 113, 4145, 4314);
            CallChecker.varInit(fromElement, "fromElement", 113, 4145, 4314);
            CallChecker.varInit(this.collection, "collection", 113, 4145, 4314);
            CallChecker.varInit(this.predicate, "predicate", 113, 4145, 4314);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.PredicatedSortedSet.serialVersionUID", 113, 4145, 4314);
            final SortedSet<E> npe_invocation_var350 = decorated();
            SortedSet<E> sub = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var350, SortedSet.class, 114, 4217, 4227)) {
                sub = CallChecker.isCalled(npe_invocation_var350, SortedSet.class, 114, 4217, 4227).tailSet(fromElement);
                CallChecker.varAssign(sub, "sub", 114, 4217, 4227);
            }
            return new PredicatedSortedSet<E>(sub, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1720.methodEnd();
        }
    }
}

