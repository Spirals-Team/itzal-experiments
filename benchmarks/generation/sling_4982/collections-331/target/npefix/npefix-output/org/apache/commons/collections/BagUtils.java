package org.apache.commons.collections;

import org.apache.commons.collections.bag.UnmodifiableSortedBag;
import org.apache.commons.collections.bag.UnmodifiableBag;
import org.apache.commons.collections.bag.TreeBag;
import org.apache.commons.collections.bag.TransformedSortedBag;
import org.apache.commons.collections.bag.TransformedBag;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.bag.HashBag;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.bag.PredicatedBag;
import org.apache.commons.collections.bag.PredicatedSortedBag;
import org.apache.commons.collections.bag.SynchronizedBag;
import org.apache.commons.collections.bag.SynchronizedSortedBag;

public class BagUtils {
    public static final Bag<Object> EMPTY_BAG = UnmodifiableBag.decorate(new HashBag<Object>());

    public static final Bag<Object> EMPTY_SORTED_BAG = UnmodifiableSortedBag.decorate(new TreeBag<Object>());

    public BagUtils() {
        MethodContext _bcornu_methode_context285 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context285.methodEnd();
        }
    }

    public static <E> Bag<E> synchronizedBag(Bag<E> bag) {
        MethodContext _bcornu_methode_context1516 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(bag, "bag", 88, 2288, 3377);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 88, 2288, 3377);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 88, 2288, 3377);
            return SynchronizedBag.decorate(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1516.methodEnd();
        }
    }

    public static <E> Bag<E> unmodifiableBag(Bag<E> bag) {
        MethodContext _bcornu_methode_context1517 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(bag, "bag", 101, 3384, 3873);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 101, 3384, 3873);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 101, 3384, 3873);
            return UnmodifiableBag.decorate(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1517.methodEnd();
        }
    }

    public static <E> Bag<E> predicatedBag(Bag<E> bag, Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context1518 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(predicate, "predicate", 119, 3880, 4689);
            CallChecker.varInit(bag, "bag", 119, 3880, 4689);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 119, 3880, 4689);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 119, 3880, 4689);
            return PredicatedBag.decorate(bag, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1518.methodEnd();
        }
    }

    public static <E> Bag<E> transformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context1519 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(transformer, "transformer", 138, 4696, 5596);
            CallChecker.varInit(bag, "bag", 138, 4696, 5596);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 138, 4696, 5596);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 138, 4696, 5596);
            return TransformedBag.decorate(bag, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1519.methodEnd();
        }
    }

    public static <E> SortedBag<E> synchronizedSortedBag(SortedBag<E> bag) {
        MethodContext _bcornu_methode_context1520 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(bag, "bag", 168, 5603, 6748);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 168, 5603, 6748);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 168, 5603, 6748);
            return SynchronizedSortedBag.decorate(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1520.methodEnd();
        }
    }

    public static <E> SortedBag<E> unmodifiableSortedBag(SortedBag<E> bag) {
        MethodContext _bcornu_methode_context1521 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(bag, "bag", 182, 6755, 7288);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 182, 6755, 7288);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 182, 6755, 7288);
            return UnmodifiableSortedBag.decorate(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1521.methodEnd();
        }
    }

    public static <E> SortedBag<E> predicatedSortedBag(SortedBag<E> bag, Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context1522 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(predicate, "predicate", 201, 7295, 8174);
            CallChecker.varInit(bag, "bag", 201, 7295, 8174);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 201, 7295, 8174);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 201, 7295, 8174);
            return PredicatedSortedBag.decorate(bag, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1522.methodEnd();
        }
    }

    public static <E> SortedBag<E> transformedSortedBag(SortedBag<E> bag, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context1523 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(transformer, "transformer", 221, 8181, 9118);
            CallChecker.varInit(bag, "bag", 221, 8181, 9118);
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 221, 8181, 9118);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 221, 8181, 9118);
            return TransformedSortedBag.decorate(bag, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1523.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Bag<E> emptyBag() {
        MethodContext _bcornu_methode_context1524 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 231, 9125, 9339);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 231, 9125, 9339);
            return ((Bag<E>) (BagUtils.EMPTY_BAG));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1524.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> SortedBag<E> emptySortedBag() {
        MethodContext _bcornu_methode_context1525 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(EMPTY_SORTED_BAG, "org.apache.commons.collections.BagUtils.EMPTY_SORTED_BAG", 241, 9346, 9597);
            CallChecker.varInit(EMPTY_BAG, "org.apache.commons.collections.BagUtils.EMPTY_BAG", 241, 9346, 9597);
            return ((SortedBag<E>) (BagUtils.EMPTY_SORTED_BAG));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1525.methodEnd();
        }
    }
}

