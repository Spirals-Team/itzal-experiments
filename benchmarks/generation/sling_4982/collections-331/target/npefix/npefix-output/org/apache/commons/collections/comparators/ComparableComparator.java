package org.apache.commons.collections.comparators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;

public class ComparableComparator<E extends Comparable<? super E>> implements Serializable , Comparator<E> {
    private static final long serialVersionUID = -291439688585137865L;

    public static final ComparableComparator<?> INSTANCE = new ComparableComparator();

    @SuppressWarnings(value = "unchecked")
    public static <E extends Comparable<? super E>> ComparableComparator<E> getInstance() {
        MethodContext _bcornu_methode_context697 = new MethodContext(ComparableComparator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.comparators.ComparableComparator.INSTANCE", 62, 2119, 2758);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparableComparator.serialVersionUID", 62, 2119, 2758);
            return ((ComparableComparator<E>) (ComparableComparator.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ComparableComparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context697.methodEnd();
        }
    }

    public ComparableComparator() {
        super();
        MethodContext _bcornu_methode_context123 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context123.methodEnd();
        }
    }

    public int compare(E obj1, E obj2) {
        MethodContext _bcornu_methode_context698 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 90, 3049, 3869);
            CallChecker.varInit(obj2, "obj2", 90, 3049, 3869);
            CallChecker.varInit(obj1, "obj1", 90, 3049, 3869);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.comparators.ComparableComparator.INSTANCE", 90, 3049, 3869);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparableComparator.serialVersionUID", 90, 3049, 3869);
            if (CallChecker.beforeDeref(obj1, null, 91, 3843, 3846)) {
                return obj1.compareTo(obj2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context698.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context699 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 103, 3876, 4267);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.comparators.ComparableComparator.INSTANCE", 103, 3876, 4267);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparableComparator.serialVersionUID", 103, 3876, 4267);
            if (CallChecker.beforeDeref("ComparableComparator", String.class, 104, 4228, 4249)) {
                return CallChecker.isCalled("ComparableComparator", String.class, 104, 4228, 4249).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context699.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context700 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 123, 4274, 5066);
            CallChecker.varInit(object, "object", 123, 4274, 5066);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.comparators.ComparableComparator.INSTANCE", 123, 4274, 5066);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparableComparator.serialVersionUID", 123, 4274, 5066);
            if (CallChecker.beforeDeref(object, Object.class, 125, 5017, 5022)) {
                object = CallChecker.beforeCalled(object, Object.class, 125, 5017, 5022);
                return ((this) == object) || ((null != object) && (CallChecker.isCalled(CallChecker.isCalled(object, Object.class, 125, 5017, 5022).getClass(), Class.class, 125, 5017, 5033).equals(this.getClass())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context700.methodEnd();
        }
    }
}

