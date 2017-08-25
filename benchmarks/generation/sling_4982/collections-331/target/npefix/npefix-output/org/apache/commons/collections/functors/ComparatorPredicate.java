package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ComparatorPredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = -1863209236504077399L;

    public enum Criterion {
EQUAL, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL;    }

    private final T object;

    private final Comparator<T> comparator;

    private final ComparatorPredicate.Criterion criterion;

    public static <T> Predicate<T> getInstance(T object, Comparator<T> comparator) {
        MethodContext _bcornu_methode_context1172 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(comparator, "comparator", 108, 3703, 4137);
            CallChecker.varInit(object, "object", 108, 3703, 4137);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ComparatorPredicate.serialVersionUID", 108, 3703, 4137);
            return ComparatorPredicate.getInstance(object, comparator, ComparatorPredicate.Criterion.EQUAL);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1172.methodEnd();
        }
    }

    public static <T> Predicate<T> getInstance(T object, Comparator<T> comparator, ComparatorPredicate.Criterion criterion) {
        MethodContext _bcornu_methode_context1173 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(criterion, "criterion", 121, 4146, 4956);
            CallChecker.varInit(comparator, "comparator", 121, 4146, 4956);
            CallChecker.varInit(object, "object", 121, 4146, 4956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ComparatorPredicate.serialVersionUID", 121, 4146, 4956);
            if (comparator == null) {
                throw new IllegalArgumentException("Comparator must not be null.");
            }
            if (criterion == null) {
                throw new IllegalArgumentException("Criterion must not be null.");
            }
            return new ComparatorPredicate<T>(object, comparator, criterion);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1173.methodEnd();
        }
    }

    public ComparatorPredicate(T object, Comparator<T> comparator, ComparatorPredicate.Criterion criterion) {
        super();
        MethodContext _bcornu_methode_context231 = new MethodContext(null);
        try {
            this.object = object;
            CallChecker.varAssign(this.object, "this.object", 141, 5385, 5405);
            this.comparator = comparator;
            CallChecker.varAssign(this.comparator, "this.comparator", 142, 5416, 5444);
            this.criterion = criterion;
            CallChecker.varAssign(this.criterion, "this.criterion", 143, 5455, 5481);
        } finally {
            _bcornu_methode_context231.methodEnd();
        }
    }

    public boolean evaluate(T target) {
        MethodContext _bcornu_methode_context1174 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 162, 5497, 7175);
            CallChecker.varInit(target, "target", 162, 5497, 7175);
            CallChecker.varInit(this.criterion, "criterion", 162, 5497, 7175);
            CallChecker.varInit(this.comparator, "comparator", 162, 5497, 7175);
            CallChecker.varInit(this.object, "object", 162, 5497, 7175);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ComparatorPredicate.serialVersionUID", 162, 5497, 7175);
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 164, 6468, 6490);
            int comparison = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(comparator, Comparator.class, 165, 6518, 6527)) {
                comparison = CallChecker.isCalled(comparator, Comparator.class, 165, 6518, 6527).compare(object, target);
                CallChecker.varAssign(comparison, "comparison", 165, 6518, 6527);
            }
            switch (criterion) {
                case EQUAL :
                    result = comparison == 0;
                    CallChecker.varAssign(result, "result", 168, 6618, 6644);
                    break;
                case GREATER :
                    result = comparison > 0;
                    CallChecker.varAssign(result, "result", 171, 6702, 6727);
                    break;
                case LESS :
                    result = comparison < 0;
                    CallChecker.varAssign(result, "result", 174, 6782, 6807);
                    break;
                case GREATER_OR_EQUAL :
                    result = comparison >= 0;
                    CallChecker.varAssign(result, "result", 177, 6874, 6900);
                    break;
                case LESS_OR_EQUAL :
                    result = comparison <= 0;
                    CallChecker.varAssign(result, "result", 180, 6964, 6990);
                    break;
                default :
                    throw new IllegalStateException((("The current criterion '" + (criterion)) + "' is invalid."));
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1174.methodEnd();
        }
    }
}

