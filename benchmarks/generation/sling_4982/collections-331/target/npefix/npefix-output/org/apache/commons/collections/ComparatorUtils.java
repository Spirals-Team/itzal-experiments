package org.apache.commons.collections;

import org.apache.commons.collections.comparators.TransformingComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.comparators.NullComparator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.comparators.BooleanComparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import org.apache.commons.collections.comparators.ComparableComparator;
import java.util.Comparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class ComparatorUtils {
    public ComparatorUtils() {
        MethodContext _bcornu_methode_context339 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context339.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static final Comparator NATURAL_COMPARATOR = ComparableComparator.<Comparable>getInstance();

    @SuppressWarnings(value = "unchecked")
    public static <E extends Comparable<? super E>> Comparator<E> naturalComparator() {
        MethodContext _bcornu_methode_context1741 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 66, 2253, 2557);
            return ComparatorUtils.NATURAL_COMPARATOR;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1741.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E extends Comparable<? super E>> Comparator<E> chainedComparator(Comparator<E> comparator1, Comparator<E> comparator2) {
        MethodContext _bcornu_methode_context1742 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(comparator2, "comparator2", 82, 2564, 3294);
            CallChecker.varInit(comparator1, "comparator1", 82, 2564, 3294);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 82, 2564, 3294);
            return ComparatorUtils.chainedComparator(new Comparator[]{ comparator1 , comparator2 });
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1742.methodEnd();
        }
    }

    public static <E extends Comparable<? super E>> Comparator<E> chainedComparator(Comparator<E>[] comparators) {
        MethodContext _bcornu_methode_context1743 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(comparators, "comparators", 95, 3301, 4205);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 95, 3301, 4205);
            ComparatorChain<E> chain = CallChecker.varInit(new ComparatorChain<E>(), "chain", 96, 3879, 3930);
            comparators = CallChecker.beforeCalled(comparators, Comparator[].class, 97, 3960, 3970);
            for (int i = 0; i < (CallChecker.isCalled(comparators, Comparator[].class, 97, 3960, 3970).length); i++) {
                if (CallChecker.beforeDeref(comparators, Comparator[].class, 98, 4003, 4013)) {
                    comparators = CallChecker.beforeCalled(comparators, Comparator[].class, 98, 4003, 4013);
                    if ((CallChecker.isCalled(comparators, Comparator[].class, 98, 4003, 4013)[i]) == null) {
                        throw new NullPointerException("Comparator cannot be null");
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(comparators, Comparator[].class, 101, 4152, 4162)) {
                    if (CallChecker.beforeDeref(chain, ComparatorChain.class, 101, 4132, 4136)) {
                        comparators = CallChecker.beforeCalled(comparators, Comparator[].class, 101, 4152, 4162);
                        chain = CallChecker.beforeCalled(chain, ComparatorChain.class, 101, 4132, 4136);
                        CallChecker.isCalled(chain, ComparatorChain.class, 101, 4132, 4136).addComparator(CallChecker.isCalled(comparators, Comparator[].class, 101, 4152, 4162)[i]);
                    }
                }
            }
            return chain;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1743.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E extends Comparable<? super E>> Comparator<E> chainedComparator(Collection<Comparator<E>> comparators) {
        MethodContext _bcornu_methode_context1744 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(comparators, "comparators", 118, 4212, 5098);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 118, 4212, 5098);
            if (CallChecker.beforeDeref(comparators, Collection.class, 120, 5062, 5072)) {
                if (CallChecker.beforeDeref(comparators, Collection.class, 120, 5027, 5037)) {
                    comparators = CallChecker.beforeCalled(comparators, Collection.class, 120, 5062, 5072);
                    comparators = CallChecker.beforeCalled(comparators, Collection.class, 120, 5027, 5037);
                    return ComparatorUtils.chainedComparator(((Comparator<E>[]) (CallChecker.isCalled(comparators, Collection.class, 120, 5027, 5037).toArray(new Comparator[CallChecker.isCalled(comparators, Collection.class, 120, 5062, 5072).size()]))));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1744.methodEnd();
        }
    }

    public static <E> Comparator<E> reversedComparator(Comparator<E> comparator) {
        MethodContext _bcornu_methode_context1745 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(comparator, "comparator", 131, 5105, 5497);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 131, 5105, 5497);
            return new ReverseComparator<E>(comparator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1745.methodEnd();
        }
    }

    public static Comparator<Boolean> booleanComparator(boolean trueFirst) {
        MethodContext _bcornu_methode_context1746 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(trueFirst, "trueFirst", 147, 5504, 6109);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 147, 5504, 6109);
            return BooleanComparator.getBooleanComparator(trueFirst);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<Boolean>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1746.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Comparator<E> nullLowComparator(Comparator<E> comparator) {
        MethodContext _bcornu_methode_context1747 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(comparator, "comparator", 163, 6120, 6863);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 163, 6120, 6863);
            if (comparator == null) {
                comparator = ComparatorUtils.NATURAL_COMPARATOR;
                CallChecker.varAssign(comparator, "comparator", 165, 6759, 6790);
            }
            return new NullComparator<E>(comparator, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1747.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Comparator<E> nullHighComparator(Comparator<E> comparator) {
        MethodContext _bcornu_methode_context1748 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(comparator, "comparator", 182, 6870, 7616);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 182, 6870, 7616);
            if (comparator == null) {
                comparator = ComparatorUtils.NATURAL_COMPARATOR;
                CallChecker.varAssign(comparator, "comparator", 184, 7513, 7544);
            }
            return new NullComparator<E>(comparator, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1748.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Comparator<E> transformedComparator(Comparator<E> comparator, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context1749 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(transformer, "transformer", 202, 7623, 8452);
            CallChecker.varInit(comparator, "comparator", 202, 7623, 8452);
            CallChecker.varInit(NATURAL_COMPARATOR, "org.apache.commons.collections.ComparatorUtils.NATURAL_COMPARATOR", 202, 7623, 8452);
            if (comparator == null) {
                comparator = ComparatorUtils.NATURAL_COMPARATOR;
                CallChecker.varAssign(comparator, "comparator", 204, 8334, 8365);
            }
            return new TransformingComparator<E>(transformer, comparator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1749.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> E min(E o1, E o2, Comparator<E> comparator) {
        if (comparator == null) {
            comparator = ComparatorUtils.NATURAL_COMPARATOR;
            CallChecker.varAssign(comparator, "comparator", 222, 8982, 9013);
        }
        int c = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(comparator, Comparator.class, 224, 9041, 9050)) {
            comparator = CallChecker.beforeCalled(comparator, Comparator.class, 224, 9041, 9050);
            c = CallChecker.isCalled(comparator, Comparator.class, 224, 9041, 9050).compare(o1, o2);
            CallChecker.varAssign(c, "c", 224, 9041, 9050);
        }
        if (c < 0) {
            return o1;
        }else {
            return o2;
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> E max(E o1, E o2, Comparator<E> comparator) {
        if (comparator == null) {
            comparator = ComparatorUtils.NATURAL_COMPARATOR;
            CallChecker.varAssign(comparator, "comparator", 241, 9636, 9667);
        }
        int c = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(comparator, Comparator.class, 243, 9695, 9704)) {
            comparator = CallChecker.beforeCalled(comparator, Comparator.class, 243, 9695, 9704);
            c = CallChecker.isCalled(comparator, Comparator.class, 243, 9695, 9704).compare(o1, o2);
            CallChecker.varAssign(c, "c", 243, 9695, 9704);
        }
        if (c > 0) {
            return o1;
        }else {
            return o2;
        }
    }
}

