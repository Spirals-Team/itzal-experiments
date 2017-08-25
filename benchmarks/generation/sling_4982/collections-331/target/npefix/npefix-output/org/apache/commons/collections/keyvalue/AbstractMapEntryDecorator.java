package org.apache.commons.collections.keyvalue;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.KeyValue;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public abstract class AbstractMapEntryDecorator<K, V> implements Map.Entry<K, V> , KeyValue<K, V> {
    protected final Map.Entry<K, V> entry;

    public AbstractMapEntryDecorator(Map.Entry<K, V> entry) {
        MethodContext _bcornu_methode_context277 = new MethodContext(null);
        try {
            if (entry == null) {
                throw new IllegalArgumentException("Map Entry must not be null");
            }
            this.entry = entry;
            CallChecker.varAssign(this.entry, "this.entry", 47, 1813, 1831);
        } finally {
            _bcornu_methode_context277.methodEnd();
        }
    }

    protected Map.Entry<K, V> getMapEntry() {
        MethodContext _bcornu_methode_context1484 = new MethodContext(Map.Entry.class);
        try {
            CallChecker.varInit(this, "this", 55, 1844, 2006);
            CallChecker.varInit(this.entry, "entry", 55, 1844, 2006);
            return entry;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1484.methodEnd();
        }
    }

    public K getKey() {
        if (CallChecker.beforeDeref(entry, Map.Entry.class, 61, 2126, 2130)) {
            return entry.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue() {
        if (CallChecker.beforeDeref(entry, Map.Entry.class, 65, 2190, 2194)) {
            return entry.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V setValue(V object) {
        if (CallChecker.beforeDeref(entry, Map.Entry.class, 69, 2264, 2268)) {
            return entry.setValue(object);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context1488 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 2302, 2461);
            CallChecker.varInit(object, "object", 73, 2302, 2461);
            CallChecker.varInit(this.entry, "entry", 73, 2302, 2461);
            if (object == (this)) {
                return true;
            }
            if (CallChecker.beforeDeref(entry, Map.Entry.class, 77, 2435, 2439)) {
                return CallChecker.isCalled(entry, Map.Entry.class, 77, 2435, 2439).equals(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1488.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1489 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 81, 2468, 2543);
            CallChecker.varInit(this.entry, "entry", 81, 2468, 2543);
            if (CallChecker.beforeDeref(entry, Map.Entry.class, 82, 2521, 2525)) {
                return CallChecker.isCalled(entry, Map.Entry.class, 82, 2521, 2525).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1489.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1490 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 86, 2550, 2628);
            CallChecker.varInit(this.entry, "entry", 86, 2550, 2628);
            if (CallChecker.beforeDeref(entry, Map.Entry.class, 87, 2606, 2610)) {
                return CallChecker.isCalled(entry, Map.Entry.class, 87, 2606, 2610).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1490.methodEnd();
        }
    }
}

