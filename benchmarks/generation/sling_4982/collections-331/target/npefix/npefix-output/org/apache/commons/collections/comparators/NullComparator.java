package org.apache.commons.collections.comparators;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Comparator;
import org.apache.commons.collections.ComparatorUtils;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class NullComparator<E> implements Serializable , Comparator<E> {
    private static final long serialVersionUID = -5820772575483504339L;

    private final Comparator<E> nonNullComparator;

    private final boolean nullsAreHigh;

    @SuppressWarnings(value = "unchecked")
    public NullComparator() {
        this(ComparatorUtils.NATURAL_COMPARATOR, true);
        MethodContext _bcornu_methode_context299 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context299.methodEnd();
        }
    }

    public NullComparator(Comparator<E> nonNullComparator) {
        this(nonNullComparator, true);
        MethodContext _bcornu_methode_context300 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context300.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public NullComparator(boolean nullsAreHigh) {
        this(ComparatorUtils.NATURAL_COMPARATOR, nullsAreHigh);
        MethodContext _bcornu_methode_context301 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context301.methodEnd();
        }
    }

    public NullComparator(Comparator<E> nonNullComparator, boolean nullsAreHigh) {
        MethodContext _bcornu_methode_context302 = new MethodContext(null);
        try {
            this.nonNullComparator = nonNullComparator;
            CallChecker.varAssign(this.nonNullComparator, "this.nonNullComparator", 115, 4543, 4585);
            this.nullsAreHigh = nullsAreHigh;
            CallChecker.varAssign(this.nullsAreHigh, "this.nullsAreHigh", 116, 4595, 4627);
            if (nonNullComparator == null) {
                throw new NullPointerException("null nonNullComparator");
            }
        } finally {
            _bcornu_methode_context302.methodEnd();
        }
    }

    public int compare(E o1, E o2) {
        MethodContext _bcornu_methode_context1571 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 140, 4770, 6038);
            CallChecker.varInit(o2, "o2", 140, 4770, 6038);
            CallChecker.varInit(o1, "o1", 140, 4770, 6038);
            CallChecker.varInit(this.nullsAreHigh, "nullsAreHigh", 140, 4770, 6038);
            CallChecker.varInit(this.nonNullComparator, "nonNullComparator", 140, 4770, 6038);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.NullComparator.serialVersionUID", 140, 4770, 6038);
            if (o1 == o2) {
                return 0;
            }
            if (o1 == null) {
                if (this.nullsAreHigh) {
                    return 1;
                }else {
                    return -1;
                }
            }
            if (o2 == null) {
                if (this.nullsAreHigh) {
                    return -1;
                }else {
                    return 1;
                }
            }
            if (CallChecker.beforeDeref(this.nonNullComparator, Comparator.class, 144, 5994, 6015)) {
                return CallChecker.isCalled(this.nonNullComparator, Comparator.class, 144, 5994, 6015).compare(o1, o2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1571.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1572 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 155, 6045, 6416);
            CallChecker.varInit(this.nullsAreHigh, "nullsAreHigh", 155, 6045, 6416);
            CallChecker.varInit(this.nonNullComparator, "nonNullComparator", 155, 6045, 6416);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.NullComparator.serialVersionUID", 155, 6045, 6416);
            return (nullsAreHigh ? -1 : 1) * (CallChecker.isCalled(nonNullComparator, Comparator.class, 156, 6382, 6398).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1572.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1573 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 171, 6423, 7302);
            CallChecker.varInit(obj, "obj", 171, 6423, 7302);
            CallChecker.varInit(this.nullsAreHigh, "nullsAreHigh", 171, 6423, 7302);
            CallChecker.varInit(this.nonNullComparator, "nonNullComparator", 171, 6423, 7302);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.NullComparator.serialVersionUID", 171, 6423, 7302);
            if (obj == null) {
                return false;
            }
            if (obj == (this)) {
                return true;
            }
            obj = CallChecker.beforeCalled(obj, Object.class, 174, 7043, 7045);
            if (CallChecker.beforeDeref(CallChecker.isCalled(obj, Object.class, 174, 7043, 7045).getClass(), Class.class, 174, 7043, 7056)) {
                if (!(CallChecker.isCalled(obj.getClass(), Class.class, 174, 7043, 7056).equals(this.getClass()))) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            NullComparator<?> other = CallChecker.varInit(((NullComparator<?>) (obj)), "other", 176, 7110, 7159);
            if (CallChecker.beforeDeref(other, NullComparator.class, 179, 7270, 7274)) {
                other = CallChecker.beforeCalled(other, NullComparator.class, 178, 7200, 7204);
                other = CallChecker.beforeCalled(other, NullComparator.class, 179, 7270, 7274);
                return ((this.nullsAreHigh) == (CallChecker.isCalled(other, NullComparator.class, 178, 7200, 7204).nullsAreHigh)) && (CallChecker.isCalled(this.nonNullComparator, Comparator.class, 179, 7240, 7261).equals(CallChecker.isCalled(other, NullComparator.class, 179, 7270, 7274).nonNullComparator));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1573.methodEnd();
        }
    }
}

