package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class ShrinkableCollection<T> implements Collection<T> {
    private final Collection<T> m_delegate;

    public ShrinkableCollection(Collection<T> delegate) {
        MethodContext _bcornu_methode_context23 = new MethodContext(null);
        try {
            m_delegate = delegate;
            CallChecker.varAssign(this.m_delegate, "this.m_delegate", 33, 1170, 1191);
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public boolean add(T o) {
        MethodContext _bcornu_methode_context331 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 36, 1204, 1289);
            CallChecker.varInit(o, "o", 36, 1204, 1289);
            CallChecker.varInit(this.m_delegate, "m_delegate", 36, 1204, 1289);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context331.methodEnd();
        }
    }

    public boolean addAll(Collection<? extends T> c) {
        MethodContext _bcornu_methode_context332 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 41, 1296, 1406);
            CallChecker.varInit(c, "c", 41, 1296, 1406);
            CallChecker.varInit(this.m_delegate, "m_delegate", 41, 1296, 1406);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context332.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context333 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 46, 1413, 1471);
            CallChecker.varInit(this.m_delegate, "m_delegate", 46, 1413, 1471);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 48, 1447, 1456)) {
                CallChecker.isCalled(m_delegate, Collection.class, 48, 1447, 1456).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context333.methodEnd();
        }
    }

    public boolean contains(Object o) {
        MethodContext _bcornu_methode_context334 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 51, 1478, 1561);
            CallChecker.varInit(o, "o", 51, 1478, 1561);
            CallChecker.varInit(this.m_delegate, "m_delegate", 51, 1478, 1561);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 53, 1533, 1542)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 53, 1533, 1542).contains(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context334.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> c) {
        MethodContext _bcornu_methode_context335 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 56, 1568, 1664);
            CallChecker.varInit(c, "c", 56, 1568, 1664);
            CallChecker.varInit(this.m_delegate, "m_delegate", 56, 1568, 1664);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 58, 1633, 1642)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 58, 1633, 1642).containsAll(c);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context335.methodEnd();
        }
    }

    @Override
    public boolean equals(Object o) {
        MethodContext _bcornu_methode_context336 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 62, 1671, 1764);
            CallChecker.varInit(o, "o", 62, 1671, 1764);
            CallChecker.varInit(this.m_delegate, "m_delegate", 62, 1671, 1764);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 64, 1738, 1747)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 64, 1738, 1747).equals(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context336.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context337 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 68, 1771, 1855);
            CallChecker.varInit(this.m_delegate, "m_delegate", 68, 1771, 1855);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 70, 1828, 1837)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 70, 1828, 1837).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context337.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context338 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 1862, 1934);
            CallChecker.varInit(this.m_delegate, "m_delegate", 73, 1862, 1934);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 75, 1908, 1917)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 75, 1908, 1917).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context338.methodEnd();
        }
    }

    public Iterator iterator() {
        MethodContext _bcornu_methode_context339 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 78, 1941, 2016);
            CallChecker.varInit(this.m_delegate, "m_delegate", 78, 1941, 2016);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 80, 1989, 1998)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 80, 1989, 1998).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context339.methodEnd();
        }
    }

    public boolean remove(Object o) {
        MethodContext _bcornu_methode_context340 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 83, 2023, 2102);
            CallChecker.varInit(o, "o", 83, 2023, 2102);
            CallChecker.varInit(this.m_delegate, "m_delegate", 83, 2023, 2102);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 85, 2076, 2085)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 85, 2076, 2085).remove(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context340.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> c) {
        MethodContext _bcornu_methode_context341 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 88, 2109, 2201);
            CallChecker.varInit(c, "c", 88, 2109, 2201);
            CallChecker.varInit(this.m_delegate, "m_delegate", 88, 2109, 2201);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 90, 2172, 2181)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 90, 2172, 2181).removeAll(c);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context341.methodEnd();
        }
    }

    public boolean retainAll(Collection<?> c) {
        MethodContext _bcornu_methode_context342 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 93, 2208, 2300);
            CallChecker.varInit(c, "c", 93, 2208, 2300);
            CallChecker.varInit(this.m_delegate, "m_delegate", 93, 2208, 2300);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 95, 2271, 2280)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 95, 2271, 2280).retainAll(c);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context342.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context343 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 98, 2307, 2369);
            CallChecker.varInit(this.m_delegate, "m_delegate", 98, 2307, 2369);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 100, 2346, 2355)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 100, 2346, 2355).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context343.methodEnd();
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context344 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 103, 2376, 2449);
            CallChecker.varInit(this.m_delegate, "m_delegate", 103, 2376, 2449);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 105, 2423, 2432)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 105, 2423, 2432).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context344.methodEnd();
        }
    }

    public <A> A[] toArray(A[] a) {
        MethodContext _bcornu_methode_context345 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 108, 2456, 2534);
            CallChecker.varInit(a, "a", 108, 2456, 2534);
            CallChecker.varInit(this.m_delegate, "m_delegate", 108, 2456, 2534);
            if (CallChecker.beforeDeref(m_delegate, Collection.class, 110, 2507, 2516)) {
                return CallChecker.isCalled(m_delegate, Collection.class, 110, 2507, 2516).toArray(a);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((A[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context345.methodEnd();
        }
    }
}

