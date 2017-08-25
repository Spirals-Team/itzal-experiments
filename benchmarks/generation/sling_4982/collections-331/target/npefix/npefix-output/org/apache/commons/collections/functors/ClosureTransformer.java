package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ClosureTransformer<T> implements Serializable , Transformer<T, T> {
    private static final long serialVersionUID = 478466901448617286L;

    private final Closure<? super T> iClosure;

    public static <T> Transformer<T, T> getInstance(Closure<? super T> closure) {
        MethodContext _bcornu_methode_context1823 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(closure, "closure", 48, 1519, 2009);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ClosureTransformer.serialVersionUID", 48, 1519, 2009);
            if (closure == null) {
                throw new IllegalArgumentException("Closure must not be null");
            }
            return new ClosureTransformer<T>(closure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1823.methodEnd();
        }
    }

    public ClosureTransformer(Closure<? super T> closure) {
        super();
        MethodContext _bcornu_methode_context358 = new MethodContext(null);
        try {
            iClosure = closure;
            CallChecker.varAssign(this.iClosure, "this.iClosure", 63, 2276, 2294);
        } finally {
            _bcornu_methode_context358.methodEnd();
        }
    }

    public T transform(T input) {
        if (CallChecker.beforeDeref(iClosure, Closure.class, 73, 2520, 2527)) {
            CallChecker.isCalled(iClosure, Closure.class, 73, 2520, 2527).execute(input);
        }
        return input;
    }

    public Closure<? super T> getClosure() {
        MethodContext _bcornu_methode_context1825 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(this, "this", 83, 2578, 2762);
            CallChecker.varInit(this.iClosure, "iClosure", 83, 2578, 2762);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ClosureTransformer.serialVersionUID", 83, 2578, 2762);
            return iClosure;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<? super T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1825.methodEnd();
        }
    }
}

