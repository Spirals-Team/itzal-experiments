package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class PredicateTransformer<T> implements Serializable , Transformer<T, Boolean> {
    private static final long serialVersionUID = 5278818408044349346L;

    private final Predicate<? super T> iPredicate;

    public static <T> Transformer<T, Boolean> getInstance(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context2284 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(predicate, "predicate", 48, 1537, 2053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.PredicateTransformer.serialVersionUID", 48, 1537, 2053);
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            return new PredicateTransformer<T>(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, Boolean>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2284.methodEnd();
        }
    }

    public PredicateTransformer(Predicate<? super T> predicate) {
        super();
        MethodContext _bcornu_methode_context424 = new MethodContext(null);
        try {
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 63, 2330, 2352);
        } finally {
            _bcornu_methode_context424.methodEnd();
        }
    }

    public Boolean transform(T input) {
        MethodContext _bcornu_methode_context2285 = new MethodContext(Boolean.class);
        try {
            CallChecker.varInit(this, "this", 72, 2365, 2640);
            CallChecker.varInit(input, "input", 72, 2365, 2640);
            CallChecker.varInit(this.iPredicate, "iPredicate", 72, 2365, 2640);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.PredicateTransformer.serialVersionUID", 72, 2365, 2640);
            if (CallChecker.beforeDeref(iPredicate, Predicate.class, 73, 2607, 2616)) {
                return Boolean.valueOf(CallChecker.isCalled(iPredicate, Predicate.class, 73, 2607, 2616).evaluate(input));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2285.methodEnd();
        }
    }

    public Predicate<? super T> getPredicate() {
        MethodContext _bcornu_methode_context2286 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(this, "this", 82, 2647, 2841);
            CallChecker.varInit(this.iPredicate, "iPredicate", 82, 2647, 2841);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.PredicateTransformer.serialVersionUID", 82, 2647, 2841);
            return iPredicate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<? super T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2286.methodEnd();
        }
    }
}

