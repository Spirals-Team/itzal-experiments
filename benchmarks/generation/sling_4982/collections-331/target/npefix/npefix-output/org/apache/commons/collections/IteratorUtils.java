package org.apache.commons.collections;

import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.iterators.UnmodifiableListIterator;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.commons.collections.iterators.TransformIterator;
import org.apache.commons.collections.iterators.SingletonListIterator;
import org.apache.commons.collections.iterators.SingletonIterator;
import org.apache.commons.collections.iterators.ObjectGraphIterator;
import org.apache.commons.collections.iterators.ObjectArrayListIterator;
import org.apache.commons.collections.iterators.ObjectArrayIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.lang.reflect.Method;
import java.util.Map;
import org.apache.commons.collections.iterators.LoopingListIterator;
import org.apache.commons.collections.iterators.LoopingIterator;
import org.apache.commons.collections.iterators.ListIteratorWrapper;
import java.util.ListIterator;
import java.util.List;
import org.apache.commons.collections.iterators.IteratorEnumeration;
import org.apache.commons.collections.iterators.IteratorChain;
import org.apache.commons.collections.iterators.EmptyIterator;
import java.util.Dictionary;
import java.util.Comparator;
import java.util.Collection;
import org.apache.commons.collections.iterators.CollatingIterator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.iterators.ArrayListIterator;
import java.util.ArrayList;
import org.apache.commons.collections.iterators.ArrayIterator;
import java.lang.reflect.Array;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.iterators.EmptyListIterator;
import org.apache.commons.collections.iterators.EmptyMapIterator;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import java.util.Enumeration;
import org.apache.commons.collections.iterators.EnumerationIterator;
import org.apache.commons.collections.iterators.FilterIterator;
import org.apache.commons.collections.iterators.FilterListIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;

public class IteratorUtils {
    public static final ResettableIterator<Object> EMPTY_ITERATOR = EmptyIterator.RESETTABLE_INSTANCE;

    public static final ResettableListIterator<Object> EMPTY_LIST_ITERATOR = EmptyListIterator.RESETTABLE_INSTANCE;

    public static final OrderedIterator<Object> EMPTY_ORDERED_ITERATOR = EmptyOrderedIterator.INSTANCE;

    public static final MapIterator<Object, Object> EMPTY_MAP_ITERATOR = EmptyMapIterator.INSTANCE;

    public static final OrderedMapIterator<Object, Object> EMPTY_ORDERED_MAP_ITERATOR = EmptyOrderedMapIterator.INSTANCE;

