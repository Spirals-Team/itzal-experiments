package org.apache.commons.collections.iterators;

import org.apache.commons.collections.list.UnmodifiableList;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.List;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import java.util.BitSet;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;

public class CollatingIterator<E> implements Iterator<E> {
    private Comparator<? super E> comparator = null;

    private ArrayList<Iterator<? extends E>> iterators = null;

    private ArrayList<E> values = null;

    private BitSet valueSet = null;

    private int lastReturned = -1;

    public CollatingIterator() {
        this(null, 2);
        MethodContext _bcornu_methode_context40 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    public CollatingIterator(final Comparator<? super E> comp) {
        this(comp, 2);
        MethodContext _bcornu_methode_context41 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public CollatingIterator(final Comparator<? super E> comp, final int initIterCapacity) {
        MethodContext _bcornu_methode_context42 = new MethodContext(null);
        try {
            iterators = new ArrayList<Iterator<? extends E>>(initIterCapacity);
            CallChecker.varAssign(this.iterators, "this.iterators", 98, 3684, 3750);
            setComparator(comp);
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public CollatingIterator(final Comparator<? super E> comp, final Iterator<? extends E> a, final Iterator<? extends E> b) {
        this(comp, 2);
        MethodContext _bcornu_methode_context43 = new MethodContext(null);
        try {
            addIterator(a);
            addIterator(b);
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public CollatingIterator(final Comparator<? super E> comp, final Iterator<? extends E>[] iterators) {
        this(comp, CallChecker.isCalled(iterators, Iterator[].class, 130, 4965, 4973).length);
        MethodContext _bcornu_methode_context44 = new MethodContext(null);
        try {
            for (int i = 0; i < (CallChecker.isCalled(iterators, Iterator[].class, 131, 5012, 5020).length); i++) {
                if (CallChecker.beforeDeref(iterators, Iterator[].class, 132, 5061, 5069)) {
                    addIterator(CallChecker.isCalled(iterators, Iterator[].class, 132, 5061, 5069)[i]);
                }
            }
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public CollatingIterator(final Comparator<? super E> comp, final Collection<Iterator<? extends E>> iterators) {
        this(comp, CallChecker.isCalled(iterators, Collection.class, 150, 5777, 5785).size());
        MethodContext _bcornu_methode_context45 = new MethodContext(null);
        try {
            if (CallChecker.beforeDeref(iterators, null, 151, 5842, 5850)) {
                for (Iterator<? extends E> iterator : iterators) {
                    addIterator(iterator);
                }
            }
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public void addIterator(final Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context282 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 165, 5911, 6550);
            CallChecker.varInit(iterator, "iterator", 165, 5911, 6550);
            CallChecker.varInit(this.lastReturned, "lastReturned", 165, 5911, 6550);
            CallChecker.varInit(this.valueSet, "valueSet", 165, 5911, 6550);
            CallChecker.varInit(this.values, "values", 165, 5911, 6550);
            CallChecker.varInit(this.iterators, "iterators", 165, 5911, 6550);
            CallChecker.varInit(this.comparator, "comparator", 165, 5911, 6550);
            checkNotStarted();
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (CallChecker.beforeDeref(iterators, ArrayList.class, 170, 6521, 6529)) {
                iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 170, 6521, 6529);
                CallChecker.isCalled(iterators, ArrayList.class, 170, 6521, 6529).add(iterator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context282.methodEnd();
        }
    }

    public void setIterator(final int index, final Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context283 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 182, 6557, 7206);
            CallChecker.varInit(iterator, "iterator", 182, 6557, 7206);
            CallChecker.varInit(index, "index", 182, 6557, 7206);
            CallChecker.varInit(this.lastReturned, "lastReturned", 182, 6557, 7206);
            CallChecker.varInit(this.valueSet, "valueSet", 182, 6557, 7206);
            CallChecker.varInit(this.values, "values", 182, 6557, 7206);
            CallChecker.varInit(this.iterators, "iterators", 182, 6557, 7206);
            CallChecker.varInit(this.comparator, "comparator", 182, 6557, 7206);
            checkNotStarted();
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (CallChecker.beforeDeref(iterators, ArrayList.class, 187, 7170, 7178)) {
                iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 187, 7170, 7178);
                CallChecker.isCalled(iterators, ArrayList.class, 187, 7170, 7178).set(index, iterator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context283.methodEnd();
        }
    }

    public List<Iterator<? extends E>> getIterators() {
        MethodContext _bcornu_methode_context284 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 195, 7213, 7452);
            CallChecker.varInit(this.lastReturned, "lastReturned", 195, 7213, 7452);
            CallChecker.varInit(this.valueSet, "valueSet", 195, 7213, 7452);
            CallChecker.varInit(this.values, "values", 195, 7213, 7452);
            CallChecker.varInit(this.iterators, "iterators", 195, 7213, 7452);
            CallChecker.varInit(this.comparator, "comparator", 195, 7213, 7452);
            return UnmodifiableList.decorate(iterators);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Iterator<? extends E>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context284.methodEnd();
        }
    }

    public Comparator<? super E> getComparator() {
        MethodContext _bcornu_methode_context285 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 202, 7459, 7617);
            CallChecker.varInit(this.lastReturned, "lastReturned", 202, 7459, 7617);
            CallChecker.varInit(this.valueSet, "valueSet", 202, 7459, 7617);
            CallChecker.varInit(this.values, "values", 202, 7459, 7617);
            CallChecker.varInit(this.iterators, "iterators", 202, 7459, 7617);
            CallChecker.varInit(this.comparator, "comparator", 202, 7459, 7617);
            return comparator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context285.methodEnd();
        }
    }

    public void setComparator(final Comparator<? super E> comp) {
        MethodContext _bcornu_methode_context286 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 211, 7624, 7892);
            CallChecker.varInit(comp, "comp", 211, 7624, 7892);
            CallChecker.varInit(this.lastReturned, "lastReturned", 211, 7624, 7892);
            CallChecker.varInit(this.valueSet, "valueSet", 211, 7624, 7892);
            CallChecker.varInit(this.values, "values", 211, 7624, 7892);
            CallChecker.varInit(this.iterators, "iterators", 211, 7624, 7892);
            CallChecker.varInit(this.comparator, "comparator", 211, 7624, 7892);
            checkNotStarted();
            comparator = comp;
            CallChecker.varAssign(this.comparator, "this.comparator", 213, 7869, 7886);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context286.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context287 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 223, 7899, 8272);
            CallChecker.varInit(this.lastReturned, "lastReturned", 223, 7899, 8272);
            CallChecker.varInit(this.valueSet, "valueSet", 223, 7899, 8272);
            CallChecker.varInit(this.values, "values", 223, 7899, 8272);
            CallChecker.varInit(this.iterators, "iterators", 223, 7899, 8272);
            CallChecker.varInit(this.comparator, "comparator", 223, 7899, 8272);
            start();
            return (anyValueSet(valueSet)) || (anyHasNext(iterators));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context287.methodEnd();
        }
    }

    public E next() throws NoSuchElementException {
        if ((hasNext()) == false) {
            throw new NoSuchElementException();
        }
        int leastIndex = CallChecker.varInit(((int) (least())), "leastIndex", 238, 8635, 8659);
        if (leastIndex == (-1)) {
            throw new NoSuchElementException();
        }
        E val = CallChecker.init(null);
        if (CallChecker.beforeDeref(values, ArrayList.class, 242, 8767, 8772)) {
            val = values.get(leastIndex);
            CallChecker.varAssign(val, "val", 242, 8767, 8772);
        }
        clear(leastIndex);
        lastReturned = leastIndex;
        CallChecker.varAssign(this.lastReturned, "this.lastReturned", 244, 8826, 8851);
        return val;
    }

    public void remove() {
        MethodContext _bcornu_methode_context289 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 255, 8884, 9337);
            CallChecker.varInit(this.lastReturned, "lastReturned", 255, 8884, 9337);
            CallChecker.varInit(this.valueSet, "valueSet", 255, 8884, 9337);
            CallChecker.varInit(this.values, "values", 255, 8884, 9337);
            CallChecker.varInit(this.iterators, "iterators", 255, 8884, 9337);
            CallChecker.varInit(this.comparator, "comparator", 255, 8884, 9337);
            if ((lastReturned) == (-1)) {
                throw new IllegalStateException("No value can be removed at present");
            }
            if (CallChecker.beforeDeref(iterators, ArrayList.class, 259, 9295, 9303)) {
                iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 259, 9295, 9303);
                if (CallChecker.beforeDeref(CallChecker.isCalled(iterators, ArrayList.class, 259, 9295, 9303).get(lastReturned), Iterator.class, 259, 9295, 9321)) {
                    iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 259, 9295, 9303);
                    CallChecker.isCalled(CallChecker.isCalled(iterators, ArrayList.class, 259, 9295, 9303).get(lastReturned), Iterator.class, 259, 9295, 9321).remove();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context289.methodEnd();
        }
    }

    public int getIteratorIndex() {
        MethodContext _bcornu_methode_context290 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 268, 9344, 9784);
            CallChecker.varInit(this.lastReturned, "lastReturned", 268, 9344, 9784);
            CallChecker.varInit(this.valueSet, "valueSet", 268, 9344, 9784);
            CallChecker.varInit(this.values, "values", 268, 9344, 9784);
            CallChecker.varInit(this.iterators, "iterators", 268, 9344, 9784);
            CallChecker.varInit(this.comparator, "comparator", 268, 9344, 9784);
            if ((lastReturned) == (-1)) {
                throw new IllegalStateException("No value has been returned yet");
            }
            return lastReturned;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context290.methodEnd();
        }
    }

    private void start() {
        MethodContext _bcornu_methode_context291 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 281, 9795, 10292);
            CallChecker.varInit(this.lastReturned, "lastReturned", 281, 9795, 10292);
            CallChecker.varInit(this.valueSet, "valueSet", 281, 9795, 10292);
            CallChecker.varInit(this.values, "values", 281, 9795, 10292);
            CallChecker.varInit(this.iterators, "iterators", 281, 9795, 10292);
            CallChecker.varInit(this.comparator, "comparator", 281, 9795, 10292);
            if ((values) == null) {
                if (CallChecker.beforeDeref(iterators, ArrayList.class, 283, 10066, 10074)) {
                    iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 283, 10066, 10074);
                    values = new ArrayList<E>(CallChecker.isCalled(iterators, ArrayList.class, 283, 10066, 10074).size());
                    CallChecker.varAssign(this.values, "this.values", 283, 10040, 10083);
                }
                if (CallChecker.beforeDeref(iterators, ArrayList.class, 284, 10119, 10127)) {
                    iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 284, 10119, 10127);
                    valueSet = new BitSet(CallChecker.isCalled(iterators, ArrayList.class, 284, 10119, 10127).size());
                    CallChecker.varAssign(this.valueSet, "this.valueSet", 284, 10097, 10136);
                }
                iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 285, 10170, 10178);
                for (int i = 0; i < (CallChecker.isCalled(iterators, ArrayList.class, 285, 10170, 10178).size()); i++) {
                    if (CallChecker.beforeDeref(values, ArrayList.class, 286, 10211, 10216)) {
                        values = CallChecker.beforeCalled(values, ArrayList.class, 286, 10211, 10216);
                        CallChecker.isCalled(values, ArrayList.class, 286, 10211, 10216).add(null);
                    }
                    if (CallChecker.beforeDeref(valueSet, BitSet.class, 287, 10245, 10252)) {
                        valueSet = CallChecker.beforeCalled(valueSet, BitSet.class, 287, 10245, 10252);
                        CallChecker.isCalled(valueSet, BitSet.class, 287, 10245, 10252).clear(i);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context291.methodEnd();
        }
    }

    private boolean set(int i) {
        MethodContext _bcornu_methode_context292 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 300, 10299, 10930);
            CallChecker.varInit(i, "i", 300, 10299, 10930);
            CallChecker.varInit(this.lastReturned, "lastReturned", 300, 10299, 10930);
            CallChecker.varInit(this.valueSet, "valueSet", 300, 10299, 10930);
            CallChecker.varInit(this.values, "values", 300, 10299, 10930);
            CallChecker.varInit(this.iterators, "iterators", 300, 10299, 10930);
            CallChecker.varInit(this.comparator, "comparator", 300, 10299, 10930);
            Iterator<? extends E> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(iterators, ArrayList.class, 301, 10700, 10708)) {
                iterators = CallChecker.beforeCalled(iterators, ArrayList.class, 301, 10700, 10708);
                it = CallChecker.isCalled(iterators, ArrayList.class, 301, 10700, 10708).get(i);
                CallChecker.varAssign(it, "it", 301, 10700, 10708);
            }
            if (CallChecker.beforeDeref(it, Iterator.class, 302, 10730, 10731)) {
                it = CallChecker.beforeCalled(it, Iterator.class, 302, 10730, 10731);
                if (CallChecker.isCalled(it, Iterator.class, 302, 10730, 10731).hasNext()) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 303, 10772, 10773)) {
                        if (CallChecker.beforeDeref(values, ArrayList.class, 303, 10758, 10763)) {
                            values.set(i, it.next());
                        }
                    }
                    if (CallChecker.beforeDeref(valueSet, BitSet.class, 304, 10796, 10803)) {
                        valueSet = CallChecker.beforeCalled(valueSet, BitSet.class, 304, 10796, 10803);
                        CallChecker.isCalled(valueSet, BitSet.class, 304, 10796, 10803).set(i);
                    }
                    return true;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(values, ArrayList.class, 307, 10856, 10861)) {
                values.set(i, null);
            }
            if (CallChecker.beforeDeref(valueSet, BitSet.class, 308, 10885, 10892)) {
                valueSet = CallChecker.beforeCalled(valueSet, BitSet.class, 308, 10885, 10892);
                CallChecker.isCalled(valueSet, BitSet.class, 308, 10885, 10892).clear(i);
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context292.methodEnd();
        }
    }

    private void clear(int i) {
        MethodContext _bcornu_methode_context293 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 316, 10937, 11137);
            CallChecker.varInit(i, "i", 316, 10937, 11137);
            CallChecker.varInit(this.lastReturned, "lastReturned", 316, 10937, 11137);
            CallChecker.varInit(this.valueSet, "valueSet", 316, 10937, 11137);
            CallChecker.varInit(this.values, "values", 316, 10937, 11137);
            CallChecker.varInit(this.iterators, "iterators", 316, 10937, 11137);
            CallChecker.varInit(this.comparator, "comparator", 316, 10937, 11137);
            if (CallChecker.beforeDeref(values, ArrayList.class, 317, 11085, 11090)) {
                values.set(i, null);
            }
            if (CallChecker.beforeDeref(valueSet, BitSet.class, 318, 11114, 11121)) {
                valueSet = CallChecker.beforeCalled(valueSet, BitSet.class, 318, 11114, 11121);
                CallChecker.isCalled(valueSet, BitSet.class, 318, 11114, 11121).clear(i);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context293.methodEnd();
        }
    }

    private void checkNotStarted() throws IllegalStateException {
        MethodContext _bcornu_methode_context294 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 327, 11144, 11529);
            CallChecker.varInit(this.lastReturned, "lastReturned", 327, 11144, 11529);
            CallChecker.varInit(this.valueSet, "valueSet", 327, 11144, 11529);
            CallChecker.varInit(this.values, "values", 327, 11144, 11529);
            CallChecker.varInit(this.iterators, "iterators", 327, 11144, 11529);
            CallChecker.varInit(this.comparator, "comparator", 327, 11144, 11529);
            if ((values) != null) {
                throw new IllegalStateException("Can't do that after next or hasNext has been called.");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context294.methodEnd();
        }
    }

    private int least() {
        MethodContext _bcornu_methode_context295 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 339, 11536, 12427);
            CallChecker.varInit(this.lastReturned, "lastReturned", 339, 11536, 12427);
            CallChecker.varInit(this.valueSet, "valueSet", 339, 11536, 12427);
            CallChecker.varInit(this.values, "values", 339, 11536, 12427);
            CallChecker.varInit(this.iterators, "iterators", 339, 11536, 12427);
            CallChecker.varInit(this.comparator, "comparator", 339, 11536, 12427);
            int leastIndex = CallChecker.varInit(((int) (-1)), "leastIndex", 340, 11752, 11771);
            E leastObject = CallChecker.varInit(null, "leastObject", 341, 11781, 11801);
            values = CallChecker.beforeCalled(values, ArrayList.class, 342, 11831, 11836);
            for (int i = 0; i < (CallChecker.isCalled(values, ArrayList.class, 342, 11831, 11836).size()); i++) {
                if (CallChecker.beforeDeref(valueSet, BitSet.class, 343, 11869, 11876)) {
                    valueSet = CallChecker.beforeCalled(valueSet, BitSet.class, 343, 11869, 11876);
                    if ((CallChecker.isCalled(valueSet, BitSet.class, 343, 11869, 11876).get(i)) == false) {
                        set(i);
                    }
                }
                if (CallChecker.beforeDeref(valueSet, BitSet.class, 346, 11951, 11958)) {
                    valueSet = CallChecker.beforeCalled(valueSet, BitSet.class, 346, 11951, 11958);
                    if (CallChecker.isCalled(valueSet, BitSet.class, 346, 11951, 11958).get(i)) {
                        if (leastIndex == (-1)) {
                            leastIndex = i;
                            CallChecker.varAssign(leastIndex, "leastIndex", 348, 12030, 12044);
                            if (CallChecker.beforeDeref(values, ArrayList.class, 349, 12080, 12085)) {
                                leastObject = values.get(i);
                                CallChecker.varAssign(leastObject, "leastObject", 349, 12066, 12093);
                            }
                        }else {
                            E curObject = CallChecker.init(null);
                            if (CallChecker.beforeDeref(values, ArrayList.class, 351, 12154, 12159)) {
                                curObject = values.get(i);
                                CallChecker.varAssign(curObject, "curObject", 351, 12154, 12159);
                            }
                            if (CallChecker.beforeDeref(comparator, Comparator.class, 352, 12193, 12202)) {
                                comparator = CallChecker.beforeCalled(comparator, Comparator.class, 352, 12193, 12202);
                                if ((CallChecker.isCalled(comparator, Comparator.class, 352, 12193, 12202).compare(curObject, leastObject)) < 0) {
                                    leastObject = curObject;
                                    CallChecker.varAssign(leastObject, "leastObject", 353, 12267, 12290);
                                    leastIndex = i;
                                    CallChecker.varAssign(leastIndex, "leastIndex", 354, 12316, 12330);
                                }
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return leastIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context295.methodEnd();
        }
    }

    private boolean anyValueSet(BitSet set) {
        MethodContext _bcornu_methode_context296 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 366, 12434, 12739);
            CallChecker.varInit(set, "set", 366, 12434, 12739);
            CallChecker.varInit(this.lastReturned, "lastReturned", 366, 12434, 12739);
            CallChecker.varInit(this.valueSet, "valueSet", 366, 12434, 12739);
            CallChecker.varInit(this.values, "values", 366, 12434, 12739);
            CallChecker.varInit(this.iterators, "iterators", 366, 12434, 12739);
            CallChecker.varInit(this.comparator, "comparator", 366, 12434, 12739);
            set = CallChecker.beforeCalled(set, BitSet.class, 367, 12611, 12613);
            for (int i = 0; i < (CallChecker.isCalled(set, BitSet.class, 367, 12611, 12613).size()); i++) {
                if (CallChecker.beforeDeref(set, BitSet.class, 368, 12646, 12648)) {
                    set = CallChecker.beforeCalled(set, BitSet.class, 368, 12646, 12648);
                    if (CallChecker.isCalled(set, BitSet.class, 368, 12646, 12648).get(i)) {
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context296.methodEnd();
        }
    }

    private boolean anyHasNext(ArrayList<Iterator<? extends E>> iters) {
        MethodContext _bcornu_methode_context297 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 379, 12746, 13104);
            CallChecker.varInit(iters, "iters", 379, 12746, 13104);
            CallChecker.varInit(this.lastReturned, "lastReturned", 379, 12746, 13104);
            CallChecker.varInit(this.valueSet, "valueSet", 379, 12746, 13104);
            CallChecker.varInit(this.values, "values", 379, 12746, 13104);
            CallChecker.varInit(this.iterators, "iterators", 379, 12746, 13104);
            CallChecker.varInit(this.comparator, "comparator", 379, 12746, 13104);
            if (CallChecker.beforeDeref(iters, boolean.class, 380, 12978, 12982)) {
                for (Iterator<? extends E> iterator : iters) {
                    if (CallChecker.beforeDeref(iterator, Iterator.class, 381, 13003, 13010)) {
                        if (CallChecker.isCalled(iterator, Iterator.class, 381, 13003, 13010).hasNext()) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context297.methodEnd();
        }
    }
}

