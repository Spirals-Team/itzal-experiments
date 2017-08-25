package org.apache.commons.collections;

import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.collection.UnmodifiableBoundedCollection;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.commons.collections.collection.TransformedCollection;
import org.apache.commons.collections.collection.SynchronizedCollection;
import java.util.HashSet;
import java.util.HashMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Enumeration;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.collection.PredicatedCollection;
import java.util.Set;

public class CollectionUtils {
    private static class CardinalityHelper<O> {
        final Map<O, Integer> cardinalityA;

        final Map<O, Integer> cardinalityB;

        public CardinalityHelper(Iterable<? extends O> a, Iterable<? extends O> b) {
            MethodContext _bcornu_methode_context182 = new MethodContext(null);
            try {
                cardinalityA = CollectionUtils.<O>getCardinalityMap(a);
                CallChecker.varAssign(this.cardinalityA, "this.cardinalityA", 67, 2482, 2536);
                cardinalityB = CollectionUtils.<O>getCardinalityMap(b);
                CallChecker.varAssign(this.cardinalityB, "this.cardinalityB", 68, 2550, 2604);
            } finally {
                _bcornu_methode_context182.methodEnd();
            }
        }

        public final int max(Object obj) {
            MethodContext _bcornu_methode_context915 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 71, 2625, 2721);
                CallChecker.varInit(obj, "obj", 71, 2625, 2721);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 71, 2625, 2721);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 71, 2625, 2721);
                return Math.max(freqA(obj), freqB(obj));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context915.methodEnd();
            }
        }

        public final int min(Object obj) {
            MethodContext _bcornu_methode_context916 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 75, 2732, 2828);
                CallChecker.varInit(obj, "obj", 75, 2732, 2828);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 75, 2732, 2828);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 75, 2732, 2828);
                return Math.min(freqA(obj), freqB(obj));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context916.methodEnd();
            }
        }

        public int freqA(Object obj) {
            MethodContext _bcornu_methode_context917 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 79, 2839, 2925);
                CallChecker.varInit(obj, "obj", 79, 2839, 2925);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 79, 2839, 2925);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 79, 2839, 2925);
                return getFreq(obj, cardinalityA);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context917.methodEnd();
            }
        }

        public int freqB(Object obj) {
            MethodContext _bcornu_methode_context918 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 83, 2936, 3022);
                CallChecker.varInit(obj, "obj", 83, 2936, 3022);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 83, 2936, 3022);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 83, 2936, 3022);
                return getFreq(obj, cardinalityB);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context918.methodEnd();
            }
        }

        private final int getFreq(final Object obj, final Map<?, Integer> freqMap) {
            MethodContext _bcornu_methode_context919 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 87, 3033, 3274);
                CallChecker.varInit(freqMap, "freqMap", 87, 3033, 3274);
                CallChecker.varInit(obj, "obj", 87, 3033, 3274);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 87, 3033, 3274);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 87, 3033, 3274);
                Integer count = CallChecker.init(Integer.class);
                if (CallChecker.beforeDeref(freqMap, Map.class, 88, 3138, 3144)) {
                    count = CallChecker.isCalled(freqMap, Map.class, 88, 3138, 3144).get(obj);
                    CallChecker.varAssign(count, "count", 88, 3138, 3144);
                }
                if (count != null) {
                    return count.intValue();
                }
                return 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context919.methodEnd();
            }
        }
    }

    private static class SetOperationCardinalityHelper<O> extends CollectionUtils.CardinalityHelper<O> implements Iterable<O> {
        private final Set<O> elements;

        private final List<O> newList;

        public SetOperationCardinalityHelper(Iterable<? extends O> a, Iterable<? extends O> b) {
            super(a, b);
            MethodContext _bcornu_methode_context183 = new MethodContext(null);
            try {
                elements = new HashSet<O>();
                CallChecker.varAssign(this.elements, "this.elements", 102, 3608, 3635);
                CollectionUtils.addAll(elements, a);
                CollectionUtils.addAll(elements, b);
                newList = new ArrayList<O>();
                CallChecker.varAssign(this.newList, "this.newList", 105, 3715, 3743);
            } finally {
                _bcornu_methode_context183.methodEnd();
            }
        }

        public Iterator<O> iterator() {
            MethodContext _bcornu_methode_context920 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 108, 3764, 3844);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 108, 3764, 3844);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 108, 3764, 3844);
                CallChecker.varInit(this.newList, "newList", 108, 3764, 3844);
                CallChecker.varInit(this.elements, "elements", 108, 3764, 3844);
                if (CallChecker.beforeDeref(elements, Set.class, 109, 3815, 3822)) {
                    return CallChecker.isCalled(elements, Set.class, 109, 3815, 3822).iterator();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<O>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context920.methodEnd();
            }
        }

        public void setCardinality(O obj, int count) {
            MethodContext _bcornu_methode_context921 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 112, 3855, 4004);
                CallChecker.varInit(count, "count", 112, 3855, 4004);
                CallChecker.varInit(obj, "obj", 112, 3855, 4004);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 112, 3855, 4004);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 112, 3855, 4004);
                CallChecker.varInit(this.newList, "newList", 112, 3855, 4004);
                CallChecker.varInit(this.elements, "elements", 112, 3855, 4004);
                for (int i = 0; i < count; i++) {
                    if (CallChecker.beforeDeref(newList, List.class, 114, 3964, 3970)) {
                        CallChecker.isCalled(newList, List.class, 114, 3964, 3970).add(obj);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context921.methodEnd();
            }
        }

        public Collection<O> list() {
            MethodContext _bcornu_methode_context922 = new MethodContext(Collection.class);
            try {
                CallChecker.varInit(this, "this", 118, 4015, 4081);
                CallChecker.varInit(this.cardinalityB, "cardinalityB", 118, 4015, 4081);
                CallChecker.varInit(this.cardinalityA, "cardinalityA", 118, 4015, 4081);
                CallChecker.varInit(this.newList, "newList", 118, 4015, 4081);
                CallChecker.varInit(this.elements, "elements", 118, 4015, 4081);
                return newList;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context922.methodEnd();
            }
        }
    }

    public static final Collection EMPTY_COLLECTION = UnmodifiableCollection.decorate(new ArrayList<Object>());

    public CollectionUtils() {
        MethodContext _bcornu_methode_context184 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context184.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Collection<T> emptyCollection() {
        MethodContext _bcornu_methode_context923 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 146, 4621, 4930);
            return CollectionUtils.EMPTY_COLLECTION;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context923.methodEnd();
        }
    }

    public static <O> Collection<O> union(final Iterable<? extends O> a, final Iterable<? extends O> b) {
        MethodContext _bcornu_methode_context924 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(b, "b", 165, 4937, 5898);
            CallChecker.varInit(a, "a", 165, 4937, 5898);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 165, 4937, 5898);
            CollectionUtils.SetOperationCardinalityHelper<O> helper = CallChecker.varInit(new CollectionUtils.SetOperationCardinalityHelper<O>(a, b), "helper", 166, 5680, 5764);
            if (CallChecker.beforeDeref(helper, Collection.class, 167, 5787, 5792)) {
                for (O obj : helper) {
                    if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 168, 5836, 5841)) {
                        if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 168, 5809, 5814)) {
                            helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 168, 5836, 5841);
                            helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 168, 5809, 5814);
                            CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 168, 5809, 5814).setCardinality(obj, CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 168, 5836, 5841).max(obj));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 170, 5879, 5884)) {
                helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 170, 5879, 5884);
                return CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 170, 5879, 5884).list();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context924.methodEnd();
        }
    }

    public static <O> Collection<O> intersection(final Iterable<? extends O> a, final Iterable<? extends O> b) {
        MethodContext _bcornu_methode_context925 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(b, "b", 189, 5905, 6915);
            CallChecker.varInit(a, "a", 189, 5905, 6915);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 189, 5905, 6915);
            CollectionUtils.SetOperationCardinalityHelper<O> helper = CallChecker.varInit(new CollectionUtils.SetOperationCardinalityHelper<O>(a, b), "helper", 190, 6697, 6781);
            if (CallChecker.beforeDeref(helper, Collection.class, 191, 6804, 6809)) {
                for (O obj : helper) {
                    if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 192, 6853, 6858)) {
                        if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 192, 6826, 6831)) {
                            helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 192, 6853, 6858);
                            helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 192, 6826, 6831);
                            CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 192, 6826, 6831).setCardinality(obj, CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 192, 6853, 6858).min(obj));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 194, 6896, 6901)) {
                helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 194, 6896, 6901);
                return CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 194, 6896, 6901).list();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context925.methodEnd();
        }
    }

    public static <O> Collection<O> disjunction(final Iterable<? extends O> a, final Iterable<? extends O> b) {
        MethodContext _bcornu_methode_context926 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(b, "b", 216, 6922, 8258);
            CallChecker.varInit(a, "a", 216, 6922, 8258);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 216, 6922, 8258);
            CollectionUtils.SetOperationCardinalityHelper<O> helper = CallChecker.varInit(new CollectionUtils.SetOperationCardinalityHelper<O>(a, b), "helper", 217, 8022, 8106);
            if (CallChecker.beforeDeref(helper, Collection.class, 218, 8129, 8134)) {
                for (O obj : helper) {
                    if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8178, 8183)) {
                        if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8196, 8201)) {
                            if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8151, 8156)) {
                                helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8178, 8183);
                                helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8196, 8201);
                                helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8151, 8156);
                                CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8151, 8156).setCardinality(obj, ((CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8178, 8183).max(obj)) - (CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 219, 8196, 8201).min(obj))));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(helper, CollectionUtils.SetOperationCardinalityHelper.class, 221, 8239, 8244)) {
                helper = CallChecker.beforeCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 221, 8239, 8244);
                return CallChecker.isCalled(helper, CollectionUtils.SetOperationCardinalityHelper.class, 221, 8239, 8244).list();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context926.methodEnd();
        }
    }

    public static <O> Collection<O> subtract(final Iterable<? extends O> a, final Iterable<? extends O> b) {
        MethodContext _bcornu_methode_context927 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(b, "b", 237, 8265, 9202);
            CallChecker.varInit(a, "a", 237, 8265, 9202);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 237, 8265, 9202);
            ArrayList<O> list = CallChecker.varInit(new ArrayList<O>(), "list", 238, 9038, 9076);
            CollectionUtils.addAll(list, a);
            if (CallChecker.beforeDeref(b, Collection.class, 240, 9128, 9128)) {
                for (O element : b) {
                    if (CallChecker.beforeDeref(list, ArrayList.class, 241, 9145, 9148)) {
                        list = CallChecker.beforeCalled(list, ArrayList.class, 241, 9145, 9148);
                        CallChecker.isCalled(list, ArrayList.class, 241, 9145, 9148).remove(element);
                    }
                }
            }
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context927.methodEnd();
        }
    }

    public static boolean containsAny(final Collection<?> coll1, final Collection<?> coll2) {
        MethodContext _bcornu_methode_context928 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(coll2, "coll2", 258, 9209, 10212);
            CallChecker.varInit(coll1, "coll1", 258, 9209, 10212);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 258, 9209, 10212);
            if (CallChecker.beforeDeref(coll1, Collection.class, 259, 9822, 9826)) {
                if (CallChecker.beforeDeref(coll2, Collection.class, 259, 9837, 9841)) {
                    if ((CallChecker.isCalled(coll1, Collection.class, 259, 9822, 9826).size()) < (CallChecker.isCalled(coll2, Collection.class, 259, 9837, 9841).size())) {
                        if (CallChecker.beforeDeref(coll1, boolean.class, 260, 9886, 9890)) {
                            for (Object aColl1 : coll1) {
                                if (CallChecker.beforeDeref(coll2, Collection.class, 261, 9915, 9919)) {
                                    if (CallChecker.isCalled(coll2, Collection.class, 261, 9915, 9919).contains(aColl1)) {
                                        return true;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(coll2, boolean.class, 266, 10056, 10060)) {
                            for (Object aColl2 : coll2) {
                                if (CallChecker.beforeDeref(coll1, Collection.class, 267, 10085, 10089)) {
                                    if (CallChecker.isCalled(coll1, Collection.class, 267, 10085, 10089).contains(aColl2)) {
                                        return true;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context928.methodEnd();
        }
    }

    public static <O> Map<O, Integer> getCardinalityMap(final Iterable<? extends O> coll) {
        MethodContext _bcornu_methode_context929 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(coll, "coll", 291, 10219, 11282);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 291, 10219, 11282);
            Map<O, Integer> count = CallChecker.varInit(new HashMap<O, Integer>(), "count", 292, 10943, 10992);
            if (CallChecker.beforeDeref(coll, Map.class, 293, 11015, 11018)) {
                for (O obj : coll) {
                    Integer c = CallChecker.init(Integer.class);
                    if (CallChecker.beforeDeref(count, Map.class, 294, 11047, 11051)) {
                        count = CallChecker.beforeCalled(count, Map.class, 294, 11047, 11051);
                        c = CallChecker.isCalled(count, Map.class, 294, 11047, 11051).get(obj);
                        CallChecker.varAssign(c, "c", 294, 11047, 11051);
                    }
                    if (c == null) {
                        if (CallChecker.beforeDeref(count, Map.class, 296, 11108, 11112)) {
                            count = CallChecker.beforeCalled(count, Map.class, 296, 11108, 11112);
                            CallChecker.isCalled(count, Map.class, 296, 11108, 11112).put(obj, Integer.valueOf(1));
                        }
                    }else {
                        if (CallChecker.beforeDeref(count, Map.class, 298, 11181, 11185)) {
                            count = CallChecker.beforeCalled(count, Map.class, 298, 11181, 11185);
                            CallChecker.isCalled(count, Map.class, 298, 11181, 11185).put(obj, Integer.valueOf(((c.intValue()) + 1)));
                        }
                    }
                }
            }
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<O, Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context929.methodEnd();
        }
    }

    public static boolean isSubCollection(final Collection<?> a, final Collection<?> b) {
        MethodContext _bcornu_methode_context930 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(b, "b", 316, 11289, 12174);
            CallChecker.varInit(a, "a", 316, 11289, 12174);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 316, 11289, 12174);
            CollectionUtils.CardinalityHelper<Object> helper = CallChecker.varInit(new CollectionUtils.CardinalityHelper<Object>(a, b), "helper", 317, 11935, 12005);
            if (CallChecker.beforeDeref(a, boolean.class, 318, 12033, 12033)) {
                for (Object obj : a) {
                    if (CallChecker.beforeDeref(helper, CollectionUtils.CardinalityHelper.class, 319, 12054, 12059)) {
                        if (CallChecker.beforeDeref(helper, CollectionUtils.CardinalityHelper.class, 319, 12074, 12079)) {
                            helper = CallChecker.beforeCalled(helper, CollectionUtils.CardinalityHelper.class, 319, 12054, 12059);
                            helper = CallChecker.beforeCalled(helper, CollectionUtils.CardinalityHelper.class, 319, 12074, 12079);
                            if ((CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 319, 12054, 12059).freqA(obj)) > (CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 319, 12074, 12079).freqB(obj))) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context930.methodEnd();
        }
    }

    public static boolean isProperSubCollection(final Collection<?> a, final Collection<?> b) {
        MethodContext _bcornu_methode_context931 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(b, "b", 347, 12181, 13377);
            CallChecker.varInit(a, "a", 347, 12181, 13377);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 347, 12181, 13377);
            return ((CallChecker.isCalled(a, Collection.class, 348, 13310, 13310).size()) < (CallChecker.isCalled(b, Collection.class, 348, 13321, 13321).size())) && (CollectionUtils.isSubCollection(a, b));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context931.methodEnd();
        }
    }

    public static boolean isEqualCollection(final Collection<?> a, final Collection<?> b) {
        MethodContext _bcornu_methode_context932 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(b, "b", 363, 13384, 14504);
            CallChecker.varInit(a, "a", 363, 13384, 14504);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 363, 13384, 14504);
            if (CallChecker.beforeDeref(a, Collection.class, 364, 14057, 14057)) {
                if (CallChecker.beforeDeref(b, Collection.class, 364, 14069, 14069)) {
                    if ((CallChecker.isCalled(a, Collection.class, 364, 14057, 14057).size()) != (CallChecker.isCalled(b, Collection.class, 364, 14069, 14069).size())) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final CollectionUtils.CardinalityHelper<Object> helper = CallChecker.varInit(new CollectionUtils.CardinalityHelper<Object>(a, b), "helper", 367, 14125, 14201);
            if (CallChecker.beforeDeref(helper, CollectionUtils.CardinalityHelper.class, 368, 14214, 14219)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 368, 14214, 14219).cardinalityA, Map.class, 368, 14214, 14232)) {
                    if (CallChecker.beforeDeref(helper, CollectionUtils.CardinalityHelper.class, 368, 14244, 14249)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 368, 14244, 14249).cardinalityB, Map.class, 368, 14244, 14262)) {
                            if ((CallChecker.isCalled(CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 368, 14214, 14219).cardinalityA, Map.class, 368, 14214, 14232).size()) != (CallChecker.isCalled(CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 368, 14244, 14249).cardinalityB, Map.class, 368, 14244, 14262).size())) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (Object obj : CallChecker.isCalled(CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 371, 14336, 14341).cardinalityA, Map.class, 371, 14336, 14354).keySet()) {
                if (CallChecker.beforeDeref(helper, CollectionUtils.CardinalityHelper.class, 372, 14383, 14388)) {
                    if (CallChecker.beforeDeref(helper, CollectionUtils.CardinalityHelper.class, 372, 14404, 14409)) {
                        if ((CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 372, 14383, 14388).freqA(obj)) != (CallChecker.isCalled(helper, CollectionUtils.CardinalityHelper.class, 372, 14404, 14409).freqB(obj))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context932.methodEnd();
        }
    }

    public static <O> int cardinality(O obj, final Iterable<? super O> coll) {
        MethodContext _bcornu_methode_context933 = new MethodContext(int.class);
        try {
            CallChecker.varInit(coll, "coll", 387, 14511, 15535);
            CallChecker.varInit(obj, "obj", 387, 14511, 15535);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 387, 14511, 15535);
            if (coll instanceof Set<?>) {
                if (CallChecker.beforeDeref(coll, Iterable.class, 389, 14998, 15001)) {
                    if (CallChecker.isCalled(((Set<? super O>) (coll)), Set.class, 389, 14998, 15001).contains(obj)) {
                        return 1;
                    }else {
                        return 0;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (coll instanceof Bag<?>) {
                if (CallChecker.beforeDeref(coll, Iterable.class, 392, 15113, 15116)) {
                    return CallChecker.isCalled(((Bag<? super O>) (coll)), Bag.class, 392, 15113, 15116).getCount(obj);
                }else
                    throw new AbnormalExecutionError();
                
            }
            int count = CallChecker.varInit(((int) (0)), "count", 394, 15152, 15165);
            if (obj == null) {
                if (CallChecker.beforeDeref(coll, int.class, 396, 15228, 15231)) {
                    for (Object element : coll) {
                        if (element == null) {
                            count++;
                        }
                    }
                }
            }else {
                if (CallChecker.beforeDeref(coll, int.class, 402, 15387, 15390)) {
                    for (Object element : coll) {
                        if (obj.equals(element)) {
                            count++;
                        }
                    }
                }
            }
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context933.methodEnd();
        }
    }

    public static <T> T find(Collection<T> collection, Predicate<? super T> predicate) {
        if ((collection != null) && (predicate != null)) {
            for (T item : collection) {
                if (predicate.evaluate(item)) {
                    return item;
                }
            }
        }
        return null;
    }

    public static <T, C extends Closure<? super T>> C forAllDo(Collection<T> collection, C closure) {
        if ((collection != null) && (closure != null)) {
            for (T element : collection) {
                closure.execute(element);
            }
        }
        return closure;
    }

    public static <T> void filter(Iterable<T> collection, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context936 = new MethodContext(void.class);
        try {
            CallChecker.varInit(predicate, "predicate", 463, 17033, 17805);
            CallChecker.varInit(collection, "collection", 463, 17033, 17805);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 463, 17033, 17805);
            if ((collection != null) && (predicate != null)) {
                for (Iterator<T> it = collection.iterator(); CallChecker.isCalled(it, Iterator.class, 465, 17655, 17656).hasNext();) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 466, 17712, 17713)) {
                        if (!(predicate.evaluate(it.next()))) {
                            if (CallChecker.beforeDeref(it, Iterator.class, 467, 17746, 17747)) {
                                CallChecker.isCalled(it, Iterator.class, 467, 17746, 17747).remove();
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context936.methodEnd();
        }
    }

    public static <C> void transform(Collection<C> collection, Transformer<? super C, ? extends C> transformer) {
        MethodContext _bcornu_methode_context937 = new MethodContext(void.class);
        try {
            CallChecker.varInit(transformer, "transformer", 491, 17812, 19266);
            CallChecker.varInit(collection, "collection", 491, 17812, 19266);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 491, 17812, 19266);
            if ((collection != null) && (transformer != null)) {
                if (collection instanceof List<?>) {
                    List<C> list = CallChecker.varInit(((List<C>) (collection)), "list", 495, 18848, 18883);
                    list = CallChecker.beforeCalled(list, List.class, 496, 18927, 18930);
                    for (ListIterator<C> it = CallChecker.isCalled(list, List.class, 496, 18927, 18930).listIterator(); CallChecker.isCalled(it, ListIterator.class, 496, 18948, 18949).hasNext();) {
                        if (CallChecker.beforeDeref(it, ListIterator.class, 497, 19014, 19015)) {
                            if (CallChecker.beforeDeref(it, ListIterator.class, 497, 18985, 18986)) {
                                CallChecker.isCalled(it, ListIterator.class, 497, 18985, 18986).set(transformer.transform(it.next()));
                            }
                        }
                    }
                }else {
                    Collection<C> resultCollection = CallChecker.varInit(CollectionUtils.collect(collection, transformer), "resultCollection", 500, 19082, 19147);
                    collection.clear();
                    collection.addAll(resultCollection);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context937.methodEnd();
        }
    }

    public static <C> int countMatches(Iterable<C> input, Predicate<? super C> predicate) {
        MethodContext _bcornu_methode_context938 = new MethodContext(int.class);
        try {
            CallChecker.varInit(predicate, "predicate", 519, 19273, 20051);
            CallChecker.varInit(input, "input", 519, 19273, 20051);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 519, 19273, 20051);
            int count = CallChecker.varInit(((int) (0)), "count", 520, 19812, 19825);
            if ((input != null) && (predicate != null)) {
                for (C o : input) {
                    if (predicate.evaluate(o)) {
                        count++;
                    }
                }
            }
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context938.methodEnd();
        }
    }

    public static <C> boolean exists(Iterable<C> input, Predicate<? super C> predicate) {
        MethodContext _bcornu_methode_context939 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(predicate, "predicate", 544, 20058, 20833);
            CallChecker.varInit(input, "input", 544, 20058, 20833);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 544, 20058, 20833);
            if ((input != null) && (predicate != null)) {
                for (C o : input) {
                    if (predicate.evaluate(o)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context939.methodEnd();
        }
    }

    public static <O> Collection<O> select(Collection<? extends O> inputCollection, Predicate<? super O> predicate) {
        MethodContext _bcornu_methode_context940 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(predicate, "predicate", 569, 20840, 21598);
            CallChecker.varInit(inputCollection, "inputCollection", 569, 20840, 21598);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 569, 20840, 21598);
            if (CallChecker.beforeDeref(inputCollection, Collection.class, 571, 21568, 21582)) {
                inputCollection = CallChecker.beforeCalled(inputCollection, Collection.class, 571, 21568, 21582);
                return CollectionUtils.select(inputCollection, predicate, new ArrayList<O>(CallChecker.isCalled(inputCollection, Collection.class, 571, 21568, 21582).size()));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context940.methodEnd();
        }
    }

    public static <O, R extends Collection<? super O>> R select(Collection<? extends O> inputCollection, Predicate<? super O> predicate, R outputCollection) {
        if ((inputCollection != null) && (predicate != null)) {
            for (O item : inputCollection) {
                if (predicate.evaluate(item)) {
                    if (CallChecker.beforeDeref(outputCollection, null, 594, 22510, 22525)) {
                        outputCollection.add(item);
                    }
                }
            }
        }
        return outputCollection;
    }

    public static <O> Collection<O> selectRejected(Collection<? extends O> inputCollection, Predicate<? super O> predicate) {
        MethodContext _bcornu_methode_context942 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(predicate, "predicate", 616, 22624, 23444);
            CallChecker.varInit(inputCollection, "inputCollection", 616, 22624, 23444);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 616, 22624, 23444);
            if (CallChecker.beforeDeref(inputCollection, Collection.class, 618, 23414, 23428)) {
                inputCollection = CallChecker.beforeCalled(inputCollection, Collection.class, 618, 23414, 23428);
                return CollectionUtils.selectRejected(inputCollection, predicate, new ArrayList<O>(CallChecker.isCalled(inputCollection, Collection.class, 618, 23414, 23428).size()));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context942.methodEnd();
        }
    }

    public static <O, R extends Collection<? super O>> R selectRejected(Collection<? extends O> inputCollection, Predicate<? super O> predicate, R outputCollection) {
        if ((inputCollection != null) && (predicate != null)) {
            for (O item : inputCollection) {
                if (!(predicate.evaluate(item))) {
                    if (CallChecker.beforeDeref(outputCollection, null, 641, 24381, 24396)) {
                        outputCollection.add(item);
                    }
                }
            }
        }
        return outputCollection;
    }

    public static <I, O> Collection<O> collect(Iterable<I> inputCollection, Transformer<? super I, ? extends O> transformer) {
        MethodContext _bcornu_methode_context944 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(transformer, "transformer", 664, 24495, 25430);
            CallChecker.varInit(inputCollection, "inputCollection", 664, 24495, 25430);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 664, 24495, 25430);
            ArrayList<O> answer = CallChecker.varInit(new ArrayList<O>(), "answer", 666, 25306, 25346);
            CollectionUtils.collect(inputCollection, transformer, answer);
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context944.methodEnd();
        }
    }

    public static <I, O> Collection<O> collect(Iterator<I> inputIterator, Transformer<? super I, ? extends O> transformer) {
        MethodContext _bcornu_methode_context945 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(transformer, "transformer", 686, 25437, 26296);
            CallChecker.varInit(inputIterator, "inputIterator", 686, 25437, 26296);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 686, 25437, 26296);
            ArrayList<O> answer = CallChecker.varInit(new ArrayList<O>(), "answer", 688, 26174, 26214);
            CollectionUtils.collect(inputIterator, transformer, answer);
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context945.methodEnd();
        }
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterable<? extends I> inputCollection, final Transformer<? super I, ? extends O> transformer, final R outputCollection) {
        if (inputCollection != null) {
            return CollectionUtils.collect(inputCollection.iterator(), transformer, outputCollection);
        }
        return outputCollection;
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterator<? extends I> inputIterator, final Transformer<? super I, ? extends O> transformer, final R outputCollection) {
        if ((inputIterator != null) && (transformer != null)) {
            while (inputIterator.hasNext()) {
                I item = CallChecker.varInit(inputIterator.next(), "item", 738, 28694, 28723);
                O value = CallChecker.varInit(transformer.transform(item), "value", 739, 28741, 28778);
                if (CallChecker.beforeDeref(outputCollection, null, 740, 28796, 28811)) {
                    outputCollection.add(value);
                }
            } 
        }
        return outputCollection;
    }

    public static <T> boolean addIgnoreNull(Collection<T> collection, T object) {
        MethodContext _bcornu_methode_context948 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(object, "object", 756, 28893, 29489);
            CallChecker.varInit(collection, "collection", 756, 28893, 29489);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 756, 28893, 29489);
            collection = CallChecker.beforeCalled(collection, Collection.class, 757, 29460, 29469);
            return (object != null) && (CallChecker.isCalled(collection, Collection.class, 757, 29460, 29469).add(object));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context948.methodEnd();
        }
    }

    public static <C> boolean addAll(Collection<C> collection, Iterable<? extends C> iterable) {
        MethodContext _bcornu_methode_context949 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(iterable, "iterable", 773, 29496, 30390);
            CallChecker.varInit(collection, "collection", 773, 29496, 30390);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 773, 29496, 30390);
            if (iterable instanceof Collection<?>) {
                if (CallChecker.beforeDeref(collection, Collection.class, 775, 30265, 30274)) {
                    collection = CallChecker.beforeCalled(collection, Collection.class, 775, 30265, 30274);
                    return CallChecker.isCalled(collection, Collection.class, 775, 30265, 30274).addAll(((Collection<? extends C>) (iterable)));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(iterable, Iterable.class, 777, 30364, 30371)) {
                iterable = CallChecker.beforeCalled(iterable, Iterable.class, 777, 30364, 30371);
                return CollectionUtils.addAll(collection, CallChecker.isCalled(iterable, Iterable.class, 777, 30364, 30371).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context949.methodEnd();
        }
    }

    public static <C> boolean addAll(Collection<C> collection, Iterator<? extends C> iterator) {
        MethodContext _bcornu_methode_context950 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(iterator, "iterator", 791, 30397, 31093);
            CallChecker.varInit(collection, "collection", 791, 30397, 31093);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 791, 30397, 31093);
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 792, 30937, 30960);
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 793, 30977, 30984);
            while (CallChecker.isCalled(iterator, Iterator.class, 793, 30977, 30984).hasNext()) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 794, 31037, 31044)) {
                    if (CallChecker.beforeDeref(collection, Collection.class, 794, 31022, 31031)) {
                        collection = CallChecker.beforeCalled(collection, Collection.class, 794, 31022, 31031);
                        changed |= CallChecker.isCalled(collection, Collection.class, 794, 31022, 31031).add(iterator.next());
                        CallChecker.varAssign(changed, "changed", 794, 31011, 31053);
                    }
                }
            } 
            return changed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context950.methodEnd();
        }
    }

    public static <C> boolean addAll(Collection<C> collection, Enumeration<? extends C> enumeration) {
        MethodContext _bcornu_methode_context951 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(enumeration, "enumeration", 806, 31100, 31702);
            CallChecker.varInit(collection, "collection", 806, 31100, 31702);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 806, 31100, 31702);
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 807, 31525, 31548);
            enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 808, 31565, 31575);
            while (CallChecker.isCalled(enumeration, Enumeration.class, 808, 31565, 31575).hasMoreElements()) {
                if (CallChecker.beforeDeref(enumeration, Enumeration.class, 809, 31636, 31646)) {
                    if (CallChecker.beforeDeref(collection, Collection.class, 809, 31621, 31630)) {
                        collection = CallChecker.beforeCalled(collection, Collection.class, 809, 31621, 31630);
                        changed |= CallChecker.isCalled(collection, Collection.class, 809, 31621, 31630).add(enumeration.nextElement());
                        CallChecker.varAssign(changed, "changed", 809, 31610, 31662);
                    }
                }
            } 
            return changed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context951.methodEnd();
        }
    }

    public static <C> boolean addAll(Collection<C> collection, C[] elements) {
        MethodContext _bcornu_methode_context952 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(elements, "elements", 824, 31709, 32322);
            CallChecker.varInit(collection, "collection", 824, 31709, 32322);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 824, 31709, 32322);
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 825, 32142, 32165);
            elements = CallChecker.beforeCalled(elements, null, 826, 32198, 32205);
            for (int i = 0, size = CallChecker.isCalled(elements, null, 826, 32198, 32205).length; i < size; i++) {
                if (CallChecker.beforeDeref(elements, null, 827, 32270, 32277)) {
                    if (CallChecker.beforeDeref(collection, Collection.class, 827, 32255, 32264)) {
                        collection = CallChecker.beforeCalled(collection, Collection.class, 827, 32255, 32264);
                        changed |= CallChecker.isCalled(collection, Collection.class, 827, 32255, 32264).add(elements[i]);
                        CallChecker.varAssign(changed, "changed", 827, 32244, 32282);
                    }
                }
            }
            return changed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context952.methodEnd();
        }
    }

    public static <T> T get(Iterator<T> iterator, int index) {
        int i = CallChecker.varInit(((int) (index)), "i", 847, 33096, 33109);
        CollectionUtils.checkIndexBounds(i);
        iterator = CallChecker.beforeCalled(iterator, Iterator.class, 849, 33159, 33166);
        while (CallChecker.isCalled(iterator, Iterator.class, 849, 33159, 33166).hasNext()) {
            i--;
            if (i == (-1)) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 852, 33260, 33267)) {
                    return iterator.next();
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(iterator, Iterator.class, 854, 33311, 33318)) {
                iterator.next();
            }
        } 
        throw new IndexOutOfBoundsException(("Entry does not exist: " + i));
    }

    private static void checkIndexBounds(int index) {
        MethodContext _bcornu_methode_context954 = new MethodContext(void.class);
        try {
            CallChecker.varInit(index, "index", 864, 33432, 33772);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 864, 33432, 33772);
            if (index < 0) {
                throw new IndexOutOfBoundsException(("Index cannot be negative: " + index));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context954.methodEnd();
        }
    }

    public static <T> T get(Iterable<T> iterable, int index) {
        CollectionUtils.checkIndexBounds(index);
        if (iterable instanceof List<?>) {
            if (CallChecker.beforeDeref(iterable, Iterable.class, 885, 34527, 34534)) {
                return ((List<T>) (iterable)).get(index);
            }else
                throw new AbnormalExecutionError();
            
        }
        if (CallChecker.beforeDeref(iterable, Iterable.class, 887, 34578, 34585)) {
            iterable = CallChecker.beforeCalled(iterable, Iterable.class, 887, 34578, 34585);
            return CollectionUtils.get(CallChecker.isCalled(iterable, Iterable.class, 887, 34578, 34585).iterator(), index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public static Object get(Object object, int index) {
        MethodContext _bcornu_methode_context956 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(index, "index", 920, 34618, 38116);
            CallChecker.varInit(object, "object", 920, 34618, 38116);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 920, 34618, 38116);
            int i = CallChecker.varInit(((int) (index)), "i", 921, 36362, 36375);
            if (i < 0) {
                throw new IndexOutOfBoundsException(("Index cannot be negative: " + i));
            }
            if (object instanceof Map<?, ?>) {
                Map<?, ?> map = CallChecker.varInit(((Map<?, ?>) (object)), "map", 926, 36545, 36579);
                Iterator<?> iterator = CallChecker.init(Iterator.class);
                if (CallChecker.beforeDeref(map, Map.class, 927, 36616, 36618)) {
                    map = CallChecker.beforeCalled(map, Map.class, 927, 36616, 36618);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 927, 36616, 36618).entrySet(), Set.class, 927, 36616, 36629)) {
                        map = CallChecker.beforeCalled(map, Map.class, 927, 36616, 36618);
                        iterator = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 927, 36616, 36618).entrySet(), Set.class, 927, 36616, 36629).iterator();
                        CallChecker.varAssign(iterator, "iterator", 927, 36616, 36618);
                    }
                }
                return CollectionUtils.get(iterator, i);
            }else
                if (object instanceof Object[]) {
                    if (CallChecker.beforeDeref(object, Object.class, 930, 36760, 36765)) {
                        object = CallChecker.beforeCalled(object, Object[].class, 930, 36760, 36765);
                        return CallChecker.isCalled(((Object[]) (object)), Object[].class, 930, 36760, 36765)[i];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (object instanceof Iterator<?>) {
                        Iterator<?> it = CallChecker.varInit(((Iterator<?>) (object)), "it", 932, 36836, 36873);
                        it = CallChecker.beforeCalled(it, Iterator.class, 933, 36894, 36895);
                        while (CallChecker.isCalled(it, Iterator.class, 933, 36894, 36895).hasNext()) {
                            i--;
                            if (i == (-1)) {
                                if (CallChecker.beforeDeref(it, Iterator.class, 936, 36989, 36990)) {
                                    return it.next();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            if (CallChecker.beforeDeref(it, Iterator.class, 938, 37034, 37035)) {
                                it.next();
                            }
                        } 
                        throw new IndexOutOfBoundsException(("Entry does not exist: " + i));
                    }else
                        if (object instanceof Collection<?>) {
                            Iterator<?> iterator = CallChecker.init(Iterator.class);
                            if (CallChecker.beforeDeref(object, Object.class, 942, 37244, 37249)) {
                                object = CallChecker.beforeCalled(object, Collection.class, 942, 37244, 37249);
                                iterator = CallChecker.isCalled(((Collection<?>) (object)), Collection.class, 942, 37244, 37249).iterator();
                                CallChecker.varAssign(iterator, "iterator", 942, 37244, 37249);
                            }
                            return CollectionUtils.get(iterator, i);
                        }else
                            if (object instanceof Enumeration<?>) {
                                Enumeration<?> it = CallChecker.varInit(((Enumeration<?>) (object)), "it", 945, 37368, 37411);
                                it = CallChecker.beforeCalled(it, Enumeration.class, 946, 37432, 37433);
                                while (CallChecker.isCalled(it, Enumeration.class, 946, 37432, 37433).hasMoreElements()) {
                                    i--;
                                    if (i == (-1)) {
                                        if (CallChecker.beforeDeref(it, Enumeration.class, 949, 37535, 37536)) {
                                            return it.nextElement();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else {
                                        if (CallChecker.beforeDeref(it, Enumeration.class, 951, 37598, 37599)) {
                                            it.nextElement();
                                        }
                                    }
                                } 
                                throw new IndexOutOfBoundsException(("Entry does not exist: " + i));
                            }else
                                if (object == null) {
                                    throw new IllegalArgumentException("Unsupported object type: null");
                                }else {
                                    TryContext _bcornu_try_context_9 = new TryContext(9, CollectionUtils.class, "java.lang.IllegalArgumentException");
                                    try {
                                        return java.lang.reflect.Array.get(object, i);
                                    } catch (IllegalArgumentException ex) {
                                        _bcornu_try_context_9.catchStart(9);
                                        object = CallChecker.beforeCalled(object, Object.class, 961, 38058, 38063);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 961, 38058, 38063).getClass(), Class.class, 961, 38058, 38074)) {
                                            throw new IllegalArgumentException(("Unsupported object type: " + (CallChecker.isCalled(object.getClass(), Class.class, 961, 38058, 38074).getName())));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    } finally {
                                        _bcornu_try_context_9.finallyStart(9);
                                    }
                                }
                            
                        
                    
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context956.methodEnd();
        }
    }

    public static <K, V> Map.Entry<K, V> get(Map<K, V> map, int index) {
        MethodContext _bcornu_methode_context957 = new MethodContext(Map.Entry.class);
        try {
            CallChecker.varInit(index, "index", 975, 38123, 38692);
            CallChecker.varInit(map, "map", 975, 38123, 38692);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 975, 38123, 38692);
            CollectionUtils.checkIndexBounds(index);
            if (CallChecker.beforeDeref(map, Map.class, 977, 38664, 38666)) {
                map = CallChecker.beforeCalled(map, Map.class, 977, 38664, 38666);
                return CollectionUtils.get(CallChecker.isCalled(map, Map.class, 977, 38664, 38666).entrySet(), index);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context957.methodEnd();
        }
    }

    public static int size(Object object) {
        MethodContext _bcornu_methode_context958 = new MethodContext(int.class);
        try {
            CallChecker.varInit(object, "object", 997, 38699, 40530);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 997, 38699, 40530);
            if (object == null) {
                return 0;
            }
            int total = CallChecker.varInit(((int) (0)), "total", 1001, 39491, 39504);
            if (object instanceof Map<?, ?>) {
                total = ((Map<?, ?>) (object)).size();
                CallChecker.varAssign(total, "total", 1003, 39560, 39595);
            }else
                if (object instanceof Collection<?>) {
                    total = ((Collection<?>) (object)).size();
                    CallChecker.varAssign(total, "total", 1005, 39663, 39702);
                }else
                    if (object instanceof Object[]) {
                        total = ((Object[]) (object)).length;
                        CallChecker.varAssign(total, "total", 1007, 39765, 39799);
                    }else
                        if (object instanceof Iterator<?>) {
                            Iterator<?> it = CallChecker.varInit(((Iterator<?>) (object)), "it", 1009, 39865, 39902);
                            it = CallChecker.beforeCalled(it, Iterator.class, 1010, 39923, 39924);
                            while (CallChecker.isCalled(it, Iterator.class, 1010, 39923, 39924).hasNext()) {
                                total++;
                                if (CallChecker.beforeDeref(it, Iterator.class, 1012, 39980, 39981)) {
                                    it.next();
                                }
                            } 
                        }else
                            if (object instanceof Enumeration<?>) {
                                Enumeration<?> it = CallChecker.varInit(((Enumeration<?>) (object)), "it", 1015, 40072, 40115);
                                it = CallChecker.beforeCalled(it, Enumeration.class, 1016, 40136, 40137);
                                while (CallChecker.isCalled(it, Enumeration.class, 1016, 40136, 40137).hasMoreElements()) {
                                    total++;
                                    if (CallChecker.beforeDeref(it, Enumeration.class, 1018, 40201, 40202)) {
                                        it.nextElement();
                                    }
                                } 
                            }else {
                                TryContext _bcornu_try_context_10 = new TryContext(10, CollectionUtils.class, "java.lang.IllegalArgumentException");
                                try {
                                    total = java.lang.reflect.Array.getLength(object);
                                    CallChecker.varAssign(total, "total", 1022, 40284, 40315);
                                } catch (IllegalArgumentException ex) {
                                    _bcornu_try_context_10.catchStart(10);
                                    object = CallChecker.beforeCalled(object, Object.class, 1024, 40450, 40455);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 1024, 40450, 40455).getClass(), Class.class, 1024, 40450, 40466)) {
                                        throw new IllegalArgumentException(("Unsupported object type: " + (CallChecker.isCalled(object.getClass(), Class.class, 1024, 40450, 40466).getName())));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                } finally {
                                    _bcornu_try_context_10.finallyStart(10);
                                }
                            }
                        
                    
                
            
            return total;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context958.methodEnd();
        }
    }

    public static boolean sizeIsEmpty(Object object) {
        MethodContext _bcornu_methode_context959 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(object, "object", 1050, 40537, 42166);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1050, 40537, 42166);
            if (object == null) {
                return true;
            }else
                if (object instanceof Collection<?>) {
                    return ((Collection<?>) (object)).isEmpty();
                }else
                    if (object instanceof Map<?, ?>) {
                        return ((Map<?, ?>) (object)).isEmpty();
                    }else
                        if (object instanceof Object[]) {
                            return (((Object[]) (object)).length) == 0;
                        }else
                            if (object instanceof Iterator<?>) {
                                return (((Iterator<?>) (object)).hasNext()) == false;
                            }else
                                if (object instanceof Enumeration<?>) {
                                    return (((Enumeration<?>) (object)).hasMoreElements()) == false;
                                }else {
                                    TryContext _bcornu_try_context_11 = new TryContext(11, CollectionUtils.class, "java.lang.IllegalArgumentException");
                                    try {
                                        return (java.lang.reflect.Array.getLength(object)) == 0;
                                    } catch (IllegalArgumentException ex) {
                                        _bcornu_try_context_11.catchStart(11);
                                        object = CallChecker.beforeCalled(object, Object.class, 1067, 42108, 42113);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 1067, 42108, 42113).getClass(), Class.class, 1067, 42108, 42124)) {
                                            throw new IllegalArgumentException(("Unsupported object type: " + (CallChecker.isCalled(object.getClass(), Class.class, 1067, 42108, 42124).getName())));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    } finally {
                                        _bcornu_try_context_11.finallyStart(11);
                                    }
                                }
                            
                        
                    
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context959.methodEnd();
        }
    }

    public static boolean isEmpty(Collection<?> coll) {
        MethodContext _bcornu_methode_context960 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(coll, "coll", 1082, 42173, 42609);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1082, 42173, 42609);
            coll = CallChecker.beforeCalled(coll, Collection.class, 1083, 42588, 42591);
            return (coll == null) || (CallChecker.isCalled(coll, Collection.class, 1083, 42588, 42591).isEmpty());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context960.methodEnd();
        }
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        MethodContext _bcornu_methode_context961 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(coll, "coll", 1095, 42616, 42973);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1095, 42616, 42973);
            return !(CollectionUtils.isEmpty(coll));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context961.methodEnd();
        }
    }

    public static void reverseArray(Object[] array) {
        MethodContext _bcornu_methode_context962 = new MethodContext(void.class);
        try {
            CallChecker.varInit(array, "array", 1105, 42980, 43454);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1105, 42980, 43454);
            int i = CallChecker.varInit(((int) (0)), "i", 1106, 43227, 43236);
            int j = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(array, Object[].class, 1107, 43254, 43258)) {
                array = CallChecker.beforeCalled(array, Object[].class, 1107, 43254, 43258);
                j = (CallChecker.isCalled(array, Object[].class, 1107, 43254, 43258).length) - 1;
                CallChecker.varAssign(j, "j", 1107, 43254, 43258);
            }
            Object tmp = CallChecker.init(Object.class);
            while (j > i) {
                if (CallChecker.beforeDeref(array, Object[].class, 1111, 43335, 43339)) {
                    array = CallChecker.beforeCalled(array, Object[].class, 1111, 43335, 43339);
                    tmp = CallChecker.isCalled(array, Object[].class, 1111, 43335, 43339)[j];
                    CallChecker.varAssign(tmp, "tmp", 1111, 43329, 43343);
                }
                if (CallChecker.beforeDeref(array, Object[].class, 1112, 43357, 43361)) {
                    if (CallChecker.beforeDeref(array, Object[].class, 1112, 43368, 43372)) {
                        array = CallChecker.beforeCalled(array, Object[].class, 1112, 43357, 43361);
                        array = CallChecker.beforeCalled(array, Object[].class, 1112, 43368, 43372);
                        CallChecker.isCalled(array, Object[].class, 1112, 43357, 43361)[j] = CallChecker.isCalled(array, Object[].class, 1112, 43368, 43372)[i];
                        CallChecker.varAssign(CallChecker.isCalled(array, Object[].class, 1112, 43357, 43361)[j], "CallChecker.isCalled(array, Object[].class, 1112, 43357, 43361)[j]", 1112, 43357, 43376);
                    }
                }
                if (CallChecker.beforeDeref(array, Object[].class, 1113, 43390, 43394)) {
                    array = CallChecker.beforeCalled(array, Object[].class, 1113, 43390, 43394);
                    CallChecker.isCalled(array, Object[].class, 1113, 43390, 43394)[i] = tmp;
                    CallChecker.varAssign(CallChecker.isCalled(array, Object[].class, 1113, 43390, 43394)[i], "CallChecker.isCalled(array, Object[].class, 1113, 43390, 43394)[i]", 1113, 43390, 43404);
                }
                j--;
                i++;
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context962.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static boolean isFull(Collection<?> coll) {
        MethodContext _bcornu_methode_context963 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(coll, "coll", 1135, 43461, 44709);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1135, 43461, 44709);
            if (coll == null) {
                throw new NullPointerException("The collection must not be null");
            }
            if (coll instanceof BoundedCollection) {
                return ((BoundedCollection<?>) (coll)).isFull();
            }
            TryContext _bcornu_try_context_12 = new TryContext(12, CollectionUtils.class, "java.lang.IllegalArgumentException");
            try {
                BoundedCollection<?> bcoll = CallChecker.varInit(UnmodifiableBoundedCollection.decorateUsing(((Collection<Object>) (coll))), "bcoll", 1143, 44485, 44584);
                if (CallChecker.beforeDeref(bcoll, BoundedCollection.class, 1144, 44605, 44609)) {
                    bcoll = CallChecker.beforeCalled(bcoll, BoundedCollection.class, 1144, 44605, 44609);
                    return CallChecker.isCalled(bcoll, BoundedCollection.class, 1144, 44605, 44609).isFull();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (IllegalArgumentException ex) {
                _bcornu_try_context_12.catchStart(12);
                return false;
            } finally {
                _bcornu_try_context_12.finallyStart(12);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context963.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static int maxSize(Collection<?> coll) {
        MethodContext _bcornu_methode_context964 = new MethodContext(int.class);
        try {
            CallChecker.varInit(coll, "coll", 1166, 44716, 45988);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1166, 44716, 45988);
            if (coll == null) {
                throw new NullPointerException("The collection must not be null");
            }
            if (coll instanceof BoundedCollection) {
                return ((BoundedCollection<?>) (coll)).maxSize();
            }
            TryContext _bcornu_try_context_13 = new TryContext(13, CollectionUtils.class, "java.lang.IllegalArgumentException");
            try {
                BoundedCollection<?> bcoll = CallChecker.varInit(UnmodifiableBoundedCollection.decorateUsing(((Collection<Object>) (coll))), "bcoll", 1174, 45766, 45865);
                if (CallChecker.beforeDeref(bcoll, BoundedCollection.class, 1175, 45886, 45890)) {
                    bcoll = CallChecker.beforeCalled(bcoll, BoundedCollection.class, 1175, 45886, 45890);
                    return CallChecker.isCalled(bcoll, BoundedCollection.class, 1175, 45886, 45890).maxSize();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (IllegalArgumentException ex) {
                _bcornu_try_context_13.catchStart(13);
                return -1;
            } finally {
                _bcornu_try_context_13.finallyStart(13);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context964.methodEnd();
        }
    }

    public static <C> Collection<C> retainAll(Collection<C> collection, Collection<?> retain) {
        MethodContext _bcornu_methode_context965 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(retain, "retain", 1197, 45995, 47244);
            CallChecker.varInit(collection, "collection", 1197, 45995, 47244);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1197, 45995, 47244);
            return ListUtils.retainAll(collection, retain);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<C>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context965.methodEnd();
        }
    }

    public static <E> Collection<E> removeAll(Collection<E> collection, Collection<?> remove) {
        MethodContext _bcornu_methode_context966 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(remove, "remove", 1217, 47251, 48561);
            CallChecker.varInit(collection, "collection", 1217, 47251, 48561);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1217, 47251, 48561);
            return ListUtils.removeAll(collection, remove);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context966.methodEnd();
        }
    }

    public static <C> Collection<C> synchronizedCollection(Collection<C> collection) {
        MethodContext _bcornu_methode_context967 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(collection, "collection", 1244, 48568, 49572);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1244, 48568, 49572);
            return SynchronizedCollection.decorate(collection);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<C>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context967.methodEnd();
        }
    }

    public static <C> Collection<C> unmodifiableCollection(Collection<C> collection) {
        MethodContext _bcornu_methode_context968 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(collection, "collection", 1257, 49579, 50127);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1257, 49579, 50127);
            return UnmodifiableCollection.decorate(collection);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<C>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context968.methodEnd();
        }
    }

    public static <C> Collection<C> predicatedCollection(Collection<C> collection, Predicate<? super C> predicate) {
        MethodContext _bcornu_methode_context969 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(predicate, "predicate", 1275, 50134, 51094);
            CallChecker.varInit(collection, "collection", 1275, 50134, 51094);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1275, 50134, 51094);
            return PredicatedCollection.decorate(collection, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<C>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context969.methodEnd();
        }
    }

    public static <E> Collection<E> transformedCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context970 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(transformer, "transformer", 1294, 51101, 52122);
            CallChecker.varInit(collection, "collection", 1294, 51101, 52122);
            CallChecker.varInit(EMPTY_COLLECTION, "org.apache.commons.collections.CollectionUtils.EMPTY_COLLECTION", 1294, 51101, 52122);
            return TransformedCollection.decorate(collection, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context970.methodEnd();
        }
    }

    public static <E> E extractSingleton(Collection<E> collection) {
        if ((collection == null) || ((collection.size()) != 1)) {
            throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
        }
        collection = CallChecker.beforeCalled(collection, Collection.class, 1309, 52670, 52679);
        if (CallChecker.beforeDeref(CallChecker.isCalled(collection, Collection.class, 1309, 52670, 52679).iterator(), Iterator.class, 1309, 52670, 52690)) {
            return collection.iterator().next();
        }else
            throw new AbnormalExecutionError();
        
    }
}

