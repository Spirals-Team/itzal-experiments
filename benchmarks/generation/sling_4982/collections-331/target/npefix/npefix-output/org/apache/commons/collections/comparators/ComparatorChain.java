package org.apache.commons.collections.comparators;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import java.util.BitSet;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;

public class ComparatorChain<E> implements Serializable , Comparator<E> {
    private static final long serialVersionUID = -721644942746081630L;

    protected List<Comparator<E>> comparatorChain = null;

    protected BitSet orderingBits = null;

    protected boolean isLocked = false;

    public ComparatorChain() {
        this(new ArrayList<Comparator<E>>(), new BitSet());
        MethodContext _bcornu_methode_context478 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context478.methodEnd();
        }
    }

    public ComparatorChain(Comparator<E> comparator) {
        this(comparator, false);
        MethodContext _bcornu_methode_context479 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context479.methodEnd();
        }
    }

    public ComparatorChain(Comparator<E> comparator, boolean reverse) {
        MethodContext _bcornu_methode_context480 = new MethodContext(null);
        try {
            comparatorChain = new ArrayList<Comparator<E>>(1);
            CallChecker.varAssign(this.comparatorChain, "this.comparatorChain", 98, 3871, 3920);
            if (CallChecker.beforeDeref(comparatorChain, List.class, 99, 3930, 3944)) {
                comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 99, 3930, 3944);
                CallChecker.isCalled(comparatorChain, List.class, 99, 3930, 3944).add(comparator);
            }
            orderingBits = new BitSet(1);
            CallChecker.varAssign(this.orderingBits, "this.orderingBits", 100, 3971, 3999);
            if (reverse == true) {
                if (CallChecker.beforeDeref(orderingBits, BitSet.class, 102, 4044, 4055)) {
                    orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 102, 4044, 4055);
                    CallChecker.isCalled(orderingBits, BitSet.class, 102, 4044, 4055).set(0);
                }
            }
        } finally {
            _bcornu_methode_context480.methodEnd();
        }
    }

    public ComparatorChain(List<Comparator<E>> list) {
        this(list, new BitSet(CallChecker.isCalled(list, List.class, 115, 4413, 4416).size()));
        MethodContext _bcornu_methode_context481 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context481.methodEnd();
        }
    }

    public ComparatorChain(List<Comparator<E>> list, BitSet bits) {
        MethodContext _bcornu_methode_context482 = new MethodContext(null);
        try {
            comparatorChain = list;
            CallChecker.varAssign(this.comparatorChain, "this.comparatorChain", 134, 5272, 5294);
            orderingBits = bits;
            CallChecker.varAssign(this.orderingBits, "this.orderingBits", 135, 5304, 5323);
        } finally {
            _bcornu_methode_context482.methodEnd();
        }
    }

    public void addComparator(Comparator<E> comparator) {
        MethodContext _bcornu_methode_context2567 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 145, 5336, 5685);
            CallChecker.varInit(comparator, "comparator", 145, 5336, 5685);
            CallChecker.varInit(this.isLocked, "isLocked", 145, 5336, 5685);
            CallChecker.varInit(this.orderingBits, "orderingBits", 145, 5336, 5685);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 145, 5336, 5685);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 145, 5336, 5685);
            addComparator(comparator, false);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2567.methodEnd();
        }
    }

    public void addComparator(Comparator<E> comparator, boolean reverse) {
        MethodContext _bcornu_methode_context2568 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 156, 5692, 6182);
            CallChecker.varInit(reverse, "reverse", 156, 5692, 6182);
            CallChecker.varInit(comparator, "comparator", 156, 5692, 6182);
            CallChecker.varInit(this.isLocked, "isLocked", 156, 5692, 6182);
            CallChecker.varInit(this.orderingBits, "orderingBits", 156, 5692, 6182);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 156, 5692, 6182);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 156, 5692, 6182);
            checkLocked();
            if (CallChecker.beforeDeref(comparatorChain, List.class, 159, 6046, 6060)) {
                comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 159, 6046, 6060);
                CallChecker.isCalled(comparatorChain, List.class, 159, 6046, 6060).add(comparator);
            }
            if (reverse == true) {
                if (CallChecker.beforeDeref(comparatorChain, List.class, 161, 6139, 6153)) {
                    if (CallChecker.beforeDeref(orderingBits, BitSet.class, 161, 6122, 6133)) {
                        comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 161, 6139, 6153);
                        orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 161, 6122, 6133);
                        CallChecker.isCalled(orderingBits, BitSet.class, 161, 6122, 6133).set(((CallChecker.isCalled(comparatorChain, List.class, 161, 6139, 6153).size()) - 1));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2568.methodEnd();
        }
    }

    public void setComparator(int index, Comparator<E> comparator) throws IndexOutOfBoundsException {
        MethodContext _bcornu_methode_context2569 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 174, 6189, 6688);
            CallChecker.varInit(comparator, "comparator", 174, 6189, 6688);
            CallChecker.varInit(index, "index", 174, 6189, 6688);
            CallChecker.varInit(this.isLocked, "isLocked", 174, 6189, 6688);
            CallChecker.varInit(this.orderingBits, "orderingBits", 174, 6189, 6688);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 174, 6189, 6688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 174, 6189, 6688);
            setComparator(index, comparator, false);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2569.methodEnd();
        }
    }

    public void setComparator(int index, Comparator<E> comparator, boolean reverse) {
        MethodContext _bcornu_methode_context2570 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 186, 6695, 7298);
            CallChecker.varInit(reverse, "reverse", 186, 6695, 7298);
            CallChecker.varInit(comparator, "comparator", 186, 6695, 7298);
            CallChecker.varInit(index, "index", 186, 6695, 7298);
            CallChecker.varInit(this.isLocked, "isLocked", 186, 6695, 7298);
            CallChecker.varInit(this.orderingBits, "orderingBits", 186, 6695, 7298);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 186, 6695, 7298);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 186, 6695, 7298);
            checkLocked();
            if (CallChecker.beforeDeref(comparatorChain, List.class, 189, 7121, 7135)) {
                comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 189, 7121, 7135);
                CallChecker.isCalled(comparatorChain, List.class, 189, 7121, 7135).set(index, comparator);
            }
            if (reverse == true) {
                if (CallChecker.beforeDeref(orderingBits, BitSet.class, 191, 7203, 7214)) {
                    orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 191, 7203, 7214);
                    CallChecker.isCalled(orderingBits, BitSet.class, 191, 7203, 7214).set(index);
                }
            }else {
                if (CallChecker.beforeDeref(orderingBits, BitSet.class, 193, 7257, 7268)) {
                    orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 193, 7257, 7268);
                    CallChecker.isCalled(orderingBits, BitSet.class, 193, 7257, 7268).clear(index);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2570.methodEnd();
        }
    }

    public void setForwardSort(int index) {
        MethodContext _bcornu_methode_context2571 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 203, 7305, 7577);
            CallChecker.varInit(index, "index", 203, 7305, 7577);
            CallChecker.varInit(this.isLocked, "isLocked", 203, 7305, 7577);
            CallChecker.varInit(this.orderingBits, "orderingBits", 203, 7305, 7577);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 203, 7305, 7577);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 203, 7305, 7577);
            checkLocked();
            if (CallChecker.beforeDeref(orderingBits, BitSet.class, 205, 7546, 7557)) {
                orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 205, 7546, 7557);
                CallChecker.isCalled(orderingBits, BitSet.class, 205, 7546, 7557).clear(index);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2571.methodEnd();
        }
    }

    public void setReverseSort(int index) {
        MethodContext _bcornu_methode_context2572 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 214, 7584, 7854);
            CallChecker.varInit(index, "index", 214, 7584, 7854);
            CallChecker.varInit(this.isLocked, "isLocked", 214, 7584, 7854);
            CallChecker.varInit(this.orderingBits, "orderingBits", 214, 7584, 7854);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 214, 7584, 7854);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 214, 7584, 7854);
            checkLocked();
            if (CallChecker.beforeDeref(orderingBits, BitSet.class, 216, 7825, 7836)) {
                orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 216, 7825, 7836);
                CallChecker.isCalled(orderingBits, BitSet.class, 216, 7825, 7836).set(index);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2572.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context2573 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 224, 7861, 8040);
            CallChecker.varInit(this.isLocked, "isLocked", 224, 7861, 8040);
            CallChecker.varInit(this.orderingBits, "orderingBits", 224, 7861, 8040);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 224, 7861, 8040);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 224, 7861, 8040);
            if (CallChecker.beforeDeref(comparatorChain, List.class, 225, 8012, 8026)) {
                comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 225, 8012, 8026);
                return CallChecker.isCalled(comparatorChain, List.class, 225, 8012, 8026).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2573.methodEnd();
        }
    }

    public boolean isLocked() {
        MethodContext _bcornu_methode_context2574 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 236, 8047, 8413);
            CallChecker.varInit(this.isLocked, "isLocked", 236, 8047, 8413);
            CallChecker.varInit(this.orderingBits, "orderingBits", 236, 8047, 8413);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 236, 8047, 8413);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 236, 8047, 8413);
            return isLocked;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2574.methodEnd();
        }
    }

    private void checkLocked() {
        MethodContext _bcornu_methode_context2575 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 241, 8420, 8688);
            CallChecker.varInit(this.isLocked, "isLocked", 241, 8420, 8688);
            CallChecker.varInit(this.orderingBits, "orderingBits", 241, 8420, 8688);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 241, 8420, 8688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 241, 8420, 8688);
            if ((isLocked) == true) {
                throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2575.methodEnd();
        }
    }

    private void checkChainIntegrity() {
        MethodContext _bcornu_methode_context2576 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 247, 8695, 8899);
            CallChecker.varInit(this.isLocked, "isLocked", 247, 8695, 8899);
            CallChecker.varInit(this.orderingBits, "orderingBits", 247, 8695, 8899);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 247, 8695, 8899);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 247, 8695, 8899);
            if (CallChecker.beforeDeref(comparatorChain, List.class, 248, 8744, 8758)) {
                comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 248, 8744, 8758);
                if ((CallChecker.isCalled(comparatorChain, List.class, 248, 8744, 8758).size()) == 0) {
                    throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2576.methodEnd();
        }
    }

    public int compare(E o1, E o2) throws UnsupportedOperationException {
        MethodContext _bcornu_methode_context2577 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 265, 8906, 10368);
            CallChecker.varInit(o2, "o2", 265, 8906, 10368);
            CallChecker.varInit(o1, "o1", 265, 8906, 10368);
            CallChecker.varInit(this.isLocked, "isLocked", 265, 8906, 10368);
            CallChecker.varInit(this.orderingBits, "orderingBits", 265, 8906, 10368);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 265, 8906, 10368);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 265, 8906, 10368);
            if ((isLocked) == false) {
                checkChainIntegrity();
                isLocked = true;
                CallChecker.varAssign(this.isLocked, "this.isLocked", 268, 9522, 9537);
            }
            Iterator<Comparator<E>> comparators = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(comparatorChain, List.class, 272, 9649, 9663)) {
                comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 272, 9649, 9663);
                comparators = CallChecker.isCalled(comparatorChain, List.class, 272, 9649, 9663).iterator();
                CallChecker.varAssign(comparators, "comparators", 272, 9649, 9663);
            }
            comparators = CallChecker.beforeCalled(comparators, Iterator.class, 273, 9715, 9725);
            for (int comparatorIndex = 0; CallChecker.isCalled(comparators, Iterator.class, 273, 9715, 9725).hasNext(); ++comparatorIndex) {
                Comparator<E> comparator = CallChecker.init(Comparator.class);
                if (CallChecker.beforeDeref(comparators, Iterator.class, 275, 9799, 9809)) {
                    comparators = CallChecker.beforeCalled(comparators, Iterator.class, 275, 9799, 9809);
                    comparator = CallChecker.isCalled(comparators, Iterator.class, 275, 9799, 9809).next();
                    CallChecker.varAssign(comparator, "comparator", 275, 9799, 9809);
                }
                int retval = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(comparator, Comparator.class, 276, 9844, 9853)) {
                    comparator = CallChecker.beforeCalled(comparator, Comparator.class, 276, 9844, 9853);
                    retval = CallChecker.isCalled(comparator, Comparator.class, 276, 9844, 9853).compare(o1, o2);
                    CallChecker.varAssign(retval, "retval", 276, 9844, 9853);
                }
                if (retval != 0) {
                    if (CallChecker.beforeDeref(orderingBits, BitSet.class, 279, 9982, 9993)) {
                        orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 279, 9982, 9993);
                        if ((CallChecker.isCalled(orderingBits, BitSet.class, 279, 9982, 9993).get(comparatorIndex)) == true) {
                            if ((Integer.MIN_VALUE) == retval) {
                                retval = Integer.MAX_VALUE;
                                CallChecker.varAssign(retval, "retval", 281, 10105, 10131);
                            }else {
                                retval *= -1;
                                CallChecker.varAssign(retval, "retval", 283, 10186, 10198);
                            }
                        }
                    }
                    return retval;
                }
            }
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2577.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2578 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 303, 10375, 10935);
            CallChecker.varInit(this.isLocked, "isLocked", 303, 10375, 10935);
            CallChecker.varInit(this.orderingBits, "orderingBits", 303, 10375, 10935);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 303, 10375, 10935);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 303, 10375, 10935);
            int hash = CallChecker.varInit(((int) (0)), "hash", 304, 10708, 10720);
            if (null != (comparatorChain)) {
                hash ^= comparatorChain.hashCode();
                CallChecker.varAssign(hash, "hash", 306, 10773, 10807);
            }
            if (null != (orderingBits)) {
                hash ^= orderingBits.hashCode();
                CallChecker.varAssign(hash, "hash", 309, 10867, 10898);
            }
            return hash;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2578.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context2579 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 331, 10942, 12220);
            CallChecker.varInit(object, "object", 331, 10942, 12220);
            CallChecker.varInit(this.isLocked, "isLocked", 331, 10942, 12220);
            CallChecker.varInit(this.orderingBits, "orderingBits", 331, 10942, 12220);
            CallChecker.varInit(this.comparatorChain, "comparatorChain", 331, 10942, 12220);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.comparators.ComparatorChain.serialVersionUID", 331, 10942, 12220);
            if ((this) == object) {
                return true;
            }
            if (null == object) {
                return false;
            }
            object = CallChecker.beforeCalled(object, Object.class, 338, 11805, 11810);
            if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 338, 11805, 11810).getClass(), Class.class, 338, 11805, 11821)) {
                if (CallChecker.isCalled(object.getClass(), Class.class, 338, 11805, 11821).equals(this.getClass())) {
                    ComparatorChain<?> chain = CallChecker.varInit(((ComparatorChain<?>) (object)), "chain", 339, 11862, 11916);
                    if (CallChecker.beforeDeref(chain, ComparatorChain.class, 341, 12032, 12036)) {
                        if ((null == (orderingBits)) || (CallChecker.beforeDeref(orderingBits, BitSet.class, 340, 11991, 12002))) {
                            if (CallChecker.beforeDeref(chain, ComparatorChain.class, 342, 12158, 12162)) {
                                if ((null == (comparatorChain)) || (CallChecker.beforeDeref(comparatorChain, List.class, 342, 12135, 12149))) {
                                    chain = CallChecker.beforeCalled(chain, ComparatorChain.class, 340, 11970, 11974);
                                    chain = CallChecker.beforeCalled(chain, ComparatorChain.class, 341, 12032, 12036);
                                    orderingBits = CallChecker.beforeCalled(orderingBits, BitSet.class, 340, 11991, 12002);
                                    chain = CallChecker.beforeCalled(chain, ComparatorChain.class, 341, 12091, 12095);
                                    chain = CallChecker.beforeCalled(chain, ComparatorChain.class, 342, 12158, 12162);
                                    comparatorChain = CallChecker.beforeCalled(comparatorChain, List.class, 342, 12135, 12149);
                                    return ((null == (orderingBits)) ? null == (CallChecker.isCalled(chain, ComparatorChain.class, 340, 11970, 11974).orderingBits) : CallChecker.isCalled(orderingBits, BitSet.class, 340, 11991, 12002).equals(CallChecker.isCalled(chain, ComparatorChain.class, 341, 12032, 12036).orderingBits)) && ((null == (comparatorChain)) ? null == (CallChecker.isCalled(chain, ComparatorChain.class, 341, 12091, 12095).comparatorChain) : CallChecker.isCalled(comparatorChain, List.class, 342, 12135, 12149).equals(CallChecker.isCalled(chain, ComparatorChain.class, 342, 12158, 12162).comparatorChain));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2579.methodEnd();
        }
    }
}

