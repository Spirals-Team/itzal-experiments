package org.apache.commons.collections.iterators;

import java.util.Set;
import org.apache.commons.collections.ResettableIterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class EntrySetMapIterator<K, V> implements MapIterator<K, V> , ResettableIterator<K> {
    private final Map<K, V> map;

    private Iterator<Map.Entry<K, V>> iterator;

    private Map.Entry<K, V> last;

    private boolean canRemove = false;

    public EntrySetMapIterator(Map<K, V> map) {
        super();
        MethodContext _bcornu_methode_context454 = new MethodContext(null);
        try {
            this.map = map;
            CallChecker.varAssign(this.map, "this.map", 56, 1883, 1897);
            if (CallChecker.beforeDeref(map, Map.class, 57, 1923, 1925)) {
                map = CallChecker.beforeCalled(map, Map.class, 57, 1923, 1925);
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 57, 1923, 1925).entrySet(), Set.class, 57, 1923, 1936)) {
                    map = CallChecker.beforeCalled(map, Map.class, 57, 1923, 1925);
                    this.iterator = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 57, 1923, 1925).entrySet(), Set.class, 57, 1923, 1936).iterator();
                    CallChecker.varAssign(this.iterator, "this.iterator", 57, 1907, 1948);
                }
            }
        } finally {
            _bcornu_methode_context454.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context2389 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 66, 1961, 2268);
            CallChecker.varInit(this.canRemove, "canRemove", 66, 1961, 2268);
            CallChecker.varInit(this.last, "last", 66, 1961, 2268);
            CallChecker.varInit(this.iterator, "iterator", 66, 1961, 2268);
            CallChecker.varInit(this.map, "map", 66, 1961, 2268);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 67, 2244, 2251)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 67, 2244, 2251);
                return CallChecker.isCalled(iterator, Iterator.class, 67, 2244, 2251).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2389.methodEnd();
        }
    }

    public K next() {
        if (CallChecker.beforeDeref(iterator, Iterator.class, 77, 2514, 2521)) {
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 77, 2514, 2521);
            last = CallChecker.isCalled(iterator, Iterator.class, 77, 2514, 2521).next();
            CallChecker.varAssign(this.last, "this.last", 77, 2507, 2529);
        }
        canRemove = true;
        CallChecker.varAssign(this.canRemove, "this.canRemove", 78, 2539, 2555);
        if (CallChecker.beforeDeref(last, Map.Entry.class, 79, 2572, 2575)) {
            return last.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context2391 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 93, 2598, 3409);
            CallChecker.varInit(this.canRemove, "canRemove", 93, 2598, 3409);
            CallChecker.varInit(this.last, "last", 93, 2598, 3409);
            CallChecker.varInit(this.iterator, "iterator", 93, 2598, 3409);
            CallChecker.varInit(this.map, "map", 93, 2598, 3409);
            if ((canRemove) == false) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            if (CallChecker.beforeDeref(iterator, Iterator.class, 97, 3338, 3345)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 97, 3338, 3345);
                CallChecker.isCalled(iterator, Iterator.class, 97, 3338, 3345).remove();
            }
            last = null;
            CallChecker.varAssign(this.last, "this.last", 98, 3365, 3376);
            canRemove = false;
            CallChecker.varAssign(this.canRemove, "this.canRemove", 99, 3386, 3403);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2391.methodEnd();
        }
    }

    public K getKey() {
        if ((last) == null) {
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }
        return last.getKey();
    }

    public V getValue() {
        if ((last) == null) {
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }
        return last.getValue();
    }

    public V setValue(V value) {
        if ((last) == null) {
            throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
        }
        return last.setValue(value);
    }

    public void reset() {
        MethodContext _bcornu_methode_context2395 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 152, 5118, 5373);
            CallChecker.varInit(this.canRemove, "canRemove", 152, 5118, 5373);
            CallChecker.varInit(this.last, "last", 152, 5118, 5373);
            CallChecker.varInit(this.iterator, "iterator", 152, 5118, 5373);
            CallChecker.varInit(this.map, "map", 152, 5118, 5373);
            if (CallChecker.beforeDeref(map, Map.class, 153, 5294, 5296)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 153, 5294, 5296).entrySet(), Set.class, 153, 5294, 5307)) {
                    iterator = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 153, 5294, 5296).entrySet(), Set.class, 153, 5294, 5307).iterator();
                    CallChecker.varAssign(this.iterator, "this.iterator", 153, 5283, 5319);
                }
            }
            last = null;
            CallChecker.varAssign(this.last, "this.last", 154, 5329, 5340);
            canRemove = false;
            CallChecker.varAssign(this.canRemove, "this.canRemove", 155, 5350, 5367);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2395.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2396 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 164, 5384, 5684);
            CallChecker.varInit(this.canRemove, "canRemove", 164, 5384, 5684);
            CallChecker.varInit(this.last, "last", 164, 5384, 5684);
            CallChecker.varInit(this.iterator, "iterator", 164, 5384, 5684);
            CallChecker.varInit(this.map, "map", 164, 5384, 5684);
            if ((last) != null) {
                return ((("MapIterator[" + (getKey())) + "=") + (getValue())) + "]";
            }
            return "MapIterator[]";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2396.methodEnd();
        }
    }
}

