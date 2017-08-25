package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class InstanceofPredicate implements Serializable , Predicate<Object> {
    private static final long serialVersionUID = -6682656911025165584L;

    private final Class<?> iType;

    public static Predicate<Object> getInstance(Class<?> type) {
        MethodContext _bcornu_methode_context1981 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(type, "type", 47, 1475, 1942);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InstanceofPredicate.serialVersionUID", 47, 1475, 1942);
            if (type == null) {
                throw new IllegalArgumentException("The type to check instanceof must not be null");
            }
            return new InstanceofPredicate(type);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1981.methodEnd();
        }
    }

    public InstanceofPredicate(Class<?> type) {
        super();
        MethodContext _bcornu_methode_context383 = new MethodContext(null);
        try {
            iType = type;
            CallChecker.varAssign(this.iType, "this.iType", 62, 2185, 2197);
        } finally {
            _bcornu_methode_context383.methodEnd();
        }
    }

    public boolean evaluate(Object object) {
        MethodContext _bcornu_methode_context1982 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 71, 2210, 2497);
            CallChecker.varInit(object, "object", 71, 2210, 2497);
            CallChecker.varInit(this.iType, "iType", 71, 2210, 2497);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InstanceofPredicate.serialVersionUID", 71, 2210, 2497);
            if (CallChecker.beforeDeref(iType, Class.class, 72, 2466, 2470)) {
                return CallChecker.isCalled(iType, Class.class, 72, 2466, 2470).isInstance(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1982.methodEnd();
        }
    }

    public Class<?> getType() {
        MethodContext _bcornu_methode_context1983 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(this, "this", 81, 2504, 2679);
            CallChecker.varInit(this.iType, "iType", 81, 2504, 2679);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InstanceofPredicate.serialVersionUID", 81, 2504, 2679);
            return iType;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1983.methodEnd();
        }
    }
}

