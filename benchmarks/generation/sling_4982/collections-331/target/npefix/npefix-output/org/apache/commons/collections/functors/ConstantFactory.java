package org.apache.commons.collections.functors;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Factory;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ConstantFactory<T> implements Serializable , Factory<T> {
    private static final long serialVersionUID = -3520677225766901240L;

    public static final Factory<Object> NULL_INSTANCE = new ConstantFactory<Object>(null);

    private final T iConstant;

    @SuppressWarnings(value = "unchecked")
    public static <T> Factory<T> getInstance(T constantToReturn) {
        MethodContext _bcornu_methode_context1201 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(constantToReturn, "constantToReturn", 53, 1727, 2191);
            CallChecker.varInit(NULL_INSTANCE, "org.apache.commons.collections.functors.ConstantFactory.NULL_INSTANCE", 53, 1727, 2191);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ConstantFactory.serialVersionUID", 53, 1727, 2191);
            if (constantToReturn == null) {
                return ((Factory<T>) (ConstantFactory.NULL_INSTANCE));
            }
            return new ConstantFactory<T>(constantToReturn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1201.methodEnd();
        }
    }

    public ConstantFactory(T constantToReturn) {
        super();
        MethodContext _bcornu_methode_context237 = new MethodContext(null);
        try {
            iConstant = constantToReturn;
            CallChecker.varAssign(this.iConstant, "this.iConstant", 68, 2463, 2491);
        } finally {
            _bcornu_methode_context237.methodEnd();
        }
    }

    public T create() {
        return iConstant;
    }

    public T getConstant() {
        return iConstant;
    }
}

