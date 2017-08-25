package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import static org.apache.commons.math3.util.MathArrays.OrderDirection.INCREASING;

public class NonMonotonicSequenceException extends MathIllegalNumberException {
    private static final long serialVersionUID = 3596849179428944575L;

    private final MathArrays.OrderDirection direction;

    private final boolean strict;

    private final int index;

    private final Number previous;

    public NonMonotonicSequenceException(Number wrong, Number previous, int index) {
        this(wrong, previous, index, INCREASING, true);
        ConstructorContext _bcornu_methode_context149 = new ConstructorContext(NonMonotonicSequenceException.class, 58, 1773, 2387);
        try {
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public NonMonotonicSequenceException(Number wrong, Number previous, int index, MathArrays.OrderDirection direction, boolean strict) {
        super((direction == (INCREASING) ? strict ? LocalizedFormats.NOT_STRICTLY_INCREASING_SEQUENCE : LocalizedFormats.NOT_INCREASING_SEQUENCE : strict ? LocalizedFormats.NOT_STRICTLY_DECREASING_SEQUENCE : LocalizedFormats.NOT_DECREASING_SEQUENCE), wrong, previous, index, (index - 1));
        ConstructorContext _bcornu_methode_context150 = new ConstructorContext(NonMonotonicSequenceException.class, 75, 2394, 3718);
        try {
            this.direction = direction;
            CallChecker.varAssign(this.direction, "this.direction", 89, 3594, 3620);
            this.strict = strict;
            CallChecker.varAssign(this.strict, "this.strict", 90, 3630, 3650);
            this.index = index;
            CallChecker.varAssign(this.index, "this.index", 91, 3660, 3678);
            this.previous = previous;
            CallChecker.varAssign(this.previous, "this.previous", 92, 3688, 3712);
        } finally {
            _bcornu_methode_context150.methodEnd();
        }
    }

    public MathArrays.OrderDirection getDirection() {
        MethodContext _bcornu_methode_context536 = new MethodContext(MathArrays.OrderDirection.class, 98, 3725, 3858);
        try {
            CallChecker.varInit(this, "this", 98, 3725, 3858);
            CallChecker.varInit(this.previous, "previous", 98, 3725, 3858);
            CallChecker.varInit(this.index, "index", 98, 3725, 3858);
            CallChecker.varInit(this.strict, "strict", 98, 3725, 3858);
            CallChecker.varInit(this.direction, "direction", 98, 3725, 3858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NonMonotonicSequenceException.serialVersionUID", 98, 3725, 3858);
            return direction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MathArrays.OrderDirection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context536.methodEnd();
        }
    }

    public boolean getStrict() {
        MethodContext _bcornu_methode_context537 = new MethodContext(boolean.class, 104, 3864, 4011);
        try {
            CallChecker.varInit(this, "this", 104, 3864, 4011);
            CallChecker.varInit(this.previous, "previous", 104, 3864, 4011);
            CallChecker.varInit(this.index, "index", 104, 3864, 4011);
            CallChecker.varInit(this.strict, "strict", 104, 3864, 4011);
            CallChecker.varInit(this.direction, "direction", 104, 3864, 4011);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NonMonotonicSequenceException.serialVersionUID", 104, 3864, 4011);
            return strict;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context537.methodEnd();
        }
    }

    public int getIndex() {
        MethodContext _bcornu_methode_context538 = new MethodContext(int.class, 112, 4017, 4165);
        try {
            CallChecker.varInit(this, "this", 112, 4017, 4165);
            CallChecker.varInit(this.previous, "previous", 112, 4017, 4165);
            CallChecker.varInit(this.index, "index", 112, 4017, 4165);
            CallChecker.varInit(this.strict, "strict", 112, 4017, 4165);
            CallChecker.varInit(this.direction, "direction", 112, 4017, 4165);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NonMonotonicSequenceException.serialVersionUID", 112, 4017, 4165);
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context538.methodEnd();
        }
    }

    public Number getPrevious() {
        MethodContext _bcornu_methode_context539 = new MethodContext(Number.class, 118, 4171, 4281);
        try {
            CallChecker.varInit(this, "this", 118, 4171, 4281);
            CallChecker.varInit(this.previous, "previous", 118, 4171, 4281);
            CallChecker.varInit(this.index, "index", 118, 4171, 4281);
            CallChecker.varInit(this.strict, "strict", 118, 4171, 4281);
            CallChecker.varInit(this.direction, "direction", 118, 4171, 4281);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NonMonotonicSequenceException.serialVersionUID", 118, 4171, 4281);
            return previous;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context539.methodEnd();
        }
    }
}

