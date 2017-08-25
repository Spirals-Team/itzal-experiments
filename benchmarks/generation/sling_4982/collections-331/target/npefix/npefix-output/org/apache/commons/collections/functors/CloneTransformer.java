package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Factory;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class CloneTransformer<T> implements Serializable , Transformer<T, T> {
    private static final long serialVersionUID = -8188742709499652567L;

    public static final Transformer<Object, Object> INSTANCE = new CloneTransformer<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <T> Transformer<T, T> getInstance() {
        MethodContext _bcornu_methode_context342 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.CloneTransformer.INSTANCE", 48, 1589, 1874);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.CloneTransformer.serialVersionUID", 48, 1589, 1874);
            return ((Transformer<T, T>) (CloneTransformer.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context342.methodEnd();
        }
    }

    private CloneTransformer() {
        super();
        MethodContext _bcornu_methode_context52 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    public T transform(T input) {
        if (input == null) {
            return null;
        }
        final Factory<T> npe_invocation_var112 = PrototypeFactory.getInstance(input);
        if (CallChecker.beforeDeref(npe_invocation_var112, Factory.class, 69, 2248, 2282)) {
            return npe_invocation_var112.create();
        }else
            throw new AbnormalExecutionError();
        
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context344 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 72, 2305, 2365);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.CloneTransformer.INSTANCE", 72, 2305, 2365);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.CloneTransformer.serialVersionUID", 72, 2305, 2365);
            return CloneTransformer.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context344.methodEnd();
        }
    }
}

