package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class TransformedPredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = -5596090919668315834L;

    private final Transformer<? super T, ? extends T> iTransformer;

    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> getInstance(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1661 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 52, 1689, 2464);
            CallChecker.varInit(transformer, "transformer", 52, 1689, 2464);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformedPredicate.serialVersionUID", 52, 1689, 2464);
            if (transformer == null) {
                throw new IllegalArgumentException("The transformer to call must not be null");
            }
            if (predicate == null) {
                throw new IllegalArgumentException("The predicate to call must not be null");
            }
            return new TransformedPredicate<T>(transformer, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1661.methodEnd();
        }
    }

    public TransformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context322 = new MethodContext(null);
        try {
            iTransformer = transformer;
            CallChecker.varAssign(this.iTransformer, "this.iTransformer", 70, 2816, 2842);
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 71, 2852, 2874);
        } finally {
            _bcornu_methode_context322.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context1662 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 81, 2887, 3288);
            CallChecker.varInit(object, "object", 81, 2887, 3288);
            CallChecker.varInit(this.iPredicate, "iPredicate", 81, 2887, 3288);
            CallChecker.varInit(this.iTransformer, "iTransformer", 81, 2887, 3288);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformedPredicate.serialVersionUID", 81, 2887, 3288);
            T result = CallChecker.init(null);
            if (CallChecker.beforeDeref(iTransformer, Transformer.class, 82, 3208, 3219)) {
                result = iTransformer.transform(object);
                CallChecker.varAssign(result, "result", 82, 3208, 3219);
            }
            if (CallChecker.beforeDeref(iPredicate, Predicate.class, 83, 3255, 3264)) {
                return CallChecker.isCalled(iPredicate, Predicate.class, 83, 3255, 3264).evaluate(result);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1662.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context1663 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 93, 3295, 3592);
            CallChecker.varInit(this.iPredicate, "iPredicate", 93, 3295, 3592);
            CallChecker.varInit(this.iTransformer, "iTransformer", 93, 3295, 3592);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformedPredicate.serialVersionUID", 93, 3295, 3592);
            return new Predicate[]{ iPredicate };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1663.methodEnd();
        }
    }

    public Transformer<? super T, ? extends T> getTransformer() {
        MethodContext _bcornu_methode_context1664 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(this, "this", 102, 3599, 3784);
            CallChecker.varInit(this.iPredicate, "iPredicate", 102, 3599, 3784);
            CallChecker.varInit(this.iTransformer, "iTransformer", 102, 3599, 3784);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformedPredicate.serialVersionUID", 102, 3599, 3784);
            return iTransformer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<? super T, ? extends T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1664.methodEnd();
        }
    }
}

