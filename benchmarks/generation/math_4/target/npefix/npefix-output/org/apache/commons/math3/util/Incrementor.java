package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;

public class Incrementor {
    public interface MaxCountExceededCallback {
        void trigger(int maximalCount) throws MaxCountExceededException;
    }

    private int maximalCount;

    private int count = 0;

    private final Incrementor.MaxCountExceededCallback maxCountCallback;

    public Incrementor() {
        this(0);
        ConstructorContext _bcornu_methode_context1005 = new ConstructorContext(Incrementor.class, 52, 1663, 1888);
        try {
        } finally {
            _bcornu_methode_context1005.methodEnd();
        }
    }

    public Incrementor(int max) {
        this(max, new Incrementor.MaxCountExceededCallback() {
            public void trigger(int max) throws MaxCountExceededException {
                MethodContext _bcornu_methode_context4472 = new MethodContext(void.class, 65, 2094, 2276);
                try {
                    CallChecker.varInit(this, "this", 65, 2094, 2276);
                    CallChecker.varInit(max, "max", 65, 2094, 2276);
                    throw new MaxCountExceededException(max);
                } catch (ForceReturn _bcornu_return_t) {
                    _bcornu_return_t.getDecision().getValue();
                    return ;
                } finally {
                    _bcornu_methode_context4472.methodEnd();
                }
            }
        });
        ConstructorContext _bcornu_methode_context1006 = new ConstructorContext(Incrementor.class, 61, 1895, 2299);
        try {
        } finally {
            _bcornu_methode_context1006.methodEnd();
        }
    }

    public Incrementor(int max, Incrementor.MaxCountExceededCallback cb) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context1007 = new ConstructorContext(Incrementor.class, 79, 2306, 2849);
        try {
            if (cb == null) {
                throw new NullArgumentException();
            }
            maximalCount = max;
            CallChecker.varAssign(this.maximalCount, "this.maximalCount", 84, 2794, 2812);
            maxCountCallback = cb;
            CallChecker.varAssign(this.maxCountCallback, "this.maxCountCallback", 85, 2822, 2843);
        } finally {
            _bcornu_methode_context1007.methodEnd();
        }
    }

    public void setMaximalCount(int max) {
        MethodContext _bcornu_methode_context4473 = new MethodContext(void.class, 95, 2856, 3144);
        try {
            CallChecker.varInit(this, "this", 95, 2856, 3144);
            CallChecker.varInit(max, "max", 95, 2856, 3144);
            CallChecker.varInit(this.maxCountCallback, "maxCountCallback", 95, 2856, 3144);
            CallChecker.varInit(this.count, "count", 95, 2856, 3144);
            CallChecker.varInit(this.maximalCount, "maximalCount", 95, 2856, 3144);
            maximalCount = max;
            CallChecker.varAssign(this.maximalCount, "this.maximalCount", 96, 3120, 3138);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4473.methodEnd();
        }
    }

    public int getMaximalCount() {
        MethodContext _bcornu_methode_context4474 = new MethodContext(int.class, 104, 3151, 3322);
        try {
            CallChecker.varInit(this, "this", 104, 3151, 3322);
            CallChecker.varInit(this.maxCountCallback, "maxCountCallback", 104, 3151, 3322);
            CallChecker.varInit(this.count, "count", 104, 3151, 3322);
            CallChecker.varInit(this.maximalCount, "maximalCount", 104, 3151, 3322);
            return maximalCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4474.methodEnd();
        }
    }

    public int getCount() {
        MethodContext _bcornu_methode_context4475 = new MethodContext(int.class, 113, 3329, 3467);
        try {
            CallChecker.varInit(this, "this", 113, 3329, 3467);
            CallChecker.varInit(this.maxCountCallback, "maxCountCallback", 113, 3329, 3467);
            CallChecker.varInit(this.count, "count", 113, 3329, 3467);
            CallChecker.varInit(this.maximalCount, "maximalCount", 113, 3329, 3467);
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4475.methodEnd();
        }
    }

    public boolean canIncrement() {
        MethodContext _bcornu_methode_context4476 = new MethodContext(boolean.class, 124, 3474, 3804);
        try {
            CallChecker.varInit(this, "this", 124, 3474, 3804);
            CallChecker.varInit(this.maxCountCallback, "maxCountCallback", 124, 3474, 3804);
            CallChecker.varInit(this.count, "count", 124, 3474, 3804);
            CallChecker.varInit(this.maximalCount, "maximalCount", 124, 3474, 3804);
            return (count) < (maximalCount);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4476.methodEnd();
        }
    }

    public void incrementCount(int value) throws MaxCountExceededException {
        MethodContext _bcornu_methode_context4477 = new MethodContext(void.class, 135, 3811, 4207);
        try {
            CallChecker.varInit(this, "this", 135, 3811, 4207);
            CallChecker.varInit(value, "value", 135, 3811, 4207);
            CallChecker.varInit(this.maxCountCallback, "maxCountCallback", 135, 3811, 4207);
            CallChecker.varInit(this.count, "count", 135, 3811, 4207);
            CallChecker.varInit(this.maximalCount, "maximalCount", 135, 3811, 4207);
            for (int i = 0; i < value; i++) {
                incrementCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4477.methodEnd();
        }
    }

    public void incrementCount() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context4478 = new MethodContext(void.class, 154, 4214, 4974);
        try {
            CallChecker.varInit(this, "this", 154, 4214, 4974);
            CallChecker.varInit(this.maxCountCallback, "maxCountCallback", 154, 4214, 4974);
            CallChecker.varInit(this.count, "count", 154, 4214, 4974);
            CallChecker.varInit(this.maximalCount, "maximalCount", 154, 4214, 4974);
            if ((++(count)) > (maximalCount)) {
                if (CallChecker.beforeDeref(maxCountCallback, Incrementor.MaxCountExceededCallback.class, 156, 4920, 4935)) {
                    CallChecker.isCalled(maxCountCallback, Incrementor.MaxCountExceededCallback.class, 156, 4920, 4935).trigger(maximalCount);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4478.methodEnd();
        }
    }

    public void resetCount() {
        MethodContext _bcornu_methode_context4479 = new MethodContext(void.class, 163, 4981, 5079);
        try {
            CallChecker.varInit(this, "this", 163, 4981, 5079);
            CallChecker.varInit(this.maxCountCallback, "maxCountCallback", 163, 4981, 5079);
            CallChecker.varInit(this.count, "count", 163, 4981, 5079);
            CallChecker.varInit(this.maximalCount, "maximalCount", 163, 4981, 5079);
            count = 0;
            CallChecker.varAssign(this.count, "this.count", 164, 5064, 5073);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4479.methodEnd();
        }
    }
}

