package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.ResettableIterator;
import java.util.Set;

public class EntrySetToMapIteratorAdapter<K, V> implements MapIterator<K, V> , ResettableIterator<K> {
    protected Set<Map.Entry<K, V>> entrySet;

    protected transient Iterator<Map.Entry<K, V>> iterator;

    protected transient Map.Entry<K, V> entry;

    public EntrySetToMapIteratorAdapter(Set<Map.Entry<K, V>> entrySet) {
        MethodContext _bcornu_methode_context284 = new MethodContext(null);
        try {
            this.entrySet = entrySet;
            CallChecker.varAssign(this.entrySet, "this.entrySet", 49, 1796, 1820);
            reset();
        } finally {
            _bcornu_methode_context284.methodEnd();
        }
    }

    public K getKey() {
        final Map.Entry<K, V> npe_invocation_var291 = current();
        if (CallChecker.beforeDeref(npe_invocation_var291, Map.Entry.class, 57, 1922, 1930)) {
            return npe_invocation_var291.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue() {
        final Map.Entry<K, V> npe_invocation_var292 = current();
        if (CallChecker.beforeDeref(npe_invocation_var292, Map.Entry.class, 64, 2027, 2035)) {
            return npe_invocation_var292.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V setValue(V value) {
        final Map.Entry<K, V> npe_invocation_var293 = current();
        if (CallChecker.beforeDeref(npe_invocation_var293, Map.Entry.class, 71, 2141, 2149)) {
            return npe_invocation_var293.setValue(value);
        }else
            throw new AbnormalExecutionError();
        
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1511 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2179, 2282);
            CallChecker.varInit(this.entry, "entry", 77, 2179, 2282);
            CallChecker.varInit(this.iterator, "iterator", 77, 2179, 2282);
            CallChecker.varInit(this.entrySet, "entrySet", 77, 2179, 2282);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 78, 2258, 2265)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 78, 2258, 2265);
                return CallChecker.isCalled(iterator, Iterator.class, 78, 2258, 2265).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1511.methodEnd();
        }
    }

    public K next() {
        if (CallChecker.beforeDeref(iterator, Iterator.class, 85, 2360, 2367)) {
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 85, 2360, 2367);
            entry = CallChecker.isCalled(iterator, Iterator.class, 85, 2360, 2367).next();
            CallChecker.varAssign(this.entry, "this.entry", 85, 2352, 2375);
        }
        return getKey();
    }

    public synchronized void reset() {
        MethodContext _bcornu_methode_context1513 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 92, 2413, 2529);
            CallChecker.varInit(this.entry, "entry", 92, 2413, 2529);
            CallChecker.varInit(this.iterator, "iterator", 92, 2413, 2529);
            CallChecker.varInit(this.entrySet, "entrySet", 92, 2413, 2529);
            if (CallChecker.beforeDeref(entrySet, Set.class, 93, 2504, 2511)) {
                entrySet = CallChecker.beforeCalled(entrySet, Set.class, 93, 2504, 2511);
                iterator = CallChecker.isCalled(entrySet, Set.class, 93, 2504, 2511).iterator();
                CallChecker.varAssign(this.iterator, "this.iterator", 93, 2493, 2523);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1513.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context1514 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 99, 2536, 2649);
            CallChecker.varInit(this.entry, "entry", 99, 2536, 2649);
            CallChecker.varInit(this.iterator, "iterator", 99, 2536, 2649);
            CallChecker.varInit(this.entrySet, "entrySet", 99, 2536, 2649);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 100, 2604, 2611)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 100, 2604, 2611);
                CallChecker.isCalled(iterator, Iterator.class, 100, 2604, 2611).remove();
            }
            entry = null;
            CallChecker.varAssign(this.entry, "this.entry", 101, 2631, 2643);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1514.methodEnd();
        }
    }

    protected synchronized Map.Entry<K, V> current() {
        MethodContext _bcornu_methode_context1515 = new MethodContext(Map.Entry.class);
        try {
            CallChecker.varInit(this, "this", 108, 2656, 2906);
            CallChecker.varInit(this.entry, "entry", 108, 2656, 2906);
            CallChecker.varInit(this.iterator, "iterator", 108, 2656, 2906);
            CallChecker.varInit(this.entrySet, "entrySet", 108, 2656, 2906);
            if ((entry) == null) {
                throw new IllegalStateException();
            }
            return entry;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1515.methodEnd();
        }
    }
}

