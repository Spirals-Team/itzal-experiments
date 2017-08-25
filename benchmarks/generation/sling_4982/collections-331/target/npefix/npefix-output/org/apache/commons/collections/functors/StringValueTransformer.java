package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class StringValueTransformer<T> implements Serializable , Transformer<T, String> {
    private static final long serialVersionUID = 7511110693171758606L;

    public static final Transformer<Object, String> INSTANCE = new StringValueTransformer<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <T> Transformer<T, String> getInstance() {
        MethodContext _bcornu_methode_context596 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.StringValueTransformer.INSTANCE", 47, 1562, 1856);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.StringValueTransformer.serialVersionUID", 47, 1562, 1856);
            return ((Transformer<T, String>) (StringValueTransformer.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context596.methodEnd();
        }
    }

    private StringValueTransformer() {
        super();
        MethodContext _bcornu_methode_context110 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context110.methodEnd();
        }
    }

    public String transform(T input) {
        MethodContext _bcornu_methode_context597 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 64, 1973, 2240);
            CallChecker.varInit(input, "input", 64, 1973, 2240);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.StringValueTransformer.INSTANCE", 64, 1973, 2240);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.StringValueTransformer.serialVersionUID", 64, 1973, 2240);
            return String.valueOf(input);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context597.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context598 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 68, 2247, 2307);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.StringValueTransformer.INSTANCE", 68, 2247, 2307);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.StringValueTransformer.serialVersionUID", 68, 2247, 2307);
            return StringValueTransformer.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context598.methodEnd();
        }
    }
}

