package org.apache.commons.collections;

import org.apache.commons.collections.list.UnmodifiableList;
import org.apache.commons.collections.list.TransformedList;
import org.apache.commons.collections.list.SynchronizedList;
import org.apache.commons.collections.list.PredicatedList;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.List;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Collections;
import org.apache.commons.collections.list.FixedSizeList;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.collections.list.LazyList;

public class ListUtils {
    public static final List<Object> EMPTY_LIST = Collections.<Object>emptyList();

    public ListUtils() {
        MethodContext _bcornu_methode_context106 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context106.methodEnd();
        }
    }

    public static <E> List<E> intersection(final List<? extends E> list1, final List<? extends E> list2) {
        MethodContext _bcornu_methode_context581 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list2, "list2", 72, 2139, 3120);
            CallChecker.varInit(list1, "list1", 72, 2139, 3120);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 72, 2139, 3120);
            final List<E> result = CallChecker.varInit(new ArrayList<E>(), "result", 73, 2632, 2673);
            List<? extends E> smaller = CallChecker.varInit(list1, "smaller", 75, 2684, 2717);
            List<? extends E> larger = CallChecker.varInit(list2, "larger", 76, 2727, 2759);
            if (CallChecker.beforeDeref(list1, List.class, 77, 2773, 2777)) {
                if (CallChecker.beforeDeref(list2, List.class, 77, 2788, 2792)) {
                    if ((CallChecker.isCalled(list1, List.class, 77, 2773, 2777).size()) > (CallChecker.isCalled(list2, List.class, 77, 2788, 2792).size())) {
                        smaller = list2;
                        CallChecker.varAssign(smaller, "smaller", 78, 2816, 2831);
                        larger = list1;
                        CallChecker.varAssign(larger, "larger", 79, 2845, 2859);
                    }
                }
            }
            HashSet<E> hashSet = CallChecker.varInit(new HashSet<E>(smaller), "hashSet", 82, 2888, 2932);
            if (CallChecker.beforeDeref(larger, List.class, 84, 2954, 2959)) {
                for (E e : larger) {
                    if (CallChecker.beforeDeref(hashSet, HashSet.class, 85, 2980, 2986)) {
                        hashSet = CallChecker.beforeCalled(hashSet, HashSet.class, 85, 2980, 2986);
                        if (CallChecker.isCalled(hashSet, HashSet.class, 85, 2980, 2986).contains(e)) {
                            if (CallChecker.beforeDeref(result, List.class, 86, 3019, 3024)) {
                                CallChecker.isCalled(result, List.class, 86, 3019, 3024).add(e);
                            }
                            if (CallChecker.beforeDeref(hashSet, HashSet.class, 87, 3050, 3056)) {
                                hashSet = CallChecker.beforeCalled(hashSet, HashSet.class, 87, 3050, 3056);
                                CallChecker.isCalled(hashSet, HashSet.class, 87, 3050, 3056).remove(e);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context581.methodEnd();
        }
    }

    public static <E> List<E> subtract(final List<E> list1, final List<? extends E> list2) {
        MethodContext _bcornu_methode_context582 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list2, "list2", 108, 3127, 4017);
            CallChecker.varInit(list1, "list1", 108, 3127, 4017);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 108, 3127, 4017);
            final ArrayList<E> result = CallChecker.varInit(new ArrayList<E>(list1), "result", 109, 3869, 3920);
            if (CallChecker.beforeDeref(list2, List.class, 110, 3941, 3945)) {
                for (E e : list2) {
                    if (CallChecker.beforeDeref(result, ArrayList.class, 111, 3962, 3967)) {
                        CallChecker.isCalled(result, ArrayList.class, 111, 3962, 3967).remove(e);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context582.methodEnd();
        }
    }

    public static <E> List<E> sum(final List<? extends E> list1, final List<? extends E> list2) {
        MethodContext _bcornu_methode_context583 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list2, "list2", 125, 4024, 4521);
            CallChecker.varInit(list1, "list1", 125, 4024, 4521);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 125, 4024, 4521);
            return ListUtils.subtract(ListUtils.union(list1, list2), ListUtils.intersection(list1, list2));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context583.methodEnd();
        }
    }

    public static <E> List<E> union(final List<? extends E> list1, final List<? extends E> list2) {
        MethodContext _bcornu_methode_context584 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list2, "list2", 139, 4528, 5158);
            CallChecker.varInit(list1, "list1", 139, 4528, 5158);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 139, 4528, 5158);
            final ArrayList<E> result = CallChecker.varInit(new ArrayList<E>(list1), "result", 140, 5048, 5099);
            if (CallChecker.beforeDeref(result, ArrayList.class, 141, 5109, 5114)) {
                CallChecker.isCalled(result, ArrayList.class, 141, 5109, 5114).addAll(list2);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context584.methodEnd();
        }
    }

    public static boolean isEqualList(final Collection<?> list1, final Collection<?> list2) {
        MethodContext _bcornu_methode_context585 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(list2, "list2", 174, 5165, 7311);
            CallChecker.varInit(list1, "list1", 174, 5165, 7311);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 174, 5165, 7311);
            if (list1 == list2) {
                return true;
            }
            if (((list1 == null) || (list2 == null)) || ((list1.size()) != (list2.size()))) {
                return false;
            }
            Iterator<?> it1 = CallChecker.varInit(list1.iterator(), "it1", 182, 6883, 6917);
            Iterator<?> it2 = CallChecker.varInit(list2.iterator(), "it2", 183, 6927, 6961);
            Object obj1 = CallChecker.varInit(null, "obj1", 184, 6971, 6989);
            Object obj2 = CallChecker.varInit(null, "obj2", 185, 6999, 7017);
            it1 = CallChecker.beforeCalled(it1, Iterator.class, 187, 7035, 7037);
            it2 = CallChecker.beforeCalled(it2, Iterator.class, 187, 7052, 7054);
            while ((CallChecker.isCalled(it1, Iterator.class, 187, 7035, 7037).hasNext()) && (CallChecker.isCalled(it2, Iterator.class, 187, 7052, 7054).hasNext())) {
                if (CallChecker.beforeDeref(it1, Iterator.class, 188, 7088, 7090)) {
                    obj1 = it1.next();
                    CallChecker.varAssign(obj1, "obj1", 188, 7081, 7098);
                }
                if (CallChecker.beforeDeref(it2, Iterator.class, 189, 7119, 7121)) {
                    obj2 = it2.next();
                    CallChecker.varAssign(obj2, "obj2", 189, 7112, 7129);
                }
                if (!(obj1 == null ? obj2 == null : obj1.equals(obj2))) {
                    return false;
                }
            } 
            it1 = CallChecker.beforeCalled(it1, Iterator.class, 196, 7274, 7276);
            it2 = CallChecker.beforeCalled(it2, Iterator.class, 196, 7291, 7293);
            return !((CallChecker.isCalled(it1, Iterator.class, 196, 7274, 7276).hasNext()) || (CallChecker.isCalled(it2, Iterator.class, 196, 7291, 7293).hasNext()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context585.methodEnd();
        }
    }

    public static <E> int hashCodeForList(final Collection<E> list) {
        MethodContext _bcornu_methode_context586 = new MethodContext(int.class);
        try {
            CallChecker.varInit(list, "list", 211, 7322, 8207);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 211, 7322, 8207);
            if (list == null) {
                return 0;
            }
            int hashCode = CallChecker.varInit(((int) (1)), "hashCode", 215, 7962, 7978);
            Iterator<E> it = CallChecker.varInit(list.iterator(), "it", 216, 7988, 8020);
            it = CallChecker.beforeCalled(it, Iterator.class, 218, 8046, 8047);
            while (CallChecker.isCalled(it, Iterator.class, 218, 8046, 8047).hasNext()) {
                E obj = CallChecker.init(null);
                if (CallChecker.beforeDeref(it, Iterator.class, 219, 8082, 8083)) {
                    obj = it.next();
                    CallChecker.varAssign(obj, "obj", 219, 8082, 8083);
                }
                if (obj == null) {
                    hashCode = (31 * hashCode) + 0;
                    CallChecker.varAssign(hashCode, "hashCode", 220, 8105, 8166);
                }else {
                    hashCode = (31 * hashCode) + (obj.hashCode());
                    CallChecker.varAssign(hashCode, "hashCode", 220, 8105, 8166);
                }
            } 
            return hashCode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context586.methodEnd();
        }
    }

    public static <E> List<E> retainAll(Collection<E> collection, Collection<?> retain) {
        MethodContext _bcornu_methode_context587 = new MethodContext(List.class);
        try {
            CallChecker.varInit(retain, "retain", 241, 8217, 9624);
            CallChecker.varInit(collection, "collection", 241, 8217, 9624);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 241, 8217, 9624);
            List<E> list = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(collection, Collection.class, 242, 9432, 9441)) {
                if (CallChecker.beforeDeref(retain, Collection.class, 242, 9451, 9456)) {
                    collection = CallChecker.beforeCalled(collection, Collection.class, 242, 9432, 9441);
                    retain = CallChecker.beforeCalled(retain, Collection.class, 242, 9451, 9456);
                    list = new ArrayList<E>(Math.min(CallChecker.isCalled(collection, Collection.class, 242, 9432, 9441).size(), CallChecker.isCalled(retain, Collection.class, 242, 9451, 9456).size()));
                    CallChecker.varAssign(list, "list", 242, 9432, 9441);
                }
            }
            if (CallChecker.beforeDeref(collection, List.class, 244, 9490, 9499)) {
                for (E obj : collection) {
                    if (CallChecker.beforeDeref(retain, Collection.class, 245, 9520, 9525)) {
                        retain = CallChecker.beforeCalled(retain, Collection.class, 245, 9520, 9525);
                        if (CallChecker.isCalled(retain, Collection.class, 245, 9520, 9525).contains(obj)) {
                            if (CallChecker.beforeDeref(list, List.class, 246, 9560, 9563)) {
                                list = CallChecker.beforeCalled(list, List.class, 246, 9560, 9563);
                                CallChecker.isCalled(list, List.class, 246, 9560, 9563).add(obj);
                            }
                        }
                    }
                }
            }
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context587.methodEnd();
        }
    }

    public static <E> List<E> removeAll(Collection<E> collection, Collection<?> remove) {
        MethodContext _bcornu_methode_context588 = new MethodContext(List.class);
        try {
            CallChecker.varInit(remove, "remove", 268, 9631, 10998);
            CallChecker.varInit(collection, "collection", 268, 9631, 10998);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 268, 9631, 10998);
            List<E> list = CallChecker.varInit(new ArrayList<E>(), "list", 269, 10807, 10840);
            if (CallChecker.beforeDeref(collection, List.class, 270, 10863, 10872)) {
                for (E obj : collection) {
                    if (CallChecker.beforeDeref(remove, Collection.class, 271, 10894, 10899)) {
                        remove = CallChecker.beforeCalled(remove, Collection.class, 271, 10894, 10899);
                        if (!(CallChecker.isCalled(remove, Collection.class, 271, 10894, 10899).contains(obj))) {
                            if (CallChecker.beforeDeref(list, List.class, 272, 10934, 10937)) {
                                list = CallChecker.beforeCalled(list, List.class, 272, 10934, 10937);
                                CallChecker.isCalled(list, List.class, 272, 10934, 10937).add(obj);
                            }
                        }
                    }
                }
            }
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context588.methodEnd();
        }
    }

    public static <E> List<E> synchronizedList(List<E> list) {
        MethodContext _bcornu_methode_context589 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list, "list", 301, 11005, 11921);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 301, 11005, 11921);
            return SynchronizedList.decorate(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context589.methodEnd();
        }
    }

    public static <E> List<E> unmodifiableList(List<E> list) {
        MethodContext _bcornu_methode_context590 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list, "list", 314, 11928, 12398);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 314, 11928, 12398);
            return UnmodifiableList.decorate(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context590.methodEnd();
        }
    }

    public static <E> List<E> predicatedList(List<E> list, Predicate<E> predicate) {
        MethodContext _bcornu_methode_context591 = new MethodContext(List.class);
        try {
            CallChecker.varInit(predicate, "predicate", 331, 12405, 13217);
            CallChecker.varInit(list, "list", 331, 12405, 13217);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 331, 12405, 13217);
            return PredicatedList.decorate(list, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context591.methodEnd();
        }
    }

    public static <E> List<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context592 = new MethodContext(List.class);
        try {
            CallChecker.varInit(transformer, "transformer", 354, 13224, 14353);
            CallChecker.varInit(list, "list", 354, 13224, 14353);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 354, 13224, 14353);
            return TransformedList.decorate(list, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context592.methodEnd();
        }
    }

    public static <E> List<E> lazyList(List<E> list, Factory<? extends E> factory) {
        MethodContext _bcornu_methode_context593 = new MethodContext(List.class);
        try {
            CallChecker.varInit(factory, "factory", 387, 14364, 15682);
            CallChecker.varInit(list, "list", 387, 14364, 15682);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 387, 14364, 15682);
            return LazyList.decorate(list, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context593.methodEnd();
        }
    }

    public static <E> List<E> fixedSizeList(List<E> list) {
        MethodContext _bcornu_methode_context594 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list, "list", 401, 15689, 16238);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 401, 15689, 16238);
            return FixedSizeList.decorate(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context594.methodEnd();
        }
    }

    public static <E> int indexOf(List<E> list, Predicate<E> predicate) {
        MethodContext _bcornu_methode_context595 = new MethodContext(int.class);
        try {
            CallChecker.varInit(predicate, "predicate", 415, 16245, 17055);
            CallChecker.varInit(list, "list", 415, 16245, 17055);
            CallChecker.varInit(EMPTY_LIST, "org.apache.commons.collections.ListUtils.EMPTY_LIST", 415, 16245, 17055);
            if ((list != null) && (predicate != null)) {
                for (int i = 0; i < (list.size()); i++) {
                    E item = CallChecker.varInit(list.get(i), "item", 418, 16890, 16910);
                    if (predicate.evaluate(item)) {
                        return i;
                    }
                }
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context595.methodEnd();
        }
    }
}