    public IteratorUtils() {
        MethodContext _bcornu_methode_context362 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context362.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> emptyIterator() {
        MethodContext _bcornu_methode_context1852 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 128, 5121, 5723);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 128, 5121, 5723);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 128, 5121, 5723);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 128, 5121, 5723);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 128, 5121, 5723);
            return EmptyIterator.<E>getResettableInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1852.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> emptyListIterator() {
        MethodContext _bcornu_methode_context1853 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 143, 5730, 6271);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 143, 5730, 6271);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 143, 5730, 6271);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 143, 5730, 6271);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 143, 5730, 6271);
            return EmptyListIterator.<E>getResettableInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1853.methodEnd();
        }
    }

    public static <E> OrderedIterator<E> emptyOrderedIterator() {
        MethodContext _bcornu_methode_context1854 = new MethodContext(OrderedIterator.class);
        try {
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 155, 6278, 6607);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 155, 6278, 6607);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 155, 6278, 6607);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 155, 6278, 6607);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 155, 6278, 6607);
            return EmptyOrderedIterator.<E>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1854.methodEnd();
        }
    }

    public static <K, V> MapIterator<K, V> emptyMapIterator() {
        MethodContext _bcornu_methode_context1855 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 167, 6614, 6935);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 167, 6614, 6935);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 167, 6614, 6935);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 167, 6614, 6935);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 167, 6614, 6935);
            return EmptyMapIterator.<K, V>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1855.methodEnd();
        }
    }

    public static <K, V> OrderedMapIterator<K, V> emptyOrderedMapIterator() {
        MethodContext _bcornu_methode_context1856 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 179, 6942, 7292);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 179, 6942, 7292);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 179, 6942, 7292);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 179, 6942, 7292);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 179, 6942, 7292);
            return EmptyOrderedMapIterator.<K, V>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1856.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> singletonIterator(E object) {
        MethodContext _bcornu_methode_context1857 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(object, "object", 197, 7299, 7975);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 197, 7299, 7975);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 197, 7299, 7975);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 197, 7299, 7975);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 197, 7299, 7975);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 197, 7299, 7975);
            return new SingletonIterator<E>(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1857.methodEnd();
        }
    }

    public static <E> ListIterator<E> singletonListIterator(E object) {
        MethodContext _bcornu_methode_context1858 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(object, "object", 210, 7982, 8405);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 210, 7982, 8405);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 210, 7982, 8405);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 210, 7982, 8405);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 210, 7982, 8405);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 210, 7982, 8405);
            return new SingletonListIterator<E>(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1858.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> arrayIterator(E[] array) {
        MethodContext _bcornu_methode_context1859 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(array, "array", 226, 8412, 9013);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 226, 8412, 9013);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 226, 8412, 9013);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 226, 8412, 9013);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 226, 8412, 9013);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 226, 8412, 9013);
            return new ObjectArrayIterator<E>(array);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1859.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> arrayIterator(Object array) {
        MethodContext _bcornu_methode_context1860 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(array, "array", 241, 9020, 9595);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 241, 9020, 9595);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 241, 9020, 9595);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 241, 9020, 9595);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 241, 9020, 9595);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 241, 9020, 9595);
            return new ArrayIterator<E>(array);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1860.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> arrayIterator(E[] array, int start) {
        MethodContext _bcornu_methode_context1861 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(start, "start", 258, 9602, 10327);
            CallChecker.varInit(array, "array", 258, 9602, 10327);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 258, 9602, 10327);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 258, 9602, 10327);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 258, 9602, 10327);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 258, 9602, 10327);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 258, 9602, 10327);
            return new ObjectArrayIterator<E>(array, start);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1861.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> arrayIterator(Object array, int start) {
        MethodContext _bcornu_methode_context1862 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(start, "start", 276, 10334, 11119);
            CallChecker.varInit(array, "array", 276, 10334, 11119);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 276, 10334, 11119);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 276, 10334, 11119);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 276, 10334, 11119);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 276, 10334, 11119);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 276, 10334, 11119);
            return new ArrayIterator<E>(array, start);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1862.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> arrayIterator(E[] array, int start, int end) {
        MethodContext _bcornu_methode_context1863 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(end, "end", 294, 11126, 11929);
            CallChecker.varInit(start, "start", 294, 11126, 11929);
            CallChecker.varInit(array, "array", 294, 11126, 11929);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 294, 11126, 11929);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 294, 11126, 11929);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 294, 11126, 11929);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 294, 11126, 11929);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 294, 11126, 11929);
            return new ObjectArrayIterator<E>(array, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1863.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> arrayIterator(Object array, int start, int end) {
        MethodContext _bcornu_methode_context1864 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(end, "end", 313, 11936, 12795);
            CallChecker.varInit(start, "start", 313, 11936, 12795);
            CallChecker.varInit(array, "array", 313, 11936, 12795);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 313, 11936, 12795);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 313, 11936, 12795);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 313, 11936, 12795);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 313, 11936, 12795);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 313, 11936, 12795);
            return new ArrayIterator<E>(array, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1864.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> arrayListIterator(E[] array) {
        MethodContext _bcornu_methode_context1865 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(array, "array", 325, 12802, 13239);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 325, 12802, 13239);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 325, 12802, 13239);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 325, 12802, 13239);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 325, 12802, 13239);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 325, 12802, 13239);
            return new ObjectArrayListIterator<E>(array);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1865.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> arrayListIterator(Object array) {
        MethodContext _bcornu_methode_context1866 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(array, "array", 340, 13246, 13841);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 340, 13246, 13841);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 340, 13246, 13841);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 340, 13246, 13841);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 340, 13246, 13841);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 340, 13246, 13841);
            return new ArrayListIterator<E>(array);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1866.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> arrayListIterator(E[] array, int start) {
        MethodContext _bcornu_methode_context1867 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(start, "start", 353, 13848, 14369);
            CallChecker.varInit(array, "array", 353, 13848, 14369);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 353, 13848, 14369);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 353, 13848, 14369);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 353, 13848, 14369);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 353, 13848, 14369);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 353, 13848, 14369);
            return new ObjectArrayListIterator<E>(array, start);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1867.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> arrayListIterator(Object array, int start) {
        MethodContext _bcornu_methode_context1868 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(start, "start", 370, 14376, 15133);
            CallChecker.varInit(array, "array", 370, 14376, 15133);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 370, 14376, 15133);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 370, 14376, 15133);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 370, 14376, 15133);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 370, 14376, 15133);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 370, 14376, 15133);
            return new ArrayListIterator<E>(array, start);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1868.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> arrayListIterator(E[] array, int start, int end) {
        MethodContext _bcornu_methode_context1869 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(end, "end", 385, 15140, 15783);
            CallChecker.varInit(start, "start", 385, 15140, 15783);
            CallChecker.varInit(array, "array", 385, 15140, 15783);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 385, 15140, 15783);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 385, 15140, 15783);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 385, 15140, 15783);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 385, 15140, 15783);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 385, 15140, 15783);
            return new ObjectArrayListIterator<E>(array, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1869.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> arrayListIterator(Object array, int start, int end) {
        MethodContext _bcornu_methode_context1870 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(end, "end", 404, 15790, 16669);
            CallChecker.varInit(start, "start", 404, 15790, 16669);
            CallChecker.varInit(array, "array", 404, 15790, 16669);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 404, 15790, 16669);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 404, 15790, 16669);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 404, 15790, 16669);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 404, 15790, 16669);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 404, 15790, 16669);
            return new ArrayListIterator<E>(array, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1870.methodEnd();
        }
    }

    public static <E> Iterator<E> unmodifiableIterator(Iterator<E> iterator) {
        MethodContext _bcornu_methode_context1871 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterator, "iterator", 418, 16676, 17229);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 418, 16676, 17229);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 418, 16676, 17229);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 418, 16676, 17229);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 418, 16676, 17229);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 418, 16676, 17229);
            return UnmodifiableIterator.decorate(iterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1871.methodEnd();
        }
    }

    public static <E> ListIterator<E> unmodifiableListIterator(ListIterator<E> listIterator) {
        MethodContext _bcornu_methode_context1872 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(listIterator, "listIterator", 431, 17236, 17785);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 431, 17236, 17785);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 431, 17236, 17785);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 431, 17236, 17785);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 431, 17236, 17785);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 431, 17236, 17785);
            return UnmodifiableListIterator.decorate(listIterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1872.methodEnd();
        }
    }

    public static <K, V> MapIterator<K, V> unmodifiableMapIterator(MapIterator<K, V> mapIterator) {
        MethodContext _bcornu_methode_context1873 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(mapIterator, "mapIterator", 443, 17792, 18318);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 443, 17792, 18318);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 443, 17792, 18318);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 443, 17792, 18318);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 443, 17792, 18318);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 443, 17792, 18318);
            return UnmodifiableMapIterator.decorate(mapIterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1873.methodEnd();
        }
    }

    public static <E> Iterator<E> chainedIterator(Iterator<? extends E> iterator1, Iterator<? extends E> iterator2) {
        MethodContext _bcornu_methode_context1874 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterator2, "iterator2", 458, 18325, 18956);
            CallChecker.varInit(iterator1, "iterator1", 458, 18325, 18956);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 458, 18325, 18956);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 458, 18325, 18956);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 458, 18325, 18956);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 458, 18325, 18956);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 458, 18325, 18956);
            return new IteratorChain<E>(iterator1, iterator2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1874.methodEnd();
        }
    }

    public static <E> Iterator<E> chainedIterator(Iterator<? extends E>[] iterators) {
        MethodContext _bcornu_methode_context1875 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterators, "iterators", 470, 18963, 19444);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 470, 18963, 19444);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 470, 18963, 19444);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 470, 18963, 19444);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 470, 18963, 19444);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 470, 18963, 19444);
            return new IteratorChain<E>(iterators);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1875.methodEnd();
        }
    }

    public static <E> Iterator<E> chainedIterator(Collection<Iterator<? extends E>> iterators) {
        MethodContext _bcornu_methode_context1876 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterators, "iterators", 483, 19451, 20045);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 483, 19451, 20045);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 483, 19451, 20045);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 483, 19451, 20045);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 483, 19451, 20045);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 483, 19451, 20045);
            return new IteratorChain<E>(iterators);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1876.methodEnd();
        }
    }

    public static <E> Iterator<E> collatedIterator(Comparator<? super E> comparator, Iterator<? extends E> iterator1, Iterator<? extends E> iterator2) {
        MethodContext _bcornu_methode_context1877 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterator2, "iterator2", 505, 20052, 21168);
            CallChecker.varInit(iterator1, "iterator1", 505, 20052, 21168);
            CallChecker.varInit(comparator, "comparator", 505, 20052, 21168);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 505, 20052, 21168);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 505, 20052, 21168);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 505, 20052, 21168);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 505, 20052, 21168);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 505, 20052, 21168);
            return new CollatingIterator<E>(comparator, iterator1, iterator2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1877.methodEnd();
        }
    }

    public static <E> Iterator<E> collatedIterator(Comparator<? super E> comparator, Iterator<? extends E>[] iterators) {
        MethodContext _bcornu_methode_context1878 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterators, "iterators", 524, 21175, 22130);
            CallChecker.varInit(comparator, "comparator", 524, 21175, 22130);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 524, 21175, 22130);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 524, 21175, 22130);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 524, 21175, 22130);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 524, 21175, 22130);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 524, 21175, 22130);
            return new CollatingIterator<E>(comparator, iterators);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1878.methodEnd();
        }
    }

    public static <E> Iterator<E> collatedIterator(Comparator<? super E> comparator, Collection<Iterator<? extends E>> iterators) {
        MethodContext _bcornu_methode_context1879 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterators, "iterators", 544, 22137, 23216);
            CallChecker.varInit(comparator, "comparator", 544, 22137, 23216);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 544, 22137, 23216);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 544, 22137, 23216);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 544, 22137, 23216);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 544, 22137, 23216);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 544, 22137, 23216);
            return new CollatingIterator<E>(comparator, iterators);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1879.methodEnd();
        }
    }

    public static <E> Iterator<E> objectGraphIterator(E root, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context1880 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(transformer, "transformer", 604, 23223, 25848);
            CallChecker.varInit(root, "root", 604, 23223, 25848);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 604, 23223, 25848);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 604, 23223, 25848);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 604, 23223, 25848);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 604, 23223, 25848);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 604, 23223, 25848);
            return new ObjectGraphIterator<E>(root, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1880.methodEnd();
        }
    }

    public static <I, O> Iterator<O> transformedIterator(Iterator<? extends I> iterator, Transformer<? super I, ? extends O> transform) {
        MethodContext _bcornu_methode_context1881 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(transform, "transform", 621, 25855, 26844);
            CallChecker.varInit(iterator, "iterator", 621, 25855, 26844);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 621, 25855, 26844);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 621, 25855, 26844);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 621, 25855, 26844);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 621, 25855, 26844);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 621, 25855, 26844);
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (transform == null) {
                throw new NullPointerException("Transformer must not be null");
            }
            return new TransformIterator<I, O>(iterator, transform);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1881.methodEnd();
        }
    }

    public static <E> Iterator<E> filteredIterator(Iterator<? extends E> iterator, Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context1882 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(predicate, "predicate", 644, 26851, 27774);
            CallChecker.varInit(iterator, "iterator", 644, 26851, 27774);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 644, 26851, 27774);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 644, 26851, 27774);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 644, 26851, 27774);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 644, 26851, 27774);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 644, 26851, 27774);
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (predicate == null) {
                throw new NullPointerException("Predicate must not be null");
            }
            return new FilterIterator<E>(iterator, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1882.methodEnd();
        }
    }

    public static <E> ListIterator<E> filteredListIterator(ListIterator<? extends E> listIterator, Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context1883 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(predicate, "predicate", 665, 27781, 28660);
            CallChecker.varInit(listIterator, "listIterator", 665, 27781, 28660);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 665, 27781, 28660);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 665, 27781, 28660);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 665, 27781, 28660);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 665, 27781, 28660);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 665, 27781, 28660);
            if (listIterator == null) {
                throw new NullPointerException("ListIterator must not be null");
            }
            if (predicate == null) {
                throw new NullPointerException("Predicate must not be null");
            }
            return new FilterListIterator<E>(listIterator, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1883.methodEnd();
        }
    }

    public static <E> ResettableIterator<E> loopingIterator(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1884 = new MethodContext(ResettableIterator.class);
        try {
            CallChecker.varInit(coll, "coll", 688, 28667, 29454);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 688, 28667, 29454);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 688, 28667, 29454);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 688, 28667, 29454);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 688, 28667, 29454);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 688, 28667, 29454);
            if (coll == null) {
                throw new NullPointerException("Collection must not be null");
            }
            return new LoopingIterator<E>(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1884.methodEnd();
        }
    }

    public static <E> ResettableListIterator<E> loopingListIterator(List<E> list) {
        MethodContext _bcornu_methode_context1885 = new MethodContext(ResettableListIterator.class);
        try {
            CallChecker.varInit(list, "list", 706, 29461, 30146);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 706, 29461, 30146);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 706, 29461, 30146);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 706, 29461, 30146);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 706, 29461, 30146);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 706, 29461, 30146);
            if (list == null) {
                throw new NullPointerException("List must not be null");
            }
            return new LoopingListIterator<E>(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResettableListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1885.methodEnd();
        }
    }

    public static <E> Iterator<E> asIterator(Enumeration<? extends E> enumeration) {
        MethodContext _bcornu_methode_context1886 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(enumeration, "enumeration", 721, 30153, 30690);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 721, 30153, 30690);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 721, 30153, 30690);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 721, 30153, 30690);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 721, 30153, 30690);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 721, 30153, 30690);
            if (enumeration == null) {
                throw new NullPointerException("Enumeration must not be null");
            }
            return new EnumerationIterator<E>(enumeration);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1886.methodEnd();
        }
    }

    public static <E> Iterator<E> asIterator(Enumeration<? extends E> enumeration, Collection<? super E> removeCollection) {
        MethodContext _bcornu_methode_context1887 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(removeCollection, "removeCollection", 736, 30697, 31460);
            CallChecker.varInit(enumeration, "enumeration", 736, 30697, 31460);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 736, 30697, 31460);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 736, 30697, 31460);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 736, 30697, 31460);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 736, 30697, 31460);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 736, 30697, 31460);
            if (enumeration == null) {
                throw new NullPointerException("Enumeration must not be null");
            }
            if (removeCollection == null) {
                throw new NullPointerException("Collection must not be null");
            }
            return new EnumerationIterator<E>(enumeration, removeCollection);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1887.methodEnd();
        }
    }

    public static <E> Enumeration<E> asEnumeration(Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context1888 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(iterator, "iterator", 753, 31467, 31937);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 753, 31467, 31937);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 753, 31467, 31937);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 753, 31467, 31937);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 753, 31467, 31937);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 753, 31467, 31937);
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            return new IteratorEnumeration<E>(iterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1888.methodEnd();
        }
    }

    public static <E> ListIterator<E> toListIterator(Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context1889 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(iterator, "iterator", 770, 31944, 32581);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 770, 31944, 32581);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 770, 31944, 32581);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 770, 31944, 32581);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 770, 31944, 32581);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 770, 31944, 32581);
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            return new ListIteratorWrapper<E>(iterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1889.methodEnd();
        }
    }

    public static Object[] toArray(Iterator<?> iterator) {
        MethodContext _bcornu_methode_context1890 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(iterator, "iterator", 787, 32588, 33219);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 787, 32588, 33219);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 787, 32588, 33219);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 787, 32588, 33219);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 787, 32588, 33219);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 787, 32588, 33219);
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            List<?> list = CallChecker.varInit(IteratorUtils.toList(iterator, 100), "list", 791, 33146, 33182);
            if (CallChecker.beforeDeref(list, List.class, 792, 33199, 33202)) {
                list = CallChecker.beforeCalled(list, List.class, 792, 33199, 33202);
                return CallChecker.isCalled(list, List.class, 792, 33199, 33202).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1890.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> E[] toArray(Iterator<? extends E> iterator, Class<E> arrayClass) {
        MethodContext _bcornu_methode_context1891 = new MethodContext(null);
        try {
            CallChecker.varInit(arrayClass, "arrayClass", 809, 33226, 34266);
            CallChecker.varInit(iterator, "iterator", 809, 33226, 34266);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 809, 33226, 34266);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 809, 33226, 34266);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 809, 33226, 34266);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 809, 33226, 34266);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 809, 33226, 34266);
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (arrayClass == null) {
                throw new NullPointerException("Array class must not be null");
            }
            List<E> list = CallChecker.varInit(IteratorUtils.toList(iterator, 100), "list", 816, 34145, 34181);
            if (CallChecker.beforeDeref(list, List.class, 817, 34247, 34250)) {
                if (CallChecker.beforeDeref(list, List.class, 817, 34198, 34201)) {
                    list = CallChecker.beforeCalled(list, List.class, 817, 34247, 34250);
                    list = CallChecker.beforeCalled(list, List.class, 817, 34198, 34201);
                    return CallChecker.isCalled(list, List.class, 817, 34198, 34201).toArray(((E[]) (Array.newInstance(arrayClass, CallChecker.isCalled(list, List.class, 817, 34247, 34250).size()))));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((E[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1891.methodEnd();
        }
    }

    public static <E> List<E> toList(Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context1892 = new MethodContext(List.class);
        try {
            CallChecker.varInit(iterator, "iterator", 830, 34273, 34748);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 830, 34273, 34748);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 830, 34273, 34748);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 830, 34273, 34748);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 830, 34273, 34748);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 830, 34273, 34748);
            return IteratorUtils.toList(iterator, 10);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1892.methodEnd();
        }
    }

    public static <E> List<E> toList(Iterator<? extends E> iterator, int estimatedSize) {
        MethodContext _bcornu_methode_context1893 = new MethodContext(List.class);
        try {
            CallChecker.varInit(estimatedSize, "estimatedSize", 846, 34755, 35752);
            CallChecker.varInit(iterator, "iterator", 846, 34755, 35752);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 846, 34755, 35752);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 846, 34755, 35752);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 846, 34755, 35752);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 846, 34755, 35752);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 846, 34755, 35752);
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (estimatedSize < 1) {
                throw new IllegalArgumentException("Estimated size must be greater than 0");
            }
            List<E> list = CallChecker.varInit(new ArrayList<E>(estimatedSize), "list", 853, 35593, 35639);
            while (iterator.hasNext()) {
                if (CallChecker.beforeDeref(list, List.class, 855, 35690, 35693)) {
                    list = CallChecker.beforeCalled(list, List.class, 855, 35690, 35693);
                    CallChecker.isCalled(list, List.class, 855, 35690, 35693).add(iterator.next());
                }
            } 
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1893.methodEnd();
        }
    }

    public static Iterator<?> getIterator(Object obj) {
        MethodContext _bcornu_methode_context1894 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(obj, "obj", 879, 35759, 37822);
            CallChecker.varInit(EMPTY_ORDERED_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR", 879, 35759, 37822);
            CallChecker.varInit(EMPTY_MAP_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_MAP_ITERATOR", 879, 35759, 37822);
            CallChecker.varInit(EMPTY_ORDERED_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ORDERED_ITERATOR", 879, 35759, 37822);
            CallChecker.varInit(EMPTY_LIST_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_LIST_ITERATOR", 879, 35759, 37822);
            CallChecker.varInit(EMPTY_ITERATOR, "org.apache.commons.collections.IteratorUtils.EMPTY_ITERATOR", 879, 35759, 37822);
            if (obj == null) {
                return IteratorUtils.emptyIterator();
            }
            if (obj instanceof Iterator) {
                return ((Iterator<?>) (obj));
            }
            if (obj instanceof Collection) {
                return ((Collection<?>) (obj)).iterator();
            }
            if (obj instanceof Object[]) {
                return new ObjectArrayIterator<Object>(((Object[]) (obj)));
            }
            if (obj instanceof Enumeration) {
                return new EnumerationIterator<Object>(((Enumeration<?>) (obj)));
            }
            if (obj instanceof Map) {
                obj = CallChecker.beforeCalled(obj, Map.class, 896, 37088, 37090);
                if (CallChecker.beforeDeref(CallChecker.isCalled(((Map<?, ?>) (obj)), Map.class, 896, 37088, 37090).values(), Collection.class, 896, 37075, 37100)) {
                    return CallChecker.isCalled(((Map<?, ?>) (obj)).values(), Collection.class, 896, 37075, 37100).iterator();
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (obj instanceof Dictionary) {
                return new EnumerationIterator<Object>(((Dictionary<?, ?>) (obj)).elements());
            }else {
                obj = CallChecker.beforeCalled(obj, Object.class, 900, 37273, 37275);
                if (CallChecker.beforeDeref(CallChecker.isCalled(obj, Object.class, 900, 37273, 37275).getClass(), Class.class, 900, 37273, 37286)) {
                    if (CallChecker.isCalled(obj.getClass(), Class.class, 900, 37273, 37286).isArray()) {
                        return new ArrayIterator<Object>(obj);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            TryContext _bcornu_try_context_20 = new TryContext(20, IteratorUtils.class, "java.lang.Exception");
            try {
                Method method = CallChecker.init(Method.class);
                obj = CallChecker.beforeCalled(obj, Object.class, 904, 37404, 37406);
                if (CallChecker.beforeDeref(CallChecker.isCalled(obj, Object.class, 904, 37404, 37406).getClass(), Class.class, 904, 37404, 37417)) {
                    method = CallChecker.isCalled(obj.getClass(), Class.class, 904, 37404, 37417).getMethod("iterator", ((Class[]) (null)));
                    CallChecker.varAssign(method, "method", 904, 37404, 37417);
                }
                if (CallChecker.beforeDeref(method, Method.class, 905, 37506, 37511)) {
                    method = CallChecker.beforeCalled(method, Method.class, 905, 37506, 37511);
                    if (Iterator.class.isAssignableFrom(CallChecker.isCalled(method, Method.class, 905, 37506, 37511).getReturnType())) {
                        Iterator<?> it = CallChecker.init(Iterator.class);
                        if (CallChecker.beforeDeref(method, Method.class, 906, 37580, 37585)) {
                            method = CallChecker.beforeCalled(method, Method.class, 906, 37580, 37585);
                            it = ((Iterator<?>) (CallChecker.isCalled(method, Method.class, 906, 37580, 37585).invoke(obj, ((Object[]) (null)))));
                            CallChecker.varAssign(it, "it", 906, 37580, 37585);
                        }
                        if (it != null) {
                            return it;
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_20.catchStart(20);
            } finally {
                _bcornu_try_context_20.finallyStart(20);
            }
            return IteratorUtils.singletonIterator(obj);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1894.methodEnd();
        }
    }
}

