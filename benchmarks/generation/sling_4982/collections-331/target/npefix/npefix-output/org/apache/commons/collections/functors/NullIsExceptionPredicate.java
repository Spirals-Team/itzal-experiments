package org.apache.commons.collections.functors;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.FunctorException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Predicate;
import java.io.Serializable;

public final class NullIsExceptionPredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = 3243449850504576071L;

    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> getInstance(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1076 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 47, 1545, 2040);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsExceptionPredicate.serialVersionUID", 47, 1545, 2040);
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            return new NullIsExceptionPredicate<T>(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1076.methodEnd();
        }
    }

    public NullIsExceptionPredicate(Predicate<? super T> predicate) {
        super();
        MethodContext _bcornu_methode_context211 = new MethodContext(null);
        try {
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 62, 2332, 2354);
        } finally {
            _bcornu_methode_context211.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context1077 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 2367, 2850);
            CallChecker.varInit(object, "object", 73, 2367, 2850);
            CallChecker.varInit(this.iPredicate, "iPredicate", 73, 2367, 2850);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsExceptionPredicate.serialVersionUID", 73, 2367, 2850);
            if (object == null) {
                throw new FunctorException("Input Object must not be null");
            }
            if (CallChecker.beforeDeref(iPredicate, Predicate.class, 77, 2817, 2826)) {
                return CallChecker.isCalled(iPredicate, Predicate.class, 77, 2817, 2826).evaluate(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1077.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context1078 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 87, 2857, 3157);
            CallChecker.varInit(this.iPredicate, "iPredicate", 87, 2857, 3157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsExceptionPredicate.serialVersionUID", 87, 2857, 3157);
            return new Predicate[]{ iPredicate };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1078.methodEnd();
        }
    }
}

