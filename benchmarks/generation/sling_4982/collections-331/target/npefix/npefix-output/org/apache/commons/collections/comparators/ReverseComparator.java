package org.apache.commons.collections.comparators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Comparator;
import org.apache.commons.collections.ComparatorUtils;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;

public class ReverseComparator<E> implements Serializable , Comparator<E> {
    private static final long serialVersionUID = 2858887242028539265L;

    private final Comparator<E> comparator;

    public ReverseComparator() {
        this(null);
        MethodContext _bcornu_methode_context286 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context286.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public ReverseComparator(Comparator<E> comparator) {
        MethodContext _bcornu_methode_context287 = new MethodContext(null);
        try {
            if (comparator == null) {
                this.comparator = ComparatorUtils.NATURAL_COMPARATOR;
                CallChecker.varAssign(this.comparator, "this.comparator", 67, 2533, 2619);
            }else {
                this.comparator = comparator;
                CallChecker.varAssign(this.comparator, "this.comparator", 67, 2533, 2619);
            }
        } finally {
            _bcornu_methode_context287.methodEnd();
        }
    }

    public int compare(E obj1, E obj2) {
        MethodContext _bcornu_methode_context1526 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 78, 2632, 3041);
            CallChecker.varInit(obj2, "obj2", 78, 2632, 3041);
            CallChecker.varInit(obj1, "obj1", 78, 2632, 3041);
            CallChecker.varInit(this.comparator, "comparator", 78, 2632, 3041);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ReverseComparator.serialVersionUID", 78, 2632, 3041);
            if (CallChecker.beforeDeref(comparator, Comparator.class, 79, 3005, 3014)) {
                return CallChecker.isCalled(comparator, Comparator.class, 79, 3005, 3014).compare(obj2, obj1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1526.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1527 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 91, 3048, 3449);
            CallChecker.varInit(this.comparator, "comparator", 91, 3048, 3449);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ReverseComparator.serialVersionUID", 91, 3048, 3449);
            return (CallChecker.isCalled("ReverseComparator", String.class, 92, 3389, 3407).hashCode()) ^ (CallChecker.isCalled(comparator, Comparator.class, 92, 3422, 3431).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1527.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context1528 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 112, 3456, 4524);
            CallChecker.varInit(object, "object", 112, 3456, 4524);
            CallChecker.varInit(this.comparator, "comparator", 112, 3456, 4524);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ReverseComparator.serialVersionUID", 112, 3456, 4524);
            if ((this) == object) {
                return true;
            }
            if (null == object) {
                return false;
            }
            object = CallChecker.beforeCalled(object, Object.class, 119, 4313, 4318);
            if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 119, 4313, 4318).getClass(), Class.class, 119, 4313, 4329)) {
                if (CallChecker.isCalled(object.getClass(), Class.class, 119, 4313, 4329).equals(this.getClass())) {
                    ReverseComparator<?> thatrc = CallChecker.varInit(((ReverseComparator<?>) (object)), "thatrc", 120, 4370, 4429);
                    if (CallChecker.beforeDeref(thatrc, ReverseComparator.class, 121, 4468, 4473)) {
                        if (CallChecker.beforeDeref(comparator, Comparator.class, 121, 4450, 4459)) {
                            thatrc = CallChecker.beforeCalled(thatrc, ReverseComparator.class, 121, 4468, 4473);
                            return CallChecker.isCalled(comparator, Comparator.class, 121, 4450, 4459).equals(CallChecker.isCalled(thatrc, ReverseComparator.class, 121, 4468, 4473).comparator);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1528.methodEnd();
        }
    }
}

