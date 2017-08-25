package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class NOPTransformer<T> implements Serializable , Transformer<T, T> {
    private static final long serialVersionUID = 2133891748318574490L;

    public static final Transformer<Object, Object> INSTANCE = new NOPTransformer<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <T> Transformer<T, T> getInstance() {
        MethodContext _bcornu_methode_context806 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NOPTransformer.INSTANCE", 46, 1467, 1751);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NOPTransformer.serialVersionUID", 46, 1467, 1751);
            return ((Transformer<T, T>) (NOPTransformer.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context806.methodEnd();
        }
    }

    private NOPTransformer() {
        super();
        MethodContext _bcornu_methode_context159 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context159.methodEnd();
        }
    }

    public T transform(T input) {
        return input;
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context808 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 67, 2098, 2158);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NOPTransformer.INSTANCE", 67, 2098, 2158);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NOPTransformer.serialVersionUID", 67, 2098, 2158);
            return NOPTransformer.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context808.methodEnd();
        }
    }
}

