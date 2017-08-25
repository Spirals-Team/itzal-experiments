package org.apache.felix.framework.util;

import java.util.RandomAccess;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.AbstractList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class ImmutableList<E> extends AbstractList<E> implements RandomAccess {
    final Object[] elements;

    public static <E> ImmutableList<E> newInstance(E... elements) {
        MethodContext _bcornu_methode_context1098 = new MethodContext(ImmutableList.class);
        try {
            CallChecker.varInit(elements, "elements", 31, 1114, 1233);
            return new ImmutableList<E>(elements);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ImmutableList<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1098.methodEnd();
        }
    }

    public static <E> ImmutableList<E> newInstance(Collection<? extends E> elements) {
        MethodContext _bcornu_methode_context1099 = new MethodContext(ImmutableList.class);
        try {
            CallChecker.varInit(elements, "elements", 36, 1240, 1530);
            if (elements instanceof ImmutableList) {
                return ((ImmutableList<E>) (elements));
            }else {
                return new ImmutableList<E>(elements);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ImmutableList<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1099.methodEnd();
        }
    }

    protected ImmutableList(E... elements) {
        MethodContext _bcornu_methode_context114 = new MethodContext(null);
        try {
            elements = CallChecker.beforeCalled(elements, null, 50, 1606, 1613);
            this.elements = CallChecker.isCalled(elements, null, 50, 1606, 1613).clone();
            CallChecker.varAssign(this.elements, "this.elements", 50, 1590, 1622);
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    protected ImmutableList(Collection<? extends E> elements) {
        MethodContext _bcornu_methode_context115 = new MethodContext(null);
        try {
            elements = CallChecker.beforeCalled(elements, Collection.class, 55, 1723, 1730);
            this.elements = CallChecker.isCalled(elements, Collection.class, 55, 1723, 1730).toArray();
            CallChecker.varAssign(this.elements, "this.elements", 55, 1707, 1741);
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    public E get(int index) {
        if (CallChecker.beforeDeref(elements, Object[].class, 60, 1803, 1810)) {
            return ((E) (CallChecker.isCalled(elements, Object[].class, 60, 1803, 1810)[index]));
        }else
            throw new AbnormalExecutionError();
        
    }

    public int size() {
        MethodContext _bcornu_methode_context1101 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 63, 1831, 1891);
            CallChecker.varInit(this.elements, "elements", 63, 1831, 1891);
            if (CallChecker.beforeDeref(elements, Object[].class, 65, 1870, 1877)) {
                return CallChecker.isCalled(elements, Object[].class, 65, 1870, 1877).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1101.methodEnd();
        }
    }

    @Override
    public boolean remove(Object o) {
        MethodContext _bcornu_methode_context1102 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 69, 1898, 2005);
            CallChecker.varInit(o, "o", 69, 1898, 2005);
            CallChecker.varInit(this.elements, "elements", 69, 1898, 2005);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1102.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        MethodContext _bcornu_methode_context1103 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2012, 2133);
            CallChecker.varInit(clctn, "clctn", 75, 2012, 2133);
            CallChecker.varInit(this.elements, "elements", 75, 2012, 2133);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1103.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1104 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 81, 2144, 2239);
            CallChecker.varInit(this.elements, "elements", 81, 2144, 2239);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1104.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        MethodContext _bcornu_methode_context1105 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 87, 2250, 2378);
            CallChecker.varInit(c, "c", 87, 2250, 2378);
            CallChecker.varInit(this.elements, "elements", 87, 2250, 2378);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1105.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1106 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 93, 2385, 2470);
            CallChecker.varInit(this.elements, "elements", 93, 2385, 2470);
            return listIterator();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1106.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        MethodContext _bcornu_methode_context1107 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 99, 2477, 2583);
            CallChecker.varInit(index, "index", 99, 2477, 2583);
            CallChecker.varInit(this.elements, "elements", 99, 2477, 2583);
            return new ListItr(index);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1107.methodEnd();
        }
    }

    private class ListItr implements ListIterator<E> {
        int cursor;

        private ListItr(int cursor) {
            MethodContext _bcornu_methode_context116 = new MethodContext(null);
            try {
                this.cursor = cursor;
                CallChecker.varAssign(this.cursor, "this.cursor", 110, 2724, 2744);
            } finally {
                _bcornu_methode_context116.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context1108 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 113, 2765, 2845);
                CallChecker.varInit(this.cursor, "cursor", 113, 2765, 2845);
                return (cursor) != (size());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1108.methodEnd();
            }
        }

        public E next() {
            if (CallChecker.beforeDeref(elements, Object[].class, 120, 2905, 2912)) {
                return ((E) (CallChecker.isCalled(elements, Object[].class, 120, 2905, 2912)[((cursor)++)]));
            }else
                throw new AbnormalExecutionError();
            
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context1110 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 123, 2944, 3023);
                CallChecker.varInit(this.cursor, "cursor", 123, 2944, 3023);
                return (cursor) != 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1110.methodEnd();
            }
        }

        public E previous() {
            if (CallChecker.beforeDeref(elements, Object[].class, 130, 3087, 3094)) {
                return ((E) (CallChecker.isCalled(elements, Object[].class, 130, 3087, 3094)[(--(cursor))]));
            }else
                throw new AbnormalExecutionError();
            
        }

        public int nextIndex() {
            MethodContext _bcornu_methode_context1112 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 133, 3126, 3194);
                CallChecker.varInit(this.cursor, "cursor", 133, 3126, 3194);
                return cursor;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1112.methodEnd();
            }
        }

        public int previousIndex() {
            MethodContext _bcornu_methode_context1113 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 138, 3205, 3281);
                CallChecker.varInit(this.cursor, "cursor", 138, 3205, 3281);
                return (cursor) - 1;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1113.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context1114 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 143, 3292, 3386);
                CallChecker.varInit(this.cursor, "cursor", 143, 3292, 3386);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1114.methodEnd();
            }
        }

        public void set(E e) {
            MethodContext _bcornu_methode_context1115 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 148, 3397, 3491);
                CallChecker.varInit(e, "e", 148, 3397, 3491);
                CallChecker.varInit(this.cursor, "cursor", 148, 3397, 3491);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1115.methodEnd();
            }
        }

        public void add(E e) {
            MethodContext _bcornu_methode_context1116 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 153, 3502, 3596);
                CallChecker.varInit(e, "e", 153, 3502, 3596);
                CallChecker.varInit(this.cursor, "cursor", 153, 3502, 3596);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1116.methodEnd();
            }
        }
    }
}

