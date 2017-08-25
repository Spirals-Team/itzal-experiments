package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Factory;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class FactoryTransformer<I, O> implements Serializable , Transformer<I, O> {
    private static final long serialVersionUID = -6817674502475353160L;

    private final Factory<? extends O> iFactory;

    public static <I, O> Transformer<I, O> getInstance(Factory<? extends O> factory) {
        MethodContext _bcornu_methode_context339 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(factory, "factory", 47, 1496, 1994);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.FactoryTransformer.serialVersionUID", 47, 1496, 1994);
            if (factory == null) {
                throw new IllegalArgumentException("Factory must not be null");
            }
            return new FactoryTransformer<I, O>(factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context339.methodEnd();
        }
    }

    public FactoryTransformer(Factory<? extends O> factory) {
        super();
        MethodContext _bcornu_methode_context51 = new MethodContext(null);
        try {
            iFactory = factory;
            CallChecker.varAssign(this.iFactory, "this.iFactory", 62, 2263, 2281);
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    public O transform(I input) {
        if (CallChecker.beforeDeref(iFactory, Factory.class, 73, 2568, 2575)) {
            return iFactory.create();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Factory<? extends O> getFactory() {
        MethodContext _bcornu_methode_context341 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(this, "this", 82, 2598, 2784);
            CallChecker.varInit(this.iFactory, "iFactory", 82, 2598, 2784);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.FactoryTransformer.serialVersionUID", 82, 2598, 2784);
            return iFactory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<? extends O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context341.methodEnd();
        }
    }
}

