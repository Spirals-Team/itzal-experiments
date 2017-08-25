package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class IdentityPredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = -89901658494523293L;

    private final T iValue;

    public static <T> Predicate<T> getInstance(T object) {
        MethodContext _bcornu_methode_context2712 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(object, "object", 47, 1468, 1882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IdentityPredicate.serialVersionUID", 47, 1468, 1882);
            if (object == null) {
                return NullPredicate.<T>nullPredicate();
            }
            return new IdentityPredicate<T>(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2712.methodEnd();
        }
    }

    public IdentityPredicate(T object) {
        super();
        MethodContext _bcornu_methode_context511 = new MethodContext(null);
        try {
            iValue = object;
            CallChecker.varAssign(this.iValue, "this.iValue", 62, 2123, 2138);
        } finally {
            _bcornu_methode_context511.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context2713 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 72, 2151, 2464);
            CallChecker.varInit(object, "object", 72, 2151, 2464);
            CallChecker.varInit(this.iValue, "iValue", 72, 2151, 2464);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IdentityPredicate.serialVersionUID", 72, 2151, 2464);
            return (iValue) == object;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2713.methodEnd();
        }
    }

    public T getValue() {
        return iValue;
    }
}

