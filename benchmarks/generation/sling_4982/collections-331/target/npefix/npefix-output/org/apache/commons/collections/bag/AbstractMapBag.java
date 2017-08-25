package org.apache.commons.collections.bag;

import org.apache.commons.collections.set.UnmodifiableSet;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ConcurrentModificationException;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Bag;
import java.lang.reflect.Array;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

public abstract class AbstractMapBag<E> implements Bag<E> {
    private transient Map<E, AbstractMapBag.MutableInteger> map;

    private int size;

    private transient int modCount;

    private transient Set<E> uniqueSet;

    protected AbstractMapBag() {
        super();
        MethodContext _bcornu_methode_context468 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context468.methodEnd();
        }
    }

    protected AbstractMapBag(Map<E, AbstractMapBag.MutableInteger> map) {
        super();
        MethodContext _bcornu_methode_context469 = new MethodContext(null);
        try {
            this.map = map;
            CallChecker.varAssign(this.map, "this.map", 76, 2671, 2685);
        } finally {
            _bcornu_methode_context469.methodEnd();
        }
    }

    protected Map<E, AbstractMapBag.MutableInteger> getMap() {
        MethodContext _bcornu_methode_context2520 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 85, 2698, 2979);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 85, 2698, 2979);
            CallChecker.varInit(this.modCount, "modCount", 85, 2698, 2979);
            CallChecker.varInit(this.size, "size", 85, 2698, 2979);
            CallChecker.varInit(this.map, "map", 85, 2698, 2979);
            return map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<E, AbstractMapBag.MutableInteger>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2520.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context2521 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 95, 2986, 3223);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 95, 2986, 3223);
            CallChecker.varInit(this.modCount, "modCount", 95, 2986, 3223);
            CallChecker.varInit(this.size, "size", 95, 2986, 3223);
            CallChecker.varInit(this.map, "map", 95, 2986, 3223);
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2521.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context2522 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 104, 3230, 3403);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 104, 3230, 3403);
            CallChecker.varInit(this.modCount, "modCount", 104, 3230, 3403);
            CallChecker.varInit(this.size, "size", 104, 3230, 3403);
            CallChecker.varInit(this.map, "map", 104, 3230, 3403);
            if (CallChecker.beforeDeref(map, Map.class, 105, 3384, 3386)) {
                map = CallChecker.beforeCalled(map, Map.class, 105, 3384, 3386);
                return CallChecker.isCalled(map, Map.class, 105, 3384, 3386).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2522.methodEnd();
        }
    }

    public int getCount(Object object) {
        MethodContext _bcornu_methode_context2523 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 115, 3410, 3859);
            CallChecker.varInit(object, "object", 115, 3410, 3859);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 115, 3410, 3859);
            CallChecker.varInit(this.modCount, "modCount", 115, 3410, 3859);
            CallChecker.varInit(this.size, "size", 115, 3410, 3859);
            CallChecker.varInit(this.map, "map", 115, 3410, 3859);
            AbstractMapBag.MutableInteger count = CallChecker.init(AbstractMapBag.MutableInteger.class);
            if (CallChecker.beforeDeref(map, Map.class, 116, 3749, 3751)) {
                map = CallChecker.beforeCalled(map, Map.class, 116, 3749, 3751);
                count = CallChecker.isCalled(map, Map.class, 116, 3749, 3751).get(object);
                CallChecker.varAssign(count, "count", 116, 3749, 3751);
            }
            if (count != null) {
                return count.value;
            }
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2523.methodEnd();
        }
    }

    public boolean contains(Object object) {
        MethodContext _bcornu_methode_context2524 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 131, 3866, 4285);
            CallChecker.varInit(object, "object", 131, 3866, 4285);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 131, 3866, 4285);
            CallChecker.varInit(this.modCount, "modCount", 131, 3866, 4285);
            CallChecker.varInit(this.size, "size", 131, 3866, 4285);
            CallChecker.varInit(this.map, "map", 131, 3866, 4285);
            if (CallChecker.beforeDeref(map, Map.class, 132, 4256, 4258)) {
                map = CallChecker.beforeCalled(map, Map.class, 132, 4256, 4258);
                return CallChecker.isCalled(map, Map.class, 132, 4256, 4258).containsKey(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2524.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2525 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 141, 4292, 4697);
            CallChecker.varInit(coll, "coll", 141, 4292, 4697);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 141, 4292, 4697);
            CallChecker.varInit(this.modCount, "modCount", 141, 4292, 4697);
            CallChecker.varInit(this.size, "size", 141, 4292, 4697);
            CallChecker.varInit(this.map, "map", 141, 4292, 4697);
            if (coll instanceof Bag) {
                return containsAll(((Bag<?>) (coll)));
            }
            return containsAll(new HashBag<Object>(coll));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2525.methodEnd();
        }
    }

    boolean containsAll(Bag<?> other) {
        MethodContext _bcornu_methode_context2526 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 155, 4704, 5315);
            CallChecker.varInit(other, "other", 155, 4704, 5315);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 155, 4704, 5315);
            CallChecker.varInit(this.modCount, "modCount", 155, 4704, 5315);
            CallChecker.varInit(this.size, "size", 155, 4704, 5315);
            CallChecker.varInit(this.map, "map", 155, 4704, 5315);
            boolean result = CallChecker.varInit(((boolean) (true)), "result", 156, 5011, 5032);
            Iterator<?> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(other, Bag.class, 157, 5059, 5063)) {
                other = CallChecker.beforeCalled(other, Bag.class, 157, 5059, 5063);
                final Set<?> npe_invocation_var447 = CallChecker.isCalled(other, Bag.class, 157, 5059, 5063).uniqueSet();
                if (CallChecker.beforeDeref(npe_invocation_var447, Set.class, 157, 5059, 5075)) {
                    it = CallChecker.isCalled(npe_invocation_var447, Set.class, 157, 5059, 5075).iterator();
                    CallChecker.varAssign(it, "it", 157, 5059, 5063);
                }
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 158, 5104, 5105);
            while (CallChecker.isCalled(it, Iterator.class, 158, 5104, 5105).hasNext()) {
                Object current = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 159, 5149, 5150)) {
                    current = it.next();
                    CallChecker.varAssign(current, "current", 159, 5149, 5150);
                }
                boolean contains = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(other, Bag.class, 160, 5212, 5216)) {
                    other = CallChecker.beforeCalled(other, Bag.class, 160, 5212, 5216);
                    contains = (getCount(current)) >= (CallChecker.isCalled(other, Bag.class, 160, 5212, 5216).getCount(current));
                    CallChecker.varAssign(contains, "contains", 160, 5212, 5216);
                }
                result = result && contains;
                CallChecker.varAssign(result, "result", 161, 5249, 5276);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2526.methodEnd();
        }
    }

    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context2527 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 173, 5322, 5655);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 173, 5322, 5655);
            CallChecker.varInit(this.modCount, "modCount", 173, 5322, 5655);
            CallChecker.varInit(this.size, "size", 173, 5322, 5655);
            CallChecker.varInit(this.map, "map", 173, 5322, 5655);
            return new AbstractMapBag.BagIterator<E>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2527.methodEnd();
        }
    }

    static class BagIterator<E> implements Iterator<E> {
        private final AbstractMapBag<E> parent;

        private final Iterator<Map.Entry<E, AbstractMapBag.MutableInteger>> entryIterator;

        private Map.Entry<E, AbstractMapBag.MutableInteger> current;

        private int itemCount;

        private final int mods;

        private boolean canRemove;

        public BagIterator(AbstractMapBag<E> parent) {
            MethodContext _bcornu_methode_context470 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 194, 6216, 6236);
                parent = CallChecker.beforeCalled(parent, AbstractMapBag.class, 195, 6271, 6276);
                this.entryIterator = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractMapBag.class, 195, 6271, 6276).map, Map.class, 195, 6271, 6280).entrySet(), Set.class, 195, 6271, 6291).iterator();
                CallChecker.varAssign(this.entryIterator, "this.entryIterator", 195, 6250, 6303);
                this.current = null;
                CallChecker.varAssign(this.current, "this.current", 196, 6317, 6336);
                parent = CallChecker.beforeCalled(parent, AbstractMapBag.class, 197, 6362, 6367);
                this.mods = CallChecker.isCalled(parent, AbstractMapBag.class, 197, 6362, 6367).modCount;
                CallChecker.varAssign(this.mods, "this.mods", 197, 6350, 6377);
                this.canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 198, 6391, 6413);
            } finally {
                _bcornu_methode_context470.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2528 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 201, 6434, 6532);
                CallChecker.varInit(this.canRemove, "canRemove", 201, 6434, 6532);
                CallChecker.varInit(this.mods, "mods", 201, 6434, 6532);
                CallChecker.varInit(this.itemCount, "itemCount", 201, 6434, 6532);
                CallChecker.varInit(this.current, "current", 201, 6434, 6532);
                CallChecker.varInit(this.entryIterator, "entryIterator", 201, 6434, 6532);
                CallChecker.varInit(this.parent, "parent", 201, 6434, 6532);
                return ((itemCount) > 0) || (CallChecker.isCalled(entryIterator, Iterator.class, 202, 6498, 6510).hasNext());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2528.methodEnd();
            }
        }

        public E next() {
            if (CallChecker.beforeDeref(parent, AbstractMapBag.class, 206, 6577, 6582)) {
                if ((CallChecker.isCalled(parent, AbstractMapBag.class, 206, 6577, 6582).modCount) != (mods)) {
                    throw new ConcurrentModificationException();
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((itemCount) == 0) {
                if (CallChecker.beforeDeref(entryIterator, Iterator.class, 210, 6739, 6751)) {
                    current = CallChecker.isCalled(entryIterator, Iterator.class, 210, 6739, 6751).next();
                    CallChecker.varAssign(this.current, "this.current", 210, 6729, 6759);
                }
                if (CallChecker.beforeDeref(current, Map.Entry.class, 211, 6789, 6795)) {
                    current = CallChecker.beforeCalled(current, Map.Entry.class, 211, 6789, 6795);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(current, Map.Entry.class, 211, 6789, 6795).getValue(), AbstractMapBag.MutableInteger.class, 211, 6789, 6806)) {
                        current = CallChecker.beforeCalled(current, Map.Entry.class, 211, 6789, 6795);
                        itemCount = CallChecker.isCalled(CallChecker.isCalled(current, Map.Entry.class, 211, 6789, 6795).getValue(), AbstractMapBag.MutableInteger.class, 211, 6789, 6806).value;
                        CallChecker.varAssign(this.itemCount, "this.itemCount", 211, 6777, 6813);
                    }
                }
            }
            canRemove = true;
            CallChecker.varAssign(this.canRemove, "this.canRemove", 213, 6841, 6857);
            (itemCount)--;
            if (CallChecker.beforeDeref(current, Map.Entry.class, 215, 6903, 6909)) {
                return current.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public void remove() {
            MethodContext _bcornu_methode_context2530 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 218, 6940, 7440);
                CallChecker.varInit(this.canRemove, "canRemove", 218, 6940, 7440);
                CallChecker.varInit(this.mods, "mods", 218, 6940, 7440);
                CallChecker.varInit(this.itemCount, "itemCount", 218, 6940, 7440);
                CallChecker.varInit(this.current, "current", 218, 6940, 7440);
                CallChecker.varInit(this.entryIterator, "entryIterator", 218, 6940, 7440);
                CallChecker.varInit(this.parent, "parent", 218, 6940, 7440);
                if (CallChecker.beforeDeref(parent, AbstractMapBag.class, 219, 6979, 6984)) {
                    if ((CallChecker.isCalled(parent, AbstractMapBag.class, 219, 6979, 6984).modCount) != (mods)) {
                        throw new ConcurrentModificationException();
                    }
                }
                if ((canRemove) == false) {
                    throw new IllegalStateException();
                }
                AbstractMapBag.MutableInteger mut = CallChecker.init(AbstractMapBag.MutableInteger.class);
                if (CallChecker.beforeDeref(current, Map.Entry.class, 225, 7217, 7223)) {
                    current = CallChecker.beforeCalled(current, Map.Entry.class, 225, 7217, 7223);
                    mut = CallChecker.isCalled(current, Map.Entry.class, 225, 7217, 7223).getValue();
                    CallChecker.varAssign(mut, "mut", 225, 7217, 7223);
                }
                if (CallChecker.beforeDeref(mut, AbstractMapBag.MutableInteger.class, 226, 7253, 7255)) {
                    mut = CallChecker.beforeCalled(mut, AbstractMapBag.MutableInteger.class, 226, 7253, 7255);
                    if ((CallChecker.isCalled(mut, AbstractMapBag.MutableInteger.class, 226, 7253, 7255).value) > 1) {
                        if (CallChecker.beforeDeref(mut, AbstractMapBag.MutableInteger.class, 227, 7286, 7288)) {
                            mut = CallChecker.beforeCalled(mut, AbstractMapBag.MutableInteger.class, 227, 7286, 7288);
                            (CallChecker.isCalled(mut, AbstractMapBag.MutableInteger.class, 227, 7286, 7288).value)--;
                        }
                    }else {
                        if (CallChecker.beforeDeref(entryIterator, Iterator.class, 229, 7336, 7348)) {
                            CallChecker.isCalled(entryIterator, Iterator.class, 229, 7336, 7348).remove();
                        }
                    }
                }
                if (CallChecker.beforeDeref(parent, AbstractMapBag.class, 231, 7386, 7391)) {
                    (CallChecker.isCalled(parent, AbstractMapBag.class, 231, 7386, 7391).size)--;
                }
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 232, 7413, 7430);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2530.methodEnd();
            }
        }
    }

    public boolean add(E object) {
        MethodContext _bcornu_methode_context2531 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 245, 7453, 7851);
            CallChecker.varInit(object, "object", 245, 7453, 7851);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 245, 7453, 7851);
            CallChecker.varInit(this.modCount, "modCount", 245, 7453, 7851);
            CallChecker.varInit(this.size, "size", 245, 7453, 7851);
            CallChecker.varInit(this.map, "map", 245, 7453, 7851);
            return add(object, 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2531.methodEnd();
        }
    }

    public boolean add(E object, int nCopies) {
        MethodContext _bcornu_methode_context2532 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 257, 7858, 8553);
            CallChecker.varInit(nCopies, "nCopies", 257, 7858, 8553);
            CallChecker.varInit(object, "object", 257, 7858, 8553);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 257, 7858, 8553);
            CallChecker.varInit(this.modCount, "modCount", 257, 7858, 8553);
            CallChecker.varInit(this.size, "size", 257, 7858, 8553);
            CallChecker.varInit(this.map, "map", 257, 7858, 8553);
            (modCount)++;
            if (nCopies > 0) {
                AbstractMapBag.MutableInteger mut = CallChecker.init(AbstractMapBag.MutableInteger.class);
                if (CallChecker.beforeDeref(map, Map.class, 260, 8275, 8277)) {
                    map = CallChecker.beforeCalled(map, Map.class, 260, 8275, 8277);
                    mut = CallChecker.isCalled(map, Map.class, 260, 8275, 8277).get(object);
                    CallChecker.varAssign(mut, "mut", 260, 8275, 8277);
                }
                size += nCopies;
                CallChecker.varAssign(this.size, "this.size", 261, 8304, 8319);
                if (mut == null) {
                    if (CallChecker.beforeDeref(map, Map.class, 263, 8368, 8370)) {
                        map = CallChecker.beforeCalled(map, Map.class, 263, 8368, 8370);
                        CallChecker.isCalled(map, Map.class, 263, 8368, 8370).put(object, new AbstractMapBag.MutableInteger(nCopies));
                    }
                    return true;
                }
                mut.value += nCopies;
                CallChecker.varAssign(mut.value, "mut.value", 266, 8469, 8489);
                return false;
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2532.methodEnd();
        }
    }

    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2533 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 278, 8560, 9054);
            CallChecker.varInit(coll, "coll", 278, 8560, 9054);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 278, 8560, 9054);
            CallChecker.varInit(this.modCount, "modCount", 278, 8560, 9054);
            CallChecker.varInit(this.size, "size", 278, 8560, 9054);
            CallChecker.varInit(this.map, "map", 278, 8560, 9054);
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 279, 8827, 8850);
            Iterator<? extends E> i = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(coll, Collection.class, 280, 8886, 8889)) {
                coll = CallChecker.beforeCalled(coll, Collection.class, 280, 8886, 8889);
                i = CallChecker.isCalled(coll, Collection.class, 280, 8886, 8889).iterator();
                CallChecker.varAssign(i, "i", 280, 8886, 8889);
            }
            i = CallChecker.beforeCalled(i, Iterator.class, 281, 8918, 8918);
            while (CallChecker.isCalled(i, Iterator.class, 281, 8918, 8918).hasNext()) {
                boolean added = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(i, Iterator.class, 282, 8965, 8965)) {
                    added = add(i.next());
                    CallChecker.varAssign(added, "added", 282, 8965, 8965);
                }
                changed = changed || added;
                CallChecker.varAssign(changed, "changed", 283, 8988, 9014);
            } 
            return changed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2533.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context2534 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 292, 9061, 9294);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 292, 9061, 9294);
            CallChecker.varInit(this.modCount, "modCount", 292, 9061, 9294);
            CallChecker.varInit(this.size, "size", 292, 9061, 9294);
            CallChecker.varInit(this.map, "map", 292, 9061, 9294);
            (modCount)++;
            if (CallChecker.beforeDeref(map, Map.class, 294, 9259, 9261)) {
                map = CallChecker.beforeCalled(map, Map.class, 294, 9259, 9261);
                CallChecker.isCalled(map, Map.class, 294, 9259, 9261).clear();
            }
            size = 0;
            CallChecker.varAssign(this.size, "this.size", 295, 9280, 9288);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2534.methodEnd();
        }
    }

    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context2535 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 304, 9301, 9718);
            CallChecker.varInit(object, "object", 304, 9301, 9718);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 304, 9301, 9718);
            CallChecker.varInit(this.modCount, "modCount", 304, 9301, 9718);
            CallChecker.varInit(this.size, "size", 304, 9301, 9718);
            CallChecker.varInit(this.map, "map", 304, 9301, 9718);
            AbstractMapBag.MutableInteger mut = CallChecker.init(AbstractMapBag.MutableInteger.class);
            if (CallChecker.beforeDeref(map, Map.class, 305, 9538, 9540)) {
                map = CallChecker.beforeCalled(map, Map.class, 305, 9538, 9540);
                mut = CallChecker.isCalled(map, Map.class, 305, 9538, 9540).get(object);
                CallChecker.varAssign(mut, "mut", 305, 9538, 9540);
            }
            if (mut == null) {
                return false;
            }
            (modCount)++;
            if (CallChecker.beforeDeref(map, Map.class, 310, 9646, 9648)) {
                map = CallChecker.beforeCalled(map, Map.class, 310, 9646, 9648);
                CallChecker.isCalled(map, Map.class, 310, 9646, 9648).remove(object);
            }
            size -= mut.value;
            CallChecker.varAssign(this.size, "this.size", 311, 9674, 9691);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2535.methodEnd();
        }
    }

    public boolean remove(Object object, int nCopies) {
        MethodContext _bcornu_methode_context2536 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 322, 9725, 10412);
            CallChecker.varInit(nCopies, "nCopies", 322, 9725, 10412);
            CallChecker.varInit(object, "object", 322, 9725, 10412);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 322, 9725, 10412);
            CallChecker.varInit(this.modCount, "modCount", 322, 9725, 10412);
            CallChecker.varInit(this.size, "size", 322, 9725, 10412);
            CallChecker.varInit(this.map, "map", 322, 9725, 10412);
            AbstractMapBag.MutableInteger mut = CallChecker.init(AbstractMapBag.MutableInteger.class);
            if (CallChecker.beforeDeref(map, Map.class, 323, 10035, 10037)) {
                map = CallChecker.beforeCalled(map, Map.class, 323, 10035, 10037);
                mut = CallChecker.isCalled(map, Map.class, 323, 10035, 10037).get(object);
                CallChecker.varAssign(mut, "mut", 323, 10035, 10037);
            }
            if (mut == null) {
                return false;
            }
            if (nCopies <= 0) {
                return false;
            }
            (modCount)++;
            if (nCopies < (mut.value)) {
                mut.value -= nCopies;
                CallChecker.varAssign(mut.value, "mut.value", 332, 10246, 10266);
                size -= nCopies;
                CallChecker.varAssign(this.size, "this.size", 333, 10280, 10295);
            }else {
                if (CallChecker.beforeDeref(map, Map.class, 335, 10326, 10328)) {
                    map = CallChecker.beforeCalled(map, Map.class, 335, 10326, 10328);
                    CallChecker.isCalled(map, Map.class, 335, 10326, 10328).remove(object);
                }
                size -= mut.value;
                CallChecker.varAssign(this.size, "this.size", 336, 10358, 10375);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2536.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2537 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 348, 10419, 10956);
            CallChecker.varInit(coll, "coll", 348, 10419, 10956);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 348, 10419, 10956);
            CallChecker.varInit(this.modCount, "modCount", 348, 10419, 10956);
            CallChecker.varInit(this.size, "size", 348, 10419, 10956);
            CallChecker.varInit(this.map, "map", 348, 10419, 10956);
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 349, 10675, 10697);
            if (coll != null) {
                Iterator<?> i = CallChecker.varInit(coll.iterator(), "i", 351, 10739, 10770);
                i = CallChecker.beforeCalled(i, Iterator.class, 352, 10791, 10791);
                while (CallChecker.isCalled(i, Iterator.class, 352, 10791, 10791).hasNext()) {
                    boolean changed = CallChecker.init(boolean.class);
                    if (CallChecker.beforeDeref(i, Iterator.class, 353, 10847, 10847)) {
                        changed = remove(i.next(), 1);
                        CallChecker.varAssign(changed, "changed", 353, 10847, 10847);
                    }
                    result = result || changed;
                    CallChecker.varAssign(result, "result", 354, 10877, 10903);
                } 
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2537.methodEnd();
        }
    }

    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2538 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 367, 10963, 11380);
            CallChecker.varInit(coll, "coll", 367, 10963, 11380);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 367, 10963, 11380);
            CallChecker.varInit(this.modCount, "modCount", 367, 10963, 11380);
            CallChecker.varInit(this.size, "size", 367, 10963, 11380);
            CallChecker.varInit(this.map, "map", 367, 10963, 11380);
            if (coll instanceof Bag) {
                return retainAll(((Bag<?>) (coll)));
            }
            return retainAll(new HashBag<Object>(coll));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2538.methodEnd();
        }
    }

    boolean retainAll(Bag<?> other) {
        MethodContext _bcornu_methode_context2539 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 382, 11387, 12291);
            CallChecker.varInit(other, "other", 382, 11387, 12291);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 382, 11387, 12291);
            CallChecker.varInit(this.modCount, "modCount", 382, 11387, 12291);
            CallChecker.varInit(this.size, "size", 382, 11387, 12291);
            CallChecker.varInit(this.map, "map", 382, 11387, 12291);
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 383, 11694, 11716);
            Bag<E> excess = CallChecker.varInit(new HashBag<E>(), "excess", 384, 11726, 11758);
            final Set<E> npe_invocation_var448 = uniqueSet();
            Iterator<E> i = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(npe_invocation_var448, Set.class, 385, 11784, 11794)) {
                i = CallChecker.isCalled(npe_invocation_var448, Set.class, 385, 11784, 11794).iterator();
                CallChecker.varAssign(i, "i", 385, 11784, 11794);
            }
            i = CallChecker.beforeCalled(i, Iterator.class, 386, 11823, 11823);
            while (CallChecker.isCalled(i, Iterator.class, 386, 11823, 11823).hasNext()) {
                E current = CallChecker.init(null);
                if (CallChecker.beforeDeref(i, Iterator.class, 387, 11862, 11862)) {
                    current = i.next();
                    CallChecker.varAssign(current, "current", 387, 11862, 11862);
                }
                int myCount = CallChecker.varInit(((int) (getCount(current))), "myCount", 388, 11884, 11915);
                int otherCount = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(other, Bag.class, 389, 11946, 11950)) {
                    other = CallChecker.beforeCalled(other, Bag.class, 389, 11946, 11950);
                    otherCount = CallChecker.isCalled(other, Bag.class, 389, 11946, 11950).getCount(current);
                    CallChecker.varAssign(otherCount, "otherCount", 389, 11946, 11950);
                }
                if ((1 <= otherCount) && (otherCount <= myCount)) {
                    if (CallChecker.beforeDeref(excess, Bag.class, 391, 12047, 12052)) {
                        excess = CallChecker.beforeCalled(excess, Bag.class, 391, 12047, 12052);
                        CallChecker.isCalled(excess, Bag.class, 391, 12047, 12052).add(current, (myCount - otherCount));
                    }
                }else {
                    if (CallChecker.beforeDeref(excess, Bag.class, 393, 12127, 12132)) {
                        excess = CallChecker.beforeCalled(excess, Bag.class, 393, 12127, 12132);
                        CallChecker.isCalled(excess, Bag.class, 393, 12127, 12132).add(current, myCount);
                    }
                }
            } 
            if (CallChecker.beforeDeref(excess, Bag.class, 396, 12194, 12199)) {
                excess = CallChecker.beforeCalled(excess, Bag.class, 396, 12194, 12199);
                if (!(CallChecker.isCalled(excess, Bag.class, 396, 12194, 12199).isEmpty())) {
                    result = removeAll(excess);
                    CallChecker.varAssign(result, "result", 397, 12226, 12252);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2539.methodEnd();
        }
    }

    protected static class MutableInteger {
        protected int value;

        MutableInteger(int value) {
            MethodContext _bcornu_methode_context471 = new MethodContext(null);
            try {
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 415, 12693, 12711);
            } finally {
                _bcornu_methode_context471.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context2540 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 419, 12732, 12954);
                CallChecker.varInit(obj, "obj", 419, 12732, 12954);
                CallChecker.varInit(this.value, "value", 419, 12732, 12954);
                if ((obj instanceof AbstractMapBag.MutableInteger) == false) {
                    return false;
                }
                obj = CallChecker.beforeCalled(obj, AbstractMapBag.MutableInteger.class, 423, 12925, 12927);
                return (CallChecker.isCalled(((AbstractMapBag.MutableInteger) (obj)), AbstractMapBag.MutableInteger.class, 423, 12925, 12927).value) == (value);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2540.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2541 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 427, 12965, 13041);
                CallChecker.varInit(this.value, "value", 427, 12965, 13041);
                return value;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2541.methodEnd();
            }
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context2542 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 438, 13054, 13634);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 438, 13054, 13634);
            CallChecker.varInit(this.modCount, "modCount", 438, 13054, 13634);
            CallChecker.varInit(this.size, "size", 438, 13054, 13634);
            CallChecker.varInit(this.map, "map", 438, 13054, 13634);
            Object[] result = CallChecker.varInit(new Object[size()], "result", 439, 13301, 13337);
            int i = CallChecker.varInit(((int) (0)), "i", 440, 13347, 13356);
            Iterator<E> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(map, Map.class, 441, 13383, 13385)) {
                map = CallChecker.beforeCalled(map, Map.class, 441, 13383, 13385);
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 441, 13383, 13385).keySet(), Set.class, 441, 13383, 13394)) {
                    map = CallChecker.beforeCalled(map, Map.class, 441, 13383, 13385);
                    it = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 441, 13383, 13385).keySet(), Set.class, 441, 13383, 13394).iterator();
                    CallChecker.varAssign(it, "it", 441, 13383, 13385);
                }
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 442, 13423, 13424);
            while (CallChecker.isCalled(it, Iterator.class, 442, 13423, 13424).hasNext()) {
                E current = CallChecker.init(null);
                if (CallChecker.beforeDeref(it, Iterator.class, 443, 13463, 13464)) {
                    current = it.next();
                    CallChecker.varAssign(current, "current", 443, 13463, 13464);
                }
                for (int index = getCount(current); index > 0; index--) {
                    if (CallChecker.beforeDeref(result, Object[].class, 445, 13560, 13565)) {
                        result = CallChecker.beforeCalled(result, Object[].class, 445, 13560, 13565);
                        CallChecker.isCalled(result, Object[].class, 445, 13560, 13565)[(i++)] = current;
                        CallChecker.varAssign(CallChecker.isCalled(result, Object[].class, 445, 13560, 13565)[(i - 1)], "CallChecker.isCalled(result, Object[].class, 445, 13560, 13565)[(i - 1)]", 445, 13560, 13581);
                    }
                }
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2542.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public <T> T[] toArray(T[] array) {
        MethodContext _bcornu_methode_context2543 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 458, 13641, 14421);
            CallChecker.varInit(array, "array", 458, 13641, 14421);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 458, 13641, 14421);
            CallChecker.varInit(this.modCount, "modCount", 458, 13641, 14421);
            CallChecker.varInit(this.size, "size", 458, 13641, 14421);
            CallChecker.varInit(this.map, "map", 458, 13641, 14421);
            int size = CallChecker.varInit(((int) (size())), "size", 459, 13895, 13912);
            if (CallChecker.beforeDeref(array, null, 460, 13926, 13930)) {
                array = CallChecker.beforeCalled(array, null, 460, 13926, 13930);
                if ((CallChecker.isCalled(array, null, 460, 13926, 13930).length) < size) {
                    if (CallChecker.beforeDeref(array, null, 461, 13993, 13997)) {
                        array = CallChecker.beforeCalled(array, null, 461, 13993, 13997);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 461, 13993, 13997).getClass(), Class.class, 461, 13993, 14008)) {
                            array = CallChecker.beforeCalled(array, null, 461, 13993, 13997);
                            array = ((T[]) (Array.newInstance(CallChecker.isCalled(CallChecker.isCalled(array, null, 461, 13993, 13997).getClass(), Class.class, 461, 13993, 14008).getComponentType(), size)));
                            CallChecker.varAssign(array, "array", 461, 13961, 14035);
                        }
                    }
                }
            }
            int i = CallChecker.varInit(((int) (0)), "i", 464, 14056, 14065);
            Iterator<E> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(map, Map.class, 465, 14092, 14094)) {
                map = CallChecker.beforeCalled(map, Map.class, 465, 14092, 14094);
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 465, 14092, 14094).keySet(), Set.class, 465, 14092, 14103)) {
                    map = CallChecker.beforeCalled(map, Map.class, 465, 14092, 14094);
                    it = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 465, 14092, 14094).keySet(), Set.class, 465, 14092, 14103).iterator();
                    CallChecker.varAssign(it, "it", 465, 14092, 14094);
                }
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 466, 14132, 14133);
            while (CallChecker.isCalled(it, Iterator.class, 466, 14132, 14133).hasNext()) {
                E current = CallChecker.init(null);
                if (CallChecker.beforeDeref(it, Iterator.class, 467, 14172, 14173)) {
                    current = it.next();
                    CallChecker.varAssign(current, "current", 467, 14172, 14173);
                }
                for (int index = getCount(current); index > 0; index--) {
                    if (CallChecker.beforeDeref(array, null, 469, 14269, 14273)) {
                        array[(i++)] = ((T) (current));
                        CallChecker.varAssign(array[(i - 1)], "array[(i - 1)]", 469, 14269, 14293);
                    }
                }
            } 
            array = CallChecker.beforeCalled(array, null, 472, 14338, 14342);
            while (i < (CallChecker.isCalled(array, null, 472, 14338, 14342).length)) {
                if (CallChecker.beforeDeref(array, null, 473, 14366, 14370)) {
                    array[(i++)] = null;
                    CallChecker.varAssign(array[(i - 1)], "array[(i - 1)]", 473, 14366, 14383);
                }
            } 
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2543.methodEnd();
        }
    }

    public Set<E> uniqueSet() {
        MethodContext _bcornu_methode_context2544 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 483, 14428, 14744);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 483, 14428, 14744);
            CallChecker.varInit(this.modCount, "modCount", 483, 14428, 14744);
            CallChecker.varInit(this.size, "size", 483, 14428, 14744);
            CallChecker.varInit(this.map, "map", 483, 14428, 14744);
            if ((uniqueSet) == null) {
                if (CallChecker.beforeDeref(map, Map.class, 485, 14689, 14691)) {
                    map = CallChecker.beforeCalled(map, Map.class, 485, 14689, 14691);
                    uniqueSet = UnmodifiableSet.<E>decorate(CallChecker.isCalled(map, Map.class, 485, 14689, 14691).keySet());
                    CallChecker.varAssign(this.uniqueSet, "this.uniqueSet", 485, 14648, 14702);
                }
            }
            return uniqueSet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2544.methodEnd();
        }
    }

    protected void doWriteObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2545 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 496, 14751, 15335);
            CallChecker.varInit(out, "out", 496, 14751, 15335);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 496, 14751, 15335);
            CallChecker.varInit(this.modCount, "modCount", 496, 14751, 15335);
            CallChecker.varInit(this.size, "size", 496, 14751, 15335);
            CallChecker.varInit(this.map, "map", 496, 14751, 15335);
            if (CallChecker.beforeDeref(map, Map.class, 497, 15052, 15054)) {
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 497, 15039, 15041)) {
                    map = CallChecker.beforeCalled(map, Map.class, 497, 15052, 15054);
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 497, 15039, 15041);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 497, 15039, 15041).writeInt(CallChecker.isCalled(map, Map.class, 497, 15052, 15054).size());
                }
            }
            map = CallChecker.beforeCalled(map, Map.class, 498, 15122, 15124);
            for (Iterator<Map.Entry<E, AbstractMapBag.MutableInteger>> it = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 498, 15122, 15124).entrySet(), Set.class, 498, 15122, 15135).iterator(); CallChecker.isCalled(it, Iterator.class, 498, 15149, 15150).hasNext();) {
                Map.Entry<E, AbstractMapBag.MutableInteger> entry = CallChecker.init(Map.Entry.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 499, 15215, 15216)) {
                    entry = CallChecker.isCalled(it, Iterator.class, 499, 15215, 15216).next();
                    CallChecker.varAssign(entry, "entry", 499, 15215, 15216);
                }
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 500, 15254, 15258)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 500, 15238, 15240)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 500, 15238, 15240);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 500, 15238, 15240).writeObject(entry.getKey());
                    }
                }
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 501, 15296, 15300)) {
                    entry = CallChecker.beforeCalled(entry, Map.Entry.class, 501, 15296, 15300);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 501, 15296, 15300).getValue(), AbstractMapBag.MutableInteger.class, 501, 15296, 15311)) {
                        if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 501, 15283, 15285)) {
                            entry = CallChecker.beforeCalled(entry, Map.Entry.class, 501, 15296, 15300);
                            out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 501, 15283, 15285);
                            CallChecker.isCalled(out, ObjectOutputStream.class, 501, 15283, 15285).writeInt(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 501, 15296, 15300).getValue(), AbstractMapBag.MutableInteger.class, 501, 15296, 15311).value);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2545.methodEnd();
        }
    }

    protected void doReadObject(Map<E, AbstractMapBag.MutableInteger> map, ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2546 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 513, 15342, 16137);
            CallChecker.varInit(in, "in", 513, 15342, 16137);
            CallChecker.varInit(map, "map", 513, 15342, 16137);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 513, 15342, 16137);
            CallChecker.varInit(this.modCount, "modCount", 513, 15342, 16137);
            CallChecker.varInit(this.size, "size", 513, 15342, 16137);
            CallChecker.varInit(this.map, "map", 513, 15342, 16137);
            this.map = map;
            CallChecker.varAssign(this.map, "this.map", 515, 15765, 15779);
            int entrySize = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 516, 15805, 15806)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 516, 15805, 15806);
                entrySize = CallChecker.isCalled(in, ObjectInputStream.class, 516, 15805, 15806).readInt();
                CallChecker.varAssign(entrySize, "entrySize", 516, 15805, 15806);
            }
            for (int i = 0; i < entrySize; i++) {
                E obj = CallChecker.init(null);
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 519, 15988, 15989)) {
                    in = CallChecker.beforeCalled(in, ObjectInputStream.class, 519, 15988, 15989);
                    obj = ((E) (CallChecker.isCalled(in, ObjectInputStream.class, 519, 15988, 15989).readObject()));
                    CallChecker.varAssign(obj, "obj", 519, 15988, 15989);
                }
                int count = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 520, 16029, 16030)) {
                    in = CallChecker.beforeCalled(in, ObjectInputStream.class, 520, 16029, 16030);
                    count = CallChecker.isCalled(in, ObjectInputStream.class, 520, 16029, 16030).readInt();
                    CallChecker.varAssign(count, "count", 520, 16029, 16030);
                }
                if (CallChecker.beforeDeref(map, Map.class, 521, 16055, 16057)) {
                    map = CallChecker.beforeCalled(map, Map.class, 521, 16055, 16057);
                    CallChecker.isCalled(map, Map.class, 521, 16055, 16057).put(obj, new AbstractMapBag.MutableInteger(count));
                }
                size += count;
                CallChecker.varAssign(this.size, "this.size", 522, 16108, 16121);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2546.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context2547 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 535, 16144, 17022);
            CallChecker.varInit(object, "object", 535, 16144, 17022);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 535, 16144, 17022);
            CallChecker.varInit(this.modCount, "modCount", 535, 16144, 17022);
            CallChecker.varInit(this.size, "size", 535, 16144, 17022);
            CallChecker.varInit(this.map, "map", 535, 16144, 17022);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof Bag) == false) {
                return false;
            }
            Bag<?> other = CallChecker.varInit(((Bag<?>) (object)), "other", 542, 16666, 16696);
            if (CallChecker.beforeDeref(other, Bag.class, 543, 16710, 16714)) {
                other = CallChecker.beforeCalled(other, Bag.class, 543, 16710, 16714);
                if ((CallChecker.isCalled(other, Bag.class, 543, 16710, 16714).size()) != (size())) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            map = CallChecker.beforeCalled(map, Map.class, 546, 16802, 16804);
            for (Iterator<E> it = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 546, 16802, 16804).keySet(), Set.class, 546, 16802, 16813).iterator(); CallChecker.isCalled(it, Iterator.class, 546, 16827, 16828).hasNext();) {
                E element = CallChecker.init(null);
                if (CallChecker.beforeDeref(it, Iterator.class, 547, 16868, 16869)) {
                    element = it.next();
                    CallChecker.varAssign(element, "element", 547, 16868, 16869);
                }
                if (CallChecker.beforeDeref(other, Bag.class, 548, 16895, 16899)) {
                    other = CallChecker.beforeCalled(other, Bag.class, 548, 16895, 16899);
                    if ((CallChecker.isCalled(other, Bag.class, 548, 16895, 16899).getCount(element)) != (getCount(element))) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2547.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2548 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 565, 17029, 17856);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 565, 17029, 17856);
            CallChecker.varInit(this.modCount, "modCount", 565, 17029, 17856);
            CallChecker.varInit(this.size, "size", 565, 17029, 17856);
            CallChecker.varInit(this.map, "map", 565, 17029, 17856);
            int total = CallChecker.varInit(((int) (0)), "total", 566, 17472, 17485);
            map = CallChecker.beforeCalled(map, Map.class, 567, 17544, 17546);
            for (Iterator<Map.Entry<E, AbstractMapBag.MutableInteger>> it = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 567, 17544, 17546).entrySet(), Set.class, 567, 17544, 17557).iterator(); CallChecker.isCalled(it, Iterator.class, 567, 17571, 17572).hasNext();) {
                Map.Entry<E, AbstractMapBag.MutableInteger> entry = CallChecker.init(Map.Entry.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 568, 17637, 17638)) {
                    entry = CallChecker.isCalled(it, Iterator.class, 568, 17637, 17638).next();
                    CallChecker.varAssign(entry, "entry", 568, 17637, 17638);
                }
                E element = CallChecker.init(null);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 569, 17672, 17676)) {
                    element = entry.getKey();
                    CallChecker.varAssign(element, "element", 569, 17672, 17676);
                }
                AbstractMapBag.MutableInteger count = CallChecker.init(AbstractMapBag.MutableInteger.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 570, 17723, 17727)) {
                    entry = CallChecker.beforeCalled(entry, Map.Entry.class, 570, 17723, 17727);
                    count = CallChecker.isCalled(entry, Map.Entry.class, 570, 17723, 17727).getValue();
                    CallChecker.varAssign(count, "count", 570, 17723, 17727);
                }
                if (element == null) {
                    if (CallChecker.beforeDeref(count, AbstractMapBag.MutableInteger.class, 571, 17807, 17811)) {
                        count = CallChecker.beforeCalled(count, AbstractMapBag.MutableInteger.class, 571, 17807, 17811);
                        total += 0 ^ (CallChecker.isCalled(count, AbstractMapBag.MutableInteger.class, 571, 17807, 17811).value);
                        CallChecker.varAssign(total, "total", 571, 17753, 17818);
                    }
                }else {
                    if (CallChecker.beforeDeref(count, AbstractMapBag.MutableInteger.class, 571, 17807, 17811)) {
                        count = CallChecker.beforeCalled(count, AbstractMapBag.MutableInteger.class, 571, 17807, 17811);
                        total += (element.hashCode()) ^ (CallChecker.isCalled(count, AbstractMapBag.MutableInteger.class, 571, 17807, 17811).value);
                        CallChecker.varAssign(total, "total", 571, 17753, 17818);
                    }
                }
            }
            return total;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2548.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2549 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 582, 17863, 18566);
            CallChecker.varInit(this.uniqueSet, "uniqueSet", 582, 17863, 18566);
            CallChecker.varInit(this.modCount, "modCount", 582, 17863, 18566);
            CallChecker.varInit(this.size, "size", 582, 17863, 18566);
            CallChecker.varInit(this.map, "map", 582, 17863, 18566);
            if ((size()) == 0) {
                return "[]";
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(), "buf", 586, 18095, 18134);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 587, 18144, 18146)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 587, 18144, 18146);
                CallChecker.isCalled(buf, StringBuilder.class, 587, 18144, 18146).append('[');
            }
            final Set<E> npe_invocation_var449 = uniqueSet();
            Iterator<E> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(npe_invocation_var449, Set.class, 588, 18186, 18196)) {
                it = CallChecker.isCalled(npe_invocation_var449, Set.class, 588, 18186, 18196).iterator();
                CallChecker.varAssign(it, "it", 588, 18186, 18196);
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 589, 18225, 18226);
            while (CallChecker.isCalled(it, Iterator.class, 589, 18225, 18226).hasNext()) {
                Object current = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 590, 18270, 18271)) {
                    current = it.next();
                    CallChecker.varAssign(current, "current", 590, 18270, 18271);
                }
                int count = CallChecker.varInit(((int) (getCount(current))), "count", 591, 18293, 18322);
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 592, 18336, 18338)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 592, 18336, 18338);
                    CallChecker.isCalled(buf, StringBuilder.class, 592, 18336, 18338).append(count);
                }
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 593, 18367, 18369)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 593, 18367, 18369);
                    CallChecker.isCalled(buf, StringBuilder.class, 593, 18367, 18369).append(':');
                }
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 594, 18396, 18398)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 594, 18396, 18398);
                    CallChecker.isCalled(buf, StringBuilder.class, 594, 18396, 18398).append(current);
                }
                if (CallChecker.beforeDeref(it, Iterator.class, 595, 18433, 18434)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 595, 18433, 18434);
                    if (CallChecker.isCalled(it, Iterator.class, 595, 18433, 18434).hasNext()) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 596, 18465, 18467)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 596, 18465, 18467);
                            CallChecker.isCalled(buf, StringBuilder.class, 596, 18465, 18467).append(',');
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 599, 18514, 18516)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 599, 18514, 18516);
                CallChecker.isCalled(buf, StringBuilder.class, 599, 18514, 18516).append(']');
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 600, 18546, 18548)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 600, 18546, 18548);
                return CallChecker.isCalled(buf, StringBuilder.class, 600, 18546, 18548).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2549.methodEnd();
        }
    }
}

