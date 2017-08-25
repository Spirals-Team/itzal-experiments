package org.apache.commons.collections.collection;

import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class PredicatedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = -5259182142076705162L;

    protected final Predicate<? super E> predicate;

    public static <T> Collection<T> decorate(Collection<T> coll, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context67 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(predicate, "predicate", 64, 2055, 2830);
            CallChecker.varInit(coll, "coll", 64, 2055, 2830);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.PredicatedCollection.serialVersionUID", 64, 2055, 2830);
            return new PredicatedCollection<T>(coll, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    protected PredicatedCollection(Collection<E> coll, Predicate<? super E> predicate) {
        super(coll);
        MethodContext _bcornu_methode_context16 = new MethodContext(null);
        try {
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 85, 3635, 3661);
            if (CallChecker.beforeDeref(coll, null, 86, 3685, 3688)) {
                for (E item : coll) {
                    validate(item);
                }
            }
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    protected void validate(E object) {
        MethodContext _bcornu_methode_context68 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 100, 3742, 4319);
            CallChecker.varInit(object, "object", 100, 3742, 4319);
            CallChecker.varInit(this.collection, "collection", 100, 3742, 4319);
            CallChecker.varInit(this.predicate, "predicate", 100, 3742, 4319);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.PredicatedCollection.serialVersionUID", 100, 3742, 4319);
            if (CallChecker.beforeDeref(predicate, Predicate.class, 101, 4136, 4144)) {
                if ((CallChecker.isCalled(predicate, Predicate.class, 101, 4136, 4144).evaluate(object)) == false) {
                    throw new IllegalArgumentException((((("Cannot add Object '" + object) + "' - Predicate '") + (predicate)) + "' rejected it"));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context69 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 116, 4326, 4809);
            CallChecker.varInit(object, "object", 116, 4326, 4809);
            CallChecker.varInit(this.collection, "collection", 116, 4326, 4809);
            CallChecker.varInit(this.predicate, "predicate", 116, 4326, 4809);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.PredicatedCollection.serialVersionUID", 116, 4326, 4809);
            validate(object);
            final Collection<E> npe_invocation_var30 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var30, Collection.class, 118, 4780, 4790)) {
                return CallChecker.isCalled(npe_invocation_var30, Collection.class, 118, 4780, 4790).add(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context70 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 131, 4816, 5363);
            CallChecker.varInit(coll, "coll", 131, 4816, 5363);
            CallChecker.varInit(this.collection, "collection", 131, 4816, 5363);
            CallChecker.varInit(this.predicate, "predicate", 131, 4816, 5363);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.PredicatedCollection.serialVersionUID", 131, 4816, 5363);
            if (CallChecker.beforeDeref(coll, boolean.class, 132, 5272, 5275)) {
                for (E item : coll) {
                    validate(item);
                }
            }
            final Collection<E> npe_invocation_var31 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var31, Collection.class, 135, 5333, 5343)) {
                return CallChecker.isCalled(npe_invocation_var31, Collection.class, 135, 5333, 5343).addAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }
}

