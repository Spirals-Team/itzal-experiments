package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class EqualPredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = 5633766978029907089L;

    private final Object iValue;

    @Deprecated
    public static <T> Predicate<T> getInstance(T object) {
        MethodContext _bcornu_methode_context1988 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(object, "object", 51, 1569, 2044);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.EqualPredicate.serialVersionUID", 51, 1569, 2044);
            if (object == null) {
                return NullPredicate.nullPredicate();
            }
            return new EqualPredicate<T>(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1988.methodEnd();
        }
    }

    public static <T> Predicate<T> equalPredicate(T object) {
        MethodContext _bcornu_methode_context1989 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(object, "object", 65, 2051, 2449);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.EqualPredicate.serialVersionUID", 65, 2051, 2449);
            if (object == null) {
                return NullPredicate.nullPredicate();
            }
            return new EqualPredicate<T>(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1989.methodEnd();
        }
    }

    public EqualPredicate(Object object) {
        super();
        MethodContext _bcornu_methode_context385 = new MethodContext(null);
        try {
            iValue = object;
            CallChecker.varAssign(this.iValue, "this.iValue", 80, 2693, 2708);
        } finally {
            _bcornu_methode_context385.methodEnd();
        }
    }

    public boolean evaluate(Object object) {
        MethodContext _bcornu_methode_context1990 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 89, 2721, 3009);
            CallChecker.varInit(object, "object", 89, 2721, 3009);
            CallChecker.varInit(this.iValue, "iValue", 89, 2721, 3009);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.EqualPredicate.serialVersionUID", 89, 2721, 3009);
            if (CallChecker.beforeDeref(iValue, Object.class, 90, 2981, 2986)) {
                return CallChecker.isCalled(iValue, Object.class, 90, 2981, 2986).equals(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1990.methodEnd();
        }
    }

    public Object getValue() {
        MethodContext _bcornu_methode_context1991 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 99, 3016, 3180);
            CallChecker.varInit(this.iValue, "iValue", 99, 3016, 3180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.EqualPredicate.serialVersionUID", 99, 3016, 3180);
            return iValue;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1991.methodEnd();
        }
    }
}

