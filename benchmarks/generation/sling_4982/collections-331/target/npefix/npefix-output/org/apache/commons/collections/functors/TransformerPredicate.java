package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.FunctorException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class TransformerPredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = -2407966402920578741L;

    private final Transformer<? super T, Boolean> iTransformer;

    public static <T> Predicate<T> getInstance(Transformer<? super T, Boolean> transformer) {
        MethodContext _bcornu_methode_context64 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(transformer, "transformer", 48, 1568, 2070);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformerPredicate.serialVersionUID", 48, 1568, 2070);
            if (transformer == null) {
                throw new IllegalArgumentException("The transformer to call must not be null");
            }
            return new TransformerPredicate<T>(transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    public TransformerPredicate(Transformer<? super T, Boolean> transformer) {
        super();
        MethodContext _bcornu_methode_context15 = new MethodContext(null);
        try {
            iTransformer = transformer;
            CallChecker.varAssign(this.iTransformer, "this.iTransformer", 63, 2357, 2383);
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context65 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 2396, 2988);
            CallChecker.varInit(object, "object", 73, 2396, 2988);
            CallChecker.varInit(this.iTransformer, "iTransformer", 73, 2396, 2988);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformerPredicate.serialVersionUID", 73, 2396, 2988);
            Boolean result = CallChecker.init(Boolean.class);
            if (CallChecker.beforeDeref(iTransformer, Transformer.class, 74, 2742, 2753)) {
                result = CallChecker.isCalled(iTransformer, Transformer.class, 74, 2742, 2753).transform(object);
                CallChecker.varAssign(result, "result", 74, 2742, 2753);
            }
            if (result == null) {
                throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
            }
            return result.booleanValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    public Transformer<? super T, Boolean> getTransformer() {
        MethodContext _bcornu_methode_context66 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(this, "this", 88, 2995, 3207);
            CallChecker.varInit(this.iTransformer, "iTransformer", 88, 2995, 3207);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformerPredicate.serialVersionUID", 88, 2995, 3207);
            return iTransformer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<? super T, Boolean>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }
}

