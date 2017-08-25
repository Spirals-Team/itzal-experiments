package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

public class FixedElapsedTime implements StoppingCondition {
    private final long maxTimePeriod;

    private long endTime = -1;

    public FixedElapsedTime(final long maxTime) throws NumberIsTooSmallException {
        this(maxTime, TimeUnit.SECONDS);
        ConstructorContext _bcornu_methode_context744 = new ConstructorContext(FixedElapsedTime.class, 46, 1600, 1956);
        try {
        } finally {
            _bcornu_methode_context744.methodEnd();
        }
    }

    public FixedElapsedTime(final long maxTime, final TimeUnit unit) throws NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context745 = new ConstructorContext(FixedElapsedTime.class, 57, 1963, 2497);
        try {
            if (maxTime < 0) {
                throw new NumberIsTooSmallException(maxTime, 0, true);
            }
            maxTimePeriod = CallChecker.isCalled(unit, TimeUnit.class, 61, 2470, 2473).toNanos(maxTime);
            CallChecker.varAssign(this.maxTimePeriod, "this.maxTimePeriod", 61, 2454, 2491);
        } finally {
            _bcornu_methode_context745.methodEnd();
        }
    }

    public boolean isSatisfied(final Population population) {
        MethodContext _bcornu_methode_context3342 = new MethodContext(boolean.class, 71, 2504, 3004);
        try {
            CallChecker.varInit(this, "this", 71, 2504, 3004);
            CallChecker.varInit(population, "population", 71, 2504, 3004);
            CallChecker.varInit(this.endTime, "endTime", 71, 2504, 3004);
            CallChecker.varInit(this.maxTimePeriod, "maxTimePeriod", 71, 2504, 3004);
            if ((endTime) < 0) {
                endTime = (System.nanoTime()) + (maxTimePeriod);
                CallChecker.varAssign(this.endTime, "this.endTime", 73, 2899, 2942);
            }
            return (System.nanoTime()) >= (endTime);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3342.methodEnd();
        }
    }
}

