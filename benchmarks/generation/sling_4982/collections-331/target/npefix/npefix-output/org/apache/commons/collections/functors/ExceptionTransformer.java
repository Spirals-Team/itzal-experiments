package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.FunctorException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class ExceptionTransformer<I, O> implements Serializable , Transformer<I, O> {
    private static final long serialVersionUID = 7179106032121985545L;

    public static final Transformer<Object, Object> INSTANCE = new ExceptionTransformer<Object, Object>();

    @SuppressWarnings(value = "unchecked")
    public static <I, O> Transformer<I, O> getInstance() {
        MethodContext _bcornu_methode_context1752 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionTransformer.INSTANCE", 47, 1566, 1853);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionTransformer.serialVersionUID", 47, 1566, 1853);
            return ((Transformer<I, O>) (ExceptionTransformer.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1752.methodEnd();
        }
    }

    private ExceptionTransformer() {
        super();
        MethodContext _bcornu_methode_context340 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context340.methodEnd();
        }
    }

    public O transform(I input) {
        throw new FunctorException("ExceptionTransformer invoked");
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1754 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 69, 2264, 2324);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionTransformer.INSTANCE", 69, 2264, 2324);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionTransformer.serialVersionUID", 69, 2264, 2324);
            return ExceptionTransformer.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1754.methodEnd();
        }
    }
}

