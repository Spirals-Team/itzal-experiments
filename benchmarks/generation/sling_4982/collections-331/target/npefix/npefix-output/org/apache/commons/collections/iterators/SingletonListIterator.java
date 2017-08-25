package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class SingletonListIterator<E> implements ListIterator<E> , ResettableListIterator<E> {
    private boolean beforeFirst = true;

    private boolean nextCalled = false;

    private boolean removed = false;

    private E object;

    public SingletonListIterator(E object) {
        super();
        MethodContext _bcornu_methode_context254 = new MethodContext(null);
        try {
            this.object = object;
            CallChecker.varAssign(this.object, "this.object", 48, 1736, 1756);
        } finally {
            _bcornu_methode_context254.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1279 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 58, 1769, 2067);
            CallChecker.varInit(this.object, "object", 58, 1769, 2067);
            CallChecker.varInit(this.removed, "removed", 58, 1769, 2067);
            CallChecker.varInit(this.nextCalled, "nextCalled", 58, 1769, 2067);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 58, 1769, 2067);
            return (beforeFirst) && (!(removed));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1279.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context1280 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 69, 2074, 2366);
            CallChecker.varInit(this.object, "object", 69, 2074, 2366);
            CallChecker.varInit(this.removed, "removed", 69, 2074, 2366);
            CallChecker.varInit(this.nextCalled, "nextCalled", 69, 2074, 2366);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 69, 2074, 2366);
            return (!(beforeFirst)) && (!(removed));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1280.methodEnd();
        }
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context1281 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 79, 2373, 2623);
            CallChecker.varInit(this.object, "object", 79, 2373, 2623);
            CallChecker.varInit(this.removed, "removed", 79, 2373, 2623);
            CallChecker.varInit(this.nextCalled, "nextCalled", 79, 2373, 2623);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 79, 2373, 2623);
            if (beforeFirst) {
                return 0;
            }else {
                return 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1281.methodEnd();
        }
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context1282 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 90, 2630, 2973);
            CallChecker.varInit(this.object, "object", 90, 2630, 2973);
            CallChecker.varInit(this.removed, "removed", 90, 2630, 2973);
            CallChecker.varInit(this.nextCalled, "nextCalled", 90, 2630, 2973);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 90, 2630, 2973);
            if (beforeFirst) {
                return -1;
            }else {
                return 0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1282.methodEnd();
        }
    }

    public E next() {
        if ((!(beforeFirst)) || (removed)) {
            throw new NoSuchElementException();
        }
        beforeFirst = false;
        CallChecker.varAssign(this.beforeFirst, "this.beforeFirst", 107, 3382, 3401);
        nextCalled = true;
        CallChecker.varAssign(this.nextCalled, "this.nextCalled", 108, 3411, 3428);
        return object;
    }

    public E previous() {
        if ((beforeFirst) || (removed)) {
            throw new NoSuchElementException();
        }
        beforeFirst = true;
        CallChecker.varAssign(this.beforeFirst, "this.beforeFirst", 125, 3870, 3888);
        return object;
    }

    public void remove() {
        MethodContext _bcornu_methode_context1285 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 136, 3924, 4446);
            CallChecker.varInit(this.object, "object", 136, 3924, 4446);
            CallChecker.varInit(this.removed, "removed", 136, 3924, 4446);
            CallChecker.varInit(this.nextCalled, "nextCalled", 136, 3924, 4446);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 136, 3924, 4446);
            if ((!(nextCalled)) || (removed)) {
                throw new IllegalStateException();
            }else {
                object = null;
                CallChecker.varAssign(this.object, "this.object", 140, 4389, 4402);
                removed = true;
                CallChecker.varAssign(this.removed, "this.removed", 141, 4416, 4430);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1285.methodEnd();
        }
    }

    public void add(E obj) {
        MethodContext _bcornu_methode_context1286 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 150, 4457, 4717);
            CallChecker.varInit(obj, "obj", 150, 4457, 4717);
            CallChecker.varInit(this.object, "object", 150, 4457, 4717);
            CallChecker.varInit(this.removed, "removed", 150, 4457, 4717);
            CallChecker.varInit(this.nextCalled, "nextCalled", 150, 4457, 4717);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 150, 4457, 4717);
            throw new UnsupportedOperationException("add() is not supported by this iterator");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1286.methodEnd();
        }
    }

    public void set(E obj) {
        MethodContext _bcornu_methode_context1287 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 161, 4728, 5105);
            CallChecker.varInit(obj, "obj", 161, 4728, 5105);
            CallChecker.varInit(this.object, "object", 161, 4728, 5105);
            CallChecker.varInit(this.removed, "removed", 161, 4728, 5105);
            CallChecker.varInit(this.nextCalled, "nextCalled", 161, 4728, 5105);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 161, 4728, 5105);
            if ((!(nextCalled)) || (removed)) {
                throw new IllegalStateException();
            }
            this.object = obj;
            CallChecker.varAssign(this.object, "this.object", 165, 5082, 5099);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1287.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context1288 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 171, 5116, 5259);
            CallChecker.varInit(this.object, "object", 171, 5116, 5259);
            CallChecker.varInit(this.removed, "removed", 171, 5116, 5259);
            CallChecker.varInit(this.nextCalled, "nextCalled", 171, 5116, 5259);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 171, 5116, 5259);
            beforeFirst = true;
            CallChecker.varAssign(this.beforeFirst, "this.beforeFirst", 172, 5207, 5225);
            nextCalled = false;
            CallChecker.varAssign(this.nextCalled, "this.nextCalled", 173, 5235, 5253);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1288.methodEnd();
        }
    }
}

