package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.collection.PredicatedCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.Bag;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Predicate;

public class PredicatedBag<E> extends PredicatedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = -2575833140344736876L;

    public static <T> Bag<T> decorate(Bag<T> bag, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context541 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(predicate, "predicate", 62, 1966, 2614);
            CallChecker.varInit(bag, "bag", 62, 1966, 2614);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedBag.serialVersionUID", 62, 1966, 2614);
            return new PredicatedBag<T>(bag, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context541.methodEnd();
        }
    }

    protected PredicatedBag(Bag<E> bag, Predicate<? super E> predicate) {
        super(bag, predicate);
        MethodContext _bcornu_methode_context98 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    @Override
    protected Bag<E> decorated() {
        MethodContext _bcornu_methode_context542 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(this, "this", 88, 3267, 3447);
            CallChecker.varInit(this.collection, "collection", 88, 3267, 3447);
            CallChecker.varInit(this.predicate, "predicate", 88, 3267, 3447);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedBag.serialVersionUID", 88, 3267, 3447);
            return ((Bag<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context542.methodEnd();
        }
    }

    public boolean add(E object, int count) {
        MethodContext _bcornu_methode_context543 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 93, 3458, 3655);
            CallChecker.varInit(count, "count", 93, 3458, 3655);
            CallChecker.varInit(object, "object", 93, 3458, 3655);
            CallChecker.varInit(this.collection, "collection", 93, 3458, 3655);
            CallChecker.varInit(this.predicate, "predicate", 93, 3458, 3655);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedBag.serialVersionUID", 93, 3458, 3655);
            validate(object);
            final Bag<E> npe_invocation_var134 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var134, Bag.class, 95, 3619, 3629)) {
                return CallChecker.isCalled(npe_invocation_var134, Bag.class, 95, 3619, 3629).add(object, count);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context543.methodEnd();
        }
    }

    public boolean remove(Object object, int count) {
        MethodContext _bcornu_methode_context544 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 98, 3662, 3766);
            CallChecker.varInit(count, "count", 98, 3662, 3766);
            CallChecker.varInit(object, "object", 98, 3662, 3766);
            CallChecker.varInit(this.collection, "collection", 98, 3662, 3766);
            CallChecker.varInit(this.predicate, "predicate", 98, 3662, 3766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedBag.serialVersionUID", 98, 3662, 3766);
            final Bag<E> npe_invocation_var135 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var135, Bag.class, 99, 3727, 3737)) {
                return CallChecker.isCalled(npe_invocation_var135, Bag.class, 99, 3727, 3737).remove(object, count);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context544.methodEnd();
        }
    }

    public Set<E> uniqueSet() {
        MethodContext _bcornu_methode_context545 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 102, 3773, 3845);
            CallChecker.varInit(this.collection, "collection", 102, 3773, 3845);
            CallChecker.varInit(this.predicate, "predicate", 102, 3773, 3845);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedBag.serialVersionUID", 102, 3773, 3845);
            final Bag<E> npe_invocation_var136 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var136, Bag.class, 103, 3816, 3826)) {
                return CallChecker.isCalled(npe_invocation_var136, Bag.class, 103, 3816, 3826).uniqueSet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context545.methodEnd();
        }
    }

    public int getCount(Object object) {
        MethodContext _bcornu_methode_context546 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 106, 3852, 3938);
            CallChecker.varInit(object, "object", 106, 3852, 3938);
            CallChecker.varInit(this.collection, "collection", 106, 3852, 3938);
            CallChecker.varInit(this.predicate, "predicate", 106, 3852, 3938);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedBag.serialVersionUID", 106, 3852, 3938);
            final Bag<E> npe_invocation_var137 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var137, Bag.class, 107, 3904, 3914)) {
                return CallChecker.isCalled(npe_invocation_var137, Bag.class, 107, 3904, 3914).getCount(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context546.methodEnd();
        }
    }
}

