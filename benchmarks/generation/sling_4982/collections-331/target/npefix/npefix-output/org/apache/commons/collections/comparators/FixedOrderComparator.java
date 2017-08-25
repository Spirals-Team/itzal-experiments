package org.apache.commons.collections.comparators;

import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class FixedOrderComparator<T> implements Comparator<T> {
    public static enum UnknownObjectBehavior {
BEFORE, AFTER, EXCEPTION;    }

    private final Map<T, Integer> map = new HashMap<T, Integer>();

    private int counter = 0;

    private boolean isLocked = false;

    private FixedOrderComparator.UnknownObjectBehavior unknownObjectBehavior = FixedOrderComparator.UnknownObjectBehavior.EXCEPTION;

    public FixedOrderComparator() {
        super();
        MethodContext _bcornu_methode_context288 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context288.methodEnd();
        }
    }

    public FixedOrderComparator(T[] items) {
        super();
        MethodContext _bcornu_methode_context289 = new MethodContext(null);
        try {
            if (items == null) {
                throw new IllegalArgumentException("The list of items must not be null");
            }
            for (int i = 0; i < (items.length); i++) {
                add(items[i]);
            }
        } finally {
            _bcornu_methode_context289.methodEnd();
        }
    }

    public FixedOrderComparator(List<T> items) {
        super();
        MethodContext _bcornu_methode_context290 = new MethodContext(null);
        try {
            if (items == null) {
                throw new IllegalArgumentException("The list of items must not be null");
            }
            for (T t : items) {
                add(t);
            }
        } finally {
            _bcornu_methode_context290.methodEnd();
        }
    }

    public boolean isLocked() {
        MethodContext _bcornu_methode_context1529 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 4279, 4793);
            CallChecker.varInit(this.unknownObjectBehavior, "unknownObjectBehavior", 128, 4279, 4793);
            CallChecker.varInit(this.isLocked, "isLocked", 128, 4279, 4793);
            CallChecker.varInit(this.counter, "counter", 128, 4279, 4793);
            CallChecker.varInit(this.map, "map", 128, 4279, 4793);
            return isLocked;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1529.methodEnd();
        }
    }

    protected void checkLocked() {
        MethodContext _bcornu_methode_context1530 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 137, 4800, 5162);
            CallChecker.varInit(this.unknownObjectBehavior, "unknownObjectBehavior", 137, 4800, 5162);
            CallChecker.varInit(this.isLocked, "isLocked", 137, 4800, 5162);
            CallChecker.varInit(this.counter, "counter", 137, 4800, 5162);
            CallChecker.varInit(this.map, "map", 137, 4800, 5162);
            if (isLocked()) {
                throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1530.methodEnd();
        }
    }

    public FixedOrderComparator.UnknownObjectBehavior getUnknownObjectBehavior() {
        MethodContext _bcornu_methode_context1531 = new MethodContext(FixedOrderComparator.UnknownObjectBehavior.class);
        try {
            CallChecker.varInit(this, "this", 148, 5169, 5393);
            CallChecker.varInit(this.unknownObjectBehavior, "unknownObjectBehavior", 148, 5169, 5393);
            CallChecker.varInit(this.isLocked, "isLocked", 148, 5169, 5393);
            CallChecker.varInit(this.counter, "counter", 148, 5169, 5393);
            CallChecker.varInit(this.map, "map", 148, 5169, 5393);
            return unknownObjectBehavior;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FixedOrderComparator.UnknownObjectBehavior) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1531.methodEnd();
        }
    }

    public void setUnknownObjectBehavior(FixedOrderComparator.UnknownObjectBehavior unknownObjectBehavior) {
        MethodContext _bcornu_methode_context1532 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 160, 5400, 6084);
            CallChecker.varInit(unknownObjectBehavior, "unknownObjectBehavior", 160, 5400, 6084);
            CallChecker.varInit(this.unknownObjectBehavior, "unknownObjectBehavior", 160, 5400, 6084);
            CallChecker.varInit(this.isLocked, "isLocked", 160, 5400, 6084);
            CallChecker.varInit(this.counter, "counter", 160, 5400, 6084);
            CallChecker.varInit(this.map, "map", 160, 5400, 6084);
            checkLocked();
            if (unknownObjectBehavior == null) {
                throw new IllegalArgumentException("Unknown object behavior must not be null");
            }
            this.unknownObjectBehavior = unknownObjectBehavior;
            CallChecker.varAssign(this.unknownObjectBehavior, "this.unknownObjectBehavior", 165, 6028, 6078);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1532.methodEnd();
        }
    }

    public boolean add(T obj) {
        MethodContext _bcornu_methode_context1533 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 180, 6091, 6834);
            CallChecker.varInit(obj, "obj", 180, 6091, 6834);
            CallChecker.varInit(this.unknownObjectBehavior, "unknownObjectBehavior", 180, 6091, 6834);
            CallChecker.varInit(this.isLocked, "isLocked", 180, 6091, 6834);
            CallChecker.varInit(this.counter, "counter", 180, 6091, 6834);
            CallChecker.varInit(this.map, "map", 180, 6091, 6834);
            checkLocked();
            Integer position = CallChecker.init(Integer.class);
            if (CallChecker.beforeDeref(map, Map.class, 182, 6757, 6759)) {
                position = CallChecker.isCalled(map, Map.class, 182, 6757, 6759).put(obj, new Integer(((counter)++)));
                CallChecker.varAssign(position, "position", 182, 6757, 6759);
            }
            return position == null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1533.methodEnd();
        }
    }

    public boolean addAsEqual(T existingObj, T newObj) {
        MethodContext _bcornu_methode_context1534 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 199, 6841, 7786);
            CallChecker.varInit(newObj, "newObj", 199, 6841, 7786);
            CallChecker.varInit(existingObj, "existingObj", 199, 6841, 7786);
            CallChecker.varInit(this.unknownObjectBehavior, "unknownObjectBehavior", 199, 6841, 7786);
            CallChecker.varInit(this.isLocked, "isLocked", 199, 6841, 7786);
            CallChecker.varInit(this.counter, "counter", 199, 6841, 7786);
            CallChecker.varInit(this.map, "map", 199, 6841, 7786);
            checkLocked();
            Integer position = CallChecker.init(Integer.class);
            if (CallChecker.beforeDeref(map, Map.class, 201, 7546, 7548)) {
                position = CallChecker.isCalled(map, Map.class, 201, 7546, 7548).get(existingObj);
                CallChecker.varAssign(position, "position", 201, 7546, 7548);
            }
            if (position == null) {
                throw new IllegalArgumentException(((existingObj + " not known to ") + (this)));
            }
            Integer result = CallChecker.init(Integer.class);
            if (CallChecker.beforeDeref(map, Map.class, 205, 7722, 7724)) {
                result = CallChecker.isCalled(map, Map.class, 205, 7722, 7724).put(newObj, position);
                CallChecker.varAssign(result, "result", 205, 7722, 7724);
            }
            return result == null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1534.methodEnd();
        }
    }

    public int compare(T obj1, T obj2) {
        MethodContext _bcornu_methode_context1535 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 225, 7793, 9543);
            CallChecker.varInit(obj2, "obj2", 225, 7793, 9543);
            CallChecker.varInit(obj1, "obj1", 225, 7793, 9543);
            CallChecker.varInit(this.unknownObjectBehavior, "unknownObjectBehavior", 225, 7793, 9543);
            CallChecker.varInit(this.isLocked, "isLocked", 225, 7793, 9543);
            CallChecker.varInit(this.counter, "counter", 225, 7793, 9543);
            CallChecker.varInit(this.map, "map", 225, 7793, 9543);
            isLocked = true;
            CallChecker.varAssign(this.isLocked, "this.isLocked", 226, 8661, 8676);
            Integer position1 = CallChecker.init(Integer.class);
            if (CallChecker.beforeDeref(map, Map.class, 227, 8706, 8708)) {
                position1 = CallChecker.isCalled(map, Map.class, 227, 8706, 8708).get(obj1);
                CallChecker.varAssign(position1, "position1", 227, 8706, 8708);
            }
            Integer position2 = CallChecker.init(Integer.class);
            if (CallChecker.beforeDeref(map, Map.class, 228, 8749, 8751)) {
                position2 = CallChecker.isCalled(map, Map.class, 228, 8749, 8751).get(obj2);
                CallChecker.varAssign(position2, "position2", 228, 8749, 8751);
            }
            if ((position1 == null) || (position2 == null)) {
                switch (unknownObjectBehavior) {
                    case BEFORE :
                        if (position1 == null) {
                            return position2 == null ? 0 : -1;
                        }else {
                            return 1;
                        }
                    case AFTER :
                        if (position1 == null) {
                            return position2 == null ? 0 : 1;
                        }else {
                            return -1;
                        }
                    case EXCEPTION :
                        Object unknownObj = CallChecker.init(Object.class);
                        if (position1 == null) {
                            unknownObj = obj1;
                            CallChecker.varAssign(unknownObj, "unknownObj", 236, 9126, 9158);
                        }else {
                            unknownObj = obj2;
                            CallChecker.varAssign(unknownObj, "unknownObj", 236, 9126, 9158);
                        }
                        throw new IllegalArgumentException(("Attempting to compare unknown object " + unknownObj));
                    default :
                        throw new UnsupportedOperationException(("Unknown unknownObjectBehavior: " + (unknownObjectBehavior)));
                }
            }
            return position1.compareTo(position2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1535.methodEnd();
        }
    }
}

