package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;

public class TransformerClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = -5194992589193388969L;

    private final Transformer<? super E, ?> iTransformer;

    public static <E> Closure<E> getInstance(Transformer<? super E, ?> transformer) {
        MethodContext _bcornu_methode_context791 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(transformer, "transformer", 49, 1524, 2027);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformerClosure.serialVersionUID", 49, 1524, 2027);
            if (transformer == null) {
                return NOPClosure.<E>getInstance();
            }
            return new TransformerClosure<E>(transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context791.methodEnd();
        }
    }

    public TransformerClosure(Transformer<? super E, ?> transformer) {
        super();
        MethodContext _bcornu_methode_context153 = new MethodContext(null);
        try {
            iTransformer = transformer;
            CallChecker.varAssign(this.iTransformer, "this.iTransformer", 64, 2313, 2339);
        } finally {
            _bcornu_methode_context153.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context792 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 72, 2352, 2554);
            CallChecker.varInit(input, "input", 72, 2352, 2554);
            CallChecker.varInit(this.iTransformer, "iTransformer", 72, 2352, 2554);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformerClosure.serialVersionUID", 72, 2352, 2554);
            if (CallChecker.beforeDeref(iTransformer, Transformer.class, 73, 2519, 2530)) {
                iTransformer.transform(input);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context792.methodEnd();
        }
    }

    public Transformer<? super E, ?> getTransformer() {
        MethodContext _bcornu_methode_context793 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(this, "this", 82, 2561, 2768);
            CallChecker.varInit(this.iTransformer, "iTransformer", 82, 2561, 2768);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TransformerClosure.serialVersionUID", 82, 2561, 2768);
            return iTransformer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<? super E, ?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context793.methodEnd();
        }
    }
}

