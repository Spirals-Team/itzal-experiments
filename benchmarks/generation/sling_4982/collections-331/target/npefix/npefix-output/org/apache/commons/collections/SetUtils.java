package org.apache.commons.collections;

import org.apache.commons.collections.set.UnmodifiableSortedSet;
import org.apache.commons.collections.set.UnmodifiableSet;
import java.util.TreeSet;
import org.apache.commons.collections.set.TransformedSortedSet;
import org.apache.commons.collections.set.TransformedSet;
import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.apache.commons.collections.set.SynchronizedSet;
import java.util.SortedSet;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Collections;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.set.ListOrderedSet;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.set.PredicatedSet;
import org.apache.commons.collections.set.PredicatedSortedSet;
import java.util.Set;

public class SetUtils {
    public static final Set<?> EMPTY_SET = Collections.EMPTY_SET;

    public static <E> Set<E> emptySet() {
        MethodContext _bcornu_methode_context45 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 61, 2109, 2292);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 61, 2109, 2292);
            return Collections.<E>emptySet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public static final SortedSet<?> EMPTY_SORTED_SET = UnmodifiableSortedSet.decorate(new TreeSet<Object>());

    @SuppressWarnings(value = "unchecked")
    public static <E> SortedSet<E> emptySortedSet() {
        MethodContext _bcornu_methode_context46 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 77, 2508, 2757);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 77, 2508, 2757);
            return ((SortedSet<E>) (SetUtils.EMPTY_SORTED_SET));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public SetUtils() {
        MethodContext _bcornu_methode_context11 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public static boolean isEqualSet(final Collection<?> set1, final Collection<?> set2) {
        MethodContext _bcornu_methode_context47 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(set2, "set2", 116, 2877, 4548);
            CallChecker.varInit(set1, "set1", 116, 2877, 4548);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 116, 2877, 4548);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 116, 2877, 4548);
            if (set1 == set2) {
                return true;
            }
            if (((set1 == null) || (set2 == null)) || ((set1.size()) != (set2.size()))) {
                return false;
            }
            return set1.containsAll(set2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public static <T> int hashCodeForSet(final Collection<T> set) {
        MethodContext _bcornu_methode_context48 = new MethodContext(int.class);
        try {
            CallChecker.varInit(set, "set", 139, 4555, 5362);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 139, 4555, 5362);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 139, 4555, 5362);
            if (set == null) {
                return 0;
            }
            int hashCode = CallChecker.varInit(((int) (0)), "hashCode", 144, 5188, 5204);
            for (T obj : set) {
                if (obj != null) {
                    hashCode += obj.hashCode();
                    CallChecker.varAssign(hashCode, "hashCode", 147, 5281, 5307);
                }
            }
            return hashCode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public static <T> Set<T> synchronizedSet(Set<T> set) {
        MethodContext _bcornu_methode_context49 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(set, "set", 176, 5373, 6263);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 176, 5373, 6263);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 176, 5373, 6263);
            return SynchronizedSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public static <E> Set<E> unmodifiableSet(Set<E> set) {
        MethodContext _bcornu_methode_context50 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(set, "set", 189, 6270, 6727);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 189, 6270, 6727);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 189, 6270, 6727);
            return UnmodifiableSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    public static <T> Set<T> predicatedSet(Set<T> set, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context51 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(predicate, "predicate", 206, 6734, 7538);
            CallChecker.varInit(set, "set", 206, 6734, 7538);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 206, 6734, 7538);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 206, 6734, 7538);
            return PredicatedSet.decorate(set, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    public static <E> Set<E> transformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context52 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(transformer, "transformer", 225, 7545, 8448);
            CallChecker.varInit(set, "set", 225, 7545, 8448);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 225, 7545, 8448);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 225, 7545, 8448);
            return TransformedSet.decorate(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    public static <E> Set<E> orderedSet(Set<E> set) {
        MethodContext _bcornu_methode_context53 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(set, "set", 240, 8459, 9006);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 240, 8459, 9006);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 240, 8459, 9006);
            return ListOrderedSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public static <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> set) {
        MethodContext _bcornu_methode_context54 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(set, "set", 267, 9017, 9952);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 267, 9017, 9952);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 267, 9017, 9952);
            return SynchronizedSortedSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    public static <T> SortedSet<T> unmodifiableSortedSet(SortedSet<T> set) {
        MethodContext _bcornu_methode_context55 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(set, "set", 280, 9959, 10461);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 280, 9959, 10461);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 280, 9959, 10461);
            return UnmodifiableSortedSet.decorate(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    public static <T> SortedSet<T> predicatedSortedSet(SortedSet<T> set, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context56 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(predicate, "predicate", 297, 10468, 11340);
            CallChecker.varInit(set, "set", 297, 10468, 11340);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 297, 10468, 11340);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 297, 10468, 11340);
            return PredicatedSortedSet.decorate(set, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public static <E> SortedSet<E> transformedSortedSet(SortedSet<E> set, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context57 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(transformer, "transformer", 316, 11347, 12287);
            CallChecker.varInit(set, "set", 316, 11347, 12287);
            CallChecker.varInit(EMPTY_SORTED_SET, "org.apache.commons.collections.SetUtils.EMPTY_SORTED_SET", 316, 11347, 12287);
            CallChecker.varInit(EMPTY_SET, "org.apache.commons.collections.SetUtils.EMPTY_SET", 316, 11347, 12287);
            return TransformedSortedSet.decorate(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }
}

