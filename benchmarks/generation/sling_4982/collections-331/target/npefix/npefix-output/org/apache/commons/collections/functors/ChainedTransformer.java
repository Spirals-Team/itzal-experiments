package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class ChainedTransformer<T> implements Serializable , Transformer<T, T> {
    private static final long serialVersionUID = 3514945074733160196L;

    private final Transformer<? super T, ? extends T>[] iTransformers;

    public static <T> Transformer<T, T> getInstance(Transformer<? super T, ? extends T>[] transformers) {
        MethodContext _bcornu_methode_context979 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformers, "transformers", 51, 1649, 2395);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedTransformer.serialVersionUID", 51, 1649, 2395);
            FunctorUtils.validate(transformers);
            if (CallChecker.beforeDeref(transformers, Transformer[].class, 53, 2189, 2200)) {
                transformers = CallChecker.beforeCalled(transformers, Transformer[].class, 53, 2189, 2200);
                if ((CallChecker.isCalled(transformers, Transformer[].class, 53, 2189, 2200).length) == 0) {
                    return NOPTransformer.<T>getInstance();
                }
            }else
                throw new AbnormalExecutionError();
            
            transformers = FunctorUtils.copy(transformers);
            CallChecker.varAssign(transformers, "transformers", 56, 2287, 2333);
            return new ChainedTransformer<T>(transformers);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context979.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Transformer<T, T> getInstance(Collection<? extends Transformer<T, T>> transformers) {
        MethodContext _bcornu_methode_context980 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformers, "transformers", 71, 2406, 3540);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedTransformer.serialVersionUID", 71, 2406, 3540);
            if (transformers == null) {
                throw new IllegalArgumentException("Transformer collection must not be null");
            }
            if ((transformers.size()) == 0) {
                return NOPTransformer.<T>getInstance();
            }
            Transformer<T, T>[] cmds = CallChecker.varInit(transformers.toArray(new Transformer[transformers.size()]), "cmds", 79, 3364, 3449);
            FunctorUtils.validate(cmds);
            return new ChainedTransformer<T>(cmds);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context980.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Transformer<T, T> getInstance(Transformer<? super T, ? extends T> transformer1, Transformer<? super T, ? extends T> transformer2) {
        MethodContext _bcornu_methode_context981 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformer2, "transformer2", 93, 3547, 4369);
            CallChecker.varInit(transformer1, "transformer1", 93, 3547, 4369);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedTransformer.serialVersionUID", 93, 3547, 4369);
            if ((transformer1 == null) || (transformer2 == null)) {
                throw new IllegalArgumentException("Transformers must not be null");
            }
            Transformer<? super T, ? extends T>[] transformers = CallChecker.varInit(new Transformer[]{ transformer1 , transformer2 }, "transformers", 97, 4206, 4307);
            return new ChainedTransformer<T>(transformers);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context981.methodEnd();
        }
    }

    public ChainedTransformer(Transformer<? super T, ? extends T>[] transformers) {
        super();
        MethodContext _bcornu_methode_context190 = new MethodContext(null);
        try {
            iTransformers = transformers;
            CallChecker.varAssign(this.iTransformers, "this.iTransformers", 109, 4683, 4711);
        } finally {
            _bcornu_methode_context190.methodEnd();
        }
    }

    public T transform(T object) {
        for (int i = 0; i < (CallChecker.isCalled(iTransformers, Transformer[].class, 119, 4985, 4997).length); i++) {
            if (CallChecker.beforeDeref(iTransformers, Transformer[].class, 120, 5035, 5047)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(iTransformers, Transformer[].class, 120, 5035, 5047)[i], Transformer.class, 120, 5035, 5050)) {
                    object = CallChecker.isCalled(iTransformers, Transformer[].class, 120, 5035, 5047)[i].transform(object);
                    CallChecker.varAssign(object, "object", 120, 5026, 5069);
                }
            }
        }
        return object;
    }

    public Transformer<? super T, ? extends T>[] getTransformers() {
        MethodContext _bcornu_methode_context983 = new MethodContext(Transformer[].class);
        try {
            CallChecker.varInit(this, "this", 130, 5115, 5355);
            CallChecker.varInit(this.iTransformers, "iTransformers", 130, 5115, 5355);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedTransformer.serialVersionUID", 130, 5115, 5355);
            return iTransformers;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context983.methodEnd();
        }
    }
}

