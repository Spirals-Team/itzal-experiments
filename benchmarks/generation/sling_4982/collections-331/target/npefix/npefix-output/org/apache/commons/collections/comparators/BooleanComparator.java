package org.apache.commons.collections.comparators;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class BooleanComparator implements Serializable , Comparator<Boolean> {
    private static final long serialVersionUID = 1830042991606340609L;

    private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);

    private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);

    private boolean trueFirst = false;

    public static BooleanComparator getTrueFirstComparator() {
        MethodContext _bcornu_methode_context819 = new MethodContext(BooleanComparator.class);
        try {
            CallChecker.varInit(FALSE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.FALSE_FIRST", 62, 1886, 2541);
            CallChecker.varInit(TRUE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.TRUE_FIRST", 62, 1886, 2541);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.BooleanComparator.serialVersionUID", 62, 1886, 2541);
            return BooleanComparator.TRUE_FIRST;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BooleanComparator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context819.methodEnd();
        }
    }

    public static BooleanComparator getFalseFirstComparator() {
        MethodContext _bcornu_methode_context820 = new MethodContext(BooleanComparator.class);
        try {
            CallChecker.varInit(FALSE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.FALSE_FIRST", 78, 2552, 3132);
            CallChecker.varInit(TRUE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.TRUE_FIRST", 78, 2552, 3132);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.BooleanComparator.serialVersionUID", 78, 2552, 3132);
            return BooleanComparator.FALSE_FIRST;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BooleanComparator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context820.methodEnd();
        }
    }

    public static BooleanComparator getBooleanComparator(boolean trueFirst) {
        MethodContext _bcornu_methode_context821 = new MethodContext(BooleanComparator.class);
        try {
            CallChecker.varInit(trueFirst, "trueFirst", 97, 3147, 3925);
            CallChecker.varInit(FALSE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.FALSE_FIRST", 97, 3147, 3925);
            CallChecker.varInit(TRUE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.TRUE_FIRST", 97, 3147, 3925);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.BooleanComparator.serialVersionUID", 97, 3147, 3925);
            if (trueFirst) {
                return BooleanComparator.TRUE_FIRST;
            }else {
                return BooleanComparator.FALSE_FIRST;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BooleanComparator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context821.methodEnd();
        }
    }

    public BooleanComparator() {
        this(false);
        MethodContext _bcornu_methode_context161 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context161.methodEnd();
        }
    }

    public BooleanComparator(boolean trueFirst) {
        MethodContext _bcornu_methode_context162 = new MethodContext(null);
        try {
            this.trueFirst = trueFirst;
            CallChecker.varAssign(this.trueFirst, "this.trueFirst", 125, 4819, 4845);
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    public int compare(Boolean b1, Boolean b2) {
        MethodContext _bcornu_methode_context822 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 138, 4858, 5529);
            CallChecker.varInit(b2, "b2", 138, 4858, 5529);
            CallChecker.varInit(b1, "b1", 138, 4858, 5529);
            CallChecker.varInit(this.trueFirst, "trueFirst", 138, 4858, 5529);
            CallChecker.varInit(FALSE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.FALSE_FIRST", 138, 4858, 5529);
            CallChecker.varInit(TRUE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.TRUE_FIRST", 138, 4858, 5529);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.BooleanComparator.serialVersionUID", 138, 4858, 5529);
            boolean v1 = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(b1, Boolean.class, 139, 5403, 5404)) {
                b1 = CallChecker.beforeCalled(b1, Boolean.class, 139, 5403, 5404);
                v1 = CallChecker.isCalled(b1, Boolean.class, 139, 5403, 5404).booleanValue();
                CallChecker.varAssign(v1, "v1", 139, 5403, 5404);
            }
            boolean v2 = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(b2, Boolean.class, 140, 5443, 5444)) {
                b2 = CallChecker.beforeCalled(b2, Boolean.class, 140, 5443, 5444);
                v2 = CallChecker.isCalled(b2, Boolean.class, 140, 5443, 5444).booleanValue();
                CallChecker.varAssign(v2, "v2", 140, 5443, 5444);
            }
            if (v1 ^ v2) {
                return v1 ^ (trueFirst) ? 1 : -1;
            }else {
                return 0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context822.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context823 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 153, 5536, 5935);
            CallChecker.varInit(this.trueFirst, "trueFirst", 153, 5536, 5935);
            CallChecker.varInit(FALSE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.FALSE_FIRST", 153, 5536, 5935);
            CallChecker.varInit(TRUE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.TRUE_FIRST", 153, 5536, 5935);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.BooleanComparator.serialVersionUID", 153, 5536, 5935);
            int hash = CallChecker.init(int.class);
            if (CallChecker.beforeDeref("BooleanComparator", String.class, 154, 5854, 5872)) {
                hash = CallChecker.isCalled("BooleanComparator", String.class, 154, 5854, 5872).hashCode();
                CallChecker.varAssign(hash, "hash", 154, 5854, 5872);
            }
            if (trueFirst) {
                return (-1) * hash;
            }else {
                return hash;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context823.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context824 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 171, 5942, 6616);
            CallChecker.varInit(object, "object", 171, 5942, 6616);
            CallChecker.varInit(this.trueFirst, "trueFirst", 171, 5942, 6616);
            CallChecker.varInit(FALSE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.FALSE_FIRST", 171, 5942, 6616);
            CallChecker.varInit(TRUE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.TRUE_FIRST", 171, 5942, 6616);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.BooleanComparator.serialVersionUID", 171, 5942, 6616);
            object = CallChecker.beforeCalled(object, BooleanComparator.class, 174, 6591, 6596);
            return ((this) == object) || ((object instanceof BooleanComparator) && ((this.trueFirst) == (CallChecker.isCalled(((BooleanComparator) (object)), BooleanComparator.class, 174, 6591, 6596).trueFirst)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context824.methodEnd();
        }
    }

    public boolean sortsTrueFirst() {
        MethodContext _bcornu_methode_context825 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 188, 6623, 7105);
            CallChecker.varInit(this.trueFirst, "trueFirst", 188, 6623, 7105);
            CallChecker.varInit(FALSE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.FALSE_FIRST", 188, 6623, 7105);
            CallChecker.varInit(TRUE_FIRST, "org.apache.commons.collections.comparators.BooleanComparator.TRUE_FIRST", 188, 6623, 7105);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.BooleanComparator.serialVersionUID", 188, 6623, 7105);
            return trueFirst;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context825.methodEnd();
        }
    }
}

